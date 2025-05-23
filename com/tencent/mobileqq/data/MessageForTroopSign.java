package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.u;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopSign extends MessageForStructing {
    public static final String TAG = "MessageForTroopSign";
    public String dynamicSource;
    public String markDesc;
    public String markIconUrl;
    public int markType;
    public String markWord;
    public String msgAction;
    public String msgBrief;
    public String msgContent;
    public String msgCoverUrl;
    public String msgTitle;
    public int positonType;
    public String srcAction;
    public String srcIconUrl;
    public String srcName;

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) this.structingMsg;
        this.srcName = structMsgForGeneralShare.mSourceName;
        this.srcAction = structMsgForGeneralShare.mSourceUrl;
        this.srcIconUrl = structMsgForGeneralShare.mSourceIcon;
        this.msgBrief = structMsgForGeneralShare.mMsgBrief;
        this.msgAction = structMsgForGeneralShare.mMsgUrl;
        List<AbsStructMsgElement> list = structMsgForGeneralShare.mStructMsgItemLists;
        if (list != null && list.size() > 0) {
            AbsStructMsgElement absStructMsgElement = list.get(0);
            if (absStructMsgElement instanceof u) {
                u uVar = (u) absStructMsgElement;
                ArrayList<AbsStructMsgElement> arrayList = uVar.U0;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "doParse, mCommonData=" + uVar.G);
                    }
                    if (!TextUtils.isEmpty(uVar.G)) {
                        JSONObject jSONObject = new JSONObject(uVar.G);
                        this.markType = jSONObject.getInt("markType");
                        this.positonType = jSONObject.getInt("positonType");
                        this.markIconUrl = jSONObject.getString("markIconUrl");
                        this.markWord = jSONObject.getString("markWord");
                        this.markDesc = jSONObject.getString("markDesc");
                        this.dynamicSource = jSONObject.optString("dynamicSource", null);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "doParse:" + e16.toString());
                    }
                }
                Iterator<AbsStructMsgElement> it = arrayList.iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    String str = next.f290322e;
                    if ("vote".equals(str)) {
                        if (next instanceof com.tencent.mobileqq.structmsg.view.c) {
                            this.msgCoverUrl = ((com.tencent.mobileqq.structmsg.view.c) next).S0;
                        }
                    } else if ("summary".equals(str)) {
                        if (next instanceof ap) {
                            this.msgContent = ((ap) next).t();
                        }
                    } else if ("title".equals(str) && (next instanceof StructMsgItemTitle)) {
                        this.msgTitle = ((StructMsgItemTitle) next).t();
                    }
                }
            }
        }
        this.f203106msg = getSummaryMsg();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doParse:" + toString());
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (TextUtils.isEmpty(this.msgBrief)) {
            this.msgBrief = HardCodeUtil.qqStr(R.string.o1x);
        }
        return this.msgBrief;
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForSign{msgCoverUrl=" + this.msgCoverUrl + ", msgAction=" + this.msgAction + ", msgTitle=" + this.msgTitle + ", msgContent=" + this.msgContent + ", srcName=" + this.srcName + ", srcAction=" + this.srcAction + ", srcIconUrl=" + this.srcIconUrl + ", msgBrief=" + this.msgBrief + ", markType=" + this.markType + ", positonType=" + this.positonType + ", markIconUrl=" + this.markIconUrl + ", markWord=" + this.markWord + ", markDesc=" + this.markDesc + '}';
    }
}
