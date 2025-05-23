package com.tencent.biz.qqcircle.beans;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSCommentPicInfoSet implements Parcelable {
    public static final Parcelable.Creator<QFSCommentPicInfoSet> CREATOR = new Parcelable.Creator<QFSCommentPicInfoSet>() { // from class: com.tencent.biz.qqcircle.beans.QFSCommentPicInfoSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QFSCommentPicInfoSet createFromParcel(Parcel parcel) {
            return new QFSCommentPicInfoSet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QFSCommentPicInfoSet[] newArray(int i3) {
            return new QFSCommentPicInfoSet[i3];
        }
    };
    public ArrayList<QFSCommentPicInfo> infos;

    public QFSCommentPicInfoSet(List<QFSCommentPicInfo> list) {
        this.infos = new ArrayList<>(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.infos);
    }

    protected QFSCommentPicInfoSet(Parcel parcel) {
        this.infos = parcel.createTypedArrayList(QFSCommentPicInfo.CREATOR);
    }
}
