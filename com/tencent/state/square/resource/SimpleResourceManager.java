package com.tencent.state.square.resource;

import android.graphics.drawable.Drawable;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.resource.IBaseResourceManager;
import com.tencent.state.utils.DrawableUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u0010\u001a\u00020\u0006H\u0016J4\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J,\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0015J$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/resource/SimpleResourceManager;", "Lcom/tencent/state/square/resource/IBaseResourceManager;", "view", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "(Lcom/tencent/state/square/avatar/SquareAvatarView;)V", "isOccupy", "", "()Z", "setOccupy", "(Z)V", "getView", "()Lcom/tencent/state/square/avatar/SquareAvatarView;", "getFailedDrawable", "Landroid/graphics/drawable/Drawable;", "data", "Lcom/tencent/state/map/MapPlayableItem;", "isOccupied", "playAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "delay", "", "needAnim", "setAvatarResource", "isAutoPlay", "", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "listener", "showAvatar", "stop", "stopWaitForAnimationEnd", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class SimpleResourceManager implements IBaseResourceManager {
    private static final String TAG = "SimpleResourceManager";
    private boolean isOccupy;
    private final SquareAvatarView view;

    public SimpleResourceManager(SquareAvatarView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    protected final Drawable getFailedDrawable(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Square.INSTANCE.getApplication() != null) {
            return DrawableUtil.INSTANCE.getDrawable(data.getDefaultResourceId());
        }
        return null;
    }

    public final SquareAvatarView getView() {
        return this.view;
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    /* renamed from: isOccupied, reason: from getter */
    public boolean getIsOccupy() {
        return this.isOccupy;
    }

    protected final boolean isOccupy() {
        return this.isOccupy;
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public boolean playAvatar(final MapPlayableItem data, final Resource resource, final IAvatarAnimListener callback, long delay, final boolean needAnim) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (resource == null || !resource.canPlay()) {
            return false;
        }
        this.isOccupy = true;
        SquareBaseKt.getSquareThread().postOnUiDelayed(delay, new Function0<Unit>() { // from class: com.tencent.state.square.resource.SimpleResourceManager$playAvatar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SimpleResourceManager.this.getView().setAnimSource(SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(data.getDefaultResourceId())), callback, needAnim);
            }
        });
        return true;
    }

    public final void setAvatarResource(MapPlayableSource source, IAvatarAnimListener listener) {
        if (source != null) {
            this.view.setStaticSource(source, true);
            this.view.setAnimSource(source, listener, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setOccupy(boolean z16) {
        this.isOccupy = z16;
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public void showAvatar(MapPlayableItem data, Resource resource, IAvatarAnimListener callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (resource != null) {
            this.view.setStaticSource(SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(data.getDefaultResourceId())), true);
        }
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public void stop(MapPlayableItem data) {
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public void stopWaitForAnimationEnd(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public void stop() {
        this.isOccupy = false;
        this.view.stop();
    }

    @Override // com.tencent.state.square.resource.IBaseResourceManager
    public boolean setAvatarResource(MapPlayableItem data, Resource resource, boolean isAutoPlay, IAvatarAnimListener callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        showAvatar(data, resource, callback);
        if (isAutoPlay) {
            return IBaseResourceManager.DefaultImpls.playAvatar$default(this, data, resource, callback, 0L, false, 24, null);
        }
        return false;
    }

    public static /* synthetic */ void setAvatarResource$default(SimpleResourceManager simpleResourceManager, MapPlayableSource mapPlayableSource, IAvatarAnimListener iAvatarAnimListener, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                iAvatarAnimListener = null;
            }
            simpleResourceManager.setAvatarResource(mapPlayableSource, iAvatarAnimListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAvatarResource");
    }
}
