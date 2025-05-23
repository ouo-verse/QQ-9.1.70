package com.tencent.mobileqq.troop.livesync.repository;

import android.os.Handler;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.livesync.repository.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsReq;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsRsp;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncRoomIDReq;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncRoomIDRsp;
import tencent.trpcprotocol.TroopLiveSyncSvr$GroupInfo;
import tencent.trpcprotocol.TroopLiveSyncSvr$SetSyncGroupReq;
import tencent.trpcprotocol.TroopLiveSyncSvr$SetSyncGroupRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J&\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002Js\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u0018j\u0002`\u001c2:\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001ej\u0002`!H\u0016J\u0089\u0001\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u0018j\u0002`%2:\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001ej\u0002`!H\u0016Js\u0010*\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00072%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u0018j\u0002`)2:\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001ej\u0002`!H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/repository/c;", "Lcom/tencent/mobileqq/troop/livesync/repository/ITroopLiveSyncRepository;", "", "roomId", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "rspGroup", "", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopMap", "", "g", "", "syncSwitch", "", "troopIds", "i", "", "method", "", "data", "Lcom/tencent/mobileqq/troop/api/f;", "callback", h.F, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rsp", "Lcom/tencent/mobileqq/troop/livesync/repository/GetSyncGroupsSuccessBlock;", "successBlock", "Lkotlin/Function2;", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/troop/livesync/repository/TroopLiveSyncErrorBlock;", "errorBlock", "a", "Ltencent/trpcprotocol/TroopLiveSyncSvr$SetSyncGroupRsp;", "Lcom/tencent/mobileqq/troop/livesync/repository/SetSyncGroupSuccessBlock;", "f", IProfileProtocolConst.PARAM_TROOP_CODE, "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncRoomIDRsp;", "Lcom/tencent/mobileqq/troop/livesync/repository/GetSyncRoomIDSuccessBlock;", "e", "c", "d", "", "b", "Ljava/util/Map;", "syncTroopCache", "troopsInfo", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c implements ITroopLiveSyncRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f297726a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, TroopLiveSyncSvr$GetSyncGroupsRsp> syncTroopCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<Long, ? extends TroopInfo> troopsInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/livesync/repository/c$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f297729a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<TroopLiveSyncSvr$GetSyncGroupsRsp, Unit> f297730b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f297731c;

        a(int i3, Function1<? super TroopLiveSyncSvr$GetSyncGroupsRsp, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f297729a = i3;
            this.f297730b = function1;
            this.f297731c = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), function1, function2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final int i3, final TroopLiveSyncSvr$GetSyncGroupsRsp rspModel, final Function1 successBlock, List infos) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(rspModel, "$rspModel");
            Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullExpressionValue(infos, "infos");
            Iterator it = infos.iterator();
            while (it.hasNext()) {
                TroopInfo troopInfo = (TroopInfo) it.next();
                String troopUin = troopInfo.getTroopUin();
                if (troopUin != null) {
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                    if (longOrNull != null) {
                        linkedHashMap.put(Long.valueOf(longOrNull.longValue()), troopInfo);
                    }
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.livesync.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.f(i3, rspModel, linkedHashMap, successBlock);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(int i3, TroopLiveSyncSvr$GetSyncGroupsRsp rspModel, Map troopMap, Function1 successBlock) {
            Intrinsics.checkNotNullParameter(rspModel, "$rspModel");
            Intrinsics.checkNotNullParameter(troopMap, "$troopMap");
            Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
            c.f297726a.g(i3, rspModel, troopMap);
            successBlock.invoke(rspModel);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("TroopLiveSync", 1, "rsp GetSyncGroups error, [roomId:" + this.f297729a + " code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f297731c;
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            function2.invoke(valueOf, str);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            final TroopLiveSyncSvr$GetSyncGroupsRsp troopLiveSyncSvr$GetSyncGroupsRsp = new TroopLiveSyncSvr$GetSyncGroupsRsp();
            f.b(troopLiveSyncSvr$GetSyncGroupsRsp, rsp.data);
            int i3 = this.f297729a;
            List<TroopLiveSyncSvr$GroupInfo> list = troopLiveSyncSvr$GetSyncGroupsRsp.able_sync_groups.get();
            Intrinsics.checkNotNullExpressionValue(list, "rspModel.able_sync_groups.get()");
            int size = list.size();
            List<TroopLiveSyncSvr$GroupInfo> list2 = troopLiveSyncSvr$GetSyncGroupsRsp.unable_sync_groups.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rspModel.unable_sync_groups.get()");
            QLog.i("TroopLiveSync", 1, "rsp GetSyncGroups success, [roomId:" + i3 + " ableCount:" + size + " unableCount:" + list2.size() + "]");
            ISelectMemberApi iSelectMemberApi = (ISelectMemberApi) QRoute.api(ISelectMemberApi.class);
            final int i16 = this.f297729a;
            final Function1<TroopLiveSyncSvr$GetSyncGroupsRsp, Unit> function1 = this.f297730b;
            iSelectMemberApi.getCreatedTroopListAsync(false, new Consumer() { // from class: com.tencent.mobileqq.troop.livesync.repository.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    c.a.e(i16, troopLiveSyncSvr$GetSyncGroupsRsp, function1, (List) obj);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/livesync/repository/c$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f297732a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> f297733b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f297734c;

        b(long j3, Function1<? super TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f297732a = j3;
            this.f297733b = function1;
            this.f297734c = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), function1, function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("TroopLiveSync", 1, "rsp GetSyncRoomID error, [groupCode:" + this.f297732a + " code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f297734c;
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            function2.invoke(valueOf, str);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            TroopLiveSyncSvr$GetSyncRoomIDRsp troopLiveSyncSvr$GetSyncRoomIDRsp = new TroopLiveSyncSvr$GetSyncRoomIDRsp();
            f.b(troopLiveSyncSvr$GetSyncRoomIDRsp, rsp.data);
            QLog.i("TroopLiveSync", 1, "rsp GetSyncRoomID success, [groupCode:" + this.f297732a + "]");
            this.f297733b.invoke(troopLiveSyncSvr$GetSyncRoomIDRsp);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/livesync/repository/c$c", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.livesync.repository.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8759c implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f297735a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f297736b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f297737c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<TroopLiveSyncSvr$SetSyncGroupRsp, Unit> f297738d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f297739e;

        C8759c(int i3, boolean z16, List<Long> list, Function1<? super TroopLiveSyncSvr$SetSyncGroupRsp, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f297735a = i3;
            this.f297736b = z16;
            this.f297737c = list;
            this.f297738d = function1;
            this.f297739e = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), list, function1, function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("TroopLiveSync", 1, "rsp SetSyncGroups error, [roomId:" + this.f297735a + " code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f297739e;
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            function2.invoke(valueOf, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            MessageMicro<TroopLiveSyncSvr$SetSyncGroupRsp> messageMicro = new MessageMicro<TroopLiveSyncSvr$SetSyncGroupRsp>() { // from class: tencent.trpcprotocol.TroopLiveSyncSvr$SetSyncGroupRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"sync_succ_num"}, new Object[]{0}, TroopLiveSyncSvr$SetSyncGroupRsp.class);
                public final PBUInt32Field sync_succ_num = PBField.initUInt32(0);
            };
            f.b(messageMicro, rsp.data);
            QLog.i("TroopLiveSync", 1, "rsp SetSyncGroups success, [roomId:" + this.f297735a + " switch:" + this.f297736b + " ids:" + this.f297737c.size() + "]");
            this.f297738d.invoke(messageMicro);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/livesync/repository/c$d", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.api.f f297740a;

        d(com.tencent.mobileqq.troop.api.f fVar) {
            this.f297740a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(com.tencent.mobileqq.troop.api.f callback, TroopTrpcRemoteResponse error) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(error, "$error");
            callback.a(error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(com.tencent.mobileqq.troop.api.f callback, TroopTrpcRemoteResponse rsp) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            callback.b(rsp);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull final TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final com.tencent.mobileqq.troop.api.f fVar = this.f297740a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.livesync.repository.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.e(com.tencent.mobileqq.troop.api.f.this, error);
                }
            });
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull final TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final com.tencent.mobileqq.troop.api.f fVar = this.f297740a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.livesync.repository.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.f(com.tencent.mobileqq.troop.api.f.this, rsp);
                }
            });
        }
    }

    static {
        Map<Long, ? extends TroopInfo> emptyMap;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f297726a = new c();
        syncTroopCache = new LinkedHashMap();
        emptyMap = MapsKt__MapsKt.emptyMap();
        troopsInfo = emptyMap;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int roomId, TroopLiveSyncSvr$GetSyncGroupsRsp rspGroup, Map<Long, ? extends TroopInfo> troopMap) {
        syncTroopCache.put(Integer.valueOf(roomId), rspGroup);
        troopsInfo = troopMap;
    }

    private final void h(String method, byte[] data, com.tencent.mobileqq.troop.api.f callback) {
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.qvideo.live_sync_qun.LiveSyncQun", method, data, 1, null, new d(callback));
    }

    private final void i(int roomId, boolean syncSwitch, List<Long> troopIds) {
        TroopLiveSyncSvr$GetSyncGroupsRsp troopLiveSyncSvr$GetSyncGroupsRsp = syncTroopCache.get(Integer.valueOf(roomId));
        if (troopLiveSyncSvr$GetSyncGroupsRsp != null) {
            troopLiveSyncSvr$GetSyncGroupsRsp.sync_switch.set(syncSwitch);
            List<TroopLiveSyncSvr$GroupInfo> list = troopLiveSyncSvr$GetSyncGroupsRsp.able_sync_groups.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.able_sync_groups.get()");
            for (TroopLiveSyncSvr$GroupInfo troopLiveSyncSvr$GroupInfo : list) {
                if (syncSwitch) {
                    troopLiveSyncSvr$GroupInfo.be_choosed.set(troopIds.contains(Long.valueOf(troopLiveSyncSvr$GroupInfo.group_code.get())));
                } else {
                    troopLiveSyncSvr$GroupInfo.be_choosed.set(false);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.livesync.repository.ITroopLiveSyncRepository
    public void a(int roomId, @NotNull Function1<? super TroopLiveSyncSvr$GetSyncGroupsRsp, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(roomId), successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopLiveSyncSvr$GetSyncGroupsReq troopLiveSyncSvr$GetSyncGroupsReq = new TroopLiveSyncSvr$GetSyncGroupsReq();
        troopLiveSyncSvr$GetSyncGroupsReq.room_id.set(roomId);
        h("/trpc.qvideo.live_sync_qun.LiveSyncQun/GetSyncGroups", troopLiveSyncSvr$GetSyncGroupsReq.toByteArray(), new a(roomId, successBlock, errorBlock));
        QLog.i("TroopLiveSync", 1, "req GetSyncGroups, [roomId:" + roomId + "]");
    }

    @Nullable
    public TroopLiveSyncSvr$GetSyncGroupsRsp c(int roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopLiveSyncSvr$GetSyncGroupsRsp) iPatchRedirector.redirect((short) 5, (Object) this, roomId);
        }
        return syncTroopCache.get(Integer.valueOf(roomId));
    }

    @NotNull
    public final Map<Long, TroopInfo> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return troopsInfo;
    }

    public void e(long troopCode, @NotNull Function1<? super TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(troopCode), successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopLiveSyncSvr$GetSyncRoomIDReq troopLiveSyncSvr$GetSyncRoomIDReq = new TroopLiveSyncSvr$GetSyncRoomIDReq();
        troopLiveSyncSvr$GetSyncRoomIDReq.group_code.set(troopCode);
        h("/trpc.qvideo.live_sync_qun.LiveSyncQun/GetSyncRoomID", troopLiveSyncSvr$GetSyncRoomIDReq.toByteArray(), new b(troopCode, successBlock, errorBlock));
        QLog.i("TroopLiveSync", 1, "req GetSyncRoomID, [groupCode:" + troopCode + "]");
    }

    public void f(int roomId, boolean syncSwitch, @NotNull List<Long> troopIds, @NotNull Function1<? super TroopLiveSyncSvr$SetSyncGroupRsp, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(roomId), Boolean.valueOf(syncSwitch), troopIds, successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(troopIds, "troopIds");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopLiveSyncSvr$SetSyncGroupReq troopLiveSyncSvr$SetSyncGroupReq = new TroopLiveSyncSvr$SetSyncGroupReq();
        troopLiveSyncSvr$SetSyncGroupReq.room_id.set(roomId);
        troopLiveSyncSvr$SetSyncGroupReq.sync_switch.set(syncSwitch);
        Iterator<T> it = troopIds.iterator();
        while (it.hasNext()) {
            troopLiveSyncSvr$SetSyncGroupReq.groups_code.add(Long.valueOf(((Number) it.next()).longValue()));
        }
        h("/trpc.qvideo.live_sync_qun.LiveSyncQun/SetSyncGroup", troopLiveSyncSvr$SetSyncGroupReq.toByteArray(), new C8759c(roomId, syncSwitch, troopIds, successBlock, errorBlock));
        i(roomId, syncSwitch, troopIds);
        QLog.i("TroopLiveSync", 1, "req SetSyncGroups, [roomId:" + roomId + " switch:" + syncSwitch + " ids:" + troopIds.size() + "]");
    }
}
