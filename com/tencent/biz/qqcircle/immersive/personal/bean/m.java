package com.tencent.biz.qqcircle.immersive.personal.bean;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends MutableLiveData<QFSPersonalInfo> implements QFSPersonalInfo.a {
    @Override // com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.a
    public void b(QFSPersonalInfo qFSPersonalInfo) {
        if (RFWThreadManager.isMainThread()) {
            setValue(qFSPersonalInfo);
        } else {
            postValue(qFSPersonalInfo);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void setValue(QFSPersonalInfo qFSPersonalInfo) {
        qFSPersonalInfo.e(this);
        super.setValue(qFSPersonalInfo);
    }
}
