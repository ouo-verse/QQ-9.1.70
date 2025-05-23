package com.tencent.biz.pubaccount.aio;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.biz.pubaccount.aio.c;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.common.app.AppInterface;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001I\b\u0016\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001WB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J \u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\u0018\u0010)\u001a\u00020\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014H\u0002J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014H\u0002J\u0018\u0010+\u001a\u00020\f2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014H\u0002J\u0006\u0010-\u001a\u00020,J\b\u0010/\u001a\u0004\u0018\u00010.J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u00020\u0006H\u0007J\b\u00104\u001a\u00020\u0006H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0016\u00106\u001a\u00020\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014J\u0010\u00109\u001a\u00020\f2\u0006\u00108\u001a\u000207H\u0016R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR(\u0010T\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020I0Q0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006X"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "isSelected", "u", "isShotMode", "t", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "", "Lcom/tencent/biz/ui/c;", "customViewDatas", UserInfo.SEX_FEMALE, "", "type", "isNeedAnimate", "G", "visibility", "D", "", "menuCommand", "menuId", "menuLevel", "y", DomainData.DOMAIN_NAME, "v", "o", "L", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "menuButtonList", "w", "K", "M", "", "r", "Lmqq/app/AppRuntime;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "J", "Landroid/os/Message;", "msg", "handleMessage", "d", "Z", "mIsInit", "Lcom/tencent/biz/pubaccount/api/IPublicAccountManager;", "e", "Lcom/tencent/biz/pubaccount/api/IPublicAccountManager;", "getMPublicAccountManager", "()Lcom/tencent/biz/pubaccount/api/IPublicAccountManager;", "setMPublicAccountManager", "(Lcom/tencent/biz/pubaccount/api/IPublicAccountManager;)V", "mPublicAccountManager", "Lmqq/os/MqqHandler;", "f", "Lmqq/os/MqqHandler;", "uiHandler", "com/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM$b", tl.h.F, "Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM$b;", "mAction", "Lmqq/observer/BusinessObserver;", "i", "Lmqq/observer/BusinessObserver;", "mPublicAccountObserver", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "messageList", "<init>", "()V", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class PublicAccountInputContainerVM extends com.tencent.aio.base.mvvm.b<PAInputIntent, PAInputUIState> implements LifecycleObserver, Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IPublicAccountManager mPublicAccountManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final MqqHandler uiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final BusinessObserver mPublicAccountObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<Pair<String, b>> messageList;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            PublicAccountInputContainerVM.this.E(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public PublicAccountInputContainerVM() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        this.mPublicAccountObserver = new BusinessObserver() { // from class: com.tencent.biz.pubaccount.aio.g
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                PublicAccountInputContainerVM.x(PublicAccountInputContainerVM.this, i3, z16, bundle);
            }
        };
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(PAInputIntent.SwitchMenuIntent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(PAInputIntent.InputContainerVisibleIntent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(ThemeEvent.PostThemeChanged.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class).getQualifiedName(), bVar)});
        this.messageList = listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void B() {
        updateUI(new PAInputUIState.CustomMenuDismissPopupMenuState());
    }

    private final void C() {
        long r16 = r();
        IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
        updateUI(new PAInputUIState.InitState(new PAInputSessionInfo(r16, iPublicAccountManager != null ? Integer.valueOf(iPublicAccountManager.getPublicAccountMenuType(String.valueOf(r()))) : null)));
    }

    private final void D(int visibility) {
        updateUI(new PAInputUIState.InputContainerVisibleState(visibility));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof PAInputIntent.SwitchMenuIntent) {
            PAInputIntent.SwitchMenuIntent switchMenuIntent = (PAInputIntent.SwitchMenuIntent) intent;
            G(switchMenuIntent.getType(), switchMenuIntent.getIsNeedAnimate());
            return;
        }
        if (intent instanceof PAInputIntent.InputContainerVisibleIntent) {
            D(((PAInputIntent.InputContainerVisibleIntent) intent).getVisibility());
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            z();
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            u(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        } else if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            t(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
        }
    }

    private final void F(List<? extends com.tencent.biz.ui.c> customViewDatas) {
        updateUI(new PAInputUIState.SetCustomMenuDataState(customViewDatas));
    }

    private final void G(int type, boolean isNeedAnimate) {
        updateUI(new PAInputUIState.SwitchMenuDataState(type, isNeedAnimate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final List<com.tencent.biz.ui.c> K(List<mobileqq_mp$ButtonInfo> menuButtonList) {
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(menuButtonList);
        int size = menuButtonList.size();
        for (int i3 = 0; i3 < size && i3 <= 2; i3++) {
            mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo = menuButtonList.get(i3);
            if (!mobileqq_mp_buttoninfo.key.has()) {
                str = "";
            } else {
                str = mobileqq_mp_buttoninfo.key.get();
            }
            if (!mobileqq_mp_buttoninfo.name.has()) {
                str2 = "";
            } else {
                str2 = mobileqq_mp_buttoninfo.name.get();
            }
            com.tencent.biz.ui.c cVar = new com.tencent.biz.ui.c(str, str2, null, mobileqq_mp_buttoninfo.f247282id.has() ? mobileqq_mp_buttoninfo.f247282id.get() : 0);
            cVar.k(mobileqq_mp_buttoninfo);
            List<mobileqq_mp$ButtonInfo> list = mobileqq_mp_buttoninfo.sub_button.has() ? mobileqq_mp_buttoninfo.sub_button.get() : null;
            if (list != null && list.size() > 0) {
                for (mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo2 : list) {
                    if (!mobileqq_mp_buttoninfo2.key.has()) {
                        str3 = "";
                    } else {
                        str3 = mobileqq_mp_buttoninfo2.key.get();
                    }
                    if (!mobileqq_mp_buttoninfo2.name.has()) {
                        str4 = "";
                    } else {
                        str4 = mobileqq_mp_buttoninfo2.name.get();
                    }
                    com.tencent.biz.ui.c cVar2 = new com.tencent.biz.ui.c(str3, str4, null, mobileqq_mp_buttoninfo2.f247282id.has() ? mobileqq_mp_buttoninfo2.f247282id.get() : 0);
                    cVar2.k(mobileqq_mp_buttoninfo2);
                    cVar.a(cVar2);
                }
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private final void L() {
        AppRuntime q16 = q();
        if (q16 == null) {
            return;
        }
        IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
        List<mobileqq_mp$ButtonInfo> publicAccountMenuButtonList = iPublicAccountManager != null ? iPublicAccountManager.getPublicAccountMenuButtonList((AppInterface) q16, String.valueOf(r())) : null;
        J(publicAccountMenuButtonList);
        if (publicAccountMenuButtonList == null || !(!publicAccountMenuButtonList.isEmpty())) {
            return;
        }
        G(2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean M(List<mobileqq_mp$ButtonInfo> menuButtonList) {
        C();
        if (menuButtonList != null && !menuButtonList.isEmpty()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.CustomMenuSwitchBtnVisibleIntent(0));
            return false;
        }
        G(1, false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.CustomMenuSwitchBtnVisibleIntent(8));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        AppRuntime q16 = q();
        if (q16 == null) {
            return;
        }
        l.f179531g = true;
        G(1, true);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PublicAccountInputContainerVM", true));
        IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
        Intrinsics.checkNotNull(iPublicAccountManager);
        if (iPublicAccountManager.getPublicAccountMenuType(String.valueOf(r())) != 0) {
            ReportController.o(q16, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005EC5", "0X8005EC5", 0, 0, String.valueOf(r()), "", "", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        final AppRuntime q16 = q();
        if (q16 == null) {
            return;
        }
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        final String str = "PA_firstOpen_" + r();
        if (from.decodeBool(str, false)) {
            return;
        }
        IRuntimeService runtimeService = q16.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IP\u2026essConstant.ALL\n        )");
        Object findPublicAccountInfo = ((IPublicAccountDataManager) runtimeService).findPublicAccountInfo(String.valueOf(r()));
        if (findPublicAccountInfo != null && (((PublicAccountInfo) findPublicAccountInfo).accountFlag & 65536) != 0) {
            IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
            Intrinsics.checkNotNull(iPublicAccountManager);
            iPublicAccountManager.sendMenuEventequest(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), (AppInterface) q16, String.valueOf(r()), "0x9e370001hd", false, 0.0d, 0.0d, null);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.aio.f
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountInputContainerVM.p(AppRuntime.this, this, from, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AppRuntime app, PublicAccountInputContainerVM this$0, MMKVOptionEntity entity, String key) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(key, "$key");
        try {
            EntityManager createEntityManager = app.getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "app.entityManagerFactory.createEntityManager()");
            PublicAccountMenuEntity publicAccountMenuEntity = (PublicAccountMenuEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountMenuEntity.class, this$0.r());
            if (publicAccountMenuEntity != null) {
                createEntityManager.remove(publicAccountMenuEntity);
            }
            createEntityManager.close();
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("PublicAccountInputContainerVM", 4, e16.getMessage());
            }
        }
        entity.encodeBool(key, true).commitSync();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        AppRuntime q16;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity == null || (q16 = q()) == null || activity.isFinishing()) {
            return;
        }
        o();
        C();
        IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
        List<mobileqq_mp$ButtonInfo> publicAccountMenuButtonList = iPublicAccountManager != null ? iPublicAccountManager.getPublicAccountMenuButtonList((AppInterface) q16, String.valueOf(r())) : null;
        J(publicAccountMenuButtonList);
        w(publicAccountMenuButtonList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(List<mobileqq_mp$ButtonInfo> menuButtonList) {
        AppRuntime q16 = q();
        if (q16 == null) {
            return;
        }
        IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
        if (iPublicAccountManager != null) {
            iPublicAccountManager.getMenuSetting(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), (AppInterface) q16, String.valueOf(r()), this.mPublicAccountObserver, false);
        }
        if (menuButtonList == null || !(!menuButtonList.isEmpty())) {
            return;
        }
        G(2, false);
        for (mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo : menuButtonList) {
            if (mobileqq_mp_buttoninfo != null) {
                xx.b.INSTANCE.l(String.valueOf(r()), mobileqq_mp_buttoninfo.f247282id.get(), mobileqq_mp_buttoninfo.name.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(PublicAccountInputContainerVM this$0, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bundle == null || bundle.getInt("update_type") == 2) {
            return;
        }
        this$0.uiHandler.sendEmptyMessage(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(String menuCommand, int menuId, int menuLevel) {
        AppRuntime q16 = q();
        if (q16 != null && (q16 instanceof QQAppInterface)) {
            l.f179531g = true;
            IPublicAccountManager iPublicAccountManager = this.mPublicAccountManager;
            if (iPublicAccountManager != null) {
                String valueOf = String.valueOf(r());
                BusinessObserver businessObserver = this.mPublicAccountObserver;
                MqqHandler mqqHandler = this.uiHandler;
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
                sessionInfo.T = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g();
                Unit unit = Unit.INSTANCE;
                iPublicAccountManager.handleButtonEvent(menuCommand, ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), (AppInterface) q16, valueOf, menuId, businessObserver, mqqHandler, menuLevel, sessionInfo);
            }
            ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportMenuClickOnPublicAccountAIO(String.valueOf(r()), ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getInt(IPublicAccountReport.INTENT_KEY_FROM, 1), menuId);
            IPublicAccountManager iPublicAccountManager2 = this.mPublicAccountManager;
            mobileqq_mp$ButtonInfo buttonInfoByMenuId = iPublicAccountManager2 != null ? iPublicAccountManager2.getButtonInfoByMenuId((AppInterface) q16, String.valueOf(r()), menuId) : null;
            if (buttonInfoByMenuId == null) {
                return;
            }
            xx.b.INSTANCE.k(String.valueOf(r()), buttonInfoByMenuId.f247282id.get(), buttonInfoByMenuId.name.get());
        }
    }

    public final void J(List<mobileqq_mp$ButtonInfo> menuButtonList) {
        if (M(menuButtonList)) {
            return;
        }
        F(K(menuButtonList));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            v();
        } else if (i3 == 2) {
            L();
        } else if (i3 == 1001) {
            B();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        H();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        super.onDestroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (!this.mIsInit) {
            this.uiHandler.sendEmptyMessage(1);
            this.mIsInit = true;
        }
        updateUI(new PAInputUIState.OnResumeState());
    }

    public final AppRuntime q() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long r() {
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getLong("key_peerUin", 0L);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(PAInputIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof PAInputIntent.CustomMenuItemClickIntent) {
            PAInputIntent.CustomMenuItemClickIntent customMenuItemClickIntent = (PAInputIntent.CustomMenuItemClickIntent) intent;
            y(customMenuItemClickIntent.getMenuCommand(), customMenuItemClickIntent.getMenuId(), customMenuItemClickIntent.getMenuLevel());
        } else if (intent instanceof PAInputIntent.CustomMenuSwitchBtnClickIntent) {
            n();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.d().getLifecycle().addObserver(this);
        this.mPublicAccountManager = (IPublicAccountManager) QRoute.api(IPublicAccountManager.class);
        A();
    }

    private final void t(boolean isShotMode) {
        if (isShotMode) {
            c.GetInputBitmap getInputBitmap = new c.GetInputBitmap(null, 1, null);
            fetchVBState(getInputBitmap);
            Bitmap bitmap = getInputBitmap.getBitmap();
            if (bitmap != null) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetInputBarBitmap(bitmap));
            }
        }
        updateUI(new PAInputUIState.SetLongShotBarVisibility(isShotMode ? 0 : 8));
    }

    private final void u(boolean isSelected) {
        updateUI(new PAInputUIState.SetMultiSelectBarVisibility(isSelected ? 0 : 8));
    }

    private final void z() {
    }
}
