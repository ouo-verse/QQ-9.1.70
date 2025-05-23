package com.tencent.mobileqq.qwallet;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletApi extends QRouteApi {
    void applyRotateAnimation(boolean z16, ViewGroup viewGroup, View view, View view2);

    void clearQWalletCache();

    long convertStringToTime(String str);

    String cutTextByPix(Context context, String str, float f16, TextPaint textPaint);

    View.OnTouchListener getAlphaChangeListener(float f16);

    String getEncodeUrl(String str);

    String getGuildNickName(AppRuntime appRuntime, String str, String str2);

    Intent getPayBridgeIntent(Context context);

    BaseQQAppInterface getQQAppInterface();

    long getQWalletCacheSize();

    QIPCModule getQWalletIPCModule();

    AbsDownloader getQWalletPicDownloader();

    String getQWalletTmpPath();

    void grapHbWithParam(AppInterface appInterface, String str, String str2, String str3, ResultReceiver resultReceiver);

    boolean isOnView(View view, float f16, float f17);

    boolean isQWalletAtTop(Context context);

    boolean jumpToHbDetail(Context context, Map<String, String> map);

    String md5Encode(String str);

    Object readObject(String str) throws Exception;

    void reportTenpay(int i3, String str);

    void reqReportHBGame(String str, long j3, String str2, int i3, boolean z16, boolean z17, int i16);

    void saveObject(Object obj, String str);

    void servletSendRequest(JceStruct jceStruct, BusinessObserver businessObserver);

    void setAlphaChangeListener(View view, float f16);

    void sortByFileNameNum(File[] fileArr);

    boolean unzipAtomically(String str, String str2);
}
