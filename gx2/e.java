package gx2;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lgx2/e;", "", "", "a", "I", "w", "()I", "setEventKey", "(I)V", "eventKey", "", "b", "[Ljava/lang/Object;", HippyTKDListViewAdapter.X, "()[Ljava/lang/Object;", "setMParams", "([Ljava/lang/Object;)V", "mParams", "<init>", "(I[Ljava/lang/Object;)V", "y", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int eventKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object[] mParams;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static int f403714c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static int f403715d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static int f403716e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static int f403717f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static int f403718g = 5;

    /* renamed from: h, reason: collision with root package name */
    private static int f403719h = 6;

    /* renamed from: i, reason: collision with root package name */
    private static int f403720i = 7;

    /* renamed from: j, reason: collision with root package name */
    private static int f403721j = 8;

    /* renamed from: k, reason: collision with root package name */
    private static int f403722k = 9;

    /* renamed from: l, reason: collision with root package name */
    private static int f403723l = 10;

    /* renamed from: m, reason: collision with root package name */
    private static int f403724m = 11;

    /* renamed from: n, reason: collision with root package name */
    private static int f403725n = 12;

    /* renamed from: o, reason: collision with root package name */
    private static int f403726o = 13;

    /* renamed from: p, reason: collision with root package name */
    private static int f403727p = 14;

    /* renamed from: q, reason: collision with root package name */
    private static int f403728q = 15;

    /* renamed from: r, reason: collision with root package name */
    private static int f403729r = 16;

    /* renamed from: s, reason: collision with root package name */
    private static int f403730s = 17;

    /* renamed from: t, reason: collision with root package name */
    private static int f403731t = 18;

    /* renamed from: u, reason: collision with root package name */
    private static int f403732u = 19;

    /* renamed from: v, reason: collision with root package name */
    private static int f403733v = 20;

    /* renamed from: w, reason: collision with root package name */
    private static int f403734w = 21;

    /* renamed from: x, reason: collision with root package name */
    private static int f403735x = 22;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\bH\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\b\u00a8\u0006J"}, d2 = {"Lgx2/e$a;", "", "", "START_AD", "I", "v", "()I", "setSTART_AD", "(I)V", "AD_SHOW_SUCC", "o", "setAD_SHOW_SUCC", "AD_SHOW_FAIL", DomainData.DOMAIN_NAME, "setAD_SHOW_FAIL", "AD_CLICK", "b", "setAD_CLICK", "AD_CLOSE", "c", "setAD_CLOSE", "AD_CLOSE_CLICK", "d", "setAD_CLOSE_CLICK", "AD_CLOSE_DIALOG_CLICK", "e", "setAD_CLOSE_DIALOG_CLICK", "AD_CLOSE_DIALOG_SHOW", "f", "setAD_CLOSE_DIALOG_SHOW", "AD_PLAY_START", "l", "setAD_PLAY_START", "AD_PLAY_PAUSE", "j", "setAD_PLAY_PAUSE", "AD_PLAY_RESUME", "k", "setAD_PLAY_RESUME", "AD_PLAY_COMPLETE", "i", "setAD_PLAY_COMPLETE", "AD_TICK", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setAD_TICK", "AD_USER_SET_MUTE", ReportConstant.COSTREPORT_PREFIX, "setAD_USER_SET_MUTE", "BACK_PRESSED", "t", "setBACK_PRESSED", "AD_USER_EARNED_REWARD", "r", "setAD_USER_EARNED_REWARD", "ACTIVITY_DESTROY", "a", "setACTIVITY_DESTROY", "ORIGINAL_EXPOSURE", "u", "setORIGINAL_EXPOSURE", "AD_SWITCH_AD", "p", "setAD_SWITCH_AD", "AD_REFRESH_AD", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setAD_REFRESH_AD", "AD_MODULE_EVENT", h.F, "setAD_MODULE_EVENT", "AD_CLOSE_PAGE_MANUAL", "g", "setAD_CLOSE_PAGE_MANUAL", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: gx2.e$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return e.f403730s;
        }

        public final int b() {
            return e.f403717f;
        }

        public final int c() {
            return e.f403718g;
        }

        public final int d() {
            return e.f403719h;
        }

        public final int e() {
            return e.f403720i;
        }

        public final int f() {
            return e.f403721j;
        }

        public final int g() {
            return e.f403735x;
        }

        public final int h() {
            return e.f403734w;
        }

        public final int i() {
            return e.f403725n;
        }

        public final int j() {
            return e.f403723l;
        }

        public final int k() {
            return e.f403724m;
        }

        public final int l() {
            return e.f403722k;
        }

        public final int m() {
            return e.f403733v;
        }

        public final int n() {
            return e.f403716e;
        }

        public final int o() {
            return e.f403715d;
        }

        public final int p() {
            return e.f403732u;
        }

        public final int q() {
            return e.f403726o;
        }

        public final int r() {
            return e.f403729r;
        }

        public final int s() {
            return e.f403727p;
        }

        public final int t() {
            return e.f403728q;
        }

        public final int u() {
            return e.f403731t;
        }

        public final int v() {
            return e.f403714c;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(int i3, @NotNull Object... mParams) {
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        this.eventKey = i3;
        this.mParams = mParams;
    }

    /* renamed from: w, reason: from getter */
    public final int getEventKey() {
        return this.eventKey;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final Object[] getMParams() {
        return this.mParams;
    }
}
