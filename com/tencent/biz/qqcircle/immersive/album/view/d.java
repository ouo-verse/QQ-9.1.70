package com.tencent.biz.qqcircle.immersive.album.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.album.event.QFSAlbumBanedEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private static final int f84876i = cx.a(256.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f84877m = cx.a(192.0f);

    /* renamed from: d, reason: collision with root package name */
    private QFSLayerAlbumViewModel f84878d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f84879e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f84880f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f84881h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<QQCircleFeedBase$AlbumPageData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
            d.this.z9(qQCircleFeedBase$AlbumPageData);
        }
    }

    private void A9() {
        this.f84879e.setVisibility(0);
        this.f84880f.setText(uq3.c.w3());
        com.tencent.biz.qqcircle.utils.j.a(this.f84881h, QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), f84876i, f84877m);
    }

    private void initViewModel() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        this.f84878d = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.O2().observe(getHostFragment(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z9(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        boolean z16;
        int i3 = 0;
        boolean z17 = true;
        if (qQCircleFeedBase$AlbumPageData.album.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.e("QFSAlbumBanedPart", 1, "[showAlbumBanedViewIfNeed]: isBaned:" + z16);
        boolean isOwner = QCirclePluginUtil.isOwner(this.f84878d.O2().getValue().album.owner.f398463id.get());
        if (!z16 || isOwner) {
            z17 = false;
        }
        FrameLayout frameLayout = this.f84879e;
        if (!z17) {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (z17) {
            this.f84880f.setText(uq3.c.w3());
            com.tencent.biz.qqcircle.utils.j.a(this.f84881h, QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), f84876i, f84877m);
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSAlbumBanedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAlbumBanedPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f84879e = (FrameLayout) view.findViewById(R.id.skj);
        this.f84880f = (TextView) view.findViewById(R.id.skh);
        this.f84881h = (ImageView) view.findViewById(R.id.ski);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSAlbumBanedEvent) {
            A9();
        }
    }
}
