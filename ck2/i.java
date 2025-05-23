package ck2;

import android.view.View;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import ik2.GifClipData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0011"}, d2 = {"Lck2/i;", "Lcom/tencent/biz/richframework/part/PartManager;", "Lik2/d;", "data", "", "a", "", "isAdd", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "text", "b", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "host", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends PartManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull IPartHost host, @Nullable View view) {
        super(host, view);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    public final void a(@NotNull GifClipData data) {
        com.tencent.mobileqq.qqvideoedit.editor.d dVar;
        Intrinsics.checkNotNullParameter(data, "data");
        for (Part part : this.mParts.values()) {
            if (part instanceof com.tencent.mobileqq.qqvideoedit.editor.d) {
                dVar = (com.tencent.mobileqq.qqvideoedit.editor.d) part;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.I9(data);
            }
        }
    }

    public final void b(boolean isAdd, @NotNull MetaMaterial text) {
        com.tencent.mobileqq.qqvideoedit.editor.d dVar;
        Intrinsics.checkNotNullParameter(text, "text");
        for (Part part : this.mParts.values()) {
            if (part instanceof com.tencent.mobileqq.qqvideoedit.editor.d) {
                dVar = (com.tencent.mobileqq.qqvideoedit.editor.d) part;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.M9(isAdd, text);
            }
        }
    }
}
