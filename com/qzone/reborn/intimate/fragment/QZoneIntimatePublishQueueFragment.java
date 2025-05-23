package com.qzone.reborn.intimate.fragment;

import android.os.Bundle;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.part.bq;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZoneIntimatePublishQueueFragment extends QZoneBaseFragment {
    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new bq());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cke;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
