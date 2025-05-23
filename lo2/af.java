package lo2;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class af extends m {

    /* renamed from: b0, reason: collision with root package name */
    public String f415114b0;

    public af(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        super(str, j3, list, dynamicSearch$ResultItem, i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            this.f415114b0 = new JSONObject(str).optString("title");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(m.f415228a0, 2, e16.toString());
            }
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public String getTitleSpans() {
        return this.f415114b0;
    }

    public af(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
    }
}
