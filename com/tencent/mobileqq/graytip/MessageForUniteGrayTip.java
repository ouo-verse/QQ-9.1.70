package com.tencent.mobileqq.graytip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.uniteGrayTip.UniteGrayTip$BusinessData;
import localpb.uniteGrayTip.UniteGrayTip$HightlightParam;
import localpb.uniteGrayTip.UniteGrayTip$UniteGrayTipMsg;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MessageForUniteGrayTip extends ChatMessage {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_BYTES_CONTENT = "bytes_content";
    public static final String KEY_SOURCE_DATA = "key_source_data";
    public static final String KEY_UINT64_BUSI_ID = "uint64_busi_id";
    public static final String KEY_UINT64_BUSI_TYPE = "uint64_busi_type";
    public static final String KEY_UINT64_TEMPL_ID = "uint64_templ_id";
    public static final String KEY_UINT64_TIPS_SEQ_ID = "uint64_tips_seq_id";
    public static final String TAG = "MessageForUniteGrayTip";
    public String appGuideTipsOpKey;
    public String caidanAnimUrl;
    public String caidanAnimUrlMd5;
    public e callback;
    public String contentDescription;
    public boolean dkTipHasReport;
    public boolean docTipHasReport;
    public String editMsgData;
    public int editState;
    public long editTime;

    @notColumn
    public UniteEntity entity;
    public String extUin;
    public int hasRead;
    public String masterUin;
    public int subType;

    @notColumn
    public long targetMsgSeq;
    public String taskId;
    public g tipParam;
    public boolean troopLuckyCharacterTipsHasReport;
    public boolean troopMemberLevelTipHasReport;

    @notColumn
    public d uniteCombineGrayTipParam;

    public MessageForUniteGrayTip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.editState = 0;
        this.editTime = 0L;
        this.editMsgData = null;
        this.docTipHasReport = false;
        this.dkTipHasReport = false;
        this.troopMemberLevelTipHasReport = false;
        this.troopLuckyCharacterTipsHasReport = false;
        this.uniteCombineGrayTipParam = null;
        this.targetMsgSeq = -1L;
    }

    private void encode() {
        if (this.tipParam == null) {
            QLog.e(TAG, 1, "MessageForUniteGrayTip, encode failed, tipParam == null");
            return;
        }
        UniteGrayTip$UniteGrayTipMsg uniteGrayTip$UniteGrayTipMsg = new UniteGrayTip$UniteGrayTipMsg();
        uniteGrayTip$UniteGrayTipMsg.graytip_id.set(this.tipParam.f213685h);
        uniteGrayTip$UniteGrayTipMsg.graytip_level.set(this.tipParam.f213691n);
        int[] iArr = this.tipParam.f213692o;
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                uniteGrayTip$UniteGrayTipMsg.graytip_mutex_id.add(Integer.valueOf(i3));
            }
        }
        if (!TextUtils.isEmpty(this.tipParam.f213693p)) {
            uniteGrayTip$UniteGrayTipMsg.graytip_key.set(this.tipParam.f213693p);
        }
        if (!TextUtils.isEmpty(this.tipParam.f213683f)) {
            uniteGrayTip$UniteGrayTipMsg.content.set(this.tipParam.f213683f);
        }
        ArrayList<GrayTipsMessageConstants$HighlightItem> f16 = this.tipParam.f();
        if (f16 != null && !f16.isEmpty()) {
            Iterator<GrayTipsMessageConstants$HighlightItem> it = f16.iterator();
            while (it.hasNext()) {
                GrayTipsMessageConstants$HighlightItem next = it.next();
                UniteGrayTip$HightlightParam uniteGrayTip$HightlightParam = new UniteGrayTip$HightlightParam();
                uniteGrayTip$HightlightParam.start.set(next.start);
                uniteGrayTip$HightlightParam.end.set(next.end);
                uniteGrayTip$HightlightParam.uin.set(next.uin);
                uniteGrayTip$HightlightParam.needUpdateNick.set(next.needUpdateNick ? 1 : 0);
                uniteGrayTip$HightlightParam.actionType.set(next.actionType);
                uniteGrayTip$HightlightParam.textColor.set(next.textColor);
                if (!TextUtils.isEmpty(next.icon)) {
                    uniteGrayTip$HightlightParam.icon.set(next.icon);
                }
                if (!TextUtils.isEmpty(next.iconAlt)) {
                    uniteGrayTip$HightlightParam.iconAlt.set(next.iconAlt);
                }
                if (!TextUtils.isEmpty(next.mMsgActionData)) {
                    uniteGrayTip$HightlightParam.mMsgActionData.set(next.mMsgActionData);
                }
                if (!TextUtils.isEmpty(next.mMsgAActionData)) {
                    uniteGrayTip$HightlightParam.mMsg_A_ActionData.set(next.mMsgAActionData);
                }
                uniteGrayTip$UniteGrayTipMsg.hightlight_item.add(uniteGrayTip$HightlightParam);
            }
        }
        uniteGrayTip$UniteGrayTipMsg.isLocalTroopMsg.set(this.tipParam.f213695r ? 1 : 0);
        UniteGrayTip$BusinessData uniteGrayTip$BusinessData = new UniteGrayTip$BusinessData();
        uniteGrayTip$BusinessData.haveRead.set(this.hasRead);
        uniteGrayTip$BusinessData.subType.set(this.subType);
        if (!TextUtils.isEmpty(this.masterUin)) {
            uniteGrayTip$BusinessData.masterUin.set(this.masterUin);
        }
        if (!TextUtils.isEmpty(this.extUin)) {
            uniteGrayTip$BusinessData.extUin.set(this.extUin);
        }
        if (!TextUtils.isEmpty(this.taskId)) {
            uniteGrayTip$BusinessData.taskId.set(this.taskId);
        }
        uniteGrayTip$BusinessData.editState.set(this.editState);
        uniteGrayTip$BusinessData.editTime.set(this.editTime);
        if (!TextUtils.isEmpty(this.editMsgData)) {
            uniteGrayTip$BusinessData.editMsgData.set(this.editMsgData);
        }
        if (!TextUtils.isEmpty(this.caidanAnimUrl)) {
            uniteGrayTip$BusinessData.caidanAnimUrl.set(this.caidanAnimUrl);
        }
        if (!TextUtils.isEmpty(this.caidanAnimUrlMd5)) {
            uniteGrayTip$BusinessData.caidanAnimUrlMd5.set(this.caidanAnimUrlMd5);
        }
        uniteGrayTip$UniteGrayTipMsg.business_data.set(uniteGrayTip$BusinessData);
        this.msgData = uniteGrayTip$UniteGrayTipMsg.toByteArray();
    }

    private GrayTipsMessageConstants$HighlightItem findHighlightItem(int i3, List<GrayTipsMessageConstants$HighlightItem> list) {
        for (int i16 = 0; list != null && i16 < list.size(); i16++) {
            GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem = list.get(i16);
            if (i3 >= grayTipsMessageConstants$HighlightItem.start && i3 < grayTipsMessageConstants$HighlightItem.end) {
                return grayTipsMessageConstants$HighlightItem;
            }
        }
        return null;
    }

    @NonNull
    private String getSummaryForUniteGrayTip(String str) {
        StringBuilder sb5 = new StringBuilder();
        ArrayList<GrayTipsMessageConstants$HighlightItem> f16 = this.tipParam.f();
        int i3 = 0;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            GrayTipsMessageConstants$HighlightItem findHighlightItem = findHighlightItem(i3, f16);
            if (findHighlightItem != null && !TextUtils.isEmpty(findHighlightItem.icon)) {
                String substring = str.substring(findHighlightItem.start, findHighlightItem.end);
                if (!TextUtils.isEmpty(findHighlightItem.iconAlt)) {
                    sb5.append(substring);
                }
                i3 += (findHighlightItem.end - findHighlightItem.start) - 1;
            } else {
                sb5.append(charAt);
            }
            i3++;
        }
        String sb6 = sb5.toString();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSummaryMsg() msg=[" + str + "],summary=[" + sb6 + "]");
        }
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        String str;
        int[] iArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.msgData == null) {
            QLog.e(TAG, 1, "doParse failed for msgData == null");
            return;
        }
        UniteGrayTip$UniteGrayTipMsg uniteGrayTip$UniteGrayTipMsg = new UniteGrayTip$UniteGrayTipMsg();
        try {
            uniteGrayTip$UniteGrayTipMsg.mergeFrom(this.msgData);
            int i3 = uniteGrayTip$UniteGrayTipMsg.graytip_id.get();
            int i16 = uniteGrayTip$UniteGrayTipMsg.graytip_level.get();
            String str2 = uniteGrayTip$UniteGrayTipMsg.graytip_key.get();
            String str3 = uniteGrayTip$UniteGrayTipMsg.content.get();
            int i17 = uniteGrayTip$UniteGrayTipMsg.isLocalTroopMsg.get();
            ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList = null;
            if (uniteGrayTip$UniteGrayTipMsg.graytip_mutex_id.has() && uniteGrayTip$UniteGrayTipMsg.graytip_mutex_id.size() > 0) {
                ArrayList arrayList2 = (ArrayList) uniteGrayTip$UniteGrayTipMsg.graytip_mutex_id.get();
                int[] iArr2 = new int[arrayList2.size()];
                for (int i18 = 0; i18 < arrayList2.size() - 1; i18++) {
                    iArr2[i18] = ((Integer) arrayList2.get(i18)).intValue();
                }
                iArr = iArr2;
            } else {
                iArr = null;
            }
            if (uniteGrayTip$UniteGrayTipMsg.hightlight_item.has() && uniteGrayTip$UniteGrayTipMsg.hightlight_item.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator it = ((ArrayList) uniteGrayTip$UniteGrayTipMsg.hightlight_item.get()).iterator();
                while (it.hasNext()) {
                    UniteGrayTip$HightlightParam uniteGrayTip$HightlightParam = (UniteGrayTip$HightlightParam) it.next();
                    arrayList.add(new GrayTipsMessageConstants$HighlightItem(uniteGrayTip$HightlightParam.start.get(), uniteGrayTip$HightlightParam.end.get(), uniteGrayTip$HightlightParam.uin.get(), uniteGrayTip$HightlightParam.needUpdateNick.get(), uniteGrayTip$HightlightParam.actionType.get(), uniteGrayTip$HightlightParam.mMsgActionData.get(), uniteGrayTip$HightlightParam.mMsg_A_ActionData.get(), uniteGrayTip$HightlightParam.icon.get(), uniteGrayTip$HightlightParam.iconAlt.get(), uniteGrayTip$HightlightParam.textColor.get()));
                }
            }
            ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList3 = arrayList;
            String str4 = this.frienduin;
            String str5 = this.senderuin;
            int i19 = this.istroop;
            int i26 = this.msgtype;
            long j3 = this.time;
            str = TAG;
            int[] iArr3 = iArr;
            try {
                g gVar = new g(str4, str5, str3, i19, i26, i3, j3);
                this.tipParam = gVar;
                gVar.f213693p = str2;
                gVar.f213691n = i16;
                gVar.f213692o = iArr3;
                gVar.k(arrayList3);
                g gVar2 = this.tipParam;
                if (i17 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                gVar2.f213695r = z16;
                this.f203106msg = str3;
                UniteGrayTip$BusinessData uniteGrayTip$BusinessData = uniteGrayTip$UniteGrayTipMsg.business_data.get();
                if (uniteGrayTip$BusinessData != null) {
                    this.hasRead = uniteGrayTip$BusinessData.haveRead.get();
                    this.subType = uniteGrayTip$BusinessData.subType.get();
                    if (uniteGrayTip$BusinessData.masterUin.has()) {
                        this.masterUin = uniteGrayTip$BusinessData.masterUin.get();
                    }
                    if (uniteGrayTip$BusinessData.extUin.has()) {
                        this.extUin = uniteGrayTip$BusinessData.extUin.get();
                    }
                    if (uniteGrayTip$BusinessData.taskId.has()) {
                        this.taskId = uniteGrayTip$BusinessData.taskId.get();
                    }
                    if (uniteGrayTip$BusinessData.editState.has()) {
                        this.editState = uniteGrayTip$BusinessData.editState.get();
                    }
                    if (uniteGrayTip$BusinessData.editTime.has()) {
                        this.editTime = uniteGrayTip$BusinessData.editTime.get();
                    }
                    if (uniteGrayTip$BusinessData.editMsgData.has()) {
                        this.editMsgData = uniteGrayTip$BusinessData.editMsgData.get();
                    }
                    if (uniteGrayTip$BusinessData.caidanAnimUrl.has()) {
                        this.caidanAnimUrl = uniteGrayTip$BusinessData.caidanAnimUrl.get();
                    }
                    if (uniteGrayTip$BusinessData.caidanAnimUrlMd5.has()) {
                        this.caidanAnimUrlMd5 = uniteGrayTip$BusinessData.caidanAnimUrlMd5.get();
                    }
                }
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                QLog.e(str, 1, "MessageForUniteGrayTip, doParese failed, " + e.getMessage());
            }
        } catch (Exception e17) {
            e = e17;
            str = TAG;
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = this.f203106msg;
        g gVar = this.tipParam;
        if (gVar != null && gVar.f213685h == 655397 && str != null) {
            return getSummaryForUniteGrayTip(str);
        }
        return super.getSummaryMsg();
    }

    public void initGrayTipMsg(AppRuntime appRuntime, g gVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) gVar);
            return;
        }
        if (gVar != null && gVar.c()) {
            String account = appRuntime.getAccount();
            String str2 = gVar.f213681d;
            String str3 = gVar.f213682e;
            String str4 = gVar.f213683f;
            long j3 = gVar.f213686i;
            init(account, str2, str3, str4, j3, gVar.f213687j, gVar.f213684g, j3);
            this.mIsParsed = true;
            this.isread = true;
            this.tipParam = gVar;
            this.msgData = null;
            return;
        }
        if (QLog.isColorLevel()) {
            if (gVar == null) {
                str = "null tipParam";
            } else {
                str = "msgtype: " + gVar.f213687j + " id: " + gVar.f213685h;
            }
            QLog.e(TAG, 2, "revoke msg createGrayTipMsg failed, error: " + str);
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean needShowTimeStamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        g gVar = this.tipParam;
        if (gVar != null && gVar.f213685h == 656395) {
            return false;
        }
        if (gVar != null && gVar.f213685h == 656396) {
            return false;
        }
        return super.needShowTimeStamp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            parse();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            encode();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "MessageForUniteGrayTip, prewrite failed, " + e16.getMessage());
        }
    }

    public void updateUniteGrayTipMsg(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateUniteGrayTipMsg");
        }
        this.f203106msg = str;
        g gVar = this.tipParam;
        if (gVar != null) {
            gVar.f213683f = str;
            prewrite();
            ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
        }
    }

    public void updateUniteGrayTipMsgData(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
        } else {
            prewrite();
            ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
        }
    }
}
