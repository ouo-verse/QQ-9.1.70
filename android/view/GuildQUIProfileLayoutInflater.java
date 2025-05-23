package android.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.view.LayoutInflater;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.richframework.layoutinflater.LayoutInflaterCompat;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.quiprofile.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mw1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J$\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0002J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J,\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Landroid/view/GuildQUIProfileLayoutInflater;", "Landroid/view/LayoutInflater;", "original", "newContext", "Landroid/content/Context;", "(Landroid/view/LayoutInflater;Landroid/content/Context;)V", PM.BASE, "cloneInContext", "containGuildActivityWrapper", "", "context", "inflate", "Landroid/view/View;", "resource", "", "root", "Landroid/view/ViewGroup;", "attachToRoot", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "onViewInflated", "", "view", "realInflate", "inflater", "setFactory", "factory", "Landroid/view/LayoutInflater$Factory;", "setFactory2", "Landroid/view/LayoutInflater$Factory2;", "setFilter", "filter", "Landroid/view/LayoutInflater$Filter;", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GuildQUIProfileLayoutInflater extends LayoutInflater {

    @NotNull
    private static final String TAG = "Guild.GuildQUIProfileLayoutInflater";

    @NotNull
    private LayoutInflater base;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildQUIProfileLayoutInflater(@NotNull LayoutInflater original, @NotNull Context newContext) {
        super(original, newContext);
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        LayoutInflater cloneInContext = (original instanceof GuildQUIProfileLayoutInflater ? ((GuildQUIProfileLayoutInflater) original).base : original).cloneInContext(newContext);
        Intrinsics.checkNotNullExpressionValue(cloneInContext, "if (original is GuildQUI\u2026loneInContext(newContext)");
        this.base = cloneInContext;
    }

    private final boolean containGuildActivityWrapper(Context context) {
        if (context instanceof GuildActivityWrapper) {
            return true;
        }
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "base.baseContext");
            if (context instanceof GuildActivityWrapper) {
                return true;
            }
        }
        return false;
    }

    private final void onViewInflated(View view) {
        if (!(view.getResources() instanceof c)) {
            if (!(getContext() instanceof GuildActivityWrapper)) {
                s.e(TAG, "View\u5173\u8054\u7684context\u5fc5\u987b\u662fGuildActivityWrapper", new RuntimeException());
            }
            s.e(TAG, "View\u5173\u8054\u7684Resources\u5fc5\u987b\u662fGuildQUIProfileResources", new RuntimeException());
        }
        a.f417705a.d(view, !Looper.getMainLooper().isCurrentThread());
    }

    private final View realInflate(LayoutInflater inflater, int resource, ViewGroup root, boolean attachToRoot) {
        View realInflate;
        try {
            View inflate = inflater.inflate(resource, root, attachToRoot);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            inflater.i\u2026, attachToRoot)\n        }");
            return inflate;
        } catch (Throwable th5) {
            Context context = inflater.getContext();
            s.e(TAG, "realInflate error", th5);
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "inflate error: context: " + context;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), th5);
            }
            if (context != context.getApplicationContext()) {
                if (context instanceof ContextWrapper) {
                    LayoutInflater cloneInContext = inflater.cloneInContext(((ContextWrapper) context).getBaseContext());
                    Intrinsics.checkNotNullExpressionValue(cloneInContext, "inflater.cloneInContext(context.baseContext)");
                    realInflate = realInflate(cloneInContext, resource, root, attachToRoot);
                } else {
                    LayoutInflater cloneInContext2 = inflater.cloneInContext(context.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(cloneInContext2, "inflater.cloneInContext(\u2026ntext.applicationContext)");
                    realInflate = realInflate(cloneInContext2, resource, root, attachToRoot);
                }
                return realInflate;
            }
            throw th5;
        }
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public LayoutInflater cloneInContext(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        if (!containGuildActivityWrapper(newContext)) {
            Logger.f235387a.d().w(TAG, 1, "newContext\u4e0eGuildActivityWrapper\u65e0\u5173\uff0c\u8fd9\u91cc\u671f\u671b\u662fGuildActivityWrapper");
            return this;
        }
        return new GuildQUIProfileLayoutInflater(this, newContext);
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public View inflate(int resource, @Nullable ViewGroup root, boolean attachToRoot) {
        View realInflate = realInflate(this.base, resource, root, attachToRoot);
        onViewInflated(realInflate);
        return realInflate;
    }

    @Override // android.view.LayoutInflater
    public void setFactory(@NotNull LayoutInflater.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        super.setFactory(factory);
        try {
            this.base.setFactory(factory);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("set base.setFactory error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), th5);
            }
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(@NotNull LayoutInflater.Factory2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        super.setFactory2(factory);
        try {
            if (this.base.getFactory2() == null) {
                this.base.setFactory2(getFactory2());
            } else {
                LayoutInflaterCompat layoutInflaterCompat = LayoutInflaterCompat.INSTANCE;
                LayoutInflater layoutInflater = this.base;
                LayoutInflater.Factory2 factory2 = getFactory2();
                Intrinsics.checkNotNullExpressionValue(factory2, "factory2");
                layoutInflaterCompat.forceSetFactory2(layoutInflater, factory2);
            }
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("set base.setFactory2 error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), th5);
            }
        }
    }

    @Override // android.view.LayoutInflater
    public void setFilter(@Nullable LayoutInflater.Filter filter) {
        super.setFilter(filter);
        LayoutInflater layoutInflater = this.base;
        if (layoutInflater != null) {
            layoutInflater.setFilter(filter);
        }
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public View inflate(@Nullable XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot) {
        View realInflate = realInflate(this.base, parser, root, attachToRoot);
        onViewInflated(realInflate);
        return realInflate;
    }

    private final View realInflate(LayoutInflater inflater, XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        View realInflate;
        try {
            View inflate = inflater.inflate(parser, root, attachToRoot);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            inflater.i\u2026, attachToRoot)\n        }");
            return inflate;
        } catch (Throwable th5) {
            Context context = inflater.getContext();
            s.e(TAG, "realInflate2 error", th5);
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "inflate error: context: " + context;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), th5);
            }
            if (context != context.getApplicationContext()) {
                if (context instanceof ContextWrapper) {
                    LayoutInflater cloneInContext = inflater.cloneInContext(((ContextWrapper) context).getBaseContext());
                    Intrinsics.checkNotNullExpressionValue(cloneInContext, "inflater.cloneInContext(context.baseContext)");
                    realInflate = realInflate(cloneInContext, parser, root, attachToRoot);
                } else {
                    LayoutInflater cloneInContext2 = inflater.cloneInContext(context.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(cloneInContext2, "inflater.cloneInContext(\u2026ntext.applicationContext)");
                    realInflate = realInflate(cloneInContext2, parser, root, attachToRoot);
                }
                return realInflate;
            }
            throw th5;
        }
    }
}
