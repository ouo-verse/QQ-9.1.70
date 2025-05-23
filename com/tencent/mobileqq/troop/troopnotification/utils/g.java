package com.tencent.mobileqq.troop.troopnotification.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.common.TroopNotificationErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/utils/g;", "", "", "errCode", "", "b", "", "isSuccess", "successMsg", "", "f", "c", "d", "Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", "result", "bizErrorCode", "e", "Landroid/content/Context;", "context", "tips", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f300931a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/utils/g$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f300932d;

        a(Context context) {
            this.f300932d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            d.f300927a.h(this.f300932d);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
            } else {
                Intrinsics.checkNotNullParameter(ds5, "ds");
                ds5.setUnderlineText(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300931a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(int errCode) {
        String str = TroopNotificationErrorCode.f355701a.a().get(Integer.valueOf(errCode));
        if (str == null) {
            String string = BaseApplication.getContext().getResources().getString(R.string.f180873c9);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026roop_manage_network_desc)");
            return string;
        }
        return str;
    }

    @NotNull
    public final CharSequence a(@NotNull Context context, @NotNull String tips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) tips);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tips, "tips");
        String string = context.getString(R.string.f235707cd);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026p_suspicious_anchor_tips)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tips + " " + string);
        int length = tips.length() + 1;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.qui_common_text_link, null)), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new a(context), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public final void c(boolean isSuccess) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isSuccess);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (isSuccess) {
            String string = context.getResources().getString(R.string.f235137au);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026tification_clear_success)");
            QQToast.makeText(context, 2, string, 0).show();
        } else {
            String string2 = context.getResources().getString(R.string.f235127at);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026otification_clear_failed)");
            QQToast.makeText(context, 1, string2, 0).show();
        }
    }

    public final void d(boolean isSuccess) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isSuccess);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (isSuccess) {
            String string = context.getResources().getString(R.string.f2064258_);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ification_delete_success)");
            QQToast.makeText(context, 2, string, 0).show();
        } else {
            String string2 = context.getResources().getString(R.string.f20641589);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026tification_delete_failed)");
            QQToast.makeText(context, 1, string2, 0).show();
        }
    }

    public final void e(@NotNull TryJoinTroopResult result, int bizErrorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) result, bizErrorCode);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        if (result == TryJoinTroopResult.HAS_JOINED) {
            BaseApplication context = BaseApplication.getContext();
            String string = context.getResources().getString(R.string.fvk);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026R.string.qq_troop_joined)");
            QQToast.makeText(context, 2, string, 0).show();
        }
    }

    public final void f(boolean isSuccess, @NotNull String successMsg, int errCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), successMsg, Integer.valueOf(errCode));
            return;
        }
        Intrinsics.checkNotNullParameter(successMsg, "successMsg");
        BaseApplication context = BaseApplication.getContext();
        if (isSuccess) {
            if (successMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                successMsg = context.getResources().getString(R.string.hei);
                Intrinsics.checkNotNullExpressionValue(successMsg, "context.resources.getStr\u2026qq.qqui.R.string.send_ok)");
            }
            QQToast.makeText(context, 2, successMsg, 0).show();
            return;
        }
        QQToast.makeText(context, 1, b(errCode), 0).show();
    }
}
