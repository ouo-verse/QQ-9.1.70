package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;

/* loaded from: classes39.dex */
public class PictureItemRecent extends PictureItem {

    @NeedParcel
    public int appid;

    @NeedParcel
    public boolean isLike;

    @NeedParcel
    public String curKey = "";

    @NeedParcel
    public String orgKey = "";

    @NeedParcel
    public String feedId = "";

    @NeedParcel
    public String cell_id = "";

    @NeedParcel
    public String cell_subId = "";

    @NeedParcel
    public int indexInfeed = -1;
}
