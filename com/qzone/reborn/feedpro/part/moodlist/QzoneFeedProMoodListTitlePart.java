package com.qzone.reborn.feedpro.part.moodlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.feedpro.event.QzoneFeedProRefreshEvent;
import com.qzone.reborn.feedpro.viewmodel.QzoneFeedProMoodListViewModel;
import com.qzone.reborn.feedpro.viewmodel.b;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f` H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/feedpro/part/moodlist/QzoneFeedProMoodListTitlePart;", "Lcom/qzone/reborn/feedpro/part/b;", "Lcom/qzone/common/event/IObserver$main;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "O9", "R9", "J9", "L9", "", "elementId", "Landroid/view/View;", "view", "K9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "p4", "Lcom/qzone/common/event/Event;", "event", "onEventUIThread", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mMoodListTitle", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "mFeedDataViewModel", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTimerShuoShuoTip", "", h.F, "Z", "mIsShowTimerIcon", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMoodListTitlePart extends com.qzone.reborn.feedpro.part.b implements IObserver.main, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mMoodListTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProMoodListViewModel mFeedDataViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTimerShuoShuoTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowTimerIcon;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/part/moodlist/QzoneFeedProMoodListTitlePart$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            QzoneFeedProMoodListTitlePart.this.J9();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        String url;
        String replace$default;
        String url2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UNPUBLISH_SHUO_SHUO, QzoneConfig.SECONDARY_UNPUBLISH_SHUO_SHUO_H5_URL, QzoneConfig.DefaultValue.DEFAULT_UNPUBLISH_SHUO_SHUO_H5_URL);
        Intrinsics.checkNotNullExpressionValue(url2, "url");
        url = StringsKt__StringsJVMKt.replace$default(url2, "{hostuin}", String.valueOf(LoginData.getInstance().getUin()), false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qzoneFeedProMoodListViewModel = null;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(url, "{uin}", String.valueOf(qzoneFeedProMoodListViewModel.getMUin()), false, 4, (Object) null);
        yo.d.d(replace$default, getActivity(), null);
    }

    private final void K9(String elementId, View view) {
        fo.c.n(view, elementId);
    }

    private final void L9() {
        R9();
        if (Intrinsics.areEqual(cl.d(getContext(), "time_shuoshuo_list_tip"), "hasShow")) {
            return;
        }
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.part.moodlist.c
            @Override // java.lang.Runnable
            public final void run() {
                QzoneFeedProMoodListTitlePart.M9(QzoneFeedProMoodListTitlePart.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(final QzoneFeedProMoodListTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mTimerShuoShuoTip;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this$0.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.part.moodlist.d
            @Override // java.lang.Runnable
            public final void run() {
                QzoneFeedProMoodListTitlePart.N9(QzoneFeedProMoodListTitlePart.this);
            }
        }, 2000L);
        cl.j(this$0.getContext(), "time_shuoshuo_list_tip", "hasShow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QzoneFeedProMoodListTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mTimerShuoShuoTip;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    private final void O9() {
        EventCenter.getInstance().addObserver(this, 0, "TimerShuoShuo", 1);
        EventCenter.getInstance().addObserver(this, 0, "TimerShuoShuo", 2);
        EventCenter.getInstance().addUIObserver(this, "Feed", 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QzoneFeedProMoodListTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this$0.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qzoneFeedProMoodListViewModel = null;
        }
        qzoneFeedProMoodListViewModel.X1();
        this$0.broadcastMessage("SCROLL_TO_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9() {
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
        K9("em_qz_timing_talk", inflate);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QzoneFeedProMoodListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026istViewModel::class.java)");
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = (QzoneFeedProMoodListViewModel) viewModel;
        this.mFeedDataViewModel = qzoneFeedProMoodListViewModel;
        if (qzoneFeedProMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qzoneFeedProMoodListViewModel = null;
        }
        MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1 = qzoneFeedProMoodListViewModel.O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function1 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.part.moodlist.QzoneFeedProMoodListTitlePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                QZoneCommonTitle qZoneCommonTitle;
                b.Companion companion = com.qzone.reborn.feedpro.viewmodel.b.INSTANCE;
                if (Intrinsics.areEqual(bVar, companion.c())) {
                    QzoneFeedProMoodListTitlePart.this.p4();
                    return;
                }
                if (Intrinsics.areEqual(bVar, companion.d())) {
                    qZoneCommonTitle = QzoneFeedProMoodListTitlePart.this.mMoodListTitle;
                    if (qZoneCommonTitle == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
                        qZoneCommonTitle = null;
                    }
                    qZoneCommonTitle.g();
                }
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.part.moodlist.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProMoodListTitlePart.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProMoodListTitlePart";
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String name = event.source.getName();
        if (Intrinsics.areEqual(name, "TimerShuoShuo")) {
            Object obj = event.params;
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            QLog.i("QzoneFeedProMoodListTitlePart", 1, "[onEventUIThread] timerShuoShuoCount:" + num);
            if (event.what != 1 || num == null || num.intValue() <= 0) {
                return;
            }
            R9();
            return;
        }
        if (Intrinsics.areEqual(name, "Feed") && event.what == 35) {
            L9();
        }
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
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
        QZoneCommonTitle qZoneCommonTitle4 = this.mMoodListTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        qZoneCommonTitle2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.moodlist.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProMoodListTitlePart.Q9(QzoneFeedProMoodListTitlePart.this, view);
            }
        });
        O9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel;
        if (!(event instanceof QzoneFeedProRefreshEvent) || (qzoneFeedProMoodListViewModel = this.mFeedDataViewModel) == null) {
            return;
        }
        if (qzoneFeedProMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedDataViewModel");
            qzoneFeedProMoodListViewModel = null;
        }
        qzoneFeedProMoodListViewModel.X1();
    }

    public void p4() {
        QZoneCommonTitle qZoneCommonTitle = this.mMoodListTitle;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodListTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProRefreshEvent.class);
        return arrayListOf;
    }
}
