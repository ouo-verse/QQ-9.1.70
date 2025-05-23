package com.tencent.mobileqq.search.searchdetail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\u0004\u00a2\u0006\u0004\bB\u0010CJ*\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J:\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0002J\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0004H\u0002J\u0014\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001cJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\rR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0018\u00104\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010'R\u0018\u00106\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010+R\u0018\u00108\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010#R\u0018\u0010:\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010'R\u0018\u0010<\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010+\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchInteractiveView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/res/Resources;", "res", "", "resId", "reqWidth", "reqHeight", "Landroid/graphics/Bitmap;", "H0", "Landroid/graphics/BitmapFactory$Options;", "options", "F0", "Lcom/tencent/mobileqq/search/searchdetail/n;", "data", "", "G0", "Landroid/view/View;", "view", "", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "originReportInfo", "", "extraParam", "J0", "", "I0", "", "dataList", "setData", "searchInteractiveData", "L0", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "likeContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "likeText", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "likeIcon", "Lcom/airbnb/lottie/LottieAnimationView;", tl.h.F, "Lcom/airbnb/lottie/LottieAnimationView;", "likeIconAnimation", "i", "commentContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "commentText", BdhLogUtil.LogTag.Tag_Conn, "commentIcon", "D", "shareContainer", "E", ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, UserInfo.SEX_FEMALE, "shareIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchInteractiveView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView commentIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout shareContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView shareText;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView shareIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout likeContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView likeText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView likeIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView likeIconAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout commentContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView commentText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchInteractiveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int F0(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i3 = options.outHeight;
        int i16 = options.outWidth;
        int i17 = 1;
        if (i3 > reqHeight || i16 > reqWidth) {
            int i18 = i3 / 2;
            int i19 = i16 / 2;
            while (i18 / i17 >= reqHeight && i19 / i17 >= reqWidth) {
                i17 *= 2;
            }
        }
        return i17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G0(SearchInteractiveData data) {
        long j3;
        int i3;
        long j16;
        Unit unit;
        HashMap hashMapOf;
        SearchReportInfo searchReportInfo;
        Map<String, String> a16;
        String str;
        if (fb0.a.a("SearchInteractiveViewHelper")) {
            Logger.f235387a.d().w("SearchInteractiveViewHelper", 1, "handleClickCreateGuild isFastDoubleClick");
            return;
        }
        QLog.d("SearchInteractiveViewHelper", 1, "click data = [" + data.getKey() + "]");
        if (Intrinsics.areEqual(data.getKey(), "like")) {
            SearchJump f16 = data.f();
            long j17 = 0;
            if (f16 != null && (a16 = com.tencent.mobileqq.search.searchdetail.content.template.model.b.a(f16)) != null && (str = a16.get(PictureConst.PHOTO_LIKE_NUM)) != null) {
                j3 = Util.toLongOrDefault(str, 0L);
            } else {
                j3 = 0;
            }
            if (data.getIcon().iconStatus == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                j16 = -1;
            } else {
                j16 = 1;
            }
            long j18 = j3 + j16;
            if (j18 >= 0 || !AppSetting.isPublicVersion()) {
                j17 = j18;
            }
            LottieAnimationView lottieAnimationView = this.likeIconAnimation;
            ImageView imageView = this.likeIcon;
            TextView textView = this.likeText;
            if (lottieAnimationView != null && imageView != null && textView != null) {
                lottieAnimationView.removeAllAnimatorListeners();
                ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).updateVoteUpUI(imageView, lottieAnimationView, textView, i3 ^ 1, Long.valueOf(j17));
                data.getIcon().title.text = textView.getText().toString();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Logger.f235387a.d().w("SearchInteractiveViewHelper", 1, "some view is null " + this.likeIconAnimation + " " + this.likeIcon + " " + this.likeText);
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("key_current_button_status", String.valueOf(data.getIcon().iconStatus)));
            SearchJump f17 = data.f();
            if (f17 != null && (searchReportInfo = f17.reportInfo) != null) {
                com.tencent.mobileqq.search.searchdetail.util.f.f284742a.c(searchReportInfo, hashMapOf);
            }
            data.e().invoke(Long.valueOf(data.getGuildId()), data.getDocId(), data.getTraceId(), Integer.valueOf(data.getIcon().iconStatus), data.f(), hashMapOf);
            data.getIcon().iconStatus = i3 ^ 1;
            SearchJump f18 = data.f();
            if (f18 != null) {
                com.tencent.mobileqq.search.searchdetail.content.template.model.b.b(f18, PictureConst.PHOTO_LIKE_NUM, Long.valueOf(j17));
                return;
            }
            return;
        }
        data.e().invoke(Long.valueOf(data.getGuildId()), data.getDocId(), data.getTraceId(), Integer.valueOf(data.getIcon().iconStatus), data.f(), null);
    }

    private final Bitmap H0(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = F0(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private final boolean I0(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    private final void J0(View view, String identifier, SearchReportInfo originReportInfo, Map<String, String> extraParam) {
        String str;
        if (extraParam == null) {
            extraParam = new LinkedHashMap<>();
        }
        if (originReportInfo != null) {
            str = originReportInfo.eid;
        } else {
            str = null;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, identifier + "_" + view.hashCode());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (originReportInfo != null) {
            com.tencent.mobileqq.search.searchdetail.util.f.f284742a.c(originReportInfo, extraParam);
        }
        VideoReport.setElementParams(view, extraParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void K0(SearchInteractiveView searchInteractiveView, View view, String str, SearchReportInfo searchReportInfo, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        searchInteractiveView.J0(view, str, searchReportInfo, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(RelativeLayout this_run, SearchInteractiveView this$0, SearchInteractiveData searchInteractiveData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchInteractiveData, "$searchInteractiveData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_like", String.valueOf(searchInteractiveData.getIcon().iconStatus));
        VideoReport.setElementParams(this_run, linkedHashMap);
        this$0.G0(searchInteractiveData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(SearchInteractiveView this$0, SearchInteractiveData searchInteractiveData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchInteractiveData, "$searchInteractiveData");
        this$0.G0(searchInteractiveData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(SearchInteractiveView this$0, SearchInteractiveData searchInteractiveData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchInteractiveData, "$searchInteractiveData");
        this$0.G0(searchInteractiveData);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void L0(@NotNull final SearchInteractiveData searchInteractiveData) {
        String d16;
        Intrinsics.checkNotNullParameter(searchInteractiveData, "searchInteractiveData");
        String key = searchInteractiveData.getKey();
        int hashCode = key.hashCode();
        if (hashCode != 3321751) {
            if (hashCode != 109400031) {
                if (hashCode == 950398559 && key.equals("comment")) {
                    TextView textView = this.commentText;
                    if (textView != null) {
                        textView.setText(searchInteractiveData.d());
                    }
                    RelativeLayout relativeLayout = this.commentContainer;
                    if (relativeLayout != null) {
                        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.p
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SearchInteractiveView.N0(SearchInteractiveView.this, searchInteractiveData, view);
                            }
                        });
                        K0(this, relativeLayout, searchInteractiveData.getReuseIdForReport(), searchInteractiveData.getReportInfo(), null, 8, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (key.equals("share")) {
                TextView textView2 = this.shareText;
                if (textView2 != null) {
                    if (TextUtils.isEmpty(searchInteractiveData.d())) {
                        d16 = "\u5206\u4eab";
                    } else {
                        d16 = searchInteractiveData.d();
                    }
                    textView2.setText(d16);
                }
                RelativeLayout relativeLayout2 = this.shareContainer;
                if (relativeLayout2 != null) {
                    relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.q
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SearchInteractiveView.O0(SearchInteractiveView.this, searchInteractiveData, view);
                        }
                    });
                    K0(this, relativeLayout2, searchInteractiveData.getReuseIdForReport(), searchInteractiveData.getReportInfo(), null, 8, null);
                    return;
                }
                return;
            }
            return;
        }
        if (key.equals("like")) {
            TextView textView3 = this.likeText;
            if (textView3 != null) {
                textView3.setText(searchInteractiveData.d());
            }
            ImageView imageView = this.likeIcon;
            LottieAnimationView lottieAnimationView = this.likeIconAnimation;
            TextView textView4 = this.likeText;
            if (imageView != null && lottieAnimationView != null && textView4 != null) {
                ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).updateVoteUpUI(imageView, null, textView4, I0(searchInteractiveData.getIcon().iconStatus), null);
            }
            final RelativeLayout relativeLayout3 = this.likeContainer;
            if (relativeLayout3 != null) {
                relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchInteractiveView.M0(relativeLayout3, this, searchInteractiveData, view);
                    }
                });
                String reuseIdForReport = searchInteractiveData.getReuseIdForReport();
                SearchReportInfo reportInfo = searchInteractiveData.getReportInfo();
                Map<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("is_like", String.valueOf(searchInteractiveData.getIcon().iconStatus));
                Unit unit = Unit.INSTANCE;
                J0(relativeLayout3, reuseIdForReport, reportInfo, linkedHashMap);
            }
        }
    }

    public final void setData(@NotNull List<SearchInteractiveData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            L0((SearchInteractiveData) it.next());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchInteractiveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SearchInteractiveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchInteractiveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Unit unit;
        Unit unit2;
        Intrinsics.checkNotNullParameter(context, "context");
        int dip2px = ViewUtils.dip2px(24.0f);
        LayoutInflater.from(context).inflate(R.layout.fo7, (ViewGroup) this, true);
        this.likeContainer = (RelativeLayout) findViewById(R.id.e9g);
        this.likeText = (TextView) findViewById(R.id.e9p);
        this.likeIconAnimation = (LottieAnimationView) findViewById(R.id.w_c);
        ImageView imageView = (ImageView) findViewById(R.id.e9j);
        Resources resources = imageView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        Bitmap H0 = H0(resources, R.drawable.guild_feed_item_up_vote_icon_normal, dip2px, dip2px);
        Unit unit3 = null;
        if (H0 != null) {
            imageView.setImageBitmap(H0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.guild_feed_item_up_vote_icon_normal));
        }
        this.likeIcon = imageView;
        this.commentContainer = (RelativeLayout) findViewById(R.id.b3r);
        this.commentText = (TextView) findViewById(R.id.f164860b51);
        ImageView imageView2 = (ImageView) findViewById(R.id.b47);
        imageView2.setColorFilter(imageView2.getResources().getColor(R.color.qui_common_icon_primary));
        Resources resources2 = imageView2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "this.resources");
        Bitmap H02 = H0(resources2, R.drawable.guild_feed_item_comment_icon_normal, dip2px, dip2px);
        if (H02 != null) {
            imageView2.setImageBitmap(H02);
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.guild_feed_item_comment_icon_normal));
        }
        this.commentIcon = imageView2;
        this.shareContainer = (RelativeLayout) findViewById(R.id.f166868ir2);
        this.shareText = (TextView) findViewById(R.id.f84504mf);
        ImageView imageView3 = (ImageView) findViewById(R.id.ir5);
        imageView3.setColorFilter(imageView3.getResources().getColor(R.color.qui_common_icon_primary));
        Resources resources3 = imageView3.getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "this.resources");
        Bitmap H03 = H0(resources3, R.drawable.guild_feed_item_share_icon_normal, dip2px, dip2px);
        if (H03 != null) {
            imageView3.setImageBitmap(H03);
            unit3 = Unit.INSTANCE;
        }
        if (unit3 == null) {
            imageView3.setImageDrawable(imageView3.getResources().getDrawable(R.drawable.guild_feed_item_share_icon_normal));
        }
        this.shareIcon = imageView3;
        if (Intrinsics.areEqual(com.tencent.mobileqq.utils.m.b(), "OPPO-PHN110")) {
            TextView textView = this.likeText;
            if (textView == null) {
                return;
            }
            textView.setMinWidth(kotlin.g.c(this, 35.0f));
            return;
        }
        TextView textView2 = this.likeText;
        if (textView2 == null) {
            return;
        }
        textView2.setMinWidth(kotlin.g.c(this, 52.0f));
    }
}
