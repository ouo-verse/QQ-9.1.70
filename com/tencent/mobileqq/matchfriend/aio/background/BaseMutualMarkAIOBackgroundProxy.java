package com.tencent.mobileqq.matchfriend.aio.background;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 \u00102\u00020\u0001:\u0006\u001f$'+.\u000eB\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0016\u0010\u001d\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH$R\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00102\u001a\u00020\u000b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "immediate", "", "p", "", "errMsg", DomainData.DOMAIN_NAME, "Landroid/view/View;", "k", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$e;", "f", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$b;", "g", "j", ReportConstant.COSTREPORT_PREFIX, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "left", "top", "right", "bottom", "t", "Lkotlin/Function0;", "block", "r", "Landroid/content/Context;", "a", "Landroid/content/Context;", "i", "()Landroid/content/Context;", "context", "b", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$e;", "resourceLoader", "c", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$b;", "viewUpdater", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "e", "Landroid/view/View;", h.F, "()Landroid/view/View;", "containView", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "currentState", "<init>", "(Landroid/content/Context;)V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class BaseMutualMarkAIOBackgroundProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final f f243791h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e resourceLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b viewUpdater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isLoading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View containView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile f currentState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$a;", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "INIT_STATE", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$b;", "", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "immediate", "", Constants.PAG_FILE_PATH, "b", "errMsg", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a(@NotNull View view);

        void b(@NotNull f state, boolean immediate, @NotNull String pagFilePath);

        void c(@NotNull f state, boolean immediate, @NotNull String errMsg);

        void onDestroy();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$c;", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "filePath", "", "b", "errMsg", "a", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface c {
        void a(@NotNull f state, @NotNull String errMsg);

        void b(@NotNull f state, @NotNull String filePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$d;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$c;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "filePath", "", "b", "errMsg", "a", "", "Z", "immediate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "getProxyRef", "()Ljava/lang/ref/WeakReference;", "proxyRef", "proxy", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;Z)V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean immediate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<BaseMutualMarkAIOBackgroundProxy> proxyRef;

        public d(@NotNull BaseMutualMarkAIOBackgroundProxy proxy, boolean z16) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, proxy, Boolean.valueOf(z16));
            } else {
                this.immediate = z16;
                this.proxyRef = new WeakReference<>(proxy);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.c
        public void a(@NotNull f state, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) state, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.proxyRef.get();
            if (baseMutualMarkAIOBackgroundProxy != null) {
                baseMutualMarkAIOBackgroundProxy.n(state, this.immediate, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.c
        public void b(@NotNull f state, @NotNull String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) state, (Object) filePath);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.proxyRef.get();
            if (baseMutualMarkAIOBackgroundProxy != null) {
                baseMutualMarkAIOBackgroundProxy.p(state, this.immediate);
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$e;", "", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "a", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$c;", "callback", "", "b", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface e {
        boolean a(@NotNull f state);

        void b(@NotNull f state, @NotNull c callback);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "I", "()I", "id", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "source", "e", "(Ljava/lang/String;)V", Constants.PAG_FILE_PATH, "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Object source;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String pagFilePath;

        public f(int i3, @NotNull String url, @Nullable Object obj, @NotNull String pagFilePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(pagFilePath, "pagFilePath");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), url, obj, pagFilePath);
                return;
            }
            this.id = i3;
            this.url = url;
            this.source = obj;
            this.pagFilePath = pagFilePath;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.id;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.pagFilePath;
        }

        @Nullable
        public final Object c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.source;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.url;
        }

        public final void e(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.pagFilePath = str;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
            }
            if (other == null || !(other instanceof f)) {
                return false;
            }
            f fVar = (f) other;
            if (this.id != fVar.id || !Intrinsics.areEqual(this.url, fVar.url)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode2 = ((this.id * 31) + this.url.hashCode()) * 31;
            Object obj = this.source;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.pagFilePath.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return super.toString() + "{id: " + this.id + ", url: " + this.url + ", pagFilePath: " + this.pagFilePath + "}";
        }

        public /* synthetic */ f(int i3, String str, Object obj, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, (i16 & 4) != 0 ? null : obj, (i16 & 8) != 0 ? "" : str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, obj, str2, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            f243791h = new f(-1, "", null, null, 12, null);
        }
    }

    public BaseMutualMarkAIOBackgroundProxy(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.resourceLoader = f();
        this.viewUpdater = g();
        this.isLoading = new AtomicBoolean(false);
        View k3 = k();
        this.containView = k3;
        this.currentState = f243791h;
        this.viewUpdater.a(k3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final f state, final boolean immediate, final String errMsg) {
        if (QLog.isColorLevel()) {
            QLog.i("BaseMutualMarkAIOBackgroundProxy", 2, "onLoadFailed " + state + ", immediate: " + immediate + ", errMsg: " + errMsg);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseMutualMarkAIOBackgroundProxy.o(BaseMutualMarkAIOBackgroundProxy.this, state, immediate, errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(BaseMutualMarkAIOBackgroundProxy this$0, f state, boolean z16, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        this$0.viewUpdater.c(state, z16, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final f state, final boolean immediate) {
        if (QLog.isColorLevel()) {
            QLog.i("BaseMutualMarkAIOBackgroundProxy", 2, "onLoadSucceed state: " + state + ", immediate: " + immediate);
        }
        this.currentState = state;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseMutualMarkAIOBackgroundProxy.q(BaseMutualMarkAIOBackgroundProxy.this, state, immediate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(BaseMutualMarkAIOBackgroundProxy this$0, f state, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.viewUpdater.b(state, z16, state.b());
    }

    @NotNull
    public abstract e f();

    @NotNull
    public abstract b g();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.containView;
    }

    @Nullable
    public final Context i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.containView;
    }

    @NotNull
    public abstract View k();

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.i("BaseMutualMarkAIOBackgroundProxy", 4, "onCreate");
            this.currentState = f243791h;
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("BaseMutualMarkAIOBackgroundProxy", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b bVar = this.viewUpdater;
        if (bVar != null) {
            bVar.onDestroy();
        }
    }

    protected abstract void r(@NotNull Function0<Unit> block);

    public final void s(@NotNull final f state, final boolean immediate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, state, Boolean.valueOf(immediate));
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.i("BaseMutualMarkAIOBackgroundProxy", 1, "setState state: " + state + ", immediate: " + immediate);
        if (state.a() >= 0 && !Intrinsics.areEqual(this.currentState, state) && this.currentState.a() < state.a()) {
            r(new Function0<Unit>(state, immediate) { // from class: com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy$setState$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $immediate;
                final /* synthetic */ BaseMutualMarkAIOBackgroundProxy.f $state;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$state = state;
                    this.$immediate = immediate;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseMutualMarkAIOBackgroundProxy.this, state, Boolean.valueOf(immediate));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BaseMutualMarkAIOBackgroundProxy.e eVar;
                    BaseMutualMarkAIOBackgroundProxy.e eVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    eVar = BaseMutualMarkAIOBackgroundProxy.this.resourceLoader;
                    if (eVar.a(this.$state)) {
                        BaseMutualMarkAIOBackgroundProxy.this.p(this.$state, this.$immediate);
                    } else {
                        eVar2 = BaseMutualMarkAIOBackgroundProxy.this.resourceLoader;
                        eVar2.b(this.$state, new BaseMutualMarkAIOBackgroundProxy.d(BaseMutualMarkAIOBackgroundProxy.this, this.$immediate));
                    }
                }
            });
        } else if (QLog.isColorLevel()) {
            QLog.i("BaseMutualMarkAIOBackgroundProxy", 2, "setState return");
        }
    }

    public void t(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        }
    }
}
