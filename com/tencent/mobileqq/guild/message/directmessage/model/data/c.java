package com.tencent.mobileqq.guild.message.directmessage.model.data;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B)\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u000e\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0006H\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0003J\u0011\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010\u0013\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001J\u0017\u0010\u0014\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/c;", "", "", "", "i", DTConstants.TAG.ELEMENT, "", "a", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "addAll", "", QCircleLpReportDc05507.KEY_CLEAR, "d", "containsAll", "isEmpty", "", "iterator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "removeAll", "retainAll", "g", "o", DomainData.DOMAIN_NAME, "toString", "Ljava/util/Set;", "set", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "onLoaded", "f", "Z", "isLoaded", "", h.F, "()I", "size", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements Set<String>, KMutableSet {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> set;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> onLoaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isLoaded;

    public c(@NotNull Set<String> set, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.set = set;
        this.onLoaded = function0;
    }

    private final Set<String> i() {
        long uptimeMillis = SystemClock.uptimeMillis();
        Set<String> E = bw.E();
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("InvisibleNotifyTypeSet", 2, "loadSetFromSp measureTime:" + uptimeMillis2 + " guildIdSet:" + E);
        }
        return E;
    }

    @Override // java.util.Set, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(@NotNull String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.set.add(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends String> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.set.addAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.set.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return d((String) obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.set.containsAll(elements);
    }

    public boolean d(@NotNull String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.set.contains(element);
    }

    public final void g() {
        if (!this.isLoaded) {
            synchronized (this) {
                if (this.isLoaded) {
                    return;
                }
                this.set.clear();
                this.set.addAll(i());
                this.isLoaded = true;
                Function0<Unit> function0 = this.onLoaded;
                if (function0 != null) {
                    function0.invoke();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public int h() {
        return this.set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<String> iterator() {
        return this.set.iterator();
    }

    public boolean m(@NotNull String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.set.remove(element);
    }

    public final void n() {
        this.isLoaded = false;
    }

    public final void o() {
        bw.l1(this.set);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return m((String) obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.set.removeAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.set.retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return h();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @NotNull
    public String toString() {
        return "InvisibleNotifyTypeSet: " + this.isLoaded + " " + this.set;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public /* synthetic */ c(Set set, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new CopyOnWriteArraySet() : set, (i3 & 2) != 0 ? null : function0);
    }
}
