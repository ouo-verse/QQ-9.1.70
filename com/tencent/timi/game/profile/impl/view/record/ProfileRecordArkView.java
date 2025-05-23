package com.tencent.timi.game.profile.impl.view.record;

import am4.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.profile.impl.view.record.ProfileRecordArkView;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.ap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$GetArkMsgBodyRsp;
import ug4.b;
import un4.d;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010A\u001a\u00020\b\u00a2\u0006\u0004\b<\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J:\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u001f\u001a\u00020\u0004H\u0014J\b\u0010 \u001a\u00020\u0004H\u0014R\u0014\u0010#\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\"R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010)R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", h.F, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", VirtualAppProxy.KEY_GAME_ID, "", "arkString", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "i", "r", "firstPosition", "secondPosition", "l", "param", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", ReportConstant.COSTREPORT_PREFIX, "", "reportMap", "pageReport", "", "isMaster", "j", "k", "f", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "d", "Ljava/lang/String;", "TAG", "e", "arkAppName", "Lam4/a;", "Lam4/a;", "profileRecordArkModeInfo", "Z", "arkRegistered", "isDestroyed", "Ljava/util/Map;", "reportParamMap", BdhLogUtil.LogTag.Tag_Conn, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "D", "reportPageName", "E", "Lnr2/ap;", UserInfo.SEX_FEMALE, "Lnr2/ap;", "binding", "Lcom/tencent/mobileqq/ark/module/g;", "G", "Lcom/tencent/mobileqq/ark/module/g;", "arkListener", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ProfileRecordArkView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String reportPageName;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ap binding;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final g arkListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String arkAppName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private am4.a profileRecordArkModeInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean arkRegistered;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, String> reportParamMap;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView$a", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "p0", "p1", "", "p2", "", "p3", "", "onLoadFailed", "onLoadState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ArkViewImplement.LoadCallback {
        a() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int p06, int p16, @Nullable String p26, boolean p36) {
            l.e(ProfileRecordArkView.this.TAG, "onLoadFailed " + p06 + " " + p16 + " " + p26 + " " + p36);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int p06) {
            l.b(ProfileRecordArkView.this.TAG, "onLoadState " + p06);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetArkMsgBodyRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379023b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379024c;

        b(int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f379023b = i3;
            this.f379024c = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable UserProxyCmdOuterClass$GetArkMsgBodyRsp result) {
            PBStringField pBStringField;
            String str;
            if (result != null && (pBStringField = result.body_json) != null && (str = pBStringField.get()) != null) {
                ProfileRecordArkView.this.i(this.f379023b, str, this.f379024c);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            f.d(true, "\u6570\u636e\u51fa\u9519");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRecordArkView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ProfileRecordArkView_";
        this.arkAppName = "";
        this.reportPageName = "";
        ap f16 = ap.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.arkListener = new g() { // from class: am4.b
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str, String str2, String str3) {
                boolean g16;
                g16 = ProfileRecordArkView.g(ProfileRecordArkView.this, str, str2, str3);
                return g16;
            }
        };
        h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(ProfileRecordArkView this$0, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i(this$0.TAG, "appName:" + str + ", eventName:" + str2 + ", params:" + str3);
        if (Intrinsics.areEqual(str, this$0.arkAppName) && Intrinsics.areEqual(str2, "ark_change_mode")) {
            this$0.m(str3);
            this$0.q();
            return true;
        }
        return true;
    }

    private final void h(Context context) {
        this.binding.f420854b.setBorderType(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int gameId, String arkString, CommonOuterClass$QQUserId userId) {
        JSONObject jSONObject;
        String str;
        if (arkString != null && !TextUtils.isEmpty(arkString)) {
            tl4.a.INSTANCE.a().e(f(gameId, userId), arkString);
            ArkView.InitInfo initInfo = new ArkView.InitInfo();
            try {
                JSONObject jSONObject2 = new JSONObject(arkString);
                String optString = jSONObject2.optString("app");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"app\")");
                this.arkAppName = optString;
                initInfo.appID = jSONObject2.optString("app");
                initInfo.view = jSONObject2.optString("view");
                JSONObject optJSONObject = jSONObject2.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                String str2 = null;
                if (optJSONObject != null) {
                    jSONObject = optJSONObject.optJSONObject(DownloadInfo.spKey_Config);
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject.put("arkuin", this.binding.f420854b.getMUniqueId());
                }
                if (optJSONObject == null || (str = optJSONObject.toString()) == null) {
                    str = "";
                }
                initInfo.meta = str;
                o();
                String str3 = this.TAG;
                if (optJSONObject != null) {
                    str2 = optJSONObject.toString();
                }
                l.b(str3, "loadArkData " + str2);
            } catch (JSONException e16) {
                l.e(this.TAG, "shareArkToQQFriend error " + e16);
            }
            this.binding.f420854b.j(initInfo, new a());
            return;
        }
        l.e(this.TAG, "loadArkData arkString == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int firstPosition, int secondPosition) {
        am4.a aVar = this.profileRecordArkModeInfo;
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("arkuin", this.binding.f420854b.getMUniqueId());
            jSONObject.put("selectArr", aVar.a(firstPosition, secondPosition));
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(this.arkAppName, "", "native_change_mode_cb", jSONObject.toString());
            l.i(this.TAG, "onModeSelected:" + this.arkAppName + ", eventName:" + jSONObject);
        }
    }

    private final void m(String param) {
        if (param != null && !TextUtils.isEmpty(param) && !this.isDestroyed) {
            this.profileRecordArkModeInfo = am4.a.INSTANCE.c(param);
            post(new Runnable() { // from class: am4.c
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileRecordArkView.n(ProfileRecordArkView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ProfileRecordArkView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDestroyed) {
            this$0.r();
        }
    }

    private final void o() {
        if (this.arkRegistered) {
            return;
        }
        d.f439289a.o(this.arkAppName, this.binding.f420854b.getMUniqueId(), this.arkListener);
        this.arkRegistered = true;
    }

    private final void p() {
        String str;
        if (this.isMaster) {
            str = "em_yes_myprofile_panel_record";
        } else {
            str = "em_yes_userprofile_panel_record";
        }
        String str2 = str;
        Map<String, String> map = this.reportParamMap;
        if (map != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.b((ug4.b) b16, this, false, null, str2, map, 6, null);
        }
    }

    private final void q() {
        String str;
        if (this.isMaster) {
            str = "em_yes_myprofile_panel_game_mode";
        } else {
            str = "em_yes_userprofile_panel_game_mode";
        }
        String str2 = str;
        Map<String, String> map = this.reportParamMap;
        if (map != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.b((ug4.b) b16, this, false, null, str2, map, 6, null);
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            bVar.reportEvent("clck", this, map);
        }
    }

    private final void r() {
        List<a.b> c16;
        c cVar = new c();
        am4.a aVar = this.profileRecordArkModeInfo;
        if (aVar != null && (c16 = aVar.c()) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            am4.a aVar2 = this.profileRecordArkModeInfo;
            Intrinsics.checkNotNull(aVar2);
            vl4.c cVar2 = new vl4.c(context, c16, aVar2.getColumns(), this.reportParamMap, this.qqUserId, this.reportPageName);
            cVar2.x0(cVar);
            cVar2.show();
        }
    }

    private final void s() {
        if (this.arkRegistered) {
            d.f439289a.s(this.arkListener);
        }
    }

    @NotNull
    public final String f(int gameId, @NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return userId.uid.get() + "_" + userId.user_from.get() + "_" + gameId;
    }

    public final void j(int gameId, @NotNull CommonOuterClass$QQUserId userId, @NotNull Map<String, String> reportMap, @NotNull String pageReport, boolean isMaster) {
        long j3;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(pageReport, "pageReport");
        this.isMaster = isMaster;
        this.reportPageName = pageReport;
        this.qqUserId = userId;
        this.reportParamMap = reportMap;
        p();
        k(gameId, userId);
        this.arkAppName = "";
        PBUInt64Field pBUInt64Field = userId.uid;
        if (pBUInt64Field != null) {
            j3 = pBUInt64Field.get();
        } else {
            j3 = 0;
        }
        ((sm4.a) mm4.b.b(sm4.a.class)).a0(2, gameId, j3, userId, new b(gameId, userId));
    }

    public final void k(int gameId, @NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String a16 = tl4.a.INSTANCE.a().a(f(gameId, userId));
        if (a16 != null) {
            i(gameId, a16, userId);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.isDestroyed = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDestroyed = true;
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRecordArkView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ProfileRecordArkView_";
        this.arkAppName = "";
        this.reportPageName = "";
        ap f16 = ap.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.arkListener = new g() { // from class: am4.b
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str, String str2, String str3) {
                boolean g16;
                g16 = ProfileRecordArkView.g(ProfileRecordArkView.this, str, str2, str3);
                return g16;
            }
        };
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRecordArkView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ProfileRecordArkView_";
        this.arkAppName = "";
        this.reportPageName = "";
        ap f16 = ap.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.arkListener = new g() { // from class: am4.b
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str, String str2, String str3) {
                boolean g16;
                g16 = ProfileRecordArkView.g(ProfileRecordArkView.this, str, str2, str3);
                return g16;
            }
        };
        h(context);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView$c", "Lvl4/f;", "", "firstPosition", "secondPosition", "", "a", "cancel", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements vl4.f {
        c() {
        }

        @Override // vl4.f
        public void a(int firstPosition, int secondPosition) {
            if (firstPosition >= 0) {
                ProfileRecordArkView.this.l(firstPosition, secondPosition);
            }
        }

        @Override // vl4.f
        public void cancel() {
        }
    }
}
