package com.tencent.qqnt.pluspanel.processor;

import com.tencent.mobileqq.aio.event.AnonymousChatEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/h;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "", "Z", "anonymousStatus", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean anonymousStatus;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.aio.api.runtime.a context, int i3, String str, GroupAnonymousInfo groupAnonymousInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("ExitAnonymousOnClickProcessor", 1, "switchAnonymousChat| onResult, result=" + i3 + ", errMsg=" + str + ", info=" + groupAnonymousInfo + ", isFirst=" + z16);
        context.e().h(new AnonymousChatEvent.SwitchAnonymousChatEvent(groupAnonymousInfo));
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        String j3 = context.g().r().c().j();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("ExitAnonymousOnClickProcessor", 1, " onClick| onClick error for kernelMsgService is null");
                return;
            }
            return;
        }
        GroupAnonymousInfo anonymousInfo = e16.getAnonymousInfo(j3);
        if (anonymousInfo != null) {
            boolean z16 = anonymousInfo.isAnonymousChat;
            this.anonymousStatus = z16;
            QLog.d("ExitAnonymousOnClickProcessor", 1, "onClick| getAnonymousInfo, anonymousStatus = " + z16);
        }
        if (this.anonymousStatus) {
            e16.switchAnonymousChat(context.g().r().c().j(), !this.anonymousStatus, new ISwitchAnonymousChatCallback() { // from class: com.tencent.qqnt.pluspanel.processor.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback
                public final void onResult(int i3, String str, GroupAnonymousInfo groupAnonymousInfo, boolean z17) {
                    h.c(com.tencent.aio.api.runtime.a.this, i3, str, groupAnonymousInfo, z17);
                }
            });
        }
    }
}
