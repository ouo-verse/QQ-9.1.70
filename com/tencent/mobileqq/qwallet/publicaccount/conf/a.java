package com.tencent.mobileqq.qwallet.publicaccount.conf;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.pb.PublicOfficeConfig$GetMenuReq;
import com.tencent.mobileqq.qwallet.pb.PublicOfficeConfig$GetMenuRsp;
import com.tencent.mobileqq.qwallet.pb.PublicOfficeConfig$MenuItem;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\tJ@\u0010\u0014\u001a\u00020\u001228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fR\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/conf/a;", "", "", "Lcom/tencent/mobileqq/qwallet/pb/PublicOfficeConfig$MenuItem;", "menuList", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabLevel;", "tabLevel", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "e", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/QWalletPAConfBean;", "c", "d", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "confBean", "", "receiver", "f", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "b", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f279114a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Gson gson = new GsonBuilder().create();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.publicaccount.conf.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8483a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f279116d;

        public C8483a(o oVar) {
            this.f279116d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) PublicOfficeConfig$GetMenuRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f279116d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PublicOfficeConfig$GetMenuRsp.class + " failed.");
                    o oVar2 = this.f279116d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f279116d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/publicaccount/conf/a$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/PublicOfficeConfig$GetMenuRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements o<PublicOfficeConfig$GetMenuRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, QWalletPAConfBean, Unit> f279117a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super QWalletPAConfBean, Unit> function2) {
            this.f279117a = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PublicOfficeConfig$GetMenuRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            a aVar = a.f279114a;
            List<PublicOfficeConfig$MenuItem> list = rsp.menu.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.menu.get()");
            QWalletPAConfBean qWalletPAConfBean = new QWalletPAConfBean(aVar.e(list, TabLevel.TAB));
            String confBeanStr = a.gson.toJson(qWalletPAConfBean);
            this.f279117a.invoke(Boolean.TRUE, qWalletPAConfBean);
            Intrinsics.checkNotNullExpressionValue(confBeanStr, "confBeanStr");
            g.q("qwallet_pa_conf_bean_cache", confBeanStr);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f279117a.invoke(Boolean.FALSE, null);
            QLog.e("PAConfRepository", 1, "PublicOfficeConfig update PA conf error " + errMsg);
        }
    }

    a() {
    }

    private final QWalletPAConfBean c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new TabItem(1, "QQ\u94b1\u5305", "mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=0&channel=2", "", "4", new ArrayList(), TabLevel.TAB));
        return new QWalletPAConfBean(arrayListOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<TabItem> e(List<PublicOfficeConfig$MenuItem> menuList, TabLevel tabLevel) {
        List<TabItem> arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (PublicOfficeConfig$MenuItem publicOfficeConfig$MenuItem : menuList) {
            if (tabLevel == TabLevel.TAB) {
                List<PublicOfficeConfig$MenuItem> list = publicOfficeConfig$MenuItem.sub_menu.get();
                Intrinsics.checkNotNullExpressionValue(list, "menu.sub_menu.get()");
                arrayList = e(list, TabLevel.SHEET);
            } else {
                arrayList = new ArrayList<>();
            }
            int i3 = publicOfficeConfig$MenuItem.f278698id.get();
            String str = publicOfficeConfig$MenuItem.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "menu.name.get()");
            String str2 = publicOfficeConfig$MenuItem.url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "menu.url.get()");
            String str3 = publicOfficeConfig$MenuItem.icon.get();
            Intrinsics.checkNotNullExpressionValue(str3, "menu.icon.get()");
            String str4 = publicOfficeConfig$MenuItem.f278699pv.get();
            Intrinsics.checkNotNullExpressionValue(str4, "menu.pv.get()");
            arrayList2.add(new TabItem(i3, str, str2, str3, str4, arrayList, tabLevel));
        }
        return arrayList2;
    }

    @NotNull
    public final QWalletPAConfBean d() {
        boolean z16;
        try {
            String i3 = g.i("qwallet_pa_conf_bean_cache");
            if (i3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                c();
            }
            QWalletPAConfBean qWalletPAConfBean = (QWalletPAConfBean) gson.fromJson(i3, QWalletPAConfBean.class);
            if (qWalletPAConfBean == null) {
                return c();
            }
            return qWalletPAConfBean;
        } catch (Throwable th5) {
            QLog.e("PAConfRepository", 1, "getPAConfBeanForCache error", th5);
            return c();
        }
    }

    public final void f(@NotNull Function2<? super Boolean, ? super QWalletPAConfBean, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        b bVar = new b(receiver);
        PublicOfficeConfig$GetMenuReq publicOfficeConfig$GetMenuReq = new PublicOfficeConfig$GetMenuReq();
        publicOfficeConfig$GetMenuReq.qyy_switch.set(true);
        publicOfficeConfig$GetMenuReq.is_youth_mode.set(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.public_office_config.Config.SsoGetMenu callback: " + bVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.public_office_config.Config.SsoGetMenu");
        newIntent.putExtra("data", fh.b(publicOfficeConfig$GetMenuReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new C8483a(bVar));
        waitAppRuntime.startServlet(newIntent);
    }
}
