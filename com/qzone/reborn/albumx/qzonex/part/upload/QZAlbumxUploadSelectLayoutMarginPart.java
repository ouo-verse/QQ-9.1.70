package com.qzone.reborn.albumx.qzonex.part.upload;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/upload/QZAlbumxUploadSelectLayoutMarginPart;", "Lcom/qzone/reborn/base/k;", "", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lqc/e;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "F9", "()Lqc/e;", "vm", "Lqc/b;", "e", "E9", "()Lqc/b;", "uploadVm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadSelectLayoutMarginPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    public QZAlbumxUploadSelectLayoutMarginPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qc.e>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectLayoutMarginPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.e invoke() {
                return (qc.e) QZAlbumxUploadSelectLayoutMarginPart.this.getViewModel(qc.e.class);
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<qc.b>() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectLayoutMarginPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qc.b invoke() {
                return (qc.b) QZAlbumxUploadSelectLayoutMarginPart.this.getViewModel(qc.b.class);
            }
        });
        this.uploadVm = lazy2;
    }

    private final qc.b E9() {
        return (qc.b) this.uploadVm.getValue();
    }

    private final qc.e F9() {
        return (qc.e) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(QZAlbumxUploadSelectLayoutMarginPart this$0, CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QZAlbumxUploadSelectLayoutMarginPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
    }

    private final void I9() {
        View findViewById = getPartRootView().findViewById(R.id.f68163fa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026one_albumx_select_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        int childCount = linearLayout.getChildCount();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < childCount) {
                View childAt = linearLayout.getChildAt(i3);
                if (childAt != null && !(childAt instanceof ViewStub) && childAt.getVisibility() == 0) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z16) {
            marginLayoutParams.topMargin = ImmersiveUtils.dpToPx(16.0f);
        } else {
            marginLayoutParams.topMargin = ImmersiveUtils.dpToPx(0.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        I9();
        F9().Q1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxUploadSelectLayoutMarginPart.G9(QZAlbumxUploadSelectLayoutMarginPart.this, (CommonAlbumInfo) obj);
            }
        });
        E9().c2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxUploadSelectLayoutMarginPart.H9(QZAlbumxUploadSelectLayoutMarginPart.this, (Boolean) obj);
            }
        });
    }
}
