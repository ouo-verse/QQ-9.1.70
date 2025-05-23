package com.qzone.reborn.feedpro.part;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTimeLineView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/part/QzoneFeedProTimeLinePart;", "Lcom/qzone/reborn/base/k;", "Lgf/m;", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView$c;", "I9", "Landroid/view/animation/Animation;", "K9", "H9", "Landroid/view/View;", "view", "", "N9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", ViewStickEventHelper.IS_SHOW, TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "action", "", "arg", "handleBroadcastMessage", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "d", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mViewModel", "e", "Landroid/view/animation/Animation;", "mTimeLineHideAnimation", "f", "mTimeLineShowAnimation", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView;", "mTimeLineView", "i", "Landroid/view/View;", "mTimeLineMask", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProTimeLinePart extends com.qzone.reborn.base.k implements gf.m {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Animation mTimeLineHideAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Animation mTimeLineShowAnimation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneHomePageTimeLineView mTimeLineView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mTimeLineMask;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/part/QzoneFeedProTimeLinePart$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QzoneFeedProTimeLinePart qzoneFeedProTimeLinePart = QzoneFeedProTimeLinePart.this;
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView = qzoneFeedProTimeLinePart.mTimeLineView;
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView2 = null;
            if (qZoneHomePageTimeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                qZoneHomePageTimeLineView = null;
            }
            qzoneFeedProTimeLinePart.N9(qZoneHomePageTimeLineView);
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = QzoneFeedProTimeLinePart.this.mTimeLineView;
            if (qZoneHomePageTimeLineView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
            } else {
                qZoneHomePageTimeLineView2 = qZoneHomePageTimeLineView3;
            }
            qZoneHomePageTimeLineView2.setContentDescription("\u6253\u5f00\u65e5\u671f\u9009\u62e9\u9762\u677f");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    private final Animation H9() {
        if (this.mTimeLineHideAnimation == null) {
            this.mTimeLineHideAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.f155014gm);
        }
        return this.mTimeLineHideAnimation;
    }

    private final QZoneHomePageTimeLineView.c I9() {
        return new QZoneHomePageTimeLineView.c() { // from class: com.qzone.reborn.feedpro.part.u
            @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTimeLineView.c
            public final void a(long j3) {
                QzoneFeedProTimeLinePart.J9(QzoneFeedProTimeLinePart.this, j3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QzoneFeedProTimeLinePart this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.db(false);
        com.qzone.reborn.feedpro.viewmodel.m mVar = this$0.mViewModel;
        if (mVar != null) {
            mVar.w2(j3);
        }
        this$0.broadcastMessage("on_time_line_click", Long.valueOf(j3));
    }

    private final Animation K9() {
        if (this.mTimeLineShowAnimation == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.f155013gl);
            this.mTimeLineShowAnimation = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new a());
            }
        }
        return this.mTimeLineShowAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QzoneFeedProTimeLinePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.db(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [android.view.View] */
    @Override // gf.m
    public void db(boolean isShow) {
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView = this.mTimeLineView;
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView2 = null;
        if (qZoneHomePageTimeLineView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
            qZoneHomePageTimeLineView = null;
        }
        if (qZoneHomePageTimeLineView.getVisibility() == 0 && !isShow) {
            if (H9() != null) {
                QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = this.mTimeLineView;
                if (qZoneHomePageTimeLineView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    qZoneHomePageTimeLineView3 = null;
                }
                qZoneHomePageTimeLineView3.startAnimation(H9());
            }
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView4 = this.mTimeLineView;
            if (qZoneHomePageTimeLineView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                qZoneHomePageTimeLineView4 = null;
            }
            qZoneHomePageTimeLineView4.setVisibility(8);
            ?? r56 = this.mTimeLineMask;
            if (r56 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineMask");
            } else {
                qZoneHomePageTimeLineView2 = r56;
            }
            qZoneHomePageTimeLineView2.setVisibility(8);
            return;
        }
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView5 = this.mTimeLineView;
        if (qZoneHomePageTimeLineView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
            qZoneHomePageTimeLineView5 = null;
        }
        if (qZoneHomePageTimeLineView5.getVisibility() == 0 || !isShow) {
            return;
        }
        if (K9() != null) {
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView6 = this.mTimeLineView;
            if (qZoneHomePageTimeLineView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                qZoneHomePageTimeLineView6 = null;
            }
            qZoneHomePageTimeLineView6.startAnimation(K9());
        }
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView7 = this.mTimeLineView;
        if (qZoneHomePageTimeLineView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
            qZoneHomePageTimeLineView7 = null;
        }
        qZoneHomePageTimeLineView7.setVisibility(0);
        View view = this.mTimeLineMask;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineMask");
            view = null;
        }
        view.setVisibility(0);
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView8 = this.mTimeLineView;
        if (qZoneHomePageTimeLineView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
        } else {
            qZoneHomePageTimeLineView2 = qZoneHomePageTimeLineView8;
        }
        qZoneHomePageTimeLineView2.h();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProTimeLinePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object arg) {
        if (Intrinsics.areEqual("SHOW_TIME_LINE", action)) {
            db(true);
            return;
        }
        if (Intrinsics.areEqual("UPDATE_TIME_LINE_SELECTION", action) && (arg instanceof Long)) {
            Number number = (Number) arg;
            if (number.longValue() > 0) {
                QZoneHomePageTimeLineView qZoneHomePageTimeLineView = this.mTimeLineView;
                if (qZoneHomePageTimeLineView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    qZoneHomePageTimeLineView = null;
                }
                qZoneHomePageTimeLineView.setSelection(number.longValue());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        MutableLiveData<ProfileTimeLine> h26;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ncw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026user_home_time_line_mask)");
        this.mTimeLineMask = findViewById;
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineMask");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProTimeLinePart.L9(QzoneFeedProTimeLinePart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.ncx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026user_home_time_line_view)");
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView2 = (QZoneHomePageTimeLineView) findViewById2;
        this.mTimeLineView = qZoneHomePageTimeLineView2;
        if (qZoneHomePageTimeLineView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
            qZoneHomePageTimeLineView2 = null;
        }
        qZoneHomePageTimeLineView2.setTimeLineListener(I9());
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = this.mTimeLineView;
        if (qZoneHomePageTimeLineView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
        } else {
            qZoneHomePageTimeLineView = qZoneHomePageTimeLineView3;
        }
        qZoneHomePageTimeLineView.setPaddingForTimeLineHeader(getActivity());
        this.mViewModel = (com.qzone.reborn.feedpro.viewmodel.m) getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        registerIoc(this, gf.m.class);
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mViewModel;
        if (mVar == null || (h26 = mVar.h2()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<ProfileTimeLine, Unit> function1 = new Function1<ProfileTimeLine, Unit>() { // from class: com.qzone.reborn.feedpro.part.QzoneFeedProTimeLinePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileTimeLine profileTimeLine) {
                invoke2(profileTimeLine);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileTimeLine profileTimeLine) {
                QZoneHomePageTimeLineView qZoneHomePageTimeLineView4 = QzoneFeedProTimeLinePart.this.mTimeLineView;
                if (qZoneHomePageTimeLineView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    qZoneHomePageTimeLineView4 = null;
                }
                qZoneHomePageTimeLineView4.setData(profileTimeLine);
            }
        };
        h26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.feedpro.part.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProTimeLinePart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.requestFocusFromTouch();
        }
    }
}
