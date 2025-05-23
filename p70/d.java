package p70;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchFilterActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchFilterDataEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$FilterGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.viewmodels.a implements SimpleEventReceiver {
    private int E;
    private List<Integer> F;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<FeedCloudRead$FilterGroup>> f425452m = new MutableLiveData<>();
    private final MutableLiveData<List<Integer>> C = new MutableLiveData<>();
    private final MutableLiveData<Integer> D = new MutableLiveData<>(0);

    public d() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void N1(int i3) {
        QLog.d("QFSSearchFilterViewModel", 1, "#resetFilterResult size: " + i3);
        ArrayList arrayList = new ArrayList(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(0);
        }
        this.C.setValue(arrayList);
    }

    private List<String> O1(@NonNull List<FeedCloudRead$FilterGroup> list, @NonNull List<Integer> list2) {
        int i3;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int size2 = list2.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (size2 > i16) {
                i3 = list2.get(i16).intValue();
            } else {
                i3 = 0;
            }
            List<String> list3 = list.get(i16).choices.get();
            if (list3 != null && list3.size() > i3) {
                QLog.d("QFSSearchFilterViewModel", 1, "#generateFilterList groupPos: " + i16 + " choicePos: " + i3 + " filter: " + list3.get(i3));
                arrayList.add(list3.get(i3));
            }
        }
        return arrayList;
    }

    private String P1(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            int size = list.size();
            int i3 = 0;
            while (true) {
                int i16 = size - 1;
                if (i3 < i16) {
                    sb5.append(list.get(i3));
                    sb5.append(",");
                    i3++;
                } else {
                    sb5.append(list.get(i16));
                    return sb5.toString();
                }
            }
        } else {
            return "";
        }
    }

    private void W1(final QFSSearchFilterDataEvent qFSSearchFilterDataEvent) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: p70.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.Z1(qFSSearchFilterDataEvent);
            }
        });
    }

    private boolean X1(@NonNull List<Integer> list) {
        if (this.F != null) {
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(QFSSearchFilterDataEvent qFSSearchFilterDataEvent) {
        int size;
        if (this.E != qFSSearchFilterDataEvent.getContextHashCode()) {
            return;
        }
        List<FeedCloudRead$FilterGroup> filterGroups = qFSSearchFilterDataEvent.getFilterGroups();
        this.f425452m.setValue(filterGroups);
        if (filterGroups == null) {
            size = 0;
        } else {
            size = filterGroups.size();
        }
        N1(size);
        this.F = null;
    }

    public void M1() {
        QLog.d("QFSSearchFilterViewModel", 1, "#clearFilterData");
        this.f425452m.setValue(null);
        this.C.setValue(null);
        this.F = null;
    }

    public MutableLiveData<List<FeedCloudRead$FilterGroup>> Q1() {
        return this.f425452m;
    }

    public String R1() {
        QLog.d("QFSSearchFilterViewModel", 1, "#getFilterOptionName");
        List<FeedCloudRead$FilterGroup> value = this.f425452m.getValue();
        List<Integer> value2 = this.C.getValue();
        if (value != null && value2 != null) {
            return P1(O1(value, value2));
        }
        return "";
    }

    public MutableLiveData<List<Integer>> S1() {
        return this.C;
    }

    public int T1() {
        Integer value = this.D.getValue();
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public MutableLiveData<Integer> U1() {
        return this.D;
    }

    public void a2() {
        QLog.d("QFSSearchFilterViewModel", 1, "#requestFilterData");
        List<FeedCloudRead$FilterGroup> value = this.f425452m.getValue();
        List<Integer> value2 = this.C.getValue();
        if (value != null && value2 != null && !value2.equals(this.F) && !X1(value2)) {
            this.F = new ArrayList(value2);
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchFilterActionEvent(O1(value, value2), this.E));
        }
    }

    public void b2() {
        int size;
        if (this.F != null) {
            this.C.setValue(new ArrayList(this.F));
            return;
        }
        if (this.f425452m.getValue() == null) {
            size = 0;
        } else {
            size = this.f425452m.getValue().size();
        }
        N1(size);
    }

    public void c2(Context context) {
        int hashCode;
        if (context == null) {
            hashCode = 0;
        } else {
            hashCode = context.hashCode();
        }
        this.E = hashCode;
    }

    public void d2(int i3) {
        this.D.setValue(Integer.valueOf(i3));
    }

    public void e2(int i3, int i16) {
        List<Integer> value = this.C.getValue();
        if (value != null && value.size() > i3) {
            QLog.d("QFSSearchFilterViewModel", 1, "#updateSelectedPos groupPos: " + i3 + " selectedPos: " + i16);
            value.set(i3, Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchFilterDataEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchFilterViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchFilterDataEvent) {
            W1((QFSSearchFilterDataEvent) simpleBaseEvent);
        }
    }
}
