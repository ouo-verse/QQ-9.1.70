package com.tencent.mobileqq.troopmanage.activity;

import android.content.Context;
import android.content.ContextParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.widget.qqui.InputMethodLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troopmanage.base.TroopManageBaseFragment;
import com.tencent.mobileqq.troopmanage.component.bb;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SpeechLimitSettingActivity extends TroopManageBaseFragment implements InputMethodLinearLayout.a {
    static IPatchRedirector $redirector_;
    private final List<Integer> E;
    private final Map<Integer, bb> F;
    private int G;
    private String H;
    private QQCustomDialog I;
    private String J;
    private QUIListItemAdapter K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f302900a;

        a(Integer num) {
            this.f302900a = num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeechLimitSettingActivity.this, (Object) num);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SpeechLimitSettingActivity.this.Ch(this.f302900a, z16);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            }
        }
    }

    public SpeechLimitSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = new ArrayList();
        this.F = new HashMap();
        this.G = 0;
    }

    private String Bh(int i3) {
        if (i3 != 5) {
            if (i3 != 10) {
                return getString(R.string.evh);
            }
            return getString(R.string.evi);
        }
        return getString(R.string.evj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(Integer num, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("TagSpeechLimitActivity", 2, "[handleModifyTroopMsgLimitFreq] suc:" + z16 + ",msgLimitFreq:" + num);
        }
        if (z16) {
            Mh(num.intValue());
        } else {
            Lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh(bb bbVar, Integer num, View view) {
        if (bbVar.V() != null) {
            if (num.intValue() == this.G) {
                bbVar.V().setVisibility(0);
            } else {
                bbVar.V().setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(Integer num, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!ph()) {
            QLog.d("TagSpeechLimitActivity", 1, "setOption network error");
            qh(getString(R.string.b3j));
        } else if (this.H != null) {
            Ih(num);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(Boolean bool, TroopInfo troopInfo) {
        Jh(bool.booleanValue(), troopInfo.troopuin, troopInfo.nMsgLimitFreq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Gh(final Boolean bool, final TroopInfo troopInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.s
            @Override // java.lang.Runnable
            public final void run() {
                SpeechLimitSettingActivity.this.Fh(bool, troopInfo);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(DialogInterface dialogInterface, int i3) {
        zh();
    }

    private void Ih(Integer num) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopMsgLimitFreq(this.H, num.intValue(), this, new a(num));
    }

    private void Jh(boolean z16, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("TagSpeechLimitActivity", 2, "onGetTroopMsgLimitFreq suc = " + z16 + "| msgLimitFreq = " + i3);
        }
        if (!TextUtils.isEmpty(this.H) && !TextUtils.isEmpty(str) && z16 && str.equals(this.H)) {
            Mh(i3);
        }
    }

    private void Lh() {
        zh();
        QQCustomDialog title = DialogUtil.createCustomDialog(getContext(), 230).setTitle(getString(R.string.evk));
        this.I = title;
        title.setPositiveButton(getString(R.string.esa), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SpeechLimitSettingActivity.this.Hh(dialogInterface, i3);
            }
        });
        try {
            this.I.show();
        } catch (Exception e16) {
            QLog.e("TagSpeechLimitActivity", 1, "dialog show e: " + e16);
        }
    }

    private void Mh(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("TagSpeechLimitActivity", 2, "updateView key = " + i3);
        }
        if (this.F.isEmpty()) {
            QLog.e("TagSpeechLimitActivity", 2, "updateView mOptionConfigList is empty");
            return;
        }
        bb bbVar = this.F.get(Integer.valueOf(this.G));
        if (bbVar != null && bbVar.V() != null) {
            bbVar.V().setVisibility(8);
            this.K.l0(bbVar);
        }
        bb bbVar2 = this.F.get(Integer.valueOf(i3));
        if (bbVar2 != null && bbVar2.V() != null) {
            bbVar2.V().setVisibility(0);
            this.K.l0(bbVar2);
        }
        this.G = i3;
    }

    private void initData() {
        this.E.add(0);
        this.E.add(10);
        this.E.add(5);
    }

    private void yh(QUIListItemAdapter qUIListItemAdapter) {
        com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[this.E.size()];
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            final Integer num = this.E.get(i3);
            final bb bbVar = new bb(new x.b.d(Bh(num.intValue())), new x.c.g("", false, false));
            bbVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.activity.t
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    SpeechLimitSettingActivity.this.Dh(bbVar, num, view);
                }
            });
            bbVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeechLimitSettingActivity.this.Eh(num, view);
                }
            });
            this.F.put(num, bbVar);
            aVarArr[i3] = bbVar;
        }
        qUIListItemAdapter.t0(Group.INSTANCE.b(aVarArr));
    }

    private void zh() {
        QQCustomDialog qQCustomDialog = this.I;
        if (qQCustomDialog != null) {
            if (qQCustomDialog.isShowing()) {
                try {
                    this.I.dismiss();
                } catch (Exception e16) {
                    QLog.e("TagSpeechLimitActivity", 1, "dialog dismiss e: " + e16);
                }
            }
            this.I = null;
        }
    }

    public ContextParams Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ContextParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.H = arguments.getString("troop_uin");
        this.G = arguments.getInt(AppConstants.Key.LIMIT_FREQ, -1);
        this.J = arguments.getString("role");
        return null;
    }

    public void Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        zh();
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.LIMIT_FREQ, this.G);
        intent.putExtra("troop_uin", this.H);
        getQBaseActivity().setResult(-1, intent);
        getQBaseActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Ah();
        initData();
        initUI();
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopSpeechLimitFreq(this.H, "TagSpeechLimitActivity", this, new Function2() { // from class: com.tencent.mobileqq.troopmanage.activity.r
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit Gh;
                Gh = SpeechLimitSettingActivity.this.Gh((Boolean) obj, (TroopInfo) obj2);
                return Gh;
            }
        });
    }

    public int dp2px(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, context, Float.valueOf(f16))).intValue();
        }
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.layout.hzo;
    }

    public void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        setTitle(HardCodeUtil.qqStr(R.string.tna));
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).setOrientation(1);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).setOnSizeChangedListenner(this);
        BounceScrollView bounceScrollView = new BounceScrollView(getContext());
        bounceScrollView.setFocusable(false);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).addView(bounceScrollView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackground(null);
        bounceScrollView.addView(linearLayout);
        linearLayout.addView(View.inflate(getContext(), R.layout.b4b, null));
        QUISettingsRecyclerView qUISettingsRecyclerView = new QUISettingsRecyclerView(requireContext());
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, true);
        this.K = qUIListItemAdapter;
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        linearLayout.addView(qUISettingsRecyclerView);
        yh(this.K);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView textView = new TextView(getContext());
        textView.setText(HardCodeUtil.qqStr(R.string.tn_));
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        textView.setBackground(null);
        textView.setPadding(dp2px(getContext(), 32.0f), dp2px(getContext(), 8.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Kh();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.qqui.InputMethodLinearLayout.a
    public void onSizeChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }
}
