package ck2;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lck2/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "", "P9", "", "getPageId", "", "", "O1", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends com.tencent.mobileqq.qqvideoedit.editor.d {
    private final Map<String, Object> O1() {
        int i3;
        HashMap hashMap = new HashMap();
        LocalMediaInfo z95 = z9();
        int i16 = 0;
        if (z95 != null) {
            i3 = z95.mediaWidth;
        } else {
            i3 = 0;
        }
        if (z95 != null) {
            i16 = z95.mediaHeight;
        }
        hashMap.put("video_edit_import_size", i3 + "*" + i16);
        hashMap.put("type_aio_pg", Integer.valueOf(B9()));
        hashMap.put("video_edit_import_from", 2);
        return hashMap;
    }

    private final void P9() {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.i("VideoEditorFragment", 1, "reportDaTongRegister mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        String pageId = getPageId();
        VideoReport.setPageId(partRootView, pageId);
        VideoReport.setPageParams(partRootView, ek2.a.b(O1()));
        QLog.i("VideoEditorFragment", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + pageId);
    }

    private final String getPageId() {
        return "pg_video_edit";
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f1170770g;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        P9();
    }
}
