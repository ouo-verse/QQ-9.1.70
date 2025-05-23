package com.tencent.tbs.one;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TBSOneComponent {
    ClassLoader getEntryClassLoader();

    Object getEntryObject();

    File getInstallationDirectory();

    String getName();

    Context getResourcesContext();

    int getVersionCode();

    String getVersionName();
}
