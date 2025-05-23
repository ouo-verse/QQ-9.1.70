package com.tencent.richframework.gallery;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.IPermissionRequester;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J+\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 2\u0006\u0010!\u001a\u00020\"H\u0016\u00a2\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0016J5\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160 \"\u0004\u0018\u00010\u0016H\u0016\u00a2\u0006\u0002\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006."}, d2 = {"Lcom/tencent/richframework/gallery/QQGalleryActivity;", "Lcom/tencent/biz/richframework/activity/CompatPublicActivity;", "Lmqq/app/IPermissionRequester;", "()V", "mNeedRemoveSaveState", "", "mOpenLayoutInflaterDelegate", "mPermissionCallerMap", "Landroid/util/SparseArray;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mQUIProfileTheme", "Lcom/tencent/richframework/gallery/QQGalleryQUIProfileTheme;", "getMQUIProfileTheme", "()Lcom/tencent/richframework/gallery/QQGalleryQUIProfileTheme;", "mQUIProfileTheme$delegate", "Lkotlin/Lazy;", "getResources", "Landroid/content/res/Resources;", "getSystemService", "name", "", "isDelegatedInflateEnabled", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onRequestPermissionsResult", "reqCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "removeFragmentState", "requestPermissions", "caller", "requestCode", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "Companion", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public class QQGalleryActivity extends CompatPublicActivity implements IPermissionRequester {

    @NotNull
    public static final String OPEN_LAYOUT_INFLATER_DELEGATE = "OPEN_LAYOUT_INFLATER_DELEGATE";

    @NotNull
    public static final String REMOVE_SAVE_STATE = "REMOVE_SAVE_STATE";

    /* renamed from: mQUIProfileTheme$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mQUIProfileTheme;

    @NotNull
    private final SparseArray<ArrayList<Object>> mPermissionCallerMap = new SparseArray<>();
    private final boolean mNeedRemoveSaveState = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(REMOVE_SAVE_STATE, true);
    private final boolean mOpenLayoutInflaterDelegate = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(OPEN_LAYOUT_INFLATER_DELEGATE, true);

    public QQGalleryActivity() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQGalleryQUIProfileTheme>() { // from class: com.tencent.richframework.gallery.QQGalleryActivity$mQUIProfileTheme$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQGalleryQUIProfileTheme invoke() {
                return new QQGalleryQUIProfileTheme(QQGalleryActivity.this);
            }
        });
        this.mQUIProfileTheme = lazy;
    }

    private final QQGalleryQUIProfileTheme getMQUIProfileTheme() {
        return (QQGalleryQUIProfileTheme) this.mQUIProfileTheme.getValue();
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        Resources resources = getMQUIProfileTheme().getResources(super.getResources());
        DisplayMetricsUtil.checkAndCorrectDensity(resources.getDisplayMetrics());
        GlobalDisplayMetricsManager.checkDensity(resources);
        return resources;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object systemService = super.getSystemService(name);
        if (Intrinsics.areEqual("layout_inflater", name) && (systemService instanceof LayoutInflater)) {
            return getMQUIProfileTheme().getLayoutInflater((LayoutInflater) systemService);
        }
        return systemService;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    /* renamed from: isDelegatedInflateEnabled, reason: from getter */
    public boolean getMOpenLayoutInflaterDelegate() {
        return this.mOpenLayoutInflaterDelegate;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        QQFragmentStateFixer.INSTANCE.fixBadParcelException(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int reqCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z16;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(reqCode, permissions, grantResults);
        if (grantResults.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ArrayList<Object> arrayList = this.mPermissionCallerMap.get(reqCode);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Object> it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    if (next instanceof QQPermissionCallback) {
                        ArrayList arrayList2 = new ArrayList();
                        int length = grantResults.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            if (grantResults[i3] != 0) {
                                arrayList2.add(permissions[i3]);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            ((QQPermissionCallback) next).deny(reqCode, permissions, grantResults);
                        } else {
                            ((QQPermissionCallback) next).grant(reqCode, permissions, grantResults);
                        }
                    } else {
                        QQPermissionHelper.requestResult(next, reqCode, permissions, grantResults);
                    }
                }
            }
        }
        if (arrayList != null) {
            this.mPermissionCallerMap.remove(reqCode);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState, @NotNull PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        if (this.mNeedRemoveSaveState) {
            removeFragmentState(outState);
            removeFragmentState(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
        }
    }

    public void removeFragmentState(@Nullable Bundle outState) {
        if (outState != null) {
            outState.remove("android:viewHierarchyState");
            outState.remove("android:fragments");
            outState.remove("android:support:fragments");
        }
    }

    @Override // mqq.app.IPermissionRequester
    public void requestPermissions(@NotNull Object caller, int requestCode, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "fight.requestPermissions-", permissions);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            Intrinsics.checkNotNull(str);
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            ArrayList<Object> arrayList2 = this.mPermissionCallerMap.get(requestCode);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
            }
            int size = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    if (obj != null && obj == caller) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList2.add(caller);
                this.mPermissionCallerMap.put(requestCode, arrayList2);
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            requestPermissions((String[]) array, requestCode);
            return;
        }
        if (caller instanceof QQPermissionCallback) {
            ((QQPermissionCallback) caller).grant(requestCode, permissions, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(caller, requestCode);
        }
    }
}
