package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$FeedAlbum;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f88910d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f88911e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f88912f;

    /* renamed from: h, reason: collision with root package name */
    private Observer<UIStateData<List<FeedCloudMeta$FeedAlbum>>> f88913h;

    /* renamed from: i, reason: collision with root package name */
    private IPartHost f88914i;

    public c(IPartHost iPartHost) {
        this.f88914i = iPartHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A9(UIStateData uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null && ((List) uIStateData.getData()).size() != 0) {
            B9();
        }
    }

    private void B9() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar;
        if (this.f88910d != null && (rVar = this.f88912f) != null && rVar.L2() && com.tencent.biz.qqcircle.utils.ai.e()) {
            this.f88910d.setVisibility(0);
        }
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(this.f88914i, "", com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.f88912f = rVar;
        if (rVar == null) {
            return;
        }
        this.f88913h = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.A9((UIStateData) obj);
            }
        };
        this.f88912f.d2().observeForever(this.f88913h);
    }

    private void z9() {
        FrameLayout frameLayout = this.f88910d;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
        com.tencent.biz.qqcircle.utils.ai.l();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAlbumTipsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f44171og) {
            z9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88910d = (FrameLayout) view.findViewById(R.id.f41881i_);
        ImageView imageView = (ImageView) view.findViewById(R.id.f44171og);
        this.f88911e = imageView;
        imageView.setOnClickListener(this);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.f88912f;
        if (rVar != null) {
            rVar.d2().removeObserver(this.f88913h);
        }
    }
}
