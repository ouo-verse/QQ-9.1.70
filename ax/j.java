package ax;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ark.ark;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.av.zplan.avatar.utils.ThreadUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.avatar.model.AvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAsset;
import com.tencent.filament.zplan.constant.AVChatRenderEventsType;
import com.tencent.filament.zplan.data.AvatarAIInfo;
import com.tencent.filament.zplan.data.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.util.log.ILogDelegate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 \u00a1\u00012\u00020\u0001:\u0002DJB\u0011\u0012\u0006\u0010H\u001a\u00020C\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\u0012\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010(\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.J&\u00106\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002012\u0006\u00105\u001a\u000201J\u000e\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010:\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!J\u0006\u0010;\u001a\u00020\u0002J\u0006\u0010<\u001a\u00020\u0002J\u0006\u0010=\u001a\u00020\u0002J\u0006\u0010>\u001a\u00020\u0002J\u0016\u0010?\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010@\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010A\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%J\u000e\u0010B\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010H\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\"\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020S0R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\"\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020W0R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010UR,\u0010[\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010UR&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\\0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010UR\u0018\u0010a\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00060\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010'R\u0016\u0010l\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010'R\u0018\u0010n\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010NR\u0018\u0010p\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010NR\u0016\u0010q\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u0003R\u0016\u0010r\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0003R\u0016\u0010s\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u0003R\u0016\u0010t\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0003R\u0018\u0010v\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010uR\u0016\u0010w\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0017\u0010|\u001a\u00020x8\u0006\u00a2\u0006\f\n\u0004\b*\u0010y\u001a\u0004\bz\u0010{R'\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b}\u0010N\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R)\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0083\u0001\u0010N\u001a\u0005\b\u0084\u0001\u0010\u007f\"\u0006\b\u0085\u0001\u0010\u0081\u0001R(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\f\u0010N\u001a\u0005\b\u0087\u0001\u0010\u007f\"\u0006\b\u0088\u0001\u0010\u0081\u0001R)\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u008a\u0001\u0010N\u001a\u0005\b\u008b\u0001\u0010\u007f\"\u0006\b\u008c\u0001\u0010\u0081\u0001R(\u0010\u0093\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u008e\u0001\u0010'\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R'\u0010\u0097\u0001\u001a\u00020x8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0094\u0001\u0010y\u001a\u0005\b\u008e\u0001\u0010{\"\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\u009a\u0001\u001a\u00020x8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0098\u0001\u0010y\u001a\u0005\b\u0094\u0001\u0010{\"\u0006\b\u0099\u0001\u0010\u0096\u0001R\u0014\u0010\u009d\u0001\u001a\u0002018F\u00a2\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0014\u0010\u009e\u0001\u001a\u0002018F\u00a2\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u009c\u0001R\u0014\u0010\u00a0\u0001\u001a\u0002018F\u00a2\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u009c\u0001R\u0014\u0010\u00a2\u0001\u001a\u0002018F\u00a2\u0006\b\u001a\u0006\b\u00a1\u0001\u0010\u009c\u0001R\u0013\u00107\u001a\u00020\u00048F\u00a2\u0006\b\u001a\u0006\b\u00a3\u0001\u0010\u0090\u0001\u00a8\u0006\u00a6\u0001"}, d2 = {"Lax/j;", "", "", "I", "", "isLocal", "", "uin", "b0", "isSelf", "Lax/j$b;", "callback", "y", "N", "U", "V", "gltfPath", "imageName", BdhLogUtil.LogTag.Tag_Req, "a0", "Y", "W", "X", "o0", "n0", "isMale", "h0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", ReportConstant.COSTREPORT_PREFIX, "j0", "Lorg/light/avatar/AvatarAIInfo;", "info", "", "pts", "Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "M", "Lcx/a;", "listener", "Z", "u", ExifInterface.LATITUDE_SOUTH, "v", "isFemale", "O", "G", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "textureView", "K", "", "width", "height", "left", "bottom", "p0", "isDoubleHorizontal", "r", "m0", "p", "e0", "f0", "d0", "g0", "t", "i0", "l0", "P", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/filament/zplan/f;", "b", "Lcom/tencent/filament/zplan/f;", "mFilamentRender", "c", "Ljava/lang/String;", "mFilamatDir", "d", "mAIBodyRefPath", "", "Lorg/json/JSONObject;", "e", "Ljava/util/Map;", "mResJsonMap", "Lcom/tencent/filament/zplan/avatar/model/AvatarResourceModel;", "f", "mUinToAvatarResModelMap", "g", "mUinToResPathMap", "", tl.h.F, "mUinToSlotIdList", "i", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "mRenderView", "j", "Ljava/util/List;", "mResFetchingList", "", "k", "[Ljava/lang/String;", "SLOT_RESOURCE_TAG", "l", "mNeedCreateLocal", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mNeedCreateRemote", DomainData.DOMAIN_NAME, "mSelfUin", "o", "mPeerUin", "mSmallViewWidth", "mSmallViewHeight", "mSmallViewLeftMargin", "mSmallViewBottomMargin", "Lcx/a;", "mRenderEventToAVLitsener", "mIsDoubleHorizontal", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMSoLoaded", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "mSoLoaded", "w", "getMMaleFaceActionPath", "()Ljava/lang/String;", "setMMaleFaceActionPath", "(Ljava/lang/String;)V", "mMaleFaceActionPath", HippyTKDListViewAdapter.X, "getMMaleBodyActionPath", "setMMaleBodyActionPath", "mMaleBodyActionPath", "getMFemaleFaceActionPath", "setMFemaleFaceActionPath", "mFemaleFaceActionPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getMFemaleBodyActionPath", "setMFemaleBodyActionPath", "mFemaleBodyActionPath", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getMIs3DMMBundleReady", "()Z", "k0", "(Z)V", "mIs3DMMBundleReady", "B", "setMIsLocalAvatarReloadSuc", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mIsLocalAvatarReloadSuc", BdhLogUtil.LogTag.Tag_Conn, "setMIsRemoteAvatarReloadSuc", "mIsRemoteAvatarReloadSuc", "E", "()I", "smallViewLeft", "smallViewBottom", UserInfo.SEX_FEMALE, "smallViewWidth", "D", "smallViewHeight", "L", "<init>", "(Landroid/content/Context;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean mIs3DMMBundleReady;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsLocalAvatarReloadSuc;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsRemoteAvatarReloadSuc;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.filament.zplan.f mFilamentRender;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFilamatDir;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAIBodyRefPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile Map<String, JSONObject> mResJsonMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile Map<String, AvatarResourceModel> mUinToAvatarResModelMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Map<String, String>> mUinToResPathMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, List<String>> mUinToSlotIdList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AVFilamentTextureView mRenderView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> mResFetchingList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] SLOT_RESOURCE_TAG;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedCreateLocal;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedCreateRemote;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSelfUin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPeerUin;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int mSmallViewWidth;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int mSmallViewHeight;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int mSmallViewLeftMargin;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int mSmallViewBottomMargin;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private cx.a mRenderEventToAVLitsener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDoubleHorizontal;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean mSoLoaded;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mMaleFaceActionPath;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mMaleBodyActionPath;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFemaleFaceActionPath;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFemaleBodyActionPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lax/j$b;", "", "", "status", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public interface b {
        void a(int status);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ax/j$c", "Lax/j$b;", "", "status", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f27140b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27141c;

        c(boolean z16, String str) {
            this.f27140b = z16;
            this.f27141c = str;
        }

        @Override // ax.j.b
        public void a(int status) {
            if (status == 3) {
                QLog.e("ZPlanAVChatFilamentAvatarManager", 1, "fetchAvatarResource suc.");
                j.this.b0(this.f27140b, this.f27141c);
            } else {
                QLog.e("ZPlanAVChatFilamentAvatarManager", 1, "fetchAvatarResource error.");
                cx.a aVar = j.this.mRenderEventToAVLitsener;
                if (aVar != null) {
                    aVar.a(this.f27141c, 6);
                }
            }
            if (j.this.mResFetchingList.contains(this.f27141c)) {
                j.this.mResFetchingList.remove(this.f27141c);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"ax/j$e", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate;", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate$Level;", "level", "", "tag", "msg", "", "throwable", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class e implements ILogDelegate {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f27144a;

            static {
                int[] iArr = new int[ILogDelegate.Level.values().length];
                try {
                    iArr[ILogDelegate.Level.VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ILogDelegate.Level.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ILogDelegate.Level.INFO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ILogDelegate.Level.WARN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f27144a = iArr;
            }
        }

        e() {
        }

        @Override // com.tencent.filament.zplanservice.util.log.ILogDelegate
        public void a(@NotNull ILogDelegate.Level level, @NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!QLog.isColorLevel()) {
                return;
            }
            int i3 = a.f27144a[level.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        QLog.e("qav_" + tag, 1, msg2, throwable);
                        return;
                    }
                    QLog.w("qav_" + tag, 1, msg2, throwable);
                    return;
                }
                QLog.i("qav_" + tag, 1, msg2, throwable);
                return;
            }
            QLog.d("qav_" + tag, 1, msg2, throwable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ax/j$f", "Luk0/b;", "", "isSuccess", "Lcom/tencent/filament/zplan/constant/AVChatRenderEventsType;", "eventsType", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class f implements uk0.b {
        f() {
        }

        @Override // uk0.b
        public void a(boolean isSuccess, @NotNull AVChatRenderEventsType eventsType) {
            Intrinsics.checkNotNullParameter(eventsType, "eventsType");
            if (eventsType == AVChatRenderEventsType.EVENT_CREATE_AVATAR_RESTORE) {
                j jVar = j.this;
                String str = isSuccess ? jVar.mSelfUin : jVar.mPeerUin;
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "EVENT_CREATE_AVATAR_RESTORE callback " + isSuccess + " " + str);
                if (str != null) {
                    j.this.N(isSuccess, str);
                    return;
                }
                return;
            }
            if (eventsType == AVChatRenderEventsType.EVENT_UPDATE_3DMM_PATH) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "EVENT_UPDATE_3DMM_PATH callback " + isSuccess);
                if (isSuccess) {
                    j.this.k0(true);
                    return;
                }
                return;
            }
            if (eventsType == AVChatRenderEventsType.EVENT_UPDATE_MATERIAL_ROOT_PATH) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "EVENT_UPDATE_MATERIAL_ROOT_PATH callback " + isSuccess);
                if (isSuccess) {
                    j.this.k0(true);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"ax/j$g", "Lcom/tencent/filament/zplan/b;", "", "frameTimeNanos", "Lkotlin/Triple;", "", "", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class g implements com.tencent.filament.zplan.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f27146a;

        g(long j3) {
            this.f27146a = j3;
        }

        @Override // com.tencent.filament.zplan.b
        @NotNull
        public Triple<Integer, Double, Boolean> a(long frameTimeNanos) {
            return new Triple<>(5001, Double.valueOf((frameTimeNanos - this.f27146a) / 1000000000), Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016\u00a8\u0006\n"}, d2 = {"ax/j$h", "Lcom/tencent/filament/zplan/a;", "", "isLocal", "", "", "Lal0/a;", "startupSteps", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class h implements com.tencent.filament.zplan.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27148b;

        h(String str) {
            this.f27148b = str;
        }

        @Override // com.tencent.filament.zplan.a
        public void a(boolean isLocal, @NotNull Map<String, al0.a> startupSteps) {
            Intrinsics.checkNotNullParameter(startupSteps, "startupSteps");
            if (isLocal) {
                j.this.getMIsLocalAvatarReloadSuc().set(true);
            } else {
                j.this.getMIsRemoteAvatarReloadSuc().set(true);
            }
            cx.a aVar = j.this.mRenderEventToAVLitsener;
            if (aVar != null) {
                aVar.a(this.f27148b, 5);
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "reloadAvatar suc " + this.f27148b + ". " + startupSteps);
        }
    }

    public j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mResJsonMap = new LinkedHashMap();
        this.mUinToAvatarResModelMap = new LinkedHashMap();
        this.mUinToResPathMap = new LinkedHashMap();
        this.mUinToSlotIdList = new LinkedHashMap();
        this.mResFetchingList = new ArrayList();
        this.SLOT_RESOURCE_TAG = new String[]{"feet", PreDetect.FACE_DETECT, "hand", "sock", "shoes", "hair", IndividuationUrlHelper.UrlId.SUIT_HOME, "glasses"};
        this.mSmallViewWidth = -1;
        this.mSmallViewHeight = -1;
        this.mSmallViewLeftMargin = -1;
        this.mSmallViewBottomMargin = -1;
        this.mSoLoaded = new AtomicBoolean(false);
        this.mIsLocalAvatarReloadSuc = new AtomicBoolean(false);
        this.mIsRemoteAvatarReloadSuc = new AtomicBoolean(false);
        Z(null);
        G();
    }

    private final void G() {
        ThreadUtil.f77341a.c(new Runnable() { // from class: ax.b
            @Override // java.lang.Runnable
            public final void run() {
                j.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
        e eVar = new e();
        FLog.INSTANCE.init(eVar);
        bl0.a.f28591a.a(eVar);
    }

    private final void I() {
        boolean z16;
        int i3;
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.mFilamatDir) && this.mFilamentRender == null) {
            if (!this.mSoLoaded.get()) {
                Z(new cx.a() { // from class: ax.g
                    @Override // cx.a
                    public final void a(String str3, int i16) {
                        j.J(j.this, str3, i16);
                    }
                });
                return;
            }
            if (AVAvatarResMgr.v().o("AEKit3DMMLowVersion") && AVAvatarResMgr.v().o("LightSDKSettings")) {
                z16 = true;
            } else {
                z16 = false;
            }
            v();
            String aeKit3DMMPath = AVAvatarResMgr.v().w("AEKit3DMMLowVersion");
            String w3 = AVAvatarResMgr.v().w("LightSDKSettings");
            dx.e a16 = a.a();
            long collectFps = 1000.0f / a16.getCollectFps();
            if (a16.getEnableInterpolate() && a16.getRenderFps() > 0 && a16.getCollectFps() > 0 && a16.getRenderWidth() > 0) {
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "initFilamentRender config=" + a16 + " materialPath=" + w3);
                FilamentRenderFactory filamentRenderFactory = FilamentRenderFactory.f105773b;
                String str3 = this.mFilamatDir;
                Intrinsics.checkNotNull(str3);
                String str4 = this.mAIBodyRefPath;
                if (str4 == null) {
                    str2 = "";
                } else {
                    str2 = str4;
                }
                Intrinsics.checkNotNullExpressionValue(aeKit3DMMPath, "aeKit3DMMPath");
                this.mFilamentRender = filamentRenderFactory.d(str3, str2, aeKit3DMMPath, a16.getCollectFps(), a16.getRenderFps(), a16.getRenderWidth(), collectFps, QLog.isDevelopLevel(), true);
            } else {
                int renderFps = a16.getRenderFps();
                if (renderFps <= 0) {
                    renderFps = 20;
                }
                int i16 = renderFps;
                if (a16.getEnableInterpolate()) {
                    i3 = i16 - 1;
                } else {
                    i3 = i16;
                }
                FilamentRenderFactory filamentRenderFactory2 = FilamentRenderFactory.f105773b;
                String str5 = this.mFilamatDir;
                Intrinsics.checkNotNull(str5);
                String str6 = this.mAIBodyRefPath;
                if (str6 == null) {
                    str = "";
                } else {
                    str = str6;
                }
                Intrinsics.checkNotNullExpressionValue(aeKit3DMMPath, "aeKit3DMMPath");
                this.mFilamentRender = filamentRenderFactory2.d(str5, str, aeKit3DMMPath, i3, i16, a16.getRenderWidth(), collectFps, QLog.isDevelopLevel(), a16.getEnableInterpolate());
            }
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            Intrinsics.checkNotNull(fVar);
            fVar.o(new f());
            p0(this.mSmallViewWidth, this.mSmallViewHeight, this.mSmallViewLeftMargin, this.mSmallViewBottomMargin);
            AVFilamentTextureView aVFilamentTextureView = this.mRenderView;
            if (aVFilamentTextureView != null) {
                K(aVFilamentTextureView);
                this.mRenderView = null;
            }
            com.tencent.filament.zplan.f fVar2 = this.mFilamentRender;
            if (fVar2 != null) {
                fVar2.onResume();
            }
            if (this.mNeedCreateLocal && !TextUtils.isEmpty(this.mSelfUin)) {
                String str7 = this.mSelfUin;
                Intrinsics.checkNotNull(str7);
                b0(true, str7);
                this.mNeedCreateLocal = false;
            }
            if (this.mNeedCreateRemote && !TextUtils.isEmpty(this.mPeerUin)) {
                String str8 = this.mPeerUin;
                Intrinsics.checkNotNull(str8);
                b0(false, str8);
                this.mNeedCreateRemote = false;
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "initFilamentRender is3DMMBundleReady=" + z16);
            return;
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "initFilamentRender " + this.mFilamatDir + " " + this.mFilamentRender, new Throwable(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(j this$0, String str, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 1) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadSo callback suc.");
            this$0.I();
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadSo callback failed: " + i3 + ".");
    }

    private final AvatarAIInfo M(org.light.avatar.AvatarAIInfo info, long pts) {
        AvatarAIInfo avatarAIInfo = new AvatarAIInfo();
        avatarAIInfo.setVersion(info.version);
        float[] fArr = info.skyBoxTransform;
        Intrinsics.checkNotNullExpressionValue(fArr, "info.skyBoxTransform");
        avatarAIInfo.setSkyBoxTransform(fArr);
        avatarAIInfo.setEvents(info.events);
        avatarAIInfo.setFace(info.f423803face);
        avatarAIInfo.setBody(info.body);
        avatarAIInfo.setFrameId(info.frameID);
        avatarAIInfo.setPts(pts);
        return avatarAIInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean isLocal, String uin) {
        String str;
        String str2;
        com.tencent.filament.zplan.f fVar;
        Map<String, String> map = this.mUinToResPathMap.get(uin);
        if (map != null) {
            map.clear();
        }
        U(uin);
        V(isLocal, uin);
        P(isLocal);
        Y(uin);
        W(isLocal, uin);
        X(isLocal, uin);
        q(isLocal);
        o0(isLocal, uin);
        n0(isLocal, uin);
        JSONObject jSONObject = this.mResJsonMap.get(uin);
        boolean z16 = false;
        if (jSONObject != null && jSONObject.optInt("gender", 1) == 1) {
            z16 = true;
        }
        h0(uin, isLocal, z16);
        if (z16) {
            str = this.mMaleBodyActionPath;
        } else {
            str = this.mFemaleBodyActionPath;
        }
        if (z16) {
            str2 = this.mMaleFaceActionPath;
        } else {
            str2 = this.mFemaleFaceActionPath;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            O(isLocal, !z16);
        }
        s();
        if (isLocal && (fVar = this.mFilamentRender) != null) {
            fVar.g(true);
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadAllAvatarRes " + isLocal + " " + uin);
    }

    private final void O(boolean isLocal, boolean isFemale) {
        String str;
        String str2;
        com.tencent.filament.zplan.f fVar;
        com.tencent.filament.zplan.f fVar2;
        if (isFemale) {
            str = this.mFemaleFaceActionPath;
        } else {
            str = this.mMaleFaceActionPath;
        }
        if (isFemale) {
            str2 = this.mFemaleBodyActionPath;
        } else {
            str2 = this.mMaleBodyActionPath;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadAnimation... " + str + " " + str2);
        if (str != null && (fVar2 = this.mFilamentRender) != null) {
            fVar2.w(isLocal, str, 5001, isFemale);
        }
        if (str2 != null && (fVar = this.mFilamentRender) != null) {
            fVar.w(isLocal, str2, 5001, isFemale);
        }
        long nanoTime = System.nanoTime();
        com.tencent.filament.zplan.f fVar3 = this.mFilamentRender;
        if (fVar3 != null) {
            fVar3.r(new g(nanoTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Q(j this$0, Ref.ObjectRef gltfPath, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gltfPath, "$gltfPath");
        com.tencent.av.zplan.avatar.utils.a aVar = com.tencent.av.zplan.avatar.utils.a.f77344a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        aVar.b(context, "qav_zplan_avatar_bg_v1", aVar.d(context2));
        this$0.R((String) gltfPath.element, z16, "bg_default.png");
    }

    private final void R(String gltfPath, boolean isLocal, String imageName) {
        if (!FileUtils.fileExists(gltfPath)) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadBg: failed, file is not exist.");
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadBg: islocal " + isLocal + " gltfPath: " + gltfPath);
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.u(isLocal, gltfPath, imageName);
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadBg suc..");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(final cx.a listener) {
        boolean z16;
        String aEResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_FILAMENT);
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadFilamentSoByAERes dir : " + aEResUnzipFinalPath);
        if (aEResUnzipFinalPath != null && aEResUnzipFinalPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (listener != null) {
                listener.a("", 0);
                return;
            }
            return;
        }
        final String str = aEResUnzipFinalPath + AECameraConstants.FILAMENT_NAME;
        if (!new File(str).exists()) {
            if (listener != null) {
                listener.a("", 0);
                return;
            }
            return;
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadFilamentSoByAERes soPath : " + str);
        if (this.mSoLoaded.get()) {
            if (listener != null) {
                listener.a("", 1);
            }
        } else {
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadFilamentSoByAERes soPath: " + str);
            ThreadUtil.f77341a.c(new Runnable() { // from class: ax.f
                @Override // java.lang.Runnable
                public final void run() {
                    j.T(str, this, listener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(String soPath, j this$0, cx.a aVar) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(soPath, "$soPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            System.load(soPath);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadFilamentSoByAERes success");
            this$0.mSoLoaded.set(true);
            if (aVar != null) {
                aVar.a("", 1);
            }
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadFilamentSoByAERes fail : " + m479exceptionOrNullimpl);
        }
    }

    private final void U(String uin) {
        String str;
        AvatarResourceModel avatarResourceModel = this.mUinToAvatarResModelMap.get(uin);
        String str2 = null;
        if (avatarResourceModel != null) {
            str = avatarResourceModel.getIndirectLightPath();
        } else {
            str = null;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadLight " + uin + " path=" + str);
        AvatarResourceModel avatarResourceModel2 = this.mUinToAvatarResModelMap.get(uin);
        if (avatarResourceModel2 != null) {
            str2 = avatarResourceModel2.getIndirectLightPath();
        }
        if (str2 != null) {
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            if (fVar != null) {
                fVar.d(str2);
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadLight suc..");
        }
    }

    private final void V(boolean isLocal, String uin) {
        String str;
        AvatarResourceModel avatarResourceModel = this.mUinToAvatarResModelMap.get(uin);
        if (avatarResourceModel != null) {
            str = avatarResourceModel.getLutTexturePath();
        } else {
            str = null;
        }
        if (str != null) {
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            if (fVar != null) {
                fVar.m(isLocal, str);
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadLut suc.. path:" + str);
        }
    }

    private final void W(boolean isLocal, String uin) {
        com.tencent.filament.zplan.f fVar;
        com.tencent.filament.zplan.f fVar2;
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadMakeUpInfo " + uin);
        if (!TextUtils.isEmpty(uin) && this.mUinToAvatarResModelMap.get(uin) != null) {
            AvatarResourceModel avatarResourceModel = this.mUinToAvatarResModelMap.get(uin);
            Intrinsics.checkNotNull(avatarResourceModel);
            for (Map.Entry<String, ZPlanFAsset> entry : avatarResourceModel.j().entrySet()) {
                entry.getKey();
                ZPlanFAsset value = entry.getValue();
                if (value instanceof ZPlanMakeUpFAsset) {
                    FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                    ZPlanMakeUpFAsset zPlanMakeUpFAsset = (ZPlanMakeUpFAsset) value;
                    String filePathInDir$default = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, "png", 2, null);
                    String filePathInDir$default2 = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, "ktx2", 2, null);
                    String filePathInDir$default3 = FilamentFileUtil.filePathInDir$default(filamentFileUtil, zPlanMakeUpFAsset.getDirPath(), null, ark.ARKMETADATA_JSON, 2, null);
                    if (filePathInDir$default != null && (fVar2 = this.mFilamentRender) != null) {
                        fVar2.e(isLocal, String.valueOf(zPlanMakeUpFAsset.getAssetInfo().getSlotId()), filePathInDir$default, filePathInDir$default3);
                    }
                    if (filePathInDir$default2 != null && (fVar = this.mFilamentRender) != null) {
                        fVar.e(isLocal, String.valueOf(zPlanMakeUpFAsset.getAssetInfo().getSlotId()), filePathInDir$default2, filePathInDir$default3);
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                AvatarResourceModel avatarResourceModel2 = this.mUinToAvatarResModelMap.get(uin);
                Intrinsics.checkNotNull(avatarResourceModel2);
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadMakeUpInfo suc. " + avatarResourceModel2.j());
                return;
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadMakeUpInfo suc.");
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadMakeUpInfo error.");
        cx.a aVar = this.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 6);
        }
    }

    private final void X(boolean isLocal, String uin) {
        boolean z16;
        String str;
        String str2;
        JSONArray controlPointsArray;
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig " + uin);
        if (!TextUtils.isEmpty(uin) && this.mUinToAvatarResModelMap.get(uin) != null && this.mUinToSlotIdList.get(uin) != null) {
            List<String> list = this.mUinToSlotIdList.get(uin);
            Intrinsics.checkNotNull(list);
            int i3 = 0;
            Object[] array = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            JSONObject jSONObject = this.mResJsonMap.get(uin);
            if (jSONObject != null && jSONObject.optInt("gender", 1) == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            AvatarResourceModel avatarResourceModel = this.mUinToAvatarResModelMap.get(uin);
            JSONObject jSONObject2 = null;
            if (avatarResourceModel != null) {
                str = avatarResourceModel.getPinchFaceConfigPath();
            } else {
                str = null;
            }
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject3 = this.mResJsonMap.get(uin);
            if (jSONObject3 != null) {
                jSONObject2 = jSONObject3.optJSONObject("face_info");
            }
            if (jSONObject2 == null) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig faceInfo==null");
                cx.a aVar = this.mRenderEventToAVLitsener;
                if (aVar != null) {
                    aVar.a(uin, 6);
                    return;
                }
                return;
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("slot_arr");
            if (optJSONArray == null) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig slotArr==null");
                cx.a aVar2 = this.mRenderEventToAVLitsener;
                if (aVar2 != null) {
                    aVar2.a(uin, 6);
                    return;
                }
                return;
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig slotArr=" + optJSONArray.length());
            int length = optJSONArray.length();
            int i16 = 0;
            while (i16 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null && (controlPointsArray = optJSONObject.optJSONArray("control_points")) != null) {
                    Intrinsics.checkNotNullExpressionValue(controlPointsArray, "controlPointsArray");
                    int length2 = controlPointsArray.length();
                    int i17 = i3;
                    while (i17 < length2) {
                        JSONObject jSONObject4 = controlPointsArray.getJSONObject(i17);
                        arrayList.add(new ZPlanPinchFaceModel(jSONObject4.optInt("control_index"), ((float) jSONObject4.optLong("x_per")) * 0.01f));
                        i17++;
                        optJSONArray = optJSONArray;
                    }
                }
                i16++;
                optJSONArray = optJSONArray;
                i3 = 0;
            }
            int size = arrayList.size();
            ZPlanPinchFaceModel[] zPlanPinchFaceModelArr = new ZPlanPinchFaceModel[size];
            for (int i18 = 0; i18 < size; i18++) {
                zPlanPinchFaceModelArr[i18] = new ZPlanPinchFaceModel(0, 0.0f);
            }
            ZPlanPinchFaceModel[] modelArray = (ZPlanPinchFaceModel[]) arrayList.toArray(zPlanPinchFaceModelArr);
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            if (fVar != null) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                Intrinsics.checkNotNullExpressionValue(modelArray, "modelArray");
                fVar.x(isLocal, str2, modelArray, strArr, z16);
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig suc. " + str);
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadPinchFaceConfig error.");
        cx.a aVar3 = this.mRenderEventToAVLitsener;
        if (aVar3 != null) {
            aVar3.a(uin, 6);
        }
    }

    private final void Y(String uin) {
        JSONObject jSONObject;
        int optInt;
        List<String> list;
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadSlotItemId " + uin);
        JSONObject jSONObject2 = this.mResJsonMap.get(uin);
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject("avatar_info");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "avatarInfo == null json=" + this.mResJsonMap.get(uin));
            cx.a aVar = this.mRenderEventToAVLitsener;
            if (aVar != null) {
                aVar.a(uin, 6);
                return;
            }
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("slot_arr");
        if (optJSONArray == null) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "slotArr == null");
            cx.a aVar2 = this.mRenderEventToAVLitsener;
            if (aVar2 != null) {
                aVar2.a(uin, 6);
                return;
            }
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "slotArrSize = " + optJSONArray.length());
        if (this.mUinToSlotIdList.get(uin) == null) {
            this.mUinToSlotIdList.put(uin, new ArrayList());
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("item_id", 0)) > 0 && (list = this.mUinToSlotIdList.get(uin)) != null) {
                list.add(String.valueOf(optInt));
            }
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadAvatarInfo suc. " + this.mUinToSlotIdList);
    }

    private final void Z(cx.a listener) {
        boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AGENT_TYPE_FILAMENT);
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "create soReady:" + isAEResExist);
        if (!isAEResExist) {
            u(listener);
        } else {
            S(listener);
        }
    }

    private final void a0(String uin) {
        ZPlanCommonGltfFAsset eyelashGltfFAsset;
        String gltfFilePath;
        Map<String, String> map;
        String gltfFilePath2;
        boolean z16;
        Map<String, String> map2;
        boolean contains;
        if (!TextUtils.isEmpty(uin) && this.mUinToAvatarResModelMap.get(uin) != null) {
            AvatarResourceModel avatarResourceModel = this.mUinToAvatarResModelMap.get(uin);
            Intrinsics.checkNotNull(avatarResourceModel);
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadTorso " + uin + " " + avatarResourceModel.j());
            if (this.mUinToResPathMap.get(uin) == null) {
                this.mUinToResPathMap.put(uin, new HashMap());
            }
            try {
                AvatarResourceModel avatarResourceModel2 = this.mUinToAvatarResModelMap.get(uin);
                Intrinsics.checkNotNull(avatarResourceModel2);
                for (Map.Entry<String, ZPlanFAsset> entry : avatarResourceModel2.j().entrySet()) {
                    String key = entry.getKey();
                    ZPlanFAsset value = entry.getValue();
                    if ((value instanceof ZPlanCommonGltfFAsset) && (gltfFilePath2 = ((ZPlanCommonGltfFAsset) value).getGltfFilePath()) != null) {
                        for (String str : this.SLOT_RESOURCE_TAG) {
                            String gltfFilePath3 = ((ZPlanCommonGltfFAsset) value).getGltfFilePath();
                            if (gltfFilePath3 != null) {
                                contains = StringsKt__StringsKt.contains((CharSequence) gltfFilePath3, (CharSequence) str, true);
                                if (contains) {
                                    z16 = true;
                                    if (z16 && (map2 = this.mUinToResPathMap.get(uin)) != null) {
                                        map2.put(str, gltfFilePath2);
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                                map2.put(str, gltfFilePath2);
                            }
                        }
                        Map<String, String> map3 = this.mUinToResPathMap.get(uin);
                        if (map3 != null) {
                            map3.put(key, gltfFilePath2);
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadTorso error: " + e16);
            }
            AvatarResourceModel avatarResourceModel3 = this.mUinToAvatarResModelMap.get(uin);
            if (avatarResourceModel3 != null && (eyelashGltfFAsset = avatarResourceModel3.getEyelashGltfFAsset()) != null && (gltfFilePath = eyelashGltfFAsset.getGltfFilePath()) != null && (map = this.mUinToResPathMap.get(uin)) != null) {
                map.put("eyslash", gltfFilePath);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadTorso suc. resourcePathMap=" + this.mUinToResPathMap);
                return;
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "loadTorso suc.");
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "loadTorso " + uin + " error....");
        cx.a aVar = this.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(final boolean isLocal, final String uin) {
        boolean z16;
        if (isLocal) {
            this.mSelfUin = uin;
        } else {
            this.mPeerUin = uin;
        }
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar == null) {
            if (isLocal) {
                this.mNeedCreateLocal = true;
            } else {
                this.mNeedCreateRemote = true;
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "createAvatarView cache " + isLocal, new Throwable(""));
            return;
        }
        Intrinsics.checkNotNull(fVar);
        if (!fVar.p(isLocal)) {
            if (this.mUinToAvatarResModelMap.get(uin) != null && this.mResJsonMap.get(uin) != null) {
                com.tencent.filament.zplan.f fVar2 = this.mFilamentRender;
                if (fVar2 != null) {
                    z16 = fVar2.h(isLocal);
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "start createAvatarView on SubThread loadResource " + uin, new Throwable(""));
                    ThreadUtil.f77341a.c(new Runnable() { // from class: ax.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.c0(j.this, isLocal, uin);
                        }
                    });
                    return;
                }
                return;
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "createAvatarView error for resource is not ready " + uin);
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "createAvatarView error: already create avatar");
        cx.a aVar = this.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(j this$0, boolean z16, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.N(z16, uin);
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "createAvatarView on SubThread loadResource " + uin);
    }

    private final void h0(String uin, boolean isLocal, boolean isMale) {
        int renderFps = a.a().getRenderFps() * 3;
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.b(isLocal, isMale, new h(uin), renderFps);
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "reloadAvatar suc. delayFrame=" + renderFps);
    }

    private final double j0(double s16) {
        if (s16 <= 0.04045d) {
            return s16 / 12.92d;
        }
        return Math.pow((s16 + 0.055d) / 1.055d, 2.4d);
    }

    private final void n0(boolean isLocal, String uin) {
        a0(uin);
        if (this.mUinToResPathMap.get(uin) != null) {
            Map<String, String> map = this.mUinToResPathMap.get(uin);
            Intrinsics.checkNotNull(map);
            if (!map.isEmpty()) {
                com.tencent.filament.zplan.f fVar = this.mFilamentRender;
                if (fVar != null) {
                    Map<String, String> map2 = this.mUinToResPathMap.get(uin);
                    Intrinsics.checkNotNull(map2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
                    fVar.j(isLocal, (HashMap) map2);
                }
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "updateAvatar isLocal=" + isLocal + " " + uin + " suc.");
                return;
            }
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "updateAvatar error.   " + isLocal + " " + uin);
        cx.a aVar = this.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 6);
        }
    }

    private final void o0(boolean isLocal, String uin) {
        JSONObject jSONObject;
        int optInt;
        JSONObject optJSONObject;
        JSONObject jSONObject2 = this.mResJsonMap.get(uin);
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject("color_info");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "updateMakeupSlotColor colorInfo==null " + uin);
            cx.a aVar = this.mRenderEventToAVLitsener;
            if (aVar != null) {
                aVar.a(uin, 6);
                return;
            }
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "updateMakeupSlotColor " + uin);
        JSONArray optJSONArray = jSONObject.optJSONArray("slot_arr");
        if (optJSONArray == null) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "updateMakeupSlotColor slotArr==null");
            cx.a aVar2 = this.mRenderEventToAVLitsener;
            if (aVar2 != null) {
                aVar2.a(uin, 6);
                return;
            }
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "updateMakeupSlotColor slotArr=" + optJSONArray.length());
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
            if (optJSONObject2 != null && (optInt = optJSONObject2.optInt(MiniAppReportManager2.KEY_SLOT_ID, -1)) > 0 && (optJSONObject = optJSONObject2.optJSONObject("single_color")) != null) {
                int optInt2 = optJSONObject.optInt("custom_color", -1);
                double d16 = 255;
                double j06 = j0(Color.blue(optInt2) / 255.0d) * d16;
                double j07 = j0(Color.green(optInt2) / 255.0d) * d16;
                double j08 = j0(Color.red(optInt2) / 255.0d) * d16;
                com.tencent.filament.zplan.f fVar = this.mFilamentRender;
                if (fVar != null) {
                    fVar.f(isLocal, String.valueOf(optInt), (int) j08, (int) j07, (int) j06, 255);
                }
            }
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "updateMakeupSlotColor suc. slotArrayLen=" + optJSONArray.length());
    }

    private final void q(boolean isLocal) {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.v(isLocal);
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "applyPinchFace suc.");
    }

    private final void s() {
        if (this.mIs3DMMBundleReady) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "[check3DMMBundle] 3dmm is not ready.");
        }
        if (AVAvatarResMgr.v().o("AEKit3DMMLowVersion")) {
            String aeKit3DMMPath = AVAvatarResMgr.v().w("AEKit3DMMLowVersion");
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            if (fVar != null) {
                Intrinsics.checkNotNullExpressionValue(aeKit3DMMPath, "aeKit3DMMPath");
                fVar.C(aeKit3DMMPath);
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "[check3DMMBundle] update3DMMPath=" + aeKit3DMMPath);
        }
        if (AVAvatarResMgr.v().o("LightSDKSettings")) {
            String materialRootPath = AVAvatarResMgr.v().w("LightSDKSettings");
            com.tencent.filament.zplan.f fVar2 = this.mFilamentRender;
            if (fVar2 != null) {
                Intrinsics.checkNotNullExpressionValue(materialRootPath, "materialRootPath");
                fVar2.s(materialRootPath);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "[check3DMMBundle] updateMaterialRootPath=" + materialRootPath);
                return;
            }
            return;
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "[check3DMMBundle] Material not Ready");
    }

    private final void u(cx.a listener) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_FILAMENT, new d(listener));
    }

    private final void v() {
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "fetchAnimationRes...");
        if (!TextUtils.isEmpty(this.mMaleFaceActionPath) && !TextUtils.isEmpty(this.mMaleBodyActionPath)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_male", true);
        bundle.putString("face_action_path", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_H_CasualWear_01_Emote_Anim_Montage");
        bundle.putString("body_action_path", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_H_CasualWear_01_Montage");
        QIPCClientHelper.getInstance().getClient().callServer("ZplanAvatarQIPCModule", "action_get_avatar_animation_resource", bundle, new EIPCResultCallback() { // from class: ax.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                j.w(j.this, eIPCResult);
            }
        });
        if (!TextUtils.isEmpty(this.mFemaleFaceActionPath) && !TextUtils.isEmpty(this.mFemaleBodyActionPath)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_male", false);
        bundle2.putString("face_action_path", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_H_CasualWear_01_Emote_Anim_Montage");
        bundle2.putString("body_action_path", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_H_CasualWear_01_Montage");
        QIPCClientHelper.getInstance().getClient().callServer("ZplanAvatarQIPCModule", "action_get_avatar_animation_resource", bundle2, new EIPCResultCallback() { // from class: ax.i
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                j.x(j.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(j this$0, EIPCResult eIPCResult) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult.code == 0) {
            Bundle bundle = eIPCResult.data;
            Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
            this$0.mMaleFaceActionPath = bundle.getString("action_animation_face_path");
            this$0.mMaleBodyActionPath = bundle.getString("action_animation_body_path");
            if (!TextUtils.isEmpty(this$0.mSelfUin) && this$0.mResJsonMap.get(this$0.mSelfUin) != null) {
                JSONObject jSONObject = this$0.mResJsonMap.get(this$0.mSelfUin);
                Intrinsics.checkNotNull(jSONObject);
                if (jSONObject.optInt("gender", 1) == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    this$0.O(true, false);
                }
            }
            if (!TextUtils.isEmpty(this$0.mPeerUin) && this$0.mResJsonMap.get(this$0.mPeerUin) != null) {
                JSONObject jSONObject2 = this$0.mResJsonMap.get(this$0.mPeerUin);
                Intrinsics.checkNotNull(jSONObject2);
                if (jSONObject2.optInt("gender", 1) == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    this$0.O(false, false);
                }
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "EIPCResult callback... male animationPath=[" + this$0.mMaleFaceActionPath + "] [" + this$0.mMaleBodyActionPath + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(j this$0, EIPCResult eIPCResult) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult.code == 0) {
            Bundle bundle = eIPCResult.data;
            Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
            this$0.mFemaleFaceActionPath = bundle.getString("action_animation_face_path");
            this$0.mFemaleBodyActionPath = bundle.getString("action_animation_body_path");
            if (!TextUtils.isEmpty(this$0.mSelfUin) && this$0.mResJsonMap.get(this$0.mSelfUin) != null) {
                JSONObject jSONObject = this$0.mResJsonMap.get(this$0.mSelfUin);
                Intrinsics.checkNotNull(jSONObject);
                if (jSONObject.optInt("gender", 1) == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    this$0.O(true, true);
                }
            }
            if (!TextUtils.isEmpty(this$0.mPeerUin) && this$0.mResJsonMap.get(this$0.mPeerUin) != null) {
                JSONObject jSONObject2 = this$0.mResJsonMap.get(this$0.mPeerUin);
                Intrinsics.checkNotNull(jSONObject2);
                if (jSONObject2.optInt("gender", 1) == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this$0.O(false, true);
                }
            }
            QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "EIPCResult callback... female animationPath=[" + this$0.mFemaleFaceActionPath + "] [" + this$0.mFemaleBodyActionPath + "]");
        }
    }

    private final synchronized void y(boolean isSelf, final String uin, final b callback) {
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "start fetchAvatarResource... " + isSelf + " " + uin);
        Bundle bundle = new Bundle();
        bundle.putString("uin", uin);
        bundle.putBoolean("is_myself", isSelf);
        QIPCClientHelper.getInstance().getClient().callServer("ZplanAvatarQIPCModule", "action_get_avatar_resource", bundle, new EIPCResultCallback() { // from class: ax.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                j.z(j.this, uin, callback, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(j this$0, String uin, b bVar, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (eIPCResult.code == 0) {
            Bundle bundle = eIPCResult.data;
            Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
            String string = bundle.getString("action_json_str");
            AvatarResourceModel avatarResourceModel = (AvatarResourceModel) bundle.getParcelable("action_avatar_res");
            if (QLog.isDevelopLevel()) {
                QLog.i("ZPlanAVChatFilamentAvatarManager", 2, "EIPCResultCallback jsonStr:" + string + " avatarResourceModel=" + avatarResourceModel);
            }
            if (string != null && avatarResourceModel != null) {
                this$0.mResJsonMap.put(uin, new JSONObject(string));
                this$0.mUinToAvatarResModelMap.put(uin, avatarResourceModel);
                String shaderDir = avatarResourceModel.getShaderDir();
                if (shaderDir != null) {
                    this$0.mFilamatDir = shaderDir;
                }
                String aiBodyRefPath = avatarResourceModel.getAiBodyRefPath();
                if (aiBodyRefPath != null) {
                    this$0.mAIBodyRefPath = aiBodyRefPath;
                }
                this$0.I();
                if (bVar != null) {
                    bVar.a(3);
                }
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "initAvatarAndJson for " + uin + "  filamatDir:" + this$0.mFilamatDir);
                return;
            }
            if (bVar != null) {
                bVar.a(2);
                return;
            }
            return;
        }
        cx.a aVar = this$0.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 2);
        }
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final AtomicBoolean getMIsLocalAvatarReloadSuc() {
        return this.mIsLocalAvatarReloadSuc;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final AtomicBoolean getMIsRemoteAvatarReloadSuc() {
        return this.mIsRemoteAvatarReloadSuc;
    }

    /* renamed from: C, reason: from getter */
    public final int getMSmallViewBottomMargin() {
        return this.mSmallViewBottomMargin;
    }

    /* renamed from: D, reason: from getter */
    public final int getMSmallViewHeight() {
        return this.mSmallViewHeight;
    }

    /* renamed from: E, reason: from getter */
    public final int getMSmallViewLeftMargin() {
        return this.mSmallViewLeftMargin;
    }

    /* renamed from: F, reason: from getter */
    public final int getMSmallViewWidth() {
        return this.mSmallViewWidth;
    }

    public final void K(@Nullable AVFilamentTextureView textureView) {
        Integer num;
        if (this.mFilamentRender != null && this.mSoLoaded.get()) {
            com.tencent.filament.zplan.f fVar = this.mFilamentRender;
            if (fVar != null) {
                Intrinsics.checkNotNull(textureView);
                fVar.D(textureView);
            }
            Integer num2 = null;
            if (textureView != null) {
                num = Integer.valueOf(textureView.getWidth());
            } else {
                num = null;
            }
            if (textureView != null) {
                num2 = Integer.valueOf(textureView.getHeight());
            }
            QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "initTextureView width=" + num + " height=" + num2);
            return;
        }
        this.mRenderView = textureView;
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "mFilamentRender == null");
    }

    /* renamed from: L, reason: from getter */
    public final boolean getMIsDoubleHorizontal() {
        return this.mIsDoubleHorizontal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0071  */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(final boolean isLocal) {
        boolean z16;
        String str;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        com.tencent.av.zplan.avatar.utils.a aVar = com.tencent.av.zplan.avatar.utils.a.f77344a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        objectRef.element = aVar.d(context) + File.separator + "plane2.gltf";
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof VideoAppInterface) {
            com.tencent.av.business.manager.a B = ((VideoAppInterface) runtime).B(19);
            Intrinsics.checkNotNull(B, "null cannot be cast to non-null type com.tencent.av.business.manager.zplan.avatar.ZplanAvatarManager");
            ku.b bVar = (ku.b) B;
            if (bVar.b0()) {
                ?? X = bVar.X();
                Intrinsics.checkNotNullExpressionValue(X, "zplanAvatarManager.gltfPath");
                objectRef.element = X;
                String V = bVar.V();
                Intrinsics.checkNotNullExpressionValue(V, "zplanAvatarManager.currentBgName");
                str = V;
                z16 = true;
                if (!z16) {
                    R((String) objectRef.element, isLocal, str);
                    return;
                } else if (aVar.e()) {
                    R((String) objectRef.element, isLocal, "bg_default.png");
                    return;
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: ax.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.Q(j.this, objectRef, isLocal);
                        }
                    }, 16, null, true);
                    return;
                }
            }
        }
        z16 = false;
        str = "bg_default.png";
        if (!z16) {
        }
    }

    public final void d0() {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.onFinish();
        }
        this.mFilamentRender = null;
    }

    public final void e0() {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.onPause();
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "onPause.", new Throwable(""));
    }

    public final void f0() {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.onResume();
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "onResume.");
    }

    public final void g0() {
        this.mResJsonMap.clear();
        this.mUinToAvatarResModelMap.clear();
        this.mUinToResPathMap.clear();
        this.mUinToSlotIdList.clear();
        this.mResFetchingList.clear();
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.onDestroy();
        }
        QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "release.");
    }

    public final void i0(boolean isLocal) {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.n(isLocal);
        }
        if (isLocal) {
            this.mIsLocalAvatarReloadSuc.set(false);
        } else {
            this.mIsRemoteAvatarReloadSuc.set(false);
        }
    }

    public final void k0(boolean z16) {
        this.mIs3DMMBundleReady = z16;
    }

    public final void l0(@Nullable cx.a listener) {
        this.mRenderEventToAVLitsener = listener;
    }

    public final void m0(boolean isLocal) {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.l(isLocal);
        }
    }

    public final void p(boolean isLocal, @NotNull org.light.avatar.AvatarAIInfo info, long pts) {
        AtomicBoolean atomicBoolean;
        com.tencent.filament.zplan.f fVar;
        Intrinsics.checkNotNullParameter(info, "info");
        s();
        if (isLocal) {
            atomicBoolean = this.mIsLocalAvatarReloadSuc;
        } else {
            atomicBoolean = this.mIsRemoteAvatarReloadSuc;
        }
        if (atomicBoolean.get() && this.mIs3DMMBundleReady && info.frameID > 1 && (fVar = this.mFilamentRender) != null) {
            fVar.E(isLocal, M(info, pts));
        }
    }

    public final void p0(int width, int height, int left, int bottom) {
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "updateSmallViewLayoutParams " + width + " " + height + " " + left + " " + bottom, new Throwable(""));
        this.mSmallViewWidth = width;
        this.mSmallViewHeight = height;
        this.mSmallViewLeftMargin = left;
        this.mSmallViewBottomMargin = bottom;
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.B(width, height, left, bottom);
        }
    }

    public final void r(boolean isDoubleHorizontal) {
        com.tencent.filament.zplan.f fVar = this.mFilamentRender;
        if (fVar != null) {
            fVar.i(isDoubleHorizontal);
        }
        this.mIsDoubleHorizontal = isDoubleHorizontal;
    }

    public final synchronized void t(boolean isLocal, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        cx.a aVar = this.mRenderEventToAVLitsener;
        if (aVar != null) {
            aVar.a(uin, 4);
        }
        QLog.d("ZPlanAVChatFilamentAvatarManager", 1, "createAvatarView isLocal=" + isLocal + " uin=" + uin, new Throwable(""));
        if (this.mUinToAvatarResModelMap.get(uin) != null && this.mResJsonMap.get(uin) != null) {
            b0(isLocal, uin);
        } else if (!this.mResFetchingList.contains(uin)) {
            this.mResFetchingList.add(uin);
            y(isLocal, uin, new c(isLocal, uin));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"ax/j$d", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class d implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ cx.a f27143e;

        d(cx.a aVar) {
            this.f27143e = aVar;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            String str;
            if (aeResInfo != null) {
                str = aeResInfo.agentType;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, AEResInfo.AGENT_TYPE_FILAMENT)) {
                if (errorType != 0 && errorType != 1) {
                    cx.a aVar = this.f27143e;
                    if (aVar != null) {
                        aVar.a("", 0);
                        return;
                    }
                    return;
                }
                QLog.i("ZPlanAVChatFilamentAvatarManager", 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                j.this.S(this.f27143e);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
