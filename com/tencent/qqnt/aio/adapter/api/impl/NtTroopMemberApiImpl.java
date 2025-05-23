package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJY\u0010\u0010\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000eH\u0016JS\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022/\u0010\u000f\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u0013H\u0016J_\u0010\u001a\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u0019H\u0016J \u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/NtTroopMemberApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/INtTroopMemberApi;", "", "troopUin", "memberUid", "", "forceNet", "from", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/ParameterName;", "name", "memberInfo", "", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberInfoCallback;", "callback", "fetchTroopMemberInfo", "", "memberInfoList", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberListCallback;", "fetchTroopMemberList", "needColorName", "needRemark", "Lcom/tencent/qqnt/aio/adapter/troop/a;", "nickInfo", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberNameCallback;", "fetchTroopMemberName", "needColorNick", "getShowName", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NtTroopMemberApiImpl implements INtTroopMemberApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NtTroopMemberApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/NtTroopMemberApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.NtTroopMemberApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtTroopMemberApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberInfo$lambda$1$lambda$0(com.tencent.qqnt.report.m cmdReport, String str, Function1 function1, int i3, String str2, GroupMemberListResult groupMemberListResult) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        MemberInfo memberInfo = groupMemberListResult.infos.get(str);
        if (function1 != null) {
            function1.invoke(memberInfo);
        }
        if (i3 != 0) {
            com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str2, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberList$lambda$3$lambda$2(com.tencent.qqnt.report.m cmdReport, com.tencent.qqnt.report.l report, Function1 function1, boolean z16, String str, int i3, String str2, GroupMemberListResult groupMemberListResult) {
        Integer num;
        ArrayList<GroupMemberInfoListId> arrayList;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(report, "$report");
        cmdReport.f();
        if (groupMemberListResult != null && (arrayList = groupMemberListResult.ids) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        report.j(num, Integer.valueOf(i3), str2);
        ArrayList arrayList2 = new ArrayList();
        Collection<MemberInfo> values = groupMemberListResult.infos.values();
        Intrinsics.checkNotNullExpressionValue(values, "result.infos.values");
        arrayList2.addAll(values);
        if (function1 != null) {
            function1.invoke(arrayList2);
        }
        if (i3 == 0 && z16) {
            TroopMemberListRepo.INSTANCE.updateMemberDBVersionAfterNetRsp(str);
        }
        report.b();
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str2, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable final String memberUid, boolean forceNet, @NotNull String from, @Nullable final Function1<? super MemberInfo, Unit> callback) {
        boolean z16;
        boolean z17;
        Long longOrNull;
        long j3;
        ArrayList<String> arrayListOf;
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUid, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(troopUin);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (memberUid != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(memberUid);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "fetchTroopMemberInfo: troopUin=" + troopUin + ", memberUid=" + memberUid + ", from=" + from);
                                }
                                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                                if (longOrNull != null) {
                                    j3 = longOrNull.longValue();
                                } else {
                                    j3 = 0;
                                }
                                long j16 = j3;
                                com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
                                if (c16 != null) {
                                    String str = "NtTroopMemberApiImpl-fetchTroopMemberInfo-" + from;
                                    final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberInfoForMqq", troopUin, str, forceNet, true);
                                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(memberUid);
                                    c16.e(j16, arrayListOf, forceNet, str, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ar
                                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                                        public final void onResult(int i3, String str2, GroupMemberListResult groupMemberListResult) {
                                            NtTroopMemberApiImpl.fetchTroopMemberInfo$lambda$1$lambda$0(com.tencent.qqnt.report.m.this, memberUid, callback, i3, str2, groupMemberListResult);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                QLog.e(TAG, 1, "fetchTroopMemberInfo: ");
                if (callback == null) {
                    callback.invoke(null);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.e(TAG, 1, "fetchTroopMemberInfo: ");
        if (callback == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r0 != false) goto L12;
     */
    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchTroopMemberList(@Nullable final String troopUin, final boolean forceNet, @NotNull String from, @Nullable final Function1<? super List<MemberInfo>, Unit> callback) {
        Long longOrNull;
        long j3;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(troopUin);
        }
        z16 = true;
        if (z16) {
            QLog.e(TAG, 1, "fetchTroopMemberList: ");
            if (callback != null) {
                callback.invoke(new ArrayList());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchTroopMemberList: troopUin=" + troopUin + ", from=" + from);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getAllMemberList", troopUin, "NtTroopMemberApiImpl-fetchTroopMemberList-" + from, forceNet, false, 16, null);
            final com.tencent.qqnt.report.l lVar = new com.tencent.qqnt.report.l(troopUin, from, forceNet, false, 8, null);
            com.tencent.qqnt.report.a.o(lVar, null, 1, null);
            c16.getAllMemberList(j16, forceNet, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.as
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                    NtTroopMemberApiImpl.fetchTroopMemberList$lambda$3$lambda$2(com.tencent.qqnt.report.m.this, lVar, callback, forceNet, troopUin, i3, str, groupMemberListResult);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    public void fetchTroopMemberName(@Nullable final String troopUin, @Nullable final String memberUid, boolean needColorName, boolean needRemark, @NotNull String from, @Nullable final Function1<? super com.tencent.qqnt.aio.adapter.troop.a, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, memberUid, Boolean.valueOf(needColorName), Boolean.valueOf(needRemark), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        final String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(memberUid);
        TroopMemberListRepo.INSTANCE.fetchTroopMemberName(troopUin, uinFromUid, from, new Function1<TroopMemberNickInfo, Unit>(callback, troopUin, uinFromUid, memberUid) { // from class: com.tencent.qqnt.aio.adapter.api.impl.NtTroopMemberApiImpl$fetchTroopMemberName$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<com.tencent.qqnt.aio.adapter.troop.a, Unit> $callback;
            final /* synthetic */ String $memberUid;
            final /* synthetic */ String $troopUin;
            final /* synthetic */ String $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callback = callback;
                this.$troopUin = troopUin;
                this.$uin = uinFromUid;
                this.$memberUid = memberUid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, callback, troopUin, uinFromUid, memberUid);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                invoke2(troopMemberNickInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                String str;
                String autoRemark;
                String troopNick;
                String colorNick;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                    return;
                }
                Function1<com.tencent.qqnt.aio.adapter.troop.a, Unit> function1 = this.$callback;
                if (function1 != null) {
                    String str2 = this.$troopUin;
                    String str3 = str2 == null ? "" : str2;
                    String uin = this.$uin;
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    String str4 = this.$memberUid;
                    String str5 = str4 == null ? "" : str4;
                    String str6 = (troopMemberNickInfo == null || (colorNick = troopMemberNickInfo.getColorNick()) == null) ? "" : colorNick;
                    int colorNickId = troopMemberNickInfo != null ? troopMemberNickInfo.getColorNickId() : 0;
                    String str7 = (troopMemberNickInfo == null || (troopNick = troopMemberNickInfo.getTroopNick()) == null) ? "" : troopNick;
                    String str8 = (troopMemberNickInfo == null || (autoRemark = troopMemberNickInfo.getAutoRemark()) == null) ? "" : autoRemark;
                    if (troopMemberNickInfo == null || (str = troopMemberNickInfo.getFriendNick()) == null) {
                        str = "";
                    }
                    function1.invoke(new com.tencent.qqnt.aio.adapter.troop.a(str3, uin, str5, str6, colorNickId, str7, str8, str));
                }
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    @NotNull
    public String getShowName(@NotNull com.tencent.qqnt.aio.adapter.troop.a nickInfo, boolean needColorNick, boolean needRemark) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, nickInfo, Boolean.valueOf(needColorNick), Boolean.valueOf(needRemark));
        }
        Intrinsics.checkNotNullParameter(nickInfo, "nickInfo");
        return new TroopMemberNickInfo(nickInfo.h(), nickInfo.j(), nickInfo.i(), nickInfo.b(), nickInfo.c(), nickInfo.g(), nickInfo.a(), nickInfo.d(), null, null, null, 1792, null).getShowName(needColorNick, needRemark);
    }
}
