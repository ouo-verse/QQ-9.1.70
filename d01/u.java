package d01;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b]\u0010^R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010>\u001a\u0004\b/\u0010?\"\u0004\b@\u0010AR$\u0010I\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\b\u0003\u0010F\"\u0004\bG\u0010HR$\u0010O\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010K\u001a\u0004\bD\u0010L\"\u0004\bM\u0010NR$\u0010U\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010Q\u001a\u0004\b\u001a\u0010R\"\u0004\bS\u0010TR$\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006_"}, d2 = {"Ld01/u;", "", "Ld01/o;", "a", "Ld01/o;", "l", "()Ld01/o;", "y", "(Ld01/o;)V", "krUncaughtExceptionHandlerAdapter", "Ld01/f;", "b", "Ld01/f;", "c", "()Ld01/f;", "p", "(Ld01/f;)V", "krFontAdapter", "Ld01/h;", "Ld01/h;", "e", "()Ld01/h;", "r", "(Ld01/h;)V", "krImageAdapter", "Ld01/e;", "d", "Ld01/e;", "()Ld01/e;", "o", "(Ld01/e;)V", "krColorParseAdapter", "Ld01/i;", "Ld01/i;", "f", "()Ld01/i;", ReportConstant.COSTREPORT_PREFIX, "(Ld01/i;)V", "krLogAdapter", "Ld01/l;", "Ld01/l;", "i", "()Ld01/l;", "v", "(Ld01/l;)V", "krRouterAdapter", "Ld01/n;", "g", "Ld01/n;", "k", "()Ld01/n;", HippyTKDListViewAdapter.X, "(Ld01/n;)V", "krThreadAdapter", "Ld01/k;", tl.h.F, "Ld01/k;", "()Ld01/k;", "u", "(Ld01/k;)V", "krPagViewAdapter", "Ld01/j;", "Ld01/j;", "()Ld01/j;", "t", "(Ld01/j;)V", "krLottieViewAdapter", "Ld01/d;", "j", "Ld01/d;", "()Ld01/d;", DomainData.DOMAIN_NAME, "(Ld01/d;)V", "krAPNGViewAdapter", "Ld01/m;", "Ld01/m;", "()Ld01/m;", "w", "(Ld01/m;)V", "krTextPostProcessorAdapter", "Ld01/g;", "Ld01/g;", "()Ld01/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ld01/g;)V", "krGlobalSwitchAdapter", "Ld01/p;", "krVideoViewAdapter", "Ld01/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ld01/p;", "setKrVideoViewAdapter", "(Ld01/p;)V", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static o krUncaughtExceptionHandlerAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static f krFontAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static h krImageAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static e krColorParseAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static i krLogAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static l krRouterAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static n krThreadAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static k krPagViewAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static j krLottieViewAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d krAPNGViewAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static m krTextPostProcessorAdapter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static g krGlobalSwitchAdapter;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final u f392615m = new u();

    u() {
    }

    @Nullable
    public final d a() {
        return krAPNGViewAdapter;
    }

    @Nullable
    public final e b() {
        return krColorParseAdapter;
    }

    @Nullable
    public final f c() {
        return krFontAdapter;
    }

    @Nullable
    public final g d() {
        return krGlobalSwitchAdapter;
    }

    @Nullable
    public final h e() {
        return krImageAdapter;
    }

    @Nullable
    public final i f() {
        return krLogAdapter;
    }

    @Nullable
    public final j g() {
        return krLottieViewAdapter;
    }

    @Nullable
    public final k h() {
        return krPagViewAdapter;
    }

    @Nullable
    public final l i() {
        return krRouterAdapter;
    }

    @Nullable
    public final m j() {
        return krTextPostProcessorAdapter;
    }

    @Nullable
    public final n k() {
        return krThreadAdapter;
    }

    @Nullable
    public final o l() {
        return krUncaughtExceptionHandlerAdapter;
    }

    @Nullable
    public final p m() {
        return null;
    }

    public final void n(@Nullable d dVar) {
        krAPNGViewAdapter = dVar;
    }

    public final void o(@Nullable e eVar) {
        krColorParseAdapter = eVar;
    }

    public final void p(@Nullable f fVar) {
        krFontAdapter = fVar;
    }

    public final void q(@Nullable g gVar) {
        krGlobalSwitchAdapter = gVar;
    }

    public final void r(@Nullable h hVar) {
        krImageAdapter = hVar;
    }

    public final void s(@Nullable i iVar) {
        krLogAdapter = iVar;
    }

    public final void t(@Nullable j jVar) {
        krLottieViewAdapter = jVar;
    }

    public final void u(@Nullable k kVar) {
        krPagViewAdapter = kVar;
    }

    public final void v(@Nullable l lVar) {
        krRouterAdapter = lVar;
    }

    public final void w(@Nullable m mVar) {
        krTextPostProcessorAdapter = mVar;
    }

    public final void x(@Nullable n nVar) {
        krThreadAdapter = nVar;
    }

    public final void y(@Nullable o oVar) {
        krUncaughtExceptionHandlerAdapter = oVar;
    }
}
