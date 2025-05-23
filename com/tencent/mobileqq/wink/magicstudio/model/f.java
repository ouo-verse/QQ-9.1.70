package com.tencent.mobileqq.wink.magicstudio.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020'\u0012\b\b\u0002\u00100\u001a\u00020'\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u00a2\u0006\u0004\bL\u0010MJ\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0000R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\fR\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u001b\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\b1\u0010%R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b3\u00105\"\u0004\b6\u00107RB\u0010@\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001109j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0011`:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=\"\u0004\b>\u0010?R6\u0010H\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020C0B\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010D\u001a\u0004\b!\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010)\u001a\u0004\bI\u0010*\"\u0004\bJ\u0010,\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "", "", ark.ARKMETADATA_JSON, "", "r", "ids", "", ReportConstant.COSTREPORT_PREFIX, "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "styleID", "b", "l", "templateID", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "k", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", HippyTKDListViewAdapter.X, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "template", "d", "img", "e", "defaultPromptTip", "defaultPrompt", "g", "i", "styleName", tl.h.F, "o", "topic", "setStyleModeId", "(Ljava/lang/String;)V", "styleModeId", "", "j", "Z", "()Z", "v", "(Z)V", "selected", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "isRecommend", "setSupportMode", "supportMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "()Ljava/util/Map;", "y", "(Ljava/util/Map;)V", "templateIDMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", DomainData.DOMAIN_NAME, "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setTemplateMaterialMap", "(Ljava/util/HashMap;)V", "templateMaterialMap", "", "Lkotlin/Pair;", "", "Ljava/util/List;", "()Ljava/util/List;", "w", "(Ljava/util/List;)V", "styleModeIdList", "p", "t", "isCollectionStyle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String styleID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String templateID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial template;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String img;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultPromptTip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultPrompt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String styleName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String topic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String styleModeId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isRecommend;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String supportMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, String> templateIDMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, MetaMaterial> templateMaterialMap;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<Pair<String, Integer>> styleModeIdList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isCollectionStyle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/model/f$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        a() {
        }
    }

    public f(@NotNull String styleID, @NotNull String templateID, @Nullable MetaMaterial metaMaterial, @NotNull String img, @NotNull String defaultPromptTip, @NotNull String defaultPrompt, @NotNull String styleName, @Nullable String str, @NotNull String styleModeId, boolean z16, boolean z17, @NotNull String supportMode) {
        Intrinsics.checkNotNullParameter(styleID, "styleID");
        Intrinsics.checkNotNullParameter(templateID, "templateID");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(defaultPromptTip, "defaultPromptTip");
        Intrinsics.checkNotNullParameter(defaultPrompt, "defaultPrompt");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(styleModeId, "styleModeId");
        Intrinsics.checkNotNullParameter(supportMode, "supportMode");
        this.styleID = styleID;
        this.templateID = templateID;
        this.template = metaMaterial;
        this.img = img;
        this.defaultPromptTip = defaultPromptTip;
        this.defaultPrompt = defaultPrompt;
        this.styleName = styleName;
        this.topic = str;
        this.styleModeId = styleModeId;
        this.selected = z16;
        this.isRecommend = z17;
        this.supportMode = supportMode;
        this.templateMaterialMap = new HashMap<>();
    }

    @NotNull
    public final f a() {
        f fVar = new f(this.styleID, this.templateID, this.template, this.img, this.defaultPromptTip, this.defaultPrompt, this.styleName, this.topic, this.styleModeId, this.selected, this.isRecommend, this.supportMode);
        fVar.templateIDMap = this.templateIDMap;
        fVar.templateMaterialMap = this.templateMaterialMap;
        fVar.styleModeIdList = this.styleModeIdList;
        fVar.isCollectionStyle = this.isCollectionStyle;
        return fVar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDefaultPrompt() {
        return this.defaultPrompt;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDefaultPromptTip() {
        return this.defaultPromptTip;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getStyleID() {
        return this.styleID;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getStyleModeId() {
        return this.styleModeId;
    }

    @Nullable
    public final List<Pair<String, Integer>> h() {
        return this.styleModeIdList;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getStyleName() {
        return this.styleName;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSupportMode() {
        return this.supportMode;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final MetaMaterial getTemplate() {
        return this.template;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTemplateID() {
        return this.templateID;
    }

    @Nullable
    public final Map<String, String> m() {
        return this.templateIDMap;
    }

    @NotNull
    public final HashMap<String, MetaMaterial> n() {
        return this.templateMaterialMap;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsCollectionStyle() {
        return this.isCollectionStyle;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsRecommend() {
        return this.isRecommend;
    }

    @Nullable
    public final Map<String, String> r(@Nullable String json) {
        try {
            return (Map) new Gson().fromJson(json, new a().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public final List<String> s(@Nullable String ids) {
        List<String> split$default;
        if (ids == null) {
            return null;
        }
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) ids, new String[]{","}, false, 0, 6, (Object) null);
            return split$default;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void t(boolean z16) {
        this.isCollectionStyle = z16;
    }

    public final void u(boolean z16) {
        this.isRecommend = z16;
    }

    public final void v(boolean z16) {
        this.selected = z16;
    }

    public final void w(@Nullable List<Pair<String, Integer>> list) {
        this.styleModeIdList = list;
    }

    public final void x(@Nullable MetaMaterial metaMaterial) {
        this.template = metaMaterial;
    }

    public final void y(@Nullable Map<String, String> map) {
        this.templateIDMap = map;
    }

    public /* synthetic */ f(String str, String str2, MetaMaterial metaMaterial, String str3, String str4, String str5, String str6, String str7, String str8, boolean z16, boolean z17, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : metaMaterial, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) == 0 ? str7 : null, (i3 & 256) == 0 ? str8 : "", (i3 & 512) != 0 ? false : z16, (i3 & 1024) != 0 ? true : z17, (i3 & 2048) != 0 ? "0" : str9);
    }
}
