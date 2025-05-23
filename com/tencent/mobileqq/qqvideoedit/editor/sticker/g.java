package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.BaseVideEditorFragment;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.model.PointF;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.ttpic.util.GsonUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002\u001a\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u001a\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u00a8\u0006\u001d"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "tavCut", "Lcom/tencent/mobileqq/qqvideoedit/editor/BaseVideEditorFragment;", "editorFragment", "", "d", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", IQQGameCommApi.K_ABTEST_MODELS, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", tl.h.F, "e", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "renderSize", "playerContainerSize", "Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "f", "Lcom/tencent/mobileqq/qqvideoedit/flow/ApplyMaterialTask$a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "l", "j", "Lcom/tencent/mobileqq/qqvideoedit/edit/bean/AEEditorDownloadResBean;", "fontBean", "g", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/sticker/g$a", "Lcom/tencent/mobileqq/qqvideoedit/edit/manager/VideoEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements VideoEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f275830a;

        a(ApplyMaterialTask.a aVar) {
            this.f275830a = aVar;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                this.f275830a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            this.f275830a.a(ApplyMaterialTask.Status.ONGOING, (int) ((progress * 0.33999999999999997d) + 66.0d));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/sticker/g$b", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoPagStickerConfig;", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends TypeToken<VideoPagStickerConfig> {
        b() {
        }
    }

    public static final void c(@NotNull MetaMaterial material, @NotNull aw tavCut, @NotNull BaseVideEditorFragment editorFragment) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        try {
            PagEffectData z16 = od4.b.f422509e.z(h.d(material));
            if (z16 != null) {
                BackgroundModel backgroundModel = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel);
                SizeF sizeF = backgroundModel.renderSize;
                Intrinsics.checkNotNull(sizeF);
                float f16 = 1280;
                float f17 = sizeF.width * f16;
                BackgroundModel backgroundModel2 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel2);
                SizeF sizeF2 = backgroundModel2.renderSize;
                Intrinsics.checkNotNull(sizeF2);
                h.e0(material, (f17 / sizeF2.height) / z16.width);
                h.N(material, 0.0f);
                h.O(material, ((z16.height * h.v(material)) / f16) - 1);
                if (h.f(material) > (-0.33333334f) - ((z16.height * h.v(material)) / f16)) {
                    h.O(material, (-0.33333334f) - ((z16.height * h.v(material)) / f16));
                }
                VideoStickerModel a16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.a.a(z16, StickerLayerIndexManager.f275821a.b(), f(tavCut.getRenderSize(), tavCut.a()), material, 0L, tavCut.getDurationUs(), StickerModel.Type.BOTTOM_FRAME);
                a16.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), h.v(material), h.e(material), h.f(material));
                tavCut.f0(a16);
            }
        } catch (Exception e16) {
            ms.a.e("TextMetaMaterial", e16);
        }
    }

    public static final void d(@NotNull MetaMaterial material, @NotNull aw tavCut, @NotNull BaseVideEditorFragment editorFragment) {
        boolean z16;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        if (h.D(material)) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            h.Z(material, uuid);
            e(material, tavCut, editorFragment);
            c(material, tavCut, editorFragment);
            return;
        }
        PagEffectData z17 = od4.b.f422509e.z(h.t(material));
        if (z17 != null) {
            PointF f16 = f(tavCut.getRenderSize(), tavCut.a());
            if (h.s(material) == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                h.e0(material, h.s(material));
            }
            StickerModel h16 = h(tavCut.e0());
            if (h16 != null && (h16 instanceof VideoStickerModel)) {
                VideoStickerModel videoStickerModel = (VideoStickerModel) h16;
                if (videoStickerModel.getMaterial() != null && !h.p(videoStickerModel.getMaterial())) {
                    h.N(material, videoStickerModel.centerX + 0.020833334f);
                    h.O(material, videoStickerModel.centerY - 0.020833334f);
                }
            }
            VideoStickerModel a16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.a.a(z17, StickerLayerIndexManager.f275821a.b(), f16, material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT);
            float ph5 = (editorFragment.ph() * 1.0f) / editorFragment.getRenderHeight();
            float qh5 = (editorFragment.qh() * 1.0f) / editorFragment.getRenderWidth();
            float min = Math.min(qh5, ph5);
            a16.updatePositionInView((int) (editorFragment.getRenderWidth() * min), (int) (editorFragment.getRenderHeight() * min), h.v(material), h.e(material), h.f(material));
            if (h.C(material)) {
                tavCut.f0(VideoStickerModel.copyAndUpdate$default(a16, null, null, 0L, 0L, 0, Math.max(ph5, qh5), 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -33, 31, null));
            } else {
                tavCut.f0(a16);
            }
        }
    }

    public static final void e(@NotNull MetaMaterial material, @NotNull aw tavCut, @NotNull BaseVideEditorFragment editorFragment) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        try {
            PagEffectData z16 = od4.b.f422509e.z(h.y(material));
            if (z16 != null) {
                BackgroundModel backgroundModel = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel);
                SizeF sizeF = backgroundModel.renderSize;
                Intrinsics.checkNotNull(sizeF);
                float f16 = 1280;
                float f17 = sizeF.width * f16;
                BackgroundModel backgroundModel2 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel2);
                SizeF sizeF2 = backgroundModel2.renderSize;
                Intrinsics.checkNotNull(sizeF2);
                h.e0(material, (f17 / sizeF2.height) / z16.width);
                h.N(material, 0.0f);
                h.O(material, 1 - ((z16.height * h.v(material)) / f16));
                if (h.f(material) < ((z16.height * h.v(material)) / f16) + 0.33333334f) {
                    h.O(material, ((z16.height * h.v(material)) / f16) + 0.33333334f);
                }
                VideoStickerModel a16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.a.a(z16, StickerLayerIndexManager.f275821a.b(), f(tavCut.getRenderSize(), tavCut.a()), material, 0L, tavCut.getDurationUs(), StickerModel.Type.TOP_FRAME);
                a16.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), h.v(material), h.e(material), h.f(material));
                tavCut.f0(a16);
            }
        } catch (Exception e16) {
            ms.a.e("TextMetaMaterial", e16);
        }
    }

    @NotNull
    public static final PointF f(@NotNull Size renderSize, @Nullable Size size) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        if (size != null && (((num = renderSize.height) == null || num.intValue() != 0) && ((num2 = renderSize.width) == null || num2.intValue() != 0))) {
            Intrinsics.checkNotNull(size.height);
            Intrinsics.checkNotNull(renderSize.height);
            float intValue = (r1.intValue() * 1.0f) / r3.intValue();
            Intrinsics.checkNotNull(size.width);
            float intValue2 = r3.intValue() * 1.0f;
            Intrinsics.checkNotNull(renderSize.width);
            if (intValue > intValue2 / r4.intValue()) {
                return new PointF(0.0f, (size.height.intValue() - (((renderSize.height.intValue() * 1.0f) * size.width.intValue()) / renderSize.width.intValue())) * 0.5f);
            }
            return new PointF((size.width.intValue() - (((renderSize.width.intValue() * 1.0f) * size.height.intValue()) / renderSize.height.intValue())) * 0.5f, 0.0f);
        }
        return new PointF(0.0f, 0.0f);
    }

    private static final void g(AEEditorDownloadResBean aEEditorDownloadResBean, ApplyMaterialTask.a aVar) {
        ms.a.a("StickerUtils", "[downloadFont] - BEGIN -");
        VideoEditorResourceManager.L().d(aEEditorDownloadResBean, new a(aVar));
        ms.a.a("StickerUtils", "[downloadFont] - END -");
    }

    private static final StickerModel h(List<MediaModel> list) {
        MediaModel mediaModel;
        Map<String, StickerModel> map;
        StickerModel stickerModel = null;
        if (list != null && list.size() > 0 && (map = (mediaModel = list.get(0)).stickers) != null && (!map.isEmpty())) {
            Iterator<StickerModel> it = mediaModel.stickers.values().iterator();
            while (it.hasNext()) {
                stickerModel = it.next();
            }
        }
        return stickerModel;
    }

    private static final void i(MetaMaterial metaMaterial) {
        ms.a.a("StickerUtils", "[parseTextPagConfig] - BEGIN -");
        String g16 = h.g(metaMaterial);
        if (TextUtils.isEmpty(g16)) {
            ms.a.a("StickerUtils", "[parseTextPagConfig] invalid config json path");
            ms.a.a("StickerUtils", "[parseTextPagConfig] - END -");
        } else {
            h.k0(metaMaterial, (VideoPagStickerConfig) GsonUtils.json2Obj(VideoEditorResourceDownloader.m(g16), new b().getType()));
            ms.a.a("StickerUtils", "[parseTextPagConfig] - END -");
        }
    }

    private static final void j(MetaMaterial metaMaterial, final ApplyMaterialTask.a aVar) {
        ms.a.a("StickerUtils", "[preProcessFontInfo] - BEGIN -");
        final AEEditorDownloadResBean I = VideoEditorResourceManager.L().I(h.k(metaMaterial));
        if (I == null) {
            aVar.a(ApplyMaterialTask.Status.FAILED, -1);
            ms.a.a("StickerUtils", "[preProcessFontInfo] invalid font info");
            ms.a.a("StickerUtils", "[preProcessFontInfo] - END -");
            return;
        }
        if (VideoEditorResourceManager.L().i(I)) {
            ms.a.a("StickerUtils", "[preProcessFontInfo] font file exists");
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        } else {
            ms.a.a("StickerUtils", "[preProcessFontInfo] font file not exists");
            if (VideoEditorResourceManager.L().t(I.getId())) {
                aVar.a(ApplyMaterialTask.Status.FAILED, -1);
                ms.a.a("StickerUtils", "[preProcessFontInfo] used fonts exceeded limit");
                ms.a.a("StickerUtils", "[preProcessFontInfo] - END -");
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.sticker.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.k(AEEditorDownloadResBean.this, aVar);
                }
            }, 128, null, false);
        }
        ms.a.a("StickerUtils", "[preProcessFontInfo] - END -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AEEditorDownloadResBean aEEditorDownloadResBean, ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        g(aEEditorDownloadResBean, callback);
    }

    private static final void l(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        ms.a.a("StickerUtils", "[prepareFontToPag] - BEGIN -");
        if (!TextUtils.isEmpty(h.k(metaMaterial))) {
            ms.a.a("StickerUtils", "[prepareFontToPag] font info configured");
            j(metaMaterial, aVar);
        } else {
            ms.a.a("StickerUtils", "[prepareFontToPag] font info not configured");
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        }
        ms.a.a("StickerUtils", "[prepareFontToPag] - END -");
    }

    public static final void m(@NotNull final MetaMaterial material, @NotNull final ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ms.a.a("StickerUtils", "[prepareTextPag] - BEGIN -");
        if (VideoEditorResourceManager.L().h(material)) {
            ms.a.a("StickerUtils", "[prepareTextPag] pag zip file exists");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.sticker.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.n(MetaMaterial.this, callback);
                }
            }, 64, null, false);
        } else {
            callback.a(ApplyMaterialTask.Status.FAILED, -1);
        }
        ms.a.a("StickerUtils", "[prepareTextPag] - END -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MetaMaterial material, ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        i(material);
        l(material, callback);
    }
}
