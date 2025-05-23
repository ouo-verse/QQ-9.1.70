package com.tencent.mm.plugin.appbrand.video.player.thumb;

import android.content.Context;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyBindServiceCallback;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public final class ThumbPlayerInitLogic {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f152322b = false;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f152324d;

    /* renamed from: a, reason: collision with root package name */
    public static final ThumbPlayerInitLogic f152321a = new ThumbPlayerInitLogic();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f152323c = new AtomicBoolean(false);

    /* loaded from: classes9.dex */
    public static final class a implements TPDLProxyBindServiceCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f152325a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f152326b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f152327c;

        public a(Context context, boolean z16, boolean z17) {
            this.f152325a = context;
            this.f152326b = z16;
            this.f152327c = z17;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyBindServiceCallback
        public final void onBindSuccess() {
            w.d("MicroMsg.AppBrand.ThumbPlayerInitLogic", "onBindSuccess");
            TPDownloadProxyHelper.setUseService(true);
            ThumbPlayerInitLogic thumbPlayerInitLogic = ThumbPlayerInitLogic.f152321a;
            Context applicationContext = this.f152325a.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            ThumbPlayerInitLogic.a(thumbPlayerInitLogic, applicationContext, null, this.f152326b, this.f152327c, 2, null);
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f152328a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z16;
            try {
                ThumbPlayerInitLogic thumbPlayerInitLogic = ThumbPlayerInitLogic.f152321a;
                Context c16 = z.c();
                Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
                ThumbPlayerInitLogic.a(thumbPlayerInitLogic, c16, false, false, 6, null);
                z16 = true;
            } catch (Throwable th5) {
                w.a("MicroMsg.AppBrand.ThumbPlayerInitLogic", th5, "initializer#isThumbPlayerAvailable, initIfNeed fail", new Object[0]);
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(b.f152328a);
        f152324d = lazy;
    }

    public final boolean a() {
        return ((Boolean) f152324d.getValue()).booleanValue();
    }

    public static /* synthetic */ void a(ThumbPlayerInitLogic thumbPlayerInitLogic, Context context, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        thumbPlayerInitLogic.a(context, z16, z17);
    }

    public final void a(Context context, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!f152323c.compareAndSet(false, true)) {
            w.a("MicroMsg.AppBrand.ThumbPlayerInitLogic", "initIfNeed, already init");
            return;
        }
        TPPlayerMgr.setOnLogListener(new TPPlayerMgr.OnLogListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbPlayerInitLogic$initIfNeedInner$1

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String tpPlayerTag = "MicroMsg.AppBrand.TPPlayer";

            public int d(String tag, String msg2) {
                w.a(this.tpPlayerTag, tag + ':' + msg2);
                return 0;
            }

            public int e(String tag, String msg2) {
                w.b(this.tpPlayerTag, tag + ':' + msg2);
                return 0;
            }

            public int i(String tag, String msg2) {
                w.d(this.tpPlayerTag, tag + ':' + msg2);
                return 0;
            }

            public int v(String tag, String msg2) {
                w.e(this.tpPlayerTag, tag + ':' + msg2);
                return 0;
            }

            public int w(String tag, String msg2) {
                w.f(this.tpPlayerTag, tag + ':' + msg2);
                return 0;
            }
        });
        TPPlayerMgr.initSdk(context.getApplicationContext(), "60303", 1);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initIfNeed, useIsolateProxy: ");
        boolean z18 = f152322b;
        sb5.append(z18);
        w.a("MicroMsg.AppBrand.ThumbPlayerInitLogic", sb5.toString());
        TPPlayerMgr.setProxyEnable(true);
        TPPlayerMgr.setProxyServiceType(100);
        TPDownloadProxyHelper.setUseService(false);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        a(applicationContext, com.tencent.luggage.wxa.zk.a.a(), z16, z17);
        if (z18) {
            TPDownloadProxyHelper.setContext(context.getApplicationContext());
            TPDownloadProxyFactory.ensurePlayManagerService(new a(context, z16, z17));
        }
    }

    public static /* synthetic */ void a(ThumbPlayerInitLogic thumbPlayerInitLogic, Context context, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "main";
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        thumbPlayerInitLogic.a(context, str, z16, z17);
    }

    public final void a(Context context, String str, boolean z16, boolean z17) {
        ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(f152322b ? 101 : 100);
        Pair a16 = f152321a.a(str);
        String str2 = (String) a16.component1();
        String str3 = (String) a16.component2();
        JSONObject jSONObject = new JSONObject();
        if (z16) {
            try {
                jSONObject.put("VodCacheEnable", true);
                jSONObject.put("MemoryAjustInterval", Integer.MAX_VALUE);
            } catch (Exception unused) {
            }
        }
        jSONObject.put("EnableOnlyHttpsUseCurl", false);
        if (z17) {
            jSONObject.put("key_localserver_buffer_size", 524288L);
            jSONObject.put("key_localserver_send_socket_buffer_size", 131072L);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject()\n           \u2026              .toString()");
        tPDownloadProxy.init(context, new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(context), TPPlayerConfig.getGuid(), str2, str3, jSONObject2));
        if (z16) {
            tPDownloadProxy.setUserData("max_use_memory", 5);
        }
        tPDownloadProxy.setMaxStorageSizeMB(512L);
    }

    public final Pair a(String str) {
        w.a("MicroMsg.AppBrand.ThumbPlayerInitLogic", "getCacheDirs, processName: " + str);
        v vVar = new v(com.tencent.luggage.wxa.db.a.e(), "ThumbVideoCache/TPDownload");
        x.m(vVar.g());
        v vVar2 = new v(vVar, str);
        x.m(vVar2.g());
        String g16 = new v(vVar2, "cache").g();
        x.m(g16);
        String b16 = x.b(g16, true);
        String g17 = new v(vVar2, "data").g();
        x.m(g17);
        return TuplesKt.to(b16, x.b(g17, true));
    }
}
