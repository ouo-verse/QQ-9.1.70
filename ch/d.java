package ch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.widget.particle.ParticleManager;
import com.qzone.widget.particle.ParticleTextSurfaceView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d implements ParticleManager.b {

    /* renamed from: d, reason: collision with root package name */
    private final QZoneRichTextView f30812d;

    /* renamed from: e, reason: collision with root package name */
    private ParticleTextSurfaceView f30813e;

    /* renamed from: f, reason: collision with root package name */
    private final FrameLayout f30814f;

    public d(QZoneRichTextView qZoneRichTextView, View view) {
        this.f30812d = qZoneRichTextView;
        this.f30814f = (FrameLayout) view.findViewById(R.id.nbf);
    }

    private void b(BusinessFeedData businessFeedData) {
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        if (cellSummaryV2 == null) {
            this.f30812d.setVisibility(0);
            return;
        }
        String str = cellSummaryV2.displayReadeableStr;
        if (businessFeedData.isPublicAccountContent() && (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim()))) {
            return;
        }
        this.f30812d.setVisibility(0);
    }

    private void c() {
        if (this.f30813e == null) {
            ParticleTextSurfaceView particleTextSurfaceView = new ParticleTextSurfaceView(this.f30814f.getContext());
            this.f30813e = particleTextSurfaceView;
            this.f30814f.addView(particleTextSurfaceView, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        c();
        g();
        this.f30813e.o(this);
        this.f30813e.setVisibility(0);
        this.f30813e.setCanShowParticle(true);
        this.f30812d.setVisibility(4);
    }

    private void e() {
        this.f30812d.post(new Runnable() { // from class: ch.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.d();
            }
        });
    }

    private void g() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f30813e.getLayoutParams();
        if (this.f30812d.getHeight() == 0 || layoutParams.height == this.f30812d.getHeight()) {
            return;
        }
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.width = this.f30812d.getWidth();
        layoutParams.height = this.f30812d.getHeight();
        this.f30813e.setLayoutParams(layoutParams);
    }

    public void f(BusinessFeedData businessFeedData) {
        ParticleTextSurfaceView particleTextSurfaceView = this.f30813e;
        if (particleTextSurfaceView != null) {
            particleTextSurfaceView.setVisibility(8);
            this.f30813e.setCanShowParticle(false);
        }
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        if (ParticleManager.u() && cellSummaryV2 != null) {
            if (cellSummaryV2.getHideFlag() == 0) {
                b(businessFeedData);
                return;
            } else {
                e();
                return;
            }
        }
        this.f30812d.setVisibility(0);
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public Bitmap getBitmap() {
        if (this.f30812d.getMeasuredWidth() == 0 || this.f30812d.getMeasuredHeight() == 0) {
            return null;
        }
        int paddingLeft = this.f30814f.getPaddingLeft() + this.f30812d.getPaddingLeft();
        this.f30812d.measure(View.MeasureSpec.makeMeasureSpec((ViewUtils.getScreenWidth() - paddingLeft) - (this.f30814f.getPaddingRight() + this.f30812d.getPaddingRight()), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap createBitmap = Bitmap.createBitmap(this.f30812d.getMeasuredWidth(), this.f30812d.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f30812d.setFontBgVisible(false);
        this.f30812d.layout(this.f30814f.getPaddingLeft(), 0, this.f30812d.getMeasuredWidth(), this.f30812d.getMeasuredHeight());
        this.f30812d.draw(canvas);
        this.f30812d.setFontBgVisible(true);
        return createBitmap;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getLineHeight() {
        return this.f30812d.getLineHeight();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleHeight() {
        return this.f30812d.getHeight();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleTextVisibility() {
        return this.f30812d.getVisibility();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleWidth() {
        return this.f30812d.getWidth();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public void setParticleTextVisibility(int i3) {
        this.f30812d.setVisibility(i3);
    }
}
