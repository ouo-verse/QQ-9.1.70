package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildModifyNickNameDialog extends ReportAndroidXDialogFragment implements View.OnClickListener {
    private QUSHalfScreenFloatingView E;
    private View F;
    private View G;
    private TextView H;
    private TextView I;
    private QUISingleLineInputView J;
    private GuildModifyNameViewModel K;
    private GuildMeViewModel L;
    private com.tencent.mobileqq.guild.window.s N;
    private int C = 1;
    private int D = 12;
    private int M = 0;
    private h53.q P = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        public View createContentView() {
            View inflate = LayoutInflater.from(GuildModifyNickNameDialog.this.getContext()).inflate(R.layout.exr, (ViewGroup) null);
            GuildModifyNickNameDialog.this.Bh(inflate);
            return inflate;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        void a(String str);
    }

    private int Ah() {
        Context context;
        if (getContext() != null) {
            context = getContext();
        } else {
            context = BaseApplication.getContext();
        }
        int a16 = bv.a(context);
        if (a16 <= 0) {
            return QQGuildUIUtil.f(451.0f);
        }
        return (int) ((a16 * 0.6f) - QQGuildUIUtil.f(15.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(View view) {
        this.G = view.findViewById(R.id.wol);
        this.H = (TextView) view.findViewById(R.id.x2y);
        this.I = (TextView) view.findViewById(R.id.f165642x34);
        this.J = (QUISingleLineInputView) view.findViewById(R.id.wju);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, Ah());
        this.G.setLayoutParams(layoutParams);
        QLog.i("Guild.profile.GuildModifyNickNameDialog", 1, "initContentHeight\uff1a" + layoutParams.height);
        this.J.setMaxWordCount(this.D);
        this.J.setInputViewWatcher(this.P);
        ev l3 = aj.l();
        if (l3 != null && !TextUtils.isEmpty(l3.getNickName())) {
            Hh(l3.getNickName());
            Gh(false);
        }
    }

    private void Ch() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) this.F.findViewById(R.id.f66733bf);
        this.E = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        this.E.setQUSDragFloatController(new b());
        this.E.J();
        this.E.setOnDismissStartListener(new QUSBaseHalfScreenFloatingView.m() { // from class: com.tencent.mobileqq.guild.profile.me.r
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.m
            public final void a() {
                GuildModifyNickNameDialog.this.Dh();
            }
        });
        this.E.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.profile.me.s
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildModifyNickNameDialog.this.dismissAllowingStateLoss();
            }
        });
        this.E.i(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh() {
        this.J.p();
    }

    private void Eh() {
        new GuildDTReportApiImpl().setElementExposureAndClickParams(this.I, "em_sgrp_mine_nick_finish", null);
    }

    private void Fh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.F, "pg_sgrp_mine_edit");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.setPageParams(this.F, new PageParams(hashMap));
    }

    private void Gh(boolean z16) {
        float f16;
        this.I.setEnabled(z16);
        TextView textView = this.I;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        textView.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(String str) {
        CharSequence d16 = this.J.d();
        if (d16 != null && d16.toString().trim().equals(str)) {
            return;
        }
        this.J.setContentText(str);
        QUISingleLineInputView qUISingleLineInputView = this.J;
        qUISingleLineInputView.setTextSelection(qUISingleLineInputView.d().length());
        Ih(cb.b(this.J.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(cb.b bVar) {
        boolean z16;
        if (bVar.a() >= this.C) {
            z16 = true;
        } else {
            z16 = false;
        }
        Gh(z16);
    }

    public static void Jh(FragmentManager fragmentManager) {
        new GuildModifyNickNameDialog().show(fragmentManager, "Guild.profile.GuildModifyNickNameDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        this.J.q();
        this.J.z();
    }

    private void Lh() {
        this.K.modifyNickName(this.J.d().toString().trim(), null);
    }

    private void initViewModel() {
        this.K = (GuildModifyNameViewModel) com.tencent.mobileqq.mvvm.h.b(this, BaseChannelViewModel.sViewModelFactory).get(GuildModifyNameViewModel.class);
        this.K.init(ch.l());
        GuildMeViewModel guildMeViewModel = (GuildMeViewModel) com.tencent.mobileqq.mvvm.h.b(this, BaseChannelViewModel.sViewModelFactory).get(GuildMeViewModel.class);
        this.L = guildMeViewModel;
        guildMeViewModel.init();
        this.L.getName().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildModifyNickNameDialog.this.Hh((String) obj);
            }
        });
    }

    private void yh() {
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildModifyNickNameDialog.this.onClick(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildModifyNickNameDialog.this.onClick(view);
            }
        });
    }

    private void zh() {
        this.J.p();
        Lh();
        this.E.t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.x2y) {
            this.J.p();
            this.E.t();
        } else if (id5 == R.id.f165642x34) {
            zh();
            VideoReport.reportEvent("dt_clck", this.I, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.f173448dl);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.F = layoutInflater.inflate(R.layout.e3i, viewGroup, false);
        Ch();
        yh();
        initViewModel();
        Fh();
        Eh();
        com.tencent.mobileqq.guild.window.s sVar = new com.tencent.mobileqq.guild.window.s(this.F);
        this.N = sVar;
        sVar.g(new a());
        View view = this.F;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.N.j();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildModifyNickNameDialog.this.Kh();
            }
        }, 250L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.F.getParent()).setBackgroundColor(0);
        if (getDialog() != null && getDialog().getWindow() != null) {
            GuildUIUtils.H(getDialog().getWindow());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setSoftInputMode(16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements s.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int i3) {
            if (GuildModifyNickNameDialog.this.M != i3) {
                GuildModifyNickNameDialog.this.M = i3;
                int f16 = GuildModifyNickNameDialog.this.M + QQGuildUIUtil.f(144.0f);
                ViewGroup.LayoutParams layoutParams = GuildModifyNickNameDialog.this.G.getLayoutParams();
                if (layoutParams.height < f16) {
                    QLog.i("Guild.profile.GuildModifyNickNameDialog", 1, "changeHeight:" + layoutParams.height + "->" + f16);
                    layoutParams.height = f16;
                    GuildModifyNickNameDialog.this.G.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardClosed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements QUSBaseHalfScreenFloatingView.n {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
            GuildModifyNickNameDialog.this.J.p();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements h53.q {
        d() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
            String charSequence = GuildModifyNickNameDialog.this.J.d().toString();
            if (!"".equals(charSequence) && "".equals(charSequence.trim())) {
                GuildModifyNickNameDialog.this.J.setContentText("");
                return;
            }
            String replaceAll = charSequence.replaceAll("[\\s]+", " ");
            if (!replaceAll.equals(charSequence)) {
                GuildModifyNickNameDialog.this.J.setContentText(replaceAll);
                GuildModifyNickNameDialog.this.J.setTextSelection(GuildModifyNickNameDialog.this.J.d().length());
            } else {
                GuildModifyNickNameDialog.this.Ih(cb.b(GuildModifyNickNameDialog.this.J.d()));
            }
        }

        @Override // h53.q
        public void A4(String str) {
        }

        @Override // h53.k
        public void f8(boolean z16) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
