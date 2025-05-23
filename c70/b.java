package c70;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.requests.QFSSavePersonalizedTagRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import qqcircle.QQCircleProfile$ContentFirstClass;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSLayerBaseViewModel {
    private final MutableLiveData<Set<String>> E = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<Boolean>> F = new MutableLiveData<>();

    private List<QQCircleProfile$ContentFirstClass> U1() {
        Set<String> Z1 = Z1();
        if (Z1.size() == 0) {
            QLog.e("QFSHobbyLabelViewModel", 1, "hobbyLabelSet size is 0");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Z1) {
            QQCircleProfile$ContentFirstClass qQCircleProfile$ContentFirstClass = new QQCircleProfile$ContentFirstClass();
            qQCircleProfile$ContentFirstClass.setHasFlag(true);
            qQCircleProfile$ContentFirstClass.name.set(str);
            arrayList.add(qQCircleProfile$ContentFirstClass);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(QFSSavePersonalizedTagRequest qFSSavePersonalizedTagRequest, UIStateData uIStateData, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        boolean z17;
        int i3;
        if (z16 && j3 == 0 && obj != null && baseRequest.getCurrentSeq() == qFSSavePersonalizedTagRequest.getCurrentSeq()) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSHobbyLabelViewModel", 1, "[onReceive] -> request = " + qFSSavePersonalizedTagRequest + " , traceId : " + qFSSavePersonalizedTagRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , isRealSuccess : " + z17);
        if (z17) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        uIStateData.setState(i3);
        uIStateData.setData(false, Boolean.TRUE);
        this.F.setValue(uIStateData);
    }

    public MutableLiveData<UIStateData<Boolean>> W1() {
        return this.F;
    }

    public MutableLiveData<Set<String>> X1() {
        return this.E;
    }

    public Set<String> Z1() {
        if (this.E.getValue() == null) {
            this.E.setValue(new HashSet());
        }
        return this.E.getValue();
    }

    public void b2() {
        List<QQCircleProfile$ContentFirstClass> U1 = U1();
        if (U1 == null) {
            QLog.d("QFSHobbyLabelViewModel", 1, "[saveHobbyLabelSelect] saveLabels is null. ");
            return;
        }
        final QFSSavePersonalizedTagRequest qFSSavePersonalizedTagRequest = new QFSSavePersonalizedTagRequest(U1);
        final UIStateData<Boolean> obtainLoading = UIStateData.obtainLoading();
        obtainLoading.setData(false, Boolean.FALSE);
        this.F.setValue(obtainLoading);
        sendRequest(qFSSavePersonalizedTagRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: c70.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.this.a2(qFSSavePersonalizedTagRequest, obtainLoading, baseRequest, z16, j3, str, obj);
            }
        });
    }
}
