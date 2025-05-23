package com.tencent.mobileqq.wink.editor.sticker.control;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.gyailib.library.GYTrackStickerInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.TrackStickerInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart;
import com.tencent.mobileqq.wink.editor.sticker.selector.adapter.WinkStickerTimeDateType;
import com.tencent.mobileqq.wink.editor.sticker.text.bb;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListViewModel;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil;
import com.tencent.mobileqq.wink.editor.view.BorderView;
import com.tencent.mobileqq.wink.editor.view.WinkAdaptiveImageView;
import com.tencent.mobileqq.wink.event.ImagePageTouchEvent;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.event.WinkPlayerControlEvent;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import com.tencent.mobileqq.wink.view.selector.WinkActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.IStickerUpdateCallback;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.model.WatermarkDateModel;
import com.tencent.videocut.model.WatermarkPoiModelWrapper;
import com.tenpay.sdk.util.UinConfigManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.Entity;

@Metadata(d1 = {"\u0000\u0088\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00d4\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002\u00d5\u0002B\t\u00a2\u0006\u0006\b\u00d2\u0002\u0010\u00d3\u0002J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J\n\u0010)\u001a\u0004\u0018\u00010(H\u0002JH\u00102\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010\bj\n\u0012\u0004\u0012\u00020,\u0018\u0001`\t2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J8\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u00010\bj\n\u0012\u0004\u0012\u000203\u0018\u0001`\t2\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010\bj\n\u0012\u0004\u0012\u00020,\u0018\u0001`\tH\u0002J\u0012\u00105\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010:\u001a\u00020\u000b2\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020!H\u0002J\b\u0010=\u001a\u00020\u000bH\u0002J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u001eH\u0002J\"\u0010A\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000eH\u0002J\u001a\u0010B\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u001eH\u0002J\b\u0010F\u001a\u00020\u000bH\u0002J\u0012\u0010G\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010H\u001a\u00020\u000bH\u0002J\u0012\u0010I\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010K\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0JH\u0002J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0JH\u0002J\b\u0010M\u001a\u00020\u000bH\u0002J\b\u0010N\u001a\u00020\u000bH\u0002J\u0018\u0010P\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u000bH\u0002J\u0010\u0010S\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020.H\u0002J\u0012\u0010V\u001a\u00020\u000e2\b\u0010U\u001a\u0004\u0018\u00010TH\u0002J\b\u0010W\u001a\u00020\u000bH\u0002J \u0010[\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u000eH\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010\\\u001a\u00020.H\u0002J \u0010a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010_\u001a\u00020.2\u0006\u0010`\u001a\u00020.H\u0002J \u0010b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010_\u001a\u00020.2\u0006\u0010`\u001a\u00020.H\u0002J\u0010\u0010c\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010e\u001a\u00020\u0005H\u0016J\b\u0010f\u001a\u00020\u000bH\u0016J\u0012\u0010i\u001a\u00020\u000b2\b\u0010h\u001a\u0004\u0018\u00010gH\u0014J\b\u0010j\u001a\u00020\u000bH\u0014J\u0006\u0010k\u001a\u00020\u000eJ\u0010\u0010m\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u0014H\u0014J\u0010\u0010n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010o\u001a\u00020\u000bJ\u0018\u0010q\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*2\b\u0010p\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010r\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010s\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010u\u001a\u00020\u000b2\b\u0010t\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010v\u001a\u0004\u0018\u00010\u001eJ$\u0010x\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w0\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w`\tH\u0016J\u001a\u0010|\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020y2\b\u0010{\u001a\u0004\u0018\u00010gH\u0016J\u0010\u0010}\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020yH\u0016J$\u0010\u0081\u0001\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u007f\u001a\u0004\u0018\u00010~2\u0007\u0010\u0080\u0001\u001a\u00020\u000eH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0013\u0010\u0083\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0013\u0010\u0084\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0013\u0010\u0085\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0013\u0010\u0087\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\t\u0010\u008a\u0001\u001a\u00020\u000bH\u0016J\u0010\u0010\u008c\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0001\u001a\u00020\u000eJ\u000f\u0010\u008d\u0001\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000eJ3\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001e2\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\b\u0010\u0090\u0001\u001a\u00030\u008e\u00012\b\u0010\u0091\u0001\u001a\u00030\u008e\u00012\b\u0010\u0092\u0001\u001a\u00030\u008e\u0001H\u0016J\u001d\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u0094\u0001\u001a\u00020~2\u0007\u0010\u0095\u0001\u001a\u00020~H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010\u009a\u0001\u001a\u00030\u0097\u0001H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u009c\u0001\u001a\u00020\u000eH\u0016J\u001f\u0010\u009f\u0001\u001a\u00020\u000b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010.2\t\u0010h\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J\u0013\u0010\u00a0\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0011\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0013\u0010\u00a2\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0013\u0010\u00a3\u0001\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u000f\u0010\u00a4\u0001\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020.J \u0010\u00a6\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010_\u001a\u00020.2\u0007\u0010\u00a5\u0001\u001a\u00020\u000eJ \u0010\u00a8\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010_\u001a\u00020.2\u0007\u0010\u00a7\u0001\u001a\u00020.J\t\u0010\u00a9\u0001\u001a\u0004\u0018\u00010.R\u001a\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R,\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00af\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001c\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u0019\u0010\u00bc\u0001\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001b\u0010\u00bf\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001a\u0010\u00c3\u0001\u001a\u00030\u00c0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u001a\u0010\u00c5\u0001\u001a\u00030\u00c0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c2\u0001R\u001a\u0010\u00c7\u0001\u001a\u00030\u00c0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c2\u0001R\u001a\u0010\u00cb\u0001\u001a\u00030\u00c8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u001a\u0010\u00cf\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u001a\u0010\u00d1\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00ce\u0001R\u001a\u0010\u00d3\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00ce\u0001R\u001a\u0010\u00d5\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u00ce\u0001R\u001a\u0010\u00d7\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00ce\u0001R\u001a\u0010\u00d9\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d8\u0001\u0010\u00ce\u0001R\u001a\u0010\u00db\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00ce\u0001R\u001a\u0010\u00dc\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u00ce\u0001R\u001a\u0010\u00de\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00dd\u0001\u0010\u00ce\u0001R\u001a\u0010\u00e0\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00ce\u0001R\u001a\u0010\u00e2\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00ce\u0001R\u001a\u0010\u00e4\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00ce\u0001R+\u0010\u00e7\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00cc\u00010\bj\t\u0012\u0005\u0012\u00030\u00cc\u0001`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00e6\u0001R+\u0010\u00ee\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001\"\u0006\b\u00ec\u0001\u0010\u00ed\u0001R\u001c\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00b0\u0001R\u001c\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00f1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f2\u0001\u0010\u00f3\u0001R\u001c\u0010\u00f8\u0001\u001a\u0005\u0018\u00010\u00f5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f6\u0001\u0010\u00f7\u0001R\u001c\u0010\u00fc\u0001\u001a\u0005\u0018\u00010\u00f9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fa\u0001\u0010\u00fb\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u00fd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fe\u0001\u0010\u00ff\u0001R\u001b\u0010\u0083\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001a\u0010\u008a\u0002\u001a\u00030\u0087\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0088\u0002\u0010\u0089\u0002R)\u0010\u0090\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008b\u0002\u0010\u00e5\u0001\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\"\u0006\b\u008e\u0002\u0010\u008f\u0002R'\u0010\u0092\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0002\u0010\u00e6\u0001R'\u0010\u0094\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0002\u0010\u00e6\u0001R\u001c\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001b\u0010\u009b\u0002\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R;\u0010\u00a0\u0002\u001a$\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.0\u009c\u0002j\u0011\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.`\u009d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001b\u0010\u00a2\u0002\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0002\u0010\u00bb\u0001R\u001c\u0010\u00a6\u0002\u001a\u0005\u0018\u00010\u00a3\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0002\u0010\u00a5\u0002R\u0017\u0010\u00a8\u0002\u001a\u00020!8\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u00a7\u0002\u0010\u00c4\u0001R\u0019\u0010\u00aa\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0002\u0010\u00e5\u0001R\u001a\u0010\u00ad\u0002\u001a\u00030\u00ab\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0002\u0010\u00ab\u0001R\u001a\u0010\u00af\u0002\u001a\u00030\u00ab\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0002\u0010\u00ab\u0001R\u001a\u0010\u00b1\u0002\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0002\u0010\u00b7\u0001R\u001a\u0010\u00b3\u0002\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0002\u0010\u00b7\u0001R;\u0010\u00b5\u0002\u001a$\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010,0\u009c\u0002j\u0011\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010,`\u009d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0002\u0010\u009f\u0002R;\u0010\u00b7\u0002\u001a$\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010,0\u009c\u0002j\u0011\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010,`\u009d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0002\u0010\u009f\u0002R\u0019\u0010\u00b9\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0002\u0010\u00e5\u0001R\u0019\u0010\u00bb\u0002\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0002\u0010\u00c4\u0001R\u001a\u0010\u00bf\u0002\u001a\u00030\u00bc\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0002\u0010\u00be\u0002R\u0019\u0010\u00c1\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0002\u0010\u00e5\u0001R\u0018\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c2\u0002\u0010\u00e5\u0001R!\u0010\u00c8\u0002\u001a\u00030\u00c3\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c4\u0002\u0010\u00c5\u0002\u001a\u0006\b\u00c6\u0002\u0010\u00c7\u0002R)\u0010\u00ca\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c9\u0002\u0010\u00e5\u0001\u001a\u0006\b\u00ca\u0002\u0010\u008d\u0002\"\u0006\b\u00cb\u0002\u0010\u008f\u0002R)\u0010\u0088\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00cc\u0002\u0010\u00e5\u0001\u001a\u0006\b\u0088\u0001\u0010\u008d\u0002\"\u0006\b\u00cd\u0002\u0010\u008f\u0002R\u0018\u0010\u00d1\u0002\u001a\u00030\u00ce\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cf\u0002\u0010\u00d0\u0002\u00a8\u0006\u00d6\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart;", "Lcom/tencent/mobileqq/wink/editor/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$e;", "", "height", "width", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "margin", "", "nc", "sb", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "tipId", "Zb", com.tencent.mobileqq.search.model.ac.f283467k0, "qb", "Landroid/view/View;", "view", "lb", "jb", "Ta", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/TextureView;", "Sa", "hc", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "fb", "", "curTime", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$a;", "Wa", "rc", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "eb", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "cb", "Lcom/tencent/tavcut/core/session/ICutSession;", "iCutSession", "Lcom/gyailib/library/GYTrackStickerInfo;", "stickerTrackerResult", "", "entityName", "Lorg/light/lightAssetKit/Entity;", "entity", "uc", "Lcom/tencent/mobileqq/wink/editor/draft/TrackStickerInfo;", "Ua", "kb", "Landroid/widget/ImageView;", "avatarView", "Landroid/widget/TextView;", "nameView", "wb", "currentDurationUs", "kc", "Cb", "mStickerModel", "Db", "forch", "Ka", "Yb", "La", "changedStickerModel", "Bb", "Nb", "Rb", "Oa", "Na", "", "Pa", "Qa", "Qb", "ub", TtmlNode.TAG_LAYOUT, "mc", PlayerConfig.TC_CACHE_DIR_NAME, "id", "sc", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "menuType", "xb", "yb", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "isFromQZoneText", "tb", "path", "Landroid/graphics/Bitmap;", "Va", "type", "button", "Ib", "Jb", "Gb", "Fb", "B9", "M9", "Landroid/os/Bundle;", "args", "L9", "onDismiss", "vb", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "Sb", UinConfigManager.KEY_HB, "model", "gc", "bc", "Ma", "event", "onReceiveEvent", "Ya", "Ljava/lang/Class;", "getEventClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/graphics/PointF;", "correctPoint", "isMove", "y2", "w2", "ec", "dc", "M3", "q9", "A3", "isTimeline", "jc", "M1", "enable", "cc", "Mb", "", "eventX", "eventY", "screenX", "screenY", "e1", "fingerOne", "fingerTwo", "U", "Landroid/graphics/RectF;", "U4", "K0", "h3", "N4", "u8", "action", "", "handleBroadcastMessage", "Z0", "Ra", "W0", "f3", "Eb", "isSuccess", "Kb", "content", "Hb", "Xa", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "D", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "winkStickerFrameLayout", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "getPlayerContainerWrapper", "()Landroid/widget/FrameLayout;", "setPlayerContainerWrapper", "(Landroid/widget/FrameLayout;)V", "playerContainerWrapper", "Landroid/view/ViewStub;", UserInfo.SEX_FEMALE, "Landroid/view/ViewStub;", "fakeFeedViewStub", "G", "Landroid/widget/TextView;", "authorInfoView", "H", "Landroid/graphics/Bitmap;", "freezeBitmap", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "I", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "winkEditorTextViewModel", "J", "winkEditorTemplateTextViewModel", "K", "winkEditorBackGroundTextViewModel", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListViewModel;", "L", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListViewModel;", "winkEditorTemplateTextListViewModel", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$b;", "M", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$b;", "timelineMenuItem", "N", "traceOnMenuItem", "P", "traceOffMenuItem", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "editMenuItem", BdhLogUtil.LogTag.Tag_Req, "deleteMenuItem", ExifInterface.LATITUDE_SOUTH, "subtitleEditMenuItem", "T", "subtitleDeleteMenuItem", "lyricEditMenuItem", "V", "lyricDeleteMenuItem", "W", "textReadMenuItem", "X", "timeEditMenuItem", "Y", "poiEditMenuItem", "Z", "Ljava/util/ArrayList;", "popupMenuItems", "a0", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getCurStickerModel", "()Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lb", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "curStickerModel", "b0", "mFakeFeedTopPart", "Landroidx/constraintlayout/widget/ConstraintLayout;", "c0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mFakeFeedInfoPart", "Landroid/widget/LinearLayout;", "d0", "Landroid/widget/LinearLayout;", "mFakeFeedPersonalInfoPart", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "e0", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "f0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "showGlobalLayoutListener", "g0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "mMusicVolumeControlViewModel", "h0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "mMusicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/tts/e;", "i0", "Lcom/tencent/mobileqq/wink/editor/tts/e;", "mTTSViewMode", "j0", "bb", "()Z", "setMStickIsMove", "(Z)V", "mStickIsMove", "k0", "margins", "l0", "smallMargins", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "m0", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "traceDialog", "n0", "Ljava/lang/String;", "modelPath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "o0", "Ljava/util/HashMap;", "modelPaths", "p0", "showTraceTips", "Landroid/animation/ValueAnimator;", "q0", "Landroid/animation/ValueAnimator;", "mTraceTipsAnimator", "r0", "TRACE_TIPS_SHOW_TIME", "s0", "isShowTraceTips", "", "t0", "curCenterX", "u0", "curCenterY", "v0", "curScaleX", "w0", "curScaleY", "x0", "traceStickers", "y0", "finalTraceStickers", "z0", "isTimePartUp", "A0", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "Landroid/util/Size;", "B0", "Landroid/util/Size;", "originStickerFrameLayoutSize", "C0", "textReadEnable", "D0", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "E0", "Lkotlin/Lazy;", "gb", "()Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "winkSubtitleViewModel", "F0", "isShowFakeFeedTip", "setShowFakeFeedTip", "G0", "setTimeline", "Ljava/lang/Runnable;", "H0", "Ljava/lang/Runnable;", "auhtorNameDisplayRunnable", "<init>", "()V", "I0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorStickerControlPart extends com.tencent.mobileqq.wink.editor.d implements SimpleEventReceiver<SimpleBaseEvent>, BorderView.e {

    /* renamed from: A0, reason: from kotlin metadata */
    private long currentTime;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private Size originStickerFrameLayoutSize;

    /* renamed from: C0, reason: from kotlin metadata */
    private boolean textReadEnable;

    /* renamed from: D, reason: from kotlin metadata */
    private WinkStickerFrameLayout winkStickerFrameLayout;

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean isFromQZoneText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout playerContainerWrapper;

    /* renamed from: E0, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkSubtitleViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ViewStub fakeFeedViewStub;

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean isShowFakeFeedTip;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView authorInfoView;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean isTimeline;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Bitmap freezeBitmap;

    /* renamed from: H0, reason: from kotlin metadata */
    @NotNull
    private final Runnable auhtorNameDisplayRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    private bb winkEditorTextViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private bb winkEditorTemplateTextViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private bb winkEditorBackGroundTextViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private WinkEditorTemplateTextListViewModel winkEditorTemplateTextListViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem timelineMenuItem;

    /* renamed from: N, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem traceOnMenuItem;

    /* renamed from: P, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem traceOffMenuItem;

    /* renamed from: Q, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem editMenuItem;

    /* renamed from: R, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem deleteMenuItem;

    /* renamed from: S, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem subtitleEditMenuItem;

    /* renamed from: T, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem subtitleDeleteMenuItem;

    /* renamed from: U, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem lyricEditMenuItem;

    /* renamed from: V, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem lyricDeleteMenuItem;

    /* renamed from: W, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem textReadMenuItem;

    /* renamed from: X, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem timeEditMenuItem;

    /* renamed from: Y, reason: from kotlin metadata */
    private WinkStickerFrameLayout.MenuItem poiEditMenuItem;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private ArrayList<WinkStickerFrameLayout.MenuItem> popupMenuItems = new ArrayList<>();

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkStickerModel curStickerModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mFakeFeedTopPart;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout mFakeFeedInfoPart;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mFakeFeedPersonalInfoPart;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StickerTrackerManager stickerTrackerManager;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener showGlobalLayoutListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicVolumeControlViewModel mMusicVolumeControlViewModel;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicSourceViewModel mMusicSourceViewModel;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.tts.e mTTSViewMode;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean mStickIsMove;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> margins;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> smallMargins;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog traceDialog;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String modelPath;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> modelPaths;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView showTraceTips;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mTraceTipsAnimator;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private final long TRACE_TIPS_SHOW_TIME;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean isShowTraceTips;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private double curCenterX;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private double curCenterY;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private float curScaleX;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private float curScaleY;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, GYTrackStickerInfo> traceStickers;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, GYTrackStickerInfo> finalTraceStickers;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private boolean isTimePartUp;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321592a;

        static {
            int[] iArr = new int[MenuType.values().length];
            try {
                iArr[MenuType.SUBTITLE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuType.SUBTITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuType.TEMPLATE_TEXT_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuType.LYRIC_STICKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuType.SMOOTH_DEBUG_CONFIG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuType.TEMPLATE_COLL_CLIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MenuType.OPENING_ENDING_AIGC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MenuType.STICKER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f321592a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart$d", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements IPlayer.PlayerListener {
        d() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            WinkEditorStickerControlPart.this.kc(currentDurationUs);
            WinkEditorStickerControlPart.this.currentTime = currentDurationUs;
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart$e", "Lcom/tencent/tavcut/core/manager/a;", "", "errorCode", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "", "stickerName", "Lorg/light/lightAssetKit/Entity;", "entity", "", "a", "", "process", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements com.tencent.tavcut.core.manager.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICutSession f321596b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WinkStickerModel f321597c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkVideoTavCut f321598d;

        e(ICutSession iCutSession, WinkStickerModel winkStickerModel, WinkVideoTavCut winkVideoTavCut) {
            this.f321596b = iCutSession;
            this.f321597c = winkStickerModel;
            this.f321598d = winkVideoTavCut;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(WinkStickerModel stickerModel, WinkEditorStickerControlPart this$0) {
            Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.showTraceTips;
            Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
            this$0.Kb(textView, i73.a.f407346a.a(stickerModel), true);
            if (stickerModel.isTextSticker()) {
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHAR_TRACK, "1");
            } else {
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_TRACK, "1");
            }
            this$0.Zb(true, R.string.f21899658);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(WinkEditorStickerControlPart this$0, float f16) {
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.traceDialog != null) {
                Intrinsics.checkNotNull(this$0.traceDialog);
                float f17 = f16 * 100;
                if (r0.k0() < f17 && (qCircleCommonLoadingDialog = this$0.traceDialog) != null) {
                    qCircleCommonLoadingDialog.setProgress((int) f17);
                }
            }
        }

        @Override // com.tencent.tavcut.core.manager.a
        public void a(int errorCode, @Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity) {
            Map<Integer, Float> map;
            Float f16;
            MutableLiveData<Boolean> u36;
            Intrinsics.checkNotNullParameter(stickerName, "stickerName");
            Intrinsics.checkNotNullParameter(entity, "entity");
            WinkEditorStickerControlPart.this.Cb();
            boolean z16 = false;
            if (errorCode != 0) {
                if (errorCode == 2) {
                    WinkEditorStickerControlPart winkEditorStickerControlPart = WinkEditorStickerControlPart.this;
                    TextView textView = winkEditorStickerControlPart.showTraceTips;
                    Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
                    winkEditorStickerControlPart.Kb(textView, i73.a.f407346a.a(this.f321597c), false);
                    WinkEditorStickerControlPart.this.Zb(true, R.string.f21896655);
                    WinkEditorStickerControlPart.this.hb();
                }
            } else {
                WinkEditorStickerControlPart.this.hb();
                WinkEditorStickerControlPart.this.uc(this.f321596b, stickerTrackerResult, stickerName, entity, this.f321597c);
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final WinkStickerModel winkStickerModel = this.f321597c;
                final WinkEditorStickerControlPart winkEditorStickerControlPart2 = WinkEditorStickerControlPart.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorStickerControlPart.e.e(WinkStickerModel.this, winkEditorStickerControlPart2);
                    }
                });
            }
            MusicVolumeControlViewModel eb5 = WinkEditorStickerControlPart.this.eb();
            if (eb5 != null) {
                map = eb5.d2();
            } else {
                map = null;
            }
            MusicSourceViewModel cb5 = WinkEditorStickerControlPart.this.cb();
            if (cb5 != null && (u36 = cb5.u3()) != null) {
                z16 = Intrinsics.areEqual(u36.getValue(), Boolean.TRUE);
            }
            if (z16) {
                this.f321598d.W2(true);
            }
            if (map != null) {
                this.f321598d.v(map);
            }
            MusicVolumeControlViewModel eb6 = WinkEditorStickerControlPart.this.eb();
            if (eb6 != null) {
                f16 = Float.valueOf(eb6.Z1());
            } else {
                f16 = null;
            }
            if (f16 != null) {
                dr.b.m(this.f321598d, f16.floatValue(), null, 2, null);
            }
            this.f321598d.v3();
        }

        @Override // com.tencent.tavcut.core.manager.a
        public void b(final float process, @NotNull String stickerName, @NotNull Entity entity) {
            Intrinsics.checkNotNullParameter(stickerName, "stickerName");
            Intrinsics.checkNotNullParameter(entity, "entity");
            ms.a.f(WinkEditorStickerControlPart.this.TAG, "IStickerTrackerManager trackingProcess " + process);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final WinkEditorStickerControlPart winkEditorStickerControlPart = WinkEditorStickerControlPart.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ac
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorStickerControlPart.e.f(WinkEditorStickerControlPart.this, process);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart$f", "Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "", "stickerName", "Lcom/gyailib/library/GYTrackStickerInfo;", "stickerInfo", "", "onUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements IStickerUpdateCallback {
        f() {
        }

        @Override // com.tencent.tavcut.core.session.IStickerUpdateCallback
        public void onUpdate(@NotNull String stickerName, @NotNull GYTrackStickerInfo stickerInfo) {
            WinkStickerModel winkStickerModel;
            boolean z16;
            boolean z17;
            boolean z18;
            Map<String, WinkStickerModel> m3;
            Intrinsics.checkNotNullParameter(stickerName, "stickerName");
            Intrinsics.checkNotNullParameter(stickerInfo, "stickerInfo");
            dr H9 = WinkEditorStickerControlPart.this.H9();
            if (H9 != null && (m3 = H9.m()) != null) {
                winkStickerModel = m3.get(stickerName);
            } else {
                winkStickerModel = null;
            }
            if (winkStickerModel != null) {
                WinkEditorStickerControlPart.this.traceStickers.put(stickerName, stickerInfo);
                boolean z19 = true;
                if (stickerInfo.imageW == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (stickerInfo.imageH == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        if (stickerInfo.f35990h == 0.0f) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            if (stickerInfo.f35991w != 0.0f) {
                                z19 = false;
                            }
                            if (!z19) {
                                WinkEditorStickerControlPart.this.finalTraceStickers.put(stickerName, stickerInfo);
                            }
                        }
                    }
                }
            }
        }
    }

    public WinkEditorStickerControlPart() {
        ArrayList<Integer> arrayListOf;
        ArrayList<Integer> arrayListOf2;
        Lazy lazy;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 0, 0, 0);
        this.margins = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(0, 0, 0, 0);
        this.smallMargins = arrayListOf2;
        this.modelPaths = new HashMap<>();
        this.TRACE_TIPS_SHOW_TIME = 2000L;
        this.curScaleX = 0.4f;
        this.curScaleY = 0.4f;
        this.traceStickers = new HashMap<>();
        this.finalTraceStickers = new HashMap<>();
        this.originStickerFrameLayoutSize = new Size(0, 0);
        this.textReadEnable = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSubtitleViewModel>() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$winkSubtitleViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkSubtitleViewModel invoke() {
                return (WinkSubtitleViewModel) WinkEditorStickerControlPart.this.getViewModel(WinkSubtitleViewModel.class);
            }
        });
        this.winkSubtitleViewModel = lazy;
        this.auhtorNameDisplayRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.u
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorStickerControlPart.Ja(WinkEditorStickerControlPart.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(WinkEditorStickerControlPart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.f(this$0.TAG, "stickerLayoutChanged:" + it);
        if (!it.booleanValue()) {
            this$0.nc(this$0.originStickerFrameLayoutSize.getHeight(), this$0.originStickerFrameLayoutSize.getWidth(), this$0.margins);
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.isTimePartUp = it.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Bb(WinkStickerModel changedStickerModel) {
        com.tencent.videocut.model.Size size;
        Integer num;
        Integer num2;
        Unit unit;
        dr H9;
        dr H92;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        ArrayList<WinkStickerModel> arrayList;
        dr H93;
        dr H94;
        WinkStickerModel winkStickerModel;
        Map<String, WinkStickerModel> m16;
        Collection<WinkStickerModel> values2;
        dr H95 = H9();
        if (H95 != null) {
            size = H95.getRenderSize();
        } else {
            size = null;
        }
        if (size != null) {
            num = size.width;
        } else {
            num = null;
        }
        if (size != null) {
            num2 = size.height;
        } else {
            num2 = null;
        }
        if (num != null && num2 != null) {
            int intValue = num2.intValue();
            int intValue2 = num.intValue();
            ArrayList arrayList2 = new ArrayList();
            if (changedStickerModel.isSubtitleSticker()) {
                dr H96 = H9();
                if (H96 != null && (m16 = H96.m()) != null && (values2 = m16.values()) != null) {
                    arrayList = new ArrayList();
                    for (Object obj : values2) {
                        if (((WinkStickerModel) obj).isSubtitleSticker()) {
                            arrayList.add(obj);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList3 = new ArrayList();
                    if (arrayList != null) {
                        for (WinkStickerModel winkStickerModel2 : arrayList) {
                            if (Intrinsics.areEqual(changedStickerModel.id, winkStickerModel2.id)) {
                                arrayList2.add(changedStickerModel);
                            } else if (hashSet.contains(Long.valueOf(winkStickerModel2.startTime))) {
                                arrayList3.add(winkStickerModel2);
                            } else {
                                WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, 0L, 0L, 0, changedStickerModel.scaleX, changedStickerModel.scaleY, changedStickerModel.rotate, changedStickerModel.centerX, changedStickerModel.centerY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -993, 1048575, null);
                                winkStickerModel = winkStickerModel2;
                                copyAndUpdate$default.updatePositionInView(intValue2, intValue, copyAndUpdate$default.scaleX, copyAndUpdate$default.scaleY, copyAndUpdate$default.centerX, copyAndUpdate$default.centerY);
                                arrayList2.add(copyAndUpdate$default);
                                hashSet.add(Long.valueOf(winkStickerModel.startTime));
                            }
                            winkStickerModel = winkStickerModel2;
                            hashSet.add(Long.valueOf(winkStickerModel.startTime));
                        }
                    }
                    H93 = H9();
                    if (H93 != null) {
                        H93.W(arrayList2);
                    }
                    H94 = H9();
                    if (H94 != null) {
                        H94.T(arrayList3);
                        unit = Unit.INSTANCE;
                    }
                }
                arrayList = null;
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList32 = new ArrayList();
                if (arrayList != null) {
                }
                H93 = H9();
                if (H93 != null) {
                }
                H94 = H9();
                if (H94 != null) {
                }
            } else {
                if (changedStickerModel.isLyricSticker() && (H92 = H9()) != null && (m3 = H92.m()) != null && (values = m3.values()) != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : values) {
                        if (((WinkStickerModel) obj2).isLyricSticker()) {
                            arrayList.add(obj2);
                        }
                    }
                    HashSet hashSet22 = new HashSet();
                    ArrayList arrayList322 = new ArrayList();
                    if (arrayList != null) {
                    }
                    H93 = H9();
                    if (H93 != null) {
                    }
                    H94 = H9();
                    if (H94 != null) {
                    }
                }
                arrayList = null;
                HashSet hashSet222 = new HashSet();
                ArrayList arrayList3222 = new ArrayList();
                if (arrayList != null) {
                }
                H93 = H9();
                if (H93 != null) {
                }
                H94 = H9();
                if (H94 != null) {
                }
            }
            if (unit != null && (H9 = H9()) != null) {
                dr.b.n(H9, changedStickerModel, false, 2, null);
                Unit unit2 = Unit.INSTANCE;
                return;
            }
        }
        unit = null;
        if (unit != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Cb() {
        StickerTrackerManager stickerTrackerManager = this.stickerTrackerManager;
        if (stickerTrackerManager != null) {
            stickerTrackerManager.U();
        }
        this.stickerTrackerManager = null;
    }

    private final void Db(WinkStickerModel mStickerModel) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        MetaMaterial material = mStickerModel.getMaterial();
        if (material != null) {
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, material.f30533id);
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(material));
        }
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        VideoReport.setElementId(winkStickerFrameLayout.getFrameView(), WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_COPYRIGHT_NOTICE);
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        VideoReport.setElementExposePolicy(winkStickerFrameLayout3.getFrameView(), ExposurePolicy.REPORT_NONE);
        WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout2 = winkStickerFrameLayout4;
        }
        VideoReport.reportEvent("dt_clck", winkStickerFrameLayout2.getFrameView(), extParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fb(View view) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_TEXT_READ_ICON);
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_TEXT_READ_ICON);
        VideoReport.reportEvent("dt_clck", view, extParams);
    }

    private final void Gb(View view) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_TEXT_READ_ICON);
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_TEXT_READ_ICON);
        VideoReport.reportEvent("dt_imp", view, extParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ib(View view, String type, String button) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_OR_CHAR, type);
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TRACK_OR_CANCEL_BUTTON, button);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_TRACK_BUTTON);
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_TRACK_BUTTON);
        VideoReport.reportEvent("dt_clck", view, extParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(WinkEditorStickerControlPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.authorInfoView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            TextView textView3 = this$0.authorInfoView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(4);
        }
    }

    private final void Jb(View view, String type, String button) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_OR_CHAR, type);
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TRACK_OR_CANCEL_BUTTON, button);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_TRACK_BUTTON);
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_TRACK_BUTTON);
        VideoReport.reportEvent("dt_imp", view, extParams);
    }

    private final void Ka(WinkStickerModel stickerModel, int tipId, boolean forch) {
        boolean z16;
        Boolean bool;
        ICutSession session;
        if (forch) {
            Yb(tipId, stickerModel);
            return;
        }
        if (stickerModel != null) {
            this.curStickerModel = stickerModel;
            if (stickerModel.getStickerTrackerResult() == null) {
                return;
            }
            dr H9 = H9();
            if (H9 == null) {
                z16 = true;
            } else {
                z16 = H9 instanceof WinkVideoTavCut;
            }
            if (z16) {
                dr H92 = H9();
                if (H92 != null && (session = H92.getSession()) != null) {
                    bool = Boolean.valueOf(Ma(session, stickerModel));
                } else {
                    bool = null;
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE) && tipId != 0) {
                    Yb(tipId, this.curStickerModel);
                }
            }
        }
    }

    private final void La(int tipId) {
        boolean z16;
        dr H9;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        boolean z17;
        dr H92;
        ICutSession session;
        dr H93 = H9();
        if (H93 == null) {
            z16 = true;
        } else {
            z16 = H93 instanceof WinkVideoTavCut;
        }
        if (z16 && (H9 = H9()) != null && (m3 = H9.m()) != null && (values = m3.values()) != null) {
            boolean z18 = false;
            for (WinkStickerModel winkStickerModel : values) {
                if (winkStickerModel.getIsTraceSticker() && (H92 = H9()) != null && (session = H92.getSession()) != null) {
                    z17 = Ma(session, winkStickerModel);
                } else {
                    z17 = false;
                }
                if (z17 && tipId != 0 && !z18) {
                    Zb(true, tipId);
                    WinkStickerModel winkStickerModel2 = this.curStickerModel;
                    if (winkStickerModel2 != null) {
                        String string = getContext().getResources().getString(tipId);
                        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(tipId)");
                        TextView textView = this.showTraceTips;
                        Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
                        Hb(textView, i73.a.f407346a.a(winkStickerModel2), string);
                    }
                    z18 = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(WinkStickerModel stickerModel) {
        if (stickerModel != null) {
            dr H9 = H9();
            if (H9 != null) {
                H9.play();
            }
            Bundle bundle = new Bundle();
            if (stickerModel.getTtsAudioInfo() == null) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = stickerModel.textItems.iterator();
                while (it.hasNext()) {
                    arrayList.add(((TextItem) it.next()).text);
                }
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                com.tencent.mobileqq.wink.editor.tts.e eVar = this.mTTSViewMode;
                com.tencent.mobileqq.wink.editor.tts.e eVar2 = null;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTTSViewMode");
                    eVar = null;
                }
                int T1 = eVar.T1();
                com.tencent.mobileqq.wink.editor.tts.e eVar3 = this.mTTSViewMode;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTTSViewMode");
                } else {
                    eVar2 = eVar3;
                }
                stickerModel.setTtsAudioInfo(new TTSAudioInfo(strArr, T1, eVar2.U1(), stickerModel.id));
            }
            stickerModel.setHasChooseTTS(true);
            bundle.putSerializable(QQWinkConstants.PICK_TEMPLATE_TTS_MODEL, stickerModel.getTtsAudioInfo());
            G9().u5(MenuType.TTS, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nb() {
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        createCustomDialog.setTitle(createCustomDialog.getContext().getString(R.string.f241067qv));
        createCustomDialog.setPositiveButton(createCustomDialog.getContext().getString(R.string.f241057qu), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorStickerControlPart.Ob(WinkEditorStickerControlPart.this, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(createCustomDialog.getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorStickerControlPart.Pb(dialogInterface, i3);
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            ms.a.e(this.TAG, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa() {
        com.tencent.mobileqq.wink.editor.music.lyric.sticker.z tk5;
        WinkEditorFragment F9 = F9();
        if (F9 != null && (tk5 = F9.tk()) != null) {
            com.tencent.mobileqq.wink.editor.music.lyric.sticker.z.g2(tk5, null, null, false, false, false, 30, null);
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkPlayerControlEvent(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ob(WinkEditorStickerControlPart this$0, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.curStickerModel = null;
        this$0.Pa(this$0.Qa());
        qQCustomDialog.dismiss();
        WinkSubtitleViewModel.v2(this$0.gb(), false, false, 2, null);
    }

    private final void Pa(List<? extends WinkStickerModel> stickerModel) {
        int i3;
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.w();
        dr H9 = H9();
        if (H9 != null) {
            H9.T(stickerModel);
        }
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkPlayerControlEvent(i3));
        G9().G4(stickerModel);
    }

    private final List<WinkStickerModel> Qa() {
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        ArrayList arrayList = new ArrayList();
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null && (values = m3.values()) != null) {
            for (WinkStickerModel winkStickerModel : values) {
                if (winkStickerModel.isSubtitleSticker()) {
                    arrayList.add(winkStickerModel);
                }
            }
        }
        return arrayList;
    }

    private final void Qb() {
        WinkStickerModel winkStickerModel;
        boolean z16;
        if (G9().getCurMenuType() != MenuType.STICKER_TIMELINE && G9().getCurMenuType() != MenuType.SUBTITLE && G9().getCurMenuType() != MenuType.TEMPLATE_TEXT_LIST && G9().getCurMenuType() != MenuType.LYRIC_STICKER && G9().getCurMenuType() != MenuType.TEMPLATE_COLL_CLIP && (winkStickerModel = this.curStickerModel) != null) {
            Intrinsics.checkNotNull(winkStickerModel);
            if (winkStickerModel.getInitStickerScale() == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                kb(getPartRootView());
                WinkStickerModel winkStickerModel2 = this.curStickerModel;
                if (winkStickerModel2 != null) {
                    this.isShowFakeFeedTip = false;
                    FrameLayout frameLayout = this.mFakeFeedTopPart;
                    if (frameLayout != null) {
                        mc(winkStickerModel2, frameLayout);
                    }
                    ConstraintLayout constraintLayout = this.mFakeFeedInfoPart;
                    if (constraintLayout != null) {
                        mc(winkStickerModel2, constraintLayout);
                    }
                    LinearLayout linearLayout = this.mFakeFeedPersonalInfoPart;
                    if (linearLayout != null) {
                        mc(winkStickerModel2, linearLayout);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rb(WinkStickerModel stickerModel) {
        W0(stickerModel);
    }

    private final TextureView Sa(ViewGroup parent) {
        TextureView Sa;
        int childCount = parent.getChildCount();
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = null;
            if (i3 >= childCount) {
                return null;
            }
            if (parent.getChildAt(i3) instanceof TextureView) {
                View childAt = parent.getChildAt(i3);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.TextureView");
                return (TextureView) childAt;
            }
            if (parent.getChildAt(i3).getVisibility() == 0) {
                View childAt2 = parent.getChildAt(i3);
                if (childAt2 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt2;
                }
                if (viewGroup != null && (Sa = Sa(viewGroup)) != null) {
                    return Sa;
                }
            }
            i3++;
        }
    }

    private final void Ta() {
        WinkVideoTavCut winkVideoTavCut;
        FrameLayout playerContainerWrapper;
        TextureView Sa;
        Bitmap bitmap;
        WinkAdaptiveImageView ivPreloadFrame;
        if (!QzoneConfig.isFreezeFrameWhileStickerTrackComputing()) {
            return;
        }
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null && (playerContainerWrapper = winkVideoTavCut.getPlayerContainerWrapper()) != null && (Sa = Sa(playerContainerWrapper)) != null && (bitmap = Sa.getBitmap()) != null) {
            Pair h16 = com.tencent.mobileqq.wink.editor.util.m.h(com.tencent.mobileqq.wink.editor.util.m.f322645a, null, 1, null);
            int intValue = ((Number) h16.component1()).intValue();
            int intValue2 = ((Number) h16.component2()).intValue();
            int renderWidth = winkVideoTavCut.getRenderWidth();
            int renderHeight = winkVideoTavCut.getRenderHeight();
            boolean U2 = winkVideoTavCut.U2(winkVideoTavCut.getRenderSize());
            WinkEditorFragment F9 = F9();
            if (F9 != null && (ivPreloadFrame = F9.getIvPreloadFrame()) != null) {
                ivPreloadFrame.setVisibility(0);
                ivPreloadFrame.setBitmapForFrameFreeze(bitmap, intValue, intValue2, renderWidth, renderHeight, U2);
                ivPreloadFrame.setBackgroundColor(-16777216);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tb(final WinkEditorStickerControlPart this$0, final WinkStickerModel winkStickerModel) {
        QCircleCommonLoadingDialog a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ta();
        if (this$0.traceDialog == null) {
            int fb5 = this$0.fb(winkStickerModel);
            if (fb5 > 30) {
                a16 = new QCircleCommonLoadingDialog.c(this$0.getContext()).n(true).q(fb5 > 60 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this$0.getContext().getString(R.string.f239817nh), this$0.getContext().getString(R.string.f241167r5, Integer.valueOf(fb5 / 60))}) : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this$0.getContext().getString(R.string.f239817nh), this$0.getContext().getString(R.string.f241157r4, Integer.valueOf(fb5))})).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorStickerControlPart.Vb(WinkEditorStickerControlPart.this, winkStickerModel);
                    }
                }).a();
            } else {
                a16 = new QCircleCommonLoadingDialog.c(this$0.getContext()).n(true).p(this$0.getContext().getString(R.string.f239817nh)).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorStickerControlPart.Wb(WinkEditorStickerControlPart.this, winkStickerModel);
                    }
                }).a();
            }
            this$0.traceDialog = a16;
            if (a16 != null) {
                a16.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.p
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                        boolean Xb;
                        Xb = WinkEditorStickerControlPart.Xb(WinkEditorStickerControlPart.this, dialogInterface, i3, keyEvent);
                        return Xb;
                    }
                });
            }
        }
        if (winkStickerModel != null) {
            this$0.Eb(i73.a.f407346a.a(winkStickerModel));
        }
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.traceDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.show();
        }
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog2 = this$0.traceDialog;
        if (qCircleCommonLoadingDialog2 != null) {
            qCircleCommonLoadingDialog2.setProgress(0);
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(8, 100));
    }

    private final ArrayList<TrackStickerInfo> Ua(ArrayList<GYTrackStickerInfo> stickerTrackerResult) {
        if (stickerTrackerResult != null) {
            ArrayList<TrackStickerInfo> arrayList = new ArrayList<>();
            Iterator<GYTrackStickerInfo> it = stickerTrackerResult.iterator();
            while (it.hasNext()) {
                GYTrackStickerInfo next = it.next();
                arrayList.add(new TrackStickerInfo(next.f35992x, next.f35993y, next.f35991w, next.f35990h, next.radian, next.imageW, next.imageH, next.confidence, next.timestamp));
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap Va(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        j.a aVar = new j.a();
        int i3 = 0;
        do {
            com.tencent.mobileqq.util.j.e(path, options, aVar);
            i3++;
            if (i3 >= 2) {
                break;
            }
        } while (aVar.f306779b == 1);
        return aVar.f306778a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vb(WinkEditorStickerControlPart this$0, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bc(winkStickerModel);
    }

    private final WinkEditorStickerTimelinePart.ClipTime Wa(long curTime) {
        boolean z16;
        boolean z17;
        List<WinkEditData> n3;
        long j3;
        List<WinkEditData> n16;
        dr H9 = H9();
        int i3 = 0;
        if (H9 != null && (n16 = H9.n()) != null && (!n16.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            dr H92 = H9();
            if (H92 != null) {
                z17 = H92.G();
            } else {
                z17 = false;
            }
            ms.a.f(this.TAG, "getCurrentClipStartAndEndTime isUsingTemplate = " + z17);
            dr H93 = H9();
            if (H93 != null && (n3 = H93.n()) != null) {
                List<MediaClip> t16 = com.tencent.mobileqq.wink.editor.draft.c.t(n3.get(0));
                long j16 = 0;
                for (Object obj : t16) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    MediaClip mediaClip = (MediaClip) obj;
                    if (!z17 && G9().getEnableImageTransition()) {
                        if (i3 != 0 && i3 != t16.size() - 1) {
                            j3 = 1000000;
                        } else {
                            j3 = 500000;
                        }
                    } else {
                        j3 = 0;
                    }
                    ResourceModel resourceModel = mediaClip.resource;
                    if (resourceModel != null) {
                        long j17 = resourceModel.scaleDuration - j3;
                        j16 += j17;
                        if (j16 > curTime) {
                            return new WinkEditorStickerTimelinePart.ClipTime(j16 - j17, j16);
                        }
                    }
                    i3 = i16;
                }
            }
        }
        ms.a.f(this.TAG, "getCurrentClipStartAndEndTime curClipEndTime 0, 0");
        return new WinkEditorStickerTimelinePart.ClipTime(0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wb(WinkEditorStickerControlPart this$0, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bc(winkStickerModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Xb(WinkEditorStickerControlPart this$0, DialogInterface dialog, int i3, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(event, "event");
        if (i3 == 4 && event.getRepeatCount() == 0) {
            this$0.bc(null);
            return false;
        }
        return false;
    }

    private final void Yb(int tipId, WinkStickerModel stickerModel) {
        Zb(true, tipId);
        if (stickerModel != null) {
            String string = getContext().getResources().getString(tipId);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(tipId)");
            TextView textView = this.showTraceTips;
            Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
            Hb(textView, i73.a.f407346a.a(stickerModel), string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Za(WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2) {
        int i3;
        int i16 = 0;
        if (winkStickerModel2 != null) {
            i3 = winkStickerModel2.layerIndex;
        } else {
            i3 = 0;
        }
        if (winkStickerModel != null) {
            i16 = winkStickerModel.layerIndex;
        }
        return i3 - i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zb(boolean isOpen, int tipId) {
        int i3;
        TextView textView = this.showTraceTips;
        if (textView != null) {
            textView.setText(getContext().getResources().getString(tipId));
        }
        TextView textView2 = this.showTraceTips;
        if (textView2 != null) {
            if (isOpen) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
        if (isOpen) {
            ac();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ab(PointF fingerCenter, WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2) {
        Intrinsics.checkNotNullParameter(fingerCenter, "$fingerCenter");
        com.tencent.mobileqq.wink.utils.u uVar = com.tencent.mobileqq.wink.utils.u.f326728a;
        return (int) (uVar.g(fingerCenter, new PointF(winkStickerModel.getCenterInView().f320587x, winkStickerModel.getCenterInView().f320588y)) - uVar.g(fingerCenter, new PointF(winkStickerModel2.getCenterInView().f320587x, winkStickerModel2.getCenterInView().f320588y)));
    }

    private final void ac() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (this.isShowTraceTips && (valueAnimator2 = this.mTraceTipsAnimator) != null) {
            valueAnimator2.end();
        }
        if (!this.isShowTraceTips && (valueAnimator = this.mTraceTipsAnimator) != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicSourceViewModel cb() {
        if (this.mMusicSourceViewModel == null && getHostFragment().getActivity() != null) {
            this.mMusicSourceViewModel = (MusicSourceViewModel) new ViewModelProvider(getHostFragment().requireActivity()).get(MusicSourceViewModel.class);
        }
        return this.mMusicSourceViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicVolumeControlViewModel eb() {
        if (this.mMusicVolumeControlViewModel == null && getHostFragment().getActivity() != null) {
            this.mMusicVolumeControlViewModel = (MusicVolumeControlViewModel) new ViewModelProvider(getHostFragment().requireActivity()).get(MusicVolumeControlViewModel.class);
        }
        return this.mMusicVolumeControlViewModel;
    }

    private final int fb(WinkStickerModel stickerModel) {
        long j3;
        float f16;
        if (stickerModel != null) {
            j3 = stickerModel.duration;
        } else {
            j3 = 0;
        }
        if (OfflineConfig.getPhonePerfLevel(getContext()) <= 3) {
            f16 = 2.5f;
        } else {
            f16 = 0.75f;
        }
        return (int) (((float) (j3 / 1000000)) * f16);
    }

    private final WinkSubtitleViewModel gb() {
        Object value = this.winkSubtitleViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkSubtitleViewModel>(...)");
        return (WinkSubtitleViewModel) value;
    }

    private final void hc() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.m
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorStickerControlPart.ic(WinkEditorStickerControlPart.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib() {
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(9, 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ic(WinkEditorStickerControlPart this$0) {
        WinkAdaptiveImageView ivPreloadFrame;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorFragment F9 = this$0.F9();
        if (F9 != null && (ivPreloadFrame = F9.getIvPreloadFrame()) != null) {
            ivPreloadFrame.setVisibility(8);
            Bitmap bitmap = this$0.freezeBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    private final void jb(View view) {
        View findViewById = view.findViewById(R.id.f164519sy1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorInfoView)");
        this.authorInfoView = (TextView) findViewById;
    }

    private final void kb(View view) {
        View view2;
        ImageView imageView;
        if (this.fakeFeedViewStub == null && view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.uzd);
            this.fakeFeedViewStub = viewStub;
            TextView textView = null;
            if (viewStub != null) {
                view2 = viewStub.inflate();
            } else {
                view2 = null;
            }
            this.mFakeFeedTopPart = (FrameLayout) view.findViewById(R.id.f122807ey);
            this.mFakeFeedInfoPart = (ConstraintLayout) view.findViewById(R.id.vaf);
            this.mFakeFeedPersonalInfoPart = (LinearLayout) view.findViewById(R.id.v_p);
            if (view2 != null) {
                imageView = (ImageView) view2.findViewById(R.id.v_e);
            } else {
                imageView = null;
            }
            if (view2 != null) {
                textView = (TextView) view2.findViewById(R.id.v_i);
            }
            if (imageView != null && textView != null) {
                wb(imageView, textView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kc(long currentDurationUs) {
        Map<String, WinkStickerModel> m3;
        String str;
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null) {
            WinkStickerModel winkStickerModel = this.curStickerModel;
            WinkStickerFrameLayout winkStickerFrameLayout = null;
            if (winkStickerModel != null) {
                str = winkStickerModel.id;
            } else {
                str = null;
            }
            WinkStickerModel winkStickerModel2 = m3.get(str);
            if (winkStickerModel2 != null) {
                long j3 = winkStickerModel2.startTime;
                if (currentDurationUs < j3 || currentDurationUs > j3 + winkStickerModel2.duration) {
                    WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    } else {
                        winkStickerFrameLayout = winkStickerFrameLayout2;
                    }
                    winkStickerFrameLayout.w();
                    ub();
                }
            }
        }
    }

    private final void lb(View view) {
        WinkEditorFragment winkEditorFragment;
        FrameLayout frameLayout;
        View findViewById = view.findViewById(R.id.f122407dv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.winkStickerFrameLayout)");
        WinkStickerFrameLayout winkStickerFrameLayout = (WinkStickerFrameLayout) findViewById;
        this.winkStickerFrameLayout = winkStickerFrameLayout;
        WinkEditorTemplateTextListViewModel winkEditorTemplateTextListViewModel = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.x(this.popupMenuItems);
        WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout2 = null;
        }
        winkStickerFrameLayout2.setPopupMenuClickListener(new WinkStickerFrameLayout.c() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$initStickerFrameLayout$1

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart$initStickerFrameLayout$1$a", "Lcom/tencent/mobileqq/wink/view/selector/WinkActionSheet$f;", "", "onDismiss", "onConfirm", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements WinkActionSheet.f {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WinkEditorStickerControlPart f321601a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ p73.b f321602b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ WinkStickerModel f321603c;

                a(WinkEditorStickerControlPart winkEditorStickerControlPart, p73.b bVar, WinkStickerModel winkStickerModel) {
                    this.f321601a = winkEditorStickerControlPart;
                    this.f321602b = bVar;
                    this.f321603c = winkStickerModel;
                }

                @Override // com.tencent.mobileqq.wink.view.selector.WinkActionSheet.f
                public void onConfirm() {
                    Map<String, WatermarkDataSourceModel> mutableMap;
                    Object obj;
                    WatermarkDateModel watermarkDateModel;
                    long e16 = this.f321602b.e();
                    w53.b.f(this.f321601a.TAG, "select time result = " + e16 + ".");
                    WatermarkDataSourceModel watermarkDataSourceModel = this.f321603c.watermarkModel.get(LightConstants.DataSourceKey.DATE);
                    if (watermarkDataSourceModel != null) {
                        mutableMap = MapsKt__MapsKt.toMutableMap(this.f321603c.watermarkModel);
                        WatermarkDateModel watermarkDateModel2 = watermarkDataSourceModel.watermarkDateModel;
                        if (watermarkDateModel2 != null) {
                            obj = null;
                            watermarkDateModel = WatermarkDateModel.copy$default(watermarkDateModel2, 1000 * e16, null, 2, null);
                        } else {
                            obj = null;
                            watermarkDateModel = null;
                        }
                        mutableMap.put(LightConstants.DataSourceKey.DATE, WatermarkDataSourceModel.copy$default(watermarkDataSourceModel, null, null, false, null, null, watermarkDateModel, null, null, 223, null));
                        dr H9 = this.f321601a.H9();
                        if (H9 != null) {
                            dr.b.n(H9, this.f321603c.copyAndUpdateWatermark(mutableMap), false, 2, obj);
                        }
                        dr H92 = this.f321601a.H9();
                        if (H92 != null) {
                            H92.play();
                        }
                    }
                }

                @Override // com.tencent.mobileqq.wink.view.selector.WinkActionSheet.f
                public void onDismiss() {
                    w53.b.f(this.f321601a.TAG, "select time canceled.");
                }
            }

            @Override // com.tencent.mobileqq.wink.view.WinkStickerFrameLayout.c
            public void a(int id5, @Nullable final WinkStickerModel stickerModel) {
                WinkStickerFrameLayout winkStickerFrameLayout3;
                String str;
                WinkStickerFrameLayout winkStickerFrameLayout4;
                WinkStickerFrameLayout winkStickerFrameLayout5;
                WinkStickerFrameLayout winkStickerFrameLayout6;
                WinkStickerFrameLayout winkStickerFrameLayout7;
                WinkStickerFrameLayout winkStickerFrameLayout8;
                WinkStickerFrameLayout winkStickerFrameLayout9;
                ICutSession session;
                boolean z16;
                WinkStickerFrameLayout winkStickerFrameLayout10;
                ICutSession session2;
                WinkStickerFrameLayout winkStickerFrameLayout11;
                WinkStickerFrameLayout winkStickerFrameLayout12;
                WinkStickerFrameLayout winkStickerFrameLayout13;
                WinkStickerFrameLayout winkStickerFrameLayout14;
                Long l3;
                long currentTimeMillis;
                WinkStickerFrameLayout winkStickerFrameLayout15;
                WatermarkDateModel watermarkDateModel;
                WinkEditorFragment F9;
                dr H9;
                WinkStickerFrameLayout winkStickerFrameLayout16;
                WinkStickerFrameLayout winkStickerFrameLayout17;
                boolean z17 = false;
                boolean z18 = true;
                WinkStickerFrameLayout winkStickerFrameLayout18 = null;
                switch (id5) {
                    case 1:
                        Bundle bundle = new Bundle();
                        if (stickerModel != null) {
                            WinkEditorStickerControlPart winkEditorStickerControlPart = WinkEditorStickerControlPart.this;
                            if (stickerModel.type == StickerModel.Type.BOTTOM_FRAME) {
                                WinkStickerModel Ra = winkEditorStickerControlPart.Ra(stickerModel);
                                if (Ra != null) {
                                    str = Ra.id;
                                } else {
                                    str = null;
                                }
                                bundle.putString("ARGS_STICKER_ID", str);
                            } else {
                                bundle.putString("ARGS_STICKER_ID", stickerModel.id);
                            }
                            if (stickerModel.isTextSticker()) {
                                bundle.putString("ARGS_ADD_BTN_TYPE", "ARGS_ADD_BTN_TYPE_TEXT");
                            } else {
                                bundle.putString("ARGS_ADD_BTN_TYPE", "ARGS_ADD_BTN_TYPE_STICKER");
                            }
                            winkEditorStickerControlPart.G9().u5(MenuType.STICKER_TIMELINE, bundle);
                            winkStickerFrameLayout3 = winkEditorStickerControlPart.winkStickerFrameLayout;
                            if (winkStickerFrameLayout3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout3;
                            }
                            com.tencent.mobileqq.wink.editor.sticker.f.r(winkStickerFrameLayout18, true);
                            return;
                        }
                        return;
                    case 2:
                        if (stickerModel != null && stickerModel.isTemplateTextSticker()) {
                            z17 = true;
                        }
                        if (z17) {
                            winkStickerFrameLayout5 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout5;
                            }
                            com.tencent.mobileqq.wink.editor.sticker.f.m(winkStickerFrameLayout18, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_TEXT_EDIT_BUTTON, true);
                        } else {
                            winkStickerFrameLayout4 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout4;
                            }
                            com.tencent.mobileqq.wink.editor.sticker.f.j(winkStickerFrameLayout18);
                        }
                        WinkEditorStickerControlPart.this.W0(stickerModel);
                        return;
                    case 3:
                        winkStickerFrameLayout6 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        } else {
                            winkStickerFrameLayout18 = winkStickerFrameLayout6;
                        }
                        com.tencent.mobileqq.wink.editor.sticker.f.i(winkStickerFrameLayout18);
                        WinkEditorStickerControlPart.this.w2(stickerModel);
                        return;
                    case 4:
                        winkStickerFrameLayout7 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        } else {
                            winkStickerFrameLayout18 = winkStickerFrameLayout7;
                        }
                        com.tencent.mobileqq.wink.editor.sticker.f.o(winkStickerFrameLayout18, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_MODIFY_BUTTON);
                        WinkEditorStickerControlPart.this.W0(stickerModel);
                        return;
                    case 5:
                        winkStickerFrameLayout8 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        } else {
                            winkStickerFrameLayout18 = winkStickerFrameLayout8;
                        }
                        com.tencent.mobileqq.wink.editor.sticker.f.o(winkStickerFrameLayout18, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_DELETE_BUTTON);
                        WinkEditorStickerControlPart.this.Nb();
                        return;
                    case 6:
                        WinkEditorStickerControlPart.this.ec(stickerModel);
                        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_TRACK_AGENT)) {
                            dr H92 = WinkEditorStickerControlPart.this.H9();
                            if (H92 != null) {
                                z18 = H92 instanceof WinkVideoTavCut;
                            }
                            if (z18) {
                                WinkEditorStickerControlPart.this.Lb(stickerModel);
                                dr H93 = WinkEditorStickerControlPart.this.H9();
                                if (H93 != null && (session = H93.getSession()) != null) {
                                    WinkEditorStickerControlPart.this.gc(session, stickerModel);
                                }
                                WinkEditorStickerControlPart.this.Sb(stickerModel);
                                if (stickerModel != null) {
                                    WinkEditorStickerControlPart winkEditorStickerControlPart2 = WinkEditorStickerControlPart.this;
                                    winkStickerFrameLayout9 = winkEditorStickerControlPart2.winkStickerFrameLayout;
                                    if (winkStickerFrameLayout9 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                    } else {
                                        winkStickerFrameLayout18 = winkStickerFrameLayout9;
                                    }
                                    winkEditorStickerControlPart2.Ib(winkStickerFrameLayout18, i73.a.f407346a.a(stickerModel), "track");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        QQToast.makeText(WinkEditorStickerControlPart.this.getContext(), -1, WinkEditorStickerControlPart.this.getContext().getString(R.string.f239967nw), 0).show();
                        return;
                    case 7:
                        WinkEditorStickerControlPart.this.Lb(stickerModel);
                        WinkEditorStickerControlPart.this.dc(stickerModel);
                        dr H94 = WinkEditorStickerControlPart.this.H9();
                        if (H94 == null) {
                            z16 = true;
                        } else {
                            z16 = H94 instanceof WinkVideoTavCut;
                        }
                        if (z16) {
                            dr H95 = WinkEditorStickerControlPart.this.H9();
                            if (H95 != null && (session2 = H95.getSession()) != null) {
                                WinkEditorStickerControlPart.this.Ma(session2, stickerModel);
                            }
                            if (stickerModel != null) {
                                WinkEditorStickerControlPart winkEditorStickerControlPart3 = WinkEditorStickerControlPart.this;
                                winkStickerFrameLayout10 = winkEditorStickerControlPart3.winkStickerFrameLayout;
                                if (winkStickerFrameLayout10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                } else {
                                    winkStickerFrameLayout18 = winkStickerFrameLayout10;
                                }
                                winkEditorStickerControlPart3.Ib(winkStickerFrameLayout18, i73.a.f407346a.a(stickerModel), "cancel_track");
                            }
                        }
                        SimpleEventBus.getInstance().dispatchEvent(new WinkPlayerControlEvent(1));
                        return;
                    case 8:
                        winkStickerFrameLayout11 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout11 = null;
                        }
                        com.tencent.mobileqq.wink.editor.sticker.f.l(winkStickerFrameLayout11, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_STYLE_MODIFY_BUTTON, false, 4, null);
                        WinkEditorStickerControlPart.this.Rb(stickerModel);
                        return;
                    case 9:
                        winkStickerFrameLayout12 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout12 = null;
                        }
                        com.tencent.mobileqq.wink.editor.sticker.f.l(winkStickerFrameLayout12, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_STYLE_DELETE_BUTTON, false, 4, null);
                        WinkEditorStickerControlPart.this.Oa();
                        return;
                    case 10:
                        WinkEditorStickerControlPart.this.Na(stickerModel);
                        if (stickerModel != null) {
                            WinkEditorStickerControlPart winkEditorStickerControlPart4 = WinkEditorStickerControlPart.this;
                            winkStickerFrameLayout13 = winkEditorStickerControlPart4.winkStickerFrameLayout;
                            if (winkStickerFrameLayout13 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout13;
                            }
                            winkEditorStickerControlPart4.Fb(winkStickerFrameLayout18);
                            return;
                        }
                        return;
                    case 11:
                        if (stickerModel != null) {
                            winkStickerFrameLayout14 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                winkStickerFrameLayout14 = null;
                            }
                            com.tencent.mobileqq.wink.editor.sticker.f.s(winkStickerFrameLayout14, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_MODIFY_TIME_BUTTON, stickerModel);
                            WatermarkDataSourceModel watermarkDataSourceModel = stickerModel.watermarkModel.get(LightConstants.DataSourceKey.DATE);
                            if (watermarkDataSourceModel != null && (watermarkDateModel = watermarkDataSourceModel.watermarkDateModel) != null) {
                                l3 = Long.valueOf(watermarkDateModel.timestampUs / 1000);
                            } else {
                                l3 = null;
                            }
                            Context context = WinkEditorStickerControlPart.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            WinkStickerTimeDateType winkStickerTimeDateType = WinkStickerTimeDateType.FullTime;
                            if (l3 != null) {
                                currentTimeMillis = l3.longValue();
                            } else {
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            p73.b bVar = new p73.b(context, true, winkStickerTimeDateType, currentTimeMillis);
                            bVar.a(new a(WinkEditorStickerControlPart.this, bVar, stickerModel));
                            bVar.b();
                            winkStickerFrameLayout15 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout15 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout15;
                            }
                            winkStickerFrameLayout18.w();
                            return;
                        }
                        return;
                    case 12:
                        F9 = WinkEditorStickerControlPart.this.F9();
                        if (F9 != null && (H9 = WinkEditorStickerControlPart.this.H9()) != null && stickerModel != null && WinkEditorStickerControlPart.this.getActivity() != null) {
                            winkStickerFrameLayout16 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout16 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                winkStickerFrameLayout16 = null;
                            }
                            com.tencent.mobileqq.wink.editor.sticker.f.s(winkStickerFrameLayout16, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_EDIT_LOCATION_BUTTON, stickerModel);
                            Pair<List<LbsDataV2.PoiInfo>, Integer> i3 = WaterMarkDataManager.f321551a.i(stickerModel, H9);
                            if (i3 == null) {
                                return;
                            }
                            final List<LbsDataV2.PoiInfo> component1 = i3.component1();
                            final int intValue = i3.component2().intValue();
                            WinkEditorLbsUtil.LocationSelector m3 = WinkEditorLbsUtil.f322604d.m(F9.Dk(), F9);
                            LbsDataV2.PoiInfo poiInfo = component1.get(intValue);
                            m3.e(component1);
                            m3.g(poiInfo);
                            m3.f(poiInfo);
                            final WinkEditorStickerControlPart winkEditorStickerControlPart5 = WinkEditorStickerControlPart.this;
                            m3.c(new Function2<LbsDataV2.PoiInfo, Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$initStickerFrameLayout$1$onMenuClick$9
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(LbsDataV2.PoiInfo poiInfo2, Throwable th5) {
                                    invoke2(poiInfo2, th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@Nullable LbsDataV2.PoiInfo poiInfo2, @Nullable Throwable th5) {
                                    Object orNull;
                                    Map<String, WatermarkDataSourceModel> mutableMap;
                                    if (poiInfo2 == null) {
                                        if (th5 != null) {
                                            w53.b.d(WinkEditorStickerControlPart.this.TAG, "select poi fail", th5);
                                            return;
                                        }
                                        return;
                                    }
                                    w53.b.a(WinkEditorStickerControlPart.this.TAG, "select poi success " + poiInfo2);
                                    orNull = CollectionsKt___CollectionsKt.getOrNull(component1, intValue);
                                    LbsDataV2.PoiInfo poiInfo3 = (LbsDataV2.PoiInfo) orNull;
                                    if (Intrinsics.areEqual(poiInfo3 != null ? poiInfo3.poiId : null, poiInfo2.poiId)) {
                                        w53.b.a(WinkEditorStickerControlPart.this.TAG, "select same poi " + poiInfo2);
                                        return;
                                    }
                                    WatermarkDataSourceModel watermarkDataSourceModel2 = stickerModel.watermarkModel.get(LightConstants.DataSourceKey.LOCATION);
                                    if (watermarkDataSourceModel2 != null) {
                                        mutableMap = MapsKt__MapsKt.toMutableMap(stickerModel.watermarkModel);
                                        WatermarkPoiModelWrapper watermarkPoiModelWrapper = watermarkDataSourceModel2.watermarkPoiModelWrapper;
                                        mutableMap.put(LightConstants.DataSourceKey.LOCATION, WatermarkDataSourceModel.copy$default(watermarkDataSourceModel2, null, null, false, null, null, null, watermarkPoiModelWrapper != null ? com.tencent.videocut.render.extension.i.h(watermarkPoiModelWrapper, poiInfo2) : null, null, 191, null));
                                        dr H96 = WinkEditorStickerControlPart.this.H9();
                                        if (H96 != null) {
                                            dr.b.n(H96, stickerModel.copyAndUpdateWatermark(mutableMap), false, 2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    w53.b.c(WinkEditorStickerControlPart.this.TAG, "cannot get location model in sticker");
                                }
                            });
                            com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_LOCATION_PANEL, new String[0]);
                            winkStickerFrameLayout17 = WinkEditorStickerControlPart.this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout17 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            } else {
                                winkStickerFrameLayout18 = winkStickerFrameLayout17;
                            }
                            winkStickerFrameLayout18.w();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof WinkEditorFragment) {
            winkEditorFragment = (WinkEditorFragment) hostFragment;
        } else {
            winkEditorFragment = null;
        }
        if (winkEditorFragment != null) {
            View view2 = winkEditorFragment.getView();
            if (view2 != null) {
                frameLayout = (FrameLayout) view2.findViewById(R.id.f25760bp);
            } else {
                frameLayout = null;
            }
            this.playerContainerWrapper = frameLayout;
        }
        if (this.showGlobalLayoutListener == null) {
            this.showGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.z
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    WinkEditorStickerControlPart.mb(WinkEditorStickerControlPart.this);
                }
            };
        }
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        ViewTreeObserver viewTreeObserver = winkStickerFrameLayout3.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this.showGlobalLayoutListener);
        }
        G9().f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerControlPart.nb(WinkEditorStickerControlPart.this, (MenuSwitchAction) obj);
            }
        });
        WinkEditorTemplateTextListViewModel winkEditorTemplateTextListViewModel2 = this.winkEditorTemplateTextListViewModel;
        if (winkEditorTemplateTextListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextListViewModel");
        } else {
            winkEditorTemplateTextListViewModel = winkEditorTemplateTextListViewModel2;
        }
        winkEditorTemplateTextListViewModel.N1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerControlPart.ob(WinkEditorStickerControlPart.this, (WinkStickerModel) obj);
            }
        });
        G9().h3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerControlPart.pb(WinkEditorStickerControlPart.this, (Configuration) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(WinkEditorStickerControlPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkStickerFrameLayout winkStickerFrameLayout = this$0.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        int measuredWidth = winkStickerFrameLayout.getMeasuredWidth();
        WinkStickerFrameLayout winkStickerFrameLayout3 = this$0.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        this$0.originStickerFrameLayoutSize = new Size(measuredWidth, winkStickerFrameLayout3.getMeasuredHeight());
        WinkStickerFrameLayout winkStickerFrameLayout4 = this$0.winkStickerFrameLayout;
        if (winkStickerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout4 = null;
        }
        int measuredHeight = winkStickerFrameLayout4.getMeasuredHeight();
        WinkStickerFrameLayout winkStickerFrameLayout5 = this$0.winkStickerFrameLayout;
        if (winkStickerFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout5 = null;
        }
        this$0.nc(measuredHeight, winkStickerFrameLayout5.getMeasuredWidth(), this$0.margins);
        WinkStickerFrameLayout winkStickerFrameLayout6 = this$0.winkStickerFrameLayout;
        if (winkStickerFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout2 = winkStickerFrameLayout6;
        }
        ViewTreeObserver viewTreeObserver = winkStickerFrameLayout2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this$0.showGlobalLayoutListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void mc(WinkStickerModel stickerModel, ViewGroup layout) {
        boolean z16;
        boolean z17 = true;
        if (com.tencent.mobileqq.wink.editor.util.g.f322634a.i()) {
            WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout = null;
            }
            if (winkStickerFrameLayout.z(stickerModel, layout)) {
                z16 = true;
                if (!z16) {
                    layout.setVisibility(0);
                } else {
                    layout.setVisibility(4);
                }
                if (!z16 && !this.isShowFakeFeedTip) {
                    z17 = false;
                }
                this.isShowFakeFeedTip = z17;
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (!z16) {
            z17 = false;
        }
        this.isShowFakeFeedTip = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(WinkEditorStickerControlPart this$0, MenuSwitchAction menuSwitchAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuSwitchAction.getMenuType() != MenuType.STICKER_TIMELINE) {
            WinkStickerFrameLayout winkStickerFrameLayout = this$0.winkStickerFrameLayout;
            WinkStickerFrameLayout winkStickerFrameLayout2 = null;
            if (winkStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout = null;
            }
            winkStickerFrameLayout.w();
            WinkStickerFrameLayout winkStickerFrameLayout3 = this$0.winkStickerFrameLayout;
            if (winkStickerFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            } else {
                winkStickerFrameLayout2 = winkStickerFrameLayout3;
            }
            winkStickerFrameLayout2.setManualHide(true);
        }
    }

    private final void nc(int height, int width, ArrayList<Integer> margin) {
        Integer num;
        float f16;
        WinkStickerFrameLayout winkStickerFrameLayout;
        float f17;
        com.tencent.videocut.model.Size a16;
        Integer num2;
        com.tencent.videocut.model.Size renderSize;
        WinkVideoTavCut winkVideoTavCut;
        WinkImageTavCut winkImageTavCut;
        WinkImageTavCut winkImageTavCut2;
        float f18;
        float f19;
        float f26;
        com.tencent.videocut.model.Size renderSize2;
        Integer num3;
        float f27;
        com.tencent.videocut.model.Size renderSize3;
        Integer num4;
        com.tencent.videocut.model.Size renderSize4;
        Integer num5;
        com.tencent.videocut.model.Size renderSize5;
        Integer num6;
        com.tencent.videocut.model.Size renderSize6;
        Integer num7;
        dr H9 = H9();
        if (H9 != null && H9.getRenderSize() != null) {
            WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams = winkStickerFrameLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            dr H92 = H9();
            if (H92 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H92;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                if (winkVideoTavCut.getUseVerticalPlayer()) {
                    float f28 = width;
                    float f29 = height;
                    margin.set(0, 0);
                    int i3 = (int) ((f29 - ((f28 * f29) / f28)) / 2.0f);
                    margin.set(1, Integer.valueOf(i3));
                    margin.set(2, 0);
                    margin.set(3, Integer.valueOf(i3));
                } else {
                    float f36 = height;
                    float f37 = width;
                    int i16 = (int) ((f37 - f37) / 2.0f);
                    margin.set(0, Integer.valueOf(i16));
                    int i17 = (int) ((f36 - f36) / 2.0f);
                    margin.set(1, Integer.valueOf(i17));
                    margin.set(2, Integer.valueOf(i16));
                    margin.set(3, Integer.valueOf(i17));
                }
                Integer num8 = margin.get(0);
                Intrinsics.checkNotNullExpressionValue(num8, "margin[0]");
                int intValue = num8.intValue();
                Integer num9 = margin.get(1);
                Intrinsics.checkNotNullExpressionValue(num9, "margin[1]");
                int intValue2 = num9.intValue();
                Integer num10 = margin.get(2);
                Intrinsics.checkNotNullExpressionValue(num10, "margin[2]");
                int intValue3 = num10.intValue();
                Integer num11 = margin.get(3);
                Intrinsics.checkNotNullExpressionValue(num11, "margin[3]");
                marginLayoutParams.setMargins(intValue, intValue2, intValue3, num11.intValue());
                WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout3 = null;
                }
                winkStickerFrameLayout3.setLayoutParams(marginLayoutParams);
                WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout4 = null;
                }
                winkStickerFrameLayout4.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorStickerControlPart.oc(WinkEditorStickerControlPart.this);
                    }
                });
            }
            dr H93 = H9();
            if (H93 instanceof WinkImageTavCut) {
                winkImageTavCut = (WinkImageTavCut) H93;
            } else {
                winkImageTavCut = null;
            }
            if (winkImageTavCut != null) {
                float f38 = height;
                float f39 = width;
                dr H94 = H9();
                if (H94 instanceof WinkImageTavCut) {
                    winkImageTavCut2 = (WinkImageTavCut) H94;
                } else {
                    winkImageTavCut2 = null;
                }
                if (winkImageTavCut2 != null && winkImageTavCut2.G()) {
                    dr H95 = H9();
                    if (H95 != null && (renderSize6 = H95.getRenderSize()) != null && (num7 = renderSize6.width) != null) {
                        f26 = num7.intValue() / 960;
                    } else {
                        f26 = 1.0f;
                    }
                    float f46 = 1280;
                    f18 = f26 * f46;
                    dr H96 = H9();
                    if (H96 != null && (renderSize5 = H96.getRenderSize()) != null && (num6 = renderSize5.width) != null) {
                        f19 = num6.intValue();
                    } else {
                        f19 = f39;
                    }
                    dr H97 = H9();
                    if (H97 != null && (renderSize2 = H97.getRenderSize()) != null && (num3 = renderSize2.height) != null && f18 > num3.intValue()) {
                        dr H98 = H9();
                        if (H98 != null && (renderSize4 = H98.getRenderSize()) != null && (num5 = renderSize4.height) != null) {
                            f18 = num5.intValue();
                        } else {
                            f18 = f39;
                        }
                        dr H99 = H9();
                        if (H99 != null && (renderSize3 = H99.getRenderSize()) != null && (num4 = renderSize3.height) != null) {
                            f27 = num4.intValue() / f46;
                        } else {
                            f27 = 1.0f;
                        }
                        f19 = f27 * 960;
                    }
                } else {
                    f18 = f38;
                    f19 = f39;
                }
                int i18 = (int) ((f39 - f19) / 2.0f);
                margin.set(0, Integer.valueOf(i18));
                int i19 = (int) ((f38 - f18) / 2.0f);
                margin.set(1, Integer.valueOf(i19));
                margin.set(2, Integer.valueOf(i18));
                margin.set(3, Integer.valueOf(i19));
                Integer num12 = margin.get(0);
                Intrinsics.checkNotNullExpressionValue(num12, "margin[0]");
                int intValue4 = num12.intValue();
                Integer num13 = margin.get(1);
                Intrinsics.checkNotNullExpressionValue(num13, "margin[1]");
                int intValue5 = num13.intValue();
                Integer num14 = margin.get(2);
                Intrinsics.checkNotNullExpressionValue(num14, "margin[2]");
                int intValue6 = num14.intValue();
                Integer num15 = margin.get(3);
                Intrinsics.checkNotNullExpressionValue(num15, "margin[3]");
                marginLayoutParams.setMargins(intValue4, intValue5, intValue6, num15.intValue());
                WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout5 = null;
                }
                winkStickerFrameLayout5.setLayoutParams(marginLayoutParams);
                WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout6 = null;
                }
                winkStickerFrameLayout6.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorStickerControlPart.qc(WinkEditorStickerControlPart.this);
                    }
                });
            }
        }
        dr H910 = H9();
        if (H910 != null && (renderSize = H910.getRenderSize()) != null) {
            num = renderSize.height;
        } else {
            num = null;
        }
        dr H911 = H9();
        if (H911 != null && (a16 = H911.a()) != null && (num2 = a16.width) != null) {
            f16 = num2.intValue() / 720;
        } else {
            f16 = 1.0f;
        }
        float f47 = f16 * 1280;
        if (num != null) {
            num.intValue();
            if (num.intValue() > 0.0f && f47 > 0.0f && num.intValue() > f47) {
                float intValue7 = num.intValue() / f47;
                WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    f17 = 1.0f;
                    winkStickerFrameLayout = null;
                } else {
                    winkStickerFrameLayout = winkStickerFrameLayout7;
                    f17 = 1.0f;
                }
                winkStickerFrameLayout.setPicScale(Math.max(intValue7, f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ob(WinkEditorStickerControlPart this$0, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.G9().getCurMenuType() == MenuType.TEMPLATE_TEXT_LIST) {
            bb bbVar = this$0.winkEditorTemplateTextViewModel;
            bb bbVar2 = null;
            if (bbVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextViewModel");
                bbVar = null;
            }
            bbVar.F2(winkStickerModel);
            WinkStickerFrameLayout winkStickerFrameLayout = this$0.winkStickerFrameLayout;
            if (winkStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout = null;
            }
            winkStickerFrameLayout.w();
            bb bbVar3 = this$0.winkEditorTemplateTextViewModel;
            if (bbVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextViewModel");
            } else {
                bbVar2 = bbVar3;
            }
            bbVar2.I2(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oc(WinkEditorStickerControlPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.flush(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pb(WinkEditorStickerControlPart this$0, Configuration configuration) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkStickerFrameLayout winkStickerFrameLayout = this$0.winkStickerFrameLayout;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.w();
    }

    private final void qb() {
        WinkEditorFragment winkEditorFragment;
        Fragment hostFragment = getHostFragment();
        TextView textView = null;
        if (hostFragment instanceof WinkEditorFragment) {
            winkEditorFragment = (WinkEditorFragment) hostFragment;
        } else {
            winkEditorFragment = null;
        }
        if (winkEditorFragment != null) {
            View view = winkEditorFragment.getView();
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.f84974np);
            }
            this.showTraceTips = textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 0.0f).setDuration(this.TRACE_TIPS_SHOW_TIME);
        this.mTraceTipsAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.r
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WinkEditorStickerControlPart.rb(WinkEditorStickerControlPart.this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mTraceTipsAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qc(WinkEditorStickerControlPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.flush(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(WinkEditorStickerControlPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        TextView textView = this$0.showTraceTips;
        if (textView != null) {
            textView.setAlpha(floatValue);
        }
    }

    private final WinkStickerModel rc(WinkStickerModel stickerModel) {
        Map<String, WinkStickerModel> m3;
        String str;
        WinkEditorStickerTimelinePart.ClipTime Wa = Wa(this.currentTime);
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null) {
            if (stickerModel != null) {
                str = stickerModel.id;
            } else {
                str = null;
            }
            WinkStickerModel winkStickerModel = m3.get(str);
            if (winkStickerModel != null) {
                WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, Wa.getStartTime(), Wa.getEndTime() - Wa.getStartTime(), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -13, 1048575, null);
                dr H92 = H9();
                Intrinsics.checkNotNull(H92);
                dr.b.n(H92, copyAndUpdate$default, false, 2, null);
                return copyAndUpdate$default;
            }
        }
        return null;
    }

    private final void sb() {
        String lightBundleDir = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(AEResInfo.LIGHT_RES_BUNDLE_TRACK_AGENT);
        this.modelPath = lightBundleDir;
        this.modelPaths.put("root-path", lightBundleDir);
    }

    private final void sc(String id5) {
        dr H9;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        com.tencent.videocut.model.Size size;
        Integer num;
        GYTrackStickerInfo gYTrackStickerInfo = this.finalTraceStickers.get(id5);
        if (gYTrackStickerInfo != null && (H9 = H9()) != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(id5)) != null) {
            double d16 = gYTrackStickerInfo.f35992x;
            float f16 = gYTrackStickerInfo.f35991w;
            double d17 = 2;
            this.curCenterX = (((d16 + (f16 * 0.5d)) / gYTrackStickerInfo.imageW) - 0.5d) * d17;
            double d18 = gYTrackStickerInfo.f35993y;
            float f17 = gYTrackStickerInfo.f35990h;
            this.curCenterY = (((d18 + (f17 * 0.5d)) / gYTrackStickerInfo.imageH) - 0.5d) * d17 * (-1);
            this.curScaleX = f16 / winkStickerModel.width;
            this.curScaleY = f17 / winkStickerModel.height;
            dr H92 = H9();
            if (H92 != null) {
                size = H92.getRenderSize();
            } else {
                size = null;
            }
            WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, 0L, 0, this.curScaleX, this.curScaleY, 0.0f, (float) this.curCenterX, (float) this.curCenterY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -865, 1048575, null);
            if (size != null && (num = size.width) != null) {
                int intValue = num.intValue();
                Integer num2 = size.height;
                if (num2 != null) {
                    winkStickerModel.updatePositionInView(intValue, num2.intValue(), this.curScaleX, this.curScaleY, (float) this.curCenterX, (float) this.curCenterY);
                }
            }
            dr H93 = H9();
            if (H93 != null) {
                dr.b.n(H93, copyAndUpdate$default, false, 2, null);
            }
        }
    }

    private final void tb(WinkStickerModel stickerModel, WinkEditorViewModel.EditMode editMode, boolean isFromQZoneText) {
        boolean z16;
        boolean z17;
        this.popupMenuItems.clear();
        WinkStickerFrameLayout winkStickerFrameLayout = null;
        if (stickerModel.isTemplateImageSticker()) {
            ArrayList<WinkStickerFrameLayout.MenuItem> arrayList = this.popupMenuItems;
            WinkStickerFrameLayout.MenuItem menuItem = this.deleteMenuItem;
            if (menuItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteMenuItem");
                menuItem = null;
            }
            arrayList.add(menuItem);
        } else {
            boolean z18 = false;
            if (stickerModel.isTemplateTextSticker()) {
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList2 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem2 = this.editMenuItem;
                if (menuItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editMenuItem");
                    menuItem2 = null;
                }
                arrayList2.add(menuItem2);
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList3 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem3 = this.deleteMenuItem;
                if (menuItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deleteMenuItem");
                    menuItem3 = null;
                }
                arrayList3.add(menuItem3);
                WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout2 = null;
                }
                com.tencent.mobileqq.wink.editor.sticker.f.m(winkStickerFrameLayout2, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_TEXT_EDIT_BUTTON, false);
            } else if (stickerModel.isBackgroundTextSticker()) {
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList4 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem4 = this.editMenuItem;
                if (menuItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editMenuItem");
                    menuItem4 = null;
                }
                arrayList4.add(menuItem4);
            } else if (stickerModel.isSubtitleSticker()) {
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList5 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem5 = this.subtitleEditMenuItem;
                if (menuItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleEditMenuItem");
                    menuItem5 = null;
                }
                arrayList5.add(menuItem5);
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList6 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem6 = this.subtitleDeleteMenuItem;
                if (menuItem6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleDeleteMenuItem");
                    menuItem6 = null;
                }
                arrayList6.add(menuItem6);
                WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout3 = null;
                }
                com.tencent.mobileqq.wink.editor.sticker.f.n(winkStickerFrameLayout3, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_DELETE_BUTTON);
                WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout4 = null;
                }
                com.tencent.mobileqq.wink.editor.sticker.f.n(winkStickerFrameLayout4, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_MODIFY_BUTTON);
            } else if (stickerModel.isLyricSticker()) {
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList7 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem7 = this.lyricEditMenuItem;
                if (menuItem7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lyricEditMenuItem");
                    menuItem7 = null;
                }
                arrayList7.add(menuItem7);
                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList8 = this.popupMenuItems;
                WinkStickerFrameLayout.MenuItem menuItem8 = this.lyricDeleteMenuItem;
                if (menuItem8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lyricDeleteMenuItem");
                    menuItem8 = null;
                }
                arrayList8.add(menuItem8);
                WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout5 = null;
                }
                com.tencent.mobileqq.wink.editor.sticker.f.k(winkStickerFrameLayout5, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_STYLE_MODIFY_BUTTON, false);
                WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout6 = null;
                }
                com.tencent.mobileqq.wink.editor.sticker.f.k(winkStickerFrameLayout6, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_STYLE_DELETE_BUTTON, false);
            } else {
                WinkEditorViewModel.EditMode editMode2 = WinkEditorViewModel.EditMode.Video;
                if (editMode == editMode2 && !isFromQZoneText) {
                    ArrayList<WinkStickerFrameLayout.MenuItem> arrayList9 = this.popupMenuItems;
                    WinkStickerFrameLayout.MenuItem menuItem9 = this.timelineMenuItem;
                    if (menuItem9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timelineMenuItem");
                        menuItem9 = null;
                    }
                    arrayList9.add(menuItem9);
                }
                if (com.tencent.videocut.render.extension.i.f(stickerModel, false, 1, null)) {
                    ArrayList<WinkStickerFrameLayout.MenuItem> arrayList10 = this.popupMenuItems;
                    WinkStickerFrameLayout.MenuItem menuItem10 = this.timeEditMenuItem;
                    if (menuItem10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeEditMenuItem");
                        menuItem10 = null;
                    }
                    arrayList10.add(menuItem10);
                    WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout7 = null;
                    }
                    com.tencent.mobileqq.wink.editor.sticker.f.t(winkStickerFrameLayout7, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_MODIFY_TIME_BUTTON, stickerModel);
                }
                if (com.tencent.videocut.render.extension.i.c(stickerModel, false, 1, null)) {
                    ArrayList<WinkStickerFrameLayout.MenuItem> arrayList11 = this.popupMenuItems;
                    WinkStickerFrameLayout.MenuItem menuItem11 = this.poiEditMenuItem;
                    if (menuItem11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("poiEditMenuItem");
                        menuItem11 = null;
                    }
                    arrayList11.add(menuItem11);
                    WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout8 = null;
                    }
                    com.tencent.mobileqq.wink.editor.sticker.f.t(winkStickerFrameLayout8, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_EDIT_LOCATION_BUTTON, stickerModel);
                }
                if (editMode == editMode2 && !isFromQZoneText) {
                    if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) >= 4) {
                        String a16 = i73.a.f407346a.a(stickerModel);
                        MetaMaterial material = stickerModel.getMaterial();
                        if (material != null && !com.tencent.mobileqq.wink.editor.sticker.m.T(material)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            if (!com.tencent.mobileqq.wink.editor.sticker.m.Q(stickerModel.getMaterial()) && stickerModel.getIsTraceSticker()) {
                                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList12 = this.popupMenuItems;
                                WinkStickerFrameLayout.MenuItem menuItem12 = this.traceOffMenuItem;
                                if (menuItem12 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("traceOffMenuItem");
                                    menuItem12 = null;
                                }
                                arrayList12.add(menuItem12);
                                WinkStickerFrameLayout winkStickerFrameLayout9 = this.winkStickerFrameLayout;
                                if (winkStickerFrameLayout9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                    winkStickerFrameLayout9 = null;
                                }
                                Jb(winkStickerFrameLayout9, a16, "cancel_track");
                            } else if (!com.tencent.mobileqq.wink.editor.sticker.m.Q(stickerModel.getMaterial()) && !stickerModel.getIsTraceSticker()) {
                                ArrayList<WinkStickerFrameLayout.MenuItem> arrayList13 = this.popupMenuItems;
                                WinkStickerFrameLayout.MenuItem menuItem13 = this.traceOnMenuItem;
                                if (menuItem13 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("traceOnMenuItem");
                                    menuItem13 = null;
                                }
                                arrayList13.add(menuItem13);
                                WinkStickerFrameLayout winkStickerFrameLayout10 = this.winkStickerFrameLayout;
                                if (winkStickerFrameLayout10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                    winkStickerFrameLayout10 = null;
                                }
                                Jb(winkStickerFrameLayout10, a16, "track");
                            }
                        }
                    }
                    if (stickerModel.isTextSticker() && this.textReadEnable) {
                        ArrayList<WinkStickerFrameLayout.MenuItem> arrayList14 = this.popupMenuItems;
                        WinkStickerFrameLayout.MenuItem menuItem14 = this.textReadMenuItem;
                        if (menuItem14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("textReadMenuItem");
                            menuItem14 = null;
                        }
                        arrayList14.add(menuItem14);
                        WinkStickerFrameLayout winkStickerFrameLayout11 = this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout11 = null;
                        }
                        Gb(winkStickerFrameLayout11);
                    }
                    WinkStickerFrameLayout winkStickerFrameLayout12 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout12 = null;
                    }
                    com.tencent.mobileqq.wink.editor.sticker.f.r(winkStickerFrameLayout12, false);
                }
                if (stickerModel.isTextSticker()) {
                    ArrayList<WinkStickerFrameLayout.MenuItem> arrayList15 = this.popupMenuItems;
                    WinkStickerFrameLayout.MenuItem menuItem15 = this.editMenuItem;
                    if (menuItem15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editMenuItem");
                        menuItem15 = null;
                    }
                    arrayList15.add(menuItem15);
                    WinkStickerFrameLayout winkStickerFrameLayout13 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout13 = null;
                    }
                    if (winkStickerFrameLayout13.getVisibility() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        W0(stickerModel);
                    }
                }
                MetaMaterial material2 = stickerModel.getMaterial();
                if (material2 != null && !com.tencent.mobileqq.wink.editor.sticker.m.T(material2)) {
                    z18 = true;
                }
                if (z18) {
                    ArrayList<WinkStickerFrameLayout.MenuItem> arrayList16 = this.popupMenuItems;
                    WinkStickerFrameLayout.MenuItem menuItem16 = this.deleteMenuItem;
                    if (menuItem16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deleteMenuItem");
                        menuItem16 = null;
                    }
                    arrayList16.add(menuItem16);
                }
            }
        }
        WinkStickerFrameLayout winkStickerFrameLayout14 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout = winkStickerFrameLayout14;
        }
        winkStickerFrameLayout.x(this.popupMenuItems);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x000c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void tc() {
        String next;
        GYTrackStickerInfo gYTrackStickerInfo;
        WinkStickerModel winkStickerModel;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel2;
        boolean z16;
        dr H9;
        com.tencent.videocut.model.Size size;
        dr H92;
        Integer num;
        Integer num2;
        boolean z17;
        boolean z18;
        Map<String, WinkStickerModel> m16;
        Iterator<String> it = this.traceStickers.keySet().iterator();
        while (it.hasNext() && (gYTrackStickerInfo = this.traceStickers.get((next = it.next()))) != null) {
            dr H93 = H9();
            if (H93 != null && (m16 = H93.m()) != null) {
                winkStickerModel = m16.get(next);
            } else {
                winkStickerModel = null;
            }
            if (winkStickerModel == null) {
                this.traceStickers.remove(next);
                return;
            }
            dr H94 = H9();
            if (H94 != null && (m3 = H94.m()) != null && (winkStickerModel2 = m3.get(next)) != null) {
                float f16 = gYTrackStickerInfo.imageH;
                boolean z19 = true;
                if (f16 == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    float f17 = gYTrackStickerInfo.imageW;
                    if (f17 == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        float f18 = gYTrackStickerInfo.f35991w;
                        if (f18 == 0.0f) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            float f19 = gYTrackStickerInfo.f35990h;
                            if (f19 != 0.0f) {
                                z19 = false;
                            }
                            if (!z19) {
                                double d16 = 2;
                                this.curCenterX = (((gYTrackStickerInfo.f35992x + (f18 * 0.5d)) / f17) - 0.5d) * d16;
                                this.curCenterY = (((gYTrackStickerInfo.f35993y + (f19 * 0.5d)) / f16) - 0.5d) * d16 * (-1);
                                this.curScaleX = gYTrackStickerInfo.f35991w / winkStickerModel2.width;
                                this.curScaleY = gYTrackStickerInfo.f35990h / winkStickerModel2.height;
                                H9 = H9();
                                if (H9 == null) {
                                    size = H9.getRenderSize();
                                } else {
                                    size = null;
                                }
                                WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, 0L, 0L, 0, this.curScaleX, this.curScaleY, 0.0f, (float) this.curCenterX, (float) this.curCenterY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -865, 1048575, null);
                                if (size != null && (num = size.width) != null) {
                                    int intValue = num.intValue();
                                    num2 = size.height;
                                    if (num2 != null) {
                                        winkStickerModel2.updatePositionInView(intValue, num2.intValue(), this.curScaleX, this.curScaleY, (float) this.curCenterX, (float) this.curCenterY);
                                    }
                                }
                                copyAndUpdate$default.setEntityName(winkStickerModel2.getEntityName());
                                copyAndUpdate$default.setTraceSticker(winkStickerModel2.getIsTraceSticker());
                                copyAndUpdate$default.setStickerTrackerResult(winkStickerModel2.getStickerTrackerResult());
                                H92 = H9();
                                if (H92 == null) {
                                    dr.b.n(H92, copyAndUpdate$default, false, 2, null);
                                }
                            }
                        }
                    }
                }
                this.curCenterX = -1.0d;
                this.curCenterY = -1.0d;
                this.curScaleX = gYTrackStickerInfo.f35991w / winkStickerModel2.width;
                this.curScaleY = gYTrackStickerInfo.f35990h / winkStickerModel2.height;
                H9 = H9();
                if (H9 == null) {
                }
                WinkStickerModel copyAndUpdate$default2 = WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, 0L, 0L, 0, this.curScaleX, this.curScaleY, 0.0f, (float) this.curCenterX, (float) this.curCenterY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -865, 1048575, null);
                if (size != null) {
                    int intValue2 = num.intValue();
                    num2 = size.height;
                    if (num2 != null) {
                    }
                }
                copyAndUpdate$default2.setEntityName(winkStickerModel2.getEntityName());
                copyAndUpdate$default2.setTraceSticker(winkStickerModel2.getIsTraceSticker());
                copyAndUpdate$default2.setStickerTrackerResult(winkStickerModel2.getStickerTrackerResult());
                H92 = H9();
                if (H92 == null) {
                }
            }
        }
    }

    private final void ub() {
        FrameLayout frameLayout = this.mFakeFeedTopPart;
        if (frameLayout != null && this.mFakeFeedInfoPart != null && this.mFakeFeedPersonalInfoPart != null) {
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.setVisibility(4);
            ConstraintLayout constraintLayout = this.mFakeFeedInfoPart;
            Intrinsics.checkNotNull(constraintLayout);
            constraintLayout.setVisibility(4);
            LinearLayout linearLayout = this.mFakeFeedPersonalInfoPart;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean uc(ICutSession iCutSession, ArrayList<GYTrackStickerInfo> stickerTrackerResult, String entityName, Entity entity, WinkStickerModel stickerModel) {
        WinkVideoTavCut winkVideoTavCut;
        IStickerUpdateCallback iStickerUpdateCallback;
        dr H9;
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) < 4) {
            return false;
        }
        dr H92 = H9();
        if (H92 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H92;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.T2(new f());
        }
        if (stickerTrackerResult == null || !(!stickerTrackerResult.isEmpty()) || entityName == null) {
            return false;
        }
        if (winkVideoTavCut != null) {
            iStickerUpdateCallback = winkVideoTavCut.getTraceStickerUpdateCallback();
        } else {
            iStickerUpdateCallback = null;
        }
        iCutSession.updateTrackedStickerPosition(stickerTrackerResult, entityName, entity, iStickerUpdateCallback);
        if (stickerModel != null) {
            stickerModel.setStickerTrackerResult(Ua(stickerTrackerResult));
        }
        if (stickerModel != null) {
            stickerModel.setEntityName(entityName);
        }
        if (stickerModel != null) {
            stickerModel.setTraceSticker(true);
        }
        if (stickerModel != null && (H9 = H9()) != null) {
            dr.b.n(H9, stickerModel, false, 2, null);
        }
        return true;
    }

    private final void wb(ImageView avatarView, TextView nameView) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorStickerControlPart$loadFeedInfoAsync$1(this, nameView, avatarView, null), 3, null);
    }

    private final boolean xb(MenuType menuType) {
        if (menuType != MenuType.SUBTITLE && menuType != MenuType.LYRIC_STICKER && menuType != MenuType.TEMPLATE_TEXT_LIST) {
            return true;
        }
        return false;
    }

    private final void yb() {
        dr H9 = H9();
        if (H9 != null) {
            if (H9.isPlaying()) {
                H9.pause();
            } else {
                H9.play();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void A3(@Nullable WinkStickerModel stickerModel) {
        MetaMaterial material;
        String str;
        if (stickerModel != null && (material = stickerModel.getMaterial()) != null && (str = material.authorName) != null) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TextView textView = null;
            if (str.length() <= 8) {
                TextView textView2 = this.authorInfoView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
                    textView2 = null;
                }
                textView2.setText("\u8d34\u7eb8\u521b\u4f5c\u8005\uff1a" + str);
            } else {
                TextView textView3 = this.authorInfoView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
                    textView3 = null;
                }
                String substring = str.substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                textView3.setText("\u8d34\u7eb8\u521b\u4f5c\u8005\uff1a" + substring + MiniBoxNoticeInfo.APPNAME_SUFFIX);
            }
            TextView textView4 = this.authorInfoView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            } else {
                textView = textView4;
            }
            textView.setVisibility(0);
            jc(this.isTimeline);
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.auhtorNameDisplayRunnable);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.auhtorNameDisplayRunnable, 3000L);
        }
        WinkStickerModel winkStickerModel = this.curStickerModel;
        Intrinsics.checkNotNull(winkStickerModel);
        Db(winkStickerModel);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f88414x0;
    }

    public final void Eb(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.traceDialog == null) {
            return;
        }
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_OR_CHAR, type);
        VideoReport.setElementId(this.traceDialog, WinkDaTongReportConstant.ElementId.EM_XSJ_TRACK_LOADING_PANEL);
        VideoReport.setElementParams(this.traceDialog, extParams);
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.traceDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.p0(WinkDaTongReportConstant.ElementId.EM_XSJ_CANCEL_TRACK_BUTTON, extParams);
        }
    }

    public final void Hb(@NotNull View view, @NotNull String type, @NotNull String content) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_OR_CHAR, type);
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PANNEL_COPYWRITER, content);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AUTO_CANCEL_TRACK_PANEL);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_AUTO_CANCEL_TRACK_PANEL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, extParams);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    @NotNull
    public RectF K0() {
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        float f16 = winkStickerFrameLayout.s().left;
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        float left = f16 + winkStickerFrameLayout3.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout4 = null;
        }
        float f17 = winkStickerFrameLayout4.s().top;
        WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout5 = null;
        }
        float top = f17 + winkStickerFrameLayout5.getTop();
        WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout6 = null;
        }
        float f18 = winkStickerFrameLayout6.s().right;
        WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout7 = null;
        }
        float left2 = f18 + winkStickerFrameLayout7.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout8 = null;
        }
        float f19 = winkStickerFrameLayout8.s().bottom;
        WinkStickerFrameLayout winkStickerFrameLayout9 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout2 = winkStickerFrameLayout9;
        }
        return new RectF(left, top, left2, f19 + winkStickerFrameLayout2.getTop());
    }

    public final void Kb(@NotNull View view, @NotNull String type, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_OR_CHAR, type);
        extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TRACK_SUCCESSFUL, Integer.valueOf(isSuccess ? 1 : 0));
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_TRACK_SUCCESS_PANEL);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TRACK_SUCCESS_PANEL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, extParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        M1();
    }

    public final void Lb(@Nullable WinkStickerModel winkStickerModel) {
        this.curStickerModel = winkStickerModel;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void M1() {
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        TextView textView = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.w();
        TextView textView2 = this.authorInfoView;
        if (textView2 != null) {
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void M3(@Nullable WinkStickerModel stickerModel) {
        ub();
        this.mStickIsMove = false;
        if (stickerModel != null) {
            if (stickerModel.isSubtitleSticker() || stickerModel.isLyricSticker()) {
                Bb(stickerModel);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        dr H9 = H9();
        if (H9 != null) {
            H9.addPlayerListener(new d());
        }
        G9().o3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerControlPart.Ab(WinkEditorStickerControlPart.this, (Boolean) obj);
            }
        });
    }

    public final boolean Ma(@NotNull ICutSession iCutSession, @Nullable WinkStickerModel stickerModel) {
        String entityName;
        WinkVideoTavCut winkVideoTavCut;
        Entity entity;
        boolean z16;
        WinkEditData K1;
        Map<String, WinkStickerModelExtra> stickerExtraMap;
        WinkStickerModelExtra winkStickerModelExtra;
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) >= 4 && stickerModel != null && (entityName = stickerModel.getEntityName()) != null) {
            w53.b.f(this.TAG, "cancelTracking start, " + entityName + ", iCutSession = " + iCutSession);
            dr H9 = H9();
            WinkVideoTavCut winkVideoTavCut2 = null;
            if (H9 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H9;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                entity = winkVideoTavCut.i1(entityName);
            } else {
                entity = null;
            }
            if (entity != null) {
                z16 = ICutSession.DefaultImpls.updateTrackedStickerPosition$default(iCutSession, null, entityName, entity, null, 8, null);
            } else {
                z16 = true;
            }
            w53.b.f(this.TAG, "cancelTracking isCancel = " + z16);
            if (z16) {
                stickerModel.setStickerTrackerResult(Ua(null));
                stickerModel.setTraceSticker(false);
                stickerModel.setEntityName(null);
                dr H92 = H9();
                if (H92 instanceof WinkVideoTavCut) {
                    winkVideoTavCut2 = (WinkVideoTavCut) H92;
                }
                if (winkVideoTavCut2 != null && (K1 = winkVideoTavCut2.K1()) != null && (stickerExtraMap = K1.getStickerExtraMap()) != null && (winkStickerModelExtra = stickerExtraMap.get(stickerModel.id)) != null) {
                    w53.b.f(this.TAG, "cancelTracking update extra");
                    winkStickerModelExtra.setStickerTrackerResult(stickerModel.getStickerTrackerResult());
                    winkStickerModelExtra.setTraceSticker(stickerModel.getIsTraceSticker());
                    winkStickerModelExtra.setEntityName(stickerModel.getEntityName());
                }
                this.traceStickers.remove(entityName);
                sc(stickerModel.id);
                this.finalTraceStickers.remove(entityName);
                w53.b.f(this.TAG, "cancelTracking end");
                return true;
            }
        }
        return false;
    }

    public final void Mb(boolean isFromQZoneText) {
        this.isFromQZoneText = isFromQZoneText;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public boolean N4() {
        boolean z16;
        MetaMaterial material;
        WinkStickerModel winkStickerModel = this.curStickerModel;
        if (winkStickerModel != null && (material = winkStickerModel.getMaterial()) != null && com.tencent.mobileqq.wink.editor.sticker.m.T(material)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (G9().getCurMenuType() != MenuType.TEMPLATE_TEXT_LIST && G9().getCurMenuType() != MenuType.LYRIC_STICKER) {
            return true;
        }
        return false;
    }

    @Nullable
    public final WinkStickerModel Ra(@NotNull WinkStickerModel stickerModel) {
        String str;
        boolean z16;
        Map<String, WinkStickerModel> map;
        String str2;
        boolean z17;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        MetaMaterial material = stickerModel.getMaterial();
        Object obj = null;
        if (material != null) {
            str = com.tencent.mobileqq.wink.editor.sticker.m.u(material);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        dr H9 = H9();
        if (H9 != null) {
            map = H9.m();
        } else {
            map = null;
        }
        Intrinsics.checkNotNull(map);
        Iterator<T> it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            WinkStickerModel winkStickerModel = (WinkStickerModel) next;
            MetaMaterial material2 = winkStickerModel.getMaterial();
            if (material2 != null) {
                str2 = com.tencent.mobileqq.wink.editor.sticker.m.u(material2);
            } else {
                str2 = null;
            }
            MetaMaterial material3 = stickerModel.getMaterial();
            Intrinsics.checkNotNull(material3);
            if (Intrinsics.areEqual(str2, com.tencent.mobileqq.wink.editor.sticker.m.u(material3)) && !Intrinsics.areEqual(winkStickerModel.id, stickerModel.id)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                obj = next;
                break;
            }
        }
        return (WinkStickerModel) obj;
    }

    public final void Sb(@Nullable final WinkStickerModel stickerModel) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.l
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorStickerControlPart.Tb(WinkEditorStickerControlPart.this, stickerModel);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0137, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, new com.tencent.mobileqq.wink.editor.sticker.control.y(r2));
     */
    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkStickerModel U(@NotNull PointF fingerOne, @NotNull PointF fingerTwo) {
        com.tencent.videocut.model.Size size;
        boolean z16;
        long j3;
        boolean z17;
        Map<String, WinkStickerModel> m3;
        List sortedWith;
        Object firstOrNull;
        WinkStickerModel winkStickerModel;
        Map<String, WinkStickerModel> m16;
        Collection<WinkStickerModel> values;
        Object first;
        Map<String, WinkStickerModel> m17;
        IPlayer currentPlayer;
        Map<String, WinkStickerModel> m18;
        Intrinsics.checkNotNullParameter(fingerOne, "fingerOne");
        Intrinsics.checkNotNullParameter(fingerTwo, "fingerTwo");
        dr H9 = H9();
        if (H9 != null) {
            size = H9.getRenderSize();
        } else {
            size = null;
        }
        if (size == null) {
            return null;
        }
        dr H92 = H9();
        boolean z18 = true;
        if (H92 != null && (m18 = H92.m()) != null && m18.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        dr H93 = H9();
        if (H93 != null && (currentPlayer = H93.getCurrentPlayer()) != null) {
            j3 = currentPlayer.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        dr H94 = H9();
        if (H94 != null && (m17 = H94.m()) != null && m17.size() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            dr H95 = H9();
            if (H95 != null && (m16 = H95.m()) != null && (values = m16.values()) != null) {
                first = CollectionsKt___CollectionsKt.first(values);
                winkStickerModel = (WinkStickerModel) first;
            } else {
                winkStickerModel = null;
            }
            if (winkStickerModel == null || !winkStickerModel.isVisibleAtCurrentPlayTime(j3)) {
                z18 = false;
            }
            if (!z18) {
                return null;
            }
            return winkStickerModel;
        }
        float f16 = fingerOne.x + fingerTwo.x;
        float f17 = 2;
        float f18 = fingerTwo.y;
        final PointF pointF = new PointF(f16 / f17, (f18 + f18) / f17);
        dr H96 = H9();
        if (H96 == null || (m3 = H96.m()) == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, WinkStickerModel> entry : m3.entrySet()) {
            if (entry.getValue().isVisibleAtCurrentPlayTime(j3)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            WinkStickerModel winkStickerModel2 = (WinkStickerModel) entry2.getValue();
            if (com.tencent.mobileqq.wink.utils.u.f326728a.m(fingerOne.x, fingerOne.y, fingerTwo.x, fingerTwo.y, winkStickerModel2.getLeftTopInView().f320587x, winkStickerModel2.getLeftTopInView().f320588y, winkStickerModel2.getRightBottomInView().f320587x, winkStickerModel2.getRightBottomInView().f320588y)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        Collection values2 = linkedHashMap2.values();
        if (values2 != null && sortedWith != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
            return (WinkStickerModel) firstOrNull;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    @NotNull
    public RectF U4() {
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        float f16 = winkStickerFrameLayout.v().left;
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        float left = f16 + winkStickerFrameLayout3.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout4 = null;
        }
        float f17 = winkStickerFrameLayout4.v().top;
        WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout5 = null;
        }
        float top = f17 + winkStickerFrameLayout5.getTop();
        WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout6 = null;
        }
        float f18 = winkStickerFrameLayout6.v().right;
        WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout7 = null;
        }
        float left2 = f18 + winkStickerFrameLayout7.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout8 = null;
        }
        float f19 = winkStickerFrameLayout8.v().bottom;
        WinkStickerFrameLayout winkStickerFrameLayout9 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout2 = winkStickerFrameLayout9;
        }
        return new RectF(left, top, left2, f19 + winkStickerFrameLayout2.getTop());
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void W0(@Nullable WinkStickerModel stickerModel) {
        if (G9().getCurMenuType() != MenuType.STICKER_TIMELINE) {
            MenuType curMenuType = G9().getCurMenuType();
            MenuType menuType = MenuType.TEMPLATE_TEXT_LIST;
            if (curMenuType != menuType) {
                this.curStickerModel = stickerModel;
                if (stickerModel != null) {
                    bb bbVar = null;
                    if (stickerModel.isSubtitleSticker()) {
                        WinkEditorViewModel.v5(G9(), MenuType.SUBTITLE, null, 2, null);
                        return;
                    }
                    if (stickerModel.isLyricSticker()) {
                        WinkEditorViewModel.v5(G9(), MenuType.LYRIC_STICKER, null, 2, null);
                        return;
                    }
                    if (stickerModel.isTemplateTextSticker()) {
                        if (G9().u4()) {
                            bb bbVar2 = this.winkEditorTemplateTextViewModel;
                            if (bbVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextViewModel");
                                bbVar2 = null;
                            }
                            bbVar2.F2(stickerModel);
                            WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
                            if (winkStickerFrameLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                winkStickerFrameLayout = null;
                            }
                            winkStickerFrameLayout.w();
                            bb bbVar3 = this.winkEditorTemplateTextViewModel;
                            if (bbVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextViewModel");
                            } else {
                                bbVar = bbVar3;
                            }
                            bbVar.I2(1);
                            return;
                        }
                        WinkEditorViewModel G9 = G9();
                        Bundle bundle = new Bundle();
                        bundle.putString("selected_sticker_uid", stickerModel.id);
                        Unit unit = Unit.INSTANCE;
                        G9.u5(menuType, bundle);
                        return;
                    }
                    if (stickerModel.isBackgroundTextSticker()) {
                        bb bbVar4 = this.winkEditorBackGroundTextViewModel;
                        if (bbVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorBackGroundTextViewModel");
                            bbVar4 = null;
                        }
                        bbVar4.F2(stickerModel);
                        WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout2 = null;
                        }
                        winkStickerFrameLayout2.w();
                        bb bbVar5 = this.winkEditorBackGroundTextViewModel;
                        if (bbVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorBackGroundTextViewModel");
                        } else {
                            bbVar = bbVar5;
                        }
                        bbVar.I2(2);
                        return;
                    }
                    if (stickerModel.isTextSticker()) {
                        if (stickerModel.isTemplateImageSticker()) {
                            ms.a.f(this.TAG, "isTemplateImageSticker Double-click not supported");
                            return;
                        }
                        bb bbVar6 = this.winkEditorTextViewModel;
                        if (bbVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
                            bbVar6 = null;
                        }
                        bbVar6.F2(stickerModel);
                        w2(stickerModel);
                        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout3 = null;
                        }
                        winkStickerFrameLayout3.w();
                        bb bbVar7 = this.winkEditorTextViewModel;
                        if (bbVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
                        } else {
                            bbVar = bbVar7;
                        }
                        bbVar.I2(0);
                        return;
                    }
                    ms.a.c(this.TAG, "sticker can not edit as text: " + this.curStickerModel);
                }
            }
        }
    }

    @Nullable
    public final String Xa() {
        WinkStickerModel winkStickerModel = this.curStickerModel;
        if (winkStickerModel != null) {
            return winkStickerModel.id;
        }
        return null;
    }

    @Nullable
    public final WinkStickerModel Ya() {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel = this.curStickerModel;
        if (winkStickerModel == null) {
            return null;
        }
        String str = winkStickerModel.id;
        dr H9 = H9();
        if (H9 == null || (m3 = H9.m()) == null) {
            return null;
        }
        return m3.get(str);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void Z0(@Nullable WinkStickerModel stickerModel) {
        boolean z16;
        int i3;
        Pair pair;
        if (G9().getCurMenuType() != MenuType.EFFECT && G9().getCurMenuType() != MenuType.TEMPLATE_COLL_CLIP) {
            boolean z17 = true;
            if (stickerModel != null && stickerModel.isMosaicDoodleSticker()) {
                z16 = true;
            } else {
                z16 = false;
            }
            WinkStickerFrameLayout winkStickerFrameLayout = null;
            if (z16) {
                WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                } else {
                    winkStickerFrameLayout = winkStickerFrameLayout2;
                }
                winkStickerFrameLayout.w();
                return;
            }
            TextView textView = this.authorInfoView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
                textView = null;
            }
            textView.setVisibility(4);
            this.curStickerModel = stickerModel;
            WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout3 = null;
            }
            winkStickerFrameLayout3.setEnableDeleteBtn(N4());
            WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout4 = null;
            }
            winkStickerFrameLayout4.setEnableCreatorInfoBtn(u8());
            if (G9().getCurMenuType() == MenuType.STICKER_TIMELINE) {
                if (stickerModel != null) {
                    WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout5 = null;
                    }
                    com.tencent.mobileqq.wink.editor.sticker.f.f(winkStickerFrameLayout5, stickerModel, true);
                    if (stickerModel.type == StickerModel.Type.BOTTOM_FRAME) {
                        pair = TuplesKt.to(Ra(stickerModel), stickerModel);
                    } else {
                        pair = TuplesKt.to(stickerModel, Ra(stickerModel));
                    }
                    WinkStickerModel winkStickerModel = (WinkStickerModel) pair.component1();
                    WinkStickerModel winkStickerModel2 = (WinkStickerModel) pair.component2();
                    if (winkStickerModel != null) {
                        WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
                        if (winkStickerFrameLayout6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                            winkStickerFrameLayout6 = null;
                        }
                        winkStickerFrameLayout6.h(winkStickerModel, winkStickerModel2, false);
                        broadcastMessage("ARGS_STICKER_ID", winkStickerModel.id);
                    }
                }
                if (stickerModel == null) {
                    WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout7 = null;
                    }
                    winkStickerFrameLayout7.w();
                    WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    } else {
                        winkStickerFrameLayout = winkStickerFrameLayout8;
                    }
                    winkStickerFrameLayout.setManualHide(true);
                    return;
                }
                return;
            }
            if (stickerModel == null) {
                WinkStickerFrameLayout winkStickerFrameLayout9 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout9 = null;
                }
                winkStickerFrameLayout9.w();
                WinkStickerFrameLayout winkStickerFrameLayout10 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout10 = null;
                }
                winkStickerFrameLayout10.setManualHide(true);
                MenuType curMenuType = G9().getCurMenuType();
                if (curMenuType == null) {
                    i3 = -1;
                } else {
                    i3 = b.f321592a[curMenuType.ordinal()];
                }
                switch (i3) {
                    case 1:
                        G9().Z1(MenuType.SUBTITLE_TEXT);
                        return;
                    case 2:
                        return;
                    case 3:
                        WinkEditorTemplateTextListViewModel winkEditorTemplateTextListViewModel = this.winkEditorTemplateTextListViewModel;
                        if (winkEditorTemplateTextListViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextListViewModel");
                            winkEditorTemplateTextListViewModel = null;
                        }
                        winkEditorTemplateTextListViewModel.R1(null);
                        return;
                    case 4:
                        yb();
                        return;
                    case 5:
                    case 6:
                    case 7:
                        return;
                    case 8:
                        G9().Z1(MenuType.STICKER);
                        return;
                    default:
                        G9().l5();
                        return;
                }
            }
            WinkEditorFragment F9 = F9();
            if (F9 == null || !F9.Hk()) {
                z17 = false;
            }
            if (z17) {
                return;
            }
            tb(stickerModel, G9().getEditMode(), G9().getIsFromQzoneText());
            WinkStickerFrameLayout winkStickerFrameLayout11 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout11 = null;
            }
            winkStickerFrameLayout11.h(stickerModel, Ra(stickerModel), xb(G9().getCurMenuType()));
            if (G9().getCurMenuType() == MenuType.TEMPLATE_TEXT_LIST) {
                WinkEditorTemplateTextListViewModel winkEditorTemplateTextListViewModel2 = this.winkEditorTemplateTextListViewModel;
                if (winkEditorTemplateTextListViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextListViewModel");
                    winkEditorTemplateTextListViewModel2 = null;
                }
                winkEditorTemplateTextListViewModel2.R1(stickerModel);
            }
            if (G9().getCurMenuType() == MenuType.VIDEO_TEMPLATE || G9().getCurMenuType() == MenuType.FILTER || G9().getCurMenuType() == MenuType.MUSIC) {
                G9().l5();
            }
            WinkStickerFrameLayout winkStickerFrameLayout12 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            } else {
                winkStickerFrameLayout = winkStickerFrameLayout12;
            }
            com.tencent.mobileqq.wink.editor.sticker.f.f(winkStickerFrameLayout, stickerModel, false);
        }
    }

    /* renamed from: bb, reason: from getter */
    public final boolean getMStickIsMove() {
        return this.mStickIsMove;
    }

    public final void bc(@Nullable WinkStickerModel stickerModel) {
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) < 4) {
            return;
        }
        if ((stickerModel != null && stickerModel.getIsTraceSticker()) || this.stickerTrackerManager == null) {
            return;
        }
        if (stickerModel == null) {
            WinkStickerModel winkStickerModel = this.curStickerModel;
            if (winkStickerModel != null) {
                winkStickerModel.setTraceSticker(false);
            }
        } else {
            this.curStickerModel = stickerModel;
            stickerModel.setTraceSticker(false);
        }
        StickerTrackerManager stickerTrackerManager = this.stickerTrackerManager;
        if (stickerTrackerManager != null) {
            stickerTrackerManager.l0();
        }
        hb();
    }

    public final void cc(boolean enable) {
        this.textReadEnable = enable;
    }

    public void dc(@Nullable WinkStickerModel stickerModel) {
        this.curStickerModel = stickerModel;
        if (stickerModel != null) {
            WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout = null;
            }
            winkStickerFrameLayout.w();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        if (r11.s().contains(r9, r10) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0120, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r9, new com.tencent.mobileqq.wink.editor.sticker.control.h());
     */
    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkStickerModel e1(float eventX, float eventY, float screenX, float screenY) {
        long j3;
        Map<String, WinkStickerModel> m3;
        List sortedWith;
        Object firstOrNull;
        boolean isVisibleAtCurrentPlayTime;
        Map<String, WinkStickerModel> m16;
        IPlayer currentPlayer;
        WinkStickerModel winkStickerModel = null;
        String str = null;
        r0 = null;
        WinkStickerModel winkStickerModel2 = null;
        winkStickerModel = null;
        winkStickerModel = null;
        winkStickerModel = null;
        if (G9().getCurMenuType() == MenuType.TEMPLATE_COLL_CLIP) {
            return null;
        }
        tc();
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        float top = eventY - winkStickerFrameLayout.getTop();
        WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout2 = null;
        }
        float left = eventX - winkStickerFrameLayout2.getLeft();
        dr H9 = H9();
        if (H9 != null && (currentPlayer = H9.getCurrentPlayer()) != null) {
            j3 = currentPlayer.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        if (winkStickerFrameLayout3.getVisibility() == 0) {
            WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout4 = null;
            }
            if (!winkStickerFrameLayout4.v().contains(left, top)) {
                WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout5 = null;
                }
            }
            dr H92 = H9();
            if (H92 != null && (m16 = H92.m()) != null) {
                WinkStickerModel winkStickerModel3 = this.curStickerModel;
                if (winkStickerModel3 != null) {
                    str = winkStickerModel3.id;
                }
                winkStickerModel2 = m16.get(str);
            }
            this.curStickerModel = winkStickerModel2;
            return winkStickerModel2;
        }
        dr H93 = H9();
        if (H93 != null && (m3 = H93.m()) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, WinkStickerModel> entry : m3.entrySet()) {
                WinkStickerModel value = entry.getValue();
                com.tencent.mobileqq.wink.utils.u uVar = com.tencent.mobileqq.wink.utils.u.f326728a;
                WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout6 = null;
                }
                if (uVar.l(left, top, winkStickerFrameLayout6.q(value), -value.rotate)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                WinkStickerModel winkStickerModel4 = (WinkStickerModel) entry2.getValue();
                if (H9() instanceof WinkImageTavCut) {
                    isVisibleAtCurrentPlayTime = true;
                } else {
                    isVisibleAtCurrentPlayTime = winkStickerModel4.isVisibleAtCurrentPlayTime(j3);
                }
                if (isVisibleAtCurrentPlayTime) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            Collection values = linkedHashMap2.values();
            if (values != null && sortedWith != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
                winkStickerModel = (WinkStickerModel) firstOrNull;
            }
        }
        this.curStickerModel = winkStickerModel;
        return winkStickerModel;
    }

    public void ec(@Nullable WinkStickerModel stickerModel) {
        this.curStickerModel = stickerModel;
        if (stickerModel != null) {
            WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout = null;
            }
            winkStickerFrameLayout.w();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void f3(@Nullable WinkStickerModel stickerModel) {
        StickerModel.Type type;
        StickerModel.Type type2;
        if (stickerModel != null) {
            type = stickerModel.type;
        } else {
            type = null;
        }
        if (type != StickerModel.Type.TOP_FRAME) {
            if (stickerModel != null) {
                type2 = stickerModel.type;
            } else {
                type2 = null;
            }
            if (type2 != StickerModel.Type.BOTTOM_FRAME) {
                return;
            }
        }
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.m(stickerModel, null);
    }

    public final void gc(@NotNull ICutSession iCutSession, @Nullable WinkStickerModel model) {
        WinkStickerModel rc5;
        WinkVideoTavCut winkVideoTavCut;
        StickerTrackerManager stickerTrackerManager;
        boolean z16;
        MutableLiveData<Boolean> u36;
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) >= 4 && (rc5 = rc(model)) != null && rc5.getMaterial() != null && !com.tencent.mobileqq.wink.editor.sticker.m.Q(rc5.getMaterial())) {
            dr H9 = H9();
            if (H9 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H9;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                MusicSourceViewModel cb5 = cb();
                if (cb5 != null && (u36 = cb5.u3()) != null) {
                    z16 = Intrinsics.areEqual(u36.getValue(), Boolean.TRUE);
                } else {
                    z16 = false;
                }
                if (z16) {
                    winkVideoTavCut.W2(false);
                }
                winkVideoTavCut.O3(0.0f);
                dr.b.m(winkVideoTavCut, 0.0f, null, 2, null);
                winkVideoTavCut.b0(0.0f, AudioModel.Type.TTS);
            }
            sd4.b bVar = new sd4.b(this.modelPaths, u53.b.f438377h + File.separator, rc5.id, null, 8, null);
            Cb();
            this.stickerTrackerManager = new StickerTrackerManager();
            if (rc5.getIsTraceSticker()) {
                Ma(iCutSession, rc5);
            }
            StickerTrackerManager stickerTrackerManager2 = this.stickerTrackerManager;
            Intrinsics.checkNotNull(stickerTrackerManager2);
            if (iCutSession.createStickerTrackerManager(stickerTrackerManager2, bVar) == 0 && (H9() instanceof WinkVideoTavCut) && (stickerTrackerManager = this.stickerTrackerManager) != null && winkVideoTavCut != null) {
                Intrinsics.checkNotNull(stickerTrackerManager);
                winkVideoTavCut.Y2(stickerTrackerManager, bVar, rc5, new e(iCutSession, rc5, winkVideoTavCut));
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ImagePageTouchEvent.class);
        arrayList.add(WinkPlayerControlEvent.class);
        arrayList.add(StickerEditEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    @NotNull
    public RectF h3() {
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        float f16 = winkStickerFrameLayout.r().left;
        WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout3 = null;
        }
        float left = f16 + winkStickerFrameLayout3.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout4 = null;
        }
        float f17 = winkStickerFrameLayout4.r().top;
        WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout5 = null;
        }
        float top = f17 + winkStickerFrameLayout5.getTop();
        WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout6 = null;
        }
        float f18 = winkStickerFrameLayout6.r().right;
        WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout7 = null;
        }
        float left2 = f18 + winkStickerFrameLayout7.getLeft();
        WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout8 = null;
        }
        float f19 = winkStickerFrameLayout8.r().bottom;
        WinkStickerFrameLayout winkStickerFrameLayout9 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout2 = winkStickerFrameLayout9;
        }
        return new RectF(left, top, left2, f19 + winkStickerFrameLayout2.getTop());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        dr H9;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        super.handleBroadcastMessage(action, args);
        WinkStickerFrameLayout winkStickerFrameLayout = null;
        if (((Intrinsics.areEqual(action, "ARGS_SWITCH_STICKER_IN_TIMELINE_SETTING") && (args instanceof String)) || (Intrinsics.areEqual(action, "ARGS_SWITCH_STICKER_IN_TEMPLATE_TEXT_LIST_SETTING") && (args instanceof String))) && (H9 = H9()) != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(args)) != null) {
            if (winkStickerModel.getIsTraceSticker()) {
                dr H92 = H9();
                boolean z16 = false;
                if (H92 != null && H92.isPlaying()) {
                    z16 = true;
                }
                if (z16) {
                    WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout2 = null;
                    }
                    winkStickerFrameLayout2.o(winkStickerModel, Ra(winkStickerModel));
                } else {
                    tc();
                    WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                        winkStickerFrameLayout3 = null;
                    }
                    winkStickerFrameLayout3.k(winkStickerModel, Ra(winkStickerModel));
                }
            } else {
                WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    winkStickerFrameLayout4 = null;
                }
                winkStickerFrameLayout4.k(winkStickerModel, Ra(winkStickerModel));
            }
            this.curStickerModel = winkStickerModel;
        }
        if (Intrinsics.areEqual(action, "ARGS_SWITCH_STICKER_IN_TEMPLATE_TEXT_LIST_SETTING") && args == null) {
            WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                winkStickerFrameLayout5 = null;
            }
            winkStickerFrameLayout5.w();
        }
        WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout6 = null;
        }
        winkStickerFrameLayout6.setEnableDeleteBtn(N4());
        WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
        } else {
            winkStickerFrameLayout = winkStickerFrameLayout7;
        }
        winkStickerFrameLayout.setEnableCreatorInfoBtn(u8());
    }

    public final void hb() {
        hc();
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.traceDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.x
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorStickerControlPart.ib();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ViewModel viewModel = getViewModel(bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorTextViewModel::class.java)");
        this.winkEditorTextViewModel = (bb) viewModel;
        ViewModel viewModel2 = getViewModel("template_", bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(\n          \u2026del::class.java\n        )");
        this.winkEditorTemplateTextViewModel = (bb) viewModel2;
        ViewModel viewModel3 = getViewModel("template_", bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(\n          \u2026del::class.java\n        )");
        this.winkEditorBackGroundTextViewModel = (bb) viewModel3;
        ViewModel viewModel4 = getViewModel(WinkEditorTemplateTextListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "getViewModel(\n          \u2026del::class.java\n        )");
        this.winkEditorTemplateTextListViewModel = (WinkEditorTemplateTextListViewModel) viewModel4;
        ViewModel viewModel5 = getViewModel(com.tencent.mobileqq.wink.editor.tts.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "getViewModel(WinkTTSViewModel::class.java)");
        this.mTTSViewMode = (com.tencent.mobileqq.wink.editor.tts.e) viewModel5;
        this.timelineMenuItem = new WinkStickerFrameLayout.MenuItem(1, R.string.f239787ne, R.drawable.f162683m41);
        this.traceOnMenuItem = new WinkStickerFrameLayout.MenuItem(6, R.string.f239807ng, R.drawable.f162685m43);
        this.traceOffMenuItem = new WinkStickerFrameLayout.MenuItem(7, R.string.f239797nf, R.drawable.f162684m42);
        this.editMenuItem = new WinkStickerFrameLayout.MenuItem(2, R.string.f239717n8, R.drawable.m3z);
        this.deleteMenuItem = new WinkStickerFrameLayout.MenuItem(3, R.string.f239687n5, R.drawable.m3x);
        this.textReadMenuItem = new WinkStickerFrameLayout.MenuItem(10, R.string.f239777nd, R.drawable.m4v);
        this.subtitleEditMenuItem = new WinkStickerFrameLayout.MenuItem(4, R.string.f239757nb, R.drawable.oql);
        this.subtitleDeleteMenuItem = new WinkStickerFrameLayout.MenuItem(5, R.string.f239707n7, R.drawable.nrk);
        this.lyricEditMenuItem = new WinkStickerFrameLayout.MenuItem(8, R.string.f239737n_, R.drawable.f162053nr3);
        this.lyricDeleteMenuItem = new WinkStickerFrameLayout.MenuItem(9, R.string.f239697n6, R.drawable.nrk);
        this.timeEditMenuItem = new WinkStickerFrameLayout.MenuItem(11, R.string.f239767nc, R.drawable.f162682m40);
        this.poiEditMenuItem = new WinkStickerFrameLayout.MenuItem(12, R.string.f239747na, R.drawable.m3y);
        lb(rootView);
        jb(rootView);
        qb();
        sb();
    }

    public final void jc(boolean isTimeline) {
        TextView textView = null;
        if (isTimeline) {
            TextView textView2 = this.authorInfoView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
                textView2 = null;
            }
            textView2.setTextSize(13.0f);
            TextView textView3 = this.authorInfoView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            } else {
                textView = textView3;
            }
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).bottomMargin = ViewUtils.dip2px(56.31f);
            return;
        }
        TextView textView4 = this.authorInfoView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
            textView4 = null;
        }
        textView4.setTextSize(16.0f);
        TextView textView5 = this.authorInfoView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorInfoView");
        } else {
            textView = textView5;
        }
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams2)).bottomMargin = ViewUtils.dip2px(90.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        M1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Cb();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        int i3;
        WinkStickerModel winkStickerModel;
        WinkStickerFrameLayout winkStickerFrameLayout = null;
        if (event instanceof ImagePageTouchEvent) {
            WinkStickerFrameLayout winkStickerFrameLayout2 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            } else {
                winkStickerFrameLayout = winkStickerFrameLayout2;
            }
            winkStickerFrameLayout.w();
            return;
        }
        if (event instanceof WinkPlayerControlEvent) {
            if (((WinkPlayerControlEvent) event).mEventType == 3) {
                WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
                if (winkStickerFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                } else {
                    winkStickerFrameLayout = winkStickerFrameLayout3;
                }
                winkStickerFrameLayout.w();
                return;
            }
            return;
        }
        if (event instanceof StickerEditEvent) {
            int i16 = ((StickerEditEvent) event).mEventType;
            int i17 = 0;
            if (i16 != 10) {
                if (i16 != 15) {
                    boolean z17 = true;
                    switch (i16) {
                        case 1:
                            this.isTimeline = true;
                            dr H9 = H9();
                            if (H9 == null) {
                                z16 = true;
                            } else {
                                z16 = H9 instanceof WinkVideoTavCut;
                            }
                            if (z16 && this.curStickerModel != null) {
                                WinkStickerFrameLayout winkStickerFrameLayout4 = this.winkStickerFrameLayout;
                                if (winkStickerFrameLayout4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                } else {
                                    winkStickerFrameLayout = winkStickerFrameLayout4;
                                }
                                winkStickerFrameLayout.w();
                                jc(true);
                                return;
                            }
                            return;
                        case 2:
                            this.isTimeline = false;
                            WinkStickerModel Ya = Ya();
                            this.curStickerModel = Ya;
                            if (Ya != null) {
                                WinkStickerFrameLayout winkStickerFrameLayout5 = this.winkStickerFrameLayout;
                                if (winkStickerFrameLayout5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                } else {
                                    winkStickerFrameLayout = winkStickerFrameLayout5;
                                }
                                winkStickerFrameLayout.D(Ya);
                                jc(false);
                                return;
                            }
                            return;
                        case 3:
                            FrameLayout frameLayout = this.playerContainerWrapper;
                            if (frameLayout != null) {
                                i3 = frameLayout.getMeasuredHeight();
                            } else {
                                i3 = 0;
                            }
                            FrameLayout frameLayout2 = this.playerContainerWrapper;
                            if (frameLayout2 != null) {
                                i17 = frameLayout2.getMeasuredWidth();
                            }
                            nc(i3, i17, this.smallMargins);
                            dr H92 = H9();
                            if (H92 != null) {
                                z17 = H92 instanceof WinkVideoTavCut;
                            }
                            if (z17) {
                                WinkStickerFrameLayout winkStickerFrameLayout6 = this.winkStickerFrameLayout;
                                if (winkStickerFrameLayout6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                    winkStickerFrameLayout6 = null;
                                }
                                if (!winkStickerFrameLayout6.getManualHide() && (winkStickerModel = this.curStickerModel) != null) {
                                    WinkStickerFrameLayout winkStickerFrameLayout7 = this.winkStickerFrameLayout;
                                    if (winkStickerFrameLayout7 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                                    } else {
                                        winkStickerFrameLayout = winkStickerFrameLayout7;
                                    }
                                    winkStickerFrameLayout.F(winkStickerModel);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 4:
                            q9(R.string.f21898657);
                            return;
                        case 5:
                            q9(R.string.f2190265a);
                            return;
                        case 6:
                            q9(R.string.f2190165_);
                            return;
                        case 7:
                            q9(R.string.f21900659);
                            return;
                        default:
                            return;
                    }
                }
                WinkStickerModel winkStickerModel2 = this.curStickerModel;
                if (winkStickerModel2 != null && winkStickerModel2.getIsTraceSticker()) {
                    WinkStickerFrameLayout winkStickerFrameLayout8 = this.winkStickerFrameLayout;
                    if (winkStickerFrameLayout8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
                    } else {
                        winkStickerFrameLayout = winkStickerFrameLayout8;
                    }
                    winkStickerFrameLayout.F(winkStickerModel2);
                    return;
                }
                return;
            }
            if (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip) {
                q9(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void q9(int tipId) {
        if (tipId == R.string.f21898657) {
            Ka(this.curStickerModel, tipId, false);
            return;
        }
        if (tipId == R.string.f2190265a) {
            La(tipId);
            return;
        }
        if (tipId == R.string.f2190165_) {
            La(tipId);
            return;
        }
        if (tipId == R.string.f21900659) {
            bb bbVar = this.winkEditorTextViewModel;
            if (bbVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
                bbVar = null;
            }
            MetaMaterial value = bbVar.S1().getValue();
            bb bbVar2 = this.winkEditorTextViewModel;
            if (bbVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
                bbVar2 = null;
            }
            WinkStickerModel b26 = bbVar2.b2();
            if (value != null && com.tencent.mobileqq.wink.editor.sticker.m.X(value) && b26 != null && b26.getIsTraceSticker()) {
                Ka(b26, tipId, true);
                bb bbVar3 = this.winkEditorTextViewModel;
                if (bbVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
                    bbVar3 = null;
                }
                bbVar3.D2(null);
                return;
            }
            return;
        }
        if (tipId == R.string.f21897656) {
            Ka(this.curStickerModel, tipId, false);
        } else if (tipId == 0) {
            La(tipId);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public boolean u8() {
        String str;
        MetaMaterial material;
        WinkStickerModel winkStickerModel = this.curStickerModel;
        if (winkStickerModel != null && (material = winkStickerModel.getMaterial()) != null) {
            str = material.authorName;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public final boolean vb() {
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        if (winkStickerFrameLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void w2(@Nullable WinkStickerModel stickerModel) {
        WinkEditorFragment winkEditorFragment;
        List<? extends WinkStickerModel> listOf;
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof WinkEditorFragment) {
            winkEditorFragment = (WinkEditorFragment) hostFragment;
        } else {
            winkEditorFragment = null;
        }
        if (winkEditorFragment != null) {
            winkEditorFragment.Bn();
        }
        if (stickerModel != null && stickerModel.isLyricSticker()) {
            this.curStickerModel = null;
            Oa();
        } else {
            if (stickerModel != null && stickerModel.isSubtitleSticker()) {
                Nb();
                return;
            }
            this.curStickerModel = null;
            if (stickerModel != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(stickerModel);
                Pa(listOf);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
    public void y2(@NotNull WinkStickerModel stickerModel, @Nullable PointF correctPoint, boolean isMove) {
        long j3;
        IPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        this.mStickIsMove = true;
        this.curStickerModel = stickerModel;
        dr H9 = H9();
        if (H9 != null) {
            H9.t(stickerModel, true);
        }
        WinkStickerFrameLayout winkStickerFrameLayout = this.winkStickerFrameLayout;
        WinkStickerFrameLayout winkStickerFrameLayout2 = null;
        if (winkStickerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            winkStickerFrameLayout = null;
        }
        winkStickerFrameLayout.D(stickerModel);
        if (isMove) {
            WinkStickerFrameLayout winkStickerFrameLayout3 = this.winkStickerFrameLayout;
            if (winkStickerFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkStickerFrameLayout");
            } else {
                winkStickerFrameLayout2 = winkStickerFrameLayout3;
            }
            winkStickerFrameLayout2.w();
        }
        dr H92 = H9();
        if (H92 != null && (currentPlayer = H92.getCurrentPlayer()) != null) {
            j3 = currentPlayer.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        if (stickerModel.isVisibleAtCurrentPlayTime(j3)) {
            Qb();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "p0", "", "onAnimationCancel", "onAnimationRepeat", "animation", "onAnimationEnd", "", "isReverse", "onAnimationStart", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
            WinkEditorStickerControlPart.this.isShowTraceTips = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TextView textView = WinkEditorStickerControlPart.this.showTraceTips;
            if (textView != null) {
                textView.setVisibility(8);
            }
            WinkEditorStickerControlPart.this.isShowTraceTips = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            TextView textView = WinkEditorStickerControlPart.this.showTraceTips;
            if (textView != null) {
                textView.setVisibility(0);
            }
            WinkEditorStickerControlPart.this.isShowTraceTips = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pb(DialogInterface dialogInterface, int i3) {
    }
}
