package com.tencent.mobileqq.zootopia.portal.detail.v2;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ~2\u00020\u0001:\u0006\u007f\u0080\u0001\u0081\u0001@B\u0013\b\u0016\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u00a2\u0006\u0004\bx\u0010yB\u001d\b\u0016\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u0012\b\u0010z\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bx\u0010{B%\b\u0016\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u0012\b\u0010z\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010|\u001a\u00020\u000b\u00a2\u0006\u0004\bx\u0010}J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\"\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\tJ\u0016\u0010-\u001a\u00020\u00042\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\bJ\u001e\u0010.\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u00100\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010/J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u001e\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u000b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020\u0004J\u0010\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108J\u0012\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0014J\u000e\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u000203R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010AR\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010FR\u0016\u0010I\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010AR\u0016\u0010L\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010AR\u0016\u0010P\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010AR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010QR\u0016\u0010S\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010KR\u0014\u0010V\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010UR\u0016\u0010X\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00160Y8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010UR\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010eR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\"\u0010u\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010A\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attributeSet", "", h.F, "Landroid/view/ViewGroup;", "fl", "", "", "titles", "", com.tencent.luggage.wxa.c8.c.G, "defaultPos", "f", "l", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "Landroid/graphics/Canvas;", PM.CANVAS, DomainData.DOMAIN_NAME, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "select", "p", "e", "o", "wNew", "hNew", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "colorSelect", "setColorSelect", "colorUnSelect", "setColorUnSelect", "needBottomDrawable", "setNeedBottomDrawAble", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$d;", "listener", "setTabClickListener", "dotText", "setItemRedDotNumber", "Lcom/tencent/sqshow/zootopia/data/n;", "mapTabList", "setMapTabList", "setData", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$c;", "setOnTabPageChangeListener", "onDraw", "position", "", "positionOffset", "positionOffsetPixels", "j", "k", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "percent", "i", "d", "I", "curSelect", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$d;", "tabClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bgPos", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "bgPositionOffset", "D", "bgPositionOffsetPixels", "E", "tabMarginStart", "Landroid/graphics/drawable/Drawable;", "G", "textSize", "H", "Z", "pressMode", "J", "needAnimate", "Landroid/util/SparseArray;", "K", "Landroid/util/SparseArray;", "needRedDot", "L", "mIsAnimating", "Landroid/graphics/Rect;", "M", "Landroid/graphics/Rect;", "mHitRect", "", "N", "Ljava/util/List;", "tabsRects", "Landroid/graphics/Paint;", "P", "Landroid/graphics/Paint;", "linePaint", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lid3/d;", BdhLogUtil.LogTag.Tag_Req, "Lid3/d;", "reportHelper", ExifInterface.LATITUDE_SOUTH, "getLastReportPos", "()I", "setLastReportPos", "(I)V", "lastReportPos", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailTabView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float bgPositionOffset;

    /* renamed from: D, reason: from kotlin metadata */
    private int bgPositionOffsetPixels;

    /* renamed from: E, reason: from kotlin metadata */
    private int tabMarginStart;

    /* renamed from: F, reason: from kotlin metadata */
    private Drawable bgDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean pressMode;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needBottomDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needAnimate;

    /* renamed from: K, reason: from kotlin metadata */
    private final SparseArray<Boolean> needRedDot;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsAnimating;

    /* renamed from: M, reason: from kotlin metadata */
    private Rect mHitRect;

    /* renamed from: N, reason: from kotlin metadata */
    private List<Rect> tabsRects;

    /* renamed from: P, reason: from kotlin metadata */
    private final Paint linePaint;

    /* renamed from: Q, reason: from kotlin metadata */
    private List<ZootopiaMapTab> mapTabList;

    /* renamed from: R, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private int lastReportPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int colorUnSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int colorSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curSelect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d tabClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bgPos;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$b;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp5) {
            Intrinsics.checkNotNullParameter(tp5, "tp");
            tp5.setFakeBoldText(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$c;", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$d;", "", "", "idx", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface d {
        void a(int idx);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements ViewPager.OnPageChangeListener {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            ZootopiaDetailTabView.c(ZootopiaDetailTabView.this);
            ZootopiaDetailTabView zootopiaDetailTabView = ZootopiaDetailTabView.this;
            boolean z16 = true;
            if (state == 1) {
                zootopiaDetailTabView.k();
            } else {
                z16 = false;
            }
            zootopiaDetailTabView.mIsAnimating = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ZootopiaDetailTabView.this.j(position, positionOffset, positionOffsetPixels);
            ZootopiaDetailTabView.c(ZootopiaDetailTabView.this);
            ZootopiaDetailTabView.this.mIsAnimating = positionOffsetPixels != 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ZootopiaDetailTabView.c(ZootopiaDetailTabView.this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$f", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView$d;", "", "idx", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f328846a;

        f(ViewPager viewPager) {
            this.f328846a = viewPager;
        }

        @Override // com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabView.d
        public void a(int idx) {
            this.f328846a.setCurrentItem(idx, true);
        }
    }

    public ZootopiaDetailTabView(Context context) {
        super(context);
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.mapTabList = new ArrayList();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        h(null);
    }

    public static final /* synthetic */ c c(ZootopiaDetailTabView zootopiaDetailTabView) {
        zootopiaDetailTabView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZootopiaDetailTabView this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            d dVar = this$0.tabClickListener;
            if (dVar != null) {
                this$0.needAnimate = true;
                dVar.a(i3);
                if (Math.abs(i3 - this$0.curSelect) > 1) {
                    this$0.needAnimate = false;
                    View childAt = this$0.getChildAt(this$0.curSelect);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                    this$0.p((ViewGroup) childAt, false, this$0.curSelect);
                    this$0.curSelect = i3;
                    View childAt2 = this$0.getChildAt(i3);
                    Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
                    this$0.p((ViewGroup) childAt2, true, this$0.curSelect);
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void h(AttributeSet attributeSet) {
        this.inflater = LayoutInflater.from(getContext());
        this.mHitRect = new Rect();
        setOrientation(0);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.bgDrawable = new ColorDrawable(this.colorSelect);
        this.linePaint.setColor(Color.argb(123, 66, 68, 118));
        this.linePaint.setStyle(Paint.Style.FILL);
    }

    private final void l() {
        post(new Runnable() { // from class: xc3.d
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDetailTabView.m(ZootopiaDetailTabView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZootopiaDetailTabView this$0) {
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

    private final void n(Drawable bgDrawable, Canvas canvas) {
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

    private final void o(int pos, ViewGroup item) {
        List<ZootopiaMapTab> list;
        ZootopiaMapTab zootopiaMapTab;
        id3.d dVar;
        if (pos != this.lastReportPos) {
            List<ZootopiaMapTab> list2 = this.mapTabList;
            if ((list2 != null ? list2.size() : 0) > pos && (list = this.mapTabList) != null && (zootopiaMapTab = list.get(pos)) != null && (dVar = this.reportHelper) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_playground_detail_tab_id", Integer.valueOf(zootopiaMapTab.getTabId()));
                linkedHashMap.put("zplan_playground_detail_tab_name", zootopiaMapTab.getTabName());
                Unit unit = Unit.INSTANCE;
                dVar.c("clck", item, linkedHashMap);
            }
            this.lastReportPos = pos;
        }
        if (pos != this.lastReportPos) {
            this.lastReportPos = pos;
        }
    }

    public final void i(float percent) {
        int e16;
        int i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (percent <= 0.0f) {
            i3 = -1;
            e16 = 0;
        } else {
            float screenWidth = ViewUtils.getScreenWidth();
            int i16 = (int) (screenWidth - ((screenWidth * percent) * 0.5f));
            e16 = (int) (i.e(40) * percent);
            i3 = i16;
        }
        if (layoutParams2.width == i3 && layoutParams2.getMarginStart() == e16) {
            return;
        }
        layoutParams2.width = i3;
        layoutParams2.setMarginStart(e16);
        this.tabMarginStart = e16;
        setLayoutParams(layoutParams2);
        l();
    }

    public final void j(int position, float positionOffset, int positionOffsetPixels) {
        this.bgPos = position;
        this.bgPositionOffset = positionOffset;
        this.bgPositionOffsetPixels = positionOffsetPixels;
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        QLog.i("ZootopiaDetailTabView", 1, "onConfigurationChanged - " + this);
        l();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.tabsRects == null) {
            return;
        }
        e(canvas);
        if (!this.needBottomDrawable || (drawable = this.bgDrawable) == null) {
            return;
        }
        n(drawable, canvas);
    }

    public final void setColorSelect(int colorSelect) {
        this.colorSelect = colorSelect;
    }

    public final void setColorUnSelect(int colorUnSelect) {
        this.colorUnSelect = colorUnSelect;
    }

    public final void setItemRedDotNumber(String dotText) {
        Intrinsics.checkNotNullParameter(dotText, "dotText");
        int childCount = getChildCount();
        int i3 = this.curSelect;
        boolean z16 = false;
        if (i3 >= 0 && i3 < childCount) {
            z16 = true;
        }
        if (z16) {
            l();
        }
    }

    public final void setLastReportPos(int i3) {
        this.lastReportPos = i3;
    }

    public final void setMapTabList(List<ZootopiaMapTab> mapTabList) {
        this.mapTabList = mapTabList;
    }

    public final void setNeedBottomDrawAble(boolean needBottomDrawable) {
        this.needBottomDrawable = needBottomDrawable;
    }

    public final void setTabClickListener(d listener) {
        this.tabClickListener = listener;
    }

    private final void f(ViewGroup fl5, List<String> titles, final int pos, int defaultPos) {
        List<ZootopiaMapTab> list;
        ZootopiaMapTab zootopiaMapTab;
        id3.d dVar;
        ZootopiaMapTab zootopiaMapTab2;
        View childAt = fl5.getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView != null) {
            SpannableString spannableString = new SpannableString(titles.get(pos));
            spannableString.setSpan(new b(), 0, titles.get(pos).length(), 17);
            textView.setText(spannableString);
            textView.setTextSize(1, this.textSize);
            textView.setIncludeFontPadding(false);
            textView.getLayoutParams().height = ViewUtils.dpToPx(this.textSize) + ViewUtils.dpToPx(this.textSize * 0.1f);
            textView.setLayoutParams(textView.getLayoutParams());
            if (pos == defaultPos) {
                if (pos != 0) {
                    this.needAnimate = false;
                }
                p(fl5, true, pos);
                this.curSelect = defaultPos;
            } else {
                p(fl5, false, pos);
            }
            textView.setLayerType(2, null);
        }
        List<ZootopiaMapTab> list2 = this.mapTabList;
        if ((list2 == null || (zootopiaMapTab2 = list2.get(pos)) == null || !zootopiaMapTab2.h()) ? false : true) {
            QLog.d("ZootopiaDetailTabView", 1, "set rank title Id ");
            fl5.setId(R.id.r78);
        }
        addView(fl5);
        List<ZootopiaMapTab> list3 = this.mapTabList;
        if ((list3 != null ? list3.size() : 0) > pos && (list = this.mapTabList) != null && (zootopiaMapTab = list.get(pos)) != null && (dVar = this.reportHelper) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_playground_detail_tab_id", Integer.valueOf(zootopiaMapTab.getTabId()));
            linkedHashMap.put("zplan_playground_detail_tab_name", zootopiaMapTab.getTabName());
            Unit unit = Unit.INSTANCE;
            id3.d.h(dVar, fl5, "em_zplan_playground_detail_tab", linkedHashMap, false, false, null, 48, null);
        }
        fl5.setOnClickListener(new View.OnClickListener() { // from class: xc3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDetailTabView.g(ZootopiaDetailTabView.this, pos, view);
            }
        });
    }

    public final void k() {
        this.needAnimate = true;
    }

    private final void e(Canvas canvas) {
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
                View childAt = getChildAt(i16);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                p((ViewGroup) childAt, true, this.curSelect);
                return;
            }
            View childAt2 = getChildAt(this.curSelect);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
            p((ViewGroup) childAt2, false, this.curSelect);
            int i17 = this.bgPos;
            this.curSelect = i17;
            View childAt3 = getChildAt(i17);
            Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.view.ViewGroup");
            p((ViewGroup) childAt3, true, this.curSelect);
            return;
        }
        int childCount = getChildCount();
        int i18 = this.bgPos;
        if (childCount > i18 + 1) {
            if (this.needAnimate) {
                if ((this.bgPositionOffset == 0.0f) && this.bgPositionOffsetPixels == 0) {
                    return;
                }
                View childAt4 = getChildAt(i18);
                Intrinsics.checkNotNull(childAt4, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt5 = ((ViewGroup) childAt4).getChildAt(0);
                Intrinsics.checkNotNull(childAt5, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) childAt5;
                View childAt6 = getChildAt(this.bgPos + 1);
                Intrinsics.checkNotNull(childAt6, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt7 = ((ViewGroup) childAt6).getChildAt(0);
                Intrinsics.checkNotNull(childAt7, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView2 = (TextView) childAt7;
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
            View childAt8 = getChildAt(this.curSelect);
            Intrinsics.checkNotNull(childAt8, "null cannot be cast to non-null type android.view.ViewGroup");
            p((ViewGroup) childAt8, true, this.curSelect);
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new e());
            this.tabClickListener = new f(viewPager);
        }
    }

    public final void setData(List<String> titles, int defaultPos) {
        if (titles != null && (!titles.isEmpty())) {
            removeAllViewsInLayout();
            setWeightSum(titles.size());
            int size = titles.size();
            for (int i3 = 0; i3 < size; i3++) {
                LayoutInflater layoutInflater = this.inflater;
                KeyEvent.Callback inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.d7m, (ViewGroup) this, false) : null;
                ViewGroup viewGroup = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
                if (viewGroup != null) {
                    f(viewGroup, titles, i3, defaultPos);
                }
            }
        }
        l();
    }

    private final void p(ViewGroup item, boolean select, int pos) {
        if (item == null) {
            return;
        }
        View childAt = item.getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView == null) {
            return;
        }
        if (select) {
            o(pos, item);
            textView.setTextColor(this.colorSelect);
        } else {
            textView.setTextColor(this.colorUnSelect);
        }
    }

    public ZootopiaDetailTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.mapTabList = new ArrayList();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        h(attributeSet);
    }

    public ZootopiaDetailTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.colorUnSelect = Color.parseColor("#ff0b0b0b");
        this.colorSelect = Color.parseColor("#ff4395f8");
        this.textSize = 18.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.mapTabList = new ArrayList();
        this.reportHelper = new id3.d(null, 1, null);
        this.lastReportPos = -1;
        h(attributeSet);
    }

    public final void setOnTabPageChangeListener(c listener) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int wNew, int hNew, int oldw, int oldh) {
    }
}
