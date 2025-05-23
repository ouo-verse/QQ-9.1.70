package com.tencent.mobileqq.fts.data.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.a;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.fts.v2.entity.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TroopIndex extends FTSEntityV2 {
    static IPatchRedirector $redirector_;
    public String content;
    public String contentindex;
    public String ext4;
    public String ext5;
    public String ext6;
    public String ext7;
    public String ext8;
    public String ext9;

    @notColumn
    public String mMemberCard;

    @notColumn
    public String mMemberName;

    @notColumn
    public String mMemberNick;

    @notColumn
    public String mMemberUin;

    @notColumn
    public String mTroopUin;
    public long oId;
    public int type;

    public TroopIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.type = -1;
        this.content = null;
        this.contentindex = null;
        this.oId = -1L;
        this.ext4 = null;
        this.ext5 = null;
        this.ext6 = null;
        this.ext7 = null;
        this.ext8 = null;
        this.ext9 = null;
    }

    @Override // com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
    protected void doDeserialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mTroopUin = this.ext1;
        this.mMemberName = this.ext2;
        this.mMemberCard = this.ext4;
        this.mMemberUin = this.ext6;
        this.mMemberNick = this.ext7;
    }

    @Override // com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
    protected void doSerialize() {
        String replace;
        String replace2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.type = 2;
        this.ext1 = this.mTroopUin;
        String str = this.mMemberName;
        if (str == null) {
            replace = "";
        } else {
            replace = str.replace("'", "''");
        }
        this.mMemberName = replace;
        String str2 = this.mMemberCard;
        if (str2 == null) {
            replace2 = "";
        } else {
            replace2 = str2.replace("'", "''");
        }
        this.mMemberCard = replace2;
        String str3 = this.mMemberName;
        this.ext2 = str3;
        if (TextUtils.isEmpty(str3)) {
            this.ext3 = "";
        } else {
            this.ext3 = a.e(this.ext2);
        }
        String str4 = this.mMemberCard;
        this.ext4 = str4;
        if (TextUtils.isEmpty(str4)) {
            this.ext5 = "";
        } else {
            this.ext5 = a.e(this.ext4);
        }
        this.ext6 = this.mMemberUin;
        String str5 = this.mMemberNick;
        this.ext7 = str5;
        if (TextUtils.isEmpty(str5)) {
            this.ext8 = "";
        } else {
            this.ext8 = a.e(this.ext7);
        }
        this.ext9 = "";
        this.content = "";
        this.contentindex = "";
    }

    @Override // com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
    public boolean needCompress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.postRead();
            doDeserialize();
        }
    }

    @Override // com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
    public synchronized void preWrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            doSerialize();
            super.preWrite();
        }
    }

    public TroopIndex(int i3, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, str4, str5);
            return;
        }
        this.content = null;
        this.contentindex = null;
        this.oId = -1L;
        this.ext4 = null;
        this.ext5 = null;
        this.ext6 = null;
        this.ext7 = null;
        this.ext8 = null;
        this.ext9 = null;
        this.type = i3;
        this.mTroopUin = str;
        this.mMemberUin = str2;
        this.mMemberName = str3;
        this.mMemberCard = str4;
        this.mMemberNick = str5;
    }
}
