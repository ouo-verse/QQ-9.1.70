package com.tencent.qqnt.forwardaio.title;

import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "<init>", "()V", "UpdateMemBtn", "UpdateTitle", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState$UpdateMemBtn;", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState$UpdateTitle;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class ForwardAIOTitleUIState implements TitleUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState$UpdateMemBtn;", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState;", "", "d", "Z", "a", "()Z", "show", "<init>", "(Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class UpdateMemBtn extends ForwardAIOTitleUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        public UpdateMemBtn(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.show = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState$UpdateTitle;", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class UpdateTitle extends ForwardAIOTitleUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateTitle(@NotNull String title) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) title);
            } else {
                this.title = title;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.title;
        }
    }

    public /* synthetic */ ForwardAIOTitleUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    ForwardAIOTitleUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
