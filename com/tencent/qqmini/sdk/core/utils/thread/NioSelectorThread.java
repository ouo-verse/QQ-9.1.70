package com.tencent.qqmini.sdk.core.utils.thread;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NioSelectorThread {
    private static NioSelectorThread INSTANCE;
    private volatile boolean registerSpin = false;
    private final Selector selector = Selector.open();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface NioHandler {
        boolean handle(SelectionKey selectionKey);
    }

    NioSelectorThread() throws IOException {
        new BaseThread(new Runnable() { // from class: com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.1
            @Override // java.lang.Runnable
            public void run() {
                NioSelectorThread.this.loopSelect();
            }
        }, "NioThread").start();
    }

    public static NioSelectorThread getInstance() throws IOException {
        synchronized (NioSelectorThread.class) {
            if (INSTANCE == null) {
                INSTANCE = new NioSelectorThread();
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loopSelect() {
        while (this.selector.isOpen()) {
            try {
                this.selector.select();
                Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    if (((NioHandler) next.attachment()).handle(next)) {
                        it.remove();
                    }
                }
            } catch (IOException unused) {
            }
            do {
            } while (this.registerSpin);
        }
    }

    public void registerChannel(SelectableChannel selectableChannel, int i3, NioHandler nioHandler) throws ClosedChannelException {
        try {
            this.registerSpin = true;
            this.selector.wakeup();
            selectableChannel.register(this.selector, i3, nioHandler);
        } finally {
            this.registerSpin = false;
        }
    }
}
