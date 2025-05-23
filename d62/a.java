package d62;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements y52.a {

    /* renamed from: a, reason: collision with root package name */
    public String f393126a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f393127b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f393128c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f393129d = 1;

    /* renamed from: e, reason: collision with root package name */
    public String f393130e = IPublicAccountConfigUtil.READINJOY_SEARCH_JUMP_URL_DEFAULT;

    @Override // y52.a
    public void a(String str) {
        this.f393126a = str;
    }

    @Override // y52.a
    public void b(String str) {
        this.f393130e = str;
    }

    @Override // y52.a
    public String c() {
        return this.f393130e;
    }

    @Override // y52.a
    public void d(String str) {
        this.f393128c = str;
    }

    @Override // y52.a
    public void e(String str) {
        this.f393127b = str;
    }

    @Override // y52.a
    public String f() {
        return this.f393126a;
    }

    @Override // y52.a
    public void g(Integer num) {
        this.f393129d = num.intValue();
    }

    public y52.a h(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.a(jSONObject.optString("kQQPASearchDiscoverPageUrl"));
            aVar.e(jSONObject.optString("kQQPASearchListTitleIconUrl"));
            aVar.d(jSONObject.optString("kQQPAClickAssociationalWordWebUrl"));
            aVar.g(Integer.valueOf(jSONObject.optInt("kQQPAClickAssociationalWordToWebSearch", 1)));
            if (QLog.isColorLevel()) {
                QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data json = ", str);
            }
            aVar.b(jSONObject.optString("kQQPASearchJumpUrl", IPublicAccountConfigUtil.READINJOY_SEARCH_JUMP_URL_DEFAULT));
            if (QLog.isColorLevel()) {
                QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). readinjoy_search_jump_url=" + aVar.c() + ", discoveryPageUrl = " + aVar.f());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ReadInjoySearchJumpurlConfBean", 2, "loadPublicAccountCenterUrlConfig error", e16);
            }
            aVar.b(IPublicAccountConfigUtil.READINJOY_SEARCH_JUMP_URL_DEFAULT);
            if (QLog.isColorLevel()) {
                QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). use the default url. exception=" + e16.getStackTrace());
            }
        }
        return aVar;
    }

    public String toString() {
        return "kQQPASearchDiscoverPageUrl = " + this.f393126a + "kQQPASearchListTitleIconUrl = " + this.f393127b + "kQQPAClickAssociationalWordWebUrl = " + this.f393128c + "kQQPAClickAssociationalWordToWebSearch = " + this.f393129d + "kQQPASearchJumpUrl = " + this.f393130e;
    }
}
