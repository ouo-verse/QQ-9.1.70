package com.tencent.mobileqq.guild.channel.create.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.qzone.widget.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IContainerViewCallback;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes12.dex */
public class QQGuildLivePlayListDialogFragment extends BottomSheetDialogFragment {
    private MiniContainerHolder C;
    private ViewGroup D;
    private BottomSheetBehavior E;
    private IContainerViewCallback F;
    private Map<String, ?> G;

    private void th() {
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior();
        this.E = behavior;
        behavior.setPeekHeight(instantScreenHeight);
    }

    private void uh() {
        View view = this.C.getView();
        view.setBackgroundColor(0);
        this.D.addView(view, 0, new ViewGroup.LayoutParams(-1, (int) (ScreenUtil.getInstantScreenHeight(requireContext()) * 0.85714287f)));
        view.setNestedScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void vh(int i3, String str) {
        QLog.i("QGL.QQGuildLivePlayListDialogFragment", 1, "load result code:" + i3 + ",msg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh(final String str) {
        if (this.F != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.create.dialog.QQGuildLivePlayListDialogFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    QQGuildLivePlayListDialogFragment.this.F.onMiniViewResult(str);
                }
            });
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static QQGuildLivePlayListDialogFragment yh(Map<String, ?> map, IContainerViewCallback iContainerViewCallback) {
        QQGuildLivePlayListDialogFragment qQGuildLivePlayListDialogFragment = new QQGuildLivePlayListDialogFragment();
        qQGuildLivePlayListDialogFragment.F = iContainerViewCallback;
        qQGuildLivePlayListDialogFragment.G = map;
        return qQGuildLivePlayListDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        QLog.d("QGL.QQGuildLivePlayListDialogFragment", 1, "onCreateView");
        this.D = (ViewGroup) layoutInflater.inflate(R.layout.f2d, viewGroup, false);
        ContainerLoadParams containerViewCallback = new ContainerLoadParams().setAddDefaultRetryView(true).setAddDefaultLoadingView(true).setForceDefaultUIDarkMode(true).setData(this.G).setLoadingCallback(new IMiniLoadCallback() { // from class: com.tencent.mobileqq.guild.channel.create.dialog.c
            @Override // com.tencent.mobileqq.mini.api.IMiniLoadCallback
            public final void onLoaded(int i3, String str) {
                QQGuildLivePlayListDialogFragment.vh(i3, str);
            }
        }).setContainerViewCallback(new IContainerViewCallback() { // from class: com.tencent.mobileqq.guild.channel.create.dialog.d
            @Override // com.tencent.mobileqq.mini.api.IContainerViewCallback
            public final void onMiniViewResult(String str) {
                QQGuildLivePlayListDialogFragment.this.wh(str);
            }
        });
        Map<String, ?> map = this.G;
        String str = "10000-pages-live/playlist/playlist.html?guild_id=%s&channel_id=%s";
        if (map != null) {
            String format = String.format(Locale.ENGLISH, "10000-pages-live/playlist/playlist.html?guild_id=%s&channel_id=%s", map.get("guild_id"), this.G.get("channel_id"));
            if (this.G.containsKey(u.COLUMN_TAB_ID)) {
                format = format + "&tab_id=" + this.G.get(u.COLUMN_TAB_ID);
            }
            str = format;
            if (this.G.containsKey("program_id")) {
                str = str + "&program_id=" + this.G.get("program_id");
            }
        }
        QLog.d("QGL.QQGuildLivePlayListDialogFragment", 4, "path:" + str);
        this.C = ((IMiniContainer) QRoute.api(IMiniContainer.class)).load(getActivity(), this, str, containerViewCallback);
        uh();
        this.D.findViewById(R.id.xi_).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.create.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildLivePlayListDialogFragment.this.xh(view);
            }
        });
        ViewGroup viewGroup2 = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        QLog.d("QGL.QQGuildLivePlayListDialogFragment", 1, "onDismiss");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        th();
    }
}
