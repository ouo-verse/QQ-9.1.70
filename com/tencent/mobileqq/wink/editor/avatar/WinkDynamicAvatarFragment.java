package com.tencent.mobileqq.wink.editor.avatar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.multitouchview.PhotoViewAttacher;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.utils.r;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b%*\u0002y}\u0018\u0000 \u00c4\u00012\u00020\u0001:\u0002\u00c5\u0001B\t\u00a2\u0006\u0006\b\u00c2\u0001\u0010\u00c3\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J7\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001aH\u0014J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010%\u001a\u00020\u001aH\u0014J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020\u0015H\u0014J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u00109\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00102\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u00102\u001a\u0004\bF\u0010GR\u001b\u0010K\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00102\u001a\u0004\bJ\u0010GR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u00102\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u00102\u001a\u0004\bR\u0010BR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u00102\u001a\u0004\bV\u0010WR\u001b\u0010[\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u00102\u001a\u0004\bZ\u0010GR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u00102\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u00102\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u00102\u001a\u0004\bh\u0010iR\u001b\u0010n\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u00102\u001a\u0004\bl\u0010mR\u001b\u0010q\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u00102\u001a\u0004\bp\u0010mR\u001b\u0010t\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u00102\u001a\u0004\bs\u0010mR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR \u0010\u0085\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0082\u0001\u00102\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R!\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u00a0\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010QR.\u0010\u00a5\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00a1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a2\u0001\u00102\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R \u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a6\u0001\u00102\u001a\u0005\b\u00a7\u0001\u0010mR\u001e\u0010\u00ab\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a9\u0001\u00102\u001a\u0005\b\u00aa\u0001\u0010mR\u001e\u0010\u00ae\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00ac\u0001\u00102\u001a\u0005\b\u00ad\u0001\u0010mR\u001e\u0010\u00b1\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00af\u0001\u00102\u001a\u0005\b\u00b0\u0001\u0010mR\u001e\u0010\u00b4\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b2\u0001\u00102\u001a\u0005\b\u00b3\u0001\u0010mR\u001f\u0010\u00b8\u0001\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b5\u0001\u00102\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u0019\u0010\u00ba\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u008e\u0001R\u0019\u0010\u00bc\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u008e\u0001R\u0016\u0010\u00be\u0001\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00bd\u0001\u0010mR\u0017\u0010\u00c1\u0001\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00c6\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "Hi", "playerContainer", "", "Gi", "initView", "Qi", "gi", "ii", "", "t", WidgetCacheLunarData.JI, "Lorg/light/lightAssetKit/components/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Landroid/graphics/Rect;", "videoRect", "", "videoDuration", "Lkotlin/Pair;", "", "hi", "(Lorg/light/lightAssetKit/components/Size;Landroid/graphics/Rect;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fi", "(Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "index", "Pi", "Ii", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "", "needAdjustImmersive", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "zi", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "root", "D", "vi", "()Landroid/view/View;", "hole", "Lcom/tencent/mobileqq/wink/editor/avatar/HoleView;", "E", "wi", "()Lcom/tencent/mobileqq/wink/editor/avatar/HoleView;", "holeMask", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "ni", "()Landroid/widget/ImageView;", "back", "Landroid/widget/TextView;", "G", "getTitle", "()Landroid/widget/TextView;", "title", "H", "pi", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "Landroid/widget/FrameLayout;", "I", "getBottomBg", "()Landroid/widget/FrameLayout;", "bottomBg", "J", "xi", "playerToggle", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView;", "K", "Ai", "()Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView;", "segClipView", "L", "Bi", "setStaticAvatar", "Landroid/widget/Space;", "M", "getChangeDurationArea", "()Landroid/widget/Space;", "changeDurationArea", "Landroid/widget/LinearLayout;", "N", "qi", "()Landroid/widget/LinearLayout;", "durations", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "P", "Di", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ki", "()Ljava/lang/String;", "apngCachePath", BdhLogUtil.LogTag.Tag_Req, "Ci", "staticFramePath", ExifInterface.LATITUDE_SOUTH, "Ei", "userStaticFrameCroppedPath", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "T", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "segClipData", "com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$f", "U", "Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$f;", "playerListener", "com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$g", "V", "Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$g;", "renderListener", "Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader;", "W", "mi", "()Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader;", "avatarUploader", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "X", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "Lkotlinx/coroutines/Job;", "Y", "Lkotlinx/coroutines/Job;", "genJob", "Z", "Lorg/light/lightAssetKit/components/Size;", "outputSize", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "a0", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "cut", "b0", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "c0", "Landroidx/activity/result/ActivityResultLauncher;", "resultLauncher", "d0", "Ljava/lang/String;", "userStaticFrame", "e0", "userStaticFrameAbsTime", "", "f0", "li", "()Ljava/util/Map;", "attrMap", "g0", "Fi", "videoPath", "h0", "ti", "fromEntrance", "i0", WidgetCacheLunarData.YI, "profileType", "j0", "getFeedId", "feedId", "k0", "ri", "feedOwner", "l0", "si", "()J", "feedTime", "m0", "hasDragScreen", "n0", "hasDragClip", "oi", "cachePathPrefix", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Z", "hasUserStaticFrame", "<init>", "()V", "p0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkDynamicAvatarFragment extends ImmersivePartFragment {

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    private static final Lazy<String> f318953q0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy root;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy hole;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy holeMask;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy back;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy confirm;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomBg;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerToggle;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy segClipView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy setStaticAvatar;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy changeDurationArea;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy durations;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy apngCachePath;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy staticFramePath;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy userStaticFrameCroppedPath;

    /* renamed from: T, reason: from kotlin metadata */
    private WinkSegClipView.SegClipModel segClipData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final f playerListener;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final g renderListener;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarUploader;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private Job genJob;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Size outputSize;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private WinkVideoTavCut cut;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private WinkPlayerContainerView playerContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ActivityResultLauncher<Intent> resultLauncher;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String userStaticFrame;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long userStaticFrameAbsTime;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy attrMap;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoPath;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fromEntrance;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy profileType;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedId;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedOwner;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedTime;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean hasDragScreen;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean hasDragClip;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f318968o0 = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$a;", "", "", "PROFILE_SCHEMA$delegate", "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "PROFILE_SCHEMA", "KEY_PHOTO_FILE_PATH", "Ljava/lang/String;", "KEY_PHOTO_SELECT_TIME", "KEY_VIDEO_DURATION", "KEY_VIDEO_FILE_PATH", "KEY_VIDEO_SELECT_DURATION", "KEY_VIDEO_START_TIME", "KEY_VIDEO_SYNC_FRAME", "PARAM_SOURCE", "", "SOURCE_WINK_AVATAR_STATIC_FRAME", "I", "STATIC_AVATAR_ACTIVITY", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            return (String) WinkDynamicAvatarFragment.f318953q0.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$b", "Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", "", "frameNum", "", "frameTs", "Landroid/graphics/Bitmap;", "croppedBitmap", "", "onCropFrame", "beforeEncode", "", "t", "onError", "", "outputPath", "onEncoded", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ApngAvatarGenerator.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f318970b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f318971c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<String, String>> f318972d;

        /* JADX WARN: Multi-variable type inference failed */
        b(long j3, Ref.LongRef longRef, CancellableContinuation<? super Pair<String, String>> cancellableContinuation) {
            this.f318970b = j3;
            this.f318971c = longRef;
            this.f318972d = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void beforeCaptureFrame(int i3, long j3) {
            ApngAvatarGenerator.b.a.a(this, i3, j3);
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void beforeEncode() {
            Map mapOf;
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - this.f318970b)));
            com.tencent.mobileqq.wink.report.e.o(eVar, WinkDengtaReportConstant.Action.WEZONE_DYNAMIC_AVATAR_FRAME_COST, mapOf, false, 4, null);
            this.f318971c.element = SystemClock.elapsedRealtime();
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onAddFrame(int i3) {
            ApngAvatarGenerator.b.a.b(this, i3);
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onCaptureFrame(int i3, long j3, @Nullable Bitmap bitmap) {
            ApngAvatarGenerator.b.a.c(this, i3, j3, bitmap);
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onCropFrame(int frameNum, long frameTs, @Nullable Bitmap croppedBitmap) {
            w53.b.f(WinkDynamicAvatarFragment.this.getTAG(), "ApngAvatarGenerator: onCropFrame  " + frameNum + " " + frameTs);
            if (frameNum == 0 && croppedBitmap != null) {
                w53.b.f(WinkDynamicAvatarFragment.this.getTAG(), "ApngAvatarGenerator: shave first frame as static avatar");
                com.tencent.mobileqq.wink.utils.f.t(WinkDynamicAvatarFragment.this.Ci(), croppedBitmap);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onEncoded(@NotNull String outputPath) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(outputPath, "outputPath");
            w53.b.f(WinkDynamicAvatarFragment.this.getTAG(), "ApngAvatarGenerator: " + outputPath);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - this.f318971c.element)), TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_APNG_SIZE, String.valueOf(new File(outputPath).length())));
            com.tencent.mobileqq.wink.report.e.o(eVar, WinkDengtaReportConstant.Action.WEZONE_DYNAMIC_AVATAR_APNG_COST, mapOf, false, 4, null);
            if (WinkDynamicAvatarFragment.this.ui()) {
                CancellableContinuation<Pair<String, String>> cancellableContinuation = this.f318972d;
                Result.Companion companion = Result.INSTANCE;
                String str = WinkDynamicAvatarFragment.this.userStaticFrame;
                Intrinsics.checkNotNull(str);
                cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(str, outputPath)));
                return;
            }
            CancellableContinuation<Pair<String, String>> cancellableContinuation2 = this.f318972d;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(TuplesKt.to(WinkDynamicAvatarFragment.this.Ci(), outputPath)));
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onError(@NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            w53.b.c(WinkDynamicAvatarFragment.this.getTAG(), "ApngAvatarGenerator: onError  " + t16);
            CancellableContinuation<Pair<String, String>> cancellableContinuation = this.f318972d;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(t16)));
        }

        @Override // com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator.b
        public void onRelease() {
            ApngAvatarGenerator.b.a.d(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$c", "Lcom/tencent/mobileqq/wink/view/multitouchview/PhotoViewAttacher$e;", "Landroid/graphics/Matrix;", "it", "", "a", "", "[F", "result", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements PhotoViewAttacher.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] result = new float[9];

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WinkPlayerContainerView f318975c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f318976d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f318977e;

        c(WinkPlayerContainerView winkPlayerContainerView, int i3, int i16) {
            this.f318975c = winkPlayerContainerView;
            this.f318976d = i3;
            this.f318977e = i16;
        }

        @Override // com.tencent.mobileqq.wink.view.multitouchview.PhotoViewAttacher.e
        public void a(@NotNull Matrix it) {
            Intrinsics.checkNotNullParameter(it, "it");
            WinkDynamicAvatarFragment.this.hasDragScreen = true;
            it.getValues(this.result);
            this.f318975c.setTranslationX(this.f318976d + this.result[2]);
            this.f318975c.setTranslationY(this.f318977e + this.result[5]);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$d", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "", "b", "", "startTimeUs", "a", "c", "timeUs", "e", "d", "f", "", "Z", "playingOnStartScroll", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkSegClipView.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean playingOnStartScroll;

        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void a(long startTimeUs) {
            WinkDynamicAvatarFragment.this.hasDragClip = true;
            WinkSegClipView.SegClipModel segClipModel = WinkDynamicAvatarFragment.this.segClipData;
            WinkSegClipView.SegClipModel segClipModel2 = null;
            if (segClipModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
                segClipModel = null;
            }
            long selectDuration = segClipModel.getSelectDuration();
            WinkSegClipView.SegClipModel segClipModel3 = WinkDynamicAvatarFragment.this.segClipData;
            if (segClipModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            } else {
                segClipModel2 = segClipModel3;
            }
            segClipModel2.i(startTimeUs);
            WinkDynamicAvatarFragment.this.Di().o3(startTimeUs, selectDuration);
            TimelineViewModelV2 timelineViewModel = WinkDynamicAvatarFragment.this.Di();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, startTimeUs, false, false, 6, null);
            ms.a.a(WinkDynamicAvatarFragment.this.getTAG(), "onScroll---start=" + startTimeUs + ", duration=" + selectDuration);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void b() {
            this.playingOnStartScroll = WinkDynamicAvatarFragment.this.Di().W2();
            WinkDynamicAvatarFragment.this.Di().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void c() {
            if (this.playingOnStartScroll) {
                WinkDynamicAvatarFragment.this.Di().c3();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void d() {
            WinkDynamicAvatarFragment.this.Di().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void e(long timeUs) {
            TimelineViewModelV2 timelineViewModel = WinkDynamicAvatarFragment.this.Di();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, timeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void f() {
            WinkDynamicAvatarFragment.this.Di().c3();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkDynamicAvatarFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Pi(3);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (WinkDynamicAvatarFragment.this.vi().getMeasuredWidth() <= 0) {
                WinkDynamicAvatarFragment.this.zi().requestLayout();
                return;
            }
            WinkDynamicAvatarFragment.this.vi().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (WinkExportUtils.R()) {
                WinkPlayerContainerView Hi = WinkDynamicAvatarFragment.this.Hi();
                if (Hi != null) {
                    WinkDynamicAvatarFragment.this.playerContainer = Hi;
                    WinkDynamicAvatarFragment winkDynamicAvatarFragment = WinkDynamicAvatarFragment.this;
                    WinkPlayerContainerView winkPlayerContainerView = winkDynamicAvatarFragment.playerContainer;
                    WinkVideoTavCut winkVideoTavCut = null;
                    if (winkPlayerContainerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                        winkPlayerContainerView = null;
                    }
                    winkDynamicAvatarFragment.Gi(winkPlayerContainerView);
                    TimelineViewModelV2 Di = WinkDynamicAvatarFragment.this.Di();
                    WinkVideoTavCut winkVideoTavCut2 = WinkDynamicAvatarFragment.this.cut;
                    if (winkVideoTavCut2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cut");
                    } else {
                        winkVideoTavCut = winkVideoTavCut2;
                    }
                    Di.R2(winkVideoTavCut, WinkDynamicAvatarFragment.this.playerListener, WinkDynamicAvatarFragment.this.renderListener);
                    View vi5 = WinkDynamicAvatarFragment.this.vi();
                    final WinkDynamicAvatarFragment winkDynamicAvatarFragment2 = WinkDynamicAvatarFragment.this;
                    vi5.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.avatar.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkDynamicAvatarFragment.e.b(WinkDynamicAvatarFragment.this);
                        }
                    }, 500L);
                    return;
                }
                w53.b.c(WinkDynamicAvatarFragment.this.getTAG(), "initPlayer null");
                FragmentActivity activity = WinkDynamicAvatarFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            w53.b.c(WinkDynamicAvatarFragment.this.getTAG(), "loadLightAssets fail");
            FragmentActivity activity2 = WinkDynamicAvatarFragment.this.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$f", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements IPlayer.PlayerListener {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkDynamicAvatarFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            long k3 = this$0.Ai().k();
            WinkSegClipView.SegClipModel segClipModel = this$0.segClipData;
            if (segClipModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
                segClipModel = null;
            }
            long selectDuration = segClipModel.getSelectDuration();
            ms.a.a(this$0.getTAG(), "onPlayerSourceReady---start=" + k3 + ", duration=" + selectDuration);
            this$0.Di().o3(k3, selectDuration);
            TimelineViewModelV2 timelineViewModel = this$0.Di();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, k3, false, false, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkDynamicAvatarFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Ai().z(j3);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkDynamicAvatarFragment winkDynamicAvatarFragment = WinkDynamicAvatarFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.avatar.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkDynamicAvatarFragment.f.c(WinkDynamicAvatarFragment.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(final long currentDurationUs, long playerDurationUs) {
            WinkDynamicAvatarFragment.this.Di().m2().postValue(Long.valueOf(currentDurationUs));
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkDynamicAvatarFragment winkDynamicAvatarFragment = WinkDynamicAvatarFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.avatar.j
                @Override // java.lang.Runnable
                public final void run() {
                    WinkDynamicAvatarFragment.f.d(WinkDynamicAvatarFragment.this, currentDurationUs);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == IPlayer.PlayerStatus.PLAYING) {
                WinkDynamicAvatarFragment.this.xi().setImageResource(R.drawable.oqq);
            } else if (status == IPlayer.PlayerStatus.PAUSED) {
                WinkDynamicAvatarFragment.this.xi().setImageResource(R.drawable.oqs);
            }
            WinkDynamicAvatarFragment.this.Di().l2().postValue(status);
        }
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$Companion$PROFILE_SCHEMA$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "mqq://card/show_pslcard?src_type=internal&version=1&card_type=person&uin=" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            }
        });
        f318953q0 = lazy;
    }

    public WinkDynamicAvatarFragment() {
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
        Lazy lazy24;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$root$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.root);
            }
        });
        this.root = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$hole$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.d6b);
            }
        });
        this.hole = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<HoleView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$holeMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HoleView invoke() {
                return (HoleView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.xac);
            }
        });
        this.holeMask = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$back$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.f164559a43);
            }
        });
        this.back = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$title$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.title);
            }
        });
        this.title = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$confirm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.b7m);
            }
        });
        this.confirm = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$bottomBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.ac5);
            }
        });
        this.bottomBg = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$playerToggle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.f25970c_);
            }
        });
        this.playerToggle = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSegClipView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$segClipView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkSegClipView invoke() {
                return (WinkSegClipView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.f81914fg);
            }
        });
        this.segClipView = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$setStaticAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.f83624k2);
            }
        });
        this.setStaticAvatar = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<Space>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$changeDurationArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Space invoke() {
                return (Space) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.trb);
            }
        });
        this.changeDurationArea = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$durations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) WinkDynamicAvatarFragment.this.requireView().findViewById(R.id.uoz);
            }
        });
        this.durations = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelineViewModelV2 invoke() {
                return (TimelineViewModelV2) new ViewModelProvider(WinkDynamicAvatarFragment.this).get(TimelineViewModelV2.class);
            }
        });
        this.timelineViewModel = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$apngCachePath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String oi5;
                oi5 = WinkDynamicAvatarFragment.this.oi();
                return oi5 + "_dynamic_avatar.apng";
            }
        });
        this.apngCachePath = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$staticFramePath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String oi5;
                oi5 = WinkDynamicAvatarFragment.this.oi();
                return oi5 + "_dynamic_avatar_static.png";
            }
        });
        this.staticFramePath = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$userStaticFrameCroppedPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String oi5;
                oi5 = WinkDynamicAvatarFragment.this.oi();
                return oi5 + "_dynamic_avatar_static_user_cropped.png";
            }
        });
        this.userStaticFrameCroppedPath = lazy16;
        this.playerListener = new f();
        this.renderListener = new g();
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<WinkDynamicAvatarUploader>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$avatarUploader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkDynamicAvatarUploader invoke() {
                return new WinkDynamicAvatarUploader();
            }
        });
        this.avatarUploader = lazy17;
        this.outputSize = new Size(300, 300);
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$attrMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Map<String, ? extends String> invoke() {
                Serializable serializableExtra = WinkDynamicAvatarFragment.this.requireActivity().getIntent().getSerializableExtra("key_attrs");
                if (serializableExtra instanceof Map) {
                    return (Map) serializableExtra;
                }
                return null;
            }
        });
        this.attrMap = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$videoPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                Map li5;
                li5 = WinkDynamicAvatarFragment.this.li();
                if (li5 != null) {
                    return (String) li5.get("mediapath");
                }
                return null;
            }
        });
        this.videoPath = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$fromEntrance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Map li5;
                String str;
                li5 = WinkDynamicAvatarFragment.this.li();
                return (li5 == null || (str = (String) li5.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) == null) ? "1" : str;
            }
        });
        this.fromEntrance = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$profileType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Map li5;
                String str;
                li5 = WinkDynamicAvatarFragment.this.li();
                return (li5 == null || (str = (String) li5.get(QCircleSchemeAttr.CoverFeed.PROFILE_TYPE)) == null) ? "0" : str;
            }
        });
        this.profileType = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$feedId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Map li5;
                String str;
                li5 = WinkDynamicAvatarFragment.this.li();
                return (li5 == null || (str = (String) li5.get("feedid")) == null) ? "" : str;
            }
        });
        this.feedId = lazy22;
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$feedOwner$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Map li5;
                String str;
                li5 = WinkDynamicAvatarFragment.this.li();
                return (li5 == null || (str = (String) li5.get("uin")) == null) ? "" : str;
            }
        });
        this.feedOwner = lazy23;
        lazy24 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$feedTime$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Map li5;
                String str;
                li5 = WinkDynamicAvatarFragment.this.li();
                return Long.valueOf((li5 == null || (str = (String) li5.get("createtime")) == null) ? 0L : Long.parseLong(str));
            }
        });
        this.feedTime = lazy24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSegClipView Ai() {
        Object value = this.segClipView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-segClipView>(...)");
        return (WinkSegClipView) value;
    }

    private final TextView Bi() {
        Object value = this.setStaticAvatar.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-setStaticAvatar>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ci() {
        return (String) this.staticFramePath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 Di() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ei() {
        return (String) this.userStaticFrameCroppedPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Fi() {
        return (String) this.videoPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi(WinkPlayerContainerView playerContainer) {
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(vi(), new ApngOptions.EmptyDrawable(playerContainer.getLayoutParams().width, playerContainer.getLayoutParams().height));
        int measuredWidth = (playerContainer.getLayoutParams().width - vi().getMeasuredWidth()) / 2;
        int measuredHeight = (playerContainer.getLayoutParams().height - vi().getMeasuredHeight()) / 2;
        photoViewAttacher.W(false);
        photoViewAttacher.V(ImageView.ScaleType.CENTER_CROP);
        photoViewAttacher.S(new c(playerContainer, measuredWidth, measuredHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkPlayerContainerView Hi() {
        boolean z16;
        List<String> listOf;
        int i3;
        int i16;
        boolean isBlank;
        w53.b.a(getTAG(), "buildTavcut");
        String Fi = Fi();
        if (Fi != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(Fi);
            if (!isBlank) {
                z16 = false;
                WinkVideoTavCut winkVideoTavCut = null;
                if (z16 && new File(Fi()).exists()) {
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    WinkPlayerContainerView winkPlayerContainerView = new WinkPlayerContainerView(requireContext);
                    o oVar = o.f326724a;
                    String Fi2 = Fi();
                    Intrinsics.checkNotNull(Fi2);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(Fi2);
                    List<LocalMediaInfo> i17 = oVar.i(listOf);
                    if (i17.isEmpty()) {
                        w53.b.c(getTAG(), "initPlayer: invalid mediaLocalPaths");
                        return null;
                    }
                    int i18 = i17.get(0).mediaWidth;
                    int i19 = i17.get(0).mediaHeight;
                    int measuredWidth = vi().getMeasuredWidth();
                    if (i19 <= 0 || i18 <= 0) {
                        w53.b.c(getTAG(), "initPlayer : invalid mediaSize " + i18 + " " + i19 + " " + Fi());
                        i18 = measuredWidth;
                        i19 = i18;
                    }
                    if (i19 > i18) {
                        i16 = (int) (i19 / (i18 / measuredWidth));
                        i3 = measuredWidth;
                    } else {
                        i3 = (int) (i18 / (i19 / measuredWidth));
                        i16 = measuredWidth;
                    }
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i3, i16);
                    layoutParams.leftToLeft = R.id.d6b;
                    layoutParams.rightToRight = R.id.d6b;
                    layoutParams.topToTop = R.id.d6b;
                    layoutParams.bottomToBottom = R.id.d6b;
                    winkPlayerContainerView.setLayoutParams(layoutParams);
                    WinkEditDataWrapper f16 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(i17), 0, 0, 6, null);
                    WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
                    ArrayList<WinkEditData> editDatas = f16.getEditDatas();
                    Boolean bool = Boolean.TRUE;
                    Boolean bool2 = u53.i.f438428a;
                    if (bool2 == null) {
                        bool2 = Boolean.FALSE;
                    }
                    Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
                    boolean booleanValue = bool2.booleanValue();
                    Integer softDecodeThreadCnt = u53.i.f438429b;
                    Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
                    WinkVideoTavCut f17 = WinkPlayerContainerView.f(winkPlayerContainerView, new dr.WinkTavCutParams(false, editMode, editDatas, null, bool, i3, i16, null, null, booleanValue, softDecodeThreadCnt.intValue(), WinkConfig.f317649a.b(), false, false, null, WinkTavCutScene.DYNAMIC_AVATAR, false, false, 0, 0, false, null, 4128768, null), null, null, false, null, 30, null);
                    this.cut = f17;
                    if (f17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cut");
                    } else {
                        winkVideoTavCut = f17;
                    }
                    winkVideoTavCut.setAutoPlay(true);
                    WinkEditData winkEditData = f16.getEditDatas().get(0);
                    Intrinsics.checkNotNullExpressionValue(winkEditData, "wrapper.editDatas[0]");
                    MediaClip mediaClip = com.tencent.mobileqq.wink.editor.draft.c.t(winkEditData).get(0);
                    ResourceModel resourceModel = mediaClip.resource;
                    Intrinsics.checkNotNull(resourceModel);
                    this.segClipData = new WinkSegClipView.SegClipModel(mediaClip, 1.0f, resourceModel.sourceDuration, Math.min(3000000L, mediaClip.resource.sourceDuration), 0L, 0L);
                    zi().addView(winkPlayerContainerView, 0);
                    return winkPlayerContainerView;
                }
                w53.b.c(getTAG(), "initPlayer: invalid path " + Fi());
                return null;
            }
        }
        z16 = true;
        WinkVideoTavCut winkVideoTavCut2 = null;
        if (z16) {
        }
        w53.b.c(getTAG(), "initPlayer: invalid path " + Fi());
        return null;
    }

    private final void Ii() {
        Ai().setSegClipCallback(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(WinkDynamicAvatarFragment this$0, int i3, TextView this_apply, HashMap reportMap, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        if (this$0.playerContainer != null) {
            this$0.Pi(i3);
            com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, this_apply, WinkDaTongReportConstant.ElementId.EM_XSJ_VIDEO_CLIP_N_SECOND_BUTTON_FORMAT, reportMap, null, 8, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(WinkDynamicAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkVideoTavCut winkVideoTavCut = this$0.cut;
        if (winkVideoTavCut != null) {
            WinkVideoTavCut winkVideoTavCut2 = null;
            if (winkVideoTavCut == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut.isPlaying()) {
                WinkVideoTavCut winkVideoTavCut3 = this$0.cut;
                if (winkVideoTavCut3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cut");
                } else {
                    winkVideoTavCut2 = winkVideoTavCut3;
                }
                winkVideoTavCut2.pause();
            } else {
                WinkVideoTavCut winkVideoTavCut4 = this$0.cut;
                if (winkVideoTavCut4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cut");
                } else {
                    winkVideoTavCut2 = winkVideoTavCut4;
                }
                winkVideoTavCut2.play();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(WinkDynamicAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this$0.requireContext(), "com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity"));
        intent.putExtra(QCircleScheme.AttrQQPublish.FROM_ENTRANCE, this$0.ti());
        intent.putExtra("param_source", 4);
        intent.putExtra("key_video_file_path", this$0.Fi());
        WinkSegClipView.SegClipModel segClipModel = this$0.segClipData;
        ActivityResultLauncher<Intent> activityResultLauncher = null;
        if (segClipModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel = null;
        }
        long j3 = 1000;
        intent.putExtra("key_video_duration", segClipModel.getSelectDuration() / j3);
        WinkSegClipView.SegClipModel segClipModel2 = this$0.segClipData;
        if (segClipModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel2 = null;
        }
        intent.putExtra("key_video_start_time", segClipModel2.getModifiedStartTime() / j3);
        WinkSegClipView.SegClipModel segClipModel3 = this$0.segClipData;
        if (segClipModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel3 = null;
        }
        intent.putExtra("key_video_select_duration", segClipModel3.getSelectDuration() / j3);
        boolean z16 = false;
        intent.putExtra("key_video_sync_frame", false);
        WinkSegClipView.SegClipModel segClipModel4 = this$0.segClipData;
        if (segClipModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel4 = null;
        }
        long modifiedStartTime = segClipModel4.getModifiedStartTime();
        WinkSegClipView.SegClipModel segClipModel5 = this$0.segClipData;
        if (segClipModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel5 = null;
        }
        long modifiedStartTime2 = segClipModel5.getModifiedStartTime();
        WinkSegClipView.SegClipModel segClipModel6 = this$0.segClipData;
        if (segClipModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel6 = null;
        }
        long selectDuration = modifiedStartTime2 + segClipModel6.getSelectDuration();
        long j16 = this$0.userStaticFrameAbsTime;
        if (modifiedStartTime <= j16 && j16 <= selectDuration) {
            z16 = true;
        }
        if (z16) {
            WinkSegClipView.SegClipModel segClipModel7 = this$0.segClipData;
            if (segClipModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
                segClipModel7 = null;
            }
            intent.putExtra("key_photo_select_time", (int) ((j16 - segClipModel7.getModifiedStartTime()) / j3));
        }
        ActivityResultLauncher<Intent> activityResultLauncher2 = this$0.resultLauncher;
        if (activityResultLauncher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLauncher");
        } else {
            activityResultLauncher = activityResultLauncher2;
        }
        activityResultLauncher.launch(intent);
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, this$0.Bi(), WinkDaTongReportConstant.ElementId.EM_XSJ_SET_STATIC_AVATAR_BUTTON, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(WinkDynamicAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(WinkDynamicAvatarFragment this$0, View it) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.playerContainer != null) {
            this$0.ii();
            HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_LENGTH, Long.valueOf(r.f384266a.f(this$0.Di().z2())));
            String str = "1";
            if (this$0.hasDragScreen) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DRAG_SCREEN, obj);
            if (!this$0.hasDragClip) {
                str = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DRAG_CLIP, str);
            VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_NONE);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.mobileqq.wink.report.e.k(eVar, it, "em_xsj_confirm_button", hashMap, null, 8, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(WinkDynamicAvatarFragment this$0, ActivityResult activityResult) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.segClipData == null) {
            w53.b.f(this$0.getTAG(), "onActivityResult: peak being killed, finish activity");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Intent data = activityResult.getData();
        WinkSegClipView.SegClipModel segClipModel = null;
        if (data != null) {
            str = data.getStringExtra("key_photo_file_path");
        } else {
            str = null;
        }
        this$0.userStaticFrame = str;
        Intent data2 = activityResult.getData();
        int i3 = 0;
        if (data2 != null) {
            i3 = data2.getIntExtra("key_photo_select_time", 0);
        }
        long j3 = i3 * 1000;
        WinkSegClipView.SegClipModel segClipModel2 = this$0.segClipData;
        if (segClipModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
        } else {
            segClipModel = segClipModel2;
        }
        this$0.userStaticFrameAbsTime = j3 + segClipModel.getModifiedStartTime();
        w53.b.a(this$0.getTAG(), "registerForActivityResult: " + this$0.userStaticFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pi(int index) {
        WinkSegClipView.SegClipModel segClipModel;
        boolean z16;
        WinkSegClipView.SegClipModel segClipModel2 = this.segClipData;
        WinkSegClipView.SegClipModel segClipModel3 = null;
        if (segClipModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel = null;
        } else {
            segClipModel = segClipModel2;
        }
        WinkSegClipView.SegClipModel segClipModel4 = this.segClipData;
        if (segClipModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel4 = null;
        }
        this.segClipData = WinkSegClipView.SegClipModel.b(segClipModel, null, 0.0f, 0L, Math.min(segClipModel4.getSourceDuration(), index * 1000 * 1000), 0L, 0L, 55, null);
        int childCount = qi().getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = qi().getChildAt(i3);
            i3++;
            if (index == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            childAt.setSelected(z16);
        }
        WinkSegClipView Ai = Ai();
        WinkSegClipView.SegClipModel segClipModel5 = this.segClipData;
        if (segClipModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel5 = null;
        }
        Ai.setSegClipModel(segClipModel5);
        TimelineViewModelV2 Di = Di();
        WinkSegClipView.SegClipModel segClipModel6 = this.segClipData;
        if (segClipModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel6 = null;
        }
        long modifiedStartTime = segClipModel6.getModifiedStartTime();
        WinkSegClipView.SegClipModel segClipModel7 = this.segClipData;
        if (segClipModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel7 = null;
        }
        Di.o3(modifiedStartTime, segClipModel7.getSelectDuration());
        TimelineViewModelV2 timelineViewModel = Di();
        Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
        WinkSegClipView.SegClipModel segClipModel8 = this.segClipData;
        if (segClipModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
        } else {
            segClipModel3 = segClipModel8;
        }
        TimelineViewModelV2.g3(timelineViewModel, segClipModel3.getModifiedStartTime(), false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi() {
        pi().setEnabled(false);
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(false).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.avatar.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkDynamicAvatarFragment.Ri(WinkDynamicAvatarFragment.this);
            }
        }).p(getString(R.string.f239157lp)).j(QCircleScheme.AttrQQPublish.OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM).a();
        this.loadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(WinkDynamicAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        Job job = this$0.genJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this$0.pi().setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fi(Rect rect, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (ui()) {
            try {
                Bitmap b16 = ApngAvatarGenerator.INSTANCE.b(this.outputSize, rect, BitmapFactory.decodeFile(this.userStaticFrame));
                if (b16 != null) {
                    com.tencent.mobileqq.wink.utils.f.t(Ei(), b16);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Ei()));
                } else {
                    w53.b.c(getTAG(), "cropStaticFrame fail");
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                }
            } catch (Exception e16) {
                w53.b.d(getTAG(), "cropStaticFrame fail2", e16);
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            }
        } else {
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFeedId() {
        return (String) this.feedId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        if (!Intrinsics.areEqual(yi(), "0")) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(INSTANCE.b()));
            startActivity(intent);
        }
        QQToast.makeText(getContext(), R.string.hfd, 1).show();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(new Intent(QCircleScheme.AttrQQPublish.BROADCAST_WINK_DYNAMIC_AVATAR_FINISH));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object hi(Size size, Rect rect, long j3, Continuation<? super Pair<String, String>> continuation) {
        Continuation intercepted;
        int i3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        String Fi = Fi();
        if (Fi != null) {
            i3 = Fi.hashCode();
        } else {
            i3 = 0;
        }
        ClipSource clipSource = new ClipSource(String.valueOf(i3), Fi(), ClipType.VIDEO, j3, null, null, null, null, null, null, null, null, null, 8176, null);
        Size size2 = new Size(size.width, size.height);
        WinkSegClipView.SegClipModel segClipModel = this.segClipData;
        WinkSegClipView.SegClipModel segClipModel2 = null;
        if (segClipModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
            segClipModel = null;
        }
        long modifiedStartTime = segClipModel.getModifiedStartTime();
        WinkSegClipView.SegClipModel segClipModel3 = this.segClipData;
        if (segClipModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("segClipData");
        } else {
            segClipModel2 = segClipModel3;
        }
        final ApngAvatarGenerator apngAvatarGenerator = new ApngAvatarGenerator(clipSource, size2, new TimeRange(modifiedStartTime, segClipModel2.getSelectDuration()), this.outputSize, rect, ki(), 0, 64, null);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$genApng$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                ApngAvatarGenerator.this.close();
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = elapsedRealtime;
        apngAvatarGenerator.q(new b(elapsedRealtime, longRef, cancellableContinuationImpl));
        apngAvatarGenerator.j();
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void ii() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WinkDynamicAvatarFragment$genApngAndUpload$1(this, null), 3, null);
        this.genJob = launch$default;
    }

    private final void initView() {
        xi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.avatar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkDynamicAvatarFragment.Ki(WinkDynamicAvatarFragment.this, view);
            }
        });
        TextView Bi = Bi();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(requireContext(), R.color.czs));
        gradientDrawable.setCornerRadius(ViewExKt.d(4));
        Bi.setBackground(gradientDrawable);
        Bi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.avatar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkDynamicAvatarFragment.Li(WinkDynamicAvatarFragment.this, view);
            }
        });
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.f(eVar, Bi(), WinkDaTongReportConstant.ElementId.EM_XSJ_SET_STATIC_AVATAR_BUTTON, null, null, 12, null);
        ni().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.avatar.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkDynamicAvatarFragment.Mi(WinkDynamicAvatarFragment.this, view);
            }
        });
        pi().setBackground(ContextCompat.getDrawable(pi().getContext(), R.drawable.m5o));
        pi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.avatar.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkDynamicAvatarFragment.Ni(WinkDynamicAvatarFragment.this, view);
            }
        });
        com.tencent.mobileqq.wink.report.e.h(eVar, pi(), "em_xsj_confirm_button", null, null, 12, null);
        qi().setDividerDrawable(new ApngOptions.EmptyDrawable(ViewExKt.d(16), ViewExKt.d(16)));
        for (final int i3 = 1; i3 < 4; i3++) {
            final TextView textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewExKt.d(52), ViewExKt.d(28)));
            textView.setGravity(17);
            textView.setTextSize(2, 12.0f);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, ContextCompat.getDrawable(textView.getContext(), R.drawable.l5d));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(ContextCompat.getColor(textView.getContext(), R.color.al7));
            gradientDrawable2.setCornerRadius(ViewExKt.d(4));
            Unit unit = Unit.INSTANCE;
            stateListDrawable.addState(new int[0], gradientDrawable2);
            textView.setBackground(stateListDrawable);
            textView.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{ContextCompat.getColor(textView.getContext(), R.color.d07), ContextCompat.getColor(textView.getContext(), R.color.bfq)}));
            textView.setSelected(false);
            textView.setText(i3 + "\u79d2");
            final HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_N_SECOND, Integer.valueOf(i3));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.avatar.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkDynamicAvatarFragment.Ji(WinkDynamicAvatarFragment.this, i3, textView, hashMap, view);
                }
            });
            com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, textView, WinkDaTongReportConstant.ElementId.EM_XSJ_VIDEO_CLIP_N_SECOND_BUTTON_FORMAT, hashMap, null, 8, null);
            qi().addView(textView);
        }
        wi().setReferencedIds(new int[]{R.id.d6b});
        TextView textView2 = (TextView) Ai().findViewById(R.id.f1055766d);
        textView2.setPadding(ViewExKt.d(4), ViewExKt.d(2), ViewExKt.d(4), ViewExKt.d(2));
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewExKt.d(4);
        Ai().findViewById(R.id.e_1).setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = Ai().findViewById(R.id.xyl).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        layoutParams3.topToTop = R.id.e_1;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = ViewExKt.d(96);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(Throwable t16) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        QQToast.makeText(requireContext(), R.string.f239167lq, 1).show();
        pi().setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ki() {
        return (String) this.apngCachePath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> li() {
        return (Map) this.attrMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkDynamicAvatarUploader mi() {
        return (WinkDynamicAvatarUploader) this.avatarUploader.getValue();
    }

    private final ImageView ni() {
        Object value = this.back.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-back>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String oi() {
        String str = u53.e.f438384a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + System.nanoTime();
    }

    private final TextView pi() {
        Object value = this.confirm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-confirm>(...)");
        return (TextView) value;
    }

    private final LinearLayout qi() {
        Object value = this.durations.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-durations>(...)");
        return (LinearLayout) value;
    }

    private final void registerDaTongReportPageId(View contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_AVATAR_EDIT_PAGE);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, ti());
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ri() {
        return (String) this.feedOwner.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long si() {
        return ((Number) this.feedTime.getValue()).longValue();
    }

    private final String ti() {
        return (String) this.fromEntrance.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ui() {
        boolean z16;
        boolean isBlank;
        String str = this.userStaticFrame;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16 && new File(this.userStaticFrame).exists()) {
                    return true;
                }
            }
        }
        z16 = true;
        return z16 ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View vi() {
        Object value = this.hole.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-hole>(...)");
        return (View) value;
    }

    private final HoleView wi() {
        Object value = this.holeMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-holeMask>(...)");
        return (HoleView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView xi() {
        Object value = this.playerToggle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-playerToggle>(...)");
        return (ImageView) value;
    }

    private final String yi() {
        return (String) this.profileType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout zi() {
        Object value = this.root.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-root>(...)");
        return (ConstraintLayout) value;
    }

    public void _$_clearFindViewByIdCache() {
        this.f318968o0.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i57;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkDynamicAvatarFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WinkExportUtils.R();
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tencent.mobileqq.wink.editor.avatar.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                WinkDynamicAvatarFragment.Oi(WinkDynamicAvatarFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul\u2026aticFrame\")\n            }");
        this.resultLauncher = registerForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncher;
        WinkVideoTavCut winkVideoTavCut = null;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.unregister();
        mi().u();
        Ai().i();
        WinkVideoTavCut winkVideoTavCut2 = this.cut;
        if (winkVideoTavCut2 != null) {
            if (winkVideoTavCut2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
            } else {
                winkVideoTavCut = winkVideoTavCut2;
            }
            winkVideoTavCut.release();
        }
        super.onDestroyView();
        Di().d3();
        ThumbnailProviderManager.f319211a.s();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        WinkVideoTavCut winkVideoTavCut = this.cut;
        if (winkVideoTavCut != null) {
            if (winkVideoTavCut == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
                winkVideoTavCut = null;
            }
            winkVideoTavCut.pause();
        }
        super.onPause();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        initView();
        Ii();
        vi().getViewTreeObserver().addOnGlobalLayoutListener(new e());
        ApngAvatarGenerator.INSTANCE.c(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                w53.b.f(WinkDynamicAvatarFragment.this.getTAG(), "ApngAvatarGenerator so pre loaded result = " + z16);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarFragment$g", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements ISessionListener {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkDynamicAvatarFragment this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            this$0.Di().D3(newData.getTimeLines());
            long k3 = this$0.Ai().k();
            WinkSegClipView.SegClipModel segClipModel = this$0.segClipData;
            if (segClipModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
                segClipModel = null;
            }
            long selectDuration = segClipModel.getSelectDuration();
            ms.a.a(this$0.getTAG(), "onRenderDataChanged---start=" + k3 + ", duration=" + selectDuration);
            this$0.Di().o3(k3, selectDuration);
            TimelineViewModelV2 timelineViewModel = this$0.Di();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, k3, false, false, 6, null);
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkDynamicAvatarFragment winkDynamicAvatarFragment = WinkDynamicAvatarFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.avatar.k
                @Override // java.lang.Runnable
                public final void run() {
                    WinkDynamicAvatarFragment.g.b(WinkDynamicAvatarFragment.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }
}
