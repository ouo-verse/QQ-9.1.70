package com.tencent.mobileqq.aio.reserve1.image;

import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "()V", "RemoveFastImage", "ShowFastImage", "Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState$RemoveFastImage;", "Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState$ShowFastImage;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class AIOFastImageUIState implements Reserve1UIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState$RemoveFastImage;", "Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class RemoveFastImage extends AIOFastImageUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RemoveFastImage f193264d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64692);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f193264d = new RemoveFastImage();
            }
        }

        RemoveFastImage() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState$ShowFastImage;", "Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/net/URL;", "d", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "url", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "e", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "recentImage", "<init>", "(Ljava/net/URL;Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class ShowFastImage extends AIOFastImageUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final URL url;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo recentImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowFastImage(@NotNull URL url, @NotNull LocalMediaInfo recentImage) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(recentImage, "recentImage");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) recentImage);
            } else {
                this.url = url;
                this.recentImage = recentImage;
            }
        }

        @NotNull
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.recentImage;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowFastImage)) {
                return false;
            }
            ShowFastImage showFastImage = (ShowFastImage) other;
            if (Intrinsics.areEqual(this.url, showFastImage.url) && Intrinsics.areEqual(this.recentImage, showFastImage.recentImage)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.url.hashCode() * 31) + this.recentImage.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "ShowFastImage(url=" + this.url + ", recentImage=" + this.recentImage + ")";
        }
    }

    public /* synthetic */ AIOFastImageUIState(DefaultConstructorMarker defaultConstructorMarker) {
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

    AIOFastImageUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
