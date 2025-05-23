package com.tencent.aio.frame.api;

import android.view.View;
import android.view.ViewParent;
import com.tencent.aio.frame.drawer.DrawerFrameViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/frame/api/a;", "", "Lcom/tencent/aio/frame/api/b;", "a", "Lcom/tencent/aio/frame/api/b;", "frameGroup", "Landroid/view/View;", "b", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b frameGroup;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/frame/api/a$a", "Lcom/tencent/aio/frame/api/b;", "", "disallowIntercept", "", "requestDisallowInterceptTouchEvent", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0627a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f69251a;

        C0627a(Ref.ObjectRef objectRef) {
            this.f69251a = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) objectRef);
            }
        }

        @Override // com.tencent.aio.frame.api.b
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, disallowIntercept);
                return;
            }
            ViewParent viewParent = (ViewParent) this.f69251a.element;
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(disallowIntercept);
            }
        }
    }

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.view = view;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.ViewParent, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.ViewParent, T] */
    @Nullable
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        b bVar = this.frameGroup;
        if (bVar != null) {
            return bVar;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.view.getParent();
        while (true) {
            Object obj = objectRef.element;
            if (((ViewParent) obj) == null) {
                break;
            }
            if (((ViewParent) obj) instanceof DrawerFrameViewGroup) {
                this.frameGroup = new C0627a(objectRef);
                break;
            }
            if (((ViewParent) obj) instanceof View) {
            }
            objectRef.element = ((ViewParent) obj).getParent();
        }
        return this.frameGroup;
    }
}
