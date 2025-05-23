package com.tencent.state.template.map.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.push.BasePushManager;
import com.tencent.state.common.push.IPushInterceptor;
import com.tencent.state.common.push.IPushListener;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.CommonConfig;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0005J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001dH\u0007J\u001a\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020 H\u0016J\u0006\u0010.\u001a\u00020\u001dJ\u0006\u0010/\u001a\u00020\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\u00a8\u00061"}, d2 = {"Lcom/tencent/state/template/map/component/TemplatePushComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "Lcom/tencent/state/common/push/IPushListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/state/common/push/IPushInterceptor;", "()V", DownloadInfo.spKey_Config, "Lcom/tencent/state/template/data/CommonConfig;", "getConfig", "()Lcom/tencent/state/template/data/CommonConfig;", "setConfig", "(Lcom/tencent/state/template/data/CommonConfig;)V", "lastReceiveTime", "", "getLastReceiveTime", "()J", "setLastReceiveTime", "(J)V", "pushManager", "Lcom/tencent/state/common/push/BasePushManager;", "getPushManager", "()Lcom/tencent/state/common/push/BasePushManager;", "setPushManager", "(Lcom/tencent/state/common/push/BasePushManager;)V", "roomId", "getRoomId", "setRoomId", "getTargetPushManager", "onAppBackground", "", "onAppForeground", "onBackPressed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onInterceptDispatchMessage", "onInterceptPullMessage", "restartPush", "stopPush", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplatePushComponent extends TemplateMapBaseComponent implements IPushListener, LifecycleObserver, IPushInterceptor {
    private static final String TAG = "TemplatePushComponent";
    private CommonConfig config = new CommonConfig(0, null, 3, null);
    private long lastReceiveTime = Long.MAX_VALUE;
    private BasePushManager pushManager;
    private long roomId;

    protected final CommonConfig getConfig() {
        return this.config;
    }

    protected final long getLastReceiveTime() {
        return this.lastReceiveTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BasePushManager getPushManager() {
        return this.pushManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getRoomId() {
        return this.roomId;
    }

    public abstract BasePushManager getTargetPushManager();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackground() {
        SquareBaseKt.getSquareLog().i(TAG, "onAppBackground");
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager != null) {
            basePushManager.stop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForeground() {
        SquareBaseKt.getSquareLog().i(TAG, "onAppForeground");
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager != null) {
            basePushManager.start();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager == null) {
            return false;
        }
        basePushManager.stop();
        return false;
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        CommonRoomInfo room = info.getRoom();
        if (room != null) {
            this.roomId = room.getId();
            this.config = room.getConfig().getConfig();
            BasePushManager basePushManager = this.pushManager;
            if (basePushManager != null) {
                basePushManager.unregisterAll();
                basePushManager.initialize(room.getId(), info.getMsgOffset());
                basePushManager.setPushInterceptor(this);
                basePushManager.register(this);
                basePushManager.start();
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.pushManager = getTargetPushManager();
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager != null) {
            basePushManager.stop();
            basePushManager.unregisterAll();
        }
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @Override // com.tencent.state.common.push.IPushInterceptor
    public boolean onInterceptDispatchMessage() {
        this.lastReceiveTime = System.currentTimeMillis();
        return false;
    }

    @Override // com.tencent.state.common.push.IPushInterceptor
    public boolean onInterceptPullMessage() {
        if (System.currentTimeMillis() - this.lastReceiveTime <= this.config.getReconnectInterval()) {
            return false;
        }
        this.lastReceiveTime = System.currentTimeMillis();
        SquareBaseKt.getSquareLog().w(TAG, "onInterceptPullMessage: reconnectInterval=" + this.config.getReconnectInterval());
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplatePushComponent$onInterceptPullMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                BasePushManager pushManager = TemplatePushComponent.this.getPushManager();
                if (pushManager != null) {
                    pushManager.stop();
                }
                TemplatePushComponent templatePushComponent = TemplatePushComponent.this;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templatePushComponent instanceof VasBaseFragmentComponentGroup) ? null : templatePushComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent = templatePushComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templatePushComponent).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templatePushComponent).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) fragmentComponent;
                if (templateRoomComponent != null) {
                    templateRoomComponent.reenterRoom();
                }
            }
        });
        return true;
    }

    public final void restartPush() {
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager != null) {
            basePushManager.start();
        }
    }

    protected final void setConfig(CommonConfig commonConfig) {
        Intrinsics.checkNotNullParameter(commonConfig, "<set-?>");
        this.config = commonConfig;
    }

    protected final void setLastReceiveTime(long j3) {
        this.lastReceiveTime = j3;
    }

    protected final void setPushManager(BasePushManager basePushManager) {
        this.pushManager = basePushManager;
    }

    protected final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public final void stopPush() {
        BasePushManager basePushManager = this.pushManager;
        if (basePushManager != null) {
            basePushManager.stop();
        }
    }
}
