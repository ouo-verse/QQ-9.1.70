package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.ae;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.l;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSelectorSearchEngine implements on2.b<a>, ae.e {

    /* renamed from: d, reason: collision with root package name */
    private int f207915d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f207916e;

    /* renamed from: f, reason: collision with root package name */
    private Context f207917f;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f207918h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f207919i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f207920m = false;
    private boolean C = false;
    List<FileInfo> D = null;
    private SearchRunnable E = new SearchRunnable();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        pn2.a f207921d;

        /* renamed from: e, reason: collision with root package name */
        on2.d<a> f207922e;

        SearchRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn2.a aVar;
            try {
                pn2.a aVar2 = this.f207921d;
                if (aVar2 == null) {
                    this.f207922e.onFinish(new ArrayList(), 6);
                    return;
                }
                String str = aVar2.f426495a;
                List<a> a16 = FileSelectorSearchEngine.this.a(aVar2);
                synchronized (this) {
                    if (this.f207922e != null && aVar2 == (aVar = this.f207921d) && str.equals(aVar.f426495a)) {
                        this.f207922e.onFinish(a16, 1);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public FileSelectorSearchEngine(QQAppInterface qQAppInterface, Context context, int i3) {
        this.f207915d = 0;
        this.f207916e = qQAppInterface;
        this.f207917f = context;
        this.f207915d = i3;
    }

    private List<a> e(pn2.a aVar) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        HashMap<String, List<FileInfo>> hashMap = new HashMap<>();
        int i3 = this.f207918h.getInt("file_choose_extension_handle_type", -1);
        if (i3 != 1) {
            str = "";
            str2 = ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|";
        } else {
            str = this.f207918h.getString("file_choose_extension_in_filter");
            str2 = this.f207918h.getString("file_choose_extension_out_filter");
            if (str.equals("") || str.contains(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|")) {
                String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/QQ/";
                if (str3 != null) {
                    ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, str3, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", hashMap, null);
                }
            }
        }
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        if (!TextUtils.isEmpty(defaultRecvPath)) {
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, defaultRecvPath, str, str2, hashMap, null);
        }
        if (i3 == -1 && d()) {
            if (!this.C) {
                this.D = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).qureyApks(this.f207917f, null);
                this.C = true;
            }
            List<FileInfo> list = this.D;
            if (list != null && !list.isEmpty()) {
                hashMap.put("installedApk", this.D);
            }
        }
        String otherRecvPath = lc1.b.a().getOtherRecvPath();
        if (otherRecvPath != null) {
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, otherRecvPath, str, str2, hashMap, null);
        }
        HashMap hashMap2 = new HashMap();
        if (!hashMap.isEmpty()) {
            ArrayList<FileInfo> arrayList2 = new ArrayList();
            for (List<FileInfo> list2 : hashMap.values()) {
                if (list2 != null && !list2.isEmpty()) {
                    arrayList2.addAll(list2);
                }
            }
            if (!arrayList2.isEmpty()) {
                for (FileInfo fileInfo : arrayList2) {
                    String j3 = fileInfo.j();
                    if (j3.indexOf(aVar.f426495a) >= 0) {
                        if (!hashMap2.containsKey(j3)) {
                            hashMap2.put(j3, new ArrayList());
                        }
                        ((List) hashMap2.get(j3)).add(fileInfo);
                    } else if (SearchUtils.j0(aVar.f426495a, j3, j.f283423k) > Long.MIN_VALUE) {
                        if (!hashMap2.containsKey(j3)) {
                            hashMap2.put(j3, new ArrayList());
                        }
                        ((List) hashMap2.get(j3)).add(fileInfo);
                    }
                }
            }
            if (!hashMap2.isEmpty()) {
                for (String str4 : hashMap2.keySet()) {
                    d dVar = new d(aVar.f426495a, this.f207915d);
                    dVar.R((List) hashMap2.get(str4));
                    dVar.P(this.f207918h);
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    private List<a> f(pn2.a aVar) {
        Map<String, List<FileManagerEntity>> T = this.f207916e.getFileManagerDataCenter().T(aVar.f426495a);
        ArrayList arrayList = new ArrayList();
        for (String str : T.keySet()) {
            f fVar = new f(aVar.f426495a, this.f207915d);
            List<FileManagerEntity> list = T.get(str);
            fVar.P(this.f207918h);
            fVar.Q(list);
            if (fVar.L() > 0) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    private List<a> g(pn2.a aVar) {
        return new ArrayList();
    }

    @Override // on2.b
    public List<a> a(pn2.a aVar) {
        List<a> list;
        int i3 = this.f207915d;
        if (i3 == 16) {
            list = f(aVar);
        } else if (i3 == 17) {
            list = e(aVar);
        } else if (i3 == 18) {
            list = g(aVar);
        } else {
            list = null;
        }
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    @Override // on2.b
    public void c(pn2.a aVar, on2.d<a> dVar) {
        String str;
        if (aVar != null && (str = aVar.f426495a) != null && !TextUtils.isEmpty(str.trim())) {
            synchronized (this.E) {
                SearchRunnable searchRunnable = this.E;
                searchRunnable.f207921d = aVar;
                searchRunnable.f207922e = dVar;
                ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
                ThreadManagerV2.executeOnFileThread(this.E);
            }
        }
    }

    @Override // on2.b
    public void cancel() {
        synchronized (this.E) {
            SearchRunnable searchRunnable = this.E;
            searchRunnable.f207921d = null;
            searchRunnable.f207922e = null;
            ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 64);
        }
    }

    protected boolean d() {
        if (this.f207920m) {
            return this.f207919i;
        }
        boolean z16 = this.f207917f.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
        this.f207919i = z16;
        this.f207920m = true;
        return z16;
    }

    public void h(Bundle bundle) {
        this.f207918h = bundle;
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

    @Override // com.tencent.mobileqq.search.ae.e
    public void b(int i3, List<? extends l> list) {
    }
}
