package com.tencent.mobileqq.richmedia.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/j;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "", "action", "", "msg", "handleBroadcastMessage", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "continuePlay", "isAutoPlayWhenVisible", "isLoopPlay", "enableDispatchFileDownloadState", "", "getMinBufferingPacketDurationMs", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "d", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "initBean", "e", "Z", "hasChangePosition", "f", "Ljava/lang/String;", "enterMediaId", tl.h.F, "isLockPlay", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends RFWLayerBasePart implements IVideoPlayStrategyProvider {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWLayerInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasChangePosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String enterMediaId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLockPlay;

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean continuePlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean enableDispatchFileDownloadState(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public long getMinBufferingPacketDurationMs(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return 0L;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object msg2) {
        if (Intrinsics.areEqual("LOCK_AUTO_PLAY", action) && (msg2 instanceof Boolean)) {
            this.isLockPlay = ((Boolean) msg2).booleanValue();
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isAutoPlayWhenVisible(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (!this.isLockPlay && !this.hasChangePosition && Intrinsics.areEqual(this.enterMediaId, mediaInfo.getMediaId())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isLoopPlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerVideoPlayStrategyProvider(rootView, this);
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) getPartHost().getHostActivity().getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        if (rFWLayerInitBean == null) {
            return;
        }
        this.initBean = rFWLayerInitBean;
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerInitBean.getRichMediaDataList();
        String str = null;
        if (richMediaDataList != null) {
            RFWLayerInitBean rFWLayerInitBean2 = this.initBean;
            if (rFWLayerInitBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
                rFWLayerInitBean2 = null;
            }
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = richMediaDataList.get(rFWLayerInitBean2.getEnterPos());
            if (rFWLayerItemMediaInfo != null) {
                str = rFWLayerItemMediaInfo.getMediaId();
            }
        }
        this.enterMediaId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        String str;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        RFWLayerItemMediaInfo selectedItemMedia = layerState.getSelectedItemMedia();
        if (selectedItemMedia != null) {
            str = selectedItemMedia.getMediaId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, this.enterMediaId)) {
            this.hasChangePosition = true;
        }
    }
}
