package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoticonListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.shimmerview.QUIShimmerUrlImageView;
import com.tencent.mobileqq.util.HotPicSearchUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0003STUB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u001aH\u0016J \u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015H\u0002J(\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0006H\u0002J\u0018\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>H\u0016J\u0012\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020>H\u0016J\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0017J\u0018\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020;H\u0002J\u0018\u0010H\u001a\u00020)2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020;H\u0002J*\u0010I\u001a\u00020)2\b\u0010J\u001a\u0004\u0018\u00010\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00104\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0016JD\u0010L\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020/0\u00192\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00192\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnLongClickListener;", "mContext", "Landroid/content/Context;", "mColumnNum", "", "mSearchEmoLinearLayoutCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;", "mShimmerController", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "(Landroid/content/Context;ILcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;)V", "getMColumnNum", "()I", "setMColumnNum", "(I)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDensity", "", "mHasPerformedLongPress", "", "mItemViewList", "", "Lcom/tencent/mobileqq/qui/shimmerview/QUIShimmerUrlImageView;", "mPendingCheckForLongPress", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$CheckForLongPress;", "mPointView", "Landroid/view/View;", "getMSearchEmoLinearLayoutCb", "()Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;", "setMSearchEmoLinearLayoutCb", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;)V", "getMShimmerController", "()Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "setMShimmerController", "(Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;)V", "mWidthPixels", "cleanShimmerForSubItem", "", "createImageView", "dtBindViewReport", "view", "position", "info", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "findPointChild", HippyTKDListViewAdapter.X, "y", "getRelatedSearchEmoView", "index", "widthPixels", "density", "columnNum", "handleExtra", "imageView", "emoticonInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "ev", "Landroid/view/MotionEvent;", NodeProps.ON_LONG_CLICK, "v", "onTouchEvent", "event", "removeLongClickCb", "isStartDrag", "updateItemByLibra", "emoticonImg", "emotionInfo", "updateItemByURLDrawable", "updateItemUI", "contentView", "reportIndex", "updateUI", "data", "viewTypeList", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter$ViewTypeInfo;", "lastImgIndex", "isMultipleType", "firstRecommendDataIndex", "CheckForLongPress", "Companion", "SearchEmoLinearLayoutCb", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public class SearchEmoLinearLayout extends LinearLayout implements View.OnLongClickListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "SearchEmoLinearLayout";
    private int mColumnNum;

    @NotNull
    private Context mContext;
    private final float mDensity;
    private boolean mHasPerformedLongPress;

    @NotNull
    private final List<QUIShimmerUrlImageView> mItemViewList;

    @Nullable
    private CheckForLongPress mPendingCheckForLongPress;

    @Nullable
    private View mPointView;

    @NotNull
    private SearchEmoLinearLayoutCb mSearchEmoLinearLayoutCb;

    @Nullable
    private QUIShimmerController mShimmerController;
    private final int mWidthPixels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$CheckForLongPress;", "Ljava/lang/Runnable;", "mEvent", "Landroid/view/MotionEvent;", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout;Landroid/view/MotionEvent;)V", "mOriginalWindowAttachCount", "", "rememberWindowAttachCount", "", TencentLocation.RUN_MODE, "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class CheckForLongPress implements Runnable {
        static IPatchRedirector $redirector_;

        @NotNull
        private final MotionEvent mEvent;
        private int mOriginalWindowAttachCount;
        final /* synthetic */ SearchEmoLinearLayout this$0;

        public CheckForLongPress(@NotNull SearchEmoLinearLayout searchEmoLinearLayout, MotionEvent mEvent) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            this.this$0 = searchEmoLinearLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchEmoLinearLayout, (Object) mEvent);
            } else {
                this.mEvent = mEvent;
            }
        }

        public final void rememberWindowAttachCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.mOriginalWindowAttachCount = this.this$0.getWindowAttachCount();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.getParent() != null && this.mOriginalWindowAttachCount == this.this$0.getWindowAttachCount() && this.this$0.mPointView != null) {
                View view = this.this$0.mPointView;
                EmoticonInfo emoticonInfo = null;
                if (view != null) {
                    obj = view.getTag();
                } else {
                    obj = null;
                }
                if (obj instanceof EmoticonInfo) {
                    emoticonInfo = (EmoticonInfo) obj;
                }
                if (emoticonInfo != null) {
                    SearchEmoLinearLayout searchEmoLinearLayout = this.this$0;
                    searchEmoLinearLayout.mHasPerformedLongPress = true;
                    View view2 = searchEmoLinearLayout.mPointView;
                    if (view2 != null) {
                        view2.performLongClick();
                    }
                    searchEmoLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
                    searchEmoLinearLayout.sendAccessibilityEvent(2);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoLinearLayout$SearchEmoLinearLayoutCb;", "", "lastCompositeImgIndex", "", "getLastCompositeImgIndex", "()I", "lastRecommendImgIndex", "getLastRecommendImgIndex", "getTypeface", "Landroid/graphics/Typeface;", "subItemClickHappened", "", "emotionInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "index", "subItemLongClickHappened", "view", "Landroid/view/View;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface SearchEmoLinearLayoutCb {
        int getLastCompositeImgIndex();

        int getLastRecommendImgIndex();

        @Nullable
        Typeface getTypeface();

        void subItemClickHappened(@NotNull EmoticonInfo emotionInfo, int index);

        void subItemLongClickHappened(@NotNull View view, @NotNull EmoticonInfo emotionInfo);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchEmoLinearLayout(@NotNull Context mContext, int i3, @NotNull SearchEmoLinearLayoutCb mSearchEmoLinearLayoutCb, @Nullable QUIShimmerController qUIShimmerController) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mSearchEmoLinearLayoutCb, "mSearchEmoLinearLayoutCb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, Integer.valueOf(i3), mSearchEmoLinearLayoutCb, qUIShimmerController);
            return;
        }
        this.mContext = mContext;
        this.mColumnNum = i3;
        this.mSearchEmoLinearLayoutCb = mSearchEmoLinearLayoutCb;
        this.mShimmerController = qUIShimmerController;
        this.mItemViewList = new ArrayList();
        this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
        this.mWidthPixels = this.mContext.getResources().getDisplayMetrics().widthPixels;
        int i16 = this.mColumnNum;
        for (int i17 = 0; i17 < i16; i17++) {
            QUIShimmerUrlImageView relatedSearchEmoView = getRelatedSearchEmoView(i17, this.mWidthPixels, this.mDensity, this.mColumnNum);
            relatedSearchEmoView.setVisibility(8);
            relatedSearchEmoView.setFocusable(true);
            relatedSearchEmoView.setFocusableInTouchMode(true);
            addView(relatedSearchEmoView);
            this.mItemViewList.add(relatedSearchEmoView);
        }
    }

    private final void dtBindViewReport(View view, int position, EmotionPanelData info) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        int hashCode = info.hashCode();
        VideoReport.setElementId(view, EmotionDaTongReportUtil.EM_BAS_EMOTICON_SEARCH_RESULTS);
        VideoReport.setElementReuseIdentifier(view, "emo_" + (position % this.mColumnNum) + "_" + hashCode);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (info instanceof HotPicSearchEmoticonInfo) {
            hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) info;
        } else {
            hotPicSearchEmoticonInfo = null;
        }
        if (hotPicSearchEmoticonInfo != null) {
            String emoMd5 = hotPicSearchEmoticonInfo.mSearchItem.getEmoMd5();
            Intrinsics.checkNotNullExpressionValue(emoMd5, "it.mSearchItem.emoMd5");
            linkedHashMap.put(EmotionDaTongReportUtil.EM_PARAMS_SFACEID, emoMd5);
        }
        int i3 = 1;
        linkedHashMap.put(EmotionDaTongReportUtil.EM_PARAMS_APP_LOCATION, Integer.valueOf(position + 1));
        if (this instanceof SearchCompositeEmoLinearLayout) {
            i3 = 2;
        }
        linkedHashMap.put(EmotionDaTongReportUtil.EM_PARAMS_EMOJI_TAB_TYPE, Integer.valueOf(i3));
        VideoReport.setElementParams(view, linkedHashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final View findPointChild(float x16, float y16) {
        int childCount = super.getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = super.getChildAt(childCount);
                float scrollX = (super.getScrollX() + x16) - childAt.getLeft();
                float scrollY = (super.getScrollY() + y16) - childAt.getTop();
                if (scrollX >= 0.0f && scrollX <= childAt.getWidth() && scrollY >= 0.0f && scrollY < childAt.getHeight() && childAt.getVisibility() == 0) {
                    return childAt;
                }
            } else {
                return null;
            }
        }
    }

    private final QUIShimmerUrlImageView getRelatedSearchEmoView(int index, int widthPixels, float density, int columnNum) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCameraEmoView");
        }
        int i3 = columnNum - 1;
        int i16 = ((int) (widthPixels - ((2 * density) * i3))) / columnNum;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
        if (index == 0) {
            layoutParams.rightMargin = (int) (1 * density);
            layoutParams.leftMargin = 0;
        } else if (index == i3) {
            layoutParams.leftMargin = (int) (1 * density);
            layoutParams.rightMargin = 0;
            layoutParams.width = -1;
        } else {
            int i17 = (int) (1 * density);
            layoutParams.rightMargin = i17;
            layoutParams.leftMargin = i17;
        }
        QUIShimmerUrlImageView createImageView = createImageView();
        createImageView.setBusinessTag(TAG);
        createImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        createImageView.setAdjustViewBounds(false);
        createImageView.setLayoutParams(layoutParams);
        createImageView.setContentDescription(this.mContext.getString(R.string.f170795ad1));
        return createImageView;
    }

    private final void updateItemByLibra(final QUIShimmerUrlImageView emoticonImg, EmoticonInfo emotionInfo) {
        emoticonImg.startShimming(this.mShimmerController);
        Option option = emotionInfo.getOption();
        if (option == null) {
            emoticonImg.setImageDrawable(null);
            QLog.e(TAG, 1, "updateItemUI can not get option, emotionInfo:" + emotionInfo);
            return;
        }
        option.setTargetView(emoticonImg);
        QQEmoticonPicLoader.f356316a.b().loadImage(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                SearchEmoLinearLayout.updateItemByLibra$lambda$4(SearchEmoLinearLayout.this, emoticonImg, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateItemByLibra$lambda$4(SearchEmoLinearLayout this$0, QUIShimmerUrlImageView emoticonImg, LoadState loadState, Option listenerOption) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emoticonImg, "$emoticonImg");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(listenerOption, "listenerOption");
        if (loadState.isFinishSuccess()) {
            QUIShimmerController qUIShimmerController = this$0.mShimmerController;
            if (qUIShimmerController != null) {
                emoticonImg.stopShimming(qUIShimmerController);
            }
            if (listenerOption.getAnimatable() instanceof r01.c) {
                Animatable animatable = listenerOption.getAnimatable();
                Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                ((r01.c) animatable).start();
                return;
            }
            return;
        }
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e(TAG, 1, "loadImage  state:" + loadState + ", listenerOption:" + listenerOption);
        }
    }

    private final void updateItemByURLDrawable(QUIShimmerUrlImageView emoticonImg, final EmoticonInfo emotionInfo) {
        URLDrawable uRLDrawable = null;
        emoticonImg.setURLDrawableDownListener(null);
        Drawable bigDrawable = emotionInfo.getBigDrawable(this.mContext, this.mDensity);
        if (this.mShimmerController != null) {
            if (bigDrawable instanceof URLDrawable) {
                uRLDrawable = (URLDrawable) bigDrawable;
            }
            if (uRLDrawable != null) {
                if (uRLDrawable.getStatus() != 1) {
                    emoticonImg.startShimming(this.mShimmerController);
                } else {
                    emoticonImg.stopShimming(this.mShimmerController);
                }
            }
        }
        if (bigDrawable instanceof URLDrawable) {
            emoticonImg.setURLDrawableDownListener(new URLDrawableDownListener(this) { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoLinearLayout$updateItemByURLDrawable$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SearchEmoLinearLayout this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonInfo.this, (Object) this);
                    }
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadCancelled(@Nullable View view, @Nullable URLDrawable drawable) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) drawable);
                        return;
                    }
                    QLog.e(SearchEmoLinearLayout.TAG, 1, "onLoadFailed: " + EmoticonInfo.this);
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadFailed(@Nullable View view, @Nullable URLDrawable drawable, @Nullable Throwable cause) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, view, drawable, cause);
                        return;
                    }
                    QLog.e(SearchEmoLinearLayout.TAG, 1, "onLoadFailed: " + EmoticonInfo.this);
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadInterrupted(@Nullable View view, @Nullable URLDrawable drawable, @Nullable InterruptedException e16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, view, drawable, e16);
                        return;
                    }
                    QLog.e(SearchEmoLinearLayout.TAG, 1, "onLoadInterrupted: " + EmoticonInfo.this);
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadProgressed(@NotNull View view, @NotNull URLDrawable drawable, int progress) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, this, view, drawable, Integer.valueOf(progress));
                    } else {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(drawable, "drawable");
                    }
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadSuccessed(@Nullable View view, @Nullable URLDrawable drawable) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) drawable);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(SearchEmoLinearLayout.TAG, 2, "onLoadSuccessed: " + EmoticonInfo.this);
                    }
                    QUIShimmerController mShimmerController = this.this$0.getMShimmerController();
                    if (mShimmerController != null && (view instanceof QUIShimmerUrlImageView)) {
                        ((QUIShimmerUrlImageView) view).stopShimming(mShimmerController);
                    }
                }
            });
        }
        emoticonImg.setImageDrawable(bigDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateItemUI$lambda$2(EmoticonInfo emotionInfo, SearchEmoLinearLayout this$0, int i3, View view) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(emotionInfo, "$emotionInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = null;
        if (emotionInfo instanceof HotPicSearchEmoticonInfo) {
            hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionInfo;
        } else {
            hotPicSearchEmoticonInfo = null;
        }
        if (hotPicSearchEmoticonInfo != null) {
            str = hotPicSearchEmoticonInfo.getLogString();
        }
        QLog.d(TAG, 1, "onClick  emotionInfo " + str);
        this$0.mSearchEmoLinearLayoutCb.subItemClickHappened(emotionInfo, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void cleanShimmerForSubItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QUIShimmerController qUIShimmerController = this.mShimmerController;
        if (qUIShimmerController != null) {
            Iterator<T> it = this.mItemViewList.iterator();
            while (it.hasNext()) {
                ((QUIShimmerUrlImageView) it.next()).stopShimming(qUIShimmerController);
            }
        }
    }

    @NotNull
    public QUIShimmerUrlImageView createImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QUIShimmerUrlImageView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new QUIShimmerUrlImageView(this.mContext);
    }

    public final int getMColumnNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mColumnNum;
    }

    @NotNull
    public final Context getMContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    @NotNull
    public final SearchEmoLinearLayoutCb getMSearchEmoLinearLayoutCb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SearchEmoLinearLayoutCb) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mSearchEmoLinearLayoutCb;
    }

    @Nullable
    public final QUIShimmerController getMShimmerController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIShimmerController) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mShimmerController;
    }

    public void handleExtra(@NotNull QUIShimmerUrlImageView imageView, @NotNull EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView, (Object) emoticonInfo);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(emoticonInfo, "emoticonInfo");
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v3) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) v3)).booleanValue();
        } else {
            if (v3 instanceof URLImageView) {
                Object tag = ((URLImageView) v3).getTag(R.id.kxb);
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.EmoticonInfo");
                EmoticonInfo emoticonInfo = (EmoticonInfo) tag;
                String str = null;
                if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
                    hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emoticonInfo;
                } else {
                    hotPicSearchEmoticonInfo = null;
                }
                if (hotPicSearchEmoticonInfo != null) {
                    str = hotPicSearchEmoticonInfo.getLogString();
                }
                QLog.d(TAG, 1, "onLongClick  emotionInfo " + str);
                this.mSearchEmoLinearLayoutCb.subItemLongClickHappened(v3, emoticonInfo);
            }
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        CheckForLongPress checkForLongPress;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    removeLongClickCb(false);
                }
            } else {
                if (!this.mHasPerformedLongPress && (checkForLongPress = this.mPendingCheckForLongPress) != null) {
                    removeCallbacks(checkForLongPress);
                }
                View view = this.mPointView;
                if (view != null) {
                    view.setAlpha(1.0f);
                    if (!this.mHasPerformedLongPress) {
                        view.performClick();
                    }
                }
                this.mPointView = null;
            }
        } else {
            this.mHasPerformedLongPress = false;
            View findPointChild = findPointChild(event.getX(), event.getY());
            this.mPointView = findPointChild;
            if (findPointChild != null) {
                findPointChild.setAlpha(0.2f);
                CheckForLongPress checkForLongPress2 = this.mPendingCheckForLongPress;
                if (checkForLongPress2 == null) {
                    checkForLongPress2 = new CheckForLongPress(this, event);
                }
                this.mPendingCheckForLongPress = checkForLongPress2;
                checkForLongPress2.rememberWindowAttachCount();
                findPointChild.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
            }
        }
        return true;
    }

    public final void removeLongClickCb(boolean isStartDrag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, isStartDrag);
            return;
        }
        QLog.i(TAG, 1, "removeLongClickCb isStartDrag: " + isStartDrag);
        super.setPressed(false);
        CheckForLongPress checkForLongPress = this.mPendingCheckForLongPress;
        if (checkForLongPress != null) {
            removeCallbacks(checkForLongPress);
        }
        View view = this.mPointView;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        this.mPointView = null;
    }

    public final void setMColumnNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mColumnNum = i3;
        }
    }

    public final void setMContext(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public final void setMSearchEmoLinearLayoutCb(@NotNull SearchEmoLinearLayoutCb searchEmoLinearLayoutCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) searchEmoLinearLayoutCb);
        } else {
            Intrinsics.checkNotNullParameter(searchEmoLinearLayoutCb, "<set-?>");
            this.mSearchEmoLinearLayoutCb = searchEmoLinearLayoutCb;
        }
    }

    public final void setMShimmerController(@Nullable QUIShimmerController qUIShimmerController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUIShimmerController);
        } else {
            this.mShimmerController = qUIShimmerController;
        }
    }

    public void updateItemUI(@Nullable View contentView, @NotNull EmotionPanelData info, final int index, int reportIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, contentView, info, Integer.valueOf(index), Integer.valueOf(reportIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (contentView == null) {
            QLog.e(TAG, 1, "contentView = null");
            return;
        }
        QUIShimmerUrlImageView qUIShimmerUrlImageView = (QUIShimmerUrlImageView) contentView;
        final EmoticonInfo emoticonInfo = (EmoticonInfo) info;
        qUIShimmerUrlImageView.setTag(emoticonInfo);
        qUIShimmerUrlImageView.setVisibility(0);
        if (QLog.isColorLevel() && !StringUtil.isEmpty(emoticonInfo.action)) {
            QLog.d(TAG, 2, "updateUI info = " + emoticonInfo.action);
        }
        if (qUIShimmerUrlImageView.getTag(R.id.kxb) == info) {
            return;
        }
        qUIShimmerUrlImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEmoLinearLayout.updateItemUI$lambda$2(EmoticonInfo.this, this, index, view);
            }
        });
        qUIShimmerUrlImageView.setFocusable(true);
        qUIShimmerUrlImageView.setOnLongClickListener(this);
        qUIShimmerUrlImageView.setTag(R.id.kxb, info);
        qUIShimmerUrlImageView.setVisibility(0);
        if (HotPicSearchUtils.f306386a.a()) {
            updateItemByLibra(qUIShimmerUrlImageView, emoticonInfo);
        } else {
            updateItemByURLDrawable(qUIShimmerUrlImageView, emoticonInfo);
        }
        handleExtra(qUIShimmerUrlImageView, emoticonInfo);
        dtBindViewReport(contentView, reportIndex, info);
    }

    public void updateUI(int position, @NotNull List<EmotionPanelData> data, @NotNull List<SearchEmoticonListAdapter.ViewTypeInfo> viewTypeList, int lastImgIndex, boolean isMultipleType, int firstRecommendDataIndex) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(position), data, viewTypeList, Integer.valueOf(lastImgIndex), Boolean.valueOf(isMultipleType), Integer.valueOf(firstRecommendDataIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewTypeList, "viewTypeList");
        int size = viewTypeList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size && i17 < position; i17++) {
            i16 += viewTypeList.get(i17).getActDataCount();
        }
        int i18 = this.mColumnNum;
        for (int i19 = 0; i19 < i18; i19++) {
            int i26 = i16 + i19;
            if (i26 > lastImgIndex) {
                this.mItemViewList.get(i19).setVisibility(8);
            } else {
                if (isMultipleType) {
                    i3 = i26 >= firstRecommendDataIndex ? i26 - 2 : i26 - 1;
                } else {
                    i3 = i26;
                }
                updateItemUI(this.mItemViewList.get(i19), data.get(i26), i26, i3);
            }
        }
    }
}
