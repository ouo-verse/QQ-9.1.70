package com.tencent.timi.game.liveroom.impl.room.match;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.SparseArray;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.match.TGAudienceMatchTabView;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 u2\u00020\u0001:\u0004vwx8B\u0013\b\u0016\u0012\b\u0010n\u001a\u0004\u0018\u00010m\u00a2\u0006\u0004\bo\u0010pB\u001d\b\u0016\u0012\b\u0010n\u001a\u0004\u0018\u00010m\u0012\b\u0010q\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bo\u0010rB%\b\u0016\u0012\b\u0010n\u001a\u0004\u0018\u00010m\u0012\b\u0010q\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010s\u001a\u00020\n\u00a2\u0006\u0004\bo\u0010tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\u001e\u0010&\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0006\u0010%\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010(J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u001e\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\n2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\nJ\u0010\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010?R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00109R\u0016\u0010D\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00109R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010CR\u0014\u0010N\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010MR\u0016\u0010R\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010MR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\b0S8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010MR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010`\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u00109R\"\u0010l\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u00109\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k\u00a8\u0006y"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attributeSet", "", h.F, "Landroid/view/ViewGroup;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "select", "", com.tencent.luggage.wxa.c8.c.G, "o", "Landroid/graphics/Canvas;", PM.CANVAS, "f", "wNew", "hNew", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "colorSelect", "setColorSelect", "colorUnSelect", "setColorUnSelect", "resId", "setLineBgDrawableRes", "needBottomDrawable", "setNeedBottomDrawAble", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$d;", "listener", "setTabClickListener", "", "dotText", "setItemRedDotNumber", "", "titles", "defaultPos", "setData", "k", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$c;", "setOnTabPageChangeListener", "needDraw", "setNeedBottomLine", "onDraw", "position", "", "positionOffset", "positionOffsetPixels", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "g", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "d", "I", "e", "curSelect", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$d;", "tabClickListener", "bgPos", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "bgPositionOffset", "D", "bgPositionOffsetPixels", "Landroid/graphics/drawable/Drawable;", "E", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "textSize", "G", "Z", "pressMode", "H", "needAnimate", "J", "needBottomLine", "Landroid/util/SparseArray;", "K", "Landroid/util/SparseArray;", "needRedDot", "L", "mIsAnimating", "Landroid/graphics/Rect;", "M", "Landroid/graphics/Rect;", "mHitRect", "", "N", "Ljava/util/List;", "tabsRects", "Landroid/graphics/Paint;", "P", "Landroid/graphics/Paint;", "linePaint", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "currentPos", BdhLogUtil.LogTag.Tag_Req, "getLastReportPos", "()I", "setLastReportPos", "(I)V", "lastReportPos", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGAudienceMatchTabView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float bgPositionOffset;

    /* renamed from: D, reason: from kotlin metadata */
    private int bgPositionOffsetPixels;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable bgDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean pressMode;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needBottomDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needAnimate;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needBottomLine;

    /* renamed from: K, reason: from kotlin metadata */
    @SuppressLint({"UseSparseArrays"})
    @NotNull
    private final SparseArray<Boolean> needRedDot;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsAnimating;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Rect mHitRect;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private List<Rect> tabsRects;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Paint linePaint;

    /* renamed from: Q, reason: from kotlin metadata */
    private int currentPos;

    /* renamed from: R, reason: from kotlin metadata */
    private int lastReportPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int colorSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int colorUnSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curSelect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LayoutInflater inflater;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d tabClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bgPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$b;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class b extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint tp5) {
            Intrinsics.checkNotNullParameter(tp5, "tp");
            tp5.setFakeBoldText(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$c;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$d;", "", "", "idx", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface d {
        void a(int idx);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements ViewPager.OnPageChangeListener {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            TGAudienceMatchTabView.c(TGAudienceMatchTabView.this);
            TGAudienceMatchTabView tGAudienceMatchTabView = TGAudienceMatchTabView.this;
            boolean z16 = true;
            if (state == 1) {
                tGAudienceMatchTabView.j();
            } else {
                z16 = false;
            }
            tGAudienceMatchTabView.mIsAnimating = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            boolean z16;
            TGAudienceMatchTabView.this.i(position, positionOffset, positionOffsetPixels);
            TGAudienceMatchTabView.c(TGAudienceMatchTabView.this);
            TGAudienceMatchTabView tGAudienceMatchTabView = TGAudienceMatchTabView.this;
            if (positionOffsetPixels != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            tGAudienceMatchTabView.mIsAnimating = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            TGAudienceMatchTabView.this.currentPos = position;
            TGAudienceMatchTabView.c(TGAudienceMatchTabView.this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$f", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView$d;", "", "idx", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f377940a;

        f(ViewPager viewPager) {
            this.f377940a = viewPager;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.match.TGAudienceMatchTabView.d
        public void a(int idx) {
            this.f377940a.setCurrentItem(idx, true);
        }
    }

    public TGAudienceMatchTabView(@Nullable Context context) {
        super(context);
        this.colorSelect = -1;
        this.colorUnSelect = -1711276033;
        this.textSize = 14.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needBottomLine = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.lastReportPos = -1;
        h(null);
    }

    public static final /* synthetic */ c c(TGAudienceMatchTabView tGAudienceMatchTabView) {
        tGAudienceMatchTabView.getClass();
        return null;
    }

    private final void f(Canvas canvas) {
        boolean z16;
        boolean z17;
        float f16;
        float f17 = this.bgPositionOffset;
        if (f17 <= 1.0f) {
            if (this.bgPositionOffsetPixels == f17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (!this.needAnimate) {
                    int i3 = this.bgPos;
                    int i16 = this.curSelect;
                    if (i3 == i16) {
                        this.needAnimate = true;
                    }
                    View childAt = getChildAt(i16);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                    o((ViewGroup) childAt, true, this.curSelect);
                    return;
                }
                View childAt2 = getChildAt(this.curSelect);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
                o((ViewGroup) childAt2, false, this.curSelect);
                int i17 = this.bgPos;
                this.curSelect = i17;
                View childAt3 = getChildAt(i17);
                Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.view.ViewGroup");
                o((ViewGroup) childAt3, true, this.curSelect);
                return;
            }
            int childCount = getChildCount();
            int i18 = this.bgPos;
            if (childCount > i18 + 1) {
                if (this.needAnimate) {
                    if (this.bgPositionOffset == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && this.bgPositionOffsetPixels == 0) {
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
                    if (!this.pressMode) {
                        textView2.setPivotY(ViewUtils.dpToPx(this.textSize));
                        textView2.setPivotX(textView2.getWidth() / 2);
                        return;
                    }
                    return;
                }
                View childAt8 = getChildAt(this.curSelect);
                Intrinsics.checkNotNull(childAt8, "null cannot be cast to non-null type android.view.ViewGroup");
                o((ViewGroup) childAt8, true, this.curSelect);
            }
        }
    }

    private final void h(AttributeSet attributeSet) {
        this.inflater = LayoutInflater.from(getContext());
        this.mHitRect = new Rect();
        setOrientation(0);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.bgDrawable = yn4.c.b(R.drawable.lqc);
        this.linePaint.setColor(Color.argb(123, 66, 68, 118));
        this.linePaint.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TGAudienceMatchTabView this$0) {
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
            int width = (int) ((rect.left - i3) + ((r8.getWidth() - dpToPx) / 2.0f));
            Rect rect2 = new Rect(width, (int) (height - (2 * dpToPx2)), (int) (width + dpToPx), (int) (height - dpToPx2));
            List<Rect> list2 = this$0.tabsRects;
            Intrinsics.checkNotNull(list2);
            list2.add(rect2);
        }
        this$0.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TGAudienceMatchTabView this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
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
                    this$0.o((ViewGroup) childAt, false, this$0.curSelect);
                    this$0.curSelect = i3;
                    View childAt2 = this$0.getChildAt(i3);
                    Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
                    this$0.o((ViewGroup) childAt2, true, this$0.curSelect);
                }
            }
        } catch (Exception e16) {
            l.f("Danny", e16.toString(), e16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(ViewGroup item, boolean select, int pos) {
        TextView textView;
        if (item != null) {
            View childAt = item.getChildAt(0);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                textView = null;
            }
            if (textView != null) {
                if (select) {
                    if (pos != this.lastReportPos) {
                        ((a) mm4.b.b(a.class)).reportEvent("clck", item, new LinkedHashMap());
                        this.lastReportPos = pos;
                    }
                    textView.setTextColor(this.colorSelect);
                    return;
                }
                textView.setTextColor(this.colorUnSelect);
            }
        }
    }

    /* renamed from: g, reason: from getter */
    public final int getCurrentPos() {
        return this.currentPos;
    }

    public final void i(int position, float positionOffset, int positionOffsetPixels) {
        this.bgPos = position;
        this.bgPositionOffset = positionOffset;
        this.bgPositionOffsetPixels = positionOffsetPixels;
        postInvalidateDelayed(16L);
    }

    public final void j() {
        this.needAnimate = true;
    }

    public final void k() {
        post(new Runnable() { // from class: tj4.a
            @Override // java.lang.Runnable
            public final void run() {
                TGAudienceMatchTabView.l(TGAudienceMatchTabView.this);
            }
        });
    }

    public final void m(int pos) {
        if (getChildAt(pos) == null) {
            return;
        }
        this.needAnimate = false;
        this.curSelect = pos;
        View childAt = getChildAt(pos);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        o((ViewGroup) childAt, false, this.curSelect);
        View childAt2 = getChildAt(this.curSelect);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
        o((ViewGroup) childAt2, true, this.curSelect);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.tabsRects == null) {
            return;
        }
        f(canvas);
        if (this.bgDrawable != null && this.needBottomDrawable) {
            float f16 = this.bgPositionOffset;
            if (f16 <= 1.0f) {
                if (this.bgPositionOffsetPixels == f16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (!this.needAnimate) {
                        if (this.bgPos == this.curSelect) {
                            this.needAnimate = true;
                        }
                        List<Rect> list = this.tabsRects;
                        Intrinsics.checkNotNull(list);
                        Rect rect = list.get(this.curSelect);
                        Drawable drawable = this.bgDrawable;
                        Intrinsics.checkNotNull(drawable);
                        drawable.setBounds(rect);
                        Drawable drawable2 = this.bgDrawable;
                        Intrinsics.checkNotNull(drawable2);
                        drawable2.draw(canvas);
                        return;
                    }
                    List<Rect> list2 = this.tabsRects;
                    Intrinsics.checkNotNull(list2);
                    Rect rect2 = list2.get(this.bgPos);
                    Drawable drawable3 = this.bgDrawable;
                    Intrinsics.checkNotNull(drawable3);
                    drawable3.setBounds(rect2);
                    Drawable drawable4 = this.bgDrawable;
                    Intrinsics.checkNotNull(drawable4);
                    drawable4.draw(canvas);
                } else {
                    List<Rect> list3 = this.tabsRects;
                    Intrinsics.checkNotNull(list3);
                    if (list3.size() > this.bgPos + 1) {
                        if (this.needAnimate) {
                            List<Rect> list4 = this.tabsRects;
                            Intrinsics.checkNotNull(list4);
                            Rect rect3 = list4.get(this.bgPos);
                            List<Rect> list5 = this.tabsRects;
                            Intrinsics.checkNotNull(list5);
                            Rect rect4 = list5.get(this.bgPos + 1);
                            int i3 = rect4.left;
                            int i16 = ((int) ((i3 - r0) * this.bgPositionOffset)) + rect3.left;
                            int i17 = rect4.top;
                            int i18 = (rect4.right - i3) + i16;
                            int i19 = rect4.bottom;
                            Drawable drawable5 = this.bgDrawable;
                            Intrinsics.checkNotNull(drawable5);
                            drawable5.setBounds(i16, i17, i18, i19);
                            Drawable drawable6 = this.bgDrawable;
                            Intrinsics.checkNotNull(drawable6);
                            drawable6.draw(canvas);
                        } else {
                            List<Rect> list6 = this.tabsRects;
                            Intrinsics.checkNotNull(list6);
                            Rect rect5 = list6.get(this.curSelect);
                            Drawable drawable7 = this.bgDrawable;
                            Intrinsics.checkNotNull(drawable7);
                            drawable7.setBounds(rect5);
                            Drawable drawable8 = this.bgDrawable;
                            Intrinsics.checkNotNull(drawable8);
                            drawable8.draw(canvas);
                        }
                    }
                }
            }
        }
        if (this.needBottomLine) {
            canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight(), this.linePaint);
        }
    }

    public final void setColorSelect(int colorSelect) {
        this.colorSelect = colorSelect;
    }

    public final void setColorUnSelect(int colorUnSelect) {
        this.colorUnSelect = colorUnSelect;
    }

    public final void setData(@Nullable List<String> titles, int defaultPos) {
        View view;
        ViewGroup viewGroup;
        TextView textView;
        if (titles != null && titles.size() > 0) {
            removeAllViewsInLayout();
            setWeightSum(titles.size());
            int size = titles.size();
            for (final int i3 = 0; i3 < size; i3++) {
                LayoutInflater layoutInflater = this.inflater;
                if (layoutInflater != null) {
                    view = layoutInflater.inflate(R.layout.ht_, (ViewGroup) this, false);
                } else {
                    view = null;
                }
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt instanceof TextView) {
                        textView = (TextView) childAt;
                    } else {
                        textView = null;
                    }
                    if (textView != null) {
                        SpannableString spannableString = new SpannableString(titles.get(i3));
                        spannableString.setSpan(new b(), 0, titles.get(i3).length(), 17);
                        textView.setText(spannableString);
                        textView.setTextSize(1, this.textSize);
                        textView.setIncludeFontPadding(false);
                        textView.getLayoutParams().height = ViewUtils.dpToPx(this.textSize) + ViewUtils.dpToPx(this.textSize * 0.1f);
                        textView.setLayoutParams(textView.getLayoutParams());
                        if (i3 == defaultPos) {
                            if (i3 != 0) {
                                this.needAnimate = false;
                            }
                            o(viewGroup, true, i3);
                            this.curSelect = defaultPos;
                        } else {
                            o(viewGroup, false, i3);
                        }
                        textView.setLayerType(2, null);
                    }
                    addView(viewGroup);
                    ((a) mm4.b.b(a.class)).g(viewGroup, false, null, "em_qqlive_match_tab", tk4.d.f436481a.w(titles.get(i3), Integer.valueOf(i3)));
                    viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tj4.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            TGAudienceMatchTabView.n(TGAudienceMatchTabView.this, i3, view2);
                        }
                    });
                }
            }
        }
        k();
    }

    public final void setItemRedDotNumber(@NotNull String dotText) {
        Intrinsics.checkNotNullParameter(dotText, "dotText");
        int i3 = this.curSelect;
        if (i3 >= 0 && i3 < getChildCount()) {
            xi4.a.f448033a.d(getChildAt(this.curSelect), dotText, 1, false);
            k();
        }
    }

    public final void setLastReportPos(int i3) {
        this.lastReportPos = i3;
    }

    public final void setLineBgDrawableRes(int resId) {
        this.bgDrawable = yn4.c.b(resId);
    }

    public final void setNeedBottomDrawAble(boolean needBottomDrawable) {
        this.needBottomDrawable = needBottomDrawable;
    }

    public final void setNeedBottomLine(boolean needDraw) {
        this.needBottomLine = needDraw;
    }

    public final void setTabClickListener(@Nullable d listener) {
        this.tabClickListener = listener;
    }

    public final void setViewPager(@Nullable ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new e());
            this.tabClickListener = new f(viewPager);
        }
    }

    public TGAudienceMatchTabView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colorSelect = -1;
        this.colorUnSelect = -1711276033;
        this.textSize = 14.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needBottomLine = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.lastReportPos = -1;
        h(attributeSet);
    }

    public TGAudienceMatchTabView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.colorSelect = -1;
        this.colorUnSelect = -1711276033;
        this.textSize = 14.0f;
        this.needBottomDrawable = true;
        this.needAnimate = true;
        this.needBottomLine = true;
        this.needRedDot = new SparseArray<>();
        this.linePaint = new Paint();
        this.lastReportPos = -1;
        h(attributeSet);
    }

    public final void setOnTabPageChangeListener(@Nullable c listener) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int wNew, int hNew, int oldw, int oldh) {
    }
}
