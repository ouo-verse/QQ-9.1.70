package com.tencent.videocut.render.extension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.pag.ImageLayerData;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.tavcut.core.render.builder.light.model.type.TimeStretchMode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.ImageType;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.render.BackgroundTextRenderHelper;
import com.tencent.videocut.render.StickerRenderHelper;
import com.tencent.videocut.render.TemplateTextRenderHelper;
import com.tencent.videocut.utils.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.datasource.LightBaseDataSourceValue;
import org.light.datasource.LightDataSource;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.DataSourceComponent;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.Image;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.ReplaceItem;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.TextReplaceItem;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Vec3;
import org.light.lightAssetKit.enums.PAGScaleMode;
import org.light.lightAssetKit.enums.ReplaceType;
import org.light.lightAssetKit.enums.ScaleMode;
import td4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u001a$\u0010\u0011\u001a\u00020\n*\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f\u001a\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0000\u001a\u0016\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u001a\f\u0010\u001b\u001a\u00020\u0019*\u00020\u0000H\u0002\u001a\u001e\u0010\u001d\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002\u001a\n\u0010\u001f\u001a\u00020\u001e*\u00020\u0000\u001a\n\u0010!\u001a\u00020 *\u00020\u0000\u001a\n\u0010#\u001a\u00020\"*\u00020\u0000\u001a\n\u0010%\u001a\u00020$*\u00020\u0000\u001a\n\u0010&\u001a\u00020$*\u00020\u0000\u001a\u0006\u0010'\u001a\u00020$\u001a\u000e\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005\u001a\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020$0**\b\u0012\u0004\u0012\u00020\u00120*\u001a\u001a\u0010.\u001a\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120*2\u0006\u0010-\u001a\u00020,\u001a\n\u00101\u001a\u000200*\u00020/\u001a\n\u00102\u001a\u00020\u0005*\u00020\u0000\u001a\n\u00103\u001a\u00020\u0005*\u00020\u0000\u001a\u0012\u00106\u001a\u000205*\u00020\u00032\u0006\u00104\u001a\u00020\u0005\u001a\u001a\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002\u001a$\u0010>\u001a\u00020=2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:092\u0006\u0010<\u001a\u00020\u0003H\u0002\u001a$\u0010B\u001a\u00020A2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020:092\u0006\u0010@\u001a\u00020?H\u0002\")\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010\u00050C*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006G"}, d2 = {"Lcom/tencent/videocut/model/StickerModel;", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "Lorg/light/lightAssetKit/Entity;", "o", "", "resourceId", "p", "Lorg/light/lightAssetKit/components/Component;", HippyQQConstants.URL_COMPONENT_NAME, "", "needLoadAsset", "Lcom/tencent/tavcut/core/session/ICutSession;", "iCutSession", "k", com.tencent.mobileqq.msf.service.b.f250813p, "needUpdateEntity", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/videocut/model/TextItem;", "curTextItem", "oldTextItem", "l", "Lorg/light/lightAssetKit/enums/PAGScaleMode;", tl.h.F, "tavCutSession", "Lcom/tencent/videocut/render/StickerRenderHelper$b;", "v", "t", "parentFilePath", "r", "Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;", "j", "Lcom/tencent/videocut/render/TemplateTextRenderHelper$b;", HippyTKDListViewAdapter.X, "Lcom/tencent/videocut/render/BackgroundTextRenderHelper$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/light/lightAssetKit/components/ReplaceItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "bgPath", "c", "", "u", "", "indexText", "f", "Lcom/tencent/videocut/model/AnimationMode;", "Lcom/tencent/tavcut/core/render/builder/light/model/type/TimeStretchMode;", "y", "d", "e", "templatePath", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "w", "inputSourceResId", "g", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "watermarkModel", "mainEntity", "", "a", "", "parentEntityId", "Lorg/light/lightAssetKit/components/DataSourceComponent;", "b", "Lkotlin/Triple;", "i", "(Lcom/tencent/videocut/model/StickerModel;)Lkotlin/Triple;", "splitedIds", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f384137a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f384138b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f384139c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f384140d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59813);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[StickerModel.Type.values().length];
            try {
                iArr[StickerModel.Type.MASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StickerModel.Type.MOSAIC_DOODLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StickerModel.Type.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StickerModel.Type.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StickerModel.Type.TEXT_TEMPLATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StickerModel.Type.TEXT_BACKGROUND_TEMPLATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f384137a = iArr;
            int[] iArr2 = new int[ReplaceType.values().length];
            try {
                iArr2[ReplaceType.Image.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ReplaceType.Text.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f384138b = iArr2;
            int[] iArr3 = new int[AnimationMode.values().length];
            try {
                iArr3[AnimationMode.LOOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[AnimationMode.FREEZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[AnimationMode.SCALE_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[AnimationMode.SCALE_BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            f384139c = iArr3;
            int[] iArr4 = new int[ImageType.values().length];
            try {
                iArr4[ImageType.COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[ImageType.PAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[ImageType.GIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[ImageType.APNG.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            f384140d = iArr4;
        }
    }

    private static final void a(Map<String, WatermarkDataSourceModel> map, Entity entity) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(((WatermarkDataSourceModel) it.next()).entityIdList);
        }
        Iterator it5 = linkedHashSet.iterator();
        while (it5.hasNext()) {
            long longValue = ((Number) it5.next()).longValue();
            Entity c16 = d.c(entity, (int) longValue);
            if (c16 != null) {
                c16.addComponent(b(map, longValue));
            }
        }
    }

    private static final DataSourceComponent b(Map<String, WatermarkDataSourceModel> map, long j3) {
        JsonObject jsonObject;
        DataSourceComponent dataSourceComponent = new DataSourceComponent();
        HashMap<String, LightDataSource> hashMap = new HashMap<>();
        for (Map.Entry<String, WatermarkDataSourceModel> entry : map.entrySet()) {
            String key = entry.getKey();
            WatermarkDataSourceModel value = entry.getValue();
            LightDataSource lightDataSource = new LightDataSource();
            lightDataSource.setEntityId(j3);
            lightDataSource.setDataKey(key);
            lightDataSource.setValue(i.j(value));
            LightBaseDataSourceValue value2 = lightDataSource.getValue();
            if (value2 != null) {
                jsonObject = value2.toJsonObject();
            } else {
                jsonObject = null;
            }
            ms.a.a("wink_sticker", "addDatasourceComponent data is " + jsonObject);
            hashMap.put(key, lightDataSource);
        }
        dataSourceComponent.setData(hashMap);
        return dataSourceComponent;
    }

    @NotNull
    public static final String c(@NotNull String bgPath) {
        Intrinsics.checkNotNullParameter(bgPath, "bgPath");
        String a16 = k.f384249b.a(bgPath);
        if (a16 != null) {
            return a16;
        }
        return bgPath;
    }

    @NotNull
    public static final String d(@NotNull StickerModel stickerModel) {
        int collectionSizeOrDefault;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        List<TextItem> list = stickerModel.textItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TextItem) it.next()).fontFamily);
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        String str = (String) firstOrNull;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String e(@NotNull StickerModel stickerModel) {
        int collectionSizeOrDefault;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        List<TextItem> list = stickerModel.textItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TextItem) it.next()).fontStyle);
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        String str = (String) firstOrNull;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public static final TextItem f(@NotNull List<TextItem> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        for (TextItem textItem : list) {
            if (textItem.index == i3) {
                return textItem;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String g(String str, String str2) {
        boolean z16;
        String str3;
        boolean contains$default;
        int lastIndexOf$default;
        JsonObject jsonObject;
        InputSource inputSource;
        JsonElement jsonElement;
        LightAssetDataContext d16 = com.tencent.videocut.render.utils.b.f384205a.d(str2);
        if (d16 == null) {
            return null;
        }
        JsonObject inputSources = d16.getInputSources();
        boolean z17 = true;
        if (inputSources != null && inputSources.has(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (inputSources != null && (jsonElement = inputSources.get(str)) != null) {
                jsonObject = jsonElement.getAsJsonObject();
            } else {
                jsonObject = null;
            }
            Gson create = new GsonBuilder().create();
            if (create != null) {
                inputSource = (InputSource) create.fromJson(String.valueOf(jsonObject), InputSource.class);
            } else {
                inputSource = null;
            }
            if (inputSource != null) {
                str3 = inputSource.getPath();
                if (str3 != null && str3.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    return null;
                }
                Intrinsics.checkNotNull(str3);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "/", false, 2, (Object) null);
                if (!contains$default) {
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str2, '/', 0, false, 6, (Object) null);
                    String substring = str2.substring(0, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    return substring + "/" + str3;
                }
                return str3;
            }
        }
        str3 = null;
        if (str3 != null) {
            z17 = false;
        }
        if (!z17) {
        }
    }

    @NotNull
    public static final PAGScaleMode h(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        StickerModel.Type type = stickerModel.type;
        if (type != StickerModel.Type.CUSTOM && type != StickerModel.Type.MASK) {
            return PAGScaleMode.LetterBox;
        }
        return PAGScaleMode.Zoom;
    }

    @NotNull
    public static final Triple<String, Integer, String> i(@NotNull StickerModel stickerModel) {
        List split$default;
        Object orNull;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        split$default = StringsKt__StringsKt.split$default((CharSequence) stickerModel.id, new String[]{"_____~~_____"}, false, 0, 6, (Object) null);
        try {
            String str = (String) split$default.get(0);
            try {
                int parseInt = Integer.parseInt((String) split$default.get(1));
                orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 2);
                return new Triple<>(str, Integer.valueOf(parseInt), (String) orNull);
            } catch (Exception e16) {
                throw new IllegalArgumentException("invalid template text sticker: " + stickerModel, e16);
            }
        } catch (Exception e17) {
            throw new IllegalArgumentException("invalid template text sticker: " + stickerModel, e17);
        }
    }

    @NotNull
    public static final StickerRenderHelper.STICKER_TYPE j(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        switch (a.f384137a[stickerModel.type.ordinal()]) {
            case 1:
                return StickerRenderHelper.STICKER_TYPE.MOSAIC;
            case 2:
                return StickerRenderHelper.STICKER_TYPE.MOSAIC_DOODLE;
            case 3:
                return StickerRenderHelper.STICKER_TYPE.DIY;
            case 4:
                return StickerRenderHelper.STICKER_TYPE.TEXT;
            case 5:
                return StickerRenderHelper.STICKER_TYPE.TEXT_TEMPLATE;
            case 6:
                return StickerRenderHelper.STICKER_TYPE.TEXT_BACKGROUND_TEMPLATE;
            default:
                return StickerRenderHelper.STICKER_TYPE.NORMAL;
        }
    }

    public static final boolean k(@NotNull Component component, boolean z16, @NotNull ICutSession iCutSession) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        if (iCutSession.componentSupportDynamicModify(component) && !z16) {
            return false;
        }
        return true;
    }

    public static final boolean l(@Nullable TextItem textItem, @Nullable TextItem textItem2) {
        boolean z16;
        if (textItem == null || textItem2 == null || !Intrinsics.areEqual(textItem.text, textItem2.text) || !Intrinsics.areEqual(textItem.fauxBold, textItem2.fauxBold) || !Intrinsics.areEqual(textItem.fauxItalic, textItem2.fauxItalic) || !Intrinsics.areEqual(textItem.fontFamily, textItem2.fontFamily) || !Intrinsics.areEqual(textItem.fontStyle, textItem2.fontStyle) || !Intrinsics.areEqual(textItem.applyStroke, textItem2.applyStroke)) {
            return false;
        }
        if (textItem.strokeWidth == textItem2.strokeWidth) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !Intrinsics.areEqual(textItem.strokeColor, textItem2.strokeColor) || !Intrinsics.areEqual(textItem.leading, textItem2.leading) || !Intrinsics.areEqual(textItem.tracking, textItem2.tracking) || !Intrinsics.areEqual(textItem.backgroundColor, textItem2.backgroundColor) || textItem.backgroundAlpha != textItem2.backgroundAlpha || !Intrinsics.areEqual(textItem.textColor, textItem2.textColor) || !Intrinsics.areEqual(textItem.justification, textItem2.justification)) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final BackgroundTextRenderHelper.b m(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Triple<String, Integer, String> i3 = i(stickerModel);
        return new BackgroundTextRenderHelper.b(p(stickerModel, i3.component3()), i3.component2().intValue(), stickerModel);
    }

    @NotNull
    public static final ReplaceItem n(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        ReplaceItem replaceItem = new ReplaceItem();
        replaceItem.index = 0;
        replaceItem.replaceType = ReplaceType.Image;
        replaceItem.src = c(stickerModel.bgPath);
        replaceItem.sourceIndex = 0;
        replaceItem.scaleMode = ScaleMode.LetterBox;
        return replaceItem;
    }

    @NotNull
    public static final Entity o(@NotNull StickerModel stickerModel, @Nullable InputSource inputSource) {
        String str;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (inputSource != null) {
            str = inputSource.getKey();
        } else {
            str = null;
        }
        return p(stickerModel, str);
    }

    @NotNull
    public static final Entity p(@NotNull StickerModel stickerModel, @Nullable String str) {
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        int i16;
        PAGAsset k3;
        List<ImageLayerData> imageLayerList;
        String str6;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        rd4.c cVar = rd4.c.f431135f;
        td4.e o16 = cVar.o();
        List<ReplaceItem> u16 = u(stickerModel.textItems);
        ReplaceItem q16 = q(stickerModel);
        if (q16 != null) {
            u16 = b.a(u16, q16);
        }
        StickerModel.Type type = stickerModel.type;
        StickerModel.Type type2 = StickerModel.Type.MASK;
        if (type == type2) {
            u16 = CollectionsKt__CollectionsKt.mutableListOf(s());
        } else if (type == StickerModel.Type.CUSTOM) {
            u16 = b.a(u16, n(stickerModel));
        }
        String str7 = stickerModel.filePath;
        if (str7 == null) {
            str7 = "";
        }
        PagEffectData A = cVar.A(str7);
        ArrayList arrayList = new ArrayList();
        w53.b.a("wink_sticker", "StickerModel.toEntity anchorPointX:" + stickerModel.centerX + ", anchorPointY:" + stickerModel.centerY + ", width:" + stickerModel.width + ", height:" + stickerModel.height + ", scaleX:" + stickerModel.scaleX + ", scaleY:" + stickerModel.scaleY + ", rotate:" + stickerModel.rotate + " ");
        StickerModel.Type type3 = stickerModel.type;
        if (type3 != StickerModel.Type.DEFAULT && type3 != StickerModel.Type.MOSAIC_DOODLE) {
            if (!u16.isEmpty()) {
                if (str == null) {
                    str6 = "";
                } else {
                    str6 = str;
                }
                k3 = o16.i(str6, u16, h(stickerModel));
            } else {
                if (A != null && (imageLayerList = A.getImageLayerList()) != null) {
                    i3 = imageLayerList.size();
                } else {
                    i3 = 1;
                }
                if (str == null) {
                    str5 = "";
                } else {
                    str5 = str;
                }
                if (stickerModel.type == type2) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                k3 = o16.k(str5, h(stickerModel), 0, i16, i3);
            }
            arrayList.add(k3);
        } else {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            arrayList.add(o16.l(str2, stickerModel.duration, h(stickerModel)));
        }
        arrayList.add(o16.e(stickerModel.startTime, stickerModel.duration));
        td4.f q17 = cVar.q();
        StickerModel.Type type4 = stickerModel.type;
        if (type4 != StickerModel.Type.TEXT_TEMPLATE && type4 != StickerModel.Type.IMAGE_TEMPLATE && type4 != StickerModel.Type.TEXT_BACKGROUND_TEMPLATE) {
            str3 = "sticker" + stickerModel.id;
        } else {
            str3 = stickerModel.id;
        }
        Entity a16 = q17.a(str3, arrayList);
        Collection<Component> components = a16.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "entity.components");
        for (Component component : components) {
            if (component instanceof ScreenTransform) {
                ScreenTransform screenTransform = (ScreenTransform) component;
                if (stickerModel.type == StickerModel.Type.MASK) {
                    int i17 = stickerModel.height;
                    float f16 = stickerModel.scaleY;
                    float f17 = 2;
                    int i18 = stickerModel.width;
                    float f18 = stickerModel.scaleX;
                    screenTransform.setOffset(new Rect(((-i17) * f16) / f17, ((-i18) * f18) / f17, (i18 * f18) / f17, (i17 * f16) / f17));
                    screenTransform.setScale(new Vec3(1.0f, 1.0f, 1.0f));
                    float f19 = stickerModel.centerY;
                    float f26 = stickerModel.centerX;
                    screenTransform.setAnchor(new Rect(f19, f26, f26, f19));
                } else {
                    int i19 = stickerModel.height;
                    float f27 = 2;
                    int i26 = stickerModel.width;
                    screenTransform.setOffset(new Rect((-i19) / f27, (-i26) / f27, i26 / f27, i19 / f27));
                    float f28 = stickerModel.scaleX;
                    screenTransform.setScale(new Vec3(f28, f28, 1.0f));
                    float f29 = stickerModel.centerY;
                    float f36 = stickerModel.centerX;
                    screenTransform.setAnchor(new Rect(f29, f36, f36, f29));
                }
                screenTransform.setRotation(com.tencent.tavcut.core.utils.b.f374339a.d(stickerModel.rotate));
            } else if (component instanceof EntityIdentifier) {
                EntityIdentifier entityIdentifier = (EntityIdentifier) component;
                int i27 = a.f384137a[stickerModel.type.ordinal()];
                if (i27 != 1) {
                    if (i27 != 2) {
                        str4 = "sticker";
                    } else {
                        str4 = "mosaic_doodlesticker";
                    }
                } else {
                    str4 = "mosaic_sticker";
                }
                entityIdentifier.setName(str4);
            }
        }
        return a16;
    }

    @NotNull
    public static final ReplaceItem q(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        ReplaceItem replaceItem = new ReplaceItem();
        replaceItem.index = 0;
        replaceItem.replaceType = ReplaceType.Image;
        replaceItem.src = c(stickerModel.bgPath);
        replaceItem.sourceIndex = 0;
        replaceItem.scaleMode = ScaleMode.LetterBox;
        return replaceItem;
    }

    private static final StickerRenderHelper.b r(StickerModel stickerModel, String str, ICutSession iCutSession) {
        String str2;
        ms.a.a("wink_sticker", "StickerModel.toLakFragmentRenderData");
        com.tencent.videocut.render.utils.c cVar = com.tencent.videocut.render.utils.c.f384212a;
        Triple<Entity, List<InputSource>, LightAsset> g16 = cVar.g(str, iCutSession);
        Entity first = g16.getFirst();
        if (first == null) {
            first = new Entity();
        }
        Entity entity = first;
        boolean j3 = j73.a.f409615a.j(str, g16.getThird());
        if (j3) {
            str2 = "ai_fragment_sticker";
        } else {
            str2 = "sticker";
        }
        String str3 = str2;
        Entity e16 = cVar.e(entity);
        if (e16 != null) {
            ms.a.a("wink_sticker", "watermarkModel isNotEmpty " + (!stickerModel.watermarkModel.isEmpty()));
            if (!stickerModel.watermarkModel.isEmpty()) {
                a(stickerModel.watermarkModel, entity);
            } else {
                PAGAsset pAGAsset = (PAGAsset) e16.getComponent(PAGAsset.class);
                if (pAGAsset != null) {
                    Intrinsics.checkNotNullExpressionValue(pAGAsset, "getComponent(PAGAsset::class.java)");
                    ArrayList<ReplaceItem> arrayList = new ArrayList<>();
                    arrayList.addAll(u(stickerModel.textItems));
                    pAGAsset.setReplacement(arrayList);
                }
            }
            com.tencent.videocut.render.utils.d.f384214a.g(stickerModel, (ScreenTransform) e16.getComponent(ScreenTransform.class));
        }
        com.tencent.videocut.render.utils.d.f384214a.d(entity, stickerModel.animationMode, stickerModel.duration);
        return new StickerRenderHelper.b(cVar.a(entity, stickerModel.startTime, stickerModel.duration, str3), g16.getSecond(), null, j(stickerModel), j3, 4, null);
    }

    @NotNull
    public static final ReplaceItem s() {
        ReplaceItem replaceItem = new ReplaceItem();
        replaceItem.index = 0;
        replaceItem.replaceType = ReplaceType.FilterReplacement;
        replaceItem.src = "";
        replaceItem.sourceIndex = -1;
        replaceItem.scaleMode = ScaleMode.LetterBox;
        return replaceItem;
    }

    private static final StickerRenderHelper.b t(StickerModel stickerModel) {
        int i3;
        InputSource d16;
        List listOf;
        w53.b.a("wink_sticker", "StickerModel.toPagRenderData");
        td4.g r16 = rd4.c.f431135f.r();
        if (a.f384139c[stickerModel.animationMode.ordinal()] == 1) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        int i16 = i3;
        TimeStretchMode y16 = y(stickerModel.animationMode);
        int i17 = a.f384140d[stickerModel.imageType.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        d16 = null;
                    } else {
                        d16 = g.a.a(r16, stickerModel.id, i16, stickerModel.filePath, null, 8, null);
                    }
                } else {
                    d16 = g.a.c(r16, stickerModel.id, i16, stickerModel.filePath, null, 8, null);
                }
            } else {
                d16 = r16.g(stickerModel.filePath, i16, stickerModel.id, y16);
            }
        } else {
            d16 = g.a.d(r16, stickerModel.id, stickerModel.filePath, null, 4, null);
        }
        Entity o16 = o(stickerModel, d16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(d16);
        return new StickerRenderHelper.b(o16, listOf, null, j(stickerModel), false, 20, null);
    }

    @NotNull
    public static final List<ReplaceItem> u(@NotNull List<TextItem> list) {
        int collectionSizeOrDefault;
        float f16;
        int i3;
        List<ReplaceItem> emptyList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<TextItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TextItem textItem : list2) {
            ReplaceItem replaceItem = new ReplaceItem();
            replaceItem.index = textItem.index;
            replaceItem.replaceType = ReplaceType.Text;
            replaceItem.src = textItem.text;
            TextReplaceItem textReplaceItem = new TextReplaceItem();
            Boolean bool = textItem.fauxBold;
            Boolean bool2 = Boolean.TRUE;
            textReplaceItem.fauxBold = Intrinsics.areEqual(bool, bool2);
            textReplaceItem.fauxItalic = Intrinsics.areEqual(textItem.fauxItalic, bool2);
            textReplaceItem.fontFamily = textItem.fontFamily;
            textReplaceItem.fontStyle = textItem.fontStyle;
            textReplaceItem.applyStroke = Intrinsics.areEqual(textItem.applyStroke, bool2);
            textReplaceItem.strokeWidth = textItem.strokeWidth;
            com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
            textReplaceItem.strokeColor = dVar.a(textItem.strokeColor);
            Float f17 = textItem.leading;
            float f18 = 0.0f;
            if (f17 != null) {
                f16 = f17.floatValue();
            } else {
                f16 = 0.0f;
            }
            textReplaceItem.leading = f16;
            Float f19 = textItem.tracking;
            if (f19 != null) {
                f18 = f19.floatValue();
            }
            textReplaceItem.tracking = f18;
            textReplaceItem.backgroundColor = dVar.a(textItem.backgroundColor);
            textReplaceItem.backgroundAlpha = textItem.backgroundAlpha;
            textReplaceItem.textColor = dVar.a(textItem.textColor);
            Integer num = textItem.justification;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            textReplaceItem.justification = i3;
            replaceItem.textReplaceItem = textReplaceItem;
            replaceItem.interactive = true;
            arrayList.add(replaceItem);
        }
        return arrayList;
    }

    @NotNull
    public static final StickerRenderHelper.b v(@NotNull StickerModel stickerModel, @Nullable ICutSession iCutSession) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (com.tencent.mobileqq.wink.editor.sticker.e.d(stickerModel)) {
            String c16 = com.tencent.mobileqq.wink.editor.sticker.e.c(stickerModel);
            Intrinsics.checkNotNull(c16);
            return r(stickerModel, c16, iCutSession);
        }
        return t(stickerModel);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final WinkStickerModel w(@NotNull Entity entity, @NotNull String templatePath) {
        boolean z16;
        int i3;
        Iterator<ReplaceItem> it;
        Map mapOf;
        PagEffectData A;
        Object orNull;
        TextLayerData textLayerData;
        Integer justification;
        boolean isBlank;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        StickerModel.Builder builder = new StickerModel.Builder();
        HashMap hashMap = new HashMap();
        builder.id = "textSticker_____~~_____" + entity.getId();
        for (Component component : entity.getComponents()) {
            if (component instanceof PAGAsset) {
                PAGAsset pAGAsset = (PAGAsset) component;
                builder.id = builder.id + "_____~~_____" + pAGAsset.getSrc();
                String src = pAGAsset.getSrc();
                if (src == null) {
                    src = "";
                }
                String g16 = g(src, templatePath);
                if (g16 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(g16);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16 && (A = rd4.c.f431135f.A(g16)) != null) {
                            orNull = CollectionsKt___CollectionsKt.getOrNull(A.getTextLayerList(), 0);
                            textLayerData = (TextLayerData) orNull;
                            if (textLayerData != null && (justification = textLayerData.getJustification()) != null) {
                                i3 = justification.intValue();
                                if (g16 == null) {
                                    g16 = "";
                                }
                                builder.filePath = g16;
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList(1);
                                builder.textItems = arrayList;
                                builder.type = StickerModel.Type.IMAGE_TEMPLATE;
                                it = pAGAsset.getReplacement().iterator();
                                while (it.hasNext()) {
                                    ReplaceItem next = it.next();
                                    TextReplaceItem textReplaceItem = next.textReplaceItem;
                                    if (textReplaceItem != null && next.interactive) {
                                        TextItem.Builder builder2 = new TextItem.Builder();
                                        builder2.fauxBold = Boolean.valueOf(textReplaceItem.fauxBold);
                                        builder2.fauxItalic = Boolean.valueOf(textReplaceItem.fauxItalic);
                                        String str = textReplaceItem.fontFamily;
                                        if (str == null) {
                                            str = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str, "textReplaceItem.fontFamily ?: \"\"");
                                        }
                                        builder2.fontFamily = str;
                                        String str2 = textReplaceItem.fontStyle;
                                        if (str2 == null) {
                                            str2 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str2, "textReplaceItem.fontStyle ?: \"\"");
                                        }
                                        builder2.fontStyle = str2;
                                        builder2.applyStroke = Boolean.valueOf(textReplaceItem.applyStroke);
                                        builder2.strokeWidth = textReplaceItem.strokeWidth;
                                        com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
                                        String str3 = textReplaceItem.strokeColor;
                                        if (str3 == null) {
                                            str3 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str3, "textReplaceItem.strokeColor ?: \"\"");
                                        }
                                        builder2.strokeColor = dVar.b(str3);
                                        builder2.leading = Float.valueOf(textReplaceItem.leading);
                                        builder2.tracking = Float.valueOf(textReplaceItem.tracking);
                                        String str4 = textReplaceItem.backgroundColor;
                                        if (str4 == null) {
                                            str4 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str4, "textReplaceItem.backgroundColor ?: \"\"");
                                        }
                                        builder2.backgroundColor = dVar.b(str4);
                                        builder2.backgroundAlpha = textReplaceItem.backgroundAlpha;
                                        String str5 = textReplaceItem.textColor;
                                        if (str5 == null) {
                                            str5 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str5, "textReplaceItem.textColor ?: \"\"");
                                        }
                                        builder2.textColor = dVar.b(str5);
                                        String str6 = next.src;
                                        if (str6 == null) {
                                            str6 = "";
                                        } else {
                                            Intrinsics.checkNotNullExpressionValue(str6, "replacement.src ?: \"\"");
                                        }
                                        builder2.text = str6;
                                        builder2.index = next.index;
                                        builder2.justification = Integer.valueOf(i3);
                                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("textMaxLength", Integer.valueOf(next.textMaxLength)));
                                        arrayList2.add(mapOf);
                                        arrayList.add(builder2.build());
                                        if (next.replaceType == ReplaceType.Text) {
                                            builder.type = StickerModel.Type.TEXT_TEMPLATE;
                                        }
                                    }
                                }
                                hashMap.put("PAGAsset", arrayList2);
                            }
                        }
                        i3 = 1;
                        if (g16 == null) {
                        }
                        builder.filePath = g16;
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList22 = new ArrayList(1);
                        builder.textItems = arrayList3;
                        builder.type = StickerModel.Type.IMAGE_TEMPLATE;
                        it = pAGAsset.getReplacement().iterator();
                        while (it.hasNext()) {
                        }
                        hashMap.put("PAGAsset", arrayList22);
                    }
                }
                z16 = true;
                if (!z16) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(A.getTextLayerList(), 0);
                    textLayerData = (TextLayerData) orNull;
                    if (textLayerData != null) {
                        i3 = justification.intValue();
                        if (g16 == null) {
                        }
                        builder.filePath = g16;
                        ArrayList arrayList32 = new ArrayList();
                        ArrayList arrayList222 = new ArrayList(1);
                        builder.textItems = arrayList32;
                        builder.type = StickerModel.Type.IMAGE_TEMPLATE;
                        it = pAGAsset.getReplacement().iterator();
                        while (it.hasNext()) {
                        }
                        hashMap.put("PAGAsset", arrayList222);
                    }
                }
                i3 = 1;
                if (g16 == null) {
                }
                builder.filePath = g16;
                ArrayList arrayList322 = new ArrayList();
                ArrayList arrayList2222 = new ArrayList(1);
                builder.textItems = arrayList322;
                builder.type = StickerModel.Type.IMAGE_TEMPLATE;
                it = pAGAsset.getReplacement().iterator();
                while (it.hasNext()) {
                }
                hashMap.put("PAGAsset", arrayList2222);
            } else if (component instanceof ScreenTransform) {
                ScreenTransform screenTransform = (ScreenTransform) component;
                Rect anchor = screenTransform.getAnchor();
                float f27 = 0.0f;
                if (anchor != null) {
                    f16 = anchor.left;
                } else {
                    f16 = 0.0f;
                }
                builder.centerX = f16;
                Rect anchor2 = screenTransform.getAnchor();
                if (anchor2 != null) {
                    f17 = anchor2.top;
                } else {
                    f17 = 0.0f;
                }
                builder.centerY = f17;
                Rect offset = screenTransform.getOffset();
                if (offset != null) {
                    f18 = offset.left;
                } else {
                    f18 = 0.0f;
                }
                float f28 = 2;
                builder.width = (int) (-(f18 * f28));
                Rect offset2 = screenTransform.getOffset();
                if (offset2 != null) {
                    f19 = offset2.top;
                } else {
                    f19 = 0.0f;
                }
                builder.height = (int) (f19 * f28);
                Vec3 scale = screenTransform.getScale();
                if (scale != null) {
                    f26 = scale.f423832x;
                } else {
                    f26 = 0.0f;
                }
                builder.scaleX = f26;
                Vec3 scale2 = screenTransform.getScale();
                if (scale2 != null) {
                    f27 = scale2.f423833y;
                }
                builder.scaleY = f27;
                builder.rotate = g.a(screenTransform);
            } else if (!(component instanceof EntityIdentifier) && (component instanceof TimeOffset)) {
                TimeOffset timeOffset = (TimeOffset) component;
                builder.startTime = timeOffset.getStartOffset();
                builder.duration = timeOffset.getDuration();
            }
        }
        return l.O(builder.build(), builder.filePath, hashMap);
    }

    @NotNull
    public static final TemplateTextRenderHelper.b x(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Triple<String, Integer, String> i3 = i(stickerModel);
        return new TemplateTextRenderHelper.b(p(stickerModel, i3.component3()), i3.component2().intValue(), stickerModel);
    }

    @NotNull
    public static final TimeStretchMode y(@NotNull AnimationMode animationMode) {
        Intrinsics.checkNotNullParameter(animationMode, "<this>");
        int i3 = a.f384139c[animationMode.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return TimeStretchMode.REPEAT;
                }
                return TimeStretchMode.SCALE;
            }
            return TimeStretchMode.SCALE;
        }
        return TimeStretchMode.NONE;
    }

    public static final boolean z(@NotNull StickerModel stickerModel, @Nullable StickerModel stickerModel2, @NotNull Entity needUpdateEntity, @NotNull ICutSession iCutSession) {
        boolean z16;
        boolean z17;
        int i3;
        TextItem f16;
        float f17;
        int i16;
        List<TextItem> list;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Intrinsics.checkNotNullParameter(needUpdateEntity, "needUpdateEntity");
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        w53.b.a("wink_sticker", "updateEntity centerX:" + stickerModel.centerX + ", centerY:" + stickerModel.centerY + ", " + stickerModel.rotate + ", " + stickerModel.scaleX + ", " + stickerModel.scaleY);
        if (stickerModel2 != null) {
            z16 = com.tencent.mobileqq.wink.editor.sticker.e.d(stickerModel2);
        } else {
            z16 = false;
        }
        Collection<Component> components = needUpdateEntity.getComponents();
        if (components != null) {
            boolean z18 = false;
            for (Component it : components) {
                if (it instanceof ScreenTransform) {
                    if (!z16) {
                        com.tencent.videocut.render.utils.d dVar = com.tencent.videocut.render.utils.d.f384214a;
                        if (dVar.b(stickerModel, stickerModel2)) {
                            dVar.g(stickerModel, (ScreenTransform) it);
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            z18 = k(it, z18, iCutSession);
                        }
                    }
                } else if (it instanceof TimeOffset) {
                    com.tencent.videocut.render.utils.d dVar2 = com.tencent.videocut.render.utils.d.f384214a;
                    if (dVar2.c(stickerModel, stickerModel2)) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        dVar2.h(stickerModel, (TimeOffset) it);
                        z18 = k(it, z18, iCutSession);
                    }
                } else {
                    boolean z19 = true;
                    if (it instanceof Image) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        Image image = (Image) it;
                        if (stickerModel2 == null || stickerModel.duration != stickerModel2.duration) {
                            z19 = false;
                        }
                        if (!z19) {
                            image.setDuration(stickerModel.duration);
                            z18 = k(image, z18, iCutSession);
                        }
                    } else if (it instanceof PAGAsset) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        PAGAsset pAGAsset = (PAGAsset) it;
                        ArrayList<ReplaceItem> replacement = pAGAsset.getReplacement();
                        Intrinsics.checkNotNullExpressionValue(replacement, "replacement");
                        boolean z26 = false;
                        for (ReplaceItem replaceItem : replacement) {
                            ReplaceType replaceType = replaceItem.replaceType;
                            if (replaceType == null) {
                                i3 = -1;
                            } else {
                                i3 = a.f384138b[replaceType.ordinal()];
                            }
                            TextItem textItem = null;
                            String str = null;
                            textItem = null;
                            if (i3 != 1) {
                                if (i3 == 2 && (f16 = f(stickerModel.textItems, replaceItem.index)) != null) {
                                    if (stickerModel2 != null && (list = stickerModel2.textItems) != null) {
                                        textItem = f(list, replaceItem.index);
                                    }
                                    if (!l(f16, textItem)) {
                                        replaceItem.src = f16.text;
                                        TextReplaceItem textReplaceItem = replaceItem.textReplaceItem;
                                        Boolean bool = f16.fauxBold;
                                        Boolean bool2 = Boolean.TRUE;
                                        textReplaceItem.fauxBold = Intrinsics.areEqual(bool, bool2);
                                        textReplaceItem.fauxItalic = Intrinsics.areEqual(f16.fauxItalic, bool2);
                                        textReplaceItem.fontFamily = f16.fontFamily;
                                        textReplaceItem.fontStyle = f16.fontStyle;
                                        textReplaceItem.applyStroke = Intrinsics.areEqual(f16.applyStroke, bool2);
                                        textReplaceItem.strokeWidth = f16.strokeWidth;
                                        com.tencent.videocut.utils.d dVar3 = com.tencent.videocut.utils.d.f384234a;
                                        textReplaceItem.strokeColor = dVar3.a(f16.strokeColor);
                                        Float f18 = f16.leading;
                                        float f19 = 0.0f;
                                        if (f18 != null) {
                                            f17 = f18.floatValue();
                                        } else {
                                            f17 = 0.0f;
                                        }
                                        textReplaceItem.leading = f17;
                                        Float f26 = f16.tracking;
                                        if (f26 != null) {
                                            f19 = f26.floatValue();
                                        }
                                        textReplaceItem.tracking = f19;
                                        textReplaceItem.backgroundColor = dVar3.a(f16.backgroundColor);
                                        textReplaceItem.backgroundAlpha = f16.backgroundAlpha;
                                        textReplaceItem.textColor = dVar3.a(f16.textColor);
                                        Integer num = f16.justification;
                                        if (num != null) {
                                            i16 = num.intValue();
                                        } else {
                                            i16 = 0;
                                        }
                                        textReplaceItem.justification = i16;
                                        z26 = true;
                                    }
                                }
                            } else {
                                String str2 = stickerModel.bgPath;
                                if (stickerModel2 != null) {
                                    str = stickerModel2.bgPath;
                                }
                                if (!Intrinsics.areEqual(str2, str)) {
                                    replaceItem.src = c(stickerModel.bgPath);
                                    z26 = true;
                                }
                            }
                        }
                        pAGAsset.setReplacement(replacement);
                        if (z26) {
                            z18 = true;
                        }
                    }
                }
            }
            z17 = z18;
        } else {
            z17 = false;
        }
        if (z16) {
            com.tencent.videocut.render.utils.d.f384214a.f(stickerModel, needUpdateEntity, stickerModel2);
        }
        return z17;
    }
}
