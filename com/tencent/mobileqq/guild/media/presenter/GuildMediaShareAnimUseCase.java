package com.tencent.mobileqq.guild.media.presenter;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.aq;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\nB-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001fR\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase;", "", "", "j", "l", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "", "u", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "a", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "o", "()Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "mShareBtn", "", "b", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "mChannelType", "", "c", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "scene", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "p", "()Lkotlin/jvm/functions/Function0;", NodeProps.ON_CLICK, "e", "Z", "mShareAnimating", "Landroid/view/View;", "kotlin.jvm.PlatformType", "f", "Landroid/view/View;", "mShareIv", "g", "Lkotlin/Lazy;", "r", "stopShareAnimFunc", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mShareBtnBubbleTip", "Lcom/airbnb/lottie/LottieAnimationView;", "i", DomainData.DOMAIN_NAME, "()Lcom/airbnb/lottie/LottieAnimationView;", "mShareAnimView", "<init>", "(Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaShareAnimUseCase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRightIconLayout mShareBtn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mChannelType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShareAnimating;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View mShareIv;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy stopShareAnimFunc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow mShareBtnBubbleTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mShareAnimView;

    public GuildMediaShareAnimUseCase(@NotNull GuildRightIconLayout mShareBtn, int i3, @NotNull String scene, @NotNull Function0<Unit> onClick) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mShareBtn, "mShareBtn");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.mShareBtn = mShareBtn;
        this.mChannelType = i3;
        this.scene = scene;
        this.onClick = onClick;
        this.mShareIv = mShareBtn.getChildAt(0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function0<? extends Unit>>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$stopShareAnimFunc$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$stopShareAnimFunc$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                final /* synthetic */ GuildMediaShareAnimUseCase this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(GuildMediaShareAnimUseCase guildMediaShareAnimUseCase) {
                    super(0);
                    this.this$0 = guildMediaShareAnimUseCase;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(GuildMediaShareAnimUseCase this$0) {
                    LottieAnimationView n3;
                    LottieAnimationView n16;
                    View view;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    GuildRightIconLayout mShareBtn = this$0.getMShareBtn();
                    n3 = this$0.n();
                    mShareBtn.removeView(n3);
                    n16 = this$0.n();
                    n16.setVisibility(8);
                    view = this$0.mShareIv;
                    view.setVisibility(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LottieAnimationView n3;
                    Map mapOf;
                    PopupWindow popupWindow;
                    PopupWindow popupWindow2;
                    LottieAnimationView n16;
                    LottieAnimationView n17;
                    LottieAnimationView n18;
                    View view;
                    View view2;
                    View view3;
                    View view4;
                    LottieAnimationView n19;
                    View view5;
                    PopupWindow popupWindow3;
                    Map mapOf2;
                    n3 = this.this$0.n();
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.this$0.getMChannelType())));
                    VideoReport.reportEvent("imp_end", n3, mapOf);
                    popupWindow = this.this$0.mShareBtnBubbleTip;
                    if (popupWindow != null) {
                        popupWindow3 = this.this$0.mShareBtnBubbleTip;
                        Intrinsics.checkNotNull(popupWindow3);
                        View contentView = popupWindow3.getContentView();
                        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.this$0.getMChannelType())));
                        VideoReport.reportEvent("imp_end", contentView, mapOf2);
                    }
                    this.this$0.mShareAnimating = false;
                    popupWindow2 = this.this$0.mShareBtnBubbleTip;
                    if (popupWindow2 != null) {
                        popupWindow2.dismiss();
                    }
                    n16 = this.this$0.n();
                    n16.cancelAnimation();
                    if (Intrinsics.areEqual(this.this$0.getScene(), "scene_live")) {
                        view2 = this.this$0.mShareIv;
                        view2.setAlpha(0.01f);
                        view3 = this.this$0.mShareIv;
                        view3.setScaleX(0.7f);
                        view4 = this.this$0.mShareIv;
                        view4.setScaleY(0.7f);
                        n19 = this.this$0.n();
                        n19.animate().alpha(0.01f).scaleX(0.7f).scaleY(0.7f).setDuration(200L).start();
                        view5 = this.this$0.mShareIv;
                        ViewPropertyAnimator duration = view5.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L);
                        final GuildMediaShareAnimUseCase guildMediaShareAnimUseCase = this.this$0;
                        duration.withEndAction(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00db: INVOKE 
                              (wrap:android.view.ViewPropertyAnimator:0x00d7: INVOKE 
                              (r0v37 'duration' android.view.ViewPropertyAnimator)
                              (wrap:java.lang.Runnable:0x00d4: CONSTRUCTOR 
                              (r1v8 'guildMediaShareAnimUseCase' com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase A[DONT_INLINE])
                             A[MD:(com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase):void (m), WRAPPED] call: com.tencent.mobileqq.guild.media.presenter.f.<init>(com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.ViewPropertyAnimator.withEndAction(java.lang.Runnable):android.view.ViewPropertyAnimator A[MD:(java.lang.Runnable):android.view.ViewPropertyAnimator (c), WRAPPED])
                             VIRTUAL call: android.view.ViewPropertyAnimator.start():void A[MD:():void (c)] (LINE:19) in method: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$stopShareAnimFunc$2.1.invoke():void, file: classes14.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.guild.media.presenter.f, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:852)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 23 more
                            */
                        /*
                            this = this;
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            com.airbnb.lottie.LottieAnimationView r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.d(r0)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r1 = r4.this$0
                            int r1 = r1.getMChannelType()
                            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                            java.lang.String r2 = "sgrp_subchannel_type"
                            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
                            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
                            java.lang.String r3 = "imp_end"
                            com.tencent.qqlive.module.videoreport.VideoReport.reportEvent(r3, r0, r1)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.widget.PopupWindow r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.e(r0)
                            if (r0 == 0) goto L4b
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.widget.PopupWindow r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.e(r0)
                            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                            android.view.View r0 = r0.getContentView()
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r1 = r4.this$0
                            int r1 = r1.getMChannelType()
                            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
                            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
                            com.tencent.qqlive.module.videoreport.VideoReport.reportEvent(r3, r0, r1)
                        L4b:
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            r1 = 0
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.g(r0, r1)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.widget.PopupWindow r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.e(r0)
                            if (r0 == 0) goto L5c
                            r0.dismiss()
                        L5c:
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            com.airbnb.lottie.LottieAnimationView r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.d(r0)
                            r0.cancelAnimation()
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            java.lang.String r0 = r0.getScene()
                            java.lang.String r2 = "scene_live"
                            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                            if (r0 == 0) goto Ldf
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.view.View r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.f(r0)
                            r1 = 1008981770(0x3c23d70a, float:0.01)
                            r0.setAlpha(r1)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.view.View r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.f(r0)
                            r2 = 1060320051(0x3f333333, float:0.7)
                            r0.setScaleX(r2)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.view.View r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.f(r0)
                            r0.setScaleY(r2)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            com.airbnb.lottie.LottieAnimationView r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.d(r0)
                            android.view.ViewPropertyAnimator r0 = r0.animate()
                            android.view.ViewPropertyAnimator r0 = r0.alpha(r1)
                            android.view.ViewPropertyAnimator r0 = r0.scaleX(r2)
                            android.view.ViewPropertyAnimator r0 = r0.scaleY(r2)
                            r1 = 200(0xc8, double:9.9E-322)
                            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
                            r0.start()
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.view.View r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.f(r0)
                            android.view.ViewPropertyAnimator r0 = r0.animate()
                            r3 = 1065353216(0x3f800000, float:1.0)
                            android.view.ViewPropertyAnimator r0 = r0.alpha(r3)
                            android.view.ViewPropertyAnimator r0 = r0.scaleX(r3)
                            android.view.ViewPropertyAnimator r0 = r0.scaleY(r3)
                            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r1 = r4.this$0
                            com.tencent.mobileqq.guild.media.presenter.f r2 = new com.tencent.mobileqq.guild.media.presenter.f
                            r2.<init>(r1)
                            android.view.ViewPropertyAnimator r0 = r0.withEndAction(r2)
                            r0.start()
                            goto L102
                        Ldf:
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            com.tencent.mobileqq.guild.widget.GuildRightIconLayout r0 = r0.getMShareBtn()
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r2 = r4.this$0
                            com.airbnb.lottie.LottieAnimationView r2 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.d(r2)
                            r0.removeView(r2)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            com.airbnb.lottie.LottieAnimationView r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.d(r0)
                            r2 = 8
                            r0.setVisibility(r2)
                            com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase r0 = r4.this$0
                            android.view.View r0 = com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase.f(r0)
                            r0.setVisibility(r1)
                        L102:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$stopShareAnimFunc$2.AnonymousClass1.invoke2():void");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Function0<? extends Unit> invoke() {
                    return new AnonymousClass1(GuildMediaShareAnimUseCase.this);
                }
            });
            this.stopShareAnimFunc = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$mShareAnimView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LottieAnimationView invoke() {
                    LottieAnimationView lottieAnimationView = new LottieAnimationView(GuildMediaShareAnimUseCase.this.getMShareBtn().getContext());
                    lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    lottieAnimationView.setRepeatCount(-1);
                    lottieAnimationView.setAnimation("guild_share_icon_animate.json");
                    lottieAnimationView.setVisibility(0);
                    return lottieAnimationView;
                }
            });
            this.mShareAnimView = lazy2;
        }

        private final void h() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function0<Unit> r16 = r();
            uIHandlerV2.removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaShareAnimUseCase.i(Function0.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        private final void j() {
            this.mShareIv.setVisibility(8);
            n().setVisibility(0);
            n().addAnimatorListener(new b());
            n().playAnimation();
            this.mShareAnimating = true;
            if (!bw.L().decodeBool("key_share_bubble_anim", false)) {
                if (this.mShareBtn.getContext() instanceof Activity) {
                    Context context = this.mShareBtn.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    if (((Activity) context).isFinishing()) {
                        return;
                    }
                }
                bw.L().encodeBool("key_share_bubble_anim", true);
                Context context2 = this.mShareBtn.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "mShareBtn.context");
                PopupWindow a16 = aq.a(context2, this.mShareBtn, true, "\u9080\u8bf7\u597d\u53cb\u4e00\u8d77\u804a");
                this.mShareBtnBubbleTip = a16;
                Intrinsics.checkNotNull(a16);
                View contentView = a16.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "mShareBtnBubbleTip!!.contentView");
                jt1.b.b(contentView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase$doShowShareAnim$2
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
                        PopupWindow popupWindow;
                        Map mapOf;
                        Intrinsics.checkNotNullParameter(it, "it");
                        popupWindow = GuildMediaShareAnimUseCase.this.mShareBtnBubbleTip;
                        Intrinsics.checkNotNull(popupWindow);
                        View contentView2 = popupWindow.getContentView();
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(GuildMediaShareAnimUseCase.this.getMChannelType())));
                        VideoReport.reportEvent("clck", contentView2, mapOf);
                        GuildMediaShareAnimUseCase.this.p().invoke();
                    }
                });
            }
            l();
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function0<Unit> r16 = r();
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaShareAnimUseCase.k(Function0.this);
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        private final void l() {
            Map mapOf;
            Map mapOf2;
            LottieAnimationView n3 = n();
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            ch.Y0(n3, "em_sgrp_share_guild_breathe_logo", clickPolicy, exposurePolicy);
            LottieAnimationView n16 = n();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.mChannelType)));
            VideoReport.reportEvent("imp", n16, mapOf);
            PopupWindow popupWindow = this.mShareBtnBubbleTip;
            if (popupWindow != null) {
                Intrinsics.checkNotNull(popupWindow);
                ch.Y0(popupWindow.getContentView(), "em_sgrp_share_guild_bubble", clickPolicy, exposurePolicy);
                PopupWindow popupWindow2 = this.mShareBtnBubbleTip;
                Intrinsics.checkNotNull(popupWindow2);
                View contentView = popupWindow2.getContentView();
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.mChannelType)));
                VideoReport.reportEvent("imp", contentView, mapOf2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LottieAnimationView n() {
            return (LottieAnimationView) this.mShareAnimView.getValue();
        }

        private final Function0<Unit> r() {
            return (Function0) this.stopShareAnimFunc.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(GuildMediaShareAnimUseCase this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j();
        }

        /* renamed from: m, reason: from getter */
        public final int getMChannelType() {
            return this.mChannelType;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final GuildRightIconLayout getMShareBtn() {
            return this.mShareBtn;
        }

        @NotNull
        public final Function0<Unit> p() {
            return this.onClick;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        public final void s() {
            if (this.mShareBtn.getVisibility() != 0) {
                return;
            }
            this.mShareBtn.addView(n());
            if (Intrinsics.areEqual(this.scene, "scene_live")) {
                n().setAlpha(0.01f);
                n().setScaleX(0.7f);
                n().setScaleY(0.7f);
                this.mShareIv.animate().alpha(0.01f).scaleX(0.7f).scaleY(0.7f).setDuration(200L).start();
                n().animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaShareAnimUseCase.t(GuildMediaShareAnimUseCase.this);
                    }
                }).start();
                return;
            }
            j();
        }

        public final boolean u() {
            Map mapOf;
            boolean z16 = this.mShareAnimating;
            if (z16) {
                LottieAnimationView n3 = n();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.mChannelType)));
                VideoReport.reportEvent("clck", n3, mapOf);
                r().invoke();
                h();
            }
            return z16;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animation) {
            }
        }
    }
