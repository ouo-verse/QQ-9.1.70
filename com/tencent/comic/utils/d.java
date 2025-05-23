package com.tencent.comic.utils;

import java.util.Observable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends Observable {
    public void a() {
        setChanged();
        notifyObservers();
    }
}
