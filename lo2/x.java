package lo2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x extends m {

    /* renamed from: i0, reason: collision with root package name */
    public static final String f415301i0 = w.class.getSimpleName();

    /* renamed from: b0, reason: collision with root package name */
    public String f415302b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415303c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415304d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f415305e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415306f0;

    /* renamed from: g0, reason: collision with root package name */
    public List<al> f415307g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f415308h0;

    private List<al> W(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                al alVar = new al(optJSONObject.optString("word"), optJSONObject.optString("url"));
                if (alVar.a()) {
                    arrayList.add(alVar);
                }
            }
        }
        return arrayList;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        this.f283549m = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415302b0 = jSONObject.optString("leftIconUrl");
            this.f415303c0 = jSONObject.optString("title");
            this.f415304d0 = jSONObject.optString("summary");
            this.f415305e0 = jSONObject.optBoolean("isShowArrow");
            this.f415306f0 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            this.f415308h0 = jSONObject.optString("subItemLeftIconUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
            if (optJSONArray != null) {
                this.f415307g0 = W(optJSONArray);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f415301i0, 2, QLog.getStackTraceString(e16));
            }
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.J == 1101) {
            return this.f415303c0 + this.N;
        }
        return super.getTitleSpans();
    }
}
