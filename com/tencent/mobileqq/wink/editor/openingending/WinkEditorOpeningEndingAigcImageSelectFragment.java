package com.tencent.mobileqq.wink.editor.openingending;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import c63.WinkTimelineSeekPlayerTimeData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment;
import com.tencent.mobileqq.wink.editor.openingending.a;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import cooperation.qzone.QzoneIPCModule;
import g63.CommonConfig;
import g63.LayoutConfig;
import g63.VideoTrackConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00c5\u00012\u00020\u00012\u00020\u0002:\u0002\u00c6\u0001B\t\u00a2\u0006\u0006\b\u00c2\u0001\u0010\u00c3\u0001BM\b\u0016\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?\u0012\u0006\u0010F\u001a\u00020@\u0012\b\b\u0002\u0010I\u001a\u00020+\u0012\b\b\u0002\u0010K\u001a\u00020+\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010P\u00a2\u0006\u0006\b\u00c2\u0001\u0010\u00c4\u0001J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0003H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020\u000bH\u0002J\u0016\u0010:\u001a\u00020\u000b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b08H\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010<\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u000bH\u0002J\u001c\u0010>\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u00100\u001a\u0004\u0018\u00010/H\u0002R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001b\u0010[\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010U\u001a\u0004\bZ\u0010WR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010U\u001a\u0004\b^\u0010_R\u001b\u0010c\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010U\u001a\u0004\bb\u0010_R\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010U\u001a\u0004\bf\u0010gR\u001b\u0010k\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010U\u001a\u0004\bj\u0010gR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010U\u001a\u0004\bn\u0010oR\u001b\u0010s\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010U\u001a\u0004\br\u0010WR\u001b\u0010v\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010U\u001a\u0004\bu\u0010oR\u001b\u0010y\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010U\u001a\u0004\bx\u0010WR\u001b\u0010|\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010U\u001a\u0004\b{\u0010WR\u001b\u0010\u007f\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010U\u001a\u0004\b~\u0010WR\u001e\u0010\u0082\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010U\u001a\u0005\b\u0081\u0001\u0010WR \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0084\u0001\u0010U\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001e\u0010\u008a\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0088\u0001\u0010U\u001a\u0005\b\u0089\u0001\u0010WR\u001e\u0010\u008d\u0001\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008b\u0001\u0010U\u001a\u0005\b\u008c\u0001\u0010gR\u001f\u0010\u0091\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\bH\u0010U\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u0098\u0001R\u0018\u0010\u009d\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010HR\u001c\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R \u0010\u00a6\u0001\u001a\u00030\u00a2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a3\u0001\u0010U\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001R \u0010\u00ab\u0001\u001a\u00030\u00a7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a8\u0001\u0010U\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R \u0010\u00b0\u0001\u001a\u00030\u00ac\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ad\u0001\u0010U\u001a\u0006\b\u00ae\u0001\u0010\u00af\u0001R \u0010\u00b5\u0001\u001a\u00030\u00b1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b2\u0001\u0010U\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u0018\u0010\u00b7\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b6\u0001\u0010HR\u0018\u0010\u00b9\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b8\u0001\u0010HR\u0018\u0010\u00bd\u0001\u001a\u00030\u00ba\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u0018\u0010\u00c1\u0001\u001a\u00030\u00be\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u00a8\u0006\u00c7\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcImageSelectFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/h;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "event", "", "Jc", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onDestroyView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "dismiss", "initView", "bj", "Ri", "Si", "Ii", "Ti", "Mi", "Li", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "ai", WidgetCacheLunarData.JI, "Ji", "Lcom/tencent/mobileqq/wink/editor/openingending/a$a;", "Fi", "", "bi", "ej", "Hi", "", "errMsg", "fj", "showLoadingDialog", "ei", "kj", "lj", "Zi", "jj", "Lkotlin/Function0;", "action", "gi", "registerDaTongReportPageId", "Ki", "dj", "cj", "", "Lcom/tencent/videocut/model/MediaClip;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mediaClips", "D", "Lcom/tencent/videocut/model/MediaClip;", "appliedTemplateClip", "E", "Z", "isFromClipping", UserInfo.SEX_FEMALE, "isFromTemplatePage", "Lcom/tencent/videocut/model/BackgroundModel;", "G", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "H", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "recoveredAigcData", "I", "Lkotlin/Lazy;", "ki", "()Landroid/view/View;", "backBtn", "J", "ti", "nextBtn", "Landroid/widget/FrameLayout;", "K", "zi", "()Landroid/widget/FrameLayout;", "videoPreviewContainer", "L", WidgetCacheLunarData.YI, "videoPreview", "Landroid/widget/ImageView;", "M", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Landroid/widget/ImageView;", "recoverImageView", "N", "ni", "imagePreview", "Landroid/widget/TextView;", "P", "Ci", "()Landroid/widget/TextView;", "videoTabText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Bi", "videoTabLine", BdhLogUtil.LogTag.Tag_Req, "si", "imageTabText", ExifInterface.LATITUDE_SOUTH, "ri", "imageTabLine", "T", "Ai", "videoTabContainer", "U", "qi", "imageTabContainer", "V", "mi", "imageAddContainer", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "W", "vi", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "timelinePanel", "X", "pi", "imagePreviewThumbnailContainer", "Y", "oi", "imagePreviewThumbnail", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "Ei", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/view/ai;", "a0", "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "b0", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedAlbumImage", "c0", "extractedVideoFrame", "d0", "needDismiss", "Lkotlinx/coroutines/Job;", "e0", "Lkotlinx/coroutines/Job;", "uiEventJob", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "f0", "wi", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "timelinePanelController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "g0", "Di", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "videoTrackController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "h0", "li", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/d;", "dragDropViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "i0", "xi", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "j0", "isVideoTab", "k0", "isRecoveredDataChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "l0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "m0", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "<init>", "()V", "(Ljava/util/List;Lcom/tencent/videocut/model/MediaClip;ZZLcom/tencent/videocut/model/BackgroundModel;Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;)V", "o0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingAigcImageSelectFragment extends ImmersivePartFragment implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<? extends MediaClip> mediaClips;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MediaClip appliedTemplateClip;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFromClipping;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFromTemplatePage;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BackgroundModel backgroundModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private OpeningEndingAigcData recoveredAigcData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy backBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextBtn;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoPreviewContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoPreview;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy recoverImageView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy imagePreview;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoTabText;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoTabLine;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageTabText;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageTabLine;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoTabContainer;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageTabContainer;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageAddContainer;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelinePanel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy imagePreviewThumbnailContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy imagePreviewThumbnail;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.view.ai loadingDialog;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo selectedAlbumImage;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo extractedVideoFrame;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean needDismiss;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job uiEventJob;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy timelinePanelController;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoTrackController;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dragDropViewController;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoTab;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean isRecoveredDataChanged;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener;

    /* renamed from: n0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f321326n0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcImageSelectFragment$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WinkEditorOpeningEndingAigcImageSelectFragment.this.yi().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, WinkEditorViewModel.EditMode.Video, WinkEditorOpeningEndingAigcImageSelectFragment.this.ai(), null, Boolean.FALSE, WinkEditorOpeningEndingAigcImageSelectFragment.this.yi().getWidth(), WinkEditorOpeningEndingAigcImageSelectFragment.this.yi().getHeight(), null, null, false, 0, Long.MAX_VALUE, false, false, null, WinkTavCutScene.OPENING_ENDING_IMAGE_SELECT, false, false, 0, 0, false, null, 4159368, null);
            TimelineViewModelV2 xi5 = WinkEditorOpeningEndingAigcImageSelectFragment.this.xi();
            WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment = WinkEditorOpeningEndingAigcImageSelectFragment.this;
            TimelineViewModelV2.S2(xi5, winkEditorOpeningEndingAigcImageSelectFragment, winkEditorOpeningEndingAigcImageSelectFragment.yi(), winkTavCutParams, WinkEditorOpeningEndingAigcImageSelectFragment.this.playerListener, WinkEditorOpeningEndingAigcImageSelectFragment.this.renderListener, false, false, true, 0L, null, 864, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcImageSelectFragment$c", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IPlayer.PlayerListener {
        c() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            IPlayer.PlayerListener.DefaultImpls.onPositionChanged(this, j3, j16);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            WinkEditorOpeningEndingAigcImageSelectFragment.this.xi().b3();
        }
    }

    public WinkEditorOpeningEndingAigcImageSelectFragment() {
        List<? extends MediaClip> emptyList;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        Lazy lazy17;
        Lazy lazy18;
        Lazy lazy19;
        Lazy lazy20;
        Lazy lazy21;
        this.f321326n0 = new LinkedHashMap();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mediaClips = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$backBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.t2c);
            }
        });
        this.backBtn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$nextBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.zqm);
            }
        });
        this.nextBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoPreviewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f1171270l);
            }
        });
        this.videoPreviewContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoPreview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f1171170k);
            }
        });
        this.videoPreview = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$recoverImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f71733oy);
            }
        });
        this.recoverImageView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imagePreview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.xhv);
            }
        });
        this.imagePreview = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoTabText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f1171870r);
            }
        });
        this.videoTabText = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoTabLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f1171770q);
            }
        });
        this.videoTabLine = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imageTabText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f165754xi1);
            }
        });
        this.imageTabText = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imageTabLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f165753xi0);
            }
        });
        this.imageTabLine = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoTabContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f1171670p);
            }
        });
        this.videoTabContainer = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imageTabContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.xhz);
            }
        });
        this.imageTabContainer = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imageAddContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.xhk);
            }
        });
        this.imageAddContainer = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<TimelinePanel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$timelinePanel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TimelinePanel invoke() {
                return (TimelinePanel) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.f97405ka);
            }
        });
        this.timelinePanel = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imagePreviewThumbnailContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.xhx);
            }
        });
        this.imagePreviewThumbnailContainer = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$imagePreviewThumbnail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) WinkEditorOpeningEndingAigcImageSelectFragment.this.requireView().findViewById(R.id.xhw);
            }
        });
        this.imagePreviewThumbnail = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                FragmentActivity activity = WinkEditorOpeningEndingAigcImageSelectFragment.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                ViewModel viewModel = new ViewModelProvider(activity).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider((activ\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.viewModel = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<TimelinePanelViewController>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$timelinePanelController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelinePanelViewController invoke() {
                TimelinePanelViewController timelinePanelViewController = new TimelinePanelViewController();
                timelinePanelViewController.x(true);
                return timelinePanelViewController;
            }
        });
        this.timelinePanelController = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$videoTrackController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l invoke() {
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
            }
        });
        this.videoTrackController = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$dragDropViewController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d invoke() {
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d();
            }
        });
        this.dragDropViewController = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelineViewModelV2 invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorOpeningEndingAigcImageSelectFragment.this).get(TimelineViewModelV2.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026eViewModelV2::class.java)");
                return (TimelineViewModelV2) viewModel;
            }
        });
        this.timelineViewModel = lazy21;
        this.isVideoTab = true;
        this.playerListener = new c();
        this.renderListener = new d();
    }

    private final View Ai() {
        Object value = this.videoTabContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoTabContainer>(...)");
        return (View) value;
    }

    private final View Bi() {
        Object value = this.videoTabLine.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoTabLine>(...)");
        return (View) value;
    }

    private final TextView Ci() {
        Object value = this.videoTabText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoTabText>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l Di() {
        return (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l) this.videoTrackController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorOpeningEndingViewModel Ei() {
        return (WinkEditorOpeningEndingViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fi(a.AigcTemplateGenerateResult event) {
        ei();
        if (!event.getFinished()) {
            return;
        }
        if (event.getSuccess()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.t
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingAigcImageSelectFragment.Gi(WinkEditorOpeningEndingAigcImageSelectFragment.this);
                }
            });
        } else {
            fj(event.getErrMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void Hi() {
        LocalMediaInfo localMediaInfo;
        String str;
        long j3;
        String str2;
        dj();
        if (ej()) {
            localMediaInfo = this.extractedVideoFrame;
        } else {
            showLoadingDialog();
            localMediaInfo = this.selectedAlbumImage;
        }
        if (localMediaInfo == null) {
            String string = requireContext().getString(R.string.ymn);
            Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026tor_waiting_image2_error)");
            fj(string);
            ei();
            return;
        }
        LocalMediaInfo localMediaInfo2 = this.extractedVideoFrame;
        String str3 = null;
        if (localMediaInfo2 != null) {
            str = localMediaInfo2.path;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (ej()) {
            j3 = xi().getCurSeekTimeUs();
        } else {
            j3 = 0;
        }
        LocalMediaInfo localMediaInfo3 = this.selectedAlbumImage;
        if (localMediaInfo3 != null) {
            str3 = localMediaInfo3.path;
        }
        if (str3 == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        OpeningEndingAigcData openingEndingAigcData = new OpeningEndingAigcData(str, j3, str2, null, ej(), null, null, 0, null, null, 1000, null);
        OpeningEndingAigcData openingEndingAigcData2 = this.recoveredAigcData;
        if (openingEndingAigcData2 != null) {
            Intrinsics.checkNotNull(openingEndingAigcData2);
            openingEndingAigcData.setTemplateMaterial(openingEndingAigcData2.getTemplateMaterial());
            OpeningEndingAigcData openingEndingAigcData3 = this.recoveredAigcData;
            Intrinsics.checkNotNull(openingEndingAigcData3);
            openingEndingAigcData.setStyleMaterials(openingEndingAigcData3.getStyleMaterials());
        } else {
            openingEndingAigcData.setTemplateMaterial(Ei().w2());
            List<MetaMaterial> m26 = Ei().m2();
            if (m26 != null) {
                openingEndingAigcData.setStyleMaterials(new ArrayList<>(m26));
            }
        }
        Ei().z2(new WeakReference<>(getActivity()), openingEndingAigcData, this.isFromClipping);
    }

    private final void Ii() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DragDropScrollView dragDropScrollView = new DragDropScrollView(requireContext, null, 0, 6, null);
        dragDropScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        li().g(dragDropScrollView);
    }

    private final void Ji() {
        Job launch$default;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1(this, null), 3, null);
        this.uiEventJob = launch$default;
    }

    private final void Ki() {
        VideoReport.setElementId((TextView) Ih(R.id.zqm), WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
        VideoReport.setElementParams((TextView) Ih(R.id.zqm), WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementEndExposePolicy((TextView) Ih(R.id.zqm), EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy((TextView) Ih(R.id.zqm), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy((TextView) Ih(R.id.zqm), ExposurePolicy.REPORT_ALL);
    }

    private final void Li() {
        yi().getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    private final void Mi() {
        wi().h(Di());
        wi().h(li());
        MutableLiveData<Long> A2 = xi().A2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initTimelineController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                TimelinePanelViewController wi5;
                wi5 = WinkEditorOpeningEndingAigcImageSelectFragment.this.wi();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                wi5.C(it.longValue());
            }
        };
        A2.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Ni(Function1.this, obj);
            }
        });
        MutableLiveData<VideoTrackData> B2 = xi().B2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<VideoTrackData, Unit> function12 = new Function1<VideoTrackData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initTimelineController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VideoTrackData videoTrackData) {
                invoke2(videoTrackData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoTrackData videoTrackData) {
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l Di;
                Di = WinkEditorOpeningEndingAigcImageSelectFragment.this.Di();
                Di.K(videoTrackData.d(), videoTrackData.c());
            }
        };
        B2.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Oi(Function1.this, obj);
            }
        });
        MutableLiveData<Long> m26 = xi().m2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Long, Unit> function13 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initTimelineController$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                TimelinePanelViewController wi5;
                wi5 = WinkEditorOpeningEndingAigcImageSelectFragment.this.wi();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                wi5.z(it.longValue());
            }
        };
        m26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Pi(Function1.this, obj);
            }
        });
        MutableLiveData<WinkTimelineSeekPlayerTimeData> w26 = xi().w2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<WinkTimelineSeekPlayerTimeData, Unit> function14 = new Function1<WinkTimelineSeekPlayerTimeData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initTimelineController$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkTimelineSeekPlayerTimeData winkTimelineSeekPlayerTimeData) {
                invoke2(winkTimelineSeekPlayerTimeData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WinkTimelineSeekPlayerTimeData winkTimelineSeekPlayerTimeData) {
                TimelinePanelViewController wi5;
                wi5 = WinkEditorOpeningEndingAigcImageSelectFragment.this.wi();
                wi5.z(winkTimelineSeekPlayerTimeData.c());
            }
        };
        w26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Qi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ri() {
        Mi();
        Si();
        Ti();
        Ii();
    }

    private final void Si() {
        wi().j(vi());
        vi().getLayoutParams().height = com.tencent.videocut.utils.e.f384236a.a(68.0f);
        wi().w(new CommonConfig(null, new LayoutConfig(0, 0.0f, 0.0f, 0.0f, 0.0f, requireContext().getColor(R.color.b9n), 31, null), new VideoTrackConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 311, null), null, 9, null));
        wi().r();
        wi().getPanelEventHandler().b(this, new Function1<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initTimelineView$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g panelEvent) {
                Intrinsics.checkNotNullParameter(panelEvent, "panelEvent");
                return Boolean.valueOf((panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.f) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d));
            }
        });
    }

    private final void Ti() {
        final Context requireContext = requireContext();
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(requireContext) { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initVideoTrack$videoTrack$1

            /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
            private boolean isMoving;

            /* renamed from: t0, reason: collision with root package name */
            @NotNull
            public Map<Integer, View> f321332t0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(requireContext, null, 0, 0, 14, null);
                this.f321332t0 = new LinkedHashMap();
                this.f321332t0 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            }

            @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView, android.widget.HorizontalScrollView, android.view.View
            public boolean onTouchEvent(@NotNull MotionEvent ev5) {
                boolean z16;
                Intrinsics.checkNotNullParameter(ev5, "ev");
                if (WinkEditorOpeningEndingAigcImageSelectFragment.this.recoveredAigcData != null) {
                    z16 = WinkEditorOpeningEndingAigcImageSelectFragment.this.isRecoveredDataChanged;
                    if (!z16) {
                        if (ev5.getAction() == 2 && !this.isMoving) {
                            final WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment = WinkEditorOpeningEndingAigcImageSelectFragment.this;
                            winkEditorOpeningEndingAigcImageSelectFragment.gi(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initVideoTrack$videoTrack$1$onTouchEvent$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    FrameLayout zi5;
                                    zi5 = WinkEditorOpeningEndingAigcImageSelectFragment.this.zi();
                                    zi5.setVisibility(0);
                                }
                            });
                            this.isMoving = true;
                            return true;
                        }
                        if (ev5.getAction() != 1) {
                            return true;
                        }
                        this.isMoving = false;
                        return true;
                    }
                }
                return super.onTouchEvent(ev5);
            }

            public final void setMoving(boolean z16) {
                this.isMoving = z16;
            }
        };
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(56.0f));
        layoutParams.topMargin = eVar.a(6.0f);
        layoutParams.bottomMargin = eVar.a(6.0f);
        videoTrackContainerView.setLayoutParams(layoutParams);
        Di().x(videoTrackContainerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(WinkEditorOpeningEndingAigcImageSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(final WinkEditorOpeningEndingAigcImageSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gi(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorOpeningEndingAigcImageSelectFragment.this.kj();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(final WinkEditorOpeningEndingAigcImageSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gi(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initView$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorOpeningEndingAigcImageSelectFragment.this.lj();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(final WinkEditorOpeningEndingAigcImageSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gi(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initView$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorOpeningEndingAigcImageSelectFragment.this.Zi();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(WinkEditorOpeningEndingAigcImageSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this$0.getContext(), this$0.requireContext().getString(R.string.f215145ut), 0).show();
        } else if (this$0.recoveredAigcData != null && !this$0.isRecoveredDataChanged) {
            this$0.Ei().E2(this$0.getActivity(), this$0.appliedTemplateClip, this$0.isFromClipping);
        } else if (!this$0.bi()) {
            this$0.Hi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zi() {
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.j(1);
        aVar.l(false);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        com.tencent.mobileqq.wink.picker.g gVar = com.tencent.mobileqq.wink.picker.g.f324860a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        gVar.h(requireContext, 1001, WinkContext.INSTANCE.d().getTraceId(), aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WinkEditData> ai() {
        List<WinkEditData> mutableListOf;
        BackgroundModel backgroundModel;
        List<MediaClip> w3 = com.tencent.videocut.render.extension.e.w(this.mediaClips);
        MediaModel c16 = com.tencent.videocut.render.repository.a.f384196a.c(w3);
        if (w3.size() > 1 && (backgroundModel = this.backgroundModel) != null) {
            c16 = c16.copy((r39 & 1) != 0 ? c16.id : null, (r39 & 2) != 0 ? c16.name : null, (r39 & 4) != 0 ? c16.version : null, (r39 & 8) != 0 ? c16.createTime : null, (r39 & 16) != 0 ? c16.updateTime : null, (r39 & 32) != 0 ? c16.duration : null, (r39 & 64) != 0 ? c16.videos : null, (r39 & 128) != 0 ? c16.audios : null, (r39 & 256) != 0 ? c16.stickers : null, (r39 & 512) != 0 ? c16.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? c16.filterModels : null, (r39 & 2048) != 0 ? c16.specialEffects : null, (r39 & 4096) != 0 ? c16.transitions : null, (r39 & 8192) != 0 ? c16.templateModel : null, (r39 & 16384) != 0 ? c16.coverInfo : null, (r39 & 32768) != 0 ? c16.exportSetting : null, (r39 & 65536) != 0 ? c16.openHDR : null, (r39 & 131072) != 0 ? c16.hdrModels : null, (r39 & 262144) != 0 ? c16.smoothModels : null, (r39 & 524288) != 0 ? c16.openSuperHDR : null, (r39 & 1048576) != 0 ? c16.unknownFields() : null);
        }
        MediaModel mediaModel = c16;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkEditData(mediaModel, com.tencent.mobileqq.wink.editor.model.a.r(mediaModel), null, null, null, null, false, null, null, null, null, null, false, null, null, null, false, null, 262140, null));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        this$0.needDismiss = false;
    }

    private final boolean bi() {
        if (!ej()) {
            return false;
        }
        showLoadingDialog();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcImageSelectFragment.ci(WinkEditorOpeningEndingAigcImageSelectFragment.this);
            }
        }, 64, null, true);
        return true;
    }

    private final void bj() {
        List<String> mutableListOf;
        Object firstOrNull;
        OpeningEndingAigcData openingEndingAigcData = this.recoveredAigcData;
        if (openingEndingAigcData != null) {
            this.isVideoTab = openingEndingAigcData.getUseVideoFrame();
            com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(openingEndingAigcData.getSelectedAlbumImagePath());
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) oVar.i(mutableListOf));
            this.selectedAlbumImage = (LocalMediaInfo) firstOrNull;
            if (this.isVideoTab) {
                lj();
                zi().setVisibility(8);
                ui().setVisibility(0);
                try {
                    ui().setImageURI(Uri.fromFile(new File(openingEndingAigcData.getExtractedVideoFramePath())));
                } catch (Exception unused) {
                    w53.b.c("WinkEditorOpeningEndingAigcImageSelectFragment", "setImageURI failed: " + openingEndingAigcData.getExtractedVideoFramePath());
                }
            } else {
                kj();
            }
            jj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(final WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ji();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.l
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcImageSelectFragment.di(WinkEditorOpeningEndingAigcImageSelectFragment.this);
            }
        });
    }

    private final void cj(View view, String errMsg) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_AIGC_ERROR_POPUP);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ERROR_REASON, errMsg);
        reportMap.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AIGC_ERROR_POPUP);
        reportMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_AIGC_CHOOSE_PIC_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hi();
    }

    private final void dj() {
        TextView si5;
        VideoReport.setElementId((TextView) Ih(R.id.zqm), WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        if (ej()) {
            si5 = Ci();
        } else {
            si5 = si();
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AIGC_CHOOSE_PIC_TAB, si5.getText());
        VideoReport.reportEvent("dt_clck", (TextView) Ih(R.id.zqm), reportMap);
    }

    private final void ei() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.u
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcImageSelectFragment.fi(WinkEditorOpeningEndingAigcImageSelectFragment.this);
            }
        });
    }

    private final boolean ej() {
        if (!this.isVideoTab && this.selectedAlbumImage != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.view.ai aiVar = this$0.loadingDialog;
        if (aiVar != null) {
            aiVar.dismiss();
        }
        this$0.loadingDialog = null;
    }

    private final void fj(final String errMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.e
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcImageSelectFragment.gj(errMsg, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(final Function0<Unit> action) {
        if (this.recoveredAigcData != null && !this.isRecoveredDataChanged) {
            try {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
                createCustomDialog.setMessage(R.string.f215795wk);
                createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.q
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        WinkEditorOpeningEndingAigcImageSelectFragment.hi(Function0.this, this, dialogInterface, i3);
                    }
                });
                createCustomDialog.setNegativeButton(R.string.f239057lf, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        WinkEditorOpeningEndingAigcImageSelectFragment.ii(dialogInterface, i3);
                    }
                });
                createCustomDialog.show();
                return;
            } catch (Exception e16) {
                w53.b.c("WinkEditorOpeningEndingAigcImageSelectFragment", "showConfirmDialog failed: " + e16);
                return;
            }
        }
        action.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gj(String errMsg, WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (errMsg.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Context context = this$0.getContext();
            if (context != null) {
                errMsg = context.getString(R.string.f215145ut);
            } else {
                errMsg = null;
            }
        }
        this$0.cj(QQToast.makeText(this$0.getContext(), errMsg, 0).show().getView(), errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Function0 action, WinkEditorOpeningEndingAigcImageSelectFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        action.invoke();
        this$0.ui().setVisibility(8);
        this$0.isRecoveredDataChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ei().a2();
        this$0.ei();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean ij(WinkEditorOpeningEndingAigcImageSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ei().a2();
        this$0.ei();
        return Boolean.TRUE;
    }

    private final void initView() {
        Ri();
        ki().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Ui(WinkEditorOpeningEndingAigcImageSelectFragment.this, view);
            }
        });
        si().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Vi(WinkEditorOpeningEndingAigcImageSelectFragment.this, view);
            }
        });
        Ci().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Wi(WinkEditorOpeningEndingAigcImageSelectFragment.this, view);
            }
        });
        mi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Xi(WinkEditorOpeningEndingAigcImageSelectFragment.this, view);
            }
        });
        ti().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingAigcImageSelectFragment.Yi(WinkEditorOpeningEndingAigcImageSelectFragment.this, view);
            }
        });
        Ki();
    }

    private final void ji() {
        MediaModel mediaModel;
        long curSeekTimeUs;
        WinkEditData h06 = xi().C2().h0();
        if (h06 != null) {
            mediaModel = h06.getMediaModel();
        } else {
            mediaModel = null;
        }
        Pair<Integer, Integer> s26 = WinkExtractCoverViewModel.s2(mediaModel);
        if (s26 == null) {
            s26 = new Pair<>(720, 1280);
        }
        if (xi().getCurSeekTimeUs() >= xi().C2().getDurationUs()) {
            curSeekTimeUs = (xi().getCurSeekTimeUs() / 1000) - 50;
        } else {
            curSeekTimeUs = xi().getCurSeekTimeUs() / 1000;
        }
        TimelineViewModelV2 xi5 = xi();
        Object obj = s26.first;
        Intrinsics.checkNotNullExpressionValue(obj, "size.first");
        int intValue = ((Number) obj).intValue();
        Object obj2 = s26.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "size.second");
        Size size = new Size(intValue, ((Number) obj2).intValue());
        String w3 = WinkExportUtils.w();
        Intrinsics.checkNotNullExpressionValue(w3, "getDefaultTemplateDir()");
        Bitmap a26 = xi5.a2(curSeekTimeUs, size, w3, null);
        if (a26 == null) {
            return;
        }
        this.extractedVideoFrame = Ei().W1(a26);
        a26.recycle();
    }

    private final void jj() {
        if (this.selectedAlbumImage == null) {
            pi().setVisibility(8);
            oi().setImageURI(null);
            ni().setImageURI(null);
        } else {
            pi().setVisibility(0);
            LocalMediaInfo localMediaInfo = this.selectedAlbumImage;
            Intrinsics.checkNotNull(localMediaInfo);
            Uri fromFile = Uri.fromFile(new File(localMediaInfo.path));
            oi().setImageURI(fromFile);
            ni().setImageURI(fromFile);
        }
    }

    private final View ki() {
        Object value = this.backBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backBtn>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kj() {
        this.isVideoTab = false;
        if (this.selectedAlbumImage == null) {
            ni().setVisibility(8);
            zi().setVisibility(0);
        } else {
            ni().setVisibility(0);
            zi().setVisibility(8);
        }
        ni().setVisibility(0);
        Bi().setVisibility(8);
        ri().setVisibility(0);
        Ci().setTextColor(requireContext().getColor(R.color.bfq));
        si().setTextColor(requireContext().getColor(R.color.bfp));
        Ci().setTypeface(Typeface.defaultFromStyle(0));
        si().setTypeface(Typeface.defaultFromStyle(1));
        Ai().setVisibility(8);
        qi().setVisibility(0);
    }

    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d li() {
        return (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d) this.dragDropViewController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lj() {
        this.isVideoTab = true;
        zi().setVisibility(0);
        ni().setVisibility(8);
        Bi().setVisibility(0);
        ri().setVisibility(8);
        Ci().setTextColor(requireContext().getColor(R.color.bfp));
        si().setTextColor(requireContext().getColor(R.color.bfq));
        Ci().setTypeface(Typeface.defaultFromStyle(1));
        si().setTypeface(Typeface.defaultFromStyle(0));
        Ai().setVisibility(0);
        qi().setVisibility(8);
    }

    private final View mi() {
        Object value = this.imageAddContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageAddContainer>(...)");
        return (View) value;
    }

    private final ImageView ni() {
        Object value = this.imagePreview.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imagePreview>(...)");
        return (ImageView) value;
    }

    private final ImageView oi() {
        Object value = this.imagePreviewThumbnail.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imagePreviewThumbnail>(...)");
        return (ImageView) value;
    }

    private final View pi() {
        Object value = this.imagePreviewThumbnailContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imagePreviewThumbnailContainer>(...)");
        return (View) value;
    }

    private final View qi() {
        Object value = this.imageTabContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageTabContainer>(...)");
        return (View) value;
    }

    private final void registerDaTongReportPageId(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_AIGC_CHOOSE_PIC_PAGE);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    private final View ri() {
        Object value = this.imageTabLine.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageTabLine>(...)");
        return (View) value;
    }

    private final void showLoadingDialog() {
        String str;
        ai.b bVar = new ai.b(getContext());
        Context context = getContext();
        if (context == null || (str = context.getString(R.string.f239577mu)) == null) {
            str = "";
        }
        com.tencent.mobileqq.wink.view.ai a16 = bVar.i(str).h(false).b(false).f(getView()).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcImageSelectFragment.hj(WinkEditorOpeningEndingAigcImageSelectFragment.this);
            }
        }).d(new Callable() { // from class: com.tencent.mobileqq.wink.editor.openingending.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean ij5;
                ij5 = WinkEditorOpeningEndingAigcImageSelectFragment.ij(WinkEditorOpeningEndingAigcImageSelectFragment.this);
                return ij5;
            }
        }).a();
        this.loadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    private final TextView si() {
        Object value = this.imageTabText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageTabText>(...)");
        return (TextView) value;
    }

    private final View ti() {
        Object value = this.nextBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-nextBtn>(...)");
        return (View) value;
    }

    private final ImageView ui() {
        Object value = this.recoverImageView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recoverImageView>(...)");
        return (ImageView) value;
    }

    private final TimelinePanel vi() {
        Object value = this.timelinePanel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-timelinePanel>(...)");
        return (TimelinePanel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelinePanelViewController wi() {
        return (TimelinePanelViewController) this.timelinePanelController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 xi() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout yi() {
        Object value = this.videoPreview.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoPreview>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout zi() {
        Object value = this.videoPreviewContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoPreviewContainer>(...)");
        return (FrameLayout) value;
    }

    @Nullable
    public View Ih(int i3) {
        View findViewById;
        Map<Integer, View> map = this.f321326n0;
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

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h
    public void Jc(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i iVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) event;
            xi().a3(iVar.getData(), iVar.getIsOutCalled());
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d) {
            xi().L2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d) event, isHidden());
            return;
        }
        boolean z17 = true;
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.b) {
            z16 = true;
        } else {
            z16 = event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.o;
        }
        if (!z16) {
            z17 = event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j;
        }
        if (z17) {
            xi().J2();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.f321326n0.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    public final void dismiss() {
        Job job = this.uiEventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        VideoReport.traversePage(getView());
        Ei().G2(this.isFromClipping, this.isFromTemplatePage);
        Ei().a2();
        getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5g;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ArrayList arrayList;
        boolean z16;
        Object first;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            if (data != null) {
                arrayList = data.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            } else {
                arrayList = null;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                this.selectedAlbumImage = (LocalMediaInfo) first;
                jj();
                zi().setVisibility(8);
                ni().setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        CommonConfig commonConfig = wi().getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        wi().w(CommonConfig.b(commonConfig, null, LayoutConfig.e(commonConfig.getLayoutConfig(), com.tencent.videocut.utils.o.g() / 2, 0.0f, 0.0f, 0.0f, 0.0f, 0, 62, null), null, null, 13, null));
        VideoTrackData value = xi().B2().getValue();
        if (value != null) {
            Di().y();
            Di().K(value.d(), value.c());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Di().F();
        xi().d3();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needDismiss) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.s
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingAigcImageSelectFragment.aj(WinkEditorOpeningEndingAigcImageSelectFragment.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        initView();
        Ji();
        Li();
        bj();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcImageSelectFragment$d", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ISessionListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorOpeningEndingAigcImageSelectFragment this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            this$0.xi().D3(newData.getTimeLines());
            OpeningEndingAigcData openingEndingAigcData = this$0.recoveredAigcData;
            boolean z16 = false;
            if (openingEndingAigcData != null && openingEndingAigcData.getUseVideoFrame()) {
                z16 = true;
            }
            if (z16) {
                TimelineViewModelV2 xi5 = this$0.xi();
                OpeningEndingAigcData openingEndingAigcData2 = this$0.recoveredAigcData;
                Intrinsics.checkNotNull(openingEndingAigcData2);
                TimelineViewModelV2.g3(xi5, openingEndingAigcData2.getExtractedVideoFrameTime(), false, false, 6, null);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment = WinkEditorOpeningEndingAigcImageSelectFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.v
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingAigcImageSelectFragment.d.b(WinkEditorOpeningEndingAigcImageSelectFragment.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingAigcImageSelectFragment(@NotNull List<? extends MediaClip> mediaClips, @NotNull MediaClip appliedTemplateClip, boolean z16, boolean z17, @Nullable BackgroundModel backgroundModel, @Nullable OpeningEndingAigcData openingEndingAigcData) {
        this();
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        Intrinsics.checkNotNullParameter(appliedTemplateClip, "appliedTemplateClip");
        this.mediaClips = mediaClips;
        this.appliedTemplateClip = appliedTemplateClip;
        this.isFromClipping = z16;
        this.isFromTemplatePage = z17;
        this.backgroundModel = backgroundModel;
        this.recoveredAigcData = openingEndingAigcData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(DialogInterface dialogInterface, int i3) {
    }
}
