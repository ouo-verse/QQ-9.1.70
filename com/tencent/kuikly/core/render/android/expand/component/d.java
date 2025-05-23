package com.tencent.kuikly.core.render.android.expand.component;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 G2\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010r\u001a\u0004\u0018\u00010p\u00a2\u0006\u0004\bs\u0010tJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0019\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\"\u0010<\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010-\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b,\u0010\u001b\"\u0004\b=\u0010\u001dR\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b@\u0010\u000fR\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\bB\u0010\u001dR\"\u0010F\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010-\u001a\u0004\b6\u0010/\"\u0004\bE\u00101R\"\u0010H\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\bG\u0010\u000fR\"\u0010K\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010-\u001a\u0004\b \u0010/\"\u0004\bJ\u00101R\"\u0010M\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010-\u001a\u0004\b?\u0010/\"\u0004\bL\u00101R\"\u0010O\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bN\u0010\u000fR\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0019\u001a\u0004\b\n\u0010\u001b\"\u0004\bP\u0010\u001dR$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0019\u001a\u0004\bS\u0010\u001b\"\u0004\bZ\u0010\u001dR\"\u0010_\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0012\u001a\u0004\b]\u0010\u0014\"\u0004\b^\u0010\u0016R\"\u0010c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u0012\u001a\u0004\ba\u0010\u0014\"\u0004\bb\u0010\u0016R$\u0010h\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010d\u001a\u0004\b\\\u0010e\"\u0004\bf\u0010gR$\u0010m\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010i\u001a\u0004\b`\u0010j\"\u0004\bk\u0010lR\"\u0010o\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010\u0012\u001a\u0004\bD\u0010\u0014\"\u0004\bn\u0010\u0016R\u0016\u0010r\u001a\u0004\u0018\u00010p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010q\u00a8\u0006u"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/d;", "", "", "propKey", "propValue", "", "D", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "a", "I", DomainData.DOMAIN_NAME, "()I", "setNumberOfLines", "(I)V", NodeProps.NUMBER_OF_LINES, "b", "Z", "g", "()Z", "setIncludePadding", "(Z)V", "includePadding", "c", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "setLineBreakMode", "(Ljava/lang/String;)V", "lineBreakMode", "Lorg/json/JSONArray;", "d", "Lorg/json/JSONArray;", HippyTKDListViewAdapter.X, "()Lorg/json/JSONArray;", "setValues", "(Lorg/json/JSONArray;)V", "values", "e", "p", IECSearchBar.METHOD_SET_TEXT, "text", "", "f", UserInfo.SEX_FEMALE, "l", "()F", "setLineSpacing", "(F)V", "lineSpacing", "r", "setTextDecoration", TtmlNode.ATTR_TTS_TEXT_DECORATION, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, CanvasView.ACTION_SET_TEXTALIGN, "textAlign", "i", "setLineBreakMargin", "lineBreakMargin", CanvasView.ACTION_SET_FONT_WEIGHT, "fontWeight", "k", CanvasView.ACTION_SET_FONT_STYLE, "fontStyle", CanvasView.ACTION_SET_FONT_FAMILY, "fontFamily", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setLetterSpacing", NodeProps.LETTER_SPACING, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "color", "o", CanvasView.ACTION_SET_FONT_SIZE, "fontSize", "setLineHeight", NodeProps.LINE_HEIGHT, "setRichTextHeadIndent", "richTextHeadIndent", "setBackgroundImage", "backgroundImage", "Lcom/tencent/kuikly/core/render/android/css/decoration/a;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/render/android/css/decoration/a;", "t", "()Lcom/tencent/kuikly/core/render/android/css/decoration/a;", "setTextShadow", "(Lcom/tencent/kuikly/core/render/android/css/decoration/a;)V", "textShadow", "setTextPostProcessor", "textPostProcessor", "u", "w", "setUseDpFontSizeDim", "useDpFontSizeDim", "v", "y", "B", "isLineBreakMargin", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setTextStrokeColor", "(Ljava/lang/Integer;)V", "textStrokeColor", "Ljava/lang/Float;", "()Ljava/lang/Float;", "setTextStrokeWidth", "(Ljava/lang/Float;)V", "textStrokeWidth", BdhLogUtil.LogTag.Tag_Conn, "needTextStrokeDraw", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "<init>", "(Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class d {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int numberOfLines;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean includePadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONArray values;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lineSpacing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float lineBreakMargin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int fontStyle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float letterSpacing;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int richTextHeadIndent;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.css.decoration.a textShadow;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean useDpFontSizeDim;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isLineBreakMargin;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer textStrokeColor;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float textStrokeWidth;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean needTextStrokeDraw;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lineBreakMode = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textDecoration = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textAlign = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fontWeight = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fontFamily = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int color = -16777216;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float fontSize = 16.0f;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float lineHeight = -1.0f;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundImage = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textPostProcessor = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0014\u0010\u0019\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u0014\u0010\u001b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u0014\u0010\u001d\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0007R\u0014\u0010\u001f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0007R\u0014\u0010!\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0007R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0004\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/d$a;", "", "", "DEFAULT_FONT_SIZE", UserInfo.SEX_FEMALE, "", "FONT_STYLE_ITALIC", "Ljava/lang/String;", "PROP_KEY_BACKGROUND_IMAGE", "PROP_KEY_COLOR", "PROP_KEY_FONT_FAMILY", "PROP_KEY_FONT_SIZE", "PROP_KEY_FONT_STYLE", "PROP_KEY_FONT_VARIANT", "PROP_KEY_FONT_WEIGHT", "PROP_KEY_HEAD_INDENT", "PROP_KEY_INCLUDE_PADDING", "PROP_KEY_LETTER_SPACING", "PROP_KEY_LINE_BREAK_MARGIN", "PROP_KEY_LINE_BREAK_MODE", "PROP_KEY_LINE_HEIGHT", "PROP_KEY_LINE_SPACING", "PROP_KEY_NUMBER_OF_LINES", "PROP_KEY_STROKE_COLOR", "PROP_KEY_STROKE_WIDTH", "PROP_KEY_TEXT", "PROP_KEY_TEXT_ALIGN", "PROP_KEY_TEXT_DECORATION", "PROP_KEY_TEXT_POST_PROCESSOR", "PROP_KEY_TEXT_SHADOW", "PROP_KEY_TEXT_USE_DP_FONT_SIZE_DIM", "PROP_KEY_VALUE", "PROP_KEY_VALUES", "TEXT_ALIGN_CENTER", "TEXT_ALIGN_RIGHT", "TEXT_DECORATION_LINE_THROUGH", "TEXT_DECORATION_UNDERLINE", "UNSET_LINE_HEIGHT", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.d$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        this.kuiklyContext = aVar;
    }

    public final void A(int i3) {
        this.color = i3;
    }

    public final void B(boolean z16) {
        this.isLineBreakMargin = z16;
    }

    public final void C(boolean z16) {
        this.needTextStrokeDraw = z16;
    }

    public final void D(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean z16 = false;
        boolean z17 = false;
        int i3 = 0;
        switch (propKey.hashCode()) {
            case -1798639867:
                if (propKey.equals("useDpFontSizeDim")) {
                    if (((Integer) propValue).intValue() == 1) {
                        z16 = true;
                    }
                    this.useDpFontSizeDim = z16;
                    return;
                }
                return;
            case -1625116241:
                if (propKey.equals("lineSpacing")) {
                    this.lineSpacing = com.tencent.kuikly.core.render.android.css.ktx.b.K(this.kuiklyContext, com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return;
                }
                return;
            case -1550943582:
                if (propKey.equals("fontStyle")) {
                    if (Intrinsics.areEqual((String) propValue, "italic")) {
                        i3 = 2;
                    }
                    this.fontStyle = i3;
                    return;
                }
                return;
            case -1447136695:
                if (propKey.equals("includePadding")) {
                    if (((Integer) propValue).intValue() == 1) {
                        z17 = true;
                    }
                    this.includePadding = z17;
                    return;
                }
                return;
            case -1408498779:
                if (propKey.equals("textPostProcessor")) {
                    this.textPostProcessor = (String) propValue;
                    return;
                }
                return;
            case -1329887265:
                if (propKey.equals(NodeProps.NUMBER_OF_LINES)) {
                    this.numberOfLines = ((Integer) propValue).intValue();
                    return;
                }
                return;
            case -1224696685:
                if (propKey.equals("fontFamily")) {
                    this.fontFamily = (String) propValue;
                    return;
                }
                return;
            case -1105983751:
                if (propKey.equals("lineBreakMargin")) {
                    this.lineBreakMargin = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return;
                }
                return;
            case -1065511464:
                if (propKey.equals("textAlign")) {
                    this.textAlign = (String) propValue;
                    return;
                }
                return;
            case -879295043:
                if (propKey.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                    this.textDecoration = (String) propValue;
                    return;
                }
                return;
            case -823812830:
                if (propKey.equals("values")) {
                    this.values = new JSONArray((String) propValue);
                    return;
                }
                return;
            case -734428249:
                if (propKey.equals("fontWeight")) {
                    this.fontWeight = (String) propValue;
                    return;
                }
                return;
            case -515807685:
                if (propKey.equals(NodeProps.LINE_HEIGHT)) {
                    this.lineHeight = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return;
                }
                return;
            case 3556653:
                if (propKey.equals("text")) {
                    this.text = (String) propValue;
                    return;
                }
                return;
            case 94842723:
                if (propKey.equals("color")) {
                    this.color = com.tencent.kuikly.core.render.android.css.ktx.b.w((String) propValue);
                    return;
                }
                return;
            case 365601008:
                if (propKey.equals("fontSize")) {
                    this.fontSize = com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue);
                    return;
                }
                return;
            case 682660270:
                if (propKey.equals("lineBreakMode")) {
                    this.lineBreakMode = (String) propValue;
                    return;
                }
                return;
            case 1172685484:
                if (propKey.equals("headIndent")) {
                    this.richTextHeadIndent = com.tencent.kuikly.core.render.android.css.ktx.b.K(this.kuiklyContext, com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return;
                }
                return;
            case 1292595405:
                if (propKey.equals("backgroundImage")) {
                    this.backgroundImage = (String) propValue;
                    return;
                }
                return;
            case 1840272557:
                if (propKey.equals("textShadow") && (propValue instanceof String)) {
                    this.textShadow = new com.tencent.kuikly.core.render.android.css.decoration.a((String) propValue, this.kuiklyContext);
                    return;
                }
                return;
            case 1905781771:
                if (propKey.equals("strokeColor")) {
                    this.textStrokeColor = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w((String) propValue));
                    this.needTextStrokeDraw = true;
                    return;
                }
                return;
            case 1924065902:
                if (propKey.equals("strokeWidth")) {
                    this.textStrokeWidth = Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    this.needTextStrokeDraw = true;
                    return;
                }
                return;
            case 2111078717:
                if (propKey.equals(NodeProps.LETTER_SPACING)) {
                    this.letterSpacing = com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    /* renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: d, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: e, reason: from getter */
    public final int getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    /* renamed from: h, reason: from getter */
    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    /* renamed from: i, reason: from getter */
    public final float getLineBreakMargin() {
        return this.lineBreakMargin;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getLineBreakMode() {
        return this.lineBreakMode;
    }

    /* renamed from: k, reason: from getter */
    public final float getLineHeight() {
        return this.lineHeight;
    }

    /* renamed from: l, reason: from getter */
    public final float getLineSpacing() {
        return this.lineSpacing;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getNeedTextStrokeDraw() {
        return this.needTextStrokeDraw;
    }

    /* renamed from: n, reason: from getter */
    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    /* renamed from: o, reason: from getter */
    public final int getRichTextHeadIndent() {
        return this.richTextHeadIndent;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getTextAlign() {
        return this.textAlign;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getTextDecoration() {
        return this.textDecoration;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getTextPostProcessor() {
        return this.textPostProcessor;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final com.tencent.kuikly.core.render.android.css.decoration.a getTextShadow() {
        return this.textShadow;
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final Integer getTextStrokeColor() {
        return this.textStrokeColor;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final Float getTextStrokeWidth() {
        return this.textStrokeWidth;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getUseDpFontSizeDim() {
        return this.useDpFontSizeDim;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final JSONArray getValues() {
        return this.values;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsLineBreakMargin() {
        return this.isLineBreakMargin;
    }

    public final boolean z() {
        int i3;
        JSONArray jSONArray = this.values;
        if (jSONArray != null) {
            i3 = jSONArray.length();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }
}
