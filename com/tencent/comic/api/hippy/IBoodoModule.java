package com.tencent.comic.api.hippy;

import android.app.Activity;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IBoodoModule {
    void doPromiseCallback(Promise promise, int i3, String str);

    void doPromiseCallback(Promise promise, JSONObject jSONObject);

    void downloadComic(HippyMap hippyMap, Promise promise);

    Activity getCurrentActivity();

    void getDownloadList(HippyMap hippyMap, Promise promise);

    HippyEngine getHippyEngine();

    void getPageTrace(Promise promise);

    void getReportInfo(HippyMap hippyMap, Promise promise);

    void mainTabAppear(HippyMap hippyMap, Promise promise);

    void modifyDownloadStatus(HippyMap hippyMap, Promise promise);

    void notifyWebStatus(HippyMap hippyMap, Promise promise);

    void openComicIntro(HippyMap hippyMap, Promise promise);

    void openDownloadDetail(HippyMap hippyMap, Promise promise);

    void popPage();

    void pushPage(HippyMap hippyMap);

    void pushPageStack(HippyMap hippyMap, Promise promise);

    void queryDownloadProgress(HippyMap hippyMap, Promise promise);

    void report(HippyMap hippyMap, Promise promise);

    void reportDC01327(HippyMap hippyMap, Promise promise);

    void startRead(HippyMap hippyMap, Promise promise);
}
