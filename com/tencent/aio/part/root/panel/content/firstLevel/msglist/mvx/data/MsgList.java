package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010\tJ(\u0010\u0007\u001a\u00020\u00062 \u0010\u0005\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0018\u00010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u0016\u0010\u0018\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u001cH\u0017J\u0016\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0017J\u0016\u0010!\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u001b\u0010\"\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R0\u0010\u0005\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(\u00a8\u0006*"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/aio/data/msglist/a;", "Lkotlin/Function1;", "", "filter", "", "setFilter", "assertThread$sdk_debug", "()V", "assertThread", DTConstants.TAG.ELEMENT, "", "add", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "addAll", "", "index", "", "c", "addAllAbsent", "e", "addIfAbsent", "addWithFilter", "addAllWithFilter", "remove", "removeAll", "removeAt", "Ljava/util/function/Predicate;", "removeIf", "Ljava/util/function/UnaryOperator;", JsonRuleKey.OPERATOR, "replaceAll", "retainAll", "set", "Lkotlin/jvm/functions/Function1;", "isNeedCrash", "Z", "()Z", "setNeedCrash", "(Z)V", "<init>", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class MsgList extends CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> {
    static IPatchRedirector $redirector_;
    private Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> filter;
    private boolean isNeedCrash;

    public MsgList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.isNeedCrash = true;
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> elements) {
        Collection<? extends com.tencent.aio.data.msglist.a> invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) elements)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null && (invoke = function1.invoke(elements)) != null) {
            elements = invoke;
        }
        return super.addAll(elements);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList
    public int addAllAbsent(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> c16) {
        Collection<? extends com.tencent.aio.data.msglist.a> invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) c16)).intValue();
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null && (invoke = function1.invoke(c16)) != null) {
            c16 = invoke;
        }
        return super.addAllAbsent(c16);
    }

    @Deprecated(message = "\u4e0d\u518d\u9700\u8981\u6b64\u63a5\u53e3\uff0c\u8bf7\u76f4\u63a5\u4f7f\u7528 addAll")
    public final void addAllWithFilter(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> elements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) elements);
            return;
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 == null) {
            addAll(elements);
        } else {
            Intrinsics.checkNotNull(function1);
            addAll(function1.invoke(elements));
        }
    }

    @Deprecated(message = "\u4e0d\u518d\u9700\u8981\u6b64\u63a5\u53e3\uff0c\u8bf7\u76f4\u63a5\u4f7f\u7528 add")
    public final void addWithFilter(@NotNull com.tencent.aio.data.msglist.a element) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) element);
            return;
        }
        Intrinsics.checkNotNullParameter(element, "element");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 == null) {
            add(element);
            return;
        }
        Intrinsics.checkNotNull(function1);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
        addAll(function1.invoke(listOf));
    }

    public final void assertThread$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!zs.b.a(Dispatchers.INSTANCE).g()) {
            if (!this.isNeedCrash) {
                com.tencent.aio.base.log.a.f69187b.e("MsgList", "access MsgList at illegal thread");
                return;
            }
            throw new IllegalStateException("access MsgList at illegal thread");
        }
    }

    public /* bridge */ boolean contains(com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? super.contains((Object) aVar) : ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) aVar)).booleanValue();
    }

    public /* bridge */ int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return super.size();
    }

    public /* bridge */ int indexOf(com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? super.indexOf((Object) aVar) : ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar)).intValue();
    }

    public final boolean isNeedCrash() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.isNeedCrash;
    }

    public /* bridge */ int lastIndexOf(com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) ? super.lastIndexOf((Object) aVar) : ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar)).intValue();
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ com.tencent.aio.data.msglist.a remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? remove(i3) : (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 18, (Object) this, i3);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) elements)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        return super.removeAll(elements);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    @NotNull
    /* renamed from: removeAt, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.data.msglist.a remove(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 17, (Object) this, index);
        }
        assertThread$sdk_debug();
        Object remove = super.remove(index);
        Intrinsics.checkNotNullExpressionValue(remove, "super.removeAt(index)");
        return (com.tencent.aio.data.msglist.a) remove;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.Collection
    @RequiresApi(24)
    public boolean removeIf(@NotNull Predicate<? super com.tencent.aio.data.msglist.a> filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) filter)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        assertThread$sdk_debug();
        return super.removeIf(filter);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    @RequiresApi(24)
    public void replaceAll(@NotNull UnaryOperator<com.tencent.aio.data.msglist.a> operator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) operator);
            return;
        }
        Intrinsics.checkNotNullParameter(operator, "operator");
        assertThread$sdk_debug();
        super.replaceAll(operator);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) elements)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        return super.retainAll(elements);
    }

    public final void setFilter(@Nullable Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) filter);
        } else {
            this.filter = filter;
        }
    }

    public final void setNeedCrash(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.isNeedCrash = z16;
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return getSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r0 != null) goto L14;
     */
    @Override // java.util.concurrent.CopyOnWriteArrayList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean addIfAbsent(@NotNull com.tencent.aio.data.msglist.a e16) {
        List listOf;
        List list;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(e16);
            list = function1.invoke(listOf2);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(e16);
        list = listOf;
        return super.addAllAbsent(list) > 0;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, obj)).booleanValue();
        }
        if (obj != null ? obj instanceof com.tencent.aio.data.msglist.a : true) {
            return contains((com.tencent.aio.data.msglist.a) obj);
        }
        return false;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, obj)).intValue();
        }
        if (obj != null ? obj instanceof com.tencent.aio.data.msglist.a : true) {
            return indexOf((com.tencent.aio.data.msglist.a) obj);
        }
        return -1;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, obj)).intValue();
        }
        if (obj != null ? obj instanceof com.tencent.aio.data.msglist.a : true) {
            return lastIndexOf((com.tencent.aio.data.msglist.a) obj);
        }
        return -1;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    @NotNull
    public com.tencent.aio.data.msglist.a set(int index, @Nullable com.tencent.aio.data.msglist.a element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 22, (Object) this, index, (Object) element);
        }
        assertThread$sdk_debug();
        Object obj = super.set(index, (int) element);
        Intrinsics.checkNotNullExpressionValue(obj, "super.set(index, element)");
        return (com.tencent.aio.data.msglist.a) obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r0 != null) goto L14;
     */
    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean add(@NotNull com.tencent.aio.data.msglist.a element) {
        List listOf;
        List list;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) element)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(element);
            list = function1.invoke(listOf2);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
        list = listOf;
        return super.addAll(list);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends com.tencent.aio.data.msglist.a> elements) {
        Collection<? extends com.tencent.aio.data.msglist.a> invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, index, (Object) elements)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null && (invoke = function1.invoke(elements)) != null) {
            elements = invoke;
        }
        return super.addAll(index, elements);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, obj)).booleanValue();
        }
        if (obj != null ? obj instanceof com.tencent.aio.data.msglist.a : true) {
            return remove((com.tencent.aio.data.msglist.a) obj);
        }
        return false;
    }

    public boolean remove(@Nullable com.tencent.aio.data.msglist.a element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) element)).booleanValue();
        }
        assertThread$sdk_debug();
        return super.remove((Object) element);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r0 != null) goto L14;
     */
    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void add(int index, @NotNull com.tencent.aio.data.msglist.a element) {
        List listOf;
        List list;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, index, (Object) element);
            return;
        }
        Intrinsics.checkNotNullParameter(element, "element");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 != null) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(element);
            list = function1.invoke(listOf2);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
        list = listOf;
        super.addAll(index, list);
    }

    @Deprecated(message = "\u4e0d\u518d\u9700\u8981\u6b64\u63a5\u53e3\uff0c\u8bf7\u76f4\u63a5\u4f7f\u7528 addAll")
    public final void addAllWithFilter(int index, @NotNull Collection<? extends com.tencent.aio.data.msglist.a> elements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, index, (Object) elements);
            return;
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        assertThread$sdk_debug();
        Function1<? super Collection<? extends com.tencent.aio.data.msglist.a>, ? extends Collection<? extends com.tencent.aio.data.msglist.a>> function1 = this.filter;
        if (function1 == null) {
            addAll(index, elements);
        } else {
            Intrinsics.checkNotNull(function1);
            addAll(0, function1.invoke(elements));
        }
    }
}
