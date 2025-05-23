package com.tencent.mobileqq.app.anim;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseActivityInjectUtil;
import com.tencent.mobileqq.app.anim.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/anim/b;", "", "Landroid/content/Intent;", "intent", "", "type", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "b", "<init>", "()V", "base_activity_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f195265a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195265a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull Intent intent, @NotNull String type) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(type, "type");
        intent.putExtra(QBaseActivity.KEY_TYPE_ACTIVITY_ANIMATION, type);
    }

    @JvmStatic
    public static final void b(@NotNull String type, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Class<a> cls = QBaseActivityInjectUtil.sAnimationSetterClasses.get(type);
        if (cls == null) {
            QLog.w("QActivityAnimationUtil", 1, "[setFinishAnimation] type " + type + " not found");
            return;
        }
        try {
            a.C7373a a16 = cls.newInstance().a();
            activity.overridePendingTransition(a16.a(), a16.b());
        } catch (Exception e16) {
            QLog.w("QActivityAnimationUtil", 1, "[setFinishAnimation] type " + type + " causes exception " + e16);
        }
    }

    @JvmStatic
    public static final void c(@NotNull String type, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Class<a> cls = QBaseActivityInjectUtil.sAnimationSetterClasses.get(type);
        if (cls == null) {
            QLog.w("QActivityAnimationUtil", 1, "[setStartAnimation] type " + type + " not found");
            return;
        }
        try {
            a.C7373a b16 = cls.newInstance().b();
            activity.overridePendingTransition(b16.a(), b16.b());
        } catch (Exception e16) {
            QLog.w("QActivityAnimationUtil", 1, "[setStartAnimation] type " + type + " causes exception " + e16);
        }
    }
}
