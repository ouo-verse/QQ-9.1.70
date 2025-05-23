package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001\u0012J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J.\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/loginregister/IFaceIdentificationEnablePrePageApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", "context", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/loginregister/IFaceIdentificationEnablePrePageApi$a;", "callback", "", "openEnablePrePage", "", "result", "", "openId", "tmpKey", "onVerifyFinish", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onCancelVerify", "a", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IFaceIdentificationEnablePrePageApi extends QRouteApi {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/loginregister/IFaceIdentificationEnablePrePageApi$a;", "", "Landroid/app/Activity;", "faceIdentificationAct", "", "openId", "tmpKey", "", "b", "a", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void a(@Nullable Activity faceIdentificationAct);

        void b(@Nullable Activity faceIdentificationAct, @Nullable String openId, @Nullable String tmpKey);
    }

    void onCancelVerify(@Nullable Activity activity);

    void onVerifyFinish(@Nullable Activity context, boolean result, @Nullable String openId, @Nullable String tmpKey);

    void openEnablePrePage(@Nullable Activity context, @Nullable Intent intent, @Nullable a callback);
}
