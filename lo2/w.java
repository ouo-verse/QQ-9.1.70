package lo2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w extends m {

    /* renamed from: h0, reason: collision with root package name */
    public static final String f415294h0 = "w";

    /* renamed from: b0, reason: collision with root package name */
    public String f415295b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415296c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415297d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f415298e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415299f0;

    /* renamed from: g0, reason: collision with root package name */
    public List<i> f415300g0;

    public w(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415295b0 = jSONObject.optString("leftIconUrl");
            this.f415296c0 = jSONObject.optString("title");
            this.f415297d0 = jSONObject.optString("summary");
            this.f415298e0 = jSONObject.optString("rightIconUrl");
            this.f415299f0 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            JSONArray optJSONArray = jSONObject.optJSONArray("pageInfo");
            if (optJSONArray != null) {
                this.f415300g0 = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    this.f415300g0.add(new i(optJSONObject.optString("leftIconUrl"), optJSONObject.optString("wording")));
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f415294h0, 2, QLog.getStackTraceString(e16));
            }
        }
    }

    public w(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
