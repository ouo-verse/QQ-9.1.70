package com.tencent.tbs.reader;

import android.content.Context;
import java.io.File;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITbsReaderEntry {
    boolean canAutoUpdate();

    Object createTbsReader(Context context, Integer num, Object obj);

    void doAction(String str, Object obj, Object obj2);

    void initRuntimeEnvironment();

    void initSettings(Map map);

    boolean isSupportCurrentPlatform();

    boolean isSupportExt(int i3, String str);

    void openQQBrowser(Context context, File file);

    void setSdkVersionCode(int i3);

    void setSdkVersionName(String str);

    void setTBSFileComponentLoggingHandler(ITBSFileComponentLoggingHandler iTBSFileComponentLoggingHandler);
}
