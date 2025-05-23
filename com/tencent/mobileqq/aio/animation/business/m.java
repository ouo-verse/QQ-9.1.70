package com.tencent.mobileqq.aio.animation.business;

import android.os.Handler;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.utils.ds;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0002#'B\u0007\u00a2\u0006\u0004\b8\u00109J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0002J$\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00050\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J.\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002JV\u0010#\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\fH\u0016J \u0010'\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010(R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00102R\u0014\u00106\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/m;", "Lcom/tencent/mobileqq/aio/animation/egg/c;", "", "Lcom/tencent/mobileqq/aio/animation/data/b;", "messageList", "", "Lcom/tencent/mobileqq/aio/animation/business/m$a;", "e", "msg", "", "j", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", "g", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "", "Lcom/tencent/mobileqq/aio/animation/config/e;", "f", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animContainer", "freqImages", "index", "i", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/os/Handler;", "uiHandler", "message", "delayTime", "isNewMsg", "Ljava/util/ArrayList;", "rulesMatched", "ruleIndex", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/animation/data/d;", "sessionInfo", "b", "Lcom/tencent/mobileqq/aio/animation/config/a;", "lastRule", "I", "lastRuleCount", "c", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animationContainer", "d", "backgroundAnimContainer", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "newMsgList", "getBizType", "()I", "bizType", "playScope", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class m implements com.tencent.mobileqq.aio.animation.egg.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.animation.config.a lastRule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int lastRuleCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOAnimationContainer animationContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOAnimationContainer backgroundAnimContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<com.tencent.mobileqq.aio.animation.data.b> newMsgList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/m$a;", "", "", "a", "J", "getMsgId", "()J", "c", "(J)V", "msgId", "Lcom/tencent/mobileqq/aio/animation/config/a;", "b", "Lcom/tencent/mobileqq/aio/animation/config/a;", "()Lcom/tencent/mobileqq/aio/animation/config/a;", "(Lcom/tencent/mobileqq/aio/animation/config/a;)V", "matchedRule", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.aio.animation.config.a matchedRule;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final com.tencent.mobileqq.aio.animation.config.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.aio.animation.config.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.matchedRule;
        }

        public final void b(@Nullable com.tencent.mobileqq.aio.animation.config.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            } else {
                this.matchedRule = aVar;
            }
        }

        public final void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.msgId = j3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/m$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.business.m$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29654);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.newMsgList = new LinkedList<>();
        }
    }

    private final List<a> e(List<? extends com.tencent.mobileqq.aio.animation.data.b> messageList) {
        boolean z16;
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mobileqq.aio.animation.data.b bVar : messageList) {
            if (!j(bVar)) {
                a aVar = new a();
                aVar.c(bVar.getMsgId());
                ArrayList<com.tencent.mobileqq.aio.animation.config.a> K = q.INSTANCE.a().K(bVar);
                if (K != null && !K.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    aVar.b(null);
                } else {
                    aVar.b(K.get(0));
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    private final Map<Integer, List<com.tencent.mobileqq.aio.animation.config.e>> f(com.tencent.mobileqq.aio.animation.config.a rule) {
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
        Intrinsics.checkNotNull(i3);
        TreeMap treeMap = new TreeMap();
        Iterator<com.tencent.mobileqq.aio.animation.config.e> it = i3.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.aio.animation.config.e image = it.next();
            String f16 = image.f();
            Intrinsics.checkNotNull(f16);
            int parseInt = Integer.parseInt(f16);
            List list = (List) treeMap.get(Integer.valueOf(parseInt));
            if (list == null) {
                list = new ArrayList();
            }
            Intrinsics.checkNotNullExpressionValue(image, "image");
            list.add(image);
            treeMap.put(Integer.valueOf(parseInt), list);
        }
        return treeMap;
    }

    private final synchronized void g(List<a> queue) {
        com.tencent.mobileqq.aio.animation.config.a a16;
        com.tencent.mobileqq.aio.animation.config.a aVar;
        int size = queue.size();
        if (size != 0) {
            int i3 = size - 1;
            if (queue.get(i3).a() != null) {
                com.tencent.mobileqq.aio.animation.config.a a17 = queue.get(i3).a();
                this.lastRule = a17;
                if (a17 == null) {
                    this.lastRuleCount = 0;
                    return;
                }
                this.lastRuleCount = 1;
                for (int i16 = size - 2; -1 < i16 && (a16 = queue.get(i16).a()) != null && (aVar = this.lastRule) != null; i16--) {
                    Intrinsics.checkNotNull(aVar);
                    if (aVar.h() != a16.h()) {
                        break;
                    }
                    this.lastRuleCount++;
                }
                return;
            }
        }
        this.lastRule = null;
        this.lastRuleCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(m this$0, AIOAnimationContainer animContainer, List list, int i3, com.tencent.mobileqq.aio.animation.config.a rule) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        this$0.i(animContainer, list, i3, rule);
    }

    private final void i(AIOAnimationContainer animContainer, List<com.tencent.mobileqq.aio.animation.config.e> freqImages, int index, com.tencent.mobileqq.aio.animation.config.a rule) {
        if (animContainer.k() == null) {
            QLog.i("LevelEggsPlayer", 1, "[playAnimation], list view is null");
            return;
        }
        com.tencent.mobileqq.aio.animation.config.e eVar = freqImages.get(index);
        if (Intrinsics.areEqual("true", eVar.c())) {
            ViewParent parent = animContainer.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) parent;
            if (this.backgroundAnimContainer == null) {
                this.backgroundAnimContainer = new AIOAnimationContainer(animContainer.getContext(), null, 2, null);
                relativeLayout.addView(this.backgroundAnimContainer, 0, new RelativeLayout.LayoutParams(-1, -1));
            }
            AIOAnimationContainer aIOAnimationContainer = this.backgroundAnimContainer;
            Intrinsics.checkNotNull(aIOAnimationContainer);
            com.tencent.mobileqq.aio.animation.data.a k3 = animContainer.k();
            Intrinsics.checkNotNull(k3);
            aIOAnimationContainer.d(k3);
            animContainer = aIOAnimationContainer;
        }
        animContainer.m(9, 400, eVar, rule);
    }

    private final boolean j(com.tencent.mobileqq.aio.animation.data.b msg2) {
        return !msg2.d();
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void a(@NotNull BaseQQAppInterface app, @NotNull Handler uiHandler, @NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull final AIOAnimationContainer animContainer, int delayTime, @NotNull final com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, @NotNull ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int ruleIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, app, uiHandler, message, animContainer, Integer.valueOf(delayTime), rule, Boolean.valueOf(isNewMsg), rulesMatched, Integer.valueOf(ruleIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(rulesMatched, "rulesMatched");
        if (!isNewMsg && ruleIndex != rulesMatched.size() - 1) {
            QLog.d("LevelEggsPlayer", 1, "[play] process unread, not the last one, continue.");
            return;
        }
        if (!rule.s()) {
            QLog.i("LevelEggsPlayer", 1, "[play] time is invalid, time is not in " + rule.q() + "-" + rule.e());
            return;
        }
        this.animationContainer = animContainer;
        Map<Integer, List<com.tencent.mobileqq.aio.animation.config.e>> f16 = f(rule);
        Iterator<Integer> it = f16.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 = Math.max(i3, it.next().intValue());
        }
        int i16 = this.lastRuleCount;
        if (i16 < i3) {
            i3 = i16;
        }
        final List<com.tencent.mobileqq.aio.animation.config.e> list = f16.get(Integer.valueOf(i3));
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            final int d16 = ds.d(0, size);
            QLog.d("LevelEggsPlayer", 1, "[play] size: ", Integer.valueOf(size), " index: ", Integer.valueOf(d16));
            uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.h(m.this, animContainer, list, d16, rule);
                }
            });
            return;
        }
        QLog.i("LevelEggsPlayer", 1, "[play] image invalid. id: " + rule.h() + ", freq: " + this.lastRuleCount);
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void b(@NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull BaseQQAppInterface app, @NotNull com.tencent.mobileqq.aio.animation.data.d sessionInfo) {
        List<a> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, message, app, sessionInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        synchronized (this.newMsgList) {
            this.newMsgList.addLast(message);
            while (this.newMsgList.size() > 10) {
                this.newMsgList.removeFirst();
            }
            e16 = e(this.newMsgList);
            Unit unit = Unit.INSTANCE;
        }
        while (e16.size() > 10) {
            e16.remove(0);
        }
        g(e16);
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public int getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.lastRuleCount = 0;
        this.lastRule = null;
        AIOAnimationContainer aIOAnimationContainer = this.backgroundAnimContainer;
        if (aIOAnimationContainer != null) {
            aIOAnimationContainer.o();
            aIOAnimationContainer.removeAllViews();
            aIOAnimationContainer.h();
        }
        this.backgroundAnimContainer = null;
        AIOAnimationContainer aIOAnimationContainer2 = this.animationContainer;
        if (aIOAnimationContainer2 != null) {
            aIOAnimationContainer2.o();
        }
        this.animationContainer = null;
    }
}
