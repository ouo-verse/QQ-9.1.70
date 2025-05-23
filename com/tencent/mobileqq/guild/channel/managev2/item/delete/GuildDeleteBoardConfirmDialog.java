package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JM\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0007J\u001b\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/GuildDeleteBoardConfirmDialog;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isMissionChannel", "", "guildId", "channelId", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "check", "", "onConfirmDelete", "e", "c", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildDeleteBoardConfirmDialog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDeleteBoardConfirmDialog f215173a = new GuildDeleteBoardConfirmDialog();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f215174d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f215175e;

        a(Ref.IntRef intRef, ActionSheet actionSheet) {
            this.f215174d = intRef;
            this.f215175e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public final void onClick(View view, int i3) {
            this.f215174d.element = i3;
            this.f215175e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f215176d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f215177e;

        b(Ref.IntRef intRef, ActionSheet actionSheet) {
            this.f215176d = intRef;
            this.f215177e = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f215176d.element = 2;
            this.f215177e.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class c implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Integer> f215178d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f215179e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Integer> continuation, Ref.IntRef intRef) {
            this.f215178d = continuation;
            this.f215179e = intRef;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Continuation<Integer> continuation = this.f215178d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Integer.valueOf(this.f215179e.element)));
        }
    }

    GuildDeleteBoardConfirmDialog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(Activity activity, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (activity.isFinishing()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxInt(-1)));
        } else {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
            Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
            ActionSheet actionSheet = (ActionSheet) createDialog;
            actionSheet.setMainTitle(R.string.f141160fx);
            actionSheet.addButton(HardCodeUtil.qqStr(R.string.f141370gh));
            actionSheet.addButton(HardCodeUtil.qqStr(R.string.f141380gi), 3);
            actionSheet.addCancelButton(R.string.f140850f3);
            actionSheet.setOnButtonClickListener(new a(intRef, actionSheet));
            actionSheet.setOnBottomCancelListener(new b(intRef, actionSheet));
            actionSheet.setOnDismissListener(new c(safeContinuation, intRef));
            actionSheet.show();
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(Activity activity, String str, String str2, Continuation<? super Boolean> continuation) {
        return ay1.a.b(activity, str, str2, continuation);
    }

    @JvmStatic
    public static final void e(@Nullable Activity activity, boolean isMissionChannel, @NotNull String guildId, @NotNull String channelId, @NotNull final Function1<? super Integer, Unit> onConfirmDelete) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(onConfirmDelete, "onConfirmDelete");
        if (activity != null && !activity.isFinishing()) {
            if (isMissionChannel) {
                MissionChannelDeleteConfirmFragment.INSTANCE.a(activity, guildId, channelId, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.GuildDeleteBoardConfirmDialog$show$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        onConfirmDelete.invoke(0);
                    }
                });
                return;
            }
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            Intrinsics.checkNotNull(f16);
            CorountineFunKt.e(f16, "GuildDeleteSubChannelConfirmDialog show", Boolean.TRUE, null, null, new GuildDeleteBoardConfirmDialog$show$2(activity, guildId, channelId, onConfirmDelete, null), 12, null);
        }
    }
}
