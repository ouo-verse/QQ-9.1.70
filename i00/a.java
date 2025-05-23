package i00;

import UserGrowth.stDeepLinkReportRsp;
import com.tencent.biz.pubaccount.weishi.net.common.b;
import com.tencent.biz.pubaccount.weishi.net.common.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.d;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSDeepLinkRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Li00/a;", "", "", QZoneDTLoginReporter.SCHEMA, "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f406985a = new a();

    a() {
    }

    public final void a(String schema) {
        x.f("WSDeepLinkReporter", "DeepLinkReport report, schema:" + schema);
        if (schema == null || schema.length() == 0) {
            return;
        }
        e.a(new WSDeepLinkRequest(schema)).b(new C10496a());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\r"}, d2 = {"i00/a$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stDeepLinkReportRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "t", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i00.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10496a extends b<stDeepLinkReportRsp, stDeepLinkReportRsp> {
        C10496a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stDeepLinkReportRsp c(g<stDeepLinkReportRsp> request, stDeepLinkReportRsp t16, d headerBean) {
            x.i("WSDeepLinkReporter", "DeepLinkReport success");
            return t16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
            x.f("WSDeepLinkReporter", "DeepLinkReport failure, errorCode:" + (errorInfo != null ? Integer.valueOf(errorInfo.a()) : null) + ", errorMsg:" + (errorInfo != null ? errorInfo.b() : null));
        }
    }
}
