package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ZplanOnlineStatusFragment extends QPublicBaseFragment {
    private int C;
    private boolean D;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements QUSBaseHalfScreenFloatingView.o {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            if (ZplanOnlineStatusFragment.this.C == 1) {
                ZplanOnlineStatusFragment.this.vh().onZplanPanelCallback(1);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(View view) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LayoutInflater f255370d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f255371e;

        b(LayoutInflater layoutInflater, QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f255370d = layoutInflater;
            this.f255371e = qUSHalfScreenFloatingView;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            return ZplanOnlineStatusFragment.this.wh(this.f255370d, this.f255371e);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOnlineStatusService vh() {
        return (IOnlineStatusService) ((AppActivity) requireActivity()).getAppRuntime().getRuntimeService(IOnlineStatusService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View wh(LayoutInflater layoutInflater, final QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
        int i3;
        try {
            View inflate = layoutInflater.inflate(R.layout.f169211i93, (ViewGroup) null);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) inflate.findViewById(R.id.f126937q4);
            roundRelativeLayout.f316197h = 15;
            roundRelativeLayout.f316195e = ViewUtils.dpToPx(4.0f);
            if (this.D) {
                i3 = R.drawable.n5_;
            } else {
                i3 = R.drawable.n57;
            }
            ((ImageView) inflate.findViewById(R.id.f126947q5)).setImageResource(i3);
            int i16 = this.C;
            if (i16 == 2) {
                ((TextView) inflate.findViewById(R.id.f126927q3)).setText(R.string.f172502qm);
                Button button = (Button) inflate.findViewById(R.id.f126147nz);
                button.setText(R.string.f172352q8);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.cb
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZplanOnlineStatusFragment.xh(QUSHalfScreenFloatingView.this, view);
                    }
                });
            } else if (i16 == 1) {
                ((Button) inflate.findViewById(R.id.f126147nz)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.cc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZplanOnlineStatusFragment.this.yh(qUSHalfScreenFloatingView, view);
                    }
                });
            }
            return inflate;
        } catch (Exception e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "getView zplan_online_status_content: " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xh(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        qUSHalfScreenFloatingView.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        vh().onZplanPanelCallback(2);
        qUSHalfScreenFloatingView.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static void zh(Context context, Intent intent) {
        QLog.i(QPublicBaseFragment.TAG, 1, "goto ZplanOnlineStatusFragment");
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ZplanOnlineStatusFragment.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull @NotNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.e(QPublicBaseFragment.TAG, 1, "onCreateView activity == null");
            view = null;
        } else {
            this.C = activity.getIntent().getIntExtra("type", 1);
            this.D = activity.getIntent().getBooleanExtra("gender", true);
            View inflate = layoutInflater.inflate(R.layout.f169212i94, viewGroup, false);
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) inflate.findViewById(R.id.f126697pg);
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.onlinestatus.ca
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    ZplanOnlineStatusFragment.this.lambda$onCreateView$0();
                }
            });
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
            qUSHalfScreenFloatingView.setOnOutsideClickListener(new a());
            qUSHalfScreenFloatingView.setQUSDragFloatController(new b(layoutInflater, qUSHalfScreenFloatingView));
            view = inflate;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
