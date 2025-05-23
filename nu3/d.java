package nu3;

import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.q;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lnu3/d;", "Lnu3/a;", "", "d", "Ljava/lang/Object;", tl.h.F, "()Ljava/lang/Object;", "setTargetObj", "(Ljava/lang/Object;)V", "targetObj", "Lorg/json/JSONObject;", "dataObj", "<init>", "(Lorg/json/JSONObject;)V", "e", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Object targetObj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JSONObject dataObj) {
        super(dataObj);
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        if (dataObj.has(PushClientConstants.TAG_CLASS_NAME)) {
            g(dataObj.getString(PushClientConstants.TAG_CLASS_NAME));
            return;
        }
        if (dataObj.has("tavobject")) {
            Object a16 = g.f421341a.a(c(dataObj));
            this.targetObj = a16;
            if (a16 != null) {
                g(q.f347998a.a(Reflection.getOrCreateKotlinClass(a16.getClass()).getSimpleName()));
                return;
            }
            return;
        }
        ee4.b.b("SendMsgTavEvent", "send msg but no object");
    }

    /* renamed from: h, reason: from getter */
    public final Object getTargetObj() {
        return this.targetObj;
    }
}
