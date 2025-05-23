package com.tencent.mobileqq.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.FileInputStream;
import mqq.app.AppRuntime;

/* loaded from: classes20.dex */
public abstract class RecordParams {

    /* renamed from: a, reason: collision with root package name */
    public static final int f307250a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f307251b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f307252c;

    /* renamed from: d, reason: collision with root package name */
    private static RecorderParam f307253d;

    /* renamed from: e, reason: collision with root package name */
    private static RecorderParam f307254e;

    static {
        int[] iArr = QQAudioUtils.f262098a;
        f307250a = iArr[0];
        int i3 = iArr[2];
        f307251b = i3;
        f307252c = false;
        f307253d = new RecorderParam(i3, 16000, 1);
        f307254e = new RecorderParam(i3, 16000, 1);
    }

    public static byte[] a(int i3, int i16) {
        if (i3 == 1) {
            return e(i16);
        }
        return "#!AMR\n".getBytes();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0060 A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #9 {Exception -> 0x0063, blocks: (B:50:0x005b, B:45:0x0060), top: B:49:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(String str) {
        DataInputStream dataInputStream;
        int i3;
        FileInputStream fileInputStream;
        int i16;
        DataInputStream dataInputStream2;
        FileInputStream fileInputStream2 = null;
        int i17 = 0;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (Exception e16) {
                e = e16;
                i16 = i17;
                dataInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                dataInputStream = null;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
            dataInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            dataInputStream = null;
        }
        try {
            byte[] bArr = new byte[10];
            if (dataInputStream2.read(bArr) == 10) {
                if (QQAudioUtils.h(bArr)) {
                    i17 = 1;
                }
                dataInputStream2.close();
                fileInputStream.close();
                dataInputStream2 = null;
            } else {
                fileInputStream2 = fileInputStream;
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
            }
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            return i17;
        } catch (Exception e18) {
            i16 = i17;
            dataInputStream = dataInputStream2;
            e = e18;
            fileInputStream2 = fileInputStream;
            i3 = i16;
            try {
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused2) {
                        return i3;
                    }
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                return i3;
            } catch (Throwable th7) {
                th = th7;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th8) {
            dataInputStream = dataInputStream2;
            th = th8;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
            }
            if (dataInputStream != null) {
            }
            throw th;
        }
    }

    public static RecorderParam c(AppRuntime appRuntime, boolean z16) {
        RecorderParam recorderParam;
        g(appRuntime, false);
        if (z16) {
            recorderParam = f307254e;
        } else {
            recorderParam = f307253d;
        }
        return new RecorderParam(recorderParam.f307255d, recorderParam.f307256e, recorderParam.f307257f);
    }

    private static String d(AppRuntime appRuntime) {
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).getString("SilkCfg", null);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "getSavedSilkCfg: " + string);
        }
        return string;
    }

    public static byte[] e(int i3) {
        byte[] bArr = new byte[10];
        bArr[0] = f(i3);
        System.arraycopy("#!SILK_V3".getBytes(), 0, bArr, 1, 9);
        return bArr;
    }

    public static byte f(int i3) {
        byte b16 = 0;
        while (true) {
            int[] iArr = QQAudioUtils.f262098a;
            if (b16 < iArr.length) {
                if (i3 != iArr[b16]) {
                    b16 = (byte) (b16 + 1);
                } else {
                    return b16;
                }
            } else {
                return (byte) -1;
            }
        }
    }

    public static void g(AppRuntime appRuntime, boolean z16) {
        String[] split;
        if (f307252c && !z16) {
            return;
        }
        f307252c = true;
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "init: false");
        }
        try {
            String d16 = d(appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "init from sp:" + d16);
            }
            if (d16 != null && d16.length() != 0 && (split = d16.split("\\|")) != null && split.length >= 3) {
                int intValue = Integer.valueOf(split[0]).intValue();
                int intValue2 = Integer.valueOf(split[1]).intValue();
                int intValue3 = Integer.valueOf(split[2]).intValue();
                int[] iArr = QQAudioUtils.f262098a;
                f307253d = new RecorderParam(iArr[intValue2], intValue3, intValue);
                if (split.length >= 6) {
                    f307254e = new RecorderParam(iArr[Integer.valueOf(split[4]).intValue()], Integer.valueOf(split[5]).intValue(), Integer.valueOf(split[3]).intValue());
                }
            }
        } catch (Exception unused) {
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "init params: " + f307253d.f307257f + "-" + f307253d.f307255d + "-" + f307253d.f307256e);
            QLog.d("RecordParams", 2, "init changer params: " + f307254e.f307257f + "-" + f307254e.f307255d + "-" + f307254e.f307256e);
        }
    }

    public static void h() {
        f307252c = false;
    }

    public static void i(AppRuntime appRuntime, String str) {
        BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).edit().putString("SilkCfg", str).commit();
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, " " + str);
        }
    }

    /* loaded from: classes20.dex */
    public static class RecorderParam implements Parcelable {
        public static final Parcelable.Creator<RecorderParam> CREATOR = new a();
        public int C;
        public int[] D;
        public String E;
        public boolean F;

        /* renamed from: d, reason: collision with root package name */
        public int f307255d;

        /* renamed from: e, reason: collision with root package name */
        public int f307256e;

        /* renamed from: f, reason: collision with root package name */
        public int f307257f;

        /* renamed from: h, reason: collision with root package name */
        public int f307258h;

        /* renamed from: i, reason: collision with root package name */
        public int f307259i;

        /* renamed from: m, reason: collision with root package name */
        public Object f307260m;

        /* loaded from: classes20.dex */
        class a implements Parcelable.Creator<RecorderParam> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RecorderParam createFromParcel(Parcel parcel) {
                return new RecorderParam(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RecorderParam[] newArray(int i3) {
                return new RecorderParam[i3];
            }
        }

        public RecorderParam(int i3, int i16, int i17) {
            this.f307255d = i3;
            this.f307256e = i16;
            this.f307257f = i17;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f307255d);
            parcel.writeInt(this.f307256e);
            parcel.writeInt(this.f307257f);
            parcel.writeInt(this.f307258h);
            parcel.writeInt(this.f307259i);
        }

        protected RecorderParam(Parcel parcel) {
            this.f307255d = parcel.readInt();
            this.f307256e = parcel.readInt();
            this.f307257f = parcel.readInt();
            this.f307258h = parcel.readInt();
            this.f307259i = parcel.readInt();
        }
    }
}
