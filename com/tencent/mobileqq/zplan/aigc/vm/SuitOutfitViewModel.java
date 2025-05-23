package com.tencent.mobileqq.zplan.aigc.vm;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.mobileqq.zplan.aigc.data.SuitOutfitPreviewBgUrlConfig;
import com.tencent.mobileqq.zplan.aigc.data.SuitOutfitPreviewBgUrlItem;
import com.tencent.mobileqq.zplan.aigc.data.ZplanSuitOutfitPreviewConfig;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.mobileqq.zplan.aigc.helper.ZPlanOutfitPublishHelper;
import com.tencent.mobileqq.zplan.aigc.parser.ZPlanSuitOutfitPreviewBgConfigParser;
import com.tencent.mobileqq.zplan.aigc.parser.ZPlanSuitOutfitPreviewConfigParser;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import pv4.r;
import pv4.s;
import qv4.z;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0092\u0001B\t\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0014J\u001e\u0010\u001a\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J0\u0010%\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u001c\u0010&\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0'J\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020*J\u001c\u0010.\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010-\u001a\u00020\fH\u0007J\u000e\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u00020/J\u0006\u00102\u001a\u00020\u0014J\u0006\u00103\u001a\u00020\u0014J\u0006\u00104\u001a\u00020\u0014J$\u00107\u001a\u00020\u00142\b\b\u0002\u00105\u001a\u00020\f2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001406J\u0006\u00109\u001a\u000208R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020D0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010<R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020D0>8\u0006\u00a2\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010BR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020J0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010<R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020J0>8\u0006\u00a2\u0006\f\n\u0004\bM\u0010@\u001a\u0004\bN\u0010BR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020/0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010<R\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020/0>8\u0006\u00a2\u0006\f\n\u0004\bR\u0010@\u001a\u0004\bS\u0010BR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000e0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010<R\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000e0>8\u0006\u00a2\u0006\f\n\u0004\bW\u0010@\u001a\u0004\bX\u0010BR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020Z0:8\u0006\u00a2\u0006\f\n\u0004\b[\u0010<\u001a\u0004\b\\\u0010]R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020_0:8\u0006\u00a2\u0006\f\n\u0004\b`\u0010<\u001a\u0004\ba\u0010]R\"\u0010i\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010q\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010y\u001a\u0004\u0018\u00010r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010\u0081\u0001\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R#\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u008a\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel;", "Landroidx/lifecycle/ViewModel;", "Lqv4/z;", "rsp", "", "t2", "", "slotId", "Luv4/az;", "storeItem", "Lorg/json/JSONObject;", "effectSlotItemsString", "", "v2", "", "itemId", "U1", "feedID", "Landroid/content/Context;", "context", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "Lcom/tencent/mobileqq/zootopia/api/e;", "cb", "tianshuAdId", "B2", NowProxyConstants.AccountInfoKey.A2, "z2", "reason", "y2", PhotoCategorySummaryInfo.AVATAR_URL, "avatarUrlThumb", "backgroundUrl", "backgroundThumbUrl", "Lnk3/h;", "callback", "x2", "W1", "", ICustomDataEditor.NUMBER_PARAM_2, "j2", "Lgl0/b;", "listener", "X1", "downloadSo", "w2", "Lcom/tencent/mobileqq/zplan/aigc/data/j;", "data", "F2", "d2", "b2", "u2", "isLoop", "Lkotlin/Function1;", "S1", "Lbv4/f;", "i2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_currentETag", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "getCurrentETag", "()Landroidx/lifecycle/LiveData;", "currentETag", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel$Companion$GetFeedStatus;", BdhLogUtil.LogTag.Tag_Conn, "_fetchStatus", "D", "l2", "fetchStatus", "Lbv4/a;", "E", "_outfitInfo", UserInfo.SEX_FEMALE, "o2", "outfitInfo", "G", "_likeData", "H", "m2", "likeData", "I", "_dressCount", "J", "k2", "dressCount", "Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "K", "q2", "()Landroidx/lifecycle/MutableLiveData;", "outfitPreviewConfig", "Lcom/tencent/mobileqq/zplan/aigc/data/SuitOutfitPreviewBgUrlConfig;", "L", "p2", "outfitPreviewBgUrlConfig", "M", "Ljava/lang/String;", "getFeedHippyJumpUrl", "()Ljava/lang/String;", "E2", "(Ljava/lang/String;)V", "feedHippyJumpUrl", "Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "N", "Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "H2", "(Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;)V", "suitAnimHelper", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "P", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "r2", "()Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", Constants.MMCCID, "(Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;)V", "scene", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", SemanticAttributes.DbSystemValues.H2, "()Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", Constants.BASE_IN_PLUGIN_VERSION, "(Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;)V", "currentGender", "Lcom/tencent/mobileqq/zplan/aigc/helper/d;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zplan/aigc/helper/d;", "downloadLightSDKHelper", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "f2", "()Ljava/util/List;", "backgroundImageList", "T", "g2", "backgroundThumbImageList", "<init>", "()V", "U", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitOutfitViewModel extends ViewModel {

    /* renamed from: C */
    private final MutableLiveData<Companion.GetFeedStatus> _fetchStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<Companion.GetFeedStatus> fetchStatus;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<bv4.a> _outfitInfo;

    /* renamed from: F */
    private final LiveData<bv4.a> outfitInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<LikeData> _likeData;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<LikeData> likeData;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Long> _dressCount;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<Long> dressCount;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<ZplanSuitOutfitPreviewConfig> outfitPreviewConfig;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<SuitOutfitPreviewBgUrlConfig> outfitPreviewBgUrlConfig;

    /* renamed from: M, reason: from kotlin metadata */
    private String feedHippyJumpUrl;

    /* renamed from: N, reason: from kotlin metadata */
    private AigcAnimHelper suitAnimHelper;

    /* renamed from: P, reason: from kotlin metadata */
    private AigcPreviewBusinessScene scene;

    /* renamed from: Q */
    private UEAvatarGender currentGender;

    /* renamed from: R */
    private final com.tencent.mobileqq.zplan.aigc.helper.d downloadLightSDKHelper;

    /* renamed from: S */
    private final List<String> backgroundImageList;

    /* renamed from: T, reason: from kotlin metadata */
    private final List<String> backgroundThumbImageList;

    /* renamed from: i, reason: from kotlin metadata */
    private final MutableLiveData<String> _currentETag;

    /* renamed from: m */
    private final LiveData<String> currentETag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel$a", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$c;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements AigcPreviewBusinessScene.c {

        /* renamed from: b */
        final /* synthetic */ boolean f330879b;

        /* renamed from: c */
        final /* synthetic */ Function1<Boolean, Unit> f330880c;

        /* JADX WARN: Multi-variable type inference failed */
        a(boolean z16, Function1<? super Boolean, Unit> function1) {
            this.f330879b = z16;
            this.f330880c = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene.c
        public void a() {
            AigcAnimHelper suitAnimHelper = SuitOutfitViewModel.this.getSuitAnimHelper();
            Intrinsics.checkNotNull(suitAnimHelper);
            AigcPreviewBusinessScene scene = SuitOutfitViewModel.this.getScene();
            this.f330880c.invoke(Boolean.valueOf(suitAnimHelper.D1(scene != null ? scene.getViewerV2() : null, false, this.f330879b)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<z> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(z result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SuitOutfitViewModel", 1, "requestRoleData onResultSuccess ");
            String t26 = SuitOutfitViewModel.this.t2(result);
            if (t26 != null) {
                SuitOutfitViewModel.this.E2(t26);
                com.tencent.mobileqq.zplan.aigc.helper.h.f330325a.p("getFeedHippyPageJumpUrl", t26);
            } else {
                QLog.e("SuitOutfitViewModel", 1, "jumpUrl is null");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SuitOutfitViewModel", 1, "requestRoleData onResultFailure error: " + error + ", message: " + message);
        }
    }

    public static final void c2(SuitOutfitViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101832", new c());
    }

    public static final void e2(SuitOutfitViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101805", new d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
    
        r5 = kotlin.collections.ArraysKt___ArraysKt.toList(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String t2(z rsp) {
        List emptyList;
        Object obj;
        r rVar = rsp.f430212b;
        if (rVar == null || (r5 = rVar.f427671o) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator it = emptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((s) obj).f427688i == 16) {
                break;
            }
        }
        s sVar = (s) obj;
        if (sVar != null) {
            return sVar.f427682c;
        }
        return null;
    }

    private final boolean v2(int slotId, az storeItem, JSONObject effectSlotItemsString) {
        boolean contains$default;
        if (r94.b.G(storeItem) || (slotId > 100 && slotId != 202)) {
            return false;
        }
        if ((slotId == 11 && Intrinsics.areEqual(storeItem.f440277d, "\u624b\uff08\u91cd\u8981\u522b\u5220\uff09")) || slotId == 4) {
            return false;
        }
        String str = storeItem.f440277d;
        Intrinsics.checkNotNullExpressionValue(str, "storeItem.name");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "N0", false, 2, (Object) null);
        return (contains$default || slotId != storeItem.f440290q.f440324a || U1((long) slotId, (long) storeItem.f440275b, effectSlotItemsString)) ? false : true;
    }

    public final void A2(String feedID) {
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitViewModel$requestLikeClick$1(this, feedID, null), 3, null);
    }

    public final void B2(com.tencent.mobileqq.zootopia.api.e<z> cb5, int tianshuAdId) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitViewModel$requestRoleData$1(tianshuAdId, cb5, null), 3, null);
    }

    public final void D2(UEAvatarGender uEAvatarGender) {
        this.currentGender = uEAvatarGender;
    }

    public final void E2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedHippyJumpUrl = str;
    }

    public final void F2(LikeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._likeData.postValue(data);
    }

    public final void G2(AigcPreviewBusinessScene aigcPreviewBusinessScene) {
        this.scene = aigcPreviewBusinessScene;
    }

    public final void H2(AigcAnimHelper aigcAnimHelper) {
        this.suitAnimHelper = aigcAnimHelper;
    }

    public final void S1(boolean isLoop, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
        if (aigcPreviewBusinessScene != null) {
            aigcPreviewBusinessScene.setLoadAnimationListener(new a(isLoop, callback));
        }
    }

    public final void W1(String feedID, com.tencent.mobileqq.zootopia.api.e<Long> callback) {
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitViewModel$deleteFeed$1(feedID, callback, null), 3, null);
    }

    public final void X1(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.downloadLightSDKHelper.b(listener);
    }

    public final void Z1() {
        String h16 = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a.h("getFeedHippyPageJumpUrl", "");
        if (!Intrinsics.areEqual(h16, "")) {
            this.feedHippyJumpUrl = h16;
        } else {
            C2(this, new b(), 0, 2, null);
        }
    }

    public final void a2(String feedID, Context context) {
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this._fetchStatus.getValue() == Companion.GetFeedStatus.GET_FEED_STATUS_SUCCESS) {
            return;
        }
        if (!NetworkUtil.isNetSupport(context)) {
            QLog.d("SuitOutfitViewModel", 2, "network error");
            this._fetchStatus.postValue(Companion.GetFeedStatus.GET_FEED_STATUS_NET_ERROR);
        } else {
            this._fetchStatus.postValue(Companion.GetFeedStatus.GET_FEED_STATUS_REQUESTING);
            QLog.d("SuitOutfitViewModel", 2, "fetchOutfitData begin");
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SuitOutfitViewModel$fetchOutfitData$1(this, feedID, null), 3, null);
        }
    }

    public final void b2() {
        QLog.i("SuitOutfitViewModel", 1, "fetchOutfitPreviewBgUrlConfig begin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.h
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitViewModel.c2(SuitOutfitViewModel.this);
            }
        }, 128, null, true);
    }

    public final void d2() {
        QLog.i("SuitOutfitViewModel", 1, "fetchOutfitPreviewConfig begin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.i
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitViewModel.e2(SuitOutfitViewModel.this);
            }
        }, 64, null, true);
    }

    public final List<String> f2() {
        return this.backgroundImageList;
    }

    public final List<String> g2() {
        return this.backgroundThumbImageList;
    }

    /* renamed from: h2, reason: from getter */
    public final UEAvatarGender getCurrentGender() {
        return this.currentGender;
    }

    public final bv4.f i2() {
        AigcAnimHelper aigcAnimHelper = this.suitAnimHelper;
        List<SuitAnimationItem> list = null;
        Integer valueOf = aigcAnimHelper != null ? Integer.valueOf(aigcAnimHelper.getCurrentAnimIndex()) : null;
        if (this.currentGender == UEAvatarGender.FEMALE) {
            ZplanSuitOutfitPreviewConfig value = this.outfitPreviewConfig.getValue();
            if (value != null) {
                list = value.getFemale();
            }
        } else {
            ZplanSuitOutfitPreviewConfig value2 = this.outfitPreviewConfig.getValue();
            if (value2 != null) {
                list = value2.getMale();
            }
        }
        if (valueOf != null) {
            List<SuitAnimationItem> list2 = list;
            if (!(list2 == null || list2.isEmpty()) && valueOf.intValue() < list.size() && valueOf.intValue() >= 0) {
                bv4.f fVar = new bv4.f();
                fVar.f29281b = list.get(valueOf.intValue()).getBodyAction();
                fVar.f29280a = list.get(valueOf.intValue()).getHeadAction();
                return fVar;
            }
        }
        return new bv4.f();
    }

    public final String j2() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        return currentUin;
    }

    public final LiveData<Long> k2() {
        return this.dressCount;
    }

    public final LiveData<Companion.GetFeedStatus> l2() {
        return this.fetchStatus;
    }

    public final LiveData<LikeData> m2() {
        return this.likeData;
    }

    public final List<az> n2() {
        List<az> list;
        HashMap hashMap = new HashMap();
        JSONObject t16 = FilamentFeatureUtil.f106409g.t();
        for (Map.Entry<Integer, az> entry : com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.d().b().b().entrySet()) {
            int intValue = entry.getKey().intValue();
            az value = entry.getValue();
            if (v2(intValue, value, t16)) {
                hashMap.put(Integer.valueOf(intValue), value);
            }
        }
        Collection values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "list.values");
        list = CollectionsKt___CollectionsKt.toList(values);
        return list;
    }

    public final LiveData<bv4.a> o2() {
        return this.outfitInfo;
    }

    public final MutableLiveData<SuitOutfitPreviewBgUrlConfig> p2() {
        return this.outfitPreviewBgUrlConfig;
    }

    public final MutableLiveData<ZplanSuitOutfitPreviewConfig> q2() {
        return this.outfitPreviewConfig;
    }

    /* renamed from: r2, reason: from getter */
    public final AigcPreviewBusinessScene getScene() {
        return this.scene;
    }

    /* renamed from: s2, reason: from getter */
    public final AigcAnimHelper getSuitAnimHelper() {
        return this.suitAnimHelper;
    }

    public final void u2() {
        AigcAnimHelper aigcAnimHelper;
        List<SuitAnimationItem> list = null;
        if (this.currentGender == UEAvatarGender.MALE) {
            ZplanSuitOutfitPreviewConfig value = this.outfitPreviewConfig.getValue();
            if (value != null) {
                list = value.getMale();
            }
        } else {
            ZplanSuitOutfitPreviewConfig value2 = this.outfitPreviewConfig.getValue();
            if (value2 != null) {
                list = value2.getFemale();
            }
        }
        if (list == null || (aigcAnimHelper = this.suitAnimHelper) == null) {
            return;
        }
        aigcAnimHelper.z1(list, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$initMasterAvatarAnimation$1$1
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
                if (!z16) {
                    QLog.e("SuitOutfitViewModel", 1, "fetchOutfitPreviewActions failed");
                } else {
                    SuitOutfitViewModel.T1(SuitOutfitViewModel.this, false, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$initMasterAvatarAnimation$1$1.1
                        public final void invoke(boolean z17) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                }
            }
        });
    }

    public final boolean w2(gl0.b listener, boolean downloadSo) {
        return this.downloadLightSDKHelper.d(listener, downloadSo);
    }

    public final void x2(String r16, String avatarUrlThumb, String backgroundUrl, String backgroundThumbUrl, nk3.h callback) {
        long[] longArray;
        long[] longArray2;
        long[] longArray3;
        long[] longArray4;
        Intrinsics.checkNotNullParameter(r16, "avatarUrl");
        Intrinsics.checkNotNullParameter(avatarUrlThumb, "avatarUrlThumb");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(backgroundThumbUrl, "backgroundThumbUrl");
        bv4.c cVar = new bv4.c();
        cVar.f29265a = "";
        cVar.f29268d = System.currentTimeMillis();
        bv4.b bVar = new bv4.b();
        bVar.f29259a = r16;
        bVar.f29262d = avatarUrlThumb;
        bVar.f29260b = backgroundUrl;
        bVar.f29263e = backgroundThumbUrl;
        com.tencent.sqshow.zootopia.nativeui.data.c cVar2 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        bVar.f29261c = cVar2.d().b().getAvatarCharacter();
        bVar.f29264f = i2();
        JSONObject t16 = FilamentFeatureUtil.f106409g.t();
        bv4.e eVar = new bv4.e();
        Map<Integer, az> b16 = cVar2.d().b().b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator<Map.Entry<Integer, az>> it = b16.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, az> next = it.next();
            int intValue = next.getKey().intValue();
            az value = next.getValue();
            if (v2(intValue, value, t16)) {
                Iterator<Map.Entry<Integer, az>> it5 = it;
                if (value.f440275b > 0 && value.f440276c <= 0) {
                    int i3 = value.f440296w;
                    if (i3 == UEAvatarGender.MALE.getIndex()) {
                        arrayList2.add(Long.valueOf(value.f440275b));
                    } else if (i3 == UEAvatarGender.FEMALE.getIndex()) {
                        arrayList4.add(Long.valueOf(value.f440275b));
                    } else {
                        arrayList2.add(Long.valueOf(value.f440275b));
                        arrayList4.add(Long.valueOf(value.f440275b));
                    }
                }
                if (value.f440276c > 0) {
                    int i16 = value.f440296w;
                    if (i16 == UEAvatarGender.MALE.getIndex()) {
                        arrayList.add(Long.valueOf(value.f440276c));
                    } else if (i16 == UEAvatarGender.FEMALE.getIndex()) {
                        arrayList3.add(Long.valueOf(value.f440276c));
                    } else {
                        arrayList.add(Long.valueOf(value.f440276c));
                        arrayList3.add(Long.valueOf(value.f440276c));
                    }
                }
                it = it5;
            }
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
        eVar.f29277d = longArray;
        longArray2 = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        eVar.f29275b = longArray2;
        longArray3 = CollectionsKt___CollectionsKt.toLongArray(arrayList4);
        eVar.f29276c = longArray3;
        longArray4 = CollectionsKt___CollectionsKt.toLongArray(arrayList3);
        eVar.f29274a = longArray4;
        eVar.f29279f = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b().getIndex();
        ZPlanOutfitPublishHelper.f330231a.a(r16, bVar, cVar, eVar, callback);
    }

    public final void y2(String feedID, String reason) {
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        Intrinsics.checkNotNullParameter(reason, "reason");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitViewModel$reportFeedViolation$1(feedID, reason, null), 3, null);
    }

    public final void z2(String feedID) {
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitViewModel$requestAddGetDressCount$1(feedID, this, null), 3, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel$c", "Lpy2/a;", "Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewBgConfigParser$b;", DownloadInfo.spKey_Config, "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements py2.a<ZPlanSuitOutfitPreviewBgConfigParser.b> {
        c() {
        }

        @Override // py2.a
        /* renamed from: b */
        public void a(ZPlanSuitOutfitPreviewBgConfigParser.b r85) {
            SuitOutfitPreviewBgUrlConfig outfitBgUrlConfig;
            QLog.i("SuitOutfitViewModel", 1, "fetchOutfitPreviewBgUrlConfig end config: " + (r85 != null ? r85.getOutfitBgUrlConfig() : null));
            if (((r85 == null || (outfitBgUrlConfig = r85.getOutfitBgUrlConfig()) == null) ? null : outfitBgUrlConfig.getBgUrlList()) != null) {
                List<SuitOutfitPreviewBgUrlItem> bgUrlList = r85.getOutfitBgUrlConfig().getBgUrlList();
                if (!(bgUrlList == null || bgUrlList.isEmpty())) {
                    SuitOutfitViewModel.this.f2().clear();
                    SuitOutfitViewModel.this.g2().clear();
                    List<SuitOutfitPreviewBgUrlItem> bgUrlList2 = r85.getOutfitBgUrlConfig().getBgUrlList();
                    SuitOutfitViewModel suitOutfitViewModel = SuitOutfitViewModel.this;
                    for (SuitOutfitPreviewBgUrlItem suitOutfitPreviewBgUrlItem : bgUrlList2) {
                        if (suitOutfitPreviewBgUrlItem == null) {
                            QLog.i("SuitOutfitViewModel", 1, "bgUrlItem is empty");
                            return;
                        } else {
                            suitOutfitViewModel.f2().add(suitOutfitPreviewBgUrlItem.getBgUrl());
                            suitOutfitViewModel.g2().add(suitOutfitPreviewBgUrlItem.getThumbBgUrl());
                        }
                    }
                    SuitOutfitViewModel.this.p2().postValue(r85.getOutfitBgUrlConfig());
                    return;
                }
            }
            QLog.i("SuitOutfitViewModel", 1, "bgUrlList is empty");
            SuitOutfitViewModel.this.p2().postValue(r85 != null ? r85.getOutfitBgUrlConfig() : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel$d", "Lpy2/a;", "Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewConfigParser$b;", DownloadInfo.spKey_Config, "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements py2.a<ZPlanSuitOutfitPreviewConfigParser.b> {
        d() {
        }

        @Override // py2.a
        /* renamed from: b */
        public void a(ZPlanSuitOutfitPreviewConfigParser.b r56) {
            QLog.i("SuitOutfitViewModel", 1, "fetchOutfitPreviewConfig end config: " + (r56 != null ? r56.getOutfitConfig() : null));
            SuitOutfitViewModel.this.q2().postValue(r56 != null ? r56.getOutfitConfig() : null);
        }
    }

    public SuitOutfitViewModel() {
        List<String> mutableListOf;
        List<String> mutableListOf2;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._currentETag = mutableLiveData;
        this.currentETag = mutableLiveData;
        MutableLiveData<Companion.GetFeedStatus> mutableLiveData2 = new MutableLiveData<>();
        this._fetchStatus = mutableLiveData2;
        this.fetchStatus = mutableLiveData2;
        MutableLiveData<bv4.a> mutableLiveData3 = new MutableLiveData<>();
        this._outfitInfo = mutableLiveData3;
        this.outfitInfo = mutableLiveData3;
        MutableLiveData<LikeData> mutableLiveData4 = new MutableLiveData<>();
        this._likeData = mutableLiveData4;
        this.likeData = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._dressCount = mutableLiveData5;
        this.dressCount = mutableLiveData5;
        this.outfitPreviewConfig = new MutableLiveData<>();
        this.outfitPreviewBgUrlConfig = new MutableLiveData<>();
        this.feedHippyJumpUrl = "";
        this.downloadLightSDKHelper = new com.tencent.mobileqq.zplan.aigc.helper.d();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://image.superqqshow.qq.com/qq/outfit_bg/bg001.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg002.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg003.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg004.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg005.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg006.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg007.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg008.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg009.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg010.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg011.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg012.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg013.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg014.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg015.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg016.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg017.jpg");
        this.backgroundImageList = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("https://image.superqqshow.qq.com/qq/outfit_bg/bg001_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg002_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg003_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg004_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg005_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg006_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg007_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg008_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg009_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg010_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg011_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg012_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg013_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg014_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg015_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg016_thumb.jpg", "https://image.superqqshow.qq.com/qq/outfit_bg/bg017_thumb.jpg");
        this.backgroundThumbImageList = mutableListOf2;
    }

    public static /* synthetic */ void C2(SuitOutfitViewModel suitOutfitViewModel, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        suitOutfitViewModel.B2(eVar, i3);
    }

    public static /* synthetic */ void T1(SuitOutfitViewModel suitOutfitViewModel, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        suitOutfitViewModel.S1(z16, function1);
    }

    private final boolean U1(long slotId, long itemId, JSONObject effectSlotItemsString) {
        if (effectSlotItemsString == null || effectSlotItemsString.isNull("slot_items")) {
            return slotId == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EARRINGS.getValue();
        }
        JSONArray optJSONArray = effectSlotItemsString.optJSONArray("slot_items");
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                if (slotId != optLong) {
                    continue;
                } else {
                    if (slotId == optLong && optJSONObject.isNull("items")) {
                        QLog.i("SuitOutfitViewModel", 1, "checkIsEffectSlot slotId " + slotId + " effectSlotId " + optLong);
                        return true;
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        if (itemId == optJSONArray2.optLong(i16)) {
                            QLog.i("SuitOutfitViewModel", 1, "checkIsEffectSlot slotId " + slotId + " effectSlotId " + optLong);
                            return true;
                        }
                    }
                }
            }
        }
        QLog.i("SuitOutfitViewModel", 1, "checkIsEffectSlot slotId " + slotId + " effectSlotItemsString " + effectSlotItemsString);
        return false;
    }
}
