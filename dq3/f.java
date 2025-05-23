package dq3;

import android.os.Bundle;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.k;
import com.tencent.open.agent.util.t;
import com.tencent.qconn.protofile.GetPromotePage$GetLoginPromotePageRsp;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteGroupView;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitPromotePageRsp;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitResultItem;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qphone.base.BaseConstants;
import com.vivo.push.PushClientConstants;
import dq3.f;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eq3.CommonReqParams;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<JD\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007JD\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002JL\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0007J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0006\u0010\u001a\u001a\u00020\u000eR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R(\u0010.\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010-R(\u00101\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b/\u0010 \u001a\u0004\b0\u0010-R(\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b2\u0010 \u001a\u0004\b3\u0010-R8\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u00142\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Ldq3/f;", "", "", PushClientConstants.TAG_PKG_NAME, "hostAppId", "proxyAppId", "proxyToken", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/open/model/a;", "account", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isStudyMode", "r", "", "data", "u", "", "Lcom/tencent/qconn/protofile/SubmitPromotePage$SubmitResultItem;", "submitResultItemList", HippyTKDListViewAdapter.X, "v", "w", "t", "Leq3/a;", "b", "Leq3/a;", "commonReqParams", "c", "Ljava/lang/String;", "state", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "d", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "signature", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "showRecommendFragment", "<set-?>", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "bannerIconUrl", "g", "o", "bannerWord", h.F, DomainData.DOMAIN_NAME, "bannerTitle", "Lcom/tencent/qconn/protofile/OpenSdkRecCommon$PromoteGroupView;", "i", "Ljava/util/List;", "p", "()Ljava/util/List;", "groups", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ByteStringMicro signature;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String bannerIconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String bannerWord;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String bannerTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<OpenSdkRecCommon$PromoteGroupView> groups;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f394643a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CommonReqParams commonReqParams = new CommonReqParams(null, null, null, null, null, null, 63, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String state = String.valueOf(System.currentTimeMillis());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean showRecommendFragment = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"dq3/f$a", "Lcom/tencent/open/agent/util/k$a;", "Lkotlin/Pair;", "", "Lcom/tencent/qconn/protofile/appType$LoginSig;", BaseConstants.CMD_MSFCOMMAND, "", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f394652a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f394653b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f394654c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f394655d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f394656e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f394657f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f394658g;

        a(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, boolean z16) {
            this.f394652a = str;
            this.f394653b = str2;
            this.f394654c = str3;
            this.f394655d = str4;
            this.f394656e = bundle;
            this.f394657f = aVar;
            this.f394658g = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String cmd, boolean z16, com.tencent.open.model.a aVar, int i3, boolean z17, Bundle bundle) {
            Intrinsics.checkNotNullParameter(cmd, "$cmd");
            t.b("AuthRecommendManager", "getPromotePage onReceive isSuccess=", Boolean.valueOf(z17), ", type=", Integer.valueOf(i3), ", cmd=", cmd);
            if (!z17) {
                f.f394643a.w();
                return;
            }
            byte[] x16 = g.x(bundle, z16, aVar);
            if (x16 == null) {
                f.f394643a.w();
                t.e("AuthRecommendManager", "getPromotePage onReceive data is null");
            } else {
                f.f394643a.u(x16);
            }
        }

        @Override // com.tencent.open.agent.util.k.a
        public void a(@NotNull Pair<String, appType$LoginSig> msfCommand) {
            Intrinsics.checkNotNullParameter(msfCommand, "msfCommand");
            final String first = msfCommand.getFirst();
            final boolean areEqual = Intrinsics.areEqual("QQConnectLogin.get_promote_page_emp", first);
            NewAuthDataSourceImpl newAuthDataSourceImpl = new NewAuthDataSourceImpl();
            f fVar = f.f394643a;
            f.state = String.valueOf(System.currentTimeMillis());
            t.b("AuthRecommendManager", "getPromotePage cmd:" + first + ", state:" + f.state);
            f.commonReqParams = new CommonReqParams(this.f394652a, this.f394653b, this.f394654c, this.f394655d, this.f394656e, this.f394657f);
            CommonReqParams commonReqParams = f.commonReqParams;
            Object[] objArr = {msfCommand.getFirst(), msfCommand.getSecond()};
            String str = f.state;
            boolean z16 = this.f394658g;
            final com.tencent.open.model.a aVar = this.f394657f;
            newAuthDataSourceImpl.f(commonReqParams, objArr, str, z16, new com.tencent.open.appcommon.d() { // from class: dq3.e
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z17, Bundle bundle) {
                    f.a.c(first, areEqual, aVar, i3, z17, bundle);
                }
            });
        }
    }

    f() {
    }

    @JvmStatic
    public static final void k(@Nullable final String pkgName, @Nullable final String hostAppId, @Nullable final String proxyAppId, @Nullable final String proxyToken, @Nullable final Bundle bundle, @Nullable final com.tencent.open.model.a account) {
        ThreadManagerV2.excute(new Runnable() { // from class: dq3.c
            @Override // java.lang.Runnable
            public final void run() {
                f.l(pkgName, hostAppId, proxyAppId, proxyToken, bundle, account);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar) {
        f394643a.q(str, str2, str3, str4, bundle, aVar);
    }

    private final void q(final String pkgName, final String hostAppId, final String proxyAppId, final String proxyToken, final Bundle bundle, final com.tencent.open.model.a account) {
        w();
        QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_get_study_mode", new Bundle(), new EIPCResultCallback() { // from class: dq3.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                f.s(pkgName, hostAppId, proxyAppId, proxyToken, bundle, account, eIPCResult);
            }
        });
    }

    private final void r(String pkgName, String hostAppId, String proxyAppId, String proxyToken, Bundle bundle, com.tencent.open.model.a account, boolean isStudyMode) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (account != null) {
            str = account.f341678a;
        } else {
            str = null;
        }
        g.z(peekAppRuntime, str, "QQConnectLogin.get_promote_page", "QQConnectLogin.get_promote_page_emp", new a(pkgName, hostAppId, proxyAppId, proxyToken, bundle, account, isStudyMode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, EIPCResult eIPCResult) {
        Bundle bundle2;
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.code == 0) {
            z16 = true;
        }
        if (z16 && (bundle2 = eIPCResult.data) != null) {
            f394643a.r(str, str2, str3, str4, bundle, aVar, bundle2.getBoolean("key_study_mode"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(byte[] data) {
        boolean z16;
        boolean z17;
        Integer num;
        try {
            GetPromotePage$GetLoginPromotePageRsp mergeFrom = new GetPromotePage$GetLoginPromotePageRsp().mergeFrom(data);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "response.mergeFrom(data)");
            GetPromotePage$GetLoginPromotePageRsp getPromotePage$GetLoginPromotePageRsp = mergeFrom;
            if (!getPromotePage$GetLoginPromotePageRsp.result.ret.has()) {
                w();
                t.e("AuthRecommendManager", "onGetPromotePage response.result.ret has false");
                return;
            }
            int i3 = getPromotePage$GetLoginPromotePageRsp.result.ret.get();
            if (i3 != 0) {
                w();
                t.e("AuthRecommendManager", "onGetPromotePage response: " + i3 + ", " + getPromotePage$GetLoginPromotePageRsp.result.f342464msg.get());
                return;
            }
            bannerIconUrl = getPromotePage$GetLoginPromotePageRsp.promote_info.banner.icon_url.get();
            bannerWord = getPromotePage$GetLoginPromotePageRsp.promote_info.banner.prompt_word.get();
            bannerTitle = getPromotePage$GetLoginPromotePageRsp.promote_info.banner.prompt_title.get();
            List<OpenSdkRecCommon$PromoteGroupView> list = getPromotePage$GetLoginPromotePageRsp.promote_info.groups.get();
            groups = list;
            AtomicBoolean atomicBoolean = showRecommendFragment;
            if (list != null && list.size() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            atomicBoolean.set(z17);
            signature = getPromotePage$GetLoginPromotePageRsp.signature.get();
            Object[] objArr = new Object[1];
            String str = bannerWord;
            String str2 = bannerTitle;
            List<OpenSdkRecCommon$PromoteGroupView> list2 = groups;
            if (list2 != null) {
                num = Integer.valueOf(list2.size());
            } else {
                num = null;
            }
            objArr[0] = "onGetPromotePage , bannerWord:" + str + ", bannerTitle:" + str2 + ", groups:" + num;
            t.b("AuthRecommendManager", objArr);
        } catch (Exception e16) {
            t.d("AuthRecommendManager", "onGetPromotePage Exception", e16);
            w();
        }
    }

    private final void v(byte[] data) {
        SubmitPromotePage$SubmitPromotePageRsp submitPromotePage$SubmitPromotePageRsp = new SubmitPromotePage$SubmitPromotePageRsp();
        try {
            submitPromotePage$SubmitPromotePageRsp.mergeFrom(data);
            if (!submitPromotePage$SubmitPromotePageRsp.result.ret.has()) {
                t.e("AuthRecommendManager", "onSubmitPromotePage response.result.ret has false");
                return;
            }
            t.f("AuthRecommendManager", "onSubmitPromotePage response: " + submitPromotePage$SubmitPromotePageRsp.result.ret.get() + ", " + submitPromotePage$SubmitPromotePageRsp.result.f342464msg.get());
        } catch (Exception e16) {
            t.d("AuthRecommendManager", "onSubmitPromotePage Exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        t.f("AuthRecommendManager", "reset");
        showRecommendFragment.set(false);
    }

    @JvmStatic
    public static final void x(@Nullable final List<SubmitPromotePage$SubmitResultItem> submitResultItemList) {
        boolean z16;
        String str;
        f394643a.w();
        List<SubmitPromotePage$SubmitResultItem> list = submitResultItemList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            t.f("AuthRecommendManager", "submitPromotePage submitResultItemList isNullOrEmpty");
            return;
        }
        t.f("AuthRecommendManager", "submitPromotePage submitResultItemList " + submitResultItemList.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.open.model.a account = commonReqParams.getAccount();
        if (account != null) {
            str = account.f341678a;
        } else {
            str = null;
        }
        g.z(peekAppRuntime, str, "QQConnectLogin.submit_promote_page", "QQConnectLogin.submit_promote_page_emp", new k.a() { // from class: dq3.a
            @Override // com.tencent.open.agent.util.k.a
            public final void a(Pair pair) {
                f.y(submitResultItemList, pair);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(List list, Pair msfCommand) {
        Intrinsics.checkNotNullParameter(msfCommand, "msfCommand");
        final String str = (String) msfCommand.getFirst();
        final boolean areEqual = Intrinsics.areEqual("QQConnectLogin.submit_promote_page_emp", str);
        t.b("AuthRecommendManager", "submitPromotePage cmd:" + str + " state:" + state);
        new NewAuthDataSourceImpl().a(commonReqParams, new Object[]{msfCommand.getFirst(), msfCommand.getSecond()}, state, list, signature, new com.tencent.open.appcommon.d() { // from class: dq3.b
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                f.z(str, areEqual, i3, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(String cmd, boolean z16, int i3, boolean z17, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cmd, "$cmd");
        t.b("AuthRecommendManager", "submitPromotePage onReceive isSuccess=", Boolean.valueOf(z17), ", type=", Integer.valueOf(i3), ", cmd=", cmd);
        if (!z17) {
            return;
        }
        byte[] x16 = g.x(bundle, z16, commonReqParams.getAccount());
        if (x16 == null) {
            t.f("AuthRecommendManager", "getPromotePage onReceive data is null");
        } else {
            f394643a.v(x16);
        }
    }

    @Nullable
    public final String m() {
        return bannerIconUrl;
    }

    @Nullable
    public final String n() {
        return bannerTitle;
    }

    @Nullable
    public final String o() {
        return bannerWord;
    }

    @Nullable
    public final List<OpenSdkRecCommon$PromoteGroupView> p() {
        return groups;
    }

    public final boolean t() {
        t.f("AuthRecommendManager", "getShowRecommendFragment " + showRecommendFragment.get());
        return showRecommendFragment.get();
    }
}
