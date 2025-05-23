package com.qzone.reborn.feedx.util;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagItemPicView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagItemTextView;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagItemVideoView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedx/util/QZoneFeedEventTagItemViewFactory;", "", "", "c", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/reborn/feedx/util/QZoneFeedEventTagItemViewFactory$ItemType;", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "a", "<init>", "()V", "ItemType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedEventTagItemViewFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneFeedEventTagItemViewFactory f55699a = new QZoneFeedEventTagItemViewFactory();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/feedx/util/QZoneFeedEventTagItemViewFactory$ItemType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TEXT", "PICTURE", "VIDEO", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum ItemType {
        TEXT(1),
        PICTURE(2),
        VIDEO(3);

        private final int type;

        ItemType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    QZoneFeedEventTagItemViewFactory() {
    }

    public final QZoneBaseWidgetView<BusinessFeedData> a(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == ItemType.VIDEO.getType()) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new QZoneEventTagItemVideoView(context);
        }
        if (viewType == ItemType.PICTURE.getType()) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return new QZoneEventTagItemPicView(context2);
        }
        Context context3 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
        return new QZoneEventTagItemTextView(context3);
    }

    public final ItemType b(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        CellPictureInfo pictureInfo = feedData.getPictureInfo();
        ArrayList<PictureItem> arrayList = pictureInfo != null ? pictureInfo.pics : null;
        if (feedData.getVideoInfo() != null) {
            return ItemType.VIDEO;
        }
        if (bl.b(arrayList)) {
            return ItemType.TEXT;
        }
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.get(0).videoflag == 1) {
            return ItemType.VIDEO;
        }
        return ItemType.PICTURE;
    }

    public final int c() {
        return ItemType.values().length;
    }
}
