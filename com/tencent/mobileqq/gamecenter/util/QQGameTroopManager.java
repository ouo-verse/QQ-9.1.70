package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.e;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$GroupMemberInfo;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$QueryGroupMemberInfoReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard$QueryGroupMemberInfoRsp;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameMemberSelectInfo$QueryOldFriendsReq;
import tencent.im.qqgame.QQGameMemberSelectInfo$QueryOldFriendsRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameTroopManager implements Manager {
    public static List<String> C;
    public static List<Long> D = Collections.synchronizedList(new ArrayList());
    public static Map<String, sgame_qgroup_datacard$GroupMemberInfo> E = Collections.synchronizedMap(new LinkedHashMap());
    private static final Set<String> F = Collections.synchronizedSet(new LinkedHashSet());
    private static int G;
    private static long H;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<QBaseActivity> f213391d;

    /* renamed from: e, reason: collision with root package name */
    private long f213392e;

    /* renamed from: f, reason: collision with root package name */
    private WadlTrpcListener f213393f = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.2
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.2.1
                {
                    add("/v1/12");
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            QQGameTroopManager.D.clear();
            int i3 = 0;
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                try {
                    QQGameMemberSelectInfo$QueryOldFriendsRsp qQGameMemberSelectInfo$QueryOldFriendsRsp = new QQGameMemberSelectInfo$QueryOldFriendsRsp();
                    qQGameMemberSelectInfo$QueryOldFriendsRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    if (qQGameMemberSelectInfo$QueryOldFriendsRsp.uinList.get() != null) {
                        QQGameTroopManager.D.addAll(qQGameMemberSelectInfo$QueryOldFriendsRsp.uinList.get());
                    }
                } catch (Exception e16) {
                    QLog.e("QQGameTroopManager", 1, e16, new Object[0]);
                }
            }
            QQGameTroopManager.this.i();
            QQGameTroopManager.this.w("friends");
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onTrpcRsp,:gameFriendList size:");
                List<Long> list = QQGameTroopManager.D;
                if (list != null) {
                    i3 = list.size();
                }
                sb5.append(i3);
                sb5.append(",cost:");
                sb5.append(System.currentTimeMillis() - QQGameTroopManager.this.f213392e);
                QLog.i("QQGameTroopManager", 2, sb5.toString());
            }
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private WadlTrpcListener f213394h = new WadlTrpcListener() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.3
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.3.1
                {
                    add("/v1/14");
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            int size;
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                try {
                    sgame_qgroup_datacard$QueryGroupMemberInfoRsp sgame_qgroup_datacard_querygroupmemberinforsp = new sgame_qgroup_datacard$QueryGroupMemberInfoRsp();
                    sgame_qgroup_datacard_querygroupmemberinforsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    List<sgame_qgroup_datacard$GroupMemberInfo> list = sgame_qgroup_datacard_querygroupmemberinforsp.memberList.get();
                    if (list != null && list.size() > 0) {
                        for (sgame_qgroup_datacard$GroupMemberInfo sgame_qgroup_datacard_groupmemberinfo : list) {
                            QQGameTroopManager.E.put(sgame_qgroup_datacard_groupmemberinfo.uin.get() + "", sgame_qgroup_datacard_groupmemberinfo);
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QQGameTroopManager.this.h() != null) {
                                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).notifyListOrSearchChange(QQGameTroopManager.this.h(), true);
                                }
                            }
                        });
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onTrpcRsp,:memberList size:");
                        if (list == null) {
                            size = 0;
                        } else {
                            size = list.size();
                        }
                        sb5.append(size);
                        QLog.i("QQGameTroopManager", 2, sb5.toString());
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQGameTroopManager", 2, th5, new Object[0]);
                    }
                }
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private Comparator<TroopMemberInfo> f213395i = new a();

    /* renamed from: m, reason: collision with root package name */
    private boolean f213396m = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<TroopMemberInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TroopMemberInfo troopMemberInfo, TroopMemberInfo troopMemberInfo2) {
            String str;
            List<String> list;
            if (troopMemberInfo != null && troopMemberInfo2 != null && (str = troopMemberInfo.memberuin) != null && troopMemberInfo2.memberuin != null && (list = QQGameTroopManager.C) != null) {
                boolean contains = list.contains(str);
                boolean contains2 = QQGameTroopManager.C.contains(troopMemberInfo2.memberuin);
                if (contains && !contains2) {
                    return -1;
                }
                if (!contains && contains2) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
    }

    public QQGameTroopManager(QQAppInterface qQAppInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<Long> list, String str, WadlTrpcListener wadlTrpcListener) {
        if (list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGameTroopManager", 2, "doReqGameMemberInfo...friendsUinList size:" + list.size() + ",troopUin\uff1a" + str);
            }
            try {
                sgame_qgroup_datacard$QueryGroupMemberInfoReq sgame_qgroup_datacard_querygroupmemberinforeq = new sgame_qgroup_datacard$QueryGroupMemberInfoReq();
                sgame_qgroup_datacard_querygroupmemberinforeq.groupId.set(Long.parseLong(str));
                sgame_qgroup_datacard_querygroupmemberinforeq.uinList.set(list);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/14", false, sgame_qgroup_datacard_querygroupmemberinforeq.toByteArray());
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(wadlTrpcListener);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
            } catch (Throwable th5) {
                QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
            }
        }
    }

    public static void g(ArrayList<ResultRecord> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                sgame_qgroup_datacard$GroupMemberInfo sgame_qgroup_datacard_groupmemberinfo = E.get(next.uin);
                if (sgame_qgroup_datacard_groupmemberinfo != null) {
                    next.gameLevelIcon = sgame_qgroup_datacard_groupmemberinfo.gradeIcon.get();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity h() {
        WeakReference<QBaseActivity> weakReference = this.f213391d;
        if (weakReference != null && (weakReference.get() instanceof Activity)) {
            return this.f213391d.get();
        }
        return null;
    }

    public static boolean l(Activity activity) {
        if (activity == null || activity.getIntent().getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0) != 43 || activity.getIntent().getIntExtra("GAME_H5_SELECT_BUSINESS_TYPE", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean m(Activity activity) {
        if (activity == null || (activity.getIntent().getIntExtra(ISelectMemberActivityConstants.PARAM_GAME_INFO_FLAG, 0) & 1) != 1) {
            return false;
        }
        return true;
    }

    public static void p(int i3, String str, boolean z16) {
        String str2;
        String str3;
        if (i3 == 0 || i3 == 1) {
            if (z16) {
                if (i3 == 1) {
                    try {
                        if (Math.abs(System.currentTimeMillis() - H) <= 2000) {
                            return;
                        }
                    } catch (Throwable th5) {
                        QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
                        return;
                    }
                }
                H = System.currentTimeMillis();
            }
            HashMap hashMap = new HashMap();
            if (z16) {
                str2 = "8";
            } else {
                str2 = "20";
            }
            hashMap.put(4, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
            hashMap.put(27, jSONObject.toString());
            if (i3 == 0) {
                if (z16) {
                    str3 = "207966";
                } else {
                    str3 = "207939";
                }
            } else if (z16) {
                str3 = "207965";
            } else {
                str3 = "207940";
            }
            hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, str3, "", "100602", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
        }
    }

    public static void q(String str, ArrayList<ResultRecord> arrayList, String str2) {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put(4, "20");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
            StringBuilder sb5 = new StringBuilder();
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append("");
            jSONObject.put("viewnum", sb5.toString());
            jSONObject.put("roomnum", G + "");
        } catch (JSONException e16) {
            QLog.e("QQGameTroopManager", 1, e16, new Object[0]);
        }
        hashMap.put(27, jSONObject.toString());
        hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, "207968", str2, "100602", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
    }

    public static void r(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(4, "20");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
            jSONObject.put("roomnum", G + "");
            jSONObject.put("guestuin", str2);
            jSONObject.put("adtag", str3);
        } catch (JSONException e16) {
            QLog.e("QQGameTroopManager", 1, e16, new Object[0]);
        }
        hashMap.put(27, jSONObject.toString());
        hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, "207967", str4, "100602", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
    }

    private void v(final Activity activity, List<String> list, Map<String, List<TroopMemberInfo>> map) {
        if (activity != null && map != null) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        Iterator<String> it = map.keySet().iterator();
                        while (it.hasNext()) {
                            Collections.sort(map.get(it.next()), this.f213395i);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
                    return;
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.5
                @Override // java.lang.Runnable
                public void run() {
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).notifyListOrSearchChange(activity, false);
                }
            });
            if (m(activity)) {
                t(0, 50, h());
            }
        }
    }

    public static void x(Activity activity, TroopMemberInfo troopMemberInfo, TextView textView, ImageView imageView, TextView textView2) {
        if (troopMemberInfo != null) {
            try {
                textView.setVisibility(0);
                String string = activity.getResources().getString(R.string.f2334777c);
                textView.setText(string);
                imageView.setVisibility(8);
                sgame_qgroup_datacard$GroupMemberInfo sgame_qgroup_datacard_groupmemberinfo = E.get(troopMemberInfo.memberuin);
                if (sgame_qgroup_datacard_groupmemberinfo != null) {
                    if (sgame_qgroup_datacard_groupmemberinfo.ret.get() == 0) {
                        if (!TextUtils.isEmpty(sgame_qgroup_datacard_groupmemberinfo.gradeName.get())) {
                            string = sgame_qgroup_datacard_groupmemberinfo.gradeName.get();
                        }
                        textView.setText(string);
                        if (!TextUtils.isEmpty(sgame_qgroup_datacard_groupmemberinfo.gradeIcon.get())) {
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                            obtain.mLoadingDrawable = drawable;
                            obtain.mFailedDrawable = drawable;
                            imageView.setImageDrawable(URLDrawable.getDrawable(sgame_qgroup_datacard_groupmemberinfo.gradeIcon.get(), obtain));
                            imageView.setVisibility(0);
                        }
                    } else if (sgame_qgroup_datacard_groupmemberinfo.ret.get() == 200022) {
                        textView.setText(activity.getResources().getString(R.string.f2334877d));
                    }
                }
                if (C == null) {
                    textView2.setVisibility(8);
                    return;
                }
                textView2.setVisibility(0);
                if (C.contains(troopMemberInfo.memberuin)) {
                    textView2.setText(activity.getResources().getString(R.string.hpt));
                } else {
                    textView2.setText(activity.getResources().getString(R.string.hps));
                }
            } catch (Throwable th5) {
                QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
            }
        }
    }

    public static void y(ImageView imageView, String str) {
        sgame_qgroup_datacard$GroupMemberInfo sgame_qgroup_datacard_groupmemberinfo = E.get(str);
        if (sgame_qgroup_datacard_groupmemberinfo != null && !TextUtils.isEmpty(sgame_qgroup_datacard_groupmemberinfo.gradeIcon.get())) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            imageView.setImageDrawable(URLDrawable.getDrawable(sgame_qgroup_datacard_groupmemberinfo.gradeIcon.get(), obtain));
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(4);
    }

    public void e(String str, QBaseActivity qBaseActivity) {
        try {
            j(qBaseActivity);
            if (TextUtils.isEmpty(str)) {
                str = qBaseActivity.getIntent().getStringExtra("group_uin");
            }
            D.clear();
            QQGameMemberSelectInfo$QueryOldFriendsReq qQGameMemberSelectInfo$QueryOldFriendsReq = new QQGameMemberSelectInfo$QueryOldFriendsReq();
            qQGameMemberSelectInfo$QueryOldFriendsReq.groupCode.set(Long.parseLong(str));
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/12", false, qQGameMemberSelectInfo$QueryOldFriendsReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f213393f);
            this.f213392e = System.currentTimeMillis();
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
            if (QLog.isColorLevel()) {
                QLog.i("QQGameTroopManager", 2, "doReqGameFriends...troopUin:" + str);
            }
        } catch (Throwable th5) {
            QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
        }
    }

    public void i() {
        int i3 = 0;
        try {
            if (h() == null) {
                return;
            }
            final Activity h16 = h();
            Map<String, List<TroopMemberInfo>> indexedFriends = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getIndexedFriends(h16);
            if (indexedFriends != null && indexedFriends.size() != 0) {
                G = 0;
                List<TroopMemberInfo> synchronizedList = Collections.synchronizedList(new ArrayList());
                List<TroopMemberInfo> synchronizedList2 = Collections.synchronizedList(new ArrayList());
                Iterator<String> it = indexedFriends.keySet().iterator();
                while (it.hasNext()) {
                    List<TroopMemberInfo> list = indexedFriends.get(it.next());
                    if (list != null) {
                        for (TroopMemberInfo troopMemberInfo : list) {
                            if (troopMemberInfo != null) {
                                try {
                                    List<Long> list2 = D;
                                    if (list2 != null && list2.contains(Long.valueOf(Long.parseLong(troopMemberInfo.memberuin)))) {
                                        synchronizedList2.add(troopMemberInfo);
                                    } else {
                                        synchronizedList.add(troopMemberInfo);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                G = synchronizedList2.size() + synchronizedList.size();
                final Map<String, List<TroopMemberInfo>> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
                if (synchronizedList2.size() > 0) {
                    synchronizedMap.put(h16.getResources().getString(R.string.f23337773), synchronizedList2);
                }
                if (synchronizedList.size() > 0) {
                    if (synchronizedList2.size() > 0) {
                        synchronizedMap.put(h16.getResources().getString(R.string.f2335077f), synchronizedList);
                    } else {
                        synchronizedMap.put(h16.getResources().getString(R.string.f2334477_), synchronizedList);
                    }
                }
                int size = synchronizedMap.keySet().size();
                if (size == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQGameTroopManager", 2, "groupSize=0");
                        return;
                    }
                    return;
                }
                Iterator<String> it5 = synchronizedMap.keySet().iterator();
                final int[] iArr = new int[size];
                final String[] strArr = new String[size];
                iArr[0] = 0;
                for (int i16 = 1; i16 < size; i16++) {
                    try {
                        iArr[i16] = iArr[i16] + iArr[i16 - 1] + synchronizedMap.get(it5.next()).size() + 1;
                    } catch (Throwable th5) {
                        th = th5;
                        i3 = 0;
                        QLog.e("QQGameTroopManager", 1, th, new Object[i3]);
                    }
                }
                Iterator<String> it6 = synchronizedMap.keySet().iterator();
                int i17 = 0;
                while (it6.hasNext()) {
                    strArr[i17] = it6.next();
                    i17++;
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).updateGameData(h16, synchronizedMap, iArr, strArr);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).updateGameData(h16, synchronizedMap, iArr, strArr);
                        }
                    });
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QQGameTroopManager", 2, "handleGameClockData...gameFriendList:" + synchronizedList2.size() + ",otherMemberList:" + synchronizedList.size() + ",groupSize:" + size);
                }
                try {
                    s(h16.getIntent().getStringExtra("group_uin"), h16.getIntent().getStringExtra(ITroopUtilApi.GAME_H5_SELECT_GAME_APPID));
                } catch (Throwable th6) {
                    th = th6;
                    i3 = 0;
                    QLog.e("QQGameTroopManager", 1, th, new Object[i3]);
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void j(QBaseActivity qBaseActivity) {
        this.f213391d = new WeakReference<>(qBaseActivity);
    }

    public void k() {
        Set<String> set = F;
        set.add("member");
        set.add("friends");
        set.add(TPReportKeys.Common.COMMON_ONLINE);
    }

    public void n(List<String> list) {
        if (list != null) {
            C = Collections.synchronizedList(list);
        }
        w(TPReportKeys.Common.COMMON_ONLINE);
    }

    public void o(Activity activity, List<ResultRecord> list, int i3, String str, final String str2) {
        String str3;
        int i16;
        j((QBaseActivity) activity);
        if (i3 == 3 || i3 == 2) {
            if (i3 == 3) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            r(str2, str, str3, activity.getIntent().getStringExtra(ITroopUtilApi.GAME_H5_SELECT_GAME_APPID));
        }
        if (m(activity) && list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGameTroopManager", 2, "onSearchBarDone,recordsSize\uff1a" + list.size() + ",searchType:" + i3);
            }
            final ArrayList arrayList = new ArrayList();
            for (ResultRecord resultRecord : list) {
                if (resultRecord != null) {
                    try {
                        if (!E.containsKey(resultRecord.uin)) {
                            arrayList.add(Long.valueOf(Long.parseLong(resultRecord.uin)));
                        }
                    } catch (Throwable th5) {
                        QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
                    }
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            if (i3 == 3) {
                i16 = 500;
            } else {
                i16 = 100;
            }
            ThreadManager.getSubThreadHandler().removeCallbacksAndMessages("reqGameInfo");
            ThreadManager.getSubThreadHandler().postAtTime(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.4
                @Override // java.lang.Runnable
                public void run() {
                    QQGameTroopManager qQGameTroopManager = QQGameTroopManager.this;
                    qQGameTroopManager.f(arrayList, str2, qQGameTroopManager.f213394h);
                }
            }, "reqGameInfo", SystemClock.uptimeMillis() + i16);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        try {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f213393f);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f213394h);
            this.f213396m = false;
            this.f213391d = null;
            E.clear();
            C = null;
            D.clear();
            F.clear();
            G = 0;
            if (!QLog.isColorLevel()) {
            }
        } catch (Throwable th5) {
            try {
                QLog.e("QQGameTroopManager", 1, th5, new Object[0]);
            } finally {
                if (QLog.isColorLevel()) {
                    QLog.i("QQGameTroopManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
                }
            }
        }
    }

    public void s(String str, String str2) {
        if (this.f213396m) {
            return;
        }
        this.f213396m = true;
        HashMap hashMap = new HashMap();
        hashMap.put(4, "8");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
            jSONObject.put("roomnum", G + "");
        } catch (JSONException e16) {
            QLog.e("QQGameTroopManager", 1, e16, new Object[0]);
        }
        hashMap.put(27, jSONObject.toString());
        hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, "207851", str2, "100602", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(int i3, int i16, Activity activity) {
        int i17;
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            int i18 = 0;
            try {
                e memberListAdapter = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getMemberListAdapter(activity);
                if (i3 == 0) {
                    i17 = memberListAdapter.getCount();
                    try {
                        i16 = Math.min(i16, i17 - 1);
                        i18 = i17;
                    } catch (Throwable th5) {
                        th = th5;
                        QLog.e("QQGameTroopManager", 1, th, new Object[0]);
                        i18 = i17;
                        if (QLog.isColorLevel()) {
                        }
                        f(arrayList, activity.getIntent().getStringExtra("group_uin"), this.f213394h);
                    }
                }
                for (int i19 = i3; i19 <= i16; i19++) {
                    try {
                        TroopMemberInfo troopMemberInfo = (TroopMemberInfo) memberListAdapter.getItem(i19);
                        if (troopMemberInfo != null) {
                            long parseLong = Long.parseLong(troopMemberInfo.memberuin);
                            if (!E.containsKey(troopMemberInfo.memberuin)) {
                                arrayList.add(Long.valueOf(parseLong));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                i17 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQGameTroopManager", 2, "reqGameInfoByPosition,firstPosition:" + i3 + ",lastPosition:" + i16 + ",itemCount\uff1a" + i18);
            }
            f(arrayList, activity.getIntent().getStringExtra("group_uin"), this.f213394h);
        }
    }

    public void u(PinnedDividerListView pinnedDividerListView, Activity activity) {
        if (pinnedDividerListView != null) {
            t(pinnedDividerListView.getFirstVisiblePosition(), pinnedDividerListView.getLastVisiblePosition(), activity);
        }
    }

    public void w(String str) {
        Activity h16;
        Set<String> set = F;
        set.remove(str);
        if (set.size() == 0 && (h16 = h()) != null) {
            Map<String, List<TroopMemberInfo>> indexedFriends = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getIndexedFriends(h16);
            if (indexedFriends != null && indexedFriends.size() != 0) {
                v(h16, C, indexedFriends);
            } else {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQGameTroopManager", 2, "checkNeedSortAndPreload,sTaskSet:" + set.toString() + ",taskName:" + str);
        }
    }
}
