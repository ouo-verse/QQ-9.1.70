package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.mobileqq.R;
import java.util.List;

/* loaded from: classes32.dex */
public class AEARCakeProvidewView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f62843d;

    /* renamed from: e, reason: collision with root package name */
    private View f62844e;

    /* renamed from: f, reason: collision with root package name */
    private AEARCakeMaterialAdapter f62845f;

    /* renamed from: h, reason: collision with root package name */
    private AEARCakePanel.g f62846h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f62847i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildLayoutPosition(view) != 0) {
                rect.left = 24;
            }
        }
    }

    public AEARCakeProvidewView(Context context, AEARCakePanel.g gVar) {
        super(context);
        this.f62846h = gVar;
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dkx, this);
        this.f62844e = inflate;
        this.f62843d = (RecyclerView) inflate.findViewById(R.id.rtg);
        this.f62843d.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f62847i = (TextView) this.f62844e.findViewById(R.id.rw7);
        this.f62845f = new AEARCakeMaterialAdapter(context, this.f62846h);
        AEARCakeMaterialManager.i().u(this.f62845f);
        this.f62843d.setAdapter(this.f62845f);
        this.f62843d.addItemDecoration(new a());
    }

    public void b() {
        AEARCakeMaterialManager.i().u(null);
    }

    public void c(List<com.tencent.aelight.camera.ae.data.a> list, int i3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).b() != null) {
                ms.a.a("AEARCakeProvidewView", "arcake : categories.get(0).materialList :" + list.get(i16).b().name);
            }
        }
        if (this.f62847i != null) {
            this.f62847i.setText(getContext().getString(R.string.y7v) + String.valueOf(list.size()) + getContext().getString(R.string.y7w));
        }
        this.f62845f.y(list, i3);
    }
}
