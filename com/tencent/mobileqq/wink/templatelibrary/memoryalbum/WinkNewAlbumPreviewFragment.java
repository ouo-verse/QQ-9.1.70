package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel;
import com.tencent.mobileqq.wink.utils.ag;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.media.QUIPlayIconView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnClipAssetListener;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00a3\u00012\u00020\u0001:\u0002\u00a4\u0001B\t\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u0019\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u001eH\u0014J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J&\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020(2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H\u0016J\u0006\u00102\u001a\u00020\u0002J\"\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u000105H\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010M\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010P\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010DR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR*\u0010q\u001a\u0016\u0012\u0004\u0012\u00020m\u0018\u00010lj\n\u0012\u0004\u0012\u00020m\u0018\u0001`n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010s\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010jR\u0018\u0010u\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010jR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010jR!\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008d\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R!\u0010\u0092\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u008a\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R!\u0010\u0097\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u008a\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R!\u0010\u00a0\u0001\u001a\u00030\u009c\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u008a\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/WinkNewAlbumPreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "initSeekBar", "", "getLimitDuration", "Xh", "", "tips", "ni", "ii", "Sh", "ki", "qi", "ri", WidgetCacheLunarData.JI, "Zh", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkNewAlbumPreviewViewModel$b;", "data", "Qh", "path", "Landroid/widget/ImageView;", "iv", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "Oh", "pi", "", "getContentLayoutId", "getStatusBarColor", "", "needAdjustImmersive", "needSupportFullScreen", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "initView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "Lcom/tencent/mobileqq/wink/editor/dr;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/dr;", "mVideoCut", "Landroidx/constraintlayout/widget/ConstraintLayout;", "D", "Landroidx/constraintlayout/widget/ConstraintLayout;", "playerFrame", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "back", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "changePic", "H", "changeTemplate", "I", "changeEdit", "J", "Landroid/widget/ImageView;", "coverImage", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "K", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "nextButton", "Lcom/tencent/widget/media/QUIPlayIconView;", "L", "Lcom/tencent/widget/media/QUIPlayIconView;", "playIcon", "M", "seekFrameLayout", "Landroid/widget/SeekBar;", "N", "Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "videoCurrentProgress", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "videoDurationProgress", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/RelativeLayout;", "videoProgressLayout", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "templateId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "T", "Ljava/util/ArrayList;", "inputMedia", "U", "selectTemplateId", "V", "coverImagePath", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "W", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "X", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkNewAlbumPreviewViewModel$b;", "mPreviewData", "Y", "Z", "isStandalone", QQWinkConstants.STORY_ID, "a0", "Ljava/util/List;", "templateList", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "b0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkNewAlbumPreviewViewModel;", "c0", "Lkotlin/Lazy;", "Vh", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkNewAlbumPreviewViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/editor/export/u;", "d0", "Wh", "()Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "e0", "Th", "()Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "mWinkExtractCoverViewModel", "Lorg/light/listener/OnClipAssetListener;", "f0", "Lorg/light/listener/OnClipAssetListener;", "onClipAssetListener", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "g0", "Uh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "<init>", "()V", "i0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumPreviewFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private dr mVideoCut;

    /* renamed from: D, reason: from kotlin metadata */
    private ConstraintLayout playerFrame;

    /* renamed from: E, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout back;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout changePic;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout changeTemplate;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout changeEdit;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView coverImage;

    /* renamed from: K, reason: from kotlin metadata */
    private QUIButton nextButton;

    /* renamed from: L, reason: from kotlin metadata */
    private QUIPlayIconView playIcon;

    /* renamed from: M, reason: from kotlin metadata */
    private FrameLayout seekFrameLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private SeekBar seekBar;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView videoCurrentProgress;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView videoDurationProgress;

    /* renamed from: R, reason: from kotlin metadata */
    private RelativeLayout videoProgressLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> inputMedia;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private String selectTemplateId;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private String coverImagePath;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private WinkNewAlbumPreviewViewModel.b mPreviewData;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isStandalone;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private String storyId;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> templateList;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkExportViewModel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mWinkExtractCoverViewModel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OnClipAssetListener onClipAssetListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f326530h0 = new LinkedHashMap();

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private String templateId = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IPlayer.PlayerListener playerListener = new d();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/WinkNewAlbumPreviewFragment$c", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            dr drVar;
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser && (drVar = WinkNewAlbumPreviewFragment.this.mVideoCut) != null) {
                WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment = WinkNewAlbumPreviewFragment.this;
                long limitDuration = (long) (winkNewAlbumPreviewFragment.getLimitDuration() * (progress / 1000.0d));
                drVar.seek(limitDuration);
                SeekBar seekBar2 = winkNewAlbumPreviewFragment.seekBar;
                TextView textView = null;
                if (seekBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                    seekBar2 = null;
                }
                seekBar2.setProgress(progress);
                TextView textView2 = winkNewAlbumPreviewFragment.videoCurrentProgress;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoCurrentProgress");
                } else {
                    textView = textView2;
                }
                textView.setText(com.tencent.mobileqq.wink.editor.music.a.d(limitDuration));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            dr drVar = WinkNewAlbumPreviewFragment.this.mVideoCut;
            if (drVar != null) {
                WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment = WinkNewAlbumPreviewFragment.this;
                seekBar.getLayoutParams().height = ViewUtils.dpToPx(4.0f);
                seekBar.requestLayout();
                drVar.pause();
                RelativeLayout relativeLayout = winkNewAlbumPreviewFragment.videoProgressLayout;
                TextView textView = null;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoProgressLayout");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                QUIPlayIconView qUIPlayIconView = winkNewAlbumPreviewFragment.playIcon;
                if (qUIPlayIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playIcon");
                    qUIPlayIconView = null;
                }
                qUIPlayIconView.setVisibility(8);
                TextView textView2 = winkNewAlbumPreviewFragment.videoDurationProgress;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoDurationProgress");
                } else {
                    textView = textView2;
                }
                textView.setText(com.tencent.mobileqq.wink.editor.music.a.d(winkNewAlbumPreviewFragment.getLimitDuration()));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            dr drVar = WinkNewAlbumPreviewFragment.this.mVideoCut;
            if (drVar != null) {
                WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment = WinkNewAlbumPreviewFragment.this;
                seekBar.getLayoutParams().height = ViewUtils.dpToPx(2.0f);
                seekBar.requestLayout();
                drVar.play();
                QUIPlayIconView qUIPlayIconView = winkNewAlbumPreviewFragment.playIcon;
                RelativeLayout relativeLayout = null;
                if (qUIPlayIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playIcon");
                    qUIPlayIconView = null;
                }
                qUIPlayIconView.setVisibility(8);
                RelativeLayout relativeLayout2 = winkNewAlbumPreviewFragment.videoProgressLayout;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoProgressLayout");
                } else {
                    relativeLayout = relativeLayout2;
                }
                relativeLayout.setVisibility(8);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/WinkNewAlbumPreviewFragment$d", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "currentPosition", "duration", "", "onPositionChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "onStatusChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements IPlayer.PlayerListener {
        d() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentPosition, long duration) {
            if (WinkNewAlbumPreviewFragment.this.seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            }
            if (((float) duration) > 0.0f) {
                long min = (long) Math.min(duration, WinkNewAlbumPreviewFragment.this.getLimitDuration());
                if (min > 0) {
                    double d16 = currentPosition / min;
                    SeekBar seekBar = WinkNewAlbumPreviewFragment.this.seekBar;
                    if (seekBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                        seekBar = null;
                    }
                    seekBar.setProgress((int) (d16 * 1000));
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }
    }

    public WinkNewAlbumPreviewFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkNewAlbumPreviewViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkNewAlbumPreviewViewModel invoke() {
                return (WinkNewAlbumPreviewViewModel) WinkNewAlbumPreviewFragment.this.getViewModel(WinkNewAlbumPreviewViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.export.u>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment$winkExportViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.export.u invoke() {
                return (com.tencent.mobileqq.wink.editor.export.u) WinkNewAlbumPreviewFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
            }
        });
        this.winkExportViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkExtractCoverViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment$mWinkExtractCoverViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkExtractCoverViewModel invoke() {
                return (WinkExtractCoverViewModel) WinkNewAlbumPreviewFragment.this.getViewModel(WinkExtractCoverViewModel.class);
            }
        });
        this.mWinkExtractCoverViewModel = lazy3;
        this.onClipAssetListener = new OnClipAssetListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.m
            @Override // org.light.listener.OnClipAssetListener
            public final void OnLoadClipError(int i3, String str) {
                WinkNewAlbumPreviewFragment.li(i3, str);
            }
        };
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkNewAlbumPreviewFragment.this).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026rceViewModel::class.java]");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy4;
    }

    private final void Oh(String path, ImageView iv5, Drawable placeholderDrawable) {
        if (path == null || iv5 == null) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setTargetView(iv5);
        obtain.setUrl(path);
        obtain.setRequestWidth(iv5.getLayoutParams().width);
        obtain.setRequestHeight(iv5.getLayoutParams().height);
        obtain.setLoadingDrawable(placeholderDrawable);
        obtain.setFailedDrawable(placeholderDrawable);
        QQPicLoader.f201806a.d().loadImage(obtain, null);
    }

    static /* synthetic */ void Ph(WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment, String str, ImageView imageView, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = ja3.b.INSTANCE.a();
        }
        winkNewAlbumPreviewFragment.Oh(str, imageView, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(WinkNewAlbumPreviewViewModel.b data) {
        IPlayer currentPlayer;
        w53.b.f(getTAG(), "buildPreview ");
        this.mPreviewData = data;
        WinkEditorResourceManager.a1().i0(data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        WinkPlayerContainerView winkPlayerContainerView = new WinkPlayerContainerView(requireContext);
        ConstraintLayout constraintLayout = this.playerFrame;
        WinkVideoTavCut winkVideoTavCut = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
            constraintLayout = null;
        }
        constraintLayout.addView(winkPlayerContainerView);
        final WinkVideoTavCut f16 = WinkPlayerContainerView.f(winkPlayerContainerView, data.getWinkTavCutParams(), null, null, false, this.onClipAssetListener, 14, null);
        this.mVideoCut = f16;
        if (f16 != null) {
            f16.setAutoPlay(true);
            if (f16 instanceof WinkVideoTavCut) {
                winkVideoTavCut = f16;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(true);
            }
            winkPlayerContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkNewAlbumPreviewFragment.Rh(dr.this, this, view);
                }
            });
            f16.Q2(new b());
        }
        dr drVar = this.mVideoCut;
        if (drVar != null && (currentPlayer = drVar.getCurrentPlayer()) != null) {
            currentPlayer.removePlayerListener(this.playerListener);
            currentPlayer.addPlayerListener(this.playerListener);
        }
        dr drVar2 = this.mVideoCut;
        if (drVar2 != null) {
            drVar2.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(dr cut, WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cut, "$cut");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIPlayIconView qUIPlayIconView = null;
        if (cut.isPlaying()) {
            cut.pause();
            QUIPlayIconView qUIPlayIconView2 = this$0.playIcon;
            if (qUIPlayIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            } else {
                qUIPlayIconView = qUIPlayIconView2;
            }
            qUIPlayIconView.setVisibility(0);
        } else {
            cut.play();
            QUIPlayIconView qUIPlayIconView3 = this$0.playIcon;
            if (qUIPlayIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            } else {
                qUIPlayIconView = qUIPlayIconView3;
            }
            qUIPlayIconView.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh() {
        int indexOf;
        List<String> list = this.templateList;
        if (list != null && (!list.isEmpty())) {
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) list), this.selectTemplateId);
            this.selectTemplateId = list.get((indexOf + 1) % list.size());
        }
        ni("\u6a21\u7248\u66f4\u6362\u4e2d");
    }

    private final WinkExtractCoverViewModel Th() {
        Object value = this.mWinkExtractCoverViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkExtractCoverViewModel>(...)");
        return (WinkExtractCoverViewModel) value;
    }

    private final WinkNewAlbumPreviewViewModel Vh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkNewAlbumPreviewViewModel) value;
    }

    private final com.tencent.mobileqq.wink.editor.export.u Wh() {
        Object value = this.winkExportViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkExportViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.export.u) value;
    }

    private final void Xh() {
        Th().m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkNewAlbumPreviewFragment.Yh(WinkNewAlbumPreviewFragment.this, (WinkExtractCoverViewModel.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(WinkNewAlbumPreviewFragment this$0, WinkExtractCoverViewModel.c cVar) {
        Intent intent;
        FragmentActivity activity;
        Intent intent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar.b() == 0) {
            dr drVar = this$0.mVideoCut;
            if (drVar != null) {
                drVar.pause();
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
            this$0.Wh().D2(false);
            if (this$0.isStandalone && (activity = this$0.getActivity()) != null && (intent2 = activity.getIntent()) != null) {
                intent2.putExtra("needRemoveAllLocalPathWhenExport", false);
            }
            com.tencent.mobileqq.wink.editor.export.u Wh = this$0.Wh();
            dr drVar2 = this$0.mVideoCut;
            ArrayList<LocalMediaInfo> a16 = cVar.a();
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            }
            Wh.J2(this$0, drVar2, true, a16, str, WinkContext.INSTANCE.d().k().a(), false, false, this$0.Uh());
        }
    }

    private final void Zh() {
        LiveData<Result<WinkNewAlbumPreviewViewModel.b>> S1 = Vh().S1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends WinkNewAlbumPreviewViewModel.b>, Unit> function1 = new Function1<Result<? extends WinkNewAlbumPreviewViewModel.b>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WinkNewAlbumPreviewViewModel.b> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends WinkNewAlbumPreviewViewModel.b> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean m483isSuccessimpl = Result.m483isSuccessimpl(it.getValue());
                w53.b.f(WinkNewAlbumPreviewFragment.this.getTAG(), "prepared  observe " + m483isSuccessimpl);
                if (!m483isSuccessimpl) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment = WinkNewAlbumPreviewFragment.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = winkNewAlbumPreviewFragment.loadingDialog;
                        if (qCircleCommonLoadingDialog != null) {
                            qCircleCommonLoadingDialog.dismiss();
                        }
                        w53.b.d(winkNewAlbumPreviewFragment.getTAG(), "observa video prepare fail", m479exceptionOrNullimpl);
                        return;
                    }
                    return;
                }
                WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment2 = WinkNewAlbumPreviewFragment.this;
                Object value = it.getValue();
                ResultKt.throwOnFailure(value);
                winkNewAlbumPreviewFragment2.Qh((WinkNewAlbumPreviewViewModel.b) value);
                WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment3 = WinkNewAlbumPreviewFragment.this;
                Object value2 = it.getValue();
                ResultKt.throwOnFailure(value2);
                winkNewAlbumPreviewFragment3.templateId = ((WinkNewAlbumPreviewViewModel.b) value2).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f30533id;
            }
        };
        S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkNewAlbumPreviewFragment.ai(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bi(WinkNewAlbumPreviewFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SeekBar seekBar = this$0.seekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            seekBar = null;
        }
        seekBar.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.mVideoCut;
        if (drVar != null) {
            if (drVar.isPlaying()) {
                drVar.pause();
            } else {
                drVar.play();
            }
        }
        QUIPlayIconView qUIPlayIconView = this$0.playIcon;
        if (qUIPlayIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            qUIPlayIconView = null;
        }
        qUIPlayIconView.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "back");
        this$0.requireActivity().finish();
        WinkNewAlbumPreviewViewModel Vh = this$0.Vh();
        FrameLayout frameLayout = this$0.back;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
            frameLayout = null;
        }
        WinkNewAlbumPreviewViewModel.Q1(Vh, frameLayout, "em_xsj_back_button", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "changePic");
        this$0.ii();
        WinkNewAlbumPreviewViewModel Vh = this$0.Vh();
        LinearLayout linearLayout = this$0.changePic;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePic");
            linearLayout = null;
        }
        WinkNewAlbumPreviewViewModel.Q1(Vh, linearLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_PICTURE_BUTTON, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(WinkNewAlbumPreviewFragment this$0, View view) {
        Map<String, String> mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "changeTemplate");
        WinkNewAlbumPreviewViewModel Vh = this$0.Vh();
        LinearLayout linearLayout = this$0.changeTemplate;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeTemplate");
            linearLayout = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("xsj_template_id", String.valueOf(this$0.selectTemplateId)));
        Vh.P1(linearLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_TEMPLATE_BUTTON, mutableMapOf);
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLimitDuration() {
        dr drVar = this.mVideoCut;
        if (drVar == null) {
            return 0L;
        }
        Intrinsics.checkNotNull(drVar);
        long h16 = drVar.h();
        Intrinsics.checkNotNull(this.mVideoCut);
        return (long) Math.min(r2.getDurationUs(), h16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "next click");
        this$0.ki();
        WinkNewAlbumPreviewViewModel Vh = this$0.Vh();
        QUIButton qUIButton = this$0.nextButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            qUIButton = null;
        }
        WinkNewAlbumPreviewViewModel.Q1(Vh, qUIButton, WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "edit click");
        this$0.ji();
        WinkNewAlbumPreviewViewModel Vh = this$0.Vh();
        LinearLayout linearLayout = this$0.changeEdit;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeEdit");
            linearLayout = null;
        }
        WinkNewAlbumPreviewViewModel.Q1(Vh, linearLayout, "em_xsj_edit_album_button", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
    
        if (r5 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ii() {
        List<MediaInfo> list;
        Bundle bundle;
        Intent intent;
        String str;
        Object orNull;
        Bundle bundle2 = new Bundle();
        bundle2.putString("app_key", "00000QG6YX3X0LZH");
        bundle2.putString("keyAction", "actionSelectPicture");
        ArrayList arrayList = new ArrayList();
        ArrayList<LocalMediaInfo> arrayList2 = this.inputMedia;
        if (arrayList2 != null) {
            for (LocalMediaInfo localMediaInfo : arrayList2) {
                ArrayList<String> mOriginPath = localMediaInfo.mOriginPath;
                if (mOriginPath != null) {
                    Intrinsics.checkNotNullExpressionValue(mOriginPath, "mOriginPath");
                    orNull = CollectionsKt___CollectionsKt.getOrNull(mOriginPath, 0);
                    str = (String) orNull;
                }
                str = localMediaInfo.path;
                String localMediaPath = str;
                if (localMediaPath != null) {
                    Intrinsics.checkNotNullExpressionValue(localMediaPath, "localMediaPath");
                    arrayList.add(new MediaInfo(MediaType.LOCAL_IMAGE, null, 0, 0, localMediaPath, null, null, 0, 0, null, null, 0L, 4078, null));
                }
            }
        }
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.j(500);
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        aVar.c(list);
        Unit unit = Unit.INSTANCE;
        bundle2.putSerializable("WINK_MEDIA_PICKER_CONFIG", aVar.a());
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        bundle2.putAll(bundle);
        com.tencent.mobileqq.wink.f.A(getActivity(), bundle2, 100);
    }

    private final void initSeekBar() {
        View view = this.rootView;
        SeekBar seekBar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.v9e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026sh_seek_bar_frame_layout)");
        this.seekFrameLayout = (FrameLayout) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.vad);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.flash_show_progress_bar)");
        this.seekBar = (SeekBar) findViewById2;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.v9f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ar_progress_current_view)");
        this.videoCurrentProgress = (TextView) findViewById3;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.v9h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026r_progress_duration_view)");
        this.videoDurationProgress = (TextView) findViewById4;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.f123937i0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_preview_progress_layout)");
        this.videoProgressLayout = (RelativeLayout) findViewById5;
        if (this.seekFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekFrameLayout");
        }
        FrameLayout frameLayout = this.seekFrameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekFrameLayout");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = this.seekFrameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekFrameLayout");
            frameLayout2 = null;
        }
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view6, MotionEvent motionEvent) {
                boolean bi5;
                bi5 = WinkNewAlbumPreviewFragment.bi(WinkNewAlbumPreviewFragment.this, view6, motionEvent);
                return bi5;
            }
        });
        RelativeLayout relativeLayout = this.videoProgressLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        SeekBar seekBar2 = this.seekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            seekBar2 = null;
        }
        seekBar2.setMax(1000);
        SeekBar seekBar3 = this.seekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        } else {
            seekBar = seekBar3;
        }
        seekBar.setOnSeekBarChangeListener(new c());
    }

    private final void ji() {
        Bundle bundle;
        MetaMaterial metaMaterial;
        Intent intent;
        Bundle bundle2 = new Bundle();
        Activity hostActivity = getHostActivity();
        String str = null;
        if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        bundle2.putAll(bundle);
        bundle2.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle2.putString("app_key", "00000QG6YX3X0LZH");
        bundle2.putBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, true);
        bundle2.putBoolean(QQWinkConstants.IS_IMAGE_MODEL, true);
        bundle2.putBoolean(QQWinkConstants.IS_EDIT_TEXT, false);
        bundle2.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, false);
        bundle2.putSerializable(QQWinkConstants.INPUT_MEDIA, this.inputMedia);
        WinkNewAlbumPreviewViewModel.b bVar = this.mPreviewData;
        if (bVar != null && (metaMaterial = bVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null) {
            str = metaMaterial.f30533id;
        }
        bundle2.putString("lib_template_id", str);
        bundle2.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_RECOMMEND);
        bundle2.putBoolean("needRemoveAllLocalPathWhenExport", true);
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(getContext(), bundle2);
    }

    private final void ki() {
        String str;
        Intent intent;
        WinkNewAlbumPreviewViewModel.b bVar = this.mPreviewData;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            WinkEditDataWrapper winkEditDataWrapper = bVar.getWinkEditDataWrapper();
            winkEditDataWrapper.setBgmVolumeType(MusicVolumeControlViewModel.VolumeType.TEMPLATE);
            winkEditDataWrapper.setBgmVolume(1.0f);
            winkEditDataWrapper.setOriginVolume(0.0f);
            winkEditDataWrapper.setMusicId(WinkEditorMusicInfo.H);
            winkEditDataWrapper.setSelectMusicMid("fakeMid_template_bgm");
            Wh().I2(winkEditDataWrapper);
            com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
            com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
            qi();
            ri();
            WinkExtractCoverViewModel Th = Th();
            dr drVar = this.mVideoCut;
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            } else {
                str = null;
            }
            Th.d2(this, drVar, winkEditDataWrapper, str, true, winkEditDataWrapper.getBusinessName(), Boolean.FALSE, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(int i3, String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.y
            @Override // java.lang.Runnable
            public final void run() {
                WinkNewAlbumPreviewFragment.mi();
            }
        });
        w53.b.c("WinkNewAlbumPreviewFragment", "\u5a92\u4f53\u8bfb\u53d6\u5931\u8d25" + i3 + ",path=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi() {
        QQToast.makeText(BaseApplication.getContext(), "\u7167\u7247\u5df2\u5220\u9664\uff0c\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u5237\u65b0\u4e00\u4e0b", 0).show();
    }

    private final void ni(String tips) {
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkNewAlbumPreviewFragment.oi(WinkNewAlbumPreviewFragment.this, view);
            }
        }).p(tips).a();
        this.loadingDialog = a16;
        if (a16 != null && !a16.isShowing()) {
            a16.show();
        }
        String str = this.selectTemplateId;
        if (str != null) {
            Vh().W1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(WinkNewAlbumPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void pi() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getFragmentContentView(), WinkDaTongReportConstant.PageId.PG_XSJ_MEMORIES_COLLECTION_PREVIEW_PAGE);
        VideoReport.setPageParams(getFragmentContentView(), new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    private final void qi() {
        List listOf;
        ArrayList arrayListOf;
        ArrayList<ArrayList<WinkPublishMediaRecord>> arrayListOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("tianshu_memoryalbum");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new WinkPublishMediaRecord("template", listOf));
        com.tencent.mobileqq.wink.editor.export.u Wh = Wh();
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(arrayListOf);
        Wh.E2(arrayListOf2);
    }

    private final void ri() {
        ArrayList<String> arrayListOf;
        String topic = Vh().getTopic();
        if (topic != null) {
            com.tencent.mobileqq.wink.editor.export.u Wh = Wh();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(topic);
            Wh.H2(arrayListOf);
        }
    }

    @NotNull
    public final MusicSourceViewModel Uh() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        this.f326530h0.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169195i71;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return -16777216;
    }

    public final void initView() {
        ImageView imageView;
        View view = this.rootView;
        QUIPlayIconView qUIPlayIconView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f25850by);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.player_frame)");
        this.playerFrame = (ConstraintLayout) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f164921bb4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.cover_image)");
        this.coverImage = (ImageView) findViewById2;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.zqn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.next_button)");
        this.nextButton = (QUIButton) findViewById3;
        ConstraintLayout constraintLayout = this.playerFrame;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        ImageView imageView2 = this.coverImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        String str = this.coverImagePath;
        if (str != null) {
            try {
                ImageView imageView3 = this.coverImage;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView = null;
                } else {
                    imageView = imageView3;
                }
                Ph(this, str, imageView, null, 4, null);
                ImageView imageView4 = this.coverImage;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView4 = null;
                }
                imageView4.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView imageView5 = this.coverImage;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView5 = null;
                }
                imageView5.setVisibility(0);
            } catch (Throwable th5) {
                w53.b.c("WinkNewAlbumPreviewFragment", "e " + th5.getMessage());
                ImageView imageView6 = this.coverImage;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView6 = null;
                }
                imageView6.setVisibility(8);
            }
        }
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f164559a43);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.back)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        this.back = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                WinkNewAlbumPreviewFragment.di(WinkNewAlbumPreviewFragment.this, view5);
            }
        });
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.trl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.change_picture)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.changePic = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePic");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                WinkNewAlbumPreviewFragment.ei(WinkNewAlbumPreviewFragment.this, view6);
            }
        });
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.tro);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.change_template)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById6;
        this.changeTemplate = linearLayout2;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeTemplate");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                WinkNewAlbumPreviewFragment.fi(WinkNewAlbumPreviewFragment.this, view7);
            }
        });
        QUIButton qUIButton = this.nextButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                WinkNewAlbumPreviewFragment.gi(WinkNewAlbumPreviewFragment.this, view7);
            }
        });
        QUIButton qUIButton2 = this.nextButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            qUIButton2 = null;
        }
        qUIButton2.setThemeId(1002);
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.trc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.change_edit)");
        LinearLayout linearLayout3 = (LinearLayout) findViewById7;
        this.changeEdit = linearLayout3;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeEdit");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                WinkNewAlbumPreviewFragment.hi(WinkNewAlbumPreviewFragment.this, view8);
            }
        });
        View view8 = this.rootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.f66333ac);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.qui_play_icon_view)");
        QUIPlayIconView qUIPlayIconView2 = (QUIPlayIconView) findViewById8;
        this.playIcon = qUIPlayIconView2;
        if (qUIPlayIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIcon");
        } else {
            qUIPlayIconView = qUIPlayIconView2;
        }
        qUIPlayIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view9) {
                WinkNewAlbumPreviewFragment.ci(WinkNewAlbumPreviewFragment.this, view9);
            }
        });
        WinkNewAlbumPreviewViewModel Vh = Vh();
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Vh.X1(oVar.c(requireContext) + ImmersiveUtils.statusHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == -1) {
                if (data != null) {
                    this.inputMedia = data.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
                }
                Vh().Z1(this.inputMedia);
                String string = getString(R.string.f216385y6);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qqwink_share_video_loading)");
                ni(string);
                return;
            }
            QLog.e("WinkNewAlbumPreviewFragment", 1, "onActivityResult, resultCode:" + resultCode);
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        Object random;
        super.onCreate(savedInstanceState);
        w53.b.c("WinkNewAlbumPreviewFragment", "[WinkNewAlbumPreviewFragment] onCreate");
        ImmersiveUtils.setWindowImmersive(requireActivity().getWindow());
        com.tencent.mobileqq.wink.l.f();
        Intent intent = requireActivity().getIntent();
        if (intent != null) {
            this.inputMedia = intent.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            this.storyId = intent.getStringExtra(QQWinkConstants.STORY_ID);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("templateId");
            this.templateList = stringArrayListExtra;
            Integer num = null;
            if (stringArrayListExtra != null) {
                random = CollectionsKt___CollectionsKt.random(stringArrayListExtra, Random.INSTANCE);
                str = (String) random;
            } else {
                str = null;
            }
            this.selectTemplateId = str;
            this.coverImagePath = intent.getStringExtra(QQWinkConstants.COVER_PATH);
            ArrayList<LocalMediaInfo> arrayList = this.inputMedia;
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            }
            w53.b.a("WinkNewAlbumPreviewFragment", num + " " + this.selectTemplateId);
        }
        Vh().Z1(this.inputMedia);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ImmersiveUtils.setWindowImmersive(requireActivity().getWindow());
        w53.b.c("WinkNewAlbumPreviewFragment", " [WinkPhotoTemplatePreviewFragment] onCreateView ");
        View view = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f169195i71, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026_new_album_preview, null)");
        this.rootView = inflate;
        if (TextUtils.isEmpty(this.selectTemplateId)) {
            this.selectTemplateId = "dapian_qingxukadian";
        }
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            drVar.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            drVar.pause();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        pi();
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            WinkVideoTavCut winkVideoTavCut = null;
            QUIPlayIconView qUIPlayIconView = null;
            if (drVar.isPlaying()) {
                drVar.pause();
                QUIPlayIconView qUIPlayIconView2 = this.playIcon;
                if (qUIPlayIconView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playIcon");
                } else {
                    qUIPlayIconView = qUIPlayIconView2;
                }
                qUIPlayIconView.setVisibility(0);
                return;
            }
            drVar.play();
            QUIPlayIconView qUIPlayIconView3 = this.playIcon;
            if (qUIPlayIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
                qUIPlayIconView3 = null;
            }
            qUIPlayIconView3.setVisibility(8);
            dr drVar2 = this.mVideoCut;
            if (drVar2 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar2;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(true);
            }
            dr drVar3 = this.mVideoCut;
            if (drVar3 != null) {
                drVar3.Z();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initSeekBar();
        Zh();
        String string = getString(R.string.f216385y6);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qqwink_share_video_loading)");
        ni(string);
        Xh();
        w53.b.f("WinkNewAlbumPreviewFragment", "onViewCreated bundlesExists " + ag.f326666a.a());
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/WinkNewAlbumPreviewFragment$b", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "", "a", "I", "firstTimes", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int firstTimes;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkNewAlbumPreviewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ImageView imageView = this$0.coverImage;
            QUIPlayIconView qUIPlayIconView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                imageView = null;
            }
            imageView.setVisibility(8);
            QUIPlayIconView qUIPlayIconView2 = this$0.playIcon;
            if (qUIPlayIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            } else {
                qUIPlayIconView = qUIPlayIconView2;
            }
            qUIPlayIconView.setVisibility(8);
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
            WinkVideoTavCut winkVideoTavCut;
            if (this.firstTimes > 1) {
                return;
            }
            w53.b.c(WinkNewAlbumPreviewFragment.this.getTAG(), "onFirstFrameTimeFinish");
            this.firstTimes++;
            dr drVar = WinkNewAlbumPreviewFragment.this.mVideoCut;
            if (drVar instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(true);
            }
            dr drVar2 = WinkNewAlbumPreviewFragment.this.mVideoCut;
            if (drVar2 != null) {
                drVar2.play();
            }
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = WinkNewAlbumPreviewFragment.this.loadingDialog;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
            Handler d16 = com.tencent.qav.thread.a.d();
            final WinkNewAlbumPreviewFragment winkNewAlbumPreviewFragment = WinkNewAlbumPreviewFragment.this;
            d16.post(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.z
                @Override // java.lang.Runnable
                public final void run() {
                    WinkNewAlbumPreviewFragment.b.b(WinkNewAlbumPreviewFragment.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
