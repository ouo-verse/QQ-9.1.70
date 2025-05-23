package com.tencent.qqlive.module.videoreport.storage;

import android.content.Context;
import com.tencent.qqlive.module.videoreport.storage.database.DatabaseStorage;
import com.tencent.qqlive.module.videoreport.storage.preference.PreferenceStorage;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataStorageFactory {
    public static final int TYPE_DATABASE = 0;
    public static final int TYPE_SP = 1;

    DataStorageFactory() {
    }

    public static IDataStorage getInstance(Context context, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return PreferenceStorage.getInstance(context);
            }
            throw new IllegalArgumentException("Type " + i3 + " is not supported.");
        }
        return DatabaseStorage.getInstance(context);
    }
}
