package com.tencent.mobileqq.flock.layer.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/layer/part/e;", "Lcom/tencent/mobileqq/flock/base/e;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "continuePlay", "isAutoPlayWhenVisible", "isLoopPlay", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends com.tencent.mobileqq.flock.base.e implements IVideoPlayStrategyProvider {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean continuePlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean enableDispatchFileDownloadState(@NotNull RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) rFWLayerItemMediaInfo)).booleanValue();
        }
        return IVideoPlayStrategyProvider.DefaultImpls.enableDispatchFileDownloadState(this, rFWLayerItemMediaInfo);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public /* synthetic */ long getMinBufferingPacketDurationMs(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        return yz3.b.a(this, rFWLayerItemMediaInfo);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isAutoPlayWhenVisible(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isLoopPlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
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
        RFWLayerIOCUtil.registerVideoPlayStrategyProvider(rootView, this);
    }
}
