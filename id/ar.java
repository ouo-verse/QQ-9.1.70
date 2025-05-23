package id;

import android.content.Context;
import android.view.View;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lid/ar;", "Lid/b;", "Lhd/b;", "p", "Landroid/content/Context;", "context", "", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ar extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final ar f407475a = new ar();

    ar() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZoneUploadRecommendDirector.INSTANCE.a().deleteAll();
        com.qzone.reborn.util.o.f59556a.a("\u5220\u9664\u6210\u529f");
        o7.c.f(false);
        o7.c.e(false);
        com.qzone.reborn.albumx.qzone.local.g.f52662a.o(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZoneUploadRecommendDirector.INSTANCE.a().startRecommend();
        com.qzone.reborn.util.o.f59556a.a("\u5f00\u59cb\u63a8\u8350");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZoneUploadRecommendDirector.INSTANCE.a().stopRecommend();
        com.qzone.reborn.util.o.f59556a.a("\u6682\u505c\u63a8\u8350");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZoneUploadRecommendDirector.INSTANCE.a().reInit();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZoneUploadRecommendDirector.INSTANCE.a().testClassify();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b p() {
        return new hd.d("\u663e\u793a\u63a8\u8350\u7167\u7247debug\u4fe1\u606f", "KEY_SHOW_RECOMMEND_PHOTO_DEBUG_INFO", false, null, 8, null);
    }

    @Override // id.b
    public List<hd.b> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u5220\u9664\u626b\u63cf\u8bb0\u5f55", new View.OnClickListener() { // from class: id.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.k(view);
            }
        }));
        arrayList.add(new hd.a("\u91cd\u65b0\u5f00\u59cb", new View.OnClickListener() { // from class: id.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.l(view);
            }
        }));
        arrayList.add(new hd.a("\u6682\u505c", new View.OnClickListener() { // from class: id.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.m(view);
            }
        }));
        arrayList.add(new hd.a("\u91cd\u65b0\u521d\u59cb\u5316", new View.OnClickListener() { // from class: id.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.n(view);
            }
        }));
        arrayList.add(new hd.a("\u6d4b\u8bd5\u805a\u7c7b\u67e5\u8be2", new View.OnClickListener() { // from class: id.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.o(view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(p());
        return arrayList;
    }
}
