package com.tencent.biz.qqcircle.share.part;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.XExpandableListView;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yb0.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00103\u001a\n .*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberListPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "E9", "G9", "initViewModel", "F9", "I9", "K9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Ljava/lang/String;", "getSelectType", "()Ljava/lang/String;", "selectType", "Lcom/tencent/widget/XExpandableListView;", "e", "Lcom/tencent/widget/XExpandableListView;", "listView", "Lcom/tencent/biz/qqcircle/widgets/QCircleStatusView;", "f", "Lcom/tencent/biz/qqcircle/widgets/QCircleStatusView;", "emptyView", "Lcom/tencent/biz/qqcircle/comment/at/dialog/d;", tl.h.F, "Lcom/tencent/biz/qqcircle/comment/at/dialog/d;", "adapter", "", "Lcom/tencent/biz/qcircleshadow/lib/variation/HostSelectMemberUtils$QCircleResultData;", "i", "Ljava/util/List;", "selectedList", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "selectStatusObserver", "Lzb0/a;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "D9", "()Lzb0/a;", "viewModel", "<init>", "(Ljava/lang/String;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberListPart extends u {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selectType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private XExpandableListView listView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QCircleStatusView emptyView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.qqcircle.comment.at.dialog.d adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<HostSelectMemberUtils.QCircleResultData> selectedList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Observer<UIStateData<QFSCommentAtEntity>> selectStatusObserver;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberListPart$b", "Lcom/tencent/widget/ExpandableListView$OnChildClickListener;", "Lcom/tencent/widget/ExpandableListView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "v", "", "groupPosition", "childPosition", "", "id", "", "onChildClick", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements ExpandableListView.OnChildClickListener {
        b() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(@Nullable ExpandableListView parent, @Nullable View v3, int groupPosition, int childPosition, long id5) {
            QFSCommentAtEntity qFSCommentAtEntity;
            String str;
            String str2;
            com.tencent.biz.qqcircle.comment.at.dialog.d dVar = QFSShareSelectMemberListPart.this.adapter;
            com.tencent.biz.qqcircle.comment.at.dialog.d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                dVar = null;
            }
            Object child = dVar.getChild(groupPosition, childPosition);
            if (child instanceof QFSCommentAtEntity) {
                qFSCommentAtEntity = (QFSCommentAtEntity) child;
            } else {
                qFSCommentAtEntity = null;
            }
            if (qFSCommentAtEntity != null) {
                com.tencent.biz.qqcircle.comment.at.dialog.d dVar3 = QFSShareSelectMemberListPart.this.adapter;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    dVar2 = dVar3;
                }
                boolean a16 = dVar2.a(qFSCommentAtEntity, QFSShareSelectMemberListPart.this.selectedList);
                if (a16) {
                    QFSShareSelectMemberListPart.this.D9().O1(qFSCommentAtEntity);
                } else {
                    if (QFSShareSelectMemberListPart.this.selectedList.size() >= 9) {
                        yb0.c.h(QFSShareSelectMemberListPart.this.getActivity());
                        QLog.d("QFSShareSelectMemberListPart", 1, "[initListView] max choose");
                        return true;
                    }
                    QFSShareSelectMemberListPart.this.D9().L1(qFSCommentAtEntity);
                }
                Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QQ_FRIEND);
                QCircleReportBean reportBean = QFSShareSelectMemberListPart.this.getReportBean();
                if (reportBean == null || (str = reportBean.getDtPageId()) == null) {
                    str = "";
                }
                params.put("xsj_custom_pgid", str);
                params.put("xsj_target_qq", ua0.d.f(qFSCommentAtEntity.f()) + qFSCommentAtEntity.e());
                if (!a16) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                params.put("xsj_is_tick", str2);
                VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
                return true;
            }
            return true;
        }
    }

    public QFSShareSelectMemberListPart(@NotNull String selectType) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        this.selectType = selectType;
        this.selectedList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zb0.a>() { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberListPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final zb0.a invoke() {
                return (zb0.a) QFSShareSelectMemberListPart.this.getViewModel(zb0.a.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zb0.a D9() {
        return (zb0.a) this.viewModel.getValue();
    }

    private final void E9() {
        View findViewById = getPartRootView().findViewById(R.id.f371416g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026s_empty_status_hint_view)");
        QCircleStatusView qCircleStatusView = (QCircleStatusView) findViewById;
        this.emptyView = qCircleStatusView;
        if (qCircleStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            qCircleStatusView = null;
        }
        qCircleStatusView.setVisibility(8);
    }

    private final void F9() {
        int i3;
        View findViewById = getPartRootView().findViewById(R.id.ebs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.list_view)");
        this.listView = (XExpandableListView) findViewById;
        if (Intrinsics.areEqual(this.selectType, "select_type_troops")) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar = new com.tencent.biz.qqcircle.comment.at.dialog.d(getContext(), this.selectedList, i3);
        this.adapter = dVar;
        dVar.d(Intrinsics.areEqual(this.selectType, "select_type_mutual_follow"));
        XExpandableListView xExpandableListView = this.listView;
        XExpandableListView xExpandableListView2 = null;
        if (xExpandableListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xExpandableListView = null;
        }
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar2 = this.adapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar2 = null;
        }
        xExpandableListView.setAdapter(dVar2);
        XExpandableListView xExpandableListView3 = this.listView;
        if (xExpandableListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            xExpandableListView2 = xExpandableListView3;
        }
        xExpandableListView2.setOnChildClickListener(new b());
        I9();
    }

    private final void G9() {
        if (D9().N1().isEmpty()) {
            return;
        }
        ArrayList<QFSCommentAtEntity> arrayList = new ArrayList();
        arrayList.addAll(D9().N1());
        for (QFSCommentAtEntity qFSCommentAtEntity : arrayList) {
            HostSelectMemberUtils.QCircleResultData qCircleResultData = new HostSelectMemberUtils.QCircleResultData();
            qCircleResultData.name = qFSCommentAtEntity.b();
            qCircleResultData.uin = qFSCommentAtEntity.e();
            qCircleResultData.uinType = qFSCommentAtEntity.f();
            this.selectedList.add(qCircleResultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H9(QFSShareSelectMemberListPart this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int state = uIStateData.getState();
        if (state != 6) {
            if (state == 8) {
                List<HostSelectMemberUtils.QCircleResultData> list = this$0.selectedList;
                Object data = uIStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data, "it.data");
                list.add(data);
            }
        } else {
            int size = this$0.selectedList.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (Intrinsics.areEqual(this$0.selectedList.get(i3).uin, ((QFSCommentAtEntity) uIStateData.getData()).e())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                this$0.selectedList.remove(i3);
            }
        }
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar = this$0.adapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar = null;
        }
        dVar.notifyDataSetChanged();
    }

    private final void I9() {
        p.f450005a.i(this.selectType, new Consumer() { // from class: com.tencent.biz.qqcircle.share.part.g
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QFSShareSelectMemberListPart.J9(QFSShareSelectMemberListPart.this, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QFSShareSelectMemberListPart this$0, Map groupsListMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        SparseArray<List<QFSCommentAtEntity>> sparseArray = new SparseArray<>();
        Intrinsics.checkNotNullExpressionValue(groupsListMap, "groupsListMap");
        for (Map.Entry entry : groupsListMap.entrySet()) {
            Groups groups = (Groups) entry.getKey();
            List<QFSCommentAtEntity> list = (List) entry.getValue();
            arrayList.add(groups);
            sparseArray.put(groups.group_id, list);
        }
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar = this$0.adapter;
        View view = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar = null;
        }
        dVar.c(arrayList, sparseArray);
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar2 = this$0.adapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar2 = null;
        }
        if (dVar2.getGroupCount() > 0) {
            XExpandableListView xExpandableListView = this$0.listView;
            if (xExpandableListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xExpandableListView = null;
            }
            xExpandableListView.expandGroup(0);
            XExpandableListView xExpandableListView2 = this$0.listView;
            if (xExpandableListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xExpandableListView2 = null;
            }
            xExpandableListView2.setVisibility(0);
            QCircleStatusView qCircleStatusView = this$0.emptyView;
            if (qCircleStatusView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            } else {
                view = qCircleStatusView;
            }
            view.setVisibility(8);
            return;
        }
        this$0.K9();
        XExpandableListView xExpandableListView3 = this$0.listView;
        if (xExpandableListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            view = xExpandableListView3;
        }
        view.setVisibility(8);
    }

    private final void K9() {
        String str;
        QCircleStatusView qCircleStatusView = this.emptyView;
        QCircleStatusView qCircleStatusView2 = null;
        if (qCircleStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            qCircleStatusView = null;
        }
        qCircleStatusView.setVisibility(0);
        String string = getContext().getString(R.string.f1906542o);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026forward_select_no_choice)");
        String str2 = this.selectType;
        int hashCode = str2.hashCode();
        if (hashCode != 28315162) {
            if (hashCode != 919262195) {
                if (hashCode == 984839491 && str2.equals("select_type_troops")) {
                    str = string + getContext().getString(R.string.f1906042j);
                }
                str = getContext().getString(R.string.f1921346o);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.string.qfs_no_more_hint)");
            } else {
                if (str2.equals("select_type_friends")) {
                    str = string + getContext().getString(R.string.f195634f5);
                }
                str = getContext().getString(R.string.f1921346o);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.string.qfs_no_more_hint)");
            }
        } else {
            if (str2.equals("select_type_mutual_follow")) {
                str = string + getContext().getString(R.string.f1906342m);
            }
            str = getContext().getString(R.string.f1921346o);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.string.qfs_no_more_hint)");
        }
        QCircleStatusView qCircleStatusView3 = this.emptyView;
        if (qCircleStatusView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        } else {
            qCircleStatusView2 = qCircleStatusView3;
        }
        qCircleStatusView2.z0(str, false, 16);
    }

    private final void initViewModel() {
        this.selectStatusObserver = new Observer() { // from class: com.tencent.biz.qqcircle.share.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSShareSelectMemberListPart.H9(QFSShareSelectMemberListPart.this, (UIStateData) obj);
            }
        };
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = D9().M1();
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
        return "QFSShareSelectMemberListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        E9();
        G9();
        F9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = D9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.removeObserver(observer);
    }
}
