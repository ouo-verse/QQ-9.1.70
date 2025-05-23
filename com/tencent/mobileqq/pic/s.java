package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class s implements Manager {
    static IPatchRedirector $redirector_;
    private static final List<String> C;
    private static final List<String> D;
    private static final List<String> E;
    private static final List<String> F;
    private static final List<String> G;
    private static final List<String> H;
    private static final List<String> I;
    private static final String[][] J;
    private static final String[][] K;
    private static final String[][] L;
    private static final String[][] M;
    private static final int N;
    private static final List<String> P;
    private static final List<String> Q;
    private static final List<String> R;
    private static final List<String> S;

    /* renamed from: m, reason: collision with root package name */
    private static final List<String> f258798m;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f258799d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f258800e;

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f258801f;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f258802h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f258803i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f258798m = arrayList;
        arrayList.add("PicStatisticsManagerSendPicTotalSize");
        arrayList.add("PicStatisticsManagerForwardPicTotalSize");
        arrayList.add("PicStatisticsManagerSendPicCount");
        arrayList.add("PicStatisticsManagerForwardPicCount");
        ArrayList arrayList2 = new ArrayList();
        C = arrayList2;
        arrayList2.add("PicStatisticsManagerThumbPicTotalSize");
        arrayList2.add("PicStatisticsManagerBigPicTotalSize");
        arrayList2.add("PicStatisticsManagerDownloadThumbPicCount");
        arrayList2.add("PicStatisticsManagerDownloadBigPicCount");
        ArrayList arrayList3 = new ArrayList();
        D = arrayList3;
        arrayList3.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
        arrayList3.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
        arrayList3.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
        arrayList3.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
        arrayList3.add("PicStatisticsManagerPicDownloadSizeLongC2C");
        arrayList3.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
        arrayList3.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
        arrayList3.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
        arrayList3.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
        arrayList3.add("PicStatisticsManagerPicPreviewSizeLongC2C");
        ArrayList arrayList4 = new ArrayList();
        E = arrayList4;
        arrayList4.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
        arrayList4.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
        arrayList4.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
        arrayList4.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
        arrayList4.add("PicStatisticsManagerPicDownloadSizeLongGroup");
        arrayList4.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
        arrayList4.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
        arrayList4.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
        arrayList4.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
        arrayList4.add("PicStatisticsManagerPicPreviewSizeLongGroup");
        ArrayList arrayList5 = new ArrayList();
        F = arrayList5;
        arrayList5.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
        arrayList5.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
        ArrayList arrayList6 = new ArrayList();
        G = arrayList6;
        arrayList6.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
        arrayList6.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
        ArrayList arrayList7 = new ArrayList();
        H = arrayList7;
        arrayList7.add("PicStatisticsManagerMissPriorityHandlingWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityAIOWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityC2CWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityDiscussionWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityGroupWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityWaitingWifi");
        arrayList7.add("PicStatisticsManagerMissPriorityUnknownWifi");
        ArrayList arrayList8 = new ArrayList();
        I = arrayList8;
        arrayList8.add("PicStatisticsManagerMissPriorityHandlingXG");
        arrayList8.add("PicStatisticsManagerMissPriorityAIOXG");
        arrayList8.add("PicStatisticsManagerMissPriorityC2CXG");
        arrayList8.add("PicStatisticsManagerMissPriorityDiscussionXG");
        arrayList8.add("PicStatisticsManagerMissPriorityGroupXG");
        arrayList8.add("PicStatisticsManagerMissPriorityWaitingXG");
        arrayList8.add("PicStatisticsManagerMissPriorityUnknownXG");
        String[][] strArr = {new String[]{"WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount"}, new String[]{"4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount"}, new String[]{"XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount"}};
        J = strArr;
        K = new String[][]{new String[]{"WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount"}, new String[]{"4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount"}, new String[]{"XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount"}};
        L = new String[][]{new String[]{"WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount"}, new String[]{"4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount"}, new String[]{"XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount"}};
        M = new String[][]{new String[]{"WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount"}, new String[]{"4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount"}, new String[]{"XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount"}};
        N = strArr[0].length;
        P = new ArrayList();
        Q = new ArrayList();
        R = new ArrayList();
        for (int i3 = 0; i3 < N; i3++) {
            List<String> list = P;
            String[][] strArr2 = J;
            list.add(strArr2[0][i3]);
            String[][] strArr3 = K;
            list.add(strArr3[0][i3]);
            String[][] strArr4 = L;
            list.add(strArr4[0][i3]);
            String[][] strArr5 = M;
            list.add(strArr5[0][i3]);
            List<String> list2 = Q;
            list2.add(strArr2[1][i3]);
            list2.add(strArr3[1][i3]);
            list2.add(strArr4[1][i3]);
            list2.add(strArr5[1][i3]);
            List<String> list3 = R;
            list3.add(strArr2[2][i3]);
            list3.add(strArr3[2][i3]);
            list3.add(strArr4[2][i3]);
            list3.add(strArr5[2][i3]);
        }
        Q.add("4G_C2C_FLOAT_HIT_COUNT");
        R.add("XG_C2C_FLOAT_HIT_COUNT");
        ArrayList arrayList9 = new ArrayList();
        S = arrayList9;
        arrayList9.add("PicStatisticsManagerPreDownloadThumbPicCount");
        arrayList9.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
        arrayList9.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
    }

    @TargetApi(9)
    public s(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f258799d = appInterface;
        this.f258800e = new HashSet();
        this.f258801f = new HashSet();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        this.f258802h = defaultSharedPreferences;
        this.f258803i = defaultSharedPreferences.edit();
        f.b("PIC_TAG_PRELOAD_PicStatisticsManager", "onInit", "Finished");
    }

    @TargetApi(9)
    private void a(int i3, int i16, String[][] strArr, boolean z16) {
        String str;
        char c16;
        String str2;
        char c17 = 0;
        if (i3 == 0) {
            if (z16) {
                this.f258803i.putLong("PicStatisticsManagerPredownloadCountWifi", this.f258802h.getLong("PicStatisticsManagerPredownloadCountWifi", 0L) + 1);
            } else {
                this.f258803i.putLong("PicStatisticsManagerPreviewCountWifi", this.f258802h.getLong("PicStatisticsManagerPreviewCountWifi", 0L) + 1);
            }
            str = Global.TRACKING_WIFI;
            c16 = 0;
        } else if (i3 == 0) {
            if (z16) {
                this.f258803i.putLong("PicStatisticsManagerPredownloadCount4G", this.f258802h.getLong("PicStatisticsManagerPredownloadCount4G", 0L) + 1);
            } else {
                this.f258803i.putLong("PicStatisticsManagerPreviewCount4G", this.f258802h.getLong("PicStatisticsManagerPreviewCount4G", 0L) + 1);
            }
            str = "4G";
            c16 = 1;
        } else {
            if (z16) {
                this.f258803i.putLong("PicStatisticsManagerPredownloadCountXG", this.f258802h.getLong("PicStatisticsManagerPredownloadCountXG", 0L) + 1);
            } else {
                this.f258803i.putLong("PicStatisticsManagerPreviewCountXG", this.f258802h.getLong("PicStatisticsManagerPreviewCountXG", 0L) + 1);
            }
            str = "XG";
            c16 = 2;
        }
        if (i16 == 3) {
            str2 = ProtocolDownloaderConstants.HOST_C2C;
        } else if (i16 == 2) {
            str2 = "Discussion";
            c17 = 1;
        } else if (i16 == 0) {
            str2 = IAnimationFactory.AnimationType.f70702GROUP;
            c17 = 2;
        } else if (i16 == 1) {
            str2 = "Digital Group";
            c17 = 3;
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("PicStatisticsManager", 2, "addCount(): Error! Unknown uin type");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addCount(): networkType=" + str + " uin=" + str2);
        }
        String str3 = strArr[c16][c17];
        this.f258803i.putLong(str3, this.f258802h.getLong(str3, 0L) + 1).apply();
    }

    private HashMap<String, String> k(List<String> list) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : list) {
            long j3 = 0;
            long j16 = this.f258802h.getLong(str, 0L);
            if (j16 >= 0 && j16 <= 10000) {
                j3 = j16;
            }
            hashMap.put(str, String.valueOf(j3));
        }
        return hashMap;
    }

    private String n(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            return "PicStatisticsManagerMissPriorityUnknownWifi";
                        }
                        return "PicStatisticsManagerMissPriorityHandlingWifi";
                    }
                    return "PicStatisticsManagerMissPriorityAIOWifi";
                }
                return "PicStatisticsManagerMissPriorityC2CWifi";
            }
            return "PicStatisticsManagerMissPriorityDiscussionWifi";
        }
        return "PicStatisticsManagerMissPriorityGroupWifi";
    }

    private String o(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            return "PicStatisticsManagerMissPriorityUnknownXG";
                        }
                        return "PicStatisticsManagerMissPriorityHandlingXG";
                    }
                    return "PicStatisticsManagerMissPriorityAIOXG";
                }
                return "PicStatisticsManagerMissPriorityC2CXG";
            }
            return "PicStatisticsManagerMissPriorityDiscussionXG";
        }
        return "PicStatisticsManagerMissPriorityGroupXG";
    }

    @TargetApi(9)
    private void p() {
        Iterator<String> it = f258798m.iterator();
        while (it.hasNext()) {
            this.f258803i.putLong(it.next(), 0L);
        }
        Iterator<String> it5 = C.iterator();
        while (it5.hasNext()) {
            this.f258803i.putLong(it5.next(), 0L);
        }
        Iterator<String> it6 = H.iterator();
        while (it6.hasNext()) {
            this.f258803i.putLong(it6.next(), 0L);
        }
        Iterator<String> it7 = I.iterator();
        while (it7.hasNext()) {
            this.f258803i.putLong(it7.next(), 0L);
        }
        Iterator<String> it8 = P.iterator();
        while (it8.hasNext()) {
            this.f258803i.putLong(it8.next(), 0L);
        }
        Iterator<String> it9 = R.iterator();
        while (it9.hasNext()) {
            this.f258803i.putLong(it9.next(), 0L);
        }
        Iterator<String> it10 = S.iterator();
        while (it10.hasNext()) {
            this.f258803i.putLong(it10.next(), 0L);
        }
        this.f258803i.apply();
    }

    @TargetApi(9)
    public void b(MessageForPic messageForPic) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageForPic);
            return;
        }
        if (messageForPic == null) {
            if (QLog.isColorLevel()) {
                QLog.e("PicStatisticsManager", 2, "addDownloadBigPicSize(): pic is null");
                return;
            }
            return;
        }
        long j3 = messageForPic.width;
        long j16 = messageForPic.height;
        if (j3 > 0 && j16 > 0) {
            if (n.i(this.f258799d, messageForPic.istroop, messageForPic.frienduin) == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            int a16 = com.tencent.mobileqq.richmedia.dc.c.a(j3, j16);
            if (a16 == 0) {
                if (z16) {
                    str = "PicStatisticsManagerPicDownloadSizeLongC2C";
                } else {
                    str = "PicStatisticsManagerPicDownloadSizeLongGroup";
                }
            } else if (a16 == 1) {
                if (z16) {
                    str = "PicStatisticsManagerPicDownloadSizeSmallC2C";
                } else {
                    str = "PicStatisticsManagerPicDownloadSizeSmallGroup";
                }
            } else if (a16 == 2) {
                if (z16) {
                    str = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
                } else {
                    str = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
                }
            } else if (a16 == 3) {
                if (z16) {
                    str = "PicStatisticsManagerPicDownloadSizeLargeC2C";
                } else {
                    str = "PicStatisticsManagerPicDownloadSizeLargeGroup";
                }
            } else if (z16) {
                str = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
            } else {
                str = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
            }
            if (com.tencent.mobileqq.v.c(messageForPic.imageType)) {
                str = str + "Dynamic";
            }
            long j17 = this.f258802h.getLong(str, 0L) + 1;
            if (QLog.isColorLevel()) {
                QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): " + str + ", Width=" + j3 + " Height=" + j16 + " Count=" + j17);
            }
            this.f258803i.putLong(str, j17).apply();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): Width=" + j3 + " Height=" + j16 + ", invalid!");
        }
    }

    @TargetApi(9)
    public void c(int i3, long j3) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        switch (i3) {
            case 13057:
                str = "SendPic";
                str2 = "PicStatisticsManagerSendPicTotalSize";
                str3 = "PicStatisticsManagerSendPicCount";
                break;
            case 13058:
                str = "ForwardPic";
                str2 = "PicStatisticsManagerForwardPicTotalSize";
                str3 = "PicStatisticsManagerForwardPicCount";
                break;
            case 13059:
                str = "DownloadThumbPic";
                str2 = "PicStatisticsManagerThumbPicTotalSize";
                str3 = "PicStatisticsManagerDownloadThumbPicCount";
                break;
            case 13060:
                str = "DownloadBigPic";
                str2 = "PicStatisticsManagerBigPicTotalSize";
                str3 = "PicStatisticsManagerDownloadBigPicCount";
                break;
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("PicStatisticsManager", 2, "addPicData(): Unknown picture type!");
                    return;
                }
                return;
        }
        long j16 = this.f258802h.getLong(str2, 0L) + j3;
        long j17 = this.f258802h.getLong(str3, 0L) + 1;
        if (QLog.isColorLevel()) {
            QLog.i("PicStatisticsManager", 2, "addPictureData(): type=" + str + " Adding Size=" + j3 + " Total Size=" + j16 + " Count=" + j17);
        }
        this.f258803i.putLong(str2, j16).putLong(str3, j17).apply();
    }

    public void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicCount(): networkType=" + i3 + " uin=" + i16);
        }
        a(i3, i16, J, true);
    }

    @TargetApi(9)
    public void e(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): networkType=" + i3 + " uin=" + i16 + " preDownloadState=" + i17);
        }
        if (i17 == 1) {
            if (i3 == 2) {
                long j3 = this.f258802h.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L) + 1;
                this.f258803i.putLong("PicStatisticsManagerPreviewCountXG", this.f258802h.getLong("PicStatisticsManagerPreviewCountXG", 0L) + 1);
                this.f258803i.putLong("XG_C2C_FLOAT_HIT_COUNT", j3);
            } else if (i3 == 1) {
                long j16 = this.f258802h.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L) + 1;
                this.f258803i.putLong("PicStatisticsManagerPreviewCount4G", this.f258802h.getLong("PicStatisticsManagerPreviewCount4G", 0L) + 1);
                this.f258803i.putLong("4G_C2C_FLOAT_HIT_COUNT", j16);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
                    return;
                }
                return;
            }
            this.f258803i.apply();
            return;
        }
        a(i3, i16, K, false);
    }

    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicMissCount(): networkType=" + i3 + " uin=" + i16);
        }
        a(i3, i16, L, false);
    }

    public void g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreDownloadNotSupportCount(): networkType=" + i3 + " uin=" + i16);
        }
        a(i3, i16, M, false);
    }

    @TargetApi(9)
    public synchronized void h(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForPic);
            return;
        }
        String str = messageForPic.md5;
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreDownloadThumbPic(): Uniseq=" + messageForPic.uniseq + " MD5=" + messageForPic.md5);
        }
        if (this.f258800e.contains(str)) {
            return;
        }
        this.f258800e.add(messageForPic.md5);
        long j3 = this.f258802h.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1;
        this.f258803i.putLong("PicStatisticsManagerPreDownloadThumbPicCount", j3).apply();
        if (QLog.isColorLevel()) {
            QLog.i("PicStatisticsManager", 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + j3);
        }
    }

    @TargetApi(9)
    public void i(int i3, int i16) {
        String o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 0) {
            o16 = n(i16);
        } else {
            o16 = o(i16);
        }
        long j3 = this.f258802h.getLong(o16, 0L) + 1;
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPredownloadMissPriority(): " + o16 + ", Count=" + j3);
        }
        this.f258803i.putLong(o16, j3).apply();
    }

    @TargetApi(9)
    public void j(MessageForPic messageForPic) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) messageForPic);
            return;
        }
        if (messageForPic == null) {
            if (QLog.isColorLevel()) {
                QLog.e("PicStatisticsManager", 2, "addPreviewBigPicSize(): pic is null");
                return;
            }
            return;
        }
        long j3 = messageForPic.width;
        long j16 = messageForPic.height;
        if (j3 > 0 && j16 > 0) {
            if (n.i(this.f258799d, messageForPic.istroop, messageForPic.frienduin) == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            int a16 = com.tencent.mobileqq.richmedia.dc.c.a(j3, j16);
            if (a16 == 0) {
                if (z16) {
                    str = "PicStatisticsManagerPicPreviewSizeLongC2C";
                } else {
                    str = "PicStatisticsManagerPicPreviewSizeLongGroup";
                }
            } else if (a16 == 1) {
                if (z16) {
                    str = "PicStatisticsManagerPicPreviewSizeSmallC2C";
                } else {
                    str = "PicStatisticsManagerPicPreviewSizeSmallGroup";
                }
            } else if (a16 == 2) {
                if (z16) {
                    str = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
                } else {
                    str = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
                }
            } else if (a16 == 3) {
                if (z16) {
                    str = "PicStatisticsManagerPicPreviewSizeLargeC2C";
                } else {
                    str = "PicStatisticsManagerPicPreviewSizeLargeGroup";
                }
            } else if (z16) {
                str = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
            } else {
                str = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
            }
            if (com.tencent.mobileqq.v.c(messageForPic.imageType)) {
                str = str + "Dynamic";
            }
            long j17 = this.f258802h.getLong(str, 0L) + 1;
            if (QLog.isColorLevel()) {
                QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): " + str + ", Width=" + j3 + " Height=" + j16 + " Count=" + j17);
            }
            this.f258803i.putLong(str, j17).apply();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): Width=" + j3 + " Height=" + j16 + ", invalid!");
        }
    }

    @TargetApi(9)
    public void l() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.f258802h.getBoolean("PicStatisticsManagerFirstUsed", false)) {
            this.f258803i.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
            if (QLog.isColorLevel()) {
                QLog.i("PicStatisticsManager", 2, "dataReport(): Not need to data report!");
                return;
            }
            return;
        }
        AppInterface appInterface = this.f258799d;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (this.f258802h.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, k(S), "");
            long j3 = this.f258802h.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
            long j16 = this.f258802h.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
            long j17 = this.f258802h.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
            long j18 = this.f258802h.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
            long j19 = this.f258802h.getLong("PicStatisticsManagerPreviewCountXG", 0L);
            long j26 = this.f258802h.getLong("PicStatisticsManagerPreviewCount4G", 0L);
            if (j3 + j18 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, k(P), "");
            }
            if (j17 + j26 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, k(Q), "");
            }
            if (j16 + j19 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, k(R), "");
            }
            if (j18 + j19 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, k(D), "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, k(E), "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, k(F), "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, k(G), "");
            }
            if (j18 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, k(H), "");
            }
            if (j19 > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, k(I), "");
            }
        }
        long j27 = this.f258802h.getLong("PicStatisticsManagerSendPicCount", 0L);
        long j28 = this.f258802h.getLong("PicStatisticsManagerForwardPicCount", 0L);
        HashMap<String, String> k3 = k(f258798m);
        if (j27 + j28 <= 0) {
            k3.put("PicStatisticsManagerIsUploadPicActive", Constants.KEY_OPTION_FALSE);
        } else {
            k3.put("PicStatisticsManagerIsUploadPicActive", Constants.KEY_OPTION_TRUE);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, StatisticCollector.STATISTIC_KEY_FOR_UPLOAD_PIC, false, 0L, 0L, k3, "");
        long j29 = this.f258802h.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
        long j36 = this.f258802h.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
        HashMap<String, String> k16 = k(C);
        if (j29 + j36 <= 0) {
            k3.put("PicStatisticsManagerIsDownloadPicActive", Constants.KEY_OPTION_FALSE);
        } else {
            k3.put("PicStatisticsManagerIsDownloadPicActive", Constants.KEY_OPTION_TRUE);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDownloadPic", false, 0L, 0L, k16, "");
        p();
    }

    public void m(int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AppInterface appInterface = this.f258799d;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        String str2 = str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("PredownloadMissReason", String.valueOf(i16));
        if (i3 == 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, hashMap, "");
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, hashMap, "");
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }
}
