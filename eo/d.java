package eo;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f396881a = "P_UPLOAD_COST";

    /* renamed from: b, reason: collision with root package name */
    public static String f396882b = "E_PUBLISH_ADD_TASK";

    /* renamed from: c, reason: collision with root package name */
    public static String f396883c = "E_PUBLISH_COMPLETE_TASK";

    /* renamed from: d, reason: collision with root package name */
    public static String f396884d = "E_PUBLISH_RESUME_TASK";

    /* renamed from: e, reason: collision with root package name */
    public static String f396885e = "E_PUBLISH_CANCEL_TASK_ON_FAILED";

    /* renamed from: f, reason: collision with root package name */
    public static String f396886f = "E_PUBLISH_CANCEL_TASK_ON_PROCESS";

    /* renamed from: g, reason: collision with root package name */
    public static String f396887g = "E_PUBLISH_REMOVE_FAKE_FEED";

    /* renamed from: h, reason: collision with root package name */
    public static String f396888h = "1";

    /* renamed from: i, reason: collision with root package name */
    public static String f396889i = "0";

    /* renamed from: j, reason: collision with root package name */
    public static String f396890j = "1";

    /* renamed from: k, reason: collision with root package name */
    public static String f396891k = "2";

    /* renamed from: l, reason: collision with root package name */
    public static String f396892l = "3";

    public static String a() {
        return LoginData.getInstance().getUin() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
    }

    public static void b(WinkPublishQualityReportData winkPublishQualityReportData) {
        if (TextUtils.isEmpty(winkPublishQualityReportData.getExt6())) {
            winkPublishQualityReportData.setExt6(f396888h);
        }
        WinkPublishReportQueue.INSTANCE.report(winkPublishQualityReportData, 4, com.tencent.qzonehub.reborn.a.a());
    }

    public static void c(String str, UploadQualityReportBuilder uploadQualityReportBuilder) {
    }
}
