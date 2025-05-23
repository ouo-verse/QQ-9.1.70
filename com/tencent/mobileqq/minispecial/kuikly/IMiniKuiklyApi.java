package com.tencent.mobileqq.minispecial.kuikly;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import g92.a;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniKuiklyApi extends QRouteApi {
    boolean checkAndParseMcKuiklyConfig(Object obj);

    Map<String, Object> getKuiklyPageData(QBaseActivity qBaseActivity);

    a getKuiklyUIProxy(Activity activity);

    QBaseFragment getMiniKuiklyBaseFragment(QBaseActivity qBaseActivity);

    Map<String, String> getShareParams();

    boolean isLaunchByMiniApp(Context context);

    boolean isMiniKuikly(@Nullable String str, @Nullable String str2);

    void openUrl(Context context, String str);

    void setShareParams(String str, String str2, String str3);
}
