package com.tencent.mobileqq.vas.pay.newcustomer;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$GetExperienceSvipInfoRsp;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$MonthInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$PayInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$ReceiveExperienceSvipRsp;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Service;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Tianxuan;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.AppSetting;
import com.tencent.util.URLUtil;
import e23.MonthlyPayData;
import i23.ExperienceExpiredCountDown;
import i23.PayListTop;
import i23.PayUserInfoText;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0099\u00012\u00020\u0001:\u00058\u009a\u0001\u009b\u0001B\t\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J$\u0010 \u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002J\u0012\u0010#\u001a\u00020\u000b2\b\b\u0001\u0010\"\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\u0014\u0010/\u001a\u00020\u000b2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\u0018\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\tH\u0002J\u000e\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020$J\u0006\u00106\u001a\u00020\u000bJ\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u000200H\u0016J\u0006\u0010;\u001a\u00020\tJ\u0006\u0010<\u001a\u00020\u000bJ\u0010\u0010=\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010>\u001a\u00020\u000bJ\u0010\u0010?\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\tJ\u0006\u0010B\u001a\u00020\u000bJ\u000e\u0010C\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020!J\u0006\u0010D\u001a\u00020\u000bJ\u0006\u0010E\u001a\u00020\u000bR\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00105R\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0016\u0010I\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00105R\u0018\u0010L\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR$\u0010V\u001a\u00020$2\u0006\u0010Q\u001a\u00020$8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020!0W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010SR\u0016\u0010^\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010SR\u0016\u0010`\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010SR\u0018\u0010c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001f\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020-8\u0006\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020i0-8\u0006\u00a2\u0006\f\n\u0004\bj\u0010e\u001a\u0004\bk\u0010gR\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020m0-8\u0006\u00a2\u0006\f\n\u0004\bn\u0010e\u001a\u0004\bo\u0010gR'\u0010s\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u000200\u0018\u00010W0-8\u0006\u00a2\u0006\f\n\u0004\bq\u0010e\u001a\u0004\br\u0010gR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020t0-8\u0006\u00a2\u0006\f\n\u0004\bu\u0010e\u001a\u0004\bv\u0010gR\u001f\u0010{\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010x0-8\u0006\u00a2\u0006\f\n\u0004\by\u0010e\u001a\u0004\bz\u0010gR\u001f\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010|0-8\u0006\u00a2\u0006\f\n\u0004\b}\u0010e\u001a\u0004\b~\u0010gR)\u0010\u0083\u0001\u001a\u0011\u0012\r\u0012\u000b \u0080\u0001*\u0004\u0018\u00010\t0\t0-8\u0006\u00a2\u0006\u000e\n\u0005\b\u0081\u0001\u0010e\u001a\u0005\b\u0082\u0001\u0010gR!\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010-8\u0006\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010e\u001a\u0005\b\u0086\u0001\u0010gR\u0019\u0010\u008a\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008e\u0001\u001a\t\u0018\u00010\u008b\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u0092\u0001\u001a\t\u0018\u00010\u008f\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R(\u0010\u0096\u0001\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010\u0003\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel;", "Lh23/b;", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "J", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "rsp", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", ExifInterface.LATITUDE_SOUTH, "result", "", "s0", "", "x0", "y0", "L", "z0", "", "autoReceiveDelaySec", "o0", "E", "w0", "expireTime", "isRequestNewData", "H", "D", "Lcom/tencent/qphone/base/util/BaseApplication;", "context", "K", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "monthInfo", "isFromRenewal", "q0", "", "stringRes", "t0", "", "text", "u0", "type", "code", "a0", "c0", "i0", "l0", "Landroidx/lifecycle/MutableLiveData;", "liveData", "e0", "Lh23/c;", "selectItem", "isDefaultSelect", UserInfo.SEX_FEMALE, "source", "Z", "p0", "G", "a", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "X", "W", "b0", "h0", "Y", "isClick", "f0", "k0", "n0", "A0", "d0", "isRelease", "isGetExperience", "c", "payBaoyue", "d", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", "lastPayBaoyueMonth", "Lcom/tencent/mobileqq/vas/pay/newcustomer/j;", "e", "Lcom/tencent/mobileqq/vas/pay/newcustomer/j;", "model", "<set-?>", "f", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "aid", "", "g", "Ljava/util/List;", "businessTypeList", tl.h.F, "policyId", "i", "hippyTrace", "j", "enteranceId", "k", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "lastRequestData", "l", "Landroidx/lifecycle/MutableLiveData;", "N", "()Landroidx/lifecycle/MutableLiveData;", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "Li23/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "V", "userInfoText", "Li23/d;", DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Req, "payListTop", "o", "O", VideoTemplateParser.ITEM_LIST, "Li23/c;", "p", "P", "payBtnStyle", "Li23/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "T", "selectedItem", "Li23/a;", "r", "M", "experienceExpiredCountDown", "kotlin.jvm.PlatformType", ReportConstant.COSTREPORT_PREFIX, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "payContentVisible", "Lh23/a;", "t", "U", "showSelectPayTypeDialog", "u", "I", "selectPayType", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$GetExperienceTask;", "v", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$GetExperienceTask;", "getExperienceTask", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$ExperienceExpiredCountDownTask;", "w", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$ExperienceExpiredCountDownTask;", "experienceExpiredCountDownTask", HippyTKDListViewAdapter.X, "getClickFlag", "()J", "clickFlag", "<init>", "()V", "y", "ExperienceExpiredCountDownTask", "GetExperienceTask", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipNewCustomerViewModel implements h23.b {

    /* renamed from: z, reason: collision with root package name */
    private static boolean f310230z;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isRelease;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isGetExperience;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean payBaoyue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExperienceSvipServerPB$MonthInfo lastPayBaoyueMonth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j model = new j();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String aid = "mvip.p.a.fc_spcc";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> businessTypeList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String policyId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String hippyTrace;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String enteranceId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExperienceSvipServerPB$GetExperienceSvipInfoRsp lastRequestData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<OpenHippyInfo> hippyInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PayUserInfoText> userInfoText;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PayListTop> payListTop;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<? extends h23.c>> itemList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<i23.c> payBtnStyle;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<i23.b> selectedItem;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ExperienceExpiredCountDown> experienceExpiredCountDown;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> payContentVisible;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<h23.a> showSelectPayTypeDialog;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int selectPayType;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GetExperienceTask getExperienceTask;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExperienceExpiredCountDownTask experienceExpiredCountDownTask;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long clickFlag;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$ExperienceExpiredCountDownTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "J", "expireTime", "<init>", "(Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel;J)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class ExperienceExpiredCountDownTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long expireTime;

        public ExperienceExpiredCountDownTask(long j3) {
            this.expireTime = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            QVipNewCustomerViewModel.this.H(this.expireTime, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$GetExperienceTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "J", "autoReceiveDelaySec", "<init>", "(Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel;J)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class GetExperienceTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long autoReceiveDelaySec;

        public GetExperienceTask(long j3) {
            this.autoReceiveDelaySec = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            QVipNewCustomerViewModel.this.o0(this.autoReceiveDelaySec);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$b", "Lh23/a;", "", "action", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements h23.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f310258b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExperienceSvipServerPB$MonthInfo f310259c;

        b(Activity activity, ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo) {
            this.f310258b = activity;
            this.f310259c = experienceSvipServerPB$MonthInfo;
        }

        @Override // h23.a
        public void action() {
            QVipNewCustomerViewModel.this.q0(this.f310258b, this.f310259c, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$c", "Lh23/d;", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$ReceiveExperienceSvipRsp;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements h23.d<ExperienceSvipServerPB$ReceiveExperienceSvipRsp> {
        c() {
        }

        @Override // h23.d
        public void a(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("QVipNewCustomerViewModel", 1, "failure");
            if (QVipNewCustomerViewModel.this.isRelease) {
                return;
            }
            BaseApplication baseApplication = BaseApplication.context;
            QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.f2172660j), 0).show();
        }

        @Override // h23.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull ExperienceSvipServerPB$ReceiveExperienceSvipRsp result, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            if (QVipNewCustomerViewModel.this.isRelease) {
                return;
            }
            QQToast.makeText(BaseApplication.context, 2, R.string.f2173560s, 0).show();
            QVipNewCustomerViewModel.this.i0();
            QVipNewCustomerViewModel.this.isGetExperience = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$d", "Lh23/d;", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "result", "", "isSuccess", "", "b", "", "data", "c", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements h23.d<ExperienceSvipServerPB$GetExperienceSvipInfoRsp> {
        d() {
        }

        private final void b(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result, boolean isSuccess) {
            com.tencent.mobileqq.vas.pay.newcustomer.c cVar = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
            cVar.h(result);
            BaseApplication context = BaseApplication.context;
            QVipNewCustomerViewModel.this.lastRequestData = result;
            if (isSuccess) {
                QVipNewCustomerViewModel qVipNewCustomerViewModel = QVipNewCustomerViewModel.this;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                qVipNewCustomerViewModel.K(result, context);
            } else {
                QVipNewCustomerViewModel.this.R().setValue(new PayListTop(a.INSTANCE.e(), ""));
            }
            QVipNewCustomerViewModel.this.z0(result);
            QVipNewCustomerViewModel.this.y0(result);
            QVipNewCustomerViewModel.this.L();
            QVipNewCustomerViewModel.this.x0(result);
            if (!QVipNewCustomerViewModel.this.s0(result)) {
                QVipNewCustomerViewModel.this.w0(result);
            } else {
                QVipNewCustomerViewModel.this.M().setValue(null);
            }
            cVar.g();
            if (AppSetting.isDebugVersion()) {
                boolean unused = QVipNewCustomerViewModel.this.isGetExperience;
            }
        }

        @Override // h23.d
        public void a(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("QVipNewCustomerViewModel", 1, "failure");
            if (QVipNewCustomerViewModel.this.isRelease) {
                return;
            }
            try {
                ExperienceSvipServerPB$GetExperienceSvipInfoRsp f16 = a.INSTANCE.f();
                if (f16 != null) {
                    b(f16, false);
                }
            } catch (Exception e16) {
                QLog.w("QVipNewCustomerViewModel", 1, "parse error", e16);
            }
        }

        @Override // h23.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull ExperienceSvipServerPB$GetExperienceSvipInfoRsp result, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("QVipNewCustomerViewModel", 1, "success");
            if (QVipNewCustomerViewModel.this.isRelease) {
                return;
            }
            b(result, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$e", "Lcom/tencent/mobileqq/vip/api/k;", "", "code", "", "a", "", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements com.tencent.mobileqq.vip.api.k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f310263b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f310264c;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Integer, Unit> function1, int i3) {
            this.f310263b = function1;
            this.f310264c = i3;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            QVipNewCustomerViewModel.this.c0();
            this.f310263b.invoke(1);
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QVipNewCustomerViewModel.this.a0(this.f310264c, code);
            QVipNewCustomerViewModel.this.t0(R.string.f2172760k);
            this.f310263b.invoke(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$f", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements com.tencent.mobileqq.vip.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExperienceSvipServerPB$MonthInfo f310266b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e23.c f310267c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f310268d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f310269e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f310270f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel$f$a", "Lh23/a;", "", "action", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements h23.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f310271a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e23.c f310272b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f310273c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QVipNewCustomerViewModel f310274d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f310275e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f310276f;

            a(String str, e23.c cVar, String str2, QVipNewCustomerViewModel qVipNewCustomerViewModel, String str3, String str4) {
                this.f310271a = str;
                this.f310272b = cVar;
                this.f310273c = str2;
                this.f310274d = qVipNewCustomerViewModel;
                this.f310275e = str3;
                this.f310276f = str4;
            }

            @Override // h23.a
            public void action() {
                int i3;
                String str;
                ExperienceSvipServerPB$MonthInfo monthInfo;
                PBInt32Field pBInt32Field;
                JSONObject jSONObject = new JSONObject(this.f310271a);
                String offerId = jSONObject.optString("app_id");
                String optString = jSONObject.optString("productid");
                String serviceType = jSONObject.optString("serviceType");
                int optInt = jSONObject.optInt("month");
                String reportData = jSONObject.optString("reportData");
                e23.c cVar = this.f310272b;
                Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                Intrinsics.checkNotNullExpressionValue(serviceType, "serviceType");
                String uin = this.f310273c;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                i23.b value = this.f310274d.T().getValue();
                if (value != null && (monthInfo = value.getMonthInfo()) != null && (pBInt32Field = monthInfo.month) != null) {
                    i3 = pBInt32Field.get();
                } else {
                    i3 = 0;
                }
                int i16 = i3;
                JSONObject jSONObject2 = new JSONObject();
                String str2 = this.f310276f;
                jSONObject2.put("apf", "2");
                jSONObject2.put("preorder_bill", str2);
                Unit unit = Unit.INSTANCE;
                String encode = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(JSONObject().appl\u2026   }.toString(), \"utf-8\")");
                String str3 = this.f310275e;
                String str4 = this.f310276f;
                if (optInt != 1) {
                    str = optInt + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
                cVar.a(new e23.a(offerId, serviceType, serviceType, uin, i16, encode, null, null, null, null, null, null, null, null, null, null, optString, str3, str4, str, null, reportData, 1114048, null), this.f310274d.selectPayType);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo, e23.c cVar, String str, Function1<? super Integer, Unit> function1, int i3) {
            this.f310266b = experienceSvipServerPB$MonthInfo;
            this.f310267c = cVar;
            this.f310268d = str;
            this.f310269e = function1;
            this.f310270f = i3;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            QVipNewCustomerViewModel.this.c0();
            this.f310269e.invoke(1);
        }

        @Override // com.tencent.mobileqq.vip.api.h
        public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
            Intrinsics.checkNotNullParameter(vipMa, "vipMa");
            Intrinsics.checkNotNullParameter(billno, "billno");
            Intrinsics.checkNotNullParameter(payStr, "payStr");
            QVipNewCustomerViewModel.this.payBaoyue = true;
            QVipNewCustomerViewModel.this.lastPayBaoyueMonth = this.f310266b;
            QVipNewCustomerViewModel.this.U().setValue(null);
            QVipNewCustomerViewModel.this.U().setValue(new a(payStr, this.f310267c, this.f310268d, QVipNewCustomerViewModel.this, vipMa, billno));
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QVipNewCustomerViewModel.this.a0(this.f310270f, code);
            if (code == -5001) {
                QVipNewCustomerViewModel.this.t0(R.string.f2172860l);
            } else if (code != -4017) {
                QVipNewCustomerViewModel.this.t0(R.string.f2172760k);
            } else {
                QVipNewCustomerViewModel.this.u0(com.tencent.mobileqq.vas.pay.newcustomer.a.INSTANCE.d());
            }
            this.f310269e.invoke(0);
        }
    }

    public QVipNewCustomerViewModel() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        this.businessTypeList = arrayList;
        this.policyId = "XLT10";
        this.hippyTrace = "";
        this.enteranceId = "";
        this.hippyInfo = new MutableLiveData<>();
        this.userInfoText = new MutableLiveData<>();
        this.payListTop = new MutableLiveData<>();
        this.itemList = new MutableLiveData<>();
        this.payBtnStyle = new MutableLiveData<>();
        this.selectedItem = new MutableLiveData<>();
        this.experienceExpiredCountDown = new MutableLiveData<>();
        this.payContentVisible = new MutableLiveData<>(Boolean.TRUE);
        this.showSelectPayTypeDialog = new MutableLiveData<>();
        this.clickFlag = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QVipNewCustomerViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k0();
        this$0.l0();
    }

    private final void D() {
        ExperienceExpiredCountDownTask experienceExpiredCountDownTask = this.experienceExpiredCountDownTask;
        if (experienceExpiredCountDownTask != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(experienceExpiredCountDownTask);
        }
        this.experienceExpiredCountDownTask = null;
    }

    private final void E() {
        GetExperienceTask getExperienceTask = this.getExperienceTask;
        if (getExperienceTask != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(getExperienceTask);
        }
        this.getExperienceTask = null;
    }

    private final void F(h23.c selectItem, boolean isDefaultSelect) {
        ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp;
        ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp2;
        List<? extends h23.c> value = this.itemList.getValue();
        if (value != null) {
            int i3 = 0;
            for (Object obj : value) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                h23.c cVar = (h23.c) obj;
                cVar.setSelected(Intrinsics.areEqual(selectItem, cVar));
                if (cVar.getIsSelected()) {
                    MutableLiveData<i23.b> mutableLiveData = this.selectedItem;
                    Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.vas.pay.newcustomer.bean.NewCustomerPreferentialItem");
                    mutableLiveData.setValue((i23.b) cVar);
                }
                i3 = i16;
            }
        }
        if (isDefaultSelect) {
            i23.b value2 = this.selectedItem.getValue();
            if (value2 != null && (experienceSvipServerPB$GetExperienceSvipInfoRsp2 = this.lastRequestData) != null) {
                com.tencent.mobileqq.vas.pay.newcustomer.c cVar2 = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
                ExperienceSvipServerPB$MonthInfo monthInfo = value2.getMonthInfo();
                ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo = experienceSvipServerPB$GetExperienceSvipInfoRsp2.pay_info.get();
                Intrinsics.checkNotNullExpressionValue(experienceSvipServerPB$PayInfo, "rsp.pay_info.get()");
                cVar2.k(monthInfo, experienceSvipServerPB$PayInfo);
                return;
            }
            return;
        }
        i23.b value3 = this.selectedItem.getValue();
        if (value3 != null && (experienceSvipServerPB$GetExperienceSvipInfoRsp = this.lastRequestData) != null) {
            com.tencent.mobileqq.vas.pay.newcustomer.c cVar3 = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
            ExperienceSvipServerPB$MonthInfo monthInfo2 = value3.getMonthInfo();
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo2 = experienceSvipServerPB$GetExperienceSvipInfoRsp.pay_info.get();
            Intrinsics.checkNotNullExpressionValue(experienceSvipServerPB$PayInfo2, "rsp.pay_info.get()");
            cVar3.m(monthInfo2, experienceSvipServerPB$PayInfo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H(long expireTime, boolean isRequestNewData) {
        long currentTimeMillis = expireTime - (System.currentTimeMillis() / 1000);
        QLog.i("QVipNewCustomerViewModel", 1, "createExperienceExpiredAndTryPostNext expireTime:" + expireTime + " diffTime:" + currentTimeMillis);
        if (currentTimeMillis > 0) {
            long j3 = 86400;
            int i3 = (int) (currentTimeMillis / j3);
            long j16 = currentTimeMillis % j3;
            long j17 = 60;
            int i16 = (int) (j16 % j17);
            long j18 = j16 / j17;
            int i17 = (int) (j18 % j17);
            int i18 = (int) ((j18 / j17) % 24);
            QLog.i("QVipNewCustomerViewModel", 1, "\u4f53\u9a8c\u5230\u671f\u5012\u8ba1\u65f6: D:" + i3 + " H:" + i18 + " M:" + i17 + " S:" + i16);
            this.experienceExpiredCountDown.setValue(new ExperienceExpiredCountDown(i3, i18, i17, i16));
            ExperienceExpiredCountDownTask experienceExpiredCountDownTask = new ExperienceExpiredCountDownTask(expireTime);
            ThreadManagerV2.getUIHandlerV2().postDelayed(experienceExpiredCountDownTask, 1000L);
            this.experienceExpiredCountDownTask = experienceExpiredCountDownTask;
            return true;
        }
        if (isRequestNewData) {
            i0();
            return false;
        }
        return false;
    }

    static /* synthetic */ boolean I(QVipNewCustomerViewModel qVipNewCustomerViewModel, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return qVipNewCustomerViewModel.H(j3, z16);
    }

    private final OpenHippyInfo J() {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        j.Companion companion = com.tencent.mobileqq.vas.pay.page.j.INSTANCE;
        openHippyInfo.bundleName = companion.j();
        openHippyInfo.domain = companion.i();
        openHippyInfo.processName = "main";
        openHippyInfo.isDisablePreload = true;
        openHippyInfo.from = "vas_pay";
        openHippyInfo.url = URLUtil.addParameter("page=experience", "traceDetail", this.hippyTrace);
        return openHippyInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result, BaseApplication context) {
        PayListTop payListTop;
        boolean z16 = result.experience_svip_info.is_experience_user.get();
        boolean z17 = result.experience_svip_info.is_new_user.get();
        MutableLiveData<PayListTop> mutableLiveData = this.payListTop;
        if (!z17 && !z16) {
            String string = context.getString(R.string.f2173860v);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ew_customer_svip_renewal)");
            String string2 = context.getString(R.string.f2173660t);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026q_distinguished_identity)");
            payListTop = new PayListTop(string, string2);
        } else {
            String string3 = context.getString(R.string.f2173760u);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026w_customer_svip_discount)");
            String string4 = context.getString(R.string.f2173460r);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026only_one_time_per_person)");
            payListTop = new PayListTop(string3, string4);
        }
        mutableLiveData.setValue(payListTop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        List<? extends h23.c> value = this.itemList.getValue();
        if (value != null) {
            if (!(!value.isEmpty())) {
                value = null;
            }
            if (value != null) {
                F(value.get(0), true);
            }
        }
    }

    private final ExperienceSvipServerPB$MonthInfo S(ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        int i3 = rsp.text_info.pay_index.get();
        List<ExperienceSvipServerPB$MonthInfo> list = rsp.pay_info.month_info.get();
        QLog.i("QVipNewCustomerViewModel", 1, "payRenewal payIndex: " + i3);
        for (ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo : list) {
            if (experienceSvipServerPB$MonthInfo.index.get() == i3) {
                return experienceSvipServerPB$MonthInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int type, int code) {
        QLog.e("QVipNewCustomerViewModel", 1, "pay error type: " + type + ", code: " + code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        f310230z = true;
        QQToast.makeText(BaseApplication.context, 2, "\u652f\u4ed8\u6210\u529f", 1).show();
        i0();
    }

    private final void e0(MutableLiveData<?> liveData) {
        Object value = liveData.getValue();
        if (value == 0) {
            return;
        }
        liveData.setValue(null);
        liveData.setValue(value);
    }

    public static /* synthetic */ void g0(QVipNewCustomerViewModel qVipNewCustomerViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qVipNewCustomerViewModel.f0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.ab
            @Override // java.lang.Runnable
            public final void run() {
                QVipNewCustomerViewModel.j0(QVipNewCustomerViewModel.this);
            }
        }, 16, null, false, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(QVipNewCustomerViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k0();
        this$0.l0();
    }

    private final void l0() {
        if (VasNormalToggle.VAS_PAY_PAGE_DELAY_REFRESH_PERSONAL.isEnable(true)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.ac
                @Override // java.lang.Runnable
                public final void run() {
                    QVipNewCustomerViewModel.m0(QVipNewCustomerViewModel.this);
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QVipNewCustomerViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e0(this$0.userInfoText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(long autoReceiveDelaySec) {
        QLog.i("QVipNewCustomerViewModel", 1, "startGetExperienceCountDown sec:" + autoReceiveDelaySec);
        if (autoReceiveDelaySec > 0) {
            PayUserInfoText value = this.userInfoText.getValue();
            if (value != null) {
                value.h(autoReceiveDelaySec);
            }
            e0(this.userInfoText);
            GetExperienceTask getExperienceTask = new GetExperienceTask(autoReceiveDelaySec - 1);
            ThreadManagerV2.getUIHandlerV2().postDelayed(getExperienceTask, 1000L);
            this.getExperienceTask = getExperienceTask;
            return;
        }
        f0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(Activity activity, final ExperienceSvipServerPB$MonthInfo monthInfo, final boolean isFromRenewal) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        PBStringField pBStringField7;
        PBStringField pBStringField8;
        ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp;
        if (activity == null) {
            return;
        }
        String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        int i3 = 0;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (!isFromRenewal && (experienceSvipServerPB$GetExperienceSvipInfoRsp = this.lastRequestData) != null) {
            com.tencent.mobileqq.vas.pay.newcustomer.c cVar = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo = experienceSvipServerPB$GetExperienceSvipInfoRsp.pay_info.get();
            Intrinsics.checkNotNullExpressionValue(experienceSvipServerPB$PayInfo, "it.pay_info.get()");
            cVar.i(monthInfo, experienceSvipServerPB$PayInfo);
        }
        e23.c cVar2 = new e23.c(activity);
        PBEnumField pBEnumField = monthInfo.type;
        if (pBEnumField != null) {
            int i16 = pBEnumField.get();
            QLog.i("QVipNewCustomerViewModel", 1, "startPay \u5f00\u59cb\u652f\u4ed8: " + i16 + " title" + monthInfo.title.get());
            Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerViewModel$startPay$reportResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i17) {
                    ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp2;
                    ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp3;
                    if (!isFromRenewal) {
                        experienceSvipServerPB$GetExperienceSvipInfoRsp2 = this.lastRequestData;
                        if (experienceSvipServerPB$GetExperienceSvipInfoRsp2 != null) {
                            ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo = monthInfo;
                            c cVar3 = c.f310291a;
                            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo2 = experienceSvipServerPB$GetExperienceSvipInfoRsp2.pay_info.get();
                            Intrinsics.checkNotNullExpressionValue(experienceSvipServerPB$PayInfo2, "it.pay_info.get()");
                            cVar3.j(experienceSvipServerPB$MonthInfo, experienceSvipServerPB$PayInfo2, i17);
                            return;
                        }
                        return;
                    }
                    c cVar4 = c.f310291a;
                    experienceSvipServerPB$GetExperienceSvipInfoRsp3 = this.lastRequestData;
                    String str15 = monthInfo.pay_aid.get();
                    Intrinsics.checkNotNullExpressionValue(str15, "monthInfo.pay_aid.get()");
                    cVar4.t(experienceSvipServerPB$GetExperienceSvipInfoRsp3, str15, i17);
                }
            };
            String str15 = null;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 5) {
                            QLog.i("QVipNewCustomerViewModel", 1, "\u652f\u4ed8\u7c7b\u578b\u6682\u4e0d\u652f\u6301");
                            return;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(uin, "uin");
                        String str16 = monthInfo.pay_aid.get();
                        Intrinsics.checkNotNullExpressionValue(str16, "monthInfo.pay_aid.get()");
                        ExperienceSvipServerPB$Tianxuan experienceSvipServerPB$Tianxuan = monthInfo.tianxuan;
                        if (experienceSvipServerPB$Tianxuan != null && (pBStringField8 = experienceSvipServerPB$Tianxuan.item_id) != null) {
                            str15 = pBStringField8.get();
                        }
                        if (str15 == null) {
                            str15 = "";
                        }
                        cVar2.b(uin, str16, str15, new f(monthInfo, cVar2, uin, function1, i16));
                        return;
                    }
                }
                ExperienceSvipServerPB$Service experienceSvipServerPB$Service = monthInfo.service;
                if (experienceSvipServerPB$Service != null && (pBStringField7 = experienceSvipServerPB$Service.offer_id) != null) {
                    str9 = pBStringField7.get();
                } else {
                    str9 = null;
                }
                if (str9 == null) {
                    str10 = "";
                } else {
                    str10 = str9;
                }
                PBInt32Field pBInt32Field = monthInfo.month;
                if (pBInt32Field != null) {
                    i3 = pBInt32Field.get();
                }
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                ExperienceSvipServerPB$Service experienceSvipServerPB$Service2 = monthInfo.service;
                if (experienceSvipServerPB$Service2 != null && (pBStringField6 = experienceSvipServerPB$Service2.service_type) != null) {
                    str11 = pBStringField6.get();
                } else {
                    str11 = null;
                }
                if (str11 == null) {
                    str11 = "";
                }
                ExperienceSvipServerPB$Service experienceSvipServerPB$Service3 = monthInfo.service;
                if (experienceSvipServerPB$Service3 != null && (pBStringField5 = experienceSvipServerPB$Service3.qq_product_name) != null) {
                    str12 = pBStringField5.get();
                } else {
                    str12 = null;
                }
                if (str12 == null) {
                    str13 = "";
                } else {
                    str13 = str12;
                }
                String str17 = monthInfo.pay_aid.get();
                Intrinsics.checkNotNullExpressionValue(str17, "monthInfo.pay_aid.get()");
                ExperienceSvipServerPB$Service experienceSvipServerPB$Service4 = monthInfo.service;
                if (experienceSvipServerPB$Service4 != null && (pBStringField4 = experienceSvipServerPB$Service4.product_id) != null) {
                    str14 = pBStringField4.get();
                } else {
                    str14 = null;
                }
                cVar2.c(new MonthlyPayData(str10, i3, uin, str11, str13, str17, null, false, null, null, false, null, str14, 4032, null), new e(function1, i16));
                return;
            }
            this.payBaoyue = true;
            this.lastPayBaoyueMonth = monthInfo;
            ExperienceSvipServerPB$Service experienceSvipServerPB$Service5 = monthInfo.service;
            if (experienceSvipServerPB$Service5 != null && (pBStringField3 = experienceSvipServerPB$Service5.offer_id) != null) {
                str = pBStringField3.get();
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            PBStringField pBStringField9 = monthInfo.service.service_type;
            if (pBStringField9 != null) {
                str3 = pBStringField9.get();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            ExperienceSvipServerPB$Service experienceSvipServerPB$Service6 = monthInfo.service;
            if (experienceSvipServerPB$Service6 != null && (pBStringField2 = experienceSvipServerPB$Service6.qq_product_name) != null) {
                str5 = pBStringField2.get();
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str6 = "";
            } else {
                str6 = str5;
            }
            int i17 = monthInfo.month.get();
            String str18 = monthInfo.pay_aid.get();
            ExperienceSvipServerPB$Service experienceSvipServerPB$Service7 = monthInfo.service;
            if (experienceSvipServerPB$Service7 != null && (pBStringField = experienceSvipServerPB$Service7.product_id) != null) {
                str7 = pBStringField.get();
            } else {
                str7 = null;
            }
            PBStringField pBStringField10 = monthInfo.group_id;
            if (pBStringField10 != null) {
                str15 = pBStringField10.get();
            }
            if (str15 == null) {
                str8 = "";
            } else {
                str8 = str15;
            }
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(str18, "get()");
            cVar2.a(new e23.a(str2, str4, str6, uin, i17, str18, null, null, null, null, null, null, null, null, null, str8, str7, null, null, null, null, null, 4095936, null), this.selectPayType);
        }
    }

    static /* synthetic */ void r0(QVipNewCustomerViewModel qVipNewCustomerViewModel, Activity activity, ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        qVipNewCustomerViewModel.q0(activity, experienceSvipServerPB$MonthInfo, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result) {
        if (result.receive_info.can_receive.get()) {
            o0(result.receive_info.auto_receive_delay_sec.get());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(@StringRes int stringRes) {
        String string = BaseApplication.context.getString(stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringRes)");
        u0(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(final String text) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.ad
            @Override // java.lang.Runnable
            public final void run() {
                QVipNewCustomerViewModel.v0(text);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(String text) {
        Intrinsics.checkNotNullParameter(text, "$text");
        QQToast.makeText(BaseApplication.context, 1, text, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result) {
        if (result.experience_svip_info.is_experience_user.get() && result.text_info.text_type.get() == 1 && I(this, result.experience_svip_info.experience_expire_time.get(), false, 2, null)) {
            return;
        }
        this.experienceExpiredCountDown.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result) {
        String buyBtnTitle = result.experience_svip_info.get().buy_btn_title.get();
        if (TextUtils.isEmpty(buyBtnTitle)) {
            buyBtnTitle = BaseApplication.context.getString(R.string.f2173360q);
        }
        MutableLiveData<i23.c> mutableLiveData = this.payBtnStyle;
        Intrinsics.checkNotNullExpressionValue(buyBtnTitle, "buyBtnTitle");
        mutableLiveData.setValue(new i23.c(buyBtnTitle, R.drawable.l7s));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result) {
        ArrayList<i23.b> arrayList = new ArrayList();
        ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo = result.pay_info;
        int size = experienceSvipServerPB$PayInfo.month_info.size();
        for (int i3 = 0; i3 < size; i3++) {
            ExperienceSvipServerPB$MonthInfo get = experienceSvipServerPB$PayInfo.month_info.get(i3);
            Intrinsics.checkNotNullExpressionValue(get, "get");
            arrayList.add(new i23.b(i3, get, false, 4, null));
        }
        MutableLiveData<List<? extends h23.c>> mutableLiveData = this.itemList;
        for (i23.b bVar : arrayList) {
            com.tencent.mobileqq.vas.pay.newcustomer.c cVar = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
            ExperienceSvipServerPB$MonthInfo monthInfo = bVar.getMonthInfo();
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo2 = result.pay_info.get();
            Intrinsics.checkNotNullExpressionValue(experienceSvipServerPB$PayInfo2, "result.pay_info.get()");
            cVar.n(monthInfo, experienceSvipServerPB$PayInfo2);
        }
        mutableLiveData.setValue(arrayList);
        this.payContentVisible.setValue(Boolean.valueOf(!arrayList.isEmpty()));
        if (!arrayList.isEmpty()) {
            com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(ExperienceSvipServerPB$GetExperienceSvipInfoRsp result) {
        MutableLiveData<PayUserInfoText> mutableLiveData = this.userInfoText;
        String str = result.text_info.pay_btn_title.get();
        Intrinsics.checkNotNullExpressionValue(str, "result.text_info.pay_btn_title.get()");
        String str2 = result.text_info.pay_btn_corner.get();
        Intrinsics.checkNotNullExpressionValue(str2, "result.text_info.pay_btn_corner.get()");
        SpannableString spannableString = new SpannableString(result.text_info.title.get());
        SpannableString spannableString2 = new SpannableString(result.text_info.sub_title.get());
        boolean z16 = result.receive_info.can_receive.get();
        String string = BaseApplication.context.getString(R.string.f2173060n);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026omer_get_svip_experience)");
        mutableLiveData.setValue(new PayUserInfoText(str, str2, spannableString, spannableString2, z16, string, result.receive_info.auto_receive_delay_sec.get()));
        com.tencent.mobileqq.vas.pay.newcustomer.c cVar = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
        cVar.q(result);
        if (result.receive_info.can_receive.get()) {
            cVar.p(result);
        }
        ExperienceSvipServerPB$MonthInfo S = S(result);
        if (S != null) {
            ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp = this.lastRequestData;
            String str3 = S.pay_aid.get();
            Intrinsics.checkNotNullExpressionValue(str3, "it.pay_aid.get()");
            cVar.s(experienceSvipServerPB$GetExperienceSvipInfoRsp, str3);
        }
    }

    public final void A0() {
        if (this.payBaoyue) {
            this.payBaoyue = false;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.aa
                @Override // java.lang.Runnable
                public final void run() {
                    QVipNewCustomerViewModel.B0(QVipNewCustomerViewModel.this);
                }
            }, 16, null, false, 2000L);
        }
    }

    public boolean G() {
        if (this.clickFlag != -1 && System.currentTimeMillis() - this.clickFlag > 300) {
            this.clickFlag = -1L;
            return true;
        }
        return false;
    }

    @NotNull
    public final MutableLiveData<ExperienceExpiredCountDown> M() {
        return this.experienceExpiredCountDown;
    }

    @NotNull
    public final MutableLiveData<OpenHippyInfo> N() {
        return this.hippyInfo;
    }

    @NotNull
    public final MutableLiveData<List<? extends h23.c>> O() {
        return this.itemList;
    }

    @NotNull
    public final MutableLiveData<i23.c> P() {
        return this.payBtnStyle;
    }

    @NotNull
    public final MutableLiveData<Boolean> Q() {
        return this.payContentVisible;
    }

    @NotNull
    public final MutableLiveData<PayListTop> R() {
        return this.payListTop;
    }

    @NotNull
    public final MutableLiveData<i23.b> T() {
        return this.selectedItem;
    }

    @NotNull
    public final MutableLiveData<h23.a> U() {
        return this.showSelectPayTypeDialog;
    }

    @NotNull
    public final MutableLiveData<PayUserInfoText> V() {
        return this.userInfoText;
    }

    public final void W() {
        com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a.f();
        Intent intent = new Intent(BaseApplication.context, (Class<?>) QQBrowserActivity.class);
        intent.setFlags(268435456);
        VasWebviewUtil.openQQBrowserActivity(BaseApplication.context, a.INSTANCE.c(), -1L, intent, false, -1);
    }

    public final boolean X() {
        ExperienceSvipServerPB$MonthInfo monthInfo;
        PBEnumField pBEnumField;
        i23.b value = this.selectedItem.getValue();
        if (value == null || (monthInfo = value.getMonthInfo()) == null || (pBEnumField = monthInfo.type) == null || pBEnumField.get() != 1) {
            return false;
        }
        return true;
    }

    public final void Y(@Nullable Activity activity) {
        ExperienceSvipServerPB$MonthInfo monthInfo;
        QLog.i("QVipNewCustomerViewModel", 1, "oneKeyRenew");
        i23.b value = this.selectedItem.getValue();
        if (value != null && (monthInfo = value.getMonthInfo()) != null) {
            r0(this, activity, monthInfo, false, 4, null);
        }
    }

    public final void Z(@NotNull String source) {
        List split$default;
        Intrinsics.checkNotNullParameter(source, "source");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(source);
        String str = argumentsFromURL.get("aid");
        if (str != null && !TextUtils.isEmpty(str)) {
            this.aid = str;
        }
        String str2 = argumentsFromURL.get("businessType");
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                Integer num = com.tencent.mobileqq.vas.pay.page.j.INSTANCE.f().get((String) it.next());
                if (num != null) {
                    arrayList.add(Integer.valueOf(num.intValue()));
                }
            }
            if (!arrayList.isEmpty()) {
                this.businessTypeList = arrayList;
            }
        }
        String str3 = argumentsFromURL.get("policyID");
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            this.policyId = str3;
        }
        String str4 = argumentsFromURL.get("hippyTrace");
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            this.hippyTrace = str4;
        }
        String str5 = argumentsFromURL.get("enterance_id");
        if (str5 != null && !TextUtils.isEmpty(str5)) {
            this.enteranceId = str5;
        }
    }

    @Override // h23.b
    public boolean a() {
        if (this.clickFlag > 0) {
            return true;
        }
        return false;
    }

    @Override // h23.b
    public void b(@NotNull h23.c item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.clickFlag = System.currentTimeMillis();
        F(item, false);
    }

    public final void b0(@Nullable Activity activity) {
        ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp;
        ExperienceSvipServerPB$MonthInfo S;
        Object obj;
        boolean z16;
        if (activity != null && (experienceSvipServerPB$GetExperienceSvipInfoRsp = this.lastRequestData) != null && (S = S(experienceSvipServerPB$GetExperienceSvipInfoRsp)) != null) {
            com.tencent.mobileqq.vas.pay.newcustomer.c cVar = com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a;
            String str = S.pay_aid.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.pay_aid.get()");
            cVar.r(experienceSvipServerPB$GetExperienceSvipInfoRsp, str);
            List<? extends h23.c> value = this.itemList.getValue();
            if (value != null) {
                Iterator<T> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        h23.c cVar2 = (h23.c) obj;
                        if ((cVar2 instanceof i23.b) && ((i23.b) cVar2).getMonthInfo().index.get() == S.index.get()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                h23.c cVar3 = (h23.c) obj;
                if (cVar3 != null) {
                    F(cVar3, false);
                }
            }
            if (X()) {
                this.showSelectPayTypeDialog.setValue(null);
                this.showSelectPayTypeDialog.setValue(new b(activity, S));
            } else {
                q0(activity, S, true);
            }
        }
    }

    public final void d0() {
        e0(this.itemList);
        e0(this.selectedItem);
        e0(this.hippyInfo);
    }

    public final void f0(boolean isClick) {
        if (this.isGetExperience) {
            return;
        }
        if (isClick) {
            com.tencent.mobileqq.vas.pay.newcustomer.c.f310291a.o(this.lastRequestData);
        }
        E();
        j jVar = this.model;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        jVar.e(peekAppRuntime, this.enteranceId, new c());
    }

    public final void h0() {
        this.isRelease = true;
        E();
        D();
    }

    public final void k0() {
        D();
        E();
        j jVar = this.model;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        jVar.h(peekAppRuntime, this.enteranceId, new d());
    }

    public final void n0(int type) {
        this.selectPayType = type;
    }

    public final void p0() {
        OpenHippyInfo b16 = a.INSTANCE.b();
        if (b16 != null) {
            b16.processName = "main";
            b16.url = URLUtil.addParameter(b16.url, "traceDetail", this.hippyTrace);
            this.hippyInfo.setValue(b16);
        } else {
            this.hippyInfo.setValue(J());
        }
    }
}
