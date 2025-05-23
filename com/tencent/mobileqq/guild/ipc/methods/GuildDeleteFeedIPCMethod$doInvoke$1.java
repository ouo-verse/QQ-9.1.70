package com.tencent.mobileqq.guild.ipc.methods;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildDeleteFeedIPCMethod$doInvoke$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final GuildDeleteFeedIPCMethod$doInvoke$1 INSTANCE = new GuildDeleteFeedIPCMethod$doInvoke$1();

    GuildDeleteFeedIPCMethod$doInvoke$1() {
        super(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f141390gj, 1).show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.ipc.methods.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildDeleteFeedIPCMethod$doInvoke$1.c();
                }
            }, 100L);
        }
    }
}
