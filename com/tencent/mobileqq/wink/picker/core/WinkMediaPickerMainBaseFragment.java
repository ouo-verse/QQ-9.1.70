package com.tencent.mobileqq.wink.picker.core;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.api.IAEFlashShowMaterialManagerUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.QQWinkPageSwitchEvent;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.WinkExodus;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.InitBean;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaAlbumTitleBarPart;
import com.tencent.mobileqq.wink.picker.core.part.ah;
import com.tencent.mobileqq.wink.picker.core.part.u;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkAlbumListViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.report.AlbumSelectionData;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_PICKER)
@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\b'\u0018\u0000 \u009a\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002\u009b\u0001B\t\u00a2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J0\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0016\u001a\u00020\u0015H&J\u000f\u0010\u0017\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H&J$\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH&J$\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH&J\b\u0010\"\u001a\u00020!H\u0014J!\u0010'\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0014J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\u001a\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\u001a\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u0002022\b\u0010-\u001a\u0004\u0018\u00010&H\u0014J\b\u00107\u001a\u00020\u0004H\u0016J\u0006\u00108\u001a\u00020\tJ\u0016\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>J\u000e\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>J\b\u0010C\u001a\u00020\u0004H\u0004J\b\u0010D\u001a\u00020\tH\u0004J\b\u0010E\u001a\u00020\u0004H\u0014J\b\u0010F\u001a\u00020\u0004H\u0014J/\u0010L\u001a\u00020\u00042\u0006\u0010G\u001a\u00020!2\u000e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\u0006\u0010K\u001a\u00020JH\u0016\u00a2\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020\tH\u0016J\b\u0010O\u001a\u00020\u0004H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\tH\u0004J\u0010\u0010R\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u001b\u0010W\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010$\u001a\u00020#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bY\u0010ZR\u001d\u0010^\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010T\u001a\u0004\b\\\u0010]R\u001b\u0010%\u001a\u00028\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010T\u001a\u0004\b`\u0010\u0018R\u001b\u0010e\u001a\u00020a8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010T\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010T\u001a\u0004\bh\u0010iR$\u0010r\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR#\u0010x\u001a\n t*\u0004\u0018\u00010s0s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010T\u001a\u0004\bv\u0010wR\u001b\u0010}\u001a\u00020y8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010T\u001a\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u007f\u0010T\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R%\u0010\u0087\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020>0\u0084\u00010\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0089\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010gR\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008a\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008b\u0001\u0010T\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R$\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020;0\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R)\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020;0\u0093\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0091\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "T", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerBaseFragment;", "", "ri", "bi", "li", "si", "", "isFromTemplateColl", "ti", "ai", "", "url", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, SensorJsPlugin.SENSOR_INTERVAL_UI, "eventId", "elementId", "operationType", "Gh", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "Oh", "()Lcom/tencent/mobileqq/wink/picker/InitBean;", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "hi", "", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "initBean", "Landroid/os/Bundle;", "Eh", "(Lcom/tencent/mobileqq/wink/picker/Config;Lcom/tencent/mobileqq/wink/picker/InitBean;)Landroid/os/Bundle;", "Fh", "Landroid/content/Context;", "context", "onAttach", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedAfterPartInit", "onResume", "ci", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Landroidx/recyclerview/widget/RecyclerView;", "mediaList", "Dh", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "childFragment", "ni", "mi", "ki", "Ih", "Yh", "gi", "fi", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetach", "Jh", "oi", "D", "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/mobileqq/wink/picker/core/d;", "mediaPickerFactory", "E", "Nh", "()Lcom/tencent/mobileqq/wink/picker/Config;", UserInfo.SEX_FEMALE, "Mh", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "G", "Ph", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "H", "Wh", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "I", "Lh", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "albumListViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "J", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "Qh", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "setLocalMediaViewModel", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;)V", "localMediaViewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "kotlin.jvm.PlatformType", "K", "Vh", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/mobileqq/wink/picker/core/part/u;", "L", "Uh", "()Lcom/tencent/mobileqq/wink/picker/core/part/u;", "permissionPart", "Lcom/tencent/mobileqq/wink/picker/core/part/d;", "M", "Kh", "()Lcom/tencent/mobileqq/wink/picker/core/part/d;", "albumListPart", "Ljava/util/LinkedList;", "Lmqq/util/WeakReference;", "N", "Ljava/util/LinkedList;", "childFragmentStack", "P", "backStackEntryCount", "Lcom/google/android/material/appbar/AppBarLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Xh", "()Lcom/google/android/material/appbar/AppBarLayout;", "topAppbarLayout", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/Map;", "_mediaTypeToMediaList", "", ExifInterface.LATITUDE_SOUTH, "Th", "()Ljava/util/Map;", "mediaTypeToMediaList", "<init>", "()V", "U", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkMediaPickerMainBaseFragment<T extends InitBean> extends WinkMediaPickerBaseFragment {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ColorDrawable V = new ColorDrawable(Color.parseColor("#00000000"));

    @NotNull
    private static final ColorDrawable W = new ColorDrawable(Color.parseColor("#F5F5F5"));

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerFactory;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy businessName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy initBean;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy albumListViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private WinkLocalMediaViewModel localMediaViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy permissionPart;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy albumListPart;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LinkedList<WeakReference<WinkMediaPickerChildFragment>> childFragmentStack;

    /* renamed from: P, reason: from kotlin metadata */
    private int backStackEntryCount;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy topAppbarLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Map<MediaType, RecyclerView> _mediaTypeToMediaList;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Map<MediaType, RecyclerView> mediaTypeToMediaList;

    @NotNull
    public Map<Integer, View> T = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment$a;", "", "Landroid/graphics/drawable/ColorDrawable;", "loadingColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "b", "()Landroid/graphics/drawable/ColorDrawable;", "failedColorDrawable", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorDrawable a() {
            return WinkMediaPickerMainBaseFragment.W;
        }

        @NotNull
        public final ColorDrawable b() {
            return WinkMediaPickerMainBaseFragment.V;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324464a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f324464a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestView;", "requestView", "", "", "deniedPermissions", "onViewShow", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkMediaPickerMainBaseFragment<T> f324465a;

        c(WinkMediaPickerMainBaseFragment<T> winkMediaPickerMainBaseFragment) {
            this.f324465a = winkMediaPickerMainBaseFragment;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f324465a.fi();
            this.f324465a.Ih();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onViewShow(@Nullable PermissionRequestView requestView, @Nullable List<String> deniedPermissions) {
            super.onViewShow(requestView, deniedPermissions);
            this.f324465a.Uh().startInit();
        }
    }

    public WinkMediaPickerMainBaseFragment() {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$mediaPickerFactory$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return this.this$0.Zh();
            }
        });
        this.mediaPickerFactory = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Config>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$config$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Config invoke() {
                Config config;
                Bundle arguments = this.this$0.getArguments();
                Serializable serializable = arguments != null ? arguments.getSerializable("WINK_MEDIA_PICKER_CONFIG") : null;
                Config config2 = serializable instanceof Config ? (Config) serializable : null;
                WinkMediaPickerMainBaseFragment<T> winkMediaPickerMainBaseFragment = this.this$0;
                if (config2 == null) {
                    Config.Companion companion = Config.INSTANCE;
                    config = new Config.a().a();
                } else {
                    config = config2;
                }
                Config Fh = winkMediaPickerMainBaseFragment.Fh(config);
                w53.b.f(this.this$0.getTAG(), "[lazyInitConfig], configFromArgs=" + config2 + ", customized=" + Fh);
                return Fh;
            }
        });
        this.config = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$businessName$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
                }
                return null;
            }
        });
        this.businessName = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<T>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$initBean$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InitBean invoke() {
                Bundle arguments = this.this$0.getArguments();
                Serializable serializable = arguments != null ? arguments.getSerializable("WINK_MEDIA_PICKER_INIT_BEAN") : null;
                InitBean initBean = serializable instanceof InitBean ? (InitBean) serializable : null;
                return initBean == null ? this.this$0.Oh() : initBean;
            }
        });
        this.initBean = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$selectedMediaViewModel$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkSelectedMediaViewModel invoke() {
                return q.j(this.this$0);
            }
        });
        this.selectedMediaViewModel = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAlbumListViewModel>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$albumListViewModel$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkAlbumListViewModel invoke() {
                return q.c(this.this$0);
            }
        });
        this.albumListViewModel = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$qqPermission$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(this.this$0);
            }
        });
        this.qqPermission = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<u>() { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$permissionPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final u invoke() {
                return new u();
            }
        });
        this.permissionPart = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.picker.core.part.d>() { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$albumListPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.picker.core.part.d invoke() {
                return new com.tencent.mobileqq.wink.picker.core.part.d();
            }
        });
        this.albumListPart = lazy9;
        this.childFragmentStack = new LinkedList<>();
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<AppBarLayout>(this) { // from class: com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment$topAppbarLayout$2
            final /* synthetic */ WinkMediaPickerMainBaseFragment<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AppBarLayout invoke() {
                View fragmentContentView;
                fragmentContentView = this.this$0.getFragmentContentView();
                if (fragmentContentView != null) {
                    return (AppBarLayout) fragmentContentView.findViewById(R.id.f166207z02);
                }
                return null;
            }
        });
        this.topAppbarLayout = lazy10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this._mediaTypeToMediaList = linkedHashMap;
        this.mediaTypeToMediaList = linkedHashMap;
    }

    private final void Gh(String eventId, String elementId, String materialId, String operationType) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("dt_eid", elementId);
        params.put("dt_pgid", "pg_xsj_choose_media_new_page");
        params.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        if (operationType != null) {
            params.put("xsj_operation_type", operationType);
        }
        if (materialId != null) {
            params.put("xsj_prop_id", materialId);
        }
        VideoReport.reportEvent(eventId, params);
    }

    static /* synthetic */ void Hh(WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment, String str, String str2, String str3, String str4, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                str3 = null;
            }
            if ((i3 & 8) != 0) {
                str4 = null;
            }
            winkMediaPickerMainBaseFragment.Gh(str, str2, str3, str4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitDialogDtReport");
    }

    private final com.tencent.mobileqq.wink.picker.core.part.d Kh() {
        return (com.tencent.mobileqq.wink.picker.core.part.d) this.albumListPart.getValue();
    }

    private final QQPermission Vh() {
        return (QQPermission) this.qqPermission.getValue();
    }

    private final boolean ai() {
        return false;
    }

    private final void bi() {
        Bundle bundle;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            WinkExodus m3 = WinkContext.INSTANCE.d().m();
            Intent intent = activity.getIntent();
            if (intent != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            m3.j(activity, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ei(WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment, boolean z16, List list, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                list = null;
            }
            winkMediaPickerMainBaseFragment.di(z16, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNextBtnClick");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ii(WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment, boolean z16, List list, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                list = null;
            }
            winkMediaPickerMainBaseFragment.hi(z16, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoTemplateClick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(WinkMediaPickerMainBaseFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildFragmentManager().getBackStackEntryCount() == 0) {
            this$0.setStatusBarTextColor();
        }
        if (this$0.backStackEntryCount < this$0.getChildFragmentManager().getBackStackEntryCount()) {
            this$0.li();
        } else if (this$0.backStackEntryCount > this$0.getChildFragmentManager().getBackStackEntryCount()) {
            this$0.si();
        }
        this$0.backStackEntryCount = this$0.getChildFragmentManager().getBackStackEntryCount();
    }

    private final void li() {
        Object orNull;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        orNull = CollectionsKt___CollectionsKt.getOrNull(fragments, getChildFragmentManager().getFragments().size() - 2);
        Fragment fragment = (Fragment) orNull;
        if (fragment instanceof WinkMediaPickerChildFragment) {
            getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(WinkMediaPickerMainBaseFragment this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "exit dialog confirm");
        com.tencent.mobileqq.wink.picker.report.a.s(this$0.getView(), z16);
        this$0.gi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(WinkMediaPickerMainBaseFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.c(this$0.getTAG(), "exit dialog cancel");
    }

    private final void ri() {
        if (Yh()) {
            return;
        }
        Vh().requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 1, new c(this));
    }

    private final void si() {
        Object lastOrNull;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        Fragment fragment = (Fragment) lastOrNull;
        if (fragment instanceof WinkMediaPickerChildFragment) {
            getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.RESUMED).commitAllowingStateLoss();
        }
    }

    private final void ti(boolean isFromTemplateColl) {
        String str;
        CharSequence trim;
        boolean equals;
        CharSequence trim2;
        boolean z16;
        if (!Wh().getSelectedMedia().isEmpty() && Nh().getNeedShowExitDialog()) {
            oi(isFromTemplateColl);
            return;
        }
        if (ai()) {
            AEMaterialMetaData randomGuildPic = ((IAEFlashShowMaterialManagerUtil) QRoute.api(IAEFlashShowMaterialManagerUtil.class)).getRandomGuildPic();
            String str2 = null;
            if (randomGuildPic != null) {
                str = randomGuildPic.guidePic;
            } else {
                str = null;
            }
            boolean z17 = false;
            if (str != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) str);
                equals = StringsKt__StringsJVMKt.equals(trim.toString(), "null", true);
                if (!equals) {
                    trim2 = StringsKt__StringsKt.trim((CharSequence) str);
                    if (trim2.toString().length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
            }
            if (z17) {
                if (randomGuildPic != null) {
                    str2 = randomGuildPic.guidePic;
                }
                Intrinsics.checkNotNull(str2);
                String str3 = randomGuildPic.f69050id;
                Intrinsics.checkNotNullExpressionValue(str3, "metaData.id");
                ui(str2, str3);
                return;
            }
            gi();
            return;
        }
        gi();
    }

    private final void ui(String url, final String materialId) {
        final QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), 0);
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setCanceledOnTouchOutside(false);
        View inflate = LayoutInflater.from(qQCustomDialog.getContext()).inflate(R.layout.f168629g44, (ViewGroup) null);
        w53.b.f(getTAG(), "showGuidePicDialog... url:" + url + " id:" + materialId);
        Option picOption = Option.obtain().setTargetView((WinkRoundedCornerImageView) inflate.findViewById(R.id.xhh)).setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(picOption, "picOption");
        qQPicLoader.e(picOption, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.picker.core.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                WinkMediaPickerMainBaseFragment.vi(loadState, option);
            }
        });
        QUIButton qUIButton = (QUIButton) inflate.findViewById(R.id.uxs);
        qUIButton.setTextColor(qUIButton.getContext().getColorStateList(R.color.czz));
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMediaPickerMainBaseFragment.wi(WinkMediaPickerMainBaseFragment.this, materialId, qQCustomDialog, view);
            }
        });
        QUIButton qUIButton2 = (QUIButton) inflate.findViewById(R.id.aoo);
        qUIButton2.setTextColor(qUIButton2.getContext().getColorStateList(R.color.czy));
        qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMediaPickerMainBaseFragment.xi(WinkMediaPickerMainBaseFragment.this, materialId, qQCustomDialog, view);
            }
        });
        inflate.findViewById(R.id.f164822az1).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMediaPickerMainBaseFragment.yi(WinkMediaPickerMainBaseFragment.this, materialId, qQCustomDialog, view);
            }
        });
        qQCustomDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.wink.picker.core.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                WinkMediaPickerMainBaseFragment.zi(WinkMediaPickerMainBaseFragment.this, materialId, dialogInterface);
            }
        });
        qQCustomDialog.setContentView(inflate);
        Hh(this, "ev_xsj_abnormal_imp", WinkDaTongReportConstant.ElementId.EM_XSJ_SHOT_GUIDE_POP, materialId, null, 8, null);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(LoadState loadState, Option option) {
        r01.c cVar;
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(option, "option");
        if (loadState.isFinishSuccess()) {
            Animatable animatable = option.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.setLoopCount(1000);
                cVar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(WinkMediaPickerMainBaseFragment this$0, String materialId, QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(materialId, "$materialId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Gh("ev_xsj_abnormal_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_SHOT_GUID_OPERATION, materialId, "exit");
        this$0.gi();
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(WinkMediaPickerMainBaseFragment this$0, String materialId, QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(materialId, "$materialId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Gh("ev_xsj_abnormal_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_SHOT_GUID_OPERATION, materialId, WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_CONTINUE);
        this_apply.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        if (activity != null) {
            FragmentActivity activity2 = this$0.getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            q.a(activity2).N1(materialId);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQWinkPageSwitchEvent(QQWinkPage.Capture));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(WinkMediaPickerMainBaseFragment this$0, String materialId, QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(materialId, "$materialId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Gh("ev_xsj_abnormal_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_SHOT_GUID_OPERATION, materialId, "close");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(WinkMediaPickerMainBaseFragment this$0, String materialId, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(materialId, "$materialId");
        this$0.Gh("ev_xsj_abnormal_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_SHOT_GUID_OPERATION, materialId, "close");
    }

    public final void Dh(@NotNull MediaType mediaType, @NotNull RecyclerView mediaList) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this._mediaTypeToMediaList.put(mediaType, mediaList);
        getPartManager().broadcastMessage("MSG_ADD_MEDIA_LIST", mediaType);
    }

    @NotNull
    public final Bundle Eh(@Nullable Config config, @Nullable T initBean) {
        Bundle bundle = new Bundle();
        if (config == null) {
            Config.Companion companion = Config.INSTANCE;
            Config.a aVar = new Config.a();
            Unit unit = Unit.INSTANCE;
            config = aVar.a();
        }
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", config);
        if (initBean == null) {
            initBean = Oh();
        }
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", initBean);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Config Fh(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return config;
    }

    protected final void Ih() {
        boolean Yh = Yh();
        if (Yh()) {
            w53.b.f(getTAG(), "fetchMediaData invoke");
            WinkLocalMediaViewModel winkLocalMediaViewModel = this.localMediaViewModel;
            if (winkLocalMediaViewModel != null) {
                winkLocalMediaViewModel.fetchFirstPageMedia();
            }
            Wh().a2();
            q.c(this).Z1();
        }
        com.tencent.mobileqq.wink.picker.h.f324861a.g(Sh(), Nh().getLocalMediaTabType(), Yh, Wh().getNeedFaceDetectWhenSelect());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Jh() {
        boolean z16;
        if (!this.childFragmentStack.isEmpty()) {
            WinkMediaPickerChildFragment winkMediaPickerChildFragment = this.childFragmentStack.pop().get();
            if (winkMediaPickerChildFragment != null && winkMediaPickerChildFragment.onBackEvent()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkAlbumListViewModel Lh() {
        return (WinkAlbumListViewModel) this.albumListViewModel.getValue();
    }

    @Nullable
    public final String Mh() {
        return (String) this.businessName.getValue();
    }

    @NotNull
    public final Config Nh() {
        return (Config) this.config.getValue();
    }

    @NotNull
    public abstract T Oh();

    @NotNull
    public final T Ph() {
        return (T) this.initBean.getValue();
    }

    @Nullable
    /* renamed from: Qh, reason: from getter */
    public final WinkLocalMediaViewModel getLocalMediaViewModel() {
        return this.localMediaViewModel;
    }

    @NotNull
    public final d Rh() {
        return (d) this.mediaPickerFactory.getValue();
    }

    @NotNull
    public abstract WinkMediaPickerScene Sh();

    @NotNull
    public final Map<MediaType, RecyclerView> Th() {
        return this.mediaTypeToMediaList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final u Uh() {
        return (u) this.permissionPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkSelectedMediaViewModel Wh() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    @Nullable
    public final AppBarLayout Xh() {
        return (AppBarLayout) this.topAppbarLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Yh() {
        boolean z16;
        if (Vh().hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && Vh().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.f(getTAG(), "check storage permission " + z16);
        WinkLocalMediaViewModel winkLocalMediaViewModel = this.localMediaViewModel;
        if (winkLocalMediaViewModel != null) {
            winkLocalMediaViewModel.updateStoragePermission(z16);
        }
        return z16;
    }

    @NotNull
    public abstract d Zh();

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.T.clear();
    }

    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uh());
        arrayList.add(new WinkMediaAlbumTitleBarPart());
        arrayList.add(Kh());
        arrayList.add(new ah());
        arrayList.addAll(Rh().g());
        return arrayList;
    }

    public final boolean ci() {
        return Wh().getNeedFaceDetectWhenSelect();
    }

    public abstract void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia);

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gi() {
        Object m476constructorimpl;
        w53.b.f(getTAG(), "onPickerExit invoke");
        AlbumSelectionData.a();
        WinkDatongCurrentParams.clearAll();
        bi();
        try {
            Result.Companion companion = Result.INSTANCE;
            com.tencent.mobileqq.wink.picker.h.f324861a.b(Sh(), Wh().getNeedFaceDetectWhenSelect());
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            com.tencent.mobileqq.wink.picker.h.f324861a.b(Sh(), false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    public abstract void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia);

    public final void ki(@NotNull WinkMediaPickerChildFragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        getChildFragmentManager().beginTransaction().setTransition(4097).add(R.id.cks, childFragment).addToBackStack(null).commitAllowingStateLoss();
    }

    public final void mi(@NotNull WinkMediaPickerChildFragment childFragment) {
        WinkMediaPickerChildFragment winkMediaPickerChildFragment;
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        WeakReference<WinkMediaPickerChildFragment> peek = this.childFragmentStack.peek();
        if (peek != null) {
            winkMediaPickerChildFragment = peek.get();
        } else {
            winkMediaPickerChildFragment = null;
        }
        if (Intrinsics.areEqual(winkMediaPickerChildFragment, childFragment)) {
            this.childFragmentStack.pop();
        }
    }

    public final void ni(@NotNull WinkMediaPickerChildFragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        this.childFragmentStack.push(new WeakReference<>(childFragment));
    }

    protected void oi(final boolean isFromTemplateColl) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewUtilsKt.n(requireActivity, R.string.f215165uv, R.string.f215155uu, Integer.valueOf(R.string.f215175uw), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkMediaPickerMainBaseFragment.pi(WinkMediaPickerMainBaseFragment.this, isFromTemplateColl, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkMediaPickerMainBaseFragment.qi(WinkMediaPickerMainBaseFragment.this, dialogInterface, i3);
            }
        }, null, 64, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        com.tencent.mobileqq.wink.picker.core.c.f324480a.j(this);
        ViewExKt.g();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Application application;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            application = activity.getApplication();
        } else {
            application = null;
        }
        if (application == null) {
            gi();
            return true;
        }
        if (Intrinsics.areEqual(Lh().T1().getValue(), Boolean.TRUE)) {
            Lh().b2();
            return true;
        }
        if (Jh()) {
            return true;
        }
        ti(this instanceof QCircleTemplateLibraryMediaPickerFragment);
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        WinkLocalMediaViewModel d16;
        MediaType mediaType;
        Wh().g2(Nh().getMaxSelectMediaSize());
        Wh().f2(Nh().getStartCountNum());
        TabType initLocalDbQueryType = Nh().getInitLocalDbQueryType();
        int[] iArr = b.f324464a;
        int i3 = iArr[initLocalDbQueryType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                d16 = q.d(this, MediaType.LOCAL_ALL);
            } else {
                d16 = q.d(this, MediaType.LOCAL_IMAGE);
            }
        } else {
            d16 = q.d(this, MediaType.LOCAL_VIDEO);
        }
        int i16 = iArr[Nh().getLocalMediaTabType().ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                mediaType = MediaType.LOCAL_ALL;
            } else {
                mediaType = MediaType.LOCAL_IMAGE;
            }
        } else {
            mediaType = MediaType.LOCAL_VIDEO;
        }
        d16.observeAlbumChange(Lh().U1(), mediaType);
        this.localMediaViewModel = d16;
        Intent intent = getHostActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        d16.setIntent(intent);
        Ih();
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c93.a.f30473a.d();
        ExtractCoverHelper.f320276a.p();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.tencent.mobileqq.wink.picker.core.c.f324480a.n(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Vh().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Uh().z9() && Yh()) {
            Ih();
            Uh().B9();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.wink.picker.core.e
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                WinkMediaPickerMainBaseFragment.ji(WinkMediaPickerMainBaseFragment.this);
            }
        });
        if (Nh().getZoneMediaTabType() != null) {
            q.i(this).O1();
        }
        if (!Yh()) {
            com.tencent.mobileqq.wink.picker.h.f324861a.d(WinkLocalMediaViewModel.FIRST_QUERY_DONE_NO_PERMISSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        ri();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fi() {
    }
}
