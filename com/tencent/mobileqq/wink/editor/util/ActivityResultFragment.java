package com.tencent.mobileqq.wink.editor.util;

import android.content.Intent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/ActivityResultFragment;", "Landroidx/fragment/app/Fragment;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/wink/editor/util/ActivityResultFragment$b;", "l", "ph", "qh", "Ljava/util/concurrent/CopyOnWriteArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/CopyOnWriteArrayList;", "resultListener", "<init>", "()V", "E", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ActivityResultFragment extends ReportAndroidXFragment {

    @NotNull
    public Map<Integer, View> D = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> resultListener = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&R\u0014\u0010\u0003\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/ActivityResultFragment$b;", "", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "a", "getRequestCode", "()I", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(int requestCode, int resultCode, @Nullable Intent data);

        int getRequestCode();
    }

    public void _$_clearFindViewByIdCache() {
        this.D.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Iterator<b> it = this.resultListener.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.getRequestCode() == requestCode) {
                next.a(requestCode, resultCode, data);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.resultListener.clear();
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void ph(@NotNull b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.resultListener.add(l3);
    }

    public final void qh(@NotNull b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.resultListener.remove(l3);
    }
}
