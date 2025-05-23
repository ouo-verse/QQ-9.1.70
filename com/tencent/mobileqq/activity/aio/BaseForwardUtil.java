package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseForwardUtil {

    /* renamed from: a, reason: collision with root package name */
    protected static int[] f178060a = {11, 2};

    public static String a() {
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("data");
        sb5.append(str);
        sb5.append("data");
        sb5.append(str);
        return sb5.toString();
    }

    public static boolean b(Context context) {
        if (context != null && context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            return false;
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class SectionBase implements Parcelable {
        public static final Parcelable.Creator<SectionBase> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public int f178061d;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements Parcelable.Creator<SectionBase> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SectionBase createFromParcel(Parcel parcel) {
                return new SectionBase(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SectionBase[] newArray(int i3) {
                return new SectionBase[i3];
            }
        }

        protected SectionBase() {
            this.f178061d = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f178061d);
        }

        protected SectionBase(Parcel parcel) {
            this.f178061d = 0;
            this.f178061d = parcel.readInt();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class SectionPic extends SectionBase {
        public static final Parcelable.Creator<SectionPic> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public String f178062e;

        /* renamed from: f, reason: collision with root package name */
        public String f178063f;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements Parcelable.Creator<SectionPic> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SectionPic createFromParcel(Parcel parcel) {
                return new SectionPic(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SectionPic[] newArray(int i3) {
                return new SectionPic[i3];
            }
        }

        public SectionPic() {
            this.f178061d = 1;
        }

        @Override // com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionBase, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f178062e);
            parcel.writeString(this.f178063f);
        }

        protected SectionPic(Parcel parcel) {
            super(parcel);
            this.f178062e = parcel.readString();
            this.f178063f = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class SectionText extends SectionBase {
        public static final Parcelable.Creator<SectionText> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public String f178064e;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements Parcelable.Creator<SectionText> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SectionText createFromParcel(Parcel parcel) {
                return new SectionText(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SectionText[] newArray(int i3) {
                return new SectionText[i3];
            }
        }

        public SectionText() {
            this.f178061d = -1;
        }

        @Override // com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionBase, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f178064e);
        }

        public SectionText(String str) {
            this.f178061d = -1;
            this.f178064e = str;
        }

        protected SectionText(Parcel parcel) {
            super(parcel);
            this.f178064e = parcel.readString();
        }
    }
}
