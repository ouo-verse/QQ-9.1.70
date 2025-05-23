package com.tencent.mobileqq.minigame.minigamecenter.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HippyDialogFragment extends DialogFragment {
    private static final float DIALOG_HEIGHT_RATE = 0.92f;
    private static final float DIALOG_WIDTH_RATE = 0.42f;
    private static final String KEY_ORIENTATION = "phone_orientation";
    private static final String KEY_URL = "hippy_url";
    private static final String TAG = "HippyDialogFragment";
    private int mOrientation = 1;
    private String mUrl;

    private CommonHippyFragment getHippyFragment() {
        CommonHippyFragment commonHippyFragment = new CommonHippyFragment();
        Bundle bundle = new OpenHippyInfo(getHippyInfoMap(this.mUrl)).toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("params", bundle);
        commonHippyFragment.setArguments(bundle2);
        return commonHippyFragment;
    }

    public static HashMap<String, String> getHippyInfoMap(String str) {
        String[] split;
        String[] split2;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            split = str.split("\\?");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[getHippyInfoMap], exception:" + e16);
        }
        if (split != null && split.length == 2 && (split2 = split[1].split(ContainerUtils.FIELD_DELIMITER)) != null && split2.length != 0) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    String substring = str2.substring(0, indexOf);
                    String substring2 = str2.substring(indexOf + 1);
                    if ("url".equals(substring)) {
                        substring2 = URLDecoder.decode(substring2, "UTF-8");
                    }
                    hashMap.put(substring, substring2);
                }
            }
            return hashMap;
        }
        return hashMap;
    }

    public static HippyDialogFragment newInstance(String str, int i3) {
        HippyDialogFragment hippyDialogFragment = new HippyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ORIENTATION, i3);
        bundle.putString("hippy_url", str);
        hippyDialogFragment.setArguments(bundle);
        return hippyDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiVisibility() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        dialog.getWindow().getDecorView().setSystemUiVisibility(7942);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            dismiss();
            return null;
        }
        this.mUrl = arguments.getString("hippy_url");
        this.mOrientation = arguments.getInt(KEY_ORIENTATION, 1);
        getDialog().requestWindowFeature(1);
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setBackgroundDrawable(new ColorDrawable());
        View inflate = layoutInflater.inflate(R.layout.f167483dk2, viewGroup, false);
        getChildFragmentManager().beginTransaction().replace(R.id.rcn, getHippyFragment(), "hippy_dialog").commit();
        setStyle(0, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setBackgroundDrawable(new ColorDrawable());
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.mobileqq.minigame.minigamecenter.dialog.HippyDialogFragment.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i3) {
                HippyDialogFragment.this.setUiVisibility();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.mOrientation == 1) {
            attributes.width = -1;
            attributes.height = (int) (getResources().getDisplayMetrics().heightPixels * DIALOG_HEIGHT_RATE);
            attributes.gravity = 80;
            attributes.windowAnimations = R.style.f243400p;
        } else {
            attributes.width = (int) (getResources().getDisplayMetrics().widthPixels * DIALOG_WIDTH_RATE);
            attributes.height = -1;
            attributes.gravity = 85;
            attributes.windowAnimations = R.style.f243410q;
        }
        window.setAttributes(attributes);
        setUiVisibility();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            if (fragmentManager.isStateSaved()) {
                return;
            }
            super.show(fragmentManager, str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "show failed.", e16);
        }
    }
}
