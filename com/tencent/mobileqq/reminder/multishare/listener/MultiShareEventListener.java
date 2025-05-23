package com.tencent.mobileqq.reminder.multishare.listener;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.multishare.api.IMultiShareApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.util.g;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import j92.b;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u000fB\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\b\u0010+\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001e\u0010\u0015\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001e\u0010\u001c\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u001e\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/listener/MultiShareEventListener;", "Lj92/b;", "Lj92/a;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnShowListener;", "Lcom/tencent/mobileqq/multishare/api/IMultiShareApi;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "", "g", "Lcom/tencent/mobileqq/multishare/action/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "Lcom/tencent/mobileqq/multishare/action/c;", "", "isSelected", "a", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "sendUsers", "", "leaveMsg", "e", "chosenUsers", "d", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onShow", "c", "Ljava/lang/String;", "defaultMsg", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/reminder/multishare/listener/a;", "Lmqq/util/WeakReference;", "msgSendEventListenerRef", "Z", "hasSendMsg", h.F, "multiSharePanelRef", "Lcom/tencent/mobileqq/reminder/multishare/listener/b;", "i", "Lcom/tencent/mobileqq/reminder/multishare/listener/b;", "accountCallback", "msgSendEventListener", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/reminder/multishare/listener/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MultiShareEventListener implements j92.b, j92.a, DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<a> msgSendEventListenerRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasSendMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<IMultiShareApi> multiSharePanelRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b accountCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/listener/MultiShareEventListener$a;", "", "", "MSG_MAX_LENGTH", "I", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.multishare.listener.MultiShareEventListener$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareEventListener(@NotNull String defaultMsg, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(defaultMsg, "defaultMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) defaultMsg, (Object) aVar);
            return;
        }
        this.defaultMsg = defaultMsg;
        this.msgSendEventListenerRef = new WeakReference<>(aVar);
        this.accountCallback = new b();
    }

    @Override // j92.b
    public void a(@NotNull com.tencent.mobileqq.multishare.action.c item, boolean isSelected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, Boolean.valueOf(isSelected));
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    @Override // j92.b
    public void b(@NotNull Activity activity, @NotNull com.tencent.mobileqq.multishare.action.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) cVar);
        } else {
            b.a.a(this, activity, cVar);
        }
    }

    @Override // j92.a
    public boolean c(@NotNull List<? extends ResultRecord> sendUsers, @NotNull String leaveMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) sendUsers, (Object) leaveMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sendUsers, "sendUsers");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        if (leaveMsg.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            leaveMsg = this.defaultMsg;
        }
        if (leaveMsg.length() <= 4500) {
            return true;
        }
        a aVar = this.msgSendEventListenerRef.get();
        if (aVar != null) {
            aVar.e();
        }
        return false;
    }

    @Override // j92.b
    public void d(@NotNull List<? extends ResultRecord> chosenUsers) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) chosenUsers);
        } else {
            Intrinsics.checkNotNullParameter(chosenUsers, "chosenUsers");
        }
    }

    @Override // j92.b
    public void e(@NotNull List<? extends ResultRecord> sendUsers, @NotNull String leaveMsg) {
        boolean z16;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sendUsers, (Object) leaveMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(sendUsers, "sendUsers");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        if (leaveMsg.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            leaveMsg = this.defaultMsg;
        }
        com.tencent.mobileqq.reminder.util.c.INSTANCE.c(sendUsers, leaveMsg);
        a aVar = this.msgSendEventListenerRef.get();
        if (aVar != null) {
            aVar.f();
        }
        this.hasSendMsg = true;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sendUsers, ",", null, null, 0, null, MultiShareEventListener$onSend$uinList$1.INSTANCE, 30, null);
        HashMap hashMap = new HashMap();
        hashMap.put("touin_list", joinToString$default);
        hashMap.put("relation_content", leaveMsg);
        g.c("qq_clck", "", "em_bas_send", hashMap);
    }

    @Override // j92.b
    public void f(@NotNull com.tencent.mobileqq.multishare.action.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    public final void g(@Nullable IMultiShareApi panel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) panel);
            return;
        }
        this.multiSharePanelRef = null;
        if (panel != null) {
            this.multiSharePanelRef = new WeakReference<>(panel);
        }
        this.accountCallback.a(this.multiSharePanelRef);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@Nullable DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dialog);
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            mobileQQ.unregisterAccountCallback(this.accountCallback);
        }
        if (!this.hasSendMsg) {
            g.d("qq_clck", "", "em_bas_close_panel", null, 8, null);
        }
        this.hasSendMsg = false;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(@Nullable DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dialog);
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            mobileQQ.registerAccountCallback(this.accountCallback);
        }
        g.d("qq_imp", "", "em_bas_one_click_thank_panel", null, 8, null);
    }
}
