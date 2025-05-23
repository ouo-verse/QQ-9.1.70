package com.tencent.mobileqq.guild.setting.subscribe.recommend;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.ConversationTabExtra;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.setting.subscribe.recommend.GuildSubscribeSuccessDialogFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSubscribeSuccessDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private static final String[] L = {"https://downv6.qq.com/innovate/guild/tips/guild_quick_setting_first_confirmed.png", "https://downv6.qq.com/innovate/guild/tips/guild_quick_setting_first_confirmed_dark.png"};
    private static final String[] M = {"https://downv6.qq.com/innovate/guild/common/guild_subscribe_first_confirmed.png", "https://downv6.qq.com/innovate/guild/common/guild_subscribe_first_confirmed_dark.png"};
    private View C;
    private View D;
    private View E;
    private ImageView F;
    private TextView G;
    private URLDrawable.URLDrawableOptions H;
    private Runnable I;
    private int J = 0;
    private String K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            String str;
            String str2;
            GuildSubscribeSuccessDialogFragment.this.F.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GuildSubscribeSuccessDialogFragment.this.H.mRequestWidth = GuildSubscribeSuccessDialogFragment.this.F.getMeasuredWidth();
            GuildSubscribeSuccessDialogFragment.this.H.mRequestHeight = GuildSubscribeSuccessDialogFragment.this.F.getMeasuredHeight();
            if (GuildSubscribeSuccessDialogFragment.this.J == 0) {
                GuildSubscribeSuccessDialogFragment guildSubscribeSuccessDialogFragment = GuildSubscribeSuccessDialogFragment.this;
                if (GuildThemeManager.f235286a.b()) {
                    str2 = GuildSubscribeSuccessDialogFragment.L[1];
                } else {
                    str2 = GuildSubscribeSuccessDialogFragment.L[0];
                }
                guildSubscribeSuccessDialogFragment.K = str2;
            } else {
                GuildSubscribeSuccessDialogFragment guildSubscribeSuccessDialogFragment2 = GuildSubscribeSuccessDialogFragment.this;
                if (GuildThemeManager.f235286a.b()) {
                    str = GuildSubscribeSuccessDialogFragment.M[1];
                } else {
                    str = GuildSubscribeSuccessDialogFragment.M[0];
                }
                guildSubscribeSuccessDialogFragment2.K = str;
            }
            GuildSubscribeSuccessDialogFragment.this.F.setImageDrawable(URLDrawable.getDrawable(GuildSubscribeSuccessDialogFragment.this.K, GuildSubscribeSuccessDialogFragment.this.H));
        }
    }

    private boolean Ah(View view) {
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            return true;
        }
        return false;
    }

    private void Bh() {
        Runnable runnable = this.I;
        if (runnable != null) {
            runnable.run();
        }
    }

    private void Ch() {
        Context context;
        int i3;
        this.F = (ImageView) this.C.findViewById(R.id.x1k);
        this.D = this.C.findViewById(R.id.agd);
        this.E = this.C.findViewById(R.id.f108616dl);
        this.G = (TextView) this.C.findViewById(R.id.x1l);
        if (this.J == 0) {
            context = getContext();
            i3 = R.string.f141920hz;
        } else {
            context = getContext();
            i3 = R.string.f157441mx;
        }
        String string = context.getString(i3);
        if (!TextUtils.isEmpty(string)) {
            this.G.setText(string);
        }
    }

    private int Dh(Pair<Integer, Integer> pair) {
        if (PadUtil.a(getContext()) == DeviceType.PHONE) {
            return ((Integer) pair.first).intValue();
        }
        return Math.min(ViewUtils.dpToPx(400.0f), ((Integer) pair.first).intValue());
    }

    @NonNull
    private Pair<Integer, Integer> Eh() {
        View rootView = this.C.getRootView();
        return new Pair<>(Integer.valueOf(rootView.getWidth()), Integer.valueOf(rootView.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i17 - i3 != i27 - i19 || i26 - i28 != i16 - i18) {
            Lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("GuildSubscribeSuccessDialogFragment", 4, "onClick = " + view);
        dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Hh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Jh(Dialog dialog) {
        View findViewById;
        if (dialog != null && (findViewById = dialog.findViewById(R.id.ugk)) != null && findViewById.getLayoutParams() != null) {
            findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: j02.b
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    GuildSubscribeSuccessDialogFragment.this.Fh(view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: j02.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildSubscribeSuccessDialogFragment.this.Gh(view);
                }
            });
            findViewById.setOnTouchListener(null);
        }
    }

    private void Kh() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        this.H = obtain;
        obtain.mLoadingDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.guild_create_subchannel_dialog_bg, null);
        URLDrawable.URLDrawableOptions uRLDrawableOptions = this.H;
        uRLDrawableOptions.mFailedDrawable = uRLDrawableOptions.mLoadingDrawable;
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void Lh() {
        if (!Ah(this.C)) {
            return;
        }
        int Dh = Dh(Eh());
        int max = (int) Math.max(0.0f, Math.min(((int) (((Integer) r0.second).intValue() * 0.8d)) - ViewUtils.dpToPx(265.0f), (Dh - ViewUtils.dpToPx(40.0f)) / 1.2175732f));
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        layoutParams.height = max;
        layoutParams.width = (int) (max * 1.2175732f);
        this.F.setLayoutParams(layoutParams);
        this.C.requestLayout();
    }

    private void Mh() {
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: j02.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSubscribeSuccessDialogFragment.Hh(view);
            }
        });
    }

    private void Nh() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.C.setLayoutParams(layoutParams);
    }

    public static void Oh(FragmentManager fragmentManager) {
        Ph(fragmentManager, new Runnable() { // from class: j02.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildSubscribeSuccessDialogFragment.Ih();
            }
        }, 0);
    }

    public static void Ph(FragmentManager fragmentManager, Runnable runnable, int i3) {
        GuildSubscribeSuccessDialogFragment guildSubscribeSuccessDialogFragment = new GuildSubscribeSuccessDialogFragment();
        guildSubscribeSuccessDialogFragment.I = runnable;
        guildSubscribeSuccessDialogFragment.J = i3;
        d.a(guildSubscribeSuccessDialogFragment, fragmentManager, "GuildSubscribeSuccessDialogFragment");
    }

    private void Qh() {
        JumpGuildParam jumpGuildParam = new JumpGuildParam("", "");
        new ConversationTabExtra(false, true).saveTo(jumpGuildParam.extras);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoConversationGuild(getContext(), jumpGuildParam);
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.C, "pg_sgrp_add_shortcut_success_popup");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            dismissAllowingStateLoss();
        } else if (view == this.E) {
            dismissAllowingStateLoss();
            Bh();
            Qh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getBehavior().setState(3);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.f9q, viewGroup, true);
        Nh();
        Ch();
        Mh();
        Kh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I = null;
        String str = this.K;
        if (str != null) {
            URLDrawable.removeMemoryCacheByUrl(str, this.H);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Jh(getDialog());
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ih() {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 4) {
                GuildSubscribeSuccessDialogFragment.this.dismissAllowingStateLoss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
