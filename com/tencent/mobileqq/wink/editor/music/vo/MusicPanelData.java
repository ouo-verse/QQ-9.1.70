package com.tencent.mobileqq.wink.editor.music.vo;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0089\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b#\u0010\rR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b&\u0010\rR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b(\u0010\rR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b*\u0010\rR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\n\u001a\u0004\b%\u0010\u000b\"\u0004\b-\u0010\rR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b/\u0010\rR\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b,\u0010\u000b\"\u0004\b1\u0010\r\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "musicLibUrl", "b", "j", "w", "musicSearchUrl", "c", "l", "y", "testMusicLibUrl", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "testMusicSearchUrl", "e", "g", "t", "musicPanelOriginVolumeName", "f", "i", "v", "musicPanelSelectMusicName", ReportConstant.COSTREPORT_PREFIX, "musicPanelOpenVolumeName", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "musicPanelOpenLyricName", "r", "musicPanelOpenSearchName", "p", "musicPanelOpenLibName", "k", "u", "musicPanelRecommendTabName", "o", "musicPanelCollectTabName", HippyTKDListViewAdapter.X, "musicSelectCellAnimation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.music.vo.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MusicPanelData {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicLibUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicSearchUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String testMusicLibUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String testMusicSearchUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelOriginVolumeName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelSelectMusicName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelOpenVolumeName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelOpenLyricName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelOpenSearchName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelOpenLibName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelRecommendTabName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicPanelCollectTabName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String musicSelectCellAnimation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/c$a;", "", "", "jsonStr", "Lcom/tencent/mobileqq/wink/editor/music/vo/c;", "a", "MUSIC_LIB_URL", "Ljava/lang/String;", "MUSIC_PANEL_COLLECT_TAB_NAME", "MUSIC_PANEL_OPEN_LIB_NAME", "MUSIC_PANEL_OPEN_LYRIC_NAME", "MUSIC_PANEL_OPEN_SEARCH_NAME", "MUSIC_PANEL_OPEN_VOLUME_NAME", "MUSIC_PANEL_ORIGIN_VOLUME_NAME", "MUSIC_PANEL_RECOMMEND_TAB_NAME", "MUSIC_PANEL_SELECT_MUSIC_NAME", "MUSIC_SEARCH_URL", "MUSIC_SELECT_CELL_ANIMATION", "TAG", "TEST_MUSIC_LIB_URL", "TEST_MUSIC_SEARCH_URL", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.vo.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MusicPanelData a(@Nullable String jsonStr) {
            boolean z16;
            QLog.d("MusicPanelData", 1, "fromJson, jsonStr:" + jsonStr);
            MusicPanelData musicPanelData = new MusicPanelData(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null);
            if (jsonStr != null && jsonStr.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonStr);
                    String optString = jSONObject.optString("music_lib_url", musicPanelData.getMusicLibUrl());
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(MUSIC_LIB_URL, musicLibUrl)");
                    musicPanelData.n(optString);
                    String optString2 = jSONObject.optString("music_search_url", musicPanelData.getMusicSearchUrl());
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(MUSIC_SEARCH_URL, musicSearchUrl)");
                    musicPanelData.w(optString2);
                    String optString3 = jSONObject.optString("test_music_lib_url", musicPanelData.getTestMusicLibUrl());
                    Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(TEST_MUSI\u2026LIB_URL, testMusicLibUrl)");
                    musicPanelData.y(optString3);
                    String optString4 = jSONObject.optString("test_music_search_url", musicPanelData.getTestMusicSearchUrl());
                    Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(TEST_MUSI\u2026_URL, testMusicSearchUrl)");
                    musicPanelData.z(optString4);
                    String optString5 = jSONObject.optString("music_panel_origin_volume_name", musicPanelData.getMusicPanelOriginVolumeName());
                    Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(MUSIC_PAN\u2026sicPanelOriginVolumeName)");
                    musicPanelData.t(optString5);
                    String optString6 = jSONObject.optString("music_panel_select_music_name", musicPanelData.getMusicPanelSelectMusicName());
                    Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(MUSIC_PAN\u2026usicPanelSelectMusicName)");
                    musicPanelData.v(optString6);
                    String optString7 = jSONObject.optString("music_panel_open_volume_name", musicPanelData.getMusicPanelOpenVolumeName());
                    Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(MUSIC_PAN\u2026musicPanelOpenVolumeName)");
                    musicPanelData.s(optString7);
                    String optString8 = jSONObject.optString("music_panel_open_lyric_name", musicPanelData.getMusicPanelOpenLyricName());
                    Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(MUSIC_PAN\u2026 musicPanelOpenLyricName)");
                    musicPanelData.q(optString8);
                    String optString9 = jSONObject.optString("music_panel_open_search_name", musicPanelData.getMusicPanelOpenSearchName());
                    Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(MUSIC_PAN\u2026musicPanelOpenSearchName)");
                    musicPanelData.r(optString9);
                    String optString10 = jSONObject.optString("music_panel_open_lib_name", musicPanelData.getMusicPanelOpenLibName());
                    Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(MUSIC_PAN\u2026E, musicPanelOpenLibName)");
                    musicPanelData.p(optString10);
                    String optString11 = jSONObject.optString("music_panel_recommend_tab_name", musicPanelData.getMusicPanelRecommendTabName());
                    Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(MUSIC_PAN\u2026sicPanelRecommendTabName)");
                    musicPanelData.u(optString11);
                    String optString12 = jSONObject.optString("music_panel_collect_tab_name", musicPanelData.getMusicPanelCollectTabName());
                    Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(MUSIC_PAN\u2026musicPanelCollectTabName)");
                    musicPanelData.o(optString12);
                    String optString13 = jSONObject.optString("music_select_cell_animation", musicPanelData.getMusicSelectCellAnimation());
                    Intrinsics.checkNotNullExpressionValue(optString13, "json.optString(MUSIC_SEL\u2026musicSelectCellAnimation)");
                    musicPanelData.x(optString13);
                } catch (Exception e16) {
                    QLog.e("MusicPanelData", 1, "fromJson, error ", e16);
                }
            }
            return musicPanelData;
        }

        Companion() {
        }
    }

    public MusicPanelData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMusicLibUrl() {
        return this.musicLibUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMusicPanelCollectTabName() {
        return this.musicPanelCollectTabName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMusicPanelOpenLibName() {
        return this.musicPanelOpenLibName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMusicPanelOpenLyricName() {
        return this.musicPanelOpenLyricName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getMusicPanelOpenSearchName() {
        return this.musicPanelOpenSearchName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicPanelData)) {
            return false;
        }
        MusicPanelData musicPanelData = (MusicPanelData) other;
        if (Intrinsics.areEqual(this.musicLibUrl, musicPanelData.musicLibUrl) && Intrinsics.areEqual(this.musicSearchUrl, musicPanelData.musicSearchUrl) && Intrinsics.areEqual(this.testMusicLibUrl, musicPanelData.testMusicLibUrl) && Intrinsics.areEqual(this.testMusicSearchUrl, musicPanelData.testMusicSearchUrl) && Intrinsics.areEqual(this.musicPanelOriginVolumeName, musicPanelData.musicPanelOriginVolumeName) && Intrinsics.areEqual(this.musicPanelSelectMusicName, musicPanelData.musicPanelSelectMusicName) && Intrinsics.areEqual(this.musicPanelOpenVolumeName, musicPanelData.musicPanelOpenVolumeName) && Intrinsics.areEqual(this.musicPanelOpenLyricName, musicPanelData.musicPanelOpenLyricName) && Intrinsics.areEqual(this.musicPanelOpenSearchName, musicPanelData.musicPanelOpenSearchName) && Intrinsics.areEqual(this.musicPanelOpenLibName, musicPanelData.musicPanelOpenLibName) && Intrinsics.areEqual(this.musicPanelRecommendTabName, musicPanelData.musicPanelRecommendTabName) && Intrinsics.areEqual(this.musicPanelCollectTabName, musicPanelData.musicPanelCollectTabName) && Intrinsics.areEqual(this.musicSelectCellAnimation, musicPanelData.musicSelectCellAnimation)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getMusicPanelOpenVolumeName() {
        return this.musicPanelOpenVolumeName;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getMusicPanelOriginVolumeName() {
        return this.musicPanelOriginVolumeName;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getMusicPanelRecommendTabName() {
        return this.musicPanelRecommendTabName;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.musicLibUrl.hashCode() * 31) + this.musicSearchUrl.hashCode()) * 31) + this.testMusicLibUrl.hashCode()) * 31) + this.testMusicSearchUrl.hashCode()) * 31) + this.musicPanelOriginVolumeName.hashCode()) * 31) + this.musicPanelSelectMusicName.hashCode()) * 31) + this.musicPanelOpenVolumeName.hashCode()) * 31) + this.musicPanelOpenLyricName.hashCode()) * 31) + this.musicPanelOpenSearchName.hashCode()) * 31) + this.musicPanelOpenLibName.hashCode()) * 31) + this.musicPanelRecommendTabName.hashCode()) * 31) + this.musicPanelCollectTabName.hashCode()) * 31) + this.musicSelectCellAnimation.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getMusicPanelSelectMusicName() {
        return this.musicPanelSelectMusicName;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getMusicSearchUrl() {
        return this.musicSearchUrl;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getMusicSelectCellAnimation() {
        return this.musicSelectCellAnimation;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTestMusicLibUrl() {
        return this.testMusicLibUrl;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getTestMusicSearchUrl() {
        return this.testMusicSearchUrl;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicLibUrl = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelCollectTabName = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelOpenLibName = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelOpenLyricName = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelOpenSearchName = str;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelOpenVolumeName = str;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelOriginVolumeName = str;
    }

    @NotNull
    public String toString() {
        return "MusicPanelData(musicLibUrl=" + this.musicLibUrl + ", musicSearchUrl=" + this.musicSearchUrl + ", testMusicLibUrl=" + this.testMusicLibUrl + ", testMusicSearchUrl=" + this.testMusicSearchUrl + ", musicPanelOriginVolumeName=" + this.musicPanelOriginVolumeName + ", musicPanelSelectMusicName=" + this.musicPanelSelectMusicName + ", musicPanelOpenVolumeName=" + this.musicPanelOpenVolumeName + ", musicPanelOpenLyricName=" + this.musicPanelOpenLyricName + ", musicPanelOpenSearchName=" + this.musicPanelOpenSearchName + ", musicPanelOpenLibName=" + this.musicPanelOpenLibName + ", musicPanelRecommendTabName=" + this.musicPanelRecommendTabName + ", musicPanelCollectTabName=" + this.musicPanelCollectTabName + ", musicSelectCellAnimation=" + this.musicSelectCellAnimation + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelRecommendTabName = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicPanelSelectMusicName = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicSearchUrl = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.musicSelectCellAnimation = str;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testMusicLibUrl = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testMusicSearchUrl = str;
    }

    public MusicPanelData(@NotNull String musicLibUrl, @NotNull String musicSearchUrl, @NotNull String testMusicLibUrl, @NotNull String testMusicSearchUrl, @NotNull String musicPanelOriginVolumeName, @NotNull String musicPanelSelectMusicName, @NotNull String musicPanelOpenVolumeName, @NotNull String musicPanelOpenLyricName, @NotNull String musicPanelOpenSearchName, @NotNull String musicPanelOpenLibName, @NotNull String musicPanelRecommendTabName, @NotNull String musicPanelCollectTabName, @NotNull String musicSelectCellAnimation) {
        Intrinsics.checkNotNullParameter(musicLibUrl, "musicLibUrl");
        Intrinsics.checkNotNullParameter(musicSearchUrl, "musicSearchUrl");
        Intrinsics.checkNotNullParameter(testMusicLibUrl, "testMusicLibUrl");
        Intrinsics.checkNotNullParameter(testMusicSearchUrl, "testMusicSearchUrl");
        Intrinsics.checkNotNullParameter(musicPanelOriginVolumeName, "musicPanelOriginVolumeName");
        Intrinsics.checkNotNullParameter(musicPanelSelectMusicName, "musicPanelSelectMusicName");
        Intrinsics.checkNotNullParameter(musicPanelOpenVolumeName, "musicPanelOpenVolumeName");
        Intrinsics.checkNotNullParameter(musicPanelOpenLyricName, "musicPanelOpenLyricName");
        Intrinsics.checkNotNullParameter(musicPanelOpenSearchName, "musicPanelOpenSearchName");
        Intrinsics.checkNotNullParameter(musicPanelOpenLibName, "musicPanelOpenLibName");
        Intrinsics.checkNotNullParameter(musicPanelRecommendTabName, "musicPanelRecommendTabName");
        Intrinsics.checkNotNullParameter(musicPanelCollectTabName, "musicPanelCollectTabName");
        Intrinsics.checkNotNullParameter(musicSelectCellAnimation, "musicSelectCellAnimation");
        this.musicLibUrl = musicLibUrl;
        this.musicSearchUrl = musicSearchUrl;
        this.testMusicLibUrl = testMusicLibUrl;
        this.testMusicSearchUrl = testMusicSearchUrl;
        this.musicPanelOriginVolumeName = musicPanelOriginVolumeName;
        this.musicPanelSelectMusicName = musicPanelSelectMusicName;
        this.musicPanelOpenVolumeName = musicPanelOpenVolumeName;
        this.musicPanelOpenLyricName = musicPanelOpenLyricName;
        this.musicPanelOpenSearchName = musicPanelOpenSearchName;
        this.musicPanelOpenLibName = musicPanelOpenLibName;
        this.musicPanelRecommendTabName = musicPanelRecommendTabName;
        this.musicPanelCollectTabName = musicPanelCollectTabName;
        this.musicSelectCellAnimation = musicSelectCellAnimation;
    }

    public /* synthetic */ MusicPanelData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? QQWinkConstants.QWINK_LOAD_QQ_MUSIC_URL : str, (i3 & 2) != 0 ? QQWinkConstants.QWINK_LOAD_QQ_SEARCH_MUSIC_URL : str2, (i3 & 4) != 0 ? "https://mtest.xsj.qq.com/h5/music/select?_wv=2" : str3, (i3 & 8) != 0 ? "https://mtest.xsj.qq.com/h5/music/search?_wv=2" : str4, (i3 & 16) != 0 ? "\u539f\u58f0" : str5, (i3 & 32) != 0 ? "\u914d\u4e50" : str6, (i3 & 64) != 0 ? "\u97f3\u91cf" : str7, (i3 & 128) != 0 ? "\u6b4c\u8bcd" : str8, (i3 & 256) != 0 ? "\u641c\u7d22" : str9, (i3 & 512) != 0 ? "\u66f2\u5e93" : str10, (i3 & 1024) != 0 ? "\u63a8\u8350" : str11, (i3 & 2048) != 0 ? "\u6536\u85cf" : str12, (i3 & 4096) != 0 ? "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/9090/musicpanel/qvideo_motion_music_dance.png" : str13);
    }
}
