package gl;

import android.view.View;
import bl.CommonNoticeBean;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002JR\u0010\u0010\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ:\u0010\u0011\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ\u0018\u0010\u0012\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0017\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lgl/b;", "", "Lbl/a;", "noticeBean", "", "", "a", "b", "Landroid/view/View;", "elementView", "elementId", "", "d", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, QQBrowserActivity.APP_PARAM, h.F, "f", "e", "c", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f402374a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String pageId = "pg_qz_related_to_me_feed";

    b() {
    }

    private final Map<String, Object> b(CommonNoticeBean noticeBean) {
        Map<String, Object> a16 = a(noticeBean);
        a16.put(QQHealthReportApiImpl.MSG_TYPE_KEY, Integer.valueOf(noticeBean.getNotice().getNoticeType()));
        return a16;
    }

    public final void c(View elementView, CommonNoticeBean noticeBean) {
        Intrinsics.checkNotNullParameter(noticeBean, "noticeBean");
        fo.c.o(elementView, "em_qz_msg", new fo.b().l(b(noticeBean)).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).i(noticeBean.getNotice().getNoticeId()));
    }

    public final void d(View elementView, String elementId, CommonNoticeBean noticeBean) {
        Intrinsics.checkNotNullParameter(elementView, "elementView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(noticeBean, "noticeBean");
        fo.c.o(elementView, elementId, new fo.b().l(a(noticeBean)).i(noticeBean.getNotice().getNoticeId()));
    }

    public final void e(View elementView, CommonNoticeBean noticeBean) {
        Intrinsics.checkNotNullParameter(noticeBean, "noticeBean");
        fo.c.o(elementView, "em_qz_msg", new fo.b().l(b(noticeBean)).i(noticeBean.getNotice().getNoticeId()));
    }

    public final void f(View elementView, String elementId, CommonNoticeBean noticeBean, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = a(noticeBean);
        if (extraParams != null) {
            a16.putAll(extraParams);
        }
        fo.c.e(elementId, pageId, elementView, a16);
    }

    public final void h(View elementView, String elementId, CommonNoticeBean noticeBean, Map<String, ? extends Object> pageParams, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        String str = pageId;
        VideoReport.setPageId(elementView, str);
        VideoReport.setPageParams(elementView, new fo.a().d(str, pageParams));
        Map<String, Object> a16 = a(noticeBean);
        if (extraParams != null) {
            a16.putAll(extraParams);
        }
        fo.c.g(elementId, str, elementView, a16);
    }

    private final Map<String, Object> a(CommonNoticeBean noticeBean) {
        Map<String, Object> mutableMapOf;
        if (noticeBean != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("to_uin", Long.valueOf(c.f402376a.f(noticeBean.getNotice().getOpUser(), noticeBean.getCommonExt()))));
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(b bVar, View view, String str, CommonNoticeBean commonNoticeBean, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        bVar.f(view, str, commonNoticeBean, map);
    }
}
