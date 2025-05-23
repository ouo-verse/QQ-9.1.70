package com.tencent.sqshow.zootopia.player.preload;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager;
import com.tencent.sqshow.zootopia.player.preload.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/a;", "Lq84/a;", "Landroid/view/View;", "itemView", "", com.tencent.luggage.wxa.c8.c.G, "", "j", "i", "", "url", h.F, "Lq84/b;", "selectInfo", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "e", "", "a", "Lhb4/b;", "b", "Lhb4/b;", "getAdapter", "()Lhb4/b;", "adapter", "<init>", "(Lhb4/b;)V", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends q84.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final hb4.b adapter;

    public a(hb4.b adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    private final String h(String url) {
        String d16 = g.d(url);
        Intrinsics.checkNotNullExpressionValue(d16, "toMD5(url)");
        return d16;
    }

    private final int i(int pos) {
        return 4;
    }

    private final void j(View itemView, int pos) {
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData;
        int i3 = i(pos);
        d.Companion companion = d.INSTANCE;
        companion.a().t(i3 - 1);
        ArrayList<ZootopiaDetailFeedsCardData> i06 = this.adapter.i0();
        companion.a().s(h((i06 == null || (zootopiaDetailFeedsCardData = i06.get(pos)) == null) ? null : ZootopiaDetailFeedsCardData.INSTANCE.h(zootopiaDetailFeedsCardData)));
        int i16 = pos + 1;
        ArrayList<ZootopiaDetailFeedsCardData> i07 = this.adapter.i0();
        Intrinsics.checkNotNull(i07);
        int min = Math.min(i3 + pos, i07.size());
        QLog.d("PreLoadManager", 2, "triggerPreloadVideo, current pos = " + pos + ", preloadmax = " + min);
        if (i16 < min) {
            VideoPlayerPreLoadManager.Companion companion2 = VideoPlayerPreLoadManager.INSTANCE;
            if (companion2.a().j()) {
                VideoPlayerPreLoadManager a16 = companion2.a();
                Context context = itemView.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                a16.o((Activity) context, pos, true);
                i16++;
            }
        }
        while (i16 < min) {
            ArrayList<ZootopiaDetailFeedsCardData> i08 = this.adapter.i0();
            d.INSTANCE.a().q(ZootopiaDetailFeedsCardData.INSTANCE.a(i08 != null ? i08.get(i16) : null));
            i16++;
        }
    }

    @Override // q84.a
    public boolean a() {
        return true;
    }

    @Override // q84.a
    public void e(q84.b selectInfo, RecyclerView.ViewHolder holder) {
        View view;
        if (holder == null || (view = holder.itemView) == null || selectInfo == null) {
            return;
        }
        j(view, selectInfo.getMPosition());
    }
}
