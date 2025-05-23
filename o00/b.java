package o00;

import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ<\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lo00/b;", "Lo00/a;", "Lcom/qq/taf/jce/JceStruct;", "T", "Lcom/qq/jce/wup/UniAttribute;", "attribute", "", QzoneIPCModule.RESULT_CODE, "", "msg", "Lcom/tencent/biz/pubaccount/weishi/net/common/d;", "observer", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements a {
    @Override // o00.a
    public <T extends JceStruct> boolean a(UniAttribute attribute, int resultCode, String msg2, com.tencent.biz.pubaccount.weishi.net.common.d<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        g<T> f16 = observer.f();
        e eVar = e.f421670a;
        if (!eVar.b(f16, resultCode)) {
            x.f("[WSService][WSCommonRetryProcessor]", "[process] cmd: " + f16.getCmdString() + ", not need retry");
            return false;
        }
        x.f("[WSService][WSCommonRetryProcessor]", "[process] cmd: " + f16.getCmdString() + ", need retry");
        eVar.c(observer, resultCode);
        return true;
    }
}
