package com.tencent.mobileqq.troop.observer;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x971.oidb_0x971$NoticeInfo;
import tencent.im.oidb.cmd0x971.oidb_0x971$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b extends ProtoUtils.TroopProtocolObserver {
    static IPatchRedirector $redirector_;

    public b() {
        super(false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void b(boolean z16, List<TroopAioKeywordTipInfo> list);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
            return;
        }
        if (i3 == 0) {
            oidb_0x971$RspBody oidb_0x971_rspbody = new oidb_0x971$RspBody();
            try {
                oidb_0x971_rspbody.mergeFrom(bArr);
                if (oidb_0x971_rspbody.notices.has()) {
                    arrayList = new ArrayList();
                    for (oidb_0x971$NoticeInfo oidb_0x971_noticeinfo : oidb_0x971_rspbody.notices.get()) {
                        TroopAioKeywordTipInfo troopAioKeywordTipInfo = new TroopAioKeywordTipInfo();
                        troopAioKeywordTipInfo.ruleId = oidb_0x971_noticeinfo.rule_id.get();
                        troopAioKeywordTipInfo.title = oidb_0x971_noticeinfo.title.get();
                        troopAioKeywordTipInfo.summary = oidb_0x971_noticeinfo.summary.get();
                        troopAioKeywordTipInfo.url = oidb_0x971_noticeinfo.url.get();
                        troopAioKeywordTipInfo.icon = oidb_0x971_noticeinfo.icon.get();
                        troopAioKeywordTipInfo.version = oidb_0x971_noticeinfo.version.get();
                        arrayList.add(troopAioKeywordTipInfo);
                    }
                } else {
                    arrayList = null;
                }
                b(true, arrayList);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i("KeywordTipInfoObserver", 1, "KeywordTipInfoObserver, e=" + e16.toString());
                b(false, null);
                return;
            }
        }
        QLog.i("KeywordTipInfoObserver", 1, "KeywordTipInfoObserver, errorCode=" + i3);
        b(false, null);
    }
}
