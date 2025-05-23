package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.y;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendDataUpdateEvent;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedTextData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J*\u0010\u0019\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0014\u0010\u001c\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00101R\u0014\u00107\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u0002088BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u00101R\u0016\u0010A\u001a\u0004\u0018\u00010/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u00101R\u0016\u0010C\u001a\u0004\u0018\u00010/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u00101R\u0014\u0010E\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u00106R\u0014\u0010G\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u00106R\u0014\u0010K\u001a\u00020H8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/LikeSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "", "stat", "M", "", "P", ExifInterface.LATITUDE_SOUTH, "data", "position", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "count", "", "zeroHint", "y", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "", "payload", "O", "e", "Ljava/lang/String;", "eid", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "mUpVoteContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mUpVote", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mUpVoteNum", "Lcom/airbnb/lottie/LottieAnimationView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "D", "()Lcom/airbnb/lottie/LottieAnimationView;", "mUpVoteAnim", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, "()Landroid/graphics/drawable/Drawable;", "normalDrawable", BdhLogUtil.LogTag.Tag_Conn, "background", "L", "()I", "textColor", "Landroid/graphics/drawable/Drawable$ConstantState;", "K", "()Landroid/graphics/drawable/Drawable$ConstantState;", "TEXT_BG_DRAWABLE_STATE", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "BG_DRAWABLE_STATE", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ALL_RED_DRAWABLE", "B", "BLACK_HOLLOW_LIKE_DRAWABLE", "N", "WHITE_HOLLOW_LIKE_DRAWABLE", "H", "QUI_COMMON_TEXT_PRIMARY", "G", "QUI_COMMON_ICON_ALLWHITE_PRIMARY", "Landroid/content/res/Resources;", "J", "()Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class LikeSection extends ar<RecommendAbsFeedData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String eid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mUpVoteContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mUpVote;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mUpVoteNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mUpVoteAnim;

    public LikeSection(@NotNull String eid) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(eid, "eid");
        this.eid = eid;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection$mUpVoteAnim$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/LikeSection$mUpVoteAnim$2$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements Animator.AnimatorListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LikeSection f217172d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ LottieAnimationView f217173e;

                a(LikeSection likeSection, LottieAnimationView lottieAnimationView) {
                    this.f217172d = likeSection;
                    this.f217173e = lottieAnimationView;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(LikeSection this$0) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.S();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animation) {
                    ImageView imageView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.f217173e.setVisibility(4);
                    imageView = this.f217172d.mUpVote;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUpVote");
                        imageView = null;
                    }
                    imageView.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(@NotNull Animator animation) {
                    ImageView imageView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    imageView = this.f217172d.mUpVote;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUpVote");
                        imageView = null;
                    }
                    imageView.setVisibility(4);
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final LikeSection likeSection = this.f217172d;
                    uIHandlerV2.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE 
                          (r5v4 'uIHandlerV2' android.os.Handler)
                          (wrap:java.lang.Runnable:0x0021: CONSTRUCTOR (r0v2 'likeSection' com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection):void (m), WRAPPED] (LINE:34) call: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.e.<init>(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection):void type: CONSTRUCTOR)
                          (200 long)
                         VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:39) in method: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection$mUpVoteAnim$2.a.onAnimationStart(android.animation.Animator):void, file: classes13.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.e, state: NOT_LOADED
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
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "animation"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection r5 = r4.f217172d
                        android.widget.ImageView r5 = com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection.u(r5)
                        if (r5 != 0) goto L15
                        java.lang.String r5 = "mUpVote"
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
                        r5 = 0
                    L15:
                        r0 = 4
                        r5.setVisibility(r0)
                        android.os.Handler r5 = com.tencent.mobileqq.app.ThreadManagerV2.getUIHandlerV2()
                        com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection r0 = r4.f217172d
                        com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.e r1 = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.e
                        r1.<init>(r0)
                        r2 = 200(0xc8, double:9.9E-322)
                        r5.postDelayed(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection$mUpVoteAnim$2.a.onAnimationStart(android.animation.Animator):void");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LottieAnimationView invoke() {
                View view;
                FrameLayout frameLayout;
                view = ((Section) LikeSection.this).mRootView;
                LottieAnimationView lottieAnimationView = new LottieAnimationView(view.getContext());
                LikeSection likeSection = LikeSection.this;
                lottieAnimationView.setAnimation(RecommendBottomSection.f217174i.a());
                ((IGuildFeedConfigAPi) QRoute.api(IGuildFeedConfigAPi.class)).changePreferLottieColor(lottieAnimationView, lottieAnimationView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
                lottieAnimationView.addAnimatorListener(new a(likeSection, lottieAnimationView));
                frameLayout = LikeSection.this.mUpVoteContainer;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
                    frameLayout = null;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.guild.aio.util.c.b(14), com.tencent.guild.aio.util.c.b(14));
                layoutParams.gravity = 8388627;
                Unit unit = Unit.INSTANCE;
                frameLayout.addView(lottieAnimationView, layoutParams);
                return lottieAnimationView;
            }
        });
        this.mUpVoteAnim = lazy;
    }

    private final Drawable.ConstantState A() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(1291845632);
        gradientDrawable.setCornerRadius(com.tencent.guild.aio.util.c.b(16));
        Drawable.ConstantState constantState = gradientDrawable.getConstantState();
        Intrinsics.checkNotNull(constantState);
        return constantState;
    }

    private final Drawable B() {
        return GuildUIUtils.z(J(), R.drawable.qui_heart, H());
    }

    private final Drawable C() {
        Drawable.ConstantState A;
        if (this.mData instanceof RecommendFeedTextData) {
            A = K();
        } else {
            A = A();
        }
        Drawable newDrawable = A.newDrawable();
        Intrinsics.checkNotNullExpressionValue(newDrawable, "if (mData is RecommendFe\u2026WABLE_STATE.newDrawable()");
        return newDrawable;
    }

    private final LottieAnimationView D() {
        return (LottieAnimationView) this.mUpVoteAnim.getValue();
    }

    private final Drawable F() {
        if (this.mData instanceof RecommendFeedTextData) {
            return B();
        }
        return N();
    }

    private final int G() {
        return J().getColor(R.color.qui_common_icon_allwhite_primary);
    }

    private final int H() {
        return J().getColor(R.color.qui_common_text_primary);
    }

    private final Resources J() {
        Resources resources;
        View rootView = getRootView();
        if (rootView != null) {
            resources = rootView.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            return new com.tencent.mobileqq.guild.quiprofile.c(sMobileQQ, null, 0, false, 14, null);
        }
        return resources;
    }

    private final Drawable.ConstantState K() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(GuildUIUtils.f235378a.E(J().getColor(R.color.qui_common_fill_standard_secondary), 0.5f));
        gradientDrawable.setCornerRadius(com.tencent.guild.aio.util.c.b(16));
        Drawable.ConstantState constantState = gradientDrawable.getConstantState();
        Intrinsics.checkNotNull(constantState);
        return constantState;
    }

    private final int L() {
        if (this.mData instanceof RecommendFeedTextData) {
            return H();
        }
        return G();
    }

    private final int M(int stat) {
        if (stat != 1) {
            return 1;
        }
        return 0;
    }

    private final Drawable N() {
        return GuildUIUtils.z(J(), R.drawable.qui_heart, G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        int mUpVoteStatus = ((RecommendAbsFeedData) this.mData).getMUpVoteStatus();
        if (mUpVoteStatus == 1) {
            ((RecommendAbsFeedData) this.mData).setUpVoteStatus(2);
            S();
        } else {
            ((RecommendAbsFeedData) this.mData).setUpVoteStatus(1);
            D().setVisibility(0);
            D().playAnimation();
        }
        IGuildFeedUtilsApi iGuildFeedUtilsApi = (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        iGuildFeedUtilsApi.doVoteUpFeed((IGProContentRecommendFeed) mData, mUpVoteStatus, null, false);
        FrameLayout frameLayout = this.mUpVoteContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
            frameLayout = null;
        }
        VideoReport.reportEvent("clck", frameLayout, null);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        T mData2 = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData2, "mData");
        simpleEventBus.dispatchEvent(new RecommendDataUpdateEvent((RecommendAbsFeedData) mData2));
    }

    private final void Q(RecommendAbsFeedData data, int position) {
        Map map;
        FrameLayout frameLayout = this.mUpVoteContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
            frameLayout = null;
        }
        String str = this.eid;
        String valueOf = String.valueOf(data.getItemId());
        Map<String, Object> v3 = RecommendReportHelperKt.v(data, position - q().d());
        v3.put("sgrp_state", Integer.valueOf(M(data.getMUpVoteStatus())));
        Unit unit = Unit.INSTANCE;
        map = MapsKt__MapsKt.toMap(v3);
        com.tencent.mobileqq.guild.discoveryv2.util.b.b(frameLayout, str, valueOf, null, null, null, map, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map R;
                R = LikeSection.R(LikeSection.this, str2);
                return R;
            }
        }, 184, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Map R(LikeSection this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_action_result", Integer.valueOf(this$0.M(((RecommendAbsFeedData) this$0.mData).getMUpVoteStatus()))));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void S() {
        boolean isBlank;
        TextView textView = null;
        if (((RecommendAbsFeedData) this.mData).getMUpVoteStatus() == 1) {
            ImageView imageView = this.mUpVote;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpVote");
                imageView = null;
            }
            imageView.setImageDrawable(z());
        } else {
            ImageView imageView2 = this.mUpVote;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpVote");
                imageView2 = null;
            }
            imageView2.setImageDrawable(F());
        }
        TextView textView2 = this.mUpVoteNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteNum");
            textView2 = null;
        }
        textView2.setText(y(((RecommendAbsFeedData) this.mData).getMUpVoteCount(), ""));
        TextView textView3 = this.mUpVoteNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteNum");
            textView3 = null;
        }
        TextView textView4 = this.mUpVoteNum;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteNum");
        } else {
            textView = textView4;
        }
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mUpVoteNum.text");
        isBlank = StringsKt__StringsJVMKt.isBlank(text);
        Boolean valueOf = Boolean.valueOf(!isBlank);
        textView3.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, textView3)) == null) {
            textView3.setVisibility(8);
        }
    }

    private final String y(long count, String zeroHint) {
        return ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getShowCountString((int) count, zeroHint, y.b.f216487d);
    }

    private final Drawable z() {
        return GuildUIUtils.z(J(), R.drawable.qui_heart_filled, J().getColor(R.color.qui_common_feedback_error));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable RecommendAbsFeedData data, int position, @Nullable List<Object> payload) {
        S();
        TextView textView = this.mUpVoteNum;
        FrameLayout frameLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteNum");
            textView = null;
        }
        textView.setTextColor(L());
        FrameLayout frameLayout2 = this.mUpVoteContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setBackground(C());
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        Q((RecommendAbsFeedData) mData, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5n};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View stubView = getStubView(R.id.w5n);
        Intrinsics.checkNotNull(stubView, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) stubView;
        this.mUpVoteContainer = frameLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
            frameLayout = null;
        }
        View findViewById = frameLayout.findViewById(R.id.w5c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mUpVoteContainer.findVie\u2026guild_discovery_like_btn)");
        this.mUpVote = (ImageView) findViewById;
        FrameLayout frameLayout3 = this.mUpVoteContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
            frameLayout3 = null;
        }
        View findViewById2 = frameLayout3.findViewById(R.id.w5d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mUpVoteContainer.findVie\u2026guild_discovery_like_num)");
        this.mUpVoteNum = (TextView) findViewById2;
        FrameLayout frameLayout4 = this.mUpVoteContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpVoteContainer");
        } else {
            frameLayout2 = frameLayout4;
        }
        jt1.b.b(frameLayout2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.LikeSection$onInitView$1
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
                LikeSection.this.P();
            }
        });
    }
}
