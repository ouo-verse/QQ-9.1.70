package com.tencent.mobileqq.icgame.api.room;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.icgame.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQLiveAudienceRoomService extends QRouteApi {
    void enterAudienceRoom(Context context, QQLiveSwitchRoom qQLiveSwitchRoom, Bundle bundle);
}
