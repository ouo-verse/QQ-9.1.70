package lo2;

import com.tencent.mobileqq.search.util.SearchUtils;
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
public class j extends m {

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f415216b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415217c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f415218d0;

    /* renamed from: e0, reason: collision with root package name */
    public List<f> f415219e0;

    /* renamed from: f0, reason: collision with root package name */
    public f f415220f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f415221g0;

    public j(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public boolean N() {
        List<f> list = this.f415219e0;
        if (list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415216b0 = SearchUtils.i0(jSONObject.optString("firstLineText"));
            this.f415217c0 = jSONObject.optString("firstLineTextPostfix");
            JSONObject optJSONObject = jSONObject.optJSONObject("leftImage");
            if (optJSONObject != null) {
                this.f415220f0 = new f(optJSONObject.optString("url"), optJSONObject.optInt("type"));
            }
            this.f415221g0 = jSONObject.optInt("allHeight");
            JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
            if (optJSONArray != null) {
                this.f415219e0 = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    this.f415219e0.add(new f(optJSONObject2.optString("url"), optJSONObject2.optInt("type")));
                }
            }
            this.f415218d0 = jSONObject.optInt("imageTotalCount");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public j(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
