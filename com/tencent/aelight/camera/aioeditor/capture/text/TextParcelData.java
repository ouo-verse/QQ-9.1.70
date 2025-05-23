package com.tencent.aelight.camera.aioeditor.capture.text;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;

/* loaded from: classes32.dex */
public class TextParcelData implements Parcelable {
    public static final Parcelable.Creator<TextParcelData> CREATOR = new a();
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    public SegmentKeeper H;

    /* renamed from: d, reason: collision with root package name */
    private g.b f66913d;

    /* renamed from: e, reason: collision with root package name */
    private DynamicTextItem f66914e;

    /* renamed from: f, reason: collision with root package name */
    private float f66915f;

    /* renamed from: h, reason: collision with root package name */
    private float f66916h;

    /* renamed from: i, reason: collision with root package name */
    private float f66917i;

    /* renamed from: m, reason: collision with root package name */
    private float f66918m;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<TextParcelData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextParcelData createFromParcel(Parcel parcel) {
            return new TextParcelData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextParcelData[] newArray(int i3) {
            return new TextParcelData[i3];
        }
    }

    protected TextParcelData(Parcel parcel) {
        this.H = new SegmentKeeper();
        DynamicTextBuilder dynamicTextBuilder = new DynamicTextBuilder();
        int readInt = parcel.readInt();
        DynamicTextItem.TextMap textMap = (DynamicTextItem.TextMap) parcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
        DynamicTextItem b16 = dynamicTextBuilder.b(readInt, textMap.b());
        this.f66914e = b16;
        if (b16 == null) {
            QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
            this.f66914e = new w(readInt, textMap.b());
        }
        this.f66914e.L(parcel.readInt() == 1);
        this.f66913d = new g.b(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        this.f66915f = parcel.readFloat();
        this.f66916h = parcel.readFloat();
        this.f66917i = parcel.readFloat();
        this.f66918m = parcel.readFloat();
        this.C = parcel.readFloat();
        this.D = parcel.readFloat();
        this.E = parcel.readFloat();
        this.F = parcel.readFloat();
        this.G = parcel.readFloat();
        this.H = (SegmentKeeper) parcel.readParcelable(SegmentKeeper.class.getClassLoader());
    }

    public g.c a(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar) {
        g.c cVar;
        if (gVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.h) {
            Objects.requireNonNull(gVar);
            cVar = new g.d(this.f66913d);
        } else {
            Objects.requireNonNull(gVar);
            cVar = new g.c(this.f66913d);
        }
        cVar.f453046b = this.f66913d.f67993b;
        DynamicTextItem dynamicTextItem = this.f66914e;
        cVar.f68001z = dynamicTextItem;
        cVar.f453051g = dynamicTextItem.w();
        cVar.f453052h = this.f66914e.m();
        cVar.f68000y = this.f66915f;
        cVar.A = this.f66916h;
        cVar.B = this.f66917i;
        cVar.C = this.f66918m;
        cVar.D = this.C;
        cVar.E = this.D;
        cVar.F = this.E;
        cVar.G = this.F;
        cVar.H = this.G;
        return cVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f66914e.v());
        parcel.writeParcelable(this.f66914e.q(), 0);
        parcel.writeInt(this.f66914e.E() ? 1 : 0);
        parcel.writeFloat(this.f66913d.f67992a.x);
        parcel.writeFloat(this.f66913d.f67992a.y);
        parcel.writeFloat(this.f66913d.f67993b);
        parcel.writeFloat(this.f66913d.f67994c);
        parcel.writeFloat(this.f66913d.f67995d);
        parcel.writeFloat(this.f66913d.f67996e);
        parcel.writeFloat(this.f66913d.f67997f);
        parcel.writeFloat(this.f66913d.f67998g);
        parcel.writeFloat(this.f66915f);
        parcel.writeFloat(this.f66916h);
        parcel.writeFloat(this.f66917i);
        parcel.writeFloat(this.f66918m);
        parcel.writeFloat(this.C);
        parcel.writeFloat(this.D);
        parcel.writeFloat(this.E);
        parcel.writeFloat(this.F);
        parcel.writeFloat(this.G);
        parcel.writeParcelable(this.H, 0);
    }
}
