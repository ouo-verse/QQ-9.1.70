package com.qzone.common.business.result;

import android.text.TextUtils;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UploadFileResponse extends JceStruct {
    private static final long serialVersionUID = -7484888819743554568L;
    public String albumId;
    public String clientFakeKey;
    public int height;
    public String md5;
    public int oheight;
    public String originId;
    public String originUploadUrl;
    public int owidth;
    public String photoId;
    public int picType;
    public String qunCode;
    public String slocId;
    public long uploadTime;
    public String url;
    public int width;

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.url, "appid");
        jceDisplayer.display(this.albumId, "albumId");
        jceDisplayer.display(this.photoId, "photoId");
        jceDisplayer.display(this.slocId, "slocId");
        jceDisplayer.display(this.width, "width");
        jceDisplayer.display(this.height, "height");
        jceDisplayer.display(this.owidth, "owidth");
        jceDisplayer.display(this.oheight, "oheight");
        jceDisplayer.display(this.picType, "picType");
        jceDisplayer.display(this.clientFakeKey, "clientFakeKey");
        jceDisplayer.display(this.uploadTime, PhotoCategorySinglePicInfo.UPLOAD_TIME);
        jceDisplayer.display(this.originUploadUrl, "originUploadUrl");
        jceDisplayer.display(this.md5, "md5");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.read(this.url, 0, false);
        this.albumId = jceInputStream.read(this.albumId, 1, false);
        this.photoId = jceInputStream.read(this.photoId, 2, false);
        this.slocId = jceInputStream.read(this.slocId, 3, false);
        this.width = jceInputStream.read(this.width, 4, false);
        this.height = jceInputStream.read(this.height, 5, false);
        this.owidth = jceInputStream.read(this.owidth, 6, false);
        this.oheight = jceInputStream.read(this.oheight, 7, false);
        this.picType = jceInputStream.read(this.picType, 8, false);
        this.clientFakeKey = jceInputStream.read(this.clientFakeKey, 9, false);
        this.uploadTime = jceInputStream.read(this.uploadTime, 10, false);
        this.originUploadUrl = jceInputStream.read(this.originUploadUrl, 11, false);
        this.qunCode = jceInputStream.read(this.qunCode, 12, false);
        this.md5 = jceInputStream.read(this.md5, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        if (TextUtils.isEmpty(this.url)) {
            str = "";
        } else {
            str = this.url;
        }
        jceOutputStream.write(str, 0);
        if (TextUtils.isEmpty(this.albumId)) {
            str2 = "";
        } else {
            str2 = this.albumId;
        }
        jceOutputStream.write(str2, 1);
        if (TextUtils.isEmpty(this.photoId)) {
            str3 = "";
        } else {
            str3 = this.photoId;
        }
        jceOutputStream.write(str3, 2);
        if (TextUtils.isEmpty(this.slocId)) {
            str4 = "";
        } else {
            str4 = this.slocId;
        }
        jceOutputStream.write(str4, 3);
        jceOutputStream.write(this.width, 4);
        jceOutputStream.write(this.height, 5);
        jceOutputStream.write(this.owidth, 6);
        jceOutputStream.write(this.oheight, 7);
        jceOutputStream.write(this.picType, 8);
        if (TextUtils.isEmpty(this.clientFakeKey)) {
            str5 = "";
        } else {
            str5 = this.clientFakeKey;
        }
        jceOutputStream.write(str5, 9);
        jceOutputStream.write(this.uploadTime, 10);
        if (TextUtils.isEmpty(this.originUploadUrl)) {
            str6 = "";
        } else {
            str6 = this.originUploadUrl;
        }
        jceOutputStream.write(str6, 11);
        if (TextUtils.isEmpty(this.qunCode)) {
            str7 = "";
        } else {
            str7 = this.qunCode;
        }
        jceOutputStream.write(str7, 12);
        if (!TextUtils.isEmpty(this.md5)) {
            str8 = this.md5;
        }
        jceOutputStream.write(str8, 13);
    }
}
