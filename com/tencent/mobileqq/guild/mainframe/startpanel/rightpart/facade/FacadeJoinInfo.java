package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FacadeJoinInfo implements Parcelable {
    public static final Parcelable.Creator<FacadeJoinInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private JumpGuildParam.JoinInfoParam f227661d;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<FacadeJoinInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacadeJoinInfo createFromParcel(Parcel parcel) {
            return new FacadeJoinInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FacadeJoinInfo[] newArray(int i3) {
            return new FacadeJoinInfo[i3];
        }
    }

    public FacadeJoinInfo() {
    }

    public JumpGuildParam.JoinInfoParam a() {
        JumpGuildParam.JoinInfoParam joinInfoParam = this.f227661d;
        if (joinInfoParam == null) {
            return new JumpGuildParam.JoinInfoParam("", "", "", "");
        }
        return joinInfoParam;
    }

    public void b(JumpGuildParam.JoinInfoParam joinInfoParam) {
        this.f227661d = joinInfoParam;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.f227661d, ((FacadeJoinInfo) obj).f227661d);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f227661d);
    }

    public String toString() {
        return "FacadeJoinInfo{, joinInfoParam=" + a() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f227661d, 1);
    }

    protected FacadeJoinInfo(Parcel parcel) {
        this.f227661d = (JumpGuildParam.JoinInfoParam) parcel.readParcelable(JumpGuildParam.JoinInfoParam.class.getClassLoader());
    }
}
