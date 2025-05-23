package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import androidx.annotation.CallSuper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.guild.feed.util.bf;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u00052\u00020\u0006B)\u0012 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001\u0018\u00010\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\u000b\u001a\u00020\n2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0017R2\u0010\u0012\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001\u0018\u00010\r8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R,\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0018\u0010\u001cR\"\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/guild/feed/util/bf;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", Node.CHILDREN_ATTR, "Lcom/tencent/mobileqq/guild/feed/util/a;", "Lcom/tencent/mobileqq/guild/feed/util/a;", "getActionSubscribeWrapper", "()Lcom/tencent/mobileqq/guild/feed/util/a;", "actionSubscribeWrapper", "f", "Lcom/tencent/base/api/runtime/a;", "c", "()Lcom/tencent/base/api/runtime/a;", "(Lcom/tencent/base/api/runtime/a;)V", "nullableContext", "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a implements f<com.tencent.base.api.runtime.a<zl1.a>>, g, bf {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<f<com.tencent.base.api.runtime.a<zl1.a>>> children;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.util.a actionSubscribeWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.base.api.runtime.a<zl1.a> context;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void E(@NotNull MsgIntent msgIntent) {
        bf.a.a(this, msgIntent);
    }

    @NotNull
    public k I(@NotNull MsgIntent msgIntent) {
        return bf.a.b(this, msgIntent);
    }

    @Nullable
    protected List<f<com.tencent.base.api.runtime.a<zl1.a>>> a() {
        return this.children;
    }

    @NotNull
    public final com.tencent.base.api.runtime.a<zl1.a> c() {
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.context;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.base.api.runtime.a<zl1.a> d() {
        if (this.context != null) {
            return c();
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        f(context);
        List<f<com.tencent.base.api.runtime.a<zl1.a>>> a16 = a();
        if (a16 != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(context, reuse);
            }
        }
        com.tencent.mobileqq.guild.feed.util.a aVar = this.actionSubscribeWrapper;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        aVar.b(e16);
    }

    public final void f(@NotNull com.tencent.base.api.runtime.a<zl1.a> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.context = aVar;
    }

    public /* synthetic */ Set getSubscribeEventNames() {
        return com.tencent.mvi.base.route.f.a(this);
    }

    public /* synthetic */ Set getSubscribeEventRNames() {
        return com.tencent.mvi.base.route.f.b(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
    
        r0 = kotlin.collections.CollectionsKt__ReversedViewsKt.asReversed(r0);
     */
    @Override // com.tencent.input.base.mvicompat.f
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroy() {
        List asReversed;
        com.tencent.mobileqq.guild.feed.util.a aVar = this.actionSubscribeWrapper;
        j e16 = c().e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        aVar.e(e16);
        List<f<com.tencent.base.api.runtime.a<zl1.a>>> a16 = a();
        if (a16 != null && asReversed != null) {
            Iterator it = asReversed.iterator();
            while (it.hasNext()) {
                ((f) it.next()).onDestroy();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable List<? extends f<com.tencent.base.api.runtime.a<zl1.a>>> list) {
        this.children = list;
        this.actionSubscribeWrapper = new com.tencent.mobileqq.guild.feed.util.a(this);
    }

    public /* synthetic */ a(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
