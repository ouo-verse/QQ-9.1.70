package com.tencent.comic.hippy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.a;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class BoodoHippyBirdge {
    private static final String TAG = "BoodoHippyBirdge";
    public static boolean sBoodoRuntimeReady;
    public static IBoodoHippyApiBuilder sHippyApiBuilder;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface ICheckPluginListener {
        void onResult(int i3, String str);
    }

    public static boolean checkBoodoRuntimeReady() {
        return sBoodoRuntimeReady;
    }

    public static void checkInitBoodoPluginImpl() {
        try {
            Constructor<?> declaredConstructor = PluginStatic.getOrCreateClassLoader(a.b(), IQQComicPluginUtil.COMIC_PLUGIN_ID).loadClass("com.qqcomic.app.BoodoPluginTask").getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        } catch (IllegalAccessException e17) {
            QLog.e(TAG, 1, e17, new Object[0]);
        } catch (InstantiationException e18) {
            QLog.e(TAG, 1, e18, new Object[0]);
        } catch (Exception e19) {
            QLog.e(TAG, 1, e19, new Object[0]);
        }
    }

    public static void checkPluginInstall(Context context, final ICheckPluginListener iCheckPluginListener) {
        if (MobileQQ.sProcessId != 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkPluginInstall not in ProcessQQ");
            }
            QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "check_qqcomic_plugin", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.comic.hippy.BoodoHippyBirdge.1
                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    Bundle bundle = eIPCResult.data;
                    int i3 = bundle.getInt("retCode");
                    String string = bundle.getString("msg");
                    ICheckPluginListener iCheckPluginListener2 = ICheckPluginListener.this;
                    if (iCheckPluginListener2 != null) {
                        iCheckPluginListener2.onResult(i3, string);
                    }
                }
            });
        } else {
            AppRuntime a16 = a.a();
            checkPluginInstall(context, (a16 == null || !(a16 instanceof BaseQQAppInterface)) ? null : (BaseQQAppInterface) a16, iCheckPluginListener);
        }
    }

    public static void checkStartBoodoHippy(Context context, Bundle bundle) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "checkStartBoodoHippy bundle:" + bundle.toString());
            }
            Intent intent = new Intent(context, (Class<?>) VipComicJumpActivity.class);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jumpto", "com.tencent.hippy.qq.fragment.CommonHippyFragment");
            jSONObject.put("comic", "");
            intent.putExtra("options", jSONObject.toString());
            intent.putExtra("click_start_time", System.currentTimeMillis());
            intent.putExtra("hippy_bundle", bundle);
            context.startActivity(intent);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public static BoodoModuleProxy createBoodoModuleImp() {
        if (sHippyApiBuilder != null) {
            return null;
        }
        QLog.i(TAG, 1, "createBoodoModuleImp");
        return null;
    }

    public static HippyAPIProvider createBoodoProvider() {
        IBoodoHippyApiBuilder iBoodoHippyApiBuilder = sHippyApiBuilder;
        if (iBoodoHippyApiBuilder != null) {
            return iBoodoHippyApiBuilder.createBoodoProvider();
        }
        QLog.i(TAG, 1, "getBoodoProvider");
        return null;
    }

    public static boolean isBoodoModule(String str) {
        return str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_CENTER) || HippyQQConstants.ModuleName.QQ_BOODO_COMIC.equals(str);
    }

    public static void checkPluginInstall(final Context context, final AppRuntime appRuntime, final ICheckPluginListener iCheckPluginListener) {
        if (appRuntime == null) {
            if (iCheckPluginListener != null) {
                iCheckPluginListener.onResult(-1, null);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkPluginInstall");
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.comic.hippy.BoodoHippyBirdge.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (QQComicPluginBridge.e(AppRuntime.this)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(BoodoHippyBirdge.TAG, 2, "plugin is installed.");
                        }
                        ICheckPluginListener iCheckPluginListener2 = iCheckPluginListener;
                        if (iCheckPluginListener2 != null) {
                            iCheckPluginListener2.onResult(0, null);
                        }
                        QQComicPluginBridge.g(context);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(BoodoHippyBirdge.TAG, 2, "wait for plugin installation...");
                    }
                    boolean b16 = QQComicPluginBridge.b(AppRuntime.this, true, null);
                    ICheckPluginListener iCheckPluginListener3 = iCheckPluginListener;
                    if (iCheckPluginListener3 != null) {
                        int i3 = b16 ? 0 : -1;
                        if (!b16) {
                            str = "plugin install failed.";
                        } else {
                            str = "plugin install success";
                        }
                        iCheckPluginListener3.onResult(i3, str);
                    }
                    if (!b16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(BoodoHippyBirdge.TAG, 2, "plugin install failed.");
                        }
                    } else {
                        QQComicPluginBridge.g(context);
                        if (QLog.isColorLevel()) {
                            QLog.d(BoodoHippyBirdge.TAG, 2, "plugin is installed now.");
                        }
                    }
                }
            }, 16, null, false);
        }
    }
}
