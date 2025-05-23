package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OcrRecogResult extends Entity implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<OcrRecogResult> CREATOR;

    @unique
    public String filename;
    public String language;
    public String ocrContent;
    public ArrayList<String> ocr_languages;
    public long saveTime;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<OcrRecogResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OcrRecogResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (OcrRecogResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new OcrRecogResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OcrRecogResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (OcrRecogResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new OcrRecogResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public OcrRecogResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static OcrRecogResult find(EntityManager entityManager, String str) {
        if (entityManager != null && !TextUtils.isEmpty(str)) {
            return (OcrRecogResult) DBMethodProxy.find(entityManager, OcrRecogResult.class, "filename=?", new String[]{String.valueOf(str)});
        }
        return null;
    }

    public static void persistOrReplace(EntityManager entityManager, OcrRecogResult ocrRecogResult) {
        if (entityManager != null && ocrRecogResult != null && !TextUtils.isEmpty(ocrRecogResult.filename)) {
            entityManager.persistOrReplace(ocrRecogResult);
        }
    }

    public static boolean remove(EntityManager entityManager, String str) {
        OcrRecogResult find;
        if (entityManager != null && !TextUtils.isEmpty(str) && (find = find(entityManager, str)) != null) {
            return entityManager.remove(find);
        }
        return false;
    }

    public static void removeCache(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(OcrRecogResult.class);
        if (query != null && query.size() > 50) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                entityManager.remove((OcrRecogResult) it.next());
            }
            QLog.d(LogTag.TAG_OCR, 1, "removeCache size:" + query.size());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return TextUtils.isEmpty(this.ocrContent);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "OcrRecogResult ocrContent = " + this.ocrContent + "\nlanguage = " + this.language + "\nocr_languages = " + this.ocr_languages + "\nfilename = " + this.filename + "\nsaveTime = " + this.saveTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.filename);
        parcel.writeLong(this.saveTime);
        parcel.writeString(this.ocrContent);
        try {
            parcel.writeString(this.language);
            parcel.writeList(this.ocr_languages);
        } catch (Throwable th5) {
            QLog.e("OcrRecogResult", 1, "writeToParcel() e:" + th5.getMessage());
        }
    }

    protected OcrRecogResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.filename = parcel.readString();
        this.saveTime = parcel.readLong();
        this.ocrContent = parcel.readString();
        try {
            this.language = parcel.readString();
            this.ocr_languages = parcel.readArrayList(getClass().getClassLoader());
        } catch (Throwable th5) {
            this.language = null;
            this.ocr_languages = null;
            QLog.e("OcrRecogResult", 1, "OcrRecogResult(Parcel in) e:" + th5.getMessage());
        }
    }
}
