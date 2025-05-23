package com.tencent.qq.minibox.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IGamePermissionManagerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes22.dex */
public class PermissionSettingFragment extends QIphoneTitleBarFragment {
    private String C;
    private String D;
    private TextView E;
    private TextView F;
    private LinearLayout G;
    private BounceScrollView H;
    private IGamePermissionManagerService I;
    private List<os3.a> J;

    private void initData() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.ui.PermissionSettingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionSettingFragment permissionSettingFragment = PermissionSettingFragment.this;
                permissionSettingFragment.J = permissionSettingFragment.I.getGamePermissionItems(PermissionSettingFragment.this.C);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.PermissionSettingFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionSettingFragment.this.vh();
                    }
                });
            }
        }, 32, null, true);
    }

    private void uh(String str, boolean z16, int i3, final String str2) {
        FormSwitchItem formSwitchItem = new FormSwitchItem(getActivity());
        this.G.addView(formSwitchItem);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) formSwitchItem.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        formSwitchItem.setFocusable(true);
        formSwitchItem.setBgType(i3);
        formSwitchItem.setText(str);
        formSwitchItem.setChecked(z16);
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qq.minibox.ui.aa
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                PermissionSettingFragment.this.xh(str2, compoundButton, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        boolean z16;
        try {
            List<os3.a> list = this.J;
            if (list != null && list.size() != 0) {
                int size = this.J.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int wh5 = wh(i3, size);
                    os3.a aVar = this.J.get(i3);
                    if (aVar.f423977d == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    uh(aVar.f423975b, z16, wh5, aVar.f423976c);
                }
                return;
            }
            yh();
        } catch (Throwable th5) {
            QLog.e("PermissionSettingFragment", 1, th5, new Object[0]);
        }
    }

    private int wh(int i3, int i16) {
        if (1 == i16) {
            return 0;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 == i16 - 1) {
            return 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(String str, CompoundButton compoundButton, boolean z16) {
        int i3;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        IGamePermissionManagerService iGamePermissionManagerService = this.I;
        if (iGamePermissionManagerService != null) {
            iGamePermissionManagerService.updateGamePermission(this.C, str, i3);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void yh() {
        this.F.setText(String.format(getString(R.string.f166562ak), this.D));
        this.F.setVisibility(0);
        this.E.setVisibility(8);
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.E = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f109916h4);
        this.G = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ypp);
        this.F = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f109636gc);
        this.H = (BounceScrollView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b9w);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.C = intent.getStringExtra(IGamePermissionManagerService.INTENT_KEY_GAME_ID);
            this.D = intent.getStringExtra(IGamePermissionManagerService.INTENT_KEY_GAME_NAME);
        }
        this.E.setText(String.format(getString(R.string.f166492ad), this.D));
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (appInterface == null) {
            QLog.w("PermissionSettingFragment", 1, "[doOnCreateView], app is NULL.");
        } else {
            this.I = (IGamePermissionManagerService) appInterface.getRuntimeService(IGamePermissionManagerService.class, "all");
            initData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fhy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public View onCreateCenterView() {
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getActivity().getString(R.string.f166582am));
        return onCreateCenterView;
    }
}
