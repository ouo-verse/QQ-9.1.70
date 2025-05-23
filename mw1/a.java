package mw1;

import android.content.res.Resources;
import android.util.Log;
import android.view.GuildQUIProfileLayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lmw1/a;", "", "Landroid/view/View;", "view", "", "g", "", "c", h.F, "Lmw1/b;", "helper", "i", "immediate", "d", "f", "", "b", "I", "profileThemeIdTagKey", "", "Lmw1/c;", "Ljava/util/List;", "guildQUIProfiler", "mw1/a$a", "Lmw1/a$a;", "onAttachStateChangeListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f417705a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int profileThemeIdTagKey = R.id.wuv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<c> guildQUIProfiler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ViewOnAttachStateChangeListenerC10808a onAttachStateChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"mw1/a$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mw1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class ViewOnAttachStateChangeListenerC10808a implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC10808a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            a aVar = a.f417705a;
            if (aVar.c(v3)) {
                aVar.g(v3);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    static {
        List<c> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{nw1.c.f421453d, nw1.b.f421452d, nw1.d.f421454d, nw1.a.f421451d, ow1.a.f424213d, ow1.b.f424214d, e.f417710d, d.f417709d});
        guildQUIProfiler = listOf;
        onAttachStateChangeListener = new ViewOnAttachStateChangeListenerC10808a();
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(View view) {
        String currentThemeId = QQTheme.getCurrentThemeId();
        int i3 = profileThemeIdTagKey;
        if (Intrinsics.areEqual(currentThemeId, view.getTag(i3))) {
            return false;
        }
        view.setTag(i3, currentThemeId);
        return true;
    }

    public static /* synthetic */ void e(a aVar, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.d(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(View view) {
        h(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(child, "child");
                g(child);
            }
        }
    }

    private final void h(View view) {
        Resources resources = view.getContext().getResources();
        if (resources instanceof com.tencent.mobileqq.guild.quiprofile.c) {
            com.tencent.mobileqq.guild.quiprofile.d helper = ((com.tencent.mobileqq.guild.quiprofile.c) resources).getHelper();
            helper.g();
            i(view, helper);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i(View view, b helper) {
        if (view instanceof ViewStub) {
            ViewStub viewStub = (ViewStub) view;
            if (!(viewStub.getLayoutInflater() instanceof GuildQUIProfileLayoutInflater)) {
                viewStub.setLayoutInflater(LayoutInflater.from(view.getContext()));
            }
        }
        Iterator<T> it = guildQUIProfiler.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(view, helper);
        }
        if (view instanceof c) {
            ((c) view).a(view, helper);
        }
    }

    @JvmOverloads
    public final void d(@Nullable View view, boolean immediate) {
        if (view == null) {
            return;
        }
        ViewOnAttachStateChangeListenerC10808a viewOnAttachStateChangeListenerC10808a = onAttachStateChangeListener;
        view.removeOnAttachStateChangeListener(viewOnAttachStateChangeListenerC10808a);
        view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC10808a);
        if (!immediate && !view.isAttachedToWindow()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildQUIThemeProfiler", "delay profile, " + view);
            }
            Resources resources = view.getResources();
            if (resources instanceof com.tencent.mobileqq.guild.quiprofile.c) {
                ((com.tencent.mobileqq.guild.quiprofile.c) resources).getHelper().g();
                return;
            }
            return;
        }
        if (!c(view)) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildQUIThemeProfiler", "not need profile, " + view);
                return;
            }
            return;
        }
        g(view);
    }

    public final void f(@Nullable View view) {
        d(view, true);
    }
}
