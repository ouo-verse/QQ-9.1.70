package com.tencent.mobileqq.wink.publish.viewmodel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class u extends BaseViewModel {

    /* renamed from: m, reason: collision with root package name */
    public static final String f326071m = "com.tencent.mobileqq.wink.publish.viewmodel.u";

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<k93.b> f326072i = new MutableLiveData<>();

    public MutableLiveData<k93.b> L1() {
        return this.f326072i;
    }

    public void M1(Intent intent) {
        k93.b bVar = new k93.b();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("key_attrs")) {
            return;
        }
        HashMap hashMap = (HashMap) intent.getExtras().get("key_attrs");
        if (hashMap.containsKey(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_ID)) {
            bVar.f411915b = Long.valueOf(Long.parseLong((String) hashMap.get(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_ID)));
        }
        if (hashMap.containsKey(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_TITLE)) {
            bVar.f411914a = (String) hashMap.get(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_TITLE);
        }
        this.f326072i.setValue(bVar);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return f326071m;
    }
}
