package com.tencent.now.pkgame.pkgame.scorebar.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001LB!\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010'\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010\"R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010\"R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u00108R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006M"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/scorebar/view/WholeScoreBarView;", "Landroid/widget/FrameLayout;", "Llo3/a;", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "i", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/a;", "addScoreBean", DomainData.DOMAIN_NAME, "", "pkId", h.F, "j", "Lpo3/a;", "scoreBean", "o", "Lmo3/d;", "J", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/ViewModelProvider;", "d", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/view/View;", "f", "Landroid/view/View;", "root", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "leftScoreValueTv", "leftAddScoreTv", "rightScoreValueTv", BdhLogUtil.LogTag.Tag_Conn, "rightAddScoreTv", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/ScoreBar;", "D", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/ScoreBar;", "scoreBar", "Lcom/tencent/mobileqq/widget/RoundImageView;", "E", "Lcom/tencent/mobileqq/widget/RoundImageView;", "leftAnchorAvatar", UserInfo.SEX_FEMALE, "rightAnchorAvatar", "G", "leftAnchorNick", "H", "rightAnchorNick", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scoreBarContent", "scoreBarFace", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "faceCursor", "Lpo3/c;", "L", "Lpo3/c;", "wholeScoreBarViewModel", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/c;", "M", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/c;", "wholeScoreBarPrepareAnimPlayer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/ViewModelProvider;Landroidx/lifecycle/LifecycleOwner;)V", "N", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class WholeScoreBarView extends FrameLayout implements lo3.a {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView rightAddScoreTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ScoreBar scoreBar;

    /* renamed from: E, reason: from kotlin metadata */
    private RoundImageView leftAnchorAvatar;

    /* renamed from: F, reason: from kotlin metadata */
    private RoundImageView rightAnchorAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView leftAnchorNick;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView rightAnchorNick;

    /* renamed from: I, reason: from kotlin metadata */
    private ConstraintLayout scoreBarContent;

    /* renamed from: J, reason: from kotlin metadata */
    private ConstraintLayout scoreBarFace;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView faceCursor;

    /* renamed from: L, reason: from kotlin metadata */
    private po3.c wholeScoreBarViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c wholeScoreBarPrepareAnimPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelProvider viewModelProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView leftScoreValueTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView leftAddScoreTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView rightScoreValueTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WholeScoreBarView(@Nullable Context context, @NotNull ViewModelProvider viewModelProvider, @NotNull LifecycleOwner lifecycleOwner) {
        super(context);
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNull(context);
        this.viewModelProvider = viewModelProvider;
        this.lifecycleOwner = lifecycleOwner;
        this.wholeScoreBarPrepareAnimPlayer = new c();
        l();
        m();
        j();
    }

    private final void h(String pkId) {
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_qqlive_pk_socrebar");
        hashMap.put("qqlive_pk_programid", pkId);
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this, true, null, "em_qqlive_pk_socrebar", hashMap);
    }

    private final URLDrawable.URLDrawableOptions i() {
        Drawable drawable = getResources().getDrawable(R.drawable.trans);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WholeScoreBarView this$0, po3.a scoreBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scoreBean, "scoreBean");
        this$0.o(scoreBean);
    }

    private final void l() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hay, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ive_pk_scorebar_bg, this)");
        this.root = inflate;
        TextView textView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f80174ar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.score_bar)");
        this.scoreBar = (ScoreBar) findViewById;
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.yhm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.left_value)");
        this.leftScoreValueTv = (TextView) findViewById2;
        View view2 = this.root;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.ygv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.left_add_value)");
        this.leftAddScoreTv = (TextView) findViewById3;
        View view3 = this.root;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.ygw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.left_anchor_avatar)");
        this.leftAnchorAvatar = (RoundImageView) findViewById4;
        View view4 = this.root;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.ygx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.left_anchor_nick)");
        this.leftAnchorNick = (TextView) findViewById5;
        View view5 = this.root;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view5 = null;
        }
        View findViewById6 = view5.findViewById(R.id.f74473wc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.right_anchor_avatar)");
        this.rightAnchorAvatar = (RoundImageView) findViewById6;
        View view6 = this.root;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view6 = null;
        }
        View findViewById7 = view6.findViewById(R.id.f74483wd);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.right_anchor_nick)");
        this.rightAnchorNick = (TextView) findViewById7;
        View view7 = this.root;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view7 = null;
        }
        View findViewById8 = view7.findViewById(R.id.f74883xg);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.right_value)");
        this.rightScoreValueTv = (TextView) findViewById8;
        View view8 = this.root;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view8 = null;
        }
        View findViewById9 = view8.findViewById(R.id.f74463wb);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.right_add_value)");
        this.rightAddScoreTv = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.f80204au);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.score_bar_face)");
        this.scoreBarFace = (ConstraintLayout) findViewById10;
        View findViewById11 = findViewById(R.id.f80194at);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.score_bar_content)");
        this.scoreBarContent = (ConstraintLayout) findViewById11;
        View findViewById12 = findViewById(R.id.f165124uz3);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.face_cursor)");
        this.faceCursor = (ImageView) findViewById12;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        ImageView imageView = this.faceCursor;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceCursor");
            imageView = null;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/Q3auHgzwzM5522kdqrNehXgZzqR6vgeRpzficZTZlKSsiaylS0QJ7b0g/", obtain));
        TextView textView2 = this.leftScoreValueTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftScoreValueTv");
            textView2 = null;
        }
        textView2.setVisibility(4);
        TextView textView3 = this.rightScoreValueTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightScoreValueTv");
            textView3 = null;
        }
        textView3.setVisibility(4);
        TextView textView4 = this.leftAddScoreTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftAddScoreTv");
            textView4 = null;
        }
        RFWTypefaceUtil.setNumberTypeface(textView4, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
        TextView textView5 = this.rightAddScoreTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightAddScoreTv");
        } else {
            textView = textView5;
        }
        RFWTypefaceUtil.setNumberTypeface(textView, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
    }

    private final void m() {
        ViewModel viewModel = this.viewModelProvider.get(po3.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(\n \u2026del::class.java\n        )");
        po3.c cVar = (po3.c) viewModel;
        this.wholeScoreBarViewModel = cVar;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
            cVar = null;
        }
        h(cVar.getPkId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(AddScoreBean addScoreBean) {
        TextView textView = null;
        if (addScoreBean.getSide() == "left") {
            TextView textView2 = this.leftAddScoreTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftAddScoreTv");
                textView2 = null;
            }
            textView2.setText(addScoreBean.getScore());
        }
        if (addScoreBean.getSide() == "right") {
            TextView textView3 = this.rightAddScoreTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightAddScoreTv");
            } else {
                textView = textView3;
            }
            textView.setText(addScoreBean.getScore());
        }
    }

    @Override // lo3.a
    @NotNull
    public mo3.d J() {
        po3.c cVar = this.wholeScoreBarViewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
            return null;
        }
        return cVar;
    }

    public final void j() {
        po3.c cVar = this.wholeScoreBarViewModel;
        po3.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
            cVar = null;
        }
        cVar.a2().observe(this.lifecycleOwner, new Observer() { // from class: com.tencent.now.pkgame.pkgame.scorebar.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WholeScoreBarView.k(WholeScoreBarView.this, (po3.a) obj);
            }
        });
        po3.c cVar3 = this.wholeScoreBarViewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
            cVar3 = null;
        }
        cVar3.W1().observe(this.lifecycleOwner, new mo3.b(new Function1<AddScoreBean, Unit>() { // from class: com.tencent.now.pkgame.pkgame.scorebar.view.WholeScoreBarView$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddScoreBean addScoreBean) {
                invoke2(addScoreBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AddScoreBean addScoreBean) {
                Intrinsics.checkNotNullParameter(addScoreBean, "addScoreBean");
                WholeScoreBarView.this.n(addScoreBean);
            }
        }));
        po3.c cVar4 = this.wholeScoreBarViewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
            cVar4 = null;
        }
        cVar4.c2().observe(this.lifecycleOwner, new mo3.b(new Function1<Boolean, Unit>() { // from class: com.tencent.now.pkgame.pkgame.scorebar.view.WholeScoreBarView$initData$3

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/now/pkgame/pkgame/scorebar/view/WholeScoreBarView$initData$3$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes22.dex */
            public static final class a implements Animation.AnimationListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ WholeScoreBarView f339085d;

                a(WholeScoreBarView wholeScoreBarView) {
                    this.f339085d = wholeScoreBarView;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@NotNull Animation animation) {
                    ConstraintLayout constraintLayout;
                    ImageView imageView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    constraintLayout = this.f339085d.scoreBarFace;
                    ImageView imageView2 = null;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBarFace");
                        constraintLayout = null;
                    }
                    constraintLayout.setVisibility(4);
                    imageView = this.f339085d.faceCursor;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("faceCursor");
                    } else {
                        imageView2 = imageView;
                    }
                    imageView2.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@NotNull Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@NotNull Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/now/pkgame/pkgame/scorebar/view/WholeScoreBarView$initData$3$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes22.dex */
            public static final class b implements Animation.AnimationListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ WholeScoreBarView f339086d;

                b(WholeScoreBarView wholeScoreBarView) {
                    this.f339086d = wholeScoreBarView;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@NotNull Animation animation) {
                    ConstraintLayout constraintLayout;
                    ImageView imageView;
                    ScoreBar scoreBar;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    constraintLayout = this.f339086d.scoreBarContent;
                    ScoreBar scoreBar2 = null;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBarContent");
                        constraintLayout = null;
                    }
                    constraintLayout.setVisibility(0);
                    imageView = this.f339086d.faceCursor;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("faceCursor");
                        imageView = null;
                    }
                    imageView.setVisibility(8);
                    scoreBar = this.f339086d.scoreBar;
                    if (scoreBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBar");
                    } else {
                        scoreBar2 = scoreBar;
                    }
                    scoreBar2.i();
                    this.f339086d.J().Q1(new jo3.c());
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@NotNull Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@NotNull Animation animation) {
                    ScoreBar scoreBar;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    scoreBar = this.f339086d.scoreBar;
                    if (scoreBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBar");
                        scoreBar = null;
                    }
                    scoreBar.j();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                c cVar5;
                ConstraintLayout constraintLayout;
                c cVar6;
                ConstraintLayout constraintLayout2;
                if (z16) {
                    cVar5 = WholeScoreBarView.this.wholeScoreBarPrepareAnimPlayer;
                    constraintLayout = WholeScoreBarView.this.scoreBarFace;
                    ConstraintLayout constraintLayout3 = null;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBarFace");
                        constraintLayout = null;
                    }
                    cVar5.c(constraintLayout, new a(WholeScoreBarView.this));
                    cVar6 = WholeScoreBarView.this.wholeScoreBarPrepareAnimPlayer;
                    constraintLayout2 = WholeScoreBarView.this.scoreBarContent;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBarContent");
                    } else {
                        constraintLayout3 = constraintLayout2;
                    }
                    cVar6.b(constraintLayout3, new b(WholeScoreBarView.this));
                }
            }
        }));
        po3.c cVar5 = this.wholeScoreBarViewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wholeScoreBarViewModel");
        } else {
            cVar2 = cVar5;
        }
        cVar2.b2().observe(this.lifecycleOwner, new mo3.b(new Function1<Boolean, Unit>() { // from class: com.tencent.now.pkgame.pkgame.scorebar.view.WholeScoreBarView$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ScoreBar scoreBar;
                if (z16) {
                    scoreBar = WholeScoreBarView.this.scoreBar;
                    if (scoreBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scoreBar");
                        scoreBar = null;
                    }
                    scoreBar.p();
                }
            }
        }));
    }

    @VisibleForTesting
    public final void o(@NotNull po3.a scoreBean) {
        Intrinsics.checkNotNullParameter(scoreBean, "scoreBean");
        ScoreBar scoreBar = this.scoreBar;
        TextView textView = null;
        if (scoreBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreBar");
            scoreBar = null;
        }
        scoreBar.q(scoreBean.leftScore, scoreBean.rightScore);
        TextView textView2 = this.leftScoreValueTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftScoreValueTv");
            textView2 = null;
        }
        textView2.setText(scoreBean.getLeftScoreText());
        TextView textView3 = this.rightScoreValueTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightScoreValueTv");
            textView3 = null;
        }
        textView3.setText(scoreBean.getRightScoreText());
        URLDrawable drawable = URLDrawable.getDrawable(scoreBean.b(), i());
        RoundImageView roundImageView = this.leftAnchorAvatar;
        if (roundImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftAnchorAvatar");
            roundImageView = null;
        }
        roundImageView.setImageDrawable(drawable);
        TextView textView4 = this.leftAnchorNick;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftAnchorNick");
            textView4 = null;
        }
        textView4.setText(scoreBean.c());
        URLDrawable drawable2 = URLDrawable.getDrawable(scoreBean.e(), i());
        RoundImageView roundImageView2 = this.rightAnchorAvatar;
        if (roundImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightAnchorAvatar");
            roundImageView2 = null;
        }
        roundImageView2.setImageDrawable(drawable2);
        TextView textView5 = this.rightAnchorNick;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightAnchorNick");
        } else {
            textView = textView5;
        }
        textView.setText(scoreBean.f());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wholeScoreBarPrepareAnimPlayer.a();
    }
}
