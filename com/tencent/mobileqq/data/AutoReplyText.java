package com.tencent.mobileqq.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.text.QQText;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AutoReplyText extends Entity implements Comparable<AutoReplyText>, Parcelable {
    public static final Parcelable.Creator<AutoReplyText> CREATOR = new a();
    public static final int TEXT_NONE = Integer.MAX_VALUE;
    public int mCheckFlag;

    @notColumn
    private Bundle mExtra;
    public String mRawText;

    @unique
    public int mTextId;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<AutoReplyText> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AutoReplyText createFromParcel(Parcel parcel) {
            return new AutoReplyText(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AutoReplyText[] newArray(int i3) {
            return new AutoReplyText[i3];
        }
    }

    public AutoReplyText() {
        this.mCheckFlag = 0;
        this.mExtra = new Bundle();
    }

    public static String trimRawString(String str, boolean z16) {
        if (str == null) {
            return "";
        }
        if (z16) {
            str = str.replace("\r\n", " ").replace('\n', TokenParser.SP).replace('\r', TokenParser.SP);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt != ' ' && charAt != '\r' && charAt != '\n') {
                break;
            }
            i3++;
        }
        while (i3 < length) {
            char charAt2 = str.charAt(length - 1);
            if (charAt2 != ' ' && charAt2 != '\r' && charAt2 != '\n') {
                break;
            }
            length--;
        }
        if (i3 > 0 || length < str.length()) {
            return str.substring(i3, length);
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.mTextId == ((AutoReplyText) obj).mTextId) {
            return true;
        }
        return false;
    }

    @NonNull
    public Bundle getExtra() {
        return this.mExtra;
    }

    public String getRawText() {
        if (this.mRawText == null) {
            this.mRawText = "";
        }
        return this.mRawText;
    }

    public CharSequence getText(int i3) {
        return new QQText(getRawText(), 3, i3);
    }

    public int getTextId() {
        return this.mTextId;
    }

    public int hashCode() {
        return Integer.MAX_VALUE & (this.mTextId + 177573);
    }

    public boolean isChecked() {
        if (this.mCheckFlag == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AutoReplyText{mTextId=" + this.mTextId + ", mRawText='" + this.mRawText + ", mCheckFlag='" + this.mCheckFlag + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mTextId);
        parcel.writeString(this.mRawText);
        parcel.writeInt(this.mCheckFlag);
        parcel.writeBundle(this.mExtra);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull AutoReplyText autoReplyText) {
        int i3 = this.mTextId;
        int i16 = autoReplyText.mTextId;
        if (i3 < i16) {
            return -1;
        }
        return i3 == i16 ? 0 : 1;
    }

    public AutoReplyText(String str, int i3) {
        this.mCheckFlag = 0;
        this.mRawText = str;
        this.mTextId = i3;
        this.mExtra = new Bundle();
    }

    protected AutoReplyText(Parcel parcel) {
        this.mCheckFlag = 0;
        this.mTextId = parcel.readInt();
        this.mRawText = parcel.readString();
        this.mCheckFlag = parcel.readInt();
        this.mExtra = parcel.readBundle(getClass().getClassLoader());
    }
}
