package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.InflateHelperKt;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.richframework.looper.RedirectMainLooperUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWSubThreadLayoutInflater;", "Lcom/tencent/biz/richframework/layoutinflater/RFWDelegateLayoutInflater;", "original", "Landroid/view/LayoutInflater;", "newContext", "Landroid/content/Context;", "delegates", "", "Lcom/tencent/biz/richframework/layoutinflater/LayoutInflateDelegate;", "(Landroid/view/LayoutInflater;Landroid/content/Context;Ljava/util/List;)V", "currentInflateResId", "", "mainHandler", "Landroid/os/Handler;", "redirectLooperMessageQueue", "", "cloneInContext", "inflate", "Landroid/view/View;", "resource", "root", "Landroid/view/ViewGroup;", "attachToRoot", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "onCreateView", "name", "", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "reportHashMapOperate", "", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWSubThreadLayoutInflater extends RFWDelegateLayoutInflater {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int currentInflateResId;
    private final Handler mainHandler;
    private final boolean redirectLooperMessageQueue;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWSubThreadLayoutInflater$Companion;", "", "()V", "TAG", "", "from", "Lcom/tencent/biz/richframework/layoutinflater/RFWSubThreadLayoutInflater;", PM.BASE, "Landroid/view/LayoutInflater;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final RFWSubThreadLayoutInflater from(@NotNull LayoutInflater base) {
            Intrinsics.checkNotNullParameter(base, "base");
            Context context = base.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "base.context");
            return new RFWSubThreadLayoutInflater(base, context, null, 4, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RFWSubThreadLayoutInflater(LayoutInflater layoutInflater, Context context, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutInflater, context, (i3 & 4) != 0 ? new ArrayList() : list);
    }

    private final void reportHashMapOperate(String name) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("ViewName", name);
        hashMap.put("InflateId", Integer.valueOf(this.currentInflateResId));
        LayoutInflater.Factory2 factory2 = getFactory2();
        if (factory2 != null) {
            str = factory2.getClass().getSimpleName();
        } else {
            str = "null";
        }
        hashMap.put("Factory2", str);
        RFWLog.d("RFWPreload_SubLayoutInflater", RFWLog.DEV, "reportParams:", hashMap);
        RFWReporter.reportCommonEvent("rfw_android_n_sub_create", hashMap);
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public LayoutInflater cloneInContext(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        LayoutInflater clonedBase = getBase().cloneInContext(newContext);
        Intrinsics.checkNotNullExpressionValue(clonedBase, "clonedBase");
        RFWSubThreadLayoutInflater rFWSubThreadLayoutInflater = new RFWSubThreadLayoutInflater(clonedBase, newContext, null, 4, null);
        rFWSubThreadLayoutInflater.resetDelegates(getDelegates());
        return rFWSubThreadLayoutInflater;
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot) {
        this.currentInflateResId = resource;
        View inflate = super.inflate(resource, root, attachToRoot);
        InflateHelperKt.setInflateResId(inflate, resource);
        Intrinsics.checkNotNullExpressionValue(inflate, "super.inflate(resource, \u2026ResId(resource)\n        }");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater, android.view.LayoutInflater
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(@NotNull final String name, @NotNull final AttributeSet attrs) throws ClassNotFoundException {
        View view;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 24 || i3 == 25) {
            reportHashMapOperate(name);
        }
        CreateViewRedirectManager createViewRedirectManager = CreateViewRedirectManager.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (createViewRedirectManager.needRedirect(name, context, attrs) && (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            FutureTask futureTask = new FutureTask(new Callable<View>() { // from class: com.tencent.biz.richframework.layoutinflater.RFWSubThreadLayoutInflater$onCreateView$futureTask$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public final View call() {
                    View onCreateView;
                    onCreateView = super/*com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater*/.onCreateView(name, attrs);
                    return onCreateView;
                }
            });
            this.mainHandler.post(futureTask);
            try {
                view = (View) futureTask.get();
            } catch (InterruptedException e16) {
                RFWLog.e("RFWPreload_SubLayoutInflater", RFWLog.USR, e16);
            } catch (ExecutionException e17) {
                RFWLog.e("RFWPreload_SubLayoutInflater", RFWLog.USR, e17);
            }
            if (view != null) {
                return super.onCreateView(name, attrs);
            }
            return view;
        }
        view = null;
        if (view != null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWSubThreadLayoutInflater(@NotNull LayoutInflater original, @NotNull Context newContext, @NotNull List<LayoutInflateDelegate> delegates) {
        super(original, newContext, delegates);
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        boolean z16 = !RFWApplication.isPublicVersion() || RFWConfig.getConfigValue("RFW_REDIRECT_LOOPER_MESSAGE_QUEUE", false);
        this.redirectLooperMessageQueue = z16;
        if (z16) {
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            String name = currentThread.getName();
            Intrinsics.checkNotNullExpressionValue(name, "Thread.currentThread().name");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "RFW_AsyncInflate", false, 2, null);
            if (startsWith$default) {
                boolean looperMessageQueueSameAsMain = RedirectMainLooperUtil.INSTANCE.setLooperMessageQueueSameAsMain();
                RFWLog.i("RFWPreload_SubLayoutInflater", RFWLog.USR, "setLooperMessageQueueSameAsMain:" + looperMessageQueueSameAsMain);
            }
        }
        this.currentInflateResId = -1;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater, android.view.LayoutInflater
    @NotNull
    public View inflate(@NotNull XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        return super.inflate(parser, root, attachToRoot);
    }
}
