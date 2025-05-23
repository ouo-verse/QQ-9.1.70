package com.tencent.mobileqq.activity.home.parts;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.o;
import com.tencent.qqnt.bus.event.p;
import com.tencent.qqnt.bus.event.q;
import com.tencent.qqnt.bus.event.r;
import com.tencent.qqnt.bus.event.s;
import com.tencent.qqnt.bus.event.t;
import com.tencent.qqnt.bus.event.u;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u001bH\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001b0.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/activity/home/parts/c;", "Lcom/tencent/qqnt/chats/biz/main/part/a;", "Lzv3/c;", "", "ia", LocaleUtils.L_JAPANESE, "Z9", "Lcom/tencent/mobileqq/mutualmark/nt/c;", "event", "ea", "Lcom/tencent/qqnt/bus/event/u;", "ga", "Lcom/tencent/qqnt/bus/event/o;", "Y9", "Lcom/tencent/qqnt/bus/event/q;", "aa", "Lcom/tencent/qqnt/bus/event/r;", "ba", "Lcom/tencent/qqnt/bus/event/t;", "da", "ca", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lzv3/a;", "B5", "Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;", "f", "Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;", "getParamGetter", "()Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;", "paramGetter", "Lcom/tencent/qqnt/chats/biz/main/part/c;", h.F, "Lcom/tencent/qqnt/chats/biz/main/part/c;", "getChatPart", "()Lcom/tencent/qqnt/chats/biz/main/part/c;", "chatPart", "Lcom/tencent/qqnt/bus/api/IBusManager;", "i", "Lcom/tencent/qqnt/bus/api/IBusManager;", "busManager", "", "Ljava/lang/Class;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[Ljava/lang/Class;", "eventList", "<init>", "(Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;Lcom/tencent/qqnt/chats/biz/main/part/c;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.qqnt.chats.biz.main.part.a implements zv3.c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.home.chats.callbcak.a paramGetter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.biz.main.part.c chatPart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IBusManager busManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends zv3.a>[] eventList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/parts/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.parts.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull com.tencent.mobileqq.activity.home.chats.callbcak.a paramGetter, @NotNull com.tencent.qqnt.chats.biz.main.part.c chatPart) {
        Intrinsics.checkNotNullParameter(paramGetter, "paramGetter");
        Intrinsics.checkNotNullParameter(chatPart, "chatPart");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) paramGetter, (Object) chatPart);
            return;
        }
        this.paramGetter = paramGetter;
        this.chatPart = chatPart;
        QRouteApi api = QRoute.api(IBusManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBusManager::class.java)");
        this.busManager = (IBusManager) api;
        this.eventList = new Class[]{o.class, com.tencent.mobileqq.mutualmark.nt.c.class, u.class, p.class, q.class, r.class, t.class, s.class};
    }

    private final void Y9(o event) {
        this.chatPart.X9().Z(event.a(), j.f354601a);
    }

    private final void Z9() {
        this.chatPart.X9().Y(j.f354601a);
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "[handleMarkUpdateEvent] call");
        }
    }

    private final void aa(q event) {
        this.chatPart.X9().Z(event.a(), j.f354601a);
    }

    private final void ba(r event) {
        this.chatPart.X9().Z(event.d(), j.f354601a);
    }

    private final void ca() {
        this.chatPart.X9().Y(j.f354601a);
    }

    private final void da(t event) {
        this.chatPart.X9().Z(event.a(), j.f354601a);
    }

    private final void ea(com.tencent.mobileqq.mutualmark.nt.c event) {
        this.chatPart.X9().b0(event.a(), j.f354601a);
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "[MutualMarkMultiEvent]size=" + event.a().size());
        }
    }

    private final void ga(u event) {
        this.chatPart.X9().c0(event.a(), j.f354601a);
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "[MutualMarkMultiEvent]size=" + event.a().size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(zv3.a event, c this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (event instanceof com.tencent.mobileqq.mutualmark.nt.c) {
            this$0.ea((com.tencent.mobileqq.mutualmark.nt.c) event);
            return;
        }
        if (event instanceof u) {
            this$0.ga((u) event);
            return;
        }
        if (event instanceof o) {
            this$0.Y9((o) event);
            return;
        }
        if (event instanceof p) {
            this$0.Z9();
            return;
        }
        if (event instanceof q) {
            this$0.aa((q) event);
            return;
        }
        if (event instanceof r) {
            this$0.ba((r) event);
        } else if (event instanceof t) {
            this$0.da((t) event);
        } else if (event instanceof s) {
            this$0.ca();
        }
    }

    private final void ia() {
        for (Class<? extends zv3.a> cls : this.eventList) {
            this.busManager.registerEvent(cls, this);
        }
    }

    private final void ja() {
        for (Class<? extends zv3.a> cls : this.eventList) {
            this.busManager.unRegisterEvent(cls, this);
        }
    }

    @Override // zv3.c
    public void B5(@NotNull final zv3.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.parts.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.ha(zv3.a.this, this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            ia();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            ja();
            super.onPartDestroy(activity);
        }
    }
}
