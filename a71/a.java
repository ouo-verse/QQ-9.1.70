package a71;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.bc;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcall.g;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.cp;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: a71.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class DialogInterfaceOnClickListenerC0017a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0017a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static void a(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, int i3, boolean z16, String str, String str2) {
        int i16;
        boolean z17;
        int i17;
        boolean z18;
        boolean z19;
        int i18;
        long b16 = QQAudioHelper.b();
        int i19 = sessionInfo.f179555d;
        String str3 = sessionInfo.f179557e;
        long c16 = g.c(str3);
        QLog.w("AIOVideoResultUtil", 1, "showGroupQavActionSheet, avType[" + i3 + "], isVideo[" + z16 + "], msgSelfUin[" + LogUtil.getSafePrintUin(str) + "], uinType[" + i19 + "], groupId[" + str3 + "], curFriendNick[" + sessionInfo.f179563i + "], troopUin[" + sessionInfo.f179559f + "], fromWhere[" + str2 + "], isVideoActionSheetShown[" + bc.p0() + "], seq[" + b16 + "]");
        if (10 == i3) {
            AVNotifyCenter.i Q = qQAppInterface.getAVNotifyCenter().Q(c16, i3);
            if (Q != null && Q.f73809c > 0) {
                i18 = 0;
                z19 = false;
            } else {
                Bundle k3 = cp.k(qQAppInterface, str3);
                z19 = k3.getBoolean("forceDisableInviteBox");
                i18 = k3.getInt("errId", R.string.dec);
            }
            if (z19) {
                DialogUtil.createCustomDialog(context, 230, (String) null, context.getResources().getString(i18), R.string.d_2, R.string.idk, new DialogInterfaceOnClickListenerC0017a(), (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        if (z16) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        if (qQAppInterface.getAVNotifyCenter().g(context, i16, sessionInfo.f179555d, sessionInfo.f179557e) || qQAppInterface.getAVNotifyCenter().h(context, sessionInfo.f179555d, sessionInfo.f179557e, z16)) {
            return;
        }
        if (QQAudioHelper.c(19) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.v4u));
        }
        if (!qQAppInterface.getAVNotifyCenter().Y(b16, str3) && !z17) {
            AVNotifyCenter.i p16 = qQAppInterface.getAVNotifyCenter().p(g.c(str3));
            if (p16 != null && (i17 = p16.f73810d) == i3) {
                if (i17 == 2 && p16.f73812f == 2 && p16.f73813g == 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                VideoStatusTipsBar.n(qQAppInterface, context, i19, str3, i3, z18, str2);
                return;
            }
            VideoMsgTools.z(qQAppInterface, context, i19, str3, sessionInfo.f179563i, z16, str2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MultiAVType", ba.uinType2MultiAVType(i19));
        if (z16) {
            bundle.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, true);
        }
        if (i19 == 1) {
            bundle.putBoolean("enableInvite", cp.g("showGroupQavActionSheet", qQAppInterface, str3));
        }
        bundle.putString("Fromwhere", str2);
        ChatActivityUtils.f0(qQAppInterface, context, i19, str3, true, true, null, bundle);
    }
}
