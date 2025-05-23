package com.tencent.mobileqq.guild.feed.nativepublish.functionbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.a;
import com.tencent.mobileqq.guild.feed.video.GuidePopBuilder;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x12.p;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J/\u0010\u0010\u001a\u00020\u000e*\u00020\t2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0012\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0017J\u0016\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030!0 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0016R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "callback", "j1", "", "newFlag", "m1", "", "enable", "o1", "overCount", ICustomDataEditor.NUMBER_PARAM_1, "showKeyboard", "l1", "g1", "h1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVM;", "e1", "bindViewAndData", "state", "f1", "", "contentStr", "G0", "Lx12/p;", "d", "Lx12/p;", "mBinding", "e", "I", "functionStateFlag", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "overLimitTextDtReport", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSimplifiedPublishFunctionBarVB extends BaseVB<a, GuildFeedPublishFunctionBarMviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements GuidePopBuilder.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private p mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int functionStateFlag = 7;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> overLimitTextDtReport = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$overLimitTextDtReport$1
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
            p pVar;
            pVar = GuildFeedSimplifiedPublishFunctionBarVB.this.mBinding;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                pVar = null;
            }
            VideoReport.reportEvent("imp", pVar.f446987g, null);
        }
    };

    private final void g1() {
        p pVar = this.mBinding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        ImageView emoji = pVar.f446984d;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        Intrinsics.checkNotNullExpressionValue(emoji, "emoji");
        if1.a.b(emoji, "em_sgrp_forum_editor_emotion", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
        p pVar3 = this.mBinding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar3 = null;
        }
        ImageView media = pVar3.f446986f;
        Intrinsics.checkNotNullExpressionValue(media, "media");
        if1.a.b(media, "em_sgrp_forum_editor_picture", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
        p pVar4 = this.mBinding;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar4 = null;
        }
        ImageView plus = pVar4.f446988h;
        Intrinsics.checkNotNullExpressionValue(plus, "plus");
        if1.a.b(plus, "em_sgrp_add_jump_entry", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
        p pVar5 = this.mBinding;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar5 = null;
        }
        ImageView articleEntry = pVar5.f446982b;
        Intrinsics.checkNotNullExpressionValue(articleEntry, "articleEntry");
        if1.a.b(articleEntry, "em_sgrp_short_publisher_long", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
        p pVar6 = this.mBinding;
        if (pVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar6 = null;
        }
        TextView publish = pVar6.f446989i;
        Intrinsics.checkNotNullExpressionValue(publish, "publish");
        if1.a.b(publish, "em_sgrp_forum_editor_send", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
        p pVar7 = this.mBinding;
        if (pVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            pVar2 = pVar7;
        }
        TextView overLimit = pVar2.f446987g;
        Intrinsics.checkNotNullExpressionValue(overLimit, "overLimit");
        if1.a.b(overLimit, "em_sgrp_word_max_tip", null, null, exposurePolicy, clickPolicy, null, null, null, 230, null);
    }

    private final void h1() {
        p pVar = this.mBinding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        ImageView imageView = pVar.f446984d;
        p pVar3 = this.mBinding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar3 = null;
        }
        Context context = pVar3.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_publish_emoji_icon_normal, Integer.valueOf(R.color.qui_common_icon_primary)));
        p pVar4 = this.mBinding;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar4 = null;
        }
        ImageView imageView2 = pVar4.f446986f;
        p pVar5 = this.mBinding;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar5 = null;
        }
        Context context2 = pVar5.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "mBinding.root.context");
        imageView2.setImageDrawable(GuildUIUtils.w(context2, R.drawable.guild_feed_publish_image, Integer.valueOf(R.color.qui_common_icon_primary)));
        p pVar6 = this.mBinding;
        if (pVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar6 = null;
        }
        ImageView imageView3 = pVar6.f446988h;
        p pVar7 = this.mBinding;
        if (pVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar7 = null;
        }
        Context context3 = pVar7.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "mBinding.root.context");
        imageView3.setImageDrawable(GuildUIUtils.w(context3, R.drawable.guild_feed_publish_plus_icon_normal, Integer.valueOf(R.color.qui_common_icon_primary)));
        p pVar8 = this.mBinding;
        if (pVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar8 = null;
        }
        ImageView imageView4 = pVar8.f446982b;
        p pVar9 = this.mBinding;
        if (pVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            pVar2 = pVar9;
        }
        Context context4 = pVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "mBinding.root.context");
        imageView4.setImageDrawable(GuildUIUtils.w(context4, R.drawable.guild_feed_publish_article_icon_normal, Integer.valueOf(R.color.qui_common_icon_primary)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1(GuildFeedSimplifiedPublishFunctionBarVB this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 0) {
            this$0.sendIntent(new a.b());
            return false;
        }
        return false;
    }

    private final void j1(View view, final Function1<? super View, Unit> function1) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildFeedSimplifiedPublishFunctionBarVB.k1(Function1.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(Function1 callback, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!o.d("GuildFeedSimplifiedPublishFunctionBarVB", 1000L)) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            callback.invoke(it);
            VideoReport.reportEvent("clck", it, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void l1(boolean showKeyboard) {
        p pVar = this.mBinding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        ImageView imageView = (ImageView) pVar.getRoot().findViewById(R.id.usq);
        if (showKeyboard) {
            if (imageView != null) {
                p pVar3 = this.mBinding;
                if (pVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    pVar2 = pVar3;
                }
                Context context = pVar2.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
                imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_publish_keyboard_icon_normal, Integer.valueOf(R.color.qui_common_icon_primary)));
                return;
            }
            return;
        }
        if (imageView != null) {
            p pVar4 = this.mBinding;
            if (pVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                pVar2 = pVar4;
            }
            Context context2 = pVar2.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "mBinding.root.context");
            imageView.setImageDrawable(GuildUIUtils.w(context2, R.drawable.guild_feed_publish_emoji_icon_normal, Integer.valueOf(R.color.qui_common_icon_primary)));
        }
    }

    private final void m1(int newFlag) {
        int i3;
        int i16 = this.functionStateFlag;
        int i17 = (newFlag & 7) | (i16 & (-8));
        this.functionStateFlag = i17;
        int i18 = i17 ^ i16;
        if (i18 == 0) {
            return;
        }
        yl1.i iVar = yl1.i.f450608a;
        int i19 = 0;
        p pVar = null;
        if (iVar.g(i18, 2)) {
            p pVar2 = this.mBinding;
            if (pVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                pVar2 = null;
            }
            ImageView imageView = pVar2.f446988h;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.plus");
            if (iVar.g(this.functionStateFlag, 2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        if (iVar.g(i18, 4)) {
            p pVar3 = this.mBinding;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                pVar = pVar3;
            }
            ImageView imageView2 = pVar.f446982b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.articleEntry");
            if (!iVar.g(this.functionStateFlag, 4)) {
                i19 = 8;
            }
            imageView2.setVisibility(i19);
        }
    }

    private final void n1(int overCount) {
        boolean z16;
        Function0<Unit> function0;
        p pVar = this.mBinding;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        pVar.f446987g.setText("-" + overCount);
        p pVar2 = this.mBinding;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar2 = null;
        }
        TextView textView = pVar2.f446987g;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.overLimit");
        int i3 = 0;
        if (overCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        if (overCount > 0 && (function0 = this.overLimitTextDtReport) != null) {
            if (function0 != null) {
                function0.invoke();
            }
            this.overLimitTextDtReport = null;
        }
    }

    private final void o1(boolean enable) {
        float f16;
        p pVar = this.mBinding;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        TextView textView = pVar.f446989i;
        if (enable) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        textView.setAlpha(f16);
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuidePopBuilder.b
    public void G0(@NotNull String contentStr) {
        Intrinsics.checkNotNullParameter(contentStr, "contentStr");
        sendIntent(new a.f(contentStr, false));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        p pVar = this.mBinding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar = null;
        }
        ImageView imageView = pVar.f446984d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.emoji");
        j1(imageView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$bindViewAndData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSimplifiedPublishFunctionBarVB.this.sendIntent(new a.d());
            }
        });
        p pVar3 = this.mBinding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar3 = null;
        }
        ImageView imageView2 = pVar3.f446986f;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.media");
        j1(imageView2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$bindViewAndData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSimplifiedPublishFunctionBarVB.this.sendIntent(new a.c());
            }
        });
        p pVar4 = this.mBinding;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar4 = null;
        }
        ImageView imageView3 = pVar4.f446988h;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mBinding.plus");
        j1(imageView3, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$bindViewAndData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSimplifiedPublishFunctionBarVB.this.sendIntent(new a.e());
            }
        });
        p pVar5 = this.mBinding;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            pVar5 = null;
        }
        ImageView imageView4 = pVar5.f446982b;
        Intrinsics.checkNotNullExpressionValue(imageView4, "mBinding.articleEntry");
        j1(imageView4, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$bindViewAndData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSimplifiedPublishFunctionBarVB.this.sendIntent(new a.g());
            }
        });
        p pVar6 = this.mBinding;
        if (pVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            pVar2 = pVar6;
        }
        TextView textView = pVar2.f446989i;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.publish");
        j1(textView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB$bindViewAndData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSimplifiedPublishFunctionBarVB.this.sendIntent(new a.h());
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public GuildFeedSimplifiedPublishFunctionBarVM createVM() {
        return new GuildFeedSimplifiedPublishFunctionBarVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildFeedPublishFunctionBarMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState) {
            m1(((GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState) state).getStateFlag());
            return;
        }
        if (state instanceof GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton) {
            l1(((GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton) state).getShowKeyboard());
        } else if (state instanceof GuildFeedPublishFunctionBarMviUIState.UpdateTextCountOverLimit) {
            n1(((GuildFeedPublishFunctionBarMviUIState.UpdateTextCountOverLimit) state).getOverCount());
        } else if (state instanceof GuildFeedPublishFunctionBarMviUIState.UpdatePublishBtnEnable) {
            o1(((GuildFeedPublishFunctionBarMviUIState.UpdatePublishBtnEnable) state).getEnable());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildFeedPublishFunctionBarMviUIState>> getObserverStates() {
        List<Class<? extends GuildFeedPublishFunctionBarMviUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState.class, GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton.class, GuildFeedPublishFunctionBarMviUIState.UpdateTextCountOverLimit.class, GuildFeedPublishFunctionBarMviUIState.UpdatePublishBtnEnable.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        p g16 = p.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            inf\u2026          false\n        )");
        this.mBinding = g16;
        p pVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        g16.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean i16;
                i16 = GuildFeedSimplifiedPublishFunctionBarVB.i1(GuildFeedSimplifiedPublishFunctionBarVB.this, view, motionEvent);
                return i16;
            }
        });
        h1();
        g1();
        p pVar2 = this.mBinding;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            pVar = pVar2;
        }
        RelativeLayout root = pVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }
}
