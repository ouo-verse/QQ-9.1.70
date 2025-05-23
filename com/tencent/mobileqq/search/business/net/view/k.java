package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.UfsLabel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends f {
    private ImageView X;

    public k(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    public static TextView v(Context context) {
        TextView textView = new TextView(context);
        textView.setId(View.generateViewId());
        textView.setSingleLine(true);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setMinWidth(w(context, 16));
        textView.setPadding(w(context, 8), w(context, 3), w(context, 8), w(context, 3));
        layoutParams.setMarginStart(w(context, 4));
        textView.setGravity(17);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private static int w(Context context, int i3) {
        return Math.round(i3 * context.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.f, com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View view = this.M;
        if (view != null) {
            this.X = (ImageView) view.findViewById(R.id.x1c);
        }
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void p(lo2.p pVar) {
        super.p(pVar);
        if (pVar == null) {
            return;
        }
        if (this.S != null && pVar.Y() != null && !pVar.Y().isEmpty()) {
            this.S.setVisibility(0);
            RecyclerView recyclerView = this.S;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
            ko2.a aVar = new ko2.a();
            this.U = aVar;
            this.S.setAdapter(aVar);
            this.U.setData(pVar.Y());
        } else {
            RecyclerView recyclerView2 = this.S;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(4);
                ko2.a aVar2 = this.U;
                if (aVar2 != null) {
                    aVar2.setData(new ArrayList());
                }
            }
        }
        ImageView imageView = this.X;
        if (imageView != null) {
            imageView.setImageResource(pVar.W());
            this.X.setVisibility(0);
        }
        if (b() != null) {
            CharSequence title = pVar.getTitle();
            String keyword = pVar.getKeyword();
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(keyword)) {
                Context context = b().getContext();
                float c16 = context.getResources().getDisplayMetrics().widthPixels - x.c(context, 30.0f);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(pVar.L);
                arrayList.add(pVar.N);
                title = SearchUtils.J(b(), c16, 1, title, arrayList, true, true, false);
            }
            b().setText(title);
        }
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int q(boolean z16) {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int r() {
        return 60;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int s() {
        return 76;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int t() {
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void u(lo2.p pVar) {
        super.u(pVar);
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = ViewUtils.dpToPx(6.0f);
            this.Q.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout2 = this.N;
        if (linearLayout2 != null) {
            linearLayout2.setPadding(ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(16.0f), 0);
            this.N.setGravity(0);
        }
        if (this.R != null && pVar.Z() != null && !pVar.Z().isEmpty()) {
            this.R.setVisibility(0);
            List<UfsLabel> Z = pVar.Z();
            int childCount = this.R.getChildCount();
            for (int i3 = 0; i3 < Z.size(); i3++) {
                TextView v3 = v(this.R.getContext());
                View childAt = this.R.getChildAt(i3);
                if (childAt == null) {
                    this.R.addView(v3);
                } else if (childAt.getVisibility() == 8) {
                    childAt.setVisibility(0);
                }
                ko2.b.k0(Z.get(i3), v3);
            }
            if (childCount > Z.size()) {
                for (int size = Z.size(); size < childCount; size++) {
                    this.R.getChildAt(size).setVisibility(8);
                }
            }
        }
    }
}
