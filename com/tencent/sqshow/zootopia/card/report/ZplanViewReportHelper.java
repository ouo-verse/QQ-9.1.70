package com.tencent.sqshow.zootopia.card.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import id3.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJN\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\bJD\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ.\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J4\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015R\u001b\u0010\u001c\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "", "Landroid/view/View;", "view", "", "id", "", "extras", "", "autoReportExpose", IECDtReport.ACTION_IDENTIFIER, "isAsync", "", "g", "i", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "c", "e", "target", "pageId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "a", "Lid3/d;", "Lkotlin/Lazy;", "b", "()Lid3/d;", "dtReportHelper", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanViewReportHelper {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy dtReportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*JJ\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u000fR\u0014\u0010!\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000fR\u0014\u0010\"\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000fR\u0014\u0010#\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u000fR\u0014\u0010$\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u000fR\u0014\u0010&\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000fR\u0014\u0010'\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u000fR\u0014\u0010(\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper$a;", "", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "cardPos", "position", "", "elementType", "Lpv4/s;", "sceneIndexModuleDetail", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "EM_CONTINUE_CUSTOMIZE", "Ljava/lang/String;", "EM_GIVE_UP_CUSTOMIZE", "EM_START_XIAOWO", "EM_ZPLAN_ACTIVE_WELFARE_ENTRANCE", "EM_ZPLAN_BACK_BTN", "EM_ZPLAN_CLOSE", "EM_ZPLAN_CREATE_BTN", "EM_ZPLAN_CREATE_ICON", "EM_ZPLAN_GUIDE_CONTINUE", "EM_ZPLAN_GUIDE_SKIP_ALL", "EM_ZPLAN_GUIDE_SKIP_CUR", "EM_ZPLAN_JUMP_AREA", "EM_ZPLAN_MAIL_BTN", "EM_ZPLAN_MOD_BTN", "EM_ZPLAN_MORE_BTN", "EM_ZPLAN_MSG_ENTRANCE", "EM_ZPLAN_PERSONAL_CENTER_BTN", "EM_ZPLAN_PRIVACY_EVERYONE_BTN", "EM_ZPLAN_PRIVACY_PRIVATE_BTN", "EM_ZPLAN_RECHARGE", "EM_ZPLAN_SETTING_BTN", "EM_ZPLAN_SILVER_COIN", "EM_ZPLAN_TASK_ENTRANCE", "EM_ZPLAN_TOPUP_ENTRANCE_BTN", "EM_ZPLAN_TOP_BANNER_RESOURCE", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final HashMap<String, Object> a(ZootopiaCardData dataInfo, int cardPos, int position, String elementType, s sceneIndexModuleDetail) {
            Map<? extends String, ? extends Object> a16;
            Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
            Intrinsics.checkNotNullParameter(elementType, "elementType");
            Intrinsics.checkNotNullParameter(sceneIndexModuleDetail, "sceneIndexModuleDetail");
            HashMap<String, Object> hashMap = new HashMap<>();
            a.Companion companion = a.INSTANCE;
            String str = sceneIndexModuleDetail.f427682c;
            Intrinsics.checkNotNullExpressionValue(str, "sceneIndexModuleDetail.jumpUrl");
            a16 = companion.a(cardPos, position, elementType, dataInfo, str, sceneIndexModuleDetail, (r17 & 64) != 0 ? new HashMap() : null);
            hashMap.putAll(a16);
            return hashMap;
        }
    }

    public ZplanViewReportHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper$dtReportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d(null, 1, null);
            }
        });
        this.dtReportHelper = lazy;
    }

    public final void a(Object target, Object view, String pageId, Map<String, Object> r56) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        b().j(target, view, pageId, r56);
    }

    public final d b() {
        return (d) this.dtReportHelper.getValue();
    }

    public final void c(View view, String id5, IDynamicParams dynamicParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(view, id5);
        if (dynamicParams != null) {
            VideoReport.setEventDynamicParams(view, dynamicParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public final void e(View view, String id5, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        HashMap hashMap = new HashMap();
        if (extras != null) {
            hashMap.putAll(extras);
        }
        d.i(b(), view, id5, hashMap, false, false, null, false, false, 224, null);
        QLog.d("ZplanReportHelper", 1, "report click id=" + id5 + " reportParams=" + hashMap);
        b().c("clck", view, hashMap);
    }

    public final void g(View view, String id5, Map<String, ? extends Object> extras, boolean autoReportExpose, String r18, boolean isAsync) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        HashMap hashMap = new HashMap();
        if (extras != null) {
            hashMap.putAll(extras);
        }
        d.i(b(), view, id5, hashMap, false, autoReportExpose, r18, isAsync, false, 128, null);
        if (autoReportExpose) {
            return;
        }
        b().c("imp", view, hashMap);
    }

    public final void i(View view, String id5, Map<String, ? extends Object> extras, boolean autoReportExpose, String r18) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        HashMap hashMap = new HashMap();
        if (extras != null) {
            hashMap.putAll(extras);
        }
        d.i(b(), view, id5, hashMap, false, autoReportExpose, r18, false, false, 192, null);
        if (autoReportExpose) {
            return;
        }
        b().c("imp_end", view, hashMap);
    }

    public static /* synthetic */ void d(ZplanViewReportHelper zplanViewReportHelper, View view, String str, IDynamicParams iDynamicParams, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            iDynamicParams = null;
        }
        zplanViewReportHelper.c(view, str, iDynamicParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(ZplanViewReportHelper zplanViewReportHelper, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        zplanViewReportHelper.e(view, str, map);
    }

    public static /* synthetic */ void j(ZplanViewReportHelper zplanViewReportHelper, View view, String str, Map map, boolean z16, String str2, int i3, Object obj) {
        Map map2 = (i3 & 4) != 0 ? null : map;
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        zplanViewReportHelper.i(view, str, map2, z16, (i3 & 16) != 0 ? null : str2);
    }

    public static /* synthetic */ void h(ZplanViewReportHelper zplanViewReportHelper, View view, String str, Map map, boolean z16, String str2, boolean z17, int i3, Object obj) {
        zplanViewReportHelper.g(view, str, (i3 & 4) != 0 ? null : map, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? false : z17);
    }
}
