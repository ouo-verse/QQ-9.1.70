package com.qzone.reborn.feedx.widget.eventtag;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedpro.utils.d;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import fo.b;
import fo.c;
import ho.i;
import ho.m;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\u000fH\u0004J\b\u0010\u0011\u001a\u00020\u000fH\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagBaseItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "", "contentHeight", "titleLineCount", "r0", "Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagItemBottomView;", "bottomView", "", "n0", "Landroid/view/View;", "view", "u0", "o0", "", "q0", "p0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneEventTagBaseItemView extends QZoneBaseWidgetView<BusinessFeedData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final int f56075f = ar.e(24.0f);

    /* renamed from: h, reason: collision with root package name */
    private static final int f56076h = ar.e(32.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final float f56077i = ar.e(7.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagBaseItemView$a;", "", "", "ROUND_RADIUS", UserInfo.SEX_FEMALE, "a", "()F", "DEFAULT_LINE_SPACE", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return QZoneEventTagBaseItemView.f56077i;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagBaseItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void n0(QZoneEventTagItemBottomView bottomView) {
        Intrinsics.checkNotNullParameter(bottomView, "bottomView");
        bottomView.setData(getData());
    }

    public final void o0(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        String str = getData().getFeedCommInfo().feedsid;
        if (str == null) {
            str = "";
        }
        hashMap.put("feedid", str);
        hashMap.put("pic_id", p0());
        hashMap.put("video_id", q0());
        hashMap.put("framer_uin", Long.valueOf(getData().getUser().uin));
        c.o(view, "em_qz_feed", new b().l(hashMap).i(getData().getFeedCommInfo().feedsid));
    }

    protected final String p0() {
        CellPictureInfo pictureInfo = getData().getPictureInfo();
        if (bl.b(pictureInfo != null ? pictureInfo.pics : null)) {
            return "";
        }
        PictureItem pictureItem = getData().getPictureInfo().pics.get(0);
        String str = pictureItem != null ? pictureItem.lloc : null;
        return str == null ? "" : str;
    }

    protected final String q0() {
        String str;
        ArrayList<PictureItem> arrayList;
        if (getData().getVideoInfo() != null) {
            VideoInfo videoInfo = getData().getVideoInfo();
            str = videoInfo != null ? videoInfo.videoId : null;
            if (str == null) {
                return "";
            }
        } else {
            CellPictureInfo pictureInfo = getData().getPictureInfo();
            if (bl.b(pictureInfo != null ? pictureInfo.pics : null)) {
                return "";
            }
            CellPictureInfo pictureInfo2 = getData().getPictureInfo();
            boolean z16 = false;
            PictureItem pictureItem = (pictureInfo2 == null || (arrayList = pictureInfo2.pics) == null) ? null : arrayList.get(0);
            if (pictureItem != null && pictureItem.videoflag == 1) {
                z16 = true;
            }
            if (!z16) {
                return "";
            }
            VideoInfo videoInfo2 = pictureItem.videodata;
            str = videoInfo2 != null ? videoInfo2.videoId : null;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public final int r0(int contentHeight, int titleLineCount) {
        if (TextUtils.isEmpty(n.e(getData()))) {
            return contentHeight + f56076h;
        }
        return contentHeight + f56076h + (f56075f * titleLineCount);
    }

    public final void u0(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(getContext() instanceof Activity)) {
            QLog.e("BaseWidgetView", 1, "onClickFeedDetail context is not Activity");
            return;
        }
        if (getData().isFakeFeed()) {
            QLog.e("BaseWidgetView", 1, "onClickFeedDetail feed isFakeFeed");
            return;
        }
        rh.c cVar = rh.c.f431447a;
        CellPictureInfo pictureInfo = getData().getPictureInfo();
        cVar.c(pictureInfo != null ? pictureInfo.pics : null);
        if (d.f54318a.b()) {
            m f16 = i.f();
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            BusinessFeedData data = getData();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            f16.e((Activity) context, data, view, 17);
            return;
        }
        ho.c e16 = i.e();
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        e16.c((Activity) context2, getData(), view, 17);
    }

    public static /* synthetic */ int s0(QZoneEventTagBaseItemView qZoneEventTagBaseItemView, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i16 = 1;
            }
            return qZoneEventTagBaseItemView.r0(i3, i16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoundContainerViewHeight");
    }
}
