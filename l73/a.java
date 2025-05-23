package l73;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.render.utils.c;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightAsset;
import org.light.datasource.LightBaseDataSourceDescription;
import org.light.datasource.LightDataSource;
import org.light.datasource.LightFormatDesc;
import org.light.datasource.LightWatermarkDataSourceDescription;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.LightAssetFragment;
import tl.h;
import y53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J$\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\rj\b\u0012\u0004\u0012\u00020\u000b`\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J4\u0010\u0013\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bJ\u0014\u0010&\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\nR \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010(R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00020+j\b\u0012\u0004\u0012\u00020\u0002`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010-\u00a8\u00061"}, d2 = {"Ll73/a;", "", "", "dirPath", "Lkotlin/Triple;", "", h.F, "jsonPath", "Lkotlin/Pair;", DomainData.DOMAIN_NAME, "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materialList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "", "a", WadlProxyConsts.KEY_MATERIAL, "o", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", "g", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tavcut/core/session/ICutSession;", "cutSession", "p", "k", "f", "i", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "j", "d", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategoryList", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "effectVideoMinDurationCache", "lightAssetFragmentCache", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "reloadedAgentTypes", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f413927a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Long> effectVideoMinDurationCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> lightAssetFragmentCache = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<String> reloadedAgentTypes = new HashSet<>();

    a() {
    }

    private final ArrayList<MetaMaterial> b(List<MetaMaterial> materialList) {
        ArrayList<MetaMaterial> arrayList = new ArrayList<>();
        Iterator<T> it = materialList.iterator();
        while (it.hasNext()) {
            arrayList.add(b.b((MetaMaterial) it.next()));
        }
        return arrayList;
    }

    private final Triple<String, String, Integer> h(String dirPath) {
        Pair<String, Integer> n3 = n(i(dirPath));
        if (n3 == null) {
            return null;
        }
        String component1 = n3.component1();
        int intValue = n3.component2().intValue();
        String str = dirPath + File.separator + component1 + ".pag";
        if (!new File(str).exists()) {
            return null;
        }
        return new Triple<>(str, component1, Integer.valueOf(intValue));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r1 != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<String, Integer> n(String jsonPath) {
        String str;
        String str2;
        int i3;
        boolean isBlank;
        JSONObject jSONObject;
        File file = new File(jsonPath);
        if (!file.exists()) {
            return null;
        }
        String readFileContent = FileUtils.readFileContent(file);
        if (TextUtils.isEmpty(readFileContent)) {
            return null;
        }
        boolean z16 = false;
        try {
            JSONObject jSONObject2 = new JSONObject(readFileContent);
            if (jSONObject2.has("effectId")) {
                str2 = jSONObject2.getString("effectId");
            } else {
                str2 = null;
            }
            try {
                if (jSONObject2.has("effectParams")) {
                    jSONObject = jSONObject2.getJSONObject("effectParams");
                } else {
                    jSONObject = null;
                }
            } catch (Throwable th5) {
                str = str2;
                th = th5;
                th.printStackTrace();
                str2 = str;
                i3 = 0;
                if (str2 != null) {
                }
                z16 = true;
                if (z16) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            str = null;
        }
        if (jSONObject != null && jSONObject.has(HippyQQPagViewController.PropertyName.SCALE_MODE)) {
            i3 = jSONObject.getInt(HippyQQPagViewController.PropertyName.SCALE_MODE);
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            }
            z16 = true;
            if (z16) {
                return null;
            }
            return TuplesKt.to(str2, Integer.valueOf(i3));
        }
        i3 = 0;
        if (str2 != null) {
        }
        z16 = true;
        if (z16) {
        }
    }

    public final void a() {
        effectVideoMinDurationCache.clear();
        lightAssetFragmentCache.clear();
        reloadedAgentTypes.clear();
    }

    public final void c(@NotNull List<MetaCategory> metaCategoryList) {
        Intrinsics.checkNotNullParameter(metaCategoryList, "metaCategoryList");
        for (MetaCategory metaCategory : metaCategoryList) {
            a aVar = f413927a;
            ArrayList<MetaMaterial> arrayList = metaCategory.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList, "metaCategory.materials");
            metaCategory.materials = aVar.b(arrayList);
        }
    }

    public final void d(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (!new File(m.y(material)).exists()) {
            String m3 = WinkEditorResourceManager.a1().m(material);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
            LightAsset c16 = com.tencent.videocut.render.utils.b.f384205a.c(f(m3));
            if (c16 != null) {
                String mainPagFilePath = c16.getMainPagFilePath();
                if (mainPagFilePath == null) {
                    mainPagFilePath = m.y(material);
                } else {
                    Intrinsics.checkNotNullExpressionValue(mainPagFilePath, "lightAsset.mainPagFilePath ?: material.pagFilePath");
                }
                m.F0(material, mainPagFilePath);
            }
        }
    }

    public final long e(@NotNull MetaMaterial material, long defaultValue) {
        long j3;
        Entity h16;
        Collection<Component> components;
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        Long l3 = effectVideoMinDurationCache.get(m3);
        if (l3 != null) {
            j3 = l3.longValue();
        } else if (k(m3) && (h16 = c.f384212a.h(m3)) != null && (components = h16.getComponents()) != null) {
            j3 = 0;
            for (Component component : components) {
                if (component instanceof LightAssetFragment) {
                    j3 = ((LightAssetFragment) component).getDefaultDuration();
                    effectVideoMinDurationCache.put(m3, Long.valueOf(j3));
                }
            }
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return j3;
        }
        return defaultValue;
    }

    @NotNull
    public final String f(@NotNull String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        return dirPath + File.separator + TemplateBean.TEMPLATE_JSON;
    }

    @Nullable
    public final List<String> g(@NotNull String dirPath) {
        File[] listFiles;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        File file = new File(dirPath);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "_file.name");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, ".pag", false, 2, null);
                if (endsWith$default) {
                    arrayList.add(file2.getPath());
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final String i(@NotNull String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        return dirPath + File.separator + "effect.json";
    }

    @NotNull
    public final List<WatermarkDataSourceModel> j(@NotNull MetaMaterial material) {
        List<WatermarkDataSourceModel> emptyList;
        LightDataSource[] allDataSource;
        boolean z16;
        boolean z17;
        List<? extends WatermarkDataSourceModel.MenuType> list;
        LightFormatDesc[] watermarkFormats;
        boolean contains$default;
        boolean contains$default2;
        WatermarkDataSourceModel.MenuType menuType;
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        if (!m(m3)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        LightAsset c16 = com.tencent.videocut.render.utils.b.f384205a.c(f(m3));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (c16 != null && (allDataSource = c16.getAllDataSource()) != null) {
            for (LightDataSource lightDataSource : allDataSource) {
                WatermarkDataSourceModel.Builder builder = (WatermarkDataSourceModel.Builder) linkedHashMap.get(lightDataSource.getDataKey());
                if (builder == null) {
                    builder = new WatermarkDataSourceModel.Builder();
                    String dataKey = lightDataSource.getDataKey();
                    Intrinsics.checkNotNullExpressionValue(dataKey, "lightDataSource.dataKey");
                    linkedHashMap.put(dataKey, builder);
                }
                if (!builder.entityIdList.contains(Long.valueOf(lightDataSource.getEntityId()))) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(builder.entityIdList);
                    arrayList2.add(Long.valueOf(lightDataSource.getEntityId()));
                    builder.entityIdList = arrayList2;
                }
                String dataKey2 = lightDataSource.getDataKey();
                if (dataKey2 == null) {
                    dataKey2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dataKey2, "lightDataSource?.dataKey ?: \"\"");
                }
                builder.dataKey = dataKey2;
                LightBaseDataSourceDescription desc = lightDataSource.getDesc();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll(builder.menuTypeList);
                if ((desc instanceof LightWatermarkDataSourceDescription) && (watermarkFormats = ((LightWatermarkDataSourceDescription) desc).getWatermarkFormats()) != null) {
                    Intrinsics.checkNotNullExpressionValue(watermarkFormats, "watermarkFormats");
                    z16 = false;
                    for (LightFormatDesc lightFormatDesc : watermarkFormats) {
                        if (Intrinsics.areEqual(lightFormatDesc.fromType, "custom")) {
                            z16 = true;
                        }
                        String str = lightFormatDesc.format;
                        Intrinsics.checkNotNullExpressionValue(str, "getWatermarkDataSourceLi\u2026ambda$8$lambda$7$lambda$6");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "location", false, 2, (Object) null);
                        if (!contains$default) {
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "date", false, 2, (Object) null);
                            if (contains$default2) {
                                menuType = WatermarkDataSourceModel.MenuType.DATE_TIME;
                            } else {
                                menuType = WatermarkDataSourceModel.MenuType.NONE;
                            }
                        } else {
                            menuType = WatermarkDataSourceModel.MenuType.LOCATION;
                        }
                        if (menuType != WatermarkDataSourceModel.MenuType.NONE) {
                            linkedHashSet.add(menuType);
                        }
                    }
                } else {
                    z16 = false;
                }
                if (!builder.isEditable && !z16) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                builder.isEditable = z17;
                list = CollectionsKt___CollectionsKt.toList(linkedHashSet);
                builder.menuTypeList = list;
            }
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((WatermarkDataSourceModel.Builder) it.next()).build());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(@Nullable String dirPath) {
        boolean z16;
        boolean isBlank;
        if (dirPath != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(dirPath);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                return new File(f(dirPath)).exists();
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final boolean l(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        return m(m3);
    }

    public final boolean m(@Nullable String dirPath) {
        LightAsset c16;
        if (dirPath != null) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = lightAssetFragmentCache;
            Boolean bool = concurrentHashMap.get(dirPath);
            if (bool != null) {
                return bool.booleanValue();
            }
            if (k(dirPath) && (c16 = com.tencent.videocut.render.utils.b.f384205a.c(f(dirPath))) != null) {
                boolean isFragment = c16.isFragment();
                concurrentHashMap.put(dirPath, Boolean.valueOf(isFragment));
                return isFragment;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public final Pair<List<String>, Triple<String, String, Integer>> o(@NotNull MetaMaterial material) {
        List<String> g16;
        List listOf;
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        if (m(m3)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(m3);
            return new Pair<>(listOf, new Triple(m3, "", 0));
        }
        com.tencent.mobileqq.wink.editor.c.z1(material, MaterialType.PAG);
        Triple<String, String, Integer> h16 = h(m3);
        if (h16 != null && (g16 = g(m3)) != null) {
            return new Pair<>(g16, h16);
        }
        return null;
    }

    public final void p(@Nullable String dirPath, @NotNull ICutSession cutSession) {
        LightAsset c16;
        Intrinsics.checkNotNullParameter(cutSession, "cutSession");
        if (dirPath != null && (c16 = com.tencent.videocut.render.utils.b.f384205a.c(f(dirPath))) != null) {
            String[] renderAgentTypes = c16.getRenderAgentTypes();
            if (renderAgentTypes == null) {
                renderAgentTypes = new String[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : renderAgentTypes) {
                if (!reloadedAgentTypes.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                cutSession.notifyReloadAsset();
                reloadedAgentTypes.addAll(arrayList);
            }
        }
    }
}
