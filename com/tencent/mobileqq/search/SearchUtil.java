package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchUtil {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f282611a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f282612b = false;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicInteger f282613c = new AtomicInteger(1);

    /* renamed from: d, reason: collision with root package name */
    protected static final HashMap<String, Integer> f282614d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f282623a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z16, b bVar) {
            super(str, z16);
            this.f282623a = bVar;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            String str;
            if (sosoLbsInfo != null) {
                str = SearchUtil.e(sosoLbsInfo);
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.SearchUtil", 2, "getLocationInfoAsync onLocationFinish " + i3, str);
            }
            b bVar = this.f282623a;
            if (bVar != null) {
                bVar.a(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(int i3, String str);
    }

    public static void A(int i3, int i16, com.tencent.mobileqq.search.model.i iVar) {
        if (iVar == null || iVar.l() == null || !iVar.A()) {
            return;
        }
        if (iVar.l().equals(do2.i.f394376m)) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X8009D4E", 0, 0, null, null);
        }
        if (iVar.l().equals(do2.h.D)) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X8009D38", 0, 0, null, null);
        }
        if (iVar.l().equals(com.tencent.mobileqq.search.model.j.C)) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X8009D3C", 0, 0, null, null);
        }
        if (iVar.l().equals(HardCodeUtil.qqStr(R.string.uuc))) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X8009D52", 0, 0, null, null);
        }
    }

    public static void B() {
        f282613c.set(1);
    }

    public static void C(View view, com.tencent.mobileqq.search.model.k kVar) {
        SearchUtils.l1(view, kVar);
    }

    private static void D(b bVar) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("QQSearch", true, bVar));
    }

    public static void b(Object obj, String str, int i3) {
        String str2;
        String str3;
        if (obj instanceof com.tencent.mobileqq.search.model.i) {
            A(0, i3, (com.tencent.mobileqq.search.model.i) obj);
        }
        if (obj instanceof do2.l) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D30", 0, 0, null, null);
        }
        if (!(obj instanceof do2.h)) {
            str2 = "";
            str3 = "all_result";
        } else {
            do2.h hVar = (do2.h) obj;
            if (hVar.o() != null) {
                int size = hVar.o().size();
                if (size > hVar.n()) {
                    size = hVar.n();
                }
                SearchUtils.W0("all_result", "exp_contact", "" + str, "" + size);
            } else {
                SearchUtils.W0("all_result", "exp_contact", "" + str, "0");
            }
            str2 = "";
            str3 = "all_result";
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D36", 0, 0, null, null);
        }
        if (obj instanceof com.tencent.mobileqq.search.model.j) {
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D3A", 0, 0, null, null);
        }
        if (obj instanceof com.tencent.mobileqq.search.ftsmsg.a) {
            com.tencent.mobileqq.search.ftsmsg.a aVar = (com.tencent.mobileqq.search.ftsmsg.a) obj;
            if (aVar.o() != null) {
                int size2 = aVar.o().size();
                if (size2 > aVar.n()) {
                    size2 = aVar.n();
                }
                SearchUtils.W0(str3, "exp_talk", str2 + str, str2 + size2);
            } else {
                SearchUtils.W0(str3, "exp_talk", str2 + str, "0");
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D4C", 0, 0, null, null);
        }
        if (obj instanceof do2.d) {
            do2.d dVar = (do2.d) obj;
            if (dVar.o() != null) {
                int size3 = dVar.o().size();
                if (size3 > dVar.n()) {
                    size3 = dVar.n();
                }
                SearchUtils.W0(str3, "exp_collect", str2 + str, str2 + size3);
            } else {
                SearchUtils.W0(str3, "exp_collect", str2 + str, "0");
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D54", 0, 0, null, null);
        }
        if (obj instanceof do2.e) {
            do2.e eVar = (do2.e) obj;
            if (eVar.o() != null) {
                int size4 = eVar.o().size();
                if (size4 > eVar.n()) {
                    size4 = eVar.n();
                }
                SearchUtils.W0(str3, "exp_file", str2 + str, str2 + size4);
            } else {
                SearchUtils.W0(str3, "exp_file", str2 + str, "0");
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D58", 0, 0, null, null);
        }
        if (obj instanceof do2.m) {
            do2.m mVar = (do2.m) obj;
            if (mVar.o() != null) {
                int size5 = mVar.o().size();
                if (size5 > mVar.n()) {
                    size5 = mVar.n();
                }
                SearchUtils.W0(str3, "exp_discuss", str2 + str, str2 + size5);
            } else {
                SearchUtils.W0(str3, "exp_discuss", str2 + str, "0");
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X800BDC0", 0, 0, null, null);
        }
        if (obj instanceof do2.p) {
            do2.p pVar = (do2.p) obj;
            com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D50", 0, 0, com.tencent.mobileqq.search.util.t.c(pVar.o(), pVar.n()), null);
        }
    }

    public static void c(com.tencent.mobileqq.search.model.x xVar, List<com.tencent.mobileqq.search.model.v> list) {
        int s16 = s();
        com.tencent.mobileqq.search.model.i iVar = new com.tencent.mobileqq.search.model.i(xVar);
        xVar.j(s16);
        iVar.j(s16);
        list.add(iVar);
        list.add(xVar);
    }

    public static int d(int i3, int i16) {
        if (Color.alpha(i3) == 0) {
            return i3;
        }
        float alpha = Color.alpha(i3) / 255.0f;
        float alpha2 = Color.alpha(i16) / 255.0f;
        float f16 = 1.0f - alpha;
        return Color.argb((int) (((alpha2 * f16) + alpha) * 255.0f), (int) ((Color.red(i3) * alpha) + (Color.red(i16) * alpha2 * f16)), (int) ((Color.green(i3) * alpha) + (Color.green(i16) * alpha2 * f16)), (int) ((Color.blue(i3) * alpha) + (Color.blue(i16) * alpha2 * f16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String e(SosoLbsInfo sosoLbsInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat02);
            jSONObject.put("lon", sosoLbsInfo.mLocation.mLon02);
            jSONObject.put("nation", f(sosoLbsInfo.mLocation.nation));
            jSONObject.put("province", f(sosoLbsInfo.mLocation.province));
            jSONObject.put("city", f(sosoLbsInfo.mLocation.city));
            jSONObject.put("adcode", f(sosoLbsInfo.mLocation.cityCode));
            jSONObject.put("district", f(sosoLbsInfo.mLocation.district));
            jSONObject.put("town", f(sosoLbsInfo.mLocation.town));
            jSONObject.put("village", f(sosoLbsInfo.mLocation.village));
            jSONObject.put("street", f(sosoLbsInfo.mLocation.street));
            jSONObject.put("streetNo", f(sosoLbsInfo.mLocation.streetNo));
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("Q.uniteSearch.SearchUtil", 1, "getLbsInfo Failed!", e16);
            return "";
        }
    }

    private static String f(String str) {
        if (str != null && !"Unknown".equals(str)) {
            return str;
        }
        return "";
    }

    public static <E> boolean g(List<E> list, List<E> list2, @NonNull Comparator<E> comparator) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        ListIterator<E> listIterator = list.listIterator();
        ListIterator<E> listIterator2 = list2.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            E next = listIterator.next();
            E next2 = listIterator2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (comparator.compare(next, next2) != 0) {
                return false;
            }
        }
        if (!listIterator.hasNext() && !listIterator2.hasNext()) {
            return true;
        }
        return false;
    }

    public static void h(Intent intent, ForwardBaseOption forwardBaseOption) {
        boolean z16;
        if (intent != null && forwardBaseOption != null) {
            String stringExtra = intent.getStringExtra("contactSearchResultUin");
            String stringExtra2 = intent.getStringExtra("contactSearchResultTroopUin");
            int intExtra = intent.getIntExtra("contactSearchResultUinType", 0);
            String stringExtra3 = intent.getStringExtra("contactSearchResultName");
            int intValue = com.tencent.mobileqq.forward.e.N3.intValue();
            int intExtra2 = intent.getIntExtra("chooseFriendFrom", 0);
            if (intExtra != 56938) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((forwardBaseOption instanceof ForwardShareCardOption) && intent.hasExtra("contactSearchResultPhoneContactMobileCode") && intExtra != 1006) {
                stringExtra = intent.getStringExtra("contactSearchResultPhoneContactMobileCode");
                intExtra = 1006;
            }
            if (intExtra != 0) {
                if (intExtra != 1) {
                    if (intExtra != 1004) {
                        if (intExtra != 1006) {
                            if (intExtra != 3000) {
                                if (intExtra == 56938) {
                                    intValue = com.tencent.mobileqq.forward.e.U3.intValue();
                                }
                            } else {
                                intValue = com.tencent.mobileqq.forward.e.Q3.intValue();
                            }
                        } else {
                            intValue = com.tencent.mobileqq.forward.e.U3.intValue();
                        }
                    } else {
                        intValue = com.tencent.mobileqq.forward.e.V3.intValue();
                    }
                } else {
                    intValue = com.tencent.mobileqq.forward.e.P3.intValue();
                }
            } else {
                intValue = com.tencent.mobileqq.forward.e.O3.intValue();
            }
            if (!StringUtil.isEmpty(stringExtra)) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", stringExtra);
                bundle.putInt("uintype", intExtra);
                bundle.putString("uinname", stringExtra3);
                bundle.putString("troop_uin", stringExtra2);
                bundle.putInt("chooseFriendFrom", intExtra2);
                bundle.putBoolean(AppConstants.Key.BIND_CONTACT, z16);
                boolean booleanExtra = intent.getBooleanExtra("choose_friend_needConfirm", false);
                if (booleanExtra) {
                    String stringExtra4 = intent.getStringExtra("choose_friend_confirmTitle");
                    String stringExtra5 = intent.getStringExtra("choose_friend_confirmContent");
                    bundle.putBoolean("choose_friend_needConfirm", booleanExtra);
                    bundle.putString("choose_friend_confirmTitle", stringExtra4);
                    bundle.putString("choose_friend_confirmContent", stringExtra5);
                }
                forwardBaseOption.buildForwardDialog(intValue, bundle);
                forwardBaseOption.reportOnSearch();
            }
        }
    }

    public static void i(final AppInterface appInterface, final String str, final String str2, final List<String> list, final String str3, final Rect rect, final SearchUtils.a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.SearchUtil.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String md5 = MD5Utils.toMD5(str);
                    int i3 = 0;
                    if (BaseImageUtil.isGifFile(str)) {
                        com.tencent.mobileqq.activity.aio.zhitu.a aVar2 = new com.tencent.mobileqq.activity.aio.zhitu.a(new File(str), false, 0.0f);
                        g.a m3 = com.tencent.mobileqq.activity.aio.zhitu.g.l().m(aVar2.getWidth(), aVar2.getHeight(), str2, list, str3, rect, 1, MD5Utils.toMD5(str), 0, Typeface.DEFAULT);
                        aVar2.f(m3);
                        com.tencent.mobileqq.activity.aio.zhitu.c cVar = new com.tencent.mobileqq.activity.aio.zhitu.c();
                        cVar.f180385d = m3;
                        cVar.f180392k = true;
                        cVar.f180384c = str;
                        cVar.f180386e = true;
                        cVar.f180387f = md5;
                        cVar.f180388g = 0;
                        cVar.f180389h = md5;
                        String z16 = ZhituManager.I(appInterface).z(cVar);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.uniteSearch.SearchUtil", 2, "generateGiftWithText: " + z16);
                        }
                        aVar.a(z16);
                        return;
                    }
                    Bitmap copy = BitmapFactory.decodeFile(str).copy(Bitmap.Config.ARGB_8888, true);
                    Rect rect2 = new Rect(0, 0, copy.getWidth(), copy.getHeight());
                    g.a m16 = com.tencent.mobileqq.activity.aio.zhitu.g.l().m(copy.getWidth(), copy.getHeight(), str2, list, str3, rect, 1, MD5Utils.toMD5(str), 0, Typeface.DEFAULT);
                    Canvas canvas = new Canvas(copy);
                    while (true) {
                        float[] fArr = m16.f180409a;
                        if (i3 < fArr.length) {
                            float f16 = rect2.top + fArr[i3];
                            if (m16.f180412d != null) {
                                canvas.drawText(m16.f180410b[i3], rect2.exactCenterX(), f16, m16.f180412d);
                            }
                            canvas.drawText(m16.f180410b[i3], rect2.exactCenterX(), f16, m16.f180411c);
                            i3++;
                        } else {
                            String str4 = str + "_" + System.currentTimeMillis();
                            BitmapUtils.saveBitmapToFile(copy, str4);
                            aVar.a(str4);
                            return;
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("Q.uniteSearch.SearchUtil", 2, "generateGiftWithText: " + e16);
                    aVar.a(null);
                } catch (OutOfMemoryError e17) {
                    QLog.e("Q.uniteSearch.SearchUtil", 2, "generateGiftWithText: " + e17);
                    aVar.a(null);
                }
            }
        }, 8, null, true);
    }

    public static String j() {
        String accountId = VSNetworkHelper.getInstance().getNetworkImpl().getAccountId();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.nanoTime());
        sb5.append(accountId);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    public static long[] k(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            jArr[i3] = list.get(i3).longValue();
        }
        return jArr;
    }

    public static List<com.tencent.mobileqq.search.model.v> l(List<com.tencent.mobileqq.search.model.x> list, boolean z16) {
        return n(list, z16, false, true);
    }

    public static List<com.tencent.mobileqq.search.model.v> m(List<com.tencent.mobileqq.search.model.x> list, boolean z16, boolean z17) {
        return n(list, z16, z17, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<com.tencent.mobileqq.search.model.v> n(List<? extends com.tencent.mobileqq.search.model.x> list, boolean z16, boolean z17, boolean z18) {
        ?? r112;
        int i3;
        ArrayList arrayList;
        List<com.tencent.mobileqq.search.model.y> o16;
        String str;
        boolean z19;
        ArrayList arrayList2;
        String str2;
        int valueOf;
        if (list == null) {
            QLog.d("Q.uniteSearch.SearchUtil", 2, "getItemListFromGroupResult  result is null.");
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (com.tencent.mobileqq.search.model.x xVar : list) {
            if (xVar instanceof lo2.b) {
                lo2.b bVar = (lo2.b) xVar;
                Integer num = (Integer) hashMap.get(Long.valueOf(bVar.D));
                if (num == null) {
                    valueOf = 1;
                } else {
                    valueOf = Integer.valueOf(num.intValue() + 1);
                }
                hashMap.put(Long.valueOf(bVar.D), valueOf);
            }
        }
        hashMap.size();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(hashMap.keySet());
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        SearchUtils.f284964m.clear();
        String str3 = "";
        for (com.tencent.mobileqq.search.model.x xVar2 : list) {
            if (xVar2 instanceof lo2.b) {
                lo2.b bVar2 = (lo2.b) xVar2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = bVar2.m();
                }
                if (z18) {
                    if (z16) {
                        if (SearchUtils.D0(bVar2.D)) {
                            arrayList5.add(Long.valueOf(bVar2.D));
                            if (bVar2.o() != null) {
                                int i16 = 0;
                                while (i16 < bVar2.o().size()) {
                                    com.tencent.mobileqq.search.model.y yVar = bVar2.o().get(i16);
                                    SearchUtils.d dVar = new SearchUtils.d();
                                    dVar.f284976a = str3;
                                    boolean z26 = yVar instanceof lo2.m;
                                    if (z26) {
                                        arrayList2 = arrayList7;
                                        dVar.f284977b = ((lo2.m) yVar).J;
                                    } else {
                                        arrayList2 = arrayList7;
                                        if (yVar instanceof lo2.c) {
                                            dVar.f284977b = ((lo2.c) yVar).J();
                                        } else {
                                            dVar.f284977b = bVar2.D;
                                        }
                                    }
                                    i16++;
                                    dVar.f284978c = i16;
                                    dVar.f284979d = false;
                                    boolean z27 = yVar instanceof lo2.c;
                                    if (z27) {
                                        str2 = ((lo2.c) yVar).H;
                                    } else if (!z26) {
                                        str2 = "";
                                    } else {
                                        str2 = ((lo2.m) yVar).G;
                                    }
                                    dVar.f284980e = str2;
                                    dVar.f284981f = f282611a;
                                    SearchUtils.f284964m.put(yVar, dVar);
                                    if (z27) {
                                        ((lo2.c) yVar).A0 = bVar2.P;
                                    }
                                    arrayList7 = arrayList2;
                                }
                            }
                        } else {
                            f282612b = f282611a;
                            arrayList6.add(Long.valueOf(bVar2.D));
                            arrayList = arrayList7;
                        }
                    } else {
                        arrayList = arrayList7;
                        arrayList.add(Long.valueOf(bVar2.D));
                    }
                    o16 = bVar2.o();
                    if (o16.size() > 0) {
                        int s16 = s();
                        if (TextUtils.isEmpty(bVar2.x()) && !u(bVar2)) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        boolean z28 = bVar2.N;
                        boolean z29 = !TextUtils.isEmpty(bVar2.J);
                        bVar2.j(s16);
                        com.tencent.mobileqq.search.model.i iVar = new com.tencent.mobileqq.search.model.i(bVar2, z19, z28);
                        iVar.E(!bVar2.M);
                        iVar.j(s16);
                        arrayList3.add(iVar);
                        int size = o16.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            com.tencent.mobileqq.search.model.y yVar2 = o16.get(i17);
                            yVar2.j(s16);
                            if (yVar2 instanceof lo2.c) {
                                lo2.c cVar = (lo2.c) yVar2;
                                rn2.k.e(cVar, size, i17);
                                arrayList3.add(cVar);
                            } else if (yVar2 instanceof lo2.m) {
                                lo2.m mVar = (lo2.m) yVar2;
                                rn2.k.e(mVar, size, i17);
                                arrayList3.add(mVar);
                            } else if (yVar2 instanceof pn2.c) {
                                arrayList3.add((pn2.c) yVar2);
                            } else {
                                arrayList3.add(yVar2);
                            }
                        }
                        if (!TextUtils.isEmpty(bVar2.J)) {
                            str = str3;
                            do2.f fVar = new do2.f(bVar2.J, bVar2.K, bVar2.D);
                            fVar.w(z29);
                            fVar.j(s16);
                            arrayList3.add(fVar);
                            str3 = str;
                        }
                    }
                    str = str3;
                    str3 = str;
                }
                arrayList = arrayList7;
                o16 = bVar2.o();
                if (o16.size() > 0) {
                }
                str = str3;
                str3 = str;
            } else {
                arrayList = arrayList7;
            }
            arrayList7 = arrayList;
        }
        ArrayList arrayList8 = arrayList7;
        if (arrayList6.size() > 0) {
            if (f282612b) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            r112 = 0;
            SearchUtils.U0("all_result", "exp_content", i3, 0, str3, SearchUtils.d0(arrayList6), "", SearchUtils.f0("UnifySearch.Unite", arrayList4));
        } else {
            r112 = 0;
        }
        if (arrayList8.size() > 0) {
            String[] strArr = new String[4];
            strArr[r112] = str3;
            strArr[1] = SearchUtils.d0(arrayList8);
            strArr[2] = "";
            strArr[3] = SearchUtils.f0("UnifySearch.Unite", arrayList4);
            SearchUtils.W0("all_result", "load_content", strArr);
        }
        f282611a = r112;
        return arrayList3;
    }

    public static String o() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
        if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
            return e(cachedLbsInfo);
        }
        return "";
    }

    public static List<Long> p(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j3 : jArr) {
            arrayList.add(Long.valueOf(j3));
        }
        return arrayList;
    }

    public static int q(com.tencent.mobileqq.search.model.v vVar) {
        if (vVar == null) {
            return -1;
        }
        HashMap<String, Integer> hashMap = f282614d;
        if (hashMap.size() == 0) {
            hashMap.put(do2.h.class.getSimpleName(), 101);
            hashMap.put(com.tencent.mobileqq.search.model.j.class.getSimpleName(), 101);
            hashMap.put(com.tencent.mobileqq.search.ftsmsg.a.class.getSimpleName(), 102);
            hashMap.put(do2.i.class.getSimpleName(), 102);
            hashMap.put(do2.d.class.getSimpleName(), 103);
            hashMap.put(do2.e.class.getSimpleName(), 104);
            hashMap.put(do2.g.class.getSimpleName(), 105);
            hashMap.put(pn2.c.class.getSimpleName(), 106);
            hashMap.put(do2.p.class.getSimpleName(), 107);
            hashMap.put(do2.j.class.getSimpleName(), 108);
            hashMap.put(do2.l.class.getSimpleName(), 109);
        }
        Integer num = hashMap.get(vVar.getClass().getSimpleName());
        if (num == null) {
            return -1;
        }
        if (vVar instanceof pn2.c) {
            if (((pn2.c) vVar).I != -1) {
                return -1;
            }
            return num.intValue();
        }
        return num.intValue();
    }

    public static void r(Context context, b bVar) {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("QQSearch");
        if (cachedLbsInfo != null) {
            if (bVar != null) {
                bVar.a(0, e(cachedLbsInfo));
                QLog.d("Q.uniteSearch.SearchUtil", 4, "getLocationInfoAsync cache ", cachedLbsInfo);
            }
            if (t() && v()) {
                D(null);
                return;
            }
            return;
        }
        if (t() && v()) {
            D(bVar);
        } else {
            bVar.a(-1, "");
            QLog.d("Q.uniteSearch.SearchUtil", 2, "getLocationInfoAsync no permission or gps closed ");
        }
    }

    public static int s() {
        return f282613c.getAndIncrement();
    }

    public static boolean t() {
        if (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.SearchUtil", 2, "hasLocationPermission no permission ");
                return false;
            }
            return false;
        }
        return true;
    }

    private static boolean u(lo2.b bVar) {
        long j3 = bVar.D;
        if ((j3 != 1114 && j3 != 1115 && j3 != 1116) || bVar.o() == null || bVar.y() <= bVar.o().size()) {
            return false;
        }
        return true;
    }

    public static final boolean v() {
        LocationManager locationManager = (LocationManager) BaseApplication.getContext().getSystemService("location");
        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
        if (!isProviderEnabled && !isProviderEnabled2) {
            return false;
        }
        return true;
    }

    public static boolean w(String str) {
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (appInterface != null && !TextUtils.isEmpty(str) && ((ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str)) {
            return true;
        }
        return false;
    }

    public static void x(AppInterface appInterface, Context context, String str, int i3, int i16) {
        SearchUtils.P0(appInterface, context, str, i3, i16);
    }

    @Nullable
    public static int[] y(@Nullable int[] iArr, List<Integer> list) {
        if (iArr != null && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (!list.contains(Integer.valueOf(i3))) {
                    arrayList.add(Integer.valueOf(iArr[i3]));
                }
            }
            iArr = new int[arrayList.size()];
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                iArr[i16] = ((Integer) arrayList.get(i16)).intValue();
            }
        }
        return iArr;
    }

    public static void z(final com.tencent.mobileqq.search.model.k kVar, final View view) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.SearchUtil.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String str;
                AppInterface appInterface;
                TroopInfo B;
                HashMap hashMap = new HashMap();
                Integer num = (Integer) view.getTag(R.id.kxc);
                int i16 = -1;
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = -1;
                }
                hashMap.put("itemLinePosition", String.valueOf(i3 + 1));
                hashMap.put("matchDegree", String.valueOf(kVar.I()));
                hashMap.put(PushClientConstants.TAG_CLASS_NAME, kVar.getClass().getSimpleName());
                hashMap.put("keyword", kVar.s());
                HashMap<String, String> hashMap2 = kVar.V;
                if (hashMap2 != null) {
                    hashMap.putAll(hashMap2);
                }
                com.tencent.mobileqq.search.model.k kVar2 = kVar;
                if (kVar2 instanceof wn2.g) {
                    str = ((wn2.g) kVar2).X;
                } else if (kVar2 instanceof wn2.f) {
                    str = ((wn2.f) kVar2).X;
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str) && (appInterface = kVar.G) != null) {
                    GroupMsgMask troopMask = ((QQAppInterface) appInterface).getTroopMask(str);
                    hashMap.put("troopMask", String.valueOf(((QQAppInterface) kVar.G).getTroopMask(str).ordinal()));
                    TroopManager troopManager = (TroopManager) kVar.G.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null && (B = troopManager.B(str)) != null) {
                        i16 = B.wMemberNum;
                    }
                    hashMap.put("troopMask", String.valueOf(troopMask.ordinal()));
                    hashMap.put("troopMemberNum", String.valueOf(i16));
                    if (QLog.isColorLevel()) {
                        QLog.d("searchUtils", 2, "Report troop member click, troopMask:" + troopMask + " troopMemberNum:" + i16);
                    }
                }
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "ContactSearchMatchDegree", true, 0L, 0L, SearchUtils.a0(hashMap), "", false);
            }
        }, null, true);
    }
}
