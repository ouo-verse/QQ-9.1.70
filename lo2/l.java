package lo2;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l extends m {

    /* renamed from: g0, reason: collision with root package name */
    public static final String f415222g0 = LogTag.TAG_UNITE_SEARCH + l.class.getSimpleName();

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f415223b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f415224c0;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f415225d0;

    /* renamed from: e0, reason: collision with root package name */
    public CharSequence f415226e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415227f0;

    public l(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public int K(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return i3;
            default:
                return 1;
        }
    }

    @Override // lo2.m
    public boolean N() {
        return true;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.W = jSONObject.optString("leftImageURL");
            int optInt = jSONObject.optInt("leftImageType", 1);
            this.f415224c0 = optInt;
            this.f415224c0 = K(optInt);
            this.f415227f0 = SearchUtils.i0(jSONObject.optString("leftImageTagText"));
            this.f415223b0 = SearchUtils.i0(jSONObject.optString("firstLineText"));
            this.f415225d0 = SearchUtils.i0(jSONObject.optString("secondLineText"));
            this.f415226e0 = SearchUtils.q(jSONObject.optJSONArray("thirdLineText"));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public l(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
