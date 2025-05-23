package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.create_album_req;
import NS_MOBILE_PHOTO.create_album_rsp;
import NS_MOBILE_PHOTO.edit_album_req;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneOptAlbumRequest extends AbsCompatRequest<a> {
    public static final String FIELD_CMD_CREATE = "createAlbum";
    public static final String FIELD_CMD_EDIT = "editAlbum";
    private String curCMD;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f43958a;
    }

    public QZoneOptAlbumRequest(String str, Album album, String str2, String str3, int i3, int i16, String str4, boolean z16) {
        super(str);
        this.curCMD = str;
        if (str.equals(FIELD_CMD_CREATE)) {
            create_album_req create_album_reqVar = new create_album_req();
            create_album_reqVar.album = album;
            create_album_reqVar.itemid = str3;
            create_album_reqVar.action = i16;
            if (i16 == 32) {
                create_album_reqVar.invite_key = album.albumid;
            } else if (i16 == 2) {
                create_album_reqVar.invite_key = str4;
            }
            create_album_reqVar.is_from_public_url = z16;
            this.req = create_album_reqVar;
            return;
        }
        if (this.curCMD.equals(FIELD_CMD_EDIT)) {
            edit_album_req edit_album_reqVar = new edit_album_req();
            edit_album_reqVar.album = album;
            if (!TextUtils.isEmpty(str2)) {
                edit_album_reqVar.newCoverId = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                edit_album_reqVar.itemid = str3;
            }
            edit_album_reqVar.cancelIndividual = i3;
            edit_album_reqVar.isModifyBitmap = true;
            this.req = edit_album_reqVar;
        }
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return this.curCMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof create_album_rsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f43958a = ((create_album_rsp) jceStruct).albumid;
        return aVar;
    }

    public QZoneOptAlbumRequest(Album album) {
        this(FIELD_CMD_EDIT, album, null, null, 0, 0, null, false);
    }
}
