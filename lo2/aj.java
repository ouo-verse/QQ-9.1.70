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
public class aj extends m {

    /* renamed from: b0, reason: collision with root package name */
    public int f415146b0;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f415147c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415148d0;

    /* renamed from: e0, reason: collision with root package name */
    public CharSequence f415149e0;

    /* renamed from: f0, reason: collision with root package name */
    public CharSequence f415150f0;

    /* renamed from: g0, reason: collision with root package name */
    public List<f> f415151g0;

    /* renamed from: h0, reason: collision with root package name */
    public double f415152h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f415153i0;

    /* renamed from: j0, reason: collision with root package name */
    public double f415154j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f415155k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f415156l0;

    public aj(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public int K(int i3) {
        if (i3 != 1 && i3 != 5) {
            return 1;
        }
        return i3;
    }

    @Override // lo2.m
    public boolean N() {
        return true;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.W = jSONObject.optString("leftImageURL");
            boolean z17 = true;
            int optInt = jSONObject.optInt("leftImageType", 1);
            this.f415146b0 = optInt;
            this.f415146b0 = K(optInt);
            this.f415147c0 = SearchUtils.i0(jSONObject.optString("headText"));
            this.f415148d0 = jSONObject.optString("headLineIconURL");
            this.f415149e0 = SearchUtils.i0(jSONObject.optString("descLineText"));
            this.f415150f0 = SearchUtils.i0(jSONObject.optString("firstLineText"));
            JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
            if (optJSONArray != null) {
                this.f415151g0 = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    this.f415151g0.add(new f(optJSONObject.optString("url"), optJSONObject.optInt("type")));
                }
            }
            this.f415152h0 = jSONObject.optDouble("imageAspectRatio", 1.0d);
            this.f415154j0 = jSONObject.optDouble("singleImageScale", 1.0d);
            this.f415153i0 = jSONObject.optInt("imageTotalCount");
            if (jSONObject.optInt("topNeedHigherMargin", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f415155k0 = z16;
            if (jSONObject.optInt("needCornerRadius", 0) != 1) {
                z17 = false;
            }
            this.f415156l0 = z17;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public aj(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
