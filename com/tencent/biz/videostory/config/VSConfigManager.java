package com.tencent.biz.videostory.config;

import NS_QQ_STORY_CONFIG.CONFIG$StGetStoryConfigRsp;
import NS_QQ_STORY_CONFIG.CONFIG$StIntConf;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.GetStoryConfigRequest;
import com.tencent.biz.videostory.entrancewidget.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mf0.d;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSConfigManager implements Manager {

    /* renamed from: f, reason: collision with root package name */
    public static String f97064f = "0";

    /* renamed from: h, reason: collision with root package name */
    public static String f97065h = "1";

    /* renamed from: i, reason: collision with root package name */
    public static final String f97066i = HardCodeUtil.qqStr(R.string.vjb);

    /* renamed from: m, reason: collision with root package name */
    private static VSConfigManager f97067m = null;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f97068d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    protected SharedPreferences f97069e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<CONFIG$StGetStoryConfigRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CONFIG$StGetStoryConfigRsp cONFIG$StGetStoryConfigRsp) {
            PBRepeatMessageField<CONFIG$StIntConf> pBRepeatMessageField;
            if (cONFIG$StGetStoryConfigRsp != null && (pBRepeatMessageField = cONFIG$StGetStoryConfigRsp.intConf) != null) {
                VSConfigManager.this.l(pBRepeatMessageField.get());
            }
        }
    }

    VSConfigManager() {
        g();
    }

    private String b() {
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null) {
            return BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        return "";
    }

    public static VSConfigManager c() {
        if (f97067m == null) {
            synchronized (VSConfigManager.class) {
                if (f97067m == null) {
                    f97067m = new VSConfigManager();
                }
            }
        }
        return f97067m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> V f(@NonNull String str, @NonNull V v3) {
        V v16;
        if (v3.getClass() == Integer.class) {
            v16 = (V) Integer.valueOf(this.f97069e.getInt(str, ((Integer) v3).intValue()));
        } else if (v3.getClass() == Long.class) {
            v16 = (V) Long.valueOf(this.f97069e.getLong(str, ((Long) v3).longValue()));
        } else if (v3.getClass() == String.class) {
            v16 = (V) this.f97069e.getString(str, (String) v3);
        } else if (v3.getClass() == Boolean.class) {
            v16 = (V) Boolean.valueOf(this.f97069e.getBoolean(str, ((Boolean) v3).booleanValue()));
        } else {
            throw new IllegalArgumentException("defValue class is not support : " + v3.getClass());
        }
        QLog.i("Q.videostory.config.VSConfigManager", 2, "get value from sp success : K:" + str + ", V : " + v16);
        if (v16 != null && v16.getClass() == v3.getClass()) {
            this.f97068d.put(str, v16);
            return v16;
        }
        return v3;
    }

    private void g() {
        this.f97069e = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.videostory.config.VSConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mf0.a aVar = (mf0.a) am.s().x(411);
                    if (aVar != null) {
                        QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + aVar.toString());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean  ");
                    }
                    d dVar = (d) am.s().x(595);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + dVar);
                    }
                    b.c().k();
                } catch (Throwable th5) {
                    QLog.e("Q.videostory.config.VSConfigManager", 2, "VSConfigManager init error! ", th5);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> void k(String str, V v3) {
        boolean commit;
        if (v3.getClass() == Integer.class) {
            commit = this.f97069e.edit().putInt(str, ((Integer) v3).intValue()).commit();
        } else if (v3.getClass() == Long.class) {
            commit = this.f97069e.edit().putLong(str, ((Long) v3).longValue()).commit();
        } else if (v3.getClass() == String.class) {
            commit = this.f97069e.edit().putString(str, (String) v3).commit();
        } else if (v3.getClass() == Boolean.class) {
            commit = this.f97069e.edit().putBoolean(str, ((Boolean) v3).booleanValue()).commit();
        } else {
            throw new IllegalArgumentException("value class is not support : " + v3.getClass());
        }
        if (!commit) {
            QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into sp error : K:" + str + ", V : " + v3);
            return;
        }
        QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into sp success : K:" + str + ", V : " + v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(List<CONFIG$StIntConf> list) {
        PBStringField pBStringField;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                CONFIG$StIntConf cONFIG$StIntConf = list.get(i3);
                if (cONFIG$StIntConf != null && (pBStringField = cONFIG$StIntConf.key) != null) {
                    String str = pBStringField.get();
                    if (!TextUtils.isEmpty(str) && ("SmartMatchMusicSwitch".equals(str) || IVSConfigManager.SMART_CUT_PIC_INTERVAL.equals(str) || IVSConfigManager.SMART_CUT_PIC_WIDTH.equals(str) || IVSConfigManager.SMART_CUT_PIC_MAX_BYTE.equals(str) || "ShootingResolution".equals(str) || IVSConfigManager.SMART_CUT_PIC_COUNT.equals(str) || IVSConfigManager.SMART_CUT_PIC_QUALITY_AND.equals(str))) {
                        j(str, Long.valueOf(cONFIG$StIntConf.value.get()));
                    }
                }
            }
        }
    }

    public void d() {
        VSNetworkHelper.getInstance().sendRequest(new GetStoryConfigRequest(), new a());
    }

    public <V> V e(@NonNull String str, @NonNull V v3) {
        V v16;
        String str2 = str + "_" + b();
        if (!this.f97068d.containsKey(str2)) {
            return (V) f(str2, v3);
        }
        if (v3.getClass() == Integer.class) {
            v16 = (V) ((Integer) this.f97068d.get(str2));
        } else if (v3.getClass() == Long.class) {
            v16 = (V) ((Long) this.f97068d.get(str2));
        } else if (v3.getClass() == String.class) {
            v16 = (V) ((String) this.f97068d.get(str2));
        } else if (v3.getClass() == Boolean.class) {
            v16 = (V) ((Boolean) this.f97068d.get(str2));
        } else {
            throw new IllegalArgumentException("defValue class is not support : " + v3.getClass());
        }
        QLog.i("Q.videostory.config.VSConfigManager", 2, "get value : K : " + str2 + ", V : " + v16);
        return (v16 == null || v16.getClass() != v3.getClass()) ? v3 : v16;
    }

    public boolean h() {
        boolean booleanValue = ((Boolean) c().e("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.FALSE)).booleanValue();
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyWidgetConfig:" + booleanValue);
        return booleanValue;
    }

    public void i() {
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
        c().j("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <V> void j(String str, V v3) {
        String str2 = str + "_" + b();
        if (v3.getClass() == Integer.class) {
            this.f97068d.put(str2, (Integer) v3);
        } else if (v3.getClass() == Long.class) {
            this.f97068d.put(str2, (Long) v3);
        } else if (v3.getClass() == String.class) {
            this.f97068d.put(str2, (String) v3);
        } else if (v3.getClass() == Boolean.class) {
            this.f97068d.put(str2, (Boolean) v3);
        } else {
            throw new IllegalArgumentException("value class is not support : " + v3.getClass());
        }
        k(str2, v3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
    }
}
