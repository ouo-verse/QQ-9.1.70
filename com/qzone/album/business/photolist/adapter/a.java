package com.qzone.album.business.photolist.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a extends BaseAdapter {

    /* renamed from: b0, reason: collision with root package name */
    public static long f42649b0 = 4294938100000L;
    protected f T;
    protected f U;
    private Comparator<PhotoCacheData> Y;
    private Comparator<PhotoCacheData> Z;

    /* renamed from: a0, reason: collision with root package name */
    private Comparator<Map.Entry<Long, List<PhotoCacheData>>> f42650a0;

    /* renamed from: d, reason: collision with root package name */
    protected x4.a f42651d;

    /* renamed from: f, reason: collision with root package name */
    protected int f42653f;

    /* renamed from: h, reason: collision with root package name */
    protected int f42654h;

    /* renamed from: i, reason: collision with root package name */
    protected int f42655i;

    /* renamed from: m, reason: collision with root package name */
    protected int f42656m;

    /* renamed from: e, reason: collision with root package name */
    protected int f42652e = BasePhotoModelController.f42937x2;
    protected boolean C = false;
    protected boolean D = false;
    protected boolean E = false;
    protected boolean F = false;
    protected boolean G = false;
    protected int H = 0;
    protected int I = 0;
    protected boolean J = false;
    protected boolean K = false;
    protected String L = "";
    protected List<PhotoCacheData[]> M = new ArrayList();
    protected List<PhotoCacheData[]> N = new ArrayList();
    protected List<PhotoCacheData> P = new CopyOnWriteArrayList();
    protected ArrayList<PhotoCacheData> Q = new ArrayList<>();
    public HashMap<Long, s4.d> R = new HashMap<>();
    public HashMap<Long, s4.d> S = new HashMap<>();
    public View.OnClickListener V = new ViewOnClickListenerC0330a();
    public View.OnLongClickListener W = new b();
    protected List<PhotoCacheData> X = null;

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0330a implements View.OnClickListener {
        ViewOnClickListenerC0330a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f fVar = a.this.T;
            if (fVar != null) {
                fVar.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            f fVar = a.this.U;
            if (fVar != null) {
                fVar.onClick(view);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements Comparator<Map.Entry<Long, List<PhotoCacheData>>> {
        e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Long, List<PhotoCacheData>> entry, Map.Entry<Long, List<PhotoCacheData>> entry2) {
            try {
                if (entry.getValue().get(0).uploadtime > entry2.getValue().get(0).uploadtime) {
                    return -1;
                }
                return entry.getValue().get(0).uploadtime == entry2.getValue().get(0).uploadtime ? 0 : 1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface f {
        void onClick(View view);
    }

    public void A(boolean z16) {
        this.D = z16;
    }

    public void B(boolean z16) {
        this.E = z16;
    }

    public void C(boolean z16) {
        this.J = z16;
    }

    public void D(f fVar) {
        this.T = fVar;
    }

    public void E(f fVar) {
        this.U = fVar;
    }

    public void F(int i3) {
        this.H = i3;
    }

    public void G(int i3) {
        this.I = i3;
    }

    public List<PhotoCacheData> I(List<PhotoCacheData[]> list, int i3) {
        Collections.sort(this.Q, QZoneAlbumUtil.w(i3));
        List<PhotoCacheData> list2 = this.P;
        if (list2 == null || list2.size() == 0) {
            List<PhotoCacheData> list3 = this.X;
            if (list3 != null) {
                this.P = list3;
            } else {
                this.P = new ArrayList();
            }
        }
        this.P = e(this.P);
        if (QZoneAlbumUtil.A(this.H)) {
            return this.P;
        }
        if (this.Q.isEmpty() && this.P.isEmpty()) {
            if (list == null) {
                return null;
            }
            list.add(new PhotoCacheData[this.f42652e]);
            return null;
        }
        if (this.J && !this.K) {
            this.Q.addAll(this.P);
        }
        return this.Q;
    }

    public String b(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        HashSet hashSet = new HashSet();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                hashSet.add(str);
            }
        }
        list.clear();
        list.addAll(hashSet);
        if (list.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (list.size() <= 3) {
            for (int i3 = 0; i3 < list.size() - 1; i3++) {
                sb5.append(list.get(i3) + ",");
            }
            sb5.append(list.get(list.size() - 1) + "\u8bb0\u5f55");
        } else {
            sb5.append(list.get(0) + "," + list.get(1) + "\u7b49" + list.size() + "\u4eba\u8bb0\u5f55");
        }
        list.clear();
        com.qzone.proxy.feedcomponent.b.a("AbstractPhotoListAdapter", "end:" + sb5.toString());
        return sb5.toString();
    }

    public String c(List<Long> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        HashSet hashSet = new HashSet();
        for (Long l3 : list) {
            if (l3.longValue() != 0) {
                hashSet.add(l3);
            }
        }
        list.clear();
        list.addAll(hashSet);
        if (list.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size() - 1; i3++) {
            sb5.append(list.get(i3) + ",");
        }
        sb5.append(list.get(list.size() - 1));
        list.clear();
        com.qzone.proxy.feedcomponent.b.a("AbstractPhotoListAdapter", "end:" + sb5.toString());
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Comparator<Map.Entry<Long, List<PhotoCacheData>>> f() {
        if (this.f42650a0 == null) {
            this.f42650a0 = new e();
        }
        return this.f42650a0;
    }

    public List<PhotoCacheData> g() {
        return this.P;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PhotoCacheData[]> list = this.M;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<PhotoCacheData[]> list = this.M;
        if (list == null || list.size() == 0 || i3 >= this.M.size() || i3 < 0) {
            return null;
        }
        return this.M.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public int h() {
        int i3 = this.f42652e;
        if (i3 > 0) {
            return this.f42655i / i3;
        }
        return 360;
    }

    public boolean i() {
        List<PhotoCacheData> list = this.X;
        return list != null && list.size() > 0;
    }

    public boolean j() {
        return this.C;
    }

    public List<PhotoCacheData> k(boolean z16) {
        List<PhotoCacheData> list;
        if (com.qzone.album.env.common.a.m().B() && z16 && (list = this.P) != null && list.size() > 8) {
            QZLog.d("AbstractPhotoListAdapter", 2, "getNoShootTimePhotoCacheDatas | before| isRepeat:" + z16 + " noShootTimePhotoCacheDatas size:" + this.P.size());
            this.P = e(this.P);
        }
        if (this.P != null) {
            QZLog.d("AbstractPhotoListAdapter", 2, "getNoShootTimePhotoCacheDatas | isRepeat:" + z16 + " noShootTimePhotoCacheDatas size:" + this.P.size());
        }
        return this.P;
    }

    protected Comparator<PhotoCacheData> l() {
        if (this.Z == null) {
            this.Z = new d();
        }
        return this.Z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Comparator<PhotoCacheData> m() {
        if (this.Y == null) {
            this.Y = new c();
        }
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(List<PhotoCacheData> list) {
        this.N = new ArrayList();
        this.P = new ArrayList();
        this.Q = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            PhotoCacheData photoCacheData = list.get(i3);
            if (photoCacheData != null && !photoCacheData.isFakePhoto()) {
                if (photoCacheData.shoottime > 0) {
                    this.Q.add(photoCacheData);
                } else {
                    this.P.add(photoCacheData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(List<PhotoCacheData> list, int i3) {
        return list.get(i3).batch_id != list.get(i3 - 1).batch_id;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(PhotoCacheData photoCacheData) {
        x4.a aVar = this.f42651d;
        if (aVar != null) {
            return ((BasePhotoModelController) aVar).g3(photoCacheData);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s(List<PhotoCacheData[]> list, int i3, int i16) {
        x4.a aVar;
        if (com.qzone.album.env.common.a.m().B() && r(list.get(i3)[i16])) {
            return true;
        }
        return com.qzone.album.env.common.a.m().D() && (aVar = this.f42651d) != null && aVar.o().contains(Integer.valueOf((i3 * this.f42652e) + i16));
    }

    public void setData(List<PhotoCacheData[]> list) {
        this.M = list;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(List<PhotoCacheData> list, int i3) {
        long j3;
        long j16;
        PhotoCacheData photoCacheData = list.get(i3);
        PhotoCacheData photoCacheData2 = list.get(i3 - 1);
        if (QZoneAlbumUtil.B(this.I)) {
            j3 = photoCacheData.shoottime * 1000;
            j16 = photoCacheData2.shoottime;
        } else {
            j3 = photoCacheData.uploadtime * 1000;
            j16 = photoCacheData2.uploadtime;
        }
        return !com.qzone.album.util.g.l(j3, j16 * 1000);
    }

    public void w(List<PhotoCacheData> list) {
        this.X = list;
    }

    public void x(boolean z16) {
        this.G = z16;
    }

    public void y(boolean z16) {
        this.C = z16;
    }

    public void z(boolean z16) {
        this.F = z16;
    }

    public List<PhotoCacheData> H(int i3) {
        return I(null, i3);
    }

    private List<PhotoCacheData> e(List<PhotoCacheData> list) {
        int i3;
        List<PhotoCacheData> subList;
        PhotoCacheData next;
        if (list == null || list.isEmpty()) {
            return list;
        }
        boolean z16 = true;
        if (list.size() - 1 < 0) {
            return list;
        }
        boolean z17 = false;
        try {
            subList = list.subList(0, list.size());
        } catch (Exception e16) {
            QLog.d("AbstractPhotoListAdapter", 1, "index out of bounds " + e16);
        }
        if (subList != null && subList.size() != 0) {
            PhotoCacheData photoCacheData = subList.get(0);
            Iterator<PhotoCacheData> it = subList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (q(next, photoCacheData) && next.hashCode() != photoCacheData.hashCode()) {
                    break;
                }
            }
            z16 = false;
            z17 = z16;
            if (!z17) {
                return list;
            }
            if (list.size() < 8) {
                i3 = list.size() / 2;
            } else {
                i3 = BasePhotoModelController.f42938y2;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.addAll(list.subList(i3, list.size()));
            return copyOnWriteArrayList;
        }
        return list;
    }

    public List<Long> d(List<Long> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        HashSet hashSet = new HashSet();
        for (Long l3 : list) {
            if (l3.longValue() != 0) {
                hashSet.add(l3);
            }
        }
        list.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public String n(PhotoCacheData photoCacheData) {
        if (photoCacheData != null && photoCacheData.uploadtime > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(photoCacheData.uploadtime * 1000);
            String str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoMayShootAt", "\u53ef\u80fd\u62cd\u6444\u4e8e") + calendar.get(1) + com.qzone.util.l.a(R.string.j0m) + (calendar.get(2) + 1) + com.qzone.util.l.a(R.string.j0n) + calendar.get(5) + com.qzone.util.l.a(R.string.j0l);
            if (!this.E) {
                return str;
            }
            return str + "\uff1f";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(PhotoCacheData photoCacheData, PhotoCacheData photoCacheData2) {
        String str;
        String str2;
        if (photoCacheData == null || (str = photoCacheData.lloc) == null || photoCacheData2 == null || (str2 = photoCacheData2.lloc) == null) {
            return false;
        }
        boolean equals = str.equals(str2);
        if (!TextUtils.isEmpty(photoCacheData.lloc) || !TextUtils.isEmpty(photoCacheData.lloc) || TextUtils.isEmpty(photoCacheData.clientKey) || TextUtils.isEmpty(photoCacheData2.clientKey)) {
            return equals;
        }
        return false;
    }

    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        long j3;
        long j16;
        ArrayList arrayList = new ArrayList();
        int i3 = this.f42652e;
        PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[i3];
        PhotoCacheData[] photoCacheDataArr2 = new PhotoCacheData[i3];
        this.N.clear();
        if (list != null && list.size() != 0) {
            int i16 = this.I;
            if (i16 == 0 || i16 == 3) {
                Collections.sort(list, m());
            } else if (i16 == 4) {
                Collections.sort(list, l());
            }
            boolean z16 = false;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                j3 = 0;
                if (i17 >= list.size()) {
                    break;
                }
                PhotoCacheData photoCacheData = list.get(i17);
                if ((i17 <= 0 || !q(photoCacheData, list.get(i17 - 1))) && photoCacheData != null) {
                    photoCacheData.descvisible = z16;
                    if (com.qzone.album.env.common.a.m().B()) {
                        photoCacheData.index = i18;
                        photoCacheData.isChecked = r(photoCacheData);
                        i18++;
                    }
                    if (photoCacheData.shoottime <= 0 && QZoneAlbumUtil.B(this.I)) {
                        if (this.N.size() == 0 && i26 == 0) {
                            photoCacheData.timevisible = true;
                            photoCacheDataArr2[i26] = photoCacheData;
                        } else {
                            if (i26 % this.f42652e == 0) {
                                this.N.add(photoCacheDataArr2);
                                photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                                i26 = 0;
                            }
                            if (QZoneAlbumUtil.A(this.H) && com.qzone.album.util.a.m(list, i17, i27, false)) {
                                photoCacheData.timevisible = true;
                                PhotoCacheData photoCacheData2 = photoCacheDataArr2[0];
                                if (photoCacheData2 != null) {
                                    photoCacheData2.numbersOfColumn = i26;
                                    this.N.add(photoCacheDataArr2);
                                }
                                photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr2[0] = photoCacheData;
                                i26 = 1;
                                i27 = i17;
                            } else {
                                photoCacheDataArr2[i26] = photoCacheData;
                            }
                        }
                        i26++;
                        i27 = i17;
                    } else if (i17 == 0) {
                        photoCacheData.timevisible = true;
                        photoCacheData.descvisible = true;
                        this.L = photoCacheData.desc;
                        photoCacheDataArr[i19] = photoCacheData;
                        i19++;
                    } else {
                        if (i19 % this.f42652e == 0) {
                            arrayList.add(photoCacheDataArr);
                            photoCacheDataArr = new PhotoCacheData[this.f42652e];
                            i19 = 0;
                        }
                        if (t(list, i17)) {
                            photoCacheData.timevisible = true;
                            photoCacheData.descvisible = true;
                            this.L = photoCacheData.desc;
                            if (photoCacheDataArr[0] != null) {
                                arrayList.add(photoCacheDataArr);
                            }
                            photoCacheDataArr = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr[0] = photoCacheData;
                            i19 = 1;
                        } else {
                            if (!photoCacheData.desc.equals(this.L)) {
                                photoCacheData.descvisible = true;
                                this.L = photoCacheData.desc;
                            }
                            photoCacheDataArr[i19] = photoCacheData;
                            i19++;
                        }
                    }
                }
                i17++;
                z16 = false;
            }
            boolean z17 = z16;
            if (photoCacheDataArr[z17 ? 1 : 0] != null) {
                arrayList.add(photoCacheDataArr);
            }
            if (photoCacheDataArr2[z17 ? 1 : 0] != null) {
                this.N.add(photoCacheDataArr2);
            }
            arrayList.addAll(this.N);
            this.R = new HashMap<>();
            new s4.d();
            if (this.C || this.H == 4) {
                for (int i28 = 0; i28 < arrayList.size(); i28++) {
                    if (arrayList.get(i28) != null) {
                        if (((PhotoCacheData[]) arrayList.get(i28))[0] != null && ((PhotoCacheData[]) arrayList.get(i28))[0].timevisible) {
                            if (QZoneAlbumUtil.B(this.I)) {
                                j16 = ((PhotoCacheData[]) arrayList.get(i28))[0].shoottime;
                            } else {
                                j16 = ((PhotoCacheData[]) arrayList.get(i28))[0].uploadtime;
                            }
                            s4.d dVar = new s4.d();
                            if (!this.R.containsKey(Long.valueOf(j16))) {
                                this.R.put(Long.valueOf(j16), dVar);
                                dVar.f433294a = j16;
                            }
                            for (int i29 = 0; i29 < this.f42652e; i29++) {
                                if (((PhotoCacheData[]) arrayList.get(i28))[i29] != null) {
                                    if (com.qzone.album.env.common.a.m().D()) {
                                        x4.a aVar = this.f42651d;
                                        if (aVar != null && aVar.o().contains(Integer.valueOf((this.f42652e * i28) + i29))) {
                                            ((PhotoCacheData[]) arrayList.get(i28))[i29].isChecked = true;
                                        } else {
                                            ((PhotoCacheData[]) arrayList.get(i28))[i29].isChecked = false;
                                        }
                                    }
                                    this.R.get(Long.valueOf(j16)).f433296c.add(((PhotoCacheData[]) arrayList.get(i28))[i29]);
                                    this.R.get(Long.valueOf(j16)).f433295b.add(Integer.valueOf((this.f42652e * i28) + i29));
                                }
                            }
                            j3 = j16;
                        } else {
                            for (int i36 = 0; i36 < this.f42652e; i36++) {
                                if (((PhotoCacheData[]) arrayList.get(i28))[i36] != null) {
                                    if (com.qzone.album.env.common.a.m().D()) {
                                        x4.a aVar2 = this.f42651d;
                                        if (aVar2 != null && aVar2.o().contains(Integer.valueOf((this.f42652e * i28) + i36))) {
                                            ((PhotoCacheData[]) arrayList.get(i28))[i36].isChecked = true;
                                        } else {
                                            ((PhotoCacheData[]) arrayList.get(i28))[i36].isChecked = false;
                                            this.R.get(Long.valueOf(j3)).f433296c.add(((PhotoCacheData[]) arrayList.get(i28))[i36]);
                                            this.R.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i28) + i36));
                                        }
                                    }
                                    this.R.get(Long.valueOf(j3)).f433296c.add(((PhotoCacheData[]) arrayList.get(i28))[i36]);
                                    this.R.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i28) + i36));
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements Comparator<PhotoCacheData> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhotoCacheData photoCacheData, PhotoCacheData photoCacheData2) {
            if (photoCacheData == null || photoCacheData2 == null) {
                return 0;
            }
            long j3 = photoCacheData.uploadtime;
            long j16 = photoCacheData2.uploadtime;
            if (j3 > j16) {
                return -1;
            }
            return j3 == j16 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements Comparator<PhotoCacheData> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhotoCacheData photoCacheData, PhotoCacheData photoCacheData2) {
            if (photoCacheData == null || photoCacheData2 == null) {
                return 0;
            }
            long j3 = photoCacheData.uploadtime;
            long j16 = photoCacheData2.uploadtime;
            if (j3 < j16) {
                return -1;
            }
            return j3 == j16 ? 0 : 1;
        }
    }

    public void u() {
    }

    public void v(s4.d dVar) {
    }
}
