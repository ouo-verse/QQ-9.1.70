package com.tencent.mobileqq.vas.adv.web;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J?\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR,\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001e0\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/VasAdvWebManager;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "", "businessId", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "subscriber", "", "subscribe", "unsubscribe", "unsubscribeAll", "eventKey", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "callback", "", "", "params", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/ui/TouchWebView;", "getWebView", "removeWebView", "initWebView", "Ljava/lang/ref/SoftReference;", "e", "Ljava/lang/ref/SoftReference;", "webViewRef", "", "", "Ljava/lang/ref/WeakReference;", "f", "Ljava/util/Map;", "eventSubscribers", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvWebManager implements VasAdvWebEvent.Publisher {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SoftReference<TouchWebView> webViewRef;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final VasAdvWebManager f308319d = new VasAdvWebManager();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, List<WeakReference<VasAdvWebEvent.Subscriber>>> eventSubscribers = new LinkedHashMap();

    VasAdvWebManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        TouchWebView touchWebView;
        SoftReference<TouchWebView> softReference = webViewRef;
        TouchWebView touchWebView2 = null;
        if (softReference != null) {
            touchWebView = softReference.get();
        } else {
            touchWebView = null;
        }
        if (touchWebView == null) {
            View g16 = VasAdvSupport.INSTANCE.a().g();
            if (g16 instanceof TouchWebView) {
                touchWebView2 = (TouchWebView) g16;
            }
            if (touchWebView2 != null) {
                webViewRef = new SoftReference<>(touchWebView2);
            }
        }
    }

    public final void c(@NotNull String businessId, @NotNull String eventKey, @Nullable VasAdvWebEvent.Callback callback, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(params, "params");
        List<WeakReference<VasAdvWebEvent.Subscriber>> list = eventSubscribers.get(businessId);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                VasAdvWebEvent.Subscriber subscriber = (VasAdvWebEvent.Subscriber) ((WeakReference) it.next()).get();
                if (subscriber != null) {
                    subscriber.onVasEvent(eventKey, callback, Arrays.copyOf(params, params.length));
                }
            }
        }
    }

    @Nullable
    public final TouchWebView getWebView(@NotNull Activity activity) {
        TouchWebView touchWebView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SoftReference<TouchWebView> softReference = webViewRef;
        ViewGroup viewGroup = null;
        if (softReference == null || (touchWebView = softReference.get()) == null) {
            return null;
        }
        WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
        if (pluginEngine != null) {
            pluginEngine.J(null, activity, null);
        }
        ViewParent parent = touchWebView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(touchWebView);
        }
        return touchWebView;
    }

    public final void initWebView() {
        c.a.b(VasAdvSupport.INSTANCE.a(), new Runnable() { // from class: com.tencent.mobileqq.vas.adv.web.a
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvWebManager.b();
            }
        }, 0L, 2, null);
    }

    public final void removeWebView() {
        TouchWebView touchWebView;
        SoftReference<TouchWebView> softReference = webViewRef;
        if (softReference != null && (touchWebView = softReference.get()) != null) {
            WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
            ViewGroup viewGroup = null;
            if (pluginEngine != null) {
                pluginEngine.f314119i = null;
            }
            ViewParent parent = touchWebView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(touchWebView);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void subscribe(@NotNull String businessId, @NotNull VasAdvWebEvent.Subscriber subscriber) {
        List<WeakReference<VasAdvWebEvent.Subscriber>> mutableListOf;
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Map<String, List<WeakReference<VasAdvWebEvent.Subscriber>>> map = eventSubscribers;
        List<WeakReference<VasAdvWebEvent.Subscriber>> list = map.get(businessId);
        if (list == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WeakReference(subscriber));
            map.put(businessId, mutableListOf);
        } else {
            list.add(new WeakReference<>(subscriber));
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void unsubscribe(@NotNull String businessId, @NotNull final VasAdvWebEvent.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        List<WeakReference<VasAdvWebEvent.Subscriber>> list = eventSubscribers.get(businessId);
        if (list != null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<WeakReference<VasAdvWebEvent.Subscriber>, Boolean>() { // from class: com.tencent.mobileqq.vas.adv.web.VasAdvWebManager$unsubscribe$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WeakReference<VasAdvWebEvent.Subscriber> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.get(), VasAdvWebEvent.Subscriber.this));
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
    public void unsubscribeAll(@NotNull String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        List<WeakReference<VasAdvWebEvent.Subscriber>> list = eventSubscribers.get(businessId);
        if (list != null) {
            list.clear();
        }
    }
}
