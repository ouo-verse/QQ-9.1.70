package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorPrepareWrapper {
    public static final String QQLIVE_BIZID = "qlive";

    void destroy();

    byte[] getAuthExt(String str);

    IQQLiveAnchorPrepareObs getObsModule();

    QQLiveAnchorRoomInfo getRoomInfo();

    IQQLiveAnchorPrepareThirdPush getThirdPushModule(ViewGroup viewGroup);

    void init(IQQLiveSDK iQQLiveSDK, long j3, String str);

    void prepare(Activity activity, byte[] bArr, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback);

    void set(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, byte[] bArr, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback);
}
