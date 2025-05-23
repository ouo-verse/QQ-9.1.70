package com.tencent.biz.pubaccount.weishi.net.common;

import android.os.Bundle;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.ParamConstants;
import com.tencent.biz.pubaccount.weishi.net.common.i;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001\u001cB)\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0#\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J3\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u001d\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010!R#\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0#8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/net/common/d;", "Lcom/qq/taf/jce/JceStruct;", "Rsp", "Lmqq/observer/BusinessObserver;", "Lcom/tencent/biz/pubaccount/weishi/net/common/i$a;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "msg", "", "g", tl.h.F, "i", "Lcom/qq/jce/wup/UniAttribute;", "attribute", "", QzoneIPCModule.RESULT_CODE, "", "e", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "onReceive", "obj", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "rspHeaderBean", "c", "(Lcom/qq/taf/jce/JceStruct;ILjava/lang/String;Lcom/tencent/biz/pubaccount/weishi/net/d;)V", "a", "d", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "f", "()Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/biz/pubaccount/weishi/net/common/a;", "Lcom/tencent/biz/pubaccount/weishi/net/common/a;", "getListener", "()Lcom/tencent/biz/pubaccount/weishi/net/common/a;", "listener", "Lcom/tencent/biz/pubaccount/weishi/net/common/i;", "Lcom/tencent/biz/pubaccount/weishi/net/common/i;", "decoder", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/net/common/g;Lcom/tencent/biz/pubaccount/weishi/net/common/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d<Rsp extends JceStruct> implements BusinessObserver, i.a<Rsp> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final g<Rsp> request;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a<Rsp, UniAttribute> listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private i<Rsp> decoder;

    public d(g<Rsp> request, a<Rsp, UniAttribute> listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.request = request;
        this.listener = listener;
        this.decoder = new i<>();
    }

    private final void e(UniAttribute attribute, int resultCode, String msg2) {
        x.f("[WSService][WSNetObserver]", "[doFailCallback]resultCode:" + resultCode + ", msg:" + msg2);
        if (o00.f.f421671a.a(resultCode).a(attribute, resultCode, msg2, this)) {
            return;
        }
        d(attribute, resultCode, msg2);
    }

    private final void g(FromServiceMsg msg2) {
        this.request.getTimeRecord().w();
        if (this.request.isNeedLaunchCalculator()) {
            f10.b.f397582a.m();
        }
        if (msg2 == null) {
            x.f("[WSService][WSNetObserver]", "[onDataResponse]" + this.request.getReqUniKey() + "MSF response is null");
            e(null, 1000000, "response is null");
            return;
        }
        i(msg2);
        if (msg2.getResultCode() != 1000) {
            h(msg2);
            return;
        }
        byte[] wupBuffer = msg2.getWupBuffer();
        if (wupBuffer != null) {
            this.request.respSize = wupBuffer.length;
        }
        String requestCmd = this.request.getRequestCmd();
        g<Rsp> gVar = this.request;
        x.i("[WSService][WSNetObserver]", "[onDataResponse]cmd=" + requestCmd + ", response size=" + gVar.respSize + ", request size=" + gVar.reqSize + ", cost=" + gVar.getTimeRecord().a());
        this.decoder.a(this.request, wupBuffer != null ? fh.a(wupBuffer) : null, msg2, this);
    }

    private final void h(FromServiceMsg msg2) {
        String businessFailMsg = msg2.getBusinessFailMsg();
        x.f("[WSService][WSNetObserver]", "[onDataResponse]errMsg:" + businessFailMsg);
        this.request.addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, "errMsg:" + businessFailMsg);
        e(null, msg2.getResultCode() + 300000, "");
    }

    private final void i(FromServiceMsg msg2) {
        List split$default;
        Object attribute = msg2.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS);
        if (attribute == null) {
            return;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) attribute.toString(), new String[]{":"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length > 1) {
            HashMap<Object, Object> hashMap = this.request.params;
            Intrinsics.checkNotNullExpressionValue(hashMap, "request.params");
            hashMap.put(ParamConstants.KEY_REQUEST_SERVER_IP, strArr[0]);
            HashMap<Object, Object> hashMap2 = this.request.params;
            Intrinsics.checkNotNullExpressionValue(hashMap2, "request.params");
            hashMap2.put(ParamConstants.KEY_REQUEST_SERVER_PORT, strArr[1]);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.i.a
    public void a(UniAttribute attribute, int resultCode, String msg2) {
        e(attribute, resultCode, msg2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.i.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(Rsp obj, int resultCode, String msg2, com.tencent.biz.pubaccount.weishi.net.d rspHeaderBean) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        x.f("[WSService][WSNetObserver]", "[doSuccessCallback] cmd:" + this.request.getCmdString() + ", retryCount:" + this.request.getRequestRetryCount());
        this.listener.b(obj, rspHeaderBean);
    }

    public final void d(UniAttribute attribute, int resultCode, String msg2) {
        this.listener.a(attribute, resultCode, msg2, null);
    }

    public final g<Rsp> f() {
        return this.request;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Object obj = bundle.get("response");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qphone.base.remote.FromServiceMsg");
        g((FromServiceMsg) obj);
    }
}
