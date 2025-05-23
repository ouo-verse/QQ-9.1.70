package com.tencent.qqnt.qbasealbum.preview.customize;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.preview.view.VideoPreviewBaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/customize/BaseCustomizePreview;", "Lcom/tencent/qqnt/qbasealbum/preview/view/VideoPreviewBaseView;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/image/URLDrawableDownListener;", "listener", "", "setPreviewImageDrawable", "Lcom/tencent/qqnt/qbasealbum/preview/customize/BaseCustomizePreview$a;", "callback", IECSearchBar.METHOD_SET_CALLBACK, "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class BaseCustomizePreview extends VideoPreviewBaseView {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/customize/BaseCustomizePreview$a;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
    }

    public void setCallback(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    public void setPreviewImageDrawable(@NotNull LocalMediaInfo localMediaInfo, @Nullable URLDrawableDownListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        }
    }
}
