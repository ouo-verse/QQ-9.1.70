package com.tencent.mobileqq.qqlive.sail.base;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.widget.floatwindow.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0004J\b\u00100\u001a\u00020\u0006H\u0004J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0013H\u0004J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0004J\u0012\u00106\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u0002H\u0004\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/part/Part;", "", "action", "", "args", "", "handleBroadcastMessage", "", "M9", "L9", "K9", "Landroidx/lifecycle/LifecycleCoroutineScope;", "P9", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "F9", "H9", "", "R9", "", "J9", "C9", "B9", "A9", "E9", "N9", "I9", "G9", "Q9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Y9", "aa", "X9", "u3", "T9", "U9", "V9", "W9", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Z9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "D9", "O9", "resId", "da", "content", "ea", "toastString", "ba", "<init>", "()V", "d", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class c extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/base/c$a;", "", "", "MSG_CHANGE_VIDEO_PLAYER", "Ljava/lang/String;", "MSG_ON_BUS_CONFIG_UPDATE", "MSG_ON_ENTER_ROOM", "MSG_ON_EXIT_ROOM", "MSG_ON_PAGE_IN", "MSG_ON_ROOM_PREPARED", "MSG_ON_START_ROOM", "MSG_PRELOAD_ROOM", "MSG_SEND_GIFT", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.base.c$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Activity this_apply, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QQToast.makeText(this_apply, 1, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Activity this_apply, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        DialogUtil.createCustomDialog(this_apply, 230, (String) null, str, (String) null, "\u786e\u5b9a", (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null).show();
    }

    @NotNull
    public final String A9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        UserInfo j3;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        f F9 = F9();
        if (F9 == null || (b16 = F9.b()) == null || (j3 = b16.j()) == null || (a16 = j3.a()) == null) {
            return "";
        }
        return a16;
    }

    @NotNull
    public final String B9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        UserInfo j3;
        String b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        f F9 = F9();
        if (F9 == null || (b16 = F9.b()) == null || (j3 = b16.j()) == null || (b17 = j3.b()) == null) {
            return "";
        }
        return b17;
    }

    public final long C9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        UserInfo j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        f F9 = F9();
        if (F9 != null && (b16 = F9.b()) != null && (j3 = b16.j()) != null) {
            return j3.f();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final e D9() {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (e) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.context, g.class.getName());
        if (floatingProxyWrapper instanceof g) {
            gVar = (g) floatingProxyWrapper;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return gVar.x0();
    }

    @NotNull
    public final String E9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        String programId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        f F9 = F9();
        if (F9 == null || (b16 = F9.b()) == null || (programId = b16.getProgramId()) == null) {
            return "";
        }
        return programId;
    }

    @Nullable
    public final f F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            RoomViewModel roomViewModel = (RoomViewModel) getViewModel(RoomViewModel.class);
            if (roomViewModel == null) {
                return null;
            }
            return roomViewModel.a2();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|QQLiveBasePart", "getRoom", "error, ", e16);
            return null;
        }
    }

    @NotNull
    public final String G9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        String cover;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        f F9 = F9();
        if (F9 == null || (b16 = F9.b()) == null || (cover = b16.getCover()) == null) {
            return "";
        }
        return cover;
    }

    public final long H9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        f F9 = F9();
        if (F9 != null) {
            return F9.getRoomId();
        }
        return 0L;
    }

    @NotNull
    public final String I9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        String roomName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        f F9 = F9();
        if (F9 == null || (b16 = F9.b()) == null || (roomName = b16.getRoomName()) == null) {
            return "";
        }
        return roomName;
    }

    public final int J9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        f F9 = F9();
        if (F9 != null && (b16 = F9.b()) != null) {
            return b16.getRoomType();
        }
        return 0;
    }

    @NotNull
    public final String K9() {
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo == null || (j3 = loginInfo.j()) == null) {
            return "";
        }
        return j3;
    }

    @NotNull
    public final String L9() {
        String m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo == null || (m3 = loginInfo.m()) == null) {
            return "";
        }
        return m3;
    }

    public final long M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
    }

    public final boolean N9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        f F9 = F9();
        if (F9 != null && (b16 = F9.b()) != null) {
            return b16.g();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(getContext(), g.class.getName());
        if (floatingProxyWrapper != null) {
            floatingProxyWrapper.quitWindowFloat(4);
        }
    }

    @Nullable
    public final LifecycleCoroutineScope P9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LifecycleCoroutineScope) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            Fragment hostFragment = getHostFragment();
            boolean z16 = false;
            if (hostFragment != null && hostFragment.isDetached()) {
                z16 = true;
            }
            if (z16) {
                AegisLogger.INSTANCE.e("Audience|QQLiveBasePart", "hostLifecycleScope", "fragment detached");
                return null;
            }
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            return LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|QQLiveBasePart", "hostLifecycleScope", "error, ", e16);
            return null;
        }
    }

    public final boolean Q9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        f F9 = F9();
        if (F9 != null && (b16 = F9.b()) != null) {
            return b16.c();
        }
        return false;
    }

    public final boolean R9() {
        long j3;
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        f F9 = F9();
        if (F9 != null && (b16 = F9.b()) != null) {
            j3 = b16.e();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) updater);
        } else {
            Intrinsics.checkNotNullParameter(updater, "updater");
        }
    }

    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    public void W9(@Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, args);
        } else {
            V9();
        }
    }

    public void X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public void Y9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public void Z9(@Nullable com.tencent.mobileqq.qqgift.data.service.d data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) data);
        }
    }

    public void aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ba(@Nullable final String toastString) {
        boolean z16;
        final Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) toastString);
            return;
        }
        if (toastString != null && toastString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.base.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.ca(activity, toastString);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void da(int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, resId);
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            ea(activity.getResources().getString(resId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ea(@Nullable final String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) content);
            return;
        }
        final Activity activity = getActivity();
        if (activity != null) {
            if (activity.isFinishing()) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                String logTag = getLogTag();
                Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                companion.i(logTag, "showTipDialog", "the activity is is isFinishing");
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.base.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.ga(activity, content);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        com.tencent.mobileqq.qqgift.data.service.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, args);
            return;
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1996746388:
                    if (action.equals("onBusConfigUpdate")) {
                        Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.ui.busconfig.BusConfigUpdater");
                        S9((com.tencent.mobileqq.qqlive.sail.ui.busconfig.a) args);
                        return;
                    }
                    return;
                case -888861516:
                    if (action.equals("onEnterRoom")) {
                        U9();
                        return;
                    }
                    return;
                case -277951529:
                    if (action.equals("onSendGift")) {
                        if (args instanceof com.tencent.mobileqq.qqgift.data.service.d) {
                            dVar = (com.tencent.mobileqq.qqgift.data.service.d) args;
                        } else {
                            dVar = null;
                        }
                        Z9(dVar);
                        return;
                    }
                    return;
                case -162414811:
                    if (action.equals("onPreloadRoom")) {
                        X9();
                        return;
                    }
                    return;
                case 411125069:
                    if (action.equals("onChangeVideoPlayer")) {
                        T9();
                        return;
                    }
                    return;
                case 647172632:
                    if (action.equals("onExitRoom")) {
                        W9(args);
                        return;
                    }
                    return;
                case 907606455:
                    if (action.equals("onRoomPrepared")) {
                        Y9();
                        return;
                    }
                    return;
                case 1402657491:
                    if (action.equals("onPageIn")) {
                        u3();
                        return;
                    }
                    return;
                case 2134832446:
                    if (action.equals("onStartRoom")) {
                        aa();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            V9();
        }
    }

    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }
}
