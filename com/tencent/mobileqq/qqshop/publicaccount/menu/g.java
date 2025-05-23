package com.tencent.mobileqq.qqshop.publicaccount.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.proto.QQShopPAMenuPB$GetBottomMenuReq;
import com.tencent.mobileqq.qqshop.proto.QQShopPAMenuPB$GetBottomMenuRsp;
import com.tencent.mobileqq.qqshop.proto.QQShopPAMenuPB$MenuItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\tJ@\u0010\u0014\u001a\u00020\u001228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fR\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/g;", "", "", "Lcom/tencent/mobileqq/qqshop/proto/QQShopPAMenuPB$MenuItem;", "menuList", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/TabLevel;", "tabLevel", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "e", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuConfBean;", "c", "d", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "confBean", "", "receiver", "f", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "b", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f274629a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/menu/g$a", "Lpl2/o;", "Lcom/tencent/mobileqq/qqshop/proto/QQShopPAMenuPB$GetBottomMenuRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements o<QQShopPAMenuPB$GetBottomMenuRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, QQShopMenuConfBean, Unit> f274631a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super QQShopMenuConfBean, Unit> function2) {
            this.f274631a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QQShopPAMenuPB$GetBottomMenuRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            g gVar = g.f274629a;
            List<QQShopPAMenuPB$MenuItem> list = rsp.menu.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.menu.get()");
            QQShopMenuConfBean qQShopMenuConfBean = new QQShopMenuConfBean(gVar.e(list, TabLevel.TAB));
            String confBeanStr = g.gson.toJson(qQShopMenuConfBean);
            this.f274631a.invoke(Boolean.TRUE, qQShopMenuConfBean);
            Intrinsics.checkNotNullExpressionValue(confBeanStr, "confBeanStr");
            com.tencent.mobileqq.qwallet.utils.g.q("qq_shop_pa_menu_cache", confBeanStr);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f274631a.invoke(Boolean.FALSE, null);
            QLog.e("QQShopPAMenuRepository", 1, "PublicOfficeConfig update PA conf error " + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f274629a = new g();
            gson = new GsonBuilder().create();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final QQShopMenuConfBean c() {
        return new QQShopMenuConfBean(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MenuItem> e(List<QQShopPAMenuPB$MenuItem> menuList, TabLevel tabLevel) {
        List<MenuItem> arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (QQShopPAMenuPB$MenuItem qQShopPAMenuPB$MenuItem : menuList) {
            if (tabLevel == TabLevel.TAB) {
                List<QQShopPAMenuPB$MenuItem> list = qQShopPAMenuPB$MenuItem.sub_menu.get();
                Intrinsics.checkNotNullExpressionValue(list, "menu.sub_menu.get()");
                arrayList = e(list, TabLevel.SHEET);
            } else {
                arrayList = new ArrayList<>();
            }
            int i3 = qQShopPAMenuPB$MenuItem.f274501id.get();
            String str = qQShopPAMenuPB$MenuItem.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "menu.name.get()");
            String str2 = qQShopPAMenuPB$MenuItem.url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "menu.url.get()");
            String str3 = qQShopPAMenuPB$MenuItem.icon.get();
            Intrinsics.checkNotNullExpressionValue(str3, "menu.icon.get()");
            String str4 = qQShopPAMenuPB$MenuItem.f274502pv.get();
            Intrinsics.checkNotNullExpressionValue(str4, "menu.pv.get()");
            arrayList2.add(new MenuItem(i3, str, str2, str3, str4, arrayList, tabLevel));
        }
        return arrayList2;
    }

    @NotNull
    public final QQShopMenuConfBean d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQShopMenuConfBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            String i3 = com.tencent.mobileqq.qwallet.utils.g.i("qq_shop_pa_menu_cache");
            if (i3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                c();
            }
            QQShopMenuConfBean qQShopMenuConfBean = (QQShopMenuConfBean) gson.fromJson(i3, QQShopMenuConfBean.class);
            if (qQShopMenuConfBean == null) {
                return c();
            }
            return qQShopMenuConfBean;
        } catch (Throwable th5) {
            QLog.e("QQShopPAMenuRepository", 1, "getPAConfBeanForCache error", th5);
            return c();
        }
    }

    public final void f(@NotNull Function2<? super Boolean, ? super QQShopMenuConfBean, Unit> receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) receiver);
            return;
        }
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        a aVar = new a(receiver);
        QQShopPAMenuPB$GetBottomMenuReq qQShopPAMenuPB$GetBottomMenuReq = new QQShopPAMenuPB$GetBottomMenuReq();
        qQShopPAMenuPB$GetBottomMenuReq.qyy_switch.set(true);
        qQShopPAMenuPB$GetBottomMenuReq.is_youth_mode.set(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi.a.a((IQWalletServletApi) api, "trpc.qqshop.officalplatform.Menu", "GetBottomMenu", qQShopPAMenuPB$GetBottomMenuReq, (MessageMicro) QQShopPAMenuPB$GetBottomMenuRsp.class.newInstance(), false, false, false, aVar, 112, null);
    }
}
