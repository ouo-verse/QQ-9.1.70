package com.tencent.mobileqq.injector;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.inject.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.robot.aio.tts.api.IRobotTtsApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J,\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/injector/f;", "Lcom/tencent/mobileqq/inject/f;", "Landroid/content/Context;", "context", "", "libName", "", "version", "", "includePrivateLib", "loadNativeLibrary", "b", "enableTalkBack", "isDebugVersion", "getAppId", "getSubVersion", "a", "robotUin", "Lcom/tencent/mobileqq/inject/f$a;", "voiceTypeListener", "", "c", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f implements com.tencent.mobileqq.inject.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/injector/f$a;", "", "", "TTS_REPORT_SWITCH_CONFIG_ID", "Ljava/lang/String;", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.injector.f$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f.a aVar, String str, int i3, String str2, GroupRobotProfile groupRobotProfile) {
        RobotTTSList robotTTSList;
        IRobotTtsApi iRobotTtsApi = (IRobotTtsApi) QRoute.api(IRobotTtsApi.class);
        if (groupRobotProfile != null) {
            robotTTSList = groupRobotProfile.ttsList;
        } else {
            robotTTSList = null;
        }
        aVar.a(iRobotTtsApi.calculateCurrentTtsId(str, robotTTSList));
    }

    @Override // com.tencent.mobileqq.inject.f
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return AppSetting.m();
    }

    @Override // com.tencent.mobileqq.inject.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return AppSetting.P;
    }

    @Override // com.tencent.mobileqq.inject.f
    public void c(@Nullable final String robotUin, @Nullable final f.a voiceTypeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) robotUin, (Object) voiceTypeListener);
            return;
        }
        if (robotUin != null && voiceTypeListener != null) {
            ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(robotUin, null, new IGetGroupRobotProfileCallback() { // from class: com.tencent.mobileqq.injector.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                    f.e(f.a.this, robotUin, i3, str, groupRobotProfile);
                }
            });
        } else if (voiceTypeListener != null) {
            voiceTypeListener.a("");
        }
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean enableTalkBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return AppSetting.f99565y;
    }

    @Override // com.tencent.mobileqq.inject.f
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.mobileqq.inject.f
    @NotNull
    public String getSubVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        return subVersion;
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean loadNativeLibrary(@Nullable Context context, @Nullable String libName, int version, boolean includePrivateLib) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, libName, Integer.valueOf(version), Boolean.valueOf(includePrivateLib))).booleanValue();
        }
        return SoLoadUtil.m(context, libName, version, includePrivateLib);
    }
}
