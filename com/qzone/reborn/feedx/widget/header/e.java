package com.qzone.reborn.feedx.widget.header;

import android.os.Message;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneAvatarDecorator;
import com.qzone.cover.ui.QzoneFacadeDecorator;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e extends d implements IObserver.main {

    /* renamed from: f, reason: collision with root package name */
    private final QzoneAvatarDecorator f56259f;

    /* renamed from: h, reason: collision with root package name */
    private final QzoneFacadeDecorator f56260h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ho.i.z().m(e.this.g(), LoginData.getInstance().getUin());
            com.qzone.misc.network.report.a.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            vo.c.c(e.this.g(), "qzone", LoginData.getInstance().getUin());
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    public e(View view) {
        super(view);
        this.f56259f = (QzoneAvatarDecorator) view.findViewById(R.id.mzm);
        this.f56260h = (QzoneFacadeDecorator) view.findViewById(R.id.mzn);
    }

    private void n() {
        this.f56259f.setContentDescription(g().getResources().getText(R.string.gqm));
        this.f56259f.setFacadeDecorator(this.f56260h);
        this.f56259f.c(g(), LoginData.getInstance().getUinString());
        this.f56259f.d();
        this.f56259f.setOnClickListener(new a());
        this.f56259f.setOnLongClickListener(new b());
        fo.c.n(this.f56259f, "em_qz_avatar");
    }

    private void o() {
        this.f56260h.r(g(), LoginData.getInstance().getUinString(), true);
        ViewCompat.setImportantForAccessibility(this.f56260h, 2);
        this.f56260h.d();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        QzoneAvatarDecorator qzoneAvatarDecorator = this.f56259f;
        if (qzoneAvatarDecorator != null) {
            qzoneAvatarDecorator.c(g(), LoginData.getInstance().getUinString());
            this.f56259f.d();
            this.f56260h.d();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void b(RecyclerView recyclerView, int i3, int i16) {
        QzoneAvatarDecorator qzoneAvatarDecorator;
        if (this.f56260h == null || (qzoneAvatarDecorator = this.f56259f) == null) {
            return;
        }
        if (!qzoneAvatarDecorator.isShown()) {
            this.f56260h.C();
        } else {
            this.f56260h.z();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderAvatarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        n();
        o();
        EventCenter.getInstance().addUIObserver(this, "QQHead", 1);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56260h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.C();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QzoneAvatarDecorator qzoneAvatarDecorator;
        if ("QQHead".equals(event.source.getName()) && event.what == 1 && (qzoneAvatarDecorator = this.f56259f) != null) {
            qzoneAvatarDecorator.d();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        QzoneAvatarDecorator qzoneAvatarDecorator;
        QZoneResult unpack = QZoneResult.unpack(message);
        if (message.what == 999924 && unpack != null && unpack.getSucceed() && (qzoneAvatarDecorator = this.f56259f) != null) {
            qzoneAvatarDecorator.c(g(), LoginData.getInstance().getUinString());
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56260h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.B();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56260h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.d();
        }
    }

    public void p() {
        this.f56259f.l(LoginData.getInstance().getUinString());
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56260h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.d();
        }
    }
}
