package com.tencent.ecommerce.biz.consumer.report;

import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.util.PerfTracer;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b2\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0011\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0015R\"\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0015R\"\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0015R\"\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b\u001e\u0010\u0015R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b0\u0010\nR\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0006\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0006\u001a\u0004\b6\u0010\b\"\u0004\b2\u0010\nR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0006\u001a\u0004\b8\u0010\b\"\u0004\b)\u0010\nR\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\b\"\u0004\b%\u0010\nR\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0012\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0015R\"\u0010C\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0015R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\bD\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010G\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\bF\u0010\u0014\"\u0004\b\f\u0010\u0015R\"\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u0010\u0015R\"\u0010N\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0012\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u0010\u0015R\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010\u0006\u001a\u0004\bP\u0010\b\"\u0004\b=\u0010\nR\"\u0010S\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0006\u001a\u0004\bR\u0010\b\"\u0004\bO\u0010\nR\"\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0006\u001a\u0004\bT\u0010\b\"\u0004\bU\u0010\nR\"\u0010V\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0006\u001a\u0004\bV\u0010\b\"\u0004\bH\u0010\nR\"\u0010W\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0012\u001a\u0004\bW\u0010\u0014\"\u0004\b:\u0010\u0015\u00a8\u0006Z"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/report/b;", "", "Lcom/tencent/ecommerce/biz/common/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "a", "I", "getBusId", "()I", "e", "(I)V", "busId", "b", "getCardUiType", "g", "cardUiType", "", "c", "Ljava/lang/String;", "getAuthorUin", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "authorUin", "d", "getContentId", "j", "contentId", "getProductId", "p", "productId", "f", "getProductPrice", "r", "productPrice", "getProductName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "productName", h.F, "getButtonText", "buttonText", "", "i", "J", "getDuration", "()J", "l", "(J)V", "duration", "y", QFSEdgeItem.KEY_VIDEO_TIME, "k", "getExpTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "expTime", "getDisappearTime", "disappearTime", "getClickTime", "clickTime", DomainData.DOMAIN_NAME, "getClickArea", "clickArea", "o", "getTaskKey", "w", "taskKey", "getTaskId", "v", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "getBtnType", "btnType", "getAppId", "appId", ReportConstant.COSTREPORT_PREFIX, "getSealTransfer", "t", "sealTransfer", "getTraceId", HippyTKDListViewAdapter.X, "traceId", "u", "getPageId", "pageId", "getSourceFrom", GetAdInfoRequest.SOURCE_FROM, "isFromECGoods", "setFromECGoods", "isResume", "isFirstExp", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int busId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int cardUiType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long duration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int videoTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int expTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int disappearTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int clickTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int clickArea;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int btnType;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int isResume;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String authorUin = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String contentId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String productId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String productPrice = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String productName = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String buttonText = "";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String taskKey = "";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String taskId = "";

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String appId = "";

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String traceId = "";

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int pageId = -1;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int sourceFrom = -1;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int isFromECGoods = 1;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String isFirstExp = "";

    /* renamed from: a, reason: from getter */
    public final int getVideoTime() {
        return this.videoTime;
    }

    public final void b(String str) {
        this.appId = str;
    }

    public final void c(String str) {
        this.authorUin = str;
    }

    public final void d(int i3) {
        this.btnType = i3;
    }

    public final void e(int i3) {
        this.busId = i3;
    }

    public final void f(String str) {
        this.buttonText = str;
    }

    public final void g(int i3) {
        this.cardUiType = i3;
    }

    public final void h(int i3) {
        this.clickArea = i3;
    }

    public final void i(int i3) {
        this.clickTime = i3;
    }

    public final void j(String str) {
        this.contentId = str;
    }

    public final void k(int i3) {
        this.disappearTime = i3;
    }

    public final void l(long j3) {
        this.duration = j3;
    }

    public final void m(int i3) {
        this.expTime = i3;
    }

    public final void n(String str) {
        this.isFirstExp = str;
    }

    public final void o(int i3) {
        this.pageId = i3;
    }

    public final void p(String str) {
        this.productId = str;
    }

    public final void q(String str) {
        this.productName = str;
    }

    public final void r(String str) {
        this.productPrice = str;
    }

    public final void s(int i3) {
        this.isResume = i3;
    }

    public final void t(String str) {
        this.sealTransfer = str;
    }

    public final void u(int i3) {
        this.sourceFrom = i3;
    }

    public final void v(String str) {
        this.taskId = str;
    }

    public final void w(String str) {
        this.taskKey = str;
    }

    public final void x(String str) {
        this.traceId = str;
    }

    public final void y(int i3) {
        this.videoTime = i3;
    }

    public final e z() {
        return new e().a(String.valueOf(this.busId)).b("viewer_uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount())).b("author_uin", this.authorUin).b("content_id", this.contentId).b("little_world_feed_id", this.contentId).b("card_ui_type", String.valueOf(this.cardUiType)).b(AppDownloadCallback.BUTTON_TXT, this.buttonText).b("product_price", this.productPrice).b(ReportDataBuilder.KEY_PRODUCT_ID, this.productId).b("product_name", this.productName).b("click_area", String.valueOf(this.clickArea)).b("duration", String.valueOf(this.duration)).b("exp_time", String.valueOf(this.expTime)).b("disappear_time", String.valueOf(this.disappearTime)).b(PerfTracer.PARAM_CLICK_TIME, String.valueOf(this.clickTime)).b("task_key", this.taskKey).b("task_id", this.taskId).b("btn_type", String.valueOf(this.btnType)).b("app_id", this.appId).b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, this.sealTransfer).b("request_id", this.traceId).b("page_scene", String.valueOf(this.pageId)).b("source_from", String.valueOf(this.sourceFrom)).b("is_from_ec_goods", String.valueOf(this.isFromECGoods)).b("link_type", "0").b("is_resume", String.valueOf(this.isResume)).b("is_first_exp", this.isFirstExp);
    }
}
