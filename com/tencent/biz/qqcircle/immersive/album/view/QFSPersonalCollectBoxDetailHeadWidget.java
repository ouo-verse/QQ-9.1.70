package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageRsp;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxDetailHeadWidget extends QCircleBaseWidgetView<ArrayList<e30.b>> implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private final Size f84855d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f84856e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f84857f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f84858h;

    public QFSPersonalCollectBoxDetailHeadWidget(@NonNull Context context, QCircleBaseFragment qCircleBaseFragment, com.tencent.biz.qqcircle.bizparts.c cVar) {
        super(context);
        n0(this);
        this.f84855d = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3n);
    }

    private void m0(QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent) {
        if (qFSPersonalCollectBoxEvent.getEventStatus() == 2) {
            this.f84856e.setText(qFSPersonalCollectBoxEvent.getFavoritesInfo().title.get());
        }
    }

    private void n0(View view) {
        this.f84856e = (TextView) view.findViewById(R.id.kbs);
        this.f84857f = (QCircleAvatarView) view.findViewById(R.id.a2o);
        this.f84858h = (TextView) view.findViewById(R.id.mdg);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalCollectBoxEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalCollectBoxDetailHeadWidget";
    }

    public void l0(QQCircleFeedBase$StFavoritesFeedsPageRsp qQCircleFeedBase$StFavoritesFeedsPageRsp) {
        this.f84856e.setText(qQCircleFeedBase$StFavoritesFeedsPageRsp.title.get());
        this.f84857f.setUser(qQCircleFeedBase$StFavoritesFeedsPageRsp.author.get(), this.f84855d);
        this.f84858h.setText(qQCircleFeedBase$StFavoritesFeedsPageRsp.author.nick.get());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalCollectBoxEvent) {
            m0((QFSPersonalCollectBoxEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(ArrayList<e30.b> arrayList, int i3) {
    }
}
