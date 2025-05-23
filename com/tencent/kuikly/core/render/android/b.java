package com.tencent.kuikly.core.render.android;

import android.content.Context;
import com.tencent.tdf.module.TDFBaseModule;
import com.tencent.tdf.module.TDFModuleProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J \u0010\u000e\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002H&J6\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0004H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0001H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0013H&J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/b;", "Li01/d;", "", "name", "Lkotlin/Function0;", "Li01/a;", "creator", "", "a", "Ljava/lang/Class;", "Lcom/tencent/tdf/module/TDFBaseModule;", "clazz", "Lcom/tencent/tdf/module/TDFModuleProvider;", "provider", "f", "moduleName", "b", "viewName", "Lkotlin/Function1;", "Landroid/content/Context;", "Li01/c;", "renderViewExportCreator", "Li01/b;", "shadowExportCreator", "g", "handler", "d", "createModule", "context", "i", tl.h.F, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b extends i01.d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b bVar, String str, Function1 function1, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    function0 = null;
                }
                bVar.g(str, function1, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderViewExport");
        }
    }

    void a(@NotNull String name, @NotNull Function0<? extends i01.a> creator);

    @NotNull
    TDFBaseModule b(@NotNull String moduleName);

    @NotNull
    i01.a createModule(@NotNull String name);

    void d(@NotNull i01.d handler);

    void f(@NotNull Class<? extends TDFBaseModule> clazz, @NotNull TDFModuleProvider provider);

    void g(@NotNull String viewName, @NotNull Function1<? super Context, ? extends i01.c> renderViewExportCreator, @Nullable Function0<? extends i01.b> shadowExportCreator);

    @NotNull
    i01.b h(@NotNull String name);

    @NotNull
    i01.c i(@NotNull String name, @NotNull Context context);
}
