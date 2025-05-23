package com.tencent.mobileqq.sharehelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShareActionHelper extends QRouteApi {
    void doSharTextToWeChat(String str, int i3, Activity activity, String str2, String str3);

    void doShareArkBySelect(String str, Activity activity, a aVar);

    void doShareArkDirectly(String str, Activity activity, a aVar, int i3, String str2);

    void doShareImageToQQBySelect(String str, Activity activity, ImageShareInfo imageShareInfo);

    void doShareImageToQQDirectly(String str, Activity activity, ImageShareInfo imageShareInfo, int i3, String str2);

    void doShareLinkToWeChat(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6);

    void doShareLinkToWeChat(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6, Runnable runnable);

    void doSharePicToWX(String str, Activity activity, String str2, String str3, int i3);

    void doShareTextBySelect(String str, Activity activity, String str2);

    void doShareTextDirectly(String str, Activity activity, String str2, int i3, String str3);

    void doShareToQZoneWithLink(String str, Context context, d dVar);

    void doShareToQZoneWithPics(String str, Context context, ArrayList<String> arrayList, int i3);

    void shareQQMiniProgramToWX(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6, String str7, String str8);

    void shareQQMiniProgramToWX(String str, String str2, Bitmap bitmap, String str3, String str4, String str5);

    void shareTargetMiniProgramToWX(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, String str6);
}
