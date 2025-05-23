package com.tencent.mobileqq.wink.editor.crop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$cropBroadcastReceiver$2;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView;
import com.tencent.mobileqq.wink.editor.crop.viewmodel.WinkEditorCropViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.view.WinkHorizontalProgressWheelView;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.util.AnimateUtils;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.widget.HorizontalListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0006\n\u0002\b\t*\u0004\u00c2\u0001\u00c8\u0001\u0018\u0000 \u00ce\u00012\u00020\u00012\u00020\u0002:\u0002\u00cf\u0001B\t\u00a2\u0006\u0006\b\u00cc\u0001\u0010\u00cd\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u001a\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J*\u0010+\u001a\u00020\u00052\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u0003H\u0002J\b\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\u0018\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0018\u00104\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0003H\u0002J\b\u00106\u001a\u00020\u0003H\u0002J\b\u00107\u001a\u00020\u0005H\u0002J\b\u00109\u001a\u000208H\u0002J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020\u0005H\u0002J\u0016\u0010?\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0002J&\u0010D\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020C0B2\u0006\u0010A\u001a\u00020@2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@H\u0002J\b\u0010F\u001a\u00020\u0018H\u0014J\b\u0010G\u001a\u00020\u0018H\u0014J\b\u0010H\u001a\u00020\u0003H\u0014J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u000bH\u0016J\b\u0010K\u001a\u000208H\u0016J\u001a\u0010O\u001a\u00020\u00052\u0006\u0010L\u001a\u00020:2\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\b\u0010P\u001a\u00020\u0005H\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010R\u001a\u00020\u0005H\u0016J\u000e\u0010U\u001a\u00020T2\u0006\u0010S\u001a\u00020\u0018J\u0006\u0010V\u001a\u000208J\u0006\u0010W\u001a\u00020\u0003R\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010^R\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR&\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u00110rj\b\u0012\u0004\u0012\u00020\u0011`s8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010^R\u0018\u0010z\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010^R\u0016\u0010|\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010oR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010eR\u0018\u0010\u0090\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010eR\u0018\u0010\u0092\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010eR!\u0010\u0098\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009b\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R!\u0010\u00a0\u0001\u001a\u00030\u009c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0095\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R \u0010\u00a3\u0001\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u0095\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R \u0010\u00a6\u0001\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u0095\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a2\u0001R \u0010\u00aa\u0001\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u0095\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R+\u0010\u00b0\u0001\u001a\r \u00ac\u0001*\u0005\u0018\u00010\u00ab\u00010\u00ab\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ad\u0001\u0010\u0095\u0001\u001a\u0006\b\u00ae\u0001\u0010\u00af\u0001R4\u0010\u00b6\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u00b2\u00010\u00b1\u00010'8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b3\u0001\u0010\u0095\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001R!\u0010\u00bb\u0001\u001a\u00030\u00b7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b8\u0001\u0010\u0095\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0019\u0010\u00bd\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u009a\u0001R\u0019\u0010\u00bf\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u009a\u0001R\u0019\u0010\u00c1\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u009a\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u0018\u0010\u00cb\u0001\u001a\u00030\u00c8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001\u00a8\u0006\u00d0\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "", "ai", "", "Ni", "si", "Landroid/view/Surface;", "playerSurface", "zi", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Zh", "isInitMediaModel", SensorJsPlugin.SENSOR_INTERVAL_UI, "Yh", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "Ri", "Wi", "Ti", "initViewModel", "Ai", "", "position", "Fi", "xi", "wi", WidgetCacheLunarData.YI, "", "currentValue", "initScale", "Qi", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "type", "reverse", "Oi", "di", "", "mediaClipsAfterCrop", "isCancel", "isBlurAfterCrop", "ei", "reset", "bi", "Si", "Landroid/graphics/Matrix;", "matrix1", "matrix2", "Ei", "cancel", "ri", "qi", "Di", "Li", "", "ni", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "ti", "cropMediaClips", "Mi", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$CropInfo;", "cropInfo", "", "", "hi", "Ki", "getStatusBarColor", "getContentLayoutId", "needAdjustImmersive", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "index", "", "gi", "getPageId", "handleBackEvent", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropView;", "cropView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "rotateTextView", "Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView;", "E", "Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView;", "rotateWheelView", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;", "cropRatioView", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "rotateContainerLayout", "H", "resetTextView", "Lcom/tencent/widget/HorizontalListView;", "I", "Lcom/tencent/widget/HorizontalListView;", "videoListView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "J", "Ljava/util/ArrayList;", "mediaClips", "K", "tvTotalTime", "L", "tvPastTime", "M", "currentSelectClipIndex", "Lcom/tencent/mobileqq/wink/editor/crop/b;", "N", "Lcom/tencent/mobileqq/wink/editor/crop/b;", "videoListViewAdapter", "Landroid/view/animation/Animation;", "P", "Landroid/view/animation/Animation;", "resetFadeInAnimation", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "resetFadeOutAnimation", "Lcom/tencent/mobileqq/wink/editor/dr;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutManager", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment;", "baseFragment", "T", "U", "scaleBeforeRotate", "V", "scaleAfterRotate", "Ljava/text/SimpleDateFormat;", "W", "Lkotlin/Lazy;", "pi", "()Ljava/text/SimpleDateFormat;", "timeFormat", "X", "Z", "isScaleTipsVisible", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "Y", WidgetCacheLunarData.JI, "()Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "cropViewModel", "oi", "()J", "startTimeOffset", "a0", "mi", "selectIndex", "b0", "Ci", "()Z", "isFromClipping", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "c0", "li", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "quitDialog", "Lkotlin/Pair;", "Landroid/graphics/RectF;", "d0", "ki", "()Ljava/util/List;", "originMediaClipCropData", "Landroid/content/BroadcastReceiver;", "e0", "ii", "()Landroid/content/BroadcastReceiver;", "cropBroadcastReceiver", "f0", "isDirty", "g0", "isOriginReverse", "h0", "isRotate90", "com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$h", "i0", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$h;", "playerListener", "j0", "Landroid/view/Surface;", "com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$i", "k0", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$i;", "surfaceTextureListener", "<init>", "()V", "m0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropFragment extends ImmersivePartFragment implements IWinkCrashReportCallback {

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private WinkEditorCropView cropView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView rotateTextView;

    /* renamed from: E, reason: from kotlin metadata */
    private WinkHorizontalProgressWheelView rotateWheelView;

    /* renamed from: F, reason: from kotlin metadata */
    private WinkEditorCropRatioView cropRatioView;

    /* renamed from: G, reason: from kotlin metadata */
    private RelativeLayout rotateContainerLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView resetTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private HorizontalListView videoListView;

    /* renamed from: J, reason: from kotlin metadata */
    private ArrayList<MediaClip> mediaClips;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView tvTotalTime;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView tvPastTime;

    /* renamed from: M, reason: from kotlin metadata */
    private int currentSelectClipIndex;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.crop.b videoListViewAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Animation resetFadeInAnimation;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Animation resetFadeOutAnimation;

    /* renamed from: R, reason: from kotlin metadata */
    private dr tavCutManager;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy timeFormat;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isScaleTipsVisible;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy startTimeOffset;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectIndex;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isFromClipping;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy quitDialog;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy originMediaClipCropData;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cropBroadcastReceiver;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean isDirty;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isOriginReverse;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isRotate90;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h playerListener;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface playerSurface;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i surfaceTextureListener;

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319732l0 = new LinkedHashMap();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private WinkEditorCropFragment baseFragment = this;

    /* renamed from: T, reason: from kotlin metadata */
    private float initScale = 1.0f;

    /* renamed from: U, reason: from kotlin metadata */
    private float scaleBeforeRotate = 1.0f;

    /* renamed from: V, reason: from kotlin metadata */
    private float scaleAfterRotate = 1.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJJ\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/videocut/model/MediaClip;", "Lkotlin/collections/ArrayList;", "mediaClips", "", "startTimeOffset", "", "isFromEditor", "totalDuration", "selectIndex", "isFromClipping", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment;", "a", "", "KEY_IS_BLUR_AFTER_CROP", "Ljava/lang/String;", "KEY_IS_CHANGED_AFTER_CROP", "KEY_IS_FROM_CLIPPING", "KEY_IS_FROM_EDITOR", "KEY_MEDIA_CLIP", "KEY_SELECT_INDEX", "KEY_START_TIME", "TAG", "TOTAL_DURATION", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkEditorCropFragment a(@NotNull ArrayList<MediaClip> mediaClips, long startTimeOffset, boolean isFromEditor, long totalDuration, long selectIndex, boolean isFromClipping) {
            Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
            WinkEditorCropFragment winkEditorCropFragment = new WinkEditorCropFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key_media_clip", mediaClips);
            bundle.putBoolean("key_is_from_editor", isFromEditor);
            bundle.putLong("key_start_time", startTimeOffset);
            bundle.putLong("key_total_duration", totalDuration);
            bundle.putLong("key_slect_index", selectIndex);
            bundle.putBoolean("key_is_from_clipping", isFromClipping);
            winkEditorCropFragment.setArguments(bundle);
            return winkEditorCropFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319733a;

        static {
            int[] iArr = new int[WinkEditorCropRatioView.RatioType.values().length];
            try {
                iArr[WinkEditorCropRatioView.RatioType.FreeRatio.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Origin.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Ratio9to16.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Ratio3to4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Ratio1to1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Ratio4to3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WinkEditorCropRatioView.RatioType.Ratio16to9.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f319733a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$c", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorTransformTextureView$b;", "Landroid/graphics/Matrix;", "matrix", "", "isChanged", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkEditorTransformTextureView.b {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView.b
        public void a(@NotNull Matrix matrix, boolean isChanged) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            WinkEditorCropFragment.this.bi();
            if (isChanged && WinkEditorCropFragment.this.isScaleTipsVisible) {
                WinkEditorCropFragment.this.isScaleTipsVisible = false;
                ((TextView) WinkEditorCropFragment.this.xh(R.id.f1055466a)).setVisibility(8);
                WinkEditorCropFragment.this.ji().o2(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$d", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$a;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "type", "", "opposite", "needResize", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkEditorCropRatioView.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView.a
        public void a(@NotNull WinkEditorCropRatioView.RatioType type, boolean opposite, boolean needResize) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            WinkEditorCropView winkEditorCropView = WinkEditorCropFragment.this.cropView;
            WinkEditorCropView winkEditorCropView2 = null;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            int a16 = (((int) (((winkEditorCropView.getEditorGestureTextureView().a() + 360) % 360.0f) + 45)) / 90) * 90;
            WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
            if (a16 % 180 == 90) {
                z16 = true;
            } else {
                z16 = false;
            }
            winkEditorCropFragment.Oi(type, z16);
            if (needResize) {
                WinkEditorCropView winkEditorCropView3 = WinkEditorCropFragment.this.cropView;
                if (winkEditorCropView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                } else {
                    winkEditorCropView2 = winkEditorCropView3;
                }
                winkEditorCropView2.getEditorGestureTextureView().R();
            }
            WinkEditorCropFragment.this.bi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$e", "Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView$a;", "", "onScrollStart", "", "deltaValue", "currentValue", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements WinkHorizontalProgressWheelView.a {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkHorizontalProgressWheelView.a
        public void onScroll(float deltaValue, float currentValue) {
            WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
            winkEditorCropFragment.Qi(currentValue, winkEditorCropFragment.scaleBeforeRotate);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkHorizontalProgressWheelView.a
        public void onScrollEnd() {
            WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
            WinkEditorCropView winkEditorCropView = winkEditorCropFragment.cropView;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            winkEditorCropFragment.scaleAfterRotate = winkEditorCropView.getEditorGestureTextureView().e();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkHorizontalProgressWheelView.a
        public void onScrollStart() {
            WinkHorizontalProgressWheelView winkHorizontalProgressWheelView = WinkEditorCropFragment.this.rotateWheelView;
            WinkEditorCropView winkEditorCropView = null;
            if (winkHorizontalProgressWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotateWheelView");
                winkHorizontalProgressWheelView = null;
            }
            if (Math.abs(winkHorizontalProgressWheelView.a()) >= 1.0E-4f) {
                WinkEditorCropView winkEditorCropView2 = WinkEditorCropFragment.this.cropView;
                if (winkEditorCropView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                } else {
                    winkEditorCropView = winkEditorCropView2;
                }
                float e16 = winkEditorCropView.getEditorGestureTextureView().e();
                if (Math.abs(e16 - WinkEditorCropFragment.this.scaleAfterRotate) > 1.0E-4f) {
                    WinkEditorCropFragment.this.scaleBeforeRotate = e16;
                    return;
                }
                return;
            }
            WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
            WinkEditorCropView winkEditorCropView3 = winkEditorCropFragment.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView = winkEditorCropView3;
            }
            winkEditorCropFragment.scaleBeforeRotate = winkEditorCropView.getEditorGestureTextureView().e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$f", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "seekbar", "onStartTrackingTouch", "onStopTrackingTouch", "d", "Z", "isTouching", "", "e", "J", "lastSeekPos", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isTouching;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastSeekPos = -1;

        f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
            long j3 = progress;
            if (this.isTouching) {
                long j16 = this.lastSeekPos;
                if (j16 >= 0 && Math.abs(j3 - j16) < 33000) {
                    return;
                }
                this.lastSeekPos = j3;
                dr drVar = WinkEditorCropFragment.this.tavCutManager;
                if (drVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                    drVar = null;
                }
                drVar.seek(j3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekbar) {
            this.isTouching = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekbar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekbar);
            this.isTouching = false;
            this.lastSeekPos = -1L;
            EventCollector.getInstance().onStopTrackingTouch(seekbar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$g", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends AnimateUtils.AnimationAdapter {
        g() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            TextView textView = WinkEditorCropFragment.this.resetTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView = null;
            }
            textView.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$h", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onPlayerSourceReady", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements IPlayer.PlayerListener {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkEditorCropFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.tvTotalTime;
            if (textView != null) {
                textView.setText(this$0.pi().format(Long.valueOf(j3 / 1000)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkEditorCropFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.tvPastTime;
            if (textView != null) {
                textView.setText(this$0.pi().format(Long.valueOf(j3 / 1000)));
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
            final long durationUs = iPlayer.getDurationUs();
            ((SeekBar) WinkEditorCropFragment.this.xh(R.id.f81814f7)).setMax((int) durationUs);
            ((SeekBar) WinkEditorCropFragment.this.xh(R.id.f81814f7)).setProgress((int) WinkEditorCropFragment.this.oi());
            TextView textView = WinkEditorCropFragment.this.tvTotalTime;
            if (textView != null) {
                final WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorCropFragment.h.c(WinkEditorCropFragment.this, durationUs);
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(final long currentDurationUs, long playerDurationUs) {
            IPlayer.PlayerListener.DefaultImpls.onPositionChanged(this, currentDurationUs, playerDurationUs);
            ((SeekBar) WinkEditorCropFragment.this.xh(R.id.f81814f7)).setProgress((int) currentDurationUs);
            TextView textView = WinkEditorCropFragment.this.tvPastTime;
            if (textView != null) {
                final WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorCropFragment.h.d(WinkEditorCropFragment.this, currentDurationUs);
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            IPlayer.PlayerListener.DefaultImpls.onStatusChanged(this, status, iPlayer);
            if (status == IPlayer.PlayerStatus.PLAYING) {
                iPlayer.pause();
                iPlayer.seek(WinkEditorCropFragment.this.oi());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/crop/WinkEditorCropFragment$i", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class i implements TextureView.SurfaceTextureListener {
        i() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            w53.b.a("wink_crop_WinkEditorCropFragment", "onSurfaceTextureAvailable");
            WinkEditorCropFragment.this.playerSurface = new Surface(surface);
            try {
                WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
                Surface surface2 = winkEditorCropFragment.playerSurface;
                Intrinsics.checkNotNull(surface2);
                winkEditorCropFragment.zi(surface2);
                WinkEditorCropFragment.vi(WinkEditorCropFragment.this, false, 1, null);
            } catch (Exception e16) {
                ms.a.c("wink_crop_WinkEditorCropFragment", e16.toString());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            w53.b.a("wink_crop_WinkEditorCropFragment", "onSurfaceTextureDestroyed");
            surface.release();
            Surface surface2 = WinkEditorCropFragment.this.playerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            dr drVar = null;
            WinkEditorCropFragment.this.playerSurface = null;
            dr drVar2 = WinkEditorCropFragment.this.tavCutManager;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
            } else {
                drVar = drVar2;
            }
            drVar.release();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            w53.b.a("wink_crop_WinkEditorCropFragment", "onSurfaceTextureSizeChanged width:" + width + ", height:" + height);
            dr drVar = WinkEditorCropFragment.this.tavCutManager;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                drVar = null;
            }
            IPlayer currentPlayer = drVar.getCurrentPlayer();
            if (currentPlayer != null) {
                currentPlayer.changeSurfaceSize(width, height);
            }
            WinkEditorCropFragment.vi(WinkEditorCropFragment.this, false, 1, null);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public WinkEditorCropFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$timeFormat$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("mm:ss");
            }
        });
        this.timeFormat = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorCropViewModel>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorCropViewModel invoke() {
                return (WinkEditorCropViewModel) new ViewModelProvider(WinkEditorCropFragment.this.requireActivity()).get(WinkEditorCropViewModel.class);
            }
        });
        this.cropViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$startTimeOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Bundle arguments = WinkEditorCropFragment.this.getArguments();
                return Long.valueOf(arguments != null ? arguments.getLong("key_start_time", 0L) : 0L);
            }
        });
        this.startTimeOffset = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$selectIndex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Bundle arguments = WinkEditorCropFragment.this.getArguments();
                return Long.valueOf(arguments != null ? arguments.getLong("key_slect_index", 0L) : 0L);
            }
        });
        this.selectIndex = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$isFromClipping$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Bundle arguments = WinkEditorCropFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("key_is_from_clipping", false) : false);
            }
        });
        this.isFromClipping = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new WinkEditorCropFragment$quitDialog$2(this));
        this.quitDialog = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Pair<? extends Matrix, ? extends RectF>>>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$originMediaClipCropData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Pair<? extends Matrix, ? extends RectF>> invoke() {
                int collectionSizeOrDefault;
                ArrayList parcelableArrayList = WinkEditorCropFragment.this.requireArguments().getParcelableArrayList("key_media_clip");
                Intrinsics.checkNotNull(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.videocut.model.MediaClip>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.videocut.model.MediaClip> }");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parcelableArrayList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.videocut.render.extension.e.h((MediaClip) it.next()));
                }
                return arrayList;
            }
        });
        this.originMediaClipCropData = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorCropFragment$cropBroadcastReceiver$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$cropBroadcastReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$cropBroadcastReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final WinkEditorCropFragment winkEditorCropFragment = WinkEditorCropFragment.this;
                return new BroadcastReceiver() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment$cropBroadcastReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                        ArrayList arrayList;
                        int i3;
                        Object orNull;
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (Intrinsics.areEqual(intent.getAction(), IECScreenReceiver.ACTION_SCREEN_OFF)) {
                            WinkEditorCropFragment winkEditorCropFragment2 = WinkEditorCropFragment.this;
                            arrayList = winkEditorCropFragment2.mediaClips;
                            if (arrayList == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                                arrayList = null;
                            }
                            i3 = WinkEditorCropFragment.this.currentSelectClipIndex;
                            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3);
                            winkEditorCropFragment2.Ri((MediaClip) orNull);
                            return;
                        }
                        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.USER_PRESENT")) {
                            WinkEditorCropFragment.this.Yh();
                        }
                    }
                };
            }
        });
        this.cropBroadcastReceiver = lazy8;
        this.playerListener = new h();
        this.surfaceTextureListener = new i();
    }

    private final void Ai() {
        int collectionSizeOrDefault;
        com.tencent.mobileqq.wink.editor.crop.b bVar;
        com.tencent.mobileqq.wink.editor.crop.b bVar2;
        ArrayList<MediaClip> arrayList = this.mediaClips;
        HorizontalListView horizontalListView = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                arrayList2.add(resourceModel);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new com.tencent.mobileqq.wink.editor.crop.model.a((ResourceModel) it5.next()));
        }
        Context context = getContext();
        if (context != null) {
            bVar = new com.tencent.mobileqq.wink.editor.crop.b(context, arrayList3);
        } else {
            bVar = null;
        }
        this.videoListViewAdapter = bVar;
        if ((!arrayList3.isEmpty()) && (bVar2 = this.videoListViewAdapter) != null) {
            bVar2.e(this.currentSelectClipIndex);
        }
        if (this.videoListViewAdapter != null) {
            HorizontalListView horizontalListView2 = this.videoListView;
            if (horizontalListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoListView");
                horizontalListView2 = null;
            }
            horizontalListView2.setAdapter((ListAdapter) this.videoListViewAdapter);
            HorizontalListView horizontalListView3 = this.videoListView;
            if (horizontalListView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoListView");
            } else {
                horizontalListView = horizontalListView3;
            }
            horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.k
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                    WinkEditorCropFragment.Bi(WinkEditorCropFragment.this, adapterView, view, i3, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(WinkEditorCropFragment this$0, AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fi(i3);
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    private final boolean Ci() {
        return ((Boolean) this.isFromClipping.getValue()).booleanValue();
    }

    private final boolean Di() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        return arguments.getBoolean("key_is_from_editor", false);
    }

    private final boolean Ei(Matrix matrix1, Matrix matrix2) {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        matrix1.getValues(fArr);
        matrix2.getValues(fArr2);
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String arrays2 = Arrays.toString(fArr2);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        ms.a.a("wink_crop_WinkEditorCropFragment", "matrixArr1: " + arrays + ", matrixArr2: " + arrays2);
        for (int i3 = 0; i3 < 9; i3++) {
            if (Math.abs(fArr[i3] - fArr2[i3]) > 0.3f) {
                return false;
            }
        }
        return true;
    }

    private final void Fi(int position) {
        Object orNull;
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        Ri((MediaClip) orNull);
        this.currentSelectClipIndex = position;
        com.tencent.mobileqq.wink.editor.crop.b bVar = this.videoListViewAdapter;
        if (bVar != null) {
            bVar.e(position);
        }
        Ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(WinkEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorCropView winkEditorCropView = this$0.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.j();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(WinkEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reset();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(WinkEditorCropFragment this$0, View view) {
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorCropView winkEditorCropView = this$0.cropView;
        ArrayList<MediaClip> arrayList = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        if (winkEditorCropView.i()) {
            ArrayList<MediaClip> arrayList2 = this$0.mediaClips;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            } else {
                arrayList = arrayList2;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this$0.currentSelectClipIndex);
            this$0.Ri((MediaClip) orNull);
            this$0.di();
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(6, 100));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(WinkEditorCropFragment this$0, View view) {
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<MediaClip> arrayList = this$0.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this$0.currentSelectClipIndex);
        this$0.Ri((MediaClip) orNull);
        if (this$0.ai()) {
            if (!this$0.li().isShowing()) {
                this$0.li().show();
            }
        } else {
            this$0.cancel();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ki(WinkEditorCropViewModel.CropInfo cropInfo) {
        WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
        ArrayList<MediaClip> arrayList = null;
        if (winkEditorCropRatioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
            winkEditorCropRatioView = null;
        }
        String c16 = winkEditorCropRatioView.c(cropInfo.getRatioType());
        int hashCode = c16.hashCode();
        String str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_FREE;
        switch (hashCode) {
            case 1574725:
                if (c16.equals("1to1")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_1TO1;
                    break;
                }
                break;
            case 1634310:
                if (c16.equals("3to4")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_3TO4;
                    break;
                }
                break;
            case 1664100:
                if (c16.equals("4to3")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_4TO3;
                    break;
                }
                break;
            case 3151468:
                c16.equals("free");
                break;
            case 46976217:
                if (c16.equals("16to9")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_16TO9;
                    break;
                }
                break;
            case 56204697:
                if (c16.equals("9to16")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_9TO16;
                    break;
                }
                break;
            case 1379043793:
                if (c16.equals("original")) {
                    str = WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_ORIGINAL;
                    break;
                }
                break;
        }
        WinkDatongCurrentParams.put(str, 1);
        WinkEditorCropViewModel ji5 = ji();
        ArrayList<MediaClip> arrayList2 = this.mediaClips;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
        } else {
            arrayList = arrayList2;
        }
        if (!ji5.N1(arrayList, ki())) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE, 1);
        }
        if (Math.abs(cropInfo.getRotateDegree()) >= 1.0f) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_SLIDE_ROTATE, 1);
        }
        if (cropInfo.isRotate90()) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_90DEGREE_ROTATE, 1);
        }
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, ni());
    }

    private final void Li() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(ii(), intentFilter);
        }
    }

    private final void Mi(List<? extends MediaClip> cropMediaClips) {
        Object orNull;
        int size = cropMediaClips.size();
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(cropMediaClips, i3);
                MediaClip mediaClip = (MediaClip) orNull;
                WinkEditorCropViewModel.CropInfo T1 = ji().T1(Di(), mediaClip);
                if (T1 != null) {
                    VideoReport.reportEvent("ev_xsj_camera_action", (ImageView) xh(R.id.xyk), hi(T1, mediaClip));
                    Ki(T1);
                }
                if (i3 != size) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private final void Ni() {
        w53.b.a("wink_crop_WinkEditorCropFragment", "resumeClip called");
        if (this.tavCutManager != null) {
            Fi(this.currentSelectClipIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oi(WinkEditorCropRatioView.RatioType type, boolean reverse) {
        Object orNull;
        float mTargetAspectRatio;
        float f16;
        float f17;
        WinkEditorCropView winkEditorCropView = this.cropView;
        ArrayList<MediaClip> arrayList = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        WinkEditorCropMaskView maskView = winkEditorCropView.getMaskView();
        if (type != WinkEditorCropRatioView.RatioType.Origin) {
            this.isOriginReverse = false;
        }
        ArrayList<MediaClip> arrayList2 = this.mediaClips;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
        } else {
            arrayList = arrayList2;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        MediaClip mediaClip = (MediaClip) orNull;
        int i3 = b.f319733a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (mediaClip != null) {
                                    if (reverse) {
                                        this.isOriginReverse = !this.isOriginReverse;
                                    }
                                    if (this.isOriginReverse) {
                                        f16 = com.tencent.videocut.render.extension.e.o(mediaClip).height;
                                        f17 = com.tencent.videocut.render.extension.e.o(mediaClip).width;
                                    } else {
                                        f16 = com.tencent.videocut.render.extension.e.o(mediaClip).width;
                                        f17 = com.tencent.videocut.render.extension.e.o(mediaClip).height;
                                    }
                                    maskView.setTargetAspectRatio(f16 / f17, 2);
                                    return;
                                }
                                return;
                            }
                            maskView.setTargetAspectRatio(1.7777778f, 0);
                            return;
                        }
                        maskView.setTargetAspectRatio(1.3333334f, 0);
                        return;
                    }
                    maskView.setTargetAspectRatio(1.0f, 0);
                    return;
                }
                maskView.setTargetAspectRatio(0.75f, 0);
                return;
            }
            maskView.setTargetAspectRatio(0.5625f, 0);
            return;
        }
        if (mediaClip != null) {
            if (maskView.getMTargetAspectRatio() <= 0.0f) {
                mTargetAspectRatio = com.tencent.videocut.render.extension.e.o(mediaClip).width / com.tencent.videocut.render.extension.e.o(mediaClip).height;
            } else {
                mTargetAspectRatio = maskView.getMTargetAspectRatio();
            }
            maskView.setTargetAspectRatio(mTargetAspectRatio, 1);
        }
    }

    static /* synthetic */ void Pi(WinkEditorCropFragment winkEditorCropFragment, WinkEditorCropRatioView.RatioType ratioType, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        winkEditorCropFragment.Oi(ratioType, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi(float currentValue, float initScale) {
        int color;
        int i3 = (int) currentValue;
        TextView textView = this.rotateTextView;
        WinkEditorCropView winkEditorCropView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
            textView = null;
        }
        if (i3 == 0) {
            color = -1;
        } else {
            color = ContextCompat.getColor(requireContext(), R.color.bdu);
        }
        textView.setTextColor(color);
        TextView textView2 = this.rotateTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
            textView2 = null;
        }
        textView2.setText(getString(R.string.f239287m2, Integer.valueOf(i3)));
        WinkEditorCropView winkEditorCropView2 = this.cropView;
        if (winkEditorCropView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView2 = null;
        }
        float a16 = (winkEditorCropView2.getEditorGestureTextureView().a() + 360) % 360.0f;
        float abs = Math.abs(currentValue);
        float f16 = 44.5f;
        float f17 = 0.0f;
        if (abs >= 44.5f) {
            if (currentValue < 0.0f) {
                f16 = -44.5f;
            }
            f17 = f16;
        } else if (abs >= 0.5d) {
            f17 = currentValue;
        }
        int i16 = (((int) (45 + a16)) / 90) * 90;
        w53.b.a("wink_crop_WinkEditorCropFragment", "setWheelRotateValue currentValue:" + currentValue + ", wheelValue:" + f17 + ", initScale:" + initScale + ", currentAngle:" + a16 + ",  rotate90Degree:" + i16);
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
        } else {
            winkEditorCropView = winkEditorCropView3;
        }
        winkEditorCropView.getEditorGestureTextureView().J((i16 + f17) - a16, initScale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri(MediaClip mediaClip) {
        if (mediaClip != null) {
            WinkEditorCropViewModel ji5 = ji();
            boolean Di = Di();
            WinkEditorCropView winkEditorCropView = this.cropView;
            WinkEditorCropView winkEditorCropView2 = null;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            Matrix d16 = winkEditorCropView.getEditorGestureTextureView().d();
            WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
            if (winkEditorCropRatioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView = null;
            }
            WinkEditorCropRatioView.RatioType selectRatioType = winkEditorCropRatioView.getSelectRatioType();
            WinkHorizontalProgressWheelView winkHorizontalProgressWheelView = this.rotateWheelView;
            if (winkHorizontalProgressWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotateWheelView");
                winkHorizontalProgressWheelView = null;
            }
            float a16 = winkHorizontalProgressWheelView.a();
            WinkEditorCropView winkEditorCropView3 = this.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView3 = null;
            }
            RectF c16 = winkEditorCropView3.getMaskView().c();
            boolean z16 = this.isRotate90;
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            float a17 = winkEditorCropView4.getEditorGestureTextureView().a();
            WinkEditorCropView winkEditorCropView5 = this.cropView;
            if (winkEditorCropView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView2 = winkEditorCropView5;
            }
            ji5.r2(Di, mediaClip, d16, selectRatioType, a16, c16, z16, a17, winkEditorCropView2.e());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0.getAlpha() < 1.0f) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f7, code lost:
    
        if ((((r6 + r0) - ((android.widget.TextView) xh(com.tencent.mobileqq.R.id.f1055466a)).getBottom()) * (((android.widget.TextView) xh(com.tencent.mobileqq.R.id.f1055466a)).getBottom() - ((android.view.ViewGroup.MarginLayoutParams) r4).topMargin)) <= 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0107, code lost:
    
        if (((android.widget.TextView) xh(com.tencent.mobileqq.R.id.f1055466a)).getBottom() > ((android.view.ViewGroup.MarginLayoutParams) r4).topMargin) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Si() {
        ConstraintLayout.LayoutParams layoutParams;
        if (!this.isDirty) {
            return;
        }
        TextView textView = this.resetTextView;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView = null;
        }
        textView.clearAnimation();
        TextView textView3 = this.resetTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView3 = null;
        }
        if (textView3.getVisibility() == 0) {
            TextView textView4 = this.resetTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView4 = null;
            }
        }
        TextView textView5 = this.resetTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView5 = null;
        }
        textView5.setVisibility(0);
        TextView textView6 = this.resetTextView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView6 = null;
        }
        textView6.startAnimation(this.resetFadeInAnimation);
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        RectF c16 = winkEditorCropView.getMaskView().c();
        TextView textView7 = this.resetTextView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView7 = null;
        }
        TextView textView8 = this.resetTextView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView8 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = textView8.getLayoutParams();
        if (layoutParams3 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams3;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((int) c16.top) + com.tencent.videocut.utils.e.f384236a.a(12.0f);
            TextView textView9 = this.resetTextView;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView9 = null;
            }
            int bottom = textView9.getBottom();
            TextView textView10 = this.resetTextView;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            } else {
                textView2 = textView10;
            }
            int top = bottom - textView2.getTop();
            if (((TextView) xh(R.id.f1055466a)) != null && ((TextView) xh(R.id.f1055466a)).getVisibility() == 0) {
                if (top > 0) {
                    int top2 = (((ViewGroup.MarginLayoutParams) layoutParams).topMargin + top) - ((TextView) xh(R.id.f1055466a)).getTop();
                    int top3 = ((TextView) xh(R.id.f1055466a)).getTop();
                    int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    if (top2 * (top3 - i3) <= 0) {
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((TextView) xh(R.id.f1055466a)).getBottom();
                }
                if (top == 0) {
                }
            }
            layoutParams2 = layoutParams;
        }
        textView7.setLayoutParams(layoutParams2);
    }

    private final void Ti() {
        Object orNull;
        ResourceModel resourceModel;
        WinkEditorCropView winkEditorCropView = this.cropView;
        dr drVar = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.setEnableAutoAdjust(false);
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null) {
            ji().W1(mediaClip, false);
            WinkEditorCropView winkEditorCropView2 = this.cropView;
            if (winkEditorCropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView2 = null;
            }
            winkEditorCropView2.setResourceSize(com.tencent.videocut.render.extension.e.o(mediaClip).width, com.tencent.videocut.render.extension.e.o(mediaClip).height);
            dr drVar2 = this.tavCutManager;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                drVar2 = null;
            }
            if (drVar2 != null) {
                WinkEditorCropView winkEditorCropView3 = this.cropView;
                if (winkEditorCropView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                    winkEditorCropView3 = null;
                }
                int width = winkEditorCropView3.getEditorGestureTextureView().getWidth();
                WinkEditorCropView winkEditorCropView4 = this.cropView;
                if (winkEditorCropView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                    winkEditorCropView4 = null;
                }
                drVar2.P(width, winkEditorCropView4.getEditorGestureTextureView().getHeight());
            }
        }
        WinkEditorCropView winkEditorCropView5 = this.cropView;
        if (winkEditorCropView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView5 = null;
        }
        winkEditorCropView5.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorCropFragment.Ui(WinkEditorCropFragment.this);
            }
        });
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            final long j3 = resourceModel.scaleDuration;
            ((SeekBar) xh(R.id.f81814f7)).setMax((int) j3);
            dr drVar3 = this.tavCutManager;
            if (drVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
            } else {
                drVar = drVar3;
            }
            drVar.seek(0L);
            TextView textView = this.tvTotalTime;
            if (textView != null) {
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorCropFragment.Vi(WinkEditorCropFragment.this, j3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(WinkEditorCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Wi();
        WinkEditorCropView winkEditorCropView = this$0.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.setEnableAutoAdjust(true);
        this$0.bi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(WinkEditorCropFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.tvTotalTime;
        if (textView != null) {
            textView.setText(this$0.pi().format(Long.valueOf(j3 / 1000)));
        }
    }

    private final void Wi() {
        if (!Yh()) {
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Yh() {
        Object orNull;
        Object orNull2;
        com.tencent.videocut.model.RectF rectF;
        int i3;
        int color;
        WinkEditorCropViewModel ji5 = ji();
        boolean Di = Di();
        ArrayList<MediaClip> arrayList = this.mediaClips;
        WinkEditorCropView winkEditorCropView = null;
        String str = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        WinkEditorCropViewModel.CropInfo T1 = ji5.T1(Di, (MediaClip) orNull);
        if (T1 != null) {
            if (T1.isEmpty()) {
                return false;
            }
            WinkEditorCropView winkEditorCropView2 = this.cropView;
            if (winkEditorCropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView2 = null;
            }
            winkEditorCropView2.getEditorGestureTextureView().setTransform(T1.getMatrix());
            WinkEditorCropView winkEditorCropView3 = this.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView3 = null;
            }
            winkEditorCropView3.getEditorGestureTextureView().setCropRect(T1.getCropRect());
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            winkEditorCropView4.getMaskView().setCropViewRect(T1.getCropRect());
            WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
            if (winkEditorCropRatioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView = null;
            }
            winkEditorCropRatioView.setSelectedStatus(T1.getRatioType());
            int i16 = b.f319733a[T1.getRatioType().ordinal()];
            if (i16 != 1) {
                i3 = 2;
                if (i16 != 2) {
                    i3 = 0;
                }
            } else {
                i3 = 1;
            }
            WinkEditorCropView winkEditorCropView5 = this.cropView;
            if (winkEditorCropView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView5 = null;
            }
            WinkEditorCropMaskView maskView = winkEditorCropView5.getMaskView();
            WinkEditorCropView winkEditorCropView6 = this.cropView;
            if (winkEditorCropView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView6 = null;
            }
            maskView.setTargetAspectRatio(winkEditorCropView6.getMaskView().getMTargetAspectRatio(), i3);
            WinkHorizontalProgressWheelView winkHorizontalProgressWheelView = this.rotateWheelView;
            if (winkHorizontalProgressWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotateWheelView");
                winkHorizontalProgressWheelView = null;
            }
            winkHorizontalProgressWheelView.setValue(T1.getRotateDegree());
            this.isRotate90 = T1.isRotate90();
            int rotateDegree = (int) T1.getRotateDegree();
            TextView textView = this.rotateTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
                textView = null;
            }
            if (rotateDegree == 0) {
                color = -1;
            } else {
                color = ContextCompat.getColor(requireContext(), R.color.bdu);
            }
            textView.setTextColor(color);
            TextView textView2 = this.rotateTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
                textView2 = null;
            }
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.f239287m2, Integer.valueOf(rotateDegree));
            }
            textView2.setText(str);
            return true;
        }
        ArrayList<MediaClip> arrayList2 = this.mediaClips;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList2 = null;
        }
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList2, this.currentSelectClipIndex);
        MediaClip mediaClip = (MediaClip) orNull2;
        if (mediaClip == null) {
            return false;
        }
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            rectF = resourceModel.picClipRect;
        } else {
            rectF = null;
        }
        if (rectF == null || !mediaClip.matrix.isEmpty()) {
            return false;
        }
        WinkEditorCropView winkEditorCropView7 = this.cropView;
        if (winkEditorCropView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView7 = null;
        }
        RectF g16 = winkEditorCropView7.g(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom));
        WinkEditorCropView winkEditorCropView8 = this.cropView;
        if (winkEditorCropView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
        } else {
            winkEditorCropView = winkEditorCropView8;
        }
        winkEditorCropView.getMaskView().setCropViewRect(g16);
        ms.a.f("wink_crop_WinkEditorCropFragment", "\u521d\u59cb\u5316\u4e86picClip " + g16);
        return false;
    }

    private final List<WinkEditData> Zh() {
        long j3;
        ArrayList arrayListOf;
        int collectionSizeOrDefault;
        Collection collection;
        List<? extends MediaClip> listOf;
        Bundle arguments = getArguments();
        if (arguments != null) {
            j3 = arguments.getLong("key_total_duration");
        } else {
            j3 = 0;
        }
        ArrayList<MediaClip> arrayList = null;
        if (Di()) {
            ArrayList<MediaClip> arrayList2 = this.mediaClips;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            } else {
                arrayList = arrayList2;
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (MediaClip mediaClip : arrayList) {
                WinkImageTavCut.Companion companion = WinkImageTavCut.INSTANCE;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaClip);
                arrayList3.add(companion.b(listOf));
            }
            collection = CollectionsKt___CollectionsKt.toCollection(arrayList3, new ArrayList());
            return (List) collection;
        }
        WinkEditData[] winkEditDataArr = new WinkEditData[1];
        WinkVideoTavCut.Companion companion2 = WinkVideoTavCut.INSTANCE;
        ArrayList<MediaClip> arrayList4 = this.mediaClips;
        if (arrayList4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
        } else {
            arrayList = arrayList4;
        }
        winkEditDataArr[0] = companion2.c(arrayList, j3);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(winkEditDataArr);
        return arrayListOf;
    }

    private final boolean ai() {
        WinkEditorCropViewModel ji5 = ji();
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        return !ji5.N1(arrayList, ki());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r0.getSelectRatioType() != com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView.RatioType.Origin) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bi() {
        boolean z16;
        TextView textView;
        WinkEditorCropRatioView winkEditorCropRatioView;
        WinkEditorCropRatioView winkEditorCropRatioView2;
        TextView textView2;
        TextView textView3;
        WinkEditorCropView winkEditorCropView = this.cropView;
        View view = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        if (Ei(winkEditorCropView.getEditorGestureTextureView().d(), new Matrix())) {
            WinkEditorCropRatioView winkEditorCropRatioView3 = this.cropRatioView;
            if (winkEditorCropRatioView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView3 = null;
            }
            WinkEditorCropRatioView.RatioType selectRatioType = winkEditorCropRatioView3.getSelectRatioType();
            WinkEditorCropRatioView winkEditorCropRatioView4 = this.cropRatioView;
            if (winkEditorCropRatioView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView4 = null;
            }
            if (selectRatioType != winkEditorCropRatioView4.getDefaultRatioType()) {
                WinkEditorCropRatioView winkEditorCropRatioView5 = this.cropRatioView;
                if (winkEditorCropRatioView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                    winkEditorCropRatioView5 = null;
                }
            }
            z16 = false;
            this.isDirty = z16;
            textView = this.resetTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView = null;
            }
            textView.setClickable(this.isDirty);
            boolean z17 = this.isDirty;
            winkEditorCropRatioView = this.cropRatioView;
            if (winkEditorCropRatioView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView = null;
            }
            WinkEditorCropRatioView.RatioType selectRatioType2 = winkEditorCropRatioView.getSelectRatioType();
            winkEditorCropRatioView2 = this.cropRatioView;
            if (winkEditorCropRatioView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
                winkEditorCropRatioView2 = null;
            }
            WinkEditorCropRatioView.RatioType defaultRatioType = winkEditorCropRatioView2.getDefaultRatioType();
            textView2 = this.resetTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView2 = null;
            }
            int visibility = textView2.getVisibility();
            textView3 = this.resetTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView3 = null;
            }
            ms.a.a("wink_crop_WinkEditorCropFragment", "checkNeedReset isDirty:" + z17 + ", cropRatioView.getSelectRatioType():" + selectRatioType2 + ", cropRatioView.getDefaultRatioType():" + defaultRatioType + ", visible:" + visibility + ", resetTextView.alpha:" + textView3.getAlpha() + " ");
            if (!this.isDirty) {
                WinkEditorCropView winkEditorCropView2 = this.cropView;
                if (winkEditorCropView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                } else {
                    view = winkEditorCropView2;
                }
                view.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.crop.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorCropFragment.ci(WinkEditorCropFragment.this);
                    }
                });
                return;
            }
            TextView textView4 = this.resetTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView4 = null;
            }
            textView4.clearAnimation();
            TextView textView5 = this.resetTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                textView5 = null;
            }
            if (textView5.getVisibility() != 8) {
                TextView textView6 = this.resetTextView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
                } else {
                    view = textView6;
                }
                view.startAnimation(this.resetFadeOutAnimation);
                return;
            }
            return;
        }
        z16 = true;
        this.isDirty = z16;
        textView = this.resetTextView;
        if (textView == null) {
        }
        textView.setClickable(this.isDirty);
        boolean z172 = this.isDirty;
        winkEditorCropRatioView = this.cropRatioView;
        if (winkEditorCropRatioView == null) {
        }
        WinkEditorCropRatioView.RatioType selectRatioType22 = winkEditorCropRatioView.getSelectRatioType();
        winkEditorCropRatioView2 = this.cropRatioView;
        if (winkEditorCropRatioView2 == null) {
        }
        WinkEditorCropRatioView.RatioType defaultRatioType2 = winkEditorCropRatioView2.getDefaultRatioType();
        textView2 = this.resetTextView;
        if (textView2 == null) {
        }
        int visibility2 = textView2.getVisibility();
        textView3 = this.resetTextView;
        if (textView3 == null) {
        }
        ms.a.a("wink_crop_WinkEditorCropFragment", "checkNeedReset isDirty:" + z172 + ", cropRatioView.getSelectRatioType():" + selectRatioType22 + ", cropRatioView.getDefaultRatioType():" + defaultRatioType2 + ", visible:" + visibility2 + ", resetTextView.alpha:" + textView3.getAlpha() + " ");
        if (!this.isDirty) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancel() {
        ji().i2();
        fi(this, null, true, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(WinkEditorCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Si();
    }

    private final void di() {
        WinkEditorCropViewModel ji5 = ji();
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        List<MediaClip> R1 = ji5.R1(arrayList);
        boolean p16 = WinkHDRPicQualityDetectUtils.f320445a.p(R1);
        w53.b.a("wink_crop_WinkEditorCropFragment", "applyChangeAndNavBack isBlurAfterCrop " + p16);
        ei(R1, false, p16);
        Mi(R1);
    }

    private final void ei(List<? extends MediaClip> mediaClipsAfterCrop, boolean isCancel, boolean isBlurAfterCrop) {
        if (ji().getIsFromClipping()) {
            qi(isCancel);
            if (mediaClipsAfterCrop != null) {
                ji().s2(mediaClipsAfterCrop, Ci());
                return;
            }
            return;
        }
        if (mediaClipsAfterCrop != null) {
            ji().s2(mediaClipsAfterCrop, Ci());
        }
        ri(isCancel, isBlurAfterCrop);
    }

    static /* synthetic */ void fi(WinkEditorCropFragment winkEditorCropFragment, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        winkEditorCropFragment.ei(list, z16, z17);
    }

    private final Map<String, Object> hi(WinkEditorCropViewModel.CropInfo cropInfo, MediaClip mediaClip) {
        int i3;
        String str;
        com.tencent.videocut.model.RectF rectF;
        SizeF sizeF;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
        if (winkEditorCropRatioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
            winkEditorCropRatioView = null;
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PRODUCT_CUT_SIZE, winkEditorCropRatioView.c(cropInfo.getRatioType()));
        if (Math.abs(cropInfo.getRotateDegree()) >= 1.0f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_SLIDE_ROTATE, Integer.valueOf(i3));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_90DEGREE_ROTATE, Integer.valueOf(cropInfo.isRotate90() ? 1 : 0));
        if (Ci()) {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_CUT_FROMCLIP_FINISH;
        } else {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_CUT_FINISH;
        }
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_custom_pgid", getPageId());
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, ni());
        if (mediaClip != null) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_ORIGIN_WIDTH, Integer.valueOf((int) sizeF.width));
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_ORIGIN_HEIGHT, Integer.valueOf((int) sizeF.height));
            }
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null && (rectF = resourceModel2.picClipRect) != null) {
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_WIDTH, Integer.valueOf(Math.abs((int) (rectF.right - rectF.left))));
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_HEIGHT, Integer.valueOf(Math.abs((int) (rectF.bottom - rectF.top))));
            }
        }
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "buildElementParams().app\u2026}\n            }\n        }");
        return buildElementParams;
    }

    private final BroadcastReceiver ii() {
        return (BroadcastReceiver) this.cropBroadcastReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorCropViewModel ji() {
        return (WinkEditorCropViewModel) this.cropViewModel.getValue();
    }

    private final List<Pair<Matrix, RectF>> ki() {
        return (List) this.originMediaClipCropData.getValue();
    }

    private final QQCustomDialog li() {
        return (QQCustomDialog) this.quitDialog.getValue();
    }

    private final long mi() {
        return ((Number) this.selectIndex.getValue()).longValue();
    }

    private final String ni() {
        if (Di()) {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_PIC_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_VIDEO_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long oi() {
        return ((Number) this.startTimeOffset.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SimpleDateFormat pi() {
        return (SimpleDateFormat) this.timeFormat.getValue();
    }

    private final void qi(boolean isCancel) {
        requireArguments().putBoolean(QQWinkConstants.IS_FROM_CROP, !isCancel);
        requireArguments().putBoolean("key_is_changed_after_crop", ai());
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (!isCancel) {
            WinkEditorCropViewModel ji5 = ji();
            ArrayList<MediaClip> arrayList = this.mediaClips;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                arrayList = null;
            }
            requireArguments().putParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL, new ArrayList<>(ji5.R1(arrayList)));
            requireArguments().putLong(QQWinkConstants.CLIP_CURRENT_PLAY_TIME, gi(this.currentSelectClipIndex));
            ji().k2(true);
        } else {
            ji().k2(false);
        }
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment instanceof WinkEditorClippingFragment) {
            WinkEditorClippingFragment winkEditorClippingFragment = (WinkEditorClippingFragment) parentFragment;
            if (winkEditorClippingFragment.getArguments() == null) {
                winkEditorClippingFragment.setArguments(new Bundle());
            }
            Bundle arguments = winkEditorClippingFragment.getArguments();
            if (arguments != null) {
                arguments.putAll(getArguments());
            }
            getParentFragmentManager().popBackStack();
            if (parentFragment instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) parentFragment;
            }
            if (aVar != null) {
                aVar.g1(false);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void registerDaTongReportPageId(View contentView) {
        String tag;
        VideoReport.addToDetectionWhitelist(getActivity());
        if (!TextUtils.isEmpty(getPageId())) {
            tag = getPageId();
        } else {
            tag = getTAG();
        }
        VideoReport.setPageId(contentView, tag);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.ignorePageInOutEvent(contentView, true);
        QLog.i("wink_crop_WinkEditorCropFragment", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + tag);
    }

    private final void reset() {
        Object orNull;
        WinkHorizontalProgressWheelView winkHorizontalProgressWheelView = this.rotateWheelView;
        WinkEditorCropView winkEditorCropView = null;
        if (winkHorizontalProgressWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateWheelView");
            winkHorizontalProgressWheelView = null;
        }
        winkHorizontalProgressWheelView.c();
        TextView textView = this.rotateTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
            textView = null;
        }
        textView.setTextColor(-1);
        TextView textView2 = this.rotateTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateTextView");
            textView2 = null;
        }
        textView2.setText(R.string.f239297m3);
        WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
        if (winkEditorCropRatioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
            winkEditorCropRatioView = null;
        }
        winkEditorCropRatioView.j();
        WinkEditorCropView winkEditorCropView2 = this.cropView;
        if (winkEditorCropView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView2 = null;
        }
        winkEditorCropView2.getEditorGestureTextureView().t();
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null) {
            WinkEditorCropView winkEditorCropView3 = this.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView = winkEditorCropView3;
            }
            winkEditorCropView.getMaskView().setTargetAspectRatio(com.tencent.videocut.render.extension.e.o(mediaClip).width / com.tencent.videocut.render.extension.e.o(mediaClip).height, 1);
        }
        this.isDirty = false;
        this.initScale = 1.0f;
    }

    private final void ri(boolean isCancel, boolean isBlurAfterCrop) {
        requireArguments().putBoolean(QQWinkConstants.IS_FROM_CROP, true);
        requireArguments().putBoolean("key_is_blur_after_crop", isBlurAfterCrop);
        requireArguments().putBoolean("key_is_changed_after_crop", ai());
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (!isCancel) {
            WinkEditorCropViewModel ji5 = ji();
            ArrayList<MediaClip> arrayList = this.mediaClips;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                arrayList = null;
            }
            requireArguments().putParcelableArrayList(QQWinkConstants.CROP_RESOURCE_MODEL, new ArrayList<>(ji5.R1(arrayList)));
        }
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment instanceof WinkEditorFragment) {
            WinkEditorFragment winkEditorFragment = (WinkEditorFragment) parentFragment;
            if (winkEditorFragment.getArguments() == null) {
                winkEditorFragment.setArguments(new Bundle());
            }
            Bundle arguments = winkEditorFragment.getArguments();
            if (arguments != null) {
                arguments.putAll(getArguments());
            }
            getParentFragmentManager().popBackStack();
            if (parentFragment instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) parentFragment;
            }
            if (aVar != null) {
                aVar.g1(false);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void si() {
        Object orNull;
        WinkEditorCropView winkEditorCropView = this.cropView;
        WinkEditorCropView winkEditorCropView2 = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.setEnableAutoAdjust(false);
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView3 = null;
        }
        winkEditorCropView3.getEditorGestureTextureView().setSurfaceTextureListener(this.surfaceTextureListener);
        ArrayList<MediaClip> arrayList = this.mediaClips;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null) {
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            winkEditorCropView4.setResourceSize(com.tencent.videocut.render.extension.e.o(mediaClip).width, com.tencent.videocut.render.extension.e.o(mediaClip).height);
        }
        WinkEditorCropView winkEditorCropView5 = this.cropView;
        if (winkEditorCropView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
        } else {
            winkEditorCropView2 = winkEditorCropView5;
        }
        winkEditorCropView2.getEditorGestureTextureView().setTransformListener(new c());
    }

    private final void ti() {
        if (Ci()) {
            VideoReport.setElementId((ImageView) xh(R.id.xyk), WinkDaTongReportConstant.ElementId.EM_XSJ_CUT_FROMCLIP_FINISH);
            VideoReport.setElementClickPolicy((ImageView) xh(R.id.xyk), ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy((ImageView) xh(R.id.xyk), ExposurePolicy.REPORT_ALL);
        } else {
            VideoReport.setElementId((ImageView) xh(R.id.xyk), WinkDaTongReportConstant.ElementId.EM_XSJ_CUT_FINISH);
            VideoReport.setElementClickPolicy((ImageView) xh(R.id.xyk), ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy((ImageView) xh(R.id.xyk), ExposurePolicy.REPORT_NONE);
        }
        VideoReport.setElementId((ImageView) xh(R.id.xyi), WinkDaTongReportConstant.ElementId.EM_XSJ_VIDEO_CANCEL_BUTTON);
        ImageView imageView = (ImageView) xh(R.id.xyi);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView, clickPolicy);
        ImageView imageView2 = (ImageView) xh(R.id.xyi);
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(imageView2, exposurePolicy);
        RelativeLayout relativeLayout = this.rotateContainerLayout;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateContainerLayout");
            relativeLayout = null;
        }
        VideoReport.setElementId(relativeLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_ROTATE_BUTTON);
        RelativeLayout relativeLayout2 = this.rotateContainerLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateContainerLayout");
            relativeLayout2 = null;
        }
        VideoReport.setElementClickPolicy(relativeLayout2, clickPolicy);
        RelativeLayout relativeLayout3 = this.rotateContainerLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateContainerLayout");
            relativeLayout3 = null;
        }
        VideoReport.setElementExposePolicy(relativeLayout3, exposurePolicy);
        TextView textView2 = this.resetTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView2 = null;
        }
        VideoReport.setElementId(textView2, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_RESET);
        TextView textView3 = this.resetTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
            textView3 = null;
        }
        VideoReport.setElementClickPolicy(textView3, clickPolicy);
        TextView textView4 = this.resetTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
        } else {
            textView = textView4;
        }
        VideoReport.setElementExposePolicy(textView, exposurePolicy);
    }

    private final void ui(boolean isInitMediaModel) {
        Object orNull;
        Object orNull2;
        WinkEditorCropView winkEditorCropView = null;
        if (isInitMediaModel) {
            WinkEditorCropViewModel ji5 = ji();
            ArrayList<MediaClip> arrayList = this.mediaClips;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                arrayList = null;
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList, this.currentSelectClipIndex);
            ji5.W1((MediaClip) orNull2, true);
        }
        dr drVar = this.tavCutManager;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
            drVar = null;
        }
        WinkEditorCropView winkEditorCropView2 = this.cropView;
        if (winkEditorCropView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView2 = null;
        }
        int width = winkEditorCropView2.getEditorGestureTextureView().getWidth();
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView3 = null;
        }
        drVar.P(width, winkEditorCropView3.getEditorGestureTextureView().getHeight());
        WinkEditorCropView winkEditorCropView4 = this.cropView;
        if (winkEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView4 = null;
        }
        winkEditorCropView4.setEnableAutoAdjust(true);
        WinkEditorCropViewModel ji6 = ji();
        boolean Di = Di();
        ArrayList<MediaClip> arrayList2 = this.mediaClips;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList2 = null;
        }
        ji6.h2(Di, arrayList2);
        ji().d2();
        Yh();
        WinkEditorCropView winkEditorCropView5 = this.cropView;
        if (winkEditorCropView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView5 = null;
        }
        this.initScale = winkEditorCropView5.getEditorGestureTextureView().e();
        if (ji().getIsFromClipping()) {
            ArrayList<MediaClip> arrayList3 = this.mediaClips;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                arrayList3 = null;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList3, this.currentSelectClipIndex);
            MediaClip mediaClip = (MediaClip) orNull;
            if (mediaClip != null) {
                WinkEditorCropViewModel ji7 = ji();
                WinkEditorCropView winkEditorCropView6 = this.cropView;
                if (winkEditorCropView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                    winkEditorCropView6 = null;
                }
                float a16 = winkEditorCropView6.getEditorGestureTextureView().a();
                WinkEditorCropView winkEditorCropView7 = this.cropView;
                if (winkEditorCropView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropView");
                } else {
                    winkEditorCropView = winkEditorCropView7;
                }
                ji7.q2(mediaClip, a16, winkEditorCropView.e());
                ji().e2();
            }
        }
    }

    static /* synthetic */ void vi(WinkEditorCropFragment winkEditorCropFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        winkEditorCropFragment.ui(z16);
    }

    private final void wi() {
        WinkEditorCropRatioView winkEditorCropRatioView = this.cropRatioView;
        if (winkEditorCropRatioView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropRatioView");
            winkEditorCropRatioView = null;
        }
        winkEditorCropRatioView.setListener(new d());
        Pi(this, WinkEditorCropRatioView.RatioType.FreeRatio, false, 2, null);
    }

    private final void xi() {
        WinkHorizontalProgressWheelView winkHorizontalProgressWheelView = this.rotateWheelView;
        if (winkHorizontalProgressWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateWheelView");
            winkHorizontalProgressWheelView = null;
        }
        winkHorizontalProgressWheelView.setScrollListener(new e());
    }

    private final void yi() {
        if (Di()) {
            ((SeekBar) xh(R.id.f81814f7)).setVisibility(8);
            TextView textView = this.tvPastTime;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.tvTotalTime;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        ((SeekBar) xh(R.id.f81814f7)).setOnSeekBarChangeListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi(Surface playerSurface) {
        dr winkVideoTavCut;
        int i3 = 1;
        dr drVar = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        if (Di()) {
            winkVideoTavCut = new WinkImageTavCut(b19 == true ? 1 : 0, i3, b18 == true ? 1 : 0);
            WinkEditorCropFragment winkEditorCropFragment = this.baseFragment;
            WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Image;
            List<WinkEditData> Zh = Zh();
            Boolean bool = Boolean.FALSE;
            WinkEditorCropView winkEditorCropView = this.cropView;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            int width = winkEditorCropView.getEditorGestureTextureView().getWidth();
            WinkEditorCropView winkEditorCropView2 = this.cropView;
            if (winkEditorCropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView2 = null;
            }
            dr.b.f(winkVideoTavCut, winkEditorCropFragment, new dr.WinkTavCutParams(false, editMode, Zh, null, bool, width, winkEditorCropView2.getEditorGestureTextureView().getHeight(), playerSurface, null, false, 0, Long.MAX_VALUE, false, false, null, WinkTavCutScene.Crop, false, false, 0, 0, false, null, 4159240, null), null, 4, null);
        } else {
            winkVideoTavCut = new WinkVideoTavCut(b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
            WinkEditorCropFragment winkEditorCropFragment2 = this.baseFragment;
            WinkEditorViewModel.EditMode editMode2 = WinkEditorViewModel.EditMode.Video;
            List<WinkEditData> Zh2 = Zh();
            Boolean bool2 = Boolean.FALSE;
            WinkEditorCropView winkEditorCropView3 = this.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView3 = null;
            }
            int width2 = winkEditorCropView3.getEditorGestureTextureView().getWidth();
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            int height = winkEditorCropView4.getEditorGestureTextureView().getHeight();
            Boolean isOpenFFmpegDecode = u53.i.f438428a;
            Intrinsics.checkNotNullExpressionValue(isOpenFFmpegDecode, "isOpenFFmpegDecode");
            boolean booleanValue = isOpenFFmpegDecode.booleanValue();
            Integer softDecodeThreadCnt = u53.i.f438429b;
            Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
            dr.b.f(winkVideoTavCut, winkEditorCropFragment2, new dr.WinkTavCutParams(false, editMode2, Zh2, null, bool2, width2, height, playerSurface, null, booleanValue, softDecodeThreadCnt.intValue(), Long.MAX_VALUE, false, false, null, WinkTavCutScene.Crop, false, false, 0, 0, false, null, 4157704, null), null, 4, null);
        }
        this.tavCutManager = winkVideoTavCut;
        winkVideoTavCut.setAutoPlay(false);
        dr drVar2 = this.tavCutManager;
        if (drVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
            drVar2 = null;
        }
        drVar2.addPlayerListener(this.playerListener);
        WinkEditorCropViewModel ji5 = ji();
        dr drVar3 = this.tavCutManager;
        if (drVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
        } else {
            drVar = drVar3;
        }
        ji5.U1(drVar);
    }

    public void _$_clearFindViewByIdCache() {
        this.f319732l0.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WinkEditorCropMenuPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168931hd2;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "wink_crop_WinkEditorCropFragment";
    }

    @NotNull
    public final String getPageId() {
        if (Di()) {
            return WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE;
        }
        return WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public final long gi(int index) {
        int coerceIn;
        Iterable<IndexedValue> withIndex;
        long j3;
        ArrayList<MediaClip> arrayList = this.mediaClips;
        ArrayList<MediaClip> arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            arrayList = null;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(index, 0, arrayList.size());
        ArrayList<MediaClip> arrayList3 = this.mediaClips;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
        } else {
            arrayList2 = arrayList3;
        }
        withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList2);
        long j16 = 0;
        for (IndexedValue indexedValue : withIndex) {
            if (indexedValue.getIndex() < coerceIn) {
                ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
                if (resourceModel != null) {
                    j3 = resourceModel.scaleDuration;
                } else {
                    j3 = 0;
                }
                j16 += j3;
            }
        }
        return j16;
    }

    public final boolean handleBackEvent() {
        ((ImageView) xh(R.id.xyi)).performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView != null) {
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            winkEditorCropView.getEditorGestureTextureView().setTransformListener(null);
        }
        super.onDestroyView();
        ji().m2(false);
        if (!Ci()) {
            ji().M1();
        }
        dr drVar = this.tavCutManager;
        if (drVar != null) {
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                drVar = null;
            }
            drVar.release();
        }
        com.tencent.mobileqq.wink.editor.crop.b bVar = this.videoListViewAdapter;
        if (bVar != null) {
            bVar.f();
        }
        HorizontalListView horizontalListView = this.videoListView;
        if (horizontalListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoListView");
            horizontalListView = null;
        }
        horizontalListView.setAdapter((ListAdapter) null);
        HorizontalListView horizontalListView2 = this.videoListView;
        if (horizontalListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoListView");
            horizontalListView2 = null;
        }
        horizontalListView2.setOnItemClickListener(null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(ii());
        }
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onResumeReport();
        Ni();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ArrayList<MediaClip> arrayList;
        ConstraintLayout.LayoutParams layoutParams;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        View findViewById = view.findViewById(R.id.f122627eg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.wink_editor_crop_view)");
        this.cropView = (WinkEditorCropView) findViewById;
        View findViewById2 = view.findViewById(R.id.f122567ea);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.wink_crop_rotate_text)");
        this.rotateTextView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f122577eb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.w\u2026k_crop_rotate_wheel_view)");
        this.rotateWheelView = (WinkHorizontalProgressWheelView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f122547e9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.wink_crop_ratio_view)");
        this.cropRatioView = (WinkEditorCropRatioView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f122557e_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.wink_crop_reset_text)");
        this.resetTextView = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f124727k5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.w\u2026eo_crop_rotate_container)");
        this.rotateContainerLayout = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.f11764720);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.video_horizontal_listview)");
        this.videoListView = (HorizontalListView) findViewById7;
        Bundle arguments = getArguments();
        TextView textView = null;
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList("key_media_clip");
        } else {
            arrayList = null;
        }
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.videocut.model.MediaClip>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.videocut.model.MediaClip> }");
        this.mediaClips = arrayList;
        this.tvTotalTime = (TextView) view.findViewById(R.id.f124717k4);
        this.tvPastTime = (TextView) view.findViewById(R.id.f124707k3);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        int a16 = eVar.a(16.0f);
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.setResPaddingTop(a16);
        TextView textView2 = (TextView) xh(R.id.f1055466a);
        ViewGroup.LayoutParams layoutParams2 = ((TextView) xh(R.id.f1055466a)).getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a16 + eVar.a(12.0f);
        } else {
            layoutParams = null;
        }
        textView2.setLayoutParams(layoutParams);
        this.resetFadeInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
        this.resetFadeOutAnimation = loadAnimation;
        if (loadAnimation != null) {
            loadAnimation.setAnimationListener(new g());
        }
        this.currentSelectClipIndex = (int) mi();
        si();
        xi();
        wi();
        yi();
        initViewModel();
        Ai();
        ti();
        RelativeLayout relativeLayout = this.rotateContainerLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateContainerLayout");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorCropFragment.Gi(WinkEditorCropFragment.this, view2);
            }
        });
        TextView textView3 = this.resetTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetTextView");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorCropFragment.Hi(WinkEditorCropFragment.this, view2);
            }
        });
        ((ImageView) xh(R.id.xyk)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorCropFragment.Ii(WinkEditorCropFragment.this, view2);
            }
        });
        ((ImageView) xh(R.id.xyi)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorCropFragment.Ji(WinkEditorCropFragment.this, view2);
            }
        });
        this.isScaleTipsVisible = ji().a2();
        TextView textView4 = (TextView) xh(R.id.f1055466a);
        if (this.isScaleTipsVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView4.setVisibility(i3);
        ji().o2(false);
        ji().m2(true);
        Li();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }

    @Nullable
    public View xh(int i3) {
        View findViewById;
        Map<Integer, View> map = this.f319732l0;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    private final void initViewModel() {
    }
}
