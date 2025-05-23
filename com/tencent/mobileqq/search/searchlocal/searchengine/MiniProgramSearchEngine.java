package com.tencent.mobileqq.search.searchlocal.searchengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import on2.d;
import rn2.k;

/* loaded from: classes18.dex */
public class MiniProgramSearchEngine implements on2.b<up2.a>, Runnable {

    /* renamed from: d, reason: collision with root package name */
    protected int f284850d;

    /* loaded from: classes18.dex */
    class a implements Comparator<up2.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(up2.a aVar, up2.a aVar2) {
            int[] iArr = aVar2.Z;
            int i3 = iArr[2];
            int[] iArr2 = aVar.Z;
            int i16 = i3 - iArr2[2];
            if (i16 != 0) {
                return i16;
            }
            int i17 = iArr2[0] - iArr[0];
            if (i17 != 0) {
                return i17;
            }
            String title = aVar.getTitle();
            int[] iArr3 = aVar.Z;
            String substring = title.substring(iArr3[0] + iArr3[1]);
            String title2 = aVar2.getTitle();
            int[] iArr4 = aVar2.Z;
            return ChnToSpell.d(substring, 2).compareTo(ChnToSpell.d(title2.substring(iArr4[0] + iArr4[1]), 2));
        }
    }

    public MiniProgramSearchEngine(AppInterface appInterface, int i3) {
        this.f284850d = i3;
    }

    @Override // on2.b
    public List<up2.a> a(pn2.a aVar) {
        int i3;
        List<MiniAppLocalSearchEntity> localSearchData = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getLocalSearchData();
        if (localSearchData != null && localSearchData.size() != 0) {
            ArrayList arrayList = new ArrayList(localSearchData.size() + 1);
            ArrayList arrayList2 = new ArrayList(localSearchData.size() + 1);
            Iterator<MiniAppLocalSearchEntity> it = localSearchData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MiniAppLocalSearchEntity next = it.next();
                int[] q06 = SearchUtils.q0(aVar.f426495a, next.appName, false);
                if (q06 != null && q06.length >= 3 && q06[0] > -1) {
                    up2.a aVar2 = new up2.a(e(), this.f284850d, next, aVar.f426495a, next.schema);
                    aVar2.Z = q06;
                    if (next.appName.equals(aVar.f426495a)) {
                        arrayList2.add(0, aVar2);
                    } else {
                        arrayList2.add(aVar2);
                    }
                }
            }
            arrayList.addAll(arrayList2);
            Collections.sort(arrayList2, new a());
            int size = arrayList.size();
            for (i3 = 0; i3 < size; i3++) {
                k.e((y) arrayList.get(i3), size, i3);
            }
            return arrayList;
        }
        return null;
    }

    public /* synthetic */ AppInterface e() {
        return on2.a.a(this);
    }

    @Override // on2.b
    public void cancel() {
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void init() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // on2.b
    public void c(pn2.a aVar, d<up2.a> dVar) {
    }
}
