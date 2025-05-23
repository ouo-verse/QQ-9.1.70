package com.tencent.mobileqq.wink.edit.manager;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ0\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J*\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u0014\u0010\u0017\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0018j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorStickerResourceManager;", "", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lkotlin/collections/ArrayList;", "effectGroupList", "f", "qqSuperMetaCategory", "", "ignoreCache", "k", tl.h.F, "g", "", "categoryKey", "Lkotlin/Function0;", "fetchCategoryFunc", "j", "fromAttach", "", "l", "", "subCategory", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "metaCategoryCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorStickerResourceManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkEditorStickerResourceManager f318326a = new WinkEditorStickerResourceManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, MetaCategory> metaCategoryCache = new HashMap<>();

    WinkEditorStickerResourceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MetaCategory> f(ArrayList<MetaCategory> effectGroupList) {
        if (effectGroupList.size() > 0) {
            ArrayList<MetaMaterial> m16 = WinkEditorResourceManager.a1().m1(effectGroupList.get(0).materials);
            Intrinsics.checkNotNullExpressionValue(m16, "getInstance().getNewReco\u2026terials\n                )");
            if (m16.size() > 0) {
                effectGroupList.get(0).materials = m16;
            } else {
                effectGroupList.remove(0);
            }
        }
        return effectGroupList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaCategory g() {
        return i.f318439a.g(new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorStickerResourceManager$fetchQQFavoriteMetaCategory$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                invoke2(metaCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MetaCategory metaCategory) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(metaCategory, "metaCategory");
                hashMap = WinkEditorStickerResourceManager.metaCategoryCache;
                hashMap.put("qq_favorite_sticker", metaCategory);
                WinkEditorStickerResourceManager.m(WinkEditorStickerResourceManager.f318326a, false, 1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaCategory h() {
        return i.f318439a.h();
    }

    private final MetaCategory j(boolean ignoreCache, String categoryKey, Function0<MetaCategory> fetchCategoryFunc) {
        HashMap<String, MetaCategory> hashMap = metaCategoryCache;
        MetaCategory metaCategory = hashMap.get(categoryKey);
        if (ignoreCache || metaCategory == null) {
            hashMap.remove(categoryKey);
            MetaCategory invoke = fetchCategoryFunc.invoke();
            if (invoke != null) {
                hashMap.put(categoryKey, invoke);
                return invoke;
            }
        }
        return metaCategory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MetaCategory> k(MetaCategory qqSuperMetaCategory, boolean ignoreCache) {
        ArrayList<MetaCategory> arrayList = new ArrayList<>();
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "qq_sys_face_sticker";
        metaCategory.name = "QQ\u9ec4\u8138\u8868\u60c5";
        ArrayList<MetaCategory> arrayList2 = new ArrayList<>();
        if (qqSuperMetaCategory != null) {
            arrayList2.add(qqSuperMetaCategory);
        }
        WinkEditorStickerResourceManager winkEditorStickerResourceManager = f318326a;
        MetaCategory j3 = winkEditorStickerResourceManager.j(ignoreCache, "qq_small_sticker", new WinkEditorStickerResourceManager$getQQMetaCategoryList$1$1$1(winkEditorStickerResourceManager));
        if (j3 != null) {
            arrayList2.add(j3);
        }
        metaCategory.subCategories = arrayList2;
        arrayList.add(metaCategory);
        MetaCategory j16 = j(ignoreCache, "qq_favorite_sticker", new WinkEditorStickerResourceManager$getQQMetaCategoryList$2(this));
        if (j16 != null) {
            arrayList.add(j16);
        }
        return arrayList;
    }

    public static /* synthetic */ void m(WinkEditorStickerResourceManager winkEditorStickerResourceManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        winkEditorStickerResourceManager.l(z16);
    }

    @NotNull
    public final MetaCategory i(@NotNull List<MetaCategory> subCategory) {
        Intrinsics.checkNotNullParameter(subCategory, "subCategory");
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "search_default";
        metaCategory.name = "\u641c\u7d22";
        metaCategory.subCategories = new ArrayList<>(subCategory);
        return metaCategory;
    }

    public final void l(boolean fromAttach) {
        w53.b.a("WinkEditorResourceManager", "loadSticker... thread: " + Thread.currentThread());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkEditorStickerResourceManager$loadSticker$1(fromAttach, null), 3, null);
    }
}
