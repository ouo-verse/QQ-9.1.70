package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vip.h;
import com.tencent.mobileqq.vip.k;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

/* compiled from: P */
@QAPI(process = {"all"})
@Deprecated
/* loaded from: classes20.dex */
public interface IVasDepTemp extends QRouteApi {
    void colorRingDownload(AppRuntime appRuntime, int i3, boolean z16, int i16, k kVar);

    String convert2SharpPFilePath(File file);

    void fetchHippyDTReportIndex(String str, AppRuntime appRuntime);

    Card findAndCreateCardByUin(String str);

    NTVasSimpleInfo findFriendEntityByUin(AppRuntime appRuntime, String str);

    h getDownloader(AppRuntime appRuntime);

    Intent getQQBrowserIntent();

    void guanjiaReport(String str, String str2, boolean z16, int i3, String str3);

    boolean isBelongServiceAccountFolderInner(String str);

    boolean isCanOpenGxhHippyPage();

    boolean isCanOpenHippyPage(String str);

    boolean isCanOpenQQVipHippyPage();

    boolean isContainsModule(String str);

    boolean isEnable();

    boolean isEnableGetAuth(String str, String str2);

    boolean isFunctionAvaliable(Context context);

    boolean isQQBrowserActivity(Activity activity);

    void openGxhHippyPage(String str);

    void openHippyPageWithConfig(String str, String str2);

    void openQQVipHippyPage(String str);

    void registerSeqKey(IJce iJce, String str);

    void reportKCLP(long j3, int i3);

    void requestPreDownload(File file, String str, int i3, String str2, int i16, int i17, RunnableTask runnableTask);

    void sendGetBaseVipInfoReq(String str, String str2);

    void sendSpecialCareEvent(List<String> list, int i3, List<String> list2, AppRuntime appRuntime);

    boolean setContentBackground(View view, int i3);

    boolean setContentBackground(View view, Drawable drawable);

    int specialSoundDownload(com.tencent.mobileqq.vip.g gVar);

    void startDownload(AppRuntime appRuntime, Bundle bundle, com.tencent.mobileqq.vip.g gVar, com.tencent.mobileqq.vip.f fVar);

    void startPhotoListEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, int i19);

    void unRegisterSeqKey(String str);

    void updateDisPlayInteval(long j3);

    void vipFuncallReport(String str, boolean z16, int i3, long j3);

    byte[] websoEncode(String str, long j3, HttpReq httpReq, String str2);

    HttpResponse websoExecuteHttpPost(Context context, String str, HttpEntity httpEntity) throws IOException;

    String websoGetAPN();

    String websoGetCookie4WebSoOrSonic(String str);

    String websoGetQUA();

    HttpRsp websoOnResponse(byte[] bArr, String str);
}
