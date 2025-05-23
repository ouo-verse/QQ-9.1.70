package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.util.JSONUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ZhituResponse implements Parcelable {
    public static final Parcelable.Creator<ZhituResponse> CREATOR = new a();
    public String cat;
    public String cookie;
    public int hasMore;

    @JSONUtils.GenericType(ZhituImgResponse.class)
    public List<ZhituImgResponse> list;

    @JSONUtils.GenericType(String.class)
    public List<String> tokens;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ZhituResponse> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ZhituResponse createFromParcel(Parcel parcel) {
            return new ZhituResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZhituResponse[] newArray(int i3) {
            return new ZhituResponse[i3];
        }
    }

    public ZhituResponse() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ZhituResponse{cat='" + this.cat + "', list=" + this.list + ", cookie='" + this.cookie + "', hasMore=" + this.hasMore + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.cat);
        parcel.writeTypedList(this.list);
        parcel.writeStringList(this.tokens);
        parcel.writeString(this.cookie);
        parcel.writeInt(this.hasMore);
    }

    protected ZhituResponse(Parcel parcel) {
        this.cat = parcel.readString();
        this.list = parcel.createTypedArrayList(ZhituImgResponse.CREATOR);
        this.tokens = parcel.createStringArrayList();
        this.cookie = parcel.readString();
        this.hasMore = parcel.readInt();
    }
}
