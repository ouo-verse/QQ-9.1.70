package com.tencent.mobileqq.wink.edit.manager;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticon.data.IEmoticonInfo;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J)\u0010\u0018\u001a\u00020\u00042!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\rR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/i;", "", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService;", "f", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "d", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "emoticonTabInfo", "", "metaCategoryId", "categoryName", "c", "categoryId", "Lcom/tencent/mobileqq/emoticon/data/IEmoticonInfo;", "picEmoticon", "", "i", tl.h.F, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "metaCategory", "", "stickerCallback", "g", "emoticonInfo", "e", "", "", "b", "[Ljava/lang/Integer;", "FAVORITE_VALID_TYPES", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f318439a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Integer[] FAVORITE_VALID_TYPES = {4, 5};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/i$a", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "", "success", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "tabInfoList", "", "onComplete", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements IEmoticonDataService.UpdateEmoticonInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<MetaCategory, Unit> f318441a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super MetaCategory, Unit> function1) {
            this.f318441a = function1;
        }

        @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService.UpdateEmoticonInfoCallback
        public void onComplete(boolean success, @NotNull List<? extends EmoticonTabInfo> tabInfoList) {
            Object orNull;
            Intrinsics.checkNotNullParameter(tabInfoList, "tabInfoList");
            if (success) {
                Function1<MetaCategory, Unit> function1 = this.f318441a;
                i iVar = i.f318439a;
                orNull = CollectionsKt___CollectionsKt.getOrNull(tabInfoList, 0);
                MetaCategory c16 = iVar.c((EmoticonTabInfo) orNull, "qq_favorite_sticker", "\u6536\u85cf\u8868\u60c5");
                if (c16 == null) {
                    c16 = iVar.d();
                } else if (c16.materials != null) {
                    ArrayList<MetaMaterial> arrayList = c16.materials;
                    c16.materials = new ArrayList<>(arrayList.subList(0, Math.min(24, arrayList.size())));
                }
                function1.invoke(c16);
            }
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaCategory c(EmoticonTabInfo emoticonTabInfo, String metaCategoryId, String categoryName) {
        boolean z16;
        boolean z17;
        boolean z18;
        List<EmoticonInfo> emoticons;
        if (emoticonTabInfo != null && (emoticons = emoticonTabInfo.getEmoticons()) != null && (!emoticons.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<MetaMaterial> arrayList = new ArrayList<>();
            MetaCategory metaCategory = new MetaCategory();
            metaCategory.f30532id = metaCategoryId;
            metaCategory.name = categoryName;
            List<EmoticonInfo> emoticons2 = emoticonTabInfo.getEmoticons();
            Intrinsics.checkNotNullExpressionValue(emoticons2, "emoticonTabInfo.emoticons");
            for (EmoticonInfo emoticonInfo : emoticons2) {
                if (emoticonInfo instanceof IEmoticonInfo) {
                    i iVar = f318439a;
                    if (iVar.i(metaCategoryId, emoticonInfo)) {
                        String thumbImagePath = emoticonInfo.getThumbImagePath();
                        String bigImagePath = emoticonInfo.getBigImagePath();
                        if (thumbImagePath != null && thumbImagePath.length() != 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            if (bigImagePath != null && bigImagePath.length() != 0) {
                                z18 = false;
                            } else {
                                z18 = true;
                            }
                            if (!z18) {
                                MetaMaterial metaMaterial = new MetaMaterial();
                                metaMaterial.f30533id = iVar.e(metaCategoryId, emoticonInfo);
                                com.tencent.mobileqq.wink.editor.sticker.m.T0(metaMaterial, "qq_emoticon_sticker");
                                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, metaCategoryId);
                                com.tencent.mobileqq.wink.editor.c.v1(metaMaterial, bigImagePath);
                                String bigImageURL = emoticonInfo.getBigImageURL();
                                if (bigImageURL == null) {
                                    bigImageURL = "";
                                }
                                com.tencent.mobileqq.wink.editor.c.x1(metaMaterial, bigImageURL);
                                if (!Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(metaMaterial), "qq_small_sticker") && (thumbImagePath = emoticonInfo.getThumbURL()) == null) {
                                    thumbImagePath = "";
                                }
                                metaMaterial.thumbUrl = thumbImagePath;
                                arrayList.add(metaMaterial);
                            }
                        }
                    }
                }
            }
            metaCategory.materials = arrayList;
            return metaCategory;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MetaCategory d() {
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "qq_favorite_sticker";
        metaCategory.name = "\u6536\u85cf\u8868\u60c5";
        metaCategory.materials = new ArrayList<>();
        return metaCategory;
    }

    private final IEmoticonDataService f() {
        try {
            return (IEmoticonDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEmoticonDataService.class, "all");
        } catch (Exception e16) {
            w53.b.c("WinkQQStickerResourceManager", "getEmoticonDataService exception:" + e16.getMessage());
            return null;
        }
    }

    private final boolean i(String categoryId, IEmoticonInfo picEmoticon) {
        boolean contains;
        if (Intrinsics.areEqual(categoryId, "qq_favorite_sticker")) {
            contains = ArraysKt___ArraysKt.contains(FAVORITE_VALID_TYPES, Integer.valueOf(picEmoticon.getEmoticonType()));
            return contains;
        }
        if (Intrinsics.areEqual(categoryId, "qq_small_sticker")) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String e(@NotNull String metaCategoryId, @NotNull IEmoticonInfo emoticonInfo) {
        String name;
        Intrinsics.checkNotNullParameter(metaCategoryId, "metaCategoryId");
        Intrinsics.checkNotNullParameter(emoticonInfo, "emoticonInfo");
        if (Intrinsics.areEqual(metaCategoryId, "qq_favorite_sticker")) {
            return "sticker_qqfavorite";
        }
        if (Intrinsics.areEqual(metaCategoryId, "qq_small_sticker")) {
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                name = "sticker_qqsmall";
            } else {
                name = emoticonInfo.getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "{\n                if (em\u2026          }\n            }");
            return name;
        }
        String name2 = emoticonInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "emoticonInfo.name");
        return name2;
    }

    @NotNull
    public final MetaCategory g(@NotNull Function1<? super MetaCategory, Unit> stickerCallback) {
        Object orNull;
        Intrinsics.checkNotNullParameter(stickerCallback, "stickerCallback");
        IEmoticonDataService f16 = f();
        if (f16 != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(f16.getEmoticonTabInfo(5), 0);
            MetaCategory c16 = c((EmoticonTabInfo) orNull, "qq_favorite_sticker", "\u6536\u85cf\u8868\u60c5");
            if (c16 == null) {
                MetaCategory d16 = d();
                f16.updateEmoticonInfo(5, new a(stickerCallback));
                return d16;
            }
            return c16;
        }
        return d();
    }

    @Nullable
    public final MetaCategory h() {
        List<EmoticonTabInfo> list;
        Object orNull;
        Object orNull2;
        IEmoticonDataService f16 = f();
        boolean z16 = true;
        if (f16 != null) {
            list = f16.getEmoticonTabInfo(1);
        } else {
            list = null;
        }
        if (list != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            EmoticonTabInfo emoticonTabInfo = (EmoticonTabInfo) orNull;
            if (emoticonTabInfo != null) {
                List<EmoticonInfo> emoticons = emoticonTabInfo.getEmoticons();
                Intrinsics.checkNotNullExpressionValue(emoticons, "systemEmoticonTabInfo.emoticons");
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(emoticons, 0);
                EmoticonInfo emoticonInfo = (EmoticonInfo) orNull2;
                if (emoticonInfo != null) {
                    String thumbImagePath = emoticonInfo.getThumbImagePath();
                    if (thumbImagePath != null && thumbImagePath.length() != 0) {
                        z16 = false;
                    }
                    if (!z16 && new File(thumbImagePath).exists()) {
                        return f318439a.c(emoticonTabInfo, "qq_small_sticker", "\u5c0f\u9ec4\u8138\u8868\u60c5");
                    }
                    w53.b.c("WinkQQStickerResourceManager", "the first system emoticon file not exist " + emoticonInfo.getThumbImagePath());
                }
            }
        }
        return null;
    }
}
