package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTimeLineView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/t;", "Lcom/qzone/reborn/base/k;", "Lgf/m;", "Lcom/qzone/common/event/IObserver$main;", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView$c;", "H9", "Landroid/view/animation/Animation;", "J9", "G9", "Landroid/view/View;", "view", "", "M9", "Lcom/qzone/common/event/Event;", "event", "K9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", ViewStickEventHelper.IS_SHOW, TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "onEventUIThread", "action", "", "arg", "handleBroadcastMessage", "Lcom/qzone/reborn/feedx/viewmodel/w;", "d", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mViewModel", "e", "Landroid/view/animation/Animation;", "mTimeLineHideAnimation", "f", "mTimeLineShowAnimation", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTimeLineView;", "mTimeLineView", "i", "Landroid/view/View;", "mTimeLineMask", "Lcom/qzone/proxy/feedcomponent/model/ProfileTimeLine;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/proxy/feedcomponent/model/ProfileTimeLine;", "mTimeLineData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends com.qzone.reborn.base.k implements gf.m, IObserver.main {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Animation mTimeLineHideAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Animation mTimeLineShowAnimation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneHomePageTimeLineView mTimeLineView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mTimeLineMask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ProfileTimeLine mTimeLineData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/part/userhome/t$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            t tVar = t.this;
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView = tVar.mTimeLineView;
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView2 = null;
            if (qZoneHomePageTimeLineView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                qZoneHomePageTimeLineView = null;
            }
            tVar.M9(qZoneHomePageTimeLineView);
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = t.this.mTimeLineView;
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

    private final Animation G9() {
        if (this.mTimeLineHideAnimation == null) {
            this.mTimeLineHideAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.f155014gm);
        }
        return this.mTimeLineHideAnimation;
    }

    private final QZoneHomePageTimeLineView.c H9() {
        return new QZoneHomePageTimeLineView.c() { // from class: com.qzone.reborn.feedx.part.userhome.s
            @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTimeLineView.c
            public final void a(long j3) {
                t.I9(t.this, j3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(t this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.db(false);
        com.qzone.reborn.feedx.viewmodel.w wVar = this$0.mViewModel;
        if (wVar != null) {
            wVar.W2(j3);
        }
        this$0.broadcastMessage("on_time_line_click", Long.valueOf(j3));
    }

    private final Animation J9() {
        if (this.mTimeLineShowAnimation == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.f155013gl);
            this.mTimeLineShowAnimation = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new a());
            }
        }
        return this.mTimeLineShowAnimation;
    }

    private final void K9(Event event) {
        ProfileTimeLine timeLineDataCache;
        HashMap<Integer, ArrayList<Integer>> hashMap;
        Object obj = event.params;
        if (obj instanceof ProfileTimeLine) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.proxy.feedcomponent.model.ProfileTimeLine");
            ProfileTimeLine profileTimeLine = (ProfileTimeLine) obj;
            HashMap<Integer, ArrayList<Integer>> hashMap2 = profileTimeLine.timeLines;
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView = null;
            if (hashMap2 != null) {
                Intrinsics.checkNotNullExpressionValue(hashMap2, "newTimeLine.timeLines");
                if (!hashMap2.isEmpty()) {
                    this.mTimeLineData = profileTimeLine;
                    QZoneHomePageTimeLineView qZoneHomePageTimeLineView2 = this.mTimeLineView;
                    if (qZoneHomePageTimeLineView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    } else {
                        qZoneHomePageTimeLineView = qZoneHomePageTimeLineView2;
                    }
                    qZoneHomePageTimeLineView.setData(this.mTimeLineData);
                    com.qzone.reborn.feedx.viewmodel.w wVar = this.mViewModel;
                    if (wVar != null) {
                        wVar.q2(this.mTimeLineData);
                        return;
                    }
                    return;
                }
            }
            com.qzone.reborn.feedx.viewmodel.w wVar2 = this.mViewModel;
            if ((wVar2 == null || (timeLineDataCache = wVar2.getTimeLineDataCache()) == null || (hashMap = timeLineDataCache.timeLines) == null || !(hashMap.isEmpty() ^ true)) ? false : true) {
                com.qzone.reborn.feedx.viewmodel.w wVar3 = this.mViewModel;
                ProfileTimeLine timeLineDataCache2 = wVar3 != null ? wVar3.getTimeLineDataCache() : null;
                this.mTimeLineData = timeLineDataCache2;
                if (timeLineDataCache2 != null) {
                    QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = this.mTimeLineView;
                    if (qZoneHomePageTimeLineView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    } else {
                        qZoneHomePageTimeLineView = qZoneHomePageTimeLineView3;
                    }
                    qZoneHomePageTimeLineView.setData(this.mTimeLineData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.db(false);
        EventCollector.getInstance().onViewClicked(view);
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
            if (G9() != null) {
                QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = this.mTimeLineView;
                if (qZoneHomePageTimeLineView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                    qZoneHomePageTimeLineView3 = null;
                }
                qZoneHomePageTimeLineView3.startAnimation(G9());
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
        if (J9() != null) {
            QZoneHomePageTimeLineView qZoneHomePageTimeLineView6 = this.mTimeLineView;
            if (qZoneHomePageTimeLineView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
                qZoneHomePageTimeLineView6 = null;
            }
            qZoneHomePageTimeLineView6.startAnimation(J9());
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
        return "QZoneUserHomeTimeLinePart";
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

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual("Feed", event.source.getName()) && event.what == 23) {
            K9(event);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
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
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.L9(t.this, view);
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
        qZoneHomePageTimeLineView2.setTimeLineListener(H9());
        QZoneHomePageTimeLineView qZoneHomePageTimeLineView3 = this.mTimeLineView;
        if (qZoneHomePageTimeLineView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeLineView");
        } else {
            qZoneHomePageTimeLineView = qZoneHomePageTimeLineView3;
        }
        qZoneHomePageTimeLineView.setPaddingForTimeLineHeader(getActivity());
        this.mViewModel = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        registerIoc(this, gf.m.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        EventCenter.getInstance().addUIObserver(this, "Feed", 23);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.requestFocusFromTouch();
        }
    }
}
