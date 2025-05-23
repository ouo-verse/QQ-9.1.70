package com.tencent.mobileqq.qqgamepub.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {""})
/* loaded from: classes16.dex */
public interface IGamePubAccountMsgService extends IRuntimeService {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void onAccountChange();

    void onGameNewMsg(List<MsgRecord> list);

    void reqGamePaNoticeByTianShu();

    void saveGalleryDataToMsg(Bundle bundle);
}
