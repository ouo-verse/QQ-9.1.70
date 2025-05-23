package com.tencent.qqnt.aio.helper;

import a54.a;
import android.text.Spanned;
import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.TroopDrawerScrollChangedEvent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.robot.slash.api.IRobotSlashApi;
import com.tencent.robot.slash.input.InputRobotMsgIntent;
import com.tencent.robot.slash.input.InputSlashMsgIntent;
import com.tencent.robot.slash.manager.d;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import l64.a;
import l64.b;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0004FILP\b\u0007\u0018\u0000 V2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u00020\tH\u0016J\u0012\u00104\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00108\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030605j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000306`7H\u0016R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqnt/aio/helper/eq;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/g;", "", "isSuccess", "", "troopUin", "", "u", "v", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", tl.h.F, "j", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$DispatchKeyBackEventInPreIme;", "k", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent$OnTextChangedForSlashDialog;", "o", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/slash/input/InputRobotMsgIntent$OnTextChangedForRobotAtDialog;", "event", "t", "charsOfConcern", "Lcom/tencent/qqnt/aio/at/c;", "lastAtSpan", "e", "r", "g", "Lcom/tencent/mvi/base/route/k;", "i", "Ll64/a$b;", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/utils/TroopDrawerScrollChangedEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Z", "isHasInitialized", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/robot/slash/manager/d;", "f", "Lcom/tencent/robot/slash/manager/d;", "mSlashDialogManagerApi", "Lcom/tencent/robot/slash/manager/b;", "Lcom/tencent/robot/slash/manager/b;", "mRobotFunctionManagerApi", "com/tencent/qqnt/aio/helper/eq$e", "Lcom/tencent/qqnt/aio/helper/eq$e;", "mTroopRobotObserver", "com/tencent/qqnt/aio/helper/eq$d", "Lcom/tencent/qqnt/aio/helper/eq$d;", "mRobotRelationObserver", "com/tencent/qqnt/aio/helper/eq$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/helper/eq$b;", "mAction", "com/tencent/qqnt/aio/helper/eq$c", "D", "Lcom/tencent/qqnt/aio/helper/eq$c;", "mActionR", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class eq implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mvi.base.route.g {
    private static final Regex F = new Regex("( )[^\n@\uff20]*");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isHasInitialized;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.slash.manager.d mSlashDialogManagerApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.slash.manager.b mRobotFunctionManagerApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final e mTroopRobotObserver = new e();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final d mRobotRelationObserver = new d();

    /* renamed from: C, reason: from kotlin metadata */
    private final b mAction = new b();

    /* renamed from: D, reason: from kotlin metadata */
    private final c mActionR = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/eq$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            eq.this.h(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/eq$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        public com.tencent.mvi.base.route.k call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return eq.this.i(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/helper/eq$d", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "f", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements a54.a {
        d() {
        }

        @Override // a54.a
        public void a(String str) {
            a.C0013a.e(this, str);
        }

        @Override // a54.a
        public void b(String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(String robotUin, String troopUin, Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.c(this, robotUin, troopUin, extraData);
            eq.this.u(true, troopUin);
        }

        @Override // a54.a
        public void e(String str, String str2, Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(String robotUin, String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.f(this, robotUin, troopUin);
            eq.this.u(true, troopUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J&\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/helper/eq$e", "Lct2/b;", "", "troopUin", "robotUin", "robotName", "", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends ct2.b {
        e() {
        }

        @Override // ct2.b
        protected void a(String troopUin, String robotUin, String robotName) {
            eq.this.u(true, troopUin);
        }

        @Override // ct2.b
        protected void b(String troopUin, String robotUin, String robotName) {
            eq.this.u(true, troopUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputRobotMsgIntent.OnTextChangedForRobotAtDialog f350818d;

        public f(InputRobotMsgIntent.OnTextChangedForRobotAtDialog onTextChangedForRobotAtDialog) {
            this.f350818d = onTextChangedForRobotAtDialog;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f350818d.getSpannedChar().getSpanStart((com.tencent.qqnt.aio.at.c) t16)), Integer.valueOf(this.f350818d.getSpannedChar().getSpanStart((com.tencent.qqnt.aio.at.c) t17)));
            return compareValues;
        }
    }

    private final boolean e(String charsOfConcern, com.tencent.qqnt.aio.at.c lastAtSpan) {
        CharSequence trimStart;
        if (r(charsOfConcern)) {
            com.tencent.robot.slash.manager.b bVar = this.mRobotFunctionManagerApi;
            if (bVar != null) {
                bVar.dismissDialog();
            }
            return false;
        }
        if (this.mRobotFunctionManagerApi == null) {
            v();
        }
        com.tencent.robot.slash.manager.b bVar2 = this.mRobotFunctionManagerApi;
        if (bVar2 != null) {
            Intrinsics.checkNotNull(charsOfConcern);
            trimStart = StringsKt__StringsKt.trimStart((CharSequence) charsOfConcern);
            String obj = trimStart.toString();
            Intrinsics.checkNotNull(lastAtSpan);
            String k3 = lastAtSpan.k();
            Intrinsics.checkNotNullExpressionValue(k3, "lastAtSpan!!.troopMemUin");
            bVar2.d(obj, k3);
        }
        return true;
    }

    private final void g() {
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        if (dVar != null) {
            dVar.e();
        }
        com.tencent.robot.slash.manager.d dVar2 = this.mSlashDialogManagerApi;
        if (dVar2 != null) {
            d.a.a(dVar2, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(MsgIntent msgIntent) {
        if (msgIntent instanceof InputSlashMsgIntent.OnTextChangedForSlashDialog) {
            o((InputSlashMsgIntent.OnTextChangedForSlashDialog) msgIntent);
        } else if (msgIntent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            k((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) msgIntent);
        } else if (msgIntent instanceof InputSlashMsgIntent.DismissSlashDialog) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k i(MsgIntent msgIntent) {
        if (msgIntent instanceof InputSlashMsgIntent.GetSlashDialogIsSowing) {
            return n();
        }
        if (msgIntent instanceof InputRobotMsgIntent.GetDialogIsShowing) {
            return m();
        }
        if (msgIntent instanceof InputRobotMsgIntent.OnTextChangedForRobotAtDialog) {
            return p((InputRobotMsgIntent.OnTextChangedForRobotAtDialog) msgIntent);
        }
        return new j54.a();
    }

    private final void j() {
        QLog.d("TroopInputSlashHelper", 1, "handleDismissDialogMsgIntent");
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        if (dVar != null && dVar.r()) {
            g();
        }
    }

    private final void k(InputEditTextMsgIntent.DispatchKeyBackEventInPreIme msgIntent) {
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        boolean z16 = false;
        if (dVar != null && dVar.r()) {
            msgIntent.b(true);
            g();
        }
        com.tencent.robot.slash.manager.b bVar = this.mRobotFunctionManagerApi;
        if (bVar != null && bVar.a()) {
            z16 = true;
        }
        if (z16) {
            msgIntent.b(true);
            com.tencent.robot.slash.manager.b bVar2 = this.mRobotFunctionManagerApi;
            if (bVar2 != null) {
                bVar2.dismissDialog();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if ((r1 != null ? r1.e() : false) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.mvi.base.route.k m() {
        com.tencent.robot.slash.manager.b bVar = this.mRobotFunctionManagerApi;
        boolean z16 = false;
        if (!(bVar != null ? bVar.a() : false)) {
            com.tencent.robot.slash.manager.b bVar2 = this.mRobotFunctionManagerApi;
        }
        z16 = true;
        return new a.DialogIsShowingResult(z16);
    }

    private final com.tencent.mvi.base.route.k n() {
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        return new b.GetSlashDialogIsShowingResult(dVar != null ? dVar.r() : false);
    }

    private final void o(InputSlashMsgIntent.OnTextChangedForSlashDialog msgIntent) {
        String replaceFirst$default;
        if (s(msgIntent.getSpannedChars(), msgIntent.getSelectionStart())) {
            g();
            return;
        }
        String substring = msgIntent.getSpannedChars().toString().substring(0, msgIntent.getSelectionStart());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(substring, "/", "", false, 4, (Object) null);
        if (this.mSlashDialogManagerApi == null) {
            v();
        }
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        if (dVar != null) {
            dVar.g(replaceFirst$default);
        }
    }

    private final a.OnTextChangedProcessResult p(InputRobotMsgIntent.OnTextChangedForRobotAtDialog msgIntent) {
        return new a.OnTextChangedProcessResult(t(msgIntent));
    }

    private final void q(TroopDrawerScrollChangedEvent event) {
        com.tencent.robot.slash.manager.b bVar;
        com.tencent.robot.slash.manager.d dVar;
        if (event.getNewScrollX() <= event.getOldScrollX() || event.getNewScrollX() <= 0) {
            return;
        }
        com.tencent.robot.slash.manager.d dVar2 = this.mSlashDialogManagerApi;
        if ((dVar2 != null && dVar2.r()) && (dVar = this.mSlashDialogManagerApi) != null) {
            dVar.b(false);
        }
        com.tencent.robot.slash.manager.b bVar2 = this.mRobotFunctionManagerApi;
        if (!(bVar2 != null && bVar2.a()) || (bVar = this.mRobotFunctionManagerApi) == null) {
            return;
        }
        bVar.dismissDialog();
    }

    private final boolean s(Spanned spannedChars, int selectionStart) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        boolean z16;
        startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) spannedChars, (CharSequence) "/", false, 2, (Object) null);
        if (startsWith$default) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) spannedChars, (CharSequence) "\n", false, 2, (Object) null);
            if (!contains$default && selectionStart >= spannedChars.length()) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) spannedChars, TokenParser.SP, false, 2, (Object) null);
                if (!contains$default2) {
                    com.tencent.qqnt.aio.at.c[] cVarArr = (com.tencent.qqnt.aio.at.c[]) spannedChars.getSpans(0, spannedChars.length(), com.tencent.qqnt.aio.at.c.class);
                    if (cVarArr != null) {
                        z16 = !(cVarArr.length == 0);
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final boolean t(InputRobotMsgIntent.OnTextChangedForRobotAtDialog event) {
        com.tencent.qqnt.aio.at.c cVar;
        Object lastOrNull;
        com.tencent.qqnt.aio.at.c[] processTextChangedForRobotAtDialog$lambda$2 = (com.tencent.qqnt.aio.at.c[]) event.getSpannedChar().getSpans(0, event.getSelectionStart(), com.tencent.qqnt.aio.at.c.class);
        Intrinsics.checkNotNullExpressionValue(processTextChangedForRobotAtDialog$lambda$2, "processTextChangedForRobotAtDialog$lambda$2");
        if (processTextChangedForRobotAtDialog$lambda$2.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(processTextChangedForRobotAtDialog$lambda$2, new f(event));
        }
        String str = null;
        if (processTextChangedForRobotAtDialog$lambda$2 != null) {
            lastOrNull = ArraysKt___ArraysKt.lastOrNull(processTextChangedForRobotAtDialog$lambda$2);
            cVar = (com.tencent.qqnt.aio.at.c) lastOrNull;
        } else {
            cVar = null;
        }
        int spanEnd = cVar != null ? event.getSpannedChar().getSpanEnd(cVar) : -1;
        if (spanEnd >= 0 && spanEnd < event.getSelectionStart()) {
            str = event.getSpannedChar().subSequence(spanEnd, event.getSelectionStart()).toString();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopInputSlashHelper", 4, "charsOfConcern: " + str + " lastAtEnd=" + spanEnd + " selectionStart=" + event.getSelectionStart() + ", inputSize=" + event.getSpannedChar().length());
        }
        return e(str, cVar);
    }

    private final void v() {
        if (this.isHasInitialized) {
            return;
        }
        this.isHasInitialized = true;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(AIOInputMsgIntent.GetInputDialogAnchor.f189144d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputDialogAnchor");
        View a16 = ((d.e) k3).a();
        IRobotSlashApi iRobotSlashApi = (IRobotSlashApi) QRoute.api(IRobotSlashApi.class);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        this.mSlashDialogManagerApi = iRobotSlashApi.createSlashManagerFromAIO(aVar3, a16);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar4;
        }
        this.mRobotFunctionManagerApi = iRobotSlashApi.createRobotFunctionManager(aVar2, a16);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350618a1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.slash.input.InputSlashMsgIntent.OnTextChangedForSlashDialog");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.DispatchKeyBackEventInPreIme");
        hashSet.add("com.tencent.robot.slash.input.InputSlashMsgIntent.DismissSlashDialog");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.slash.input.InputSlashMsgIntent.GetSlashDialogIsSowing");
        hashSet.add("com.tencent.robot.slash.input.InputRobotMsgIntent.GetDialogIsShowing");
        hashSet.add("com.tencent.robot.slash.input.InputRobotMsgIntent.OnTextChangedForRobotAtDialog");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopInputSlashHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        a16.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().l(this, this.mActionR);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IRobotRelationService iRobotRelationService = (IRobotRelationService) (appInterface != null ? appInterface.getRuntimeService(IRobotRelationService.class, "") : null);
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.mRobotRelationObserver);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface2 = peekAppRuntime2 instanceof AppInterface ? (AppInterface) peekAppRuntime2 : null;
        if (appInterface2 != null) {
            appInterface2.addObserver(this.mTroopRobotObserver);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        if (dVar != null) {
            dVar.onDestroy();
        }
        this.mSlashDialogManagerApi = null;
        com.tencent.robot.slash.manager.b bVar = this.mRobotFunctionManagerApi;
        if (bVar != null) {
            bVar.destroy();
        }
        this.mRobotFunctionManagerApi = null;
        this.isHasInitialized = false;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().e(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IRobotRelationService iRobotRelationService = (IRobotRelationService) (appInterface != null ? appInterface.getRuntimeService(IRobotRelationService.class, "") : null);
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.mRobotRelationObserver);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface2 = peekAppRuntime2 instanceof AppInterface ? (AppInterface) peekAppRuntime2 : null;
        if (appInterface2 != null) {
            appInterface2.removeObserver(this.mTroopRobotObserver);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof TroopDrawerScrollChangedEvent) {
            q((TroopDrawerScrollChangedEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopDrawerScrollChangedEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean isSuccess, String troopUin) {
        if (isSuccess) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            if (Intrinsics.areEqual(troopUin, aVar.g().r().c().j())) {
                com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
                if (dVar != null) {
                    dVar.c();
                }
                com.tencent.robot.slash.manager.b bVar = this.mRobotFunctionManagerApi;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }
    }

    private final boolean r(String charsOfConcern) {
        CharSequence trim;
        if (charsOfConcern == null) {
            return true;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) charsOfConcern);
        if (trim.toString().length() <= 12) {
            return (charsOfConcern.length() > 1 && charsOfConcern.charAt(1) == ' ') || !F.matches(charsOfConcern);
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
