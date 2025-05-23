package com.tencent.mobileqq.wink.editor;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.api.IAEEditorProcess;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.events.QCircleShowSaveDraftDialogEvent;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.challenge.WinkEditorChallengePart;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.extractor.FirstFramePreLoader;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel;
import com.tencent.mobileqq.wink.editor.hdr.HDRStatusView;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager;
import com.tencent.mobileqq.wink.editor.menu.MenuItem;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.lyric.sticker.WinkEditorLyricStickerMenuPart;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.ui.WinkMusicButton;
import com.tencent.mobileqq.wink.editor.music.utils.WinkEditorMusicConfig;
import com.tencent.mobileqq.wink.editor.music.viewmodel.DraftMusic;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicOptimizeManager;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.VolumeValueCache;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart;
import com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart;
import com.tencent.mobileqq.wink.editor.openingending.UpdateOpeningEndingData;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingUpdateEvent;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.performance.WinkEditorPefScene;
import com.tencent.mobileqq.wink.editor.smartclip.viewmodel.WinkEditSmartClipViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel;
import com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioItem;
import com.tencent.mobileqq.wink.editor.util.ActivityResultFragment;
import com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil;
import com.tencent.mobileqq.wink.editor.view.BorderView;
import com.tencent.mobileqq.wink.editor.view.WinkAdaptiveImageView;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.event.TemplateSelectEvent;
import com.tencent.mobileqq.wink.event.WinkExtractCoverEvent;
import com.tencent.mobileqq.wink.event.WinkExtractCoverReceiverEvent;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.event.WinkNoSaveEvent;
import com.tencent.mobileqq.wink.event.WinkPlayerControlEvent;
import com.tencent.mobileqq.wink.event.WinkPublishInitializationCompletedEvent;
import com.tencent.mobileqq.wink.event.WinkSaveEditDraftEvent;
import com.tencent.mobileqq.wink.event.WinkShowBottomDashBoardEvent;
import com.tencent.mobileqq.wink.inference.WinkInferenceResManager;
import com.tencent.mobileqq.wink.model.DailyInfo;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.datong.WinkSchemeConstant;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tav.player.PlayerDefaultConfigs;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.util.UiThreadUtil;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.extension.MediaClipUseType;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import d73.LyricSticker;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import k93.c;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.TimeRange;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import td4.g;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_QCIRCLE, scene = QQPermissionConstants.Business.SCENE.CIRCLE_EDITOR_WATERMARK)
@Metadata(d1 = {"\u0000\u00ac\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u00b4\u00022\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0004\u00e0\u0004\u00e1\u0004B\t\u00a2\u0006\u0006\b\u00df\u0004\u0010\u00ec\u0001J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\"\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0012\u0010-\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010.\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\u0018\u00103\u001a\u00020\u000b2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\u0012\u00104\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u00106\u001a\u00020\tH\u0002J\b\u00107\u001a\u00020\tH\u0002J\b\u00108\u001a\u00020\tH\u0002J \u0010=\u001a\u00020\t2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;H\u0002J\u0010\u0010>\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010?\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020\u000bH\u0002J\u0010\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020DH\u0002J\u0018\u0010G\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;H\u0002J \u0010I\u001a\u00020\t2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020D09j\b\u0012\u0004\u0012\u00020D`;H\u0002J\b\u0010J\u001a\u00020\tH\u0002J\u0010\u0010K\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\tH\u0002J\b\u0010N\u001a\u00020\tH\u0002J\u0012\u0010Q\u001a\u00020D2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002J0\u0010S\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;2\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;H\u0002J8\u0010W\u001a\u00020\t2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u000109j\n\u0012\u0004\u0012\u00020:\u0018\u0001`;2\u0006\u0010T\u001a\u00020D2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010UH\u0002J8\u0010Y\u001a\u00020\t2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u000109j\n\u0012\u0004\u0012\u00020:\u0018\u0001`;2\u0006\u0010X\u001a\u00020D2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010UH\u0002J\b\u0010Z\u001a\u00020\tH\u0002J\b\u0010[\u001a\u00020\tH\u0002J(\u0010_\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J \u0010a\u001a\u00020`2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u0006\u0010]\u001a\u00020\u000bH\u0002J\b\u0010b\u001a\u00020\tH\u0002J\b\u0010c\u001a\u00020\tH\u0002J\b\u0010d\u001a\u00020\tH\u0002J\b\u0010e\u001a\u00020\tH\u0002J\u0012\u0010g\u001a\u00020\t2\b\b\u0002\u0010f\u001a\u00020\u000bH\u0002J\b\u0010h\u001a\u00020\tH\u0002J\u0010\u0010j\u001a\u00020\t2\u0006\u0010i\u001a\u00020DH\u0002J\b\u0010k\u001a\u00020\tH\u0002J\b\u0010l\u001a\u00020\tH\u0002J\u0016\u0010o\u001a\u00020\t2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\t0mH\u0002J\b\u0010p\u001a\u00020\u000bH\u0002J\b\u0010q\u001a\u00020\tH\u0002J\b\u0010r\u001a\u00020\tH\u0002J\b\u0010s\u001a\u00020\tH\u0002J\b\u0010t\u001a\u00020\tH\u0002J\b\u0010u\u001a\u00020\tH\u0002J\b\u0010v\u001a\u00020\u000bH\u0002J\b\u0010w\u001a\u00020\tH\u0002J\u0010\u0010y\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u000bH\u0002J4\u0010\u007f\u001a\u00020\t2\u0006\u0010z\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020@2\u0006\u0010|\u001a\u00020D2\b\b\u0002\u0010}\u001a\u00020\u000b2\b\b\u0002\u0010~\u001a\u00020\u000fH\u0002J\t\u0010\u0080\u0001\u001a\u00020\tH\u0002J\t\u0010\u0081\u0001\u001a\u00020\tH\u0002J+\u0010\u0086\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u000201002\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0087\u0001\u001a\u00020\tH\u0002J\t\u0010\u0088\u0001\u001a\u00020\tH\u0002J\t\u0010\u0089\u0001\u001a\u00020\tH\u0002J,\u0010\u008d\u0001\u001a\u00020\t2!\u0010\u008c\u0001\u001a\u001c\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\t0\u008a\u0001H\u0002J\u0014\u0010\u008f\u0001\u001a\u00020\t2\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020@H\u0002J\t\u0010\u0092\u0001\u001a\u00020\tH\u0002J\t\u0010\u0093\u0001\u001a\u00020\tH\u0002J\t\u0010\u0094\u0001\u001a\u00020\tH\u0002J\t\u0010\u0095\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0096\u0001\u001a\u00020\tH\u0002J\t\u0010\u0097\u0001\u001a\u00020\tH\u0002J\t\u0010\u0098\u0001\u001a\u00020\tH\u0002J\u0017\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010DH\u0002J\u001e\u0010\u009f\u0001\u001a\u00020\t2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u00a0\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u00a2\u0001\u001a\u00020\t2\u0007\u0010\u00a1\u0001\u001a\u00020\u000bH\u0002J\u001c\u0010\u00a6\u0001\u001a\u00020\t2\u0007\u0010\u00a3\u0001\u001a\u00020U2\b\u0010\u00a5\u0001\u001a\u00030\u00a4\u0001H\u0002J\u001c\u0010\u00a7\u0001\u001a\u00020\t2\u0007\u0010\u00a3\u0001\u001a\u00020U2\b\u0010\u00a5\u0001\u001a\u00030\u00a4\u0001H\u0002J\u0012\u0010\u00a8\u0001\u001a\u00020\t2\u0007\u0010\u00a3\u0001\u001a\u00020UH\u0002J\u001c\u0010\u00ab\u0001\u001a\u00020\t2\u0007\u0010\u00a3\u0001\u001a\u00020U2\b\u0010\u00aa\u0001\u001a\u00030\u00a9\u0001H\u0002J\t\u0010\u00ac\u0001\u001a\u00020\tH\u0002J0\u0010\u00ae\u0001\u001a\u00020\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\r\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010f\u001a\u00020\u000bH\u0002J\u0019\u0010\u00af\u0001\u001a\u00020\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\t\u0010\u00b0\u0001\u001a\u00020\u000bH\u0002J\u001c\u0010\u00b2\u0001\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u00b1\u0001\u001a\u00020\u000fH\u0002J\u001c\u0010\u00b3\u0001\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u00b1\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u00b4\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u00b5\u0001\u001a\u00020\tH\u0002J\t\u0010\u00b6\u0001\u001a\u00020\tH\u0002J\t\u0010\u00b7\u0001\u001a\u00020\tH\u0002J\t\u0010\u00b8\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u00ba\u0001\u001a\u00020\t2\u0007\u0010\u00b9\u0001\u001a\u00020DH\u0002J\u0019\u0010\u00bb\u0001\u001a\u00020\u000b2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\t\u0010\u00bc\u0001\u001a\u00020\tH\u0002J\t\u0010\u00bd\u0001\u001a\u00020\tH\u0002J'\u0010\u00bf\u0001\u001a\u00020\t2\u0011\b\u0002\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010m2\t\b\u0002\u0010\u00be\u0001\u001a\u00020\u000bH\u0002J\u0014\u0010\u00c1\u0001\u001a\u00020\t2\t\b\u0002\u0010\u00c0\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u00c2\u0001\u001a\u00020\tH\u0002J\t\u0010\u00c3\u0001\u001a\u00020\tH\u0002J\u001b\u0010\u00c6\u0001\u001a\u00020\t2\u0007\u0010\u00c4\u0001\u001a\u00020:2\u0007\u0010\u00c5\u0001\u001a\u00020DH\u0002J\u0019\u0010\u00c9\u0001\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0005\u0012\u00030\u00c8\u0001\u0018\u00010\u00c7\u0001H\u0002J\t\u0010\u00ca\u0001\u001a\u00020\tH\u0002J\f\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u00cb\u0001H\u0002J\f\u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00cb\u0001H\u0002J\t\u0010\u00ce\u0001\u001a\u00020DH\u0002J\t\u0010\u00cf\u0001\u001a\u00020\tH\u0002J\u0014\u0010\u00d1\u0001\u001a\u00020\t2\t\b\u0002\u0010\u00d0\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u00d2\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010\u00d4\u0001\u001a\u00020\u000f2\t\u0010\u00d3\u0001\u001a\u0004\u0018\u000101J\u0012\u0010\u00d5\u0001\u001a\u00020\u000f2\t\u0010\u00d3\u0001\u001a\u0004\u0018\u000101J\t\u0010\u00d6\u0001\u001a\u00020\u000bH\u0014J\t\u0010\u00d7\u0001\u001a\u00020\u000fH\u0014J\t\u0010\u00d8\u0001\u001a\u00020\u000fH\u0014J\u0013\u0010\u00db\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u00da\u00010\u00d9\u0001H\u0016J\u0014\u0010\u00dd\u0001\u001a\u00020\t2\t\u0010\u00dc\u0001\u001a\u0004\u0018\u00010UH\u0016J\u0013\u0010\u00e0\u0001\u001a\u00020\t2\b\u0010\u00df\u0001\u001a\u00030\u00de\u0001H\u0016J\t\u0010\u00e1\u0001\u001a\u00020\tH\u0016J7\u0010\u00e7\u0001\u001a\u00020\t2\u0007\u0010\u00e2\u0001\u001a\u00020\u000f2\u0010\u0010\u00e4\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010D0\u00e3\u00012\b\u0010\u00e6\u0001\u001a\u00030\u00e5\u0001H\u0016\u00a2\u0006\u0006\b\u00e7\u0001\u0010\u00e8\u0001J\u001c\u0010\u00e9\u0001\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\t\u0010\u00dc\u0001\u001a\u0004\u0018\u00010UH\u0014J\u001c\u0010\u00ea\u0001\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\t\u0010\u00dc\u0001\u001a\u0004\u0018\u00010UH\u0014J\u0012\u0010\u00eb\u0001\u001a\u00020\tH\u0000\u00a2\u0006\u0006\b\u00eb\u0001\u0010\u00ec\u0001J\u0007\u0010\u00ed\u0001\u001a\u00020\tJ\u0007\u0010\u00ee\u0001\u001a\u00020\u000bJ\u0007\u0010\u00ef\u0001\u001a\u00020\tJ\u0007\u0010\u00f0\u0001\u001a\u00020\tJ\t\u0010\u00f1\u0001\u001a\u00020\tH\u0016J\t\u0010\u00f2\u0001\u001a\u00020\tH\u0016J\u0013\u0010\u00f5\u0001\u001a\u00020\t2\b\u0010\u00f4\u0001\u001a\u00030\u00f3\u0001H\u0016J\t\u0010\u00f6\u0001\u001a\u00020\tH\u0016J\t\u0010\u00f7\u0001\u001a\u00020\tH\u0016J\b\u0010\u00f9\u0001\u001a\u00030\u00f8\u0001J\u0007\u0010\u00fa\u0001\u001a\u00020\tJ\u0007\u0010\u00fb\u0001\u001a\u00020\u000bJ\u0012\u0010\u00fd\u0001\u001a\u00020\t2\u0007\u0010\u00fc\u0001\u001a\u00020\u000bH\u0016J\n\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fe\u0001J'\u0010\u0084\u0002\u001a\u00020\t2\u0007\u0010\u0080\u0002\u001a\u00020\u000f2\u0007\u0010\u0081\u0002\u001a\u00020\u000b2\n\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0016J\u0014\u0010\u0086\u0002\u001a\u00020\t2\t\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J'\u0010\u0088\u0002\u001a \u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040\u0087\u000209j\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040\u0087\u0002`;H\u0016J\t\u0010\u0089\u0002\u001a\u00020DH\u0016J\t\u0010\u008a\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u008b\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u008c\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u008d\u0002\u001a\u00020\u000fH\u0016J\u0013\u0010\u0090\u0002\u001a\u00020\t2\b\u0010\u008f\u0002\u001a\u00030\u008e\u0002H\u0016J\t\u0010\u0091\u0002\u001a\u00020\tH\u0016J\t\u0010\u0092\u0002\u001a\u00020\tH\u0016J\u0012\u0010\u0094\u0002\u001a\u00020\t2\u0007\u0010\u0093\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010\u0097\u0002\u001a\u00020\t2\u0007\u0010\u0095\u0002\u001a\u00020\u000b2\u0007\u0010\u0096\u0002\u001a\u00020\u000bH\u0016J\u001c\u0010\u009a\u0002\u001a\u00020\t2\u0007\u0010\u0095\u0002\u001a\u00020\u000b2\b\u0010\u0099\u0002\u001a\u00030\u0098\u0002H\u0016J0\u0010\u00a0\u0002\u001a\u00020\t2\n\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00022\u0007\u0010\u009d\u0002\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@2\n\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009e\u0002J\u0007\u0010\u00a1\u0002\u001a\u00020\tJ\u0007\u0010\u00a2\u0002\u001a\u00020\u000bJ\t\u0010\u00a3\u0002\u001a\u00020\u000bH\u0016J\u0014\u0010\u00a4\u0002\u001a\u00020\t2\t\u0010\u00dc\u0001\u001a\u0004\u0018\u00010UH\u0016J\u0012\u0010\u00a6\u0002\u001a\u00020\t2\u0007\u0010\u00a5\u0002\u001a\u00020UH\u0016J\u0011\u0010\u00a9\u0002\u001a\u00020\t2\b\u0010\u00a8\u0002\u001a\u00030\u00a7\u0002J\t\u0010\u00aa\u0002\u001a\u00020\tH\u0016J\t\u0010\u00ab\u0002\u001a\u00020\tH\u0016J\t\u0010\u00ac\u0002\u001a\u00020\tH\u0016J\t\u0010\u00ad\u0002\u001a\u00020\tH\u0016J\t\u0010\u00ae\u0002\u001a\u00020\tH\u0016J\t\u0010\u00af\u0002\u001a\u00020\u001bH\u0016J\t\u0010\u00b0\u0002\u001a\u00020\u001bH\u0016J\u000b\u0010\u00b1\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J\u000b\u0010\u00b2\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u00b4\u0002\u001a\u00020\t2\u0007\u0010\u00b3\u0002\u001a\u00020\u000bH\u0016J\t\u0010\u00b5\u0002\u001a\u0004\u0018\u00010DJ\n\u0010\u00b7\u0002\u001a\u0005\u0018\u00010\u00b6\u0002J\u0011\u0010\u00ba\u0002\u001a\u00020\u000b2\b\u0010\u00b9\u0002\u001a\u00030\u00b8\u0002J\u0007\u0010\u00bb\u0002\u001a\u00020\u000bJ\u0007\u0010\u00bc\u0002\u001a\u00020\tJ\u0007\u0010\u00bd\u0002\u001a\u00020\u000bR!\u0010\u00c3\u0002\u001a\u00030\u00be\u00028FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bf\u0002\u0010\u00c0\u0002\u001a\u0006\b\u00c1\u0002\u0010\u00c2\u0002R \u0010\u00c7\u0002\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c4\u0002\u0010\u00c0\u0002\u001a\u0006\b\u00c5\u0002\u0010\u00c6\u0002R\u0019\u0010\u00ca\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0002\u0010\u00c9\u0002R\u0019\u0010\u00cd\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cb\u0002\u0010\u00cc\u0002R\u0017\u0010\u00d0\u0002\u001a\u00020@8\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u00ce\u0002\u0010\u00cf\u0002R\u0017\u0010\u00d2\u0002\u001a\u00020@8\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u00d1\u0002\u0010\u00cf\u0002R\u001c\u0010\u00d5\u0002\u001a\u0005\u0018\u00010\u00d3\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cc\u0002\u0010\u00d4\u0002R\u001a\u0010\u00d8\u0002\u001a\u00030\u00d6\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cf\u0002\u0010\u00d7\u0002R\u001a\u0010\u00db\u0002\u001a\u00030\u00d9\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008d\u0002\u0010\u00da\u0002R\u001b\u0010\u00de\u0002\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00dc\u0002\u0010\u00dd\u0002R\u001a\u0010\u00e2\u0002\u001a\u00030\u00df\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e0\u0002\u0010\u00e1\u0002R\u001a\u0010\u00e6\u0002\u001a\u00030\u00e3\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e4\u0002\u0010\u00e5\u0002R\u0019\u0010\u00e8\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e7\u0002\u0010\u00dd\u0002R\u001a\u0010\u00ec\u0002\u001a\u00030\u00e9\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ea\u0002\u0010\u00eb\u0002R\u001c\u0010\u00f0\u0002\u001a\u0005\u0018\u00010\u00ed\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ee\u0002\u0010\u00ef\u0002R\u001c\u0010\u00f4\u0002\u001a\u0005\u0018\u00010\u00f1\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f2\u0002\u0010\u00f3\u0002R\u0019\u0010\u00f6\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00f5\u0002\u0010\u00dd\u0002R\u0019\u0010\u00f8\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00f7\u0002\u0010\u00dd\u0002R\u0019\u0010\u00fa\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00f9\u0002\u0010\u00dd\u0002R\u0019\u0010\u00fc\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00fb\u0002\u0010\u00dd\u0002R,\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u00fd\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00fe\u0002\u0010\u00ff\u0002\u001a\u0006\b\u0080\u0003\u0010\u0081\u0003\"\u0006\b\u0082\u0003\u0010\u0083\u0003R\u001c\u0010\u0087\u0003\u001a\u0005\u0018\u00010\u00fe\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0003\u0010\u0086\u0003R\u001c\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00fe\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c9\u0002\u0010\u0086\u0003R\u001c\u0010\u0089\u0003\u001a\u0005\u0018\u00010\u00fe\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0003\u0010\u0086\u0003R\u0019\u0010\u008b\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0003\u0010\u00c9\u0002R\u0019\u0010\u008d\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0003\u0010\u00c9\u0002R\u0019\u0010\u008f\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0003\u0010\u00c9\u0002R\u001c\u0010\u0093\u0003\u001a\u0005\u0018\u00010\u0090\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0003\u0010\u0092\u0003R\u0019\u0010\u0095\u0003\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0003\u0010\u00cf\u0002R\u0019\u0010\u0097\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0003\u0010\u00c9\u0002R\u0019\u0010\u0099\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0003\u0010\u00c9\u0002R\u0019\u0010\u009b\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0003\u0010\u00c9\u0002R\u0019\u0010\u009d\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0003\u0010\u00c9\u0002R\u0019\u0010\u009f\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0003\u0010\u00cc\u0002R\u0019\u0010\u00a1\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0003\u0010\u00cc\u0002R\u0019\u0010\u00a3\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0003\u0010\u00cc\u0002R+\u0010\u00a7\u0003\u001a\u0014\u0012\u0005\u0012\u00030\u00a4\u000309j\t\u0012\u0005\u0012\u00030\u00a4\u0003`;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0003\u0010\u00a6\u0003R\u0019\u0010\u00a9\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0003\u0010\u00c9\u0002R\u0019\u0010\u00ab\u0003\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0003\u0010\u00c9\u0002R\u001c\u0010\u00af\u0003\u001a\u0005\u0018\u00010\u00ac\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ad\u0003\u0010\u00ae\u0003R7\u0010\u00b4\u0003\u001a \u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0\u00b0\u0003j\u000f\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D`\u00b1\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0003\u0010\u00b3\u0003R\u001c\u0010\u00b8\u0003\u001a\u0005\u0018\u00010\u00b5\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0003\u0010\u00b7\u0003R!\u0010\u00bd\u0003\u001a\u00030\u00b9\u00038@X\u0080\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ba\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00bb\u0003\u0010\u00bc\u0003R!\u0010\u00c2\u0003\u001a\u00030\u00be\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bf\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00c0\u0003\u0010\u00c1\u0003R!\u0010\u00c7\u0003\u001a\u00030\u00c3\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c4\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00c5\u0003\u0010\u00c6\u0003R!\u0010\u00cc\u0003\u001a\u00030\u00c8\u00038FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c9\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00ca\u0003\u0010\u00cb\u0003R!\u0010\u00d0\u0003\u001a\u00030\u00f8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cd\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00ce\u0003\u0010\u00cf\u0003R!\u0010\u00d5\u0003\u001a\u00030\u00d1\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d2\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00d3\u0003\u0010\u00d4\u0003R!\u0010\u00da\u0003\u001a\u00030\u00d6\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d7\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00d8\u0003\u0010\u00d9\u0003R!\u0010\u00df\u0003\u001a\u00030\u00db\u00038FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00dc\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00dd\u0003\u0010\u00de\u0003R!\u0010\u00e4\u0003\u001a\u00030\u00e0\u00038FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00e1\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00e2\u0003\u0010\u00e3\u0003R!\u0010\u00e9\u0003\u001a\u00030\u00e5\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00e6\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00e7\u0003\u0010\u00e8\u0003R!\u0010\u00ee\u0003\u001a\u00030\u00ea\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00eb\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00ec\u0003\u0010\u00ed\u0003R#\u0010\u00f3\u0003\u001a\u0005\u0018\u00010\u00ef\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f0\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00f1\u0003\u0010\u00f2\u0003R!\u0010\u00f8\u0003\u001a\u00030\u00f4\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f5\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00f6\u0003\u0010\u00f7\u0003R!\u0010\u00fd\u0003\u001a\u00030\u00f9\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00fa\u0003\u0010\u00c0\u0002\u001a\u0006\b\u00fb\u0003\u0010\u00fc\u0003R!\u0010\u0082\u0004\u001a\u00030\u00fe\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ff\u0003\u0010\u00c0\u0002\u001a\u0006\b\u0080\u0004\u0010\u0081\u0004R!\u0010\u0087\u0004\u001a\u00030\u0083\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0004\u0010\u00c0\u0002\u001a\u0006\b\u0085\u0004\u0010\u0086\u0004R!\u0010\u008a\u0004\u001a\u00030\u00e0\u00038BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0088\u0004\u0010\u00c0\u0002\u001a\u0006\b\u0089\u0004\u0010\u00e3\u0003R!\u0010\u008f\u0004\u001a\u00030\u008b\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008c\u0004\u0010\u00c0\u0002\u001a\u0006\b\u008d\u0004\u0010\u008e\u0004R!\u0010\u0094\u0004\u001a\u00030\u0090\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0091\u0004\u0010\u00c0\u0002\u001a\u0006\b\u0092\u0004\u0010\u0093\u0004R!\u0010\u0099\u0004\u001a\u00030\u0095\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0096\u0004\u0010\u00c0\u0002\u001a\u0006\b\u0097\u0004\u0010\u0098\u0004R!\u0010\u009e\u0004\u001a\u00030\u009a\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009b\u0004\u0010\u00c0\u0002\u001a\u0006\b\u009c\u0004\u0010\u009d\u0004R\u001c\u0010\u00a1\u0004\u001a\u0005\u0018\u00010\u00cb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0004\u0010\u00a0\u0004R\u001c\u0010\u00a3\u0004\u001a\u0005\u0018\u00010\u00cb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0004\u0010\u00a0\u0004R\u001b\u0010\u00a6\u0004\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0004\u0010\u00a5\u0004R\u0019\u0010\u00a8\u0004\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0004\u0010\u00a5\u0004R\u0019\u0010\u00aa\u0004\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0004\u0010\u00cf\u0002R\u0019\u0010\u00ac\u0004\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0004\u0010\u00c9\u0002R)\u0010\u00b2\u0004\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ad\u0004\u0010\u00cf\u0002\u001a\u0006\b\u00ae\u0004\u0010\u00af\u0004\"\u0006\b\u00b0\u0004\u0010\u00b1\u0004R\u0019\u0010\u00b4\u0004\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0004\u0010\u00cf\u0002R\u001c\u0010\u00b8\u0004\u001a\u0005\u0018\u00010\u00b5\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0004\u0010\u00b7\u0004R\u001f\u0010\u00bc\u0004\u001a\n\u0012\u0005\u0012\u00030\u00ba\u00040\u00b9\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bb\u0004\u0010\u00c0\u0002R\u0018\u0010\u00c0\u0004\u001a\u00030\u00bd\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00be\u0004\u0010\u00bf\u0004R\u001d\u0010\u00c6\u0004\u001a\u00030\u00c1\u00048\u0006\u00a2\u0006\u0010\n\u0006\b\u00c2\u0004\u0010\u00c3\u0004\u001a\u0006\b\u00c4\u0004\u0010\u00c5\u0004R\u001d\u0010\u00cc\u0004\u001a\u00030\u00c7\u00048\u0006\u00a2\u0006\u0010\n\u0006\b\u00c8\u0004\u0010\u00c9\u0004\u001a\u0006\b\u00ca\u0004\u0010\u00cb\u0004R\u0018\u0010\u00d0\u0004\u001a\u00030\u00cd\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ce\u0004\u0010\u00cf\u0004R\u0018\u0010\u00d4\u0004\u001a\u00030\u00d1\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d2\u0004\u0010\u00d3\u0004R\u001a\u0010\u00d6\u0004\u001a\u00030\u00ed\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0004\u0010\u00ef\u0002R\u0018\u0010\u00d8\u0004\u001a\u00030\u00ed\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0004\u0010\u00ef\u0002R\u0017\u0010\u00d9\u0004\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00d9\u0004\u0010\u00c6\u0002R!\u0010\u00de\u0004\u001a\u00030\u00ba\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\u001a\u0006\b\u00da\u0004\u0010\u00db\u0004*\u0006\b\u00dc\u0004\u0010\u00dd\u0004\u00a8\u0006\u00e2\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$b;", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$c;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Lcom/tencent/mobileqq/wink/editor/a;", "", "zn", "", "Nm", "el", "bl", "", "width", "height", "on", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "params", "tl", "Xj", "jl", "xl", "qm", "wm", "Landroid/view/View;", "view", "yl", LinkReportConstant$EventKey.VALUE, "Sl", "playerWidth", "playerHeight", "nm", "rl", com.tencent.av.ui.ak.f75340i, "fk", "ul", "Zj", "dk", "ek", "bk", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "Wn", "Am", "jk", "Lm", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "Qj", "gk", "mo", "nn", "An", LocaleUtils.L_KOREAN, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "covers", "lo", "hm", "im", "", "delay", "ao", "Om", "", "mButtonName", "Vm", "nk", "stickerTopicList", "Hj", "mk", "xm", "initViewModel", "il", "Kl", "Landroid/content/Intent;", "intent", "kk", "imageCovers", "lk", "tag", "Landroid/os/Bundle;", "bundle", "Rj", "content", "Tj", "Il", "zl", "beginHDR", "needConfirm", "enhanceCheckClips", "Jj", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment$b;", "ik", "Kj", "Lj", "Mn", "ll", "isClipChange", "nl", "wn", QzoneZipCacheHelper.DIR, "no", "Vn", "ql", "Lkotlin/Function0;", "onConfirm", "bo", "Km", MsfCmdConfig.CMD_DELETE_FILE, "po", "um", "Cm", "Tl", "Um", "Pj", "needShowToast", "Mj", "hasBgm", "timeCost", "errorMsg", "fromLocal", "segmentIdx", "xn", "Ul", "Ql", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfo", "videos", "triggerSmartClip", "hk", "mm", "pm", "km", "Lkotlin/Function3;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "action", "Yj", "fromRestore", "fl", "durationUs", "oo", "hn", "Cn", "En", "Pm", "ro", "cm", "ym", "stickerId", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Ek", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "ttsAudioInfo", "isSeek", "hl", "dm", "isHidden", "Wm", "fragmentArguments", "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "winkImageTavCut", com.tencent.av.ui.an.f75362j, "Xm", "Zm", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "videoTavCut", "Ym", "qo", "oldClips", "al", ReportConstant.COSTREPORT_SN, "Mm", "visibility", "Nj", "Oj", "cl", "eo", "Pn", "Sn", "pn", "eid", "to", "Im", "Ol", "Xn", "forceSave", "kn", "savePublishDraft", "Fn", "Hn", "Ij", "localMediaInfo", "thumbfilePath", "Kn", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "Bk", "qn", "Landroid/view/animation/Animation;", "pk", "qk", "wk", "Ln", "isDestroy", "tn", "Rm", "mediaClip", "Ak", "zk", "enableRootViewSetFitsSystemWindows", "getStatusBarColor", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/Context;", "context", "onAttach", "onDestroyView", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "jo", "()V", "jn", "Qm", "in", "Dn", "onResume", DKHippyEvent.EVENT_STOP, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/wink/editor/tts/e;", "Ik", "On", "Sm", "hidden", "onHiddenChanged", "Lcom/tencent/mobileqq/wink/editor/dr;", "Jk", "type", "isSuccess", "", "data", "onUpdate", "simpleBaseEvent", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "getLogTag", "getRenderWidth", "getRenderHeight", "i1", "K", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "direction", "hc", ICustomDataEditor.STRING_ARRAY_PARAM_6, "va", "pointNum", "Sd", "isClickEvent", "isStickerActive", "Pb", "", "positionY", "xg", "", "msg", "cancelable", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Yn", "Vj", "Fm", "onBackEvent", "onViewStateRestored", "outState", "onSaveInstanceState", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "dataWrapper", "In", "dd", "B3", "N2", "b8", "R6", "bb", "bc", "ga", "w7", "isChildShow", "g1", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "Lo73/a;", "Kk", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "menuItem", "kl", "Hk", "Bn", "Hm", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Dk", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "D", "Jm", "()Z", "isFromQQLevelH5", "E", "Z", "isLightResourceLoadSucceed", UserInfo.SEX_FEMALE, "I", "lastMusicStartTime", "G", "J", "HDR_TIPS_SHOW_TIME", "H", "MUSIC_ITEM_DELAY_TIME", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "showHDRTips", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "menuBar", "L", "Landroid/view/View;", "musicMenuItem", "Lcom/tencent/mobileqq/wink/editor/hdr/HDRStatusView;", "M", "Lcom/tencent/mobileqq/wink/editor/hdr/HDRStatusView;", "hdrStatusView", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "N", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "stickerBorderView", "P", "bottomDashboardScrollView", "Lcom/tencent/mobileqq/wink/editor/cx;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/cx;", "partManager", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Runnable;", "realSaveRunnable", "Landroid/animation/ValueAnimator;", ExifInterface.LATITUDE_SOUTH, "Landroid/animation/ValueAnimator;", "mHDRTipsAnimator", "T", "mTopLine", "U", "mLeftLine", "V", "mRightLine", "W", "mBottomLine", "Lcom/tencent/mobileqq/wink/editor/view/WinkAdaptiveImageView;", "X", "Lcom/tencent/mobileqq/wink/editor/view/WinkAdaptiveImageView;", "rk", "()Lcom/tencent/mobileqq/wink/editor/view/WinkAdaptiveImageView;", "setIvPreloadFrame", "(Lcom/tencent/mobileqq/wink/editor/view/WinkAdaptiveImageView;)V", "ivPreloadFrame", "Y", "Lcom/tencent/mobileqq/wink/editor/dr;", "curTavCut", "a0", "imageTavCut", "b0", "isVideoTavCutRenderListenerAdded", "c0", "isImageTavCutRenderListenerAdded", "d0", "isInAddClipHDR", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "e0", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "f0", "showDialogTime", "g0", "isExportProcessing", "h0", "isShowHDRTips", "i0", "isFirstShow", "j0", "isFirstDismiss", "k0", "deLogo", "l0", "deBlur", "m0", "deFace", "", "n0", "Ljava/util/ArrayList;", "extractResult", "o0", "jumpToPublished", "p0", "isSaveUnDefined", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "q0", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "editorDataServiceHandler", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "r0", "Ljava/util/HashMap;", "schemaAttrsMap", "Lcom/tencent/mobileqq/wink/editor/hdr/r;", "s0", "Lcom/tencent/mobileqq/wink/editor/hdr/r;", "lastHDRListenerDelegate", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "t0", "Tk", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/recommend/b;", "u0", "Yk", "()Lcom/tencent/mobileqq/wink/editor/recommend/b;", "winkRecommendViewModel", "Lcom/tencent/mobileqq/wink/editor/hdr/q;", "v0", "Vk", "()Lcom/tencent/mobileqq/wink/editor/hdr/q;", "winkHDRViewModel", "Lcom/tencent/mobileqq/wink/editor/template/x;", "w0", "Sk", "()Lcom/tencent/mobileqq/wink/editor/template/x;", "winkEditorTemplateViewModel", "x0", "Zk", "()Lcom/tencent/mobileqq/wink/editor/tts/e;", "winkTTSViewModel", "Lcom/tencent/mobileqq/wink/editor/filter/af;", "y0", "Ok", "()Lcom/tencent/mobileqq/wink/editor/filter/af;", "winkEditorFilterViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "z0", "yk", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "A0", "xk", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z;", "B0", "tk", "()Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z;", "mWinkEditorLyricStickerViewModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/WinkEditSmartClipViewModel;", "C0", "Qk", "()Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/WinkEditSmartClipViewModel;", "winkEditorSmartClipViewModel", "Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel;", "D0", "Rk", "()Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel;", "winkEditorSmartFilterViewModel", "Lm63/d;", "E0", "Uk", "()Lm63/d;", "winkEffectTimeLineViewModel", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "F0", "Gk", "()Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "subtitleViewModel", "Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "G0", "vk", "()Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "mWinkExtractCoverViewModel", "Lcom/tencent/mobileqq/wink/editor/export/u;", "H0", "uk", "()Lcom/tencent/mobileqq/wink/editor/export/u;", "mWinkExportViewModel", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "I0", "Mk", "()Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "J0", "Lk", "winkEditLyricStickerViewModel", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "K0", "Pk", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "winkEditorOpeningEndingViewModel", "Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "L0", "Wk", "()Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "winkMaterialViewModel", "Lb63/a;", "M0", "Nk", "()Lb63/a;", "winkEditorChallengeViewModel", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "N0", "Xk", "()Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "winkQZoneTemplateViewModel", "O0", "Landroid/view/animation/Animation;", "mFadeInAnimation", "P0", "mFadeOutAnimation", "Q0", "Ljava/lang/String;", "clientTraceId", "R0", "tongKuanMusicMid", "S0", "curPlayerTimeUs", "T0", "isInStickerEdit", "U0", "sk", "()J", "setMDelayForSaveMedialModel", "(J)V", "mDelayForSaveMedialModel", "V0", "mLastPublishTime", "Lkotlinx/coroutines/Job;", "W0", "Lkotlinx/coroutines/Job;", "preloadDataJob", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/wink/editor/hdr/k;", "X0", "progressDialogDelegate", "Landroid/view/TextureView$SurfaceTextureListener;", "Y0", "Landroid/view/TextureView$SurfaceTextureListener;", "playerSurfaceTextureListener", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Z0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "getPlayerListener", "()Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/d;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/d;", "Fk", "()Lcom/tencent/mobileqq/wink/editor/sticker/sticker/d;", "stickerUpdateListener", "Landroid/os/Handler;", "b1", "Landroid/os/Handler;", "onLoadAssetHandler", "Lq63/a;", "c1", "Lq63/a;", "loadAssetListener", "d1", "mTimeSaveMediaModelRunnable", "e1", "mSaveMediaRunnable", "isZShowTemplate", "Ck", "()Lcom/tencent/mobileqq/wink/editor/hdr/k;", "getProgressDialog$delegate", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;)Ljava/lang/Object;", "progressDialog", "<init>", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorFragment extends ImmersivePartFragment implements BusinessObserver, SimpleEventReceiver<SimpleBaseEvent>, BorderView.b, BorderView.c, IWinkCrashReportCallback, a {

    /* renamed from: h1, reason: collision with root package name */
    private static boolean f318525h1;

    /* renamed from: i1, reason: collision with root package name */
    private static boolean f318526i1;

    /* renamed from: j1, reason: collision with root package name */
    @Nullable
    private static Job f318527j1;

    /* renamed from: k1, reason: collision with root package name */
    private static long f318528k1;

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWinkEditorLyricStickerViewModel;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: C0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditorSmartClipViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFromQQLevelH5;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditorSmartFilterViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isLightResourceLoadSucceed;

    /* renamed from: E0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEffectTimeLineViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastMusicStartTime;

    /* renamed from: F0, reason: from kotlin metadata */
    @NotNull
    private final Lazy subtitleViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private final long HDR_TIPS_SHOW_TIME;

    /* renamed from: G0, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWinkExtractCoverViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private final long MUSIC_ITEM_DELAY_TIME;

    /* renamed from: H0, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWinkExportViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView backBtn;

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditPerformanceViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView showHDRTips;

    /* renamed from: J0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditLyricStickerViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout menuBar;

    /* renamed from: K0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditorOpeningEndingViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View musicMenuItem;

    /* renamed from: L0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkMaterialViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private HDRStatusView hdrStatusView;

    /* renamed from: M0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditorChallengeViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    private BorderView stickerBorderView;

    /* renamed from: N0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkQZoneTemplateViewModel;

    /* renamed from: O0, reason: from kotlin metadata */
    @Nullable
    private Animation mFadeInAnimation;

    /* renamed from: P, reason: from kotlin metadata */
    private View bottomDashboardScrollView;

    /* renamed from: P0, reason: from kotlin metadata */
    @Nullable
    private Animation mFadeOutAnimation;

    /* renamed from: Q, reason: from kotlin metadata */
    private cx partManager;

    /* renamed from: Q0, reason: from kotlin metadata */
    @Nullable
    private String clientTraceId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Runnable realSaveRunnable;

    /* renamed from: R0, reason: from kotlin metadata */
    @NotNull
    private String tongKuanMusicMid;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mHDRTipsAnimator;

    /* renamed from: S0, reason: from kotlin metadata */
    private long curPlayerTimeUs;

    /* renamed from: T, reason: from kotlin metadata */
    private View mTopLine;

    /* renamed from: T0, reason: from kotlin metadata */
    private boolean isInStickerEdit;

    /* renamed from: U, reason: from kotlin metadata */
    private View mLeftLine;

    /* renamed from: U0, reason: from kotlin metadata */
    private long mDelayForSaveMedialModel;

    /* renamed from: V, reason: from kotlin metadata */
    private View mRightLine;

    /* renamed from: V0, reason: from kotlin metadata */
    private long mLastPublishTime;

    /* renamed from: W, reason: from kotlin metadata */
    private View mBottomLine;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private Job preloadDataJob;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private WinkAdaptiveImageView ivPreloadFrame;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy<com.tencent.mobileqq.wink.editor.hdr.k> progressDialogDelegate;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private dr curTavCut;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final TextureView.SurfaceTextureListener playerSurfaceTextureListener;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private dr videoTavCut;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dr imageTavCut;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.sticker.sticker.d stickerUpdateListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoTavCutRenderListenerAdded;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler onLoadAssetHandler;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isImageTavCutRenderListenerAdded;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q63.a loadAssetListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isInAddClipHDR;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable mTimeSaveMediaModelRunnable;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mSaveMediaRunnable;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private long showDialogTime;

    /* renamed from: f1, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f318541f1 = new LinkedHashMap();

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isExportProcessing;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isShowHDRTips;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstShow;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstDismiss;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private int deLogo;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int deBlur;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int deFace;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<byte[]> extractResult;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean jumpToPublished;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean isSaveUnDefined;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkDataServiceHandler editorDataServiceHandler;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> schemaAttrsMap;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.hdr.r lastHDRListenerDelegate;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkEditorViewModel;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkRecommendViewModel;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkHDRViewModel;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkEditorTemplateViewModel;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkTTSViewModel;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkEditorFilterViewModel;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicVolumeViewModel;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l1, reason: collision with root package name */
    private static boolean f318529l1 = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0004\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment$a;", "", "", "isFirstEnterEditor", "Z", "a", "()Z", "setFirstEnterEditor", "(Z)V", "", "ASSET_PROCESSING_PREPAREAI_BEGIN", "Ljava/lang/String;", "ASSET_PROCESSING_PREPAREAI_FINISHED", "ASSET_PROCESSING_PREPAREAI_PROCESSING_STATE", "", "CLICK_INTERNAL_TIME", "I", "CURRENT_MENU_TYPE", "", "DIALOG_LOADING_TIMEOUT_MS", "J", "EVENT_KEY_LIGHT_TEMPLATE_CACHE", "IS_LOAD_FROM_DRAFT", "IS_ORIGIN_AUDIO_ENABLED", "KEY_LIGHT_TEMPLATE_CACHE", "MAX_COUNTER_FRAME", "NEXT_BUTTON_ENABLE_TIMEOUT_MS", "TAG", "XSJ_EMOTION_NAME", "attachTime", "hasShowMusicApply", "Lkotlinx/coroutines/Job;", "musicLoadingJob", "Lkotlinx/coroutines/Job;", "showMusicApply", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.WinkEditorFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return WinkEditorFragment.f318529l1;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment$b;", "", "", "showDialog", "", "success", "e", "", "v", HippyQQPagView.FunctionName.SET_PROGRESS, "d", "b", "a", "needDeLogo", "needDeBlur", "needDeFace", "Ljava/lang/Runnable;", "enhanceProcess", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(float v3);

        void b();

        void c(boolean needDeLogo, boolean needDeBlur, boolean needDeFace, @Nullable Runnable enhanceProcess);

        void d();

        void e(boolean success);

        void setProgress(float v3);

        void showDialog();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f318562a;

        static {
            int[] iArr = new int[MenuType.values().length];
            try {
                iArr[MenuType.CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuType.CLIPPING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuType.AI_ELIMINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuType.MOSAIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuType.BOTTOM_DASHBOARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuType.TO_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MenuType.TEMPLATE_COLL_CLIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MenuType.TEMPLATE_TEXT_LIST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MenuType.OPENING_ENDING_AIGC.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f318562a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$f", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "isSuccess", "", "resCode", "", "onDownloadFinish", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements com.tencent.aelight.camera.download.a {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Tk().y5();
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(@NotNull AEMaterialMetaData info, boolean isSuccess, int resCode) {
            Intrinsics.checkNotNullParameter(info, "info");
            ms.a.f("WinkEditorFragment", "onDownloadFinish EnhanceMaterial");
            String str = u53.b.f438376g;
            FileUtils.deleteFilesInDirectory(str + File.separator);
            FileUtils.copyDirectory(info.getLocalPath(), str + QQWinkConstants.HDR_MATERIAL_PATH, false, false, false);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final WinkEditorFragment winkEditorFragment = WinkEditorFragment.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bx
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.f.b(WinkEditorFragment.this);
                }
            });
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(@NotNull AEMaterialMetaData info, int progress) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$i", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$d;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/videocut/model/Size;", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class i implements BorderView.d {
        i() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        @NotNull
        public Size a() {
            BorderView borderView = WinkEditorFragment.this.stickerBorderView;
            BorderView borderView2 = null;
            if (borderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                borderView = null;
            }
            Integer valueOf = Integer.valueOf(borderView.getWidth());
            BorderView borderView3 = WinkEditorFragment.this.stickerBorderView;
            if (borderView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            } else {
                borderView2 = borderView3;
            }
            return new Size(valueOf, Integer.valueOf(borderView2.getHeight()), null, 4, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        @NotNull
        public Size b() {
            Size M;
            dr drVar = WinkEditorFragment.this.curTavCut;
            if (drVar == null || (M = drVar.M()) == null) {
                return new Size(null, null, null, 7, null);
            }
            return M;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        public boolean isValid() {
            if (WinkEditorFragment.this.curTavCut != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$j", "Ls73/a;", "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "winkTavCut", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", "d", "", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class j implements s73.a<WinkImageTavCut> {
        j() {
        }

        @Override // s73.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull WinkImageTavCut winkTavCut) {
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            winkTavCut.D0(WinkEditorFragment.this.getStickerUpdateListener());
        }

        @Override // s73.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Object> a(@NotNull WinkImageTavCut winkTavCut) {
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            return new HashMap<>();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$k", "Ls73/a;", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "winkTavCut", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", "d", "", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class k implements s73.a<WinkVideoTavCut> {
        k() {
        }

        @Override // s73.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull WinkVideoTavCut winkTavCut) {
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            winkTavCut.addPlayerListener(WinkEditorFragment.this.getPlayerListener());
            winkTavCut.P2(WinkEditorFragment.this.playerSurfaceTextureListener);
            winkTavCut.R0(WinkEditorFragment.this.getStickerUpdateListener());
            if (WinkEditorFragment.this.Tk().getIsFromFirstTemplate()) {
                winkTavCut.J2(WinkEditorFragment.this.Tk().getIsFromFirstTemplate());
            }
        }

        @Override // s73.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Object> a(@NotNull WinkVideoTavCut winkTavCut) {
            Serializable serializable;
            Intent intent;
            Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
            winkTavCut.K2(WinkEditorFragment.this.Tk().O2());
            HashMap<String, Object> hashMap = new HashMap<>();
            WinkEditorFragment winkEditorFragment = WinkEditorFragment.this;
            if (winkEditorFragment.Tk().getIsFromZShow()) {
                s73.c.f(hashMap, MediaPickerScene.TEMPLATE_ZSHOW);
                s73.c.i(hashMap, winkEditorFragment.Tk().getTemplateMaterial());
            }
            FragmentActivity activity = winkEditorFragment.getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                serializable = intent.getSerializableExtra(QQWinkConstants.EDITOR_TEXT_MATERIAL);
            } else {
                serializable = null;
            }
            MetaMaterial metaMaterial = (MetaMaterial) serializable;
            if (metaMaterial != null) {
                s73.c.j(hashMap, metaMaterial);
            }
            s73.c.h(hashMap, true);
            s73.c.g(hashMap, winkEditorFragment.Tk().k3());
            return hashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$m", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "a", "J", "cachedCurrentDurationUs", "b", "cachedPlayerDurationUs", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class m implements IPlayer.PlayerListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long cachedCurrentDurationUs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long cachedPlayerDurationUs;

        m() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorFragment this$0, long j3, long j16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            cx cxVar = this$0.partManager;
            if (cxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar = null;
            }
            cxVar.y().Ca(j3, j16);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (WinkEditorFragment.this.isResumed()) {
                WinkEditorFragment.this.Cn();
            } else {
                WinkEditorFragment.this.hn();
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(final long currentDurationUs, long playerDurationUs) {
            if (currentDurationUs != this.cachedCurrentDurationUs || playerDurationUs != this.cachedPlayerDurationUs) {
                this.cachedCurrentDurationUs = currentDurationUs;
                this.cachedPlayerDurationUs = playerDurationUs;
                WinkEditorFragment.this.Tk().B2().postValue(Long.valueOf(currentDurationUs));
                dr drVar = WinkEditorFragment.this.curTavCut;
                if (drVar != null) {
                    playerDurationUs = drVar.getDurationUs();
                }
                final long j3 = playerDurationUs;
                long j16 = 1000;
                long a16 = com.tencent.mobileqq.wink.editor.music.a.a(currentDurationUs / j16);
                if (WinkEditorFragment.this.xk().getCurrentMusic() != null) {
                    com.tencent.mobileqq.wink.editor.music.lyric.e.a().e(a16, j3 / j16);
                }
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final WinkEditorFragment winkEditorFragment = WinkEditorFragment.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ck
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorFragment.m.b(WinkEditorFragment.this, currentDurationUs, j3);
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            WinkEditorFragment.this.Tk().A2().postValue(playerStatus);
            cx cxVar = WinkEditorFragment.this.partManager;
            if (cxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar = null;
            }
            cxVar.y().Da(playerStatus);
            WinkEditorFragment.this.Mk().f2(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$n", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "d", "I", "frameCount", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class n implements TextureView.SurfaceTextureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int frameCount;

        n() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            String str;
            Intrinsics.checkNotNullParameter(surface, "surface");
            int i3 = this.frameCount;
            if (i3 == 0) {
                WinkEditPerformanceViewModel Mk = WinkEditorFragment.this.Mk();
                boolean isUseTemplate = WinkEditorFragment.this.Sk().getIsUseTemplate();
                String wk5 = WinkEditorFragment.this.wk();
                MetaMaterial curTemplateMaterial = WinkEditorFragment.this.Sk().getCurTemplateMaterial();
                if (curTemplateMaterial != null) {
                    str = curTemplateMaterial.f30533id;
                } else {
                    str = null;
                }
                Mk.W1(isUseTemplate, wk5, str, WinkEditorFragment.this.Tk().R1(), WinkEditorFragment.this.Tk().getMagicStudioSessionID());
            } else if (i3 == 1) {
                WinkEditorFragment.this.rl();
            }
            this.frameCount++;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class o extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public o(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkEditorFragment", "preloadData exception: " + stackTraceToString);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$p", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/d;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "", "stickerModelMap", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class p implements com.tencent.mobileqq.wink.editor.sticker.sticker.d {
        p() {
        }

        @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.d
        public void a(@NotNull WinkStickerModel stickerModel, @NotNull Map<String, WinkStickerModel> stickerModelMap) {
            Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
            Intrinsics.checkNotNullParameter(stickerModelMap, "stickerModelMap");
            if (stickerModelMap.containsKey(stickerModel.id) || WinkEditorFragment.this.Qm()) {
                return;
            }
            com.tencent.mobileqq.wink.editor.sticker.control.f.INSTANCE.c(WinkEditorFragment.this, stickerModel);
        }
    }

    public WinkEditorFragment() {
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
        Lazy lazy22;
        Lazy lazy23;
        Lazy<com.tencent.mobileqq.wink.editor.hdr.k> lazy24;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(WinkEditorFragment.this);
            }
        });
        this.qqPermission = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$isFromQQLevelH5$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                Intent intent;
                FragmentActivity activity = WinkEditorFragment.this.getActivity();
                Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_attrs");
                HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
                if (hashMap != null) {
                    Object obj = hashMap.get("taskid");
                    z16 = Intrinsics.areEqual(obj != null ? obj.toString() : null, "qq_level_h5");
                } else {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        });
        this.isFromQQLevelH5 = lazy2;
        this.lastMusicStartTime = -1;
        this.HDR_TIPS_SHOW_TIME = 2000L;
        this.MUSIC_ITEM_DELAY_TIME = 200L;
        this.isFirstShow = true;
        this.isFirstDismiss = true;
        this.extractResult = new ArrayList<>();
        this.schemaAttrsMap = new HashMap<>();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditorViewModel invoke() {
                return (WinkEditorViewModel) WinkEditorFragment.this.getViewModel(WinkEditorViewModel.class);
            }
        });
        this.winkEditorViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.recommend.b>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkRecommendViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.recommend.b invoke() {
                return (com.tencent.mobileqq.wink.editor.recommend.b) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.recommend.b.class);
            }
        });
        this.winkRecommendViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.hdr.q>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkHDRViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.hdr.q invoke() {
                return (com.tencent.mobileqq.wink.editor.hdr.q) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.hdr.q.class);
            }
        });
        this.winkHDRViewModel = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.template.x>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorTemplateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.template.x invoke() {
                return (com.tencent.mobileqq.wink.editor.template.x) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
            }
        });
        this.winkEditorTemplateViewModel = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.tts.e>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkTTSViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.tts.e invoke() {
                return (com.tencent.mobileqq.wink.editor.tts.e) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.tts.e.class);
            }
        });
        this.winkTTSViewModel = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.filter.af>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorFilterViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.filter.af invoke() {
                return (com.tencent.mobileqq.wink.editor.filter.af) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.filter.af.class);
            }
        });
        this.winkEditorFilterViewModel = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$musicVolumeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorFragment.this.requireActivity()).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026rolViewModel::class.java)");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.musicVolumeViewModel = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorFragment.this.requireActivity()).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026rceViewModel::class.java)");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.music.lyric.sticker.z>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$mWinkEditorLyricStickerViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.music.lyric.sticker.z invoke() {
                return (com.tencent.mobileqq.wink.editor.music.lyric.sticker.z) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.music.lyric.sticker.z.class);
            }
        });
        this.mWinkEditorLyricStickerViewModel = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditSmartClipViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorSmartClipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditSmartClipViewModel invoke() {
                return (WinkEditSmartClipViewModel) WinkEditorFragment.this.getViewModel(WinkEditSmartClipViewModel.class);
            }
        });
        this.winkEditorSmartClipViewModel = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorSmartFilterViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorSmartFilterViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditorSmartFilterViewModel invoke() {
                return (WinkEditorSmartFilterViewModel) WinkEditorFragment.this.getViewModel(WinkEditorSmartFilterViewModel.class);
            }
        });
        this.winkEditorSmartFilterViewModel = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<m63.d>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEffectTimeLineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final m63.d invoke() {
                try {
                    return (m63.d) WinkEditorFragment.this.getViewModel(m63.d.class);
                } catch (Exception e16) {
                    w53.b.d("WinkEditorFragment", "get WinkEffectTimeLineViewModel exception", e16);
                    return null;
                }
            }
        });
        this.winkEffectTimeLineViewModel = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSubtitleViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$subtitleViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkSubtitleViewModel invoke() {
                WinkSubtitleViewModel winkSubtitleViewModel = (WinkSubtitleViewModel) WinkEditorFragment.this.getViewModel(WinkSubtitleViewModel.class);
                winkSubtitleViewModel.W2(DefaultSubtitleDataSource.f322225a, com.tencent.mobileqq.wink.editor.subtitle.a.f322144a);
                return winkSubtitleViewModel;
            }
        });
        this.subtitleViewModel = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<WinkExtractCoverViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$mWinkExtractCoverViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkExtractCoverViewModel invoke() {
                return (WinkExtractCoverViewModel) WinkEditorFragment.this.getViewModel(WinkExtractCoverViewModel.class);
            }
        });
        this.mWinkExtractCoverViewModel = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.export.u>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$mWinkExportViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.export.u invoke() {
                return (com.tencent.mobileqq.wink.editor.export.u) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
            }
        });
        this.mWinkExportViewModel = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditPerformanceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditPerformanceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditPerformanceViewModel invoke() {
                return (WinkEditPerformanceViewModel) WinkEditorFragment.this.getViewModel(WinkEditPerformanceViewModel.class);
            }
        });
        this.winkEditPerformanceViewModel = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.music.lyric.sticker.z>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditLyricStickerViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.music.lyric.sticker.z invoke() {
                return (com.tencent.mobileqq.wink.editor.music.lyric.sticker.z) WinkEditorFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.music.lyric.sticker.z.class);
            }
        });
        this.winkEditLyricStickerViewModel = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorOpeningEndingViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorFragment.this.requireActivity()).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.winkEditorOpeningEndingViewModel = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMaterialViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkMaterialViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkMaterialViewModel invoke() {
                return (WinkMaterialViewModel) WinkEditorFragment.this.getViewModel(WinkMaterialViewModel.class);
            }
        });
        this.winkMaterialViewModel = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<b63.a>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkEditorChallengeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b63.a invoke() {
                return (b63.a) WinkEditorFragment.this.getViewModel(b63.a.class);
            }
        });
        this.winkEditorChallengeViewModel = lazy22;
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<WinkQZoneTemplateLibViewModel>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$winkQZoneTemplateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkQZoneTemplateLibViewModel invoke() {
                return (WinkQZoneTemplateLibViewModel) WinkEditorFragment.this.getViewModel(WinkQZoneTemplateLibViewModel.class);
            }
        });
        this.winkQZoneTemplateViewModel = lazy23;
        this.clientTraceId = "";
        this.tongKuanMusicMid = "";
        this.mDelayForSaveMedialModel = QzoneConfig.getSaveMediaModelDuration();
        lazy24 = LazyKt__LazyJVMKt.lazy(new WinkEditorFragment$progressDialogDelegate$1(this));
        this.progressDialogDelegate = lazy24;
        this.playerSurfaceTextureListener = new n();
        this.playerListener = new m();
        this.stickerUpdateListener = new p();
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.wink.editor.p
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean bn5;
                bn5 = WinkEditorFragment.bn(WinkEditorFragment.this, message);
                return bn5;
            }
        });
        this.onLoadAssetHandler = handler;
        this.loadAssetListener = new q63.a(handler);
        this.mTimeSaveMediaModelRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$mTimeSaveMediaModelRunnable$1
            /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
            
                if (r0.O() == true) goto L8;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                dr drVar = WinkEditorFragment.this.curTavCut;
                if (drVar != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    cx cxVar = WinkEditorFragment.this.partManager;
                    if (cxVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        cxVar = null;
                    }
                    if (!cxVar.A().getMStickIsMove() && WinkEditorFragment.this.Tk().getCurMenuType() != MenuType.EFFECT) {
                        WinkEditorFragment.ln(WinkEditorFragment.this, null, false, 3, null);
                    }
                }
                if (WinkEditorFragment.this.getMDelayForSaveMedialModel() > 0) {
                    ThreadManager.getFileThreadHandler().postDelayed(this, WinkEditorFragment.this.getMDelayForSaveMedialModel());
                }
            }
        };
        this.mSaveMediaRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aa
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.Tm(WinkEditorFragment.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Al(WinkEditorFragment this$0, MenuSwitchAction menuSwitchAction) {
        int i3;
        List<WinkEditData> n3;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = null;
        if (menuSwitchAction.getMenuType() != MenuType.BOTTOM_DASHBOARD && menuSwitchAction.getMenuType() != MenuType.BACKGROUND) {
            if (menuSwitchAction.getMenuType() != MenuType.VIDEO_FIRST_TEMPLATE && (imageView = this$0.backBtn) != null) {
                imageView.setVisibility(4);
            }
            if (this$0.Tk().getEditMode() == WinkEditorViewModel.EditMode.Image) {
                WinkPlayerContainerView winkPlayerContainerView = (WinkPlayerContainerView) this$0.Fi(R.id.f25760bp);
                if (winkPlayerContainerView != null) {
                    textView = winkPlayerContainerView.getImageIndexIndicator();
                }
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            return;
        }
        ImageView imageView2 = this$0.backBtn;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        if (this$0.Tk().getEditMode() == WinkEditorViewModel.EditMode.Image) {
            dr drVar = this$0.curTavCut;
            if (drVar != null && (n3 = drVar.n()) != null) {
                i3 = n3.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                WinkPlayerContainerView winkPlayerContainerView2 = (WinkPlayerContainerView) this$0.Fi(R.id.f25760bp);
                if (winkPlayerContainerView2 != null) {
                    textView = winkPlayerContainerView2.getImageIndexIndicator();
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
        }
    }

    private final void Am(dr.WinkTavCutParams params) {
        dr drVar;
        List<MediaClip> emptyList;
        long j3;
        if (params != null && getHostActivity() != null && !getHostActivity().isFinishing() && !getHostActivity().isDestroyed()) {
            if (!Tk().getIsOpeningEndingEditMode()) {
                gk(params);
            }
            List<MediaClip> list = null;
            try {
                if (params.getEditMode() == WinkEditorViewModel.EditMode.Image) {
                    if (this.imageTavCut == null) {
                        this.imageTavCut = ((WinkPlayerContainerView) Fi(R.id.f25760bp)).c(params, new j());
                        mo(params);
                    }
                    dr drVar2 = this.videoTavCut;
                    if (drVar2 != null) {
                        drVar2.b(true);
                    }
                    this.curTavCut = this.imageTavCut;
                    BorderView borderView = this.stickerBorderView;
                    if (borderView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                        borderView = null;
                    }
                    borderView.setBorderViewEventConsumable(false);
                } else {
                    dr drVar3 = this.videoTavCut;
                    if (drVar3 == null) {
                        WinkPlayerContainerView playerContainer = (WinkPlayerContainerView) Fi(R.id.f25760bp);
                        Intrinsics.checkNotNullExpressionValue(playerContainer, "playerContainer");
                        this.videoTavCut = WinkPlayerContainerView.f(playerContainer, params, new k(), this.loadAssetListener, false, null, 24, null);
                        mo(params);
                    } else {
                        Intrinsics.checkNotNull(drVar3, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                        ((WinkVideoTavCut) drVar3).M3();
                    }
                    dr drVar4 = this.imageTavCut;
                    if (drVar4 != null) {
                        drVar4.b(true);
                    }
                    this.curTavCut = this.videoTavCut;
                    BorderView borderView2 = this.stickerBorderView;
                    if (borderView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                        borderView2 = null;
                    }
                    borderView2.setBorderViewEventConsumable(true);
                }
            } catch (Throwable th5) {
                ms.a.c("WinkEditorFragment", "initTavCut throwable:" + th5.getMessage());
            }
            Activity hostActivity = getHostActivity();
            View fragmentContentView = getFragmentContentView();
            Intrinsics.checkNotNullExpressionValue(fragmentContentView, "fragmentContentView");
            cu.H(hostActivity, fragmentContentView, Tk().getEditMode(), Tk().getIsFromTemplateLib(), Tk().getTemplateMaterial(), Tk().getIsAutoTemplate(), Tk().getIsFromZShow(), Tk().R2(), Tk().getIsOpeningEndingEditMode());
            dr drVar5 = this.curTavCut;
            if (drVar5 != null) {
                Tk().c5(drVar5.p());
                if (drVar5.p()) {
                    dr drVar6 = this.curTavCut;
                    if (drVar6 != null) {
                        drVar6.c0(true);
                    }
                    w53.b.a("WinkEditorFragment", "\u8349\u7a3f\u8fdb\u5165\u573a\u666f\u9700\u8981\u6062\u590d\u5b9e\u65f6HDR\u6548\u679c");
                    this.onLoadAssetHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ac
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkEditorFragment.Bm(WinkEditorFragment.this);
                        }
                    });
                }
            }
            dr drVar7 = this.curTavCut;
            if (drVar7 != null) {
                drVar7.b(false);
            }
            cx cxVar = this.partManager;
            if (cxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar = null;
            }
            Iterator<T> it = cxVar.x().iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.wink.editor.d) it.next()).J9(params.getEditMode());
            }
            WinkEditorViewModel.EditMode editMode = params.getEditMode();
            WinkEditorViewModel.EditMode editMode2 = WinkEditorViewModel.EditMode.Image;
            if ((editMode == editMode2 && !this.isImageTavCutRenderListenerAdded) || (params.getEditMode() == WinkEditorViewModel.EditMode.Video && !this.isVideoTavCutRenderListenerAdded)) {
                dr drVar8 = this.curTavCut;
                if (drVar8 != null) {
                    drVar8.F(new l());
                }
                if (params.getEditMode() == editMode2) {
                    this.isImageTavCutRenderListenerAdded = true;
                } else {
                    this.isVideoTavCutRenderListenerAdded = true;
                }
            }
            if (params.getIsFirstInit()) {
                if (Rm()) {
                    BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new WinkEditorFragment$initTavCut$6(this, null), 3, null);
                } else {
                    com.tencent.mobileqq.wink.editor.recommend.b Yk = Yk();
                    dr drVar9 = this.curTavCut;
                    if (drVar9 == null || (emptyList = drVar9.g0()) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    boolean isAllImages = Tk().getIsAllImages();
                    dr drVar10 = this.curTavCut;
                    if (drVar10 != null) {
                        j3 = drVar10.getDurationUs();
                    } else {
                        j3 = 0;
                    }
                    Yk.M1(emptyList, isAllImages, j3);
                }
            }
            jk();
            ln(this, null, false, 3, null);
            nn();
            An();
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MEDIA_IMPORT);
            if (!Tk().getIsFromTemplateColl()) {
                dr drVar11 = this.curTavCut;
                if (drVar11 != null) {
                    list = drVar11.g0();
                }
                if (!Qj(list) && (drVar = this.curTavCut) != null) {
                    drVar.D(false);
                }
            }
            this.isFirstShow = true;
            this.isFirstDismiss = true;
            Mk().R1(this.curTavCut);
            Mk().a2();
            Mk().Q1();
        }
    }

    private final void An() {
        boolean isBlank;
        boolean z16 = false;
        boolean booleanExtra = getHostActivity().getIntent().getBooleanExtra(QQWinkConstants.IS_AUTO_TEMPLATE, false);
        String stringExtra = getHostActivity().getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        if (!booleanExtra) {
            if (stringExtra != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra);
                if (!isBlank) {
                    z16 = true;
                }
            }
            if (z16) {
                com.tencent.mobileqq.wink.report.g.d(stringExtra, this.clientTraceId);
            }
        }
    }

    private final Map<String, WinkEditUIData> Bk() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        for (com.tencent.mobileqq.wink.editor.d dVar : cxVar.x()) {
            WinkEditUIData C9 = dVar.C9();
            if (C9 != null) {
                String str = dVar.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "it.TAG");
                linkedHashMap.put(str, C9);
            }
        }
        linkedHashMap.put(Vk().getTAG(), Vk().R1());
        if (!(!linkedHashMap.isEmpty())) {
            return null;
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bl(WinkEditorFragment this$0, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Tk().e5(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bm(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.k().fb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.hdr.k Ck() {
        return this.progressDialogDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cl(WinkEditorFragment this$0, dr.WinkTavCutParams winkTavCutParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.f("WinkEditorFragment", "tavCutParamsLiveData observer:initTavCut->" + winkTavCutParams);
        this$0.Am(winkTavCutParams);
    }

    private final void Cm() {
        Sk().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Dm(WinkEditorFragment.this, (x.UpdateTemplateAction) obj);
            }
        });
        Sk().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Em(WinkEditorFragment.this, (x.UpdateTemplateClipsAction) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Cn() {
        boolean E3 = Tk().E3();
        ms.a.f("WinkEditorFragment", "resumeBgm enableResumeBgm:" + E3 + ", editMode:" + Tk().getEditMode());
        if (E3) {
            if (Tk().getEditMode() == WinkEditorViewModel.EditMode.Image) {
                Dn();
            } else {
                En();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dl(WinkEditorFragment this$0, t73.a aVar) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            this$0.Jj(booleanValue, false, null);
            if (booleanValue) {
                str = "1";
            } else {
                str = "0";
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dm(WinkEditorFragment this$0, x.UpdateTemplateAction it) {
        List<MediaClip> list;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkEditorFragment", "initTemplateViewModel from updateTemplateActionLiveData");
        this$0.Sk().W1(it.getTemplatePath());
        dr drVar = this$0.curTavCut;
        if (drVar != null && this$0.Tk().A4()) {
            w53.b.f("WinkEditorFragment", "updateTemplate~~winkEditorTemplateViewModel ");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dr.b.o(drVar, it, true, false, null, 12, null);
        }
        if (this$0.Tk().a2()) {
            SimpleEventBus.getInstance().dispatchEvent(new TemplateSelectEvent(it.getMetaMaterial(), false));
        }
        this$0.Tk().J4(this$0);
        cx cxVar = null;
        if (!TextUtils.isEmpty(it.getTemplatePath())) {
            if (!this$0.Tk().getIsFromZShow() && !this$0.Tk().getIsFromMagicStudio()) {
                this$0.xk().d4();
            }
        } else {
            this$0.xk().T3();
            this$0.Qk().S1(null);
            dr drVar2 = this$0.curTavCut;
            if (drVar2 != null) {
                list = drVar2.g0();
            } else {
                list = null;
            }
            this$0.sn(list);
        }
        cx cxVar2 = this$0.partManager;
        if (cxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        } else {
            cxVar = cxVar2;
        }
        cxVar.m().xb(this$0.curTavCut);
        if (this$0.Tk().getIsFromTemplateColl()) {
            dr drVar3 = this$0.curTavCut;
            if (drVar3 != null) {
                j3 = drVar3.getDurationUs();
            } else {
                j3 = 0;
            }
            QLog.d("WinkEditorFragment", 4, "[updateDuration], from smartClipResultLiveData coll " + j3);
            this$0.oo(j3);
        }
        this$0.Sk().X1(true);
    }

    private final WinkStickerModel Ek(String stickerId) {
        Map<String, WinkStickerModel> m3;
        dr drVar = this.curTavCut;
        if (drVar != null && (m3 = drVar.m()) != null) {
            return m3.get(stickerId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void El(WinkEditorFragment this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = (String) aVar.a();
        if (str == null) {
            return;
        }
        this$0.no(str);
        this$0.Mn();
        this$0.Tk().S4(str + File.separator + TemplateBean.TEMPLATE_JSON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Em(WinkEditorFragment this$0, x.UpdateTemplateClipsAction it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) this$0.curTavCut;
        if (winkVideoTavCut != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkVideoTavCut.A3(it);
        }
    }

    private final void En() {
        dr drVar;
        ms.a.f("WinkEditorFragment", "resumeVideoBgm.");
        if (Km()) {
            ms.a.f("WinkEditorFragment", "resumeVideoBgm.pauseVideoBgm.");
            jn();
            return;
        }
        ms.a.f("WinkEditorFragment", "resumeVideoBgm.play.");
        cx cxVar = this.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        if (!cxVar.A().vb()) {
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar3;
            }
            if (cxVar2.D().Kb() && !Pm() && (drVar = this.curTavCut) != null) {
                drVar.play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fl(WinkEditorFragment this$0, final t73.a aVar) {
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkEditorFragment", "open guidence : " + com.tencent.mobileqq.wink.editor.hdr.a.o());
        if (!com.tencent.mobileqq.wink.editor.hdr.a.o() || (context = this$0.getContext()) == null) {
            return;
        }
        final com.tencent.mobileqq.wink.editor.hdr.m mVar = new com.tencent.mobileqq.wink.editor.hdr.m(context, R.style.atl);
        mVar.N(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.bi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorFragment.Gl(t73.a.this, mVar, view);
            }
        });
        mVar.show();
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_INTRO_PANEL);
        map.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        VideoReport.reportEvent("dt_imp", null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fn(boolean savePublishDraft) {
        boolean z16;
        InteractiveModel interactiveModel;
        boolean z17;
        Intent intent;
        if (this.curTavCut != null && Tk() != null) {
            ArrayList<LocalMediaInfo> R2 = Tk().R2();
            boolean z18 = true;
            if (R2 != null && !R2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                ms.a.i("WinkEditorFragment", "saveMediaModel... output media is null");
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Ij();
                ViewModel viewModel = new ViewModelProvider(activity).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026rolViewModel::class.java)");
                MusicVolumeControlViewModel musicVolumeControlViewModel = (MusicVolumeControlViewModel) viewModel;
                ViewModel viewModel2 = new ViewModelProvider(activity).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(owner)\u2026rceViewModel::class.java)");
                MusicSourceViewModel musicSourceViewModel = (MusicSourceViewModel) viewModel2;
                long currentTimeMillis = System.currentTimeMillis();
                WinkEditorViewModel Tk = Tk();
                dr drVar = this.curTavCut;
                Intrinsics.checkNotNull(drVar);
                cx cxVar = this.partManager;
                Intent intent2 = null;
                if (cxVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    cxVar = null;
                }
                WinkEditorChallengePart challengePart = cxVar.getChallengePart();
                if (challengePart != null) {
                    interactiveModel = challengePart.ba();
                } else {
                    interactiveModel = null;
                }
                Map<String, WinkEditUIData> Bk = Bk();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    intent2 = activity2.getIntent();
                }
                WinkEditDataWrapper N4 = Tk.N4(drVar, musicSourceViewModel, musicVolumeControlViewModel, interactiveModel, Bk, intent2);
                FragmentActivity activity3 = getActivity();
                if (activity3 != null && (intent = activity3.getIntent()) != null) {
                    z17 = intent.getBooleanExtra(QQWinkConstants.EDITOR_DISABLE_SAVE_PUBLISH_DRAFT, false);
                } else {
                    z17 = false;
                }
                if (!z17 && savePublishDraft && Tk().s4() && !isZShowTemplate()) {
                    if (Tk().getEditMode() != WinkEditorViewModel.EditMode.Image) {
                        z18 = false;
                    }
                    if (z18) {
                        Hn();
                    } else {
                        In(N4);
                    }
                }
                dr drVar2 = this.curTavCut;
                if (drVar2 != null) {
                    drVar2.u();
                }
                ms.a.a("WinkEditorFragment", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            return;
        }
        ms.a.f("WinkEditorFragment", "curTavCut == null || winkEditorViewModel == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSubtitleViewModel Gk() {
        Object value = this.subtitleViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subtitleViewModel>(...)");
        return (WinkSubtitleViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gl(t73.a aVar, com.tencent.mobileqq.wink.editor.hdr.m this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Runnable runnable = (Runnable) aVar.a();
        if (runnable != null) {
            runnable.run();
        }
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gm(WinkEditorFragment this$0, Context it, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.ll();
        un(this$0, false, 1, null);
        this$0.Tk().D4(it);
        ImageView imageView = this$0.backBtn;
        if (imageView != null) {
            cu.z(imageView, this$0.Tk().getIsFromTemplateLib());
        }
        this$0.requireActivity().finish();
    }

    static /* synthetic */ void Gn(WinkEditorFragment winkEditorFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        winkEditorFragment.Fn(z16);
    }

    private final void Hj(ArrayList<String> stickerTopicList) {
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        String joinToString$default;
        Object first;
        Intent intent;
        Intent intent2;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        MetaMaterial curTemplateMaterial = Sk().getCurTemplateMaterial();
        String str4 = null;
        if (curTemplateMaterial != null) {
            str = com.tencent.mobileqq.wink.editor.c.M0(curTemplateMaterial);
        } else {
            str = null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str2 = intent2.getStringExtra(QQWinkConstants.CAPTURE_MATERIAL_TOPIC);
        } else {
            str2 = null;
        }
        MetaMaterial curFilterMaterial = Ok().getCurFilterMaterial();
        if (curFilterMaterial != null) {
            str3 = com.tencent.mobileqq.wink.editor.c.M0(curFilterMaterial);
        } else {
            str3 = null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str4 = intent.getStringExtra(QQWinkConstants.USER_GUIDE_TOPIC);
        }
        boolean z19 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            arrayList.add(str2);
            hashSet.add(str2);
        }
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            arrayList.add(str.toString());
            hashSet.add(str);
        }
        if (!stickerTopicList.isEmpty()) {
            arrayList.addAll(stickerTopicList);
            hashSet.addAll(stickerTopicList);
        }
        if (str3 != null && str3.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18) {
            arrayList.add(str3.toString());
            hashSet.add(str3);
        }
        if (str4 == null || str4.length() == 0) {
            z19 = true;
        }
        if (!z19) {
            arrayList.add(str4);
            hashSet.add(str4);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
        w53.b.f("WinkEditorFragment", "addTopic materialSet = " + joinToString$default);
        uk().H2(new ArrayList<>(arrayList));
        if (!arrayList.isEmpty()) {
            com.tencent.mobileqq.wink.editor.export.u uk5 = uk();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            uk5.G2((String) first);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hl(WinkEditorFragment this$0, Boolean isChildShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isChildShow, "isChildShow");
        this$0.Wm(isChildShow.booleanValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0092, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Hn() {
        Unit unit;
        String str;
        Intent intent;
        ArrayList<LocalMediaInfo> R2 = Tk().R2();
        if (R2 != null) {
            if (!R2.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<T> it = R2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).path);
                }
                ms.a.a("WinkEditorFragment", "savePicDraft... pathList: " + arrayList);
                LocalMediaInfo localMediaInfo = R2.get(0);
                Intrinsics.checkNotNullExpressionValue(localMediaInfo, "get(0)");
                LocalMediaInfo localMediaInfo2 = localMediaInfo;
                LocalMediaInfo localMediaInfo3 = new LocalMediaInfo();
                localMediaInfo3.path = localMediaInfo2.path;
                localMediaInfo3.mMimeType = "image/jpeg";
                localMediaInfo3.mediaHeight = localMediaInfo2.mediaHeight;
                localMediaInfo3.mediaWidth = localMediaInfo2.mediaWidth;
                localMediaInfo3.mOriginPath = arrayList;
                HashMap hashMap = new HashMap();
                String str2 = localMediaInfo2.path;
                Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
                hashMap.put(str2, localMediaInfo3);
                FragmentActivity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    Intrinsics.checkNotNullExpressionValue(intent, "intent");
                    str = TagRetriever.f326413a.f(intent);
                }
                str = "";
                WinkDraftUtil.INSTANCE.s(new c.a(Tk().getMissionId(), 4, arrayList, hashMap).F(str).E(this.clientTraceId).A());
            } else {
                ms.a.i("WinkEditorFragment", "savePicDraft... output media is empty");
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ms.a.i("WinkEditorFragment", "savePicDraft... output media is null");
        }
    }

    private final void Ij() {
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        c73.a s16 = cxVar.s();
        if (s16 != null) {
            s16.Y2();
        }
    }

    private final void Il() {
        uk().h2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Jl(WinkEditorFragment.this, (Integer) obj);
            }
        });
    }

    private final boolean Im(List<? extends MediaClip> mediaClips) {
        return com.tencent.videocut.render.extension.e.u(mediaClips);
    }

    private final void Jj(boolean beginHDR, boolean needConfirm, List<? extends MediaClip> enhanceCheckClips) {
        long j3;
        Long l3;
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        List<WinkEditData> n3;
        if (beginHDR) {
            boolean z16 = this.curTavCut instanceof WinkVideoTavCut;
            String missionId = Tk().getMissionId();
            int K2 = Tk().K2();
            ArrayList<LocalMediaInfo> R2 = Tk().R2();
            int O2 = Tk().O2();
            dr drVar = this.curTavCut;
            if (drVar != null) {
                j3 = drVar.getDurationUs();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            boolean isFromCapture = Tk().getIsFromCapture();
            boolean isFromQzoneText = Tk().getIsFromQzoneText();
            boolean isFromTemplateColl = Tk().getIsFromTemplateColl();
            ArrayList<String> k26 = Tk().k2();
            if (k26 == null) {
                k26 = new ArrayList<>();
            }
            ArrayList<String> arrayList = k26;
            int j26 = Tk().j2();
            String textQzoneText = Tk().getTextQzoneText();
            WinkEditorMusicInfo currentMusic = xk().getCurrentMusic();
            if (currentMusic != null) {
                l3 = Long.valueOf(currentMusic.o());
            } else {
                l3 = null;
            }
            WinkEditorMusicInfo currentMusic2 = xk().getCurrentMusic();
            if (currentMusic2 != null) {
                str = currentMusic2.q();
            } else {
                str = null;
            }
            WinkEditorMusicInfo currentMusic3 = xk().getCurrentMusic();
            if (currentMusic3 != null) {
                str2 = currentMusic3.r();
            } else {
                str2 = null;
            }
            WinkEditorMusicInfo currentMusic4 = xk().getCurrentMusic();
            if (currentMusic4 != null) {
                num = Integer.valueOf(currentMusic4.n());
            } else {
                num = null;
            }
            WinkEditorMusicInfo currentMusic5 = xk().getCurrentMusic();
            if (currentMusic5 != null) {
                str3 = currentMusic5.p();
            } else {
                str3 = null;
            }
            MusicSourceViewModel xk5 = xk();
            WinkEditorMusicInfo currentMusic6 = xk().getCurrentMusic();
            if (currentMusic6 == null || (str4 = currentMusic6.p()) == null) {
                str4 = "";
            }
            Integer m3 = xk5.m3(str4);
            int useHD = Tk().getUseHD();
            Float value = yk().h2().getValue();
            if (value == null) {
                value = Float.valueOf(0.0f);
            }
            Float value2 = yk().T1().getValue();
            if (value2 == null) {
                value2 = Float.valueOf(0.0f);
            }
            MusicVolumeControlViewModel.VolumeType f26 = yk().f2();
            boolean z17 = com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip;
            String str5 = Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
            if (str5 == null) {
                str5 = "QCIRCLE";
            }
            WinkEditDataWrapper winkEditDataWrapper = new WinkEditDataWrapper(missionId, Integer.valueOf(K2), null, R2, null, Integer.valueOf(O2), null, j16, isFromCapture, str3, m3, false, useHD, value.floatValue(), value2.floatValue(), f26, z17, null, str5, Tk().getIsEnableSwitchEditMode(), 0L, l3, str, Tk().getIsEnableMusic(), 0L, false, null, isFromQzoneText, textQzoneText, isFromTemplateColl, arrayList, j26, Tk().getCaptureMaterialId(), Tk().getEnableImageTransition(), Tk().getIsHDRExporting(), null, false, false, false, Tk().getCaptureMaterialName(), str2, num, Tk().getWatermarkConfig(), false, 118622276, 2168, null);
            dr drVar2 = this.curTavCut;
            if (drVar2 != null && (n3 = drVar2.n()) != null) {
                winkEditDataWrapper.getEditDatas().addAll(n3);
            }
            Vk().f2(true);
            b ik5 = ik(enhanceCheckClips, needConfirm);
            this.lastHDRListenerDelegate = new com.tencent.mobileqq.wink.editor.hdr.r(ik5);
            Object newProxyInstance = Proxy.newProxyInstance(ik5.getClass().getClassLoader(), ik5.getClass().getInterfaces(), this.lastHDRListenerDelegate);
            Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkEditorFragment.ExportProgressListener");
            uk().b2(this, z16, needConfirm, winkEditDataWrapper, enhanceCheckClips, (b) newProxyInstance);
            return;
        }
        Kj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jl(WinkEditorFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HDRStatusView hDRStatusView = null;
        if (num != null && num.intValue() == 2) {
            HDRStatusView hDRStatusView2 = this$0.hdrStatusView;
            if (hDRStatusView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
            } else {
                hDRStatusView = hDRStatusView2;
            }
            hDRStatusView.g();
            return;
        }
        if (num != null && num.intValue() == 0) {
            HDRStatusView hDRStatusView3 = this$0.hdrStatusView;
            if (hDRStatusView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
            } else {
                hDRStatusView = hDRStatusView3;
            }
            hDRStatusView.b(false);
        }
    }

    private final boolean Jm() {
        return ((Boolean) this.isFromQQLevelH5.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jn(WinkEditorFragment this$0, LocalMediaInfo localMediaInfo, String thumbfilePath, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thumbfilePath, "$thumbfilePath");
        ms.a.f("WinkEditorFragment", "saveVideoDraft... getVideoCover:" + z16);
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
            this$0.Kn(localMediaInfo, thumbfilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kj() {
        Lj();
        dr drVar = this.curTavCut;
        if (drVar != null) {
            drVar.c0(false);
        }
        w53.b.a("WinkEditorFragment", "\u53d6\u6d88\u753b\u8d28\u589e\u5f3a\u65f6\uff0c\u9700\u8981\u5173\u95ed\u5b9e\u65f6hdr\u6548\u679c");
        uk().S1();
        wn();
    }

    private final void Kl() {
        vk().m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Ll(WinkEditorFragment.this, (WinkExtractCoverViewModel.c) obj);
            }
        });
    }

    private final boolean Km() {
        if (this.progressDialogDelegate.isInitialized() && Ck().getDialog().isShowing()) {
            return true;
        }
        return false;
    }

    private final void Kn(LocalMediaInfo localMediaInfo, String thumbfilePath) {
        String str;
        ha3.b bVar;
        Object firstOrNull;
        Intent intent;
        if (Tk().getIsOpeningEndingEditMode()) {
            ms.a.f("WinkEditorFragment", "saveVideoDraftWithThumb return:isOpeningEndingEditMode");
            return;
        }
        if (Tk().getIsDraftDeletedWhenBack()) {
            ms.a.f("WinkEditorFragment", "saveVideoDraftWithThumb return:isDraftDeletedWhenBack");
            Tk().X4(false);
            return;
        }
        localMediaInfo.thumbnailPath = thumbfilePath;
        ms.a.f("WinkEditorFragment", "saveVideoDraftWithThumb... thumbnailPath:" + thumbfilePath);
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMediaInfo.path);
        HashMap hashMap = new HashMap();
        String str2 = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
        hashMap.put(str2, localMediaInfo);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = TagRetriever.f326413a.f(intent)) == null) {
            str = "";
        }
        WinkDraftUtil.Companion companion = WinkDraftUtil.INSTANCE;
        List<ha3.b> l3 = companion.l(com.tencent.mobileqq.wink.utils.aj.c(), Tk().getMissionId());
        if (l3 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) l3);
            bVar = (ha3.b) firstOrNull;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f404619d = str;
            bVar.f404621f = arrayList;
            bVar.f404622g = hashMap;
            if (this.isSaveUnDefined) {
                bVar.f404626k = 0;
                this.isSaveUnDefined = false;
            } else {
                bVar.f404626k = 5;
            }
            companion.r(bVar);
            return;
        }
        companion.s(new c.a(Tk().getMissionId(), 4, arrayList, hashMap).F(str).E(this.clientTraceId).A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lj() {
        com.tencent.mobileqq.wink.editor.hdr.r rVar = this.lastHDRListenerDelegate;
        if (rVar != null) {
            rVar.a(false);
        }
        this.lastHDRListenerDelegate = null;
    }

    private final com.tencent.mobileqq.wink.editor.music.lyric.sticker.z Lk() {
        Object value = this.winkEditLyricStickerViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditLyricStickerViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.music.lyric.sticker.z) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ll(WinkEditorFragment this$0, WinkExtractCoverViewModel.c cVar) {
        Window window;
        Intent intent;
        Intent intent2;
        Map<String, String> b16;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar.b() == 0) {
            dr drVar = this$0.curTavCut;
            if (drVar != null) {
                drVar.pause();
            }
            if (!this$0.Tk().getIsOpeningEndingEditMode()) {
                this$0.Yn(HardCodeUtil.qqStr(R.string.ymp), true, 0L, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.editor.bl
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        WinkEditorFragment.Ml(dialogInterface);
                    }
                });
                return;
            }
            return;
        }
        boolean z16 = false;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        bundle = null;
        if (cVar.b() == 2) {
            this$0.Vj();
            Context context = this$0.getContext();
            Context context2 = this$0.getContext();
            if (context2 != null) {
                str2 = context2.getString(R.string.f239337m7);
            }
            QQToast.makeText(context, -1, str2, 0).show();
            return;
        }
        if (cVar.b() != 1 && cVar.b() != 4) {
            if (cVar.b() == 3) {
                this$0.Yn(HardCodeUtil.qqStr(R.string.ymm), true, 0L, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.editor.bm
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        WinkEditorFragment.Nl(dialogInterface);
                    }
                });
                return;
            }
            if (cVar.b() == 5) {
                this$0.Vj();
                Context context3 = this$0.getContext();
                Context context4 = this$0.getContext();
                if (context4 != null) {
                    str3 = context4.getString(R.string.ymn);
                }
                QQToast.makeText(context3, -1, str3, 0).show();
                return;
            }
            return;
        }
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.t().W9();
        this$0.Vj();
        if (this$0.Tk().getIsFromFirstTemplate()) {
            com.tencent.mobileqq.wink.editor.template.c cVar2 = com.tencent.mobileqq.wink.editor.template.c.f322362a;
            cx cxVar2 = this$0.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar2 = null;
            }
            TextView Z9 = cxVar2.t().Z9();
            MetaMaterial curTemplateMaterial = this$0.Sk().getCurTemplateMaterial();
            if (curTemplateMaterial != null) {
                str = curTemplateMaterial.f30533id;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            cVar2.c(Z9, str, this$0.Tk().a2(), this$0.Tk().getIsUserImageReplaced());
        }
        if (!Intrinsics.areEqual(this$0.Tk().E2(), "0") && (b16 = com.tencent.mobileqq.wink.schema.d.f326305a.b(WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.DATONG_REPORT_ELEMENT_PARAMS))) != null) {
            cx cxVar3 = this$0.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar3 = null;
            }
            View dailySendBtn = cxVar3.t().getDailySendBtn();
            if (dailySendBtn != null) {
                cu.g(dailySendBtn, "em_xsj_publish_button", b16, null, 8, null);
            }
        }
        if (!this$0.Tk().a2() && Intrinsics.areEqual(this$0.Tk().E2(), "0")) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkEditorFragment$initExtractCoverViewModel$1$3(this$0, cVar, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(this$0.Tk().E2(), "3")) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                intent2.putExtra(QQWinkConstants.WINK_PUBLISH_PARAM_DAILY_PARAMS, new DailyInfo(true, DailyNextBtnPart.INSTANCE.c(), null, 4, null));
                intent2.putExtra(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA, this$0.uk().m2());
                ArrayList<LocalMediaInfo> a16 = cVar.a();
                Intrinsics.checkNotNullExpressionValue(a16, "it.coverFiles");
                intent2.putExtra(QQWinkConstants.TEMP_PARAMS_LOCAL_MEDIA_INFO_LIST, this$0.lk(a16));
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkEditorFragment$initExtractCoverViewModel$1$5(this$0, cVar, null), 3, null);
            return;
        }
        String string = this$0.getString(R.string.f240007o0);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wink_first_template_tag)");
        String p16 = WinkContext.INSTANCE.d().p("content");
        if (p16 != null) {
            if (p16.length() > 0) {
                z16 = true;
            }
            if (z16) {
                string = p16;
            }
        }
        ArrayList<LocalMediaInfo> a17 = cVar.a();
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        this$0.Rj(a17, string, bundle);
        this$0.startActivity(this$0.Tk().S2());
        Activity hostActivity = this$0.getHostActivity();
        if (hostActivity != null && (window = hostActivity.getWindow()) != null) {
            window.setWindowAnimations(R.style.f2436019);
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 13, null), true);
    }

    private final boolean Lm() {
        boolean z16;
        Intent intent;
        String str = this.schemaAttrsMap.get("target");
        if (Intrinsics.areEqual(str, "20") || Intrinsics.areEqual(str, "19")) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && intent.getBooleanExtra(QQWinkConstants.QZONE_TEMPLATE_LIB_IS_IMAGE_TEMPLATE, false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ln() {
        String str;
        int i3;
        FragmentActivity activity;
        String str2;
        FragmentActivity activity2;
        FragmentActivity activity3;
        Intent intent;
        Intent intent2;
        String a06;
        Intent intent3;
        Intent intent4;
        if (WinkContext.INSTANCE.d().u("QZONE") && Intrinsics.areEqual(WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE), QQWinkConstants.QZONE_LIBTEMPLATE)) {
            FragmentActivity activity4 = getActivity();
            if (activity4 != null && (intent4 = activity4.getIntent()) != null) {
                str = intent4.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
            } else {
                str = null;
            }
            boolean z16 = true;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1723175553) {
                    if (hashCode == -167123713 && str.equals("operation_material")) {
                        i3 = 1;
                    }
                } else if (str.equals("normal_material")) {
                    i3 = 0;
                }
                activity = getActivity();
                String str3 = "";
                if (activity != null || (intent3 = activity.getIntent()) == null || (str2 = intent3.getStringExtra(QQWinkConstants.CAPTURE_MATERIAL_NAME)) == null) {
                    str2 = "";
                }
                if (str2.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    MetaMaterial curTemplateMaterial = Sk().getCurTemplateMaterial();
                    if (curTemplateMaterial != null && (a06 = com.tencent.mobileqq.wink.editor.c.a0(curTemplateMaterial)) != null) {
                        str3 = a06;
                    }
                    str2 = str3;
                }
                ms.a.f("WinkEditorFragment", "setQzoneMaterialInfo... captureId:" + str2 + ", materialType = " + i3);
                activity2 = getActivity();
                if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                    intent2.putExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE, String.valueOf(i3));
                }
                activity3 = getActivity();
                if (activity3 == null && (intent = activity3.getIntent()) != null) {
                    intent.putExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME, str2);
                    return;
                }
            }
            i3 = -1;
            activity = getActivity();
            String str32 = "";
            if (activity != null) {
            }
            str2 = "";
            if (str2.length() != 0) {
            }
            if (z16) {
            }
            ms.a.f("WinkEditorFragment", "setQzoneMaterialInfo... captureId:" + str2 + ", materialType = " + i3);
            activity2 = getActivity();
            if (activity2 != null) {
                intent2.putExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE, String.valueOf(i3));
            }
            activity3 = getActivity();
            if (activity3 == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mj(boolean needShowToast) {
        String str;
        boolean z16 = true;
        f318526i1 = true;
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        if (qCircleCommonLoadingDialog == null || !qCircleCommonLoadingDialog.isShowing()) {
            z16 = false;
        }
        if (z16 && f318525h1) {
            Vj();
            f318525h1 = false;
            if (needShowToast) {
                Context context = getContext();
                Context context2 = getContext();
                if (context2 != null) {
                    str = context2.getString(R.string.f216095xd);
                } else {
                    str = null;
                }
                QQToast.makeText(context, -1, str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditPerformanceViewModel Mk() {
        Object value = this.winkEditPerformanceViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditPerformanceViewModel>(...)");
        return (WinkEditPerformanceViewModel) value;
    }

    private final boolean Mm() {
        if (Tk().getCurMenuType() != MenuType.SUBTITLE && Tk().getCurMenuType() != MenuType.FILTER && Tk().getCurMenuType() != MenuType.VIDEO_TEMPLATE && Tk().getCurMenuType() != MenuType.MUSIC && Tk().getCurMenuType() != MenuType.LYRIC_STICKER && Tk().getCurMenuType() != MenuType.STICKER_TIMELINE) {
            return true;
        }
        return false;
    }

    private final void Mn() {
        ImageView imageView = this.backBtn;
        if (imageView != null && imageView.getVisibility() != 0) {
            Nj(this.backBtn, 0);
        }
        final View view = this.musicMenuItem;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bn
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.Nn(view, this);
                }
            }, this.MUSIC_ITEM_DELAY_TIME);
        }
    }

    private final void Nj(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    private final b63.a Nk() {
        Object value = this.winkEditorChallengeViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorChallengeViewModel>(...)");
        return (b63.a) value;
    }

    private final boolean Nm() {
        String str;
        Intent intent;
        if (DailyNextBtnPart.INSTANCE.g() && Tk().getMFrom() != 8) {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra(WinkSchemeConstant.SchemeKey.KEY_SCHEMA_FIRST_TEMPLATE);
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, "1")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nn(View it, WinkEditorFragment this$0) {
        View view;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.getVisibility() != 0 && (view = this$0.musicMenuItem) != null) {
            view.setVisibility(0);
        }
    }

    private final void Oj(View view, int visibility) {
        boolean z16 = false;
        if (view != null && view.getVisibility() == visibility) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (visibility == 0) {
            if (view != null) {
                view.setVisibility(visibility);
            }
            if (view != null) {
                view.startAnimation(pk());
                return;
            }
            return;
        }
        if (view != null) {
            view.startAnimation(qk());
        }
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.filter.af Ok() {
        Object value = this.winkEditorFilterViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorFilterViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.filter.af) value;
    }

    private final void Ol() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 0.0f).setDuration(this.HDR_TIPS_SHOW_TIME);
        this.mHDRTipsAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.x
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WinkEditorFragment.Pl(WinkEditorFragment.this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mHDRTipsAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new g());
        }
    }

    private final boolean Om() {
        boolean z16;
        boolean z17;
        if (!xk().getNeedAutoMusic()) {
            return false;
        }
        ArrayList<LocalMediaInfo> R2 = Tk().R2();
        if (R2 != null) {
            if (R2.size() > 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if ((z16 && !Tk().getIsAllImages()) || Tk().getIsFromTemplateLib() || !MusicOptimizeManager.f321154a.c()) {
                    return false;
                }
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
        return true;
    }

    private final void Pj() {
        Long N = uq3.o.N(7000L);
        Intrinsics.checkNotNullExpressionValue(N, "getBgmJudgeOverTime(7000L)");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkEditorFragment$checkOriBgmByLocal$1(N.longValue(), this, System.currentTimeMillis(), null), 3, null);
    }

    private final WinkEditorOpeningEndingViewModel Pk() {
        return (WinkEditorOpeningEndingViewModel) this.winkEditorOpeningEndingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pl(WinkEditorFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        TextView textView = this$0.showHDRTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
            textView = null;
        }
        textView.setAlpha(floatValue);
    }

    private final boolean Pm() {
        boolean z16;
        cx cxVar = null;
        if (cx.INSTANCE.e()) {
            cx cxVar2 = this.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar2 = null;
            }
            z16 = cxVar2.J().visible;
        } else {
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar3 = null;
            }
            z16 = cxVar3.I().visible;
        }
        if (!z16) {
            cx cxVar4 = this.partManager;
            if (cxVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar4 = null;
            }
            if (!cxVar4.B().visible) {
                cx cxVar5 = this.partManager;
                if (cxVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    cxVar5 = null;
                }
                if (!cxVar5.C().visible) {
                    cx cxVar6 = this.partManager;
                    if (cxVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    } else {
                        cxVar = cxVar6;
                    }
                    if (!cxVar.F().visible) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final void Pn() {
        final ActionSheet create = ActionSheet.create(getContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(context)");
        create.setMainTitle(R.string.f184563m8);
        create.addButton(R.string.f184583m_, 1);
        create.addButton(R.string.f184533m5, 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.wink.editor.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                WinkEditorFragment.Qn(WinkEditorFragment.this, create, view, i3);
            }
        });
        if (!requireActivity().isFinishing() && !create.isShowing()) {
            create.show();
        }
    }

    private final boolean Qj(List<? extends MediaClip> mediaClips) {
        int i3;
        int i16;
        int coerceAtLeast;
        SizeF sizeF;
        SizeF sizeF2;
        if (mediaClips != null) {
            Iterator<T> it = mediaClips.iterator();
            while (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null && (sizeF2 = resourceModel.size) != null) {
                    i3 = (int) sizeF2.width;
                } else {
                    i3 = 0;
                }
                if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                    i16 = (int) sizeF.height;
                } else {
                    i16 = 0;
                }
                w53.b.a("WinkEditorFragment", "WinkEditorFragment.contains4KSizeMediaClip clipWidth:" + i3 + ", clipHeight:" + i16);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, i16);
                if (coerceAtLeast >= 3840) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditSmartClipViewModel Qk() {
        Object value = this.winkEditorSmartClipViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorSmartClipViewModel>(...)");
        return (WinkEditSmartClipViewModel) value;
    }

    private final void Ql() {
        Lk().a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Rl(WinkEditorFragment.this, (LyricSticker) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Qn(final WinkEditorFragment this$0, ActionSheet cancelActionSheet, View view, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelActionSheet, "$cancelActionSheet");
        if (i3 == 0) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.w
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.Rn(WinkEditorFragment.this);
                }
            });
            if (this$0.Tk().g4()) {
                this$0.jo();
                z16 = true;
                cancelActionSheet.superDismiss();
                if (z16) {
                    this$0.pn();
                    return;
                }
                return;
            }
        }
        z16 = false;
        cancelActionSheet.superDismiss();
        if (z16) {
        }
    }

    private final void Rj(ArrayList<LocalMediaInfo> covers, final String tag, final Bundle bundle) {
        if (System.currentTimeMillis() - this.mLastPublishTime >= 1000 && covers != null && covers.size() <= 1 && !TextUtils.isEmpty(covers.get(0).path)) {
            final String str = covers.get(0).path;
            this.mLastPublishTime = System.currentTimeMillis();
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bp
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.Sj(WinkEditorFragment.this, str, tag, bundle);
                }
            });
        }
    }

    private final WinkEditorSmartFilterViewModel Rk() {
        Object value = this.winkEditorSmartFilterViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorSmartFilterViewModel>(...)");
        return (WinkEditorSmartFilterViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rl(WinkEditorFragment this$0, LyricSticker lyricSticker) {
        MediaClip mediaClip;
        ResourceModel resourceModel;
        List<MediaClip> a06;
        Object first;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lyricSticker, "lyricSticker");
        cx cxVar = this$0.partManager;
        MediaClipUseType mediaClipUseType = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.A().M1();
        dr drVar = this$0.curTavCut;
        if (drVar != null && (a06 = drVar.a0()) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) a06);
            mediaClip = (MediaClip) first;
        } else {
            mediaClip = null;
        }
        if (mediaClip != null) {
            mediaClipUseType = com.tencent.videocut.render.extension.e.r(mediaClip);
        }
        long j3 = 0;
        if (mediaClipUseType == MediaClipUseType.OPENING && (resourceModel = mediaClip.resource) != null) {
            j3 = resourceModel.scaleDuration;
        }
        e73.a.f395827a.b(this$0.curTavCut, lyricSticker, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Rm() {
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2") && Tk().s4()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rn(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Gn(this$0, false, 1, null);
        IWinkDraft iWinkDraft = (IWinkDraft) QRoute.api(IWinkDraft.class);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        iWinkDraft.updateUploadStatus(Long.parseLong(account), this$0.Tk().getMissionId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sj(WinkEditorFragment this$0, String str, String tag, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Gn(this$0, false, 1, null);
        com.tencent.mobileqq.wink.editor.draft.a.i(this$0.uk().o2(), this$0.Tk().getMissionId());
        OneClickPublishingHelper.z(OneClickPublishingHelper.f325628a, 0, this$0.Tk().getMissionId(), str, tag, bundle, false, 32, null);
    }

    private final void Sl(View view) {
        int i3;
        ConstraintLayout.LayoutParams layoutParams;
        Integer num;
        if (!Tk().getIsOpeningEndingEditMode() && Tk().getIsEnableMusic()) {
            if (cx.INSTANCE.f()) {
                i3 = R.id.zjq;
            } else {
                i3 = R.id.zjp;
            }
            View findViewById = view.findViewById(i3);
            findViewById.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            Integer num2 = null;
            if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                num = Integer.valueOf(((ViewGroup.MarginLayoutParams) layoutParams).topMargin - com.tencent.mobileqq.wink.editor.util.m.m(findViewById.getContext()));
            } else {
                num = null;
            }
            if (num != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = num.intValue();
            }
            if (layoutParams != null) {
                num2 = Integer.valueOf(((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
            }
            ms.a.a("WinkEditorFragment", "AFTER music top:" + num2);
            this.musicMenuItem = findViewById;
        }
    }

    private final void Sn() {
        final ActionSheet create = ActionSheet.create(getContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(context)");
        create.setMainTitle(R.string.f184563m8);
        create.addButton(R.string.f184583m_, 1);
        create.addButton(R.string.f184533m5, 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.wink.editor.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                WinkEditorFragment.Tn(WinkEditorFragment.this, create, view, i3);
            }
        });
        if (!requireActivity().isFinishing() && !create.isShowing()) {
            create.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Tj(ArrayList<LocalMediaInfo> covers, final String content, final Bundle bundle) {
        if (System.currentTimeMillis() - this.mLastPublishTime >= 1000 && covers != null && !TextUtils.isEmpty(covers.get(0).path)) {
            final String str = covers.get(0).path;
            this.mLastPublishTime = System.currentTimeMillis();
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bo
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.Uj(WinkEditorFragment.this, str, content, bundle);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Tl() {
        boolean z16;
        boolean z17;
        ArrayList<LocalMediaInfo> R2;
        int i3;
        MarqueeTextView marqueeTextView;
        WinkMusicButton winkMusicButton;
        String p16;
        Integer intOrNull;
        dr drVar;
        Serializable serializable;
        boolean z18;
        boolean z19;
        boolean z26;
        float Z1;
        Intent intent;
        List<MediaClip> list;
        MediaModel V;
        boolean z27;
        boolean z28;
        WinkEditDataWrapper originEditData;
        xk().v4();
        if (Tk().k3() && (originEditData = Tk().getOriginEditData()) != null) {
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip = originEditData.isSmartClipActive();
        }
        il();
        if (Tk().getIsFromZShow()) {
            xk().q4(true);
            if (!cx.INSTANCE.f()) {
                xk().U4();
            }
            xk().u4(true);
        }
        if (WinkEditorMusicConfig.f321149a.a() && Tk().getIsSingleVideo()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!Tk().getIsFromTemplateLib()) {
            ArrayList<LocalMediaInfo> R22 = Tk().R2();
            if (R22 != null) {
                if (R22.size() > 1) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (z28) {
                    z27 = true;
                    if (z27 && MusicOptimizeManager.f321154a.c()) {
                        z17 = true;
                        boolean a16 = MusicOptimizeManager.f321154a.a();
                        w53.b.f("WinkEditorFragment", "[initMusicSourceViewModel], isSingleVideoAutoMusic=" + z16 + ", isMultiVideoPhotoAutoMusic=" + z17 + ", disableAutoMusic=" + a16);
                        if ((Tk().getIsLoadFromDraft() || TextUtils.isEmpty(Tk().getDraftMusicMid())) && !Tk().getIsLoadFromDraft() && !Tk().X3()) {
                            if (Tk().getIsAllImages()) {
                                xk().u4(true);
                                yk().H2(false);
                            } else if (!a16 && (z16 || z17)) {
                                xk().u4(true);
                            }
                            ao(3000L);
                        }
                        if (!Tk().getIsLoadFromDraft() && !Tk().X3()) {
                            boolean isUseTemplate = Sk().getIsUseTemplate();
                            drVar = this.curTavCut;
                            if (drVar instanceof WinkVideoTavCut) {
                                if (drVar != null && (V = drVar.V()) != null) {
                                    list = V.videos;
                                } else {
                                    list = null;
                                }
                                if (!Im(list)) {
                                    yk().H2(true);
                                    if (!Tk().getIsAllImages()) {
                                        FragmentActivity activity = getActivity();
                                        if (activity != null && (intent = activity.getIntent()) != null) {
                                            serializable = intent.getSerializableExtra(QQWinkConstants.RECOMMEND_MUSIC_INFO_BYTES);
                                        } else {
                                            serializable = null;
                                        }
                                        MusicVolumeControlViewModel yk5 = yk();
                                        if (serializable == null && !yk().s2()) {
                                            z18 = false;
                                        } else {
                                            z18 = true;
                                        }
                                        yk5.n2(z18, isUseTemplate);
                                        yk().Q1(yk().d2());
                                        if (this.tongKuanMusicMid.length() > 0) {
                                            z19 = true;
                                        } else {
                                            z19 = false;
                                        }
                                        if (!z19 && !z16 && !z17) {
                                            z26 = false;
                                        } else {
                                            z26 = true;
                                        }
                                        if (cx.INSTANCE.f()) {
                                            if (!z26 && !Tk().getIsFromZShow() && !Tk().getIsFromMagicStudio()) {
                                                z26 = false;
                                            } else {
                                                z26 = true;
                                            }
                                        }
                                        if (z26) {
                                            Z1 = VolumeValueCache.INSTANCE.a();
                                        } else {
                                            Z1 = yk().Z1();
                                        }
                                        yk().S1(Z1, MusicVolumeControlViewModel.VolumeType.BGM);
                                    } else {
                                        MusicVolumeControlViewModel.z2(yk(), true, false, 2, null);
                                        yk().n2(true, isUseTemplate);
                                        float b16 = VolumeValueCache.INSTANCE.b();
                                        yk().L2(b16);
                                        yk().S1(b16, MusicVolumeControlViewModel.VolumeType.BGM);
                                    }
                                }
                            }
                            yk().H2(false);
                            if (!Tk().getIsAllImages()) {
                            }
                        }
                        if (!TextUtils.isEmpty(this.tongKuanMusicMid)) {
                            xk().u4(true);
                        }
                        R2 = Tk().R2();
                        if (R2 != null) {
                            i3 = R2.size();
                        } else {
                            i3 = 0;
                        }
                        if (i3 > 1 && (p16 = WinkContext.INSTANCE.d().p("up_source")) != null && intOrNull != null && intOrNull.intValue() == 10) {
                            xk().u4(true);
                            yk().S1(1.0f, MusicVolumeControlViewModel.VolumeType.BGM);
                        }
                        w53.b.a("WinkEditorFragment", "[initMusicSourceViewModel] needAutoMusic:" + xk().getNeedAutoMusic());
                        if (!xk().getNeedAutoMusic() && !Tk().getIsAutoTemplate()) {
                            xk().g3().postValue(null);
                        }
                        if (xk().getNeedAutoMusic()) {
                            if (cx.INSTANCE.f()) {
                                View view = this.musicMenuItem;
                                if (view instanceof WinkMusicButton) {
                                    winkMusicButton = (WinkMusicButton) view;
                                } else {
                                    winkMusicButton = null;
                                }
                                if (winkMusicButton != null) {
                                    WinkMusicButton.o(winkMusicButton, null, 1, null);
                                }
                            } else {
                                View view2 = this.musicMenuItem;
                                if (view2 instanceof MarqueeTextView) {
                                    marqueeTextView = (MarqueeTextView) view2;
                                } else {
                                    marqueeTextView = null;
                                }
                                if (marqueeTextView != null) {
                                    MarqueeTextView.l(marqueeTextView, null, 1, null);
                                }
                            }
                        }
                        if (!Um() && WinkInferenceResManager.f322940a.F("yamnet")) {
                            Pj();
                            return;
                        } else {
                            xk().w4(false);
                        }
                    }
                }
            }
            z27 = false;
            if (z27) {
                z17 = true;
                boolean a162 = MusicOptimizeManager.f321154a.a();
                w53.b.f("WinkEditorFragment", "[initMusicSourceViewModel], isSingleVideoAutoMusic=" + z16 + ", isMultiVideoPhotoAutoMusic=" + z17 + ", disableAutoMusic=" + a162);
                if (Tk().getIsLoadFromDraft()) {
                }
                if (Tk().getIsAllImages()) {
                }
                ao(3000L);
                if (!Tk().getIsLoadFromDraft()) {
                    boolean isUseTemplate2 = Sk().getIsUseTemplate();
                    drVar = this.curTavCut;
                    if (drVar instanceof WinkVideoTavCut) {
                    }
                    yk().H2(false);
                    if (!Tk().getIsAllImages()) {
                    }
                }
                if (!TextUtils.isEmpty(this.tongKuanMusicMid)) {
                }
                R2 = Tk().R2();
                if (R2 != null) {
                }
                if (i3 > 1) {
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(p16);
                    xk().u4(true);
                    yk().S1(1.0f, MusicVolumeControlViewModel.VolumeType.BGM);
                }
                w53.b.a("WinkEditorFragment", "[initMusicSourceViewModel] needAutoMusic:" + xk().getNeedAutoMusic());
                if (!xk().getNeedAutoMusic()) {
                    xk().g3().postValue(null);
                }
                if (xk().getNeedAutoMusic()) {
                }
                if (!Um()) {
                }
                xk().w4(false);
            }
        }
        z17 = false;
        boolean a1622 = MusicOptimizeManager.f321154a.a();
        w53.b.f("WinkEditorFragment", "[initMusicSourceViewModel], isSingleVideoAutoMusic=" + z16 + ", isMultiVideoPhotoAutoMusic=" + z17 + ", disableAutoMusic=" + a1622);
        if (Tk().getIsLoadFromDraft()) {
        }
        if (Tk().getIsAllImages()) {
        }
        ao(3000L);
        if (!Tk().getIsLoadFromDraft()) {
        }
        if (!TextUtils.isEmpty(this.tongKuanMusicMid)) {
        }
        R2 = Tk().R2();
        if (R2 != null) {
        }
        if (i3 > 1) {
        }
        w53.b.a("WinkEditorFragment", "[initMusicSourceViewModel] needAutoMusic:" + xk().getNeedAutoMusic());
        if (!xk().getNeedAutoMusic()) {
        }
        if (xk().getNeedAutoMusic()) {
        }
        if (!Um()) {
        }
        xk().w4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tm(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Gn(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tn(final WinkEditorFragment this$0, ActionSheet cancelActionSheet, View view, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelActionSheet, "$cancelActionSheet");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.Tk().W1();
                this$0.to(WinkDaTongReportConstant.ElementId.EM_XSJ_UNSAVE_BUTTON);
            }
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.v
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.Un(WinkEditorFragment.this);
                }
            });
            Context context = this$0.getContext();
            Context context2 = this$0.getContext();
            if (context2 != null) {
                str = context2.getString(R.string.f239677n4);
            } else {
                str = null;
            }
            QQToast.makeText(context, -1, str, 0).show();
            this$0.to(WinkDaTongReportConstant.ElementId.EM_XSJ_SAVE_RETURN);
        }
        cancelActionSheet.superDismiss();
        this$0.pn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uj(WinkEditorFragment this$0, String str, String content, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(content, "$content");
        com.tencent.mobileqq.wink.editor.draft.a.i(this$0.uk().o2(), this$0.Tk().getMissionId());
        OneClickPublishingHelper.D(OneClickPublishingHelper.f325628a, 0, this$0.Tk().getMissionId(), str, content, bundle, false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m63.d Uk() {
        return (m63.d) this.winkEffectTimeLineViewModel.getValue();
    }

    private final void Ul() {
        ms.a.f("WinkEditorFragment", "initMusicSourceViewModelObserver");
        xk().o3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Vl(WinkEditorFragment.this, (Long) obj);
            }
        });
        xk().t3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Wl(WinkEditorFragment.this, (WinkEditorMusicInfo) obj);
            }
        });
        xk().D2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Xl(WinkEditorFragment.this, (MusicInfoWrapper) obj);
            }
        });
        xk().j3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Yl(WinkEditorFragment.this, (List) obj);
            }
        });
        xk().u3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.bc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Zl(WinkEditorFragment.this, (Boolean) obj);
            }
        });
        xk().W2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.am(WinkEditorFragment.this, ((Integer) obj).intValue());
            }
        });
        MutableLiveData<Boolean> l26 = yk().l2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$initMusicSourceViewModelObserver$7
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
                w53.b.a("WinkEditorFragment", "musicVolumeViewModel.volumeUIChangedLivedData changed " + bool);
                cx cxVar = WinkEditorFragment.this.partManager;
                if (cxVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    cxVar = null;
                }
                c73.a s16 = cxVar.s();
                if (s16 != null) {
                    s16.j1();
                }
                WinkEditorFragment.ln(WinkEditorFragment.this, null, false, 3, null);
            }
        };
        l26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.bm(Function1.this, obj);
            }
        });
    }

    private final boolean Um() {
        boolean z16;
        if (TextUtils.isEmpty(this.tongKuanMusicMid) && xk().getNeedAutoMusic() && !Tk().getIsAutoTemplate() && !Tk().getIsFromTemplateLib() && !Tk().getIsAllImages() && Tk().getIsAllVideos() && !Tk().getIsFromZShow() && !Tk().getIsFromMagicStudio() && Tk().s4() && !Jm()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_open_local_bgm_judge", true);
        IQCircleABTestApi iQCircleABTestApi = (IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class);
        iQCircleABTestApi.reportExpExposure("exp_xsj_local_bgm_check_new_2");
        return iQCircleABTestApi.isExperiment("exp_xsj_local_bgm_check_new_2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Un(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Gn(this$0, false, 1, null);
        IWinkDraft iWinkDraft = (IWinkDraft) QRoute.api(IWinkDraft.class);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        iWinkDraft.updateUploadStatus(Long.parseLong(account), this$0.Tk().getMissionId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.hdr.q Vk() {
        Object value = this.winkHDRViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkHDRViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.hdr.q) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vl(WinkEditorFragment this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.curTavCut;
        if (drVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            drVar.seek(it.longValue());
        }
    }

    private final void Vm(String mButtonName) {
        Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
        mParams.put("xsj_actiontype", mButtonName);
        mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        mParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_IMAGE_ENHANCE_TERMINATE_PANEL_TWO);
        VideoReport.reportEvent("ev_xsj_camera_action", null, mParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vn() {
        Ck().f();
        Ck().j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wj(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
            if (this$0.showDialogTime > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this$0.showDialogTime;
                this$0.showDialogTime = currentTimeMillis;
                if (f318525h1) {
                    com.tencent.mobileqq.wink.report.b.f326260a.b("edit_apply_music", String.valueOf(currentTimeMillis));
                } else {
                    com.tencent.mobileqq.wink.report.b.f326260a.b("edit_to_publish", String.valueOf(currentTimeMillis));
                }
                this$0.showDialogTime = 0L;
            }
        }
    }

    private final WinkMaterialViewModel Wk() {
        Object value = this.winkMaterialViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkMaterialViewModel>(...)");
        return (WinkMaterialViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wl(WinkEditorFragment this$0, WinkEditorMusicInfo winkEditorMusicInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isResumed()) {
            this$0.xk().R3();
        }
    }

    private final void Wm(boolean isHidden) {
        w53.b.a("WinkEditorFragment", "onHiddenOption " + isHidden);
        if (!isHidden) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                com.tencent.mobileqq.wink.editor.util.i iVar = com.tencent.mobileqq.wink.editor.util.i.f322640a;
                int i3 = c.f318562a[iVar.f(getArguments()).ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                dr drVar = this.curTavCut;
                                if (drVar instanceof WinkImageTavCut) {
                                    Intrinsics.checkNotNull(drVar, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkImageTavCut");
                                    an(arguments, (WinkImageTavCut) drVar);
                                }
                            }
                        } else {
                            dr drVar2 = this.curTavCut;
                            if (drVar2 instanceof WinkImageTavCut) {
                                Intrinsics.checkNotNull(drVar2, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkImageTavCut");
                                Xm(arguments, (WinkImageTavCut) drVar2);
                            }
                        }
                    } else {
                        dr drVar3 = this.curTavCut;
                        if (drVar3 instanceof WinkVideoTavCut) {
                            Intrinsics.checkNotNull(drVar3, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                            Ym(arguments, (WinkVideoTavCut) drVar3);
                        }
                    }
                } else {
                    Zm(arguments);
                }
                iVar.k(arguments);
            }
            Cn();
            return;
        }
        dr drVar4 = this.curTavCut;
        if (drVar4 != null) {
            drVar4.pause();
        }
        hn();
    }

    private final void Wn(boolean isOpen) {
        int i3;
        TextView textView = this.showHDRTips;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
            textView = null;
        }
        textView.setText(getResources().getString(R.string.f21895654));
        TextView textView3 = this.showHDRTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
        } else {
            textView2 = textView3;
        }
        if (isOpen) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView2.setVisibility(i3);
        if (isOpen) {
            Xn();
        }
    }

    private final void Xj() {
        if (Lm()) {
            dr drVar = this.imageTavCut;
            if (drVar != null) {
                drVar.m0(new d());
                return;
            }
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new ReceiveSchemaEvent(this.schemaAttrsMap));
    }

    private final WinkQZoneTemplateLibViewModel Xk() {
        Object value = this.winkQZoneTemplateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkQZoneTemplateViewModel>(...)");
        return (WinkQZoneTemplateLibViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Xl(WinkEditorFragment this$0, MusicInfoWrapper it) {
        List<MediaClip> emptyList;
        boolean z16;
        boolean z17;
        long j3;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.t().Z9().setEnabled(true);
        Job job = f318527j1;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        f318526i1 = true;
        if (f318525h1) {
            this$0.Vj();
        }
        dr drVar = this$0.curTavCut;
        if (drVar == null || (emptyList = drVar.g0()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        List<MediaClip> list = emptyList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (!this$0.Sk().getIsUseTemplate()) {
            dr drVar2 = this$0.curTavCut;
            if (drVar2 != null && drVar2.S()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                z17 = false;
                if (it.getMusicInfo() != null) {
                    dr drVar3 = this$0.curTavCut;
                    if (drVar3 != null) {
                        dr.b.k(drVar3, null, null, 2, null);
                    }
                    this$0.yk().y2(false, true);
                    if (!this$0.Tk().getIsFromTemplateColl() && com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip && !com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.isUserOpCloseSmartClip) {
                        this$0.Qk().W1(emptyList, z17, true);
                    }
                    this$0.yk().n2(false, z17);
                    this$0.Qk().S1(null);
                    return;
                }
                dr drVar4 = this$0.curTavCut;
                if (drVar4 != null) {
                    dr.b.k(drVar4, null, null, 2, null);
                }
                if (!this$0.Tk().getIsFromTemplateColl()) {
                    if (Intrinsics.areEqual(it.getMusicInfo().p(), this$0.Qk().getCurrentBgmMid()) && this$0.lastMusicStartTime == it.getStartTime()) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        this$0.hk(it, emptyList, false);
                        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SETTING_DEFAULT_STATUS, 0);
                    } else {
                        this$0.lastMusicStartTime = it.getStartTime();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        this$0.hk(it, emptyList, true);
                        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SETTING_DEFAULT_STATUS, 1);
                    }
                    this$0.Qk().S1(it.getMusicInfo().p());
                }
                if (z17 && Intrinsics.areEqual(it.getMusicInfo().p(), "fakeMid_template_bgm")) {
                    this$0.yk().K2(true);
                } else {
                    dr drVar5 = this$0.curTavCut;
                    if (drVar5 != null) {
                        AudioModel e16 = it.e();
                        Float value = this$0.yk().T1().getValue();
                        if (value == null) {
                            value = Float.valueOf(1.0f);
                        }
                        dr.b.k(drVar5, AudioModel.copy$default(e16, null, null, null, null, null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, 524255, null), null, 2, null);
                    }
                    MusicVolumeControlViewModel.z2(this$0.yk(), true, false, 2, null);
                }
                this$0.yk().n2(true, z17);
                MusicSourceViewModel xk5 = this$0.xk();
                dr drVar6 = this$0.curTavCut;
                if (drVar6 != null) {
                    j3 = drVar6.getDurationUs();
                } else {
                    j3 = 0;
                }
                xk5.z4(j3 / 1000);
                return;
            }
        }
        z17 = true;
        if (it.getMusicInfo() != null) {
        }
    }

    private final void Xm(Bundle fragmentArguments, WinkImageTavCut winkImageTavCut) {
        ArrayList arrayList;
        Tk().l5();
        Serializable serializable = fragmentArguments.getSerializable("KEY_MEDIA_ELIMINATION_RESULT");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        w53.b.a("WinkEditorViewModel", "onHiddenOptionFromAIElimination list: " + arrayList);
        int i3 = fragmentArguments.getInt("KEY_SELECT_INDEX", 0);
        if (arrayList != null) {
            winkImageTavCut.e0(arrayList);
            winkImageTavCut.C1(i3, fragmentArguments.getBoolean("KEY_IS_APPLY_ELIMINATE", false));
            fragmentArguments.remove("KEY_MEDIA_ELIMINATION_RESULT");
        }
    }

    private final void Xn() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (this.isShowHDRTips && (valueAnimator2 = this.mHDRTipsAnimator) != null) {
            valueAnimator2.end();
        }
        if (!this.isShowHDRTips && (valueAnimator = this.mHDRTipsAnimator) != null) {
            valueAnimator.start();
        }
    }

    private final void Yj(Function3<? super LAKRenderModel, ? super Long, ? super Long, Unit> action) {
        dr curTavCut = getCurTavCut();
        if (curTavCut != null) {
            curTavCut.F(new e(action, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.recommend.b Yk() {
        Object value = this.winkRecommendViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkRecommendViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.recommend.b) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
    
        if (r4 == false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Yl(WinkEditorFragment this$0, List list) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Object firstOrNull;
        boolean z26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.curTavCut;
        if (drVar != null) {
            this$0.xk().z4(drVar.getDurationUs() / 1000);
        }
        if (!this$0.Tk().k3() && (!this$0.Tk().getIsLoadFromDraft() || TextUtils.isEmpty(this$0.tongKuanMusicMid))) {
            if (this$0.Sk() != null) {
                z16 = this$0.Sk().getIsUseTemplate();
            } else {
                z16 = false;
            }
            if (cx.INSTANCE.f() && (this$0.Tk().getIsFromZShow() || this$0.Tk().getIsFromMagicStudio())) {
                z16 = false;
            }
            ArrayList<LocalMediaInfo> R2 = this$0.Tk().R2();
            if (R2 != null && !R2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (this$0.tongKuanMusicMid.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && R2.size() == 1) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) R2);
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
                    if (localMediaInfo != null && localMediaInfo.mMediaType == 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                }
                if (this$0.xk().getCurrentMusic() != null) {
                    if (z16) {
                        this$0.yk().K2(true);
                    } else {
                        MusicVolumeControlViewModel yk5 = this$0.yk();
                        if (this$0.xk().getCurrentMusic() != null) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        MusicVolumeControlViewModel.z2(yk5, z19, false, 2, null);
                    }
                    this$0.yk().n2(true, z16);
                }
                this$0.xk().f4();
            }
            if (WinkEditorMusicConfig.f321149a.a() || this$0.Tk().getIsFromZShow()) {
                this$0.xk().f4();
                return;
            }
            return;
        }
        MusicSourceViewModel.h4(this$0.xk(), null, this$0.tongKuanMusicMid, 1, null);
        if (this$0.xk().A3() && com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip && !a63.a.INSTANCE.f("winkSmartClip")) {
            this$0.Tk().w5(2);
        }
    }

    private final void Ym(Bundle fragmentArguments, WinkVideoTavCut videoTavCut) {
        List<MediaClip> list;
        List<MediaClip> emptyList;
        List<MediaClip> list2;
        String str;
        Boolean bool;
        MediaModel V;
        MediaModel V2;
        Tk().l5();
        ArrayList parcelableArrayList = fragmentArguments.getParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL);
        if (parcelableArrayList != null) {
            list = com.tencent.mobileqq.wink.editor.hdr.f.a(parcelableArrayList, Tk().getEnhanceOnOffState());
        } else {
            list = null;
        }
        dr drVar = this.curTavCut;
        if (drVar == null || (V2 = drVar.V()) == null || (emptyList = V2.videos) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(emptyList);
        com.tencent.mobileqq.wink.utils.an anVar = com.tencent.mobileqq.wink.utils.an.f326680a;
        dr drVar2 = this.curTavCut;
        if (drVar2 != null && (V = drVar2.V()) != null) {
            list2 = V.videos;
        } else {
            list2 = null;
        }
        boolean j3 = anVar.j(list, list2);
        boolean z16 = fragmentArguments.getBoolean("ARGS_IS_VOLUME_CHANGED", false);
        boolean z17 = fragmentArguments.getBoolean(QQWinkConstants.CLIP_IS_DURATION_CHANGE, false);
        if (z16 || z17 || j3) {
            SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(5, 100));
        }
        qo();
        if (j3) {
            yk().H2(!Im(list));
            if (!yk().getIsBgmVolumeChangedManually() && MusicOptimizeManager.f321154a.d() && yk().s2()) {
                if (com.tencent.videocut.render.extension.e.u(list)) {
                    yk().D2(VolumeValueCache.INSTANCE.b());
                } else {
                    yk().D2(VolumeValueCache.INSTANCE.a());
                }
            }
        }
        if (list != null && Sm()) {
            if (videoTavCut.G()) {
                videoTavCut.A3(new x.UpdateTemplateClipsAction(false, list));
                cx cxVar = this.partManager;
                if (cxVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    cxVar = null;
                }
                cxVar.y().Ja(videoTavCut.getDurationUs());
                str = "partManager";
            } else {
                WinkVideoTavCut.t3(videoTavCut, list, false, true, 2, null);
                h73.a.INSTANCE.b(list);
                sn(list);
                long j16 = fragmentArguments.getLong(QQWinkConstants.MEDIA_DURATION);
                Tk().n5(j16);
                if (!Im(list) || !QzoneConfig.getWinkTransitionSwitch()) {
                    str = "partManager";
                } else {
                    long size = j16 - ((list.size() - 1) * 1000000);
                    str = "partManager";
                    if (size > list.size() * 1000000) {
                        j16 = size;
                    }
                }
                if (j16 != 0 && Sm()) {
                    oo(j16);
                }
            }
            if (z16 || j3) {
                yk().Q1(com.tencent.videocut.render.extension.e.g(list));
                MusicVolumeControlViewModel yk5 = yk();
                if (z16) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
                yk5.q2(list, bool);
                if (z16) {
                    cx cxVar2 = this.partManager;
                    if (cxVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        cxVar2 = null;
                    }
                    c73.a s16 = cxVar2.s();
                    if (s16 != null) {
                        s16.j1();
                    }
                    yk().J2(true);
                }
            }
        }
        al(list, arrayList, j3);
        Vk().Z1(this, j3, fragmentArguments.getBoolean("key_is_blur_after_crop"), fragmentArguments.getBoolean("key_is_changed_after_crop"));
        ln(this, new WinkEditorFragment$onHiddenOptionFromClip$1(j3, this), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zj() {
        bk();
        ak();
        fk();
        ek();
        dk();
    }

    private final com.tencent.mobileqq.wink.editor.tts.e Zk() {
        Object value = this.winkTTSViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkTTSViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.tts.e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zl(WinkEditorFragment this$0, Boolean it) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.curTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkVideoTavCut.W2(it.booleanValue());
        }
    }

    private final void Zm(Bundle fragmentArguments) {
        ArrayList parcelableArrayList;
        w53.b.a("WinkEditorViewModel", "onHiddenOptionFromCrop");
        Tk().l5();
        if (Sk().getIsUseTemplate() && (this.curTavCut instanceof WinkVideoTavCut) && (parcelableArrayList = fragmentArguments.getParcelableArrayList(QQWinkConstants.CROP_RESOURCE_MODEL)) != null && Sm()) {
            Sk().d2(parcelableArrayList);
        }
        Vk().a2(this, fragmentArguments.getBoolean("key_is_blur_after_crop", false), fragmentArguments.getBoolean("key_is_changed_after_crop", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zn(WinkEditorFragment this$0, CharSequence charSequence, boolean z16, DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.getActivity() != null && !this$0.requireActivity().isFinishing()) {
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
                if (qCircleCommonLoadingDialog != null) {
                    Intrinsics.checkNotNull(qCircleCommonLoadingDialog);
                    if (qCircleCommonLoadingDialog.isShowing()) {
                        QCircleCommonLoadingDialog qCircleCommonLoadingDialog2 = this$0.loadingDialog;
                        Intrinsics.checkNotNull(qCircleCommonLoadingDialog2);
                        qCircleCommonLoadingDialog2.dismiss();
                        this$0.showDialogTime = 0L;
                    }
                }
                QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(this$0.requireActivity()).p(String.valueOf(charSequence)).a();
                a16.setCancelable(z16);
                a16.setOnDismissListener(onDismissListener);
                this$0.loadingDialog = a16;
                Intrinsics.checkNotNull(a16);
                a16.show();
                this$0.showDialogTime = System.currentTimeMillis();
                return;
            }
            w53.b.c("WinkEditorFragment", "Activity has been destroy.");
        } catch (Exception e16) {
            w53.b.d("WinkEditorFragment", "showLoadingDialog error", e16);
        }
    }

    private final void ak() {
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE;
        if (!iAEResUtil.isAEResExist(aEResInfo)) {
            ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo, null, false);
        }
        IAEResUtil iAEResUtil2 = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY;
        if (!iAEResUtil2.isAEResExist(aEResInfo2)) {
            ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo2, null, false);
        }
        IAEResUtil iAEResUtil3 = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME = AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME;
        if (!iAEResUtil3.isAEResExist(LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME)) {
            ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME, null, false);
        } else {
            com.tencent.mobileqq.wink.utils.ah ahVar = com.tencent.mobileqq.wink.utils.ah.f326668a;
            Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME, "LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME");
            ahVar.e(LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME);
        }
        com.tencent.mobileqq.wink.utils.ah ahVar2 = com.tencent.mobileqq.wink.utils.ah.f326668a;
        AEResInfo LIGHT_RES_SMILE_AGENT = AEResInfo.LIGHT_RES_SMILE_AGENT;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_SMILE_AGENT, "LIGHT_RES_SMILE_AGENT");
        ahVar2.e(LIGHT_RES_SMILE_AGENT);
        AEResInfo LIGHT_RES_DEPTH_RELATIVE_AGENT = AEResInfo.LIGHT_RES_DEPTH_RELATIVE_AGENT;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_DEPTH_RELATIVE_AGENT, "LIGHT_RES_DEPTH_RELATIVE_AGENT");
        ahVar2.e(LIGHT_RES_DEPTH_RELATIVE_AGENT);
        AEResInfo LIGHT_RES_EMOTION_SCORE_AGENT = AEResInfo.LIGHT_RES_EMOTION_SCORE_AGENT;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_EMOTION_SCORE_AGENT, "LIGHT_RES_EMOTION_SCORE_AGENT");
        ahVar2.e(LIGHT_RES_EMOTION_SCORE_AGENT);
        AEResInfo LIGHT_RES_BUNDLE_FACE = AEResInfo.LIGHT_RES_BUNDLE_FACE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_FACE, "LIGHT_RES_BUNDLE_FACE");
        ahVar2.e(LIGHT_RES_BUNDLE_FACE);
        AEResInfo LIGHT_RES_BUNDLE_3DMM = AEResInfo.LIGHT_RES_BUNDLE_3DMM;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_3DMM, "LIGHT_RES_BUNDLE_3DMM");
        ahVar2.e(LIGHT_RES_BUNDLE_3DMM);
        AEResInfo LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT = AEResInfo.LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT, "LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT");
        ahVar2.e(LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT);
    }

    private final void al(List<? extends MediaClip> mediaClips, List<? extends MediaClip> oldClips, boolean isClipChange) {
        boolean z16;
        Set set;
        String str;
        String str2;
        if (mediaClips == null) {
            return;
        }
        dr drVar = this.curTavCut;
        if (drVar != null && drVar.p()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.wink.editor.hdr.g gVar = com.tencent.mobileqq.wink.editor.hdr.g.f320477a;
            if (gVar.d(mediaClips) && isClipChange) {
                if (uk().w2()) {
                    uk().F2(false);
                    return;
                }
                if (!gVar.d(oldClips)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = oldClips.iterator();
                    while (it.hasNext()) {
                        ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                        if (resourceModel != null) {
                            str2 = resourceModel.path;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            arrayList.add(str2);
                        }
                    }
                    set = CollectionsKt___CollectionsKt.toSet(arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : mediaClips) {
                        ResourceModel resourceModel2 = ((MediaClip) obj).resource;
                        if ((resourceModel2 != null && (str = resourceModel2.path) != null) ? !set.contains(str) : false) {
                            arrayList2.add(obj);
                        }
                    }
                    Jj(true, true, arrayList2);
                    return;
                }
                return;
            }
            this.isInAddClipHDR = false;
            nl(isClipChange);
            return;
        }
        wn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void am(WinkEditorFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), 1, this$0.requireContext().getString(i3), 0).show();
        if (cx.INSTANCE.f()) {
            try {
                View view = this$0.musicMenuItem;
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.ui.WinkMusicButton");
                ((WinkMusicButton) view).a();
            } catch (Exception e16) {
                w53.b.e("WinkEditorFragment", e16);
            }
        }
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.t().Z9().setEnabled(true);
    }

    private final void an(Bundle fragmentArguments, WinkImageTavCut winkImageTavCut) {
        ArrayList<MosaicData> arrayList;
        Tk().l5();
        boolean z16 = fragmentArguments.getBoolean("KEY_IS_CANCEL");
        Serializable serializable = fragmentArguments.getSerializable("KEY_MEDIA_MOSAIC_RESULT");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        fragmentArguments.remove("KEY_MEDIA_MOSAIC_RESULT");
        w53.b.a("WinkEditorViewModel", "onHiddenOptionFromMosaic list: " + arrayList);
        if (!z16 && arrayList != null) {
            winkImageTavCut.I1(arrayList);
            winkImageTavCut.J1(y63.a.a(arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ao(long delay) {
        Job launch$default;
        if (Om() && !f318526i1) {
            Job job = f318527j1;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WinkEditorFragment$showMusicLoadingDialog$1(delay, this, null), 3, null);
            f318527j1 = launch$default;
            return true;
        }
        return false;
    }

    private final void bk() {
        if (FileUtils.fileExists(u53.b.f438376g + QQWinkConstants.HDR_MATERIAL_PATH)) {
            ms.a.f("WinkEditorFragment", "already exit EnhanceMaterial");
            return;
        }
        final f fVar = new f();
        final AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.f69050id = QQWinkConstants.HDR_MATERIAL_NAME;
        aEMaterialMetaData.name = QQWinkConstants.HDR_MATERIAL_NAME;
        aEMaterialMetaData.resurl = QQWinkConstants.HDR_MATERIAL_URL;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.m
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.ck(AEMaterialMetaData.this, fVar);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bl() {
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.f();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bm(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bn(WinkEditorFragment this$0, Message msg2) {
        HashMap hashMap;
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            Object obj = msg2.obj;
            if (obj instanceof HashMap) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
                hashMap = (HashMap) obj;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    ms.a.a("WinkEditorFragment", "inpainting OnAssetProcessing" + str + "value :" + str2);
                    if (Intrinsics.areEqual(str, LightConstants.AIPrepareConfigKeys.ASSET_PROCESSING_PREPAREAI_PROCESSING_STATE)) {
                        if (this$0.isFirstShow && str2.equals("1")) {
                            ms.a.a("WinkEditorFragment", "inpainting showLoadingDialog");
                            this$0.Yn(HardCodeUtil.qqStr(R.string.ymp), true, 0L, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.editor.u
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    WinkEditorFragment.cn(dialogInterface);
                                }
                            });
                            this$0.isFirstShow = false;
                        }
                        if (this$0.isFirstDismiss && str2.equals("0")) {
                            ms.a.a("WinkEditorFragment", "inpainting dismissLoadingDialog");
                            this$0.Vj();
                            this$0.isFirstDismiss = false;
                        }
                    } else if (Intrinsics.areEqual(str, "lightasset.behaviour.lightTemplateCache")) {
                        this$0.Tk().P4("lightTemplateCache", str2);
                        dr drVar = this$0.videoTavCut;
                        if (drVar instanceof WinkVideoTavCut) {
                            winkVideoTavCut = (WinkVideoTavCut) drVar;
                        } else {
                            winkVideoTavCut = null;
                        }
                        if (winkVideoTavCut != null) {
                            winkVideoTavCut.G2(this$0.Tk().i2());
                        }
                    }
                }
            }
        } else {
            ms.a.a("WinkEditorFragment", "inpainting OnLoadAssetError");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ymq, 0).show();
            this$0.Vj();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bo(final Function0<Unit> onConfirm) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(getString(R.string.f215505vs));
        createCustomDialog.setPositiveButton(getString(R.string.f215525vu), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.bj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorFragment.co(WinkEditorFragment.this, onConfirm, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getString(R.string.f215515vt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.bk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorFragment.m229do(WinkEditorFragment.this, dialogInterface, i3);
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
    public static final void ck(AEMaterialMetaData material, com.tencent.aelight.camera.download.a downloadListener) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).startDownloadMaterial(com.tencent.mobileqq.wink.b.a(), material, material.getZipDownloadPath(), downloadListener);
    }

    private final boolean cl() {
        String str;
        boolean z16;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra(QQWinkConstants.OPENING_ENDING_VIDEO_PATH);
        } else {
            str = null;
        }
        dr drVar = this.curTavCut;
        boolean z17 = false;
        if (drVar != null && drVar.l0()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                Tk().D4(getContext());
                requireActivity().finish();
                return true;
            }
        }
        final Context context = getContext();
        if (context != null) {
            ViewUtilsKt.n(context, R.string.f215675w9, 0, Integer.valueOf(R.string.f215805wl), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorFragment.dl(WinkEditorFragment.this, context, dialogInterface, i3);
                }
            }, null, null, 100, null);
        }
        return true;
    }

    private final void cm() {
        if (Tk().getIsEnableMusic()) {
            dm();
            Tl();
            Ql();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void co(WinkEditorFragment this$0, Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        this$0.isInAddClipHDR = true;
        onConfirm.invoke();
    }

    private final void dk() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_BG_SEG.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_QNN_HTP_BUNDLE.agentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dl(WinkEditorFragment this$0, Context it, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.Tk().D4(it);
        this$0.requireActivity().finish();
    }

    private final void dm() {
        List<MediaClip> a06;
        dr drVar = this.curTavCut;
        if (drVar != null && (a06 = drVar.a0()) != null) {
            yk().p2(a06);
        }
        yk().h2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.em(WinkEditorFragment.this, (Float) obj);
            }
        });
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = -1.0f;
        yk().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.fm(WinkEditorFragment.this, floatRef, (Float) obj);
            }
        });
        Sk().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.gm(WinkEditorFragment.this, floatRef, (x.UpdateTemplateAction) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dn(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do, reason: not valid java name */
    public static final void m229do(WinkEditorFragment this$0, DialogInterface dialogInterface, int i3) {
        long j3;
        IPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isInAddClipHDR = false;
        dr drVar = this$0.curTavCut;
        if (drVar != null && (currentPlayer = drVar.getCurrentPlayer()) != null) {
            j3 = currentPlayer.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        this$0.curPlayerTimeUs = j3;
        WinkEditorViewModel Tk = this$0.Tk();
        dr drVar2 = this$0.curTavCut;
        Intrinsics.checkNotNull(drVar2);
        WinkEditorViewModel.C5(Tk, drVar2, WinkHDRCacheManager.INSTANCE.a().c(), this$0.curPlayerTimeUs, true, false, 16, null);
    }

    private final void ek() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_VIDEO_FILTER.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_SCENE.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE.agentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void el() {
        Intent intent;
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.u().Ia();
        boolean z16 = true;
        ln(this, null, true, 1, null);
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.f();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            dr curTavCut = getCurTavCut();
            if (curTavCut != null) {
                z16 = curTavCut.l0();
            }
            intent.putExtra(QQWinkConstants.IS_OPENING_ENDING_VIDEO_CHANGED, z16);
        }
        jo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void em(WinkEditorFragment this$0, Float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.curTavCut;
        if (drVar != null) {
            drVar.v(this$0.yk().e2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void en(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ll();
    }

    private final void eo() {
        final ActionSheet create = ActionSheet.create(getContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(context)");
        create.setMainTitle("\u662f\u5426\u4fdd\u5b58\u6b64\u6b21\u7f16\u8f91\u6548\u679c\uff1f");
        final String str = "\u5b58\u8349\u7a3f\u5e76\u9000\u51fa";
        create.addButton("\u5b58\u8349\u7a3f\u5e76\u9000\u51fa", 1);
        create.addButton(R.string.f184533m5, 1);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.wink.editor.bq
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                WinkEditorFragment.fo(WinkEditorFragment.this);
            }
        });
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.wink.editor.br
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                WinkEditorFragment.go(WinkEditorFragment.this, create, str, view, i3);
            }
        });
        if (!requireActivity().isFinishing() && !create.isShowing()) {
            create.show();
            com.tencent.mobileqq.wink.report.a.b(com.tencent.mobileqq.wink.report.a.f326259a, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_RETENTION_PANEL, "ev_xsj_abnormal_imp", cu.k(Tk().getEditMode()), null, 8, null);
        }
    }

    private final void fk() {
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_TRACK_AGENT;
        if (!iAEResUtil.isAEResExist(aEResInfo)) {
            ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo, null, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0158, code lost:
    
        if (r2 != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fl(boolean fromRestore) {
        boolean z16;
        String selectMusicMid;
        Integer selectMusicStart;
        int i3;
        Map<Integer, Float> linkedHashMap;
        Object orNull;
        WinkEditData winkEditData;
        boolean z17;
        boolean z18;
        MediaModel mediaModel;
        List<MediaClip> list;
        boolean isBlank;
        boolean z19;
        Intent intent;
        boolean z26 = true;
        if (!fromRestore && !Tk().k3()) {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null && intent.getBooleanExtra(QQWinkConstants.EDITOR_TEMPORARY_ENTRANCE_RECOVERFOR_VOLUME, false)) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                return;
            }
        }
        Sk().S1(Tk().getTemplatePath());
        WinkEditDataWrapper originEditData = Tk().getOriginEditData();
        if (originEditData != null) {
            String templatePath = Tk().getTemplatePath();
            if (templatePath != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(templatePath);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        xk().u2(false);
                    }
                    if (originEditData.getBgmVolumeType() != MusicVolumeControlViewModel.VolumeType.TEMPLATE && Intrinsics.areEqual(originEditData.getSelectMusicMid(), "fakeMid_template_bgm")) {
                        xk().u3().postValue(Boolean.TRUE);
                    } else {
                        xk().u3().postValue(Boolean.FALSE);
                        selectMusicMid = originEditData.getSelectMusicMid();
                        if (selectMusicMid != null && originEditData.getSelectMusicStart() != null) {
                            MusicSourceViewModel xk5 = xk();
                            selectMusicStart = originEditData.getSelectMusicStart();
                            if (selectMusicStart == null) {
                                i3 = selectMusicStart.intValue();
                            } else {
                                i3 = 0;
                            }
                            xk5.a4(selectMusicMid, i3, true);
                        }
                    }
                    linkedHashMap = new LinkedHashMap<>();
                    orNull = CollectionsKt___CollectionsKt.getOrNull(originEditData.getEditDatas(), 0);
                    winkEditData = (WinkEditData) orNull;
                    if (winkEditData != null && (mediaModel = winkEditData.getMediaModel()) != null && (list = mediaModel.videos) != null) {
                        linkedHashMap = com.tencent.videocut.render.extension.e.g(list);
                        yk().q2(list, null);
                        yk().H2(!Tk().getIsAllImages());
                        yk().Q1(linkedHashMap);
                    }
                    if (!TextUtils.isEmpty(originEditData.getSelectMusicMid())) {
                        yk().G2(MusicVolumeControlViewModel.VolumeType.NONE);
                    } else {
                        yk().G2(originEditData.getBgmVolumeType());
                        yk().S1(originEditData.getBgmVolume(), originEditData.getBgmVolumeType());
                    }
                    MusicVolumeControlViewModel yk5 = yk();
                    if (Tk().getIsAllImages()) {
                        if (!linkedHashMap.isEmpty()) {
                            Iterator<Map.Entry<Integer, Float>> it = linkedHashMap.entrySet().iterator();
                            while (it.hasNext()) {
                                if (it.next().getValue().floatValue() > 0.0f) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    z18 = true;
                                    break;
                                }
                            }
                        }
                        z18 = false;
                    }
                    z26 = false;
                    yk5.I2(z26);
                }
            }
            z16 = true;
            if (!z16) {
            }
            if (originEditData.getBgmVolumeType() != MusicVolumeControlViewModel.VolumeType.TEMPLATE) {
            }
            xk().u3().postValue(Boolean.FALSE);
            selectMusicMid = originEditData.getSelectMusicMid();
            if (selectMusicMid != null) {
                MusicSourceViewModel xk52 = xk();
                selectMusicStart = originEditData.getSelectMusicStart();
                if (selectMusicStart == null) {
                }
                xk52.a4(selectMusicMid, i3, true);
            }
            linkedHashMap = new LinkedHashMap<>();
            orNull = CollectionsKt___CollectionsKt.getOrNull(originEditData.getEditDatas(), 0);
            winkEditData = (WinkEditData) orNull;
            if (winkEditData != null) {
                linkedHashMap = com.tencent.videocut.render.extension.e.g(list);
                yk().q2(list, null);
                yk().H2(!Tk().getIsAllImages());
                yk().Q1(linkedHashMap);
            }
            if (!TextUtils.isEmpty(originEditData.getSelectMusicMid())) {
            }
            MusicVolumeControlViewModel yk52 = yk();
            if (Tk().getIsAllImages()) {
            }
            z26 = false;
            yk52.I2(z26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fm(WinkEditorFragment this$0, Ref.FloatRef templateVolume, Float it) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(templateVolume, "$templateVolume");
        if (this$0.yk().f2() == MusicVolumeControlViewModel.VolumeType.TEMPLATE) {
            dr drVar = this$0.curTavCut;
            if (drVar instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                WinkVideoTavCut.H3(winkVideoTavCut, it.floatValue(), null, 2, null);
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            templateVolume.element = it.floatValue();
            return;
        }
        dr drVar2 = this$0.curTavCut;
        if (drVar2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dr.b.l(drVar2, it.floatValue(), null, 2, null);
        }
        this$0.xk().j4(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fn(WinkEditorFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Tk().E4(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.s
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.gn();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fo(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        String k3 = cu.k(this$0.Tk().getEditMode());
        Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_item_name", "\u53d6\u6d88");
        Unit unit = Unit.INSTANCE;
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_RETENTION_PANEL_BUTTON, "ev_xsj_abnormal_clck", k3, buildElementParams);
    }

    private final void gk(dr.WinkTavCutParams params) {
        WinkTavCutScene winkTavCutScene;
        if (Tk().R1()) {
            if (params != null) {
                params.y(WinkTavCutScene.PICK_PRELOAD);
            }
            if (params != null) {
                winkTavCutScene = params.getScene();
            } else {
                winkTavCutScene = null;
            }
            w53.b.f("WinkEditorFragment", "preload player initTavcut scene " + winkTavCutScene);
            WinkEditPerformanceViewModel Mk = Mk();
            if (Mk != null) {
                Mk.Q1();
                return;
            }
            return;
        }
        com.tencent.mobileqq.wink.picker.core.part.an.INSTANCE.h();
    }

    static /* synthetic */ void gl(WinkEditorFragment winkEditorFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        winkEditorFragment.fl(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gm(WinkEditorFragment this$0, Ref.FloatRef templateVolume, x.UpdateTemplateAction updateTemplateAction) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(templateVolume, "$templateVolume");
        dr drVar = this$0.curTavCut;
        WinkVideoTavCut winkVideoTavCut2 = null;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null && templateVolume.element >= 0.0f && updateTemplateAction.getTemplatePath() != null) {
            dr drVar2 = this$0.curTavCut;
            if (drVar2 instanceof WinkVideoTavCut) {
                winkVideoTavCut2 = (WinkVideoTavCut) drVar2;
            }
            if (winkVideoTavCut2 != null) {
                winkVideoTavCut2.m0(new h(winkVideoTavCut2, templateVolume));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void go(final WinkEditorFragment this$0, ActionSheet cancelActionSheet, String actionBtnText, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelActionSheet, "$cancelActionSheet");
        Intrinsics.checkNotNullParameter(actionBtnText, "$actionBtnText");
        if (i3 == 0) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.r
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.ho(WinkEditorFragment.this);
                }
            });
        }
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        String k3 = cu.k(this$0.Tk().getEditMode());
        Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (i3 != 0) {
            actionBtnText = "\u4e0d\u4fdd\u5b58";
        }
        buildElementParams.put("xsj_item_name", actionBtnText);
        Unit unit = Unit.INSTANCE;
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_RETENTION_PANEL_BUTTON, "ev_xsj_abnormal_clck", k3, buildElementParams);
        cancelActionSheet.superDismiss();
        this$0.pn();
    }

    private final void hk(MusicInfoWrapper musicInfo, List<? extends MediaClip> videos, boolean triggerSmartClip) {
        final boolean z16;
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = videos.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (com.tencent.videocut.render.extension.e.r((MediaClip) next) == MediaClipUseType.NORMAL) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        boolean a16 = com.tencent.mobileqq.wink.editor.smartclip.o.f321529a.a(musicInfo);
        if (triggerSmartClip && com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip && arrayList.size() > 1 && a16) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.a("WinkEditorFragment", "shouldDoSmartClip:" + z16 + ", hasStuckPointInfo:" + a16);
        Qk().N1(musicInfo, arrayList, z16, Sk().getIsUseTemplate(), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$executeSmartClipLogic$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                WinkEditSmartClipViewModel Qk;
                Qk = WinkEditorFragment.this.Qk();
                WinkEditSmartClipViewModel.X1(Qk, arrayList, false, z16, 2, null);
            }
        });
        if (z16) {
            Tk().p5();
        }
    }

    private final void hl(TTSAudioInfo ttsAudioInfo, boolean isSeek) {
        boolean z16;
        String str;
        Float f16;
        boolean z17;
        Map<String, Serializable> map;
        Map<String, Serializable> map2;
        if (ttsAudioInfo != null) {
            if (ttsAudioInfo.getTemplateType() == TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
                w53.b.a("WinkEditorFragment", "cancelTemplateTTSAudio");
                dr drVar = this.curTavCut;
                Intrinsics.checkNotNull(drVar, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                Entity templateTTSEntity = ((WinkVideoTavCut) drVar).getTemplateTTSEntity();
                if (templateTTSEntity != null) {
                    Collection<Component> components = templateTTSEntity.getComponents();
                    if (components != null) {
                        Intrinsics.checkNotNullExpressionValue(components, "components");
                        for (Component component : components) {
                            if (component instanceof AudioSource) {
                                AudioSource audioSource = (AudioSource) component;
                                audioSource.setSrc("");
                                audioSource.setVolume(0.0f);
                            } else if (component instanceof ScreenTransform) {
                                ((ScreenTransform) component).setObjectEnabled(false);
                            }
                        }
                    }
                    dr drVar2 = this.curTavCut;
                    Intrinsics.checkNotNull(drVar2, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                    ((WinkVideoTavCut) drVar2).X2(false);
                    dr drVar3 = this.curTavCut;
                    Intrinsics.checkNotNull(drVar3, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                    MetaMaterial templateMaterial = ((WinkVideoTavCut) drVar3).getTemplateMaterial();
                    if (templateMaterial != null && (map2 = templateMaterial.additionalObjectFields) != null) {
                        map2.remove(QQWinkConstants.PICK_TEMPLATE_TTS_MODEL);
                    }
                }
            } else {
                w53.b.a("WinkEditorFragment", "updateTemplateTTSAudio");
                if (ttsAudioInfo.getAudioItems() != null) {
                    TTSAudioItem[] audioItems = ttsAudioInfo.getAudioItems();
                    Intrinsics.checkNotNullExpressionValue(audioItems, "it.audioItems");
                    if (audioItems.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        TTSAudioItem tTSAudioItem = ttsAudioInfo.getAudioItems()[0];
                        dr drVar4 = this.curTavCut;
                        Intrinsics.checkNotNull(drVar4, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                        Entity templateTTSEntity2 = ((WinkVideoTavCut) drVar4).getTemplateTTSEntity();
                        if (templateTTSEntity2 != null) {
                            if (tTSAudioItem != null) {
                                str = tTSAudioItem.getLocalPath();
                            } else {
                                str = null;
                            }
                            if (tTSAudioItem != null) {
                                f16 = Float.valueOf(tTSAudioItem.getVolume());
                            } else {
                                f16 = null;
                            }
                            w53.b.a("WinkEditorFragment", "localPath:" + str + "\uff0c audio volume: " + f16);
                            if (str != null) {
                                InputSource b16 = g.a.b(rd4.c.f431135f.r(), str, new TimeRange(0L, tTSAudioItem.getDuration()), null, 4, null);
                                dr drVar5 = this.curTavCut;
                                Intrinsics.checkNotNull(drVar5, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                ICutSession.DefaultImpls.addInputSource$default(((WinkVideoTavCut) drVar5).getSession(), b16, false, 2, null);
                                Collection<Component> components2 = templateTTSEntity2.getComponents();
                                if (components2 != null) {
                                    Intrinsics.checkNotNullExpressionValue(components2, "components");
                                    z17 = true;
                                    for (Component component2 : components2) {
                                        if (component2 instanceof AudioSource) {
                                            AudioSource audioSource2 = (AudioSource) component2;
                                            audioSource2.setSrc(b16.getKey());
                                            audioSource2.setVolume(tTSAudioItem.getVolume() * 2);
                                        } else if (component2 instanceof TimeOffset) {
                                            TimeOffset timeOffset = (TimeOffset) component2;
                                            tTSAudioItem.setStartTime(timeOffset.getStartOffset());
                                            timeOffset.setEndOffset(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                                            timeOffset.setLoopCount(0);
                                            timeOffset.setDuration(tTSAudioItem.getDuration());
                                        } else if (component2 instanceof ScreenTransform) {
                                            ScreenTransform screenTransform = (ScreenTransform) component2;
                                            z17 = !screenTransform.getObjectEnabled();
                                            screenTransform.setObjectEnabled(true);
                                        }
                                    }
                                } else {
                                    z17 = true;
                                }
                                dr drVar6 = this.curTavCut;
                                Intrinsics.checkNotNull(drVar6, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                MetaMaterial templateMaterial2 = ((WinkVideoTavCut) drVar6).getTemplateMaterial();
                                if (templateMaterial2 != null && (map = templateMaterial2.additionalObjectFields) != null) {
                                    map.put(QQWinkConstants.PICK_TEMPLATE_TTS_MODEL, ttsAudioInfo);
                                }
                                w53.b.a("WinkEditorFragment", "start:" + tTSAudioItem.getStartTime() + "\uff0cduration: " + tTSAudioItem.getDuration() + "\uff0cisNeedAdd:" + z17);
                                if (z17) {
                                    dr drVar7 = this.curTavCut;
                                    Intrinsics.checkNotNull(drVar7, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                    ((WinkVideoTavCut) drVar7).X2(true);
                                } else {
                                    dr drVar8 = this.curTavCut;
                                    Intrinsics.checkNotNull(drVar8, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                    ((WinkVideoTavCut) drVar8).c1(true);
                                }
                                if (isSeek && tTSAudioItem.getStartTime() >= 0) {
                                    dr drVar9 = this.curTavCut;
                                    Intrinsics.checkNotNull(drVar9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                    ((WinkVideoTavCut) drVar9).seek(tTSAudioItem.getStartTime());
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            Tk().E5(ttsAudioInfo);
        }
    }

    private final void hm(View view) {
        cx cxVar = this.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.t().Q9(null);
        WinkEditorFragment$initNextBtn$clickSendAction$1 winkEditorFragment$initNextBtn$clickSendAction$1 = new WinkEditorFragment$initNextBtn$clickSendAction$1(this);
        cx cxVar3 = this.partManager;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar3 = null;
        }
        cxVar3.t().ha(winkEditorFragment$initNextBtn$clickSendAction$1);
        cx cxVar4 = this.partManager;
        if (cxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar4 = null;
        }
        cxVar4.t().ja(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$initNextBtn$1
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
                WinkEditorFragment.this.jo();
            }
        });
        cx cxVar5 = this.partManager;
        if (cxVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar5 = null;
        }
        if (cxVar5.t() instanceof DailyNextBtnPart) {
            cx cxVar6 = this.partManager;
            if (cxVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar6;
            }
            NextBtnPart t16 = cxVar2.t();
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart");
            ((DailyNextBtnPart) t16).za(winkEditorFragment$initNextBtn$clickSendAction$1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hn() {
        if (Tk().getEditMode() == WinkEditorViewModel.EditMode.Image) {
            in();
        } else {
            jn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ho(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSaveUnDefined = true;
        Gn(this$0, false, 1, null);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShowSaveDraftDialogEvent(), true);
    }

    private final b ik(List<? extends MediaClip> enhanceCheckClips, boolean needConfirm) {
        return new WinkEditorFragment$exportProgressListener$1(this, new Ref.BooleanRef(), enhanceCheckClips, needConfirm);
    }

    private final void il() {
        boolean z16;
        String str;
        Intent intent;
        Intent intent2;
        Intent intent3;
        boolean isLoadFromDraft = Tk().getIsLoadFromDraft();
        boolean z17 = true;
        if (Tk().getMFrom() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = null;
        if (isLoadFromDraft && !TextUtils.isEmpty(Tk().getDraftMusicMid())) {
            this.tongKuanMusicMid = Tk().getDraftMusicMid();
        } else {
            String str2 = "";
            if (!isLoadFromDraft && z16) {
                this.tongKuanMusicMid = "";
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    str = intent.getStringExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_ID);
                } else {
                    str = null;
                }
                if (str != null) {
                    str2 = str;
                }
                this.tongKuanMusicMid = str2;
            }
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent3 = activity2.getIntent()) == null || !intent3.hasExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE)) {
            z17 = false;
        }
        if (z17) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
                num = Integer.valueOf(intent2.getIntExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE, 0));
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE, num);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0060, code lost:
    
        if (com.tencent.mobileqq.activity.photo.MimeHelper.validateVideoType(r0) != false) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void im() {
        boolean z16;
        boolean z17;
        boolean z18;
        Object firstOrNull;
        String str;
        cx cxVar = null;
        if (Tk().getIsEnableMusic() && Tk().getEditMode() != WinkEditorViewModel.EditMode.Image && !Tk().getIsLoadFromDraft()) {
            ArrayList<LocalMediaInfo> R2 = Tk().R2();
            z16 = false;
            if (R2 != null && !R2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (this.tongKuanMusicMid.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && R2.size() == 1) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) R2);
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
                    if (localMediaInfo != null) {
                        str = localMediaInfo.mMimeType;
                    } else {
                        str = null;
                    }
                }
                if (MusicOptimizeManager.f321154a.c()) {
                    z16 = true;
                }
                if (!z16) {
                    cx cxVar2 = this.partManager;
                    if (cxVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        cxVar2 = null;
                    }
                    if (cxVar2.P()) {
                        cx cxVar3 = this.partManager;
                        if (cxVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        } else {
                            cxVar = cxVar3;
                        }
                        cxVar.t().Z9().setEnabled(true);
                        return;
                    }
                    return;
                }
                getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorFragment.jm(WinkEditorFragment.this);
                    }
                }, 3000L);
                return;
            }
        }
        z16 = true;
        if (MusicOptimizeManager.f321154a.c()) {
        }
        if (!z16) {
        }
    }

    private final void initViewModel() {
        zl();
        Cm();
        cm();
        ym();
        Kl();
        Il();
        rm();
        um();
        mm();
        km();
        pm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void io(WinkEditorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ll();
        this$0.ko();
        this$0.Vm("publish");
    }

    private final boolean isZShowTemplate() {
        Serializable serializable;
        Intent intent;
        FragmentActivity activity = getActivity();
        MediaPickerScene mediaPickerScene = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
        } else {
            serializable = null;
        }
        if (serializable instanceof MediaPickerScene) {
            mediaPickerScene = (MediaPickerScene) serializable;
        }
        if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW) {
            return true;
        }
        return false;
    }

    private final void jk() {
        if (Lm()) {
            return;
        }
        dr drVar = this.curTavCut;
        if (drVar != null) {
            drVar.seek(this.curPlayerTimeUs);
        }
        dr drVar2 = this.curTavCut;
        if (drVar2 != null) {
            dr.b.b(drVar2, false, 1, null);
        }
    }

    private final void jl() {
        WinkEditDataWrapper originEditData;
        if ((Tk().Z3() || Tk().b4()) && (originEditData = Tk().getOriginEditData()) != null) {
            int size = originEditData.getEditDatas().size();
            for (int i3 = 0; i3 < size; i3++) {
                WinkEditData winkEditData = originEditData.getEditDatas().get(i3);
                InteractiveModel challengeData = winkEditData.getChallengeData();
                if (challengeData != null) {
                    Nk().N1(challengeData);
                }
                String manualDeletedChallengeTag = winkEditData.getManualDeletedChallengeTag();
                if (manualDeletedChallengeTag != null) {
                    com.tencent.mobileqq.wink.model.b.f324006a.i(manualDeletedChallengeTag);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jm(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        if (cxVar.P()) {
            cx cxVar3 = this$0.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar3;
            }
            cxVar2.t().Z9().setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String kk(Intent intent) {
        boolean z16;
        String str;
        if (intent != null) {
            String p16 = WinkContext.INSTANCE.d().p("content");
            if (p16 != null && p16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str = TagRetriever.f326413a.f(intent);
            } else {
                str = p16 + " " + TagRetriever.f326413a.f(intent);
            }
            w53.b.f("WinkEditorFragment", "generateDailyContent... content:" + str);
            return str;
        }
        return "";
    }

    private final void km() {
        Pk().C2();
        Pk().M2(com.tencent.mobileqq.wink.picker.core.viewmodel.q.e(this));
        Pk().x2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.bf
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.lm(WinkEditorFragment.this, (UpdateOpeningEndingData) obj);
            }
        });
    }

    private final void kn(final Function0<Unit> action, boolean forceSave) {
        Runnable runnable;
        if (!Tk().getIsLoadFromDraft() || forceSave) {
            if (action == null) {
                runnable = this.mSaveMediaRunnable;
            } else {
                runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorFragment.mn(WinkEditorFragment.this, action);
                    }
                };
            }
            this.realSaveRunnable = runnable;
            ThreadManager.getFileThreadHandler().postDelayed(this.realSaveRunnable, 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ko() {
        String str;
        Map map;
        dr drVar;
        Float value;
        Float value2;
        List<WinkEditData> n3;
        int i3;
        Map mutableMap;
        dr drVar2 = this.curTavCut;
        String templatePath = drVar2 != null ? drVar2.getTemplatePath() : null;
        if (Tk().getIsFromQzoneText() && !TextUtils.isEmpty(Tk().getBackgroundTemplatePath())) {
            templatePath = Tk().getBackgroundTemplatePath();
        }
        String str2 = templatePath;
        String missionId = Tk().getMissionId();
        int K2 = Tk().K2();
        ArrayList<LocalMediaInfo> nk5 = nk();
        int O2 = Tk().O2();
        dr drVar3 = this.curTavCut;
        long durationUs = drVar3 != null ? drVar3.getDurationUs() : 0L;
        boolean isFromCapture = Tk().getIsFromCapture();
        WinkEditorMusicInfo currentMusic = xk().getCurrentMusic();
        Long valueOf = currentMusic != null ? Long.valueOf(currentMusic.o()) : null;
        WinkEditorMusicInfo currentMusic2 = xk().getCurrentMusic();
        String q16 = currentMusic2 != null ? currentMusic2.q() : null;
        WinkEditorMusicInfo currentMusic3 = xk().getCurrentMusic();
        String r16 = currentMusic3 != null ? currentMusic3.r() : null;
        WinkEditorMusicInfo currentMusic4 = xk().getCurrentMusic();
        Integer valueOf2 = currentMusic4 != null ? Integer.valueOf(currentMusic4.n()) : null;
        WinkEditorMusicInfo currentMusic5 = xk().getCurrentMusic();
        String p16 = currentMusic5 != null ? currentMusic5.p() : null;
        MusicSourceViewModel xk5 = xk();
        WinkEditorMusicInfo currentMusic6 = xk().getCurrentMusic();
        if (currentMusic6 == null || (str = currentMusic6.p()) == null) {
            str = "";
        }
        Integer m3 = xk5.m3(str);
        int useHD = Tk().getUseHD();
        Float value3 = yk().h2().getValue();
        if (value3 == null) {
            value3 = Float.valueOf(0.0f);
        }
        Float value4 = yk().T1().getValue();
        if (value4 == null) {
            value4 = Float.valueOf(0.0f);
        }
        MusicVolumeControlViewModel.VolumeType f26 = yk().f2();
        boolean z16 = com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip;
        Map<String, WinkEditUIData> Bk = Bk();
        String str3 = Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
        if (str3 == null) {
            str3 = "QCIRCLE";
        }
        String str4 = str3;
        boolean isEnableSwitchEditMode = Tk().getIsEnableSwitchEditMode();
        boolean isEnableMusic = Tk().getIsEnableMusic();
        boolean isFromQzoneText = Tk().getIsFromQzoneText();
        boolean isFromTemplateColl = Tk().getIsFromTemplateColl();
        ArrayList<String> k26 = Tk().k2();
        if (k26 == null) {
            k26 = new ArrayList<>();
        }
        ArrayList<String> arrayList = k26;
        int j26 = Tk().j2();
        String textQzoneText = Tk().getTextQzoneText();
        dr drVar4 = this.curTavCut;
        WinkVideoTavCut winkVideoTavCut = drVar4 instanceof WinkVideoTavCut ? (WinkVideoTavCut) drVar4 : null;
        long r17 = winkVideoTavCut != null ? winkVideoTavCut.r1() : 0L;
        String captureMaterialId = Tk().getCaptureMaterialId();
        String captureMaterialName = Tk().getCaptureMaterialName();
        boolean enableImageTransition = Tk().getEnableImageTransition();
        boolean isHDRExporting = Tk().getIsHDRExporting();
        z93.a a16 = Wink.INSTANCE.a();
        if (a16 != null) {
            FragmentActivity activity = getActivity();
            Map<String, String> a17 = a16.a(activity != null ? activity.getIntent() : null, Tk());
            if (a17 != null) {
                mutableMap = MapsKt__MapsKt.toMutableMap(a17);
                map = mutableMap;
                WinkEditDataWrapper winkEditDataWrapper = new WinkEditDataWrapper(missionId, Integer.valueOf(K2), null, nk5, str2, Integer.valueOf(O2), null, durationUs, isFromCapture, p16, m3, false, useHD, value3.floatValue(), value4.floatValue(), f26, z16, Bk, str4, isEnableSwitchEditMode, r17, valueOf, q16, isEnableMusic, 0L, false, null, isFromQzoneText, textQzoneText, isFromTemplateColl, arrayList, j26, captureMaterialId, enableImageTransition, isHDRExporting, map, false, false, false, captureMaterialName, r16, valueOf2, Tk().getWatermarkConfig(), false, 117442628, 2160, null);
                ArrayList<String> arrayList2 = new ArrayList<>();
                drVar = this.curTavCut;
                if (drVar != null && (n3 = drVar.n()) != null) {
                    for (WinkEditData winkEditData : n3) {
                        try {
                            dr drVar5 = this.curTavCut;
                            WinkVideoTavCut winkVideoTavCut2 = drVar5 instanceof WinkVideoTavCut ? (WinkVideoTavCut) drVar5 : null;
                            if (winkVideoTavCut2 != null) {
                                winkVideoTavCut2.j3();
                            }
                            WinkEditData copy$default = WinkEditData.copy$default(winkEditData, null, 0L, null, null, null, null, false, null, null, null, null, null, false, null, null, null, false, null, 262143, null);
                            winkEditDataWrapper.getEditDatas().add(copy$default);
                            com.tencent.videocut.render.utils.a.f384204a.l(copy$default);
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            Map<String, WinkStickerModel> stickerModelMap = copy$default.getStickerModelMap();
                            if (stickerModelMap != null) {
                                for (Map.Entry<String, WinkStickerModel> entry : stickerModelMap.entrySet()) {
                                    String key = entry.getKey();
                                    WinkStickerModel value5 = entry.getValue();
                                    dr drVar6 = this.curTavCut;
                                    if (drVar6 instanceof WinkVideoTavCut) {
                                        Intrinsics.checkNotNull(drVar6, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                                        i3 = ((WinkVideoTavCut) drVar6).j1(value5.getEntityName());
                                    } else {
                                        i3 = 0;
                                    }
                                    linkedHashMap.put(key, new WinkStickerModelExtra(value5.getInitStickerScale(), value5.getDownScaleRecord(), value5.getOriginPointInView(), value5.getSizeInView(), value5.getCenterInView(), value5.getLeftTopInView(), value5.getRightBottomInView(), value5.getMaterial(), value5.getLastDownScaleX(), value5.getLastDownScaleY(), value5.getLastDownRotate(), value5.getNormalizedLeftTopInView(), value5.getNormalizedRightBottomInView(), value5.isTextSticker(), value5.getClickBoundsLeftTopInView(), value5.getClickBoundsRightBottomInView(), value5.getIsTraceSticker(), value5.getStickerTrackerResult(), value5.getEntityName(), i3, value5.getIsTimeRangeChangedByUser(), false, null, 6291456, null));
                                    MetaMaterial material = value5.getMaterial();
                                    if ((material != null ? com.tencent.mobileqq.wink.editor.c.M0(material) : null) != null) {
                                        if (com.tencent.mobileqq.wink.editor.c.M0(value5.getMaterial()).length() > 0) {
                                            arrayList2.add(com.tencent.mobileqq.wink.editor.c.M0(value5.getMaterial()));
                                        }
                                    }
                                }
                            }
                            copy$default.setStickerExtraMap(linkedHashMap);
                            com.tencent.mobileqq.wink.model.b bVar = com.tencent.mobileqq.wink.model.b.f324006a;
                            if (bVar.f()) {
                                cx cxVar = this.partManager;
                                if (cxVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                                    cxVar = null;
                                }
                                WinkEditorChallengePart challengePart = cxVar.getChallengePart();
                                copy$default.setChallengeData(challengePart != null ? challengePart.ba() : null);
                                InteractiveModel challengeData = copy$default.getChallengeData();
                                WinkDatongCurrentParams.put("xsj_challenge_topic", challengeData != null ? Float.valueOf(challengeData.getXAxisPercentage()) : null);
                            } else {
                                copy$default.setChallengeData(null);
                                WinkDatongCurrentParams.put("xsj_challenge_topic", "");
                            }
                            copy$default.setManualDeletedChallengeTag(bVar.c());
                        } catch (Error e16) {
                            w53.b.c("WinkEditorFragment", "updateExportSetting error " + e16.getMessage());
                            return;
                        }
                    }
                }
                Hj(arrayList2);
                Ln();
                mk();
                HashMap<String, Object> params = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                value = yk().T1().getValue();
                if (value == null) {
                    value = Float.valueOf(0.0f);
                }
                params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, value);
                HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params2, "params");
                value2 = yk().h2().getValue();
                if (value2 == null) {
                    value2 = Float.valueOf(0.0f);
                }
                params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, value2);
                uk().I2(winkEditDataWrapper);
                vk().d2(this, this.curTavCut, winkEditDataWrapper, this.clientTraceId, Tk().s4(), Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String(), Boolean.valueOf(Tk().getIsFromMagicStudio()), Tk().getCoverIndex());
                FirstFramePreLoader.p();
                w53.b.f("WinkEditorFragment", "toNext: dataWrapper.editDatas = " + winkEditDataWrapper.getEditDatas());
            }
        }
        map = null;
        WinkEditDataWrapper winkEditDataWrapper2 = new WinkEditDataWrapper(missionId, Integer.valueOf(K2), null, nk5, str2, Integer.valueOf(O2), null, durationUs, isFromCapture, p16, m3, false, useHD, value3.floatValue(), value4.floatValue(), f26, z16, Bk, str4, isEnableSwitchEditMode, r17, valueOf, q16, isEnableMusic, 0L, false, null, isFromQzoneText, textQzoneText, isFromTemplateColl, arrayList, j26, captureMaterialId, enableImageTransition, isHDRExporting, map, false, false, false, captureMaterialName, r16, valueOf2, Tk().getWatermarkConfig(), false, 117442628, 2160, null);
        ArrayList<String> arrayList22 = new ArrayList<>();
        drVar = this.curTavCut;
        if (drVar != null) {
            while (r2.hasNext()) {
            }
        }
        Hj(arrayList22);
        Ln();
        mk();
        HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params3, "params");
        value = yk().T1().getValue();
        if (value == null) {
        }
        params3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, value);
        HashMap<String, Object> params22 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params22, "params");
        value2 = yk().h2().getValue();
        if (value2 == null) {
        }
        params22.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, value2);
        uk().I2(winkEditDataWrapper2);
        vk().d2(this, this.curTavCut, winkEditDataWrapper2, this.clientTraceId, Tk().s4(), Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String(), Boolean.valueOf(Tk().getIsFromMagicStudio()), Tk().getCoverIndex());
        FirstFramePreLoader.p();
        w53.b.f("WinkEditorFragment", "toNext: dataWrapper.editDatas = " + winkEditDataWrapper2.getEditDatas());
    }

    private final ArrayList<LocalMediaInfo> lk(ArrayList<LocalMediaInfo> imageCovers) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList<>();
        ArrayList<String> n26 = uk().n2();
        int size = imageCovers.size();
        for (int i3 = 0; i3 < size; i3++) {
            LocalMediaInfo localMediaInfo = imageCovers.get(i3);
            if (localMediaInfo != null) {
                if (n26 != null && (!n26.isEmpty())) {
                    localMediaInfo.mHashTagList.addAll(n26);
                }
                if (!TextUtils.isEmpty(localMediaInfo.path)) {
                    arrayList.add(localMediaInfo.path);
                    String str = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str, "cover.path");
                    hashMap.put(str, localMediaInfo);
                    if (localMediaInfo.path != null) {
                        localMediaInfo.thumbnailProgress = -1.0f;
                        arrayList2.add(localMediaInfo);
                    } else {
                        w53.b.g("WinkEditorFragment", "[loadMediaInfos] invalid mediaInfo");
                    }
                }
            }
        }
        LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
        localMediaInfo2.missionID = uk().o2().getMissionId();
        localMediaInfo2.mOriginPath = arrayList;
        uk().o2().setOutMediaInfo(localMediaInfo2);
        com.tencent.mobileqq.wink.editor.draft.a.h(uk().o2(), uk().o2().getMissionId());
        com.tencent.mobileqq.wink.editor.draft.a.i(uk().o2(), uk().o2().getMissionId());
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ll() {
        IPlayer currentPlayer;
        if (this.curTavCut == null) {
            return;
        }
        boolean z16 = true;
        if (uk().S1() != 1) {
            z16 = false;
        }
        if (!this.isInAddClipHDR && z16) {
            dr drVar = this.curTavCut;
            if (drVar != null && (currentPlayer = drVar.getCurrentPlayer()) != null) {
                currentPlayer.play();
            }
            this.onLoadAssetHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.t
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.ml(WinkEditorFragment.this);
                }
            });
            Tk().c5(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lm(final WinkEditorFragment this$0, final UpdateOpeningEndingData updateInfo) {
        List<MediaClip> list;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (updateInfo.getIsFromClipping()) {
            return;
        }
        dr drVar = this$0.curTavCut;
        String str = null;
        if (drVar != null) {
            list = drVar.g0();
        } else {
            list = null;
        }
        List<MediaClip> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(5, 100));
        this$0.qo();
        if (!(this$0.curTavCut instanceof WinkVideoTavCut)) {
            return;
        }
        WinkEditorOpeningEndingViewModel.Companion companion = WinkEditorOpeningEndingViewModel.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(updateInfo, "updateInfo");
        List<MediaClip> b16 = companion.b(list, updateInfo);
        this$0.sn(b16);
        dr drVar2 = this$0.curTavCut;
        Intrinsics.checkNotNull(drVar2, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
        WinkVideoTavCut.t3((WinkVideoTavCut) drVar2, b16, false, false, 6, null);
        h73.a.INSTANCE.b(b16);
        this$0.yk().H2(!this$0.Im(b16));
        this$0.yk().Q1(com.tencent.videocut.render.extension.e.g(b16));
        this$0.yk().q2(b16, null);
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        c73.a s16 = cxVar.s();
        if (s16 != null) {
            s16.j1();
        }
        MusicInfoWrapper value = this$0.xk().D2().getValue();
        if (value != null && !this$0.Tk().getIsFromTemplateColl()) {
            this$0.lastMusicStartTime = value.getStartTime();
            this$0.hk(value, b16, true);
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SETTING_DEFAULT_STATUS, 1);
            WinkEditSmartClipViewModel Qk = this$0.Qk();
            WinkEditorMusicInfo musicInfo = value.getMusicInfo();
            if (musicInfo != null) {
                str = musicInfo.p();
            }
            Qk.S1(str);
        }
        if (updateInfo.getIsOpeningClip()) {
            this$0.Yj(new Function3<LAKRenderModel, Long, Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$initOpeningEndingModel$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel, Long l3, Long l16) {
                    invoke(lAKRenderModel, l3.longValue(), l16.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull LAKRenderModel lAKRenderModel, long j3, long j16) {
                    Intrinsics.checkNotNullParameter(lAKRenderModel, "<anonymous parameter 0>");
                    dr curTavCut = WinkEditorFragment.this.getCurTavCut();
                    if (curTavCut != null) {
                        curTavCut.seek(0L);
                    }
                }
            });
        } else if (!updateInfo.getIsOpeningClip() && updateInfo.getMediaClip() != null) {
            this$0.Yj(new Function3<LAKRenderModel, Long, Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$initOpeningEndingModel$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel, Long l3, Long l16) {
                    invoke(lAKRenderModel, l3.longValue(), l16.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull LAKRenderModel lAKRenderModel, long j3, long j16) {
                    Intrinsics.checkNotNullParameter(lAKRenderModel, "<anonymous parameter 0>");
                    ResourceModel resourceModel = UpdateOpeningEndingData.this.getMediaClip().resource;
                    long j17 = resourceModel != null ? resourceModel.scaleDuration : 0L;
                    dr curTavCut = this$0.getCurTavCut();
                    if (curTavCut != null) {
                        curTavCut.seek(j3 - j17);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ln(WinkEditorFragment winkEditorFragment, Function0 function0, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        winkEditorFragment.kn(function0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lo(ArrayList<LocalMediaInfo> covers) {
        z93.c f16;
        if (getHostActivity() != null && !getHostActivity().isFinishing()) {
            cx cxVar = this.partManager;
            cx cxVar2 = null;
            if (cxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar = null;
            }
            boolean aa5 = cxVar.t().aa();
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar3 = null;
            }
            NextBtnPart t16 = cxVar3.t();
            dr drVar = this.curTavCut;
            WinkEditorViewModel Tk = Tk();
            MetaMaterial curTemplateMaterial = Sk().getCurTemplateMaterial();
            MetaMaterial curFilterMaterial = Ok().getCurFilterMaterial();
            int filterRangeMode = Ok().getFilterRangeMode();
            Activity hostActivity = getHostActivity();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
            cu.E(t16, drVar, Tk, curTemplateMaterial, curFilterMaterial, filterRangeMode, hostActivity, Tk().getIsFromTemplateLib(), Tk().getIsAutoTemplate(), Tk().getIsFromZShow(), aa5, "", true);
            uk().J2(this, this.curTavCut, Tk().getIsFromTemplateLib(), covers, this.clientTraceId, Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String(), aa5, getHostActivity().getIntent().getBooleanExtra(QQWinkConstants.IS_TO_TEMPLATE_TAB, false), xk());
            this.jumpToPublished = true;
            String str = this.clientTraceId;
            if (str != null) {
                WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL).traceId(str).retCode("0").getReportData();
                String str2 = Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
                if (str2 != null && (f16 = Wink.INSTANCE.f()) != null) {
                    f16.b(reportData, str2);
                }
            }
            if (r93.h.f430993a.g()) {
                cx cxVar4 = this.partManager;
                if (cxVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar4;
                }
                cu.I(cxVar2.t().Z9(), getHostActivity().getIntent(), Tk(), this, uk());
                return;
            }
            return;
        }
        w53.b.c("WinkEditorFragment", "toPublishPage: hostActivity is null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:242:0x0212, code lost:
    
        r10 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x013a, code lost:
    
        r12 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01cd, code lost:
    
        r10 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x037a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0472 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0441 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void mk() {
        String joinToString$default;
        List split$default;
        List<MediaClip> g06;
        int collectionSizeOrDefault;
        List<WinkEditData> n3;
        List list;
        List list2;
        List list3;
        List list4;
        List listOf;
        Collection<WinkStickerModel> values;
        int collectionSizeOrDefault2;
        List list5;
        boolean z16;
        Collection<WinkStickerModel> values2;
        List list6;
        boolean z17;
        Collection<WinkStickerModel> values3;
        int collectionSizeOrDefault3;
        List list7;
        Collection<WinkStickerModel> values4;
        int collectionSizeOrDefault4;
        List list8;
        List listOf2;
        List list9;
        List listOf3;
        String id5;
        Intent intent;
        String stringExtra;
        String str;
        List listOf4;
        Intent intent2;
        Intent intent3;
        String stringExtra2;
        FragmentActivity activity;
        Intent intent4;
        String stringExtra3;
        List listOf5;
        ArrayList<ArrayList<WinkPublishMediaRecord>> arrayList = new ArrayList<>();
        dr drVar = this.curTavCut;
        Set set = null;
        if (drVar != null && (n3 = drVar.n()) != null) {
            for (WinkEditData winkEditData : n3) {
                ArrayList<WinkPublishMediaRecord> arrayList2 = new ArrayList<>();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent3 = activity2.getIntent()) != null && (stringExtra2 = intent3.getStringExtra(QQWinkConstants.SCHEMA_MATERIAL_ID)) != null && (activity = getActivity()) != null && (intent4 = activity.getIntent()) != null && (stringExtra3 = intent4.getStringExtra(QQWinkConstants.SCHEMA_MATERIAL_TYPE)) != null) {
                    listOf5 = CollectionsKt__CollectionsJVMKt.listOf(stringExtra2);
                    arrayList2.add(new WinkPublishMediaRecord(stringExtra3, listOf5));
                }
                FragmentActivity activity3 = getActivity();
                Serializable serializableExtra = (activity3 == null || (intent2 = activity3.getIntent()) == null) ? null : intent2.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
                MetaMaterial metaMaterial = serializableExtra instanceof MetaMaterial ? (MetaMaterial) serializableExtra : null;
                if (metaMaterial != null && (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) != null && Intrinsics.areEqual(str, QQWinkConstants.BUSINESS_ZSHOW_NAME)) {
                    listOf4 = CollectionsKt__CollectionsJVMKt.listOf(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME);
                    arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_ZSHOW, listOf4));
                }
                FragmentActivity activity4 = getActivity();
                if (activity4 != null && (intent = activity4.getIntent()) != null && (stringExtra = intent.getStringExtra(QQWinkConstants.SCHEMA_OPERATION_ACTIVITY_ID)) != null) {
                    HashMap<String, Object> params = WinkDatongCurrentParams.params;
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    params.put("xsj_operation_activity_id", stringExtra);
                    Unit unit = Unit.INSTANCE;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (Tk().getIsFromMemoryAlbum()) {
                    linkedHashSet.add("tianshu_memoryalbum");
                }
                if (Tk().getMFrom() == 12) {
                    linkedHashSet2.add(QQWinkConstants.TEMPLATE_ID_MAOMEME);
                }
                if (Sk().getCurTemplateMaterial() != null) {
                    MetaMaterial curTemplateMaterial = Sk().getCurTemplateMaterial();
                    if (curTemplateMaterial != null && (id5 = curTemplateMaterial.f30533id) != null) {
                        Intrinsics.checkNotNullExpressionValue(id5, "id");
                        if (Tk().getIsFromTemplateLib()) {
                            linkedHashSet2.add(id5);
                        } else {
                            linkedHashSet.add(id5);
                        }
                    }
                } else {
                    Map<String, MetaMaterial> templateMaterialMap = winkEditData.getTemplateMaterialMap();
                    if (templateMaterialMap != null && (r12 = templateMaterialMap.keySet()) != null && list != null) {
                        if (Tk().getIsFromTemplateLib()) {
                            linkedHashSet2.addAll(list);
                        } else {
                            linkedHashSet.addAll(list);
                        }
                    }
                }
                list2 = CollectionsKt___CollectionsKt.toList(linkedHashSet);
                arrayList2.add(new WinkPublishMediaRecord("template", list2));
                list3 = CollectionsKt___CollectionsKt.toList(linkedHashSet2);
                arrayList2.add(new WinkPublishMediaRecord("libTemplate", list3));
                String captureMaterialId = Tk().getCaptureMaterialId();
                if (!(captureMaterialId == null || captureMaterialId.length() == 0)) {
                    listOf3 = CollectionsKt__CollectionsJVMKt.listOf(Tk().getCaptureMaterialId());
                    arrayList2.add(new WinkPublishMediaRecord("meterial", listOf3));
                }
                if (Ok().getFilterRangeMode() == 100) {
                    listOf2 = CollectionsKt__CollectionsJVMKt.listOf("2");
                    arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_FILTER_SCOPE, listOf2));
                    Map<String, MetaMaterial> filterMaterialMap = winkEditData.getFilterMaterialMap();
                    if (filterMaterialMap != null && (r10 = filterMaterialMap.keySet()) != null && list9 != null) {
                        arrayList2.add(new WinkPublishMediaRecord("filter", list9));
                    }
                } else if (Ok().getFilterRangeMode() == 101) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf("1");
                    arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_FILTER_SCOPE, listOf));
                    arrayList2.add(new WinkPublishMediaRecord("filter", cu.i(this.curTavCut)));
                } else {
                    Map<String, MetaMaterial> filterMaterialMap2 = winkEditData.getFilterMaterialMap();
                    if (filterMaterialMap2 != null && (r10 = filterMaterialMap2.keySet()) != null && list4 != null) {
                        arrayList2.add(new WinkPublishMediaRecord("filter", list4));
                    }
                }
                Map<String, WinkStickerModel> stickerModelMap = winkEditData.getStickerModelMap();
                if (stickerModelMap != null && (values4 = stickerModelMap.values()) != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : values4) {
                        WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
                        if ((winkStickerModel.getMaterial() == null || winkStickerModel.isTextSticker() || Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(winkStickerModel.getMaterial()), "CATEGORY_TEXT_DECOR") || !com.tencent.mobileqq.wink.editor.c.o0(winkStickerModel.getMaterial())) ? false : true) {
                            arrayList3.add(obj);
                        }
                    }
                    collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                    ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        MetaMaterial material = ((WinkStickerModel) it.next()).getMaterial();
                        Intrinsics.checkNotNull(material);
                        arrayList4.add(material.f30533id);
                    }
                    list8 = CollectionsKt___CollectionsKt.toList(arrayList4);
                    if (list8 != null) {
                        arrayList2.add(new WinkPublishMediaRecord("sticker", list8));
                    }
                }
                Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
                if (stickerModelMap2 != null && (values3 = stickerModelMap2.values()) != null) {
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj2 : values3) {
                        WinkStickerModel winkStickerModel2 = (WinkStickerModel) obj2;
                        if (winkStickerModel2.getMaterial() != null && winkStickerModel2.isPlainText() && com.tencent.mobileqq.wink.editor.c.o0(winkStickerModel2.getMaterial())) {
                            arrayList5.add(obj2);
                        }
                    }
                    collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
                    ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault3);
                    Iterator it5 = arrayList5.iterator();
                    while (it5.hasNext()) {
                        MetaMaterial material2 = ((WinkStickerModel) it5.next()).getMaterial();
                        Intrinsics.checkNotNull(material2);
                        arrayList6.add(material2.f30533id);
                    }
                    list7 = CollectionsKt___CollectionsKt.toList(arrayList6);
                    if (list7 != null) {
                        arrayList2.add(new WinkPublishMediaRecord("text", list7));
                    }
                }
                ArrayList arrayList7 = new ArrayList();
                if (Tk().getTtsAudioInfo() != null) {
                    TTSAudioInfo ttsAudioInfo = Tk().getTtsAudioInfo();
                    Intrinsics.checkNotNull(ttsAudioInfo);
                    if (ttsAudioInfo.getTemplateType() != TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
                        TTSAudioInfo ttsAudioInfo2 = Tk().getTtsAudioInfo();
                        Intrinsics.checkNotNull(ttsAudioInfo2);
                        String displayName = ttsAudioInfo2.getDisplayName();
                        if (displayName == null) {
                            displayName = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(displayName, "winkEditorViewModel.ttsA\u2026!!.displayName ?: DEFAULT");
                        }
                        arrayList7.add(displayName);
                    }
                }
                Map<String, WinkStickerModel> stickerModelMap3 = winkEditData.getStickerModelMap();
                if (stickerModelMap3 != null && (values2 = stickerModelMap3.values()) != null) {
                    ArrayList arrayList8 = new ArrayList();
                    for (Object obj3 : values2) {
                        WinkStickerModel winkStickerModel3 = (WinkStickerModel) obj3;
                        if (winkStickerModel3.getMaterial() != null && winkStickerModel3.getTtsAudioInfo() != null) {
                            TTSAudioInfo ttsAudioInfo3 = winkStickerModel3.getTtsAudioInfo();
                            if (!(ttsAudioInfo3 != null && ttsAudioInfo3.getTemplateType() == TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER)) {
                                z17 = true;
                                if (!z17) {
                                    arrayList8.add(obj3);
                                }
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                    }
                    ArrayList arrayList9 = new ArrayList();
                    Iterator it6 = arrayList8.iterator();
                    while (it6.hasNext()) {
                        TTSAudioInfo ttsAudioInfo4 = ((WinkStickerModel) it6.next()).getTtsAudioInfo();
                        Intrinsics.checkNotNull(ttsAudioInfo4);
                        String displayName2 = ttsAudioInfo4.getDisplayName();
                        if (displayName2 != null) {
                            arrayList9.add(displayName2);
                        }
                    }
                    list6 = CollectionsKt___CollectionsKt.toList(arrayList9);
                    if (list6 != null) {
                        arrayList7.addAll(list6);
                    }
                }
                if (!arrayList7.isEmpty()) {
                    arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_TTS_NAME, arrayList7));
                }
                ArrayList arrayList10 = new ArrayList();
                if (Tk().getTtsAudioInfo() != null) {
                    TTSAudioInfo ttsAudioInfo5 = Tk().getTtsAudioInfo();
                    Intrinsics.checkNotNull(ttsAudioInfo5);
                    if (ttsAudioInfo5.getTemplateType() != TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
                        TTSAudioInfo ttsAudioInfo6 = Tk().getTtsAudioInfo();
                        Intrinsics.checkNotNull(ttsAudioInfo6);
                        arrayList10.add(String.valueOf(ttsAudioInfo6.getVolume()));
                    }
                }
                Map<String, WinkStickerModel> stickerModelMap4 = winkEditData.getStickerModelMap();
                if (stickerModelMap4 != null && (values = stickerModelMap4.values()) != null) {
                    ArrayList arrayList11 = new ArrayList();
                    for (Object obj4 : values) {
                        WinkStickerModel winkStickerModel4 = (WinkStickerModel) obj4;
                        if (winkStickerModel4.getMaterial() != null && winkStickerModel4.getTtsAudioInfo() != null) {
                            TTSAudioInfo ttsAudioInfo7 = winkStickerModel4.getTtsAudioInfo();
                            if (!(ttsAudioInfo7 != null && ttsAudioInfo7.getTemplateType() == TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER)) {
                                z16 = true;
                                if (!z16) {
                                    arrayList11.add(obj4);
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList11, 10);
                    ArrayList arrayList12 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it7 = arrayList11.iterator();
                    while (it7.hasNext()) {
                        TTSAudioInfo ttsAudioInfo8 = ((WinkStickerModel) it7.next()).getTtsAudioInfo();
                        Intrinsics.checkNotNull(ttsAudioInfo8);
                        arrayList12.add(String.valueOf(ttsAudioInfo8.getVolume()));
                    }
                    list5 = CollectionsKt___CollectionsKt.toList(arrayList12);
                    if (list5 != null) {
                        arrayList10.addAll(list5);
                    }
                }
                if (!arrayList10.isEmpty()) {
                    arrayList2.add(new WinkPublishMediaRecord(WinkPublishMediaRecord.WINK_REPORT_TYPE_TTS_VOLUME, arrayList10));
                }
                arrayList.add(arrayList2);
            }
            Unit unit2 = Unit.INSTANCE;
        }
        dr drVar2 = this.curTavCut;
        if (drVar2 != null && (g06 = drVar2.g0()) != null) {
            ArrayList arrayList13 = new ArrayList();
            for (Object obj5 : g06) {
                if (com.tencent.videocut.render.extension.e.r((MediaClip) obj5) != MediaClipUseType.NORMAL) {
                    arrayList13.add(obj5);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList13, 10);
            ArrayList arrayList14 = new ArrayList(collectionSizeOrDefault);
            Iterator it8 = arrayList13.iterator();
            while (it8.hasNext()) {
                arrayList14.add(com.tencent.videocut.render.extension.e.p((MediaClip) it8.next()));
            }
            set = CollectionsKt___CollectionsKt.toMutableSet(arrayList14);
        }
        Set set2 = set;
        if (set2 != null) {
            Object videoMaterialIds = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID);
            String str2 = (String) videoMaterialIds;
            if (!(str2 == null || str2.length() == 0) && !Intrinsics.areEqual(videoMaterialIds, "")) {
                Intrinsics.checkNotNullExpressionValue(videoMaterialIds, "videoMaterialIds");
                split$default = StringsKt__StringsKt.split$default((CharSequence) videoMaterialIds, new String[]{","}, false, 0, 6, (Object) null);
                set2.addAll(split$default);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(set2, ",", null, null, 0, null, null, 62, null);
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, joinToString$default);
        }
        uk().E2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ml(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.k().fb(false);
    }

    private final void mm() {
        AECameraPrefsUtil.c().b("SP_SHOW_FPS_INFO", false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mn(WinkEditorFragment this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSaveMediaRunnable.run();
        function0.invoke();
    }

    private final void mo(dr.WinkTavCutParams params) {
        if (!params.getIsFirstInit()) {
            VideoReport.pageLogicDestroy(getView());
        }
    }

    private final ArrayList<LocalMediaInfo> nk() {
        Object obj;
        ArrayList<String> arrayList;
        Object obj2;
        HashMap hashMap;
        Object obj3;
        HashMap hashMap2;
        ArrayList<LocalMediaInfo> R2;
        HashMap<String, Serializable> hashMap3;
        LocalMediaInfo localMediaInfo;
        int collectionSizeOrDefault;
        Bundle arguments = getArguments();
        Map map = null;
        if (arguments != null) {
            obj = arguments.get(QQWinkConstants.CLIP_ALL_MEDIA_LIST);
        } else {
            obj = null;
        }
        if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            obj2 = arguments2.get(QQWinkConstants.CLIP_LOCAL_MEDIA_INFO_EXT_DATA);
        } else {
            obj2 = null;
        }
        if (obj2 instanceof HashMap) {
            hashMap = (HashMap) obj2;
        } else {
            hashMap = null;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            obj3 = arguments3.get(QQWinkConstants.CLIP_ADDED_LOCAL_MEDIA_INFO);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof HashMap) {
            hashMap2 = (HashMap) obj3;
        } else {
            hashMap2 = null;
        }
        ArrayList<LocalMediaInfo> R22 = Tk().R2();
        if (R22 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(R22, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo2 : R22) {
                arrayList2.add(TuplesKt.to(localMediaInfo2.path, localMediaInfo2));
            }
            map = MapsKt__MapsKt.toMap(arrayList2);
        }
        ArrayList<LocalMediaInfo> arrayList3 = new ArrayList<>();
        if (arrayList != null) {
            for (String str : arrayList) {
                boolean z16 = false;
                if (map != null && map.containsKey(str)) {
                    z16 = true;
                }
                if (z16) {
                    LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) map.get(str);
                    if (localMediaInfo3 != null) {
                        arrayList3.add(localMediaInfo3);
                    }
                } else if (hashMap != null && (hashMap3 = (HashMap) hashMap.get(str)) != null && hashMap2 != null && (localMediaInfo = (LocalMediaInfo) hashMap2.get(str)) != null) {
                    localMediaInfo.extData = hashMap3;
                    arrayList3.add(localMediaInfo);
                }
            }
        }
        if (arrayList3.isEmpty() && (R2 = Tk().R2()) != null) {
            arrayList3.addAll(R2);
        }
        return arrayList3;
    }

    private final void nl(boolean isClipChange) {
        long j3;
        if (this.curTavCut == null) {
            ms.a.f("WinkEditorFragment", "curTavCut == null || winkEditorViewModel == null");
            return;
        }
        if (isClipChange) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.l
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.pl(WinkEditorFragment.this);
                }
            });
        }
        dr drVar = this.curTavCut;
        if (drVar != null) {
            j3 = drVar.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        this.curPlayerTimeUs = j3;
        if (this.isExportProcessing) {
            this.curPlayerTimeUs = 0L;
            this.isExportProcessing = false;
        }
        WinkEditorViewModel Tk = Tk();
        dr drVar2 = this.curTavCut;
        Intrinsics.checkNotNull(drVar2);
        Tk.B5(drVar2, WinkHDRCacheManager.INSTANCE.a().c(), this.curPlayerTimeUs, true, Tk().E3());
    }

    private final void nm(View view, int playerWidth, int playerHeight) {
        WinkVideoTavCut winkVideoTavCut;
        WinkAdaptiveImageView winkAdaptiveImageView = (WinkAdaptiveImageView) view.findViewById(R.id.xyw);
        if (winkAdaptiveImageView == null) {
            return;
        }
        this.ivPreloadFrame = winkAdaptiveImageView;
        if (Tk().R1()) {
            return;
        }
        WinkVideoTavCut winkVideoTavCut2 = null;
        if (Tk().getIsFromTemplateLib() && !Tk().k3()) {
            WinkAdaptiveImageView winkAdaptiveImageView2 = this.ivPreloadFrame;
            if (winkAdaptiveImageView2 != null) {
                winkAdaptiveImageView2.setVisibility(0);
            }
            WinkAdaptiveImageView winkAdaptiveImageView3 = this.ivPreloadFrame;
            if (winkAdaptiveImageView3 != null) {
                winkAdaptiveImageView3.setImageBitmap(null);
            }
            WinkAdaptiveImageView winkAdaptiveImageView4 = this.ivPreloadFrame;
            if (winkAdaptiveImageView4 != null) {
                winkAdaptiveImageView4.setBackgroundColor(-16777216);
            }
        } else {
            Bitmap g16 = FirstFramePreLoader.g();
            if (g16 == null) {
                return;
            }
            dr drVar = this.videoTavCut;
            if (drVar instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                int renderFillType = winkVideoTavCut.getRenderFillType();
                dr drVar2 = this.videoTavCut;
                if (drVar2 instanceof WinkVideoTavCut) {
                    winkVideoTavCut2 = (WinkVideoTavCut) drVar2;
                }
                if (winkVideoTavCut2 != null) {
                    Intrinsics.checkNotNull(drVar2);
                    boolean U2 = winkVideoTavCut2.U2(drVar2.getRenderSize());
                    ms.a.f("WinkEditorFragment", "initPreloadFrame w = " + playerWidth + " h = " + playerHeight + ", renderFillType = " + renderFillType + ", isVerticalPlayer = " + U2);
                    WinkAdaptiveImageView winkAdaptiveImageView5 = this.ivPreloadFrame;
                    if (winkAdaptiveImageView5 != null) {
                        winkAdaptiveImageView5.setVisibility(0);
                    }
                    try {
                        WinkAdaptiveImageView winkAdaptiveImageView6 = this.ivPreloadFrame;
                        if (winkAdaptiveImageView6 != null) {
                            winkAdaptiveImageView6.setImageBitmap(g16, getRenderWidth(), getRenderHeight(), playerWidth, playerHeight, renderFillType, U2);
                        }
                    } catch (Exception e16) {
                        w53.b.c("WinkEditorFragment", "initPreloadFrame mFirstFrameBitMap set error: " + e16);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Mk().g2();
        WinkAdaptiveImageView winkAdaptiveImageView7 = this.ivPreloadFrame;
        if (winkAdaptiveImageView7 != null) {
            winkAdaptiveImageView7.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ad
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.om(WinkEditorFragment.this);
                }
            }, 3000L);
        }
    }

    private final void nn() {
        if (this.mDelayForSaveMedialModel > 0) {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.mTimeSaveMediaModelRunnable);
            ThreadManager.getFileThreadHandler().postDelayed(this.mTimeSaveMediaModelRunnable, this.mDelayForSaveMedialModel);
        }
    }

    private final void no(String dir) {
        dr drVar = this.curTavCut;
        if (drVar != null) {
            drVar.j0(dir);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void ol(WinkEditorFragment winkEditorFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        winkEditorFragment.nl(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void om(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkAdaptiveImageView winkAdaptiveImageView = this$0.ivPreloadFrame;
        if (winkAdaptiveImageView != null) {
            winkAdaptiveImageView.setImageBitmap(null);
            winkAdaptiveImageView.setVisibility(4);
        }
    }

    private final void on(int width, int height) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), new o(CoroutineExceptionHandler.INSTANCE), null, new WinkEditorFragment$preloadData$1(this, width, height, null), 2, null);
        this.preloadDataJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oo(long durationUs) {
        cx cxVar = this.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        c73.a s16 = cxVar.s();
        if (s16 != null) {
            s16.W(durationUs);
        }
        cx cxVar3 = this.partManager;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        } else {
            cxVar2 = cxVar3;
        }
        cxVar2.y().Ja(durationUs);
    }

    private final Animation pk() {
        Animation animation = this.mFadeInAnimation;
        if (animation == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
            this.mFadeInAnimation = loadAnimation;
            return loadAnimation;
        }
        return animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pl(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.Wn(true);
        }
    }

    private final void pm() {
        if (Tk().t4()) {
            Xk().P1(true);
        }
    }

    private final void pn() {
        Unit unit;
        if (Tk().s4()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_EDITOR_EXIT");
                WinkContext.Companion companion2 = WinkContext.INSTANCE;
                WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).ext1(String.valueOf(Tk().getMFrom())).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void po() {
        boolean z16;
        boolean z17;
        Intent intent;
        boolean areEqual = Intrinsics.areEqual(this.schemaAttrsMap.get("target"), "1");
        String str = this.schemaAttrsMap.get("music");
        boolean z18 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && intent.getBooleanExtra(QQWinkConstants.IS_AUTO_TEMPLATE, false)) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean k3 = Tk().k3();
        MusicSourceViewModel xk5 = xk();
        if (z17 && areEqual && z16 && !k3) {
            z18 = false;
        }
        xk5.u4(z18);
        w53.b.f("WinkEditorFragment", "[updateNeedAutoMusic] needAutoMusic=" + xk().getNeedAutoMusic());
    }

    private final Animation qk() {
        Animation animation = this.mFadeOutAnimation;
        if (animation == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
            this.mFadeOutAnimation = loadAnimation;
            return loadAnimation;
        }
        return animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ql() {
        Ck().d();
    }

    private final void qm() {
        if (!a63.a.INSTANCE.f("winkQzonePhotoTemplate")) {
            Tk().o5();
        }
    }

    private final void qn() {
        Tk().w3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.rn(WinkEditorFragment.this, (Map) obj);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    private final void qo() {
        ?? orNull;
        WinkVideoTavCut winkVideoTavCut;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        orNull = CollectionsKt___CollectionsKt.getOrNull(Gk().F2(this.curTavCut), 0);
        objectRef.element = orNull;
        dr drVar = this.curTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            WinkEditorFragment$updateSubtitle$1$runnable$1 winkEditorFragment$updateSubtitle$1$runnable$1 = new WinkEditorFragment$updateSubtitle$1$runnable$1(this, objectRef);
            ThreadManagerV2.getUIHandlerV2().postDelayed(winkEditorFragment$updateSubtitle$1$runnable$1, 500L);
            winkVideoTavCut.m0(new q(winkVideoTavCut, winkEditorFragment$updateSubtitle$1$runnable$1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rl() {
        WinkAdaptiveImageView winkAdaptiveImageView = this.ivPreloadFrame;
        if (winkAdaptiveImageView != null) {
            winkAdaptiveImageView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.q
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.sl(WinkEditorFragment.this);
                }
            });
        }
    }

    private final void rm() {
        Serializable serializable;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Intent intent;
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.RECOMMEND_MUSIC_INFO_BYTES);
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        w53.b.f("WinkEditorFragment", "[initRecommendViewModel] musicInfoBytes.size=" + num);
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            final ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new QQCircleSmartMatchMusic$MusicInfo().mergeFrom((byte[]) it.next()));
            }
            po();
            if (!TextUtils.isEmpty(this.tongKuanMusicMid) && !Intrinsics.areEqual("fakeMid_template_bgm", this.tongKuanMusicMid)) {
                w53.b.f("WinkEditorFragment", "[initRecommendViewModel] tongKuanMusicMid=" + this.tongKuanMusicMid);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(this.tongKuanMusicMid);
                WinkEditorMusicHelper.D(arrayList3, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.af
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        WinkEditorFragment.sm(WinkEditorFragment.this, arrayList2, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                    }
                });
            } else {
                xk().x4(arrayList2, new ArrayList());
            }
        }
        LiveData<List<byte[]>> N1 = Yk().N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final WinkEditorFragment$initRecommendViewModel$3 winkEditorFragment$initRecommendViewModel$3 = new WinkEditorFragment$initRecommendViewModel$3(arrayList, this);
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.tm(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rn(WinkEditorFragment this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        for (com.tencent.mobileqq.wink.editor.d dVar : cxVar.x()) {
            if (map.containsKey(dVar.TAG) && map.get(dVar.TAG) != null) {
                dVar.N9((WinkEditUIData) map.get(dVar.TAG));
            }
        }
        if (map.containsKey(this$0.Vk().getTAG()) && map.get(this$0.Vk().getTAG()) != null) {
            this$0.Vk().b2((WinkEditUIData) map.get(this$0.Vk().getTAG()));
        }
    }

    private final void ro() {
        ((WinkPlayerContainerView) Fi(R.id.f25760bp)).post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aw
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.so(WinkEditorFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sl(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkAdaptiveImageView winkAdaptiveImageView = this$0.ivPreloadFrame;
        if (winkAdaptiveImageView != null) {
            winkAdaptiveImageView.setImageBitmap(null);
        }
        WinkAdaptiveImageView winkAdaptiveImageView2 = this$0.ivPreloadFrame;
        if (winkAdaptiveImageView2 != null) {
            winkAdaptiveImageView2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sm(WinkEditorFragment this$0, List it, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        w53.b.f("WinkEditorFragment", "[initRecommendViewModel] requestDetailedMusicInfo=" + qQCircleSmartMatchMusic$MusicInfoRsp);
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            this$0.xk().x4(it, WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350"));
        }
    }

    private final void sn(List<? extends MediaClip> mediaClips) {
        if ((this.curTavCut instanceof WinkImageTavCut) || !QzoneConfig.getWinkTransitionSwitch()) {
            return;
        }
        if (Im(mediaClips)) {
            dr drVar = this.curTavCut;
            Intrinsics.checkNotNull(drVar, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
            Tk().Z4(((WinkVideoTavCut) drVar).M3());
            return;
        }
        dr drVar2 = this.curTavCut;
        Intrinsics.checkNotNull(drVar2, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
        ((WinkVideoTavCut) drVar2).D2();
        Tk().Z4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void so(WinkEditorFragment this$0) {
        WinkImageTavCut winkImageTavCut;
        IPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null && !this$0.requireActivity().isFinishing()) {
            com.tencent.mobileqq.wink.editor.util.m mVar = com.tencent.mobileqq.wink.editor.util.m.f322645a;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            WinkVideoTavCut winkVideoTavCut = null;
            mVar.t(null, requireActivity);
            Pair<Integer, Integer> g16 = mVar.g(this$0.requireActivity());
            int intValue = g16.component1().intValue();
            int intValue2 = g16.component2().intValue();
            this$0.On();
            dr drVar = this$0.curTavCut;
            if (drVar != null) {
                drVar.n0(intValue, intValue2);
            }
            dr drVar2 = this$0.curTavCut;
            if (drVar2 instanceof WinkImageTavCut) {
                winkImageTavCut = (WinkImageTavCut) drVar2;
            } else {
                winkImageTavCut = null;
            }
            if (winkImageTavCut != null) {
                winkImageTavCut.i1(intValue, intValue2);
            }
            dr drVar3 = this$0.curTavCut;
            if (drVar3 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar3;
            }
            WinkVideoTavCut winkVideoTavCut2 = winkVideoTavCut;
            if (winkVideoTavCut2 != null) {
                Intrinsics.checkNotNull(drVar3);
                WinkVideoTavCut.a3(winkVideoTavCut2, drVar3.V(), false, 0L, 6, null);
            }
            dr drVar4 = this$0.curTavCut;
            if (drVar4 != null) {
                drVar4.R(0);
            }
            dr drVar5 = this$0.curTavCut;
            if (drVar5 != null && (currentPlayer = drVar5.getCurrentPlayer()) != null) {
                currentPlayer.requestRender();
                return;
            }
            return;
        }
        w53.b.c("WinkEditorFragment", "Activity has been destroy.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tl(dr.WinkTavCutParams params) {
        w53.b.f("WinkEditorFragment", "initAfterPerloadData listen:initTavCut-> " + params.getWidth() + ", " + params.getHeight());
        if (getHostActivity() != null && !getHostActivity().isFinishing() && !getHostActivity().isDestroyed() && !isDetached() && getView() != null) {
            Am(params);
            View view = getView();
            if (view != null) {
                nm(view, params.getWidth(), params.getHeight());
            }
            cx cxVar = null;
            gl(this, false, 1, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorFragment$initAfterPreloadData$2(this, null), 3, null);
            cx cxVar2 = this.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar2 = null;
            }
            Iterator<T> it = cxVar2.x().iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.wink.editor.d) it.next()).M9();
            }
            if (Tk().getIsEnableMusic()) {
                Ul();
            }
            Xj();
            initViewModel();
            ul();
            SimpleEventBus.getInstance().dispatchEvent(new WinkPublishInitializationCompletedEvent(), true);
            Log.i("PhoneLevel:", String.valueOf(OfflineConfig.getPhonePerfLevel(getContext())));
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar = cxVar3;
            }
            WinkEditorOpeningEndingModePart openingEndingModelPart = cxVar.getOpeningEndingModelPart();
            if (openingEndingModelPart != null) {
                openingEndingModelPart.qa();
            }
            jl();
            if (Tk().u4()) {
                qm();
            }
            Tk().q5();
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_fabuqi_wenzigongnengjiaohudiedai");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tm(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void tn(boolean isDestroy) {
        ThreadManager.getFileThreadHandler().removeCallbacks(this.mTimeSaveMediaModelRunnable);
        if (this.realSaveRunnable != null) {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.realSaveRunnable);
        }
        if (isDestroy) {
            this.mTimeSaveMediaModelRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.al
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.vn();
                }
            };
            this.realSaveRunnable = null;
        }
    }

    private final void to(String eid) {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", eid);
        View view = null;
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null) {
            view = pageInfo.getPageView();
        }
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
    }

    private final com.tencent.mobileqq.wink.editor.export.u uk() {
        Object value = this.mWinkExportViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkExportViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.export.u) value;
    }

    private final void ul() {
        Rk().m2();
    }

    private final void um() {
        Qk().T1(Tk().getDraftMusicMid());
        Qk().U1(Tk().getIsLoadFromDraft());
        Qk().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.vm(WinkEditorFragment.this, (AutoClipResult) obj);
            }
        });
    }

    static /* synthetic */ void un(WinkEditorFragment winkEditorFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        winkEditorFragment.tn(z16);
    }

    private final WinkExtractCoverViewModel vk() {
        Object value = this.mWinkExtractCoverViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkExtractCoverViewModel>(...)");
        return (WinkExtractCoverViewModel) value;
    }

    private final void vl(View view) {
        ConstraintLayout.LayoutParams layoutParams;
        Integer num;
        if (Tk().getIsOpeningEndingEditMode()) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.t2c);
        imageView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        Integer num2 = null;
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            num = Integer.valueOf(((ViewGroup.MarginLayoutParams) layoutParams).topMargin - com.tencent.mobileqq.wink.editor.util.m.m(imageView.getContext()));
        } else {
            num = null;
        }
        if (num != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = num.intValue();
        }
        if (layoutParams != null) {
            num2 = Integer.valueOf(((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
        }
        ms.a.a("WinkEditorFragment", "AFTER backBtn top:" + num2);
        this.backBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkEditorFragment.wl(WinkEditorFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vm(WinkEditorFragment this$0, AutoClipResult result) {
        dr drVar;
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!result.c().isEmpty() && (drVar = this$0.curTavCut) != null) {
            WinkEditorOpeningEndingViewModel.Companion companion = WinkEditorOpeningEndingViewModel.INSTANCE;
            Intrinsics.checkNotNull(drVar);
            List<MediaClip> g06 = drVar.g0();
            Intrinsics.checkNotNullExpressionValue(result, "result");
            List<MediaClip> a16 = companion.a(g06, result);
            dr drVar2 = this$0.curTavCut;
            if (drVar2 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar2;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.e0(a16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String wk() {
        List<MediaClip> g06;
        long j3;
        StringBuilder sb5 = new StringBuilder();
        dr drVar = this.curTavCut;
        if (drVar != null && (g06 = drVar.g0()) != null) {
            for (MediaClip mediaClip : g06) {
                int Ak = Ak(mediaClip);
                int zk5 = zk(mediaClip);
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    j3 = resourceModel.scaleDuration;
                } else {
                    j3 = 0;
                }
                sb5.append(Ak);
                sb5.append("*");
                sb5.append(zk5);
                sb5.append(":");
                sb5.append(j3 / 1000000);
                sb5.append(",");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wl(WinkEditorFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void wm() {
        Boolean bool = u53.i.f438428a;
        if (bool == null) {
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.context);
            Boolean valueOf = Boolean.valueOf(QzoneConfig.isOpenFFmpegDecode(phonePerfLevel, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
            u53.i.f438428a = valueOf;
            w53.b.c("WinkEditorFragment", "[wns][onViewCreated] deviceLevel = " + phonePerfLevel + ", isOpenFFmpegDecode = " + valueOf);
            return;
        }
        w53.b.c("WinkEditorFragment", "[wns][onViewCreated] isOpenFFmpegDecode = " + bool);
    }

    private final void wn() {
        long j3;
        dr drVar = this.curTavCut;
        if (drVar == null) {
            ms.a.f("WinkEditorFragment", "curTavCut == null || winkEditorViewModel == null");
            return;
        }
        if (drVar != null) {
            j3 = drVar.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        this.curPlayerTimeUs = j3;
        WinkEditorViewModel Tk = Tk();
        dr drVar2 = this.curTavCut;
        Intrinsics.checkNotNull(drVar2);
        WinkEditorViewModel.C5(Tk, drVar2, WinkHDRCacheManager.INSTANCE.a().c(), this.curPlayerTimeUs, false, false, 16, null);
    }

    private final void xl() {
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        WinkEditorChallengePart challengePart = cxVar.getChallengePart();
        if (challengePart != null) {
            challengePart.Q9(null);
        }
    }

    private final void xm(View view) {
        boolean z16;
        cx cxVar = this.partManager;
        BorderView borderView = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        WinkEditorStickerControlPart A = cxVar.A();
        if (!Tk().getIsFromZShow() && !Tk().getIsFromQzoneText()) {
            z16 = true;
        } else {
            z16 = false;
        }
        A.cc(z16);
        cx cxVar2 = this.partManager;
        if (cxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar2 = null;
        }
        cxVar2.A().Mb(Tk().getIsFromQzoneText());
        cx cxVar3 = this.partManager;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar3 = null;
        }
        cxVar3.A().Q9(null);
        View findViewById = view.findViewById(R.id.f88404wz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.stickerControlView)");
        BorderView borderView2 = (BorderView) findViewById;
        this.stickerBorderView = borderView2;
        if (borderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView2 = null;
        }
        borderView2.setGestureDetectorCallback(this);
        BorderView borderView3 = this.stickerBorderView;
        if (borderView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView3 = null;
        }
        cx cxVar4 = this.partManager;
        if (cxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar4 = null;
        }
        borderView3.setOperationCallback(cxVar4.A());
        BorderView borderView4 = this.stickerBorderView;
        if (borderView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView4 = null;
        }
        borderView4.setBorderLineCallBack(this);
        BorderView borderView5 = this.stickerBorderView;
        if (borderView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
        } else {
            borderView = borderView5;
        }
        borderView.setCutSizeCallBack(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xn(boolean hasBgm, long timeCost, String errorMsg, boolean fromLocal, int segmentIdx) {
        String str;
        Unit unit;
        if (Tk().s4()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_EDIT_BGM_CHECK");
                WinkContext.Companion companion2 = WinkContext.INSTANCE;
                WinkPublishQualityReportData.Builder ext2 = eventId.traceId(companion2.d().getTraceId()).ext1(String.valueOf(Tk().getMFrom())).ext2(String.valueOf(timeCost));
                String str2 = "1";
                if (fromLocal) {
                    str = "1";
                } else {
                    str = "0";
                }
                WinkPublishQualityReportData.Builder ext4 = ext2.ext3(str).ext4(String.valueOf(segmentIdx));
                if (!hasBgm) {
                    str2 = "0";
                }
                WinkPublishQualityReportData reportData = ext4.ext5(str2).ext6(errorMsg).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
    }

    private final MusicVolumeControlViewModel yk() {
        return (MusicVolumeControlViewModel) this.musicVolumeViewModel.getValue();
    }

    private final void ym() {
        Zk().q2(Tk().getIsFromZShow());
        Zk().N1(Tk().getTtsAudioInfo());
        Zk().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.zm(WinkEditorFragment.this, (androidx.core.util.Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void yn(WinkEditorFragment winkEditorFragment, boolean z16, long j3, String str, boolean z17, int i3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        boolean z18 = z17;
        if ((i16 & 16) != 0) {
            i3 = -1;
        }
        winkEditorFragment.xn(z16, j3, str, z18, i3);
    }

    private final void zl() {
        Tk().f3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Al(WinkEditorFragment.this, (MenuSwitchAction) obj);
            }
        });
        Tk().P2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Bl(WinkEditorFragment.this, (ArrayList) obj);
            }
        });
        Tk().p3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Cl(WinkEditorFragment.this, (dr.WinkTavCutParams) obj);
            }
        });
        Tk().M2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Dl(WinkEditorFragment.this, (t73.a) obj);
            }
        });
        Tk().w2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.El(WinkEditorFragment.this, (t73.a) obj);
            }
        });
        Tk().i3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Fl(WinkEditorFragment.this, (t73.a) obj);
            }
        });
        Tk().x2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorFragment.Hl(WinkEditorFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r2 == true) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void zm(WinkEditorFragment this$0, androidx.core.util.Pair pair) {
        TTSAudioItem[] tTSAudioItemArr;
        String stickerId;
        boolean z16;
        TTSAudioItem[] tTSAudioItemArr2;
        String str;
        TTSAudioItem[] audioItems;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkEditorFragment", "tts model live data changed!");
        dr drVar = this$0.curTavCut;
        if (drVar != null && !(drVar instanceof WinkImageTavCut)) {
            if (this$0.Tk().getIsFromZShow() && !this$0.Tk().getIsFromQzoneText()) {
                TTSAudioInfo tTSAudioInfo = (TTSAudioInfo) pair.first;
                S s16 = pair.second;
                Intrinsics.checkNotNullExpressionValue(s16, "it.second");
                this$0.hl(tTSAudioInfo, ((Boolean) s16).booleanValue());
                return;
            }
            TTSAudioInfo tTSAudioInfo2 = (TTSAudioInfo) pair.first;
            String str2 = null;
            if (tTSAudioInfo2 != null) {
                tTSAudioItemArr = tTSAudioInfo2.getAudioItems();
            } else {
                tTSAudioItemArr = null;
            }
            if (tTSAudioItemArr != null) {
                TTSAudioInfo tTSAudioInfo3 = (TTSAudioInfo) pair.first;
                if (tTSAudioInfo3 != null && (audioItems = tTSAudioInfo3.getAudioItems()) != null) {
                    z16 = true;
                    if (audioItems.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z16 = false;
                if (!z16) {
                    TTSAudioInfo tTSAudioInfo4 = (TTSAudioInfo) pair.first;
                    if (tTSAudioInfo4 != null) {
                        tTSAudioItemArr2 = tTSAudioInfo4.getAudioItems();
                    } else {
                        tTSAudioItemArr2 = null;
                    }
                    Intrinsics.checkNotNull(tTSAudioItemArr2);
                    TTSAudioItem tTSAudioItem = tTSAudioItemArr2[0];
                    if (this$0.Tk().getIsFromQzoneText()) {
                        WinkEditorViewModel Tk = this$0.Tk();
                        dr drVar2 = this$0.curTavCut;
                        Intrinsics.checkNotNull(drVar2);
                        String m26 = Tk.m2(drVar2);
                        if (m26 != null) {
                            dr drVar3 = this$0.curTavCut;
                            Intrinsics.checkNotNull(drVar3, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                            WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) drVar3;
                            String localPath = tTSAudioItem.getLocalPath();
                            AudioInfo audioInfo = tTSAudioItem.getAudioInfo();
                            if (audioInfo != null) {
                                str2 = audioInfo.MD5;
                            }
                            winkVideoTavCut.Q0(localPath, str2, tTSAudioItem.getDuration(), m26, tTSAudioItem.getVolume(), tTSAudioItem.getStartTime());
                        }
                    } else {
                        TTSAudioInfo tTSAudioInfo5 = (TTSAudioInfo) pair.first;
                        if (tTSAudioInfo5 != null) {
                            str = tTSAudioInfo5.getStickerId();
                        } else {
                            str = null;
                        }
                        WinkStickerModel Ek = this$0.Ek(str);
                        if (Ek != null) {
                            if (tTSAudioItem != null) {
                                tTSAudioItem.setStartTime(Ek.startTime);
                            }
                            dr drVar4 = this$0.curTavCut;
                            Intrinsics.checkNotNull(drVar4, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                            WinkVideoTavCut winkVideoTavCut2 = (WinkVideoTavCut) drVar4;
                            String localPath2 = tTSAudioItem.getLocalPath();
                            AudioInfo audioInfo2 = tTSAudioItem.getAudioInfo();
                            if (audioInfo2 != null) {
                                str2 = audioInfo2.MD5;
                            }
                            winkVideoTavCut2.Q0(localPath2, str2, tTSAudioItem.getDuration(), Ek.id, tTSAudioItem.getVolume(), tTSAudioItem.getStartTime());
                            this$0.Zk().p2(((TTSAudioInfo) pair.first).getTemplateType(), ((TTSAudioInfo) pair.first).getVolume());
                        }
                    }
                    S s17 = pair.second;
                    Intrinsics.checkNotNullExpressionValue(s17, "it.second");
                    if (((Boolean) s17).booleanValue()) {
                        dr drVar5 = this$0.curTavCut;
                        Intrinsics.checkNotNull(drVar5, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                        ((WinkVideoTavCut) drVar5).seek(tTSAudioItem.getStartTime());
                    }
                    dr drVar6 = this$0.curTavCut;
                    Intrinsics.checkNotNull(drVar6, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                    ((WinkVideoTavCut) drVar6).play();
                    return;
                }
            }
            if (this$0.Tk().getIsFromQzoneText()) {
                WinkEditorViewModel Tk2 = this$0.Tk();
                dr drVar7 = this$0.curTavCut;
                Intrinsics.checkNotNull(drVar7);
                String m27 = Tk2.m2(drVar7);
                if (m27 != null) {
                    dr drVar8 = this$0.curTavCut;
                    Intrinsics.checkNotNull(drVar8, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                    ((WinkVideoTavCut) drVar8).Y0(m27);
                    return;
                }
                return;
            }
            TTSAudioInfo tTSAudioInfo6 = (TTSAudioInfo) pair.first;
            if (tTSAudioInfo6 != null && (stickerId = tTSAudioInfo6.getStickerId()) != null) {
                dr drVar9 = this$0.curTavCut;
                Intrinsics.checkNotNull(drVar9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                ((WinkVideoTavCut) drVar9).Y0(stickerId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zn() {
        long j3;
        long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_AEFTER_DETECT);
        ms.a.f("WinkEditorFragment", "performance after detect cost time : " + timeCost);
        dr drVar = this.curTavCut;
        if (drVar != null && drVar.g0() != null) {
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_POSITION, Integer.valueOf(((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel()));
            map.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_EFFICIENCY_INFO);
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_EFFICIENCY_LVTM, Long.valueOf(timeCost));
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_INPUT_INFO, wk());
            dr drVar2 = this.curTavCut;
            if (drVar2 != null) {
                j3 = drVar2.getDurationUs();
            } else {
                j3 = 0;
            }
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_LENGTH, Long.valueOf(j3 / 1000000));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("delogo : ");
            sb5.append(this.deLogo);
            sb5.append(" deface : ");
            sb5.append(this.deFace);
            sb5.append(" deblur : ");
            sb5.append(this.deBlur);
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ENHANCE_FEATURE, sb5);
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkCommonEvents(WinkDaTongReportConstant.ElementParamValue.XSJ_IMAGE_ENHANCE_AFTER_CHECK, map);
            Mk().U1(timeCost);
        }
    }

    public final int Ak(@Nullable MediaClip mediaClip) {
        SizeF sizeF;
        ResourceModel resourceModel;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            sizeF = resourceModel.size;
        } else {
            sizeF = null;
        }
        if (sizeF == null) {
            return 720;
        }
        return (int) mediaClip.resource.size.width;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    public void B3() {
        View view = this.mTopLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopLine");
            view = null;
        }
        view.setVisibility(0);
    }

    public final void Bn() {
        BorderView borderView = this.stickerBorderView;
        if (borderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView = null;
        }
        borderView.setStickerActive(false);
    }

    @NotNull
    public final QQPermission Dk() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    public final void Dn() {
        xk().Y3();
    }

    @Nullable
    public View Fi(int i3) {
        View findViewById;
        Map<Integer, View> map = this.f318541f1;
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

    @NotNull
    /* renamed from: Fk, reason: from getter */
    public final com.tencent.mobileqq.wink.editor.sticker.sticker.d getStickerUpdateListener() {
        return this.stickerUpdateListener;
    }

    public final boolean Fm() {
        final Context context = getContext();
        if (context != null) {
            ViewUtilsKt.n(context, R.string.f215675w9, 0, Integer.valueOf(R.string.f215695wa), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorFragment.Gm(WinkEditorFragment.this, context, dialogInterface, i3);
                }
            }, null, cu.k(Tk().getEditMode()), 36, null);
            return true;
        }
        return true;
    }

    public final boolean Hk() {
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        return cxVar.K().visible;
    }

    public final boolean Hm() {
        boolean z16;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && isAdded()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.tts.e Ik() {
        return Zk();
    }

    public final void In(@NotNull WinkEditDataWrapper dataWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        ms.a.f("WinkEditorFragment", "saveVideoDraft...");
        ArrayList<LocalMediaInfo> R2 = Tk().R2();
        if (R2 != null && !R2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ArrayList<LocalMediaInfo> R22 = Tk().R2();
            Intrinsics.checkNotNull(R22);
            if (R22.get(0) != null && com.tencent.mobileqq.wink.editor.draft.c.C(dataWrapper)) {
                String str = u53.b.f438374e;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                WinkEditData winkEditData = dataWrapper.getEditDatas().get(0);
                Intrinsics.checkNotNullExpressionValue(winkEditData, "dataWrapper.editDatas[0]");
                List<MediaClip> t16 = com.tencent.mobileqq.wink.editor.draft.c.t(winkEditData);
                ResourceModel resourceModel = t16.get(0).resource;
                Intrinsics.checkNotNull(resourceModel);
                File file2 = new File(resourceModel.path);
                final String str2 = str + File.separator + "output_" + Tk().getMissionId() + "_" + com.tencent.mobileqq.wink.editor.export.u.i2(file2.getName()) + ".jpg";
                android.util.Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(dataWrapper);
                float intValue = ((Number) r26.first).intValue();
                float intValue2 = ((Number) r26.second).intValue();
                ResourceModel resourceModel2 = t16.get(0).resource;
                Intrinsics.checkNotNull(resourceModel2);
                int i3 = (int) intValue;
                int i16 = (int) intValue2;
                final LocalMediaInfo localMediaInfo = com.tencent.mobileqq.wink.editor.export.u.U1(t16, resourceModel2.path, str2, Tk().getMissionId(), i3, i16, null, 0L);
                if (!FileUtils.fileExists(str2)) {
                    ms.a.f("WinkEditorFragment", "saveVideoDraft... isNeedCropVideoCover true");
                    WinkExtractCoverViewModel.p2(str2, i3, i16, this.curTavCut, dataWrapper, dataWrapper.getPreferredCoverTime(), new com.tencent.mobileqq.wink.editor.cover.a() { // from class: com.tencent.mobileqq.wink.editor.z
                        @Override // com.tencent.mobileqq.wink.editor.cover.a
                        public final void onResult(boolean z17) {
                            WinkEditorFragment.Jn(WinkEditorFragment.this, localMediaInfo, str2, z17);
                        }
                    });
                    return;
                } else {
                    ms.a.f("WinkEditorFragment", "saveVideoDraft... isNeedCropVideoCover false");
                    Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
                    Kn(localMediaInfo, str2);
                    return;
                }
            }
        }
        ms.a.f("WinkEditorFragment", "dataWrapper not valid");
    }

    @Nullable
    /* renamed from: Jk, reason: from getter */
    public final dr getCurTavCut() {
        return this.curTavCut;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public int K() {
        WinkPlayerContainerView winkPlayerContainerView = (WinkPlayerContainerView) Fi(R.id.f25760bp);
        if (winkPlayerContainerView != null) {
            return winkPlayerContainerView.getHeight();
        }
        return 0;
    }

    @Nullable
    public final o73.a Kk() {
        cx cxVar = null;
        if (cx.INSTANCE.e()) {
            cx cxVar2 = this.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar = cxVar2;
            }
            return cxVar.J();
        }
        cx cxVar3 = this.partManager;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        } else {
            cxVar = cxVar3;
        }
        return cxVar.I();
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    public void N2() {
        View view = this.mRightLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightLine");
            view = null;
        }
        view.setVisibility(0);
    }

    public final void On() {
        Tk().l5();
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void Pb(boolean isClickEvent, boolean isStickerActive) {
        WinkVideoTavCut winkVideoTavCut;
        IPlayer.PlayerStatus playerStatus;
        com.tencent.mobileqq.wink.editor.sticker.control.f.INSTANCE.e(this);
        if (!this.isInStickerEdit) {
            Nj(this.backBtn, 0);
            Nj(this.musicMenuItem, 0);
        }
        cx cxVar = this.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.t().oa(true);
        if (com.tencent.mobileqq.wink.editor.menu.v.d()) {
            if (Mm()) {
                View view = this.bottomDashboardScrollView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                    view = null;
                }
                Oj(view, 0);
            }
        } else {
            View view2 = this.bottomDashboardScrollView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                view2 = null;
            }
            Oj(view2, 0);
        }
        if (isClickEvent) {
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar3 = null;
            }
            if (cxVar3.K().visible) {
                cx cxVar4 = this.partManager;
                if (cxVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar4;
                }
                cxVar2.K().x9();
                return;
            }
            cx cxVar5 = this.partManager;
            if (cxVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar5;
            }
            cxVar2.y().Ea(false);
            return;
        }
        dr drVar = this.curTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            playerStatus = winkVideoTavCut.getStickerOperationPlayerStatus();
        } else {
            playerStatus = null;
        }
        if (playerStatus == IPlayer.PlayerStatus.PLAYING && !isStickerActive) {
            cx cxVar6 = this.partManager;
            if (cxVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar6;
            }
            cxVar2.y().Fa();
        }
    }

    public final boolean Qm() {
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        return cxVar.D().visible;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    public void R6() {
        View view = this.mBottomLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            view = null;
        }
        view.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void Sd(int pointNum) {
        cx cxVar = null;
        if (pointNum == 1) {
            Nj(this.backBtn, 4);
            Nj(this.musicMenuItem, 4);
            cx cxVar2 = this.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar2 = null;
            }
            cxVar2.t().oa(false);
            if (com.tencent.mobileqq.wink.editor.menu.v.d()) {
                if (Mm()) {
                    View view = this.bottomDashboardScrollView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                        view = null;
                    }
                    Oj(view, 4);
                } else {
                    View view2 = this.bottomDashboardScrollView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                        view2 = null;
                    }
                    Nj(view2, 4);
                }
            } else {
                View view3 = this.bottomDashboardScrollView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                    view3 = null;
                }
                Oj(view3, 4);
            }
        }
        cx cxVar3 = this.partManager;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        } else {
            cxVar = cxVar3;
        }
        cxVar.y().Ea(false);
        com.tencent.mobileqq.wink.editor.sticker.control.f.INSTANCE.e(this);
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.template.x Sk() {
        Object value = this.winkEditorTemplateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorTemplateViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.template.x) value;
    }

    public final boolean Sm() {
        dr drVar = this.curTavCut;
        Intrinsics.checkNotNull(drVar);
        if (drVar.getIsInit()) {
            dr drVar2 = this.curTavCut;
            Intrinsics.checkNotNull(drVar2);
            if (drVar2.i()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final WinkEditorViewModel Tk() {
        Object value = this.winkEditorViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditorViewModel>(...)");
        return (WinkEditorViewModel) value;
    }

    public final void Vj() {
        this.onLoadAssetHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ab
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.Wj(WinkEditorFragment.this);
            }
        });
    }

    public final void Yn(@Nullable final CharSequence msg2, final boolean cancelable, long delay, @Nullable final DialogInterface.OnDismissListener dismissListener) {
        String str;
        boolean z16 = false;
        if (msg2 != null) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.f216105xe);
            } else {
                str = null;
            }
            if (msg2.equals(str)) {
                z16 = true;
            }
        }
        f318525h1 = z16;
        this.onLoadAssetHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.y
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment.Zn(WinkEditorFragment.this, msg2, cancelable, dismissListener);
            }
        }, delay);
    }

    public void _$_clearFindViewByIdCache() {
        this.f318541f1.clear();
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void a6() {
        WinkVideoTavCut winkVideoTavCut;
        dr drVar = this.curTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.E2();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<? extends Part> assembleParts() {
        cx cxVar = new cx(isZShowTemplate(), Tk().getIsOpeningEndingEditMode(), Nm(), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$assembleParts$1
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
                WinkEditorFragment.this.el();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$assembleParts$2
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
                WinkEditorFragment.this.bl();
            }
        });
        this.partManager = cxVar;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            activity = this;
        }
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        return cxVar.c(activity);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    public void b8() {
        View view = this.mLeftLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftLine");
            view = null;
        }
        view.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    @NotNull
    public View bb() {
        View view = this.mBottomLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    @NotNull
    public View bc() {
        View view = this.mTopLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopLine");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    public void dd() {
        View view = this.mTopLine;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopLine");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.mRightLine;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightLine");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.mLeftLine;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftLine");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.mBottomLine;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLine");
        } else {
            view2 = view5;
        }
        view2.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean enableRootViewSetFitsSystemWindows() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.a
    public void g1(boolean isChildShow) {
        Tk().U1(isChildShow);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    @Nullable
    public View ga() {
        View view = this.mLeftLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftLine");
            return null;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hdf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkPlayerControlEvent.class);
        arrayList.add(StickerEditEvent.class);
        arrayList.add(WinkSaveEditDraftEvent.class);
        arrayList.add(WinkEditorOpeningEndingUpdateEvent.class);
        arrayList.add(WinkNoSaveEvent.class);
        arrayList.add(WinkExtractCoverEvent.class);
        arrayList.add(WinkShowBottomDashBoardEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorFragment";
    }

    @NotNull
    public final IPlayer.PlayerListener getPlayerListener() {
        return this.playerListener;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public int getRenderHeight() {
        Size renderSize;
        Integer num;
        dr drVar = this.curTavCut;
        if (drVar != null && (renderSize = drVar.getRenderSize()) != null && (num = renderSize.height) != null) {
            return num.intValue();
        }
        WinkPlayerContainerView winkPlayerContainerView = (WinkPlayerContainerView) Fi(R.id.f25760bp);
        if (winkPlayerContainerView != null) {
            return winkPlayerContainerView.getHeight();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public int getRenderWidth() {
        Size renderSize;
        Integer num;
        dr drVar = this.curTavCut;
        if (drVar != null && (renderSize = drVar.getRenderSize()) != null && (num = renderSize.width) != null) {
            return num.intValue();
        }
        WinkPlayerContainerView winkPlayerContainerView = (WinkPlayerContainerView) Fi(R.id.f25760bp);
        if (winkPlayerContainerView != null) {
            return winkPlayerContainerView.getWidth();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return -16777216;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void hc(@NotNull BorderView.Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Ok().f2(direction);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public int i1() {
        WinkPlayerContainerView winkPlayerContainerView = (WinkPlayerContainerView) Fi(R.id.f25760bp);
        if (winkPlayerContainerView != null) {
            return winkPlayerContainerView.getWidth();
        }
        return 0;
    }

    public final void in() {
        xk().R3();
    }

    public final void jn() {
        dr drVar = this.curTavCut;
        if (drVar != null) {
            drVar.pause();
        }
    }

    public final void jo() {
        if (uk().A2()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ViewUtilsKt.n(requireContext, R.string.f239547mr, R.string.f239557ms, Integer.valueOf(R.string.f239537mq), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorFragment.io(WinkEditorFragment.this, dialogInterface, i3);
                }
            }, null, cu.k(Tk().getEditMode()), 32, null);
            Vm("exp");
            return;
        }
        ko();
    }

    public final boolean kl(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        if (cxVar.k().qa(menuItem) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String ok() {
        cx cxVar = this.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        WinkEditorStickerControlPart A = cxVar.A();
        if (A == null) {
            return null;
        }
        return A.Xa();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intent intent;
        boolean z16;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        BusinessHandler businessHandler;
        WinkDataServiceHandler winkDataServiceHandler;
        Intrinsics.checkNotNullParameter(context, "context");
        f318528k1 = System.currentTimeMillis();
        com.tencent.mobileqq.wink.editor.performance.c cVar = com.tencent.mobileqq.wink.editor.performance.c.f321449a;
        cVar.e("method_trace_wink_editor");
        WinkEditorPefScene winkEditorPefScene = WinkEditorPefScene.FRAGMENT_ON_ATTACH;
        cVar.b(winkEditorPefScene);
        super.onAttach(context);
        com.tencent.mobileqq.wink.editor.util.g gVar = com.tencent.mobileqq.wink.editor.util.g.f322634a;
        WinkEditorViewModel Tk = Tk();
        FragmentActivity activity = getActivity();
        String str = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        gVar.b(Tk.G3(intent));
        this.isLightResourceLoadSucceed = k73.a.f411805a.c(getActivity());
        WinkEditorResourceManager.a1().N2();
        WinkEditorResourceManager.a1().k3();
        TransitionResourceManager.c().i(context);
        if (this.isLightResourceLoadSucceed) {
            com.tencent.mobileqq.wink.utils.y.f326739a.b(context);
        }
        AppInterface e16 = com.tencent.mobileqq.wink.b.e();
        if (e16 != null) {
            e16.addObserver(this);
        }
        if (this.editorDataServiceHandler == null) {
            if (e16 != null) {
                businessHandler = e16.getBusinessHandler(WinkDataServiceHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof WinkDataServiceHandler) {
                winkDataServiceHandler = (WinkDataServiceHandler) businessHandler;
            } else {
                winkDataServiceHandler = null;
            }
            this.editorDataServiceHandler = winkDataServiceHandler;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent5 = activity2.getIntent()) != null) {
            str = intent5.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        this.clientTraceId = str;
        ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).updateEnhanceConfigInSubThread();
        WinkEditorViewModel Tk2 = Tk();
        FragmentActivity activity3 = getActivity();
        boolean z17 = true;
        int i3 = 0;
        if (activity3 != null && (intent4 = activity3.getIntent()) != null && intent4.getBooleanExtra(QQWinkConstants.IS_OPENING_ENDING_EDIT_MODE, false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Tk2.g5(z16);
        WinkEditorViewModel Tk3 = Tk();
        FragmentActivity activity4 = getActivity();
        if (activity4 == null || (intent3 = activity4.getIntent()) == null || !intent3.getBooleanExtra(QQWinkConstants.IS_OPENING_ENDING_AIGC_TEMPLATE, false)) {
            z17 = false;
        }
        Tk3.Q4(z17);
        WinkEditorViewModel Tk4 = Tk();
        FragmentActivity activity5 = getActivity();
        if (activity5 != null && (intent2 = activity5.getIntent()) != null) {
            i3 = intent2.getIntExtra(QQWinkConstants.EDITOR_ENTRANCE, 0);
        }
        Tk4.f5(i3);
        cVar.c(winkEditorPefScene);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Unit unit;
        f318526i1 = false;
        if (Tk().getIsDisableOther()) {
            return true;
        }
        cx cxVar = this.partManager;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.A().bc(null);
        if (Tk().s4()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_EDITOR_CANCEL");
                WinkContext.Companion companion2 = WinkContext.INSTANCE;
                WinkPublishQualityReportData reportData = eventId.traceId(companion2.d().getTraceId()).ext1(String.valueOf(Tk().getMFrom())).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
        if (Tk().getIsOpeningEndingEditMode()) {
            return cl();
        }
        MenuSwitchAction value = Tk().f3().getValue();
        if ((value != null ? value.getMenuType() : null) == MenuType.CLIPPING) {
            cx cxVar3 = this.partManager;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar3;
            }
            return cxVar2.i().onBackEvent();
        }
        MenuSwitchAction value2 = Tk().f3().getValue();
        if ((value2 != null ? value2.getMenuType() : null) == MenuType.CROP) {
            cx cxVar4 = this.partManager;
            if (cxVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar4;
            }
            return cxVar2.j().onBackEvent();
        }
        MenuSwitchAction value3 = Tk().f3().getValue();
        if ((value3 != null ? value3.getMenuType() : null) == MenuType.MOSAIC) {
            cx cxVar5 = this.partManager;
            if (cxVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar5;
            }
            return cxVar2.o().onBackEvent();
        }
        MenuSwitchAction value4 = Tk().f3().getValue();
        if ((value4 != null ? value4.getMenuType() : null) == MenuType.AI_ELIMINATION) {
            cx cxVar6 = this.partManager;
            if (cxVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar6;
            }
            return cxVar2.f().onBackEvent();
        }
        MenuSwitchAction value5 = Tk().f3().getValue();
        if ((value5 != null ? value5.getMenuType() : null) == MenuType.SUBTITLE) {
            cx cxVar7 = this.partManager;
            if (cxVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar7;
            }
            return cxVar2.E().onBackEvent();
        }
        MenuSwitchAction value6 = Tk().f3().getValue();
        if ((value6 != null ? value6.getMenuType() : null) == MenuType.SUBTITLE_TEXT) {
            cx cxVar8 = this.partManager;
            if (cxVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar8;
            }
            return cxVar2.F().onBackEvent();
        }
        MenuSwitchAction value7 = Tk().f3().getValue();
        if ((value7 != null ? value7.getMenuType() : null) == MenuType.STICKER_TIMELINE) {
            cx cxVar9 = this.partManager;
            if (cxVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar9;
            }
            return cxVar2.D().onBackEvent();
        }
        MenuSwitchAction value8 = Tk().f3().getValue();
        if ((value8 != null ? value8.getMenuType() : null) == MenuType.LYRIC_STICKER) {
            cx cxVar10 = this.partManager;
            if (cxVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar2 = cxVar10;
            }
            WinkEditorLyricStickerMenuPart winkEditorLyricStickerMenuPart = cxVar2.getWinkEditorLyricStickerMenuPart();
            if (winkEditorLyricStickerMenuPart == null || !winkEditorLyricStickerMenuPart.onBackEvent()) {
                return false;
            }
        } else {
            MenuSwitchAction value9 = Tk().f3().getValue();
            if ((value9 != null ? value9.getMenuType() : null) == MenuType.MUSIC_VOLUME) {
                cx cxVar11 = this.partManager;
                if (cxVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar11;
                }
                return cxVar2.N().onBackEvent();
            }
            MenuSwitchAction value10 = Tk().f3().getValue();
            if ((value10 != null ? value10.getMenuType() : null) == MenuType.EFFECT) {
                cx cxVar12 = this.partManager;
                if (cxVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar12;
                }
                return cxVar2.l().onBackEvent();
            }
            MenuSwitchAction value11 = Tk().f3().getValue();
            if ((value11 != null ? value11.getMenuType() : null) == MenuType.TEMPLATE_TEXT_LIST) {
                cx cxVar13 = this.partManager;
                if (cxVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar13;
                }
                return cxVar2.H().onBackEvent();
            }
            MenuSwitchAction value12 = Tk().f3().getValue();
            if ((value12 != null ? value12.getMenuType() : null) == MenuType.OPENING_ENDING) {
                cx cxVar14 = this.partManager;
                if (cxVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar14;
                }
                return cxVar2.w().onBackEvent();
            }
            MenuSwitchAction value13 = Tk().f3().getValue();
            if ((value13 != null ? value13.getMenuType() : null) == MenuType.STICKER) {
                cx cxVar15 = this.partManager;
                if (cxVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar15;
                }
                return cxVar2.B().onBackEvent();
            }
            MenuSwitchAction value14 = Tk().f3().getValue();
            if ((value14 != null ? value14.getMenuType() : null) == MenuType.STICKER_OLD) {
                cx cxVar16 = this.partManager;
                if (cxVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar16;
                }
                return cxVar2.C().onBackEvent();
            }
            MenuSwitchAction value15 = Tk().f3().getValue();
            if ((value15 != null ? value15.getMenuType() : null) == MenuType.MUSIC) {
                cx cxVar17 = this.partManager;
                if (cxVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar17;
                }
                c73.a s16 = cxVar2.s();
                if (s16 != null) {
                    return s16.onBackEvent();
                }
                return false;
            }
            MenuSwitchAction value16 = Tk().f3().getValue();
            if ((value16 != null ? value16.getMenuType() : null) == MenuType.AI_TEMPLATE) {
                cx cxVar18 = this.partManager;
                if (cxVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar18;
                }
                return cxVar2.g().onBackEvent();
            }
            if (Tk().b4()) {
                Sn();
            } else {
                dr drVar = this.curTavCut;
                if (drVar != null && drVar.l0()) {
                    if (!Tk().Z3() && !Tk().g4()) {
                        if (Tk().c4()) {
                            eo();
                        } else {
                            Fm();
                        }
                    } else {
                        Pn();
                    }
                } else {
                    un(this, false, 1, null);
                    Tk().D4(getContext());
                    return super.onBackEvent();
                }
            }
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Tk().C4(newConfig);
        ro();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_VIDEO_LOAD_FIRST_FRAME);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_VIDEO_LOAD_FAKE_FIRST_FRAME);
        com.tencent.mobileqq.wink.editor.performance.c cVar = com.tencent.mobileqq.wink.editor.performance.c.f321449a;
        WinkEditorPefScene winkEditorPefScene = WinkEditorPefScene.FRAGMENT_ON_CREATE;
        cVar.b(winkEditorPefScene);
        super.onCreate(savedInstanceState);
        cVar.c(winkEditorPefScene);
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

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Job job = this.preloadDataJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        jn();
        tn(true);
        com.tencent.videocut.render.utils.b.f384205a.a();
        l73.a.f413927a.a();
        FirstFramePreLoader.q();
        WinkHDRCacheManager.INSTANCE.a().i();
        f318529l1 = false;
        w53.b.f("WinkEditorFragment", "onDestroy.");
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WinkAdaptiveImageView winkAdaptiveImageView = this.ivPreloadFrame;
        BorderView borderView = null;
        if (winkAdaptiveImageView != null) {
            winkAdaptiveImageView.setImageBitmap(null);
        }
        this.onLoadAssetHandler.removeCallbacksAndMessages(null);
        WaterMarkDataManager.f321551a.h();
        ms.a.f("WinkEditorFragment", "tavcut release start ");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        BorderView borderView2 = this.stickerBorderView;
        if (borderView2 != null) {
            if (borderView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            } else {
                borderView = borderView2;
            }
            borderView.G();
        }
        dr drVar = this.videoTavCut;
        if (drVar != null) {
            drVar.release();
        }
        dr drVar2 = this.imageTavCut;
        if (drVar2 != null) {
            drVar2.release();
        }
        if (!Tk().getIsOpeningEndingEditMode()) {
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.e();
        }
        com.tencent.mobileqq.wink.b.a().removeObserver(this);
        WinkEditorLbsUtil.f322604d.j();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        onHiddenChangedReport(hidden);
        Wm(hidden);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
        hn();
        un(this, false, 1, null);
        ApngImage.pauseAll();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        byte b16;
        boolean z16 = false;
        BorderView borderView = null;
        cx cxVar = null;
        cx cxVar2 = null;
        cx cxVar3 = null;
        cx cxVar4 = null;
        BorderView borderView2 = null;
        if (simpleBaseEvent instanceof WinkPlayerControlEvent) {
            w53.b.c("WinkEditorFragment", "receive WinkPlayerControlEvent: release cutsession ");
            int i3 = ((WinkPlayerControlEvent) simpleBaseEvent).mEventType;
            if (i3 != 3) {
                if (i3 == 4) {
                    cx cxVar5 = this.partManager;
                    if (cxVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        cxVar5 = null;
                    }
                    cxVar5.t().Q9(null);
                    View view = this.bottomDashboardScrollView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                        view = null;
                    }
                    view.setVisibility(0);
                    if (Tk().a2()) {
                        cx cxVar6 = this.partManager;
                        if (cxVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partManager");
                            cxVar6 = null;
                        }
                        if (cxVar6.n().visible) {
                            cx cxVar7 = this.partManager;
                            if (cxVar7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                            } else {
                                cxVar = cxVar7;
                            }
                            cxVar.n().jb(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            cx cxVar8 = this.partManager;
            if (cxVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar8 = null;
            }
            cxVar8.t().x9();
            View view2 = this.bottomDashboardScrollView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomDashboardScrollView");
                view2 = null;
            }
            view2.setVisibility(8);
            if (Tk().a2()) {
                cx cxVar9 = this.partManager;
                if (cxVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partManager");
                } else {
                    cxVar2 = cxVar9;
                }
                cxVar2.n().jb(false);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof StickerEditEvent) {
            StickerEditEvent stickerEditEvent = (StickerEditEvent) simpleBaseEvent;
            w53.b.c("WinkEditorFragment", "receive StickerEditEvent: " + stickerEditEvent.mEventType);
            switch (stickerEditEvent.mEventType) {
                case 1:
                case 11:
                case 13:
                case 16:
                case 18:
                    this.isInStickerEdit = true;
                    if (this.stickerBorderView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                    }
                    BorderView borderView3 = this.stickerBorderView;
                    if (borderView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                    } else {
                        borderView = borderView3;
                    }
                    borderView.f();
                    return;
                case 2:
                case 12:
                case 14:
                case 17:
                case 19:
                    this.isInStickerEdit = false;
                    if (this.stickerBorderView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                    }
                    BorderView borderView4 = this.stickerBorderView;
                    if (borderView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
                    } else {
                        borderView2 = borderView4;
                    }
                    borderView2.d();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 10:
                case 15:
                default:
                    return;
                case 8:
                    cx cxVar10 = this.partManager;
                    if (cxVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    } else {
                        cxVar4 = cxVar10;
                    }
                    m73.b y16 = cxVar4.y();
                    if (y16 != null) {
                        y16.za();
                        return;
                    }
                    return;
                case 9:
                    cx cxVar11 = this.partManager;
                    if (cxVar11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                    } else {
                        cxVar3 = cxVar11;
                    }
                    m73.b y17 = cxVar3.y();
                    if (y17 != null) {
                        y17.Ga();
                        return;
                    }
                    return;
            }
        }
        if (simpleBaseEvent instanceof WinkSaveEditDraftEvent) {
            w53.b.a("WinkEditorFragment", "receive WinkSaveEditDraftEvent: ");
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bh
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.dn(WinkEditorFragment.this);
                }
            });
            return;
        }
        if (simpleBaseEvent instanceof WinkEditorOpeningEndingUpdateEvent) {
            FragmentActivity activity = getActivity();
            if (activity != null && activity.isFinishing()) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && activity2.isDestroyed()) {
                    z16 = true;
                }
                if (!z16) {
                    Pk().F2(true);
                    WinkEditorOpeningEndingUpdateEvent winkEditorOpeningEndingUpdateEvent = (WinkEditorOpeningEndingUpdateEvent) simpleBaseEvent;
                    Pk().N2(winkEditorOpeningEndingUpdateEvent.getVideoFilePath(), winkEditorOpeningEndingUpdateEvent.getIsOpeningClip(), winkEditorOpeningEndingUpdateEvent.getIsFromClipping(), winkEditorOpeningEndingUpdateEvent.getTemplateId(), winkEditorOpeningEndingUpdateEvent.getMissionId(), winkEditorOpeningEndingUpdateEvent.getAigcData());
                    return;
                }
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof WinkNoSaveEvent) {
            Tk().O4();
            return;
        }
        if (simpleBaseEvent instanceof WinkExtractCoverEvent) {
            if (this.extractResult.size() == 0) {
                this.extractResult = ((WinkExtractCoverEvent) simpleBaseEvent).getResult();
                SimpleEventBus.getInstance().dispatchEvent(new WinkExtractCoverReceiverEvent());
                w53.b.f("WinkEditorFragment", "onReceiveEvent WinkExtractCoverEvent " + this.extractResult.size());
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof WinkShowBottomDashBoardEvent) {
            Tk().l5();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Dk().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.tencent.mobileqq.wink.editor.performance.c cVar = com.tencent.mobileqq.wink.editor.performance.c.f321449a;
        WinkEditorPefScene winkEditorPefScene = WinkEditorPefScene.FRAGMENT_ON_RESUME;
        cVar.b(winkEditorPefScene);
        super.onResume();
        cx cxVar = this.partManager;
        Intent intent = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.A().bc(null);
        onResumeReport();
        Cn();
        nn();
        ApngImage.resumeAll();
        w53.a.e(4);
        dr drVar = this.curTavCut;
        if (drVar != null) {
            drVar.Z();
        }
        this.jumpToPublished = false;
        cVar.c(winkEditorPefScene);
        cVar.c(WinkEditorPefScene.FRAGMENT_LAUNCH);
        cVar.f();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        }
        t53.a.b(intent, t53.a.f435443a.d(), new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$onResume$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1004);
                dc5507Report.j(1);
            }
        });
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        String str = null;
        ln(this, null, false, 3, null);
        outState.putString(QQWinkConstants.MISSION_ID, Tk().getMissionId());
        outState.putBoolean("key_wink_is_load_from_draft", Tk().getIsLoadFromDraft());
        MenuType curMenuType = Tk().getCurMenuType();
        if (curMenuType == MenuType.TEMPLATE_COLL_CLIP || curMenuType == MenuType.CLIPPING || curMenuType == MenuType.CROP) {
            outState.putString("currentMenuType", curMenuType.name());
        }
        WinkEditorViewModel Tk = Tk();
        if (curMenuType != null) {
            str = curMenuType.name();
        }
        w53.b.c("WinkEditorViewModel", "onSaveInstanceState missionId:" + Tk + ".missionId, currentMenuType:" + str);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.tencent.mobileqq.wink.editor.performance.c.f321449a.d();
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (1 == type) {
            WinkEditorResourceManager.a1().v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intent intent;
        View findViewById;
        Long l3;
        String str;
        String str2;
        Intent intent2;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.wink.editor.performance.c.f321449a.b(WinkEditorPefScene.FRAGMENT_AFTER_PART_CREATE);
        super.onViewCreatedAfterPartInit(view, savedInstanceState);
        if (!this.isLightResourceLoadSucceed) {
            k73.a.f411805a.b(getActivity());
            return;
        }
        WinkContext.Companion companion = WinkContext.INSTANCE;
        String str3 = "QCIRCLE";
        if (Intrinsics.areEqual(companion.d().k().a(), "QCIRCLE")) {
            ((IQQWinkABTestReportAPI) QRoute.api(IQQWinkABTestReportAPI.class)).reportWinkEditorExperiment();
        }
        this.schemaAttrsMap = com.tencent.mobileqq.wink.schema.d.f326305a.d(getActivity());
        if (getChildFragmentManager().findFragmentByTag("ActivityResultFragment") == null) {
            getChildFragmentManager().beginTransaction().add(new ActivityResultFragment(), "ActivityResultFragment").commitNowAllowingStateLoss();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.ckj)) != null) {
            frameLayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.bd5));
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        WinkEditorViewModel Tk = Tk();
        FragmentActivity activity2 = getActivity();
        Unit unit = null;
        r4 = null;
        Bundle bundle = null;
        if (activity2 != null) {
            intent = activity2.getIntent();
        } else {
            intent = null;
        }
        Tk.F3(intent, savedInstanceState);
        Wk().initTemplateObserver(Tk().u4());
        if (Tk().u4()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorFragment$onViewCreatedAfterPartInit$1(this, null), 3, null);
        }
        if (Tk().getMDraftFrom() == 7) {
            DailySignConfig dailySignConfig = new DailySignConfig(new com.tencent.mobileqq.wink.dailysign.af(null, null, companion.d().getMissionId()));
            Bundle bundle2 = new Bundle();
            FragmentActivity activity3 = getActivity();
            if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
                bundle = intent2.getExtras();
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            dailySignConfig.setFrom("QZONE");
            bundle2.putSerializable(QQWinkConstants.EDITOR_TEXT_TEMPLATE_CONFIG, dailySignConfig);
            com.tencent.mobileqq.wink.f.m(requireContext(), bundle2);
            pn();
            return;
        }
        Mk().e2(Tk().getIsFromMagicStudio());
        WinkEditPerformanceViewModel Mk = Mk();
        String str4 = Tk().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
        if (str4 != null) {
            str3 = str4;
        }
        Mk.d2(str3);
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            ViewModel viewModel = new ViewModelProvider(activity4).get(MusicSourceViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026rceViewModel::class.java)");
            MusicSourceViewModel musicSourceViewModel = (MusicSourceViewModel) viewModel;
            ViewModel viewModel2 = new ViewModelProvider(activity4).get(MusicVolumeControlViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(activi\u2026rolViewModel::class.java)");
            MusicVolumeControlViewModel musicVolumeControlViewModel = (MusicVolumeControlViewModel) viewModel2;
            if (Tk().getOriginEditData() != null) {
                WinkEditDataWrapper originEditData = Tk().getOriginEditData();
                if (originEditData != null) {
                    l3 = originEditData.getMusicId();
                } else {
                    l3 = null;
                }
                WinkEditDataWrapper originEditData2 = Tk().getOriginEditData();
                if (originEditData2 != null) {
                    str = originEditData2.getMusicName();
                } else {
                    str = null;
                }
                WinkEditDataWrapper originEditData3 = Tk().getOriginEditData();
                if (originEditData3 != null) {
                    str2 = originEditData3.getSelectMusicMid();
                } else {
                    str2 = null;
                }
                musicSourceViewModel.n4(new DraftMusic(l3, str, str2));
                WinkEditDataWrapper originEditData4 = Tk().getOriginEditData();
                if (originEditData4 != null) {
                    musicVolumeControlViewModel.C2(new com.tencent.mobileqq.wink.editor.music.viewmodel.c(originEditData4.getBgmVolumeType(), originEditData4.getBgmVolume(), originEditData4.getOriginVolume()));
                }
            }
        }
        hm(view);
        xm(view);
        xl();
        wm();
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.t9b);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            View findViewById2 = inflate.findViewById(R.id.f99555q4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "inflatedView.findViewById(R.id.topLine)");
            this.mTopLine = findViewById2;
            View findViewById3 = inflate.findViewById(R.id.f74403w6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "inflatedView.findViewById(R.id.rightLine)");
            this.mRightLine = findViewById3;
            View findViewById4 = inflate.findViewById(R.id.ygq);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "inflatedView.findViewById(R.id.leftLine)");
            this.mLeftLine = findViewById4;
            View findViewById5 = inflate.findViewById(R.id.t9s);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "inflatedView.findViewById(R.id.bottomLine)");
            this.mBottomLine = findViewById5;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        boolean z16 = false;
        rd4.c.t(context, "", "lightsdk_qq", WinkContext.Companion.j(companion, false, 1, null));
        w53.a.e(4);
        rd4.b.f431129b.b(false);
        PlayerDefaultConfigs.enableVideoSyncOpt = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103203", false);
        if (com.tencent.mobileqq.wink.editor.menu.v.d()) {
            findViewById = view.findViewById(R.id.t9p);
            Intrinsics.checkNotNullExpressionValue(findViewById, "{\n            view.findV\u2026enuScrollView2)\n        }");
        } else {
            findViewById = view.findViewById(R.id.t9o);
            Intrinsics.checkNotNullExpressionValue(findViewById, "{\n            view.findV\u2026MenuScrollView)\n        }");
        }
        this.bottomDashboardScrollView = findViewById;
        qn();
        ArrayList<LocalMediaInfo> R2 = Tk().R2();
        double d16 = 0.0d;
        if (R2 != null) {
            while (R2.iterator().hasNext()) {
                d16 += ((LocalMediaInfo) r13.next()).mDuration;
            }
        }
        ms.a.f("WinkEditorFragment", "sourceDuration=" + d16);
        Tk().n5(((long) d16) * 1000);
        Pair<Integer, Integer> g16 = com.tencent.mobileqq.wink.editor.util.m.f322645a.g(getContext());
        on(g16.component1().intValue(), g16.component2().intValue());
        vl(view);
        View findViewById6 = view.findViewById(R.id.t9k);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.bottomDashboardMenu)");
        this.menuBar = (LinearLayout) findViewById6;
        Sl(view);
        View findViewById7 = view.findViewById(R.id.f84974np);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.showMessageTips)");
        TextView textView = (TextView) findViewById7;
        this.showHDRTips = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
            textView = null;
        }
        textView.setVisibility(8);
        this.isShowHDRTips = false;
        View findViewById8 = view.findViewById(R.id.x7m);
        HDRStatusView hDRStatusView = (HDRStatusView) findViewById8;
        hDRStatusView.setWinkHDRStopListerner(new com.tencent.mobileqq.wink.editor.hdr.l() { // from class: com.tencent.mobileqq.wink.editor.bs
            @Override // com.tencent.mobileqq.wink.editor.hdr.l
            public final void a() {
                WinkEditorFragment.en(WinkEditorFragment.this);
            }
        });
        hDRStatusView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.bt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkEditorFragment.fn(WinkEditorFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById<HDRSta\u2026)\n            }\n        }");
        this.hdrStatusView = hDRStatusView;
        Ol();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorFragment$onViewCreatedAfterPartInit$4(this, null), 3, null);
        im();
        if (!Tk().getIsFromTemplateColl()) {
            com.tencent.mobileqq.wink.editor.hdr.q.P1(Vk(), this, false, false, 6, null);
        }
        if (Tk().s4()) {
            try {
                Result.Companion companion2 = Result.INSTANCE;
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_EDITOR_REDAY");
                WinkContext.Companion companion3 = WinkContext.INSTANCE;
                WinkPublishQualityReportData.Builder ext1 = eventId.traceId(companion3.d().getTraceId()).ext1(String.valueOf(Tk().getMFrom()));
                if (!Tk().getIsFromCapture() && MusicOptimizeManager.f321154a.d()) {
                    z16 = true;
                }
                WinkPublishQualityReportData reportData = ext1.ext2(String.valueOf(z16)).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion3.d().k().b());
                    unit = Unit.INSTANCE;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
        yl(view);
        ((IAEEditorProcess) QRoute.api(IAEEditorProcess.class)).preloadQQSysEmojiApng();
        com.tencent.mobileqq.wink.editor.performance.c.f321449a.c(WinkEditorPefScene.FRAGMENT_AFTER_PART_CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreatedBeforePartInit(view, savedInstanceState);
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), ContextCompat.getColor(requireActivity(), R.color.bd5));
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        String str;
        boolean z16;
        MenuType valueOf;
        super.onViewStateRestored(savedInstanceState);
        cx cxVar = null;
        if (savedInstanceState != null) {
            str = savedInstanceState.getString("currentMenuType");
        } else {
            str = null;
        }
        w53.b.a("WinkEditorFragment", "onViewStateRestored currentMenuType:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (valueOf = MenuType.valueOf(str)) != null) {
            if (valueOf == MenuType.TEMPLATE_COLL_CLIP) {
                WinkEditorViewModel.v5(Tk(), valueOf, null, 2, null);
            } else {
                Tk().T4(valueOf);
            }
        }
        if (savedInstanceState != null) {
            cx cxVar2 = this.partManager;
            if (cxVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
            } else {
                cxVar = cxVar2;
            }
            Iterator<T> it = cxVar.x().iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.wink.editor.d) it.next()).K9();
            }
        }
    }

    @Nullable
    /* renamed from: rk, reason: from getter */
    public final WinkAdaptiveImageView getIvPreloadFrame() {
        return this.ivPreloadFrame;
    }

    /* renamed from: sk, reason: from getter */
    public final long getMDelayForSaveMedialModel() {
        return this.mDelayForSaveMedialModel;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.music.lyric.sticker.z tk() {
        Object value = this.mWinkEditorLyricStickerViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkEditorLyricStickerViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.music.lyric.sticker.z) value;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void va() {
        WinkVideoTavCut winkVideoTavCut;
        dr drVar = this.curTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.E2();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
    @Nullable
    public View w7() {
        View view = this.mRightLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightLine");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
    public void xg(boolean isClickEvent, float positionY) {
        int i3;
        int i16;
        int[] iArr = new int[2];
        View view = this.musicMenuItem;
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        if (isClickEvent) {
            if (Tk().getIsEnableMusic()) {
                int i17 = iArr[1];
                View view2 = this.musicMenuItem;
                if (view2 != null) {
                    i16 = view2.getHeight();
                } else {
                    i16 = 0;
                }
                if (positionY < i17 + i16) {
                    return;
                }
            }
            MenuType curMenuType = Tk().getCurMenuType();
            if (curMenuType == null) {
                i3 = -1;
            } else {
                i3 = c.f318562a[curMenuType.ordinal()];
            }
            switch (i3) {
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    cx cxVar = this.partManager;
                    HDRStatusView hDRStatusView = null;
                    if (cxVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        cxVar = null;
                    }
                    cxVar.y().wa();
                    HDRStatusView hDRStatusView2 = this.hdrStatusView;
                    if (hDRStatusView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
                        hDRStatusView2 = null;
                    }
                    if (hDRStatusView2.getVisibility() == 0) {
                        HDRStatusView hDRStatusView3 = this.hdrStatusView;
                        if (hDRStatusView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
                        } else {
                            hDRStatusView = hDRStatusView3;
                        }
                        hDRStatusView.j();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @NotNull
    public final MusicSourceViewModel xk() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    public final int zk(@Nullable MediaClip mediaClip) {
        SizeF sizeF;
        ResourceModel resourceModel;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            sizeF = resourceModel.size;
        } else {
            sizeF = null;
        }
        if (sizeF == null) {
            return 720;
        }
        return (int) mediaClip.resource.size.height;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$d", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ICutStatusCallback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorFragment this$0, d this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            SimpleEventBus.getInstance().dispatchEvent(new ReceiveSchemaEvent(this$0.schemaAttrsMap));
            dr drVar = this$0.imageTavCut;
            if (drVar != null) {
                drVar.d(this$1);
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            Handler mainHandler = WinkEditorFragment.this.getMainHandler();
            final WinkEditorFragment winkEditorFragment = WinkEditorFragment.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bv
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.d.b(WinkEditorFragment.this, this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$e", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ISessionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<LAKRenderModel, Long, Long, Unit> f318564a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorFragment f318565b;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function3<? super LAKRenderModel, ? super Long, ? super Long, Unit> function3, WinkEditorFragment winkEditorFragment) {
            this.f318564a = function3;
            this.f318565b = winkEditorFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Function3 action, LAKRenderModel newData, long j3, long j16, WinkEditorFragment this$0, e this$1) {
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            action.invoke(newData, Long.valueOf(j3), Long.valueOf(j16));
            dr curTavCut = this$0.getCurTavCut();
            if (curTavCut != null) {
                curTavCut.Q(this$1);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, final long duration, final long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function3<LAKRenderModel, Long, Long, Unit> function3 = this.f318564a;
            final WinkEditorFragment winkEditorFragment = this.f318565b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bw
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.e.b(Function3.this, newData, duration, mediaDuration, winkEditorFragment, this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$h", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkVideoTavCut f318572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.FloatRef f318573b;

        h(WinkVideoTavCut winkVideoTavCut, Ref.FloatRef floatRef) {
            this.f318572a = winkVideoTavCut;
            this.f318573b = floatRef;
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            this.f318572a.d(this);
            WinkVideoTavCut.H3(this.f318572a, this.f318573b.element, null, 2, null);
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$l", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "", "a", "Z", "isMusicLoaded", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class l implements ISessionListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isMusicLoaded;

        l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(l this$0, WinkEditorFragment this$1, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!this$0.isMusicLoaded) {
                this$1.oo(j3);
                this$0.isMusicLoaded = true;
                return;
            }
            cx cxVar = this$1.partManager;
            if (cxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("partManager");
                cxVar = null;
            }
            cxVar.y().Ja(j3);
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel newData, long duration, final long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            WinkEditorFragment.this.Tk().z5(duration);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorFragment winkEditorFragment = WinkEditorFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ci
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.l.b(WinkEditorFragment.l.this, winkEditorFragment, mediaDuration);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$q", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class q implements ICutStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkVideoTavCut f318585a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorFragment$updateSubtitle$1$runnable$1 f318586b;

        q(WinkVideoTavCut winkVideoTavCut, WinkEditorFragment$updateSubtitle$1$runnable$1 winkEditorFragment$updateSubtitle$1$runnable$1) {
            this.f318585a = winkVideoTavCut;
            this.f318586b = winkEditorFragment$updateSubtitle$1$runnable$1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorFragment$updateSubtitle$1$runnable$1 runnable) {
            Intrinsics.checkNotNullParameter(runnable, "$runnable");
            runnable.run();
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
            this.f318585a.d(this);
            final WinkEditorFragment$updateSubtitle$1$runnable$1 winkEditorFragment$updateSubtitle$1$runnable$1 = this.f318586b;
            UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.co
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment.q.b(WinkEditorFragment$updateSubtitle$1$runnable$1.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vn() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$g", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "p0", "", "onAnimationCancel", "onAnimationRepeat", "animation", "onAnimationEnd", "", "isReverse", "onAnimationStart", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends com.tencent.mobileqq.widget.f {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
            WinkEditorFragment.this.isShowHDRTips = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TextView textView = WinkEditorFragment.this.showHDRTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
                textView = null;
            }
            textView.setVisibility(8);
            WinkEditorFragment.this.isShowHDRTips = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            TextView textView = WinkEditorFragment.this.showHDRTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
                textView = null;
            }
            textView.setVisibility(0);
            WinkEditorFragment.this.isShowHDRTips = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ml(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nl(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cn(DialogInterface dialogInterface) {
    }

    private final void yl(View view) {
    }
}
