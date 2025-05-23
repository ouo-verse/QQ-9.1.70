package gm;

import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.util.ag;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends ql.a {
    public static final String I = "c";
    private HashMap<String, LocalMediaInfo> C;
    private HashMap<String, ShuoshuoVideoInfo> D;
    private HashMap<String, ShuoshuoVideoInfo> E;
    private List<String> F;
    private boolean G;
    private final MutableLiveData<Boolean> H;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<DynamicArrayList<String>> f402392m;

    public c() {
        MutableLiveData<DynamicArrayList<String>> mutableLiveData = new MutableLiveData<>(null);
        this.f402392m = mutableLiveData;
        this.H = new MutableLiveData<>();
        mutableLiveData.observeForever(new Observer() { // from class: gm.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.a2((DynamicArrayList) obj);
            }
        });
    }

    private boolean U1(List<String> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!TextUtils.equals(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(ArrayList arrayList) {
        f2(arrayList);
        List<String> list = this.F;
        if (list == null || list.isEmpty()) {
            if (arrayList == null) {
                this.F = new ArrayList();
                this.G = false;
                return;
            } else {
                this.F = new ArrayList(arrayList);
                this.G = true;
                return;
            }
        }
        if (arrayList != null) {
            if (U1(arrayList, this.F)) {
                this.G = false;
                return;
            } else {
                this.F.clear();
                this.F.addAll(arrayList);
            }
        } else {
            this.F.clear();
        }
        this.G = true;
        QLog.i(I, 1, "isSelectedMediaChanged");
    }

    @Override // ql.a
    public boolean M1() {
        DynamicArrayList<String> value = this.f402392m.getValue();
        return (value == null || value.isEmpty()) ? false : true;
    }

    public Pair<Integer, Integer> Q1() {
        HashMap<String, ShuoshuoVideoInfo> hashMap;
        DynamicArrayList<String> value = this.f402392m.getValue();
        if (this.C != null && value != null) {
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < value.size(); i17++) {
                String str = value.get(i17);
                LocalMediaInfo localMediaInfo = this.C.get(str);
                if (localMediaInfo != null) {
                    if (QAlbumUtil.getMediaType(localMediaInfo) == 1 || ((hashMap = this.D) != null && hashMap.containsKey(str))) {
                        i16++;
                    } else {
                        i3++;
                    }
                }
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return new Pair<>(0, 0);
    }

    public List<String> R1() {
        ArrayList<String> arrayList;
        ArrayList arrayList2 = new ArrayList();
        DynamicArrayList<String> value = this.f402392m.getValue();
        HashMap<String, LocalMediaInfo> hashMap = this.C;
        if (value != null && hashMap != null) {
            for (int i3 = 0; i3 < value.size(); i3++) {
                String str = value.get(i3);
                if (str != null) {
                    LocalMediaInfo localMediaInfo = hashMap.get(str);
                    if (localMediaInfo != null && (arrayList = localMediaInfo.mOriginPath) != null) {
                        arrayList2.addAll(arrayList);
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        return arrayList2;
    }

    public MutableLiveData<DynamicArrayList<String>> S1() {
        return this.f402392m;
    }

    public HashMap<String, LocalMediaInfo> T1() {
        return this.C;
    }

    public boolean W1() {
        DynamicArrayList<String> value = this.f402392m.getValue();
        if (this.C != null && value != null) {
            for (int i3 = 0; i3 < value.size(); i3++) {
                LocalMediaInfo localMediaInfo = this.C.get(value.get(i3));
                if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                    QZLog.d(I, 2, "has normal video");
                    return true;
                }
                HashMap<String, ShuoshuoVideoInfo> hashMap = this.D;
                if (hashMap != null && hashMap.containsKey(value.get(i3))) {
                    QZLog.d(I, 2, "has record video");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean X1() {
        return this.G;
    }

    public void c2(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.D = hashMap;
    }

    public void d2(HashMap<String, LocalMediaInfo> hashMap) {
        this.C = hashMap;
    }

    public void e2(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.E = hashMap;
    }

    public void g2(boolean z16) {
        HashMap<String, ShuoshuoVideoInfo> hashMap;
        DynamicArrayList<String> value = this.f402392m.getValue();
        if (value == null) {
            return;
        }
        for (int i3 = 0; i3 < value.size(); i3++) {
            HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.E;
            ShuoshuoVideoInfo shuoshuoVideoInfo = hashMap2 != null ? hashMap2.get(value.get(i3)) : null;
            if (shuoshuoVideoInfo == null && (hashMap = this.D) != null) {
                shuoshuoVideoInfo = hashMap.get(value.get(i3));
            }
            if (shuoshuoVideoInfo != null) {
                ag.C(shuoshuoVideoInfo, z16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return I;
    }

    public void b2() {
        this.G = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (W1() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f2(ArrayList<String> arrayList) {
        boolean z16;
        if (arrayList != null) {
            z16 = true;
            if (arrayList.size() == 1) {
            }
        }
        z16 = false;
        this.H.postValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(DynamicArrayList dynamicArrayList) {
        if (dynamicArrayList == null) {
            return;
        }
        dynamicArrayList.getLiveData().observeForever(new Observer() { // from class: gm.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.Z1((ArrayList) obj);
            }
        });
    }
}
