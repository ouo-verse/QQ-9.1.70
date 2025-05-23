package cooperation.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IPluginAdapter;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c implements IPluginAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Integer> f390258a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f390258a = hashMap;
        hashMap.put("qzone_plugin.apk", 2);
    }

    public static int a(String str) {
        if (f390258a.get(str) == null) {
            return 1;
        }
        return f390258a.get(str).intValue();
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginAdapter
    public void initSkin(Context context) {
        InitSkin.initSkinTinter();
        InitSkin.initMMKV();
        InitSkin.initSkin(context);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginAdapter
    public void initSkinEngine(Context context) throws Exception {
        InitSkin.initSkinTinter();
        InitSkin.initMMKV();
        SkinEngine.init(context, InitSkin.DRAWABLE_COUNT, InitSkin.FIRST_DRAWABLE_ID, InitSkin.LAST_DRAWABLE_ID, InitSkin.COLOR_COUNT, InitSkin.FIRST_COLOR_ID, InitSkin.LAST_COLOR_ID, null);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginAdapter
    public Object invoke(int i3, Object obj) {
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return null;
                        }
                        return Integer.valueOf(ImmersiveUtils.isSupporImmersive());
                    }
                    if (a((String) obj) <= 1) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                }
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                String str = IPluginAdapterProxy.getProxy().currentUin;
                if (!TextUtils.isEmpty(str)) {
                    String string = application.getSharedPreferences(str, 4).getString("currentThemeId_6.3.5", "1000");
                    if ("1000".equals(string) || "999".equals(string)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
            return ThreadManagerV2.getSubThreadLooper();
        }
        try {
            return Boolean.valueOf(ThemeUtil.isNowThemeIsNight(null, true, null));
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "get isNowThemeIsNight error!", e16);
            return Boolean.FALSE;
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginAdapter
    public boolean isBuiltinPluginAndUpToDay(String str, PluginBaseInfo pluginBaseInfo) {
        return a.b(MobileQQ.sMobileQQ).f(str, pluginBaseInfo);
    }
}
