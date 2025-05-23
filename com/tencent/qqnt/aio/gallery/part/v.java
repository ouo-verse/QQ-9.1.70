package com.tencent.qqnt.aio.gallery.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/v;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "continuePlay", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "msg", "handleBroadcastMessage", "isAutoPlayWhenVisible", "isLoopPlay", "", "getMinBufferingPacketDurationMs", "enableDispatchFileDownloadState", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "d", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "initBean", "e", "Z", "setMaxBuffering", "f", "hasChangePosition", tl.h.F, "Ljava/lang/String;", "enterMediaId", "i", "isLockPlay", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class v extends NTAIOLayerBasePart implements IVideoPlayStrategyProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWLayerInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean setMaxBuffering;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasChangePosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String enterMediaId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLockPlay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/v$a;", "", "", "AIO_LAYER_SET_MAX_BUFFERING", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.gallery.part.v$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.setMaxBuffering = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("AIO_LAYER_SET_MAX_BUFFERING", true);
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
    public boolean enableDispatchFileDownloadState(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Object extraData = mediaInfo.getExtraData();
        if (extraData instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) extraData;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem == null) {
            return false;
        }
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.b.f349994a.a(mediaInfo);
        if (a16 == null || com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue()) != 3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public long getMinBufferingPacketDurationMs(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, (Object) mediaInfo)).longValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (!this.setMaxBuffering) {
            return 0L;
        }
        Object extraData = mediaInfo.getExtraData();
        if (extraData instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) extraData;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem == null) {
            return 0L;
        }
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.b.f349994a.a(mediaInfo);
        if (a16 == null) {
            return 0L;
        }
        int a17 = com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue());
        if (a17 != 3 && a17 != 4) {
            return 0L;
        }
        return TTL.MAX_VALUE;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, msg2);
        } else if (Intrinsics.areEqual("LOCK_AUTO_PLAY", action) && (msg2 instanceof Boolean)) {
            this.isLockPlay = ((Boolean) msg2).booleanValue();
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isAutoPlayWhenVisible(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (!this.isLockPlay && !this.hasChangePosition && Intrinsics.areEqual(this.enterMediaId, mediaInfo.getMediaId())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isLoopPlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
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

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
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
