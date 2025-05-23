package m73;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.event.WinkPlayerControlEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.extension.e;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends com.tencent.mobileqq.wink.editor.d implements SimpleEventReceiver, View.OnClickListener {
    public static final int W = Color.parseColor("#80000000");
    public static final int X = ViewUtils.dip2px(2.0f);
    public static final int Y = ViewUtils.dip2px(4.0f);
    private static final int Z = ViewUtils.dip2px(16.0f);

    /* renamed from: a0, reason: collision with root package name */
    private static final int f416382a0 = ViewUtils.dip2px(6.0f);

    /* renamed from: b0, reason: collision with root package name */
    public static final int f416383b0 = ViewUtils.getScreenWidth();
    private FrameLayout D;
    private FrameLayout E;
    private SeekBar F;
    private ImageView G;
    private FrameLayout H;
    private TextView I;
    private TextView J;
    private x K;
    private Animation L;
    private Animation M;
    private boolean P;
    private boolean Q;
    private boolean N = false;
    private boolean R = true;
    private boolean S = false;
    private float T = 0.0f;
    private boolean U = false;
    private int V = f416382a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b.this.F.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: m73.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C10771b implements SeekBar.OnSeekBarChangeListener {
        C10771b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            IPlayer sa5 = b.this.sa();
            if (z16 && sa5 != null && b.this.H9() != null && b.this.V > 0) {
                long ra5 = b.this.ra();
                float f16 = 100000.0f;
                if (b.this.S && ra5 > 0) {
                    b.this.T = i3 - (((((float) sa5.getCurrentPlayUs()) * 1.0f) / ((float) ra5)) * 100000.0f);
                    b.this.S = false;
                }
                float f17 = i3;
                float f18 = f17 - b.this.T;
                if ((b.this.G.getX() == 0.0f && f17 < b.this.T) || f18 < 0.0f) {
                    f16 = 0.0f;
                } else if ((b.this.G.getX() != 100000.0f || f17 - b.this.T < 100000.0f) && f18 < 100000.0f) {
                    f16 = f18;
                }
                double d16 = f16 / 100000.0d;
                long j3 = (long) (ra5 * d16);
                sa5.seek(j3);
                b.this.F.setProgress((int) (100000.0d * d16));
                b.this.Ia(d16);
                b.this.I.setText(b.this.ta(j3, ra5));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.V = b.Z;
            b.this.U = true;
            IPlayer sa5 = b.this.sa();
            if (sa5 != null && b.this.H9() != null) {
                seekBar.getLayoutParams().height = ViewUtils.dpToPx(4.0f);
                seekBar.requestLayout();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.G.getLayoutParams();
                layoutParams.height = b.this.V;
                layoutParams.width = b.this.V;
                layoutParams.bottomMargin = ViewUtils.dpToPx(8.0f);
                b.this.G.requestLayout();
                b.this.H.setVisibility(0);
                if (sa5.isPlaying()) {
                    b.this.R = true;
                } else if (!sa5.isPlaying()) {
                    b.this.R = false;
                }
                b.this.Ea(false);
                b.this.I.setVisibility(0);
                b.this.xa(false);
                b.this.I.setText(b.this.ta(sa5.getCurrentPlayUs(), b.this.ra()));
                SimpleEventBus.getInstance().dispatchEvent(new WinkPlayerControlEvent(3));
                b.this.S = true;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            b.this.V = b.f416382a0;
            b.this.U = false;
            seekBar.getLayoutParams().height = ViewUtils.dpToPx(2.0f);
            seekBar.requestLayout();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.G.getLayoutParams();
            layoutParams.height = b.this.V;
            layoutParams.width = b.this.V;
            layoutParams.bottomMargin = ViewUtils.dpToPx(12.0f);
            b.this.G.requestLayout();
            b.this.H.setVisibility(8);
            b.this.Ia((seekBar.getProgress() * 1.0f) / 100000.0f);
            if (b.this.R) {
                b.this.Fa();
            }
            b.this.xa(!r0.R);
            b.this.I.setVisibility(8);
            SimpleEventBus.getInstance().dispatchEvent(new WinkPlayerControlEvent(4));
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    private void Aa() {
        FrameLayout frameLayout = this.E;
        if (frameLayout == null) {
            return;
        }
        int i3 = 0;
        frameLayout.setVisibility(0);
        this.J.setOnClickListener(this);
        this.I.setVisibility(8);
        this.E.setOnTouchListener(new a());
        this.F.setMax(100000);
        ((FrameLayout.LayoutParams) this.F.getLayoutParams()).height = ViewUtils.dpToPx(2.0f);
        this.F.requestLayout();
        ((FrameLayout.LayoutParams) this.G.getLayoutParams()).bottomMargin = ViewUtils.dpToPx(12.0f);
        this.G.requestLayout();
        this.F.setOnSeekBarChangeListener(new C10771b());
        FrameLayout frameLayout2 = this.E;
        if (this.Q) {
            i3 = 8;
        }
        frameLayout2.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(MenuSwitchAction menuSwitchAction) {
        boolean z16;
        boolean z17 = false;
        if (menuSwitchAction.getMenuType() == MenuType.BOTTOM_DASHBOARD) {
            if (H9() != null && H9().isPlaying()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.P && !z16) {
                z17 = true;
            }
            xa(z17);
            return;
        }
        this.P = this.N;
        xa(false);
    }

    private void Ha(long j3, long j16) {
        this.J.setText(ta(j3, j16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia(double d16) {
        float width = ((float) d16) * (this.F.getWidth() - this.V);
        if (width < 0.0f) {
            width = 0.0f;
        }
        this.G.setX(width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ra() {
        if (H9() == null) {
            return 0L;
        }
        return Math.min(H9().getDurationUs(), H9().h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableString ta(long j3, long j16) {
        String d16 = com.tencent.mobileqq.wink.editor.music.a.d(j3);
        SpannableString spannableString = new SpannableString(d16 + " / " + com.tencent.mobileqq.wink.editor.music.a.d(j16));
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, d16.length(), 17);
        return spannableString;
    }

    private x va() {
        if (this.K == null) {
            this.K = (x) getViewModel(x.class);
        }
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z16) {
        Animation qa5;
        ms.a.a("WinkEditorSeekbarPart", "handlePauseLayout, needShow = " + z16);
        if (this.N != z16) {
            if (z16) {
                qa5 = ua();
            } else {
                qa5 = qa();
            }
            this.J.startAnimation(qa5);
        }
        this.N = z16;
        IPlayer sa5 = sa();
        if (z16 && sa5 != null && H9() != null) {
            Ha(sa5.getCurrentPlayUs(), ra());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f81824f8;
    }

    public void Ca(long j3, long j16) {
        if (this.F != null && ((float) j16) > 0.0f) {
            long min = Math.min(j16, ra());
            if (!this.U) {
                double d16 = j3 / min;
                this.F.setProgress((int) (100000.0d * d16));
                Ia(d16);
            }
            if (this.N) {
                Ha(j3, min);
            }
        }
    }

    public void Da(IPlayer.PlayerStatus playerStatus) {
        if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
            xa(false);
        }
    }

    public void Ea(boolean z16) {
        xa(z16);
        IPlayer sa5 = sa();
        if (sa5 != null && sa5.isPlaying()) {
            sa5.pause();
        }
    }

    public void Fa() {
        xa(false);
        IPlayer sa5 = sa();
        if (sa5 != null && !sa5.isPlaying()) {
            sa5.play();
        }
    }

    public void Ga() {
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        SeekBar seekBar = this.F;
        if (seekBar != null) {
            seekBar.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        super.J9(editMode);
        if (editMode == WinkEditorViewModel.EditMode.Video) {
            Q9(getHostFragment().getArguments());
        } else {
            x9();
        }
    }

    public void Ja(long j3) {
        float f16;
        float f17;
        float f18;
        if (H9() != null && ra() != 0) {
            this.K = va();
            if (!H9().G() && e.u(H9().g0())) {
                f16 = 1000000.0f;
            } else {
                f16 = 0.0f;
            }
            float min = (float) Math.min(j3, H9().h());
            ArrayList arrayList = new ArrayList();
            MediaModel V = H9().V();
            float f19 = 0.0f;
            for (int i3 = 0; i3 < V.videos.size(); i3++) {
                MediaClip mediaClip = V.videos.get(i3);
                if (i3 != 0 && i3 != V.videos.size() - 1) {
                    f17 = f16;
                } else {
                    f17 = f16 / 2.0f;
                }
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    f18 = ((float) resourceModel.scaleDuration) - f17;
                } else {
                    f18 = 0.0f;
                }
                f19 += f18;
                arrayList.add(Float.valueOf(f19));
            }
            this.H.removeAllViews();
            Context context = getContext();
            if (arrayList.size() > 1 && context != null) {
                for (int i16 = 0; i16 < arrayList.size() && i16 != arrayList.size() - 1; i16++) {
                    float floatValue = ((Float) arrayList.get(i16)).floatValue();
                    View view = new View(context);
                    view.setBackgroundColor(W);
                    this.H.addView(view, X, Y);
                    view.setX((floatValue / min) * f416383b0);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        Ja(ra());
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void Q9(@Nullable Bundle bundle) {
        FrameLayout frameLayout;
        super.Q9(bundle);
        if (!this.Q && (frameLayout = this.D) != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WinkPlayerControlEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorSeekbarPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        int i3 = 0;
        this.Q = AECameraPrefsUtil.c().b("SP_HIDE_DYNAMIC_UI", false, 0);
        this.D = (FrameLayout) view.findViewById(R.id.f6439364);
        this.E = (FrameLayout) view.findViewById(R.id.v9e);
        this.F = (SeekBar) view.findViewById(R.id.vad);
        this.G = (ImageView) view.findViewById(R.id.vae);
        this.H = (FrameLayout) view.findViewById(R.id.f644936d);
        this.I = (TextView) view.findViewById(R.id.f123937i0);
        this.J = (TextView) view.findViewById(R.id.f645036e);
        Aa();
        this.winkEditorViewModel.f3().observe(F9(), new Observer() { // from class: m73.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.this.Ba((MenuSwitchAction) obj);
            }
        });
        FrameLayout frameLayout = this.D;
        if (this.Q) {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f645036e) {
            Fa();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View view) {
        super.onInitView(view);
        Q9(getHostFragment().getArguments());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof WinkPlayerControlEvent)) {
            return;
        }
        WinkPlayerControlEvent winkPlayerControlEvent = (WinkPlayerControlEvent) simpleBaseEvent;
        int i3 = winkPlayerControlEvent.mEventType;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 == 2) {
                if (winkPlayerControlEvent.mFrom == 3) {
                    z16 = false;
                }
                Ea(z16);
                return;
            }
            return;
        }
        Fa();
    }

    public Animation qa() {
        if (this.M == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
            this.M = loadAnimation;
            loadAnimation.setAnimationListener(new d());
        }
        return this.M;
    }

    public IPlayer sa() {
        if (H9() != null) {
            return H9().getCurrentPlayer();
        }
        return null;
    }

    public Animation ua() {
        if (this.L == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
            this.L = loadAnimation;
            loadAnimation.setAnimationListener(new c());
        }
        return this.L;
    }

    public void wa() {
        IPlayer sa5 = sa();
        if (sa5 == null) {
            return;
        }
        if (sa5.isPlaying()) {
            Ea(true);
        } else {
            Fa();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void x9() {
        super.x9();
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void za() {
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        SeekBar seekBar = this.F;
        if (seekBar != null) {
            seekBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.J.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.J.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
