package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes5.dex */
public class ColorNote extends Entity implements Serializable, Cloneable {
    public static final String PARAM_EXTRA = "param_extra";
    public static final String PARAM_EXTRA_FLAG = "param_extra_flag";
    public static final String PARAM_MAINTITLE = "param_main_title";
    public static final String PARAM_PIC_URL = "param_pic_url";
    public static final String PARAM_RESERVE = "param_reserve";
    public static final String PARAM_SERVICETYPE = "param_service_type";
    public static final String PARAM_SUBTITLE = "param_sub_title";
    public static final String PARAM_SUBTYPE = "param_sub_type";
    public static final int STATE_NORMAL = 1;
    public static final int STATE_OPEN = 2;
    public static final String TAG = "ColorNote";
    public static final int TYPE_HISTORY = 2;
    public static final int TYPE_NORMAL = 0;
    private static final long serialVersionUID = -2145926824830169542L;

    @notColumn
    public boolean animate;
    public long mExtLong;
    public int mExtra;
    public String mMainTitle;
    public String mPicUrl;
    public byte[] mReserve;
    public final int mServiceType;
    public int mState;
    public String mSubTitle;
    public final String mSubType;
    public final long mTime;
    public final String mUniKey;

    @notColumn
    public long mVisibleTime;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f201389a;

        /* renamed from: b, reason: collision with root package name */
        String f201390b;

        /* renamed from: c, reason: collision with root package name */
        int f201391c = 0;

        /* renamed from: d, reason: collision with root package name */
        String f201392d;

        /* renamed from: e, reason: collision with root package name */
        String f201393e;

        /* renamed from: f, reason: collision with root package name */
        String f201394f;

        /* renamed from: g, reason: collision with root package name */
        byte[] f201395g;

        /* renamed from: h, reason: collision with root package name */
        long f201396h;

        public ColorNote a() {
            return new ColorNote(this);
        }

        public a b(long j3) {
            this.f201396h = j3;
            return this;
        }

        public a c(int i3) {
            this.f201391c = i3;
            return this;
        }

        public a d(String str) {
            this.f201392d = str;
            return this;
        }

        public a e(String str) {
            this.f201394f = str;
            return this;
        }

        public a f(byte[] bArr) {
            this.f201395g = bArr;
            return this;
        }

        public a g(int i3) {
            this.f201389a = i3;
            return this;
        }

        public a h(String str) {
            this.f201393e = str;
            return this;
        }

