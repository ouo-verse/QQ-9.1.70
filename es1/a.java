package es1;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends PopupWindow {

    /* renamed from: d, reason: collision with root package name */
    private static final int f397080d = bi.b(63);

    /* renamed from: e, reason: collision with root package name */
    private static final int f397081e = bi.b(71);

    /* renamed from: a, reason: collision with root package name */
    private View f397082a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f397083b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f397084c;

    /* compiled from: P */
    /* renamed from: es1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class ViewOnKeyListenerC10263a implements View.OnKeyListener {
        ViewOnKeyListenerC10263a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f397086d;

        b(View.OnClickListener onClickListener) {
            this.f397086d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View.OnClickListener onClickListener = this.f397086d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            a.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context) {
        super(context);
        b(context);
        setOutsideTouchable(true);
        setTouchable(true);
        getContentView().setOnKeyListener(new ViewOnKeyListenerC10263a());
    }

    private void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f8l, (ViewGroup) null);
        this.f397082a = inflate;
        this.f397083b = (ImageView) inflate.findViewById(R.id.icon);
        this.f397084c = (TextView) this.f397082a.findViewById(R.id.f165644x40);
        setBackgroundDrawable(new ColorDrawable(0));
        setContentView(this.f397082a);
    }

    public View a() {
        return this.f397083b;
    }

    public void c(boolean z16, View view, View.OnClickListener onClickListener) {
        if (z16) {
            this.f397083b.setImageDrawable(this.f397082a.getResources().getDrawable(R.drawable.guild_set_to_top));
            this.f397084c.setText(R.string.f155871io);
        } else {
            this.f397083b.setImageDrawable(this.f397082a.getResources().getDrawable(R.drawable.guild_set_cancel_top));
            this.f397084c.setText(R.string.f140880f6);
        }
        this.f397082a.setOnClickListener(new b(onClickListener));
        showAsDropDown(view, bi.b(3), ((-f397081e) - view.getHeight()) - bi.b(6));
    }
}
