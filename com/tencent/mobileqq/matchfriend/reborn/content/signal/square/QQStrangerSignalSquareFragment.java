package com.tencent.mobileqq.matchfriend.reborn.content.signal.square;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.QQStrangerSignalSquareSmartRefreshPart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.QQStrangerSignalSquareStatePart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.i;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/QQStrangerSignalSquareFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "ph", "qh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needStatusTrans", "needImmersive", "onResume", DKHippyEvent.EVENT_STOP, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareFragment extends QPublicBaseFragment {
    private final void ph() {
        VideoReport.setPageId(getView(), "pg_kl_expansion_list");
        VideoReport.setPageReportPolicy(getView(), PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgIn(getView());
    }

    private final void qh() {
        VideoReport.setPageId(getView(), "pg_kl_expansion_list");
        VideoReport.setPageReportPolicy(getView(), PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgOut(getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cya;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ph();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        qh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new i(), new QQStrangerSignalSquareSmartRefreshPart(), new QQStrangerSignalSquareStatePart());
        return mutableListOf;
    }
}
