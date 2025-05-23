package i60;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSSearchResultHintView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.util.LoadingUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSBaseBlockPart implements b {

    /* renamed from: d, reason: collision with root package name */
    private QFSSearchResultHintView f407295d;

    /* renamed from: e, reason: collision with root package name */
    private View f407296e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f407297f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f407298h;

    /* renamed from: i, reason: collision with root package name */
    protected String f407299i;

    /* renamed from: m, reason: collision with root package name */
    protected QFSSearchInfo f407300m;

    public d(int i3, List<MultiViewBlock> list, int i16, int i17) {
        super(i3, list, i16, i17);
    }

    public void A9(int i3) {
        showLoadingView();
        this.f407296e.setBackground(getContext().getResources().getDrawable(i3));
    }

    @Override // i60.b
    public void G4() {
        x9();
        this.mBlockContainer.setVisibility(0);
    }

    public void S2(String str, long j3) {
        x9();
        this.mBlockContainer.setVisibility(0);
        IStatusViewProvider statusInterface = this.mBlockContainer.getStatusInterface();
        if (statusInterface != null) {
            statusInterface.showErrorView((int) j3, str);
            return;
        }
        if (!QCirclePluginUtil.isRequestSecurityHit(j3)) {
            QCircleToast.o(str, 0);
        }
        u1();
    }

    @Override // i60.b
    public void X6() {
        x9();
        showLoadingView();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f407295d = (QFSSearchResultHintView) view.findViewById(R.id.f371416g);
        this.f407296e = view.findViewById(R.id.f53682d6);
        this.f407297f = (ImageView) view.findViewById(R.id.f53692d7);
        this.f407295d.addView(new QUIEmptyState.Builder(getContext()).setAutoCenter(true).setImageType(9).setTitle(getContext().getString(R.string.f195154du)).build(), -1, -1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(getContext(), 2);
        this.f407298h = loadingDrawable;
        this.f407297f.setImageDrawable(loadingDrawable);
    }

    public void showLoadingView() {
        this.f407296e.setBackground(null);
        this.f407296e.setVisibility(0);
        this.f407297f.setImageDrawable(this.f407298h);
    }

    public void u1() {
        x9();
        this.f407295d.setVisibility(0);
        this.f407295d.setSearchInfo(this.f407300m);
        this.f407295d.A0(getContext().getString(R.string.f195154du));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x9() {
        this.f407295d.setVisibility(8);
        this.f407296e.setVisibility(8);
        this.f407297f.setImageDrawable(null);
        IStatusViewProvider statusInterface = this.mBlockContainer.getStatusInterface();
        if (statusInterface != null) {
            statusInterface.getStatusView().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z9(int i3, int i16, int i17, int i18) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f407295d.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i17;
        layoutParams.topMargin = i16;
        layoutParams.bottomMargin = i18;
    }
}
