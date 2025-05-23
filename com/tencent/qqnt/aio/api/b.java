package com.tencent.qqnt.aio.api;

import android.content.res.ColorStateList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0019J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/api/b;", "", "", "type", "", "curFriendUid", "uinType", "", "needImmersive", "", "setInfo", "height", "notifyInputHeightChange", "notifyBackgourndUpdate", "backgroundResume", "backgroundPause", "Lcom/tencent/qqnt/aio/api/b$c;", "listener", "setOnBackgroundChangedListener", "Landroid/content/res/ColorStateList;", "getBgTextColor", "adapter", "setAdapterNavigationBarImmersive", "u4", "a", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: u4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/api/b$a;", "", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f348879a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50480);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348879a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/api/b$c;", "", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface c {
        void a();
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(50486), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f348879a;
        }
    }

    void backgroundPause();

    void backgroundResume();

    @Nullable
    ColorStateList getBgTextColor();

    void notifyBackgourndUpdate();

    void notifyInputHeightChange(int height);

    void setAdapterNavigationBarImmersive(boolean adapter);

    void setInfo(@NotNull String curFriendUid, int uinType, boolean needImmersive);

    void setOnBackgroundChangedListener(@NotNull c listener);

    int type();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.aio.api.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9449b {
        @Nullable
        public static ColorStateList c(@NotNull b bVar) {
            return null;
        }

        public static void g(@NotNull b bVar, @NotNull String curFriendUid, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        }

        public static void h(@NotNull b bVar, @NotNull c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void a(@NotNull b bVar) {
        }

        public static void b(@NotNull b bVar) {
        }

        public static void d(@NotNull b bVar) {
        }

        public static void e(@NotNull b bVar, int i3) {
        }

        public static void f(@NotNull b bVar, boolean z16) {
        }
    }
}
