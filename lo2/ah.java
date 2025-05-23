package lo2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ah extends m {

    /* renamed from: g0, reason: collision with root package name */
    public static final String f415119g0 = "ah";

    /* renamed from: b0, reason: collision with root package name */
    public String f415120b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415121c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415122d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f415123e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415124f0;

    public ah(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415120b0 = jSONObject.optString("leftIcon");
            this.f415121c0 = jSONObject.optString("firstTitle");
            this.f415122d0 = jSONObject.optString("secondTitle");
            this.f415123e0 = jSONObject.optString("moreText");
            this.f415124f0 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f415119g0, 2, e16.toString());
            }
        }
    }

    public ah(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
