package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import f61.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateContentItemLoverAchievementView extends IntimateContentItemBaseView {
    private RelativeLayout F;
    private TextView G;
    private RecyclerView H;
    private d I;
    private c J;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView.c
        public void a(View view, int i3, e.a aVar) {
            String str = FriendIntimateRelationshipConfProcessor.a().f202728x0;
            if (!TextUtils.isEmpty(str)) {
                IntimateContentItemLoverAchievementView.this.v();
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(IntimateContentItemLoverAchievementView.this.f179219d, str, 2064, null);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_couple_achievement", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends GridLayoutManager {
        b(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private interface c {
        void a(View view, int i3, e.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: m, reason: collision with root package name */
        private List<e.a> f179227m = new ArrayList();

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f179227m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            e eVar = (e) viewHolder;
            e.a aVar = this.f179227m.get(i3);
            eVar.itemView.setTag(aVar);
            if (!TextUtils.isEmpty(aVar.f397912b)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestHeight = eVar.E.getHeight();
                obtain.mRequestWidth = eVar.E.getWidth();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                eVar.E.setImageDrawable(URLDrawable.getDrawable(aVar.f397912b, obtain));
                eVar.E.setCornerRadiusAndMode(ViewUtils.dpToPx(7.0f), 1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            IntimateContentItemLoverAchievementView intimateContentItemLoverAchievementView = IntimateContentItemLoverAchievementView.this;
            return new e(LayoutInflater.from(intimateContentItemLoverAchievementView.f179219d).inflate(R.layout.f168212fd2, (ViewGroup) null));
        }

        public void setData(List<e.a> list) {
            if (list != null && list.size() > 0) {
                this.f179227m.clear();
                this.f179227m.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class e extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener {
        public RoundRectImageView E;

        public e(@NonNull View view) {
            super(view);
            this.E = (RoundRectImageView) view.findViewById(R.id.u__);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (IntimateContentItemLoverAchievementView.this.J != null) {
                IntimateContentItemLoverAchievementView.this.J.a(view, getLayoutPosition(), (e.a) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    public IntimateContentItemLoverAchievementView(Context context) {
        this(context, null);
    }

    private SpannableString u(String str, int i3, int i16) {
        try {
            SpannableString spannableString = new SpannableString(str);
            int i17 = i16 + i3;
            spannableString.setSpan(new StyleSpan(0), i3, i17, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(14.0f)), i3, i17, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f179219d, R.color.qui_common_text_secondary)), i3, i17, 33);
            return spannableString;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("IntimateContentItemLoverAchievementView", 2, "getUnBoldContent fail:" + e16.toString());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ReportController.o(null, "dc00898", "", "", "0X800B567", "0X800B567", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        boolean z16;
        f61.e eVar;
        ArrayList<e.a> arrayList;
        boolean z17 = FriendIntimateRelationshipConfProcessor.a().f202725u0;
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo != null && (eVar = intimateInfo.loveAchievementInfo) != null && (arrayList = eVar.f397910c) != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z17 || this.f179224m != 1 || !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.fcx, (ViewGroup) this, true);
        this.F = (RelativeLayout) inflate.findViewById(R.id.u_a);
        this.G = (TextView) inflate.findViewById(R.id.u_c);
        this.H = (RecyclerView) inflate.findViewById(R.id.u_b);
        this.F.setOnClickListener(this);
        this.F.setOnTouchListener(this);
        this.I = new d();
        this.H.setLayoutManager(new b(this.f179219d, 3));
        this.H.setAdapter(this.I);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        if (view.getId() == R.id.u_a) {
            String str = FriendIntimateRelationshipConfProcessor.a().f202728x0;
            if (!TextUtils.isEmpty(str)) {
                v();
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f179219d, str, 2064, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void d() {
        RecyclerView recyclerView = this.H;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(null);
            this.H.removeAllViews();
            this.H.setAdapter(null);
            this.H = null;
            removeAllViews();
        }
        super.d();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        f61.e eVar;
        ArrayList<e.a> arrayList;
        if (intimateInfo != null && (eVar = intimateInfo.loveAchievementInfo) != null && (arrayList = eVar.f397910c) != null && arrayList.size() > 0) {
            setVisibility(0);
            SpannableString u16 = u(String.format(this.f179219d.getResources().getString(R.string.f161041wn), Integer.valueOf(intimateInfo.loveAchievementInfo.f397909b), Integer.valueOf(intimateInfo.loveAchievementInfo.f397908a)), 0, 3);
            if (u16 != null) {
                this.G.setText(u16);
            }
            if (this.I != null) {
                if (intimateInfo.loveAchievementInfo.f397910c.size() > 3) {
                    this.I.setData(intimateInfo.loveAchievementInfo.f397910c.subList(0, 3));
                } else {
                    this.I.setData(intimateInfo.loveAchievementInfo.f397910c);
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X800B566", "0X800B566", 0, 0, "", "", "", "");
            return;
        }
        setVisibility(8);
    }

    public IntimateContentItemLoverAchievementView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntimateContentItemLoverAchievementView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = new a();
    }
}
