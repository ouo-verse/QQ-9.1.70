package com.qzone.feed.business.model;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class ViewFeedPhotoData implements SmartParcelable {
    public static int DEFAULT_SOURCE = 0;
    public static int FROM_COMMENT = 1;

    @NeedParcel
    public int commentNum;

    @NeedParcel
    public int curIndex;

    @NeedParcel
    public BusinessFeedData feedData;

    @NeedParcel
    public int likeNum;

    @NeedParcel
    public CellPictureInfo pictureInfo;

    @NeedParcel
    public boolean isLike = false;

    @NeedParcel
    public String curKey = "";

    @NeedParcel
    public String orgKey = "";

    @NeedParcel
    public String feedId = "";

    @NeedParcel
    public String cell_id = "";

    @NeedParcel
    public int cell_commSubId = 0;

    @NeedParcel
    public String cell_subId = "";

    @NeedParcel
    public int appid = 4;

    @NeedParcel
    public int photoSource = DEFAULT_SOURCE;

    @NeedParcel
    public boolean isMyFeed = false;

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();
}
