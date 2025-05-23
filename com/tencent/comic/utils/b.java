package com.tencent.comic.utils;

import android.content.Context;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends Observable {
    public void a(Context context) {
        setChanged();
        notifyObservers(context);
    }
}
