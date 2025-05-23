package com.qzone.reborn.albumx.common.part.editalbum;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditLoadingPart;", "Lcom/qzone/reborn/base/k;", "", "F9", "I9", "Landroid/app/Dialog;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "d", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "vm", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumEditLoadingPart extends k {

    /* renamed from: f, reason: collision with root package name */
    private static volatile Dialog f52446f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.c vm;

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        Dialog G9 = G9();
        if (G9.isShowing()) {
            G9.dismiss();
        }
    }

    private final Dialog G9() {
        Dialog dialog = f52446f;
        if (dialog != null) {
            return dialog;
        }
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), "\u52a0\u8f7d\u4e2d", false);
        f52446f = showLoadingDialog;
        Intrinsics.checkNotNullExpressionValue(showLoadingDialog, "showLoadingDialog(contex\u2026   loading = it\n        }");
        return showLoadingDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        Dialog G9 = G9();
        if (G9.isShowing()) {
            return;
        }
        G9.show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.c cVar = null;
        com.qzone.reborn.albumx.common.viewmodel.c te4 = ((l9.f) RFWIocAbilityProvider.g().getIocInterface(l9.f.class, rootView, null)).te();
        this.vm = te4;
        if (te4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            cVar = te4;
        }
        LiveData<Boolean> P1 = cVar.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditLoadingPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    CommonAlbumEditLoadingPart.this.I9();
                } else {
                    CommonAlbumEditLoadingPart.this.F9();
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.editalbum.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumEditLoadingPart.H9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        Dialog dialog = f52446f;
        if (dialog != null) {
            dialog.dismiss();
        }
        f52446f = null;
    }
}
