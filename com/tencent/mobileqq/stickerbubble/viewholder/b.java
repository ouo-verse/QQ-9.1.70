package com.tencent.mobileqq.stickerbubble.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.stickerbubble.viewholder.b;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0019\n\u0002\b\u0003\n\u0002\b\u0006*\u000214\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J,\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u001c\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0006R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010%R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/stickerbubble/viewholder/b;", "", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView$a;", "callback", "", "isSend", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView;", "j", "Landroid/view/ViewGroup;", "afRoot", "Landroid/view/View;", "animationView", "e", "p", "", "Ljava/lang/ref/WeakReference;", "callbackList", "", "itemTypeCount", "itemCount", DomainData.DOMAIN_NAME, "", "o", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "g", h.F, "f", ReportConstant.COSTREPORT_PREFIX, "r", "i", "b", "Z", "resetTypeFaceFlag", "c", "Ljava/util/List;", "mSendListenerList", "d", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView;", "mSendAnimView", "mSendAnimationViewAdded", "mReceiveListenerList", "mReceiveAnimView", "mReceiveAnimationViewAdded", "com/tencent/mobileqq/stickerbubble/viewholder/b$a", "Lcom/tencent/mobileqq/stickerbubble/viewholder/b$a;", "mReceiveCallback", "com/tencent/mobileqq/stickerbubble/viewholder/b$b", "Lcom/tencent/mobileqq/stickerbubble/viewholder/b$b;", "mSendCallback", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f290239a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean resetTypeFaceFlag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<StickerBubbleAnimationView.a>> mSendListenerList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static StickerBubbleAnimationView mSendAnimView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mSendAnimationViewAdded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<StickerBubbleAnimationView.a>> mReceiveListenerList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static StickerBubbleAnimationView mReceiveAnimView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean mReceiveAnimationViewAdded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a mReceiveCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C8621b mSendCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/stickerbubble/viewholder/b$a", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView$a;", "", "itemTypeCount", "itemCount", "", h.F, "e", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements StickerBubbleAnimationView.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            b.f290239a.l();
        }

        @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AnimationViewCache", 2, "onViewDetached");
            }
            b.f290239a.o(b.mReceiveListenerList);
        }

        @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
        public void h(int itemTypeCount, int itemCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(itemTypeCount), Integer.valueOf(itemCount));
                return;
            }
            com.tencent.mobileqq.popanim.view.a.g("0X800BBA4", 2, String.valueOf(itemTypeCount), String.valueOf(itemCount));
            b.f290239a.n(b.mReceiveListenerList, itemTypeCount, itemCount);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.stickerbubble.viewholder.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.b();
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/stickerbubble/viewholder/b$b", "Lcom/tencent/mobileqq/activity/aio/stickerbubble/StickerBubbleAnimationView$a;", "", "itemTypeCount", "itemCount", "", h.F, "e", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.stickerbubble.viewholder.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8621b implements StickerBubbleAnimationView.a {
        static IPatchRedirector $redirector_;

        C8621b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            b.f290239a.m();
        }

        @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b.f290239a.o(b.mSendListenerList);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
        public void h(int itemTypeCount, int itemCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.f290239a.n(b.mSendListenerList, itemTypeCount, itemCount);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.stickerbubble.viewholder.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.C8621b.b();
                    }
                });
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(itemTypeCount), Integer.valueOf(itemCount));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f290239a = new b();
        mSendListenerList = new CopyOnWriteArrayList();
        mReceiveListenerList = new CopyOnWriteArrayList();
        mReceiveCallback = new a();
        mSendCallback = new C8621b();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(ViewGroup afRoot, View animationView) {
        if (animationView.getParent() != null) {
            if (animationView.getParent() != afRoot) {
                ViewParent parent = animationView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(animationView);
                afRoot.addView(animationView);
            }
        } else {
            afRoot.addView(animationView);
        }
        animationView.bringToFront();
    }

    private final StickerBubbleAnimationView j() {
        if (mReceiveAnimView == null) {
            com.tencent.mobileqq.poke.c cVar = com.tencent.mobileqq.poke.c.f258994a;
            if (cVar.g() == null) {
                cVar.k();
            }
            StickerBubbleAnimationView stickerBubbleAnimationView = new StickerBubbleAnimationView(BaseApplication.getContext());
            stickerBubbleAnimationView.setShowText(false);
            stickerBubbleAnimationView.setTypeface(cVar.g());
            stickerBubbleAnimationView.setId(R.id.j3a);
            stickerBubbleAnimationView.setAnimationCallback(mReceiveCallback);
            mReceiveAnimView = stickerBubbleAnimationView;
        }
        StickerBubbleAnimationView stickerBubbleAnimationView2 = mReceiveAnimView;
        Intrinsics.checkNotNull(stickerBubbleAnimationView2);
        return stickerBubbleAnimationView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void n(List<? extends WeakReference<StickerBubbleAnimationView.a>> callbackList, int itemTypeCount, int itemCount) {
        Iterator<? extends WeakReference<StickerBubbleAnimationView.a>> it = callbackList.iterator();
        while (it.hasNext()) {
            StickerBubbleAnimationView.a aVar = it.next().get();
            if (aVar != null) {
                aVar.h(itemTypeCount, itemCount);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void o(List<WeakReference<StickerBubbleAnimationView.a>> callbackList) {
        Iterator it = new ArrayList(callbackList).iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            StickerBubbleAnimationView.a aVar = (StickerBubbleAnimationView.a) weakReference.get();
            if (aVar != null) {
                aVar.e();
            } else {
                callbackList.remove(weakReference);
            }
        }
    }

    private final void p(View animationView) {
        if (animationView.getParent() != null) {
            ViewParent parent = animationView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(animationView);
        }
    }

    private final synchronized void q(StickerBubbleAnimationView.a callback, boolean isSend) {
        List<WeakReference<StickerBubbleAnimationView.a>> list;
        if (isSend) {
            list = mSendListenerList;
        } else {
            list = mReceiveListenerList;
        }
        for (WeakReference<StickerBubbleAnimationView.a> weakReference : list) {
            if (Intrinsics.areEqual(weakReference.get(), callback)) {
                list.remove(weakReference);
            }
        }
    }

    public final synchronized void f(@NotNull StickerBubbleAnimationView.a callback, boolean isSend) {
        List<WeakReference<StickerBubbleAnimationView.a>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, callback, Boolean.valueOf(isSend));
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isSend) {
            list = mSendListenerList;
        } else {
            list = mReceiveListenerList;
        }
        Iterator<WeakReference<StickerBubbleAnimationView.a>> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), callback)) {
                return;
            }
        }
        list.add(new WeakReference<>(callback));
    }

    public final synchronized void g(@NotNull StickerBubbleAnimationView.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            f(callback, false);
        }
    }

    public final synchronized void h(@NotNull StickerBubbleAnimationView.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            f(callback, true);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AnimationViewCache", 2, "cleanView");
        }
        if (mReceiveAnimationViewAdded) {
            l();
        }
        if (mSendAnimationViewAdded) {
            m();
        }
        mReceiveListenerList.clear();
        mSendListenerList.clear();
        mSendAnimView = null;
        mReceiveAnimView = null;
    }

    @NotNull
    public final StickerBubbleAnimationView k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (StickerBubbleAnimationView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!resetTypeFaceFlag && com.tencent.mobileqq.poke.c.f258994a.f()) {
            resetTypeFaceFlag = true;
        }
        StickerBubbleAnimationView stickerBubbleAnimationView = mSendAnimView;
        if (stickerBubbleAnimationView == null) {
            com.tencent.mobileqq.poke.c cVar = com.tencent.mobileqq.poke.c.f258994a;
            if (cVar.g() == null) {
                cVar.k();
            }
            StickerBubbleAnimationView stickerBubbleAnimationView2 = new StickerBubbleAnimationView(BaseApplication.getContext());
            stickerBubbleAnimationView2.setShowText(true);
            stickerBubbleAnimationView2.setTypeface(cVar.g());
            stickerBubbleAnimationView2.setId(R.id.j3a);
            stickerBubbleAnimationView2.setAnimationCallback(mSendCallback);
            mSendAnimView = stickerBubbleAnimationView2;
        } else if (resetTypeFaceFlag) {
            Intrinsics.checkNotNull(stickerBubbleAnimationView);
            stickerBubbleAnimationView.setTypeface(com.tencent.mobileqq.poke.c.f258994a.g());
        }
        StickerBubbleAnimationView stickerBubbleAnimationView3 = mSendAnimView;
        Intrinsics.checkNotNull(stickerBubbleAnimationView3);
        return stickerBubbleAnimationView3;
    }

    @NotNull
    public final StickerBubbleAnimationView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (StickerBubbleAnimationView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StickerBubbleAnimationView j3 = j();
        if (mReceiveAnimationViewAdded) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationViewCache", 2, "hideReceiveAnimationView: " + j3);
            }
            p(j3);
            mReceiveAnimationViewAdded = false;
        }
        return j3;
    }

    @NotNull
    public final StickerBubbleAnimationView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StickerBubbleAnimationView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StickerBubbleAnimationView k3 = k();
        if (mSendAnimationViewAdded) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationViewCache", 2, "hileSendAnimationView: " + k3);
            }
            p(k3);
            mSendAnimationViewAdded = false;
        }
        return k3;
    }

    public final synchronized void r(@NotNull StickerBubbleAnimationView.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            q(callback, false);
        }
    }

    public final synchronized void s(@NotNull StickerBubbleAnimationView.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            q(callback, true);
        }
    }

    @NotNull
    public final StickerBubbleAnimationView t(@NotNull ViewGroup afRoot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StickerBubbleAnimationView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) afRoot);
        }
        Intrinsics.checkNotNullParameter(afRoot, "afRoot");
        StickerBubbleAnimationView j3 = j();
        if (!mReceiveAnimationViewAdded) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationViewCache", 2, "showSendAnimationView: " + j3.getParent() + " / " + afRoot);
            }
            e(afRoot, j3);
            mReceiveAnimationViewAdded = true;
        }
        return j3;
    }

    @NotNull
    public final StickerBubbleAnimationView u(@NotNull ViewGroup afRoot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StickerBubbleAnimationView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) afRoot);
        }
        Intrinsics.checkNotNullParameter(afRoot, "afRoot");
        StickerBubbleAnimationView k3 = k();
        if (!mSendAnimationViewAdded) {
            if (QLog.isColorLevel()) {
                QLog.d("AnimationViewCache", 2, "showSendAnimationView: " + k3.getParent() + " / " + afRoot);
            }
            e(afRoot, k3);
            mSendAnimationViewAdded = true;
        }
        k3.setShowText(true);
        return k3;
    }
}
