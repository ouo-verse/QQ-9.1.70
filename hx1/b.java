package hx1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements MiniAppLaunchListener {
        a() {
        }

        @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            if (!z16 && bundle != null) {
                QLog.e("GuildRobotTag:RobotPanelUtil", 1, "start mini app fail, errCode : ", Integer.valueOf((int) bundle.getLong("retCode", -1)), " errMsg : ", bundle.getString("errMsg", ""));
            }
        }
    }

    public static boolean a(Context context) {
        boolean z16;
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(context);
        if (sx1.f.f().b().intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotPanelUtil", 2, "isNetWorkEnable:" + isNetworkAvailable + ", isConfigEnable:" + z16);
        }
        if (!isNetworkAvailable || !z16) {
            return false;
        }
        return true;
    }

    public static String b(EditText editText) {
        AtTroopMemberSpan i3;
        if (editText == null || (i3 = so0.c.i(editText)) == null || !(i3 instanceof com.tencent.guild.aio.input.at.utils.b)) {
            return "";
        }
        return ((com.tencent.guild.aio.input.at.utils.b) i3).j();
    }

    public static void c(Activity activity, EditText editText, String str, String str2, boolean z16) {
        SpannableString o16 = com.tencent.guild.aio.input.at.utils.b.o(activity, str, str2, editText, z16);
        QLog.i("GuildRobotTag:RobotPanelUtil", 1, "insertAtSpan: TinyId:" + str + " Name:" + str2 + " SpanString:" + ((Object) o16));
        if (TextUtils.isEmpty(o16)) {
            return;
        }
        QLog.i("GuildRobotTag:RobotPanelUtil", 1, "insertAtSpan invoked. atTag: " + new yo0.a(mo0.a.k(editText.getEditableText(), editText.getSelectionStart(), o16, ""), o16) + " editText: " + editText.getText().toString());
    }

    public static void d(EditText editText, String str) {
        QLog.i("GuildRobotTag:RobotPanelUtil", 1, "insertNormalString(), inputStr:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Editable editableText = editText.getEditableText();
        editableText.insert(editText.getSelectionStart(), str);
        QLog.i("GuildRobotTag:RobotPanelUtil", 1, "insertNormalString() finished. editable: " + ((Object) editableText));
    }

    public static boolean e(String str) {
        return TextUtils.isEmpty(str.trim());
    }

    public static boolean f(String str) {
        return TextUtils.equals(str, "/");
    }

    public static void g(EditText editText) {
        int i3 = 1;
        ap0.f.isSlashPanelOpenFromBtn = true;
        Editable editableText = editText.getEditableText();
        String obj = editableText.toString();
        i(editText);
        if (!e(obj) && !f(obj)) {
            if (com.tencent.mobileqq.guild.robot.utils.a.c(obj)) {
                editableText.clear();
                editableText.insert(0, "/");
                for (String str : obj.replace("/", "").split(" ")) {
                    editableText.insert(i3, str + " ");
                    i3 += str.length();
                }
                return;
            }
            return;
        }
        editableText.clear();
        editableText.insert(0, "/");
    }

    public static void h(ImageView imageView, CommonBotInfo commonBotInfo, boolean z16) {
        Resources resources = imageView.getResources();
        if (z16 && resources != null) {
            Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.qui_time, null);
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(resources.getColor(R.color.qui_common_text_secondary_light), PorterDuff.Mode.SRC_IN));
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            Drawable faceDrawableByUser = ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getFaceDrawableByUser((AppInterface) peekAppRuntime, String.valueOf(commonBotInfo.getUin()));
            if (faceDrawableByUser == null) {
                faceDrawableByUser = imageView.getContext().getDrawable(R.drawable.guild_robot_default_avatar);
            }
            imageView.setImageDrawable(faceDrawableByUser);
        }
    }

    public static void i(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
    }

    public static void j(Context context, String str) {
        cx.a(context, str);
    }

    public static void k(Context context, String str) {
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        if (!iMiniAppService.isMiniAppUrl(str)) {
            QLog.d("GuildRobotTag:RobotPanelUtil", 1, "open robot mini app, url error : ", str);
            return;
        }
        EntryModel entryModel = new EntryModel();
        entryModel.type = -1;
        iMiniAppService.startMiniApp(context, str, 5003, entryModel, new a());
    }

    public static boolean l(String str) {
        if (!str.startsWith(" ")) {
            return false;
        }
        String substring = str.substring(1);
        if (substring.startsWith(" ") || substring.startsWith("\n")) {
            return false;
        }
        return true;
    }
}
