package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSPersonalGroupInfoInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSModifyFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.TroopItemType;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSProfileTroopViewModel;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.TroopRequestType;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R#\u0010A\u001a\n <*\u0004\u0018\u00010;0;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSTroopBindFeedPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "I9", "S9", "H9", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "Q9", "L9", "", "data", "W9", "T9", "K9", "U9", "showErrorView", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "title", "desc", "V9", "Landroid/content/Intent;", "R9", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/beans/QFSPersonalGroupInfoInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QFSPersonalGroupInfoInitBean;", "initBean", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "hintViewContainer", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "f", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "loadingView", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v;", "i", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/v;", "troopAdapter", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "confirmBtn", "", BdhLogUtil.LogTag.Tag_Conn, "J", "originSelectedTroopId", "D", "selectedTroopId", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSProfileTroopViewModel;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSProfileTroopViewModel;", "viewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSTroopBindFeedPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: C, reason: from kotlin metadata */
    private long originSelectedTroopId;

    /* renamed from: D, reason: from kotlin metadata */
    private long selectedTroopId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPersonalGroupInfoInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout hintViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCirclePanelLoadingView loadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recycleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.adapter.v troopAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton confirmBtn;

    public QFSTroopBindFeedPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSProfileTroopViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSTroopBindFeedPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSProfileTroopViewModel invoke() {
                return (QFSProfileTroopViewModel) QFSTroopBindFeedPart.this.getViewModel(QFSProfileTroopViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final void H9() {
        QFSTroopItemInfo k06;
        QUIButton qUIButton = this.confirmBtn;
        if (qUIButton != null) {
            VideoReport.setElementId(qUIButton, QCircleDaTongConstant.ElementId.EM_XSJ_JOIN_GROUP_BUTTON);
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
            if (vVar != null && (k06 = vVar.k0(this.originSelectedTroopId)) != null && k06.getType() == TroopItemType.DATA) {
                Intrinsics.checkNotNullExpressionValue(map, "map");
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID, Long.valueOf(k06.getId()));
            }
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put("xsj_button_text", qUIButton.getText());
            VideoReport.setElementExposePolicy(qUIButton, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(qUIButton, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("imp", qUIButton, map);
        }
    }

    private final void I9() {
        QFSTroopItemInfo k06;
        S9();
        if (this.originSelectedTroopId == this.selectedTroopId) {
            QLog.d("QFSTroopBindFeedPart", 1, "[doChangeTroopBind] no change, ignore");
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = this.initBean;
        boolean z16 = false;
        if (qFSPersonalGroupInfoInitBean != null && qFSPersonalGroupInfoInitBean.isSelectWhenClick()) {
            z16 = true;
        }
        if (z16) {
            Intent R9 = R9();
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(-1, R9);
            }
            Activity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
        Unit unit = null;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        unit = null;
        if (vVar != null && (k06 = vVar.k0(this.selectedTroopId)) != null) {
            QFSProfileTroopViewModel J9 = J9();
            TroopRequestType troopRequestType = TroopRequestType.TYPE_FEED;
            QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean2 = this.initBean;
            if (qFSPersonalGroupInfoInitBean2 != null) {
                feedCloudMeta$StFeed = qFSPersonalGroupInfoInitBean2.getFeed();
            }
            J9.Z1(k06, troopRequestType, feedCloudMeta$StFeed);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("QFSTroopBindFeedPart", 1, "[doChangeTroopBind] invalid selectedTroopId: " + this.selectedTroopId);
        }
    }

    private final QFSProfileTroopViewModel J9() {
        return (QFSProfileTroopViewModel) this.viewModel.getValue();
    }

    private final void K9() {
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean;
        Intent intent = getActivity().getIntent();
        long j3 = 0;
        if (intent != null) {
            if (intent.hasExtra("key_bundle_common_init_bean")) {
                Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
                if (serializableExtra instanceof QFSPersonalGroupInfoInitBean) {
                    qFSPersonalGroupInfoInitBean = (QFSPersonalGroupInfoInitBean) serializableExtra;
                } else {
                    qFSPersonalGroupInfoInitBean = null;
                }
                this.initBean = qFSPersonalGroupInfoInitBean;
            } else if (intent.hasExtra("uin")) {
                QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean2 = new QFSPersonalGroupInfoInitBean();
                qFSPersonalGroupInfoInitBean2.setSelectWhenClick(true);
                qFSPersonalGroupInfoInitBean2.setHostUin(intent.getStringExtra("uin"));
                qFSPersonalGroupInfoInitBean2.setSelectGroupId(intent.getLongExtra("troop_id", 0L));
                this.initBean = qFSPersonalGroupInfoInitBean2;
            }
        }
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean3 = this.initBean;
        if (qFSPersonalGroupInfoInitBean3 != null) {
            j3 = qFSPersonalGroupInfoInitBean3.getSelectGroupId();
        }
        this.originSelectedTroopId = j3;
        this.selectedTroopId = j3;
        QLog.d("QFSTroopBindFeedPart", 1, "[initInitBean] selectedTroopId=" + j3);
    }

    private final void L9() {
        LiveData<UIStateData<List<QFSTroopItemInfo>>> g26 = J9().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends QFSTroopItemInfo>>, Unit> function1 = new Function1<UIStateData<List<? extends QFSTroopItemInfo>>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSTroopBindFeedPart$initObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends QFSTroopItemInfo>> uIStateData) {
                invoke2((UIStateData<List<QFSTroopItemInfo>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<QFSTroopItemInfo>> uIStateData) {
                QCirclePanelLoadingView qCirclePanelLoadingView;
                int state = uIStateData.getState();
                if (state == 0) {
                    QFSTroopBindFeedPart.this.U9();
                    return;
                }
                if (state == 1) {
                    qCirclePanelLoadingView = QFSTroopBindFeedPart.this.loadingView;
                    if (qCirclePanelLoadingView != null) {
                        qCirclePanelLoadingView.n0();
                        return;
                    }
                    return;
                }
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                    QFSTroopBindFeedPart.this.showErrorView();
                } else {
                    QFSTroopBindFeedPart qFSTroopBindFeedPart = QFSTroopBindFeedPart.this;
                    List<QFSTroopItemInfo> data = uIStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "uiState.data");
                    qFSTroopBindFeedPart.W9(data);
                }
            }
        };
        g26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSTroopBindFeedPart.N9(Function1.this, obj);
            }
        });
        LiveData<Pair<String, QFSTroopItemInfo>> e26 = J9().e2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends String, ? extends QFSTroopItemInfo>, Unit> function12 = new Function1<Pair<? extends String, ? extends QFSTroopItemInfo>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSTroopBindFeedPart$initObservers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends QFSTroopItemInfo> pair) {
                invoke2((Pair<String, QFSTroopItemInfo>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, QFSTroopItemInfo> pair) {
                boolean isBlank;
                String first = pair.getFirst();
                QLog.d("QFSTroopBindFeedPart", 1, "[initObservers] errMsg=" + first);
                isBlank = StringsKt__StringsJVMKt.isBlank(first);
                if (!isBlank) {
                    QCircleToast.v(QCircleToast.f91645e, "\u7ed1\u5b9a\u5931\u8d25", 0);
                    return;
                }
                QQToastUtil.showQQToast(2, R.string.f188433wo);
                QFSTroopBindFeedPart.this.O9(pair.getSecond());
                Activity activity = QFSTroopBindFeedPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        };
        e26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSTroopBindFeedPart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(QFSTroopItemInfo info) {
        String str;
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = this.initBean;
        if (qFSPersonalGroupInfoInitBean != null) {
            str = qFSPersonalGroupInfoInitBean.getFeedId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QLog.d("QFSTroopBindFeedPart", 1, "[notifyFeed] feedId=" + str + ", troopId=" + info.getId());
        SimpleEventBus.getInstance().dispatchEvent(new QFSModifyFeedEvent(str, info.getName(), info.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QFSTroopBindFeedPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(QFSTroopItemInfo info) {
        QFSTroopItemInfo k06;
        if (info.getId() == this.selectedTroopId) {
            QLog.d("QFSTroopBindFeedPart", 1, "[onItemClick] same id, ignore");
            return;
        }
        if (info.getIsFull()) {
            QLog.d("QFSTroopBindFeedPart", 1, "[onItemClick] troop is full");
            QCircleToast.v(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f188403wl), 0);
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
        if (vVar != null && (k06 = vVar.k0(this.selectedTroopId)) != null) {
            k06.o(false);
            com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar2 = this.troopAdapter;
            if (vVar2 != null) {
                vVar2.o0(k06);
            }
        }
        info.o(true);
        this.selectedTroopId = info.getId();
        com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar3 = this.troopAdapter;
        if (vVar3 != null) {
            vVar3.o0(info);
        }
    }

    private final Intent R9() {
        QFSTroopItemInfo qFSTroopItemInfo;
        long j3;
        String str;
        String headUrl;
        Intent intent = new Intent();
        com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
        if (vVar != null) {
            qFSTroopItemInfo = vVar.k0(this.selectedTroopId);
        } else {
            qFSTroopItemInfo = null;
        }
        if (qFSTroopItemInfo != null) {
            j3 = qFSTroopItemInfo.getId();
        } else {
            j3 = 0;
        }
        intent.putExtra("troop_id", j3);
        String str2 = "";
        if (qFSTroopItemInfo == null || (str = qFSTroopItemInfo.getName()) == null) {
            str = "";
        }
        intent.putExtra("troop_name", str);
        if (qFSTroopItemInfo != null && (headUrl = qFSTroopItemInfo.getHeadUrl()) != null) {
            str2 = headUrl;
        }
        intent.putExtra("troop_avatar_url", str2);
        return intent;
    }

    private final void S9() {
        QFSTroopItemInfo k06;
        QUIButton qUIButton = this.confirmBtn;
        if (qUIButton != null) {
            VideoReport.setElementId(qUIButton, QCircleDaTongConstant.ElementId.EM_XSJ_JOIN_GROUP_BUTTON);
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
            if (vVar != null && (k06 = vVar.k0(this.selectedTroopId)) != null && k06.getType() == TroopItemType.DATA) {
                Intrinsics.checkNotNullExpressionValue(map, "map");
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID, Long.valueOf(k06.getId()));
            }
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put("xsj_button_text", qUIButton.getText());
            VideoReport.reportEvent("clck", qUIButton, map);
        }
    }

    private final void T9() {
        String str;
        String str2;
        FeedCloudMeta$StFeed feed;
        PBStringField pBStringField;
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = this.initBean;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (qFSPersonalGroupInfoInitBean != null) {
            str = qFSPersonalGroupInfoInitBean.getHostUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean2 = this.initBean;
        if (qFSPersonalGroupInfoInitBean2 != null && (feed = qFSPersonalGroupInfoInitBean2.getFeed()) != null && (pBStringField = feed.f398449id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        QLog.d("QFSTroopBindFeedPart", 1, "[requestData] uin=" + str + ", feedId=" + str2);
        QFSProfileTroopViewModel J9 = J9();
        TroopRequestType troopRequestType = TroopRequestType.TYPE_FEED;
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean3 = this.initBean;
        if (qFSPersonalGroupInfoInitBean3 != null) {
            feedCloudMeta$StFeed = qFSPersonalGroupInfoInitBean3.getFeed();
        }
        J9.c2(str, troopRequestType, feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9() {
        String title = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928248j);
        String desc = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928348k);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        V9(16, title, desc);
        QUIButton qUIButton = this.confirmBtn;
        if (qUIButton != null) {
            qUIButton.setVisibility(8);
        }
    }

    private final void V9(int imageType, String title, String desc) {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.loadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(imageType).setTitle(title).setDesc(desc).setBackgroundColorType(0).build();
        FrameLayout frameLayout = this.hintViewContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(build);
            frameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(List<QFSTroopItemInfo> data) {
        Object obj;
        boolean z16;
        QLog.d("QFSTroopBindFeedPart", 1, "[showTroops] size=" + data.size());
        QCirclePanelLoadingView qCirclePanelLoadingView = this.loadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        FrameLayout frameLayout = this.hintViewContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        QUIButton qUIButton = this.confirmBtn;
        if (qUIButton != null) {
            qUIButton.setVisibility(0);
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((QFSTroopItemInfo) obj).getId() == this.selectedTroopId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) obj;
        if (qFSTroopItemInfo != null) {
            qFSTroopItemInfo.o(true);
        }
        com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = this.troopAdapter;
        if (vVar != null) {
            vVar.setData(data);
        }
        H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorView() {
        String str;
        String str2;
        String[] f16 = cu.f(com.tencent.biz.qqcircle.utils.h.a(R.string.f184063kv), "\n");
        if (f16.length >= 2) {
            str = f16[0];
            Intrinsics.checkNotNullExpressionValue(str, "splitMsg[0]");
            str2 = f16[1];
            Intrinsics.checkNotNullExpressionValue(str2, "splitMsg[1]");
        } else {
            str = "\u65e0\u6cd5\u8fde\u63a5\u77ed\u89c6\u9891";
            str2 = "\u68c0\u67e5\u4e00\u4e0b\u7f51\u7edc\u518d\u8bd5\u5427";
        }
        V9(13, str, str2);
        QUIButton qUIButton = this.confirmBtn;
        if (qUIButton != null) {
            qUIButton.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUIButton qUIButton;
        FrameLayout frameLayout;
        QCirclePanelLoadingView qCirclePanelLoadingView;
        super.onInitView(rootView);
        RecyclerView recyclerView = null;
        if (rootView != null) {
            qUIButton = (QUIButton) rootView.findViewById(R.id.f487620v);
        } else {
            qUIButton = null;
        }
        this.confirmBtn = qUIButton;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.aw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSTroopBindFeedPart.P9(QFSTroopBindFeedPart.this, view);
                }
            });
        }
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f487720w);
        } else {
            frameLayout = null;
        }
        this.hintViewContainer = frameLayout;
        if (rootView != null) {
            qCirclePanelLoadingView = (QCirclePanelLoadingView) rootView.findViewById(R.id.f487920y);
        } else {
            qCirclePanelLoadingView = null;
        }
        this.loadingView = qCirclePanelLoadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918345v));
        }
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f4849205);
        }
        this.recycleView = recyclerView;
        if (recyclerView != null) {
            com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.v();
            this.troopAdapter = vVar;
            vVar.setHasStableIds(true);
            com.tencent.biz.qqcircle.immersive.personal.adapter.v vVar2 = this.troopAdapter;
            if (vVar2 != null) {
                vVar2.n0(new QFSTroopBindFeedPart$onInitView$2$1(this));
            }
            recyclerView.setAdapter(this.troopAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        K9();
        L9();
        T9();
    }
}
