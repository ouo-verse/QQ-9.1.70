package com.tencent.mobileqq.richmediabrowser.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IBrowserManager extends QRouteApi {
    MainBrowserPresenter getPresenter();

    IBrowserManager launchRichMediaBrowser(Context context, Intent intent, f fVar, String str, List<RichMediaBrowserInfo> list, int i3);

    void notifyImageListChanged(AIOBrowserBaseData[] aIOBrowserBaseDataArr, int i3);

    void notifyImageProgress(long j3, int i3, int i16, int i17, long j16, boolean z16);

    void notifyImageResult(long j3, int i3, int i16, int i17, String str, boolean z16);

    void notifyVideoUrl(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle);
}
