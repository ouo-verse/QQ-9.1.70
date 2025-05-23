package com.tencent.mobileqq.poke;

import com.tencent.mobileqq.aio.msglist.holder.component.poke.af;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h implements af {
    static IPatchRedirector $redirector_;
    private static final String[] C;
    private static final int[] D;
    private static final int[] E;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f259060d;

    /* renamed from: e, reason: collision with root package name */
    private static String f259061e;

    /* renamed from: f, reason: collision with root package name */
    private static String f259062f;

    /* renamed from: h, reason: collision with root package name */
    private static final String f259063h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f259064i;

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f259065m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f259060d = false;
        f259061e = "";
        f259062f = "";
        f259063h = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "bigPoke");
        f259064i = false;
        f259065m = new String[]{"/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion"};
        C = new String[]{"/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan"};
        D = new int[]{57, 57, 67, 6, 0, 50, 20};
        E = new int[]{2, 10, 37, 55};
    }

    public static boolean a() {
        File file = new File(af.H3);
        if (file.exists() && file.list() != null) {
            for (int i3 = 0; i3 < 4; i3++) {
                if (!b(i3, af.I3)) {
                    f259064i = false;
                    return false;
                }
            }
            for (int i16 = 0; i16 < 7; i16++) {
                if (!c(i16, af.J3)) {
                    f259064i = false;
                    return false;
                }
            }
            f259064i = true;
            return true;
        }
        f259064i = false;
        return false;
    }

    public static boolean b(int i3, String str) {
        String[] list;
        File file = new File(str + C[i3]);
        int i16 = E[i3];
        try {
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            if (list.length != i16) {
                return false;
            }
            return true;
        } catch (NullPointerException e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("PokeBigResHandler", 2, e16, new Object[0]);
            return false;
        }
    }

    public static boolean c(int i3, String str) {
        File[] listFiles;
        String[] list;
        String str2 = str + f259065m[i3];
        int i16 = D[i3];
        File file = new File(str2);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        if (i3 == 4) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (!file2.getName().contains("dazhao_move")) {
                        if (file2.getName().contains("daozhao_motion")) {
                            String[] list2 = file2.list();
                            if (list2 == null) {
                                return false;
                            }
                            if (list2.length == 29) {
                                continue;
                            }
                        }
                        if (file2.getName().contains("dazhao2_motion") && (list = file2.list()) != null && list.length == 23) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        if (listFiles.length != i16) {
            return false;
        }
        return true;
    }
}
