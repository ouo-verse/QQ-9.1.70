package com.tencent.kuikly.core.manager;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.exception.PagerCreatorNotFundException;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.measure.utils.MeasureConst;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bf\u0010gJZ\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u0012\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0011J\u001c\u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bJ\u000e\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\fJV\u0010(\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001J\u001e\u0010+\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0011J\u0016\u0010,\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0002J&\u00100\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002J8\u00105\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u0002J6\u00109\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u0002062\u0006\u00100\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206J&\u0010:\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206J6\u0010>\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00112\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0011JB\u0010A\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010@\u001a\u00020\u0002JN\u0010D\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010@\u001a\u00020\u0002J\u001e\u0010E\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0011J\u0016\u0010F\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0002J&\u0010G\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0001J\u0016\u0010H\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0002J\u001e\u0010J\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010I\u001a\u0002062\u0006\u0010=\u001a\u00020\u0011J,\u0010K\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00112\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0011J\u000e\u0010L\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011J\u0014\u0010N\u001a\u00020\f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010O\u001a\u00020\u0017J\u0014\u0010P\u001a\u00020\f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010Q\u001a\u00020\f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010S\u001a\u00020\f2\b\u0010R\u001a\u0004\u0018\u00010$R\u0016\u0010V\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR*\u0010^\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u00118F@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001d0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020$0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010d\u00a8\u0006h"}, d2 = {"Lcom/tencent/kuikly/core/manager/BridgeManager;", "", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "l", "Lkotlin/Function0;", "", "block", "H", "", "throwable", "", "w", "Lkotlin/Pair;", "v", "Lcom/tencent/kuikly/core/pager/b;", "t", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "La01/b;", "globalNativeDelegate", HippyTKDListViewAdapter.X, "instanceId", "La01/c;", MosaicConstants$JsProperty.PROP_NATIVE_BRIDGE, BdhLogUtil.LogTag.Tag_Conn, "pageName", "B", "creator", "D", "Lcom/tencent/kuikly/core/manager/b;", "observer", "e", "E", "j", "tag", "viewName", "r", UserInfo.SEX_FEMALE, "parentTag", "childTag", "index", "y", "propKey", "propValue", "isEvent", "sync", "O", "", "width", "height", "K", "i", "method", "params", "callbackId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "moduleName", "syncCall", "k", "succCallbackId", "errorCallbackId", "p", ReportConstant.COSTREPORT_PREFIX, "G", "M", "L", "delayTimeMs", "N", DomainData.DOMAIN_NAME, "o", "task", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "g", h.F, "delegate", "I", "b", "Z", "didInit", "value", "c", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "J", "(Ljava/lang/String;)V", "currentPageId", "Lcom/tencent/kuikly/core/kmp/b;", "d", "Lcom/tencent/kuikly/core/kmp/b;", "nativeBridgeMap", "callObserverMap", "Lcom/tencent/kuikly/core/manager/b;", "bridgeDelegate", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BridgeManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean didInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.kuikly.core.kmp.b<a01.c> nativeBridgeMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.kuikly.core.kmp.b<b> callObserverMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static b bridgeDelegate;

    /* renamed from: a, reason: collision with root package name */
    public static final BridgeManager f117344a = new BridgeManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String currentPageId = "";

    static {
        c cVar = c.f117352a;
        boolean z16 = false;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        nativeBridgeMap = new com.tencent.kuikly.core.kmp.b<>(cVar.j(), z16, i3, defaultConstructorMarker);
        callObserverMap = new com.tencent.kuikly.core.kmp.b<>(cVar.j(), z16, i3, defaultConstructorMarker);
    }

    BridgeManager() {
    }

    private final void H(Function0<Unit> block) {
        try {
            block.invoke();
        } catch (Throwable th5) {
            String w3 = w(th5);
            Pair<Integer, String> v3 = v(th5);
            String a16 = com.tencent.kuikly.core.exception.a.a(th5);
            com.tencent.kuikly.core.pager.b t16 = t(th5);
            if (t16 != null) {
                t16.onUnhandledException(a16);
            }
            if ((Intrinsics.areEqual(v3.getSecond(), "android") && v3.getFirst().intValue() >= 5) || Intrinsics.areEqual(v3.getSecond(), "ohos")) {
                a01.c b16 = nativeBridgeMap.b(w3);
                if (b16 != null) {
                    b16.c(15, w3, a16, null, null, null, null);
                    return;
                }
                return;
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String str) {
        if (c.f117352a.n(str)) {
            return;
        }
        currentPageId = str;
    }

    private final Object l(final int methodId, final Object arg0, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        H(new Function0<Unit>() { // from class: com.tencent.kuikly.core.manager.BridgeManager$callNativeMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
            
                r0 = com.tencent.kuikly.core.manager.BridgeManager.bridgeDelegate;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                com.tencent.kuikly.core.kmp.b bVar;
                com.tencent.kuikly.core.kmp.b bVar2;
                b bVar3;
                c cVar = c.f117352a;
                Object obj = arg0;
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    str = "";
                }
                if (!cVar.n(str) && bVar3 != null) {
                    bVar3.onCallNative(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
                }
                bVar = BridgeManager.callObserverMap;
                b bVar4 = (b) bVar.b(BridgeManager.f117344a.u());
                if (bVar4 != null) {
                    a.c(bVar4, methodId, arg0, arg1, arg2, arg3, arg4, arg5);
                }
                Ref.ObjectRef<Object> objectRef2 = objectRef;
                bVar2 = BridgeManager.nativeBridgeMap;
                Object obj2 = arg0;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                a01.c cVar2 = (a01.c) bVar2.b((String) obj2);
                objectRef2.element = cVar2 != null ? cVar2.c(methodId, arg0, arg1, arg2, arg3, arg4, arg5) : 0;
            }
        });
        return objectRef.element;
    }

    private final com.tencent.kuikly.core.pager.b t(Throwable throwable) {
        if (throwable instanceof PagerCreatorNotFundException) {
            return null;
        }
        return c.f117352a.h();
    }

    private final Pair<Integer, String> v(Throwable throwable) {
        String str;
        if (throwable instanceof PagerCreatorNotFundException) {
            e eVar = new e(((PagerCreatorNotFundException) throwable).getPageData());
            return new Pair<>(Integer.valueOf(eVar.k("nativeBuild", 0)), eVar.p("platform"));
        }
        com.tencent.kuikly.core.pager.b h16 = c.f117352a.h();
        g pageData = h16 != null ? h16.getPageData() : null;
        Integer valueOf = Integer.valueOf(pageData != null ? pageData.getNativeBuild() : -1);
        if (pageData == null || (str = pageData.getPlatform()) == null) {
            str = "";
        }
        return new Pair<>(valueOf, str);
    }

    private final String w(Throwable throwable) {
        if (throwable instanceof PagerCreatorNotFundException) {
            return ((PagerCreatorNotFundException) throwable).getPagerId();
        }
        return u();
    }

    public final boolean A() {
        return didInit;
    }

    public final boolean B(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return c.f117352a.o(pageName);
    }

    public final void C(String instanceId, a01.c nativeBridge) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(nativeBridge, "nativeBridge");
        nativeBridgeMap.e(instanceId, nativeBridge);
    }

    public final void D(String pageName, Function0<? extends com.tencent.kuikly.core.pager.b> creator) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(creator, "creator");
        c.f117352a.r(pageName, creator);
    }

    public final void E() {
        callObserverMap.d(u());
    }

    public final void F(String instanceId, int tag) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        m(this, 2, instanceId, Integer.valueOf(tag), null, null, null, null, 120, null);
    }

    public final void G(String instanceId, int tag) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        m(this, 10, instanceId, Integer.valueOf(tag), null, null, null, null, 120, null);
    }

    public final void I(b delegate) {
        bridgeDelegate = delegate;
    }

    public final void K(String instanceId, int tag, float x16, float y16, float width, float height) {
        b bVar;
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        if (!c.f117352a.n(instanceId) && (bVar = bridgeDelegate) != null) {
            bVar.onSetRenderViewFrame(tag, x16, y16, width, height);
        }
        l(5, instanceId, Integer.valueOf(tag), Float.valueOf(x16), Float.valueOf(y16), Float.valueOf(width), Float.valueOf(height));
    }

    public final void L(String instanceId, int tag) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        m(this, 12, instanceId, Integer.valueOf(tag), null, null, null, null, 120, null);
    }

    public final void M(String instanceId, int tag, String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        m(this, 11, instanceId, Integer.valueOf(tag), propKey, propValue, null, null, 96, null);
    }

    public final void N(String instanceId, float delayTimeMs, String callbackId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        m(this, 13, instanceId, Float.valueOf(delayTimeMs), callbackId, null, null, null, 112, null);
    }

    public final void O(String instanceId, int tag, String propKey, Object propValue, int isEvent, int sync) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        l(4, instanceId, Integer.valueOf(tag), propKey, propValue, Integer.valueOf(isEvent), Integer.valueOf(sync));
    }

    public final void e(b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        callObserverMap.e(u(), observer);
    }

    public final void f(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        a01.a aVar = a01.a.f25308a;
        if (aVar.a()) {
            aVar.c(18, new Function0<Unit>() { // from class: com.tencent.kuikly.core.manager.BridgeManager$asyncContextThread$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (!c.f117352a.m()) {
                        TimerKt.c(1, task);
                    } else {
                        task.invoke();
                    }
                }
            }, null, null, null, null, null);
        } else {
            TimerKt.c(1, task);
        }
    }

    public final void g(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        a01.a aVar = a01.a.f25308a;
        if (aVar.a()) {
            aVar.c(19, task, null, null, null, null, null);
        } else {
            TimerKt.c(1, task);
        }
    }

    public final void h(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        a01.a aVar = a01.a.f25308a;
        if (aVar.a()) {
            aVar.c(20, task, null, null, null, null, null);
        } else {
            TimerKt.c(1, task);
        }
    }

    public final String i(String instanceId, int tag, float width, float height) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Object m3 = m(this, 6, instanceId, Integer.valueOf(tag), Float.valueOf(width), Float.valueOf(height), null, null, 96, null);
        if (m3 == null) {
            return "";
        }
        return (String) m3;
    }

    public final void j(final int methodId, final Object arg0, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final Object arg5) {
        H(new Function0<Unit>() { // from class: com.tencent.kuikly.core.manager.BridgeManager$callKotlinMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x00dc, code lost:
            
                r0 = com.tencent.kuikly.core.manager.BridgeManager.bridgeDelegate;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                com.tencent.kuikly.core.kmp.b bVar;
                b bVar2;
                Object obj = arg0;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                BridgeManager.f117344a.J(str);
                switch (methodId) {
                    case 1:
                        c cVar = c.f117352a;
                        Object obj2 = arg0;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                        Object obj3 = arg1;
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                        Object obj4 = arg2;
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                        cVar.a((String) obj2, (String) obj3, (String) obj4);
                        break;
                    case 2:
                        c cVar2 = c.f117352a;
                        Object obj5 = arg0;
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                        Object obj6 = arg1;
                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                        Object obj7 = arg2;
                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Any");
                        cVar2.e((String) obj5, (String) obj6, obj7);
                        break;
                    case 3:
                        Object obj8 = arg0;
                        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.String");
                        String str2 = (String) obj8;
                        c.f117352a.b(str2);
                        bVar = BridgeManager.nativeBridgeMap;
                        a01.c cVar3 = (a01.c) bVar.d(str2);
                        if (cVar3 != null) {
                            cVar3.a();
                            break;
                        }
                        break;
                    case 4:
                        c cVar4 = c.f117352a;
                        Object obj9 = arg0;
                        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.String");
                        Object obj10 = arg1;
                        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.String");
                        cVar4.c((String) obj9, (String) obj10, arg2);
                        break;
                    case 5:
                        c cVar5 = c.f117352a;
                        Object obj11 = arg0;
                        Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.String");
                        String str3 = (String) obj11;
                        Object obj12 = arg1;
                        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Int");
                        int intValue = ((Integer) obj12).intValue();
                        Object obj13 = arg2;
                        Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.String");
                        String str4 = (String) obj13;
                        Object obj14 = arg3;
                        cVar5.f(str3, intValue, str4, obj14 instanceof String ? (String) obj14 : null);
                        break;
                    case 6:
                        c cVar6 = c.f117352a;
                        Object obj15 = arg0;
                        Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type kotlin.String");
                        cVar6.d((String) obj15);
                        break;
                    default:
                        KLog.INSTANCE.e("BridgeManager", "[callKotlinMethod]:call method failed. methodId: " + methodId);
                        break;
                }
                if (c.f117352a.n(str) || bVar2 == null) {
                    return;
                }
                bVar2.onCallKotlin(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
            }
        });
        b b16 = callObserverMap.b(u());
        if (b16 != null) {
            a.b(b16, methodId, arg0, arg1, arg2, arg3, arg4, arg5);
        }
    }

    public final Object k(String instanceId, String moduleName, String method, Object params, String callbackId, int syncCall) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        return l(8, instanceId, moduleName, method, params, callbackId, Integer.valueOf(syncCall));
    }

    public final Object n(String instanceId, int tag, String method, String params) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(method, "method");
        return m(this, 14, instanceId, Integer.valueOf(tag), method, params, null, null, 96, null);
    }

    public final void o(String instanceId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        m(this, 16, instanceId, null, null, null, null, null, 124, null);
    }

    public final void q(String instanceId, int tag, String method, String params, String callbackId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(method, "method");
        m(this, 7, instanceId, Integer.valueOf(tag), method, params, callbackId, null, 64, null);
    }

    public final void r(String instanceId, int tag, String viewName) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        m(this, 1, instanceId, Integer.valueOf(tag), viewName, null, null, null, 112, null);
    }

    public final void s(String instanceId, int tag, String viewName) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        m(this, 9, instanceId, Integer.valueOf(tag), viewName, null, null, null, 112, null);
    }

    public final String u() {
        c cVar = c.f117352a;
        if (cVar.l() && (!a.a() || cVar.m())) {
            return cVar.j();
        }
        return currentPageId;
    }

    public final void y(String instanceId, int parentTag, int childTag, int index) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        m(this, 3, instanceId, Integer.valueOf(parentTag), Integer.valueOf(childTag), Integer.valueOf(index), null, null, 96, null);
    }

    public final boolean z() {
        if (a01.a.f25308a.a()) {
            return !Intrinsics.areEqual(r0.c(21, null, null, null, null, null, null), (Object) 0);
        }
        return true;
    }

    public final void x(a01.b globalNativeDelegate) {
        didInit = true;
        if (globalNativeDelegate != null) {
            a01.a.f25308a.b(globalNativeDelegate);
        }
    }

    public final Object p(String instanceId, String moduleName, String method, String params, String succCallbackId, String errorCallbackId, int syncCall) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        e eVar = new e();
        if (succCallbackId != null) {
            eVar.v(MeasureConst.SLI_TYPE_SUCCESS, succCallbackId);
        }
        if (errorCallbackId != null) {
            eVar.v("error", errorCallbackId);
        }
        return l(17, instanceId, moduleName, method, params, eVar.toString(), Integer.valueOf(syncCall));
    }

    public static /* synthetic */ void P(BridgeManager bridgeManager, String str, int i3, String str2, Object obj, int i16, int i17, int i18, Object obj2) {
        if ((i18 & 32) != 0) {
            i17 = 0;
        }
        bridgeManager.O(str, i3, str2, obj, i16, i17);
    }

    static /* synthetic */ Object m(BridgeManager bridgeManager, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i16, Object obj7) {
        return bridgeManager.l(i3, (i16 & 2) != 0 ? null : obj, (i16 & 4) != 0 ? null : obj2, (i16 & 8) != 0 ? null : obj3, (i16 & 16) != 0 ? null : obj4, (i16 & 32) != 0 ? null : obj5, (i16 & 64) == 0 ? obj6 : null);
    }
}
