package com.qzone.reborn.message.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.message.part.QZonePassiveMessageTabPart;
import com.qzone.reborn.message.part.w;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.QZoneHelper;
import dl.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/message/fragment/QZonePassiveMessageTabFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "onBackEvent", "getLogTag", BdhLogUtil.LogTag.Tag_Conn, "Z", "fromNotification", "Ldl/f;", "D", "Ldl/f;", "pageReportIoc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageTabFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean fromNotification;

    /* renamed from: D, reason: from kotlin metadata */
    private f pageReportIoc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        Map<String, Object> O1;
        f fVar = this.pageReportIoc;
        return (fVar == null || (O1 = fVar.O1()) == null) ? new LinkedHashMap() : O1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1276519;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_related_to_me_feed";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePassiveMessageTabFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        RFWLog.d(getTAG(), RFWLog.USR, "onBackEvent, fromNotification: " + this.fromNotification);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (this.fromNotification) {
            QZoneHelper.forwardToQZoneFriendFeedActivity(getActivity(), new Intent(getActivity(), (Class<?>) QZoneFriendFeedXActivity.class), false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            this.fromNotification = intent.getBooleanExtra("FromNotification", false);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QZonePassiveMessageTabPart qZonePassiveMessageTabPart = new QZonePassiveMessageTabPart();
        this.pageReportIoc = qZonePassiveMessageTabPart;
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(qZonePassiveMessageTabPart, new w(), new cc("page_launch_passive_message"));
        return mutableListOf;
    }
}
