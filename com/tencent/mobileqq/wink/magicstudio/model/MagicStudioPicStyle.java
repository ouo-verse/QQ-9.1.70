package com.tencent.mobileqq.wink.magicstudio.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.wink.editor.InputMediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 Z2\u00020\u0001:\u0001[B\u00d3\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\t\u00a2\u0006\u0004\bX\u0010YJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\tH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\u00e2\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010,\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b-\u0010.J\t\u0010/\u001a\u00020\u0002H\u00d6\u0001J\t\u00100\u001a\u00020\u0006H\u00d6\u0001J\u0013\u00103\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000101H\u00d6\u0003R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b7\u00106R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b8\u00106R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b<\u00106R\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010=\u001a\u0004\b@\u0010?R\u0017\u0010!\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u00104\u001a\u0004\bD\u00106R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\bE\u00106R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u00104\u001a\u0004\bF\u00106R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u00104\u001a\u0004\bG\u00106R\u0019\u0010&\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0013R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u00104\u001a\u0004\bJ\u00106R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u00104\u001a\u0004\bK\u00106R\u0019\u0010)\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u00104\u001a\u0004\bL\u00106R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u00104\u001a\u0004\bM\u00106R\u0019\u0010+\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u00104\u001a\u0004\bN\u00106R\u0017\u0010,\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b,\u0010=\u001a\u0004\bO\u0010?R6\u0010R\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060Q\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "component5", "", "component6", "component7", "Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "component8", "component9", "component10", "component11", "component12", "component13", "()Ljava/lang/Integer;", "component14", "component15", "component16", "component17", "component18", "component19", "coverUrl", "styleId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "priority", "name", "useDefaultStyleId", "forceVerticalResultImage", "inputMediaType", "styleModeIdListStr", "tagTitle", "tagUin", AppConstants.Key.KEY_QZONE_VIDEO_URL, "usageCnt", "staticMotionCoverUrl", "makeButtonTitle", "categoryName", "pushImgUrl", "outputImageAspectRatio", "publishWithOriginImage", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLcom/tencent/mobileqq/wink/editor/InputMediaType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/String;", "getStyleId", "getMaterialId", "I", "getPriority", "()I", "getName", "Z", "getUseDefaultStyleId", "()Z", "getForceVerticalResultImage", "Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "getInputMediaType", "()Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "getStyleModeIdListStr", "getTagTitle", "getTagUin", "getVideoUrl", "Ljava/lang/Integer;", "getUsageCnt", "getStaticMotionCoverUrl", "getMakeButtonTitle", "getCategoryName", "getPushImgUrl", "getOutputImageAspectRatio", "getPublishWithOriginImage", "", "Lkotlin/Pair;", "styleModeIdList", "Ljava/util/List;", "getStyleModeIdList", "()Ljava/util/List;", "setStyleModeIdList", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLcom/tencent/mobileqq/wink/editor/InputMediaType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioPicStyle implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String categoryName;

    @NotNull
    private final String coverUrl;
    private final boolean forceVerticalResultImage;

    @NotNull
    private final InputMediaType inputMediaType;

    @Nullable
    private final String makeButtonTitle;

    @NotNull
    private final String materialId;

    @NotNull
    private final String name;

    @Nullable
    private final String outputImageAspectRatio;
    private final int priority;
    private final boolean publishWithOriginImage;

    @Nullable
    private final String pushImgUrl;

    @Nullable
    private final String staticMotionCoverUrl;

    @NotNull
    private final String styleId;

    @Nullable
    private List<Pair<String, Integer>> styleModeIdList;

    @Nullable
    private final String styleModeIdListStr;

    @Nullable
    private final String tagTitle;

    @Nullable
    private final String tagUin;

    @Nullable
    private final Integer usageCnt;
    private final boolean useDefaultStyleId;

    @Nullable
    private final String videoUrl;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MagicStudioPicStyle a(@NotNull MetaMaterial material, @Nullable MetaCategory metaCategory) {
            boolean z16;
            Intrinsics.checkNotNullParameter(material, "material");
            String x06 = com.tencent.mobileqq.wink.editor.c.x0(material);
            String t16 = com.tencent.mobileqq.wink.editor.c.t(material);
            String str = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            int h06 = com.tencent.mobileqq.wink.editor.c.h0(material);
            String a06 = com.tencent.mobileqq.wink.editor.c.a0(material);
            boolean Q0 = com.tencent.mobileqq.wink.editor.c.Q0(material);
            boolean D = com.tencent.mobileqq.wink.editor.c.D(material);
            InputMediaType L = com.tencent.mobileqq.wink.editor.c.L(material);
            String A0 = com.tencent.mobileqq.wink.editor.c.A0(material);
            String C0 = com.tencent.mobileqq.wink.editor.c.C0(material);
            String D0 = com.tencent.mobileqq.wink.editor.c.D0(material);
            String S0 = com.tencent.mobileqq.wink.editor.c.S0(material);
            Integer valueOf = Integer.valueOf(material.usageCnt);
            String s06 = com.tencent.mobileqq.wink.editor.c.s0(material);
            String Q = com.tencent.mobileqq.wink.editor.c.Q(material);
            String p16 = com.tencent.mobileqq.wink.editor.c.p(material);
            String j06 = com.tencent.mobileqq.wink.editor.c.j0(material);
            String f06 = com.tencent.mobileqq.wink.editor.c.f0(material);
            if (metaCategory != null) {
                z16 = com.tencent.mobileqq.wink.editor.b.d(metaCategory);
            } else {
                z16 = true;
            }
            return new MagicStudioPicStyle(x06, t16, str, h06, a06, Q0, D, L, A0, C0, D0, S0, valueOf, s06, Q, p16, j06, f06, z16);
        }

        Companion() {
        }
    }

    public MagicStudioPicStyle(@NotNull String coverUrl, @NotNull String styleId, @NotNull String materialId, int i3, @NotNull String name, boolean z16, boolean z17, @NotNull InputMediaType inputMediaType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, boolean z18) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(inputMediaType, "inputMediaType");
        this.coverUrl = coverUrl;
        this.styleId = styleId;
        this.materialId = materialId;
        this.priority = i3;
        this.name = name;
        this.useDefaultStyleId = z16;
        this.forceVerticalResultImage = z17;
        this.inputMediaType = inputMediaType;
        this.styleModeIdListStr = str;
        this.tagTitle = str2;
        this.tagUin = str3;
        this.videoUrl = str4;
        this.usageCnt = num;
        this.staticMotionCoverUrl = str5;
        this.makeButtonTitle = str6;
        this.categoryName = str7;
        this.pushImgUrl = str8;
        this.outputImageAspectRatio = str9;
        this.publishWithOriginImage = z18;
        if (str == null || str.length() == 0) {
            return;
        }
        this.styleModeIdList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                String string = jSONObject.getString("styleId");
                int i17 = jSONObject.getInt("baseImageIndex");
                List<Pair<String, Integer>> list = this.styleModeIdList;
                Intrinsics.checkNotNull(list);
                list.add(TuplesKt.to(string, Integer.valueOf(i17)));
            }
        } catch (Throwable th5) {
            w53.b.e("MagicStudioPicStyle", th5);
        }
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getTagTitle() {
        return this.tagTitle;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getTagUin() {
        return this.tagUin;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getUsageCnt() {
        return this.usageCnt;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getStaticMotionCoverUrl() {
        return this.staticMotionCoverUrl;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getMakeButtonTitle() {
        return this.makeButtonTitle;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getPushImgUrl() {
        return this.pushImgUrl;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getOutputImageAspectRatio() {
        return this.outputImageAspectRatio;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getPublishWithOriginImage() {
        return this.publishWithOriginImage;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getStyleId() {
        return this.styleId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMaterialId() {
        return this.materialId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUseDefaultStyleId() {
        return this.useDefaultStyleId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getForceVerticalResultImage() {
        return this.forceVerticalResultImage;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final InputMediaType getInputMediaType() {
        return this.inputMediaType;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getStyleModeIdListStr() {
        return this.styleModeIdListStr;
    }

    @NotNull
    public final MagicStudioPicStyle copy(@NotNull String coverUrl, @NotNull String styleId, @NotNull String materialId, int priority, @NotNull String name, boolean useDefaultStyleId, boolean forceVerticalResultImage, @NotNull InputMediaType inputMediaType, @Nullable String styleModeIdListStr, @Nullable String tagTitle, @Nullable String tagUin, @Nullable String videoUrl, @Nullable Integer usageCnt, @Nullable String staticMotionCoverUrl, @Nullable String makeButtonTitle, @Nullable String categoryName, @Nullable String pushImgUrl, @Nullable String outputImageAspectRatio, boolean publishWithOriginImage) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(inputMediaType, "inputMediaType");
        return new MagicStudioPicStyle(coverUrl, styleId, materialId, priority, name, useDefaultStyleId, forceVerticalResultImage, inputMediaType, styleModeIdListStr, tagTitle, tagUin, videoUrl, usageCnt, staticMotionCoverUrl, makeButtonTitle, categoryName, pushImgUrl, outputImageAspectRatio, publishWithOriginImage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioPicStyle)) {
            return false;
        }
        MagicStudioPicStyle magicStudioPicStyle = (MagicStudioPicStyle) other;
        if (Intrinsics.areEqual(this.coverUrl, magicStudioPicStyle.coverUrl) && Intrinsics.areEqual(this.styleId, magicStudioPicStyle.styleId) && Intrinsics.areEqual(this.materialId, magicStudioPicStyle.materialId) && this.priority == magicStudioPicStyle.priority && Intrinsics.areEqual(this.name, magicStudioPicStyle.name) && this.useDefaultStyleId == magicStudioPicStyle.useDefaultStyleId && this.forceVerticalResultImage == magicStudioPicStyle.forceVerticalResultImage && this.inputMediaType == magicStudioPicStyle.inputMediaType && Intrinsics.areEqual(this.styleModeIdListStr, magicStudioPicStyle.styleModeIdListStr) && Intrinsics.areEqual(this.tagTitle, magicStudioPicStyle.tagTitle) && Intrinsics.areEqual(this.tagUin, magicStudioPicStyle.tagUin) && Intrinsics.areEqual(this.videoUrl, magicStudioPicStyle.videoUrl) && Intrinsics.areEqual(this.usageCnt, magicStudioPicStyle.usageCnt) && Intrinsics.areEqual(this.staticMotionCoverUrl, magicStudioPicStyle.staticMotionCoverUrl) && Intrinsics.areEqual(this.makeButtonTitle, magicStudioPicStyle.makeButtonTitle) && Intrinsics.areEqual(this.categoryName, magicStudioPicStyle.categoryName) && Intrinsics.areEqual(this.pushImgUrl, magicStudioPicStyle.pushImgUrl) && Intrinsics.areEqual(this.outputImageAspectRatio, magicStudioPicStyle.outputImageAspectRatio) && this.publishWithOriginImage == magicStudioPicStyle.publishWithOriginImage) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final boolean getForceVerticalResultImage() {
        return this.forceVerticalResultImage;
    }

    @NotNull
    public final InputMediaType getInputMediaType() {
        return this.inputMediaType;
    }

    @Nullable
    public final String getMakeButtonTitle() {
        return this.makeButtonTitle;
    }

    @NotNull
    public final String getMaterialId() {
        return this.materialId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOutputImageAspectRatio() {
        return this.outputImageAspectRatio;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getPublishWithOriginImage() {
        return this.publishWithOriginImage;
    }

    @Nullable
    public final String getPushImgUrl() {
        return this.pushImgUrl;
    }

    @Nullable
    public final String getStaticMotionCoverUrl() {
        return this.staticMotionCoverUrl;
    }

    @NotNull
    public final String getStyleId() {
        return this.styleId;
    }

    @Nullable
    public final List<Pair<String, Integer>> getStyleModeIdList() {
        return this.styleModeIdList;
    }

    @Nullable
    public final String getStyleModeIdListStr() {
        return this.styleModeIdListStr;
    }

    @Nullable
    public final String getTagTitle() {
        return this.tagTitle;
    }

    @Nullable
    public final String getTagUin() {
        return this.tagUin;
    }

    @Nullable
    public final Integer getUsageCnt() {
        return this.usageCnt;
    }

    public final boolean getUseDefaultStyleId() {
        return this.useDefaultStyleId;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10 = ((((((((this.coverUrl.hashCode() * 31) + this.styleId.hashCode()) * 31) + this.materialId.hashCode()) * 31) + this.priority) * 31) + this.name.hashCode()) * 31;
        boolean z16 = this.useDefaultStyleId;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode10 + i16) * 31;
        boolean z17 = this.forceVerticalResultImage;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode11 = (((i17 + i18) * 31) + this.inputMediaType.hashCode()) * 31;
        String str = this.styleModeIdListStr;
        int i19 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i26 = (hashCode11 + hashCode) * 31;
        String str2 = this.tagTitle;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i27 = (i26 + hashCode2) * 31;
        String str3 = this.tagUin;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i28 = (i27 + hashCode3) * 31;
        String str4 = this.videoUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i29 = (i28 + hashCode4) * 31;
        Integer num = this.usageCnt;
        if (num == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num.hashCode();
        }
        int i36 = (i29 + hashCode5) * 31;
        String str5 = this.staticMotionCoverUrl;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i37 = (i36 + hashCode6) * 31;
        String str6 = this.makeButtonTitle;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i38 = (i37 + hashCode7) * 31;
        String str7 = this.categoryName;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i39 = (i38 + hashCode8) * 31;
        String str8 = this.pushImgUrl;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i46 = (i39 + hashCode9) * 31;
        String str9 = this.outputImageAspectRatio;
        if (str9 != null) {
            i19 = str9.hashCode();
        }
        int i47 = (i46 + i19) * 31;
        boolean z18 = this.publishWithOriginImage;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i47 + i3;
    }

    public final void setStyleModeIdList(@Nullable List<Pair<String, Integer>> list) {
        this.styleModeIdList = list;
    }

    @NotNull
    public String toString() {
        return "MagicStudioPicStyle(coverUrl=" + this.coverUrl + ", styleId=" + this.styleId + ", materialId=" + this.materialId + ", priority=" + this.priority + ", name=" + this.name + ", useDefaultStyleId=" + this.useDefaultStyleId + ", forceVerticalResultImage=" + this.forceVerticalResultImage + ", inputMediaType=" + this.inputMediaType + ", styleModeIdListStr=" + this.styleModeIdListStr + ", tagTitle=" + this.tagTitle + ", tagUin=" + this.tagUin + ", videoUrl=" + this.videoUrl + ", usageCnt=" + this.usageCnt + ", staticMotionCoverUrl=" + this.staticMotionCoverUrl + ", makeButtonTitle=" + this.makeButtonTitle + ", categoryName=" + this.categoryName + ", pushImgUrl=" + this.pushImgUrl + ", outputImageAspectRatio=" + this.outputImageAspectRatio + ", publishWithOriginImage=" + this.publishWithOriginImage + ")";
    }

    public /* synthetic */ MagicStudioPicStyle(String str, String str2, String str3, int i3, String str4, boolean z16, boolean z17, InputMediaType inputMediaType, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, String str11, String str12, String str13, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? -1 : i3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? false : z17, inputMediaType, str5, (i16 & 512) != 0 ? null : str6, (i16 & 1024) != 0 ? null : str7, (i16 & 2048) != 0 ? null : str8, (i16 & 4096) != 0 ? null : num, (i16 & 8192) != 0 ? null : str9, (i16 & 16384) != 0 ? null : str10, (32768 & i16) != 0 ? null : str11, (65536 & i16) != 0 ? null : str12, (131072 & i16) != 0 ? null : str13, (i16 & 262144) != 0 ? true : z18);
    }
}
