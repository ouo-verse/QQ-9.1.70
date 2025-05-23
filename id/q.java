package id;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumCreateAlbumInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lid/q;", "Lid/b;", "Landroid/content/Context;", "context", "", "content", "", HippyTKDListViewAdapter.X, "", "Lhd/b;", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final q f407516a = new q();

    q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.m().i(context, new GroupAlbumMainPageInitBean("111756453"));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.m().h(context, new GroupAlbumAlbumDetailInitBean("111756453"));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        boolean z16 = context instanceof Activity;
        Dialog createDialog = ActionSheetHelper.createDialog(z16 ? (Activity) context : null, null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(com.qzone.util.l.a(R.string.f1330250), 1);
            actionSheet.addButton(com.qzone.util.l.a(R.string.f132954t), 1);
            actionSheet.addButton(com.qzone.util.l.a(R.string.f133004y), 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: id.o
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    q.r(context, actionSheet, view2, i3);
                }
            });
            ef.d.f(actionSheet, z16 ? (Activity) context : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Context context, ActionSheet this_run, View view, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        q qVar = f407516a;
        String content = this_run.getContent(i3);
        Intrinsics.checkNotNullExpressionValue(content, "this.getContent(which)");
        qVar.x(context, content);
        this_run.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        GroupAlbumCreateAlbumDialog groupAlbumCreateAlbumDialog = new GroupAlbumCreateAlbumDialog(context, new GroupAlbumCreateAlbumInitBean("111756453"));
        groupAlbumCreateAlbumDialog.r0(new GroupAlbumCreateAlbumDialog.a() { // from class: id.p
            @Override // com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog.a
            public final void a(boolean z16, AlbumInfo albumInfo) {
                q.t(z16, albumInfo);
            }
        });
        groupAlbumCreateAlbumDialog.show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.V("r30FCAO69lCgkzXUozpIKg!!");
        commonAlbumInfo.m0("test");
        ho.i.m().n(context, new GroupUploadAlbumInitBean("1127385111", 0, true, commonAlbumInfo, 0, 16, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.m().m(context, new GroupAlbumTaskDetailInitBean("552739950", "zaki", 0));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.m().k(context, new GroupAlbumNoticeInitBean("667213719"));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u4e3b\u9875", new View.OnClickListener() { // from class: id.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.o(context, view);
            }
        }));
        arrayList.add(new hd.a("\u76f8\u518c\u8be6\u60c5\u9875", new View.OnClickListener() { // from class: id.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.p(context, view);
            }
        }));
        arrayList.add(new hd.a("\u76f8\u518c\u7f16\u8f91\u9875", new View.OnClickListener() { // from class: id.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.q(context, view);
            }
        }));
        arrayList.add(new hd.a("\u521b\u5efa\u76f8\u518c\u5f39\u7a97", new View.OnClickListener() { // from class: id.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.s(context, view);
            }
        }));
        arrayList.add(new hd.a("\u7fa4\u76f8\u518c\u4e0a\u4f20\u9875", new View.OnClickListener() { // from class: id.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.u(context, view);
            }
        }));
        arrayList.add(new hd.a("\u7fa4\u76f8\u518c\u4efb\u52a1\u9875", new View.OnClickListener() { // from class: id.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.v(context, view);
            }
        }));
        arrayList.add(new hd.a("\u7fa4\u76f8\u518c\u6d88\u606f\u9875", new View.OnClickListener() { // from class: id.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.w(context, view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.d("AIO\u7fa4\u76f8\u518c\u5165\u53e3\u6539\u4e3anative\u8df3\u8f6c", "KEY_OPEN_NEW_AIO_GROUP_ALBUM_ENTRANCE", false, null, 8, null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(boolean z16, AlbumInfo albumInfo) {
        String str;
        if (albumInfo == null) {
            str = "";
        } else {
            str = "name:" + albumInfo.name + ", desc:" + albumInfo.desc + ", spaceId:" + albumInfo.owner;
        }
        QLog.d(QZoneOptAlbumRequest.FIELD_CMD_CREATE, 1, "isSuccess" + z16 + ", albumInfo -> " + str);
    }

    private final void x(Context context, String content) {
        if (Intrinsics.areEqual(content, com.qzone.util.l.a(R.string.f1330250))) {
            oi.c m3 = ho.i.m();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            m3.d((Activity) context, 0, new CommonAlbumEditInitBean("111756453", new CommonAlbumInfo(), true, true, false));
        } else {
            if (Intrinsics.areEqual(content, com.qzone.util.l.a(R.string.f132954t))) {
                return;
            }
            Intrinsics.areEqual(content, com.qzone.util.l.a(R.string.f133004y));
        }
    }
}
