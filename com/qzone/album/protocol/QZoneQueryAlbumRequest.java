package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.get_album_req;
import NS_MOBILE_PHOTO.get_album_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.common.account.LoginData;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQueryAlbumRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "queryAlbum";
    private static final String TAG = "QZoneQueryAlbumRequest";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public AlbumSocialInfoCacheData f43972a;

        /* renamed from: b, reason: collision with root package name */
        public BusinessAlbumInfo f43973b;

        /* renamed from: c, reason: collision with root package name */
        public AlbumCacheData f43974c;
    }

    public QZoneQueryAlbumRequest(get_album_req get_album_reqVar) {
        super(CMD_STRING);
        this.req = get_album_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public get_album_rsp getResponse() {
        return (get_album_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof get_album_rsp)) {
            return null;
        }
        a aVar = new a();
        get_album_rsp get_album_rspVar = (get_album_rsp) jceStruct;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "onQueryAlbumSocialInfo for TAG mThemeRecommentType rsp.album.recommendType:" + get_album_rspVar.album.recommend_album_type);
        }
        AlbumSocialInfoCacheData createFromResponse = AlbumSocialInfoCacheData.createFromResponse(get_album_rspVar);
        aVar.f43972a = createFromResponse;
        if (createFromResponse != null && TextUtils.isEmpty(createFromResponse.albumid)) {
            aVar.f43972a = null;
        }
        BusinessAlbumInfo create = BusinessAlbumInfo.create(get_album_rspVar.album);
        aVar.f43973b = (create == null || !TextUtils.isEmpty(create.getTitle())) ? create : null;
        aVar.f43974c = AlbumCacheData.createFromResponse(get_album_rspVar.album);
        return aVar;
    }

    public QZoneQueryAlbumRequest(String str, int i3) {
        this(str, i3, LoginData.getInstance().getUin(), false, false, "");
    }

    public QZoneQueryAlbumRequest(String str, int i3, long j3, boolean z16, boolean z17, String str2) {
        super(CMD_STRING);
        get_album_req get_album_reqVar = new get_album_req();
        get_album_reqVar.albumid = str;
        get_album_reqVar.type = i3;
        get_album_reqVar.owner_uin = j3;
        get_album_reqVar.is_get_url_key = z16;
        get_album_reqVar.is_from_public_url = z17;
        get_album_reqVar.share_key = str2;
        this.req = get_album_reqVar;
    }
}
