package com.tencent.mobileqq.guild.contentshare.fragment;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/d;", "info", "", "invoke", "(Lcom/tencent/mobileqq/guild/contentshare/d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildContentShareFragment$initData$2 extends Lambda implements Function1<com.tencent.mobileqq.guild.contentshare.d, Unit> {
    final /* synthetic */ GuildContentShareFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContentShareFragment$initData$2(GuildContentShareFragment guildContentShareFragment) {
        super(1);
        this.this$0 = guildContentShareFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildContentShareFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Uh();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.contentshare.d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable com.tencent.mobileqq.guild.contentshare.d dVar) {
        if (dVar == null) {
            QLog.i("GuildContentShareFragment", 1, "Failed to create share info. shareScene=" + this.this$0.getShareScene());
            return;
        }
        this.this$0.Zh(dVar);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildContentShareFragment guildContentShareFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.contentshare.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildContentShareFragment$initData$2.b(GuildContentShareFragment.this);
            }
        });
    }
}
