package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import android.view.View;
import com.qzone.reborn.feedpro.section.QzoneFeedProHeadSection;
import com.qzone.reborn.feedpro.section.QzoneFeedProSmallTailSection;
import com.qzone.reborn.feedpro.section.am;
import com.qzone.reborn.feedpro.section.ap;
import com.qzone.reborn.feedpro.section.at;
import com.qzone.reborn.feedpro.section.bc;
import com.qzone.reborn.feedpro.section.bf;
import com.qzone.reborn.feedpro.section.u;
import com.qzone.reborn.feedpro.section.z;
import com.tencent.mobileqq.R;
import de.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/QzoneFeedProForwardMixPicVideoItemView;", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "Lde/f;", "", "getLayoutId", "", "getLogTag", "", "Ljava/lang/Class;", "Lne/a;", "r0", "", "play", "pause", "a", "Landroid/view/View;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProForwardMixPicVideoItemView extends QzoneBaseFeedProItemView implements f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProForwardMixPicVideoItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // de.f
    public void a() {
        Iterator<ne.a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            vg.c cVar = (ne.a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).a();
            }
        }
    }

    @Override // de.f
    public View d() {
        Iterator<ne.a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            vg.c cVar = (ne.a) it.next();
            if (cVar instanceof f) {
                return ((f) cVar).d();
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130037o;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QzoneFeedProForwardMixPicVideoItemView";
    }

    @Override // de.f
    public void pause() {
        Iterator<ne.a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            vg.c cVar = (ne.a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).pause();
            }
        }
    }

    @Override // de.f
    public void play() {
        Iterator<ne.a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            vg.c cVar = (ne.a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).play();
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected List<Class<? extends ne.a>> r0() {
        List<Class<? extends ne.a>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(QzoneFeedProHeadSection.class, bf.class, z.class, ap.class, QzoneFeedProSmallTailSection.class, at.class, bc.class, am.class, u.class);
        mutableListOf.addAll(com.qzone.reborn.feedpro.utils.ap.f54313a.a(q0()));
        return mutableListOf;
    }
}
