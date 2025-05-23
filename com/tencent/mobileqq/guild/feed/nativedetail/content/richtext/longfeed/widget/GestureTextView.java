package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ReplacementSpan;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bf\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001b\b\u0016\u0018\u0000 \u0084\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001B\u0013\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J(\u0010&\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0018\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0014J\b\u00101\u001a\u00020\u0004H\u0014J\u000e\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\rJ\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u001c\u00107\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0016J\u0006\u0010;\u001a\u00020\u0004R\u0014\u0010=\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010<R\u0016\u0010@\u001a\u0004\u0018\u00010>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010<R\u0016\u0010H\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010<R\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010UR*\u0010Z\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010Wj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010YR\u0016\u0010\\\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010<R$\u0010b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010i\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bB\u0010f\"\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u00103R$\u0010r\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010w\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010mR\u0018\u0010y\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010tR\u0016\u0010{\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010<R\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "duration", "", "B", "w", "H", "Landroid/text/Spannable;", "spannable", "", "selStart", "selEnd", "", tl.h.F, "", "text", "o", "Landroid/graphics/drawable/Drawable;", "drawable", HippyTKDListViewAdapter.X, "spannableText", "", "emoDrawable", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", DomainData.DOMAIN_NAME, "com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView$c", "i", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView$c;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "Landroid/graphics/Rect;", "globalVisibleRect", "localVisibleRect", "t", "u", "offset", "containSpan", "r", "lineNum", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "j", "E", "G", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "hide", "I", "onSelectionChanged", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "requestLayout", "invalidateDrawable", "onTouchEvent", "K", "Z", "isCustomMenuEnabled", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow;", "operateWindow", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/n;", "selectionInfo", BdhLogUtil.LogTag.Tag_Conn, "isHideWhenScroll", "D", "isHide", "Landroid/view/GestureDetector;", "Lkotlin/Lazy;", "p", "()Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "onScrollChangedListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDrawListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "updateSelectViewRunnable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "holdDrawables", "J", "blockRelayout", "Ljava/lang/Object;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/Object;", "setSelectionController", "(Ljava/lang/Object;)V", "selectionController", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;", "L", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;", "setEditorFields", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;)V", "editorFields", "M", "nextDownTarget", "N", "Landroid/view/View;", "getStartHandleView", "()Landroid/view/View;", "setStartHandleView", "(Landroid/view/View;)V", "startHandleView", "P", "Landroid/graphics/drawable/Drawable;", "startHandleDrawable", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "endHandleView", BdhLogUtil.LogTag.Tag_Req, "endHandleDrawable", ExifInterface.LATITUDE_SOUTH, "hasMoveOverBounds", "Landroid/view/View$OnTouchListener;", "T", "Landroid/view/View$OnTouchListener;", "selectionHandleTouchListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "U", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GestureTextView extends AppCompatTextView {
    private static final boolean V = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("customize_selection_cursor_touch_9165", true);
    private static final boolean W = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("invalidate_emo_span_9165", true);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isHideWhenScroll;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isHide;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable updateSelectViewRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Drawable> holdDrawables;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean blockRelayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Object selectionController;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private EditorFields editorFields;

    /* renamed from: M, reason: from kotlin metadata */
    private int nextDownTarget;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View startHandleView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Drawable startHandleDrawable;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private View endHandleView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Drawable endHandleDrawable;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasMoveOverBounds;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final View.OnTouchListener selectionHandleTouchListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isCustomMenuEnabled;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final OperateWindow operateWindow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SelectionInfo selectionInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView$b;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "event", "", "onDoubleTap", "onSingleTapConfirmed", "", e.a.NAME, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent event) {
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a aVar;
            Intrinsics.checkNotNullParameter(event, "event");
            MovementMethod movementMethod = GestureTextView.this.getMovementMethod();
            Spanned spanned = null;
            if (movementMethod instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) {
                aVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) movementMethod;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                GestureTextView gestureTextView = GestureTextView.this;
                Layout layout = gestureTextView.getLayout();
                CharSequence text = GestureTextView.this.getText();
                if (text instanceof Spanned) {
                    spanned = (Spanned) text;
                }
                return aVar.a(gestureTextView, layout, spanned, event);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent event) {
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a aVar;
            Intrinsics.checkNotNullParameter(event, "event");
            MovementMethod movementMethod = GestureTextView.this.getMovementMethod();
            Spanned spanned = null;
            if (movementMethod instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) {
                aVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) movementMethod;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                GestureTextView gestureTextView = GestureTextView.this;
                Layout layout = gestureTextView.getLayout();
                CharSequence text = GestureTextView.this.getText();
                if (text instanceof Spanned) {
                    spanned = (Spanned) text;
                }
                aVar.b(gestureTextView, layout, spanned, event);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent event) {
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a aVar;
            Intrinsics.checkNotNullParameter(event, "event");
            MovementMethod movementMethod = GestureTextView.this.getMovementMethod();
            Spanned spanned = null;
            if (movementMethod instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) {
                aVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a) movementMethod;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                GestureTextView gestureTextView = GestureTextView.this;
                Layout layout = gestureTextView.getLayout();
                CharSequence text = GestureTextView.this.getText();
                if (text instanceof Spanned) {
                    spanned = (Spanned) text;
                }
                return aVar.c(gestureTextView, layout, spanned, event);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GestureTextView(@NotNull final Context context) {
        super(context);
        boolean z16;
        OperateWindow operateWindow;
        Lazy lazy;
        List listOf;
        boolean equals;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        if (V) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI);
            List list = listOf;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    equals = StringsKt__StringsJVMKt.equals((String) it.next(), Build.MANUFACTURER, true);
                    if (equals) {
                        z17 = false;
                        break;
                    }
                }
            }
            z17 = true;
            if (z17) {
                z16 = true;
                this.isCustomMenuEnabled = z16;
                if (!z16) {
                    operateWindow = new OperateWindow(this);
                } else {
                    operateWindow = null;
                }
                this.operateWindow = operateWindow;
                this.selectionInfo = new SelectionInfo(0, 0, 3, null);
                this.isHide = true;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView$gestureDetector$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final GestureDetector invoke() {
                        return new GestureDetector(context, new GestureTextView.b());
                    }
                });
                this.gestureDetector = lazy;
                this.onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.c
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        GestureTextView.A(GestureTextView.this);
                    }
                };
                this.updateSelectViewRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GestureTextView.J(GestureTextView.this);
                    }
                };
                setHighlightColor(context.getColor(R.color.qui_common_brand_light));
                if (z16) {
                    setCustomSelectionActionModeCallback(i());
                }
                this.selectionHandleTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.e
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean D;
                        D = GestureTextView.D(GestureTextView.this, view, motionEvent);
                        return D;
                    }
                };
            }
        }
        z16 = false;
        this.isCustomMenuEnabled = z16;
        if (!z16) {
        }
        this.operateWindow = operateWindow;
        this.selectionInfo = new SelectionInfo(0, 0, 3, null);
        this.isHide = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView$gestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                return new GestureDetector(context, new GestureTextView.b());
            }
        });
        this.gestureDetector = lazy;
        this.onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                GestureTextView.A(GestureTextView.this);
            }
        };
        this.updateSelectViewRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                GestureTextView.J(GestureTextView.this);
            }
        };
        setHighlightColor(context.getColor(R.color.qui_common_brand_light));
        if (z16) {
        }
        this.selectionHandleTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = GestureTextView.D(GestureTextView.this, view, motionEvent);
                return D;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GestureTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C(this$0, 0L, 1, null);
    }

    private final void B(long duration) {
        if (duration <= 0) {
            this.updateSelectViewRunnable.run();
        } else {
            postDelayed(this.updateSelectViewRunnable, duration);
        }
    }

    static /* synthetic */ void C(GestureTextView gestureTextView, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = 0;
            }
            gestureTextView.B(j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postUpdateSelectView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(GestureTextView this$0, View v3, MotionEvent event) {
        boolean z16;
        boolean z17;
        Method updateMagnifierMethod;
        Method updateMagnifierMethod2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (event.getAction() != 2) {
                this$0.I(false);
                this$0.H();
                this$0.hasMoveOverBounds = false;
            } else {
                this$0.I(true);
                Rect rect = new Rect();
                this$0.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this$0.getLocalVisibleRect(rect2);
                if (event.getRawY() > rect.bottom) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (event.getRawY() < rect.top) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 && !z17) {
                    if (this$0.hasMoveOverBounds) {
                        Intrinsics.checkNotNullExpressionValue(v3, "v");
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        this$0.v(v3, event, rect, rect2);
                        EditorFields editorFields = this$0.editorFields;
                        if (editorFields != null && (updateMagnifierMethod2 = editorFields.getUpdateMagnifierMethod()) != null) {
                            updateMagnifierMethod2.invoke(v3, event);
                        }
                        return true;
                    }
                } else {
                    if (z16) {
                        Intrinsics.checkNotNullExpressionValue(v3, "v");
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        this$0.t(v3, event, rect, rect2);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(v3, "v");
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        this$0.u(v3, event, rect, rect2);
                    }
                    this$0.hasMoveOverBounds = true;
                    EditorFields editorFields2 = this$0.editorFields;
                    if (editorFields2 != null && (updateMagnifierMethod = editorFields2.getUpdateMagnifierMethod()) != null) {
                        updateMagnifierMethod.invoke(v3, event);
                    }
                    return true;
                }
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GestureTextView", 4, "[selectionCursorTouchListener] exception: " + e16.getMessage());
            }
        }
        return false;
    }

    private final void E() {
        Field editor;
        Object obj;
        Object obj2;
        Object obj3;
        View view;
        Object obj4;
        View view2;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Drawable drawable;
        try {
            EditorFields editorFields = this.editorFields;
            if (editorFields != null && (editor = editorFields.getEditor()) != null && (obj = editor.get(this)) != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "get(this)");
                Field selectionController = editorFields.getSelectionController();
                if (selectionController != null && (obj2 = selectionController.get(obj)) != null) {
                    Intrinsics.checkNotNullExpressionValue(obj2, "get(editor)");
                    this.selectionController = obj2;
                    Field startHandle = editorFields.getStartHandle();
                    Drawable drawable2 = null;
                    if (startHandle != null) {
                        obj3 = startHandle.get(obj2);
                    } else {
                        obj3 = null;
                    }
                    if (obj3 instanceof View) {
                        view = (View) obj3;
                    } else {
                        view = null;
                    }
                    this.startHandleView = view;
                    if (view != null) {
                        view.setOnTouchListener(this.selectionHandleTouchListener);
                    }
                    Field endHandle = editorFields.getEndHandle();
                    if (endHandle != null) {
                        obj4 = endHandle.get(obj2);
                    } else {
                        obj4 = null;
                    }
                    if (obj4 instanceof View) {
                        view2 = (View) obj4;
                    } else {
                        view2 = null;
                    }
                    this.endHandleView = view2;
                    if (view2 != null) {
                        view2.setOnTouchListener(this.selectionHandleTouchListener);
                    }
                    if (Build.VERSION.SDK_INT < 29) {
                        Field startHandle2 = editorFields.getStartHandle();
                        if (startHandle2 != null && (obj7 = startHandle2.get(obj2)) != null) {
                            Intrinsics.checkNotNullExpressionValue(obj7, "get(selectionController)");
                            Field handleDrawable = editorFields.getHandleDrawable();
                            if (handleDrawable != null) {
                                obj8 = handleDrawable.get(obj7);
                            } else {
                                obj8 = null;
                            }
                            if (obj8 instanceof Drawable) {
                                drawable = (Drawable) obj8;
                            } else {
                                drawable = null;
                            }
                            this.startHandleDrawable = drawable;
                        }
                        Field endHandle2 = editorFields.getEndHandle();
                        if (endHandle2 != null && (obj5 = endHandle2.get(obj2)) != null) {
                            Intrinsics.checkNotNullExpressionValue(obj5, "get(selectionController)");
                            Field handleDrawable2 = editorFields.getHandleDrawable();
                            if (handleDrawable2 != null) {
                                obj6 = handleDrawable2.get(obj5);
                            } else {
                                obj6 = null;
                            }
                            if (obj6 instanceof Drawable) {
                                drawable2 = (Drawable) obj6;
                            }
                            this.endHandleDrawable = drawable2;
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("GestureTextView", 1, "setCursorTouchListener exception: " + e16.getMessage());
        }
    }

    private final void F(Spannable spannableText, Object emoDrawable) {
        boolean z16;
        try {
            EmoticonSpan n3 = n(spannableText, emoDrawable);
            int spanStart = spannableText.getSpanStart(n3);
            int spanEnd = spannableText.getSpanEnd(n3);
            SpanWatcher[] watchers = (SpanWatcher[]) spannableText.getSpans(spanStart, spanEnd, SpanWatcher.class);
            boolean z17 = true;
            if (watchers != null) {
                if (watchers.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (!z17) {
                Intrinsics.checkNotNullExpressionValue(watchers, "watchers");
                for (SpanWatcher spanWatcher : watchers) {
                    spanWatcher.onSpanChanged(spannableText, n3, spanStart, spanEnd, spanStart, spanEnd);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GestureTextView", 2, "setEmoSpanChanged Exception: " + e16.getMessage());
            }
        }
    }

    private final void G() {
        Drawable mutate;
        int color = getContext().getColor(R.color.qui_common_brand_standard);
        for (Drawable drawable : Build.VERSION.SDK_INT >= 29 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Drawable[]{getTextCursorDrawable(), getTextSelectHandle(), getTextSelectHandleLeft(), getTextSelectHandleRight()}) : CollectionsKt__CollectionsKt.listOf((Object[]) new Drawable[]{this.startHandleDrawable, this.endHandleDrawable})) {
            if (drawable != null && (mutate = drawable.mutate()) != null) {
                mutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
        }
    }

    private final void H() {
        if (this.selectionInfo.getStart() != this.selectionInfo.getEnd()) {
            this.isHide = false;
            OperateWindow operateWindow = this.operateWindow;
            if (operateWindow != null) {
                operateWindow.r(this.selectionInfo);
                return;
            }
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(GestureTextView this$0) {
        OperateWindow operateWindow;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isHide && (operateWindow = this$0.operateWindow) != null) {
            operateWindow.t(this$0.selectionInfo);
        }
    }

    private final boolean h(Spannable spannable, int selStart, int selEnd) {
        boolean z16;
        Object firstOrNull;
        int coerceAtMost;
        if (selEnd - selStart < 4) {
            if (selStart >= 0 && selEnd <= spannable.length() && selStart < selEnd) {
                CharSequence subSequence = spannable.subSequence(selStart, selEnd);
                if (subSequence.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return false;
                }
                if (new StringBuilder(subSequence).codePointAt(0) == 65039) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(selStart + 2, spannable.length());
                    Selection.setSelection(spannable, selStart, coerceAtMost);
                    return true;
                }
                Object[] spans = spannable.getSpans(selStart, selEnd, ReplacementSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "spannable.getSpans(selSt\u2026lacementSpan::class.java)");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(spans);
                ReplacementSpan replacementSpan = (ReplacementSpan) firstOrNull;
                if (replacementSpan != null) {
                    int spanStart = spannable.getSpanStart(replacementSpan);
                    int spanEnd = spannable.getSpanEnd(replacementSpan);
                    if ((selStart != spanStart || selEnd != spanEnd) && selStart >= spanStart && selEnd <= spanEnd) {
                        Selection.setSelection(spannable, spanStart, spanEnd);
                        return true;
                    }
                }
            } else {
                QLog.e("GestureTextView", 1, "Invalid range: selStart=" + selStart + ", selEnd=" + selEnd);
            }
        }
        return false;
    }

    private final c i() {
        return new c();
    }

    private final void j() {
        try {
            if (this.editorFields == null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GestureTextView.k(GestureTextView.this);
                    }
                }, 16, null, true);
            } else {
                E();
                G();
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("GestureTextView", 4, "customizeCursorTouch exception: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final GestureTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final EditorFields a16 = m.f221619a.a();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                GestureTextView.l(GestureTextView.this, a16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GestureTextView this$0, EditorFields editorFields) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.editorFields = editorFields;
        this$0.E();
        this$0.G();
    }

    private final EmoticonSpan n(Spannable spannableText, Object emoDrawable) {
        try {
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spannableText.getSpans(0, getText().length(), EmoticonSpan.class);
            if (emoticonSpanArr != null) {
                for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                    if (emoticonSpan.getDrawable() == emoDrawable) {
                        return emoticonSpan;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GestureTextView", 2, "getEmoSpan Exception: " + e16.getMessage());
                return null;
            }
            return null;
        }
    }

    private final void o(CharSequence text) {
        if (text instanceof Spanned) {
            ArrayList<Drawable> arrayList = new ArrayList<>();
            Spanned spanned = (Spanned) text;
            Object[] spans = spanned.getSpans(0, spanned.length(), EmoticonSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le\u2026EmoticonSpan::class.java)");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : spans) {
                Drawable drawable = ((EmoticonSpan) obj).getDrawable();
                if (drawable != null) {
                    arrayList2.add(drawable);
                }
            }
            arrayList.addAll(arrayList2);
            Object[] spans2 = spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans2, "text.getSpans(0, text.le\u2026DrawableSpan::class.java)");
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : spans2) {
                Drawable drawable2 = ((DynamicDrawableSpan) obj2).getDrawable();
                if (drawable2 != null) {
                    arrayList3.add(drawable2);
                }
            }
            arrayList.addAll(arrayList3);
            if (!arrayList.isEmpty()) {
                ArrayList<Drawable> arrayList4 = this.holdDrawables;
                if (arrayList4 != null) {
                    Iterator<T> it = arrayList4.iterator();
                    while (it.hasNext()) {
                        ((Drawable) it.next()).setCallback(null);
                    }
                }
                this.holdDrawables = arrayList;
                Iterator<T> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    ((Drawable) it5.next()).setCallback(this);
                }
                invalidate();
            }
        }
    }

    private final GestureDetector p() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    private final int q(int lineNum) {
        Rect rect = new Rect();
        if (lineNum < getLayout().getLineCount() && lineNum >= 0) {
            getLayout().getLineBounds(lineNum, rect);
        }
        return rect.height();
    }

    private final int r(int offset, boolean containSpan) {
        Object firstOrNull;
        if (getText() instanceof Spanned) {
            CharSequence text = getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
            ReplacementSpan[] spans = (ReplacementSpan[]) ((Spanned) text).getSpans(offset, offset, ReplacementSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "spans");
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(spans);
            ReplacementSpan replacementSpan = (ReplacementSpan) firstOrNull;
            if (replacementSpan != null) {
                if (containSpan) {
                    CharSequence text2 = getText();
                    Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
                    return ((Spanned) text2).getSpanEnd(replacementSpan);
                }
                CharSequence text3 = getText();
                Intrinsics.checkNotNull(text3, "null cannot be cast to non-null type android.text.Spanned");
                return ((Spanned) text3).getSpanStart(replacementSpan);
            }
            return offset;
        }
        return offset;
    }

    private final void t(View v3, MotionEvent event, Rect globalVisibleRect, Rect localVisibleRect) {
        boolean z16;
        char c16;
        Method updateCursorPositionMethod;
        char c17;
        Method updateCursorPositionMethod2;
        boolean y16 = y(v3);
        if (localVisibleRect.bottom >= getMeasuredHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int i3 = globalVisibleRect.top + localVisibleRect.bottom;
            int q16 = q(getLayout().getLineForOffset(getSelectionEnd()) + 1);
            if (this.nextDownTarget <= i3) {
                this.nextDownTarget = i3 + q16;
            }
            int r16 = r(getOffsetForPosition(event.getRawX(), this.nextDownTarget), true);
            if (r16 == getSelectionEnd() && r16 < getText().length() - 1) {
                r16 = r(r16 + 1, true);
            }
            if (QLog.isDevelopLevel()) {
                c17 = 1;
                QLog.d("GestureTextView", 1, "[cursor move bottom] isStart: " + y16 + ", (" + event.getRawX() + ", " + event.getRawY() + "), local: " + localVisibleRect + ", global: " + globalVisibleRect + ", bottom: " + i3 + ", offset: " + r16 + ", selectionEnd: " + getSelectionEnd() + ", nextTarget: " + this.nextDownTarget + ", nextLineHeight: " + q16);
            } else {
                c17 = 1;
            }
            EditorFields editorFields = this.editorFields;
            if (editorFields != null && (updateCursorPositionMethod2 = editorFields.getUpdateCursorPositionMethod()) != null) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(r16);
                objArr[c17] = Boolean.TRUE;
                updateCursorPositionMethod2.invoke(v3, objArr);
                return;
            }
            return;
        }
        int offsetForPosition = getOffsetForPosition(event.getRawX(), (event.getRawY() - globalVisibleRect.top) + localVisibleRect.top);
        if (QLog.isDevelopLevel()) {
            c16 = 1;
            QLog.d("GestureTextView", 1, "[cursor move bottom] offset: " + offsetForPosition + ", (" + event.getRawX() + ", " + event.getRawY() + "), local: " + localVisibleRect + ", global: " + globalVisibleRect);
        } else {
            c16 = 1;
        }
        EditorFields editorFields2 = this.editorFields;
        if (editorFields2 != null && (updateCursorPositionMethod = editorFields2.getUpdateCursorPositionMethod()) != null) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(offsetForPosition);
            objArr2[c16] = Boolean.TRUE;
            updateCursorPositionMethod.invoke(v3, objArr2);
        }
    }

    private final void u(View v3, MotionEvent event, Rect globalVisibleRect, Rect localVisibleRect) {
        boolean z16;
        Method updateCursorPositionMethod;
        boolean y16 = y(v3);
        int i3 = localVisibleRect.top;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int q16 = i3 - q(getLayout().getLineForOffset(getSelectionEnd()) - 1);
            int r16 = r(getOffsetForPosition(event.getRawX(), q16), false);
            if (QLog.isDevelopLevel()) {
                QLog.d("GestureTextView", 4, "[cursor move top] isStart: " + y16 + ", local: " + localVisibleRect + ", global: " + globalVisibleRect + ", topInWindow: " + i3 + ", offset: " + r16 + ", nextTarget: " + q16 + ", selStart: " + getSelectionStart());
            }
            if (r16 <= getSelectionStart() && !y16) {
                if (getOffsetForPosition(localVisibleRect.left, localVisibleRect.top) > getSelectionStart()) {
                    bringPointIntoView(getSelectionStart());
                }
            } else {
                EditorFields editorFields = this.editorFields;
                if (editorFields != null && (updateCursorPositionMethod = editorFields.getUpdateCursorPositionMethod()) != null) {
                    updateCursorPositionMethod.invoke(v3, Integer.valueOf(r16), Boolean.TRUE);
                }
            }
        }
    }

    private final void v(View v3, MotionEvent event, Rect globalVisibleRect, Rect localVisibleRect) {
        Method updateCursorPositionMethod;
        float rawY = (event.getRawY() - globalVisibleRect.top) + localVisibleRect.top;
        int offsetForPosition = getOffsetForPosition(event.getRawX(), rawY);
        if (offsetForPosition < getText().length()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GestureTextView", 4, "[cursor move inside] offset: " + offsetForPosition + ", global: " + globalVisibleRect + ", local: " + localVisibleRect + ", rawX: " + event.getRawX() + " rawY: " + event.getRawY() + ", localY: " + rawY);
            }
            EditorFields editorFields = this.editorFields;
            if (editorFields != null && (updateCursorPositionMethod = editorFields.getUpdateCursorPositionMethod()) != null) {
                updateCursorPositionMethod.invoke(v3, Integer.valueOf(offsetForPosition), Boolean.TRUE);
            }
        }
    }

    private final void w() {
        this.isHide = true;
        OperateWindow operateWindow = this.operateWindow;
        if (operateWindow != null) {
            operateWindow.n();
        }
    }

    private final void x(Drawable drawable) {
        if (W && isTextSelectable() && (getText() instanceof Spannable)) {
            this.blockRelayout = true;
            CharSequence text = getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
            F((Spannable) text, drawable);
            this.blockRelayout = false;
        }
    }

    private final boolean y(View v3) {
        return Intrinsics.areEqual(v3, this.startHandleView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(GestureTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C(this$0, 0L, 1, null);
        return true;
    }

    public final void I(boolean hide) {
        this.isHideWhenScroll = hide;
    }

    public final void K() {
        int coerceAtMost;
        int coerceAtLeast;
        int selectionStart = Selection.getSelectionStart(getText());
        int selectionEnd = Selection.getSelectionEnd(getText());
        SelectionInfo selectionInfo = this.selectionInfo;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(selectionStart, selectionEnd);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(selectionStart, selectionEnd);
        this.selectionInfo = selectionInfo.a(coerceAtMost, coerceAtLeast);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        invalidate();
        x(drawable);
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final EditorFields getEditorFields() {
        return this.editorFields;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        K();
        H();
        I(false);
        if (this.onPreDrawListener == null) {
            this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.b
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    boolean z16;
                    z16 = GestureTextView.z(GestureTextView.this);
                    return z16;
                }
            };
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.onScrollChangedListener);
            viewTreeObserver.addOnPreDrawListener(this.onPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
        I(true);
        removeCallbacks(this.updateSelectViewRunnable);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnScrollChangedListener(this.onScrollChangedListener);
            viewTreeObserver.removeOnPreDrawListener(this.onPreDrawListener);
        }
        this.onPreDrawListener = null;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (selEnd - selStart != 0 && V) {
            j();
        }
        Method method = null;
        Spannable spannable = null;
        boolean z16 = false;
        if (this.isCustomMenuEnabled && selStart != selEnd && !this.isHideWhenScroll) {
            CharSequence text = getText();
            if (text instanceof Spannable) {
                spannable = (Spannable) text;
            }
            if (spannable != null && h(spannable, selStart, selEnd)) {
                return;
            }
            K();
            OperateWindow operateWindow = this.operateWindow;
            if (operateWindow != null && operateWindow.p()) {
                z16 = true;
            }
            if (z16) {
                this.operateWindow.t(this.selectionInfo);
            } else {
                H();
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("GestureTextView", 4, "[onSelectionChanged] " + selStart + ", " + selEnd);
                return;
            }
            return;
        }
        K();
        w();
        if (selStart == selEnd) {
            m mVar = m.f221619a;
            EditorFields editorFields = this.editorFields;
            if (editorFields != null) {
                method = editorFields.getHideHandlerMethod();
            }
            mVar.d(method, this.selectionController, new Object[0]);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 || event.getAction() == 3) {
            H();
        }
        if (p().onTouchEvent(event) || super.onTouchEvent(event)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.blockRelayout) {
            super.requestLayout();
        }
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final Object getSelectionController() {
        return this.selectionController;
    }

    public final void setEditorFields(@Nullable EditorFields editorFields) {
        this.editorFields = editorFields;
    }

    public final void setSelectionController(@Nullable Object obj) {
        this.selectionController = obj;
    }

    public final void setStartHandleView(@Nullable View view) {
        this.startHandleView = view;
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        super.setText(text, type);
        o(text);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView$c", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "", "onDestroyActionMode", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ActionMode.Callback {
        c() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            if (menu != null) {
                menu.clear();
            }
            if (menu != null) {
                menu.close();
                return true;
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            if (menu != null) {
                menu.clear();
            }
            if (menu != null) {
                menu.close();
                return true;
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@Nullable ActionMode mode) {
        }
    }
}
