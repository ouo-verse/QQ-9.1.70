package com.qq.e.comm.plugin.tangramsplash.interactive;

import android.os.Handler;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private a f40265a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract void a(boolean z16);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f40265a;
        if (aVar != null) {
            aVar.a(true);
        }
    }
}
