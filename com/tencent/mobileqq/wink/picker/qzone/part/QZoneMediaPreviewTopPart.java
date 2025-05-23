package com.tencent.mobileqq.wink.picker.qzone.part;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/QZoneMediaPreviewTopPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "d", "Landroid/view/View;", "topView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "e", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "seqNumberText", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "f", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "<init>", "()V", tl.h.F, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPreviewTopPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUICheckBox seqNumberText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMediaPreviewViewModel mediaPreviewViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(QZoneMediaPreviewTopPart this$0, View it) {
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
    public static final void D9(QZoneMediaPreviewTopPart this$0, WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.seqNumberText;
        if (qUICheckBox != null) {
            qUICheckBox.setChecked(seqNumberTextAttrs.getIsChecked());
            qUICheckBox.setText(seqNumberTextAttrs.getNumberText());
            if (seqNumberTextAttrs.getIsChecked()) {
                str = "\u5df2\u9009\u4e2d";
            } else {
                str = "\u672a\u9009\u4e2d";
            }
            qUICheckBox.setContentDescription(str);
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(seqNumberTextAttrs.getNumberText());
            if (intOrNull != null) {
                if (intOrNull.intValue() > 99) {
                    qUICheckBox.setTextSize(2, 11.0f);
                } else {
                    qUICheckBox.setTextSize(2, 14.0f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPreviewTopPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.topView = rootView.findViewById(R.id.f123477gr);
        QUICheckBox qUICheckBox = (QUICheckBox) rootView.findViewById(R.id.f81964fl);
        qUICheckBox.setVisibility(0);
        qUICheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneMediaPreviewTopPart.C9(QZoneMediaPreviewTopPart.this, view);
            }
        });
        this.seqNumberText = qUICheckBox;
        WinkMediaPickerChildFragment a16 = com.tencent.mobileqq.wink.picker.core.ktx.a.a(this);
        if (a16 != null) {
            final WinkMediaPreviewViewModel f16 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(a16);
            if (f16 != null) {
                f16.X1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.j
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZoneMediaPreviewTopPart.D9(QZoneMediaPreviewTopPart.this, (WinkMediaPreviewViewModel.SeqNumberTextAttrs) obj);
                    }
                });
                LiveData<LocalMediaInfo> U1 = f16.U1();
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<LocalMediaInfo, Unit> function1 = new Function1<LocalMediaInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewTopPart$onInitView$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LocalMediaInfo localMediaInfo) {
                        invoke2(localMediaInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LocalMediaInfo localMediaInfo) {
                        QUICheckBox qUICheckBox2;
                        QUICheckBox qUICheckBox3;
                        qUICheckBox2 = QZoneMediaPreviewTopPart.this.seqNumberText;
                        if (qUICheckBox2 != null) {
                            WinkMediaPreviewViewModel winkMediaPreviewViewModel = f16;
                            qUICheckBox3 = QZoneMediaPreviewTopPart.this.seqNumberText;
                            Intrinsics.checkNotNull(qUICheckBox3);
                            winkMediaPreviewViewModel.P1(qUICheckBox3);
                        }
                    }
                };
                U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.k
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZoneMediaPreviewTopPart.E9(Function1.this, obj);
                    }
                });
            } else {
                f16 = null;
            }
            this.mediaPreviewViewModel = f16;
        }
    }
}
