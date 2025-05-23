package com.tencent.mobileqq.searchlocal.searchengine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.PublicAccountInfoForSearch;
import com.tencent.mobileqq.search.model.k;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import on2.d;

/* loaded from: classes18.dex */
public class PublicAccountSearchEngine implements on2.b<up2.b>, Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<up2.b> f285242h = new a();

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator<up2.b> f285243i = new b();

    /* renamed from: d, reason: collision with root package name */
    private IPublicAccountDataManager f285244d;

    /* renamed from: e, reason: collision with root package name */
    private final AppInterface f285245e;

    /* renamed from: f, reason: collision with root package name */
    private int f285246f;

    /* loaded from: classes18.dex */
    class a implements Comparator<up2.b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(up2.b bVar, up2.b bVar2) {
            int signum = Long.signum(bVar2.I() - bVar.I());
            if (signum == 0) {
                return PublicAccountSearchEngine.d(bVar, bVar2);
            }
            return signum;
        }
    }

    /* loaded from: classes18.dex */
    class b implements Comparator<up2.b> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(up2.b bVar, up2.b bVar2) {
            int signum = Long.signum(bVar2.I() - bVar.I());
            if (signum == 0) {
                signum = Long.signum(bVar2.J() - bVar.J());
            }
            if (signum == 0) {
                return PublicAccountSearchEngine.d(bVar, bVar2);
            }
            return signum;
        }
    }

    public PublicAccountSearchEngine(AppInterface appInterface, int i3) {
        this.f285246f = -1;
        this.f285245e = appInterface;
        this.f285244d = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        this.f285246f = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(k kVar, k kVar2) {
        int i3;
        if (kVar2.getTitleSpans() != null && kVar.getTitleSpans() != null) {
            i3 = kVar.getTitleSpans().toString().compareTo(kVar2.getTitleSpans().toString());
        } else {
            i3 = 0;
        }
        if (i3 == 0 && kVar2.getSubTitleSpans() != null && kVar.getSubTitleSpans() != null) {
            return kVar.getSubTitleSpans().toString().compareTo(kVar2.getSubTitleSpans().toString());
        }
        return i3;
    }

    @Override // on2.b
    public List<up2.b> a(pn2.a aVar) {
        IQidianManagerApi iQidianManagerApi;
        up2.b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        do {
        } while (this.f285244d.isBuildingList());
        long currentTimeMillis2 = System.currentTimeMillis();
        List<Entity> publicAccountList = this.f285244d.getPublicAccountList();
        if (publicAccountList != null && !publicAccountList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = publicAccountList.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                PublicAccountInfoForSearch convertToPublicAccountEntity = ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).convertToPublicAccountEntity(publicAccountList.get(i16));
                if (convertToPublicAccountEntity != null && (((iQidianManagerApi = (IQidianManagerApi) this.f285245e.getRuntimeService(IQidianManagerApi.class, "")) == null || !iQidianManagerApi.isQidianMaster(convertToPublicAccountEntity.getUinString())) && !TextUtils.equals(convertToPublicAccountEntity.getUinString(), AppConstants.PUBLIC_ACCOUNT_READINJOY_FOLLOW_UIN) && (this.f285246f != 12 || ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.f285245e, convertToPublicAccountEntity.getUinString())))) {
                    up2.b bVar2 = new up2.b(this.f285245e, convertToPublicAccountEntity, this.f285246f);
                    bVar2.O(aVar.f426495a);
                    if (bVar2.I() != Long.MIN_VALUE && ((bVar = (up2.b) hashMap.get(bVar2.getUin())) == null || bVar.I() < bVar2.I())) {
                        hashMap.put(bVar2.getUin(), bVar2);
                    }
                    if (convertToPublicAccountEntity.getDisplayNumber() != null && convertToPublicAccountEntity.getDisplayNumber().equalsIgnoreCase(bVar2.getKeyword())) {
                        arrayList.add(bVar2);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(hashMap.values());
            Collections.sort(arrayList2, f285242h);
            int min = Math.min(arrayList2.size(), 30);
            List subList = arrayList2.subList(0, min);
            Collections.sort(subList, f285243i);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(subList);
            arrayList3.addAll(arrayList2.subList(min, arrayList2.size()));
            arrayList3.removeAll(arrayList);
            arrayList3.addAll(0, arrayList);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                i3++;
                ((up2.b) it.next()).S(i3);
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (QLog.isDevelopLevel()) {
                QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (currentTimeMillis3 - currentTimeMillis) + ", pure search cost:" + (currentTimeMillis3 - currentTimeMillis2));
            }
            return arrayList3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountSearchEngine", 2, "all publicAccountInfoList is null or empty");
            return null;
        }
        return null;
    }

    @Override // on2.b
    public void c(final pn2.a aVar, final d<up2.b> dVar) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine.1
            @Override // java.lang.Runnable
            public void run() {
                List<up2.b> a16 = PublicAccountSearchEngine.this.a(aVar);
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onFinish(a16, 1);
                }
            }
        }, null, true);
        if (!TextUtils.isEmpty(aVar.f426495a)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f285245e, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", aVar.f426495a, "", false);
        }
    }

    @Override // on2.b
    public void init() {
        IPublicAccountDataManager iPublicAccountDataManager = this.f285244d;
        if (iPublicAccountDataManager != null && !iPublicAccountDataManager.isCached()) {
            ThreadManagerV2.post(this, 5, null, true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f285244d.initPublicAccountDataManager();
    }

    @Override // on2.b
    public void cancel() {
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
