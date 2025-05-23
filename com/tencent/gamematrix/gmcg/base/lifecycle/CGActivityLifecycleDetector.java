package com.tencent.gamematrix.gmcg.base.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGActivityLifecycleDetector implements Handler.Callback {
    static final String FRAGMENT_TAG = "com.tencent.gamematrix.gmcg";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final CGSingletonHelper<CGActivityLifecycleDetector> sInstance = new CGSingletonHelper<CGActivityLifecycleDetector>() { // from class: com.tencent.gamematrix.gmcg.base.lifecycle.CGActivityLifecycleDetector.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGActivityLifecycleDetector create() {
            return new CGActivityLifecycleDetector();
        }
    };
    final Map<FragmentManager, CGSupportLifecycleManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final Handler handler = new Handler(Looper.getMainLooper(), this);

    public static CGActivityLifecycleDetector get() {
        return sInstance.get();
    }

    @NonNull
    private CGSupportLifecycleManagerFragment getLifecycleFragmentOfActivity(Activity activity) {
        return getSupportRequestManagerFragment(activity.getFragmentManager());
    }

    @NonNull
    private CGSupportLifecycleManagerFragment getSupportRequestManagerFragment(@NonNull FragmentManager fragmentManager) {
        CGSupportLifecycleManagerFragment cGSupportLifecycleManagerFragment = (CGSupportLifecycleManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (cGSupportLifecycleManagerFragment == null) {
            CGSupportLifecycleManagerFragment cGSupportLifecycleManagerFragment2 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
            if (cGSupportLifecycleManagerFragment2 == null) {
                CGSupportLifecycleManagerFragment cGSupportLifecycleManagerFragment3 = new CGSupportLifecycleManagerFragment();
                this.pendingSupportRequestManagerFragments.put(fragmentManager, cGSupportLifecycleManagerFragment3);
                fragmentManager.beginTransaction().add(cGSupportLifecycleManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
                this.handler.obtainMessage(2, fragmentManager).sendToTarget();
                return cGSupportLifecycleManagerFragment3;
            }
            return cGSupportLifecycleManagerFragment2;
        }
        return cGSupportLifecycleManagerFragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        FragmentManager fragmentManager;
        CGSupportLifecycleManagerFragment remove;
        int i3 = message.what;
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            remove = null;
            z16 = false;
            fragmentManager = null;
        } else {
            FragmentManager fragmentManager2 = (FragmentManager) message.obj;
            fragmentManager = fragmentManager2;
            remove = this.pendingSupportRequestManagerFragments.remove(fragmentManager2);
        }
        if (z16 && remove == null) {
            CGLog.w("Failed to remove expected request manager fragment, manager: " + fragmentManager);
        }
        return z16;
    }

    public void register(Activity activity, CGLifecycleListener cGLifecycleListener) {
        getLifecycleFragmentOfActivity(activity).getLifecycle().addListener(cGLifecycleListener);
    }

    public void unregister(Activity activity, CGLifecycleListener cGLifecycleListener) {
        getLifecycleFragmentOfActivity(activity).getLifecycle().removeListener(cGLifecycleListener);
    }
}
