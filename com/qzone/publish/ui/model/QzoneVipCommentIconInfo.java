package com.qzone.publish.ui.model;

import NS_CLIENT_SHOW_PROTOCOL.CommentQzmallDeco;
import NS_CLIENT_SHOW_PROTOCOL.QzmallCommentBadge;
import android.os.Parcel;
import android.os.Parcelable;
import cooperation.qzone.util.JceUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVipCommentIconInfo implements Parcelable {
    public static final Parcelable.Creator<QzoneVipCommentIconInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f51898d;

    /* renamed from: e, reason: collision with root package name */
    public int f51899e;

    /* renamed from: f, reason: collision with root package name */
    public String f51900f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<QzoneVipCommentIconInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QzoneVipCommentIconInfo createFromParcel(Parcel parcel) {
            return new QzoneVipCommentIconInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneVipCommentIconInfo[] newArray(int i3) {
            return new QzoneVipCommentIconInfo[i3];
        }
    }

    public QzoneVipCommentIconInfo() {
        this.f51898d = 0;
        this.f51899e = 0;
        this.f51900f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f51898d);
        parcel.writeInt(this.f51899e);
        parcel.writeString(this.f51900f);
    }

    protected QzoneVipCommentIconInfo(Parcel parcel) {
        this.f51898d = 0;
        this.f51899e = 0;
        this.f51900f = "";
        this.f51898d = parcel.readInt();
        this.f51899e = parcel.readInt();
        this.f51900f = parcel.readString();
    }

    public static QzoneVipCommentIconInfo a(byte[] bArr) {
        CommentQzmallDeco commentQzmallDeco;
        QzmallCommentBadge qzmallCommentBadge;
        if (bArr == null || (commentQzmallDeco = (CommentQzmallDeco) JceUtils.decodeWup(CommentQzmallDeco.class, bArr)) == null || (qzmallCommentBadge = commentQzmallDeco.badge) == null || qzmallCommentBadge.itemid <= 0) {
            return null;
        }
        QzoneVipCommentIconInfo qzoneVipCommentIconInfo = new QzoneVipCommentIconInfo();
        QzmallCommentBadge qzmallCommentBadge2 = commentQzmallDeco.badge;
        qzoneVipCommentIconInfo.f51898d = qzmallCommentBadge2.itemid;
        qzoneVipCommentIconInfo.f51899e = qzmallCommentBadge2.bigClubLevel;
        qzoneVipCommentIconInfo.f51900f = qzmallCommentBadge2.jumpUrl;
        return qzoneVipCommentIconInfo;
    }
}
