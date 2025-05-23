package com.tencent.biz.pubaccount.accountdetail.model;

import android.widget.CompoundButton;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ4\u0010\n\u001a\u00020\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/model/m;", "Lcom/tencent/biz/pubaccount/accountdetail/model/c;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "itemConfig", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "d", "<init>", "()V", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class m extends c {
    public m() {
        g("\u52a0\u5165\u6392\u884c\u699c");
        f(((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getRankingSwitchStateDefault());
        e(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.biz.pubaccount.accountdetail.model.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                m.k(compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(CompoundButton compoundButton, boolean z16) {
        QLog.d("QQSportPADataCardItemConfigModel", 1, "joinQQSportsRank is clicked = " + z16);
        ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).requestJoinRanking(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final WeakReference weakReference, final WeakReference weakReference2, boolean z16, int i3) {
        QLog.d("QQSportPADataCardItemConfigModel", 1, "requestRankingState callback isSuccess:" + z16 + ", state = " + i3);
        final boolean z17 = i3 != 0;
        if (z16) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.model.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.m(weakReference, z17, weakReference2);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.model.c
    public void d(final WeakReference<x<x.b.d, x.c.f>> itemConfig, final WeakReference<QUIListItemAdapter> adapter) {
        ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).requestRankingState(new h43.d() { // from class: com.tencent.biz.pubaccount.accountdetail.model.k
            @Override // h43.d
            public final void a(boolean z16, int i3) {
                m.l(itemConfig, adapter, z16, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WeakReference weakReference, boolean z16, WeakReference weakReference2) {
        x xVar;
        QUIListItemAdapter qUIListItemAdapter;
        if (weakReference == null || (xVar = (x) weakReference.get()) == null) {
            return;
        }
        ((x.c.f) xVar.O()).f(z16);
        if (weakReference2 == null || (qUIListItemAdapter = (QUIListItemAdapter) weakReference2.get()) == null) {
            return;
        }
        qUIListItemAdapter.l0(xVar);
    }
}
