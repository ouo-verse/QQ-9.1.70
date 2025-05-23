package cn3;

import androidx.fragment.app.FragmentActivity;
import com.tencent.now.linkpkanchorplay.setting.view.SettingDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static SettingDialog a(FragmentActivity fragmentActivity) {
        SettingDialog settingDialog = new SettingDialog();
        settingDialog.show(fragmentActivity.getSupportFragmentManager(), "pk_setting_dialog");
        return settingDialog;
    }
}
