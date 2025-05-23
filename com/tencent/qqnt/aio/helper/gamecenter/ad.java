package com.tencent.qqnt.aio.helper.gamecenter;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.data.SayHiState;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMsgBottomBarEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting$QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.helper.gamecenter.ad;
import com.tencent.qqnt.event.IceBreakEvent;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 o2\u00020\u0001:\u0002pqB\u0007\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016J\u001a\u0010)\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*J\u000e\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0016J\u000e\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0016J\u0006\u00101\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000bJ\b\u00105\u001a\u0004\u0018\u00010\u000bJ\u0006\u00103\u001a\u00020\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0016H\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010DR\u0016\u0010G\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010IR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010LR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010NR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010@R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\"\u0010l\u001a\u00020c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010e\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k\u00a8\u0006r"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/ad;", "Lcom/tencent/aio/main/businesshelper/h;", "", "p", "o", "", "k", "", ViewStickEventHelper.IS_SHOW, "E", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "r", "Lcom/tencent/mobileqq/gamecenter/data/SayHiState;", "state", "Landroid/os/Bundle;", "stateData", "g", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "sayHiType", "text", "B", "", "stringList", "exclude", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "i", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "myRoldId", "friendRoleId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/GameMsgGreeting$QueryAIOGreetInfoRsp;", "sayHiInfoRsp", "y", "heightInDp", "D", "height", BdhLogUtil.LogTag.Tag_Conn, "u", "w", "v", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "onMoveToState", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mRootView", "Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "e", "Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "mGameGlobal", "f", "Z", "mIsChatAioDestroyed", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/helper/gamecenter/ad$b;", "Ljava/util/ArrayList;", "mEmojiList", "I", "mWaitReplyUiHeightInDp", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "Landroid/os/Bundle;", "mCustomParam", "Ljava/lang/String;", "mPeerUid", "Lmqq/app/AppRuntime;", UserInfo.SEX_FEMALE, "Lmqq/app/AppRuntime;", "mApp", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "G", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "mMsgApi", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "mGameSession", "mIsMetaDream", "Lcom/tencent/mvi/base/route/a;", "J", "Lcom/tencent/mvi/base/route/a;", "mAction1", "Landroid/view/View$OnClickListener;", "K", "Landroid/view/View$OnClickListener;", "mClickListener", "L", "getMEmojiClickListener", "()Landroid/view/View$OnClickListener;", "setMEmojiClickListener", "(Landroid/view/View$OnClickListener;)V", "mEmojiClickListener", "<init>", "()V", "M", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private Bundle mCustomParam;

    /* renamed from: F, reason: from kotlin metadata */
    private AppRuntime mApp;

    /* renamed from: G, reason: from kotlin metadata */
    private final IGameMsgNtApi mMsgApi;

    /* renamed from: H, reason: from kotlin metadata */
    private TempChatGameSession mGameSession;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsMetaDream;

    /* renamed from: J, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: K, reason: from kotlin metadata */
    private final View.OnClickListener mClickListener;

    /* renamed from: L, reason: from kotlin metadata */
    private View.OnClickListener mEmojiClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsChatAioDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final GameGlobalData mGameGlobal = GameGlobalData.INSTANCE.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<b> mEmojiList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mWaitReplyUiHeightInDp = 92;

    /* renamed from: E, reason: from kotlin metadata */
    private String mPeerUid = "";

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350944a;

        static {
            int[] iArr = new int[SayHiState.values().length];
            try {
                iArr[SayHiState.NORMAL_CHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SayHiState.SAY_HI_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SayHiState.SAY_HI_SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SayHiState.SAY_HI_WAIT_REPLYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SayHiState.SAY_HI_RECEIVED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f350944a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/ad$d", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/ad$e", "Lcom/tencent/mobileqq/gamecenter/api/h;", "", "retCode", "", "errMsg", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/GameMsgGreeting$QueryAIOGreetInfoRsp;", "sayHiInfoRsp", "", "a", "fromRoleId", "toRoleId", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.gamecenter.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f350946b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f350947c;

        e(String str, String str2) {
            this.f350946b = str;
            this.f350947c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ad this$0, GameMsgGreeting$QueryAIOGreetInfoRsp gameMsgGreeting$QueryAIOGreetInfoRsp) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y(gameMsgGreeting$QueryAIOGreetInfoRsp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ad this$0, String str, String str2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.A(str, str2);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.h
        public void a(long retCode, String errMsg, final GameMsgGreeting$QueryAIOGreetInfoRsp sayHiInfoRsp) {
            QLog.i("GameMsgSayHiHelper", 1, "onGetGameMsgSayHiInfo ret:" + retCode + " err:" + errMsg + " ,mIsChatAioDestroyed:" + ad.this.mIsChatAioDestroyed);
            ad.this.mGameGlobal.l(false);
            if (ad.this.mIsChatAioDestroyed || retCode != 0 || sayHiInfoRsp == null) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ad adVar = ad.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ad.e.e(ad.this, sayHiInfoRsp);
                }
            });
        }

        @Override // com.tencent.mobileqq.gamecenter.api.h
        public void b(String fromRoleId, String toRoleId) {
            QLog.i("GameMsgSayHiHelper", 2, "onReceiveSayHiMessage fromRoleId:" + fromRoleId + " toRoleId:" + toRoleId + " friendRoleId:" + this.f350946b);
            if (fromRoleId == null || !Intrinsics.areEqual(fromRoleId, this.f350946b)) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ad adVar = ad.this;
            final String str = this.f350947c;
            final String str2 = this.f350946b;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.af
                @Override // java.lang.Runnable
                public final void run() {
                    ad.e.f(ad.this, str, str2);
                }
            }, 1000L);
        }
    }

    public ad() {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        this.mMsgApi = (IGameMsgNtApi) api;
        this.mAction1 = new d();
        this.mClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ad.s(ad.this, view);
            }
        };
        this.mEmojiClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ad.t(ad.this, view);
            }
        };
    }

    private final void g(SayHiState state, Bundle stateData) {
        if (this.mRootView == null || this.mGameGlobal.getMSayHiState() == state || state == SayHiState.UNKNOWN) {
            return;
        }
        this.mGameGlobal.o(state);
        FrameLayout frameLayout = this.mRootView;
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.ydt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ayout_choose_say_hi_text)");
        View findViewById2 = frameLayout.findViewById(R.id.yff);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.layout_reply_say_hi)");
        View findViewById3 = frameLayout.findViewById(R.id.f95885g7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.text_wait_replying)");
        int i3 = c.f350944a[state.ordinal()];
        if (i3 == 1) {
            E(true);
            frameLayout.setVisibility(8);
            return;
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 == 4) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(0);
                D(this.mWaitReplyUiHeightInDp);
                return;
            }
            if (i3 != 5) {
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(8);
            D(this.mWaitReplyUiHeightInDp);
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(k(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209031", "", "", "8", "0");
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(8);
        findViewById3.setVisibility(8);
        long j3 = j(stateData);
        View findViewById4 = frameLayout.findViewById(R.id.f95675fm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.text_say_hi_tips)");
        TextView textView = (TextView) findViewById4;
        View findViewById5 = frameLayout.findViewById(R.id.f95705fp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.text_send)");
        TextView textView2 = (TextView) findViewById5;
        if (state == SayHiState.SAY_HI_DENIED && j3 > 0) {
            String string = BaseApplication.getContext().getString(R.string.f13601030, Long.valueOf(j3));
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(\n\u2026ime\n                    )");
            textView.setText(string);
            textView2.setEnabled(false);
        } else {
            textView.setText(BaseApplication.getContext().getString(R.string.f1363403w));
            textView2.setEnabled(true);
        }
        D(205);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(k(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209029", "", "", "8", "0");
    }

    private final void h() {
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        TempChatGameSession tempChatGameSession = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        this.mCustomParam = l3;
        if (l3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            l3 = null;
        }
        String string = l3.getString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, "");
        Bundle bundle = this.mCustomParam;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle = null;
        }
        String string2 = bundle.getString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, "");
        Bundle bundle2 = this.mCustomParam;
        if (bundle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle2 = null;
        }
        String string3 = bundle2.getString("key_peerId", "");
        Intrinsics.checkNotNullExpressionValue(string3, "mCustomParam.getString(C\u2026Constants.KEY_PEERID, \"\")");
        this.mPeerUid = string3;
        IGameMsgNtApi iGameMsgNtApi = this.mMsgApi;
        Bundle bundle3 = this.mCustomParam;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle3 = null;
        }
        this.mGameSession = iGameMsgNtApi.getGameSessionFromPeerUidOrJson(string3, bundle3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        sessionInfo.j(string);
        SessionInfo sessionInfo2 = this.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo2 = null;
        }
        sessionInfo2.k(string2);
        this.mGameGlobal.i();
        GameGlobalData gameGlobalData = this.mGameGlobal;
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession2 = null;
        }
        gameGlobalData.j(String.valueOf(tempChatGameSession2.gameAppId));
        TempChatGameSession tempChatGameSession3 = this.mGameSession;
        if (tempChatGameSession3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
        } else {
            tempChatGameSession = tempChatGameSession3;
        }
        this.mIsMetaDream = Intrinsics.areEqual("1112198072", String.valueOf(tempChatGameSession.gameAppId));
        p();
        if (this.mEmojiList.size() <= 0) {
            o();
        }
        A(string2, string);
        QLog.i("GameMsgSayHiHelper", 1, "[doOnCreate] friendRoleId:" + string + ",myRoleId:" + string2 + ",mPeerUid:" + this.mPeerUid + ",mIsMetaDream:" + this.mIsMetaDream);
    }

    private final void i() {
        AppRuntime appRuntime = this.mApp;
        IGameMsgManagerService iGameMsgManagerService = appRuntime != null ? (IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "") : null;
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.removeGameMsgSayHiCallback();
        }
        this.mIsChatAioDestroyed = true;
        this.mGameGlobal.i();
    }

    private final String k() {
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        return String.valueOf(tempChatGameSession.gameAppId);
    }

    private final void o() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgSayHiHelper", 2, "[initEmojiListFromBuiltIn] mIsMetaDream:" + this.mIsMetaDream);
        }
        if (this.mIsMetaDream) {
            b bVar = new b();
            bVar.f(2);
            bVar.g(R.drawable.ml6);
            String string = context.getString(R.string.f1363203u);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026dream_say_hi_trick_title)");
            bVar.h(string);
            bVar.d().add(context.getString(R.string.f1362803q));
            bVar.d().add(context.getString(R.string.f1362903r));
            bVar.d().add(context.getString(R.string.f1363003s));
            bVar.d().add(context.getString(R.string.f1363103t));
            b bVar2 = new b();
            bVar2.f(3);
            bVar2.g(R.drawable.f160130ml3);
            String string2 = context.getString(R.string.f1362203k);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_dream_say_hi_clap_title)");
            bVar2.h(string2);
            bVar2.d().add(context.getString(R.string.f1361903h));
            bVar2.d().add(context.getString(R.string.f1362003i));
            bVar2.d().add(context.getString(R.string.f1362103j));
            b bVar3 = new b();
            bVar3.f(1);
            bVar3.g(R.drawable.ml5);
            String string3 = context.getString(R.string.f1362703p);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026dream_say_hi_drool_title)");
            bVar3.h(string3);
            bVar3.d().add(context.getString(R.string.f1362303l));
            bVar3.d().add(context.getString(R.string.f1362403m));
            bVar3.d().add(context.getString(R.string.f1362503n));
            bVar3.d().add(context.getString(R.string.f1362603o));
            this.mEmojiList.add(bVar);
            this.mEmojiList.add(bVar2);
            this.mEmojiList.add(bVar3);
            return;
        }
        b bVar4 = new b();
        bVar4.f(2);
        bVar4.g(R.drawable.ml6);
        String string4 = context.getString(R.string.f1365204d);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026e_aio_say_hi_trick_title)");
        bVar4.h(string4);
        bVar4.d().add(context.getString(R.string.f13646048));
        bVar4.d().add(context.getString(R.string.f13647049));
        bVar4.d().add(context.getString(R.string.f1364804_));
        bVar4.d().add(context.getString(R.string.f1364904a));
        bVar4.d().add(context.getString(R.string.f1365004b));
        bVar4.d().add(context.getString(R.string.f1365104c));
        b bVar5 = new b();
        bVar5.f(3);
        bVar5.g(R.drawable.f160130ml3);
        String string5 = context.getString(R.string.f13639041);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026me_aio_say_hi_clap_title)");
        bVar5.h(string5);
        bVar5.d().add(context.getString(R.string.f1363503x));
        bVar5.d().add(context.getString(R.string.f1363603y));
        bVar5.d().add(context.getString(R.string.f1363703z));
        bVar5.d().add(context.getString(R.string.f13638040));
        b bVar6 = new b();
        bVar6.f(1);
        bVar6.g(R.drawable.ml5);
        String string6 = context.getString(R.string.f13645047);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri\u2026e_aio_say_hi_drool_title)");
        bVar6.h(string6);
        bVar6.d().add(context.getString(R.string.f13640042));
        bVar6.d().add(context.getString(R.string.f13641043));
        bVar6.d().add(context.getString(R.string.f13642044));
        bVar6.d().add(context.getString(R.string.f13643045));
        bVar6.d().add(context.getString(R.string.f13644046));
        this.mEmojiList.add(bVar4);
        this.mEmojiList.add(bVar6);
        this.mEmojiList.add(bVar5);
    }

    private final void p() {
        AppRuntime appRuntime = this.mApp;
        IGameMsgManagerService iGameMsgManagerService = appRuntime != null ? (IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "") : null;
        JSONObject sayHiDefaultConfig = iGameMsgManagerService != null ? iGameMsgManagerService.getSayHiDefaultConfig() : null;
        if (this.mIsMetaDream) {
            sayHiDefaultConfig = iGameMsgManagerService != null ? iGameMsgManagerService.getMetaDreamSayHiConfig() : null;
        }
        JSONArray optJSONArray = sayHiDefaultConfig != null ? sayHiDefaultConfig.optJSONArray("showList") : null;
        if (optJSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length() && i3 < 3; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                this.mEmojiList.add(new b(optJSONObject));
            }
        }
    }

    private final void q() {
        if (this.mRootView != null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        View inflate = View.inflate(BaseApplication.getContext(), R.layout.dv7, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.mRootView = frameLayout;
        Intrinsics.checkNotNull(frameLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar = aVar2;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new GameMsgBottomBarEvent.AddBottomView(0, frameLayout, layoutParams));
        }
        r(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.ydj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.layout_accept)");
        findViewById.setOnClickListener(this.mClickListener);
        View findViewById2 = frameLayout.findViewById(R.id.f166014ye2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.layout_deny)");
        findViewById2.setOnClickListener(this.mClickListener);
        View findViewById3 = frameLayout.findViewById(R.id.xi8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.image_change)");
        findViewById3.setOnClickListener(this.mClickListener);
        View findViewById4 = frameLayout.findViewById(R.id.f95705fp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.text_send)");
        findViewById4.setOnClickListener(this.mClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ad this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (view.getId()) {
            case R.id.xi8 /* 2131372836 */:
                this$0.v();
                return;
            case R.id.ydj /* 2131374676 */:
                this$0.u();
                return;
            case R.id.f166014ye2 /* 2131374714 */:
                this$0.w();
                return;
            case R.id.f95705fp /* 2131389306 */:
                this$0.z();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ad this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.x(v3);
    }

    private final void z() {
        String str;
        Object tag;
        FrameLayout frameLayout = this.mRootView;
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.jha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById(R.id.text_input)");
        B(1, ((TextView) findViewById).getText().toString());
        g(SayHiState.SAY_HI_WAIT_REPLYING, null);
        View n3 = n();
        if (n3 == null || (tag = n3.getTag()) == null || (str = tag.toString()) == null) {
            str = "";
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(k(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209030", "", str, "20", "0");
    }

    public final void A(String myRoldId, String friendRoleId) {
        if (this.mApp != null) {
            if (!(myRoldId == null || myRoldId.length() == 0)) {
                if (!(friendRoleId == null || friendRoleId.length() == 0)) {
                    this.mGameGlobal.l(true);
                    AppRuntime appRuntime = this.mApp;
                    Intrinsics.checkNotNull(appRuntime);
                    IRuntimeService runtimeService = appRuntime.getRuntimeService(IGameMsgManagerService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp!!.getRuntimeService\u2026va, ProcessConstant.MAIN)");
                    ((IGameMsgManagerService) runtimeService).reqGameMsgSayHiInfo(myRoldId, friendRoleId, new e(friendRoleId, myRoldId));
                    return;
                }
            }
        }
        QLog.i("GameMsgSayHiHelper", 2, "[requestSayHiInfo] myRoldId:" + myRoldId + ",friendRoleId:" + friendRoleId);
    }

    public final void C(int height) {
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOMsgListEvent.BottomLayoutHeightChange(height));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.X;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgSayHiHelper";
    }

    public final View n() {
        FrameLayout frameLayout = this.mRootView;
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.ye6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById(R.id.layout_emoji_list)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        for (int i3 = 0; i3 < linearLayout.getChildCount() && i3 < this.mEmojiList.size(); i3++) {
            View findViewById2 = linearLayout.getChildAt(i3).findViewById(R.id.awy);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutEmojiList.getChild\u2026dViewById(R.id.check_box)");
            if (((CheckBox) findViewById2).isChecked()) {
                return linearLayout.getChildAt(i3);
            }
        }
        return null;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAioContext.aioParam");
        this.mSessionInfo = su3.b.a(g16);
        this.mApp = MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("GameMsgSayHiHelper", 2, "[onMoveToState] state:" + state);
        if (state == 0) {
            h();
        } else {
            if (state != 12) {
                return;
            }
            i();
        }
    }

    public final void u() {
        String string = BaseApplication.getContext().getString(R.string.f1360002z);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026g.game_aio_accept_say_hi)");
        B(2, string);
        g(SayHiState.NORMAL_CHAT, null);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(k(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209032", "", "1", "20", "0");
    }

    public final void v() {
        ArrayList<String> arrayList;
        FrameLayout frameLayout = this.mRootView;
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.ye6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById(R.id.layout_emoji_list)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        for (int i3 = 0; i3 < linearLayout.getChildCount() && i3 < this.mEmojiList.size(); i3++) {
            View findViewById2 = linearLayout.getChildAt(i3).findViewById(R.id.awy);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutEmojiList.getChild\u2026dViewById(R.id.check_box)");
            if (((CheckBox) findViewById2).isChecked()) {
                arrayList = this.mEmojiList.get(i3).d();
                break;
            }
        }
        arrayList = null;
        FrameLayout frameLayout2 = this.mRootView;
        Intrinsics.checkNotNull(frameLayout2);
        View findViewById3 = frameLayout2.findViewById(R.id.jha);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView!!.findViewById(R.id.text_input)");
        TextView textView = (TextView) findViewById3;
        textView.setText(m(arrayList, textView.getText().toString()));
    }

    public final void w() {
        String string = BaseApplication.getContext().getString(R.string.f13607036);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ing.game_aio_deny_say_hi)");
        B(3, string);
        g(SayHiState.NORMAL_CHAT, null);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(k(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209032", "", "2", "20", "0");
    }

    public final void x(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.jha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById(R.id.text_input)");
        TextView textView = (TextView) findViewById;
        FrameLayout frameLayout2 = this.mRootView;
        Intrinsics.checkNotNull(frameLayout2);
        View findViewById2 = frameLayout2.findViewById(R.id.ye6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView!!.findViewById(R.id.layout_emoji_list)");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        for (int i3 = 0; i3 < linearLayout.getChildCount() && i3 < this.mEmojiList.size(); i3++) {
            View childAt = linearLayout.getChildAt(i3);
            View findViewById3 = childAt.findViewById(R.id.awy);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "childView.findViewById(R.id.check_box)");
            ((CheckBox) findViewById3).setChecked(v3 == childAt);
            if (v3 == childAt) {
                b bVar = this.mEmojiList.get(i3);
                Intrinsics.checkNotNullExpressionValue(bVar, "mEmojiList[i]");
                textView.setText(m(bVar.d(), textView.getText().toString()));
            }
        }
    }

    public final void y(GameMsgGreeting$QueryAIOGreetInfoRsp sayHiInfoRsp) {
        Intrinsics.checkNotNullParameter(sayHiInfoRsp, "sayHiInfoRsp");
        if (!sayHiInfoRsp.greetType.has()) {
            QLog.e("GameMsgSayHiHelper", 1, "onSayHiResponse no greetType");
            return;
        }
        int i3 = sayHiInfoRsp.greetType.get();
        if (i3 > SayHiState.UNKNOWN.ordinal()) {
            SayHiState sayHiState = SayHiState.NORMAL_CHAT;
            if (i3 > sayHiState.ordinal()) {
                return;
            }
            QLog.i("GameMsgSayHiHelper", 1, "onSayHiResponse state:" + i3);
            if (i3 == sayHiState.ordinal()) {
                if (this.mRootView == null) {
                    return;
                }
                SayHiState sayHiState2 = SayHiState.values()[i3];
                com.tencent.aio.api.runtime.a aVar = null;
                g(sayHiState2, null);
                com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                } else {
                    aVar = aVar2;
                }
                com.tencent.mvi.base.route.j e16 = aVar.e();
                if (e16 != null) {
                    e16.h(new IceBreakEvent.UpdateIceBreakPokeShow(false, true));
                    return;
                }
                return;
            }
            if (this.mRootView == null) {
                E(false);
                q();
            }
            Bundle bundle = new Bundle();
            if (sayHiInfoRsp.nextGreetTime.has()) {
                bundle.putLong("allowTimeStamp", sayHiInfoRsp.nextGreetTime.get());
            }
            g(SayHiState.values()[i3], bundle);
        }
    }

    private final void E(boolean isShow) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (!isShow) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar2 = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            if (e16 != null) {
                e16.h(InputEvent.InputHide.f188577d);
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            } else {
                aVar = aVar3;
            }
            com.tencent.mvi.base.route.j e17 = aVar.e();
            if (e17 != null) {
                e17.h(InputEvent.AIOShortcutBarHide.f188562d);
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mAioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar4 = null;
        }
        com.tencent.mvi.base.route.j e18 = aVar4.e();
        if (e18 != null) {
            e18.h(InputEvent.InputShow.f188578d);
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mAioContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar = aVar5;
        }
        com.tencent.mvi.base.route.j e19 = aVar.e();
        if (e19 != null) {
            e19.h(InputEvent.AIOShortcutBarShow.f188563d);
        }
    }

    private final String m(List<String> stringList, String exclude) {
        List<String> list = stringList;
        if (list == null || list.isEmpty()) {
            return "";
        }
        int abs = Math.abs(new Random().nextInt()) % stringList.size();
        int indexOf = !TextUtils.isEmpty(exclude) ? stringList.indexOf(exclude) : -1;
        if (indexOf >= 0 && abs == indexOf) {
            abs++;
        }
        return stringList.get(abs < stringList.size() ? abs : 0);
    }

    public final void D(int heightInDp) {
        C(BaseAIOUtils.f(heightInDp, BaseApplication.getContext().getResources()));
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    private final void r(View rootView) {
        View findViewById = rootView.findViewById(R.id.ye6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.layout_emoji_list)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        int size = this.mEmojiList.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mEmojiList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mEmojiList[i]");
            b bVar2 = bVar;
            View inflate = View.inflate(BaseApplication.getContext(), R.layout.dv8, null);
            View findViewById2 = inflate.findViewById(R.id.xie);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutEmojiItem.findViewById(R.id.image_emoji)");
            ImageView imageView = (ImageView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.f95275ej);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "layoutEmojiItem.findViewById(R.id.text_emoji)");
            TextView textView = (TextView) findViewById3;
            inflate.setTag(Integer.valueOf(bVar2.getMId()));
            inflate.setOnClickListener(this.mEmojiClickListener);
            if (bVar2.getMText() != null) {
                textView.setText(bVar2.getMText());
            }
            if (!TextUtils.isEmpty(bVar2.getMImageUrl())) {
                imageView.setImageDrawable(URLDrawable.getDrawable(bVar2.getMImageUrl()));
            } else if (bVar2.getMImageResId() != 0) {
                imageView.setImageResource(bVar2.getMImageResId());
            }
            Resources resources = BaseApplication.getContext().getResources();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BaseAIOUtils.f(106.5f, resources), BaseAIOUtils.f(86.0f, resources));
            layoutParams.leftMargin = BaseAIOUtils.f(6.0f, resources);
            layoutParams.rightMargin = BaseAIOUtils.f(6.0f, resources);
            linearLayout.addView(inflate, layoutParams);
        }
        if (linearLayout.getChildCount() > 0) {
            View childAt = linearLayout.getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "layoutEmojiList.getChildAt(0)");
            x(childAt);
        }
    }

    private final void B(int sayHiType, String text) {
        if (!TextUtils.isEmpty(text) && !TextUtils.isEmpty(this.mPeerUid)) {
            TempChatGameSession tempChatGameSession = this.mGameSession;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            String str = tempChatGameSession.peerRoleId;
            if (!(str == null || str.length() == 0)) {
                String str2 = tempChatGameSession.selfRoleId;
                if (!(str2 == null || str2.length() == 0)) {
                    TempChatGameSession tempChatGameSession2 = new TempChatGameSession(tempChatGameSession.gameAppId, tempChatGameSession.nickname, tempChatGameSession.selfTinyId, tempChatGameSession.selfRoleId, tempChatGameSession.selfOpenId, tempChatGameSession.peerTinyId, tempChatGameSession.peerRoleId, tempChatGameSession.peerOpenId, tempChatGameSession.pushWindowFlag, Integer.valueOf(sayHiType), tempChatGameSession.redPointSwitch, 0);
                    IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class);
                    String str3 = this.mPeerUid;
                    Intrinsics.checkNotNull(text);
                    iGameMsgNtApi.sendSayHiMsg(sayHiType, str3, text, tempChatGameSession2);
                    return;
                }
            }
            QLog.i("GameMsgSayHiHelper", 1, "[sendSayHiMessage] gameSession is invalid");
            return;
        }
        QLog.i("GameMsgSayHiHelper", 1, "[sendSayHiMessage] params invalid,text:" + text + ",mPeerUid:" + this.mPeerUid);
    }

    private final long j(Bundle stateData) {
        if (stateData == null || !stateData.containsKey("allowTimeStamp")) {
            return 0L;
        }
        long j3 = stateData.getLong("allowTimeStamp", 0L);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (j3 <= serverTime) {
            return 0L;
        }
        long j16 = j3 - serverTime;
        long j17 = 60;
        return (j16 % j17 > 0 ? 1 : 0) + (j16 / j17);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\t\b\u0016\u00a2\u0006\u0004\b\u001f\u0010!R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/ad$b;", "", "", "a", "I", "()I", "f", "(I)V", "mId", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMImageUrl", "(Ljava/lang/String;)V", "mImageUrl", "g", "mImageResId", "d", "e", tl.h.F, "mText", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setMRandomStrings", "(Ljava/util/ArrayList;)V", "mRandomStrings", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int mId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String mImageUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mImageResId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String mText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ArrayList<String> mRandomStrings;

        public b(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.mId = jsonObject.optInt("configId");
            String optString = jsonObject.optString("desc", "");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"desc\", \"\")");
            this.mText = optString;
            this.mImageUrl = jsonObject.optString("imageUrl");
            this.mImageResId = 0;
            this.mRandomStrings = new ArrayList<>();
            JSONArray optJSONArray = jsonObject.optJSONArray("textList");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                this.mRandomStrings.add(optJSONArray.optString(i3, ""));
            }
        }

        /* renamed from: a, reason: from getter */
        public final int getMId() {
            return this.mId;
        }

        /* renamed from: b, reason: from getter */
        public final int getMImageResId() {
            return this.mImageResId;
        }

        /* renamed from: c, reason: from getter */
        public final String getMImageUrl() {
            return this.mImageUrl;
        }

        public final ArrayList<String> d() {
            return this.mRandomStrings;
        }

        /* renamed from: e, reason: from getter */
        public final String getMText() {
            return this.mText;
        }

        public final void f(int i3) {
            this.mId = i3;
        }

        public final void g(int i3) {
            this.mImageResId = i3;
        }

        public final void h(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mText = str;
        }

        public b() {
            this.mId = 0;
            this.mText = "";
            this.mImageUrl = null;
            this.mImageResId = 0;
            this.mRandomStrings = new ArrayList<>();
        }
    }
}
