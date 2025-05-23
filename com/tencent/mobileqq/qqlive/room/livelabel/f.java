package com.tencent.mobileqq.qqlive.room.livelabel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.room.livelabel.b;
import com.tencent.mobileqq.qqlive.room.livelabel.f;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetThirdLabelRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;
    private LabelModel C;
    private int D;
    private boolean E;
    private HashMap<Long, List<LabelModel>> F;
    private IAegisLogApi G;
    private long H;
    private a I;

    /* renamed from: m, reason: collision with root package name */
    private f55.e[] f271624m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(int i3, int i16, LabelModel labelModel);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        RecyclerView E;
        com.tencent.mobileqq.qqlive.room.livelabel.b F;

        public b(@NonNull View view) {
            super(view);
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) view);
                return;
            }
            this.E = (RecyclerView) view.findViewById(R.id.i4l);
            if (f.this.E) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            int b16 = lk4.e.b(view.getContext(), 12.0f);
            int b17 = lk4.e.b(view.getContext(), f.this.E ? 16.0f : 12.0f);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), i3);
            com.tencent.mobileqq.qqlive.room.livelabel.a aVar = new com.tencent.mobileqq.qqlive.room.livelabel.a(i3, b17, b16);
            this.E.setLayoutManager(gridLayoutManager);
            com.tencent.mobileqq.qqlive.room.livelabel.b bVar = new com.tencent.mobileqq.qqlive.room.livelabel.b(f.this.E);
            this.F = bVar;
            this.E.setAdapter(bVar);
            this.E.setItemAnimator(null);
            this.E.setHasFixedSize(true);
            this.E.addItemDecoration(aVar);
            this.F.m0(new b.a() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.g
                @Override // com.tencent.mobileqq.qqlive.room.livelabel.b.a
                public final void a(int i16, LabelModel labelModel) {
                    f.b.this.p(i16, labelModel);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(f55.e eVar, QQLiveResponse qQLiveResponse) {
            f55.h[] hVarArr;
            boolean z16;
            if (qQLiveResponse.isSuccess() && qQLiveResponse.getRetCode() == 0) {
                f55.d dVar = (f55.d) qQLiveResponse.getRsp();
                if (dVar != null && (hVarArr = dVar.f397867a) != null && hVarArr.length >= 1) {
                    this.itemView.setVisibility(0);
                    ArrayList arrayList = new ArrayList(dVar.f397867a.length);
                    for (f55.h hVar : dVar.f397867a) {
                        LabelModel labelModel = new LabelModel();
                        labelModel.iconUrl = hVar.f397877c;
                        labelModel.isShowIcon = f.this.E;
                        labelModel.title = hVar.f397876b;
                        labelModel.secondId = hVar.f397881g;
                        labelModel.gameId = hVar.f397880f;
                        labelModel.thirdLabelId = hVar.f397875a;
                        if (eVar.f397871c == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        labelModel.isGame = z16;
                        arrayList.add(labelModel);
                    }
                    f.this.r0(arrayList);
                    this.F.setData(arrayList);
                    f.this.F.put(Long.valueOf(eVar.f397869a), arrayList);
                    return;
                }
                AegisLogger.e(AegisLogger.OPEN_LIVE, "PagerSelectAdapter", "[bindData] no thirdLabelInfo");
                this.itemView.setVisibility(4);
                return;
            }
            AegisLogger.e(AegisLogger.OPEN_LIVE, "PagerSelectAdapter", "[bindData] isSuccess=" + qQLiveResponse.isSuccess() + "retCode=" + qQLiveResponse.getRetCode());
            this.itemView.setVisibility(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(int i3, LabelModel labelModel) {
            f.this.D = getAdapterPosition();
            f.this.I.a(f.this.D, i3, labelModel);
            f.this.C = labelModel;
            f.this.G.i("PagerSelectAdapter", "setOnItemClickListener mTabSelectedPos=" + f.this.D + ",mLastSelectedModel=" + f.this.C);
        }

        public void n(final f55.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            List<LabelModel> list = (List) f.this.F.get(Long.valueOf(eVar.f397869a));
            if (list != null) {
                if (getAdapterPosition() != f.this.D) {
                    Iterator<LabelModel> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().isSelected = false;
                    }
                }
                this.itemView.setVisibility(0);
                f.this.r0(list);
                this.F.setData(list);
                return;
            }
            if (f.this.s0(eVar.f397869a)) {
                ArrayList<LabelModel> b16 = e.b();
                if (b16.size() > 0) {
                    b16.get(0).isSelected = true;
                }
                this.itemView.setVisibility(0);
                f.this.r0(b16);
                this.F.setData(b16);
                return;
            }
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetThirdLabelRequest(eVar.f397869a), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.h
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    f.b.this.o(eVar, qQLiveResponse);
                }
            });
        }
    }

    public f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.E = false;
        this.F = new HashMap<>();
        this.G = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.H = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s0(long j3) {
        if (this.H == 10 && j3 == 99999999) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        f55.e[] eVarArr = this.f271624m;
        if (eVarArr == null) {
            return 0;
        }
        return eVarArr.length;
    }

    public void r0(List<LabelModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null && this.C != null) {
            for (LabelModel labelModel : list) {
                int i3 = labelModel.secondId;
                LabelModel labelModel2 = this.C;
                if (i3 == labelModel2.secondId && labelModel.thirdLabelId == labelModel2.thirdLabelId) {
                    labelModel.isSelected = true;
                } else {
                    labelModel.isSelected = false;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar, i3);
        } else {
            bVar.n(this.f271624m[i3]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i3t, viewGroup, false));
    }

    public void v0(f55.e[] eVarArr, LabelModel labelModel, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, eVarArr, labelModel, Boolean.valueOf(z16));
            return;
        }
        this.f271624m = eVarArr;
        this.C = labelModel;
        notifyDataSetChanged();
        this.G.i("PagerSelectAdapter", "setData items=" + Arrays.toString(eVarArr) + ",lastModel=" + labelModel + ",isShowLogo=" + z16);
    }

    public void w0(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.I = aVar;
        }
    }
}
