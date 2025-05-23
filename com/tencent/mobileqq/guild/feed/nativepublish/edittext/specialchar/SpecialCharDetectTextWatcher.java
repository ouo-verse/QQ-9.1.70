package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import androidx.core.util.Supplier;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.guild.feed.util.framework.route.InterfaceRouterImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0002\u000e\u0019B\u0015\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!\u00a2\u0006\u0004\b5\u00106J)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0006\u0010\u0019\u001a\u00020\u0007J>\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b\"\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher;", "Landroid/text/TextWatcher;", "Landroid/text/InputFilter;", "", "actionName", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "", "Lkotlin/ExtensionFunctionType;", "action", "c", "Landroidx/core/util/Supplier;", "Landroid/text/Editable;", "supplier", "a", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "afterTextChanged", "b", "source", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "", "d", "[Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "plugins", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/InterfaceRouterImpl;", "e", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/InterfaceRouterImpl;", "getPluginRouter", "()Lcom/tencent/mobileqq/guild/feed/util/framework/route/InterfaceRouterImpl;", "pluginRouter", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "activePlugin", "", tl.h.F, "Z", "getHasDetectBarrier", "()Z", "(Z)V", "hasDetectBarrier", "<init>", "([Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpecialCharDetectTextWatcher implements TextWatcher, InputFilter {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f221930i = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b[] plugins;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceRouterImpl pluginRouter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b activePlugin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasDetectBarrier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public SpecialCharDetectTextWatcher(@NotNull b[] plugins) {
        Intrinsics.checkNotNullParameter(plugins, "plugins");
        this.plugins = plugins;
        this.pluginRouter = new InterfaceRouterImpl();
        for (b bVar : plugins) {
            this.pluginRouter.a(bVar.getClass(), bVar);
        }
    }

    private final void c(String actionName, Function1<? super b, Unit> action) {
        boolean z16;
        boolean z17;
        if (!this.hasDetectBarrier) {
            b[] bVarArr = this.plugins;
            int length = bVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (bVarArr[i3].getHasDetectBarrier()) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                b bVar = this.activePlugin;
                String str = null;
                if (bVar != null) {
                    if (!bVar.d()) {
                        bVar = null;
                    }
                    if (bVar != null) {
                        action.invoke(bVar);
                    }
                }
                b bVar2 = this.activePlugin;
                if (bVar2 != null && bVar2.d()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    b bVar3 = this.activePlugin;
                    if (bVar3 != null) {
                        str = bVar3.getClass().getSimpleName();
                    }
                    QLog.i("SpecialCharDetectTextWatcher", 1, "dispatchChangedToPlugin|plugin:" + str + " active");
                    return;
                }
                b bVar4 = this.activePlugin;
                if (bVar4 != null) {
                    bVar4.f();
                }
                this.activePlugin = null;
                for (b bVar5 : this.plugins) {
                    action.invoke(bVar5);
                    if (bVar5.d()) {
                        bVar5.e();
                        this.activePlugin = bVar5;
                        return;
                    }
                }
                return;
            }
        }
        QLog.i("SpecialCharDetectTextWatcher", 1, actionName + ".hasDetectBarrier");
    }

    public final void a(@NotNull Supplier<Editable> supplier) {
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        for (b bVar : this.plugins) {
            bVar.g(supplier);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NotNull final Editable text) {
        Intrinsics.checkNotNullParameter(text, "text");
        c("afterTextChanged", new Function1<b, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher$afterTextChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpecialCharDetectTextWatcher.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpecialCharDetectTextWatcher.b dispatchChangedToPlugin) {
                Intrinsics.checkNotNullParameter(dispatchChangedToPlugin, "$this$dispatchChangedToPlugin");
                dispatchChangedToPlugin.afterTextChanged(text);
            }
        });
    }

    public final void b() {
        c("beforePaste", new Function1<b, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher$beforePaste$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpecialCharDetectTextWatcher.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpecialCharDetectTextWatcher.b dispatchChangedToPlugin) {
                Intrinsics.checkNotNullParameter(dispatchChangedToPlugin, "$this$dispatchChangedToPlugin");
                dispatchChangedToPlugin.a();
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull final CharSequence text, final int start, final int count, final int after) {
        Intrinsics.checkNotNullParameter(text, "text");
        c("beforeTextChange", new Function1<b, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher$beforeTextChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpecialCharDetectTextWatcher.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpecialCharDetectTextWatcher.b dispatchChangedToPlugin) {
                Intrinsics.checkNotNullParameter(dispatchChangedToPlugin, "$this$dispatchChangedToPlugin");
                dispatchChangedToPlugin.beforeTextChanged(text, start, count, after);
            }
        });
    }

    public final void d(boolean z16) {
        this.hasDetectBarrier = z16;
    }

    @Override // android.text.InputFilter
    @Nullable
    public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
        if (this.hasDetectBarrier) {
            return null;
        }
        CharSequence charSequence = source;
        int i3 = start;
        int i16 = end;
        for (b bVar : this.plugins) {
            CharSequence filter = bVar.filter(charSequence, i3, i16, dest, dstart, dend);
            if (filter != null) {
                i3 = 0;
                charSequence = filter;
                i16 = filter.length();
            }
        }
        if (charSequence == source) {
            return null;
        }
        return charSequence;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull final CharSequence text, final int start, final int before, final int count) {
        Intrinsics.checkNotNullParameter(text, "text");
        c("onTextChanged", new Function1<b, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher$onTextChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpecialCharDetectTextWatcher.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpecialCharDetectTextWatcher.b dispatchChangedToPlugin) {
                Intrinsics.checkNotNullParameter(dispatchChangedToPlugin, "$this$dispatchChangedToPlugin");
                dispatchChangedToPlugin.onTextChanged(text, start, before, count);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J>\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\u00198&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001d\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "Landroid/text/TextWatcher;", "Landroid/text/InputFilter;", "", "e", "f", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "a", "source", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "", "d", "Z", "c", "()Z", "setHasDetectBarrier", "(Z)V", "hasDetectBarrier", "Landroidx/core/util/Supplier;", "Landroidx/core/util/Supplier;", "b", "()Landroidx/core/util/Supplier;", "g", "(Landroidx/core/util/Supplier;)V", "editablePeeker", "isActivatable", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class b implements TextWatcher, InputFilter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean hasDetectBarrier;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public Supplier<Editable> editablePeeker;

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable text) {
            Intrinsics.checkNotNullParameter(text, "text");
        }

        @NotNull
        public final Supplier<Editable> b() {
            Supplier<Editable> supplier = this.editablePeeker;
            if (supplier != null) {
                return supplier;
            }
            Intrinsics.throwUninitializedPropertyAccessException("editablePeeker");
            return null;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence text, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(text, "text");
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHasDetectBarrier() {
            return this.hasDetectBarrier;
        }

        public abstract boolean d();

        @Nullable
        public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
            return null;
        }

        public final void g(@NotNull Supplier<Editable> supplier) {
            Intrinsics.checkNotNullParameter(supplier, "<set-?>");
            this.editablePeeker = supplier;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence text, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(text, "text");
        }

        public void a() {
        }

        public void e() {
        }

        public void f() {
        }
    }
}
