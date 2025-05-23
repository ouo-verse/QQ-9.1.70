package com.tencent.sqshow.zootopia.report;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import id3.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0002\u0005\tB\u0019\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/b;", "", "Landroid/content/Intent;", "intent", "", "a", "c", "d", "e", "b", "", "I", "viewType", "mapId", "Lcom/tencent/sqshow/zootopia/report/b$b;", "Lcom/tencent/sqshow/zootopia/report/b$b;", "statistics", "state", "<init>", "(II)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final d f372694f = new d(null, 1, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mapId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final C9838b statistics = new C9838b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int state = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/b$a;", "", "Landroid/content/Intent;", "intent", "", "b", "Landroid/os/Bundle;", "bundle", "c", "", "viewType", "mapId", "Lcom/tencent/sqshow/zootopia/report/b;", "a", "", "KEY_CLICK_SERVER_TIME", "Ljava/lang/String;", "KEY_CLICK_TIME", "KEY_IS_ENGINE_READY", "STATE_APPEAR", "I", "STATE_ENTER_SCENE", "STATE_FIRST_FRAME", "TAG", "TYPE_GAME", "TYPE_PORTAL", "TYPE_RESIDENCE", "TYPE_SCENE", "Lid3/d;", "reporter", "Lid3/d;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.report.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(int viewType, int mapId) {
            return new b(viewType, mapId);
        }

        public final void b(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("key_click_time", SystemClock.uptimeMillis());
            intent.putExtra("key_click_server_time", NetConnInfoCenter.getServerTimeMillis());
            intent.putExtra("key_is_engine_ready", ZPlanServiceHelper.I.l0());
        }

        public final void c(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong("key_click_time", SystemClock.uptimeMillis());
            bundle.putBoolean("key_is_engine_ready", ZPlanServiceHelper.I.l0());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bR\"\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/b$b;", "", "", "b", "c", "j", "d", "a", "", "e", "", "Z", "isEngineReady", "()Z", "k", "(Z)V", "J", "f", "()J", "l", "(J)V", NodeProps.ON_CLICK, "getOnCreate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onCreate", "g", DomainData.DOMAIN_NAME, "onEngineReady", "getOnRoomEntered", "setOnRoomEntered", "onRoomEntered", h.F, "o", "onEnterScene", "i", "p", "onFirstFrame", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.report.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9838b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isEngineReady;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long onClick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long onCreate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long onEngineReady;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long onRoomEntered;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long onEnterScene;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long onFirstFrame;

        public final long a() {
            return this.onFirstFrame - this.onClick;
        }

        public final long b() {
            return this.onCreate - this.onClick;
        }

        public final long c() {
            long coerceAtLeast;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.onEngineReady - this.onCreate, 0L);
            return coerceAtLeast;
        }

        public final long d() {
            return this.onFirstFrame - this.onEnterScene;
        }

        public final int e() {
            return this.isEngineReady ? 1 : 0;
        }

        /* renamed from: f, reason: from getter */
        public final long getOnClick() {
            return this.onClick;
        }

        /* renamed from: g, reason: from getter */
        public final long getOnEngineReady() {
            return this.onEngineReady;
        }

        /* renamed from: h, reason: from getter */
        public final long getOnEnterScene() {
            return this.onEnterScene;
        }

        /* renamed from: i, reason: from getter */
        public final long getOnFirstFrame() {
            return this.onFirstFrame;
        }

        public final long j() {
            long coerceAtLeast;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.onRoomEntered - this.onCreate, 0L);
            return coerceAtLeast;
        }

        public final void k(boolean z16) {
            this.isEngineReady = z16;
        }

        public final void l(long j3) {
            this.onClick = j3;
        }

        public final void m(long j3) {
            this.onCreate = j3;
        }

        public final void n(long j3) {
            this.onEngineReady = j3;
        }

        public final void o(long j3) {
            this.onEnterScene = j3;
        }

        public final void p(long j3) {
            this.onFirstFrame = j3;
        }
    }

    public b(int i3, int i16) {
        this.viewType = i3;
        this.mapId = i16;
    }

    public final void a(Intent intent) {
        this.statistics.k(intent != null ? intent.getBooleanExtra("key_is_engine_ready", false) : false);
        this.statistics.l(intent != null ? intent.getLongExtra("key_click_time", 0L) : 0L);
        this.statistics.m(SystemClock.uptimeMillis());
        this.state = 1;
    }

    public final void b() {
        Map<String, Object> mutableMapOf;
        d dVar = f372694f;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_view_type", Integer.valueOf(this.viewType)), TuplesKt.to("zplan_scene_status", Integer.valueOf(this.state)), TuplesKt.to("zplan_scene_stay_time", Long.valueOf(SystemClock.uptimeMillis() - this.statistics.getOnClick())), TuplesKt.to("zplan_map_id", Integer.valueOf(this.mapId)));
        dVar.d("ev_zplan_leave_avatar_scene", mutableMapOf);
    }

    public final void c() {
        if (this.statistics.getOnEngineReady() <= 0) {
            this.statistics.n(SystemClock.uptimeMillis());
        }
    }

    public final void d() {
        if (this.statistics.getOnEnterScene() <= 0) {
            this.statistics.o(SystemClock.uptimeMillis());
            this.state = 2;
        }
    }

    public final void e() {
        Map<String, Object> mutableMapOf;
        if (this.statistics.getOnFirstFrame() > 0) {
            return;
        }
        this.statistics.p(SystemClock.uptimeMillis());
        this.state = 3;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_view_type", Integer.valueOf(this.viewType)), TuplesKt.to("zplan_click_to_appear", Long.valueOf(this.statistics.b())), TuplesKt.to("zplan_appear_to_engine_ready", Long.valueOf(this.statistics.c())), TuplesKt.to("zplan_appear_to_enter_room", Long.valueOf(this.statistics.j())), TuplesKt.to("zplan_call_lua_to_first_frame", Long.valueOf(this.statistics.d())), TuplesKt.to("zplan_click_to_first_frame", Long.valueOf(this.statistics.a())), TuplesKt.to("zplan_is_engine_ready", Integer.valueOf(this.statistics.e())), TuplesKt.to("zplan_map_id", Integer.valueOf(this.mapId)));
        f372694f.d("ev_zplan_enter_avatar_scene", mutableMapOf);
        QLog.i("ZootopiaTechReporter", 1, "cost time collect: " + mutableMapOf);
    }
}
