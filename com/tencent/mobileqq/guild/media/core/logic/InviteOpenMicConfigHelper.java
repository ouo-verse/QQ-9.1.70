package com.tencent.mobileqq.guild.media.core.logic;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016JU\u0010\u0012\u001a\u00020\u00022M\b\u0002\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\tJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010!\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/InviteOpenMicConfigHelper;", "Lcom/tencent/mobileqq/guild/media/core/g;", "", "l", "k", "", tl.h.F, "e", "E0", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "retCode", "", "retMsg", "needToast", "callback", "f", "u", "p", "h0", "", "time1", "time2", "g", "Lcom/tencent/mobileqq/guild/media/core/f;", "d", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Ljava/lang/String;", "TAG", "I", "DAY_DIFF", "Ljava/util/Timer;", "Ljava/util/Timer;", "inviteOpenMicTipsTimer", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class InviteOpenMicConfigHelper implements com.tencent.mobileqq.guild.media.core.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int DAY_DIFF;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Timer inviteOpenMicTipsTimer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InviteOpenMicConfigHelper$a", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, Boolean, Unit> f228171a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function3<? super Integer, ? super String, ? super Boolean, Unit> function3) {
            this.f228171a = function3;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (result == 0) {
                com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ac(true));
            }
            this.f228171a.invoke(Integer.valueOf(result), errMsg, Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InviteOpenMicConfigHelper$b", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, Boolean, Unit> f228172a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Integer, ? super String, ? super Boolean, Unit> function3) {
            this.f228172a = function3;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f228172a.invoke(Integer.valueOf(result), errMsg, Boolean.TRUE);
        }
    }

    public InviteOpenMicConfigHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.TAG = "QGMC.InviteDialogConfigHelper";
        this.DAY_DIFF = 1;
    }

    private final void e() {
        Timer timer = this.inviteOpenMicTipsTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.inviteOpenMicTipsTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h() {
        Integer num;
        Integer num2 = 0;
        if (!com.tencent.mobileqq.guild.media.core.j.a().S().T(true, true)) {
            Logger.f235387a.d().d(this.TAG, 1, "startConfigChecker no talk permission");
            return false;
        }
        if (MediaChannelUtils.f228046a.t(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo())) {
            Logger.f235387a.d().d(this.TAG, 1, "startConfigChecker isAdminUser");
            return false;
        }
        MediaGuidanceConfig.NavConfigData inviteOpenMicTipsConfigData = MediaGuidanceConfig.INSTANCE.a().getInviteOpenMicTipsConfigData();
        if (com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a.size() <= inviteOpenMicTipsConfigData.getEffectiveCondition()) {
            Logger.f235387a.d().d(this.TAG, 1, "startConfigChecker anchors.size not qualified");
            return false;
        }
        com.tencent.mobileqq.guild.util.bw bwVar = com.tencent.mobileqq.guild.util.bw.f235485a;
        if (bwVar.F() != inviteOpenMicTipsConfigData.getDataVersion() || g(bwVar.G(), NetConnInfoCenter.getServerTimeMillis()) >= this.DAY_DIFF) {
            bwVar.m1(inviteOpenMicTipsConfigData.getDataVersion());
            bwVar.n1(NetConnInfoCenter.getServerTimeMillis());
            bwVar.o1(num2);
            Logger.f235387a.d().d(this.TAG, 1, "startConfigChecker update data version");
        }
        JSONArray timesLimit = inviteOpenMicTipsConfigData.getTimesLimit();
        if (timesLimit != null) {
            num = timesLimit.get(0);
        } else {
            num = null;
        }
        if (num != null) {
            num2 = num;
        }
        int intValue = num2.intValue();
        if (bwVar.H() < intValue) {
            return true;
        }
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().d(str, 1, "startConfigChecker beyond count " + intValue);
        return false;
    }

    private final void k() {
        Object obj;
        JSONArray userEnterTime = MediaGuidanceConfig.INSTANCE.a().getInviteOpenMicTipsConfigData().getUserEnterTime();
        if (userEnterTime != null) {
            obj = userEnterTime.get(0);
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = 0;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue == 0) {
            return;
        }
        e();
        BaseTimer baseTimer = new BaseTimer();
        this.inviteOpenMicTipsTimer = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.guild.media.core.logic.InviteOpenMicConfigHelper$startInviteOpenMicTimer$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean h16;
                h16 = InviteOpenMicConfigHelper.this.h();
                if (h16) {
                    MediaChannelCore.INSTANCE.a().o0().s().setValue(Boolean.TRUE);
                }
            }
        }, intValue * 1000);
    }

    private final void l() {
        Object obj;
        if (MediaChannelUtils.m() != 1) {
            QLog.d(this.TAG, 1, "updateNavTipsConfig not chat mode, return");
            return;
        }
        MediaGuidanceConfig.NavConfigData navConfigData = MediaGuidanceConfig.INSTANCE.a().getNavConfigData();
        com.tencent.mobileqq.guild.util.bw bwVar = com.tencent.mobileqq.guild.util.bw.f235485a;
        if (bwVar.T() < navConfigData.getDataVersion()) {
            bwVar.B1(0);
            bwVar.A1(navConfigData.getDataVersion());
        }
        JSONArray timesLimit = navConfigData.getTimesLimit();
        if (timesLimit != null) {
            obj = timesLimit.get(0);
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = 0;
        }
        if (bwVar.U() < ((Integer) obj).intValue()) {
            BuildersKt__Builders_commonKt.launch$default(this.core.getCoroutineScope(), null, null, new InviteOpenMicConfigHelper$startNavTipsTimer$1(navConfigData, this, null), 3, null);
        } else {
            QLog.d(this.TAG, 1, "updateNavTipsConfig beyond count");
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        QLog.d(this.TAG, 4, "onEnterChannel");
        k();
        l();
    }

    public final void f(@NotNull Function3<? super Integer, ? super String, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (MediaChannelPermissionHelper.U(com.tencent.mobileqq.guild.media.core.j.a().S(), false, false, 3, null)) {
            com.tencent.mobileqq.guild.media.core.j.a().J().i(true, new a(callback));
            return;
        }
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        int n3 = mediaChannelUtils.n(com.tencent.mobileqq.guild.media.core.j.c().e());
        if (n3 != 2) {
            if (n3 != 4) {
                if (com.tencent.mobileqq.guild.util.ch.s(com.tencent.mobileqq.guild.media.core.j.c().r())) {
                    Logger logger = Logger.f235387a;
                    logger.d().i(this.TAG, 1, "doUserAcceptInvitation: error, has not permission with visitor limit.");
                    QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                    if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                        com.tencent.mobileqq.guild.util.ch.h1(qBaseActivity, com.tencent.mobileqq.guild.media.core.j.c().r());
                        return;
                    }
                    return;
                }
                if (com.tencent.mobileqq.guild.media.core.j.a().C().i0()) {
                    Logger logger2 = Logger.f235387a;
                    logger2.d().i(this.TAG, 1, "doUserAcceptInvitation: error, has not permission with speak threshold limit.");
                    QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
                    if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
                        sz1.c.d(qBaseActivity2, com.tencent.mobileqq.guild.media.core.j.c().r());
                        return;
                    }
                    return;
                }
                String w3 = com.tencent.mobileqq.guild.setting.mute.c.w(com.tencent.mobileqq.guild.media.core.j.c().r(), com.tencent.mobileqq.guild.media.core.j.c().e());
                if (!TextUtils.isEmpty(w3)) {
                    Logger logger3 = Logger.f235387a;
                    logger3.d().i(this.TAG, 1, "doUserAcceptInvitation: error, has not permission with mute.");
                    MediaChannelUtils.Q(mediaChannelUtils, w3, null, 2, null);
                    return;
                }
                com.tencent.mobileqq.guild.media.core.j.a().J().i(true, new b(callback));
                return;
            }
            com.tencent.mobileqq.guild.media.core.j.a().T().k2(callback);
            return;
        }
        com.tencent.mobileqq.guild.media.core.j.a().N().r1(callback);
    }

    public final int g(long time1, long time2) {
        Date date = new Date(time1);
        Date date2 = new Date(time2);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        date2.setHours(0);
        date2.setMinutes(0);
        date2.setSeconds(0);
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        QLog.d(this.TAG, 4, "onReEnterChannel");
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
        QLog.d(this.TAG, 4, "onEnterChannelForPreview");
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        e();
        QLog.d(this.TAG, 4, "onExitChannel");
    }
}
