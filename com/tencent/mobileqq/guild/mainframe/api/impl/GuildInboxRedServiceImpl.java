package com.tencent.mobileqq.guild.mainframe.api.impl;

import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.mainframe.v;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildInboxRedServiceImpl implements IGuildInboxRedService {
    public static final String TAG = "Guild.C2C.GuildInboxRedServiceImpl";
    private AppRuntime mAppRuntime;
    private ConcurrentHashMap<Integer, cq> mGuildNoticeRedPointMap = new ConcurrentHashMap<>();
    private volatile boolean mHasFetchNoticeRedPointSucc = false;
    private AtomicBoolean mIsFetching = new AtomicBoolean(false);
    private final CopyOnWriteArraySet<IGuildInboxRedService.a> mNoticeRedUpdateListeners = new CopyOnWriteArraySet<>();
    private List<Integer> mInboxNoticeTypes = new ArrayList();
    private v mTabStatusChangeListener = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements v {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.v
        public void a() {
            if (q.l()) {
                GuildInboxRedServiceImpl guildInboxRedServiceImpl = GuildInboxRedServiceImpl.this;
                guildInboxRedServiceImpl.fetchNoticeRedPoint(guildInboxRedServiceImpl.mAppRuntime);
                q.x(GuildInboxRedServiceImpl.this.mTabStatusChangeListener);
            }
        }
    }

    private cq copy(cq cqVar) {
        if (cqVar == null) {
            return new cq();
        }
        cq cqVar2 = new cq();
        cqVar2.f265931a = cqVar.f265931a;
        cqVar2.f265932b = cqVar.f265932b;
        cqVar2.f265933c = cqVar.f265933c;
        cqVar2.f265934d = cqVar.f265934d;
        return cqVar2;
    }

    private void initInboxNoticeTypeList() {
        this.mInboxNoticeTypes.clear();
        this.mInboxNoticeTypes.add(7);
        this.mInboxNoticeTypes.add(5);
        this.mInboxNoticeTypes.add(8);
    }

    private void notify(final IGuildUnreadCntService.b bVar, final cq cqVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            notifyOnUI(bVar, cqVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildInboxRedServiceImpl.this.notifyOnUI(bVar, cqVar);
                }
            });
        }
    }

    private void notifyListUpdate() {
        ConcurrentHashMap<Integer, cq> concurrentHashMap = this.mGuildNoticeRedPointMap;
        if (concurrentHashMap == null) {
            QLog.e(TAG, 1, "notifyListUpdate is too late!");
            return;
        }
        for (cq cqVar : concurrentHashMap.values()) {
            Iterator<IGuildInboxRedService.a> it = this.mNoticeRedUpdateListeners.iterator();
            while (it.hasNext()) {
                it.next().c(cqVar);
            }
        }
        IGuildUnreadCntService.b noticeRedCount = getNoticeRedCount();
        List<cq> noticeGroupList = getNoticeGroupList();
        Iterator<IGuildInboxRedService.a> it5 = this.mNoticeRedUpdateListeners.iterator();
        while (it5.hasNext()) {
            IGuildInboxRedService.a next = it5.next();
            next.a(noticeRedCount);
            next.b(noticeGroupList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnUI(IGuildUnreadCntService.b bVar, cq cqVar) {
        List<cq> noticeGroupList = getNoticeGroupList();
        QLog.i(TAG, 1, "notify total count=" + bVar + " changed redPoint=" + cqVar);
        Iterator<IGuildInboxRedService.a> it = this.mNoticeRedUpdateListeners.iterator();
        while (it.hasNext()) {
            IGuildInboxRedService.a next = it.next();
            if (next == null) {
                QLog.e(TAG, 1, "notify:listener is null, size:", Integer.valueOf(this.mNoticeRedUpdateListeners.size()));
            } else {
                next.a(bVar);
                if (cqVar != null) {
                    next.c(cqVar);
                }
                next.b(noticeGroupList);
            }
        }
    }

    private void tryFetchRedPoint() {
        if (!this.mHasFetchNoticeRedPointSucc) {
            QLog.w(TAG, 4, "redpoint not init yet! ");
            fetchNoticeRedPoint(this.mAppRuntime);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public void addNoticeRedUpdateListener(@NonNull IGuildInboxRedService.a aVar) {
        if (aVar == null) {
            s.f(TAG, "listener must not be null ", new IllegalArgumentException());
            return;
        }
        this.mNoticeRedUpdateListeners.add(aVar);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addNoticeRedUpdateListener mNoticeRedUpdateListeners size: ", Integer.valueOf(this.mNoticeRedUpdateListeners.size()), " hashCode", Integer.valueOf(hashCode()));
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public void clearAllNoticeRedPoint() {
        if (this.mInboxNoticeTypes.isEmpty()) {
            QLog.e(TAG, 1, "clearAllNoticeRedPoint list is empty");
            return;
        }
        Iterator<Integer> it = this.mInboxNoticeTypes.iterator();
        while (it.hasNext()) {
            clearNoticeRedPoint(it.next().intValue());
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public boolean fetchNoticeRedPoint(AppRuntime appRuntime) {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public List<cq> getNoticeGroupList() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "getNoticeGroupList " + this.mGuildNoticeRedPointMap.size());
        }
        return Collections.unmodifiableList(new ArrayList(this.mGuildNoticeRedPointMap.values()));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    @AnyThread
    public IGuildUnreadCntService.b getNoticeRedCount() {
        IGuildUnreadCntService.b bVar = new IGuildUnreadCntService.b();
        int i3 = 0;
        int i16 = 0;
        for (cq cqVar : this.mGuildNoticeRedPointMap.values()) {
            if (cqVar.f265934d == 1) {
                i16 += cqVar.f265932b;
            } else {
                i3 += cqVar.f265932b;
            }
        }
        if (i3 != 0) {
            bVar.f230840d = i3;
            bVar.f230841e = 1;
        } else {
            bVar.f230840d = i16;
            bVar.f230841e = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getNoticeRedCount listSize=" + this.mGuildNoticeRedPointMap.size() + " total=" + bVar.toString());
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    @NonNull
    public cq getNoticeRedPoint(int i3) {
        return copy(this.mGuildNoticeRedPointMap.get(Integer.valueOf(i3)));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public boolean needFetchNoticeRed() {
        return !this.mHasFetchNoticeRedPointSucc;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 2, "onCreate hashCode" + hashCode());
        this.mAppRuntime = appRuntime;
        initInboxNoticeTypeList();
        if (q.l()) {
            fetchNoticeRedPoint(this.mAppRuntime);
        } else {
            q.i(this.mTabStatusChangeListener);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 2, "onDestroy hashCode" + hashCode());
        this.mIsFetching.set(false);
        this.mHasFetchNoticeRedPointSucc = false;
        this.mGuildNoticeRedPointMap.clear();
        this.mNoticeRedUpdateListeners.clear();
        q.x(this.mTabStatusChangeListener);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public void removeNoticeRedUpdateListener(IGuildInboxRedService.a aVar) {
        this.mNoticeRedUpdateListeners.remove(aVar);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeNoticeRedUpdateListener mNoticeRedUpdateListeners size: ", Integer.valueOf(this.mNoticeRedUpdateListeners.size()), " hashCode", Integer.valueOf(hashCode()));
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService
    public void clearNoticeRedPoint(int i3) {
    }
}
