package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.b;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import gx2.d;
import gx2.e;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pw2.n;
import pw2.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0017\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u001a\u0010#\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u001c\u0010)\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u001f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u00020!H\u0016J\b\u00105\u001a\u00020\u0003H\u0016J\u001a\u00109\u001a\u00020\u00032\u0006\u00106\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010<\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/QAdRewardFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "", "qh", "setFullScreen", ParseCommon.CONTAINER, "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "", "mHashKey", "sh", "(Ljava/lang/Integer;)V", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "rh", "onBackPressed", "we", "Lcom/tencent/ams/xsad/rewarded/RewardedAdError;", "errorInfo", "L7", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$ClickInfo;", "clickInfo", "Ab", "", "playedDuration", "jb", ICustomDataEditor.STRING_ARRAY_PARAM_5, "Lcom/tencent/ams/xsad/rewarded/view/a;", "dialog", "", "isExistClick", "gb", "S7", com.tencent.bugly.common.constants.Constants.BASE_IN_PLUGIN_VERSION, "p0", "Lorg/json/JSONObject;", "p1", "A1", "Lcom/tencent/ams/xsad/rewarded/b;", "reward", "yg", "onAdPlayStart", "onAdPlayPause", "onAdPlayResume", "onAdPlayComplete", "position", "Od", "isMute", "J1", RewardAdMethodHandler.RewardAdEvent.ON_ORIGINAL_EXPOSURE, "switchType", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$b;", "switchCallBack", "m6", "Lcom/tencent/ams/xsad/rewarded/event/ModuleEvent;", "event", "K6", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Integer;", "D", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$b;", "mSwitchCallBack", "E", "Landroidx/fragment/app/Fragment;", "fragmentContainer", "<init>", "()V", "G", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardFragment extends ReportAndroidXFragment implements RewardedAdListener {

    /* renamed from: C, reason: from kotlin metadata */
    private Integer mHashKey;

    /* renamed from: D, reason: from kotlin metadata */
    private RewardedAdListener.b mSwitchCallBack;

    /* renamed from: E, reason: from kotlin metadata */
    private Fragment fragmentContainer;
    private HashMap F;

    private final void qh() {
        Map mutableMapOf;
        Serializable refPg;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("eid", QAdVrReport.ElementID.AD_WATCH));
        linkedHashMap.put(QAdVrReportParams.ParamKey.REF_ELE, mutableMapOf);
        Bundle arguments = getArguments();
        if (arguments != null && (refPg = arguments.getSerializable("ref_pg")) != null) {
            Intrinsics.checkNotNullExpressionValue(refPg, "refPg");
            linkedHashMap.put("ref_pg", refPg);
        }
        w.o(getActivity(), linkedHashMap);
    }

    private final void setFullScreen() {
        FragmentActivity it = getActivity();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            rh(it);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void Ab(@Nullable RewardedAdListener.ClickInfo clickInfo) {
        n.e("[RewardAd]QAdRewardFragment", "onAdClicked");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.b(), clickInfo));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void J1(boolean isMute) {
        n.e("[RewardAd]QAdRewardFragment", "onUserSetMute, isMute " + isMute);
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.s(), Boolean.valueOf(isMute)));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void K6(@Nullable ModuleEvent event) {
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.h(), event));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void L7(@Nullable RewardedAdError errorInfo) {
        n.e("[RewardAd]QAdRewardFragment", "onAdShowFailed, error msg = " + errorInfo);
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.n(), errorInfo));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void Od(int position) {
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.q(), Integer.valueOf(position)));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void S7(@Nullable com.tencent.ams.xsad.rewarded.view.a dialog) {
        n.e("[RewardAd]QAdRewardFragment", "onAdCloseDialogClicked");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.f(), dialog));
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void a5() {
        n.e("[RewardAd]QAdRewardFragment", "onAdCloseClicked");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.d(), new Object[0]));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void gb(@Nullable com.tencent.ams.xsad.rewarded.view.a dialog, boolean isExistClick) {
        n.e("[RewardAd]QAdRewardFragment", "onAdCloseDialogClicked\uff0cunlock = " + isExistClick);
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.e(), dialog, Boolean.valueOf(isExistClick)));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void jb(long playedDuration) {
        n.e("[RewardAd]QAdRewardFragment", "onAdClosed");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.c(), Long.valueOf(playedDuration)));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void m6(int switchType, @Nullable RewardedAdListener.b switchCallBack) {
        this.mSwitchCallBack = switchCallBack;
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.p(), Integer.valueOf(switchType), this.mSwitchCallBack));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayComplete() {
        n.e("[RewardAd]QAdRewardFragment", "onAdPlayComplete");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.i(), new Object[0]));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayPause() {
        n.e("[RewardAd]QAdRewardFragment", "onAdPlayPause");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.j(), new Object[0]));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayResume() {
        n.e("[RewardAd]QAdRewardFragment", "onAdPlayResume");
        setFullScreen();
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.k(), new Object[0]));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayStart() {
        n.e("[RewardAd]QAdRewardFragment", "onAdPlayStart");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.l(), new Object[0]));
    }

    public final void onBackPressed() {
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.t(), new Object[0]));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        n.e("[RewardAd]QAdRewardFragment", "onCreate");
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        FragmentActivity fragmentActivity = null;
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("param_ad_reward_param"));
        } else {
            num = null;
        }
        this.mHashKey = num;
        int v3 = e.INSTANCE.v();
        Object[] objArr = new Object[2];
        Fragment fragment = this.fragmentContainer;
        if (fragment != null) {
            fragmentActivity = fragment.getActivity();
        }
        objArr[0] = fragmentActivity;
        objArr[1] = this;
        d.f403713b.a(this.mHashKey, new e(v3, objArr));
        qh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.a(), new Object[0]));
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onOriginalExposure() {
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.u(), new Object[0]));
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setFullScreen();
    }

    public final void ph(@NotNull Fragment container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.fragmentContainer = container;
    }

    public final void rh(@NotNull FragmentActivity activity) {
        View decorView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView ?: return");
            decorView.setSystemUiVisibility(3846);
        }
    }

    public final void sh(@Nullable Integer mHashKey) {
        n.e("[RewardAd]QAdRewardFragment", "updateRewardAdData,prevHashKey = " + this.mHashKey + "newHashKey = " + mHashKey);
        this.mHashKey = mHashKey;
        d.f403713b.a(mHashKey, new e(e.INSTANCE.m(), this.mSwitchCallBack));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void we() {
        n.e("[RewardAd]QAdRewardFragment", "onAdShowed");
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.o(), new Object[0]));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void yg(@Nullable b reward) {
        n.e("[RewardAd]QAdRewardFragment", RewardAdMethodHandler.RewardAdEvent.ON_USER_EARNED_REWARD);
        d.f403713b.a(this.mHashKey, new e(e.INSTANCE.r(), reward));
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void D2() {
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void A1(@Nullable com.tencent.ams.xsad.rewarded.view.a p06, @Nullable JSONObject p16) {
    }
}
