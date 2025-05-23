package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.qqnt.aio.adapter.api.IAIOLocationShareApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOLocationShareApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOLocationShareApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "onClickLocationShare", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "getLocationShareStatus", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOLocationShareApiImpl implements IAIOLocationShareApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOLocationShareApi
    public boolean getLocationShareStatus(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        SessionInfo a16 = su3.b.a(g16);
        AIOParam g17 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        Integer p16 = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(g17)));
        Intrinsics.checkNotNullExpressionValue(p16, "getOldUinType(aioContext.aioParam.getChatType())");
        int intValue = p16.intValue();
        String str = a16.f179557e;
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
        return com.tencent.mobileqq.location.e.b((QQAppInterface) peekAppRuntime).isSessionSharingLocation(intValue, str);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOLocationShareApi
    public void onClickLocationShare(Context context, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ILocationShareService b16 = com.tencent.mobileqq.location.e.b((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        if (context instanceof Activity) {
            Integer p16 = IceBreakingUtil.p(Integer.valueOf(msgRecord.chatType));
            Intrinsics.checkNotNullExpressionValue(p16, "getOldUinType(msgRecord.chatType)");
            b16.launchShareUi((Activity) context, p16.intValue(), String.valueOf(msgRecord.peerUin), 2);
        }
    }
}
