package com.tencent.mobileqq.aio.panel.photo;

import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "()V", "ShieldQuality", "UpdateMediaInfo", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState$ShieldQuality;", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState$UpdateMediaInfo;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class PhotoPanelUIState implements PanelUIState {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState$ShieldQuality;", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class ShieldQuality extends PhotoPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShieldQuality f193056d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64500);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f193056d = new ShieldQuality();
            }
        }

        ShieldQuality() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState$UpdateMediaInfo;", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "list", "", "e", "b", "needRefreshMedias", "", "f", "I", "c", "()I", "refreshTag", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class UpdateMediaInfo extends PhotoPanelUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<LocalMediaInfo> list;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<LocalMediaInfo> needRefreshMedias;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int refreshTag;

        public UpdateMediaInfo() {
            this(null, null, 0, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @NotNull
        public final List<LocalMediaInfo> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.list;
        }

        @Nullable
        public final List<LocalMediaInfo> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.needRefreshMedias;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.refreshTag;
        }

        public /* synthetic */ UpdateMediaInfo(List list, List list2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 2) != 0 ? null : list2, (i16 & 4) != 0 ? 0 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, list2, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateMediaInfo(@NotNull List<LocalMediaInfo> list, @Nullable List<LocalMediaInfo> list2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, list, list2, Integer.valueOf(i3));
                return;
            }
            this.list = list;
            this.needRefreshMedias = list2;
            this.refreshTag = i3;
        }
    }

    public /* synthetic */ PhotoPanelUIState(DefaultConstructorMarker defaultConstructorMarker) {
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

    PhotoPanelUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
