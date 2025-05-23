package com.qzone.proxy.feedcomponent.model;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AudioInfo implements SmartParcelable {

    @NeedParcel
    public String audioKey;

    @NeedParcel
    public int audioTime;

    @NeedParcel
    public String errorMessage;

    public AudioInfo() {
    }

    public String toCacheString() {
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] d16 = com.qzone.proxy.feedcomponent.util.b.d(obtain.marshall(), 0);
        OaidMonitor.parcelRecycle(obtain);
        return new String(d16);
    }

    public NS_MOBILE_OPERATION.AudioInfo toNSAudioInfo() {
        return new NS_MOBILE_OPERATION.AudioInfo(this.audioKey, this.audioTime);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AudioInfo {\n");
        if (!TextUtils.isEmpty(this.audioKey)) {
            sb5.append("audioKey: ");
            sb5.append(this.audioKey);
            sb5.append("\n");
        }
        sb5.append("audioTime: ");
        sb5.append(this.audioTime);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.errorMessage)) {
            sb5.append("errorMessage: ");
            sb5.append(this.errorMessage);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public AudioInfo(String str, int i3, String str2) {
        this.audioKey = str;
        this.audioTime = i3;
        this.errorMessage = str2;
    }

    public static AudioInfo fromString(String str) {
        Parcel parcel;
        byte[] b16;
        Parcel parcel2 = null;
        try {
            b16 = com.qzone.proxy.feedcomponent.util.b.b(str.getBytes(), 0);
            parcel = Parcel.obtain();
        } catch (Exception unused) {
            parcel = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            parcel.unmarshall(b16, 0, b16.length);
            parcel.setDataPosition(0);
            AudioInfo audioInfo = (AudioInfo) ParcelableWrapper.createDataFromParcel(parcel);
            OaidMonitor.parcelRecycle(parcel);
            return audioInfo;
        } catch (Exception unused2) {
            if (parcel == null) {
                return null;
            }
            OaidMonitor.parcelRecycle(parcel);
            return null;
        } catch (Throwable th6) {
            th = th6;
            parcel2 = parcel;
            if (parcel2 != null) {
                OaidMonitor.parcelRecycle(parcel2);
            }
            throw th;
        }
    }
}
