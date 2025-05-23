package com.tencent.sqshow.zootopia.report;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JJ\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\fJH\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\fJ2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001`\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010RZ\u0010\u0014\u001aF\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n0\nj*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001`\f`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/a;", "", "", "modMapId", "", "a", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "b", "e", "", "clearAfterRead", "d", "Ljava/util/HashMap;", "modReportParamMap", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f372690a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, HashMap<String, Object>> modReportParamMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.sqshow.zootopia.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public /* synthetic */ class C9837a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372692a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f372692a = iArr;
        }
    }

    a() {
    }

    private final void a(int modMapId) {
        QLog.i("ZPlanModReportHelper", 1, "clearMobBtnReportParams " + modMapId);
        modReportParamMap.remove(Integer.valueOf(modMapId));
    }

    public final void b(int modMapId, ButtonStatus buttonStatus, ZootopiaSource sourceCurrent, HashMap<String, Object> extraParams) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        int i3 = buttonStatus == null ? -1 : C9837a.f372692a[buttonStatus.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            e(modMapId, buttonStatus, sourceCurrent, extraParams);
        }
    }

    public final HashMap<String, Object> d(int modMapId, boolean clearAfterRead) {
        HashMap<String, Object> hashMap = modReportParamMap.get(Integer.valueOf(modMapId));
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        QLog.i("ZPlanModReportHelper", 1, "readModBtnReportParams " + modMapId + " - " + clearAfterRead);
        if (clearAfterRead) {
            a(modMapId);
        }
        return hashMap;
    }

    public final void e(int modMapId, ButtonStatus buttonStatus, ZootopiaSource sourceCurrent, HashMap<String, Object> extraParams) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        HashMap<String, Object> hashMap = new HashMap<>();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if ((pageInfo != null ? pageInfo.pageId : null) != null) {
            String str = pageInfo.pageId;
            Intrinsics.checkNotNullExpressionValue(str, "curPage.pageId");
            hashMap.put("dt_pgid", str);
            String str2 = pageInfo.pageId;
            Intrinsics.checkNotNullExpressionValue(str2, "curPage.pageId");
            hashMap.put("zplan_pgid", str2);
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(sourceCurrent));
        hashMap.put("zplan_map_id", Integer.valueOf(modMapId));
        if (buttonStatus != null) {
            hashMap.put("zplan_btn_status", Integer.valueOf(ButtonStatus.INSTANCE.b(buttonStatus)));
        }
        if (extraParams != null && extraParams.size() > 0) {
            hashMap.putAll(extraParams);
        }
        modReportParamMap.put(Integer.valueOf(modMapId), hashMap);
        QLog.i("ZPlanModReportHelper", 1, "saveModBtnReportParams " + modMapId + " - " + buttonStatus + " - " + hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, int i3, ButtonStatus buttonStatus, ZootopiaSource zootopiaSource, HashMap hashMap, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            hashMap = null;
        }
        aVar.b(i3, buttonStatus, zootopiaSource, hashMap);
    }
}
