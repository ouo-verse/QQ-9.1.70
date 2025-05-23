package com.tencent.qqnt.aio.helper.gamecenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.nt.aio.title.GameMsgTitleEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u0001:\u0002`aB\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0002J\u0010\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\rJ\u0010\u0010%\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010&\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\rH\u0016R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010@R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010MR\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010@R\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgRightIconHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "t", UserInfo.SEX_FEMALE, "Lorg/json/JSONObject;", "root", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "url", "w", "showRedDot", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "v", "", "width", "height", "Landroid/widget/ImageView$ScaleType;", "scaleType", "u", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "icon", "y", "B", "G", "state", "onMoveToState", "", "interestedIn", "getId", "getTag", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "mGameSession", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "mCustomParam", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgRightIconHelper$b;", "f", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgRightIconHelper$b;", "mWeeklyReportGuideInfo", tl.h.F, "Ljava/lang/String;", "mKingIconUrl", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mUiHandler", "Z", "mIsWeeklyReportClicked", BdhLogUtil.LogTag.Tag_Conn, "mIsDestroyed", "D", "mIsShowingWeeklyReportIcon", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/app/Activity;", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/URLDrawable;", "mIconDrawable", "H", "mIsMetaDreamAddFriendIconVisible", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "I", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "mMsgApi", "Lcom/tencent/mvi/base/route/a;", "J", "Lcom/tencent/mvi/base/route/a;", "mAction1", "Ljava/lang/Runnable;", "K", "Ljava/lang/Runnable;", "mShowTask", "<init>", "()V", "L", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GameMsgRightIconHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsDestroyed;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsShowingWeeklyReportIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: F, reason: from kotlin metadata */
    private Activity mActivity;

    /* renamed from: G, reason: from kotlin metadata */
    private URLDrawable mIconDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsMetaDreamAddFriendIconVisible;

    /* renamed from: I, reason: from kotlin metadata */
    private final IGameMsgNtApi mMsgApi;

    /* renamed from: J, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: K, reason: from kotlin metadata */
    private final Runnable mShowTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TempChatGameSession mGameSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Bundle mCustomParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b mWeeklyReportGuideInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mKingIconUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Handler mUiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsWeeklyReportClicked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgRightIconHelper$b;", "", "", "d", "", "a", "I", "getMIsShowEntrance", "()I", "f", "(I)V", "mIsShowEntrance", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "mIconUrl", "c", "g", "mJumpUrl", "", "()Z", "isShowEntrance", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int mIsShowEntrance;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String mIconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String mJumpUrl;

        /* renamed from: a, reason: from getter */
        public final String getMIconUrl() {
            return this.mIconUrl;
        }

        /* renamed from: b, reason: from getter */
        public final String getMJumpUrl() {
            return this.mJumpUrl;
        }

        public final boolean c() {
            return this.mIsShowEntrance == 1;
        }

        public final void d() {
            if (QLog.isColorLevel()) {
                QLog.d("GameMsgRightIconHelper", 2, "isShowEntrance:" + this.mIsShowEntrance + ",iconUrl:" + this.mIconUrl + ",jumpUrl:" + this.mJumpUrl);
            }
        }

        public final void e(String str) {
            this.mIconUrl = str;
        }

        public final void f(int i3) {
            this.mIsShowEntrance = i3;
        }

        public final void g(String str) {
            this.mJumpUrl = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgRightIconHelper$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (QLog.isColorLevel()) {
                QLog.i("GameMsgRightIconHelper", 2, "[mAction1] call:" + i3);
            }
            if (i3 instanceof AIOTitleEvent.Right2IvClickEvent) {
                GameMsgRightIconHelper.this.r();
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.KingIconUpdate) {
                GameMsgRightIconHelper.this.y(((GameMsgTitleEvent.KingIconUpdate) i3).getIconUrl());
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.WeeklyIconUpdate) {
                GameMsgRightIconHelper.this.B(((GameMsgTitleEvent.WeeklyIconUpdate) i3).getDataObj());
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.KingOrWeeklyIconRedDotUpdate) {
                URLDrawable uRLDrawable = GameMsgRightIconHelper.this.mIconDrawable;
                if (uRLDrawable != null) {
                    GameMsgRightIconHelper.this.G(uRLDrawable);
                    return;
                }
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.MetaDreamAddFriendEvent) {
                GameMsgRightIconHelper.this.z();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    public GameMsgRightIconHelper() {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        this.mMsgApi = (IGameMsgNtApi) api;
        this.mAction1 = new c();
        this.mShowTask = new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.GameMsgRightIconHelper$mShowTask$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                Handler handler;
                try {
                    z16 = GameMsgRightIconHelper.this.mIsDestroyed;
                    if (z16) {
                        return;
                    }
                    z17 = GameMsgRightIconHelper.this.mIsShowingWeeklyReportIcon;
                    if (!z17) {
                        GameMsgRightIconHelper.this.A();
                    } else {
                        GameMsgRightIconHelper.this.x();
                    }
                    handler = GameMsgRightIconHelper.this.mUiHandler;
                    if (handler != null) {
                        handler.postDelayed(this, 3000L);
                    }
                } catch (Throwable th5) {
                    QLog.e("GameMsgRightIconHelper", 1, "mShowTask errors:" + th5.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final GameMsgRightIconHelper this$0, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgRightIconHelper", 2, "[showWeeklyReportIcon]");
        }
        if (!this$0.s(jSONObject)) {
            QLog.w("GameMsgRightIconHelper", 1, "fail to parse json");
            return;
        }
        b bVar = this$0.mWeeklyReportGuideInfo;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
            bVar = null;
        }
        if (bVar.c()) {
            Handler handler = this$0.mUiHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameMsgRightIconHelper.D(GameMsgRightIconHelper.this);
                    }
                });
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameGlobalData.INSTANCE.a().getMAppId(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209620", "", "2", "8", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GameMsgRightIconHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E();
    }

    private final void E() {
        b bVar = this.mWeeklyReportGuideInfo;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
            bVar = null;
        }
        if (!bVar.c()) {
            x();
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(this.mKingIconUrl);
        b bVar3 = this.mWeeklyReportGuideInfo;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
        } else {
            bVar2 = bVar3;
        }
        boolean isEmpty2 = TextUtils.isEmpty(bVar2.getMIconUrl());
        if (isEmpty && isEmpty2) {
            return;
        }
        if (isEmpty || isEmpty2) {
            if (!isEmpty2) {
                A();
                return;
            } else {
                x();
                return;
            }
        }
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mShowTask);
        }
        Handler handler2 = this.mUiHandler;
        if (handler2 != null) {
            handler2.postDelayed(this.mShowTask, 3000L);
        }
    }

    private final void F() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingIconUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        aVar4.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.WeeklyIconUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        aVar5.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingOrWeeklyIconRedDotUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar6;
        }
        aVar2.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MetaDreamAddFriendEvent.class)), this.mAction1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GameMsgRightIconHelper this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mIsShowingWeeklyReportIcon) {
            this$0.v(true, drawable);
        } else if (GameGlobalData.INSTANCE.a().getMRedDotShow()) {
            this$0.v(true, drawable);
        } else {
            this$0.v(false, drawable);
        }
    }

    private final void o() {
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mShowTask);
        }
    }

    private final void p() {
        if (this.mIsWeeklyReportClicked) {
            this.mIsShowingWeeklyReportIcon = false;
            w(this.mKingIconUrl);
        } else {
            E();
        }
    }

    private final void q() {
        Activity activity;
        String str;
        Handler handler = this.mUiHandler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacks(this.mShowTask);
        this.mIsWeeklyReportClicked = true;
        v(false, this.mIconDrawable);
        b bVar = this.mWeeklyReportGuideInfo;
        TempChatGameSession tempChatGameSession = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
            bVar = null;
        }
        if (TextUtils.isEmpty(bVar.getMJumpUrl()) || (activity = this.mActivity) == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        b bVar2 = this.mWeeklyReportGuideInfo;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
            bVar2 = null;
        }
        intent.putExtra("url", bVar2.getMJumpUrl());
        activity.startActivity(intent);
        IGameCenterCommonApi iGameCenterCommonApi = (IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class);
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
        } else {
            tempChatGameSession = tempChatGameSession2;
        }
        if (iGameCenterCommonApi.isApplyPartnerContact(tempChatGameSession)) {
            str = "92050";
        } else {
            str = "92005";
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameGlobalData.INSTANCE.a().getMAppId(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str, "206357", "", "2", "20", "0");
    }

    private final void t() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.d(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingIconUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        aVar4.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.WeeklyIconUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        aVar5.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingOrWeeklyIconRedDotUpdate.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar6;
        }
        aVar2.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MetaDreamAddFriendEvent.class)), this.mAction1);
    }

    private final void u(int width, int height, ImageView.ScaleType scaleType) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.UpdateRight2IvScaleType(width, height, scaleType));
        }
    }

    private final void v(boolean showRedDot, Drawable iconDrawable) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.UpdateRight2IvEvent(showRedDot, true, iconDrawable, 0, "3"));
        }
    }

    private final void w(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Drawable drawable = MobileQQ.sMobileQQ.getDrawable(R.drawable.joz);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        G(URLDrawable.getDrawable(url, obtain));
    }

    public final void B(final JSONObject root) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.z
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgRightIconHelper.C(GameMsgRightIconHelper.this, root);
            }
        }, 16, null, false);
    }

    public final void G(final Drawable iconDrawable) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.y
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgRightIconHelper.H(GameMsgRightIconHelper.this, iconDrawable);
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350620b0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgRightIconHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("GameMsgRightIconHelper", 1, "[GameMsgAioRightIconHelper]");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mCustomParam = a16.g().l();
        this.mActivity = param.a().c().getActivity();
        this.mWeeklyReportGuideInfo = new b();
        this.mUiHandler = ThreadManagerV2.getUIHandlerV2();
        t();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("GameMsgRightIconHelper", 2, "[onMoveToState] state:" + state);
        if (state == 0) {
            m();
            return;
        }
        if (state == 3) {
            p();
        } else if (state == 8) {
            o();
        } else {
            if (state != 12) {
                return;
            }
            n();
        }
    }

    public final void r() {
        QLog.i("GameMsgRightIconHelper", 1, "[onIconClick] mIsShowingWeeklyReportIcon:" + this.mIsShowingWeeklyReportIcon + ", mIsMetaDreamAddFriendIconVisible:" + this.mIsMetaDreamAddFriendIconVisible);
        com.tencent.aio.api.runtime.a aVar = null;
        if (this.mIsMetaDreamAddFriendIconVisible) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                e16.h(GameMsgTitleEvent.MetaDreamAddFriendIconClick.f212242d);
                return;
            }
            return;
        }
        if (this.mIsShowingWeeklyReportIcon) {
            q();
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar3;
        }
        com.tencent.mvi.base.route.j e17 = aVar.e();
        if (e17 != null) {
            e17.h(GameMsgTitleEvent.KingIconClick.f212237d);
        }
    }

    public final void y(String icon) {
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgRightIconHelper", 2, "[showKingIcon]");
        }
        this.mKingIconUrl = icon;
        E();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameGlobalData.INSTANCE.a().getMAppId(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "209620", "", "1", "8", "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.mIsShowingWeeklyReportIcon = true;
        b bVar = this.mWeeklyReportGuideInfo;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
            bVar = null;
        }
        w(bVar.getMIconUrl());
    }

    private final void n() {
        this.mIsDestroyed = true;
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mShowTask);
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        this.mIsShowingWeeklyReportIcon = false;
        w(this.mKingIconUrl);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3, 8, 12};
    }

    public final void z() {
        this.mIsMetaDreamAddFriendIconVisible = true;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.UpdateRight2IvEvent(false, true, MobileQQ.sMobileQQ.getDrawable(R.drawable.qui_add_friend_icon_navigation_01_selector), 0, "3"));
        }
    }

    private final void m() {
        u(ViewUtils.dpToPx(30.0f), ViewUtils.dpToPx(30.0f), ImageView.ScaleType.FIT_CENTER);
        Bundle bundle = this.mCustomParam;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle = null;
        }
        String string = bundle.getString("key_peerId", "");
        IGameMsgNtApi iGameMsgNtApi = this.mMsgApi;
        Bundle bundle3 = this.mCustomParam;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
        } else {
            bundle2 = bundle3;
        }
        this.mGameSession = iGameMsgNtApi.getGameSessionFromPeerUidOrJson(string, bundle2.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
    }

    private final boolean s(JSONObject root) {
        if (root == null) {
            return false;
        }
        try {
            b bVar = this.mWeeklyReportGuideInfo;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeeklyReportGuideInfo");
                bVar = null;
            }
            bVar.f(root.optInt("is_show_entrance"));
            bVar.e(root.optString("icon"));
            bVar.g(root.optString("url"));
            bVar.d();
            return true;
        } catch (Throwable th5) {
            QLog.e("GameMsgRightIconHelper", 1, "parseJson error:" + th5.getMessage());
            return false;
        }
    }
}
