package com.tencent.mobileqq.wink.picker.core.part;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewActionPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", "", "checkAnySelection", "D9", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "d", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "seqNumberText", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "mediaPreviewConfirmBtn", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "f", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "C9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "setMediaPreviewViewModel", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;)V", "mediaPreviewViewModel", "<init>", "()V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkMediaPreviewActionPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUICheckBox seqNumberText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mediaPreviewConfirmBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMediaPreviewViewModel mediaPreviewViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(WinkMediaPreviewActionPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMediaPreviewViewModel winkMediaPreviewViewModel = this$0.mediaPreviewViewModel;
        if (winkMediaPreviewViewModel != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkMediaPreviewViewModel.P1(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(WinkMediaPreviewActionPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.D9(it, true);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: C9, reason: from getter */
    public final WinkMediaPreviewViewModel getMediaPreviewViewModel() {
        return this.mediaPreviewViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D9(@NotNull View v3, boolean checkAnySelection) {
        WinkMediaPickerChildFragment a16;
        Intrinsics.checkNotNullParameter(v3, "v");
        WinkMediaPreviewViewModel winkMediaPreviewViewModel = this.mediaPreviewViewModel;
        boolean z16 = false;
        if (winkMediaPreviewViewModel != null && !winkMediaPreviewViewModel.O1(v3, checkAnySelection)) {
            z16 = true;
        }
        if (z16 && (a16 = com.tencent.mobileqq.wink.picker.core.ktx.a.a(this)) != null) {
            a16.onBackEvent();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaPreviewActionPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        LiveData<WinkMediaPreviewViewModel.SeqNumberTextAttrs> X1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QUICheckBox qUICheckBox = (QUICheckBox) rootView.findViewById(R.id.f81964fl);
        this.seqNumberText = qUICheckBox;
        if (qUICheckBox != null) {
            qUICheckBox.setVisibility(0);
        }
        com.tencent.mobileqq.wink.picker.report.a.b(this.seqNumberText, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_BUTTON, null, null, false, 28, null);
        this.mediaPreviewConfirmBtn = (Button) rootView.findViewById(R.id.yze);
        QUICheckBox qUICheckBox2 = this.seqNumberText;
        if (qUICheckBox2 != null) {
            qUICheckBox2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkMediaPreviewActionPart.E9(WinkMediaPreviewActionPart.this, view);
                }
            });
        }
        Button button = this.mediaPreviewConfirmBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkMediaPreviewActionPart.F9(WinkMediaPreviewActionPart.this, view);
                }
            });
        }
        com.tencent.mobileqq.wink.picker.report.a.b(this.mediaPreviewConfirmBtn, "em_xsj_confirm_button", null, null, false, 28, null);
        WinkMediaPickerChildFragment a16 = com.tencent.mobileqq.wink.picker.core.ktx.a.a(this);
        if (a16 != null) {
            WinkMediaPreviewViewModel f16 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(a16);
            this.mediaPreviewViewModel = f16;
            if (f16 != null && (X1 = f16.X1()) != null) {
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit> function1 = new Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart$onInitView$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                        invoke2(seqNumberTextAttrs);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                        QUICheckBox qUICheckBox3;
                        QUICheckBox qUICheckBox4;
                        Integer intOrNull;
                        QUICheckBox qUICheckBox5;
                        QUICheckBox qUICheckBox6;
                        qUICheckBox3 = WinkMediaPreviewActionPart.this.seqNumberText;
                        if (qUICheckBox3 != null) {
                            qUICheckBox3.setChecked(seqNumberTextAttrs.getIsChecked());
                        }
                        qUICheckBox4 = WinkMediaPreviewActionPart.this.seqNumberText;
                        if (qUICheckBox4 != null) {
                            qUICheckBox4.setText(seqNumberTextAttrs.getNumberText());
                        }
                        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(seqNumberTextAttrs.getNumberText());
                        if (intOrNull != null) {
                            WinkMediaPreviewActionPart winkMediaPreviewActionPart = WinkMediaPreviewActionPart.this;
                            if (intOrNull.intValue() > 99) {
                                qUICheckBox6 = winkMediaPreviewActionPart.seqNumberText;
                                if (qUICheckBox6 != null) {
                                    qUICheckBox6.setTextSize(2, 11.0f);
                                    return;
                                }
                                return;
                            }
                            qUICheckBox5 = winkMediaPreviewActionPart.seqNumberText;
                            if (qUICheckBox5 != null) {
                                qUICheckBox5.setTextSize(2, 14.0f);
                            }
                        }
                    }
                };
                X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.ac
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkMediaPreviewActionPart.G9(Function1.this, obj);
                    }
                });
            }
        }
    }
}
