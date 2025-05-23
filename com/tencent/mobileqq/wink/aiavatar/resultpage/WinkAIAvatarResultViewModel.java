package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.IQQAvatarUpdateAvatarUtilsApi;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarFinishEvent;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils;
import com.tencent.mobileqq.wink.aigc.utils.WinkMakeAIImageResponse;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.ak;
import com.tencent.mobileqq.wink.utils.al;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00a1\u00012\u00020\u0001:\u0002\u00a2\u0001B\t\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a0\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J%\u0010\u0015\u001a\u00020\u00062\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002J,\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J#\u0010 \u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u0006H\u0014J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\fJ\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0012J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bJ\u0012\u0010,\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010-\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010.\u001a\u0004\u0018\u00010\bJ\u0006\u0010/\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u00020\u0006J\u0006\u00104\u001a\u00020\fJ\u0006\u00105\u001a\u000200J\b\u00106\u001a\u0004\u0018\u000100J\u0006\u00107\u001a\u00020\u0004J.\u0010>\u001a\u00020\u00062\u0006\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u00020\u00042\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010=\u001a\u00020\u0004J\b\u0010?\u001a\u00020\u0006H\u0016J\u0006\u0010@\u001a\u00020\u0006J\u0010\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u000200J \u0010B\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012J#\u0010D\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010F\u001a\u00020\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;J\u0006\u0010G\u001a\u00020\fR\u0016\u0010J\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR6\u0010S\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010Kj\n\u0012\u0004\u0012\u00020(\u0018\u0001`L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR6\u0010W\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010Kj\n\u0012\u0004\u0012\u00020(\u0018\u0001`L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010N\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR\"\u0010]\u001a\u0002008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010I\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010_\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010IR\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010g\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\b0p8\u0006\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020v0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010nR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020v0p8\u0006\u00a2\u0006\f\n\u0004\by\u0010r\u001a\u0004\bz\u0010tR \u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00040l8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b|\u0010n\u001a\u0004\b}\u0010~R \u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040p8\u0006\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010r\u001a\u0005\b\u0081\u0001\u0010tR\u001c\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040l8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010nR \u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040p8\u0006\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010r\u001a\u0005\b\u0086\u0001\u0010tR)\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00120l8\u0004X\u0084\u0004\u00a2\u0006\u000e\n\u0005\b\u0088\u0001\u0010n\u001a\u0005\b\u0089\u0001\u0010~R&\u0010\u008d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00120p8\u0006\u00a2\u0006\u000e\n\u0005\b\u008b\u0001\u0010r\u001a\u0005\b\u008c\u0001\u0010tR+\u0010\u0092\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u008f\u00010\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R,\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0093\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010\u009e\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/os/Bundle;", "arguments", "", "K2", "", "I2", "Lcom/tencent/mobileqq/wink/aigc/utils/c;", "response", "L2", "(Lcom/tencent/mobileqq/wink/aigc/utils/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "imagePath", "M2", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRegenerate", "f2", "", "Landroid/graphics/Bitmap;", "originBimapList", "W2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.BASE_IN_PLUGIN_VERSION, "l2", "url", ICustomDataEditor.NUMBER_PARAM_2, "syncQZone", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "y2", "Q2", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogTag", "onCleared", "e2", Constants.MMCCID, "E2", "v2", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "t2", "avatarResult", "V2", "H2", "J2", "m2", "d2", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "U2", "S2", "x2", "w2", "u2", "F2", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "needFinishActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "notifyUI", "g2", "P2", "R2", "j2", "i2", MimeHelper.IMAGE_SUBTYPE_BITMAP, "T2", "(Landroid/graphics/Bitmap;Ljava/lang/Boolean;)V", "N2", NowProxyConstants.AccountInfoKey.A2, "i", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "originStyleMaterial", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "getOriginLocalMediaInfoList", "()Ljava/util/ArrayList;", "setOriginLocalMediaInfoList", "(Ljava/util/ArrayList;)V", "originLocalMediaInfoList", BdhLogUtil.LogTag.Tag_Conn, "o2", "setImagePickerLocalMediaInfos", "imagePickerLocalMediaInfos", "D", "getLastSelectedStyleMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setLastSelectedStyleMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "lastSelectedStyleMaterial", "E", "selectedStyleMaterial", UserInfo.SEX_FEMALE, "Z", "isCoupleAvatar", "G", "isSchemeJump", "H", "Ljava/lang/String;", "comeFrom", "Lkotlinx/coroutines/Job;", "I", "Lkotlinx/coroutines/Job;", "generateJob", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "_onAIAvatarGenerated", "Landroidx/lifecycle/LiveData;", "K", "Landroidx/lifecycle/LiveData;", "p2", "()Landroidx/lifecycle/LiveData;", "onAIAvatarGenerated", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "L", "_shareInfoCategoryLiveData", "M", "z2", "shareInfoCategoryLiveData", "N", "B2", "()Landroidx/lifecycle/MutableLiveData;", "_onAvatarSet", "P", "r2", "onAvatarSet", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_onAvatarDownloaded", BdhLogUtil.LogTag.Tag_Req, "q2", "onAvatarDownloaded", ExifInterface.LATITUDE_SOUTH, "C2", "_onRecommendStyles", "T", ICustomDataEditor.STRING_PARAM_2, "onRecommendStyles", "", "Lkotlin/Pair;", "U", "Ljava/util/List;", "croppedImageList", "", "V", "Ljava/util/Map;", "k2", "()Ljava/util/Map;", "avatarResultCache", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "W", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "qqUserInfo", "X", "schemeUserNickName", "<init>", "()V", "Y", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkAIAvatarResultViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> imagePickerLocalMediaInfos;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isCoupleAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isSchemeJump;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Job generateJob;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkMakeAIImageResponse> _onAIAvatarGenerated;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<WinkMakeAIImageResponse> onAIAvatarGenerated;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaCategory> _shareInfoCategoryLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MetaCategory> shareInfoCategoryLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _onAvatarSet;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> onAvatarSet;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _onAvatarDownloaded;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> onAvatarDownloaded;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaMaterial>> _onRecommendStyles;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<MetaMaterial>> onRecommendStyles;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, String>> croppedImageList;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Map<String, WinkMakeAIImageResponse> avatarResultCache;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.ntrelation.friendsinfo.bean.d qqUserInfo;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String schemeUserNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> originLocalMediaInfoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MetaMaterial originStyleMaterial = new MetaMaterial();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MetaMaterial lastSelectedStyleMaterial = new MetaMaterial();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MetaMaterial selectedStyleMaterial = new MetaMaterial();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String comeFrom = "0";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkAIAvatarResultViewModel f317793d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CoroutineExceptionHandler.Companion companion, WinkAIAvatarResultViewModel winkAIAvatarResultViewModel) {
            super(companion);
            this.f317793d = winkAIAvatarResultViewModel;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAIAvatarResultViewModel", "generateAIAvatar exception: " + stackTraceToString);
            if (!(exception instanceof CancellationException)) {
                MutableLiveData mutableLiveData = this.f317793d._onAIAvatarGenerated;
                String y06 = com.tencent.mobileqq.wink.editor.c.y0(this.f317793d.selectedStyleMaterial);
                String str = this.f317793d.selectedStyleMaterial.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "selectedStyleMaterial.id");
                mutableLiveData.postValue(new WinkMakeAIImageResponse(false, -1L, null, false, y06, str, new ArrayList(), ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "state", "Lcom/tencent/libra/LoadState;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/libra/request/Option;", "onStateChange"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class c implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Unit> f317794d;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Unit> cancellableContinuation) {
            this.f317794d = cancellableContinuation;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public final void onStateChange(LoadState loadState, Option option) {
            boolean z16 = false;
            if (loadState != null && loadState.isFinish()) {
                z16 = true;
            }
            if (z16) {
                CancellableContinuation<Unit> cancellableContinuation = this.f317794d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel$d", "Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi$a;", "", "success", "", "msg", "", "onResult", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements IQQAvatarUpdateAvatarUtilsApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f317795a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f317795a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.avatar.IQQAvatarUpdateAvatarUtilsApi.a
        public void onResult(boolean success, @Nullable String msg2) {
            w53.b.f("WinkAIAvatarResultViewModel", "setAvatar onResult success? " + success + ", msg: " + msg2);
            this.f317795a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(success)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public e(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAIAvatarResultViewModel", "setAvatar exception: " + stackTraceToString);
        }
    }

    public WinkAIAvatarResultViewModel() {
        MutableLiveData<WinkMakeAIImageResponse> mutableLiveData = new MutableLiveData<>();
        this._onAIAvatarGenerated = mutableLiveData;
        this.onAIAvatarGenerated = mutableLiveData;
        MutableLiveData<MetaCategory> mutableLiveData2 = new MutableLiveData<>();
        this._shareInfoCategoryLiveData = mutableLiveData2;
        this.shareInfoCategoryLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._onAvatarSet = mutableLiveData3;
        this.onAvatarSet = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._onAvatarDownloaded = mutableLiveData4;
        this.onAvatarDownloaded = mutableLiveData4;
        MutableLiveData<List<MetaMaterial>> mutableLiveData5 = new MutableLiveData<>();
        this._onRecommendStyles = mutableLiveData5;
        this.onRecommendStyles = mutableLiveData5;
        this.croppedImageList = new ArrayList();
        this.avatarResultCache = new LinkedHashMap();
        this.schemeUserNickName = "";
    }

    private final void D2() {
        boolean z16;
        String curUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(curUin, "curUin");
        String uidFromUin = iFriendsInfoService.getUidFromUin(curUin);
        if (uidFromUin != null && uidFromUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.qqUserInfo = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "WinkAIAvatarResultViewModel");
        }
    }

    private final void I2(Bundle arguments) {
        Serializable serializable;
        Serializable serializable2;
        Serializable serializable3;
        Integer num = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("selected_style_material");
        } else {
            serializable = null;
        }
        MetaMaterial metaMaterial = (MetaMaterial) serializable;
        if (metaMaterial != null) {
            this.originStyleMaterial = metaMaterial;
        }
        MetaMaterial metaMaterial2 = this.originStyleMaterial;
        this.selectedStyleMaterial = metaMaterial2;
        this.lastSelectedStyleMaterial = metaMaterial2;
        if (arguments != null) {
            serializable2 = arguments.getSerializable("selected_local_media_info_list");
        } else {
            serializable2 = null;
        }
        this.originLocalMediaInfoList = (ArrayList) serializable2;
        if (arguments != null) {
            serializable3 = arguments.getSerializable("selected_origin_local_media_info_list");
        } else {
            serializable3 = null;
        }
        this.imagePickerLocalMediaInfos = (ArrayList) serializable3;
        boolean z16 = true;
        if (!com.tencent.mobileqq.wink.editor.c.Z0(this.originStyleMaterial)) {
            z16 = false;
        }
        this.isCoupleAvatar = z16;
        String str = this.originStyleMaterial.f30533id;
        ArrayList<LocalMediaInfo> arrayList = this.originLocalMediaInfoList;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        w53.b.f("WinkAIAvatarResultViewModel", "parseArguments: " + str + ", " + z16 + ", " + num);
    }

    private final boolean K2(Bundle arguments) {
        String str;
        String str2;
        List split$default;
        boolean z16;
        Object orNull;
        List split$default2;
        if (arguments != null) {
            str = arguments.getString("key_scheme");
        } else {
            str = null;
        }
        w53.b.f("WinkAIAvatarResultViewModel", "parseSchemeArguments: " + str);
        com.tencent.mobileqq.wink.schema.d dVar = com.tencent.mobileqq.wink.schema.d.f326305a;
        int i3 = 0;
        if (!Intrinsics.areEqual(dVar.l("target", arguments), "25")) {
            return false;
        }
        this.isSchemeJump = true;
        String l3 = dVar.l("material_id", arguments);
        if (l3 != null) {
            this.originStyleMaterial.f30533id = l3;
        }
        String l16 = dVar.l(PictureConst.KEY_CATEGORY_ID, arguments);
        if (l16 != null) {
            WinkAIAvatarUtils.f317678a.z(this.originStyleMaterial, l16);
        }
        ArrayList arrayList = new ArrayList();
        String l17 = dVar.l("gender", arguments);
        if (l17 != null) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) l17, new String[]{";;;"}, false, 0, 6, (Object) null);
            arrayList.addAll(split$default2);
        }
        String l18 = dVar.l("nickname", arguments);
        if (l18 != null) {
            this.schemeUserNickName = l18;
        }
        String l19 = dVar.l(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, arguments);
        if (l19 == null) {
            str2 = "";
        } else {
            str2 = l19;
        }
        this.selectedStyleMaterial = this.originStyleMaterial;
        ArrayList arrayList2 = new ArrayList();
        String l26 = dVar.l("medias", arguments);
        if (l26 != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) l26, new String[]{";;;"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isCoupleAvatar = z16;
            for (Object obj : split$default) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3);
                String str4 = (String) orNull;
                if (str4 == null) {
                    str4 = "";
                }
                arrayList2.add(new WinkMakeAIImageResponse.Media(str3, "", str4));
                i3 = i16;
            }
        }
        String y06 = com.tencent.mobileqq.wink.editor.c.y0(this.selectedStyleMaterial);
        String str5 = this.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str5, "selectedStyleMaterial.id");
        WinkMakeAIImageResponse winkMakeAIImageResponse = new WinkMakeAIImageResponse(true, 0L, null, false, y06, str5, arrayList2, str2);
        Map<String, WinkMakeAIImageResponse> map = this.avatarResultCache;
        String str6 = this.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str6, "selectedStyleMaterial.id");
        map.put(str6, winkMakeAIImageResponse);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object L2(WinkMakeAIImageResponse winkMakeAIImageResponse, Continuation<? super Unit> continuation) {
        WinkAIAvatarResultViewModel$preloadResultImage$1 winkAIAvatarResultViewModel$preloadResultImage$1;
        Object coroutine_suspended;
        int i3;
        Iterator it;
        WinkAIAvatarResultViewModel winkAIAvatarResultViewModel;
        if (continuation instanceof WinkAIAvatarResultViewModel$preloadResultImage$1) {
            winkAIAvatarResultViewModel$preloadResultImage$1 = (WinkAIAvatarResultViewModel$preloadResultImage$1) continuation;
            int i16 = winkAIAvatarResultViewModel$preloadResultImage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkAIAvatarResultViewModel$preloadResultImage$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkAIAvatarResultViewModel$preloadResultImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAIAvatarResultViewModel$preloadResultImage$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (Iterator) winkAIAvatarResultViewModel$preloadResultImage$1.L$1;
                        winkAIAvatarResultViewModel = (WinkAIAvatarResultViewModel) winkAIAvatarResultViewModel$preloadResultImage$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    it = winkMakeAIImageResponse.b().iterator();
                    winkAIAvatarResultViewModel = this;
                }
                while (it.hasNext()) {
                    String imageUrl = ((WinkMakeAIImageResponse.Media) it.next()).getImageUrl();
                    winkAIAvatarResultViewModel$preloadResultImage$1.L$0 = winkAIAvatarResultViewModel;
                    winkAIAvatarResultViewModel$preloadResultImage$1.L$1 = it;
                    winkAIAvatarResultViewModel$preloadResultImage$1.label = 1;
                    if (winkAIAvatarResultViewModel.M2(imageUrl, winkAIAvatarResultViewModel$preloadResultImage$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        winkAIAvatarResultViewModel$preloadResultImage$1 = new WinkAIAvatarResultViewModel$preloadResultImage$1(this, continuation);
        Object obj2 = winkAIAvatarResultViewModel$preloadResultImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAIAvatarResultViewModel$preloadResultImage$1.label;
        if (i3 == 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    private final Object M2(String str, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Option option = Option.obtain();
        option.setUrl(str);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2() {
        SimpleEventBus.getInstance().dispatchEvent(new WinkAIAvatarFinishEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q2(String str, boolean z16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IQQAvatarUpdateAvatarUtilsApi) QRoute.api(IQQAvatarUpdateAvatarUtilsApi.class)).setUserAvatar(str, z16, new d(cancellableContinuationImpl), y2(z16));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x013e -> B:11:0x0141). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object W2(List<Bitmap> list, Continuation<? super Unit> continuation) {
        WinkAIAvatarResultViewModel$updateCroppedImageList$1 winkAIAvatarResultViewModel$updateCroppedImageList$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        boolean z17;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Iterator it;
        WinkAIAvatarResultViewModel winkAIAvatarResultViewModel;
        int collectionSizeOrDefault2;
        WinkAIAvatarResultViewModel winkAIAvatarResultViewModel2;
        Iterator it5;
        String str;
        if (continuation instanceof WinkAIAvatarResultViewModel$updateCroppedImageList$1) {
            winkAIAvatarResultViewModel$updateCroppedImageList$1 = (WinkAIAvatarResultViewModel$updateCroppedImageList$1) continuation;
            int i16 = winkAIAvatarResultViewModel$updateCroppedImageList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkAIAvatarResultViewModel$updateCroppedImageList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkAIAvatarResultViewModel$updateCroppedImageList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAIAvatarResultViewModel$updateCroppedImageList$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str = (String) winkAIAvatarResultViewModel$updateCroppedImageList$1.L$2;
                            it5 = (Iterator) winkAIAvatarResultViewModel$updateCroppedImageList$1.L$1;
                            winkAIAvatarResultViewModel2 = (WinkAIAvatarResultViewModel) winkAIAvatarResultViewModel$updateCroppedImageList$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            String str2 = (String) ((Pair) obj).getSecond();
                            w53.b.f("WinkAIAvatarResultViewModel", "updateCroppedImageList imageUrl: " + str + " safeID: " + str2);
                            winkAIAvatarResultViewModel2.croppedImageList.add(TuplesKt.to(str, str2));
                            it = it5;
                            winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                            if (it.hasNext()) {
                                String imagePath = (String) it.next();
                                al alVar = al.f326675a;
                                Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$0 = winkAIAvatarResultViewModel;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$1 = it;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$2 = null;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.label = 1;
                                Object b16 = al.b(alVar, imagePath, false, winkAIAvatarResultViewModel$updateCroppedImageList$1, 2, null);
                                if (b16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                winkAIAvatarResultViewModel2 = winkAIAvatarResultViewModel;
                                obj = b16;
                                it5 = it;
                                str = (String) obj;
                                WinkAIGCRequestUtils winkAIGCRequestUtils = WinkAIGCRequestUtils.f317926a;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$0 = winkAIAvatarResultViewModel2;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$1 = it5;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.L$2 = str;
                                winkAIAvatarResultViewModel$updateCroppedImageList$1.label = 2;
                                obj = winkAIGCRequestUtils.i("qzone_ai_avatar", str, false, winkAIAvatarResultViewModel$updateCroppedImageList$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                String str22 = (String) ((Pair) obj).getSecond();
                                w53.b.f("WinkAIAvatarResultViewModel", "updateCroppedImageList imageUrl: " + str + " safeID: " + str22);
                                winkAIAvatarResultViewModel2.croppedImageList.add(TuplesKt.to(str, str22));
                                it = it5;
                                winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                                if (it.hasNext()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) winkAIAvatarResultViewModel$updateCroppedImageList$1.L$1;
                    WinkAIAvatarResultViewModel winkAIAvatarResultViewModel3 = (WinkAIAvatarResultViewModel) winkAIAvatarResultViewModel$updateCroppedImageList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    winkAIAvatarResultViewModel2 = winkAIAvatarResultViewModel3;
                    it5 = it;
                    str = (String) obj;
                    WinkAIGCRequestUtils winkAIGCRequestUtils2 = WinkAIGCRequestUtils.f317926a;
                    winkAIAvatarResultViewModel$updateCroppedImageList$1.L$0 = winkAIAvatarResultViewModel2;
                    winkAIAvatarResultViewModel$updateCroppedImageList$1.L$1 = it5;
                    winkAIAvatarResultViewModel$updateCroppedImageList$1.L$2 = str;
                    winkAIAvatarResultViewModel$updateCroppedImageList$1.label = 2;
                    obj = winkAIGCRequestUtils2.i("qzone_ai_avatar", str, false, winkAIAvatarResultViewModel$updateCroppedImageList$1);
                    if (obj == coroutine_suspended) {
                    }
                    String str222 = (String) ((Pair) obj).getSecond();
                    w53.b.f("WinkAIAvatarResultViewModel", "updateCroppedImageList imageUrl: " + str + " safeID: " + str222);
                    winkAIAvatarResultViewModel2.croppedImageList.add(TuplesKt.to(str, str222));
                    it = it5;
                    winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                    if (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                List<Bitmap> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && (!this.croppedImageList.isEmpty())) {
                    return Unit.INSTANCE;
                }
                this.croppedImageList.clear();
                if (list2 != null && !list2.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    ArrayList<LocalMediaInfo> arrayList2 = this.originLocalMediaInfoList;
                    if (arrayList2 != null) {
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault2);
                        Iterator<T> it6 = arrayList2.iterator();
                        while (it6.hasNext()) {
                            arrayList.add(((LocalMediaInfo) it6.next()).path);
                        }
                    } else {
                        arrayList = null;
                    }
                } else {
                    List<Bitmap> list3 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Bitmap bitmap : list3) {
                        String str3 = l2() + System.nanoTime() + ".jpg";
                        com.tencent.mobileqq.wink.utils.f.v(str3, bitmap, Bitmap.CompressFormat.JPEG, 100);
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        arrayList.add(str3);
                    }
                }
                if (arrayList != null) {
                    it = arrayList.iterator();
                    winkAIAvatarResultViewModel = this;
                    if (it.hasNext()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        winkAIAvatarResultViewModel$updateCroppedImageList$1 = new WinkAIAvatarResultViewModel$updateCroppedImageList$1(this, continuation);
        Object obj2 = winkAIAvatarResultViewModel$updateCroppedImageList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAIAvatarResultViewModel$updateCroppedImageList$1.label;
        if (i3 == 0) {
        }
    }

    private final boolean f2(boolean isRegenerate) {
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        String y06 = com.tencent.mobileqq.wink.editor.c.y0(this.selectedStyleMaterial);
        String str = this.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "selectedStyleMaterial.id");
        this._onAIAvatarGenerated.postValue(new WinkMakeAIImageResponse(false, -1L, "\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", isRegenerate, y06, str, new ArrayList(), ""));
        return false;
    }

    public static /* synthetic */ void h2(WinkAIAvatarResultViewModel winkAIAvatarResultViewModel, QQPermission qQPermission, boolean z16, Activity activity, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            if ((i3 & 4) != 0) {
                activity = null;
            }
            if ((i3 & 8) != 0) {
                z17 = true;
            }
            winkAIAvatarResultViewModel.g2(qQPermission, z16, activity, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadAIAvatarImages");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l2() {
        String str = u53.e.f438384a + "/ai_avatar/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n2(String url) {
        int lastIndexOf$default;
        String str;
        boolean z16;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            str = url.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = "";
        }
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (str.charAt(i3) == '?') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            str = str.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        String l26 = l2();
        File file = new File(l26);
        if (!file.exists()) {
            file.mkdirs();
        }
        return l26 + "aiavatar_" + System.currentTimeMillis() + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Serializable> y2(boolean syncQZone) {
        HashMap<String, Serializable> hashMap = new HashMap<>();
        hashMap.put("is_from_ai", 1);
        if (!syncQZone) {
            return hashMap;
        }
        hashMap.put("NoPush", 0);
        Boolean bool = Boolean.TRUE;
        hashMap.put("shouldShareToQZone", bool);
        hashMap.put("needCustomQZoneContent", bool);
        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, WinkPublishMediaRecord.WINK_REPORT_TYPE_AI_AVATAR);
        String str = this.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "selectedStyleMaterial.id");
        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, str);
        String str2 = this.selectedStyleMaterial.additionalFields.get("style_id");
        if (str2 != null) {
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID, str2);
        }
        String str3 = this.selectedStyleMaterial.additionalFields.get("name");
        if (str3 != null) {
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_NAME, str3);
        }
        String str4 = this.selectedStyleMaterial.additionalFields.get(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG);
        if (str4 != null) {
            hashMap.put(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG, str4);
        }
        String str5 = this.selectedStyleMaterial.additionalFields.get(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG_ID);
        if (str5 != null) {
            hashMap.put(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG_ID, str5);
        }
        String str6 = this.selectedStyleMaterial.additionalFields.get("publish_material_content");
        if (str6 != null) {
            hashMap.put("publish_material_content", str6);
        }
        return hashMap;
    }

    @NotNull
    public final String A2() {
        String p16;
        if (this.isSchemeJump) {
            return this.schemeUserNickName;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.qqUserInfo;
        if (dVar == null || (p16 = dVar.p()) == null) {
            return "";
        }
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MutableLiveData<Boolean> B2() {
        return this._onAvatarSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MutableLiveData<List<MetaMaterial>> C2() {
        return this._onRecommendStyles;
    }

    /* renamed from: E2, reason: from getter */
    public final boolean getIsCoupleAvatar() {
        return this.isCoupleAvatar;
    }

    public final boolean F2() {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.qqUserInfo;
        if (dVar == null || dVar.v() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: G2, reason: from getter */
    public final boolean getIsSchemeJump() {
        return this.isSchemeJump;
    }

    public void H2(@Nullable Bundle arguments) {
        D2();
        if (K2(arguments)) {
            return;
        }
        I2(arguments);
    }

    public final void J2(@Nullable Bundle arguments) {
        Serializable serializable;
        boolean z16;
        w53.b.f("WinkAIAvatarResultViewModel", "parseReplaceResult");
        Serializable serializable2 = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("selected_local_media_info_list");
        } else {
            serializable = null;
        }
        ArrayList<LocalMediaInfo> arrayList = (ArrayList) serializable;
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.originLocalMediaInfoList = arrayList;
            this.croppedImageList.clear();
        } else {
            w53.b.c("WinkAIAvatarResultViewModel", "parseReplaceResult: mediaList is null or empty");
        }
        if (arguments != null) {
            serializable2 = arguments.getSerializable("selected_origin_local_media_info_list");
        }
        ArrayList<LocalMediaInfo> arrayList2 = (ArrayList) serializable2;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z17 = true;
        }
        if (!z17) {
            this.imagePickerLocalMediaInfos = arrayList2;
        } else {
            w53.b.c("WinkAIAvatarResultViewModel", "parseReplaceResult: imagePickerLocalMediaInfos is null or empty");
        }
    }

    public final void N2(@Nullable Activity activity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.ae
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarResultViewModel.O2();
            }
        }, 1000L);
    }

    public void P2() {
        boolean z16;
        String str = this.originStyleMaterial.f30533id;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.c("WinkAIAvatarResultViewModel", "originStyleMaterial is null");
            return;
        }
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        String str2 = this.originStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str2, "originStyleMaterial.id");
        winkAIAvatarUtils.w(str2, winkAIAvatarUtils.j(this.originStyleMaterial), new Function3<Boolean, Long, List<? extends MetaMaterial>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$requestRecommendStyles$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Long l3, List<? extends MetaMaterial> list) {
                invoke(bool.booleanValue(), l3.longValue(), (List<MetaMaterial>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, long j3, @NotNull List<MetaMaterial> styles) {
                List<MetaMaterial> mutableList;
                boolean z18;
                MetaMaterial metaMaterial;
                MetaMaterial metaMaterial2;
                MetaMaterial metaMaterial3;
                boolean z19;
                Intrinsics.checkNotNullParameter(styles, "styles");
                WinkAIAvatarResultViewModel winkAIAvatarResultViewModel = WinkAIAvatarResultViewModel.this;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = styles.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    boolean Z0 = com.tencent.mobileqq.wink.editor.c.Z0((MetaMaterial) next);
                    z19 = winkAIAvatarResultViewModel.isCoupleAvatar;
                    if (Z0 == z19) {
                        arrayList.add(next);
                    }
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                WinkAIAvatarResultViewModel winkAIAvatarResultViewModel2 = WinkAIAvatarResultViewModel.this;
                Iterator<MetaMaterial> it5 = mutableList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it5.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    String str3 = it5.next().f30533id;
                    metaMaterial3 = winkAIAvatarResultViewModel2.originStyleMaterial;
                    if (Intrinsics.areEqual(str3, metaMaterial3.f30533id)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    WinkAIAvatarResultViewModel.this.originStyleMaterial = mutableList.remove(i3);
                    metaMaterial2 = WinkAIAvatarResultViewModel.this.originStyleMaterial;
                    mutableList.add(0, metaMaterial2);
                } else {
                    z18 = WinkAIAvatarResultViewModel.this.isSchemeJump;
                    if (!z18) {
                        metaMaterial = WinkAIAvatarResultViewModel.this.originStyleMaterial;
                        mutableList.add(0, metaMaterial);
                    }
                }
                WinkAIAvatarResultViewModel.this.C2().postValue(mutableList);
            }
        });
    }

    public final void R2() {
        WinkAIAvatarUtils.f317678a.u(true, new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$requestShareInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<MetaCategory> list) {
                MutableLiveData mutableLiveData;
                MetaCategory metaCategory = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "share")) {
                            metaCategory = next;
                            break;
                        }
                    }
                    metaCategory = metaCategory;
                }
                mutableLiveData = WinkAIAvatarResultViewModel.this._shareInfoCategoryLiveData;
                mutableLiveData.postValue(metaCategory);
            }
        });
    }

    public final void S2() {
        this.selectedStyleMaterial = this.lastSelectedStyleMaterial;
    }

    public void T2(@Nullable Bitmap bitmap, @Nullable Boolean syncQZone) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), new e(CoroutineExceptionHandler.INSTANCE), null, new WinkAIAvatarResultViewModel$setAvatar$1(this, bitmap, syncQZone, null), 2, null);
    }

    public final void U2(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        this.selectedStyleMaterial = material;
    }

    public final void V2(@NotNull WinkMakeAIImageResponse avatarResult) {
        Intrinsics.checkNotNullParameter(avatarResult, "avatarResult");
        this.avatarResultCache.put(avatarResult.getMaterialID(), avatarResult);
        this.lastSelectedStyleMaterial = this.selectedStyleMaterial;
    }

    @NotNull
    public final String d2() {
        boolean z16;
        Object firstOrNull;
        String str;
        Object firstOrNull2;
        List<WinkMakeAIImageResponse.Media> drop;
        String gender;
        WinkMakeAIImageResponse m26 = m2();
        String str2 = "";
        if (m26 == null) {
            return "";
        }
        com.tencent.mobileqq.wink.share.b bVar = new com.tencent.mobileqq.wink.share.b();
        bVar.j(Integer.parseInt("25"));
        bVar.f(m26.getMaterialID());
        String j3 = WinkAIAvatarUtils.f317678a.j(this.selectedStyleMaterial);
        if (j3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            j3 = com.tencent.mobileqq.wink.editor.c.o(this.selectedStyleMaterial);
        }
        bVar.c(j3);
        w53.b.a("WinkAIAvatarResultViewModel", "selectedStyleMaterial.categoryId: " + j3 + ", " + m26.getStyleID());
        bVar.i(m26.getShareImageUrl());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) m26.b());
        WinkMakeAIImageResponse.Media media = (WinkMakeAIImageResponse.Media) firstOrNull;
        if (media == null || (str = media.getImageUrl()) == null) {
            str = "https://shadow-h5-image-1251316161.file.myqcloud.com/2023-aigc/wecom-temp-143487-e5a1fb8b2f66f7d63dbf0d93f1e88b0d.png";
        }
        bVar.g(str);
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) m26.b());
        WinkMakeAIImageResponse.Media media2 = (WinkMakeAIImageResponse.Media) firstOrNull2;
        if (media2 != null && (gender = media2.getGender()) != null) {
            str2 = gender;
        }
        bVar.e(str2);
        WinkMakeAIImageResponse m27 = m2();
        Intrinsics.checkNotNull(m27);
        drop = CollectionsKt___CollectionsKt.drop(m27.b(), 1);
        for (WinkMakeAIImageResponse.Media media3 : drop) {
            bVar.g(bVar.getMedias() + ";;;");
            bVar.g(bVar.getMedias() + media3.getImageUrl());
            bVar.e(bVar.getGender() + ";;;");
            bVar.e(bVar.getGender() + media3.getGender());
        }
        bVar.h(A2());
        bVar.d(this.isCoupleAvatar ? 1 : 0);
        String json = new Gson().toJson(bVar);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(schemaExtra)");
        return json;
    }

    public final void e2() {
        Job job = this.generateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void g2(@NotNull QQPermission qqPermission, final boolean needFinishActivity, @Nullable final Activity activity, final boolean notifyUI) {
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        WinkAIAvatarUtils.f317678a.d(qqPermission, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$downloadAIAvatarImages$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$downloadAIAvatarImages$1$1", f = "WinkAIAvatarResultViewModel.kt", i = {0}, l = {AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 338}, m = "invokeSuspend", n = {"savePath"}, s = {"L$2"})
            /* renamed from: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$downloadAIAvatarImages$1$1, reason: invalid class name */
            /* loaded from: classes21.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Activity $activity;
                final /* synthetic */ boolean $needFinishActivity;
                final /* synthetic */ boolean $notifyUI;
                Object L$0;
                Object L$1;
                Object L$2;
                boolean Z$0;
                int label;
                final /* synthetic */ WinkAIAvatarResultViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(WinkAIAvatarResultViewModel winkAIAvatarResultViewModel, boolean z16, boolean z17, Activity activity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = winkAIAvatarResultViewModel;
                    this.$notifyUI = z16;
                    this.$needFinishActivity = z17;
                    this.$activity = activity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$notifyUI, this.$needFinishActivity, this.$activity, continuation);
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x012c, code lost:
                
                    if (r2 == false) goto L41;
                 */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00e7  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x013c  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f2 -> B:10:0x012c). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0114 -> B:6:0x0117). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    AnonymousClass1 anonymousClass1;
                    List<WinkMakeAIImageResponse.Media> b16;
                    WinkAIAvatarResultViewModel winkAIAvatarResultViewModel;
                    boolean z16;
                    Iterator it;
                    MutableLiveData mutableLiveData;
                    WinkAIAvatarResultViewModel winkAIAvatarResultViewModel2;
                    Object obj2;
                    Iterator it5;
                    String str;
                    boolean z17;
                    MutableLiveData mutableLiveData2;
                    boolean z18;
                    String n26;
                    MutableLiveData mutableLiveData3;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                z17 = this.Z$0;
                                Iterator it6 = (Iterator) this.L$1;
                                WinkAIAvatarResultViewModel winkAIAvatarResultViewModel3 = (WinkAIAvatarResultViewModel) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                anonymousClass1 = this;
                                winkAIAvatarResultViewModel2 = winkAIAvatarResultViewModel3;
                                it5 = it6;
                                Object i16 = obj;
                                if (!((Boolean) i16).booleanValue() && z17) {
                                    mutableLiveData3 = winkAIAvatarResultViewModel2._onAvatarDownloaded;
                                    mutableLiveData3.postValue(Boxing.boxBoolean(false));
                                }
                                winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                                Iterator it7 = it5;
                                z16 = z17;
                                it = it7;
                                if (!it.hasNext()) {
                                    WinkMakeAIImageResponse.Media media = (WinkMakeAIImageResponse.Media) it.next();
                                    String imageUrlWithQRCode = media.getImageUrlWithQRCode();
                                    if (imageUrlWithQRCode.length() == 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        imageUrlWithQRCode = media.getImageUrl();
                                    }
                                    w53.b.f("WinkAIAvatarResultViewModel", "downloadAIAvatarImages imageUrl: " + imageUrlWithQRCode);
                                    n26 = winkAIAvatarResultViewModel.n2(imageUrlWithQRCode);
                                    WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                                    Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
                                    anonymousClass1.L$0 = winkAIAvatarResultViewModel;
                                    anonymousClass1.L$1 = it;
                                    anonymousClass1.L$2 = n26;
                                    anonymousClass1.Z$0 = z16;
                                    anonymousClass1.label = 1;
                                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                                    obj2 = ak.f(a16, imageUrlWithQRCode, n26, null, anonymousClass1, 4, null);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    winkAIAvatarResultViewModel2 = winkAIAvatarResultViewModel;
                                    anonymousClass1 = anonymousClass12;
                                    str = n26;
                                    boolean z19 = z16;
                                    it5 = it;
                                    z17 = z19;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        if (FileUtils.fileExists(str)) {
                                            FileUtils.deleteFile(str);
                                        }
                                        if (z17) {
                                            mutableLiveData2 = winkAIAvatarResultViewModel2._onAvatarDownloaded;
                                            mutableLiveData2.postValue(Boxing.boxBoolean(false));
                                        }
                                        winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                                        Iterator it72 = it5;
                                        z16 = z17;
                                        it = it72;
                                        if (!it.hasNext()) {
                                        }
                                    } else {
                                        WinkEditorResourceManager a17 = WinkEditorResourceManager.a1();
                                        Intrinsics.checkNotNullExpressionValue(a17, "getInstance()");
                                        anonymousClass1.L$0 = winkAIAvatarResultViewModel2;
                                        anonymousClass1.L$1 = it5;
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.Z$0 = z17;
                                        anonymousClass1.label = 2;
                                        i16 = ak.i(a17, str, anonymousClass1);
                                        if (i16 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (!((Boolean) i16).booleanValue()) {
                                            mutableLiveData3 = winkAIAvatarResultViewModel2._onAvatarDownloaded;
                                            mutableLiveData3.postValue(Boxing.boxBoolean(false));
                                        }
                                        winkAIAvatarResultViewModel = winkAIAvatarResultViewModel2;
                                        Iterator it722 = it5;
                                        z16 = z17;
                                        it = it722;
                                        if (!it.hasNext()) {
                                            if (anonymousClass1.$notifyUI) {
                                                mutableLiveData = anonymousClass1.this$0._onAvatarDownloaded;
                                                mutableLiveData.postValue(Boxing.boxBoolean(true));
                                            }
                                            if (anonymousClass1.$needFinishActivity) {
                                                anonymousClass1.this$0.N2(anonymousClass1.$activity);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            z17 = this.Z$0;
                            str = (String) this.L$2;
                            it5 = (Iterator) this.L$1;
                            WinkAIAvatarResultViewModel winkAIAvatarResultViewModel4 = (WinkAIAvatarResultViewModel) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            anonymousClass1 = this;
                            winkAIAvatarResultViewModel2 = winkAIAvatarResultViewModel4;
                            obj2 = obj;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        WinkMakeAIImageResponse winkMakeAIImageResponse = this.this$0.k2().get(this.this$0.selectedStyleMaterial.f30533id);
                        if (winkMakeAIImageResponse != null && (b16 = winkMakeAIImageResponse.b()) != null) {
                            winkAIAvatarResultViewModel = this.this$0;
                            z16 = this.$notifyUI;
                            it = b16.iterator();
                            anonymousClass1 = this;
                            if (!it.hasNext()) {
                            }
                        } else {
                            anonymousClass1 = this;
                            if (anonymousClass1.$notifyUI) {
                            }
                            if (anonymousClass1.$needFinishActivity) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f317796d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ WinkAIAvatarResultViewModel f317797e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(CoroutineExceptionHandler.Companion companion, boolean z16, WinkAIAvatarResultViewModel winkAIAvatarResultViewModel) {
                    super(companion);
                    this.f317796d = z16;
                    this.f317797e = winkAIAvatarResultViewModel;
                }

                @Override // kotlinx.coroutines.CoroutineExceptionHandler
                public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
                    String stackTraceToString;
                    MutableLiveData mutableLiveData;
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
                    w53.b.c("WinkAIAvatarResultViewModel", "downloadAIAvatarImages exception: " + stackTraceToString);
                    if (this.f317796d) {
                        mutableLiveData = this.f317797e._onAvatarDownloaded;
                        mutableLiveData.postValue(Boolean.FALSE);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    w53.b.c("WinkAIAvatarResultViewModel", "downloadAIAvatarImages no storage permission");
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.b())), new a(CoroutineExceptionHandler.INSTANCE, notifyUI, this), null, new AnonymousClass1(this, notifyUI, needFinishActivity, activity, null), 2, null);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkAIAvatarResultViewModel";
    }

    public final void i2(boolean isRegenerate, @Nullable List<Bitmap> originBimapList) {
        Job launch$default;
        Job job = this.generateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (!f2(isRegenerate)) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), new b(CoroutineExceptionHandler.INSTANCE, this), null, new WinkAIAvatarResultViewModel$generateAIAvatar$1(this, originBimapList, isRegenerate, null), 2, null);
        this.generateJob = launch$default;
    }

    @Nullable
    public final WinkMakeAIImageResponse j2(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return this.avatarResultCache.get(material.f30533id);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<String, WinkMakeAIImageResponse> k2() {
        return this.avatarResultCache;
    }

    @Nullable
    public final WinkMakeAIImageResponse m2() {
        return this.avatarResultCache.get(this.selectedStyleMaterial.f30533id);
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> o2() {
        return this.imagePickerLocalMediaInfos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        e2();
    }

    @NotNull
    public final LiveData<WinkMakeAIImageResponse> p2() {
        return this.onAIAvatarGenerated;
    }

    @NotNull
    public final LiveData<Boolean> q2() {
        return this.onAvatarDownloaded;
    }

    @NotNull
    public final LiveData<Boolean> r2() {
        return this.onAvatarSet;
    }

    @NotNull
    public final LiveData<List<MetaMaterial>> s2() {
        return this.onRecommendStyles;
    }

    @Nullable
    public final List<LocalMediaInfo> t2() {
        return this.originLocalMediaInfoList;
    }

    @Nullable
    public final MetaMaterial u2() {
        boolean z16;
        List<MetaMaterial> value = this._onRecommendStyles.getValue();
        boolean z17 = false;
        if (value != null) {
            List<MetaMaterial> list = value;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((MetaMaterial) it.next()).f30533id, this.originStyleMaterial.f30533id)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            return this.originStyleMaterial;
        }
        return null;
    }

    @NotNull
    /* renamed from: v2, reason: from getter */
    public final String getSchemeUserNickName() {
        return this.schemeUserNickName;
    }

    @NotNull
    /* renamed from: w2, reason: from getter */
    public final MetaMaterial getSelectedStyleMaterial() {
        return this.selectedStyleMaterial;
    }

    @NotNull
    public final String x2() {
        String str = this.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "selectedStyleMaterial.id");
        return str;
    }

    @NotNull
    public final LiveData<MetaCategory> z2() {
        return this.shareInfoCategoryLiveData;
    }
}
