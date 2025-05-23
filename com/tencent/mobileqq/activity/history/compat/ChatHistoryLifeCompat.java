package com.tencent.mobileqq.activity.history.compat;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryLifeCompat;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lcom/tencent/mobileqq/activity/history/ChatHistoryBaseFragment;", "d", "Lcom/tencent/mobileqq/activity/history/ChatHistoryBaseFragment;", "qqBaseHistory", "<init>", "(Lcom/tencent/mobileqq/activity/history/ChatHistoryBaseFragment;)V", "e", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ChatHistoryLifeCompat implements LifecycleEventObserver {

    /* renamed from: e, reason: collision with root package name */
    private static final a f182549e = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ChatHistoryBaseFragment qqBaseHistory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryLifeCompat$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f182551a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f182551a = iArr;
        }
    }

    public ChatHistoryLifeCompat(ChatHistoryBaseFragment qqBaseHistory) {
        Intrinsics.checkNotNullParameter(qqBaseHistory, "qqBaseHistory");
        this.qqBaseHistory = qqBaseHistory;
        qqBaseHistory.getLifecycle().addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d("ChatHistoryLifeCompat", 1, " " + this.qqBaseHistory + " state Change -> " + event);
        int i3 = b.f182551a[event.ordinal()];
        if (i3 == 1) {
            this.qqBaseHistory.qh();
            return;
        }
        if (i3 == 2) {
            this.qqBaseHistory.ph();
        } else {
            if (i3 != 3) {
                return;
            }
            this.qqBaseHistory.doOnDestroy();
            this.qqBaseHistory.getLifecycle().removeObserver(this);
        }
    }
}
