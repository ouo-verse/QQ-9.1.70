package com.tencent.qqnt.aio.gametail.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gametail.api.IAIOGameTailApi;
import com.tencent.qqnt.aio.gametail.api.JumpType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/gametail/api/impl/AIOGameTailApiImpl;", "Lcom/tencent/qqnt/aio/gametail/api/IAIOGameTailApi;", "", "appId", "", "appType", "msgTimestamp", "Lcom/tencent/qqnt/aio/gametail/api/a;", "getGamePicTailInfo", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOGameTailApiImpl implements IAIOGameTailApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350218a;

        static {
            int[] iArr = new int[IGameAioLittleTailApi.JumpType.values().length];
            try {
                iArr[IGameAioLittleTailApi.JumpType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IGameAioLittleTailApi.JumpType.SCHEMA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f350218a = iArr;
        }
    }

    @Override // com.tencent.qqnt.aio.gametail.api.IAIOGameTailApi
    public com.tencent.qqnt.aio.gametail.api.a getGamePicTailInfo(long appId, int appType, long msgTimestamp) {
        JumpType jumpType;
        JumpType jumpType2;
        IGameAioLittleTailApi.LittleTailInfo queryGamePicLittleTailInfo = ((IGameAioLittleTailApi) QRoute.api(IGameAioLittleTailApi.class)).queryGamePicLittleTailInfo(appId, appType, msgTimestamp);
        if (queryGamePicLittleTailInfo == null) {
            return null;
        }
        int i3 = a.f350218a[queryGamePicLittleTailInfo.getJumpType().ordinal()];
        if (i3 == 1) {
            jumpType = JumpType.HTTP;
        } else if (i3 == 2) {
            jumpType = JumpType.SCHEMA;
        } else {
            jumpType2 = null;
            if (jumpType2 == JumpType.HTTP && jumpType2 != JumpType.SCHEMA) {
                QLog.i("SplashAIOFragment", 1, "getGamePicTailInfo type error:" + queryGamePicLittleTailInfo.getJumpType());
                return null;
            }
            return new com.tencent.qqnt.aio.gametail.api.a(queryGamePicLittleTailInfo.getAppId(), queryGamePicLittleTailInfo.getAppName(), queryGamePicLittleTailInfo.getText(), queryGamePicLittleTailInfo.getIconUrl(), queryGamePicLittleTailInfo.getJumpUrl(), jumpType2, queryGamePicLittleTailInfo.getBgColor(), queryGamePicLittleTailInfo.getTextColor());
        }
        jumpType2 = jumpType;
        if (jumpType2 == JumpType.HTTP) {
        }
        return new com.tencent.qqnt.aio.gametail.api.a(queryGamePicLittleTailInfo.getAppId(), queryGamePicLittleTailInfo.getAppName(), queryGamePicLittleTailInfo.getText(), queryGamePicLittleTailInfo.getIconUrl(), queryGamePicLittleTailInfo.getJumpUrl(), jumpType2, queryGamePicLittleTailInfo.getBgColor(), queryGamePicLittleTailInfo.getTextColor());
    }
}
