package com.tencent.qqnt.datepicker.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.datepicker.a;
import com.tencent.qqnt.datepicker.utils.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001L\b\u0007\u0018\u00002\u00020\u0001:\u0002\u008b\u0001B#\b\u0007\u0012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001\u0012\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u0010\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J$\u0010\u001c\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0002H\u0002J*\u0010'\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0014J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,H\u0017J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,H\u0014J\u0016\u00100\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eJ\u0006\u00101\u001a\u00020\u0002J\u000e\u00103\u001a\u0002022\u0006\u0010\"\u001a\u00020\u0002J\u0016\u00106\u001a\u0002042\u0006\u0010\"\u001a\u00020\u00022\u0006\u00105\u001a\u000204R\u0014\u00108\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00107R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00109R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00109R\u001c\u0010?\u001a\n =*\u0004\u0018\u00010<0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010AR\u0014\u0010C\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u00109R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010V\u001a\n =*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u001c\u0010Y\u001a\n =*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010UR\u001b\u0010_\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010b\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010\\\u001a\u0004\ba\u0010^R\u001b\u0010e\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010\\\u001a\u0004\bd\u0010^R\u0016\u0010g\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u00109R\u0016\u0010i\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u00109R\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u00109R\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u00109R\u0016\u0010o\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u00109R\u0016\u0010q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u00109R\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u00109R\u0016\u0010u\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u00109R\u0016\u0010w\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u00109R\u0016\u0010y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u00109R\u0016\u0010{\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010QR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "Landroid/view/View;", "", "year", "month", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Canvas;", PM.CANVAS, "g", "Landroid/graphics/RectF;", "dayRectF", "bgColor", "f", "todayDateRectF", "todayTxtColor", h.F, "Lcom/tencent/qqnt/datepicker/b;", "drawingDay", "", ReportConstant.COSTREPORT_PREFIX, "", "drawingDayContent", "textRectF", "paintColor", "e", "r", "", HippyTKDListViewAdapter.X, "y", "d", "index", "t", "Lcom/tencent/qqnt/datepicker/a;", "controller", "selectDay", "setData", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "dispatchHoverEvent", "l", "j", "", "k", "Landroid/graphics/Rect;", "bounds", "i", "Ljava/lang/String;", "TAG", "I", "dayHeight", "dayWidth", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "Ljava/util/TimeZone;", "timeZone", "Ljava/util/Locale;", "Ljava/util/Locale;", "locale", "firstWeekDay", "", "Lcom/tencent/qqnt/datepicker/data/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dayParams", "D", "Lcom/tencent/qqnt/datepicker/b;", "selectedDay", "com/tencent/qqnt/datepicker/view/DateMonthView$c", "E", "Lcom/tencent/qqnt/datepicker/view/DateMonthView$c;", "gesture", "Landroidx/core/view/GestureDetectorCompat;", UserInfo.SEX_FEMALE, "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "G", "Ljava/util/Calendar;", "curMonthCalender", "H", "calendarWithFirstDayOfMonth", "todayCalender", "Landroid/graphics/Paint;", "J", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/graphics/Paint;", "dayPaint", "K", "o", "selectedBgPaint", "L", "p", "todayPaint", "M", "maximumMonthDay", "N", "todayClickableTextColor", "P", "todayUnClickableTextColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "selectedDayBgColor", BdhLogUtil.LogTag.Tag_Req, "selectedDayBgColorNotSelectable", ExifInterface.LATITUDE_SOUTH, "textColorNormal", "T", "textColorClickable", "U", "textColorSelected", "V", "textSize", "W", "toadyTextSize", "a0", "bgCircleRadius", "b0", "Lcom/tencent/qqnt/datepicker/a;", "c0", "Z", "isSameMonth", "Lcom/tencent/qqnt/datepicker/view/DateMonthView$a;", "d0", "Lcom/tencent/qqnt/datepicker/view/DateMonthView$a;", "dateMonthAccessHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes24.dex */
public final class DateMonthView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.datepicker.data.a> dayParams;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.datepicker.b selectedDay;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c gesture;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GestureDetectorCompat gestureDetector;

    /* renamed from: G, reason: from kotlin metadata */
    private final Calendar curMonthCalender;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Calendar calendarWithFirstDayOfMonth;

    /* renamed from: I, reason: from kotlin metadata */
    private final Calendar todayCalender;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy dayPaint;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedBgPaint;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy todayPaint;

    /* renamed from: M, reason: from kotlin metadata */
    private int maximumMonthDay;

    /* renamed from: N, reason: from kotlin metadata */
    private int todayClickableTextColor;

    /* renamed from: P, reason: from kotlin metadata */
    private int todayUnClickableTextColor;

    /* renamed from: Q, reason: from kotlin metadata */
    private int selectedDayBgColor;

    /* renamed from: R, reason: from kotlin metadata */
    private int selectedDayBgColorNotSelectable;

    /* renamed from: S, reason: from kotlin metadata */
    private int textColorNormal;

    /* renamed from: T, reason: from kotlin metadata */
    private int textColorClickable;

    /* renamed from: U, reason: from kotlin metadata */
    private int textColorSelected;

    /* renamed from: V, reason: from kotlin metadata */
    private int textSize;

    /* renamed from: W, reason: from kotlin metadata */
    private int toadyTextSize;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private float bgCircleRadius;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.datepicker.a controller;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isSameMonth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a dateMonthAccessHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int dayHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int dayWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TimeZone timeZone;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Locale locale;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int firstWeekDay;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0014J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\"\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/datepicker/view/DateMonthView$a;", "Landroidx/customview/widget/ExploreByTouchHelper;", "", HippyTKDListViewAdapter.X, "y", "", "getVirtualViewAt", "", "virtualViewIds", "", "getVisibleVirtualViews", "virtualViewId", "Landroid/view/accessibility/AccessibilityEvent;", "event", "onPopulateEventForVirtualView", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "node", "onPopulateNodeForVirtualView", "action", "Landroid/os/Bundle;", "arguments", "", "onPerformActionForVirtualView", "Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "a", "Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "getParentView", "()Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "parentView", "Landroid/graphics/Rect;", "b", "Landroid/graphics/Rect;", "mTempParentBounds", "<init>", "(Lcom/tencent/qqnt/datepicker/view/DateMonthView;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends ExploreByTouchHelper {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DateMonthView parentView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect mTempParentBounds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull DateMonthView parentView) {
            super(parentView);
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentView);
            } else {
                this.parentView = parentView;
                this.mTempParentBounds = new Rect();
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, Float.valueOf(x16), Float.valueOf(y16))).intValue();
            }
            int l3 = this.parentView.l(x16, y16);
            if (l3 < 0) {
                return Integer.MIN_VALUE;
            }
            return l3;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NotNull List<Integer> virtualViewIds) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) virtualViewIds);
                return;
            }
            Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
            int j3 = this.parentView.j();
            if (j3 >= 0) {
                int i3 = 0;
                while (true) {
                    virtualViewIds.add(Integer.valueOf(i3));
                    if (i3 != j3) {
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, @Nullable Bundle arguments) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(virtualViewId), Integer.valueOf(action), arguments)).booleanValue();
            }
            if (action == 16) {
                this.parentView.t(virtualViewId);
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int virtualViewId, @NotNull AccessibilityEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, virtualViewId, (Object) event);
            } else {
                Intrinsics.checkNotNullParameter(event, "event");
                event.setContentDescription(this.parentView.k(virtualViewId));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, @NotNull AccessibilityNodeInfoCompat node) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, virtualViewId, (Object) node);
                return;
            }
            Intrinsics.checkNotNullParameter(node, "node");
            node.setContentDescription(this.parentView.k(virtualViewId));
            node.addAction(16);
            node.setBoundsInParent(this.parentView.i(virtualViewId, this.mTempParentBounds));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/datepicker/view/DateMonthView$b", "Lcom/tencent/qqnt/datepicker/a;", "Lcom/tencent/qqnt/datepicker/b;", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.datepicker.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DateMonthView.this);
            }
        }

        @Override // com.tencent.qqnt.datepicker.a
        @NotNull
        public com.tencent.qqnt.datepicker.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.datepicker.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return com.tencent.qqnt.datepicker.b.INSTANCE.a(DateMonthView.this.todayCalender.get(1), DateMonthView.this.todayCalender.get(2) + 1, DateMonthView.this.todayCalender.get(5));
        }

        @Override // com.tencent.qqnt.datepicker.a
        public boolean b(@NotNull com.tencent.qqnt.datepicker.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar)).booleanValue();
            }
            return a.C9609a.a(this, bVar);
        }

        @Override // com.tencent.qqnt.datepicker.a
        public void c(@NotNull com.tencent.qqnt.datepicker.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            } else {
                a.C9609a.b(this, bVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/datepicker/view/DateMonthView$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "onSingleTapUp", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DateMonthView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            DateMonthView.this.d(e16.getX(), e16.getY());
            return super.onSingleTapUp(e16);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DateMonthView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(float x16, float y16) {
        for (com.tencent.qqnt.datepicker.data.a aVar : this.dayParams) {
            if (aVar.a() && aVar.c().contains(x16, y16)) {
                this.selectedDay = aVar.b();
                invalidate();
                this.controller.c(aVar.b());
            }
        }
    }

    private final void e(Canvas canvas, String str, RectF rectF, int i3) {
        n().setColor(i3);
        float measureText = n().measureText(str);
        Paint.FontMetrics fontMetrics = n().getFontMetrics();
        float f16 = fontMetrics.descent;
        float f17 = 2;
        canvas.drawText(str, rectF.left + ((rectF.width() - measureText) / f17), rectF.top + (rectF.height() / f17) + (((f16 - fontMetrics.ascent) / f17) - f16), n());
    }

    private final void f(Canvas canvas, RectF rectF, int i3) {
        float f16 = 2;
        float width = rectF.left + (rectF.width() / f16);
        float height = rectF.top + (rectF.height() / f16);
        float f17 = this.bgCircleRadius;
        Paint o16 = o();
        o16.setColor(i3);
        Unit unit = Unit.INSTANCE;
        canvas.drawCircle(width, height, f17, o16);
    }

    private final void g(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        this.dayParams.clear();
        int m3 = m(this.calendarWithFirstDayOfMonth);
        com.tencent.qqnt.datepicker.utils.a.f355927a.a(this.TAG, "firstDayOfMonth -> " + m3);
        int i19 = 0;
        int i26 = 0;
        while (i19 < 7) {
            if (i26 == 7) {
                i19++;
                i26 = 0;
            }
            float paddingLeft = (this.dayWidth * i19) + getPaddingLeft();
            float paddingTop = (this.dayHeight * i26) + getPaddingTop();
            RectF rectF = new RectF(paddingLeft, paddingTop, this.dayWidth + paddingLeft, this.dayHeight + paddingTop);
            boolean z16 = true;
            int i27 = (((i26 * 7) + i19) + 1) - m3;
            if (i27 > 0) {
                if (i27 > this.maximumMonthDay) {
                    i19++;
                    i26 = 0;
                } else {
                    if (isInEditMode()) {
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setStrokeWidth(1.0f);
                        paint.setColor(-16711936);
                        Unit unit = Unit.INSTANCE;
                        canvas.drawRect(rectF, paint);
                    }
                    String valueOf = String.valueOf(i27);
                    com.tencent.qqnt.datepicker.b a16 = com.tencent.qqnt.datepicker.b.INSTANCE.a(this.curMonthCalender.get(1), this.curMonthCalender.get(2) + 1, i27);
                    boolean b16 = this.controller.b(a16);
                    this.dayParams.add(new com.tencent.qqnt.datepicker.data.a(rectF, a16, i19, b16 ? 1 : 0));
                    boolean r16 = r(i27);
                    com.tencent.qqnt.datepicker.b bVar = this.selectedDay;
                    if (bVar != null || !r16) {
                        z16 = false;
                    }
                    if (bVar != null) {
                        z16 = s(bVar, i27);
                    }
                    if (z16) {
                        if (b16) {
                            i17 = this.selectedDayBgColor;
                        } else {
                            i17 = this.selectedDayBgColorNotSelectable;
                        }
                        f(canvas, rectF, i17);
                        e(canvas, valueOf, rectF, this.textColorSelected);
                        if (r16) {
                            if (b16) {
                                i18 = this.todayClickableTextColor;
                            } else {
                                i18 = this.todayUnClickableTextColor;
                            }
                            h(canvas, rectF, i18);
                        }
                    } else {
                        if (b16) {
                            i3 = this.textColorClickable;
                        } else {
                            i3 = this.textColorNormal;
                        }
                        e(canvas, valueOf, rectF, i3);
                        if (r16) {
                            if (b16) {
                                i16 = this.textColorClickable;
                            } else {
                                i16 = this.todayUnClickableTextColor;
                            }
                            h(canvas, rectF, i16);
                        }
                    }
                }
            }
            i26++;
        }
    }

    private final void h(Canvas canvas, RectF rectF, int i3) {
        p().setColor(i3);
        float measureText = p().measureText("\u4eca\u5929");
        float f16 = p().getFontMetrics().top;
        float f17 = rectF.left;
        float width = rectF.width() - measureText;
        float f18 = 2;
        canvas.drawText("\u4eca\u5929", f17 + (width / f18), ((rectF.top + (rectF.height() / f18)) + (rectF.height() / 3)) - f16, p());
    }

    private final int m(Calendar calendar) {
        int i3 = calendar.get(7) - this.firstWeekDay;
        if (i3 < 0) {
            return i3 + 7;
        }
        return i3;
    }

    private final Paint n() {
        return (Paint) this.dayPaint.getValue();
    }

    private final Paint o() {
        return (Paint) this.selectedBgPaint.getValue();
    }

    private final Paint p() {
        return (Paint) this.todayPaint.getValue();
    }

    private final void q(int year, int month) {
        this.calendarWithFirstDayOfMonth.setMinimalDaysInFirstWeek(1);
        this.calendarWithFirstDayOfMonth.setFirstDayOfWeek(this.firstWeekDay);
        this.calendarWithFirstDayOfMonth.set(1, year);
        this.calendarWithFirstDayOfMonth.set(2, month - 1);
        this.calendarWithFirstDayOfMonth.add(2, 0);
        this.calendarWithFirstDayOfMonth.set(11, 0);
        this.calendarWithFirstDayOfMonth.set(12, 0);
        this.calendarWithFirstDayOfMonth.set(13, 0);
        this.calendarWithFirstDayOfMonth.set(14, 0);
        this.calendarWithFirstDayOfMonth.set(5, 1);
    }

    private final boolean r(int drawingDay) {
        if (drawingDay == this.maximumMonthDay && this.isSameMonth) {
            return true;
        }
        return false;
    }

    private final boolean s(com.tencent.qqnt.datepicker.b bVar, int i3) {
        if (this.curMonthCalender.get(1) == bVar.c() && this.curMonthCalender.get(2) + 1 == bVar.b() && i3 == bVar.a()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void setData$default(DateMonthView dateMonthView, int i3, int i16, com.tencent.qqnt.datepicker.a aVar, com.tencent.qqnt.datepicker.b bVar, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            bVar = null;
        }
        dateMonthView.setData(i3, i16, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int index) {
        com.tencent.qqnt.datepicker.b bVar;
        Object obj;
        com.tencent.qqnt.datepicker.b b16;
        boolean z16;
        this.dateMonthAccessHelper.sendEventForVirtualView(index, 1);
        Iterator<T> it = this.dayParams.iterator();
        while (true) {
            bVar = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.qqnt.datepicker.data.a) obj).b().a() == index) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.datepicker.data.a aVar = (com.tencent.qqnt.datepicker.data.a) obj;
        if (aVar != null) {
            bVar = aVar.b();
        }
        this.selectedDay = bVar;
        invalidate();
        if (aVar != null && (b16 = aVar.b()) != null) {
            this.controller.c(b16);
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.dateMonthAccessHelper.dispatchHoverEvent(event) && !super.dispatchHoverEvent(event)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Rect i(int index, @NotNull Rect bounds) {
        Object obj;
        RectF c16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Rect) iPatchRedirector.redirect((short) 11, (Object) this, index, (Object) bounds);
        }
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Iterator<T> it = this.dayParams.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.qqnt.datepicker.data.a) obj).b().a() == index) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.datepicker.data.a aVar = (com.tencent.qqnt.datepicker.data.a) obj;
        if (aVar != null && (c16 = aVar.c()) != null) {
            Rect rect = new Rect();
            c16.roundOut(rect);
            return rect;
        }
        return bounds;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.maximumMonthDay;
    }

    @NotNull
    public final CharSequence k(int index) {
        boolean z16;
        Integer num;
        Object obj;
        Integer num2;
        String valueOf;
        String qqStr;
        com.tencent.qqnt.datepicker.b b16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, (Object) this, index);
        }
        Iterator<T> it = this.dayParams.iterator();
        while (true) {
            z16 = true;
            num = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.qqnt.datepicker.data.a) obj).b().a() == index) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.datepicker.data.a aVar = (com.tencent.qqnt.datepicker.data.a) obj;
        if (aVar != null && (b16 = aVar.b()) != null) {
            num2 = Integer.valueOf(b16.b());
        } else {
            num2 = null;
        }
        if (aVar != null) {
            num = Integer.valueOf(aVar.e());
        }
        if (num != null && num.intValue() == 0) {
            valueOf = HardCodeUtil.qqStr(R.string.zky);
        } else {
            valueOf = String.valueOf(num);
        }
        if (aVar == null || aVar.d() != 0) {
            z16 = false;
        }
        if (z16) {
            qqStr = HardCodeUtil.qqStr(R.string.zkm);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.zjv);
        }
        return num2 + " \u6708 " + index + " \u65e5\uff0c\u661f\u671f " + valueOf + " " + qqStr;
    }

    public final int l(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Float.valueOf(x16), Float.valueOf(y16))).intValue();
        }
        for (com.tencent.qqnt.datepicker.data.a aVar : this.dayParams) {
            if (aVar.a() && aVar.c().contains(x16, y16)) {
                return aVar.b().a();
            }
        }
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        g(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = ((View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()) / 7;
        this.dayWidth = size;
        this.dayHeight = (int) (size * 0.9d);
        if (this.curMonthCalender.get(1) == this.todayCalender.get(1) && this.curMonthCalender.get(2) == this.todayCalender.get(2)) {
            com.tencent.qqnt.datepicker.utils.a.f355927a.a(this.TAG, " \u5f53\u524d\u663e\u793a\u65e5\u671f  \u548c \u4eca\u5929\u662f\u540c\u4e00\u5929");
            num = Integer.valueOf(this.todayCalender.get(5));
            this.maximumMonthDay = num.intValue();
            this.isSameMonth = true;
        } else {
            this.maximumMonthDay = this.curMonthCalender.getActualMaximum(5);
            this.isSameMonth = false;
            num = null;
        }
        b.Companion companion = com.tencent.qqnt.datepicker.utils.b.INSTANCE;
        Date time = this.curMonthCalender.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "curMonthCalender.time");
        int a16 = companion.a(time, num);
        com.tencent.qqnt.datepicker.utils.a.f355927a.a(this.TAG, " maxWeekNumberForMonth " + a16);
        setMeasuredDimension(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (((float) ((a16 * this.dayHeight) + getPaddingTop() + getPaddingBottom())) + (p().getFontMetrics().bottom - p().getFontMetrics().top)), 1073741824));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        return this.gestureDetector.onTouchEvent(event);
    }

    public final void setData(int year, int month, @NotNull com.tencent.qqnt.datepicker.a controller, @Nullable com.tencent.qqnt.datepicker.b selectDay) {
        com.tencent.qqnt.datepicker.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(year), Integer.valueOf(month), controller, selectDay);
            return;
        }
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.curMonthCalender.clear();
        this.curMonthCalender.set(1, year);
        this.curMonthCalender.set(2, month - 1);
        com.tencent.qqnt.datepicker.utils.a aVar = com.tencent.qqnt.datepicker.utils.a.f355927a;
        aVar.a(this.TAG, " curMonthCalender year " + year + " month " + month + " - " + this.curMonthCalender.get(2));
        com.tencent.qqnt.datepicker.b a17 = controller.a();
        this.todayCalender.set(1, a17.c());
        this.todayCalender.set(2, a17.b() - 1);
        this.todayCalender.set(5, a17.a());
        aVar.a(this.TAG, " currentDate " + a17 + " - " + this.todayCalender.get(2));
        q(year, month);
        if (selectDay == null) {
            a16 = null;
        } else {
            a16 = com.tencent.qqnt.datepicker.b.INSTANCE.a(selectDay.c(), selectDay.b(), selectDay.a());
        }
        this.selectedDay = a16;
        this.controller = controller;
        requestLayout();
        aVar.a(this.TAG, " setData " + this.curMonthCalender.getTime());
    }

    public /* synthetic */ DateMonthView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DateMonthView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.TAG = "DateMonthView" + hashCode();
        TimeZone timeZone = TimeZone.getDefault();
        this.timeZone = timeZone;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        this.locale = locale;
        this.firstWeekDay = 1;
        this.dayParams = new ArrayList();
        c cVar = new c();
        this.gesture = cVar;
        this.gestureDetector = new GestureDetectorCompat(context, cVar);
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        calendar.setMinimalDaysInFirstWeek(1);
        calendar.setFirstDayOfWeek(1);
        this.curMonthCalender = calendar;
        Calendar calendar2 = Calendar.getInstance(timeZone, locale);
        Intrinsics.checkNotNullExpressionValue(calendar2, "getInstance(timeZone, locale)");
        this.calendarWithFirstDayOfMonth = calendar2;
        this.todayCalender = Calendar.getInstance(timeZone, locale);
        lazy = LazyKt__LazyJVMKt.lazy(DateMonthView$dayPaint$2.INSTANCE);
        this.dayPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(DateMonthView$selectedBgPaint$2.INSTANCE);
        this.selectedBgPaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(DateMonthView$todayPaint$2.INSTANCE);
        this.todayPaint = lazy3;
        this.todayClickableTextColor = SupportMenu.CATEGORY_MASK;
        this.todayUnClickableTextColor = -7829368;
        this.selectedDayBgColor = -256;
        this.selectedDayBgColorNotSelectable = -256;
        this.textColorNormal = -16777216;
        this.textColorClickable = -16776961;
        this.textColorSelected = -65281;
        this.textSize = 50;
        this.toadyTextSize = 30;
        this.bgCircleRadius = l.a(14.5f);
        this.controller = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, cw3.a.f392120r0, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026able.DateMonthView, 0, 0)");
            try {
                this.todayClickableTextColor = obtainStyledAttributes.getColor(cw3.a.f392163y0, this.todayClickableTextColor);
                this.todayUnClickableTextColor = obtainStyledAttributes.getColor(cw3.a.A0, this.todayUnClickableTextColor);
                p().setTextSize(obtainStyledAttributes.getDimensionPixelSize(cw3.a.f392169z0, this.toadyTextSize));
                this.textColorNormal = obtainStyledAttributes.getColor(cw3.a.f392157x0, this.textColorNormal);
                this.textColorClickable = obtainStyledAttributes.getColor(cw3.a.f392152w0, this.textColorClickable);
                int color = obtainStyledAttributes.getColor(cw3.a.f392134t0, this.selectedDayBgColor);
                o().setColor(color);
                this.selectedDayBgColor = color;
                int color2 = obtainStyledAttributes.getColor(cw3.a.f392141u0, this.selectedDayBgColorNotSelectable);
                o().setColor(color2);
                this.selectedDayBgColorNotSelectable = color2;
                this.textColorSelected = obtainStyledAttributes.getColor(cw3.a.f392147v0, this.textColorSelected);
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(cw3.a.f392127s0, this.textSize);
                n().setTextSize(dimensionPixelSize);
                this.textSize = dimensionPixelSize;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        a aVar = new a(this);
        this.dateMonthAccessHelper = aVar;
        ViewCompat.setAccessibilityDelegate(this, aVar);
    }
}
