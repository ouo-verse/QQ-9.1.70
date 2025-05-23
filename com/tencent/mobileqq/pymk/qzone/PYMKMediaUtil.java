package com.tencent.mobileqq.pymk.qzone;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MediaInfo;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.pymk.PYMKBusiData;
import com.tencent.mobileqq.pymk.PYMKMedia;
import com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.troop.findtroop.TabRecommendPB$MediaInfo;
import tencent.im.troop.findtroop.TabRecommendPB$PersonExtraInfo;
import tl.h;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u00022-B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\u0011\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010 \u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J,\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\"`#2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J,\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\"`#2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)H\u0002J$\u0010-\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J$\u00102\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u0010\u00103\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R0\u0010>\u001a\u001e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020;0!j\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020;`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010BR$\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00160Dj\b\u0012\u0004\u0012\u00020\u0016`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010FR\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/pymk/qzone/PYMKMediaUtil;", "Lcom/tencent/mobileqq/pymk/api/b;", "Landroid/view/View$OnClickListener;", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recFriendData", "", "u", "Landroid/view/View;", "mediaLayout", "t", "v", "Lkotlin/Function0;", "callback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "recommendData", "w", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", h.F, "", "url", "Landroid/widget/ImageView;", "view", "Lcom/tencent/libra/request/Option;", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "isClick", "isJumpSuccess", "k", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "p", DomainData.DOMAIN_NAME, "value", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "l", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "pymkItem", "Landroid/os/Bundle;", "extras", "a", NodeProps.ON_CLICK, "d", "Z", "isShowQZone", "Lcom/tencent/mobileqq/data/QZoneInfo;", "e", "Lcom/tencent/mobileqq/data/QZoneInfo;", "qZoneInfo", "Ltencent/im/troop/findtroop/TabRecommendPB$PersonExtraInfo;", "f", "Ljava/util/HashMap;", "uinToExtraInfo", "Landroid/graphics/drawable/Drawable;", "picDefaultDrawable", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "qZonePicURLDrawableOptions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "exposureMediaUins", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "<init>", "()V", "D", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PYMKMediaUtil implements com.tencent.mobileqq.pymk.api.b, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private Bundle extras;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShowQZone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneInfo qZoneInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Long, TabRecommendPB$PersonExtraInfo> uinToExtraInfo = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Drawable picDefaultDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final URLDrawable.URLDrawableOptions qZonePicURLDrawableOptions;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashSet<String> exposureMediaUins;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/pymk/qzone/PYMKMediaUtil$b;", "", "", "a", "Z", "()Z", "setHasResetLargeSize", "(Z)V", "hasResetLargeSize", "<init>", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasResetLargeSize;

        public b() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasResetLargeSize() {
            return this.hasResetLargeSize;
        }

        public b(boolean z16) {
            this.hasResetLargeSize = z16;
        }

        public /* synthetic */ b(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    public PYMKMediaUtil() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.qZonePicURLDrawableOptions = obtain;
        this.exposureMediaUins = new HashSet<>();
        this.extras = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PYMKMediaUtil this$0, View mediaLayout, MayKnowRecommend mayKnowRecommend) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(mediaLayout, "mediaLayout");
        this$0.k(mediaLayout, mayKnowRecommend, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ImageView imageView, ImageView imageView2, LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_SUCCESS) {
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k(View view, MayKnowRecommend recFriendData, boolean isClick, boolean isJumpSuccess) {
        HashMap<String, Object> n3;
        String str;
        int i3 = view.getVisibility() == 8 ? 1 : 0;
        if (i3 == 0) {
            if (isClick || !this.exposureMediaUins.contains(recFriendData.uin)) {
                this.exposureMediaUins.add(recFriendData.uin);
                VideoReport.setElementId(view, "em_bas_space_dynamic_entry");
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
                if (v(recFriendData)) {
                    n3 = p(recFriendData);
                } else {
                    n3 = n(recFriendData);
                }
                String str2 = recFriendData.uin;
                Intrinsics.checkNotNullExpressionValue(str2, "recFriendData.uin");
                n3.put("to_uin", str2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                n3.put("is_place_holder", sb5.toString());
                if (isClick) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(isJumpSuccess ? 1 : 0);
                    n3.put("is_transfer", sb6.toString());
                }
                byte[] bArr = recFriendData.algBuffer;
                if (bArr != null) {
                    Intrinsics.checkNotNullExpressionValue(bArr, "recFriendData.algBuffer");
                    if (((bArr.length == 0) ^ true) != false) {
                        byte[] bArr2 = recFriendData.algBuffer;
                        Intrinsics.checkNotNullExpressionValue(bArr2, "recFriendData.algBuffer");
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        n3.put("algo_id", new String(bArr2, UTF_8));
                    }
                }
                String str3 = recFriendData.recommendReason;
                Intrinsics.checkNotNullExpressionValue(str3, "recFriendData.recommendReason");
                n3.put("recommend_reason", str3);
                n3.put("user_request_subsourceid", String.valueOf(this.extras.getInt("user_request_subsourceid", 0)));
                n3.put("user_request_sourceid", "3045");
                if (isClick) {
                    str = "clck";
                } else {
                    str = "imp";
                }
                VideoReport.reportEvent(str, view, n3);
            }
        }
    }

    private final Drawable l(Context context) {
        if (this.picDefaultDrawable == null) {
            ColorDrawable colorDrawable = new ColorDrawable(context.getResources().getColor(R.color.qui_common_fill_standard_primary));
            this.picDefaultDrawable = colorDrawable;
            URLDrawable.URLDrawableOptions uRLDrawableOptions = this.qZonePicURLDrawableOptions;
            uRLDrawableOptions.mFailedDrawable = colorDrawable;
            uRLDrawableOptions.mLoadingDrawable = colorDrawable;
        }
        return this.picDefaultDrawable;
    }

    private final HashMap<String, Object> n(MayKnowRecommend recFriendData) {
        int i3;
        int i16;
        HashMap<String, Object> hashMap = new HashMap<>();
        List<PYMKBusiData> list = recFriendData.busiDataList;
        int i17 = 0;
        if (list == null || list.isEmpty()) {
            return hashMap;
        }
        ArrayList<PYMKMedia> arrayList = recFriendData.busiDataList.get(0).medias;
        int size = arrayList.size();
        if (size > 0) {
            int i18 = 0;
            i3 = 0;
            i16 = 0;
            while (i17 < size) {
                int i19 = arrayList.get(i17).mediaType;
                if (i19 == 1) {
                    i18++;
                } else if (i19 == 2) {
                    i3++;
                } else if (i19 == 3) {
                    i16++;
                }
                i17++;
            }
            i17 = i18;
        } else {
            i3 = 0;
            i16 = 0;
        }
        hashMap.put("feedid", "");
        hashMap.put("materials_number", String.valueOf(size));
        hashMap.put("pic_cnt", Integer.valueOf(i17));
        hashMap.put("video_number", String.valueOf(i3));
        hashMap.put("talk_number", String.valueOf(i16));
        hashMap.put("business_type", 2);
        return hashMap;
    }

    private final Option o(String url, ImageView view) {
        Option failedDrawableId = Option.obtain().setUrl(url).setTargetView(view).setLoadingDrawableId(R.drawable.trans).setFailedDrawableId(R.drawable.asd);
        Intrinsics.checkNotNullExpressionValue(failedDrawableId, "obtain()\n            .se\u2026wable.qzone_defaultphoto)");
        return failedDrawableId;
    }

    private final HashMap<String, Object> p(MayKnowRecommend recFriendData) {
        int i3;
        int i16;
        HashMap<String, Object> hashMap = new HashMap<>();
        List<MediaInfo> list = recFriendData.mediaInfos;
        int i17 = 0;
        int size = list == null ? 0 : list.size();
        StringBuilder sb5 = new StringBuilder();
        if (size > 0) {
            int i18 = 0;
            i3 = 0;
            i16 = 0;
            while (i17 < size) {
                MediaInfo mediaInfo = recFriendData.mediaInfos.get(i17);
                int mediaType = mediaInfo.getMediaType();
                if (mediaType == 1) {
                    i18++;
                } else if (mediaType == 2) {
                    i3++;
                } else if (mediaType == 3) {
                    i16++;
                }
                sb5.append(mediaInfo.getReportData());
                sb5.append(",");
                i17++;
            }
            i17 = i18;
        } else {
            i3 = 0;
            i16 = 0;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "feedId.toString()");
        hashMap.put("feedid", sb6);
        hashMap.put("materials_number", String.valueOf(size));
        hashMap.put("pic_cnt", Integer.valueOf(i17));
        hashMap.put("video_number", String.valueOf(i3));
        hashMap.put("talk_number", String.valueOf(i16));
        hashMap.put("business_type", 1);
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(View v3) {
        Object tag = v3.getTag();
        MayKnowRecommend mayKnowRecommend = tag instanceof MayKnowRecommend ? (MayKnowRecommend) tag : 0;
        if (mayKnowRecommend == 0) {
            QLog.e("PYMKMediaUtil", 1, "onQZoneClick. ", (Throwable) mayKnowRecommend);
            return;
        }
        if (v(mayKnowRecommend)) {
            r(v3, mayKnowRecommend);
            return;
        }
        Context context = v3.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        PhotoWallView.jumpToPhotoWall((Activity) context, mayKnowRecommend.uin, false);
        k(v3, mayKnowRecommend, true, true);
    }

    private final void r(View v3, MayKnowRecommend recFriendData) {
        if (TextUtils.isEmpty(recFriendData.qZoneJumpUrl)) {
            QLog.e("PYMKMediaUtil", 1, "onQZoneClick. url is null", recFriendData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PYMKMediaUtil", 2, "onQZoneClick. " + recFriendData.uin + ", " + recFriendData.nick + ", view id: " + v3.getId() + ", JumpUrl: " + recFriendData.qZoneJumpUrl);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ax c16 = bi.c((QQAppInterface) peekAppRuntime, v3.getContext(), recFriendData.qZoneJumpUrl);
        k(v3, recFriendData, true, c16 != null ? c16.b() : false);
    }

    private final long s(String value) {
        try {
            if (TextUtils.isEmpty(value)) {
                return 0L;
            }
            return Long.parseLong(value);
        } catch (NumberFormatException unused) {
            QLog.e("PYMKMediaUtil", 1, "parseLong error " + value);
            return 0L;
        }
    }

    private final void t(View mediaLayout) {
        if (mediaLayout.getVisibility() == 0 && FontSettingManager.isFontSizeLarge()) {
            LinearLayout linearLayout = (LinearLayout) mediaLayout.findViewById(R.id.f166205z00);
            Object tag = linearLayout.getTag();
            b bVar = tag instanceof b ? (b) tag : null;
            if (bVar != null ? bVar.getHasResetLargeSize() : false) {
                return;
            }
            linearLayout.setTag(new b(true));
            FontSettingManager.resetViewSize2Normal(linearLayout.getContext(), linearLayout);
            FontSettingManager.resetViewSize2Normal(linearLayout.getContext(), (ImageView) mediaLayout.findViewById(R.id.yzn));
            FontSettingManager.resetViewSize2Normal(linearLayout.getContext(), (QQProAvatarView) mediaLayout.findViewById(R.id.a2o));
        }
    }

    private final boolean u(MayKnowRecommend recFriendData) {
        List<PYMKBusiData> list = recFriendData.busiDataList;
        return list != null && list.size() > 0;
    }

    private final boolean v(MayKnowRecommend recFriendData) {
        if (!this.isShowQZone || this.qZoneInfo == null || m(recFriendData) == 0) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            String str = recFriendData.uin;
            String str2 = recFriendData.nick;
            QZoneInfo qZoneInfo = this.qZoneInfo;
            Integer valueOf = qZoneInfo != null ? Integer.valueOf(qZoneInfo.getHitExpGroup()) : null;
            String str3 = recFriendData.qZoneJumpUrl;
            int i3 = recFriendData.qZoneFeedsCnt;
            List<MediaInfo> list = recFriendData.mediaInfos;
            QLog.d("PYMKMediaUtil", 4, "controlQZoneView. uin: " + str + ", nick: " + str2 + ", QZoneInfo[HitExpGroup: " + valueOf + "], JumpUrl: " + str3 + ", qZoneFeedsCnt: " + i3 + ", MediaInfoCnt: " + (list == null ? 0 : list.size()) + ".");
        }
        QZoneInfo qZoneInfo2 = this.qZoneInfo;
        return !(qZoneInfo2 != null && qZoneInfo2.getHitExpGroup() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Function0<Unit> callback, CopyOnWriteArrayList<MayKnowRecommend> recommendData) {
        Object clone = recommendData.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = clone instanceof CopyOnWriteArrayList ? (CopyOnWriteArrayList) clone : null;
        if (copyOnWriteArrayList == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = ((MayKnowRecommend) copyOnWriteArrayList.get(i3)).uin;
            Intrinsics.checkNotNullExpressionValue(str, "dataList[i].uin");
            long s16 = s(str);
            TabRecommendPB$PersonExtraInfo tabRecommendPB$PersonExtraInfo = this.uinToExtraInfo.get(Long.valueOf(s16));
            Object obj = copyOnWriteArrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[i]");
            MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) obj;
            if (tabRecommendPB$PersonExtraInfo == null) {
                mayKnowRecommend.mediaInfos = new ArrayList();
                mayKnowRecommend.qZoneJumpUrl = "";
            } else {
                ArrayList arrayList = new ArrayList();
                if (tabRecommendPB$PersonExtraInfo.qzone_media_info.isEmpty()) {
                    QLog.w("PYMKMediaUtil", 1, ". personExtraInfoMap. uin: " + s16 + " media is empty");
                } else {
                    int size2 = tabRecommendPB$PersonExtraInfo.qzone_media_info.size();
                    for (int i16 = 0; i16 < size2; i16++) {
                        TabRecommendPB$MediaInfo tabRecommendPB$MediaInfo = tabRecommendPB$PersonExtraInfo.qzone_media_info.get(i16);
                        Intrinsics.checkNotNullExpressionValue(tabRecommendPB$MediaInfo, "personExtraInfo.qzone_media_info[j]");
                        arrayList.add(new MediaInfo(tabRecommendPB$MediaInfo));
                    }
                    mayKnowRecommend.mediaInfos = arrayList;
                    mayKnowRecommend.qZoneJumpUrl = tabRecommendPB$PersonExtraInfo.qzone_jump_url.get();
                }
            }
        }
        recommendData.clear();
        recommendData.addAll(copyOnWriteArrayList);
        callback.invoke();
    }

    private final void x() {
        QZoneInfo qZoneInfo = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getQZoneInfo();
        this.qZoneInfo = qZoneInfo;
        Integer valueOf = qZoneInfo != null ? Integer.valueOf(qZoneInfo.getHitExpGroup()) : null;
        if (valueOf == null) {
            this.isShowQZone = false;
            return;
        }
        if (valueOf.intValue() <= 0) {
            this.isShowQZone = false;
            return;
        }
        if (!this.isShowQZone) {
            QLog.i("PYMKMediaUtil", 1, "isShowQZone: TRUE. HitExpGroup: " + valueOf);
        }
        this.isShowQZone = true;
    }

    @Override // com.tencent.mobileqq.pymk.api.b
    public void a(View pymkItem, final MayKnowRecommend recFriendData, Bundle extras) {
        Intrinsics.checkNotNullParameter(pymkItem, "pymkItem");
        if (recFriendData == null) {
            pymkItem.setVisibility(8);
            return;
        }
        if (!v(recFriendData) && !u(recFriendData)) {
            View findViewById = pymkItem.findViewById(R.id.yzz);
            if (findViewById == null) {
                return;
            }
            findViewById.setVisibility(8);
            return;
        }
        ((IPYMKAddFrinedApi) QRoute.api(IPYMKAddFrinedApi.class)).initMediaLayout(pymkItem);
        final View mediaLayout = pymkItem.findViewById(R.id.yzz);
        mediaLayout.setOnClickListener(this);
        mediaLayout.setTag(recFriendData);
        if (v(recFriendData)) {
            Intrinsics.checkNotNullExpressionValue(mediaLayout, "mediaLayout");
            i(mediaLayout, recFriendData);
        } else if (u(recFriendData)) {
            Intrinsics.checkNotNullExpressionValue(mediaLayout, "mediaLayout");
            h(mediaLayout, recFriendData);
        } else {
            mediaLayout.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(mediaLayout, "mediaLayout");
        t(mediaLayout);
        this.extras.clear();
        if (extras != null) {
            this.extras.putAll(extras);
        }
        mediaLayout.post(new Runnable() { // from class: com.tencent.mobileqq.pymk.qzone.a
            @Override // java.lang.Runnable
            public final void run() {
                PYMKMediaUtil.g(PYMKMediaUtil.this, mediaLayout, recFriendData);
            }
        });
    }

    @Override // com.tencent.mobileqq.pymk.api.b
    public void b(final CopyOnWriteArrayList<MayKnowRecommend> recommendData, final Function0<Unit> callback) {
        QZoneInfo qZoneInfo;
        Intrinsics.checkNotNullParameter(recommendData, "recommendData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        x();
        if (!this.isShowQZone || recommendData.isEmpty() || (qZoneInfo = this.qZoneInfo) == null) {
            return;
        }
        boolean z16 = false;
        if (qZoneInfo != null && qZoneInfo.getHitExpGroup() == 1) {
            z16 = true;
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            Iterator<MayKnowRecommend> it = recommendData.iterator();
            while (it.hasNext()) {
                MayKnowRecommend next = it.next();
                if (next.qZoneFeedsCnt > 0) {
                    String str = next.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "mayKnowRecommend.uin");
                    arrayList.add(Long.valueOf(s(str)));
                }
            }
            if (arrayList.isEmpty()) {
                QLog.d("PYMKMediaUtil", 1, "fetchQZoneExtraInfoAndProcess. uinList is empty");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PYMKMediaUtil", 2, "fetchQZoneExtraInfoAndProcess. uinList " + arrayList);
            }
            if (this.uinToExtraInfo.keySet().containsAll(arrayList)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PYMKMediaUtil", 2, "fetchQZoneExtraInfoAndProcess. cache:" + this.uinToExtraInfo.keySet());
                }
                w(callback, recommendData);
                return;
            }
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchQZoneExtraInfo(arrayList, new Function2<Boolean, Map<Long, ? extends TabRecommendPB$PersonExtraInfo>, Unit>() { // from class: com.tencent.mobileqq.pymk.qzone.PYMKMediaUtil$fetchQZoneExtraInfoAndProcess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<Long, ? extends TabRecommendPB$PersonExtraInfo> map) {
                    invoke(bool.booleanValue(), (Map<Long, TabRecommendPB$PersonExtraInfo>) map);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, Map<Long, TabRecommendPB$PersonExtraInfo> personExtraInfoMap) {
                    HashMap hashMap;
                    Intrinsics.checkNotNullParameter(personExtraInfoMap, "personExtraInfoMap");
                    if (z17 && !personExtraInfoMap.isEmpty()) {
                        hashMap = PYMKMediaUtil.this.uinToExtraInfo;
                        hashMap.putAll(personExtraInfoMap);
                        QLog.d("PYMKMediaUtil", 1, "fetchQZoneExtraInfoAndProcess. personExtraInfoMap.size: ", Integer.valueOf(personExtraInfoMap.size()));
                        PYMKMediaUtil.this.w(callback, recommendData);
                        return;
                    }
                    QLog.w("PYMKMediaUtil", 1, "fetchQZoneExtraInfoAndProcess. result: " + z17);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.yzz) {
            q(v3);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.b
    public void onPause() {
        this.exposureMediaUins.clear();
    }

    private final void i(View mediaLayout, MayKnowRecommend recFriendData) {
        LinearLayout linearLayout = (LinearLayout) mediaLayout.findViewById(R.id.f166205z00);
        linearLayout.setContentDescription("\u7a7a\u95f4\u52a8\u6001");
        int i3 = 5;
        int i16 = 0;
        while (i16 < 5) {
            View childAt = linearLayout.getChildAt(i16);
            final ImageView mediaImageView = (ImageView) childAt.findViewById(R.id.f29500lt);
            final ImageView imageView = (ImageView) childAt.findViewById(R.id.f29530lw);
            if (i16 >= recFriendData.qZoneFeedsCnt) {
                childAt.setVisibility(8);
            } else {
                childAt.setVisibility(0);
                ImageView imageView2 = (ImageView) childAt.findViewById(R.id.f29510lu);
                imageView2.setVisibility(0);
                imageView2.setImageDrawable(imageView2.getContext().getDrawable(R.drawable.qui_qzone_icon_allwhite_primary));
                List<MediaInfo> list = recFriendData.mediaInfos;
                MediaInfo mediaInfo = (list == null || i16 >= list.size()) ? null : recFriendData.mediaInfos.get(i16);
                if (mediaInfo == null) {
                    List<MediaInfo> list2 = recFriendData.mediaInfos;
                    if (list2 != null && !list2.isEmpty()) {
                        mediaImageView.setVisibility(8);
                    } else {
                        mediaImageView.setVisibility(0);
                        Context context = mediaImageView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "mediaImageView.context");
                        mediaImageView.setImageDrawable(l(context));
                    }
                    imageView.setVisibility(8);
                } else if (mediaInfo.getMediaType() == 1) {
                    if (!TextUtils.isEmpty(mediaInfo.getPicUrl())) {
                        String picUrl = mediaInfo.getPicUrl();
                        Intrinsics.checkNotNullExpressionValue(mediaImageView, "mediaImageView");
                        c.a().i(o(picUrl, mediaImageView), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.pymk.qzone.b
                            @Override // com.tencent.libra.listener.IPicLoadStateListener
                            public final void onStateChange(LoadState loadState, Option option) {
                                PYMKMediaUtil.j(mediaImageView, imageView, loadState, option);
                            }
                        });
                    }
                } else if (mediaInfo.getMediaType() == 2) {
                    if (!TextUtils.isEmpty(mediaInfo.getPicUrl())) {
                        mediaImageView.setVisibility(0);
                        c a16 = c.a();
                        String picUrl2 = mediaInfo.getPicUrl();
                        Intrinsics.checkNotNullExpressionValue(mediaImageView, "mediaImageView");
                        a16.h(o(picUrl2, mediaImageView));
                        imageView.setVisibility(0);
                    }
                } else {
                    childAt.setVisibility(8);
                }
                i16++;
            }
            i3--;
            i16++;
        }
        if (i3 > 0) {
            mediaLayout.setVisibility(0);
        } else {
            mediaLayout.setVisibility(8);
        }
    }

    private final int m(MayKnowRecommend recFriendData) {
        int i3;
        if (recFriendData == null) {
            return 0;
        }
        List<MediaInfo> list = recFriendData.mediaInfos;
        int size = list != null ? list.size() : 0;
        return (size != 0 || (i3 = recFriendData.qZoneFeedsCnt) <= size) ? size : i3;
    }

    private final void h(View mediaLayout, MayKnowRecommend recFriendData) {
        LinearLayout linearLayout = (LinearLayout) mediaLayout.findViewById(R.id.f166205z00);
        int i3 = 8;
        if (recFriendData.busiDataList.isEmpty()) {
            mediaLayout.setVisibility(8);
            return;
        }
        ArrayList<PYMKMedia> arrayList = recFriendData.busiDataList.get(0).medias;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i16 = 1;
            QLog.e("PYMKMediaUtil", 1, "toUin " + recFriendData.uin + ", medias.size " + arrayList.size());
            linearLayout.setContentDescription("\u7cbe\u9009\u7167\u7247");
            mediaLayout.setVisibility(0);
            int i17 = 0;
            while (i17 < 5) {
                View childAt = linearLayout.getChildAt(i17);
                if (i17 >= arrayList.size()) {
                    childAt.setVisibility(i3);
                } else {
                    ImageView mediaImageView = (ImageView) childAt.findViewById(R.id.f29500lt);
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.f29530lw);
                    PYMKMedia pYMKMedia = arrayList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(pYMKMedia, "medias[i]");
                    PYMKMedia pYMKMedia2 = pYMKMedia;
                    ImageView imageView2 = (ImageView) childAt.findViewById(R.id.f29510lu);
                    if (recFriendData.busiDataList.get(0).type == i16) {
                        imageView2.setImageDrawable(imageView2.getContext().getDrawable(R.drawable.qui_photos_wall_icon_allwhite_primary));
                        imageView2.setVisibility(0);
                    } else {
                        imageView2.setVisibility(i3);
                    }
                    int i18 = pYMKMedia2.mediaType;
                    if (i18 == 1) {
                        if (!TextUtils.isEmpty(pYMKMedia2.picUrl)) {
                            childAt.setVisibility(0);
                            c a16 = c.a();
                            String str = pYMKMedia2.picUrl;
                            Intrinsics.checkNotNullExpressionValue(str, "media.picUrl");
                            Intrinsics.checkNotNullExpressionValue(mediaImageView, "mediaImageView");
                            a16.h(o(str, mediaImageView));
                            imageView.setVisibility(8);
                        }
                    } else if (i18 == 2) {
                        if (!TextUtils.isEmpty(pYMKMedia2.picUrl)) {
                            childAt.setVisibility(0);
                            c a17 = c.a();
                            String str2 = pYMKMedia2.picUrl;
                            Intrinsics.checkNotNullExpressionValue(str2, "media.picUrl");
                            Intrinsics.checkNotNullExpressionValue(mediaImageView, "mediaImageView");
                            a17.h(o(str2, mediaImageView));
                            imageView.setVisibility(0);
                        }
                    } else {
                        i3 = 8;
                        childAt.setVisibility(8);
                        size--;
                        i17++;
                        i16 = 1;
                    }
                }
                i3 = 8;
                i17++;
                i16 = 1;
            }
            if (size > 0) {
                mediaLayout.setVisibility(0);
                return;
            } else {
                mediaLayout.setVisibility(i3);
                return;
            }
        }
        mediaLayout.setVisibility(8);
    }
}
