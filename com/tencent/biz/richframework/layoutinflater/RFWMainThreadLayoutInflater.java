package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.InflateHelperKt;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\nH\u0016JD\u0010\u001d\u001a\u00020\f2\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J0\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWMainThreadLayoutInflater;", "Lcom/tencent/biz/richframework/layoutinflater/RFWDelegateLayoutInflater;", PM.BASE, "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "viewProvider", "Lcom/tencent/biz/richframework/layoutinflater/IViewProvider;", "(Landroid/view/LayoutInflater;Landroid/content/Context;Lcom/tencent/biz/richframework/layoutinflater/IViewProvider;)V", "collectEventOnAttachView", "", "addChildViewToAnotherGroup", "", "preViewGroup", "Landroid/view/ViewGroup;", "targetViewGroup", "advanceToRootNode", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "cloneInContext", "newContext", "getLayoutManager", "", "root", "inflate", "Landroid/view/View;", "resource", "", "attachToRoot", "sendSystemInflateResult", "inflateView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "isAttachRoot", "isMergeXml", "costTime", "", "isFromCache", "setFactory", "factory", "Landroid/view/LayoutInflater$Factory;", "setFactory2", "Landroid/view/LayoutInflater$Factory2;", "setFilter", "filter", "Landroid/view/LayoutInflater$Filter;", "wrapRootView", "res", "Landroid/content/res/Resources;", "view", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public class RFWMainThreadLayoutInflater extends RFWDelegateLayoutInflater {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean collectEventOnAttachView;
    private final IViewProvider viewProvider;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWMainThreadLayoutInflater$Companion;", "", "()V", "TAG", "", "from", "Lcom/tencent/biz/richframework/layoutinflater/RFWMainThreadLayoutInflater;", PM.BASE, "Landroid/view/LayoutInflater;", "viewProvider", "Lcom/tencent/biz/richframework/layoutinflater/IViewProvider;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final RFWMainThreadLayoutInflater from(@NotNull LayoutInflater base, @NotNull IViewProvider viewProvider) {
            Intrinsics.checkNotNullParameter(base, "base");
            Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
            Context context = base.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "base.context");
            RFWMainThreadLayoutInflater rFWMainThreadLayoutInflater = new RFWMainThreadLayoutInflater(base, context, viewProvider);
            Object context2 = base.getContext();
            if (!(context2 instanceof LayoutInflater.Factory2)) {
                context2 = null;
            }
            LayoutInflater.Factory2 factory2 = (LayoutInflater.Factory2) context2;
            if (factory2 != null) {
                LayoutInflaterCompat layoutInflaterCompat = LayoutInflaterCompat.INSTANCE;
                layoutInflaterCompat.forceInvokeSetPrivateFactory(rFWMainThreadLayoutInflater, factory2);
                layoutInflaterCompat.forceInvokeSetPrivateFactory(base, factory2);
            }
            return rFWMainThreadLayoutInflater;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWMainThreadLayoutInflater(@NotNull LayoutInflater base, @NotNull Context context, @NotNull IViewProvider viewProvider) {
        super(base, context, null, 4, null);
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        this.viewProvider = viewProvider;
        this.collectEventOnAttachView = RFWConfig.getConfigValue("RFW_COLLECT_INFLATE_ON_ATTACH", false);
    }

    private final void addChildViewToAnotherGroup(ViewGroup preViewGroup, ViewGroup targetViewGroup) {
        int childCount = preViewGroup.getChildCount();
        ArrayList<View> arrayList = new ArrayList(childCount);
        for (int i3 = 0; i3 < childCount; i3++) {
            arrayList.add(preViewGroup.getChildAt(i3));
        }
        for (View view : arrayList) {
            preViewGroup.removeView(view);
            targetViewGroup.addView(view);
        }
    }

    private final void advanceToRootNode(XmlPullParser parser) throws InflateException, IOException, XmlPullParserException {
        int next;
        do {
            next = parser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return;
        }
        throw new InflateException(parser.getPositionDescription() + ": No start tag found!");
    }

    @JvmStatic
    @NotNull
    public static final RFWMainThreadLayoutInflater from(@NotNull LayoutInflater layoutInflater, @NotNull IViewProvider iViewProvider) {
        return INSTANCE.from(layoutInflater, iViewProvider);
    }

    private final String getLayoutManager(ViewGroup root) {
        RecyclerView.LayoutManager layoutManager;
        if (!(root instanceof RecyclerView)) {
            root = null;
        }
        RecyclerView recyclerView = (RecyclerView) root;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            return layoutManager.getClass().getName();
        }
        return "";
    }

    private final void sendSystemInflateResult(@LayoutRes final int resource, final View inflateView, final View rootView, final boolean isAttachRoot, final boolean isMergeXml, final long costTime, final boolean isFromCache) {
        InflateHelperKt.setInflateResId(inflateView, resource);
        if (inflateView.isAttachedToWindow()) {
            ArgusInflateCollector.INSTANCE.handleInflateEvent(resource, inflateView, rootView, isAttachRoot, isMergeXml, costTime, isFromCache);
        } else if (this.collectEventOnAttachView) {
            inflateView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.biz.richframework.layoutinflater.RFWMainThreadLayoutInflater$sendSystemInflateResult$$inlined$let$lambda$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v3) {
                    Intrinsics.checkNotNullParameter(v3, "v");
                    inflateView.removeOnAttachStateChangeListener(this);
                    ArgusInflateCollector.INSTANCE.handleInflateEvent(resource, inflateView, rootView, isAttachRoot, isMergeXml, costTime, isFromCache);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v3) {
                    Intrinsics.checkNotNullParameter(v3, "v");
                }
            });
        } else {
            inflateView.post(new Runnable() { // from class: com.tencent.biz.richframework.layoutinflater.RFWMainThreadLayoutInflater$sendSystemInflateResult$$inlined$let$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    ArgusInflateCollector.INSTANCE.handleInflateEvent(resource, inflateView, rootView, isAttachRoot, isMergeXml, costTime, isFromCache);
                }
            });
        }
    }

    private final boolean wrapRootView(Resources res, int resource, View view, ViewGroup root, boolean attachToRoot) {
        if (view.getLayoutParams() == null) {
            try {
                XmlResourceParser parser = res.getLayout(resource);
                AttributeSet asAttributeSet = Xml.asAttributeSet(parser);
                Intrinsics.checkNotNullExpressionValue(asAttributeSet, "Xml.asAttributeSet(parser)");
                Intrinsics.checkNotNullExpressionValue(parser, "parser");
                advanceToRootNode(parser);
                ViewGroup.LayoutParams generateLayoutParams = root.generateLayoutParams(asAttributeSet);
                Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "root.generateLayoutParams(attrs)");
                if (attachToRoot) {
                    root.addView(view, generateLayoutParams);
                } else {
                    view.setLayoutParams(generateLayoutParams);
                }
                return true;
            } catch (IOException e16) {
                RFWLog.e("RFWMainThreadLayoutInflater", RFWLog.USR, e16);
                return false;
            } catch (XmlPullParserException e17) {
                RFWLog.e("RFWMainThreadLayoutInflater", RFWLog.USR, e17);
                return false;
            }
        }
        if (attachToRoot) {
            root.addView(view);
        }
        return true;
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public LayoutInflater cloneInContext(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        LayoutInflater clonedBase = getBase().cloneInContext(newContext);
        Intrinsics.checkNotNullExpressionValue(clonedBase, "clonedBase");
        RFWMainThreadLayoutInflater rFWMainThreadLayoutInflater = new RFWMainThreadLayoutInflater(clonedBase, newContext, this.viewProvider);
        rFWMainThreadLayoutInflater.resetDelegates(getDelegates());
        return rFWMainThreadLayoutInflater;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.view.View] */
    @Override // android.view.LayoutInflater
    @NotNull
    public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot) {
        View inflate;
        boolean z16;
        long nanoTime = System.nanoTime();
        IViewProvider iViewProvider = this.viewProvider;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        PreloadResult preloadResult = iViewProvider.getPreloadResult(context, new PreloadRequest(resource, root != null ? root.getClass().getName() : "", getLayoutManager(root)), false);
        if (preloadResult == null) {
            IViewProvider iViewProvider2 = this.viewProvider;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            preloadResult = iViewProvider2.getPreloadResult(context2, new PreloadRequest(resource, "", null, 4, null), false);
        }
        PreloadResult preloadResult2 = preloadResult;
        ViewGroup view = preloadResult2 != null ? preloadResult2.getView() : null;
        if ((view instanceof ViewGroup) && preloadResult2 != null && preloadResult2.getIsMergeRes() && root != null && attachToRoot) {
            addChildViewToAnotherGroup(view, root);
            sendSystemInflateResult(resource, root, root, true, true, System.nanoTime() - nanoTime, true);
            return root;
        }
        if (view != null) {
            if (root != null) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                Resources resources = context3.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                z16 = wrapRootView(resources, resource, view, root, attachToRoot);
            } else {
                z16 = true;
            }
            if (z16) {
                sendSystemInflateResult(resource, view, root, attachToRoot, preloadResult2 != null ? preloadResult2.getIsMergeRes() : false, System.nanoTime() - nanoTime, true);
                return (root == null || !attachToRoot) ? view : root;
            }
        }
        int childCount = (root == null || !attachToRoot) ? 0 : root.getChildCount();
        try {
            inflate = super.inflate(resource, root, attachToRoot);
        } catch (Exception unused) {
            inflate = getBase().inflate(resource, root, attachToRoot);
        }
        View inflateView = inflate;
        Intrinsics.checkNotNullExpressionValue(inflateView, "inflateView");
        sendSystemInflateResult(resource, inflateView, root, attachToRoot, root != null && attachToRoot && root.getChildCount() - childCount > 1, System.nanoTime() - nanoTime, false);
        return inflateView;
    }

    @Override // android.view.LayoutInflater
    public void setFactory(@NotNull LayoutInflater.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        super.setFactory(factory);
        getBase().setFactory(factory);
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(@NotNull LayoutInflater.Factory2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        super.setFactory2(factory);
        if (getBase().getFactory2() == null) {
            getBase().setFactory2(getFactory2());
            return;
        }
        LayoutInflaterCompat layoutInflaterCompat = LayoutInflaterCompat.INSTANCE;
        LayoutInflater base = getBase();
        LayoutInflater.Factory2 factory2 = getFactory2();
        Intrinsics.checkNotNullExpressionValue(factory2, "factory2");
        layoutInflaterCompat.forceSetFactory2(base, factory2);
    }

    @Override // android.view.LayoutInflater
    public void setFilter(@Nullable LayoutInflater.Filter filter) {
        super.setFilter(filter);
        if (getBase() != null) {
            getBase().setFilter(filter);
        }
    }

    @Override // com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater, android.view.LayoutInflater
    @NotNull
    public View inflate(@NotNull XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        return super.inflate(parser, root, attachToRoot);
    }
}
