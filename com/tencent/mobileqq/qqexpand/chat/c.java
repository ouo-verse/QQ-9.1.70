package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.c;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u00012\u00020\u0002:\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/c;", "Lcom/tencent/mobileqq/qqexpand/chat/d;", "Lcom/tencent/mobileqq/qqexpand/network/ExpandObserver;", "d", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class c extends ExpandObserver implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J4\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J4\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007JD\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/c$a;", "", "Lcom/tencent/mobileqq/qqexpand/chat/d;", "iBanish", "", "d", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "uinType", "", "frdUin", "e", "Landroid/content/Context;", "context", h.F, "g", "c", "", "suc", "uin", "isUsedUp", "f", "k", "LIMIT_CHAT_LIMIT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.chat.c$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(d iBanish, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(iBanish, "$iBanish");
            iBanish.de();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(d iBanish, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(iBanish, "$iBanish");
            iBanish.i5();
        }

        @JvmStatic
        public final void d(d iBanish) {
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            Dialog B1 = iBanish.B1();
            if (B1 != null) {
                B1.dismiss();
            }
            ReportController.o(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 2, 0, "", "", "", "");
        }

        @JvmStatic
        public final void f(BaseQQAppInterface app, Context context, boolean suc, int uinType, String uin, boolean isUsedUp, d iBanish) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            if ((app instanceof QQAppInterface) && (context instanceof BaseActivity)) {
                if (suc && !Intrinsics.areEqual(BaseActivity.sTopActivity, context)) {
                    ((BaseActivity) context).finish();
                    return;
                }
                if (suc) {
                    BaseActivity baseActivity = (BaseActivity) context;
                    QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getResources().getString(R.string.f198484mu), 1).show(baseActivity.getTitleBarHeight());
                    baseActivity.finish();
                    ReportController.o(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
                } else if (!suc) {
                    if (isUsedUp) {
                        h(app, context, iBanish);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getResources().getString(R.string.f198474mt), 1).show(((BaseActivity) context).getTitleBarHeight());
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
                    QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + suc + " uinType=" + uinType + " uin=" + MobileQQ.getShortUinStr(uin));
                }
                QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + suc + " uinType=" + uinType + " uin=" + MobileQQ.getShortUinStr(uin));
            }
        }

        @JvmStatic
        public final void h(BaseQQAppInterface app, Context context, final d iBanish) {
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || app == null) {
                    return;
                }
                ColdPalaceHelper a16 = ColdPalaceHelper.INSTANCE.a(app);
                String p16 = a16.p(1);
                if (TextUtils.equals(activity.getIntent().getStringExtra("public_fragment_class"), ChatSettingFragment.class.getName())) {
                    QQToast.makeText(context, p16, 1).show();
                } else {
                    Dialog B1 = iBanish.B1();
                    if (B1 != null) {
                        B1.dismiss();
                    }
                    iBanish.Se(DialogUtil.createCustomDialog(context, 230, p16, a16.p(2), R.string.cancel, R.string.f198414mn, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.chat.a
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            c.Companion.i(d.this, dialogInterface, i3);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.chat.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            c.Companion.j(d.this, dialogInterface, i3);
                        }
                    }));
                    Dialog B12 = iBanish.B1();
                    if (B12 != null) {
                        B12.show();
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", iBanish.from(), 0, "", "", "", "");
            }
        }

        @JvmStatic
        public final void k(Context context) {
            ChatFragment chatFragment;
            Intrinsics.checkNotNullParameter(context, "context");
            if (!(context instanceof BaseActivity) || (chatFragment = ((BaseActivity) context).getChatFragment()) == null || chatFragment.qh() == null) {
                return;
            }
            QQToast.makeText(context, context.getResources().getString(R.string.f198684nd), 1).show(chatFragment.qh().o());
        }

        Companion() {
        }

        @JvmStatic
        public final void e(BaseQQAppInterface app, Activity activity, int uinType, String frdUin, d iBanish) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(frdUin, "frdUin");
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            Dialog B1 = iBanish.B1();
            if (B1 != null) {
                B1.dismiss();
            }
            NewReportPlugin.V((BaseActivity) activity, uinType, frdUin, app.getCurrentAccountUin(), "");
            ReportController.o(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
        }

        @JvmStatic
        public final void g(BaseQQAppInterface app, Context context, int uinType, String frdUin, d iBanish) {
            Intrinsics.checkNotNullParameter(frdUin, "frdUin");
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            if (!(context instanceof Activity) || ((Activity) context).isFinishing() || app == null) {
                return;
            }
            Dialog B1 = iBanish.B1();
            if (B1 != null) {
                B1.dismiss();
            }
            ColdPalaceHelper a16 = ColdPalaceHelper.INSTANCE.a(app);
            iBanish.Se(new com.tencent.mobileqq.qqexpand.widget.e(context, app, frdUin, uinType, String.valueOf(iBanish.from())));
            Dialog B12 = iBanish.B1();
            Intrinsics.checkNotNull(B12, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog");
            ((com.tencent.mobileqq.qqexpand.widget.e) B12).Y(a16.p(0));
            ReportController.o(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", iBanish.from(), 0, "", "", "", "");
        }

        @JvmStatic
        public final void c(BaseQQAppInterface app, Context context, int uinType, String frdUin, d iBanish) {
            Intrinsics.checkNotNullParameter(frdUin, "frdUin");
            Intrinsics.checkNotNullParameter(iBanish, "iBanish");
            if (!(context instanceof Activity) || ((Activity) context).isFinishing() || app == null) {
                return;
            }
            ColdPalaceHelper a16 = ColdPalaceHelper.INSTANCE.a(app);
            if (QLog.isColorLevel()) {
                QLog.i("AioLimitColdPalaceHelper", 2, "doOnBanishColdPalaceClick skillTimesLeft:" + a16.getSvrSkillTimesLeft() + " from:" + iBanish.from());
            }
            if (a16.getSvrSkillTimesLeft() <= 0 && a16.getSvrSkillTimesLeft() != Integer.MIN_VALUE) {
                h(app, context, iBanish);
            } else {
                g(app, context, uinType, frdUin, iBanish);
            }
            ReportController.o(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", iBanish.from(), 0, "", "", "", "");
        }
    }
}
