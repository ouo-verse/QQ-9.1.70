package com.tencent.mobileqq.zplan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/ZplanViewContractFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "", "getContentLayoutId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanViewContractFragment extends QIphoneTitleBarFragment {
    private final void initView() {
        LinearLayout linearLayout = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.q39);
        String data = com.tencent.mobileqq.zplan.setting.c.g("key_view_contract_info", "");
        QLog.d("ZplanViewContractFragment", 2, " data => " + data);
        com.tencent.mobileqq.zplan.servlet.c cVar = com.tencent.mobileqq.zplan.servlet.c.f335402a;
        Intrinsics.checkNotNullExpressionValue(data, "data");
        List<hu4.l> a16 = cVar.a(data);
        u.Companion companion = t74.u.INSTANCE;
        Context context = getContext();
        if (context == null) {
            context = BaseApplication.getContext();
        }
        int c16 = companion.c(context) - com.tencent.sqshow.zootopia.utils.i.b(80);
        for (final hu4.l lVar : a16) {
            QLog.d("ZplanViewContractFragment", 2, "item data => " + lVar.f406385a + MsgSummary.STR_COLON + lVar.f406386b);
            FormSimpleItem formSimpleItem = new FormSimpleItem(getContext());
            formSimpleItem.setBgType(0);
            formSimpleItem.h(true);
            formSimpleItem.setRightTextColor(2);
            formSimpleItem.setLeftText(lVar.f406385a);
            formSimpleItem.c().setMaxWidth(c16);
            formSimpleItem.setContentDescription(lVar.f406385a);
            formSimpleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.af
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanViewContractFragment.qh(hu4.l.this, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.tencent.sqshow.zootopia.utils.i.b(56));
            layoutParams.topMargin = com.tencent.sqshow.zootopia.utils.i.b(10);
            linearLayout.addView(formSimpleItem, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(hu4.l itemData, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        if (itemData.f406386b != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = itemData.f406386b;
            Intrinsics.checkNotNullExpressionValue(str, "itemData.greementSchema");
            iSchemeApi.launchScheme(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.xtk));
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2r;
    }
}
