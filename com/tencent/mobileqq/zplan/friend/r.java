package com.tencent.mobileqq.zplan.friend;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\f0\u000bJ8\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/r;", "", "", "data", "", "Lcom/tencent/mobileqq/zplan/friend/r$a;", "b", "Lcom/tencent/common/app/AppInterface;", "app", "", "type", "Lkotlin/Function1;", "", "callback", "d", "appRuntime", "", "templateID", "idList", "", "c", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f333732a = new r();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/friend/r$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f333738a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f333738a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanFriendRequest", 1, "reportSetRole error code:" + errCode + " msg:" + errMsg);
            this.f333738a.invoke(Boolean.FALSE);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            QLog.i("ZPlanFriendRequest", 1, "reportSetRole success");
            this.f333738a.invoke(Boolean.TRUE);
        }
    }

    r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RoleInfo> b(byte[] data) {
        cw4.b bVar;
        ArrayList arrayList = new ArrayList();
        try {
            bVar = cw4.b.c(data);
        } catch (Exception e16) {
            QLog.e("ZPlanFriendRequest", 1, e16, new Object[0]);
            bVar = null;
        }
        if (bVar == null) {
            QLog.i("ZPlanFriendRequest", 1, "parse friend resp failed");
            return arrayList;
        }
        cw4.d[] dVarArr = bVar.f392175a;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            cw4.d[] dVarArr2 = bVar.f392175a;
            cw4.d dVar = dVarArr2 != null ? dVarArr2[i3] : null;
            if (dVar != null) {
                long j3 = dVar.f392179a;
                if (j3 != 0) {
                    arrayList.add(new RoleInfo(String.valueOf(j3), null, dVar.f392181c, dVar.f392180b, Integer.valueOf(dVar.f392182d)));
                }
            }
        }
        return arrayList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/friend/r$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<RoleInfo>, Unit> f333739a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super List<RoleInfo>, Unit> function1) {
            this.f333739a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            List<RoleInfo> emptyList;
            QLog.e("ZPlanFriendRequest", 1, "request role list fail, errCode = " + errCode + ", errMsg = " + errMsg);
            Function1<List<RoleInfo>, Unit> function1 = this.f333739a;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function1.invoke(emptyList);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            List<RoleInfo> b16 = data != null ? r.f333732a.b(data) : CollectionsKt__CollectionsKt.emptyList();
            QLog.i("ZPlanFriendRequest", 1, "onReceive called, result RoleInfo list size:" + b16.size());
            this.f333739a.invoke(b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/r$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "uin", "b", "head", "c", "image", "d", "name", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.friend.r$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class RoleInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String head;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String image;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String name;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final Integer gender;

        public RoleInfo(String uin, String str, String str2, String str3, Integer num) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uin = uin;
            this.head = str;
            this.image = str2;
            this.name = str3;
            this.gender = num;
        }

        /* renamed from: a, reason: from getter */
        public final Integer getGender() {
            return this.gender;
        }

        /* renamed from: b, reason: from getter */
        public final String getHead() {
            return this.head;
        }

        /* renamed from: c, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: d, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: e, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public int hashCode() {
            int hashCode = this.uin.hashCode() * 31;
            String str = this.head;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.image;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.name;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.gender;
            return hashCode4 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "RoleInfo(uin=" + this.uin + ", head=" + this.head + ", image=" + this.image + ", name=" + this.name + ", gender=" + this.gender + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleInfo)) {
                return false;
            }
            RoleInfo roleInfo = (RoleInfo) other;
            return Intrinsics.areEqual(this.uin, roleInfo.uin) && Intrinsics.areEqual(this.head, roleInfo.head) && Intrinsics.areEqual(this.image, roleInfo.image) && Intrinsics.areEqual(this.name, roleInfo.name) && Intrinsics.areEqual(this.gender, roleInfo.gender);
        }
    }

    public final void d(AppInterface app, int type, Function1<? super List<RoleInfo>, Unit> callback) {
        String str;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (type == 0) {
            str = "BOT";
        } else {
            str = "FRIEND";
        }
        QLog.i("ZPlanFriendRequest", 1, "start request role list with type = " + str);
        cw4.a aVar = new cw4.a();
        aVar.f392174a = type;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.user_info.UserInfoSvr", "GetRoles", byteArray, emptyMap, new c(callback), 0, 0, 192, null);
    }

    public final void c(AppInterface appRuntime, String templateID, List<String> idList, Function1<? super Boolean, Unit> callback) {
        int collectionSizeOrDefault;
        long[] longArray;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(templateID, "templateID");
        Intrinsics.checkNotNullParameter(idList, "idList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZPlanFriendRequest", 1, "reportSetRole idList:" + idList + ",templateID:" + templateID);
        if (!idList.isEmpty()) {
            if (!(templateID.length() == 0)) {
                cw4.c cVar = new cw4.c();
                cVar.f392177b = Integer.parseInt(templateID);
                List<String> list = idList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
                }
                longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
                cVar.f392176a = longArray;
                QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
                byte[] byteArray = MessageNano.toByteArray(cVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appRuntime, "trpc.metaverse.user_info.UserInfoSvr", "ReportSetRole", byteArray, emptyMap, new b(callback), 0, 0, 192, null);
                return;
            }
        }
        callback.invoke(Boolean.FALSE);
    }
}
