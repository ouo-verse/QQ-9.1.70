package com.tencent.mobileqq.wink.editor;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.GYVideoClassifyResult;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.HDRModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.WatermarkConfig;
import org.light.listener.OnLoadAssetListener;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 A2\u00020\u0001:\u0003A\u0092\u0001J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u0002`\bH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH'J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0014H'J\u0012\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0010H&J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0014H'J\b\u0010\u001e\u001a\u00020\u001dH&J\u001c\u0010\"\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001fH&J\u001a\u0010%\u001a\u00020\n2\u0006\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020\u0010H&J\u0016\u0010(\u001a\u00020\n2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020 0&H&J\u0010\u0010)\u001a\u00020\n2\u0006\u0010#\u001a\u00020 H&J\u0016\u0010*\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0&H&J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH&J&\u00101\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u00020\u0010H&J\u001c\u00106\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u0001022\b\b\u0002\u00105\u001a\u000204H&J\u001a\u00109\u001a\u00020\n2\u0006\u00108\u001a\u0002072\b\b\u0002\u00105\u001a\u000204H&J\u001a\u0010:\u001a\u00020\n2\u0006\u00108\u001a\u0002072\b\b\u0002\u00105\u001a\u000204H&J\u0010\u0010;\u001a\u00020\n2\u0006\u00108\u001a\u000207H&J\u001c\u0010?\u001a\u00020\n2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002070<H&J\b\u0010A\u001a\u00020@H&J\u0012\u0010B\u001a\u00020@2\b\u0010/\u001a\u0004\u0018\u00010.H&J\b\u0010C\u001a\u00020@H&J\u0018\u0010F\u001a\u00020\n2\u0006\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020=H&J\u0010\u0010H\u001a\u00020\n2\u0006\u0010G\u001a\u00020@H&J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020I0&H&J\b\u0010K\u001a\u00020\u0010H&J\n\u0010L\u001a\u0004\u0018\u00010\u0007H&J\b\u0010M\u001a\u00020\u0010H\u0016J\b\u0010N\u001a\u00020\nH&J\b\u0010O\u001a\u00020\u0010H&J(\u0010T\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020=2\u0006\u0010R\u001a\u00020=2\u0006\u0010S\u001a\u00020\u0010H&J\u0010\u0010U\u001a\u00020\n2\u0006\u0010R\u001a\u00020=H&J\u0010\u0010W\u001a\u00020\n2\u0006\u0010V\u001a\u00020\u0010H&J\b\u0010X\u001a\u00020\u0010H&J \u0010\\\u001a\u00020\n2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0&2\b\b\u0002\u0010[\u001a\u00020\u001dH\u0016J\u000e\u0010]\u001a\b\u0012\u0004\u0012\u00020Y0&H\u0016J\b\u0010^\u001a\u00020\nH&J\b\u0010_\u001a\u00020\u0010H&J\b\u0010`\u001a\u00020\u0010H&J\b\u0010a\u001a\u00020\u0010H&J\b\u0010b\u001a\u00020@H&J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00140&H'J\u0010\u0010e\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u0010H&J0\u0010g\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070&0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070&`fH&J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070&H&J\b\u0010i\u001a\u00020\u0010H\u0016J\u0012\u0010k\u001a\u00020\u00102\b\u0010j\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010l\u001a\u00020\u001dH&J\b\u0010m\u001a\u00020\nH&J\b\u0010n\u001a\u00020\u0010H&J\b\u0010o\u001a\u00020\nH&J\b\u0010p\u001a\u00020\u0010H&J\u0010\u0010r\u001a\u00020\n2\u0006\u0010q\u001a\u00020\u001dH&J\u0018\u0010r\u001a\u00020\n2\u0006\u0010q\u001a\u00020\u001d2\u0006\u0010s\u001a\u00020\u0010H&J\u0010\u0010t\u001a\u00020\n2\u0006\u0010q\u001a\u00020\u001dH&J\u0010\u0010v\u001a\u00020\n2\u0006\u0010u\u001a\u00020\u0010H&J\u0010\u0010x\u001a\u00020\n2\u0006\u0010w\u001a\u00020\u0010H&J\b\u0010y\u001a\u00020\u001dH\u0016J\u0018\u0010|\u001a\u00020\n2\u0006\u0010z\u001a\u00020\u001d2\u0006\u0010{\u001a\u00020\u001dH&J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020}0&H&J\u000e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020}0&H&JK\u0010\u0085\u0001\u001a\u00020\n2%\u0010\u0081\u0001\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0080\u00010\u0006j\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0080\u0001`f2\u0007\u0010\u0082\u0001\u001a\u00020\u001d2\u0007\u0010\u0083\u0001\u001a\u00020\u00102\u0007\u0010\u0084\u0001\u001a\u00020\u0010H&J\u0013\u0010\u0088\u0001\u001a\u00020\n2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J\u0013\u0010\u0089\u0001\u001a\u00020\n2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H&J\u0013\u0010\u008c\u0001\u001a\u00020\n2\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001H&J\u0013\u0010\u008d\u0001\u001a\u00020\n2\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001H&J-\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020}0&2\u001c\u0010\u0091\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0005\u0012\u00030\u0090\u00010\u008e\u00010&H&J\u0018\u0010\u0094\u0001\u001a\u00020\u00102\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020}0&H&J\u0019\u0010\u0095\u0001\u001a\u00020\n2\u0006\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020=H&J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001H&J\u0012\u0010\u0099\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010&H&J\t\u0010\u009a\u0001\u001a\u00020\u001dH&J\u0012\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010\u009b\u0001\u001a\u00020\u0007H&J\u0013\u0010\u009e\u0001\u001a\u00020\n2\b\u0010\u008b\u0001\u001a\u00030\u009d\u0001H&J\u0013\u0010\u009f\u0001\u001a\u00020\n2\b\u0010\u008b\u0001\u001a\u00030\u009d\u0001H&J\t\u0010\u00a0\u0001\u001a\u00020\nH\u0016J\u0010\u0010\u00a2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a1\u00010&H&J3\u0010\u00a7\u0001\u001a\u00020\n2\u0007\u0010\u0019\u001a\u00030\u00a3\u00012\u0007\u0010\u00a4\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u00a5\u0001\u001a\u00020\u00102\u000b\b\u0002\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0007H&J\u000f\u0010\u00a8\u0001\u001a\b\u0012\u0004\u0012\u00020 0&H&J\t\u0010\u00a9\u0001\u001a\u00020\nH&R\u0018\u0010j\u001a\u0004\u0018\u00010\u00078&X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0019\u0010\u00ae\u0001\u001a\u0004\u0018\u00010I8&X\u00a6\u0004\u00a2\u0006\b\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dr;", "", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "params", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", BaseConstants.ATTR_KET_EXTRA_MAP, "", HippyTKDListViewAdapter.X, "Lcom/tencent/tavcut/core/render/player/IPlayer;", "getPlayer", "Lcom/tencent/tavcut/core/session/ICutSession;", "l", "", "hidden", "b", "release", "Lcom/tencent/videocut/model/MediaModel;", "V", FileReaderHelper.OPEN_FILE_FROM_FORCE, HippyQQPagView.FunctionName.FLUSH, "Lkotlin/Function0;", "action", "L", "mediaModel", "r", "", "getDurationUs", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModelMap", "B", "stickerModel", "isTransition", "t", "", "stickerModels", "W", "e", "T", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/videocut/model/FilterModel;", "filterModel", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "onlyUpdateIntensity", "i0", "Lcom/tencent/videocut/model/AudioModel;", "audioModel", "Lcom/tencent/videocut/model/AudioModel$Type;", "audioType", "k0", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, ReportConstant.COSTREPORT_PREFIX, "b0", "o", "", "", "clipVolumes", "v", "Lcom/tencent/videocut/model/Size;", "a", "d0", "getRenderSize", "width", "height", "n0", "size", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", DomainData.DOMAIN_NAME, "U", "X", ExifInterface.LATITUDE_SOUTH, "j", "l0", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "bottomOffset", "topOffset", "isBackgroundPanel", "Y", BdhLogUtil.LogTag.Tag_Req, com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "c0", "p", "Lcom/tencent/videocut/model/SpecialEffectModel;", IQQGameCommApi.K_ABTEST_MODELS, "targetTime", "N", "y", "u", "O", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "M", "J", "isForce", "D", "Lkotlin/collections/HashMap;", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", "templatePath", "f0", "getCurrentPlayUs", "pause", "isReady", "play", "isPlaying", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "openInAccurateSeek", "stop", "isLoop", "setLoopPlay", "isAutoPlay", "setAutoPlay", "getFrameDuration", "startTimeUs", "durationUs", "setPlayTimeRange", "Lcom/tencent/videocut/model/MediaClip;", "g0", "a0", "Lcom/tencent/videocut/model/HDRModel;", "inputMap", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "useHDR", "needPlay", "k", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "addPlayerListener", "removePlayerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "listener", UserInfo.SEX_FEMALE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Pair;", "Landroid/graphics/Matrix;", "Landroid/graphics/RectF;", "cropInfoList", "c", "clips", "e0", "P", "Lcom/gyailib/library/GYVideoClassifyResult;", "E", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "I", tl.h.F, QzoneZipCacheHelper.DIR, "j0", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "m0", "d", "Z", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/wink/editor/template/x$b;", "isClearStickers", "needChaneStrickerDirectly", "stickerText", "K", "f", "g", "H", "()Ljava/lang/String;", "h0", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "currentEditData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface dr {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f319911a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static void a(@NotNull dr drVar, @NotNull List<SpecialEffectModel> models, long j3) {
            Intrinsics.checkNotNullParameter(models, "models");
        }

        public static /* synthetic */ void b(dr drVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                drVar.flush(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flush");
        }

        @NotNull
        public static List<SpecialEffectModel> c(@NotNull dr drVar) {
            List<SpecialEffectModel> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        public static long d(@NotNull dr drVar) {
            return 0L;
        }

        @NotNull
        public static String e(@NotNull dr drVar) {
            return r73.a.f430927a.d(drVar.H());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void f(dr drVar, BasePartFragment basePartFragment, WinkTavCutParams winkTavCutParams, HashMap hashMap, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    hashMap = new HashMap();
                }
                drVar.x(basePartFragment, winkTavCutParams, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }

        public static boolean g(@NotNull dr drVar) {
            boolean z16;
            String H = drVar.H();
            if (H != null && H.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            return !z16;
        }

        public static boolean h(@NotNull dr drVar) {
            return drVar.f0(drVar.H());
        }

        public static boolean i(@NotNull dr drVar, @Nullable String str) {
            return !TextUtils.isEmpty(str);
        }

        public static void j(@NotNull dr drVar) {
            if (Build.VERSION.SDK_INT <= 24 || Companion.DEVICES_RECREATE_PLAYER_WHEN_RESUME.contains(DeviceInfoMonitor.getModel())) {
                w53.b.f("Metamaterial", "recreatePlayerIfNeeded device:" + DeviceInfoMonitor.getModel());
                ICutSession l3 = drVar.l();
                if (l3 instanceof LAKCutSession) {
                    LAKCutSession.updatePlayer$default((LAKCutSession) l3, 0L, false, 3, null);
                }
            }
        }

        public static /* synthetic */ void k(dr drVar, AudioModel audioModel, AudioModel.Type type, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    type = AudioModel.Type.MUSIC;
                }
                drVar.k0(audioModel, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAudio");
        }

        public static /* synthetic */ void l(dr drVar, float f16, AudioModel.Type type, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    type = AudioModel.Type.MUSIC;
                }
                drVar.s(f16, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAudioVolume");
        }

        public static /* synthetic */ void m(dr drVar, float f16, AudioModel.Type type, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    type = AudioModel.Type.MUSIC;
                }
                drVar.b0(f16, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAudioVolumeWithouDelay");
        }

        public static /* synthetic */ void n(dr drVar, WinkStickerModel winkStickerModel, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                drVar.t(winkStickerModel, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSticker");
        }

        public static /* synthetic */ void o(dr drVar, x.UpdateTemplateAction updateTemplateAction, boolean z16, boolean z17, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z17 = false;
                }
                if ((i3 & 8) != 0) {
                    str = null;
                }
                drVar.K(updateTemplateAction, z16, z17, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTemplate");
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            if (r6 == null) goto L35;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void p(@NotNull dr drVar, @Nullable String str) {
            Unit unit;
            String str2;
            ms.a.f("WinkTavCutDelegate", "updateTemplatePath " + str);
            if (str != null) {
                try {
                    ICutSession l3 = drVar.l();
                    if (l3 != null) {
                        String parent = new File(str).getParent();
                        if (parent != null) {
                            str2 = parent + File.separator;
                        }
                        str2 = "/";
                        l3.setTemplateDir(str2);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                } catch (Exception e16) {
                    ms.a.c("WinkTavCutDelegate", "setTemplateDir exception:" + e16.getMessage());
                    unit = Unit.INSTANCE;
                }
                if (unit != null) {
                    return;
                }
            }
            ICutSession l16 = drVar.l();
            if (l16 != null) {
                l16.setTemplateDir("/");
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @NotNull
    List<MosaicData> A();

    void B(@NotNull Map<String, WinkStickerModel> stickerModelMap);

    void C(@NotNull Size size);

    void D(boolean isForce);

    @Nullable
    GYVideoClassifyResult E();

    void F(@NotNull ISessionListener iSessionListener);

    boolean G();

    @Nullable
    String H();

    @Nullable
    List<ClipSource> I();

    @Deprecated(message = "forbidden to call mediaModel list")
    @NotNull
    List<MediaModel> J();

    void K(@NotNull x.UpdateTemplateAction action, boolean isClearStickers, boolean needChaneStrickerDirectly, @Nullable String stickerText);

    void L(@NotNull Function0<Unit> action);

    @NotNull
    Size M();

    void N(@NotNull List<SpecialEffectModel> r16, long targetTime);

    boolean O();

    void P(int width, int height);

    void Q(@NotNull ISessionListener iSessionListener);

    void R(int i3);

    boolean S();

    void T(@NotNull List<? extends WinkStickerModel> stickerModel);

    boolean U();

    @Deprecated(message = "forbidden to call mediaModel")
    @NotNull
    MediaModel V();

    void W(@NotNull List<? extends WinkStickerModel> stickerModels);

    @Nullable
    String X();

    void Y(boolean r16, int bottomOffset, int topOffset, boolean isBackgroundPanel);

    void Z();

    @NotNull
    Size a();

    @NotNull
    List<MediaClip> a0();

    void addPlayerListener(@NotNull IPlayer.PlayerListener playerListener);

    void b(boolean hidden);

    void b0(float r16, @NotNull AudioModel.Type audioType);

    @NotNull
    List<MediaClip> c(@NotNull List<? extends Pair<? extends Matrix, ? extends RectF>> cropInfoList);

    void c0(boolean r16);

    void d(@NotNull ICutStatusCallback listener);

    @NotNull
    Size d0(@Nullable MetaMaterial r16);

    void e(@NotNull WinkStickerModel stickerModel);

    boolean e0(@NotNull List<? extends MediaClip> clips);

    @NotNull
    List<WinkStickerModel> f();

    boolean f0(@Nullable String templatePath);

    void flush(boolean z16);

    void g();

    @NotNull
    List<MediaClip> g0();

    long getCurrentPlayUs();

    long getDurationUs();

    long getFrameDuration();

    @Deprecated(message = "forbidden to call player")
    @Nullable
    IPlayer getPlayer();

    @NotNull
    Size getRenderSize();

    long h();

    @Nullable
    WinkEditData h0();

    boolean i();

    void i0(@Nullable FilterModel filterModel, @Nullable MetaMaterial r26, boolean onlyUpdateIntensity);

    boolean isPlaying();

    boolean isReady();

    void j();

    void j0(@NotNull String r16);

    void k(@NotNull HashMap<String, HDRModel> inputMap, long r26, boolean useHDR, boolean needPlay);

    void k0(@Nullable AudioModel audioModel, @NotNull AudioModel.Type audioType);

    @Deprecated(message = "forbidden to call session")
    @Nullable
    ICutSession l();

    boolean l0();

    @Nullable
    Map<String, WinkStickerModel> m();

    void m0(@NotNull ICutStatusCallback listener);

    @NotNull
    List<WinkEditData> n();

    void n0(int width, int height);

    void o(float r16);

    boolean p();

    void pause();

    void play();

    boolean q();

    @Deprecated(message = "forbidden to call mediaModel")
    void r(@NotNull MediaModel mediaModel);

    void release();

    void removePlayerListener(@NotNull IPlayer.PlayerListener playerListener);

    void s(float f16, @NotNull AudioModel.Type type);

    void seek(long j3);

    void seek(long j3, boolean z16);

    void setAutoPlay(boolean isAutoPlay);

    void setLoopPlay(boolean isLoop);

    void setPlayTimeRange(long startTimeUs, long durationUs);

    void stop(long timeUs);

    void t(@NotNull WinkStickerModel stickerModel, boolean isTransition);

    void u();

    void v(@NotNull Map<Integer, Float> clipVolumes);

    @NotNull
    HashMap<String, List<String>> w();

    void x(@NotNull BasePartFragment basePartFragment, @NotNull WinkTavCutParams winkTavCutParams, @NotNull HashMap<String, Object> hashMap);

    @NotNull
    List<SpecialEffectModel> y();

    @NotNull
    List<String> z();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\bR \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dr$a;", "", "", "b", "J", "c", "()J", "getMaxPlayerTimeLimit$annotations", "()V", "maxPlayerTimeLimit", "", "", "Ljava/util/List;", "DEVICES_RECREATE_PLAYER_WHEN_RESUME", "Lorg/light/listener/OnLoadAssetListener;", "d", "Lorg/light/listener/OnLoadAssetListener;", "()Lorg/light/listener/OnLoadAssetListener;", "ASSET_LISTENER_DEFAULT", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.dr$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a */
        static final /* synthetic */ Companion f319911a = new Companion();

        /* renamed from: b, reason: from kotlin metadata */
        private static final long maxPlayerTimeLimit = WinkConfig.f317649a.b();

        /* renamed from: c, reason: from kotlin metadata */
        @NotNull
        private static final List<String> DEVICES_RECREATE_PLAYER_WHEN_RESUME;

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private static final OnLoadAssetListener ASSET_LISTENER_DEFAULT;

        static {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("V1813BA");
            DEVICES_RECREATE_PLAYER_WHEN_RESUME = listOf;
            ASSET_LISTENER_DEFAULT = new C9021a();
        }

        Companion() {
        }

        @NotNull
        public final OnLoadAssetListener b() {
            return ASSET_LISTENER_DEFAULT;
        }

        public final long c() {
            return maxPlayerTimeLimit;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/dr$a$a", "Lorg/light/listener/OnLoadAssetListener;", "", "p0", "", "OnLoadAssetError", "Ljava/util/HashMap;", "", "OnAssetProcessing", "", "OnAssetDurationChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.dr$a$a */
        /* loaded from: classes21.dex */
        public static final class C9021a implements OnLoadAssetListener {
            C9021a() {
            }

            @Override // org.light.listener.OnLoadAssetListener
            public void OnAssetDurationChange(long p06) {
            }

            @Override // org.light.listener.OnLoadAssetListener
            public void OnAssetProcessing(@Nullable HashMap<String, String> p06) {
            }

            @Override // org.light.listener.OnLoadAssetListener
            public void OnLoadAssetError(int p06) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\bY\u0010ZJ\u009c\u0002\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u00c6\u0001\u00a2\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\tH\u00d6\u0001J\t\u0010'\u001a\u00020\fH\u00d6\u0001J\u0013\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b@\u0010=\u001a\u0004\bA\u0010?R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER7\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00128\u0006\u00a2\u0006\f\n\u0004\bA\u0010F\u001a\u0004\b1\u0010GR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bH\u0010*\u001a\u0004\b@\u0010,R\u0017\u0010\u0015\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\bI\u0010=\u001a\u0004\bJ\u0010?R\u0017\u0010\u0017\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\bD\u0010K\u001a\u0004\bH\u0010LR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bM\u0010*\u001a\u0004\b<\u0010,R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bJ\u0010*\u001a\u0004\bN\u0010,R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\bO\u00106\u001a\u0004\bP\u00108R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bM\u0010S\"\u0004\bT\u0010UR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b5\u0010,R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bP\u0010*\u001a\u0004\bB\u0010,R\u0017\u0010\u001f\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\bV\u0010=\u001a\u0004\bO\u0010?R\u0017\u0010 \u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b>\u0010=\u001a\u0004\bQ\u0010?R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b3\u0010*\u001a\u0004\bI\u0010,R\u0019\u0010#\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b+\u0010W\u001a\u0004\bV\u0010X\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dr$c;", "", "", "isFirstInit", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "winkEditData", "", "templatePath", "isFromTemplateColl", "", "width", "height", "Landroid/view/Surface;", "playerSurface", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "enableSoftDecode", "softDecodeThreadCount", "", "maxPlayerTimeLimit", "enableImageTemplateEdit", "isFromQzoneText", "textQzoneText", "Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;", "scene", "autoPlay", "enableVideoFilter", "surfaceHeight", "surfaceWidth", "needPaintingFlush", "Lorg/light/WatermarkConfig;", "watermarkConfig", "a", "(ZLcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;IILandroid/view/Surface;Ljava/util/HashMap;ZIJZZLjava/lang/String;Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;ZZIIZLorg/light/WatermarkConfig;)Lcom/tencent/mobileqq/wink/editor/dr$c;", "toString", "hashCode", "other", "equals", "Z", "v", "()Z", "b", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "e", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "c", "Ljava/util/List;", "u", "()Ljava/util/List;", "d", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "Ljava/lang/Boolean;", HippyTKDListViewAdapter.X, "()Ljava/lang/Boolean;", "f", "I", "t", "()I", "g", "i", tl.h.F, "Landroid/view/Surface;", "l", "()Landroid/view/Surface;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "j", "k", DomainData.DOMAIN_NAME, "J", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "o", "r", "p", "Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;", "()Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;", "y", "(Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;)V", ReportConstant.COSTREPORT_PREFIX, "Lorg/light/WatermarkConfig;", "()Lorg/light/WatermarkConfig;", "<init>", "(ZLcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;IILandroid/view/Surface;Ljava/util/HashMap;ZIJZZLjava/lang/String;Lcom/tencent/mobileqq/wink/editor/model/WinkTavCutScene;ZZIIZLorg/light/WatermarkConfig;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.dr$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class WinkTavCutParams {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final boolean isFirstInit;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @NotNull
        private final WinkEditorViewModel.EditMode editMode;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @NotNull
        private final List<WinkEditData> winkEditData;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        @Nullable
        private final String templatePath;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        @Nullable
        private final Boolean isFromTemplateColl;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final int width;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final int height;

        /* renamed from: h, reason: from toString */
        @Nullable
        private final Surface playerSurface;

        /* renamed from: i, reason: from kotlin metadata and from toString */
        @Nullable
        private final HashMap<String, String> assetData;

        /* renamed from: j, reason: from kotlin metadata and from toString */
        private final boolean enableSoftDecode;

        /* renamed from: k, reason: from kotlin metadata and from toString */
        private final int softDecodeThreadCount;

        /* renamed from: l, reason: from kotlin metadata and from toString */
        private final long maxPlayerTimeLimit;

        /* renamed from: m, reason: from toString */
        private final boolean enableImageTemplateEdit;

        /* renamed from: n, reason: from toString */
        private final boolean isFromQzoneText;

        /* renamed from: o, reason: from kotlin metadata and from toString */
        @Nullable
        private final String textQzoneText;

        /* renamed from: p, reason: from kotlin metadata and from toString */
        @NotNull
        private WinkTavCutScene scene;

        /* renamed from: q, reason: from toString */
        private final boolean autoPlay;

        /* renamed from: r, reason: from kotlin metadata and from toString */
        private final boolean enableVideoFilter;

        /* renamed from: s, reason: from toString */
        private final int surfaceHeight;

        /* renamed from: t, reason: from kotlin metadata and from toString */
        private final int surfaceWidth;

        /* renamed from: u, reason: from kotlin metadata and from toString */
        private final boolean needPaintingFlush;

        /* renamed from: v, reason: from kotlin metadata and from toString */
        @Nullable
        private final WatermarkConfig watermarkConfig;

        public WinkTavCutParams(boolean z16, @NotNull WinkEditorViewModel.EditMode editMode, @NotNull List<WinkEditData> winkEditData, @Nullable String str, @Nullable Boolean bool, int i3, int i16, @Nullable Surface surface, @Nullable HashMap<String, String> hashMap, boolean z17, int i17, long j3, boolean z18, boolean z19, @Nullable String str2, @NotNull WinkTavCutScene scene, boolean z26, boolean z27, int i18, int i19, boolean z28, @Nullable WatermarkConfig watermarkConfig) {
            Intrinsics.checkNotNullParameter(editMode, "editMode");
            Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
            Intrinsics.checkNotNullParameter(scene, "scene");
            this.isFirstInit = z16;
            this.editMode = editMode;
            this.winkEditData = winkEditData;
            this.templatePath = str;
            this.isFromTemplateColl = bool;
            this.width = i3;
            this.height = i16;
            this.playerSurface = surface;
            this.assetData = hashMap;
            this.enableSoftDecode = z17;
            this.softDecodeThreadCount = i17;
            this.maxPlayerTimeLimit = j3;
            this.enableImageTemplateEdit = z18;
            this.isFromQzoneText = z19;
            this.textQzoneText = str2;
            this.scene = scene;
            this.autoPlay = z26;
            this.enableVideoFilter = z27;
            this.surfaceHeight = i18;
            this.surfaceWidth = i19;
            this.needPaintingFlush = z28;
            this.watermarkConfig = watermarkConfig;
        }

        @NotNull
        public final WinkTavCutParams a(boolean isFirstInit, @NotNull WinkEditorViewModel.EditMode editMode, @NotNull List<WinkEditData> winkEditData, @Nullable String templatePath, @Nullable Boolean isFromTemplateColl, int width, int height, @Nullable Surface playerSurface, @Nullable HashMap<String, String> assetData, boolean enableSoftDecode, int softDecodeThreadCount, long maxPlayerTimeLimit, boolean enableImageTemplateEdit, boolean isFromQzoneText, @Nullable String textQzoneText, @NotNull WinkTavCutScene scene, boolean autoPlay, boolean enableVideoFilter, int surfaceHeight, int surfaceWidth, boolean needPaintingFlush, @Nullable WatermarkConfig watermarkConfig) {
            Intrinsics.checkNotNullParameter(editMode, "editMode");
            Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
            Intrinsics.checkNotNullParameter(scene, "scene");
            return new WinkTavCutParams(isFirstInit, editMode, winkEditData, templatePath, isFromTemplateColl, width, height, playerSurface, assetData, enableSoftDecode, softDecodeThreadCount, maxPlayerTimeLimit, enableImageTemplateEdit, isFromQzoneText, textQzoneText, scene, autoPlay, enableVideoFilter, surfaceHeight, surfaceWidth, needPaintingFlush, watermarkConfig);
        }

        @Nullable
        public final HashMap<String, String> c() {
            return this.assetData;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getAutoPlay() {
            return this.autoPlay;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final WinkEditorViewModel.EditMode getEditMode() {
            return this.editMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WinkTavCutParams)) {
                return false;
            }
            WinkTavCutParams winkTavCutParams = (WinkTavCutParams) other;
            if (this.isFirstInit == winkTavCutParams.isFirstInit && this.editMode == winkTavCutParams.editMode && Intrinsics.areEqual(this.winkEditData, winkTavCutParams.winkEditData) && Intrinsics.areEqual(this.templatePath, winkTavCutParams.templatePath) && Intrinsics.areEqual(this.isFromTemplateColl, winkTavCutParams.isFromTemplateColl) && this.width == winkTavCutParams.width && this.height == winkTavCutParams.height && Intrinsics.areEqual(this.playerSurface, winkTavCutParams.playerSurface) && Intrinsics.areEqual(this.assetData, winkTavCutParams.assetData) && this.enableSoftDecode == winkTavCutParams.enableSoftDecode && this.softDecodeThreadCount == winkTavCutParams.softDecodeThreadCount && this.maxPlayerTimeLimit == winkTavCutParams.maxPlayerTimeLimit && this.enableImageTemplateEdit == winkTavCutParams.enableImageTemplateEdit && this.isFromQzoneText == winkTavCutParams.isFromQzoneText && Intrinsics.areEqual(this.textQzoneText, winkTavCutParams.textQzoneText) && this.scene == winkTavCutParams.scene && this.autoPlay == winkTavCutParams.autoPlay && this.enableVideoFilter == winkTavCutParams.enableVideoFilter && this.surfaceHeight == winkTavCutParams.surfaceHeight && this.surfaceWidth == winkTavCutParams.surfaceWidth && this.needPaintingFlush == winkTavCutParams.needPaintingFlush && Intrinsics.areEqual(this.watermarkConfig, winkTavCutParams.watermarkConfig)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getEnableImageTemplateEdit() {
            return this.enableImageTemplateEdit;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getEnableSoftDecode() {
            return this.enableSoftDecode;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getEnableVideoFilter() {
            return this.enableVideoFilter;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v44 */
        /* JADX WARN: Type inference failed for: r0v45 */
        /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v24, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v31, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v33, types: [boolean] */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            boolean z16 = this.isFirstInit;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode6 = ((((r06 * 31) + this.editMode.hashCode()) * 31) + this.winkEditData.hashCode()) * 31;
            String str = this.templatePath;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (hashCode6 + hashCode) * 31;
            Boolean bool = this.isFromTemplateColl;
            if (bool == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = bool.hashCode();
            }
            int i18 = (((((i17 + hashCode2) * 31) + this.width) * 31) + this.height) * 31;
            Surface surface = this.playerSurface;
            if (surface == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = surface.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            HashMap<String, String> hashMap = this.assetData;
            if (hashMap == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = hashMap.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            ?? r26 = this.enableSoftDecode;
            int i27 = r26;
            if (r26 != 0) {
                i27 = 1;
            }
            int a16 = (((((i26 + i27) * 31) + this.softDecodeThreadCount) * 31) + androidx.fragment.app.a.a(this.maxPlayerTimeLimit)) * 31;
            ?? r27 = this.enableImageTemplateEdit;
            int i28 = r27;
            if (r27 != 0) {
                i28 = 1;
            }
            int i29 = (a16 + i28) * 31;
            ?? r28 = this.isFromQzoneText;
            int i36 = r28;
            if (r28 != 0) {
                i36 = 1;
            }
            int i37 = (i29 + i36) * 31;
            String str2 = this.textQzoneText;
            if (str2 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str2.hashCode();
            }
            int hashCode7 = (((i37 + hashCode5) * 31) + this.scene.hashCode()) * 31;
            ?? r29 = this.autoPlay;
            int i38 = r29;
            if (r29 != 0) {
                i38 = 1;
            }
            int i39 = (hashCode7 + i38) * 31;
            ?? r210 = this.enableVideoFilter;
            int i46 = r210;
            if (r210 != 0) {
                i46 = 1;
            }
            int i47 = (((((i39 + i46) * 31) + this.surfaceHeight) * 31) + this.surfaceWidth) * 31;
            boolean z17 = this.needPaintingFlush;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i48 = (i47 + i3) * 31;
            WatermarkConfig watermarkConfig = this.watermarkConfig;
            if (watermarkConfig != null) {
                i16 = watermarkConfig.hashCode();
            }
            return i48 + i16;
        }

        /* renamed from: i, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: j, reason: from getter */
        public final long getMaxPlayerTimeLimit() {
            return this.maxPlayerTimeLimit;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getNeedPaintingFlush() {
            return this.needPaintingFlush;
        }

        @Nullable
        /* renamed from: l, reason: from getter */
        public final Surface getPlayerSurface() {
            return this.playerSurface;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final WinkTavCutScene getScene() {
            return this.scene;
        }

        /* renamed from: n, reason: from getter */
        public final int getSoftDecodeThreadCount() {
            return this.softDecodeThreadCount;
        }

        /* renamed from: o, reason: from getter */
        public final int getSurfaceHeight() {
            return this.surfaceHeight;
        }

        /* renamed from: p, reason: from getter */
        public final int getSurfaceWidth() {
            return this.surfaceWidth;
        }

        @Nullable
        /* renamed from: q, reason: from getter */
        public final String getTemplatePath() {
            return this.templatePath;
        }

        @Nullable
        /* renamed from: r, reason: from getter */
        public final String getTextQzoneText() {
            return this.textQzoneText;
        }

        @Nullable
        /* renamed from: s, reason: from getter */
        public final WatermarkConfig getWatermarkConfig() {
            return this.watermarkConfig;
        }

        /* renamed from: t, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        @NotNull
        public String toString() {
            return "WinkTavCutParams(isFirstInit=" + this.isFirstInit + ", editMode=" + this.editMode + ", winkEditData=" + this.winkEditData + ", templatePath=" + this.templatePath + ", isFromTemplateColl=" + this.isFromTemplateColl + ", width=" + this.width + ", height=" + this.height + ", playerSurface=" + this.playerSurface + ", assetData=" + this.assetData + ", enableSoftDecode=" + this.enableSoftDecode + ", softDecodeThreadCount=" + this.softDecodeThreadCount + ", maxPlayerTimeLimit=" + this.maxPlayerTimeLimit + ", enableImageTemplateEdit=" + this.enableImageTemplateEdit + ", isFromQzoneText=" + this.isFromQzoneText + ", textQzoneText=" + this.textQzoneText + ", scene=" + this.scene + ", autoPlay=" + this.autoPlay + ", enableVideoFilter=" + this.enableVideoFilter + ", surfaceHeight=" + this.surfaceHeight + ", surfaceWidth=" + this.surfaceWidth + ", needPaintingFlush=" + this.needPaintingFlush + ", watermarkConfig=" + this.watermarkConfig + ")";
        }

        @NotNull
        public final List<WinkEditData> u() {
            return this.winkEditData;
        }

        /* renamed from: v, reason: from getter */
        public final boolean getIsFirstInit() {
            return this.isFirstInit;
        }

        /* renamed from: w, reason: from getter */
        public final boolean getIsFromQzoneText() {
            return this.isFromQzoneText;
        }

        @Nullable
        /* renamed from: x, reason: from getter */
        public final Boolean getIsFromTemplateColl() {
            return this.isFromTemplateColl;
        }

        public final void y(@NotNull WinkTavCutScene winkTavCutScene) {
            Intrinsics.checkNotNullParameter(winkTavCutScene, "<set-?>");
            this.scene = winkTavCutScene;
        }

        public /* synthetic */ WinkTavCutParams(boolean z16, WinkEditorViewModel.EditMode editMode, List list, String str, Boolean bool, int i3, int i16, Surface surface, HashMap hashMap, boolean z17, int i17, long j3, boolean z18, boolean z19, String str2, WinkTavCutScene winkTavCutScene, boolean z26, boolean z27, int i18, int i19, boolean z28, WatermarkConfig watermarkConfig, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this((i26 & 1) != 0 ? true : z16, editMode, list, (i26 & 8) != 0 ? null : str, (i26 & 16) != 0 ? Boolean.FALSE : bool, i3, i16, (i26 & 128) != 0 ? null : surface, (i26 & 256) != 0 ? null : hashMap, (i26 & 512) != 0 ? false : z17, (i26 & 1024) != 0 ? 4 : i17, (i26 & 2048) != 0 ? WinkConfig.f317649a.b() : j3, (i26 & 4096) != 0 ? false : z18, (i26 & 8192) != 0 ? false : z19, (i26 & 16384) != 0 ? null : str2, winkTavCutScene, (65536 & i26) != 0 ? false : z26, (131072 & i26) != 0 ? true : z27, (262144 & i26) != 0 ? 0 : i18, (524288 & i26) != 0 ? 0 : i19, (1048576 & i26) != 0 ? true : z28, (i26 & 2097152) != 0 ? null : watermarkConfig);
        }
    }
}
