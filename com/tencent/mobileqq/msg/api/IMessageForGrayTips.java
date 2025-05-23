package com.tencent.mobileqq.msg.api;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface IMessageForGrayTips extends IRuntimeService {
    void addHightlightItem(MessageRecord messageRecord, int i3, int i16, Bundle bundle);

    MessageRecord getMessageForGrayTips(int i3);

    boolean isMessageForSplitLineTips(MessageRecord messageRecord);

    void setTextGravity(MessageRecord messageRecord, int i3);
}
