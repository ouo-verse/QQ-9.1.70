package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalPublishConfigSelectedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalPublishOnGetConfigEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishGuideHelper;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalConfigResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.util.QQToastUtil;
import g82.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ?2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001@B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u001f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/part/QQStrangerSignalPublishPickerPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBasePart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "Lg82/a;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "result", "", "R9", "P9", "Lg82/a$a;", "state", "N9", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "signalConfig", "", "J9", "", "partnerAdjId", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "O9", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "M9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "viewModel", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/view/QQStrangerSignalPickerView;", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/view/QQStrangerSignalPickerView;", "pickerView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "f", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "floatingView", h.F, "Lg82/a$a;", "lastPublishSignalInfoState", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "signalConfigResult", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isShowTotal", "Lf82/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "I9", "()Lf82/a;", "adapter", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper;", "D", "K9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper;", "guideHelper", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;)V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishPickerPart extends QQStrangerSignalBasePart<QQStrangerSignalPublishViewModel, g82.a, Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy guideHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerSignalPublishViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQStrangerSignalPickerView pickerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView floatingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a.QQStrangerUpdateLastPublishSignalInfoState lastPublishSignalInfoState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQStrangerSignalConfigResult signalConfigResult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowTotal;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/signal/publish/part/QQStrangerSignalPublishPickerPart$b", "Lcom/tencent/mobileqq/widget/qus/a;", "", "onShowTotal", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QQStrangerSignalPublishPickerPart.this.isShowTotal = true;
            QQStrangerSignalConfigResult qQStrangerSignalConfigResult = QQStrangerSignalPublishPickerPart.this.signalConfigResult;
            if (qQStrangerSignalConfigResult != null) {
                QQStrangerSignalPublishPickerPart.this.P9(qQStrangerSignalConfigResult);
            }
        }
    }

    public QQStrangerSignalPublishPickerPart(QQStrangerSignalPublishViewModel viewModel) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<f82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.QQStrangerSignalPublishPickerPart$adapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f82.a invoke() {
                return new f82.a();
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalPublishGuideHelper>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.QQStrangerSignalPublishPickerPart$guideHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalPublishGuideHelper invoke() {
                return new QQStrangerSignalPublishGuideHelper();
            }
        });
        this.guideHelper = lazy2;
    }

    private final f82.a I9() {
        return (f82.a) this.adapter.getValue();
    }

    private final int J9(SignalPB$SignalConfig signalConfig) {
        int a16 = I9().a();
        int j3 = signalConfig != null ? I9().j(signalConfig) : -1;
        if (j3 == -1) {
            return Math.max(Math.min(2, a16 - 1), 0);
        }
        return Math.max(Math.min(j3, a16 - 1), 0);
    }

    private final QQStrangerSignalPublishGuideHelper K9() {
        return (QQStrangerSignalPublishGuideHelper) this.guideHelper.getValue();
    }

    private final int L9(SignalPB$SignalConfig signalConfig, long partnerAdjId) {
        int size = signalConfig.partner_adjs.size();
        int c16 = ModelExtKt.c(signalConfig, partnerAdjId);
        if (c16 == -1) {
            return Math.max(Math.min(2, size - 1), 0);
        }
        return Math.max(Math.min(c16, size - 1), 0);
    }

    private final void N9(a.QQStrangerUpdateLastPublishSignalInfoState state) {
        QLog.i("QQStrangerSignalPublishPickerPart", 1, "handleLastPublishSignalInfoSelected state: " + state);
        SignalPB$SignalConfig l3 = I9().l(state.getPartnerId());
        int J9 = J9(l3);
        QQStrangerSignalPickerView qQStrangerSignalPickerView = this.pickerView;
        QQStrangerSignalPickerView qQStrangerSignalPickerView2 = null;
        if (qQStrangerSignalPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerView");
            qQStrangerSignalPickerView = null;
        }
        qQStrangerSignalPickerView.setFirstSelection(J9);
        if (l3 == null) {
            l3 = I9().k(J9);
        }
        if (l3 != null) {
            int L9 = L9(l3, state.getPartnerAdjId());
            QQStrangerSignalPickerView qQStrangerSignalPickerView3 = this.pickerView;
            if (qQStrangerSignalPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickerView");
            } else {
                qQStrangerSignalPickerView2 = qQStrangerSignalPickerView3;
            }
            qQStrangerSignalPickerView2.setSecondSelection(L9);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSignalPublishConfigSelectedEvent(l3, L9));
        }
        this.lastPublishSignalInfoState = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(QQStrangerSignalConfigResult result) {
        int collectionSizeOrDefault;
        if (QLog.isColorLevel()) {
            boolean z16 = this.isShowTotal;
            List<SignalPB$SignalConfig> a16 = result.a();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(ModelExtKt.y((SignalPB$SignalConfig) it.next()));
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String arrays = Arrays.toString(array);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.i("QQStrangerSignalPublishPickerPart", 2, "handleUpdateSignalConfigsSuccess isShowTotal: " + z16 + ",  configs: " + arrays);
        }
        if (this.isShowTotal) {
            I9().m(result.a());
            if (!result.a().isEmpty()) {
                QQStrangerSignalPublishGuideHelper K9 = K9();
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
                QQStrangerSignalPickerView qQStrangerSignalPickerView = null;
                if (qUSHalfScreenImmersiveFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                    qUSHalfScreenImmersiveFloatingView = null;
                }
                View x16 = qUSHalfScreenImmersiveFloatingView.x();
                ViewGroup viewGroup = x16 instanceof ViewGroup ? (ViewGroup) x16 : null;
                QQStrangerSignalPickerView qQStrangerSignalPickerView2 = this.pickerView;
                if (qQStrangerSignalPickerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickerView");
                } else {
                    qQStrangerSignalPickerView = qQStrangerSignalPickerView2;
                }
                K9.p(viewGroup, qQStrangerSignalPickerView.D0());
            }
            a.QQStrangerUpdateLastPublishSignalInfoState qQStrangerUpdateLastPublishSignalInfoState = this.lastPublishSignalInfoState;
            if (qQStrangerUpdateLastPublishSignalInfoState != null) {
                N9(qQStrangerUpdateLastPublishSignalInfoState);
            }
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSignalPublishOnGetConfigEvent(result.getSignalExpire()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQStrangerSignalPublishPickerPart this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SignalPB$SignalConfig k3 = this$0.I9().k(i3);
        if (k3 != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSignalPublishConfigSelectedEvent(k3, i16));
        }
    }

    private final void R9(QQStrangerSignalConfigResult result) {
        if (result.getIsSuccess()) {
            this.signalConfigResult = result;
            P9(result);
        } else {
            QQToastUtil.showQQToast(0, "\u83b7\u53d6\u6269\u5217\u4fe1\u53f7\u914d\u7f6e\u5931\u8d25");
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: M9, reason: from getter and merged with bridge method [inline-methods] */
    public QQStrangerSignalPublishViewModel A9() {
        return this.viewModel;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: O9, reason: merged with bridge method [inline-methods] */
    public void B9(g82.a state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof a.QQStrangerUpdateSignalConfigsState) {
            R9(((a.QQStrangerUpdateSignalConfigsState) state).getResult());
        } else if (state instanceof a.QQStrangerUpdateLastPublishSignalInfoState) {
            N9((a.QQStrangerUpdateLastPublishSignalInfoState) state);
        } else {
            super.B9(state);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ojs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.floating_view)");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = (QUSHalfScreenImmersiveFloatingView) findViewById;
        this.floatingView = qUSHalfScreenImmersiveFloatingView;
        QQStrangerSignalPickerView qQStrangerSignalPickerView = null;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView = null;
        }
        qUSHalfScreenImmersiveFloatingView.j(new b());
        View findViewById2 = rootView.findViewById(R.id.opl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026gnal_publish_picker_view)");
        QQStrangerSignalPickerView qQStrangerSignalPickerView2 = (QQStrangerSignalPickerView) findViewById2;
        this.pickerView = qQStrangerSignalPickerView2;
        if (qQStrangerSignalPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerView");
            qQStrangerSignalPickerView2 = null;
        }
        qQStrangerSignalPickerView2.setAdapter(I9());
        QQStrangerSignalPickerView qQStrangerSignalPickerView3 = this.pickerView;
        if (qQStrangerSignalPickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerView");
        } else {
            qQStrangerSignalPickerView = qQStrangerSignalPickerView3;
        }
        qQStrangerSignalPickerView.setOnItemSelectedListener(new QQStrangerSignalPickerView.c() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.c
            @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.c
            public final void onItemSelected(int i3, int i16) {
                QQStrangerSignalPublishPickerPart.Q9(QQStrangerSignalPublishPickerPart.this, i3, i16);
            }
        });
        Activity activity = getActivity();
        long j3 = -1;
        long longExtra = (activity == null || (intent2 = activity.getIntent()) == null) ? -1L : intent2.getLongExtra("key_partner_id", -1L);
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            j3 = intent.getLongExtra("key_partner_adj_id", -1L);
        }
        A9().S1();
        A9().T1(longExtra, j3);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        K9().j();
    }
}
