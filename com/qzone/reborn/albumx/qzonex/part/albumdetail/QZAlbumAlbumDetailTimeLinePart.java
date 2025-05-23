package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.fragment.timeline.QZAlbumxTimeLineBaseDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bs;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumAlbumDetailTimeLinePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "T9", "initData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "event", "U9", "", "beans", "curTimeLineEvent", "L9", "Lcom/qzone/reborn/albumx/qzonex/fragment/timeline/QZAlbumxTimeLineBaseDialogFragment;", "Q9", "initViewModel", "S9", "R9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnc/y;", "d", "Lnc/y;", "detailViewModel", "Lnc/bs;", "e", "Lnc/bs;", "timeLineViewModel", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "f", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "weakDialogFragment", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumAlbumDetailTimeLinePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nc.y detailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private bs timeLineViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.avatar.meta.refresh.c<QZAlbumxTimeLineBaseDialogFragment> weakDialogFragment;

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
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final QZAlbumxTimeLineBaseDialogFragment Q9() {
        com.tencent.qqnt.avatar.meta.refresh.c<QZAlbumxTimeLineBaseDialogFragment> cVar = this.weakDialogFragment;
        QZAlbumxTimeLineBaseDialogFragment qZAlbumxTimeLineBaseDialogFragment = cVar != null ? cVar.get() : null;
        if (qZAlbumxTimeLineBaseDialogFragment != null) {
            return qZAlbumxTimeLineBaseDialogFragment;
        }
        QZAlbumxTimeLineBaseDialogFragment qZAlbumxTimeLineBaseDialogFragment2 = new QZAlbumxTimeLineBaseDialogFragment();
        this.weakDialogFragment = new com.tencent.qqnt.avatar.meta.refresh.c<>(qZAlbumxTimeLineBaseDialogFragment2);
        return qZAlbumxTimeLineBaseDialogFragment2;
    }

    private final void R9() {
        String str;
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        MutableLiveData<CommonAlbumInfo> M12;
        MutableLiveData<CommonAlbumInfo> M13;
        CommonAlbumInfo value2;
        String name;
        MutableLiveData<CommonAlbumInfo> M14;
        CommonAlbumInfo value3;
        bs bsVar = this.timeLineViewModel;
        Integer num = null;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        wa.c cVar = bsVar.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String();
        cVar.i(3);
        nc.y yVar = this.detailViewModel;
        String str2 = "";
        if (yVar == null || (M14 = yVar.M1()) == null || (value3 = M14.getValue()) == null || (str = value3.getAlbumId()) == null) {
            str = "";
        }
        cVar.f(str);
        nc.y yVar2 = this.detailViewModel;
        if (yVar2 != null && (M13 = yVar2.M1()) != null && (value2 = M13.getValue()) != null && (name = value2.getName()) != null) {
            str2 = name;
        }
        cVar.g(str2);
        mc.d dVar = mc.d.f416543a;
        nc.y yVar3 = this.detailViewModel;
        cVar.j(dVar.b((yVar3 == null || (M12 = yVar3.M1()) == null) ? null : M12.getValue()));
        nc.y yVar4 = this.detailViewModel;
        if (yVar4 != null && (M1 = yVar4.M1()) != null && (value = M1.getValue()) != null && (commonAlbumAccessPermission = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) != null) {
            num = Integer.valueOf(commonAlbumAccessPermission.getPermissionType());
        }
        cVar.h(dVar.c(num));
    }

    private final void S9() {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        nc.y yVar = this.detailViewModel;
        bs bsVar = null;
        int c16 = cVar.c((yVar == null || (M1 = yVar.M1()) == null || (value = M1.getValue()) == null) ? null : Integer.valueOf(value.getQzAlbumType()));
        int i3 = 2;
        if (c16 != 2) {
            i3 = 4;
            if (c16 != 3) {
                i3 = c16 != 4 ? c16 != 5 ? 0 : 1 : 3;
            }
        }
        bs bsVar2 = this.timeLineViewModel;
        if (bsVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
        } else {
            bsVar = bsVar2;
        }
        bsVar.U1(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(CommonStTimeLineEvent event) {
        bs bsVar = this.timeLineViewModel;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        bsVar.Z1(event);
    }

    private final void initData() {
        MutableLiveData<List<CommonStTimeLineEvent>> J2;
        MutableLiveData<CommonStTimeLineEvent> x26;
        nc.y yVar = this.detailViewModel;
        if (yVar != null && (x26 = yVar.x2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<CommonStTimeLineEvent, Unit> function1 = new Function1<CommonStTimeLineEvent, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailTimeLinePart$initData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CommonStTimeLineEvent commonStTimeLineEvent) {
                    invoke2(commonStTimeLineEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CommonStTimeLineEvent commonStTimeLineEvent) {
                    bs bsVar;
                    QZAlbumAlbumDetailTimeLinePart.this.U9(commonStTimeLineEvent);
                    bsVar = QZAlbumAlbumDetailTimeLinePart.this.timeLineViewModel;
                    if (bsVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                        bsVar = null;
                    }
                    bsVar.W1();
                }
            };
            x26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumAlbumDetailTimeLinePart.M9(Function1.this, obj);
                }
            });
        }
        nc.y yVar2 = this.detailViewModel;
        if (yVar2 != null && (J2 = yVar2.J2()) != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<List<CommonStTimeLineEvent>, Unit> function12 = new Function1<List<CommonStTimeLineEvent>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailTimeLinePart$initData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<CommonStTimeLineEvent> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<CommonStTimeLineEvent> it) {
                    bs bsVar;
                    List<CommonStTimeLineEvent> list = it;
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    bsVar = QZAlbumAlbumDetailTimeLinePart.this.timeLineViewModel;
                    if (bsVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                        bsVar = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    bsVar.a2(it);
                }
            };
            J2.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumAlbumDetailTimeLinePart.N9(Function1.this, obj);
                }
            });
        }
        bs bsVar = this.timeLineViewModel;
        bs bsVar2 = null;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        MutableLiveData<Boolean> R1 = bsVar.R1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailTimeLinePart$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                com.tencent.qqnt.avatar.meta.refresh.c cVar;
                Dialog dialog;
                bs bsVar3;
                bs bsVar4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bs bsVar5 = null;
                if (!it.booleanValue()) {
                    cVar = QZAlbumAlbumDetailTimeLinePart.this.weakDialogFragment;
                    QZAlbumxTimeLineBaseDialogFragment qZAlbumxTimeLineBaseDialogFragment = cVar != null ? (QZAlbumxTimeLineBaseDialogFragment) cVar.get() : null;
                    boolean z16 = false;
                    if (qZAlbumxTimeLineBaseDialogFragment != null && (dialog = qZAlbumxTimeLineBaseDialogFragment.getDialog()) != null && dialog.isShowing()) {
                        z16 = true;
                    }
                    if (!z16 || qZAlbumxTimeLineBaseDialogFragment == null) {
                        return;
                    }
                    qZAlbumxTimeLineBaseDialogFragment.dismissAllowingStateLoss();
                    return;
                }
                QZAlbumAlbumDetailTimeLinePart qZAlbumAlbumDetailTimeLinePart = QZAlbumAlbumDetailTimeLinePart.this;
                bsVar3 = qZAlbumAlbumDetailTimeLinePart.timeLineViewModel;
                if (bsVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                    bsVar3 = null;
                }
                List<CommonStTimeLineEvent> S1 = bsVar3.S1();
                bsVar4 = QZAlbumAlbumDetailTimeLinePart.this.timeLineViewModel;
                if (bsVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                } else {
                    bsVar5 = bsVar4;
                }
                qZAlbumAlbumDetailTimeLinePart.L9(S1, bsVar5.getCurTimelineEvent());
            }
        };
        R1.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumAlbumDetailTimeLinePart.O9(Function1.this, obj);
            }
        });
        bs bsVar3 = this.timeLineViewModel;
        if (bsVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
        } else {
            bsVar2 = bsVar3;
        }
        MutableLiveData<za.a> M1 = bsVar2.M1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<za.a, Unit> function14 = new Function1<za.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailTimeLinePart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(za.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(za.a aVar) {
                nc.y yVar3;
                yVar3 = QZAlbumAlbumDetailTimeLinePart.this.detailViewModel;
                if (yVar3 != null) {
                    yVar3.Y2(1, aVar.getEvent());
                }
                QZAlbumAlbumDetailTimeLinePart.this.broadcastMessage("click_time_line_point_refresh", null);
            }
        };
        M1.observe(lifecycleOwner4, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumAlbumDetailTimeLinePart.P9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bs.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxTim\u2026ineViewModel::class.java)");
        this.timeLineViewModel = (bs) viewModel;
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        ViewModel Ne = cVar != null ? cVar.Ne() : null;
        this.detailViewModel = Ne instanceof nc.y ? (nc.y) Ne : null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumAlbumDetailTimeLinePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        T9(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QZAlbumxTimeLineBaseDialogFragment qZAlbumxTimeLineBaseDialogFragment;
        super.onPartDestroy(activity);
        com.tencent.qqnt.avatar.meta.refresh.c<QZAlbumxTimeLineBaseDialogFragment> cVar = this.weakDialogFragment;
        if (cVar != null && (qZAlbumxTimeLineBaseDialogFragment = cVar.get()) != null) {
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
            qZAlbumxTimeLineBaseDialogFragment.Ch(fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null);
        }
        this.weakDialogFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(List<CommonStTimeLineEvent> beans, CommonStTimeLineEvent curTimeLineEvent) {
        String str;
        QZAlbumxAlbumDetailInitBean mInitBean;
        if (beans != null && !beans.isEmpty()) {
            QZAlbumxTimeLineBaseDialogFragment Q9 = Q9();
            if (getActivity() == null || !(getActivity() instanceof FragmentActivity)) {
                return;
            }
            if (Q9 != null) {
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi\u2026y).supportFragmentManager");
                Q9.Fh(supportFragmentManager);
            }
            S9();
            R9();
            bs bsVar = this.timeLineViewModel;
            bs bsVar2 = null;
            if (bsVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                bsVar = null;
            }
            nc.y yVar = this.detailViewModel;
            if (yVar == null || (mInitBean = yVar.getMInitBean()) == null || (str = mInitBean.getUin()) == null) {
                str = "";
            }
            bsVar.T1(str);
            if (Q9 != null) {
                bs bsVar3 = this.timeLineViewModel;
                if (bsVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                } else {
                    bsVar2 = bsVar3;
                }
                Q9.Eh(bsVar2);
            }
            if (Q9 != null) {
                Q9.Hh(beans, curTimeLineEvent);
                return;
            }
            return;
        }
        QLog.e(getTAG(), 1, "beans is empty");
    }

    private final void T9(View rootView) {
    }
}
