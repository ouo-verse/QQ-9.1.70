package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import com.qzone.misc.network.uploader.report.BusinessReport;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class SafeParcelableSerializer {
    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        S createFromParcel = creator.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return createFromParcel;
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (S) deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        return (S) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (bundle == null || (arrayList = (ArrayList) bundle.getSerializable(str)) == null) {
            return null;
        }
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            anonymousClass1.add((BusinessReport.AnonymousClass1) deserializeFromBytes((byte[]) it.next(), creator));
        }
        return anonymousClass1;
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            anonymousClass1.add((BusinessReport.AnonymousClass1) deserializeFromBytes((byte[]) it.next(), creator));
        }
        return anonymousClass1;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S s16) {
        Parcel obtain = Parcel.obtain();
        s16.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s16, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(s16));
    }

    public static <S extends SafeParcelable> String serializeToString(S s16) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(s16));
    }
}
