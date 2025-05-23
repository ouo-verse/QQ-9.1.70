package bo0;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aio.api.list.o;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0019\u0018\u0000 \u001e2\u00020\u0001:\u0001\tB\u001b\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lbo0/a;", "Lcom/tencent/aio/api/list/o$a;", "Landroid/content/Context;", "context", "", "e", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aio/api/list/o;", DTConstants.TAG.API, "b", "c", "f", "", "g", "Lkotlin/Function1;", "Lat/b;", "Lkotlin/jvm/functions/Function1;", "sendIntent", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "scanningLightView", "bo0/a$b", "Lbo0/a$b;", "uiHandler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements o.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<at.b, Unit> sendIntent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScanningLightView scanningLightView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lbo0/a$a;", "", "", "skeletonStartTime", "", "a", "", "HANDLE_WHAT_SHOW_SKELETON", "I", "HANDLE_WHAT_SKELETON_LAST_TIME", "SHOW_DELAY", "J", "SHOW_LAST_TIME", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bo0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(long skeletonStartTime) {
            if (System.currentTimeMillis() - skeletonStartTime < 1000) {
                QLog.i("GuildSkeletonHolder", 1, "shouldDelayHide");
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"bo0/a$b", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends MqqHandler {
        b(Looper looper) {
            super(looper);
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            WeakReference weakReference;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 101) {
                if (i3 == 102) {
                    QLog.i("GuildSkeletonHolder", 1, "handleMessage: SkeletonLastEnoughTime");
                    a.this.sendIntent.invoke(a.v.f110490d);
                    return;
                }
                return;
            }
            QLog.i("GuildSkeletonHolder", 1, "handleMessage: showSkeleton");
            Object obj = msg2.obj;
            if (obj instanceof WeakReference) {
                o oVar = null;
                if (obj instanceof WeakReference) {
                    weakReference = (WeakReference) obj;
                } else {
                    weakReference = null;
                }
                if (weakReference != null) {
                    oVar = (o) weakReference.get();
                }
                if (oVar != null) {
                    Object obj2 = msg2.obj;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.ref.WeakReference<com.tencent.aio.api.list.ISkeletonApi>");
                    o oVar2 = (o) ((WeakReference) obj2).get();
                    if (oVar2 != null) {
                        a.this.f(oVar2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super at.b, Unit> sendIntent) {
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        this.sendIntent = sendIntent;
        this.uiHandler = new b(Looper.getMainLooper());
    }

    private final int e(Context context) {
        return GuildUIUtils.f235378a.E(context.getColor(R.color.qui_common_bg_middle_light), 0.5f);
    }

    @Override // com.tencent.aio.api.list.o.a
    public void a() {
        QLog.i("GuildSkeletonHolder", 1, "onReset");
        this.uiHandler.removeMessages(102);
    }

    @Override // com.tencent.aio.api.list.o.a
    public void b(@NotNull View rootView, @NotNull o api) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(api, "api");
        QLog.i("GuildSkeletonHolder", 1, "preHide");
        ScanningLightView scanningLightView = this.scanningLightView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(8);
        }
        api.o();
        this.sendIntent.invoke(a.u.f110489d);
    }

    @Override // com.tencent.aio.api.list.o.a
    public void c(@NotNull View rootView, @NotNull o api) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(api, "api");
        QLog.i("GuildSkeletonHolder", 1, "preShow");
        if (!this.uiHandler.hasMessages(101)) {
            Message message = new Message();
            message.what = 101;
            message.obj = new WeakReference(api);
            this.uiHandler.sendMessageDelayed(message, 50L);
        }
    }

    @Override // com.tencent.aio.api.list.o.a
    @NotNull
    public View createView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
        scanningLightView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scanningLightView.setImageResource(R.drawable.guild_aio_skeleton_bg);
        scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
        if (UIUtil.f112434a.A()) {
            ScanningLightView.setLightColor$default(scanningLightView, e(context), 0, 2, null);
        } else {
            scanningLightView.setLightColorRes(R.color.qui_common_fill_light_secondary);
        }
        this.scanningLightView = scanningLightView;
        Intrinsics.checkNotNull(scanningLightView);
        return scanningLightView;
    }

    public final void f(@NotNull o api) {
        Intrinsics.checkNotNullParameter(api, "api");
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("GuildSkeletonHolder", 1, "handleShowSkeletonMsg, startTime: " + currentTimeMillis);
        this.sendIntent.invoke(new a.SkeletonShow(currentTimeMillis));
        api.r();
        ScanningLightView scanningLightView = this.scanningLightView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
        if (!this.uiHandler.hasMessages(102)) {
            Message message = new Message();
            message.what = 102;
            message.obj = new WeakReference(api);
            this.uiHandler.sendMessageDelayed(message, 1000L);
        }
    }

    public final boolean g() {
        ScanningLightView scanningLightView = this.scanningLightView;
        if (scanningLightView == null || scanningLightView.getVisibility() != 0 || scanningLightView.getParent() == null) {
            return false;
        }
        return true;
    }
}
