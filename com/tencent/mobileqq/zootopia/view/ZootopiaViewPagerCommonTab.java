package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 w2\u00020\u0001:\u0004xyz7B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bq\u0010rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010s\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bq\u0010tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010s\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010u\u001a\u00020\u0010\u00a2\u0006\u0004\bq\u0010vJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\fH\u0002J(\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0014J\u0016\u0010,\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*J\u001e\u0010,\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*2\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-J\u0010\u00102\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000100J\u0010\u00104\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u000103J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0006\u00106\u001a\u00020\u0006R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010<R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010CR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00108R\u0016\u0010H\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010<R\u0016\u0010J\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00108R\u0016\u0010K\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010<R\u0014\u0010Q\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b8\u0010PR\u0016\u0010S\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010U\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010PR\u0016\u0010W\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010PR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010_\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R&\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\n0`j\b\u0012\u0004\u0012\u00020\n`a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR&\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\f0`j\b\u0012\u0004\u0012\u00020\f`a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\"\u0010p\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u00108\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "i", "attr", "j", "Landroid/view/ViewGroup;", "titleViewGroup", "Landroid/widget/TextView;", "textView", "", "title", "", com.tencent.luggage.wxa.c8.c.G, "defaultPos", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "bgDrawable", "Landroid/graphics/Canvas;", PM.CANVAS, "o", "", "select", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "position", "", "positionOffset", "positionOffsetPixels", "k", "f", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "p", "wNew", "hNew", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "", "titles", "setData", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$d;", "listener", "setTabClickListener", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$c;", "setOnTabPageChangeListener", "onDraw", "l", "d", "I", "colorUnSelect", "e", "colorSelect", UserInfo.SEX_FEMALE, "mainTextSize", tl.h.F, "curSelect", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$d;", "tabClickListener", BdhLogUtil.LogTag.Tag_Conn, "bgPos", "D", "bgPositionOffset", "E", "bgPositionOffsetPixels", "tabMarginStart", "G", "Landroid/graphics/drawable/Drawable;", "H", "textSize", "Z", "pressMode", "J", "needBottomDrawable", "K", "needAnimate", "L", "mIsAnimating", "Landroid/graphics/Rect;", "M", "Landroid/graphics/Rect;", "mHitRect", "", "N", "Ljava/util/List;", "tabsRects", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "P", "Ljava/util/ArrayList;", "titleContainerList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "titleTextViewList", "Lid3/d;", BdhLogUtil.LogTag.Tag_Req, "Lid3/d;", "reportHelper", ExifInterface.LATITUDE_SOUTH, "getLastReportPos", "()I", "setLastReportPos", "(I)V", "lastReportPos", "<init>", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaViewPagerCommonTab extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int bgPos;

    /* renamed from: D, reason: from kotlin metadata */
    private float bgPositionOffset;

    /* renamed from: E, reason: from kotlin metadata */
    private int bgPositionOffsetPixels;

    /* renamed from: F, reason: from kotlin metadata */
    private int tabMarginStart;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable bgDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean pressMode;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needBottomDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean needAnimate;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsAnimating;

    /* renamed from: M, reason: from kotlin metadata */
    private Rect mHitRect;

    /* renamed from: N, reason: from kotlin metadata */
    private List<Rect> tabsRects;

    /* renamed from: P, reason: from kotlin metadata */
    private ArrayList<ViewGroup> titleContainerList;

    /* renamed from: Q, reason: from kotlin metadata */
    private ArrayList<TextView> titleTextViewList;

    /* renamed from: R, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private int lastReportPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int colorUnSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int colorSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mainTextSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curSelect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private d tabClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$b;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp5) {
            Intrinsics.checkNotNullParameter(tp5, "tp");
            tp5.setFakeBoldText(true);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$c;", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$d;", "", "", "idx", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface d {
        void a(int idx);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements ViewPager.OnPageChangeListener {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            ZootopiaViewPagerCommonTab.c(ZootopiaViewPagerCommonTab.this);
            ZootopiaViewPagerCommonTab zootopiaViewPagerCommonTab = ZootopiaViewPagerCommonTab.this;
            boolean z16 = true;
            if (state == 1) {
                zootopiaViewPagerCommonTab.l();
            } else {
                z16 = false;
            }
            zootopiaViewPagerCommonTab.mIsAnimating = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ZootopiaViewPagerCommonTab.this.k(position, positionOffset, positionOffsetPixels);
            ZootopiaViewPagerCommonTab.c(ZootopiaViewPagerCommonTab.this);
            ZootopiaViewPagerCommonTab.this.mIsAnimating = positionOffsetPixels != 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ZootopiaViewPagerCommonTab.c(ZootopiaViewPagerCommonTab.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$f", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaViewPagerCommonTab$d;", "", "idx", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f329708a;

        f(ViewPager viewPager) {
            this.f329708a = viewPager;
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaViewPagerCommonTab.d
        public void a(int idx) {
            this.f329708a.setCurrentItem(idx, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaViewPagerCommonTab(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.mainTextSize = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.titleContainerList = new ArrayList<>();
        this.titleTextViewList = new ArrayList<>();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        i(context, null);
    }

    public static final /* synthetic */ c c(ZootopiaViewPagerCommonTab zootopiaViewPagerCommonTab) {
        zootopiaViewPagerCommonTab.getClass();
        return null;
    }

    private final void g(ViewGroup titleViewGroup, TextView textView, String title, final int pos, int defaultPos) {
        this.titleContainerList.add(titleViewGroup);
        this.titleTextViewList.add(textView);
        SpannableString spannableString = new SpannableString(title);
        spannableString.setSpan(new b(), 0, title.length(), 17);
        textView.setText(spannableString);
        textView.setTextSize(1, this.textSize);
        textView.setIncludeFontPadding(false);
        textView.getLayoutParams().height = ViewUtils.dpToPx(this.textSize) + ViewUtils.dpToPx(this.textSize * 0.1f);
        textView.setLayoutParams(textView.getLayoutParams());
        if (pos == defaultPos) {
            if (pos != 0) {
                this.needAnimate = false;
            }
            q(true, pos);
            this.curSelect = defaultPos;
        } else {
            q(false, pos);
        }
        textView.setLayerType(2, null);
        addView(titleViewGroup);
        titleViewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaViewPagerCommonTab.h(ZootopiaViewPagerCommonTab.this, pos, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaViewPagerCommonTab this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            d dVar = this$0.tabClickListener;
            if (dVar != null) {
                this$0.needAnimate = true;
                dVar.a(i3);
                if (Math.abs(i3 - this$0.curSelect) > 1) {
                    this$0.needAnimate = false;
                    this$0.q(false, this$0.curSelect);
                    this$0.curSelect = i3;
                    this$0.q(true, i3);
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void i(Context context, AttributeSet attributeSet) {
        j(context, attributeSet);
        this.inflater = LayoutInflater.from(context);
        this.mHitRect = new Rect();
        setOrientation(0);
        this.bgDrawable = new ColorDrawable(this.colorSelect);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int position, float positionOffset, int positionOffsetPixels) {
        this.bgPos = position;
        this.bgPositionOffset = positionOffset;
        this.bgPositionOffsetPixels = positionOffsetPixels;
        postInvalidateDelayed(16L);
    }

    private final void m() {
        post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ae
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaViewPagerCommonTab.n(ZootopiaViewPagerCommonTab.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZootopiaViewPagerCommonTab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildCount() <= 0) {
            return;
        }
        List<Rect> list = this$0.tabsRects;
        if (list == null) {
            this$0.tabsRects = new ArrayList();
        } else {
            Intrinsics.checkNotNull(list);
            list.clear();
        }
        float height = this$0.getHeight();
        float dpToPx = ViewUtils.dpToPx(28.0f);
        float dpToPx2 = ViewUtils.dpToPx(2.0f);
        Rect rect = new Rect();
        this$0.getHitRect(rect);
        int i3 = rect.left;
        int childCount = this$0.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            this$0.getChildAt(i16).getHitRect(rect);
            int width = (int) ((rect.left - i3) + this$0.tabMarginStart + ((r8.getWidth() - dpToPx) / 2.0f));
            Rect rect2 = new Rect(width, (int) (height - (2 * dpToPx2)), (int) (width + dpToPx), (int) (height - dpToPx2));
            List<Rect> list2 = this$0.tabsRects;
            Intrinsics.checkNotNull(list2);
            list2.add(rect2);
        }
        this$0.postInvalidate();
    }

    private final void o(Drawable bgDrawable, Canvas canvas) {
        float f16 = this.bgPositionOffset;
        if (f16 <= 1.0f) {
            if (((float) this.bgPositionOffsetPixels) == f16) {
                if (!this.needAnimate) {
                    if (this.bgPos == this.curSelect) {
                        this.needAnimate = true;
                    }
                    List<Rect> list = this.tabsRects;
                    Intrinsics.checkNotNull(list);
                    bgDrawable.setBounds(list.get(this.curSelect));
                    bgDrawable.draw(canvas);
                    return;
                }
                List<Rect> list2 = this.tabsRects;
                Intrinsics.checkNotNull(list2);
                bgDrawable.setBounds(list2.get(this.bgPos));
                bgDrawable.draw(canvas);
                return;
            }
            List<Rect> list3 = this.tabsRects;
            Intrinsics.checkNotNull(list3);
            if (list3.size() > this.bgPos + 1) {
                if (this.needAnimate) {
                    List<Rect> list4 = this.tabsRects;
                    Intrinsics.checkNotNull(list4);
                    Rect rect = list4.get(this.bgPos);
                    List<Rect> list5 = this.tabsRects;
                    Intrinsics.checkNotNull(list5);
                    Rect rect2 = list5.get(this.bgPos + 1);
                    int i3 = rect2.left;
                    int i16 = ((int) ((i3 - r0) * this.bgPositionOffset)) + rect.left;
                    bgDrawable.setBounds(i16, rect2.top, (rect2.right - i3) + i16, rect2.bottom);
                    bgDrawable.draw(canvas);
                    return;
                }
                List<Rect> list6 = this.tabsRects;
                Intrinsics.checkNotNull(list6);
                bgDrawable.setBounds(list6.get(this.curSelect));
                bgDrawable.draw(canvas);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.tabsRects == null) {
            return;
        }
        f(canvas);
        if (!this.needBottomDrawable || (drawable = this.bgDrawable) == null) {
            return;
        }
        o(drawable, canvas);
    }

    public final void setData(List<String> titles) {
        setData(titles, 0);
    }

    public final void setLastReportPos(int i3) {
        this.lastReportPos = i3;
    }

    public final void setTabClickListener(d listener) {
        this.tabClickListener = listener;
    }

    public final void l() {
        this.needAnimate = true;
    }

    public final void setData(List<String> titles, int defaultPos) {
        if (titles != null && (!titles.isEmpty())) {
            removeAllViewsInLayout();
            this.titleContainerList.clear();
            this.titleTextViewList.clear();
            setWeightSum(titles.size());
            int size = titles.size();
            for (int i3 = 0; i3 < size; i3++) {
                LayoutInflater layoutInflater = this.inflater;
                View inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.d7m, (ViewGroup) this, false) : null;
                ViewGroup viewGroup = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
                if (viewGroup != null) {
                    View findViewById = viewGroup.findViewById(R.id.qp9);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "fl.findViewById(R.id.tabTextView)");
                    g(viewGroup, (TextView) findViewById, titles.get(i3), i3, defaultPos);
                }
            }
        }
        m();
    }

    private final void f(Canvas canvas) {
        float f16;
        float f17 = this.bgPositionOffset;
        if (f17 > 1.0f) {
            return;
        }
        if (((float) this.bgPositionOffsetPixels) == f17) {
            if (!this.needAnimate) {
                int i3 = this.bgPos;
                int i16 = this.curSelect;
                if (i3 == i16) {
                    this.needAnimate = true;
                }
                q(true, i16);
                return;
            }
            q(false, this.curSelect);
            int i17 = this.bgPos;
            this.curSelect = i17;
            q(true, i17);
            return;
        }
        int childCount = getChildCount();
        int i18 = this.bgPos;
        if (childCount > i18 + 1) {
            if (this.needAnimate) {
                if ((this.bgPositionOffset == 0.0f) && this.bgPositionOffsetPixels == 0) {
                    return;
                }
                View childAt = getChildAt(i18);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) childAt2;
                View childAt3 = getChildAt(this.bgPos + 1);
                Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt4 = ((ViewGroup) childAt3).getChildAt(0);
                Intrinsics.checkNotNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView2 = (TextView) childAt4;
                if (this.pressMode) {
                    textView.setPivotY(ViewUtils.dpToPx(this.textSize));
                    textView.setPivotX(0.0f);
                    textView2.setPivotY(ViewUtils.dpToPx(this.textSize));
                    textView2.setPivotX(textView2.getWidth());
                }
                if (this.bgPos == this.curSelect) {
                    f16 = this.bgPositionOffset;
                } else {
                    f16 = 1 - this.bgPositionOffset;
                    textView2 = textView;
                    textView = textView2;
                }
                int alpha = Color.alpha(this.colorSelect);
                int red = Color.red(this.colorSelect);
                int green = Color.green(this.colorSelect);
                int blue = Color.blue(this.colorSelect);
                int alpha2 = Color.alpha(this.colorUnSelect);
                int red2 = Color.red(this.colorUnSelect);
                int green2 = Color.green(this.colorUnSelect);
                int blue2 = Color.blue(this.colorUnSelect);
                float f18 = alpha;
                float f19 = (alpha2 - alpha) * f16;
                float f26 = red;
                float f27 = (red2 - red) * f16;
                float f28 = green;
                float f29 = (green2 - green) * f16;
                float f36 = blue;
                float f37 = (blue2 - blue) * f16;
                int argb = Color.argb((int) (f18 + f19), (int) (f26 + f27), (int) (f28 + f29), (int) (f36 + f37));
                int argb2 = Color.argb((int) (alpha2 - f19), (int) (red2 - f27), (int) (green2 - f29), (int) (blue2 - f37));
                textView.setTextColor(argb);
                textView2.setTextColor(argb2);
                if (!this.pressMode) {
                    textView.setPivotY(ViewUtils.dpToPx(this.textSize));
                    textView.setPivotX(textView.getWidth() / 2);
                }
                if (this.pressMode) {
                    return;
                }
                textView2.setPivotY(ViewUtils.dpToPx(this.textSize));
                textView2.setPivotX(textView2.getWidth() / 2);
                return;
            }
            q(true, this.curSelect);
        }
    }

    private final void j(Context context, AttributeSet attr) {
        if (attr != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attr, ei3.a.f396319m);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026able.ZplanPagerCommonTab)");
            this.mainTextSize = obtainStyledAttributes.getDimension(0, this.mainTextSize);
            this.colorUnSelect = obtainStyledAttributes.getResourceId(1, this.colorUnSelect);
            this.colorSelect = obtainStyledAttributes.getResourceId(2, this.colorSelect);
            obtainStyledAttributes.recycle();
        }
    }

    private final void q(boolean select, int pos) {
        TextView textView = (pos < 0 || pos >= this.titleTextViewList.size()) ? null : this.titleTextViewList.get(pos);
        if (textView == null) {
            return;
        }
        if (select) {
            p(pos, textView);
            textView.setTextColor(this.colorSelect);
        } else {
            textView.setTextColor(this.colorUnSelect);
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new e());
            setTabClickListener(new f(viewPager));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaViewPagerCommonTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.mainTextSize = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.titleContainerList = new ArrayList<>();
        this.titleTextViewList = new ArrayList<>();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        i(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaViewPagerCommonTab(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.mainTextSize = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.titleContainerList = new ArrayList<>();
        this.titleTextViewList = new ArrayList<>();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        i(context, attributeSet);
    }

    public final void setOnTabPageChangeListener(c listener) {
    }

    private final void p(int pos, TextView item) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int wNew, int hNew, int oldw, int oldh) {
    }
}
