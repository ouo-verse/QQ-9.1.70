package com.tencent.mobileqq.guild.media.core.logic;

import android.os.Build;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001-\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/g;", "", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "isCalling", "", "W", "i0", "j0", "onFocusLoss", "onFocusGain", "T", "c0", "e0", "d0", "X", "U", "E0", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "f", "Z", "mMicStatus", tl.h.F, "mIsCalling", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "i", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "mPhoneStatusMonitor", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "mNetworkListener", "Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", "mPhoneStatusAudioModeMonitor", "Lcom/tencent/av/utils/PhoneStatusMonitor$a;", "D", "Lcom/tencent/av/utils/PhoneStatusMonitor$a;", "mPhoneStatusListener", "com/tencent/mobileqq/guild/media/core/logic/g$b", "E", "Lcom/tencent/mobileqq/guild/media/core/logic/g$b;", "audioQueueFinishEventListener", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends h implements IModule.FocusChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PhoneStatusAudioModeMonitor mPhoneStatusAudioModeMonitor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final PhoneStatusMonitor.a mPhoneStatusListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b audioQueueFinishEventListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mMicStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsCalling;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPhoneStateMonitorApi.a mPhoneStatusMonitor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final INetworkStateApi.a mNetworkListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/g$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.a> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("QGMC.AudioSystemHelper", 1, "audio queue finish.");
            g.this.mMicStatus = false;
        }
    }

    public g(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.mNetworkListener = new INetworkStateApi.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.c
            @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
            public final void onNetworkConnect(boolean z16) {
                g.Y(g.this, z16);
            }
        };
        this.mPhoneStatusListener = new PhoneStatusMonitor.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.d
            @Override // com.tencent.av.utils.PhoneStatusMonitor.a
            public final void a(boolean z16) {
                g.a0(g.this, z16);
            }
        };
        this.audioQueueFinishEventListener = new b();
    }

    private final void W(boolean isCalling) {
        i0(isCalling);
        this.mIsCalling = isCalling;
        if (isCalling) {
            this.mMicStatus = this.core.getSelfUserInfo().f228101i;
            this.core.J().g(false);
            this.core.W().g();
            return;
        }
        this.core.J().g(this.mMicStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(g this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.w("QGMC.AudioSystemHelper", 1, "mNetworkListener " + z16);
        if (z16 && this$0.core.isInChannel()) {
            this$0.core.n0();
        }
        this$0.core.l0().j(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(g this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.AudioSystemHelper", 1, "mPhoneStatusAudioModeMonitor " + z16);
        this$0.W(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<Long, String> focusBusiness = AVBizModuleFactory.getModuleByName(Constants.Business.QQ_GUILD).getFocusBusiness();
        if (focusBusiness != null && Intrinsics.areEqual(Constants.Business.QQ_RTC, focusBusiness.get(1L))) {
            this$0.core.D("", "on focus loss.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(g this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.AudioSystemHelper", 1, "onCallStateChanged " + z16);
        this$0.W(z16);
    }

    private final void i0(boolean isCalling) {
        int i3;
        if (!this.core.isInChannel()) {
            return;
        }
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "core.getQQAppInterface()\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String str = this.core.getSelfUserInfo().P;
        Intrinsics.checkNotNullExpressionValue(str, "core.getSelfUserInfo().guildId");
        String str2 = this.core.getSelfUserInfo().Q;
        Intrinsics.checkNotNullExpressionValue(str2, "core.getSelfUserInfo().channelId");
        if (isCalling) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QLog.i("QGMC.AudioSystemHelper", 1, "setSysMicIfInRoom guildId: " + str + ", channelId: " + str2 + ", status: " + i3);
        iGPSService.setMyVoiceSysMicStatus(str, str2, i3);
        j0(isCalling);
    }

    private final void j0(boolean isCalling) {
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
        selfUserInfo.B = isCalling;
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(selfUserInfo.f228093a);
        if (g16 != null) {
            g16.B = isCalling;
        }
        com.tencent.mobileqq.guild.media.core.data.a w06 = this.core.w0();
        if (Intrinsics.areEqual(w06.f228093a, selfUserInfo.f228093a)) {
            w06.B = isCalling;
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        T();
        this.core.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueFinishEventListener);
    }

    public final void T() {
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.mNetworkListener);
    }

    public final void U() {
        this.mIsCalling = false;
        PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = this.mPhoneStatusAudioModeMonitor;
        if (phoneStatusAudioModeMonitor != null) {
            phoneStatusAudioModeMonitor.n(this.mPhoneStatusListener);
        }
        PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor2 = this.mPhoneStatusAudioModeMonitor;
        if (phoneStatusAudioModeMonitor2 != null) {
            phoneStatusAudioModeMonitor2.o(BaseApplication.context);
        }
    }

    /* renamed from: X, reason: from getter */
    public final boolean getMIsCalling() {
        return this.mIsCalling;
    }

    public final void c0() {
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.mNetworkListener);
    }

    public final void d0() {
        QLog.i("QGMC.AudioSystemHelper", 1, "[resetPhoneCallMonitor] ");
        IPhoneStateMonitorApi.a aVar = this.mPhoneStatusMonitor;
        if (aVar != null) {
            aVar.release();
        }
        this.mPhoneStatusMonitor = null;
    }

    public final void e0() {
        if (this.mPhoneStatusMonitor == null) {
            this.mPhoneStatusMonitor = ((IPhoneStateMonitorApi) QRoute.api(IPhoneStateMonitorApi.class)).newPhoneStateMonitor(this.core.getAppContext(), new IPhoneStateMonitorApi.b() { // from class: com.tencent.mobileqq.guild.media.core.logic.f
                @Override // com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi.b
                public final void a(boolean z16) {
                    g.f0(g.this, z16);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = new PhoneStatusAudioModeMonitor();
            this.mPhoneStatusAudioModeMonitor = phoneStatusAudioModeMonitor;
            Intrinsics.checkNotNull(phoneStatusAudioModeMonitor);
            phoneStatusAudioModeMonitor.i(this.mPhoneStatusListener);
            PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor2 = this.mPhoneStatusAudioModeMonitor;
            Intrinsics.checkNotNull(phoneStatusAudioModeMonitor2);
            phoneStatusAudioModeMonitor2.j(BaseApplication.context);
        }
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        QLog.i("QGMC.AudioSystemHelper", 1, "[onFocusGain] ");
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        QLog.w("QGMC.AudioSystemHelper", 1, "onFocusLoss");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.e
            @Override // java.lang.Runnable
            public final void run() {
                g.b0(g.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        c0();
        this.core.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueFinishEventListener);
    }
}
