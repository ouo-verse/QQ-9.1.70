package com.tencent.rfix.loader.storage;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixStorageFactory implements IRFixStorageFactory {
    private static IRFixStorageFactory sStorageFactoryImpl = new RFixStorageFactory();

    public static IRFixStorageFactory getsStorageFactoryImpl() {
        return sStorageFactoryImpl;
    }

    public static void setStorageFactoryImpl(IRFixStorageFactory iRFixStorageFactory) {
        if (iRFixStorageFactory != null) {
            sStorageFactoryImpl = iRFixStorageFactory;
        }
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorageFactory
    public IRFixStorage createRFixStorage(Context context, String str) {
        return new PropertiesStorage(context, str);
    }
}
