package com.tencent.mobileqq.guild.feed.webbundle;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.webbundle.j;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.tencent.webbundle.sdk.WebBundleConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u0001:\u0003\u0014-0B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000fH\u0002J\u001a\u0010'\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\fH\u0002R\u0018\u0010)\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0+j\b\u0012\u0004\u0012\u00020\u000f`,0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001e0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager;", "Lcom/tencent/mobileqq/guild/feed/webbundle/j$b;", "", "w", "", "y", "Lcom/tencent/mobileqq/guild/feed/webbundle/k;", "p", "Lcom/tencent/mobileqq/guild/feed/webbundle/s;", "u", "Landroid/content/Context;", "context", "", WebAccelerateHelper.KEY_PRELOAD_URL, "B", "Lcom/tencent/mobileqq/guild/feed/webbundle/j;", DomainData.DOMAIN_NAME, "webBundle", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "state", "a", "", "delay", "url", "D", "j", "runtime", DownloadInfo.spKey_Config, HippyTKDListViewAdapter.X, "k", "", ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "i", "guildWebBundle", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", "Lcom/tencent/mobileqq/guild/feed/webbundle/j;", "curPreloadingOne", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "preloadedPool", "c", "preloadFailCntMap", "d", "Lcom/tencent/mobileqq/guild/feed/webbundle/k;", "e", "Lcom/tencent/mobileqq/guild/feed/webbundle/s;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "g", "Lkotlin/Lazy;", "v", "()Z", "webKernelCheckEnable", "<init>", "()V", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildWebBundleManager implements j.b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildWebBundleManager> f224076i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j curPreloadingOne;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, ArrayList<j>> preloadedPool;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Integer> preloadFailCntMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private k config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private s runtime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isInit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy webKernelCheckEnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager$a;", "", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildWebBundleManager b() {
            return (GuildWebBundleManager) GuildWebBundleManager.f224076i.getValue();
        }

        @JvmStatic
        @NotNull
        public final GuildWebBundleManager a() {
            return b();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager$b;", "Lcom/tencent/mobileqq/guild/feed/webbundle/u;", "", TencentLocation.RUN_MODE, "", "getTaskId", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", WebAccelerateHelper.KEY_PRELOAD_URL, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements u {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String preloadUrl;

        public b(@NotNull Context context, @NotNull String preloadUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(preloadUrl, "preloadUrl");
            this.context = context;
            this.preloadUrl = preloadUrl;
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.u
        @NotNull
        public String getTaskId() {
            return "guild_preload";
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.u
        public int run() {
            GuildWebBundleManager.INSTANCE.a().B(this.context, this.preloadUrl);
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager$c;", "Lcom/tencent/mobileqq/guild/feed/webbundle/u;", "", TencentLocation.RUN_MODE, "", "getTaskId", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements u {
        @Override // com.tencent.mobileqq.guild.feed.webbundle.u
        @NotNull
        public String getTaskId() {
            return "guild_preload_tool";
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.u
        public int run() {
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f224088a;

        static {
            int[] iArr = new int[GuildWebBundlePreloadState.values().length];
            try {
                iArr[GuildWebBundlePreloadState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildWebBundlePreloadState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f224088a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleManager$e", "Lcom/tencent/mobileqq/guild/feed/webbundle/l;", "", "isEnable", "", "enableWebBundle", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements l {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.l
        public void enableWebBundle(boolean isEnable) {
            Logger.f235387a.d().d("GuildWebBundleManager", 1, "initInner FeedWebBundle== enableWebBundle " + isEnable);
            ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).setWebBundlePreloadEnable(isEnable);
            if (!isEnable) {
                GuildWebBundleManager.this.j();
            }
        }
    }

    static {
        Lazy<GuildWebBundleManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildWebBundleManager>() { // from class: com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildWebBundleManager invoke() {
                return new GuildWebBundleManager(null);
            }
        });
        f224076i = lazy;
    }

    public /* synthetic */ GuildWebBundleManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void A(j guildWebBundle) {
        String preloadUrl = guildWebBundle.getPreloadUrl();
        if (this.curPreloadingOne == guildWebBundle) {
            this.curPreloadingOne = null;
        }
        ArrayList<j> arrayList = this.preloadedPool.get(preloadUrl);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(guildWebBundle);
        this.preloadedPool.put(preloadUrl, arrayList);
        Logger.f235387a.d().d("GuildWebBundleManager", 1, "onPreloadSuccess FeedWebBundle== preloading=" + t() + ", preloaded=" + s(preloadUrl) + ", preloadUrl=" + preloadUrl);
        this.preloadFailCntMap.put(preloadUrl, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(GuildWebBundleManager this$0, Context context, String preloadUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(preloadUrl, "$preloadUrl");
        this$0.k(context, preloadUrl);
    }

    public static /* synthetic */ void E(GuildWebBundleManager guildWebBundleManager, long j3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        guildWebBundleManager.D(j3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GuildWebBundleManager this$0, long j3, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.l(j3, url);
    }

    private final boolean i(String url) {
        int s16 = s(url);
        k kVar = this.config;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            kVar = null;
        }
        if (s16 < kVar.getPreloadWebViewCount() && q(url) < 2) {
            return true;
        }
        return false;
    }

    private final void k(Context context, String preloadUrl) {
        boolean z16;
        String str;
        if (this.curPreloadingOne != null) {
            Logger.f235387a.d().d("GuildWebBundleManager", 1, "doPreload FeedWebBundle== current Loading, so return!");
            return;
        }
        if (preloadUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = r();
        } else {
            str = preloadUrl;
        }
        if (!i(str)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("doPreload FeedWebBundle== url can not preload");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it.next(), null);
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            Logger.f235387a.d().d("GuildWebBundleManager", 1, "doPreload FeedWebBundle== preloading=" + t() + ", preloaded=" + s(str) + ", preloadUrl=" + preloadUrl + " url=" + ((Object) str));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("preload_type", "guild_feed_detail_default");
            jSONObject.put(WebBundleConstants.WEBBUNDLE_PRELOAD_URL, preloadUrl);
            j jVar = new j(context);
            jVar.v(str, jSONObject, this);
            this.curPreloadingOne = jVar;
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("doPreload FeedWebBundle== url is invalid, so return!");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it5.next(), null);
        }
    }

    private final void l(long delay, final String url) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.n
            @Override // java.lang.Runnable
            public final void run() {
                GuildWebBundleManager.m(GuildWebBundleManager.this, url);
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildWebBundleManager this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        GuildFeedDetailIdleTaskHelper a16 = GuildFeedDetailIdleTaskHelper.INSTANCE.a();
        s sVar = this$0.runtime;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("runtime");
            sVar = null;
        }
        a16.f(new b(sVar.getContext(), url));
    }

    public static /* synthetic */ j o(GuildWebBundleManager guildWebBundleManager, Context context, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return guildWebBundleManager.n(context, str);
    }

    private final int q(String url) {
        Integer num = this.preloadFailCntMap.get(url);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    private final String r() {
        Object firstOrNull;
        k kVar = this.config;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            kVar = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) kVar.c());
        String str = (String) firstOrNull;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(String url) {
        ArrayList<j> arrayList = this.preloadedPool.get(url);
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        if (this.curPreloadingOne != null) {
            return 1;
        }
        return 0;
    }

    private final boolean v() {
        return ((Boolean) this.webKernelCheckEnable.getValue()).booleanValue();
    }

    private final synchronized void x(s runtime, k config) {
        Logger logger = Logger.f235387a;
        logger.d().d("GuildWebBundleManager", 1, "initInner FeedWebBundle== alreadyInit=" + this.isInit.get());
        if (this.isInit.compareAndSet(false, true)) {
            this.runtime = runtime;
            this.config = config;
            logger.d().d("GuildWebBundleManager", 1, "initInner FeedWebBundle== init=====success");
            config.f(new e());
        }
    }

    private final void z(j guildWebBundle) {
        String preloadUrl = guildWebBundle.getPreloadUrl();
        if (this.curPreloadingOne == guildWebBundle) {
            this.curPreloadingOne = null;
        }
        Integer num = this.preloadFailCntMap.get(preloadUrl);
        if (num == null) {
            num = 0;
        }
        this.preloadFailCntMap.put(preloadUrl, Integer.valueOf(num.intValue() + 1));
    }

    public final void B(@NotNull final Context context, @NotNull final String preloadUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadUrl, "preloadUrl");
        QLog.i("GuildWebBundleManager", 1, "preload FeedWebBundle== preloadUrl=" + preloadUrl + " ");
        if (!this.isInit.get()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("preload FeedWebBundle== not init, so return!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it.next(), null);
            }
            return;
        }
        if (!((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).enableWebBundlePreload()) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("preload FeedWebBundle== disable,so return!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it5.next(), null);
            }
            return;
        }
        if (v() && !com.tencent.mobileqq.webview.swift.utils.m.e()) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("preload  FeedWebBundle== webKernel uninitiated");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it6.next(), null);
            }
            return;
        }
        if (UiThreadUtil.isOnUiThread()) {
            k(context, preloadUrl);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.o
                @Override // java.lang.Runnable
                public final void run() {
                    GuildWebBundleManager.C(GuildWebBundleManager.this, context, preloadUrl);
                }
            });
        }
    }

    public final void D(final long delay, @NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("GuildWebBundleManager", 1, "preloadWhileOnIdle isInit=" + y() + " delay=" + delay);
        if (y()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildWebBundleManager.F(GuildWebBundleManager.this, delay, url);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.j.b
    public void a(@NotNull j webBundle, @NotNull GuildWebBundlePreloadState state) {
        Intrinsics.checkNotNullParameter(webBundle, "webBundle");
        Intrinsics.checkNotNullParameter(state, "state");
        int i3 = d.f224088a[state.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                z(webBundle);
                return;
            }
            return;
        }
        A(webBundle);
    }

    public final void j() {
        Logger.f235387a.d().d("GuildWebBundleManager", 1, "destroy GuildWebBundle.");
        if (y()) {
            j jVar = this.curPreloadingOne;
            if (jVar != null) {
                jVar.k("destroy");
            }
            Iterator<Map.Entry<String, ArrayList<j>>> it = this.preloadedPool.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<T> it5 = it.next().getValue().iterator();
                while (it5.hasNext()) {
                    ((j) it5.next()).j();
                }
            }
            this.preloadedPool.clear();
            this.preloadFailCntMap.clear();
            this.isInit.set(false);
            k kVar = this.config;
            s sVar = null;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                kVar = null;
            }
            kVar.e();
            s sVar2 = this.runtime;
            if (sVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("runtime");
            } else {
                sVar = sVar2;
            }
            sVar.destroy();
        }
        GuildFeedDetailIdleTaskHelper.INSTANCE.a().l("guild_preload");
    }

    @Nullable
    public final j n(@NotNull Context context, @NotNull String preloadUrl) {
        boolean z16;
        boolean z17;
        j jVar;
        String str;
        t webView;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadUrl, "preloadUrl");
        boolean enableWebBundlePreload = ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).enableWebBundlePreload();
        QLog.i("GuildWebBundleManager", 1, "getAvailableWebBundle FeedWebBundle== isInit=" + this.isInit.get() + " isEnable=" + enableWebBundlePreload + " preloadUrl=" + preloadUrl);
        if (this.isInit.get() && enableWebBundlePreload) {
            if (preloadUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ConcurrentHashMap<String, ArrayList<j>> concurrentHashMap = this.preloadedPool;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ArrayList<j>> entry : concurrentHashMap.entrySet()) {
                    if (!entry.getValue().isEmpty()) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(linkedHashMap.keySet());
                preloadUrl = (String) firstOrNull;
            }
            if (preloadUrl != null && preloadUrl.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("getAvailableWebBundle FeedWebBundle== currentPreloadUrl is empty, return null");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it.next(), null);
                }
                return null;
            }
            ArrayList<j> arrayList = this.preloadedPool.get(preloadUrl);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            Logger.f235387a.d().d("GuildWebBundleManager", 1, "getAvailableWebBundle FeedWebBundle== . preloading=" + t() + ", preloaded=" + s(preloadUrl) + ", currentPreloadUrl=" + preloadUrl);
            if (!arrayList.isEmpty()) {
                jVar = arrayList.remove(0);
            } else {
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("getAvailableWebBundle FeedWebBundle== preloadedList is empty");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it5.next(), null);
                }
                jVar = null;
            }
            if (jVar == null || (webView = jVar.getWebView()) == null || (str = webView.getThemeId()) == null) {
                str = "unknown";
            }
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            if (!Intrinsics.areEqual(str, currentThemeId)) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                String str2 = "getAvailableWebBundle FeedWebBundle== unMatch themeId, preloadTheme=" + str + ", currentTheme=" + currentThemeId;
                if (str2 instanceof String) {
                    bVar3.a().add(str2);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it6.next(), null);
                }
                return null;
            }
            if (jVar != null) {
                jVar.s(context);
            }
            return jVar;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar4 = new Logger.b();
        bVar4.a().add("getAvailableWebBundle FeedWebBundle== return null");
        Iterator<T> it7 = bVar4.a().iterator();
        while (it7.hasNext()) {
            Logger.f235387a.d().e("GuildWebBundleManager", 1, (String) it7.next(), null);
        }
        return null;
    }

    @NotNull
    public final k p() {
        k kVar = this.config;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            return null;
        }
        return kVar;
    }

    @NotNull
    public final s u() {
        s sVar = this.runtime;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("runtime");
            return null;
        }
        return sVar;
    }

    public final synchronized void w() {
        go1.a aVar = new go1.a();
        String webBundlePreloadUrl = ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).getWebBundlePreloadUrl();
        k g16 = new k().g(webBundlePreloadUrl);
        boolean enableWebBundlePreload = ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).enableWebBundlePreload();
        QLog.i("GuildWebBundleManager", 2, "init FeedWebBundle== webBundleEnable=" + enableWebBundlePreload + " webBundleUrl=" + webBundlePreloadUrl);
        if (!enableWebBundlePreload) {
            QLog.i("GuildWebBundleManager", 2, "FeedWebBundle== disable webBundleUrl");
        } else {
            x(aVar, g16);
        }
    }

    public final synchronized boolean y() {
        return this.isInit.get();
    }

    GuildWebBundleManager() {
        Lazy lazy;
        this.preloadedPool = new ConcurrentHashMap<>();
        this.preloadFailCntMap = new ConcurrentHashMap<>();
        this.isInit = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager$webKernelCheckEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_feed_webView_preload_enable_121231749", true));
            }
        });
        this.webKernelCheckEnable = lazy;
    }
}
