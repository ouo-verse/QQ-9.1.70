package m92;

import appoint.define.appoint_define$InterestItem;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public Object b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        InterestTagInfo interestTagInfo = new InterestTagInfo();
        try {
            if (jSONObject.has("tagId")) {
                interestTagInfo.tagId = jSONObject.getLong("tagId");
            }
            if (jSONObject.has("tagName")) {
                interestTagInfo.tagName = jSONObject.getString("tagName");
            }
            if (jSONObject.has("tagIconUrl")) {
                interestTagInfo.tagIconUrl = jSONObject.getString("tagIconUrl");
            }
            if (jSONObject.has("tagJumpUrl")) {
                interestTagInfo.tagJumpUrl = jSONObject.getString("tagJumpUrl");
            }
            if (jSONObject.has("tagTextColor")) {
                interestTagInfo.tagTextColor = jSONObject.getString("tagTextColor");
            }
            if (jSONObject.has("tagBgColor")) {
                interestTagInfo.tagBgColor = jSONObject.getString("tagBgColor");
            }
            if (jSONObject.has("bid")) {
                interestTagInfo.bid = jSONObject.getLong("bid");
            }
            return interestTagInfo;
        } catch (JSONException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i("InterestTag", 2, e16.toString());
            return null;
        }
    }

    public Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        appoint_define$InterestItem appoint_define_interestitem = (appoint_define$InterestItem) obj;
        InterestTagInfo interestTagInfo = new InterestTagInfo();
        if (appoint_define_interestitem.str_tag_back_color.has()) {
            interestTagInfo.tagBgColor = appoint_define_interestitem.str_tag_back_color.get();
        }
        if (appoint_define_interestitem.str_tag_font_color.has()) {
            interestTagInfo.tagTextColor = appoint_define_interestitem.str_tag_font_color.get();
        }
        if (appoint_define_interestitem.str_tag_icon_url.has()) {
            interestTagInfo.tagIconUrl = appoint_define_interestitem.str_tag_icon_url.get();
        }
        if (appoint_define_interestitem.str_tag_name.has()) {
            interestTagInfo.tagName = appoint_define_interestitem.str_tag_name.get();
        }
        if (appoint_define_interestitem.str_tag_href.has()) {
            interestTagInfo.tagJumpUrl = appoint_define_interestitem.str_tag_href.get();
        }
        if (appoint_define_interestitem.uint64_tag_id.has()) {
            interestTagInfo.tagId = appoint_define_interestitem.uint64_tag_id.get();
        }
        if (appoint_define_interestitem.uint32_bid.has()) {
            interestTagInfo.bid = appoint_define_interestitem.uint32_bid.get();
        }
        return interestTagInfo;
    }
}
