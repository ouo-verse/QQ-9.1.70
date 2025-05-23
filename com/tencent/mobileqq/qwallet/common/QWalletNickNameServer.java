package com.tencent.mobileqq.qwallet.common;

import android.os.Bundle;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J:\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/common/QWalletNickNameServer;", "", "", "groupId", "uin", "Lkotlin/Function1;", "", "callback", "b", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/qwallet/data/NickNameInfo;", "c", "", "e", "a", "d", "<init>", "()V", "NickNameIPCModule", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletNickNameServer {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletNickNameServer f277113a = new QWalletNickNameServer();

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J8\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0004\u0012\u00020\b0\u0006J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/common/QWalletNickNameServer$NickNameIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "groupId", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qwallet/data/NickNameInfo;", "", "callback", "getNickNameList", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class NickNameIPCModule extends QIPCModule {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NickNameIPCModule f277114d = new NickNameIPCModule();

        NickNameIPCModule() {
            super(IQWalletNickNameApi.IPC_MODULE_NAME);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 callback, EIPCResult eIPCResult) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            boolean z16 = false;
            if (eIPCResult != null && eIPCResult.isSuccess()) {
                z16 = true;
            }
            if (z16) {
                ArrayList parcelableArrayList = eIPCResult.data.getParcelableArrayList("key_ret_name_info_list");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                callback.invoke(parcelableArrayList);
                return;
            }
            callback.invoke(new ArrayList());
        }

        public final void getNickNameList(@Nullable String groupId, @NotNull List<String> uinList, @NotNull final Function1<? super List<NickNameInfo>, Unit> callback) {
            List mutableList;
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppTranRoomIdServlet.KEY_GROUP_ID, groupId);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) uinList);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            bundle.putStringArrayList("key_in_uin_list", (ArrayList) mutableList);
            QIPCClientHelper.getInstance().getClient().callServer(IQWalletNickNameApi.IPC_MODULE_NAME, "action_get_nick_name_list", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qwallet.common.a
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    QWalletNickNameServer.NickNameIPCModule.c(Function1.this, eIPCResult);
                }
            });
        }

        @Override // eipc.EIPCModule
        @Nullable
        public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, final int callbackId) {
            String str;
            ArrayList<String> arrayList;
            if (Intrinsics.areEqual(action, "action_get_nick_name_list")) {
                if (params != null) {
                    str = params.getString(MiniAppTranRoomIdServlet.KEY_GROUP_ID);
                } else {
                    str = null;
                }
                if (params != null) {
                    arrayList = params.getStringArrayList("key_in_uin_list");
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    callbackResult(callbackId, EIPCResult.createResult(-102, new Bundle()));
                    return null;
                }
                a.f277115a.g(str, arrayList, new Function1<List<? extends NickNameInfo>, Unit>() { // from class: com.tencent.mobileqq.qwallet.common.QWalletNickNameServer$NickNameIPCModule$onCall$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends NickNameInfo> list) {
                        invoke2((List<NickNameInfo>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<NickNameInfo> nickNameList) {
                        List mutableList;
                        Intrinsics.checkNotNullParameter(nickNameList, "nickNameList");
                        Bundle bundle = new Bundle();
                        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) nickNameList);
                        Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable>{ kotlin.collections.TypeAliasesKt.ArrayList<out android.os.Parcelable> }");
                        bundle.putParcelableArrayList("key_ret_name_info_list", (ArrayList) mutableList);
                        QWalletNickNameServer.NickNameIPCModule.f277114d.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                    }
                });
            }
            return null;
        }
    }

    QWalletNickNameServer() {
    }

    @JvmStatic
    public static final void b(@Nullable String groupId, @NotNull String uin, @NotNull final Function1<? super String, Unit> callback) {
        List listOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
        c(groupId, listOf, new Function1<List<? extends NickNameInfo>, Unit>() { // from class: com.tencent.mobileqq.qwallet.common.QWalletNickNameServer$getNickName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends NickNameInfo> list) {
                invoke2((List<NickNameInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<NickNameInfo> it) {
                Object firstOrNull;
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<String, Unit> function1 = callback;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                NickNameInfo nickNameInfo = (NickNameInfo) firstOrNull;
                function1.invoke(nickNameInfo != null ? nickNameInfo.getNickName() : null);
            }
        });
    }

    @JvmStatic
    public static final void c(@Nullable String groupId, @NotNull List<String> uinList, @NotNull Function1<? super List<NickNameInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (f277113a.e()) {
            a.f277115a.g(groupId, uinList, callback);
        } else {
            NickNameIPCModule.f277114d.getNickNameList(groupId, uinList, callback);
        }
    }

    private final boolean e() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String a(@Nullable String groupId) {
        String c16 = com.tencent.mobileqq.base.a.c();
        String d16 = d(groupId, c16);
        if (!Intrinsics.areEqual(d16, c16)) {
            return d16;
        }
        String property = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.nickName.toString() + com.tencent.mobileqq.base.a.c());
        if (property != null) {
            return property;
        }
        return c16;
    }

    @NotNull
    public final String d(@Nullable String groupId, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return a.f277115a.h(groupId, uin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JF\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0004\u0012\u00020\t0\u0007H\u0002J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J8\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0004\u0012\u00020\t0\u0007J\u0018\u0010\u0011\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/common/QWalletNickNameServer$a;", "", "", "groupId", "", SquareJSConst.Params.PARAMS_UIN_LIST, "uidList", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qwallet/data/NickNameInfo;", "", "callback", "e", "Lcom/tencent/mobileqq/troop/d;", "c", "d", "g", "uin", h.F, "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f277115a = new a();

        a() {
        }

        private final void c(String groupId, List<String> uinList, d callback) {
            try {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoByUins(groupId, uinList, false, null, "QWalletNickNameServer", callback);
            } catch (Exception e16) {
                QLog.w("QWalletNickNameServer", 1, "fetchTroopMemberInfoByUinsSafely catch:", e16);
                callback.a(Boolean.FALSE, null);
            }
        }

        private final List<NickNameInfo> d(List<String> uidList) {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList;
            boolean z16;
            ArrayList arrayList2 = new ArrayList();
            try {
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNull(uidList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                arrayList = iFriendsInfoService.getFriendSimpleInfoWithUid((ArrayList) uidList, "QWalletNickNameServer");
            } catch (Exception e16) {
                QLog.w("QWalletNickNameServer", 1, "getC2CNickNameList error:", e16);
                arrayList = null;
            }
            if (arrayList != null) {
                for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : arrayList) {
                    String r16 = dVar.r();
                    String p16 = dVar.p();
                    boolean z17 = false;
                    if (r16 != null && r16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16 || Intrinsics.areEqual(dVar.x(), com.tencent.mobileqq.base.a.c())) {
                        if (p16 == null || p16.length() == 0) {
                            z17 = true;
                        }
                        if (!z17) {
                            r16 = p16;
                        } else {
                            r16 = dVar.x();
                        }
                    }
                    arrayList2.add(new NickNameInfo(dVar.x(), dVar.getUid(), r16));
                }
            }
            QLog.i("QWalletNickNameServer", 1, "getNickNameList C2C: " + uidList.size());
            return arrayList2;
        }

        private final void e(String groupId, final List<String> uinList, final List<String> uidList, final Function1<? super List<NickNameInfo>, Unit> callback) {
            c(groupId, uinList, new d() { // from class: com.tencent.mobileqq.qwallet.common.b
                @Override // com.tencent.mobileqq.troop.d
                public final void a(Boolean bool, List list) {
                    QWalletNickNameServer.a.f(uinList, uidList, callback, bool, list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void f(List uinList, List uidList, Function1 callback, Boolean bool, List list) {
            boolean z16;
            Intrinsics.checkNotNullParameter(uinList, "$uinList");
            Intrinsics.checkNotNullParameter(uidList, "$uidList");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (Object obj : list) {
                    if (obj instanceof TroopMemberInfo) {
                        TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
                        String hBShowName = troopMemberInfo.nickInfo.getHBShowName();
                        if (!Intrinsics.areEqual(hBShowName, troopMemberInfo.memberuin)) {
                            String str = troopMemberInfo.memberuin;
                            Intrinsics.checkNotNullExpressionValue(str, "info.memberuin");
                            arrayList.add(new NickNameInfo(str, troopMemberInfo.memberUid, hBShowName));
                        }
                    }
                }
            }
            QLog.i("QWalletNickNameServer", 1, "getNickNameList " + uinList.size() + " " + arrayList.size());
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : uidList) {
                    String str2 = (String) obj2;
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (!(!Intrinsics.areEqual(((NickNameInfo) it.next()).getUid(), str2))) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                }
                uidList = arrayList2;
            }
            if (!uidList.isEmpty()) {
                QLog.i("QWalletNickNameServer", 1, "noNickNameUidList size=" + uidList.size());
                arrayList.addAll(f277115a.d(uidList));
            }
            callback.invoke(arrayList);
        }

        public final void g(@Nullable String groupId, @NotNull List<String> uinList, @NotNull Function1<? super List<NickNameInfo>, Unit> callback) {
            boolean z16;
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = uinList.iterator();
            while (it.hasNext()) {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin((String) it.next());
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                arrayList.add(uid);
            }
            if (groupId != null && groupId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                e(groupId, uinList, arrayList, callback);
            } else {
                callback.invoke(d(arrayList));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #1 {Exception -> 0x0046, blocks: (B:3:0x000b, B:5:0x0027, B:7:0x002d, B:9:0x0033, B:14:0x003f), top: B:2:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006d A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:20:0x004d, B:22:0x006d, B:24:0x0080), top: B:19:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: Exception -> 0x0089, TRY_LEAVE, TryCatch #0 {Exception -> 0x0089, blocks: (B:20:0x004d, B:22:0x006d, B:24:0x0080), top: B:19:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String h(@Nullable String groupId, @NotNull String uin) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
            TroopMemberInfo troopMemberInfo;
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(uin, "uin");
            NickNameInfo nickNameInfo = null;
            try {
                Object troopMemberFromCacheOrFetchAsync = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getTroopMemberFromCacheOrFetchAsync(groupId, uin, null, "QWalletNickNameServer", new com.tencent.mobileqq.troop.c() { // from class: com.tencent.mobileqq.qwallet.common.c
                    @Override // com.tencent.mobileqq.troop.c
                    public final void a(Object obj) {
                        QWalletNickNameServer.a.i(obj);
                    }
                });
                if (troopMemberFromCacheOrFetchAsync instanceof TroopMemberInfo) {
                    troopMemberInfo = (TroopMemberInfo) troopMemberFromCacheOrFetchAsync;
                } else {
                    troopMemberInfo = null;
                }
                if (troopMemberInfo != null) {
                    str = troopMemberInfo.troopnick;
                } else {
                    str = null;
                }
            } catch (Exception e16) {
                QLog.w("QWalletNickNameServer", 1, "getNickNameSync group error:", e16);
            }
            try {
                if (str != null && str.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        if (!Intrinsics.areEqual(str, uin)) {
                            return str;
                        }
                    }
                    String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(uin);
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "QWalletNickNameServer");
                    if (friendsSimpleInfoWithUid != null) {
                        nickNameInfo = new NickNameInfo(friendsSimpleInfoWithUid.x(), friendsSimpleInfoWithUid.getUid(), friendsSimpleInfoWithUid.p());
                    }
                    if (nickNameInfo == null) {
                        String nickName = nickNameInfo.getNickName();
                        if (nickName != null) {
                            return nickName;
                        }
                        return uin;
                    }
                    return uin;
                }
                String uid2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(uin);
                IFriendsInfoService iFriendsInfoService2 = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid2, "uid");
                friendsSimpleInfoWithUid = iFriendsInfoService2.getFriendsSimpleInfoWithUid(uid2, "QWalletNickNameServer");
                if (friendsSimpleInfoWithUid != null) {
                }
                if (nickNameInfo == null) {
                }
            } catch (Exception e17) {
                QLog.w("QWalletNickNameServer", 1, "getNickNameSync C2C error:", e17);
                return uin;
            }
            z16 = true;
            if (!z16) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Object obj) {
        }
    }
}
