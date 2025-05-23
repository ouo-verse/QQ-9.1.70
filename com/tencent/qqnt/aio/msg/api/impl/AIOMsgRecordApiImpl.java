package com.tencent.qqnt.aio.msg.api.impl;

import android.net.Uri;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.data.b;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.msg.api.IAIOMsgRecordApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J@\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/msg/api/impl/AIOMsgRecordApiImpl;", "Lcom/tencent/qqnt/aio/msg/api/IAIOMsgRecordApi;", "", "senderUid", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", QQBrowserActivity.KEY_MSG_TYPE, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "originPath", "Landroid/net/Uri;", "originUri", "", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "getPicMsgRecord", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "getMarkFaceMsgRecord", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMsgRecordApiImpl implements IAIOMsgRecordApi {
    static IPatchRedirector $redirector_;

    public AIOMsgRecordApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MsgRecord getMsgRecord(String senderUid, long senderUin, int msgType, ArrayList<MsgElement> msgElement) {
        return new MsgRecord(0L, 0L, 0L, 0L, 1, msgType, 0, 1, senderUid, "", "", "", 0L, 0L, 0L, System.currentTimeMillis() / 1000, null, 2, "", "", "", "", "", msgElement, null, null, 0L, 0, null, "", null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, senderUin, 0L, new HashMap(), null, 0, 0, null, null, 0, null);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgRecordApi
    @Nullable
    public MsgRecord getMarkFaceMsgRecord(@NotNull MarkFaceMessage markFaceMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 3, (Object) this, (Object) markFaceMessage);
        }
        Intrinsics.checkNotNullParameter(markFaceMessage, "markFaceMessage");
        ArrayList<MsgElement> m3 = AIOObjectTransform.m(AIOObjectTransform.f194080a, b.f190166a.a(markFaceMessage), 0, 2, null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        String currentUid = peekAppRuntime.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid");
        return getMsgRecord(currentUid, peekAppRuntime.getLongAccountUin(), 17, m3);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgRecordApi
    @Nullable
    public MsgRecord getPicMsgRecord(@NotNull String originPath, @Nullable Uri originUri, boolean quality, int subType, @Nullable String textSummary, @Nullable g picExtBizInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, this, originPath, originUri, Boolean.valueOf(quality), Integer.valueOf(subType), textSummary, picExtBizInfo);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        ArrayList<MsgElement> m3 = AIOObjectTransform.m(AIOObjectTransform.f194080a, b.c(b.f190166a, originPath, originUri, quality, subType, textSummary, picExtBizInfo, null, false, 192, null), 0, 2, null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        String currentUid = peekAppRuntime.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid");
        return getMsgRecord(currentUid, peekAppRuntime.getLongAccountUin(), 2, m3);
    }
}
