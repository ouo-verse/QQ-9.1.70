package cooperation.qqfav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static e f390608c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f390609a = false;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<a> f390610b = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public Intent f390611a;
    }

    e() {
    }

    public static e a() {
        if (f390608c == null) {
            synchronized (e.class) {
                if (f390608c == null) {
                    f390608c = new e();
                }
            }
        }
        return f390608c;
    }

    public boolean b() {
        boolean isEmpty;
        synchronized (this.f390610b) {
            isEmpty = this.f390610b.isEmpty();
        }
        return isEmpty;
    }

    public byte[] c() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        synchronized (this.f390610b) {
            if (this.f390610b.isEmpty()) {
                return null;
            }
            Iterator<a> it = this.f390610b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f390611a.getExtras());
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pendingData", arrayList);
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return marshall;
        }
    }

    public List<Bundle> d(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return bundle.getParcelableArrayList("pendingData");
        }
        return null;
    }
}
