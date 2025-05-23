package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.s_outshare;
import com.qzone.proxy.feedcomponent.model.ArkInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.e;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumDataOutShare implements SmartParcelable {

    @NeedParcel
    public Map<Integer, PictureUrl> mapPhotoUrl;

    @NeedParcel
    public String weixinUrl = "";

    @NeedParcel
    public String qqUrl = "";

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String summary = "";

    @NeedParcel
    public int spaceRight = 0;

    @NeedParcel
    public int albumRight = 1;

    @NeedParcel
    public String xcx_share_path = "";

    @NeedParcel
    public String xcx_name = "";

    @NeedParcel
    public String md5 = "";

    @NeedParcel
    public ArkInfo ark = null;

    public static AlbumDataOutShare createFrom(s_outshare s_outshareVar) {
        if (s_outshareVar == null) {
            return null;
        }
        AlbumDataOutShare albumDataOutShare = new AlbumDataOutShare();
        albumDataOutShare.weixinUrl = s_outshareVar.weixin_url;
        albumDataOutShare.qqUrl = s_outshareVar.qq_url;
        albumDataOutShare.title = s_outshareVar.title;
        albumDataOutShare.summary = s_outshareVar.summary;
        albumDataOutShare.spaceRight = s_outshareVar.space_right;
        albumDataOutShare.albumRight = s_outshareVar.album_right;
        albumDataOutShare.xcx_name = s_outshareVar.xcx_name;
        albumDataOutShare.xcx_share_path = s_outshareVar.xcx_share_path;
        albumDataOutShare.md5 = s_outshareVar.md5;
        if (s_outshareVar.ark_sharedata != null) {
            ArkInfo arkInfo = new ArkInfo();
            s_arkshare s_arkshareVar = s_outshareVar.ark_sharedata;
            arkInfo.arkContent = s_arkshareVar.ark_content;
            arkInfo.arkId = s_arkshareVar.ark_id;
            arkInfo.viewId = s_arkshareVar.view_id;
            albumDataOutShare.ark = arkInfo;
        }
        Map<Integer, s_picurl> map = s_outshareVar.photourl;
        if (map != null && map.size() > 0) {
            albumDataOutShare.mapPhotoUrl = new HashMap();
            for (Map.Entry<Integer, s_picurl> entry : s_outshareVar.photourl.entrySet()) {
                albumDataOutShare.mapPhotoUrl.put(entry.getKey(), e.n(entry.getValue()));
            }
        }
        return albumDataOutShare;
    }
}
