package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.guide_button;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GuideButton implements SmartParcelable {

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public String buttonTitle;

    @NeedParcel
    public String picUrl;

    public static ArrayList<GuideButton> fromSGuideButtonList(ArrayList<guide_button> arrayList) {
        ArrayList<GuideButton> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<guide_button> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(com.qzone.proxy.feedcomponent.util.e.h(it.next()));
            }
        }
        return arrayList2;
    }
}
