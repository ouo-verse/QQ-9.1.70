package com.tencent.paysdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.paysdk.api.IAuthTask;
import com.tencent.paysdk.api.VideoAuthCore;
import com.tencent.paysdk.core.JsDelegatorDecorator;
import com.tencent.paysdk.data.VideoInfo;
import com.tencent.paysdk.report.InternalReport;
import com.tencent.paysdk.vipauth.DefinitionAuthInternal;
import com.tencent.paysdk.vipauth.VideoPreAuthInternal;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0004:\u0001+B\u0013\u0012\b\u0010\u0085\u0001\u001a\u00030\u0083\u0001\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001e\u0010\u0019\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0002J\u001e\u0010\u001a\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0002J\u001e\u0010\u001b\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0002J\u001e\u0010\u001c\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\tH\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\tH\u0016J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\tH\u0016J\u001c\u0010/\u001a\u00020\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0-H\u0016J\b\u00100\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\u0010\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\tH\u0016R$\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00108R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010=R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010=R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010AR\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010DR0\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0Fj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010:R\u0016\u0010L\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010\u001aR\u0016\u0010N\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010\u001aR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010UR\u0014\u0010^\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u0014\u0010`\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010UR\u0014\u0010b\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010YR\u0018\u0010f\u001a\u00060cR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR$\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010:R\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010pR\u0016\u0010z\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010:R\u0018\u0010{\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010vR\u0018\u0010|\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010pR\u0016\u0010}\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010:R\u0018\u0010~\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010:R\u0018\u0010\u007f\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010vR\u001b\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001f\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b7\u0010\u0084\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/paysdk/api/VideoAuthCore;", "Lcom/tencent/paysdk/api/IAuthTask;", "Lmq3/a;", "Lcom/tencent/paysdk/vipauth/b;", "", "Lcom/tencent/paysdk/api/o;", "web", "Lcom/tencent/paysdk/api/l;", "jsDelegate", "", BdhLogUtil.LogTag.Tag_Conn, "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "L", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isContinue", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/paysdk/vipauth/e;", "Lcom/tencent/paysdk/vipauth/requestdata/BaseRequestData;", "Lcom/tencent/paysdk/vipauth/responsedata/VideoPreAuthResponse;", "resultInfo", "K", "J", "I", BdhLogUtil.LogTag.Tag_Req, "O", "H", UserInfo.SEX_FEMALE, "M", "T", "N", "E", "Landroid/content/Context;", "D", "P", "Lcom/tencent/paysdk/api/IAuthTask$a;", "iVideoAuth", "d", "g", "a", QCircleLpReportDc05507.KEY_CLEAR, "", "map", "f", "b", "", "c", "e", "i", "isInternalLogin", tl.h.F, "G", "Lcom/tencent/paysdk/vipauth/e;", "authInfo", "Ljava/lang/String;", "mAuthJsonInfo", "Lcom/tencent/paysdk/vipauth/VideoPreAuthInternal;", "Lcom/tencent/paysdk/vipauth/VideoPreAuthInternal;", "mVodPreAuthInternal", "mLivePreAuthInternal", "Lcom/tencent/paysdk/vipauth/DefinitionAuthInternal;", "Lcom/tencent/paysdk/vipauth/DefinitionAuthInternal;", "mVodDefinitionAuthInternal", "mLiveDefinitionAuthInternal", "Lcom/tencent/paysdk/api/IAuthTask$a;", "mIVideoAuthCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mSourceParams", "mUUID", "j", "mTryPlayEndTime", "k", "mH5CreatedTime", "Lcom/tencent/paysdk/api/IAuthTask$AuthType;", "l", "Lcom/tencent/paysdk/api/IAuthTask$AuthType;", "mAuthType", "Lcom/tencent/paysdk/core/JsDelegatorDecorator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/paysdk/core/JsDelegatorDecorator;", "toastJsDelegate", "Lcom/tencent/paysdk/api/q;", DomainData.DOMAIN_NAME, "Lcom/tencent/paysdk/api/q;", "toastWebViewLifecycle", "o", "payButtonJsDelegate", "p", "payButtonWebViewLifecycle", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "payPanelJsDelegate", "r", "payPanelWebViewLifecycle", "Lcom/tencent/paysdk/api/VideoAuthCore$a;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/paysdk/api/VideoAuthCore$a;", WadlProxyConsts.FLAGS, "Lcom/tencent/paysdk/vipauth/a;", "t", "Lcom/tencent/paysdk/vipauth/a;", "mPayVipAuthBaseListener", "Lcom/tencent/paysdk/api/r;", "u", "Lcom/tencent/paysdk/api/r;", "videoPayListener", "v", "Lcom/tencent/paysdk/api/o;", "mTopBuyBtnWeb", "w", "mTopBuyBtnWebUrl", "Lmq3/c;", HippyTKDListViewAdapter.X, "Lmq3/c;", "mTopBuyBtnJsbHandler", "y", "mPayPanelWeb", "mPayPanelWebUrl", "mPayPanelJsbHandler", "mToastWeb", "mToastWebUrl", "mAudioTipsUrl", "mToastJsbHandler", "Lcom/tencent/paysdk/api/b;", "Lcom/tencent/paysdk/api/b;", "mAudioTipsHelper", "Lcom/tencent/paysdk/api/c;", "Lcom/tencent/paysdk/api/c;", "provider", "<init>", "(Lcom/tencent/paysdk/api/c;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class VideoAuthCore implements IAuthTask, mq3.a, com.tencent.paysdk.vipauth.b {
    static IPatchRedirector $redirector_;

    /* renamed from: A, reason: from kotlin metadata */
    private mq3.c mPayPanelJsbHandler;

    /* renamed from: B, reason: from kotlin metadata */
    private o mToastWeb;

    /* renamed from: C, reason: from kotlin metadata */
    private String mToastWebUrl;

    /* renamed from: D, reason: from kotlin metadata */
    private String mAudioTipsUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private mq3.c mToastJsbHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.paysdk.api.b mAudioTipsHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private final c provider;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> authInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mAuthJsonInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final VideoPreAuthInternal mVodPreAuthInternal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final VideoPreAuthInternal mLivePreAuthInternal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final DefinitionAuthInternal mVodDefinitionAuthInternal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final DefinitionAuthInternal mLiveDefinitionAuthInternal;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private IAuthTask.a mIVideoAuthCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, String> mSourceParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mUUID;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long mTryPlayEndTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long mH5CreatedTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private IAuthTask.AuthType mAuthType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final JsDelegatorDecorator toastJsDelegate;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final q toastWebViewLifecycle;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final JsDelegatorDecorator payButtonJsDelegate;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final q payButtonWebViewLifecycle;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final JsDelegatorDecorator payPanelJsDelegate;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final q payPanelWebViewLifecycle;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final a flags;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private com.tencent.paysdk.vipauth.a<BaseRequestData, VideoPreAuthResponse> mPayVipAuthBaseListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final r videoPayListener;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private o mTopBuyBtnWeb;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private String mTopBuyBtnWebUrl;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private mq3.c mTopBuyBtnJsbHandler;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private o mPayPanelWeb;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String mPayPanelWebUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b!\u0010\u000eR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b#\u0010\u000eR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010-\u001a\u0004\b\u0014\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/paysdk/api/VideoAuthCore$a;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "a", "c", "b", "k", "l", "Z", "isPayButtonLoadFinish", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "i", ReportConstant.COSTREPORT_PREFIX, "isPayPanelLoadFinish", "isToastLoadFinish", "u", "d", "isToastDismiss", "t", "e", "isPayPanelGone", "r", "f", "setEnableManualLoadH5", "enableManualLoadH5", "g", tl.h.F, "setOnH5Loaded", "onH5Loaded", "p", "hasTryPlay", "o", "finishTryPlay", "j", "setTvkPlayerShowing", "isTvkPlayerShowing", "isTvkPlayerPendingReplay", "v", "isTvkPlayerPendingReplayContinue", "w", "", "I", "()I", DomainData.DOMAIN_NAME, "(I)V", "authResult", "<init>", "(Lcom/tencent/paysdk/api/VideoAuthCore;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isPayButtonLoadFinish;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isPayPanelLoadFinish;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isToastLoadFinish;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isToastDismiss;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isPayPanelGone;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean enableManualLoadH5;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean onH5Loaded;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean hasTryPlay;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean finishTryPlay;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean isTvkPlayerShowing;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean isTvkPlayerPendingReplay;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private boolean isTvkPlayerPendingReplayContinue;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int authResult;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, (Object) VideoAuthCore.this);
            } else {
                this.isPayPanelGone = true;
                this.isTvkPlayerShowing = true;
            }
        }

        private final void m() {
            this.hasTryPlay = false;
            this.finishTryPlay = false;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            if (this.isPayButtonLoadFinish && this.isToastDismiss) {
                return true;
            }
            return false;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
            }
            if (this.enableManualLoadH5 && !this.onH5Loaded) {
                return false;
            }
            return true;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            if (this.isToastLoadFinish && this.isPayPanelGone) {
                return true;
            }
            return false;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
            }
            return this.authResult;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            return this.enableManualLoadH5;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
            }
            return this.finishTryPlay;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
            }
            return this.hasTryPlay;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
            }
            return this.onH5Loaded;
        }

        public final boolean i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isPayPanelLoadFinish;
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
            }
            return this.isTvkPlayerShowing;
        }

        public final void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this);
                return;
            }
            this.isPayButtonLoadFinish = false;
            this.isToastDismiss = false;
            this.isToastLoadFinish = false;
            this.isPayPanelGone = true;
            this.isPayPanelLoadFinish = false;
            m();
            this.isTvkPlayerShowing = true;
            l();
            this.onH5Loaded = false;
        }

        public final void l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this);
            } else {
                this.isTvkPlayerPendingReplay = false;
                this.isTvkPlayerPendingReplayContinue = false;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, i3);
            } else {
                this.authResult = i3;
            }
        }

        public final void o(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, z16);
            } else {
                this.finishTryPlay = z16;
            }
        }

        public final void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, z16);
            } else {
                this.hasTryPlay = z16;
            }
        }

        public final void q(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.isPayButtonLoadFinish = z16;
            }
        }

        public final void r(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, z16);
            } else {
                this.isPayPanelGone = z16;
            }
        }

        public final void s(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.isPayPanelLoadFinish = z16;
            }
        }

        public final void t(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, z16);
            } else {
                this.isToastDismiss = z16;
            }
        }

        public final void u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.isToastLoadFinish = z16;
            }
        }

        public final void v(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, z16);
            } else {
                this.isTvkPlayerPendingReplay = z16;
            }
        }

        public final void w(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                iPatchRedirector.redirect((short) 28, (Object) this, z16);
            } else {
                this.isTvkPlayerPendingReplayContinue = z16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"", "errCode", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "", "Jd", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    static final class b implements r {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
            }
        }

        @Override // com.tencent.paysdk.api.r
        public final void Jd(int i3, String str, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4);
            } else if (i3 == 0) {
                VideoAuthCore.this.S(true);
            }
        }
    }

    public VideoAuthCore(@NotNull c provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) provider);
            return;
        }
        this.provider = provider;
        this.mAuthJsonInfo = "";
        this.mVodPreAuthInternal = new com.tencent.paysdk.vipauth.g(provider);
        this.mLivePreAuthInternal = new com.tencent.paysdk.vipauth.d(provider);
        this.mVodDefinitionAuthInternal = new com.tencent.paysdk.vipauth.f(provider);
        this.mLiveDefinitionAuthInternal = new com.tencent.paysdk.vipauth.c(provider);
        this.mSourceParams = new HashMap<>();
        this.mAuthType = IAuthTask.AuthType.TYPE_VOD;
        JsDelegatorDecorator jsDelegatorDecorator = new JsDelegatorDecorator(provider.d().c(), new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$toastJsDelegate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoAuthCore.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                aVar = VideoAuthCore.this.flags;
                aVar.t(true);
                VideoAuthCore.this.M();
            }
        }, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$toastJsDelegate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoAuthCore.a aVar;
                VideoAuthCore.a aVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                aVar = VideoAuthCore.this.flags;
                aVar.t(false);
                aVar2 = VideoAuthCore.this.flags;
                aVar2.u(true);
                VideoAuthCore.this.O();
            }
        }, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$toastJsDelegate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    VideoAuthCore.this.H();
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }
        });
        this.toastJsDelegate = jsDelegatorDecorator;
        this.toastWebViewLifecycle = jsDelegatorDecorator.g();
        JsDelegatorDecorator jsDelegatorDecorator2 = new JsDelegatorDecorator(provider.d().f(), null, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$payButtonJsDelegate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoAuthCore.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                aVar = VideoAuthCore.this.flags;
                aVar.q(true);
                VideoAuthCore.this.M();
            }
        }, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$payButtonJsDelegate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    VideoAuthCore.this.F();
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }
        }, 2, null);
        this.payButtonJsDelegate = jsDelegatorDecorator2;
        this.payButtonWebViewLifecycle = jsDelegatorDecorator2.g();
        JsDelegatorDecorator jsDelegatorDecorator3 = new JsDelegatorDecorator(provider.d().b(), new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$payPanelJsDelegate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoAuthCore.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    aVar = VideoAuthCore.this.flags;
                    aVar.r(true);
                }
            }
        }, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$payPanelJsDelegate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoAuthCore.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                aVar = VideoAuthCore.this.flags;
                aVar.s(true);
                com.tencent.paysdk.log.c.b("VideoAuthCore", VideoAuthCore.this + ":on load finish, try show pay panel");
                VideoAuthCore.this.T();
            }
        }, new Function0<Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$payPanelJsDelegate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    VideoAuthCore.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }
        });
        this.payPanelJsDelegate = jsDelegatorDecorator3;
        this.payPanelWebViewLifecycle = jsDelegatorDecorator3.g();
        this.flags = new a();
        com.tencent.paysdk.util.e.b(this);
        provider.c().d();
        this.mPayVipAuthBaseListener = new VideoAuthCore$mPayVipAuthBaseListener$1(this);
        this.videoPayListener = new b();
        this.mTopBuyBtnWebUrl = "";
        this.mPayPanelWebUrl = "";
        this.mToastWebUrl = "";
    }

    private final void A() {
        if (this.mAudioTipsHelper == null) {
            this.mAudioTipsHelper = com.tencent.paysdk.audio.a.INSTANCE.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.mAuthType != IAuthTask.AuthType.TYPE_AUDIO) {
            return;
        }
        A();
        com.tencent.paysdk.api.b bVar = this.mAudioTipsHelper;
        if (bVar != null) {
            bVar.b(this.mAudioTipsUrl);
        }
        com.tencent.paysdk.api.b bVar2 = this.mAudioTipsHelper;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    private final void C(o web, l jsDelegate) {
        if (web != null) {
            web.clear();
            mq3.c m3 = web.m();
            if (m3 != null) {
                m3.onDestroy();
            }
            ViewParent parent = web.k().getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(web.k());
            }
        }
    }

    private final Context D() {
        Context context = this.provider.d().e().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "provider.getHostViewProv\u2026yPanelContainer().context");
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        F();
        G();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        View k3;
        o oVar = this.mTopBuyBtnWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(8);
        }
        this.payButtonWebViewLifecycle.onHide();
        if (this.mUUID != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("module", "\u53f3\u4e0a\u89d2\u6309\u94ae");
            hashMap.put("url", this.mTopBuyBtnWebUrl);
            String str = this.mUUID;
            Intrinsics.checkNotNull(str);
            hashMap.put(ServiceConst.PARA_SESSION_ID, str);
            hashMap.put("msg", "\u9690\u85cf");
            hashMap.put("vid", this.provider.c().c().n());
            hashMap.put("cid", this.provider.c().c().b());
            InternalReport.INSTANCE.g(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        View k3;
        o oVar = this.mToastWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(8);
        }
        this.flags.t(true);
        this.toastWebViewLifecycle.onHide();
        if (this.mUUID != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("module", "Toast");
            hashMap.put("url", this.mToastWebUrl);
            String str = this.mUUID;
            Intrinsics.checkNotNull(str);
            hashMap.put(ServiceConst.PARA_SESSION_ID, str);
            hashMap.put("msg", "\u9690\u85cf");
            hashMap.put("vid", this.provider.c().c().n());
            hashMap.put("cid", this.provider.c().c().b());
            InternalReport.INSTANCE.g(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        String str;
        ViewParent viewParent;
        View view;
        View k3;
        String str2;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        View k16;
        VideoPreAuthResponse a17;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean2;
        View view2 = null;
        if (resultInfo != null && (a17 = resultInfo.a()) != null && (playerPayViewMergeInfoBean2 = a17.getPlayerPayViewMergeInfoBean()) != null) {
            str = playerPayViewMergeInfoBean2.getTopbarPaybuttonUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.paysdk.log.c.a("VideoAuthCore", "pay button url is empty");
            F();
            return;
        }
        this.mH5CreatedTime = System.currentTimeMillis();
        ViewGroup a18 = this.provider.d().a();
        Context context = a18.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "payButtonContainer.context");
        o k17 = com.tencent.paysdk.a.k(context);
        C(this.mTopBuyBtnWeb, this.payButtonJsDelegate);
        this.payButtonWebViewLifecycle.onCreate();
        this.mTopBuyBtnWeb = k17;
        if (k17 != null && (k16 = k17.k()) != null) {
            k16.setId(R.id.f94105bd);
        }
        this.mTopBuyBtnJsbHandler = new com.tencent.paysdk.jsbridge.d(D(), this.mTopBuyBtnWeb, this.provider, this, this.payButtonJsDelegate);
        mq3.c cVar = this.mToastJsbHandler;
        if (!(cVar instanceof com.tencent.paysdk.jsbridge.d)) {
            cVar = null;
        }
        com.tencent.paysdk.jsbridge.d dVar = (com.tencent.paysdk.jsbridge.d) cVar;
        if (dVar != null) {
            dVar.e(new Function1<Boolean, Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$loadPayButton$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        VideoAuthCore.this.S(z16);
                    } else {
                        iPatchRedirector.redirect((short) 1, (Object) this, z16);
                    }
                }
            });
        }
        o oVar = this.mTopBuyBtnWeb;
        if (oVar != null) {
            oVar.setJsbridgeHandler(this.mTopBuyBtnJsbHandler);
        }
        o oVar2 = this.mTopBuyBtnWeb;
        if (oVar2 != null) {
            oVar2.setBgTransparent();
        }
        F();
        o oVar3 = this.mTopBuyBtnWeb;
        if (oVar3 != null) {
            if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
                str2 = playerPayViewMergeInfoBean.getTopbarPaybuttonUrl();
            } else {
                str2 = null;
            }
            oVar3.loadUrl(z(str2), null);
        }
        this.payButtonWebViewLifecycle.h();
        o oVar4 = this.mTopBuyBtnWeb;
        if (oVar4 != null && (k3 = oVar4.k()) != null) {
            viewParent = k3.getParent();
        } else {
            viewParent = null;
        }
        if (!(viewParent instanceof ViewGroup)) {
            viewParent = null;
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        if (viewGroup != null) {
            o oVar5 = this.mTopBuyBtnWeb;
            if (oVar5 != null) {
                view = oVar5.k();
            } else {
                view = null;
            }
            viewGroup.removeView(view);
        }
        o oVar6 = this.mTopBuyBtnWeb;
        if (oVar6 != null) {
            if (oVar6 != null) {
                view2 = oVar6.k();
            }
            a18.addView(view2);
            this.payButtonWebViewLifecycle.onAttach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        String str;
        ViewParent viewParent;
        View view;
        View k3;
        View k16;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        View view2 = null;
        if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
            str = playerPayViewMergeInfoBean.getPlayerPayviewUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.paysdk.log.c.a("VideoAuthCore", "pay panel url is empty");
            G();
            return;
        }
        ViewGroup e16 = this.provider.d().e();
        Context context = e16.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "payPanelContainer.context");
        o k17 = com.tencent.paysdk.a.k(context);
        C(this.mPayPanelWeb, this.payPanelJsDelegate);
        this.payPanelWebViewLifecycle.onCreate();
        this.mPayPanelWeb = k17;
        if (k17 != null && (k16 = k17.k()) != null) {
            k16.setId(R.id.f94075ba);
        }
        this.mPayPanelJsbHandler = new com.tencent.paysdk.jsbridge.d(D(), this.mPayPanelWeb, this.provider, this, this.payPanelJsDelegate);
        mq3.c cVar = this.mToastJsbHandler;
        if (!(cVar instanceof com.tencent.paysdk.jsbridge.d)) {
            cVar = null;
        }
        com.tencent.paysdk.jsbridge.d dVar = (com.tencent.paysdk.jsbridge.d) cVar;
        if (dVar != null) {
            dVar.e(new Function1<Boolean, Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$loadPayPanel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        VideoAuthCore.this.S(z16);
                    } else {
                        iPatchRedirector.redirect((short) 1, (Object) this, z16);
                    }
                }
            });
        }
        o oVar = this.mPayPanelWeb;
        if (oVar != null) {
            oVar.setJsbridgeHandler(this.mPayPanelJsbHandler);
        }
        o oVar2 = this.mPayPanelWeb;
        if (oVar2 != null) {
            oVar2.setBgTransparent();
        }
        G();
        o oVar3 = this.mPayPanelWeb;
        if (oVar3 != null) {
            oVar3.loadUrl(z(str), null);
        }
        this.payPanelWebViewLifecycle.h();
        o oVar4 = this.mPayPanelWeb;
        if (oVar4 != null) {
            if (oVar4 != null && (k3 = oVar4.k()) != null) {
                viewParent = k3.getParent();
            } else {
                viewParent = null;
            }
            if (!(viewParent instanceof ViewGroup)) {
                viewParent = null;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent;
            if (viewGroup != null) {
                o oVar5 = this.mPayPanelWeb;
                if (oVar5 != null) {
                    view = oVar5.k();
                } else {
                    view = null;
                }
                viewGroup.removeView(view);
            }
        }
        o oVar6 = this.mPayPanelWeb;
        if (oVar6 != null) {
            view2 = oVar6.k();
        }
        e16.addView(view2);
        this.payPanelWebViewLifecycle.onAttach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        String toastUrl;
        boolean z16;
        ViewParent viewParent;
        View view;
        View k3;
        View k16;
        if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null && (toastUrl = playerPayViewMergeInfoBean.getToastUrl()) != null) {
            if (toastUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.paysdk.log.c.a("VideoAuthCore", "toast url is empty");
                H();
                M();
                return;
            }
            if (!this.flags.b()) {
                return;
            }
            ViewGroup d16 = this.provider.d().d();
            Context context = d16.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "toastContainer.context");
            o k17 = com.tencent.paysdk.a.k(context);
            C(this.mToastWeb, this.toastJsDelegate);
            this.toastWebViewLifecycle.onCreate();
            this.mToastWeb = k17;
            if (k17 != null && (k16 = k17.k()) != null) {
                k16.setId(R.id.f94095bc);
            }
            com.tencent.paysdk.jsbridge.d dVar = new com.tencent.paysdk.jsbridge.d(D(), this.mToastWeb, this.provider, this, this.toastJsDelegate);
            this.mToastJsbHandler = dVar;
            View view2 = null;
            if (!(dVar instanceof com.tencent.paysdk.jsbridge.d)) {
                dVar = null;
            }
            if (dVar != null) {
                dVar.e(new Function1<Boolean, Unit>() { // from class: com.tencent.paysdk.api.VideoAuthCore$loadToast$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) VideoAuthCore.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                            VideoAuthCore.this.S(z17);
                        } else {
                            iPatchRedirector.redirect((short) 1, (Object) this, z17);
                        }
                    }
                });
            }
            o oVar = this.mToastWeb;
            if (oVar != null) {
                oVar.setJsbridgeHandler(this.mToastJsbHandler);
            }
            o oVar2 = this.mToastWeb;
            if (oVar2 != null) {
                oVar2.setBgTransparent();
            }
            H();
            this.flags.t(false);
            o oVar3 = this.mToastWeb;
            if (oVar3 != null) {
                oVar3.loadUrl(z(toastUrl), null);
            }
            this.toastWebViewLifecycle.h();
            o oVar4 = this.mToastWeb;
            if (oVar4 != null) {
                if (oVar4 != null && (k3 = oVar4.k()) != null) {
                    viewParent = k3.getParent();
                } else {
                    viewParent = null;
                }
                if (!(viewParent instanceof ViewGroup)) {
                    viewParent = null;
                }
                ViewGroup viewGroup = (ViewGroup) viewParent;
                if (viewGroup != null) {
                    o oVar5 = this.mToastWeb;
                    if (oVar5 != null) {
                        view = oVar5.k();
                    } else {
                        view = null;
                    }
                    viewGroup.removeView(view);
                }
            }
            o oVar6 = this.mToastWeb;
            if (oVar6 != null) {
                view2 = oVar6.k();
            }
            d16.addView(view2);
            this.toastWebViewLifecycle.onAttach();
        }
    }

    private final void L() {
        E();
        this.flags.k();
        this.mAuthJsonInfo = "";
        this.authInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        View k3;
        if (!this.flags.a()) {
            return;
        }
        o oVar = this.mTopBuyBtnWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(0);
        }
        this.payButtonWebViewLifecycle.onShow();
        mq3.c cVar = this.mTopBuyBtnJsbHandler;
        if (cVar != null) {
            cVar.a();
        }
        if (this.mUUID != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("module", "\u53f3\u4e0a\u89d2\u6309\u94ae");
            hashMap.put("url", this.mTopBuyBtnWebUrl);
            String str = this.mUUID;
            Intrinsics.checkNotNull(str);
            hashMap.put(ServiceConst.PARA_SESSION_ID, str);
            hashMap.put("msg", "\u663e\u793a");
            hashMap.put("vid", this.provider.c().c().n());
            hashMap.put("cid", this.provider.c().c().b());
            InternalReport.INSTANCE.g(hashMap);
        }
    }

    private final void N() {
        View k3;
        o oVar = this.mPayPanelWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(0);
        }
        this.flags.r(false);
        this.payPanelWebViewLifecycle.onShow();
        mq3.c cVar = this.mPayPanelJsbHandler;
        if (cVar != null) {
            cVar.a();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module", "\u4ed8\u8d39\u9762\u677f");
        hashMap.put("url", this.mPayPanelWebUrl);
        String str = this.mUUID;
        Intrinsics.checkNotNull(str);
        hashMap.put(ServiceConst.PARA_SESSION_ID, str);
        hashMap.put("msg", "\u663e\u793a");
        hashMap.put("vid", this.provider.c().c().n());
        hashMap.put("cid", this.provider.c().c().b());
        InternalReport.INSTANCE.g(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        View k3;
        if (!this.flags.c()) {
            return;
        }
        o oVar = this.mToastWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(0);
        }
        this.toastWebViewLifecycle.onShow();
        mq3.c cVar = this.mToastJsbHandler;
        if (cVar != null) {
            cVar.a();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module", "Toast");
        hashMap.put("url", this.mToastWebUrl);
        String str = this.mUUID;
        Intrinsics.checkNotNull(str);
        hashMap.put(ServiceConst.PARA_SESSION_ID, str);
        hashMap.put("msg", "\u663e\u793a");
        hashMap.put("vid", this.provider.c().c().n());
        hashMap.put("cid", this.provider.c().c().b());
        InternalReport.INSTANCE.g(hashMap);
    }

    private final void Q() {
        this.mUUID = UUID.randomUUID().toString();
        if (VideoInfo.PlayerType.VOD == this.provider.c().c().e()) {
            com.tencent.paysdk.log.c.a("VideoAuthCore", "startVideoAuthInternal() VideoInfo.PlayerType:" + this.provider.c().c().e());
            this.mVodPreAuthInternal.e(this.mUUID);
            this.mVodPreAuthInternal.c(this.mPayVipAuthBaseListener);
        } else if (VideoInfo.PlayerType.LIVE == this.provider.c().c().e()) {
            com.tencent.paysdk.log.c.a("VideoAuthCore", "startVideoAuthInternal() VideoInfo.PlayerType:" + this.provider.c().c().e());
            this.mLivePreAuthInternal.e(this.mUUID);
            this.mLivePreAuthInternal.c(this.mPayVipAuthBaseListener);
        } else {
            com.tencent.paysdk.log.c.a("VideoAuthCore", "startVideoAuthInternal() VideoInfo.PlayerType not set!!");
        }
        com.tencent.paysdk.util.f.b(this.videoPayListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        String str;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
            str = playerPayViewMergeInfoBean.getAudioUrl();
        } else {
            str = null;
        }
        this.mAudioTipsUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(boolean isContinue) {
        if (!this.flags.j()) {
            this.flags.v(true);
            this.flags.w(isContinue);
        } else {
            this.provider.c().b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        com.tencent.paysdk.log.c.b("VideoAuthCore", this + ":tryShowPayPanel, hasTryPlay: " + this.flags.g() + ", finishTryPlay:" + this.flags.f() + ", isPayPanelLoadFinish:" + this.flags.i());
        if ((!this.flags.g() || this.flags.f()) && this.flags.i()) {
            N();
            H();
            F();
            this.provider.c().pause();
            return;
        }
        com.tencent.paysdk.log.c.b("VideoAuthCore", this + ":tryShowPayPanel fail");
        G();
    }

    private final String z(String url) {
        boolean contains$default;
        if (url != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(url);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (!contains$default) {
                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            }
            for (Map.Entry<String, String> entry : this.mSourceParams.entrySet()) {
                String str = entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(str);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "urlBuilder.toString()");
            return sb6;
        }
        return "";
    }

    public void G() {
        View k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        o oVar = this.mPayPanelWeb;
        if (oVar != null && (k3 = oVar.k()) != null) {
            k3.setVisibility(8);
        }
        this.payPanelWebViewLifecycle.onHide();
        if (this.mUUID != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("module", "\u4ed8\u8d39\u9762\u677f");
            hashMap.put("url", this.mPayPanelWebUrl);
            String str = this.mUUID;
            Intrinsics.checkNotNull(str);
            hashMap.put(ServiceConst.PARA_SESSION_ID, str);
            hashMap.put("msg", "\u9690\u85cf");
            hashMap.put("vid", this.provider.c().c().n());
            hashMap.put("cid", this.provider.c().c().b());
            InternalReport.INSTANCE.g(hashMap);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.paysdk.api.IAuthTask
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.paysdk.log.c.b("VideoAuthCore", "startTryPlay()");
        this.flags.p(true);
        this.flags.o(false);
        G();
    }

    @Override // com.tencent.paysdk.vipauth.b
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mAuthJsonInfo;
    }

    @Override // com.tencent.paysdk.vipauth.b
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.mH5CreatedTime;
    }

    @Override // com.tencent.paysdk.api.IAuthTask
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.toastWebViewLifecycle.a();
        this.payButtonWebViewLifecycle.a();
        this.payPanelWebViewLifecycle.a();
        C(this.mPayPanelWeb, this.payPanelJsDelegate);
        C(this.mTopBuyBtnWeb, this.payButtonJsDelegate);
        C(this.mToastWeb, this.toastJsDelegate);
        com.tencent.paysdk.util.f.c(this.videoPayListener);
        com.tencent.paysdk.util.e.c(this);
    }

    @Override // com.tencent.paysdk.api.IAuthTask
    public void d(@Nullable IAuthTask.a iVideoAuth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVideoAuth);
            return;
        }
        this.mIVideoAuthCallback = iVideoAuth;
        P();
        L();
        Q();
    }

    @Override // com.tencent.paysdk.vipauth.b
    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.mTryPlayEndTime;
    }

    @Override // com.tencent.paysdk.api.IAuthTask
    public void f(@NotNull Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) map);
            return;
        }
        Intrinsics.checkNotNullParameter(map, "map");
        this.mSourceParams.clear();
        this.mSourceParams.putAll(map);
    }

    @Override // com.tencent.paysdk.api.IAuthTask
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int d16 = this.flags.d();
        com.tencent.paysdk.log.c.b("VideoAuthCore", "finishTryPlay() current auth result=" + d16);
        this.mTryPlayEndTime = System.currentTimeMillis();
        this.flags.o(true);
        T();
        if (d16 == 2) {
            com.tencent.paysdk.log.c.b("VideoAuthCore", "finishTryPlay after auth need pay, check play audio tips");
            B();
        } else {
            com.tencent.paysdk.log.c.b("VideoAuthCore", "finishTryPlay before auth need pay, wait for auth result");
        }
    }

    @Override // mq3.a
    public void h(boolean isInternalLogin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isInternalLogin);
        } else if (isInternalLogin) {
            S(true);
        }
    }

    @Override // com.tencent.paysdk.vipauth.b
    @NotNull
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        String str = this.mUUID;
        Intrinsics.checkNotNull(str);
        return str;
    }
}
