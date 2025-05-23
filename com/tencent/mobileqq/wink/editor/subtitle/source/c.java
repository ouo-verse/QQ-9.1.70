package com.tencent.mobileqq.wink.editor.subtitle.source;

import androidx.annotation.CallSuper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0017R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/c;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "child", "", "b", "cancel", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getCancelSelf", "()Lkotlin/jvm/functions/Function0;", "c", "(Lkotlin/jvm/functions/Function0;)V", "cancelSelf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", Node.CHILDREN_ATTR, "", "f", "Z", "a", "()Z", "(Z)V", "canceled", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class c implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> cancelSelf;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> children = new ArrayList<>(1);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean canceled;

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    /* renamed from: a, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.b
    public void b(@Nullable a child) {
        if (!getCanceled() && child != null && !this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public final void c(@Nullable Function0<Unit> function0) {
        this.cancelSelf = function0;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    @CallSuper
    public void cancel() {
        Iterator<a> it = this.children.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.getCanceled()) {
                w53.b.c("ChainCancelable", "cancel child");
                next.cancel();
            }
        }
        this.children.clear();
        w53.b.c("ChainCancelable", "cancel self");
        Function0<Unit> function0 = this.cancelSelf;
        if (function0 != null) {
            function0.invoke();
        }
        d(true);
    }

    public void d(boolean z16) {
        this.canceled = z16;
    }
}
