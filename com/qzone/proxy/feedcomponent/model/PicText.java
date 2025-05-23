package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PicText implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public String descBeforeClick;

    @NeedParcel
    public String descPostClick;

    @NeedParcel
    public String extraInfo;

    @NeedParcel
    public PictureItem pictureItem;

    @NeedParcel
    public String playurl = "";

    @NeedParcel
    public String postFix;

    @NeedParcel
    public String strHeader;

    @NeedParcel
    public String summary;

    @NeedParcel
    public String title;

    @NeedParcel
    public ArrayList<User> userList;
}
