package com.tencent.tbs.reader.tool;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ITbsReaderEntry;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.util.HashMap;
import re4.b;
import se4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsToolEntrance {
    private static final String TAG = "TbsToolEntrance";
    private static final HashMap<String, String> extToPlugin;
    private static volatile TbsToolEntrance instance;
    private static final HashMap<String, Integer> pluginToVersion;
    private static ITbsToolHost toolHost;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        extToPlugin = hashMap;
        pluginToVersion = new HashMap<>();
        hashMap.put(FileReaderHelper.DOC_EXT, "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.DOCX_EXT, "com.tencent.qb.plugin.office");
        hashMap.put("rtf", "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.XLS_EXT, "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.XLSX_EXT, "com.tencent.qb.plugin.office");
        hashMap.put("csv", "com.tencent.qb.plugin.office");
        hashMap.put("xlsm", "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.PPT_EXT, "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.PPTX_EXT, "com.tencent.qb.plugin.office");
        hashMap.put(FileReaderHelper.PDF_EXT, "com.tencent.mtt.plugin.new_pdf");
    }

    TbsToolEntrance() {
    }

    public static TbsToolEntrance getInstance() {
        if (instance == null) {
            synchronized (TbsToolEntrance.class) {
                if (instance == null) {
                    instance = new TbsToolEntrance();
                }
            }
        }
        return instance;
    }

    public static int getPluginVersion(String str) {
        String str2 = extToPlugin.get(str);
        b.d(TAG, "[getPluginVersion]pkgName is " + str2);
        if (str2 == null) {
            return 0;
        }
        HashMap<String, Integer> hashMap = pluginToVersion;
        Integer num = hashMap.get(str2);
        if (num == null) {
            try {
                num = Integer.valueOf(Integer.parseInt(toolHost.queryStringValue(ITbsReader.SP_TBS_FILE, ITbsReader.KEY_INSTALLED_PLUGIN_VERSION_PREFIX + str2, "0")));
                hashMap.put(str2, num);
            } catch (NumberFormatException e16) {
                b.c(TAG, "[getPluginVersion]", e16);
                num = 0;
            }
        }
        return num.intValue();
    }

    public int callToolPage(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback, FrameLayout frameLayout) {
        return TbsFileInterfaceImpl.getInstance().openToolPage(context, bundle, iTbsReaderCallback, frameLayout);
    }

    @Nullable
    public ITbsToolHost getToolHost() {
        return toolHost;
    }

    public boolean isSupportCquatre(String str) {
        int queryIntValue = toolHost.queryIntValue(ITbsReader.SP_TBS_FILE, ITbsReader.KEY_FILE_COMPONENT_VERSION, 0);
        if (queryIntValue < 5070080) {
            b.d(TAG, "[isSupportCquatre] componentVersion too low:" + queryIntValue);
            return false;
        }
        String str2 = extToPlugin.get(str);
        b.d(TAG, "[isSupportCquatre]pkgName is " + str2);
        if (str2 == null) {
            return true;
        }
        toolHost.saveBoolKv(ITbsReader.SP_TBS_FILE, ITbsReader.KEY_IS_EXCEPT_CQUATRE, true);
        int pluginVersion = getPluginVersion(str);
        b.d(TAG, "[isSupportCquatre]pluginVersion=" + pluginVersion + ",ext=" + str);
        if (pluginVersion <= 0) {
            return false;
        }
        return true;
    }

    public boolean onJsCall(String str, String str2, ValueCallback<String> valueCallback) {
        ITbsReaderEntry readerEntry = ReaderEngine.getInstance().getReaderEntry();
        b.d(TAG, "onJsCall method:" + str + " param:" + str2 + " tbsReaderEntry:" + readerEntry);
        if (readerEntry == null) {
            b.b(TAG, "invalid JsCall tbs not init method:" + str + " param:" + str2 + " tbsReaderEntry:" + readerEntry);
            return false;
        }
        ReaderEngine.getInstance().getReaderEntry().doAction(str, str2, valueCallback);
        return true;
    }

    public boolean openQQBrowser(Context context, File file) {
        b.d(TAG, "openQQBrowser, srcFile: " + file);
        ITbsReaderEntry readerEntry = ReaderEngine.getInstance().getReaderEntry();
        if (readerEntry == null) {
            b.f(TAG, "openQQBrowser, tbsReaderEntry not init, srcFile: " + file);
            a.m(context, file, "QQ\u6d4f\u89c8\u5668\u652f\u6301\u4e0a\u767e\u79cd\u683c\u5f0f\u9884\u89c8\uff0c\u5e76\u63d0\u4f9b\u4e91\u76d8\u4fdd\u5b58\u3001\u683c\u5f0f\u8f6c\u6362\u3001\u6587\u4ef6\u89e3\u538b\u3001\u6587\u4ef6\u6e05\u7406\u7b49\u9ad8\u9636\u529f\u80fd\uff0c\u52a9\u60a8\u8f7b\u677e\u67e5\u770b\u5404\u79cd\u6587\u4ef6\uff01", "1100125236", "10361");
            return true;
        }
        readerEntry.openQQBrowser(context, file);
        return true;
    }

    public void setToolHost(ITbsToolHost iTbsToolHost) {
        toolHost = iTbsToolHost;
    }
}
