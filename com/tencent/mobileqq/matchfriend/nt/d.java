package com.tencent.mobileqq.matchfriend.nt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/nt/d;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "matchUin", "Lcom/tencent/mobileqq/data/MessageForArkApp;", "messageForArkApp", "", "front", "", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f244175a = new d();

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String str) {
        QLog.i("MatchFriendNTUtils", 1, "insertNtLocalRecordArk result " + i3 + " errMsg " + str);
    }

    public final void b(QQAppInterface app, String matchUin, MessageForArkApp messageForArkApp, boolean front) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (messageForArkApp == null) {
            QLog.e("MatchFriendNTUtils", 1, "insertNtLocalRecordArk is error messageForArkApp is null!");
            return;
        }
        w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService == null) {
            QLog.e("MatchFriendNTUtils", 1, "insertNtLocalRecordArk is error msgService is null!");
            return;
        }
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        String appXml = messageForArkApp.ark_app_message.toAppXml();
        Intrinsics.checkNotNullExpressionValue(appXml, "messageForArkApp.ark_app_message.toAppXml()");
        aVar.o(appXml);
        msgService.w(new Contact(104, matchUin, ""), 11L, ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createArkElement(aVar), front, new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.nt.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                d.c(i3, str);
            }
        });
    }
}
