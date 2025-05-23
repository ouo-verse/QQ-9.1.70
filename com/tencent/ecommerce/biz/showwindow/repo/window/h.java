package com.tencent.ecommerce.biz.showwindow.repo.window;

import ck0.Product;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ,2\u00020\u0001:\u0001\u0011B\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR2\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b'\u0010\u0014R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/h;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "I", "c", "()I", "setTotal", "(I)V", "total", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setCookie", "(Ljava/lang/String;)V", "cookie", "f", "Z", "()Z", "setEnd", "(Z)V", "isEnd", "Ljava/util/ArrayList;", "Lck0/c;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setProductList", "(Ljava/util/ArrayList;)V", "productList", "i", "setWindowTitle", "windowTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNight", "<init>", BdhLogUtil.LogTag.Tag_Conn, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String cookie;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Product> productList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String windowTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isNight;

    public h() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    public final ArrayList<Product> b() {
        return this.productList;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: d, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        ArrayList<Product> e16;
        cg0.a.b("ECShowWindowViewProductListRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.total = data.optInt("total", 0);
        this.cookie = data.optString("cookie", "");
        this.isEnd = data.optBoolean("is_end", false);
        this.windowTitle = data.optString("title", "");
        JSONArray optJSONArray = data.optJSONArray("products");
        if (optJSONArray == null) {
            return true;
        }
        e16 = fj0.c.f399474a.e(optJSONArray, (r13 & 2) != 0 ? false : false, (r13 & 4) != 0 ? false : false, false, (r13 & 16) != 0 ? false : this.isNight);
        this.productList = e16;
        return true;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public h(boolean z16) {
        this.isNight = z16;
        this.cookie = "";
        this.productList = new ArrayList<>();
        this.windowTitle = "";
    }

    public /* synthetic */ h(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
