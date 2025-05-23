package gl1;

import android.view.View;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nJ\u0012\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lgl1/b;", "", "", "invokeFrom", "", "f", "e", "Landroid/view/View;", "view", "c", "", "", "param", "d", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "b", "Lyk1/a;", "a", "Lyk1/a;", "binding", "", "Z", "hasSetUpElementId", "isEmotionShortcutVisible", "Ljava/util/Map;", "currentCommonParams", "<init>", "(Lyk1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f402380e = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final yk1.a binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasSetUpElementId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isEmotionShortcutVisible;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> currentCommonParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lgl1/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public b(@NotNull yk1.a binding) {
        Map<String, ? extends Object> emptyMap;
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.currentCommonParams = emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, Map params) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (this$0.binding.getEmoShortcut().getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.isEmotionShortcutVisible = z16;
        if (z16) {
            VideoReport.reportEvent("imp", this$0.binding.getEmoShortcut(), params);
        }
    }

    public final void b(@Nullable IDynamicParams dynamicParams) {
        if (this.hasSetUpElementId) {
            return;
        }
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo == null) {
            QLog.e("FeedNativeDetailInputReportHelper", 1, "[bindInputWindowReportElementId]: pageInfo should not be null");
            return;
        }
        VideoReport.setPageId(this.binding.getMRv(), pageInfo.pageId);
        VideoReport.setPageReportPolicy(this.binding.getMRv(), PageReportPolicy.REPORT_NONE);
        bt btVar = bt.f235484a;
        View sendBtn = this.binding.getSendBtn();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        bt.f(btVar, sendBtn, "em_sgrp_forum_comment_send", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bt.f(btVar, this.binding.getAtButton(), "em_sgrp_at_btn", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bt.f(btVar, this.binding.getEmotionButton(), "em_sgrp_aio_stickers", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bt.f(btVar, this.binding.getPicButton(), "em_sgrp_aio_plus_pic", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bt.f(btVar, this.binding.getEmoShortcut(), "em_sgrp_quick_emotion", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bt.f(btVar, this.binding.getInputPanelContainer(), "em_sgrp_enter_comment_box", null, dynamicParams, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        this.hasSetUpElementId = true;
    }

    public final void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.reportEvent("clck", view, this.currentCommonParams);
    }

    public final void d(@NotNull View view, @NotNull Map<String, ? extends Object> param) {
        Map plus;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(param, "param");
        plus = MapsKt__MapsKt.plus(this.currentCommonParams, param);
        VideoReport.reportEvent("clck", view, plus);
    }

    public final void e() {
        if (this.isEmotionShortcutVisible) {
            VideoReport.reportEvent("imp_end", this.binding.getEmoShortcut(), this.currentCommonParams);
        }
    }

    public final void f(short invokeFrom) {
        final Map<String, ? extends Object> mapOf;
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo == null) {
            QLog.e("FeedNativeDetailInputReportHelper", 1, "[reportShowInput] pageInfo should not be null");
            return;
        }
        Pair[] pairArr = new Pair[2];
        Map<String, Object> map = pageInfo.pageParams;
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("pgid", pageInfo.pageId);
        Unit unit = Unit.INSTANCE;
        pairArr[0] = TuplesKt.to("cur_pg", hashMap);
        pairArr[1] = TuplesKt.to("sgrp_click_region", Short.valueOf(invokeFrom));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        this.currentCommonParams = mapOf;
        if (QLog.isDebugVersion()) {
            QLog.d("FeedNativeDetailInputReportHelper", 4, "[reportShowInput] + " + mapOf);
        }
        VideoReport.reportEvent("imp", this.binding.getInputPanelContainer(), mapOf);
        this.binding.getMRv().post(new Runnable() { // from class: gl1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(b.this, mapOf);
            }
        });
    }
}
