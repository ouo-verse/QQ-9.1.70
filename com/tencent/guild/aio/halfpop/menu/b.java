package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0004R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\b\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010%R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006-"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/b;", "", "T", "Lcom/tencent/guild/aio/halfpop/menu/n;", "Lcom/tencent/guild/aio/halfpop/b;", "menuCtrl", "", "c", "data", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "(Ljava/lang/Object;Lcom/tencent/aio/api/runtime/a;)V", "g", "()Ljava/lang/Object;", "", "a", "(Ljava/lang/Object;)Z", "Lcom/tencent/guild/aio/halfpop/menu/s;", "itemUIAttrs", "d", "Landroid/view/View;", "view", "b", "(Landroid/view/View;Ljava/lang/Object;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "attr", DomainData.DOMAIN_NAME, "Lcom/tencent/guild/aio/halfpop/b;", "j", "()Lcom/tencent/guild/aio/halfpop/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/guild/aio/halfpop/b;)V", "hostCtrl", "Ljava/lang/Object;", "i", "l", "(Ljava/lang/Object;)V", "Lcom/tencent/aio/api/runtime/a;", tl.h.F, "()Lcom/tencent/aio/api/runtime/a;", "k", "(Lcom/tencent/aio/api/runtime/a;)V", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class b<T> implements n<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public com.tencent.guild.aio.halfpop.b hostCtrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public T data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public com.tencent.aio.api.runtime.a aioContext;

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public boolean a(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return true;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public void b(@NotNull View view, @NotNull T data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public void c(@NotNull com.tencent.guild.aio.halfpop.b menuCtrl) {
        Intrinsics.checkNotNullParameter(menuCtrl, "menuCtrl");
        m(menuCtrl);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public void e(@NotNull T data, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        l(data);
        k(aioContext);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public T g() {
        return i();
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a h() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        return null;
    }

    @NotNull
    public final T i() {
        T t16 = this.data;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return (T) Unit.INSTANCE;
    }

    @NotNull
    public final com.tencent.guild.aio.halfpop.b j() {
        com.tencent.guild.aio.halfpop.b bVar = this.hostCtrl;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hostCtrl");
        return null;
    }

    public final void k(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.aioContext = aVar;
    }

    public final void l(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<set-?>");
        this.data = t16;
    }

    public final void m(@NotNull com.tencent.guild.aio.halfpop.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.hostCtrl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n(@Nullable Object attr) {
        if (attr != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public void onDestroy() {
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    public void d(@Nullable s itemUIAttrs) {
    }
}
