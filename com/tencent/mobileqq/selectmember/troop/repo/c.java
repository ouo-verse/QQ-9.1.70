package com.tencent.mobileqq.selectmember.troop.repo;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.troop.repo.c;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$BindedSubGroup;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$CheckGroupsReq;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$CheckGroupsRsp;
import tencent.trpcprotocol.TroopSourceSvr$DeleteAllReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0096\u0001\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f2O\u0010\u0013\u001aK\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u000ej\u0002`\u0012H\u0007J{\u0010\u001c\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u00192:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u001aj\u0002`\u001bH\u0007J\u008d\u0001\u0010 \u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u00192:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u001aj\u0002`\u001bH\u0007J\u008f\u0001\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u00172'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u00192:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u001aj\u0002`\u001bH\u0002\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/selectmember/troop/repo/c;", "", "", "masterGroupUin", "", "subGroupList", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/selectmember/troop/repo/f;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/selectmember/troop/repo/TroopListCheckSuccessBlock;", "successBlock", "Lkotlin/Function3;", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/selectmember/troop/repo/TroopListCheckErrorBlock;", "errorBlock", "b", "", "sourceGroups", "", "rspData", "Lcom/tencent/mobileqq/selectmember/troop/repo/TroopListSuccessBlock;", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/selectmember/troop/repo/TroopListErrorBlock;", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "a", "service", "method", "serializationType", "data", "d", "<init>", "()V", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f286051a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/selectmember/troop/repo/c$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<f, Unit> f286052a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<f, Integer, String, Unit> f286053b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super f, Unit> function1, Function3<? super f, ? super Integer, ? super String, Unit> function3) {
            this.f286052a = function1;
            this.f286053b = function3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1, (Object) function3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function3 errorBlock, TroopTrpcRemoteResponse error) {
            Intrinsics.checkNotNullParameter(errorBlock, "$errorBlock");
            Intrinsics.checkNotNullParameter(error, "$error");
            f fVar = new f(null, null, null, null, null, null, null, 127, null);
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            errorBlock.invoke(fVar, valueOf, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(TroopTrpcRemoteResponse rsp, Function1 successBlock) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
            if (rsp.data != null) {
                TroopJoinQunAutoSwitch$CheckGroupsRsp mergeFrom = new TroopJoinQunAutoSwitch$CheckGroupsRsp().mergeFrom(rsp.data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "CheckGroupsRsp().mergeFrom(rsp.data)");
                TroopJoinQunAutoSwitch$CheckGroupsRsp troopJoinQunAutoSwitch$CheckGroupsRsp = mergeFrom;
                ArrayList arrayList = new ArrayList();
                List<String> nameWrongGroups = troopJoinQunAutoSwitch$CheckGroupsRsp.name_wrong_group.get();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(nameWrongGroups, "nameWrongGroups");
                for (String groupId : nameWrongGroups) {
                    Intrinsics.checkNotNullExpressionValue(groupId, "groupId");
                    linkedHashMap.put(groupId, Boolean.TRUE);
                    arrayList.add(groupId);
                }
                List<String> sourceGroups = troopJoinQunAutoSwitch$CheckGroupsRsp.source_groups.get();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(sourceGroups, "sourceGroups");
                for (String groupId2 : sourceGroups) {
                    Intrinsics.checkNotNullExpressionValue(groupId2, "groupId");
                    linkedHashMap2.put(groupId2, Boolean.TRUE);
                }
                List<String> bindMasterGroups = troopJoinQunAutoSwitch$CheckGroupsRsp.binded_master_groups.get();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(bindMasterGroups, "bindMasterGroups");
                for (String masterGroupUin : bindMasterGroups) {
                    Intrinsics.checkNotNullExpressionValue(masterGroupUin, "masterGroupUin");
                    linkedHashMap3.put(masterGroupUin, Boolean.TRUE);
                }
                List<TroopJoinQunAutoSwitch$BindedSubGroup> bindSubGroupsPB = troopJoinQunAutoSwitch$CheckGroupsRsp.binded_sub_groups.get();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(bindSubGroupsPB, "bindSubGroupsPB");
                for (TroopJoinQunAutoSwitch$BindedSubGroup troopJoinQunAutoSwitch$BindedSubGroup : bindSubGroupsPB) {
                    String groupId3 = troopJoinQunAutoSwitch$BindedSubGroup.group_id.get();
                    String masterGroupId = troopJoinQunAutoSwitch$BindedSubGroup.master_group_id.get();
                    Intrinsics.checkNotNullExpressionValue(groupId3, "groupId");
                    Intrinsics.checkNotNullExpressionValue(masterGroupId, "masterGroupId");
                    linkedHashMap4.put(groupId3, masterGroupId);
                    arrayList.add(groupId3);
                }
                List<String> unsafeGroups = troopJoinQunAutoSwitch$CheckGroupsRsp.unsafe_groups.get();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(unsafeGroups, "unsafeGroups");
                for (String groupId4 : unsafeGroups) {
                    Intrinsics.checkNotNullExpressionValue(groupId4, "groupId");
                    linkedHashMap5.put(groupId4, Boolean.TRUE);
                    arrayList.add(groupId4);
                }
                successBlock.invoke(new f(troopJoinQunAutoSwitch$CheckGroupsRsp, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, arrayList, linkedHashMap5));
                return;
            }
            QLog.i("SelectTroopListRepository", 1, "sendRequest success, but data is empty!");
            successBlock.invoke(new f(null, null, null, null, null, null, null, 127, null));
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull final TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("SelectTroopListRepository", 1, "sendRequest error, code:" + error.code + " msg:" + error.f293941msg + "]");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function3<f, Integer, String, Unit> function3 = this.f286053b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.repo.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.e(Function3.this, error);
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
            QLog.i("SelectTroopListRepository", 1, "sendRequest success");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<f, Unit> function1 = this.f286052a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.repo.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.f(TroopTrpcRemoteResponse.this, function1);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/selectmember/troop/repo/c$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<byte[], Unit> f286054a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f286055b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super byte[], Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f286054a = function1;
            this.f286055b = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1, (Object) function2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function2 errorBlock, TroopTrpcRemoteResponse error) {
            Intrinsics.checkNotNullParameter(errorBlock, "$errorBlock");
            Intrinsics.checkNotNullParameter(error, "$error");
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            errorBlock.invoke(valueOf, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(Function1 successBlock, TroopTrpcRemoteResponse rsp) {
            Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            successBlock.invoke(rsp.data);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull final TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("SelectTroopListRepository", 1, "sendRequest error, code:" + error.code + " msg:" + error.f293941msg + "]");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function2<Integer, String, Unit> function2 = this.f286055b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.repo.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.e(Function2.this, error);
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
            QLog.i("SelectTroopListRepository", 1, "sendRequest success");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<byte[], Unit> function1 = this.f286054a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.repo.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.f(Function1.this, rsp);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286051a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String masterGroupUin, @NotNull ArrayList<ResultRecord> subGroupList, @NotNull Function1<? super byte[], Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        Intrinsics.checkNotNullParameter(masterGroupUin, "masterGroupUin");
        Intrinsics.checkNotNullParameter(subGroupList, "subGroupList");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("master_group", masterGroupUin);
        JSONArray jSONArray = new JSONArray();
        Iterator<ResultRecord> it = subGroupList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().uin);
        }
        jSONObject.put("sub_groups", jSONArray);
        c cVar = f286051a;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "addSubGroupsReq.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        cVar.d("trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch", "/trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch/AddSubGroups", 0, bytes, successBlock, errorBlock);
    }

    @JvmStatic
    public static final void b(@NotNull String masterGroupUin, @NotNull List<String> subGroupList, @NotNull Function1<? super f, Unit> successBlock, @NotNull Function3<? super f, ? super Integer, ? super String, Unit> errorBlock) {
        Intrinsics.checkNotNullParameter(masterGroupUin, "masterGroupUin");
        Intrinsics.checkNotNullParameter(subGroupList, "subGroupList");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopJoinQunAutoSwitch$CheckGroupsReq troopJoinQunAutoSwitch$CheckGroupsReq = new TroopJoinQunAutoSwitch$CheckGroupsReq();
        troopJoinQunAutoSwitch$CheckGroupsReq.master_group.set(masterGroupUin);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = subGroupList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        troopJoinQunAutoSwitch$CheckGroupsReq.sub_groups.set(arrayList);
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch", "/trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch/CheckGroups", troopJoinQunAutoSwitch$CheckGroupsReq.toByteArray(), 1, null, new a(successBlock, errorBlock));
    }

    @JvmStatic
    public static final void c(@NotNull List<Long> sourceGroups, @NotNull Function1<? super byte[], Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        Intrinsics.checkNotNullParameter(sourceGroups, "sourceGroups");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopSourceSvr$DeleteAllReq troopSourceSvr$DeleteAllReq = new TroopSourceSvr$DeleteAllReq();
        troopSourceSvr$DeleteAllReq.group_ids.set(sourceGroups);
        f286051a.d("trpc.ecom.qun_source_svr.QunSourceSvr", "/trpc.ecom.qun_source_svr.QunSourceSvr/DeleteAll", 1, troopSourceSvr$DeleteAllReq.toByteArray(), successBlock, errorBlock);
    }

    private final void d(String service, String method, int serializationType, byte[] data, Function1<? super byte[], Unit> successBlock, Function2<? super Integer, ? super String, Unit> errorBlock) {
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest(service, method, data, serializationType, null, new b(successBlock, errorBlock));
    }
}
