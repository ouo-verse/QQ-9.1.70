package cooperation.plugin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.ReqUserInfo;
import tencent.im.plugin.ResourceConfig$GetResourceReqInfoV2;
import tencent.im.plugin.ResourceConfig$GetResourceReqV2;
import tencent.im.plugin.ResourceConfig$GetResourceRespInfoV2;
import tencent.im.plugin.ResourceConfig$GetResourceRespV2;

/* loaded from: classes28.dex */
public class PluginUpdater implements Runnable, Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private Context f390246d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f390247e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f390248f;

    /* renamed from: m, reason: collision with root package name */
    private b f390251m;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, PluginInfo> f390250i = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, PluginInfo> f390249h = new HashMap();

    /* loaded from: classes28.dex */
    class a implements BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                ResourceConfig$GetResourceRespV2 resourceConfig$GetResourceRespV2 = new ResourceConfig$GetResourceRespV2();
                try {
                    resourceConfig$GetResourceRespV2.mergeFrom(byteArray);
                    PluginUpdater.this.i(true, 128, resourceConfig$GetResourceRespV2);
                    return;
                } catch (Exception unused) {
                    PluginUpdater.this.i(false, 128, null);
                    return;
                }
            }
            PluginUpdater.this.i(false, 128, null);
        }
    }

    /* loaded from: classes28.dex */
    public interface b {
        boolean h1(PluginInfo pluginInfo);

        void z1(boolean z16);
    }

    public PluginUpdater(Context context, Handler handler) {
        this.f390246d = context;
        this.f390248f = new Handler(handler.getLooper(), this);
        File f16 = f(context);
        boolean d16 = e.d(f16);
        File[] c16 = e.c(f16);
        if (c16 != null) {
            for (File file : c16) {
                if (file.isFile()) {
                    if (d16) {
                        file.delete();
                    } else {
                        PluginInfo a16 = e.a(file);
                        if (a16 != null) {
                            this.f390249h.put(a16.mID, a16);
                        } else {
                            file.delete();
                        }
                    }
                }
            }
        }
        if (d16) {
            e.h(f16);
        }
        QLog.d("plugin_tag", 1, "init plugin updater :" + this.f390249h.size());
    }

    private boolean b(PluginInfo pluginInfo, PluginInfo pluginInfo2) {
        if (pluginInfo == null || pluginInfo2 == null || !"GroupVideo.apk".equals(pluginInfo2.mID)) {
            return false;
        }
        QLog.i("plugin_tag", 1, "checkUpgradeVersion new plugin version: " + pluginInfo.mVersion + " cur plugin version: " + pluginInfo2.mVersion);
        if (StringUtil.isEmpty(pluginInfo.mVersion) || StringUtil.isEmpty(pluginInfo2.mVersion) || pluginInfo.mVersion.split("\\.").length != pluginInfo2.mVersion.split("\\.").length || TroopBarPublishUtils.b(pluginInfo.mVersion, pluginInfo2.mVersion) >= 0) {
            return false;
        }
        return true;
    }

    private void c(ResourceConfig$GetResourceRespV2 resourceConfig$GetResourceRespV2) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        PluginInfo pluginInfo;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
        }
        if (resourceConfig$GetResourceRespV2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "onGetPluginConfig GetResourceRespV2: " + resourceConfig$GetResourceRespV2 + "[add: " + resourceConfig$GetResourceRespV2.addedResInfo.size() + ", remove: " + resourceConfig$GetResourceRespV2.deletedResInfo.size() + ", update: " + resourceConfig$GetResourceRespV2.updatedResInfo.size() + "]");
            }
            PluginBaseInfoHelper.PluginInfoParser pluginInfoParser = new PluginBaseInfoHelper.PluginInfoParser();
            pluginInfoParser.setResultClass(PluginInfo.class);
            ArrayList<String> arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator<ResourceConfig$GetResourceRespInfoV2> it = resourceConfig$GetResourceRespV2.deletedResInfo.get().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().pkgName.get());
            }
            Iterator<ResourceConfig$GetResourceRespInfoV2> it5 = resourceConfig$GetResourceRespV2.addedResInfo.get().iterator();
            while (true) {
                z16 = false;
                if (!it5.hasNext()) {
                    break;
                }
                ResourceConfig$GetResourceRespInfoV2 next = it5.next();
                PluginInfo pluginInfo2 = (PluginInfo) PluginBaseInfoHelper.parseConfig(next.resConf.get(), pluginInfoParser);
                if (pluginInfo2 != null) {
                    pluginInfo2.mType = next.resSubType.get();
                    pluginInfo2.mPackageName = next.pkgName.get();
                    pluginInfo2.mCurVersion = next.newVer.get();
                    pluginInfo2.mState = 0;
                    hashMap.put(pluginInfo2.mID, pluginInfo2);
                }
            }
            for (ResourceConfig$GetResourceRespInfoV2 resourceConfig$GetResourceRespInfoV2 : resourceConfig$GetResourceRespV2.updatedResInfo.get()) {
                PluginInfo pluginInfo3 = (PluginInfo) PluginBaseInfoHelper.parseConfig(resourceConfig$GetResourceRespInfoV2.resConf.get(), pluginInfoParser);
                if (pluginInfo3 != null) {
                    pluginInfo3.mType = resourceConfig$GetResourceRespInfoV2.resSubType.get();
                    pluginInfo3.mPackageName = resourceConfig$GetResourceRespInfoV2.pkgName.get();
                    pluginInfo3.mCurVersion = resourceConfig$GetResourceRespInfoV2.newVer.get();
                    pluginInfo3.mState = 0;
                    hashMap2.put(pluginInfo3.mID, pluginInfo3);
                }
            }
            synchronized (this) {
                Map<String, PluginInfo> map = this.f390249h;
                for (String str6 : arrayList) {
                    Iterator<PluginInfo> it6 = map.values().iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            pluginInfo = it6.next();
                            if (pluginInfo.mPackageName.equals(str6)) {
                                break;
                            }
                        } else {
                            pluginInfo = null;
                            break;
                        }
                    }
                    if (pluginInfo != null) {
                        if (hashMap.containsKey(pluginInfo.mID)) {
                            PluginInfo pluginInfo4 = (PluginInfo) hashMap.get(pluginInfo.mID);
                            hashMap.remove(pluginInfo.mID);
                            hashMap2.put(pluginInfo.mID, pluginInfo4);
                        } else {
                            b bVar = this.f390251m;
                            if (bVar != null && bVar.h1(pluginInfo)) {
                                map.remove(pluginInfo.mID);
                                if (QLog.isColorLevel()) {
                                    QLog.d("plugin_tag", 2, "remove PluginInfo: " + pluginInfo);
                                }
                                z16 = true;
                            }
                        }
                    }
                }
                Iterator it7 = hashMap.keySet().iterator();
                while (it7.hasNext()) {
                    PluginInfo pluginInfo5 = (PluginInfo) hashMap.get((String) it7.next());
                    PluginInfo pluginInfo6 = map.get(pluginInfo5.mID);
                    if (pluginInfo6 == null || (str4 = pluginInfo6.mMD5) == null || !str4.equals(pluginInfo5.mMD5) || ((str5 = pluginInfo6.mURL) != null && pluginInfo5.mForceUrl > 0 && !str5.equals(pluginInfo5.mURL))) {
                        map.put(pluginInfo5.mID, pluginInfo5);
                        if (QLog.isColorLevel()) {
                            QLog.d("plugin_tag", 2, "add PluginInfo: " + pluginInfo5);
                        }
                        z16 = true;
                    }
                }
                Iterator it8 = hashMap2.keySet().iterator();
                while (it8.hasNext()) {
                    PluginInfo pluginInfo7 = (PluginInfo) hashMap2.get((String) it8.next());
                    PluginInfo pluginInfo8 = map.get(pluginInfo7.mID);
                    if (pluginInfo8 != null && (str = pluginInfo8.mMD5) != null && str.equals(pluginInfo7.mMD5) && ((str2 = pluginInfo8.mURL) == null || pluginInfo7.mForceUrl <= 0 || str2.equals(pluginInfo7.mURL))) {
                        if (pluginInfo8.mMD5.equals(pluginInfo7.mMD5) && (str3 = pluginInfo8.mURL) != null && pluginInfo7.mForceUrl <= 0 && !str3.equals(pluginInfo7.mURL)) {
                            pluginInfo8.mPackageName = pluginInfo7.mPackageName;
                            pluginInfo8.mCurVersion = pluginInfo7.mCurVersion;
                            pluginInfo8.mURL = pluginInfo7.mURL;
                        } else {
                            long j3 = pluginInfo8.mCurVersion;
                            long j16 = pluginInfo7.mCurVersion;
                            if (j3 != j16) {
                                pluginInfo8.mCurVersion = j16;
                            }
                        }
                        z16 = true;
                    }
                    map.put(pluginInfo7.mID, pluginInfo7);
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "update PluginInfo: " + pluginInfo7);
                    }
                    z16 = true;
                }
            }
            b bVar2 = this.f390251m;
            if (bVar2 != null) {
                bVar2.z1(true);
            }
            if (this.f390249h.isEmpty()) {
                HashMap<String, String> hashMap3 = new HashMap<>();
                StatisticCollector.fillFailCode(hashMap3, AppSetting.f());
                StatisticCollector.getInstance(this.f390246d).collectPerformance(String.valueOf(resourceConfig$GetResourceRespV2.uin), "pluginUpdateEmpty", false, 0L, 0L, hashMap3, "");
            }
            if (z16) {
                k();
            }
        }
    }

    static File e(Context context) {
        return context.getDir("debug_plugin_info", 0);
    }

    static File f(Context context) {
        return context.getDir("plugin_info", 0);
    }

    public static boolean h(Context context) {
        return new File(e(context), "enableDebug").exists();
    }

    public boolean a(PluginInfo pluginInfo) {
        boolean z16;
        String str;
        if (pluginInfo == null) {
            return false;
        }
        PluginInfo g16 = g(pluginInfo.mID);
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "pre: " + pluginInfo.mMD5);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("new: ");
            if (g16 != null) {
                str = g16.mMD5;
            } else {
                str = null;
            }
            sb5.append(str);
            QLog.d("plugin_tag", 2, sb5.toString());
        }
        if (g16 != null && g16.mMD5.equals(pluginInfo.mMD5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !b(g16, pluginInfo)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginInfo d(String str) {
        return this.f390250i.get(str);
    }

    public PluginInfo g(String str) {
        PluginInfo pluginInfo = this.f390250i.get(str);
        if (!h(this.f390246d) || pluginInfo == null) {
            pluginInfo = this.f390249h.get(str);
        }
        if (pluginInfo == null) {
            pluginInfo = cooperation.plugin.a.b(this.f390246d).a(str);
        }
        QLog.d("plugin_tag", 1, "getPluginNews: " + pluginInfo);
        return pluginInfo;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 2) {
            int i3 = message.arg1;
            boolean z16 = true;
            if (message.arg2 != 1) {
                z16 = false;
            }
            j(z16, i3, (ResourceConfig$GetResourceRespV2) message.obj);
        }
        return false;
    }

    public void i(boolean z16, int i3, ResourceConfig$GetResourceRespV2 resourceConfig$GetResourceRespV2) {
        Message.obtain(this.f390248f, 2, i3, z16 ? 1 : 0, resourceConfig$GetResourceRespV2).sendToTarget();
    }

    public void j(boolean z16, int i3, ResourceConfig$GetResourceRespV2 resourceConfig$GetResourceRespV2) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "onGetPluginConfig: " + z16);
        }
        if (i3 != 128) {
            b bVar = this.f390251m;
            if (bVar != null) {
                bVar.z1(false);
                return;
            }
            return;
        }
        if (z16 && resourceConfig$GetResourceRespV2 != null) {
            c(resourceConfig$GetResourceRespV2);
            this.f390247e = false;
        } else {
            b bVar2 = this.f390251m;
            if (bVar2 != null) {
                bVar2.z1(false);
            }
        }
    }

    public void k() {
        File f16 = f(this.f390246d);
        File[] c16 = e.c(f16);
        if (c16 != null) {
            for (File file : c16) {
                file.delete();
            }
        }
        Iterator<PluginInfo> it = this.f390249h.values().iterator();
        while (it.hasNext()) {
            e.g(it.next(), f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(PluginInfo pluginInfo) {
        if (pluginInfo != null) {
            e.g(pluginInfo, e(this.f390246d));
        }
    }

    public void m(b bVar) {
        this.f390251m = bVar;
    }

    public void n(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "handle getPluginList");
        }
        this.f390247e = true;
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.cType = (byte) 1;
        reqUserInfo.stGps = new GPS();
        reqUserInfo.strAuthName = QQAppInterface.AUTHORIZATION_NAME;
        reqUserInfo.strAuthPassword = QQAppInterface.AUTHORIZATION_PASSWORD;
        reqUserInfo.vCells = new ArrayList<>();
        reqUserInfo.vMacs = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (PluginInfo pluginInfo : this.f390249h.values()) {
            ResourceConfig$GetResourceReqInfoV2 resourceConfig$GetResourceReqInfoV2 = new ResourceConfig$GetResourceReqInfoV2();
            resourceConfig$GetResourceReqInfoV2.state.set(0);
            resourceConfig$GetResourceReqInfoV2.lanType.set(1);
            resourceConfig$GetResourceReqInfoV2.resSubType.set(pluginInfo.mType);
            resourceConfig$GetResourceReqInfoV2.pkgName.set(pluginInfo.mPackageName);
            resourceConfig$GetResourceReqInfoV2.curVer.set(pluginInfo.mCurVersion);
            arrayList.add(resourceConfig$GetResourceReqInfoV2);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "getPluginList Add: " + pluginInfo.mID);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "getPluginList: 128");
        }
        ResourceConfig$GetResourceReqV2 resourceConfig$GetResourceReqV2 = new ResourceConfig$GetResourceReqV2();
        resourceConfig$GetResourceReqV2.appid.set(AppSetting.f());
        resourceConfig$GetResourceReqV2.pluginType.set(128);
        resourceConfig$GetResourceReqV2.reqVer.set(1);
        resourceConfig$GetResourceReqV2.resReqInfo.set(arrayList);
        resourceConfig$GetResourceReqV2.revision.set(AppSetting.f99543c);
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), com.tencent.biz.m.class);
        newIntent.putExtra("cmd", "ResourceConfig.ClientReqV2");
        newIntent.putExtra("data", resourceConfig$GetResourceReqV2.toByteArray());
        newIntent.setObserver(new a());
        qQAppInterface.startServlet(newIntent);
    }

    @Override // java.lang.Runnable
    public void run() {
        ResourceConfig$GetResourceRespV2 resourceConfig$GetResourceRespV2 = new ResourceConfig$GetResourceRespV2();
        resourceConfig$GetResourceRespV2.result.set(0);
        c(resourceConfig$GetResourceRespV2);
    }
}
