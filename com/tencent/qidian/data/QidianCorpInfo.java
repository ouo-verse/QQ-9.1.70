package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$CorpInfo;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianCorpInfo extends Entity {
    static IPatchRedirector $redirector_;
    public String corpAddr;
    public String corpCall;
    public String corpCode;
    public String corpFullName;
    public String corpHome;
    public String corpIntro;
    public String corpLogo;
    public String corpName;

    @unique
    public String corpUin;
    public byte[] infoByte;

    public QidianCorpInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.corpUin = "";
        this.corpIntro = "";
        this.corpHome = "";
        this.corpAddr = "";
        this.corpCall = "";
        this.corpCode = "";
        this.corpLogo = "";
        this.corpName = "";
        this.corpFullName = "";
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
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
        return Arrays.equals(this.infoByte, ((QidianCorpInfo) obj).infoByte);
    }

    public void from(mobileqq_qidian$CorpInfo mobileqq_qidian_corpinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mobileqq_qidian_corpinfo);
            return;
        }
        this.infoByte = mobileqq_qidian_corpinfo.toByteArray();
        if (mobileqq_qidian_corpinfo.str_corp_intro.has()) {
            this.corpIntro = mobileqq_qidian_corpinfo.str_corp_intro.get();
        }
        if (mobileqq_qidian_corpinfo.str_homepage.has()) {
            this.corpHome = mobileqq_qidian_corpinfo.str_homepage.get();
        }
        if (mobileqq_qidian_corpinfo.str_address.has()) {
            this.corpAddr = mobileqq_qidian_corpinfo.str_address.get();
        }
        if (mobileqq_qidian_corpinfo.str_corp_call.has()) {
            this.corpCall = mobileqq_qidian_corpinfo.str_corp_call.get();
        }
        if (mobileqq_qidian_corpinfo.str_postcode.has()) {
            this.corpCode = mobileqq_qidian_corpinfo.str_postcode.get();
        }
        if (mobileqq_qidian_corpinfo.str_logo.has()) {
            this.corpLogo = mobileqq_qidian_corpinfo.str_logo.get();
        }
        if (mobileqq_qidian_corpinfo.str_corp_short_name.has()) {
            this.corpName = mobileqq_qidian_corpinfo.str_corp_short_name.get();
        }
        if (mobileqq_qidian_corpinfo.uint64_master_uin.has()) {
            this.corpUin = String.valueOf(mobileqq_qidian_corpinfo.uint64_master_uin.get());
        }
        if (mobileqq_qidian_corpinfo.str_corp_full_name.has()) {
            this.corpFullName = mobileqq_qidian_corpinfo.str_corp_full_name.get();
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return Arrays.hashCode(this.infoByte);
    }

    public mobileqq_qidian$CorpInfo to() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (mobileqq_qidian$CorpInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        mobileqq_qidian$CorpInfo mobileqq_qidian_corpinfo = new mobileqq_qidian$CorpInfo();
        mobileqq_qidian_corpinfo.str_corp_short_name.set(this.corpName);
        mobileqq_qidian_corpinfo.str_corp_intro.set(this.corpIntro);
        mobileqq_qidian_corpinfo.str_homepage.set(this.corpHome);
        mobileqq_qidian_corpinfo.str_address.set(this.corpAddr);
        mobileqq_qidian_corpinfo.str_corp_call.set(this.corpCall);
        mobileqq_qidian_corpinfo.str_postcode.set(this.corpCode);
        mobileqq_qidian_corpinfo.str_logo.set(this.corpLogo);
        mobileqq_qidian_corpinfo.uint64_master_uin.set(Long.parseLong(this.corpUin));
        mobileqq_qidian_corpinfo.str_corp_full_name.set(this.corpFullName);
        return mobileqq_qidian_corpinfo;
    }

    public void update(QidianCorpInfo qidianCorpInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qidianCorpInfo);
            return;
        }
        if (qidianCorpInfo != null && this.corpUin.equals(qidianCorpInfo.corpUin)) {
            if (!TextUtils.isEmpty(qidianCorpInfo.corpAddr)) {
                this.corpAddr = qidianCorpInfo.corpAddr;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpHome)) {
                this.corpHome = qidianCorpInfo.corpHome;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpIntro)) {
                this.corpIntro = qidianCorpInfo.corpIntro;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpCall)) {
                this.corpCall = qidianCorpInfo.corpCall;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpCode)) {
                this.corpCode = qidianCorpInfo.corpCode;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpLogo)) {
                this.corpLogo = qidianCorpInfo.corpLogo;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpName)) {
                this.corpName = qidianCorpInfo.corpName;
            }
            if (!TextUtils.isEmpty(qidianCorpInfo.corpFullName)) {
                this.corpFullName = qidianCorpInfo.corpFullName;
            }
            this.infoByte = to().toByteArray();
        }
    }
}
