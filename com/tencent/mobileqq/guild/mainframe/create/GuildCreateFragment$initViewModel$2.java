package com.tencent.mobileqq.guild.mainframe.create;

import android.util.Log;
import com.tencent.mobileqq.guild.mainframe.create.widget.GuildCreateMemberRecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ur1.GuildCreateMemberData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lur1/e;", "kotlin.jvm.PlatformType", "memberList", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCreateFragment$initViewModel$2 extends Lambda implements Function1<List<? extends GuildCreateMemberData>, Unit> {
    final /* synthetic */ GuildCreateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCreateFragment$initViewModel$2(GuildCreateFragment guildCreateFragment) {
        super(1);
        this.this$0 = guildCreateFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildCreateFragment this$0, List list) {
        GuildCreateMemberRecyclerView guildCreateMemberRecyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        guildCreateMemberRecyclerView = this$0.memberView;
        if (guildCreateMemberRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberView");
            guildCreateMemberRecyclerView = null;
        }
        guildCreateMemberRecyclerView.smoothScrollToPosition(list.size() - 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildCreateMemberData> list) {
        invoke2((List<GuildCreateMemberData>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<GuildCreateMemberData> memberList) {
        GuildCreateMemberRecyclerView guildCreateMemberRecyclerView;
        GuildCreateMemberRecyclerView guildCreateMemberRecyclerView2;
        String joinToString$default;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Intrinsics.checkNotNullExpressionValue(memberList, "memberList");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(memberList, ",", null, null, 0, null, null, 62, null);
            Log.d("GuildCreateFragment", "memberList: " + joinToString$default);
        }
        guildCreateMemberRecyclerView = this.this$0.memberView;
        GuildCreateMemberRecyclerView guildCreateMemberRecyclerView3 = null;
        if (guildCreateMemberRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberView");
            guildCreateMemberRecyclerView = null;
        }
        Intrinsics.checkNotNullExpressionValue(memberList, "memberList");
        guildCreateMemberRecyclerView.I(memberList);
        guildCreateMemberRecyclerView2 = this.this$0.memberView;
        if (guildCreateMemberRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberView");
        } else {
            guildCreateMemberRecyclerView3 = guildCreateMemberRecyclerView2;
        }
        final GuildCreateFragment guildCreateFragment = this.this$0;
        guildCreateMemberRecyclerView3.post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.create.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildCreateFragment$initViewModel$2.b(GuildCreateFragment.this, memberList);
            }
        });
    }
}
