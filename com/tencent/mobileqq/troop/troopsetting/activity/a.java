package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.ap;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J,\u0010\u0013\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010!\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/a;", "", "Landroid/view/View;", "itemView", "", "memo", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$AppInfo;", "appInfo", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "flag", "wording", "delay", "j", "b", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "i", "f", h.F, "nResID", "nIconType", "g", "originTitle", "", "d", "c", "Lcom/tencent/mobileqq/widget/ap;", "Lcom/tencent/mobileqq/widget/ap;", "getMNotifier", "()Lcom/tencent/mobileqq/widget/ap;", "setMNotifier", "(Lcom/tencent/mobileqq/widget/ap;)V", "mNotifier", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Lmqq/util/WeakReference;", "processDialogRef", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301056a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ap mNotifier;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<QQProgressDialog> processDialogRef;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f301056a = new a();
            processDialogRef = new WeakReference<>(null);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull oidb_0xe83$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        String name = appInfo.name.get();
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        if (name.length() > 4) {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            String substring = name.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            name = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return name;
    }

    @JvmStatic
    public static final void k(@NotNull View itemView, @Nullable String memo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R.id.abv);
        TextView textView2 = (TextView) itemView.findViewById(R.id.i_f);
        if (memo != null && memo.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(itemView.getContext().getString(R.string.esc));
        } else {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(memo);
        }
    }

    @JvmStatic
    public static final void l(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ((TextView) itemView.findViewById(R.id.i_f)).setTextColor(itemView.getResources().getColorStateList(R.color.qui_common_text_secondary));
    }

    @JvmStatic
    public static final void m(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R.id.abv);
        textView.setMaxLines(3);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            b();
            mNotifier = null;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ap apVar = mNotifier;
        if (apVar != null) {
            apVar.b();
        }
    }

    @NotNull
    public final CharSequence c(@Nullable String originTitle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CharSequence) iPatchRedirector.redirect((short) 12, (Object) this, (Object) originTitle);
        }
        if (originTitle == null) {
            return "";
        }
        return originTitle;
    }

    @NotNull
    public final CharSequence d(@Nullable String originTitle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this, (Object) originTitle);
        }
        if (originTitle == null) {
            return "";
        }
        return originTitle;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = processDialogRef.get();
        if (qQProgressDialog != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).hideJuhua(qQProgressDialog, "");
        }
    }

    public final void g(@NotNull Activity activity, int nResID, int nIconType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, Integer.valueOf(nResID), Integer.valueOf(nIconType));
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            new QQToastNotifier(activity).notifyUser(nResID, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, nIconType);
        }
    }

    public final void h(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(activity);
        }
    }

    public final void i(@Nullable QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity);
            return;
        }
        if (qBaseActivity == null) {
            return;
        }
        QQProgressDialog qQProgressDialog = processDialogRef.get();
        if (qQProgressDialog == null) {
            try {
                qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                qQProgressDialog.setMessage(R.string.cpr);
                qQProgressDialog.setBackAndSearchFilter(false);
                processDialogRef = new WeakReference<>(qQProgressDialog);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("", 2, e16.toString());
                    return;
                }
                return;
            }
        }
        qQProgressDialog.show();
    }

    public final void j(@Nullable Activity activity, int flag, @NotNull String wording, int delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, Integer.valueOf(flag), wording, Integer.valueOf(delay));
            return;
        }
        Intrinsics.checkNotNullParameter(wording, "wording");
        if (activity == null) {
            return;
        }
        if (mNotifier == null) {
            mNotifier = new ap(activity);
        }
        ap apVar = mNotifier;
        if (apVar != null) {
            apVar.e(flag, wording, delay);
        }
    }
}
