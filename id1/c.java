package id1;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.temp.api.IArkTempApi;
import com.tencent.mobileqq.gamecenter.api.IGameMallAIOApi;
import com.tencent.mobileqq.gamecenter.api.d;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMallArkContainer;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$GetShopArkRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMallAIORecommend$ShopArk;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010+\u00a8\u00061"}, d2 = {"Lid1/c;", "Lcom/tencent/aio/main/businesshelper/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "k", "j", h.F, "g", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/GameMallAIORecommend$ShopArk;", "arkInfo", DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/Integer;", "chatType", "e", "Ljava/lang/String;", "peerUid", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/ark/open/ArkView;", "Lcom/tencent/ark/open/ArkView;", "mArkView", "Z", "hasDestroy", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "mRootLayout", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer chatType = 0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String peerUid = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArkView mArkView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasDestroy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mRootLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"id1/c$b", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errorCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements ArkViewImplement.LoadCallback {
        b() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int state, int errorCode, @Nullable String msg2, boolean canRetry) {
            QLog.e("GameMallPubHelper", 1, "onLoadFailed state:" + state + " errorCode:" + errorCode + " msg:" + msg2);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int state) {
            Integer num;
            ArkView arkView = c.this.mArkView;
            if (arkView != null) {
                num = Integer.valueOf(arkView.getHeight());
            } else {
                num = null;
            }
            QLog.i("GameMallPubHelper", 1, "onLoadState state:" + state + " arkHeight:" + num);
            if (state == 1) {
                c.this.o();
            }
        }
    }

    private final void g() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(83.0f));
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        GameMallArkContainer gameMallArkContainer = new GameMallArkContainer(sMobileQQ);
        gameMallArkContainer.setVisibility(4);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new PAInputIntent.AddInputContainerAboveViewIntent(gameMallArkContainer, layoutParams));
        }
        this.mRootLayout = gameMallArkContainer;
    }

    private final void h() {
        QLog.i("GameMallPubHelper", 2, "[doOnDestroy]");
        this.hasDestroy = true;
        ArkView arkView = this.mArkView;
        if (arkView != null) {
            arkView.onDestroy();
        }
        p();
        this.mRootLayout = null;
        this.mArkView = null;
    }

    private final void i() {
        QLog.i("GameMallPubHelper", 2, "[doOnInitUI]");
        this.hasDestroy = false;
        g();
        q();
    }

    private final void j() {
        QLog.i("GameMallPubHelper", 2, "[doOnPause]");
        ArkView arkView = this.mArkView;
        if (arkView != null) {
            arkView.onPause();
        }
    }

    private final void k() {
        QLog.i("GameMallPubHelper", 2, "[doOnResume]");
        ArkView arkView = this.mArkView;
        if (arkView != null) {
            arkView.onResume();
        }
    }

    private final boolean m() {
        Integer num = this.chatType;
        if (num != null && num.intValue() == 103 && Intrinsics.areEqual(this.peerUid, "u_BWXiWqJtbtbmrr2h5LELQg")) {
            return true;
        }
        return false;
    }

    private final void n(GameMallAIORecommend$ShopArk arkInfo) {
        if (!this.hasDestroy && this.mArkView == null && !TextUtils.isEmpty(arkInfo.app.get()) && !TextUtils.isEmpty(arkInfo.view.get())) {
            QRouteApi api = QRoute.api(IArkEnvironment.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IArkEnvironment::class.java)");
            ((IArkEnvironment) api).initMultiProcEnv((IArkEnvDelegate) QRoute.api(IArkEnvDelegate.class), false);
            String str = arkInfo.app.get();
            String str2 = arkInfo.view.get();
            String str3 = arkInfo.ver.get();
            String str4 = arkInfo.config.get();
            String str5 = arkInfo.meta.get();
            ArkView arkView = new ArkView(MobileQQ.sMobileQQ, null);
            this.mArkView = arkView;
            arkView.setBorderType(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.topMargin = -ViewUtils.dpToPx(17.0f);
            RelativeLayout relativeLayout = this.mRootLayout;
            if (relativeLayout != null) {
                relativeLayout.addView(this.mArkView, layoutParams);
            }
            String currentAppConfig = ((IArkTempApi) QRoute.api(IArkTempApi.class)).getCurrentAppConfig();
            try {
                JSONObject jSONObject = new JSONObject(currentAppConfig);
                JSONObject jSONObject2 = new JSONObject(str4);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str6 = (String) keys.next();
                    jSONObject.put(str6, jSONObject2.opt(str6));
                }
                currentAppConfig = jSONObject.toString();
            } catch (Exception e16) {
                QLog.e("GameMallPubHelper", 1, e16, new Object[0]);
            }
            String str7 = currentAppConfig;
            QLog.i("GameMallPubHelper", 2, "currentAppConfig:" + str7);
            ArkView arkView2 = this.mArkView;
            if (arkView2 != null) {
                arkView2.load(str, str2, str3, str5, str7, new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (this.hasDestroy) {
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new PAInputIntent.InputContainerAboveViewParentMarginIntent(0, 0, 0, -ViewUtils.dpToPx(12.0f)));
        }
    }

    private final void p() {
        ((IGameMallAIOApi) QRoute.api(IGameMallAIOApi.class)).removeGameMallAIOArkInfoCallback();
    }

    private final void q() {
        QRouteApi api = QRoute.api(IGameMallAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IGameMa\u2026Api::class.java\n        )");
        ((IGameMallAIOApi) api).reqGameMallAIOArkInfo(new d() { // from class: id1.a
            @Override // com.tencent.mobileqq.gamecenter.api.d
            public final void a(long j3, String str, GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp) {
                c.r(c.this, j3, str, gameMallAIORecommend$GetShopArkRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final c this$0, long j3, String str, final GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 == 0 && gameMallAIORecommend$GetShopArkRsp != null && gameMallAIORecommend$GetShopArkRsp.ark.get() != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: id1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.s(c.this, gameMallAIORecommend$GetShopArkRsp);
                }
            });
        } else {
            QLog.e("GameMallPubHelper", 1, "requestArkInfo failed to get Ark info", " ret:", Long.valueOf(j3), " errMsg:", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(c this$0, GameMallAIORecommend$GetShopArkRsp gameMallAIORecommend$GetShopArkRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GameMallAIORecommend$ShopArk gameMallAIORecommend$ShopArk = gameMallAIORecommend$GetShopArkRsp.ark.get();
        Intrinsics.checkNotNullExpressionValue(gameMallAIORecommend$ShopArk, "rsp.ark.get()");
        this$0.n(gameMallAIORecommend$ShopArk);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350633f1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GameMallPubHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        AIOContact aIOContact;
        Integer num;
        AIOSession r16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        String str = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        if (g16 != null && (r16 = g16.r()) != null) {
            aIOContact = r16.c();
        } else {
            aIOContact = null;
        }
        if (aIOContact != null) {
            num = Integer.valueOf(aIOContact.e());
        } else {
            num = null;
        }
        this.chatType = num;
        if (aIOContact != null) {
            str = aIOContact.j();
        }
        this.peerUid = str;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (m()) {
            if (state != 0) {
                if (state != 3) {
                    if (state != 8) {
                        if (state == 12) {
                            h();
                            return;
                        }
                        return;
                    }
                    j();
                    return;
                }
                k();
                return;
            }
            i();
        }
    }
}
