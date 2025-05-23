package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$InternalInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianInternalInfo extends Entity {
    static IPatchRedirector $redirector_;
    public byte[] infoByte;
    public String mobile;

    @unique
    public String uin;

    public QidianInternalInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uin = "";
            this.mobile = "";
        }
    }

    public void from(mobileqq_qidian$InternalInfo mobileqq_qidian_internalinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mobileqq_qidian_internalinfo);
            return;
        }
        this.infoByte = mobileqq_qidian_internalinfo.toByteArray();
        if (mobileqq_qidian_internalinfo.uint64_uin.has()) {
            this.uin = String.valueOf(mobileqq_qidian_internalinfo.uint64_uin.get());
        }
        if (mobileqq_qidian_internalinfo.str_internal_mobile.has()) {
            this.mobile = mobileqq_qidian_internalinfo.str_internal_mobile.get();
        }
    }

    public mobileqq_qidian$InternalInfo to() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (mobileqq_qidian$InternalInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        mobileqq_qidian$InternalInfo mobileqq_qidian_internalinfo = new mobileqq_qidian$InternalInfo();
        mobileqq_qidian_internalinfo.str_internal_mobile.set(this.mobile);
        mobileqq_qidian_internalinfo.uint64_uin.set(Long.parseLong(this.uin));
        return mobileqq_qidian_internalinfo;
    }

    public void update(QidianInternalInfo qidianInternalInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qidianInternalInfo);
        } else if (qidianInternalInfo != null && this.uin.equals(qidianInternalInfo.uin)) {
            if (!TextUtils.isEmpty(qidianInternalInfo.mobile)) {
                this.mobile = qidianInternalInfo.mobile;
            }
            this.infoByte = to().toByteArray();
        }
    }
}
