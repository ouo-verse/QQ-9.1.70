package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b12.a;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB9\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "", "", "f", "Landroid/view/View;", "containerView", "", tl.h.F, "", "type", "i", "j", "", "show", "g", "a", "Landroid/view/View;", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "deleteAction", "c", "editAction", "d", "republishAction", "Lx12/f;", "e", "Lx12/f;", "binding", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPostFailedEditComponents {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f219069f = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View containerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> deleteAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> editAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> republishAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private x12.f binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents$a;", "", "", "BTN_DELETE", "I", "BTN_EDIT", "BTN_REPUBLISH", "", "ELEM_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public GuildFeedPostFailedEditComponents(@NotNull View containerView, @NotNull Function0<Unit> deleteAction, @NotNull Function0<Unit> editAction, @NotNull Function0<Unit> republishAction) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(deleteAction, "deleteAction");
        Intrinsics.checkNotNullParameter(editAction, "editAction");
        Intrinsics.checkNotNullParameter(republishAction, "republishAction");
        this.containerView = containerView;
        this.deleteAction = deleteAction;
        this.editAction = editAction;
        this.republishAction = republishAction;
    }

    private final int[] f() {
        return new int[]{R.id.f165496wb1};
    }

    private final void h(View containerView) {
        int first;
        first = ArraysKt___ArraysKt.first(f());
        View findViewById = containerView.findViewById(first);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ewStubLayoutId().first())");
        View findViewById2 = ((ViewStub) findViewById).inflate().findViewById(R.id.wcx);
        if (!(findViewById2 instanceof ViewGroup)) {
            return;
        }
        x12.f e16 = x12.f.e(findViewById2);
        Intrinsics.checkNotNullExpressionValue(e16, "bind(container)");
        this.binding = e16;
        x12.f fVar = null;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            e16 = null;
        }
        ConstraintLayout root = e16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        kotlin.b.b(root, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                x12.f fVar2;
                function0 = GuildFeedPostFailedEditComponents.this.republishAction;
                function0.invoke();
                GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = GuildFeedPostFailedEditComponents.this;
                fVar2 = guildFeedPostFailedEditComponents.binding;
                if (fVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fVar2 = null;
                }
                ConstraintLayout root2 = fVar2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                guildFeedPostFailedEditComponents.i(root2, 1);
            }
        });
        x12.f fVar2 = this.binding;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar2 = null;
        }
        TextView textView = fVar2.f446925e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.postEditText");
        ko1.b.c(textView, 16, 16, 0, 16, 4, null);
        x12.f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        TextView textView2 = fVar3.f446925e;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.postEditText");
        kotlin.b.b(textView2, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                x12.f fVar4;
                function0 = GuildFeedPostFailedEditComponents.this.editAction;
                function0.invoke();
                GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = GuildFeedPostFailedEditComponents.this;
                fVar4 = guildFeedPostFailedEditComponents.binding;
                if (fVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fVar4 = null;
                }
                TextView textView3 = fVar4.f446925e;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.postEditText");
                guildFeedPostFailedEditComponents.i(textView3, 2);
            }
        });
        x12.f fVar4 = this.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        TextView textView3 = fVar4.f446923c;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.postDeleteText");
        ko1.b.c(textView3, 0, 16, 16, 16, 1, null);
        x12.f fVar5 = this.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar = fVar5;
        }
        TextView textView4 = fVar.f446923c;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.postDeleteText");
        kotlin.b.b(textView4, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                x12.f fVar6;
                function0 = GuildFeedPostFailedEditComponents.this.deleteAction;
                function0.invoke();
                GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = GuildFeedPostFailedEditComponents.this;
                fVar6 = guildFeedPostFailedEditComponents.binding;
                if (fVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fVar6 = null;
                }
                TextView textView5 = fVar6.f446923c;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.postDeleteText");
                guildFeedPostFailedEditComponents.i(textView5, 3);
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View view, int i3) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_tip_btn", Integer.valueOf(i3)));
        VideoReport.setElementId(view, "em_sgrp_forum_fail_tip");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMapOf);
    }

    private final void j() {
        b12.a aVar = new b12.a();
        x12.f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        ConstraintLayout root = fVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        aVar.b(root, new Function1<a.SetupBuilder, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents$setupReport$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.SetupBuilder setupBuilder) {
                invoke2(setupBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.SetupBuilder setup) {
                Intrinsics.checkNotNullParameter(setup, "$this$setup");
                setup.e("em_sgrp_forum_fail_tip");
                setup.d(ExposurePolicy.REPORT_ALL);
            }
        });
    }

    public final void g(boolean show) {
        boolean z16 = false;
        x12.f fVar = null;
        if (show) {
            if (this.binding == null) {
                h(this.containerView);
            }
            x12.f fVar2 = this.binding;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fVar = fVar2;
            }
            fVar.getRoot().setVisibility(0);
            return;
        }
        x12.f fVar3 = this.binding;
        if (fVar3 != null) {
            if (fVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar3 = null;
            }
            ConstraintLayout root = fVar3.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            if (root.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                x12.f fVar4 = this.binding;
                if (fVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fVar = fVar4;
                }
                fVar.getRoot().setVisibility(8);
            }
        }
    }
}
