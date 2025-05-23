package com.tencent.mobileqq.activity.aio.intimate.reborn;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.activity.aio.intimate.reborn.part.c;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001\u0006B!\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00104\u001a\u00020\u001c\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J5\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0010*\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0010*\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0019J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00052\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eJ\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005R\u0019\u0010+\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R\u0017\u00100\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b'\u0010-\u001a\u0004\b.\u0010/R\u0017\u00104\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b&\u00101\u001a\u0004\b2\u00103R\u0014\u00107\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/IntimatePartManager;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View;", "contentView", "", "a", "Lcom/tencent/biz/richframework/part/PartManager;", "d", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroid/app/Activity;", "getHostActivity", "Landroid/content/Context;", "getHostContext", "Landroidx/lifecycle/ViewModel;", "T", "", "keyPrefix", "Ljava/lang/Class;", "viewModelClass", "getViewModel", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "getViewTagData", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "", "Lcom/tencent/biz/richframework/part/Part;", "partList", "b", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "g", "f", "e", "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "mContentView", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getMActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "mActivity", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", h.F, "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "", "i", "Ljava/util/List;", "mParts", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/part/PartManager;", "mPartManager", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/app/QBaseActivity;Landroidx/lifecycle/LifecycleOwner;)V", BdhLogUtil.LogTag.Tag_Conn, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimatePartManager implements IPartHost, LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View mContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStore viewModelStore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Part> mParts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PartManager mPartManager;

    public IntimatePartManager(@Nullable View view, @NotNull QBaseActivity mActivity, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.mContentView = view;
        this.mActivity = mActivity;
        this.lifecycleOwner = lifecycleOwner;
        this.viewModelStore = new ViewModelStore();
        this.mParts = new ArrayList();
    }

    private final void a(View contentView) {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.setRootView(contentView);
        }
        PartManager partManager2 = this.mPartManager;
        if (partManager2 != null) {
            partManager2.onPartCreate(this.mActivity, null);
        }
    }

    public final void b(@Nullable List<? extends Part> partList) {
        if (partList == null) {
            return;
        }
        List<? extends Part> list = partList;
        if (!list.isEmpty()) {
            this.mParts.clear();
            this.mParts.addAll(list);
            PartManager d16 = d();
            this.mPartManager = d16;
            Intrinsics.checkNotNull(d16);
            d16.registerPart(partList);
        }
        View view = this.mContentView;
        if (view == null) {
            return;
        }
        a(view);
    }

    @Nullable
    public final PartManager d() {
        if (this.mPartManager == null) {
            this.mPartManager = new PartManager(this, this.mContentView);
        }
        return this.mPartManager;
    }

    public final void e() {
        c cVar;
        for (Part part : this.mParts) {
            if (part instanceof c) {
                cVar = (c) part;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.x9();
            }
        }
    }

    public final void f() {
        c cVar;
        for (Part part : this.mParts) {
            if (part instanceof c) {
                cVar = (c) part;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.z9();
            }
        }
    }

    public final void g() {
        c cVar;
        for (Part part : this.mParts) {
            if (part instanceof c) {
                cVar = (c) part;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.A9();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    @NotNull
    public Activity getHostActivity() {
        return this.mActivity;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public Context getHostContext() {
        Context context;
        View view = this.mContentView;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.mActivity;
        }
        return context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: getHostLifecycleOwner, reason: from getter */
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public <T extends ViewModel> T getViewModel(@Nullable String keyPrefix, @NotNull Class<T> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        return (T) getViewModel(this, keyPrefix, viewModelClass);
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        return this.viewModelStore;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public Object getViewTagData() {
        View view = this.mContentView;
        if (view != null) {
            return view.getTag(TagData.TAG_DATA_ID);
        }
        return null;
    }

    public final void onDestroy() {
        QLog.i("QQSettingMePartManager", 1, "ON_DESTROY");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartDestroy(this.mActivity);
        }
        this.mParts.clear();
        this.viewModelStore.clear();
        this.mPartManager = null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    public final void onPause() {
        QLog.i("QQSettingMePartManager", 1, "ON_PAUSE");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartPause(this.mActivity);
        }
    }

    public final void onResume() {
        QLog.i("QQSettingMePartManager", 1, "ON_RESUME");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartResume(this.mActivity);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public <T extends ViewModel> T getViewModel(@Nullable ViewModelStoreOwner storeOwner, @Nullable String keyPrefix, @NotNull Class<T> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        return (T) com.tencent.mobileqq.mvvm.h.b(this, j61.c.INSTANCE.a()).get(viewModelClass);
    }
}
