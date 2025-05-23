package com.tencent.mobileqq.aio.title.right2;

import android.widget.ImageView;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ag;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.right2.Right2UIState;
import com.tencent.mobileqq.aio.title.right2.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/title/right2/c;", "Lcom/tencent/mobileqq/aio/title/al;", "Lcom/tencent/mobileqq/aio/title/right2/a;", "Lcom/tencent/mobileqq/aio/title/right2/Right2UIState;", "", "width", "height", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "p", "", "selectMode", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "intent", "o", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "Z", "mIsSelectedMode", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends al<a, Right2UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void n(boolean selectMode) {
        this.mIsSelectedMode = selectMode;
        updateUI(new Right2UIState.MultiSelectModeChangeState(selectMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(AIOTitleEvent.UpdateRight2IvEvent intent) {
        AIOUtil aIOUtil = AIOUtil.f194084a;
        if (!aIOUtil.x(((com.tencent.aio.api.runtime.a) getMContext()).g().r()) && !aIOUtil.z(((com.tencent.aio.api.runtime.a) getMContext()).g().r()) && !aIOUtil.w(((com.tencent.aio.api.runtime.a) getMContext()).g().r())) {
            updateUI(new Right2UIState.UpdateDataUIState(new ag(intent.b(), intent.e(), intent.c(), intent.a(), intent.d(), this.mIsSelectedMode)));
        } else {
            updateUI(new Right2UIState.UpdateDataUIState(new ag(false, false, null, 0, "", this.mIsSelectedMode)));
        }
    }

    private final void p(int width, int height, ImageView.ScaleType scaleType) {
        updateUI(new Right2UIState.UpdateRight2IvScaleType(width, height, scaleType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.Right2IvClickEvent.f188500d);
    }

    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOTitleEvent.UpdateRight2IvEvent) {
            o((AIOTitleEvent.UpdateRight2IvEvent) intent);
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateRight2IvScaleType) {
            AIOTitleEvent.UpdateRight2IvScaleType updateRight2IvScaleType = (AIOTitleEvent.UpdateRight2IvScaleType) intent;
            p(updateRight2IvScaleType.c(), updateRight2IvScaleType.a(), updateRight2IvScaleType.b());
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            n(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateRight2IvEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateRight2IvScaleType");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
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
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            l();
        } else if (intent instanceof a.C7365a) {
            q();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        this.mIsSelectedMode = false;
    }

    private final void l() {
    }
}
