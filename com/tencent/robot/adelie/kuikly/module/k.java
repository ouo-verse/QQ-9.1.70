package com.tencent.robot.adelie.kuikly.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseBizType;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.api.IPreDownloadVideoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J9\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0002J9\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000fH\u0016JI\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/k;", "Li01/e;", "", "params", "", "i", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "l", "g", "method", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "call", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k extends i01.e {
    private final void g(Object params, Function1<Object, Unit> callback) {
        Object[] objArr;
        boolean z16;
        byte[] bArr;
        if (params instanceof Object[]) {
            objArr = (Object[]) params;
        } else {
            objArr = null;
        }
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        for (Object obj : objArr) {
            if (obj instanceof byte[]) {
                bArr = (byte[]) obj;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                arrayList.add(bArr);
            }
        }
        AdelieUtils.f365929a.y(arrayList, callback);
    }

    private final void i(String params) {
        boolean z16;
        String str;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final String optString = jSONObject.optString("uid", "");
        final long optLong = jSONObject.optLong("uin", 0L);
        final String optString2 = jSONObject.optString("nick", "");
        final String dayUrl = jSONObject.optString("dayUrl", "");
        final String nightUrl = jSONObject.optString("nightUrl", "");
        if (je0.a.a(BaseApplication.getContext())) {
            Intrinsics.checkNotNullExpressionValue(dayUrl, "dayUrl");
            str = dayUrl;
        } else {
            Intrinsics.checkNotNullExpressionValue(nightUrl, "nightUrl");
            str = nightUrl;
        }
        ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackgroundUrl(str, true);
        final String optString3 = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL, "");
        final String optString4 = jSONObject.optString("fullScreenBg", "");
        final int optInt = jSONObject.optInt("bizType", RobotBaseBizType.KNONE.ordinal());
        final String optString5 = jSONObject.optString("dayColor", "");
        final String optString6 = jSONObject.optString("nightColor", "");
        final String optString7 = jSONObject.optString("avatarDominantColor", "");
        final String optString8 = jSONObject.optString("dayDynamicPic", "");
        final String optString9 = jSONObject.optString("nightDynamicPic", "");
        final int optInt2 = jSONObject.optInt("supportHalfScreenSwitch", 0);
        final boolean optBoolean = jSONObject.optBoolean("isSupportTts", false);
        final int optInt3 = jSONObject.optInt("isSupportAutoTts", 0);
        final boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("babyq_play_video_9095", true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.j
            @Override // java.lang.Runnable
            public final void run() {
                k.j(optInt, optString, optLong, optString5, optString6, optString7, dayUrl, nightUrl, optString8, optString9, optInt2, optBoolean, optInt3, isSwitchOn, optString3, optString4, optString2);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String uid, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i16, boolean z16, int i17, boolean z17, String videoUrl, String fullScreenBg, String nick) {
        if ((RobotBaseBizType.KADELIE.ordinal() == i3) && !TextUtils.isEmpty(uid) && j3 != 0) {
            IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class);
            String valueOf = String.valueOf(j3);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            iUixConvertAdapterApi.saveUidByUin(valueOf, uid);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_from", "27");
        bundle.putBoolean("key_ignore_pre_scale_chat", true);
        bundle.putString("key_day_color", str);
        bundle.putString("key_night_color", str2);
        bundle.putString("key_avatar_dominantColor", str3);
        bundle.putString("key_day_bg", str4);
        bundle.putString("key_night_bg", str5);
        bundle.putString("key_day_dynamic_bg", str6);
        bundle.putString("key_night_dynamic_bg", str7);
        bundle.putBoolean("key_support_half_screen", i16 != 0);
        bundle.putBoolean("key_support_tts", z16);
        bundle.putBoolean("key_support_auto_tts", i17 != 0);
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(videoUrl, "videoUrl");
            if (videoUrl.length() > 0) {
                Intrinsics.checkNotNullExpressionValue(fullScreenBg, "fullScreenBg");
                if (fullScreenBg.length() > 0) {
                    bundle.putBoolean("key_babyQ_need_show_video", true);
                    bundle.putString("key_babyQ_video_url", videoUrl);
                    bundle.putString("key_babyQ_image_url", fullScreenBg);
                }
            }
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        iAIOStarterApi.navigateToAIOActivity(context, 1, uid, nick, j3, bundle);
    }

    private final void l(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyHomePageModule", 1, "call preloadAIOGuideInfo params is null, return");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final String bgUrl = jSONObject.optString("bgUrl");
        final String videoUrl = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        Intrinsics.checkNotNullExpressionValue(videoUrl, "videoUrl");
        if (videoUrl.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.m(videoUrl);
                }
            }, 16, null, false);
        }
        Intrinsics.checkNotNullExpressionValue(bgUrl, "bgUrl");
        if (bgUrl.length() > 0) {
            z18 = true;
        }
        if (z18) {
            Option option = Option.obtain().setUrl(bgUrl);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.kuikly.module.i
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option2) {
                    k.o(bgUrl, callback, loadState, option2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String videoUrl) {
        IPreDownloadVideoApi iPreDownloadVideoApi = (IPreDownloadVideoApi) QRoute.api(IPreDownloadVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(videoUrl, "videoUrl");
        iPreDownloadVideoApi.preVideoDownload(videoUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str, Function1 function1, LoadState loadState, Option option) {
        QLog.i("AdelieKuiklyHomePageModule", 1, "loadImage onStateChange: " + loadState + ", url=" + str);
        if (loadState == LoadState.STATE_SUCCESS) {
            AIOUtil.f366629a.g(option.getResultBitMap());
            r.e(function1, null, 1, null);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "openAIOByRobotInfo")) {
            i(params);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "preloadAIOGuideInfo")) {
            l(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "backFlowRobotCoreInfos")) {
            return super.call(method, params, callback);
        }
        g(params, callback);
        return Unit.INSTANCE;
    }
}
