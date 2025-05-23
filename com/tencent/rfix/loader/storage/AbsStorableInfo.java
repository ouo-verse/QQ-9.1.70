package com.tencent.rfix.loader.storage;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class AbsStorableInfo {
    protected final IRFixStorage storage;
    protected final boolean withFileLock;

    public AbsStorableInfo(Context context, String str) {
        this(context, str, true, false);
    }

    public void loadStoreInfo() {
        this.storage.load(this.withFileLock);
    }

    public void saveStoreInfo() {
        this.storage.save(this.withFileLock);
    }

    public AbsStorableInfo(Context context, String str, boolean z16) {
        this(context, str, z16, false);
    }

    public AbsStorableInfo(Context context, String str, boolean z16, boolean z17) {
        this.storage = RFixStorageFactory.getsStorageFactoryImpl().createRFixStorage(context, str);
        this.withFileLock = z17;
        if (z16) {
            loadStoreInfo();
        }
    }
}
