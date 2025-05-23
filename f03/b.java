package f03;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bb\u0010cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010'\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b)\u0010\u001b\"\u0004\b<\u0010\u001dR\"\u0010@\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b0\u0010\u001b\"\u0004\b?\u0010\u001dR$\u0010F\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\b>\u0010D\"\u0004\b6\u0010ER$\u0010H\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010C\u001a\u0004\bB\u0010D\"\u0004\bG\u0010ER$\u0010J\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010C\u001a\u0004\b\n\u0010D\"\u0004\bI\u0010ER2\u0010M\u001a\u0012\u0012\u0004\u0012\u00020A0\u000ej\b\u0012\u0004\u0012\u00020A`\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\bL\u0010\u0016R2\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u00020Nj\b\u0012\u0004\u0012\u00020\u0002`O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010P\u001a\u0004\b\u0003\u0010Q\"\u0004\bR\u0010SRB\u0010[\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020V\u0018\u00010Uj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020V\u0018\u0001`W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010X\u001a\u0004\b\u0011\u0010Y\"\u0004\bK\u0010ZR$\u0010a\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010]\u001a\u0004\b5\u0010^\"\u0004\b_\u0010`\u00a8\u0006d"}, d2 = {"Lf03/b;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "id", "b", "getName", "v", "name", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "k", "()Ljava/util/ArrayList;", "B", "(Ljava/util/ArrayList;)V", "subBubbleArrayId", "d", "I", "getNextSubBubbleIndex", "()I", "w", "(I)V", "nextSubBubbleIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "fontColor", "f", "g", "u", "linkColor", "getStrokeColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "strokeColor", "", h.F, "Z", "getHasStroke", "()Z", "r", "(Z)V", "hasStroke", "i", "getAutoStroke", DomainData.DOMAIN_NAME, "autoStroke", "", "j", "D", "getThresholdFactor", "()D", BdhLogUtil.LogTag.Tag_Conn, "(D)V", "thresholdFactor", HippyTKDListViewAdapter.X, "ninePatchCenterX", "l", "y", "ninePatchCenterY", "Lf03/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lf03/a;", "()Lf03/a;", "(Lf03/a;)V", "voiceAnimation", "E", "voicePrintAnimation", "o", "bubbleFrameAnimation", "p", "t", "keywordAnimations", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setAnimZipNames", "(Ljava/util/HashSet;)V", "animZipNames", "Ljava/util/HashMap;", "Lg03/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "(Ljava/util/HashMap;)V", "diyBubbleConfigMap", "Lf03/d;", "Lf03/d;", "()Lf03/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lf03/d;)V", "shootAnimation", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<Integer> subBubbleArrayId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int nextSubBubbleIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int fontColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int linkColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int strokeColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasStroke;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean autoStroke;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private double thresholdFactor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a voiceAnimation;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a voicePrintAnimation;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a bubbleFrameAnimation;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, g03.a> diyBubbleConfigMap;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d shootAnimation;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String id = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int ninePatchCenterX = -1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int ninePatchCenterY = -1;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<a> keywordAnimations = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<String> animZipNames = new HashSet<>();

    public final void A(int i3) {
        this.strokeColor = i3;
    }

    public final void B(@Nullable ArrayList<Integer> arrayList) {
        this.subBubbleArrayId = arrayList;
    }

    public final void C(double d16) {
        this.thresholdFactor = d16;
    }

    public final void D(@Nullable a aVar) {
        this.voiceAnimation = aVar;
    }

    public final void E(@Nullable a aVar) {
        this.voicePrintAnimation = aVar;
    }

    @NotNull
    public final HashSet<String> a() {
        return this.animZipNames;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final a getBubbleFrameAnimation() {
        return this.bubbleFrameAnimation;
    }

    @Nullable
    public final HashMap<String, g03.a> c() {
        return this.diyBubbleConfigMap;
    }

    /* renamed from: d, reason: from getter */
    public final int getFontColor() {
        return this.fontColor;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ArrayList<a> f() {
        return this.keywordAnimations;
    }

    /* renamed from: g, reason: from getter */
    public final int getLinkColor() {
        return this.linkColor;
    }

    /* renamed from: h, reason: from getter */
    public final int getNinePatchCenterX() {
        return this.ninePatchCenterX;
    }

    /* renamed from: i, reason: from getter */
    public final int getNinePatchCenterY() {
        return this.ninePatchCenterY;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final d getShootAnimation() {
        return this.shootAnimation;
    }

    @Nullable
    public final ArrayList<Integer> k() {
        return this.subBubbleArrayId;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final a getVoiceAnimation() {
        return this.voiceAnimation;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final a getVoicePrintAnimation() {
        return this.voicePrintAnimation;
    }

    public final void n(boolean z16) {
        this.autoStroke = z16;
    }

    public final void o(@Nullable a aVar) {
        this.bubbleFrameAnimation = aVar;
    }

    public final void p(@Nullable HashMap<String, g03.a> hashMap) {
        this.diyBubbleConfigMap = hashMap;
    }

    public final void q(int i3) {
        this.fontColor = i3;
    }

    public final void r(boolean z16) {
        this.hasStroke = z16;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void t(@NotNull ArrayList<a> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.keywordAnimations = arrayList;
    }

    public final void u(int i3) {
        this.linkColor = i3;
    }

    public final void v(@Nullable String str) {
        this.name = str;
    }

    public final void w(int i3) {
        this.nextSubBubbleIndex = i3;
    }

    public final void x(int i3) {
        this.ninePatchCenterX = i3;
    }

    public final void y(int i3) {
        this.ninePatchCenterY = i3;
    }

    public final void z(@Nullable d dVar) {
        this.shootAnimation = dVar;
    }
}
