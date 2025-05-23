package cj0;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0005\bB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcj0/a;", "", "Lorg/json/JSONObject;", "data", "", "a", "", "J", "b", "()J", "setMediaProductId", "(J)V", "mediaProductId", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "d", "()Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "setResult", "(Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;)V", "result", "Lcj0/a$b;", "c", "Lcj0/a$b;", "()Lcj0/a$b;", "setRespMsgInfo", "(Lcj0/a$b;)V", "respMsgInfo", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mediaProductId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private k result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b respMsgInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcj0/a$b;", "", "", "a", "Z", "()Z", "setDisplay", "(Z)V", "display", "", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "c", "f", IECSearchBar.METHOD_SET_TEXT, "text", "d", "setLeftBtnText", "leftBtnText", "e", "setLeftBtnUrl", "leftBtnUrl", "setRightBtnText", "rightBtnText", "setRightBtnUrl", "rightBtnUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean display;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String leftBtnText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String leftBtnUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private String rightBtnText;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private String rightBtnUrl;

        public b(boolean z16, String str, String str2, String str3, String str4, String str5, String str6) {
            this.display = z16;
            this.title = str;
            this.text = str2;
            this.leftBtnText = str3;
            this.leftBtnUrl = str4;
            this.rightBtnText = str5;
            this.rightBtnUrl = str6;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDisplay() {
            return this.display;
        }

        /* renamed from: b, reason: from getter */
        public final String getLeftBtnText() {
            return this.leftBtnText;
        }

        /* renamed from: c, reason: from getter */
        public final String getLeftBtnUrl() {
            return this.leftBtnUrl;
        }

        /* renamed from: d, reason: from getter */
        public final String getRightBtnText() {
            return this.rightBtnText;
        }

        /* renamed from: e, reason: from getter */
        public final String getRightBtnUrl() {
            return this.rightBtnUrl;
        }

        /* renamed from: f, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }
    }

    public final boolean a(JSONObject data) {
        String optString;
        cg0.a.b("ECShowWindowAddProductRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.mediaProductId = data.optLong("media_product_id", 0L);
        JSONObject optJSONObject = data.optJSONObject("result");
        this.result = new k(optJSONObject != null ? optJSONObject.optInt("result_type", -1) : -1, (optJSONObject == null || (optString = optJSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "")) == null) ? "" : optString, null, null, 0, 28, null);
        JSONObject optJSONObject2 = data.optJSONObject("msg_box");
        if (optJSONObject2 == null) {
            return true;
        }
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("left_btn");
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("right_btn");
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        this.respMsgInfo = new b(optJSONObject2.optBoolean("display", false), optJSONObject2.optString("title", ""), optJSONObject2.optString("text", ""), optJSONObject3.optString("text", ""), optJSONObject3.optString("url", ""), optJSONObject4.optString("text", ""), optJSONObject4.optString("url", ""));
        return true;
    }

    /* renamed from: b, reason: from getter */
    public final long getMediaProductId() {
        return this.mediaProductId;
    }

    /* renamed from: c, reason: from getter */
    public final b getRespMsgInfo() {
        return this.respMsgInfo;
    }

    /* renamed from: d, reason: from getter */
    public final k getResult() {
        return this.result;
    }
}
