package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/n;", "", "T", "Lcom/tencent/guild/aio/halfpop/b;", "menuCtrl", "", "c", "data", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "(Ljava/lang/Object;Lcom/tencent/aio/api/runtime/a;)V", "g", "()Ljava/lang/Object;", "", "a", "(Ljava/lang/Object;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", "Lcom/tencent/guild/aio/halfpop/menu/s;", "itemUIAttrs", "d", "view", "b", "(Landroid/view/View;Ljava/lang/Object;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface n<T> {
    boolean a(@NotNull T data);

    void b(@NotNull View view, @NotNull T data);

    void c(@NotNull com.tencent.guild.aio.halfpop.b menuCtrl);

    void d(@Nullable s itemUIAttrs);

    void e(@NotNull T data, @NotNull com.tencent.aio.api.runtime.a aioContext);

    @NotNull
    View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container);

    @NotNull
    T g();

    void onDestroy();
}
