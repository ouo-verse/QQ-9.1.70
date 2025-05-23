package com.tencent.mobileqq.notification.modularize;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Landroid/content/Intent;", tl.h.F, "Lcom/tencent/mobileqq/notification/modularize/a;", "button", "Landroid/app/PendingIntent;", "e", "", "url", "d", "b", "", "j", "g", "i", "c", "f", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class BaseJumpScheme {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f254238b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme$a;", "", "", "sCanUsedPackName$delegate", "Lkotlin/Lazy;", "a", "()Z", "sCanUsedPackName", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.modularize.BaseJumpScheme$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) BaseJumpScheme.f254238b.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BaseJumpScheme$Companion$sCanUsedPackName$2.INSTANCE);
        f254238b = lazy;
    }

    public BaseJumpScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Intent h(f pushComponent) {
        Intent intent = SplashActivity.getAliasIntent(BaseApplication.context);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.setFlags(335544320);
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return intent;
    }

    @NotNull
    protected abstract Intent b(@NotNull f pushComponent);

    @NotNull
    public final Intent c(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        if (Intrinsics.areEqual(pushComponent.jumpScheme, "")) {
            return h(pushComponent);
        }
        BaseApplication baseApplication = BaseApplication.context;
        Intent intent = new Intent(baseApplication, (Class<?>) QQBrowserActivity.class);
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuildShareUrl(pushComponent.jumpScheme)) {
            intent = new Intent(baseApplication, (Class<?>) QQBrowserDelegationActivity.class);
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setGuildPginSource(pushComponent.jumpScheme);
        intent.putExtra("url", pushComponent.jumpScheme);
        intent.addFlags(268435456);
        i.b(intent, pushComponent);
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, pushComponent.notifyId);
        return intent;
    }

    @NotNull
    public final Intent d(@NotNull f pushComponent, @NotNull String url) {
        f a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pushComponent, (Object) url);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Intrinsics.checkNotNullParameter(url, "url");
        a16 = pushComponent.a((r39 & 1) != 0 ? pushComponent.mainBusinessId : 0, (r39 & 2) != 0 ? pushComponent.subBusinessId : 0, (r39 & 4) != 0 ? pushComponent.time : 0L, (r39 & 8) != 0 ? pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String : 0, (r39 & 16) != 0 ? pushComponent.notifyId : 0, (r39 & 32) != 0 ? pushComponent.com.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String : 0, (r39 & 64) != 0 ? pushComponent.type : 0, (r39 & 128) != 0 ? pushComponent.title : null, (r39 & 256) != 0 ? pushComponent.iconUrl : null, (r39 & 512) != 0 ? pushComponent.contentText : null, (r39 & 1024) != 0 ? pushComponent.jumpScheme : url, (r39 & 2048) != 0 ? pushComponent.triggerInfo : null, (r39 & 4096) != 0 ? pushComponent.senderIcon : null, (r39 & 8192) != 0 ? pushComponent.from : null, (r39 & 16384) != 0 ? pushComponent.isUrlJump : false, (r39 & 32768) != 0 ? pushComponent.isRevokePush : false, (r39 & 65536) != 0 ? pushComponent.forcePushInfo : null, (r39 & 131072) != 0 ? pushComponent.style : 0, (r39 & 262144) != 0 ? pushComponent.buttons : null, (r39 & 524288) != 0 ? pushComponent.bytesExtData : null);
        return g(a16);
    }

    @NotNull
    public final PendingIntent e(@NotNull f pushComponent, @NotNull a button) {
        f a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pushComponent, (Object) button);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Intrinsics.checkNotNullParameter(button, "button");
        a16 = pushComponent.a((r39 & 1) != 0 ? pushComponent.mainBusinessId : 0, (r39 & 2) != 0 ? pushComponent.subBusinessId : 0, (r39 & 4) != 0 ? pushComponent.time : 0L, (r39 & 8) != 0 ? pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String : 0, (r39 & 16) != 0 ? pushComponent.notifyId : 0, (r39 & 32) != 0 ? pushComponent.com.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String : 0, (r39 & 64) != 0 ? pushComponent.type : 0, (r39 & 128) != 0 ? pushComponent.title : null, (r39 & 256) != 0 ? pushComponent.iconUrl : null, (r39 & 512) != 0 ? pushComponent.contentText : null, (r39 & 1024) != 0 ? pushComponent.jumpScheme : button.url, (r39 & 2048) != 0 ? pushComponent.triggerInfo : null, (r39 & 4096) != 0 ? pushComponent.senderIcon : null, (r39 & 8192) != 0 ? pushComponent.from : null, (r39 & 16384) != 0 ? pushComponent.isUrlJump : false, (r39 & 32768) != 0 ? pushComponent.isRevokePush : false, (r39 & 65536) != 0 ? pushComponent.forcePushInfo : null, (r39 & 131072) != 0 ? pushComponent.style : 0, (r39 & 262144) != 0 ? pushComponent.buttons : null, (r39 & 524288) != 0 ? pushComponent.bytesExtData : null);
        return i(a16);
    }

    @NotNull
    public final Intent f(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(pushComponent.jumpScheme));
        intent.setFlags(335544320);
        i.b(intent, pushComponent);
        if (INSTANCE.a()) {
            intent.setPackage(RFWApplication.getApplication().getPackageName());
        }
        return intent;
    }

    @NotNull
    public final Intent g(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        if (j()) {
            return b(pushComponent);
        }
        return c(pushComponent);
    }

    @NotNull
    public final PendingIntent i(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, pushComponent.notifyId, g(pushComponent), 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(BaseApplicat\u2026ingIntent.FLAG_IMMUTABLE)");
        return activity;
    }

    protected boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
