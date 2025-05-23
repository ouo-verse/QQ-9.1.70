package com.tencent.mobileqq.troop.homework.notice.detail.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditFoldView;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView;", "e", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView;", "mediaEditFoldView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWDetailContentPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HWMediaEditFoldView mediaEditFoldView;

    public HWDetailContentPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<HWNoticeDetailViewModel>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailContentPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailContentPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HWNoticeDetailViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (HWNoticeDetailViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HWDetailContentPart hWDetailContentPart = HWDetailContentPart.this;
                    Intent intent = hWDetailContentPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.troop.homework.notice.detail.g.c(hWDetailContentPart, intent);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HWNoticeDetailViewModel A9() {
        return (HWNoticeDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
        View findViewById = rootView.findViewById(R.id.yzw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.media_edit_fold_view)");
        HWMediaEditFoldView hWMediaEditFoldView = (HWMediaEditFoldView) findViewById;
        this.mediaEditFoldView = hWMediaEditFoldView;
        if (hWMediaEditFoldView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
            hWMediaEditFoldView = null;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f i26 = A9().i2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        hWMediaEditFoldView.setMediaEditManager(i26, lifecycleOwner);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        A9().c2(true);
        LiveData<Boolean> h26 = A9().h2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailContentPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                HWMediaEditFoldView hWMediaEditFoldView;
                HWMediaEditFoldView hWMediaEditFoldView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                HWMediaEditFoldView hWMediaEditFoldView3 = null;
                if (it.booleanValue()) {
                    hWMediaEditFoldView2 = HWDetailContentPart.this.mediaEditFoldView;
                    if (hWMediaEditFoldView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
                    } else {
                        hWMediaEditFoldView3 = hWMediaEditFoldView2;
                    }
                    hWMediaEditFoldView3.setMediaContentClose();
                    return;
                }
                hWMediaEditFoldView = HWDetailContentPart.this.mediaEditFoldView;
                if (hWMediaEditFoldView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
                } else {
                    hWMediaEditFoldView3 = hWMediaEditFoldView;
                }
                hWMediaEditFoldView3.setMediaContentExpand();
            }
        };
        h26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWDetailContentPart.B9(Function1.this, obj);
            }
        });
    }
}
