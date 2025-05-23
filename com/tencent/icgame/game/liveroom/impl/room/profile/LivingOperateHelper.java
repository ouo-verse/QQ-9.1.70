package com.tencent.icgame.game.liveroom.impl.room.profile;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.profile.LivingOperateHelper;
import com.tencent.icgame.game.liveroom.impl.room.util.PopWindowType;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.icgame.game.liveroom.impl.room.util.n;
import com.tencent.icgame.game.liveroom.impl.room.util.o;
import com.tencent.icgame.game.sso.request.QQLiveReportRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.utils.v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;
import tw0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J<\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J0\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J<\u0010\u001b\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002JN\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J*\u0010\"\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J2\u0010#\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0007JH\u0010%\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010$\u001a\u00020\u0007H\u0007J\u0006\u0010&\u001a\u00020\u0002J\u0006\u0010'\u001a\u00020\u0013J.\u0010-\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*R\u0014\u00100\u001a\u00020*8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010:R\u0014\u0010=\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/LivingOperateHelper;", "", "", "uid", "Lpw0/a;", "i", "roomId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "blurBackgroundView", "Landroid/content/Context;", "context", "Lhx0/a;", "liveUserInfo", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;", "reportParam", "Lpw0/b;", "anchorJudgeStrategy", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "", "reportSource", "e", "blurBlackgroundView", "reprotInfo", "l", "Lcom/tencent/icgame/game/liveroom/impl/room/util/PopWindowType;", "dialogType", "isAnchorOpen", "Lcom/tencent/icgame/game/liveroom/impl/room/util/o;", "j", "roomType", tl.h.F, DomainData.DOMAIN_NAME, "isAcrossRoomAnchor", "o", "d", "f", "reporterUid", "reporteeUid", "", "reason", "targetUserName", "g", "b", "Ljava/lang/String;", "TAG", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/b;", "c", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/b;", "getDialog", "()Lcom/tencent/icgame/game/liveroom/impl/room/profile/b;", "setDialog", "(Lcom/tencent/icgame/game/liveroom/impl/room/profile/b;)V", "dialog", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lpw0/a;", "defaultAnchorJudge", "Z", "isMultiAvChatStart", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LivingOperateHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LivingOperateHelper f115476a = new LivingOperateHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "ICGameLivingOperateHelper";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.icgame.game.liveroom.impl.room.profile.b dialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi mAegisLog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final pw0.a defaultAnchorJudge;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isMultiAvChatStart;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/LivingOperateHelper$a;", "Lpw0/a;", "", "uid", "d", "", "isShowGiftBtn", "b", "J", "mUid", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends pw0.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long mUid;

        @NotNull
        public final a d(long uid) {
            this.mUid = uid;
            return this;
        }

        @Override // pw0.a, pw0.b
        public boolean isShowGiftBtn() {
            return zu0.a.f453416a.a(this.mUid);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/LivingOperateHelper$b", "Lix0/a;", "Lhx0/a;", "userCardInfo", "", "a", "", "errorCode", "", "errorMsg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ix0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f115483a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f115484b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f115485c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pw0.b f115486d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f115487e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f115488f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f115489g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ i f115490h;

        b(Context context, int i3, Ref.LongRef longRef, pw0.b bVar, boolean z16, long j3, View view, i iVar) {
            this.f115483a = context;
            this.f115484b = i3;
            this.f115485c = longRef;
            this.f115486d = bVar;
            this.f115487e = z16;
            this.f115488f = j3;
            this.f115489g = view;
            this.f115490h = iVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(hx0.a userCardInfo, Ref.LongRef realRoomId, View view, Context context, i reportParam, pw0.b judgeStrategy, boolean z16) {
            Intrinsics.checkNotNullParameter(userCardInfo, "$userCardInfo");
            Intrinsics.checkNotNullParameter(realRoomId, "$realRoomId");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
            Intrinsics.checkNotNullParameter(judgeStrategy, "$judgeStrategy");
            userCardInfo.f406545f = z16;
            LivingOperateHelper.f115476a.m(realRoomId.element, view, context, userCardInfo, reportParam, judgeStrategy);
        }

        @Override // ix0.a
        public void a(@NotNull final hx0.a userCardInfo) {
            long d16;
            Intrinsics.checkNotNullParameter(userCardInfo, "userCardInfo");
            Context context = this.f115483a;
            if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) this.f115483a).isDestroyed())) {
                LivingOperateHelper.mAegisLog.i(LivingOperateHelper.TAG, "activity is Finishing or Destroyed when open MiniCard dialog");
                return;
            }
            if (userCardInfo.uid == 0) {
                LivingOperateHelper.mAegisLog.a("toast_d", 1, "openProfileDialog#userCardInfo.uid == 0,from=" + this.f115484b + ",roomId=" + this.f115485c.element);
                return;
            }
            LivingOperateHelper.mAegisLog.i(LivingOperateHelper.TAG, 1, userCardInfo.toString());
            userCardInfo.f406543d = this.f115486d.isShowGiftBtn();
            userCardInfo.f406546g = this.f115487e;
            if (m.b(this.f115485c.element) == 2) {
                LivingOperateHelper.f115476a.m(this.f115485c.element, this.f115489g, this.f115483a, userCardInfo, this.f115490h, this.f115486d);
                return;
            }
            if (this.f115486d.b(this.f115488f)) {
                d16 = userCardInfo.uid;
            } else {
                d16 = LivingOperateHelper.f115476a.d();
            }
            long acquireAnchorUid = this.f115486d.acquireAnchorUid(this.f115485c.element);
            final Ref.LongRef longRef = this.f115485c;
            long j3 = longRef.element;
            final View view = this.f115489g;
            final Context context2 = this.f115483a;
            final i iVar = this.f115490h;
            final pw0.b bVar = this.f115486d;
            k.q(acquireAnchorUid, d16, j3, new k.c() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.g
                @Override // qw0.k.c
                public final void a(boolean z16) {
                    LivingOperateHelper.b.c(hx0.a.this, longRef, view, context2, iVar, bVar, z16);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            LivingOperateHelper.mAegisLog.e(LivingOperateHelper.TAG, 1, "errorCode=" + errorCode + ",errorMsg=" + errorMsg);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u7f51\u7edc\u5f02\u5e38\uff0c");
            sb5.append(errorMsg);
            com.tencent.icgame.game.ui.widget.f.b(sb5.toString());
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        mAegisLog = (IAegisLogApi) api;
        defaultAnchorJudge = new pw0.a();
    }

    LivingOperateHelper() {
    }

    private final i e(LiveUserInfo liveUserInfo, long roomId, int reportSource, Context context, pw0.b anchorJudgeStrategy) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("icgame_inf_module_user_id", String.valueOf(liveUserInfo.uid));
        linkedHashMap.put("icgame_inf_module_source", String.valueOf(reportSource));
        boolean isOpenAnchorProfile = anchorJudgeStrategy.isOpenAnchorProfile(roomId, liveUserInfo.uid);
        String str = "1";
        if (isOpenAnchorProfile) {
            obj = "1";
        } else {
            obj = "0";
        }
        linkedHashMap.put("icgame_is_archor_inf_module", obj);
        if (!v.b(context.getResources())) {
            str = "0";
        }
        linkedHashMap.put("icgame_screen_orientation", str);
        return new i("pg_icgame_audience", "em_icgame_inf_module", linkedHashMap, "0", xw0.a.INSTANCE.a().b());
    }

    private final pw0.b h(long roomId, int roomType, LiveUserInfo liveUserInfo, pw0.b anchorJudgeStrategy) {
        if (anchorJudgeStrategy == null) {
            pw0.a aVar = defaultAnchorJudge;
            if (roomType == 0 && isMultiAvChatStart) {
                return i(liveUserInfo.uid);
            }
            return aVar;
        }
        return anchorJudgeStrategy;
    }

    private final pw0.a i(long uid) {
        return new a().d(uid);
    }

    private final o j(PopWindowType dialogType, View blurBlackgroundView, Context context, hx0.a liveUserInfo, long roomId, i reprotInfo, pw0.b anchorJudgeStrategy, boolean isAnchorOpen) {
        int i3;
        o oVar = new o();
        oVar.x(dialogType);
        if (context.getResources().getConfiguration().orientation == 2) {
            i3 = 320;
        } else {
            i3 = -1;
        }
        oVar.v(i3);
        oVar.u(-2);
        oVar.s(320);
        oVar.r(-2);
        oVar.w(new h(liveUserInfo, roomId, blurBlackgroundView, reprotInfo, isAnchorOpen, anchorJudgeStrategy));
        oVar.q(R.style.b0c);
        return oVar;
    }

    static /* synthetic */ o k(LivingOperateHelper livingOperateHelper, PopWindowType popWindowType, View view, Context context, hx0.a aVar, long j3, i iVar, pw0.b bVar, boolean z16, int i3, Object obj) {
        boolean z17;
        if ((i3 & 128) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        return livingOperateHelper.j(popWindowType, view, context, aVar, j3, iVar, bVar, z17);
    }

    private final void l(View blurBlackgroundView, Context context, final hx0.a liveUserInfo, final long roomId, i reprotInfo, final pw0.b anchorJudgeStrategy) {
        com.tencent.icgame.game.liveroom.impl.room.profile.b bVar = dialog;
        if (bVar != null) {
            bVar.dismiss();
        }
        PopupWindow f16 = n.f(context, null, k(this, PopWindowType.LIVING_PROFILE_ANCHOR, blurBlackgroundView, context, liveUserInfo, roomId, reprotInfo, anchorJudgeStrategy, false, 128, null), new Function1<PopupWindow, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.LivingOperateHelper$openAnchorProfileDialog$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/LivingOperateHelper$openAnchorProfileDialog$1$a", "Ltw0/b$a;", "", "type", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "data", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes7.dex */
            public static final class a implements b.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f115491a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ pw0.b f115492b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ hx0.a f115493c;

                a(long j3, pw0.b bVar, hx0.a aVar) {
                    this.f115491a = j3;
                    this.f115492b = bVar;
                    this.f115493c = aVar;
                }

                @Override // tw0.b.a
                public void a(int type, @Nullable AdminReason data) {
                    String str;
                    if (type == 3) {
                        LivingOperateHelper livingOperateHelper = LivingOperateHelper.f115476a;
                        long j3 = this.f115491a;
                        long a16 = this.f115492b.a();
                        hx0.a aVar = this.f115493c;
                        long j16 = aVar.uid;
                        if (data != null) {
                            str = data.desc;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "";
                        }
                        String str2 = aVar.nick;
                        Intrinsics.checkNotNullExpressionValue(str2, "liveUserInfo.nick");
                        livingOperateHelper.g(j3, a16, j16, str, str2);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PopupWindow popupWindow) {
                invoke2(popupWindow);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PopupWindow it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ((b) it).D(new a(roomId, anchorJudgeStrategy, liveUserInfo));
            }
        });
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.icgame.game.liveroom.impl.room.profile.BaseLivingProfileDialog");
        dialog = (com.tencent.icgame.game.liveroom.impl.room.profile.b) f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(long roomId, View blurBackgroundView, Context context, hx0.a liveUserInfo, i reportParam, pw0.b anchorJudgeStrategy) {
        if (!anchorJudgeStrategy.isOpenAnchorProfile(roomId, liveUserInfo.uid) && q(roomId)) {
            mAegisLog.d(TAG, "[openProfileDialog] shieldAudience");
        } else {
            l(blurBackgroundView, context, liveUserInfo, roomId, reportParam, anchorJudgeStrategy);
        }
    }

    public static /* synthetic */ void p(LivingOperateHelper livingOperateHelper, View view, Context context, long j3, LiveUserInfo liveUserInfo, int i3, pw0.b bVar, boolean z16, int i16, Object obj) {
        pw0.b bVar2;
        boolean z17;
        if ((i16 & 32) != 0) {
            bVar2 = null;
        } else {
            bVar2 = bVar;
        }
        if ((i16 & 64) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        livingOperateHelper.o(view, context, j3, liveUserInfo, i3, bVar2, z17);
    }

    private final boolean q(long roomId) {
        return false;
    }

    public final long d() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.getUid();
        }
        return 0L;
    }

    public final void f() {
        tw0.b operateDialog;
        com.tencent.icgame.game.liveroom.impl.room.profile.b bVar = dialog;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.tencent.icgame.game.liveroom.impl.room.profile.b bVar2 = dialog;
        if (bVar2 != null && (operateDialog = bVar2.getOperateDialog()) != null) {
            operateDialog.dismiss();
        }
        com.tencent.icgame.game.liveroom.impl.room.profile.b bVar3 = dialog;
        if (bVar3 != null) {
            bVar3.l();
        }
        dialog = null;
    }

    public final void g(long roomId, long reporterUid, long reporteeUid, @NotNull String reason, @NotNull String targetUserName) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(targetUserName, "targetUserName");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveReportRequest(roomId, reporterUid, reporteeUid, reason), new Function1<QQLiveResponse<ty0.b>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.LivingOperateHelper$doReport$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ty0.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ty0.b> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ty0.b rsp = response.getRsp();
                if (response.isFailed() || rsp == null || rsp.f437902a != 0) {
                    LivingOperateHelper.mAegisLog.e(LivingOperateHelper.TAG, "[doReport] error, " + response.getRetCode() + ", " + response.getErrMsg() + "; " + (rsp != null ? Integer.valueOf(rsp.f437902a) : null) + ", " + (rsp != null ? rsp.f437903b : null));
                    com.tencent.icgame.game.ui.widget.f.b("\u4e3e\u62a5\u5931\u8d25");
                    return;
                }
                LivingOperateHelper.mAegisLog.d(LivingOperateHelper.TAG, "[doReport] onSuccess");
                com.tencent.icgame.game.ui.widget.f.b("\u4e3e\u62a5\u6210\u529f");
            }
        });
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "openProfile", imports = {}))
    public final void n(@Nullable View blurBlackgroundView, @NotNull Context context, long roomId, @NotNull LiveUserInfo liveUserInfo, int reportSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
        p(this, blurBlackgroundView, context, roomId, liveUserInfo, reportSource, null, false, 64, null);
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "openProfile", imports = {}))
    public final void o(@Nullable View blurBlackgroundView, @NotNull Context context, long roomId, @NotNull LiveUserInfo liveUserInfo, int reportSource, @Nullable pw0.b anchorJudgeStrategy, boolean isAcrossRoomAnchor) {
        long j3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = roomId;
        if (roomId == 0) {
            BaseRoomInfo q16 = ((fu0.c) qx0.a.b(fu0.c.class)).q(0L);
            if (q16 != null) {
                j3 = q16.getRoomId();
            } else {
                j3 = 0;
            }
            longRef.element = j3;
        }
        long j16 = longRef.element;
        pw0.b h16 = h(j16, m.b(j16), liveUserInfo, anchorJudgeStrategy);
        h16.c(0L);
        if (com.tencent.timi.game.utils.o.f("profile_" + liveUserInfo.uid, 1000L)) {
            return;
        }
        i e16 = e(liveUserInfo, longRef.element, reportSource, context, h16);
        IQQLiveSDK f16 = ((fu0.c) qx0.a.b(fu0.c.class)).f();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UserFileds.Fileds_Follow);
        arrayList.add(UserFileds.Fileds_FANS_GROUP);
        arrayList.add(UserFileds.Fileds_MEDAL);
        arrayList.add(UserFileds.Fileds_Fans_QQ_Group);
        gx0.a.d(f16, liveUserInfo.uid, arrayList, new b(context, reportSource, longRef, h16, isAcrossRoomAnchor, roomId, blurBlackgroundView, e16));
    }
}
