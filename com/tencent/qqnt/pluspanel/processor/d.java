package com.tencent.qqnt.pluspanel.processor;

import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.aio.event.AnonymousChatEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AnonyStatus;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/d;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "", "type", "", "content", "e", tl.h.F, "Lcom/tencent/biz/anonymous/QQAnonymousDialog;", "Lcom/tencent/biz/anonymous/QQAnonymousDialog;", "mAnonymousDialog", "", "b", "Z", "anonymousStatus", "<init>", "()V", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QQAnonymousDialog mAnonymousDialog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean anonymousStatus;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, int i3, String str, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.h(i3, str, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, com.tencent.aio.api.runtime.a context, int i3, String str, GroupAnonymousInfo groupAnonymousInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("AnonymousChatOnClickProcessor", 1, "switchAnonymousChat| onResult, result=" + i3 + ", errMsg=" + str + ", info=" + groupAnonymousInfo + ", isFirst=" + z16);
        if (i3 != 0) {
            this$0.e(1, str, context);
            return;
        }
        AnonyStatus anonyStatus = groupAnonymousInfo.anonyStatus;
        if (anonyStatus.forbidTalking == 0) {
            QQAnonymousDialog qQAnonymousDialog = this$0.mAnonymousDialog;
            if (qQAnonymousDialog != null) {
                qQAnonymousDialog.dismiss();
            }
            context.e().h(new AnonymousChatEvent.SwitchAnonymousChatEvent(groupAnonymousInfo));
            return;
        }
        this$0.e(3, anonyStatus.statusInfo, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAnonymousDialog qQAnonymousDialog = this$0.mAnonymousDialog;
        if (qQAnonymousDialog != null) {
            qQAnonymousDialog.dismiss();
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        String j3 = context.g().r().c().j();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("AnonymousChatOnClickProcessor", 1, " onClick| getAnonymousInfo error for kernelMsgService is null");
                return;
            }
            return;
        }
        GroupAnonymousInfo anonymousInfo = e16.getAnonymousInfo(j3);
        if (anonymousInfo != null) {
            boolean z16 = anonymousInfo.isAnonymousChat;
            this.anonymousStatus = z16;
            QLog.d("AnonymousChatOnClickProcessor", 1, " onClick| getAnonymousInfo,  anonymousStatus = " + z16);
        }
        if (this.anonymousStatus) {
            return;
        }
        h(2, "", context);
        e16.switchAnonymousChat(context.g().r().c().j(), !this.anonymousStatus, new ISwitchAnonymousChatCallback() { // from class: com.tencent.qqnt.pluspanel.processor.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.ISwitchAnonymousChatCallback
            public final void onResult(int i3, String str, GroupAnonymousInfo groupAnonymousInfo, boolean z17) {
                d.g(d.this, context, i3, str, groupAnonymousInfo, z17);
            }
        });
    }

    public final void e(final int type, final String content, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.pluspanel.processor.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(d.this, type, content, context);
            }
        }, 0L);
    }

    public final void h(int type, String content, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mAnonymousDialog == null) {
            this.mAnonymousDialog = new QQAnonymousDialog(context.c().getContext());
        }
        QQAnonymousDialog qQAnonymousDialog = this.mAnonymousDialog;
        if (qQAnonymousDialog != null) {
            qQAnonymousDialog.N(type, content);
            qQAnonymousDialog.show();
            if (type == 1 || type == 3) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.pluspanel.processor.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.i(d.this);
                    }
                }, AppSetting.f99565y ? 3000L : 1000L);
            }
        }
    }
}
