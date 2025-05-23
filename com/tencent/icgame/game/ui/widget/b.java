package com.tencent.icgame.game.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends ReportDialog implements LifecycleOwner {
    private final List<g> C;
    private boolean D;
    private int E;
    private View F;
    protected Context G;
    private LifecycleRegistry H;

    public b(@NonNull Context context, int i3) {
        super(context, i3);
        this.C = new CopyOnWriteArrayList();
        this.D = false;
        this.E = 0;
        init(context);
    }

    private void N() {
        if (this.E != 0 && getWindow() != null) {
            if (getWindow().getDecorView().getSystemUiVisibility() != this.E) {
                getWindow().getDecorView().setSystemUiVisibility(this.E);
            }
            View view = this.F;
            if (view != null) {
                int systemUiVisibility = view.getSystemUiVisibility();
                int i3 = this.E;
                if (systemUiVisibility != i3) {
                    this.F.setSystemUiVisibility(i3);
                }
            }
        }
    }

    private void init(Context context) {
        this.G = context;
        this.H = new LifecycleRegistry(this);
    }

    private boolean isActivityDestroyed() {
        Context context = this.G;
        if (!(context instanceof Activity)) {
            return false;
        }
        if (!((Activity) context).isFinishing() && !((Activity) this.G).isDestroyed()) {
            return false;
        }
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        List<g> list = this.C;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.onCancel(this);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isActivityDestroyed()) {
            com.tencent.icgame.game.utils.g.d("ICGameBaseDialog", getContext() + " is finishing, can't dismiss");
            return;
        }
        if (isShowing()) {
            super.dismiss();
        } else {
            com.tencent.icgame.game.utils.g.d("ICGameBaseDialog", getContext() + " not showing, can't dismiss");
        }
        List<g> list = this.C;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.onDismiss(this);
                }
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.H;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            N();
        }
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view) {
        this.F = view;
        super.setContentView(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (isActivityDestroyed()) {
            com.tencent.icgame.game.utils.g.d("ICGameBaseDialog", getContext() + "show() is destroyed, can't show");
            return;
        }
        if (this.E != 0 && getWindow() != null) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (this.E != 0 && getWindow() != null) {
            N();
            getWindow().clearFlags(8);
        }
        List<g> list = this.C;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.onShow(this);
                }
            }
        }
    }
}
