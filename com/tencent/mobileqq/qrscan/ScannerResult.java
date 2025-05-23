package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScannerResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ScannerResult> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<QBarResult> f276520d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<QMiniResult> f276521e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f276522f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f276523h;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<ScannerResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScannerResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ScannerResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ScannerResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScannerResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ScannerResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ScannerResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            CREATOR = new a();
        }
    }

    public ScannerResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276522f = false;
            this.f276523h = false;
        }
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        } else {
            b(str, new Rect(), 0.0f, 0, 0, i3);
        }
    }

    public void b(String str, Rect rect, float f16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, rect, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if ((((IQRCodeApi) QRoute.api(IQRCodeApi.class)).isWxCodeSupported() && i17 == 3) || TextUtils.isEmpty(str)) {
            return;
        }
        QMiniResult qMiniResult = new QMiniResult();
        qMiniResult.f276511e = str;
        if (i3 > 0 && i16 > 0) {
            float f17 = i3;
            float f18 = i16;
            qMiniResult.f276512f = new RectF((rect.left * 1.0f) / f17, (rect.top * 1.0f) / f18, (rect.right * 1.0f) / f17, (rect.bottom * 1.0f) / f18);
        } else {
            qMiniResult.f276512f = new RectF();
        }
        qMiniResult.f276510d = f16;
        if (this.f276521e == null) {
            this.f276521e = new ArrayList<>();
        }
        if (i17 == 3) {
            qMiniResult.f276513h = "wx";
        } else if (i17 == 2) {
            qMiniResult.f276513h = "qq";
        }
        this.f276521e.add(qMiniResult);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<QMiniResult> arrayList = this.f276521e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.f276521e.get(0).f276511e;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 0;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<QMiniResult> arrayList = this.f276521e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.f276521e.get(0).f276513h;
        }
        return null;
    }

    public Pair<StringBuilder, StringBuilder> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<QBarResult> arrayList = this.f276520d;
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            sb5.append(this.f276520d.get(0).f276507e);
            sb6.append(this.f276520d.get(0).f276508f);
            return new Pair<>(sb6, sb5);
        }
        return null;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        boolean l3 = l();
        if (j()) {
            return (l3 ? 1 : 0) | 2;
        }
        return l3 ? 1 : 0;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        ArrayList<QMiniResult> arrayList = this.f276521e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean k() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        ArrayList<QBarResult> arrayList = this.f276520d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<QBarResult> it = this.f276520d.iterator();
            i3 = 0;
            while (it.hasNext()) {
                RectF rectF = it.next().f276509h;
                if (rectF != null && !rectF.isEmpty()) {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        ArrayList<QMiniResult> arrayList2 = this.f276521e;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            if (!this.f276522f) {
                return false;
            }
            Iterator<QMiniResult> it5 = this.f276521e.iterator();
            while (it5.hasNext()) {
                RectF rectF2 = it5.next().f276512f;
                if (rectF2 != null && !rectF2.isEmpty()) {
                    i3++;
                }
            }
        }
        if (i3 <= 1) {
            return false;
        }
        return true;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        ArrayList<QBarResult> arrayList = this.f276520d;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!j() && !l()) {
            return false;
        }
        return true;
    }

    public void n() {
        ArrayList<QMiniResult> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!m()) {
            return;
        }
        ArrayList<QBarResult> arrayList2 = this.f276520d;
        if (arrayList2 != null && arrayList2.size() > 1) {
            QBarResult qBarResult = this.f276520d.get(0);
            this.f276520d.clear();
            this.f276520d.add(qBarResult);
        }
        if (l() && (arrayList = this.f276521e) != null && !arrayList.isEmpty()) {
            this.f276521e.clear();
        }
        ArrayList<QMiniResult> arrayList3 = this.f276521e;
        if (arrayList3 != null && arrayList3.size() > 1) {
            QMiniResult qMiniResult = this.f276521e.get(0);
            this.f276521e.clear();
            this.f276521e.add(qMiniResult);
        }
    }

    public void o(SparseArray<Object> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sparseArray);
            return;
        }
        Pair<StringBuilder, StringBuilder> f16 = f();
        if (f16 != null) {
            sparseArray.put(1, f16);
        }
        String c16 = c();
        String e16 = e();
        if (!TextUtils.isEmpty(c16)) {
            sparseArray.put(2, c16);
            sparseArray.put(1001, e16);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "ScannerResult{hasQrCode:" + l() + " hasMiniCode:" + j() + " maybeMulti:" + this.f276523h + " hasMultiResult:" + k() + " qMiniUseAIDetect:" + this.f276522f + "\nqBarResults=" + this.f276520d + "\nqMiniResults=" + this.f276521e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeTypedList(this.f276520d);
        parcel.writeTypedList(this.f276521e);
        parcel.writeByte(this.f276522f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f276523h ? (byte) 1 : (byte) 0);
    }

    protected ScannerResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel);
            return;
        }
        this.f276522f = false;
        this.f276523h = false;
        this.f276520d = parcel.createTypedArrayList(QBarResult.CREATOR);
        this.f276521e = parcel.createTypedArrayList(QMiniResult.CREATOR);
        this.f276522f = parcel.readByte() != 0;
        this.f276523h = parcel.readByte() != 0;
    }
}
