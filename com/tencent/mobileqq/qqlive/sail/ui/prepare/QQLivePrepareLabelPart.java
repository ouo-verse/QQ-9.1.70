package com.tencent.mobileqq.qqlive.sail.ui.prepare;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareLabelPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "", "sa", "Lgr4/k;", "labelInfo", "Lcom/tencent/mobileqq/qqlive/room/livelabel/LabelModel;", "oa", "labelModel", "pa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "selectLabelTitleTV", "f", "selectLabelContentTv", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "na", "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "prepareViewModel", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePrepareLabelPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView selectLabelTitleTV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView selectLabelContentTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy prepareViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareLabelPart$a;", "", "", "TEXT_CHANGE_LIVE", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareLabelPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePrepareLabelPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePrepareViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareLabelPart$prepareViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareLabelPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQLivePrepareViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePrepareViewModel) QQLivePrepareLabelPart.this.getViewModel(QQLivePrepareViewModel.class) : (QQLivePrepareViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.prepareViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final QQLivePrepareViewModel na() {
        return (QQLivePrepareViewModel) this.prepareViewModel.getValue();
    }

    private final LabelModel oa(gr4.k labelInfo) {
        LabelModel labelModel = new LabelModel();
        if (labelInfo != null) {
            labelModel.thirdLabelId = labelInfo.f403137a;
            labelModel.gameId = labelInfo.f403142f;
            labelModel.secondId = labelInfo.f403143g;
            labelModel.isSelected = true;
            labelModel.title = labelInfo.f403138b;
            labelModel.iconUrl = labelInfo.f403139c;
            labelModel.isGame = false;
        }
        return labelModel;
    }

    private final gr4.k pa(LabelModel labelModel) {
        gr4.k kVar = new gr4.k();
        kVar.f403137a = labelModel.thirdLabelId;
        kVar.f403142f = labelModel.gameId;
        kVar.f403143g = labelModel.secondId;
        kVar.f403138b = labelModel.title;
        kVar.f403139c = labelModel.iconUrl;
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(QQLivePrepareLabelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void sa() {
        SelectLabelDialog selectLabelDialog = new SelectLabelDialog(1L);
        selectLabelDialog.Ch(new SelectLabelDialog.b() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.k
            @Override // com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog.b
            public final void a(LabelModel labelModel) {
                QQLivePrepareLabelPart.ta(QQLivePrepareLabelPart.this, labelModel);
            }
        });
        selectLabelDialog.Bh(oa(na().O1().getValue()));
        selectLabelDialog.show(getHostFragment().getParentFragmentManager(), "SelectLabelDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(QQLivePrepareLabelPart this$0, LabelModel labelModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (labelModel == null) {
            return;
        }
        this$0.na().O1().setValue(this$0.pa(labelModel));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.selectLabelTitleTV = (TextView) rootView.findViewById(R.id.f82284gg);
        this.selectLabelContentTv = (TextView) rootView.findViewById(R.id.f82274gf);
        rootView.findViewById(R.id.f639434w).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLivePrepareLabelPart.qa(QQLivePrepareLabelPart.this, view);
            }
        });
        MutableLiveData<gr4.k> O1 = na().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<gr4.k, Unit> function1 = new Function1<gr4.k, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareLabelPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareLabelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(gr4.k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(gr4.k kVar) {
                TextView textView;
                TextView textView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) kVar);
                    return;
                }
                textView = QQLivePrepareLabelPart.this.selectLabelTitleTV;
                if (textView != null) {
                    textView.setText("\u66f4\u6362\u76f4\u64ad\u5185\u5bb9");
                }
                textView2 = QQLivePrepareLabelPart.this.selectLabelContentTv;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(kVar != null ? kVar.f403138b : null);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePrepareLabelPart.ra(Function1.this, obj);
            }
        });
    }
}
