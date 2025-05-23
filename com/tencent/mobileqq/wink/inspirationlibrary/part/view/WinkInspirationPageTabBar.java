package com.tencent.mobileqq.wink.inspirationlibrary.part.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 l2\u00020\u0001:\u0003mnoB+\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010e\u001a\u00020\u0005\u0012\u0006\u0010f\u001a\u00020\u0005\u00a2\u0006\u0004\bg\u0010hB\u0013\b\u0016\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u00a2\u0006\u0004\bg\u0010iB\u001d\b\u0016\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\bg\u0010jB%\b\u0016\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010e\u001a\u00020\u0005\u00a2\u0006\u0004\bg\u0010kJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u001b\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070!\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0002J\u0016\u0010'\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001aJ \u0010)\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001aH\u0004J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0004J\u0010\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+J\u0006\u0010.\u001a\u00020\u0002R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00104R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00104R\u0016\u0010K\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00104R\u0016\u0010M\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010?R\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00104R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u00104R\u0016\u0010Z\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00104R\u0016\u0010\\\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u00104R$\u0010`\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b'\u0010_\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar;", "Landroid/widget/HorizontalScrollView;", "", HippyTKDListViewAdapter.X, "p", "", "position", "", "title", "j", "Landroid/view/View;", "tab", "v", "k", "Landroid/graphics/Canvas;", PM.CANVAS, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", "currentPos", "y", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isShowLine", "setIsShowLine", "onDraw", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "", "arrayText", "setTabData", "([Ljava/lang/String;)V", "r", "animUnderline", "setCurrentPosition", "fromUserClick", "u", "t", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$b;", "listener", "setTabChangeListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mTabContainer", "e", "I", "mTabCount", "f", "mCurrentPosition", tl.h.F, "mPrePosition", "i", "[Ljava/lang/String;", "mTabTexts", "mAnimationStartX", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsAnim", "D", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "E", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", UserInfo.SEX_FEMALE, "mThemeId", "G", "mWidth", "H", "mIsShowLine", "tabMargin", "Landroid/graphics/RectF;", "J", "Landroid/graphics/RectF;", "mRect", "Landroid/graphics/Paint;", "K", "Landroid/graphics/Paint;", "mPaint", "L", "lineOffset", "M", "checkedExpTextColor", "N", "uncheckedTextColor", DomainData.DOMAIN_NAME, "()I", "(I)V", "currentPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkInspirationPageTabBar extends HorizontalScrollView {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsAnim;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewPager mViewPager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewPager2 mViewPager2;

    /* renamed from: F, reason: from kotlin metadata */
    private int mThemeId;

    /* renamed from: G, reason: from kotlin metadata */
    private int mWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsShowLine;

    /* renamed from: I, reason: from kotlin metadata */
    private int tabMargin;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private RectF mRect;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: L, reason: from kotlin metadata */
    private int lineOffset;

    /* renamed from: M, reason: from kotlin metadata */
    private int checkedExpTextColor;

    /* renamed from: N, reason: from kotlin metadata */
    private int uncheckedTextColor;

    @NotNull
    public Map<Integer, View> P;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mTabContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mTabCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPrePosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String[] mTabTexts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mAnimationStartX;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$b;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$d", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f323037e;

        d(int i3) {
            this.f323037e = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            if (animation == null) {
                return;
            }
            WinkInspirationPageTabBar winkInspirationPageTabBar = WinkInspirationPageTabBar.this;
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            winkInspirationPageTabBar.mAnimationStartX = ((Integer) animatedValue).intValue();
            if (WinkInspirationPageTabBar.this.mAnimationStartX == this.f323037e) {
                WinkInspirationPageTabBar.this.mIsAnim = false;
            }
            WinkInspirationPageTabBar.this.invalidate();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$e", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AccessibilityDelegateCompat {
        e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
            boolean z16;
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            Object tag = host.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) tag).intValue() == WinkInspirationPageTabBar.this.mCurrentPosition) {
                z16 = true;
            } else {
                z16 = false;
            }
            info.setSelected(z16);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$f", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (WinkInspirationPageTabBar.this.mWidth == 0 || WinkInspirationPageTabBar.this.mWidth != WinkInspirationPageTabBar.this.getWidth()) {
                WinkInspirationPageTabBar winkInspirationPageTabBar = WinkInspirationPageTabBar.this;
                winkInspirationPageTabBar.mWidth = winkInspirationPageTabBar.getWidth();
                WinkInspirationPageTabBar.this.r();
                if (WinkInspirationPageTabBar.this.mIsShowLine) {
                    WinkInspirationPageTabBar winkInspirationPageTabBar2 = WinkInspirationPageTabBar.this;
                    winkInspirationPageTabBar2.mAnimationStartX = winkInspirationPageTabBar2.m();
                    WinkInspirationPageTabBar.this.invalidate();
                }
            }
            WinkInspirationPageTabBar.this.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkInspirationPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.P = new LinkedHashMap();
        this.mTabContainer = new LinearLayout(context);
        this.mThemeId = 1000;
        this.mIsShowLine = true;
        this.tabMargin = ViewUtils.dpToPx(23.0f);
        this.mRect = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(ViewUtils.dip2px(16.0f));
        this.mPaint = paint;
        this.lineOffset = ViewUtils.dpToPx(8.0f);
        this.checkedExpTextColor = getContext().getColor(R.color.qui_common_text_primary);
        this.uncheckedTextColor = getContext().getColor(R.color.qui_common_text_secondary);
        p();
        x();
    }

    private final void j(int position, String title) {
        int i3;
        Typeface typeface;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(16.0f);
        if (position == getMCurrentPosition()) {
            i3 = this.checkedExpTextColor;
        } else {
            i3 = this.uncheckedTextColor;
        }
        textView.setTextColor(i3);
        if (position == getMCurrentPosition()) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textView.setTypeface(typeface);
        textView.setGravity(48);
        textView.setIncludeFontPadding(false);
        textView.setPadding(0, ViewUtils.dpToPx(10.0f), 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        t(textView);
        v(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.rightMargin = this.tabMargin;
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    private final void k() {
        int i3 = this.mPrePosition;
        int i16 = this.mCurrentPosition;
        if (i3 != i16) {
            int i17 = o(i3)[0];
            int i18 = o(this.mCurrentPosition)[0];
            ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
            Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(startX, endX)");
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new d(i18));
            ofInt.start();
            this.mIsAnim = true;
            return;
        }
        this.mAnimationStartX = o(i16)[0];
        invalidate();
    }

    private final void l(Canvas canvas) {
        if (!this.mIsShowLine) {
            return;
        }
        int[] o16 = o(this.mCurrentPosition);
        int i3 = o16[2];
        int i16 = o16[0];
        int i17 = i3 - i16;
        int i18 = this.mAnimationStartX;
        if (i18 > 0) {
            i16 = i18;
        }
        this.mRect.set(i16, o16[1], i17 + i16, o16[3]);
        canvas.drawRect(this.mRect, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        return o(this.mCurrentPosition)[0];
    }

    private final int[] o(int position) {
        View childAt = this.mTabContainer.getChildAt(position);
        Intrinsics.checkNotNullExpressionValue(childAt, "mTabContainer.getChildAt(position)");
        int width = childAt.getWidth();
        Paint paint = this.mPaint;
        String[] strArr = this.mTabTexts;
        Intrinsics.checkNotNull(strArr);
        int measureText = (int) (width - paint.measureText(strArr[position]));
        int left = childAt.getLeft() + measureText + this.lineOffset;
        int right = (childAt.getRight() - measureText) - this.lineOffset;
        int dip2px = ViewUtils.dip2px(10.0f) + ViewUtils.dpToPx(16.0f) + ViewUtils.dpToPx(6.0f);
        return new int[]{left, dip2px, right, ViewUtils.dpToPx(2.0f) + dip2px};
    }

    private final void p() {
        this.mTabContainer.setOrientation(0);
        this.mTabContainer.setBackgroundColor(0);
        addView(this.mTabContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    private final void s(int position) {
        View childAt;
        if (this.mTabCount == 0 || (childAt = this.mTabContainer.getChildAt(position)) == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = this.tabMargin + (childAt.getWidth() / 2);
        int right = ((childAt.getRight() - scrollX) + width) - getWidth();
        if (right > 0) {
            smoothScrollBy(right, 0);
            return;
        }
        int left = (childAt.getLeft() - scrollX) - width;
        if (left < 0) {
            smoothScrollBy(left, 0);
        }
    }

    private final void v(final int position, View tab) {
        tab.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkInspirationPageTabBar.w(WinkInspirationPageTabBar.this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(WinkInspirationPageTabBar this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager viewPager = this$0.mViewPager;
        if (viewPager != null) {
            if (viewPager != null) {
                viewPager.setCurrentItem(i3, false);
            }
        } else {
            ViewPager2 viewPager2 = this$0.mViewPager2;
            if (viewPager2 != null) {
                if (viewPager2 != null) {
                    viewPager2.setCurrentItem(i3, false);
                }
            } else {
                this$0.u(i3, true, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x() {
        getViewTreeObserver().addOnPreDrawListener(new f());
    }

    private final void y(int currentPos) {
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (i3 == currentPos) {
                textView.setTextColor(this.checkedExpTextColor);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                textView.setTextColor(this.uncheckedTextColor);
                textView.setTypeface(Typeface.DEFAULT);
            }
        }
    }

    /* renamed from: n, reason: from getter */
    public final int getMCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        x();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount == 0 || this.mTabContainer.getChildAt(this.mCurrentPosition) == null) {
            return;
        }
        this.mPaint.setColor(ie0.a.f().g(getContext(), R.color.qui_common_brand_standard, this.mThemeId));
        l(canvas);
    }

    public final void q() {
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            if (childAt instanceof TextView) {
                VideoReport.setElementId(childAt, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_CATEGORY);
                VideoReport.setElementParam(childAt, WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIBRARY_CATEGORY_NAME, ((TextView) childAt).getText());
                VideoReport.setElementEndExposePolicy(childAt, EndExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(childAt, ClickPolicy.REPORT_ALL);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r0 != r4) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r() {
        boolean z16;
        int i3;
        PagerAdapter pagerAdapter;
        Integer num;
        PagerAdapter adapter;
        boolean z17;
        String[] strArr = this.mTabTexts;
        if (strArr != null) {
            if (strArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    QLog.e("WinkInspirationPageTabBar", 1, "tabTexts is empty!");
                    return;
                }
                ViewPager viewPager = this.mViewPager;
                if (viewPager != null) {
                    Integer num2 = null;
                    if (viewPager != null) {
                        pagerAdapter = viewPager.getAdapter();
                    } else {
                        pagerAdapter = null;
                    }
                    if (pagerAdapter != null) {
                        ViewPager viewPager2 = this.mViewPager;
                        if (viewPager2 != null && (adapter = viewPager2.getAdapter()) != null) {
                            num = Integer.valueOf(adapter.getF373114d());
                        } else {
                            num = null;
                        }
                        String[] strArr2 = this.mTabTexts;
                        if (strArr2 != null) {
                            num2 = Integer.valueOf(strArr2.length);
                        }
                    }
                    QLog.e("WinkInspirationPageTabBar", 1, "tabTexts size not match pages size");
                    return;
                }
                this.mTabContainer.removeAllViews();
                String[] strArr3 = this.mTabTexts;
                if (strArr3 != null) {
                    i3 = strArr3.length;
                } else {
                    i3 = 0;
                }
                this.mTabCount = i3;
                for (int i16 = 0; i16 < i3; i16++) {
                    String[] strArr4 = this.mTabTexts;
                    Intrinsics.checkNotNull(strArr4);
                    j(i16, strArr4[i16]);
                }
                this.mAnimationStartX = 0;
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void setCurrentPosition(int i3) {
        setCurrentPosition(i3, false);
    }

    public final void setIsShowLine(boolean isShowLine) {
        this.mIsShowLine = isShowLine;
    }

    public final void setTabData(@NotNull String[] arrayText) {
        boolean z16;
        Intrinsics.checkNotNullParameter(arrayText, "arrayText");
        if (arrayText.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mTabTexts = (String[]) arrayText.clone();
        r();
    }

    public final void setViewPager(@Nullable ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        if (viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.addOnPageChangeListener(new c());
            r();
            return;
        }
        QLog.e("WinkInspirationPageTabBar", 1, "ViewPager does not have adapter instance.");
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    protected final void t(@NotNull View tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        ViewCompat.setAccessibilityDelegate(tab, new e());
    }

    protected final void u(int position, boolean animUnderline, boolean fromUserClick) {
        if (position < 0 || position >= this.mTabCount) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(" illegal position, please check! position = %d, tabCount = %d", Arrays.copyOf(new Object[]{Integer.valueOf(position), Integer.valueOf(this.mTabCount)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.e("WinkInspirationPageTabBar", 1, format);
            position = 0;
        }
        int i3 = this.mCurrentPosition;
        if (i3 != position && i3 >= 0) {
            this.mPrePosition = i3;
            this.mCurrentPosition = position;
            y(position);
            s(this.mCurrentPosition);
            if (animUnderline) {
                k();
            } else {
                if (this.mTabContainer.getChildAt(this.mCurrentPosition) == null) {
                    return;
                }
                this.mAnimationStartX = m();
                invalidate();
            }
        }
    }

    public final void setCurrentPosition(int position, boolean animUnderline) {
        u(position, animUnderline, false);
    }

    public WinkInspirationPageTabBar(@Nullable Context context) {
        this(context, null);
    }

    public WinkInspirationPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkInspirationPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar$c;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "<init>", "(Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private final class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            WinkInspirationPageTabBar.this.u(position, true, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    public final void setTabChangeListener(@Nullable b listener) {
    }
}
