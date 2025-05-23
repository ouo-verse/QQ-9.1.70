package com.tencent.mobileqq.flock.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/base/e;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "updateLayerState", "onLayerStateUpdate", "", "z9", "x9", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class e extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerState);
        } else {
            Intrinsics.checkNotNullParameter(layerState, "layerState");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) layerState);
        } else {
            Intrinsics.checkNotNullParameter(layerState, "layerState");
            onLayerStateUpdate(layerState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int x9(@Nullable RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) layerState)).intValue();
        }
        if (layerState == null) {
            return 1;
        }
        return 1 + layerState.getSelectedPosition() + layerState.getPositionOffset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int z9(@Nullable RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layerState)).intValue();
        }
        if (layerState == null) {
            return 1;
        }
        if (layerState.getRichMediaDataList() == null) {
            return layerState.getMediaSum();
        }
        int mediaSum = layerState.getMediaSum();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        Intrinsics.checkNotNull(richMediaDataList);
        return Math.max(mediaSum, richMediaDataList.size());
    }
}
