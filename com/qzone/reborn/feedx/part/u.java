package com.qzone.reborn.feedx.part;

import android.os.Looper;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.util.CreditLevelMonitor;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends g {

    /* renamed from: d, reason: collision with root package name */
    private gf.n f55319d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends HdAsyncAction {
        a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (!u.this.f55319d.d()) {
                return doNext(false);
            }
            com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
            aVar.f47117a = 6;
            aVar.f47119c = LocalMultiProcConfig.getString4Uin("creditmessage", "", LoginData.getInstance().getUin());
            u.this.f55319d.b(aVar);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends HdAsyncAction {
        b(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            return doNext(CreditLevelMonitor.f(GuildMsgItem.NICK_FRIEND));
        }
    }

    private void E9() {
        HdAsync.with(this).then(new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread))).then(new a(Looper.getMainLooper())).call();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxCreditLevelTopBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        E9();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55319d = (gf.n) getIocInterface(gf.n.class);
    }
}
