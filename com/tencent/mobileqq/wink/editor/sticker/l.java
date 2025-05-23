package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import androidx.exifinterface.media.ExifInterface;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.sticker.g;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioItem;
import com.tencent.mobileqq.wink.editor.tts.source.TTSInterfaceDataSource;
import com.tencent.mobileqq.wink.editor.tts.source.a;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.util.MatrixTransform;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.ImageType;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.ScreenTransform;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u000e\u001a\u00020\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b\u001a \u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a~\u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u001e\u001a.\u0010'\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019\u001aF\u0010*\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010(\u001a\u001e\u0010,\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0012\u001aH\u00101\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b\u001aP\u00105\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b\u001a4\u00106\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019\u001a*\u00108\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0012\u001a\u001e\u00109\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010:\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010;\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010>\u001a\u00020\u00172\u0006\u00103\u001a\u00020<2\u0006\u0010=\u001a\u00020<\u001a\u0016\u0010?\u001a\u00020\u00172\u0006\u00103\u001a\u0002022\u0006\u0010=\u001a\u000202\u001a\u0016\u0010B\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@\u001a\u0016\u0010C\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@\u001a\u0016\u0010D\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@\u001a(\u0010J\u001a\u00020\u0012*\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u00062\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H0G\u001a\u0010\u0010K\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u000e\u0010L\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0018\u0010M\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@H\u0002\u001a\u0018\u0010N\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@H\u0002\u001a \u0010Q\u001a\u00020\r2\u0006\u0010P\u001a\u00020O2\u0006\u0010A\u001a\u00020@2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010R\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u000e\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020S\u001a\u000e\u0010V\u001a\u00020\u00062\u0006\u0010T\u001a\u00020S\u001a\u000e\u0010W\u001a\u00020\u00062\u0006\u0010+\u001a\u00020E\u001a\u000e\u0010X\u001a\u00020\u00062\u0006\u0010T\u001a\u00020S\u001a\u000e\u0010Y\u001a\u00020\u00062\u0006\u0010T\u001a\u00020S\u001a&\u0010^\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010]\u001a\u00020\\\u00a8\u0006_"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCut", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "editorFragment", "", "imagePath", "", "width", "height", "", "isSegment", "", "f", "mosaicImagePath", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", BdhLogUtil.LogTag.Tag_Conn, tl.h.F, "g", "layerIndex", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "originInView", "", "startTimeUs", "durationUs", "Lcom/tencent/videocut/model/StickerModel$Type;", "type", "", "postCropScale", "postCropTranslateY", "Lcom/tencent/videocut/model/ImageType;", NodeProps.CUSTOM_PROP_IMAGE_TYPE, BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "D", "startUs", "j", "Lkotlin/Function1;", "beforeUpdate", "k", "stickerModel", "P", "renderWidth", "renderHeight", "limitWidth", "updatePositionInView", "r", "Lcom/tencent/videocut/model/SizeF;", "renderSize", "containerSizeF", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "referenceSticker", "v", "l", "e", "i", "Lcom/tencent/videocut/model/Size;", "playerContainerSize", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "M", "K", "I", "Lcom/tencent/videocut/model/StickerModel;", "pagPath", "", "", "extra", "O", UserInfo.SEX_FEMALE, "B", "J", "G", "Lcom/tencent/mobileqq/wink/edit/bean/AEEditorDownloadResBean;", "fontBean", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "winkEditData", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "w", HippyTKDListViewAdapter.X, DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "stickerStartUs", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "pagEffectData", "y", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f321742a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f321743b;

        static {
            int[] iArr = new int[ImageType.values().length];
            try {
                iArr[ImageType.APNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageType.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageType.COMMON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f321742a = iArr;
            int[] iArr2 = new int[StickerModel.Type.values().length];
            try {
                iArr2[StickerModel.Type.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[StickerModel.Type.TEXT_TEMPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[StickerModel.Type.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[StickerModel.Type.MASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f321743b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/l$b", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorResourceDownloader.d {

        /* renamed from: a */
        final /* synthetic */ MetaMaterial f321744a;

        /* renamed from: b */
        final /* synthetic */ ApplyMaterialTask.a f321745b;

        b(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
            this.f321744a = metaMaterial;
            this.f321745b = aVar;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                m.U0(this.f321744a);
                this.f321745b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            this.f321745b.a(ApplyMaterialTask.Status.ONGOING, (int) ((progress * 0.33999999999999997d) + 66.0d));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/l$c", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkPagStickerConfig;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends TypeToken<WinkPagStickerConfig> {
        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/l$d", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkPagStickerConfig;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends TypeToken<WinkPagStickerConfig> {
        d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/l$f", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ResDownLoadListener {

        /* renamed from: a */
        final /* synthetic */ MetaMaterial f321747a;

        /* renamed from: b */
        final /* synthetic */ ApplyMaterialTask.a f321748b;

        f(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
            this.f321747a = metaMaterial;
            this.f321748b = aVar;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            ms.a.a("StickerUtils", "[prepareTextsPag] - onDownloadFinish -");
            WinkEditorResourceManager.a1().i0(this.f321747a);
            m.Q0(this.f321747a, true);
            this.f321748b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            this.f321748b.a(ApplyMaterialTask.Status.ONGOING, progress);
        }
    }

    @NotNull
    public static final String A(@NotNull WinkEditData winkEditData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
        HashMap hashMap = new HashMap();
        Iterator<T> it = winkEditData.getMediaModel().stickers.values().iterator();
        while (it.hasNext()) {
            String N = N((StickerModel) it.next());
            if (hashMap.containsKey(N)) {
                Integer num = (Integer) hashMap.get(N);
                if (num == null) {
                    num = 0;
                }
                hashMap.put(N, Integer.valueOf(num.intValue() + 1));
            } else {
                hashMap.put(N, 1);
            }
        }
        String str = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            str = ((Object) str) + entry.getKey() + ":" + entry.getValue() + ",";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return "{" + ((Object) str) + "}";
    }

    public static final boolean B(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        ms.a.a("StickerUtils", "[isCustomSticker] - BEGIN -");
        String k3 = m.k(material);
        if (TextUtils.isEmpty(k3)) {
            ms.a.a("StickerUtils", "[isCustomSticker] invalid config json path");
            ms.a.a("StickerUtils", "[isCustomSticker] - END -");
            return Intrinsics.areEqual("sticker_custom", material.f30533id);
        }
        WinkPagStickerConfig winkPagStickerConfig = (WinkPagStickerConfig) GsonUtils.json2Obj(WinkEditorResourceDownloader.y(k3), new c().getType());
        ms.a.a("StickerUtils", "[isCustomSticker] - END -");
        if (winkPagStickerConfig != null) {
            return Intrinsics.areEqual(winkPagStickerConfig.type, "custom_sticker");
        }
        return false;
    }

    @Nullable
    public static final WinkStickerModel C(@NotNull dr tavCut, @NotNull String mosaicImagePath, @NotNull MediaClip mediaClip) {
        String str;
        int i3;
        float height;
        float f16;
        Bitmap m3;
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(mosaicImagePath, "mosaicImagePath");
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        Size h16 = com.tencent.mobileqq.wink.utils.f.h(mosaicImagePath);
        RectF rectF = null;
        if (h16 == null) {
            return null;
        }
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            rectF = resourceModel.picClipRect;
        }
        if ((!mediaClip.matrix.isEmpty()) && rectF != null) {
            Bitmap c16 = com.tencent.mobileqq.wink.utils.f.c(mosaicImagePath);
            SizeF sizeF = mediaClip.resource.size;
            if (sizeF == null) {
                m3 = c16;
            } else {
                m3 = com.tencent.mobileqq.wink.utils.f.m(c16, sizeF.width, sizeF.height);
            }
            Size size = new Size((int) Math.abs(rectF.left - rectF.right), (int) Math.abs(rectF.top - rectF.bottom));
            Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), m3.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Matrix transListMatrixToMatrix = MatrixTransform.transListMatrixToMatrix(mediaClip.matrix);
            transListMatrixToMatrix.postTranslate(-rectF.left, -rectF.top);
            canvas.drawBitmap(m3, transListMatrixToMatrix, new Paint());
            String str2 = u53.d.f438381a;
            String str3 = File.separator;
            String str4 = str2 + str3 + "mosaic_doodle_stickers" + str3 + System.currentTimeMillis() + ".png";
            com.tencent.mobileqq.wink.utils.f.v(str4, createBitmap, Bitmap.CompressFormat.PNG, 100);
            c16.recycle();
            m3.recycle();
            createBitmap.recycle();
            str = str4;
            h16 = size;
        } else {
            str = mosaicImagePath;
        }
        Integer num = tavCut.getRenderSize().width;
        int i16 = 0;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (tavCut.G() && i3 != 0) {
            i16 = (int) ((i3 / 960.0f) * 1280);
        } else {
            Integer num2 = tavCut.getRenderSize().height;
            if (num2 != null) {
                i16 = num2.intValue();
            }
        }
        int i17 = i16;
        MetaMaterial metaMaterial = new MetaMaterial();
        m.F0(metaMaterial, mosaicImagePath);
        float f17 = i3;
        float f18 = i17;
        if (h16.getWidth() / h16.getHeight() > f17 / f18) {
            f16 = (f17 * 1280) / f18;
            height = h16.getWidth();
        } else {
            height = h16.getHeight();
            f16 = 1280.0f;
        }
        m.G0(metaMaterial, f16 / height);
        WinkStickerModel D = D(-10000, n(tavCut.getRenderSize(), tavCut.a()), metaMaterial, 0L, tavCut.getDurationUs(), StickerModel.Type.MOSAIC_DOODLE, 1.0f, 0.0f, str, ImageType.COMMON, h16.getWidth(), h16.getHeight(), m.A(metaMaterial), m.A(metaMaterial));
        D.updatePositionInView(i3, i17, m.A(metaMaterial), m.A(metaMaterial), m.i(metaMaterial), m.j(metaMaterial));
        return D;
    }

    @NotNull
    public static final WinkStickerModel D(int i3, @NotNull PointF originInView, @NotNull MetaMaterial material, long j3, long j16, @NotNull StickerModel.Type type, float f16, float f17, @NotNull String imagePath, @NotNull ImageType imageType, int i16, int i17, float f18, float f19) {
        List emptyList;
        Intrinsics.checkNotNullParameter(originInView, "originInView");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        String uuid = UUID.randomUUID().toString();
        AnimationMode animationMode = AnimationMode.LOOP;
        String id5 = material.f30533id;
        StickerModel.ActionType actionType = StickerModel.ActionType.NONE;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        return new WinkStickerModel(uuid, imagePath, j3, j16, i3, f18, f19, 0.0f, 0.0f, 0.0f, true, i16, i17, 0.18f, 1.0f, emptyList, "", 0, animationMode, type, id5, null, 0, 0, -1L, actionType, null, null, null, 0.0f, null, imageType, null, 0.4f, 0.0f, originInView, null, null, null, null, material, null, null, null, null, false, null, null, false, f16, f17, null, false, 2095054848, 1703669, null);
    }

    public static /* synthetic */ WinkStickerModel E(int i3, PointF pointF, MetaMaterial metaMaterial, long j3, long j16, StickerModel.Type type, float f16, float f17, String str, ImageType imageType, int i16, int i17, float f18, float f19, int i18, Object obj) {
        float f26;
        float f27;
        float f28;
        float f29;
        if ((i18 & 64) != 0) {
            f26 = 1.0f;
        } else {
            f26 = f16;
        }
        if ((i18 & 128) != 0) {
            f27 = 0.0f;
        } else {
            f27 = f17;
        }
        if ((i18 & 4096) != 0) {
            f28 = 0.4f;
        } else {
            f28 = f18;
        }
        if ((i18 & 8192) != 0) {
            f29 = 0.4f;
        } else {
            f29 = f19;
        }
        return D(i3, pointF, metaMaterial, j3, j16, type, f26, f27, str, imageType, i16, i17, f28, f29);
    }

    private static final void F(MetaMaterial metaMaterial) {
        ms.a.a("StickerUtils", "[parseTextPagConfig] - BEGIN -");
        String k3 = m.k(metaMaterial);
        if (TextUtils.isEmpty(k3)) {
            ms.a.a("StickerUtils", "[parseTextPagConfig] invalid config json path");
            ms.a.a("StickerUtils", "[parseTextPagConfig] - END -");
        } else {
            m.V0(metaMaterial, (WinkPagStickerConfig) GsonUtils.json2Obj(WinkEditorResourceDownloader.y(k3), new d().getType()));
            ms.a.a("StickerUtils", "[parseTextPagConfig] - END -");
        }
    }

    private static final void G(final MetaMaterial metaMaterial, final ApplyMaterialTask.a aVar) {
        ms.a.a("StickerUtils", "[preProcessFontInfo] - BEGIN -");
        final AEEditorDownloadResBean W0 = WinkEditorResourceManager.a1().W0(m.q(metaMaterial));
        if (W0 == null) {
            aVar.a(ApplyMaterialTask.Status.FAILED, -1);
            ms.a.a("StickerUtils", "[preProcessFontInfo] invalid font info");
            ms.a.a("StickerUtils", "[preProcessFontInfo] - END -");
        } else {
            if (WinkEditorResourceManager.a1().r(W0)) {
                ms.a.a("StickerUtils", "[preProcessFontInfo] font file exists");
                aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                ms.a.a("StickerUtils", "[preProcessFontInfo] font file not exists");
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.H(AEEditorDownloadResBean.this, aVar, metaMaterial);
                    }
                }, 128, null, false);
            }
            ms.a.a("StickerUtils", "[preProcessFontInfo] - END -");
        }
    }

    public static final void H(AEEditorDownloadResBean aEEditorDownloadResBean, ApplyMaterialTask.a callback, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(material, "$material");
        p(aEEditorDownloadResBean, callback, material);
    }

    public static final void I(@NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (new File(com.tencent.mobileqq.wink.editor.c.H(material)).exists()) {
            callback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            return;
        }
        String J = com.tencent.mobileqq.wink.editor.c.J(material);
        if (J != null && J.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            com.tencent.mobileqq.wink.downloader.b.f318210a.b(com.tencent.mobileqq.wink.editor.c.J(material), com.tencent.mobileqq.wink.editor.c.H(material), new e(callback));
            return;
        }
        String str = material.thumbUrl;
        Intrinsics.checkNotNullExpressionValue(str, "material.thumbUrl");
        com.tencent.mobileqq.wink.editor.c.v1(material, str);
        callback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }

    private static final void J(MetaMaterial metaMaterial, ApplyMaterialTask.a aVar) {
        ms.a.a("StickerUtils", "[prepareFontToPag] - BEGIN -");
        if (!TextUtils.isEmpty(m.q(metaMaterial))) {
            ms.a.a("StickerUtils", "[prepareFontToPag] font info configured");
            G(metaMaterial, aVar);
        } else {
            ms.a.a("StickerUtils", "[prepareFontToPag] font info not configured");
            aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        }
        ms.a.a("StickerUtils", "[prepareFontToPag] - END -");
    }

    public static final void K(@NotNull final MetaMaterial material, @NotNull final ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ms.a.a("StickerUtils", "[prepareTextPag] - BEGIN -");
        if (WinkEditorResourceManager.a1().q(material)) {
            ms.a.a("StickerUtils", "[prepareTextPag] pag zip file exists");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.L(MetaMaterial.this, callback);
                }
            }, 64, null, false);
        } else {
            callback.a(ApplyMaterialTask.Status.FAILED, -1);
        }
        ms.a.a("StickerUtils", "[prepareTextPag] - END -");
    }

    public static final void L(MetaMaterial material, ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        F(material);
        J(material, callback);
    }

    public static final void M(@NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ms.a.a("StickerUtils", "\u591a\u5751\u4f4d [prepareTextsPag] - BEGIN -");
        WinkEditorResourceManager.a1().h0(material, new f(material, callback));
    }

    @NotNull
    public static final String N(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        int i3 = a.f321743b[stickerModel.type.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    int i16 = a.f321742a[stickerModel.imageType.ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (stickerModel.watermarkModel != null && (!r5.isEmpty())) {
                                    return "dataSource";
                                }
                                return "fixText";
                            }
                            return "image_static";
                        }
                        return "image_gif";
                    }
                    return "image_apng";
                }
                return "blur";
            }
            return "custom";
        }
        return "text";
    }

    @NotNull
    public static final WinkStickerModel O(@NotNull StickerModel stickerModel, @Nullable String str, @NotNull Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Intrinsics.checkNotNullParameter(extra, "extra");
        w53.b.a("wink_sticker_TextMetaMaterial", "toDefaultWinkStickerModel: " + str);
        return new WinkStickerModel(stickerModel.id, stickerModel.filePath, stickerModel.startTime, stickerModel.duration, stickerModel.layerIndex, stickerModel.scaleX, stickerModel.scaleY, stickerModel.rotate, stickerModel.centerX, stickerModel.centerY, stickerModel.editable, stickerModel.width, stickerModel.height, stickerModel.minScale, stickerModel.maxScale, stickerModel.textItems, stickerModel.thumbUrl, stickerModel.timelineTrackIndex, stickerModel.animationMode, stickerModel.type, stickerModel.materialId, stickerModel.captionInfo, stickerModel.localThumbId, stickerModel.editingLayerIndex, stickerModel.playEndDuration, stickerModel.actionType, stickerModel.bgConfig, stickerModel.bgPath, stickerModel.configType, stickerModel.frameScale, stickerModel.watermarkModel, stickerModel.imageType, stickerModel.unknownFields(), 0.0f, 0.0f, null, null, null, null, null, m.c0(stickerModel, str, extra), null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, 0, 2096894, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo, T] */
    public static final void P(@NotNull final WinkEditorFragment editorFragment, @NotNull final dr tavCut, @NotNull final WinkStickerModel stickerModel) {
        String l3;
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        final TTSInterfaceDataSource X1 = editorFragment.Ik().X1();
        TTSAudioInfo ttsAudioInfo = stickerModel.getTtsAudioInfo();
        if (ttsAudioInfo != null) {
            ArrayList arrayList = new ArrayList();
            MetaMaterial material = stickerModel.getMaterial();
            if (material != null && (l3 = m.l(material)) != null) {
                arrayList.add(l3);
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            ?? tTSAudioInfo = new TTSAudioInfo((String[]) array, ttsAudioInfo.getTemplateType(), ttsAudioInfo.getVolume(), ttsAudioInfo.getStickerId());
            objectRef.element = tTSAudioInfo;
            tTSAudioInfo.setDisplayName(ttsAudioInfo.getDisplayName());
            String[] texts = ((TTSAudioInfo) objectRef.element).getTexts();
            Intrinsics.checkNotNull(texts);
            X1.u(texts, ((TTSAudioInfo) objectRef.element).getTemplateType(), new com.tencent.mobileqq.wink.editor.tts.source.a() { // from class: com.tencent.mobileqq.wink.editor.sticker.h
                @Override // com.tencent.mobileqq.wink.editor.tts.source.a
                public final void a(int i3, TTSAudioItem[] tTSAudioItemArr) {
                    l.Q(Ref.ObjectRef.this, stickerModel, X1, editorFragment, tavCut, i3, tTSAudioItemArr);
                }
            });
            stickerModel.setTtsAudioInfo((TTSAudioInfo) objectRef.element);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Q(Ref.ObjectRef ttsNewAudioInfo, final WinkStickerModel stickerModel, TTSInterfaceDataSource tTSInterfaceDataSource, final WinkEditorFragment editorFragment, final dr tavCut, int i3, final TTSAudioItem[] audioItems) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ttsNewAudioInfo, "$ttsNewAudioInfo");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        Intrinsics.checkNotNullParameter(editorFragment, "$editorFragment");
        Intrinsics.checkNotNullParameter(tavCut, "$tavCut");
        ms.a.a("wink_sticker_TextMetaMaterial", "code : " + i3 + ", size: " + audioItems.length);
        if (i3 == 1000001) {
            Intrinsics.checkNotNullExpressionValue(audioItems, "audioItems");
            if (audioItems.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ((TTSAudioInfo) ttsNewAudioInfo.element).setAudioItems(audioItems);
                TTSAudioItem tTSAudioItem = audioItems[0];
                if (tTSAudioItem != null) {
                    tTSAudioItem.setStartTime(stickerModel.startTime);
                }
                tTSInterfaceDataSource.l((TTSAudioInfo) ttsNewAudioInfo.element, new a.InterfaceC9047a() { // from class: com.tencent.mobileqq.wink.editor.sticker.i
                    @Override // com.tencent.mobileqq.wink.editor.tts.source.a.InterfaceC9047a
                    public final void a(int i16, boolean[] zArr, int i17) {
                        l.R(dr.this, audioItems, stickerModel, editorFragment, i16, zArr, i17);
                    }
                });
                return;
            }
        }
        o73.a Kk = editorFragment.Kk();
        if (Kk != null) {
            Kk.w3();
        }
    }

    public static final void R(dr tavCut, TTSAudioItem[] tTSAudioItemArr, WinkStickerModel stickerModel, WinkEditorFragment editorFragment, int i3, boolean[] zArr, int i16) {
        String str;
        long j3;
        float f16;
        long j16;
        AudioInfo audioInfo;
        Intrinsics.checkNotNullParameter(tavCut, "$tavCut");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        Intrinsics.checkNotNullParameter(editorFragment, "$editorFragment");
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) tavCut;
        TTSAudioItem tTSAudioItem = tTSAudioItemArr[0];
        String str2 = null;
        if (tTSAudioItem != null) {
            str = tTSAudioItem.getLocalPath();
        } else {
            str = null;
        }
        String valueOf = String.valueOf(str);
        TTSAudioItem tTSAudioItem2 = tTSAudioItemArr[0];
        if (tTSAudioItem2 != null && (audioInfo = tTSAudioItem2.getAudioInfo()) != null) {
            str2 = audioInfo.MD5;
        }
        String valueOf2 = String.valueOf(str2);
        TTSAudioItem tTSAudioItem3 = tTSAudioItemArr[0];
        if (tTSAudioItem3 != null) {
            j3 = tTSAudioItem3.getDuration();
        } else {
            j3 = 0;
        }
        String str3 = stickerModel.id;
        TTSAudioItem tTSAudioItem4 = tTSAudioItemArr[0];
        if (tTSAudioItem4 != null) {
            f16 = tTSAudioItem4.getVolume();
        } else {
            f16 = 1.0f;
        }
        float f17 = f16;
        TTSAudioItem tTSAudioItem5 = tTSAudioItemArr[0];
        if (tTSAudioItem5 != null) {
            j16 = tTSAudioItem5.getStartTime();
        } else {
            j16 = 0;
        }
        winkVideoTavCut.Q0(valueOf, valueOf2, j3, str3, f17, j16);
        o73.a Kk = editorFragment.Kk();
        if (Kk != null) {
            Kk.w3();
        }
    }

    public static final void e(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment) {
        SizeF m3;
        long durationUs;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        try {
            PagEffectData A = rd4.c.f431135f.A(m.h(material));
            if (A != null) {
                BackgroundModel backgroundModel = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel);
                SizeF sizeF = backgroundModel.renderSize;
                Intrinsics.checkNotNull(sizeF);
                Float valueOf = Float.valueOf(sizeF.width);
                BackgroundModel backgroundModel2 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel2);
                SizeF sizeF2 = backgroundModel2.renderSize;
                Intrinsics.checkNotNull(sizeF2);
                Pair pair = new Pair(valueOf, Float.valueOf(sizeF2.height));
                float f16 = 1280;
                m.G0(material, (((((Number) pair.component1()).floatValue() + ViewUtils.dpToPx(1.0f)) * f16) / ((Number) pair.component2()).floatValue()) / A.getWidth());
                float A2 = m.A(material);
                m.k0(material, 0.0f);
                m.l0(material, ((A.getHeight() * m.A(material)) / f16) - 1);
                if (tavCut.G()) {
                    m3 = new SizeF(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), null, 4, null);
                } else {
                    m3 = m(tavCut);
                }
                float renderWidth = (m3.height / m3.width) * (-1.0f) * (editorFragment.getRenderWidth() / editorFragment.getRenderHeight());
                m.l0(material, (((A.getHeight() - ViewUtils.dpToPx(1.0f)) * m.A(material)) / f16) + Math.max(renderWidth, -1.0f));
                PointF n3 = n(tavCut.getRenderSize(), tavCut.a());
                int b16 = StickerLayerIndexManager.f321548a.b();
                IPlayer currentPlayer = tavCut.getCurrentPlayer();
                if (currentPlayer != null) {
                    durationUs = currentPlayer.getDurationUs();
                } else {
                    durationUs = tavCut.getDurationUs();
                }
                WinkStickerModel a16 = com.tencent.mobileqq.wink.editor.sticker.d.a(A, b16, n3, material, 0L, durationUs, StickerModel.Type.BOTTOM_FRAME, -renderWidth, (-1) - renderWidth);
                a16.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), A2, A2, m.i(material), m.j(material));
                dr.b.n(tavCut, a16, false, 2, null);
            }
        } catch (Exception e16) {
            ms.a.e("wink_sticker_TextMetaMaterial", e16);
        }
    }

    public static final void f(@Nullable MetaMaterial metaMaterial, @Nullable dr drVar, @Nullable WinkEditorFragment winkEditorFragment, @NotNull String imagePath, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        if (metaMaterial != null && drVar != null && winkEditorFragment != null) {
            PagEffectData A = rd4.c.f431135f.A(m.y(metaMaterial));
            if (A != null) {
                WinkStickerModel E = E(StickerLayerIndexManager.f321548a.b(), n(drVar.getRenderSize(), drVar.a()), metaMaterial, 0L, drVar.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, imagePath, ImageType.COMMON, A.getWidth(), A.getHeight(), 0.0f, 0.0f, 12288, null);
                float f16 = i3 / i16;
                if (f16 > 1.0f) {
                    E.height = (int) (E.width / f16);
                } else {
                    E.width = (int) (E.height * f16);
                }
                if (!z16) {
                    E.frameScale = 1.1f;
                }
                E.updatePositionInView(winkEditorFragment.getRenderWidth(), winkEditorFragment.getRenderHeight(), m.A(metaMaterial), m.A(metaMaterial), m.i(metaMaterial), m.j(metaMaterial));
                dr.b.n(drVar, E, false, 2, null);
                return;
            }
            return;
        }
        ms.a.c("wink_sticker_TextMetaMaterial", "addSticker, params is null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00af, code lost:
    
        if (r4 != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dd, code lost:
    
        if (r4 != false) goto L151;
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0157: MOVE (r15 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:344), block:B:74:0x0156 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment) {
        Throwable th5;
        InputStream inputStream;
        FileInputStream fileInputStream;
        BitmapFactory.Options c16;
        boolean z16;
        int i3;
        boolean z17;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        ImageType fromValue = ImageType.INSTANCE.fromValue(com.tencent.mobileqq.wink.editor.c.I(material));
        if (fromValue == null || fromValue == ImageType.UNKNOWN) {
            fromValue = an.f326680a.g(com.tencent.mobileqq.wink.editor.c.H(material));
            com.tencent.mobileqq.wink.editor.c.w1(material, fromValue.getValue());
        }
        ImageType imageType = fromValue;
        ms.a.a("wink_sticker_TextMetaMaterial", "addEmojiSticker,  image type is " + imageType + " " + com.tencent.mobileqq.wink.editor.c.H(material));
        if (imageType == ImageType.UNKNOWN) {
            ms.a.c("wink_sticker_TextMetaMaterial", "addEmojiSticker, unknown image type " + com.tencent.mobileqq.wink.editor.c.H(material));
            return;
        }
        int i16 = 187;
        InputStream inputStream2 = null;
        boolean z18 = true;
        try {
            if (imageType == ImageType.GIF) {
                try {
                    com.tencent.mobileqq.activity.aio.stickerbubble.frame.c cVar = new com.tencent.mobileqq.activity.aio.stickerbubble.frame.c(new File(com.tencent.mobileqq.wink.editor.c.H(material)), false);
                    int height = cVar.getHeight();
                    int width = cVar.getWidth();
                    if (1 <= height && height < 61) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (1 > width || width >= 61) {
                            z18 = false;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                i3 = 375;
                WinkStickerModel E = E(StickerLayerIndexManager.f321548a.b(), n(tavCut.getRenderSize(), tavCut.a()), material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, com.tencent.mobileqq.wink.editor.c.H(material), imageType, i3, i3, 0.0f, 0.0f, 12288, null);
                E.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), 0.4f, 0.4f, 0.0f, 0.0f);
                dr.b.n(tavCut, E, false, 2, null);
            }
            try {
                c16 = com.tencent.open.base.b.c();
                c16.inJustDecodeBounds = true;
                fileInputStream = new FileInputStream(com.tencent.mobileqq.wink.editor.c.H(material));
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        throw th5;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        throw th5;
                    }
                }
                throw th5;
            }
            try {
                BitmapFactory.decodeStream(fileInputStream, null, c16);
                int i17 = c16.outHeight;
                int i18 = c16.outWidth;
                if (1 <= i17 && i17 < 61) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (1 > i18 || i18 >= 61) {
                        z18 = false;
                    }
                }
                i16 = 375;
                try {
                    fileInputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                i3 = i16;
            } catch (Exception e26) {
                e = e26;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                i3 = 375;
                WinkStickerModel E2 = E(StickerLayerIndexManager.f321548a.b(), n(tavCut.getRenderSize(), tavCut.a()), material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, com.tencent.mobileqq.wink.editor.c.H(material), imageType, i3, i3, 0.0f, 0.0f, 12288, null);
                E2.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), 0.4f, 0.4f, 0.0f, 0.0f);
                dr.b.n(tavCut, E2, false, 2, null);
            }
            WinkStickerModel E22 = E(StickerLayerIndexManager.f321548a.b(), n(tavCut.getRenderSize(), tavCut.a()), material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, com.tencent.mobileqq.wink.editor.c.H(material), imageType, i3, i3, 0.0f, 0.0f, 12288, null);
            E22.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), 0.4f, 0.4f, 0.0f, 0.0f);
            dr.b.n(tavCut, E22, false, 2, null);
        } catch (Throwable th7) {
            th5 = th7;
            inputStream2 = inputStream;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void h(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment) {
        Throwable th5;
        FileInputStream fileInputStream;
        int i3;
        int i16;
        BitmapFactory.Options c16;
        int i17;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        ImageType fromValue = ImageType.INSTANCE.fromValue(com.tencent.mobileqq.wink.editor.c.I(material));
        if (fromValue == null || fromValue == ImageType.UNKNOWN) {
            fromValue = an.f326680a.g(com.tencent.mobileqq.wink.editor.c.H(material));
            com.tencent.mobileqq.wink.editor.c.w1(material, fromValue.getValue());
        }
        ImageType imageType = fromValue;
        ms.a.a("wink_sticker_TextMetaMaterial", "addFavoritesSticker,  image type is " + imageType + " " + com.tencent.mobileqq.wink.editor.c.H(material));
        if (imageType == ImageType.UNKNOWN) {
            ms.a.c("wink_sticker_TextMetaMaterial", "addFavoritesSticker, unknown image type " + com.tencent.mobileqq.wink.editor.c.H(material));
            return;
        }
        PointF n3 = n(tavCut.getRenderSize(), tavCut.a());
        InputStream inputStream = null;
        int i18 = 800;
        try {
            try {
                c16 = com.tencent.open.base.b.c();
                c16.inJustDecodeBounds = true;
                fileInputStream = new FileInputStream(com.tencent.mobileqq.wink.editor.c.H(material));
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (inputStream == null) {
                }
            }
            try {
                BitmapFactory.decodeStream(fileInputStream, null, c16);
                float f16 = c16.outHeight / c16.outWidth;
                if (f16 > 1.0f) {
                    int i19 = (int) (800 / f16);
                    i17 = 800;
                    i18 = i19;
                } else {
                    i17 = (int) (800 * f16);
                }
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                i3 = i18;
                i16 = i17;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                i3 = 800;
                i16 = 800;
                WinkStickerModel E = E(StickerLayerIndexManager.f321548a.b(), n3, material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, com.tencent.mobileqq.wink.editor.c.H(material), imageType, i3, i16, 0.0f, 0.0f, 12288, null);
                E.frameScale = 1.1f;
                E.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), 0.4f, 0.4f, 0.0f, 0.0f);
                dr.b.n(tavCut, E, false, 2, null);
            }
            WinkStickerModel E2 = E(StickerLayerIndexManager.f321548a.b(), n3, material, 0L, tavCut.getDurationUs(), StickerModel.Type.DEFAULT, 1.0f, 0.0f, com.tencent.mobileqq.wink.editor.c.H(material), imageType, i3, i16, 0.0f, 0.0f, 12288, null);
            E2.frameScale = 1.1f;
            E2.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), 0.4f, 0.4f, 0.0f, 0.0f);
            dr.b.n(tavCut, E2, false, 2, null);
        } catch (Throwable th7) {
            th5 = th7;
            inputStream = null;
            if (inputStream == null) {
                try {
                    inputStream.close();
                    throw th5;
                } catch (IOException e26) {
                    e26.printStackTrace();
                    throw th5;
                }
            }
            throw th5;
        }
    }

    public static final void i(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment) {
        long durationUs;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        PagEffectData A = rd4.c.f431135f.A(m.y(material));
        if (A != null) {
            PointF n3 = n(tavCut.getRenderSize(), tavCut.a());
            int d16 = StickerLayerIndexManager.f321548a.d();
            IPlayer currentPlayer = tavCut.getCurrentPlayer();
            if (currentPlayer != null) {
                durationUs = currentPlayer.getDurationUs();
            } else {
                durationUs = tavCut.getDurationUs();
            }
            WinkStickerModel b16 = com.tencent.mobileqq.wink.editor.sticker.d.b(A, d16, n3, material, 0L, durationUs, StickerModel.Type.MASK, 0.0f, 0.0f, 192, null);
            b16.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), m.A(material), m.A(material), m.i(material), m.j(material));
            dr.b.n(tavCut, b16, false, 2, null);
        }
    }

    public static final void j(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment, long j3, long j16) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        k(material, tavCut, editorFragment, j3, j16, null);
    }

    public static final void k(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment, long j3, long j16, @Nullable Function1<? super WinkStickerModel, ? extends WinkStickerModel> function1) {
        WinkStickerModel winkStickerModel;
        WinkStickerModel winkStickerModel2;
        String str;
        List list;
        o73.a Kk;
        String[] texts;
        int T1;
        float U1;
        List<TextItem> list2;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        if (m.Q(material)) {
            g.Companion.i(g.INSTANCE, tavCut, false, 2, null);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            m.z0(material, uuid);
            String b26 = WinkEditorResourceManager.a1().b2(material);
            Intrinsics.checkNotNullExpressionValue(b26, "getInstance().getTopBianKuangStickerPath(material)");
            m.S0(material, b26);
            String B0 = WinkEditorResourceManager.a1().B0(material);
            Intrinsics.checkNotNullExpressionValue(B0, "getInstance().getBottomB\u2026uangStickerPath(material)");
            m.j0(material, B0);
            l(material, tavCut, editorFragment);
            e(material, tavCut, editorFragment);
            return;
        }
        if (m.N(material)) {
            i(material, tavCut, editorFragment);
            return;
        }
        if ((tavCut instanceof WinkImageTavCut) && tavCut.isPlaying()) {
            tavCut.pause();
        }
        WinkStickerModel t16 = t(material, tavCut, editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), j3, j16, false, false, 96, null);
        if (t16 == null) {
            return;
        }
        if (function1 != null) {
            winkStickerModel = function1.invoke(t16);
        } else {
            winkStickerModel = null;
        }
        if (winkStickerModel == null) {
            winkStickerModel2 = t16;
        } else {
            winkStickerModel2 = winkStickerModel;
        }
        dr.b.n(tavCut, winkStickerModel2, false, 2, null);
        ArrayList arrayList = new ArrayList();
        if (winkStickerModel != null && (list2 = winkStickerModel.textItems) != null) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TextItem) it.next()).text);
            }
        }
        Map<String, String> map = material.additionalFields;
        if (map != null) {
            str = map.get("showTTSMenu");
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1")) {
            if (winkStickerModel != null) {
                tavCut.play();
                Bundle bundle = new Bundle();
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                TTSAudioInfo ttsAudioInfo = winkStickerModel.getTtsAudioInfo();
                if (ttsAudioInfo != null) {
                    T1 = ttsAudioInfo.getTemplateType();
                } else {
                    T1 = editorFragment.Ik().T1();
                }
                TTSAudioInfo ttsAudioInfo2 = winkStickerModel.getTtsAudioInfo();
                if (ttsAudioInfo2 != null) {
                    U1 = ttsAudioInfo2.getVolume();
                } else {
                    U1 = editorFragment.Ik().U1();
                }
                winkStickerModel.setTtsAudioInfo(new TTSAudioInfo(strArr, T1, U1, winkStickerModel.id));
                winkStickerModel.setHasChooseTTS(true);
                bundle.putSerializable(QQWinkConstants.PICK_TEMPLATE_TTS_MODEL, winkStickerModel.getTtsAudioInfo());
                editorFragment.Tk().u5(MenuType.TTS, bundle);
                return;
            }
            return;
        }
        if (m.X(material) && t16.getHasChooseTTS()) {
            String obj = arrayList.toString();
            TTSAudioInfo ttsAudioInfo3 = t16.getTtsAudioInfo();
            if (ttsAudioInfo3 != null && (texts = ttsAudioInfo3.getTexts()) != null) {
                list = ArraysKt___ArraysKt.toList(texts);
            } else {
                list = null;
            }
            if (!Intrinsics.areEqual(obj, String.valueOf(list)) && (Kk = editorFragment.Kk()) != null) {
                Kk.D3();
            }
            P(editorFragment, tavCut, t16);
        }
    }

    public static final void l(@NotNull MetaMaterial material, @NotNull dr tavCut, @NotNull WinkEditorFragment editorFragment) {
        SizeF m3;
        long durationUs;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
        try {
            PagEffectData A = rd4.c.f431135f.A(m.I(material));
            if (A != null) {
                BackgroundModel backgroundModel = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel);
                SizeF sizeF = backgroundModel.renderSize;
                Intrinsics.checkNotNull(sizeF);
                Float valueOf = Float.valueOf(sizeF.width);
                BackgroundModel backgroundModel2 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel2);
                SizeF sizeF2 = backgroundModel2.renderSize;
                Intrinsics.checkNotNull(sizeF2);
                Pair pair = new Pair(valueOf, Float.valueOf(sizeF2.height));
                float f16 = 1280;
                m.G0(material, (((((Number) pair.component1()).floatValue() + ViewUtils.dpToPx(1.0f)) * f16) / ((Number) pair.component2()).floatValue()) / A.getWidth());
                float A2 = m.A(material);
                m.k0(material, 0.0f);
                float f17 = 1;
                m.l0(material, f17 - ((A.getHeight() * m.A(material)) / f16));
                if (tavCut.G()) {
                    m3 = new SizeF(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), null, 4, null);
                } else {
                    m3 = m(tavCut);
                }
                float renderWidth = (m3.height / m3.width) * 1.0f * (editorFragment.getRenderWidth() / editorFragment.getRenderHeight());
                m.l0(material, Math.min(renderWidth, 1.0f) - (((A.getHeight() - ViewUtils.dpToPx(1.0f)) * m.A(material)) / f16));
                PointF n3 = n(tavCut.getRenderSize(), tavCut.a());
                int b16 = StickerLayerIndexManager.f321548a.b();
                IPlayer currentPlayer = tavCut.getCurrentPlayer();
                if (currentPlayer != null) {
                    durationUs = currentPlayer.getDurationUs();
                } else {
                    durationUs = tavCut.getDurationUs();
                }
                WinkStickerModel a16 = com.tencent.mobileqq.wink.editor.sticker.d.a(A, b16, n3, material, 0L, durationUs, StickerModel.Type.TOP_FRAME, renderWidth, f17 - renderWidth);
                a16.updatePositionInView(editorFragment.getRenderWidth(), editorFragment.getRenderHeight(), A2, A2, m.i(material), m.j(material));
                dr.b.n(tavCut, a16, false, 2, null);
            }
        } catch (Exception e16) {
            ms.a.e("wink_sticker_TextMetaMaterial", e16);
        }
    }

    private static final SizeF m(dr drVar) {
        Object next;
        float f16;
        SizeF sizeF;
        float f17;
        SizeF sizeF2;
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        Iterator<T> it = drVar.V().videos.iterator();
        SizeF sizeF3 = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) next).resource;
                if (resourceModel != null && (rectF2 = resourceModel.picClipRect) != null) {
                    f16 = Math.abs((rectF2.bottom - rectF2.top) / (rectF2.right - rectF2.left));
                } else if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                    f16 = Math.abs(sizeF.height / sizeF.width);
                } else {
                    f16 = 0.0f;
                }
                do {
                    Object next2 = it.next();
                    ResourceModel resourceModel2 = ((MediaClip) next2).resource;
                    if (resourceModel2 != null && (rectF = resourceModel2.picClipRect) != null) {
                        f17 = Math.abs((rectF.bottom - rectF.top) / (rectF.right - rectF.left));
                    } else if (resourceModel2 != null && (sizeF2 = resourceModel2.size) != null) {
                        f17 = Math.abs(sizeF2.height / sizeF2.width);
                    } else {
                        f17 = 0.0f;
                    }
                    if (Float.compare(f16, f17) < 0) {
                        next = next2;
                        f16 = f17;
                    }
                } while (it.hasNext());
            }
        }
        MediaClip mediaClip = (MediaClip) next;
        if (mediaClip != null) {
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null && (rectF3 = resourceModel3.picClipRect) != null) {
                return new SizeF(rectF3.right - rectF3.left, rectF3.bottom - rectF3.top, null, 4, null);
            }
            if (resourceModel3 != null) {
                sizeF3 = resourceModel3.size;
            }
            if (sizeF3 == null) {
                return new SizeF(0.0f, 0.0f, null, 7, null);
            }
            return sizeF3;
        }
        return new SizeF(0.0f, 0.0f, null, 7, null);
    }

    @NotNull
    public static final PointF n(@NotNull com.tencent.videocut.model.Size renderSize, @NotNull com.tencent.videocut.model.Size playerContainerSize) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(playerContainerSize, "playerContainerSize");
        Integer num = playerContainerSize.width;
        int i18 = 0;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        Integer num2 = renderSize.width;
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = 0;
        }
        int i19 = i3 - i16;
        Integer num3 = playerContainerSize.height;
        if (num3 != null) {
            i17 = num3.intValue();
        } else {
            i17 = 0;
        }
        Integer num4 = renderSize.height;
        if (num4 != null) {
            i18 = num4.intValue();
        }
        return new PointF(i19 / 2, (i17 - i18) / 2);
    }

    @NotNull
    public static final PointF o(@NotNull SizeF renderSize, @NotNull SizeF playerContainerSize) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(playerContainerSize, "playerContainerSize");
        float f16 = 2;
        return new PointF((playerContainerSize.width - renderSize.width) / f16, (playerContainerSize.height - renderSize.height) / f16);
    }

    private static final void p(AEEditorDownloadResBean aEEditorDownloadResBean, ApplyMaterialTask.a aVar, MetaMaterial metaMaterial) {
        ms.a.a("StickerUtils", "[downloadFont] - BEGIN -");
        WinkEditorResourceManager.a1().h(aEEditorDownloadResBean, new b(metaMaterial, aVar));
        ms.a.a("StickerUtils", "[downloadFont] - END -");
    }

    @Nullable
    public static final WinkStickerModel q(@NotNull MetaMaterial metaMaterial, @NotNull dr tavCut, int i3, int i16, long j3, long j16) {
        StickerModel.Type type;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        PagEffectData A = rd4.c.f431135f.A(m.y(metaMaterial));
        if (A != null) {
            PointF n3 = n(tavCut.getRenderSize(), tavCut.d0(metaMaterial));
            if (m.X(metaMaterial)) {
                type = StickerModel.Type.TEXT;
            } else {
                type = StickerModel.Type.DEFAULT;
            }
            return com.tencent.mobileqq.wink.editor.sticker.d.b(A, StickerLayerIndexManager.f321548a.b(), n3, metaMaterial, j3, j16, type, 0.0f, 0.0f, 192, null);
        }
        return null;
    }

    @Nullable
    public static final WinkStickerModel r(@NotNull MetaMaterial metaMaterial, @NotNull dr tavCut, int i3, int i16, long j3, long j16, boolean z16, boolean z17) {
        StickerModel.Type type;
        float A;
        ScreenTransform f16;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        PagEffectData A2 = rd4.c.f431135f.A(m.y(metaMaterial));
        if (A2 != null) {
            PointF n3 = n(tavCut.getRenderSize(), tavCut.d0(metaMaterial));
            String id5 = metaMaterial.f30533id;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            long y16 = y(id5, j3, tavCut, A2);
            if (m.X(metaMaterial)) {
                type = StickerModel.Type.TEXT;
            } else {
                type = StickerModel.Type.DEFAULT;
            }
            WinkStickerModel b16 = com.tencent.mobileqq.wink.editor.sticker.d.b(A2, StickerLayerIndexManager.f321548a.b(), n3, metaMaterial, y16, j16, type, 0.0f, 0.0f, 192, null);
            String m3 = WinkEditorResourceManager.a1().m(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(this)");
            if (com.tencent.mobileqq.wink.editor.sticker.e.e(b16, m3) && (f16 = com.tencent.videocut.render.utils.c.f384212a.f(m3)) != null) {
                float f17 = 2;
                b16 = WinkStickerModel.copyAndUpdate$default(b16, null, null, 0L, 0L, 0, b16.scaleX, b16.scaleY, com.tencent.videocut.render.extension.g.a(f16), 0.0f, 0.0f, false, Math.abs((int) (f16.getOffset().left * f17)), Math.abs((int) (f16.getOffset().top * f17)), 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -7137, 1048575, null);
            }
            if (z17) {
                if (z16) {
                    int i17 = b16.width;
                    b16.width = Math.min(i3, i17);
                    A = i3 / i17;
                } else {
                    A = m.A(metaMaterial);
                }
                b16.updatePositionInView(i3, i16, A, A, m.i(metaMaterial), m.j(metaMaterial));
            }
            return b16;
        }
        return null;
    }

    @Nullable
    public static final WinkStickerModel s(@NotNull MetaMaterial metaMaterial, @NotNull SizeF renderSize, @NotNull SizeF containerSizeF, int i3, int i16, long j3, long j16, boolean z16, boolean z17) {
        StickerModel.Type type;
        float A;
        ScreenTransform f16;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(containerSizeF, "containerSizeF");
        PagEffectData A2 = rd4.c.f431135f.A(m.y(metaMaterial));
        if (A2 != null) {
            PointF o16 = o(renderSize, containerSizeF);
            if (m.X(metaMaterial)) {
                type = StickerModel.Type.TEXT;
            } else {
                type = StickerModel.Type.DEFAULT;
            }
            WinkStickerModel b16 = com.tencent.mobileqq.wink.editor.sticker.d.b(A2, StickerLayerIndexManager.f321548a.b(), o16, metaMaterial, j3, j16, type, 0.0f, 0.0f, 192, null);
            String m3 = WinkEditorResourceManager.a1().m(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(this)");
            if (com.tencent.mobileqq.wink.editor.sticker.e.e(b16, m3) && (f16 = com.tencent.videocut.render.utils.c.f384212a.f(m3)) != null) {
                float f17 = 2;
                b16 = WinkStickerModel.copyAndUpdate$default(b16, null, null, 0L, 0L, 0, b16.scaleX, b16.scaleY, com.tencent.videocut.render.extension.g.a(f16), 0.0f, 0.0f, false, Math.abs((int) (f16.getOffset().left * f17)), Math.abs((int) (f16.getOffset().top * f17)), 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -7137, 1048575, null);
            }
            if (z17) {
                if (z16) {
                    int i17 = b16.width;
                    b16.width = Math.min(i3, i17);
                    A = i3 / i17;
                } else {
                    A = m.A(metaMaterial);
                }
                b16.updatePositionInView(i3, i16, A, A, m.i(metaMaterial), m.j(metaMaterial));
            }
            return b16;
        }
        return null;
    }

    public static /* synthetic */ WinkStickerModel t(MetaMaterial metaMaterial, dr drVar, int i3, int i16, long j3, long j16, boolean z16, boolean z17, int i17, Object obj) {
        boolean z18;
        boolean z19;
        if ((i17 & 32) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i17 & 64) != 0) {
            z19 = true;
        } else {
            z19 = z17;
        }
        return r(metaMaterial, drVar, i3, i16, j3, j16, z18, z19);
    }

    public static /* synthetic */ WinkStickerModel u(MetaMaterial metaMaterial, SizeF sizeF, SizeF sizeF2, int i3, int i16, long j3, long j16, boolean z16, boolean z17, int i17, Object obj) {
        boolean z18;
        boolean z19;
        if ((i17 & 64) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i17 & 128) != 0) {
            z19 = true;
        } else {
            z19 = z17;
        }
        return s(metaMaterial, sizeF, sizeF2, i3, i16, j3, j16, z18, z19);
    }

    @NotNull
    public static final WinkStickerModel v(@NotNull MetaMaterial metaMaterial, @NotNull dr tavCut, int i3, int i16, @NotNull WinkStickerModel referenceSticker) {
        String str;
        MetaMaterialContentWrapper metaMaterialContentWrapper;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(referenceSticker, "referenceSticker");
        MetaMaterial material = referenceSticker.getMaterial();
        if (material == null || (str = m.l(material)) == null) {
            str = "";
        }
        m.n0(metaMaterial, str);
        MetaMaterial material2 = referenceSticker.getMaterial();
        WinkStickerModel winkStickerModel = null;
        if (material2 == null || (metaMaterialContentWrapper = m.m(material2)) == null) {
            metaMaterialContentWrapper = null;
        }
        m.o0(metaMaterial, metaMaterialContentWrapper);
        WinkStickerModel t16 = t(metaMaterial, tavCut, i3, i16, referenceSticker.startTime, referenceSticker.duration, false, false, 32, null);
        if (t16 != null) {
            winkStickerModel = WinkStickerModel.copyAndUpdate$default(t16, referenceSticker.id, null, 0L, 0L, 0, referenceSticker.scaleX, referenceSticker.scaleY, referenceSticker.rotate, referenceSticker.centerX, referenceSticker.centerY, false, referenceSticker.width, referenceSticker.height, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -7138, 1048575, null);
        }
        m.Z(metaMaterial, i3);
        if (winkStickerModel != null) {
            winkStickerModel.updatePositionInView(i3, i16, referenceSticker.scaleX, referenceSticker.scaleY, referenceSticker.centerX, referenceSticker.centerY);
        }
        if (winkStickerModel == null) {
            return referenceSticker;
        }
        return winkStickerModel;
    }

    @NotNull
    public static final String w(@NotNull WinkEditData winkEditData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
        HashMap hashMap = new HashMap();
        Iterator<T> it = winkEditData.getMediaModel().specialEffects.values().iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            SpecialEffectModel specialEffectModel = (SpecialEffectModel) it.next();
            if (hashMap.containsKey(specialEffectModel.name)) {
                Integer num = (Integer) hashMap.get(specialEffectModel.name);
                if (num != null) {
                    i3 = num.intValue();
                }
                int i16 = i3 + 1;
                String str = specialEffectModel.name;
                if (str != null) {
                }
            } else {
                String str2 = specialEffectModel.name;
                if (str2 != null) {
                }
            }
        }
        String str3 = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            str3 = ((Object) str3) + entry.getKey() + ":" + entry.getValue() + ",";
        }
        if (str3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str3 = str3.substring(0, str3.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return "{" + ((Object) str3) + "}";
    }

    @NotNull
    public static final String x(@NotNull WinkEditData winkEditData) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
        HashMap hashMap = new HashMap();
        Iterator<T> it = winkEditData.getMediaModel().specialEffects.values().iterator();
        while (it.hasNext()) {
            Integer num = ((SpecialEffectModel) it.next()).effectType;
            if (num != null && num.intValue() == 0) {
                str = "screen";
            } else {
                str = PreDetect.FACE_DETECT;
            }
            if (hashMap.containsKey(str)) {
                Integer num2 = (Integer) hashMap.get(str);
                if (num2 == null) {
                    num2 = 0;
                }
                hashMap.put(str, Integer.valueOf(num2.intValue() + 1));
            } else {
                hashMap.put(str, 1);
            }
        }
        String str2 = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            str2 = ((Object) str2) + entry.getKey() + ":" + entry.getValue() + ",";
        }
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = str2.substring(0, str2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return "{" + ((Object) str2) + "}";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        if (r3.equals("sticker_fenwei_02") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
    
        r4 = -620000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (r3.equals("sticker_zipai_05") == false) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long y(@NotNull String materialId, long j3, @NotNull dr tavCut, @NotNull PagEffectData pagEffectData) {
        long durationUs;
        boolean z16;
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(pagEffectData, "pagEffectData");
        if (tavCut instanceof WinkImageTavCut) {
            switch (materialId.hashCode()) {
                case -2015408560:
                    if (materialId.equals("sticker_youxi_21")) {
                        j3 = -1150000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs && durationUs < 3000000) {
                        z16 = true;
                    }
                    if (z16) {
                        j3 = ((-1) * pagEffectData.getDurationUs()) + 100000;
                        break;
                    } else {
                        j3 = -5000000;
                        break;
                    }
                case -2015408559:
                    if (materialId.equals("sticker_youxi_22")) {
                        j3 = -1000000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                        z16 = true;
                        break;
                    }
                    if (z16) {
                    }
                    break;
                case -1467039811:
                    break;
                case -1447568790:
                    if (materialId.equals("sticker_biaoji_003")) {
                        j3 = -660000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                    }
                    if (z16) {
                    }
                    break;
                case -735052079:
                    if (materialId.equals("sticker_qingxu_02")) {
                        j3 = -2000000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                    }
                    if (z16) {
                    }
                    break;
                case -269034189:
                    break;
                case 141247269:
                    if (materialId.equals("sticker_yijiansanlian1")) {
                        j3 = -4000000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                    }
                    if (z16) {
                    }
                    break;
                case 1636599261:
                    if (materialId.equals("sticker_manhualian_04")) {
                        j3 = -1500000;
                        break;
                    }
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                    }
                    if (z16) {
                    }
                    break;
                default:
                    durationUs = pagEffectData.getDurationUs();
                    z16 = false;
                    if (100001 <= durationUs) {
                    }
                    if (z16) {
                    }
                    break;
            }
            w53.b.a("wink_sticker_TextMetaMaterial", "generateCommSticker id:" + materialId + ", imageSticker startUs is " + j3 + " us");
        }
        return j3;
    }

    @NotNull
    public static final String z(@NotNull WinkEditData winkEditData) {
        String str;
        boolean z16;
        boolean z17;
        String str2;
        Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
        HashMap hashMap = new HashMap();
        Iterator<T> it = winkEditData.getMediaModel().stickers.values().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            StickerModel stickerModel = (StickerModel) it.next();
            String str3 = stickerModel.materialId;
            if (str3.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                Intrinsics.checkNotNull(stickerModel, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel");
                MetaMaterial material = ((WinkStickerModel) stickerModel).getMaterial();
                if (material != null) {
                    str2 = material.f30533id;
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "(it as WinkStickerModel).material?.id ?: \"\"");
                    str = str2;
                }
                str3 = str;
            }
            if (hashMap.containsKey(str3)) {
                Integer num = (Integer) hashMap.get(str3);
                if (num == null) {
                    num = 0;
                }
                hashMap.put(str3, Integer.valueOf(num.intValue() + 1));
            } else {
                hashMap.put(str3, 1);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            str = ((Object) str) + entry.getKey() + ":" + entry.getValue() + ",";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        return "{" + ((Object) str) + "}";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/l$e", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ResDownLoadListener {

        /* renamed from: a */
        final /* synthetic */ ApplyMaterialTask.a f321746a;

        e(ApplyMaterialTask.a aVar) {
            this.f321746a = aVar;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                this.f321746a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f321746a.a(ApplyMaterialTask.Status.FAILED, 100);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
