package com.tencent.qqnt.aio.bottombar.sectionbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "", "<init>", "()V", "BusinessUIState", "HideBottomSectionBar", "PostThemeChanged", "ShowBottomSectionBar", "SubmitSection", "SubmitSections", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$BusinessUIState;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$HideBottomSectionBar;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$PostThemeChanged;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$ShowBottomSectionBar;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$SubmitSection;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$SubmitSections;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BottomSectionBarMviUIState implements MviUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$BusinessUIState;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "sectionType", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e", "Lcom/tencent/mvi/base/mvi/MviUIState;", "b", "()Lcom/tencent/mvi/base/mvi/MviUIState;", "sectionUIState", "<init>", "(ILcom/tencent/mvi/base/mvi/MviUIState;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class BusinessUIState extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int sectionType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MviUIState sectionUIState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessUIState(int i3, @NotNull MviUIState sectionUIState) {
            super(null);
            Intrinsics.checkNotNullParameter(sectionUIState, "sectionUIState");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) sectionUIState);
            } else {
                this.sectionType = i3;
                this.sectionUIState = sectionUIState;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.sectionType;
        }

        @NotNull
        public final MviUIState b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MviUIState) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.sectionUIState;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof BusinessUIState)) {
                return false;
            }
            BusinessUIState businessUIState = (BusinessUIState) other;
            if (this.sectionType == businessUIState.sectionType && Intrinsics.areEqual(this.sectionUIState, businessUIState.sectionUIState)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.sectionType * 31) + this.sectionUIState.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "BusinessUIState(sectionType=" + this.sectionType + ", sectionUIState=" + this.sectionUIState + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$HideBottomSectionBar;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class HideBottomSectionBar extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideBottomSectionBar f349781d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65518);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349781d = new HideBottomSectionBar();
            }
        }

        HideBottomSectionBar() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$PostThemeChanged;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class PostThemeChanged extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final PostThemeChanged f349782d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65519);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349782d = new PostThemeChanged();
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$ShowBottomSectionBar;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ShowBottomSectionBar extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowBottomSectionBar f349783d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65520);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349783d = new ShowBottomSectionBar();
            }
        }

        ShowBottomSectionBar() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$SubmitSection;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "d", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "a", "()Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "sectionModel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class SubmitSection extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.bottombar.sectionbar.model.b sectionModel;

        @NotNull
        public final com.tencent.qqnt.aio.bottombar.sectionbar.model.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.aio.bottombar.sectionbar.model.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sectionModel;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitSection) && Intrinsics.areEqual(this.sectionModel, ((SubmitSection) other).sectionModel)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.sectionModel.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SubmitSection(sectionModel=" + this.sectionModel + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState$SubmitSections;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "sectionModelList", "<init>", "(Ljava/util/ArrayList;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class SubmitSections extends BottomSectionBarMviUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> sectionModelList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitSections(@NotNull ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> sectionModelList) {
            super(null);
            Intrinsics.checkNotNullParameter(sectionModelList, "sectionModelList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sectionModelList);
            } else {
                this.sectionModelList = sectionModelList;
            }
        }

        @NotNull
        public final ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sectionModelList;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitSections) && Intrinsics.areEqual(this.sectionModelList, ((SubmitSections) other).sectionModelList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.sectionModelList.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SubmitSections(sectionModelList=" + this.sectionModelList + ")";
        }
    }

    public /* synthetic */ BottomSectionBarMviUIState(DefaultConstructorMarker defaultConstructorMarker) {
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

    BottomSectionBarMviUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
