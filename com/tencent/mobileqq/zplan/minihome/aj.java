package com.tencent.mobileqq.zplan.minihome;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b+\u0010,J4\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\"\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016JH\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J<\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0016R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010(R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/aj;", "Lcom/tencent/mobileqq/zplan/minihome/aa;", "", "eventCode", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", tl.h.F, "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeDownloadStatus;", "g", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "type", "a", "uin", "d", "timeStatJSONString", "pixelCallbackDuration", "f", "errMsg", "errorDuration", "b", "entranceFrom", "exitReason", "isResetRoomAndAvatar", "roomLoadDuration", "avatarLoadDuration", "totalDuration", "c", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeReplaceEvent;", "event", "", "success", "e", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeDownloadStatus;", "bootHasDownload", "roomHasDownload", "avatarHasDownload", "Ljava/lang/String;", "errorMsg", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "cardType", "cardUin", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aj implements aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MiniHomeDownloadStatus bootHasDownload;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MiniHomeDownloadStatus roomHasDownload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MiniHomeDownloadStatus avatarHasDownload;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String errorMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MiniHomeProfileCardType cardType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String cardUin;

    public aj() {
        MiniHomeDownloadStatus miniHomeDownloadStatus = MiniHomeDownloadStatus.UNKNOWN;
        this.bootHasDownload = miniHomeDownloadStatus;
        this.roomHasDownload = miniHomeDownloadStatus;
        this.avatarHasDownload = miniHomeDownloadStatus;
        this.cardType = MiniHomeProfileCardType.UNKNOWN;
        this.cardUin = "";
    }

    private final void h(String eventCode, HashMap<String, String> params) {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportToBeacon("0AND0YAG6R40RLM6", eventCode, params);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void a(MiniHomeProfileCardType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.cardType = type;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void b(String eventCode, String errMsg, String errorDuration) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(errorDuration, "errorDuration");
        if (errMsg == null) {
            errMsg = "";
        }
        this.errorMsg = errMsg;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errMsg", errMsg), TuplesKt.to("errDuration", errorDuration), TuplesKt.to("bootHasDownload", this.bootHasDownload.name()), TuplesKt.to("roomHasDownload", this.roomHasDownload.name()), TuplesKt.to("avatarHasDownload", this.avatarHasDownload.name()), TuplesKt.to("hasDownload", g().name()), TuplesKt.to("cardType", this.cardType.name()), TuplesKt.to("cardUin", this.cardUin));
        h(eventCode, hashMapOf);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void d(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.cardUin = uin;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void e(MiniHomeReplaceEvent event, boolean success, HashMap<String, String> params) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("MiniHomeReporter", 2, "reportMiniHomeReplaceResult " + event + ", " + success + ", " + params);
        String name = event.name();
        if (success) {
            str = "1";
        } else {
            str = "0";
        }
        params.put("success", str);
        Unit unit = Unit.INSTANCE;
        h(name, params);
    }

    private final MiniHomeDownloadStatus g() {
        List listOf;
        boolean z16;
        boolean z17 = false;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MiniHomeDownloadStatus[]{this.bootHasDownload, this.roomHasDownload, this.avatarHasDownload});
        List list = listOf;
        boolean z18 = list instanceof Collection;
        if (!z18 || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((MiniHomeDownloadStatus) it.next()) == MiniHomeDownloadStatus.HAS_DOWNLOAD) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            return MiniHomeDownloadStatus.HAS_DOWNLOAD;
        }
        if (!z18 || !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                if (!(((MiniHomeDownloadStatus) it5.next()) == MiniHomeDownloadStatus.UNKNOWN)) {
                    break;
                }
            }
        }
        z17 = true;
        if (z17) {
            return MiniHomeDownloadStatus.UNKNOWN;
        }
        return MiniHomeDownloadStatus.WITHOUT_DOWNLOAD;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void f(String eventCode, String timeStatJSONString, String pixelCallbackDuration) {
        JSONObject jSONObject;
        boolean optBoolean;
        boolean optBoolean2;
        boolean optBoolean3;
        String str;
        String str2;
        MiniHomeDownloadStatus miniHomeDownloadStatus;
        MiniHomeDownloadStatus miniHomeDownloadStatus2;
        MiniHomeDownloadStatus miniHomeDownloadStatus3;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(pixelCallbackDuration, "pixelCallbackDuration");
        if (timeStatJSONString == null || timeStatJSONString.length() == 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            jSONObject = new JSONObject(timeStatJSONString);
            optBoolean = jSONObject.optBoolean("bootHasDownload", false);
            optBoolean2 = jSONObject.optBoolean("roomHasDownload", false);
            optBoolean3 = jSONObject.optBoolean("avatarHasDownload", false);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String optString = jSONObject.optString("bootResTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString, "timeStatJSON.optString(\"bootResTimeCost\", \"\")");
            hashMap.put("bootResTimeCost", optString);
            String optString2 = jSONObject.optString("bootTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "timeStatJSON.optString(\"bootTimeCost\", \"\")");
            hashMap.put("bootTimeCost", optString2);
            String optString3 = jSONObject.optString("userRoomResTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "timeStatJSON.optString(\"userRoomResTimeCost\", \"\")");
            hashMap.put("userRoomResTimeCost", optString3);
            String optString4 = jSONObject.optString("loadUserRoomTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "timeStatJSON.optString(\"loadUserRoomTimeCost\", \"\")");
            hashMap.put("loadUserRoomTimeCost", optString4);
            String optString5 = jSONObject.optString("avatarResTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "timeStatJSON.optString(\"avatarResTimeCost\", \"\")");
            hashMap.put("avatarResTimeCost", optString5);
            String optString6 = jSONObject.optString("resetAvatarTimeCost", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "timeStatJSON.optString(\"resetAvatarTimeCost\", \"\")");
            hashMap.put("resetAvatarTimeCost", optString6);
            hashMap.put("pixelCallbackDuration", pixelCallbackDuration);
            String str3 = "1";
            if (optBoolean) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("bootHasDownload", str);
            if (optBoolean2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put("roomHasDownload", str2);
            if (!optBoolean3) {
                str3 = "0";
            }
            hashMap.put("avatarHasDownload", str3);
            hashMap.put("cardUin", this.cardUin);
            hashMap.put("cardType", this.cardType.name());
            if (optBoolean) {
                miniHomeDownloadStatus = MiniHomeDownloadStatus.HAS_DOWNLOAD;
            } else {
                miniHomeDownloadStatus = MiniHomeDownloadStatus.WITHOUT_DOWNLOAD;
            }
            this.bootHasDownload = miniHomeDownloadStatus;
            if (optBoolean2) {
                miniHomeDownloadStatus2 = MiniHomeDownloadStatus.HAS_DOWNLOAD;
            } else {
                miniHomeDownloadStatus2 = MiniHomeDownloadStatus.WITHOUT_DOWNLOAD;
            }
            this.roomHasDownload = miniHomeDownloadStatus2;
            if (optBoolean3) {
                miniHomeDownloadStatus3 = MiniHomeDownloadStatus.HAS_DOWNLOAD;
            } else {
                miniHomeDownloadStatus3 = MiniHomeDownloadStatus.WITHOUT_DOWNLOAD;
            }
            this.avatarHasDownload = miniHomeDownloadStatus3;
            h(eventCode, hashMap);
        } catch (Throwable th6) {
            th = th6;
            QLog.e("MiniHomeReporter", 1, "reportMiniHomeTimeStat failed.", th);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.aa
    public void c(String eventCode, String entranceFrom, String exitReason, String isResetRoomAndAvatar, String pixelCallbackDuration, String roomLoadDuration, String avatarLoadDuration, String totalDuration) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(entranceFrom, "entranceFrom");
        Intrinsics.checkNotNullParameter(exitReason, "exitReason");
        Intrinsics.checkNotNullParameter(isResetRoomAndAvatar, "isResetRoomAndAvatar");
        Intrinsics.checkNotNullParameter(pixelCallbackDuration, "pixelCallbackDuration");
        Intrinsics.checkNotNullParameter(roomLoadDuration, "roomLoadDuration");
        Intrinsics.checkNotNullParameter(avatarLoadDuration, "avatarLoadDuration");
        Intrinsics.checkNotNullParameter(totalDuration, "totalDuration");
        String str = this.errorMsg;
        if (str == null) {
            str = "NO_ERROR";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("isResetRoomAndAvatar", isResetRoomAndAvatar), TuplesKt.to("entranceFrom", entranceFrom), TuplesKt.to("exitReason", exitReason), TuplesKt.to("totalDuration", totalDuration), TuplesKt.to("pixelCallbackDuration", pixelCallbackDuration), TuplesKt.to("roomLoadDuration", roomLoadDuration), TuplesKt.to("avatarLoadDuration", avatarLoadDuration), TuplesKt.to("bootHasDownload", this.bootHasDownload.name()), TuplesKt.to("roomHasDownload", this.roomHasDownload.name()), TuplesKt.to("avatarHasDownload", this.avatarHasDownload.name()), TuplesKt.to("hasDownload", g().name()), TuplesKt.to("cardType", this.cardType.name()), TuplesKt.to("cardUin", this.cardUin), TuplesKt.to("errMsg", str));
        h(eventCode, hashMapOf);
    }
}
