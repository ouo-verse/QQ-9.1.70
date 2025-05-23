package com.tencent.qcircle.weseevideo.editor.sticker.dispatcher;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerEventDispatcher {
    private static StickerEventDispatcher INSTANCE = new StickerEventDispatcher();
    private CopyOnWriteArrayList<IStickerEventListener> handlerList = new CopyOnWriteArrayList<>();

    StickerEventDispatcher() {
    }

    public static StickerEventDispatcher getInstance() {
        return INSTANCE;
    }

    public void addStickerEventListener(IStickerEventListener iStickerEventListener) {
        if (!this.handlerList.contains(iStickerEventListener)) {
            this.handlerList.add(iStickerEventListener);
        }
    }

    public void onStickerDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19) {
        Iterator<IStickerEventListener> it = this.handlerList.iterator();
        while (it.hasNext()) {
            it.next().onStickerDataChanged(tAVSticker, tAVStickerOperationMode, f16, f17, f18, f19);
        }
    }

    public void onStickerStatusChanged(TAVSticker tAVSticker, Boolean bool, Boolean bool2) {
        Iterator<IStickerEventListener> it = this.handlerList.iterator();
        while (it.hasNext()) {
            it.next().onStickerStatusChanged(tAVSticker, bool.booleanValue(), bool2.booleanValue());
        }
    }

    public void removeStickerEventListener(IStickerEventListener iStickerEventListener) {
        this.handlerList.remove(iStickerEventListener);
    }
}
