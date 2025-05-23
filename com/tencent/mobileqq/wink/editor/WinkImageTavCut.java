package com.tencent.mobileqq.wink.editor;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.GYVideoClassifyResult;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditStretchedData;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicDataSerializable;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.g;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.event.ImageChangePageEvent;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.event.TemplateSelectEvent;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.HDRModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaModelUtilsKt;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.WatermarkConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.listener.OnClipAssetListener;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u001f\u0018\u0000 \u00ba\u00012\u00020\u00012\u00020\u0002:\u0003\u0097\u0001iB\u0015\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0006\b\u00d8\u0002\u0010\u0091\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J*\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J&\u0010(\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\bH\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\bH\u0002Jt\u0010>\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032&\u00107\u001a\"\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u000105j\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u0001`62\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u001dH\u0002J2\u0010?\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020\u001dH\u0002J\u0016\u0010B\u001a\u00020\b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0$H\u0002J.\u0010H\u001a\u0002032\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020\u00052\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0$H\u0002J$\u0010L\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u001d2\b\b\u0002\u0010K\u001a\u00020;H\u0002J\b\u0010N\u001a\u00020MH\u0002J:\u0010S\u001a\u00020\b2\u0006\u0010O\u001a\u0002032\u0018\u0010Q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0P0$2\u0006\u0010R\u001a\u00020/2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u0014\u0010U\u001a\u0004\u0018\u00010T2\b\u00100\u001a\u0004\u0018\u00010/H\u0002J\b\u0010V\u001a\u00020\u001aH\u0016J0\u0010\\\u001a\u00020\b2\u0006\u0010X\u001a\u00020W2\u0006\u0010,\u001a\u00020+2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020Y05j\u0002`ZH\u0016J2\u0010_\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010,\u001a\u00020+2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020Y05j\u0002`ZH\u0016J\b\u0010`\u001a\u00020\u001dH\u0016J\b\u0010a\u001a\u00020\u001dH\u0016J\u0016\u0010b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0016\u0010c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016J\n\u0010g\u001a\u0004\u0018\u00010fH\u0016J\u0010\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u00020\u001dH\u0016J\b\u0010j\u001a\u00020\bH\u0016J\u0010\u0010l\u001a\u00020\b2\u0006\u0010k\u001a\u00020\u0005H\u0016J\b\u0010m\u001a\u00020\u0017H\u0016J\u000e\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0016J\u0010\u0010p\u001a\u00020\b2\u0006\u0010o\u001a\u00020\u001dH\u0016J\u0016\u0010s\u001a\u00020\b2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\b0qH\u0016J\u0010\u0010t\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u0017H\u0016J\u0014\u0010v\u001a\u00020\b2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00170$J\b\u0010w\u001a\u00020;H\u0016J\u0010\u0010x\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u001c\u0010{\u001a\u00020\b2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020@0yH\u0016J\u0018\u0010~\u001a\u00020\b2\u0006\u0010|\u001a\u00020@2\u0006\u0010}\u001a\u00020\u001dH\u0016J\u0012\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0016J\u0018\u0010\u0083\u0001\u001a\u00020\b2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020@0$H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\b2\u0006\u0010|\u001a\u00020@H\u0016J\u0017\u0010\u0085\u0001\u001a\u00020\b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0$H\u0016J\u0017\u0010\u0086\u0001\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020@\u0018\u00010yH\u0016J)\u0010\u008b\u0001\u001a\u00020\b2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u008a\u0001\u001a\u00020\u001dH\u0016J\u001f\u0010\u0090\u0001\u001a\u00020\b2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010\u0092\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\u001a2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010\u0093\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\u001a2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0016J\u001e\u0010\u0096\u0001\u001a\u00020\b2\u0013\u0010\u0095\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0PH\u0016J\t\u0010\u0097\u0001\u001a\u00020MH\u0016J\u0013\u0010\u0098\u0001\u001a\u00020M2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u009b\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u009c\u0001\u001a\u00020\bH\u0016J\t\u0010\u009d\u0001\u001a\u00020\u001dH\u0016J\u0019\u0010\u009e\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\t\u0010\u009f\u0001\u001a\u00020MH\u0016J\u0012\u0010\u00a1\u0001\u001a\u00020\b2\u0007\u0010\u00a0\u0001\u001a\u00020MH\u0016J\u000f\u0010\u00a2\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150$H\u0016J\t\u0010\u00a3\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u00a4\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u00a5\u0001\u001a\u00020/H\u0016J\t\u0010\u00a6\u0001\u001a\u00020\u001dH\u0016J\u000b\u0010\u00a7\u0001\u001a\u0004\u0018\u00010/H\u0016J\t\u0010\u00a8\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u00a9\u0001\u001a\u00020\u001dH\u0016J\u000b\u0010\u00aa\u0001\u001a\u0004\u0018\u00010/H\u0016J\t\u0010\u00ab\u0001\u001a\u00020\bH\u0016J\u001e\u0010\u00ad\u0001\u001a\u00020\b2\u0015\u0010\u00ac\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010/0PJ-\u0010\u00b2\u0001\u001a\u00020\b2\u0007\u0010\u00ae\u0001\u001a\u00020\u001d2\u0007\u0010\u00af\u0001\u001a\u00020\u00052\u0007\u0010\u00b0\u0001\u001a\u00020\u00052\u0007\u0010\u00b1\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u00b3\u0001\u001a\u00020MH\u0016J\u0012\u0010\u00b4\u0001\u001a\u00020\b2\u0007\u0010\u00b0\u0001\u001a\u00020\u0005H\u0016J\u000f\u0010\u00b5\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0016J\u0011\u0010\u00b6\u0001\u001a\u00020\b2\u0006\u0010o\u001a\u00020\u001dH\u0016J1\u0010\u00b7\u0001\u001a*\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0$05j\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0$`6H\u0016J\f\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0016J\u0011\u0010\u00ba\u0001\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010$H\u0016J\u000f\u0010\u00bb\u0001\u001a\b\u0012\u0004\u0012\u00020/0$H\u0016J6\u0010\u00bd\u0001\u001a\u00020\b2\u0006\u00100\u001a\u00020/2#\u0010\u00bc\u0001\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/05j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/`6H\u0016J\t\u0010\u00be\u0001\u001a\u00020;H\u0016J\t\u0010\u00bf\u0001\u001a\u00020\bH\u0016J\t\u0010\u00c0\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u00c1\u0001\u001a\u00020\bH\u0016J\t\u0010\u00c2\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010\u00c4\u0001\u001a\u00020\b2\u0007\u0010\u00c3\u0001\u001a\u00020;H\u0016J\u001b\u0010\u00c4\u0001\u001a\u00020\b2\u0007\u0010\u00c3\u0001\u001a\u00020;2\u0007\u0010\u00c5\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010\u00c6\u0001\u001a\u00020\b2\u0007\u0010\u00c3\u0001\u001a\u00020;H\u0016J\u0012\u0010\u00c8\u0001\u001a\u00020\b2\u0007\u0010\u00c7\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010\u00ca\u0001\u001a\u00020\b2\u0007\u0010\u00c9\u0001\u001a\u00020\u001dH\u0016J\u001b\u0010\u00cd\u0001\u001a\u00020\b2\u0007\u0010\u00cb\u0001\u001a\u00020;2\u0007\u0010\u00cc\u0001\u001a\u00020;H\u0016J\u000f\u0010\u00ce\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u000f\u0010\u00cf\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010\u00d1\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d0\u00010$H\u0016J$\u0010\u00d5\u0001\u001a\u00020\b2\u001b\u0010\u00d4\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00d0\u00010\u00d2\u0001j\n\u0012\u0005\u0012\u00030\u00d0\u0001`\u00d3\u0001J\u0019\u0010\u00d8\u0001\u001a\u00020\b2\u0007\u0010\u00d6\u0001\u001a\u00020\u00052\u0007\u0010\u00d7\u0001\u001a\u00020\u001dJ\u001b\u0010\u00da\u0001\u001a\u00020\b2\u0007\u0010\u00d6\u0001\u001a\u00020\u00052\t\u0010\u00d9\u0001\u001a\u0004\u0018\u000101J\u0007\u0010\u00db\u0001\u001a\u00020\u001dJK\u0010\u00e1\u0001\u001a\u00020\b2%\u0010\u00dd\u0001\u001a \u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u00dc\u000105j\u000f\u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u00dc\u0001`62\u0007\u0010\u00de\u0001\u001a\u00020;2\u0007\u0010\u00df\u0001\u001a\u00020\u001d2\u0007\u0010\u00e0\u0001\u001a\u00020\u001dH\u0016J\u0013\u0010\u00e4\u0001\u001a\u00020\b2\b\u0010\u00e3\u0001\u001a\u00030\u00e2\u0001H\u0016J\u0013\u0010\u00e5\u0001\u001a\u00020\b2\b\u0010\u00e3\u0001\u001a\u00030\u00e2\u0001H\u0016J\u0013\u0010\u00e8\u0001\u001a\u00020\b2\b\u0010\u00e7\u0001\u001a\u00030\u00e6\u0001H\u0016J\u0013\u0010\u00e9\u0001\u001a\u00020\b2\b\u0010\u00e7\u0001\u001a\u00030\u00e6\u0001H\u0016J\u0013\u0010\u00eb\u0001\u001a\u00020\b2\b\u0010\u00e7\u0001\u001a\u00030\u00ea\u0001H\u0016J\u0013\u0010\u00ec\u0001\u001a\u00020\b2\b\u0010\u00e7\u0001\u001a\u00030\u00ea\u0001H\u0016J-\u0010\u00f1\u0001\u001a\b\u0012\u0004\u0012\u00020%0$2\u001c\u0010\u00f0\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u00ee\u0001\u0012\u0005\u0012\u00030\u00ef\u00010\u00ed\u00010$H\u0016J\u0017\u0010\u00f2\u0001\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0019\u0010\u00f3\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\t\u0010\u00f4\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u00f5\u0001\u001a\u00020;H\u0016J\u0012\u0010\u00f7\u0001\u001a\u00020\b2\u0007\u0010\u00f6\u0001\u001a\u00020/H\u0016J\u0011\u0010\u00fa\u0001\u001a\u00020\b2\b\u0010\u00f9\u0001\u001a\u00030\u00f8\u0001J\u0011\u0010\u00fb\u0001\u001a\u00020\b2\b\u0010\u00f9\u0001\u001a\u00030\u00f8\u0001J#\u0010\u00fe\u0001\u001a\u00020'2\u0006\u0010I\u001a\u00020\u00172\u0007\u0010\u00fc\u0001\u001a\u00020\u00052\u0007\u0010\u00fd\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00ff\u0001\u001a\u00020\bH\u0016J\u0013\u0010\u0081\u0002\u001a\u00020\b2\n\u0010\u00e7\u0001\u001a\u0005\u0018\u00010\u0080\u0002J.\u0010\u0085\u0002\u001a\u00020\b2\u0007\u0010r\u001a\u00030\u0082\u00022\u0006\u0010:\u001a\u00020\u001d2\u0007\u0010\u0083\u0002\u001a\u00020\u001d2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010/H\u0016J,\u0010\u0086\u0002\u001a\u00020\b2#\u0010\u00bc\u0001\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/05j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/`6J$\u0010\u0087\u0002\u001a\u00020\b2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020@0y2\u0007\u0010\u00c3\u0001\u001a\u00020;J#\u0010\u0088\u0002\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u001d2\b\b\u0002\u0010K\u001a\u00020;J!\u0010\u008b\u0002\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u00172\u0007\u0010\u0089\u0002\u001a\u00020'2\u0007\u0010\u008a\u0002\u001a\u00020\u001aJ\u000f\u0010\u008c\u0002\u001a\b\u0012\u0004\u0012\u00020@0$H\u0016R)\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0017\n\u0005\bi\u0010\u008d\u0002\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002R\u001c\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u0093\u0002R\u001c\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ec\u0001\u0010\u0096\u0002R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0099\u0002R\u0018\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008c\u0002\u0010\u009b\u0002R\u001c\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009c\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ff\u0001\u0010\u009d\u0002R\u001b\u0010\u00a0\u0002\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u009f\u0002R\u001a\u0010\u00a2\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\ba\u0010\u00a1\u0002R)\u0010\u00a7\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ba\u0001\u001a\u0006\b\u00a3\u0002\u0010\u00a4\u0002\"\u0006\b\u00a5\u0002\u0010\u00a6\u0002R\u0019\u0010\u00a8\u0002\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00ba\u0001R\u0018\u0010\u00aa\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bg\u0010\u00a9\u0002R\u0019\u0010\u00ab\u0002\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u00ba\u0001R\u0019\u0010\u00ac\u0002\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00ba\u0001R\u001f\u0010\u00ae\u0002\u001a\b\u0012\u0004\u0012\u00020\u00170$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u00ad\u0002R\u0019\u0010\u00af\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u00a9\u0002R\u001e\u0010\u00b0\u0002\u001a\b\u0012\u0004\u0012\u00020\u00170$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u00ad\u0002R\u0018\u0010\u00b1\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bt\u0010\u00a9\u0002R\u0019\u0010\u00b2\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u00a9\u0002R\u0018\u0010\u00c0\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b~\u0010\u00a9\u0002R\u0019\u0010\u00b3\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u00a9\u0002R\u0019\u0010\u00b4\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u00b5\u0001RA\u0010\u00b6\u0002\u001a*\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0$05j\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0$`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b5\u0002R\u001e\u0010\u00b9\u0002\u001a\n\u0012\u0005\u0012\u00030\u00f8\u00010\u00b7\u00028\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\\\u0010\u00b8\u0002R \u0010\u00bc\u0002\u001a\t\u0012\u0004\u0012\u00020\u007f0\u00ba\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0002\u0010\u00ad\u0002R\u0019\u0010\u00bd\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00a9\u0002R\u001b\u0010\u00bf\u0002\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u00be\u0002R\u001e\u0010\u00c0\u0002\u001a\n\u0012\u0005\u0012\u00030\u00ea\u00010\u00b7\u00028\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b{\u0010\u00b8\u0002R)\u0010\u00c1\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a1\u0001\u0010\u00a9\u0002\u001a\u0006\b\u00c1\u0002\u0010\u00c2\u0002\"\u0006\b\u00c3\u0002\u0010\u00c4\u0002R+\u0010\u00c7\u0002\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b6\u0001\u0010\u008d\u0002\u001a\u0006\b\u00c5\u0002\u0010\u008f\u0002\"\u0006\b\u00c6\u0002\u0010\u0091\u0002R)\u0010\u00c8\u0002\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b9\u0001\u0010\u00a9\u0002\u001a\u0006\b\u00c8\u0002\u0010\u00c2\u0002\"\u0006\b\u00c9\u0002\u0010\u00c4\u0002R\u001b\u0010\u00cb\u0002\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00ca\u0002R)\u0010\u00cf\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00cc\u0002\u0010\u00ba\u0001\u001a\u0006\b\u00cd\u0002\u0010\u00a4\u0002\"\u0006\b\u00ce\u0002\u0010\u00a6\u0002R)\u0010\u00d2\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u00ba\u0001\u001a\u0006\b\u00d0\u0002\u0010\u00a4\u0002\"\u0006\b\u00d1\u0002\u0010\u00a6\u0002R\u0017\u0010\u00d4\u0002\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00d3\u0002\u0010\u00c2\u0002R\u0019\u0010\u00d7\u0002\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00d5\u0002\u0010\u00d6\u0002\u00a8\u0006\u00d9\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "Lcom/tencent/mobileqq/wink/editor/dr;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "Landroid/view/Surface;", "surface", "", "surfaceWidth", "surfaceHeight", "", "c1", "d1", ICustomDataEditor.NUMBER_PARAM_1, "F1", "q1", "position", "Landroid/widget/FrameLayout;", "S0", "Landroid/view/TextureView;", "W0", "j1", Constants.APK_CERTIFICATE, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "editData", "Lcom/tencent/videocut/model/MediaModel;", "N0", "O0", "", "width", "height", "", "isSinglePlayer", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut$b;", "E0", "J0", "P0", "f1", "", "Lcom/tencent/videocut/model/MediaClip;", "clips", "Lcom/tencent/videocut/model/SizeF;", "I0", "H0", "t1", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "params", "k1", "l1", "", "templatePath", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "renderModel", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "applyNewTemplate", "enableImageTemplateEdit", "isClearStickers", "", "currentTimeUs", "needRecoveryTemplateFromDraft", "N1", "m1", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModelList", "p1", "modifyClipsDuration", "bgColor", "fillMode", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSources", "P1", "mediaModel", "needUpdate", "initTime", "Q1", "Lcom/tencent/videocut/model/Size;", "M0", "templateRenderModel", "", "mediaClipExtras", "color", "M1", "Lorg/light/lightAssetKit/enums/BackgroundFillMode;", "R0", "Y0", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", BaseConstants.ATTR_KET_EXTRA_MAP, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "containerView", "b1", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "i1", "x1", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "getPlayer", "Lcom/tencent/tavcut/core/session/ICutSession;", "l", "hidden", "b", "release", "state", "onPageScrollStateChanged", "V", "Q0", FileReaderHelper.OPEN_FILE_FROM_FORCE, HippyQQPagView.FunctionName.FLUSH, "Lkotlin/Function0;", "action", "L", "r", "mediaModels", "H1", "getDurationUs", "onPageSelected", "", "stickerModelMap", "B", "stickerModel", "isTransition", "t", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/d;", "stickerUpdateListener", "D0", "stickerModels", "W", "e", "T", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/videocut/model/FilterModel;", "filterModel", WadlProxyConsts.KEY_MATERIAL, "onlyUpdateIntensity", "i0", "Lcom/tencent/videocut/model/AudioModel;", "audioModel", "Lcom/tencent/videocut/model/AudioModel$Type;", "audioType", "k0", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, ReportConstant.COSTREPORT_PREFIX, "b0", "o", "clipVolumes", "v", "a", "d0", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "c0", "p", "u", "O", "n0", "getRenderSize", "size", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "U", "h1", "U0", "e1", "X", "g1", "l0", "T0", "j", "mosaicFiles", "J1", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "bottomOffset", "topOffset", "isBackgroundPanel", "Y", "M", BdhLogUtil.LogTag.Tag_Req, "J", "D", "w", "Lcom/gyailib/library/GYVideoClassifyResult;", "E", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "map", "u1", "getCurrentPlayUs", "pause", "isReady", "play", "isPlaying", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "openInAccurateSeek", "stop", "isLoop", "setLoopPlay", "isAutoPlay", "setAutoPlay", "startTimeUs", "durationUs", "setPlayTimeRange", "g0", "a0", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mosaicList", "I1", "selectedIndex", "isAIElimination", "C1", "template", Constants.BASE_IN_PLUGIN_ID, ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/videocut/model/HDRModel;", "inputMap", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "useHDR", "needPlay", "k", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "addPlayerListener", "removePlayerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "listener", UserInfo.SEX_FEMALE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "m0", "d", "Lkotlin/Pair;", "Landroid/graphics/Matrix;", "Landroid/graphics/RectF;", "cropInfoList", "c", "e0", "P", "Z0", tl.h.F, QzoneZipCacheHelper.DIR, "j0", "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut$b;", "callback", "C0", "o1", "paramsWidth", "paramsHeight", "G0", "g", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "w1", "Lcom/tencent/mobileqq/wink/editor/template/x$b;", "needChaneStrickerDirectly", "stickerText", "K", "v1", "K1", "A1", "renderSize", "fillScale", "E1", "f", "Ljava/lang/String;", "H", "()Ljava/lang/String;", "z1", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "indicator", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "renderLayer", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "Landroid/view/Surface;", "playerSurface", "L0", "()I", "setCurrentPosition", "(I)V", "currentPosition", "lastPosition", "Z", "pageChanged", "showAreaWidth", "showAreaHeight", "Ljava/util/List;", "oriMediaModels", "isHidden", "lastMediaModels", "isInit", "needStretchBack", "isLabelDetected", "labelDetectDuration", "Ljava/util/HashMap;", "mediaLabels", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onPageChangeCallbacks", "", "y", "stickerUpdateListeners", "needUpdateMosaicDoodle", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateMaterial", "cutStatusCallBackList", "isFromQzoneText", "()Z", "setFromQzoneText", "(Z)V", "getTextQzoneText", "setTextQzoneText", "textQzoneText", "isBackgroundTemplateInited", "setBackgroundTemplateInited", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "currentPlayer", "G", "getRenderWidth", "setRenderWidth", "renderWidth", "getRenderHeight", "setRenderHeight", "renderHeight", "X0", "usingTemplateMaterial", "h0", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "currentEditData", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkImageTavCut extends ViewPager2.OnPageChangeCallback implements dr {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial templateMaterial;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<ICutStatusCallback> cutStatusCallBackList;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFromQzoneText;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String textQzoneText;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isBackgroundTemplateInited;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPlayer currentPlayer;

    /* renamed from: G, reason: from kotlin metadata */
    private int renderWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int renderHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String templatePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView indicator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private dr.WinkTavCutParams params;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ComposeRenderLayer renderLayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ICutSession session;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface playerSurface;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int currentPosition;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int lastPosition;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean pageChanged;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int showAreaWidth;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int showAreaHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MediaModel> oriMediaModels;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isHidden;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MediaModel> lastMediaModels;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean needStretchBack;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isReady;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isLabelDetected;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private long labelDetectDuration;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, List<String>> mediaLabels;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> onPageChangeCallbacks;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.wink.editor.sticker.sticker.d> stickerUpdateListeners;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateMosaicDoodle;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut$a;", "", "", "Lcom/tencent/videocut/picker/MediaData;", "mediaData", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "a", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "b", "", "DURATION_US", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.WinkImageTavCut$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkEditData a(@NotNull List<MediaData> mediaData) {
            Intrinsics.checkNotNullParameter(mediaData, "mediaData");
            return new WinkEditData(com.tencent.videocut.render.repository.a.f384196a.b(mediaData), 10000000L, null, null, null, null, false, null, null, null, null, null, true, null, null, null, false, null, 258044, null);
        }

        @NotNull
        public final WinkEditData b(@NotNull List<? extends MediaClip> mediaClips) {
            Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
            return new WinkEditData(com.tencent.videocut.render.repository.a.f384196a.c(mediaClips), 10000000L, null, null, null, null, false, null, null, null, null, null, true, null, null, null, false, null, 258044, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut$b;", "", "", "newPosition", "", "a", "", "b", "()Z", "callAfterIdle", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(int newPosition);

        boolean b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\"\u0010\n\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkImageTavCut$c", "Lcom/tencent/mobileqq/wink/dect/b;", "", "", "result", "", "d", "Lcom/gyailib/library/GYVideoClassifyResult;", "b", "", "a", "Ljava/lang/Exception;", "e", "msg", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.dect.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.dect.d f318672b;

        c(com.tencent.mobileqq.wink.dect.d dVar) {
            this.f318672b = dVar;
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void a(@NotNull Map<String, ? extends List<String>> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            WinkImageTavCut.this.labelDetectDuration = System.currentTimeMillis() - WinkImageTavCut.this.labelDetectDuration;
            w53.b.f("WinkImageTavCut", "generateMediaLabels, onMultiResultAvailable, result.size = " + result.size() + ", duration = " + WinkImageTavCut.this.labelDetectDuration);
            WinkImageTavCut.this.isLabelDetected = true;
            WinkImageTavCut.this.mediaLabels.clear();
            WinkImageTavCut.this.mediaLabels.putAll(result);
            this.f318672b.e();
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void b(@NotNull GYVideoClassifyResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void c(@Nullable Exception e16, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            WinkImageTavCut.this.labelDetectDuration = System.currentTimeMillis() - WinkImageTavCut.this.labelDetectDuration;
            w53.b.f("WinkImageTavCut", "generateMediaLabels, onFailed: " + msg2 + "duration = " + WinkImageTavCut.this.labelDetectDuration);
            WinkImageTavCut.this.isLabelDetected = false;
            WinkImageTavCut.this.mediaLabels.clear();
            this.f318672b.e();
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void d(@NotNull List<String> result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkImageTavCut$d", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements TextureView.SurfaceTextureListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f318673d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkImageTavCut f318674e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f318675f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f318676h;

        d(int i3, WinkImageTavCut winkImageTavCut, Ref.IntRef intRef, Ref.IntRef intRef2) {
            this.f318673d = i3;
            this.f318674e = winkImageTavCut;
            this.f318675f = intRef;
            this.f318676h = intRef2;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            ms.a.f("WinkImageTavCut", "surfaceTextureListener " + this.f318673d + " :onSurfaceTextureAvailable ");
            if (this.f318673d == this.f318674e.getCurrentPosition()) {
                ms.a.f("WinkImageTavCut", "surfaceTextureListener " + this.f318673d + " :initPlayer ");
                this.f318674e.c1(new Surface(surfaceTexture), this.f318675f.element, this.f318676h.element);
                ComposeRenderLayer composeRenderLayer = this.f318674e.renderLayer;
                if (composeRenderLayer != null) {
                    dr.WinkTavCutParams winkTavCutParams = this.f318674e.params;
                    if (winkTavCutParams == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("params");
                        winkTavCutParams = null;
                    }
                    composeRenderLayer.l(winkTavCutParams.u().get(this.f318673d).getMediaModel());
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            ms.a.f("WinkImageTavCut", "surfaceTextureListener " + this.f318673d + " :onSurfaceTextureDestroyed ");
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            IPlayer player;
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            ms.a.f("WinkImageTavCut", "surfaceTextureListener " + this.f318673d + " :onSurfaceTextureSizeChanged ");
            ICutSession iCutSession = this.f318674e.session;
            if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
                player.changeSurfaceSize(width, height);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surfaceTexture) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkImageTavCut$e", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ICutStatusCallback {
        e() {
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            ComposeRenderLayer composeRenderLayer;
            ms.a.f("WinkImageTavCut", "ronLightEntityReload");
            if (rootEntity != null && (composeRenderLayer = WinkImageTavCut.this.renderLayer) != null) {
                composeRenderLayer.r(rootEntity);
            }
            Iterator it = WinkImageTavCut.this.cutStatusCallBackList.iterator();
            while (it.hasNext()) {
                ((ICutStatusCallback) it.next()).onLightEntityReload(rootEntity);
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            Iterator it = WinkImageTavCut.this.cutStatusCallBackList.iterator();
            while (it.hasNext()) {
                ((ICutStatusCallback) it.next()).onRenderChainReady();
            }
        }
    }

    public WinkImageTavCut() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void B1(WinkImageTavCut winkImageTavCut, MediaModel mediaModel, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        winkImageTavCut.A1(mediaModel, z16, j3);
    }

    private final WinkVideoTavCut.RenderSizeAndOriginSize E0(WinkEditData editData, float width, float height, boolean isSinglePlayer) {
        dr.WinkTavCutParams winkTavCutParams = null;
        if (!isSinglePlayer && (!J0(width, height) || com.tencent.mobileqq.wink.editor.draft.c.B(editData))) {
            dr.WinkTavCutParams winkTavCutParams2 = this.params;
            if (winkTavCutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams2 = null;
            }
            int width2 = winkTavCutParams2.getWidth();
            dr.WinkTavCutParams winkTavCutParams3 = this.params;
            if (winkTavCutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams3 = null;
            }
            int height2 = winkTavCutParams3.getHeight();
            if (!com.tencent.mobileqq.wink.editor.draft.c.B(editData)) {
                float f16 = width2;
                editData.setStretchData(new WinkEditStretchedData(true, f16, (height * f16) / width, 0.0f, 0.0f, 0.0f, 0.0f, 120, null));
            }
            WinkEditStretchedData stretchData = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData);
            float originWidth = stretchData.getOriginWidth();
            WinkEditStretchedData stretchData2 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData2);
            float originHeight = stretchData2.getOriginHeight();
            float f17 = (height2 - originHeight) / 2;
            float f18 = f17 + originHeight;
            float f19 = originHeight / originWidth;
            dr.WinkTavCutParams winkTavCutParams4 = this.params;
            if (winkTavCutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams4 = null;
            }
            float height3 = f19 / winkTavCutParams4.getHeight();
            dr.WinkTavCutParams winkTavCutParams5 = this.params;
            if (winkTavCutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams = winkTavCutParams5;
            }
            float width3 = height3 * winkTavCutParams.getWidth();
            WinkEditStretchedData stretchData3 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData3);
            stretchData3.setOriginScaleX(width3);
            return new WinkVideoTavCut.RenderSizeAndOriginSize(width2, height2, originWidth, originHeight, f17, f18, width3, true);
        }
        dr.WinkTavCutParams winkTavCutParams6 = this.params;
        if (winkTavCutParams6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams6 = null;
        }
        int width4 = winkTavCutParams6.getWidth();
        int i3 = (int) ((width4 * height) / width);
        dr.WinkTavCutParams winkTavCutParams7 = this.params;
        if (winkTavCutParams7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams7 = null;
        }
        if (i3 < winkTavCutParams7.getHeight()) {
            dr.WinkTavCutParams winkTavCutParams8 = this.params;
            if (winkTavCutParams8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams = winkTavCutParams8;
            }
            i3 = winkTavCutParams.getHeight();
            width4 = (int) ((width * i3) / height);
        }
        return new WinkVideoTavCut.RenderSizeAndOriginSize(width4, i3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, false);
    }

    static /* synthetic */ WinkVideoTavCut.RenderSizeAndOriginSize F0(WinkImageTavCut winkImageTavCut, WinkEditData winkEditData, float f16, float f17, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return winkImageTavCut.E0(winkEditData, f16, f17, z16);
    }

    private final void F1() {
        Object orNull;
        Map<String, WinkStickerModel> stickerModelMap;
        Collection<WinkStickerModel> values;
        String str;
        if (!this.needUpdateMosaicDoodle) {
            this.needUpdateMosaicDoodle = true;
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        dr.WinkTavCutParams winkTavCutParams = this.params;
        Object obj = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), this.currentPosition);
        WinkEditData winkEditData = (WinkEditData) orNull;
        if (winkEditData != null && (stickerModelMap = winkEditData.getStickerModelMap()) != null && (values = stickerModelMap.values()) != null) {
            Iterator<T> it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((WinkStickerModel) next).isMosaicDoodleSticker()) {
                    obj = next;
                    break;
                }
            }
            WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
            if (winkStickerModel != null) {
                Integer valueOf = Integer.valueOf(this.currentPosition);
                MetaMaterial material = winkStickerModel.getMaterial();
                if (material == null || (str = com.tencent.mobileqq.wink.editor.sticker.m.y(material)) == null) {
                    str = "";
                }
                linkedHashMap.put(valueOf, str);
                J1(linkedHashMap);
            }
        }
    }

    private final void G1() {
        if (this.isHidden) {
            TextView textView = this.indicator;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        dr.WinkTavCutParams winkTavCutParams = this.params;
        dr.WinkTavCutParams winkTavCutParams2 = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        if (winkTavCutParams.u().size() > 1) {
            TextView textView2 = this.indicator;
            if (textView2 != null) {
                int i3 = this.currentPosition + 1;
                dr.WinkTavCutParams winkTavCutParams3 = this.params;
                if (winkTavCutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                } else {
                    winkTavCutParams2 = winkTavCutParams3;
                }
                textView2.setText(i3 + "/" + winkTavCutParams2.u().size());
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView3 = this.indicator;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    private final void H0(float width, float height) {
        MediaModel copy;
        float f16;
        if (G()) {
            return;
        }
        dr.WinkTavCutParams winkTavCutParams = this.params;
        BackgroundModel backgroundModel = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        WinkEditData winkEditData = winkTavCutParams.u().get(this.currentPosition);
        BackgroundModel backgroundModel2 = winkEditData.getMediaModel().backgroundModel;
        if (backgroundModel2 != null) {
            SizeF sizeF = new SizeF(width, height, null, 4, null);
            if (width > height) {
                f16 = 1000.0f;
            } else {
                f16 = 0.0f;
            }
            backgroundModel = BackgroundModel.copy$default(backgroundModel2, null, sizeF, null, null, null, null, null, null, f16, 0, null, 1789, null);
        }
        copy = r3.copy((r39 & 1) != 0 ? r3.id : null, (r39 & 2) != 0 ? r3.name : null, (r39 & 4) != 0 ? r3.version : null, (r39 & 8) != 0 ? r3.createTime : null, (r39 & 16) != 0 ? r3.updateTime : null, (r39 & 32) != 0 ? r3.duration : null, (r39 & 64) != 0 ? r3.videos : null, (r39 & 128) != 0 ? r3.audios : null, (r39 & 256) != 0 ? r3.stickers : null, (r39 & 512) != 0 ? r3.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? r3.filterModels : null, (r39 & 2048) != 0 ? r3.specialEffects : null, (r39 & 4096) != 0 ? r3.transitions : null, (r39 & 8192) != 0 ? r3.templateModel : null, (r39 & 16384) != 0 ? r3.coverInfo : null, (r39 & 32768) != 0 ? r3.exportSetting : null, (r39 & 65536) != 0 ? r3.openHDR : null, (r39 & 131072) != 0 ? r3.hdrModels : null, (r39 & 262144) != 0 ? r3.smoothModels : null, (r39 & 524288) != 0 ? r3.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
        winkEditData.setMediaModel(copy);
    }

    private final SizeF I0(List<? extends MediaClip> clips, float width, float height) {
        boolean z16;
        float f16 = width;
        float f17 = height;
        for (MediaClip mediaClip : clips) {
            boolean z17 = true;
            if (com.tencent.videocut.render.extension.e.o(mediaClip).width == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (com.tencent.videocut.render.extension.e.o(mediaClip).height != 0.0f) {
                    z17 = false;
                }
                if (!z17 && (com.tencent.videocut.render.extension.e.o(mediaClip).width * 1.0f) / com.tencent.videocut.render.extension.e.o(mediaClip).height < (1.0f * f16) / f17) {
                    f16 = com.tencent.videocut.render.extension.e.o(mediaClip).width;
                    f17 = com.tencent.videocut.render.extension.e.o(mediaClip).height;
                }
            }
        }
        return new SizeF(f16, f17, null, 4, null);
    }

    private final boolean J0(float width, float height) {
        if (width * 3 < height * 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(WinkImageTavCut this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<MediaModel> Q0 = this$0.Q0();
        if (Q0 != null) {
            com.tencent.mobileqq.wink.dect.d dVar = new com.tencent.mobileqq.wink.dect.d(Q0);
            dVar.k(com.tencent.mobileqq.wink.dect.c.INSTANCE.a(), new c(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(WinkImageTavCut this$0) {
        Map<String, WinkStickerModel> mutableMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Size renderSize = this$0.getRenderSize();
        if (renderSize.width != null && renderSize.height != null) {
            FrameLayout S0 = this$0.S0(this$0.currentPosition);
            Intrinsics.checkNotNull(S0);
            dr.WinkTavCutParams winkTavCutParams = this$0.params;
            dr.WinkTavCutParams winkTavCutParams2 = null;
            if (winkTavCutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams = null;
            }
            int width = winkTavCutParams.getWidth();
            dr.WinkTavCutParams winkTavCutParams3 = this$0.params;
            if (winkTavCutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams2 = winkTavCutParams3;
            }
            int width2 = (winkTavCutParams2.getWidth() * renderSize.height.intValue()) / renderSize.width.intValue();
            Map<String, WinkStickerModel> m3 = this$0.m();
            if (m3 != null) {
                for (Map.Entry<String, WinkStickerModel> entry : m3.entrySet()) {
                    PointF n3 = com.tencent.mobileqq.wink.editor.sticker.l.n(this$0.getRenderSize(), new Size(Integer.valueOf(S0.getWidth()), Integer.valueOf(S0.getHeight()), null, 4, null));
                    entry.getValue().getOriginPointInView().f320587x = n3.f320587x;
                    entry.getValue().getOriginPointInView().f320588y = n3.f320588y;
                    entry.getValue().updatePositionInView(width, width2, entry.getValue().scaleX, entry.getValue().scaleY, entry.getValue().centerX, entry.getValue().centerY);
                }
            }
            Map<String, WinkStickerModel> m16 = this$0.m();
            if (m16 != null) {
                mutableMap = MapsKt__MapsKt.toMutableMap(m16);
                this$0.B(mutableMap);
            }
        }
    }

    private final Size M0() {
        return new Size(960, 1280, null, 4, null);
    }

    private final void M1(LAKRenderModel templateRenderModel, List<? extends Map<String, String>> mediaClipExtras, String color, int fillMode) {
        BackgroundFillMode backgroundFillMode;
        BackgroundModel backgroundModel;
        WinkEditData Z0 = Z0();
        if (Z0 != null && Z0.getMediaModel() != null) {
            List<MediaClip> H = com.tencent.videocut.render.extension.e.H(com.tencent.videocut.render.extension.e.I(com.tencent.videocut.render.extension.e.D(templateRenderModel.getClipsAssets(), mediaClipExtras), Z0.getMediaModel().videos), Z0.getMediaModel().videos);
            if (fillMode == -1) {
                if (getTemplatePath() != null) {
                    if (R0(getTemplatePath()) == org.light.lightAssetKit.enums.BackgroundFillMode.GaussianBlur) {
                        backgroundFillMode = BackgroundFillMode.PAG;
                    } else {
                        backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
                    }
                } else {
                    backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
                }
            } else if (fillMode == 0) {
                backgroundFillMode = BackgroundFillMode.PAG;
            } else {
                backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
            }
            BackgroundFillMode backgroundFillMode2 = backgroundFillMode;
            String str = Z0.getMediaModel().id;
            BackgroundModel backgroundModel2 = Z0.getMediaModel().backgroundModel;
            if (backgroundModel2 != null) {
                backgroundModel = BackgroundModel.copy$default(backgroundModel2, null, null, backgroundFillMode2, color, null, null, null, null, 0.0f, 0, null, TXLiveConstants.PLAY_EVT_DECODE_FIRST_VIDEO_FRAME, null);
            } else {
                backgroundModel = null;
            }
            Z0.setMediaModel(new MediaModel(str, null, null, null, null, null, H, null, null, backgroundModel, null, null, null, null, null, null, null, null, null, null, null, 2031038, null));
            Z0.setTemplateMaterialMap(new LinkedHashMap());
            if (this.templateMaterial != null) {
                Map<String, MetaMaterial> templateMaterialMap = Z0.getTemplateMaterialMap();
                Intrinsics.checkNotNull(templateMaterialMap);
                MetaMaterial metaMaterial = this.templateMaterial;
                Intrinsics.checkNotNull(metaMaterial);
                String str2 = metaMaterial.f30533id;
                Intrinsics.checkNotNullExpressionValue(str2, "templateMaterial!!.id");
                MetaMaterial metaMaterial2 = this.templateMaterial;
                Intrinsics.checkNotNull(metaMaterial2);
                templateMaterialMap.put(str2, metaMaterial2);
                MetaMaterial metaMaterial3 = this.templateMaterial;
                Intrinsics.checkNotNull(metaMaterial3);
                w53.b.a("templateTest", metaMaterial3.f30533id);
            }
            Z0.setStickerModelMap(new LinkedHashMap());
            Z0.setFilterModelMap(new LinkedHashMap());
            Z0.setEffectModelMap(new LinkedHashMap());
            Z0.setMosaicData(null);
        }
    }

    private final MediaModel N0(WinkEditData editData) {
        WinkEditStretchedData stretchData = editData.getStretchData();
        boolean z16 = false;
        if (stretchData != null && stretchData.isStretched()) {
            z16 = true;
        }
        if (z16) {
            g.Companion companion = com.tencent.mobileqq.wink.editor.sticker.g.INSTANCE;
            Map<String, WinkStickerModel> stickerModelMap = editData.getStickerModelMap();
            WinkEditStretchedData stretchData2 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData2);
            float originTopY = stretchData2.getOriginTopY();
            WinkEditStretchedData stretchData3 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData3);
            boolean e16 = companion.e(stickerModelMap, originTopY, stretchData3.getOriginBottomY());
            ms.a.c("WinkImageTavCut", "isOutside = " + e16);
            if (!e16) {
                MediaModel mediaModel = editData.getMediaModel();
                WinkEditStretchedData stretchData4 = editData.getStretchData();
                Intrinsics.checkNotNull(stretchData4);
                float originScaleX = stretchData4.getOriginScaleX();
                WinkEditStretchedData stretchData5 = editData.getStretchData();
                Intrinsics.checkNotNull(stretchData5);
                float originScaleY = stretchData5.getOriginScaleY();
                WinkEditStretchedData stretchData6 = editData.getStretchData();
                Intrinsics.checkNotNull(stretchData6);
                float originTopY2 = stretchData6.getOriginTopY();
                WinkEditStretchedData stretchData7 = editData.getStretchData();
                Intrinsics.checkNotNull(stretchData7);
                float originWidth = stretchData7.getOriginWidth();
                WinkEditStretchedData stretchData8 = editData.getStretchData();
                Intrinsics.checkNotNull(stretchData8);
                return companion.g(mediaModel, originScaleX, originScaleY, originTopY2, originWidth, stretchData8.getOriginHeight(), true, Y0());
            }
        }
        return editData.getMediaModel();
    }

    private final void N1(String templatePath, MetaMaterial metaMaterial, LAKRenderModel renderModel, HashMap<String, String> assetData, boolean applyNewTemplate, boolean enableImageTemplateEdit, boolean isClearStickers, long currentTimeUs, boolean needRecoveryTemplateFromDraft) {
        boolean z16;
        WinkEditData Z0;
        MediaModel mediaModel;
        BackgroundModel backgroundModel;
        SizeF sizeF;
        ICutSession iCutSession;
        ms.a.f("WinkImageTavCut", "updateTemplateInternal " + templatePath);
        z1(templatePath);
        this.templateMaterial = metaMaterial;
        if (templatePath != null && templatePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            O1(WinkExportUtils.w() + File.separator + TemplateBean.TEMPLATE_JSON);
        } else {
            O1(templatePath);
        }
        if (templatePath != null && (iCutSession = this.session) != null) {
            iCutSession.setRenderModel(renderModel);
        }
        m1(applyNewTemplate, enableImageTemplateEdit, isClearStickers, currentTimeUs, needRecoveryTemplateFromDraft);
        if (applyNewTemplate && (Z0 = Z0()) != null && (mediaModel = Z0.getMediaModel()) != null && (backgroundModel = mediaModel.backgroundModel) != null && (sizeF = backgroundModel.renderSize) != null) {
            P((int) sizeF.width, (int) sizeF.height);
        }
        if (assetData != null) {
            v1(assetData);
        }
    }

    private final MediaModel O0(WinkEditData editData) {
        float f16;
        float f17;
        if (!G() && f1(editData)) {
            ms.a.f("WinkImageTavCut", "use horizontal video origin size.");
            MediaModel mediaModel = editData.getMediaModel();
            SizeF i3 = com.tencent.videocut.render.g.i(mediaModel.videos);
            if (i3 == null) {
                WinkEditStretchedData stretchData = editData.getStretchData();
                if (stretchData != null) {
                    f16 = stretchData.getOriginWidth();
                } else {
                    f16 = 0.0f;
                }
                WinkEditStretchedData stretchData2 = editData.getStretchData();
                if (stretchData2 != null) {
                    f17 = stretchData2.getOriginHeight();
                } else {
                    f17 = 0.0f;
                }
                i3 = new SizeF(f16, f17, null, 4, null);
            }
            SizeF I0 = I0(mediaModel.videos, i3.width, i3.height);
            g.Companion companion = com.tencent.mobileqq.wink.editor.sticker.g.INSTANCE;
            WinkEditStretchedData stretchData3 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData3);
            float originScaleX = stretchData3.getOriginScaleX();
            WinkEditStretchedData stretchData4 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData4);
            float originScaleY = stretchData4.getOriginScaleY();
            WinkEditStretchedData stretchData5 = editData.getStretchData();
            Intrinsics.checkNotNull(stretchData5);
            return companion.g(mediaModel, originScaleX, originScaleY, stretchData5.getOriginTopY(), I0.width, I0.height, com.tencent.mobileqq.wink.editor.draft.c.B(editData), Y0());
        }
        ms.a.f("WinkImageTavCut", "use the current render size.");
        return editData.getMediaModel();
    }

    private final MediaModel P0(WinkEditData editData) {
        Object obj;
        boolean z16;
        RectF rectF;
        SizeF sizeF;
        MediaModel mediaModel = editData.getMediaModel();
        if (!G()) {
            List<MediaClip> list = mediaModel.videos;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null) {
                    rectF = resourceModel.picClipRect;
                } else {
                    rectF = null;
                }
                if (resourceModel != null) {
                    sizeF = resourceModel.size;
                } else {
                    sizeF = null;
                }
                if (rectF != null) {
                    obj = TuplesKt.to(Float.valueOf(Math.abs(rectF.right - rectF.left)), Float.valueOf(Math.abs(rectF.bottom - rectF.top)));
                } else if (sizeF != null) {
                    obj = TuplesKt.to(Float.valueOf(sizeF.width), Float.valueOf(sizeF.height));
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            Iterator it5 = arrayList.iterator();
            if (it5.hasNext()) {
                obj = it5.next();
                if (it5.hasNext()) {
                    Pair pair = (Pair) obj;
                    float floatValue = ((Number) pair.getFirst()).floatValue() / ((Number) pair.getSecond()).floatValue();
                    do {
                        Object next = it5.next();
                        Pair pair2 = (Pair) next;
                        float floatValue2 = ((Number) pair2.getFirst()).floatValue() / ((Number) pair2.getSecond()).floatValue();
                        if (Float.compare(floatValue, floatValue2) > 0) {
                            obj = next;
                            floatValue = floatValue2;
                        }
                    } while (it5.hasNext());
                }
            }
            Pair pair3 = (Pair) obj;
            if (pair3 != null) {
                float floatValue3 = ((Number) pair3.component1()).floatValue();
                float floatValue4 = ((Number) pair3.component2()).floatValue();
                WinkVideoTavCut.RenderSizeAndOriginSize F0 = F0(this, editData, floatValue3, floatValue4, false, 8, null);
                int renderWidth = F0.getRenderWidth();
                int renderHeight = F0.getRenderHeight();
                float originTopY = F0.getOriginTopY();
                float originBottomY = F0.getOriginBottomY();
                float originScale = F0.getOriginScale();
                boolean isStretched = F0.getIsStretched();
                if (!isStretched) {
                    return com.tencent.mobileqq.wink.editor.sticker.g.INSTANCE.g(mediaModel, originScale, originScale, originTopY, (renderWidth * 1280.0f) / renderHeight, 1280.0f, isStretched, Y0());
                }
                g.Companion companion = com.tencent.mobileqq.wink.editor.sticker.g.INSTANCE;
                if (!companion.e(editData.getStickerModelMap(), originTopY, originBottomY) && !companion.f(editData.getStickerModelMap(), editData.getMediaModel(), renderWidth, renderHeight, originTopY, originBottomY)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    float f16 = renderWidth;
                    return companion.g(mediaModel, originScale, originScale, originTopY, f16, (floatValue4 * f16) / floatValue3, isStretched, Y0());
                }
                return mediaModel;
            }
            ms.a.c("WinkImageTavCut", "invalid media models, have not valid size");
        }
        return mediaModel;
    }

    private final LAKRenderModel P1(boolean modifyClipsDuration, String bgColor, int fillMode, List<ClipSource> clipSources) {
        org.light.lightAssetKit.enums.BackgroundFillMode backgroundFillMode;
        String backgroundColor;
        String pagPath;
        MediaModel mediaModel;
        String str;
        rd4.c cVar = rd4.c.f431135f;
        LAKRenderModel y16 = cVar.y(clipSources);
        if (modifyClipsDuration) {
            String templatePath = getTemplatePath();
            if (templatePath == null) {
                templatePath = r73.a.f430927a.b();
            }
            LAKRenderModel k3 = cVar.k(templatePath, clipSources, modifyClipsDuration);
            if (k3 == null) {
                k3 = cVar.y(clipSources);
            }
            y16 = k3;
            y16.setModifyClipsDuration(true);
        } else {
            y16.setModifyClipsDuration(false);
        }
        if (fillMode == -1) {
            backgroundFillMode = R0(getTemplatePath());
        } else if (fillMode == 0) {
            backgroundFillMode = org.light.lightAssetKit.enums.BackgroundFillMode.GaussianBlur;
        } else {
            backgroundFillMode = org.light.lightAssetKit.enums.BackgroundFillMode.SolidColorFill;
        }
        org.light.lightAssetKit.components.Size size = new org.light.lightAssetKit.components.Size(960, 1280);
        if (getTemplatePath() == null) {
            BackgroundModel backgroundModel = V().backgroundModel;
            if (backgroundModel != null && (str = backgroundModel.bgColor) != null) {
                y16.setPainting(new Painting(org.light.lightAssetKit.enums.BackgroundFillMode.SolidColorFill, com.tencent.videocut.utils.d.f384234a.a(str), size, null, null, 24, null));
            }
        } else if (!Intrinsics.areEqual(bgColor, "") || fillMode != -1) {
            Painting painting = y16.getPainting();
            if (!Intrinsics.areEqual(bgColor, "")) {
                backgroundColor = com.tencent.videocut.utils.d.f384234a.a(bgColor);
            } else {
                backgroundColor = y16.getPainting().getBackgroundColor();
            }
            String str2 = backgroundColor;
            if (fillMode == -1) {
                backgroundFillMode = y16.getPainting().getBackgroundFillMode();
            }
            org.light.lightAssetKit.enums.BackgroundFillMode backgroundFillMode2 = backgroundFillMode;
            if (fillMode != -1) {
                pagPath = WinkExportUtils.t();
            } else {
                pagPath = y16.getPainting().getPagPath();
            }
            y16.setPainting(Painting.copy$default(painting, backgroundFillMode2, str2, size, null, pagPath, 8, null));
        }
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null) {
            B1(this, mediaModel, false, 0L, 4, null);
        }
        return y16;
    }

    private final void Q1(MediaModel mediaModel, boolean needUpdate, long initTime) {
        float f16;
        ComposeRenderLayer composeRenderLayer;
        w53.b.f("WinkImageTavCut", "updateWithNoSurface needUpdate:" + needUpdate + ", initTime:" + initTime);
        try {
            dr.WinkTavCutParams winkTavCutParams = this.params;
            dr.WinkTavCutParams winkTavCutParams2 = null;
            if (winkTavCutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams = null;
            }
            int width = winkTavCutParams.getWidth();
            dr.WinkTavCutParams winkTavCutParams3 = this.params;
            if (winkTavCutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams3 = null;
            }
            SizeF G0 = G0(mediaModel, width, winkTavCutParams3.getHeight());
            if (X0()) {
                f16 = 1.0f;
            } else if (G0.width > G0.height) {
                f16 = 99999.0f;
            } else {
                f16 = 0.0f;
            }
            MediaModel E1 = E1(mediaModel, G0, f16);
            float f17 = G0.width;
            float f18 = G0.height;
            dr.WinkTavCutParams winkTavCutParams4 = this.params;
            if (winkTavCutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams4 = null;
            }
            int width2 = winkTavCutParams4.getWidth();
            dr.WinkTavCutParams winkTavCutParams5 = this.params;
            if (winkTavCutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams2 = winkTavCutParams5;
            }
            ms.a.c("WinkImageTavCut", "renderSize: width = " + f17 + " height = " + f18 + "params w = " + width2 + " h = " + winkTavCutParams2.getHeight());
            WinkEditData Z0 = Z0();
            if (Z0 != null) {
                Z0.setMediaModel(E1);
            }
            if (this.currentPlayer != null && needUpdate && (composeRenderLayer = this.renderLayer) != null) {
                composeRenderLayer.l(mediaModel);
            }
            SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(3, 100));
        } catch (Exception e16) {
            String message = e16.getMessage();
            if (message != null) {
                ms.a.c("WinkImageTavCut", message);
            }
        }
    }

    private final org.light.lightAssetKit.enums.BackgroundFillMode R0(String templatePath) {
        Entity rootEntity;
        List<Entity> entitiesWithComponent;
        Object orNull;
        MultiMedia multiMedia;
        LightAssetDataContext d16 = com.tencent.videocut.render.utils.b.f384205a.d(templatePath);
        if (d16 != null && (rootEntity = d16.getRootEntity()) != null && (entitiesWithComponent = rootEntity.getEntitiesWithComponent(MultiMedia.class)) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(entitiesWithComponent, 0);
            Entity entity = (Entity) orNull;
            if (entity != null && (multiMedia = (MultiMedia) entity.getComponent(MultiMedia.class)) != null) {
                return multiMedia.getBackgroundFillMode();
            }
        }
        return org.light.lightAssetKit.enums.BackgroundFillMode.SolidColorFill;
    }

    private final FrameLayout S0(int position) {
        View view;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            view = layoutManager.findViewByPosition(position);
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        return (FrameLayout) view.findViewById(R.id.f25760bp);
    }

    private final TextureView W0(int position) {
        View view;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            view = layoutManager.findViewByPosition(position);
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        return (TextureView) view.findViewById(R.id.jjj);
    }

    private final boolean X0() {
        boolean z16;
        String templatePath = getTemplatePath();
        if (templatePath != null && templatePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(Surface surface, int surfaceWidth, int surfaceHeight) {
        ms.a.f("WinkImageTavCut", "initPlayer " + this.session);
        this.playerSurface = surface;
        IPlayer g16 = rd4.c.f431135f.g(null);
        g16.setLoopPlay(false);
        g16.setAutoPlay(false);
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.bindPlayer(g16);
        }
        g16.setUpSurface(surface, surfaceWidth, surfaceHeight);
    }

    private final void d1() {
        this.needStretchBack = true;
    }

    private final boolean f1(WinkEditData editData) {
        float f16;
        if (com.tencent.mobileqq.wink.editor.draft.c.B(editData)) {
            g.Companion companion = com.tencent.mobileqq.wink.editor.sticker.g.INSTANCE;
            Map<String, WinkStickerModel> stickerModelMap = editData.getStickerModelMap();
            WinkEditStretchedData stretchData = editData.getStretchData();
            float f17 = 0.0f;
            if (stretchData != null) {
                f16 = stretchData.getOriginTopY();
            } else {
                f16 = 0.0f;
            }
            WinkEditStretchedData stretchData2 = editData.getStretchData();
            if (stretchData2 != null) {
                f17 = stretchData2.getOriginBottomY();
            }
            if (!companion.e(stickerModelMap, f16, f17)) {
                return true;
            }
        }
        return false;
    }

    private final void j1(int position) {
        ms.a.f("WinkImageTavCut", "onPageSelectedUpdate begin");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        dr.WinkTavCutParams winkTavCutParams2 = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        ResourceModel resourceModel = winkTavCutParams.u().get(position).getMediaModel().videos.get(0).resource;
        Intrinsics.checkNotNull(resourceModel);
        SizeF sizeF = resourceModel.size;
        Intrinsics.checkNotNull(sizeF);
        float f16 = sizeF.width;
        dr.WinkTavCutParams winkTavCutParams3 = this.params;
        if (winkTavCutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams3 = null;
        }
        ResourceModel resourceModel2 = winkTavCutParams3.u().get(position).getMediaModel().videos.get(0).resource;
        Intrinsics.checkNotNull(resourceModel2);
        SizeF sizeF2 = resourceModel2.size;
        Intrinsics.checkNotNull(sizeF2);
        float f17 = sizeF2.height;
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        if (J0(f16, f17)) {
            int i3 = this.showAreaWidth;
            intRef.element = i3;
            int i16 = (int) ((i3 * f17) / f16);
            intRef2.element = i16;
            int i17 = this.showAreaHeight;
            if (i16 < i17) {
                intRef2.element = i17;
                intRef.element = (int) ((i17 * f16) / f17);
            }
        } else {
            int i18 = this.showAreaWidth;
            intRef.element = i18;
            dr.WinkTavCutParams winkTavCutParams4 = this.params;
            if (winkTavCutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams4 = null;
            }
            int height = i18 * winkTavCutParams4.getHeight();
            dr.WinkTavCutParams winkTavCutParams5 = this.params;
            if (winkTavCutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams5 = null;
            }
            intRef2.element = height / winkTavCutParams5.getWidth();
            WinkEditData Z0 = Z0();
            if (Z0 != null && !com.tencent.mobileqq.wink.editor.draft.c.B(Z0)) {
                int i19 = this.showAreaWidth;
                float f18 = i19;
                float f19 = (i19 * f17) / f16;
                float f26 = (intRef2.element - f19) / 2;
                float f27 = f26 + f19;
                float f28 = f19 / f18;
                dr.WinkTavCutParams winkTavCutParams6 = this.params;
                if (winkTavCutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    winkTavCutParams6 = null;
                }
                float height2 = f28 / winkTavCutParams6.getHeight();
                dr.WinkTavCutParams winkTavCutParams7 = this.params;
                if (winkTavCutParams7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                } else {
                    winkTavCutParams2 = winkTavCutParams7;
                }
                float width = height2 * winkTavCutParams2.getWidth();
                int i26 = this.showAreaWidth;
                Z0.setStretchData(new WinkEditStretchedData(true, i26, (i26 * f17) / f16, f26, f27, width, width));
            }
            H0(intRef.element, intRef2.element);
        }
        ms.a.a("WinkImageTavCut", "[onPageSelectedUpdate] image size=" + f16 + HippyTKDListViewAdapter.X + f17 + ", area size=" + this.showAreaWidth + HippyTKDListViewAdapter.X + this.showAreaHeight + ", container size=" + intRef.element + HippyTKDListViewAdapter.X + intRef2.element);
        FrameLayout S0 = S0(position);
        if (S0 != null) {
            ViewGroup.LayoutParams layoutParams = S0.getLayoutParams();
            layoutParams.width = intRef.element;
            layoutParams.height = intRef2.element;
            S0.setLayoutParams(layoutParams);
            F1();
            TextureView W0 = W0(position);
            FrameLayout S02 = S0(position);
            if (S02 == null) {
                return;
            }
            if (W0 != null) {
                S02.removeView(W0);
            }
            TextureView textureView = new TextureView(S02.getContext());
            S02.addView(textureView);
            textureView.setSurfaceTextureListener(new d(position, this, intRef, intRef2));
        }
        G1();
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(3, 100));
        ms.a.f("WinkImageTavCut", "onPageSelectedUpdate end");
    }

    private final void k1(dr.WinkTavCutParams params) {
        z1(params.getTemplatePath());
        this.isFromQzoneText = params.getIsFromQzoneText();
        this.textQzoneText = params.getTextQzoneText();
        this.isBackgroundTemplateInited = false;
        if (params.c() != null) {
            n().get(this.currentPosition).setAssetData(params.c());
        }
    }

    private final void l1() {
        boolean z16;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        dr.WinkTavCutParams winkTavCutParams2 = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        if (f0(winkTavCutParams.getTemplatePath())) {
            List<MediaClip> list = V().videos;
            if (getTemplatePath() == null && com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip) {
                z16 = true;
            } else {
                z16 = false;
            }
            LAKRenderModel P1 = P1(false, "", -1, com.tencent.videocut.render.extension.e.z(list, z16, Boolean.FALSE));
            dr.WinkTavCutParams winkTavCutParams3 = this.params;
            if (winkTavCutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams3 = null;
            }
            String templatePath = winkTavCutParams3.getTemplatePath();
            dr.WinkTavCutParams winkTavCutParams4 = this.params;
            if (winkTavCutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams2 = winkTavCutParams4;
            }
            N1(templatePath, null, P1, winkTavCutParams2.c(), false, true, false, 0L, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m1(boolean applyNewTemplate, boolean enableImageTemplateEdit, boolean isClearStickers, long currentTimeUs, boolean needRecoveryTemplateFromDraft) {
        boolean z16;
        int collectionSizeOrDefault;
        ComposeRenderLayer composeRenderLayer;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        Map mutableMap;
        MediaModel copy;
        boolean z17;
        Collection<WinkStickerModel> values;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        int mapCapacity2;
        int coerceAtLeast2;
        Map<String, WinkStickerModel> mutableMap2;
        Map<String, WinkStickerModel> m3;
        boolean isBlank;
        w53.b.f("WinkImageTavCut", "refreshTemplateTextSticker applyNewTemplate: " + applyNewTemplate);
        String templatePath = getTemplatePath();
        if (templatePath != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(templatePath);
            if (!isBlank) {
                z16 = false;
                if (z16 && !this.isFromQzoneText) {
                    ArrayList arrayList = new ArrayList();
                    WinkVideoTavCut.Companion companion = WinkVideoTavCut.INSTANCE;
                    arrayList.addAll(companion.h(templatePath));
                    if (enableImageTemplateEdit) {
                        arrayList.addAll(companion.g(templatePath));
                    }
                    if (isClearStickers && arrayList.isEmpty()) {
                        return;
                    }
                    List<WinkStickerModel> d16 = com.tencent.videocut.render.utils.c.f384212a.d(arrayList, templatePath, this.renderWidth, this.renderHeight);
                    ArrayList arrayList2 = new ArrayList();
                    if (!isClearStickers && (m3 = m()) != null) {
                        ArrayList arrayList3 = new ArrayList(m3.size());
                        for (Map.Entry<String, WinkStickerModel> entry : m3.entrySet()) {
                            if (entry.getValue().type == StickerModel.Type.TEXT) {
                                arrayList2.add(entry.getValue());
                            }
                            arrayList3.add(Unit.INSTANCE);
                        }
                    }
                    List<WinkStickerModel> list = d16;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(Boolean.valueOf(arrayList2.add((WinkStickerModel) it.next())));
                    }
                    if (applyNewTemplate) {
                        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault4);
                        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
                        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast2);
                        for (Object obj : arrayList2) {
                            linkedHashMap.put(((WinkStickerModel) obj).id, obj);
                        }
                        mutableMap2 = MapsKt__MapsKt.toMutableMap(linkedHashMap);
                        K1(mutableMap2, currentTimeUs);
                    } else {
                        if (needRecoveryTemplateFromDraft) {
                            w53.b.f("WinkImageTavCut", "removeTemplateSticker fromDraft: " + needRecoveryTemplateFromDraft);
                            ArrayList arrayList5 = new ArrayList();
                            for (Object obj2 : arrayList2) {
                                WinkStickerModel winkStickerModel = (WinkStickerModel) obj2;
                                Map<String, WinkStickerModel> m16 = m();
                                if (m16 != null && (values = m16.values()) != null) {
                                    Collection<WinkStickerModel> collection = values;
                                    collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
                                    ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault3);
                                    Iterator<T> it5 = collection.iterator();
                                    while (it5.hasNext()) {
                                        arrayList6.add(((WinkStickerModel) it5.next()).id);
                                    }
                                    if (!arrayList6.contains(winkStickerModel.id)) {
                                        z17 = true;
                                        if (!z17) {
                                            arrayList5.add(obj2);
                                        }
                                    }
                                }
                                z17 = false;
                                if (!z17) {
                                }
                            }
                            p1(arrayList5);
                        }
                        WinkEditData Z0 = Z0();
                        if (Z0 != null && Z0.getMediaModel() != null && (composeRenderLayer = this.renderLayer) != null) {
                            MediaModel mediaModel = Z0.getMediaModel();
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast);
                            for (Object obj3 : arrayList2) {
                                linkedHashMap2.put(((WinkStickerModel) obj3).id, obj3);
                            }
                            mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap2);
                            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : mutableMap, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
                            ComposeRenderLayer.u(composeRenderLayer, copy, false, currentTimeUs, false, 10, null);
                        }
                    }
                    R(0);
                    return;
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void n1() {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            ICutSession iCutSession2 = this.session;
            if (iCutSession2 != null) {
                iCutSession2.unbindCutPlayer(player);
            }
            player.destroySurface();
            player.release();
        }
        Surface surface = this.playerSurface;
        if (surface != null) {
            surface.release();
        }
        ICutSession iCutSession3 = this.session;
        if (iCutSession3 != null) {
            iCutSession3.release();
        }
    }

    private final void p1(List<? extends WinkStickerModel> stickerModelList) {
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.f(stickerModelList);
        }
    }

    private final void q1() {
        LAKCutSession lAKCutSession;
        ms.a.f("WinkImageTavCut", "resetTavCut begin");
        ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
        this.session = createLAKCutSession;
        if (createLAKCutSession instanceof LAKCutSession) {
            lAKCutSession = (LAKCutSession) createLAKCutSession;
        } else {
            lAKCutSession = null;
        }
        if (lAKCutSession != null) {
            lAKCutSession.setClipAssetListener(new OnClipAssetListener() { // from class: com.tencent.mobileqq.wink.editor.de
                @Override // org.light.listener.OnClipAssetListener
                public final void OnLoadClipError(int i3, String str) {
                    WinkImageTavCut.r1(i3, str);
                }
            });
        }
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.setCutStatusListener(new e());
        }
        ICutSession iCutSession2 = this.session;
        if (iCutSession2 != null) {
            String w3 = WinkExportUtils.w();
            Intrinsics.checkNotNullExpressionValue(w3, "getDefaultTemplateDir()");
            iCutSession2.setTemplateDir(w3);
        }
        ICutSession iCutSession3 = this.session;
        if (iCutSession3 != null) {
            this.renderLayer = new ComposeRenderLayer(iCutSession3, new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null), ComposeRenderLayer.RenderScene.PIC, 0 == true ? 1 : 0, 8, 0 == true ? 1 : 0);
        }
        d1();
        ms.a.f("WinkImageTavCut", "resetTavCut end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(final int i3, String str) {
        ms.a.c("WinkImageTavCut", "\u5a92\u4f53\u8bfb\u53d6\u5931\u8d25" + i3 + ",path=" + str + ",\u8bf7\u91cd\u8bd5");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.df
            @Override // java.lang.Runnable
            public final void run() {
                WinkImageTavCut.s1(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(int i3) {
        QQToast.makeText(BaseApplication.getContext(), "\u5a92\u4f53\u8bfb\u53d6\u5931\u8d25" + i3 + ",\u8bf7\u91cd\u8bd5", 0).show();
    }

    private final void t1() {
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (findViewByPosition = layoutManager.findViewByPosition(this.currentPosition)) != null) {
            float x16 = findViewByPosition.getX();
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.beginFakeDrag();
                viewPager2.fakeDragBy(x16);
                viewPager2.endFakeDrag();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(WinkImageTavCut this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j1(this$0.currentPosition);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<MosaicData> A() {
        int collectionSizeOrDefault;
        MosaicData mosaicData;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(u16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = u16.iterator();
        while (it.hasNext()) {
            MosaicDataSerializable mosaicData2 = ((WinkEditData) it.next()).getMosaicData();
            if (mosaicData2 == null || (mosaicData = mosaicData2.restore()) == null) {
                mosaicData = new MosaicData(new CopyOnWriteArrayList(), new CopyOnWriteArrayList(), null, 4, null);
            }
            arrayList.add(mosaicData);
        }
        return arrayList;
    }

    public final void A1(@NotNull MediaModel mediaModel, boolean needUpdate, long initTime) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        if (winkTavCutParams.getPlayerSurface() == null) {
            Q1(mediaModel, needUpdate, initTime);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void B(@NotNull Map<String, WinkStickerModel> stickerModelMap) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(stickerModelMap, "stickerModelMap");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        WinkEditData winkEditData = winkTavCutParams.u().get(this.currentPosition);
        winkEditData.setStickerModelMap(stickerModelMap);
        MediaModel mediaModel = winkEditData.getMediaModel();
        Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap2);
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : stickerModelMap2, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        winkEditData.setMediaModel(copy);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            ComposeRenderLayer.u(composeRenderLayer, winkEditData.getMediaModel(), false, 0L, false, 14, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void C(@NotNull Size size) {
        int i3;
        Intrinsics.checkNotNullParameter(size, "size");
        FrameLayout S0 = S0(this.currentPosition);
        if (S0 != null) {
            ViewGroup.LayoutParams layoutParams = S0.getLayoutParams();
            Integer num = size.width;
            int i16 = 0;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            layoutParams.width = i3;
            Integer num2 = size.height;
            if (num2 != null) {
                i16 = num2.intValue();
            }
            layoutParams.height = i16;
            S0.setLayoutParams(layoutParams);
        }
    }

    public final void C0(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        o1(callback);
        this.onPageChangeCallbacks.add(callback);
    }

    public final void C1(int selectedIndex, boolean isAIElimination) {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : winkTavCutParams.u()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            WinkEditData winkEditData = (WinkEditData) obj;
            if (i3 == selectedIndex) {
                if (winkEditData.isAIElimination() || isAIElimination) {
                    z16 = true;
                }
                winkEditData.setAIElimination(z16);
                return;
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void D(boolean force) {
        if (!force && this.isLabelDetected) {
            return;
        }
        this.labelDetectDuration = System.currentTimeMillis();
        w53.b.f("WinkImageTavCut", "generateMediaLabels, startGenerate");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.dh
            @Override // java.lang.Runnable
            public final void run() {
                WinkImageTavCut.K0(WinkImageTavCut.this);
            }
        }, 16, null, false);
    }

    public void D0(@NotNull com.tencent.mobileqq.wink.editor.sticker.sticker.d stickerUpdateListener) {
        Intrinsics.checkNotNullParameter(stickerUpdateListener, "stickerUpdateListener");
        this.stickerUpdateListeners.add(stickerUpdateListener);
    }

    public final void D1(int selectedIndex, @Nullable MetaMaterial template) {
        Object orNull;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), selectedIndex);
        WinkEditData winkEditData = (WinkEditData) orNull;
        if (winkEditData != null) {
            winkEditData.setAiTemplate(template);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    /* renamed from: E */
    public GYVideoClassifyResult getGyResult() {
        return null;
    }

    @NotNull
    public final MediaModel E1(@NotNull MediaModel mediaModel, @NotNull SizeF renderSize, float fillScale) {
        Integer num;
        float f16;
        SizeF sizeF;
        BackgroundModel c16;
        MediaModel copy;
        BackgroundModel copy$default;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        if (!X0()) {
            num = Integer.valueOf(com.tencent.mobileqq.wink.editor.util.m.f322645a.b().height);
        } else {
            num = M0().height;
        }
        float f17 = renderSize.height;
        float f18 = renderSize.width;
        if (f17 * f18 <= 0.0f) {
            ms.a.c("WinkImageTavCut", "render size is error: width = " + f18 + ",height=" + f17);
            f16 = 1.0f;
        } else {
            f16 = f17 / f18;
        }
        if (f16 < 1.0f) {
            Intrinsics.checkNotNull(num);
            sizeF = new SizeF(num.intValue(), num.intValue() * f16, ByteString.EMPTY);
        } else {
            Intrinsics.checkNotNull(num);
            sizeF = new SizeF(num.intValue() / f16, num.intValue(), ByteString.EMPTY);
        }
        SizeF d16 = com.tencent.mobileqq.wink.editor.model.a.d(g0(), sizeF.width, sizeF.height);
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        if (backgroundModel != null && (copy$default = BackgroundModel.copy$default(backgroundModel, null, d16, null, null, null, null, null, null, fillScale, 0, null, 1789, null)) != null) {
            c16 = copy$default;
        } else {
            c16 = com.tencent.videocut.render.g.c(d16, fillScale, null, 4, null);
        }
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : c16, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void F(@NotNull ISessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.addSessionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean G() {
        return dr.b.h(this);
    }

    @NotNull
    public SizeF G0(@NotNull MediaModel mediaModel, int paramsWidth, int paramsHeight) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        if (X0()) {
            dr.WinkTavCutParams winkTavCutParams = this.params;
            dr.WinkTavCutParams winkTavCutParams2 = null;
            if (winkTavCutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams = null;
            }
            float height = winkTavCutParams.getHeight();
            Intrinsics.checkNotNull(M0().width);
            float intValue = height * r0.intValue();
            Intrinsics.checkNotNull(M0().height);
            float intValue2 = intValue / r0.intValue();
            dr.WinkTavCutParams winkTavCutParams3 = this.params;
            if (winkTavCutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams3 = null;
            }
            float height2 = winkTavCutParams3.getHeight();
            this.renderWidth = (int) intValue2;
            dr.WinkTavCutParams winkTavCutParams4 = this.params;
            if (winkTavCutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                winkTavCutParams2 = winkTavCutParams4;
            }
            this.renderHeight = winkTavCutParams2.getHeight();
            return new SizeF(intValue2, height2, null, 4, null);
        }
        Integer num = getRenderSize().width;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 720;
        }
        Integer num2 = getRenderSize().height;
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = 1280;
        }
        return new SizeF(i3, i16, null, 4, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    /* renamed from: H, reason: from getter */
    public String getTemplatePath() {
        return this.templatePath;
    }

    public final void H1(@NotNull List<MediaModel> mediaModels) {
        Intrinsics.checkNotNullParameter(mediaModels, "mediaModels");
        int i3 = 0;
        for (Object obj : mediaModels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaModel mediaModel = (MediaModel) obj;
            dr.WinkTavCutParams winkTavCutParams = this.params;
            if (winkTavCutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams = null;
            }
            winkTavCutParams.u().get(i3).setMediaModel(mediaModel);
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    public List<ClipSource> I() {
        return null;
    }

    public final void I1(@NotNull ArrayList<MosaicData> mosaicList) {
        Intrinsics.checkNotNullParameter(mosaicList, "mosaicList");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        int i3 = 0;
        for (Object obj : winkTavCutParams.u()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((WinkEditData) obj).setMosaicData(new MosaicDataSerializable(mosaicList.get(i3).getPathList(), mosaicList.get(i3).getUndoPathList(), mosaicList.get(i3).getResultPath()));
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<MediaModel> J() {
        int collectionSizeOrDefault;
        MediaModel N0;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(u16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData : u16) {
            if (com.tencent.mobileqq.wink.editor.util.g.f322634a.h()) {
                if (com.tencent.mobileqq.wink.editor.draft.c.w(winkEditData)) {
                    N0 = P0(winkEditData);
                } else {
                    N0 = O0(winkEditData);
                }
            } else {
                N0 = N0(winkEditData);
            }
            arrayList.add(N0);
        }
        return arrayList;
    }

    public final void J1(@NotNull Map<Integer, String> mosaicFiles) {
        Object orNull;
        Object firstOrNull;
        ComposeRenderLayer composeRenderLayer;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mosaicFiles, "mosaicFiles");
        for (Map.Entry<Integer, String> entry : mosaicFiles.entrySet()) {
            int intValue = entry.getKey().intValue();
            String value = entry.getValue();
            dr.WinkTavCutParams winkTavCutParams = this.params;
            if (winkTavCutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                winkTavCutParams = null;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), intValue);
            WinkEditData winkEditData = (WinkEditData) orNull;
            if (winkEditData != null) {
                Map<String, WinkStickerModel> stickerModelMap = winkEditData.getStickerModelMap();
                if (stickerModelMap == null) {
                    stickerModelMap = new LinkedHashMap<>();
                }
                CollectionsKt__MutableCollectionsKt.removeAll(stickerModelMap.entrySet(), new Function1<Map.Entry<String, WinkStickerModel>, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.WinkImageTavCut$updateMosaicDoodleStickers$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Map.Entry<String, WinkStickerModel> entry2) {
                        Intrinsics.checkNotNullParameter(entry2, "entry");
                        return Boolean.valueOf(entry2.getValue().isMosaicDoodleSticker());
                    }
                });
                if (value != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditData.getMediaModel().videos);
                    MediaClip mediaClip = (MediaClip) firstOrNull;
                    if (mediaClip != null) {
                        WinkStickerModel C = com.tencent.mobileqq.wink.editor.sticker.l.C(this, value, mediaClip);
                        if (C != null) {
                            stickerModelMap.put(C.id, C);
                            winkEditData.setStickerModelMap(stickerModelMap);
                            MediaModel mediaModel = winkEditData.getMediaModel();
                            Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
                            Intrinsics.checkNotNull(stickerModelMap2);
                            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : stickerModelMap2, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
                            winkEditData.setMediaModel(copy);
                            com.tencent.videocut.render.utils.a.f384204a.l(winkEditData);
                        }
                        if (this.currentPosition == intValue && (composeRenderLayer = this.renderLayer) != null) {
                            ComposeRenderLayer.u(composeRenderLayer, winkEditData.getMediaModel(), false, 0L, false, 14, null);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void K(@NotNull x.UpdateTemplateAction action, boolean isClearStickers, boolean needChaneStrickerDirectly, @Nullable String stickerText) {
        boolean z16;
        List<? extends Map<String, String>> emptyList;
        MediaModel mediaModel;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(action, "action");
        w53.b.a("WinkImageTavCut", "updateTemplate in videoTavCut action:" + action);
        List<MediaClip> list = V().videos;
        if (getTemplatePath() == null && com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<ClipSource> z17 = com.tencent.videocut.render.extension.e.z(list, z16, Boolean.FALSE);
        z1(action.getTemplatePath());
        this.templateMaterial = action.getMetaMaterial();
        LAKRenderModel P1 = P1(action.getModifyClipsDuration(), action.getColor(), action.getFillMode(), z17);
        dr.WinkTavCutParams winkTavCutParams = null;
        if (needChaneStrickerDirectly && !TextUtils.isEmpty(stickerText)) {
            P1.setStickerValue(stickerText);
        } else {
            P1.setStickerValue(null);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        M1(P1, emptyList, action.getColor(), action.getFillMode());
        String templatePath = getTemplatePath();
        MetaMaterial metaMaterial = this.templateMaterial;
        dr.WinkTavCutParams winkTavCutParams2 = this.params;
        if (winkTavCutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            winkTavCutParams = winkTavCutParams2;
        }
        N1(templatePath, metaMaterial, P1, winkTavCutParams.c(), true, action.getEnableTemplateImageStickerEdit(), isClearStickers, action.getCurrentTimeUs(), false);
        if (!isClearStickers) {
            ICutSession iCutSession = this.session;
            if (iCutSession != null) {
                iCutSession.flushWithoutDelay(true, action.getCurrentTimeUs());
            }
        } else {
            ICutSession iCutSession2 = this.session;
            if (iCutSession2 != null) {
                iCutSession2.flushWithoutDelay();
            }
        }
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null) {
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : Boolean.valueOf(p()), (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            Z0.setMediaModel(copy);
            ComposeRenderLayer composeRenderLayer = this.renderLayer;
            if (composeRenderLayer != null) {
                ComposeRenderLayer.p(composeRenderLayer, Z0.getMediaModel(), ComposeRenderLayer.FlushMode.FLUSH, 0L, 4, null);
            }
        }
        cu.F(true);
    }

    public final void K1(@NotNull Map<String, WinkStickerModel> stickerModelMap, long timeUs) {
        MediaModel copy;
        BackgroundModel backgroundModel;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(stickerModelMap, "stickerModelMap");
        WinkEditData Z0 = Z0();
        if (Z0 != null && Z0.getMediaModel() != null) {
            Z0.setStickerModelMap(stickerModelMap);
            MediaModel mediaModel = Z0.getMediaModel();
            Map<String, WinkStickerModel> stickerModelMap2 = Z0.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap2);
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : stickerModelMap2, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            Z0.setMediaModel(copy);
            MediaModel mediaModel2 = Z0.getMediaModel();
            if (mediaModel2 != null && (backgroundModel = mediaModel2.backgroundModel) != null && (sizeF = backgroundModel.renderSize) != null) {
                P((int) sizeF.width, (int) sizeF.height);
            }
            ComposeRenderLayer composeRenderLayer = this.renderLayer;
            if (composeRenderLayer != null) {
                composeRenderLayer.t(Z0.getMediaModel(), true, timeUs, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void L(@NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        F(new f(action));
    }

    /* renamed from: L0, reason: from getter */
    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (com.tencent.mobileqq.wink.editor.draft.c.B(r0) == true) goto L8;
     */
    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Size M() {
        boolean z16;
        int i3;
        WinkEditStretchedData stretchData;
        WinkEditStretchedData stretchData2;
        WinkEditData Z0 = Z0();
        int i16 = 0;
        if (Z0 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            WinkEditData Z02 = Z0();
            if (Z02 != null && (stretchData2 = Z02.getStretchData()) != null) {
                i3 = (int) stretchData2.getOriginWidth();
            } else {
                i3 = 0;
            }
            Integer valueOf = Integer.valueOf(i3);
            WinkEditData Z03 = Z0();
            if (Z03 != null && (stretchData = Z03.getStretchData()) != null) {
                i16 = (int) stretchData.getOriginHeight();
            }
            return new Size(valueOf, Integer.valueOf(i16), null, 4, null);
        }
        return getRenderSize();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void N(@NotNull List<SpecialEffectModel> list, long j3) {
        dr.b.a(this, list, j3);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean O() {
        return !Intrinsics.areEqual(this.lastMediaModels, Q0());
    }

    public void O1(@Nullable String str) {
        dr.b.p(this, str);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void P(int width, int height) {
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.updateRenderSize(new org.light.lightAssetKit.components.Size(width, height));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void Q(@NotNull ISessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.removeSessionListener(listener);
        }
    }

    @NotNull
    public List<MediaModel> Q0() {
        int collectionSizeOrDefault;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(u16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = u16.iterator();
        while (it.hasNext()) {
            arrayList.add(((WinkEditData) it.next()).getMediaModel());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void R(int topOffset) {
        FrameLayout S0 = S0(this.currentPosition);
        if (S0 != null) {
            S0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.dg
                @Override // java.lang.Runnable
                public final void run() {
                    WinkImageTavCut.L1(WinkImageTavCut.this);
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean S() {
        return dr.b.g(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void T(@NotNull List<? extends WinkStickerModel> stickerModelList) {
        Map<String, WinkStickerModel> stickerModelMap;
        MediaModel copy;
        Object obj;
        Intrinsics.checkNotNullParameter(stickerModelList, "stickerModelList");
        p1(stickerModelList);
        WinkEditData Z0 = Z0();
        if (Z0 != null && (stickerModelMap = Z0.getStickerModelMap()) != null && (!stickerModelMap.isEmpty())) {
            for (WinkStickerModel winkStickerModel : stickerModelList) {
                stickerModelMap.remove(winkStickerModel.id);
                MetaMaterial material = winkStickerModel.getMaterial();
                boolean z16 = false;
                if (material != null && com.tencent.mobileqq.wink.editor.sticker.m.Q(material)) {
                    z16 = true;
                }
                if (z16) {
                    Iterator<T> it = stickerModelMap.values().iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        MetaMaterial material2 = ((WinkStickerModel) next).getMaterial();
                        if (material2 != null) {
                            obj = com.tencent.mobileqq.wink.editor.sticker.m.u(material2);
                        }
                        if (Intrinsics.areEqual(obj, com.tencent.mobileqq.wink.editor.sticker.m.u(winkStickerModel.getMaterial()))) {
                            obj = next;
                            break;
                        }
                    }
                    WinkStickerModel winkStickerModel2 = (WinkStickerModel) obj;
                    if (winkStickerModel2 != null) {
                        stickerModelMap.remove(winkStickerModel2.id);
                    }
                }
            }
            copy = r2.copy((r39 & 1) != 0 ? r2.id : null, (r39 & 2) != 0 ? r2.name : null, (r39 & 4) != 0 ? r2.version : null, (r39 & 8) != 0 ? r2.createTime : null, (r39 & 16) != 0 ? r2.updateTime : null, (r39 & 32) != 0 ? r2.duration : null, (r39 & 64) != 0 ? r2.videos : null, (r39 & 128) != 0 ? r2.audios : null, (r39 & 256) != 0 ? r2.stickers : stickerModelMap, (r39 & 512) != 0 ? r2.backgroundModel : null, (r39 & 1024) != 0 ? r2.filterModels : null, (r39 & 2048) != 0 ? r2.specialEffects : null, (r39 & 4096) != 0 ? r2.transitions : null, (r39 & 8192) != 0 ? r2.templateModel : null, (r39 & 16384) != 0 ? r2.coverInfo : null, (r39 & 32768) != 0 ? r2.exportSetting : null, (r39 & 65536) != 0 ? r2.openHDR : null, (r39 & 131072) != 0 ? r2.hdrModels : null, (r39 & 262144) != 0 ? r2.smoothModels : null, (r39 & 524288) != 0 ? r2.openSuperHDR : null, (r39 & 1048576) != 0 ? Z0.getMediaModel().unknownFields() : null);
            Z0.setMediaModel(copy);
            ComposeRenderLayer composeRenderLayer = this.renderLayer;
            if (composeRenderLayer != null) {
                composeRenderLayer.l(Z0.getMediaModel());
            }
        }
    }

    @Nullable
    public String T0() {
        MediaModel mediaModel;
        Map<String, SpecialEffectModel> map;
        WinkEditData Z0 = Z0();
        String str = "";
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null && (map = mediaModel.specialEffects) != null) {
            int i3 = 5;
            for (SpecialEffectModel specialEffectModel : map.values()) {
                if (i3 < 0) {
                    return str;
                }
                i3--;
                str = ((Object) str) + specialEffectModel.materialId + " ";
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean U() {
        List<MediaModel> Q0 = Q0();
        if ((Q0 instanceof Collection) && Q0.isEmpty()) {
            return false;
        }
        Iterator<T> it = Q0.iterator();
        while (it.hasNext()) {
            if (com.tencent.mobileqq.wink.editor.model.a.y((MediaModel) it.next())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String U0() {
        Map<String, StickerModel> map;
        Collection<StickerModel> values;
        MediaModel mediaModel;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null) {
            map = mediaModel.stickers;
        } else {
            map = null;
        }
        String str = "";
        if (map != null && (values = map.values()) != null) {
            int i3 = 5;
            for (StickerModel stickerModel : values) {
                if (i3 < 0) {
                    return str;
                }
                i3--;
                str = ((Object) str) + stickerModel.materialId + " ";
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public MediaModel V() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        return winkTavCutParams.u().get(this.currentPosition).getMediaModel();
    }

    @NotNull
    public String V0() {
        return dr.b.e(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void W(@NotNull List<? extends WinkStickerModel> stickerModels) {
        Object orNull;
        Map<String, WinkStickerModel> linkedHashMap;
        Intrinsics.checkNotNullParameter(stickerModels, "stickerModels");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), this.currentPosition);
        WinkEditData winkEditData = (WinkEditData) orNull;
        if (winkEditData == null || (linkedHashMap = winkEditData.getStickerModelMap()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        for (WinkStickerModel winkStickerModel : stickerModels) {
            linkedHashMap.put(winkStickerModel.id, winkStickerModel);
        }
        B(linkedHashMap);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    public String X() {
        Map<String, FilterModel> filterModelMap;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (filterModelMap = Z0.getFilterModelMap()) != null && filterModelMap.size() == 1) {
            Iterator<T> it = filterModelMap.values().iterator();
            while (it.hasNext()) {
                LutFilterModel lutFilterModel = ((FilterModel) it.next()).lut;
                if (lutFilterModel != null) {
                    return lutFilterModel.filterId;
                }
            }
            return "";
        }
        return "";
    }

    public float Y0() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        dr.WinkTavCutParams winkTavCutParams2 = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        float height = winkTavCutParams.getHeight();
        dr.WinkTavCutParams winkTavCutParams3 = this.params;
        if (winkTavCutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            winkTavCutParams2 = winkTavCutParams3;
        }
        return height / winkTavCutParams2.getWidth();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void Z() {
        dr.b.j(this);
    }

    @Nullable
    public final WinkEditData Z0() {
        Object orNull;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), this.currentPosition);
        return (WinkEditData) orNull;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public Size a() {
        return new Size(Integer.valueOf(this.showAreaWidth), Integer.valueOf(this.showAreaHeight), null, 4, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<MediaClip> a0() {
        List<MediaClip> emptyList;
        Object orNull;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<MediaModel> Q0 = Q0();
        if (Q0 != null) {
            Iterator<T> it = Q0.iterator();
            while (it.hasNext()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(((MediaModel) it.next()).videos, 0);
                MediaClip mediaClip = (MediaClip) orNull;
                if (mediaClip != null) {
                    emptyList = CollectionsKt___CollectionsKt.plus((Collection<? extends MediaClip>) ((Collection<? extends Object>) emptyList), mediaClip);
                }
            }
        }
        return emptyList;
    }

    public final boolean a1() {
        MosaicDataSerializable mosaicData;
        ArrayList<String> pathList;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mosaicData = Z0.getMosaicData()) != null && (pathList = mosaicData.getPathList()) != null) {
            return !pathList.isEmpty();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void addPlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        IPlayer player;
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.addPlayerListener(playerListener);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void b(boolean hidden) {
        TextView textView;
        this.isHidden = hidden;
        if (hidden) {
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setVisibility(4);
            }
            TextView textView2 = this.indicator;
            if (textView2 != null) {
                textView2.setVisibility(4);
                return;
            }
            return;
        }
        t1();
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setVisibility(0);
        }
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        if (winkTavCutParams.u().size() > 1 && (textView = this.indicator) != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void b0(float volume, @NotNull AudioModel.Type audioType) {
        Intrinsics.checkNotNullParameter(audioType, "audioType");
    }

    public void b1(@Nullable WinkPlayerContainerView containerView, @NotNull dr.WinkTavCutParams params, @NotNull HashMap<String, Object> extraMap) {
        ViewPager2 viewPager2;
        ICutSession iCutSession;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        q1();
        WatermarkConfig watermarkConfig = params.getWatermarkConfig();
        if (watermarkConfig != null && (iCutSession = this.session) != null) {
            iCutSession.setWatermarkConfig(watermarkConfig);
        }
        this.params = params;
        k1(params);
        this.oriMediaModels = Q0();
        if (params.getPlayerSurface() != null) {
            ICutSession iCutSession2 = this.session;
            if (iCutSession2 != null) {
                iCutSession2.updateRenderSize(new org.light.lightAssetKit.components.Size(params.getWidth(), params.getHeight()));
            }
            c1(params.getPlayerSurface(), params.getWidth(), params.getHeight());
        } else {
            TextView textView = null;
            if (containerView != null) {
                viewPager2 = containerView.getImagePlayerContainer();
            } else {
                viewPager2 = null;
            }
            this.viewPager = viewPager2;
            if (containerView != null) {
                textView = containerView.getImageIndexIndicator();
            }
            this.indicator = textView;
            x1(params.getWidth(), params.getHeight());
        }
        l1();
        this.isInit = true;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<MediaClip> c(@NotNull List<? extends Pair<? extends Matrix, ? extends android.graphics.RectF>> cropInfoList) {
        ArrayList arrayList;
        List<MediaClip> emptyList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        MediaModel copy;
        ResourceModel resourceModel;
        ResourceModel copy2;
        Intrinsics.checkNotNullParameter(cropInfoList, "cropInfoList");
        List<MediaModel> Q0 = Q0();
        if (Q0 != null) {
            List<MediaModel> list = Q0;
            int i3 = 10;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            int i16 = 0;
            for (Object obj : list) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MediaModel mediaModel = (MediaModel) obj;
                List<MediaClip> list2 = mediaModel.videos;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, i3);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (MediaClip mediaClip : list2) {
                    if (cropInfoList.get(i16) != null) {
                        List<Float> a16 = com.tencent.mobileqq.wink.editor.crop.a.a(cropInfoList.get(i16).getFirst());
                        ResourceModel resourceModel2 = mediaClip.resource;
                        if (resourceModel2 != null) {
                            copy2 = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : new RectF(cropInfoList.get(i16).getSecond().left, cropInfoList.get(i16).getSecond().top, cropInfoList.get(i16).getSecond().right, cropInfoList.get(i16).getSecond().bottom, null, 16, null), (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                            resourceModel = copy2;
                        } else {
                            resourceModel = null;
                        }
                        mediaClip = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, a16, null, 94, null);
                    }
                    arrayList2.add(mediaClip);
                }
                copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : arrayList2, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
                arrayList.add(copy);
                i16 = i17;
                i3 = 10;
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            H1(arrayList);
        }
        F1();
        dr.b.b(this, false, 1, null);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void c0(boolean isOpen) {
        MediaModel copy;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        dr.WinkTavCutParams winkTavCutParams2 = null;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        for (WinkEditData winkEditData : winkTavCutParams.u()) {
            if (winkEditData.getOpenHDR() != isOpen) {
                winkEditData.setOpenHDR(isOpen);
                copy = r7.copy((r39 & 1) != 0 ? r7.id : null, (r39 & 2) != 0 ? r7.name : null, (r39 & 4) != 0 ? r7.version : null, (r39 & 8) != 0 ? r7.createTime : null, (r39 & 16) != 0 ? r7.updateTime : null, (r39 & 32) != 0 ? r7.duration : null, (r39 & 64) != 0 ? r7.videos : null, (r39 & 128) != 0 ? r7.audios : null, (r39 & 256) != 0 ? r7.stickers : null, (r39 & 512) != 0 ? r7.backgroundModel : null, (r39 & 1024) != 0 ? r7.filterModels : null, (r39 & 2048) != 0 ? r7.specialEffects : null, (r39 & 4096) != 0 ? r7.transitions : null, (r39 & 8192) != 0 ? r7.templateModel : null, (r39 & 16384) != 0 ? r7.coverInfo : null, (r39 & 32768) != 0 ? r7.exportSetting : null, (r39 & 65536) != 0 ? r7.openHDR : Boolean.valueOf(isOpen), (r39 & 131072) != 0 ? r7.hdrModels : null, (r39 & 262144) != 0 ? r7.smoothModels : null, (r39 & 524288) != 0 ? r7.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
                winkEditData.setMediaModel(copy);
            }
        }
        dr.WinkTavCutParams winkTavCutParams3 = this.params;
        if (winkTavCutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            winkTavCutParams2 = winkTavCutParams3;
        }
        WinkEditData winkEditData2 = winkTavCutParams2.u().get(this.currentPosition);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.l(winkEditData2.getMediaModel());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void d(@NotNull ICutStatusCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutStatusCallBackList.remove(listener);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public Size d0(@Nullable MetaMaterial metaMaterial) {
        return a();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void e(@NotNull WinkStickerModel stickerModel) {
        List<? extends WinkStickerModel> listOf;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(stickerModel);
        T(listOf);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean e0(@NotNull List<? extends MediaClip> clips) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(clips, "clips");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        WinkEditData winkEditData = winkTavCutParams.u().get(this.currentPosition);
        copy = r2.copy((r39 & 1) != 0 ? r2.id : null, (r39 & 2) != 0 ? r2.name : null, (r39 & 4) != 0 ? r2.version : null, (r39 & 8) != 0 ? r2.createTime : null, (r39 & 16) != 0 ? r2.updateTime : null, (r39 & 32) != 0 ? r2.duration : null, (r39 & 64) != 0 ? r2.videos : clips, (r39 & 128) != 0 ? r2.audios : null, (r39 & 256) != 0 ? r2.stickers : null, (r39 & 512) != 0 ? r2.backgroundModel : null, (r39 & 1024) != 0 ? r2.filterModels : null, (r39 & 2048) != 0 ? r2.specialEffects : null, (r39 & 4096) != 0 ? r2.transitions : null, (r39 & 8192) != 0 ? r2.templateModel : null, (r39 & 16384) != 0 ? r2.coverInfo : null, (r39 & 32768) != 0 ? r2.exportSetting : null, (r39 & 65536) != 0 ? r2.openHDR : null, (r39 & 131072) != 0 ? r2.hdrModels : null, (r39 & 262144) != 0 ? r2.smoothModels : null, (r39 & 524288) != 0 ? r2.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
        winkEditData.setMediaModel(copy);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.l(winkEditData.getMediaModel());
            return true;
        }
        return true;
    }

    public boolean e1() {
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<WinkStickerModel> f() {
        List<WinkStickerModel> emptyList;
        Map<String, WinkStickerModel> stickerModelMap;
        Collection<WinkStickerModel> values;
        boolean z16;
        WinkEditData Z0 = Z0();
        if (Z0 == null || (stickerModelMap = Z0.getStickerModelMap()) == null || (values = stickerModelMap.values()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
            if (!winkStickerModel.isTemplateTextSticker() && !winkStickerModel.isBackgroundTextSticker() && !winkStickerModel.isTemplateImageSticker()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean f0(@Nullable String str) {
        return dr.b.i(this, str);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void flush(boolean force) {
        if (force) {
            ICutSession iCutSession = this.session;
            if (iCutSession != null) {
                iCutSession.flush();
                return;
            }
            return;
        }
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        WinkEditData winkEditData = winkTavCutParams.u().get(this.currentPosition);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.l(winkEditData.getMediaModel());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r0 != null) goto L12;
     */
    @Override // com.tencent.mobileqq.wink.editor.dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        MetaMaterial metaMaterial;
        Map<String, MetaMaterial> templateMaterialMap;
        Collection<MetaMaterial> values;
        Object elementAtOrNull;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (templateMaterialMap = Z0.getTemplateMaterialMap()) != null && (values = templateMaterialMap.values()) != null) {
            elementAtOrNull = CollectionsKt___CollectionsKt.elementAtOrNull(values, 0);
            metaMaterial = (MetaMaterial) elementAtOrNull;
        }
        metaMaterial = null;
        if (metaMaterial != null) {
            this.templateMaterial = metaMaterial;
            SimpleEventBus.getInstance().dispatchEvent(new TemplateSelectEvent(metaMaterial, false));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<MediaClip> g0() {
        return V().videos;
    }

    public boolean g1() {
        MediaModel mediaModel;
        Map<String, SpecialEffectModel> map;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null && (map = mediaModel.specialEffects) != null) {
            return !map.isEmpty();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public long getCurrentPlayUs() {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            return player.getCurrentPlayUs();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public long getDurationUs() {
        return 10000000L;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public long getFrameDuration() {
        return dr.b.d(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    /* renamed from: getPlayer */
    public IPlayer getCurrentPlayer() {
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            return iCutSession.getPlayer();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public Size getRenderSize() {
        FrameLayout S0 = S0(this.currentPosition);
        if (S0 != null) {
            return new Size(Integer.valueOf(S0.getLayoutParams().width), Integer.valueOf(S0.getLayoutParams().height), null, 4, null);
        }
        return new Size(null, null, null, 7, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public long h() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        return winkTavCutParams.getMaxPlayerTimeLimit();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    public WinkEditData h0() {
        Object orNull;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkTavCutParams.u(), this.currentPosition);
        return (WinkEditData) orNull;
    }

    public boolean h1() {
        MediaModel mediaModel;
        Map<String, StickerModel> map;
        WinkEditData Z0 = Z0();
        if (Z0 != null && (mediaModel = Z0.getMediaModel()) != null && (map = mediaModel.stickers) != null) {
            return !map.isEmpty();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean i() {
        boolean z16;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        if (u16 != null && !u16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void i0(@Nullable FilterModel filterModel, @Nullable MetaMaterial material, boolean onlyUpdateIntensity) {
        MediaModel copy;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        WinkEditData winkEditData = winkTavCutParams.u().get(this.currentPosition);
        if (winkEditData.getFilterModelMap() == null) {
            winkEditData.setFilterModelMap(new LinkedHashMap());
        }
        if (winkEditData.getFilterMaterialMap() == null) {
            winkEditData.setFilterMaterialMap(new LinkedHashMap());
        }
        Map<String, MetaMaterial> filterMaterialMap = winkEditData.getFilterMaterialMap();
        Intrinsics.checkNotNull(filterMaterialMap);
        filterMaterialMap.clear();
        Map<String, FilterModel> filterModelMap = winkEditData.getFilterModelMap();
        Intrinsics.checkNotNull(filterModelMap);
        filterModelMap.clear();
        if (material != null) {
            Map<String, MetaMaterial> filterMaterialMap2 = winkEditData.getFilterMaterialMap();
            Intrinsics.checkNotNull(filterMaterialMap2);
            String str = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "it.id");
            filterMaterialMap2.put(str, material);
        }
        if (filterModel != null) {
            Map<String, FilterModel> filterModelMap2 = winkEditData.getFilterModelMap();
            Intrinsics.checkNotNull(filterModelMap2);
            filterModelMap2.put(filterModel.id, filterModel);
        }
        MediaModel mediaModel = winkEditData.getMediaModel();
        Map<String, FilterModel> filterModelMap3 = winkEditData.getFilterModelMap();
        Intrinsics.checkNotNull(filterModelMap3);
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : filterModelMap3, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        winkEditData.setMediaModel(copy);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.l(winkEditData.getMediaModel());
        }
    }

    public final void i1(int width, int height) {
        n1();
        q1();
        x1(width, height);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean isPlaying() {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            return player.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    /* renamed from: isReady, reason: from getter */
    public boolean getIsReady() {
        return this.isReady;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void j() {
        this.oriMediaModels = Q0();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void j0(@NotNull String dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void k(@NotNull HashMap<String, HDRModel> inputMap, long playTime, boolean useHDR, boolean needPlay) {
        Intrinsics.checkNotNullParameter(inputMap, "inputMap");
        for (WinkEditData winkEditData : n()) {
            winkEditData.setMediaModel(MediaModelUtilsKt.updateHDRClips(winkEditData.getMediaModel(), inputMap, useHDR));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void k0(@Nullable AudioModel audioModel, @NotNull AudioModel.Type audioType) {
        Intrinsics.checkNotNullParameter(audioType, "audioType");
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    /* renamed from: l, reason: from getter */
    public ICutSession getSession() {
        return this.session;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean l0() {
        return !Intrinsics.areEqual(this.oriMediaModels, Q0());
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @Nullable
    public Map<String, WinkStickerModel> m() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        return winkTavCutParams.u().get(this.currentPosition).getStickerModelMap();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void m0(@NotNull ICutStatusCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutStatusCallBackList.add(listener);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<WinkEditData> n() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        return winkTavCutParams.u();
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void n0(int width, int height) {
        dr.WinkTavCutParams a16;
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        a16 = r2.a((r41 & 1) != 0 ? r2.isFirstInit : false, (r41 & 2) != 0 ? r2.editMode : null, (r41 & 4) != 0 ? r2.winkEditData : null, (r41 & 8) != 0 ? r2.templatePath : null, (r41 & 16) != 0 ? r2.isFromTemplateColl : null, (r41 & 32) != 0 ? r2.width : width, (r41 & 64) != 0 ? r2.height : height, (r41 & 128) != 0 ? r2.playerSurface : null, (r41 & 256) != 0 ? r2.assetData : null, (r41 & 512) != 0 ? r2.enableSoftDecode : false, (r41 & 1024) != 0 ? r2.softDecodeThreadCount : 0, (r41 & 2048) != 0 ? r2.maxPlayerTimeLimit : 0L, (r41 & 4096) != 0 ? r2.enableImageTemplateEdit : false, (r41 & 8192) != 0 ? r2.isFromQzoneText : false, (r41 & 16384) != 0 ? r2.textQzoneText : null, (r41 & 32768) != 0 ? r2.scene : null, (r41 & 65536) != 0 ? r2.autoPlay : false, (r41 & 131072) != 0 ? r2.enableVideoFilter : false, (r41 & 262144) != 0 ? r2.surfaceHeight : 0, (r41 & 524288) != 0 ? r2.surfaceWidth : 0, (r41 & 1048576) != 0 ? r2.needPaintingFlush : false, (r41 & 2097152) != 0 ? winkTavCutParams.watermarkConfig : null);
        this.params = a16;
    }

    public final void o1(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.onPageChangeCallbacks.contains(callback)) {
            return;
        }
        this.onPageChangeCallbacks.remove(callback);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int state) {
        w53.b.a("WinkImageTavCut", "[onPageScrollStateChanged] state=" + state);
        if (this.pageChanged && state == 0) {
            int i3 = this.lastPosition;
            int i16 = this.currentPosition;
            if (i3 != i16) {
                this.lastPosition = i16;
                n1();
                q1();
                j1(this.currentPosition);
                this.pageChanged = false;
                Iterator<b> it = this.onPageChangeCallbacks.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.b()) {
                        next.a(this.currentPosition);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        ms.a.a("WinkImageTavCut", "[onPageSelected] position=" + position);
        if (this.currentPosition != position) {
            this.currentPosition = position;
            this.pageChanged = true;
            SimpleEventBus.getInstance().dispatchEvent(new ImageChangePageEvent(position));
            G1();
            Iterator<b> it = this.onPageChangeCallbacks.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!next.b()) {
                    next.a(this.currentPosition);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public boolean p() {
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        if ((u16 instanceof Collection) && u16.isEmpty()) {
            return false;
        }
        Iterator<T> it = u16.iterator();
        while (it.hasNext()) {
            if (((WinkEditData) it.next()).getOpenHDR()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void pause() {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.pause();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void play() {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.play();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    /* renamed from: q, reason: from getter */
    public boolean getIsInit() {
        return this.isInit;
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void r(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        winkTavCutParams.u().get(this.currentPosition).setMediaModel(mediaModel);
        ComposeRenderLayer composeRenderLayer = this.renderLayer;
        if (composeRenderLayer != null) {
            composeRenderLayer.l(mediaModel);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void release() {
        ms.a.f("WinkImageTavCut", "release begin " + this.session);
        n1();
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        }
        ms.a.f("WinkImageTavCut", "release end " + this.session);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void removePlayerListener(@NotNull IPlayer.PlayerListener playerListener) {
        IPlayer player;
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.removePlayerListener(playerListener);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void s(float volume, @NotNull AudioModel.Type audioType) {
        Intrinsics.checkNotNullParameter(audioType, "audioType");
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void seek(long timeUs) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession == null || (player = iCutSession.getPlayer()) == null) {
            return;
        }
        player.seek(timeUs);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void setAutoPlay(boolean isAutoPlay) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.setAutoPlay(isAutoPlay);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void setLoopPlay(boolean isLoop) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.setLoopPlay(isLoop);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void setPlayTimeRange(long startTimeUs, long durationUs) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.setPlayTimeRange(startTimeUs, durationUs);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void stop(long timeUs) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.stop(timeUs);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void t(@NotNull WinkStickerModel stickerModel, boolean isTransition) {
        Map<String, WinkStickerModel> linkedHashMap;
        WinkEditData Z0;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        WinkEditData Z02 = Z0();
        if (Z02 == null || (linkedHashMap = Z02.getStickerModelMap()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        Iterator<T> it = this.stickerUpdateListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.wink.editor.sticker.sticker.d) it.next()).a(stickerModel, linkedHashMap);
        }
        WinkStickerModel winkStickerModel = linkedHashMap.get(stickerModel.id);
        linkedHashMap.put(stickerModel.id, stickerModel);
        if (winkStickerModel != null && isTransition && ((stickerModel.isTemplateTextSticker() || stickerModel.isTemplateImageSticker()) && (Z0 = Z0()) != null)) {
            Z0.setStickerModelMap(linkedHashMap);
            MediaModel mediaModel = Z0.getMediaModel();
            Map<String, WinkStickerModel> stickerModelMap = Z0.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap);
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : stickerModelMap, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            Z0.setMediaModel(copy);
            ComposeRenderLayer composeRenderLayer = this.renderLayer;
            if (composeRenderLayer != null) {
                composeRenderLayer.s(winkStickerModel, stickerModel);
            }
        }
        B(linkedHashMap);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void u() {
        this.lastMediaModels = Q0();
    }

    public void u1(@NotNull String templatePath, @NotNull HashMap<String, String> map) {
        HashMap<String, String> assetData;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(map, "map");
        w53.b.a("WinkImageTavCut", "setAssetData : " + templatePath + ", " + map + " ");
        WinkEditData Z0 = Z0();
        if (Z0 != null && (assetData = Z0.getAssetData()) != null) {
            assetData.putAll(map);
        }
        ICutSession iCutSession = this.session;
        if (iCutSession != null) {
            iCutSession.setAssetData(templatePath, map);
        }
        ICutSession iCutSession2 = this.session;
        if (iCutSession2 != null) {
            iCutSession2.flushWithoutDelay();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void v(@NotNull Map<Integer, Float> clipVolumes) {
        Intrinsics.checkNotNullParameter(clipVolumes, "clipVolumes");
    }

    public final void v1(@NotNull HashMap<String, String> map) {
        String c16;
        Intrinsics.checkNotNullParameter(map, "map");
        if (getTemplatePath() == null) {
            c16 = com.tencent.mobileqq.wink.utils.r.c(r73.a.f430927a.b());
        } else {
            c16 = com.tencent.mobileqq.wink.utils.r.c(getTemplatePath());
        }
        if (c16 != null) {
            u1(c16, map);
        } else {
            w53.b.c("WinkImageTavCut", "no template but set asset data");
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public HashMap<String, List<String>> w() {
        return this.mediaLabels;
    }

    public final void w1(@Nullable IRenderTimeListener listener) {
        ICutSession iCutSession;
        if (listener != null && (iCutSession = this.session) != null) {
            iCutSession.setRenderTimeListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void x(@NotNull BasePartFragment hostFragment, @NotNull dr.WinkTavCutParams params, @NotNull HashMap<String, Object> extraMap) {
        WinkPlayerContainerView winkPlayerContainerView;
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        View view = hostFragment.getView();
        if (view != null) {
            winkPlayerContainerView = (WinkPlayerContainerView) view.findViewById(R.id.f25760bp);
        } else {
            winkPlayerContainerView = null;
        }
        b1(winkPlayerContainerView, params, extraMap);
    }

    public final void x1(int width, int height) {
        int collectionSizeOrDefault;
        this.showAreaWidth = width;
        this.showAreaHeight = height;
        ViewPager2 viewPager2 = this.viewPager;
        Intrinsics.checkNotNull(viewPager2);
        viewPager2.setOrientation(0);
        dr.WinkTavCutParams winkTavCutParams = this.params;
        if (winkTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            winkTavCutParams = null;
        }
        List<WinkEditData> u16 = winkTavCutParams.u();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(u16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = u16.iterator();
        while (it.hasNext()) {
            arrayList.add(((WinkEditData) it.next()).getMediaModel());
        }
        viewPager2.setAdapter(new dc(arrayList));
        viewPager2.registerOnPageChangeCallback(this);
        viewPager2.setVisibility(0);
        this.recyclerView = (RecyclerView) viewPager2.getChildAt(0);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.dd
            @Override // java.lang.Runnable
            public final void run() {
                WinkImageTavCut.y1(WinkImageTavCut.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<SpecialEffectModel> y() {
        return dr.b.c(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    @NotNull
    public List<String> z() {
        ArrayList arrayList = new ArrayList();
        Collection<List<String>> values = this.mediaLabels.values();
        if (values != null) {
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                List it5 = (List) it.next();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.addAll(it5);
            }
        }
        return arrayList;
    }

    public void z1(@Nullable String str) {
        this.templatePath = str;
    }

    public /* synthetic */ WinkImageTavCut(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void seek(long timeUs, boolean openInAccurateSeek) {
        IPlayer player;
        ICutSession iCutSession = this.session;
        if (iCutSession == null || (player = iCutSession.getPlayer()) == null) {
            return;
        }
        player.seek(timeUs, openInAccurateSeek);
    }

    public WinkImageTavCut(@Nullable String str) {
        this.templatePath = str;
        this.lastPosition = -1;
        this.oriMediaModels = new ArrayList();
        this.lastMediaModels = new ArrayList();
        this.needStretchBack = true;
        this.isReady = true;
        this.mediaLabels = new HashMap<>();
        this.onPageChangeCallbacks = new CopyOnWriteArrayList<>();
        this.stickerUpdateListeners = new ArrayList();
        this.cutStatusCallBackList = new CopyOnWriteArrayList<>();
        this.renderWidth = 720;
        this.renderHeight = 1280;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkImageTavCut$f", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ISessionListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f318679b;

        f(Function0<Unit> function0) {
            this.f318679b = function0;
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            WinkImageTavCut.this.Q(this);
            this.f318679b.invoke();
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void o(float volume) {
    }

    @Override // com.tencent.mobileqq.wink.editor.dr
    public void Y(boolean isFullScreen, int bottomOffset, int topOffset, boolean isBackgroundPanel) {
    }
}
