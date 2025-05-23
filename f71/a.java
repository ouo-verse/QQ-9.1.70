package f71;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.s;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements ArkViewImplement.InputCallback {

    /* renamed from: a, reason: collision with root package name */
    private BubblePopupWindow f397967a = null;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f397968b = null;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f397969c = null;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f397970d = null;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f397971e = null;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<ArkAppView> f397972f;

    /* compiled from: P */
    /* renamed from: f71.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class ViewOnClickListenerC10284a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f397973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArkViewImplement.ArkViewInterface f397974e;

        ViewOnClickListenerC10284a(int i3, ArkViewImplement.ArkViewInterface arkViewInterface) {
            this.f397973d = i3;
            this.f397974e = arkViewInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            int i3 = this.f397973d;
            if (i3 == 2) {
                if (id5 == 0) {
                    this.f397974e.doInputCommand(5);
                } else if (id5 == 1) {
                    this.f397974e.doInputCommand(4);
                } else if (id5 == 2) {
                    this.f397974e.doInputCommand(3);
                }
            } else if (i3 == 1) {
                if (id5 == 0) {
                    this.f397974e.doInputCommand(1);
                } else if (id5 == 1) {
                    this.f397974e.doInputCommand(2);
                } else if (id5 == 2) {
                    this.f397974e.doInputCommand(3);
                }
            } else {
                this.f397974e.doInputCommand(3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(ArkAppView arkAppView) {
        this.f397972f = null;
        this.f397972f = new WeakReference<>(arkAppView);
    }

    private void b(View view) {
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(8);
        }
    }

    private void d(View view, int i3, int i16) {
        if (view != null) {
            view.setVisibility(0);
            view.animate().x(i3).y(i16).setDuration(0L).start();
        }
    }

    public int a() {
        ImageView imageView = this.f397970d;
        if (imageView != null) {
            return imageView.getHeight();
        }
        return 0;
    }

    public void c(ViewGroup viewGroup) {
        this.f397971e = viewGroup;
    }

    @Override // com.tencent.ark.ArkViewImplement.InputCallback
    public void onFocusChanged(View view, boolean z16) {
        ArkAppView arkAppView = this.f397972f.get();
        if (arkAppView == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) arkAppView.getParent();
        ViewGroup viewGroup2 = this.f397971e;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        }
        if (viewGroup == null) {
            return;
        }
        if (z16) {
            Drawable drawable = arkAppView.getResources().getDrawable(R.drawable.c_c);
            Drawable drawable2 = arkAppView.getResources().getDrawable(R.drawable.c_b);
            arkAppView.setInputSetSelectHolderSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            arkAppView.setInputSetCaretHolderSize(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            if (this.f397968b == null) {
                ImageView imageView = new ImageView(arkAppView.getContext());
                this.f397968b = imageView;
                imageView.setBackgroundDrawable(drawable);
                this.f397968b.setScaleX(-1.0f);
                viewGroup.addView(this.f397968b, new RelativeLayout.LayoutParams(-2, -2));
                this.f397968b.setVisibility(8);
                this.f397968b.setOnTouchListener(arkAppView);
            }
            if (this.f397969c == null) {
                ImageView imageView2 = new ImageView(arkAppView.getContext());
                this.f397969c = imageView2;
                imageView2.setBackgroundDrawable(drawable);
                viewGroup.addView(this.f397969c, new RelativeLayout.LayoutParams(-2, -2));
                this.f397969c.setVisibility(8);
                this.f397968b.setOnTouchListener(arkAppView);
            }
            if (this.f397970d == null) {
                ImageView imageView3 = new ImageView(arkAppView.getContext());
                this.f397970d = imageView3;
                imageView3.setBackgroundDrawable(drawable2);
                viewGroup.addView(this.f397970d, new RelativeLayout.LayoutParams(-2, -2));
                this.f397970d.setVisibility(8);
                this.f397970d.setOnTouchListener(arkAppView);
            }
        }
        b(this.f397968b);
        b(this.f397969c);
        b(this.f397970d);
    }

    @Override // com.tencent.ark.ArkViewImplement.InputCallback
    public void onHideMenu(View view) {
        BubblePopupWindow bubblePopupWindow = this.f397967a;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
            this.f397967a = null;
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.InputCallback
    public void onSelectChanged(View view, int i3, int i16, int i17, int i18) {
        ArkAppView arkAppView = this.f397972f.get();
        if (arkAppView == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) arkAppView.getParent();
        ViewGroup viewGroup2 = this.f397971e;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        }
        if (viewGroup == null) {
            return;
        }
        if (i3 > 0 && i16 > 0 && (i3 < i17 || i16 < i18)) {
            int width = this.f397968b.getWidth();
            if (width <= 0) {
                width = arkAppView.getResources().getDrawable(R.drawable.c_c).getIntrinsicWidth();
            }
            d(this.f397968b, (arkAppView.getLeft() + i3) - width, arkAppView.getTop() + i16);
        } else {
            b(this.f397968b);
        }
        if (i17 > 0 && i18 > 0 && (i3 < i17 || i16 < i18)) {
            d(this.f397969c, arkAppView.getLeft() + i17, arkAppView.getTop() + i18);
        } else {
            b(this.f397969c);
        }
        if (i3 > 0 && i16 > 0 && i3 == i17 && i16 == i18) {
            int width2 = this.f397970d.getWidth();
            if (width2 <= 0) {
                width2 = arkAppView.getResources().getDrawable(R.drawable.c_b).getIntrinsicWidth();
            }
            d(this.f397970d, (i17 + arkAppView.getLeft()) - (width2 / 2), i18 + arkAppView.getTop());
            return;
        }
        b(this.f397970d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ark.ArkViewImplement.InputCallback
    public void onShowMenu(View view, int i3, int i16, int i17, int i18) {
        ArkAppView arkAppView = this.f397972f.get();
        if (arkAppView == null) {
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f397967a;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
            this.f397967a = null;
        }
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        if (i18 == 2) {
            aVar.a(0, HardCodeUtil.qqStr(R.string.jop));
            aVar.a(1, HardCodeUtil.qqStr(R.string.jol));
            aVar.a(2, HardCodeUtil.qqStr(R.string.jom));
        } else if (i18 == 1) {
            aVar.a(0, HardCodeUtil.qqStr(R.string.joo));
            aVar.a(1, HardCodeUtil.qqStr(R.string.jok));
            aVar.a(2, HardCodeUtil.qqStr(R.string.jon));
        } else {
            aVar.a(0, HardCodeUtil.qqStr(R.string.joq));
        }
        this.f397967a = s.b(view, i3, i16, i17 + arkAppView.getResources().getDrawable(R.drawable.c_b).getIntrinsicHeight(), aVar, new ViewOnClickListenerC10284a(i18, (ArkViewImplement.ArkViewInterface) view));
    }
}
