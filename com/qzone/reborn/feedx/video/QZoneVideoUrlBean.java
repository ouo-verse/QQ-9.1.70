package com.qzone.reborn.feedx.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoUrlBean implements Parcelable {
    public int C;
    public int D;
    public int E;
    public int F;
    public float G;

    /* renamed from: d, reason: collision with root package name */
    public int f55801d;

    /* renamed from: e, reason: collision with root package name */
    public String f55802e;

    /* renamed from: f, reason: collision with root package name */
    public String f55803f;

    /* renamed from: h, reason: collision with root package name */
    public int f55804h;

    /* renamed from: i, reason: collision with root package name */
    public int f55805i;

    /* renamed from: m, reason: collision with root package name */
    public int f55806m;
    public static final Pattern H = Pattern.compile("(.*).f(\\d*)");
    private static final int[] I = {500, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 700, 1000, 1200};
    private static final int[] J = {700, 1000};
    public static final Parcelable.Creator<QZoneVideoUrlBean> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Parcelable.Creator<QZoneVideoUrlBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZoneVideoUrlBean createFromParcel(Parcel parcel) {
            return new QZoneVideoUrlBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneVideoUrlBean[] newArray(int i3) {
            return new QZoneVideoUrlBean[i3];
        }
    }

    protected QZoneVideoUrlBean(Parcel parcel) {
        this.f55801d = parcel.readInt();
        this.f55802e = parcel.readString();
        this.f55803f = parcel.readString();
        this.f55804h = parcel.readInt();
        this.f55805i = parcel.readInt();
        this.f55806m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return " \u7801\u7387 " + this.C + "kb/s \u7f16\u7801 " + a(this.f55806m) + " \u6863\u4f4d " + this.D + " \u5206\u8fa8\u7387 " + this.f55804h + HippyTKDListViewAdapter.X + this.f55805i + "\n \u57df\u540d " + this.f55803f + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f55801d);
        parcel.writeString(this.f55802e);
        parcel.writeString(this.f55803f);
        parcel.writeInt(this.f55804h);
        parcel.writeInt(this.f55805i);
        parcel.writeInt(this.f55806m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeFloat(this.G);
    }

    public static String a(int i3) {
        if (i3 == 1) {
            return "h264";
        }
        if (i3 == 2) {
            return UploadVideoObject.VODEO_FORMAT_H265;
        }
        return "\u672a\u77e5";
    }
}
