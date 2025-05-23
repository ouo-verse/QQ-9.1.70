package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ChatFileManagerSearchEngine implements on2.b<a> {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f207836d;

    /* renamed from: e, reason: collision with root package name */
    private int f207837e;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f207839h;

    /* renamed from: f, reason: collision with root package name */
    private int f207838f = 1;

    /* renamed from: i, reason: collision with root package name */
    private SearchRunnable f207840i = new SearchRunnable();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        pn2.a f207841d;

        /* renamed from: e, reason: collision with root package name */
        on2.d<a> f207842e;

        SearchRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn2.a aVar;
            try {
                pn2.a aVar2 = this.f207841d;
                if (aVar2 == null) {
                    this.f207842e.onFinish(new ArrayList(), 6);
                    return;
                }
                String str = aVar2.f426495a;
                List<a> a16 = ChatFileManagerSearchEngine.this.a(aVar2);
                synchronized (this) {
                    if (this.f207842e != null && aVar2 == (aVar = this.f207841d) && str.equals(aVar.f426495a)) {
                        this.f207842e.onFinish(a16, 1);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public ChatFileManagerSearchEngine(QQAppInterface qQAppInterface, int i3) {
        this.f207837e = 0;
        this.f207836d = qQAppInterface;
        this.f207837e = i3;
    }

    private List<Integer> b(int i3) {
        ArrayList arrayList = new ArrayList();
        if (i3 == 3) {
            arrayList.add(9);
            arrayList.add(7);
            arrayList.add(6);
            arrayList.add(3);
        } else {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    @Override // on2.b
    public List<a> a(pn2.a aVar) {
        Bundle bundle;
        List<FileManagerEntity> W;
        ArrayList arrayList = new ArrayList();
        int i3 = this.f207838f;
        if (i3 == 1) {
            Map<String, List<FileManagerEntity>> T = this.f207836d.getFileManagerDataCenter().T(aVar.f426495a);
            for (String str : T.keySet()) {
                a aVar2 = new a();
                aVar2.G.addAll(T.get(str));
                aVar2.H = aVar.f426495a;
                aVar2.K = this.f207837e;
                Bundle bundle2 = this.f207839h;
                if (bundle2 != null) {
                    aVar2.L = bundle2.getString("qfile_search_param_uin", "");
                }
                arrayList.add(aVar2);
            }
        } else if (i3 == 4) {
            Bundle bundle3 = this.f207839h;
            if (bundle3 != null) {
                int i16 = bundle3.getInt("qfile_search_param_type", -1);
                String string = this.f207839h.getString("qfile_search_param_uin", "");
                ArrayList<Integer> integerArrayList = this.f207839h.getIntegerArrayList("qfile_search_param_others");
                if (i16 != -1 && !TextUtils.isEmpty(string)) {
                    if (i16 == 11) {
                        if (integerArrayList.contains(3)) {
                            integerArrayList.add(6);
                            integerArrayList.add(7);
                            integerArrayList.add(9);
                        }
                        W = this.f207836d.getFileManagerDataCenter().V(integerArrayList, string);
                    } else {
                        W = this.f207836d.getFileManagerDataCenter().W(b(i16), string);
                    }
                    if (W != null) {
                        for (FileManagerEntity fileManagerEntity : W) {
                            a aVar3 = new a();
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(fileManagerEntity);
                            aVar3.G.addAll(arrayList2);
                            aVar3.H = aVar.f426495a;
                            aVar3.K = this.f207837e;
                            aVar3.L = string;
                            arrayList.add(aVar3);
                        }
                    }
                }
            }
        } else if (i3 == 3 && (bundle = this.f207839h) != null) {
            String string2 = bundle.getString("qfile_search_param_uin", "");
            for (FileManagerEntity fileManagerEntity2 : this.f207836d.getFileManagerDataCenter().U(aVar.f426495a, string2, false)) {
                a aVar4 = new a();
                ArrayList arrayList3 = new ArrayList(1);
                arrayList3.add(fileManagerEntity2);
                aVar4.G.addAll(arrayList3);
                aVar4.H = aVar.f426495a;
                aVar4.K = this.f207837e;
                aVar4.L = string2;
                arrayList.add(aVar4);
            }
        }
        return arrayList;
    }

    @Override // on2.b
    public void c(pn2.a aVar, on2.d<a> dVar) {
        String str;
        if (aVar != null && (str = aVar.f426495a) != null && !TextUtils.isEmpty(str.trim())) {
            synchronized (this.f207840i) {
                SearchRunnable searchRunnable = this.f207840i;
                searchRunnable.f207841d = aVar;
                searchRunnable.f207842e = dVar;
                ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
                ThreadManagerV2.executeOnFileThread(this.f207840i);
            }
        }
    }

    @Override // on2.b
    public void cancel() {
        synchronized (this.f207840i) {
            SearchRunnable searchRunnable = this.f207840i;
            searchRunnable.f207841d = null;
            searchRunnable.f207842e = null;
            ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
        }
    }

    public void d(int i3, Bundle bundle) {
        this.f207838f = i3;
        this.f207839h = bundle;
    }

    @Override // on2.b
    public void init() {
        this.f207836d.getFileManagerProxy().init();
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
