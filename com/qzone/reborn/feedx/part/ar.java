package com.qzone.reborn.feedx.part;

import android.os.Message;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0007J\u001c\u0010\u0013\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0007R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/part/ar;", "Lcom/tencent/biz/richframework/part/PartManager;", "", "Lcom/qzone/reborn/feedx/part/g;", "i", "Landroid/os/Message;", "msg", "", "e", "Lcom/qzone/common/business/result/QZoneResult;", "result", "c", "b", "f", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "loadType", "g", "d", "Ljo/d;", "Ljo/d;", "mMonitor", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "fragment", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ar extends PartManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private jo.d mMonitor;

    public ar(IPartHost iPartHost, View view) {
        super(iPartHost, view);
        this.mMonitor = jo.h.f410717a.g("part_lifecycle");
    }

    private final List<g> i() {
        Collection<Part> values = this.mParts.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void a() {
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onDelayShowAfterFeedShow";
            this.mMonitor.h(str);
            gVar.i6();
            this.mMonitor.b(str);
        }
    }

    public final void b(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onFeedLoadMoreFinish";
            this.mMonitor.h(str);
            gVar.f7(result);
            this.mMonitor.b(str);
        }
    }

    public final void c(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onFeedRefreshFinish";
            this.mMonitor.h(str);
            gVar.i5(result);
            this.mMonitor.b(str);
        }
    }

    public final void d() {
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onFeedRefreshStart";
            this.mMonitor.h(str);
            gVar.p4();
            this.mMonitor.b(str);
        }
    }

    public final void e(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onHandleMessage";
            this.mMonitor.h(str);
            gVar.onHandleMessage(msg2);
            this.mMonitor.b(str);
        }
    }

    public final void f(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onSubsidiaryRefreshFinish";
            this.mMonitor.h(str);
            gVar.v0(result);
            this.mMonitor.b(str);
        }
    }

    public final void g(List<? extends BusinessFeedData> feedsData, int loadType) {
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        for (g gVar : i()) {
            String str = gVar.getLogTag() + "#onUpdateFeedData";
            this.mMonitor.h(str);
            gVar.j7(feedsData, loadType);
            this.mMonitor.b(str);
        }
    }
}
