package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.O3ReportUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J@\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J)\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOReportImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOReport;", "", "bigT", "", "reportBigT", "", "entry", "result", "r1", "r2", "r3", "r4", "event", "", "params", "reportBeacon", "currentMode", "position", "aioChatType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "reportArkExpo", "(ILjava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "reportRobot", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOReportImpl implements IAIOReport {
    private static final String TAG = "AIOReportFallback";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public String currentMode() {
        if (SimpleUIUtil.isNowElderMode()) {
            return "3";
        }
        if (QQTheme.isNowSimpleUI()) {
            return "1";
        }
        if (StudyModeManager.t()) {
            return "2";
        }
        if (QQTheme.isDefaultTheme()) {
            return "0";
        }
        return "4";
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportArkExpo(int position, Integer aioChatType, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).publicAccountAIOMsgReport(117, aioChatType, msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBeacon(String event, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "[reportBeacon] event=" + event + " params=" + params);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBigT(String bigT) {
        Intrinsics.checkNotNullParameter(bigT, "bigT");
        QLog.i(TAG, 1, "[reportBigT] bigT=" + bigT);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBigT(String bigT, int entry, int result, String r16, String r26, String r36, String r46) {
        Intrinsics.checkNotNullParameter(bigT, "bigT");
        Intrinsics.checkNotNullParameter(r16, "r1");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        QLog.i(TAG, 1, "[reportBigT] bigT=" + bigT + ", entry=" + entry + ", result=" + result + "r1=" + r16 + ", r2=" + r26 + ", r3=" + r36 + ", r4=" + r46);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportRobot(MsgRecord msgRecord) {
        ChatMessage convertToChatMessage;
        Activity topActivity;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(peekAppRuntime, msgRecord)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(convertToChatMessage);
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 == null || (topActivity = Foreground.getTopActivity()) == null || !(topActivity instanceof QBaseActivity)) {
            return;
        }
        String reportMsg = NewReportPlugin.k(arrayList);
        String msgJson = com.tencent.mobileqq.jubao.a.A(arrayList);
        Intrinsics.checkNotNullExpressionValue(msgJson, "msgJson");
        byte[] bytes = msgJson.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String msgEncBase64 = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 2);
        String valueOf = String.valueOf(msgRecord.peerUin);
        String senderUin = com.tencent.imcore.message.ad.k(convertToChatMessage);
        if (msgRecord.chatType == 2) {
            i3 = 101063;
            i16 = 1;
        } else {
            i3 = 100730;
            i16 = 0;
        }
        Bundle bundle = NewReportPlugin.G(senderUin, i16);
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(valueOf, msgRecord.peerUid);
        Intrinsics.checkNotNullExpressionValue(senderUin, "senderUin");
        String currentUin = peekAppRuntime2.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "appRuntime.currentUin");
        Intrinsics.checkNotNullExpressionValue(reportMsg, "reportMsg");
        int size = arrayList.size();
        Intrinsics.checkNotNullExpressionValue(msgEncBase64, "msgEncBase64");
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        O3ReportUtil.d((QBaseActivity) topActivity, senderUin, "1", valueOf, currentUin, i3, reportMsg, size, msgEncBase64, bundle);
    }
}
