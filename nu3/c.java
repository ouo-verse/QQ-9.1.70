package nu3;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lnu3/c;", "Lnu3/a;", "Lorg/json/JSONObject;", "dataObj", "<init>", "(Lorg/json/JSONObject;)V", "d", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(JSONObject dataObj) {
        super(dataObj);
        String str;
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        if (dataObj.has(PushClientConstants.TAG_CLASS_NAME)) {
            str = dataObj.getString(PushClientConstants.TAG_CLASS_NAME);
        } else {
            ee4.b.b("ObjCreateTavEvent", "send msg but no object");
            str = "";
        }
        g(str);
    }
}
