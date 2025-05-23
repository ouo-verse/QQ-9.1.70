package com.tencent.mobileqq.aio.input.inputbar.compat;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "<init>", "()V", "ChangeStyleForFullScreenMode", "PostThemeChanged", "RefreshSendBtn", "SetBackgroundTransparent", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$ChangeStyleForFullScreenMode;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$PostThemeChanged;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$SetBackgroundTransparent;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class AIOInputBarCompatUIState implements InputUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$ChangeStyleForFullScreenMode;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isFullScreenMode", "e", "b", "isRobotAIO", "<init>", "(ZZ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class ChangeStyleForFullScreenMode extends AIOInputBarCompatUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isFullScreenMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isRobotAIO;

        public ChangeStyleForFullScreenMode(boolean z16, boolean z17) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.isFullScreenMode = z16;
                this.isRobotAIO = z17;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isFullScreenMode;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isRobotAIO;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeStyleForFullScreenMode)) {
                return false;
            }
            ChangeStyleForFullScreenMode changeStyleForFullScreenMode = (ChangeStyleForFullScreenMode) other;
            if (this.isFullScreenMode == changeStyleForFullScreenMode.isFullScreenMode && this.isRobotAIO == changeStyleForFullScreenMode.isRobotAIO) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.isFullScreenMode;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isRobotAIO;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "ChangeStyleForFullScreenMode(isFullScreenMode=" + this.isFullScreenMode + ", isRobotAIO=" + this.isRobotAIO + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$PostThemeChanged;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class PostThemeChanged extends AIOInputBarCompatUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final PostThemeChanged f189707d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55695);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189707d = new PostThemeChanged();
            }
        }

        PostThemeChanged() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$SetBackgroundTransparent;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "e", "a", "isImmersive", "<init>", "(ZZ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetBackgroundTransparent extends AIOInputBarCompatUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isTransparent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isImmersive;

        public SetBackgroundTransparent(boolean z16, boolean z17) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.isTransparent = z16;
                this.isImmersive = z17;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isImmersive;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isTransparent;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetBackgroundTransparent)) {
                return false;
            }
            SetBackgroundTransparent setBackgroundTransparent = (SetBackgroundTransparent) other;
            if (this.isTransparent == setBackgroundTransparent.isTransparent && this.isImmersive == setBackgroundTransparent.isImmersive) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.isTransparent;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isImmersive;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SetBackgroundTransparent(isTransparent=" + this.isTransparent + ", isImmersive=" + this.isImmersive + ")";
        }
    }

    public /* synthetic */ AIOInputBarCompatUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "selectedMediaCount", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn$RefreshFlag;", "e", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn$RefreshFlag;", "a", "()Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn$RefreshFlag;", "refreshFlag", "<init>", "(ILcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn$RefreshFlag;)V", "RefreshFlag", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class RefreshSendBtn extends AIOInputBarCompatUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int selectedMediaCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RefreshFlag refreshFlag;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn$RefreshFlag;", "", "(Ljava/lang/String;I)V", "FLAG_IMPLICIT", "FLAG_FORCE_DISABLE", "FLAG_FORCE_ENABLE", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes10.dex */
        public static final class RefreshFlag {
            private static final /* synthetic */ RefreshFlag[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final RefreshFlag FLAG_FORCE_DISABLE;
            public static final RefreshFlag FLAG_FORCE_ENABLE;
            public static final RefreshFlag FLAG_IMPLICIT;

            private static final /* synthetic */ RefreshFlag[] $values() {
                return new RefreshFlag[]{FLAG_IMPLICIT, FLAG_FORCE_DISABLE, FLAG_FORCE_ENABLE};
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55696);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                FLAG_IMPLICIT = new RefreshFlag("FLAG_IMPLICIT", 0);
                FLAG_FORCE_DISABLE = new RefreshFlag("FLAG_FORCE_DISABLE", 1);
                FLAG_FORCE_ENABLE = new RefreshFlag("FLAG_FORCE_ENABLE", 2);
                $VALUES = $values();
            }

            RefreshFlag(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static RefreshFlag valueOf(String str) {
                return (RefreshFlag) Enum.valueOf(RefreshFlag.class, str);
            }

            public static RefreshFlag[] values() {
                return (RefreshFlag[]) $VALUES.clone();
            }
        }

        public /* synthetic */ RefreshSendBtn(int i3, RefreshFlag refreshFlag, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? RefreshFlag.FLAG_IMPLICIT : refreshFlag);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), refreshFlag, Integer.valueOf(i16), defaultConstructorMarker);
        }

        @NotNull
        public final RefreshFlag a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RefreshFlag) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.refreshFlag;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.selectedMediaCount;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshSendBtn)) {
                return false;
            }
            RefreshSendBtn refreshSendBtn = (RefreshSendBtn) other;
            if (this.selectedMediaCount == refreshSendBtn.selectedMediaCount && this.refreshFlag == refreshSendBtn.refreshFlag) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.selectedMediaCount * 31) + this.refreshFlag.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "RefreshSendBtn(selectedMediaCount=" + this.selectedMediaCount + ", refreshFlag=" + this.refreshFlag + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshSendBtn(int i3, @NotNull RefreshFlag refreshFlag) {
            super(null);
            Intrinsics.checkNotNullParameter(refreshFlag, "refreshFlag");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) refreshFlag);
            } else {
                this.selectedMediaCount = i3;
                this.refreshFlag = refreshFlag;
            }
        }
    }

    AIOInputBarCompatUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
