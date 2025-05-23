package com.qzone.reborn.groupalbum.part.myalbum;

import aa.f;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMyAlbumInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/groupalbum/part/myalbum/b;", "Lcom/qzone/reborn/base/k;", "", "D9", "Landroid/view/View;", "view", "F9", "G9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "getLogTag", "d", "Ljava/lang/String;", "groupId", "e", "albumId", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mIvGroupAlbumListView", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String groupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String albumId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvGroupAlbumListView;

    public b(String str, String str2) {
        this.groupId = str;
        this.albumId = str2;
        RFWLog.i("GroupAlbumMyAlbumBtnPart", RFWLog.USR, "init, groupId:" + str + ", albumId:" + str2);
        if (str == null || str.length() == 0) {
            RFWLog.fatal("GroupAlbumMyAlbumBtnPart", RFWLog.USR, new RuntimeException("groupId should not be null or empty"));
        }
    }

    private final void D9() {
        String str = this.groupId;
        if (str == null || str.length() == 0) {
            return;
        }
        GroupAlbumMyAlbumInitBean groupAlbumMyAlbumInitBean = new GroupAlbumMyAlbumInitBean(this.groupId);
        oi.c m3 = i.m();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m3.j(context, groupAlbumMyAlbumInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        this$0.F9(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumMyAlbumBtnPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.l75);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_group_album_list)");
        ImageView imageView = (ImageView) findViewById;
        this.mIvGroupAlbumListView = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvGroupAlbumListView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.myalbum.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.E9(b.this, view);
            }
        });
        ImageView imageView3 = this.mIvGroupAlbumListView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvGroupAlbumListView");
            imageView3 = null;
        }
        rn.h.a(imageView3, "qui_group", R.color.qui_common_icon_nav_secondary);
        f.Companion companion = aa.f.INSTANCE;
        ImageView imageView4 = this.mIvGroupAlbumListView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvGroupAlbumListView");
        } else {
            imageView2 = imageView4;
        }
        companion.a(imageView2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        G9(getPartRootView());
    }

    private final void F9(View view) {
        if (view == null) {
            return;
        }
        fo.c.d("em_qz_all_group_albums", "pg_qz_group_dynamic_tab", view);
    }

    private final void G9(View view) {
        if (view == null) {
            return;
        }
        fo.c.f("em_qz_all_group_albums", "pg_qz_group_dynamic_tab", view);
    }
}
