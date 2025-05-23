package com.tencent.mobileqq.guild.robot.components.auth;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.b;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateMemberDataEvent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotAuthorizeAddFragment extends BottomSheetDialogFragment {
    private WeakReference<View> C;
    private vw1.d F;
    private b G;
    private String H;
    private int D = -2;
    private String E = "cancel";
    private boolean I = true;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(e eVar, Button button, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.setEnabled(false);
        view.setAlpha(0.5f);
        ap0.f.needFetchNewData = true;
        this.G.e();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("qq_robot_robot_role_type", Integer.valueOf(eVar.i0()));
        hashMap.put("qq_robot_on_off", Integer.valueOf(eVar.j0()));
        xh(button, "em_qqrobot_allow", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Ch(WeakReference weakReference, long j3, long j16, long j17, String str, vw1.d dVar, AppRuntime appRuntime, String str2, int i3, String str3, RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        FragmentActivity fragmentActivity = (FragmentActivity) weakReference.get();
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            if (i3 == 0 && b.m(robotAuthorizeAddInfo)) {
                Lh(fragmentActivity, appRuntime, j3, j16, j17, str, robotAuthorizeAddInfo, dVar, str2);
                return;
            }
            QLog.e("RobotAuthorizeFragment", 2, "failed to get permissions, code: " + i3 + ", message: " + str3 + ", guildId: " + j3 + ", robotUin: " + j16 + ", robotTid: " + j17 + ", robotName: " + str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("failed to get robot permissions, server message: ");
            sb5.append(str3);
            dVar.a(i3, sb5.toString());
            return;
        }
        QLog.w("RobotAuthorizeFragment", 2, "cancel showing, guildId: " + j3 + ", robotUin: " + j16 + ", robotTid: " + j17 + ", robotName: " + str);
        dVar.a(-2, "cancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Dh(WeakReference weakReference, GuildChannel guildChannel, RobotInfo robotInfo, vw1.d dVar, AppRuntime appRuntime, String str, int i3, String str2, RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        FragmentActivity fragmentActivity = (FragmentActivity) weakReference.get();
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            if (i3 == 0 && b.m(robotAuthorizeAddInfo)) {
                Lh(fragmentActivity, appRuntime, guildChannel.b(), robotInfo.l(), robotInfo.k(), robotInfo.j(), robotAuthorizeAddInfo, dVar, str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("RobotAuthorizeFragment", 2, "failed to get permissions, code: " + i3 + ", message: " + str2 + ", guildChannel: " + guildChannel + ", robotoInfo: " + robotInfo);
            }
            if (dVar != null) {
                dVar.a(i3, "failed to get robot permissions, server message: " + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("RobotAuthorizeFragment", 2, "cancel showing, guildChannel: " + guildChannel + ", robotoInfo: " + robotInfo);
        }
        if (dVar != null) {
            dVar.a(-2, "cancel");
        }
    }

    public static void Ih(@NonNull FragmentActivity fragmentActivity, @NonNull final long j3, @NonNull final long j16, @NonNull final long j17, @NonNull final String str, @Nullable final vw1.d dVar, @NonNull final String str2) {
        final WeakReference weakReference = new WeakReference(fragmentActivity);
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        b.l(j3, j16, new b.a() { // from class: ax1.e
            @Override // com.tencent.mobileqq.guild.robot.components.auth.b.a
            public final void a(int i3, String str3, RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
                RobotAuthorizeAddFragment.Ch(WeakReference.this, j3, j16, j17, str, dVar, peekAppRuntime, str2, i3, str3, robotAuthorizeAddInfo);
            }
        });
    }

    public static void Jh(@Nullable FragmentActivity fragmentActivity, @Nullable final AppRuntime appRuntime, @Nullable final GuildChannel guildChannel, @Nullable final RobotInfo robotInfo, @Nullable RobotAuthorizeAddInfo robotAuthorizeAddInfo, @Nullable final vw1.d dVar, final String str) {
        if (fragmentActivity != null && appRuntime != null && guildChannel != null && robotInfo != null) {
            if (robotAuthorizeAddInfo == null) {
                final WeakReference weakReference = new WeakReference(fragmentActivity);
                b.l(guildChannel.b(), robotInfo.l(), new b.a() { // from class: ax1.j
                    @Override // com.tencent.mobileqq.guild.robot.components.auth.b.a
                    public final void a(int i3, String str2, RobotAuthorizeAddInfo robotAuthorizeAddInfo2) {
                        RobotAuthorizeAddFragment.Dh(WeakReference.this, guildChannel, robotInfo, dVar, appRuntime, str, i3, str2, robotAuthorizeAddInfo2);
                    }
                });
                return;
            } else {
                Lh(fragmentActivity, appRuntime, guildChannel.b(), robotInfo.l(), robotInfo.k(), robotInfo.j(), robotAuthorizeAddInfo, dVar, str);
                return;
            }
        }
        if (dVar != null) {
            if (QLog.isColorLevel()) {
                QLog.e("RobotAuthorizeFragment", 2, "invalid parameters, hostActivity: " + fragmentActivity + ", appRuntime: " + appRuntime + ", guildChannel: " + guildChannel + ", robotoInfo: " + robotInfo + ", authorizeInfo: " + robotAuthorizeAddInfo);
            }
            dVar.a(-1, "failed to show, invalid parameters.");
        }
    }

    private static void Lh(@NonNull FragmentActivity fragmentActivity, @NonNull AppRuntime appRuntime, @NonNull long j3, @NonNull long j16, @NonNull long j17, @NonNull String str, @NonNull RobotAuthorizeAddInfo robotAuthorizeAddInfo, @Nullable vw1.d dVar, String str2) {
        if (o.c("RobotAuthorizeFragment")) {
            return;
        }
        b bVar = new b(appRuntime, j3, j16, j17, str);
        RobotAuthorizeAddFragment robotAuthorizeAddFragment = new RobotAuthorizeAddFragment();
        robotAuthorizeAddFragment.Fh(dVar);
        robotAuthorizeAddFragment.Gh(bVar);
        robotAuthorizeAddFragment.Hh(str2);
        bVar.o(robotAuthorizeAddFragment);
        bVar.n(robotAuthorizeAddInfo);
        robotAuthorizeAddFragment.show(fragmentActivity.getSupportFragmentManager(), "RobotAuthorizeFragment");
    }

    private void cancel() {
        this.D = -2;
        this.E = "cancel";
        dismiss();
    }

    private void initView() {
        if (this.G == null) {
            QLog.d("RobotAuthorizeFragment", 2, "init view with null controller, return");
            return;
        }
        FragmentActivity activity = getActivity();
        AppRuntime appRuntime = this.G.f232101a;
        View view = this.C.get();
        if (view == null) {
            return;
        }
        String str = this.G.f232105e;
        if (str == null) {
            str = "";
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.y8e);
        TextView textView = (TextView) view.findViewById(R.id.f110806ji);
        TextView textView2 = (TextView) view.findViewById(R.id.f110796jh);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f7915490);
        Button button = (Button) view.findViewById(R.id.tgi);
        final Button button2 = (Button) view.findViewById(R.id.tgh);
        if (imageView != null && textView != null && textView2 != null && recyclerView != null && button != null && button2 != null) {
            if (appRuntime instanceof AppInterface) {
                imageView.setImageDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getUserFaceDrawable((AppInterface) appRuntime, String.valueOf(this.G.f232103c), (byte) 2));
            }
            textView.setText(str);
            textView2.setText(getString(R.string.f153471c7, str));
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            final e eVar = new e(activity);
            eVar.m0(this.G.f());
            recyclerView.setAdapter(eVar);
            button.setOnClickListener(new View.OnClickListener() { // from class: ax1.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RobotAuthorizeAddFragment.this.Ah(view2);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: ax1.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RobotAuthorizeAddFragment.this.Bh(eVar, button2, view2);
                }
            });
            vh(eVar, button);
            xh(button2, "em_qqrobot_allow", null);
            return;
        }
        QLog.e("RobotAuthorizeFragment", 2, "icon = " + imageView + " description = " + textView2 + " recyclerView = " + recyclerView + " reject = " + button + " permit = " + button2);
        dismissAllowingStateLoss();
    }

    private void vh(final e eVar, Button button) {
        View view = this.C.get();
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.wwj);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.f165605wx0);
        final ImageView imageView = (ImageView) view.findViewById(R.id.wwi);
        final ImageView imageView2 = (ImageView) view.findViewById(R.id.wwz);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.wwk);
        View findViewById = view.findViewById(R.id.f116206y4);
        View findViewById2 = view.findViewById(R.id.f116196y3);
        imageView.setVisibility(0);
        imageView2.setVisibility(8);
        linearLayout.setVisibility(0);
        findViewById2.setVisibility(8);
        findViewById.setVisibility(0);
        if (this.G.g() == 2) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ax1.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RobotAuthorizeAddFragment.this.yh(imageView, imageView2, eVar, view2);
                }
            });
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: ax1.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RobotAuthorizeAddFragment.this.zh(imageView, imageView2, eVar, view2);
                }
            });
        } else {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(8);
            linearLayout.setVisibility(8);
            eVar.n0(false);
        }
        xh(button, "em_qqrobot_cancel", null);
    }

    private void wh() {
        if (this.C != null && this.G != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this.C.get(), "pg_qqrobot_add_permissions_more");
            VideoReport.setElementExposePolicy(this.C.get(), ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.C.get(), ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.C.get(), EndExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(String.valueOf(this.G.f232102b));
            if (guildInfo != null) {
                hashMap.put("qq_robot_channel_name", guildInfo.getGuildName());
                hashMap.put("qq_robot_channel_id", guildInfo.getGuildID());
                hashMap.put("qq_robot_user_from", this.H);
                hashMap.put("qq_robot_role_type", Integer.valueOf(guildInfo.getUserType()));
            }
            hashMap.put("qq_robot_robot_id", Long.valueOf(this.G.f232104d));
            VideoReport.setPageParams(this.C.get(), new PageParams(hashMap));
        }
    }

    private void xh(View view, String str, HashMap<String, Object> hashMap) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(ImageView imageView, ImageView imageView2, e eVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.I) {
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            eVar.n0(true);
            this.I = true;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(ImageView imageView, ImageView imageView2, e eVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.I) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            eVar.n0(false);
            this.I = false;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Eh() {
        SimpleEventBus.getInstance().dispatchEvent(new UpdateMemberDataEvent());
        this.D = 0;
        this.E = "";
        dismiss();
    }

    public void Fh(vw1.d dVar) {
        this.F = dVar;
    }

    public void Gh(b bVar) {
        this.G = bVar;
    }

    public void Hh(String str) {
        this.H = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Kh(int i3, String str) {
        this.D = i3;
        this.E = str;
        View view = this.C.get();
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.tgh);
        findViewById.setEnabled(true);
        findViewById.setAlpha(1.0f);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168163f51, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        vw1.d dVar = this.F;
        if (dVar != null) {
            dVar.a(this.D, this.E);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        View view;
        super.onResume();
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (activity == null || aVar == null || aVar.getWindow() == null || (view = this.C.get()) == null) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).setBackgroundColor(0);
        }
        Window window = aVar.getWindow();
        window.setLayout(-1, -2);
        window.setGravity(80);
        window.getAttributes().windowAnimations = R.style.a0o;
        aVar.getBehavior().setState(3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.C = new WeakReference<>(view);
        initView();
        wh();
    }
}
