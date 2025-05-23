package o00;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.net.WeishiIntent;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J&\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\u0006\u00a8\u0006\u0012"}, d2 = {"Lo00/e;", "", "Lcom/qq/taf/jce/JceStruct;", "T", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "", "errorCode", "", "b", "a", "Lcom/tencent/biz/pubaccount/weishi/net/common/d;", "observer", "code", "", "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f421670a = new e();

    e() {
    }

    public final <T extends JceStruct> boolean a(g<T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return request.isShouldStartQQAuth();
    }

    public final <T extends JceStruct> boolean b(g<T> request, int errorCode) {
        Intrinsics.checkNotNullParameter(request, "request");
        return request.canRequestRetry() && request.getRequestRetryCount() < d.f421669a.a() && (errorCode == 301002 || errorCode == 301013 || errorCode == -99);
    }

    public final <T extends JceStruct> void c(com.tencent.biz.pubaccount.weishi.net.common.d<T> observer, int code) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        g<T> f16 = observer.f();
        f16.setRequestRetryCount(f16.getRequestRetryCount() + 1);
        f16.setRetryCode(code);
        WeishiIntent weishiIntent = new WeishiIntent(BaseApplication.getContext(), l.class);
        weishiIntent.setWithouLogin(true);
        weishiIntent.setObserver(observer);
        weishiIntent.putExtra("timeout", f16.mTimeout);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            runtime.startServlet(weishiIntent);
        }
    }
}
