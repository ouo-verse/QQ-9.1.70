package com.tencent.ecommerce.biz.showwindow.repo.window;

import ck0.Category;
import ck0.Product;
import com.tencent.ecommerce.base.network.api.IECResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 \u001f2\u00020\u0001:\u0002\u0010\tB\u001b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/d;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;", "d", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;", "b", "()Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;", "setProductListRsp", "(Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;)V", "productListRsp", "e", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "f", "Z", "isShowAddBtn", tl.h.F, "isEdited", "()Z", "setEdited", "(Z)V", "<init>", "(ZZ)V", "i", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d implements IECResponse {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b productListRsp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private JSONObject dataJson;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAddBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isEdited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$a;", "", "Lorg/json/JSONObject;", "data", "", "isShowAddBtn", "isEdited", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.repo.window.d$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(JSONObject data, boolean isShowAddBtn, boolean isEdited) {
            ArrayList<Product> e16;
            b bVar = new b();
            int i3 = 0;
            bVar.l(data.optInt("total", 0));
            bVar.i(data.optString("cookie", ""));
            bVar.j(data.optBoolean("is_end", false));
            JSONArray optJSONArray = data.optJSONArray("products");
            if (optJSONArray != null) {
                e16 = fj0.c.f399474a.e(optJSONArray, (r13 & 2) != 0 ? false : isShowAddBtn, (r13 & 4) != 0 ? false : isEdited, true, (r13 & 16) != 0 ? false : false);
                bVar.k(e16);
            }
            JSONArray optJSONArray2 = data.optJSONArray("category_list");
            if (optJSONArray2 != null) {
                ArrayList<Category> arrayList = new ArrayList<>();
                int length = optJSONArray2.length();
                int i16 = 0;
                while (i16 < length) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i16);
                    arrayList.add(new Category(optJSONObject.optLong("id", 0L), optJSONObject.optString("name", ""), optJSONObject.optInt("goods_type", i3), false, 8, null));
                    i16++;
                    i3 = 0;
                }
                bVar.h(arrayList);
            }
            JSONArray optJSONArray3 = data.optJSONArray("banners");
            if (optJSONArray3 != null) {
                ArrayList<ck0.a> arrayList2 = new ArrayList<>();
                int length2 = optJSONArray3.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i17);
                    ck0.a aVar = new ck0.a(optJSONObject2.optString("title", ""), optJSONObject2.optString("desc", ""), optJSONObject2.optString("pic", ""), optJSONObject2.optString("url", ""));
                    if (!aVar.b()) {
                        break;
                    }
                    arrayList2.add(aVar);
                }
                int size = arrayList2.size();
                if (1 <= size && 2 >= size) {
                    bVar.g(arrayList2);
                }
            }
            return bVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0019j\b\u0012\u0004\u0012\u00020\"`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u000b\u0010\u001e\"\u0004\b#\u0010 R2\u0010'\u001a\u0012\u0012\u0004\u0012\u00020%0\u0019j\b\u0012\u0004\u0012\u00020%`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u0003\u0010\u001e\"\u0004\b&\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/d$b;", "", "", "a", "I", "e", "()I", "l", "(I)V", "total", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "cookie", "", "Z", "f", "()Z", "j", "(Z)V", "isEnd", "Ljava/util/ArrayList;", "Lck0/c;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "k", "(Ljava/util/ArrayList;)V", "productList", "Lck0/b;", tl.h.F, "categoryList", "Lck0/a;", "g", "bannerList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int total;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isEnd;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String cookie = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private ArrayList<Product> productList = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ArrayList<Category> categoryList = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private ArrayList<ck0.a> bannerList = new ArrayList<>();

        public final ArrayList<ck0.a> a() {
            return this.bannerList;
        }

        public final ArrayList<Category> b() {
            return this.categoryList;
        }

        /* renamed from: c, reason: from getter */
        public final String getCookie() {
            return this.cookie;
        }

        public final ArrayList<Product> d() {
            return this.productList;
        }

        /* renamed from: e, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        public final void g(ArrayList<ck0.a> arrayList) {
            this.bannerList = arrayList;
        }

        public final void h(ArrayList<Category> arrayList) {
            this.categoryList = arrayList;
        }

        public final void i(String str) {
            this.cookie = str;
        }

        public final void j(boolean z16) {
            this.isEnd = z16;
        }

        public final void k(ArrayList<Product> arrayList) {
            this.productList = arrayList;
        }

        public final void l(int i3) {
            this.total = i3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: b, reason: from getter */
    public final b getProductListRsp() {
        return this.productListRsp;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        this.dataJson = data;
        cg0.a.b("ECShowWindowGetProductListRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.productListRsp = INSTANCE.a(data, this.isShowAddBtn, this.isEdited);
        return true;
    }

    public d(boolean z16, boolean z17) {
        this.isShowAddBtn = z16;
        this.isEdited = z17;
    }

    public /* synthetic */ d(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }
}