        public a i(String str) {
            this.f201390b = str;
            return this;
        }
    }

    @Deprecated
    public ColorNote() {
        this.mState = 1;
        this.mExtra = 0;
        this.mVisibleTime = 0L;
        this.mServiceType = -1;
        this.mSubType = "";
        this.mUniKey = String.valueOf(-1) + "" + this.mExtra;
        this.mTime = NetConnInfoCenter.getServerTime();
    }

    private ColorNote deepCopy() {
        return new ColorNote(this);
    }

    private static String desensitizeLog(String str) {
        if (str != null && !str.isEmpty()) {
            if (QLog.isColorLevel()) {
                return str;
            }
            return "";
        }
        return str;
    }

    private static boolean propertyEquals(String str, String str2) {
        if ((!TextUtils.isEmpty(str)) ^ (!TextUtils.isEmpty(str2))) {
            return false;
        }
        if (str == null) {
            return true;
        }
        return str.equals(str2);
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        return deepCopy();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ColorNote)) {
            return false;
        }
        ColorNote colorNote = (ColorNote) obj;
        if (this.mServiceType != colorNote.getServiceType() || !propertyEquals(this.mSubType, colorNote.getSubType()) || !propertyEquals(this.mMainTitle, colorNote.getMainTitle()) || !propertyEquals(this.mSubTitle, colorNote.getSubTitle()) || this.mExtra != colorNote.mExtra) {
            return false;
        }
        return true;
    }

    public long getExtLong() {
        return this.mExtLong;
    }

    public String getMainTitle() {
        return this.mMainTitle;
    }

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public byte[] getReserve() {
        return this.mReserve;
    }

    public int getServiceType() {
        return this.mServiceType;
    }

    public int getState() {
        return this.mState;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getSubType() {
        return this.mSubType;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getUniKey() {
        return this.mServiceType + this.mSubType + this.mExtra;
    }

    public boolean isOpen() {
        if (this.mState == 2) {
            return true;
        }
        return false;
    }

    public boolean isTitleAndPicValid() {
        if (!TextUtils.isEmpty(this.mMainTitle) && !TextUtils.isEmpty(this.mSubTitle) && !TextUtils.isEmpty(this.mPicUrl)) {
            return true;
        }
        return false;
    }

    public Bundle parseBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_SERVICETYPE, this.mServiceType);
        bundle.putString(PARAM_SUBTYPE, this.mSubType);
        bundle.putString(PARAM_MAINTITLE, this.mMainTitle);
        bundle.putString(PARAM_SUBTITLE, this.mSubTitle);
        bundle.putString(PARAM_PIC_URL, this.mPicUrl);
        bundle.putByteArray(PARAM_RESERVE, this.mReserve);
        bundle.putInt(PARAM_EXTRA, this.mExtra);
        bundle.putLong(PARAM_EXTRA_FLAG, this.mExtLong);
        return bundle;
    }

    public void setState(int i3) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setState [ ");
            if (i3 == 2) {
                str = "STATE_OPEN ]";
            } else {
                str = "STATE_NORMAL ]";
            }
            sb5.append(str);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (i3 == 2) {
            this.mVisibleTime = System.currentTimeMillis();
        }
        this.mState = i3;
    }

    public void setType(int i3) {
        this.mExtra = i3;
    }

    public String toString() {
        return "hash: " + hashCode() + ". ColorNote{mServiceType=" + this.mServiceType + ", mSubType='" + desensitizeLog(this.mSubType) + "', mUniKey='" + desensitizeLog(this.mUniKey) + "', mTime=" + this.mTime + ", mPicUrl='" + this.mPicUrl + "', mState=" + this.mState + ", mExtra" + this.mExtra + ", extLong" + this.mExtLong + '}';
    }

    public ColorNote(ColorNote colorNote) {
        this.mState = 1;
        this.mExtra = 0;
        this.mVisibleTime = 0L;
        this.mServiceType = colorNote.getServiceType();
        this.mSubType = colorNote.getSubType();
        this.mUniKey = colorNote.getUniKey();
        this.mTime = colorNote.mTime;
        this.mMainTitle = colorNote.getMainTitle();
        this.mSubTitle = colorNote.getSubTitle();
        this.mPicUrl = colorNote.getPicUrl();
        this.mReserve = colorNote.getReserve();
        this.mState = colorNote.getState();
        this.mExtra = colorNote.mExtra;
        this.animate = colorNote.animate;
        this.mExtLong = colorNote.mExtLong;
        this.mVisibleTime = colorNote.mVisibleTime;
    }

    public ColorNote(Bundle bundle) {
        this.mState = 1;
        this.mExtra = 0;
        this.mVisibleTime = 0L;
        int i3 = bundle.getInt(PARAM_SERVICETYPE, -1);
        this.mServiceType = i3;
        String string = bundle.getString(PARAM_SUBTYPE, "");
        this.mSubType = string;
        this.mExtra = bundle.getInt(PARAM_EXTRA, 1);
        this.mUniKey = String.valueOf(i3) + string + this.mExtra;
        this.mTime = NetConnInfoCenter.getServerTime();
        this.mVisibleTime = System.currentTimeMillis();
        this.mMainTitle = bundle.getString(PARAM_MAINTITLE);
        this.mSubTitle = bundle.getString(PARAM_SUBTITLE);
        this.mPicUrl = bundle.getString(PARAM_PIC_URL);
        this.mReserve = bundle.getByteArray(PARAM_RESERVE);
        this.mExtLong = bundle.getLong(PARAM_EXTRA_FLAG, 0L);
        if ((i3 == -1 || TextUtils.isEmpty(string)) && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Illegal param mServiceType = " + i3 + ", mSubType = " + string);
        }
    }

    public ColorNote(a aVar) {
        this.mState = 1;
        this.mExtra = 0;
        this.mVisibleTime = 0L;
        int i3 = aVar.f201389a;
        this.mServiceType = i3;
        String str = aVar.f201390b;
        this.mSubType = str;
        this.mSubTitle = aVar.f201393e;
        this.mMainTitle = aVar.f201392d;
        this.mPicUrl = aVar.f201394f;
        this.mReserve = aVar.f201395g;
        this.mExtra = aVar.f201391c;
        this.mExtLong = aVar.f201396h;
        this.mUniKey = aVar.f201389a + aVar.f201390b + aVar.f201391c;
        this.mTime = NetConnInfoCenter.getServerTime();
        this.mVisibleTime = System.currentTimeMillis();
        if ((i3 == -1 || TextUtils.isEmpty(str)) && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Illegal param mServiceType = " + i3 + ", mSubType = " + desensitizeLog(str));
        }
    }
}
