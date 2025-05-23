package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ab implements u {

    /* renamed from: d, reason: collision with root package name */
    protected MessageForReplyText.SourceMsgInfo f178761d;

    public static void a(StringBuilder sb5, MessageForStructing messageForStructing, boolean z16) {
        StructMsgForGeneralShare structMsgForGeneralShare;
        List<AbsStructMsgElement> list;
        com.tencent.mobileqq.structmsg.a aVar;
        ArrayList<AbsStructMsgElement> arrayList;
        if (!b()) {
            return;
        }
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if ((absStructMsg instanceof StructMsgForGeneralShare) && (list = (structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg).mStructMsgItemLists) != null && !list.isEmpty()) {
            AbsStructMsgElement absStructMsgElement = structMsgForGeneralShare.mStructMsgItemLists.get(0);
            if ((absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) && (arrayList = (aVar = (com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0) != null && !arrayList.isEmpty()) {
                AbsStructMsgElement absStructMsgElement2 = aVar.U0.get(0);
                if (!(absStructMsgElement2 instanceof StructMsgItemTitle)) {
                    return;
                }
                if (z16) {
                    sb5.append(HardCodeUtil.qqStr(R.string.kcn));
                }
                sb5.append(((StructMsgItemTitle) absStructMsgElement2).X0);
            }
        }
    }

    public static boolean b() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("reply_msg_optimization", true);
    }

    public MessageForReplyText.SourceMsgInfo c() {
        return this.f178761d;
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
    }
}
