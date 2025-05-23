package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class PhotoInfo implements SmartParcelable {

    @NeedParcel
    public String albumId;

    @NeedParcel
    public String albumName;

    @NeedParcel
    public PhotoUrl bigPhoto;

    @NeedParcel
    public String description;

    @NeedParcel
    public PhotoUrl mediumPhoto;

    @NeedParcel
    public long modifyTime;

    @NeedParcel
    public String name;

    @NeedParcel
    public PhotoUrl smallPhoto;

    @NeedParcel
    public int type;

    @NeedParcel
    public long uploadTime;

    /* loaded from: classes39.dex */
    public static class PhotoUrl implements SmartParcelable {

        @NeedParcel
        public int height;

        /* renamed from: id, reason: collision with root package name */
        @NeedParcel
        public String f50264id;

        @NeedParcel
        public String url;

        @NeedParcel
        public int width;

        public PhotoUrl() {
        }

        public boolean contains(String str) {
            String str2 = this.url;
            if (str2 == null) {
                return false;
            }
            return str2.equalsIgnoreCase(str);
        }

        public PhotoUrl(String str, String str2) {
            this(str, str2, -1, -1);
        }

        public PhotoUrl(String str, String str2, int i3, int i16) {
            this.f50264id = str;
            this.url = str2;
            this.width = i3;
            this.height = i16;
        }
    }

    public boolean contains(String str) {
        PhotoUrl photoUrl;
        PhotoUrl photoUrl2;
        PhotoUrl photoUrl3 = this.smallPhoto;
        return (photoUrl3 != null && photoUrl3.contains(str)) || ((photoUrl = this.mediumPhoto) != null && photoUrl.contains(str)) || ((photoUrl2 = this.bigPhoto) != null && photoUrl2.contains(str));
    }
}
