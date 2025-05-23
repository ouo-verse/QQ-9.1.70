package com.tencent.mobileqq.guild.setting.group.groupshow;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Laz1/a;", "kotlin.jvm.PlatformType", "dataList", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGroupChatShowFragment$initViewModel$2 extends Lambda implements Function1<List<? extends az1.a>, Unit> {
    final /* synthetic */ GuildGroupChatShowFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGroupChatShowFragment$initViewModel$2(GuildGroupChatShowFragment guildGroupChatShowFragment) {
        super(1);
        this.this$0 = guildGroupChatShowFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final GuildGroupChatShowFragment this$0) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        overScrollRecyclerViewWithHeaderFooter = this$0.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildGroupChatShowFragment$initViewModel$2.d(GuildGroupChatShowFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildGroupChatShowFragment this$0) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        overScrollRecyclerViewWithHeaderFooter = this$0.recyclerView;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.invalidateItemDecorations();
        overScrollRecyclerViewWithHeaderFooter2 = this$0.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            overScrollRecyclerViewWithHeaderFooter3 = overScrollRecyclerViewWithHeaderFooter2;
        }
        VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends az1.a> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends az1.a> list) {
        zy1.a aVar;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildGroupChatShowFragment", "observe dataList, " + list);
        }
        aVar = this.this$0.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        final GuildGroupChatShowFragment guildGroupChatShowFragment = this.this$0;
        aVar.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildGroupChatShowFragment$initViewModel$2.c(GuildGroupChatShowFragment.this);
            }
        });
    }
}
