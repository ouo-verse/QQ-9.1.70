package com.tencent.mobileqq.zplan.debug.recordpreview;

import android.app.Dialog;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import by4.ZPlanRecordResourceStatistic;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t74.l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$recordAndPreview$1", f = "ZPlanRecordPreviewFragment.kt", i = {}, l = {179, 203}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanRecordPreviewFragment$recordAndPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $progressDialog;
    final /* synthetic */ SingleRecordRequestParams $recordRequest;
    final /* synthetic */ int $resourceId;
    final /* synthetic */ boolean $useFilament;
    int label;
    final /* synthetic */ ZPlanRecordPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRecordPreviewFragment$recordAndPreview$1(SingleRecordRequestParams singleRecordRequestParams, ZPlanRecordPreviewFragment zPlanRecordPreviewFragment, int i3, Dialog dialog, boolean z16, Continuation<? super ZPlanRecordPreviewFragment$recordAndPreview$1> continuation) {
        super(2, continuation);
        this.$recordRequest = singleRecordRequestParams;
        this.this$0 = zPlanRecordPreviewFragment;
        this.$resourceId = i3;
        this.$progressDialog = dialog;
        this.$useFilament = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanRecordPreviewFragment$recordAndPreview$1(this.$recordRequest, this.this$0, this.$resourceId, this.$progressDialog, this.$useFilament, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<? extends Source> Lh;
        String str;
        ZPlanRecordResourceStatistic statistic;
        ZPlanRecordResourceStatistic statistic2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            SingleRecordRequestParams singleRecordRequestParams = this.$recordRequest;
            Lh = this.this$0.Lh();
            this.label = 1;
            obj = zPlanRecordResourceCenter.h(singleRecordRequestParams, Lh, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        final ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        str = this.this$0.TAG;
        QLog.i(str, 1, "record result:" + zPlanRecordResource);
        Object obj2 = null;
        Object raw = (zPlanRecordResource == null || (statistic2 = zPlanRecordResource.getStatistic()) == null) ? null : statistic2.getRaw();
        if (raw == null ? true : raw instanceof wx4.d) {
            if (zPlanRecordResource != null && (statistic = zPlanRecordResource.getStatistic()) != null) {
                obj2 = statistic.getRaw();
            }
            obj2 = (wx4.d) obj2;
        }
        final wx4.d dVar = obj2;
        if (zPlanRecordResource != null && zPlanRecordResource.o()) {
            long e16 = dVar != 0 ? dVar.e() : 0L;
            this.this$0.toast(this.$resourceId + " \u5f55\u5236\u6210\u529f, \u8017\u65f6:" + e16, 2);
            final ZPlanRecordPreviewFragment zPlanRecordPreviewFragment = this.this$0;
            final boolean z16 = this.$useFilament;
            final Dialog dialog = this.$progressDialog;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$recordAndPreview$1.2
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
                    boolean z17;
                    Button button;
                    ImageView imageView;
                    ImageView imageView2;
                    String str2;
                    TextView textView;
                    z17 = ZPlanRecordPreviewFragment.this.destroyed;
                    if (z17) {
                        return;
                    }
                    button = ZPlanRecordPreviewFragment.this.startRecordButton;
                    if (button != null) {
                        button.setClickable(true);
                    }
                    String localPath = zPlanRecordResource.getLocalPath();
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mFailedDrawable = null;
                    obtain.mUseMemoryCache = false;
                    URLDrawable fileDrawable = URLDrawable.getFileDrawable(localPath, obtain);
                    imageView = ZPlanRecordPreviewFragment.this.previewImageView;
                    if (imageView != null) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    }
                    imageView2 = ZPlanRecordPreviewFragment.this.previewImageView;
                    if (imageView2 != null) {
                        imageView2.setImageDrawable(fileDrawable);
                    }
                    wx4.d dVar2 = dVar;
                    if (dVar2 == null || dVar2.getHitCache()) {
                        str2 = "Cache";
                    } else {
                        str2 = z16 ? "Filament" : "UE";
                    }
                    textView = ZPlanRecordPreviewFragment.this.recordEngineView;
                    if (textView != null) {
                        textView.setText(str2);
                    }
                    dialog.dismiss();
                }
            };
            this.label = 2;
            if (PostUtilKt.d(function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        int errCode = dVar != 0 ? dVar.getErrCode() : -1;
        this.this$0.toast(this.$resourceId + " \u5f55\u5236\u5931\u8d25, \u9519\u8bef\u7801:" + errCode, 1);
        l lVar = l.f435563a;
        final Dialog dialog2 = this.$progressDialog;
        final ZPlanRecordPreviewFragment zPlanRecordPreviewFragment2 = this.this$0;
        lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$recordAndPreview$1.1
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
                Button button;
                dialog2.dismiss();
                button = zPlanRecordPreviewFragment2.startRecordButton;
                if (button == null) {
                    return;
                }
                button.setClickable(true);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanRecordPreviewFragment$recordAndPreview$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
