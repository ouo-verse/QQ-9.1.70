package i40;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Li40/b;", "", "", "feedsImplNum", "", "c", "Landroid/view/View;", "view", "", "hasFeeds", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "b", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407181a = new b();

    b() {
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(view, "em_xsj_confirm_button");
        VideoReport.setElementParams(view, buildElementParams);
    }

    public final void b(@NotNull View view, @Nullable FeedCloudMeta$StFeed stFeed) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (stFeed == null) {
            return;
        }
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_feed_id", stFeed.f398449id.get());
        VideoReport.setElementReuseIdentifier(view, stFeed.f398449id.get());
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        VideoReport.setElementParams(view, params);
    }

    public final void c(int feedsImplNum) {
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Integer valueOf = Integer.valueOf(feedsImplNum);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_WORKS_IMP_NUM, valueOf);
        params.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_MY_WORKS_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void d(@NotNull View view, boolean hasFeeds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_WORKS, Integer.valueOf(hasFeeds ? 1 : 0));
        VideoReport.setElementId(view, "em_xsj_publish_button");
        VideoReport.setElementParams(view, params);
    }
}
