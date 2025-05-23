package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.business.contact.fragment.SpecialCareSearchFragment;
import com.tencent.mobileqq.search.e;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.mobileqq.search.model.GuessSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends BaseSearchEntryModel<View> implements sn2.d {
    private Context F;
    private QQAppInterface G;
    private View H;
    private TextView I;
    private RecyclerView J;
    private View K;
    private b L;
    private GuessSearchEntryDataModel M;
    private a N;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class b extends RecyclerView.Adapter<c> {

        /* renamed from: m, reason: collision with root package name */
        private final List<GuessSearchEntryDataModel.GuessSearchItem> f283122m = new ArrayList();
        private final Comparator<GuessSearchEntryDataModel.GuessSearchItem> C = new Comparator() { // from class: com.tencent.mobileqq.search.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int j06;
                j06 = e.b.j0((GuessSearchEntryDataModel.GuessSearchItem) obj, (GuessSearchEntryDataModel.GuessSearchItem) obj2);
                return j06;
            }
        };

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int j0(GuessSearchEntryDataModel.GuessSearchItem guessSearchItem, GuessSearchEntryDataModel.GuessSearchItem guessSearchItem2) {
            if (guessSearchItem == guessSearchItem2) {
                return 0;
            }
            if (guessSearchItem != null && guessSearchItem2 != null && TextUtils.equals(guessSearchItem.word, guessSearchItem2.word) && TextUtils.equals(guessSearchItem.extension, guessSearchItem2.extension) && TextUtils.equals(guessSearchItem.reportData, guessSearchItem2.reportData)) {
                return 0;
            }
            return -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f283122m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull c cVar, int i3) {
            cVar.l(i3, this.f283122m.get(i3));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168779gv4, viewGroup, false));
        }

        public void refresh(List<GuessSearchEntryDataModel.GuessSearchItem> list) {
            if (list != null && !list.isEmpty()) {
                if (SearchUtil.g(this.f283122m, list, this.C)) {
                    QLog.i("QQSearch.Local.entry.GuessSearchEntryModel", 1, "#updateData: same data, no update");
                    return;
                } else {
                    this.f283122m.clear();
                    this.f283122m.addAll(list);
                }
            } else {
                this.f283122m.clear();
                QLog.w("QQSearch.Local.entry.GuessSearchEntryModel", 1, "#updateData: empty data. It looks like a server bug");
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView E;
        private final TextView F;
        private GuessSearchEntryDataModel.GuessSearchItem G;

        public c(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.jfb);
            this.F = (TextView) view.findViewById(R.id.f166942ja3);
            view.setOnClickListener(this);
        }

        private boolean m(GuessSearchEntryDataModel.GuessSearchItem guessSearchItem) {
            if (guessSearchItem != null && !TextUtils.isEmpty(guessSearchItem.tagText) && !TextUtils.isEmpty(guessSearchItem.tagColor) && !TextUtils.isEmpty(guessSearchItem.tagBgColor)) {
                return true;
            }
            return false;
        }

        private void o() {
            if (!m(this.G)) {
                this.F.setVisibility(8);
                return;
            }
            try {
                int parseColor = Color.parseColor(this.G.tagColor);
                int parseColor2 = Color.parseColor(this.G.tagBgColor);
                this.F.setVisibility(0);
                this.F.setText(this.G.tagText);
                this.F.setTextColor(parseColor);
                this.F.setBackground(com.tencent.biz.qqcircle.immersive.views.search.util.ad.f(parseColor2, 3, 16, 16));
            } catch (IllegalArgumentException e16) {
                QLog.w("QQSearch.Local.entry.GuessSearchEntryModel", 1, e16.getMessage(), e16);
            }
        }

        public void l(int i3, GuessSearchEntryDataModel.GuessSearchItem guessSearchItem) {
            this.G = guessSearchItem;
            this.E.setText(guessSearchItem.word);
            o();
            com.tencent.mobileqq.search.util.u.e(this.itemView, i3, guessSearchItem.word, guessSearchItem.tagText, guessSearchItem.reportData, guessSearchItem.hashCode(), guessSearchItem.type);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(this.itemView);
            GuessSearchEntryDataModel.GuessSearchItem guessSearchItem = this.G;
            if (guessSearchItem != null) {
                int i3 = guessSearchItem.type;
                if (i3 == 2) {
                    FTSEntitySearchFragment.wh(e.this.F, e.this.F.getResources().getString(R.string.f214065rw), 2, 1, 1, null, null, e.this.F.getResources().getString(R.string.f214065rw));
                } else if (i3 == 3) {
                    SpecialCareSearchFragment.INSTANCE.a(e.this.F, 1, null);
                } else if (!TextUtils.isEmpty(guessSearchItem.jumpUrl)) {
                    SearchUtils.Q0(e.this.G, e.this.F, SearchUtils.g(this.G.jumpUrl));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class d extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private final int f283123d;

        d(Context context) {
            this.f283123d = com.tencent.mobileqq.util.x.c(context, 8.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.left = this.f283123d;
        }
    }

    public e(int i3, int i16) {
        super(i3, i16);
    }

    private void C(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            Context context = this.F;
            if (context instanceof AppActivity) {
                AppRuntime appRuntime = ((AppActivity) context).getAppRuntime();
                if (appRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) appRuntime;
                }
            }
        }
        this.G = qQAppInterface;
    }

    private Drawable D() {
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{SearchUtil.d(this.H.getResources().getColor(R.color.qui_common_fill_light_primary), this.H.getResources().getColor(R.color.qui_common_bg_bottom_standard)), 0});
    }

    @Override // sn2.d
    public View getView() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        p(new GuessSearchEntryDataModel(11, this.mTabType));
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        this.F = context;
        C(qQAppInterface);
        if (this.G == null) {
            QLog.w("QQSearch.Local.entry.GuessSearchEntryModel", 1, "#onCreateView: app is null");
            return new View(context);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.gv5, (ViewGroup) null);
        this.H = inflate;
        inflate.setVisibility(8);
        this.I = (TextView) this.H.findViewById(R.id.title);
        this.K = this.H.findViewById(R.id.enc);
        RecyclerView recyclerView = (RecyclerView) this.H.findViewById(R.id.eap);
        this.J = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.H.getContext(), 0, false));
        b bVar = new b();
        this.L = bVar;
        this.J.setAdapter(bVar);
        this.J.setItemAnimator(null);
        RecyclerView recyclerView2 = this.J;
        recyclerView2.addItemDecoration(new d(recyclerView2.getContext()));
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void t() {
        az.f(this.H, this.N);
        super.t();
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    /* renamed from: y */
    public void S(SearchEntryDataModel searchEntryDataModel) {
        if (this.H != null && (searchEntryDataModel instanceof GuessSearchEntryDataModel)) {
            GuessSearchEntryDataModel guessSearchEntryDataModel = (GuessSearchEntryDataModel) searchEntryDataModel;
            this.M = guessSearchEntryDataModel;
            if (guessSearchEntryDataModel.o().isEmpty()) {
                this.H.setVisibility(8);
                QLog.w("QQSearch.Local.entry.GuessSearchEntryModel", 1, "#updateData: no data");
                return;
            }
            this.H.setVisibility(0);
            QLog.i("QQSearch.Local.entry.GuessSearchEntryModel", 1, "#updateData: title=" + this.M.p() + ", item count=" + this.M.o().size());
            if (!TextUtils.isEmpty(this.M.p())) {
                this.I.setText(this.M.p());
                w(this.M.p());
            }
            this.L.refresh(this.M.o());
            this.J.scrollToPosition(0);
            if (this.N == null) {
                this.N = new a();
            }
            if (this.K.getBackground() == null) {
                this.K.setBackground(D());
            }
            az.d(this.H, this.N);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class a implements TopGestureLayout.InterceptTouchEventListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f283120a;

        a() {
        }

        private boolean a(View view, MotionEvent motionEvent) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int width = view.getWidth() + i3;
            int i16 = iArr[1];
            int height = view.getHeight() + i16;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (rawX <= i3 || rawX >= width || rawY < i16 || rawY >= height) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public boolean OnInterceptTouchEvent(MotionEvent motionEvent) {
            if (e.this.H == null) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                this.f283120a = false;
            }
            if (action == 0) {
                this.f283120a = a(e.this.H, motionEvent);
            }
            return !this.f283120a;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public void OnDispatchTouchEvent(MotionEvent motionEvent) {
        }
    }
}
