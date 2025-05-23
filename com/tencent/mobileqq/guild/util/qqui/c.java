package com.tencent.mobileqq.guild.util.qqui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f235607a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f235607a = hashMap;
        hashMap.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, HardCodeUtil.qqStr(R.string.lly));
        hashMap.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, HardCodeUtil.qqStr(R.string.lmc));
        hashMap.put(DeviceInfoUtil.PERMISSION_READ_PHONE, "QQ\u4f7f\u7528\u7535\u8bdd\u6743\u9650\u786e\u5b9a\u672c\u673a\u53f7\u7801\u548c\u8bbe\u5907ID\uff0c\u4ee5\u4fdd\u8bc1\u8d26\u53f7\u767b\u5f55\u7684\u5b89\u5168\u6027\u3002QQ\u4e0d\u4f1a\u62e8\u6253\u5176\u4ed6\u53f7\u7801\u6216\u7ec8\u6b62\u901a\u8bdd\u3002\n" + HardCodeUtil.qqStr(R.string.llk));
        hashMap.put(QQPermissionConstants.Permission.CAMERA, HardCodeUtil.qqStr(R.string.lmo));
        hashMap.put(QQPermissionConstants.Permission.RECORD_AUDIO, HardCodeUtil.qqStr(R.string.llw));
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", HardCodeUtil.qqStr(R.string.llr));
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", HardCodeUtil.qqStr(R.string.llx));
        hashMap.put("android.permission.READ_CALENDAR", HardCodeUtil.qqStr(R.string.f171885ln4));
        hashMap.put(QQPermissionConstants.Permission.WRITE_CALENDAR, HardCodeUtil.qqStr(R.string.f171883ln2));
        hashMap.put(QQPermissionConstants.Permission.SEND_SMS, HardCodeUtil.qqStr(R.string.lmq));
        hashMap.put(QQPermissionConstants.Permission.READ_CONTACTS, HardCodeUtil.qqStr(R.string.lmf));
        hashMap.put(QQPermissionConstants.Permission.WRITE_CONTACTS, HardCodeUtil.qqStr(R.string.lmx));
    }

    public static QQCustomDialog a(Context context, int i3) {
        return c(context, i3, null, null, R.string.cancel, R.string.f171151ok, null, null);
    }

    public static QQCustomDialog b(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(charSequence);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog c(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(i16, onClickListener2);
        qQCustomDialog.setPositiveButton(i17, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }

    public static QQCustomDialog d(Context context, int i3, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return c(context, i3, str, str2, R.string.cancel, R.string.f171151ok, onClickListener, onClickListener2);
    }

    public static QQCustomDialog e(Activity activity, String str, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog c16 = c(activity, 230, null, str, i3, i16, onClickListener, onClickListener2);
        if (c16 != null) {
            ((TextView) c16.findViewById(R.id.bit)).setVisibility(8);
            ((TextView) c16.findViewById(R.id.dialogText)).setMinHeight(bi.b(35));
        }
        return c16;
    }
}
