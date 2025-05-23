package com.tencent.mobileqq.guild.profile.profilecard.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildConfirmDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private TextView D;
    private TextView E;
    a F;
    boolean G;
    boolean H = false;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void g8(boolean z16);
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.e("Guild.profile.GuildConfirmDialogFragment", 1, "initData : bundle is null");
        } else {
            this.G = arguments.getBoolean("isClearGreyBg");
        }
    }

    private void initView() {
        this.D = (TextView) this.C.findViewById(R.id.f908953p);
        this.E = (TextView) this.C.findViewById(R.id.tlo);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
    }

    private void ph(boolean z16) {
        a aVar = this.F;
        if (aVar != null) {
            aVar.g8(z16);
        }
        this.H = true;
        dismiss();
    }

    public static void rh(FragmentActivity fragmentActivity, boolean z16, a aVar) {
        QLog.i("Guild.profile.GuildConfirmDialogFragment", 1, "show GuildConfirmDialogFragment\uff0c isClearGreyBg\uff1a" + z16);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isClearGreyBg", z16);
        GuildConfirmDialogFragment guildConfirmDialogFragment = new GuildConfirmDialogFragment();
        guildConfirmDialogFragment.setArguments(bundle);
        guildConfirmDialogFragment.qh(aVar);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            guildConfirmDialogFragment.show(supportFragmentManager, "Guild.profile.GuildConfirmDialogFragment");
        } catch (IllegalStateException unused) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(guildConfirmDialogFragment, "Guild.profile.GuildConfirmDialogFragment");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            ph(true);
        } else if (view == this.E) {
            ph(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        if (this.G) {
            aVar.getWindow().clearFlags(2);
        }
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.ejw, viewGroup, false);
        initView();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar;
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildConfirmDialogFragment", 2, "onDismiss");
        }
        if (!this.H && (aVar = this.F) != null) {
            aVar.g8(false);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
    }

    public void qh(a aVar) {
        this.F = aVar;
    }
}
