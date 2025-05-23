package lo2;

import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae extends m {

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f415110b0;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f415111c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415112d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f415113e0;

    public ae(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415110b0 = SearchUtils.q(jSONObject.optJSONArray("leftText"));
            this.f415111c0 = SearchUtils.q(jSONObject.optJSONArray("rightText"));
            this.f415112d0 = jSONObject.optString("bgColor");
            int optInt = jSONObject.optInt("needCenter");
            boolean z16 = true;
            if (optInt != 1) {
                z16 = false;
            }
            this.f415113e0 = z16;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(m.f415228a0, 2, e16.toString());
            }
        }
    }

    public ae(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
