package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/br;", "", "Lcom/tencent/mobileqq/guild/util/br$a;", "param", "Lkotlin/Function0;", "", "onAllGranted", "onDenied", "", "a", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "b", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class br {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final br f235474a = new br();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\nB?\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\"\u001a\u0004\u0018\u00010 8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/util/br$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "c", "()Landroidx/fragment/app/Fragment;", "fragment", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "permissions", "Ljava/lang/String;", "getBusinessId", "()Ljava/lang/String;", "businessId", "e", "getSceneId", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "()Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "businessConfig", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "f", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.util.br$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class PermissionParam {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Activity activity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Fragment fragment;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> permissions;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String businessId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sceneId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/br$a$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "businessId", WadlProxyConsts.SCENE_ID, "", "permissions", "Lcom/tencent/mobileqq/guild/util/br$a;", "a", "NOT_SET", "Ljava/lang/String;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.util.br$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final PermissionParam a(@NotNull Activity activity, @NotNull String businessId, @NotNull String sceneId, @NotNull List<String> permissions) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(businessId, "businessId");
                Intrinsics.checkNotNullParameter(sceneId, "sceneId");
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                return new PermissionParam(activity, null, permissions, businessId, sceneId);
            }

            Companion() {
            }
        }

        public PermissionParam(@Nullable Activity activity, @Nullable Fragment fragment, @NotNull List<String> permissions, @NotNull String businessId, @NotNull String sceneId) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            Intrinsics.checkNotNullParameter(sceneId, "sceneId");
            this.activity = activity;
            this.fragment = fragment;
            this.permissions = permissions;
            this.businessId = businessId;
            this.sceneId = sceneId;
        }

        @JvmStatic
        @NotNull
        public static final PermissionParam e(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull List<String> list) {
            return INSTANCE.a(activity, str, str2, list);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        @Nullable
        public final BusinessConfig b() {
            boolean z16;
            boolean z17 = true;
            if (this.businessId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (this.sceneId.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    return new BusinessConfig(this.businessId, this.sceneId);
                }
                return null;
            }
            return null;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Fragment getFragment() {
            return this.fragment;
        }

        @NotNull
        public final List<String> d() {
            return this.permissions;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionParam)) {
                return false;
            }
            PermissionParam permissionParam = (PermissionParam) other;
            if (Intrinsics.areEqual(this.activity, permissionParam.activity) && Intrinsics.areEqual(this.fragment, permissionParam.fragment) && Intrinsics.areEqual(this.permissions, permissionParam.permissions) && Intrinsics.areEqual(this.businessId, permissionParam.businessId) && Intrinsics.areEqual(this.sceneId, permissionParam.sceneId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Activity activity = this.activity;
            int i3 = 0;
            if (activity == null) {
                hashCode = 0;
            } else {
                hashCode = activity.hashCode();
            }
            int i16 = hashCode * 31;
            Fragment fragment = this.fragment;
            if (fragment != null) {
                i3 = fragment.hashCode();
            }
            return ((((((i16 + i3) * 31) + this.permissions.hashCode()) * 31) + this.businessId.hashCode()) * 31) + this.sceneId.hashCode();
        }

        @NotNull
        public String toString() {
            return "PermissionParam(activity=" + this.activity + ", fragment=" + this.fragment + ", permissions=" + this.permissions + ", businessId=" + this.businessId + ", sceneId=" + this.sceneId + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/util/br$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f235481a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f235482b;

        b(Function0<Unit> function0, Function0<Unit> function02) {
            this.f235481a = function0;
            this.f235482b = function02;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f235481a.invoke();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            Function0<Unit> function0 = this.f235482b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    br() {
    }

    @JvmStatic
    public static final boolean a(@NotNull PermissionParam param, @NotNull Function0<Unit> onAllGranted, @Nullable Function0<Unit> onDenied) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(onAllGranted, "onAllGranted");
        QQPermission b16 = f235474a.b(param);
        List<String> d16 = param.d();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = d16.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (b16.hasPermission((String) next) == 0) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            onAllGranted.invoke();
            return true;
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        b16.requestPermissions((String[]) array, 2, new b(onAllGranted, onDenied));
        return false;
    }

    private final QQPermission b(PermissionParam param) {
        BusinessConfig b16 = param.b();
        if (param.getActivity() != null) {
            if (b16 == null) {
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(param.getActivity());
                Intrinsics.checkNotNullExpressionValue(qQPermission, "{\n                QQPerm\u2026m.activity)\n            }");
                return qQPermission;
            }
            QQPermission qQPermission2 = QQPermissionFactory.getQQPermission(param.getActivity(), b16);
            Intrinsics.checkNotNullExpressionValue(qQPermission2, "{\n                QQPerm\u2026nessConfig)\n            }");
            return qQPermission2;
        }
        if (b16 == null) {
            QQPermission qQPermission3 = QQPermissionFactory.getQQPermission(param.getFragment());
            Intrinsics.checkNotNullExpressionValue(qQPermission3, "{\n            QQPermissi\u2026param.fragment)\n        }");
            return qQPermission3;
        }
        QQPermission qQPermission4 = QQPermissionFactory.getQQPermission(param.getFragment(), b16);
        Intrinsics.checkNotNullExpressionValue(qQPermission4, "{\n            QQPermissi\u2026businessConfig)\n        }");
        return qQPermission4;
    }
}
