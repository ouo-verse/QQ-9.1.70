package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.stRecommandAlbumEx;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RecomAlbumExData implements SmartParcelable {

    @NeedParcel
    public AlbumCacheData albumInfo;

    @NeedParcel
    public ArrayList<s_picdata> photolist;

    @NeedParcel
    public int commentCnt = 0;

    @NeedParcel
    public int likeCnt = 0;

    @NeedParcel
    public int viewCount = 0;

    public static RecomAlbumExData createFromResponse(stRecommandAlbumEx strecommandalbumex) {
        if (strecommandalbumex == null) {
            return null;
        }
        RecomAlbumExData recomAlbumExData = new RecomAlbumExData();
        recomAlbumExData.albumInfo = AlbumCacheData.createFromResponse(strecommandalbumex.albuminfo);
        recomAlbumExData.commentCnt = strecommandalbumex.commentCnt;
        recomAlbumExData.likeCnt = strecommandalbumex.likeCnt;
        recomAlbumExData.photolist = strecommandalbumex.photolist;
        recomAlbumExData.viewCount = strecommandalbumex.viewCnt;
        return recomAlbumExData;
    }
}
