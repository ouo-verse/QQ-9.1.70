package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.template.IPositionMsgApi;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.upgrade.YybUpgradeDialog;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ak {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f307424a;

        a(int i3) {
            this.f307424a = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f307424a);
        }
    }

    public static QQCustomArkDialogForAio a(Context context, String str, Bundle bundle) {
        QQCustomArkDialogForAio qQCustomArkDialogForAio = new QQCustomArkDialogForAio(context, R.style.qZoneInputDialog);
        qQCustomArkDialogForAio.R(context, bundle);
        qQCustomArkDialogForAio.setTitle(str);
        qQCustomArkDialogForAio.setCanceledOnTouchOutside(true);
        qQCustomArkDialogForAio.setCancelable(true);
        return qQCustomArkDialogForAio;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput] */
    public static QQCustomDialogWtihEmoticonInput b(Context context, String str, Bundle bundle, int i3) {
        Object obj;
        QQCustomArkDialog qQCustomArkDialog;
        if (n(bundle)) {
            IArkQQApi.a templateMsgDialog = ((IArkQQApi) QRoute.api(IArkQQApi.class)).getTemplateMsgDialog(context, R.style.qZoneInputDialog);
            templateMsgDialog.u(context, bundle);
            obj = templateMsgDialog;
        } else if (((IPositionMsgApi) QRoute.api(IPositionMsgApi.class)).isPositionMsg(bundle.getString("appName"))) {
            IArkQQApi.a positionMsgDialog = ((IArkQQApi) QRoute.api(IArkQQApi.class)).getPositionMsgDialog(context, R.style.qZoneInputDialog);
            positionMsgDialog.u(context, bundle);
            obj = positionMsgDialog;
        } else {
            obj = null;
        }
        if (obj instanceof QQCustomDialogWtihEmoticonInput) {
            qQCustomArkDialog = (QQCustomDialogWtihEmoticonInput) obj;
        } else {
            QQCustomArkDialog qQCustomArkDialog2 = new QQCustomArkDialog(context, R.style.qZoneInputDialog);
            qQCustomArkDialog2.M0(context, bundle);
            qQCustomArkDialog = qQCustomArkDialog2;
        }
        qQCustomArkDialog.setTitle(str);
        qQCustomArkDialog.setCanceledOnTouchOutside(false);
        qQCustomArkDialog.setCancelable(true);
        if (i3 > 0) {
            qQCustomArkDialog.r0(i3);
        }
        return qQCustomArkDialog;
    }

    public static QQCustomDialog c(Activity activity, String str, long j3, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        View inflate = activity.getLayoutInflater().inflate(R.layout.f167777gr, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.kfj);
        String g06 = YybUpgradeDialog.g0((float) j3, true, 2);
        if (!TextUtils.isEmpty(g06)) {
            textView.setText(HardCodeUtil.qqStr(R.string.lm5) + g06);
        }
        ((TextView) inflate.findViewById(R.id.dialogText)).setText(str2);
        qQCustomDialog.addView(inflate);
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.llh), onClickListener);
        qQCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.lmt), onClickListener2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static cy d(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        cy cyVar = new cy(context, R.style.qZoneInputDialog);
        cyVar.setContentView(R.layout.f167858jp);
        cyVar.Q(str.replace(HardCodeUtil.qqStr(R.string.lmz), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.qqStr(R.string.llg), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.qqStr(R.string.lmi), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.qqStr(R.string.f171882ln1), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
        cyVar.N(str2.replace(HardCodeUtil.qqStr(R.string.lmh), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.qqStr(R.string.lm7), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.qqStr(R.string.lmp), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.qqStr(R.string.lmw), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0f);
        cyVar.O(R.drawable.b9u, R.string.cancel, onClickListener2);
        cyVar.P(str3.replace(HardCodeUtil.qqStr(R.string.lll), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.qqStr(R.string.f171881ln0), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.qqStr(R.string.f171884ln3), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.qqStr(R.string.lli), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), onClickListener);
        cyVar.setCanceledOnTouchOutside(false);
        return cyVar;
    }

    public static YybUpgradeDialog e(Activity activity, String str, long j3, String str2, CharSequence charSequence) {
        YybUpgradeDialog yybUpgradeDialog = new YybUpgradeDialog(activity);
        yybUpgradeDialog.w0(new QQText(m(str), 3)).q0(new QQText(m(str2), 3)).r0(j3).u0(charSequence);
        yybUpgradeDialog.setCanceledOnTouchOutside(false);
        yybUpgradeDialog.setCancelable(true);
        return yybUpgradeDialog;
    }

    public static void f(View view, int i3) {
        if (view == null || i3 < 0) {
            return;
        }
        view.setOutlineProvider(new a(i3));
        view.setClipToOutline(true);
    }

    public static QQCustomDialogWtihInput g(Context context, int i3, int i16, String str, TextWatcher textWatcher, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialogWtihInput qQCustomDialogWtihInput = new QQCustomDialogWtihInput(context, R.style.qZoneInputDialog);
        qQCustomDialogWtihInput.setContentView(R.layout.e59);
        qQCustomDialogWtihInput.setTitle(i3);
        qQCustomDialogWtihInput.setMessage(i16);
        qQCustomDialogWtihInput.setCanceledOnTouchOutside(false);
        qQCustomDialogWtihInput.setCancelable(true);
        qQCustomDialogWtihInput.Y(textWatcher);
        qQCustomDialogWtihInput.X(str);
        qQCustomDialogWtihInput.setNegativeButton(R.string.cancel, onClickListener2);
        if (onClickListener2 == null) {
            qQCustomDialogWtihInput.W(8);
        }
        qQCustomDialogWtihInput.setPositiveButton(R.string.f171151ok, onClickListener);
        qQCustomDialogWtihInput.show();
        return qQCustomDialogWtihInput;
    }

    public static QQCustomDialogWtihInput h(Context context, int i3, int i16, String str, TextWatcher textWatcher, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialogWtihInput qQCustomDialogWtihInput = new QQCustomDialogWtihInput(context, R.style.qZoneInputDialog);
        qQCustomDialogWtihInput.setContentView(R.layout.e59);
        qQCustomDialogWtihInput.setTitle(i3);
        qQCustomDialogWtihInput.setMessage(i16);
        qQCustomDialogWtihInput.setCanceledOnTouchOutside(false);
        qQCustomDialogWtihInput.setCancelable(true);
        qQCustomDialogWtihInput.Y(textWatcher);
        qQCustomDialogWtihInput.X(str);
        qQCustomDialogWtihInput.setNegativeButton(R.string.f1383609c, onClickListener2);
        qQCustomDialogWtihInput.setPositiveButton(R.string.f1383509b, onClickListener);
        qQCustomDialogWtihInput.show();
        return qQCustomDialogWtihInput;
    }

    public static QQCustomDialogWtihEmoticonInput i(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i3) {
        return j(context, str, str2, str3, onClickListener, onClickListener2, i3, false);
    }

    public static QQCustomDialogWtihEmoticonInput j(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i3, boolean z16) {
        QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = new QQCustomDialogWtihEmoticonInput(context, R.style.qZoneInputDialog);
        qQCustomDialogWtihEmoticonInput.p0(7);
        qQCustomDialogWtihEmoticonInput.u0(z16);
        qQCustomDialogWtihEmoticonInput.setContentView(R.layout.f167864jw);
        qQCustomDialogWtihEmoticonInput.setTitle(str);
        if (i3 != 0) {
            qQCustomDialogWtihEmoticonInput.r0(i3);
        }
        qQCustomDialogWtihEmoticonInput.setMessage(str2);
        qQCustomDialogWtihEmoticonInput.setCanceledOnTouchOutside(false);
        qQCustomDialogWtihEmoticonInput.setCancelable(true);
        qQCustomDialogWtihEmoticonInput.q0(str3);
        qQCustomDialogWtihEmoticonInput.setNegativeButton(R.string.cancel, onClickListener2);
        qQCustomDialogWtihEmoticonInput.setPositiveButton(R.string.a1p, onClickListener);
        qQCustomDialogWtihEmoticonInput.show();
        return qQCustomDialogWtihEmoticonInput;
    }

    public static QQCustomDialogWtihEmoticonInput k(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = new QQCustomDialogWtihEmoticonInput(context, R.style.qZoneInputDialog);
        qQCustomDialogWtihEmoticonInput.setContentView(R.layout.f167864jw);
        qQCustomDialogWtihEmoticonInput.setTitle(str);
        qQCustomDialogWtihEmoticonInput.setMessage(str2);
        qQCustomDialogWtihEmoticonInput.setCanceledOnTouchOutside(false);
        qQCustomDialogWtihEmoticonInput.setCancelable(true);
        qQCustomDialogWtihEmoticonInput.q0(str3);
        qQCustomDialogWtihEmoticonInput.setNegativeButton(R.string.cancel, onClickListener2);
        qQCustomDialogWtihEmoticonInput.setPositiveButton(R.string.a1p, onClickListener);
        qQCustomDialogWtihEmoticonInput.show();
        return qQCustomDialogWtihEmoticonInput;
    }

    public static QQCustomDialogWtihInputAndChoose l(Context context, String str, String str2, String str3, ArrayList<String> arrayList, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i3, boolean z16) {
        QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose = new QQCustomDialogWtihInputAndChoose(context, R.style.qZoneInputDialog);
        qQCustomDialogWtihInputAndChoose.j0(z16);
        qQCustomDialogWtihInputAndChoose.setContentView(R.layout.f167868k1);
        qQCustomDialogWtihInputAndChoose.setTitle(str);
        if (i3 != 0) {
            qQCustomDialogWtihInputAndChoose.i0(i3);
        }
        qQCustomDialogWtihInputAndChoose.setMessage(str2);
        qQCustomDialogWtihInputAndChoose.setMessageCount(str3);
        qQCustomDialogWtihInputAndChoose.f0(arrayList);
        qQCustomDialogWtihInputAndChoose.setCanceledOnTouchOutside(false);
        qQCustomDialogWtihInputAndChoose.setCancelable(true);
        qQCustomDialogWtihInputAndChoose.g0(str4);
        qQCustomDialogWtihInputAndChoose.setNegativeButton(R.string.cancel, onClickListener2);
        qQCustomDialogWtihInputAndChoose.setPositiveButton(R.string.a1p, onClickListener);
        qQCustomDialogWtihInputAndChoose.show();
        return qQCustomDialogWtihInputAndChoose;
    }

    protected static String m(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replace(HardCodeUtil.qqStr(R.string.ln6), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.qqStr(R.string.f171878lm2), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.qqStr(R.string.llj), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.qqStr(R.string.lmb), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
        }
        return null;
    }

    public static boolean n(Bundle bundle) {
        boolean z16;
        boolean z17;
        QQCustomArkDialog.b bVar = new QQCustomArkDialog.b(bundle);
        if (TextUtils.isEmpty(bVar.f307108a) && ((ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class)).isTemplateMsg("com.tencent.structmsg", "", "")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!((ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class)).isTemplateMsg(bVar.f307108a, bVar.f307110c, bVar.f307109b) && !z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        boolean equals = "com.tencent.multimsg".equals(bVar.f307108a);
        if (z17 && !equals) {
            return true;
        }
        return false;
    }
}
