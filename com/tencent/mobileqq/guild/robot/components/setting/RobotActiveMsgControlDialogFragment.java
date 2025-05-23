package com.tencent.mobileqq.guild.robot.components.setting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cf1.b;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.bottomsheet.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoActivity;
import com.tencent.mobileqq.guild.robot.components.setting.RobotActiveMsgControlDialogFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef1.c;
import kotlin.jvm.functions.Function0;
import ox1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotActiveMsgControlDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private LinearLayout D;
    private View E;
    private GuildSwitchButton F;
    private i G;
    private final String H;
    private final String I;
    private final String J;
    private final String K;

    public RobotActiveMsgControlDialogFragment(String str, String str2, String str3, String str4) {
        this.H = str;
        this.I = str2;
        this.J = str3;
        this.K = str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(Long l3) {
        String format = String.format(getString(R.string.f153731cw), l3);
        TextView textView = (TextView) this.E.findViewById(R.id.f74663wv);
        textView.setVisibility(0);
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(b bVar) {
        SecurityTipHelperKt.D(getContext(), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(ActionSheet actionSheet, View view, int i3) {
        if (o.c("RobotMoreSettingDialog")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), R.string.f146090t9, 1).show();
            return;
        }
        this.G.U1().setValue(Boolean.TRUE);
        this.G.d2();
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Dh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        o.c("RobotMoreSettingDialog");
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Eh() {
        if (this.G.U1().getValue().booleanValue()) {
            this.G.U1().setValue(Boolean.FALSE);
            this.G.d2();
        } else {
            Hh();
        }
    }

    public static void Fh(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4) {
        new RobotActiveMsgControlDialogFragment(str, str2, str3, str4).show(fragmentActivity.getSupportFragmentManager(), "RobotMoreSettingDialog");
    }

    public static void Gh(FragmentActivity fragmentActivity, i iVar, String str, String str2, String str3) {
        new RobotActiveMsgControlDialogFragment(iVar, str, str2, str3).show(fragmentActivity.getSupportFragmentManager(), "RobotMoreSettingDialog");
    }

    private void Ih() {
        DirectMsgLimitDialogFragment.Jh(getActivity(), null, this.G, this.H, this.J, this.K, 2);
        dismiss();
    }

    private void initUI() {
        this.D = (LinearLayout) this.C.findViewById(R.id.b_7);
        this.D.addView(xh());
        View wh5 = wh(R.string.f154271ec, R.id.f165609wx4);
        this.D.addView(wh5);
        this.F = (GuildSwitchButton) wh5.findViewById(R.id.w4j);
        wh5.setOnClickListener(this);
        View vh5 = vh(R.string.f153721cv, R.id.wws);
        this.E = vh5;
        this.D.addView(vh5);
        this.E.setOnClickListener(this);
    }

    private void initViewModel() {
        if (this.G == null) {
            this.G = (i) c.a(this, i.class, new Function0() { // from class: ox1.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    i yh5;
                    yh5 = RobotActiveMsgControlDialogFragment.this.yh();
                    return yh5;
                }
            });
        }
        this.G.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotActiveMsgControlDialogFragment.this.zh((Boolean) obj);
            }
        });
        this.G.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotActiveMsgControlDialogFragment.this.Ah((Long) obj);
            }
        });
        this.G.W1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotActiveMsgControlDialogFragment.this.Bh((cf1.b) obj);
            }
        });
    }

    private View vh(@StringRes int i3, int i16) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f5w, (ViewGroup) null);
        inflate.setId(i16);
        ((TextView) inflate.findViewById(R.id.f768542s)).setText(i3);
        return inflate;
    }

    private View wh(@StringRes int i3, int i16) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f5x, (ViewGroup) null);
        inflate.setId(i16);
        ((TextView) inflate.findViewById(R.id.f768642t)).setText(i3);
        GuildSwitchButton guildSwitchButton = (GuildSwitchButton) inflate.findViewById(R.id.w4j);
        guildSwitchButton.setOnClickListener(null);
        guildSwitchButton.setClickable(false);
        return inflate;
    }

    private View xh() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f5v, (ViewGroup) null);
        ((GuildUserAvatarView) inflate.findViewById(R.id.f763141b)).setAvatarTinyId(this.H, this.I);
        ((TextView) inflate.findViewById(R.id.f771043g)).setText(this.K);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i yh() {
        return new i(this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(Boolean bool) {
        int i3;
        GuildSwitchButton guildSwitchButton = this.F;
        if (guildSwitchButton != null) {
            guildSwitchButton.setCheckedOnly(bool.booleanValue());
        }
        if (this.E != null) {
            if (bool.booleanValue()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            this.E.setVisibility(i3);
        }
    }

    public void Hh() {
        final ActionSheet createMenuSheet = ActionSheet.createMenuSheet(getContext());
        createMenuSheet.setRoundCornerTop(true);
        createMenuSheet.setMainTitle(R.string.f154211e7);
        createMenuSheet.addButton(R.string.f143520ma, 3, R.id.wwu);
        createMenuSheet.getWindow().clearFlags(2);
        createMenuSheet.addCancelButton(R.string.cancel);
        createMenuSheet.preInitView();
        createMenuSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: ox1.j
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                RobotActiveMsgControlDialogFragment.this.Ch(createMenuSheet, view, i3);
            }
        });
        createMenuSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: ox1.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotActiveMsgControlDialogFragment.Dh(view);
            }
        });
        createMenuSheet.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.f165609wx4) {
                Eh();
            } else if (id5 == R.id.wws) {
                Ih();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.f5u, viewGroup, false);
        initUI();
        initViewModel();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if ((getActivity() instanceof RobotInfoActivity) && ((RobotInfoActivity) getActivity()).F2()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
        a aVar = (a) getDialog();
        if (aVar == null) {
            return;
        }
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(getActivity());
        aVar.getBehavior().setPeekHeight((int) (instantScreenHeight * 0.6f));
        Window window = aVar.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(-1, instantScreenHeight - ImmersiveUtils.getStatusBarHeight(getActivity()));
        window.setGravity(80);
    }

    public RobotActiveMsgControlDialogFragment(i iVar, String str, String str2, String str3) {
        this.G = iVar;
        this.H = str;
        this.I = iVar.X1();
        this.J = str2;
        this.K = str3;
    }
}
