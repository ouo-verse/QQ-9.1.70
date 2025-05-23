package com.tencent.mobileqq.zplan.aio;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.setting.e;
import com.tencent.mobileqq.zplan.utils.ZDispatchers;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\u0003\u0007\fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/a;", "", "Lcom/tencent/mobileqq/zplan/aio/a$b;", "a", "Lcom/tencent/mobileqq/zplan/aio/a$b;", "param", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/zplan/aio/a$b;)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Param param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/a$a;", "", "", "uin", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(long uin) {
            QRouteApi api = QRoute.api(IZPlanAccessibleHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAccessibleHelper::class.java)");
            if (!((IZPlanAccessibleHelper) api).isZplanAccessibleWithoutSetting(1009L, uin)) {
                QLog.i("ZPlanAioAvatarJudge", 1, "\u573a\u666f\u672a\u542f\u7528");
                return false;
            }
            if (ZPlanFeatureSwitch.f369852a.l3()) {
                return true;
            }
            QLog.i("ZPlanAioAvatarJudge", 2, "\u7279\u6027\u5f00\u5173\u672a\u542f\u7528");
            return false;
        }

        Companion() {
        }
    }

    public a(Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.scope = CoroutineScopeKt.CoroutineScope(ZDispatchers.f335734a.a());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/a$c;", "", "", "uin", "", "c", "d", "isTurnOn", "Lnk3/a;", "callback", "", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f330912a = new c();

        c() {
        }

        @JvmStatic
        public static final boolean c(long uin) {
            return a.INSTANCE.a(uin);
        }

        @JvmStatic
        public static final boolean d() {
            return com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.AIO_AVATAR_SETTING);
        }

        @JvmStatic
        public static final void e(final boolean isTurnOn, final nk3.a callback) {
            List<? extends Pair<? extends SwitchSetting, Boolean>> listOf;
            QLog.d("ZPlanAioAvatarJudge", 1, "\u8bbe\u7f6e\u9875\u5f00\u5173 isTurnOn=" + isTurnOn);
            if (!com.tencent.mobileqq.zplan.setting.c.e() && isTurnOn) {
                e eVar = e.f335451a;
                SwitchSetting switchSetting = SwitchSetting.AIO_AVATAR_SETTING;
                Boolean bool = Boolean.TRUE;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(switchSetting, bool), TuplesKt.to(SwitchSetting.MASTER_SETTING, bool)});
                eVar.g(listOf, new nk3.a() { // from class: com.tencent.mobileqq.zplan.aio.b
                    @Override // nk3.a
                    public final void onResult(boolean z16) {
                        a.c.f(nk3.a.this, z16);
                    }
                });
                return;
            }
            e.f335451a.f(SwitchSetting.AIO_AVATAR_SETTING, isTurnOn, new nk3.a() { // from class: com.tencent.mobileqq.zplan.aio.c
                @Override // nk3.a
                public final void onResult(boolean z16) {
                    a.c.g(nk3.a.this, isTurnOn, z16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(nk3.a aVar, boolean z16) {
            if (aVar != null) {
                aVar.onResult(z16);
            }
            if (z16) {
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.AIO_AVATAR_SETTING, true);
                com.tencent.mobileqq.zplan.setting.c.n(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(nk3.a aVar, boolean z16, boolean z17) {
            if (aVar != null) {
                aVar.onResult(z17);
            }
            if (z17) {
                com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.AIO_AVATAR_SETTING, z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "La61/c;", "a", "La61/c;", "getChatPie", "()La61/c;", "chatPie", "<init>", "(La61/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.a$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class Param {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final a61.c chatPie;

        public Param(a61.c chatPie) {
            Intrinsics.checkNotNullParameter(chatPie, "chatPie");
            this.chatPie = chatPie;
        }

        public int hashCode() {
            return this.chatPie.hashCode();
        }

        public String toString() {
            return "Param(chatPie=" + this.chatPie + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.chatPie, ((Param) other).chatPie);
        }
    }
}
