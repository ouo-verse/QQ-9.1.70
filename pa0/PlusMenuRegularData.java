package pa0;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b?\b\u0086\b\u0018\u0000 82\u00020\u0001:\u0001\tB\u009d\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u00a2\u0006\u0004\bD\u0010EJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b+\u0010\u000eR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b-\u0010\u000eR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b/\u0010\u000eR\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00101\u001a\u0004\b$\u00102\"\u0004\b3\u00104R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b6\u0010\u000eR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b8\u0010\u000eR\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b:\u0010\u000eR\u0017\u0010=\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b<\u0010\fR\u0017\u0010?\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b>\u0010\fR\u0017\u0010A\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b@\u0010\fR\u0017\u0010C\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\bB\u0010\f\u00a8\u0006F"}, d2 = {"Lpa0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;)V", "mainText", "b", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mainTextNew", "c", h.F, "w", "cameraMainText", "d", "i", HippyTKDListViewAdapter.X, "cameraSecondText", "e", "j", "y", "cameraSecondTextNew", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "templateMainText", "g", DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, "templateSecondText", "o", "D", "templateSecondTextNew", "p", "albumMainText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "albumSecondText", "r", "albumSecondTextNew", "I", "()I", "v", "(I)V", "bannerScrollInterval", "u", "bannerPlaceHolderLoadingHint", "t", "bannerPlaceHolderFailHint", ReportConstant.COSTREPORT_PREFIX, "bannerPlaceHolderEmptyHint", "getShowMainText", "showMainText", "getShowCameraSecondText", "showCameraSecondText", "getShowTemplateSecondText", "showTemplateSecondText", "getShowAlbumSecondText", "showAlbumSecondText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pa0.c, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PlusMenuRegularData {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mainText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mainTextNew;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String cameraMainText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String cameraSecondText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String cameraSecondTextNew;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String templateMainText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String templateSecondText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String templateSecondTextNew;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String albumMainText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String albumSecondText;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String albumSecondTextNew;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int bannerScrollInterval;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bannerPlaceHolderLoadingHint;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bannerPlaceHolderFailHint;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bannerPlaceHolderEmptyHint;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showMainText;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showCameraSecondText;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showTemplateSecondText;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showAlbumSecondText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lpa0/c$a;", "", "", "jsonStr", "Lpa0/c;", "a", "ALBUM_MAIN_TEXT", "Ljava/lang/String;", "ALBUM_SECOND_TEXT", "ALBUM_SECOND_TEXT_NEW", "BANNER_PLACEHOLDER_EMPTY_HINT", "BANNER_PLACEHOLDER_FAIL_HINT", "BANNER_PLACEHOLDER_LOADING_HINT", "BANNER_SCROLL_INTERVAL", "CAMERA_MAIN_TEXT", "CAMERA_SECOND_TEXT", "CAMERA_SECOND_TEXT_NEW", "MAIN_TEXT", "MAIN_TEXT_NEW", "TAG", "TEMPLATE_MAIN_TEXT", "TEMPLATE_SECOND_TEXT", "TEMPLATE_SECOND_TEXT_NEW", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pa0.c$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlusMenuRegularData a(@Nullable String jsonStr) {
            boolean z16;
            QLog.d("PlusMenuRegularData", 1, "fromJson, jsonStr:" + jsonStr);
            PlusMenuRegularData plusMenuRegularData = new PlusMenuRegularData(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 32767, null);
            if (jsonStr != null && jsonStr.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonStr);
                    String optString = jSONObject.optString("main_text", plusMenuRegularData.getMainText());
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(MAIN_TEXT, mainText)");
                    plusMenuRegularData.z(optString);
                    String optString2 = jSONObject.optString("main_text_new", plusMenuRegularData.getMainTextNew());
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(MAIN_TEXT_NEW, mainTextNew)");
                    plusMenuRegularData.A(optString2);
                    String optString3 = jSONObject.optString("camera_main_text", plusMenuRegularData.getCameraMainText());
                    Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(CAMERA_MAIN_TEXT, cameraMainText)");
                    plusMenuRegularData.w(optString3);
                    String optString4 = jSONObject.optString("camera_second_text", plusMenuRegularData.getCameraSecondText());
                    Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(CAMERA_SE\u2026D_TEXT, cameraSecondText)");
                    plusMenuRegularData.x(optString4);
                    String optString5 = jSONObject.optString("camera_second_text_new", plusMenuRegularData.getCameraSecondTextNew());
                    Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(CAMERA_SE\u2026NEW, cameraSecondTextNew)");
                    plusMenuRegularData.y(optString5);
                    String optString6 = jSONObject.optString("template_main_text", plusMenuRegularData.getTemplateMainText());
                    Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(TEMPLATE_\u2026N_TEXT, templateMainText)");
                    plusMenuRegularData.B(optString6);
                    String optString7 = jSONObject.optString("template_second_text", plusMenuRegularData.getTemplateSecondText());
                    Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(TEMPLATE_\u2026TEXT, templateSecondText)");
                    plusMenuRegularData.C(optString7);
                    String optString8 = jSONObject.optString("template_second_text_new", plusMenuRegularData.getTemplateSecondTextNew());
                    Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(TEMPLATE_\u2026W, templateSecondTextNew)");
                    plusMenuRegularData.D(optString8);
                    String optString9 = jSONObject.optString("album_main_text", plusMenuRegularData.getAlbumMainText());
                    Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(ALBUM_MAIN_TEXT, albumMainText)");
                    plusMenuRegularData.p(optString9);
                    String optString10 = jSONObject.optString("album_second_text", plusMenuRegularData.getAlbumSecondText());
                    Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(ALBUM_SECOND_TEXT, albumSecondText)");
                    plusMenuRegularData.q(optString10);
                    String optString11 = jSONObject.optString("album_second_text_new", plusMenuRegularData.getAlbumSecondTextNew());
                    Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(ALBUM_SEC\u2026_NEW, albumSecondTextNew)");
                    plusMenuRegularData.r(optString11);
                    plusMenuRegularData.v(jSONObject.optInt("banner_scroll_interval", plusMenuRegularData.getBannerScrollInterval()));
                    String optString12 = jSONObject.optString("banner_placeHolder_loading_hint", plusMenuRegularData.getBannerPlaceHolderLoadingHint());
                    Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(BANNER_PL\u2026erPlaceHolderLoadingHint)");
                    plusMenuRegularData.u(optString12);
                    String optString13 = jSONObject.optString("banner_placeHolder_fail_hint", plusMenuRegularData.getBannerPlaceHolderFailHint());
                    Intrinsics.checkNotNullExpressionValue(optString13, "json.optString(BANNER_PL\u2026annerPlaceHolderFailHint)");
                    plusMenuRegularData.t(optString13);
                    String optString14 = jSONObject.optString("banner_placeHolder_empty_hint", plusMenuRegularData.getBannerPlaceHolderEmptyHint());
                    Intrinsics.checkNotNullExpressionValue(optString14, "json.optString(BANNER_PL\u2026nnerPlaceHolderEmptyHint)");
                    plusMenuRegularData.s(optString14);
                } catch (Exception e16) {
                    QLog.e("PlusMenuRegularData", 1, "fromJson, error ", e16);
                }
            }
            return plusMenuRegularData;
        }

        Companion() {
        }
    }

    public PlusMenuRegularData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 32767, null);
    }

    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainTextNew = str;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateMainText = str;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateSecondText = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateSecondTextNew = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAlbumMainText() {
        return this.albumMainText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAlbumSecondText() {
        return this.albumSecondText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAlbumSecondTextNew() {
        return this.albumSecondTextNew;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBannerPlaceHolderEmptyHint() {
        return this.bannerPlaceHolderEmptyHint;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getBannerPlaceHolderFailHint() {
        return this.bannerPlaceHolderFailHint;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlusMenuRegularData)) {
            return false;
        }
        PlusMenuRegularData plusMenuRegularData = (PlusMenuRegularData) other;
        if (Intrinsics.areEqual(this.mainText, plusMenuRegularData.mainText) && Intrinsics.areEqual(this.mainTextNew, plusMenuRegularData.mainTextNew) && Intrinsics.areEqual(this.cameraMainText, plusMenuRegularData.cameraMainText) && Intrinsics.areEqual(this.cameraSecondText, plusMenuRegularData.cameraSecondText) && Intrinsics.areEqual(this.cameraSecondTextNew, plusMenuRegularData.cameraSecondTextNew) && Intrinsics.areEqual(this.templateMainText, plusMenuRegularData.templateMainText) && Intrinsics.areEqual(this.templateSecondText, plusMenuRegularData.templateSecondText) && Intrinsics.areEqual(this.templateSecondTextNew, plusMenuRegularData.templateSecondTextNew) && Intrinsics.areEqual(this.albumMainText, plusMenuRegularData.albumMainText) && Intrinsics.areEqual(this.albumSecondText, plusMenuRegularData.albumSecondText) && Intrinsics.areEqual(this.albumSecondTextNew, plusMenuRegularData.albumSecondTextNew) && this.bannerScrollInterval == plusMenuRegularData.bannerScrollInterval && Intrinsics.areEqual(this.bannerPlaceHolderLoadingHint, plusMenuRegularData.bannerPlaceHolderLoadingHint) && Intrinsics.areEqual(this.bannerPlaceHolderFailHint, plusMenuRegularData.bannerPlaceHolderFailHint) && Intrinsics.areEqual(this.bannerPlaceHolderEmptyHint, plusMenuRegularData.bannerPlaceHolderEmptyHint)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getBannerPlaceHolderLoadingHint() {
        return this.bannerPlaceHolderLoadingHint;
    }

    /* renamed from: g, reason: from getter */
    public final int getBannerScrollInterval() {
        return this.bannerScrollInterval;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getCameraMainText() {
        return this.cameraMainText;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.mainText.hashCode() * 31) + this.mainTextNew.hashCode()) * 31) + this.cameraMainText.hashCode()) * 31) + this.cameraSecondText.hashCode()) * 31) + this.cameraSecondTextNew.hashCode()) * 31) + this.templateMainText.hashCode()) * 31) + this.templateSecondText.hashCode()) * 31) + this.templateSecondTextNew.hashCode()) * 31) + this.albumMainText.hashCode()) * 31) + this.albumSecondText.hashCode()) * 31) + this.albumSecondTextNew.hashCode()) * 31) + this.bannerScrollInterval) * 31) + this.bannerPlaceHolderLoadingHint.hashCode()) * 31) + this.bannerPlaceHolderFailHint.hashCode()) * 31) + this.bannerPlaceHolderEmptyHint.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getCameraSecondText() {
        return this.cameraSecondText;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getCameraSecondTextNew() {
        return this.cameraSecondTextNew;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getMainText() {
        return this.mainText;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getMainTextNew() {
        return this.mainTextNew;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getTemplateMainText() {
        return this.templateMainText;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getTemplateSecondText() {
        return this.templateSecondText;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getTemplateSecondTextNew() {
        return this.templateSecondTextNew;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumMainText = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumSecondText = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumSecondTextNew = str;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerPlaceHolderEmptyHint = str;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerPlaceHolderFailHint = str;
    }

    @NotNull
    public String toString() {
        return "PlusMenuRegularData(mainText=" + this.mainText + ", mainTextNew=" + this.mainTextNew + ", cameraMainText=" + this.cameraMainText + ", cameraSecondText=" + this.cameraSecondText + ", cameraSecondTextNew=" + this.cameraSecondTextNew + ", templateMainText=" + this.templateMainText + ", templateSecondText=" + this.templateSecondText + ", templateSecondTextNew=" + this.templateSecondTextNew + ", albumMainText=" + this.albumMainText + ", albumSecondText=" + this.albumSecondText + ", albumSecondTextNew=" + this.albumSecondTextNew + ", bannerScrollInterval=" + this.bannerScrollInterval + ", bannerPlaceHolderLoadingHint=" + this.bannerPlaceHolderLoadingHint + ", bannerPlaceHolderFailHint=" + this.bannerPlaceHolderFailHint + ", bannerPlaceHolderEmptyHint=" + this.bannerPlaceHolderEmptyHint + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerPlaceHolderLoadingHint = str;
    }

    public final void v(int i3) {
        this.bannerScrollInterval = i3;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cameraMainText = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cameraSecondText = str;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cameraSecondTextNew = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainText = str;
    }

    public PlusMenuRegularData(@NotNull String mainText, @NotNull String mainTextNew, @NotNull String cameraMainText, @NotNull String cameraSecondText, @NotNull String cameraSecondTextNew, @NotNull String templateMainText, @NotNull String templateSecondText, @NotNull String templateSecondTextNew, @NotNull String albumMainText, @NotNull String albumSecondText, @NotNull String albumSecondTextNew, int i3, @NotNull String bannerPlaceHolderLoadingHint, @NotNull String bannerPlaceHolderFailHint, @NotNull String bannerPlaceHolderEmptyHint) {
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        Intrinsics.checkNotNullParameter(mainTextNew, "mainTextNew");
        Intrinsics.checkNotNullParameter(cameraMainText, "cameraMainText");
        Intrinsics.checkNotNullParameter(cameraSecondText, "cameraSecondText");
        Intrinsics.checkNotNullParameter(cameraSecondTextNew, "cameraSecondTextNew");
        Intrinsics.checkNotNullParameter(templateMainText, "templateMainText");
        Intrinsics.checkNotNullParameter(templateSecondText, "templateSecondText");
        Intrinsics.checkNotNullParameter(templateSecondTextNew, "templateSecondTextNew");
        Intrinsics.checkNotNullParameter(albumMainText, "albumMainText");
        Intrinsics.checkNotNullParameter(albumSecondText, "albumSecondText");
        Intrinsics.checkNotNullParameter(albumSecondTextNew, "albumSecondTextNew");
        Intrinsics.checkNotNullParameter(bannerPlaceHolderLoadingHint, "bannerPlaceHolderLoadingHint");
        Intrinsics.checkNotNullParameter(bannerPlaceHolderFailHint, "bannerPlaceHolderFailHint");
        Intrinsics.checkNotNullParameter(bannerPlaceHolderEmptyHint, "bannerPlaceHolderEmptyHint");
        this.mainText = mainText;
        this.mainTextNew = mainTextNew;
        this.cameraMainText = cameraMainText;
        this.cameraSecondText = cameraSecondText;
        this.cameraSecondTextNew = cameraSecondTextNew;
        this.templateMainText = templateMainText;
        this.templateSecondText = templateSecondText;
        this.templateSecondTextNew = templateSecondTextNew;
        this.albumMainText = albumMainText;
        this.albumSecondText = albumSecondText;
        this.albumSecondTextNew = albumSecondTextNew;
        this.bannerScrollInterval = i3;
        this.bannerPlaceHolderLoadingHint = bannerPlaceHolderLoadingHint;
        this.bannerPlaceHolderFailHint = bannerPlaceHolderFailHint;
        this.bannerPlaceHolderEmptyHint = bannerPlaceHolderEmptyHint;
        this.showMainText = mainTextNew;
        this.showCameraSecondText = cameraSecondTextNew;
        this.showTemplateSecondText = templateSecondTextNew;
        this.showAlbumSecondText = albumSecondTextNew;
    }

    public /* synthetic */ PlusMenuRegularData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i3, String str12, String str13, String str14, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "\u6bcf\u4e00\u4e2a\u4f60\u90fd\u503c\u5f97\u88ab\u8ba4\u8bc6\u2728" : str, (i16 & 2) != 0 ? "\u62cd\u89c6\u9891\uff0c\u8bb0\u5f55\u751f\u6d3b" : str2, (i16 & 4) != 0 ? "\u62cd\u6444" : str3, (i16 & 8) != 0 ? "\u767e\u6b3e\u9053\u5177\uff0c\u589e\u52a0\u8da3\u5473" : str4, (i16 & 16) != 0 ? "\u767e\u53d8\u8da3\u5473\u9053\u5177" : str5, (i16 & 32) != 0 ? "\u7075\u611f\u5e93" : str6, (i16 & 64) != 0 ? "\u54c1\u8d28\u6a21\u7248\uff0c\u8f7b\u677e\u5927\u7247" : str7, (i16 & 128) != 0 ? "\u6d77\u91cf\u89c6\u9891\u6a21\u677f" : str8, (i16 & 256) != 0 ? QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE : str9, (i16 & 512) != 0 ? "\u4e0a\u4f20\u5185\u5bb9\uff0c\u667a\u80fd\u6210\u7247" : str10, (i16 & 1024) != 0 ? "\u4e00\u952e\u4f20\u56fe\u6210\u7247" : str11, (i16 & 2048) != 0 ? 3 : i3, (i16 & 4096) != 0 ? "" : str12, (i16 & 8192) != 0 ? "\u52a0\u8f7d\u5931\u8d25" : str13, (i16 & 16384) != 0 ? "\u6682\u65e0\u6700\u65b0\u6d3b\u52a8" : str14);
    }
}
