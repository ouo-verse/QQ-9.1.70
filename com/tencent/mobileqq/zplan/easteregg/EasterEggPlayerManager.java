package com.tencent.mobileqq.zplan.easteregg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IZplanOutboundAvatar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.easteregg.EasterEggPlayerManager;
import com.tencent.mobileqq.zplan.easteregg.manager.GetPagResourceTask;
import com.tencent.mobileqq.zplan.easteregg.manager.IEasterEggResourceTaskResult;
import com.tencent.mobileqq.zplan.easteregg.report.EasterEggDaTongReport;
import com.tencent.mobileqq.zplan.easteregg.u;
import com.tencent.mobileqq.zplan.easteregg.v;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\"\u0010\u0018\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001a\u0010 \u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J$\u0010.\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0016H\u0016J\u0012\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0016R\u001e\u00107\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00106R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00109R\u0014\u0010;\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010\u001eR\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001eR\u0014\u0010?\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010\u001e\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/EasterEggPlayerManager;", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "nextTask", "", "D", "task", "", BasicAnimation.KeyPath.SCALE_X, "Lcom/tencent/mobileqq/zplan/easteregg/v$b;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zplan/easteregg/v;", "player", "", "path", "", "index", "H", "w", "v", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "res", "", "gap", UserInfo.SEX_FEMALE, "", NodeProps.VISIBLE, "K", "G", "pagView", "J", "type", "B", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "M", "Lcom/tencent/mobileqq/zplan/easteregg/a;", DownloadInfo.spKey_Config, "I", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "y", "b", "seq", "stop", "Lcom/tencent/mobileqq/zplan/easteregg/w$a;", "statusListener", "c", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mStatusListener", "Lcom/tencent/mobileqq/zplan/easteregg/s;", "Lcom/tencent/mobileqq/zplan/easteregg/s;", "playManagerHelper", "playMaxWaitTime", "d", "startTime", "e", "defaultAnimateDuration", "<init>", "()V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EasterEggPlayerManager implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<w.a> mStatusListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private s<com.tencent.mobileqq.zplan.easteregg.model.c> playManagerHelper = new s<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long playMaxWaitTime = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getEasterEggPlayTimeOutGap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long defaultAnimateDuration = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getEasterEggShowAvatarAnimateDuration();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/EasterEggPlayerManager$a", "Lcom/tencent/mobileqq/zplan/easteregg/y;", "Lcom/tencent/mobileqq/zplan/easteregg/model/f;", "task", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements y {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.y
        public void a(com.tencent.mobileqq.zplan.easteregg.model.f task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (task instanceof com.tencent.mobileqq.zplan.easteregg.model.c) {
                EasterEggPlayerManager.this.D((com.tencent.mobileqq.zplan.easteregg.model.c) task);
            }
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.y
        public void b(com.tencent.mobileqq.zplan.easteregg.model.f task) {
            v vVar;
            v vVar2;
            v vVar3;
            Intrinsics.checkNotNullParameter(task, "task");
            if (task instanceof com.tencent.mobileqq.zplan.easteregg.model.c) {
                com.tencent.mobileqq.zplan.easteregg.model.c cVar = (com.tencent.mobileqq.zplan.easteregg.model.c) task;
                cVar.C(false);
                mqq.util.WeakReference<v> f16 = cVar.f();
                if (f16 != null && (vVar3 = f16.get()) != null) {
                    vVar3.stop();
                }
                mqq.util.WeakReference<v> d16 = cVar.d();
                if (d16 != null && (vVar2 = d16.get()) != null) {
                    vVar2.stop();
                }
                mqq.util.WeakReference<v> j3 = cVar.j();
                if (j3 != null && (vVar = j3.get()) != null) {
                    vVar.stop();
                }
                EasterEggPlayerManager.this.K(cVar, false);
                EasterEggPlayerManager.this.M(cVar);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/EasterEggPlayerManager$d", "Lcom/tencent/mobileqq/zplan/easteregg/v$a;", "", "duration", "", "onStart", "onEnd", "onRelease", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements v.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.model.c f332840a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EasterEggPlayerManager f332841b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f332842c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f332843d;

        d(com.tencent.mobileqq.zplan.easteregg.model.c cVar, EasterEggPlayerManager easterEggPlayerManager, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2) {
            this.f332840a = cVar;
            this.f332841b = easterEggPlayerManager;
            this.f332842c = booleanRef;
            this.f332843d = booleanRef2;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.v.a
        public void onEnd() {
            w.a aVar;
            QLog.i("EasterEggPlayerManager", 1, "avatarAnimationView onEnd\uff1a " + this.f332840a.getSeq());
            WeakReference weakReference = this.f332841b.mStatusListener;
            if (weakReference != null && (aVar = (w.a) weakReference.get()) != null) {
                aVar.d(Long.valueOf(this.f332840a.getSeq()));
            }
            this.f332841b.K(this.f332840a, false);
            this.f332841b.M(this.f332840a);
            this.f332841b.G(this.f332840a);
            this.f332841b.playManagerHelper.f(this.f332840a);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.v.a
        public void onError() {
            w.a aVar;
            QLog.i("EasterEggPlayerManager", 1, "avatarAnimationView onError\uff1a " + this.f332840a.getSeq());
            WeakReference weakReference = this.f332841b.mStatusListener;
            if (weakReference != null && (aVar = (w.a) weakReference.get()) != null) {
                aVar.c(Long.valueOf(this.f332840a.getSeq()), 0);
            }
            this.f332841b.K(this.f332840a, false);
            this.f332841b.M(this.f332840a);
            this.f332841b.G(this.f332840a);
            this.f332841b.playManagerHelper.f(this.f332840a);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.v.a
        public void onRelease() {
            w.a aVar;
            QLog.i("EasterEggPlayerManager", 1, "avatarAnimationView onRelease\uff1a " + this.f332840a.getSeq());
            WeakReference weakReference = this.f332841b.mStatusListener;
            if (weakReference == null || (aVar = (w.a) weakReference.get()) == null) {
                return;
            }
            aVar.b(Long.valueOf(this.f332840a.getSeq()));
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.v.a
        public void onStart(long duration) {
            w.a aVar;
            QLog.i("EasterEggPlayerManager", 1, "avatarAnimationView onStart\uff1a " + this.f332840a.getSeq());
            WeakReference weakReference = this.f332841b.mStatusListener;
            if (weakReference != null && (aVar = (w.a) weakReference.get()) != null) {
                aVar.a(Long.valueOf(this.f332840a.getSeq()));
            }
            EasterEggPlayerManager easterEggPlayerManager = this.f332841b;
            mqq.util.WeakReference<v> f16 = this.f332840a.f();
            easterEggPlayerManager.J(f16 != null ? f16.get() : null, true);
            EasterEggPlayerManager easterEggPlayerManager2 = this.f332841b;
            mqq.util.WeakReference<v> d16 = this.f332840a.d();
            easterEggPlayerManager2.J(d16 != null ? d16.get() : null, this.f332842c.element);
            EasterEggPlayerManager easterEggPlayerManager3 = this.f332841b;
            mqq.util.WeakReference<v> j3 = this.f332840a.j();
            easterEggPlayerManager3.J(j3 != null ? j3.get() : null, this.f332843d.element);
            this.f332841b.z(this.f332840a, duration);
        }
    }

    public EasterEggPlayerManager() {
        this.playManagerHelper.g(new a());
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(Drawable drawable, long j3) {
        if (drawable instanceof IZplanOutboundAvatar) {
            ((IZplanOutboundAvatar) drawable).hideZplanAvatar(j3);
            return;
        }
        QLog.e("EasterEggPlayerManager", 1, "try hide avatar before easter egg failed, avatarHeadDrawable null: " + (drawable == 0) + ", if false then not IZplanOutboundAvatar!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(com.tencent.mobileqq.zplan.easteregg.model.c task, int type) {
        w.a aVar;
        QLog.i("EasterEggPlayerManager", 1, "onPlayStatusError, " + type);
        WeakReference<w.a> weakReference = this.mStatusListener;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.c(task != null ? Long.valueOf(task.getSeq()) : null, type);
        }
        if (task != null) {
            this.playManagerHelper.f(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(EasterEggPlayerManager this$0, com.tencent.mobileqq.zplan.easteregg.model.c task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "$task");
        this$0.playManagerHelper.c(task, task.getInterrupt());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (Intrinsics.areEqual(task.getUin(), peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null)) {
            this$0.I(task.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(final com.tencent.mobileqq.zplan.easteregg.model.c nextTask) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.q
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.E(com.tencent.mobileqq.zplan.easteregg.model.c.this, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(com.tencent.mobileqq.zplan.easteregg.model.c nextTask, EasterEggPlayerManager this$0) {
        Intrinsics.checkNotNullParameter(nextTask, "$nextTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.easteregg.manager.c cVar = new com.tencent.mobileqq.zplan.easteregg.manager.c(nextTask);
        cVar.c(new GetPagResourceTask());
        cVar.c(new com.tencent.mobileqq.zplan.easteregg.manager.e());
        cVar.c(new com.tencent.mobileqq.zplan.easteregg.manager.d());
        cVar.e(new c(nextTask));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void L(v vVar, int i3) {
        View view = vVar instanceof View ? (View) vVar : null;
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(com.tencent.mobileqq.zplan.easteregg.model.c task) {
        final Drawable avatarDrawable;
        ImageView imageView;
        mqq.util.WeakReference<ImageView> h16 = task.h();
        if (h16 == null || (imageView = h16.get()) == null || (avatarDrawable = imageView.getDrawable()) == null) {
            avatarDrawable = task.getAvatarDrawable();
        }
        long seq = task.getSeq();
        mqq.util.WeakReference<ImageView> h17 = task.h();
        QLog.i("EasterEggPlayerManager", 1, "showZPlanAvatar:  " + seq + ",  " + (h17 != null ? h17.get() : null) + ", " + avatarDrawable);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.p
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.N(avatarDrawable, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N(Drawable drawable, EasterEggPlayerManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (drawable instanceof IZplanOutboundAvatar) {
            ((IZplanOutboundAvatar) drawable).showZplanAvatar(this$0.defaultAnimateDuration);
            return;
        }
        QLog.e("EasterEggPlayerManager", 1, "try show avatar before easter egg failed, avatarHeadDrawable null: " + (drawable == 0) + ", if false then not IZplanOutboundAvatar!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(EasterEggPlayerManager this$0, long j3) {
        v vVar;
        v vVar2;
        v vVar3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.easteregg.model.c a16 = this$0.playManagerHelper.a(j3);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("EasterEggPlayerManager", 2, "stop : " + j3);
                return;
            }
            return;
        }
        this$0.playManagerHelper.f(a16);
        a16.C(false);
        mqq.util.WeakReference<v> f16 = a16.f();
        if (f16 != null && (vVar3 = f16.get()) != null) {
            vVar3.stop();
        }
        mqq.util.WeakReference<v> d16 = a16.d();
        if (d16 != null && (vVar2 = d16.get()) != null) {
            vVar2.stop();
        }
        mqq.util.WeakReference<v> j16 = a16.j();
        if (j16 != null && (vVar = j16.get()) != null) {
            vVar.stop();
        }
        this$0.K(a16, false);
        this$0.M(a16);
    }

    private final int v(com.tencent.mobileqq.zplan.easteregg.model.c task) {
        com.tencent.mobileqq.zplan.easteregg.a aVar = task.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (aVar == null || aVar.getAvatarBackgroundLayer() == null) {
            return -1;
        }
        Integer avatarBackgroundLayer = aVar.getAvatarBackgroundLayer();
        Intrinsics.checkNotNull(avatarBackgroundLayer);
        if (avatarBackgroundLayer.intValue() < 0) {
            return -1;
        }
        Integer avatarBackgroundLayer2 = aVar.getAvatarBackgroundLayer();
        Intrinsics.checkNotNull(avatarBackgroundLayer2);
        return avatarBackgroundLayer2.intValue();
    }

    private final int w(com.tencent.mobileqq.zplan.easteregg.model.c task) {
        com.tencent.mobileqq.zplan.easteregg.a aVar = task.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (aVar == null || aVar.getAvatarCharacterLayer() == null) {
            return -2;
        }
        Integer avatarCharacterLayer = aVar.getAvatarCharacterLayer();
        Intrinsics.checkNotNull(avatarCharacterLayer);
        if (avatarCharacterLayer.intValue() < 0) {
            return -2;
        }
        Integer avatarCharacterLayer2 = aVar.getAvatarCharacterLayer();
        Intrinsics.checkNotNull(avatarCharacterLayer2);
        return avatarCharacterLayer2.intValue();
    }

    private final v.b x(com.tencent.mobileqq.zplan.easteregg.model.c task, float scaleX) {
        v.b bVar = new v.b();
        bVar.f333094a = false;
        com.tencent.mobileqq.zplan.easteregg.a aVar = task.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        bVar.f333095b = aVar != null ? aVar.getRepeatCount() : 1;
        bVar.f333096c = 0L;
        bVar.f333098e = scaleX;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(com.tencent.mobileqq.zplan.easteregg.model.c task, final long duration) {
        final Drawable avatarDrawable;
        ImageView imageView;
        if (!ZPlanFeatureSwitch.f369852a.E()) {
            QLog.w("EasterEggPlayerManager", 1, "hide zplan avatar not allowed, play easter egg directly.");
            return;
        }
        mqq.util.WeakReference<ImageView> h16 = task.h();
        if (h16 == null || (imageView = h16.get()) == null || (avatarDrawable = imageView.getDrawable()) == null) {
            avatarDrawable = task.getAvatarDrawable();
        }
        long seq = task.getSeq();
        mqq.util.WeakReference<ImageView> h17 = task.h();
        QLog.i("EasterEggPlayerManager", 1, "hideZPlanAvatar: " + seq + ", " + (h17 != null ? h17.get() : null) + ", " + avatarDrawable + ", " + duration);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.l
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.A(avatarDrawable, duration);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.w
    public void b(final com.tencent.mobileqq.zplan.easteregg.model.c task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.o
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.C(EasterEggPlayerManager.this, task);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.w
    public void stop(final long seq) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.n
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.O(EasterEggPlayerManager.this, seq);
            }
        }, 16, null, true);
    }

    public View y(Context context, AttributeSet attrs, int defStyleAttr) {
        View playerView = new EasterEggPlayer(context, attrs, defStyleAttr).getPlayerView();
        Intrinsics.checkNotNullExpressionValue(playerView, "EasterEggPlayer(context,\u2026 defStyleAttr).playerView");
        return playerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(com.tencent.mobileqq.zplan.easteregg.model.c task) {
        mqq.util.WeakReference<v> j3;
        mqq.util.WeakReference<v> f16;
        mqq.util.WeakReference<v> d16;
        mqq.util.WeakReference<v> j16;
        mqq.util.WeakReference<v> f17;
        mqq.util.WeakReference<v> d17;
        mqq.util.WeakReference<v> j17;
        mqq.util.WeakReference<v> f18;
        mqq.util.WeakReference<v> d18;
        QLog.e("EasterEggPlayerManager", 1, "releasePagView View.GONE release");
        v vVar = (task == null || (d18 = task.d()) == null) ? null : d18.get();
        EasterEggPagPlayer easterEggPagPlayer = vVar instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) vVar : null;
        if (easterEggPagPlayer != null) {
            easterEggPagPlayer.stop();
        }
        v vVar2 = (task == null || (f18 = task.f()) == null) ? null : f18.get();
        EasterEggPagPlayer easterEggPagPlayer2 = vVar2 instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) vVar2 : null;
        if (easterEggPagPlayer2 != null) {
            easterEggPagPlayer2.stop();
        }
        v vVar3 = (task == null || (j17 = task.j()) == null) ? null : j17.get();
        EasterEggPagPlayer easterEggPagPlayer3 = vVar3 instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) vVar3 : null;
        if (easterEggPagPlayer3 != null) {
            easterEggPagPlayer3.stop();
        }
        v vVar4 = (task == null || (d17 = task.d()) == null) ? null : d17.get();
        EasterEggPagPlayer easterEggPagPlayer4 = vVar4 instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) vVar4 : null;
        if (easterEggPagPlayer4 != null) {
            easterEggPagPlayer4.w();
        }
        v vVar5 = (task == null || (f17 = task.f()) == null) ? null : f17.get();
        EasterEggPagPlayer easterEggPagPlayer5 = vVar5 instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) vVar5 : null;
        if (easterEggPagPlayer5 != null) {
            easterEggPagPlayer5.w();
        }
        Object obj = (task == null || (j16 = task.j()) == null) ? null : (v) j16.get();
        EasterEggPagPlayer easterEggPagPlayer6 = obj instanceof EasterEggPagPlayer ? (EasterEggPagPlayer) obj : null;
        if (easterEggPagPlayer6 != null) {
            easterEggPagPlayer6.w();
        }
        if (task != null && (d16 = task.d()) != null) {
            d16.clear();
        }
        if (task != null && (f16 = task.f()) != null) {
            f16.clear();
        }
        if (task == null || (j3 = task.j()) == null) {
            return;
        }
        j3.clear();
    }

    private final void I(com.tencent.mobileqq.zplan.easteregg.a config) {
        if (config == null) {
            QLog.e("EasterEggPlayerManager", 1, "reportEasterEggPlaySuccess failed, config is null.");
        } else if (!config.getEnableReport()) {
            QLog.i("EasterEggPlayerManager", 1, "reportEasterEggPlaySuccess failed, config enableReport false.");
        } else {
            com.tencent.mobileqq.zplan.servlet.i.f335409a.d(config.getPortraitName());
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.w
    public View a(Context context) {
        return y(context, null, 0);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.w
    public void c(w.a statusListener) {
        if (statusListener != null) {
            this.mStatusListener = new WeakReference<>(statusListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(com.tencent.mobileqq.zplan.easteregg.model.c task, IEasterEggResourceTaskResult res, long gap) {
        v vVar;
        Boolean bool;
        v vVar2;
        v vVar3;
        Boolean bool2;
        v vVar4;
        v vVar5;
        if (task == null) {
            return;
        }
        QLog.d("EasterEggPlayerManager", 1, "realAnimationPlay: " + task.getSeq());
        if (!task.getNeedPlay()) {
            QLog.d("EasterEggPlayerManager", 1, "realAnimationPlay not need play: " + task.getSeq());
            return;
        }
        if (TextUtils.isEmpty(res.getAvatarPagAnimationPath())) {
            QLog.i("EasterEggPlayerManager", 1, "realAnimationPlay avatarPagAnimationPath is empty");
            K(task, false);
            B(task, 7);
            return;
        }
        u.EasterEggReportParam reportParam = task.getReportParam();
        if (reportParam != null) {
            reportParam.h(res.getPortraitSource() == PortraitSource.RECORD);
            reportParam.i(gap);
            new EasterEggDaTongReport().f(reportParam);
        }
        K(task, false);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (!TextUtils.isEmpty(res.getAtmospherePagAnimationPath())) {
            mqq.util.WeakReference<v> d16 = task.d();
            Boolean valueOf = (d16 == null || (vVar5 = d16.get()) == null) ? null : Boolean.valueOf(vVar5.prepare(res.getAtmospherePagAnimationPath()));
            Boolean bool3 = Boolean.TRUE;
            if (Intrinsics.areEqual(valueOf, bool3)) {
                mqq.util.WeakReference<v> d17 = task.d();
                bool2 = (d17 == null || (vVar4 = d17.get()) == null) ? null : Boolean.valueOf(vVar4.a(x(task, task.getAtmosphereScale())));
            } else {
                bool2 = Boolean.FALSE;
            }
            booleanRef.element = Intrinsics.areEqual(valueOf, bool3) && Intrinsics.areEqual(bool2, bool3);
        }
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        if (!TextUtils.isEmpty(res.getFullScreenPagAnimationPath())) {
            mqq.util.WeakReference<v> j3 = task.j();
            Boolean valueOf2 = (j3 == null || (vVar3 = j3.get()) == null) ? null : Boolean.valueOf(vVar3.prepare(res.getFullScreenPagAnimationPath()));
            Boolean bool4 = Boolean.TRUE;
            if (Intrinsics.areEqual(valueOf2, bool4)) {
                mqq.util.WeakReference<v> j16 = task.j();
                bool = (j16 == null || (vVar2 = j16.get()) == null) ? null : Boolean.valueOf(vVar2.a(x(task, 1.0f)));
            } else {
                bool = Boolean.FALSE;
            }
            booleanRef2.element = Intrinsics.areEqual(valueOf2, bool4) && Intrinsics.areEqual(bool, bool4);
        }
        mqq.util.WeakReference<v> f16 = task.f();
        if (f16 != null && (vVar = f16.get()) != null) {
            vVar.setStatusListener(new d(task, this, booleanRef, booleanRef2));
        }
        mqq.util.WeakReference<v> f17 = task.f();
        v vVar6 = f17 != null ? f17.get() : null;
        if (Intrinsics.areEqual(vVar6 != null ? Boolean.valueOf(vVar6.prepare(res.getAvatarPagAnimationPath())) : null, Boolean.TRUE)) {
            H(vVar6, res.getPortraitHeadPath(), w(task));
            H(vVar6, res.getBackgroundResourcePath(), v(task));
            vVar6.a(x(task, task.getAvatarScale()));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/EasterEggPlayerManager$c", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "", "code", "res", "", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.easteregg.manager.g<IEasterEggResourceTaskResult> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.model.c f332839b;

        c(com.tencent.mobileqq.zplan.easteregg.model.c cVar) {
            this.f332839b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(EasterEggPlayerManager this$0, com.tencent.mobileqq.zplan.easteregg.model.c nextTask, IEasterEggResourceTaskResult iEasterEggResourceTaskResult, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(nextTask, "$nextTask");
            this$0.F(nextTask, iEasterEggResourceTaskResult, j3);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.manager.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(int code, final IEasterEggResourceTaskResult res) {
            QLog.i("EasterEggPlayerManager", 1, "playNext : " + code);
            if (res == null) {
                EasterEggPlayerManager.this.B(this.f332839b, code);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - EasterEggPlayerManager.this.startTime;
            final long currentTimeMillis2 = System.currentTimeMillis() - this.f332839b.getTimestamp();
            if (currentTimeMillis < 1000) {
                final EasterEggPlayerManager easterEggPlayerManager = EasterEggPlayerManager.this;
                final com.tencent.mobileqq.zplan.easteregg.model.c cVar = this.f332839b;
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        EasterEggPlayerManager.c.d(EasterEggPlayerManager.this, cVar, res, currentTimeMillis2);
                    }
                }, 16, null, true, 1000 - currentTimeMillis2);
            } else if (currentTimeMillis2 > EasterEggPlayerManager.this.playMaxWaitTime) {
                EasterEggPlayerManager.this.B(this.f332839b, 8);
            } else {
                EasterEggPlayerManager.this.F(this.f332839b, res, currentTimeMillis2);
            }
        }
    }

    private final void H(v player, String path, int index) {
        if (player == null || path == null) {
            return;
        }
        Bitmap d16 = com.tencent.mobileqq.zplan.cc.util.c.d(path, 1);
        HashMap hashMap = new HashMap();
        if (d16 == null) {
            return;
        }
        hashMap.put(Integer.valueOf(index), d16);
        player.c(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void J(final v pagView, boolean visible) {
        final int i3 = visible ? 0 : 8;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            View view = pagView instanceof View ? (View) pagView : null;
            if (view == null) {
                return;
            }
            view.setVisibility(i3);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.m
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPlayerManager.L(v.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final com.tencent.mobileqq.zplan.easteregg.model.c task, boolean visible) {
        final int i3 = visible ? 0 : 8;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.EasterEggPlayerManager$setPagViewVisible$1
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
                mqq.util.WeakReference<v> j3;
                mqq.util.WeakReference<v> f16;
                mqq.util.WeakReference<v> d16;
                com.tencent.mobileqq.zplan.easteregg.model.c cVar = com.tencent.mobileqq.zplan.easteregg.model.c.this;
                Object obj = (cVar == null || (d16 = cVar.d()) == null) ? null : (v) d16.get();
                View view = obj instanceof View ? (View) obj : null;
                if (view != null) {
                    view.setVisibility(i3);
                }
                com.tencent.mobileqq.zplan.easteregg.model.c cVar2 = com.tencent.mobileqq.zplan.easteregg.model.c.this;
                Object obj2 = (cVar2 == null || (f16 = cVar2.f()) == null) ? null : (v) f16.get();
                View view2 = obj2 instanceof View ? (View) obj2 : null;
                if (view2 != null) {
                    view2.setVisibility(i3);
                }
                com.tencent.mobileqq.zplan.easteregg.model.c cVar3 = com.tencent.mobileqq.zplan.easteregg.model.c.this;
                Object obj3 = (cVar3 == null || (j3 = cVar3.j()) == null) ? null : (v) j3.get();
                View view3 = obj3 instanceof View ? (View) obj3 : null;
                if (view3 == null) {
                    return;
                }
                view3.setVisibility(i3);
            }
        });
    }
}
