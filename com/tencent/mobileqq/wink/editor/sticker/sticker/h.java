package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.utils.ab;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\nH\u0002J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\nR$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\tj\b\u0012\u0004\u0012\u00020\u000e`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/h;", "", "", "id", "", "b", "", "f", "e", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", tl.h.F, WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "d", "", "a", "", "data", "g", "c", "Ljava/util/ArrayList;", "recentStickerData", "searchStickerData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecentStickerData> recentStickerData = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MetaMaterial> searchStickerData = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0002J\u008c\u0001\u0010\u0014\u001a\u00020\u00132\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00042\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002J<\u0010\u0015\u001a\u00020\u00132\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004H\u0002J\u0080\u0001\u0010\u0016\u001a\u00020\u00132\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00042\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0002J\u0080\u0001\u0010\u0017\u001a\u00020\u00132\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJB\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u001f\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dJ\u001e\u0010!\u001a\u00020\u00132\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004R\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/h$a;", "", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "k", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "i", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "stickersWithoutEmoticon", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "idToIndex", "size", "tempMaterials", "recordData", "hotStickers", "", "e", "b", "g", "f", WadlProxyConsts.KEY_MATERIAL, "c", tl.h.F, "j", "l", "", "materials", "d", "recents", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "MAX_SIZE", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.h$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/h$a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/RecentStickerData;", "Lkotlin/collections/ArrayList;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9035a extends TypeToken<ArrayList<RecentStickerData>> {
            C9035a() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/h$a$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.h$a$b */
        /* loaded from: classes21.dex */
        public static final class b extends TypeToken<ArrayList<MetaMaterial>> {
            b() {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(ArrayList<MetaMaterial> tempMaterials, ArrayList<MetaCategory> stickersWithoutEmoticon) {
            List<MetaMaterial> emptyList;
            List filterNotNull;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            MetaCategory d16 = d(emptyList);
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(tempMaterials);
            ArrayList<MetaMaterial> arrayList = new ArrayList<>(filterNotNull);
            d16.materials = arrayList;
            w53.b.f("WinkStickerRecentManager", "attachToPanelData recentCate.materials = " + arrayList.size());
            Intrinsics.checkNotNullExpressionValue(d16.materials, "recentCate.materials");
            if (!r4.isEmpty()) {
                stickersWithoutEmoticon.add(0, d16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MetaMaterial c(MetaMaterial material) {
            MetaMaterial copyRecentMaterial$lambda$7 = material.copy();
            Intrinsics.checkNotNullExpressionValue(copyRecentMaterial$lambda$7, "copyRecentMaterial$lambda$7");
            com.tencent.mobileqq.wink.editor.c.o1(copyRecentMaterial$lambda$7, "100020815");
            Intrinsics.checkNotNullExpressionValue(copyRecentMaterial$lambda$7, "material.copy().apply {\n\u2026CATEGORY_ID\n            }");
            return copyRecentMaterial$lambda$7;
        }

        private final void e(ArrayList<MetaCategory> stickersWithoutEmoticon, HashMap<String, Integer> idToIndex, int size, ArrayList<MetaMaterial> tempMaterials, ArrayList<RecentStickerData> recordData, MetaCategory hotStickers) {
            boolean z16;
            ArrayList<MetaCategory> arrayListOf;
            ArrayList<MetaMaterial> arrayList;
            g(stickersWithoutEmoticon, idToIndex, size, tempMaterials, recordData);
            if (hotStickers != null && (arrayList = hotStickers.materials) != null && (!arrayList.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                w53.b.a("WinkStickerRecentManager", "fillAvailableSticker filterhotSticker");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(hotStickers);
                g(arrayListOf, idToIndex, size, tempMaterials, recordData);
            }
            w53.b.a("WinkStickerRecentManager", "fillAvailableSticker filterSearchSticker = " + (!idToIndex.isEmpty()));
            if (!idToIndex.isEmpty()) {
                f(k(), idToIndex, size, tempMaterials, recordData);
            }
        }

        private final void f(ArrayList<MetaMaterial> stickersWithoutEmoticon, HashMap<String, Integer> idToIndex, int size, ArrayList<MetaMaterial> tempMaterials, ArrayList<RecentStickerData> recordData) {
            for (MetaMaterial material : new ArrayList(stickersWithoutEmoticon)) {
                w53.b.a("WinkStickerRecentManager", "filterSearchSticker stickersWhitOutEmoticon = " + material.f30533id);
                if (idToIndex.isEmpty()) {
                    return;
                }
                Integer remove = idToIndex.remove(material.f30533id);
                if (remove == null) {
                    remove = -1;
                }
                Intrinsics.checkNotNullExpressionValue(remove, "idToIndex.remove(material.id) ?: -1");
                int intValue = remove.intValue();
                w53.b.a("WinkStickerRecentManager", "filterSearchSticker stickersWhitOutEmoticon index = " + intValue);
                boolean z16 = false;
                if (intValue >= 0 && intValue < size) {
                    z16 = true;
                }
                if (z16 && recordData.get(intValue).getIsFromSearch()) {
                    w53.b.f("WinkStickerRecentManager", "filterSearchSticker attach =========== " + material.f30533id);
                    Companion companion = h.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(material, "material");
                    tempMaterials.set(intValue, companion.c(material));
                    recordData.get(intValue).setHasHit(true);
                    recordData.get(intValue).setMaterial(material);
                }
            }
        }

        private final void g(ArrayList<MetaCategory> stickersWithoutEmoticon, HashMap<String, Integer> idToIndex, int size, ArrayList<MetaMaterial> tempMaterials, ArrayList<RecentStickerData> recordData) {
            boolean z16;
            Iterator it = new ArrayList(stickersWithoutEmoticon).iterator();
            while (it.hasNext()) {
                for (MetaMaterial material : new ArrayList(((MetaCategory) it.next()).materials)) {
                    if (!idToIndex.isEmpty()) {
                        w53.b.a("WinkStickerRecentManager", "filterSticker stickersWhitOutEmoticon = " + material.f30533id);
                        Integer remove = idToIndex.remove(material.f30533id);
                        if (remove == null) {
                            remove = -1;
                        }
                        Intrinsics.checkNotNullExpressionValue(remove, "idToIndex.remove(material.id) ?: -1");
                        int intValue = remove.intValue();
                        w53.b.a("WinkStickerRecentManager", "filterSticker stickersWhitOutEmoticon index = " + intValue);
                        if (intValue >= 0 && intValue < size) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            w53.b.f("WinkStickerRecentManager", "filterSticker attach =========== " + material.f30533id);
                            Companion companion = h.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(material, "material");
                            tempMaterials.set(intValue, companion.c(material));
                            recordData.get(intValue).setHasHit(true);
                            recordData.get(intValue).setMaterial(material);
                            recordData.get(intValue).setFromSearch(false);
                        }
                    }
                }
            }
        }

        private final ArrayList<RecentStickerData> i() {
            try {
                File file = new File(h());
                if (!file.exists()) {
                    w53.b.c("WinkStickerRecentManager", "insertRecentCategory file not exists()");
                    return new ArrayList<>();
                }
                String h16 = com.tencent.mobileqq.wink.edit.manager.h.h(file);
                w53.b.f("WinkStickerRecentManager", "insertRecentCategory OldData = " + h16);
                if (TextUtils.isEmpty(h16)) {
                    return new ArrayList<>();
                }
                Object fromJson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(h16, new C9035a().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                val fi\u2026() {}.type)\n            }");
                return (ArrayList) fromJson;
            } catch (Exception unused) {
                return new ArrayList<>();
            }
        }

        private final ArrayList<MetaMaterial> k() {
            try {
                File file = new File(j());
                if (!file.exists()) {
                    w53.b.c("WinkStickerRecentManager", "getSearchStickerData file not exists()");
                    return new ArrayList<>();
                }
                String h16 = com.tencent.mobileqq.wink.edit.manager.h.h(file);
                w53.b.f("WinkStickerRecentManager", "getSearchStickerData OldData = " + h16);
                if (TextUtils.isEmpty(h16)) {
                    return new ArrayList<>();
                }
                Object fromJson = new Gson().fromJson(h16, new b().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                val fi\u2026() {}.type)\n            }");
                return (ArrayList) fromJson;
            } catch (Exception unused) {
                return new ArrayList<>();
            }
        }

        @NotNull
        public final MetaCategory d(@NotNull List<MetaMaterial> materials) {
            Intrinsics.checkNotNullParameter(materials, "materials");
            MetaCategory metaCategory = new MetaCategory();
            metaCategory.f30532id = "100020815";
            metaCategory.name = HardCodeUtil.qqStr(R.string.f240977qm);
            metaCategory.materials = new ArrayList<>(materials);
            return metaCategory;
        }

        @NotNull
        public final String h() {
            try {
                return ab.f326657a.b("editor_recent_sticker.json");
            } catch (IOException unused) {
                return "";
            }
        }

        @NotNull
        public final String j() {
            try {
                return ab.f326657a.b("editor_recent_search_sticker.json");
            } catch (IOException unused) {
                return "";
            }
        }

        @JvmStatic
        @WorkerThread
        @NotNull
        public final ArrayList<RecentStickerData> l(@Nullable ArrayList<MetaCategory> stickersWithoutEmoticon, @Nullable MetaCategory hotStickers) {
            boolean z16;
            String joinToString$default;
            int i3 = 0;
            if (stickersWithoutEmoticon != null && !stickersWithoutEmoticon.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                w53.b.c("WinkStickerRecentManager", "insertRecentCategory stickersWhitOutEmoticon isNullOrEmpty");
                return new ArrayList<>();
            }
            try {
                ArrayList<RecentStickerData> i16 = i();
                if (i16.isEmpty()) {
                    w53.b.f("WinkStickerRecentManager", "insertRecentCategory recordData is empty");
                    return new ArrayList<>();
                }
                int size = i16.size();
                ArrayList<MetaMaterial> arrayList = new ArrayList<>(Collections.nCopies(size, null));
                HashMap<String, Integer> hashMap = new HashMap<>();
                for (Object obj : i16) {
                    int i17 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    hashMap.put(((RecentStickerData) obj).getId(), Integer.valueOf(i3));
                    i3 = i17;
                }
                Collection<Integer> values = hashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "idToIndex.values");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(values, null, null, null, 0, null, null, 63, null);
                w53.b.a("WinkStickerRecentManager", "insertRecentCategory idToIndex = " + joinToString$default);
                e(stickersWithoutEmoticon, hashMap, size, arrayList, i16, hotStickers);
                try {
                    b(arrayList, stickersWithoutEmoticon);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : i16) {
                        if (((RecentStickerData) obj2).getHasHit()) {
                            arrayList2.add(obj2);
                        }
                    }
                    return new ArrayList<>(arrayList2);
                } catch (Exception e16) {
                    e = e16;
                    w53.b.d("WinkStickerRecentManager", "insertRecentCategory error ", e);
                    return new ArrayList<>();
                }
            } catch (Exception e17) {
                e = e17;
            }
        }

        public final void m(@NotNull ArrayList<MetaMaterial> recents) {
            Object obj;
            Intrinsics.checkNotNullParameter(recents, "recents");
            List<MetaCategory> value = WinkEditorResourceManager.a1().J1().getValue();
            if (value == null) {
                return;
            }
            for (MetaCategory metaCategory : value) {
                if (Intrinsics.areEqual(metaCategory.f30532id, "common_sticker")) {
                    if (metaCategory.subCategories.isEmpty()) {
                        w53.b.g("WinkStickerRecentManager", "updateRecentMaterial it.subCategories.isEmpty");
                        return;
                    }
                    ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "it.subCategories");
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "100020815")) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    MetaCategory metaCategory2 = (MetaCategory) obj;
                    if (metaCategory2 == null) {
                        metaCategory.subCategories.add(0, h.INSTANCE.d(recents));
                    } else {
                        metaCategory2.materials = recents;
                    }
                    WinkEditorResourceManager.a1().J1().setValue(value);
                }
            }
        }

        Companion() {
        }
    }

    private final int a(MetaMaterial material) {
        int i3 = -1;
        int i16 = 0;
        for (Object obj : this.recentStickerData) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((RecentStickerData) obj).getId(), material.f30533id)) {
                i3 = i16;
            }
            i16 = i17;
        }
        return i3;
    }

    private final boolean b(String id5) {
        ArrayList<MetaMaterial> arrayList;
        Object obj;
        ArrayList<MetaCategory> arrayList2;
        List<MetaCategory> value = WinkEditorResourceManager.a1().J1().getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "common_sticker")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaCategory metaCategory = (MetaCategory) obj;
            if (metaCategory != null && (arrayList2 = metaCategory.subCategories) != null) {
                Iterator<T> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ArrayList<MetaMaterial> materials = ((MetaCategory) it5.next()).materials;
                    if (materials != null) {
                        Intrinsics.checkNotNullExpressionValue(materials, "materials");
                        Iterator<T> it6 = materials.iterator();
                        while (it6.hasNext()) {
                            if (Intrinsics.areEqual(((MetaMaterial) it6.next()).f30533id, id5)) {
                                w53.b.f("WinkStickerRecentManager", "isFromSearch stickerWithQQEmoticonLiveData id = " + id5);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        MetaCategory value2 = WinkEditorResourceManager.a1().Y0().getValue();
        if (value2 != null && (arrayList = value2.materials) != null) {
            Iterator<T> it7 = arrayList.iterator();
            while (it7.hasNext()) {
                if (Intrinsics.areEqual(((MetaMaterial) it7.next()).f30533id, id5)) {
                    w53.b.f("WinkStickerRecentManager", "isFromSearch hotStickerLiveData id = " + id5);
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private final RecentStickerData d(MetaMaterial material) {
        int a16 = a(material);
        if (a16 >= 0 && a16 < this.recentStickerData.size()) {
            return this.recentStickerData.remove(a16);
        }
        return null;
    }

    private final void e() {
        if (this.recentStickerData.isEmpty()) {
            w53.b.f("WinkStickerRecentManager", "saveRecentSticker recentIds.isEmpty");
            return;
        }
        try {
            String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this.recentStickerData);
            w53.b.f("WinkStickerRecentManager", "saveRecentSticker = " + json);
            FileUtils.writeFile(INSTANCE.h(), json);
        } catch (Exception e16) {
            w53.b.d("WinkStickerRecentManager", "saveRecentSticker error not crash", e16);
        }
    }

    private final void f() {
        if (this.searchStickerData.isEmpty()) {
            w53.b.f("WinkStickerRecentManager", "saveSearchSticker recentIds.isEmpty");
            return;
        }
        try {
            String json = new Gson().toJson(this.searchStickerData);
            w53.b.f("WinkStickerRecentManager", "saveSearchSticker = " + json);
            FileUtils.writeFile(INSTANCE.j(), json);
        } catch (Exception e16) {
            w53.b.d("WinkStickerRecentManager", "saveSearchSticker error not crash", e16);
        }
    }

    private final ArrayList<MetaMaterial> h() {
        ArrayList<RecentStickerData> arrayList = this.recentStickerData;
        ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((RecentStickerData) it.next()).getMaterial());
        }
        return arrayList2;
    }

    @NotNull
    public final ArrayList<MetaMaterial> c(@Nullable MetaMaterial material) {
        boolean b16;
        Boolean bool;
        if (material == null) {
            return h();
        }
        w53.b.f("WinkStickerRecentManager", "onNewStickerUsed : " + material.f30533id + ", " + com.tencent.mobileqq.wink.editor.c.o(material));
        if (m.N(material)) {
            w53.b.f("WinkStickerRecentManager", "onNewStickerUsed isEffectSticker");
            return h();
        }
        if (!l.B(material)) {
            MetaMaterial c16 = INSTANCE.c(material);
            RecentStickerData d16 = d(c16);
            if (d16 != null) {
                b16 = d16.getIsFromSearch();
            } else {
                String str = c16.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "recent.id");
                b16 = b(str);
            }
            Object obj = null;
            if (d16 != null) {
                bool = Boolean.valueOf(d16.getIsFromSearch());
            } else {
                bool = null;
            }
            w53.b.f("WinkStickerRecentManager", "onNewStickerUsed last = " + bool + ", fromSearch = " + b16);
            ArrayList<RecentStickerData> arrayList = this.recentStickerData;
            String str2 = c16.f30533id;
            Intrinsics.checkNotNullExpressionValue(str2, "recent.id");
            RecentStickerData recentStickerData = new RecentStickerData(str2);
            boolean z16 = true;
            recentStickerData.setHasHit(true);
            recentStickerData.setMaterial(c16);
            recentStickerData.setFromSearch(b16);
            Unit unit = Unit.INSTANCE;
            arrayList.add(0, recentStickerData);
            while (this.recentStickerData.size() > 24) {
                CollectionsKt__MutableCollectionsKt.removeLast(this.recentStickerData);
            }
            if (b16) {
                Iterator<T> it = this.searchStickerData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((MetaMaterial) next).f30533id, c16.f30533id)) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    z16 = false;
                }
                w53.b.f("WinkStickerRecentManager", "onNewStickerUsed fromSearch, contains = " + z16);
                if (!z16) {
                    this.searchStickerData.add(c16);
                    f();
                }
            }
            e();
            return h();
        }
        w53.b.f("WinkStickerRecentManager", "onNewStickerUsed isCustomSticker");
        return h();
    }

    public final void g(@NotNull List<RecentStickerData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        w53.b.f("WinkStickerRecentManager", "setRecentMaterials: " + data.size());
        if (data.isEmpty()) {
            return;
        }
        this.searchStickerData.clear();
        for (RecentStickerData recentStickerData : data) {
            if (recentStickerData.getIsFromSearch()) {
                w53.b.f("WinkStickerRecentManager", "setRecentMaterials isFromSearch : " + recentStickerData.getId());
                this.searchStickerData.add(recentStickerData.getMaterial());
            }
        }
        this.recentStickerData.clear();
        this.recentStickerData.addAll(data);
    }
}
