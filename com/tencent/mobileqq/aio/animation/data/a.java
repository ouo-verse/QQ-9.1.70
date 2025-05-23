package com.tencent.mobileqq.aio.animation.data;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0006H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/a;", "", "Landroid/content/Context;", "getContext", "Landroid/view/ViewGroup;", "getParent", "", "getInputBarHeight", "V0", "", "Lcom/tencent/mobileqq/aio/animation/data/a$a;", "j0", "Landroid/view/View$OnLayoutChangeListener;", "listener", "", "Y0", "l", "getWidth", "a", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "msgId", "b", "Z", "c", "()Z", NodeProps.VISIBLE, "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "<init>", "(JZLandroid/graphics/Rect;)V", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final /* data */ class C7235a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect rect;

        public C7235a(long j3, boolean z16, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Boolean.valueOf(z16), rect);
                return;
            }
            this.msgId = j3;
            this.visible = z16;
            this.rect = rect;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.msgId;
        }

        @NotNull
        public final Rect b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Rect) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.rect;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.visible;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C7235a)) {
                return false;
            }
            C7235a c7235a = (C7235a) other;
            if (this.msgId == c7235a.msgId && this.visible == c7235a.visible && Intrinsics.areEqual(this.rect, c7235a.rect)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int a16 = androidx.fragment.app.a.a(this.msgId) * 31;
            boolean z16 = this.visible;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((a16 + i3) * 31) + this.rect.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "AIOMsgItemRect(msgId=" + this.msgId + ", visible=" + this.visible + ", rect=" + this.rect + ")";
        }
    }

    int V0();

    void Y0(@NotNull View.OnLayoutChangeListener listener);

    @NotNull
    Context getContext();

    int getInputBarHeight();

    @NotNull
    ViewGroup getParent();

    int getWidth();

    @NotNull
    List<C7235a> j0();

    void l(@NotNull View.OnLayoutChangeListener listener);
}
