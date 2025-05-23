package com.tencent.gdtad.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.IGdtMotiveAPI;
import com.tencent.gdtad.basics.motivevideo.hippy.i;
import com.tencent.gdtad.jsbridge.GdtOpenMotiveAdHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import uz2.VasRewardAdReportParams;

/* loaded from: classes6.dex */
public final class GdtMotiveAPIImpl implements IGdtMotiveAPI {
    public static final String TAG = "GdtMotiveAPIImpl";

    /* loaded from: classes6.dex */
    class a implements tz2.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GdtOpenMotiveAdHandler f109208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f109209b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f109210c;

        a(GdtOpenMotiveAdHandler gdtOpenMotiveAdHandler, String str, boolean z16) {
            this.f109208a = gdtOpenMotiveAdHandler;
            this.f109209b = str;
            this.f109210c = z16;
        }

        @Override // tz2.b
        public void a(@NonNull VasAdvServiceCode vasAdvServiceCode, int i3, @NonNull String str, @Nullable byte[] bArr) {
            boolean z16;
            String str2;
            GdtOpenMotiveAdHandler gdtOpenMotiveAdHandler = this.f109208a;
            String str3 = this.f109209b;
            if (vasAdvServiceCode == VasAdvServiceCode.SUCCEED) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            boolean z18 = this.f109210c;
            if (bArr == null) {
                str2 = "";
            } else {
                str2 = new String(bArr, StandardCharsets.UTF_8);
            }
            gdtOpenMotiveAdHandler.f(str3, i3, z17, z18, str2);
        }
    }

    @Override // com.tencent.gdtad.IGdtMotiveAPI
    public String getJSBundleVersion() {
        return i.K();
    }

    @Override // com.tencent.gdtad.IGdtMotiveAPI
    public String getJsBundleInfo() {
        return i.L();
    }

    @Override // com.tencent.gdtad.IGdtMotiveAPI
    public void preDownload() {
        nm0.b.c().e();
    }

    @Override // com.tencent.gdtad.IGdtMotiveAPI
    public void registerIPCForHippy(Context context) {
        nm0.b.c().g(context);
    }

    @Override // com.tencent.gdtad.IGdtMotiveAPI
    public void scheduleH5ReportRewardAdNew(GdtOpenMotiveAdHandler gdtOpenMotiveAdHandler, Bundle bundle, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            boolean z16 = bundle.getBoolean("profitable", false);
            int i3 = bundle.getInt("elapsedTime", 0);
            String string = bundle.getString("arg_callback", "");
            if (TextUtils.isEmpty(string)) {
                GdtLog.e(TAG, "[onReceiveResult] callbackId is empty");
                return;
            }
            adv_report.RewardReportInfo rewardReportInfo = new adv_report.RewardReportInfo();
            rewardReportInfo.reward_type.set(jSONObject.optInt("reward_type", 0));
            rewardReportInfo.reward_item.set(ByteStringMicro.copyFromUtf8(jSONObject.optString("reward_item", "")));
            rewardReportInfo.time.set(jSONObject2.optLong("time", 0L));
            rewardReportInfo.nonce.set(jSONObject2.optInt("nonce", 0));
            rewardReportInfo.signature.set(jSONObject2.optString("signature", ""));
            VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
            c11382a.e(z16);
            c11382a.b(i3);
            c11382a.g(rewardReportInfo);
            ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).reportH5RewardAdNew(c11382a.a(), new a(gdtOpenMotiveAdHandler, string, z16));
            return;
        }
        GdtLog.e(TAG, "[scheduleJSReportRewardAd] reportInfo or rewardRspInfo is null");
    }
}
