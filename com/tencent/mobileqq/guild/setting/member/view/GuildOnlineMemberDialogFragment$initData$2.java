package com.tencent.mobileqq.guild.setting.member.view;

import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Ldg1/b;", "kotlin.jvm.PlatformType", "dataList", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOnlineMemberDialogFragment$initData$2 extends Lambda implements Function1<List<? extends dg1.b>, Unit> {
    final /* synthetic */ GuildOnlineMemberDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildOnlineMemberDialogFragment$initData$2(GuildOnlineMemberDialogFragment guildOnlineMemberDialogFragment) {
        super(1);
        this.this$0 = guildOnlineMemberDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        VideoReport.traverseExposure();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends dg1.b> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends dg1.b> dataList) {
        ViewGroup viewGroup;
        cg1.a aVar;
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar;
        ViewGroup viewGroup2;
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar2 = null;
        ViewGroup viewGroup3 = null;
        if (dataList.isEmpty()) {
            viewGroup2 = this.this$0.mChannelListWrapper;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelListWrapper");
            } else {
                viewGroup3 = viewGroup2;
            }
            viewGroup3.setVisibility(8);
        } else {
            viewGroup = this.this$0.mChannelListWrapper;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelListWrapper");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            aVar = this.this$0.mChannelAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelAdapter");
                aVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
            aVar.submitList(dataList);
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildOnlineMemberDialogFragment$initData$2.c();
                }
            });
            cVar = this.this$0.mVisibleAreaVideoController;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVisibleAreaVideoController");
            } else {
                cVar2 = cVar;
            }
            cVar2.g();
        }
        this.this$0.Ph();
    }
}
