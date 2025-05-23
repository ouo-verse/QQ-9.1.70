package com.qzone.common.event.ui.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.open.base.MD5Utils;

/* loaded from: classes39.dex */
public class PublishEventTag implements SmartParcelable {

    @NeedParcel
    public String advId;

    @NeedParcel
    public String desc;

    @NeedParcel
    public int descTruncateNum;

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f45886id;

    @NeedParcel
    public String picUrl;

    /* renamed from: protocol, reason: collision with root package name */
    @NeedParcel
    public String f45887protocol;

    @NeedParcel
    public String time;

    @NeedParcel
    public String title;

    @NeedParcel
    public String uin;

    public static PublishEventTag assembleFakeTag(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = str;
        publishEventTag.uin = str2;
        publishEventTag.f45887protocol = str2 + "_102_" + str;
        publishEventTag.f45886id = MD5Utils.toMD5(str);
        return publishEventTag;
    }
}
