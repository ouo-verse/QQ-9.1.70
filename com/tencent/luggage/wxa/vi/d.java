package com.tencent.luggage.wxa.vi;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MMBottomSheet f143500a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f143501b;

        public a(MMBottomSheet mMBottomSheet, b bVar) {
            this.f143500a = mMBottomSheet;
            this.f143501b = bVar;
        }

        @Override // com.tencent.luggage.wxa.vi.d.b
        public void a(View view, int i3) {
            if (this.f143500a.isShowing()) {
                this.f143500a.tryHide();
            }
            this.f143501b.a(view, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        public final List f143502a;

        /* renamed from: b, reason: collision with root package name */
        public final b f143503b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f143504a;

            public a(int i3) {
                this.f143504a = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f143503b != null) {
                    c.this.f143503b.a(view, this.f143504a);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f143506a;

            public b(View view) {
                super(view);
            }
        }

        public c(List list, b bVar) {
            this.f143502a = new ArrayList(list);
            this.f143503b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f143502a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dyj, viewGroup, false);
            b bVar = new b(inflate);
            bVar.f143506a = (TextView) inflate.findViewById(R.id.title);
            return bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            bVar.f143506a.setText((CharSequence) this.f143502a.get(i3));
            bVar.f143506a.setOnClickListener(new a(i3));
        }
    }

    public static void a(Context context, boolean z16, List list, String str, com.tencent.luggage.wxa.wj.c cVar, b bVar) {
        MMBottomSheet mMBottomSheet = new MMBottomSheet(context, false, 0);
        if (cVar.shouldInLargeScreenCompatMode()) {
            mMBottomSheet.setNewLandscapeMaxWidth((int) (cVar.getVDisplayMetrics().widthPixels * cVar.getScale()));
        }
        mMBottomSheet.hideStatusBar(z16);
        mMBottomSheet.hideNavigationFullScreen(z16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dyi, (ViewGroup) null);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) inflate.findViewById(android.R.id.title)).setText(str);
        }
        mMBottomSheet.setFooterView(a(context, list, new a(mMBottomSheet, bVar)));
        mMBottomSheet.setTitleView(inflate, true);
        mMBottomSheet.tryShow();
    }

    public static View a(Context context, List list, b bVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dyh, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.vsx);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(new c(list, bVar));
        return inflate;
    }
}
