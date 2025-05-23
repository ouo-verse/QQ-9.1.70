package f03;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u0000 %2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\bP\u0010QR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u000e\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010 \u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u0013\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R2\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00020,j\b\u0012\u0004\u0012\u00020\u0002`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b\u001a\u00100\"\u0004\b1\u00102R$\u00105\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b\n\u0010$\"\u0004\b4\u0010&R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b6\u0010\bR\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b9\u0010=R\"\u0010A\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R\"\u0010C\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\bB\u0010\u0018R\"\u0010E\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b(\u0010\u0016\"\u0004\bD\u0010\u0018R\"\u0010G\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b.\u0010\u0016\"\u0004\bF\u0010\u0018R\"\u0010I\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\bH\u0010\u0018R\"\u0010L\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010:\u001a\u0004\bJ\u0010<\"\u0004\bK\u0010=R\"\u0010O\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010:\u001a\u0004\bM\u0010<\"\u0004\bN\u0010=\u00a8\u0006R"}, d2 = {"Lf03/a;", "", "", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "zipName", "b", "getAnimKeyName", "o", "animKeyName", "c", "getLinkZip", "v", "linkZip", "", "d", "I", "getAnimConditionType", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "animConditionType", "e", "r", "cycleCount", "f", "getCount", "p", "count", "", "g", "[I", "()[I", "t", "([I)V", "gifRect", h.F, "getTime", "B", "time", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "u", "(Ljava/util/ArrayList;)V", "keywords", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "cutPoints", "k", "align", "", "l", "Z", "getAlpha", "()Z", "(Z)V", com.tencent.luggage.wxa.c8.c.f123400v, "getAnimContentType", DomainData.DOMAIN_NAME, "animContentType", "y", NodeProps.PADDING_LEFT, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.PADDING_RIGHT, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.PADDING_TOP, HippyTKDListViewAdapter.X, NodeProps.PADDING_BOTTOM, "getDisappear", ReportConstant.COSTREPORT_PREFIX, "disappear", "getMirror", "w", "mirror", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int animConditionType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int cycleCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int count;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] gifRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int time;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] cutPoints;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String align;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean alpha;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int paddingLeft;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int paddingRight;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int paddingTop;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int paddingBottom;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String zipName = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String animKeyName = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String linkZip = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> keywords = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int animContentType = -1;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean disappear = true;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean mirror = true;

    public final void A(int i3) {
        this.paddingTop = i3;
    }

    public final void B(int i3) {
        this.time = i3;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zipName = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final int[] getCutPoints() {
        return this.cutPoints;
    }

    /* renamed from: c, reason: from getter */
    public final int getCycleCount() {
        return this.cycleCount;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final int[] getGifRect() {
        return this.gifRect;
    }

    @NotNull
    public final ArrayList<String> e() {
        return this.keywords;
    }

    /* renamed from: f, reason: from getter */
    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    /* renamed from: g, reason: from getter */
    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    /* renamed from: h, reason: from getter */
    public final int getPaddingRight() {
        return this.paddingRight;
    }

    /* renamed from: i, reason: from getter */
    public final int getPaddingTop() {
        return this.paddingTop;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getZipName() {
        return this.zipName;
    }

    public final void k(@Nullable String str) {
        this.align = str;
    }

    public final void l(boolean z16) {
        this.alpha = z16;
    }

    public final void m(int i3) {
        this.animConditionType = i3;
    }

    public final void n(int i3) {
        this.animContentType = i3;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.animKeyName = str;
    }

    public final void p(int i3) {
        this.count = i3;
    }

    public final void q(@Nullable int[] iArr) {
        this.cutPoints = iArr;
    }

    public final void r(int i3) {
        this.cycleCount = i3;
    }

    public final void s(boolean z16) {
        this.disappear = z16;
    }

    public final void t(@Nullable int[] iArr) {
        this.gifRect = iArr;
    }

    public final void u(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.keywords = arrayList;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.linkZip = str;
    }

    public final void w(boolean z16) {
        this.mirror = z16;
    }

    public final void x(int i3) {
        this.paddingBottom = i3;
    }

    public final void y(int i3) {
        this.paddingLeft = i3;
    }

    public final void z(int i3) {
        this.paddingRight = i3;
    }
}
