package id;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lid/bv;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bv extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bv f407501a = new bv();

    bv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = new QZAlbumxMainPageInitBean(uinString);
        vb.b x16 = ho.i.x();
        Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
        vb.b.j(x16, context, qZAlbumxMainPageInitBean, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(uinString);
        qZAlbumxAlbumDetailInitBean.setAlbumId("V52UtE9B475hhj1Ik0xa1G57Xl0gQoIU");
        qZAlbumxAlbumDetailInitBean.setAlbumName("\u624b\u673a\u76f8\u518c");
        ho.i.x().g(context, qZAlbumxAlbumDetailInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean = new QZAlbumxInvitePageInitBean(uinString);
        qZAlbumxInvitePageInitBean.setAlbumId("V52UtE9B475hhj1Ik0xa1G57Xl381Ekr");
        qZAlbumxInvitePageInitBean.setAlbumName("\u624b\u673a\u76f8\u518c");
        qZAlbumxInvitePageInitBean.setAlbumOwner("2830116175");
        qZAlbumxInvitePageInitBean.setJoinAttachInfo("kooQOOP0bCbDIdo1P21P-HfF5MBgGBYMZdC2qKOD_t2Kw6Jh60UUf0wd");
        qZAlbumxInvitePageInitBean.setPageType(0);
        ho.i.x().h(context, qZAlbumxInvitePageInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = new QZAlbumxAnswerCheckPageInitBean(uinString);
        qZAlbumxAnswerCheckPageInitBean.setAlbumId("V52UtE9B475hhj1Ik0xa1G57Xl3FNH0w");
        String uinString2 = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString2, "getInstance().uinString");
        qZAlbumxAnswerCheckPageInitBean.setOwnerUin(uinString2);
        ho.i.x().d((Activity) context, 0, qZAlbumxAnswerCheckPageInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u4e3b\u9875", new View.OnClickListener() { // from class: id.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bv.j(context, view);
            }
        }));
        arrayList.add(new hd.a("\u76f8\u518c\u8be6\u60c5\u9875", new View.OnClickListener() { // from class: id.bs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bv.k(context, view);
            }
        }));
        arrayList.add(new hd.a("\u9080\u8bf7\u8be6\u60c5\u9875", new View.OnClickListener() { // from class: id.bt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bv.l(context, view);
            }
        }));
        arrayList.add(new hd.a("\u95ee\u9898\u9a8c\u8bc1\u9875", new View.OnClickListener() { // from class: id.bu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bv.m(context, view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.d("\u7a7a\u95f4\u76f8\u518c\u5165\u53e3\u6539\u4e3a\u8df3\u8f6c\u65b0\u7248", "KEY_OPEN_NEW_QZONE_ALBUMX_ENTRANCE", true, null, 8, null));
        return arrayList;
    }
}
