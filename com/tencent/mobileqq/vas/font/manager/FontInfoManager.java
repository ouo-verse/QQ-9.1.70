package com.tencent.mobileqq.vas.font.manager;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.k;
import com.etrump.mixlayout.n;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.font.manager.h;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z03.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J8\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J(\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cJ:\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R/\u0010;\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000504048\u0006\u00a2\u0006\f\n\u0004\b8\u00106\u001a\u0004\b9\u0010:R$\u0010B\u001a\u0004\u0018\u00010<8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010E\u001a\u0004\u0018\u00010<8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0014\u0010G\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010FR\u0014\u0010H\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010FRP\u0010N\u001a>\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0Jj\b\u0012\u0004\u0012\u00020\u001c`K0Ij\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0Jj\b\u0012\u0004\u0012\u00020\u001c`K`L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010MR\u0014\u0010Q\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager;", "", "Landroid/os/Handler$Callback;", "", MessageForRichState.SIGN_MSG_FONT_ID, "Lcom/etrump/mixlayout/k;", "fontInfo", "", "E", MessageForRichState.SIGN_MSG_FONT_TYPE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ReportConstant.COSTREPORT_PREFIX, "isTroop", "", "uin", "", "diyTimestamp", "isSend", DomainData.DOMAIN_NAME, "font", UserInfo.SEX_FEMALE, "timestamp", "r", "enterAIO", "D", "Landroid/os/Handler;", "v", "Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager$b;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Landroid/content/Context;", "context", "u", "t", "Landroid/os/Message;", "p0", "handleMessage", "d", "Landroid/os/Handler;", "mFontHandler", "e", "mainHandler", "Landroid/os/HandlerThread;", "f", "Landroid/os/HandlerThread;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/os/HandlerThread;", "setMHandlerThread", "(Landroid/os/HandlerThread;)V", "mHandlerThread", "Ljava/util/concurrent/ConcurrentHashMap;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "sFontInfoCache", "i", "B", "()Ljava/util/concurrent/ConcurrentHashMap;", "mDIYConfigMap", "Lcom/etrump/mixlayout/ETEngine;", "Lcom/etrump/mixlayout/ETEngine;", "getMEngine", "()Lcom/etrump/mixlayout/ETEngine;", "setMEngine", "(Lcom/etrump/mixlayout/ETEngine;)V", "mEngine", "getMEngineAnimation", "setMEngineAnimation", "mEngineAnimation", "Ljava/lang/Object;", "mLoadFontLock", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "loadListenerMap", "G", "Z", "isEnable", "<init>", "()V", "H", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class FontInfoManager implements Handler.Callback {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final FontInfoManager I = new FontInfoManager();
    private static final boolean J = ZipDownloadBusiness.USE_ASYNC_FZ_SO;
    private static final boolean K = ar.INSTANCE.b("anzaihuang", "2024-06-12", "vas_font_cache_switch_config").isEnable(true);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ETEngine mEngineAnimation;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Object mLoadFontLock;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Object lock;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<b>> loadListenerMap;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler mFontHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HandlerThread mHandlerThread;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, k> sFontInfoCache;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, k>> mDIYConfigMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ETEngine mEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager$a;", "", "Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager;", "b", "()Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager;", "", "enableNewEngine", "Z", "a", "()Z", "", "KEY_CHAT_TEXT_SIZE_TYPE", "Ljava/lang/String;", "SETTING_TEXT_SIZE", "TAG", "", "TYPE_TEXT_SIZE_EXTRA_LARGE", "I", "TYPE_TEXT_SIZE_LARGE", "TYPE_TEXT_SIZE_MIDDLE", "TYPE_TEXT_SIZE_SMALL", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.manager.FontInfoManager$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return FontInfoManager.J;
        }

        @NotNull
        public final FontInfoManager b() {
            return FontInfoManager.I;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager$b;", "", "Lcom/etrump/mixlayout/k;", "fontInfo", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(@NotNull k fontInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/font/manager/FontInfoManager$c", "Lcom/tencent/mobileqq/vas/font/manager/h$b;", "", "isSuccess", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements h.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f309191b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f309192c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f309193d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f309194e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f309195f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f309196g;

        c(int i3, int i16, boolean z16, String str, long j3, boolean z17) {
            this.f309191b = i3;
            this.f309192c = i16;
            this.f309193d = z16;
            this.f309194e = str;
            this.f309195f = j3;
            this.f309196g = z17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FontInfoManager this$0, int i3, int i16, boolean z16, String uin, long j3, boolean z17) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(uin, "$uin");
            this$0.D(true);
            this$0.w(i3, i16, z16, uin, j3, z17);
        }

        @Override // com.tencent.mobileqq.vas.font.manager.h.b
        public void a(boolean isSuccess) {
            if (isSuccess) {
                ETEngine.getInstance().isEngineInited.compareAndSet(false, true);
                ETEngine.isSOLoaded.compareAndSet(false, true);
                Handler handler = FontInfoManager.this.mFontHandler;
                final FontInfoManager fontInfoManager = FontInfoManager.this;
                final int i3 = this.f309191b;
                final int i16 = this.f309192c;
                final boolean z16 = this.f309193d;
                final String str = this.f309194e;
                final long j3 = this.f309195f;
                final boolean z17 = this.f309196g;
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontInfoManager.c.c(FontInfoManager.this, i3, i16, z16, str, j3, z17);
                    }
                }, 2000L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/font/manager/FontInfoManager$d", "Lz03/b$b;", "", MessageForRichState.SIGN_MSG_FONT_ID, "", DownloadInfo.spKey_Config, "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements b.InterfaceC11643b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<ConcurrentHashMap<Integer, k>> f309197a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f309198b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FontInfoManager f309199c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f309200d;

        d(Ref.ObjectRef<ConcurrentHashMap<Integer, k>> objectRef, k kVar, FontInfoManager fontInfoManager, String str) {
            this.f309197a = objectRef;
            this.f309198b = kVar;
            this.f309199c = fontInfoManager;
            this.f309200d = str;
        }

        @Override // z03.b.InterfaceC11643b
        public void a(int fontId, @NotNull String config) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(config, "config");
            if (!this.f309197a.element.containsKey(Integer.valueOf(this.f309198b.f32751a))) {
                k kVar = this.f309198b;
                this.f309197a.element.put(Integer.valueOf(this.f309198b.f32751a), new k(kVar.f32751a, kVar.f32752b));
                this.f309199c.B().put(this.f309200d, this.f309197a.element);
            }
            k kVar2 = this.f309197a.element.get(Integer.valueOf(this.f309198b.f32751a));
            if (kVar2 != null) {
                kVar2.f32755e = config;
            }
            boolean z17 = false;
            if (kVar2 != null && (str = kVar2.f32755e) != null) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                kVar2.f32756f.parseDIYJsonString(kVar2.f32755e);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/font/manager/FontInfoManager$e", "Lcom/tencent/mobileqq/vas/font/manager/h$b;", "", "isSuccess", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements h.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f309202b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f309203c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f309204d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f309205e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f309206f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f309207g;

        e(int i3, int i16, boolean z16, String str, long j3, boolean z17) {
            this.f309202b = i3;
            this.f309203c = i16;
            this.f309204d = z16;
            this.f309205e = str;
            this.f309206f = j3;
            this.f309207g = z17;
        }

        @Override // com.tencent.mobileqq.vas.font.manager.h.b
        public void a(boolean isSuccess) {
            if (isSuccess) {
                m.c.e().f415883d.set(true);
                FontInfoManager.this.w(this.f309202b, this.f309203c, this.f309204d, this.f309205e, this.f309206f, this.f309207g);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/font/manager/FontInfoManager$f", "Lz03/b$b;", "", MessageForRichState.SIGN_MSG_FONT_ID, "", DownloadInfo.spKey_Config, "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements b.InterfaceC11643b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<k> f309208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap<Integer, k> f309209b;

        f(Ref.ObjectRef<k> objectRef, ConcurrentHashMap<Integer, k> concurrentHashMap) {
            this.f309208a = objectRef;
            this.f309209b = concurrentHashMap;
        }

        @Override // z03.b.InterfaceC11643b
        public void a(int fontId, @NotNull String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            k kVar = this.f309208a.element;
            kVar.f32755e = config;
            kVar.f32756f.parseDIYJsonString(config);
            this.f309209b.put(Integer.valueOf(fontId), this.f309208a.element);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/font/manager/FontInfoManager$g", "Lz03/b$b;", "", MessageForRichState.SIGN_MSG_FONT_ID, "", DownloadInfo.spKey_Config, "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements b.InterfaceC11643b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<k> f309210a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FontInfoManager f309211b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f309212c;

        g(Ref.ObjectRef<k> objectRef, FontInfoManager fontInfoManager, String str) {
            this.f309210a = objectRef;
            this.f309211b = fontInfoManager;
            this.f309212c = str;
        }

        @Override // z03.b.InterfaceC11643b
        public void a(int fontId, @NotNull String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            k kVar = this.f309210a.element;
            kVar.f32755e = config;
            kVar.f32756f.parseDIYJsonString(config);
            ConcurrentHashMap<Integer, k> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(Integer.valueOf(fontId), this.f309210a.element);
            this.f309211b.B().put(this.f309212c, concurrentHashMap);
        }
    }

    public FontInfoManager() {
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("VasFont", 0);
        Intrinsics.checkNotNullExpressionValue(newFreeHandlerThread, "newFreeHandlerThread(\"Va\u2026.THREAD_PRIORITY_DEFAULT)");
        this.mHandlerThread = newFreeHandlerThread;
        this.sFontInfoCache = new ConcurrentHashMap<>();
        this.mDIYConfigMap = new ConcurrentHashMap<>();
        this.mLoadFontLock = new Object();
        this.lock = new Object();
        this.loadListenerMap = new HashMap<>();
        this.isEnable = VasNtToggle.VAS_AIO_FONT_BUG_116794049.isEnable(true);
        this.mHandlerThread.start();
        this.mFontHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }

    private final k A(int fontType, int fontId) {
        if (!K) {
            return null;
        }
        if ((fontType == 3 || fontType == 4) && !m.c.e().f415884e.get() && (!m.c.e().f415882c.get() || !m.c.e().f415883d.get())) {
            return null;
        }
        k kVar = this.sFontInfoCache.get(String.valueOf(fontId));
        if (kVar != null) {
            if (kVar.f32753c == 4) {
                if (s()) {
                    m.c.e().h(fontId, kVar.f32752b);
                } else if (!m.c.e().g(fontId).booleanValue()) {
                    return null;
                }
                kVar.f32758h = m.b.g(fontId);
            }
            if (kVar.f32756f == null) {
                kVar.f32756f = new ETFont(fontId, kVar.f32752b, 16.0f, kVar.f32753c, kVar.f32754d);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(boolean enterAIO) {
        long j3;
        long j16;
        boolean z16;
        long j17;
        long j18;
        try {
            this.mEngine = ETEngine.getInstance();
            this.mEngineAnimation = ETEngine.getInstanceForAnimation();
            QLog.i("FontAnimDrawable.FontInfoManager", 1, "initFontEngine start");
            if (this.mEngine != null && this.mEngineAnimation != null) {
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                int u16 = u(sMobileQQ);
                int i3 = u16 * u16 * 240 * 18 * 2;
                if (i3 <= 1048576) {
                    i3 = 1048576;
                }
                ETEngine eTEngine = this.mEngine;
                Intrinsics.checkNotNull(eTEngine);
                boolean z17 = eTEngine.isEngineReady.get();
                ETEngine eTEngine2 = this.mEngineAnimation;
                Intrinsics.checkNotNull(eTEngine2);
                boolean z18 = eTEngine2.isEngineReady.get();
                if (!z17) {
                    try {
                        ETEngine eTEngine3 = this.mEngine;
                        Intrinsics.checkNotNull(eTEngine3);
                        z17 = eTEngine3.initEngine(18, i3);
                    } catch (Exception e16) {
                        ReportInfo value2 = VasNtCommonReporter.getFont().setValue1("init-error").setValue2(e16.getMessage());
                        if (z17) {
                            j3 = 1;
                        } else {
                            j3 = 0;
                        }
                        ReportInfo num1 = value2.setNum1(j3);
                        if (z18) {
                            j16 = 1;
                        } else {
                            j16 = 0;
                        }
                        ReportInfo.report$default(num1.setNum2(j16), false, 1, null);
                        QLog.e("FontAnimDrawable.FontInfoManager", 1, "init font engine fail " + e16.getMessage());
                        return;
                    }
                }
                if (!z18) {
                    ETEngine eTEngine4 = this.mEngineAnimation;
                    Intrinsics.checkNotNull(eTEngine4);
                    z18 = eTEngine4.initEngine(10, 3145728);
                }
                QLog.i("FontAnimDrawable.FontInfoManager", 1, "start init font engine fontsize=" + u16 + ",num=18,cache=" + i3 + ", engineInited: " + z17 + ", engineAnimationInited: " + z18);
                if (z17 && z18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ETEngine.getInstance().isEngineReady.set(true);
                    if (!enterAIO) {
                        QLog.d("FontAnimDrawable.FontInfoManager", 1, "VipFontReport: AioRefreshed");
                        return;
                    }
                    return;
                }
                ReportInfo value1 = VasNtCommonReporter.getFont().setValue1("init-error");
                if (z16) {
                    j17 = 1;
                } else {
                    j17 = 0;
                }
                ReportInfo num12 = value1.setNum1(j17);
                if (z18) {
                    j18 = 1;
                } else {
                    j18 = 0;
                }
                ReportInfo.report$default(num12.setNum2(j18), false, 1, null);
                return;
            }
            throw new Exception("create font engine Instance fail");
        } catch (Throwable th5) {
            ReportInfo.report$default(VasNtCommonReporter.getFont().setValue1("init-error").setValue2(th5.getMessage()), false, 1, null);
            QLog.e("FontAnimDrawable.FontInfoManager", 1, "init font engine fail " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int fontId, k fontInfo) {
        String valueOf = String.valueOf(fontId);
        synchronized (this.lock) {
            ArrayList<b> remove = this.loadListenerMap.remove(valueOf);
            if (remove != null) {
                Iterator<b> it = remove.iterator();
                while (it.hasNext()) {
                    it.next().a(fontInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final synchronized boolean F(k font, String uin, long diyTimestamp, boolean isSend) {
        File file;
        boolean native_loadFont;
        boolean native_loadFont2;
        try {
            file = new File(font.f32752b);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("FontAnimDrawable.FontInfoManager", 2, "load font fail", th5);
            }
        }
        if (!file.exists()) {
            ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).startDownload(font.f32751a);
            return false;
        }
        if (FileUtils.fileToBytes(file) == null) {
            FileUtils.deleteFile(file);
            ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).startDownload(font.f32751a);
            return false;
        }
        synchronized (this.mLoadFontLock) {
            ETEngine eTEngine = this.mEngine;
            Intrinsics.checkNotNull(eTEngine);
            native_loadFont = eTEngine.native_loadFont(font.f32752b, font.f32751a, isSend);
            ETEngine eTEngine2 = this.mEngineAnimation;
            Intrinsics.checkNotNull(eTEngine2);
            native_loadFont2 = eTEngine2.native_loadFont(font.f32752b, font.f32751a, isSend);
            Unit unit = Unit.INSTANCE;
        }
        if (native_loadFont && native_loadFont2) {
            if (QLog.isColorLevel()) {
                QLog.d("FontAnimDrawable.FontInfoManager", 2, "setActiveFonts refreshAIO");
            }
            r(uin, font, diyTimestamp);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FontAnimDrawable.FontInfoManager", 2, "load font fail font id=" + font.f32751a + " ret=" + native_loadFont + " ret2=" + native_loadFont2);
        }
        return false;
    }

    private final void n(final int fontId, final int fontType, final boolean isTroop, final String uin, final long diyTimestamp, final boolean isSend) {
        this.mFontHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.d
            @Override // java.lang.Runnable
            public final void run() {
                FontInfoManager.o(FontInfoManager.this, uin, fontId, fontType, diyTimestamp, isSend, isTroop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0235  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void o(final FontInfoManager this$0, final String uin, final int i3, int i16, long j3, boolean z16, boolean z17) {
        ?? r102;
        k kVar;
        String str;
        k kVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (this$0.sFontInfoCache.get(uin + "|" + i3) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("FontAnimDrawable.FontInfoManager", 2, "asyncLoadFont font " + i3 + " has loaded");
                return;
            }
            return;
        }
        final String fontPath = ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getFontPath(i3);
        Intrinsics.checkNotNullExpressionValue(fontPath, "fontBusiness.getFontPath(fontId)");
        if (new File(fontPath).exists()) {
            final k kVar3 = new k(i3, fontPath);
            kVar3.f32753c = i16;
            if (i16 == 0) {
                kVar3.f32753c = 1;
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3 || i16 == 4) {
                        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.font.manager.FontInfoManager$asyncLoadFont$1$run$1
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
                                ConcurrentHashMap concurrentHashMap;
                                ConcurrentHashMap concurrentHashMap2;
                                m.c.e().h(i3, kVar3.f32752b);
                                kVar3.f32758h = m.b.g(i3);
                                k kVar4 = kVar3;
                                kVar4.f32753c = 4;
                                if (kVar4.f32756f == null) {
                                    kVar4.f32756f = new ETFont(i3, fontPath, 16.0f, 4, kVar4.f32754d);
                                }
                                concurrentHashMap = this$0.sFontInfoCache;
                                concurrentHashMap.put(String.valueOf(i3), kVar3);
                                concurrentHashMap2 = this$0.sFontInfoCache;
                                concurrentHashMap2.put(uin + "|" + i3, kVar3);
                                this$0.E(i3, kVar3);
                            }
                        };
                        if (J) {
                            this$0.mFontHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FontInfoManager.p(Function0.this);
                                }
                            });
                            return;
                        } else {
                            this$0.mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FontInfoManager.q(Function0.this);
                                }
                            });
                            return;
                        }
                    }
                    return;
                }
                try {
                    kVar3.f32754d = Typeface.createFromFile(kVar3.f32752b);
                    this$0.sFontInfoCache.put(String.valueOf(i3), kVar3);
                    this$0.sFontInfoCache.put(uin + "|" + i3, kVar3);
                    this$0.E(i3, kVar3);
                    return;
                } catch (Exception e16) {
                    QLog.e("FontAnimDrawable.FontInfoManager", 1, "getFontInfo createTypeface error: " + e16.getMessage());
                    kVar3.f32754d = null;
                    return;
                }
            }
            if (!ETEngine.getInstance().isEngineInited.get()) {
                if (QLog.isColorLevel()) {
                    QLog.e("FontAnimDrawable.FontInfoManager", 2, "doGetUserFont and fontEngine not init");
                }
                h.Companion companion = h.INSTANCE;
                if (!companion.b().a()) {
                    r102 = 1;
                    str = "|";
                    kVar = kVar3;
                    companion.b().b(new c(i3, i16, z17, uin, j3, z16));
                    if (!ETEngine.getInstance().isEngineReady.get()) {
                        ETEngine eTEngine = this$0.mEngine;
                        if (eTEngine != null && this$0.mEngineAnimation != null) {
                            Intrinsics.checkNotNull(eTEngine);
                            if (eTEngine.native_isFontLoaded(i3)) {
                                ETEngine eTEngine2 = this$0.mEngineAnimation;
                                Intrinsics.checkNotNull(eTEngine2);
                                if (eTEngine2.native_isFontLoaded(i3)) {
                                    kVar2 = kVar;
                                    IFontManager.INSTANCE.j(r102);
                                    this$0.sFontInfoCache.put(String.valueOf(i3), kVar2);
                                    this$0.sFontInfoCache.put(uin + str + i3, kVar2);
                                    this$0.E(i3, kVar2);
                                    return;
                                }
                            }
                            if (!this$0.F(kVar, uin, j3, z16)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FontAnimDrawable.FontInfoManager", (int) r102, "doGetUserFont setActiveFont fail");
                                    return;
                                }
                                return;
                            }
                            ETFont eTFont = new ETFont(i3, fontPath, 1.0f);
                            ETEngine eTEngine3 = this$0.mEngine;
                            Intrinsics.checkNotNull(eTEngine3);
                            int native_getVariantStyleComboCount = eTEngine3.native_getVariantStyleComboCount(eTFont);
                            kVar2 = kVar;
                            kVar2.f32758h = native_getVariantStyleComboCount;
                            if (QLog.isColorLevel()) {
                                QLog.i("FontAnimDrawable.FontInfoManager", 2, "asyncLoadFont: id=" + kVar2.f32751a + " styleCount=" + kVar2.f32758h);
                            }
                            IFontManager.INSTANCE.j(r102);
                            this$0.sFontInfoCache.put(String.valueOf(i3), kVar2);
                            this$0.sFontInfoCache.put(uin + str + i3, kVar2);
                            this$0.E(i3, kVar2);
                            return;
                        }
                        boolean z18 = r102;
                        if (QLog.isColorLevel()) {
                            QLog.e("FontAnimDrawable.FontInfoManager", 2, "doGetUserFont mEngine = null");
                        }
                        if (this$0.isEnable && ETEngine.getInstance().isEngineInited.get()) {
                            ETEngine.getInstance().isEngineInited.compareAndSet(z18, false);
                            return;
                        }
                        return;
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.e("FontAnimDrawable.FontInfoManager", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
                        return;
                    }
                    return;
                }
            }
            r102 = 1;
            kVar = kVar3;
            str = "|";
            if (!ETEngine.getInstance().isEngineReady.get()) {
            }
        } else if (!MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin().equals(uin) && z17 && !e13.a.c(MobileQQ.sMobileQQ) && !e13.a.b(MobileQQ.sMobileQQ)) {
            if (QLog.isColorLevel()) {
                QLog.e("FontAnimDrawable.FontInfoManager", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("FontAnimDrawable.FontInfoManager", 2, "getFontInfo startDownload no cache");
            }
            ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).startDownload(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.util.concurrent.ConcurrentHashMap] */
    private final boolean r(String uin, k font, long timestamp) {
        String str;
        boolean z16;
        if (font.f32756f == null) {
            font.f32756f = new ETFont(font.f32751a, font.f32752b, 16.0f, font.f32753c, font.f32754d);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r16 = this.mDIYConfigMap.get(uin);
        objectRef.element = r16;
        if (r16 == 0) {
            objectRef.element = new ConcurrentHashMap();
        }
        boolean z17 = false;
        if (!ETEngine.getInstance().native_diyFontIsDIYFont(font.f32756f)) {
            return false;
        }
        font.f32757g = true;
        if (!z03.b.INSTANCE.a().c(uin, font.f32751a, timestamp, new d(objectRef, font, this, uin))) {
            return false;
        }
        if (((ConcurrentHashMap) objectRef.element).containsKey(Integer.valueOf(font.f32751a))) {
            if (font.f32751a != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("FontAnimDrawable.FontInfoManager", 2, "isDIYFont fontid = " + font.f32751a + " is diy font handle = " + font.f32756f.mDiyHandle);
                }
                font.f32757g = true;
                k kVar = (k) ((ConcurrentHashMap) objectRef.element).get(Integer.valueOf(font.f32751a));
                if (kVar != null && (str = kVar.f32755e) != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    kVar.f32756f.parseDIYJsonString(kVar.f32755e);
                }
            }
        } else {
            k kVar2 = new k(font.f32751a, font.f32752b);
            kVar2.f32753c = font.f32753c;
            kVar2.f32757g = true;
            kVar2.f32756f = new ETFont(font.f32751a, font.f32752b, 16.0f, font.f32753c, null);
            ((Map) objectRef.element).put(Integer.valueOf(font.f32751a), kVar2);
            this.mDIYConfigMap.put(uin, objectRef.element);
        }
        return true;
    }

    private final boolean s() {
        if (J) {
            return Intrinsics.areEqual(Looper.myLooper(), this.mFontHandler.getLooper());
        }
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
    public static final void x(final int i3, final FontInfoManager this$0, final int i16, final boolean z16, final String uin, final long j3, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if ((i3 == 3 || i3 == 4) && !m.c.e().f415884e.get()) {
            if (!m.c.e().f415882c.get()) {
                m.c.e().f415882c.set(true);
                this$0.mFontHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontInfoManager.y(FontInfoManager.this, i16, i3, z16, uin, j3, z17);
                    }
                });
                return;
            } else if (m.c.e().f415883d.get()) {
                if (J) {
                    m.c.e().d().f();
                } else {
                    m.c.e().d().e();
                }
                m.c.e().f415884e.set(true);
            } else {
                return;
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r46 = this$0.sFontInfoCache.get(String.valueOf(i16));
        objectRef.element = r46;
        if (r46 == 0) {
            this$0.n(i16, i3, z16, uin, j3, z17);
            return;
        }
        if (((k) r46).f32753c == 4) {
            long currentTimeMillis = System.currentTimeMillis();
            int h16 = m.c.e().h(i16, ((k) objectRef.element).f32752b);
            ((k) objectRef.element).f32758h = m.b.g(i16);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (h16 != 0) {
                n.a("action_load", i16, 4, 0, currentTimeMillis2 - currentTimeMillis);
            }
        }
        T t16 = objectRef.element;
        if (((k) t16).f32756f == null) {
            ((k) t16).f32756f = new ETFont(i16, ((k) t16).f32752b, 16.0f, ((k) t16).f32753c, ((k) t16).f32754d);
        }
        if (((k) objectRef.element).f32757g) {
            final ConcurrentHashMap<Integer, k> concurrentHashMap = this$0.mDIYConfigMap.get(uin);
            if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i16))) {
                this$0.mFontHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontInfoManager.z(uin, i16, j3, objectRef, concurrentHashMap);
                    }
                });
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(uin, Integer.valueOf(((k) objectRef.element).f32751a));
                new z03.b().e(hashMap, new g(objectRef, this$0, uin));
            }
        }
        this$0.E(i16, (k) objectRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(FontInfoManager this$0, int i3, int i16, boolean z16, String uin, long j3, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        h.INSTANCE.a().b(new e(i3, i16, z16, uin, j3, z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(String uin, int i3, long j3, Ref.ObjectRef fontInfo, ConcurrentHashMap concurrentHashMap) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(fontInfo, "$fontInfo");
        z03.b.INSTANCE.a().c(uin, i3, j3, new f(fontInfo, concurrentHashMap));
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentHashMap<Integer, k>> B() {
        return this.mDIYConfigMap;
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final HandlerThread getMHandlerThread() {
        return this.mHandlerThread;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return true;
    }

    public final void m(int fontId, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String valueOf = String.valueOf(fontId);
        synchronized (this.lock) {
            ArrayList<b> arrayList = this.loadListenerMap.get(valueOf);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.loadListenerMap.put(valueOf, arrayList);
            }
            arrayList.add(listener);
        }
    }

    public final void t() {
        this.loadListenerMap.clear();
    }

    public final int u(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = context.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        context.getResources().getDimensionPixelSize(R.dimen.f158274c0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return context.getResources().getDimensionPixelSize(R.dimen.f158274c0);
                }
                return context.getResources().getDimensionPixelSize(R.dimen.f158272bx);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.by);
        }
        return context.getResources().getDimensionPixelSize(R.dimen.f158273bz);
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final Handler getMFontHandler() {
        return this.mFontHandler;
    }

    @Nullable
    public k w(final int fontId, final int fontType, final boolean isTroop, @NotNull final String uin, final long diyTimestamp, final boolean isSend) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.font.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                FontInfoManager.x(fontType, this, fontId, isTroop, uin, diyTimestamp, isSend);
            }
        };
        if (J) {
            this.mFontHandler.post(runnable);
        } else {
            this.mainHandler.post(runnable);
        }
        return A(fontType, fontId);
    }
}
