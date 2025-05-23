package com.tencent.qqnt.aio.locate.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.locate.MsgLocation;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001JK\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/locate/api/impl/MsgLocationApiImpl;", "Lcom/tencent/qqnt/aio/locate/api/IMsgLocationApi;", "()V", "jumpToTargetNTAIOPosition", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "uinType", "", "uin", "", "troopUin", AppConstants.Key.COLUMN_SHMSG_SEQ, "", "msgId", "chatType", "peerUid", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MsgLocationApiImpl implements IMsgLocationApi {
    private final /* synthetic */ MsgLocation $$delegate_0 = MsgLocation.INSTANCE;

    @Override // com.tencent.qqnt.aio.locate.api.IMsgLocationApi
    public void jumpToTargetNTAIOPosition(Activity activity, int uinType, String uin, String troopUin, long shmsgseq, long msgId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.$$delegate_0.jumpToTargetNTAIOPosition(activity, uinType, uin, troopUin, shmsgseq, msgId);
    }

    @Override // com.tencent.qqnt.aio.locate.api.IMsgLocationApi
    public void jumpToTargetNTAIOPosition(Activity activity, int uinType, String uin, String troopUin, long shmsgseq, long msgId, int chatType, String peerUid) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        this.$$delegate_0.jumpToTargetNTAIOPosition(activity, uinType, uin, troopUin, shmsgseq, msgId, chatType, peerUid);
    }
}
