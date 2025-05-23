package com.tencent.mobileqq.guild.robot.components.console;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cx1.c;
import cx1.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotInfoFragment extends BottomSheetDialogFragment {
    private static WeakReference<a> L;
    private Activity C;
    private String D;
    private boolean E;
    private QQCustomDialog F;
    private RobotInfo H;
    private e I;
    private View J;
    private boolean G = false;
    private List<c> K = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a();

        void b(boolean z16);
    }

    private void initData() {
        Activity activity = this.C;
        if (activity == null) {
            return;
        }
        this.G = false;
        this.I = new e(this.H, this.D, this.E, activity, this, qh());
    }

    private int qh() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 0;
        }
        return arguments.getInt("robot_import_source", 0);
    }

    private void rh() {
        this.F = DialogUtil.createCustomDialog(this.C, 230).setPositiveButton(R.string.f146610un, new DialogInterface.OnClickListener() { // from class: cx1.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RobotInfoFragment.th(dialogInterface, i3);
            }
        });
    }

    public static void sh(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, boolean z16, int i3) {
        if (fragmentActivity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("channelId", str);
        bundle.putString("guildId", str2);
        bundle.putString("robotId", str3);
        bundle.putString("robotUin", str4);
        bundle.putString("userFrom", str5);
        bundle.putBoolean("is_from_direct_msg", z16);
        bundle.putInt("robot_import_source", i3);
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            Intent intent = new Intent(fragmentActivity, (Class<?>) RobotInfoActivity.class);
            intent.putExtra("robot_bundle", bundle);
            fragmentActivity.startActivity(intent, bundle);
        } else if (!fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            RobotInfoFragment robotInfoFragment = new RobotInfoFragment();
            robotInfoFragment.setArguments(bundle);
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            if (supportFragmentManager.isDestroyed()) {
                return;
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(robotInfoFragment, "RobotInfoFragment");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void th(DialogInterface dialogInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotInfoFragment", 1, "i know");
        }
    }

    public static void wh(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, boolean z16, int i3) {
        sh(fragmentActivity, str, str2, str3, str4, str5, z16, i3);
    }

    public static void xh(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, boolean z16, a aVar, int i3) {
        L = new WeakReference<>(aVar);
        sh(fragmentActivity, str, str2, str3, str4, str5, z16, i3);
        WeakReference<a> weakReference = L;
        if (weakReference != null && weakReference.get() != null) {
            L.get().a();
        }
    }

    private long yh(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    public View getRootView() {
        return this.J;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dismiss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        String str = this.D;
        if (str == "4" || str == "5") {
            aVar.getWindow().clearFlags(2);
        }
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C = getActivity();
        this.J = layoutInflater.inflate(R.layout.f5c, viewGroup, false);
        initData();
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onCreateView();
        }
        View view = this.J;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("RobotInfoFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.K.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.G = true;
        Activity activity = this.C;
        if ((activity instanceof RobotInfoActivity) && ((RobotInfoActivity) activity).F2()) {
            this.C.finish();
        }
        WeakReference<a> weakReference = L;
        if (weakReference != null && weakReference.get() != null) {
            L.get().b(this.I.h().j());
            L = null;
        }
        if (this.F != null) {
            this.F = null;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(this.C);
        aVar.getBehavior().setPeekHeight((int) (instantScreenHeight * 0.6f));
        Window window = aVar.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(-1, instantScreenHeight - (ImmersiveUtils.getStatusBarHeight(this.C) + ViewUtils.dip2px(43.0f)));
        window.setGravity(80);
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Iterator<c> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(@Nullable Bundle bundle) {
        int i3;
        super.setArguments(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("guildId");
        String string2 = arguments.getString("channelId");
        String string3 = arguments.getString("robotId");
        String string4 = arguments.getString("robotUin");
        this.E = arguments.getBoolean("is_from_direct_msg");
        this.D = arguments.getString("userFrom");
        RobotInfo robotInfo = new RobotInfo();
        this.H = robotInfo;
        robotInfo.p(yh(string, 0L));
        this.H.n(yh(string2, 0L));
        this.H.t(yh(string3, 0L));
        this.H.u(yh(string4, 0L));
        RobotInfo robotInfo2 = this.H;
        if (this.E) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        robotInfo2.o(i3);
    }

    public void uh(c cVar) {
        this.K.add(cVar);
    }

    public void vh(int i3) {
        if (this.G) {
            return;
        }
        if (this.F == null) {
            rh();
        }
        this.F.setMessage(i3).show();
    }
}
