package di0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Ldi0/b;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "d", "Ljava/lang/String;", "getBubbleText", "()Ljava/lang/String;", "setBubbleText", "(Ljava/lang/String;)V", "bubbleText", "", "e", "J", "getIntervals", "()J", "setIntervals", "(J)V", "intervals", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String bubbleText = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long intervals = 300;

    public final HashMap<String, Object> a() {
        HashMap<String, Object> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_BUYING_BUBBLE_TEXT", this.bubbleText), TuplesKt.to("PARAM_BUYING_BUBBLE_TIME_INTERVALS", Long.valueOf(this.intervals)));
        return hashMapOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0013 A[Catch: Exception -> 0x0021, TryCatch #0 {Exception -> 0x0021, blocks: (B:15:0x0002, B:3:0x000f, B:5:0x0013, B:6:0x001d), top: B:14:0x0002 }] */
    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean decodeData(JSONObject data) {
        String optString;
        if (data != null) {
            try {
                optString = data.optString("bullet_chat");
                if (optString != null) {
                    this.bubbleText = optString;
                    this.intervals = data == null ? data.optLong("intervals") : 0L;
                    return true;
                }
            } catch (Exception e16) {
                cg0.a.a("ECLiveBuyingBubbleRsp", "ECLiveBuyingBubbleRsp", "e: " + e16);
                return false;
            }
        }
        optString = "";
        this.bubbleText = optString;
        this.intervals = data == null ? data.optLong("intervals") : 0L;
        return true;
    }
}
