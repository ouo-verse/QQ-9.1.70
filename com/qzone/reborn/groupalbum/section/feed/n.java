package com.qzone.reborn.groupalbum.section.feed;

import android.content.Context;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellMediaInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/groupalbum/section/feed/n;", "Lvg/a;", "Landroid/content/Context;", "context", "", "I", "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class n extends vg.a {
    private final void I(Context context) {
        CellMediaInfo cellMediaInfo;
        CellGroupAlbumInfo cellGroupAlbumInfo;
        BusinessFeedData businessFeedData = this.f441565h;
        String str = null;
        String str2 = (businessFeedData == null || (cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo) == null) ? null : cellGroupAlbumInfo.groupId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        BusinessFeedData businessFeedData2 = this.f441565h;
        if (businessFeedData2 != null && (cellMediaInfo = businessFeedData2.cellMediaInfo) != null) {
            str = cellMediaInfo.albumId;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        String str3 = this.f441565h.cellGroupAlbumInfo.groupId;
        Intrinsics.checkNotNullExpressionValue(str3, "mFeedData.cellGroupAlbumInfo.groupId");
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(str3);
        String str4 = this.f441565h.cellMediaInfo.albumId;
        Intrinsics.checkNotNullExpressionValue(str4, "mFeedData.cellMediaInfo.albumId");
        groupAlbumAlbumDetailInitBean.setAlbumId(str4);
        String str5 = this.f441565h.cellMediaInfo.albumName;
        Intrinsics.checkNotNullExpressionValue(str5, "mFeedData.cellMediaInfo.albumName");
        groupAlbumAlbumDetailInitBean.setAlbumName(str5);
        ho.i.m().h(context, groupAlbumAlbumDetailInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.I(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    public void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        containerView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.J(n.this, view);
            }
        });
    }
}
