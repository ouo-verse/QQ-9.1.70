package com.tencent.tbs.reader.tool;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITbsToolHost {
    Context getApplicationContext();

    String getAuthority();

    boolean isNightMode();

    void openFile(Bundle bundle, ValueCallback<Boolean> valueCallback);

    void openFileCenter(String str);

    void openWebPage(String str);

    boolean queryBoolValue(String str, String str2, boolean z16);

    int queryIntValue(String str, String str2, int i3);

    String queryStringValue(String str, String str2, String str3);

    void saveBoolKv(String str, String str2, boolean z16);

    void saveIntKv(String str, String str2, int i3);

    void saveStringKv(String str, String str2, String str3);

    void saveToFileCenter(Bundle bundle, ValueCallback<Bundle> valueCallback);

    void showTips(Map<String, Object> map, ValueCallback<Void> valueCallback);
}
