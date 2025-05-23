package com.tencent.mobileqq.troop.troopnotification.repo;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTargetMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTemplateItem;
import com.tencent.qqnt.kernel.nativeinterface.IGroupNotifyOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u00b1\u0001\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2d\u0010\u0013\u001a`\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u00122#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014Jt\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062d\u0010\u0013\u001a`\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u0012J\u0098\u0001\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2d\u0010\u0013\u001a`\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u0012J\u0084\u0001\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2d\u0010\u0013\u001a`\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u0012J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0004JW\u0010\"\u001a\u00020\u00112O\u0010\u0013\u001aK\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110 j\u0002`!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/repo/TroopNotificationOperateRepo;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "", "source", "Lcom/tencent/qqnt/notification/f;", "msg", "", "operateData", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "", "Lcom/tencent/mobileqq/troop/troopnotification/repo/OperateNotificationCallback;", "callback", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateMsg;", "req", "onReq", "p", "j", "extraMsg", "setBlackList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "category", "w", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/troop/troopnotification/repo/ClearNotificationCallback;", "k", "", "b", "[I", "HAD_DEAL_ERROR", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationOperateRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final TroopNotificationOperateRepo f300860a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final int[] HAD_DEAL_ERROR;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59707);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f300860a = new TroopNotificationOperateRepo();
            HAD_DEAL_ERROR = new int[]{120162000, 120162002, 120162003, 120162004, 120162005, 120162006, 120162007};
        }
    }

    TroopNotificationOperateRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final void l(com.tencent.qqnt.report.m cmdReportDoubt, int i3, String str) {
        Intrinsics.checkNotNullParameter(cmdReportDoubt, "$cmdReportDoubt");
        cmdReportDoubt.f();
        QLog.d("TroopNotificationOperateRepo", 1, "clearAllNotification: doubt errCode=" + i3 + ", errMsg=" + str);
        com.tencent.qqnt.report.m.c(cmdReportDoubt, Integer.valueOf(i3), null, str, 2, null);
    }

    public static final void m(com.tencent.qqnt.report.m cmdReport, final Function3 callback, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        cmdReport.f();
        QLog.d("TroopNotificationOperateRepo", 1, "clearAllNotification: not doubt errCode=" + i3 + ", errMsg=" + str);
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.n
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationOperateRepo.n(i3, callback, str);
            }
        });
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    public static final void n(int i3, Function3 callback, String errMsg) {
        boolean z16;
        ITroopNotificationInnerService iTroopNotificationInnerService;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0 && (iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class)) != null) {
            iTroopNotificationInnerService.clearAllNotification();
        }
        if (i3 != 0 && i3 != 5) {
            z16 = false;
        } else {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        Integer valueOf2 = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(valueOf, valueOf2, errMsg);
    }

    public static /* synthetic */ void r(TroopNotificationOperateRepo troopNotificationOperateRepo, com.tencent.qqnt.notification.f fVar, int i3, String str, String str2, boolean z16, Function4 function4, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        troopNotificationOperateRepo.q(fVar, i3, str, str3, z16, function4);
    }

    public static final void s(com.tencent.qqnt.report.m cmdReport, final GroupNotifyOperateType operateType, final com.tencent.qqnt.notification.f msg2, final Function4 callback, final int i3, final int i16, final String str, final GroupNotifyOperateRsp groupNotifyOperateRsp) {
        boolean contains;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(operateType, "$operateType");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        cmdReport.f();
        QLog.d("TroopNotificationOperateRepo", 1, "operateNotification: operateType=" + operateType + ", errCode=" + i16 + ", errMsg=" + str + ", msg=" + msg2);
        contains = ArraysKt___ArraysKt.contains(HAD_DEAL_ERROR, i16);
        if (contains) {
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.g
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationOperateRepo.t(i16, msg2, callback, str);
                }
            });
        } else {
            bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.h
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationOperateRepo.u(GroupNotifyOperateRsp.this, msg2, i3, i16, operateType, callback, str);
                }
            });
        }
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i16), null, str, 2, null);
    }

    public static final void t(int i3, com.tencent.qqnt.notification.f msg2, Function4 callback, String errMsg) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 120162000) {
            msg2.m(true);
        }
        if (i3 == 120162007) {
            msg2.n(true);
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            iTroopNotificationInnerService.updateNotificationMsg(msg2);
        }
        Boolean bool = Boolean.FALSE;
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(bool, valueOf, errMsg, msg2);
    }

    public static final void u(GroupNotifyOperateRsp groupNotifyOperateRsp, final com.tencent.qqnt.notification.f msg2, int i3, final int i16, final GroupNotifyOperateType operateType, final Function4 callback, final String str) {
        final com.tencent.qqnt.notification.f fVar;
        List<GroupNotifyMsg> listOf;
        Object firstOrNull;
        com.tencent.qqnt.notification.f k3;
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(operateType, "$operateType");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (groupNotifyOperateRsp.item.seq != 0) {
            Intrinsics.checkNotNullExpressionValue(groupNotifyOperateRsp.templates, "rsp.templates");
            if (!r0.isEmpty()) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(groupNotifyOperateRsp.item);
                long j3 = msg2.j().seq;
                com.tencent.mobileqq.troop.troopnotification.utils.b bVar = com.tencent.mobileqq.troop.troopnotification.utils.b.f300925a;
                ArrayList<GroupNotifyTemplateItem> arrayList = groupNotifyOperateRsp.templates;
                Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.templates");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.h(i3, listOf, arrayList, j3, "TroopNotificationOperateRepo-operateNotification"));
                com.tencent.qqnt.notification.f fVar2 = (com.tencent.qqnt.notification.f) firstOrNull;
                if (fVar2 != null && (k3 = fVar2.k(msg2)) != null) {
                    fVar = k3;
                    bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopNotificationOperateRepo.v(i16, operateType, msg2, fVar, callback, str);
                        }
                    });
                }
            }
        }
        fVar = msg2;
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.m
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationOperateRepo.v(i16, operateType, msg2, fVar, callback, str);
            }
        });
    }

    public static final void v(int i3, GroupNotifyOperateType operateType, com.tencent.qqnt.notification.f msg2, com.tencent.qqnt.notification.f resultMsg, Function4 callback, String errMsg) {
        boolean z16;
        ITroopNotificationInnerService iTroopNotificationInnerService;
        Intrinsics.checkNotNullParameter(operateType, "$operateType");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(resultMsg, "$resultMsg");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0) {
            if (operateType == GroupNotifyOperateType.KDELETE) {
                ITroopNotificationInnerService iTroopNotificationInnerService2 = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
                if (iTroopNotificationInnerService2 != null) {
                    iTroopNotificationInnerService2.removeNotificationMsg(msg2);
                }
            } else if (!Intrinsics.areEqual(msg2, resultMsg) && (iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class)) != null) {
                iTroopNotificationInnerService.updateNotificationMsg(resultMsg);
            }
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        Integer valueOf2 = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(valueOf, valueOf2, errMsg, resultMsg);
    }

    public static final void x(com.tencent.qqnt.report.m cmdReport, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationOperateRepo", 2, "readAllNotification: category=" + i3 + ", errCode=" + i16 + ", " + str);
        }
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i16), null, str, 2, null);
    }

    public static final void y(com.tencent.qqnt.report.m cmdReport, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationOperateRepo", 2, "readAllNotification: category=" + i3 + ", errCode=" + i16 + ", " + str);
        }
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i16), null, str, 2, null);
    }

    public final void j(@NotNull com.tencent.qqnt.notification.f msg2, @NotNull Function4<? super Boolean, ? super Integer, ? super String, ? super com.tencent.qqnt.notification.f, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        p(GroupNotifyOperateType.KREFUSE, 2, msg2, "", callback, TroopNotificationOperateRepo$blackListNotification$1.INSTANCE);
    }

    public final void k(@NotNull final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("clearGroupNotifies", null, "TroopNotificationOperateRepo-clearAllNotification-false", false, false, 18, null);
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.clearGroupNotifies(false, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    TroopNotificationOperateRepo.m(com.tencent.qqnt.report.m.this, callback, i16, str);
                }
            });
        }
        final com.tencent.qqnt.report.m mVar2 = new com.tencent.qqnt.report.m("clearGroupNotifies", null, "TroopNotificationOperateRepo-clearAllNotification-true", false, false, 18, null);
        s i16 = bg.i(null, 1, null);
        if (i16 != null) {
            i16.clearGroupNotifies(true, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i17, String str) {
                    TroopNotificationOperateRepo.l(com.tencent.qqnt.report.m.this, i17, str);
                }
            });
        }
    }

    public final void o(@NotNull com.tencent.qqnt.notification.f msg2, int source, @NotNull String operateData, @NotNull Function4<? super Boolean, ? super Integer, ? super String, ? super com.tencent.qqnt.notification.f, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, msg2, Integer.valueOf(source), operateData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(operateData, "operateData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        p(GroupNotifyOperateType.KDELETE, source, msg2, operateData, callback, null);
    }

    public final void p(@NotNull final GroupNotifyOperateType operateType, int source, @NotNull final com.tencent.qqnt.notification.f msg2, @NotNull String operateData, @NotNull final Function4<? super Boolean, ? super Integer, ? super String, ? super com.tencent.qqnt.notification.f, Unit> callback, @Nullable Function1<? super GroupNotifyOperateMsg, Unit> onReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, operateType, Integer.valueOf(source), msg2, operateData, callback, onReq);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(operateData, "operateData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("TroopNotificationOperateRepo", 1, "operateNotification: operateType=" + operateType + ", msg=" + msg2);
        GroupNotifyOperateMsg groupNotifyOperateMsg = new GroupNotifyOperateMsg();
        groupNotifyOperateMsg.operateType = operateType;
        groupNotifyOperateMsg.operateSource = source;
        GroupNotifyTargetMsg groupNotifyTargetMsg = new GroupNotifyTargetMsg();
        groupNotifyTargetMsg.seq = msg2.j().seq;
        groupNotifyTargetMsg.type = msg2.j().type;
        groupNotifyTargetMsg.groupCode = msg2.j().group.groupCode;
        groupNotifyTargetMsg.operateData = operateData;
        groupNotifyTargetMsg.operateTransInfo = msg2.j().operateTransInfo;
        groupNotifyOperateMsg.targetMsg = groupNotifyTargetMsg;
        if (onReq != null) {
            onReq.invoke(groupNotifyOperateMsg);
        }
        final int c16 = msg2.c();
        if (c16 == -1000) {
            z16 = true;
        }
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("operateSysNotifyV2", null, "TroopNotificationOperateRepo-operateNotification-" + z16, false, false, 18, null);
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.operateSysNotifyV2(z16, groupNotifyOperateMsg, new IGroupNotifyOperateCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupNotifyOperateCallback
                public final void onResult(int i16, String str, GroupNotifyOperateRsp groupNotifyOperateRsp) {
                    TroopNotificationOperateRepo.s(com.tencent.qqnt.report.m.this, operateType, msg2, callback, c16, i16, str, groupNotifyOperateRsp);
                }
            });
        }
    }

    public final void q(@NotNull com.tencent.qqnt.notification.f msg2, int i3, @NotNull String operateData, @NotNull String extraMsg, boolean z16, @NotNull Function4<? super Boolean, ? super Integer, ? super String, ? super com.tencent.qqnt.notification.f, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg2, Integer.valueOf(i3), operateData, extraMsg, Boolean.valueOf(z16), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(operateData, "operateData");
        Intrinsics.checkNotNullParameter(extraMsg, "extraMsg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        p(GroupNotifyOperateType.KGENERAL, i3, msg2, operateData, callback, new Function1<GroupNotifyOperateMsg, Unit>(extraMsg, z16) { // from class: com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationOperateRepo$operateNotification$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $extraMsg;
            final /* synthetic */ boolean $setBlackList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$extraMsg = extraMsg;
                this.$setBlackList = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, extraMsg, Boolean.valueOf(z16));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupNotifyOperateMsg groupNotifyOperateMsg) {
                invoke2(groupNotifyOperateMsg);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupNotifyOperateMsg it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                GroupNotifyTargetMsg groupNotifyTargetMsg = it.targetMsg;
                groupNotifyTargetMsg.postscript = this.$extraMsg;
                groupNotifyTargetMsg.setBlackList = this.$setBlackList;
            }
        });
    }

    public final void w(final int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, category);
            return;
        }
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("clearGroupNotifiesUnreadCount", null, "TroopNotificationOperateRepo-readAllNotification-" + category, false, false, 18, null);
        boolean z16 = false;
        if (category != -1000 && category != 0) {
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.clearGroupNotifyLocalUnreadCount(false, category, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.j
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str) {
                        TroopNotificationOperateRepo.y(com.tencent.qqnt.report.m.this, category, i16, str);
                    }
                });
                return;
            }
            return;
        }
        if (category == -1000) {
            z16 = true;
        }
        s i16 = bg.i(null, 1, null);
        if (i16 != null) {
            i16.clearGroupNotifiesUnreadCount(z16, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopnotification.repo.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i17, String str) {
                    TroopNotificationOperateRepo.x(com.tencent.qqnt.report.m.this, category, i17, str);
                }
            });
        }
    }
}
