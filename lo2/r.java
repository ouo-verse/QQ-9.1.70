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
public class r extends m {

    /* renamed from: b0, reason: collision with root package name */
    public int f415252b0;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f415253c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415254d0;

    /* renamed from: e0, reason: collision with root package name */
    public CharSequence f415255e0;

    /* renamed from: f0, reason: collision with root package name */
    public CharSequence f415256f0;

    /* renamed from: g0, reason: collision with root package name */
    public List<f> f415257g0;

    /* renamed from: h0, reason: collision with root package name */
    public double f415258h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f415259i0;

    /* renamed from: j0, reason: collision with root package name */
    public double f415260j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f415261k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f415262l0;

    /* renamed from: m0, reason: collision with root package name */
    public List<String> f415263m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f415264n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f415265o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f415266p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f415267q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f415268r0;

    public r(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public int K(int i3) {
        if (i3 != 5) {
            return 1;
        }
        return i3;
    }

    @Override // lo2.m
    public boolean N() {
        return super.N();
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.W = jSONObject.optString("leftImageURL");
            boolean z17 = true;
            int optInt = jSONObject.optInt("leftImageType", 1);
            this.f415252b0 = optInt;
            this.f415252b0 = K(optInt);
            this.f415253c0 = SearchUtils.i0(jSONObject.optString("headText"));
            this.f415254d0 = jSONObject.optString("headLineIconURL");
            this.f415255e0 = SearchUtils.i0(jSONObject.optString("descLineText"));
            this.f415256f0 = SearchUtils.i0(jSONObject.optString("firstLineText"));
            JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
            if (optJSONArray != null) {
                this.f415257g0 = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    this.f415257g0.add(new f(optJSONObject.optString("url"), optJSONObject.optInt("type")));
                }
            }
            this.f415258h0 = jSONObject.optDouble("imageAspectRatio", 1.0d);
            this.f415260j0 = jSONObject.optDouble("singleImageScale", 1.0d);
            this.f415259i0 = jSONObject.optInt("imageTotalCount");
            if (jSONObject.optInt("topNeedHigherMargin", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f415261k0 = z16;
            if (jSONObject.optInt("needCornerRadius", 0) != 1) {
                z17 = false;
            }
            this.f415262l0 = z17;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("dynamicLineImageList");
            if (optJSONArray2 != null) {
                this.f415263m0 = new ArrayList(optJSONArray2.length());
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    this.f415263m0.add(optJSONArray2.optJSONObject(i16).optString("url"));
                }
            }
            this.f415264n0 = jSONObject.optString("dynamicLineLeftText");
            this.f415265o0 = jSONObject.optString("dynamicLineZanIconUrl");
            this.f415266p0 = jSONObject.optString("dynamicLineZanText");
            this.f415267q0 = jSONObject.optString("dynamicLineCommentIconUrl");
            this.f415268r0 = jSONObject.optString("dynamicLineCommentText");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public r(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
