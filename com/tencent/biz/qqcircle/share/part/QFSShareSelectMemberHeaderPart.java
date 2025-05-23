package com.tencent.biz.qqcircle.share.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.share.bean.QFSShareSelectMemberInitBean;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberHeaderPart;
import com.tencent.biz.qqcircle.share.widget.QFSShareSelectMemberHeaderView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.multishare.api.IMultiShareApi;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.XExpandableListView;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.o;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002HIB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010 \u001a\u00020\bH\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J \u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\rH\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c03028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R#\u0010=\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberHeaderPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lwb0/d;", "Landroid/view/View$OnClickListener;", "", "O9", "N9", "J9", "", "uin", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentShareList", "", "Q9", "initViewModel", "itemName", "H9", "selectType", "R9", "Landroid/content/Intent;", "intent", "Lcom/tencent/biz/qqcircle/share/bean/QFSShareSelectMemberInitBean;", "K9", "Landroid/os/ResultReceiver;", "L9", "Landroid/os/Bundle;", "resultData", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "I9", "G9", "S9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "entity", "", com.tencent.luggage.wxa.c8.c.G, "isSelected", "l4", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/biz/qqcircle/share/widget/QFSShareSelectMemberHeaderView;", "d", "Lcom/tencent/biz/qqcircle/share/widget/QFSShareSelectMemberHeaderView;", "headerView", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "e", "Landroidx/lifecycle/Observer;", "selectStatusObserver", "Lzb0/a;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "M9", "()Lzb0/a;", "viewModel", tl.h.F, "Landroid/os/ResultReceiver;", "selectedMemberResultReceiver", "", "i", "Ljava/util/List;", "initSelectedUinList", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "QFSHeaderResultReceiver", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberHeaderPart extends u implements wb0.d, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QFSShareSelectMemberHeaderView headerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Observer<UIStateData<QFSCommentAtEntity>> selectStatusObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResultReceiver selectedMemberResultReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> initSelectedUinList;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberHeaderPart$QFSHeaderResultReceiver;", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberHeaderPart;", "d", "Ljava/lang/ref/WeakReference;", "headerPartWrf", "headerPart", "Landroid/os/Handler;", "handler", "<init>", "(Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberHeaderPart;Landroid/os/Handler;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class QFSHeaderResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSShareSelectMemberHeaderPart> headerPartWrf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QFSHeaderResultReceiver(@Nullable QFSShareSelectMemberHeaderPart qFSShareSelectMemberHeaderPart, @NotNull Handler handler) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.headerPartWrf = new WeakReference<>(qFSShareSelectMemberHeaderPart);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            QFSShareSelectMemberHeaderPart qFSShareSelectMemberHeaderPart = this.headerPartWrf.get();
            if (qFSShareSelectMemberHeaderPart == null) {
                QLog.d("QFSShareSelectMemberHeaderPart", 1, "[onReceiveResult] headerPart is null.");
                return;
            }
            if (resultCode != -1) {
                if (resultCode == 1000) {
                    qFSShareSelectMemberHeaderPart.G9(resultData);
                    return;
                } else {
                    if (resultCode == 1001) {
                        qFSShareSelectMemberHeaderPart.S9(resultData);
                        return;
                    }
                    return;
                }
            }
            Activity activity = qFSShareSelectMemberHeaderPart.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberHeaderPart$b", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements RecentContactListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<RecentUser> f92387b;

        b(List<RecentUser> list) {
            this.f92387b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QFSShareSelectMemberHeaderPart this$0, List headerItemInfoList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(headerItemInfoList, "$headerItemInfoList");
            this$0.initSelectedUinList.clear();
            QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView = this$0.headerView;
            if (qFSShareSelectMemberHeaderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerView");
                qFSShareSelectMemberHeaderView = null;
            }
            qFSShareSelectMemberHeaderView.setItemsListData(headerItemInfoList);
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> recentUserList) {
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            final ArrayList arrayList = new ArrayList();
            for (RecentUser recentUser : recentUserList) {
                int i3 = recentUser.type;
                if (i3 == 0 || i3 == 1 || i3 == 10008) {
                    QFSShareSelectMemberHeaderPart qFSShareSelectMemberHeaderPart = QFSShareSelectMemberHeaderPart.this;
                    String str = recentUser.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
                    List<RecentUser> recentShares = this.f92387b;
                    Intrinsics.checkNotNullExpressionValue(recentShares, "recentShares");
                    if (qFSShareSelectMemberHeaderPart.Q9(str, recentShares) || recentUser.type == 10008) {
                        QFSCommentAtEntity qFSCommentAtEntity = new QFSCommentAtEntity(recentUser.uin, null, recentUser.displayName, 0, recentUser.type);
                        qFSCommentAtEntity.j(recentUser.lastmsgtime);
                        o20.a aVar = new o20.a();
                        aVar.c(qFSCommentAtEntity);
                        aVar.d(QFSShareSelectMemberHeaderPart.this.initSelectedUinList.contains(qFSCommentAtEntity.e()));
                        arrayList.add(aVar);
                    }
                }
            }
            Handler mainHandler = QFSShareSelectMemberHeaderPart.this.getMainHandler();
            final QFSShareSelectMemberHeaderPart qFSShareSelectMemberHeaderPart2 = QFSShareSelectMemberHeaderPart.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.share.part.f
                @Override // java.lang.Runnable
                public final void run() {
                    QFSShareSelectMemberHeaderPart.b.b(QFSShareSelectMemberHeaderPart.this, arrayList);
                }
            });
        }
    }

    public QFSShareSelectMemberHeaderPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zb0.a>() { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberHeaderPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final zb0.a invoke() {
                return (zb0.a) QFSShareSelectMemberHeaderPart.this.getViewModel(zb0.a.class);
            }
        });
        this.viewModel = lazy;
        this.initSelectedUinList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(Bundle resultData) {
        QFSCommentAtEntity I9 = I9(resultData);
        if (I9 != null) {
            M9().L1(I9);
        }
    }

    private final void H9(String itemName) {
        String str;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_FUNCTION_ENTRANCE);
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null || (str = reportBean.getDtPageId()) == null) {
            str = "";
        }
        params.put("xsj_custom_pgid", str);
        params.put("xsj_item_name", itemName);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSCommentAtEntity I9(Bundle resultData) {
        if (resultData == null) {
            return null;
        }
        Parcelable parcelable = resultData.getParcelable("param_changed_item");
        if (!(parcelable instanceof QFSCommentAtEntity)) {
            return null;
        }
        return (QFSCommentAtEntity) parcelable;
    }

    private final void J9() {
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        Intrinsics.checkNotNullExpressionValue(recentForwardCache, "appRuntime.getRuntimeSer\u2026     ).recentForwardCache");
        ((IMultiShareApi) QRoute.api(IMultiShareApi.class)).getRecentUserList(yb0.j.INSTANCE.c(true), new b(recentForwardCache.getRecentList(true, true, false)));
    }

    private final QFSShareSelectMemberInitBean K9(Intent intent) {
        QFSShareSelectMemberInitBean qFSShareSelectMemberInitBean;
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QFSShareSelectMemberInitBean) {
            qFSShareSelectMemberInitBean = (QFSShareSelectMemberInitBean) serializableExtra;
        } else {
            qFSShareSelectMemberInitBean = null;
        }
        if (qFSShareSelectMemberInitBean == null) {
            return new QFSShareSelectMemberInitBean();
        }
        return qFSShareSelectMemberInitBean;
    }

    private final ResultReceiver L9() {
        if (o.Y1("qqcircle_enable_share_select_fix_leak", true)) {
            return new QFSHeaderResultReceiver(this, new Handler(Looper.getMainLooper()));
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        return new ResultReceiver(handler) { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberHeaderPart$getResultReceiver$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
            
                r2 = r1.f92388d.I9(r3);
             */
            @Override // android.os.ResultReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                QFSCommentAtEntity I9;
                zb0.a M9;
                QFSCommentAtEntity I92;
                zb0.a M92;
                if (resultCode != -1) {
                    if (resultCode == 1000) {
                        I9 = QFSShareSelectMemberHeaderPart.this.I9(resultData);
                        if (I9 != null) {
                            M9 = QFSShareSelectMemberHeaderPart.this.M9();
                            M9.L1(I9);
                            return;
                        }
                        return;
                    }
                    if (resultCode == 1001 && I92 != null) {
                        M92 = QFSShareSelectMemberHeaderPart.this.M9();
                        M92.O1(I92);
                        return;
                    }
                    return;
                }
                Activity activity = QFSShareSelectMemberHeaderPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zb0.a M9() {
        return (zb0.a) this.viewModel.getValue();
    }

    private final void N9() {
        View findViewById = getPartRootView().findViewById(R.id.ebs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.list_view)");
        XExpandableListView xExpandableListView = (XExpandableListView) findViewById;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView = new QFSShareSelectMemberHeaderView(context);
        this.headerView = qFSShareSelectMemberHeaderView;
        qFSShareSelectMemberHeaderView.setJumpClickListener(this);
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView2 = this.headerView;
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView3 = null;
        if (qFSShareSelectMemberHeaderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            qFSShareSelectMemberHeaderView2 = null;
        }
        xExpandableListView.addHeaderView(qFSShareSelectMemberHeaderView2);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView4 = this.headerView;
        if (qFSShareSelectMemberHeaderView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
        } else {
            qFSShareSelectMemberHeaderView3 = qFSShareSelectMemberHeaderView4;
        }
        g16.registerIoc(qFSShareSelectMemberHeaderView3.getShareListRecyclerView(), this, wb0.d.class);
    }

    private final void O9() {
        if (M9().N1().isEmpty()) {
            return;
        }
        ArrayList<QFSCommentAtEntity> arrayList = new ArrayList();
        arrayList.addAll(M9().N1());
        for (QFSCommentAtEntity qFSCommentAtEntity : arrayList) {
            List<String> list = this.initSelectedUinList;
            String e16 = qFSCommentAtEntity.e();
            Intrinsics.checkNotNullExpressionValue(e16, "entity.getUin()");
            list.add(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QFSShareSelectMemberHeaderPart this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int state = uIStateData.getState();
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView = null;
        if (state != 6) {
            if (state == 8) {
                QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView2 = this$0.headerView;
                if (qFSShareSelectMemberHeaderView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                } else {
                    qFSShareSelectMemberHeaderView = qFSShareSelectMemberHeaderView2;
                }
                String str = ((QFSCommentAtEntity) uIStateData.getData()).uin;
                Intrinsics.checkNotNullExpressionValue(str, "it.data.uin");
                qFSShareSelectMemberHeaderView.m0(str);
                return;
            }
            return;
        }
        QFSShareSelectMemberHeaderView qFSShareSelectMemberHeaderView3 = this$0.headerView;
        if (qFSShareSelectMemberHeaderView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
        } else {
            qFSShareSelectMemberHeaderView = qFSShareSelectMemberHeaderView3;
        }
        String str2 = ((QFSCommentAtEntity) uIStateData.getData()).uin;
        Intrinsics.checkNotNullExpressionValue(str2, "it.data.uin");
        qFSShareSelectMemberHeaderView.n0(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q9(String uin, List<RecentUser> recentShareList) {
        Iterator<RecentUser> it = recentShareList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().uin, uin)) {
                return true;
            }
        }
        return false;
    }

    private final void R9(String selectType) {
        Intent intent;
        Activity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("param_selected_item_list", bg.f302144a.n(M9().N1()));
        intent.putExtras(bundle);
        if (this.selectedMemberResultReceiver == null) {
            this.selectedMemberResultReceiver = L9();
        }
        intent.putExtra("param_select_member_activity_result_receiver", this.selectedMemberResultReceiver);
        QFSShareSelectMemberInitBean K9 = K9(intent);
        K9.setSelectType(selectType);
        com.tencent.biz.qqcircle.launcher.c.D0(getContext(), intent, K9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(Bundle resultData) {
        QFSCommentAtEntity I9 = I9(resultData);
        if (I9 != null) {
            M9().O1(I9);
        }
    }

    private final void initViewModel() {
        this.selectStatusObserver = new Observer() { // from class: com.tencent.biz.qqcircle.share.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSShareSelectMemberHeaderPart.P9(QFSShareSelectMemberHeaderPart.this, (UIStateData) obj);
            }
        };
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = M9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.observeForever(observer);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShareSelectMemberHeaderPart";
    }

    @Override // wb0.d
    public void l4(@NotNull QFSCommentAtEntity entity, int pos, boolean isSelected) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (isSelected) {
            if (M9().N1().size() >= 9) {
                yb0.c.h(getActivity());
                QLog.d("QFSShareSelectMemberHeaderPart", 1, "[initListView] max choose");
                return;
            } else {
                M9().L1(entity);
                return;
            }
        }
        M9().O1(entity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f44691pv) {
            R9("select_type_troops");
            String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1905842h);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_forward_choose_from_troops)");
            H9(a16);
        } else if (num != null && num.intValue() == R.id.f44701pw) {
            R9("select_type_mutual_follow");
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1905742g);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_forwa\u2026hoose_from_mutual_follow)");
            H9(a17);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        O9();
        N9();
        J9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = M9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.removeObserver(observer);
        this.selectedMemberResultReceiver = null;
    }
}
