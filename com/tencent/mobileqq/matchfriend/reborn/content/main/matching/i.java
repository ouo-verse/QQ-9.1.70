package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoCanImmediateMatchReq;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoCanImmediateMatchRsp;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoCancelImmediateMatchReq;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoJoinImmediateMatchQueueReq;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoJoinImmediateMatchQueueRsp;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoPullImmediateMatchResultReq;
import com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoPullImmediateMatchResultRsp;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 =2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0019R\u0016\u0010/\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0019R\u0016\u00100\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R*\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/a;", "", "E", UserInfo.SEX_FEMALE, "y", "v", "w", "o", "r", "l", "", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "start", "k", DomainData.DOMAIN_NAME, "b", "a", "j", "Landroid/app/Activity;", "", "I", "state", "c", "Z", "isMatchSuccess", "", "d", "J", "loadingStartTime", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/t;", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/t;", "fullscreenLoading", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog;", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog;", "failDialog", "g", "queryGap", tl.h.F, "queryMaxCount", "i", "queryTimes", "matchSeq", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnMatchingChatEnd", "()Lkotlin/jvm/functions/Function0;", BdhLogUtil.LogTag.Tag_Conn, "(Lkotlin/jvm/functions/Function0;)V", "onMatchingChatEnd", "getOnMatchingChatCancel", "B", "onMatchingChatCancel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class i implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isMatchSuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long loadingStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t fullscreenLoading = new t();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerMatchDialog failDialog = new QQStrangerMatchDialog(this);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int queryGap = 1000;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int queryMaxCount = 10;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int queryTimes;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long matchSeq;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onMatchingChatEnd;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onMatchingChatCancel;

    private final boolean D() {
        return System.currentTimeMillis() - this.loadingStartTime < 5000;
    }

    private final void E() {
        int i3 = this.state;
        if (i3 + 1 > 5) {
            return;
        }
        int i16 = i3 + 1;
        this.state = i16;
        if (i16 == 0) {
            y();
            return;
        }
        if (i16 == 1) {
            v();
            return;
        }
        if (i16 == 2) {
            w();
            return;
        }
        if (i16 == 3) {
            o();
        } else if (i16 == 4) {
            r();
        } else {
            if (i16 != 5) {
                return;
            }
            z();
        }
    }

    private final void l() {
        if (com.tencent.mobileqq.utils.u.a().b()) {
            return;
        }
        QLog.i("QQStrangerMatchChatManager", 1, "onCancel");
        if (j() && this.isMatchSuccess && D()) {
            QQToastUtil.showQQToastInUiThread(0, "\u5339\u914d\u6210\u529f\uff0c\u8df3\u8f6c\u4e2d...");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.ImmediateMatch.SsoCancelImmediateMatch", new MessageMicro<immediateMatch$SsoCancelImmediateMatchReq>() { // from class: com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoCancelImmediateMatchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], immediateMatch$SsoCancelImmediateMatchReq.class);
        }.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.h
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                i.m(i3, z16, obj);
            }
        });
        this.fullscreenLoading.d(this.activity);
        Function0<Unit> function0 = this.onMatchingChatCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, boolean z16, Object obj) {
        QLog.i("QQStrangerMatchChatManager", 1, "onCancel,isSuccess=" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(long j3, i this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        QLog.i("QQStrangerMatchChatManager", 1, "onJoinPool,isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            immediateMatch$SsoJoinImmediateMatchQueueRsp immediatematch_ssojoinimmediatematchqueuersp = new immediateMatch$SsoJoinImmediateMatchQueueRsp();
            try {
                immediatematch_ssojoinimmediatematchqueuersp.mergeFrom((byte[]) obj);
                if (immediatematch_ssojoinimmediatematchqueuersp.ret_code.get() != 0) {
                    QLog.e("QQStrangerMatchChatManager", 1, "onJoinPool,fail,retCode=" + immediatematch_ssojoinimmediatematchqueuersp.ret_code.get());
                    this$0.F();
                    QQStrangerMatchDialog qQStrangerMatchDialog = this$0.failDialog;
                    Activity activity = this$0.activity;
                    int i16 = immediatematch_ssojoinimmediatematchqueuersp.ret_code.get();
                    String str = immediatematch_ssojoinimmediatematchqueuersp.ret_msg.get();
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.ret_msg.get()");
                    qQStrangerMatchDialog.t(activity, i16, str, false);
                    return;
                }
                this$0.queryGap = immediatematch_ssojoinimmediatematchqueuersp.loading_gap.get();
                int i17 = immediatematch_ssojoinimmediatematchqueuersp.loading_max_count.get();
                this$0.queryMaxCount = i17;
                QLog.i("QQStrangerMatchChatManager", 1, "onJoinPool,queryGap=" + this$0.queryGap + ",queryMaxCount=" + i17);
                this$0.E();
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchChatManager", 1, "onJoinPool,error", e16);
                this$0.F();
                this$0.failDialog.t(this$0.activity, 2000, "", false);
                return;
            }
        }
        this$0.F();
        this$0.failDialog.t(this$0.activity, 2000, "", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    private final void r() {
        QLog.i("QQStrangerMatchChatManager", 1, "onMatching");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            F();
            this.failDialog.t(this.activity, 2000, "", false);
            return;
        }
        this.queryTimes++;
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        MessageMicro<immediateMatch$SsoPullImmediateMatchResultReq> messageMicro = new MessageMicro<immediateMatch$SsoPullImmediateMatchResultReq>() { // from class: com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoPullImmediateMatchResultReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], immediateMatch$SsoPullImmediateMatchResultReq.class);
        };
        final long j3 = this.matchSeq;
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.ImmediateMatch.SsoPullImmediateMatchResult", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.e
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                i.s(j3, this, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(long j3, i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fullscreenLoading.d(this$0.activity);
    }

    private final void v() {
        QLog.i("QQStrangerMatchChatManager", 1, "onNetCheck");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            F();
            Function0<Unit> function0 = this.onMatchingChatEnd;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        E();
    }

    private final void w() {
        QLog.i("QQStrangerMatchChatManager", 1, "onPreCheck");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            F();
            this.failDialog.t(this.activity, 2000, "", true);
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        MessageMicro<immediateMatch$SsoCanImmediateMatchReq> messageMicro = new MessageMicro<immediateMatch$SsoCanImmediateMatchReq>() { // from class: com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoCanImmediateMatchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], immediateMatch$SsoCanImmediateMatchReq.class);
        };
        final long j3 = this.matchSeq;
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.ImmediateMatch.SsoCanImmediateMatch", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.d
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                i.x(j3, this, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(long j3, i this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        QLog.i("QQStrangerMatchChatManager", 1, "onPreCheck,isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            immediateMatch$SsoCanImmediateMatchRsp immediatematch_ssocanimmediatematchrsp = new immediateMatch$SsoCanImmediateMatchRsp();
            try {
                immediatematch_ssocanimmediatematchrsp.mergeFrom((byte[]) obj);
                if (immediatematch_ssocanimmediatematchrsp.ret_code.get() != 0) {
                    QLog.e("QQStrangerMatchChatManager", 1, "onPreCheck,fail,retCode=" + immediatematch_ssocanimmediatematchrsp.ret_code.get());
                    this$0.F();
                    QQStrangerMatchDialog qQStrangerMatchDialog = this$0.failDialog;
                    Activity activity = this$0.activity;
                    int i16 = immediatematch_ssocanimmediatematchrsp.ret_code.get();
                    String str = immediatematch_ssocanimmediatematchrsp.ret_msg.get();
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.ret_msg.get()");
                    qQStrangerMatchDialog.t(activity, i16, str, true);
                    return;
                }
                this$0.E();
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchChatManager", 1, "onPreCheck,error", e16);
                this$0.F();
                this$0.failDialog.t(this$0.activity, 2000, "", true);
                return;
            }
        }
        this$0.F();
        this$0.failDialog.t(this$0.activity, 2000, "", true);
    }

    public void A(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.fullscreenLoading.h(activity, 3);
    }

    public final void B(Function0<Unit> function0) {
        this.onMatchingChatCancel = function0;
    }

    public final void C(Function0<Unit> function0) {
        this.onMatchingChatEnd = function0;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void a() {
        Function0<Unit> function0 = this.onMatchingChatCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void b() {
        Function0<Unit> function0 = this.onMatchingChatEnd;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public boolean j() {
        return this.state >= 5;
    }

    public boolean k() {
        QLog.i("QQStrangerMatchChatManager", 1, "onBackEvent");
        if (!this.fullscreenLoading.getIsLoadingState()) {
            return false;
        }
        F();
        return true;
    }

    private final void F() {
        QLog.i("QQStrangerMatchChatManager", 1, "stop");
        this.state = 5;
        this.fullscreenLoading.d(this.activity);
    }

    private final void o() {
        QLog.i("QQStrangerMatchChatManager", 1, "onJoinPool");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            F();
            this.failDialog.t(this.activity, 2000, "", false);
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        MessageMicro<immediateMatch$SsoJoinImmediateMatchQueueReq> messageMicro = new MessageMicro<immediateMatch$SsoJoinImmediateMatchQueueReq>() { // from class: com.tencent.trpcprotocol.kuolie.immediate_match.immediate_match.immediateMatch$SsoJoinImmediateMatchQueueReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], immediateMatch$SsoJoinImmediateMatchQueueReq.class);
        };
        final long j3 = this.matchSeq;
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.ImmediateMatch.SsoJoinImmediateMatchQueue", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                i.p(j3, this, i3, z16, obj);
            }
        });
        this.fullscreenLoading.m(this.activity, 3, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.q(i.this, view);
            }
        });
        this.loadingStartTime = System.currentTimeMillis();
    }

    private final void y() {
        QLog.i("QQStrangerMatchChatManager", 1, "onStateStart");
        E();
    }

    private final void z() {
        QLog.i("QQStrangerMatchChatManager", 1, "onStepEnd");
        Function0<Unit> function0 = this.onMatchingChatEnd;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void n() {
        this.onMatchingChatEnd = null;
        this.onMatchingChatCancel = null;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void start() {
        QLog.i("QQStrangerMatchChatManager", 1, "onStart");
        if (!QQStrangerMatchingPart.INSTANCE.d()) {
            QQToastUtil.showQQToastInUiThread(0, "\u8be5\u529f\u80fd\u6682\u4e0d\u652f\u6301\u3002");
            return;
        }
        this.state = -1;
        this.isMatchSuccess = false;
        this.matchSeq = System.currentTimeMillis();
        this.queryTimes = 0;
        this.loadingStartTime = 0L;
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final long j3, final i this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq || this$0.j()) {
            return;
        }
        QLog.i("QQStrangerMatchChatManager", 1, "onMatching,queryTimes=" + this$0.queryTimes + ",isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            immediateMatch$SsoPullImmediateMatchResultRsp immediatematch_ssopullimmediatematchresultrsp = new immediateMatch$SsoPullImmediateMatchResultRsp();
            try {
                immediatematch_ssopullimmediatematchresultrsp.mergeFrom((byte[]) obj);
                int i16 = immediatematch_ssopullimmediatematchresultrsp.ret_code.get();
                String str = immediatematch_ssopullimmediatematchresultrsp.ret_msg.get();
                String str2 = immediatematch_ssopullimmediatematchresultrsp.to_openid.get();
                String str3 = immediatematch_ssopullimmediatematchresultrsp.recom_trace.get();
                String str4 = str3 != null ? str3 : "";
                QLog.i("QQStrangerMatchChatManager", 1, "onMatching,retCode=" + i16 + ",retMsg=" + str + ",toOpenId=" + str2 + ",traceId=" + str4);
                if (i16 == 3005 && this$0.queryTimes < this$0.queryMaxCount) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.t(j3, this$0);
                        }
                    }, 16, null, false, this$0.queryGap);
                    return;
                }
                if (i16 == 0) {
                    SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMatchChatSuccessEvent());
                    IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                    Activity activity = this$0.activity;
                    Bundle bundle = new Bundle();
                    bundle.putString("recom_trace", str4);
                    Unit unit = Unit.INSTANCE;
                    iMatchFriendEntryApi.enterMatchFriendAIO(qQAppInterface, activity, str2, 3, bundle);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.u(i.this);
                        }
                    }, 1000L);
                    this$0.isMatchSuccess = true;
                    this$0.E();
                    return;
                }
                this$0.F();
                QQStrangerMatchDialog qQStrangerMatchDialog = this$0.failDialog;
                Activity activity2 = this$0.activity;
                int i17 = immediatematch_ssopullimmediatematchresultrsp.ret_code.get();
                String str5 = immediatematch_ssopullimmediatematchresultrsp.ret_msg.get();
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.ret_msg.get()");
                qQStrangerMatchDialog.t(activity2, i17, str5, false);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchChatManager", 1, "onJoinPool,error", e16);
                this$0.F();
                this$0.failDialog.t(this$0.activity, 2000, "", false);
                return;
            }
        }
        this$0.F();
        this$0.failDialog.t(this$0.activity, 2000, "", false);
    }
}
