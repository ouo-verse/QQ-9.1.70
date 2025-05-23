package com.tencent.mobileqq.qqlive.room.frame.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.TraceCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.now.od.ui.game.meleegame.widget.MeleeGameStageView;
import com.tencent.now.od.ui.game.odgame.widget.ODGameStageView;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0004$%\r\u0004B\u0007\u00a2\u0006\u0004\b!\u0010\"J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J,\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\u0003R*\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R(\u0010\u0018\u001a\u0016\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0012\u0004\u0012\u00020\u00150\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/a;", "Landroid/view/LayoutInflater$Factory2;", "Landroid/view/View;", "", "d", HippyNestedScrollComponent.PRIORITY_PARENT, "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "onCreateView", "c", "Ljava/util/HashMap;", "Ljava/util/Deque;", "Ljava/util/HashMap;", "viewCaches", "", "Ljava/io/Serializable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$d;", "e", "Ljava/util/Map;", "viewFactories", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "f", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "logger", "", h.F, "Z", "destroyed", "<init>", "()V", "i", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements LayoutInflater.Factory2 {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final C8370a f271561i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Deque<View>> viewCaches;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Serializable, d> viewFactories;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean destroyed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.frame.activity.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static final class C8370a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ C8370a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        C8370a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$b;", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$d;", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/view/View;", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class b implements d {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.frame.activity.a.d
        @NotNull
        public View a(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, name, context, attrs);
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            return new MeleeGameStageView(context, attrs, 0, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$c;", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$d;", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/view/View;", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class c implements d {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.frame.activity.a.d
        @NotNull
        public View a(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, name, context, attrs);
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            return new ODGameStageView(context, attrs, 0, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/a$d;", "", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/view/View;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private interface d {
        @NotNull
        View a(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/room/frame/activity/a$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<View> f271567e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Deque<View>> f271568f;

        e(Ref.ObjectRef<View> objectRef, Ref.ObjectRef<Deque<View>> objectRef2) {
            this.f271567e = objectRef;
            this.f271568f = objectRef2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, objectRef, objectRef2);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IAegisLogApi iAegisLogApi = a.this.logger;
                Integer num = null;
                if (v3 != null) {
                    str = v3.getClass().getSimpleName();
                } else {
                    str = null;
                }
                if (v3 != null) {
                    num = Integer.valueOf(v3.hashCode());
                }
                iAegisLogApi.i("QQLiveRoomLayoutFactory", str + num + " is attached to window");
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                IAegisLogApi iAegisLogApi = a.this.logger;
                Integer num = null;
                if (v3 != null) {
                    str = v3.getClass().getSimpleName();
                } else {
                    str = null;
                }
                if (v3 != null) {
                    num = Integer.valueOf(v3.hashCode());
                }
                iAegisLogApi.i("QQLiveRoomLayoutFactory", str + num + " is detached to window ,factory destroyed:" + a.this.destroyed);
                this.f271567e.element.removeOnAttachStateChangeListener(this);
                if (a.this.destroyed) {
                    return;
                }
                this.f271568f.element.offer(this.f271567e.element);
                a.this.logger.i("QQLiveRoomLayoutFactory", "offer a view to cache,cache size:" + this.f271568f.element.size());
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f271561i = new C8370a(null);
        }
    }

    public a() {
        Map<Serializable, d> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewCaches = new HashMap<>();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(MeleeGameStageView.class.getName(), new b()), TuplesKt.to(ODGameStageView.class, new c()));
        this.viewFactories = mapOf;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
    }

    private final void d(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            this.logger.i("QQLiveRoomLayoutFactory", "view has parent,remove it");
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.logger.i("QQLiveRoomLayoutFactory", "destroy");
        this.destroyed = true;
        Iterator<Map.Entry<String, Deque<View>>> it = this.viewCaches.entrySet().iterator();
        while (it.hasNext()) {
            Deque<View> value = it.next().getValue();
            if (value != null) {
                value.clear();
            }
        }
        this.viewCaches.clear();
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, name, context, attrs);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object, java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, android.view.View] */
    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View parent, @NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, parent, name, context, attrs);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (!this.viewFactories.keySet().contains(name)) {
            return null;
        }
        TraceCompat.beginSection("create_" + name);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r16 = this.viewCaches.get(name);
        objectRef.element = r16;
        if (r16 == 0) {
            ?? linkedList = new LinkedList();
            objectRef.element = linkedList;
            this.viewCaches.put(name, linkedList);
        }
        this.logger.i("QQLiveRoomLayoutFactory", "create " + name + ",cache size:" + ((Deque) objectRef.element).size());
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ?? poll = ((Deque) objectRef.element).poll();
        objectRef2.element = poll;
        if (poll == 0) {
            d dVar = this.viewFactories.get(name);
            if (dVar == null) {
                this.logger.i("QQLiveRoomLayoutFactory", "no view factory:" + name);
                return null;
            }
            objectRef2.element = dVar.a(name, context, attrs);
        } else {
            IAegisLogApi iAegisLogApi = this.logger;
            View view = (View) poll;
            String simpleName = view != null ? view.getClass().getSimpleName() : null;
            iAegisLogApi.i("QQLiveRoomLayoutFactory", "hit cache," + simpleName + " " + ((View) objectRef2.element).hashCode());
            d((View) objectRef2.element);
        }
        ((View) objectRef2.element).addOnAttachStateChangeListener(new e(objectRef2, objectRef));
        TraceCompat.endSection();
        return (View) objectRef2.element;
    }
}
