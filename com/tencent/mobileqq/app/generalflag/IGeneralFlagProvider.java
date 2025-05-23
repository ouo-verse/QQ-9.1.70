package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* loaded from: classes11.dex */
public interface IGeneralFlagProvider {
    boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags);
}
