package com.tencent.mobileqq.wink.reddot.material;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.reddot.RedDotRecord;
import com.tencent.mobileqq.wink.reddot.RedDotRecordCache;
import com.tencent.mobileqq.wink.reddot.a;
import com.tencent.mobileqq.wink.utils.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u53.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00013B\u0007\u00a2\u0006\u0004\b>\u0010?J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00120\u0012H\u0002J\u0010\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004H\u0002J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0002J&\u0010&\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0002J\u001e\u0010(\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010'\u001a\u00020\bH\u0002J\u001a\u0010*\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u000eH\u0002J\u001a\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u000eH\u0002J\u001a\u0010,\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u00102\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u00101\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400\u0012\u0004\u0012\u00020\n0/H\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\u0016\u00106\u001a\u00020\n2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000200H\u0016R0\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001307j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00109R0\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001307j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00109R0\u0010=\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/material/MaterialRedDotHandler;", "Lcom/tencent/mobileqq/wink/reddot/a;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "id", "", "list", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "", ReportConstant.COSTREPORT_PREFIX, "categoryId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "newVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "", "Lcom/tencent/mobileqq/wink/reddot/RedDotRecord;", "t", "kotlin.jvm.PlatformType", h.F, "", "Lcom/tencent/mobileqq/wink/reddot/RedDotRecordCache;", "map", "v", "", TtmlNode.ATTR_TTS_ORIGIN, "target", "o", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/reddot/material/MaterialRedDotInfo;", "info", "l", "category", "needRemoveCategoryRecord", "childrens", "j", "needRemoveEntracnceRecord", "k", "version", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "i", "r", "Lkotlin/Function1;", "", "action", "b", "a", "c", IVideoFilterTools.CATEGORYS, "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "redDotMap", "lastClickRecord", "Ljava/util/Map;", "oldDate", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MaterialRedDotHandler implements a<MetaCategory, MetaMaterial> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, RedDotRecord> redDotMap = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, RedDotRecord> lastClickRecord = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, ? extends Map<String, RedDotRecord>> oldDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/reddot/material/MaterialRedDotHandler$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/reddot/RedDotRecordCache;", "Lkotlin/collections/ArrayList;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends TypeToken<ArrayList<RedDotRecordCache>> {
        b() {
        }
    }

    private final RedDotRecord f(String id5, int version) {
        w53.b.f("MaterialRedDotHandler", "addToMap id = " + id5 + "\uff0c version = " + version);
        RedDotRecord redDotRecord = new RedDotRecord(id5, version);
        this.redDotMap.put(id5, redDotRecord);
        return redDotRecord;
    }

    static /* synthetic */ RedDotRecord g(MaterialRedDotHandler materialRedDotHandler, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return materialRedDotHandler.f(str, i3);
    }

    private final String h() {
        return com.tencent.mobileqq.wink.edit.manager.h.d().b(f.f438391d, "editor_auto_template_update_template_copy.json");
    }

    private final MaterialRedDotInfo i(MetaMaterial material) {
        String str;
        Map<String, String> map = material.additionalFields;
        if (map == null || (str = map.get("redDotInfo")) == null) {
            return null;
        }
        try {
            return (MaterialRedDotInfo) new Gson().fromJson(str, MaterialRedDotInfo.class);
        } catch (Exception e16) {
            w53.b.d("MaterialRedDotHandler", "getRedDotInfo error \u4e0d\u662fcrash ", e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(MetaCategory category, boolean needRemoveCategoryRecord, List<RedDotRecord> childrens) {
        boolean z16;
        w53.b.f("MaterialRedDotHandler", "handlerCategoryRedDot id = " + category.f30532id + " , needRemoveCategoryRecord = " + needRemoveCategoryRecord + " ");
        if (needRemoveCategoryRecord) {
            String str = category.f30532id;
            Intrinsics.checkNotNullExpressionValue(str, "category.id");
            u(str);
        }
        String str2 = category.f30532id;
        Intrinsics.checkNotNullExpressionValue(str2, "category.id");
        if (!r(str2)) {
            String str3 = category.f30532id;
            Intrinsics.checkNotNullExpressionValue(str3, "category.id");
            if (!n(this, str3, 0, 2, null)) {
                if (!childrens.isEmpty()) {
                    z16 = true;
                    category.hasRedDot = z16;
                    w53.b.f("MaterialRedDotHandler", "handlerCategoryRedDot hasRedDot = " + z16);
                    if (category.hasRedDot) {
                        String str4 = category.f30532id;
                        Intrinsics.checkNotNullExpressionValue(str4, "category.id");
                        g(this, str4, 0, 2, null).addChilds(childrens);
                        return;
                    } else {
                        if (childrens.isEmpty()) {
                            String str5 = category.f30532id;
                            Intrinsics.checkNotNullExpressionValue(str5, "category.id");
                            u(str5);
                            return;
                        }
                        return;
                    }
                }
                z16 = false;
                category.hasRedDot = z16;
                w53.b.f("MaterialRedDotHandler", "handlerCategoryRedDot hasRedDot = " + z16);
                if (category.hasRedDot) {
                }
            }
        }
        w53.b.f("MaterialRedDotHandler", "handlerCategoryRedDot id = " + category.f30532id + " , hasClicked = true ");
        z16 = false;
        category.hasRedDot = z16;
        w53.b.f("MaterialRedDotHandler", "handlerCategoryRedDot hasRedDot = " + z16);
        if (category.hasRedDot) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r7.isEmpty() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (r7.isEmpty() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k(List<RedDotRecord> childrens, boolean needRemoveEntracnceRecord) {
        w53.b.f("MaterialRedDotHandler", "handlerEntranceRedDot , needRemoveEntracnceRecord = " + needRemoveEntracnceRecord);
        if (needRemoveEntracnceRecord) {
            u(c());
        }
        boolean z16 = true;
        if (!needRemoveEntracnceRecord) {
            if (n(this, c(), 0, 2, null)) {
                w53.b.f("MaterialRedDotHandler", "handlerEntranceRedDot id = " + c() + " , hasClicked = true");
            }
            z16 = false;
        }
        w53.b.f("MaterialRedDotHandler", "handlerEntranceRedDot hasRedDot = " + z16);
        if (z16) {
            g(this, c(), 0, 2, null).addChilds(childrens);
        } else if (childrens.isEmpty()) {
            u(c());
        }
    }

    private final boolean l(MetaMaterial material, MaterialRedDotInfo info) {
        boolean p16 = p(material, info);
        material.hasRedDot = p16;
        return p16;
    }

    private final boolean m(String id5, int version) {
        Integer num;
        int i3;
        w53.b.f("MaterialRedDotHandler", "hasClicked id = " + id5 + "\uff0c version = " + version);
        boolean z16 = true;
        int i16 = -1;
        if (this.lastClickRecord.containsKey(id5)) {
            RedDotRecord redDotRecord = this.lastClickRecord.get(id5);
            if (redDotRecord != null) {
                i3 = redDotRecord.getRedDotVersion();
            } else {
                i3 = -1;
            }
            w53.b.a("MaterialRedDotHandler", "hasClicked lastClickRecord.containsKey(id)\uff0c version = " + i3);
            RedDotRecord redDotRecord2 = this.lastClickRecord.get(id5);
            if (redDotRecord2 != null) {
                i16 = redDotRecord2.getRedDotVersion();
            }
            if (i16 >= version) {
                return true;
            }
            return false;
        }
        RedDotRecord redDotRecord3 = (RedDotRecord) ar.h(ar.f326685a, id5, RedDotRecord.class, null, 4, null);
        if (redDotRecord3 != null) {
            num = Integer.valueOf(redDotRecord3.getRedDotVersion());
        } else {
            num = null;
        }
        w53.b.f("MaterialRedDotHandler", "hasClicked id = " + id5 + "\uff0c record = " + num);
        if (redDotRecord3 == null) {
            this.lastClickRecord.put(id5, new RedDotRecord(id5, -1));
            return false;
        }
        this.lastClickRecord.put(id5, redDotRecord3);
        if (redDotRecord3.getRedDotVersion() < version) {
            z16 = false;
        }
        if (!z16) {
            u(id5);
        }
        return z16;
    }

    static /* synthetic */ boolean n(MaterialRedDotHandler materialRedDotHandler, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return materialRedDotHandler.m(str, i3);
    }

    private final boolean o(long origin, long target) {
        if ((origin & target) == target) {
            return true;
        }
        return false;
    }

    private final boolean p(MetaMaterial material, MaterialRedDotInfo info) {
        if (info != null && info.getRedDotMask() >= 1) {
            w53.b.f("MaterialRedDotHandler", "hasRedDot material: " + material.f30533id);
            try {
                String str = material.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "material.id");
                if (m(str, info.getRedDotVersion())) {
                    w53.b.f("MaterialRedDotHandler", "hasRedDot id = " + material.f30533id + " , hasClicked = true ");
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis >= info.getStartDate() && currentTimeMillis < info.getEndDate()) {
                    if (!o(info.getRedDotMask(), 1L)) {
                        return false;
                    }
                    return true;
                }
                String str2 = material.f30533id;
                Intrinsics.checkNotNullExpressionValue(str2, "material.id");
                u(str2);
                w53.b.f("MaterialRedDotHandler", "time exprid = false");
                return false;
            } catch (Exception e16) {
                w53.b.d("MaterialRedDotHandler", "hasRedDot error = " + material.f30533id, e16);
            }
        }
        return false;
    }

    private final boolean q(String categoryId, String materialId, int newVersion) {
        Map<String, RedDotRecord> map;
        RedDotRecord redDotRecord;
        Map<String, ? extends Map<String, RedDotRecord>> map2 = this.oldDate;
        if (map2 == null || (map = map2.get(categoryId)) == null || (redDotRecord = map.get(materialId)) == null || newVersion > redDotRecord.getRedDotVersion()) {
            return true;
        }
        return false;
    }

    private final boolean r(String id5) {
        return Intrinsics.areEqual(id5, "recommend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String id5, final List<String> list, boolean first) {
        w53.b.f("MaterialRedDotHandler", "onClick = " + id5 + ", first = " + first);
        RedDotRecord remove = this.redDotMap.remove(id5);
        if (remove == null) {
            return;
        }
        this.lastClickRecord.put(id5, remove);
        ar.f326685a.q(id5, remove);
        if (!first) {
            list.add(id5);
        }
        remove.notifyParents(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.reddot.material.MaterialRedDotHandler$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MaterialRedDotHandler.this.s(it, list, false);
            }
        });
    }

    private final Map<String, Map<String, RedDotRecord>> t() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        w53.b.f("MaterialRedDotHandler", "getOldData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            File file = new File(h());
            if (file.exists()) {
                String h16 = com.tencent.mobileqq.wink.edit.manager.h.h(file);
                if (TextUtils.isEmpty(h16)) {
                    return linkedHashMap;
                }
                w53.b.a("MaterialRedDotHandler", "getOldData = " + h16);
                Object fromJson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(h16, new b().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "GsonBuilder().excludeFie\u2026ype\n                    )");
                ArrayList<RedDotRecordCache> arrayList = (ArrayList) fromJson;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast);
                for (RedDotRecordCache redDotRecordCache : arrayList) {
                    String id5 = redDotRecordCache.getId();
                    Set<RedDotRecord> records = redDotRecordCache.getRecords();
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(records, 10);
                    mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap(coerceAtLeast2);
                    for (Object obj : records) {
                        linkedHashMap3.put(((RedDotRecord) obj).getId(), obj);
                    }
                    Pair pair = TuplesKt.to(id5, linkedHashMap3);
                    linkedHashMap2.put(pair.getFirst(), pair.getSecond());
                }
                return linkedHashMap2;
            }
        } catch (Exception e16) {
            w53.b.d("MaterialRedDotHandler", "getOldData error", e16);
        }
        return linkedHashMap;
    }

    private final void u(String id5) {
        w53.b.f("MaterialRedDotHandler", "removeRecord = " + id5);
        this.lastClickRecord.remove(id5);
        ar.f326685a.l(id5);
    }

    private final void v(Set<RedDotRecordCache> map) {
        if (map.isEmpty()) {
            w53.b.f("MaterialRedDotHandler", "saveOriginData map.isEmpty");
            return;
        }
        try {
            String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(map);
            FileUtils.writeFile(h(), json);
            w53.b.f("MaterialRedDotHandler", "saveOriginData = " + json);
        } catch (Exception e16) {
            w53.b.d("MaterialRedDotHandler", "saveOriginData error not crash", e16);
        }
    }

    @Override // com.tencent.mobileqq.wink.reddot.a
    public boolean a(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        boolean containsKey = this.redDotMap.containsKey(id5);
        w53.b.f("MaterialRedDotHandler", "showRedDot = " + id5 + ", " + containsKey);
        return containsKey;
    }

    @Override // com.tencent.mobileqq.wink.reddot.a
    public void b(@NotNull String id5, @NotNull Function1<? super List<String>, Unit> action) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(action, "action");
        w53.b.f("MaterialRedDotHandler", "recordClick = " + id5);
        ArrayList arrayList = new ArrayList();
        s(id5, arrayList, true);
        if (!arrayList.isEmpty()) {
            action.invoke(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.wink.reddot.a
    @NotNull
    public String c() {
        return MenuType.VIDEO_TEMPLATE.name();
    }

    @Override // com.tencent.mobileqq.wink.reddot.a
    public void d(@NotNull List<? extends MetaCategory> categorys) {
        Map<String, RedDotRecord> map;
        Collection<RedDotRecord> values;
        Set mutableSet;
        Iterator it;
        boolean z16;
        Iterator it5;
        LinkedHashSet linkedHashSet;
        String str;
        Intrinsics.checkNotNullParameter(categorys, "categorys");
        w53.b.f("MaterialRedDotHandler", "transMaterialToRedDotRecord start");
        this.oldDate = t();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        Iterator it6 = categorys.iterator();
        boolean z17 = false;
        boolean z18 = false;
        while (it6.hasNext()) {
            MetaCategory metaCategory = (MetaCategory) it6.next();
            ArrayList arrayList2 = new ArrayList();
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            String str2 = "category.id";
            if (!z18) {
                String str3 = metaCategory.f30532id;
                Intrinsics.checkNotNullExpressionValue(str3, "category.id");
                z18 = r(str3);
            }
            ArrayList<MetaMaterial> arrayList3 = metaCategory.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "category.materials");
            Iterator it7 = arrayList3.iterator();
            boolean z19 = false;
            while (it7.hasNext()) {
                MetaMaterial material = (MetaMaterial) it7.next();
                Intrinsics.checkNotNullExpressionValue(material, "material");
                MaterialRedDotInfo i3 = i(material);
                if (i3 == null) {
                    it = it6;
                    z16 = z18;
                    linkedHashSet = linkedHashSet3;
                    str = str2;
                    it5 = it7;
                } else {
                    String str4 = metaCategory.name;
                    it = it6;
                    String str5 = material.f30533id;
                    boolean z26 = z17;
                    StringBuilder sb5 = new StringBuilder();
                    z16 = z18;
                    sb5.append("transMaterialToRedDotRecord  ID= ");
                    sb5.append(str4);
                    sb5.append("\uff0c");
                    sb5.append(str5);
                    sb5.append(", info = ");
                    sb5.append(i3);
                    w53.b.a("MaterialRedDotHandler", sb5.toString());
                    String str6 = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str6, "material.id");
                    it5 = it7;
                    linkedHashSet3.add(new RedDotRecord(str6, i3.getRedDotVersion()));
                    String str7 = metaCategory.f30532id;
                    Intrinsics.checkNotNullExpressionValue(str7, str2);
                    String str8 = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str8, "material.id");
                    boolean q16 = q(str7, str8, i3.getRedDotVersion());
                    linkedHashSet = linkedHashSet3;
                    str = str2;
                    boolean o16 = o(i3.getRedDotMask(), 2L);
                    boolean z27 = z19;
                    boolean o17 = o(i3.getRedDotMask(), 4L);
                    w53.b.a("MaterialRedDotHandler", "hasCategory = " + o16 + ", hasEntrance = " + o17 + ", isNewMaterial = " + q16);
                    if (q16) {
                        z26 = o17;
                        z27 = o16;
                    }
                    if (l(material, i3)) {
                        w53.b.a("MaterialRedDotHandler", "handlerMaterialRedDot " + metaCategory.name + "\uff0c" + material.f30533id);
                        String str9 = material.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str9, "material.id");
                        RedDotRecord f16 = f(str9, i3.getRedDotVersion());
                        if (o16) {
                            arrayList2.add(f16);
                        }
                        if (o17) {
                            arrayList.add(f16);
                        }
                    }
                    z17 = z26;
                    z19 = z27;
                }
                it6 = it;
                z18 = z16;
                it7 = it5;
                linkedHashSet3 = linkedHashSet;
                str2 = str;
            }
            Iterator it8 = it6;
            boolean z28 = z17;
            boolean z29 = z18;
            LinkedHashSet linkedHashSet4 = linkedHashSet3;
            String str10 = str2;
            boolean z36 = z19;
            if (!linkedHashSet4.isEmpty()) {
                w53.b.a("MaterialRedDotHandler", "saveData add ID= " + metaCategory.name + "\uff0c size = " + linkedHashSet4.size());
                String str11 = metaCategory.f30532id;
                Intrinsics.checkNotNullExpressionValue(str11, str10);
                linkedHashSet2.add(new RedDotRecordCache(str11, linkedHashSet4));
            }
            j(metaCategory, z36, arrayList2);
            it6 = it8;
            z17 = z28;
            z18 = z29;
        }
        k(arrayList, z17);
        if (!z18) {
            w53.b.f("MaterialRedDotHandler", "transMaterialToRedDotRecord without recommend");
            Map<String, ? extends Map<String, RedDotRecord>> map2 = this.oldDate;
            if (map2 != null && (map = map2.get("recommend")) != null && (values = map.values()) != null) {
                mutableSet = CollectionsKt___CollectionsKt.toMutableSet(values);
                linkedHashSet2.add(new RedDotRecordCache("recommend", mutableSet));
            }
        }
        v(linkedHashSet2);
    }
}
