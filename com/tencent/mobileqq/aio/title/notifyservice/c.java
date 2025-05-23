package com.tencent.mobileqq.aio.title.notifyservice;

import com.tencent.aio.data.AIOParam;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.mobileqq.aio.event.AIOGestureEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.notifyservice.NotifyServiceTitleUIState;
import com.tencent.mobileqq.aio.title.notifyservice.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/title/notifyservice/c;", "Lcom/tencent/mobileqq/aio/title/al;", "Lcom/tencent/mobileqq/aio/title/notifyservice/a;", "Lcom/tencent/mobileqq/aio/title/notifyservice/NotifyServiceTitleUIState;", "", "o", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "source", "selectMode", DomainData.DOMAIN_NAME, "handled", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, TagValue.MOSAIC, "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "l", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends al<a, NotifyServiceTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/notifyservice/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.notifyservice.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void m(boolean handled) {
        QLog.d("NotifyServiceTitleVM", 1, "[handleLeftSwipeEvent] handled:" + handled);
    }

    private final void n(String source, boolean selectMode) {
        QLog.d("NotifyServiceTitleVM", 1, "[handleMultiSelectModeChangeEvent] source:" + source + " | selectedMode:" + selectMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        QLog.d("NotifyServiceTitleVM", 1, "[handleOnBind]");
        AIOUtil aIOUtil = AIOUtil.f194084a;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (aIOUtil.u(g16)) {
            String g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g();
            String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
            String avatarPath = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getString("key_notify_avatar_path", "");
            String subTitle = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getString("key_notify_app_sub_title", "");
            Intrinsics.checkNotNullExpressionValue(avatarPath, "avatarPath");
            Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
            updateUI(new NotifyServiceTitleUIState.UpdateNotifyServiceTitle(new d(true, g17, j3, avatarPath, subTitle)));
        }
    }

    private final void p(boolean handled) {
        QLog.d("NotifyServiceTitleVM", 1, "[handleRightSwipeEvent] handled:" + handled);
    }

    private final void q(boolean visible) {
        QLog.d("NotifyServiceTitleVM", 1, "[handleSetTabVisibility] visible:" + visible);
    }

    private final void r(boolean mosaic) {
        QLog.d("NotifyServiceTitleVM", 1, "[handleShotMosaic] mosaic:" + mosaic);
        updateUI(new NotifyServiceTitleUIState.UpdateNotifyTitleShotMosaic(mosaic));
    }

    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOGestureEvent.LeftSwipeEvent) {
            m(((AIOGestureEvent.LeftSwipeEvent) intent).a());
            return;
        }
        if (intent instanceof AIOGestureEvent.RightSwipeEvent) {
            p(((AIOGestureEvent.RightSwipeEvent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            AIOMsgListEvent.MultiSelectModeChangeEvent multiSelectModeChangeEvent = (AIOMsgListEvent.MultiSelectModeChangeEvent) intent;
            n(multiSelectModeChangeEvent.a(), multiSelectModeChangeEvent.b());
        } else if (intent instanceof TitleTabEvent.SetTabVisibility) {
            q(((TitleTabEvent.SetTabVisibility) intent).a());
        } else if (intent instanceof LongShotMsgIntent.ShotMosaic) {
            r(((LongShotMsgIntent.ShotMosaic) intent).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOGestureEvent.LeftSwipeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOGestureEvent.RightSwipeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.SetTabVisibility");
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.ShotMosaic");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7363a) {
            o();
        }
    }
}
