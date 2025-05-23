package ck2;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportProgress;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qqvideoedit.utils.QQVideoEditUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0014\u00a8\u0006\u0011"}, d2 = {"Lck2/c;", "Lck2/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "vm", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/b;", "state", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originInfo", "", "Y9", "aa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "U9", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends f {
    @Override // ck2.f
    protected void U9() {
        QQVideoEditUtil.k(getPartRootView(), R.string.f238017im);
    }

    @Override // ck2.f
    protected void Y9(@NotNull VideoExportViewModel vm5, @NotNull VideoExportProgress state, @Nullable LocalMediaInfo originInfo) {
        String str;
        View partRootView;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(state, "state");
        LocalMediaInfo localMediaInfo = state.getLocalMediaInfo();
        if (localMediaInfo != null && (str = localMediaInfo.path) != null && (partRootView = getPartRootView()) != null) {
            QQVideoEditUtil.j(partRootView, str);
        }
    }

    @Override // ck2.f
    public void aa() {
        dk2.a videoExportProgressDialog = getVideoExportProgressDialog();
        if (videoExportProgressDialog != null) {
            videoExportProgressDialog.P(R.string.f237727hu);
        }
    }

    @Override // ck2.f, com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Z9(1);
    }
}
