package com.tencent.mobileqq.qcall;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCallCardInfo extends Entity implements Cloneable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final int CARD_BLACK = 2;
    public static final int CARD_FREE = 1;
    public static final Parcelable.Creator<QCallCardInfo> CREATOR;
    public static int HIDE;
    public static final int NONE = 0;
    public static int SHOW;
    public String autoRemark;
    public int birthday;

    @notColumn
    public int card_type;

    @notColumn
    public int contact_qq_status;

    @notColumn
    public int freeStatus;
    public int gender;
    public int identity;
    public int in_use_flag;

    @notColumn
    public int isPopup;
    public int is_ever_pstn;
    public View.OnClickListener mOnClickListener;
    public int netstatus;
    public String nickname;
    public int normal_all_free_time;
    public int normal_left_free_time;
    public int phone_mask;
    public String phonenum;
    public int pre_recycle_flag;

    @notColumn
    public int pstn_freeStatus;

    @notColumn
    public int qid_qq_status;

    /* renamed from: qq, reason: collision with root package name */
    public String f261492qq;

    @Deprecated
    public long qqUin;
    public String qqUin2;
    public int recycle_flag;
    public String recycle_ip;
    public int recycle_time;
    public String reg_ip;
    public int reg_time;
    public String remark;

    @unique
    public String uin;
    public int used_free_time;
    public int vip_all_free_time;
    public int vip_left_free_time;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<QCallCardInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCallCardInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QCallCardInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            QCallCardInfo qCallCardInfo = new QCallCardInfo();
            qCallCardInfo.uin = parcel.readString();
            qCallCardInfo.nickname = parcel.readString();
            qCallCardInfo.gender = parcel.readInt();
            qCallCardInfo.birthday = parcel.readInt();
            qCallCardInfo.in_use_flag = parcel.readInt();
            qCallCardInfo.pre_recycle_flag = parcel.readInt();
            qCallCardInfo.recycle_flag = parcel.readInt();
            qCallCardInfo.reg_time = parcel.readInt();
            qCallCardInfo.reg_ip = parcel.readString();
            qCallCardInfo.recycle_time = parcel.readInt();
            qCallCardInfo.recycle_ip = parcel.readString();
            qCallCardInfo.remark = parcel.readString();
            qCallCardInfo.netstatus = parcel.readInt();
            qCallCardInfo.f261492qq = parcel.readString();
            qCallCardInfo.phonenum = parcel.readString();
            qCallCardInfo.phone_mask = parcel.readInt();
            qCallCardInfo.freeStatus = parcel.readInt();
            qCallCardInfo.pstn_freeStatus = parcel.readInt();
            qCallCardInfo.is_ever_pstn = parcel.readInt();
            qCallCardInfo.vip_all_free_time = parcel.readInt();
            qCallCardInfo.vip_left_free_time = parcel.readInt();
            qCallCardInfo.normal_all_free_time = parcel.readInt();
            qCallCardInfo.normal_left_free_time = parcel.readInt();
            qCallCardInfo.used_free_time = parcel.readInt();
            qCallCardInfo.identity = parcel.readInt();
            qCallCardInfo.autoRemark = parcel.readString();
            qCallCardInfo.card_type = parcel.readInt();
            qCallCardInfo.isPopup = parcel.readInt();
            qCallCardInfo.qqUin2 = parcel.readString();
            qCallCardInfo.qid_qq_status = parcel.readInt();
            qCallCardInfo.contact_qq_status = parcel.readInt();
            return qCallCardInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QCallCardInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QCallCardInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new QCallCardInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74357);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        SHOW = 0;
        HIDE = 1;
        CREATOR = new a();
    }

    public QCallCardInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public int getCardType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.card_type;
    }

    public boolean isHideMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.phone_mask == HIDE) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "[ qid=" + g.b(this.uin) + ",nickname=" + StringUtil.crypticCenter(this.nickname) + ",in_use_flag=" + this.in_use_flag + ",phoneNum=" + g.b(this.phonenum) + ",phone_mask=" + this.phone_mask + ",qqUin=" + g.b(this.f261492qq) + ",qqUin2=" + g.b(this.qqUin2) + ",remark=" + this.remark + ",network=" + this.netstatus + ",autoRemark=" + this.autoRemark + ",freestatus=" + this.freeStatus + ",pstn_freestatus=" + this.pstn_freeStatus + ",card_type=" + this.card_type + ",is_ever_pstn=" + this.is_ever_pstn + ",vip_all_free_time=" + this.vip_all_free_time + ",vip_left_free_time=" + this.vip_left_free_time + ",normal_all_free_time=" + this.normal_all_free_time + ",normal_left_free_time=" + this.normal_left_free_time + ",used_free_time=" + this.used_free_time + ",identity=" + this.identity + ",isPopup=" + this.isPopup + ",qid_qq_status=" + this.qid_qq_status + ",contact_qq_status=" + this.contact_qq_status + " ] ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        try {
            parcel.writeString(this.uin);
            parcel.writeString(this.nickname);
            parcel.writeInt(this.gender);
            parcel.writeInt(this.birthday);
            parcel.writeInt(this.in_use_flag);
            parcel.writeInt(this.pre_recycle_flag);
            parcel.writeInt(this.recycle_flag);
            parcel.writeInt(this.reg_time);
            parcel.writeString(this.reg_ip);
            parcel.writeInt(this.recycle_time);
            parcel.writeString(this.recycle_ip);
            parcel.writeString(this.remark);
            parcel.writeInt(this.netstatus);
            parcel.writeString(this.f261492qq);
            parcel.writeString(this.phonenum);
            parcel.writeInt(this.phone_mask);
            parcel.writeInt(this.freeStatus);
            parcel.writeInt(this.pstn_freeStatus);
            parcel.writeInt(this.is_ever_pstn);
            parcel.writeInt(this.vip_all_free_time);
            parcel.writeInt(this.vip_left_free_time);
            parcel.writeInt(this.normal_all_free_time);
            parcel.writeInt(this.normal_left_free_time);
            parcel.writeInt(this.used_free_time);
            parcel.writeInt(this.identity);
            parcel.writeString(this.autoRemark);
            parcel.writeInt(this.card_type);
            parcel.writeInt(this.isPopup);
            parcel.writeString(this.qqUin2);
            parcel.writeInt(this.qid_qq_status);
            parcel.writeInt(this.contact_qq_status);
        } catch (RuntimeException unused) {
        }
    }
}
