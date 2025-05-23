package com.tencent.guild.api.ark.impl;

import android.util.DisplayMetrics;
import com.tencent.ark.ark;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.b;
import com.tencent.mobileqq.ark.base.DefaultApplicationCallback;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.PlatformInfor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import qr0.g;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/api/ark/impl/GuildArkApiImpl;", "Lcom/tencent/guild/api/ark/IGuildArkApi;", "()V", "canReply", "", "appName", "", QQCustomArkDialogUtil.APP_VIEW, ark.APP_SPECIFIC_BIZSRC, "getAioConfigMaxHeight", "", "getApplicationCallback", "Lcom/tencent/ark/ark$ApplicationCallback;", "getCurrentAppConfig", "getMaxWidth", "getPlayerStubFactory", "Lcom/tencent/ark/ark$PlayerStubFactory;", "isEngineDisableHardwareRendering", "isOptimizeEnable", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildArkApiImpl implements IGuildArkApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112485a;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.FOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f112485a = iArr;
        }
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    public boolean canReply(@Nullable String appName, @Nullable String appView, @Nullable String bizSrc) {
        return ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).canReply(appName, appView, bizSrc);
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    public int getAioConfigMaxHeight() {
        return ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig().c().a();
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    @NotNull
    public ark.ApplicationCallback getApplicationCallback() {
        return new DefaultApplicationCallback();
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    @NotNull
    public String getCurrentAppConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (SimpleUIUtil.getSimpleUISwitch()) {
                jSONObject2.put("mode", PlatformInfor.SIMPLE_MODE);
            } else {
                jSONObject2.put("mode", "default");
            }
            jSONObject2.put("themeId", g.f429342a.a());
            jSONObject.put("theme", jSONObject2);
        } catch (JSONException e16) {
            QLog.e("GuildArkApiImpl", 1, "Exception=", e16);
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "cfgJson.toString()");
        return jSONObject3;
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    public int getMaxWidth() {
        int min;
        int a16;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        DeviceType a17 = PadUtil.a(context);
        Intrinsics.checkNotNullExpressionValue(a17, "getDeviceType(context)");
        int i3 = a.f112485a[a17.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                min = ViewUtils.getScreenWidth();
                a16 = x.a(96.0f);
            } else {
                min = ViewUtils.getScreenWidth();
                if (e.a() == SplitViewState.STATE_FLAT) {
                    min = (int) (min * e.g());
                }
                a16 = x.a(96.0f);
            }
        } else {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (e.a() == SplitViewState.STATE_FLAT) {
                min = (int) (min * e.g());
            }
            a16 = x.a(96.0f);
        }
        return min - a16;
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    @NotNull
    public ark.PlayerStubFactory getPlayerStubFactory() {
        ark.PlayerStubFactory sFactory = ArkMediaPlayer.F;
        Intrinsics.checkNotNullExpressionValue(sFactory, "sFactory");
        return sFactory;
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    public boolean isEngineDisableHardwareRendering() {
        return b.f199160b;
    }

    @Override // com.tencent.guild.api.ark.IGuildArkApi
    public boolean isOptimizeEnable() {
        return ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig().c().f();
    }
}
