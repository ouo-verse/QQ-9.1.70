package com.tencent.mobileqq.zplan.minihome;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\"\u0010#J4\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J8\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/ak;", "Lcom/tencent/mobileqq/zplan/minihome/ab;", "", "eventCode", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "f", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "type", "a", "timeStatJSONString", "e", "", "hasPausedBeforeFirstFrame", "", "duration", "c", "durationFromStart", "durationFromLoad", "b", "roomLoaded", "avatarLoaded", "firstFramed", "timeStatCallbacked", "d", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "cardType", "Lcom/tencent/mobileqq/zplan/minihome/an;", "Lcom/tencent/mobileqq/zplan/minihome/an;", "timeStat", "Ljava/lang/String;", "reportUUID", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ak implements ab {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MiniHomeProfileCardType cardType = MiniHomeProfileCardType.UNKNOWN;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MiniHomeTimeStat timeStat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String reportUUID;

    public ak() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.reportUUID = uuid;
    }

    private final void f(String eventCode, HashMap<String, String> params) {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportToBeacon("0AND0YAG6R40RLM6", eventCode, params);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.ab
    public void a(MiniHomeProfileCardType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.cardType = type;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.ab
    public void b(boolean hasPausedBeforeFirstFrame, long durationFromStart, long durationFromLoad) {
        String str;
        String str2;
        String str3;
        if (this.timeStat == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        MiniHomeTimeStat miniHomeTimeStat = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat);
        String str4 = "1";
        if (miniHomeTimeStat.getBootHasDownload()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("bootHasDownload", str);
        MiniHomeTimeStat miniHomeTimeStat2 = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat2);
        if (miniHomeTimeStat2.getRoomHasDownload()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("roomHasDownload", str2);
        MiniHomeTimeStat miniHomeTimeStat3 = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat3);
        if (miniHomeTimeStat3.getAvatarHasDownload()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("avatarHasDownload", str3);
        hashMap.put("durationFromStart", String.valueOf(durationFromStart));
        hashMap.put("durationFromLoad", String.valueOf(durationFromLoad));
        hashMap.put("cardType", this.cardType.name());
        if (!hasPausedBeforeFirstFrame) {
            str4 = "0";
        }
        hashMap.put("hasPausedBeforeFirstFrame", str4);
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.reportUUID);
        Unit unit = Unit.INSTANCE;
        f("minihome_profilecard_engine_statistic", hashMap);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.ab
    public void c(boolean hasPausedBeforeFirstFrame, long duration) {
        String str;
        String str2;
        String str3;
        if (this.timeStat == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        MiniHomeTimeStat miniHomeTimeStat = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat);
        String str4 = "1";
        if (miniHomeTimeStat.getBootHasDownload()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("bootHasDownload", str);
        MiniHomeTimeStat miniHomeTimeStat2 = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat2);
        if (miniHomeTimeStat2.getRoomHasDownload()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("roomHasDownload", str2);
        MiniHomeTimeStat miniHomeTimeStat3 = this.timeStat;
        Intrinsics.checkNotNull(miniHomeTimeStat3);
        if (miniHomeTimeStat3.getAvatarHasDownload()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("avatarHasDownload", str3);
        hashMap.put("clickToShow", String.valueOf(duration));
        hashMap.put("cardType", this.cardType.name());
        if (!hasPausedBeforeFirstFrame) {
            str4 = "0";
        }
        hashMap.put("hasPausedBeforeFirstFrame", str4);
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.reportUUID);
        Unit unit = Unit.INSTANCE;
        f("minihome_profilecard_page_statistic", hashMap);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.ab
    public void d(boolean roomLoaded, boolean avatarLoaded, boolean firstFramed, boolean timeStatCallbacked, boolean hasPausedBeforeFirstFrame, long duration) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap<String, String> hashMap = new HashMap<>();
        String str5 = "1";
        if (roomLoaded) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("roomLoaded", str);
        if (avatarLoaded) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("avatarLoaded", str2);
        if (firstFramed) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("firstFramed", str3);
        if (timeStatCallbacked) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        hashMap.put("timeStatCallbacked", str4);
        if (!hasPausedBeforeFirstFrame) {
            str5 = "0";
        }
        hashMap.put("hasPausedBeforeFirstFrame", str5);
        hashMap.put("duration", String.valueOf(duration));
        hashMap.put("cardType", this.cardType.name());
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.reportUUID);
        Unit unit = Unit.INSTANCE;
        f("minihome_profilecard_minihome_exit", hashMap);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.ab
    public void e(String timeStatJSONString) {
        if (timeStatJSONString == null || timeStatJSONString.length() == 0) {
            return;
        }
        try {
            this.timeStat = (MiniHomeTimeStat) GsonUtil.f385283b.a().fromJson(timeStatJSONString, MiniHomeTimeStat.class);
        } catch (Throwable th5) {
            QLog.e("MiniHomeReporterV2", 1, "setTimeStatJSONString failed.", th5);
        }
    }
}
