package com.tencent.mobileqq.zootopia.webview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadData;
import com.tencent.mobileqq.zootopia.ipc.aa;
import com.tencent.mobileqq.zootopia.ipc.ah;
import com.tencent.mobileqq.zootopia.ipc.n;
import com.tencent.mobileqq.zootopia.ipc.r;
import com.tencent.mobileqq.zootopia.ipc.s;
import com.tencent.mobileqq.zootopia.ipc.x;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2;
import com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mobileqq.zplan.authorize.api.CheckResultDefaultProcessor;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mobileqq.zplan.friend.api.IZPlanChangeFriendApi;
import com.tencent.mobileqq.zplan.friend.o;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.TabBackFrom;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.ZPlanTabBackEvent;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jl3.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\"\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010%\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010*\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0017J \u0010/\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020-J\u000e\u00101\u001a\u0002002\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\nJ\u000e\u00105\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\nJ\u0006\u00108\u001a\u00020\nJ\u000e\u00109\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010:\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;J\u0016\u0010>\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010?\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010B\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010C\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010E\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010G\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010H\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/JSEventDelegate;", "", "Lcom/tencent/mobileqq/zplan/model/MaintEntryType;", "type", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/Date;", "date", "", "j", "", "id", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "data", "k", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "a0", "(Ljava/lang/Integer;)I", ark.ARKMETADATA_JSON, "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "jsonStr", "D", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "startTime", ExifInterface.LATITUDE_SOUTH, "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "g", "V", "mapId", "G", "X", "J", "E", UserInfo.SEX_FEMALE, "u", "w", "p", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "T", "Lorg/json/JSONArray;", "o", tl.h.F, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c0", "t", "P", "O", DomainData.DOMAIN_NAME, "M", "Lcom/tencent/sqshow/zootopia/recommend/specialtab/event/TabBackFrom;", "from", "Y", "b0", "N", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Req, "i", "L", "h5DataJson", "y", "jsonParam", "l", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class JSEventDelegate {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$b", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ah {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f329794a;

        b(Promise promise) {
            this.f329794a = promise;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Promise promise = this.f329794a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("msg", errorMessage);
            promise.resolve(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onSuccess(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Promise promise = this.f329794a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            promise.resolve(jSONObject.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$c", "Lcom/tencent/mobileqq/zplan/friend/o;", "", "success", "", "path", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f329795a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f329796b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f329797c;

        c(String str, Promise promise, JSONObject jSONObject) {
            this.f329795a = str;
            this.f329796b = promise;
            this.f329797c = jSONObject;
        }

        @Override // com.tencent.mobileqq.zplan.friend.o
        public void a(boolean success, String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            QLog.d("HippyEventDeleage", 1, "getUserAvatar, onComplete = " + success + ", uin = " + this.f329795a + ", path = " + path);
            if (success) {
                if (!(path.length() == 0)) {
                    this.f329797c.put(QCircleSchemeAttr.Detail.AVATAR_URL, path);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = this.f329797c;
                    jSONObject.put("result", 0);
                    jSONObject.put("data", jSONObject2);
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026             }.toString()");
                    QLog.d("HippyEventDeleage", 1, "currentInfo " + jSONObject3);
                    this.f329796b.resolve(jSONObject3);
                    return;
                }
            }
            Promise promise = this.f329796b;
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = this.f329797c;
            jSONObject4.put("result", 1);
            jSONObject4.put("data", jSONObject5);
            promise.resolve(jSONObject4.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$d", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$b;", "", PreloadTRTCPlayerParams.KEY_SIG, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements SuitFeedViewModel.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f329798a;

        d(Ref.ObjectRef<String> objectRef) {
            this.f329798a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel.b
        public void a(String sig) {
            this.f329798a.element = sig;
            if (sig == 0) {
                QQToastUtil.showQQToast(0, HardCodeUtil.qqStr(R.string.bce));
                return;
            }
            JumpGuildParam jumpGuildParam = new JumpGuildParam(be3.a.INSTANCE.b(), "");
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(this.f329798a.element, "share", "others"));
            com.tencent.mobileqq.guild.report.b.g("functional_superqqshow_square", "HippyEventDeleage");
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(BaseApplication.context, jumpGuildParam);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$f", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements ah {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f329800a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f329801b;

        f(String str, Promise promise) {
            this.f329800a = str;
            this.f329801b = promise;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.i("HippyEventDeleage", 1, "pauseMapDownload " + this.f329800a + ", onFailed, errorCode= " + errorCode + ", errorMessage= " + errorMessage);
            Promise promise = this.f329801b;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", errorCode);
            jSONObject.put("errMsg", errorMessage);
            promise.reject(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onSuccess(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            QLog.i("HippyEventDeleage", 1, "pauseMapDownload " + this.f329800a + ", onSuccess");
            Promise promise = this.f329801b;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            promise.resolve(jSONObject.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$g", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements ah {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f329802a;

        g(Promise promise) {
            this.f329802a = promise;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("HippyEventDeleage", 1, "requestServer failed : errCode == " + errorCode + " , errorMessage == " + errorMessage);
            Promise promise = this.f329802a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", errorCode);
            jSONObject.put("errorMessage", errorMessage);
            promise.reject(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onSuccess(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            QLog.i("HippyEventDeleage", 1, "requestServer success : response == " + response);
            Promise promise = this.f329802a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("rsp", response);
            promise.resolve(jSONObject.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$h", "Lpk3/c;", "", "isContinueNext", "hasPermissionGranted", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements pk3.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f329803a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f329804b;

        h(Promise promise, long j3) {
            this.f329803a = promise;
            this.f329804b = j3;
        }

        @Override // pk3.b
        public void a(boolean isContinueNext, boolean hasPermissionGranted) {
            QLog.i("HippyEventDeleage", 1, "showMapFloatWindow#Callback - " + isContinueNext);
            Promise promise = this.f329803a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", isContinueNext ? 0 : -1);
            promise.resolve(jSONObject.toString());
            QLog.d("HippyEventDeleage", 1, "showMapFloatWindow cost: " + (System.currentTimeMillis() - this.f329804b) + "ms");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$i", "Ljl3/a$a;", "", "onDismiss", "", "", "selectResult", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements a.InterfaceC10597a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f329805a;

        i(Promise promise) {
            this.f329805a = promise;
        }

        @Override // jl3.a.InterfaceC10597a
        public void a(List<Integer> selectResult) {
            Intrinsics.checkNotNullParameter(selectResult, "selectResult");
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) selectResult);
            jSONObject.put("selectResult", jSONArray);
            QLog.i("HippyEventDeleage", 1, "showWheelPicker::onConfirm callback , resultJson == " + jSONArray);
            Promise promise = this.f329805a;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 0);
            jSONObject2.put("data", jSONObject);
            promise.resolve(jSONObject2.toString());
        }

        @Override // jl3.a.InterfaceC10597a
        public void onDismiss() {
            QLog.i("HippyEventDeleage", 1, "showWheelPicker::onDismiss callback");
            Promise promise = this.f329805a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 1);
            promise.resolve(jSONObject.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$j", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j implements ah {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f329806a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f329807b;

        j(String str, Promise promise) {
            this.f329806a = str;
            this.f329807b = promise;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.i("HippyEventDeleage", 1, "startMapDownload " + this.f329806a + ", onFailed, errorCode= " + errorCode + ", errorMessage= " + errorMessage);
            Promise promise = this.f329807b;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", errorCode);
            jSONObject.put("errMsg", errorMessage);
            promise.reject(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ah
        public void onSuccess(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            QLog.i("HippyEventDeleage", 1, "startMapDownload " + this.f329806a + ", onSuccess");
            Promise promise = this.f329807b;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            promise.resolve(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Promise promise, int i3) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", i3);
        promise.resolve(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Promise promise, JSEventDelegate this$0, FileDownloadData fileDownloadData) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("HippyEventDeleage", 1, "queryResourceDownloadInfo status " + (fileDownloadData != null ? Integer.valueOf(fileDownloadData.getStatus()) : null));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this$0.a0(fileDownloadData != null ? Integer.valueOf(fileDownloadData.getStatus()) : null));
        long size = fileDownloadData != null ? fileDownloadData.getSize() : 0L;
        jSONObject.put("totalBytes", size);
        jSONObject.put("bytes", Float.valueOf(((float) size) * (fileDownloadData != null ? fileDownloadData.getProgress() : 0.0f)));
        promise.resolve(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(TabBackFrom from) {
        Intrinsics.checkNotNullParameter(from, "$from");
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanTabBackEvent(from));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject k(int id5, ZootopiaResData data) {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", a0(data != null ? Integer.valueOf(data.getDownloadStatus()) : null));
        jSONObject.put("resourceId", id5);
        if (data == null || (str = data.getVersion()) == null) {
            str = "";
        }
        jSONObject.put("version", str);
        long size = data != null ? data.getSize() : 0L;
        jSONObject.put("totalBytes", size);
        jSONObject.put("bytes", Float.valueOf(((float) size) * (data != null ? data.getProgress() : 0.0f)));
        return jSONObject;
    }

    private final JSONObject q(MaintEntryType type) {
        JSONObject jSONObject = new JSONObject();
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(type);
        jSONObject.put("enable", maintenanceInfo.getMEnable());
        jSONObject.put("mainTitle", maintenanceInfo.f());
        jSONObject.put(QQWinkConstants.TAB_SUBTITLE, maintenanceInfo.g());
        jSONObject.put("beginTime", j(maintenanceInfo.getMBeginTime()));
        jSONObject.put("endTime", j(maintenanceInfo.getMEndTime()));
        if (maintenanceInfo.getMEnable()) {
            return null;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3, Promise promise, AccessibleDetail accessibleDetail) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        boolean isAccessible = accessibleDetail != null ? accessibleDetail.isAccessible() : false;
        QLog.d("HippyEventDeleage", 1, "isSupportZPlan isAccessible:" + isAccessible + ", appId:" + i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSupport", isAccessible);
        promise.resolve(jSONObject.toString());
    }

    public final void B(JSONObject params, final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String jumpFrom = params.optString("jumpFrom");
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Source source = Source.H5;
        Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
        ZootopiaSource d16 = ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null);
        Bundle bundle = new Bundle();
        bundle.putString("jumpSrc", params.optString("jumpSrc"));
        bundle.putString("jumpMsg", params.optString("jumpMsg"));
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("ueParams", bundle);
        ((r) k74.i.INSTANCE.a(r.class)).enterPortal(d16, bundle2, new s() { // from class: com.tencent.mobileqq.zootopia.webview.e
            @Override // com.tencent.mobileqq.zootopia.ipc.s
            public final void onResponse(int i3) {
                JSEventDelegate.C(Promise.this, i3);
            }
        });
    }

    public final void D(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "openRechargePanel jsonStr:" + jsonStr);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.e("HippyEventDeleage", 1, "openRechargePanel activity is null");
            promise.reject("fail activity is null");
            return;
        }
        JSONObject jSONObject = new JSONObject(jsonStr);
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(topActivity, jSONObject.optString("title"), jSONObject.optString("appName"), new IVasNativePayManager.ReportData(String.valueOf(jSONObject.optInt("appId", 0)), String.valueOf(jSONObject.optInt(WadlProxyConsts.SCENE_ID, 0)), String.valueOf(jSONObject.optInt("sourceId", 0)), jSONObject.optString("reportExt", "0_0_0_0")), new e(promise));
    }

    public final int E(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "openSameStylePage json:" + json);
        String taskId = json.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        String optString = json.optString("tag");
        if (optString == null) {
            optString = "";
        }
        String jumpFrom = json.optString("jumpFrom");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(taskId)) {
            Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
            hashMap.put("taskid", taskId);
        }
        if (!TextUtils.isEmpty(optString)) {
            hashMap.put("tag", optString);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_extra_params", hashMap);
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Source source = Source.H5;
        Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null));
        ZplanHostActivity.Companion companion2 = ZplanHostActivity.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion2.b(context, com.tencent.sqshow.zootopia.samestyle.a.class, bundle, 268435456);
        return 0;
    }

    public final void G(String mapId, Promise promise) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ((n) k74.i.INSTANCE.a(n.class)).pauseMapDownload(mapId, new f(mapId, promise));
    }

    public final void H(JSONObject params, final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final int optInt = params.optInt("resourceId");
        QLog.i("HippyEventDeleage", 1, "queryDownloadInfo id " + optInt);
        ZootopiaDownloadManagerIpc.f328013a.i(optInt, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.webview.JSEventDelegate$queryDownloadInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                JSONObject k3;
                k3 = JSEventDelegate.this.k(optInt, zootopiaResData);
                String jSONObject = k3.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "createJSONObject(mapId, it).toString()");
                QLog.i("HippyEventDeleage", 1, "queryDownloadInfo id " + optInt + " status " + (zootopiaResData != null ? Integer.valueOf(zootopiaResData.getDownloadStatus()) : null) + " ver " + (zootopiaResData != null ? zootopiaResData.getVersion() : null) + ", callbackRet=" + jSONObject);
                promise.resolve(jSONObject);
            }
        });
    }

    public final void I(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
        QLog.d("HippyEventDeleage", 1, "queryFloatingPermission permission: " + checkPermission);
        int i3 = checkPermission ? 0 : -1;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", i3);
        promise.resolve(jSONObject.toString());
    }

    public final void J(JSONObject params, final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        int optInt = params.optInt("category");
        String optString = params.optString("url", "");
        QLog.i("HippyEventDeleage", 1, "queryResourceDownloadInfo " + optInt + " " + optString);
        ((n) k74.i.INSTANCE.a(n.class)).queryFileDownloadInfo(optInt, optString, new com.tencent.mobileqq.zootopia.ipc.b() { // from class: com.tencent.mobileqq.zootopia.webview.a
            @Override // com.tencent.mobileqq.zootopia.ipc.b
            public final void a(FileDownloadData fileDownloadData) {
                JSEventDelegate.K(Promise.this, this, fileDownloadData);
            }
        });
    }

    public final void L(JSONObject json, Promise promise) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        com.tencent.mobileqq.zootopia.utils.h hVar = com.tencent.mobileqq.zootopia.utils.h.f329557a;
        long f16 = hVar.f();
        long c16 = hVar.c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("totalSize", f16);
        jSONObject2.put("remainedSize", c16);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        promise.resolve(jSONObject.toString());
    }

    public final int M(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "refreshDressInfo json:" + json);
        String optString = json.optString("refresh_scene");
        if (TextUtils.isEmpty(optString)) {
            optString = "jsb";
        }
        ((IZplanHandleApi) QRoute.api(IZplanHandleApi.class)).handleDataToMain(IZplanHandleApi.BUSINESS_DRESS_INFO, IZplanHandleApi.METHOD_REFRESH_DRESS_INFO, optString);
        return 0;
    }

    public final int N(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "refreshModJsInfo json:" + json);
        gg3.a.f402031a.a(json.optString("data", ""));
        return 0;
    }

    public final int P() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneName", "JSB#refreshSilenceDownloadList");
        ((IZplanHandleApi) QRoute.api(IZplanHandleApi.class)).handleDataToMain(IZplanHandleApi.BUSINESS_MOD_API, IZplanHandleApi.METHOD_SILENCE_DOWNLOAD, jSONObject.toString());
        return 0;
    }

    public final void Q(JSONObject json, Promise promise) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "requestJsonServer request:" + json);
        String server = json.optString("server");
        String method = json.optString("method");
        String req = json.optString("req");
        if (!TextUtils.isEmpty(server) && !TextUtils.isEmpty(method)) {
            aa aaVar = (aa) k74.i.INSTANCE.a(aa.class);
            Intrinsics.checkNotNullExpressionValue(server, "server");
            Intrinsics.checkNotNullExpressionValue(method, "method");
            Intrinsics.checkNotNullExpressionValue(req, "req");
            aaVar.sendJsonRequest(server, method, req, new g(promise));
            return;
        }
        QLog.i("HippyEventDeleage", 1, "requestServer error : server or method must not be empty");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", -1);
        promise.reject(jSONObject.toString());
    }

    public final int R(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "setStartScheme => " + json);
        String mapId = json.optString("mapId");
        String scheme = json.optString(ZPlanPublishSource.FROM_SCHEME);
        try {
            com.tencent.mobileqq.zplan.authorize.impl.helper.e eVar = (com.tencent.mobileqq.zplan.authorize.impl.helper.e) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.authorize.impl.helper.e.class);
            Intrinsics.checkNotNullExpressionValue(mapId, "mapId");
            int parseInt = Integer.parseInt(mapId);
            Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
            return eVar.saveScheme(parseInt, scheme);
        } catch (Exception unused) {
            return -1;
        }
    }

    public final void S(JSONObject params, Promise promise, long startTime) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "showMapFloatWindow - " + params);
        String mapId = params.optString("mapId", "");
        String optString = params.optString(ZPlanPublishSource.FROM_SCHEME, "");
        if (!TextUtils.isEmpty(mapId)) {
            com.tencent.mobileqq.zootopia.ipc.f fVar = (com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class);
            Intrinsics.checkNotNullExpressionValue(mapId, "mapId");
            fVar.h5ShowMapFloatWindow(mapId, optString, new h(promise, startTime));
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            promise.resolve(jSONObject.toString());
        }
    }

    public final void T(JSONObject json, Promise promise, Activity activity) {
        Integer[] numArr;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i("HippyEventDeleage", 1, "showWheelPicker:: json:" + json);
        String optString = json.optString("title");
        JSONArray optJSONArray = json.optJSONArray("defaultValues");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            numArr = new Integer[length];
            for (int i3 = 0; i3 < length; i3++) {
                numArr[i3] = Integer.valueOf(optJSONArray.getInt(i3));
            }
        } else {
            numArr = new Integer[0];
        }
        JSONArray optJSONArray2 = json.optJSONArray("selectData");
        if (optJSONArray2 == null) {
            return;
        }
        QLog.i("HippyEventDeleage", 1, "showWheelPicker::selectDataJson json:" + optJSONArray2);
        ArrayList arrayList = new ArrayList();
        int length2 = optJSONArray2.length();
        for (int i16 = 0; i16 < length2; i16++) {
            JSONArray jSONArray = optJSONArray2.getJSONArray(i16);
            int length3 = jSONArray.length();
            String[] strArr = new String[length3];
            for (int i17 = 0; i17 < length3; i17++) {
                String string = jSONArray.getString(i17);
                Intrinsics.checkNotNullExpressionValue(string, "columnDataJson.getString(it)");
                strArr[i17] = string;
            }
            arrayList.add(strArr);
        }
        ((el3.a) vb3.a.f441346a.a(el3.a.class)).W(activity, new a.SelectData(optString, arrayList, numArr), new i(promise)).m();
    }

    public final void V(JSONObject params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String optString = params.optString("mapId", "");
        QLog.i("HippyEventDeleage", 1, "startMapDownload " + params);
        if (TextUtils.isEmpty(optString)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.webview.d
                @Override // java.lang.Runnable
                public final void run() {
                    JSEventDelegate.W();
                }
            });
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -432101);
            jSONObject.put("errMsg", "invalid param");
            promise.reject(jSONObject.toString());
            return;
        }
        ((n) k74.i.INSTANCE.a(n.class)).startMapDownload(optString, new j(optString, promise));
    }

    public final int X(JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        int optInt = params.optInt("category");
        String optString = params.optString("url", "");
        QLog.i("HippyEventDeleage", 1, "startResourceDownload " + optInt + " " + optString);
        if (TextUtils.isEmpty(optString)) {
            return -1;
        }
        ((n) k74.i.INSTANCE.a(n.class)).startFileDownload(optInt, optString, "", "", "");
        return 0;
    }

    public final void Y(final TabBackFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.webview.c
            @Override // java.lang.Runnable
            public final void run() {
                JSEventDelegate.Z(TabBackFrom.this);
            }
        });
    }

    public final void b0(JSONObject params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BaseHippyUeActionHandler M0 = ((te3.a) vb3.a.f441346a.b(te3.a.class)).M0(params, promise);
        if (M0 == null) {
            QLog.e("HippyEventDeleage", 1, "ueFusionAction unsupported action:" + params);
            promise.reject("actionHandler is null");
            return;
        }
        M0.f();
    }

    public final int c0(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "updateQQLiveSteamMediaInfo json:" + json);
        String liveSteamStr = json.optString("mediaInfo");
        Intrinsics.checkNotNullExpressionValue(liveSteamStr, "liveSteamStr");
        if (liveSteamStr.length() == 0) {
            QLog.e("HippyEventDeleage", 1, "updateQQLiveSteamMediaInfo no params");
            return -1;
        }
        try {
            dv4.j liveSteamInfo = dv4.j.c(com.tencent.mobileqq.musicpendant.a.a(liveSteamStr));
            VideoMediaInfo.Companion companion = VideoMediaInfo.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(liveSteamInfo, "liveSteamInfo");
            VideoMediaInfo a16 = companion.a(liveSteamInfo);
            VideoPlayInfo a17 = VideoPlayInfo.INSTANCE.a(json.optJSONObject("playInfo"));
            vb3.a aVar = vb3.a.f441346a;
            ((zk3.a) aVar.a(zk3.a.class)).D0(new TXVideoInfo(a17, a16, ((zk3.a) aVar.a(zk3.a.class)).a0()));
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final void g(JSONObject params, final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        JSONArray optJSONArray = params.optJSONArray("mapIdList");
        if (optJSONArray == null) {
            return;
        }
        final JSONArray jSONArray = new JSONArray();
        final ArrayList<Integer> arrayList = new ArrayList<>();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
        }
        ZootopiaDownloadManagerIpc.f328013a.j(arrayList, new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.webview.JSEventDelegate$batchQueryDownloadInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
                invoke2((List<ZootopiaResData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaResData> datas) {
                Object obj;
                JSONObject k3;
                Intrinsics.checkNotNullParameter(datas, "datas");
                ArrayList<Integer> arrayList2 = arrayList;
                JSONArray jSONArray2 = jSONArray;
                JSEventDelegate jSEventDelegate = this;
                Iterator<T> it = arrayList2.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    Iterator<T> it5 = datas.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it5.next();
                            if (((ZootopiaResData) obj).getId() == intValue) {
                                break;
                            }
                        }
                    }
                    k3 = jSEventDelegate.k(intValue, (ZootopiaResData) obj);
                    jSONArray2.mo162put(k3);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", jSONArray);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
                QLog.i("HippyEventDeleage", 1, "batchQueryDownloadInfo result " + jSONObject2);
                promise.resolve(jSONObject2);
            }
        });
    }

    public final void h(JSONObject json, Promise promise) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "callN2LEvent:: json:" + json);
        String eventName = json.optString(AdMetricTag.EVENT_NAME);
        String params = json.optString("params");
        if (eventName == null || eventName.length() == 0) {
            QLog.e("HippyEventDeleage", 1, "callN2LEvent error :: eventName is empty ");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", -1);
            jSONObject.put("msg", "callN2LEvent error :: eventName is empty ");
            promise.reject(jSONObject.toString());
            return;
        }
        x xVar = (x) k74.i.INSTANCE.a(x.class);
        Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
        Intrinsics.checkNotNullExpressionValue(params, "params");
        xVar.sendLuaCall(eventName, params, new b(promise));
    }

    public final void i(JSONObject json, Promise promise) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ((n) k74.i.INSTANCE.a(n.class)).cancelMapDownload(json.optString("mapId"));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        promise.resolve(jSONObject.toString());
    }

    public final void l(JSONObject jsonParam, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonParam, "jsonParam");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "common dispatchEvent - " + jsonParam);
        String optString = jsonParam.optString(AdMetricTag.EVENT_NAME);
        if (TextUtils.isEmpty(optString)) {
            optString = jsonParam.optString("event");
        }
        boolean z16 = !TextUtils.isEmpty(optString);
        if (z16) {
            if (Intrinsics.areEqual(optString, "ZPlanH5StoreBuySucceed")) {
                u94.a.f438601a.a(jsonParam.optString("data"));
            } else if (Intrinsics.areEqual(optString, "ZPlanOpenSmallHomePublicAccount")) {
                ((IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class)).openSmallHomePublicAccountInfoPage();
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", z16 ? 0 : -1);
        promise.resolve(jSONObject.toString());
    }

    public final int m() {
        return ViewUtils.pxToDp(BaseApplication.context.getResources().getDimension(R.dimen.f122670));
    }

    public final void n(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "getCurrentUserInfo ");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime.getCurrentUin();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
        Card profileCardFromCache = ((IProfileDataService) runtimeService).getProfileCardFromCache(currentUin);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uin", currentUin);
        String str = profileCardFromCache != null ? profileCardFromCache.strNick : null;
        if (str == null) {
            str = w.f373306a.a();
        }
        jSONObject.put("nick", str);
        jSONObject.put("gender", Short.valueOf(profileCardFromCache != null ? profileCardFromCache.shGender : (short) -1));
        ((IZPlanChangeFriendApi) QRoute.api(IZPlanChangeFriendApi.class)).getUserAvatar(currentUin, new c(currentUin, promise, jSONObject));
    }

    public final JSONArray o(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONArray optJSONArray = json.optJSONArray("productIds");
        QLog.i("HippyEventDeleage", 1, "getDesignerDraft:: productIds:" + optJSONArray);
        JSONArray a16 = kc4.a.f412032a.a(optJSONArray);
        QLog.i("HippyEventDeleage", 1, "getDesignerDraft:: result: " + a16);
        return a16;
    }

    public final String p() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("zplanAll", q(MaintEntryType.ALL));
        jSONObject.put("smallHome", q(MaintEntryType.SMALL_HOME));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", 0);
        jSONObject2.put("data", jSONObject);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026ata)\n        }.toString()");
        return jSONObject3;
    }

    public final int r() {
        return ViewUtils.pxToDp(ImmersiveUtils.getStatusBarHeight(BaseApplication.context));
    }

    public final void s(JSONObject jsonParam, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonParam, "jsonParam");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "go to guild");
        new SuitFeedViewModel().T1(new d(new Ref.ObjectRef()));
    }

    public final int t(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "handleH5Data json:" + json);
        String business = json.optString("business");
        String method = json.optString("method");
        String optString = json.optString("params");
        IZplanHandleApi iZplanHandleApi = (IZplanHandleApi) QRoute.api(IZplanHandleApi.class);
        Intrinsics.checkNotNullExpressionValue(business, "business");
        Intrinsics.checkNotNullExpressionValue(method, "method");
        iZplanHandleApi.handleDataToUE(business, method, optString);
        return 0;
    }

    public final void u(JSONObject json, final Promise promise) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "isSupprotZplan " + json);
        final int optInt = json.optInt("appId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("HippyEventDeleage", 1, "isSupportZPlan appRuntime is null");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSupport", false);
            promise.reject(jSONObject.toString());
            return;
        }
        uk3.g.f439121a.e(optInt, peekAppRuntime.getLongAccountUin(), new nk3.n() { // from class: com.tencent.mobileqq.zootopia.webview.b
            @Override // nk3.n
            public final void a(AccessibleDetail accessibleDetail) {
                JSEventDelegate.v(optInt, promise, accessibleDetail);
            }
        });
    }

    public final int w(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "launchScheme json:" + json);
        String schemeUrl = json.optString("schemeUrl");
        Intrinsics.checkNotNullExpressionValue(schemeUrl, "schemeUrl");
        if (schemeUrl.length() == 0) {
            QLog.e("HippyEventDeleage", 1, "launchScheme error : schemeUrl must not be empty");
            return -1;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, schemeUrl);
        return 0;
    }

    public final int x(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "notifyEvent => " + json);
        int optInt = json.optInt("actionType");
        json.optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        if (optInt == 1) {
            yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
            return 0;
        }
        QLog.e("HippyEventDeleage", 1, "not support yet");
        return -1;
    }

    public final void y(JSONObject h5DataJson, Promise promise) {
        Intrinsics.checkNotNullParameter(h5DataJson, "h5DataJson");
        Intrinsics.checkNotNullParameter(promise, "promise");
        int optInt = h5DataJson.optInt("status");
        JSONObject optJSONObject = h5DataJson.optJSONObject("extraInfo");
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanNotifyH5MediaStatusEvent(new ZPlanModH5MediaStatusData(optInt, optJSONObject != null ? optJSONObject.optInt("stopReason") : 0, optJSONObject != null ? optJSONObject.optDouble("stopPlayPosition", 0.0d) : 0.0d)), true);
        if (!TextUtils.isEmpty(promise.getCallbackId())) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            promise.resolve(jSONObject.toString());
            return;
        }
        QLog.i("HippyEventDeleage", 1, "notifyH5MediaStatusUpdated callbackId empty, skip callback");
    }

    public final int O() {
        QLog.i("HippyEventDeleage", 1, "refreshReserveList json:");
        QRouteApi api = QRoute.api(IZplanHandleApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanHandleApi::class.java)");
        IZplanHandleApi.b.a((IZplanHandleApi) api, IZplanHandleApi.BUSINESS_RESERVE, IZplanHandleApi.METHOD_REFRESH_RESERVE, null, 4, null);
        return 0;
    }

    private final long j(Date date) {
        return (date != null ? date.getTime() : 0L) / 1000;
    }

    public final int F(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.i("HippyEventDeleage", 1, "openSameStylePreviewPage json:" + json);
        String taskId = json.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        String optString = json.optString("tag");
        if (optString == null) {
            optString = "";
        }
        int optInt = json.optInt("templateId");
        String jumpFrom = json.optString("jumpFrom");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(taskId)) {
            Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
            hashMap.put("taskid", taskId);
        }
        if (!TextUtils.isEmpty(optString)) {
            hashMap.put("tag", optString);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_extra_params", hashMap);
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Source source = Source.H5;
        Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null));
        bundle.putInt("templateId", optInt);
        String buildPageScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildPageScheme(ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null), 3, bundle);
        QLog.i("HippyEventDeleage", 1, "openSameStylePreviewPage scheme:" + buildPageScheme);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, buildPageScheme);
        return 0;
    }

    public final int z(JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        int optInt = params.optInt("resourceId");
        boolean optBoolean = params.optBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, false);
        JSONObject optJSONObject = params.optJSONObject("extraParam");
        Map<String, Object> b16 = optJSONObject != null ? com.tencent.mobileqq.ark.util.i.b(optJSONObject) : null;
        String jumpFrom = params.optString("jumpFrom");
        QLog.i("HippyEventDeleage", 1, "openDetail id " + optInt + " download " + optBoolean + " extra " + optJSONObject);
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZootopiaSource.Companion companion2 = ZootopiaSource.INSTANCE;
        Source source = Source.H5;
        Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
        ZootopiaSource d16 = ZootopiaSource.Companion.d(companion2, source, jumpFrom, null, 4, null);
        Bundle bundle = new Bundle();
        bundle.putInt("mapId", optInt);
        bundle.putSerializable("detail_config", new ZootopiaDetailFragment.Config(0, false, false, optBoolean, null, null, false, b16, 119, null));
        Unit unit = Unit.INSTANCE;
        ZootopiaActivity.Companion.c(companion, context, ZootopiaDetailFragmentV2.class, d16, bundle, false, 16, null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W() {
        QQToastUtil.showQQToast(R.string.xj6);
    }

    public static /* synthetic */ void U(JSEventDelegate jSEventDelegate, JSONObject jSONObject, Promise promise, Activity activity, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            activity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "getTopActivity()");
        }
        jSEventDelegate.T(jSONObject, promise, activity);
    }

    private final int a0(Integer downloadStatus) {
        boolean z16 = true;
        if (downloadStatus != null && downloadStatus.intValue() == 1) {
            return 1;
        }
        int i3 = 2;
        if (!((downloadStatus != null && downloadStatus.intValue() == 2) || (downloadStatus != null && downloadStatus.intValue() == 3))) {
            i3 = 4;
            if ((downloadStatus == null || downloadStatus.intValue() != 4) && (downloadStatus == null || downloadStatus.intValue() != 8)) {
                z16 = false;
            }
            if (z16) {
                return 3;
            }
            if (downloadStatus == null || downloadStatus.intValue() != 5) {
                return (downloadStatus != null && downloadStatus.intValue() == 6) ? 5 : 0;
            }
        }
        return i3;
    }

    public final void A(JSONObject params, final Promise promise) {
        Map<String, ? extends Object> hashMap;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyEventDeleage", 1, "openMap => " + params);
        String optString = params.optString("jumpSrc");
        String optString2 = params.optString("jumpMsg");
        params.optBoolean("nativeHanleError", true);
        String jumpFrom = params.optString("jumpFrom");
        final int optInt = params.optInt("resourceId");
        JSONObject optJSONObject = params.optJSONObject("extraParam");
        if (optJSONObject != null) {
            hashMap = com.tencent.mobileqq.ark.util.i.b(optJSONObject);
        } else {
            hashMap = new HashMap<>();
        }
        Map<String, ? extends Object> map = hashMap;
        map.put("jumpSrc", optString);
        map.put("jumpMsg", optString2);
        QLog.i("HippyEventDeleage", 1, "openMap id " + optInt + " extra " + optJSONObject);
        si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Source source = Source.H5;
        Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
        cVar.u(optInt, ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null), map, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.webview.JSEventDelegate$openMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                invoke2(enterModCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("HippyEventDeleage", 1, "openMap " + optInt + " result " + result.getResultCode());
                Promise promise2 = promise;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", CheckResultDefaultProcessor.f331386a.d(result.getResultCode()));
                promise2.resolve(jSONObject.toString());
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/webview/JSEventDelegate$e", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements IVasNativePayManager.PayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f329799a;

        e(Promise promise) {
            this.f329799a = promise;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("result", "1");
                jSONObject.put("msg", "\u6253\u5f00\u652f\u4ed8\u9762\u677f\u5931\u8d25");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            QLog.e("HippyEventDeleage", 1, "openRechargePanel \u6253\u5f00\u652f\u4ed8\u9762\u677f\u5931\u8d25");
            this.f329799a.reject(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "1");
                jSONObject.put("result", "0");
                jSONObject.put("msg", "\u652f\u4ed8\u6210\u529f");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            QLog.i("HippyEventDeleage", 1, "openRechargePanel \u652f\u4ed8\u6210\u529f");
            this.f329799a.resolve(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
        }
    }
}
