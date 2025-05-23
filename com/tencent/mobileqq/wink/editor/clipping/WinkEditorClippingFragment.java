package com.tencent.mobileqq.wink.editor.clipping;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import c63.WinkTimelineSeekPlayerTimeData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment;
import com.tencent.mobileqq.wink.editor.clipping.dialog.WinkVideoClipVolumeControlDialog;
import com.tencent.mobileqq.wink.editor.clipping.dialog.a;
import com.tencent.mobileqq.wink.editor.clipping.model.WinkClippingTemplateMusicInfo;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.MusicDotBarView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.MusicDotModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.openingending.OpeningEndingAddBtnView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropFragment;
import com.tencent.mobileqq.wink.editor.crop.viewmodel.WinkEditorCropViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.VolumeValueCache;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.openingending.UpdateOpeningEndingData;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateFragment;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel;
import com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.extension.MediaClipUseType;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import e63.SelectItem;
import g63.CommonConfig;
import g63.LayoutConfig;
import g63.VideoTrackConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0010*\u0002\u0092\u0002\u0018\u0000 \u009e\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u009f\u0002\u00a0\u0002B\t\u00a2\u0006\u0006\b\u009c\u0002\u0010\u009d\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002JO\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010(\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0012\u00104\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0018H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\u0007H\u0003J\b\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00132\u0006\u0010?\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0013H\u0002J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0013H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020\u0007H\u0002J\b\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\b\u0010P\u001a\u00020\u0007H\u0002J\b\u0010Q\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\u0007H\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0002J\b\u0010X\u001a\u00020\u0007H\u0002J\b\u0010Y\u001a\u00020\u0007H\u0002J@\u0010b\u001a\u00020\u00072\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020\u00132\u0006\u00109\u001a\u0002082\u0006\u0010a\u001a\u00020\u0013H\u0002J\u0010\u0010d\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0015H\u0002J\b\u0010e\u001a\u00020\u0007H\u0002J\b\u0010f\u001a\u00020\u0013H\u0002J\b\u0010g\u001a\u00020\u0018H\u0002J\n\u0010i\u001a\u0004\u0018\u00010hH\u0002J\b\u0010j\u001a\u00020\u0013H\u0002J\b\u0010k\u001a\u00020\u0007H\u0002J\b\u0010l\u001a\u00020\u0007H\u0002J\u001e\u0010o\u001a\b\u0012\u0004\u0012\u00020m0%2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010%H\u0002J\u0010\u0010q\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0013H\u0002J\u0010\u0010t\u001a\u00020\u00072\u0006\u0010s\u001a\u00020rH\u0002J\u0010\u0010v\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0005H\u0002J\b\u0010w\u001a\u00020\u0007H\u0002J\b\u0010x\u001a\u00020\u0007H\u0002J\u0018\u0010|\u001a\u00020\u00072\u0006\u0010z\u001a\u00020y2\u0006\u0010{\u001a\u00020\u0013H\u0002J\u001a\u0010~\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010}\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010\u007f\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0013H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0083\u0001\u001a\u00020]H\u0014J\t\u0010\u0084\u0001\u001a\u00020]H\u0014J\u0010\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010%H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001J\t\u0010\u008a\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\u00072\u0007\u0010z\u001a\u00030\u008b\u0001H\u0016J'\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u008d\u0001\u001a\u00020]2\u0007\u0010\u008e\u0001\u001a\u00020]2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\u00072\u0007\u0010\u0092\u0001\u001a\u00020\u0013H\u0016J\u0007\u0010\u0094\u0001\u001a\u00020\u0018J\u0007\u0010\u0095\u0001\u001a\u00020\u0013R)\u0010\u009a\u0001\u001a\u0014\u0012\u0004\u0012\u0002080\u0096\u0001j\t\u0012\u0004\u0012\u000208`\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u00a1\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R!\u0010\u00a7\u0001\u001a\u00030\u00a2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R!\u0010\u00ac\u0001\u001a\u00030\u00a8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a9\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001R!\u0010\u00b1\u0001\u001a\u00030\u00ad\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R!\u0010\u00b6\u0001\u001a\u00030\u00b2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001R!\u0010\u00bb\u0001\u001a\u00030\u00b7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b8\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R!\u0010\u00c0\u0001\u001a\u00030\u00bc\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bd\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001R!\u0010\u00c5\u0001\u001a\u00030\u00c1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R!\u0010\u00ca\u0001\u001a\u00030\u00c6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00c9\u0001R!\u0010\u00cf\u0001\u001a\u00030\u00cb\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R!\u0010\u00d4\u0001\u001a\u00030\u00d0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d1\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00d2\u0001\u0010\u00d3\u0001R!\u0010\u00d9\u0001\u001a\u00030\u00d5\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d6\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001R!\u0010\u00de\u0001\u001a\u00030\u00da\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00db\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00dc\u0001\u0010\u00dd\u0001R\u001c\u0010\u00e2\u0001\u001a\u0005\u0018\u00010\u00df\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e0\u0001\u0010\u00e1\u0001R\u0019\u0010\u00e4\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00a0\u0001R\u0019\u0010\u00e6\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00b8\u0001R\u001c\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001R\u001c\u0010\u00ee\u0001\u001a\u0005\u0018\u00010\u00eb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ec\u0001\u0010\u00ed\u0001R\u0019\u0010\u00f0\u0001\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00b3\u0001R\u001b\u0010\u00f3\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u00f2\u0001Rd\u0010\u00f6\u0001\u001aM\u0012\u0004\u0012\u00020\u0018\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u00f4\u00010\u0017\u0018\u00010\u0017j.\u0012\u0004\u0012\u00020\u0018\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u00f4\u00010\u0017j\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u00f4\u0001`\u001a\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00f5\u0001R9\u0010\u00f8\u0001\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020m\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020m\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f7\u0001\u0010\u00f5\u0001R\u0019\u0010\u00fa\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f9\u0001\u0010\u00a0\u0001R/\u0010\u00fc\u0001\u001a\u0018\u0012\u0004\u0012\u000208\u0018\u00010\u0096\u0001j\u000b\u0012\u0004\u0012\u000208\u0018\u0001`\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fb\u0001\u0010\u0099\u0001R\u0019\u0010\u00fe\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00a0\u0001R\u0018\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ff\u0001\u0010\u00a0\u0001R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0019\u0010\u0085\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0002\u0010\u00a0\u0001R\u0018\u0010\u0089\u0002\u001a\u00030\u0086\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0018\u0010\u008d\u0002\u001a\u00030\u008a\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u0018\u0010\u0091\u0002\u001a\u00030\u008e\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0018\u0010\u0095\u0002\u001a\u00030\u0092\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0019\u0010\u0099\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0002\u0010\u00a0\u0001R\u0019\u0010\u009b\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0002\u0010\u00a0\u0001\u00a8\u0006\u00a1\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/h;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Lcom/tencent/mobileqq/wink/editor/a;", "Landroid/view/View;", "view", "", "Oj", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "ti", "Lcom/tencent/videocut/model/MediaModel;", "fj", "Lj", "", "musicVolume", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfoWrapper", "", "usingTemplate", "", "totalSelectDurationUs", "Ljava/util/HashMap;", "", "Lcom/tencent/videocut/model/AudioModel;", "Lkotlin/collections/HashMap;", "Xi", "(Ljava/lang/Float;Lcom/tencent/mobileqq/wink/editor/music/vo/b;ZJ)Ljava/util/HashMap;", "initView", "Ij", "mj", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "Bi", "Cj", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "videoTrackModelList", "zk", "isHidden", "ck", "pk", "ek", "cj", "Qj", "kj", "Gj", "Pj", "lj", "hidden", "uk", "zj", "selectedCategoryId", "mk", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "lk", "Uj", "Hj", "Ui", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "gk", "Mj", "Vj", "gj", "Jj", QCircleDaTongConstant.ElementParamValue.MANUAL, "dk", WidgetCacheLunarData.YI, "Yi", "aj", "Si", com.tencent.av.ui.ak.f75340i, "dj", "qk", "kk", "sk", "Ak", "Ck", "Dk", "rk", "Bk", "Ln73/a;", "result", "Ti", "tk", "xk", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "width", "", "textResId", "backgroundColorResId", "showIcon", "needExposeOpeningEndingTagView", "zi", "currentPlayTime", "yk", "xi", "Zj", "Ni", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Mi", "Yj", "nk", "wk", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "pickerMediaInfoList", "Ci", "isCancel", SensorJsPlugin.SENSOR_INTERVAL_UI, "Landroid/os/Bundle;", "args", "Ri", "contentView", "registerDaTongReportPageId", "hk", "vi", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/n;", "event", "smartClipEnabled", "wi", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onHiddenChanged", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onDestroyView", "getStatusBarColor", "getContentLayoutId", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$a;", "addClipInterceptor", "fk", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "Jc", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isChildShow", "g1", "getPageId", "handleBackEvent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mediaClips", "Lcom/tencent/videocut/model/BackgroundModel;", "D", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "E", "Z", "isUserPlayOrPausing", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Pi", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/d;", "G", "Li", "()Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/d;", "smartClipViewModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/b;", "H", "Ei", "()Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/b;", "editSegClipViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "I", "Gi", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "J", "Hi", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeControlViewModel", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "K", "Di", "()Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "cropViewModel", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "L", "Ji", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "openingEndingViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "M", "Ki", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "panelController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "N", "Qi", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "videoTrackController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "P", "Oi", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "timeBarViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Fi", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/a;", "musicDotBarViewController", "Lh63/a;", BdhLogUtil.LogTag.Tag_Req, "Ii", "()Lh63/a;", "openingEndingAddBtnController", "Lm63/d;", ExifInterface.LATITUDE_SOUTH, "Lm63/d;", "winkEffectTimeLineViewModel", "T", "isSmartClipBtnEnable", "U", "stepToCropPlayTime", "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/a;", "V", "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/a;", "setSpeedDialog", "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog;", "W", "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog;", "volumeControlDialog", "X", "volumeDialogClipIndex", "Y", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "mBgmSource", "Ljava/io/Serializable;", "Ljava/util/HashMap;", "clipMediaExtInfo", "a0", "clipAddedMediaInfo", "b0", "isVolumeChanged", "c0", "originMediaClips", "d0", "tavcutInited", "e0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "f0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "mPlayerStateOnDeleteDialogPopup", "g0", "isChangedAfterCrop", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "h0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", "i0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", "reorderListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "j0", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$k", "k0", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$k;", "volumeDialogSeekBarListener", "l0", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$a;", "m0", "needReplay", "n0", "isLastAddClipReady", "<init>", "()V", "p0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorClippingFragment extends ImmersivePartFragment implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h, IWinkCrashReportCallback, com.tencent.mobileqq.wink.editor.a {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isUserPlayOrPausing;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy smartClipViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy editSegClipViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeControlViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy openingEndingViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy panelController;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoTrackController;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy timeBarViewController;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicDotBarViewController;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy openingEndingAddBtnController;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private m63.d winkEffectTimeLineViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isSmartClipBtnEnable;

    /* renamed from: U, reason: from kotlin metadata */
    private long stepToCropPlayTime;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.dialog.a setSpeedDialog;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private WinkVideoClipVolumeControlDialog volumeControlDialog;

    /* renamed from: X, reason: from kotlin metadata */
    private int volumeDialogClipIndex;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private MusicInfoWrapper mBgmSource;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, HashMap<String, Serializable>> clipMediaExtInfo;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, LocalMediaInfo> clipAddedMediaInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isVolumeChanged;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<MediaClip> originMediaClips;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean tavcutInited;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean needExposeOpeningEndingTagView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer.PlayerStatus mPlayerStateOnDeleteDialogPopup;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isChangedAfterCrop;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.k reorderListener;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k volumeDialogSeekBarListener;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a addClipInterceptor;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean needReplay;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isLastAddClipReady;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319115o0 = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<MediaClip> mediaClips = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private BackgroundModel backgroundModel = new BackgroundModel(null, null, null, null, null, null, null, null, 0.0f, 0, null, 2047, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$a;", "", "Ljava/lang/Runnable;", "onConfirm", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        boolean a(@NotNull Runnable onConfirm);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f319118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorClippingFragment f319119e;

        d(FrameLayout frameLayout, WinkEditorClippingFragment winkEditorClippingFragment) {
            this.f319118d = frameLayout;
            this.f319119e = winkEditorClippingFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorClippingFragment this$0, FrameLayout frameLayout) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
            List ti5 = this$0.ti();
            Boolean bool = Boolean.FALSE;
            int width = frameLayout.getWidth();
            int height = frameLayout.getHeight();
            Boolean isOpenFFmpegDecode = u53.i.f438428a;
            Intrinsics.checkNotNullExpressionValue(isOpenFFmpegDecode, "isOpenFFmpegDecode");
            boolean booleanValue = isOpenFFmpegDecode.booleanValue();
            Integer softDecodeThreadCnt = u53.i.f438429b;
            Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
            TimelineViewModelV2.S2(this$0.Pi(), this$0, frameLayout, new dr.WinkTavCutParams(false, editMode, ti5, null, bool, width, height, null, null, booleanValue, softDecodeThreadCnt.intValue(), Long.MAX_VALUE, false, false, null, WinkTavCutScene.Clipping, true, false, 0, 0, false, null, 3960832, null), this$0.playerListener, this$0.renderListener, false, false, true, 0L, null, 768, null);
            this$0.Lj();
            this$0.mj();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f319118d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Handler d16 = com.tencent.qav.thread.a.d();
            final WinkEditorClippingFragment winkEditorClippingFragment = this.f319119e;
            final FrameLayout frameLayout = this.f319118d;
            d16.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.ao
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorClippingFragment.d.b(WinkEditorClippingFragment.this, frameLayout);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/a;", "", "uuid", "Landroid/graphics/Point;", "touchPoint", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a
        public void a(@NotNull String uuid, @NotNull Point touchPoint) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
            WinkEditorClippingFragment.this.Pi().b3();
            WinkEditorClippingFragment.this.reorderListener.b(uuid, touchPoint);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$f", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/c;", "", "onCompleted", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.c
        public void onCompleted() {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_TIMELINE_GENERATE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$h", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements IPlayer.PlayerListener {
        h() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            if (!WinkEditorClippingFragment.this.Pi().getIsDraggingSlider() && !WinkEditorClippingFragment.this.Pi().getIsDraggingSliderForRenderListener()) {
                long curTargetTime = WinkEditorClippingFragment.this.Pi().getCurTargetTime();
                if (curTargetTime >= 0 && curTargetTime == currentDurationUs) {
                    WinkEditorClippingFragment.this.Pi().j3(-1L);
                }
                if (WinkEditorClippingFragment.this.isUserPlayOrPausing) {
                    ms.a.a("WinkEditorClippingFragment", "\u7528\u6237\u6682\u505c/\u64ad\u653e\u8fc7\u7a0b\u4e2d\uff0c\u8fdb\u5ea6\u56de\u8c03\u53ef\u4ee5\u4e0d\u7528\u5f71\u54cdUI\u3002");
                    return;
                }
                if (WinkEditorClippingFragment.this.Pi().getCurTargetTime() < 0 || (WinkEditorClippingFragment.this.Pi().getCurTargetTime() > 0 && WinkEditorClippingFragment.this.Pi().getCurTargetTime() == currentDurationUs)) {
                    if (com.tencent.videocut.utils.thread.c.f384289c.a()) {
                        WinkEditorClippingFragment.this.Pi().m2().setValue(Long.valueOf(currentDurationUs));
                    } else {
                        WinkEditorClippingFragment.this.Pi().m2().postValue(Long.valueOf(currentDurationUs));
                    }
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            IPlayer.PlayerStatus playerStatus = IPlayer.PlayerStatus.PLAYING;
            if (status == playerStatus) {
                ((ImageView) WinkEditorClippingFragment.this.ai(R.id.xyv)).setImageResource(R.drawable.oqq);
            } else if (status == IPlayer.PlayerStatus.PAUSED) {
                ((ImageView) WinkEditorClippingFragment.this.ai(R.id.xyv)).setImageResource(R.drawable.oqs);
            }
            if (!WinkEditorClippingFragment.this.Pi().getIsDraggingSlider()) {
                WinkEditorClippingFragment.this.isUserPlayOrPausing = false;
                WinkEditorClippingFragment.this.Pi().l2().postValue(status);
                if (status == playerStatus) {
                    WinkEditorClippingFragment.this.Pi().p3(true);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$j", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", "", "uuid", "Landroid/graphics/Point;", "point", "", "b", "", "targetIndex", "a", "I", "c", "()I", "setDragIndex", "(I)V", "dragIndex", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class j implements com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int dragIndex = -1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$j$a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/b;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WinkEditorClippingFragment f319125d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ j f319126e;

            a(WinkEditorClippingFragment winkEditorClippingFragment, j jVar) {
                this.f319125d = winkEditorClippingFragment;
                this.f319126e = jVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                boolean z16;
                Intrinsics.checkNotNullParameter(animation, "animation");
                VideoTrackContainerView n3 = this.f319125d.Qi().n();
                if (n3 != null && n3.getHasUpEvent()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    WinkEditorClippingFragment.vk(this.f319125d, false, 1, null);
                    return;
                }
                ((ReorderContainerView) this.f319125d.ai(R.id.f72983sb)).setVisibility(0);
                ((ReorderContainerView) this.f319125d.ai(R.id.f72983sb)).S(this.f319126e.getDragIndex());
                VideoTrackContainerView n16 = this.f319125d.Qi().n();
                if (n16 != null) {
                    n16.setVisibility(4);
                }
                this.f319125d.Oi().s(false);
                this.f319125d.Ki().B(false);
                VideoTrackContainerView n17 = this.f319125d.Qi().n();
                if (n17 != null) {
                    n17.setHandleView((ReorderContainerView) this.f319125d.ai(R.id.f72983sb));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation, boolean isReverse) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        j() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.k
        public void a(@NotNull String uuid, int targetIndex) {
            Object first;
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            WinkEditorClippingFragment.vk(WinkEditorClippingFragment.this, false, 1, null);
            ((ReorderContainerView) WinkEditorClippingFragment.this.ai(R.id.f72983sb)).setVisibility(4);
            WinkEditorClippingFragment.this.Oi().s(true);
            WinkEditorClippingFragment.this.Ki().B(true);
            VideoTrackContainerView n3 = WinkEditorClippingFragment.this.Qi().n();
            if (n3 != null) {
                n3.setVisibility(0);
                n3.a0();
                n3.setHandleView(null);
            }
            if (this.dragIndex != targetIndex && targetIndex >= 0) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) WinkEditorClippingFragment.this.Pi().u2());
                if (com.tencent.videocut.render.extension.e.r((MediaClip) first) == MediaClipUseType.OPENING) {
                    targetIndex++;
                }
                WinkEditorClippingFragment.this.Pi().D2(uuid, targetIndex, !WinkEditorClippingFragment.this.Li().getIsOpenSmartClip());
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.k
        public void b(@NotNull String uuid, @NotNull Point point) {
            List<VideoTrackTimelineView> list;
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(point, "point");
            int Q = ((ReorderContainerView) WinkEditorClippingFragment.this.ai(R.id.f72983sb)).Q(uuid, point);
            this.dragIndex = Q;
            if (Q == -1 || WinkEditorClippingFragment.this.Qi().n() == null) {
                return;
            }
            VideoTrackContainerView n3 = WinkEditorClippingFragment.this.Qi().n();
            if (n3 != null) {
                list = n3.U();
            } else {
                list = null;
            }
            int i3 = point.x;
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            Animator a16 = com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.l.f319312a.a(list, this.dragIndex, i3 - eVar.a(16.0f), eVar.a(72.0f));
            a16.setDuration(200L);
            VideoTrackContainerView n16 = WinkEditorClippingFragment.this.Qi().n();
            if (n16 != null) {
                n16.l0();
            }
            a16.addListener(new a(WinkEditorClippingFragment.this, this));
            a16.start();
            WinkEditorClippingFragment.this.uk(true);
        }

        /* renamed from: c, reason: from getter */
        public final int getDragIndex() {
            return this.dragIndex;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$k", "Lcom/tencent/mobileqq/wink/editor/clipping/dialog/WinkVideoClipVolumeControlDialog$b;", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class k implements WinkVideoClipVolumeControlDialog.b {
        k() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.dialog.WinkVideoClipVolumeControlDialog.b
        public void a(float volume) {
            Map<Integer, Float> mapOf;
            TimelineViewModelV2 Pi = WinkEditorClippingFragment.this.Pi();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Integer.valueOf(WinkEditorClippingFragment.this.volumeDialogClipIndex), Float.valueOf(volume)));
            Pi.L3(mapOf, true);
            WinkEditorClippingFragment.this.Pi().w3();
            WinkEditorClippingFragment.this.isVolumeChanged = true;
        }
    }

    public WinkEditorClippingFragment() {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelineViewModelV2 invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this).get(TimelineViewModelV2.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026eViewModelV2::class.java)");
                return (TimelineViewModelV2) viewModel;
            }
        });
        this.timelineViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$smartClipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026lipViewModel::class.java)");
                return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d) viewModel;
            }
        });
        this.smartClipViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$editSegClipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026lipViewModel::class.java)");
                return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b) viewModel;
            }
        });
        this.editSegClipViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026rceViewModel::class.java)");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$musicVolumeControlViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026rolViewModel::class.java)");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.musicVolumeControlViewModel = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorCropViewModel>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorCropViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(WinkEditorCropViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026ropViewModel::class.java)");
                return (WinkEditorCropViewModel) viewModel;
            }
        });
        this.cropViewModel = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$openingEndingViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorClippingFragment.this.requireActivity()).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.openingEndingViewModel = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TimelinePanelViewController>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$panelController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelinePanelViewController invoke() {
                return new TimelinePanelViewController();
            }
        });
        this.panelController = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$videoTrackController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l invoke() {
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
            }
        });
        this.videoTrackController = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$timeBarViewController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a invoke() {
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a();
            }
        });
        this.timeBarViewController = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$musicDotBarViewController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a invoke() {
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a();
            }
        });
        this.musicDotBarViewController = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<h63.a>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$openingEndingAddBtnController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h63.a invoke() {
                return new h63.a();
            }
        });
        this.openingEndingAddBtnController = lazy12;
        this.volumeDialogClipIndex = -1;
        this.needExposeOpeningEndingTagView = true;
        this.playerListener = new h();
        this.reorderListener = new j();
        this.renderListener = new i();
        this.volumeDialogSeekBarListener = new k();
        this.needReplay = true;
        this.isLastAddClipReady = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(MediaClip mediaClip, WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(mediaClip, "$mediaClip");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.videocut.render.extension.e.k(mediaClip) == null) {
            this$0.Ji().E2(this$0.getActivity(), mediaClip, true);
        } else {
            this$0.Pi().b3();
            this$0.lk(mediaClip);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mk("opening");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ak() {
        MediaClipUseType mediaClipUseType;
        boolean z16;
        MediaClip k26 = Pi().k2();
        if (k26 != null) {
            mediaClipUseType = com.tencent.videocut.render.extension.e.r(k26);
        } else {
            mediaClipUseType = null;
        }
        if (mediaClipUseType == MediaClipUseType.NORMAL) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((RelativeLayout) ai(R.id.f75263yh)).setClickable(z16);
        if (z16) {
            ((ImageView) ai(R.id.xyz)).setImageResource(R.drawable.nqx);
            ((TextView) ai(R.id.f1055666c)).setTextColor(getResources().getColor(R.color.f158017al3));
        } else {
            ((ImageView) ai(R.id.xyz)).setImageResource(R.drawable.nqw);
            ((TextView) ai(R.id.f1055666c)).setTextColor(getResources().getColor(R.color.ala));
        }
    }

    private final WinkEditorFragment Bi(Fragment fragment) {
        if (fragment instanceof WinkEditorFragment) {
            return (WinkEditorFragment) fragment;
        }
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            return null;
        }
        return Bi(parentFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mk("ending");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Bk() {
        boolean z16;
        boolean z17 = false;
        if (Li().P1() <= 1 && com.tencent.videocut.render.extension.e.w(Pi().u2()).size() <= 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean Yj = Yj();
        if ((z16 || Yj) && Li().L1()) {
            z17 = true;
        }
        this.isSmartClipBtnEnable = z17;
        if (z17) {
            if (Li().getIsOpenSmartClip()) {
                ((ImageView) ai(R.id.f165887xz2)).setImageResource(R.drawable.opn);
                ((TextView) ai(R.id.f1055966f)).setTextColor(getResources().getColor(R.color.f158017al3));
                return;
            } else {
                ((ImageView) ai(R.id.f165887xz2)).setImageResource(R.drawable.opl);
                ((TextView) ai(R.id.f1055966f)).setTextColor(getResources().getColor(R.color.f158017al3));
                return;
            }
        }
        ((ImageView) ai(R.id.f165887xz2)).setImageResource(R.drawable.opm);
        ((TextView) ai(R.id.f1055966f)).setTextColor(getResources().getColor(R.color.ala));
    }

    private final List<LocalMediaInfo> Ci(List<? extends LocalMediaInfo> pickerMediaInfoList) {
        ArrayList arrayList = new ArrayList();
        if (pickerMediaInfoList != null) {
            Iterator<T> it = pickerMediaInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mobileqq.wink.utils.o.f326724a.k((LocalMediaInfo) it.next()));
            }
        }
        return arrayList;
    }

    private final void Cj() {
        LiveData<Boolean> s26 = Ji().s2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$initOpeningEndingObserver$1
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
            public final void invoke2(Boolean isFromClipping) {
                Intrinsics.checkNotNullExpressionValue(isFromClipping, "isFromClipping");
                if (isFromClipping.booleanValue()) {
                    WinkEditorClippingFragment.this.Pi().c3();
                }
            }
        };
        s26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.Dj(Function1.this, obj);
            }
        });
        LiveData<Pair<Boolean, Boolean>> q26 = Ji().q2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> function12 = new Function1<Pair<? extends Boolean, ? extends Boolean>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$initOpeningEndingObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
                invoke2((Pair<Boolean, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, Boolean> pair) {
                boolean booleanValue = pair.component1().booleanValue();
                boolean booleanValue2 = pair.component2().booleanValue();
                if (!booleanValue || booleanValue2) {
                    return;
                }
                WinkEditorClippingFragment.this.Pi().c3();
            }
        };
        q26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.Ej(Function1.this, obj);
            }
        });
        LiveData<UpdateOpeningEndingData> x26 = Ji().x2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<UpdateOpeningEndingData, Unit> function13 = new Function1<UpdateOpeningEndingData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$initOpeningEndingObserver$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateOpeningEndingData updateOpeningEndingData) {
                invoke2(updateOpeningEndingData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateOpeningEndingData updateInfo) {
                WinkEditorClippingFragment.this.needExposeOpeningEndingTagView = true;
                if (updateInfo.getIsFromClipping()) {
                    TimelineViewModelV2 Pi = WinkEditorClippingFragment.this.Pi();
                    Intrinsics.checkNotNullExpressionValue(updateInfo, "updateInfo");
                    Pi.C3(updateInfo);
                    WinkEditorClippingFragment.vk(WinkEditorClippingFragment.this, false, 1, null);
                }
            }
        };
        x26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.Fj(Function1.this, obj);
            }
        });
        vk(this, false, 1, null);
    }

    private final void Ck() {
        boolean z16;
        if (Pi().x2().getValue() != null && Pi().h2() != null && Pi().h2() == MediaType.VIDEO) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((RelativeLayout) ai(R.id.f75293yk)) != null) {
            ((RelativeLayout) ai(R.id.f75293yk)).setClickable(z16);
            if (z16) {
                ((ImageView) ai(R.id.f165888xz3)).setImageResource(R.drawable.f162068ns4);
                ((TextView) ai(R.id.f1056066g)).setTextColor(getResources().getColor(R.color.f158017al3));
                return;
            }
            ((ImageView) ai(R.id.f165888xz3)).setImageResource(R.drawable.or7);
            ((TextView) ai(R.id.f1056066g)).setTextColor(getResources().getColor(R.color.ala));
            com.tencent.mobileqq.wink.editor.clipping.dialog.a aVar = this.setSpeedDialog;
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
        }
    }

    private final WinkEditorCropViewModel Di() {
        return (WinkEditorCropViewModel) this.cropViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Dk() {
        boolean z16;
        if (Pi().h2() == MediaType.VIDEO) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((RelativeLayout) ai(R.id.f75303yl)).setClickable(z16);
        if (z16) {
            ((ImageView) ai(R.id.xzk)).setImageResource(R.drawable.f162062ns1);
            ((TextView) ai(R.id.f1057366t)).setTextColor(getResources().getColor(R.color.f158017al3));
        } else {
            ((ImageView) ai(R.id.xzk)).setImageResource(R.drawable.nrz);
            ((TextView) ai(R.id.f1057366t)).setTextColor(getResources().getColor(R.color.ala));
        }
    }

    private final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b Ei() {
        return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b) this.editSegClipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ej(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a Fi() {
        return (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a) this.musicDotBarViewController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final MusicSourceViewModel Gi() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    private final void Gj() {
        TimelinePanelViewController Ki = Ki();
        TimelinePanel timelinePanel = (TimelinePanel) ai(R.id.f97405ka);
        Intrinsics.checkNotNullExpressionValue(timelinePanel, "timelinePanel");
        Ki.j(timelinePanel);
        Ki().w(new CommonConfig(null, new LayoutConfig(0, 10.0f, 0.0f, 0.0f, 0.0f, 0, 61, null), new VideoTrackConfig(0.0f, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, false, false, true, 247, null), null, 9, null));
        Ki().r();
        Ki().getPanelEventHandler().b(this, new Function1<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment$initPanelView$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g panelEvent) {
                Intrinsics.checkNotNullParameter(panelEvent, "panelEvent");
                return Boolean.valueOf((panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.f) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e) || (panelEvent instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d));
            }
        });
    }

    private final MusicVolumeControlViewModel Hi() {
        return (MusicVolumeControlViewModel) this.musicVolumeControlViewModel.getValue();
    }

    private final void Hj() {
        ((ReorderContainerView) ai(R.id.f72983sb)).P(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
        ((ReorderContainerView) ai(R.id.f72983sb)).setReorderListener(this.reorderListener);
    }

    private final h63.a Ii() {
        return (h63.a) this.openingEndingAddBtnController.getValue();
    }

    private final void Ij() {
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75193ya), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_DELETE_BUTTON);
        RelativeLayout relativeLayout = (RelativeLayout) ai(R.id.f75193ya);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(relativeLayout, clickPolicy);
        RelativeLayout relativeLayout2 = (RelativeLayout) ai(R.id.f75193ya);
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(relativeLayout2, exposurePolicy);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75273yi), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_ADJUST_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75273yi), clickPolicy);
        VideoReport.setElementExposePolicy((RelativeLayout) ai(R.id.f75273yi), exposurePolicy);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75263yh), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_SEPARATE_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75263yh), clickPolicy);
        VideoReport.setElementExposePolicy((RelativeLayout) ai(R.id.f75263yh), exposurePolicy);
        VideoReport.setElementId((ImageView) ai(R.id.xyk), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_FINISH);
        VideoReport.setElementClickPolicy((ImageView) ai(R.id.xyk), clickPolicy);
        VideoReport.setElementExposePolicy((ImageView) ai(R.id.xyk), exposurePolicy);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75293yk), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_SPEED_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75293yk), clickPolicy);
        VideoReport.setElementExposePolicy((RelativeLayout) ai(R.id.f75293yk), exposurePolicy);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75183y_), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_CROP_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75183y_), clickPolicy);
        RelativeLayout relativeLayout3 = (RelativeLayout) ai(R.id.f75183y_);
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(relativeLayout3, exposurePolicy2);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75283yj), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_MUSIC_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75283yj), clickPolicy);
        VideoReport.setElementExposePolicy((RelativeLayout) ai(R.id.f75283yj), exposurePolicy);
        VideoReport.setElementId((RelativeLayout) ai(R.id.f75303yl), WinkDaTongReportConstant.ElementId.EM_XSJ_VOLUME_BUTTON);
        VideoReport.setElementClickPolicy((RelativeLayout) ai(R.id.f75303yl), clickPolicy);
        VideoReport.setElementExposePolicy((RelativeLayout) ai(R.id.f75303yl), exposurePolicy2);
    }

    private final WinkEditorOpeningEndingViewModel Ji() {
        return (WinkEditorOpeningEndingViewModel) this.openingEndingViewModel.getValue();
    }

    private final void Jj() {
        ((RelativeLayout) ai(R.id.f75283yj)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Kj(WinkEditorClippingFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelinePanelViewController Ki() {
        return (TimelinePanelViewController) this.panelController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSmartClipBtnEnable) {
            this$0.Qi().i().g();
            if (!this$0.Li().getIsOpenSmartClip()) {
                this$0.dk(true);
                RelativeLayout rlSmartClip = (RelativeLayout) this$0.ai(R.id.f75283yj);
                Intrinsics.checkNotNullExpressionValue(rlSmartClip, "rlSmartClip");
                d63.b.b(this$0, rlSmartClip, true);
            } else {
                this$0.yi(true);
                RelativeLayout rlSmartClip2 = (RelativeLayout) this$0.ai(R.id.f75283yj);
                Intrinsics.checkNotNullExpressionValue(rlSmartClip2, "rlSmartClip");
                d63.b.b(this$0, rlSmartClip2, false);
            }
            this$0.Pi().m3(true);
        } else if (com.tencent.videocut.render.extension.e.w(this$0.Pi().u2()).size() <= 1) {
            QQToast.makeText(this$0.requireContext(), R.string.f215385vg, 0).show();
        } else if (!this$0.Li().T1()) {
            QQToast.makeText(this$0.requireContext(), R.string.f215435vl, 0).show();
        } else if (!this$0.Li().U1()) {
            QQToast.makeText(this$0.requireContext(), R.string.f241377rp, 0).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d Li() {
        return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d) this.smartClipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lj() {
        WinkEditorMusicInfo winkEditorMusicInfo;
        MusicInfoWrapper musicInfoWrapper = this.mBgmSource;
        MusicInfoWrapper musicInfoWrapper2 = null;
        if (musicInfoWrapper != null) {
            winkEditorMusicInfo = musicInfoWrapper.getMusicInfo();
        } else {
            winkEditorMusicInfo = null;
        }
        if (winkEditorMusicInfo != null) {
            musicInfoWrapper2 = this.mBgmSource;
        }
        Li().W1(musicInfoWrapper2, Pi().u2(), Zj(), Ni(), Mi(), Yj());
        Li().k2(this.mediaClips);
    }

    private final MetaMaterial Mi() {
        Serializable serializable = requireArguments().getSerializable(QQWinkConstants.TEMPLATE_MATERIAL);
        if (serializable instanceof MetaMaterial) {
            return (MetaMaterial) serializable;
        }
        return null;
    }

    private final void Mj() {
        ((RelativeLayout) ai(R.id.f75293yk)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Nj(WinkEditorClippingFragment.this, view);
            }
        });
        Ck();
    }

    private final String Ni() {
        String string = requireArguments().getString(QQWinkConstants.TEMPLATE_PATH, "");
        if (string == null) {
            return "";
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.nk();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a Oi() {
        return (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a) this.timeBarViewController.getValue();
    }

    private final void Oj(View view) {
        ms.a.f("WinkEditorClippingFragment", "initTavCut");
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.v8h);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new d(frameLayout, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 Pi() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    private final void Pj() {
        TimeBarView timeBarView = new TimeBarView(getContext(), null, 0, 6, null);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(20.0f));
        layoutParams.topMargin = eVar.a(12.0f);
        timeBarView.setLayoutParams(layoutParams);
        timeBarView.setMaxDurationLimit(WinkConfig.f317649a.b());
        String string = requireContext().getString(R.string.f215355vd);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026ink_cut_max_duration_tip)");
        timeBarView.setMaxDurationLimitTip(string);
        Oi().g(timeBarView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l Qi() {
        return (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l) this.videoTrackController.getValue();
    }

    private final void Qj() {
        ((ImageView) ai(R.id.xyi)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Rj(WinkEditorClippingFragment.this, view);
            }
        });
        ((ImageView) ai(R.id.xyk)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Sj(WinkEditorClippingFragment.this, view);
            }
        });
        ((ImageView) ai(R.id.xyv)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Tj(WinkEditorClippingFragment.this, view);
            }
        });
    }

    private final void Ri(Bundle args) {
        com.tencent.mobileqq.wink.editor.a aVar;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof WinkEditorFragment) {
            WinkEditorFragment winkEditorFragment = (WinkEditorFragment) parentFragment;
            if (winkEditorFragment.getArguments() == null) {
                winkEditorFragment.setArguments(new Bundle());
            }
            winkEditorFragment.requireArguments().putAll(args);
            ActivityResultCaller parentFragment2 = getParentFragment();
            if (parentFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) parentFragment2;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.g1(false);
            }
            getParentFragmentManager().beginTransaction().hide(this).commit();
            return;
        }
        if (getActivity() != null) {
            requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("WinkEditorClippingFragment_cancel", 500L)) {
            if (this$0.Pi().getHasChanged()) {
                this$0.hk();
            } else {
                if (this$0.getArguments() == null) {
                    this$0.setArguments(new Bundle());
                }
                this$0.requireArguments().putBoolean(QQWinkConstants.IS_FROM_CLIP, true);
                this$0.requireArguments().putParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL, null);
                this$0.Ri(new Bundle(this$0.getArguments()));
                this$0.ui(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Si() {
        if (Pi().x2().getValue() != null && getActivity() != null) {
            Pi().b3();
            Pi().N2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sj(WinkEditorClippingFragment this$0, View view) {
        boolean z16;
        int collectionSizeOrDefault;
        String str;
        boolean z17;
        boolean z18;
        Float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Pi().j2() < 2000000) {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), R.string.f215375vf, 0).show();
        } else {
            if (this$0.Li().T1() && this$0.Li().U1()) {
                com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip = this$0.Li().getIsOpenSmartClip();
            }
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip = this$0.Li().getIsUserOpCloseSmartClip();
            if (this$0.getArguments() == null) {
                this$0.setArguments(new Bundle());
            }
            ArrayList<MediaClip> p26 = this$0.Pi().p2();
            this$0.requireArguments().putParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL, p26);
            if (!p26.isEmpty()) {
                if (this$0.originMediaClips != null && (!r2.isEmpty())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ArrayList<MediaClip> arrayList = this$0.originMediaClips;
                    if (arrayList != null && arrayList.size() == p26.size()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18 && !this$0.isVolumeChanged) {
                        ArrayList<MediaClip> arrayList2 = this$0.originMediaClips;
                        if (arrayList2 != null) {
                            Iterator<T> it = arrayList2.iterator();
                            if (it.hasNext()) {
                                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                                if (resourceModel != null) {
                                    f19 = resourceModel.volume;
                                } else {
                                    f19 = 0.0f;
                                }
                                while (it.hasNext()) {
                                    ResourceModel resourceModel2 = ((MediaClip) it.next()).resource;
                                    if (resourceModel2 != null) {
                                        f26 = resourceModel2.volume;
                                    } else {
                                        f26 = 0.0f;
                                    }
                                    f19 = Math.max(f19, f26);
                                }
                                f16 = Float.valueOf(f19);
                            } else {
                                throw new NoSuchElementException();
                            }
                        } else {
                            f16 = null;
                        }
                        Iterator<T> it5 = p26.iterator();
                        if (it5.hasNext()) {
                            ResourceModel resourceModel3 = ((MediaClip) it5.next()).resource;
                            if (resourceModel3 != null) {
                                f17 = resourceModel3.volume;
                            } else {
                                f17 = 0.0f;
                            }
                            while (it5.hasNext()) {
                                ResourceModel resourceModel4 = ((MediaClip) it5.next()).resource;
                                if (resourceModel4 != null) {
                                    f18 = resourceModel4.volume;
                                } else {
                                    f18 = 0.0f;
                                }
                                f17 = Math.max(f17, f18);
                            }
                            this$0.isVolumeChanged = !Intrinsics.areEqual(f16, f17);
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                }
            }
            this$0.requireArguments().putBoolean("ARGS_IS_VOLUME_CHANGED", this$0.isVolumeChanged);
            boolean p16 = WinkHDRPicQualityDetectUtils.f320445a.p(p26);
            this$0.requireArguments().putBoolean("key_is_blur_after_crop", p16);
            this$0.requireArguments().putBoolean("key_is_changed_after_crop", this$0.isChangedAfterCrop);
            this$0.requireArguments().putLong(QQWinkConstants.MEDIA_DURATION, this$0.Pi().j2());
            Bundle requireArguments = this$0.requireArguments();
            if (this$0.Pi().getInitDuration() != this$0.Pi().j2()) {
                z16 = true;
            } else {
                z16 = false;
            }
            requireArguments.putBoolean(QQWinkConstants.CLIP_IS_DURATION_CHANGE, z16);
            this$0.requireArguments().putBoolean(QQWinkConstants.IS_FROM_CLIP, true);
            Bundle bundle = new Bundle(this$0.getArguments());
            List<MediaClip> u26 = this$0.Pi().u2();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(u26, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = u26.iterator();
            while (it6.hasNext()) {
                ResourceModel resourceModel5 = ((MediaClip) it6.next()).resource;
                if (resourceModel5 != null) {
                    str = resourceModel5.path;
                } else {
                    str = null;
                }
                arrayList3.add(str);
            }
            bundle.putSerializable(QQWinkConstants.CLIP_ALL_MEDIA_LIST, new ArrayList(arrayList3));
            bundle.putSerializable(QQWinkConstants.CLIP_LOCAL_MEDIA_INFO_EXT_DATA, this$0.clipMediaExtInfo);
            bundle.putSerializable(QQWinkConstants.CLIP_ADDED_LOCAL_MEDIA_INFO, this$0.clipAddedMediaInfo);
            this$0.Ri(bundle);
            this$0.ui(false);
            d63.b.c(this$0, this$0.Pi().u2());
            w53.b.f("WinkEditorClippingFragment", "confirm click: clips = " + p26 + " isBlurAfterCrop:" + p16 + ", isChangedAfterCrop:" + this$0.isChangedAfterCrop);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ti(AutoClipResult result) {
        boolean isBlank;
        if (Li().getIsOpenSmartClip()) {
            if (!result.getIsSuccess()) {
                isBlank = StringsKt__StringsJVMKt.isBlank(result.getTipString());
                if (!isBlank) {
                    QQToast.makeText(BaseApplication.getContext(), result.getTipString(), 0).show();
                }
            }
            Pi().I2(result.c(), !isHidden());
        }
        Bk();
        tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tj(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qi().i().g();
        this$0.isUserPlayOrPausing = true;
        if (this$0.Pi().W2()) {
            this$0.Pi().b3();
            ((ImageView) this$0.ai(R.id.xyv)).setImageResource(R.drawable.oqs);
        } else {
            this$0.Pi().c3();
            ((ImageView) this$0.ai(R.id.xyv)).setImageResource(R.drawable.oqq);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ui() {
        ((FrameLayout) ai(R.id.v79)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Vi(WinkEditorClippingFragment.this, view);
            }
        });
    }

    @RequiresApi(api = 19)
    private final void Uj() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(requireContext, null, 0, 0, 14, null);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(56.0f));
        layoutParams.topMargin = eVar.a(6.0f);
        videoTrackContainerView.setLayoutParams(layoutParams);
        videoTrackContainerView.setItemOnLongClickListener(new e());
        videoTrackContainerView.setDrawBitmapListener(new f());
        Qi().x(videoTrackContainerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(final WinkEditorClippingFragment this$0, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Pi().X1() >= 35) {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), R.string.f215365ve, 0).show();
        } else {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.g
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorClippingFragment.Wi(WinkEditorClippingFragment.this);
                }
            };
            a aVar = this$0.addClipInterceptor;
            if (aVar != null) {
                if (!aVar.a(runnable)) {
                    runnable.run();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                runnable.run();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Vj() {
        ((RelativeLayout) ai(R.id.f75303yl)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Wj(WinkEditorClippingFragment.this, view);
            }
        });
        Dk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(WinkEditorClippingFragment this$0) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isLastAddClipReady) {
            return;
        }
        this$0.isLastAddClipReady = false;
        Context context = ((FrameLayout) this$0.ai(R.id.v79)).getContext();
        Boolean bool = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        int X1 = this$0.Pi().X1();
        z93.a a16 = Wink.INSTANCE.a();
        if (a16 != null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "curActivity.intent");
            bool = Boolean.valueOf(a16.b(activity, intent, X1, 1));
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            this$0.gk(activity);
            com.tencent.mobileqq.wink.picker.g gVar = com.tencent.mobileqq.wink.picker.g.f324860a;
            String traceId = WinkContext.INSTANCE.d().getTraceId();
            Config.Companion companion = Config.INSTANCE;
            Config.a aVar = new Config.a();
            aVar.p(this$0.Pi().X1());
            aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
            Unit unit = Unit.INSTANCE;
            gVar.h(activity, 1, traceId, aVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wj(final WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            final WinkVideoClipVolumeControlDialog winkVideoClipVolumeControlDialog = this$0.volumeControlDialog;
            if (winkVideoClipVolumeControlDialog == null) {
                winkVideoClipVolumeControlDialog = new WinkVideoClipVolumeControlDialog(activity);
                this$0.volumeControlDialog = winkVideoClipVolumeControlDialog;
                winkVideoClipVolumeControlDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.k
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        WinkEditorClippingFragment.Xj(WinkVideoClipVolumeControlDialog.this, this$0, dialogInterface);
                    }
                });
            }
            if (!winkVideoClipVolumeControlDialog.isShowing()) {
                this$0.Ki().getFlingHelper().g();
                this$0.volumeDialogClipIndex = this$0.Pi().d2();
                winkVideoClipVolumeControlDialog.Z(this$0.Pi().i2());
                winkVideoClipVolumeControlDialog.Y(this$0.volumeDialogSeekBarListener);
                RelativeLayout rlVolume = (RelativeLayout) this$0.ai(R.id.f75303yl);
                Intrinsics.checkNotNullExpressionValue(rlVolume, "rlVolume");
                winkVideoClipVolumeControlDialog.a0(rlVolume, 0, ImmersiveUtils.dpToPx(10.0f));
                Long value = this$0.Pi().m2().getValue();
                if (value == null) {
                    value = 0L;
                }
                Intrinsics.checkNotNullExpressionValue(value, "timelineViewModel.curren\u2026erTimeLiveData.value?: 0L");
                this$0.yk(value.longValue());
                if (!this$0.Pi().W2()) {
                    this$0.Pi().c3();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final HashMap<String, AudioModel> Xi(Float musicVolume, MusicInfoWrapper musicInfoWrapper, boolean usingTemplate, long totalSelectDurationUs) {
        List emptyList;
        Parcelable[] parcelableArray;
        HashMap<String, AudioModel> hashMap = new HashMap<>();
        if (usingTemplate && musicInfoWrapper != null && musicInfoWrapper.getMusicInfo() != null && musicInfoWrapper.getMusicInfo() == WinkEditorMusicInfo.J && getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null || (parcelableArray = arguments.getParcelableArray(QQWinkConstants.CLIP_TEMPLATE_MUSIC_INFO)) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    if (parcelable instanceof WinkClippingTemplateMusicInfo) {
                        emptyList.add(parcelable);
                    }
                }
            }
            if (!TextUtils.isEmpty(Ni()) && (!emptyList.isEmpty())) {
                WinkClippingTemplateMusicInfo winkClippingTemplateMusicInfo = (WinkClippingTemplateMusicInfo) emptyList.get(0);
                String name = winkClippingTemplateMusicInfo.getName();
                String path = winkClippingTemplateMusicInfo.getPath();
                long startTime = winkClippingTemplateMusicInfo.getStartTime();
                long duration = winkClippingTemplateMusicInfo.getDuration();
                AudioModel.Builder volume = new AudioModel.Builder().id("template_music").name(name).path(path).speed(Float.valueOf(1.0f)).type(AudioModel.Type.MUSIC).volume(musicVolume);
                volume.sourceStartTime = startTime;
                volume.selectStartTime = startTime;
                volume.sourceDuration = startTime + duration;
                if (totalSelectDurationUs > 0) {
                    duration = totalSelectDurationUs;
                }
                volume.selectDuration = duration;
                AudioModel build = volume.build();
                hashMap.put(build.id, com.tencent.videocut.render.extension.a.j(build, this.mediaClips, totalSelectDurationUs));
            }
        } else if (musicInfoWrapper != null) {
            AudioModel e16 = musicInfoWrapper.e();
            if (musicVolume != null) {
                AudioModel.Builder newBuilder = e16.newBuilder();
                newBuilder.volume = musicVolume.floatValue();
                if (totalSelectDurationUs > 0) {
                    newBuilder.selectDuration = totalSelectDurationUs;
                }
                e16 = newBuilder.build();
            }
            hashMap.put(e16.id, com.tencent.videocut.render.extension.a.j(e16, this.mediaClips, totalSelectDurationUs));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xj(WinkVideoClipVolumeControlDialog this_apply, WinkEditorClippingFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.Y(null);
        d63.b.f(this$0, this_apply.S());
    }

    private final void Yi() {
        ((RelativeLayout) ai(R.id.f75273yi)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Zi(WinkEditorClippingFragment.this, view);
            }
        });
    }

    private final boolean Yj() {
        boolean z16;
        List<MediaClip> u26 = Pi().u2();
        if (u26.size() != 1 || !com.tencent.videocut.render.extension.e.u(u26)) {
            return false;
        }
        MetaMaterial Mi = Mi();
        if (Mi != null && com.tencent.mobileqq.wink.editor.template.b.a(Mi)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("WinkEditorClippingFragmentnextStepClick", 500L)) {
            this$0.ak();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean Zj() {
        return requireArguments().getBoolean(QQWinkConstants.IS_USE_TEMPLATE, false);
    }

    private final void aj() {
        ((RelativeLayout) ai(R.id.f75263yh)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.bj(WinkEditorClippingFragment.this, view);
            }
        });
        Ak();
    }

    private final void ak() {
        MediaClip y26 = Pi().y2();
        if (y26 == null) {
            return;
        }
        final WinkEditorSegClipFragmentV2 b16 = WinkEditorSegClipFragmentV2.INSTANCE.b(this.backgroundModel, y26, Pi().u2());
        getChildFragmentManager().beginTransaction().add(R.id.f122537e8, b16, "WinkEditorSegClipFragmentV2").addToBackStack("WinkEditorSegClipFragmentV2").commit();
        getChildFragmentManager().setFragmentResultListener(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_RESULT, this, new FragmentResultListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.l
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                WinkEditorClippingFragment.bk(WinkEditorClippingFragment.this, b16, str, bundle);
            }
        });
        pk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bj(WinkEditorClippingFragment this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int T2 = this$0.Pi().T2();
        if (this$0.Pi().x2().getValue() != null && T2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.Si();
            this$0.vi();
            this$0.xi();
        } else if (T2 != 1) {
            if (T2 == 2) {
                QQToast.makeText(this$0.requireContext(), R.string.f215425vk, 0).show();
            }
        } else {
            QQToast.makeText(this$0.requireContext(), R.string.f215415vj, 0).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bk(WinkEditorClippingFragment this$0, WinkEditorSegClipFragmentV2 fragment, String requestKey, Bundle result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.getChildFragmentManager().beginTransaction().remove(fragment).commit();
    }

    private final void cj() {
        Ki().h(Oi());
        Ki().h(Qi());
        Ki().h(Fi());
        Ki().h(Ii());
    }

    private final void ck(boolean isHidden) {
        if (!isHidden) {
            Bundle arguments = getArguments();
            if (arguments != null && arguments.containsKey(QQWinkConstants.IS_FROM_CROP) && arguments.getBoolean(QQWinkConstants.IS_FROM_CROP)) {
                ArrayList parcelableArrayList = arguments.getParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL);
                if (parcelableArrayList != null) {
                    this.mediaClips.clear();
                    this.mediaClips.addAll(parcelableArrayList);
                }
                boolean z16 = true;
                if (Di().getIsChanged()) {
                    Pi().m3(true);
                }
                TimelineViewModelV2.v3(Pi(), this.mediaClips, true, 0L, false, 12, null);
                Pi().f3(arguments.getLong(QQWinkConstants.CLIP_CURRENT_PLAY_TIME), false, true);
                if (!this.isChangedAfterCrop && !arguments.getBoolean("key_is_changed_after_crop")) {
                    z16 = false;
                }
                this.isChangedAfterCrop = z16;
                arguments.putBoolean(QQWinkConstants.IS_FROM_CROP, false);
            }
            Pi().c3();
            return;
        }
        Pi().b3();
    }

    private final void dj() {
        ((RelativeLayout) ai(R.id.f75183y_)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.ej(WinkEditorClippingFragment.this, view);
            }
        });
    }

    private final void dk(boolean manual) {
        List<MediaClip> u26 = Pi().u2();
        Li().i2(true);
        Li().h2(true);
        Li().j2(false);
        Li().k2(u26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(WinkEditorClippingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qk();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ek() {
        if (this.needReplay) {
            Pi().c3();
        } else {
            Pi().b3();
        }
    }

    private final MediaModel fj() {
        String str;
        long j3;
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        ResourceModel copy;
        Float value = Hi().T1().getValue();
        QLog.i("WinkEditorClippingFragment", 1, "music info volume: musicVolume=" + value);
        MusicInfoWrapper value2 = Gi().D2().getValue();
        this.mBgmSource = value2;
        if (value2 != null) {
            str = value2.toString();
        } else {
            str = null;
        }
        QLog.i("WinkEditorClippingFragment", 1, "music info:  " + str);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(QQWinkConstants.CLIP_RESOURCE_MODEL)) {
            ArrayList<MediaClip> parcelableArrayList = arguments.getParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL);
            this.originMediaClips = parcelableArrayList;
            if (parcelableArrayList != null) {
                this.mediaClips.clear();
                ArrayList<MediaClip> arrayList = this.mediaClips;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parcelableArrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (MediaClip mediaClip : parcelableArrayList) {
                    ResourceModel resourceModel2 = mediaClip.resource;
                    if (resourceModel2 != null) {
                        copy = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                        resourceModel = copy;
                    } else {
                        resourceModel = null;
                    }
                    arrayList2.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
                }
                arrayList.addAll(arrayList2);
            }
            BackgroundModel backgroundModel = (BackgroundModel) arguments.getParcelable(QQWinkConstants.BACKGROUND_MODEL);
            if (backgroundModel == null) {
                backgroundModel = new BackgroundModel(null, null, null, null, null, null, null, null, 0.0f, 0, null, 2047, null);
            }
            this.backgroundModel = backgroundModel;
        }
        boolean Zj = Zj();
        QLog.i("WinkEditorClippingFragment", 1, "usingTemplate=" + Zj + ", templatePath=" + Ni());
        Iterator<T> it = this.mediaClips.iterator();
        long j16 = 0L;
        while (it.hasNext()) {
            ResourceModel resourceModel3 = ((MediaClip) it.next()).resource;
            if (resourceModel3 != null) {
                j3 = resourceModel3.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        QLog.i("WinkEditorClippingFragment", 1, "totalSelectDurationUs=" + j16);
        return com.tencent.mobileqq.wink.editor.model.a.b(this.mediaClips, this.backgroundModel, Xi(value, this.mBgmSource, Zj, j16));
    }

    private final void gj() {
        ((RelativeLayout) ai(R.id.f75193ya)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.hj(WinkEditorClippingFragment.this, view);
            }
        });
    }

    private final boolean gk(Activity activity) {
        Serializable serializable;
        boolean z16;
        Intent intent = activity.getIntent();
        String c16 = com.tencent.mobileqq.wink.editor.util.i.f322640a.c(intent);
        String str = null;
        if (intent != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        } else {
            serializable = null;
        }
        MetaMaterial metaMaterial = (MetaMaterial) serializable;
        if (intent != null) {
            str = intent.getStringExtra("local_template_path");
        }
        if (metaMaterial != null && !TextUtils.isEmpty(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!intent.getBooleanExtra(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, false) && !z16 && (Intrinsics.areEqual(c16, "QCIRCLE") || Intrinsics.areEqual(c16, QQWinkConstants.BUSINESS_ZSHOW_NAME))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj(final WinkEditorClippingFragment this$0, View view) {
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("WinkEditorClippingFragment_delete", 500L) && this$0.Pi().x2().getValue() != null && (activity = this$0.getActivity()) != null) {
            this$0.Pi().b3();
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
            createCustomDialog.setMessage(activity.getString(R.string.f215325va));
            createCustomDialog.setPositiveButton(activity.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorClippingFragment.ij(WinkEditorClippingFragment.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setNegativeButton(activity.getString(R.string.ym5), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorClippingFragment.jj(WinkEditorClippingFragment.this, dialogInterface, i3);
                }
            });
            try {
                if (!createCustomDialog.isShowing()) {
                    createCustomDialog.show();
                    this$0.mPlayerStateOnDeleteDialogPopup = this$0.Pi().l2().getValue();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            VideoReport.reportEvent("dt_clck", (RelativeLayout) this$0.ai(R.id.f75193ya), WinkDTParamBuilder.buildElementParams());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void hk() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireContext(), 230);
        createCustomDialog.setMessage(createCustomDialog.getContext().getString(R.string.f215395vh));
        createCustomDialog.setPositiveButton(createCustomDialog.getContext().getString(R.string.f215405vi), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorClippingFragment.ik(WinkEditorClippingFragment.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(createCustomDialog.getContext().getString(R.string.ym5), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorClippingFragment.jk(dialogInterface, i3);
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ij(WinkEditorClippingFragment this$0, DialogInterface dialogInterface, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 Pi = this$0.Pi();
        if (this$0.Li().getIsOpenSmartClip() && this$0.Pi().u2().size() > 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        Pi.G2(z16);
        vk(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ik(WinkEditorClippingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getArguments() == null) {
            this$0.setArguments(new Bundle());
        }
        this$0.requireArguments().putBoolean(QQWinkConstants.IS_FROM_CLIP, true);
        this$0.requireArguments().putParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL, null);
        this$0.Ri(new Bundle(this$0.getArguments()));
        this$0.ui(true);
    }

    private final void initView() {
        Ij();
        Qj();
        Gj();
        Gj();
        lj();
        Uj();
        Pj();
        Hj();
        Ui();
        Jj();
        Yi();
        Mj();
        dj();
        Vj();
        gj();
        aj();
        zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jj(WinkEditorClippingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Pi().b3();
        if (this$0.mPlayerStateOnDeleteDialogPopup != IPlayer.PlayerStatus.PAUSED) {
            this$0.Pi().c3();
        }
    }

    private final void kj() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 0;
        for (Object obj : this.mediaClips) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ResourceModel resourceModel = ((MediaClip) obj).resource;
            if (resourceModel != null) {
                linkedHashMap.put(Integer.valueOf(i3), Float.valueOf(resourceModel.volume));
            }
            i3 = i16;
        }
        Pi().L3(linkedHashMap, false);
    }

    private final void kk() {
        ArrayList<MediaClip> arrayList = new ArrayList<>(Pi().u2());
        Long value = Pi().m2().getValue();
        if (value != null) {
            this.stepToCropPlayTime = value.longValue();
        }
        WinkEditorCropFragment a16 = WinkEditorCropFragment.INSTANCE.a(arrayList, 0L, false, Pi().z2(), Pi().e2(this.stepToCropPlayTime), true);
        getChildFragmentManager().beginTransaction().add(R.id.f122537e8, a16, a16.getTAG()).addToBackStack(a16.getTAG()).commit();
        Di().l2(true);
        Di().n2(true);
    }

    private final void lj() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        MusicDotBarView musicDotBarView = new MusicDotBarView(requireContext);
        musicDotBarView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.videocut.utils.e.f384236a.a(10.0f)));
        Fi().g(musicDotBarView);
    }

    private final void lk(MediaClip mediaClip) {
        getChildFragmentManager().beginTransaction().add(R.id.f122537e8, new WinkEditorOpeningEndingAigcImageSelectFragment(Pi().u2(), mediaClip, true, false, this.backgroundModel, com.tencent.videocut.render.extension.e.k(mediaClip)), "WinkEditorOpeningEndingAigcImageSelectFragment").addToBackStack("WinkEditorOpeningEndingAigcImageSelectFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mj() {
        m63.d dVar;
        Pi().A2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.sj(WinkEditorClippingFragment.this, (Long) obj);
            }
        });
        Pi().B2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.tj(WinkEditorClippingFragment.this, (VideoTrackData) obj);
            }
        });
        Pi().m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.uj(WinkEditorClippingFragment.this, (Long) obj);
            }
        });
        Pi().w2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.vj(WinkEditorClippingFragment.this, (WinkTimelineSeekPlayerTimeData) obj);
            }
        });
        Pi().x2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.wj(WinkEditorClippingFragment.this, (SelectItem) obj);
            }
        });
        Pi().v2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.xj(WinkEditorClippingFragment.this, (List) obj);
            }
        });
        Pi().t2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.yj(WinkEditorClippingFragment.this, (TimelineViewModelV2.NumChangedData) obj);
            }
        });
        Li().S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.nj(WinkEditorClippingFragment.this, (AutoClipResult) obj);
            }
        });
        Ei().L1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.oj(WinkEditorClippingFragment.this, (List) obj);
            }
        });
        Ei().M1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.pj(WinkEditorClippingFragment.this, (Boolean) obj);
            }
        });
        Di().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.qj(WinkEditorClippingFragment.this, (Boolean) obj);
            }
        });
        final WinkEditorFragment Bi = Bi(this);
        if (Bi != null) {
            dVar = (m63.d) Bi.getViewModel(m63.d.class);
        } else {
            dVar = null;
        }
        this.winkEffectTimeLineViewModel = dVar;
        Di().O1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.clipping.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorClippingFragment.rj(WinkEditorClippingFragment.this, Bi, (Pair) obj);
            }
        });
        Cj();
    }

    private final void mk(String selectedCategoryId) {
        Pi().b3();
        getChildFragmentManager().beginTransaction().add(R.id.f122537e8, new WinkEditorOpeningEndingTemplateFragment(Pi().u2(), selectedCategoryId, true, this.backgroundModel), "WinkEditorOpeningEndingTemplateFragment").addToBackStack("WinkEditorOpeningEndingTemplateFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nj(WinkEditorClippingFragment this$0, AutoClipResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.Ti(result);
    }

    private final void nk() {
        float f16;
        Pi().b3();
        com.tencent.mobileqq.wink.editor.clipping.dialog.a aVar = this.setSpeedDialog;
        if (aVar == null) {
            aVar = new com.tencent.mobileqq.wink.editor.clipping.dialog.a(getActivity(), R.style.f173460a10);
            aVar.setGravity(8388691);
            ((RelativeLayout) ai(R.id.f75293yk)).getLocationOnScreen(new int[2]);
            aVar.W(new a.b() { // from class: com.tencent.mobileqq.wink.editor.clipping.h
                @Override // com.tencent.mobileqq.wink.editor.clipping.dialog.a.b
                public final void a(float f17, View view) {
                    WinkEditorClippingFragment.ok(WinkEditorClippingFragment.this, f17, view);
                }
            });
            this.setSpeedDialog = aVar;
        }
        if (!aVar.isShowing()) {
            if (Pi().f2() != null) {
                Float f26 = Pi().f2();
                if (f26 != null) {
                    f16 = f26.floatValue();
                } else {
                    f16 = 1.0f;
                }
                aVar.U(f16);
            }
            aVar.show();
            Window window = aVar.getWindow();
            if (window != null) {
                window.getAttributes().x = ((int) ((RelativeLayout) ai(R.id.f75293yk)).getX()) + ((((RelativeLayout) ai(R.id.f75293yk)).getWidth() - window.getAttributes().width) / 2);
                window.getAttributes().y = ((int) ((RelativeLayout) ai(R.id.f75293yk)).getY()) + ((RelativeLayout) ai(R.id.f75293yk)).getHeight() + ImmersiveUtils.dpToPx(18.0f);
                window.setAttributes(window.getAttributes());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oj(WinkEditorClippingFragment this$0, List startTimes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 Pi = this$0.Pi();
        Intrinsics.checkNotNullExpressionValue(startTimes, "startTimes");
        Pi.K2(startTimes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ok(WinkEditorClippingFragment this$0, float f16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.Pi().E2(f16)) {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), R.string.f215295v8, 0).show();
        }
        this$0.vi();
        this$0.xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pj(WinkEditorClippingFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ek();
    }

    private final void pk() {
        this.needReplay = Pi().W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qj(WinkEditorClippingFragment this$0, Boolean isCropShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isCropShow, "isCropShow");
        this$0.ck(isCropShow.booleanValue());
    }

    private final void qk() {
        if (Pi().y2() != null) {
            kk();
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
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(new HashMap(), WinkContext.INSTANCE.d().getDtParams().c()));
        QLog.i("WinkEditorClippingFragment", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rj(WinkEditorClippingFragment this$0, WinkEditorFragment winkEditorFragment, Pair pair) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((Boolean) pair.getSecond()).booleanValue()) {
            TimelineViewModelV2.A3(this$0.Pi(), this$0.Di().R1(this$0.mediaClips), 0L, false, 2, null);
        }
        if (winkEditorFragment != null) {
            dr curTavCut = winkEditorFragment.getCurTavCut();
            if (curTavCut instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) curTavCut;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.m0(new c(winkVideoTavCut, this$0));
            }
        }
    }

    private final void rk() {
        boolean z16 = !com.tencent.videocut.render.extension.e.u(Pi().u2());
        if (((RelativeLayout) ai(R.id.f75273yi)) != null) {
            ((RelativeLayout) ai(R.id.f75273yi)).setClickable(z16);
            if (z16) {
                ((ImageView) ai(R.id.f165885xz0)).setImageResource(R.drawable.oqw);
                ((TextView) ai(R.id.f1055866e)).setTextColor(getResources().getColor(R.color.f158017al3));
            } else {
                ((ImageView) ai(R.id.f165885xz0)).setImageResource(R.drawable.oqv);
                ((TextView) ai(R.id.f1055866e)).setTextColor(getResources().getColor(R.color.ala));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sj(WinkEditorClippingFragment this$0, Long duration) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ki().y(this$0.Pi().T1());
        TimelinePanelViewController Ki = this$0.Ki();
        Intrinsics.checkNotNullExpressionValue(duration, "duration");
        Ki.C(duration.longValue());
        Long value = this$0.Pi().m2().getValue();
        if (value == null) {
            value = 0L;
        }
        long longValue = value.longValue();
        TextView textView = (TextView) this$0.ai(R.id.k4u);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        long j3 = 1000;
        String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(longValue / j3), com.tencent.mobileqq.wink.editor.music.a.c(duration.longValue() / j3)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r1 > 1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sk() {
        MediaClipUseType mediaClipUseType;
        int i3;
        boolean z16;
        MediaClip k26 = Pi().k2();
        if (k26 != null) {
            mediaClipUseType = com.tencent.videocut.render.extension.e.r(k26);
        } else {
            mediaClipUseType = null;
        }
        boolean z17 = true;
        if (mediaClipUseType != MediaClipUseType.OPENING && mediaClipUseType != MediaClipUseType.ENDING) {
            if (mediaClipUseType == MediaClipUseType.NORMAL) {
                List<MediaClip> u26 = Pi().u2();
                if ((u26 instanceof Collection) && u26.isEmpty()) {
                    i3 = 0;
                } else {
                    Iterator<T> it = u26.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        if (com.tencent.videocut.render.extension.e.r((MediaClip) it.next()) == MediaClipUseType.NORMAL) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
            }
            z17 = false;
        }
        if (((RelativeLayout) ai(R.id.f75193ya)) != null) {
            ((RelativeLayout) ai(R.id.f75193ya)).setClickable(z17);
            if (z17) {
                ((ImageView) ai(R.id.xym)).setImageResource(R.drawable.nrk);
                ((TextView) ai(R.id.f10514658)).setTextColor(getResources().getColor(R.color.f158017al3));
            } else {
                ((ImageView) ai(R.id.xym)).setImageResource(R.drawable.oqg);
                ((TextView) ai(R.id.f10514658)).setTextColor(getResources().getColor(R.color.ala));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WinkEditData> ti() {
        List<WinkEditData> mutableListOf;
        MediaModel fj5 = fj();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkEditData(fj5, com.tencent.mobileqq.wink.editor.model.a.r(fj5), null, null, null, null, false, null, null, null, null, null, true, null, null, null, false, null, 253952, null));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tj(WinkEditorClippingFragment this$0, VideoTrackData videoTrackData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ClipModel> a16 = videoTrackData.a();
        this$0.Qi().K(a16, videoTrackData.b());
        this$0.zk(a16);
        if (this$0.Pi().getCurTargetTime() > 0) {
            QLog.d("WinkEditorClippingFragment", 4, "Cur target time = " + this$0.Pi().getCurTargetTime());
            this$0.Ki().a(this$0.Ki().getScaleCalculator().y(this$0.Pi().getCurTargetTime()));
        }
        this$0.sk();
        this$0.Bk();
        this$0.tk();
        this$0.xk();
        this$0.wk();
    }

    private final void tk() {
        long j3;
        List<MediaClip> R1 = Li().R1();
        if (Li().getIsOpenMusicDot() && Li().T1() && Li().U1()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = R1.iterator();
            long j16 = 0;
            while (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null) {
                    j3 = resourceModel.scaleDuration;
                } else {
                    j3 = 0;
                }
                j16 += j3;
                arrayList.add(new MusicDotModel(j16, true));
            }
            Fi().s(arrayList);
            return;
        }
        Fi().s(new ArrayList());
    }

    private final void ui(boolean isCancel) {
        if (isCancel) {
            Di().j2();
            Di().s2(Di().R1(this.mediaClips), true);
            return;
        }
        Di().L1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uj(WinkEditorClippingFragment this$0, Long time) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Pi().getIsPlayingForTimeline()) {
            TimelinePanelViewController Ki = this$0.Ki();
            i63.b scaleCalculator = this$0.Ki().getScaleCalculator();
            Intrinsics.checkNotNullExpressionValue(time, "time");
            Ki.a(scaleCalculator.y(time.longValue()));
            TextView textView = (TextView) this$0.ai(R.id.k4u);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            long j3 = 1000;
            String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(time.longValue() / j3), com.tencent.mobileqq.wink.editor.music.a.c(this$0.Pi().j2() / j3)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            this$0.Pi().N1(time.longValue());
            this$0.yk(time.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uk(boolean hidden) {
        Boolean bool;
        boolean z16;
        boolean z17;
        boolean z18;
        Bundle arguments = getArguments();
        boolean z19 = false;
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, false));
        } else {
            bool = null;
        }
        if (com.tencent.mobileqq.wink.editor.util.h.f322638a.d() && !Intrinsics.areEqual(bool, Boolean.TRUE) && !Pi().u2().isEmpty()) {
            if (hidden) {
                ((OpeningEndingAddBtnView) ai(R.id.zza)).e(false);
                ((OpeningEndingAddBtnView) ai(R.id.zza)).d(false);
                return;
            }
            List<MediaClip> u26 = Pi().u2();
            if (!(u26 instanceof Collection) || !u26.isEmpty()) {
                Iterator<T> it = u26.iterator();
                while (it.hasNext()) {
                    if (com.tencent.videocut.render.extension.e.r((MediaClip) it.next()) == MediaClipUseType.OPENING) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            ((OpeningEndingAddBtnView) ai(R.id.zza)).e(!z17);
            List<MediaClip> u27 = Pi().u2();
            if (!(u27 instanceof Collection) || !u27.isEmpty()) {
                Iterator<T> it5 = u27.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (com.tencent.videocut.render.extension.e.r((MediaClip) it5.next()) == MediaClipUseType.ENDING) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        z19 = true;
                        break;
                    }
                }
            }
            ((OpeningEndingAddBtnView) ai(R.id.zza)).d(!z19);
        }
    }

    private final void vi() {
        if (Li().getIsOpenSmartClip() && Li().X1() && !Li().a2(Pi().u2(), false)) {
            Li().f2(false);
            QUIDefaultBubbleTip.r(requireContext()).o0(requireContext().getString(R.string.f215305v9)).S((RelativeLayout) ai(R.id.f75283yj)).R(0).k0(0).m0(3).s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vj(WinkEditorClippingFragment this$0, WinkTimelineSeekPlayerTimeData winkTimelineSeekPlayerTimeData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long time = winkTimelineSeekPlayerTimeData.getTime();
        boolean needScroll = winkTimelineSeekPlayerTimeData.getNeedScroll();
        if (!this$0.Pi().getIsPlayingForTimeline() && needScroll && !this$0.Pi().getIsDraggingSliderForRenderListener()) {
            this$0.Ki().a(this$0.Ki().getScaleCalculator().y(time));
            TextView textView = (TextView) this$0.ai(R.id.k4u);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            long j3 = 1000;
            String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(time / j3), com.tencent.mobileqq.wink.editor.music.a.c(this$0.Pi().j2() / j3)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            this$0.Pi().N1(time);
        }
        this$0.Ck();
        this$0.Dk();
        this$0.Ak();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void vk(WinkEditorClippingFragment winkEditorClippingFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        winkEditorClippingFragment.uk(z16);
    }

    private final void wi(com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n event, boolean smartClipEnabled) {
        if (event.getData() == null) {
            return;
        }
        TimeData timeData = event.getData().getTimeData();
        if (timeData.getScaleDurationUs() != timeData.getSelectDurationUs() && smartClipEnabled) {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), R.string.f215285v7, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wj(WinkEditorClippingFragment this$0, SelectItem selectItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ck();
        this$0.sk();
        this$0.Dk();
        this$0.Ak();
    }

    private final void wk() {
        List<VideoTrackTimelineView> list;
        boolean z16;
        Object first;
        VideoTrackContainerView n3 = Qi().n();
        if (n3 != null) {
            list = n3.U();
        } else {
            list = null;
        }
        List<VideoTrackTimelineView> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((VideoTrackTimelineView) first).getLayoutParams();
            if (layoutParams != null) {
                Ii().s(layoutParams.leftMargin);
            }
        }
    }

    private final void xi() {
        boolean z16;
        if (Li().R1().size() == Pi().u2().size() && Li().a2(Pi().u2(), false)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (Li().getIsOpenSmartClip() && z16) {
            yi(false);
            Li().j2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xj(WinkEditorClippingFragment this$0, List mediaClips) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.d Li = this$0.Li();
        Intrinsics.checkNotNullExpressionValue(mediaClips, "mediaClips");
        Li.k2(mediaClips);
    }

    private final void xk() {
        List<VideoTrackTimelineView> list;
        boolean z16;
        Object first;
        Object last;
        Object last2;
        Object first2;
        boolean z17;
        VideoTrackContainerView n3 = Qi().n();
        if (n3 != null) {
            list = n3.U();
        } else {
            list = null;
        }
        List<VideoTrackTimelineView> list2 = list;
        boolean z18 = true;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((VideoTrackTimelineView) it.next()).getExtraContainer().removeAllViews();
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) Pi().u2());
        MediaClip mediaClip = (MediaClip) first;
        if (com.tencent.videocut.render.extension.e.r(mediaClip) == MediaClipUseType.OPENING) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            FrameLayout extraContainer = ((VideoTrackTimelineView) first2).getExtraContainer();
            String j3 = com.tencent.videocut.render.extension.e.j(mediaClip);
            if (j3 != null && j3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                zi(extraContainer, 36.0f, R.string.f215785wj, R.color.bfe, false, mediaClip, this.needExposeOpeningEndingTagView);
            } else {
                zi(extraContainer, 62.0f, R.string.f215735we, R.color.bdk, true, mediaClip, this.needExposeOpeningEndingTagView);
            }
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) Pi().u2());
        MediaClip mediaClip2 = (MediaClip) last;
        if (com.tencent.videocut.render.extension.e.r(mediaClip2) == MediaClipUseType.ENDING) {
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            FrameLayout extraContainer2 = ((VideoTrackTimelineView) last2).getExtraContainer();
            String j16 = com.tencent.videocut.render.extension.e.j(mediaClip2);
            if (j16 != null && j16.length() != 0) {
                z18 = false;
            }
            if (z18) {
                zi(extraContainer2, 36.0f, R.string.f215755wg, R.color.bfe, false, mediaClip2, this.needExposeOpeningEndingTagView);
            } else {
                zi(extraContainer2, 62.0f, R.string.f215725wd, R.color.bdk, true, mediaClip2, this.needExposeOpeningEndingTagView);
            }
        }
        this.needExposeOpeningEndingTagView = false;
    }

    private final void yi(boolean manual) {
        Li().i2(false);
        if (manual) {
            Li().h2(false);
        }
        if ((!Li().R1().isEmpty()) && Li().a2(Pi().u2(), true)) {
            Pi().I2(com.tencent.videocut.render.extension.e.m(Pi().u2()), true);
            QQToast.makeText(requireContext(), R.string.f215315v_, 0).show();
        }
        Bk();
        tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yj(WinkEditorClippingFragment this$0, TimelineViewModelV2.NumChangedData numChangedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<MediaClip> a16 = numChangedData.a();
        if (numChangedData.getCurrentClipSize() <= 1 && !this$0.Yj()) {
            this$0.xi();
            this$0.Li().h2(false);
        }
        this$0.Li().k2(a16);
        this$0.rk();
    }

    private final void yk(long currentPlayTime) {
        WinkVideoClipVolumeControlDialog winkVideoClipVolumeControlDialog = this.volumeControlDialog;
        if (winkVideoClipVolumeControlDialog != null && winkVideoClipVolumeControlDialog.isShowing() && this.volumeDialogClipIndex != -1) {
            long W1 = TimelineViewModelV2.W1(Pi(), this.volumeDialogClipIndex, false, 2, null);
            if (200000 + currentPlayTime > Pi().U1(this.volumeDialogClipIndex, false) || currentPlayTime < W1) {
                TimelineViewModelV2.g3(Pi(), W1, false, false, 6, null);
            }
        }
    }

    private final void zi(ViewGroup parent, float width, int textResId, int backgroundColorResId, boolean showIcon, final MediaClip mediaClip, boolean needExposeOpeningEndingTagView) {
        String str;
        Resources resources;
        int i3 = 0;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.he7, parent, false);
        TextView textView = (TextView) inflate.findViewById(R.id.f920856x);
        if (textView != null) {
            textView.setText(textResId);
        }
        View findViewById = inflate.findViewById(R.id.f920456t);
        if (findViewById != null) {
            if (!showIcon) {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
        CardView cardView = (CardView) inflate.findViewById(R.id.ja_);
        if (cardView != null) {
            cardView.setCardBackgroundColor(cardView.getContext().getResources().getColor(backgroundColorResId));
            if (showIcon) {
                cardView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.af
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WinkEditorClippingFragment.Ai(MediaClip.this, this, view);
                    }
                });
            }
        }
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eVar.a(width), eVar.a(20.0f));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = eVar.a(3.0f);
        layoutParams.bottomMargin = eVar.a(2.0f);
        parent.addView(inflate, layoutParams);
        VideoReport.setElementId(inflate, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_OPENING_ENDING_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        CharSequence charSequence = null;
        if (mediaClip != null) {
            str = com.tencent.videocut.render.extension.e.p(mediaClip);
        } else {
            str = null;
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, str);
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            charSequence = resources.getText(textResId);
        }
        reportMap.put("xsj_button_text", charSequence);
        VideoReport.setElementParams(inflate, reportMap);
        VideoReport.setElementEndExposePolicy(inflate, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(inflate, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(inflate, ExposurePolicy.REPORT_NONE);
        if (needExposeOpeningEndingTagView) {
            VideoReport.reportEvent("dt_imp", inflate, reportMap);
        }
    }

    private final void zj() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((OpeningEndingAddBtnView) ai(R.id.zza)).getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.tencent.videocut.utils.e.f384236a.a(16.0f);
        }
        h63.a Ii = Ii();
        OpeningEndingAddBtnView openingEndingAddBtnView = (OpeningEndingAddBtnView) ai(R.id.zza);
        Intrinsics.checkNotNullExpressionValue(openingEndingAddBtnView, "openingEndingAddBtnView");
        Ii.r(openingEndingAddBtnView);
        vk(this, false, 1, null);
        ((OpeningEndingAddBtnView) ai(R.id.zza)).setOpeningBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Aj(WinkEditorClippingFragment.this, view);
            }
        });
        ((OpeningEndingAddBtnView) ai(R.id.zza)).setEndingBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorClippingFragment.Bj(WinkEditorClippingFragment.this, view);
            }
        });
    }

    private final void zk(List<ClipModel> videoTrackModelList) {
        List<ClipModel> mutableList;
        Object firstOrNull;
        MediaClipUseType mediaClipUseType;
        Object lastOrNull;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) videoTrackModelList);
        List<MediaClip> u26 = Pi().u2();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) u26);
        MediaClip mediaClip = (MediaClip) firstOrNull;
        MediaClipUseType mediaClipUseType2 = null;
        if (mediaClip != null) {
            mediaClipUseType = com.tencent.videocut.render.extension.e.r(mediaClip);
        } else {
            mediaClipUseType = null;
        }
        if (mediaClipUseType == MediaClipUseType.OPENING) {
            CollectionsKt__MutableCollectionsKt.removeFirst(mutableList);
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) u26);
        MediaClip mediaClip2 = (MediaClip) lastOrNull;
        if (mediaClip2 != null) {
            mediaClipUseType2 = com.tencent.videocut.render.extension.e.r(mediaClip2);
        }
        if (mediaClipUseType2 == MediaClipUseType.ENDING) {
            CollectionsKt__MutableCollectionsKt.removeLast(mutableList);
        }
        ((ReorderContainerView) ai(R.id.f72983sb)).T(mutableList);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h
    public void Jc(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i iVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) event;
            Pi().a3(iVar.getData(), iVar.getIsOutCalled());
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.m) {
            Pi().O2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.m) event);
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.p) {
            Pi().b3();
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) {
            TimelineViewModelV2 Pi = Pi();
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n nVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) event;
            boolean isOpenSmartClip = Li().getIsOpenSmartClip();
            View requireView = requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
            Pi.P2(nVar, isOpenSmartClip, requireView);
            wi(nVar, Li().getIsOpenSmartClip());
            vi();
            xi();
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) {
            Pi().J2();
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l) {
            Pi().b3();
            wk();
            return;
        }
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) {
            if (((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) event).getActive()) {
                Pi().b3();
            }
        } else if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c) {
            Pi().H2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c) event);
            wk();
        } else if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e) {
            Pi().M2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e) event);
        } else if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d) {
            Pi().L2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d) event, isHidden());
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.f319115o0.clear();
    }

    @Nullable
    public View ai(int i3) {
        View findViewById;
        Map<Integer, View> map = this.f319115o0;
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

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WinkEditorClippingMenuPartV2());
        return arrayList;
    }

    public final void fk(@NotNull a addClipInterceptor) {
        Intrinsics.checkNotNullParameter(addClipInterceptor, "addClipInterceptor");
        this.addClipInterceptor = addClipInterceptor;
    }

    @Override // com.tencent.mobileqq.wink.editor.a
    public void g1(boolean isChildShow) {
        Di().l2(isChildShow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168929hd0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorClippingFragment";
    }

    @NotNull
    public final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_CUT_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public final boolean handleBackEvent() {
        WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2;
        WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment;
        WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment;
        if (getHost() == null) {
            w53.b.c("WinkEditorClippingFragment", "in handleBackEvent host is null!");
            return false;
        }
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("WinkEditorSegClipFragmentV2");
        WinkEditorCropFragment winkEditorCropFragment = null;
        if (findFragmentByTag instanceof WinkEditorSegClipFragmentV2) {
            winkEditorSegClipFragmentV2 = (WinkEditorSegClipFragmentV2) findFragmentByTag;
        } else {
            winkEditorSegClipFragmentV2 = null;
        }
        if (winkEditorSegClipFragmentV2 != null && winkEditorSegClipFragmentV2.isAdded() && !winkEditorSegClipFragmentV2.isHidden()) {
            return winkEditorSegClipFragmentV2.handleBackEvent();
        }
        Fragment findFragmentByTag2 = getChildFragmentManager().findFragmentByTag("WinkEditorOpeningEndingAigcImageSelectFragment");
        if (findFragmentByTag2 instanceof WinkEditorOpeningEndingAigcImageSelectFragment) {
            winkEditorOpeningEndingAigcImageSelectFragment = (WinkEditorOpeningEndingAigcImageSelectFragment) findFragmentByTag2;
        } else {
            winkEditorOpeningEndingAigcImageSelectFragment = null;
        }
        if (winkEditorOpeningEndingAigcImageSelectFragment != null && winkEditorOpeningEndingAigcImageSelectFragment.isAdded() && !winkEditorOpeningEndingAigcImageSelectFragment.isHidden()) {
            winkEditorOpeningEndingAigcImageSelectFragment.dismiss();
            return true;
        }
        Fragment findFragmentByTag3 = getChildFragmentManager().findFragmentByTag("WinkEditorOpeningEndingTemplateFragment");
        if (findFragmentByTag3 instanceof WinkEditorOpeningEndingTemplateFragment) {
            winkEditorOpeningEndingTemplateFragment = (WinkEditorOpeningEndingTemplateFragment) findFragmentByTag3;
        } else {
            winkEditorOpeningEndingTemplateFragment = null;
        }
        if (winkEditorOpeningEndingTemplateFragment != null && winkEditorOpeningEndingTemplateFragment.isAdded() && !winkEditorOpeningEndingTemplateFragment.isHidden()) {
            winkEditorOpeningEndingTemplateFragment.dismiss();
            return true;
        }
        Fragment findFragmentByTag4 = getChildFragmentManager().findFragmentByTag("wink_crop_WinkEditorCropFragment");
        if (findFragmentByTag4 instanceof WinkEditorCropFragment) {
            winkEditorCropFragment = (WinkEditorCropFragment) findFragmentByTag4;
        }
        if (winkEditorCropFragment != null && winkEditorCropFragment.isAdded() && !winkEditorCropFragment.isHidden()) {
            return winkEditorCropFragment.handleBackEvent();
        }
        ((ImageView) ai(R.id.xyi)).performClick();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        float e16;
        float f16;
        float e17;
        HashMap<String, HashMap<String, Serializable>> hashMap;
        this.isLastAddClipReady = true;
        if (Pi().u2().isEmpty()) {
            f16 = VolumeValueCache.INSTANCE.e();
        } else if (com.tencent.videocut.render.extension.e.u(Pi().u2())) {
            f16 = VolumeValueCache.INSTANCE.e();
        } else {
            Iterator<T> it = Pi().u2().iterator();
            if (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null) {
                    e16 = resourceModel.volume;
                } else {
                    e16 = VolumeValueCache.INSTANCE.e();
                }
                while (it.hasNext()) {
                    ResourceModel resourceModel2 = ((MediaClip) it.next()).resource;
                    if (resourceModel2 != null) {
                        e17 = resourceModel2.volume;
                    } else {
                        e17 = VolumeValueCache.INSTANCE.e();
                    }
                    e16 = Math.max(e16, e17);
                }
                f16 = e16;
            } else {
                throw new NoSuchElementException();
            }
        }
        if (requestCode != 1 || resultCode != -1 || data == null) {
            return;
        }
        List<LocalMediaInfo> Ci = Ci(data.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA));
        Serializable serializableExtra = data.getSerializableExtra(QQWinkConstants.CLIP_LOCAL_MEDIA_INFO_EXT_DATA);
        HashMap<String, LocalMediaInfo> hashMap2 = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        this.clipMediaExtInfo = hashMap;
        Serializable serializableExtra2 = data.getSerializableExtra(QQWinkConstants.CLIP_ADDED_LOCAL_MEDIA_INFO);
        if (serializableExtra2 instanceof HashMap) {
            hashMap2 = (HashMap) serializableExtra2;
        }
        this.clipAddedMediaInfo = hashMap2;
        if (Li().getIsTemplateMode() && Li().e2() && Pi().X1() == 1) {
            Li().i2(true);
            Li().h2(true);
        }
        Pi().F2(Ci, !Li().getIsOpenSmartClip(), f16);
        WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkExportViewModel::class.java)");
        WinkHDRPicQualityDetectUtils.s(winkHDRPicQualityDetectUtils, (com.tencent.mobileqq.wink.editor.export.u) viewModel, Pi().u2(), new g(), null, 8, null);
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
        Qi().F();
        super.onDestroyView();
        this.addClipInterceptor = null;
        Pi().d3();
        Di().M1();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        ms.a.f("WinkEditorClippingFragment", "onHiddenChanged---hidden=" + hidden);
        super.onHiddenChanged(hidden);
        onHiddenChangedReport(hidden);
        if (!hidden) {
            MediaModel fj5 = fj();
            Pi().x3(fj5.videos, fj5.backgroundModel, fj5.audios);
            TimelineViewModelV2.v3(Pi(), fj5.videos, true, 0L, false, 12, null);
            Pi().r3(null);
            Pi().r3(fj5.audios);
            Pi().m3(false);
            Pi().f3(0L, false, true);
            Pi().c3();
            Lj();
            Ki().getScaleCalculator().q(new j63.a());
            Ki().r();
            this.isChangedAfterCrop = false;
            this.isVolumeChanged = false;
            kj();
            Pi().w3();
            vk(this, false, 1, null);
            return;
        }
        Pi().b3();
        d63.b.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
        pk();
        Pi().b3();
        com.tencent.mobileqq.wink.editor.clipping.dialog.a aVar = this.setSpeedDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        WinkVideoClipVolumeControlDialog winkVideoClipVolumeControlDialog = this.volumeControlDialog;
        if (winkVideoClipVolumeControlDialog != null) {
            winkVideoClipVolumeControlDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onResumeReport();
        ek();
        try {
            Result.Companion companion = Result.INSTANCE;
            Pi().C2().Z();
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_TIMELINE_GENERATE);
        registerDaTongReportPageId(view);
        cj();
        initView();
        Oj(view);
        this.tavcutInited = true;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$c", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkVideoTavCut f319116a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorClippingFragment f319117b;

        c(WinkVideoTavCut winkVideoTavCut, WinkEditorClippingFragment winkEditorClippingFragment) {
            this.f319116a = winkVideoTavCut;
            this.f319117b = winkEditorClippingFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorClippingFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            m63.d dVar = this$0.winkEffectTimeLineViewModel;
            if (dVar != null) {
                dVar.n2();
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            w53.b.a("WinkEditorClippingFragment", "Clipping onLightEntityReload");
            this.f319116a.d(this);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorClippingFragment winkEditorClippingFragment = this.f319117b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.an
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorClippingFragment.c.b(WinkEditorClippingFragment.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$i", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class i implements ISessionListener {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorClippingFragment this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            if (this$0.Pi().getIsDraggingSliderForRenderListener()) {
                return;
            }
            this$0.Pi().D3(newData.getTimeLines());
            if (this$0.Pi().getFirstEnter()) {
                this$0.Pi().F3();
                this$0.Pi().l3(false);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorClippingFragment winkEditorClippingFragment = WinkEditorClippingFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.ap
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorClippingFragment.i.b(WinkEditorClippingFragment.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment$g", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "", "isBlur", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements WinkHDRPicQualityDetectUtils.a {
        g() {
        }

        @Override // com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils.a
        public void a(boolean isBlur) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jk(DialogInterface dialogInterface, int i3) {
    }
}
