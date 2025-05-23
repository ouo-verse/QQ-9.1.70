package com.tencent.mobileqq.data;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.activity.eu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FeedsManager implements Manager, BusinessObserver {
    private QQAppInterface app;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f203072em;
    Map<String, FeedInfo> feedInfoCache = new ConcurrentHashMap();
    private volatile boolean inited = false;
    public long serverTimeDiv = 0;
    private static Map<String, Long> tokenMap = new ConcurrentHashMap();
    private static Map<String, String> showStatusUIns = new ConcurrentHashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.data.FeedsManager$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedInfo f203076d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f203077e;
        final /* synthetic */ FeedsManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.this$0.f203072em != null) {
                    boolean update = this.this$0.f203072em.update(this.f203076d);
                    if (QLog.isColorLevel()) {
                        QLog.e("FeedsManager", 2, "setFeedInfoRead  :" + this.f203077e + " ,success:" + update);
                    }
                }
            } catch (Exception e16) {
                QLog.e("FeedsManager", 1, e16, new Object[0]);
            }
        }
    }

    public FeedsManager(QQAppInterface qQAppInterface) {
        this.app = qQAppInterface;
        this.f203072em = qQAppInterface.getEntityManagerFactory().createEntityManager();
        intCache();
    }

    public static String convertAtStruct(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            Matcher matcher = Pattern.compile("@\\{uin:\\d+?,nick:(.+?)\\}").matcher(str);
            StringBuilder sb5 = new StringBuilder(str.length());
            int i3 = 0;
            while (matcher.find()) {
                sb5.append(str.substring(i3, matcher.start()));
                sb5.append("@" + decodeNick(matcher.group(1)));
                i3 = matcher.end();
            }
            sb5.append(str.substring(i3));
            return sb5.toString();
        } catch (Throwable th5) {
            QLog.e("FeedsManager", 2, "", th5);
            return str;
        }
    }

    private long getAIOLatestFeedsTime(String str) {
        List<MessageRecord> D;
        MessageForQzoneFeed messageForQzoneFeed;
        if (TextUtils.isEmpty(str) || (D = this.app.getMessageFacade().D(str, 0, new int[]{MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED})) == null || D.size() <= 0 || (messageForQzoneFeed = (MessageForQzoneFeed) D.get(D.size() - 1)) == null) {
            return 0L;
        }
        messageForQzoneFeed.doParse();
        return messageForQzoneFeed.feedTime;
    }

    public static long getToken(String str) {
        Long l3;
        if (tokenMap.containsKey(str) && (l3 = tokenMap.get(str)) != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public static void hideStatus(String str) {
        showStatusUIns.remove(str);
    }

    private void intCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.FeedsManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int delete = FeedsManager.this.f203072em.delete(new FeedInfo().getTableName(), "feedTime<?", new String[]{String.valueOf(NetConnInfoCenter.getServerTime() - JoinTimeType.SEVEN_DAY)});
                    if (QLog.isColorLevel()) {
                        QLog.i("FeedsManager", 2, String.format("\u5220\u9664 %d \u6761 7\u5929\u524d\u7684feeds\u8bb0\u5f55", Integer.valueOf(delete)));
                    }
                    ArrayList arrayList = (ArrayList) FeedsManager.this.f203072em.query(FeedInfo.class);
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            FeedInfo feedInfo = (FeedInfo) it.next();
                            FeedsManager.this.feedInfoCache.put(String.valueOf(feedInfo.ownerUin), feedInfo);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("FeedsManager", 1, e16, new Object[0]);
                }
            }
        }, 32, new ThreadExcutor.IThreadListener() { // from class: com.tencent.mobileqq.data.FeedsManager.2
            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                FeedsManager.this.inited = true;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.data.FeedsManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!FeedsManager.this.feedInfoCache.isEmpty()) {
                            FeedsManager.this.app.notifyObservers(eu.class, 10000, true, null);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
            }
        }, true);
    }

    public static boolean isShowStatus(String str) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = showStatusUIns) != null) {
            return map.containsKey(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAndUpdateCache(ArrayList<feed_info> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<FeedInfo> arrayList2 = new ArrayList<>();
            Iterator<feed_info> it = arrayList.iterator();
            while (it.hasNext()) {
                feed_info next = it.next();
                FeedInfo feedInfo = new FeedInfo();
                feedInfo.appid = next.appid;
                feedInfo.content = next.strcontent;
                feedInfo.feedTime = next.time;
                feedInfo.hasPic = (int) next.has_pic;
                feedInfo.strImgUrl = next.strImgUrl;
                feedInfo.typeId = next.typeId;
                feedInfo.ownerUin = next.opuin;
                feedInfo.strkey = next.strkey;
                arrayList2.add(feedInfo);
                long aIOLatestFeedsTime = getAIOLatestFeedsTime(String.valueOf(feedInfo.ownerUin));
                if (feedInfo.feedTime <= aIOLatestFeedsTime) {
                    QLog.w("FeedsManager", 1, String.format("aio feeds lastes time is %d > this feed time (%d),\u8bf4\u660e\u7528\u6237\u5df2\u7ecf\u5728aio\u770b\u5230\u8fc7\u6700\u65b0feeds\uff0c\u4e0d\u518d\u663e\u793a\u65b0\u52a8\u6001", Long.valueOf(aIOLatestFeedsTime), Long.valueOf(feedInfo.feedTime)));
                    feedInfo.showInTab = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("FeedsManager", 2, String.valueOf(feedInfo));
                }
            }
            if (!arrayList2.isEmpty() && saveFeedInfoToDb(arrayList2)) {
                Iterator<FeedInfo> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    FeedInfo next2 = it5.next();
                    this.feedInfoCache.put(String.valueOf(next2.ownerUin), next2);
                }
            }
            if (!this.feedInfoCache.isEmpty()) {
                this.app.notifyObservers(eu.class, 10000, true, null);
                return;
            }
            return;
        }
        QLog.w("FeedsManager", 1, "saveAndUpdateCache error: feedInfoRspList is empty");
    }

    private boolean saveFeedInfoToDb(ArrayList<FeedInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<FeedInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PersistOrReplaceTransaction(it.next()));
        }
        boolean doMultiDBOperateByTransaction = this.f203072em.doMultiDBOperateByTransaction(arrayList2);
        QLog.d("FeedsManager", 1, "saveFeedInfoToDb result :" + doMultiDBOperateByTransaction);
        return doMultiDBOperateByTransaction;
    }

    private void saveServerTimeDiv(long j3) {
        this.serverTimeDiv = j3;
        this.app.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).edit().putLong("time_server_div", j3).apply();
    }

    public static void showStatus(String str) {
        showStatusUIns.put(str, "");
    }

    public String getSummary(String str) {
        String str2 = null;
        if (QZoneHelper.hideQzoneStatusInConverstation()) {
            QLog.i("FeedsManager", 2, "getSummary \u4e0b\u53d1\u914d\u7f6e\u9690\u85cf\u65b0\u52a8\u6001");
        } else {
            FeedInfo feedInfo = this.feedInfoCache.get(str);
            if (feedInfo != null && feedInfo.showInTab) {
                str2 = feedInfo.content;
            }
            str2 = convertAtStruct(str2);
            if (!TextUtils.isEmpty(str2) && QLog.isColorLevel()) {
                QLog.i("FeedsManager", 2, "getSummary uin:" + str + " showQzoneStatus content:" + str2);
            }
        }
        return str2;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.inited = false;
        this.feedInfoCache.clear();
        showStatusUIns.clear();
        if (QLog.isColorLevel()) {
            QLog.i("FeedsManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i("FeedsManager", 2, String.format(" onReceive,type:%d,success:%b,bundle:%s", Integer.valueOf(i3), Boolean.valueOf(z16), String.valueOf(bundle)));
        }
        if (z16) {
            newest_feeds_rsp newest_feeds_rspVar = (newest_feeds_rsp) bundle.getSerializable("key_response");
            final ArrayList<feed_info> arrayList = newest_feeds_rspVar.vec_feed_info;
            saveServerTimeDiv(newest_feeds_rspVar.uNextTime);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.FeedsManager.3
                @Override // java.lang.Runnable
                public void run() {
                    FeedsManager.this.saveAndUpdateCache(arrayList);
                }
            }, 32, null, true);
        }
    }

    public void reportExposeStatus(String str) {
        FeedInfo feedInfo = this.feedInfoCache.get(str);
        if (feedInfo != null && !feedInfo.isExpose) {
            feedInfo.isExpose = true;
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(QVipServiceAccountFolderProcessor.CMD, 1, 1), false, false);
            q qVar = (q) this.app.getManager(QQManagerFactory.BEANCURD_MANAGER);
            if (qVar != null) {
                qVar.m(1, 2);
            }
        }
    }

    private static String decodeNick(String str) {
        return str;
    }
}
