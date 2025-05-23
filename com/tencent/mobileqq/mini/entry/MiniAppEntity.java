package com.tencent.mobileqq.mini.entry;

import android.os.Parcel;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntity extends Entity {
    public static final String TAG = "MiniAppEntity";

    @unique
    public String appId;
    public byte[] appInfo;
    public String name;
    public int position;

    public MiniAppEntity() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x004f: IF  (r3 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:23:0x0054, block:B:21:0x004f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniAppInfo createFromBuffer(byte[] bArr) {
        Parcel parcel;
        Parcel parcel2;
        try {
            try {
                parcel = Parcel.obtain();
            } catch (OutOfMemoryError unused) {
                parcel = null;
            } catch (Throwable th5) {
                th = th5;
                parcel = null;
            }
            try {
                parcel.unmarshall(bArr, 0, bArr.length);
                parcel.setDataPosition(0);
                MiniAppInfo miniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
                OaidMonitor.parcelRecycle(parcel);
                return miniAppInfo;
            } catch (OutOfMemoryError unused2) {
                QLog.e(TAG, 1, "MiniAppInfo memory Error");
            } catch (Throwable th6) {
                th = th6;
                QLog.e(TAG, 1, "createFromCursor exception:" + Log.getStackTraceString(th));
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
                return null;
            }
        } catch (Throwable th7) {
            if (parcel2 != null) {
                OaidMonitor.parcelRecycle(parcel2);
            }
            throw th7;
        }
    }

    public MiniAppEntity(MiniAppInfo miniAppInfo) {
        this.appId = miniAppInfo.appId;
        this.name = miniAppInfo.name;
        this.position = miniAppInfo.position;
        this.appInfo = packMiniAppInfo(miniAppInfo);
    }

    private byte[] packMiniAppInfo(MiniAppInfo miniAppInfo) {
        Parcel parcel;
        try {
            parcel = Parcel.obtain();
        } catch (Throwable th5) {
            th = th5;
            parcel = null;
        }
        try {
            parcel.setDataPosition(0);
            parcel.writeParcelable(miniAppInfo, 0);
            byte[] marshall = parcel.marshall();
            OaidMonitor.parcelRecycle(parcel);
            return marshall;
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(TAG, 1, "writeTo MiniAppInfo exception: " + Log.getStackTraceString(th));
                return null;
            } finally {
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
            }
        }
    }
}
