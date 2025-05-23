package h6;

import android.content.Context;
import android.view.View;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends FeedViewSection {

    /* renamed from: d, reason: collision with root package name */
    protected final AdExposureChecker.ExposureCallback f404415d;

    /* renamed from: e, reason: collision with root package name */
    private final FeedViewSection.SectionController f404416e;

    /* compiled from: P */
    /* renamed from: h6.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10414a implements AdExposureChecker.ExposureCallback {
        C10414a() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            GdtAdFeedUtil.doEffectiveExposureReport(((FeedViewSection) a.this).mFeedData, ((FeedViewSection) a.this).feedPosition, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements FeedViewSection.SectionController {
        b() {
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return !GdtAdFeedUtil.isSectionVisible(businessFeedData, a.this.d());
        }
    }

    public a(Context context, NormalAbsFeedView normalAbsFeedView) {
        super(context, normalAbsFeedView);
        this.f404415d = new C10414a();
        this.f404416e = new b();
        init();
    }

    private void init() {
        setSectionController(this.f404416e);
    }

    public FeedAutoVideo c() {
        return null;
    }

    protected abstract ViewSectionType d();

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getAdData().getIsCGIExposureReport()) {
            return;
        }
        AdExposureChecker.onClick(getContext(), new GdtAd(GdtFeedUtilForQZone.f(businessFeedData)), new WeakReference(this.f404415d));
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
    }

    public void onPause() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
    }
}
