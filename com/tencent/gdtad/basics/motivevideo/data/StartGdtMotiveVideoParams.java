package com.tencent.gdtad.basics.motivevideo.data;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class StartGdtMotiveVideoParams {
    public Activity activity;
    public GdtMotiveVideoPageData data;
    public ResultReceiver resultReceiver;
    public GdtMotiveVideoPageData secondVideoData;
    public GdtMotiveVideoPageData thirdVideoData;
    public boolean processInTool = false;

    @NonNull
    public Bundle bundle = new Bundle();
    public int requestCode = 101;

    @NonNull
    public static StartGdtMotiveVideoParams build(Activity activity, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
        startGdtMotiveVideoParams.activity = activity;
        startGdtMotiveVideoParams.data = gdtMotiveVideoPageData;
        return startGdtMotiveVideoParams;
    }

    @NonNull
    public static StartGdtMotiveVideoParams buildForJsBridge(Activity activity, GdtMotiveVideoPageData gdtMotiveVideoPageData, ResultReceiver resultReceiver) {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
        startGdtMotiveVideoParams.activity = activity;
        startGdtMotiveVideoParams.data = gdtMotiveVideoPageData;
        startGdtMotiveVideoParams.resultReceiver = resultReceiver;
        startGdtMotiveVideoParams.processInTool = true;
        return startGdtMotiveVideoParams;
    }

    @NonNull
    public static StartGdtMotiveVideoParams buildWithRequestCode(Activity activity, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3) {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
        startGdtMotiveVideoParams.activity = activity;
        startGdtMotiveVideoParams.data = gdtMotiveVideoPageData;
        startGdtMotiveVideoParams.requestCode = i3;
        return startGdtMotiveVideoParams;
    }

    @NonNull
    public static StartGdtMotiveVideoParams build(Activity activity, GdtMotiveVideoPageData gdtMotiveVideoPageData, ResultReceiver resultReceiver) {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
        startGdtMotiveVideoParams.activity = activity;
        startGdtMotiveVideoParams.data = gdtMotiveVideoPageData;
        startGdtMotiveVideoParams.resultReceiver = resultReceiver;
        return startGdtMotiveVideoParams;
    }

    @NonNull
    public static StartGdtMotiveVideoParams build(Activity activity, GdtMotiveVideoPageData gdtMotiveVideoPageData, String str) {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
        startGdtMotiveVideoParams.activity = activity;
        startGdtMotiveVideoParams.data = gdtMotiveVideoPageData;
        startGdtMotiveVideoParams.bundle.putString("arg_callback", str);
        return startGdtMotiveVideoParams;
    }
}
