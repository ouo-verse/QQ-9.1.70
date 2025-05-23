package com.tencent.mobileqq.zplan.utils.stack.lifecycle.impl;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import i74.b;
import java.util.HashMap;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import xk3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0003J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R7\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/lifecycle/impl/UEActivityLifeCycleImpl;", "Lcom/tencent/mobileqq/zplan/utils/stack/lifecycle/IUEActivityLifeCycle;", "", "key", "", "finish", "", "isFinishing", "getProcess", "activityName", "", "hashCode", "", "ueActivity", OperateCustomButton.OPERATE_CREATE, "destroy", "getActiveSceneCounter", "isTopEngineActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "finishCheck", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Ljava/util/HashMap;", "Li74/b;", "Lkotlin/collections/HashMap;", "mUEActivityPool$delegate", "Lkotlin/Lazy;", "getMUEActivityPool", "()Ljava/util/HashMap;", "mUEActivityPool", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UEActivityLifeCycleImpl implements IUEActivityLifeCycle {
    private static final String TAG = "UEActivityLifeCycleImpl_";

    /* renamed from: mUEActivityPool$delegate, reason: from kotlin metadata */
    private final Lazy mUEActivityPool;

    public UEActivityLifeCycleImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, b>>() { // from class: com.tencent.mobileqq.zplan.utils.stack.lifecycle.impl.UEActivityLifeCycleImpl$mUEActivityPool$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, b> invoke() {
                return new HashMap<>();
            }
        });
        this.mUEActivityPool = lazy;
    }

    private final HashMap<String, b> getMUEActivityPool() {
        return (HashMap) this.mUEActivityPool.getValue();
    }

    @ProcessName
    private final String getProcess() {
        String str = MobileQQ.processName;
        QLog.d(TAG, 4, "getProcess processName:" + str);
        if (Intrinsics.areEqual(str, "com.tencent.mobileqq")) {
            return "main";
        }
        if (Intrinsics.areEqual(str, "com.tencent.mobileqq:zplan")) {
            return "zplan";
        }
        return null;
    }

    private final boolean isFinishing(String key) {
        b bVar = getMUEActivityPool().get(key);
        boolean a85 = bVar != null ? bVar.a8() : false;
        QLog.d(TAG, 4, "isPageFinishing ueActivity:" + bVar + ", isPageFinishing:" + a85);
        return a85;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public void create(String activityName, int hashCode, Object ueActivity) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(ueActivity, "ueActivity");
        if (ueActivity instanceof b) {
            String process = getProcess();
            if (process != null) {
                QLog.d(TAG, 4, "create " + activityName + hashCode + " " + process + " " + ueActivity);
                getMUEActivityPool().put(xk3.b.f448110a.a(activityName, hashCode), ueActivity);
                ((a) i.INSTANCE.a(a.class)).create(activityName, hashCode, process);
                return;
            }
            throw new IllegalStateException("must call from main/zplan process!");
        }
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public void destroy(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        QLog.d(TAG, 4, "destroy " + activityName + hashCode);
        getMUEActivityPool().remove(xk3.b.f448110a.a(activityName, hashCode));
        ((a) i.INSTANCE.a(a.class)).destroy(activityName, hashCode);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public void finish(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        finish(xk3.b.f448110a.a(activityName, hashCode));
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle, yk3.a
    public Boolean finishCheck(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean isFinishing = isFinishing(key);
        QLog.d(TAG, 4, "finishCheck key:" + key + ", isFinishing:" + isFinishing);
        if (isFinishing) {
            finish(key);
        }
        return Boolean.valueOf(isFinishing);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public int getActiveSceneCounter() {
        return ((a) i.INSTANCE.a(a.class)).getActiveSceneCounter();
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public boolean isTopEngineActivity(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return ((a) i.INSTANCE.a(a.class)).isTopEngineActivity(activityName, hashCode);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle
    public boolean isTopEngineActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return xk3.b.f448110a.c(activity);
    }

    private final void finish(String key) {
        QLog.d(TAG, 4, "finish key:" + key);
        getMUEActivityPool().remove(key);
        ((a) i.INSTANCE.a(a.class)).finish(key);
    }
}
