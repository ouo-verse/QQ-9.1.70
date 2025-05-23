package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ComponentCenter implements IComponentCenter {
    static IPatchRedirector $redirector_ = null;
    private static final boolean LOG_ENABLE = false;
    private static final String TAG = "ComponentCenter";
    private QBaseActivity mActivity;
    private boolean mBackPressed;
    private SparseArray<IComponent> mComponentArray;
    private int mCurLifecycle;
    private final IProfileViewLoader mViewLoader;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class Lifecycle {
        static IPatchRedirector $redirector_ = null;
        public static final int CREATED = 2;
        public static final int DESTROYED = 7;
        public static final int NONE = 1;
        public static final int PAUSED = 5;
        public static final int RESUMED = 4;
        public static final int STARTED = 3;
        public static final int STOPPED = 6;

        Lifecycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface TraversalComponentCallback {
        void onTraversalComponent(IComponent iComponent);
    }

    public ComponentCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mViewLoader = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getViewHolder();
        this.mComponentArray = new SparseArray<>();
        this.mCurLifecycle = 1;
    }

    private void callComponentLifecycle(IComponent iComponent, int i3, int i16) {
        int i17 = i16 - i3;
        if (i17 != 0) {
            if (i17 > 0) {
                switch (i3) {
                    case 1:
                        iComponent.onCreate(this.mActivity, null);
                        callComponentLifecycle(iComponent, 2, i16);
                        return;
                    case 2:
                        iComponent.onStart();
                        callComponentLifecycle(iComponent, 3, i16);
                        return;
                    case 3:
                        iComponent.onResume();
                        callComponentLifecycle(iComponent, 4, i16);
                        return;
                    case 4:
                        iComponent.onPause();
                        callComponentLifecycle(iComponent, 5, i16);
                        return;
                    case 5:
                        iComponent.onStop();
                        callComponentLifecycle(iComponent, 6, i16);
                        return;
                    case 6:
                        iComponent.onDestroy();
                        callComponentLifecycle(iComponent, 7, i16);
                        return;
                    default:
                        QLog.w(TAG, 1, String.format("callComponentLifecycle not support lifecycle, from=%s", Integer.valueOf(i3)));
                        return;
                }
            }
            QLog.e(TAG, 1, String.format("callComponentLifecycle not support sequence, form=%s to=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    private void traversalComponentArray(TraversalComponentCallback traversalComponentCallback) {
        if (traversalComponentCallback == null) {
            return;
        }
        SparseArray<IComponent> clone = this.mComponentArray.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            traversalComponentCallback.onTraversalComponent(clone.valueAt(i3));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
    public void addComponent(IComponent iComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iComponent);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.iAsync(TAG, 2, String.format("addComponent component=%s", iComponent));
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (iComponent != null) {
                int componentType = iComponent.getComponentType();
                if (this.mComponentArray.indexOfKey(componentType) < 0) {
                    this.mComponentArray.put(componentType, iComponent);
                    callComponentLifecycle(iComponent, 1, this.mCurLifecycle);
                    return;
                } else {
                    QLog.e(TAG, 1, String.format("addComponent component exist. component=%s", iComponent));
                    return;
                }
            }
            return;
        }
        throw new RuntimeException("This Method Must Call In Main Thread.");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
    public IComponent getComponent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IComponent) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.mComponentArray.get(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
    public IProfileViewLoader getViewLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IProfileViewLoader) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mViewLoader;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
    public void init(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("init activity=%s", qBaseActivity));
        }
        if (qBaseActivity != null) {
            this.mActivity = qBaseActivity;
            this.mComponentArray.clear();
            this.mViewLoader.startPreload(qBaseActivity);
            return;
        }
        QLog.e(TAG, 1, "init params invalid.");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("onActivityResult requestCode=%s resultCode=%s data=%s", Integer.valueOf(i3), Integer.valueOf(i16), intent));
        }
        traversalComponentArray(new TraversalComponentCallback(i3, i16, intent) { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ Intent val$data;
            final /* synthetic */ int val$requestCode;
            final /* synthetic */ int val$resultCode;

            {
                this.val$requestCode = i3;
                this.val$resultCode = i16;
                this.val$data = intent;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ComponentCenter.this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onActivityResult(this.val$requestCode, this.val$resultCode, this.val$data);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public boolean onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "onBackPressed");
        }
        this.mBackPressed = false;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                    return;
                }
                ComponentCenter componentCenter = ComponentCenter.this;
                componentCenter.mBackPressed = iComponent.onBackPressed() | componentCenter.mBackPressed;
            }
        });
        return this.mBackPressed;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("onCreate activity=%s savedInstanceState=%s", qBaseActivity, bundle));
        }
        this.mCurLifecycle = 2;
        traversalComponentArray(new TraversalComponentCallback(qBaseActivity, bundle) { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QBaseActivity val$activity;
            final /* synthetic */ Bundle val$savedInstanceState;

            {
                this.val$activity = qBaseActivity;
                this.val$savedInstanceState = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ComponentCenter.this, qBaseActivity, bundle);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onCreate(this.val$activity, this.val$savedInstanceState);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.mCurLifecycle = 7;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onDestroy();
                }
            }
        });
        this.mActivity = null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("onNewIntent intent=%s", intent));
        }
        traversalComponentArray(new TraversalComponentCallback(intent) { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ Intent val$intent;

            {
                this.val$intent = intent;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this, (Object) intent);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onNewIntent(this.val$intent);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.mCurLifecycle = 5;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onPause();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "onResume");
        }
        this.mCurLifecycle = 4;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onResume();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "onStart");
        }
        this.mCurLifecycle = 3;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onStart();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, DKHippyEvent.EVENT_STOP);
        }
        this.mCurLifecycle = 6;
        traversalComponentArray(new TraversalComponentCallback() { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentCenter.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onStop();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("onWindowFocusChanged isFocused=%s", Boolean.valueOf(z16)));
        }
        traversalComponentArray(new TraversalComponentCallback(z16) { // from class: com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isFocused;

            {
                this.val$isFocused = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ComponentCenter.this, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.TraversalComponentCallback
            public void onTraversalComponent(IComponent iComponent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iComponent);
                } else {
                    iComponent.onWindowFocusChanged(this.val$isFocused);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
    public void removeComponent(IComponent iComponent) {
        int indexOfKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iComponent);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, String.format("removeComponent component=%s", iComponent));
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (iComponent != null && (indexOfKey = this.mComponentArray.indexOfKey(iComponent.getComponentType())) >= 0) {
                this.mComponentArray.removeAt(indexOfKey);
                callComponentLifecycle(iComponent, this.mCurLifecycle, 7);
                return;
            }
            return;
        }
        throw new RuntimeException("This Method Must Call In Main Thread.");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return String.format("ComponentCenter@%s", Integer.valueOf(hashCode()));
    }
}
