package com.tencent.mobileqq.wink.dailysign;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.JsonObject;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.dailysign.DailySignBorderView;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.dailysign.DailySignFragment;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicLyricCropPart;
import com.tencent.mobileqq.wink.editor.music.ui.LyricStyleStickerImageVIew;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.ui.WinkMusicButton;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.music.volume.WinkMusicVolumeControlPart;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.lightAssetKit.Entity;
import org.light.listener.OnLoadAssetListener;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00c2\u00012\u00020\u00012\u00020\u0002:\u0004\u00c3\u0001\u00c4\u0001B\t\u00a2\u0006\u0006\b\u00c0\u0001\u0010\u00c1\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J#\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u0018\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0002J\b\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u0003H\u0014J\b\u00102\u001a\u00020\u0018H\u0014J\b\u00104\u001a\u0004\u0018\u000103J\b\u00105\u001a\u00020\u0018H\u0014J\b\u00106\u001a\u00020\u0003H\u0014J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0016J\u001a\u0010@\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010>H\u0014J\u0006\u0010A\u001a\u00020\tJ\u0010\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020\tH\u0016J\u0018\u0010H\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0003H\u0016J\b\u0010I\u001a\u00020\u0005H\u0014J\b\u0010J\u001a\u00020\tH\u0016J\b\u0010K\u001a\u00020\tH\u0016J\b\u0010L\u001a\u00020\tH\u0016J\"\u0010P\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010OH\u0016J\b\u0010Q\u001a\u00020\u0003H\u0016R\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010~\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u008b\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010qR\u0019\u0010\u008d\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0083\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u0083\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0083\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010\u00a2\u0001\u001a\u00030\u009e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009f\u0001\u0010T\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001R \u0010\u00a7\u0001\u001a\u00030\u00a3\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a4\u0001\u0010T\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R \u0010\u00ab\u0001\u001a\u00030\u00a8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0083\u0001\u0010T\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R \u0010\u00b0\u0001\u001a\u00030\u00ac\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ad\u0001\u0010T\u001a\u0006\b\u00ae\u0001\u0010\u00af\u0001R \u0010\u00b5\u0001\u001a\u00030\u00b1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b2\u0001\u0010T\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001a\u0010\u00b9\u0001\u001a\u00030\u00b6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u001d\u0010\u00bf\u0001\u001a\u00030\u00ba\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001\u00a8\u0006\u00c5\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "", "bj", "", "getPageId", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "", "ri", "Landroid/view/View;", "view", "eid", "Ljava/util/HashMap;", "extParams", "qi", "Mi", "Lr53/a;", "wi", "Ci", "mj", "cj", "Qi", "", "renderHeight", "renderWidth", "jj", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "rj", "Ni", "Fi", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "info", "kj", "lj", "gj", "ij", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "data", "fj", "pi", "pj", "Ei", "", "deltaX", "deltay", "Bi", "aj", "isUseDarkTextStatusBar", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/editor/dr;", "zi", "getContentLayoutId", "needSupportFullScreen", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "initViewModel", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "xc", "curPageId", "isSelf", "X9", "getLogTag", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "onBackEvent", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "si", "()Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "D", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "mVideoTavCut", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "E", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "mVideoContainerView", "Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView;", "dailySignBorderView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "closeButton", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "errorView", "Lcom/tencent/mobileqq/wink/dailysign/d;", "I", "Lcom/tencent/mobileqq/wink/dailysign/d;", "dailySignBottomPart", "Lcom/tencent/mobileqq/wink/dailysign/WinkSlidMenuPart;", "J", "Lcom/tencent/mobileqq/wink/dailysign/WinkSlidMenuPart;", "winkEmotionSlidMenuPart", "Lcom/tencent/mobileqq/wink/dailysign/ah;", "K", "Lcom/tencent/mobileqq/wink/dailysign/ah;", "musicMenuPart", "Lcom/tencent/mobileqq/wink/dailysign/ak;", "L", "Lcom/tencent/mobileqq/wink/dailysign/ak;", "musicMenuPartV2", "M", "Landroid/view/View;", "musicMenuItem", "N", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "pagerCallback", "P", "Z", "isCutInit", "Lcom/tencent/mobileqq/wink/dailysign/DailySignTextMenuPart;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/dailysign/DailySignTextMenuPart;", "mTextEditPart", "", BdhLogUtil.LogTag.Tag_Req, "startTime", ExifInterface.LATITUDE_SOUTH, WinkDengtaReportConstant.Params.REPORT_IS_FROM_TAKE_SAME, "T", "isFromPhotoPicker", "U", "isPageSelected", "Landroidx/constraintlayout/widget/ConstraintLayout;", "V", "Landroidx/constraintlayout/widget/ConstraintLayout;", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMRootView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mRootView", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "W", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "X", "ti", "()Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "dailySignViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "Y", "xi", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", WidgetCacheLunarData.YI, "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lcom/tencent/mobileqq/wink/editor/export/u;", "a0", "Ai", "()Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "b0", "vi", "()Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "mWinkExtractCoverViewModel", "Lorg/light/listener/OnLoadAssetListener;", "c0", "Lorg/light/listener/OnLoadAssetListener;", "loadAssetListener", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "d0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "getPlayerListener", "()Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "<init>", "()V", "e0", "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailySignFragment extends ImmersivePartFragment implements FragmentPager.d {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WinkVideoTavCut mVideoTavCut;

    /* renamed from: E, reason: from kotlin metadata */
    private WinkPlayerContainerView mVideoContainerView;

    /* renamed from: F, reason: from kotlin metadata */
    private DailySignBorderView dailySignBorderView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView closeButton;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout errorView;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.dailysign.d dailySignBottomPart;

    /* renamed from: J, reason: from kotlin metadata */
    private WinkSlidMenuPart winkEmotionSlidMenuPart;

    /* renamed from: K, reason: from kotlin metadata */
    private ah musicMenuPart;

    /* renamed from: L, reason: from kotlin metadata */
    private ak musicMenuPartV2;

    /* renamed from: M, reason: from kotlin metadata */
    private View musicMenuItem;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private FragmentPager.b pagerCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isCutInit;

    /* renamed from: Q, reason: from kotlin metadata */
    private DailySignTextMenuPart mTextEditPart;

    /* renamed from: R, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isFromTakeSame;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isFromPhotoPicker;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isPageSelected;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mRootView;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy dailySignViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkExportViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mWinkExtractCoverViewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OnLoadAssetListener loadAssetListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment$a;", "", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "dailySignConfig", "", "", "a", "ACTION", "Ljava/lang/String;", "ACTION_JUMP_TO_CAMERA", "ACTION_PICK_IMAGE", "BASE_JS_PREFIX", "", "BOTTOM_VIEW_HEIGHT", UserInfo.SEX_FEMALE, "BOTTOM_VIEW_WIDTH", "EMOTION_BOTTOM", "EMOTION_TOP", "EMOTION_VALUE", "QZONE_BOTTOM_VIEW_HEIGHT", "TAG", "UPDATE_BACKGROUND_EVENT", "UPDATE_EMOTION", "UPDATE_EMOTION_EVENT", "UPDATE_TEXT_EVENT", "UPDATE_TOUCH_EVENT", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.dailysign.DailySignFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<String, Object> a(@NotNull DailySignConfig dailySignConfig) {
            Intrinsics.checkNotNullParameter(dailySignConfig, "dailySignConfig");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String second = dailySignConfig.getTemplateType().getSecond();
            if (!Intrinsics.areEqual(second, "0")) {
                linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SINGLE_PIC_TEXT_TYPE, second);
            }
            return linkedHashMap;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment$b;", "", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$c", "Ls73/a;", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "winkTavCut", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", "d", "", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements s73.a<WinkVideoTavCut> {
        c() {
        }

        @Override // s73.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull WinkVideoTavCut winkTavCut) {
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            winkTavCut.addPlayerListener(DailySignFragment.this.getPlayerListener());
        }

        @Override // s73.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Object> a(@NotNull WinkVideoTavCut winkTavCut) {
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            return new HashMap<>();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$d", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ICutStatusCallback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DailySignFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.lj();
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            DailySignFragment.this.isCutInit = true;
            Handler mainHandler = DailySignFragment.this.getMainHandler();
            final DailySignFragment dailySignFragment = DailySignFragment.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.dailysign.ad
                @Override // java.lang.Runnable
                public final void run() {
                    DailySignFragment.d.b(DailySignFragment.this);
                }
            });
            ms.a.c("DailySignFragment", "onLightEntityReload: " + rootEntity);
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            ms.a.f("DailySignFragment", "onRenderChainReady ");
            WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
            if (winkVideoTavCut != null) {
                winkVideoTavCut.O2(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$f", "Lorg/light/listener/OnLoadAssetListener;", "", "p0", "", "OnLoadAssetError", "Ljava/util/HashMap;", "", "hashMap", "OnAssetProcessing", "", "OnAssetDurationChange", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements OnLoadAssetListener {
        f() {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long p06) {
            w53.b.f(DailySignFragment.this.getTAG(), "OnAssetDurationChange ");
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(@NotNull HashMap<String, String> hashMap) {
            String str;
            Intrinsics.checkNotNullParameter(hashMap, "hashMap");
            if (hashMap.containsKey("material_result") && (str = hashMap.get("material_result")) != null) {
                DailySignFragment dailySignFragment = DailySignFragment.this;
                try {
                    String optString = new JSONObject(str).optString("eventType");
                    if (optString != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -2108582394) {
                            if (hashCode != -1548150928) {
                                if (hashCode == -595263633 && optString.equals("onTextUpdated")) {
                                }
                            } else if (!optString.equals("showTextEditPanel")) {
                            }
                        } else if (!optString.equals("showEmotionPanel")) {
                        }
                        dailySignFragment.Bi(0.0f, 0.0f);
                    }
                } catch (Exception e16) {
                    w53.b.a(dailySignFragment.getTAG(), "Exception: " + e16);
                }
            }
            DailySignFragment.this.ti().y2(hashMap);
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int p06) {
            w53.b.f(DailySignFragment.this.getTAG(), "OnLoadAssetError " + p06);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$g", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements ISessionListener {
        g() {
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
            ICutSession session;
            WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
            if (winkVideoTavCut != null && (session = winkVideoTavCut.getSession()) != null) {
                session.removeSessionListener(this);
            }
            w53.b.c(DailySignFragment.this.getTAG(), "onRenderDataApplied");
            DailySignFragment.this.xi().X3();
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            w53.b.c(DailySignFragment.this.getTAG(), "onRenderDataChanged");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$h", "Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView$b;", "", "deltaX", "deltay", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements DailySignBorderView.b {
        h() {
        }

        @Override // com.tencent.mobileqq.wink.dailysign.DailySignBorderView.b
        public void a(float deltaX, float deltay) {
            DailySignFragment.this.Bi(deltaX, deltay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$i", "Landroidx/fragment/app/FragmentResultListener;", "", "requestKey", "Landroid/os/Bundle;", "result", "", "onFragmentResult", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class i implements FragmentResultListener {
        i() {
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@NotNull String requestKey, @NotNull Bundle result) {
            LocalMediaInfo localMediaInfo;
            Intrinsics.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics.checkNotNullParameter(result, "result");
            Object obj = result.get(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
            if (obj instanceof LocalMediaInfo) {
                localMediaInfo = (LocalMediaInfo) obj;
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo != null) {
                DailySignViewModel ti5 = DailySignFragment.this.ti();
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                ti5.W1(str, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$j", "Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment$b;", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class j implements b {
        j() {
        }

        @Override // com.tencent.mobileqq.wink.dailysign.DailySignFragment.b
        public void a() {
            al alVar;
            HashMap<String, String> hashMap;
            WinkEditData copy;
            String str;
            boolean z16;
            Long l3;
            String str2;
            String str3;
            Integer num;
            MusicVolumeControlViewModel.VolumeType volumeType;
            Intent intent;
            Boolean isFromTemplateColl;
            WinkEditData K1;
            Result<al> value = DailySignFragment.this.ti().o2().getValue();
            String str4 = null;
            if (value != null) {
                Object value2 = value.getValue();
                ResultKt.throwOnFailure(value2);
                alVar = (al) value2;
            } else {
                alVar = null;
            }
            if (alVar != null) {
                WinkEditDataWrapper winkEditDataWrapper = alVar.getWinkEditDataWrapper();
                DailySignFragment.this.ri(winkEditDataWrapper);
                if (winkEditDataWrapper.getEditDatas().size() > 0) {
                    DailySignViewModel ti5 = DailySignFragment.this.ti();
                    WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
                    if (winkVideoTavCut != null && (K1 = winkVideoTavCut.K1()) != null) {
                        hashMap = K1.getAssetData();
                    } else {
                        hashMap = null;
                    }
                    HashMap<String, String> C2 = ti5.C2(true, hashMap);
                    WinkEditData winkEditData = winkEditDataWrapper.getEditDatas().get(0);
                    Intrinsics.checkNotNullExpressionValue(winkEditData, "dataWrapper.editDatas.get(0)");
                    copy = r7.copy((r37 & 1) != 0 ? r7.mediaModel : null, (r37 & 2) != 0 ? r7.durationUs : 0L, (r37 & 4) != 0 ? r7.stickerModelMap : null, (r37 & 8) != 0 ? r7.filterModelMap : null, (r37 & 16) != 0 ? r7.filterMaterialMap : null, (r37 & 32) != 0 ? r7.stickerExtraMap : null, (r37 & 64) != 0 ? r7.openHDR : false, (r37 & 128) != 0 ? r7.effectModelMap : null, (r37 & 256) != 0 ? r7.renderModelStr : null, (r37 & 512) != 0 ? r7.templateMaterialMap : null, (r37 & 1024) != 0 ? r7.stretchData : null, (r37 & 2048) != 0 ? r7.assetData : C2, (r37 & 4096) != 0 ? r7.isLakData : false, (r37 & 8192) != 0 ? r7.mosaicData : null, (r37 & 16384) != 0 ? r7.challengeData : null, (r37 & 32768) != 0 ? r7.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? r7.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(copy);
                    WinkEditorMusicInfo currentMusic = DailySignFragment.this.xi().getCurrentMusic();
                    if (currentMusic != null) {
                        str = currentMusic.p();
                    } else {
                        str = null;
                    }
                    dr.WinkTavCutParams winkTavCutParams = alVar.getWinkTavCutParams();
                    if (winkTavCutParams != null && (isFromTemplateColl = winkTavCutParams.getIsFromTemplateColl()) != null) {
                        z16 = isFromTemplateColl.booleanValue();
                    } else {
                        z16 = false;
                    }
                    WinkEditorMusicInfo currentMusic2 = DailySignFragment.this.xi().getCurrentMusic();
                    if (currentMusic2 != null) {
                        l3 = Long.valueOf(currentMusic2.o());
                    } else {
                        l3 = null;
                    }
                    WinkEditorMusicInfo currentMusic3 = DailySignFragment.this.xi().getCurrentMusic();
                    if (currentMusic3 != null) {
                        str2 = currentMusic3.q();
                    } else {
                        str2 = null;
                    }
                    WinkEditorMusicInfo currentMusic4 = DailySignFragment.this.xi().getCurrentMusic();
                    if (currentMusic4 != null) {
                        str3 = currentMusic4.r();
                    } else {
                        str3 = null;
                    }
                    WinkEditorMusicInfo currentMusic5 = DailySignFragment.this.xi().getCurrentMusic();
                    if (currentMusic5 != null) {
                        num = Integer.valueOf(currentMusic5.n());
                    } else {
                        num = null;
                    }
                    Float value3 = DailySignFragment.this.yi().T1().getValue();
                    if (value3 == null) {
                        value3 = Float.valueOf(0.0f);
                    }
                    if (TextUtils.isEmpty(str)) {
                        volumeType = MusicVolumeControlViewModel.VolumeType.NONE;
                    } else {
                        volumeType = MusicVolumeControlViewModel.VolumeType.BGM;
                    }
                    WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(winkEditDataWrapper, null, null, arrayList, null, null, 7, null, 0L, false, str, null, false, 0, 0.0f, value3.floatValue(), volumeType, false, null, null, false, 0L, l3, str2, false, 0L, false, null, false, null, z16, null, 0, null, false, false, null, false, false, false, null, str3, num, null, false, -543212069, 3327, null);
                    DailySignFragment.this.Ai().I2(copy$default);
                    com.tencent.mobileqq.wink.editor.draft.a.h(copy$default, copy$default.getMissionId());
                    com.tencent.mobileqq.wink.editor.draft.a.i(copy$default, copy$default.getMissionId());
                    WinkVideoTavCut winkVideoTavCut2 = DailySignFragment.this.mVideoTavCut;
                    if (winkVideoTavCut2 != null) {
                        winkVideoTavCut2.G2(C2);
                    }
                    WinkExtractCoverViewModel vi5 = DailySignFragment.this.vi();
                    DailySignFragment dailySignFragment = DailySignFragment.this;
                    WinkVideoTavCut winkVideoTavCut3 = dailySignFragment.mVideoTavCut;
                    FragmentActivity activity = DailySignFragment.this.getActivity();
                    if (activity != null && (intent = activity.getIntent()) != null) {
                        str4 = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
                    }
                    vi5.d2(dailySignFragment, winkVideoTavCut3, copy$default, str4, true, copy$default.getBusinessName(), Boolean.FALSE, 0);
                }
                HashMap<String, Object> params = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                Float value4 = DailySignFragment.this.yi().T1().getValue();
                if (value4 == null) {
                    value4 = Float.valueOf(0.0f);
                }
                params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, value4);
                HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params2, "params");
                Float value5 = DailySignFragment.this.yi().h2().getValue();
                if (value5 == null) {
                    value5 = Float.valueOf(0.0f);
                }
                params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, value5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$k", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "a", "J", "getCachedCurrentDurationUs", "()J", "setCachedCurrentDurationUs", "(J)V", "cachedCurrentDurationUs", "b", "getCachedPlayerDurationUs", "setCachedPlayerDurationUs", "cachedPlayerDurationUs", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class k implements IPlayer.PlayerListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long cachedCurrentDurationUs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long cachedPlayerDurationUs;

        k() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            if (currentDurationUs != this.cachedCurrentDurationUs || playerDurationUs != this.cachedPlayerDurationUs) {
                this.cachedCurrentDurationUs = currentDurationUs;
                this.cachedPlayerDurationUs = playerDurationUs;
                DailySignFragment.this.wi().J3().postValue(Long.valueOf(currentDurationUs));
                DailySignFragment.this.xi().Q2().postValue(Long.valueOf(currentDurationUs));
                long j3 = 1000;
                long a16 = com.tencent.mobileqq.wink.editor.music.a.a(currentDurationUs / j3);
                if (DailySignFragment.this.xi().getCurrentMusic() != null) {
                    com.tencent.mobileqq.wink.editor.music.lyric.e a17 = com.tencent.mobileqq.wink.editor.music.lyric.e.a();
                    WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
                    if (winkVideoTavCut != null) {
                        playerDurationUs = winkVideoTavCut.getDurationUs();
                    }
                    a17.e(a16, playerDurationUs / j3);
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class l extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public l(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("DailySignFragment", "preloadData exception: " + stackTraceToString);
        }
    }

    public DailySignFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DailySignConfig>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DailySignConfig invoke() {
                HashMap hashMap = new HashMap();
                String F2 = uq3.c.F2();
                Intrinsics.checkNotNullExpressionValue(F2, "getNickname()");
                hashMap.put("nickNameForQQ", F2);
                hashMap.put("yearNumber", String.valueOf(Calendar.getInstance().get(1)));
                DailySignConfig.Companion companion = DailySignConfig.INSTANCE;
                hashMap.put("monthNumber", companion.a(Calendar.getInstance().get(2) + 1));
                hashMap.put("dayNumber", companion.a(Calendar.getInstance().get(5)));
                hashMap.put("weekString", com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a.INSTANCE.a(Calendar.getInstance().get(7) - 1));
                Intent intent = DailySignFragment.this.requireActivity().getIntent();
                Serializable serializableExtra = intent != null ? intent.getSerializableExtra(QQWinkConstants.EDITOR_TEXT_TEMPLATE_CONFIG) : null;
                DailySignConfig dailySignConfig = serializableExtra instanceof DailySignConfig ? (DailySignConfig) serializableExtra : null;
                DailySignConfig dailySignConfig2 = dailySignConfig == null ? new DailySignConfig(null, null, null, null, null, 31, null) : dailySignConfig;
                String textContent = dailySignConfig2.getTextContent();
                if (textContent != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("text", textContent);
                }
                return DailySignConfig.copy$default(dailySignConfig2, null, null, null, hashMap, null, 23, null);
            }
        });
        this.config = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DailySignViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$dailySignViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DailySignViewModel invoke() {
                return (DailySignViewModel) DailySignFragment.this.getViewModel(DailySignViewModel.class);
            }
        });
        this.dailySignViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(DailySignFragment.this).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026rceViewModel::class.java]");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$musicVolumeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(DailySignFragment.this).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026rolViewModel::class.java]");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.musicVolumeViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.export.u>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$winkExportViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.export.u invoke() {
                return (com.tencent.mobileqq.wink.editor.export.u) DailySignFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
            }
        });
        this.winkExportViewModel = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<WinkExtractCoverViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$mWinkExtractCoverViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkExtractCoverViewModel invoke() {
                return (WinkExtractCoverViewModel) DailySignFragment.this.getViewModel(WinkExtractCoverViewModel.class);
            }
        });
        this.mWinkExtractCoverViewModel = lazy6;
        this.loadAssetListener = new f();
        this.playerListener = new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.export.u Ai() {
        Object value = this.winkExportViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkExportViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.export.u) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Bi(float deltaX, float deltay) {
        HashMap<String, String> hashMapOf;
        WinkVideoTavCut winkVideoTavCut;
        boolean isInMultiWindowMode;
        w53.b.a(getTAG(), "handleActionDown deltaX " + deltaX + " deltay" + deltay);
        WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
        if (winkVideoTavCut2 != null) {
            winkVideoTavCut2.flush(true);
        }
        JsonObject jsonObject = new JsonObject();
        float f16 = 0.171f;
        DailySignBorderView dailySignBorderView = null;
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = getHostActivity().isInMultiWindowMode();
            if (isInMultiWindowMode) {
                int[] iArr = new int[2];
                DailySignBorderView dailySignBorderView2 = this.dailySignBorderView;
                if (dailySignBorderView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
                    dailySignBorderView2 = null;
                }
                dailySignBorderView2.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i16 = iArr[1];
                float f17 = deltaX + i3;
                WinkPlayerContainerView winkPlayerContainerView = this.mVideoContainerView;
                if (winkPlayerContainerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerView");
                    winkPlayerContainerView = null;
                }
                if (f17 > winkPlayerContainerView.getWidth()) {
                    return;
                }
                DailySignBorderView dailySignBorderView3 = this.dailySignBorderView;
                if (dailySignBorderView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
                    dailySignBorderView3 = null;
                }
                jsonObject.addProperty(HippyTKDListViewAdapter.X, Float.valueOf(f17 / dailySignBorderView3.getWidth()));
                if (getActivity() instanceof QQWinkActivity) {
                    float f18 = deltay + i16;
                    DailySignBorderView dailySignBorderView4 = this.dailySignBorderView;
                    if (dailySignBorderView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
                    } else {
                        dailySignBorderView = dailySignBorderView4;
                    }
                    float height = f18 / (dailySignBorderView.getHeight() + i16);
                    double d16 = height;
                    if (d16 <= 0.32d || d16 >= 0.4d) {
                        f16 = height;
                    }
                    jsonObject.addProperty("y", Float.valueOf(f16));
                } else {
                    DailySignBorderView dailySignBorderView5 = this.dailySignBorderView;
                    if (dailySignBorderView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
                    } else {
                        dailySignBorderView = dailySignBorderView5;
                    }
                    jsonObject.addProperty("y", Float.valueOf(deltay / (dailySignBorderView.getHeight() + ViewUtils.dpToPx(30.0f))));
                }
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("event.script.updateTouchEvent", String.valueOf(jsonObject)));
                w53.b.a(getTAG(), "handleActionDown map " + hashMapOf);
                winkVideoTavCut = this.mVideoTavCut;
                if (winkVideoTavCut == null) {
                    winkVideoTavCut.G2(hashMapOf);
                    return;
                }
                return;
            }
        }
        DailySignBorderView dailySignBorderView6 = this.dailySignBorderView;
        if (dailySignBorderView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
            dailySignBorderView6 = null;
        }
        jsonObject.addProperty(HippyTKDListViewAdapter.X, Float.valueOf(deltaX / (dailySignBorderView6.getWidth() + 70.0f)));
        if (getActivity() instanceof QQWinkActivity) {
            DailySignBorderView dailySignBorderView7 = this.dailySignBorderView;
            if (dailySignBorderView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
            } else {
                dailySignBorderView = dailySignBorderView7;
            }
            float height2 = deltay / (dailySignBorderView.getHeight() + ViewUtils.dpToPx(56.0f));
            if (height2 >= 0.17f || height2 <= 0.14f) {
                f16 = height2;
            }
            jsonObject.addProperty("y", Float.valueOf(f16));
        } else {
            DailySignBorderView dailySignBorderView8 = this.dailySignBorderView;
            if (dailySignBorderView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
            } else {
                dailySignBorderView = dailySignBorderView8;
            }
            jsonObject.addProperty("y", Float.valueOf(deltay / (dailySignBorderView.getHeight() + ViewUtils.dpToPx(30.0f))));
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("event.script.updateTouchEvent", String.valueOf(jsonObject)));
        w53.b.a(getTAG(), "handleActionDown map " + hashMapOf);
        winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut == null) {
        }
    }

    private final void Ci() {
        vi().m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Di(DailySignFragment.this, (WinkExtractCoverViewModel.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(DailySignFragment this$0, WinkExtractCoverViewModel.c cVar) {
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar.b() == 0) {
            WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
            if (winkVideoTavCut != null) {
                winkVideoTavCut.pause();
                return;
            }
            return;
        }
        String str = null;
        if (cVar.b() == 2) {
            Context context = this$0.getContext();
            Context context2 = this$0.getContext();
            if (context2 != null) {
                str = context2.getString(R.string.f239337m7);
            }
            QQToast.makeText(context, -1, str, 0).show();
            return;
        }
        if (cVar.b() == 1 || cVar.b() == 4) {
            com.tencent.mobileqq.wink.editor.export.u Ai = this$0.Ai();
            WinkVideoTavCut winkVideoTavCut2 = this$0.mVideoTavCut;
            ArrayList<LocalMediaInfo> a16 = cVar.a();
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            }
            Ai.J2(this$0, winkVideoTavCut2, true, a16, str, WinkContext.INSTANCE.d().k().a(), false, false, this$0.xi());
        }
    }

    private final void Ei() {
        this.startTime = SystemClock.elapsedRealtime();
        WinkMaterialResourceLoader.f325333a.j("wordpicture");
        try {
            if (!ti().E2(si().getMissionId())) {
                ti().J2(true);
                ti().G2();
            }
        } catch (Exception e16) {
            ti().K2(true);
            QLog.d(getTAG(), 1, e16, new Object[0]);
        }
    }

    private final void Fi() {
        ms.a.f(getTAG(), "initMusicSourceViewModelObserver");
        xi().o3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Gi(DailySignFragment.this, (Long) obj);
            }
        });
        xi().D2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Hi(DailySignFragment.this, (MusicInfoWrapper) obj);
            }
        });
        yi().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ii(DailySignFragment.this, (Float) obj);
            }
        });
        xi().j3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ji(DailySignFragment.this, (List) obj);
            }
        });
        xi().u3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ki(DailySignFragment.this, (Boolean) obj);
            }
        });
        xi().W2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Li(DailySignFragment.this, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(DailySignFragment this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
        if (winkVideoTavCut != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkVideoTavCut.seek(it.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(DailySignFragment this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "musicinfo = " + musicInfoWrapper.getMusicInfo() + ", durationMs = " + musicInfoWrapper.getDurationMs() + ", mVideoTavCut=" + this$0.mVideoTavCut);
        this$0.kj(musicInfoWrapper);
        this$0.ij();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(DailySignFragment this$0, Float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicInfoWrapper value = this$0.xi().D2().getValue();
        if (value != null) {
            this$0.kj(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(DailySignFragment this$0, List list) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
        if (winkVideoTavCut != null) {
            this$0.xi().z4(winkVideoTavCut.getDurationUs() / 1000);
        }
        if (this$0.xi().getCurrentMusic() != null) {
            MusicVolumeControlViewModel yi5 = this$0.yi();
            if (this$0.xi().getCurrentMusic() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            MusicVolumeControlViewModel.z2(yi5, z16, false, 2, null);
            QLog.i(this$0.getTAG(), 1, "volume  currentMusic " + this$0.xi().getCurrentMusic());
        }
        w53.b.a(this$0.getTAG(), "musicList change");
        this$0.lj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(DailySignFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
        if (winkVideoTavCut != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkVideoTavCut.W2(it.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(DailySignFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), 1, this$0.requireContext().getString(i3), 0).show();
        if (cx.INSTANCE.f()) {
            try {
                View view = this$0.musicMenuItem;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
                    view = null;
                }
                ((WinkMusicButton) view).a();
            } catch (Exception e16) {
                w53.b.e("WinkEditorFragment", e16);
            }
        }
    }

    private final void Mi() {
        Fi();
        Ni();
        wi().P3();
    }

    private final void Ni() {
        List<MediaClip> a06;
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null && (a06 = winkVideoTavCut.a0()) != null) {
            yi().p2(a06);
        }
        yi().h2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Oi(DailySignFragment.this, (Float) obj);
            }
        });
        yi().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Pi(DailySignFragment.this, (Float) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(DailySignFragment this$0, Float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.v(this$0.yi().e2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(DailySignFragment this$0, Float it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "volume  " + it + " originMusicInfo " + this$0.ti().getPublishConfig().getOriginMusicInfoVolume());
        this$0.ti().getPublishConfig().p(it);
        if (this$0.ti().getPublishConfig().getOriginMusicInfoVolume() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(it, 0.0f)) {
            as publishConfig = this$0.ti().getPublishConfig();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            publishConfig.t(it.floatValue());
        }
        if (this$0.yi().f2() == MusicVolumeControlViewModel.VolumeType.TEMPLATE) {
            WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
            if (winkVideoTavCut != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                WinkVideoTavCut.H3(winkVideoTavCut, it.floatValue(), null, 2, null);
                return;
            }
            return;
        }
        WinkVideoTavCut winkVideoTavCut2 = this$0.mVideoTavCut;
        if (winkVideoTavCut2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dr.b.l(winkVideoTavCut2, it.floatValue(), null, 2, null);
        }
        this$0.xi().j4(it);
    }

    private final void Qi() {
        ti().H2(com.tencent.mobileqq.wink.editor.util.m.f322645a.g(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean aj() {
        String name;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            int backStackEntryCount = activity.getSupportFragmentManager().getBackStackEntryCount();
            if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0 && (name = activity.getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName()) != null && Intrinsics.areEqual(name, "DAILY_SIGN")) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean bj() {
        return cx.INSTANCE.f();
    }

    private final boolean cj() {
        if (ti().getPublishConfig().i()) {
            mj();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dj(DailySignFragment this$0, View view) {
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.cj() && (activity = this$0.getActivity()) != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(DailySignFragment this$0) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.aj()) {
            WinkVideoTavCut winkVideoTavCut2 = this$0.mVideoTavCut;
            if (winkVideoTavCut2 != null) {
                winkVideoTavCut2.pause();
                return;
            }
            return;
        }
        if (this$0.isResumed() && (winkVideoTavCut = this$0.mVideoTavCut) != null) {
            winkVideoTavCut.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj(com.tencent.mobileqq.wink.lowthresholdltemplate.a data) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), new l(CoroutineExceptionHandler.INSTANCE), null, new DailySignFragment$preloadData$1(data, this, null), 2, null);
    }

    private final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_DAILY_SIGNIN_PAGE;
    }

    private final void gj() {
        Object obj;
        final List<WinkEditorMusicInfo> R2 = xi().R2();
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = R2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WinkEditorMusicInfo) obj).p(), ti().getDraftMusicMid())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) obj;
        if (winkEditorMusicInfo != null) {
            arrayList.addAll(R2);
            arrayList.remove(winkEditorMusicInfo);
            arrayList.add(0, winkEditorMusicInfo);
            xi().m4(arrayList);
            xi().g4("\u968f\u8bb0", ti().getDraftMusicMid());
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ti().getDraftMusicMid());
        WinkEditorMusicHelper.D(arrayList2, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.dailysign.u
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj2) {
                DailySignFragment.hj(arrayList, R2, this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$MusicInfoRsp) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj(List nextList, List originList, DailySignFragment this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        Intrinsics.checkNotNullParameter(nextList, "$nextList");
        Intrinsics.checkNotNullParameter(originList, "$originList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            List<WinkEditorMusicInfo> queriedMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_DAILY_SIGN_ID", "\u968f\u8bb0");
            Intrinsics.checkNotNullExpressionValue(queriedMusicList, "queriedMusicList");
            nextList.addAll(queriedMusicList);
            nextList.addAll(originList);
            this$0.xi().m4(nextList);
            this$0.xi().g4("\u968f\u8bb0", this$0.ti().getDraftMusicMid());
        }
    }

    private final void ij() {
        Long l3;
        String str;
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        WinkEditorMusicInfo currentMusic = xi().getCurrentMusic();
        View view = null;
        if (currentMusic != null) {
            l3 = Long.valueOf(currentMusic.o());
        } else {
            l3 = null;
        }
        map.put("xsj_music_id", l3);
        View view2 = this.musicMenuItem;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
            view2 = null;
        }
        VideoReport.setElementId(view2, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
        View view3 = this.musicMenuItem;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
            view3 = null;
        }
        VideoReport.setElementExposePolicy(view3, ExposurePolicy.REPORT_NONE);
        View view4 = this.musicMenuItem;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_NONE);
        map.put("dt_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
        WinkEditorMusicInfo currentMusic2 = xi().getCurrentMusic();
        if (currentMusic2 != null) {
            str = currentMusic2.q();
        } else {
            str = null;
        }
        map.put("xsj_music_name", str);
        View view5 = this.musicMenuItem;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
        } else {
            view = view5;
        }
        VideoReport.reportEvent("dt_imp", view, map);
    }

    private final void jj(Integer renderHeight, Integer renderWidth) {
        w53.b.f(getTAG(), "resizePlayerContainer playerContainer " + renderHeight + "*" + renderWidth);
        if (getContext() != null && renderHeight != null) {
            int intValue = renderHeight.intValue();
            if (renderWidth != null) {
                int intValue2 = renderWidth.intValue();
                DailySignBorderView dailySignBorderView = this.dailySignBorderView;
                if (dailySignBorderView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
                    dailySignBorderView = null;
                }
                w53.b.f(getTAG(), "resizePlayerContainer dailySignBorderView  " + dailySignBorderView.getMeasuredWidth() + " " + dailySignBorderView.getMeasuredHeight());
                ViewGroup.LayoutParams layoutParams = dailySignBorderView.getLayoutParams();
                if (layoutParams != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                    layoutParams.width = intValue2 + com.tencent.mobileqq.util.x.c(getContext(), 20.0f);
                    layoutParams.height = intValue + com.tencent.mobileqq.util.x.c(getContext(), 20.0f);
                    dailySignBorderView.setLayoutParams(layoutParams);
                    dailySignBorderView.requestLayout();
                }
            }
        }
    }

    private final void kj(MusicInfoWrapper info) {
        long j3;
        AudioModel copy;
        if (info != null) {
            ti().getPublishConfig().o(info);
            if (ti().getPublishConfig().getOriginMusicIdInfo() == null) {
                ti().getPublishConfig().s(info);
            }
            if (info.getMusicInfo() == null) {
                WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
                if (winkVideoTavCut != null) {
                    dr.b.k(winkVideoTavCut, null, null, 2, null);
                }
                yi().y2(false, true);
                return;
            }
            WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
            if (winkVideoTavCut2 != null) {
                dr.b.k(winkVideoTavCut2, null, null, 2, null);
            }
            WinkVideoTavCut winkVideoTavCut3 = this.mVideoTavCut;
            if (winkVideoTavCut3 != null) {
                AudioModel e16 = info.e();
                Float value = yi().T1().getValue();
                if (value == null) {
                    value = Float.valueOf(1.0f);
                }
                copy = e16.copy((r37 & 1) != 0 ? e16.id : null, (r37 & 2) != 0 ? e16.path : null, (r37 & 4) != 0 ? Long.valueOf(e16.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(e16.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(e16.startTimeInTimeline) : null, (r37 & 32) != 0 ? Float.valueOf(e16.volume) : value, (r37 & 64) != 0 ? Float.valueOf(e16.speed) : null, (r37 & 128) != 0 ? e16.volumeEffects : null, (r37 & 256) != 0 ? e16.name : null, (r37 & 512) != 0 ? e16.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(e16.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(e16.selectDuration) : null, (r37 & 4096) != 0 ? Long.valueOf(e16.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(e16.fadeOutDuration) : null, (r37 & 16384) != 0 ? e16.lyricInfo : null, (r37 & 32768) != 0 ? e16.type : null, (r37 & 65536) != 0 ? e16.waveSampleData : null, (r37 & 131072) != 0 ? e16.event : null, (r37 & 262144) != 0 ? e16.unknownFields() : null);
                dr.b.k(winkVideoTavCut3, copy, null, 2, null);
            }
            QLog.i(getTAG(), 1, "volume  musicVolumeViewModel~~~~ " + yi().T1().getValue());
            MusicVolumeControlViewModel.z2(yi(), true, false, 2, null);
            MusicSourceViewModel xi5 = xi();
            WinkVideoTavCut winkVideoTavCut4 = this.mVideoTavCut;
            if (winkVideoTavCut4 != null) {
                j3 = winkVideoTavCut4.getDurationUs();
            } else {
                j3 = 0;
            }
            xi5.z4(j3 / 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lj() {
        if (this.isCutInit && xi().getNeedAutoMusic()) {
            w53.b.a(getTAG(), "setAutoMusic " + ti().getDraftMusicMid());
            View view = this.musicMenuItem;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
                view = null;
            }
            boolean z16 = false;
            view.setVisibility(0);
            String draftMusicMid = ti().getDraftMusicMid();
            if (draftMusicMid == null || draftMusicMid.length() == 0) {
                z16 = true;
            }
            if (z16) {
                xi().g4("\u968f\u8bb0", null);
            } else {
                gj();
            }
        }
    }

    private final void mj() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ViewUtilsKt.n(requireContext, R.string.f239107lk, R.string.f239057lf, Integer.valueOf(R.string.f215695wa), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DailySignFragment.nj(DailySignFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DailySignFragment.oj(dialogInterface, i3);
            }
        }, null, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nj(DailySignFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("DailySignFragment", 1, "exit dialog back");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(com.tencent.mobileqq.wink.lowthresholdltemplate.a data) {
        WinkPlayerContainerView winkPlayerContainerView;
        Integer num;
        Integer num2;
        ICutSession session;
        ICutSession session2;
        w53.b.a(getTAG(), "buildPreview: " + data.getWinkEditDataWrapper());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        WinkEditorResourceManager.a1().i0(data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
        WinkPlayerContainerView winkPlayerContainerView2 = this.mVideoContainerView;
        com.tencent.mobileqq.wink.dailysign.d dVar = null;
        if (winkPlayerContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerView");
            winkPlayerContainerView = null;
        } else {
            winkPlayerContainerView = winkPlayerContainerView2;
        }
        WinkVideoTavCut f16 = WinkPlayerContainerView.f(winkPlayerContainerView, data.getWinkTavCutParams(), new c(), null, false, null, 28, null);
        this.mVideoTavCut = f16;
        if (f16 != null) {
            f16.setAutoPlay(true);
        }
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.setLoopPlay(true);
        }
        WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
        if (winkVideoTavCut2 != null && (session2 = winkVideoTavCut2.getSession()) != null) {
            session2.setLoadAssetListener(this.loadAssetListener);
        }
        WinkVideoTavCut winkVideoTavCut3 = this.mVideoTavCut;
        if (winkVideoTavCut3 != null && (session = winkVideoTavCut3.getSession()) != null) {
            session.setCutStatusListener(new d());
        }
        WinkVideoTavCut winkVideoTavCut4 = this.mVideoTavCut;
        if (winkVideoTavCut4 != null) {
            winkVideoTavCut4.Q2(new e(elapsedRealtime));
        }
        WinkVideoTavCut winkVideoTavCut5 = this.mVideoTavCut;
        if (winkVideoTavCut5 != null) {
            num = Integer.valueOf(winkVideoTavCut5.getRenderHeight());
        } else {
            num = null;
        }
        WinkVideoTavCut winkVideoTavCut6 = this.mVideoTavCut;
        if (winkVideoTavCut6 != null) {
            num2 = Integer.valueOf(winkVideoTavCut6.getRenderWidth());
        } else {
            num2 = null;
        }
        jj(num, num2);
        com.tencent.mobileqq.wink.dailysign.d dVar2 = this.dailySignBottomPart;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignBottomPart");
        } else {
            dVar = dVar2;
        }
        dVar.G9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pj() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        if (qCircleCommonLoadingDialog == null) {
            qCircleCommonLoadingDialog = new QCircleCommonLoadingDialog.c(getContext()).n(false).e(new Runnable() { // from class: com.tencent.mobileqq.wink.dailysign.j
                @Override // java.lang.Runnable
                public final void run() {
                    DailySignFragment.qj(DailySignFragment.this);
                }
            }).p("\u52a0\u8f7d\u4e2d").a();
        }
        this.loadingDialog = qCircleCommonLoadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(View view, String eid, HashMap<String, String> extParams) {
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extParams != null) {
            buildElementParams.putAll(extParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qj(DailySignFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ri(WinkEditDataWrapper editDataWrapper) {
        int i3;
        boolean isBlank;
        List emptyList;
        ArrayList<ArrayList<WinkPublishMediaRecord>> arrayList = new ArrayList<>();
        for (WinkEditData winkEditData : editDataWrapper.getEditDatas()) {
            ArrayList<WinkPublishMediaRecord> arrayList2 = new ArrayList<>();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_DAILY_SIGN, emptyList));
            arrayList.add(arrayList2);
        }
        Ai().E2(arrayList);
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_BACKGROUND, Integer.valueOf(ti().getIsUseCustomBackground() ? 1 : 0));
        if (!ti().getIsUseCustomBackground()) {
            WinkDatongCurrentParams.put("xsj_background_id", ti().c2());
        }
        String currentEmotionName = ti().getCurrentEmotionName();
        if (currentEmotionName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(currentEmotionName);
            if (!isBlank) {
                i3 = 0;
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_EMOTION, Integer.valueOf(i3 ^ 1));
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME, ti().getCurrentEmotionName());
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_TEXT, Integer.valueOf(!ti().getIsRandomText() ? 1 : 0));
                if (!ti().getIsRandomText()) {
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PRESET_TEXT_ID, ti().getCurrentPresetTextId());
                    return;
                } else {
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUSTOM_TEXT_WORDNUMBER, Integer.valueOf(ti().getCustomTextLen()));
                    return;
                }
            }
        }
        i3 = 1;
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_EMOTION, Integer.valueOf(i3 ^ 1));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME, ti().getCurrentEmotionName());
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_TEXT, Integer.valueOf(!ti().getIsRandomText() ? 1 : 0));
        if (!ti().getIsRandomText()) {
        }
    }

    private final void rj() {
        WinkPlayerContainerView winkPlayerContainerView = this.mVideoContainerView;
        if (winkPlayerContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerView");
            winkPlayerContainerView = null;
        }
        winkPlayerContainerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.dailysign.e
            @Override // java.lang.Runnable
            public final void run() {
                DailySignFragment.sj(DailySignFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailySignConfig si() {
        return (DailySignConfig) this.config.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sj(DailySignFragment this$0) {
        Integer num;
        Integer num2;
        Integer num3;
        IPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.util.m mVar = com.tencent.mobileqq.wink.editor.util.m.f322645a;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Integer num4 = null;
        mVar.t(null, requireActivity);
        Pair<Integer, Integer> g16 = mVar.g(this$0.requireActivity());
        int intValue = g16.component1().intValue();
        int intValue2 = g16.component2().intValue();
        WinkVideoTavCut winkVideoTavCut = this$0.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.n0(intValue, intValue2);
        }
        WinkVideoTavCut winkVideoTavCut2 = this$0.mVideoTavCut;
        if (winkVideoTavCut2 != null) {
            Intrinsics.checkNotNull(winkVideoTavCut2);
            WinkVideoTavCut.a3(winkVideoTavCut2, winkVideoTavCut2.V(), false, 0L, 6, null);
        }
        WinkVideoTavCut winkVideoTavCut3 = this$0.mVideoTavCut;
        if (winkVideoTavCut3 != null) {
            winkVideoTavCut3.R(0);
        }
        WinkVideoTavCut winkVideoTavCut4 = this$0.mVideoTavCut;
        if (winkVideoTavCut4 != null && (currentPlayer = winkVideoTavCut4.getCurrentPlayer()) != null) {
            currentPlayer.requestRender();
        }
        WinkVideoTavCut winkVideoTavCut5 = this$0.mVideoTavCut;
        if (winkVideoTavCut5 != null) {
            num = Integer.valueOf(winkVideoTavCut5.getRenderHeight());
        } else {
            num = null;
        }
        WinkVideoTavCut winkVideoTavCut6 = this$0.mVideoTavCut;
        if (winkVideoTavCut6 != null) {
            num2 = Integer.valueOf(winkVideoTavCut6.getRenderWidth());
        } else {
            num2 = null;
        }
        this$0.jj(num, num2);
        String tag = this$0.getTAG();
        WinkVideoTavCut winkVideoTavCut7 = this$0.mVideoTavCut;
        if (winkVideoTavCut7 != null) {
            num3 = Integer.valueOf(winkVideoTavCut7.getRenderWidth());
        } else {
            num3 = null;
        }
        WinkVideoTavCut winkVideoTavCut8 = this$0.mVideoTavCut;
        if (winkVideoTavCut8 != null) {
            num4 = Integer.valueOf(winkVideoTavCut8.getRenderHeight());
        }
        w53.b.a(tag, "updateTavCut " + intValue + " " + intValue2 + " size: " + num3 + " " + num4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailySignViewModel ti() {
        Object value = this.dailySignViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dailySignViewModel>(...)");
        return (DailySignViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkExtractCoverViewModel vi() {
        Object value = this.mWinkExtractCoverViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkExtractCoverViewModel>(...)");
        return (WinkExtractCoverViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r53.a wi() {
        r53.a aVar;
        if (bj()) {
            aVar = this.musicMenuPartV2;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicMenuPartV2");
                return null;
            }
        } else {
            aVar = this.musicMenuPart;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicMenuPart");
                return null;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicVolumeControlViewModel yi() {
        return (MusicVolumeControlViewModel) this.musicVolumeViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pagerCallback = callback;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String curPageId, boolean isSelf) {
        LAKRenderModel u16;
        ICutSession session;
        ICutSession session2;
        Intrinsics.checkNotNullParameter(curPageId, "curPageId");
        FragmentPager.d.a.a(this, curPageId, isSelf);
        w53.b.a(getTAG(), "onPageSelected curPageId " + curPageId);
        this.isPageSelected = isSelf;
        if (isSelf && this.isCutInit) {
            ti().J2(true);
            w53.b.a(getTAG(), "reset render model");
            WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
            if (winkVideoTavCut != null && (u16 = winkVideoTavCut.u1()) != null) {
                WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
                if (winkVideoTavCut2 != null && (session2 = winkVideoTavCut2.getSession()) != null) {
                    session2.setRenderModel(u16);
                }
                WinkVideoTavCut winkVideoTavCut3 = this.mVideoTavCut;
                if (winkVideoTavCut3 != null && (session = winkVideoTavCut3.getSession()) != null) {
                    session.addSessionListener(new g());
                }
                WinkVideoTavCut winkVideoTavCut4 = this.mVideoTavCut;
                if (winkVideoTavCut4 != null) {
                    winkVideoTavCut4.c1(true);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.wink.dailysign.d dVar = new com.tencent.mobileqq.wink.dailysign.d();
        this.dailySignBottomPart = dVar;
        arrayList.add(dVar);
        WinkSlidMenuPart winkSlidMenuPart = new WinkSlidMenuPart();
        this.winkEmotionSlidMenuPart = winkSlidMenuPart;
        arrayList.add(winkSlidMenuPart);
        DailySignTextMenuPart dailySignTextMenuPart = new DailySignTextMenuPart();
        this.mTextEditPart = dailySignTextMenuPart;
        arrayList.add(dailySignTextMenuPart);
        if (bj()) {
            ak akVar = new ak();
            this.musicMenuPartV2 = akVar;
            arrayList.add(akVar);
            arrayList.add(new WinkMusicVolumeControlPart(this));
            arrayList.add(new WinkMusicLyricCropPart(this));
        } else {
            ah ahVar = new ah();
            this.musicMenuPart = ahVar;
            arrayList.add(ahVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169184i51;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "DailySignFragment";
    }

    @NotNull
    public final IPlayer.PlayerListener getPlayerListener() {
        return this.playerListener;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public final void initViewModel() {
        LiveData<Result<al>> o26 = ti().o2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends al>, Unit> function1 = new Function1<Result<? extends al>, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends al> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends al> it) {
                long j3;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!Result.m483isSuccessimpl(it.getValue())) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        DailySignFragment dailySignFragment = DailySignFragment.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        w53.b.d(dailySignFragment.getTAG(), "observa video prepare fail", m479exceptionOrNullimpl);
                        dailySignFragment.ti().J2(false);
                        dailySignFragment.ti().K2(true);
                    }
                    DailySignViewModel ti5 = DailySignFragment.this.ti();
                    j3 = DailySignFragment.this.startTime;
                    ti5.F2(j3, -1L, DailySignFragment.this.isFromTakeSame);
                    return;
                }
                DailySignFragment dailySignFragment2 = DailySignFragment.this;
                Object value = it.getValue();
                ResultKt.throwOnFailure(value);
                dailySignFragment2.fj((com.tencent.mobileqq.wink.lowthresholdltemplate.a) value);
            }
        };
        o26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Wi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> m26 = ti().m2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                WinkSlidMenuPart winkSlidMenuPart;
                winkSlidMenuPart = DailySignFragment.this.winkEmotionSlidMenuPart;
                if (winkSlidMenuPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkEmotionSlidMenuPart");
                    winkSlidMenuPart = null;
                }
                winkSlidMenuPart.Q9(null);
            }
        };
        m26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Xi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> j26 = ti().j2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            
                r3 = r2.this$0.loadingDialog;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean it) {
                boolean z16;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog2;
                z16 = DailySignFragment.this.isPageSelected;
                if (z16) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        DailySignFragment.this.pj();
                        return;
                    }
                    qCircleCommonLoadingDialog = DailySignFragment.this.loadingDialog;
                    boolean z17 = false;
                    if (qCircleCommonLoadingDialog != null && qCircleCommonLoadingDialog.isShowing()) {
                        z17 = true;
                    }
                    if (!z17 || qCircleCommonLoadingDialog2 == null) {
                        return;
                    }
                    qCircleCommonLoadingDialog2.dismiss();
                }
            }
        };
        j26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Yi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> n26 = ti().n2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                d dVar;
                LinearLayout linearLayout;
                LinearLayout linearLayout2;
                LinearLayout linearLayout3;
                dVar = DailySignFragment.this.dailySignBottomPart;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignBottomPart");
                    dVar = null;
                }
                dVar.I9(!it.booleanValue());
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    linearLayout3 = DailySignFragment.this.errorView;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorView");
                        linearLayout3 = null;
                    }
                    linearLayout3.setVisibility(0);
                    ConstraintLayout mRootView = DailySignFragment.this.getMRootView();
                    if (mRootView != null) {
                        mRootView.setVisibility(4);
                    }
                } else {
                    linearLayout = DailySignFragment.this.errorView;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("errorView");
                        linearLayout = null;
                    }
                    linearLayout.setVisibility(4);
                    ConstraintLayout mRootView2 = DailySignFragment.this.getMRootView();
                    if (mRootView2 != null) {
                        mRootView2.setVisibility(0);
                    }
                }
                DailySignFragment dailySignFragment = DailySignFragment.this;
                linearLayout2 = dailySignFragment.errorView;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorView");
                    linearLayout2 = null;
                }
                dailySignFragment.qi(linearLayout2, WinkDaTongReportConstant.ElementId.EM_XSJ_NO_NETWORK_PIC, null);
            }
        };
        n26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Zi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> r26 = ti().r2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DailySignTextMenuPart dailySignTextMenuPart;
                dailySignTextMenuPart = DailySignFragment.this.mTextEditPart;
                if (dailySignTextMenuPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextEditPart");
                    dailySignTextMenuPart = null;
                }
                dailySignTextMenuPart.jd(4);
            }
        };
        r26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ri(Function1.this, obj);
            }
        });
        MutableLiveData<MetaMaterial> l26 = ti().l2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<MetaMaterial, Unit> function16 = new Function1<MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaMaterial metaMaterial) {
                invoke2(metaMaterial);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetaMaterial mate) {
                HashMap<String, String> hashMapOf;
                String m3 = WinkEditorResourceManager.a1().m(mate);
                Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(mate)");
                List<String> g16 = l73.a.f413927a.g(m3);
                if (g16 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : g16) {
                        if (new File((String) obj).exists()) {
                            arrayList.add(obj);
                        }
                    }
                    String str = (String) arrayList.get(0);
                    if (str != null) {
                        DailySignFragment dailySignFragment = DailySignFragment.this;
                        JsonObject jsonObject = new JsonObject();
                        Intrinsics.checkNotNullExpressionValue(mate, "mate");
                        jsonObject.addProperty("enityName", com.tencent.mobileqq.wink.editor.c.a0(mate));
                        jsonObject.addProperty("path", str);
                        jsonObject.addProperty("moodName", mate.showName);
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("event.script.updateEmotion", String.valueOf(jsonObject)));
                        w53.b.a(dailySignFragment.getTAG(), "UPDATE_EMOTION map " + hashMapOf);
                        WinkVideoTavCut winkVideoTavCut = dailySignFragment.mVideoTavCut;
                        if (winkVideoTavCut != null) {
                            winkVideoTavCut.G2(hashMapOf);
                        }
                    }
                }
            }
        };
        l26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Si(Function1.this, obj);
            }
        });
        MutableLiveData<HashMap<String, Object>> b26 = ti().b2();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<HashMap<String, Object>, Unit> function17 = new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, Object> hashMap) {
                HashMap<String, String> hashMapOf;
                d dVar;
                w53.b.a(DailySignFragment.this.getTAG(), "updateBackPic path " + hashMap.get("path"));
                WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
                if (winkVideoTavCut != null) {
                    winkVideoTavCut.flush(true);
                }
                JsonObject jsonObject = new JsonObject();
                Object obj = hashMap.get("path");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                jsonObject.addProperty("path", (String) obj);
                Object obj2 = hashMap.get("isCustomPic");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                jsonObject.addProperty("isCustomPic", (Boolean) obj2);
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("event.script.updateBackPic", String.valueOf(jsonObject)));
                w53.b.a(DailySignFragment.this.getTAG(), "updateBackPic map " + hashMapOf);
                WinkVideoTavCut winkVideoTavCut2 = DailySignFragment.this.mVideoTavCut;
                if (winkVideoTavCut2 != null) {
                    winkVideoTavCut2.G2(hashMapOf);
                }
                dVar = DailySignFragment.this.dailySignBottomPart;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailySignBottomPart");
                    dVar = null;
                }
                dVar.G9();
            }
        };
        b26.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ti(Function1.this, obj);
            }
        });
        MutableLiveData<JSONObject> s26 = ti().s2();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        final Function1<JSONObject, Unit> function18 = new Function1<JSONObject, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject) {
                WinkEditData K1;
                HashMap<String, String> assetData;
                String str;
                WinkVideoTavCut winkVideoTavCut = DailySignFragment.this.mVideoTavCut;
                if (winkVideoTavCut == null || (K1 = winkVideoTavCut.K1()) == null || (assetData = K1.getAssetData()) == null || (str = assetData.get(LightConstants.EventKey.EVENT_SCRIPT_PARAMS)) == null) {
                    return;
                }
                DailySignFragment dailySignFragment = DailySignFragment.this;
                JSONObject jSONObject2 = new JSONObject(str);
                jSONObject2.put("updateText", jSONObject.toString());
                HashMap<String, String> hashMap = new HashMap<>();
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.toString()");
                hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, jSONObject3);
                w53.b.a(dailySignFragment.getTAG(), "updateText map " + hashMap);
                WinkVideoTavCut winkVideoTavCut2 = dailySignFragment.mVideoTavCut;
                if (winkVideoTavCut2 != null) {
                    winkVideoTavCut2.G2(hashMap);
                }
            }
        };
        s26.observe(viewLifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Ui(Function1.this, obj);
            }
        });
        LiveData<MenuSwitchAction> f36 = ((WinkEditorViewModel) getViewModel(WinkEditorViewModel.class)).f3();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        final Function1<MenuSwitchAction, Unit> function19 = new Function1<MenuSwitchAction, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.DailySignFragment$initViewModel$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuSwitchAction menuSwitchAction) {
                invoke2(menuSwitchAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MenuSwitchAction menuType) {
                FragmentPager.b bVar;
                ImageView imageView;
                WinkVideoTavCut winkVideoTavCut;
                WinkVideoTavCut winkVideoTavCut2;
                ImageView imageView2;
                Intrinsics.checkNotNullParameter(menuType, "menuType");
                MenuType menuType2 = menuType.getMenuType();
                MenuType menuType3 = MenuType.TEXT;
                boolean z16 = (menuType2 == menuType3 || menuType.getMenuType() == MenuType.MUSIC || menuType.getMenuType() == MenuType.STICKER) ? false : true;
                bVar = DailySignFragment.this.pagerCallback;
                if (bVar != null) {
                    bVar.a(z16);
                }
                ImageView imageView3 = null;
                if (z16) {
                    imageView2 = DailySignFragment.this.closeButton;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                    } else {
                        imageView3 = imageView2;
                    }
                    imageView3.setVisibility(0);
                } else {
                    imageView = DailySignFragment.this.closeButton;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                    } else {
                        imageView3 = imageView;
                    }
                    imageView3.setVisibility(4);
                }
                if (menuType.getMenuType() == menuType3 && (winkVideoTavCut2 = DailySignFragment.this.mVideoTavCut) != null) {
                    winkVideoTavCut2.pause();
                }
                if (menuType.getMenuType() != MenuType.BOTTOM_DASHBOARD || (winkVideoTavCut = DailySignFragment.this.mVideoTavCut) == null) {
                    return;
                }
                winkVideoTavCut.play();
            }
        };
        f36.observe(viewLifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailySignFragment.Vi(Function1.this, obj);
            }
        });
        Mi();
        Ci();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        boolean z16;
        Serializable serializable;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            FragmentActivity fragmentActivity = null;
            LocalMediaInfo localMediaInfo = null;
            if (data != null) {
                str = data.getStringExtra(AECameraConstants.FRAGMENT_RETURN_ACTION);
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER)) {
                    this.isFromPhotoPicker = true;
                    if (data != null) {
                        serializable = data.getSerializableExtra(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
                    } else {
                        serializable = null;
                    }
                    if (serializable instanceof LocalMediaInfo) {
                        localMediaInfo = (LocalMediaInfo) serializable;
                    }
                    if (localMediaInfo != null) {
                        w53.b.a("DailySignFragment", "path is: " + localMediaInfo.path);
                        DailySignViewModel ti5 = ti();
                        String str2 = localMediaInfo.path;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                        ti5.W1(str2, true);
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA)) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(QQWinkConstants.WINK_CAPTURE_FRAGMENT_IGNORE_BOTTOM_HEIGHT, true);
                    bundle.putInt("ability_flag", 2);
                    bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
                    bundle.putString("app_key", "00000QG6YX3X0LZH");
                    bundle.putBoolean("camera_direct_return_result", true);
                    bundle.putString("camera_fragment_tag", "DAILY_SIGN");
                    bundle.putInt("fragment_request_business_code", 100);
                    Context context = getContext();
                    if (context instanceof FragmentActivity) {
                        fragmentActivity = (FragmentActivity) context;
                    }
                    if (fragmentActivity != null) {
                        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAECameraFragment(fragmentActivity, bundle);
                    }
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        if (aj()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                supportFragmentManager.popBackStack();
                return true;
            }
            return true;
        }
        return cj();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        rj();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        w53.b.a(getTAG(), MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        this.loadAssetListener = dr.INSTANCE.b();
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        w53.b.a(getTAG(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.pause();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        WinkVideoTavCut winkVideoTavCut;
        WinkVideoTavCut winkVideoTavCut2;
        HashMap<String, String> hashMap;
        WinkEditData K1;
        w53.b.a(getTAG(), "onResume");
        super.onResume();
        this.isPageSelected = true;
        if (!this.isFromPhotoPicker && (winkVideoTavCut2 = this.mVideoTavCut) != null) {
            DailySignViewModel ti5 = ti();
            WinkVideoTavCut winkVideoTavCut3 = this.mVideoTavCut;
            if (winkVideoTavCut3 != null && (K1 = winkVideoTavCut3.K1()) != null) {
                hashMap = K1.getAssetData();
            } else {
                hashMap = null;
            }
            winkVideoTavCut2.G2(ti5.C2(false, hashMap));
        }
        this.isFromPhotoPicker = false;
        if (!aj() && (winkVideoTavCut = this.mVideoTavCut) != null) {
            winkVideoTavCut.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        View findViewById;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        WinkHomeReportHelper.f326257a.c(getActivity(), contentView, getPageId(), INSTANCE.a(si()));
        this.isFromTakeSame = "9".equals(requireActivity().getIntent().getStringExtra("AECAMERA_TAB_SELECTED"));
        this.mRootView = (ConstraintLayout) contentView.findViewById(R.id.f124687k1);
        if (getActivity() instanceof QQWinkActivity) {
            contentView.findViewById(R.id.adk).setVisibility(8);
        }
        View findViewById2 = contentView.findViewById(R.id.f25760bp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.playerContainer)");
        this.mVideoContainerView = (WinkPlayerContainerView) findViewById2;
        ((RoundCorneredRelativeLayout) contentView.findViewById(R.id.f25780br)).setRadius(0.0f, 0.0f, ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.dpToPx(16.0f));
        if (bj()) {
            findViewById = contentView.findViewById(R.id.zjq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "{\n            contentVie\u2026usicMenuItemV2)\n        }");
        } else {
            findViewById = contentView.findViewById(R.id.zjp);
            LyricStyleStickerImageVIew lyricStyleStickerImageVIew = ((MarqueeTextView) findViewById).getLyricStyleStickerImageVIew();
            if (lyricStyleStickerImageVIew != null) {
                lyricStyleStickerImageVIew.setState(2);
            }
            Intrinsics.checkNotNullExpressionValue(findViewById, "{\n            contentVie\u2026)\n            }\n        }");
        }
        this.musicMenuItem = findViewById;
        View findViewById3 = contentView.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById<ImageView>(R.id.close)");
        this.closeButton = (ImageView) findViewById3;
        com.tencent.mobileqq.wink.dailysign.d dVar = null;
        if (getActivity() instanceof QQWinkActivity) {
            ImageView imageView = this.closeButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.qui_chevron_left_icon_white);
        }
        ImageView imageView2 = this.closeButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailySignFragment.dj(DailySignFragment.this, view);
            }
        });
        View findViewById4 = contentView.findViewById(R.id.ypn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026.ll_online_asset_loading)");
        this.errorView = (LinearLayout) findViewById4;
        View findViewById5 = contentView.findViewById(R.id.f88404wz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.stickerControlView)");
        DailySignBorderView dailySignBorderView = (DailySignBorderView) findViewById5;
        this.dailySignBorderView = dailySignBorderView;
        if (dailySignBorderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
            dailySignBorderView = null;
        }
        dailySignBorderView.setonTouchClickCallBack(new h());
        ti().I2(si());
        Qi();
        initViewModel();
        Ei();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.wink.dailysign.x
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public final void onBackStackChanged() {
                    DailySignFragment.ej(DailySignFragment.this);
                }
            });
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
            supportFragmentManager.setFragmentResultListener("100", this, new i());
        }
        com.tencent.mobileqq.wink.dailysign.d dVar2 = this.dailySignBottomPart;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignBottomPart");
        } else {
            dVar = dVar2;
        }
        dVar.H9(new j());
    }

    @Nullable
    /* renamed from: ui, reason: from getter */
    public final ConstraintLayout getMRootView() {
        return this.mRootView;
    }

    @NotNull
    public final MusicSourceViewModel xi() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    @Nullable
    public final dr zi() {
        return this.mVideoTavCut;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oj(DialogInterface dialogInterface, int i3) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/dailysign/DailySignFragment$e", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements IRenderTimeListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f318082b;

        e(long j3) {
            this.f318082b = j3;
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
            DailySignFragment.this.ti().J2(false);
            DailySignFragment.this.ti().F2(DailySignFragment.this.si().getStartTime(), SystemClock.elapsedRealtime() - this.f318082b, DailySignFragment.this.isFromTakeSame);
            WinkPlayerContainerView winkPlayerContainerView = DailySignFragment.this.mVideoContainerView;
            DailySignBorderView dailySignBorderView = null;
            if (winkPlayerContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerView");
                winkPlayerContainerView = null;
            }
            w53.b.a(DailySignFragment.this.getTAG(), "buildPreview mVideoContainerView  " + winkPlayerContainerView.getMeasuredWidth() + " " + winkPlayerContainerView.getMeasuredHeight());
            DailySignBorderView dailySignBorderView2 = DailySignFragment.this.dailySignBorderView;
            if (dailySignBorderView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailySignBorderView");
            } else {
                dailySignBorderView = dailySignBorderView2;
            }
            w53.b.f(DailySignFragment.this.getTAG(), "buildPreview dailySignBorderView  " + dailySignBorderView.getMeasuredWidth() + " " + dailySignBorderView.getMeasuredHeight());
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
