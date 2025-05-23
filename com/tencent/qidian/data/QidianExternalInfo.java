package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$CompanyShowCaseInfo;
import com.tencent.qidian.proto.mobileqq_qidian$ExternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian$GroupItem;
import com.tencent.qidian.proto.mobileqq_qidian$PubAccItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianExternalInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QidianExternalInfo";
    public long city;
    public long country;
    public long district;
    public long externalOidbflag;
    public int gender;
    public String icon;
    public byte[] infoByte;
    public int isShowCall;
    public int isShowVideoCall;
    public String job;
    private List<a> mCompanyShowCaseInfos;
    private List<b> mGroupItems;
    private List<b> mGroupItemsCorp;
    private List<c> mPubAccItems;
    private List<c> mPubAccItemsCorp;
    public String mail;
    public String masterUin;
    public String mobile;
    public String nickname;
    public long province;
    public String sign;
    public String tel;

    @unique
    public String uin;
    public String verify_url;
    public int verity;

    public QidianExternalInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.uin = "";
        this.masterUin = "";
        this.nickname = "";
        this.icon = "";
        this.sign = "";
        this.job = "";
        this.tel = "";
        this.mobile = "";
        this.mail = "";
        this.mPubAccItems = null;
        this.mPubAccItemsCorp = null;
        this.mGroupItems = null;
        this.mGroupItemsCorp = null;
        this.mCompanyShowCaseInfos = null;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return Arrays.equals(this.infoByte, ((QidianExternalInfo) obj).infoByte);
    }

    public void from(mobileqq_qidian$ExternalInfo mobileqq_qidian_externalinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileqq_qidian_externalinfo);
            return;
        }
        this.infoByte = mobileqq_qidian_externalinfo.toByteArray();
        if (mobileqq_qidian_externalinfo.uint64_uin.has()) {
            this.uin = String.valueOf(mobileqq_qidian_externalinfo.uint64_uin.get());
        }
        if (mobileqq_qidian_externalinfo.str_external_nick.has()) {
            this.nickname = mobileqq_qidian_externalinfo.str_external_nick.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_icon.has()) {
            this.icon = mobileqq_qidian_externalinfo.str_external_icon.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_sign.has()) {
            this.sign = mobileqq_qidian_externalinfo.str_external_sign.get();
        }
        if (mobileqq_qidian_externalinfo.uint32_external_gender.has()) {
            this.gender = mobileqq_qidian_externalinfo.uint32_external_gender.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_external_country.has()) {
            this.country = mobileqq_qidian_externalinfo.uint64_external_country.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_external_province.has()) {
            this.province = mobileqq_qidian_externalinfo.uint64_external_province.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_external_city.has()) {
            this.city = mobileqq_qidian_externalinfo.uint64_external_city.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_external_district.has()) {
            this.district = mobileqq_qidian_externalinfo.uint64_external_district.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_job.has()) {
            this.job = mobileqq_qidian_externalinfo.str_external_job.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_tel.has()) {
            this.tel = mobileqq_qidian_externalinfo.str_external_tel.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_mobile.has()) {
            this.mobile = mobileqq_qidian_externalinfo.str_external_mobile.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_external_oidbflag.has()) {
            this.externalOidbflag = mobileqq_qidian_externalinfo.uint64_external_oidbflag.get();
        }
        if (mobileqq_qidian_externalinfo.str_external_mail.has()) {
            this.mail = mobileqq_qidian_externalinfo.str_external_mail.get();
        }
        if (mobileqq_qidian_externalinfo.uint64_master_uin.has()) {
            this.masterUin = String.valueOf(mobileqq_qidian_externalinfo.uint64_master_uin.get());
        }
        if (mobileqq_qidian_externalinfo.uint32_verity.has()) {
            this.verity = mobileqq_qidian_externalinfo.uint32_verity.get();
        }
        if (mobileqq_qidian_externalinfo.uint32_entcallshow.has()) {
            this.isShowCall = mobileqq_qidian_externalinfo.uint32_entcallshow.get();
        }
        if (mobileqq_qidian_externalinfo.uint32_videoshow.has()) {
            this.isShowVideoCall = mobileqq_qidian_externalinfo.uint32_videoshow.get();
        }
        if (mobileqq_qidian_externalinfo.str_thirdpart_verity_icon.has()) {
            this.verify_url = mobileqq_qidian_externalinfo.str_thirdpart_verity_icon.get();
        }
        initList();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Load from server: " + toString());
        }
    }

    public List<a> getCompanyShowCaseInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mCompanyShowCaseInfos;
    }

    public List<b> getGroupItemsCorp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mGroupItemsCorp;
    }

    public List<b> getGroupItemsUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mGroupItems;
    }

    public List<c> getPublicAccountItemsCorp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mPubAccItemsCorp;
    }

    public List<c> getPublicAccountItemsUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mPubAccItems;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return Arrays.hashCode(this.infoByte);
    }

    public void initList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (this.infoByte != null) {
                mobileqq_qidian$ExternalInfo mobileqq_qidian_externalinfo = new mobileqq_qidian$ExternalInfo();
                mobileqq_qidian_externalinfo.mergeFrom(this.infoByte);
                if (mobileqq_qidian_externalinfo.rpt_msg_pubacc_item.has()) {
                    this.mPubAccItems = new ArrayList();
                    Iterator<mobileqq_qidian$PubAccItem> it = mobileqq_qidian_externalinfo.rpt_msg_pubacc_item.get().iterator();
                    while (it.hasNext()) {
                        this.mPubAccItems.add(new c(it.next()));
                    }
                }
                if (mobileqq_qidian_externalinfo.rpt_msg_pubacc_item_corp.has()) {
                    this.mPubAccItemsCorp = new ArrayList();
                    Iterator<mobileqq_qidian$PubAccItem> it5 = mobileqq_qidian_externalinfo.rpt_msg_pubacc_item_corp.get().iterator();
                    while (it5.hasNext()) {
                        this.mPubAccItemsCorp.add(new c(it5.next()));
                    }
                }
                if (mobileqq_qidian_externalinfo.rpt_msg_group_item.has()) {
                    this.mGroupItems = new ArrayList();
                    Iterator<mobileqq_qidian$GroupItem> it6 = mobileqq_qidian_externalinfo.rpt_msg_group_item.get().iterator();
                    while (it6.hasNext()) {
                        this.mGroupItems.add(new b(it6.next()));
                    }
                }
                if (mobileqq_qidian_externalinfo.rpt_msg_group_item_corp.has()) {
                    this.mGroupItemsCorp = new ArrayList();
                    Iterator<mobileqq_qidian$GroupItem> it7 = mobileqq_qidian_externalinfo.rpt_msg_group_item_corp.get().iterator();
                    while (it7.hasNext()) {
                        this.mGroupItemsCorp.add(new b(it7.next()));
                    }
                }
                if (mobileqq_qidian_externalinfo.rpt_msg_company_show_case_info.has()) {
                    this.mCompanyShowCaseInfos = new ArrayList();
                    Iterator<mobileqq_qidian$CompanyShowCaseInfo> it8 = mobileqq_qidian_externalinfo.rpt_msg_company_show_case_info.get().iterator();
                    while (it8.hasNext()) {
                        this.mCompanyShowCaseInfos.add(new a(it8.next()));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean isExternalMobileVerified() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if ((this.externalOidbflag & 8) == 8) {
            return true;
        }
        return false;
    }

    public void setExternalMobileVerified(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else if (z16) {
            this.externalOidbflag |= 8;
        } else {
            this.externalOidbflag &= -9;
        }
    }

    public mobileqq_qidian$ExternalInfo to() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (mobileqq_qidian$ExternalInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        mobileqq_qidian$ExternalInfo mobileqq_qidian_externalinfo = new mobileqq_qidian$ExternalInfo();
        mobileqq_qidian_externalinfo.uint64_uin.set(Long.parseLong(this.uin));
        mobileqq_qidian_externalinfo.str_external_nick.set(this.nickname);
        mobileqq_qidian_externalinfo.str_external_icon.set(this.icon);
        mobileqq_qidian_externalinfo.str_external_sign.set(this.sign);
        mobileqq_qidian_externalinfo.uint32_external_gender.set(this.gender);
        mobileqq_qidian_externalinfo.uint64_external_country.set(this.country);
        mobileqq_qidian_externalinfo.uint64_external_province.set(this.province);
        mobileqq_qidian_externalinfo.uint64_external_city.set(this.city);
        mobileqq_qidian_externalinfo.uint64_external_district.set(this.district);
        mobileqq_qidian_externalinfo.str_external_job.set(this.job);
        mobileqq_qidian_externalinfo.str_external_tel.set(this.tel);
        mobileqq_qidian_externalinfo.str_external_mobile.set(this.mobile);
        mobileqq_qidian_externalinfo.uint64_external_oidbflag.set(this.externalOidbflag);
        mobileqq_qidian_externalinfo.str_external_mail.set(this.mail);
        List<c> list = this.mPubAccItems;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                mobileqq_qidian_externalinfo.rpt_msg_pubacc_item.add(it.next().b());
            }
        }
        List<c> list2 = this.mPubAccItemsCorp;
        if (list2 != null) {
            for (c cVar : list2) {
                if (cVar != null) {
                    mobileqq_qidian_externalinfo.rpt_msg_pubacc_item_corp.add(cVar.b());
                }
            }
        }
        List<b> list3 = this.mGroupItems;
        if (list3 != null) {
            Iterator<b> it5 = list3.iterator();
            while (it5.hasNext()) {
                mobileqq_qidian_externalinfo.rpt_msg_group_item.add(it5.next().b());
            }
        }
        List<b> list4 = this.mGroupItemsCorp;
        if (list4 != null) {
            for (b bVar : list4) {
                if (bVar != null) {
                    mobileqq_qidian_externalinfo.rpt_msg_group_item_corp.add(bVar.b());
                }
            }
        }
        List<a> list5 = this.mCompanyShowCaseInfos;
        if (list5 != null) {
            Iterator<a> it6 = list5.iterator();
            while (it6.hasNext()) {
                mobileqq_qidian_externalinfo.rpt_msg_company_show_case_info.add(it6.next().b());
            }
        }
        mobileqq_qidian_externalinfo.uint64_master_uin.set(Long.parseLong(this.masterUin));
        mobileqq_qidian_externalinfo.uint32_verity.set(this.verity);
        mobileqq_qidian_externalinfo.uint32_entcallshow.set(this.isShowCall);
        mobileqq_qidian_externalinfo.uint32_videoshow.set(this.isShowVideoCall);
        return mobileqq_qidian_externalinfo;
    }

    public void update(QidianExternalInfo qidianExternalInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qidianExternalInfo);
            return;
        }
        if (qidianExternalInfo != null && this.uin.equals(qidianExternalInfo.uin)) {
            if (!TextUtils.isEmpty(qidianExternalInfo.masterUin)) {
                this.masterUin = qidianExternalInfo.masterUin;
            }
            if (!TextUtils.isEmpty(qidianExternalInfo.nickname)) {
                this.nickname = qidianExternalInfo.nickname;
            }
            if (!TextUtils.isEmpty(qidianExternalInfo.icon)) {
                this.icon = qidianExternalInfo.icon;
            }
            this.sign = qidianExternalInfo.sign;
            if (!TextUtils.isEmpty(qidianExternalInfo.job)) {
                this.job = qidianExternalInfo.job;
            }
            if (!TextUtils.isEmpty(qidianExternalInfo.tel)) {
                this.tel = qidianExternalInfo.tel;
            }
            if (!TextUtils.isEmpty(qidianExternalInfo.mobile)) {
                this.mobile = qidianExternalInfo.mobile;
            }
            this.externalOidbflag = qidianExternalInfo.externalOidbflag;
            if (!TextUtils.isEmpty(qidianExternalInfo.mail)) {
                this.mail = qidianExternalInfo.mail;
            }
            long j3 = qidianExternalInfo.country;
            if (j3 > 0) {
                this.country = j3;
            }
            long j16 = qidianExternalInfo.province;
            if (j16 > 0) {
                this.province = j16;
            }
            long j17 = qidianExternalInfo.city;
            if (j17 > 0) {
                this.city = j17;
            }
            long j18 = qidianExternalInfo.district;
            if (j18 > 0) {
                this.district = j18;
            }
            this.isShowCall = qidianExternalInfo.isShowCall;
            this.isShowVideoCall = qidianExternalInfo.isShowVideoCall;
            List<c> list = qidianExternalInfo.mPubAccItems;
            if (list != null) {
                this.mPubAccItems = list;
            }
            List<c> list2 = qidianExternalInfo.mPubAccItemsCorp;
            if (list2 != null) {
                this.mPubAccItemsCorp = list2;
            }
            List<b> list3 = qidianExternalInfo.mGroupItems;
            if (list3 != null) {
                this.mGroupItems = list3;
            }
            List<b> list4 = qidianExternalInfo.mGroupItemsCorp;
            if (list4 != null) {
                this.mGroupItemsCorp = list4;
            }
            this.mCompanyShowCaseInfos = qidianExternalInfo.mCompanyShowCaseInfos;
            this.verity = qidianExternalInfo.verity;
            if (!TextUtils.isEmpty(qidianExternalInfo.verify_url)) {
                this.verify_url = qidianExternalInfo.verify_url;
            }
            this.infoByte = qidianExternalInfo.to().toByteArray();
        }
    }
}
