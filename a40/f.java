package a40;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumEntranceView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int K = cx.a(130.0f);
    private static final int L = cx.a(92.0f);
    private static final int M = cx.a(52.0f);
    private static final int N = cx.a(30.0f);
    private static final int P = cx.a(6.0f);
    private static final int Q = cx.a(28.0f);
    private static final int R = cx.a(44.0f);
    private static final int S = cx.a(35.0f);
    private Context C;
    private LayoutInflater D;
    private c E;
    private int G;
    private int H;
    private View I;
    private boolean J;

    /* renamed from: m, reason: collision with root package name */
    private List<b40.a> f25469m = new ArrayList();
    private int F = (cx.g() - QFSPersonalAlbumEntranceView.D) - QFSPersonalAlbumEntranceView.E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public Button E;
        public ImageView F;
        public ImageView G;

        public a(@NonNull View view) {
            super(view);
            this.E = (Button) view.findViewById(R.id.u0m);
            this.F = (ImageView) view.findViewById(R.id.u0o);
            this.G = (ImageView) view.findViewById(R.id.u0p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public Button E;
        public RoundCornerImageView F;
        public ImageView G;
        public TextView H;
        public TextView I;

        public b(@NonNull View view) {
            super(view);
            this.F = (RoundCornerImageView) view.findViewById(R.id.f33640x0);
            this.E = (Button) view.findViewById(R.id.f33650x1);
            this.G = (ImageView) view.findViewById(R.id.f33620wy);
            this.H = (TextView) view.findViewById(R.id.f33660x2);
            this.I = (TextView) view.findViewById(R.id.f33630wz);
        }

        public static void l(RoundCornerImageView roundCornerImageView, b40.a aVar) {
            if (aVar.c() != null && !aVar.c().isEmpty()) {
                Long k3 = aVar.k();
                roundCornerImageView.setCorner(cx.a(4.0f));
                String c16 = aVar.c();
                if (c16.isEmpty()) {
                    roundCornerImageView.setImageDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw));
                    return;
                }
                Long l3 = 0L;
                if (roundCornerImageView.getTag(R.id.f33640x0) instanceof Long) {
                    l3 = (Long) roundCornerImageView.getTag(R.id.f33640x0);
                }
                roundCornerImageView.setTag(R.id.f33640x0, k3);
                if (l3.longValue() == 0 || !l3.equals(k3)) {
                    com.tencent.biz.qqcircle.utils.j.b(roundCornerImageView, c16, roundCornerImageView.getLayoutParams().width, roundCornerImageView.getLayoutParams().height, com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw));
                    return;
                }
                return;
            }
            QLog.e("QFSPersonalAlbumEntranceAdapter", 1, "draft album's cover is empty!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b(b40.a aVar);

        void c(b40.a aVar, boolean z16);

        void d();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    static class d extends RecyclerView.ViewHolder {
        public d(@NonNull View view) {
            super(view);
        }
    }

    public f(Context context) {
        this.C = context;
        LayoutInflater from = LayoutInflater.from(this.C);
        this.D = from;
        this.I = from.inflate(R.layout.glb, (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(b40.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c cVar = this.E;
        if (cVar != null) {
            cVar.c(aVar, true);
            c40.b.c(aVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(b40.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c cVar = this.E;
        if (cVar != null) {
            cVar.b(aVar);
            c40.b.d(aVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c cVar = this.E;
        if (cVar != null) {
            cVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void D0(a aVar, final b40.a aVar2) {
        aVar.F.setVisibility(0);
        aVar.G.setVisibility(0);
        aVar.E.setText(t0(aVar2.m()));
        aVar.F.setBackgroundResource(R.drawable.qui_video_collection);
        aVar.E.setOnClickListener(new View.OnClickListener() { // from class: a40.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.y0(aVar2, view);
            }
        });
    }

    private void E0(a aVar) {
        aVar.F.setVisibility(0);
        aVar.G.setVisibility(8);
        aVar.E.setText("  " + this.C.getResources().getString(R.string.f181413dp));
        aVar.F.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_add));
        aVar.E.setOnClickListener(new View.OnClickListener() { // from class: a40.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.z0(view);
            }
        });
    }

    private void F0(b bVar, final b40.a aVar) {
        bVar.H.setText(aVar.m());
        bVar.I.setText(this.C.getResources().getString(R.string.f188233w5, Integer.valueOf(aVar.g())));
        b.l(bVar.F, aVar);
        bVar.E.setOnClickListener(new View.OnClickListener() { // from class: a40.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.A0(aVar, view);
            }
        });
        bVar.G.setOnClickListener(new View.OnClickListener() { // from class: a40.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.B0(aVar, view);
            }
        });
    }

    private void H0(List<b40.a> list) {
        this.f25469m.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 5) {
            for (int i3 = 0; i3 < 6; i3++) {
                this.f25469m.add(list.get(i3));
            }
            return;
        }
        this.f25469m.addAll(list);
    }

    private void I0(a aVar) {
        Button button = aVar.E;
        button.setPadding(Q, button.getPaddingTop(), R, aVar.E.getPaddingBottom());
        aVar.E.setTextSize(12.0f);
        aVar.E.getLayoutParams().height = S;
    }

    private void n0() {
        if (this.f25469m.size() > 5) {
            if (this.f25469m.get(r0.size() - 1).f() == null) {
                this.f25469m.remove(r0.size() - 1);
            }
            this.f25469m.add(new b40.a());
        }
    }

    private void o0(View view, b40.a aVar) {
        Map<String, Object> a16 = c40.b.a(aVar);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_ALBUM_ENTRANCE);
        VideoReport.setElementParams(view, a16);
    }

    private void p0(View view, int i3, b40.a aVar) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (i3 == 0 && aVar.f() == null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CREATE_ICON);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CREATE_ICON);
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_ALBUM_ENTRANCE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, aVar.k());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_ALBUM_ENTRANCE + "_" + aVar.k());
    }

    private void q0(List<b40.a> list) {
        if (list != null && list.size() > 0) {
            this.G = 0;
            int i3 = 0;
            for (int i16 = 0; i16 < list.size() && i16 != 5; i16++) {
                if (list.get(i16).f() != null) {
                    i3 += x0(list.get(i16).m());
                    if (list.size() == 1) {
                        this.G = this.F - i3;
                    } else {
                        this.G = (this.F - i3) - (QFSPersonalAlbumEntranceView.F * 2);
                    }
                }
            }
        }
    }

    private void r0(List<b40.a> list) {
        int length;
        this.H = 0;
        if (list != null && list.size() > 0) {
            for (b40.a aVar : list) {
                if (aVar.f() != null) {
                    length = aVar.m().length();
                } else {
                    length = this.C.getResources().getString(R.string.f181413dp).length() + 0;
                }
                this.H += length;
            }
        }
    }

    private void s0() {
        this.J = false;
        for (b40.a aVar : this.f25469m) {
            if (aVar != null && aVar.f() != null && aVar.f().album.status.get() == 2) {
                this.J = true;
                return;
            }
        }
    }

    private String t0(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 12) {
            return str.substring(0, 11) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    private void u0(a aVar, int i3) {
        aVar.E.getLayoutParams().width = i3;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) aVar.F.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) aVar.E.getLayoutParams();
        Button button = aVar.E;
        button.setPadding(((ViewGroup.MarginLayoutParams) layoutParams).width, button.getPaddingTop(), 0, aVar.E.getPaddingBottom());
        aVar.E.setGravity(17);
        layoutParams.setMarginStart(((((ViewGroup.MarginLayoutParams) layoutParams2).width / 2) - (((int) aVar.E.getPaint().measureText(this.C.getResources().getString(R.string.f181413dp))) / 2)) - cx.a(8.0f));
    }

    private void v0(b bVar) {
        if (this.f25469m.size() == 2) {
            ViewGroup.LayoutParams layoutParams = bVar.itemView.getLayoutParams();
            bVar.itemView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = bVar.itemView.getMeasuredWidth();
            int i3 = (this.F - QFSPersonalAlbumEntranceView.F) - L;
            layoutParams.width = i3;
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) bVar.E.getLayoutParams();
            layoutParams2.setMarginStart(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + (i3 - measuredWidth));
        }
    }

    private void w0(a aVar, b40.a aVar2, int i3) {
        I0(aVar);
        if (this.f25469m.size() == 1 && aVar2.f() == null) {
            u0(aVar, this.F);
            return;
        }
        if (this.f25469m.size() == 2) {
            ViewGroup.LayoutParams layoutParams = aVar.E.getLayoutParams();
            layoutParams.width = (this.F - QFSPersonalAlbumEntranceView.F) / 2;
            if (i3 == 0 && aVar2.f() == null) {
                u0(aVar, layoutParams.width);
                return;
            }
            return;
        }
        if (i3 == 0 && aVar2.f() == null) {
            int i16 = K;
            u0(aVar, i16);
            this.G -= i16;
        } else if (this.G > 0) {
            aVar.E.getLayoutParams().width = x0(aVar2.m()) + ((this.G * aVar2.m().length()) / this.H);
        }
    }

    private int x0(String str) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ((Button) this.I.findViewById(R.id.u0m)).setText(str);
        this.I.measure(makeMeasureSpec, makeMeasureSpec2);
        return this.I.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(b40.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c cVar = this.E;
        if (cVar != null) {
            cVar.c(aVar, false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c cVar = this.E;
        if (cVar != null) {
            cVar.d();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void J0(c cVar) {
        this.E = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<b40.a> list = this.f25469m;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        b40.a aVar = this.f25469m.get(i3);
        if (aVar != null && aVar.f() != null && aVar.f().album.status.get() == 2) {
            return 2;
        }
        if (this.f25469m.size() > 5 && i3 == this.f25469m.size() - 1) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        int itemViewType = getItemViewType(i3);
        b40.a aVar = this.f25469m.get(i3);
        if (this.J) {
            if (itemViewType == 2) {
                b bVar = (b) viewHolder;
                v0(bVar);
                F0(bVar, aVar);
                o0(bVar.itemView, aVar);
                return;
            }
            if (i3 == 0 && aVar.f() == null) {
                a aVar2 = (a) viewHolder;
                ViewGroup.LayoutParams layoutParams = aVar2.E.getLayoutParams();
                layoutParams.height = M;
                layoutParams.width = L;
                Button button = aVar2.E;
                button.setPadding(N, button.getPaddingTop(), P, aVar2.E.getPaddingBottom());
                aVar2.E.setTextSize(12.0f);
                E0(aVar2);
                p0(aVar2.E, i3, aVar);
                return;
            }
            return;
        }
        if (itemViewType == 1) {
            ((d) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: a40.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.this.C0(view);
                }
            });
            return;
        }
        if (itemViewType == 2) {
            b bVar2 = (b) viewHolder;
            F0(bVar2, aVar);
            o0(bVar2.itemView, aVar);
            return;
        }
        a aVar3 = (a) viewHolder;
        w0(aVar3, aVar, i3);
        if (i3 == 0 && aVar.f() == null) {
            E0(aVar3);
        } else {
            D0(aVar3, aVar);
        }
        p0(aVar3.E, i3, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder aVar;
        if (i3 == 1) {
            aVar = new d(this.D.inflate(R.layout.gla, viewGroup, false));
        } else if (i3 == 2) {
            aVar = new b(this.D.inflate(R.layout.gl9, viewGroup, false));
        } else {
            aVar = new a(this.D.inflate(R.layout.glb, viewGroup, false));
        }
        aVar.setIsRecyclable(false);
        return aVar;
    }

    public void updateData(List<b40.a> list) {
        H0(list);
        s0();
        r0(list);
        q0(list);
        n0();
        notifyDataSetChanged();
    }
}
