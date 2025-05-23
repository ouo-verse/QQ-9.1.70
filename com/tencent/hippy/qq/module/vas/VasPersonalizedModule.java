package com.tencent.hippy.qq.module.vas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper;
import com.tencent.mobileqq.vas.hippy.c;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinEngine;

@HippyNativeModule(name = VasPersonalizedModule.TAG)
/* loaded from: classes7.dex */
public class VasPersonalizedModule extends QQBaseModule {
    static final String TAG = "VasPersonalizedModule";
    private final int BUBBLE;
    private final int CARD;
    private final int COLOR_SCREEN;
    private final int E_MOJI;
    private final int FACE;
    private final int FACE_ADDON;
    private final int FONT;
    private final int FUN_CALL;
    private final int LIKE;
    private final int LISTEN_TOGETHER;
    private final int MAGIC_FONTFont;
    private final String METHOD_SET;
    private final int RED_PACKET;
    private final int THEME;
    private final int THEME_BG;
    private final int TROOP;
    private final c mFunCallHippyHelper;
    private final ThemeChangedBroadcastReceiver mThemeChangedBroadcastReceiver;
    private final VasThemeHippyHelper mThemeHippyHelper;

    /* loaded from: classes7.dex */
    static class ThemeChangedBroadcastReceiver extends BroadcastReceiver {
        ThemeChangedBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VasUtil.getService().getThemeSwitchManager().onPostThemeChanged();
        }
    }

    public VasPersonalizedModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.METHOD_SET = "set";
        this.THEME_BG = 8;
        this.RED_PACKET = 16;
        this.FUN_CALL = 17;
        this.FONT = 5;
        this.CARD = 15;
        this.LIKE = 20;
        this.FACE = 23;
        this.COLOR_SCREEN = 22;
        this.BUBBLE = 2;
        this.THEME = 3;
        this.LISTEN_TOGETHER = 39;
        this.FACE_ADDON = 4;
        this.E_MOJI = 1;
        this.TROOP = 26;
        this.MAGIC_FONTFont = 300;
        ThemeChangedBroadcastReceiver themeChangedBroadcastReceiver = new ThemeChangedBroadcastReceiver();
        this.mThemeChangedBroadcastReceiver = themeChangedBroadcastReceiver;
        BaseApplication.getContext().registerReceiver(themeChangedBroadcastReceiver, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        this.mThemeHippyHelper = new VasThemeHippyHelper(ContextHolder.getAppContext(), getAppInterface(), getActivity());
        this.mFunCallHippyHelper = new c(ContextHolder.getAppContext(), getActivity());
    }

    private void setTheme(long j3, Promise promise) {
        if ("1000".equals(j3 + "")) {
            this.mThemeHippyHelper.g(false, "200", "1000", "0", 0, null, null, 0L, promise);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        BaseApplication.getContext().unregisterReceiver(this.mThemeChangedBroadcastReceiver);
        super.destroy();
    }

    @HippyMethod(name = "set")
    public void set(HippyMap hippyMap, Promise promise) {
        long j3 = hippyMap.getLong("bid");
        long j16 = hippyMap.getLong("itemId");
        int i3 = (int) j3;
        if (i3 != 3) {
            if (i3 == 17) {
                this.mFunCallHippyHelper.a(hippyMap, promise);
                return;
            }
            return;
        }
        setTheme(j16, promise);
    }
}
