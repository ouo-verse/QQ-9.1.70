package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAnswerControl;
import com.tencent.mobileqq.gamecenter.qa.view.bh;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyAnswerDialog extends BottomSheetDialogFragment {
    private QQGameStrategyAnswerControl C;
    protected BottomSheetBehavior D;
    private View E;
    private boolean F = true;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements bh.x {
        a() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.bh.x
        public void a(boolean z16) {
            QQGameStrategyAnswerDialog.this.F = z16;
            QQGameStrategyAnswerDialog.this.dismiss();
        }
    }

    public static Bundle qh(int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry) {
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putLong("questionId", j3);
        bundle.putString("questionContent", str);
        bundle.putSerializable("channelEntry", gameStrategyChannelEntry);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.C.m0(i3, i16, intent);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        getDialog().getWindow().setSoftInputMode(16);
        Bundle arguments = getArguments();
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = new com.tencent.mobileqq.gamecenter.qa.model.h();
        if (arguments != null) {
            hVar.f212650a = arguments.getInt("appId");
            hVar.f212651b = arguments.getLong("questionId");
            hVar.f212652c = arguments.getString("questionContent");
            hVar.f212654e = (GameStrategyChannelEntry) arguments.getSerializable("channelEntry");
        }
        QQGameStrategyAnswerControl qQGameStrategyAnswerControl = new QQGameStrategyAnswerControl(getActivity(), getContext(), hVar, 1, ThemeUtil.isNowThemeIsNight(null, false, null));
        this.C = qQGameStrategyAnswerControl;
        qQGameStrategyAnswerControl.f2(new a());
        View o06 = this.C.o0(layoutInflater, viewGroup, bundle);
        this.E = o06;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, o06);
        return o06;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C.q0();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.F) {
            return;
        }
        this.C.X1();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.C.r0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.C.t0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.E.getParent()).setBackgroundColor(0);
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior();
        this.D = behavior;
        behavior.setState(3);
        this.D.setPeekHeight(0);
        this.D.addBottomSheetCallback(new b());
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 4) {
                QQGameStrategyAnswerDialog.this.dismiss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
