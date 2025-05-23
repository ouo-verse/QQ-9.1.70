package com.qzone.reborn.feedx.scroller;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016JL\u0010\u0014\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedx/scroller/c;", "Lhh/b;", "", "r", "c", "", "j", "onResume", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends hh.b {
    private final String r() {
        Context context = this.f404912f;
        if (context != null && (context instanceof Activity)) {
            int hashCode = context.hashCode();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode);
            return sb5.toString();
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            int hashCode2 = topActivity.hashCode();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(hashCode2);
            return sb6.toString();
        }
        return "";
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "PSLink-QZoneFeedAnimScroller";
    }

    @Override // hh.b
    public void j() {
        super.j();
        com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.b("qzone" + r(), "");
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        if (newState == 0) {
            com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.d("qzone" + r(), "");
            return;
        }
        com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.b("qzone" + r(), "");
    }

    @Override // hh.b
    public void onResume() {
        super.onResume();
        com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.d("qzone" + r(), "");
    }
}
