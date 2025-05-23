package c83;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.intermediate.TemplateLibIntermediateFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends p53.b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected final TemplateLibIntermediateFragment f30441d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f30442e;

    /* renamed from: f, reason: collision with root package name */
    protected d83.a f30443f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f30444h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f30445i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f30446m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Observer<a83.a> {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(a83.a aVar) {
            QLog.d("TemplateLibIntermediateSelectPart", 1, "requestMaterialRes, getMetaCategoryResult: " + aVar);
            if (aVar.a()) {
                ArrayList<MetaMaterial> arrayList = ((MetaCategory) aVar.f25718a).materials;
                if (arrayList != null && !arrayList.isEmpty()) {
                    d.this.f30443f.P1(arrayList.get(0));
                    return;
                }
                return;
            }
            d.this.C9(aVar.f25719b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements Observer<a83.b> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(a83.b bVar) {
            QLog.d("TemplateLibIntermediateSelectPart", 1, "requestMaterialRes, getMetaMaterialResult: " + bVar);
            if (bVar.a()) {
                d.this.B9((MetaMaterial) bVar.f25718a);
            } else {
                d.this.C9(bVar.f25719b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: c83.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0176d extends RecyclerView.ViewHolder {
        public C0176d(@NonNull @NotNull View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class e extends RecyclerView.Adapter<f> {

        /* renamed from: m, reason: collision with root package name */
        private final int f30449m;

        e(int i3) {
            this.f30449m = i3;
        }

        private void k0(f fVar, int i3) {
            int dpToPx = ImmersiveUtils.dpToPx(0.0f);
            int dpToPx2 = ImmersiveUtils.dpToPx(-1.0f);
            int dpToPx3 = ImmersiveUtils.dpToPx(1.0f);
            if (i3 % 3 == 0) {
                if (i3 == 0) {
                    fVar.itemView.setPadding(dpToPx, dpToPx, dpToPx3, dpToPx3);
                    return;
                } else {
                    fVar.itemView.setPadding(dpToPx, dpToPx, dpToPx3, dpToPx3);
                    return;
                }
            }
            if (((i3 - 3) + 1) % 3 == 0) {
                if (i3 == 2) {
                    fVar.itemView.setPadding(dpToPx3, dpToPx, dpToPx2, dpToPx3);
                    return;
                } else {
                    fVar.itemView.setPadding(dpToPx3, dpToPx3, dpToPx2, dpToPx3);
                    return;
                }
            }
            if (i3 == 1) {
                fVar.itemView.setPadding(dpToPx3, dpToPx, dpToPx3, dpToPx3);
            } else {
                fVar.itemView.setPadding(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return 15;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull f fVar, int i3) {
            k0(fVar, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public f onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i8_, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            int i16 = this.f30449m;
            layoutParams.width = i16;
            layoutParams.height = i16;
            inflate.setLayoutParams(layoutParams);
            return new f(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class f extends RecyclerView.ViewHolder {
        public f(@NonNull @NotNull View view) {
            super(view);
        }
    }

    public d(TemplateLibIntermediateFragment templateLibIntermediateFragment, String str) {
        this.f30441d = templateLibIntermediateFragment;
        this.f30442e = str;
    }

    private void A9(View view) {
        int dimensionPixelSize = (getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R.dimen.c6x) * 2)) / 3;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f7922497);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(new e(dimensionPixelSize));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(MetaMaterial metaMaterial) {
        Intent a16 = QCircleTemplateLibraryMediaPickerFragment.INSTANCE.a(getContext(), metaMaterial);
        a16.putExtras(this.f30441d.getHostActivity().getIntent().getExtras());
        this.f30441d.vh(a16);
        this.f30441d.ph(false);
    }

    private void initViewModel() {
        d83.a aVar = (d83.a) getViewModel(d83.a.class);
        this.f30443f = aVar;
        aVar.M1().observe(getHostFragment(), new a());
        this.f30443f.N1().observe(getHostFragment(), new b());
    }

    private void z9(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f7881483);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView.addItemDecoration(new b83.a(8));
        recyclerView.setAdapter(new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C9(int i3) {
        ra3.a.a(getContext(), getContext().getResources().getString(R.string.f241257rd));
        this.f30445i.setVisibility(0);
        this.f30446m.setText(getContext().getResources().getString(R.string.f241267re));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D9() {
        this.f30443f.O1(this.f30442e);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TemplateLibIntermediateSelectPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dum) {
            this.f30441d.finish();
        } else if (view.getId() == R.id.lod || view.getId() == R.id.kbr) {
            this.f30445i.setVisibility(8);
            this.f30446m.setText(getContext().getResources().getString(R.string.f241277rf));
            D9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dum);
        this.f30444h = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.lod);
        this.f30445i = imageView2;
        imageView2.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.kbr);
        this.f30446m = textView;
        textView.setOnClickListener(this);
        A9(view);
        z9(view);
        initViewModel();
        D9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c extends RecyclerView.Adapter<C0176d> {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return 6;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public C0176d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new C0176d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i88, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull C0176d c0176d, int i3) {
        }
    }
}
