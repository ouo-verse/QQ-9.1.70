package com.tencent.mobileqq.guild.schedule.create.selectchannel;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import java.util.List;
import mf1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleSelectChannelDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private RecyclerView C;
    private TextView D;
    private kf1.a E;
    private b F;
    private View G;
    private String H = "";
    private ky1.a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements Observer<List<lf1.a>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<lf1.a> list) {
            GuildScheduleSelectChannelDialogFragment.this.th(list);
        }
    }

    private void initData() {
        this.F = (b) h.b(this, b.D).get(b.class);
        if (!TextUtils.isEmpty(this.H)) {
            this.F.Q1(this.H);
        }
        this.F.S1(rh());
        this.F.R1(qh());
        kf1.a aVar = new kf1.a();
        this.E = aVar;
        aVar.m0(this);
        this.C.setAdapter(this.E);
        this.C.setLayoutManager(new LinearLayoutManager(getContext()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.C.setItemAnimator(defaultItemAnimator);
        this.E.setData(this.F.O1(this.H));
    }

    private void initView() {
        this.C = (RecyclerView) this.G.findViewById(R.id.wzb);
        TextView textView = (TextView) this.G.findViewById(R.id.wza);
        this.D = textView;
        textView.setOnClickListener(this);
    }

    private List<Long> qh() {
        return Arrays.asList(1000050L);
    }

    private List<Integer> rh() {
        return Arrays.asList(1, 2, 5, 6, 7);
    }

    private void sh() {
        this.F.P1().observe(getViewLifecycleOwner(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(List<lf1.a> list) {
        if (list != null && list.size() > 0) {
            this.E.setData(list);
        }
    }

    private void uh() {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
            int i3 = getContext().getResources().getDisplayMetrics().heightPixels;
            behavior.setPeekHeight(i3 - x.c(getContext(), 331.0f));
            aVar.getWindow().setLayout(-1, i3 - x.c(getContext(), 82.0f));
            aVar.getWindow().setGravity(80);
        }
    }

    public static void yh(Fragment fragment, String str, ky1.a aVar) {
        GuildScheduleSelectChannelDialogFragment guildScheduleSelectChannelDialogFragment = new GuildScheduleSelectChannelDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", str);
        guildScheduleSelectChannelDialogFragment.setArguments(bundle);
        guildScheduleSelectChannelDialogFragment.xh(aVar);
        d.a(guildScheduleSelectChannelDialogFragment, fragment.getChildFragmentManager(), "Guild.sch.GSSelectChannelDialogFragment");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wza) {
            this.I.a(null);
            dismiss();
        } else {
            lf1.a aVar = (lf1.a) view.getTag();
            if (aVar != null && aVar.f414445c != null) {
                this.I.a(aVar);
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.H = arguments.getString("key_guild_id", "");
        }
        QLog.i("Guild.sch.GSSelectChannelDialogFragment", 1, "[onCreate] mGuildId = " + this.H);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setCanceledOnTouchOutside(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    @SuppressLint({"NewApi"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.G = View.inflate(getActivity(), R.layout.f168174f71, null);
        initView();
        initData();
        sh();
        View view = this.G;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.G.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        uh();
        wh(this.H);
        vh();
    }

    public void xh(ky1.a aVar) {
        this.I = aVar;
    }

    private void vh() {
    }

    private void wh(String str) {
    }
}
