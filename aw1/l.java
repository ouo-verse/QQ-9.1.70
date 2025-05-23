package aw1;

import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;
import aw1.k;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends a<k.b> {

    /* renamed from: c, reason: collision with root package name */
    private TextView f27079c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f27080d;

    @Override // aw1.a
    public void b() {
        this.f27079c = (TextView) this.f27041a.findViewById(R.id.vu7);
        this.f27080d = (ImageView) this.f27041a.findViewById(R.id.vth);
    }

    @Override // aw1.a
    public int d() {
        return R.id.wuh;
    }

    @Override // aw1.a
    protected int e() {
        return R.layout.f6q;
    }

    @Override // aw1.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(k.b bVar) {
        String str = bVar.f27067c;
        if (bVar.a()) {
            str = this.f27041a.getContext().getResources().getString(R.string.f154371em) + APLogFileUtil.SEPARATOR_LOG + bVar.f27067c;
        }
        this.f27079c.setText(str);
        TextView textView = this.f27079c;
        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary));
        this.f27079c.getPaint().setFakeBoldText(false);
        if (bVar.f27065a.equals(String.valueOf(2)) || bVar.f27065a.equals(String.valueOf(5)) || bVar.f27065a.equals(String.valueOf(7)) || bVar.f27065a.equals(String.valueOf(4)) || bVar.a()) {
            this.f27079c.setTextColor(ColorStateList.valueOf(bVar.f27066b));
            this.f27079c.getPaint().setFakeBoldText(true);
        }
        this.f27080d.setImageTintList(ColorStateList.valueOf(bVar.f27066b));
    }
}
