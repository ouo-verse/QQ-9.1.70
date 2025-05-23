package com.qzone.reborn.layer.recommendphoto;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.reborn.bean.QZoneInitBean;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerRecommendPhotoBean extends QZoneInitBean {
    public List<AlbumCacheData> albumCacheDataList;
    public String albumOwnerTitle;
    public long albumOwnerUin;
    public String backgroundUrl;
    public boolean isDataIllegal;
    public boolean isDefaultStyle;
    public boolean isShowHasMoreBtn;
    public String moreBtnText;
    public RecomAlbumList recomAlbumList;
    public int refer;
    public boolean isShowBackView = true;
    public boolean isShowUserHomeEntrance = true;
    public boolean isShowUserIcon = true;
    public String layerAlbumId = "";
    public String layerAlbumName = "";
    public HashMap<String, Object> extraParams = new HashMap<>();
}
