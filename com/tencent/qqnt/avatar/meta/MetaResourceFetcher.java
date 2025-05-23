package com.tencent.qqnt.avatar.meta;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.cache.AvatarInfoCache;
import com.tencent.qqnt.avatar.cache.a;
import com.tencent.qqnt.avatar.cache.e;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.fetch.d;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import com.tencent.qqnt.avatar.meta.task.TaskManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J.\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u001f\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\n\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ7\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00192\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000\u00a2\u0006\u0004\b \u0010!J/\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0000\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/MetaResourceFetcher;", "Lcom/tencent/qqnt/avatar/core/a;", "Lkotlin/Function0;", "", "cancelBlock", "Lcom/tencent/qqnt/avatar/fetch/b;", "l", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "forceRefresh", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "Lcom/tencent/qqnt/avatar/meta/request/a;", "Lcom/tencent/qqnt/avatar/layer/a;", "baseLoadTarget", "Lcom/tencent/qqnt/avatar/meta/request/b;", "k", "Lcom/tencent/qqnt/avatar/meta/a;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "g", "(Lcom/tencent/qqnt/avatar/meta/a;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArray", "Landroid/graphics/Bitmap;", "f", "(Landroid/content/Context;Lcom/tencent/qqnt/avatar/meta/a;[Lcom/tencent/qqnt/avatar/meta/info/a;)[Landroid/graphics/Bitmap;", "avatarInfoArr", h.F, "(Landroid/content/Context;Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Landroid/graphics/Bitmap;", "j", "", "i", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "taskManager", "Lcom/tencent/qqnt/avatar/cache/e;", "d", "Lcom/tencent/qqnt/avatar/cache/e;", "memoryCache", "Lcom/tencent/qqnt/avatar/cache/AvatarInfoCache;", "e", "Lcom/tencent/qqnt/avatar/cache/AvatarInfoCache;", "infoCache", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MetaResourceFetcher extends com.tencent.qqnt.avatar.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final MetaResourceFetcher f352881b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final TaskManager taskManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e memoryCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AvatarInfoCache infoCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/avatar/meta/MetaResourceFetcher$a", "Lcom/tencent/qqnt/avatar/meta/request/a;", "Lcom/tencent/qqnt/avatar/layer/a;", "result", "", "a", "", "errorMsg", "onFail", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.qqnt.avatar.meta.request.a<com.tencent.qqnt.avatar.layer.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.bean.a f352885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9507a f352886b;

        a(com.tencent.qqnt.avatar.bean.a aVar, a.InterfaceC9507a interfaceC9507a) {
            this.f352885a = aVar;
            this.f352886b = interfaceC9507a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) interfaceC9507a);
            }
        }

        @Override // com.tencent.qqnt.avatar.meta.request.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinish(@NotNull com.tencent.qqnt.avatar.layer.a result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            this.f352886b.a(new d(this.f352885a, true, result, null, 8, null));
        }

        @Override // com.tencent.qqnt.avatar.meta.request.a
        public void onFail(@Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
            } else {
                this.f352886b.a(new d(this.f352885a, false, null, errorMsg, 4, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/avatar/meta/MetaResourceFetcher$b", "Lcom/tencent/qqnt/avatar/fetch/b;", "", "cancel", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.avatar.fetch.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f352887a;

        b(Function0<Unit> function0) {
            this.f352887a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.qqnt.avatar.fetch.b
        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Function0<Unit> function0 = this.f352887a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f352881b = new MetaResourceFetcher();
        taskManager = new TaskManager("MetaResourceFetcher", null, 4, 0L, 0, 0, false, 122, null);
        memoryCache = e.f352705a;
        infoCache = AvatarInfoCache.f352688a;
    }

    MetaResourceFetcher() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.avatar.fetch.b l(Function0<Unit> cancelBlock) {
        return new b(cancelBlock);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ com.tencent.qqnt.avatar.fetch.b m(MetaResourceFetcher metaResourceFetcher, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        return metaResourceFetcher.l(function0);
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @NotNull
    public com.tencent.qqnt.avatar.fetch.b a(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull a.InterfaceC9507a callback, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.fetch.b) iPatchRedirector.redirect((short) 2, this, context, bean, callback, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(bean instanceof com.tencent.qqnt.avatar.meta.b)) {
            callback.a(new d(bean, false, null, null, 12, null));
            return m(this, null, 1, null);
        }
        final com.tencent.qqnt.avatar.meta.request.b k3 = k(context, (com.tencent.qqnt.avatar.meta.b) bean, new a(bean, callback), forceRefresh);
        return l(new Function0<Unit>() { // from class: com.tencent.qqnt.avatar.meta.MetaResourceFetcher$fetcherResource$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.meta.request.b.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    com.tencent.qqnt.avatar.meta.request.b.this.a();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh) {
        com.tencent.qqnt.avatar.meta.info.a[] c16;
        com.tencent.qqnt.avatar.layer.a c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, this, bean, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        if ((bean instanceof com.tencent.qqnt.avatar.meta.b) && (c16 = infoCache.c((com.tencent.qqnt.avatar.meta.a) bean)) != null) {
            if (c16.length != 0) {
                z16 = false;
            }
            if (!z16 && (c17 = memoryCache.c(MetaCacheKeyGenerator.f352879a.a((com.tencent.qqnt.avatar.meta.b) bean, c16))) != null) {
                return new d(bean, true, c17, null, 8, null);
            }
        }
        return null;
    }

    @Nullable
    public final Bitmap[] f(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.a bean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArray) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 6, this, context, bean, infoArray);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (infoArray != null) {
            if (infoArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ArrayIteratorKt.iterator(infoArray);
                while (it.hasNext()) {
                    Bitmap f16 = AvatarResourceManager.f352954a.f((com.tencent.qqnt.avatar.meta.info.a) it.next(), context, bean.e());
                    if (f16 != null) {
                        arrayList.add(f16);
                    }
                }
                if (arrayList.size() != infoArray.length) {
                    com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "MetaResourceFetcher", "getAvatarBitmapArrayFromDiskCache fail. infoArr size: " + infoArray.length + ", bitmapArr size: " + arrayList.size(), null, 4, null);
                    return null;
                }
                Object[] array = arrayList.toArray(new Bitmap[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (Bitmap[]) array;
            }
        }
        return null;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.meta.info.a[] g(@NotNull com.tencent.qqnt.avatar.meta.a bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bean);
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        return infoCache.c(bean);
    }

    @Nullable
    public final Bitmap h(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, this, context, avatarBean, avatarInfoArr);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        MetaCacheKeyGenerator metaCacheKeyGenerator = MetaCacheKeyGenerator.f352879a;
        String a16 = metaCacheKeyGenerator.a(avatarBean, avatarInfoArr);
        com.tencent.qqnt.avatar.layer.a c16 = memoryCache.c(a16);
        if (c16 != null) {
            bitmap = c16.d();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        a.Companion companion = com.tencent.qqnt.avatar.cache.a.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        Bitmap e16 = companion.a(applicationContext).e(a16);
        if (e16 != null) {
            return e16;
        }
        if (!metaCacheKeyGenerator.c()) {
            return null;
        }
        String b16 = metaCacheKeyGenerator.b(avatarBean, avatarInfoArr);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        return companion.a(applicationContext2).e(b16);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.b avatarBean) {
        boolean z16;
        String str;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        com.tencent.qqnt.avatar.meta.info.a[] h16 = AvatarInfoRequestManager.f352916a.h(avatarBean);
        boolean z18 = false;
        if (h16 != null) {
            if (h16.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                MetaCacheKeyGenerator metaCacheKeyGenerator = MetaCacheKeyGenerator.f352879a;
                String a16 = metaCacheKeyGenerator.a(avatarBean, h16);
                a.Companion companion = com.tencent.qqnt.avatar.cache.a.INSTANCE;
                File f16 = companion.a(context).f(a16);
                if (f16 != null) {
                    str = f16.getPath();
                } else {
                    str = null;
                }
                if (str == null || str.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    return str;
                }
                if (!metaCacheKeyGenerator.c()) {
                    return null;
                }
                File f17 = companion.a(context).f(metaCacheKeyGenerator.b(avatarBean, h16));
                if (f17 == null) {
                    return null;
                }
                return f17.getPath();
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Nullable
    public final Bitmap j(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean) {
        Bitmap bitmap;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        com.tencent.qqnt.avatar.meta.info.a[] h16 = AvatarInfoRequestManager.f352916a.h(avatarBean);
        boolean z17 = true;
        if (h16 != null) {
            if (h16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            return null;
        }
        com.tencent.qqnt.avatar.layer.a c16 = memoryCache.c(MetaCacheKeyGenerator.f352879a.a(avatarBean, h16));
        if (c16 != null) {
            bitmap = c16.d();
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        return bitmap;
    }

    @NotNull
    public final com.tencent.qqnt.avatar.meta.request.b k(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.request.a<com.tencent.qqnt.avatar.layer.a> baseLoadTarget, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.avatar.meta.request.b) iPatchRedirector.redirect((short) 4, this, context, avatarBean, baseLoadTarget, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(baseLoadTarget, "baseLoadTarget");
        com.tencent.qqnt.avatar.meta.request.c cVar = new com.tencent.qqnt.avatar.meta.request.c(context, avatarBean, baseLoadTarget);
        e eVar = memoryCache;
        a.Companion companion = com.tencent.qqnt.avatar.cache.a.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        final MetaAvatarLoadTask metaAvatarLoadTask = new MetaAvatarLoadTask(cVar, eVar, companion.a(applicationContext));
        taskManager.o(metaAvatarLoadTask, forceRefresh);
        return new com.tencent.qqnt.avatar.meta.request.b(avatarBean, new Function0<Unit>() { // from class: com.tencent.qqnt.avatar.meta.MetaResourceFetcher$loadAvatar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MetaAvatarLoadTask.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TaskManager taskManager2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    taskManager2 = MetaResourceFetcher.taskManager;
                    taskManager2.s(MetaAvatarLoadTask.this);
                }
            }
        });
    }
}
