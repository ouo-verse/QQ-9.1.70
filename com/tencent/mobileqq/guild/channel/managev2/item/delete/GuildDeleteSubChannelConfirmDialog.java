package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJJ\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J-\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/GuildDeleteSubChannelConfirmDialog;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isMissionChannel", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "guildId", "channelId", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "onConfirmDelete", "i", "", "channelType", "e", "(Landroid/app/Activity;Landroid/view/View;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "type", h.F, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildDeleteSubChannelConfirmDialog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDeleteSubChannelConfirmDialog f215180a = new GuildDeleteSubChannelConfirmDialog();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f215181d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f215182e;

        a(Ref.BooleanRef booleanRef, ActionSheet actionSheet) {
            this.f215181d = booleanRef;
            this.f215182e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public final void onClick(View view, int i3) {
            this.f215181d.element = true;
            this.f215182e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class b implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f215183d;

        b(ActionSheet actionSheet) {
            this.f215183d = actionSheet;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f215183d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class c implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f215184d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f215185e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f215186f;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation, Ref.BooleanRef booleanRef, ActionSheet actionSheet) {
            this.f215184d = continuation;
            this.f215185e = booleanRef;
            this.f215186f = actionSheet;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            int i3;
            Continuation<Boolean> continuation = this.f215184d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(this.f215185e.element)));
            GuildDeleteSubChannelConfirmDialog guildDeleteSubChannelConfirmDialog = GuildDeleteSubChannelConfirmDialog.f215180a;
            ViewGroup rootView = this.f215186f.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "actionSheet.rootView");
            if (this.f215185e.element) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            guildDeleteSubChannelConfirmDialog.h(rootView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f215187d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Boolean> continuation) {
            this.f215187d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f215187d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f215188d;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super Boolean> continuation) {
            this.f215188d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f215188d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    GuildDeleteSubChannelConfirmDialog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(Activity activity, View view, int i3, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        int i16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (activity.isFinishing()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        } else {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
            Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
            ActionSheet actionSheet = (ActionSheet) createDialog;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        i16 = R.string.f141400gk;
                    } else {
                        i16 = R.string.f147600xb;
                    }
                } else {
                    i16 = R.string.f158411pj;
                }
            } else {
                i16 = R.string.f157671nj;
            }
            actionSheet.setMainTitle(i16);
            actionSheet.addButton(HardCodeUtil.qqStr(R.string.f143030kz), 3);
            actionSheet.addCancelButton(R.string.f140850f3);
            actionSheet.setOnButtonClickListener(new a(booleanRef, actionSheet));
            actionSheet.setOnCancelListener(new b(actionSheet));
            actionSheet.setOnDismissListener(new c(safeContinuation, booleanRef, actionSheet));
            actionSheet.show();
            if (view != null) {
                VideoReport.setLogicParent(actionSheet.getRootView(), view);
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(Activity activity, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (activity.isFinishing()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        } else {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, HardCodeUtil.qqStr(R.string.f157541n7), HardCodeUtil.qqStr(R.string.f157531n6), HardCodeUtil.qqStr(R.string.f157521n5), QQGuildUIUtil.i(activity, R.color.action_sheet_button_red), new d(safeContinuation), new e(safeContinuation));
            createCustomDialog.getMessageTextView().setGravity(17);
            createCustomDialog.getBtnLeft().setTypeface(createCustomDialog.getBtnLeft().getTypeface(), 1);
            createCustomDialog.show();
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Activity activity, String str, String str2, Continuation<? super Boolean> continuation) {
        return ay1.a.b(activity, str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(View view, int type) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Integer.valueOf(type)));
        ChannelSettingUtils.i(view, "em_sgrp_delete_panel", mapOf);
    }

    @JvmStatic
    public static final void i(@Nullable Activity activity, boolean isMissionChannel, @NotNull IGProChannelInfo channelInfo, @NotNull String guildId, @NotNull String channelId, @Nullable View view, @NotNull final Function0<Unit> onConfirmDelete) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(onConfirmDelete, "onConfirmDelete");
        if (activity != null && !activity.isFinishing()) {
            if (isMissionChannel) {
                MissionChannelDeleteConfirmFragment.INSTANCE.a(activity, guildId, channelId, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.GuildDeleteSubChannelConfirmDialog$show$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        onConfirmDelete.invoke();
                    }
                });
                return;
            }
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            Intrinsics.checkNotNull(f16);
            CorountineFunKt.e(f16, "GuildDeleteSubChannelConfirmDialog show", Boolean.TRUE, null, null, new GuildDeleteSubChannelConfirmDialog$show$2(activity, view, channelInfo, guildId, channelId, onConfirmDelete, null), 12, null);
        }
    }
}
