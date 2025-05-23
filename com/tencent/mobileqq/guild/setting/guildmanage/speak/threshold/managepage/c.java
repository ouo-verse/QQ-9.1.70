package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sz1.SpeakingThresholdStatus;
import vh2.x;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/c;", "Lef1/b;", "", "P1", "X1", "", "W1", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqguildsdk/data/fc;", "D", "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "statusLiveData", "Lsz1/e;", "E", "Lsz1/e;", "R1", "()Lsz1/e;", "setLocalStatus", "(Lsz1/e;)V", "localStatus", "Lcom/tencent/mobileqq/guild/profile/profilecard/main/l;", UserInfo.SEX_FEMALE, "U1", "toastLiveData", "G", "S1", "savaLiveData", "<init>", "(Ljava/lang/String;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<fc> statusLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private SpeakingThresholdStatus localStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.guild.profile.profilecard.main.l> toastLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> savaLiveData;

    public c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.statusLiveData = new MutableLiveData<>();
        this.localStatus = new SpeakingThresholdStatus(false, false, false, 0L, false, false, false, 0L, 255, null);
        this.toastLiveData = new MutableLiveData<>();
        this.savaLiveData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(c this$0, int i3, String str, fc fcVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && fcVar != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 1, "fetchStatus success threshold:" + fcVar);
            }
            this$0.statusLiveData.postValue(fcVar);
            this$0.localStatus = SpeakingThresholdStatus.INSTANCE.a(fcVar);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "fetchStatus failed, result: " + i3 + ", errMsg:" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 1, (String) it.next(), null);
        }
        this$0.toastLiveData.postValue(com.tencent.mobileqq.guild.profile.profilecard.main.l.e(i3, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(c this$0, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toastLiveData.postValue(new com.tencent.mobileqq.guild.profile.profilecard.main.l(i3, str, iGProSecurityResult));
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 1, "submitStatus success localStatus:" + this$0.getLocalStatus());
            }
            this$0.statusLiveData.postValue(this$0.localStatus.h());
            this$0.savaLiveData.postValue(Boolean.TRUE);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "submitStatus failed, result: " + i3 + ", errMsg:" + str + " sec:" + iGProSecurityResult;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 1, (String) it.next(), null);
        }
    }

    public final void P1() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 2, "fetchStatus start");
        }
        ((IGPSService) M1().getRuntimeService(IGPSService.class, "")).fetchGuildSpeakableThreshold(this.guildId, new x() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.a
            @Override // vh2.x
            public final void a(int i3, String str, fc fcVar) {
                c.Q1(c.this, i3, str, fcVar);
            }
        });
    }

    @NotNull
    /* renamed from: R1, reason: from getter */
    public final SpeakingThresholdStatus getLocalStatus() {
        return this.localStatus;
    }

    @NotNull
    public final MutableLiveData<Boolean> S1() {
        return this.savaLiveData;
    }

    @NotNull
    public final MutableLiveData<fc> T1() {
        return this.statusLiveData;
    }

    @NotNull
    public final MutableLiveData<com.tencent.mobileqq.guild.profile.profilecard.main.l> U1() {
        return this.toastLiveData;
    }

    public final boolean W1() {
        SpeakingThresholdStatus speakingThresholdStatus = this.localStatus;
        fc value = this.statusLiveData.getValue();
        if (value == null) {
            value = new SpeakingThresholdStatus(false, false, false, 0L, false, false, false, 0L, 255, null).h();
        }
        Intrinsics.checkNotNullExpressionValue(value, "statusLiveData.value ?: \u2026oldStatus().toThreshold()");
        return !speakingThresholdStatus.a(value);
    }

    public final void X1() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sr.SpeakingThresholdManageFragment.ViewModel", 2, "submitStatus start");
        }
        ((IGPSService) M1().getRuntimeService(IGPSService.class, "")).setGuildSpeakableThreshold(this.guildId, this.localStatus.h(), new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.b
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                c.Z1(c.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }
}
