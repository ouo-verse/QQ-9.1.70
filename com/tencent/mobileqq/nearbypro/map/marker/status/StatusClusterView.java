package com.tencent.mobileqq.nearbypro.map.marker.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import bb2.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.FeedCheckFragment;
import com.tencent.mobileqq.nearbypro.utils.i;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.xweb.FileReaderHelper;
import hb2.a;
import hb2.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0010B\u001d\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/status/StatusClusterView;", "Landroid/widget/FrameLayout;", "Lbb2/d;", "Lhb2/b;", "clickedData", "", "i", "j", "newItem", "", "b", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/view/MotionEvent;", "clickEvent", "c", "a", "markerItemData", "k", "d", "Lhb2/b;", "curData", "Lhb2/a;", "e", "Lhb2/a;", "markerView", "f", "Lcom/tencent/mobileqq/nearbypro/part/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StatusClusterView extends FrameLayout implements d<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b curData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a markerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.nearbypro.part.a host;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusClusterView(@NotNull Context context, @Nullable com.tencent.mobileqq.nearbypro.part.a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.host = aVar;
    }

    private final boolean b(b newItem) {
        xp4.a aVar;
        xp4.a data = newItem.getData();
        b bVar = this.curData;
        if (bVar != null) {
            aVar = bVar.getData();
        } else {
            aVar = null;
        }
        return !i.i(data, aVar);
    }

    private final void i(b clickedData) {
        boolean z16;
        String str;
        View view;
        g gVar = clickedData.getData().f448301f;
        if (gVar != null) {
            z16 = i.j(gVar);
        } else {
            z16 = false;
        }
        if (z16) {
            str = "pic";
        } else {
            str = FileReaderHelper.TXT_EXT;
        }
        HashMap hashMap = new HashMap();
        VideoReport.setPageId(this, "pg_nearby_home_map");
        VideoReport.setPageParams(this, new PageParams(hashMap));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        a aVar = this.markerView;
        View view2 = null;
        if (aVar != null) {
            view = aVar.d();
        } else {
            view = null;
        }
        VideoReport.setElementId(view, "em_nearby_state_icon");
        hashMap.put("nearby_status_id", str);
        a aVar2 = this.markerView;
        if (aVar2 != null) {
            view2 = aVar2.d();
        }
        VideoReport.reportEvent("dt_clck", view2, hashMap);
    }

    private final void j(b clickedData) {
        boolean z16;
        String str;
        View view;
        g gVar = clickedData.getData().f448301f;
        if (gVar != null) {
            z16 = i.j(gVar);
        } else {
            z16 = false;
        }
        if (z16) {
            str = "pic";
        } else {
            str = FileReaderHelper.TXT_EXT;
        }
        HashMap hashMap = new HashMap();
        VideoReport.setPageId(this, "pg_nearby_home_map");
        VideoReport.setPageParams(this, new PageParams(hashMap));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        a aVar = this.markerView;
        View view2 = null;
        if (aVar != null) {
            view = aVar.d();
        } else {
            view = null;
        }
        VideoReport.setElementId(view, "em_nearby_state_icon");
        hashMap.put("nearby_status_id", str);
        a aVar2 = this.markerView;
        if (aVar2 != null) {
            view2 = aVar2.d();
        }
        VideoReport.reportEvent("dt_imp", view2, hashMap);
    }

    @Override // bb2.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull b clickedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        d.a.c(this, clickedData, host, clickEvent);
        i(clickedData);
        FeedCheckFragment.Companion companion = FeedCheckFragment.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FeedCheckFragment.Companion.b(companion, context, host, null, null, clickedData.getData(), "1", 12, null);
    }

    @Override // bb2.d
    public void f(@NotNull com.tencent.mobileqq.nearbypro.part.a aVar) {
        d.a.a(this, aVar);
    }

    @Override // bb2.d
    public void h() {
        d.a.b(this);
    }

    @Override // bb2.d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull b markerItemData) {
        String str;
        boolean z16;
        a statusNoPicClusterView;
        xp4.a data;
        Intrinsics.checkNotNullParameter(markerItemData, "markerItemData");
        String str2 = markerItemData.getData().f448296a;
        b bVar = this.curData;
        if (bVar != null && (data = bVar.getData()) != null) {
            str = data.f448296a;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str)) {
            j.c().e("StatusClusterView", "update isSameFeed");
            return;
        }
        if (b(markerItemData) || this.markerView == null) {
            g gVar = markerItemData.getData().f448301f;
            if (gVar != null) {
                z16 = i.j(gVar);
            } else {
                z16 = false;
            }
            if (z16) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                statusNoPicClusterView = new StatusPicClusterView(context, this.host);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                statusNoPicClusterView = new StatusNoPicClusterView(context2, this.host);
            }
            this.markerView = statusNoPicClusterView;
            removeAllViews();
            a aVar = this.markerView;
            Intrinsics.checkNotNull(aVar);
            addView(aVar.d());
        }
        a aVar2 = this.markerView;
        if (aVar2 != null) {
            aVar2.a(markerItemData);
        }
        this.curData = markerItemData;
        j(markerItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // bb2.d
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StatusClusterView d() {
        return this;
    }
}
