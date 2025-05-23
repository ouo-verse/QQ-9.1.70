package com.tencent.mobileqq.aio.msglist.childvm;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.RefreshType;
import com.tencent.mobileqq.aio.msg.t;
import com.tencent.mobileqq.aio.msglist.holder.external.ExternalGetUIInfoEvent;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import com.tencent.qqnt.aio.refresher.ae;
import com.tencent.qqnt.aio.refresher.af;
import com.tencent.qqnt.aio.refresher.am;
import com.tencent.qqnt.aio.refresher.ao;
import com.tencent.qqnt.aio.refresher.ap;
import com.tencent.qqnt.aio.refresher.as;
import com.tencent.qqnt.aio.refresher.av;
import com.tencent.qqnt.aio.refresher.aw;
import com.tencent.qqnt.aio.refresher.k;
import com.tencent.qqnt.aio.refresher.m;
import com.tencent.qqnt.aio.refresher.r;
import com.tencent.qqnt.aio.refresher.u;
import com.tencent.qqnt.aio.refresher.v;
import com.tencent.qqnt.aio.refresher.w;
import com.tencent.qqnt.aio.refresher.x;
import com.tencent.qqnt.aio.refresher.y;
import com.tencent.qqnt.aio.refresher.z;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceBody;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002KT\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001\nB#\u0012\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y0W\u0012\u0006\u0010[\u001a\u00020\t\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020+H\u0002J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u000202H\u0002J\u0010\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u000204H\u0002Jb\u0010C\u001a\u00020\u000328\u0010<\u001a4\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807j\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`;`:2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u000bH\u0002J4\u0010F\u001a\u00020\u00032\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`;0D2\u0006\u0010E\u001a\u00020@H\u0002J\u0010\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0002J\u0018\u0010J\u001a\u00020\u00032\u0006\u0010I\u001a\u00020H2\u0006\u0010A\u001a\u00020@H\u0002R\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r07j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR(\u0010S\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b08j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010U\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "sendMessage", "Lcom/tencent/aio/api/runtime/a;", "a", "", "type", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "r", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msglist/holder/external/MsgItemExternalRefreshEvent$DoRefresh;", "w", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "refreshRequest", "u", "Lcom/tencent/qqnt/aio/refresher/as;", "rsp", "H", "Lcom/tencent/qqnt/aio/refresher/c;", "y", "Lcom/tencent/qqnt/aio/refresher/af;", "E", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/aio/refresher/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/aio/refresher/t;", "J", "Lcom/tencent/qqnt/aio/refresher/u;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/refresher/z;", BdhLogUtil.LogTag.Tag_Conn, "p", "Lcom/tencent/qqnt/aio/refresher/am;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/refresher/ap;", "G", "Lcom/tencent/qqnt/aio/refresher/aw;", "I", "troopUin", "memberUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/refresher/w;", "B", "Lcom/tencent/qqnt/aio/refresher/av;", "o", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$ResourceItem;", "resourceItem", "t", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msg/t;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "refreshMap", "key", "Lcom/tencent/mobileqq/aio/msg/RefreshType;", "refreshType", "", "businessId", "itemId", "l", "", "updateType", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgIem", "v", "com/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$b", h.F, "Lcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$b;", "mAction", "i", "Ljava/util/HashMap;", "refresherMap", "Ljava/util/ArrayList;", "earlyInitBusiType", "com/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$c", "Lcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$c;", "mEventObserver", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "mAioContext", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM extends com.tencent.mobileqq.aio.msglist.childvm.c implements com.tencent.mobileqq.aio.msglist.holder.external.e {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a D;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mEventObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.aio.msglist.holder.external.c> refresherMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> earlyInitBusiType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgItemRefreshBuisVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MsgItemRefreshBuisVM.this.s(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM$c", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements zv3.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgItemRefreshBuisVM.this);
            }
        }

        @Override // zv3.c
        public void B5(@NotNull zv3.a event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof com.tencent.qqnt.aio.frequencycontrol.a) {
                MsgItemRefreshBuisVM.this.t(((com.tencent.qqnt.aio.frequencycontrol.a) event).a());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58718);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            D = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM(@NotNull MsgListVMWrapper<at.b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mParentVm, (Object) mAioContext);
            return;
        }
        this.mAction = new b();
        this.refresherMap = new HashMap<>();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Reflection.getOrCreateKotlinClass(ae.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(m.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(r.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(y.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ao.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(com.tencent.qqnt.aio.refresher.a.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(v.class).getQualifiedName());
        this.earlyInitBusiType = arrayListOf;
        this.mEventObserver = new c();
    }

    private final void A(u rsp) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 4, "refreshGradeLevel");
        }
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshGradeLevel$$inlined$refreshMsgList$1(d16, this, "grade_level", null, rsp), 2, null);
    }

    private final void B(w rsp) {
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshMemberAppIconBindData$$inlined$refreshMsgList$1(d16, this, "troop_app_icon_bind_data", null, rsp), 2, null);
    }

    private final void C(z rsp) {
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshMemberLevel$$inlined$refreshMsgList$1(d16, this, "member_level", null, rsp), 2, null);
    }

    private final void D(Map<String, ? extends ArrayList<t>> refreshMap, int updateType) {
        QLog.i("MsgItemRefreshBuisVM", 1, "[refreshMsg]: size is " + refreshMap.size());
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshMsg$1(this, refreshMap, updateType, null), 2, null);
    }

    private final void E(af rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshMutualMask");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshMutualMask$1(this, rsp, null), 2, null);
    }

    private final void F(am rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshPaiYiPaiEffect");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1(this, rsp, null), 2, null);
    }

    private final void G(ap rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshQCircleRedDot");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshQCircleRedDot$1(this, rsp, null), 2, null);
    }

    private final void H(as rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshShootBubble");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshShootBubble$1(this, rsp, null), 2, null);
    }

    private final void I(aw rsp) {
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshTroopAIONickIcon$1(this, rsp, null), 2, null);
    }

    private final void J(com.tencent.qqnt.aio.refresher.t rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "toggleGradeLevel");
        }
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1(d16, this, "grade_level", null, rsp), 2, null);
    }

    private final void l(HashMap<String, ArrayList<t>> refreshMap, String key, RefreshType refreshType, int businessId, String itemId) {
        ArrayList<t> arrayList = refreshMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            refreshMap.put(key, arrayList);
        }
        arrayList.add(new t(refreshType, businessId, itemId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String troopUin, final String memberUin) {
        ((IAIONickIconServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONickIconServiceApi.class)).getTmInfoIconDataAsync(troopUin, memberUin, new IAIONickIconServiceApi.b(memberUin) { // from class: com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$doRefreshTroopAIONickIcon$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f190467b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f190467b = memberUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgItemRefreshBuisVM.this, (Object) memberUin);
                }
            }

            @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi.b
            public void a(boolean fetchedFromLruCache, @NotNull List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> nickIconData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(fetchedFromLruCache), nickIconData);
                    return;
                }
                Intrinsics.checkNotNullParameter(nickIconData, "nickIconData");
                MsgItemRefreshBuisVM msgItemRefreshBuisVM = MsgItemRefreshBuisVM.this;
                MsgListVMWrapper<at.b, MsgListUiState> d16 = msgItemRefreshBuisVM.d();
                BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$doRefreshTroopAIONickIcon$1$onNickIconFetched$$inlined$refreshMsgList$1(d16, msgItemRefreshBuisVM, "troop_nick_icon_data", null, this.f190467b, nickIconData), 2, null);
            }
        });
    }

    private final void n() {
        QLog.i("MsgItemRefreshBuisVM", 1, "forceRefreshMutualMask");
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$forceRefreshMutualMask$1(this, null), 2, null);
    }

    private final void o(av rsp) {
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$forceRefreshTroopAppIconBindData$$inlined$refreshMsgList$1(d16, this, "troop_app_icon_bind_data", null, rsp), 2, null);
    }

    private final void p() {
        MsgListVMWrapper<at.b, MsgListUiState> d16 = d();
        BuildersKt__Builders_commonKt.launch$default(d16.vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$forceUpdateMemberLevel$$inlined$refreshMsgList$1(d16, this, "member_level", null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int q(int businessId) {
        switch (businessId) {
            case 11020001:
            case 11020002:
            case 12020001:
            case 12020004:
            case 12020006:
            case 12020007:
            case 13020002:
            case 13020003:
                return 1;
            default:
                QLog.e("MsgItemRefreshBuisVM", 1, "[getMsgDataInjectType]: no match, businessId is " + businessId);
                return -1;
        }
    }

    private final com.tencent.mobileqq.aio.msglist.holder.external.c r(String type) {
        com.tencent.mobileqq.aio.msglist.holder.external.c cVar = this.refresherMap.get(type);
        if (cVar == null && (cVar = com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.a(type, this)) != null) {
            this.refresherMap.put(type, cVar);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(MsgIntent intent) {
        if (intent instanceof MsgItemExternalRefreshEvent.DoRefresh) {
            w((MsgItemExternalRefreshEvent.DoRefresh) intent);
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.ForceRefreshMutualMask) {
            n();
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.RefreshEvent) {
            u(((MsgItemExternalRefreshEvent.RefreshEvent) intent).a());
        } else if (intent instanceof ExternalGetUIInfoEvent.IsSelectMode) {
            ((ExternalGetUIInfoEvent.IsSelectMode) intent).a(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j(c()));
        } else if (intent instanceof FullBackgroundMviIntent.AIOBackgroundDrawable) {
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(FrequencyControlField$ResourceItem resourceItem) {
        boolean z16;
        String j3 = c().g().r().c().j();
        String str = resourceItem.peer_uid.get();
        int i3 = resourceItem.update_type.get();
        if (!j3.equals(str)) {
            return;
        }
        QLog.i("MsgItemRefreshBuisVM", 1, "[handleRefreshEvent], size " + resourceItem.resource_body_list.size() + ", currenPeerId is " + j3 + ", refreshPeerId is " + str + ", updateType is " + i3);
        HashMap<String, ArrayList<t>> hashMap = new HashMap<>();
        List<FrequencyControlField$ResourceBody> list = resourceItem.resource_body_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "resourceItem.resource_body_list.get()");
        for (FrequencyControlField$ResourceBody frequencyControlField$ResourceBody : list) {
            int i16 = frequencyControlField$ResourceBody.business_id.get();
            String senderUid = frequencyControlField$ResourceBody.sender_uid.get();
            long j16 = frequencyControlField$ResourceBody.sender_uin.get();
            String itemId = frequencyControlField$ResourceBody.item_id.get();
            long j17 = frequencyControlField$ResourceBody.msg_id.get();
            switch (frequencyControlField$ResourceBody.update_scope_type.get()) {
                case 222001:
                    String valueOf = String.valueOf(j17);
                    RefreshType refreshType = RefreshType.REFRESH_WITH_MSGID;
                    Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
                    l(hashMap, valueOf, refreshType, i16, itemId);
                    break;
                case 222002:
                    Intrinsics.checkNotNullExpressionValue(senderUid, "senderUid");
                    if (senderUid.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        RefreshType refreshType2 = RefreshType.REFRESH_WITH_UID;
                        Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
                        l(hashMap, senderUid, refreshType2, i16, itemId);
                        break;
                    } else if (j16 > 0) {
                        String valueOf2 = String.valueOf(j16);
                        RefreshType refreshType3 = RefreshType.REFRESH_WITH_UIN;
                        Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
                        l(hashMap, valueOf2, refreshType3, i16, itemId);
                        break;
                    } else {
                        break;
                    }
            }
        }
        if (!hashMap.isEmpty()) {
            D(hashMap, i3);
        }
    }

    private final void u(com.tencent.mobileqq.aio.msglist.holder.external.h refreshRequest) {
        System.currentTimeMillis();
        String qualifiedName = Reflection.getOrCreateKotlinClass(refreshRequest.getClass()).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        com.tencent.mobileqq.aio.msglist.holder.external.c r16 = r(qualifiedName);
        if (r16 != null) {
            if (!QQTheme.isNowSimpleUI() || r16.j()) {
                r16.c(refreshRequest);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(AIOMsgItem msgIem, int businessId) {
        Integer num;
        if (businessId == 13020001) {
            num = 1;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            QLog.i("MsgItemRefreshBuisVM", 1, "[handleResChange]");
            Integer valueOf = Integer.valueOf(intValue);
            HashMap<Integer, Integer> o06 = msgIem.o0();
            Integer num2 = msgIem.o0().get(Integer.valueOf(intValue));
            Intrinsics.checkNotNull(num2);
            o06.put(valueOf, Integer.valueOf(num2.intValue() + 1));
        }
    }

    private final void w(MsgItemExternalRefreshEvent.DoRefresh intent) {
        com.tencent.mobileqq.aio.msglist.holder.external.f a16 = intent.a();
        if (a16 instanceof as) {
            H((as) a16);
            return;
        }
        if (a16 instanceof com.tencent.qqnt.aio.refresher.c) {
            y((com.tencent.qqnt.aio.refresher.c) a16);
            return;
        }
        if (a16 instanceof af) {
            E((af) a16);
            return;
        }
        if (a16 instanceof k) {
            z((k) a16);
            return;
        }
        if (a16 instanceof u) {
            A((u) a16);
            return;
        }
        if (a16 instanceof com.tencent.qqnt.aio.refresher.t) {
            J((com.tencent.qqnt.aio.refresher.t) a16);
            return;
        }
        if (a16 instanceof z) {
            C((z) a16);
            return;
        }
        if (a16 instanceof x) {
            p();
            return;
        }
        if (a16 instanceof am) {
            F((am) a16);
            return;
        }
        if (a16 instanceof ap) {
            G((ap) a16);
            return;
        }
        if (a16 instanceof aw) {
            I((aw) a16);
        } else if (a16 instanceof w) {
            B((w) a16);
        } else if (a16 instanceof av) {
            o((av) a16);
        }
    }

    private final void x() {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshAIOBackground");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshAIOBackground$1(this, null), 2, null);
    }

    private final void y(com.tencent.qqnt.aio.refresher.c rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshAvatarEgg");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshAvatarEgg$1(this, rsp, null), 2, null);
    }

    private final void z(k rsp) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgItemRefreshBuisVM", 2, "refreshEssenceTail");
        }
        BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgItemRefreshBuisVM$refreshEssenceTail$1(this, rsp, null), 2, null);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.e
    @NotNull
    public com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return c();
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        c().e().f(this, this.mAction);
        QLog.i("MsgItemRefreshBuisVM", 1, "[onCreate]: earlyInitRefresher");
        for (String str : this.earlyInitBusiType) {
            Intrinsics.checkNotNull(str);
            r(str);
        }
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.aio.frequencycontrol.a.class, this.mEventObserver);
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.DoRefresh");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.ForceRefreshMutualMask");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.RefreshEvent");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.ExternalGetUIInfoEvent.IsSelectMode");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.AIOBackgroundDrawable");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c().e().i(this, this.mAction);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.aio.frequencycontrol.a.class, this.mEventObserver);
        Iterator<Map.Entry<String, com.tencent.mobileqq.aio.msglist.holder.external.c>> it = this.refresherMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().h();
        }
        this.refresherMap.clear();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.e
    @MainThread
    public void sendMessage(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            c().e().h(intent);
        }
    }
}
