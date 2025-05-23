package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.menu.CustomMenuLayout;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.OperateWindow$statusCallback$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\f*\u0002\u0015#\u0018\u0000 \n2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow;", "", "Lqg1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/l;", "position", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/n;", "selectionInfo", "g", "window", "Landroid/view/View;", "k", "Lcom/tencent/mobileqq/guild/component/menu/b;", "j", "Landroid/view/View$OnClickListener;", tl.h.F, "", "text", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$b", "l", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$b;", "r", "t", DomainData.DOMAIN_NAME, "", "p", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;", "textView", "b", "Lqg1/a;", "com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$statusCallback$2$a", "c", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$statusCallback$2$a;", "statusCallback", "", "d", "[I", "tempCoors", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/l;", "lastPopupPosition", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/n;", "lastSelectionInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class OperateWindow {

    /* renamed from: h, reason: collision with root package name */
    private static final int f221585h = ViewUtils.dip2px(49.0f) + ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ);

    /* renamed from: i, reason: collision with root package name */
    private static final int f221586i = ViewUtils.dip2px(80.0f);

    /* renamed from: j, reason: collision with root package name */
    private static final int f221587j = ViewUtils.dip2px(36.0f);

    /* renamed from: k, reason: collision with root package name */
    private static final int f221588k = ViewUtils.dip2px(8.0f);

    /* renamed from: l, reason: collision with root package name */
    private static final int f221589l = ViewUtils.dip2px(6.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureTextView textView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qg1.a window;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] tempCoors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupPosition lastPopupPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectionInfo lastSelectionInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$b", "Lrg1/a;", "Landroid/content/Context;", "context", "", "e", "f", "c", "a", "b", "Landroid/view/View;", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements rg1.a {
        b() {
        }

        @Override // rg1.a
        public int a() {
            return OperateWindow.f221586i;
        }

        @Override // rg1.a
        public int b() {
            return OperateWindow.f221587j;
        }

        @Override // rg1.a
        public int c() {
            return OperateWindow.f221588k;
        }

        @Override // rg1.a
        @NotNull
        public View d(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view = new View(context);
            view.setBackgroundColor(context.getColor(R.color.f157324c50));
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2px(1.0f), -1));
            return view;
        }

        @Override // rg1.a
        public int e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getColor(R.color.c4v);
        }

        @Override // rg1.a
        public int f(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getColor(R.color.c4w);
        }
    }

    public OperateWindow(@NotNull GestureTextView textView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OperateWindow$statusCallback$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.OperateWindow$statusCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/OperateWindow$statusCallback$2$a", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ OperateWindow f221596a;

                a(OperateWindow operateWindow) {
                    this.f221596a = operateWindow;
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public /* bridge */ /* synthetic */ void onClick(View view) {
                    l53.d.a(this, view);
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public void onDismiss() {
                    GestureTextView gestureTextView;
                    gestureTextView = this.f221596a.textView;
                    gestureTextView.K();
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public void onShow() {
                    qg1.a aVar;
                    View v3;
                    GestureTextView gestureTextView;
                    aVar = this.f221596a.window;
                    if (aVar != null && (v3 = aVar.v()) != null) {
                        gestureTextView = this.f221596a.textView;
                        VideoReport.setLogicParent(v3, gestureTextView);
                        yl1.b.h(yl1.b.f450589a, v3, "em_sgrp_text_float", null, 4, null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(OperateWindow.this);
            }
        });
        this.statusCallback = lazy;
        this.tempCoors = new int[2];
    }

    private final PopupPosition g(SelectionInfo selectionInfo) {
        int i3;
        int coerceIn;
        int end;
        int coerceIn2;
        boolean z16;
        int lineBottom;
        int primaryHorizontal;
        boolean z17;
        int width;
        int width2;
        int paddingEnd;
        int intValue;
        this.textView.getLocationInWindow(this.tempCoors);
        Layout layout = this.textView.getLayout();
        Integer num = null;
        if (layout == null) {
            return null;
        }
        CharSequence text = this.textView.getText();
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return null;
        }
        boolean z18 = true;
        int i16 = i3 - 1;
        coerceIn = RangesKt___RangesKt.coerceIn(selectionInfo.getStart(), 0, i16);
        if (selectionInfo.getEnd() > 0) {
            end = selectionInfo.getEnd() - 1;
        } else {
            end = selectionInfo.getEnd();
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn(end, 0, i16);
        int lineForOffset = layout.getLineForOffset(coerceIn);
        int lineForOffset2 = layout.getLineForOffset(coerceIn2);
        if (lineForOffset2 > lineForOffset) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        int lineTop = layout.getLineTop(lineForOffset) + this.tempCoors[1];
        if (layout.getLineCount() - 1 != lineForOffset2) {
            lineBottom = layout.getLineBottom(lineForOffset2) + this.tempCoors[1];
        } else {
            lineBottom = (int) (layout.getLineBottom(lineForOffset2) + this.tempCoors[1] + this.textView.getLineSpacingExtra());
        }
        int i18 = f221585h;
        if (lineBottom >= i18 && lineTop <= i17) {
            this.textView.I(false);
            int i19 = lineTop - i18;
            int i26 = f221587j;
            if (i19 >= i26) {
                int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(selectionInfo.getStart());
                if (z16) {
                    width2 = this.textView.getWidth();
                    paddingEnd = this.textView.getPaddingEnd();
                } else {
                    Integer valueOf = Integer.valueOf((int) layout.getPrimaryHorizontal(selectionInfo.getEnd()));
                    if (valueOf.intValue() == 0) {
                        z18 = false;
                    }
                    if (z18) {
                        num = valueOf;
                    }
                    if (num != null) {
                        intValue = num.intValue();
                        return new PopupPosition((((primaryHorizontal2 + intValue) / 2) + this.tempCoors[0]) - (f221586i / 2), (lineTop - i26) - f221589l, 0);
                    }
                    width2 = this.textView.getWidth();
                    paddingEnd = this.textView.getPaddingEnd();
                }
                intValue = width2 - paddingEnd;
                return new PopupPosition((((primaryHorizontal2 + intValue) / 2) + this.tempCoors[0]) - (f221586i / 2), (lineTop - i26) - f221589l, 0);
            }
            if (z16) {
                primaryHorizontal = this.textView.getPaddingStart();
            } else {
                primaryHorizontal = (int) layout.getPrimaryHorizontal(selectionInfo.getStart());
            }
            Integer valueOf2 = Integer.valueOf((int) layout.getPrimaryHorizontal(selectionInfo.getEnd()));
            if (valueOf2.intValue() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                num = valueOf2;
            }
            if (num != null) {
                width = num.intValue();
            } else {
                width = this.textView.getWidth() - this.textView.getPaddingEnd();
            }
            return new PopupPosition((((primaryHorizontal + width) / 2) + this.tempCoors[0]) - (f221586i / 2), lineBottom - f221589l, 1);
        }
        this.textView.I(true);
        return null;
    }

    private final View.OnClickListener h() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OperateWindow.i(OperateWindow.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(OperateWindow this$0, View v3) {
        CharSequence text;
        Integer valueOf;
        int end;
        boolean z16;
        ClipboardManager clipboardManager;
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectionInfo selectionInfo = this$0.lastSelectionInfo;
        if (selectionInfo != null && (text = this$0.textView.getText()) != null) {
            if (selectionInfo.getStart() > selectionInfo.getEnd()) {
                valueOf = Integer.valueOf(selectionInfo.getEnd());
                end = selectionInfo.getStart();
            } else {
                valueOf = Integer.valueOf(selectionInfo.getStart());
                end = selectionInfo.getEnd();
            }
            Pair pair = TuplesKt.to(valueOf, Integer.valueOf(end));
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            boolean z17 = false;
            if (intValue >= 0 && intValue <= text.length()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (intValue2 >= 0 && intValue2 <= text.length()) {
                    z17 = true;
                }
                if (z17) {
                    String obj = text.subSequence(intValue, intValue2).toString();
                    if (v3.getId() == R.id.f114686u0) {
                        Object systemService = this$0.textView.getContext().getSystemService("clipboard");
                        if (systemService instanceof ClipboardManager) {
                            clipboardManager = (ClipboardManager) systemService;
                        } else {
                            clipboardManager = null;
                        }
                        if (clipboardManager != null) {
                            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(null, obj));
                        }
                        yl1.b bVar = yl1.b.f450589a;
                        Intrinsics.checkNotNullExpressionValue(v3, "v");
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_text", obj));
                        bVar.e(v3, "em_sgrp_text_float", mapOf);
                    }
                    this$0.q(text);
                }
            }
            QLog.e("OperateWindow", 1, "inValid params: start:" + intValue + " end:" + intValue2);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final com.tencent.mobileqq.guild.component.menu.b j() {
        com.tencent.mobileqq.guild.component.menu.b bVar = new com.tencent.mobileqq.guild.component.menu.b();
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.c.f221652a;
        Context context = this.textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        bVar.a(cVar.b(R.id.f114686u0, "\u590d\u5236", R.drawable.guild_feed_url_copy_allwhiite, context));
        return bVar;
    }

    private final View k(qg1.a window) {
        CustomMenuLayout e16 = CustomMenuLayout.e(window, this.textView.getContext(), j(), h(), l());
        Intrinsics.checkNotNullExpressionValue(e16, "createContent(\n         \u2026eateMenuStyle()\n        )");
        return e16;
    }

    private final b l() {
        return new b();
    }

    private final qg1.a m() {
        qg1.a aVar = new qg1.a(this.textView.getContext());
        aVar.S(this.textView);
        aVar.a0(k(aVar));
        aVar.E0(f221588k);
        aVar.R(0);
        aVar.b0(-1L);
        aVar.W(this.textView.getContext().getColor(R.color.c4v));
        aVar.g0(false);
        aVar.r0(false);
        aVar.p(false);
        return aVar;
    }

    private final OperateWindow$statusCallback$2.a o() {
        return (OperateWindow$statusCallback$2.a) this.statusCallback.getValue();
    }

    private final void q(CharSequence text) {
        Method method;
        m mVar = m.f221619a;
        EditorFields editorFields = this.textView.getEditorFields();
        Spannable spannable = null;
        if (editorFields != null) {
            method = editorFields.getHideHandlerMethod();
        } else {
            method = null;
        }
        mVar.d(method, this.textView.getSelectionController(), new Object[0]);
        if (text instanceof Spannable) {
            spannable = (Spannable) text;
        }
        if (spannable != null) {
            Selection.removeSelection(spannable);
        }
    }

    private final void s(PopupPosition position) {
        qg1.a aVar = this.window;
        if (aVar != null) {
            aVar.k0(position.getArrowPosition());
            aVar.F0(position.getPosX(), position.getPosY());
            aVar.G0(position.getPosX() + (f221586i / 2), position.getPosY());
            aVar.f(o());
            aVar.s0();
        }
    }

    public final void n() {
        qg1.a aVar;
        if (p() && (aVar = this.window) != null) {
            aVar.o();
        }
    }

    public final boolean p() {
        qg1.a aVar = this.window;
        if (aVar == null || !aVar.L()) {
            return false;
        }
        return true;
    }

    public final void r(@NotNull SelectionInfo selectionInfo) {
        Unit unit;
        Intrinsics.checkNotNullParameter(selectionInfo, "selectionInfo");
        if (this.window == null) {
            this.window = m();
        }
        if (!p()) {
            this.lastSelectionInfo = selectionInfo;
            PopupPosition g16 = g(selectionInfo);
            if (g16 != null) {
                this.lastPopupPosition = g16;
                s(g16);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                n();
            }
        }
    }

    public final void t(@NotNull SelectionInfo selectionInfo) {
        Intrinsics.checkNotNullParameter(selectionInfo, "selectionInfo");
        this.lastSelectionInfo = selectionInfo;
        if (this.window == null) {
            return;
        }
        PopupPosition g16 = g(selectionInfo);
        if (g16 == null) {
            n();
            return;
        }
        if (Intrinsics.areEqual(g16, this.lastPopupPosition)) {
            return;
        }
        PopupPosition popupPosition = this.lastPopupPosition;
        boolean z16 = false;
        if (popupPosition != null && popupPosition.getArrowPosition() == g16.getArrowPosition()) {
            z16 = true;
        }
        if (!z16) {
            qg1.a aVar = this.window;
            if (aVar != null) {
                aVar.o();
            }
            s(g16);
        } else if (p()) {
            qg1.a aVar2 = this.window;
            if (aVar2 != null) {
                aVar2.H0(g16.getPosX(), g16.getPosY());
            }
        } else {
            s(g16);
        }
        this.lastPopupPosition = g16;
    }
}
