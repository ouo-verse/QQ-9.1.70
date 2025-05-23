package com.tencent.mobileqq.selectmember;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements com.tencent.mobileqq.graytip.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private UniteEntity.Note[] d(UniteEntity.Note note) {
        ArrayList<UniteEntity.Note> subNotes;
        boolean z16;
        if (note == null || (subNotes = note.getSubNotes()) == null) {
            return null;
        }
        UniteEntity.Note[] noteArr = new UniteEntity.Note[2];
        Iterator<UniteEntity.Note> it = subNotes.iterator();
        while (it.hasNext()) {
            UniteEntity.Note next = it.next();
            if (next.getNoteType() == 4) {
                if (noteArr[0] == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    noteArr[0] = next;
                } else {
                    noteArr[1] = next;
                }
            }
        }
        return noteArr;
    }

    private String e(@NonNull UniteEntity.Note note) {
        HashMap<Integer, Object> fields = note.getFields();
        if (fields == null) {
            return null;
        }
        Iterator<Map.Entry<Integer, Object>> it = fields.entrySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next().getKey();
            if (key.intValue() == 6) {
                return (String) fields.get(key);
            }
        }
        return null;
    }

    private boolean f(long j3) {
        if (j3 != 10179 && j3 != 10180) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.graytip.b
    public boolean a(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) messageForUniteGrayTip)).booleanValue();
        }
        if (messageForUniteGrayTip == null || !f(NumberUtil.stringToLong(messageForUniteGrayTip.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID), -1L))) {
            return false;
        }
        return !com.tencent.mobileqq.selectmember.util.b.a(appRuntime);
    }

    @Override // com.tencent.mobileqq.graytip.b
    public void b(MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForUniteGrayTip);
            return;
        }
        if (messageForUniteGrayTip == null || !f(NumberUtil.stringToLong(messageForUniteGrayTip.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID), -1L))) {
            return;
        }
        QLog.d("InviteGrayTipsProcessor", 1, "handleTipsNoticeCreate");
        g gVar = messageForUniteGrayTip.tipParam;
        if (gVar == null) {
            return;
        }
        String string = gVar.f213688k.getString("inviteeUin", null);
        String string2 = gVar.f213688k.getString("invitorUin", null);
        if (string != null && string2 != null) {
            messageForUniteGrayTip.saveExtInfoToExtStr("inviteeUin", string);
            messageForUniteGrayTip.saveExtInfoToExtStr("invitorUin", string2);
        }
    }

    @Override // com.tencent.mobileqq.graytip.b
    public void c(g gVar, UniteEntity.Note note, int i3, String str, long j3) {
        UniteEntity.Note note2;
        UniteEntity.Note note3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, gVar, note, Integer.valueOf(i3), str, Long.valueOf(j3));
            return;
        }
        if (!f(j3)) {
            return;
        }
        QLog.d("InviteGrayTipsProcessor", 1, "handleInitGrayTipsParams");
        UniteEntity.Note[] d16 = d(note);
        if (d16 != null && d16.length >= 2 && (note2 = d16[0]) != null && (note3 = d16[1]) != null) {
            String e16 = e(note2);
            String e17 = e(note3);
            if (e16 != null && e17 != null) {
                gVar.f213688k.putString("inviteeUin", e16);
                gVar.f213688k.putString("invitorUin", e17);
                QLog.d("InviteGrayTipsProcessor", 1, "invitor uin : ", StringUtil.getSimpleUinForPrint(e16), " invited uin : ", StringUtil.getSimpleUinForPrint(e17));
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null || peekAppRuntime.getCurrentAccountUin() == null) {
                    return;
                }
                gVar.f213682e = e17;
                if (((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str) == null) {
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).saveTroopInCache(new TroopInfo(str));
                }
            }
        }
    }
}
