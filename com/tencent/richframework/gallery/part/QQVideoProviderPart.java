package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.video.RFWAudioFocusManager;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.biz.richframework.video.RFWPlayerManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.IVideoUIProvider;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.IPlayerManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/richframework/gallery/part/QQVideoProviderPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/video/IPlayerManager;", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoUIProvider;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getPlayScene", "", "key", "Lcom/tencent/richframework/video/IPlayer;", "obtain", "releasePlayer", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartStop", "onPartDestroy", "Landroid/graphics/drawable/Drawable;", "getPlayIconBackground", "getPlayIconDrawable", "playSceneID", "I", "getPlaySceneID", "()I", "", "playKeys", "Ljava/util/Set;", "getPlayKeys", "()Ljava/util/Set;", "<init>", "(I)V", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQVideoProviderPart extends RFWLayerBasePart implements IPlayerManager, IVideoUIProvider {

    @NotNull
    private final Set<String> playKeys;
    private final int playSceneID;

    public QQVideoProviderPart(int i3) {
        this.playSceneID = i3;
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(hashSetOf())");
        this.playKeys = synchronizedSet;
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoUIProvider
    @Nullable
    public Drawable getPlayIconBackground() {
        return AppCompatResources.getDrawable(getContext(), R.drawable.qui_media_play_view_bg);
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoUIProvider
    @Nullable
    public Drawable getPlayIconDrawable() {
        return AppCompatResources.getDrawable(getContext(), R.drawable.qui_play_filled_icon_white);
    }

    @Override // com.tencent.richframework.video.IPlayerManager
    /* renamed from: getPlayScene, reason: from getter */
    public int getPlaySceneID() {
        return this.playSceneID;
    }

    @Override // com.tencent.richframework.video.IPlayerManager
    @NotNull
    public IPlayer obtain(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.playKeys.add(key);
        RFWPlayer obtainNewPlayer = RFWPlayerManager.g().obtainNewPlayer(key);
        Intrinsics.checkNotNullExpressionValue(obtainNewPlayer, "g().obtainNewPlayer(key)");
        return obtainNewPlayer;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPlayerManager(rootView, this);
        RFWLayerIOCUtil.registerVideoUIProvider(rootView, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        RFWAudioFocusManager.g().releaseAudioFocus();
        AVBizModuleFactory.getModuleByName(Constants.Business.QQ_LAYER).asyncAbandonAVFocus();
        synchronized (this.playKeys) {
            Iterator<String> it = this.playKeys.iterator();
            while (it.hasNext()) {
                RFWPlayerManager.g().releasePlayer(it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStart(activity);
        AVBizModuleFactory.getModuleByName(Constants.Business.QQ_LAYER).asyncRequestAVFocus(null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        AVBizModuleFactory.getModuleByName(Constants.Business.QQ_LAYER).asyncAbandonAVFocus();
    }

    @Override // com.tencent.richframework.video.IPlayerManager
    public void releasePlayer(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.playKeys.remove(key);
        RFWPlayerManager.g().releasePlayer(key);
    }
}
