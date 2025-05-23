package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.fragment.timeline.QZAlbumxTimeLineBaseDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bp;
import nc.bq;
import nc.br;
import nc.bs;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabTimeLinePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "S9", "initData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "event", "T9", "", "beans", "curTimeLineEvent", "L9", "Lcom/qzone/reborn/albumx/qzonex/fragment/timeline/QZAlbumxTimeLineBaseDialogFragment;", "Q9", "initViewModel", "R9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnc/bp;", "d", "Lnc/bp;", "K9", "()Lnc/bp;", "mediaViewModel", "Lnc/bs;", "e", "Lnc/bs;", "timeLineViewModel", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "f", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "weakDialogFragment", "<init>", "(Lnc/bp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabTimeLinePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bp mediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private bs timeLineViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.avatar.meta.refresh.c<QZAlbumxTimeLineBaseDialogFragment> weakDialogFragment;

    public QZAlbumTabTimeLinePart(bp mediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
        this.mediaViewModel = mediaViewModel;
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
        int i3;
        bs bsVar = this.timeLineViewModel;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        wa.c cVar = bsVar.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String();
        if (cVar != null) {
            bp bpVar = this.mediaViewModel;
            if (bpVar instanceof br) {
                i3 = 2;
            } else {
                i3 = bpVar instanceof bq ? 1 : 0;
            }
            cVar.i(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(CommonStTimeLineEvent event) {
        bs bsVar = this.timeLineViewModel;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        bsVar.Z1(event);
    }

    private final void initData() {
        MutableLiveData<cb.b> R1 = this.mediaViewModel.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<cb.b, Unit> function1 = new Function1<cb.b, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabTimeLinePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cb.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cb.b bVar) {
                QZAlbumTabTimeLinePart.this.T9(bVar.getEvent());
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabTimeLinePart.M9(Function1.this, obj);
            }
        });
        MutableLiveData<UIStateData<cb.a>> W1 = this.mediaViewModel.W1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<cb.a>, Unit> function12 = new Function1<UIStateData<cb.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabTimeLinePart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<cb.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<cb.a> uIStateData) {
                bs bsVar;
                if (uIStateData == null || uIStateData.getData() == null || !(!uIStateData.getData().l().isEmpty())) {
                    return;
                }
                bsVar = QZAlbumTabTimeLinePart.this.timeLineViewModel;
                if (bsVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                    bsVar = null;
                }
                bsVar.a2(uIStateData.getData().l());
            }
        };
        W1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabTimeLinePart.N9(Function1.this, obj);
            }
        });
        bs bsVar = this.timeLineViewModel;
        bs bsVar2 = null;
        if (bsVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
            bsVar = null;
        }
        MutableLiveData<Boolean> R12 = bsVar.R1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabTimeLinePart$initData$3
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
                    cVar = QZAlbumTabTimeLinePart.this.weakDialogFragment;
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
                QZAlbumTabTimeLinePart qZAlbumTabTimeLinePart = QZAlbumTabTimeLinePart.this;
                bsVar3 = qZAlbumTabTimeLinePart.timeLineViewModel;
                if (bsVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                    bsVar3 = null;
                }
                List<CommonStTimeLineEvent> S1 = bsVar3.S1();
                bsVar4 = QZAlbumTabTimeLinePart.this.timeLineViewModel;
                if (bsVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                } else {
                    bsVar5 = bsVar4;
                }
                qZAlbumTabTimeLinePart.L9(S1, bsVar5.getCurTimelineEvent());
            }
        };
        R12.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabTimeLinePart.O9(Function1.this, obj);
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
        final Function1<za.a, Unit> function14 = new Function1<za.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabTimeLinePart$initData$4
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
            public final void invoke2(za.a it) {
                bp mediaViewModel = QZAlbumTabTimeLinePart.this.getMediaViewModel();
                if (mediaViewModel != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mediaViewModel.a2(it);
                }
            }
        };
        M1.observe(lifecycleOwner4, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabTimeLinePart.P9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bs.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxTim\u2026ineViewModel::class.java)");
        this.timeLineViewModel = (bs) viewModel;
    }

    /* renamed from: K9, reason: from getter */
    public final bp getMediaViewModel() {
        return this.mediaViewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabTimeLinePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        S9(rootView);
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
            R9();
            bs bsVar = this.timeLineViewModel;
            bs bsVar2 = null;
            if (bsVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeLineViewModel");
                bsVar = null;
            }
            bsVar.T1(this.mediaViewModel.getUin());
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

    private final void S9(View rootView) {
    }
}
