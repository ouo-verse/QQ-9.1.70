package com.tencent.mobileqq.guild.home.parts;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.List;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "kotlin.jvm.PlatformType", "list", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildHomeLoadingPart$onInitView$2 extends Lambda implements Function1<List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>, Unit> {
    final /* synthetic */ GuildHomeLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeLoadingPart$onInitView$2(GuildHomeLoadingPart guildHomeLoadingPart) {
        super(1);
        this.this$0 = guildHomeLoadingPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final GuildHomeLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.bc
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeLoadingPart$onInitView$2.d(GuildHomeLoadingPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeLoadingPart this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasHeaderList = true;
        z16 = this$0.hasTintColor;
        if (z16) {
            this$0.X9("\u7f6e\u9876\u533a\u57df\u6709\u6570\u636e");
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeLoadingPart", "hasHeaderList size:" + list.size());
        }
        final GuildHomeLoadingPart guildHomeLoadingPart = this.this$0;
        Function0.b(20, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.bb
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeLoadingPart$onInitView$2.c(GuildHomeLoadingPart.this);
            }
        });
    }
}
