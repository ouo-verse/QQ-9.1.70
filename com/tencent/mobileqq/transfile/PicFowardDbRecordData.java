package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class PicFowardDbRecordData {
    static IPatchRedirector $redirector_;
    public int fowardOrgFileSizeType;
    public long fowardOrgId;
    public String fowardOrgUin;
    public int fowardOrgUinType;
    public String fowardOrgUrl;
    public String fowardThumbPath;

    public PicFowardDbRecordData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void initFromMsg(String str) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() > 12 && (split = str.split("\\|")) != null) {
            if (split.length >= 13) {
                try {
                    this.fowardOrgId = Long.parseLong(split[12]);
                } catch (Exception unused) {
                    this.fowardOrgId = -1L;
                }
            }
            if (split.length >= 14) {
                this.fowardOrgUin = split[13];
            }
            if (split.length >= 15) {
                try {
                    this.fowardOrgUinType = Integer.parseInt(split[14]);
                } catch (Exception unused2) {
                    this.fowardOrgUinType = -1;
                }
            }
            if (split.length >= 16) {
                try {
                    this.fowardOrgUrl = split[15];
                } catch (Exception unused3) {
                    this.fowardOrgUrl = null;
                }
            }
            if (split.length >= 17) {
                try {
                    this.fowardThumbPath = split[16];
                } catch (Exception unused4) {
                    this.fowardThumbPath = null;
                }
            }
            if (split.length >= 18) {
                try {
                    this.fowardOrgFileSizeType = Integer.parseInt(split[17]);
                } catch (Exception unused5) {
                    this.fowardOrgFileSizeType = -1;
                }
            }
        }
    }
}
