package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Looper;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h {
    public static void b(String str) {
        AVBizModuleFactory.getModuleByName(str).abandonAVFocus();
        AVBizModuleFactory.removeModuleByName(str);
    }

    public static boolean c(String str, List<String> list) {
        HashMap<Long, String> focusBusiness;
        if (list != null && !list.isEmpty() && (focusBusiness = AVBizModuleFactory.getModuleByName(str).getFocusBusiness()) != null && !focusBusiness.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (focusBusiness.containsValue(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int d(String str) {
        if (!com.tencent.mobileqq.guild.media.core.j.a().isInChannel()) {
            return 0;
        }
        if (!com.tencent.mobileqq.guild.media.core.j.a().K(str)) {
            return 1;
        }
        return 2;
    }

    public static boolean e() {
        return GuildFloatWindowUtils.l();
    }

    public static boolean f(String str) {
        HashMap<Long, String> focusBusiness = AVBizModuleFactory.getModuleByName(str).getFocusBusiness();
        if (focusBusiness != null && !focusBusiness.isEmpty()) {
            return focusBusiness.containsValue(str);
        }
        return false;
    }

    public static int g(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Constants.Business.QQ_RTC);
        if (c(str, arrayList)) {
            return R.string.f148500zr;
        }
        arrayList.clear();
        arrayList.add(Constants.Business.QQ_GUILD_KARAOKE);
        if (c(str, arrayList)) {
            return R.string.f148510zs;
        }
        if (!str.equals(Constants.Business.QQ_GUILD_LIVE_VIEWER)) {
            arrayList.clear();
            arrayList.add(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
            if (c(str, arrayList)) {
                return R.string.f148520zt;
            }
            return 0;
        }
        return 0;
    }

    public static int h(String str) {
        if (Constants.Business.QQ_GUILD.equals(str)) {
            return 2;
        }
        if (!Constants.Business.QQ_GUILD_LIVE_VIEWER.equals(str) && !Constants.Business.QQ_GUILD_LIVE_AUTHOR.equals(str)) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Context context, String str, int i3) {
        QQToast.makeText(context, str, 1).show(i3);
    }

    public static void j(int i3, String str) {
        if (i3 == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Constants.Business.QQ_GUILD);
            if (c(str, arrayList)) {
                l();
                return;
            }
            return;
        }
        if (i3 == 2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Constants.Business.QQ_GUILD_LIVE_VIEWER);
            if (c(str, arrayList2)) {
                k();
                return;
            }
            return;
        }
        if (i3 == 3) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(Constants.Business.QQ_GUILD);
            if (c(str, arrayList3)) {
                l();
            }
            arrayList3.clear();
            arrayList3.add(Constants.Business.QQ_GUILD_LIVE_VIEWER);
            if (c(str, arrayList3)) {
                k();
            }
        }
    }

    public static void k() {
        GLiveChannelCore.f226698a.b("GuildAVPriorityManager. live avfocus exit");
        GuildFloatWindowUtils.p();
    }

    public static void l() {
        com.tencent.mobileqq.guild.media.core.j.a().D("", "GuildAVPriorityManager. media avfocus exit");
        GuildFloatWindowUtils.r();
    }

    public static boolean m(AppRuntime appRuntime, String str, IModule.FocusChangeListener focusChangeListener) {
        IModule moduleByName = AVBizModuleFactory.getModuleByName(str);
        String requestAVFocus = moduleByName.requestAVFocus();
        if (!"true".equals(requestAVFocus)) {
            moduleByName.abandonAVFocus();
            AVBizModuleFactory.removeModuleByName(Constants.Business.QQ_GUILD);
            int g16 = g(requestAVFocus);
            if (g16 != 0) {
                final Context applicationContext = appRuntime.getApplicationContext();
                final String string = applicationContext.getString(g16);
                final int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    QQToast.makeText(applicationContext, string, 1).show(dimensionPixelSize);
                    return false;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.i(applicationContext, string, dimensionPixelSize);
                    }
                });
                return false;
            }
            j(h(str), str);
        }
        moduleByName.setListener(focusChangeListener);
        return true;
    }
}
