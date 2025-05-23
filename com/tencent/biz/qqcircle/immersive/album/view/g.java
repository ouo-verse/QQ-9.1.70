package com.tencent.biz.qqcircle.immersive.album.view;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.immersive.album.view.g;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedAlbum$AlbumInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QFSLayerAlbumViewModel f84885d;

    /* renamed from: e, reason: collision with root package name */
    private Button f84886e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f84887f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSLayerAlbumViewModel.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (g.this.getActivity() != null && g.this.getActivity().isFinishing()) {
                g.this.getActivity().finish();
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.b
        public void a(QQCircleFeedAlbum$AlbumInfo qQCircleFeedAlbum$AlbumInfo) {
            g.this.f84887f = false;
            g.this.f84885d.S2().setValue(Boolean.FALSE);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumEvent(3, qQCircleFeedAlbum$AlbumInfo.f429303id.get(), qQCircleFeedAlbum$AlbumInfo.title.get(), qQCircleFeedAlbum$AlbumInfo.description.get(), qQCircleFeedAlbum$AlbumInfo.cover_url.get(), qQCircleFeedAlbum$AlbumInfo.item_count.get()));
            QCircleToast.o(g.this.getActivity().getResources().getString(R.string.f188263w8), 0);
            g.this.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.album.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.a.this.c();
                }
            }, 500L);
        }

        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.b
        public void onFailed() {
            g.this.f84887f = false;
            QCircleToast.o(g.this.getActivity().getResources().getString(R.string.f188243w6), 0);
        }
    }

    private void B9() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.f84885d;
        if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.O2() != null && this.f84885d.O2().getValue() != null) {
            ArrayList<FeedCloudMeta$StFeed> d16 = e30.d.d(this.f84885d.O1());
            QQCircleFeedAlbum$AlbumInfo qQCircleFeedAlbum$AlbumInfo = new QQCircleFeedAlbum$AlbumInfo();
            qQCircleFeedAlbum$AlbumInfo.f429303id.set(this.f84885d.O2().getValue().album.f398441id.get());
            qQCircleFeedAlbum$AlbumInfo.cover_url.set(this.f84885d.O2().getValue().album.cover_url.get());
            qQCircleFeedAlbum$AlbumInfo.description.set(this.f84885d.O2().getValue().album.description.get());
            qQCircleFeedAlbum$AlbumInfo.create_time.set(this.f84885d.O2().getValue().album.create_time.get());
            qQCircleFeedAlbum$AlbumInfo.title.set(this.f84885d.O2().getValue().album.title.get());
            qQCircleFeedAlbum$AlbumInfo.item_count.set(d16.size());
            qQCircleFeedAlbum$AlbumInfo.owner_id.set(this.f84885d.O2().getValue().album.owner.f398463id.get());
            this.f84887f = true;
            this.f84885d.g3(qQCircleFeedAlbum$AlbumInfo, d16, true, new a());
            return;
        }
        QLog.e("QFSAlbumDraftCreatePart", 1, "[createAlbumFromDraft]:AlbumPageData is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitView$0(Boolean bool) {
        int i3;
        Button button = this.f84886e;
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        button.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAlbumDraftCreatePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f33610wx && !fb0.a.a("QFSAlbumDraftCreatePart") && !this.f84887f) {
            B9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f84886e = (Button) view.findViewById(R.id.f33610wx);
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        this.f84885d = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.S2().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.this.lambda$onInitView$0((Boolean) obj);
            }
        });
        this.f84886e.setOnClickListener(this);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(this.f84886e, QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_ALBUM_BUTTON);
        VideoReport.setElementParams(this.f84886e, buildElementParams);
    }
}
