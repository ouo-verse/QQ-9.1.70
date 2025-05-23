package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.activity.ChatSettingActivity;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTitleApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTitleApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "isSupportEar", "isSupportUnreadCount", "Landroid/graphics/drawable/Drawable;", "getRight1Bg", "getRight2Bg", "Landroid/content/Context;", "Landroid/widget/TextView;", "getLyricView", "Landroid/view/Window;", "window", "", "setWindowStyle", "onNickClick", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTitleApiNtImpl implements IAIOTitleApi {
    static IPatchRedirector $redirector_;

    public AIOTitleApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    @NotNull
    public TextView getLyricView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new TextView(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    @NotNull
    public Drawable getRight1Bg(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.qui_chat_settings_icon_navigation_01);
        Intrinsics.checkNotNullExpressionValue(drawable, "getContext().resources.g\u2026tings_icon_navigation_01)");
        return drawable;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    @Nullable
    public Drawable getRight2Bg(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (e16 != 1) {
            if (e16 != 2) {
                return null;
            }
            return BaseApplication.getContext().getResources().getDrawable(R.drawable.qui_daka_icon_navigation_01);
        }
        return BaseApplication.getContext().getResources().getDrawable(R.drawable.qui_telephone_icon_navigation_01);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public boolean isSupportEar(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (e16 == 2 || e16 == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public boolean isSupportUnreadCount(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (context.g().l().getBoolean("key_is_scale_chat", false)) {
            return false;
        }
        if (e16 != 2 && e16 != 1 && e16 != 111 && e16 != 100) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public void onNickClick(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            ((ITitleRight1IvApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITitleRight1IvApi.class)).onRight1IvClick(context, ChatSettingActivity.class);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public void setWindowStyle(@NotNull Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) window);
            return;
        }
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            window.getDecorView().setSystemUiVisibility(9216);
        } catch (Throwable th5) {
            QLog.e("AIOTitleApiNtImpl", 1, "setWindowStyle ", th5);
        }
    }
}
