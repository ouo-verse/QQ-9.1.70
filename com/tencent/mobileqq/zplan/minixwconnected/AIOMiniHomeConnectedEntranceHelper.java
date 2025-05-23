package com.tencent.mobileqq.zplan.minixwconnected;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Job;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 +2\u00020\u0001:\u0001,Bm\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f\u00128\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eRF\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR/\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010%R\u0014\u0010(\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/AIOMiniHomeConnectedEntranceHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/u;", "", "eventKey", "", "j", "e", "g", "d", "", "state", "onMoveToState", "Lkotlin/Function0;", "Landroid/content/Context;", "Lkotlin/jvm/functions/Function0;", "contextGetter", "c2cUinGetter", "f", "c2cNicknameGetter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "", "value", tl.h.F, "Lkotlin/jvm/functions/Function2;", "sender", "Lkotlinx/coroutines/Job;", "<set-?>", "i", "Lkotlin/properties/ReadWriteProperty;", "getJob", "()Lkotlinx/coroutines/Job;", "k", "(Lkotlinx/coroutines/Job;)V", "job", "()Landroid/content/Context;", "context", "()Ljava/lang/String;", "c2cUin", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOMiniHomeConnectedEntranceHelper implements com.tencent.mobileqq.activity.aio.helper.u {
    private static final ReadWriteProperty<Object, Boolean> D;
    private static final ReadWriteProperty<Object, Boolean> E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<Context> contextGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<String> c2cUinGetter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function0<String> c2cNicknameGetter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function2<Integer, Object, Unit> sender;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty job;
    static final /* synthetic */ KProperty<Object>[] C = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AIOMiniHomeConnectedEntranceHelper.class, "job", "getJob()Lkotlinx/coroutines/Job;", 0))};

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/AIOMiniHomeConnectedEntranceHelper$a;", "", "", "<set-?>", "mmkvForceDisable$delegate", "Lkotlin/properties/ReadWriteProperty;", "a", "()Z", "c", "(Z)V", "mmkvForceDisable", "mmkvIsBubbleShown$delegate", "b", "d", "mmkvIsBubbleShown", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.AIOMiniHomeConnectedEntranceHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f334438a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvForceDisable", "getMmkvForceDisable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvIsBubbleShown", "getMmkvIsBubbleShown()Z", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) AIOMiniHomeConnectedEntranceHelper.D.getValue(this, f334438a[0])).booleanValue();
        }

        public final boolean b() {
            return ((Boolean) AIOMiniHomeConnectedEntranceHelper.E.getValue(this, f334438a[1])).booleanValue();
        }

        public final void c(boolean z16) {
            AIOMiniHomeConnectedEntranceHelper.D.setValue(this, f334438a[0], Boolean.valueOf(z16));
        }

        public final void d(boolean z16) {
            AIOMiniHomeConnectedEntranceHelper.E.setValue(this, f334438a[1], Boolean.valueOf(z16));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends ObservableProperty<Job> {
        public b(Object obj) {
            super(obj);
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, Job oldValue, Job newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            Job job = oldValue;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIOMiniHomeConnectedEntranceHelper(Function0<? extends Context> contextGetter, Function0<String> c2cUinGetter, Function0<String> c2cNicknameGetter, Function2<? super Integer, Object, Unit> sender) {
        Intrinsics.checkNotNullParameter(contextGetter, "contextGetter");
        Intrinsics.checkNotNullParameter(c2cUinGetter, "c2cUinGetter");
        Intrinsics.checkNotNullParameter(c2cNicknameGetter, "c2cNicknameGetter");
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.contextGetter = contextGetter;
        this.c2cUinGetter = c2cUinGetter;
        this.c2cNicknameGetter = c2cNicknameGetter;
        this.sender = sender;
        Delegates delegates = Delegates.INSTANCE;
        this.job = new b(null);
    }

    private final void e() {
        final WeakReference weakReference = new WeakReference(this);
        com.tencent.mobileqq.zplan.minixwconnected.b.f(this.sender, R.drawable.gq5, R.drawable.gq5);
        com.tencent.mobileqq.zplan.minixwconnected.b.d(this.sender, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOMiniHomeConnectedEntranceHelper.f(AIOMiniHomeConnectedEntranceHelper.this, weakReference, view);
            }
        });
        com.tencent.mobileqq.zplan.minixwconnected.b.e(this.sender, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AIOMiniHomeConnectedEntranceHelper this$0, WeakReference thisRef, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisRef, "$thisRef");
        this$0.j("click");
        AIOMiniHomeConnectedEntranceHelper aIOMiniHomeConnectedEntranceHelper = (AIOMiniHomeConnectedEntranceHelper) thisRef.get();
        if (aIOMiniHomeConnectedEntranceHelper == null) {
            return;
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(aIOMiniHomeConnectedEntranceHelper.i(), ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("aio_titlebar", null, this$0.h(), false, null));
    }

    private final String h() {
        return this.c2cUinGetter.invoke();
    }

    private final Context i() {
        return this.contextGetter.invoke();
    }

    private final void k(Job job) {
        this.job.setValue(this, C[0], job);
    }

    static {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        D = t74.i.f((IZPlanMMKVApi) api, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.AIOMiniHomeConnectedEntranceHelper$Companion$mmkvForceDisable$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_AIOMiniHomeConnectedEntranceHelper_forceDisable";
            }
        }, false);
        QRouteApi api2 = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IZPlanMMKVApi::class.java)");
        E = t74.i.f((IZPlanMMKVApi) api2, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.AIOMiniHomeConnectedEntranceHelper$Companion$mmkvIsBubbleShown$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_AIOMiniHomeConnectedEntranceHelper_isBubbleShown";
            }
        }, false);
    }

    private final void d() {
        k(null);
    }

    private final void j(String eventKey) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE"), TuplesKt.to("zplan_action_type", eventKey));
        VideoReport.reportEvent("ev_zplan_aio_xiaowo_link_en", mapOf);
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int state) {
        if (state == 5) {
            e();
        } else if (state == 12) {
            g();
        } else {
            if (state != 15) {
                return;
            }
            d();
        }
    }

    private final void g() {
    }
}
