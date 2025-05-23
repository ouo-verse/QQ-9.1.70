package com.tencent.mobileqq.guild.feed.publish.helper;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.IGuildFeedPublishQualityReporterApi;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.q;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDbDataHelper {

    /* renamed from: c, reason: collision with root package name */
    private static final String f222901c = new GuildMediaProgressState().getTableName();

    /* renamed from: d, reason: collision with root package name */
    private static volatile GuildDbDataHelper f222902d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile WeakReference<AppRuntime> f222903e;

    /* renamed from: a, reason: collision with root package name */
    protected EntityManager f222904a;

    /* renamed from: b, reason: collision with root package name */
    protected final Handler f222905b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper$8, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f222924d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f222925e;
        final /* synthetic */ GuildDbDataHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            List list = this.f222924d;
            if (list != null && !list.isEmpty()) {
                StringBuilder sb5 = new StringBuilder("mUin=? and (mTaskId=?");
                for (int i3 = 1; i3 < this.f222924d.size(); i3++) {
                    sb5.append(" OR mTaskId=?");
                }
                sb5.append(")");
                int size = this.f222924d.size() + 1;
                String[] strArr = new String[size];
                int i16 = 0;
                strArr[0] = ax.v();
                for (int i17 = 1; i17 < size; i17++) {
                    strArr[i17] = (String) this.f222924d.get(i17 - 1);
                }
                List B = this.this$0.B(sb5.toString(), strArr);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[queryMainTaskIdTaskEntry]  entryList.size = ");
                if (B != null) {
                    i16 = B.size();
                }
                sb6.append(i16);
                QLog.d("GUP-T-GuildDbDataHelper", 1, sb6.toString());
                this.this$0.C(B, this.f222925e);
                return;
            }
            QLog.w("GUP-T-GuildDbDataHelper", 1, "[queryMainTaskIdTaskEntry]  mainTaskIds = null");
            this.f222925e.onResult(Collections.emptyList());
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a<T> {
        void onResult(T t16);
    }

    public GuildDbDataHelper() {
        AppRuntime t16 = t();
        f222903e = new WeakReference<>(t16);
        this.f222904a = t().getEntityManagerFactory(t16.getAccount()).createEntityManager();
        this.f222905b = RFWThreadManager.createNewThreadHandler("GuildTaskDbDataThread", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public List<GuildTaskProgressState> B(String str, String[] strArr) {
        List query;
        EntityManager u16 = u();
        synchronized (u16) {
            query = u16.query(GuildTaskProgressState.class, GuildTaskProgressState.TABLE_NAME, false, str, strArr, null, null, "mUpdateTime desc", null, null);
        }
        L(query);
        return query;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final List<GuildTaskProgressState> list, final a<List<GuildTaskProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.3
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = aVar;
                if (aVar2 == null) {
                    QLog.e("GUP-T-GuildDbDataHelper", 1, "queryDataRspListener  listener == null");
                } else {
                    aVar2.onResult(list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GuildTaskProgressState> E(String str, String str2) {
        String str3;
        String[] strArr;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QLog.e("GUP-T-GuildDbDataHelper", 1, "[queryGuildChannelFailTask]   guildId = null but channelId = " + str2);
            return null;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            strArr = new String[]{ax.v(), "3"};
            str3 = "mUin=? and mState<>?";
        } else if (TextUtils.isEmpty(str2)) {
            str3 = "mUin=? and mState<>? and mGuildId=?";
            strArr = new String[]{ax.v(), "3", str};
        } else {
            String[] strArr2 = {ax.v(), "3", str, str2};
            str3 = "mUin=? and mState<>? and mGuildId=? and mChannelId=?";
            strArr = strArr2;
        }
        return B(str3, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GuildTaskProgressState> J(int i3) {
        return B("mUin=? and mState<>? and mScope=?", new String[]{ax.v(), String.valueOf(3), String.valueOf(i3)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L(List<GuildTaskProgressState> list) {
        List<? extends Entity> query;
        int i3;
        if (bl.b(list)) {
            QLog.w("GUP-T-GuildDbDataHelper", 1, "[querySonTaskEntry]: entryList is empty");
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i16 = 0; i16 < list.size(); i16++) {
            GuildTaskProgressState guildTaskProgressState = list.get(i16);
            String[] strArr = {guildTaskProgressState.getMainTaskId()};
            EntityManager u16 = u();
            synchronized (u16) {
                query = u16.query(GuildMediaProgressState.class, new GuildMediaProgressState().getTableName(), false, "mMainTaskId=?", strArr, null, null, null, null, null);
            }
            guildTaskProgressState.setMediaProgressStates(query);
            if (query != null) {
                i3 = query.size();
            } else {
                i3 = 0;
            }
            iArr[i16] = i3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i17 = 0; i17 < size; i17++) {
                if (iArr[i17] > 0) {
                    sb5.append('(');
                    sb5.append(list.get(i17).getMainTaskId());
                    sb5.append(", ");
                    sb5.append(iArr[i17]);
                    sb5.append(')');
                }
            }
            QLog.d("GUP-T-GuildDbDataHelper", 2, "[querySonTaskEntry]: " + ((Object) sb5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void A(List<GuildMediaProgressState> list) {
        if (!bl.b(list)) {
            for (GuildMediaProgressState guildMediaProgressState : list) {
                EntityManager u16 = u();
                synchronized (u16) {
                    if (guildMediaProgressState.getStatus() == 1000) {
                        u16.persistOrReplace(guildMediaProgressState);
                    } else if (!u16.update(guildMediaProgressState)) {
                        QLog.e("GUP-T-GuildDbDataHelper", 1, "[updateSonTaskEntry] failed!  | mainTaskId = " + guildMediaProgressState.getMainTaskId() + " | mediaProgressState = " + guildMediaProgressState);
                        QCirclePublishQualityDataBuilder ext2 = new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_MEDIA_UPLOAD_UPDATE_DB_FAILED").setTraceId(guildMediaProgressState.getMainTaskId()).setExt1(guildMediaProgressState.getTaskId()).setExt2(guildMediaProgressState.toString());
                        ((IGuildFeedPublishQualityReporterApi) QRoute.api(IGuildFeedPublishQualityReporterApi.class)).uploadQualityReport(ext2);
                        ak.a(ext2);
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator<GuildMediaProgressState> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().getTaskId());
                sb5.append(",");
            }
            QLog.d("GUP-T-GuildDbDataHelper", 1, "[updateSonTaskEntry]  entryList.size = " + list.size() + " | entryIds = " + ((Object) sb5));
            return;
        }
        QLog.w("GUP-T-GuildDbDataHelper", 1, "[updateSonTaskEntry]: entryList is empty");
    }

    public static GuildDbDataHelper s() {
        if (f222902d == null) {
            synchronized (GuildDbDataHelper.class) {
                if (f222902d == null) {
                    f222902d = new GuildDbDataHelper();
                }
            }
        }
        return f222902d;
    }

    private AppRuntime t() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EntityManager u() {
        AppRuntime t16 = t();
        AppRuntime appRuntime = f222903e.get();
        if (appRuntime == null || appRuntime != t16) {
            f222903e = new WeakReference<>(t16);
            this.f222904a = t().getEntityManagerFactory(t16.getAccount()).createEntityManager();
        }
        return this.f222904a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(String str, List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GuildTaskProgressState guildTaskProgressState = (GuildTaskProgressState) it.next();
                if (!TextUtils.equals(str, guildTaskProgressState.getMainTaskId()) && guildTaskProgressState.isTriggerSave() && GuildFeedPublishUtils.f222315a.u(str, guildTaskProgressState.getMainTaskId())) {
                    q(guildTaskProgressState.getMainTaskId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(String str, List list) {
        if (list == null) {
            return;
        }
        QLog.i("GUP-T-GuildDbDataHelper", 2, "deleteSameGuildChannelDraftTask");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GuildTaskProgressState guildTaskProgressState = (GuildTaskProgressState) it.next();
            if (!TextUtils.equals(str, guildTaskProgressState.getMainTaskId()) && guildTaskProgressState.isTriggerSave() && GuildFeedPublishUtils.f222315a.u(str, guildTaskProgressState.getMainTaskId())) {
                q(guildTaskProgressState.getMainTaskId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("GUP-T-GuildDbDataHelper", 1, "[deleteTaskEntry]  mainTaskId = null");
            return;
        }
        EntityManager u16 = u();
        synchronized (u16) {
            u16.delete(new GuildMediaProgressState().getTableName(), "mMainTaskId=?", new String[]{str});
            u16.delete(GuildTaskProgressState.TABLE_NAME, "mTaskId=?", new String[]{str});
        }
        QLog.d("GUP-T-GuildDbDataHelper", 1, "[deleteTaskEntry]  mainTaskId = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(List list, final a aVar) {
        if (bl.b(list)) {
            aVar.onResult(Collections.emptyList());
            return;
        }
        q.BatchQueryParams a16 = q.f223921a.a(list, 50, "mTaskId");
        final ArrayList arrayList = new ArrayList();
        EntityManager u16 = u();
        synchronized (u16) {
            int i3 = 0;
            while (i3 < a16.b().size()) {
                int i16 = i3;
                List<? extends Entity> query = u16.query(GuildMediaProgressState.class, f222901c, false, a16.a().get(i3), a16.b().get(i3), null, null, null, null, null);
                if (query != null) {
                    arrayList.addAll(query);
                }
                i3 = i16 + 1;
            }
        }
        QLog.d("GUP-T-GuildDbDataHelper", 1, "[queryMediaTaskIdTaskEntry]  entryList.size = " + arrayList.size());
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.9
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = aVar;
                if (aVar2 == null) {
                    QLog.e("GUP-T-GuildDbDataHelper", 1, "queryDataRspListener  listener == null");
                } else {
                    aVar2.onResult(arrayList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i3, a aVar) {
        Object obj;
        List<GuildTaskProgressState> J = J(i3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[queryNotSuccessTaskByScopeOnly]   entryList = ");
        if (J == null) {
            obj = 0;
        } else {
            obj = J.toString();
        }
        sb5.append(obj);
        QLog.d("GUP-T-GuildDbDataHelper", 1, sb5.toString());
        C(J, aVar);
    }

    public void D(final String str, final String str2, final boolean z16, final int i3, final a<List<GuildTaskProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.2
            @Override // java.lang.Runnable
            public void run() {
                List J;
                int size;
                String obj;
                int i16 = i3;
                if (i16 == 0) {
                    J = GuildDbDataHelper.this.E(str, str2);
                } else {
                    J = i16 == 1 ? GuildDbDataHelper.this.J(i16) : null;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[queryFailTaskEntry] | entryList.size = ");
                if (J == null) {
                    size = 0;
                } else {
                    size = J.size();
                }
                sb5.append(size);
                sb5.append(" | entryList = ");
                if (J == null) {
                    obj = "null";
                } else {
                    obj = J.toString();
                }
                sb5.append(obj);
                QLog.d("GUP-T-GuildDbDataHelper", 1, sb5.toString());
                if (J == null) {
                    GuildDbDataHelper.this.C(null, aVar);
                    return;
                }
                if (!z16) {
                    GuildDbDataHelper.this.C(J, aVar);
                    return;
                }
                Iterator it = J.iterator();
                while (it.hasNext()) {
                    GuildTaskProgressState guildTaskProgressState = (GuildTaskProgressState) it.next();
                    if (!guildTaskProgressState.isTriggerPublish()) {
                        it.remove();
                        QLog.d("GUP-T-GuildDbDataHelper", 1, "[queryFailTaskEntry]  find task is not publish task, remove  | mainTaskId = " + guildTaskProgressState.getMainTaskId());
                    }
                }
                GuildDbDataHelper.this.C(J, aVar);
            }
        });
    }

    public void F(final String str, final String str2, final a<List<GuildTaskProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.6
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                List E = GuildDbDataHelper.this.E(str, str2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[queryGuildChannelTaskEntry]   entryList = ");
                if (E == null) {
                    obj = 0;
                } else {
                    obj = E.toString();
                }
                sb5.append(obj);
                QLog.d("GUP-T-GuildDbDataHelper", 1, sb5.toString());
                GuildDbDataHelper.this.C(E, aVar);
            }
        });
    }

    public List<GuildTaskProgressState> G() {
        List query;
        String[] strArr = {ax.v(), "3", "0"};
        EntityManager u16 = u();
        synchronized (u16) {
            query = u16.query(GuildTaskProgressState.class, GuildTaskProgressState.TABLE_NAME, false, "mUin=? and mState<>? and mIsTriggerSave=true and mScope=?", strArr, null, null, "mUpdateTime desc", null, null);
        }
        return query;
    }

    public void H(final String str, final a<List<GuildTaskProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    QLog.w("GUP-T-GuildDbDataHelper", 1, "[queryMainTaskIdTaskEntry]  mainTaskId = null");
                }
                int i3 = 0;
                List B = GuildDbDataHelper.this.B("mUin=? and mTaskId=?", new String[]{ax.v(), str});
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[queryMainTaskIdTaskEntry]  entryList.size = ");
                if (B != null) {
                    i3 = B.size();
                }
                sb5.append(i3);
                QLog.d("GUP-T-GuildDbDataHelper", 1, sb5.toString());
                GuildDbDataHelper.this.C(B, aVar);
            }
        });
    }

    public void I(final List<String> list, final a<List<GuildMediaProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildDbDataHelper.this.y(list, aVar);
            }
        });
    }

    public void K(final int i3, final a<List<GuildTaskProgressState>> aVar) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildDbDataHelper.this.z(i3, aVar);
            }
        });
    }

    public void M(final List<GuildMediaProgressState> list) {
        if (bl.b(list)) {
            QLog.w("GUP-T-GuildDbDataHelper", 1, "[updateMediaTaskEntries]: entryList is empty");
        } else {
            this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildDbDataHelper.this.A(list);
                }
            });
        }
    }

    public void O(GuildTaskProgressState guildTaskProgressState) {
        P("", guildTaskProgressState);
    }

    public void P(String str, GuildTaskProgressState guildTaskProgressState) {
        Q(str, guildTaskProgressState, true);
    }

    public void Q(final String str, final GuildTaskProgressState guildTaskProgressState, final boolean z16) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.1
            @Override // java.lang.Runnable
            public void run() {
                boolean update;
                int size;
                GuildTaskProgressState guildTaskProgressState2 = guildTaskProgressState;
                if (guildTaskProgressState2 == null) {
                    QLog.w("GUP-T-GuildDbDataHelper", 1, "[updateTaskEntry]  progressState = null");
                    return;
                }
                if (!bl.b(guildTaskProgressState2.getMediaProgressStates()) && z16) {
                    GuildDbDataHelper.this.A(guildTaskProgressState.getMediaProgressStates());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[updateTaskEntry]: updateSonTaskEntry  | mainTaskId = ");
                    sb5.append(guildTaskProgressState.getMainTaskId());
                    sb5.append(" | mediaList.size = ");
                    if (guildTaskProgressState.getMediaProgressStates() == null) {
                        size = 0;
                    } else {
                        size = guildTaskProgressState.getMediaProgressStates().size();
                    }
                    sb5.append(size);
                    QLog.d("GUP-T-GuildDbDataHelper", 1, sb5.toString());
                }
                guildTaskProgressState.setUpdateTime(System.currentTimeMillis());
                EntityManager u16 = GuildDbDataHelper.this.u();
                synchronized (u16) {
                    if (guildTaskProgressState.getStatus() == 1000) {
                        u16.persistOrReplace(guildTaskProgressState);
                        update = true;
                    } else {
                        update = u16.update(guildTaskProgressState);
                    }
                }
                QLog.d("GUP-T-GuildDbDataHelper", 1, "[updateTaskEntry]: " + str + "-> isSuccess:" + update + ",  progressState = " + guildTaskProgressState);
            }
        });
    }

    public void n(final String str, int i3) {
        K(i3, new a() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.e
            @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
            public final void onResult(Object obj) {
                GuildDbDataHelper.this.v(str, (List) obj);
            }
        });
    }

    public void o(final String str, final String str2) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    String[] strArr = {str, str2};
                    EntityManager u16 = GuildDbDataHelper.this.u();
                    synchronized (u16) {
                        u16.delete(new GuildMediaProgressState().getTableName(), "mMainTaskId=? and mTaskId=?", strArr);
                    }
                    QLog.d("GUP-T-GuildDbDataHelper", 1, "[deleteMediaUploadTask]  | mainTaskId = " + str + " | taskId = " + str2);
                    return;
                }
                QLog.w("GUP-T-GuildDbDataHelper", 1, "[deleteMediaUploadTask] mainTaskId = null ||  taskId = null");
            }
        });
    }

    public void p(final String str, String str2, String str3) {
        F(str2, str3, new a() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.f
            @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
            public final void onResult(Object obj) {
                GuildDbDataHelper.this.w(str, (List) obj);
            }
        });
    }

    public void q(final String str) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildDbDataHelper.this.x(str);
            }
        });
    }

    public void r(final List<String> list) {
        this.f222905b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.4
            @Override // java.lang.Runnable
            public void run() {
                List list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    EntityManager u16 = GuildDbDataHelper.this.u();
                    int size = list.size();
                    ArrayList<String[]> arrayList = new ArrayList();
                    int i3 = 0;
                    while (i3 < size) {
                        int i16 = i3 + 50;
                        arrayList.add((String[]) list.subList(i3, Math.min(i16, size)).toArray(new String[0]));
                        i3 = i16;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String[] strArr : arrayList) {
                        StringBuilder sb5 = new StringBuilder();
                        for (int i17 = 0; i17 < strArr.length; i17++) {
                            if (i17 > 0) {
                                sb5.append(" OR ");
                            }
                            sb5.append("mMainTaskId = ?");
                        }
                        arrayList2.add(sb5.toString());
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (String[] strArr2 : arrayList) {
                        StringBuilder sb6 = new StringBuilder();
                        for (int i18 = 0; i18 < strArr2.length; i18++) {
                            if (i18 > 0) {
                                sb6.append(" OR ");
                            }
                            sb6.append("mTaskId = ?");
                        }
                        arrayList3.add(sb6.toString());
                    }
                    for (int i19 = 0; i19 < arrayList.size(); i19++) {
                        synchronized (u16) {
                            u16.delete(GuildDbDataHelper.f222901c, (String) arrayList2.get(i19), (String[]) Arrays.copyOf((String[]) arrayList.get(i19), ((String[]) arrayList.get(i19)).length));
                            u16.delete(GuildTaskProgressState.TABLE_NAME, (String) arrayList3.get(i19), (String[]) Arrays.copyOf((String[]) arrayList.get(i19), ((String[]) arrayList.get(i19)).length));
                        }
                    }
                    QLog.d("GUP-T-GuildDbDataHelper", 1, "[deleteTaskEntryList] mainTaskList = " + Arrays.toString(list.toArray()));
                    return;
                }
                QLog.w("GUP-T-GuildDbDataHelper", 1, "[deleteTaskEntryList]  mainTaskIdList is empty");
            }
        });
    }
}
