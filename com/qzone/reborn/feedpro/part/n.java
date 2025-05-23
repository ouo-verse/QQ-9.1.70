package com.qzone.reborn.feedpro.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/feedpro/part/n;", "Lcom/tencent/biz/richframework/part/PartManager;", "", "Lcom/qzone/reborn/feedpro/part/b;", "b", "", "a", "Ljo/d;", "d", "Ljo/d;", "mMonitor", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "fragment", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends PartManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private jo.d mMonitor;

    public n(IPartHost iPartHost, View view) {
        super(iPartHost, view);
        this.mMonitor = jo.h.f410717a.g("part_lifecycle");
    }

    private final List<b> b() {
        Collection<Part> values = this.mParts.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (obj instanceof b) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void a() {
        for (b bVar : b()) {
            String str = bVar.getLogTag() + "#onDelayShowAfterFeedShow";
            this.mMonitor.h(str);
            bVar.c9();
            this.mMonitor.b(str);
        }
    }
}
