package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.comm_page_info;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShareAlbumMemberCacheData implements Serializable, SmartParcelable {

    @NeedParcel
    public comm_page_info page;

    @NeedParcel
    public ArrayList<s_picdata> photos;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public String nick = "";

    @NeedParcel
    public long photo_cnt = 0;

    @NeedParcel
    public long video_cnt = 0;
}
