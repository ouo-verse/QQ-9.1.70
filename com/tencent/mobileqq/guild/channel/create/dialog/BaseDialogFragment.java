package com.tencent.mobileqq.guild.channel.create.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseDialogFragment extends BottomSheetDialogFragment implements DialogInterface.OnKeyListener, Handler.Callback {
    protected View C;
    protected View E;
    public BaseDialogFragment F;
    public BaseDialogFragment G;
    protected CreateSubChannelInfo H;
    protected BottomSheetBehavior I;
    private c J;
    private ValueAnimator L;
    public Boolean D = Boolean.TRUE;
    private final WeakReferenceHandler K = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.c.create.BaseDialogFragment", 2, "onSlide\uff1aslideOffset=" + f16);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.c.create.BaseDialogFragment", 2, "onStateChanged\uff1anewState=" + i3);
            }
            if (i3 == 4) {
                BaseDialogFragment.this.rh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BaseDialogFragment.this.J != null) {
                BaseDialogFragment.this.J.a();
            }
            BaseDialogFragment.this.rh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        layoutParams.height = intValue;
        this.E.setLayoutParams(layoutParams);
    }

    private void uh(boolean z16) {
        int vh5;
        int measuredHeight = this.E.getMeasuredHeight();
        if (z16) {
            vh5 = xh();
        } else {
            vh5 = vh();
        }
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, vh5);
        this.L = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.channel.create.dialog.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                BaseDialogFragment.this.Ah(valueAnimator2);
            }
        });
        if (z16) {
            this.L.setStartDelay((vh() * 400) / xh());
        }
        this.L.setDuration(400L);
        this.L.start();
    }

    private int xh() {
        Context context;
        if (getContext() != null) {
            context = getContext();
        } else {
            context = BaseApplication.getContext();
        }
        if (context == null) {
            return 1852;
        }
        return bv.a(context);
    }

    public void Bh() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "reopen");
        }
        uh(false);
    }

    public void Ch(c cVar) {
        this.J = cVar;
    }

    public void Dh(BaseDialogFragment baseDialogFragment) {
        this.F = baseDialogFragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            dismiss();
            return false;
        }
        return false;
    }

    protected void init() {
        View findViewById = this.C.findViewById(R.id.f164814ty2);
        this.E = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = vh();
        this.E.setLayoutParams(layoutParams);
        this.E.setOnClickListener(new b());
        getChildFragmentManager().beginTransaction().replace(R.id.bjz, wh(this.H)).commit();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        CreateSubChannelInfo createSubChannelInfo;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.H = (CreateSubChannelInfo) arguments.getParcelable("extra_key_subchannel_info");
        }
        if (QLog.isColorLevel() && (createSubChannelInfo = this.H) != null) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, String.format("onCreate, guildId=%s, from=%s, categoryId=%s, channelType=%s", createSubChannelInfo.f214821d, createSubChannelInfo.f214823f, Long.valueOf(createSubChannelInfo.f214822e), Integer.valueOf(this.H.f214824h)));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "onCreateDialog");
        }
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        if (zh()) {
            aVar.getWindow().clearFlags(2);
        }
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.efl, viewGroup, false);
        init();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.L = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "onDismiss");
        }
        this.D = Boolean.TRUE;
        super.onDismiss(dialogInterface);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "onKey: keyCode=" + i3);
        }
        if (i3 == 4 && keyEvent.getAction() != 0) {
            sh();
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        aVar.setOnKeyListener(this);
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        this.I = behavior;
        behavior.setState(3);
        this.I.setPeekHeight(0);
        this.I.addBottomSheetCallback(new a());
    }

    public void rh() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "closeAllDialog");
        }
        dismiss();
        BaseDialogFragment baseDialogFragment = this.F;
        if (baseDialogFragment != null) {
            baseDialogFragment.rh();
        }
        BaseDialogFragment baseDialogFragment2 = this.G;
        if (baseDialogFragment2 != null) {
            baseDialogFragment2.dismiss();
        }
    }

    public void sh() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "closeAndBackLastPage : " + this);
        }
        dismiss();
        BaseDialogFragment baseDialogFragment = this.F;
        if (baseDialogFragment != null) {
            baseDialogFragment.D = Boolean.TRUE;
            baseDialogFragment.Bh();
        }
    }

    public void th() {
        this.K.sendEmptyMessageDelayed(1, (vh() * 400) / xh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int vh() {
        Context context;
        if (getContext() != null) {
            context = getContext();
        } else {
            context = BaseApplication.getContext();
        }
        if (context == null) {
            return 396;
        }
        int a16 = (int) ((bv.a(context) * 0.2138229f) - bv.c(context));
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseDialogFragment", 2, "backgroundHeight: " + a16);
        }
        return a16;
    }

    protected abstract Fragment wh(CreateSubChannelInfo createSubChannelInfo);

    public void yh() {
        uh(true);
    }

    protected boolean zh() {
        return false;
    }
}
