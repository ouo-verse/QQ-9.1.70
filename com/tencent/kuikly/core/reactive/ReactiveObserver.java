package com.tencent.kuikly.core.reactive;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import oicq.wlogin_sdk.tools.util;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\bM\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J.\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0014\u0010\u000b\u001a\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\nH\u0002J<\u0010\u000e\u001a\u0018\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n\u0018\u00010\r2\u0014\u0010\u000b\u001a\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00020\bj\u0002`\u000fH\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\n\u0010\u0013\u001a\u00060\u0005j\u0002`\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0015\u001a\u00020\u00022\n\u0010\u0013\u001a\u00060\u0005j\u0002`\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J.\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u001c\u0010\u0018\u001a\u0018\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n\u0018\u00010\u0017H\u0002J\u001c\u0010\u001a\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0005j\u0002`\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J?\u0010\"\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u001c\u001a\u00020\u00012!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001dJ1\u0010%\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u00012!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00020\u001dJ\u000e\u0010&\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0001J\u0014\u0010(\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ$\u0010)\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00012\u0014\u0010\u000b\u001a\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\nJ\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001J\u000f\u0010+\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0080\u0001\u00108\u001an\u0012\u0004\u0012\u00020\u0005\u0012,\u0012*\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\t0\b03j\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n`402j6\u0012\u0004\u0012\u00020\u0005\u0012,\u0012*\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\t0\b03j\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n`4`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107Rp\u0010;\u001a^\u0012\u0004\u0012\u000209\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b03j\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\bj\u0002`\u000f`402j.\u0012\u0004\u0012\u000209\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b03j\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\bj\u0002`\u000f`4`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00107RX\u0010=\u001aF\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001702j\"\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u0001j\u0002`\t0\bj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00107R0\u0010B\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0>j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010J\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010G\u001a\u0004\bH\u0010IR(\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u0010G\u001a\u0004\bK\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/kuikly/core/reactive/ReactiveObserver;", "", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "propertyName", "observerFnOwner", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/reactive/Observer;", "Lcom/tencent/kuikly/core/reactive/ObserverFn;", "observerFn", h.F, "", DomainData.DOMAIN_NAME, "Lcom/tencent/kuikly/core/reactive/ObserverRemoveFn;", "observerRemoveFn", "o", "Lcom/tencent/kuikly/core/reactive/PropertyOwner;", "propertyOwner", "u", "v", "propertyKey", "", "fromObserverFnSet", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "valueBlock", "byOwner", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "valueChange", "k", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "l", "y", "task", "i", "j", "w", "p", "()V", "a", "Ljava/util/Set;", "activeReadPropertyNames", "b", "activeWritePropertyNames", "Ljava/util/HashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "propertyObserverFnMap", "", "d", "observerRemoveFnOwnerMap", "e", "observerFnCollectionPropertiesMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "endCollectDependencyTasks", "g", "Z", "startCollectDependency", "<set-?>", "Ljava/lang/String;", "t", "()Ljava/lang/String;", "currentObservablePropertyKey", ReportConstant.COSTREPORT_PREFIX, "currentChangingPropertyKey", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReactiveObserver {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean startCollectDependency;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String currentChangingPropertyKey;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<String> activeReadPropertyNames = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Set<String> activeWritePropertyNames = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, LinkedHashSet<Function0<Object>>> propertyObserverFnMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, LinkedHashSet<Function0<Unit>>> observerRemoveFnOwnerMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Function0<Object>, Set<String>> observerFnCollectionPropertiesMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Function0<Unit>> endCollectDependencyTasks = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String currentObservablePropertyKey = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J1\u0010\n\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001J\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ+\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u0013\"\u0004\b\u0000\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/reactive/ReactiveObserver$a;", "", "observer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "", "valueChange", "b", "observerFnOwner", "e", "f", "Lkotlin/Function0;", "task", "a", "T", "init", "Lkotlin/properties/ReadWriteProperty;", "c", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "Lcom/tencent/kuikly/core/reactive/collection/c;", "d", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.reactive.ReactiveObserver$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/kuikly/core/reactive/ReactiveObserver$a$a", "Lc01/b;", "", "Lcom/tencent/kuikly/core/reactive/PropertyOwner;", "propertyOwner", "propertyName", "", "a", "b", "core_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.kuikly.core.reactive.ReactiveObserver$a$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public static final class C5867a implements c01.b {
            C5867a() {
            }

            @Override // c01.b
            public void a(String propertyOwner, String propertyName) {
                Intrinsics.checkNotNullParameter(propertyOwner, "propertyOwner");
                Intrinsics.checkNotNullParameter(propertyName, "propertyName");
                c.f117352a.i().v(propertyOwner, propertyName);
            }

            @Override // c01.b
            public void b(String propertyOwner, String propertyName) {
                Intrinsics.checkNotNullParameter(propertyOwner, "propertyOwner");
                Intrinsics.checkNotNullParameter(propertyName, "propertyName");
                c.f117352a.i().u(propertyOwner, propertyName);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/kuikly/core/reactive/ReactiveObserver$a$b", "Lc01/b;", "", "Lcom/tencent/kuikly/core/reactive/PropertyOwner;", "propertyOwner", "propertyName", "", "a", "b", "core_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.kuikly.core.reactive.ReactiveObserver$a$b */
        /* loaded from: classes33.dex */
        public static final class b implements c01.b {
            b() {
            }

            @Override // c01.b
            public void a(String propertyOwner, String propertyName) {
                Intrinsics.checkNotNullParameter(propertyOwner, "propertyOwner");
                Intrinsics.checkNotNullParameter(propertyName, "propertyName");
                c.f117352a.i().v(propertyOwner, propertyName);
            }

            @Override // c01.b
            public void b(String propertyOwner, String propertyName) {
                Intrinsics.checkNotNullParameter(propertyOwner, "propertyOwner");
                Intrinsics.checkNotNullParameter(propertyName, "propertyName");
                c.f117352a.i().u(propertyOwner, propertyName);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Function0<Unit> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            c.f117352a.i().i(task);
        }

        public final boolean b(Object observer, Function1<? super Boolean, Unit> valueChange) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(valueChange, "valueChange");
            return c.f117352a.i().l(observer, valueChange);
        }

        public final <T> ReadWriteProperty<Object, T> c(T init) {
            return new a(init, new C5867a());
        }

        public final <T> ReadWriteProperty<Object, com.tencent.kuikly.core.reactive.collection.c<T>> d() {
            return new ObservableCollectionProperty(new com.tencent.kuikly.core.reactive.collection.c(null, null, null, 7, null), new b());
        }

        public final void e(Object observerFnOwner) {
            Intrinsics.checkNotNullParameter(observerFnOwner, "observerFnOwner");
            c.f117352a.i().w(observerFnOwner);
        }

        public final void f(Object observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            e(observer);
        }

        Companion() {
        }
    }

    private final void h(final String propertyName, Object observerFnOwner, final Function0<? extends Object> observerFn) {
        final Set<Function0<Object>> n3 = n(observerFn, propertyName);
        if (n3 != null) {
            o(observerFnOwner, new Function0<Unit>() { // from class: com.tencent.kuikly.core.reactive.ReactiveObserver$addActivePropertyObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HashMap hashMap;
                    HashMap hashMap2;
                    Set<Function0<Object>> set = n3;
                    Function0<Object> function0 = observerFn;
                    ReactiveObserver reactiveObserver = this;
                    set.remove(function0);
                    hashMap = reactiveObserver.observerFnCollectionPropertiesMap;
                    hashMap.remove(function0);
                    if (n3.isEmpty()) {
                        hashMap2 = this.propertyObserverFnMap;
                        hashMap2.remove(propertyName);
                    }
                }
            });
        }
    }

    private final String m(String propertyOwner, String propertyName) {
        String str = propertyOwner + util.base64_pad_url + propertyName;
        this.currentObservablePropertyKey = str;
        return str;
    }

    private final Set<Function0<Object>> n(Function0<? extends Object> observerFn, String propertyName) {
        LinkedHashSet<Function0<Object>> linkedHashSet = this.propertyObserverFnMap.get(propertyName);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            this.propertyObserverFnMap.put(propertyName, linkedHashSet);
        }
        if (linkedHashSet.add(observerFn)) {
            return linkedHashSet;
        }
        return null;
    }

    private final void o(Object observerFnOwner, Function0<Unit> observerRemoveFn) {
        int hashCode = observerFnOwner.hashCode();
        LinkedHashSet<Function0<Unit>> linkedHashSet = this.observerRemoveFnOwnerMap.get(Integer.valueOf(hashCode));
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            this.observerRemoveFnOwnerMap.put(Integer.valueOf(hashCode), linkedHashSet);
        }
        linkedHashSet.add(observerRemoveFn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String propertyOwner, String propertyName) {
        if (this.startCollectDependency) {
            this.activeReadPropertyNames.add(m(propertyOwner, propertyName));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String propertyOwner, String propertyName) {
        final Set set;
        final String m3 = m(propertyOwner, propertyName);
        if (this.startCollectDependency) {
            this.activeWritePropertyNames.add(m3);
            LinkedHashSet<Function0<Object>> linkedHashSet = this.propertyObserverFnMap.get(m3);
            if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                return;
            }
            set = CollectionsKt___CollectionsKt.toSet(linkedHashSet);
            i(new Function0<Unit>() { // from class: com.tencent.kuikly.core.reactive.ReactiveObserver$notifyPropertyObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ReactiveObserver.this.currentChangingPropertyKey = m3;
                    ReactiveObserver.this.r(m3, set);
                    ReactiveObserver.this.currentObservablePropertyKey = "";
                    ReactiveObserver.this.currentChangingPropertyKey = null;
                }
            });
            return;
        }
        this.currentChangingPropertyKey = m3;
        r(m3, this.propertyObserverFnMap.get(m3));
        this.currentObservablePropertyKey = "";
        this.currentChangingPropertyKey = null;
    }

    public final void i(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.startCollectDependency) {
            this.endCollectDependencyTasks.add(task);
        } else {
            task.invoke();
        }
    }

    public final boolean j(Object observerFnOwner, Function0<? extends Object> observerFn) {
        Set<String> mutableSet;
        Set<String> set;
        Intrinsics.checkNotNullParameter(observerFnOwner, "observerFnOwner");
        Intrinsics.checkNotNullParameter(observerFn, "observerFn");
        if (!this.activeReadPropertyNames.isEmpty()) {
            mutableSet = CollectionsKt___CollectionsKt.toMutableSet(this.activeReadPropertyNames);
            set = CollectionsKt___CollectionsKt.toSet(this.activeWritePropertyNames);
            for (String str : set) {
                if (mutableSet.contains(str)) {
                    mutableSet.remove(str);
                }
            }
            try {
                Iterator it = mutableSet.iterator();
                while (it.hasNext()) {
                    h((String) it.next(), observerFnOwner, observerFn);
                }
                this.observerFnCollectionPropertiesMap.put(observerFn, mutableSet);
                this.activeReadPropertyNames.clear();
                this.activeWritePropertyNames.clear();
                return true;
            } catch (Throwable th5) {
                this.activeReadPropertyNames.clear();
                this.activeWritePropertyNames.clear();
                throw th5;
            }
        }
        this.activeWritePropertyNames.clear();
        return false;
    }

    public final void k(final Function0<? extends Object> valueBlock, Object byOwner, final Function1<Object, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(valueBlock, "valueBlock");
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
        l(byOwner, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.reactive.ReactiveObserver$bindValueChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                final Object invoke = valueBlock.invoke();
                ReactiveObserver reactiveObserver = this;
                final Function1<Object, Unit> function1 = valueChange;
                reactiveObserver.i(new Function0<Unit>() { // from class: com.tencent.kuikly.core.reactive.ReactiveObserver$bindValueChange$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function1.invoke(invoke);
                    }
                });
            }
        });
    }

    public final boolean l(final Object byOwner, final Function1<? super Boolean, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
        x();
        valueChange.invoke(Boolean.TRUE);
        boolean j3 = j(byOwner, new Function0<Object>() { // from class: com.tencent.kuikly.core.reactive.ReactiveObserver$bindValueChange$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                valueChange.invoke(Boolean.FALSE);
                return byOwner;
            }
        });
        q();
        return j3;
    }

    public final void p() {
        this.activeReadPropertyNames.clear();
        this.activeWritePropertyNames.clear();
        this.propertyObserverFnMap.clear();
        this.observerRemoveFnOwnerMap.clear();
        this.observerFnCollectionPropertiesMap.clear();
        this.endCollectDependencyTasks.clear();
        this.endCollectDependencyTasks.clear();
    }

    /* renamed from: s, reason: from getter */
    public final String getCurrentChangingPropertyKey() {
        return this.currentChangingPropertyKey;
    }

    /* renamed from: t, reason: from getter */
    public final String getCurrentObservablePropertyKey() {
        return this.currentObservablePropertyKey;
    }

    public final void w(Object observerFnOwner) {
        Intrinsics.checkNotNullParameter(observerFnOwner, "observerFnOwner");
        LinkedHashSet<Function0<Unit>> remove = this.observerRemoveFnOwnerMap.remove(Integer.valueOf(observerFnOwner.hashCode()));
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }

    public final void y(Object byOwner) {
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        w(byOwner);
    }

    private final void q() {
        List list;
        this.startCollectDependency = false;
        if (!this.endCollectDependencyTasks.isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(this.endCollectDependencyTasks);
            this.endCollectDependencyTasks.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }

    private final void x() {
        this.startCollectDependency = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String propertyKey, Set<? extends Function0<? extends Object>> fromObserverFnSet) {
        List<Function0<? extends Object>> list;
        Set<String> set;
        if (fromObserverFnSet != null) {
            list = CollectionsKt___CollectionsKt.toList(fromObserverFnSet);
            for (Function0<? extends Object> function0 : list) {
                if (fromObserverFnSet.contains(function0) && (set = this.observerFnCollectionPropertiesMap.get(function0)) != null && set.contains(propertyKey)) {
                    x();
                    j(function0.invoke(), function0);
                    q();
                }
            }
        }
    }
}
