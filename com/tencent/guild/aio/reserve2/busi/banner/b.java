package com.tencent.guild.aio.reserve2.busi.banner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import at.d;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.reserve2.busi.banner.GuildOperationBannerUIState;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import rr1.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001!\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u0015\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/banner/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lat/d;", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState;", "", DomainData.DOMAIN_NAME, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/LifecycleOwner;", "source", "p", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "E", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$NotifyEvent;", "notifyEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getOnDestroyUITask", "()Lkotlin/jvm/functions/Function0;", "onDestroyUITask", "", "e", "Z", "isInterestedChannelType", "f", "isBannerInitialized", "com/tencent/guild/aio/reserve2/busi/banner/b$b", h.F, "Lcom/tencent/guild/aio/reserve2/busi/banner/b$b;", "mAction", "Landroidx/lifecycle/LifecycleEventObserver;", "i", "Landroidx/lifecycle/LifecycleEventObserver;", "mEventObserver", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.b<d, GuildOperationBannerUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onDestroyUITask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isInterestedChannelType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isBannerInitialized;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C1209b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver mEventObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/reserve2/busi/banner/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.reserve2.busi.banner.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1209b implements com.tencent.mvi.base.route.a {
        C1209b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull Function0<Unit> onDestroyUITask) {
        Intrinsics.checkNotNullParameter(onDestroyUITask, "onDestroyUITask");
        this.onDestroyUITask = onDestroyUITask;
        this.mAction = new C1209b();
        this.mEventObserver = new LifecycleEventObserver() { // from class: com.tencent.guild.aio.reserve2.busi.banner.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                b.o(b.this, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent msgIntent) {
        if (msgIntent instanceof MFGestureListIntent.NotifyEvent) {
            m((MFGestureListIntent.NotifyEvent) msgIntent);
        }
    }

    private final void m(MFGestureListIntent.NotifyEvent notifyEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        i notifyData = notifyEvent.getNotifyData();
        boolean z26 = false;
        if (notifyData.f() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (notifyData.c() != notifyData.a()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (notifyData.c() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && (z17 || z18)) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            notifyData = null;
        }
        if (notifyData != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildOperationBannerVM", 4, "vm@" + hashCode() + MsgSummary.STR_COLON + notifyEvent.getNotifyData());
            }
            if (notifyData.c() == 1) {
                z26 = true;
            }
            if (z26) {
                n();
            }
            updateUI(new GuildOperationBannerUIState.AIOVisibilityChange(z26));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        if (this.isBannerInitialized) {
            return;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        Integer d16 = com.tencent.guild.aio.util.a.d(g16);
        if (d16 != null) {
            int intValue = d16.intValue();
            if (this.isInterestedChannelType) {
                AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                long parseLong = Long.parseLong(com.tencent.guild.aio.util.a.g(g17));
                AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                updateUI(new GuildOperationBannerUIState.InitBanner(parseLong, Long.parseLong(com.tencent.guild.aio.util.a.b(g18)), intValue));
                this.isBannerInitialized = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(b this$0, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int ordinal = event.ordinal();
        if (ordinal == Lifecycle.Event.ON_RESUME.ordinal()) {
            this$0.r();
        } else if (ordinal == Lifecycle.Event.ON_PAUSE.ordinal()) {
            this$0.q();
        } else if (ordinal == Lifecycle.Event.ON_DESTROY.ordinal()) {
            this$0.p(source);
        }
    }

    private final void p(LifecycleOwner source) {
        this.onDestroyUITask.invoke();
        source.getLifecycle().removeObserver(this.mEventObserver);
    }

    private final void q() {
        updateUI(new GuildOperationBannerUIState.AIOVisibilityChange(false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        boolean g16 = com.tencent.guild.aio.util.ex.a.g((com.tencent.aio.api.runtime.a) getMContext());
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildOperationBannerVM", 4, "vm@" + hashCode() + ": moveToResume, isInitialized=" + this.isBannerInitialized + ", isAioFullyOpen=" + g16);
        }
        if (g16) {
            n();
            updateUI(new GuildOperationBannerUIState.AIOVisibilityChange(true));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        if (this.isInterestedChannelType) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        if (!com.tencent.guild.aio.util.a.k(g16)) {
            AIOParam g17 = context.g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            Integer d16 = com.tencent.guild.aio.util.a.d(g17);
            if (d16 == null || d16.intValue() != 7) {
                z16 = false;
                this.isInterestedChannelType = z16;
                if (z16) {
                    return;
                }
                context.e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
                context.d().getLifecycle().addObserver(this.mEventObserver);
                if (com.tencent.guild.aio.util.ex.a.c(context) != ContainerType.MF_TYPE) {
                    n();
                    return;
                }
                return;
            }
        }
        z16 = true;
        this.isInterestedChannelType = z16;
        if (z16) {
        }
    }
}
