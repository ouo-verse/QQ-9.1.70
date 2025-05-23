package com.tencent.state.square.resource;

import android.os.Handler;
import android.os.Looper;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.resource.SquareResourceManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002)*B\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000e\u0012\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0012J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016J4\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0016J\"\u0010\"\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010$\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u001a\u0010&\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/resource/SquareResourceManager;", "Lcom/tencent/state/square/resource/SimpleResourceManager;", "Lcom/tencent/state/square/resource/IResourceManager;", "view", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "onUpdateFilament", "Lkotlin/Function2;", "Lcom/tencent/state/map/MapPlayableItem;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "", "onPlayFilament", "onStopFilament", "", HippyQQPagView.EventName.ON_PLAY_END, "Lkotlin/Function1;", "recorder", "Lcom/tencent/state/square/data/Resource;", "Lcom/tencent/state/square/resource/IResourceCallback;", "(Lcom/tencent/state/square/avatar/SquareAvatarView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "changeSource", "data", "resource", "callback", "onRecycled", "playAvatar", "delay", "", "needAnim", "setAvatarResource", "isAutoPlay", "showAvatar", "showFailedDefaultAvatar", "startRecord", "stop", "stopWaitForAnimationEnd", "AvatarViewListener", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareResourceManager extends SimpleResourceManager implements IResourceManager {
    private static final String TAG = "SquareResourceManager";

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private final Lazy handler;
    private final Function1<MapPlayableItem, Unit> onPlayEnd;
    private final Function2<MapPlayableItem, IAvatarAnimListener, Unit> onPlayFilament;
    private final Function2<MapPlayableItem, Boolean, Unit> onStopFilament;
    private final Function2<MapPlayableItem, IAvatarAnimListener, Unit> onUpdateFilament;
    private final Function2<Resource, IResourceCallback, Unit> recorder;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/resource/SquareResourceManager$AvatarViewListener;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "data", "Lcom/tencent/state/map/MapPlayableItem;", "callback", "(Lcom/tencent/state/square/resource/SquareResourceManager;Lcom/tencent/state/map/MapPlayableItem;Lcom/tencent/state/square/avatar/IAvatarAnimListener;)V", "onFirstFrame", "", HippyQQPagView.EventName.ON_PLAY_END, "onPlayError", "errorCode", "", HippyQQPagView.EventName.ON_PLAY_START, "onRemovedListener", "onStaticFailed", "onStaticSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class AvatarViewListener implements IAvatarAnimListener {
        private final IAvatarAnimListener callback;
        private final MapPlayableItem data;
        final /* synthetic */ SquareResourceManager this$0;

        public AvatarViewListener(SquareResourceManager squareResourceManager, MapPlayableItem data, IAvatarAnimListener iAvatarAnimListener) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.this$0 = squareResourceManager;
            this.data = data;
            this.callback = iAvatarAnimListener;
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onFirstFrame() {
            ResourceIdentify dynamic;
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("url=");
            Resource userResource = this.data.getUserResource();
            sb5.append((userResource == null || (dynamic = userResource.getDynamic()) == null) ? null : dynamic.getUrl());
            squareLog.i(SquareResourceManager.TAG, sb5.toString());
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onFirstFrame();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayEnd() {
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onPlayEnd: ");
                sb5.append(this.data.getTroopName());
                sb5.append(", actionId=");
                Resource userResource = this.data.getUserResource();
                sb5.append(userResource != null ? Integer.valueOf(userResource.getActionId()) : null);
                squareLog.i(SquareResourceManager.TAG, sb5.toString());
            }
            this.this$0.setOccupy(false);
            this.this$0.onPlayEnd.invoke(this.data);
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayEnd();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayError(int errorCode) {
            ResourceIdentify dynamic;
            this.this$0.setOccupy(false);
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" url=");
            Resource userResource = this.data.getUserResource();
            sb5.append((userResource == null || (dynamic = userResource.getDynamic()) == null) ? null : dynamic.getUrl());
            squareLog.i(SquareResourceManager.TAG, sb5.toString());
            this.this$0.onPlayEnd.invoke(this.data);
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayError(errorCode);
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayStart() {
            ResourceIdentify dynamic;
            ResourceIdentify resourceIdentify;
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onPlayStart: ");
                sb5.append(this.data.getUin());
                sb5.append(", staticUrl=");
                Resource userResource = this.data.getUserResource();
                String str = null;
                sb5.append((userResource == null || (resourceIdentify = userResource.getStatic()) == null) ? null : resourceIdentify.getUrl());
                sb5.append(", ");
                sb5.append("dynamicUrl=");
                Resource userResource2 = this.data.getUserResource();
                if (userResource2 != null && (dynamic = userResource2.getDynamic()) != null) {
                    str = dynamic.getUrl();
                }
                sb5.append(str);
                squareLog.i(SquareResourceManager.TAG, sb5.toString());
            }
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayStart();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onRemovedListener() {
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onRemovedListener();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticFailed() {
            ResourceIdentify resourceIdentify;
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("url=");
            Resource userResource = this.data.getUserResource();
            sb5.append((userResource == null || (resourceIdentify = userResource.getStatic()) == null) ? null : resourceIdentify.getUrl());
            squareLog.i(SquareResourceManager.TAG, sb5.toString());
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onStaticFailed();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticSuccess() {
            IAvatarAnimListener iAvatarAnimListener = this.callback;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onStaticSuccess();
            }
        }
    }

    public /* synthetic */ SquareResourceManager(SquareAvatarView squareAvatarView, Function2 function2, Function2 function22, Function2 function23, Function1 function1, Function2 function24, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(squareAvatarView, function2, function22, function23, function1, (i3 & 32) != 0 ? null : function24);
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    private final void showFailedDefaultAvatar(MapPlayableItem data) {
        getView().setStaticSource(null, true);
    }

    @Override // com.tencent.state.square.resource.IResourceManager
    public void changeSource(MapPlayableItem data, Resource resource, IAvatarAnimListener callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resource, "resource");
        IAvatarAnimView.DefaultImpls.changeSourceWithAnim$default(getView(), SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(data.getDefaultResourceId())), new AvatarViewListener(this, data, callback), false, 4, null);
        this.onUpdateFilament.invoke(data, callback);
    }

    @Override // com.tencent.state.square.resource.SimpleResourceManager, com.tencent.state.square.resource.IBaseResourceManager
    public boolean playAvatar(final MapPlayableItem data, final Resource resource, final IAvatarAnimListener callback, long delay, final boolean needAnim) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (resource != null && resource.canPlay()) {
            setOccupy(true);
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().i(TAG, '(' + data.getTroopName() + ") playAvatar delay=" + delay);
            }
            getHandler().postDelayed(new Runnable() { // from class: com.tencent.state.square.resource.SquareResourceManager$playAvatar$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function2 function2;
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().i("SquareResourceManager", '(' + data.getTroopName() + ") playAvatar setAnimSource");
                    }
                    function2 = SquareResourceManager.this.onPlayFilament;
                    MapPlayableItem mapPlayableItem = data;
                    function2.invoke(mapPlayableItem, new SquareResourceManager.AvatarViewListener(SquareResourceManager.this, mapPlayableItem, callback));
                    SquareResourceManager.this.getView().setAnimSource(SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(data.getDefaultResourceId())), new SquareResourceManager.AvatarViewListener(SquareResourceManager.this, data, callback), needAnim);
                }
            }, delay);
            return true;
        }
        showFailedDefaultAvatar(data);
        return false;
    }

    @Override // com.tencent.state.square.resource.IResourceManager
    public void setAvatarResource(MapPlayableItem data, boolean isAutoPlay, IResourceCallback callback) {
        Function2<Resource, IResourceCallback, Unit> function2;
        Intrinsics.checkNotNullParameter(data, "data");
        Resource userResource = data.getUserResource();
        setAvatarResource(data, userResource, isAutoPlay, callback);
        Resource userResource2 = data.getUserResource();
        if (userResource2 == null || !userResource2.canPlay()) {
            stop(data);
        } else if (isAutoPlay) {
            this.onPlayFilament.invoke(data, callback);
        } else {
            this.onUpdateFilament.invoke(data, callback);
        }
        if (userResource == null || !userResource.getIsDefault() || !data.isMe() || (function2 = this.recorder) == null) {
            return;
        }
        function2.invoke(userResource, callback);
    }

    @Override // com.tencent.state.square.resource.SimpleResourceManager, com.tencent.state.square.resource.IBaseResourceManager
    public void showAvatar(MapPlayableItem data, Resource resource, IAvatarAnimListener callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        getView().setStaticSource(resource != null ? SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(data.getDefaultResourceId())) : null, true);
    }

    @Override // com.tencent.state.square.resource.IResourceManager
    public void startRecord(MapPlayableItem data, IResourceCallback callback) {
        Function2<Resource, IResourceCallback, Unit> function2;
        Intrinsics.checkNotNullParameter(data, "data");
        Resource userResource = data.getUserResource();
        if (userResource == null || (function2 = this.recorder) == null) {
            return;
        }
        function2.invoke(userResource, callback);
    }

    @Override // com.tencent.state.square.resource.SimpleResourceManager, com.tencent.state.square.resource.IBaseResourceManager
    public void stopWaitForAnimationEnd(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.onStopFilament.invoke(data, Boolean.TRUE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SquareResourceManager(SquareAvatarView view, Function2<? super MapPlayableItem, ? super IAvatarAnimListener, Unit> onUpdateFilament, Function2<? super MapPlayableItem, ? super IAvatarAnimListener, Unit> onPlayFilament, Function2<? super MapPlayableItem, ? super Boolean, Unit> onStopFilament, Function1<? super MapPlayableItem, Unit> onPlayEnd, Function2<? super Resource, ? super IResourceCallback, Unit> function2) {
        super(view);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onUpdateFilament, "onUpdateFilament");
        Intrinsics.checkNotNullParameter(onPlayFilament, "onPlayFilament");
        Intrinsics.checkNotNullParameter(onStopFilament, "onStopFilament");
        Intrinsics.checkNotNullParameter(onPlayEnd, "onPlayEnd");
        this.onUpdateFilament = onUpdateFilament;
        this.onPlayFilament = onPlayFilament;
        this.onStopFilament = onStopFilament;
        this.onPlayEnd = onPlayEnd;
        this.recorder = function2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.state.square.resource.SquareResourceManager$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.handler = lazy;
    }

    @Override // com.tencent.state.square.resource.IResourceManager
    public void onRecycled(MapPlayableItem data) {
        setOccupy(false);
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().i(TAG, "playAvatar removeCallbacksAndMessages");
        }
        if (data != null) {
            this.onStopFilament.invoke(data, Boolean.FALSE);
        }
        getHandler().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.state.square.resource.SimpleResourceManager, com.tencent.state.square.resource.IBaseResourceManager
    public void stop(MapPlayableItem data) {
        if (data != null) {
            this.onStopFilament.invoke(data, Boolean.FALSE);
        }
        super.stop();
    }
}
