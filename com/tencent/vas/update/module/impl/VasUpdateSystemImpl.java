package com.tencent.vas.update.module.impl;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.Constants;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.request.TaskBatchUrlReq;
import com.tencent.vas.update.request.TaskBatchUrlRsp;
import com.tencent.vas.update.request.TaskSyncReq;
import com.tencent.vas.update.request.TaskSyncRsp;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sw4.g;
import uw4.c;
import uw4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VasUpdateSystemImpl implements d {

    /* renamed from: c, reason: collision with root package name */
    private uw4.b f384030c;

    /* renamed from: h, reason: collision with root package name */
    private Queue<ItemUpdateVerPtr> f384035h;

    /* renamed from: k, reason: collision with root package name */
    private TaskSyncReq f384038k;

    /* renamed from: l, reason: collision with root package name */
    private int f384039l;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f384031d = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f384037j = true;

    /* renamed from: a, reason: collision with root package name */
    private c f384028a = new TimerModuleImpl(this);

    /* renamed from: b, reason: collision with root package name */
    private uw4.a f384029b = new a();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, vw4.a> f384032e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f384033f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private List<TaskBatchUrlReq> f384034g = Collections.synchronizedList(new ArrayList());

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, ItemUpdateVerPtr> f384036i = new ConcurrentHashMap<>();

    private void A(int i3, String str) {
        TaskBatchUrlReq taskBatchUrlReq;
        TaskBatchUrlRsp parseResponse = TaskBatchUrlRsp.parseResponse(str);
        if (parseResponse == null) {
            return;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_System", "onPbResponse response cookie = " + parseResponse.mCookie);
        ArrayList<UpdateUrlInfoPtr> arrayList = parseResponse.mUpdateList;
        if (arrayList != null) {
            boolean z16 = true;
            if (arrayList.size() > 1) {
                Iterator<UpdateUrlInfoPtr> it = parseResponse.mUpdateList.iterator();
                long j3 = -1;
                while (it.hasNext()) {
                    UpdateUrlInfoPtr next = it.next();
                    if (j3 == -1) {
                        j3 = next.mBid;
                    } else if (j3 != next.mBid) {
                        z16 = false;
                    }
                }
                if (z16) {
                    VasUpdateWrapper.getVasUpdateSystem().a(j3).preHandleGetUrlRsp(parseResponse);
                }
            }
        }
        synchronized (this.f384034g) {
            Iterator<TaskBatchUrlReq> it5 = this.f384034g.iterator();
            while (true) {
                if (it5.hasNext()) {
                    taskBatchUrlReq = it5.next();
                    if (taskBatchUrlReq != null && taskBatchUrlReq.getCookieId() == parseResponse.mCookie) {
                        it5.remove();
                        break;
                    }
                } else {
                    taskBatchUrlReq = null;
                    break;
                }
            }
        }
        if (taskBatchUrlReq != null) {
            taskBatchUrlReq.handlePbResponse(i3, parseResponse);
        }
    }

    private void B(int i3) {
        if (this.f384035h != null && this.f384036i.size() <= 0) {
            if (this.f384035h.size() == 0 && this.f384039l == 1) {
                u(4);
                return;
            }
            synchronized (this.f384036i) {
                int i16 = 0;
                while (true) {
                    int i17 = i16 + 1;
                    if (i16 >= 50) {
                        break;
                    }
                    if (this.f384035h.size() <= 0) {
                        break;
                    }
                    ItemUpdateVerPtr poll = this.f384035h.poll();
                    if (poll == null) {
                        return;
                    }
                    this.f384036i.put(poll.mItemId, poll);
                    q(poll, i3);
                    i16 = i17;
                }
            }
        }
    }

    private void C(int i3, String str) {
        if (this.f384038k != null) {
            this.f384038k.handlePbResponse(i3, TaskSyncRsp.parseResponseJson(str));
        }
    }

    private void D() {
        TaskBatchUrlReq taskBatchUrlReq = new TaskBatchUrlReq();
        synchronized (this.f384032e) {
            this.f384031d.compareAndSet(false, true);
            ArrayList<Map.Entry> arrayList = null;
            for (Map.Entry<String, vw4.a> entry : this.f384032e.entrySet()) {
                if (entry.getValue().v()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(entry);
                }
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                for (Map.Entry entry2 : arrayList) {
                    taskBatchUrlReq.addTask((String) entry2.getKey(), (vw4.a) entry2.getValue());
                    this.f384032e.remove(entry2.getKey());
                }
            } else {
                for (Map.Entry<String, vw4.a> entry3 : this.f384032e.entrySet()) {
                    taskBatchUrlReq.addTask(entry3.getKey(), entry3.getValue());
                }
                this.f384032e.clear();
            }
            this.f384031d.set(false);
            this.f384037j = true;
        }
        synchronized (this.f384034g) {
            if (taskBatchUrlReq.getTaskCount() > 0) {
                this.f384034g.add(taskBatchUrlReq);
                if (!VasUpdateWrapper.getCmdManager().a("GetUrlReq", taskBatchUrlReq.getRequest(), this)) {
                    taskBatchUrlReq.onSendPbMsgError();
                    this.f384034g.remove(taskBatchUrlReq);
                }
            }
        }
    }

    private void E() {
        u(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@NonNull BusinessUpdateParams businessUpdateParams, boolean z16) {
        String str;
        String str2 = businessUpdateParams.mFrom;
        String str3 = businessUpdateParams.mItemId;
        VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem params = \n" + businessUpdateParams.toString());
        if (TextUtils.isEmpty(str2)) {
            com.tencent.vas.update.entity.a aVar = new com.tencent.vas.update.entity.a();
            aVar.f384001a = 3;
            aVar.f384002b = 11;
            aVar.f384003c = 0;
            aVar.f384004d = "current from = null , itemId " + str3;
            b(businessUpdateParams, aVar, null);
            return;
        }
        String b16 = VasUpdateWrapper.getDbManager().b(1, str3);
        if (r(businessUpdateParams, b16)) {
            VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem select should_update , ItemId = " + str3 + " , content = " + b16 + ", checkCurrentItemValid:true");
            return;
        }
        String b17 = VasUpdateWrapper.getDbManager().b(0, str3);
        VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem select local , ItemId = " + str3 + " , content = " + b17);
        ItemUpdateVerPtr itemUpdateVerPtr = new ItemUpdateVerPtr();
        if (TextUtils.isEmpty(b17)) {
            itemUpdateVerPtr.mItemId = str3;
            itemUpdateVerPtr.mSrcMd5 = "";
            itemUpdateVerPtr.mDstMd5 = "";
            itemUpdateVerPtr.mFrom = str2;
            itemUpdateVerPtr.mLastRunTime = 0L;
            itemUpdateVerPtr.mRunCount = 0;
        } else {
            ItemLocalVerPrt parseJsonToItemLocalVerPrt = ItemLocalVerPrt.parseJsonToItemLocalVerPrt(b17);
            itemUpdateVerPtr.mItemId = str3;
            if (parseJsonToItemLocalVerPrt == null) {
                str = "";
            } else {
                str = parseJsonToItemLocalVerPrt.mMd5;
            }
            itemUpdateVerPtr.mSrcMd5 = str;
            itemUpdateVerPtr.mDstMd5 = "";
            itemUpdateVerPtr.mFrom = str2;
            itemUpdateVerPtr.mLastRunTime = 0L;
            itemUpdateVerPtr.mRunCount = 0;
        }
        p(itemUpdateVerPtr, businessUpdateParams, 3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        boolean z16;
        TaskSyncReq taskSyncReq = this.f384038k;
        if (taskSyncReq != null) {
            taskSyncReq.loadSeqConfig();
            try {
                z16 = VasUpdateWrapper.getCmdManager().a("SyncVCRReq", this.f384038k.getRequest(), this);
            } catch (Throwable th5) {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "sendSyncRequest exception", th5);
                th5.printStackTrace();
                z16 = false;
            }
            if (!z16) {
                this.f384038k.onSendPbMsgError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3) {
        if (i3 != 3 && this.f384032e.size() < 50) {
            this.f384028a.a(1);
            this.f384028a.b(1, VasUpdateWrapper.getCommonManager().d(), false);
        } else {
            onTime(1);
        }
    }

    private boolean I() {
        try {
            long parseLong = Long.parseLong(VasUpdateWrapper.getDbManager().b(3, "time_value"));
            long parseLong2 = Long.parseLong(VasUpdateWrapper.getDbManager().b(3, "time_success"));
            long a16 = VasUpdateWrapper.getCommonManager().a();
            g log = VasUpdateWrapper.getLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("syncEnable timeValue = ");
            sb5.append(parseLong);
            sb5.append(" offest = ");
            long j3 = a16 - parseLong2;
            sb5.append(j3);
            log.i("VasUpdate_System", sb5.toString());
            if (j3 >= parseLong) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "doSyncTable exception", th5);
            th5.printStackTrace();
            return true;
        }
    }

    private void J(int i3) {
        VasUpdateWrapper.getDbManager().d(3, "time_value", String.valueOf(i3));
        VasUpdateWrapper.getDbManager().d(3, "time_success", String.valueOf(VasUpdateWrapper.getCommonManager().a()));
    }

    private void p(@NonNull ItemUpdateVerPtr itemUpdateVerPtr, @NonNull BusinessUpdateParams businessUpdateParams, int i3, boolean z16) {
        if (s(itemUpdateVerPtr.mItemId)) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun currentItem is filter , itemId = " + businessUpdateParams.mItemId);
            if (qw4.a.f430257a) {
                int z17 = z(itemUpdateVerPtr.mItemId);
                com.tencent.vas.update.entity.a aVar = new com.tencent.vas.update.entity.a();
                aVar.f384006f = 0L;
                aVar.f384002b = z17;
                aVar.f384003c = 0;
                aVar.f384004d = "resources empty limit getUrl = -20002";
                aVar.f384005e = 0L;
                aVar.f384001a = i3;
                b(businessUpdateParams, aVar, null);
                return;
            }
            return;
        }
        if (this.f384031d.get()) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun currentItem thread is lock , itemId = " + businessUpdateParams.mItemId);
        }
        synchronized (this.f384032e) {
            if (this.f384032e.containsKey(itemUpdateVerPtr.mItemId)) {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun mTempTaskMaps hasContain itemid = " + itemUpdateVerPtr.mItemId);
                return;
            }
            VasUpdateWrapper.getLog().e("VasUpdate_System", "start addItemVersionForStartRun itemId = " + businessUpdateParams.mItemId + " mGetUrlTimerFinish = " + this.f384037j);
            String str = itemUpdateVerPtr.mItemId;
            vw4.a x16 = x(itemUpdateVerPtr, businessUpdateParams, i3, str, z16);
            if (x16 == null) {
                return;
            }
            x16.C();
            this.f384032e.put(str, x16);
        }
    }

    private void q(ItemUpdateVerPtr itemUpdateVerPtr, int i3) {
        if (itemUpdateVerPtr != null && !TextUtils.isEmpty(itemUpdateVerPtr.mItemId)) {
            if (a(CommonUtil.sParseBidId(itemUpdateVerPtr.mItemId)) == null) {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete requestList currentItem not register , itemId = " + itemUpdateVerPtr.mItemId);
                VasUpdateWrapper.getDbManager().c(1, itemUpdateVerPtr.mItemId);
                return;
            }
            p(itemUpdateVerPtr, new BusinessUpdateParams(CommonUtil.sParseBidId(itemUpdateVerPtr.mItemId), CommonUtil.sParseScid(itemUpdateVerPtr.mItemId), itemUpdateVerPtr.mFrom), i3, false);
            H(i3);
        }
    }

    private boolean r(@NonNull BusinessUpdateParams businessUpdateParams, String str) {
        ItemUpdateVerPtr parseJsonToItemUpdateVerPrt;
        if (TextUtils.isEmpty(str) || (parseJsonToItemUpdateVerPrt = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt(str)) == null) {
            return false;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - parseJsonToItemUpdateVerPrt.mLastRunTime;
        if (parseJsonToItemUpdateVerPrt.mRunCount >= 3 && currentTimeMillis >= 0 && currentTimeMillis < 8) {
            com.tencent.vas.update.entity.a aVar = new com.tencent.vas.update.entity.a();
            aVar.f384001a = 3;
            aVar.f384002b = 20;
            aVar.f384003c = 0;
            aVar.f384004d = " update delay retry ";
            b(businessUpdateParams, aVar, null);
            return true;
        }
        if (qw4.a.f430262f) {
            parseJsonToItemUpdateVerPrt.mFrom = businessUpdateParams.mFrom;
        }
        p(parseJsonToItemUpdateVerPrt, businessUpdateParams, 3, false);
        H(3);
        return true;
    }

    private boolean s(String str) {
        return this.f384033f.containsKey(str);
    }

    private boolean t(@NonNull ItemUpdateVerPtr itemUpdateVerPtr) {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - itemUpdateVerPtr.mLastRunTime;
        if (itemUpdateVerPtr.mRunCount >= 3 && currentTimeMillis < JoinTimeType.SIX_HOUR) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete checkLastTime , itemId = " + itemUpdateVerPtr.mItemId + " time = " + currentTimeMillis);
            return true;
        }
        return false;
    }

    private void u(int i3) {
        if (!I() && i3 != 4) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "doSyncTable enable = false");
            return;
        }
        Queue<ItemUpdateVerPtr> queue = this.f384035h;
        if (queue != null && queue.size() != 0) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "doSyncTable isDoing , queue size = " + this.f384035h.size());
            return;
        }
        if (this.f384038k != null) {
            VasUpdateWrapper.getLog().d("VasUpdate_System", "doSyncTable request != null");
            return;
        }
        VasUpdateWrapper.getLog().d("VasUpdate_System", "start doSyncTable dlFrom = " + i3);
        this.f384028a.a(2);
        this.f384038k = new TaskSyncReq(i3);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.vas.update.module.impl.VasUpdateSystemImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    VasUpdateSystemImpl.this.G();
                }
            });
        } else {
            G();
        }
    }

    private boolean w(int i3, ItemUpdateVerPtr itemUpdateVerPtr) {
        if (itemUpdateVerPtr != null && !TextUtils.isEmpty(itemUpdateVerPtr.mItemId)) {
            if (!itemUpdateVerPtr.checkItemIsCurrentVersion()) {
                return true;
            }
            itemUpdateVerPtr.mFrom = Constants.UpdateFrom.SILENT_UPDATE;
            long sParseBidId = CommonUtil.sParseBidId(itemUpdateVerPtr.mItemId);
            String sParseScid = CommonUtil.sParseScid(itemUpdateVerPtr.mItemId);
            IBusinessCallback a16 = a(sParseBidId);
            if (a16 == null) {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete currentItem not register , itemId = " + itemUpdateVerPtr.mItemId);
                VasUpdateWrapper.getDbManager().c(1, itemUpdateVerPtr.mItemId);
                return true;
            }
            BusinessItemInfo businessItemInfo = a16.getBusinessItemInfo(sParseBidId, sParseScid);
            if (businessItemInfo == null) {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete getItemInfo fail , itemId = " + itemUpdateVerPtr.mItemId);
                VasUpdateWrapper.getDbManager().c(1, itemUpdateVerPtr.mItemId);
                return true;
            }
            BusinessUpdateParams businessUpdateParams = new BusinessUpdateParams(sParseBidId, sParseScid, itemUpdateVerPtr.mFrom);
            if (businessItemInfo.mIsCanUpdate) {
                return false;
            }
            com.tencent.vas.update.entity.a aVar = new com.tencent.vas.update.entity.a();
            aVar.f384001a = i3;
            aVar.f384002b = 1;
            aVar.f384003c = 0;
            aVar.f384004d = "can update = false";
            b(businessUpdateParams, aVar, null);
            return true;
        }
        VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete node doesn't have updateItem , continue , itemId = " + itemUpdateVerPtr.mItemId);
        return true;
    }

    private vw4.a x(@NonNull ItemUpdateVerPtr itemUpdateVerPtr, @NonNull BusinessUpdateParams businessUpdateParams, int i3, String str, boolean z16) {
        IBusinessCallback a16 = a(CommonUtil.sParseBidId(str));
        if (a16 == null) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun currentItem not register , itemId = " + str);
            VasUpdateWrapper.getDbManager().c(1, str);
            return null;
        }
        BusinessItemInfo businessItemInfo = a16.getBusinessItemInfo(CommonUtil.sParseBidId(str), CommonUtil.sParseScid(str));
        if (businessItemInfo == null) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun getItemInfo fail, itemId = " + str);
            VasUpdateWrapper.getDbManager().c(1, str);
            return null;
        }
        vw4.a aVar = new vw4.a(businessUpdateParams, itemUpdateVerPtr, businessItemInfo);
        aVar.B(z16);
        aVar.A(i3);
        return aVar;
    }

    private LinkedList<ItemUpdateVerPtr> y(int i3, HashMap<String, ItemUpdateVerPtr> hashMap) {
        LinkedList<ItemUpdateVerPtr> linkedList = new LinkedList<>();
        if (hashMap != null) {
            for (Map.Entry<String, ItemUpdateVerPtr> entry : hashMap.entrySet()) {
                if (entry != null && entry.getValue() != null) {
                    ItemUpdateVerPtr value = entry.getValue();
                    if (w(i3, value)) {
                        continue;
                    } else {
                        synchronized (this.f384032e) {
                            if (this.f384032e.containsKey(value.mItemId) && this.f384032e.get(value.mItemId) != null) {
                                this.f384032e.get(value.mItemId).A(i3);
                            } else if (value.mRunCount >= 10) {
                                VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete item runcount >= 10 , delete, itemId = " + value.mItemId);
                                if (qw4.a.f430260d) {
                                    VasUpdateWrapper.getDbManager().c(1, value.mItemId);
                                }
                            } else if (!t(value)) {
                                linkedList.add(value);
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    private int z(String str) {
        Integer num = this.f384033f.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // uw4.d
    public IBusinessCallback a(long j3) {
        uw4.b bVar = this.f384030c;
        if (bVar == null) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "getObserver , notification = null");
            return null;
        }
        return bVar.a(j3);
    }

    @Override // uw4.d
    public void b(@NonNull BusinessUpdateParams businessUpdateParams, @NonNull com.tencent.vas.update.entity.a aVar, DLReportInfo dLReportInfo) {
        VasUpdateWrapper.getLog().i("VasUpdate_System", "onTaskItemComplete itemId = " + businessUpdateParams.mItemId + ", errorCode = " + aVar.f384002b + " , httpCode = " + aVar.f384003c);
        uw4.b bVar = this.f384030c;
        if (bVar == null) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemComplete , notify = null");
            return;
        }
        int i3 = aVar.f384002b;
        if (i3 != 0) {
            bVar.c(businessUpdateParams, i3, aVar.f384003c, aVar.f384004d);
        } else {
            bVar.b(businessUpdateParams);
        }
        com.tencent.vas.update.entity.b bVar2 = new com.tencent.vas.update.entity.b(aVar, CommonUtil.sParseBidId(businessUpdateParams.mItemId), CommonUtil.sParseScid(businessUpdateParams.mItemId));
        if (dLReportInfo != null) {
            bVar2.f384010d = dLReportInfo.mDstMd5;
            bVar2.f384011e = dLReportInfo.mIsIncrement;
            bVar2.f384014h = dLReportInfo.mRetryCount;
            VasUpdateWrapper.getReportManager().a(bVar2);
        } else {
            bVar2.f384010d = "";
            bVar2.f384011e = false;
            bVar2.f384014h = 0;
            VasUpdateWrapper.getReportManager().a(bVar2);
        }
        synchronized (this.f384036i) {
            this.f384036i.remove(businessUpdateParams.mItemId);
        }
        B(5);
    }

    @Override // uw4.d
    public void c(uw4.b bVar) {
        this.f384030c = bVar;
    }

    @Override // uw4.d
    public uw4.a d() {
        return this.f384029b;
    }

    @Override // uw4.d
    public void e() {
        u(1);
    }

    @Override // uw4.d
    public void f(BusinessUpdateParams businessUpdateParams, int i3) {
        if (businessUpdateParams == null) {
            return;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_System", "addFilterTaskItem params = " + businessUpdateParams.toString());
        this.f384033f.put(businessUpdateParams.mItemId, Integer.valueOf(i3));
    }

    @Override // uw4.d
    public void g(final List<BusinessUpdateParams> list) {
        ThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.vas.update.module.impl.VasUpdateSystemImpl.2
            @Override // java.lang.Runnable
            public void run() {
                for (BusinessUpdateParams businessUpdateParams : list) {
                    if (businessUpdateParams != null && businessUpdateParams.mBid > 0) {
                        VasUpdateSystemImpl.this.F(businessUpdateParams, true);
                    } else {
                        throw new RuntimeException("system request download business or params = null or bid <= 0");
                    }
                }
                VasUpdateSystemImpl.this.H(3);
            }
        });
    }

    @Override // uw4.d
    public void h(int i3) {
        this.f384039l = i3;
    }

    @Override // uw4.d
    public void i(BusinessUpdateParams businessUpdateParams, long j3, long j16, int i3) {
        uw4.b bVar = this.f384030c;
        if (bVar == null) {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemProgress , notify = null");
        } else {
            bVar.d(businessUpdateParams, j3, j16, i3);
        }
    }

    @Override // uw4.d
    public void j(BusinessUpdateParams businessUpdateParams) {
        v(businessUpdateParams, false);
    }

    @Override // uw4.d
    public void k(int i3, int i16, HashMap<String, ItemUpdateVerPtr> hashMap) {
        this.f384038k = null;
        LinkedList<ItemUpdateVerPtr> y16 = y(i16, hashMap);
        Queue<ItemUpdateVerPtr> queue = this.f384035h;
        if (queue == null) {
            this.f384035h = y16;
        } else {
            queue.addAll(y16);
        }
        VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete mSyncItemList size = " + this.f384035h.size());
        B(i16);
        VasUpdateWrapper.getLog().d("VasUpdate_System", "onTaskSyncTableComplete start update request , size = " + this.f384032e.size());
        if (i3 > 0) {
            J(i3);
            this.f384028a.b(2, i3 * 1000, false);
        }
    }

    @Override // uw4.d
    public void l(long j3, String str) {
        VasUpdateWrapper.getLog().i("VasUpdate_System", "cancelDownload bid = " + j3 + " scid = " + str);
        VasUpdateWrapper.getHttpDownloader().cancelDownload(CommonUtil.sComposeItemId(j3, str));
    }

    @Override // com.tencent.vas.update.callback.listener.ICmdListener
    public void onPbResponse(int i3, String str, String str2) {
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().i("VasUpdate_System", "onPbResponse cmd = " + str + " result = " + i3 + " response = " + str2);
        }
        if ("GetUrlRsp".equalsIgnoreCase(str)) {
            A(i3, str2);
        } else if ("SyncVCRRsp".equalsIgnoreCase(str)) {
            C(i3, str2);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.ITimerListener
    public void onTime(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                E();
                return;
            }
            return;
        }
        D();
    }

    public void v(final BusinessUpdateParams businessUpdateParams, final boolean z16) {
        if (businessUpdateParams != null && businessUpdateParams.mBid > 0) {
            ThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.vas.update.module.impl.VasUpdateSystemImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    VasUpdateSystemImpl.this.F(businessUpdateParams, z16);
                    VasUpdateSystemImpl.this.H(3);
                }
            });
            return;
        }
        throw new RuntimeException("system request download business or params = null or bid <= 0");
    }
}
