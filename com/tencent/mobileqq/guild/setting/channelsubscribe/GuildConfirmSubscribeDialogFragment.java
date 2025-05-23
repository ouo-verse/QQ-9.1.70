package com.tencent.mobileqq.guild.setting.channelsubscribe;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.guild.setting.channelsubscribe.GuildConfirmSubscribeDialogFragment;
import com.tencent.mobileqq.guild.setting.subscribe.recommend.GuildSubscribeSuccessDialogFragment;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;
import vh2.cc;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildConfirmSubscribeDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    public static final String[] L = {"8.8.83", "8.8.85"};
    private static final int M = ViewUtils.dpToPx(400.0f);
    private View C;
    private View D;
    private QUICheckBox E;
    private ImageView F;
    private URLDrawable.URLDrawableOptions G;
    private View.OnClickListener H;
    private Runnable I;
    private String J;
    private String K;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GuildConfirmSubscribeDialogFragment.this.F.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GuildConfirmSubscribeDialogFragment.this.G.mRequestWidth = GuildConfirmSubscribeDialogFragment.this.F.getMeasuredWidth();
            GuildConfirmSubscribeDialogFragment.this.G.mRequestHeight = (int) (GuildConfirmSubscribeDialogFragment.this.G.mRequestWidth / 1.2175732f);
            GuildConfirmSubscribeDialogFragment.this.F.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/innovate/guild/tips/guild_tips_pic_add_qq_msg_list_v1.png", GuildConfirmSubscribeDialogFragment.this.G));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements cc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f233375a;

        b(FragmentManager fragmentManager) {
            this.f233375a = fragmentManager;
        }

        private void a() {
            if (bw.o0()) {
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.f141020fj, 0).show();
            } else {
                bw.W1();
                GuildSubscribeSuccessDialogFragment.Ph(this.f233375a, GuildConfirmSubscribeDialogFragment.this.I, 0);
            }
        }

        @Override // vh2.cc
        public void onResult(int i3, String str) {
            if (i3 == 0) {
                a();
            } else if (i3 == 110000) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f141010fi, 0).show();
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Bh(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        View view = this.C;
        if (view != null) {
            view.getRootView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: xy1.b
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    GuildConfirmSubscribeDialogFragment.this.zh(view2, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
        }
        View findViewById = dialog.findViewById(R.id.ugk);
        if (findViewById != null && findViewById.getLayoutParams() != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: xy1.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildConfirmSubscribeDialogFragment.this.Ah(view2);
                }
            });
            findViewById.setOnTouchListener(null);
        }
        Fh();
    }

    private void Ch() {
        if (!vh(this.C)) {
            return;
        }
        int wh5 = wh(yh());
        int max = (int) Math.max(0.0f, Math.min(((int) (((Integer) r0.second).intValue() * 0.8d)) - ViewUtils.dpToPx(265.0f), (wh5 - ViewUtils.dpToPx(40.0f)) / 1.2175732f));
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        layoutParams.height = max;
        layoutParams.width = (int) (max * 1.2175732f);
        this.F.setLayoutParams(layoutParams);
        this.C.requestLayout();
    }

    private void Fh() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.C.setLayoutParams(layoutParams);
    }

    public static GuildConfirmSubscribeDialogFragment Gh(FragmentManager fragmentManager, String str, String str2, View.OnClickListener onClickListener) {
        GuildConfirmSubscribeDialogFragment guildConfirmSubscribeDialogFragment = new GuildConfirmSubscribeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("guildId", str);
        bundle.putString("channelId", str2);
        guildConfirmSubscribeDialogFragment.setArguments(bundle);
        guildConfirmSubscribeDialogFragment.Eh(onClickListener);
        d.a(guildConfirmSubscribeDialogFragment, fragmentManager, "Guild.guide.GuildConfirmSubscribeDialogFragment");
        return guildConfirmSubscribeDialogFragment;
    }

    private void Hh() {
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).setQQMsgListChannel(this.J, this.K, 1, xh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreateView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean vh(View view) {
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            return true;
        }
        return false;
    }

    private int wh(Pair<Integer, Integer> pair) {
        if (PadUtil.a(getContext()) == DeviceType.PHONE) {
            return ((Integer) pair.first).intValue();
        }
        return Math.min(M, ((Integer) pair.first).intValue());
    }

    private cc xh() {
        return new b(getParentFragmentManager());
    }

    @NonNull
    private Pair<Integer, Integer> yh() {
        View view = this.C;
        if (view == null) {
            return new Pair<>(Integer.valueOf(ViewUtils.getScreenWidth()), Integer.valueOf(ViewUtils.getScreenHeight()));
        }
        View rootView = view.getRootView();
        return new Pair<>(Integer.valueOf(rootView.getWidth()), Integer.valueOf(rootView.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i17 - i3 != i27 - i19 || i26 - i28 != i16 - i18) {
            Ch();
        }
    }

    public void Dh(Runnable runnable) {
        this.I = runnable;
    }

    public void Eh(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            if (this.E.isChecked()) {
                bw.R0();
            }
            dismissAllowingStateLoss();
            View.OnClickListener onClickListener = this.H;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            } else {
                Hh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.J = arguments.getString("guildId");
            this.K = arguments.getString("channelId");
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ejy, viewGroup, true);
        this.C = inflate;
        this.F = (ImageView) inflate.findViewById(R.id.x1k);
        this.D = this.C.findViewById(R.id.agd);
        this.E = (QUICheckBox) this.C.findViewById(R.id.tpm);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: xy1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildConfirmSubscribeDialogFragment.lambda$onCreateView$0(view);
            }
        });
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        this.G = obtain;
        obtain.mLoadingDrawable = getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
        this.G.mFailedDrawable = getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        URLDrawable.removeMemoryCacheByUrl("https://downv6.qq.com/innovate/guild/tips/guild_tips_pic_add_qq_msg_list_v1.png", this.G);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bh(getDialog());
    }
}
