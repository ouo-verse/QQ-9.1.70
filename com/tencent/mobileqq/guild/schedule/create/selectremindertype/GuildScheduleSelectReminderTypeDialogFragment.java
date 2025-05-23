package com.tencent.mobileqq.guild.schedule.create.selectremindertype;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;
import ly1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleSelectReminderTypeDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private TextView D;
    private TextView E;
    private WheelView F;
    private ly1.a G;
    private int H;
    private List<ly1.b> I = new ArrayList();
    private ly1.b J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            QLog.i("Guild.sch.GSSelectReminderTypeDialogFragment", 1, String.format("onItemSelected, %s", Integer.valueOf(i3)));
            GuildScheduleSelectReminderTypeDialogFragment guildScheduleSelectReminderTypeDialogFragment = GuildScheduleSelectReminderTypeDialogFragment.this;
            guildScheduleSelectReminderTypeDialogFragment.J = (ly1.b) guildScheduleSelectReminderTypeDialogFragment.I.get(i3);
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            QLog.i("Guild.sch.GSSelectReminderTypeDialogFragment", 1, String.format("onNothingSelected", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements VerticalGallery.OnSelectViewDataUpdateListener {
        b() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            QLog.i("Guild.sch.GSSelectReminderTypeDialogFragment", 1, String.format("onSelectDataUpdate", new Object[0]));
        }
    }

    private void Ah(int i3) {
        for (int i16 = 0; i16 < this.I.size(); i16++) {
            if (this.I.get(i16).c() == i3) {
                this.F.setSelection(i16);
                return;
            }
        }
    }

    private void initData() {
        sh();
        yh();
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i3 = arguments.getInt("reminder_type");
            this.H = i3;
            Ah(i3);
        }
    }

    private void initView() {
        this.D = (TextView) this.C.findViewById(R.id.wxq);
        this.E = (TextView) this.C.findViewById(R.id.wxs);
        WheelView wheelView = (WheelView) this.C.findViewById(R.id.wxt);
        this.F = wheelView;
        wheelView.setmMaxSkew(0.0f);
        this.F.setmMaxRotationAngle(0);
        this.F.setNeedTranslate(false);
        this.E.setOnClickListener(this);
        this.D.setOnClickListener(this);
    }

    private void sh() {
        this.I.add(ly1.b.f415774c);
        this.I.add(ly1.b.f415775d);
        this.I.add(ly1.b.f415776e);
        this.I.add(ly1.b.f415777f);
        this.I.add(ly1.b.f415778g);
        this.I.add(ly1.b.f415779h);
    }

    private static Bundle th(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("reminder_type", i3);
        return bundle;
    }

    private void uh() {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            aVar.getBehavior().setPeekHeight(x.c(getContext(), 378.0f));
            aVar.getWindow().setLayout(-1, x.c(getContext(), 378.0f));
            aVar.getWindow().setGravity(80);
        }
    }

    private void yh() {
        this.F.setAdapter((SpinnerAdapter) new c(getContext(), this.I));
        this.F.setOnItemSelectedListener(new a());
        this.F.setOnSelectViewDataUpdateListener(new b());
    }

    public static void zh(Fragment fragment, int i3, ly1.a aVar) {
        GuildScheduleSelectReminderTypeDialogFragment guildScheduleSelectReminderTypeDialogFragment = new GuildScheduleSelectReminderTypeDialogFragment();
        guildScheduleSelectReminderTypeDialogFragment.xh(aVar);
        guildScheduleSelectReminderTypeDialogFragment.setArguments(th(i3));
        d.a(guildScheduleSelectReminderTypeDialogFragment, fragment.getChildFragmentManager(), "Guild.sch.GSSelectReminderTypeDialogFragment");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wxs) {
            ly1.b bVar = this.J;
            if (bVar != null) {
                this.G.a(true, bVar.c());
                dismiss();
            } else {
                QLog.i("Guild.sch.GSSelectReminderTypeDialogFragment", 1, String.format("onClick, mSelectReminderItem == null", new Object[0]));
            }
        } else if (view.getId() == R.id.wxq) {
            this.G.a(false, 0);
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    @SuppressLint({"NewApi"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = View.inflate(getActivity(), R.layout.f168175f72, null);
        initView();
        initData();
        rh();
        View view = this.C;
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
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        uh();
        wh("");
        vh();
    }

    public void xh(ly1.a aVar) {
        this.G = aVar;
    }

    private void rh() {
    }

    private void vh() {
    }

    private void wh(String str) {
    }
}
