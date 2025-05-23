package lo2;

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
public class y extends m {

    /* renamed from: f0, reason: collision with root package name */
    public static final String f415309f0 = "y";

    /* renamed from: b0, reason: collision with root package name */
    public String f415310b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f415311c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f415312d0;

    /* renamed from: e0, reason: collision with root package name */
    public List<a> f415313e0;

    public y(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f415310b0 = jSONObject.optString("askIcon");
            this.f415311c0 = jSONObject.optString("headLine");
            this.f415312d0 = jSONObject.optString("answerNumText");
            JSONArray optJSONArray = jSONObject.optJSONArray("answers");
            if (optJSONArray != null) {
                this.f415313e0 = new ArrayList(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    String optString = optJSONObject.optString("leftIcon");
                    String optString2 = optJSONObject.optString("userNameText");
                    String optString3 = optJSONObject.optString("praiseText");
                    String optString4 = optJSONObject.optString("answerText");
                    int optInt = optJSONObject.optInt("imageTotalCount");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("imageList");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray2 != null) {
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i16);
                            arrayList.add(new f(optJSONObject2.optString("url"), optJSONObject2.optInt("type")));
                        }
                    }
                    this.f415313e0.add(new a(optString, optString2, optString3, optString4, optInt, arrayList));
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f415309f0, 2, QLog.getStackTraceString(e16));
            }
        }
    }

    public y(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
