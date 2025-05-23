package com.tencent.qqnt.aio.activity;

import android.content.Intent;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mvi.base.route.MsgIntent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 !2\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H&J\b\u0010\u0019\u001a\u00020\u0013H&J\b\u0010\u001a\u001a\u00020\u0004H&J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0013H&\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/activity/j;", "", "Landroid/view/View;", "show", "", "hide", "getAIORootView", "", "state", "d", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "a", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", tl.h.F, "g", "", "c", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "isEnable", "b", "f", "clearAIOCache", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "e", "t4", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface j {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: t4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/activity/j$a;", "", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.activity.j$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f348485a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39554);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348485a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39569), (Class<?>) j.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f348485a;
        }
    }

    void a(@NotNull MsgIntent intent);

    void b(boolean isEnable);

    boolean c();

    void clearAIOCache();

    void d(int state);

    boolean e();

    boolean f();

    void g(int state);

    @NotNull
    AIOContact getAIOContact();

    @NotNull
    View getAIORootView();

    void h(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action);

    void hide();

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    @NotNull
    View show();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b {
        public static void a(@NotNull j jVar, int i3, int i16, @Nullable Intent intent) {
        }
    }
}
