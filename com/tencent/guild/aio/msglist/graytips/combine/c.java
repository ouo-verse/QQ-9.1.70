package com.tencent.guild.aio.msglist.graytips.combine;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004J\u0006\u0010\u000b\u001a\u00020\u0002R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/c;", "", "", "d", "", "Lcom/tencent/guild/aio/msglist/graytips/combine/e;", "msgDataList", "a", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "b", "c", "", "Lcom/tencent/guild/aio/msglist/graytips/combine/f;", "Ljava/util/List;", "mProcessorList", "mLastGrayTipMsgDataList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> mProcessorList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<e> mLastGrayTipMsgDataList = new ArrayList();

    public c() {
        d();
    }

    private final void a(List<e> msgDataList) {
        Iterator<f> it = this.mProcessorList.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        int size = msgDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<f> it5 = this.mProcessorList.iterator();
            while (it5.hasNext()) {
                it5.next().b(msgDataList.get(i3));
            }
        }
        Iterator<f> it6 = this.mProcessorList.iterator();
        while (it6.hasNext()) {
            it6.next().a();
        }
    }

    private final void d() {
        this.mProcessorList.add(new b());
    }

    public final void b(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        List<e> a16 = CombineGrayTipFilter.f111311a.a(msgList);
        this.mLastGrayTipMsgDataList = a16;
        a(a16);
        QLog.d("CombineGrayTipsCenter", 1, "onDataSetChanged cost = " + (NetConnInfoCenter.getServerTimeMillis() - serverTimeMillis));
    }

    public final void c() {
        this.mLastGrayTipMsgDataList.clear();
        Iterator<f> it = this.mProcessorList.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }
}
