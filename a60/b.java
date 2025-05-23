package a60;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.utils.ax;
import com.tencent.biz.qqcircle.utils.ce;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f25564d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f25565e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f25566f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.L9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: a60.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0014b extends AnimatorListenerAdapter {
        C0014b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Iterator it = b.this.f25564d.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    public b() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: a60.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.K9(valueAnimator);
            }
        };
        I9(animatorUpdateListener);
        H9(animatorUpdateListener);
    }

    private void F9() {
        View findViewById;
        if (getActivity() == null || (findViewById = getActivity().findViewById(R.id.f34610zm)) == null) {
            return;
        }
        this.f25564d.add(findViewById);
    }

    private void G9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (!C9(viewGroup, childAt) && childAt != view && childAt.getId() != R.id.f490821q && childAt.getId() != R.id.v9e && childAt.getVisibility() == 0) {
                    this.f25564d.add(childAt);
                }
            }
            if (view.getParent() instanceof View) {
                G9((View) view.getParent());
            }
        }
    }

    private void H9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.f25566f = duration;
        duration.addListener(new C0014b());
        this.f25566f.addUpdateListener(animatorUpdateListener);
    }

    private void I9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.f25565e = duration;
        duration.addListener(new a());
        this.f25565e.addUpdateListener(animatorUpdateListener);
    }

    private boolean J9() {
        Object broadcastGetMessage = broadcastGetMessage("qfs_is_teen_mode_window_show", null);
        if (broadcastGetMessage instanceof Boolean) {
            return ((Boolean) broadcastGetMessage).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f25564d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        Iterator<View> it = this.f25564d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    private void N9() {
        if (this.f25565e.isRunning()) {
            this.f25565e.cancel();
        }
        this.f25566f.start();
    }

    private void O9() {
        if (this.f25566f.isRunning()) {
            this.f25566f.cancel();
        }
        this.f25565e.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B9() {
        View E9 = E9();
        if (E9 == null) {
            QLog.d("QFSBaseClearScreenPart", 1, "clearUi return not init");
            return;
        }
        E9.setVisibility(0);
        if (ce.c(getContext())) {
            QLog.d("QFSBaseClearScreenPart", 1, "already clearUi.");
            return;
        }
        ax.h(getContext(), false);
        View D9 = D9();
        if (D9 != null) {
            G9(D9);
        }
        F9();
        N9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C9(View view, View view2) {
        return false;
    }

    abstract View D9();

    abstract View E9();

    /* JADX INFO: Access modifiers changed from: protected */
    public void M9() {
        View E9 = E9();
        if (E9 == null) {
            QLog.d("QFSBaseClearScreenPart", 1, "showUI return not init");
            return;
        }
        E9.setVisibility(8);
        if (ce.c(getContext())) {
            QLog.d("QFSBaseClearScreenPart", 1, "is Clear UI.");
            return;
        }
        O9();
        if (!J9() && !QCirclePanelStateEvent.isSpecifiedPanelShowing(5) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(7)) {
            ax.h(getContext(), true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
}
