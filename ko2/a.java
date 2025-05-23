package ko2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends RecyclerView.Adapter<C10673a> {
    private static final int C = ViewUtils.dpToPx(16.0f);
    private static final int D = ViewUtils.dpToPx(2.0f);

    /* renamed from: m, reason: collision with root package name */
    private final List<String> f412738m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ko2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C10673a extends RecyclerView.ViewHolder {
        URLImageView E;

        public C10673a(@NonNull View view) {
            super(view);
            if (view instanceof URLImageView) {
                this.E = (URLImageView) view;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f412738m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull C10673a c10673a, int i3) {
        URLImageView uRLImageView = c10673a.E;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(this.f412738m.get(i3), (URLDrawable.URLDrawableOptions) null));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C10673a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        URLImageView uRLImageView = new URLImageView(viewGroup.getContext());
        int i16 = C;
        int i17 = D;
        uRLImageView.setLayoutParams(new LinearLayout.LayoutParams(i16 + i17, i16));
        uRLImageView.setPadding(i17, 0, 0, 0);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new C10673a(uRLImageView);
    }

    public void setData(List<String> list) {
        this.f412738m.clear();
        this.f412738m.addAll(list);
        notifyDataSetChanged();
    }
}
