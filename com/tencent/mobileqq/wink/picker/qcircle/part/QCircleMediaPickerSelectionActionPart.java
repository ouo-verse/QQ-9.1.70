package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import d93.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionActionPart;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionActionPart;", "", "X9", "", "action", "", "args", "handleBroadcastMessage", "Landroid/view/View;", "btn", "Q9", "U9", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "D", "Lkotlin/Lazy;", "ea", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "E", "da", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "", "enableVideoTemplate", "nextBtnText", "<init>", "(ZLjava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerSelectionActionPart extends UniversalMediaSelectionActionPart {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPreviewViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaPickerSelectionActionPart(boolean z16, @NotNull String nextBtnText) {
        super(z16, nextBtnText);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(nextBtnText, "nextBtnText");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionActionPart$selectedViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSelectedMediaViewModel invoke() {
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(QCircleMediaPickerSelectionActionPart.this);
                if (b16 != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
                }
                return null;
            }
        });
        this.selectedViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPreviewViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionActionPart$mediaPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkMediaPreviewViewModel invoke() {
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(com.tencent.mobileqq.wink.picker.core.ktx.a.a(QCircleMediaPickerSelectionActionPart.this));
            }
        });
        this.mediaPreviewViewModel = lazy2;
    }

    private final WinkMediaPreviewViewModel da() {
        return (WinkMediaPreviewViewModel) this.mediaPreviewViewModel.getValue();
    }

    private final WinkSelectedMediaViewModel ea() {
        return (WinkSelectedMediaViewModel) this.selectedViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final QCircleMediaPickerSelectionActionPart this$0, View view) {
        int i3;
        WinkMediaPreviewViewModel da5;
        final LocalMediaInfo curPreviewMedia;
        List<LocalMediaInfo> selectedMedia;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkSelectedMediaViewModel ea5 = this$0.ea();
        if (ea5 != null && (selectedMedia = ea5.getSelectedMedia()) != null) {
            i3 = selectedMedia.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            UniversalMediaSelectionActionPart.N9(this$0, null, 1, null);
        } else if (!FastClickUtils.isFastDoubleClick("QCircleMediaPickerSelectionActionPart") && (da5 = this$0.da()) != null && (curPreviewMedia = da5.getCurPreviewMedia()) != null) {
            c.Companion companion = d93.c.INSTANCE;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.b(context, e93.i.x(curPreviewMedia), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionActionPart$setNextBtn$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List listOf;
                    QCircleMediaPickerSelectionActionPart qCircleMediaPickerSelectionActionPart = QCircleMediaPickerSelectionActionPart.this;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(curPreviewMedia);
                    qCircleMediaPickerSelectionActionPart.M9(listOf);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(final QCircleMediaPickerSelectionActionPart this$0, View view) {
        int i3;
        WinkMediaPreviewViewModel da5;
        final LocalMediaInfo curPreviewMedia;
        List<LocalMediaInfo> selectedMedia;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkSelectedMediaViewModel ea5 = this$0.ea();
        if (ea5 != null && (selectedMedia = ea5.getSelectedMedia()) != null) {
            i3 = selectedMedia.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            UniversalMediaSelectionActionPart.P9(this$0, null, 1, null);
        } else if (!FastClickUtils.isFastDoubleClick("QCircleMediaPickerSelectionActionPart") && (da5 = this$0.da()) != null && (curPreviewMedia = da5.getCurPreviewMedia()) != null) {
            c.Companion companion = d93.c.INSTANCE;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.b(context, e93.i.x(curPreviewMedia), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionActionPart$setVideoTemplateBtn$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List listOf;
                    QCircleMediaPickerSelectionActionPart qCircleMediaPickerSelectionActionPart = QCircleMediaPickerSelectionActionPart.this;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(curPreviewMedia);
                    qCircleMediaPickerSelectionActionPart.O9(listOf);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart
    public void Q9(@NotNull View btn) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        if (f93.a.b(this)) {
            btn.setEnabled(true);
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleMediaPickerSelectionActionPart.ga(QCircleMediaPickerSelectionActionPart.this, view);
                }
            });
        } else {
            super.Q9(btn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart
    public void U9(@NotNull View btn) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        if (f93.a.b(this)) {
            btn.setEnabled(true);
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleMediaPickerSelectionActionPart.ha(QCircleMediaPickerSelectionActionPart.this, view);
                }
            });
        } else {
            super.U9(btn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart
    public void X9() {
        if (!f93.a.b(this)) {
            super.X9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "MSG_MEDIA_PREVIEW_OVERLAY_VISIBLE_CHANGED") && (args instanceof Boolean)) {
            T9(((Boolean) args).booleanValue());
        }
    }
}
