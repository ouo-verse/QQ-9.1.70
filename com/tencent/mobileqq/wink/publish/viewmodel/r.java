package com.tencent.mobileqq.wink.publish.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class r extends BaseViewModel {
    private static final String C = UploadConstants.TAG + "FSShareViewModel";
    public static final String D = "sync_qzone_last_value" + WinkCommonUtil.getCurrentAccountLong();
    public static final String E = "sync_qzone_last_value_from_qzone" + WinkCommonUtil.getCurrentAccountLong();

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<Boolean> f326065i = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: m, reason: collision with root package name */
    public boolean f326066m = false;

    public void L1(BasePartFragment basePartFragment) {
        O1(basePartFragment, !this.f326066m);
    }

    public void M1(BasePartFragment basePartFragment) {
        MMKVOptionEntity from = QMMKV.from(basePartFragment.getContext(), "QCIRCLE_MMKV_COMMON");
        if (String.valueOf(10).equals(WinkContext.INSTANCE.d().p("up_source"))) {
            this.f326066m = from.decodeBool(E, false);
        } else {
            this.f326066m = from.decodeBool(D, false);
        }
        this.f326065i.postValue(Boolean.valueOf(this.f326066m));
        QLog.d(C, 1, "initSyncQzoneValue: " + this.f326066m);
    }

    public void N1(BasePartFragment basePartFragment, boolean z16) {
        MMKVOptionEntity from = QMMKV.from(basePartFragment.getContext(), "QCIRCLE_MMKV_COMMON");
        if (String.valueOf(10).equals(WinkContext.INSTANCE.d().p("up_source"))) {
            from.encodeBool(E, z16);
        } else {
            from.encodeBool(D, z16);
        }
    }

    public void O1(BasePartFragment basePartFragment, boolean z16) {
        if (this.f326066m == z16) {
            return;
        }
        this.f326066m = z16;
        this.f326065i.postValue(Boolean.valueOf(z16));
        N1(basePartFragment, z16);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return C;
    }
}
