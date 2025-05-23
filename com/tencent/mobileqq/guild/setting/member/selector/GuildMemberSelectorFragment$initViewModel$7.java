package com.tencent.mobileqq.guild.setting.member.selector;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vp1.bx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "kotlin.jvm.PlatformType", "memberListData", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberSelectorFragment$initViewModel$7 extends Lambda implements Function1<List<? extends a>, Unit> {
    final /* synthetic */ GuildMemberSelectorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberSelectorFragment$initViewModel$7(GuildMemberSelectorFragment guildMemberSelectorFragment) {
        super(1);
        this.this$0 = guildMemberSelectorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMemberSelectorFragment this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z16 = this$0.startSearchList;
        if (z16) {
            this$0.startSearchList = false;
            bx bxVar = this$0.binding;
            if (bxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bxVar = null;
            }
            bxVar.f442630f.scrollToPosition(0);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends a> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends a> list) {
        d dVar;
        dVar = this.this$0.searchAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
            dVar = null;
        }
        final GuildMemberSelectorFragment guildMemberSelectorFragment = this.this$0;
        dVar.submitList(list, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.selector.n
            @Override // java.lang.Runnable
            public final void run() {
                GuildMemberSelectorFragment$initViewModel$7.b(GuildMemberSelectorFragment.this);
            }
        });
    }
}
