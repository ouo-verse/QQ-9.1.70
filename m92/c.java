package m92;

import appoint.define.appoint_define$InterestItem;
import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    public a b(JSONObject jSONObject) {
        InterestTagInfo interestTagInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a(jSONObject.has("tagType") ? jSONObject.getInt("tagType") : 0);
            JSONArray jSONArray = jSONObject.has("tagInfos") ? jSONObject.getJSONArray("tagInfos") : null;
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2 != null && (interestTagInfo = (InterestTagInfo) ((IInterestTagInfoUtils) QRoute.api(IInterestTagInfoUtils.class)).convertFrom(jSONObject2)) != null) {
                        aVar.f416459b.add(interestTagInfo);
                    }
                }
            }
            return aVar;
        } catch (JSONException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i(LogTag.NEARBY_PEOPLE_CARD, 2, e16.toString());
            return null;
        }
    }

    public a a(appoint_define$InterestTag appoint_define_interesttag) {
        if (appoint_define_interesttag == null) {
            return null;
        }
        a aVar = new a(appoint_define_interesttag.uint32_tag_type.get());
        List<appoint_define$InterestItem> list = appoint_define_interesttag.rpt_msg_tag_list.get();
        if (list == null || list.size() <= 0) {
            return aVar;
        }
        Iterator<appoint_define$InterestItem> it = list.iterator();
        while (it.hasNext()) {
            InterestTagInfo interestTagInfo = (InterestTagInfo) ((IInterestTagInfoUtils) QRoute.api(IInterestTagInfoUtils.class)).convertFrom(it.next());
            if (interestTagInfo != null) {
                aVar.f416459b.add(interestTagInfo);
            }
        }
        return aVar;
    }
}
