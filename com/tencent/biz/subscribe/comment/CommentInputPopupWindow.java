package com.tencent.biz.subscribe.comment;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class CommentInputPopupWindow extends p implements View.OnClickListener, DialogInterface.OnDismissListener {
    private ImageButton D;
    private CommentEditText E;
    private ImageButton F;
    private EmoView G;
    private InputMethodManager H;
    private boolean I;
    private b J;
    private View K;
    private q L;
    private Handler M;
    private boolean N;

    /* renamed from: com.tencent.biz.subscribe.comment.CommentInputPopupWindow$10, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ CommentInputPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.F.setVisibility(8);
            this.this$0.D.setVisibility(0);
            this.this$0.Y(true);
            this.this$0.E.requestFocus();
        }
    }

    /* renamed from: com.tencent.biz.subscribe.comment.CommentInputPopupWindow$9, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ CommentInputPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.b0();
            this.this$0.F.setVisibility(0);
            this.this$0.D.setVisibility(8);
        }
    }

    private Handler X() {
        if (this.M == null) {
            this.M = new Handler(Looper.getMainLooper());
        }
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z16) {
        EmoView emoView = this.G;
        if (emoView != null) {
            emoView.setVisibility(8);
        }
        d0(this.K);
        if (z16) {
            c0(this.E);
        }
    }

    private void a0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = view.getHeight();
        layoutParams.weight = 0.0f;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        boolean z16;
        if (this.I) {
            a0(this.K);
        }
        this.N = true;
        this.G.setVisibility(0);
        final WorkSpaceView workSpaceView = (WorkSpaceView) this.G.getChildAt(0);
        if (workSpaceView != null) {
            X().post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentInputPopupWindow.8
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("CommentInputPopupWindow", 1, "top   " + workSpaceView.getTop() + " bottom\uff1a " + workSpaceView.getBottom() + " getx :  " + workSpaceView.getX() + " gety :  " + workSpaceView.getY() + "   Width\uff1a  " + workSpaceView.getMeasuredWidth() + "  Height\uff1a  " + workSpaceView.getMeasuredHeight());
                }
            });
        }
        Object[] objArr = new Object[1];
        if (("workSpaceView is empty" + workSpaceView) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        QLog.d("CommentInputPopupWindow", 1, objArr);
        Z(this.E);
    }

    private void d0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
    }

    public void Z(View view) {
        this.H.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void c0(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.CommentInputPopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                CommentInputPopupWindow.this.H.showSoftInput(view, 1);
            }
        });
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Z(this.E);
        Y(false);
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("CommentInputPopupWindow", 1, "onClick:" + view.getId());
        int id5 = view.getId();
        if (id5 == R.id.ah5) {
            QLog.d("CommentInputPopupWindow", 1, "btn_emotion");
            b0();
            this.F.setVisibility(0);
            this.D.setVisibility(8);
        } else if (id5 == R.id.jha) {
            QLog.d("CommentInputPopupWindow", 1, "text_input");
            Y(true);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
        } else if (id5 == R.id.aiz) {
            b bVar = this.J;
            if (bVar != null) {
                bVar.a();
            }
        } else if (id5 == R.id.f164666ai3) {
            QLog.d("CommentInputPopupWindow", 1, "btn_keyboard");
            Y(true);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.L.d();
        this.L = null;
        this.D.setVisibility(8);
        this.F.setVisibility(0);
        this.I = false;
    }
}
