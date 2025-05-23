package com.qzone.reborn.intimate.fragment;

import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.part.message.QZoneIntimateMessageBodyPart;
import com.qzone.reborn.intimate.part.message.e;
import com.qzone.reborn.intimate.part.message.g;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import gf.p;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateMessageFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getChildDaTongPageParams", "", "", "", "getContentLayoutId", "", "getDaTongPageId", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateMessageFragment extends QZoneBaseFragment {
    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> mutableMapOf;
        p pVar = (p) getIocInterface(p.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("red_dot_state", Integer.valueOf((pVar != null ? pVar.k1() : 0) > 0 ? 1 : 0)));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ck9;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_buddy_space_message";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZoneIntimateMessageBodyPart(), new com.qzone.reborn.intimate.part.message.a(), new e(), new g());
        return mutableListOf;
    }
}
