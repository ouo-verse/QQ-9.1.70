package com.tencent.videocut.render.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.mobileqq.wink.editor.hdr.g;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.StickerModel;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\n\u0010\u0016\u001a\u00020\u0006*\u00020\u0015J\n\u0010\u0018\u001a\u00020\u0006*\u00020\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/videocut/render/utils/a;", "", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "Lorg/light/lightAssetKit/Entity;", "entity", "", "index", "", "b", AIAbilityModel.AI_KEY, "f", "d", "c", "a", "g", "e", "i", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "editData", "l", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "j", "Lcom/tencent/videocut/model/SpecialEffectModel;", "k", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f384204a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002`\u0005J4\u0010\t\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/videocut/render/utils/a$a", "Ljava/util/Comparator;", "Lkotlin/Pair;", "", "Lcom/tencent/videocut/model/SpecialEffectModel;", "Lkotlin/Comparator;", "pairA", "pairB", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10041a implements Comparator<Pair<? extends String, ? extends SpecialEffectModel>> {
        static IPatchRedirector $redirector_;

        C10041a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@Nullable Pair<String, SpecialEffectModel> pairA, @Nullable Pair<String, SpecialEffectModel> pairB) {
            SpecialEffectModel specialEffectModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pairA, (Object) pairB)).intValue();
            }
            SpecialEffectModel specialEffectModel2 = null;
            if (pairA != null) {
                specialEffectModel = pairA.getSecond();
            } else {
                specialEffectModel = null;
            }
            if (pairB != null) {
                specialEffectModel2 = pairB.getSecond();
            }
            if (specialEffectModel != null && specialEffectModel2 != null) {
                a aVar = a.f384204a;
                return aVar.k(specialEffectModel2) - aVar.k(specialEffectModel);
            }
            return 0;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002`\u0005J4\u0010\t\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/videocut/render/utils/a$b", "Ljava/util/Comparator;", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lkotlin/Comparator;", "pairA", "pairB", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class b implements Comparator<Pair<? extends String, ? extends WinkStickerModel>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@Nullable Pair<String, ? extends WinkStickerModel> pairA, @Nullable Pair<String, ? extends WinkStickerModel> pairB) {
            WinkStickerModel winkStickerModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pairA, (Object) pairB)).intValue();
            }
            WinkStickerModel winkStickerModel2 = null;
            if (pairA != null) {
                winkStickerModel = pairA.getSecond();
            } else {
                winkStickerModel = null;
            }
            if (pairB != null) {
                winkStickerModel2 = pairB.getSecond();
            }
            if (winkStickerModel != null && winkStickerModel2 != null) {
                a aVar = a.f384204a;
                return aVar.j(winkStickerModel) - aVar.j(winkStickerModel2);
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f384204a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void h(a aVar, ICutSession iCutSession, Entity entity, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        aVar.g(iCutSession, entity, i3);
    }

    public final void a(@NotNull ICutSession tavCutSession, @NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tavCutSession, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        int a16 = com.tencent.videocut.render.d.a(tavCutSession, "sticker");
        w53.b.a("render_helper_LakEntityAddHelper", "addAIStickerEntity commonStickerMinIndex " + a16);
        tavCutSession.addVideoSourceEntity(entity, a16);
    }

    public final void b(@NotNull ICutSession tavCutSession, @NotNull Entity entity, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tavCutSession, entity, Integer.valueOf(index));
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        tavCutSession.addVideoSourceEntity(entity, index);
    }

    public final void c(@NotNull ICutSession tavCutSession, @NotNull Entity entity) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tavCutSession, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        int a17 = com.tencent.videocut.render.d.a(tavCutSession, "ai_fragment_sticker");
        if (a17 > -1) {
            a16 = a17;
        } else {
            a16 = com.tencent.videocut.render.d.a(tavCutSession, "sticker");
        }
        w53.b.a("render_helper_LakEntityAddHelper", "addMaskEntity aiStickerMinIndex " + a17 + ",maskStickerIndex " + a16);
        tavCutSession.addVideoSourceEntity(entity, a16);
    }

    public final void d(@NotNull ICutSession tavCutSession, @NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tavCutSession, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        int a16 = com.tencent.videocut.render.d.a(tavCutSession, "mosaic_doodlesticker");
        if (a16 <= -1 && (a16 = com.tencent.videocut.render.d.a(tavCutSession, "mosaic_sticker")) <= -1 && (a16 = com.tencent.videocut.render.d.a(tavCutSession, "ai_fragment_sticker")) <= -1) {
            a16 = com.tencent.videocut.render.d.a(tavCutSession, "sticker");
        }
        w53.b.a("render_helper_LakEntityAddHelper", "addMaskEntity addMosaicDoodleStickerEntity " + a16);
        tavCutSession.addVideoSourceEntity(entity, a16);
    }

    public final void e(@NotNull ICutSession tavCutSession, @NotNull Entity entity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tavCutSession, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (tavCutSession instanceof LAKCutSession) {
            if (g.f320477a.b((LAKCutSession) tavCutSession)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            w53.b.a("render_helper_LakEntityAddHelper", "addSmoothEntity index " + i3);
            tavCutSession.addHDR(entity, i3);
        }
    }

    public final void f(@NotNull ICutSession tavCutSession, @NotNull Entity entity, int effectType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tavCutSession, entity, Integer.valueOf(effectType));
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a("render_helper_LakEntityAddHelper", "addSpecialEffectEntity effectType " + WinkEffectCatType.INSTANCE.a(effectType).name());
        if (effectType == WinkEffectCatType.TypeFace.ordinal()) {
            tavCutSession.addVideoSourceEntityAfterLutFilter(entity);
            return;
        }
        int b16 = com.tencent.videocut.render.d.b(tavCutSession, "face_specialEffect");
        w53.b.a("render_helper_LakEntityAddHelper", "addSpecialEffectEntity faceMaxIndex " + b16);
        if (b16 > -1) {
            tavCutSession.addVideoSourceEntity(entity, b16 + 1);
        } else {
            tavCutSession.addVideoSourceEntityAfterLutFilter(entity);
        }
    }

    public final void g(@NotNull ICutSession tavCutSession, @NotNull Entity entity, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tavCutSession, entity, Integer.valueOf(index));
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        tavCutSession.addVideoSourceEntity(entity, index);
        w53.b.a("render_helper_LakEntityAddHelper", "addStickerEntity index " + index);
    }

    public final void i(@NotNull ICutSession tavCutSession, @NotNull Entity entity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tavCutSession, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (tavCutSession instanceof LAKCutSession) {
            if (g.f320477a.b((LAKCutSession) tavCutSession)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            w53.b.a("render_helper_LakEntityAddHelper", "addSmoothEntity index " + i3);
            tavCutSession.addHDR(entity, i3);
        }
    }

    public final int j(@NotNull WinkStickerModel winkStickerModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) winkStickerModel)).intValue();
        }
        Intrinsics.checkNotNullParameter(winkStickerModel, "<this>");
        StickerModel.Type type = winkStickerModel.type;
        if (type == StickerModel.Type.MOSAIC_DOODLE) {
            return 0;
        }
        if (type == StickerModel.Type.MASK) {
            return 1;
        }
        if (winkStickerModel.isAISticker()) {
            return 2;
        }
        return 3;
    }

    public final int k(@NotNull SpecialEffectModel specialEffectModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) specialEffectModel)).intValue();
        }
        Intrinsics.checkNotNullParameter(specialEffectModel, "<this>");
        Integer num = specialEffectModel.effectType;
        int ordinal = WinkEffectCatType.TypeScreen.ordinal();
        if (num != null && num.intValue() == ordinal) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r2 = kotlin.collections.MapsKt___MapsKt.toList(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        r2 = kotlin.collections.MapsKt___MapsKt.toList(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(@NotNull WinkEditData editData) {
        List<Pair> list;
        MediaModel copy;
        MediaModel copy2;
        List list2;
        List list3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) editData);
            return;
        }
        Intrinsics.checkNotNullParameter(editData, "editData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Map<String, WinkStickerModel> stickerModelMap = editData.getStickerModelMap();
        List<Pair> list4 = null;
        if (stickerModelMap != null && list3 != null) {
            list = CollectionsKt___CollectionsKt.sortedWith(list3, new b());
        } else {
            list = null;
        }
        if (list != null) {
            for (Pair pair : list) {
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        editData.setStickerModelMap(linkedHashMap);
        copy = r4.copy((r39 & 1) != 0 ? r4.id : null, (r39 & 2) != 0 ? r4.name : null, (r39 & 4) != 0 ? r4.version : null, (r39 & 8) != 0 ? r4.createTime : null, (r39 & 16) != 0 ? r4.updateTime : null, (r39 & 32) != 0 ? r4.duration : null, (r39 & 64) != 0 ? r4.videos : null, (r39 & 128) != 0 ? r4.audios : null, (r39 & 256) != 0 ? r4.stickers : linkedHashMap, (r39 & 512) != 0 ? r4.backgroundModel : null, (r39 & 1024) != 0 ? r4.filterModels : null, (r39 & 2048) != 0 ? r4.specialEffects : null, (r39 & 4096) != 0 ? r4.transitions : null, (r39 & 8192) != 0 ? r4.templateModel : null, (r39 & 16384) != 0 ? r4.coverInfo : null, (r39 & 32768) != 0 ? r4.exportSetting : null, (r39 & 65536) != 0 ? r4.openHDR : null, (r39 & 131072) != 0 ? r4.hdrModels : null, (r39 & 262144) != 0 ? r4.smoothModels : null, (r39 & 524288) != 0 ? r4.openSuperHDR : null, (r39 & 1048576) != 0 ? editData.getMediaModel().unknownFields() : null);
        editData.setMediaModel(copy);
        Map<String, SpecialEffectModel> effectModelMap = editData.getEffectModelMap();
        if (effectModelMap != null && list2 != null) {
            list4 = CollectionsKt___CollectionsKt.sortedWith(list2, new C10041a());
        }
        if (list4 != null) {
            for (Pair pair2 : list4) {
                linkedHashMap2.put(pair2.getFirst(), pair2.getSecond());
            }
        }
        editData.setEffectModelMap(linkedHashMap2);
        copy2 = r14.copy((r39 & 1) != 0 ? r14.id : null, (r39 & 2) != 0 ? r14.name : null, (r39 & 4) != 0 ? r14.version : null, (r39 & 8) != 0 ? r14.createTime : null, (r39 & 16) != 0 ? r14.updateTime : null, (r39 & 32) != 0 ? r14.duration : null, (r39 & 64) != 0 ? r14.videos : null, (r39 & 128) != 0 ? r14.audios : null, (r39 & 256) != 0 ? r14.stickers : null, (r39 & 512) != 0 ? r14.backgroundModel : null, (r39 & 1024) != 0 ? r14.filterModels : null, (r39 & 2048) != 0 ? r14.specialEffects : linkedHashMap2, (r39 & 4096) != 0 ? r14.transitions : null, (r39 & 8192) != 0 ? r14.templateModel : null, (r39 & 16384) != 0 ? r14.coverInfo : null, (r39 & 32768) != 0 ? r14.exportSetting : null, (r39 & 65536) != 0 ? r14.openHDR : null, (r39 & 131072) != 0 ? r14.hdrModels : null, (r39 & 262144) != 0 ? r14.smoothModels : null, (r39 & 524288) != 0 ? r14.openSuperHDR : null, (r39 & 1048576) != 0 ? editData.getMediaModel().unknownFields() : null);
        editData.setMediaModel(copy2);
    }
}
