package ba0;

import android.view.View;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSShowSearchHotPanelEvent;
import com.tencent.biz.qqcircle.immersive.views.searchprompt.hotrank.template.itemview.templatetext.QFSSearchItemViewTextHolder;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends QFSSearchItemViewTextHolder {
    public a(View view) {
        super(view);
    }

    @Override // aa0.b, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSShowSearchHotPanelEvent(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.searchprompt.hotrank.template.itemview.templatetext.QFSSearchItemViewTextHolder, aa0.b
    public void s(QFSSearchInfo qFSSearchInfo) {
        super.s(qFSSearchInfo);
        qFSSearchInfo.j(23);
    }
}
