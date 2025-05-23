package com.qzone.reborn.feedpro.itemview.ad;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import de.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.l;
import ne.a;
import ne.b;
import vg.c;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/ad/QZoneAdVideoFeedProItemView;", "Lcom/qzone/reborn/feedpro/itemview/ad/QZoneAdBaseFeedProItemView;", "Lde/f;", "", "getLogTag", "", "Ljava/lang/Class;", "Lne/a;", "r0", "", "play", "pause", "a", "Landroid/view/View;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneAdVideoFeedProItemView extends QZoneAdBaseFeedProItemView implements f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdVideoFeedProItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // de.f
    public void a() {
        b bVar = this.f53916e;
        if (bVar == null || bVar.f() == null) {
            return;
        }
        Iterator<a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).a();
            }
        }
    }

    @Override // de.f
    public View d() {
        b bVar = this.f53916e;
        if (bVar != null && bVar.f() != null) {
            Iterator<a> it = this.f53916e.f().iterator();
            while (it.hasNext()) {
                c cVar = (a) it.next();
                if (cVar instanceof f) {
                    return ((f) cVar).d();
                }
            }
        }
        return null;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneAdVideoFeedProItemView";
    }

    @Override // de.f
    public void pause() {
        b bVar = this.f53916e;
        if (bVar == null || bVar.f() == null) {
            return;
        }
        Iterator<a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).pause();
            }
        }
    }

    @Override // de.f
    public void play() {
        b bVar = this.f53916e;
        if (bVar == null || bVar.f() == null) {
            return;
        }
        Iterator<a> it = this.f53916e.f().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof f) {
                ((f) cVar).play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.itemview.ad.QZoneAdBaseFeedProItemView, com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    public List<Class<? extends a>> r0() {
        List<Class<? extends a>> r06 = super.r0();
        r06.add(l.class);
        return r06;
    }
}
