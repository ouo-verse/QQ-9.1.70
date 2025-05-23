package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop$SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop$SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop$SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop$SQQSHPNewUserRecmd;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcshopCacheTool {

    /* renamed from: k, reason: collision with root package name */
    public static final String f79578k = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";

    /* renamed from: a, reason: collision with root package name */
    EntityManager f79579a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, Friends> f79580b;

    /* renamed from: f, reason: collision with root package name */
    public EcshopReportHandler f79584f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f79585g;

    /* renamed from: h, reason: collision with root package name */
    ShopWebViewFragment f79586h;

    /* renamed from: i, reason: collision with root package name */
    Runnable f79587i = new Runnable() { // from class: com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1
        @Override // java.lang.Runnable
        public void run() {
            List<Entity> rawQuery = DBMethodProxy.rawQuery(EcshopCacheTool.this.f79579a, Friends.class, " SELECT * FROM Friends ", new String[0]);
            EcshopCacheTool.this.f79580b = new HashMap();
            if (rawQuery != null && !rawQuery.isEmpty()) {
                Iterator<Entity> it = rawQuery.iterator();
                while (it.hasNext()) {
                    Friends friends = (Friends) it.next();
                    EcshopCacheTool.this.f79580b.put(friends.uin, friends);
                }
            }
            ShopWebViewFragment shopWebViewFragment = EcshopCacheTool.this.f79586h;
            if (shopWebViewFragment != null && shopWebViewFragment.M != null) {
                shopWebViewFragment.getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar;
                        ShopWebViewFragment shopWebViewFragment2 = EcshopCacheTool.this.f79586h;
                        if (shopWebViewFragment2 != null && (bVar = shopWebViewFragment2.M) != null) {
                            bVar.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    BusinessObserver f79588j = new a();

    /* renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f79582d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f79583e = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    Map<String, Bitmap> f79581c = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            b bVar;
            String string = bundle.getString(WadlProxyConsts.EXTRA_CMD);
            if (z16) {
                try {
                    if ("SQQShopFolderSvc.GetShopBindUin".equals(string)) {
                        byte[] byteArray = bundle.getByteArray("extra_data");
                        qqshop$SQQSHPClientRsp qqshop_sqqshpclientrsp = new qqshop$SQQSHPClientRsp();
                        qqshop_sqqshpclientrsp.mergeFrom(byteArray);
                        List<qqshop$SQQSHPAccoutRelation> list = qqshop_sqqshpclientrsp.bindlist.get();
                        for (int i16 = 0; i16 < list.size(); i16++) {
                            qqshop$SQQSHPAccoutRelation qqshop_sqqshpaccoutrelation = list.get(i16);
                            String valueOf = String.valueOf(qqshop_sqqshpaccoutrelation.puin.get());
                            String valueOf2 = String.valueOf(qqshop_sqqshpaccoutrelation.binduin.get());
                            EcshopCacheTool.this.f79582d.put(valueOf, Integer.valueOf(qqshop_sqqshpaccoutrelation.distance.get()));
                            EcshopCacheTool.this.f79583e.put(valueOf, valueOf2);
                        }
                        ShopWebViewFragment shopWebViewFragment = EcshopCacheTool.this.f79586h;
                        if (shopWebViewFragment != null && (bVar = shopWebViewFragment.M) != null && shopWebViewFragment.N == 1) {
                            bVar.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if ("SQQShopFolderSvc.GetFolderInfo".equals(string)) {
                        byte[] byteArray2 = bundle.getByteArray("extra_data");
                        qqshop$SQQSHPClientRsp qqshop_sqqshpclientrsp2 = new qqshop$SQQSHPClientRsp();
                        qqshop_sqqshpclientrsp2.mergeFrom(byteArray2);
                        if (qqshop_sqqshpclientrsp2.newusrrecmd.has()) {
                            qqshop$SQQSHPNewUserRecmd qqshop_sqqshpnewuserrecmd = qqshop_sqqshpclientrsp2.newusrrecmd.get();
                            if (qqshop_sqqshpnewuserrecmd.recmdflag.has() && qqshop_sqqshpnewuserrecmd.recmdflag.get() == 1) {
                                String str = qqshop_sqqshpnewuserrecmd.recmdurl.get();
                                if (!TextUtils.isEmpty(str) && EcshopCacheTool.this.f79586h != null) {
                                    QLog.i("EcshopCacheTool", 2, "newusrrecmd url:" + str);
                                    Intent intent = new Intent(EcshopCacheTool.this.f79586h.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
                                    intent.putExtra("url", str);
                                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                                    EcshopCacheTool.this.f79586h.startActivity(intent);
                                    EcshopCacheTool.this.f79586h.getQBaseActivity().overridePendingTransition(R.anim.f154424l, 0);
                                    ReportController.o(null, "CliOper", "", "", "Shop_newuser", "Pv_shopnewuserpage", 0, 0, "", "", "", "");
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public EcshopCacheTool(AppInterface appInterface, ShopWebViewFragment shopWebViewFragment) {
        this.f79586h = shopWebViewFragment;
        this.f79579a = appInterface.getEntityManagerFactory().createEntityManager();
        this.f79584f = (EcshopReportHandler) appInterface.getBusinessHandler(BrowserAppInterface.J);
        ThreadManagerV2.post(this.f79587i, 5, null, true);
    }

    public void a() {
        this.f79586h = null;
        this.f79584f = null;
        Map<String, Friends> map = this.f79580b;
        if (map != null) {
            map.clear();
        }
        Map<String, Bitmap> map2 = this.f79581c;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Integer> map3 = this.f79582d;
        if (map3 != null) {
            map3.clear();
        }
        Map<String, String> map4 = this.f79583e;
        if (map4 != null) {
            map4.clear();
        }
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        synchronized (this.f79581c) {
            bitmap = this.f79581c.get(str);
        }
        return bitmap;
    }

    public String c(String str) {
        Map<String, Friends> map;
        Friends friends;
        if (TextUtils.isEmpty(str) || (map = this.f79580b) == null || (friends = map.get(str)) == null) {
            return "";
        }
        return friends.getFriendNick();
    }

    public void d(AppRuntime appRuntime, int i3) {
        qqshop$SQQSHPClientReq qqshop_sqqshpclientreq = new qqshop$SQQSHPClientReq();
        qqshop_sqqshpclientreq.msglistlen.set(i3);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), am.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "SQQShopFolderSvc.GetFolderInfo");
        newIntent.putExtra("extra_data", qqshop_sqqshpclientreq.toByteArray());
        newIntent.putExtra("extra_timeout", 30000L);
        newIntent.setObserver(this.f79588j);
        appRuntime.startServlet(newIntent);
    }

    public void e(AppRuntime appRuntime, List<Long> list, double d16, double d17) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), am.class);
        qqshop$SQQSHPClientReq qqshop_sqqshpclientreq = new qqshop$SQQSHPClientReq();
        qqshop_sqqshpclientreq.puinlist.addAll(list);
        if (!TextUtils.isEmpty(appRuntime.getAccount()) && d16 != 0.0d && d17 != 0.0d) {
            qqshop_sqqshpclientreq.latitude.set(d17);
            qqshop_sqqshpclientreq.longitude.set(d16);
            QLog.i("EcshopCacheTool", 2, "lat:" + d17 + ",lon:" + d16);
        }
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "SQQShopFolderSvc.GetShopBindUin");
        newIntent.putExtra("extra_data", qqshop_sqqshpclientreq.toByteArray());
        newIntent.putExtra("extra_timeout", 30000L);
        newIntent.setObserver(this.f79588j);
        appRuntime.startServlet(newIntent);
    }

    public boolean f(String str) {
        Map<String, Friends> map;
        if (TextUtils.isEmpty(str) || (map = this.f79580b) == null || map.get(str) == null) {
            return false;
        }
        return true;
    }

    public void g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        context.startActivity(intent);
    }

    public void h(Context context, String str) {
        Intent intent = new Intent("action_get_PA_head");
        intent.putExtra("uin", str);
        context.sendBroadcast(intent);
    }

    public void i(String str, Bitmap bitmap) {
        synchronized (this.f79581c) {
            this.f79581c.put(str, bitmap);
        }
    }
}
