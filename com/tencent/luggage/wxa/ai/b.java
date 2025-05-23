package com.tencent.luggage.wxa.ai;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.KeyEvent;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002>A\u0018\u0000 \u00042\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\n\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u001d\u0010%\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b\u0013\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R+\u00100\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b\u0013\u0010/R*\u00107\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b\n\u00106R\"\u0010:\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010.\"\u0004\b\u0010\u0010/R\"\u0010;\u001a\u00020\r8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00109\u001a\u0004\b'\u0010.\"\u0004\b\u001b\u0010/R+\u0010=\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b<\u0010.\"\u0004\b\n\u0010/R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010BR\u001b\u0010F\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b2\u0010ER\u0013\u0010I\u001a\u0004\u0018\u00010G8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/luggage/wxa/ai/b;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", DomainData.DOMAIN_NAME, "Lorg/json/JSONObject;", "data", "", "a", "Lcom/tencent/luggage/wxa/z7/c;", "invokeContext", "", "", "e", "d", "", "updateVideoPath", "b", "Lcom/tencent/luggage/wxa/z7/c;", "I", "j", "()I", "(I)V", "videoCurrentPosition", "Lcom/tencent/luggage/wxa/xd/d;", "c", "Lcom/tencent/luggage/wxa/xd/d;", "()Lcom/tencent/luggage/wxa/xd/d;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/luggage/wxa/ai/j;", "Lcom/tencent/luggage/wxa/ai/j;", "volumeObserver", "Landroid/media/AudioManager;", "Lkotlin/Lazy;", "()Landroid/media/AudioManager;", "audioManager", "Lcom/tencent/luggage/wxa/bi/c;", "f", "Lcom/tencent/luggage/wxa/bi/c;", "castReportHelper", "<set-?>", "g", "Lkotlin/properties/ReadWriteProperty;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "(Z)V", "isForeground", "path", tl.h.F, "Ljava/lang/String;", "k", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "videoPath", "i", "Z", "videoCastEnable", IGuildSpeechApi.KEY_NEED_INTERCEPT, "l", "isCastMediaPresent", "com/tencent/luggage/wxa/ai/b$j", "Lcom/tencent/luggage/wxa/ai/b$j;", "volumeDownKeyObserver", "com/tencent/luggage/wxa/ai/b$k", "Lcom/tencent/luggage/wxa/ai/b$k;", "volumeUpKeyObserver", "Lcom/tencent/luggage/wxa/bi/h;", "()Lcom/tencent/luggage/wxa/bi/h;", "videoCastController", "Lcom/tencent/luggage/wxa/ic/g;", "()Lcom/tencent/luggage/wxa/ic/g;", "runtime", "Lcom/tencent/luggage/wxa/j8/a;", "eventHandler", "<init>", "(Lcom/tencent/luggage/wxa/j8/a;Lcom/tencent/luggage/wxa/z7/c;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final String f121436q = "MicroMsg.VideoCast.AppBrandVideoCastHandler";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.luggage.wxa.z7.c invokeContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int videoCurrentPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.luggage.wxa.xd.d component;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.luggage.wxa.ai.j volumeObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy audioManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.luggage.wxa.bi.c castReportHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty isForeground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean videoCastEnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean needIntercept;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty isCastMediaPresent;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j volumeDownKeyObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k volumeUpKeyObserver;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoCastController;

    /* renamed from: p, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f121435p = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "isForeground", "isForeground()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "isCastMediaPresent", "isCastMediaPresent()Z", 0))};

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements g.d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public final void onForeground() {
            b.this.b(true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ai.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6014b implements g.b {
        public C6014b() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public final void onBackground() {
            b.this.b(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f121453a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AudioManager invoke() {
            return (AudioManager) z.c().getSystemService("audio");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {
        public e() {
            super(0);
        }

        public final void a() {
            b.this.c(true);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f121455a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Object obj, b bVar) {
            super(obj);
            this.f121455a = bVar;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            boolean booleanValue2 = ((Boolean) obj).booleanValue();
            w.d(b.f121436q, "isForeground = " + booleanValue + TokenParser.SP);
            if (booleanValue && !booleanValue2) {
                this.f121455a.h().i();
            }
            if (!booleanValue && !booleanValue2) {
                this.f121455a.h().h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f121456a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj, b bVar) {
            super(obj);
            this.f121456a = bVar;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            ((Boolean) obj).booleanValue();
            if (!booleanValue || !this.f121456a.m()) {
                this.f121456a.p();
                this.f121456a.q();
            } else {
                this.f121456a.n();
                this.f121456a.o();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {
        public h() {
            super(1);
        }

        public final void a(boolean z16) {
            com.tencent.luggage.wxa.bi.h.a(b.this.h(), 0, 0, 3, (Object) null);
            if (!z16) {
                b.this.a(false);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j8.a f121459b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(com.tencent.luggage.wxa.j8.a aVar) {
            super(0);
            this.f121459b = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.bi.h invoke() {
            return new com.tencent.luggage.wxa.bi.h(b.this.invokeContext, this.f121459b, b.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends com.tencent.luggage.wxa.ic.z {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f121461a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.f121461a = bVar;
            }

            public final void a(com.tencent.luggage.wxa.bi.f it) {
                Intrinsics.checkNotNullParameter(it, "it");
                w.d(b.f121436q, "volume now:" + it.a());
                com.tencent.luggage.wxa.bi.h h16 = this.f121461a.h();
                Intrinsics.checkNotNull(it.a());
                h16.b(((Number) r3).intValue() - 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((com.tencent.luggage.wxa.bi.f) obj);
                return Unit.INSTANCE;
            }
        }

        public j() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            w.d(b.f121436q, "volume down");
            b.this.h().a(new a(b.this));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends com.tencent.luggage.wxa.ic.z {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f121463a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.f121463a = bVar;
            }

            public final void a(com.tencent.luggage.wxa.bi.f it) {
                Intrinsics.checkNotNullParameter(it, "it");
                w.d(b.f121436q, "volume now:" + it.a());
                com.tencent.luggage.wxa.bi.h h16 = this.f121463a.h();
                Object a16 = it.a();
                Intrinsics.checkNotNull(a16);
                h16.b(((Number) a16).intValue() + 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((com.tencent.luggage.wxa.bi.f) obj);
                return Unit.INSTANCE;
            }
        }

        public k() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            w.d(b.f121436q, "volume up");
            b.this.h().a(new a(b.this));
            return true;
        }
    }

    public b(@NotNull com.tencent.luggage.wxa.j8.a eventHandler, @NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        this.invokeContext = invokeContext;
        com.tencent.luggage.wxa.xd.d e16 = invokeContext.e();
        Intrinsics.checkNotNullExpressionValue(e16, "invokeContext.component");
        this.component = e16;
        Context c16 = z.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
        this.volumeObserver = new com.tencent.luggage.wxa.ai.j(c16, null);
        lazy = LazyKt__LazyJVMKt.lazy(d.f121453a);
        this.audioManager = lazy;
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bi.c.class));
        Delegates delegates = Delegates.INSTANCE;
        this.isForeground = new f(Boolean.TRUE, this);
        com.tencent.luggage.wxa.bi.d.a(invokeContext);
        if (e16 instanceof com.tencent.luggage.wxa.xd.f) {
            com.tencent.luggage.wxa.xd.f fVar = (com.tencent.luggage.wxa.xd.f) e16;
            fVar.b(new a());
            fVar.a(new C6014b());
        }
        this.videoPath = "";
        this.isCastMediaPresent = new g(Boolean.FALSE, this);
        this.volumeDownKeyObserver = new j();
        this.volumeUpKeyObserver = new k();
        lazy2 = LazyKt__LazyJVMKt.lazy(new i(eventHandler));
        this.videoCastController = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.luggage.wxa.bi.h h() {
        return (com.tencent.luggage.wxa.bi.h) this.videoCastController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        com.tencent.luggage.wxa.ic.g g16 = g();
        if (g16 != null) {
            g16.a(25, -1, this.volumeDownKeyObserver);
        }
        com.tencent.luggage.wxa.ic.g g17 = g();
        if (g17 != null) {
            g17.a(24, -1, this.volumeUpKeyObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        z.c().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.volumeObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        com.tencent.luggage.wxa.ic.g g16 = g();
        if (g16 != null) {
            g16.a((com.tencent.luggage.wxa.ic.z) this.volumeDownKeyObserver);
        }
        com.tencent.luggage.wxa.ic.g g17 = g();
        if (g17 != null) {
            g17.a((com.tencent.luggage.wxa.ic.z) this.volumeUpKeyObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        z.c().getContentResolver().unregisterContentObserver(this.volumeObserver);
    }

    @Nullable
    public final com.tencent.luggage.wxa.ic.g g() {
        com.tencent.luggage.wxa.z7.c cVar = this.invokeContext;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
            if (e16 == null) {
                return null;
            }
            if (e16 instanceof com.tencent.luggage.wxa.ic.d) {
                return ((com.tencent.luggage.wxa.ic.d) e16).getRuntime();
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: i, reason: from getter */
    public final boolean getVideoCastEnable() {
        return this.videoCastEnable;
    }

    /* renamed from: j, reason: from getter */
    public final int getVideoCurrentPosition() {
        return this.videoCurrentPosition;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getVideoPath() {
        return this.videoPath;
    }

    public final boolean l() {
        return ((Boolean) this.isCastMediaPresent.getValue(this, f121435p[1])).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) this.isForeground.getValue(this, f121435p[0])).booleanValue();
    }

    private final AudioManager b() {
        return (AudioManager) this.audioManager.getValue();
    }

    public final void a(int i3) {
        this.videoCurrentPosition = i3;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final com.tencent.luggage.wxa.xd.d getComponent() {
        return this.component;
    }

    public final void d(boolean z16) {
        this.videoCastEnable = z16;
    }

    public final int e() {
        AudioManager b16 = b();
        if (b16 != null) {
            return b16.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final boolean f() {
        if (this.videoCastEnable) {
            return this.needIntercept;
        }
        return false;
    }

    public final void a(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.videoPath = path;
    }

    public final void b(boolean z16) {
        this.isForeground.setValue(this, f121435p[0], Boolean.valueOf(z16));
    }

    public final void c(boolean z16) {
        this.needIntercept = z16;
    }

    public final int d() {
        AudioManager b16 = b();
        if (b16 != null) {
            return SystemMethodProxy.getStreamVolume(b16, 3);
        }
        return 0;
    }

    public final void a(boolean z16) {
        this.isCastMediaPresent.setValue(this, f121435p[1], Boolean.valueOf(z16));
    }

    public final void b(@NotNull String updateVideoPath) {
        CharSequence trim;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(updateVideoPath, "updateVideoPath");
        w.d(f121436q, "updateVideoPath: [" + updateVideoPath + ']');
        trim = StringsKt__StringsKt.trim((CharSequence) updateVideoPath);
        isBlank = StringsKt__StringsJVMKt.isBlank(trim.toString());
        if (isBlank) {
            return;
        }
        h().i();
        if (Intrinsics.areEqual(updateVideoPath, this.videoPath)) {
            return;
        }
        a(updateVideoPath);
        a(true);
        h().c(new h());
        if (h().f() == -1) {
            h().a(8);
        } else {
            w.d(f121436q, "discard a updateVideoPath report event");
        }
    }

    public void a() {
        h().a();
        this.needIntercept = false;
        a(false);
        h().i();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ai.b$c, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i3) {
            StringBuilder sb5 = new StringBuilder();
            int i16 = i3 / 1000;
            sb5.setLength(0);
            String formatter = new Formatter(sb5, Locale.getDefault()).format("%02d:%02d:%02d", Integer.valueOf(i16 / 3600), Integer.valueOf((i16 / 60) % 60), Integer.valueOf(i16 % 60)).toString();
            Intrinsics.checkNotNullExpressionValue(formatter, "formatter.format(\"%02d:%\u2026utes, seconds).toString()");
            return formatter;
        }

        public final long a(String str) {
            int lastIndexOf$default;
            List emptyList;
            int lastIndexOf$default2;
            String valueOf = String.valueOf(str);
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) valueOf, ".", 0, false, 6, (Object) null);
            if (lastIndexOf$default != -1) {
                lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) valueOf, ".", 0, false, 6, (Object) null);
                valueOf = valueOf.substring(0, lastIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(valueOf, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            List<String> split = new Regex(":").split(valueOf, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (!(listIterator.previous().length() == 0)) {
                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            Object[] array = emptyList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length == 3) {
                return ((Long.parseLong(strArr[0]) * 3600) + (Long.parseLong(strArr[1]) * 60) + Long.parseLong(strArr[2])) * 1000;
            }
            throw new IllegalArgumentException(("Can't parse time string: " + valueOf).toString());
        }
    }

    public boolean a(@NotNull JSONObject data, @NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        String optString = data.optString("type");
        w.d(f121436q, "handleOperate: type = " + optString);
        if (optString == null) {
            return true;
        }
        switch (optString.hashCode()) {
            case -1983381905:
                if (!optString.equals("switchCasting")) {
                    return true;
                }
                h().k();
                return true;
            case -1491869371:
                if (!optString.equals("exitCasting")) {
                    return true;
                }
                com.tencent.luggage.wxa.bi.h.b(h(), null, 1, null);
                h().a();
                this.needIntercept = false;
                a(false);
                return true;
            case 3443508:
                if (!optString.equals("play")) {
                    return true;
                }
                com.tencent.luggage.wxa.bi.h.a(h(), 0, 0, 3, (Object) null);
                return true;
            case 3526264:
                if (!optString.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                    return true;
                }
                long a16 = a(data);
                if (a16 > 0) {
                    h().a(INSTANCE.a((int) a16));
                    return true;
                }
                w.d(f121436q, "invalid seek position");
                return false;
            case 106440182:
                if (!optString.equals("pause")) {
                    return true;
                }
                com.tencent.luggage.wxa.bi.h.a(h(), null, 1, null);
                return true;
            case 420897153:
                if (!optString.equals("startCasting")) {
                    return true;
                }
                h().a(new e());
                com.tencent.luggage.wxa.bi.h.a(h(), true, false, 2, (Object) null);
                return true;
            case 1082113260:
                if (!optString.equals("reconnectCasting")) {
                    return true;
                }
                h().g();
                return true;
            default:
                return true;
        }
    }

    private final long a(JSONObject data) {
        if (data != null && data.has("data")) {
            JSONArray optJSONArray = data.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                double optDouble = optJSONArray.optDouble(0, -1.0d);
                if (optDouble < 0.0d) {
                    w.h(f121436q, "parseSeekPosition, invalid position:%s", Double.valueOf(optDouble));
                    return -1L;
                }
                w.d(f121436q, "parseSeekPosition, position:%s", Double.valueOf(optDouble));
                return (long) (optDouble * 1000);
            }
            w.f(f121436q, "parseSeekPosition, data array is null");
        }
        return -1L;
    }
}
