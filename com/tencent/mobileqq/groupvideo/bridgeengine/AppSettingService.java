package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/AppSettingService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IAppSettingService;", "()V", "originApi", "Lcom/tencent/mobileqq/config/api/IAppSettingApi;", "getOriginApi", "()Lcom/tencent/mobileqq/config/api/IAppSettingApi;", "originApi$delegate", "Lkotlin/Lazy;", "buildNum", "", "getAppId", "", "getPublishVersionString", "getReportVersionName", "getSubVersion", "getVersion", "isDebugVersion", "", "isGrayVersion", "isPublicVersion", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AppSettingService implements IAppSettingService {
    static IPatchRedirector $redirector_;

    /* renamed from: originApi$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy originApi;

    public AppSettingService() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AppSettingService$originApi$2.INSTANCE);
            this.originApi = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IAppSettingApi getOriginApi() {
        return (IAppSettingApi) this.originApi.getValue();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    @NotNull
    public String buildNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String buildNum = getOriginApi().buildNum();
        Intrinsics.checkNotNullExpressionValue(buildNum, "originApi.buildNum()");
        return buildNum;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return getOriginApi().getAppId();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    @NotNull
    public String getPublishVersionString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String publishVersionString = getOriginApi().getPublishVersionString();
        Intrinsics.checkNotNullExpressionValue(publishVersionString, "originApi.publishVersionString");
        return publishVersionString;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    @NotNull
    public String getReportVersionName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String reportVersionName = getOriginApi().getReportVersionName();
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "originApi.reportVersionName");
        return reportVersionName;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    @NotNull
    public String getSubVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String subVersion = getOriginApi().getSubVersion();
        Intrinsics.checkNotNullExpressionValue(subVersion, "originApi.subVersion");
        return subVersion;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    @NotNull
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String version = getOriginApi().getVersion();
        Intrinsics.checkNotNullExpressionValue(version, "originApi.version");
        return version;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return getOriginApi().isDebugVersion();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    public boolean isGrayVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return getOriginApi().isGrayVersion();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IAppSettingService
    public boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return getOriginApi().isPublicVersion();
    }
}
