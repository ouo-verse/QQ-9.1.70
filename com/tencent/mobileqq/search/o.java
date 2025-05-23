package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.OperationHotSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.o;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends BaseSearchEntryModel<View> {
    private Context F;
    private QQAppInterface G;
    private View H;
    private TextView I;
    private RoundCornerImageView J;
    private a K;
    private OperationHotSearchEntryDataModel L;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends RecyclerView.Adapter<b> {
        private boolean C;

        /* renamed from: m, reason: collision with root package name */
        private final List<OperationHotSearchEntryDataModel.OperationHotSearchItemData> f283573m = new ArrayList();

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f283573m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            bVar.q(this.f283573m.get(i3), i3);
            if (this.C) {
                bVar.itemView.setPadding(ViewUtils.dpToPx(16.0f), 0, ViewUtils.dpToPx(6.0f), 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new b(LayoutInflater.from(o.this.F).inflate(R.layout.gv6, viewGroup, false));
        }

        public void k0(List<OperationHotSearchEntryDataModel.OperationHotSearchItemData> list, boolean z16) {
            this.f283573m.clear();
            this.f283573m.addAll(list);
            this.C = z16;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends RecyclerView.ViewHolder {
        private final URLImageView E;
        private final TextView F;
        private final TextView G;
        private OperationHotSearchEntryDataModel.OperationHotSearchItemData H;

        public b(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.b.this.p(view2);
                }
            });
            this.E = (URLImageView) view.findViewById(R.id.icon);
            this.F = (TextView) view.findViewById(R.id.jfb);
            this.G = (TextView) view.findViewById(R.id.f166942ja3);
        }

        private void m() {
            if (TextUtils.isEmpty(this.H.serialNumUrl)) {
                return;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.qui_common_fill_standard_primary_bg_corner_4);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            this.E.setImageDrawable(URLDrawable.getDrawable(this.H.serialNumUrl, obtain));
        }

        private void o() {
            if (!TextUtils.isEmpty(this.H.tagText) && !TextUtils.isEmpty(this.H.tagColor) && !TextUtils.isEmpty(this.H.tagBgColor)) {
                try {
                    int parseColor = Color.parseColor(this.H.tagColor);
                    int parseColor2 = Color.parseColor(this.H.tagBgColor);
                    this.G.setVisibility(0);
                    this.G.setText(this.H.tagText);
                    this.G.setTextColor(parseColor);
                    this.G.setBackground(com.tencent.biz.qqcircle.immersive.views.search.util.ad.f(parseColor2, 3, 17, 17));
                    return;
                } catch (IllegalArgumentException e16) {
                    QLog.w("QQSearch.Local.entry.OperationHotSearchEntryModel", 1, e16.getMessage(), e16);
                    return;
                }
            }
            this.G.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.H.jumpUrl)) {
                SearchUtils.Q0(o.this.G, o.this.F, this.H.jumpUrl);
            }
            EventCollector.getInstance().onViewClicked(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        public void q(OperationHotSearchEntryDataModel.OperationHotSearchItemData operationHotSearchItemData, int i3) {
            if (operationHotSearchItemData == null) {
                return;
            }
            this.H = operationHotSearchItemData;
            this.F.setText(operationHotSearchItemData.word);
            StringBuilder sb5 = new StringBuilder();
            int i16 = i3 + 1;
            sb5.append(i16);
            sb5.append(operationHotSearchItemData.word);
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(operationHotSearchItemData.jumpUrl)) {
                AccessibilityUtil.c(this.F, sb6, Button.class.getName());
            } else {
                AccessibilityUtil.c(this.F, sb6, TextView.class.getName());
            }
            m();
            o();
            com.tencent.mobileqq.search.util.u.s(this.itemView, operationHotSearchItemData.word, operationHotSearchItemData.hotSearchTextId, operationHotSearchItemData.isManualOperation, operationHotSearchItemData.tagText, i16, operationHotSearchItemData.hashCode());
        }
    }

    public o(int i3, int i16) {
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

    private void D() {
        if (TextUtils.isEmpty(this.L.F)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = this.F.getDrawable(R.drawable.kbl);
        obtain.mLoadingDrawable = this.F.getDrawable(R.drawable.kbl);
        this.J.setImageDrawable(URLDrawable.getDrawable(this.L.F, obtain));
        this.J.setCorner(ViewUtils.dpToPx(4.0f));
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.this.E(view);
            }
        });
        AccessibilityUtil.n(this.J, false);
        this.J.getLayoutParams().width = Math.min((int) (ViewUtils.dpToPx((this.L.D.size() * 32) - 12) * 0.75f), (ViewUtils.getScreenWidth() / 2) - ViewUtils.dpToPx(16.0f));
        com.tencent.mobileqq.search.util.u.n(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(this.L.H)) {
            SearchUtils.Q0(this.G, this.F, this.L.H);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        p(new OperationHotSearchEntryDataModel(12, this.mTabType));
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        this.F = context;
        C(qQAppInterface);
        if (this.G == null) {
            QLog.w("QQSearch.Local.entry.OperationHotSearchEntryModel", 1, "#onCreateView: app is null");
            return new View(context);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.gv7, (ViewGroup) null);
        this.H = inflate;
        inflate.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) this.H.findViewById(R.id.eap);
        this.I = (TextView) this.H.findViewById(R.id.title);
        this.J = (RoundCornerImageView) this.H.findViewById(R.id.df9);
        a aVar = new a();
        this.K = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setOverScrollMode(2);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.H, false);
            AccessibilityUtil.n(recyclerView, false);
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    /* renamed from: y */
    public void S(SearchEntryDataModel searchEntryDataModel) {
        if (this.H != null && (searchEntryDataModel instanceof OperationHotSearchEntryDataModel)) {
            OperationHotSearchEntryDataModel operationHotSearchEntryDataModel = (OperationHotSearchEntryDataModel) searchEntryDataModel;
            this.L = operationHotSearchEntryDataModel;
            if (operationHotSearchEntryDataModel.D.isEmpty()) {
                this.H.setVisibility(8);
                QLog.w("QQSearch.Local.entry.OperationHotSearchEntryModel", 1, "#updateData: no data");
                return;
            }
            this.H.setVisibility(0);
            QLog.i("QQSearch.Local.entry.OperationHotSearchEntryModel", 1, "#updateData: title=" + this.L.E + ", item count=" + this.L.D.size());
            if (!TextUtils.isEmpty(this.L.E)) {
                this.I.setText(this.L.E);
                w(this.L.E);
            }
            D();
            this.K.k0(this.L.D, !TextUtils.isEmpty(r0.F));
            com.tencent.mobileqq.search.util.u.t(this.H);
        }
    }
}
