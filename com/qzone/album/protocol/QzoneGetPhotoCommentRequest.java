package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.get_photo_comment_req;
import NS_MOBILE_PHOTO.get_photo_comment_rsp;
import android.os.Parcel;
import android.os.Parcelable;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes39.dex */
public class QzoneGetPhotoCommentRequest extends AbsCompatRequest<RespBean> {
    private static final String CMD = "asy_photo.getPhotoComment";

    public QzoneGetPhotoCommentRequest(long j3, String str, String str2, int i3, String str3) {
        super(CMD);
        this.req = new get_photo_comment_req(j3, str, str2, i3, str3);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getPhotoComment";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public RespBean onJceRespParse(JceStruct jceStruct) throws Exception {
        RespBean respBean = new RespBean();
        if (jceStruct instanceof get_photo_comment_rsp) {
            respBean.f43993d = (get_photo_comment_rsp) jceStruct;
        }
        return respBean;
    }

    /* loaded from: classes39.dex */
    public static final class RespBean implements Parcelable {

        /* renamed from: d, reason: collision with root package name */
        public get_photo_comment_rsp f43993d;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
        }
    }
}
