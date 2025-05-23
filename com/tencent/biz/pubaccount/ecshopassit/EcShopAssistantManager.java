package com.tencent.biz.pubaccount.ecshopassit;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcShopAssistantManager implements Manager {
    public static final String K;
    public static final String L;
    public static String M;
    public static String N;
    public static HashMap<String, String> P;
    public static HashMap<String, Long> Q;
    public static int R;
    public static final String S;
    public static final String T;
    public static List<String> U;
    public static List<String> V;
    public static String W;
    public static boolean X;
    public static final String Y;
    IFaceDecoder E;
    public long J;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f79570d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f79571e;

    /* renamed from: f, reason: collision with root package name */
    public String f79572f;

    /* renamed from: h, reason: collision with root package name */
    public long f79573h;

    /* renamed from: i, reason: collision with root package name */
    public int f79574i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f79575m;
    public boolean C = false;
    public String[] D = {"https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3"};
    DecodeTaskCompletionListener F = new a();
    public boolean G = false;
    public String H = null;
    public String I = null;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements DecodeTaskCompletionListener {
        a() {
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            if (!TextUtils.isEmpty(str) && bitmap != null) {
                Intent intent = new Intent("action_decode_finish");
                intent.putExtra(MimeHelper.IMAGE_SUBTYPE_BITMAP, bitmap);
                intent.putExtra("uin", str);
                BaseApplication.getContext().sendBroadcast(intent);
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append("shop_assit_banner_json.txt");
        K = sb5.toString();
        L = AppConstants.SDCARD_PATH + ".shop_assit/image/";
        M = "";
        N = "";
        P = new HashMap<>();
        Q = new HashMap<>();
        R = 600000;
        S = BaseApplication.getContext().getFilesDir() + str + "qqshp_client_log_wl_conf.json";
        T = BaseApplication.getContext().getFilesDir() + str + "qqshp_client_log_jd_conf.json";
        U = null;
        V = null;
        X = true;
        Y = BaseApplication.getContext().getFilesDir().getAbsoluteFile() + str + "animConfig/red_packet.png";
    }

    public EcShopAssistantManager(QQAppInterface qQAppInterface) {
        this.f79571e = false;
        this.f79575m = false;
        this.f79570d = qQAppInterface;
        this.f79571e = false;
        this.f79575m = false;
        W = "0";
        this.f79573h = 5000L;
        this.f79574i = 3;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1
            @Override // java.lang.Runnable
            public void run() {
                EcshopReportHandler ecshopReportHandler = (EcshopReportHandler) EcShopAssistantManager.this.f79570d.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                if (ecshopReportHandler != null) {
                    ecshopReportHandler.L2();
                }
                EcShopAssistantManager.this.h();
            }
        }, 5, null, true);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.E = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this.F);
    }

    public static SharedPreferences j() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            account = "noLogin";
        }
        return QMMKV.fromSpAdapter(BaseApplicationImpl.getApplication(), "ecshop_sp" + account, "common_mmkv_configurations");
    }

    public static Drawable l(Context context) {
        if (!TextUtils.isEmpty(N)) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.cj9);
            try {
                return URLDrawable.getDrawable(new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_ICON, N, L + N.split("/")[r2.length - 1]), drawable, drawable);
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                return context.getResources().getDrawable(R.drawable.qvip_aio_shop_assist_tab_icon);
            }
        }
        return context.getResources().getDrawable(R.drawable.qvip_aio_shop_assist_tab_icon);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b6, code lost:
    
        if (r12 > 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dc, code lost:
    
        if (r12.mUnreadNum > 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Intent intent, Context context, int i3) {
        Bundle extras;
        boolean z16;
        RecentUser findRecentUser;
        String str;
        String valueOf;
        if (intent != null && context != null) {
            if (intent.getExtras() == null) {
                extras = new Bundle();
            } else {
                extras = intent.getExtras();
            }
            extras.putParcelableArrayList("datas", (ArrayList) m());
            if (!TextUtils.isEmpty(this.H)) {
                extras.putString("ad_logo", this.H);
            }
            if (!TextUtils.isEmpty(this.I)) {
                extras.putString("ad_jump", this.I);
            }
            long j3 = this.J;
            if (j3 != 0) {
                extras.putLong("ad_id", j3);
            }
            this.G = true;
            extras.putBoolean(TabDataHelper.SCENE_IS_TAB_SHOW, this.f79571e);
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("com.tencent.mobileqq:tool".equals(it.next().processName)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            extras.putBoolean("is_tool_exist", z16);
            extras.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            extras.putStringArray(CoverDBCacheData.URLS, this.D);
            SharedPreferences j16 = j();
            boolean z17 = j16.getBoolean("folder_tab_red", false);
            RecentUserProxy m3 = this.f79570d.getProxyManager().m();
            if (i3 < 0) {
                if (m3 != null && (findRecentUser = m3.findRecentUser(AppConstants.EC_SHOP_ASSISTANT_UIN, AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST)) != null) {
                    RecentBaseData b16 = g.c().b(g.d(findRecentUser.uin, findRecentUser.getType()));
                    if (b16 != null) {
                    }
                }
                extras.putBoolean("hasUnread", z17);
                extras.putLong("last_read_folder", j16.getLong("last_read_folder", 0L));
                extras.putLong("latest_time", j16.getLong("latest_time", 0L));
                extras.putInt("unReadNum", this.f79570d.getMessageFacade().H1());
                extras.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
                Friends u16 = ((FriendsManager) this.f79570d.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(this.f79570d.getCurrentAccountUin());
                String str2 = this.D[1];
                String str3 = "0";
                if (!z17) {
                    str = "0";
                } else {
                    str = "1";
                }
                String addParameter = URLUtil.addParameter(str2, "has_reddot", str);
                if (u16 == null) {
                    valueOf = "0";
                } else {
                    valueOf = String.valueOf((int) u16.gender);
                }
                String addParameter2 = URLUtil.addParameter(addParameter, "gender", valueOf);
                extras.putInt("PUSH_TASK_ID", j16.getInt("PUSH_TASK_ID", 0));
                extras.putString("str_ecshop_diy", j16.getString("str_ecshop_diy", ""));
                extras.putInt("PUSH_TASK_TYPE", j16.getInt("PUSH_TASK_TYPE", 0));
                extras.putString("PUSH_TASK_INFO", j16.getString("PUSH_TASK_INFO", ""));
                extras.putLong("PUSH_RECEIVE_TIME", j16.getLong("PUSH_RECEIVE_TIME", 0L));
                if (!TextUtils.isEmpty(j16.getString("PUSH_JUMP_URL", ""))) {
                    addParameter2 = URLUtil.addParameter(addParameter2, WadlProxyConsts.KEY_JUMP_URL, j16.getString("PUSH_JUMP_URL", ""));
                }
                if (this.C) {
                    str3 = String.valueOf(j16.getInt("FOLDER_MSG_TYPE", -1));
                }
                String addParameter3 = URLUtil.addParameter(URLUtil.addParameter(addParameter2, "type", str3), "taskType", String.valueOf(j16.getInt("PUSH_TASK_TYPE", 0)));
                intent.putExtra("bundle", extras);
                intent.putExtra("url", addParameter3);
            }
        }
    }

    public EcShopData f(String str) {
        return new EcShopData();
    }

    public List<EcShopData> g() {
        return new ArrayList();
    }

    public void h() {
        String str = K;
        File file = new File(str);
        if (file.exists()) {
            String readFileContent = FileUtils.readFileContent(file);
            if (!TextUtils.isEmpty(readFileContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(readFileContent);
                    if (jSONObject.has("shopFolderName")) {
                        M = jSONObject.getString("shopFolderName");
                    }
                    if (jSONObject.has("shopFolderIcon")) {
                        N = jSONObject.getString("shopFolderIcon");
                    }
                    if (jSONObject.has("shopButton")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("shopButton");
                        if (QLog.isColorLevel()) {
                            QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + jSONArray.toString());
                        }
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            this.D[r2.getInt("id") - 1] = ((JSONObject) jSONArray.get(i3)).getString("url");
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", e16);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + str);
    }

    public int i(QQAppInterface qQAppInterface) {
        return 0;
    }

    public EcShopData k() {
        return null;
    }

    public List<RecentShopParcel> m() {
        return new ArrayList();
    }

    public boolean o(String str) {
        List<String> list = U;
        if ((list != null && list.contains(str)) || ServiceAccountFolderManager.j(this.f79570d, str)) {
            return true;
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IFaceDecoder iFaceDecoder = this.E;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.E = null;
        }
    }

    public void s(boolean z16) {
        this.f79571e = z16;
    }

    public void d() {
    }

    public void n() {
    }

    public void e(QQAppInterface qQAppInterface) {
    }

    public void p(String str) {
    }

    public void q(EcShopData ecShopData) {
    }

    public void r(boolean z16) {
    }

    public void t(long j3) {
    }

    public void a(long j3, boolean z16) {
    }

    public void c(MessageRecord messageRecord, QQAppInterface qQAppInterface) {
    }

    public void u(String str, long j3) {
    }
}
