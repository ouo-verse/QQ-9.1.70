package com.tencent.qqnt.aio.paiyipai;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.aio.utils.j;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.luckybag.IVasLuckyBagApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/paiyipai/b;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Lcom/tencent/qqnt/aio/paiyipai/a;", "detector", "", "a", "", "msgId", "b", "(Ljava/lang/Long;)V", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDoubleTap", e.a.NAME, "d", "Lcom/tencent/qqnt/aio/paiyipai/a;", "mDetector", "Ljava/lang/Long;", "mMsgId", "<init>", "()V", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f351737h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long mMsgId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/paiyipai/b$a;", "", "Landroid/view/View;", "avatar", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "", "b", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.paiyipai.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void b(View avatar, AIOMsgItem aioMsgItem) {
            String str;
            com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
            HashMap hashMap = new HashMap();
            hashMap.put("aio_type", String.valueOf(aioMsgItem.getMsgRecord().chatType));
            Unit unit = Unit.INSTANCE;
            bVar.n("ev_bas_double_click_avatar", hashMap);
            new c(avatar).c();
            ((IPaiYiPaiApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPaiYiPaiApi.class)).sendDoubleClickReq(aioMsgItem.getMsgRecord());
            String str2 = aioMsgItem.getMsgRecord().senderUid;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUid();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str2, str)) {
                ((IVasLuckyBagApi) QRoute.api(IVasLuckyBagApi.class)).handleLuckyBag(aioMsgItem.v(), aioMsgItem.getMsgRecord().senderUin);
            }
        }

        public final void a(@NotNull View avatar, @NotNull AIOMsgItem aioMsgItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatar, (Object) aioMsgItem);
                return;
            }
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
            Context context = avatar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "avatar.context");
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(context, R.string.cib, 0).show();
                return;
            }
            if (aioMsgItem.getMsgRecord().chatType == 1) {
                b(avatar, aioMsgItem);
                return;
            }
            if (aioMsgItem.getMsgRecord().chatType == 2) {
                if (!d.s(aioMsgItem) && !j.f194163a.a(String.valueOf(aioMsgItem.getMsgRecord().peerUin))) {
                    b(avatar, aioMsgItem);
                } else {
                    QQToast.makeText(context, R.string.f173102s9, 0).show();
                }
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            f351737h = "AvatarOnGestureListener";
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable a detector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) detector);
        } else {
            this.mDetector = detector;
        }
    }

    public final void b(@Nullable Long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgId);
        } else {
            this.mMsgId = msgId;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(@NotNull MotionEvent e16) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        if (QLog.isColorLevel()) {
            QLog.d(f351737h, 2, "onDoubleTap() msgId " + this.mMsgId + " called with: e = [" + e16 + "]");
        }
        a aVar = this.mDetector;
        if (aVar != null) {
            aVar.setIsLongpressEnabled(false);
            View a16 = aVar.a();
            if (a16 != null) {
                obj = a16.getTag();
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            INSTANCE.a(a16, (AIOMsgItem) obj);
        }
        return super.onDoubleTap(e16);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(@NotNull MotionEvent e16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) e16);
            return;
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        super.onLongPress(e16);
        if (QLog.isColorLevel()) {
            QLog.d(f351737h, 2, "onLongPress() called with: e = [" + e16 + "]");
        }
        a aVar = this.mDetector;
        if (aVar != null) {
            view = aVar.a();
        } else {
            view = null;
        }
        boolean z16 = false;
        if (view != null && view.hasOnClickListeners()) {
            z16 = true;
        }
        if (z16) {
            view.performLongClick();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        if (QLog.isColorLevel()) {
            QLog.d(f351737h, 2, "onSingleTapConfirmed() msgId " + this.mMsgId + " called with: e = [" + e16 + "]");
        }
        a aVar = this.mDetector;
        if (aVar != null) {
            view = aVar.a();
        } else {
            view = null;
        }
        boolean z16 = false;
        if (view != null && view.hasOnClickListeners()) {
            z16 = true;
        }
        if (z16) {
            view.performClick();
        }
        return super.onSingleTapConfirmed(e16);
    }
}
