package ly1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f415782d;

    /* renamed from: e, reason: collision with root package name */
    private List<b> f415783e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f415784f;

    public c(Context context, List<b> list) {
        this.f415782d = context;
        this.f415783e = list;
        this.f415784f = ResourcesCompat.getColorStateList(context.getResources(), R.color.guild_skin_content_text, context.getTheme());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f415783e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new WheelTextView(this.f415782d);
            view.setLayoutParams(new VerticalGallery.LayoutParams(-1, x.c(viewGroup.getContext(), 56.0f)));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
        }
        String b16 = this.f415783e.get(i3).b();
        WheelTextView wheelTextView = (WheelTextView) view;
        wheelTextView.setTextSize(17.0f);
        wheelTextView.setTextColor(this.f415784f);
        wheelTextView.setGravity(17);
        wheelTextView.setText(b16);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
