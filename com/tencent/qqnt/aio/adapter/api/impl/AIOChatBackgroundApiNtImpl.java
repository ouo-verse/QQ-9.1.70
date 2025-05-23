package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChatBackgroundApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOChatBackgroundApi;", "Landroid/content/Context;", "context", "", "curFriendUid", "", "uinType", "", "needImmersive", "Lcom/tencent/qqnt/aio/adapter/background/a;", "aioCreate", "", "aioResume", "selfUin", "aioDelayLoad", "aioPause", "aioDestroy", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOChatBackgroundApiNtImpl implements IAIOChatBackgroundApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AIOChatBackgroundApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChatBackgroundApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOChatBackgroundApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOChatBackgroundApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    @Nullable
    public com.tencent.qqnt.aio.adapter.background.a aioCreate(@Nullable Context context, @NotNull String curFriendUid, int uinType, boolean needImmersive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.adapter.background.a) iPatchRedirector.redirect((short) 2, this, context, curFriendUid, Integer.valueOf(uinType), Boolean.valueOf(needImmersive));
        }
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        QLog.d(TAG, 1, "AIO CREATE");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioDelayLoad(@NotNull String selfUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) selfUin);
        } else {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            QLog.d(TAG, 1, "AIO DELAY_LOAD");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO DESTROY");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO PAUSE");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void aioResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d(TAG, 1, "AIO RESUME");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    @Nullable
    public ColorStateList getBackgroundTextColor(@NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        return IAIOChatBackgroundApi.a.a(this, str, str2);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    @Nullable
    public String getCurrentChatBackgroundBg(@NotNull String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
        return IAIOChatBackgroundApi.a.b(this, str, i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    @Nullable
    public Drawable getCurrentChatBackgroundDrawable(@NotNull String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
        return IAIOChatBackgroundApi.a.c(this, str, i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public boolean isAvatarBackground(@NotNull String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3)).booleanValue();
        }
        return IAIOChatBackgroundApi.a.d(this, str, i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public boolean isDIYChaTBackground(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        return IAIOChatBackgroundApi.a.e(this, str);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void setImmersiveBottomDrawable(@NotNull ViewGroup viewGroup, @NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) viewGroup, (Object) drawable);
        } else {
            IAIOChatBackgroundApi.a.f(this, viewGroup, drawable);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi
    public void setWindowFit(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
        } else {
            IAIOChatBackgroundApi.a.g(this, activity);
        }
    }
}
