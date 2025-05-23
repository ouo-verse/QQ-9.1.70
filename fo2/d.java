package fo2;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.utils.ViewUtils;
import sn2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends f {
    private View C;

    /* renamed from: i, reason: collision with root package name */
    private TextView f400171i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f400172m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public d(ViewGroup viewGroup, boolean z16, boolean z17) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168018p4, viewGroup, false);
        this.f433995d = inflate;
        inflate.setOnTouchListener(new a());
        TextView textView = (TextView) this.f433995d.findViewById(R.id.title);
        this.f400171i = textView;
        textView.setVisibility(0);
        TextView textView2 = (TextView) this.f433995d.findViewById(R.id.ezq);
        this.f400172m = textView2;
        if (z17) {
            textView2.setVisibility(0);
        }
        View findViewById = this.f433995d.findViewById(R.id.bnd);
        this.C = findViewById;
        if (z16) {
            findViewById.setVisibility(0);
        }
        if (aq.a()) {
            this.f433995d.findViewById(R.id.title_container).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            this.f433995d.findViewById(R.id.acn).setVisibility(0);
            this.f400171i.setTextColor(viewGroup.getResources().getColorStateList(R.color.qui_common_text_primary));
            this.f400172m.setTextColor(viewGroup.getResources().getColorStateList(R.color.qui_common_text_secondary));
            Drawable drawable = viewGroup.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01);
            drawable.setBounds(0, 0, ViewUtils.dip2px(15.0f), ViewUtils.dip2px(15.0f));
            this.f400172m.setCompoundDrawablePadding(ViewUtils.dip2px(1.0f));
            this.f400172m.setCompoundDrawables(null, null, drawable, null);
        }
    }

    public void a(boolean z16) {
        int i3;
        View view = this.C;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @Override // sn2.f, sn2.b
    public TextView b() {
        return this.f400171i;
    }

    @Override // sn2.f, sn2.b
    public TextView getMoreView() {
        return this.f400172m;
    }
}
