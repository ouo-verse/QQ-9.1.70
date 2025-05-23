package if0;

import WEISHI_USER_GROWTH.WEISHI$stMetaFeed;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstorysave.widget.StoryCoverView;
import com.tencent.biz.videostory.widget.view.MineWSPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    private List<c> f407566d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final QBaseActivity f407567e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f407568f;

    /* renamed from: h, reason: collision with root package name */
    private MineWSPanel.c f407569h;

    /* compiled from: P */
    /* renamed from: if0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class ViewOnClickListenerC10523a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f407570d;

        ViewOnClickListenerC10523a(c cVar) {
            this.f407570d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!hf0.a.a(a.class.getName() + "clickFeed")) {
                a.this.f407569h.a(this.f407570d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        final ImageView f407572d;

        /* renamed from: e, reason: collision with root package name */
        final StoryCoverView f407573e;

        b(View view) {
            super(view);
            this.f407572d = (ImageView) view.findViewById(R.id.d_k);
            this.f407573e = (StoryCoverView) view.findViewById(R.id.bbd);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        int f407574a;

        /* renamed from: b, reason: collision with root package name */
        WEISHI$stMetaFeed f407575b;

        c(WEISHI$stMetaFeed wEISHI$stMetaFeed, int i3) {
            this.f407575b = wEISHI$stMetaFeed;
            this.f407574a = i3;
        }

        public int a() {
            return this.f407574a;
        }
    }

    public a(QBaseActivity qBaseActivity) {
        this.f407567e = qBaseActivity;
    }

    private void q(ImageView imageView, String str) {
        String e16 = pd0.c.e(str);
        if (!e16.equals(imageView.getTag())) {
            UIUtils.q(imageView, e16, 68, 90, 4, UIUtils.f94442e, "QQStoryMemory");
        }
    }

    private void r(RecyclerView.ViewHolder viewHolder, WEISHI$stMetaFeed wEISHI$stMetaFeed, int i3) {
        q(((b) viewHolder).f407572d, wEISHI$stMetaFeed.material_thumburl.get());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.f407566d;
        if (list != null && list.size() > 0) {
            if (this.f407566d.size() > 3) {
                return 3;
            }
            return this.f407566d.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f407566d.get(i3).f407574a;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int adapterPosition = viewHolder.getAdapterPosition();
        c cVar = this.f407566d.get(adapterPosition);
        int i16 = cVar.f407574a;
        WEISHI$stMetaFeed wEISHI$stMetaFeed = cVar.f407575b;
        if (i16 != 100) {
            if (i16 == 101 && i16 == 101) {
                r(viewHolder, wEISHI$stMetaFeed, adapterPosition);
            }
        } else if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            ((b) viewHolder).f407572d.setImageResource(R.drawable.gyx);
        } else {
            ((b) viewHolder).f407572d.setImageResource(R.drawable.f5j);
        }
        viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC10523a(cVar));
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i3 != 100 && i3 != 101) {
            return null;
        }
        return new b(from.inflate(R.layout.f168847b10, viewGroup, false));
    }

    public void s(List<WEISHI$stMetaFeed> list, boolean z16) {
        int i3;
        this.f407566d.clear();
        this.f407568f = z16;
        if (list != null && list.size() > 0) {
            if (z16) {
                this.f407566d.add(new c(null, 100));
                i3 = 2;
            } else {
                i3 = 3;
            }
            int size = list.size();
            if (size < i3) {
                i3 = size;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                this.f407566d.add(new c(list.get(i16), 101));
            }
        }
        notifyDataSetChanged();
    }

    public void t(MineWSPanel.c cVar) {
        this.f407569h = cVar;
    }
}
