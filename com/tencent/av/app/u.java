package com.tencent.av.app;

import java.util.Observable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u extends Observable {

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f73211a;

    public u(VideoAppInterface videoAppInterface) {
        this.f73211a = null;
        if (videoAppInterface != null) {
            this.f73211a = videoAppInterface;
        }
    }

    public synchronized void a(Object[] objArr) {
        super.setChanged();
        super.notifyObservers(objArr);
    }
}
