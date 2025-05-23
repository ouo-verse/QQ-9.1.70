package mh0;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.base.network.json.IgnoreFailureTypeAdapterFactory;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.repo.consumer.resp.Advertisement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lmh0/b;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "Ljava/lang/String;", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "contentId", "", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "e", "Ljava/util/List;", "b", "()Ljava/util/List;", "setAds", "(Ljava/util/List;)V", "ads", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "f", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "content", "<init>", "(Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "i", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String contentId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<Advertisement> ads;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ECContentInfo content;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Gson f416768h = new GsonBuilder().setLenient().registerTypeAdapterFactory(new IgnoreFailureTypeAdapterFactory()).create();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lmh0/b$a;", "", "", "adsJson", "", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "a", "TAG", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: mh0.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"mh0/b$a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "Lkotlin/collections/ArrayList;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: mh0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class C10785a extends TypeToken<ArrayList<Advertisement>> {
            C10785a() {
            }
        }

        Companion() {
        }

        public final List<Advertisement> a(String adsJson) {
            List<Advertisement> emptyList;
            List<Advertisement> emptyList2;
            if (TextUtils.isEmpty(adsJson)) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            try {
                return (List) b.f416768h.fromJson(adsJson, new C10785a().getType());
            } catch (Exception e16) {
                cg0.a.a("QQECGoodsAdResponse", "parseAds", "error:" + e16.getLocalizedMessage());
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(ECContentInfo eCContentInfo) {
        List<Advertisement> emptyList;
        this.content = eCContentInfo;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.ads = emptyList;
    }

    public final List<Advertisement> b() {
        return this.ads;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("QQECGoodsAdResponse", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("ad");
        if (optJSONObject == null) {
            return true;
        }
        this.contentId = optJSONObject.optString("content_id");
        this.ads = INSTANCE.a(optJSONObject.optString("ads"));
        return true;
    }
}
