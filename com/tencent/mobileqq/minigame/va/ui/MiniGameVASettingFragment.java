package com.tencent.mobileqq.minigame.va.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.IMiniShareApi;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/MiniGameVASettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()V", "itemRecyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "miniArkShareModel", "Lcom/tencent/mobileqq/mini/share/MiniArkShareModel;", "createItems", "Lcom/tencent/mobileqq/widget/listitem/Group;", "doOnCreateView", "", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "getContentLayoutId", "", "openAuthSettingPage", "url", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVASettingFragment extends QIphoneTitleBarFragment {
    private static final String TAG = "MiniGameVASettingFragment";
    private QUISettingsRecyclerView itemRecyclerView;
    private MiniArkShareModel miniArkShareModel;

    private final Group createItems() {
        x xVar = new x(new x.b.d("\u6388\u6743QQ\u4f7f\u7528\u4fe1\u606f"), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameVASettingFragment.createItems$lambda$0(MiniGameVASettingFragment.this, view);
            }
        });
        x xVar2 = new x(new x.b.d("\u4e0b\u8f7d\u7ba1\u7406"), new x.c.g("", true, false));
        xVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameVASettingFragment.createItems$lambda$3(MiniGameVASettingFragment.this, view);
            }
        });
        return new Group(xVar, xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createItems$lambda$0(MiniGameVASettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniArkShareModel miniArkShareModel = this$0.miniArkShareModel;
        this$0.openAuthSettingPage(miniArkShareModel != null ? miniArkShareModel.getWebURL() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createItems$lambda$3(MiniGameVASettingFragment this$0, View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            QPublicFragmentActivity.start(activity, activity.getIntent(), MiniGameVADownloadSettingFragment.class);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "open download setting failed, activity is null!");
        }
    }

    private final void openAuthSettingPage(String url) {
        if (!TextUtils.isEmpty(url)) {
            ((IMiniShareApi) QRoute.api(IMiniShareApi.class)).jumpUrl(getActivity(), url);
            return;
        }
        QLog.e(TAG, 1, "open auth setting failed, url:" + url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent;
        setTitle("\u8bbe\u7f6e");
        FragmentActivity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra(MiniChatConstants.MINI_APP_ARK_MODEL);
        this.miniArkShareModel = serializableExtra instanceof MiniArkShareModel ? (MiniArkShareModel) serializableExtra : null;
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.rii);
        this.itemRecyclerView = findViewById instanceof QUISettingsRecyclerView ? (QUISettingsRecyclerView) findViewById : null;
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);
        qUIListItemAdapter.t0(createItems());
        QUISettingsRecyclerView qUISettingsRecyclerView = this.itemRecyclerView;
        if (qUISettingsRecyclerView != null) {
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        }
        QUISettingsRecyclerView qUISettingsRecyclerView2 = this.itemRecyclerView;
        if (qUISettingsRecyclerView2 != null) {
            qUISettingsRecyclerView2.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Middle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dkl;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
