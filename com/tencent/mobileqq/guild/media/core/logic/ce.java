package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.core.logic.s;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\"\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ce;", "Lcom/tencent/mobileqq/guild/media/core/logic/s;", "", "l", "", "privateMapKey", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "audioIsOpen", "k", "g", "needSet", "d", "enable", "needCheckRsp", tl.h.F, "b", "needLaunchImmediately", "e", "c", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Z", "getNeedLaunchScreenShareImmediately", "()Z", "setNeedLaunchScreenShareImmediately", "(Z)V", "needLaunchScreenShareImmediately", "", "J", "screenShareRecordTime", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ce implements s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean needLaunchScreenShareImmediately;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long screenShareRecordTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ce$b", "Lcom/tencent/mobileqq/guild/media/core/b;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f228428b;

        b(String str) {
            this.f228428b = str;
        }

        @Override // com.tencent.mobileqq.guild.media.core.b
        public void a(boolean isSuccess, @Nullable IGProSecurityResult securityResult) {
            QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[startScreenShare] enter room result: " + isSuccess);
            if (isSuccess) {
                ITRTCAudioRoom y06 = ce.this.core.y0();
                y06.E(this.f228428b);
                y06.A();
                ce.this.c();
            }
        }
    }

    public ce(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    private final void l() {
        this.core.getSelfUserInfo().f228103k = false;
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(this.core.getSelfUserInfo().f228093a);
        if (g16 != null) {
            g16.f228103k = false;
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void a(@NotNull String privateMapKey) {
        Intrinsics.checkNotNullParameter(privateMapKey, "privateMapKey");
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[startScreenShare] ");
        com.tencent.mobileqq.guild.media.core.f fVar = this.core;
        if (!fVar.i0(fVar.E())) {
            QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[startScreenShare] enter room start");
            this.core.Q().L0(new b(privateMapKey));
        } else {
            ITRTCAudioRoom y06 = this.core.y0();
            y06.E(privateMapKey);
            y06.A();
            c();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public boolean b() {
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[needLaunchShareImmediately] " + this.needLaunchScreenShareImmediately);
        return this.needLaunchScreenShareImmediately;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void c() {
        this.screenShareRecordTime = System.currentTimeMillis();
        Logger.f235387a.d().i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "recordScreenShareStarted");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void d(boolean needSet) {
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[closeScreenShare] guildId: " + this.core.getGuildID() + ", channelId: " + this.core.E());
        k(false);
        this.core.w0().p(false);
        m();
        l();
        if (needSet) {
            s.a.a(this, false, false, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void e(boolean needLaunchImmediately) {
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[setNeedLaunchShareImmediately] " + needLaunchImmediately);
        this.needLaunchScreenShareImmediately = needLaunchImmediately;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void f() {
        int i3 = 1;
        Logger.f235387a.d().i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "recordScreenShareStopped " + this.screenShareRecordTime);
        if (Intrinsics.compare(this.screenShareRecordTime, 0L) != 0) {
            com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_subchannel_session_id", c16.L());
            long currentTimeMillis = (System.currentTimeMillis() - this.screenShareRecordTime) / 1000;
            hashMap.put(QCircleSchemeAttr.CollectBoxDetail.SHARE_TIME, Long.valueOf(currentTimeMillis));
            String sharerId = c16.getScreenShareAnchorInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(sharerId, "sharerId");
            hashMap.put("sgrp_sharer_uin", sharerId);
            boolean areEqual = Intrinsics.areEqual(sharerId, c16.getSelfUserInfo().f228093a);
            if (!areEqual) {
                if (!areEqual) {
                    i3 = 2;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            hashMap.put("sgrp_screen_sharer", Integer.valueOf(i3));
            if (currentTimeMillis > 0) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_sgrp_subchannel_screenshare", hashMap);
            }
            QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 2, "[recordScreenShareStopped] " + currentTimeMillis);
            this.screenShareRecordTime = 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void g() {
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[closeScreenShareIfSelfSharing] ");
        if (this.core.H0().C()) {
            d(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.s
    public void h(boolean enable, boolean needCheckRsp) {
        int i3;
        if (enable) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QLog.i("QGMC.Core.MediaScreenShareCtrlHelper", 1, "[reportScreenState] enable: " + i3 + ", needCheck: " + needCheckRsp);
        bi.W(this.core.p0(), 0, i3, 0, needCheckRsp, 5, null);
    }

    public void k(boolean audioIsOpen) {
        this.core.y0().i(audioIsOpen);
    }

    public void m() {
        this.core.y0().o();
        f();
    }
}
