package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.NegativeItem;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRecomInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0000\u001a\u0016\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u0000\u001a\f\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0000\u001a<\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u001a\u0010\u001c\u001a\u00020\u001b*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0000\u001a\"\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e\u001a\n\u0010$\u001a\u00020\u0004*\u00020\u0000\" \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010%\u00a8\u0006'"}, d2 = {"Lfeedcloud/FeedCloudMeta$StFeed;", "", "c", "other", "", "f", "otherFeedId", "g", "Lorg/json/JSONObject;", "d", "Lkotlin/Pair;", "", "b", "a", h.F, "Landroid/view/View;", "view", "Landroid/graphics/drawable/Drawable;", "feedCoverDrawable", "from", "", "playPosition", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "k", "coverUrl", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "l", "i", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/NegativeItem;", "Lkotlin/collections/ArrayList;", "j", "e", "Lkotlin/Pair;", "DEFAULT_RATIO", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Pair<Integer, Integer> f86733a = new Pair<>(3, 4);

    @Nullable
    public static final JSONObject a(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        byte[] bArr;
        boolean z16;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feedCloudMeta$StFeed.recomInfo;
        if (feedCloudMeta$StRecomInfo != null && (pBBytesField = feedCloudMeta$StRecomInfo.clientSealData) != null && (byteStringMicro = pBBytesField.get()) != null) {
            bArr = byteStringMicro.toByteArray();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        try {
            return new JSONObject(new String(bArr, Charsets.UTF_8));
        } catch (JSONException e16) {
            QLog.e("FeedCloudMeta.StFeedExt", 1, "getClientSealDataJson parse error, e=" + e16 + ", e");
            return null;
        }
    }

    @NotNull
    public static final Pair<Integer, Integer> b(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Pair<Integer, Integer> pair;
        String optString;
        List split$default;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        try {
            JSONObject a16 = a(feedCloudMeta$StFeed);
            if (a16 != null && (optString = a16.optString("cover_ratio")) != null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{":"}, false, 0, 6, (Object) null);
                pair = new Pair<>(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), Integer.valueOf(Integer.parseInt((String) split$default.get(1))));
            } else {
                pair = f86733a;
            }
            return pair;
        } catch (Throwable th5) {
            QLog.e("FeedCloudMeta.StFeedExt", 1, "getCoverRatio error, feed=" + feedCloudMeta$StFeed.f398449id.get() + ", e=" + th5.getMessage(), th5);
            return f86733a;
        }
    }

    @NotNull
    public static final String c(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String removePrefix;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        String str = feedCloudMeta$StFeed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.id.get()");
        removePrefix = StringsKt__StringsKt.removePrefix(str, (CharSequence) "share_fake_");
        return removePrefix;
    }

    @NotNull
    public static final JSONObject d(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String optString;
        JSONObject a16;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        JSONObject a17 = a(feedCloudMeta$StFeed);
        if (a17 == null || (optString = a17.optString("mask_task_info")) == null || (a16 = b.a(optString)) == null) {
            return new JSONObject();
        }
        return a16;
    }

    public static final boolean e(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        PBUInt32Field pBUInt32Field = feedCloudMeta$StFeed.feedType;
        if (pBUInt32Field == null || pBUInt32Field.get() != 4) {
            return false;
        }
        return true;
    }

    public static final boolean f(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NotNull FeedCloudMeta$StFeed other) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(c(feedCloudMeta$StFeed), c(other));
    }

    public static final boolean g(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @Nullable String str) {
        String str2;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        String c16 = c(feedCloudMeta$StFeed);
        if (str != null) {
            str2 = StringsKt__StringsKt.removePrefix(str, (CharSequence) "share_fake_");
        } else {
            str2 = null;
        }
        return Intrinsics.areEqual(c16, str2);
    }

    public static final boolean h(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        return !feedCloudMeta$StFeed.opMask2.get().contains(43);
    }

    @NotNull
    public static final String i(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        return "id=" + feedCloudMeta$StFeed.f398449id.get() + ", posterId=" + feedCloudMeta$StFeed.poster.f398463id.get() + ", createTime=" + feedCloudMeta$StFeed.createTime.get();
    }

    @NotNull
    public static final ArrayList<NegativeItem> j(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<NegativeItem> arrayList = new ArrayList<>();
        try {
            List<Integer> list = new QQCircleFeedBase$StFeedBusiReqData().mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray()).uninterest_buttons.get();
            if (list.contains(1)) {
                String string = context.getString(R.string.f184003kp);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_feedback_hide_this_work)");
                arrayList.add(new NegativeItem(string, 3));
            }
            if (list.contains(2)) {
                String string2 = context.getString(R.string.f183983kn);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_feedback_hide_his_works)");
                arrayList.add(new NegativeItem(string2, 4));
            }
            if (list.contains(3)) {
                String string3 = context.getString(R.string.f183993ko);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_hide_this_kind_of_works)");
                arrayList.add(new NegativeItem(string3, 2));
            }
            if (list.contains(7)) {
                String string4 = context.getString(R.string.f184013kq);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026ive_feedback_low_quality)");
                arrayList.add(new NegativeItem(string4, 5));
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("FeedCloudMeta.StFeedExt", 1, "toNegativeItemList failed, e=" + e16.getMessage(), e16);
        }
        if (arrayList.isEmpty()) {
            String string5 = context.getString(R.string.f184003kp);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026_feedback_hide_this_work)");
            arrayList.add(new NegativeItem(string5, 3));
        }
        return arrayList;
    }

    @NotNull
    public static final QCircleLayerBean k(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @Nullable View view, @Nullable Drawable drawable, @NotNull String from, long j3, @NotNull QCircleInitBean initBean) {
        QFSTransitionAnimBean qFSTransitionAnimBean;
        String str;
        HashMap<String, String> hashMapOf;
        int i3;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (view != null && drawable != null) {
            String str2 = feedCloudMeta$StFeed.cover.picUrl.get();
            Intrinsics.checkNotNullExpressionValue(str2, "cover.picUrl.get()");
            qFSTransitionAnimBean = l(view, str2, drawable);
        } else {
            qFSTransitionAnimBean = null;
        }
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean);
        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
        boolean z16 = true;
        qCircleLayerBean.setGetFeedList(true);
        qCircleLayerBean.setLaunchFrom(from);
        qCircleLayerBean.setActionBean(initBean.getActionBean());
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(QCircleScheme.AttrDetail.ENABLE_REFRESH, "1");
        pairArr[1] = TuplesKt.to("feedid", feedCloudMeta$StFeed.f398449id.get());
        pairArr[2] = TuplesKt.to(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(j3));
        if (an.d(initBean)) {
            str = QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
        } else {
            str = "pg_xsj_gzh_page";
        }
        pairArr[3] = TuplesKt.to("xsj_custom_pgid", str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        qCircleLayerBean.setSchemeAttrs(hashMapOf);
        HashMap<String, String> schemeAttrs = initBean.getSchemeAttrs();
        if (schemeAttrs != null && !schemeAttrs.isEmpty()) {
            z16 = false;
        }
        if (!z16 && initBean.getSchemeAttrs().containsKey("xsj_main_entrance")) {
            HashMap<String, String> schemeAttrs2 = qCircleLayerBean.getSchemeAttrs();
            Intrinsics.checkNotNullExpressionValue(schemeAttrs2, "schemeAttrs");
            schemeAttrs2.put("xsj_main_entrance", initBean.getSchemeAttrs().get("xsj_main_entrance"));
        }
        if (an.d(initBean)) {
            i3 = 85;
        } else {
            i3 = 61;
        }
        qCircleLayerBean.setSourceType(i3);
        return qCircleLayerBean;
    }

    @NotNull
    public static final QFSTransitionAnimBean l(@NotNull View view, @NotNull String coverUrl, @NotNull Drawable feedCoverDrawable) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(feedCoverDrawable, "feedCoverDrawable");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        QFSTransitionAnimBean.SourceRect sourceRect = new QFSTransitionAnimBean.SourceRect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        qFSTransitionAnimBean.setLayoutRect(sourceRect);
        qFSTransitionAnimBean.setScaleType(ImageView.ScaleType.CENTER_CROP);
        qFSTransitionAnimBean.setTransitionDelayTimeMs(0);
        qFSTransitionAnimBean.setTransitionDurationMs(200);
        qFSTransitionAnimBean.setEnterAnimFadeCoverTimeMs(300);
        qFSTransitionAnimBean.setImageUrl(coverUrl);
        qFSTransitionAnimBean.setCoverDrawable(feedCoverDrawable);
        return qFSTransitionAnimBean;
    }
}
