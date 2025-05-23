package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MusicInfo implements SmartParcelable {

    @NeedParcel
    public PictureUrl coverUrl;

    @NeedParcel
    public int height;

    @NeedParcel
    public String musicId;

    @NeedParcel
    public String musicMid;

    @NeedParcel
    public String musicNUrl;

    @NeedParcel
    public String musicUrl;

    @NeedParcel
    public int musictime;

    @NeedParcel
    public String title;

    @NeedParcel
    public int width;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MusicInfo {\n");
        if (!TextUtils.isEmpty(this.musicId)) {
            sb5.append("musicId: ");
            sb5.append(this.musicId);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.musicMid)) {
            sb5.append("musicMid: ");
            sb5.append(this.musicMid);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.musicUrl)) {
            sb5.append("musicUrl: ");
            sb5.append(this.musicUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.musicNUrl)) {
            sb5.append("musicNUrl: ");
            sb5.append(this.musicNUrl);
            sb5.append("\n");
        }
        PictureUrl pictureUrl = this.coverUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            sb5.append("coverUrl: ");
            sb5.append(this.coverUrl.url);
            sb5.append("\n");
        }
        sb5.append("width: ");
        sb5.append(this.width);
        sb5.append(", ");
        sb5.append("height: ");
        sb5.append(this.height);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.title)) {
            sb5.append("title: ");
            sb5.append(this.title);
            sb5.append("\n");
        }
        sb5.append("musictime: ");
        sb5.append(this.musictime);
        sb5.append(", ");
        sb5.append("}");
        return sb5.toString();
    }
}
