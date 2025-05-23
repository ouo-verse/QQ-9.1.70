package com.qzone.reborn.part.publish.intimate;

import android.text.TextUtils;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.reborn.part.publish.common.inputarea.QZoneScrollViewPart;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart;
import com.qzone.util.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ul.c;
import vl.e;
import wl.a;
import yl.b;

/* loaded from: classes37.dex */
public class QZonePublishIntimateMoodFragment extends QZoneBaseFragment {
    private String C;
    private int D;

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        String spaceId;
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = (QZoneIntimateWriteMoodInitBean) getHostActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (qZoneIntimateWriteMoodInitBean == null) {
            spaceId = "";
        } else {
            spaceId = qZoneIntimateWriteMoodInitBean.getSpaceId();
        }
        this.C = spaceId;
        this.D = qZoneIntimateWriteMoodInitBean == null ? -1 : qZoneIntimateWriteMoodInitBean.getSpaceType();
        RFWLog.d("QZonePublishIntimateMoodFragment", RFWLog.USR, "spaceInfo mSpaceId:" + this.C + ",mSpaceType:" + this.D);
        ph();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(new b()));
        c cVar = new c();
        cVar.F9("em_qz_sync_to_your_friend_feed");
        arrayList.add(cVar);
        sl.a aVar = new sl.a();
        aVar.C9("em_qz_add_location");
        arrayList.add(aVar);
        e eVar = new e();
        eVar.O9(l.a(R.string.f22004682));
        eVar.I9("em_qz_talk_publish_button");
        arrayList.add(eVar);
        arrayList.add(new com.qzone.reborn.part.publish.common.inputarea.c(new xl.b(this.D)));
        arrayList.add(new QZoneInputKeyboardMenuPart(new xl.a()));
        arrayList.add(new QZoneScrollViewPart());
        arrayList.add(new com.qzone.reborn.part.publish.intimate.director.e());
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.C)) {
            hashMap.put("close_friend_space_id", this.C);
        }
        int i3 = this.D;
        if (i3 >= 0) {
            hashMap.put("close_friend_space_type", Integer.valueOf(i3));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hlc;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_chum_space_talk_release";
    }

    private void ph() {
    }
}
