package o00;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.s;
import com.tencent.biz.pubaccount.weishi.util.x;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JI\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lo00/c;", "Lo00/a;", "Lcom/qq/taf/jce/JceStruct;", "T", "Lcom/tencent/biz/pubaccount/weishi/net/common/d;", "observer", "Lcom/qq/jce/wup/UniAttribute;", "attribute", "", QzoneIPCModule.RESULT_CODE, "", "msg", "o00/c$b", "b", "(Lcom/tencent/biz/pubaccount/weishi/net/common/d;Lcom/qq/jce/wup/UniAttribute;ILjava/lang/String;)Lo00/c$b;", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"o00/c$b", "Lcom/tencent/biz/pubaccount/weishi/s$b;", "", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", "onSuccess", "", "code", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements s.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.net.common.d<T> f421665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f421666b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ UniAttribute f421667c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f421668d;

        b(com.tencent.biz.pubaccount.weishi.net.common.d<T> dVar, int i3, UniAttribute uniAttribute, String str) {
            this.f421665a = dVar;
            this.f421666b = i3;
            this.f421667c = uniAttribute;
            this.f421668d = str;
        }

        @Override // com.tencent.biz.pubaccount.weishi.s.b
        public void onFailure(int code) {
            x.f("[WSService][WSQQAuthRetryProcessor]", "[retry] cmd: " + this.f421665a.f().getCmdString() + ", auth failure. code:" + code);
            this.f421665a.d(this.f421667c, 2000005, this.f421668d);
        }

        @Override // com.tencent.biz.pubaccount.weishi.s.b
        public void onSuccess(String openId, String accessToken) {
            x.f("[WSService][WSQQAuthRetryProcessor]", "[retry] cmd: " + this.f421665a.f().getCmdString() + ", auth success");
            e.f421670a.c(this.f421665a, this.f421666b);
        }
    }

    private final <T extends JceStruct> b b(com.tencent.biz.pubaccount.weishi.net.common.d<T> observer, UniAttribute attribute, int resultCode, String msg2) {
        return new b(observer, resultCode, attribute, msg2);
    }

    @Override // o00.a
    public <T extends JceStruct> boolean a(UniAttribute attribute, int resultCode, String msg2, com.tencent.biz.pubaccount.weishi.net.common.d<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        g<T> f16 = observer.f();
        e eVar = e.f421670a;
        if (!eVar.a(f16)) {
            x.f("[WSService][WSQQAuthRetryProcessor]", "[process] cmd: " + f16.getCmdString() + ", not need qq auth");
            return false;
        }
        if (!eVar.b(f16, resultCode)) {
            s.h().o(2);
            x.f("[WSService][WSQQAuthRetryProcessor]", "[process] cmd: " + f16.getCmdString() + ", need qq auth, but not need retry");
            return false;
        }
        s.h().p(2, b(observer, attribute, resultCode, msg2));
        x.f("[WSService][WSQQAuthRetryProcessor]", "[process] cmd: " + f16.getCmdString() + ", need qq auth, and need retry");
        return true;
    }
}
