package com.qzone.reborn.feedx.part.moodlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedx/part/moodlist/g;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/qzone/common/event/IObserver$main;", "", "L9", "N9", "H9", "I9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "p4", "Lcom/qzone/common/business/result/QZoneResult;", "result", "i5", "Lcom/qzone/common/event/Event;", "event", "onEventUIThread", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mMoodListTitle", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "e", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "mFeedDataViewModel", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTimerShuoShuoTip", "", h.F, "Z", "mIsShowTimerIcon", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.feedx.part.g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mMoodListTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxMoodListViewModel mFeedDataViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTimerShuoShuoTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowTimerIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/part/moodlist/g$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            g.this.H9();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        String url;
        String replace$default;
        String url2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UNPUBLISH_SHUO_SHUO, QzoneConfig.SECONDARY_UNPUBLISH_SHUO_SHUO_H5_URL, QzoneConfig.DefaultValue.DEFAULT_UNPUBLISH_SHUO_SHUO_H5_URL);
        Intrinsics.checkNotNullExpressionValue(url2, "url");
        url = StringsKt__StringsJVMKt.replace$default(url2, "{hostuin}", String.valueOf(LoginData.getInstance().getUin()), false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this.mFeedDataViewModel;
        if (qZoneFeedxMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qZoneFeedxMoodListViewModel = null;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(url, "{uin}", String.valueOf(qZoneFeedxMoodListViewModel.getMUin()), false, 4, (Object) null);
        yo.d.d(replace$default, getActivity(), null);
        LpReportInfo_pf00064.allReport(630, 7, 1);
    }

    private final void I9() {
        N9();
        if (Intrinsics.areEqual(cl.d(getContext(), "time_shuoshuo_list_tip"), "hasShow")) {
            return;
        }
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.part.moodlist.e
            @Override // java.lang.Runnable
            public final void run() {
                g.J9(g.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mTimerShuoShuoTip;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this$0.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.part.moodlist.f
            @Override // java.lang.Runnable
            public final void run() {
                g.K9(g.this);
            }
        }, 2000L);
        cl.j(this$0.getContext(), "time_shuoshuo_list_tip", "hasShow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mTimerShuoShuoTip;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    private final void L9() {
        EventCenter.getInstance().addObserver(this, 0, "TimerShuoShuo", 1);
        EventCenter.getInstance().addObserver(this, 0, "TimerShuoShuo", 2);
        EventCenter.getInstance().addUIObserver(this, "Feed", 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this$0.mFeedDataViewModel;
        if (qZoneFeedxMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qZoneFeedxMoodListViewModel = null;
        }
        qZoneFeedxMoodListViewModel.P1();
        this$0.broadcastMessage("SCROLL_TO_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9() {
        if (this.mIsShowTimerIcon) {
            return;
        }
        this.mIsShowTimerIcon = true;
        QZoneCommonTitle qZoneCommonTitle = null;
        View inflate = LayoutInflater.from(getPartRootView().getContext()).inflate(R.layout.cfz, (ViewGroup) null);
        com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) inflate.findViewById(R.id.lgr), getContext().getColor(R.color.qui_common_icon_nav_secondary));
        inflate.setOnClickListener(new b());
        QZoneCommonTitle qZoneCommonTitle2 = this.mMoodListTitle;
        if (qZoneCommonTitle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
        } else {
            qZoneCommonTitle = qZoneCommonTitle2;
        }
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        qZoneCommonTitle.d(viewGroup);
        if (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, ViewUtils.dpToPx(8.0f), 0);
        }
        LpReportInfo_pf00064.allReport(630, 6, 1);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxMoodListTitlePart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i5(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QZoneCommonTitle qZoneCommonTitle = this.mMoodListTitle;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.g();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String name = event.source.getName();
        if (Intrinsics.areEqual(name, "TimerShuoShuo")) {
            Object obj = event.params;
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            QLog.i("QZoneFeedxMoodListTitlePart", 1, "[onEventUIThread] timerShuoShuoCount:" + num);
            if (event.what != 1 || num == null || num.intValue() <= 0) {
                return;
            }
            N9();
            return;
        }
        if (Intrinsics.areEqual(name, "Feed") && event.what == 35) {
            I9();
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f162837mw3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026one_feed_mood_list_title)");
        QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) findViewById;
        this.mMoodListTitle = qZoneCommonTitle;
        QZoneCommonTitle qZoneCommonTitle2 = null;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.setupTitleHeight(QZoneFeedxViewUtils.b(getActivity()));
        this.mTimerShuoShuoTip = (TextView) rootView.findViewById(R.id.mjl);
        QZoneCommonTitle qZoneCommonTitle3 = this.mMoodListTitle;
        if (qZoneCommonTitle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
            qZoneCommonTitle3 = null;
        }
        qZoneCommonTitle3.getMCenterTitle().setText(l.a(R.string.rgk));
        ViewModel viewModel = getViewModel(QZoneFeedxMoodListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFeedxM\u2026istViewModel::class.java)");
        this.mFeedDataViewModel = (QZoneFeedxMoodListViewModel) viewModel;
        QZoneCommonTitle qZoneCommonTitle4 = this.mMoodListTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        qZoneCommonTitle2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.moodlist.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.M9(g.this, view);
            }
        });
        L9();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void p4() {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this.mFeedDataViewModel;
        QZoneCommonTitle qZoneCommonTitle = null;
        if (qZoneFeedxMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qZoneFeedxMoodListViewModel = null;
        }
        if (qZoneFeedxMoodListViewModel.A2()) {
            QZoneCommonTitle qZoneCommonTitle2 = this.mMoodListTitle;
            if (qZoneCommonTitle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
            } else {
                qZoneCommonTitle = qZoneCommonTitle2;
            }
            qZoneCommonTitle.k();
        }
    }
}
