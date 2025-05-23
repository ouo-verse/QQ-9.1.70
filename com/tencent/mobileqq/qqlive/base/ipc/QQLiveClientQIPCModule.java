package com.tencent.mobileqq.qqlive.base.ipc;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.api.profile.QQProfile;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart;
import com.tencent.mobileqq.qqlive.sail.model.RemotePlayerInfo;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.QQLiveExitRoomEvent;
import com.tencent.mobileqq.qqlive.sail.ui.like.QQLiveLikeEvent;
import com.tencent.mobileqq.qqlive.widget.floatwindow.g;
import com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer;
import com.tencent.mobileqq.qqlive.widget.player.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.message.i;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020\u000e\u00a2\u0006\u0004\b&\u0010'J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0017\u001a\u00020\u0006J&\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "callbackId", "", "l", "Leipc/EIPCResult;", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "k", "j", "", "p", "r", h.F, "i", "g", "code", "msg", "f", "registerModule", "action", "onCall", "uin", "Lcom/tencent/mobileqq/qqlive/api/profile/QQProfile;", "getQQProfile", "attaId", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData$Builder;", "builder", "qualityReport", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "d", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "logger", "moduleName", "<init>", "(Ljava/lang/String;)V", "e", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveClientQIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f271004f;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<QQLiveClientQIPCModule> f271005h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Leipc/EIPCResult;", "b", "Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "PROCESS_NAME", "Ljava/lang/String;", "TAG", "", "isRegisterModule", "Z", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, action, params, callback);
            } else {
                Intrinsics.checkNotNullParameter(action, "action");
                QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", QQLiveIPCConstants.Module.MODULE_CLIENT, action, params, callback);
            }
        }

        @Nullable
        public final EIPCResult b(@NotNull String action, @Nullable Bundle params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, (Object) params);
            }
            Intrinsics.checkNotNullParameter(action, "action");
            return QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, QQLiveIPCConstants.Module.MODULE_CLIENT, action, params);
        }

        @NotNull
        public final QQLiveClientQIPCModule c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQLiveClientQIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (QQLiveClientQIPCModule) QQLiveClientQIPCModule.f271005h.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IQQLiveCheckFollowCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f271008b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f271009c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Long f271010d;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule$b$a", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a implements IQQLiveFollowCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQLiveClientQIPCModule f271011a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f271012b;

            a(QQLiveClientQIPCModule qQLiveClientQIPCModule, int i3) {
                this.f271011a = qQLiveClientQIPCModule;
                this.f271012b = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveClientQIPCModule, i3);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
            public void onFail(int errCode, @Nullable String errMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                    return;
                }
                this.f271011a.f(errCode, "do follow failed code:" + errCode, this.f271012b);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    this.f271011a.f(0, "", this.f271012b);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        b(int i3, Long l3, Long l16) {
            this.f271008b = i3;
            this.f271009c = l3;
            this.f271010d = l16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLiveClientQIPCModule.this, Integer.valueOf(i3), l3, l16);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            QQLiveClientQIPCModule.this.f(errCode, "check follow state failed code:" + errCode, this.f271008b);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isFollow);
            } else if (isFollow == 1) {
                QQLiveClientQIPCModule.this.f(0, "already follow", this.f271008b);
            } else {
                TGLiveFollowManager.f377684a.h(null, this.f271009c.longValue(), this.f271010d.longValue(), new a(QQLiveClientQIPCModule.this, this.f271008b));
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/base/ipc/QQLiveClientQIPCModule$c", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements IQQLiveMessageCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f271014b;

        c(int i3) {
            this.f271014b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveClientQIPCModule.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQLiveClientQIPCModule.this.f(errCode, "", this.f271014b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                QQLiveClientQIPCModule.this.f(-1, "onIllegalMsg", this.f271014b);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLiveClientQIPCModule.this.f(0, "", this.f271014b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, isLocal);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2);
                return;
            }
            QQLiveClientQIPCModule.this.f(-2, "onUserForbid: " + msg2, this.f271014b);
        }
    }

    static {
        Lazy<QQLiveClientQIPCModule> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveClientQIPCModule$Companion$instance$2.INSTANCE);
        f271005h = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveClientQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) moduleName);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int code, String msg2, int callbackId) {
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_KUIKLY_CALLBACK_MSG, msg2);
        callbackResult(callbackId, EIPCResult.createResult(code, bundle));
    }

    private final void g(String params, final int callbackId) {
        boolean z16;
        Long longOrNull;
        sq4.a aVar;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f(-1, "error params", callbackId);
            return;
        }
        String optString = new JSONObject(params).optString("seq");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"seq\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        sq4.b bVar = ri2.b.INSTANCE.a().get(longOrNull);
        if (bVar != null) {
            aVar = bVar.f434255b;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            f(-1, "error gameData", callbackId);
            QLog.e(QQLiveIPCConstants.Module.MODULE_CLIENT, 1, "enterGameInviteRoom but gameData is null");
        } else {
            ri2.a.f431480a.b(new QQLivePreparePlayTogetherPart.GameData(aVar.f434247a, aVar.f434248b, aVar.f434249c, aVar.f434251e, aVar.f434252f, aVar.f434253g), new Function2<Integer, String, Unit>(callbackId) { // from class: com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule$enterGameInviteRoom$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $callbackId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$callbackId = callbackId;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveClientQIPCModule.this, callbackId);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) msg2);
                    } else {
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        QQLiveClientQIPCModule.this.f(i3, msg2, this.$callbackId);
                    }
                }
            });
        }
    }

    private final void h(String params, int callbackId) {
        boolean z16;
        Long longOrNull;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f(-1, "error params", callbackId);
            return;
        }
        String optString = new JSONObject(params).optString("roomID");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"roomID\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        if (longOrNull == null) {
            f(-1, "error params", callbackId);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QQLiveExitRoomEvent(longOrNull.longValue()));
            f(0, "", callbackId);
        }
    }

    private final void i(String params, int callbackId) {
        boolean z16;
        Long longOrNull;
        Long longOrNull2;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f(-1, "error params", callbackId);
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("roomID");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"roomID\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        String optString2 = jSONObject.optString("userID");
        Intrinsics.checkNotNullExpressionValue(optString2, "paramsObj.optString(\"userID\")");
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(optString2);
        if (longOrNull != null && longOrNull2 != null) {
            TGLiveFollowManager.f377684a.f(null, longOrNull2.longValue(), new b(callbackId, longOrNull2, longOrNull));
        } else {
            f(-1, "error params", callbackId);
        }
    }

    private final e j() {
        g gVar;
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.context, g.class.getName());
        if (floatingProxyWrapper instanceof g) {
            gVar = (g) floatingProxyWrapper;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return gVar.x0();
    }

    private final e k() {
        e k3 = com.tencent.mobileqq.qqlive.sail.c.f272176a.m().k();
        if (k3 == null) {
            k3 = j();
        }
        if (k3 == null) {
            this.logger.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "[getValidRoom] has no room");
            return null;
        }
        if (k3.isDestroyed()) {
            this.logger.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "[getValidRoom] roomId=" + k3.getRoomId() + ", room is destroyed");
            return null;
        }
        this.logger.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "[getValidRoom] roomId=" + k3.getRoomId() + ", windowMode=" + k3.b().v());
        return k3;
    }

    private final void l(Bundle params, int callbackId) {
        if (params == null) {
            return;
        }
        final boolean z16 = params.getBoolean(QQLiveIPCConstants.Param.PARAM_CHAT_AUDIO_IS_CHATTING);
        final boolean z17 = params.getBoolean(QQLiveIPCConstants.Param.PARAM_CHAT_AUDIO_IS_BEING_INVITE);
        QLog.i(QQLiveIPCConstants.Module.MODULE_CLIENT, 1, "onChatAudioChange isChatting:" + z16 + " isBeInviting:" + z17);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.base.ipc.a
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveClientQIPCModule.m(QQLiveClientQIPCModule.this, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQLiveClientQIPCModule this$0, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e k3 = this$0.k();
        if (k3 != null) {
            QLog.i(QQLiveIPCConstants.Module.MODULE_CLIENT, 2, "onChatAudioChange room:" + k3 + " isChatting:" + z16 + " isBeInviting:" + z17);
            if (!z16 && !z17) {
                k3.y(false);
            } else {
                k3.y(true);
            }
        }
    }

    private final EIPCResult n(Bundle params) {
        RemotePlayerInfo remotePlayerInfo;
        Long l3;
        IBinder iBinder;
        com.tencent.mobileqq.qqlive.widget.player.a j3;
        if (params != null) {
            params.setClassLoader(RemotePlayerInfo.class.getClassLoader());
        }
        if (params != null) {
            remotePlayerInfo = (RemotePlayerInfo) params.getParcelable(QQLiveIPCConstants.Param.PARAM_REMOTE_PLAYER_INFO);
        } else {
            remotePlayerInfo = null;
        }
        IAegisLogApi iAegisLogApi = this.logger;
        if (remotePlayerInfo != null) {
            l3 = Long.valueOf(remotePlayerInfo.c());
        } else {
            l3 = null;
        }
        if (remotePlayerInfo != null) {
            iBinder = remotePlayerInfo.b();
        } else {
            iBinder = null;
        }
        iAegisLogApi.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "[onUseRemotePlayer] roomId=" + l3 + ", binder=" + iBinder);
        if (remotePlayerInfo == null || remotePlayerInfo.c() == 0 || (j3 = a.AbstractBinderC8408a.j(remotePlayerInfo.b())) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(j3, "IQQLiveRemotePlayer.Stub\u2026it.binder) ?: return null");
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext(), true);
        createPlayerVideoView.setXYaxis(remotePlayerInfo.a());
        createPlayerVideoView.setFixedSize(remotePlayerInfo.getWidth(), remotePlayerInfo.getHeight());
        com.tencent.mobileqq.qqlive.sail.c.f272176a.a(remotePlayerInfo.c(), new QQLiveRemotePlayer(j3, createPlayerVideoView));
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        return eIPCResult;
    }

    private final EIPCResult o() {
        e k3 = k();
        if (k3 != null) {
            ReportExtKt.d(k3);
            Bundle bundle = new Bundle();
            bundle.putParcelable(QQLiveIPCConstants.Param.PARAM_BACKGROUND_ROOM_INFO, k3.b());
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(bundle)");
            return createSuccessResult;
        }
        EIPCResult createExceptionResult = EIPCResult.createExceptionResult(new IllegalStateException("no room found"));
        Intrinsics.checkNotNullExpressionValue(createExceptionResult, "createExceptionResult(Il\u2026ception(\"no room found\"))");
        return createExceptionResult;
    }

    private final void p(String params, final int callbackId) {
        boolean z16;
        final Long longOrNull;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f(-1, "error params", callbackId);
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("roomID");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"roomID\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        final String optString2 = jSONObject.optString("comment");
        if (longOrNull == null) {
            f(-1, "error params", callbackId);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.base.ipc.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveClientQIPCModule.q(longOrNull, optString2, this, callbackId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Long l3, String comment, QQLiveClientQIPCModule this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = i.f378067a;
        long longValue = l3.longValue();
        Intrinsics.checkNotNullExpressionValue(comment, "comment");
        iVar.b(longValue, comment, null, new c(i3));
    }

    private final void r(String params, int callbackId) {
        boolean z16;
        Long longOrNull;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f(-1, "error params", callbackId);
            return;
        }
        String optString = new JSONObject(params).optString("roomID");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"roomID\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        if (longOrNull == null) {
            f(-1, "error params", callbackId);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QQLiveLikeEvent(longOrNull.longValue()));
            f(0, "", callbackId);
        }
    }

    @Nullable
    public final QQProfile getQQProfile(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQProfile) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.logger.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "getQQProfile uin:" + uin);
        QQLiveServerQIPCModule.Companion companion = QQLiveServerQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.Param.PARAM_ACCOUNT_UIN, uin);
        Unit unit = Unit.INSTANCE;
        EIPCResult b16 = companion.b(QQLiveIPCConstants.Action.ACTION_GET_QQ_PROFILE, bundle);
        if (b16 != null && b16.isSuccess()) {
            QQProfile qQProfile = (QQProfile) b16.data.getParcelable(QQLiveIPCConstants.Param.PARAM_QQ_PROFILE);
            this.logger.i(QQLiveIPCConstants.Module.MODULE_CLIENT, "profile " + qQProfile);
            return qQProfile;
        }
        this.logger.e(QQLiveIPCConstants.Module.MODULE_CLIENT, "getQQProfile fail");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 4, this, action, params, Integer.valueOf(callbackId));
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1658960086:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_ROOM_BACKGROUND_REPORT)) {
                        return o();
                    }
                    break;
                case -1306231931:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_CLIENT_ROOM_CHAT_AV_NOTIFY)) {
                        l(params, callbackId);
                        break;
                    }
                    break;
                case -1136291912:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_USE_REMOTE_PLAYER)) {
                        return n(params);
                    }
                    break;
                case -1120394887:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_FOLLOW_ANCHOR)) {
                        if (params != null) {
                            str = params.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS);
                        } else {
                            str = null;
                        }
                        i(str, callbackId);
                        break;
                    }
                    break;
                case -708221512:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_SEND_FREE_LOVE)) {
                        if (params != null) {
                            str2 = params.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS);
                        } else {
                            str2 = null;
                        }
                        r(str2, callbackId);
                        break;
                    }
                    break;
                case 565755762:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_SEND_COMMENT)) {
                        if (params != null) {
                            str3 = params.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS);
                        } else {
                            str3 = null;
                        }
                        p(str3, callbackId);
                        break;
                    }
                    break;
                case 1678910674:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_EXIT_ROOM)) {
                        if (params != null) {
                            str4 = params.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS);
                        } else {
                            str4 = null;
                        }
                        h(str4, callbackId);
                        break;
                    }
                    break;
                case 1763519573:
                    if (action.equals(QQLiveIPCConstants.Action.ACTION_QQLIVE_ENTER_GAME_INVITE_ROOM)) {
                        if (params != null) {
                            str5 = params.getString(QQLiveIPCConstants.Param.PARAM_KUIKLY_PARAMS);
                        } else {
                            str5 = null;
                        }
                        g(str5, callbackId);
                        break;
                    }
                    break;
            }
        }
        return null;
    }

    public final void qualityReport(int attaId, @NotNull QQLiveQualityReportData.Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, attaId, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        QQLiveServerQIPCModule.Companion companion = QQLiveServerQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(QQLiveIPCConstants.Param.PARAM_ATTA_ID, attaId);
        bundle.putParcelable(QQLiveIPCConstants.Param.PARAM_REPORT_DATA, builder.getReportData());
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_QUALITY_REPORT, bundle, null);
    }

    public final void registerModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!f271004f) {
            try {
                QIPCClientHelper.getInstance().register(INSTANCE.c());
            } catch (Exception e16) {
                this.logger.e(QQLiveIPCConstants.Module.MODULE_CLIENT, "[registerModule] error", e16);
            }
            f271004f = true;
        }
    }
}
