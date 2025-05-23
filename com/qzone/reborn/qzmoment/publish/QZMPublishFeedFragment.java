package com.qzone.reborn.qzmoment.publish;

import android.os.Bundle;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.publish.part.QZMPublishInputPart;
import com.qzone.reborn.qzmoment.publish.part.b;
import com.qzone.reborn.qzmoment.publish.part.c;
import com.qzone.reborn.qzmoment.publish.part.d;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZMPublishFeedFragment extends QZMBaseFragment {
    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c());
        arrayList.add(new d());
        arrayList.add(new b());
        arrayList.add(new QZMPublishInputPart());
        arrayList.add(new cc("qzm_page_launch_publish"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128403_;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected String getDaTongPageId() {
        return "pg_bas_publishing";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
