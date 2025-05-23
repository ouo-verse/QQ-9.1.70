package com.tencent.qqnt.avatar.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.core.b;
import com.tencent.qqnt.avatar.fetch.ResourceFetchResultRecord;
import com.tencent.qqnt.avatar.fetch.d;
import com.tencent.qqnt.avatar.g;
import com.tencent.qqnt.avatar.meta.MetaResourceFetcher;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager;
import com.tencent.qqnt.avatar.util.e;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0002'EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u00010\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0018\u0010\u001c\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J.\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016R(\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00105R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0000048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00105\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "Lcom/tencent/qqnt/avatar/meta/refresh/b;", "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "", "o", "Landroid/content/Context;", "context", "", "forceRefresh", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "Lcom/tencent/qqnt/avatar/layer/d;", "", "map", "k", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "r", "Lcom/tencent/qqnt/avatar/fetch/ResourceFetchResultRecord;", "p", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", "callback", "t", "Lcom/tencent/qqnt/avatar/fetch/a;", "updater", "v", "w", "u", HippyTKDListViewAdapter.X, "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "i", "l", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/avatar/meta/refresh/bean/a;", "refreshInfo", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "resourceLayerMap", "e", "Lcom/tencent/qqnt/avatar/fetch/c;", "curRequest", "f", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", h.F, "Landroid/graphics/drawable/Drawable;", "defLoadingDrawable", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "contextRef", "I", "loadState", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/avatar/fetch/a;", "requestUpdater", "", "D", "Ljava/lang/String;", "tag", "E", "weakRef", "<init>", "()V", UserInfo.SEX_FEMALE, "b", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ResourceOrganizer implements com.tencent.qqnt.avatar.meta.refresh.b {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final ConcurrentHashMap<String, ResourceFetchResultRecord> G;

    @NotNull
    private static final Map<Integer, com.tencent.qqnt.avatar.core.a> H;

    @Nullable
    private static b I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.fetch.a requestUpdater;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final WeakReference<ResourceOrganizer> weakRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> resourceLayerMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.fetch.c curRequest;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable defLoadingDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> contextRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int loadState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", "", "", "Lcom/tencent/qqnt/avatar/layer/d;", "layerList", "", "onResult", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void onResult(@Nullable List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J&\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0017\u001a\u00020\u00162\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00140\u000bJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aJ\u001d\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001e\u00a2\u0006\u0004\b!\u0010\"J5\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001e2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010(R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$b;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "weakRef", "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "", "isMeta", "Lcom/tencent/qqnt/avatar/core/a$a;", "b", "", "", "Lcom/tencent/qqnt/avatar/core/a;", "resourceFetcherMap", "", "f", "Lcom/tencent/qqnt/avatar/core/b;", "organizer", h.F, "Lcom/tencent/qqnt/avatar/layer/d;", "raw", "Lcom/tencent/qqnt/avatar/core/c;", "g", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/meta/b;", "bean", "Landroid/graphics/Bitmap;", "e", "Lcom/tencent/qqnt/avatar/meta/a;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "d", "(Lcom/tencent/qqnt/avatar/meta/a;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArray", "c", "(Landroid/content/Context;Lcom/tencent/qqnt/avatar/meta/a;[Lcom/tencent/qqnt/avatar/meta/info/a;)[Landroid/graphics/Bitmap;", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqnt/avatar/fetch/ResourceFetchResultRecord;", "fetchResultRecordMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "fetcherMap", "Ljava/util/Map;", "layerOrganizer", "Lcom/tencent/qqnt/avatar/core/b;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.core.ResourceOrganizer$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/avatar/core/ResourceOrganizer$b$a", "Lcom/tencent/qqnt/avatar/core/a$a;", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.avatar.core.ResourceOrganizer$b$a */
        /* loaded from: classes23.dex */
        public static final class a implements a.InterfaceC9507a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeakReference<ResourceOrganizer> f352728a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.avatar.fetch.c f352729b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f352730c;

            a(WeakReference<ResourceOrganizer> weakReference, com.tencent.qqnt.avatar.fetch.c cVar, boolean z16) {
                this.f352728a = weakReference;
                this.f352729b = cVar;
                this.f352730c = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, weakReference, cVar, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
            public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                ResourceOrganizer resourceOrganizer = this.f352728a.get();
                if (resourceOrganizer != null) {
                    com.tencent.qqnt.avatar.fetch.c cVar = this.f352729b;
                    boolean z16 = this.f352730c;
                    resourceOrganizer.r(cVar, result);
                    if (z16) {
                        cVar.g().a(new e.a("async_load", result.c(), null, 0L, null, 28, null));
                    }
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a.InterfaceC9507a b(WeakReference<ResourceOrganizer> weakRef, com.tencent.qqnt.avatar.fetch.c request, boolean isMeta) {
            return new a(weakRef, request, isMeta);
        }

        @Nullable
        public final Bitmap[] c(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.a bean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArray) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Bitmap[]) iPatchRedirector.redirect((short) 7, this, context, bean, infoArray);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, "bean");
            return MetaResourceFetcher.f352881b.f(context, bean, infoArray);
        }

        @Nullable
        public final com.tencent.qqnt.avatar.meta.info.a[] d(@NotNull com.tencent.qqnt.avatar.meta.a bean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bean);
            }
            Intrinsics.checkNotNullParameter(bean, "bean");
            return MetaResourceFetcher.f352881b.g(bean);
        }

        @Nullable
        public final Bitmap e(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.b bean) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) bean);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, "bean");
            com.tencent.qqnt.avatar.meta.info.a[] h16 = AvatarInfoRequestManager.f352916a.h(bean);
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
                com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "ResourceOrganizer", "getCacheBitmap infoArray is null or empty", null, 4, null);
                return null;
            }
            return MetaResourceFetcher.f352881b.h(context, bean, h16);
        }

        public final void f(@NotNull Map<Integer, ? extends com.tencent.qqnt.avatar.core.a> resourceFetcherMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resourceFetcherMap);
                return;
            }
            Intrinsics.checkNotNullParameter(resourceFetcherMap, "resourceFetcherMap");
            ResourceOrganizer.H.put(0, MetaResourceFetcher.f352881b);
            for (Map.Entry<Integer, ? extends com.tencent.qqnt.avatar.core.a> entry : resourceFetcherMap.entrySet()) {
                if (ResourceOrganizer.H.containsKey(entry.getKey())) {
                    com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "ResourceOrganizer", "addResourceFetcher error, key has already used. key=[" + entry.getKey() + "], value=" + entry.getValue(), null, 4, null);
                } else {
                    ResourceOrganizer.H.put(entry.getKey(), entry.getValue());
                }
            }
        }

        @NotNull
        public final com.tencent.qqnt.avatar.core.c g(@NotNull Map<Integer, ? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> raw) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.avatar.core.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) raw);
            }
            Intrinsics.checkNotNullParameter(raw, "raw");
            b bVar = ResourceOrganizer.I;
            if (bVar == null) {
                bVar = b.a.f352736a;
            }
            return bVar.a(raw);
        }

        public final void h(@NotNull b organizer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) organizer);
            } else {
                Intrinsics.checkNotNullParameter(organizer, "organizer");
                ResourceOrganizer.I = organizer;
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/avatar/core/ResourceOrganizer$c", "Lcom/tencent/qqnt/avatar/core/a$a;", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements a.InterfaceC9507a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.fetch.c f352732b;

        c(com.tencent.qqnt.avatar.fetch.c cVar) {
            this.f352732b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceOrganizer.this, (Object) cVar);
            }
        }

        @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
        public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
            } else {
                Intrinsics.checkNotNullParameter(result, "result");
                ResourceOrganizer.this.r(this.f352732b, result);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/avatar/core/ResourceOrganizer$d", "Lcom/tencent/qqnt/avatar/core/a$a;", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements a.InterfaceC9507a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.fetch.c f352734b;

        d(com.tencent.qqnt.avatar.fetch.c cVar) {
            this.f352734b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceOrganizer.this, (Object) cVar);
            }
        }

        @Override // com.tencent.qqnt.avatar.core.a.InterfaceC9507a
        public void a(@NotNull com.tencent.qqnt.avatar.fetch.d result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            ResourceOrganizer.this.r(this.f352734b, result);
            this.f352734b.g().a(new e.a("async_load", result.c(), null, 0L, null, 28, null));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        INSTANCE = new Companion(null);
        G = new ConcurrentHashMap<>();
        H = new LinkedHashMap();
        I = b.a.f352736a;
    }

    public ResourceOrganizer() {
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.resourceLayerMap = new ConcurrentHashMap<>();
        this.defLoadingDrawable = new ColorDrawable(0);
        int hashCode = hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        this.tag = "ResourceOrganizer_" + num;
        if (!g.f352801a.g()) {
            s();
        }
        this.weakRef = new WeakReference<>(this);
    }

    private final boolean k(com.tencent.qqnt.avatar.fetch.c request, Map<Integer, ? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> map) {
        if (map == null) {
            return false;
        }
        return p(request).a(request, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[Catch: all -> 0x019c, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0018, B:7:0x001b, B:9:0x004c, B:11:0x0052, B:12:0x005a, B:14:0x0060, B:20:0x006f, B:22:0x0098, B:24:0x00b9, B:25:0x00bc, B:28:0x00d8, B:33:0x00e6, B:35:0x00fd, B:39:0x0109, B:41:0x011f, B:42:0x012d, B:44:0x013b, B:45:0x013e, B:47:0x014e, B:48:0x0154, B:50:0x015a, B:52:0x0178, B:54:0x018a, B:57:0x0192, B:60:0x0196, B:66:0x0182, B:70:0x0128, B:73:0x00c4, B:75:0x00cc, B:77:0x00d0), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8 A[Catch: all -> 0x019c, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0018, B:7:0x001b, B:9:0x004c, B:11:0x0052, B:12:0x005a, B:14:0x0060, B:20:0x006f, B:22:0x0098, B:24:0x00b9, B:25:0x00bc, B:28:0x00d8, B:33:0x00e6, B:35:0x00fd, B:39:0x0109, B:41:0x011f, B:42:0x012d, B:44:0x013b, B:45:0x013e, B:47:0x014e, B:48:0x0154, B:50:0x015a, B:52:0x0178, B:54:0x018a, B:57:0x0192, B:60:0x0196, B:66:0x0182, B:70:0x0128, B:73:0x00c4, B:75:0x00cc, B:77:0x00d0), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0018, B:7:0x001b, B:9:0x004c, B:11:0x0052, B:12:0x005a, B:14:0x0060, B:20:0x006f, B:22:0x0098, B:24:0x00b9, B:25:0x00bc, B:28:0x00d8, B:33:0x00e6, B:35:0x00fd, B:39:0x0109, B:41:0x011f, B:42:0x012d, B:44:0x013b, B:45:0x013e, B:47:0x014e, B:48:0x0154, B:50:0x015a, B:52:0x0178, B:54:0x018a, B:57:0x0192, B:60:0x0196, B:66:0x0182, B:70:0x0128, B:73:0x00c4, B:75:0x00cc, B:77:0x00d0), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109 A[Catch: all -> 0x019c, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0018, B:7:0x001b, B:9:0x004c, B:11:0x0052, B:12:0x005a, B:14:0x0060, B:20:0x006f, B:22:0x0098, B:24:0x00b9, B:25:0x00bc, B:28:0x00d8, B:33:0x00e6, B:35:0x00fd, B:39:0x0109, B:41:0x011f, B:42:0x012d, B:44:0x013b, B:45:0x013e, B:47:0x014e, B:48:0x0154, B:50:0x015a, B:52:0x0178, B:54:0x018a, B:57:0x0192, B:60:0x0196, B:66:0x0182, B:70:0x0128, B:73:0x00c4, B:75:0x00cc, B:77:0x00d0), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c4 A[Catch: all -> 0x019c, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0018, B:7:0x001b, B:9:0x004c, B:11:0x0052, B:12:0x005a, B:14:0x0060, B:20:0x006f, B:22:0x0098, B:24:0x00b9, B:25:0x00bc, B:28:0x00d8, B:33:0x00e6, B:35:0x00fd, B:39:0x0109, B:41:0x011f, B:42:0x012d, B:44:0x013b, B:45:0x013e, B:47:0x014e, B:48:0x0154, B:50:0x015a, B:52:0x0178, B:54:0x018a, B:57:0x0192, B:60:0x0196, B:66:0x0182, B:70:0x0128, B:73:0x00c4, B:75:0x00cc, B:77:0x00d0), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void m(Context context, final com.tencent.qqnt.avatar.fetch.c request, boolean forceRefresh) {
        List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list;
        boolean z16;
        boolean z17;
        a aVar;
        com.tencent.qqnt.avatar.fetch.b bVar;
        boolean z18;
        boolean z19;
        a.InterfaceC9507a dVar;
        a.InterfaceC9507a cVar;
        com.tencent.qqnt.avatar.fetch.b bVar2;
        com.tencent.qqnt.avatar.fetch.c cVar2;
        Collection<com.tencent.qqnt.avatar.layer.d<? extends Object>> values;
        this.contextRef = new WeakReference<>(context);
        if (!Intrinsics.areEqual(this.curRequest, request)) {
            o(request);
        }
        final StringBuilder sb5 = new StringBuilder("fetchResource sync result: [" + request.f() + "] forceRefresh: " + forceRefresh);
        request.g().e();
        Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x16 = x(request, forceRefresh);
        if (x16 != null && (values = x16.values()) != null) {
            list = CollectionsKt___CollectionsKt.toList(values);
        } else {
            list = null;
        }
        List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
            if (z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            request.g().a(new e.a("sync_load", z17, null, 0L, null, 28, null));
            if (!z17) {
                sb5.append(" \u547d\u4e2d\u7f13\u5b58[cb: " + this.callback + "]");
                a aVar2 = this.callback;
                if (aVar2 != null) {
                    aVar2.onResult(list);
                }
                request.g().c(true);
            } else {
                sb5.append(" \u65e0\u7f13\u5b58");
                if (!forceRefresh && (aVar = this.callback) != null) {
                    bVar = null;
                    aVar.onResult(null);
                    if (forceRefresh && k(request, x16)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    sb5.append(", \u9700\u8981\u5f02\u6b65\u8bf7\u6c42? " + z19);
                    if (z18) {
                        request.g().c(true);
                        this.loadState = 2;
                        return;
                    }
                    com.tencent.qqnt.avatar.util.d dVar2 = com.tencent.qqnt.avatar.util.d.f352991a;
                    dVar2.a(this.tag, new Function0<String>(sb5) { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$doFetchResource$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ StringBuilder $log;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$log = sb5;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sb5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.$log.toString() : (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    });
                    this.loadState = 1;
                    if (g.f352801a.u()) {
                        dVar = INSTANCE.b(this.weakRef, request, true);
                    } else {
                        dVar = new d(request);
                    }
                    com.tencent.qqnt.avatar.fetch.b a16 = MetaResourceFetcher.f352881b.a(context, request.c(), dVar, forceRefresh);
                    com.tencent.qqnt.avatar.fetch.c cVar3 = this.curRequest;
                    if (cVar3 != null) {
                        cVar3.a(a16);
                    }
                    dVar2.a(this.tag, new Function0<String>() { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$doFetchResource$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.fetch.c.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "extendsBeanList: " + com.tencent.qqnt.avatar.fetch.c.this.d();
                        }
                    });
                    List<com.tencent.qqnt.avatar.bean.a> d16 = request.d();
                    if (d16 != null) {
                        for (com.tencent.qqnt.avatar.bean.a aVar3 : d16) {
                            com.tencent.qqnt.avatar.core.a aVar4 = H.get(Integer.valueOf(aVar3.b()));
                            if (g.f352801a.u()) {
                                cVar = INSTANCE.b(this.weakRef, request, false);
                            } else {
                                cVar = new c(request);
                            }
                            if (aVar4 != null) {
                                bVar2 = aVar4.a(context, aVar3, cVar, forceRefresh);
                            } else {
                                bVar2 = bVar;
                            }
                            if (bVar2 != null && (cVar2 = this.curRequest) != null) {
                                cVar2.a(bVar2);
                            }
                        }
                    }
                    return;
                }
            }
            bVar = null;
            if (forceRefresh) {
            }
            z18 = false;
            if (!z18) {
            }
            sb5.append(", \u9700\u8981\u5f02\u6b65\u8bf7\u6c42? " + z19);
            if (z18) {
            }
        }
        z16 = true;
        if (z16) {
        }
        request.g().a(new e.a("sync_load", z17, null, 0L, null, 28, null));
        if (!z17) {
        }
        bVar = null;
        if (forceRefresh) {
        }
        z18 = false;
        if (!z18) {
        }
        sb5.append(", \u9700\u8981\u5f02\u6b65\u8bf7\u6c42? " + z19);
        if (z18) {
        }
    }

    static /* synthetic */ void n(ResourceOrganizer resourceOrganizer, Context context, com.tencent.qqnt.avatar.fetch.c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        resourceOrganizer.m(context, cVar, z16);
    }

    private final synchronized void o(final com.tencent.qqnt.avatar.fetch.c request) {
        String str;
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            if (cVar != null) {
                str = cVar.f();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, request.f())) {
                com.tencent.qqnt.avatar.util.d.f352991a.a(this.tag, new Function0<String>(this) { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$doUpdateResourceFetchRequest$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ResourceOrganizer this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.fetch.c.this, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final String invoke() {
                        com.tencent.qqnt.avatar.fetch.c cVar2;
                        com.tencent.qqnt.avatar.fetch.c cVar3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        int hashCode = com.tencent.qqnt.avatar.fetch.c.this.hashCode();
                        String f16 = com.tencent.qqnt.avatar.fetch.c.this.f();
                        cVar2 = this.this$0.curRequest;
                        Integer valueOf = cVar2 != null ? Integer.valueOf(cVar2.hashCode()) : null;
                        cVar3 = this.this$0.curRequest;
                        return "fetchResource compare request[" + hashCode + "-" + f16 + "] [" + valueOf + "-" + (cVar3 != null ? cVar3.f() : null) + "] ";
                    }
                });
                com.tencent.qqnt.avatar.fetch.c cVar2 = this.curRequest;
                if (cVar2 != null) {
                    cVar2.b();
                }
                this.resourceLayerMap.clear();
            }
        }
        this.curRequest = request;
    }

    private final ResourceFetchResultRecord p(com.tencent.qqnt.avatar.fetch.c request) {
        ConcurrentHashMap<String, ResourceFetchResultRecord> concurrentHashMap = G;
        ResourceFetchResultRecord resourceFetchResultRecord = concurrentHashMap.get(request.f());
        if (resourceFetchResultRecord == null) {
            ResourceFetchResultRecord resourceFetchResultRecord2 = new ResourceFetchResultRecord(request.f());
            concurrentHashMap.put(request.f(), resourceFetchResultRecord2);
            return resourceFetchResultRecord2;
        }
        return resourceFetchResultRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(com.tencent.qqnt.avatar.fetch.c request, final com.tencent.qqnt.avatar.fetch.d result) {
        String str;
        boolean z16;
        com.tencent.qqnt.avatar.util.d dVar = com.tencent.qqnt.avatar.util.d.f352991a;
        dVar.a(this.tag, new Function0<String>() { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$handleFetchResult$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                String d16 = d.this.a().d();
                com.tencent.qqnt.avatar.bean.a a16 = d.this.a();
                boolean c16 = d.this.c();
                com.tencent.qqnt.avatar.layer.d<? extends Object> b16 = d.this.b();
                return "handleFetchResult bean:" + d16 + " " + a16 + MsgSummary.STR_COLON + c16 + ", resource:" + (b16 != null ? b16.d() : null);
            }
        });
        String f16 = request.f();
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            str = cVar.f();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(f16, str)) {
            dVar.a("ResourceOrganizer", ResourceOrganizer$handleFetchResult$2.INSTANCE);
            return;
        }
        ResourceFetchResultRecord p16 = p(request);
        if (result.c() && result.b() != null) {
            this.resourceLayerMap.put(Integer.valueOf(result.a().b()), result.b());
            j();
            z16 = true;
        } else {
            boolean containsKey = this.resourceLayerMap.containsKey(Integer.valueOf(result.a().b()));
            this.resourceLayerMap.remove(Integer.valueOf(result.a().b()));
            if (containsKey) {
                j();
            }
            z16 = false;
        }
        p16.c(result.a().b(), z16);
        if (result.a().b() == 0) {
            request.g().c(z16);
        }
    }

    @Override // com.tencent.qqnt.avatar.meta.refresh.b
    public void a(@NotNull com.tencent.qqnt.avatar.meta.refresh.bean.a refreshInfo) {
        com.tencent.qqnt.avatar.fetch.c cVar;
        Context e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) refreshInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshInfo, "refreshInfo");
        com.tencent.qqnt.avatar.fetch.c cVar2 = this.curRequest;
        if (cVar2 == null) {
            return;
        }
        final com.tencent.qqnt.avatar.meta.b c16 = cVar2.c();
        if (refreshInfo.a() == c16.a() && Intrinsics.areEqual(refreshInfo.b(), c16.c())) {
            com.tencent.qqnt.avatar.util.d dVar = com.tencent.qqnt.avatar.util.d.f352991a;
            dVar.a(this.tag, new Function0<String>() { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$refresh$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.meta.b.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "refresh [" + com.tencent.qqnt.avatar.meta.b.this.a() + "-" + com.tencent.qqnt.avatar.meta.b.this.c() + "]";
                }
            });
            l();
            com.tencent.qqnt.avatar.fetch.a aVar = this.requestUpdater;
            if (aVar != null) {
                cVar = aVar.onUpdate();
            } else {
                cVar = null;
            }
            WeakReference<Context> weakReference = this.contextRef;
            if (weakReference == null || (e16 = weakReference.get()) == null) {
                e16 = g.f352801a.e();
            }
            if (e16 == null) {
                com.tencent.qqnt.avatar.util.d.d(dVar, this.tag, "refresh [" + refreshInfo.a() + "-" + refreshInfo.b() + "] context null", null, 4, null);
                return;
            }
            if (cVar != null) {
                cVar2 = cVar;
            }
            m(e16, cVar2, true);
        }
    }

    public final synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final synchronized boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.avatar.util.d.f352991a.a(this.tag, new Function0<String>() { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$checkResourcesIsReady$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ResourceOrganizer.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                com.tencent.qqnt.avatar.fetch.c cVar;
                ConcurrentHashMap concurrentHashMap;
                ResourceOrganizer.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                cVar = ResourceOrganizer.this.curRequest;
                String f16 = cVar != null ? cVar.f() : null;
                concurrentHashMap = ResourceOrganizer.this.resourceLayerMap;
                aVar = ResourceOrganizer.this.callback;
                return "checkResourcesIsReady[" + f16 + "]. resourceMap= " + concurrentHashMap + ", cb= " + aVar;
            }
        });
        if (!this.resourceLayerMap.isEmpty()) {
            com.tencent.qqnt.avatar.core.c g16 = INSTANCE.g(this.resourceLayerMap);
            if (!g16.a().isEmpty()) {
                a aVar = this.callback;
                if (aVar != null) {
                    aVar.onResult(g16.a());
                }
                return true;
            }
            com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
            if (cVar != null && p(cVar).b(cVar)) {
                this.loadState = 2;
            }
        }
        return false;
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            G.clear();
        }
    }

    @NotNull
    public final Drawable q() {
        Drawable e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar == null || (e16 = cVar.e()) == null) {
            return this.defLoadingDrawable;
        }
        return e16;
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.b(this);
        }
    }

    public final void t(@Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else if (callback != null) {
            this.callback = callback;
        }
    }

    public final void u(@Nullable Context context, @Nullable com.tencent.qqnt.avatar.fetch.c request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) request);
        } else if (context != null && request != null) {
            o(request);
            n(this, context, request, false, 4, null);
        }
    }

    public final void v(@Nullable com.tencent.qqnt.avatar.fetch.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) updater);
        } else {
            this.requestUpdater = updater;
        }
    }

    public final void w(@Nullable Context context, @NotNull com.tencent.qqnt.avatar.fetch.c request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (context == null) {
            return;
        }
        n(this, context, request, false, 4, null);
    }

    @Nullable
    public final Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x(@NotNull com.tencent.qqnt.avatar.fetch.c request, boolean forceRefresh) {
        SortedMap sortedMapOf;
        com.tencent.qqnt.avatar.fetch.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, this, request, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(request, "request");
        sortedMapOf = MapsKt__MapsJVMKt.sortedMapOf(new Pair[0]);
        com.tencent.qqnt.avatar.fetch.d d16 = com.tencent.qqnt.avatar.core.a.d(MetaResourceFetcher.f352881b, request.c(), false, 2, null);
        if (d16 == null) {
            return null;
        }
        if (d16.c() && d16.b() != null) {
            sortedMapOf.put(Integer.valueOf(d16.a().b()), d16.b());
        }
        List<com.tencent.qqnt.avatar.bean.a> d17 = request.d();
        if (d17 != null) {
            for (final com.tencent.qqnt.avatar.bean.a aVar : d17) {
                final com.tencent.qqnt.avatar.core.a aVar2 = H.get(Integer.valueOf(aVar.b()));
                com.tencent.qqnt.avatar.util.d.f352991a.a(this.tag, new Function0<String>(aVar2) { // from class: com.tencent.qqnt.avatar.core.ResourceOrganizer$syncFetchResource$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ a $fetcher;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$fetcher = aVar2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.bean.a.this, (Object) aVar2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "fetcher resource: " + com.tencent.qqnt.avatar.bean.a.this.b() + ". fetcher exist? " + (this.$fetcher != null);
                    }
                });
                if (aVar2 != null) {
                    dVar = aVar2.c(aVar, forceRefresh);
                } else {
                    dVar = null;
                }
                if (dVar != null && dVar.c() && dVar.b() != null) {
                    sortedMapOf.put(Integer.valueOf(dVar.a().b()), dVar.b());
                }
            }
        }
        if (sortedMapOf.isEmpty()) {
            return null;
        }
        return sortedMapOf;
    }
}
