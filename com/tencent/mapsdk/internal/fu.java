package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.hn;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class fu implements BitmapDescriptor.BitmapFormator {

    /* renamed from: f, reason: collision with root package name */
    public String f148357f;

    /* renamed from: g, reason: collision with root package name */
    public a f148358g;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap[] f148359h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f148360i;

    /* renamed from: k, reason: collision with root package name */
    private final int f148362k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f148363l;

    /* renamed from: m, reason: collision with root package name */
    private String f148364m;

    /* renamed from: o, reason: collision with root package name */
    private int f148366o;

    /* renamed from: p, reason: collision with root package name */
    private int f148367p;

    /* renamed from: q, reason: collision with root package name */
    private int f148368q;

    /* renamed from: r, reason: collision with root package name */
    private nc f148369r;

    /* renamed from: j, reason: collision with root package name */
    private final String f148361j = "marker_default.png";

    /* renamed from: a, reason: collision with root package name */
    public int f148352a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f148353b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f148354c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f148355d = "";

    /* renamed from: e, reason: collision with root package name */
    public float f148356e = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    private int f148365n = 1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.tencent.mapsdk.internal.fu.a.1
            private static a a(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ a[] newArray(int i3) {
                return new a[i3];
            }

            private static a[] a(int i3) {
                return new a[i3];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        String f148370a;

        /* renamed from: b, reason: collision with root package name */
        int f148371b;

        /* renamed from: c, reason: collision with root package name */
        int f148372c;

        /* renamed from: d, reason: collision with root package name */
        public float f148373d;

        /* renamed from: e, reason: collision with root package name */
        public int f148374e;

        /* renamed from: f, reason: collision with root package name */
        public Typeface f148375f;

        /* renamed from: g, reason: collision with root package name */
        public float f148376g;

        public a(String str, int i3, int i16) {
            this.f148376g = 1.0f;
            this.f148370a = str;
            this.f148371b = i3;
            this.f148372c = i16;
        }

        private float a() {
            return this.f148376g;
        }

        private float b() {
            return this.f148373d;
        }

        private int c() {
            return this.f148374e;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("FontText{");
            stringBuffer.append("text='");
            stringBuffer.append(this.f148370a);
            stringBuffer.append('\'');
            stringBuffer.append(", textSize=");
            stringBuffer.append(this.f148371b);
            stringBuffer.append(", textColor=");
            stringBuffer.append(this.f148372c);
            stringBuffer.append(", strokeWith=");
            stringBuffer.append(this.f148373d);
            stringBuffer.append(", strokeColor=");
            stringBuffer.append(this.f148374e);
            stringBuffer.append(", typeface=");
            stringBuffer.append(this.f148375f);
            stringBuffer.append(", scale=");
            stringBuffer.append(this.f148376g);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f148370a);
            parcel.writeInt(this.f148371b);
            parcel.writeInt(this.f148372c);
            parcel.writeFloat(this.f148373d);
            parcel.writeInt(this.f148374e);
            parcel.writeFloat(this.f148376g);
        }

        private void a(float f16) {
            this.f148376g = f16;
        }

        private void b(float f16) {
            this.f148373d = f16;
        }

        private void a(int i3) {
            this.f148374e = i3;
        }

        private void a(Typeface typeface) {
            this.f148375f = typeface;
        }

        protected a(Parcel parcel) {
            this.f148376g = 1.0f;
            this.f148370a = parcel.readString();
            this.f148371b = parcel.readInt();
            this.f148372c = parcel.readInt();
            this.f148373d = parcel.readFloat();
            this.f148374e = parcel.readInt();
            this.f148376g = parcel.readFloat();
        }
    }

    public fu(Context context, int i3) {
        this.f148360i = context;
        this.f148362k = i3;
    }

    private static String a(float f16) {
        if (f16 < 30.0f) {
            return "RED.png";
        }
        if (f16 >= 30.0f && f16 < 60.0f) {
            return "ORANGE.png";
        }
        if (f16 >= 60.0f && f16 < 120.0f) {
            return "YELLOW.png";
        }
        if (f16 >= 120.0f && f16 < 180.0f) {
            return "GREEN.png";
        }
        if (f16 >= 180.0f && f16 < 210.0f) {
            return "CYAN.png";
        }
        if (f16 >= 210.0f && f16 < 240.0f) {
            return "AZURE.png";
        }
        if (f16 >= 240.0f && f16 < 270.0f) {
            return "BLUE.png";
        }
        if (f16 >= 270.0f && f16 < 300.0f) {
            return "VIOLET.png";
        }
        if (f16 >= 300.0f && f16 < 330.0f) {
            return "MAGENTAV.png";
        }
        if (f16 >= 330.0f) {
            return "ROSE.png";
        }
        return null;
    }

    private static String b(Bitmap bitmap) {
        return hn.a(bitmap);
    }

    private BitmapDescriptor.BitmapFormator c(String str) {
        this.f148354c = str;
        return this;
    }

    private BitmapDescriptor.BitmapFormator d(String str) {
        this.f148355d = str;
        return this;
    }

    private BitmapDescriptor.BitmapFormator e(String str) {
        this.f148357f = str;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final int activeSize() {
        Bitmap[] bitmapArr = this.f148359h;
        if (bitmapArr != null) {
            return bitmapArr.length;
        }
        if (this.f148363l != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final Bitmap getBitmap(Context context) {
        Bitmap bitmap;
        Bitmap bitmap2 = this.f148363l;
        if (bitmap2 != null && this.f148364m != null && this.f148362k != 10) {
            return bitmap2;
        }
        Bitmap bitmap3 = null;
        if (context == null) {
            return null;
        }
        hn.a aVar = hn.f148686b;
        if (aVar != null) {
            bitmap = aVar.a(getBitmapId());
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            switch (this.f148362k) {
                case 1:
                    bitmap3 = hn.a(context, this.f148352a);
                    break;
                case 2:
                    bitmap3 = hn.c(context, this.f148353b);
                    if (bitmap3 == null && (bitmap3 = hn.b(context, this.f148353b)) != null && !this.f148353b.equals(ga.f148427i)) {
                        bitmap3 = hn.b(bitmap3);
                        break;
                    }
                    break;
                case 3:
                    bitmap3 = hn.a(context, this.f148354c);
                    break;
                case 4:
                    bitmap3 = hn.a(this.f148355d);
                    break;
                case 5:
                    bitmap3 = hn.b(context, "marker_default.png");
                    break;
                case 6:
                    String a16 = a(this.f148356e);
                    if (a16 != null) {
                        bitmap3 = hn.b(context, a16);
                        break;
                    }
                    break;
                case 7:
                    bitmap3 = this.f148363l;
                    break;
                case 8:
                    if (!TextUtils.isEmpty(this.f148357f)) {
                        bitmap3 = a(this.f148357f);
                        break;
                    }
                    break;
                case 9:
                    a aVar2 = this.f148358g;
                    if (aVar2 != null) {
                        if (this.f148369r == null) {
                            this.f148369r = new nc(context);
                        }
                        nc ncVar = this.f148369r;
                        ncVar.setText(aVar2.f148370a);
                        ncVar.setTextSize(0, aVar2.f148371b * aVar2.f148376g);
                        ncVar.setTextColor(aVar2.f148372c);
                        ncVar.setStrokeColor(aVar2.f148374e);
                        ncVar.setStrokeWidth(aVar2.f148373d * aVar2.f148376g);
                        ncVar.setTypeface(aVar2.f148375f);
                        bitmap3 = hn.a(ncVar);
                        break;
                    }
                    break;
                case 10:
                    Bitmap[] bitmapArr = this.f148359h;
                    if (bitmapArr != null) {
                        int length = bitmapArr.length;
                        int i3 = this.f148368q;
                        if (length > i3 && i3 >= 0) {
                            bitmap3 = bitmapArr[i3];
                            break;
                        }
                    }
                    break;
            }
            hn.a aVar3 = hn.f148686b;
            if (aVar3 != null && bitmap3 != null) {
                aVar3.a(getBitmapId(), bitmap3);
            }
            bitmap = bitmap3;
        }
        if (bitmap != null) {
            this.f148366o = bitmap.getWidth();
            this.f148367p = bitmap.getHeight();
            this.f148363l = bitmap;
        }
        return bitmap;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final String getBitmapId() {
        Bitmap bitmap;
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (TextUtils.isEmpty(this.f148364m) || this.f148362k == 10) {
            switch (this.f148362k) {
                case 1:
                    this.f148364m = "res_" + this.f148352a;
                    break;
                case 2:
                    this.f148364m = "asset_" + this.f148353b;
                    break;
                case 3:
                    this.f148364m = "file_" + this.f148354c;
                    break;
                case 4:
                    this.f148364m = "path_" + this.f148355d;
                    break;
                case 5:
                    this.f148364m = "asset_marker_default.png";
                    break;
                case 6:
                    String a16 = a(this.f148356e);
                    if (a16 != null) {
                        this.f148364m = "asset_".concat(a16);
                        break;
                    }
                    break;
                case 7:
                    Bitmap bitmap2 = this.f148363l;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        this.f148364m = "bitmap_" + hn.a(this.f148363l);
                        break;
                    }
                    break;
                case 8:
                    if (!TextUtils.isEmpty(this.f148357f)) {
                        this.f148364m = "url_" + Util.getMD5String(this.f148357f);
                        break;
                    }
                    break;
                case 9:
                    if (this.f148358g != null) {
                        this.f148364m = "fonttext_" + Util.getMD5String(this.f148358g.toString());
                        break;
                    }
                    break;
                case 10:
                    Bitmap[] bitmapArr = this.f148359h;
                    if (bitmapArr != null) {
                        int length = bitmapArr.length;
                        int i3 = this.f148368q;
                        if (length > i3 && i3 >= 0 && (bitmap = bitmapArr[i3]) != null && !bitmap.isRecycled()) {
                            this.f148364m = "bitmaps_" + hn.a(bitmap);
                            break;
                        }
                    }
                    break;
            }
        }
        sb5.append(this.f148364m);
        if (this.f148365n <= 1) {
            str = "";
        } else {
            str = "@" + this.f148365n + HippyTKDListViewAdapter.X;
        }
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final int getFormateType() {
        return this.f148362k;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final int getHeight() {
        getBitmap(this.f148360i);
        return this.f148367p;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final int getWidth() {
        getBitmap(this.f148360i);
        return this.f148366o;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final int nextActiveIndex() {
        Bitmap[] bitmapArr = this.f148359h;
        if (bitmapArr != null && bitmapArr.length > 1) {
            int i3 = this.f148368q + 1;
            this.f148368q = i3;
            this.f148368q = i3 % bitmapArr.length;
        } else {
            this.f148368q = 0;
        }
        return this.f148368q;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final void recycle() {
        LogUtil.b(ky.f149113s, "remove on format recycle");
        if (hn.f148686b.b(getBitmapId())) {
            ku.a(this.f148359h);
            ku.a(this.f148363l);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public final void setScale(int i3) {
        this.f148365n = i3;
    }

    private String a() {
        if (this.f148365n <= 1) {
            return "";
        }
        return "@" + this.f148365n + HippyTKDListViewAdapter.X;
    }

    private String b() {
        Bitmap bitmap;
        if (!TextUtils.isEmpty(this.f148364m) && this.f148362k != 10) {
            return this.f148364m;
        }
        switch (this.f148362k) {
            case 1:
                this.f148364m = "res_" + this.f148352a;
                break;
            case 2:
                this.f148364m = "asset_" + this.f148353b;
                break;
            case 3:
                this.f148364m = "file_" + this.f148354c;
                break;
            case 4:
                this.f148364m = "path_" + this.f148355d;
                break;
            case 5:
                this.f148364m = "asset_marker_default.png";
                break;
            case 6:
                String a16 = a(this.f148356e);
                if (a16 != null) {
                    this.f148364m = "asset_".concat(a16);
                    break;
                }
                break;
            case 7:
                Bitmap bitmap2 = this.f148363l;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.f148364m = "bitmap_" + hn.a(this.f148363l);
                    break;
                }
                break;
            case 8:
                if (!TextUtils.isEmpty(this.f148357f)) {
                    this.f148364m = "url_" + Util.getMD5String(this.f148357f);
                    break;
                }
                break;
            case 9:
                if (this.f148358g != null) {
                    this.f148364m = "fonttext_" + Util.getMD5String(this.f148358g.toString());
                    break;
                }
                break;
            case 10:
                Bitmap[] bitmapArr = this.f148359h;
                if (bitmapArr != null) {
                    int length = bitmapArr.length;
                    int i3 = this.f148368q;
                    if (length > i3 && i3 >= 0 && (bitmap = bitmapArr[i3]) != null && !bitmap.isRecycled()) {
                        this.f148364m = "bitmaps_" + hn.a(bitmap);
                        break;
                    }
                }
                break;
        }
        return this.f148364m;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Bitmap a(Context context, int i3) {
        switch (i3) {
            case 1:
                return hn.a(context, this.f148352a);
            case 2:
                Bitmap c16 = hn.c(context, this.f148353b);
                if (c16 != null) {
                    return c16;
                }
                Bitmap b16 = hn.b(context, this.f148353b);
                return (b16 == null || this.f148353b.equals(ga.f148427i)) ? b16 : hn.b(b16);
            case 3:
                return hn.a(context, this.f148354c);
            case 4:
                return hn.a(this.f148355d);
            case 5:
                return hn.b(context, "marker_default.png");
            case 6:
                String a16 = a(this.f148356e);
                if (a16 != null) {
                    return hn.b(context, a16);
                }
                return null;
            case 7:
                return this.f148363l;
            case 8:
                if (!TextUtils.isEmpty(this.f148357f)) {
                    return a(this.f148357f);
                }
                return null;
            case 9:
                a aVar = this.f148358g;
                if (aVar != null) {
                    if (this.f148369r == null) {
                        this.f148369r = new nc(context);
                    }
                    nc ncVar = this.f148369r;
                    ncVar.setText(aVar.f148370a);
                    ncVar.setTextSize(0, aVar.f148371b * aVar.f148376g);
                    ncVar.setTextColor(aVar.f148372c);
                    ncVar.setStrokeColor(aVar.f148374e);
                    ncVar.setStrokeWidth(aVar.f148373d * aVar.f148376g);
                    ncVar.setTypeface(aVar.f148375f);
                    return hn.a(ncVar);
                }
                return null;
            case 10:
                Bitmap[] bitmapArr = this.f148359h;
                if (bitmapArr != null) {
                    int length = bitmapArr.length;
                    int i16 = this.f148368q;
                    if (length > i16 && i16 >= 0) {
                        return bitmapArr[i16];
                    }
                }
                return null;
            default:
                return null;
        }
    }

    private Bitmap a(Context context, a aVar) {
        if (this.f148369r == null) {
            this.f148369r = new nc(context);
        }
        nc ncVar = this.f148369r;
        ncVar.setText(aVar.f148370a);
        ncVar.setTextSize(0, aVar.f148371b * aVar.f148376g);
        ncVar.setTextColor(aVar.f148372c);
        ncVar.setStrokeColor(aVar.f148374e);
        ncVar.setStrokeWidth(aVar.f148373d * aVar.f148376g);
        ncVar.setTypeface(aVar.f148375f);
        return hn.a(ncVar);
    }

    private BitmapDescriptor.BitmapFormator b(String str) {
        this.f148353b = str;
        return this;
    }

    private BitmapDescriptor.BitmapFormator b(float f16) {
        this.f148356e = f16;
        return this;
    }

    private static Bitmap a(String str) {
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        if (doGet != null && doGet.available()) {
            try {
                byte[] bArr = doGet.data;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } catch (OutOfMemoryError unused) {
                System.gc();
                try {
                    byte[] bArr2 = doGet.data;
                    return BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                } catch (OutOfMemoryError unused2) {
                }
            }
        }
        return null;
    }

    private BitmapDescriptor.BitmapFormator a(int i3) {
        this.f148352a = i3;
        return this;
    }

    public final BitmapDescriptor.BitmapFormator a(Bitmap bitmap) {
        this.f148363l = bitmap;
        getBitmap(this.f148360i);
        return this;
    }

    private BitmapDescriptor.BitmapFormator a(a aVar) {
        this.f148358g = aVar;
        return this;
    }

    private void a(Bitmap[] bitmapArr) {
        this.f148359h = bitmapArr;
        getBitmap(this.f148360i);
    }
}
