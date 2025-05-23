package com.tencent.mobileqq.guild.feed.nativepublish.fragment;

import android.view.View;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent$ContentStatisticChangeMsgIntent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.fragment.ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1", f = "ShortFeedEditorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1 extends SuspendLambda implements Function2<FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $dtReportView;
    final /* synthetic */ Ref.IntRef $editStatus;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1(Ref.IntRef intRef, View view, Continuation<? super ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1> continuation) {
        super(2, continuation);
        this.$editStatus = intRef;
        this.$dtReportView = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1 shortFeedEditorFragment$setupContentExistenceStatusDtReport$1 = new ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1(this.$editStatus, this.$dtReportView, continuation);
        shortFeedEditorFragment$setupContentExistenceStatusDtReport$1.L$0 = obj;
        return shortFeedEditorFragment$setupContentExistenceStatusDtReport$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent contentStatisticChangeMsgIntent, @Nullable Continuation<? super Unit> continuation) {
        return ((ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1) create(contentStatisticChangeMsgIntent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent contentStatisticChangeMsgIntent = (FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent) this.L$0;
            if (contentStatisticChangeMsgIntent.getSupervisorAttachInfo().getContentLength() <= 0 && contentStatisticChangeMsgIntent.getSupervisorAttachInfo().getMediaCount() <= 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            Ref.IntRef intRef = this.$editStatus;
            if (intRef.element != i3) {
                intRef.element = i3;
                VideoReport.setPageParams(this.$dtReportView, "sgrp_is_edit_status", Boxing.boxInt(i3));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
