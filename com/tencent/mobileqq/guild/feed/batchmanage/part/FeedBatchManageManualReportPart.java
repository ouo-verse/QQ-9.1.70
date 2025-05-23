package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart;
import com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.FeedBatchManageSearchPreparationViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageManualReportPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "d", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "viewDependencies", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageManualReportPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedBatchManageInteractStateViewControllerPart.b viewDependencies;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public FeedBatchManageManualReportPart(@NotNull FeedBatchManageInteractStateViewControllerPart.b viewDependencies) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        this.viewDependencies = viewDependencies;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<FeedBatchManageSearchPreparationViewModel>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageManualReportPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedBatchManageSearchPreparationViewModel invoke() {
                return (FeedBatchManageSearchPreparationViewModel) FeedBatchManageManualReportPart.this.getViewModel(FeedBatchManageSearchPreparationViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final FeedBatchManageSearchPreparationViewModel A9() {
        return (FeedBatchManageSearchPreparationViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        MutableLiveData<Integer> M1 = A9().M1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageManualReportPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                FeedBatchManageInteractStateViewControllerPart.b bVar;
                FeedBatchManageInteractStateViewControllerPart.b bVar2;
                FeedBatchManageInteractStateViewControllerPart.b bVar3;
                FeedBatchManageInteractStateViewControllerPart.b bVar4;
                if (num != null && num.intValue() == 0) {
                    bVar4 = FeedBatchManageManualReportPart.this.viewDependencies;
                    VideoReport.reportPgIn(bVar4.a());
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    bVar3 = FeedBatchManageManualReportPart.this.viewDependencies;
                    VideoReport.reportPgIn(bVar3.b());
                } else if (num != null && num.intValue() == 1) {
                    bVar2 = FeedBatchManageManualReportPart.this.viewDependencies;
                    VideoReport.reportPgOut(bVar2.a());
                } else if (num != null && num.intValue() == 3) {
                    bVar = FeedBatchManageManualReportPart.this.viewDependencies;
                    VideoReport.reportPgOut(bVar.b());
                }
            }
        };
        M1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedBatchManageManualReportPart.B9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        boolean z16;
        Integer value = A9().M1().getValue();
        boolean z17 = false;
        if ((value != null && value.intValue() == 0) || (value != null && value.intValue() == 3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            VideoReport.reportPgOut(this.viewDependencies.a());
            return;
        }
        if ((value != null && value.intValue() == 2) || (value != null && value.intValue() == 1)) {
            z17 = true;
        }
        if (z17) {
            VideoReport.reportPgOut(this.viewDependencies.b());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        boolean z16;
        Integer value = A9().M1().getValue();
        boolean z17 = false;
        if ((value != null && value.intValue() == 0) || (value != null && value.intValue() == 3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            VideoReport.reportPgIn(this.viewDependencies.a());
            return;
        }
        if ((value != null && value.intValue() == 2) || (value != null && value.intValue() == 1)) {
            z17 = true;
        }
        if (z17) {
            VideoReport.reportPgIn(this.viewDependencies.b());
        }
    }
}
