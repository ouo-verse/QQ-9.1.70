package com.tencent.mobileqq.aio.msglist.holder.component.egg;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.e;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/egg/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", "u1", "v1", "", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "view", "bubbleHeight", "r1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "c1", h.F, "Landroid/view/View;", "mContentView", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/egg/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.egg.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void r1(View view, int bubbleHeight) {
        int i3 = view.getLayoutParams().height;
        if (i3 != 0 && bubbleHeight != 0) {
            if (view.getParent() != null) {
                QLog.e("AvatarEggAtmosphereComponent", 1, "[bindView]: atmosphereView parent is not null, return");
                return;
            }
            this.mContentView = view;
            ViewGroup.LayoutParams layoutParams = f1().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = bubbleHeight - i3;
            q1();
            return;
        }
        QLog.e("AvatarEggAtmosphereComponent", 1, "[bindView]: params invalid, viewHeight is " + i3 + ", bubbleHeight is " + bubbleHeight);
    }

    private final int s1() {
        ViewGroup viewGroup;
        ViewParent parent = f1().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            return viewGroup.getMeasuredHeight();
        }
        return 0;
    }

    private final void u1(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.AVATAR_EGG_PAYLOAD) != null) {
                v1(msgItem);
            }
        }
    }

    private final void v1(AIOMsgItem msgItem) {
        com.tencent.qqnt.aio.avatar.egg.a q16 = msgItem.q();
        if (q16 != null) {
            if (q16.g() == 0) {
                QLog.i("AvatarEggAtmosphereComponent", 1, "[updateAvatarAtmosphere]: start avatar egg, msgId is " + msgItem.getMsgId());
                int s16 = s1();
                if (s16 != 0 && q16.c() != null) {
                    View c16 = q16.c();
                    Intrinsics.checkNotNull(c16);
                    r1(c16, s16);
                    return;
                }
                QLog.i("AvatarEggAtmosphereComponent", 1, "[updateAvatarAtmosphere]: bubbleHeight is " + s16 + " atomsphereView is " + q16.c());
                return;
            }
            if (q16.g() == 1) {
                QLog.i("AvatarEggAtmosphereComponent", 1, "[updateAvatarAtmosphere]: stop avatar egg, msgId is " + msgItem.getMsgId());
                p1();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        u1((AIOMsgItem) msgItem, payloads);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            return null;
        }
        return view;
    }
}
