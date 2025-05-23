package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void c(HashMap<String, ArrayList<MessageRecord>> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<MessageRecord> arrayList = hashMap.get(it.next());
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    MessageRecord messageRecord = arrayList.get(i3);
                    if ((messageRecord instanceof MessageForFile) || (messageRecord instanceof MessageForTroopFile)) {
                        arrayList.set(i3, this.f251587a.getProxyManager().k().c(messageRecord, HardCodeUtil.qqStr(R.string.b5h) + messageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), true));
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.multimsg.a, com.tencent.mobileqq.multimsg.c
    public void a(h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        tb1.b cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, hVar, hashMap, dVar);
            return;
        }
        if (hVar == null) {
            return;
        }
        int i3 = hVar.f251625i;
        if (i3 != 8 && i3 != 9) {
            if (i3 == 2) {
                c(hashMap);
                dVar.c(0, 2, hVar);
                return;
            }
            cVar = new tb1.a(this.f251587a, hVar, hashMap, dVar);
        } else {
            cVar = new tb1.c(this.f251587a, hVar, hashMap, dVar);
        }
        this.f251587a.getFileManagerEngine().O().j(cVar, hashMap);
    }
}
