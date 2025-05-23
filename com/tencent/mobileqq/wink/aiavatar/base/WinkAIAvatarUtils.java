package com.tencent.mobileqq.wink.aiavatar.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aiavatar.detailpage.AIAvatarImgPickGuideDataItem;
import com.tencent.mobileqq.wink.aiavatar.detailpage.ImagePickGuideWrapper;
import com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarCoupleMediaPickerFragment;
import com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarSingleMediaPickerFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.request.material.WinkGetRecommendMaterialByIdReq;
import com.tencent.mobileqq.wink.share.WinkShareManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMaterialDistribution$GetRecommendCatMatTreeRsp;
import qshadow.QShadowMetaMaterial$CategoryInfo;
import qshadow.QShadowMetaMaterial$MaterialInfo;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bu\u0010vJ&\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J$\u0010\r\u001a\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J.\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0002J*\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u001a\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\nJ\u000e\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020 J<\u0010-\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020 2\b\b\u0002\u0010*\u001a\u00020$2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0002J\u001e\u0010/\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0016J?\u00104\u001a\u00020\b\"\b\b\u0000\u00101*\u0002002\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00062\u000e\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001022\u0006\u0010.\u001a\u00020\u0016\u00a2\u0006\u0004\b4\u00105J\u0016\u00109\u001a\u0002082\u0006\u0010'\u001a\u00020&2\u0006\u00107\u001a\u000206J1\u0010@\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\b0\nJ<\u0010E\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u00162$\u0010\f\u001a \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0004\u0012\u00020\b0CJ\u001a\u0010G\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0016J\u0010\u0010I\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010K\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010(\u001a\u00020\u0006J&\u0010M\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\b\b\u0002\u0010B\u001a\u00020\u0016J<\u0010Q\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u00162\u0006\u0010#\u001a\u00020 2\u0006\u0010P\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001dJ\u000e\u0010S\u001a\u00020\u00162\u0006\u0010R\u001a\u00020$J\u000e\u0010T\u001a\u00020\u00162\u0006\u0010R\u001a\u00020$J\u000e\u0010U\u001a\u00020\u00162\u0006\u0010R\u001a\u00020$J\u000e\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020VR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010]R\u0016\u0010`\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010_R\u0016\u0010a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010_R\u0016\u0010b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010_R\u0016\u0010d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010cR\u0016\u0010f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010gR$\u0010o\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\be\u0010l\"\u0004\bm\u0010nR(\u0010t\u001a\u00020\u0016*\u00020\u00062\u0006\u0010p\u001a\u00020\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bj\u0010q\"\u0004\br\u0010s\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarUtils;", "", "", "Lqshadow/QShadowMetaMaterial$CategoryInfo;", "categoryList", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "", "t", "Lkotlin/Function1;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "responseCallback", "v", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/b;", "wrapper", "c", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/a;", "f", "i", "Lcom/tencent/mobileqq/wink/share/a;", "info", "", "shareUrl", "G", "shareInfo", "businessId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "shareCallback", "B", "", "ignoreCache", "u", "isCoupleStyle", "", "k", "Landroid/content/Context;", "context", WadlProxyConsts.KEY_MATERIAL, "ignoreContextExtras", "requestCode", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "alreadySelectedMedia", "p", "comeFrom", "r", "Landroid/view/View;", "T", "", "shareView", ReportConstant.COSTREPORT_PREFIX, "(Landroid/content/Context;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;[Landroid/view/View;Ljava/lang/String;)V", "", "size", "Landroid/graphics/drawable/Drawable;", "o", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lkotlin/ParameterName;", "name", "result", "callback", "d", "materialID", "categoryID", "Lkotlin/Function3;", "", "w", "msg", UserInfo.SEX_FEMALE, "shareCategory", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "imageGuideCategory", HippyTKDListViewAdapter.X, "g", BdhLogUtil.LogTag.Tag_Conn, "previewUrl", "nickName", "schemaExtra", "E", "serviceId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "Landroid/content/Intent;", "intent", "e", "Lcom/tencent/mobileqq/widget/QQToast;", "b", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "Z", "shareIsShowing", "Ljava/lang/String;", "shareMainPageInfoJson", "shareResultPageInfoJson", "defaultUploadImageSuggestJson", "Lcom/tencent/mobileqq/wink/share/a;", "originShareMainPageModel", h.F, "originShareResultPageModel", "Ljava/util/List;", "imagePickGuideInfoList", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "j", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "()Lqshadow/ShadowAIGCStatus$GetStatusReply;", "y", "(Lqshadow/ShadowAIGCStatus$GetStatusReply;)V", "latestGenerateBtnStatus", "value", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "recommendCategoryId", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarUtils {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQToast qqToast;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean shareIsShowing;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ShadowAIGCStatus$GetStatusReply latestGenerateBtnStatus;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkAIAvatarUtils f317678a = new WinkAIAvatarUtils();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String shareMainPageInfoJson = "{     \"title\": \"\u6b22\u8fce\u4f53\u9a8cAI\u5934\u50cf\",     \"preview\": \"https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_avatar_ai_ark_img.png\",     \"desc\": \"\u5feb\u6765\u5236\u4f5c\u4e00\u6b3e\u9177\u70ab\u7684AI\u5934\u50cf\u5427\uff01\",     \"prompt\": \"\u6765AI\u5934\u50cf\u4f53\u9a8c\u5947\u8da3\u7f8e\u56fe\uff0c\u53d1\u73b0\u767e\u53d8\u81ea\u6211\",     \"shareUrl\": \"mqqapi://qcircle/openqqpublish?target=24\",     \"tagIcon\": \"https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_icon_avatar_ai_ark.png\",     \"tagName\": \"AI\u5934\u50cf\",     \"shareExternalUrl\": \"https://h5.tu.qq.com/stg-one/ai-avatar/index?url=\" }";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String shareResultPageInfoJson = "{     \"title\": \"AI\u5934\u50cf\",     \"preview\": \"https://qq-video.cdn-go.cn/ios/latest/defaultmode/9105/qzone_lingganku_ai_share.jpg\",     \"desc\": \"${name}\u5236\u4f5c\u4e86AI\u5934\u50cf\uff0c\u5feb\u6765\u770b\u770b\u5427\uff01\",     \"coupleDesc\": \"${name}\u5236\u4f5c\u4e86\u60c5\u4fa3\u6b3eAI\u5934\u50cf\uff0c\u5feb\u6765\u770b\u770b\u5427\uff01\",     \"coupleGiftDesc\": \"${name}\u9001\u4f60\u60c5\u4fa3\u5934\u50cf\",     \"prompt\": \"\u6765AI\u5934\u50cf\u4f53\u9a8c\u5947\u8da3\u7f8e\u56fe\uff0c\u53d1\u73b0\u767e\u53d8\u81ea\u6211\",     \"shareUrl\": \"mqqapi://qcircle/openqqpublish?target=25&material_id=${material_id}&come_from=2\",     \"tagIcon\": \"https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_icon_avatar_ai_ark.png\",     \"tagName\": \"AI\u5934\u50cf\",     \"shareExternalUrl\": \"https://h5.tu.qq.com/stg-one/ai-avatar/result?url=\" }";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String defaultUploadImageSuggestJson = "{     \"items\": [         {             \"iconUrl\": \"https://downv6.qq.com/shadow_qqcamera/AIAvatar/suggust_sample_0_v1_tick.png\",             \"iconTitle\": \"\\u6b63\\u9762\\u6e05\\u6670\",             \"isRight\": 1         },         {             \"iconUrl\": \"https://downv6.qq.com/shadow_qqcamera/AIAvatar/suggust_sample_1_v1_closed.png\",             \"iconTitle\": \"\\u4fa7\\u8138\\u7167\\u7247\",             \"isRight\": 0         },         {             \"iconUrl\": \"https://downv6.qq.com/shadow_qqcamera/AIAvatar/suggust_sample_2_v1_closed.png\",             \"iconTitle\": \"\\u9762\\u90e8\\u6709\\u906e\\u6321\",             \"isRight\": 0         },         {             \"iconUrl\": \"https://downv6.qq.com/shadow_qqcamera/AIAvatar/suggust_sample_3_v1_closed.png\",             \"iconTitle\": \"\\u8fc7\\u4e8e\\u6a21\\u7cca\",             \"isRight\": 0         }         ]     }";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.wink.share.a originShareMainPageModel = new com.tencent.mobileqq.wink.share.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.wink.share.a originShareResultPageModel = new com.tencent.mobileqq.wink.share.a();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<ImagePickGuideWrapper> imagePickGuideInfoList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarUtils$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f317688a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f317688a = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f317688a.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            this.f317688a.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarUtils$b", "Lw93/a;", "Lqshadow/QShadowMaterialDistribution$GetRecommendCatMatTreeRsp;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements w93.a<QShadowMaterialDistribution$GetRecommendCatMatTreeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Long, List<MetaMaterial>, Unit> f317689a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Boolean, ? super Long, ? super List<MetaMaterial>, Unit> function3) {
            this.f317689a = function3;
        }

        @Override // w93.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable QShadowMaterialDistribution$GetRecommendCatMatTreeRsp pbResponse) {
            Integer num;
            PBRepeatMessageField<QShadowMetaMaterial$CategoryInfo> pBRepeatMessageField;
            List<QShadowMetaMaterial$CategoryInfo> list = null;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            w53.b.f("WinkAIAvatarUtils", "requestRecommendMaterial onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            ArrayList arrayList = new ArrayList();
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            if (pbResponse != null && (pBRepeatMessageField = pbResponse.categories) != null) {
                list = pBRepeatMessageField.get();
            }
            winkAIAvatarUtils.t(list, arrayList);
            this.f317689a.invoke(Boolean.valueOf(isSuccess), Long.valueOf(retCode), arrayList);
        }
    }

    WinkAIAvatarUtils() {
    }

    private final void B(com.tencent.mobileqq.wink.share.a shareInfo, String businessId, Activity activity, Function0<Unit> shareCallback) {
        if (!shareIsShowing && (activity instanceof FragmentActivity)) {
            shareIsShowing = true;
            WinkShareManager winkShareManager = WinkShareManager.f326323a;
            winkShareManager.i((FragmentActivity) activity, shareInfo, winkShareManager.g(shareInfo, businessId, 52136, businessId), 2, new WinkAIAvatarUtils$shareAIAvatar$1(shareCallback), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils$shareAIAvatar$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkAIAvatarUtils.shareIsShowing = false;
                }
            });
        }
    }

    public static /* synthetic */ void D(WinkAIAvatarUtils winkAIAvatarUtils, Activity activity, Function0 function0, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        winkAIAvatarUtils.C(activity, function0, str);
    }

    private final void G(com.tencent.mobileqq.wink.share.a info, String shareUrl) {
        boolean z16;
        String g16 = com.tencent.mobileqq.wink.schema.d.f326305a.g(shareUrl);
        String shareExternalUrl = info.getShareExternalUrl();
        if (shareExternalUrl != null && shareExternalUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.c("WinkAIAvatarUtils", "updateExternalShareUrl shareUrl is empty");
            info.n("https://ti.qq.com/new_open_qq/index.html?appid=13&url=" + g16);
            info.o("https://ti.qq.com/new_open_qq/index.html?appid=13&url=" + g16);
            return;
        }
        info.n(info.getShareExternalUrl() + g16);
        info.o(info.getShareUrlPrefix() + g16);
    }

    private final void c(ImagePickGuideWrapper wrapper) {
        if (!imagePickGuideInfoList.contains(wrapper)) {
            imagePickGuideInfoList.add(wrapper);
        }
    }

    private final List<AIAvatarImgPickGuideDataItem> f() {
        Object obj;
        List<AIAvatarImgPickGuideDataItem> b16;
        Iterator<T> it = imagePickGuideInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((ImagePickGuideWrapper) obj).getId(), "ai_avatar_single_upload_img_suggest_info")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ImagePickGuideWrapper imagePickGuideWrapper = (ImagePickGuideWrapper) obj;
        if (imagePickGuideWrapper == null || (b16 = imagePickGuideWrapper.b()) == null) {
            return i();
        }
        return b16;
    }

    private final List<AIAvatarImgPickGuideDataItem> i() {
        Object m476constructorimpl;
        List emptyList;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object fromJson = new Gson().fromJson(defaultUploadImageSuggestJson, (Class<Object>) ImagePickGuideWrapper.class);
            ImagePickGuideWrapper imagePickGuideWrapper = (ImagePickGuideWrapper) fromJson;
            imagePickGuideWrapper.c("ai_avatar_single_upload_img_suggest_info");
            w53.b.a("WinkAIAvatarUtils", "setImgPickGuideInfo materialGuide: " + imagePickGuideWrapper.b());
            List<AIAvatarImgPickGuideDataItem> b16 = ((ImagePickGuideWrapper) fromJson).b();
            if (b16 == null) {
                b16 = CollectionsKt__CollectionsKt.emptyList();
            }
            m476constructorimpl = Result.m476constructorimpl(b16);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            w53.b.d("WinkAIAvatarUtils", "parse local image guide failed", m479exceptionOrNullimpl);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = emptyList;
        }
        return (List) m476constructorimpl;
    }

    public static /* synthetic */ void q(WinkAIAvatarUtils winkAIAvatarUtils, Context context, MetaMaterial metaMaterial, boolean z16, int i3, List list, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i16 & 8) != 0) {
            i3 = 100;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            list = null;
        }
        winkAIAvatarUtils.p(context, metaMaterial, z17, i17, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List<QShadowMetaMaterial$CategoryInfo> categoryList, List<MetaMaterial> materials) {
        List<QShadowMetaMaterial$MaterialInfo> list;
        if (categoryList != null) {
            for (QShadowMetaMaterial$CategoryInfo qShadowMetaMaterial$CategoryInfo : categoryList) {
                PBRepeatMessageField<QShadowMetaMaterial$MaterialInfo> pBRepeatMessageField = qShadowMetaMaterial$CategoryInfo.materials;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "get()");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo = ((QShadowMetaMaterial$MaterialInfo) it.next()).get();
                        Intrinsics.checkNotNullExpressionValue(qShadowMetaMaterial$MaterialInfo, "material.get()");
                        MetaMaterial j3 = v53.a.j(qShadowMetaMaterial$MaterialInfo, null, 1, null);
                        String str = qShadowMetaMaterial$CategoryInfo.f429483id.get();
                        Intrinsics.checkNotNullExpressionValue(str, "category.id.get()");
                        com.tencent.mobileqq.wink.editor.c.o1(j3, str);
                        String str2 = qShadowMetaMaterial$CategoryInfo.name.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "category.name.get()");
                        com.tencent.mobileqq.wink.editor.c.p1(j3, str2);
                        materials.add(j3);
                    }
                }
                f317678a.t(qShadowMetaMaterial$CategoryInfo.subCategories.get(), materials);
            }
        }
    }

    private final void v(final Function1<? super List<MetaCategory>, Unit> responseCallback) {
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkAIAvatarServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarServiceHandler");
        WinkAIAvatarServiceHandler winkAIAvatarServiceHandler = (WinkAIAvatarServiceHandler) businessHandler;
        winkAIAvatarServiceHandler.r3(new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils$requestMaterials$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<MetaCategory> list) {
                responseCallback.invoke(list);
            }
        });
        winkAIAvatarServiceHandler.m3("AiAvatar");
    }

    public final void A(@Nullable MetaCategory shareCategory) {
        List<MetaMaterial> emptyList;
        if (shareCategory == null || (emptyList = shareCategory.materials) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        for (MetaMaterial shareMaterial : emptyList) {
            if (Intrinsics.areEqual(shareMaterial.f30533id, "ai_avatar_mainpage_share_info")) {
                Intrinsics.checkNotNullExpressionValue(shareMaterial, "shareMaterial");
                w53.b.a("WinkAIAvatarUtils", "share main set from share material: " + com.tencent.mobileqq.wink.editor.c.p0(shareMaterial));
                shareMainPageInfoJson = com.tencent.mobileqq.wink.editor.c.p0(shareMaterial);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Object fromJson = new Gson().fromJson(com.tencent.mobileqq.wink.editor.c.p0(shareMaterial), (Class<Object>) com.tencent.mobileqq.wink.share.a.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(\n       \u2026ava\n                    )");
                    originShareMainPageModel = (com.tencent.mobileqq.wink.share.a) fromJson;
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
            if (Intrinsics.areEqual(shareMaterial.f30533id, "ai_avatar_resultpage_share_info")) {
                Intrinsics.checkNotNullExpressionValue(shareMaterial, "shareMaterial");
                w53.b.a("WinkAIAvatarUtils", "share result set from share material: " + com.tencent.mobileqq.wink.editor.c.p0(shareMaterial));
                shareResultPageInfoJson = com.tencent.mobileqq.wink.editor.c.p0(shareMaterial);
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Object fromJson2 = new Gson().fromJson(com.tencent.mobileqq.wink.editor.c.p0(shareMaterial), (Class<Object>) com.tencent.mobileqq.wink.share.a.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson2, "Gson().fromJson(\n       \u2026ava\n                    )");
                    originShareResultPageModel = (com.tencent.mobileqq.wink.share.a) fromJson2;
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th6) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
            }
        }
    }

    public final void C(@NotNull Activity activity, @NotNull Function0<Unit> shareCallback, @NotNull String categoryID) {
        Object obj;
        Throwable th5;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        Intrinsics.checkNotNullParameter(categoryID, "categoryID");
        com.tencent.mobileqq.wink.share.a aVar = new com.tencent.mobileqq.wink.share.a();
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = new Gson().fromJson(shareMainPageInfoJson, (Class<Object>) com.tencent.mobileqq.wink.share.a.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Gson().fromJson(\n       \u2026:class.java\n            )");
        } catch (Throwable th6) {
            obj = aVar;
            th5 = th6;
        }
        try {
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th7) {
            th5 = th7;
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
            com.tencent.mobileqq.wink.share.a aVar2 = (com.tencent.mobileqq.wink.share.a) obj;
            w53.b.a("WinkAIAvatarUtils", "shareAvatarMainPage shareUrl:" + aVar2.getShareUrl());
            G(aVar2, aVar2.getShareUrl());
            B(aVar2, "qzone_ai_avatar_mainpage", activity, shareCallback);
        }
        com.tencent.mobileqq.wink.share.a aVar22 = (com.tencent.mobileqq.wink.share.a) obj;
        w53.b.a("WinkAIAvatarUtils", "shareAvatarMainPage shareUrl:" + aVar22.getShareUrl());
        G(aVar22, aVar22.getShareUrl());
        B(aVar22, "qzone_ai_avatar_mainpage", activity, shareCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(@NotNull String previewUrl, @NotNull String nickName, boolean isCoupleStyle, @NotNull String schemaExtra, @NotNull Activity activity, @NotNull Function0<Unit> shareCallback) {
        Object obj;
        Throwable th5;
        String coupleDesc;
        boolean z16;
        Intrinsics.checkNotNullParameter(previewUrl, "previewUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(schemaExtra, "schemaExtra");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        com.tencent.mobileqq.wink.share.a aVar = new com.tencent.mobileqq.wink.share.a();
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = new Gson().fromJson(shareResultPageInfoJson, (Class<Object>) com.tencent.mobileqq.wink.share.a.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Gson().fromJson(\n       \u2026:class.java\n            )");
            try {
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th6) {
                th5 = th6;
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
                com.tencent.mobileqq.wink.share.a aVar2 = (com.tencent.mobileqq.wink.share.a) obj;
                com.tencent.mobileqq.wink.schema.d dVar = com.tencent.mobileqq.wink.schema.d.f326305a;
                aVar2.l(dVar.n(aVar2.getDesc(), "name", nickName));
                coupleDesc = aVar2.getCoupleDesc();
                if (coupleDesc == null) {
                }
                z16 = true;
                if (isCoupleStyle & (!z16)) {
                }
                aVar2.m(previewUrl);
                String p16 = dVar.p(aVar2.getShareUrl(), schemaExtra, true);
                aVar2.p(dVar.p(aVar2.getShareUrl(), schemaExtra, false));
                G(aVar2, p16);
                B(aVar2, "qzone_ai_avatar_result", activity, shareCallback);
            }
        } catch (Throwable th7) {
            obj = aVar;
            th5 = th7;
        }
        com.tencent.mobileqq.wink.share.a aVar22 = (com.tencent.mobileqq.wink.share.a) obj;
        com.tencent.mobileqq.wink.schema.d dVar2 = com.tencent.mobileqq.wink.schema.d.f326305a;
        aVar22.l(dVar2.n(aVar22.getDesc(), "name", nickName));
        coupleDesc = aVar22.getCoupleDesc();
        if (coupleDesc == null && coupleDesc.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (isCoupleStyle & (!z16)) {
            String coupleDesc2 = aVar22.getCoupleDesc();
            Intrinsics.checkNotNull(coupleDesc2);
            aVar22.l(dVar2.n(coupleDesc2, "name", nickName));
        }
        aVar22.m(previewUrl);
        String p162 = dVar2.p(aVar22.getShareUrl(), schemaExtra, true);
        aVar22.p(dVar2.p(aVar22.getShareUrl(), schemaExtra, false));
        G(aVar22, p162);
        B(aVar22, "qzone_ai_avatar_result", activity, shareCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(@NotNull Context context, @Nullable String msg2) {
        boolean z16;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(context, "context");
        QQToast qQToast = qqToast;
        boolean z17 = true;
        if (qQToast != null && qQToast.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (msg2 != null && msg2.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) msg2, (CharSequence) com.tencent.mobileqq.msf.core.quicksend.b.A, false, 2, (Object) null);
        }
        msg2 = context.getString(R.string.f215145ut);
        Intrinsics.checkNotNullExpressionValue(msg2, "if (msg.isNullOrEmpty() \u2026            msg\n        }");
        try {
            QQToast makeText = QQToast.makeText(context, msg2, 0);
            qqToast = makeText;
            if (makeText != null) {
                makeText.show();
            }
        } catch (Throwable th5) {
            w53.b.c("WinkAIAvatarUtils", "showErrorToast " + th5);
        }
    }

    public final void d(@NotNull QQPermission qqPermission, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (qqPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qqPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            callback.invoke(Boolean.TRUE);
        } else {
            qqPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(callback));
        }
    }

    public final void e(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (companion.l()) {
            return;
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
        WinkContext a16 = companion.a(intent);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, a16.getTraceId());
        companion.o(a16);
    }

    @NotNull
    public final List<AIAvatarImgPickGuideDataItem> g(@NotNull MetaMaterial material) {
        Object obj;
        List<AIAvatarImgPickGuideDataItem> b16;
        Intrinsics.checkNotNullParameter(material, "material");
        Iterator<T> it = imagePickGuideInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((ImagePickGuideWrapper) obj).getId(), com.tencent.mobileqq.wink.editor.c.O0(material))) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ImagePickGuideWrapper imagePickGuideWrapper = (ImagePickGuideWrapper) obj;
        if (imagePickGuideWrapper == null || (b16 = imagePickGuideWrapper.b()) == null) {
            return f();
        }
        return b16;
    }

    @Nullable
    public final ShadowAIGCStatus$GetStatusReply h() {
        return latestGenerateBtnStatus;
    }

    @NotNull
    public final String j(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "recommend_group_id");
    }

    public final int k(boolean isCoupleStyle) {
        if (isCoupleStyle) {
            return 2;
        }
        return 4;
    }

    @NotNull
    public final String l(int serviceId) {
        String tagName;
        if (serviceId != 100) {
            if (serviceId != 101 || (tagName = originShareResultPageModel.getTagName()) == null) {
                return "AI\u5934\u50cf";
            }
        } else {
            tagName = originShareMainPageModel.getTagName();
            if (tagName == null) {
                return "AI\u5934\u50cf";
            }
        }
        return tagName;
    }

    @NotNull
    public final String m(int serviceId) {
        String tagIcon;
        if (serviceId != 100) {
            if (serviceId != 101 || (tagIcon = originShareResultPageModel.getTagIcon()) == null) {
                return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_icon_avatar_ai_ark.png";
            }
        } else {
            tagIcon = originShareMainPageModel.getTagIcon();
            if (tagIcon == null) {
                return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_icon_avatar_ai_ark.png";
            }
        }
        return tagIcon;
    }

    @NotNull
    public final String n(int serviceId) {
        String prompt;
        if (serviceId != 100) {
            if (serviceId != 101 || (prompt = originShareResultPageModel.getPrompt()) == null) {
                return "\u6765AI\u5934\u50cf\u4f53\u9a8c\u5947\u8da3\u7f8e\u56fe\uff0c\u53d1\u73b0\u767e\u53d8\u81ea\u6211";
            }
        } else {
            prompt = originShareMainPageModel.getPrompt();
            if (prompt == null) {
                return "\u6765AI\u5934\u50cf\u4f53\u9a8c\u5947\u8da3\u7f8e\u56fe\uff0c\u53d1\u73b0\u767e\u53d8\u81ea\u6211";
            }
        }
        return prompt;
    }

    @NotNull
    public final Drawable o(@NotNull Context context, float size) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{context.getDrawable(R.drawable.ool)});
        layerDrawable.setLayerSize(0, ImmersiveUtils.dpToPx(size), ImmersiveUtils.dpToPx(size));
        return layerDrawable;
    }

    public final void p(@NotNull Context context, @NotNull MetaMaterial material, boolean ignoreContextExtras, int requestCode, @Nullable List<? extends LocalMediaInfo> alreadySelectedMedia) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(material, "material");
        if (com.tencent.mobileqq.wink.editor.c.Z0(material)) {
            Intent a16 = WinkAIAvatarCoupleMediaPickerFragment.INSTANCE.a(context, material, ignoreContextExtras, requestCode, alreadySelectedMedia);
            if (context instanceof Activity) {
                CompatPublicActivity.startForResult((Activity) context, a16, (Class<? extends CompatPublicFragment>) WinkAIAvatarCoupleMediaPickerFragment.class, requestCode);
                return;
            }
            return;
        }
        Intent a17 = WinkAIAvatarSingleMediaPickerFragment.INSTANCE.a(context, material, ignoreContextExtras, requestCode);
        if (context instanceof Activity) {
            CompatPublicActivity.startForResult((Activity) context, a17, (Class<? extends CompatPublicFragment>) WinkAIAvatarSingleMediaPickerFragment.class, requestCode);
        }
    }

    public final void r(@NotNull Context context, @NotNull MetaMaterial material, @NotNull String comeFrom) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        s(context, material, null, comeFrom);
    }

    public final <T extends View> void s(@NotNull Context context, @NotNull MetaMaterial material, @Nullable T[] shareView, @NotNull String comeFrom) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selected_style_material", material);
        bundle.putString("come_from", comeFrom);
        intent.putExtras(bundle);
        com.tencent.mobileqq.wink.f.r(context, intent, shareView);
    }

    public final void u(boolean ignoreCache, @NotNull Function1<? super List<MetaCategory>, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!ignoreCache) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkAIAvatarUtils$requestAIAvatarMaterials$1(responseCallback, null), 3, null);
        }
        v(responseCallback);
    }

    public final void w(@NotNull String materialID, @NotNull String categoryID, @NotNull Function3<? super Boolean, ? super Long, ? super List<MetaMaterial>, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Intrinsics.checkNotNullParameter(categoryID, "categoryID");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        w93.e.f445096a.f(new WinkGetRecommendMaterialByIdReq("AiAvatar", materialID, categoryID), new b(responseCallback));
    }

    public final void x(@Nullable MetaCategory imageGuideCategory) {
        List<MetaMaterial> emptyList;
        imagePickGuideInfoList = new ArrayList();
        if (imageGuideCategory == null || (emptyList = imageGuideCategory.materials) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        for (MetaMaterial material : emptyList) {
            Intrinsics.checkNotNullExpressionValue(material, "material");
            w53.b.a("WinkAIAvatarUtils", "setImgPickGuideInfo set from material: " + com.tencent.mobileqq.wink.editor.c.N0(material));
            try {
                Result.Companion companion = Result.INSTANCE;
                ImagePickGuideWrapper wrapper = (ImagePickGuideWrapper) new Gson().fromJson(com.tencent.mobileqq.wink.editor.c.N0(material), ImagePickGuideWrapper.class);
                String str = material.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "material.id");
                wrapper.c(str);
                w53.b.a("WinkAIAvatarUtils", "setImgPickGuideInfo materialGuide: " + wrapper.b());
                WinkAIAvatarUtils winkAIAvatarUtils = f317678a;
                Intrinsics.checkNotNullExpressionValue(wrapper, "wrapper");
                winkAIAvatarUtils.c(wrapper);
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
    }

    public final void y(@Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        latestGenerateBtnStatus = shadowAIGCStatus$GetStatusReply;
    }

    public final void z(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "recommend_group_id", value);
    }
}
