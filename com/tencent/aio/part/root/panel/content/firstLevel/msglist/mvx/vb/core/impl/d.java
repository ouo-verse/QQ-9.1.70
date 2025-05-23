package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/d;", "Lxs/a;", "", "msgPosition", "Lxs/a$c;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "", "baseBottom", "Lxs/a$b;", "completeListener", "p", "offset", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "f", "()Ljava/lang/Long;", "Landroidx/recyclerview/widget/AIORecycleView;", "d", "Landroidx/recyclerview/widget/AIORecycleView;", "recycleView", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "focusIndex", "<init>", "(Landroidx/recyclerview/widget/AIORecycleView;Lkotlin/jvm/functions/Function0;)V", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d implements xs.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AIORecycleView recycleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Long> focusIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.d$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull AIORecycleView recycleView, @NotNull Function0<Long> focusIndex) {
        Intrinsics.checkNotNullParameter(recycleView, "recycleView");
        Intrinsics.checkNotNullParameter(focusIndex, "focusIndex");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recycleView, (Object) focusIndex);
        } else {
            this.recycleView = recycleView;
            this.focusIndex = focusIndex;
        }
    }

    @Override // xs.a
    @Nullable
    public Long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Long) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.focusIndex.invoke();
    }

    @Override // xs.a
    public void m(int msgPosition, @Nullable a.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, msgPosition, (Object) listener);
            return;
        }
        this.recycleView.setTag(R.id.f793049e, listener);
        this.recycleView.smoothScrollToPosition(msgPosition);
        com.tencent.aio.base.log.a.f69187b.d("ListScrollApiImpl", "smoothScrollToMsgPosition  position " + msgPosition + " + listener " + listener);
    }

    @Override // xs.a
    public boolean p(int position, boolean baseBottom, @Nullable a.b completeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Boolean.valueOf(baseBottom), completeListener)).booleanValue();
        }
        com.tencent.aio.base.log.a.f69187b.d("ListScrollApiImpl", "scrollToMsgPosition  position " + position + " + baseBottom " + baseBottom + "  completeListener " + completeListener);
        return this.recycleView.getLayoutManager().scrollToPositionWithOffset$sdk_debug(position, 0, baseBottom, completeListener);
    }

    @Override // xs.a
    public boolean z(int position, boolean baseBottom, int offset, @Nullable a.b completeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), Boolean.valueOf(baseBottom), Integer.valueOf(offset), completeListener)).booleanValue();
        }
        com.tencent.aio.base.log.a.f69187b.d("ListScrollApiImpl", "scrollToMsgPositionWithOffset  position " + position + " + baseBottom " + baseBottom + "  offset " + offset + " completeListener " + completeListener);
        return this.recycleView.getLayoutManager().scrollToPositionWithOffset$sdk_debug(position, offset, baseBottom, completeListener);
    }
}
