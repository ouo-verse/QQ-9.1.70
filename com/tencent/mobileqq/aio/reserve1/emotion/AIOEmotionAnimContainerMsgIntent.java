package com.tencent.mobileqq.aio.reserve1.emotion;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/emotion/AIOEmotionAnimContainerMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "InputLayoutChange", "Lcom/tencent/mobileqq/aio/reserve1/emotion/AIOEmotionAnimContainerMsgIntent$InputLayoutChange;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class AIOEmotionAnimContainerMsgIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/emotion/AIOEmotionAnimContainerMsgIntent$InputLayoutChange;", "Lcom/tencent/mobileqq/aio/reserve1/emotion/AIOEmotionAnimContainerMsgIntent;", "", "isSticky", "", "toString", "", "hashCode", "", "other", "equals", "d", "I", "getLeft", "()I", "left", "e", "b", "top", "f", "getRight", "right", h.F, "a", "bottom", "<init>", "(IIII)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class InputLayoutChange extends AIOEmotionAnimContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int left;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int top;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int right;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int bottom;

        public InputLayoutChange(int i3, int i16, int i17, int i18) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.left = i3;
            this.top = i16;
            this.right = i17;
            this.bottom = i18;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.bottom;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.top;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputLayoutChange)) {
                return false;
            }
            InputLayoutChange inputLayoutChange = (InputLayoutChange) other;
            if (this.left == inputLayoutChange.left && this.top == inputLayoutChange.top && this.right == inputLayoutChange.right && this.bottom == inputLayoutChange.bottom) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "com.tencent.mobileqq.aio.reserve1.emotion.AIOEmotionAnimContainerMsgIntent.InputLayoutChange";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return true;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "InputLayoutChange(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    public /* synthetic */ AIOEmotionAnimContainerMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    AIOEmotionAnimContainerMsgIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
