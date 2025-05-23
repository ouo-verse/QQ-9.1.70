package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import fe.e;
import fe.f;
import fe.g;
import fe.i;
import fe.j;
import fe.k;
import fe.l;
import fe.m;
import fe.n;
import fe.o;
import fe.p;
import fe.q;
import fe.r;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jo.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fR\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/b;", "", "Lfe/a;", "detector", "", "d", "i", "c", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "position", h.F, "viewType", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "g", "", "a", "Ljava/util/List;", "mTypeDetectors", "", "Ljava/lang/reflect/Constructor;", "b", "Ljava/util/Map;", "mViewTypeToItemView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f53924d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<fe.a<?>> mTypeDetectors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, Constructor<? extends QzoneBaseFeedProItemView>> mViewTypeToItemView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/b$a;", "", "Lcom/qzone/reborn/feedpro/itemview/b;", "a", "", "TAG", "Ljava/lang/String;", "sInstance", "Lcom/qzone/reborn/feedpro/itemview/b;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.itemview.b$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final b a() {
            if (b.f53924d == null) {
                synchronized (b.class) {
                    if (b.f53924d == null) {
                        b.f53924d = new b(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            b bVar = b.f53924d;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c() {
        d(new ee.b());
        d(new ee.c());
        d(new ee.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d(fe.a<?> detector) {
        try {
            Map<Integer, Constructor<? extends QzoneBaseFeedProItemView>> map = this.mViewTypeToItemView;
            Integer valueOf = Integer.valueOf(detector.b().getMViewType());
            Constructor<?> constructor = detector.a().getConstructor(Context.class);
            Intrinsics.checkNotNullExpressionValue(constructor, "detector.getViewClass()\n\u2026ctor(Context::class.java)");
            map.put(valueOf, constructor);
            this.mTypeDetectors.add(detector);
        } catch (NoSuchMethodException e16) {
            e16.printStackTrace();
        }
    }

    private final void e() {
        d(new g());
        d(new fe.h());
        d(new n());
        d(new fe.c());
        d(new i());
        d(new j());
        d(new f());
        d(new k());
    }

    @JvmStatic
    public static final b f() {
        return INSTANCE.a();
    }

    private final void i() {
        d(new r());
        d(new q());
        d(new e());
        d(new fe.b());
    }

    public final QzoneBaseFeedProItemView g(int viewType, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Constructor<? extends QzoneBaseFeedProItemView> constructor = this.mViewTypeToItemView.get(Integer.valueOf(viewType));
        try {
            jo.h hVar = jo.h.f410717a;
            d g16 = hVar.g("item_view_construct");
            Intrinsics.checkNotNull(constructor);
            g16.h(constructor.getName() + "#newInstance");
            QzoneBaseFeedProItemView itemView = constructor.newInstance(context);
            hVar.g("item_view_construct").b(constructor.getName() + "#newInstance");
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return itemView;
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
            return new QzoneEmptyItemView(context);
        }
    }

    public final int h(CommonFeed commonFeed, int position) {
        for (fe.a<?> aVar : this.mTypeDetectors) {
            if (commonFeed != null && aVar.c(commonFeed)) {
                return aVar.b().getMViewType();
            }
        }
        return QzoneFeedProType.UNIQUE_TYPE_UNKNOWN.getMViewType();
    }

    b() {
        this.mTypeDetectors = new ArrayList();
        this.mViewTypeToItemView = new HashMap();
        c();
        d(new l());
        e();
        d(new o());
        d(new p());
        d(new fe.d());
        d(new m());
        i();
    }
}
