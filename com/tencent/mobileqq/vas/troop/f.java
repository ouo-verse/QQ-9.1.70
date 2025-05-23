package com.tencent.mobileqq.vas.troop;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/f;", "", "", "c", "b", "d", "aid", "a", "", "e", "msg", "", "f", "Ljava/lang/String;", "uploadPhotoPayUrl", "videoPayUrl", "photoTipsText", "videoTipsText", "qualityRawTextDesc", "", "g", "J", "resetQualityTime", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f311020a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String uploadPhotoPayUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String videoPayUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String photoTipsText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String videoTipsText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String qualityRawTextDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final long resetQualityTime;

    static {
        UnitedProxy a16 = ar.INSTANCE.a("anzaihuang", "2024-06-20", "vas_qzone_yellow_pay_config");
        boolean z16 = true;
        long j3 = 0;
        if (a16.isEnable(true)) {
            JSONObject json = a16.getJson();
            String optString = json.optString("photo_open_link", "mqqapi://kuikly/open?aid={AID}&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond&half_pay=1&modal_mode=1&month=1&policy_id=ytsc&referrer=qzoneAlbum");
            Intrinsics.checkNotNullExpressionValue(optString, "config.optString(\"photo_\u2026\", DEFAULT_PHOTO_PAY_URL)");
            uploadPhotoPayUrl = optString;
            String optString2 = json.optString("video_open_link", "mqqapi://kuikly/open?aid={AID}&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond&half_pay=1&modal_mode=1&month=1&policy_id=ytsc");
            Intrinsics.checkNotNullExpressionValue(optString2, "config.optString(\"video_\u2026\", DEFAULT_VIDEO_PAY_URL)");
            videoPayUrl = optString2;
            String optString3 = json.optString("photo_tips_text", "\u5f00\u901a\u9ec4\u94bb\uff0c\u4eab\u65e0\u635f\u539f\u56fe\u4e0a\u4f20");
            Intrinsics.checkNotNullExpressionValue(optString3, "config.optString(\"photo_\u2026ext\", DEFAULT_PHOTO_TEXT)");
            photoTipsText = optString3;
            String optString4 = json.optString("video_tips_text", "\u5f00\u901a\u9ec4\u94bb \u5c0a\u4eab\u89c6\u9891\u539f\u753b\u4e0a\u4f20");
            Intrinsics.checkNotNullExpressionValue(optString4, "config.optString(\"video_\u2026ext\", DEFAULT_VIDEO_TEXT)");
            videoTipsText = optString4;
            String optString5 = json.optString("quality_raw_text", "\u6309\u539f\u59cb\u56fe\u50cf\u8d28\u91cf\u548c\u5927\u5c0f\u65e0\u635f\u4e0a\u4f20\uff0c\u4e0a\u4f20\u901f\u5ea6\u8f83\u6162");
            Intrinsics.checkNotNullExpressionValue(optString5, "config.optString(\"qualit\u2026_text\", DEFAULT_RAW_TEXT)");
            qualityRawTextDesc = optString5;
            String timeString = json.optString("reset_quality_time", "");
            Intrinsics.checkNotNullExpressionValue(timeString, "timeString");
            if (timeString.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                try {
                    Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).parse(timeString);
                    Intrinsics.checkNotNull(parse);
                    j3 = parse.getTime() / 1000;
                } catch (Exception unused) {
                }
            }
            resetQualityTime = j3;
            return;
        }
        uploadPhotoPayUrl = "mqqapi://kuikly/open?aid={AID}&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond&half_pay=1&modal_mode=1&month=1&policy_id=ytsc&referrer=qzoneAlbum";
        videoPayUrl = "mqqapi://kuikly/open?aid={AID}&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwMSJ9&version=1&kr_turbo_display=yellowDiamond&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=yellowDiamond&business_type=yellowDiamond&half_pay=1&modal_mode=1&month=1&policy_id=ytsc";
        photoTipsText = "\u5f00\u901a\u9ec4\u94bb\uff0c\u4eab\u65e0\u635f\u539f\u56fe\u4e0a\u4f20";
        videoTipsText = "\u5f00\u901a\u9ec4\u94bb \u5c0a\u4eab\u89c6\u9891\u539f\u753b\u4e0a\u4f20";
        qualityRawTextDesc = "\u6309\u539f\u59cb\u56fe\u50cf\u8d28\u91cf\u548c\u5927\u5c0f\u65e0\u635f\u4e0a\u4f20\uff0c\u4e0a\u4f20\u901f\u5ea6\u8f83\u6162";
        resetQualityTime = 0L;
    }

    f() {
    }

    @NotNull
    public final String a(@NotNull String aid) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(aid, "aid");
        if (Intrinsics.areEqual("jhan.hz.rk.tq_yspsc", aid)) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(videoPayUrl, "{AID}", aid, false, 4, (Object) null);
            return replace$default2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(uploadPhotoPayUrl, "{AID}", aid, false, 4, (Object) null);
        return replace$default;
    }

    @NotNull
    public final String b() {
        return photoTipsText;
    }

    @NotNull
    public final String c() {
        return qualityRawTextDesc;
    }

    @NotNull
    public final String d() {
        return videoTipsText;
    }

    public final boolean e() {
        long j3 = resetQualityTime;
        boolean z16 = false;
        if (j3 == 0) {
            return false;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime > j3) {
            z16 = true;
        }
        QLog.i("QzoneVasUploadConfig", 1, "isTimeForResetImageUploadQuality[" + j3 + "][" + serverTime + "] hit=" + z16);
        return z16;
    }

    public final void f(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("QzoneVasUploadConfig", 1, msg2);
    }
}
