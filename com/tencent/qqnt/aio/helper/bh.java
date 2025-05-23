package com.tencent.qqnt.aio.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.event.IceBreakEvent;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.QZoneShareManager;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import expand.common.GetMatchSrcRsp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001?\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J5\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0011\u0010J\u001a\u00020G8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/aio/helper/bh;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mvi/base/route/g;", "", "u", "w", "o", "j", "v", "", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "", "sessionUin", "k", ReportConstant.COSTREPORT_PREFIX, "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", DomainData.DOMAIN_NAME, "", "bOnCreate", "toShow", "pushSceneId", "grayText", HippyTKDListViewAdapter.X, "(ZZLjava/lang/Integer;Ljava/lang/String;)V", "appId", "r", "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "e", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "f", "I", "oldUinType", "Lcom/tencent/mobileqq/relationx/icebreaking/AIOIceBreakShow;", tl.h.F, "Lcom/tencent/mobileqq/relationx/icebreaking/AIOIceBreakShow;", "mAIOIceBreakShow", "Lcom/tencent/util/MqqWeakReferenceHandler;", "i", "Lcom/tencent/util/MqqWeakReferenceHandler;", "mUIHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Integer;", "Lcom/tencent/mvi/base/route/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/a;", "mAction1", "com/tencent/qqnt/aio/helper/bh$c", "D", "Lcom/tencent/qqnt/aio/helper/bh$c;", "iceBreakChangeListener", "Lcom/tencent/mobileqq/relationx/icebreaking/b;", "E", "Lcom/tencent/mobileqq/relationx/icebreaking/b;", "iceBreakHotPicCallback", "Lcom/tencent/mobileqq/app/QQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class bh implements com.tencent.aio.main.businesshelper.h, Handler.Callback, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final HashMap<String, Integer> G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c iceBreakChangeListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.relationx.icebreaking.b iceBreakHotPicCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int oldUinType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOIceBreakShow mAIOIceBreakShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MqqWeakReferenceHandler mUIHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer pushSceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/helper/bh$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.bh$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/bh$b", "Lcom/tencent/mobileqq/qqexpand/network/d;", "Lcom/tencent/mobileqq/qqexpand/network/a;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/qqexpand/network/b;", "response", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mobileqq.qqexpand.network.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IceBreakingMng f350519a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bh f350520b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f350521c;

        b(IceBreakingMng iceBreakingMng, bh bhVar, String str) {
            this.f350519a = iceBreakingMng;
            this.f350520b = bhVar;
            this.f350521c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iceBreakingMng, bhVar, str);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.d
        public void a(@Nullable com.tencent.mobileqq.qqexpand.network.a request, @NotNull com.tencent.mobileqq.qqexpand.network.b response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.c() == 0 && response.b() != null) {
                GetMatchSrcRsp getMatchSrcRsp = new GetMatchSrcRsp();
                try {
                    getMatchSrcRsp.mergeFrom(response.b());
                    if (getMatchSrcRsp.MatchedInfoList.has() && getMatchSrcRsp.MatchedInfoList.get() != null && getMatchSrcRsp.MatchedInfoList.get().get(0) != null) {
                        QLog.d("IceBreakHelperexpand.chat.", 4, "getMatchInfo succ. id=" + getMatchSrcRsp.MatchedInfoList.get().get(0).get().MatchSrcId.get());
                        this.f350519a.i0(this.f350520b.q().getCurrentUin(), 3, ((ILimitChatMatchInfoHelper) QRoute.api(ILimitChatMatchInfoHelper.class)).getIceBreakAioType(getMatchSrcRsp.MatchedInfoList.get().get(0)), this.f350521c);
                        return;
                    }
                    QLog.w("IceBreakHelperexpand.chat.", 1, "getMatchInfo. error ");
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w("IceBreakHelperexpand.chat.", 1, e16.toString());
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.w("IceBreakHelperexpand.chat.", 1, "getMatchInfo. error " + response.c());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/aio/helper/bh$c", "Lcom/tencent/mobileqq/relationx/icebreaking/f;", "", "isSuccess", "", "selfUin", "frdUin", "", "ts", "", "c", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "sessionUin", "isTroop", "b", "a", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.mobileqq.relationx.icebreaking.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bh.this);
            }
        }

        @Override // com.tencent.mobileqq.relationx.icebreaking.f
        public void a(@Nullable String sessionUin, boolean isTroop) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, sessionUin, Boolean.valueOf(isTroop));
                return;
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onRemoveIceBreak uin: %s, isTroop: %s", Arrays.copyOf(new Object[]{sessionUin, Boolean.valueOf(isTroop)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("IceBreakHelper", 2, format);
            }
            QQAppInterface q16 = bh.this.q();
            int i3 = bh.this.oldUinType;
            SessionInfo sessionInfo = bh.this.mSessionInfo;
            SessionInfo sessionInfo2 = null;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            if (IceBreakingUtil.g(q16, i3, sessionInfo.f179557e) && !TextUtils.isEmpty(sessionUin)) {
                SessionInfo sessionInfo3 = bh.this.mSessionInfo;
                if (sessionInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                } else {
                    sessionInfo2 = sessionInfo3;
                }
                if (sessionInfo2.f179557e.equals(sessionUin)) {
                    if ((isTroop && IceBreakingUtil.x(bh.this.oldUinType)) || ((!isTroop && IceBreakingUtil.s(bh.this.oldUinType)) || IceBreakingUtil.u(bh.this.oldUinType) || IceBreakingUtil.w(bh.this.oldUinType) || IceBreakingUtil.v(bh.this.oldUinType) || IceBreakingUtil.t(bh.this.oldUinType))) {
                        bh.y(bh.this, false, false, null, null, 12, null);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.relationx.icebreaking.f
        public void b(@Nullable String sessionUin, boolean isTroop) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, sessionUin, Boolean.valueOf(isTroop));
                return;
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onAddIceBreak uin: %s, isTroop: %s", Arrays.copyOf(new Object[]{sessionUin, Boolean.valueOf(isTroop)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.i("IceBreakHelper", 2, format);
            }
            SessionInfo sessionInfo = bh.this.mSessionInfo;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            String str = sessionInfo.f179557e;
            if (IceBreakingUtil.g(bh.this.q(), bh.this.oldUinType, sessionUin) && !TextUtils.isEmpty(sessionUin) && str.equals(sessionUin)) {
                if ((isTroop && IceBreakingUtil.x(bh.this.oldUinType)) || ((!isTroop && IceBreakingUtil.s(bh.this.oldUinType)) || IceBreakingUtil.u(bh.this.oldUinType) || IceBreakingUtil.w(bh.this.oldUinType) || IceBreakingUtil.v(bh.this.oldUinType))) {
                    bh.y(bh.this, false, true, null, null, 12, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.relationx.icebreaking.f
        public void c(boolean isSuccess, @Nullable String selfUin, @Nullable String frdUin, @Nullable Long ts5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), selfUin, frdUin, ts5);
                return;
            }
            QQAppInterface q16 = bh.this.q();
            int i3 = bh.this.oldUinType;
            SessionInfo sessionInfo = bh.this.mSessionInfo;
            SessionInfo sessionInfo2 = null;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            if (IceBreakingUtil.g(q16, i3, sessionInfo.f179557e) && isSuccess && TextUtils.equals(selfUin, bh.this.q().getCurrentAccountUin())) {
                SessionInfo sessionInfo3 = bh.this.mSessionInfo;
                if (sessionInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo3 = null;
                }
                if (TextUtils.equals(frdUin, sessionInfo3.f179557e)) {
                    QQAppInterface q17 = bh.this.q();
                    com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
                    com.tencent.aio.api.runtime.a aVar = bh.this.mAIOContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar = null;
                    }
                    AIOParam g16 = aVar.g();
                    Intrinsics.checkNotNull(g16);
                    Contact c16 = lVar.c(g16.r());
                    SessionInfo sessionInfo4 = bh.this.mSessionInfo;
                    if (sessionInfo4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    } else {
                        sessionInfo2 = sessionInfo4;
                    }
                    IceBreakingUtil.k(q17, c16, sessionInfo2.f179557e, true, bh.this.oldUinType);
                }
            }
        }

        @Override // com.tencent.mobileqq.relationx.icebreaking.f
        public void d(@Nullable String sessionUin) {
            AIOIceBreakShow aIOIceBreakShow;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                SessionInfo sessionInfo = bh.this.mSessionInfo;
                if (sessionInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo = null;
                }
                QLog.i("IceBreakHelper", 1, "onRemoveIceBreak curFriendUin:" + sessionInfo.f179557e + ", sessionUin:" + sessionUin);
                SessionInfo sessionInfo2 = bh.this.mSessionInfo;
                if (sessionInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo2 = null;
                }
                if (sessionInfo2.f179557e.equals(sessionUin) && (aIOIceBreakShow = bh.this.mAIOIceBreakShow) != null) {
                    aIOIceBreakShow.q(null, 0, -1);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sessionUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/bh$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bh.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            QLog.i("IceBreakHelper", 2, "[mAction1] call:" + i3);
            if (i3 instanceof IceBreakEvent.UpdateIceBreakPokeShow) {
                IceBreakEvent.UpdateIceBreakPokeShow updateIceBreakPokeShow = (IceBreakEvent.UpdateIceBreakPokeShow) i3;
                bh.y(bh.this, updateIceBreakPokeShow.a(), updateIceBreakPokeShow.b(), null, null, 12, null);
            } else {
                boolean z16 = i3 instanceof IceBreakEvent.GetIceBreakStatus;
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/bh$e", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$a;", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "appId", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements IGameMsgAioNtApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IceBreakingMng f350525b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f350526c;

        e(IceBreakingMng iceBreakingMng, String str) {
            this.f350525b = iceBreakingMng;
            this.f350526c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bh.this, iceBreakingMng, str);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi.a
        public void onResult(boolean canShow, @Nullable String appId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(canShow), appId);
            } else if (canShow && !TextUtils.isEmpty(appId)) {
                this.f350525b.i0(bh.this.q().getCurrentUin(), 3, bh.this.r(appId), this.f350526c);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            G = new HashMap<>();
        }
    }

    public bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUIHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        this.mAction1 = new d();
        this.iceBreakChangeListener = new c();
        this.iceBreakHotPicCallback = new com.tencent.mobileqq.relationx.icebreaking.b() { // from class: com.tencent.qqnt.aio.helper.be
            @Override // com.tencent.mobileqq.relationx.icebreaking.b
            public final void a(boolean z16, List list, int i3, String str) {
                bh.t(bh.this, z16, list, i3, str);
            }
        };
    }

    private final void j() {
        QQAppInterface q16 = q();
        int i3 = this.oldUinType;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        SessionInfo sessionInfo = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        if (IceBreakingUtil.g(q16, i3, su3.b.a(g16).f179557e)) {
            SessionInfo sessionInfo2 = this.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo2 = null;
            }
            if (!TextUtils.isEmpty(sessionInfo2.f179557e)) {
                SessionInfo sessionInfo3 = this.mSessionInfo;
                if (sessionInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo3 = null;
                }
                if (!TextUtils.isEmpty(sessionInfo3.f179557e)) {
                    int i16 = this.oldUinType;
                    SessionInfo sessionInfo4 = this.mSessionInfo;
                    if (sessionInfo4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    } else {
                        sessionInfo = sessionInfo4;
                    }
                    String str = sessionInfo.f179557e;
                    Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.curFriendUin");
                    k(i16, str);
                }
            }
        }
    }

    private final void k(final int sessionType, final String sessionUin) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bg
            @Override // java.lang.Runnable
            public final void run() {
                bh.m(bh.this, sessionUin, sessionType);
            }
        }, 16, null, false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(bh this$0, String sessionUin, int i3) {
        boolean z16;
        String str;
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sessionUin, "$sessionUin");
        IceBreakingMng iceBreakingMng = (IceBreakingMng) this$0.q().getManager(QQManagerFactory.ICE_BREAKING_MNG);
        if (iceBreakingMng == null) {
            return;
        }
        iceBreakingMng.k0(this$0.iceBreakChangeListener);
        iceBreakingMng.j0(this$0.iceBreakHotPicCallback);
        int w3 = iceBreakingMng.w(sessionUin, i3);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", Arrays.copyOf(new Object[]{Integer.valueOf(i3), sessionUin, Integer.valueOf(w3)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.i("IceBreakHelper", 1, format);
        if (w3 != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        SessionInfo sessionInfo = null;
        if (!z16) {
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            String string = aVar.g().l().getString(AppConstants.Key.KEY_AIO_BREAK_ICE);
            if (string != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
            } else {
                num = null;
            }
            this$0.pushSceneId = num;
            com.tencent.aio.api.runtime.a aVar2 = this$0.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            str = aVar2.g().l().getString(AppConstants.Key.KEY_GRAY_TEXT);
            Integer num2 = this$0.pushSceneId;
            if (num2 != null) {
                QLog.i("IceBreakHelper", 1, "checkNeedShowImmediately  pushSceneId:" + num2 + ", grayText:" + str);
                z16 = true;
            }
        } else {
            str = null;
        }
        if (z16) {
            this$0.x(true, true, this$0.pushSceneId, str);
            return;
        }
        QQAppInterface q16 = this$0.q();
        com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
        com.tencent.aio.api.runtime.a aVar3 = this$0.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        AIOParam g16 = aVar3.g();
        Intrinsics.checkNotNull(g16);
        Contact c16 = lVar.c(g16.r());
        SessionInfo sessionInfo2 = this$0.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            sessionInfo = sessionInfo2;
        }
        IceBreakingUtil.k(q16, c16, sessionInfo.f179557e, false, this$0.oldUinType);
    }

    private final void o() {
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bf
            @Override // java.lang.Runnable
            public final void run() {
                bh.p(bh.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(bh this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    private final void s() {
        Manager manager = q().getManager(QQManagerFactory.ICE_BREAKING_MNG);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng");
        IceBreakingMng iceBreakingMng = (IceBreakingMng) manager;
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        String str = sessionInfo.f179557e;
        if (iceBreakingMng.E(str)) {
            return;
        }
        ((ILimitChatMatchInfoHelper) QRoute.api(ILimitChatMatchInfoHelper.class)).getMatchInfoRequest(q(), str, new b(iceBreakingMng, this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(bh this$0, boolean z16, List list, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            return;
        }
        if (this$0.pushSceneId != null) {
            AIOIceBreakShow aIOIceBreakShow = this$0.mAIOIceBreakShow;
            if (aIOIceBreakShow != null) {
                aIOIceBreakShow.u(list, i3, 3);
                return;
            }
            return;
        }
        AIOIceBreakShow aIOIceBreakShow2 = this$0.mAIOIceBreakShow;
        if (aIOIceBreakShow2 != null) {
            aIOIceBreakShow2.t(list, i3);
        }
    }

    private final void u() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.f(this, this.mAction1);
        }
    }

    private final void v() {
        HashMap<String, Integer> hashMap = G;
        hashMap.put(QZoneShareManager.GLORY_OF_KINGS, 12);
        hashMap.put("1106467070", 13);
    }

    private final void w() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.i(this, this.mAction1);
        }
    }

    public static /* synthetic */ void y(bh bhVar, boolean z16, boolean z17, Integer num, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        bhVar.x(z16, z17, num, str);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return cw.H;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.event.IceBreakEvent.UpdateIceBreakPokeShow");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Set) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "IceBreakHelper";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{3, 12};
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mAIOIceBreakShow != null) {
            Manager manager = q().getManager(QQManagerFactory.ICE_BREAKING_MNG);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng");
            IceBreakingMng iceBreakingMng = (IceBreakingMng) manager;
            iceBreakingMng.Y(this.iceBreakChangeListener);
            iceBreakingMng.V();
            AIOIceBreakShow aIOIceBreakShow = this.mAIOIceBreakShow;
            if (aIOIceBreakShow != null) {
                aIOIceBreakShow.n();
            }
            AIOIceBreakShow aIOIceBreakShow2 = this.mAIOIceBreakShow;
            if (aIOIceBreakShow2 != null) {
                aIOIceBreakShow2.l();
            }
            this.mAIOIceBreakShow = null;
        }
        this.oldUinType = 0;
        w();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mSessionInfo = su3.b.a(g16);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        AIOParam g17 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAIOContext.aioParam");
        Integer p16 = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(g17)));
        Intrinsics.checkNotNullExpressionValue(p16, "getOldUinType(mAIOContext.aioParam.getChatType())");
        this.oldUinType = p16.intValue();
        u();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        } else {
            if (state != 3) {
                if (state == 12) {
                    n();
                    return;
                }
                return;
            }
            o();
        }
    }

    @NotNull
    public final QQAppInterface q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) peekAppRuntime;
    }

    public final int r(@Nullable String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appId)).intValue();
        }
        HashMap<String, Integer> hashMap = G;
        if (hashMap.size() == 0) {
            v();
        }
        if (!TextUtils.isEmpty(appId)) {
            Integer num = hashMap.get(appId);
            if (num != null) {
                return num.intValue();
            }
            return 14;
        }
        return 1;
    }

    public final void x(boolean bOnCreate, boolean toShow, @Nullable Integer pushSceneId, @Nullable String grayText) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(bOnCreate), Boolean.valueOf(toShow), pushSceneId, grayText);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(bOnCreate);
        SessionInfo sessionInfo = this.mSessionInfo;
        SessionInfo sessionInfo2 = null;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        objArr[1] = sessionInfo.f179557e;
        objArr[2] = Boolean.valueOf(toShow);
        String format = String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", Arrays.copyOf(objArr, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.i("IceBreakHelper", 1, format);
        if (this.mAIOIceBreakShow == null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            AIOIceBreakShow aIOIceBreakShow = new AIOIceBreakShow(aVar);
            aIOIceBreakShow.i();
            aIOIceBreakShow.r(grayText);
            this.mAIOIceBreakShow = aIOIceBreakShow;
        }
        if (!toShow) {
            this.iceBreakHotPicCallback.a(true, null, 0, "");
            return;
        }
        Manager manager = q().getManager(QQManagerFactory.ICE_BREAKING_MNG);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng");
        IceBreakingMng iceBreakingMng = (IceBreakingMng) manager;
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo3 = null;
        }
        String str = sessionInfo3.f179557e;
        if (pushSceneId != null) {
            iceBreakingMng.i0(q().getCurrentUin(), 3, pushSceneId.intValue(), str);
            return;
        }
        if (IceBreakingUtil.s(this.oldUinType)) {
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            SessionInfo sessionInfo4 = this.mSessionInfo;
            if (sessionInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo4 = null;
            }
            String uid = iRelationNTUinAndUidApi.getUidFromUin(sessionInfo4.f179557e);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            boolean isFriend = iFriendsInfoService.isFriend(uid, "IceBreakHelper");
            if (this.mAIOIceBreakShow != null && isFriend) {
                if (iceBreakingMng.w(str, this.oldUinType) == 1) {
                    i3 = 6;
                }
                String currentAccountUin = q().getCurrentAccountUin();
                SessionInfo sessionInfo5 = this.mSessionInfo;
                if (sessionInfo5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                } else {
                    sessionInfo2 = sessionInfo5;
                }
                iceBreakingMng.i0(currentAccountUin, 3, i3, sessionInfo2.f179557e);
                return;
            }
            return;
        }
        if (IceBreakingUtil.x(this.oldUinType)) {
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
            if (troopInfoFromCache != null && troopInfoFromCache.isTroopBlocked) {
                z16 = true;
            } else {
                z16 = false;
            }
            TroopInfo troopInfoFromCache2 = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
            if (troopInfoFromCache2 != null && troopInfoFromCache2.isHomeworkTroop()) {
                z17 = true;
            }
            if (!z16 && !z17 && !iceBreakingMng.H(str)) {
                iceBreakingMng.i0(q().getCurrentUin(), 3, 2, str);
                return;
            }
            return;
        }
        if (IceBreakingUtil.u(this.oldUinType)) {
            s();
            return;
        }
        if (this.oldUinType == 1046) {
            SessionInfo sessionInfo6 = this.mSessionInfo;
            if (sessionInfo6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo2 = sessionInfo6;
            }
            if (!sessionInfo2.f179557e.equals("256111111111111111")) {
                QLog.d("IceBreakHelper", 1, "updateIceBreakPokeShow enter matchfriendicebreakshow judge logic!");
                if (!iceBreakingMng.F(str)) {
                    iceBreakingMng.i0(q().getCurrentUin(), 3, 15, str);
                    return;
                }
                return;
            }
        }
        if (IceBreakingUtil.w(this.oldUinType)) {
            if (!iceBreakingMng.G(str)) {
                iceBreakingMng.i0(q().getCurrentUin(), 3, 5, str);
            }
        } else if (IceBreakingUtil.t(this.oldUinType)) {
            ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).reqCanShowIceBreakImages(str, new e(iceBreakingMng, str));
        }
    }
}
