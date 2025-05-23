package com.tencent.mobileqq.nearby.interestTag.impl;

import appoint.define.appoint_define$InterestItem;
import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.Iterator;
import m92.a;
import m92.c;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterestTagUtilsImpl implements IInterestTagUtils {
    public static final String TAG = "InterestTagUtilsImpl";
    private final c mInterestTagUtils = new c();

    @Override // com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils
    public Object convertTo(a aVar) {
        appoint_define$InterestTag appoint_define_interesttag = new appoint_define$InterestTag();
        appoint_define_interesttag.uint32_tag_type.set(aVar.f416458a);
        if (aVar.f416459b.size() > 0) {
            Iterator<InterestTagInfo> it = aVar.f416459b.iterator();
            while (it.hasNext()) {
                InterestTagInfo next = it.next();
                if (next != null) {
                    appoint_define$InterestItem appoint_define_interestitem = new appoint_define$InterestItem();
                    appoint_define_interestitem.uint64_tag_id.set(next.tagId);
                    String str = next.tagName;
                    if (str != null) {
                        appoint_define_interestitem.str_tag_name.set(str);
                    }
                    String str2 = next.tagBgColor;
                    if (str2 != null) {
                        appoint_define_interestitem.str_tag_back_color.set(str2);
                    }
                    String str3 = next.tagTextColor;
                    if (str3 != null) {
                        appoint_define_interestitem.str_tag_font_color.set(str3);
                    }
                    String str4 = next.tagJumpUrl;
                    if (str4 != null) {
                        appoint_define_interestitem.str_tag_href.set(str4);
                    }
                    String str5 = next.tagIconUrl;
                    if (str5 != null) {
                        appoint_define_interestitem.str_tag_icon_url.set(str5);
                    }
                    appoint_define_interesttag.rpt_msg_tag_list.add(appoint_define_interestitem);
                }
            }
        }
        return appoint_define_interesttag;
    }

    @Override // com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils
    public a convertFrom(Object obj) {
        return this.mInterestTagUtils.a((appoint_define$InterestTag) obj);
    }

    @Override // com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils
    public a convertFromJSONObject(JSONObject jSONObject) {
        return this.mInterestTagUtils.b(jSONObject);
    }
}
