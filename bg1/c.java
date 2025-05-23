package bg1;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    private static String c(IGProSecurityResult iGProSecurityResult) {
        try {
            String optString = new JSONObject(iGProSecurityResult.getStrDetail()).optString("verify_url");
            if (!URLUtil.isValidUrl(optString)) {
                return null;
            }
            return optString;
        } catch (Exception e16) {
            QLog.e("Guild.mnr.ChannelSecurityVerifyUtil", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, String str, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        cx.a(context, str);
    }

    public static void f(final Context context, IGProSecurityResult iGProSecurityResult, int i3, String str) {
        final String c16 = c(iGProSecurityResult);
        if (TextUtils.isEmpty(c16)) {
            SecurityTipHelperKt.J(iGProSecurityResult, context, i3, str);
            return;
        }
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(context, 230).setTitle(context.getString(R.string.f142060ic)).setMessage(context.getString(R.string.f142050ib)).setPositiveButton(R.string.f142570jq, new DialogInterface.OnClickListener() { // from class: bg1.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                c.d(context, c16, dialogInterface, i16);
            }
        }).setNegativeButton(R.string.f140850f3, new DialogInterface.OnClickListener() { // from class: bg1.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                dialogInterface.dismiss();
            }
        });
        negativeButton.setCancelable(true);
        negativeButton.setCanceledOnTouchOutside(true);
        negativeButton.show();
    }

    public static void g(IGProSecurityResult iGProSecurityResult, int i3, String str) {
        f(MobileQQ.sMobileQQ.getResumeActivity(), iGProSecurityResult, i3, str);
    }
}
