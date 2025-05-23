package com.tencent.mobileqq.qwallet.pet.data;

import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$Cloth;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$GetRsp;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$Pet;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$PetActionResource;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$Scene;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$SubActionResources;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qk2.FilamentConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bR(\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R4\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRL\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0017\u0018\u00010\u001d2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0017\u0018\u00010\u001d8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R4\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00172\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u0012\u0010\u001bR4\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b%\u0010\u001bR$\u0010,\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010(\u001a\u0004\b\u001e\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/f;", "", "", "i", "Lcom/qwallet/protocol/Wallet/pb/pet/PetGlobalConfig$GetRsp;", "petGlobalConfig", "", "j", "", "petType", "actionType", "Lcom/tencent/mobileqq/qwallet/pet/data/e;", "a", "c", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/qwallet/pet/data/j;", tl.h.F, "<set-?>", "b", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "", "Lcom/tencent/mobileqq/qwallet/pet/data/g;", "Ljava/util/List;", "e", "()Ljava/util/List;", "petInfoList", "", "d", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "petType2ActionsMap", "Lcom/tencent/mobileqq/qwallet/pet/data/a;", "clothingList", "g", "sceneList", "Lcom/tencent/mobileqq/qwallet/pet/data/c;", "Lcom/tencent/mobileqq/qwallet/pet/data/c;", "()Lcom/tencent/mobileqq/qwallet/pet/data/c;", "setFilamentDefaultResource", "(Lcom/tencent/mobileqq/qwallet/pet/data/c;)V", "filamentDefaultResource", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f278777a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String version;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<PetInfo> petInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Map<String, ? extends List<e>> petType2ActionsMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<ClothInfo> clothingList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<j> sceneList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static FilamentDefaultResource filamentDefaultResource;

    f() {
    }

    private final void i() {
        filamentDefaultResource = new FilamentDefaultResource(((FilamentConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_FILAMENT_CONFIG, new FilamentConfig(null, 1, null))).getContent().getDefaultResUrl());
    }

    @Nullable
    public final e a(@NotNull String petType, @NotNull String actionType) {
        List<e> list;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Map<String, ? extends List<e>> map = petType2ActionsMap;
        Object obj = null;
        if (map == null || (list = map.get(petType)) == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((e) next).getActionType(), actionType)) {
                obj = next;
                break;
            }
        }
        return (e) obj;
    }

    @Nullable
    public final List<ClothInfo> b() {
        return clothingList;
    }

    @Nullable
    public final String c(@Nullable String petType) {
        List<e> list;
        Object obj;
        Map<String, ? extends List<e>> map = petType2ActionsMap;
        if (map == null || (list = map.get(petType)) == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((e) obj).getIsDefault()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        e eVar = (e) obj;
        if (eVar == null) {
            return null;
        }
        return eVar.getActionType();
    }

    @Nullable
    public final FilamentDefaultResource d() {
        return filamentDefaultResource;
    }

    @Nullable
    public final List<PetInfo> e() {
        return petInfoList;
    }

    @Nullable
    public final Map<String, List<e>> f() {
        return petType2ActionsMap;
    }

    @Nullable
    public final List<j> g() {
        return sceneList;
    }

    @Nullable
    public final j h(@Nullable String sceneId) {
        Object obj;
        List<j> list = sceneList;
        Object obj2 = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((j) obj).getSceneId(), sceneId)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            j jVar = (j) obj;
            if (jVar != null) {
                return jVar;
            }
        }
        List<j> list2 = sceneList;
        if (list2 == null) {
            return null;
        }
        Iterator<T> it5 = list2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((j) next).getIsDefault()) {
                obj2 = next;
                break;
            }
        }
        return (j) obj2;
    }

    public final synchronized boolean j(@Nullable PetGlobalConfig$GetRsp petGlobalConfig) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        int collectionSizeOrDefault5;
        int i3;
        int collectionSizeOrDefault6;
        int collectionSizeOrDefault7;
        i();
        if (petGlobalConfig == null) {
            return false;
        }
        String str = petGlobalConfig.version.get();
        int i16 = 1;
        if (Intrinsics.areEqual(str, version)) {
            QLog.i("QWallet.Pet.DataManager", 1, "ignored update: " + version);
            return true;
        }
        version = str;
        QLog.i("QWallet.Pet.DataManager", 1, "version: " + str);
        List<PetGlobalConfig$Pet> list = petGlobalConfig.pets.get();
        Intrinsics.checkNotNullExpressionValue(list, "petGlobalConfig.pets.get()");
        List<PetGlobalConfig$Pet> list2 = list;
        int i17 = 10;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (PetGlobalConfig$Pet petGlobalConfig$Pet : list2) {
            String str2 = petGlobalConfig$Pet.pet_type.get();
            Intrinsics.checkNotNullExpressionValue(str2, "pet.pet_type.get()");
            boolean areEqual = Intrinsics.areEqual(petGlobalConfig$Pet.pet_type.get(), petGlobalConfig.defaults.pet_type.get());
            List<PetGlobalConfig$PetActionResource> list3 = petGlobalConfig$Pet.pet_action_resources.get();
            Intrinsics.checkNotNullExpressionValue(list3, "pet.pet_action_resources.get()");
            List<PetGlobalConfig$PetActionResource> list4 = list3;
            collectionSizeOrDefault7 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault7);
            Iterator<T> it = list4.iterator();
            while (it.hasNext()) {
                arrayList2.add(((PetGlobalConfig$PetActionResource) it.next()).action_type.get());
            }
            String str3 = petGlobalConfig$Pet.entrance_pic_small.get();
            Intrinsics.checkNotNullExpressionValue(str3, "pet.entrance_pic_small.get()");
            String str4 = petGlobalConfig$Pet.entrance_pic_big.get();
            Intrinsics.checkNotNullExpressionValue(str4, "pet.entrance_pic_big.get()");
            arrayList.add(new PetInfo(str2, areEqual, arrayList2, str3, str4));
        }
        petInfoList = arrayList;
        QLog.i("QWallet.Pet.DataManager", 1, "petInfoList: " + arrayList);
        List<PetGlobalConfig$Pet> list5 = petGlobalConfig.pets.get();
        Intrinsics.checkNotNullExpressionValue(list5, "petGlobalConfig.pets.get()");
        List<PetGlobalConfig$Pet> list6 = list5;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        Iterator it5 = list6.iterator();
        while (it5.hasNext()) {
            PetGlobalConfig$Pet petGlobalConfig$Pet2 = (PetGlobalConfig$Pet) it5.next();
            String str5 = petGlobalConfig$Pet2.pet_type.get();
            List<PetGlobalConfig$PetActionResource> list7 = petGlobalConfig$Pet2.pet_action_resources.get();
            Intrinsics.checkNotNullExpressionValue(list7, "pet.pet_action_resources.get()");
            List<PetGlobalConfig$PetActionResource> list8 = list7;
            collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list8, i17);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault5);
            for (PetGlobalConfig$PetActionResource petGlobalConfig$PetActionResource : list8) {
                boolean areEqual2 = Intrinsics.areEqual(petGlobalConfig$Pet2.base_action_type.get(), petGlobalConfig$PetActionResource.action_type.get());
                String str6 = petGlobalConfig$Pet2.pet_type.get();
                Intrinsics.checkNotNullExpressionValue(str6, "pet.pet_type.get()");
                String str7 = petGlobalConfig$PetActionResource.action_type.get();
                Intrinsics.checkNotNullExpressionValue(str7, "action.action_type.get()");
                if (areEqual2) {
                    i3 = -1;
                } else {
                    i3 = i16;
                }
                String str8 = petGlobalConfig$PetActionResource.pet_resource.get();
                List<PetGlobalConfig$SubActionResources> list9 = petGlobalConfig$PetActionResource.sub_action_resources.get();
                Intrinsics.checkNotNullExpressionValue(list9, "action.sub_action_resources.get()");
                List<PetGlobalConfig$SubActionResources> list10 = list9;
                collectionSizeOrDefault6 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list10, i17);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault6);
                for (PetGlobalConfig$SubActionResources petGlobalConfig$SubActionResources : list10) {
                    String str9 = petGlobalConfig$SubActionResources.sub_action_type.get();
                    Iterator it6 = it5;
                    Intrinsics.checkNotNullExpressionValue(str9, "subActionResource.sub_action_type.get()");
                    String str10 = petGlobalConfig$SubActionResources.sub_action_resource.get();
                    Intrinsics.checkNotNullExpressionValue(str10, "subActionResource.sub_action_resource.get()");
                    arrayList4.add(new k(str9, str10, petGlobalConfig$SubActionResources.begin_time.get(), petGlobalConfig$SubActionResources.end_time.get(), petGlobalConfig$SubActionResources.elapse_animation_time.get()));
                    it5 = it6;
                    petGlobalConfig$Pet2 = petGlobalConfig$Pet2;
                }
                arrayList3.add(new e(str6, str7, areEqual2, i3, str8, arrayList4, petGlobalConfig$PetActionResource.decoration_resource.get()));
                it5 = it5;
                petGlobalConfig$Pet2 = petGlobalConfig$Pet2;
                i16 = 1;
                i17 = 10;
            }
            Iterator it7 = it5;
            Pair pair = TuplesKt.to(str5, arrayList3);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
            it5 = it7;
            i16 = 1;
            i17 = 10;
        }
        petType2ActionsMap = linkedHashMap;
        QLog.i("QWallet.Pet.DataManager", 1, "petType2ActionsMap: " + linkedHashMap);
        List<PetGlobalConfig$Cloth> list11 = petGlobalConfig.clothing.get();
        Intrinsics.checkNotNullExpressionValue(list11, "petGlobalConfig.clothing.get()");
        List<PetGlobalConfig$Cloth> list12 = list11;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list12, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault3);
        for (PetGlobalConfig$Cloth petGlobalConfig$Cloth : list12) {
            String str11 = petGlobalConfig$Cloth.f41706id.get();
            Intrinsics.checkNotNullExpressionValue(str11, "clothing.id.get()");
            List<String> list13 = petGlobalConfig$Cloth.pets.get();
            Intrinsics.checkNotNullExpressionValue(list13, "clothing.pets.get()");
            String str12 = petGlobalConfig$Cloth.node_name.get();
            Intrinsics.checkNotNullExpressionValue(str12, "clothing.node_name.get()");
            arrayList5.add(new ClothInfo(str11, list13, str12, null, 8, null));
        }
        clothingList = arrayList5;
        QLog.i("QWallet.Pet.DataManager", 1, "clothingList: " + arrayList5);
        List<PetGlobalConfig$Scene> list14 = petGlobalConfig.scenes.get();
        Intrinsics.checkNotNullExpressionValue(list14, "petGlobalConfig.scenes.get()");
        List<PetGlobalConfig$Scene> list15 = list14;
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list15, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault4);
        for (PetGlobalConfig$Scene petGlobalConfig$Scene : list15) {
            String str13 = petGlobalConfig$Scene.f41708id.get();
            Intrinsics.checkNotNullExpressionValue(str13, "scene.id.get()");
            arrayList6.add(new j(str13, Intrinsics.areEqual(petGlobalConfig$Scene.f41708id.get(), petGlobalConfig.defaults.scene_id.get()), petGlobalConfig$Scene.resource.get()));
        }
        sceneList = arrayList6;
        QLog.i("QWallet.Pet.DataManager", 1, "sceneList: " + arrayList6);
        return true;
    }
}
