package c83;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.intermediate.TemplateLibIntermediateFragment;
import com.tencent.mobileqq.wink.templatelibrary.WinkTemplatePreviewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends p53.b implements View.OnClickListener {
    private ImageView C;
    private TextView D;
    private View E;

    /* renamed from: d, reason: collision with root package name */
    private final TemplateLibIntermediateFragment f30434d;

    /* renamed from: e, reason: collision with root package name */
    private final String f30435e;

    /* renamed from: f, reason: collision with root package name */
    private d83.a f30436f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f30437h;

    /* renamed from: i, reason: collision with root package name */
    private View f30438i;

    /* renamed from: m, reason: collision with root package name */
    private View f30439m;

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
            QLog.d("TemplateLibIntermediatePreviewPart", 1, "requestMateCategory, getMetaCategoryResult: " + aVar);
            if (aVar.a()) {
                c.this.A9((MetaCategory) aVar.f25718a);
            } else {
                c.this.B9(aVar.f25719b);
            }
        }
    }

    public c(TemplateLibIntermediateFragment templateLibIntermediateFragment, String str) {
        this.f30434d = templateLibIntermediateFragment;
        this.f30435e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9(MetaCategory metaCategory) {
        Intent intent = new Intent();
        intent.setClass(getContext(), QQWinkActivity.class);
        intent.putExtras(this.f30434d.getHostActivity().getIntent().getExtras());
        intent.putExtra("public_fragment_class", WinkTemplatePreviewFragment.class.getName());
        intent.putExtra("category", metaCategory);
        intent.putExtra("position", 0);
        this.f30434d.vh(intent);
        this.f30434d.ph(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(int i3) {
        this.f30438i.setVisibility(8);
        this.f30439m.setVisibility(0);
        if (i3 == -1) {
            this.C.setImageResource(R.drawable.oex);
            this.D.setText(getContext().getResources().getString(R.string.f241287rg));
        } else {
            this.C.setImageResource(R.drawable.oew);
            this.D.setText(getContext().getResources().getString(R.string.f241297rh));
        }
    }

    private void C9() {
        this.f30436f.O1(this.f30435e);
    }

    private void initViewModel() {
        d83.a aVar = (d83.a) getViewModel(d83.a.class);
        this.f30436f = aVar;
        aVar.M1().observe(getHostFragment(), new a());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TemplateLibIntermediatePreviewPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f1186174m) {
            this.f30434d.finish();
        } else if (view.getId() == R.id.tga) {
            this.f30439m.setVisibility(8);
            this.f30438i.setVisibility(0);
            C9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f1186174m);
        this.f30437h = imageView;
        imageView.setOnClickListener(this);
        this.f30438i = view.findViewById(R.id.f85784pw);
        this.f30439m = view.findViewById(R.id.error_layout);
        this.C = (ImageView) view.findViewById(R.id.y2u);
        this.D = (TextView) view.findViewById(R.id.f107786bc);
        View findViewById = view.findViewById(R.id.tga);
        this.E = findViewById;
        findViewById.setOnClickListener(this);
        initViewModel();
        C9();
    }
}
