package ne3;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.cloudmod.CloudWeakNetEvent;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.EnterModCheckRequest;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.NewIntent;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lne3/b;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "", "text", DomainData.DOMAIN_NAME, "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "k", "", "d", "I", "targetSpeed", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int targetSpeed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"ne3/b$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements SimpleEventReceiver<SimpleBaseEvent> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f420067d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f420068e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f420069f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f420070h;

        a(EnterModCheckResult enterModCheckResult, b bVar, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest) {
            this.f420067d = enterModCheckResult;
            this.f420068e = bVar;
            this.f420069f = aVar;
            this.f420070h = enterModCheckRequest;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(CloudWeakNetEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent event) {
            if ((event instanceof CloudWeakNetEvent ? (CloudWeakNetEvent) event : null) != null) {
                EnterModCheckResult enterModCheckResult = this.f420067d;
                b bVar = this.f420068e;
                com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar = this.f420069f;
                EnterModCheckRequest enterModCheckRequest = this.f420070h;
                if (((CloudWeakNetEvent) event).getIsWeak()) {
                    enterModCheckResult.setResultCode(27);
                    QLog.i(bVar.b(), 1, "check :: net type is not stable , type == " + m.f329564a.b());
                    enterModCheckResult.setProcessInner(false);
                    aVar.b(enterModCheckResult);
                    bVar.n("\u5f53\u524d\u4e3a\u5f31\u7f51\uff0c\u542f\u52a8\u4e91\u6e38\u5931\u8d25");
                } else {
                    bVar.d(enterModCheckRequest, enterModCheckResult, aVar);
                }
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            }
        }
    }

    public b() {
        this.targetSpeed = 100;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("101007", new byte[0]), Charsets.UTF_8);
        if (str.length() > 0) {
            this.targetSpeed = new JSONObject(str).optInt("targetSpeed", 100);
        }
    }

    private final boolean l() {
        m mVar = m.f329564a;
        return mVar.a() == 1 || mVar.a() == 5 || mVar.a() == 4 || mVar.a() == 6;
    }

    private final void m() {
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), d.class);
        newIntent.setAction("action_send_weak_network_pkg");
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "CloudNetChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        if (!l()) {
            lastCheckResult.setResultCode(26);
            String b16 = b();
            m mVar = m.f329564a;
            QLog.i(b16, 1, "check :: net type is not stable , type == " + mVar.b());
            lastCheckResult.setProcessInner(false);
            callback.b(lastCheckResult);
            n("\u975e\u7a33\u5b9a\u7f51\u7edc\u7c7b\u578b\uff0c\u5f53\u524d\u7f51\u7edc\u7c7b\u578b\u4e3a:" + mVar.b());
            return;
        }
        oe3.b bVar = oe3.b.f422582a;
        if (bVar.d() < this.targetSpeed && bVar.d() != 0) {
            lastCheckResult.setResultCode(28);
            QLog.i(b(), 1, "check :: low net speed , speed == " + bVar.d());
            lastCheckResult.setProcessInner(false);
            callback.b(lastCheckResult);
            n("\u5f53\u524d\u7f51\u901f\u592a\u6162\uff0c\u7f51\u901f\u4e3a:" + bVar.d());
            return;
        }
        QLog.i(b(), 1, "check :: net speed fast, speed == " + bVar.d());
        SimpleEventBus.getInstance().registerReceiver(new a(lastCheckResult, this, callback, request));
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String text) {
    }
}
