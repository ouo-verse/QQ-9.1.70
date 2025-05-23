package com.tencent.mobileqq.vipav;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.pb.funcall.VipFunCallAndRing$TSourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f313100d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f313100d = ar.b("shouyouye", "2024-06-04", "vas_bug_move_video_view_hierarchy").isEnable(false);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006c -> B:21:0x007b). Please report as a decompilation issue!!! */
    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        File file = new File(VipFunCallUtil.getFunCallPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!b()) {
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "<<need to copy a default config file.");
            }
            InputStream inputStream = null;
            try {
                try {
                    try {
                        inputStream = qQAppInterface.getApp().getAssets().open("funcall/vipfuncall_config.json");
                        FileUtils.writeFile(VipFunCallUtil.getFunCallPath(), new StringBuffer("config.json"), inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th5) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
    }

    public static VipFullScreenVideoView a(Activity activity, ViewGroup viewGroup, boolean z16) {
        int i3;
        if (activity == null || viewGroup == null) {
            return null;
        }
        View inflate = LayoutInflater.from(VasUtil.getApp().getApplicationContext()).inflate(R.layout.c3d, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        if (activity.isFinishing()) {
            return null;
        }
        View findViewById = viewGroup.findViewById(R.id.f30100nf);
        if (f313100d && findViewById != null) {
            i3 = viewGroup.indexOfChild(findViewById) + 1;
        } else {
            i3 = 0;
        }
        viewGroup.addView(inflate, i3, layoutParams);
        if (QLog.isDevelopLevel()) {
            QLog.i("VipFunCall", 4, "addVideoView");
        }
        return (VipFullScreenVideoView) inflate.findViewById(R.id.f167090kp4);
    }

    private boolean b() {
        return new File(VipFunCallConstants.FUNCALL_CONFIG_FILE).exists();
    }

    public static void c(AppRuntime appRuntime, int i3, Bundle bundle, VipFunCallAndRing$TSourceInfo vipFunCallAndRing$TSourceInfo, boolean z16) {
        int i16;
        int i17;
        String str;
        String str2;
        String str3;
        int i18;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (bundle != null) {
            i17 = bundle.getInt("callId");
            str3 = bundle.getString("name");
            i18 = bundle.getInt(VipFunCallConstants.KEY_RING_ID);
            i16 = bundle.getInt(VipFunCallConstants.KEY_FEET_TYPE);
            str4 = bundle.getString(VipFunCallConstants.KEY_URL_VIDEO);
            str5 = bundle.getString(VipFunCallConstants.KEY_URL_FUZZPIC);
            str6 = bundle.getString(VipFunCallConstants.KEY_URL_PICTURE);
            str2 = bundle.getString(VipFunCallConstants.KEY_URL_RING);
            str = bundle.getString(VipFunCallConstants.KEY_URL_CALL_THUM);
        } else {
            i16 = -1;
            if (vipFunCallAndRing$TSourceInfo != null) {
                str4 = vipFunCallAndRing$TSourceInfo.str_media_url.get();
                str5 = vipFunCallAndRing$TSourceInfo.str_image_url.get();
                str6 = vipFunCallAndRing$TSourceInfo.str_image_url.get();
                str2 = vipFunCallAndRing$TSourceInfo.str_ring_url.get();
                str3 = vipFunCallAndRing$TSourceInfo.str_fc_name.get();
                str = vipFunCallAndRing$TSourceInfo.str_thumb_url.get();
                i17 = i3;
                i18 = 0;
            } else {
                i17 = i3;
                str = null;
                str2 = null;
                str3 = null;
                i18 = 0;
                str4 = null;
                str5 = null;
                str6 = null;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            str7 = str;
            sb5.append("downloadFCSuit callid=");
            sb5.append(i3);
            sb5.append(", ringid=");
            sb5.append(i18);
            sb5.append(", feeType");
            sb5.append(i16);
            sb5.append(", mediaUrl=");
            sb5.append(str4);
            sb5.append(", fuzzImageUrl");
            sb5.append(str5);
            sb5.append(", imageUrl=");
            sb5.append(str6);
            sb5.append(", ringUrl");
            sb5.append(str2);
            sb5.append(", name=");
            sb5.append(str3);
            str8 = str2;
            QLog.d("VipFunCallManager", 2, sb5.toString());
        } else {
            str7 = str;
            str8 = str2;
        }
        if (i17 == 0) {
            return;
        }
        File file = new File(VipFunCallUtil.getFunCallPath() + i3 + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }
        SharedPreferences funCallSP = VipFunCallUtil.getFunCallSP(appRuntime, 0, String.valueOf(i3));
        if (funCallSP != null) {
            SharedPreferences.Editor edit = funCallSP.edit();
            edit.putInt("callId", i17);
            edit.putInt(VipFunCallConstants.KEY_RING_ID, i18);
            if (i16 != 0) {
                edit.putInt(VipFunCallConstants.KEY_FEET_TYPE, i16);
            }
            if (!TextUtils.isEmpty(str3)) {
                edit.putString("name", str3);
            }
            edit.putString("_6", str4);
            edit.putString("_9", str5);
            edit.putString("_7", str6);
            str9 = str8;
            edit.putString("_3", str9);
            edit.putString("_8", str7);
            edit.commit();
        } else {
            str9 = str8;
        }
        SharedPreferences funCallSP2 = VipFunCallUtil.getFunCallSP(appRuntime, 0, null);
        if (funCallSP2 != null) {
            SharedPreferences.Editor edit2 = funCallSP2.edit();
            edit2.putString("_3_" + i18, str9);
            edit2.commit();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
