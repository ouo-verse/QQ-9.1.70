package lo2;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends m {

    /* renamed from: j0, reason: collision with root package name */
    public static final String f415241j0 = LogTag.TAG_UNITE_SEARCH + n.class.getSimpleName();

    /* renamed from: b0, reason: collision with root package name */
    public int f415242b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415243c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f415244d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f415245e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415246f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f415247g0;

    /* renamed from: h0, reason: collision with root package name */
    public CharSequence f415248h0;

    /* renamed from: i0, reason: collision with root package name */
    public CharSequence f415249i0;

    public n(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
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
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415242b0 = jSONObject.optInt("bannerImageType");
            this.f415243c0 = jSONObject.optString("bannerImageUrl");
            this.f415244d0 = (float) jSONObject.optDouble("bannerImageWidth");
            this.f415245e0 = (float) jSONObject.optDouble("bannerImageHeight");
            this.f415246f0 = jSONObject.optString("topLeftTagText");
            this.f415247g0 = jSONObject.optString("topLeftTagColor");
            this.f415248h0 = jSONObject.optString("firstLineText");
            this.f415249i0 = jSONObject.optString("secondLineText");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f415241j0, 2, QLog.getStackTraceString(e16));
            }
        }
    }

    public n(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
