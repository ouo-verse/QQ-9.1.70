package com.tencent.mobileqq.zplan.friend.changerole.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.zplan.friend.FriendInfo;
import com.tencent.mobileqq.zplan.friend.FriendRepository;
import com.tencent.mobileqq.zplan.friend.Gender;
import com.tencent.mobileqq.zplan.friend.r;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a extends ViewModel {
    private AppInterface C;
    private FriendRepository D;
    private int E;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Map<Integer, FriendInfo>> f333687i = new MutableLiveData<>(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    private String f333688m = "";
    private ArrayList<Integer> F = new ArrayList<>();
    private ArrayList<String> G = new ArrayList<>();
    private final MutableLiveData<Integer> H = new MutableLiveData<>(0);
    private final ArrayList<FriendInfo> I = new ArrayList<>();
    private final HashMap<Integer, FriendInfo> J = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.friend.changerole.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9179a implements Function1<List<FriendInfo>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f333689d;

        C9179a(c cVar) {
            this.f333689d = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List<FriendInfo> list) {
            QLog.d("ZPlaneFriendSelectStateModel", 1, "initData invoke = " + list.toString());
            a.this.I.clear();
            a.this.I.addAll(list);
            if (a.this.I.size() == 0) {
                QLog.e("ZPlaneFriendSelectStateModel", 1, "initData addFriend is empty!!");
                return null;
            }
            a.this.J.clear();
            ((Map) a.this.f333687i.getValue()).clear();
            for (int i3 = 0; i3 < a.this.G.size(); i3++) {
                String str = (String) a.this.G.get(i3);
                int i16 = 0;
                while (true) {
                    if (i16 < a.this.I.size()) {
                        FriendInfo friendInfo = (FriendInfo) a.this.I.get(i16);
                        if (friendInfo.getUin().equals(str)) {
                            ((Map) a.this.f333687i.getValue()).put(Integer.valueOf(i3), friendInfo);
                            a.this.J.put(Integer.valueOf(i3), friendInfo);
                            break;
                        }
                        i16++;
                    }
                }
            }
            this.f333689d.onInitFinish();
            a.this.H.postValue(0);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements Function1<Boolean, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.e("ZPlaneFriendSelectStateModel", 4, "reportSetRole is " + bool);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface c {
        void onInitFinish();
    }

    private void c2(ArrayList<String> arrayList) {
        r.f333732a.c(this.C, this.f333688m, arrayList, new b());
    }

    public AppInterface Q1() {
        return this.C;
    }

    public JSONArray R1(ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (arrayList.isEmpty()) {
                return jSONArray;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uin", next);
                jSONObject.put("suitId", 0);
                jSONArray.mo162put(jSONObject);
            }
            QLog.i("ZPlaneFriendSelectStateModel", 4, "getAvatarUinJsonStr resultJo = " + jSONArray);
            return jSONArray;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> S1() {
        ArrayList<String> arrayList = new ArrayList<>();
        Map<Integer, FriendInfo> value = this.f333687i.getValue();
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            FriendInfo friendInfo = value != null ? value.get(Integer.valueOf(i3)) : null;
            if (friendInfo == null) {
                friendInfo = this.J.get(Integer.valueOf(i3));
            }
            arrayList.add(friendInfo.getUin());
        }
        QLog.i("ZPlaneFriendSelectStateModel", 4, "getAvatarUinList friendUin = " + arrayList);
        return arrayList;
    }

    public MutableLiveData<Integer> T1() {
        return this.H;
    }

    public JSONObject U1() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Map<Integer, FriendInfo> value = this.f333687i.getValue();
            for (int i3 = 0; i3 < this.F.size(); i3++) {
                FriendInfo friendInfo = value != null ? value.get(Integer.valueOf(i3)) : null;
                if (friendInfo == null) {
                    friendInfo = this.J.get(Integer.valueOf(i3));
                }
                arrayList.add(friendInfo.getUin());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uin", friendInfo.getUin());
                jSONObject2.put("nick", friendInfo.getName());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("friends", jSONArray);
            c2(arrayList);
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public ArrayList<Integer> W1() {
        return this.F;
    }

    public List<FriendInfo> X1() {
        Integer value = this.H.getValue();
        Objects.requireNonNull(value);
        int intValue = value.intValue();
        ArrayList arrayList = new ArrayList();
        if (intValue >= this.F.size()) {
            QLog.e("ZPlaneFriendSelectStateModel", 1, "out of gender index, pleas check genderList & currentStep " + intValue + ProgressTracer.SEPARATOR + this.F.toString());
            return arrayList;
        }
        int intValue2 = this.F.get(intValue).intValue();
        if (intValue2 == Gender.ALL.getGender()) {
            QLog.d("ZPlaneFriendSelectStateModel", 1, "not limit gender " + intValue2);
            return this.I;
        }
        Iterator<FriendInfo> it = this.I.iterator();
        while (it.hasNext()) {
            FriendInfo next = it.next();
            if (next.getGender().intValue() == intValue2) {
                arrayList.add(next);
            }
        }
        Map<Integer, FriendInfo> value2 = this.f333687i.getValue();
        Objects.requireNonNull(value2);
        if (intValue >= value2.size()) {
            QLog.e("ZPlaneFriendSelectStateModel", 1, "out of stepSelectedUin index, pleas check stepSelectedUid & currentStep " + intValue + ProgressTracer.SEPARATOR + this.f333687i.toString());
            return arrayList;
        }
        FriendInfo friendInfo = this.f333687i.getValue().get(Integer.valueOf(intValue));
        if (friendInfo != null && !arrayList.contains(friendInfo)) {
            arrayList.add(friendInfo);
        }
        return arrayList;
    }

    public MutableLiveData<Map<Integer, FriendInfo>> Z1() {
        return this.f333687i;
    }

    public int a2() {
        return this.E;
    }

    public void d2(AppInterface appInterface) {
        this.C = appInterface;
        this.D = new FriendRepository(appInterface);
    }

    public void e2(int i3) {
        this.H.postValue(Integer.valueOf(i3));
    }

    public void f2(ArrayList<Integer> arrayList) {
        this.F = arrayList;
        this.E = arrayList.size();
    }

    public void g2(ArrayList<String> arrayList) {
        this.G = arrayList;
    }

    public void h2(int i3, FriendInfo friendInfo) {
        Map<Integer, FriendInfo> value = this.f333687i.getValue();
        value.put(Integer.valueOf(i3), friendInfo);
        this.f333687i.postValue(value);
    }

    public void i2(String str) {
        this.f333688m = str;
    }

    public void b2(c cVar) {
        QLog.d("ZPlaneFriendSelectStateModel", 1, "initData start");
        this.D.d(new C9179a(cVar));
    }
}
