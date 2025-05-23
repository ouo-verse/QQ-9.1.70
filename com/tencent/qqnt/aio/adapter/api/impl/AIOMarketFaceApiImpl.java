package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMarketFaceApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOMarketFaceApi;", "Landroid/view/View;", "clickedView", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "", "enterMarketFacePreview", "paramMarketFaceElement", "", "source", "enterMarketFacePreviewWithSource", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOMarketFaceApiImpl implements IAIOMarketFaceApi {
    public static final String TAG = "AIOMarketFaceApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi
    public void enterMarketFacePreview(View clickedView, MsgRecord msgRecord, MarketFaceElement marketFaceElement) {
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        enterMarketFacePreviewWithSource(clickedView, msgRecord, marketFaceElement, 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi
    public void enterMarketFacePreviewWithSource(View clickedView, MsgRecord msgRecord, MarketFaceElement paramMarketFaceElement, int source) {
        MarketFaceElement marketFaceElement;
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement i3 = MsgExtKt.i(msgRecord, 11);
        if (paramMarketFaceElement == null) {
            marketFaceElement = i3 != null ? i3.marketFaceElement : null;
        } else {
            marketFaceElement = paramMarketFaceElement;
        }
        if (marketFaceElement == null) {
            QLog.e(TAG, 1, "enterMarketFacePreview failed, marketFaceElement is null!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "enterMarketFacePreview failed, app is not QQAppInterface!");
            return;
        }
        MarkFaceMessage d16 = com.tencent.qqnt.aio.adapter.marketface.a.f348768a.d(marketFaceElement);
        String valueOf = String.valueOf(msgRecord.peerUin);
        int c16 = su3.a.c(msgRecord);
        MessageForMarketFace x16 = com.tencent.mobileqq.service.message.q.x((QQAppInterface) peekAppRuntime, valueOf, valueOf, c16, d16);
        x16.uniseq = msgRecord.msgId;
        if (com.tencent.mobileqq.emotionintegrate.t.f205295a.b()) {
            x16.shmsgseq = msgRecord.msgSeq;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = c16;
        sessionInfo.f179559f = valueOf;
        sessionInfo.f179557e = valueOf;
        sessionInfo.f179563i = msgRecord.peerName;
        Bundle bundle = new Bundle();
        bundle.putInt("key_source", source);
        if (msgRecord.chatType == 3) {
            bundle.putBoolean("need_more_btn", false);
        }
        Context context = clickedView.getContext();
        if (context instanceof SplashActivity) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", context.getClass().getName());
        }
        Context context2 = clickedView.getContext();
        int i16 = msgRecord.chatType;
        String str = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        AIOEmotionFragment.ci(context2, x16, sessionInfo, new AIOContact(i16, str, "", null, 8, null), com.tencent.common.galleryactivity.j.d(clickedView), true, true, bundle);
    }
}
