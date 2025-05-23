package com.tencent.mobileqq.aio.msglist.scrollers;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002 $B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J&\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00102R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00102R\u0018\u0010\u000f\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00106R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/scrollers/a;", "", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "", DownloaderConstant.KEY_RANGE, "", "l", "helper", "Lcom/tencent/mobileqq/aio/msglist/scrollers/a$b;", "focusTarget", "", h.F, "position", "Lcom/tencent/mobileqq/aio/msglist/scrollers/b;", "scrollListener", "g", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "j", "f", "e", "k", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "footerCount", "o", DomainData.DOMAIN_NAME, "a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "scroller", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "contextWeakRef", "c", "Lcom/tencent/mobileqq/aio/msglist/scrollers/a$b;", "currentFocusTarget", "d", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "I", "i", "()I", "setRecyclerViewHeight", "(I)V", "recyclerViewHeight", "Z", "isAnimation", "listenerAdded", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "touchListener", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearSmoothScroller scroller;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> contextWeakRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b currentFocusTarget;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IListUIOperationApi uiHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimation;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean listenerAdded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.OnScrollListener scrollListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnAIOTouchListener touchListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/scrollers/a$a;", "", "", "FOCUS_NO_ANIM", "Ljava/lang/String;", "", "MAX_SCROLL_TIME", "I", "MIN_SCROLL_TIME", "SCROLL_DOWN_DIRECTION", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.scrollers.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/scrollers/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "position", "b", "Ljava/lang/Integer;", "getUpdateType", "()Ljava/lang/Integer;", "updateType", "<init>", "(ILjava/lang/Integer;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Integer updateType;

        public b(int i3, @Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) num);
            } else {
                this.position = i3;
                this.updateType = num;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.position == bVar.position && Intrinsics.areEqual(this.updateType, bVar.updateType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int i3 = this.position * 31;
            Integer num = this.updateType;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "FocusTarget(position=" + this.position + ", updateType=" + this.updateType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/scrollers/a$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IListUIOperationApi f192705d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f192706e;

        c(IListUIOperationApi iListUIOperationApi, a aVar) {
            this.f192705d = iListUIOperationApi;
            this.f192706e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iListUIOperationApi, (Object) aVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            AIORecycleView i3 = this.f192705d.i();
            a aVar = this.f192706e;
            if (aVar.m(i3)) {
                aVar.isAnimation = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/scrollers/a$d", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements OnAIOTouchListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 0) {
                a.this.isAnimation = false;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/scrollers/a$e", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", DKHippyEvent.EVENT_STOP, "", "dx", "calculateTimeForScrolling", "getVerticalSnapPreference", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e extends LinearSmoothScroller {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f192708c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context, a aVar) {
            super(context);
            this.f192708c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, dx5)).intValue();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("FocusBottomHandler", 4, "calculateTimeForScrolling dx=" + dx5);
            }
            if (dx5 > this.f192708c.i() / 2) {
                return 85;
            }
            if (dx5 > 0) {
                return 65;
            }
            return (int) Math.ceil(dx5);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onStop();
            IListUIOperationApi iListUIOperationApi = this.f192708c.uiHelper;
            b bVar = this.f192708c.currentFocusTarget;
            if (iListUIOperationApi != null && bVar != null && !this.f192708c.l(iListUIOperationApi, 1)) {
                QLog.d("FocusBottomHandler", 1, "smooth scroll is stop before reach target");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64322);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
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

    private final LinearSmoothScroller f(Context context) {
        return new e(context, this);
    }

    private final void g(IListUIOperationApi helper, int position, com.tencent.mobileqq.aio.msglist.scrollers.b scrollListener) {
        scrollListener.onScrollStart();
        helper.p(position, true, scrollListener);
    }

    private final void h(IListUIOperationApi helper, b focusTarget) {
        Context context = helper.i().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.getRecycleView().context");
        LinearSmoothScroller j3 = j(context);
        j3.setTargetPosition(focusTarget.a());
        e(helper);
        helper.i().getLayoutManager().startSmoothScroll(j3);
        this.isAnimation = true;
    }

    private final LinearSmoothScroller j(Context context) {
        Context context2;
        WeakReference<Context> weakReference = this.contextWeakRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        if (!Intrinsics.areEqual(context, context2)) {
            this.contextWeakRef = new WeakReference<>(context);
            this.scroller = f(context);
        }
        if (this.scroller == null) {
            this.scroller = f(context);
        }
        LinearSmoothScroller linearSmoothScroller = this.scroller;
        Intrinsics.checkNotNull(linearSmoothScroller, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearSmoothScroller");
        return linearSmoothScroller;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(IListUIOperationApi uiHelper, int range) {
        int findLastVisibleItemPosition = uiHelper.i().getLayoutManager().findLastVisibleItemPosition();
        int size = uiHelper.t().size();
        if (QLog.isDevelopLevel()) {
            QLog.d("FocusBottomHandler", 4, "currentListSize=" + size + " lastItemPos=" + findLastVisibleItemPosition);
        }
        if (findLastVisibleItemPosition >= size - range && findLastVisibleItemPosition < size) {
            return true;
        }
        return false;
    }

    public final void e(@NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (this.listenerAdded) {
            return;
        }
        this.listenerAdded = true;
        c cVar = new c(uiHelper, this);
        d dVar = new d();
        this.scrollListener = cVar;
        this.touchListener = dVar;
        AIORecycleView i3 = uiHelper.i();
        i3.addOnScrollListener(cVar);
        i3.addOnTouchListener(dVar);
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.recyclerViewHeight;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isAnimation;
    }

    public final boolean m(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) recyclerView)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    public final void n() {
        IListUIOperationApi iListUIOperationApi;
        AIORecycleView i3;
        IListUIOperationApi iListUIOperationApi2;
        AIORecycleView i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.isAnimation = false;
        this.listenerAdded = false;
        RecyclerView.OnScrollListener onScrollListener = this.scrollListener;
        if (onScrollListener != null && (iListUIOperationApi2 = this.uiHelper) != null && (i16 = iListUIOperationApi2.i()) != null) {
            i16.removeOnScrollListener(onScrollListener);
        }
        OnAIOTouchListener onAIOTouchListener = this.touchListener;
        if (onAIOTouchListener != null && (iListUIOperationApi = this.uiHelper) != null && (i3 = iListUIOperationApi.i()) != null) {
            i3.removeOnTouchListener(onAIOTouchListener);
        }
        this.scrollListener = null;
        this.touchListener = null;
    }

    public final void o(@NotNull MsgListState state, @NotNull IListUIOperationApi helper, int footerCount, @NotNull com.tencent.mobileqq.aio.msglist.scrollers.b scrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, state, helper, Integer.valueOf(footerCount), scrollListener);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(scrollListener, "scrollListener");
        Bundle extra = state.getExtra();
        if (extra != null) {
            z16 = extra.getBoolean("FOCUS_NO_ANIM", false);
        }
        this.uiHelper = helper;
        this.recyclerViewHeight = helper.i().getHeight();
        int size = (state.size() - 1) + footerCount;
        boolean isSmoothScrolling = helper.i().getLayoutManager().isSmoothScrolling();
        boolean l3 = l(helper, 2);
        if (QLog.isDevelopLevel()) {
            QLog.d("FocusBottomHandler", 4, "processFocusBottom|isSmoothScrolling=" + isSmoothScrolling + " targetPosition=" + size + " isInBottomRange=" + l3 + " noAnim=" + z16 + ", footerCount=" + footerCount);
        }
        if (size >= 0 && size <= helper.i().getLayoutManager().getItemCount() - 1) {
            b bVar = new b(size, Integer.valueOf(state.getUpdateType()));
            if (l3 && !z16) {
                h(helper, bVar);
            } else {
                if (isSmoothScrolling) {
                    helper.i().stopScroll();
                }
                g(helper, size, scrollListener);
            }
            this.currentFocusTarget = bVar;
        }
    }
}
