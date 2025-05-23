package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.utils.j;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/z;", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewActionPart;", "Landroid/view/View;", "v", "", "K9", "", "checkAnySelection", "M9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "D9", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "i", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class z extends WinkMediaPreviewActionPart {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSelectedMediaViewModel selectedMediaViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/part/z$a", "Lcom/tencent/mobileqq/wink/utils/j$a;", "", "hasFace", "isLegal", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements j.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f325104b;

        a(View view) {
            this.f325104b = view;
        }

        @Override // com.tencent.mobileqq.wink.utils.j.a
        public void a(boolean hasFace, boolean isLegal) {
            if (hasFace && isLegal) {
                z.this.M9(this.f325104b, false);
            } else if (!hasFace) {
                QQToast.makeText(BaseApplication.getContext().getApplicationContext(), R.string.f241357rn, 0).show();
            } else {
                QQToast.makeText(BaseApplication.getContext().getApplicationContext(), R.string.f240447p7, 0).show();
            }
        }
    }

    private final void K9(final View v3) {
        final String str;
        boolean z16;
        LocalMediaInfo curPreviewMedia;
        WinkMediaPreviewViewModel mediaPreviewViewModel = getMediaPreviewViewModel();
        if (mediaPreviewViewModel != null && (curPreviewMedia = mediaPreviewViewModel.getCurPreviewMedia()) != null) {
            str = curPreviewMedia.path;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            super.D9(v3, false);
        } else {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.x
                @Override // java.lang.Runnable
                public final void run() {
                    z.L9(str, this, v3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(String str, z this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        com.tencent.mobileqq.wink.utils.j.i(str, true, new a(v3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(final View v3, final boolean checkAnySelection) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.y
            @Override // java.lang.Runnable
            public final void run() {
                z.N9(z.this, v3, checkAnySelection);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(z this$0, View v3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        super.D9(v3, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r4.getNeedFaceDetectWhenSelect() == true) goto L8;
     */
    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void D9(@NotNull View v3, boolean checkAnySelection) {
        boolean z16;
        Intrinsics.checkNotNullParameter(v3, "v");
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
        if (winkSelectedMediaViewModel != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            K9(v3);
        } else {
            super.D9(v3, false);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            this.selectedMediaViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
        }
    }
}
