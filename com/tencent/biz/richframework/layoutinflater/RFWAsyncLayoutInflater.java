package com.tencent.biz.richframework.layoutinflater;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pools;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0005\u001e\u001f !\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J$\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0011H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handlerCallback", "Landroid/os/Handler$Callback;", "hostContextWrf", "Ljava/lang/ref/WeakReference;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "mainHandler", "Landroid/os/Handler;", "requestPool", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRequest;", "cancel", "", "inflate", "resId", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;", "obtainRequest", "releaseRequest", "obj", "BasicInflater", "Companion", "InflateRequest", "InflateRunnable", "OnInflateFinishedListener", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWAsyncLayoutInflater {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private Handler.Callback handlerCallback;
    private final WeakReference<Context> hostContextWrf;
    private final Handler mainHandler;
    private final Pools.SynchronizedPool<InflateRequest> requestPool;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$BasicInflater;", "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cloneInContext", "newContext", "onCreateView", "Landroid/view/View;", "name", "", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class BasicInflater extends LayoutInflater {
        private static final String[] CLASS_PREFIX_LIST = {"android.widget.", "android.webkit.", "android.app."};

        public BasicInflater(@Nullable Context context) {
            super(context);
            if (context instanceof AppCompatActivity) {
                Object delegate = ((AppCompatActivity) context).getDelegate();
                Intrinsics.checkNotNullExpressionValue(delegate, "context.delegate");
                if (delegate instanceof LayoutInflater.Factory2) {
                    androidx.core.view.LayoutInflaterCompat.setFactory2(this, (LayoutInflater.Factory2) delegate);
                }
            }
        }

        @Override // android.view.LayoutInflater
        @NotNull
        public LayoutInflater cloneInContext(@NotNull Context newContext) {
            Intrinsics.checkNotNullParameter(newContext, "newContext");
            return new BasicInflater(newContext);
        }

        @Override // android.view.LayoutInflater
        @NotNull
        protected View onCreateView(@NotNull String name, @NotNull AttributeSet attrs) throws ClassNotFoundException {
            View createView;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            for (String str : CLASS_PREFIX_LIST) {
                try {
                    createView = createView(name, str, attrs);
                } catch (ClassNotFoundException e16) {
                    RFWLog.e("RFWAsyncLayoutInflater", RFWLog.USR, "createView error:" + e16.getMessage(), e16);
                }
                if (createView != null) {
                    return createView;
                }
            }
            View onCreateView = super.onCreateView(name, attrs);
            Intrinsics.checkNotNullExpressionValue(onCreateView, "super.onCreateView(name, attrs)");
            return onCreateView;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$Companion;", "", "()V", "MERGE_EXCEPTION", "", "TAG", "isMergeException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMergeException(Exception e16) {
            String message;
            boolean contains$default;
            if ((e16 instanceof InflateException) && (message = e16.getMessage()) != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "can be used only with a valid ViewGroup root and attachToRoot=true", false, 2, (Object) null);
                if (!contains$default) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRequest;", "", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "inflater", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "getInflater", "()Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "setInflater", "(Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;)V", "Landroid/view/ViewGroup;", "parentGroupView", "Landroid/view/ViewGroup;", "getParentGroupView", "()Landroid/view/ViewGroup;", "setParentGroupView", "(Landroid/view/ViewGroup;)V", "", "isMergeRes", "Z", "()Z", "setMergeRes", "(Z)V", "", "resLayoutId", "I", "getResLayoutId", "()I", "setResLayoutId", "(I)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "", "inflateThrowable", "Ljava/lang/Throwable;", "getInflateThrowable", "()Ljava/lang/Throwable;", "setInflateThrowable", "(Ljava/lang/Throwable;)V", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;", "callback", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;", "getCallback", "()Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;)V", "<init>", "()V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class InflateRequest {

        @Nullable
        private OnInflateFinishedListener callback;

        @Nullable
        private Throwable inflateThrowable;

        @Nullable
        private RFWAsyncLayoutInflater inflater;
        private boolean isMergeRes;

        @Nullable
        private ViewGroup parentGroupView;
        private int resLayoutId;

        @Nullable
        private View view;

        @Nullable
        public final OnInflateFinishedListener getCallback() {
            return this.callback;
        }

        @Nullable
        public final Throwable getInflateThrowable() {
            return this.inflateThrowable;
        }

        @Nullable
        public final RFWAsyncLayoutInflater getInflater() {
            return this.inflater;
        }

        @Nullable
        public final ViewGroup getParentGroupView() {
            return this.parentGroupView;
        }

        public final int getResLayoutId() {
            return this.resLayoutId;
        }

        @Nullable
        public final View getView() {
            return this.view;
        }

        /* renamed from: isMergeRes, reason: from getter */
        public final boolean getIsMergeRes() {
            return this.isMergeRes;
        }

        public final void setCallback(@Nullable OnInflateFinishedListener onInflateFinishedListener) {
            this.callback = onInflateFinishedListener;
        }

        public final void setInflateThrowable(@Nullable Throwable th5) {
            this.inflateThrowable = th5;
        }

        public final void setInflater(@Nullable RFWAsyncLayoutInflater rFWAsyncLayoutInflater) {
            this.inflater = rFWAsyncLayoutInflater;
        }

        public final void setMergeRes(boolean z16) {
            this.isMergeRes = z16;
        }

        public final void setParentGroupView(@Nullable ViewGroup viewGroup) {
            this.parentGroupView = viewGroup;
        }

        public final void setResLayoutId(int i3) {
            this.resLayoutId = i3;
        }

        public final void setView(@Nullable View view) {
            this.view = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "<set-?>", "isRunning", "Z", "()Z", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRequest;", "<init>", "(Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$InflateRequest;)V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class InflateRunnable implements Runnable {
        private boolean isRunning;
        private final InflateRequest request;

        public InflateRunnable(@NotNull InflateRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th5;
            Throwable th6;
            View view;
            LayoutInflater layoutInflater;
            View view2;
            LayoutInflater layoutInflater2;
            this.isRunning = true;
            Handler handler = null;
            try {
                long nanoTime = System.nanoTime();
                InflateRequest inflateRequest = this.request;
                RFWAsyncLayoutInflater inflater = inflateRequest.getInflater();
                if (inflater != null && (layoutInflater2 = inflater.getLayoutInflater()) != null) {
                    view2 = layoutInflater2.inflate(this.request.getResLayoutId(), this.request.getParentGroupView(), false);
                } else {
                    view2 = null;
                }
                inflateRequest.setView(view2);
                long nanoTime2 = System.nanoTime() - nanoTime;
                int i3 = RFWLog.USR;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("inflate id:");
                sb5.append(this.request.getResLayoutId());
                sb5.append(" name:");
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                sb5.append(application.getResources().getResourceName(this.request.getResLayoutId()));
                sb5.append(" save time:");
                sb5.append(nanoTime2);
                RFWLog.i("RFWAsyncLayoutInflater", i3, sb5.toString());
            } catch (InflateException e16) {
                this.request.setInflateThrowable(e16);
                if (LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getTryFixMerge() && RFWAsyncLayoutInflater.INSTANCE.isMergeException(e16) && this.request.getParentGroupView() != null) {
                    ParentViewGroupPool parentViewGroupPool = ParentViewGroupPool.INSTANCE;
                    ViewGroup parentGroupView = this.request.getParentGroupView();
                    Intrinsics.checkNotNull(parentGroupView);
                    Class<?> findAndroidSuperClass = parentViewGroupPool.findAndroidSuperClass(parentGroupView.getClass());
                    if (findAndroidSuperClass != null) {
                        try {
                            ViewGroup createViewGroup = parentViewGroupPool.createViewGroup(findAndroidSuperClass);
                            long nanoTime3 = System.nanoTime();
                            InflateRequest inflateRequest2 = this.request;
                            RFWAsyncLayoutInflater inflater2 = inflateRequest2.getInflater();
                            if (inflater2 != null && (layoutInflater = inflater2.getLayoutInflater()) != null) {
                                view = layoutInflater.inflate(this.request.getResLayoutId(), createViewGroup, true);
                            } else {
                                view = null;
                            }
                            inflateRequest2.setView(view);
                            long nanoTime4 = System.nanoTime() - nanoTime3;
                            int i16 = RFWLog.USR;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("inflate with merge fakeParent id:");
                            sb6.append(this.request.getResLayoutId());
                            sb6.append(" name:");
                            Application application2 = RFWApplication.getApplication();
                            Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                            sb6.append(application2.getResources().getResourceName(this.request.getResLayoutId()));
                            sb6.append(" save time:");
                            sb6.append(nanoTime4);
                            RFWLog.i("RFWAsyncLayoutInflater", i16, sb6.toString());
                            this.request.setMergeRes(true);
                        } catch (Exception e17) {
                            RFWLog.e("RFWAsyncLayoutInflater", RFWLog.USR, "catch merge exception:", e16);
                            RFWLog.e("RFWAsyncLayoutInflater", RFWLog.USR, "Failed to fix merge exception, catch:", e17);
                            this.request.setInflateThrowable(e17);
                        }
                    }
                } else {
                    RFWLog.e("RFWAsyncLayoutInflater", RFWLog.USR, "inflate Failed catch exception:", e16);
                    Throwable cause = e16.getCause();
                    if (cause != null) {
                        th5 = cause.getCause();
                    } else {
                        th5 = null;
                    }
                    if (th5 != null) {
                        int i17 = RFWLog.USR;
                        Object[] objArr = new Object[2];
                        objArr[0] = "inflate base exception:";
                        Throwable cause2 = e16.getCause();
                        if (cause2 != null) {
                            th6 = cause2.getCause();
                        } else {
                            th6 = null;
                        }
                        objArr[1] = th6;
                        RFWLog.e("RFWAsyncLayoutInflater", i17, objArr);
                    }
                }
            } catch (Throwable th7) {
                this.request.setInflateThrowable(th7);
            }
            RFWAsyncLayoutInflater inflater3 = this.request.getInflater();
            if (inflater3 != null) {
                handler = inflater3.mainHandler;
            }
            Message.obtain(handler, 0, this.request).sendToTarget();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J,\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater$OnInflateFinishedListener;", "", "onInflateError", "", "e", "", "onInflateFinished", "view", "Landroid/view/View;", "resId", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "isMerge", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface OnInflateFinishedListener {
        void onInflateError(@Nullable Throwable e16);

        void onInflateFinished(@NotNull View view, @LayoutRes int resId, @Nullable ViewGroup parent, boolean isMerge);
    }

    public RFWAsyncLayoutInflater(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.requestPool = new Pools.SynchronizedPool<>(20);
        this.handlerCallback = new Handler.Callback() { // from class: com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater$handlerCallback$1
            /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            
                if (r0 != null) goto L15;
             */
            @Override // android.os.Handler.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final boolean handleMessage(@NotNull Message msg2) {
                Unit unit;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Object obj = msg2.obj;
                if (obj != null) {
                    RFWAsyncLayoutInflater.InflateRequest inflateRequest = (RFWAsyncLayoutInflater.InflateRequest) obj;
                    View view = inflateRequest.getView();
                    if (view != null) {
                        RFWAsyncLayoutInflater.OnInflateFinishedListener callback = inflateRequest.getCallback();
                        if (callback != null) {
                            callback.onInflateFinished(view, inflateRequest.getResLayoutId(), inflateRequest.getParentGroupView(), inflateRequest.getIsMergeRes());
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                    }
                    RFWAsyncLayoutInflater.OnInflateFinishedListener callback2 = inflateRequest.getCallback();
                    if (callback2 != null) {
                        callback2.onInflateError(inflateRequest.getInflateThrowable());
                        Unit unit2 = Unit.INSTANCE;
                    }
                    RFWAsyncLayoutInflater.this.releaseRequest(inflateRequest);
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater.InflateRequest");
            }
        };
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
        this.hostContextWrf = new WeakReference<>(context);
    }

    private final InflateRequest obtainRequest() {
        InflateRequest acquire = this.requestPool.acquire();
        if (acquire == null) {
            return new InflateRequest();
        }
        return acquire;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseRequest(InflateRequest obj) {
        obj.setCallback(null);
        obj.setInflater(null);
        obj.setParentGroupView(null);
        obj.setResLayoutId(0);
        obj.setMergeRes(false);
        obj.setView(null);
        this.requestPool.release(obj);
    }

    public final void cancel() {
        this.mainHandler.removeCallbacksAndMessages(null);
        this.handlerCallback = null;
    }

    @Nullable
    public final LayoutInflater getLayoutInflater() {
        Context context = this.hostContextWrf.get();
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return LayoutInflater.from(context);
        }
        return new BasicInflater(context);
    }

    @UiThread
    public final void inflate(@LayoutRes int resId, @Nullable ViewGroup parent, @NotNull OnInflateFinishedListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InflateRequest obtainRequest = obtainRequest();
        obtainRequest.setInflater(this);
        obtainRequest.setResLayoutId(resId);
        obtainRequest.setParentGroupView(parent);
        obtainRequest.setCallback(callback);
        RFWPreloadExecutor.INSTANCE.execute(new InflateRunnable(obtainRequest));
    }
}
