package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {""})
/* loaded from: classes3.dex */
public interface IIndividualRedPacket extends IRuntimeService {
    void dealRedPacketToShow(RedPacketInfo redPacketInfo);

    boolean getIndividualRedPacketEnable();

    String getMallURL(int i3);

    int getRedPacketCannotUseFlag();

    int getRedPacketEnableFlag();

    String getTenpayCombineImg(String str, String str2);

    boolean isAllowShowRedpacket();

    boolean isIndividualRedPacketEnable();

    boolean isSDCardError();

    boolean isShowRedpacket();

    void setRedPacketFlags(int i3, int i16, boolean z16);
}
