package com.tencent.aio.widget.textView.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.widget.textView.api.c;
import com.tencent.aio.widget.textView.creator.g;
import com.tencent.aio.widget.textView.param.b;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00c5\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001`B.\b\u0007\u0012\b\u0010\u00bf\u0001\u001a\u00030\u00be\u0001\u0012\f\b\u0002\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00c0\u0001\u0012\t\b\u0002\u0010\u00c2\u0001\u001a\u00020\u0007\u00a2\u0006\u0006\b\u00c3\u0001\u0010\u00c4\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J:\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152(\u0010\u001b\u001a$\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0005H\u0014J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016J\u001a\u0010*\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\nH\u0016J(\u00104\u001a\u00020\u00052\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020+00j\b\u0012\u0004\u0012\u00020+`12\u0006\u00103\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020(H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00109\u001a\u000208H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000fH\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020$H\u0016J\b\u0010D\u001a\u00020$H\u0016J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020$H\u0016J\b\u0010G\u001a\u00020$H\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020$H\u0016J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0007H\u0016J\u0018\u0010N\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J0\u0010T\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0014J\b\u0010U\u001a\u00020\u0005H\u0014J\u0012\u0010X\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010VH\u0014J\u0010\u0010Z\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020+H\u0014J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\\\u001a\u00020$J\u0018\u0010`\u001a\u00020\u00052\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020\u0019H\u0016J\b\u0010b\u001a\u00020aH\u0016J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010c\u001a\u00020aH\u0016J\u0010\u0010f\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0007H\u0016J\u0010\u0010h\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0018H\u0016J \u0010k\u001a\u0012\u0012\u0004\u0012\u00020]\u0012\u0006\u0012\u0004\u0018\u00010j\u0018\u00010i2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010m\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u000fH\u0016J\u0010\u0010o\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\u000fH\u0016J\b\u0010p\u001a\u00020\u0005H\u0016J\n\u0010q\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010r\u001a\u0004\u0018\u00010jH\u0016J&\u0010x\u001a\u0004\u0018\u00010w2\u0006\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00072\n\u0010v\u001a\u0006\u0012\u0002\b\u00030uH\u0016R\u001b\u0010~\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u007fR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u0081\u0001R\u0019\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b|\u0010\u0082\u0001R\u0017\u0010B\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\br\u0010\u0083\u0001R\u0017\u0010E\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bD\u0010\u0083\u0001R\u0018\u0010H\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u008b\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010]8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0089\u0001R\u0019\u0010\u0097\u0001\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0096\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009c\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0083\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R*\u0010)\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a0\u0001\u0010\u009e\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001\"\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001a\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0018\u0010J\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u0086\u0001R\u0018\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u0086\u0001R\u001b\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u0099\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u0019\u0010\u00b1\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u0089\u0001R\u0019\u0010\u00b3\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0089\u0001R\u0018\u0010n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u0089\u0001R-\u0010\u00b7\u0001\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u000100j\n\u0012\u0004\u0012\u00020+\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u0019\u0010\u00b9\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u0086\u0001R\u0019\u0010\u00bb\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u0089\u0001R\u0019\u0010\u00bd\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u0089\u0001\u00a8\u0006\u00c6\u0001"}, d2 = {"Lcom/tencent/aio/widget/textView/view/AioTextView;", "Landroid/view/View;", "Lcom/tencent/aio/widget/textView/api/c;", "Lcom/tencent/aio/widget/textView/creator/g$b;", "Lcom/tencent/aio/widget/textView/creator/g$a;", "", "w", "", "p", "k", "Lcom/tencent/aio/widget/textView/view/a;", "spanCallback", "", "text", "t", "", "u", "limitWidth", "j", "maxLayoutWidth", "e", "Landroid/view/MotionEvent;", "event", "Lkotlin/Function4;", "Lcom/tencent/aio/widget/textView/view/b;", "Landroid/text/StaticLayout;", "Landroid/text/Spanned;", "method", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/widget/textView/param/b$a;", "f", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "setLinkTextColor", "drawableStateChanged", "", "size", "setTextSize", "value", "", "valueKey", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/drawable/Drawable;", "drawable", "invalidateDrawable", TtmlNode.TAG_SPAN, "setSpanCallBack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "drawables", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "setMaxLines", "assetPath", "setTypeface", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setEllipsize", "Landroid/text/Layout$Alignment;", "alignment", "setAlignment", "include", "setIncludePad", "spacingMult", "setSpacingMult", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "spacingAdd", "setSpacingAdd", "l", NodeProps.LETTER_SPACING, "setLetterSpacing", NodeProps.MAX_WIDTH, "setMaxWidth", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "who", "verifyDrawable", "onTouchEvent", "r", "Lcom/tencent/aio/widget/textView/param/b;", "param", "staticLayout", "a", "Landroid/text/TextPaint;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "paint", "setTextPaint", LayoutAttrDefine.Gravity.Gravity, "setGravity", "movement", "setMovementMethod", "Lkotlin/Pair;", "Landroid/text/Layout;", "v", "preCreate", "setIsPreCreate", "needDoubleCheck", "setNeedDoubleCheck", "setSyncCreateLayout", "o", "i", HippyTKDListViewAdapter.X, "y", "Ljava/lang/Class;", "classType", "", DomainData.DOMAIN_NAME, "Landroid/view/GestureDetector;", "d", "Lkotlin/Lazy;", h.F, "()Landroid/view/GestureDetector;", "gestureDetector", "Landroid/text/TextPaint;", "textPaint", "Ljava/lang/CharSequence;", "Landroid/text/TextUtils$TruncateAt;", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "D", "I", "maxLines", "E", "Z", "includePad", "Landroid/text/StaticLayout;", TtmlNode.TAG_LAYOUT, "G", "Lcom/tencent/aio/widget/textView/param/b;", "g", "()Lcom/tencent/aio/widget/textView/param/b;", "setCurrentParam", "(Lcom/tencent/aio/widget/textView/param/b;)V", "currentParam", "H", "wasLayout", "Landroid/text/Layout$Alignment;", "align", "J", "Landroid/content/res/ColorStateList;", "textColor", "K", "textSize", "L", "Ljava/lang/String;", "textTypeface", "M", "getValueKey", "()Ljava/lang/String;", "setValueKey", "(Ljava/lang/String;)V", "N", "Landroid/graphics/Typeface;", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "linkColor", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/widget/textView/view/b;", "mMovement", "T", "Lcom/tencent/aio/widget/textView/view/a;", "U", "isPreCreate", "V", "syncCreateLayout", "W", "a0", "Ljava/util/ArrayList;", "holdDrawables", "b0", "loadDrawableAsyncTaskId", "c0", "loadDrawableDone", "d0", "firstDrawDone", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f0", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class AioTextView extends View implements c, g.b, g.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    public static g f70072e0;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float letterSpacing;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxLines;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean includePad;

    /* renamed from: F, reason: from kotlin metadata */
    private StaticLayout layout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.widget.textView.param.b currentParam;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean wasLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private Layout.Alignment align;

    /* renamed from: J, reason: from kotlin metadata */
    private ColorStateList textColor;

    /* renamed from: K, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: L, reason: from kotlin metadata */
    private String textTypeface;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String valueKey;

    /* renamed from: N, reason: from kotlin metadata */
    private Typeface typeface;

    /* renamed from: P, reason: from kotlin metadata */
    private int maxWidth;

    /* renamed from: Q, reason: from kotlin metadata */
    private int gravity;

    /* renamed from: R, reason: from kotlin metadata */
    private ColorStateList linkColor;

    /* renamed from: S, reason: from kotlin metadata */
    private b mMovement;

    /* renamed from: T, reason: from kotlin metadata */
    private a spanCallback;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isPreCreate;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean syncCreateLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean needDoubleCheck;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private volatile ArrayList<Drawable> holdDrawables;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int loadDrawableAsyncTaskId;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean loadDrawableDone;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy gestureDetector;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean firstDrawDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextPaint textPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CharSequence text;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextUtils.TruncateAt ellipsize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float spacingMult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float spacingAdd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/widget/textView/view/AioTextView$a;", "", "Lcom/tencent/aio/widget/textView/creator/g;", "creator", "Lcom/tencent/aio/widget/textView/creator/g;", "getCreator$simple_textView_debug", "()Lcom/tencent/aio/widget/textView/creator/g;", "a", "(Lcom/tencent/aio/widget/textView/creator/g;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.view.AioTextView$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public final void a(@NotNull g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            } else {
                Intrinsics.checkNotNullParameter(gVar, "<set-?>");
                AioTextView.f70072e0 = gVar;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 50)) {
            redirector.redirect((short) 50);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public AioTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
            return;
        }
        iPatchRedirector.redirect((short) 49, (Object) this, (Object) context);
    }

    private final boolean e(int maxLayoutWidth) {
        StaticLayout staticLayout;
        TextPaint paint;
        int i3 = 0;
        if (TextUtils.isEmpty(this.text)) {
            return false;
        }
        com.tencent.aio.widget.textView.param.b a16 = f(maxLayoutWidth).a();
        g gVar = f70072e0;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creator");
        }
        com.tencent.aio.widget.textView.cache.a f16 = gVar.f(a16);
        CharSequence charSequence = null;
        if (f16 != null) {
            staticLayout = f16.b();
        } else {
            staticLayout = null;
        }
        this.layout = staticLayout;
        if (staticLayout != null) {
            com.tencent.aio.widget.textView.log.a aVar = com.tencent.aio.widget.textView.log.a.f70035a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[createLayout] \u547d\u4e2d\u7f13\u5b58 this: ");
            sb5.append(hashCode());
            sb5.append(", ");
            sb5.append("layout: ");
            StaticLayout staticLayout2 = this.layout;
            if (staticLayout2 != null) {
                i3 = staticLayout2.hashCode();
            }
            sb5.append(i3);
            sb5.append(", required width: ");
            sb5.append(getWidth());
            sb5.append(", layoutWidth: ");
            StaticLayout staticLayout3 = this.layout;
            Intrinsics.checkNotNull(staticLayout3);
            sb5.append(staticLayout3.getWidth());
            aVar.a("AioTextView", sb5.toString());
            StaticLayout staticLayout4 = this.layout;
            if (staticLayout4 != null && (paint = staticLayout4.getPaint()) != null) {
                paint.setColor(this.textPaint.getColor());
            }
            this.currentParam = a16;
            g gVar2 = f70072e0;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creator");
            }
            com.tencent.aio.widget.textView.cache.a f17 = gVar2.f(a16);
            if (f17 != null) {
                charSequence = f17.a();
            }
            t(this.spanCallback, charSequence);
            this.text = charSequence;
            return true;
        }
        if (this.syncCreateLayout) {
            g gVar3 = f70072e0;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creator");
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            StaticLayout d16 = gVar3.d(a16, context, this.textPaint);
            this.currentParam = a16;
            this.layout = d16;
        } else {
            g gVar4 = f70072e0;
            if (gVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creator");
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            gVar4.a(a16, context2, this.textPaint, this);
        }
        t(this.spanCallback, this.text);
        return true;
    }

    private final b.a f(int maxLayoutWidth) {
        b.a aVar = new b.a();
        CharSequence charSequence = this.text;
        Intrinsics.checkNotNull(charSequence);
        aVar.j(charSequence);
        aVar.o(this.textSize);
        aVar.p(this.textTypeface);
        aVar.i(maxLayoutWidth);
        aVar.b(this.align);
        aVar.m(this.spacingMult);
        aVar.l(this.spacingAdd);
        aVar.f(this.letterSpacing);
        aVar.e(this.includePad);
        aVar.d(this.ellipsize);
        aVar.h(this.maxLines);
        aVar.c(maxLayoutWidth);
        aVar.k(this.valueKey);
        aVar.q(this.typeface);
        aVar.n(this.textPaint.getColor());
        aVar.g(this.textPaint.linkColor);
        return aVar;
    }

    private final GestureDetector h() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    private final int j(int limitWidth) {
        int coerceAtLeast;
        int coerceAtMost;
        if (!TextUtils.isEmpty(this.text)) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, (limitWidth - getPaddingLeft()) - getPaddingRight());
            CharSequence charSequence = this.text;
            if (charSequence != null) {
                limitWidth = charSequence.length();
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) Math.ceil(Layout.getDesiredWidth(charSequence, 0, limitWidth, this.textPaint)), coerceAtLeast);
            if (coerceAtMost <= 0) {
                return 0;
            }
            return coerceAtMost + getPaddingLeft() + getPaddingRight();
        }
        return 0;
    }

    private final int k() {
        ColorStateList colorStateList = this.linkColor;
        if (colorStateList == null) {
            return -16776961;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        if (colorForState == 0) {
            int defaultColor = colorStateList.getDefaultColor();
            if (defaultColor == 0) {
                return -16776961;
            }
            return defaultColor;
        }
        return colorForState;
    }

    private final int p() {
        int colorForState = this.textColor.getColorForState(getDrawableState(), 0);
        if (colorForState == 0) {
            int defaultColor = this.textColor.getDefaultColor();
            if (defaultColor == 0) {
                return -16777216;
            }
            return defaultColor;
        }
        return colorForState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(MotionEvent event, Function4<? super b, ? super StaticLayout, ? super Spanned, ? super MotionEvent, Boolean> method) {
        Spanned spanned;
        b bVar = this.mMovement;
        if (bVar != null) {
            CharSequence charSequence = this.text;
            if (charSequence instanceof Spanned) {
                if (charSequence != null) {
                    spanned = (Spanned) charSequence;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
                }
            } else {
                spanned = null;
            }
            return method.invoke(bVar, this.layout, spanned, event).booleanValue();
        }
        return false;
    }

    private final void t(a spanCallback, CharSequence text) {
        if (text instanceof Spanned) {
            this.loadDrawableAsyncTaskId++;
            g gVar = f70072e0;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creator");
            }
            gVar.c(text, this, this, spanCallback, this.loadDrawableAsyncTaskId);
        }
    }

    private final boolean u() {
        if ((this.wasLayout && getMeasuredHeight() != 0) || this.isPreCreate) {
            return false;
        }
        requestLayout();
        return true;
    }

    private final void w() {
        boolean z16;
        int p16 = p();
        boolean z17 = true;
        if (p16 != this.textPaint.getColor()) {
            this.textPaint.setColor(p16);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.linkColor != null) {
            int k3 = k();
            TextPaint textPaint = this.textPaint;
            if (k3 != textPaint.linkColor) {
                textPaint.linkColor = k3;
            } else {
                z17 = z16;
            }
            z16 = z17;
        }
        if (z16) {
            invalidate();
        }
    }

    @Override // com.tencent.aio.widget.textView.creator.g.b
    public void a(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull StaticLayout staticLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) param, (Object) staticLayout);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(staticLayout, "staticLayout");
        this.currentParam = param;
        this.layout = staticLayout;
        requestLayout();
    }

    @Override // com.tencent.aio.widget.textView.creator.g.a
    public void b(@NotNull ArrayList<Drawable> drawables, int taskId) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) drawables, taskId);
            return;
        }
        Intrinsics.checkNotNullParameter(drawables, "drawables");
        if (taskId != this.loadDrawableAsyncTaskId) {
            return;
        }
        this.holdDrawables = drawables;
        boolean z16 = true;
        this.loadDrawableDone = true;
        invalidate();
        ArrayList<Drawable> arrayList = this.holdDrawables;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            com.tencent.aio.widget.textView.log.a aVar = com.tencent.aio.widget.textView.log.a.f70035a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onGetDrawables] this: ");
            sb5.append(hashCode());
            sb5.append(", ");
            sb5.append("drawables size: ");
            ArrayList<Drawable> arrayList2 = this.holdDrawables;
            if (arrayList2 != null) {
                num = Integer.valueOf(arrayList2.size());
            } else {
                num = null;
            }
            sb5.append(num);
            aVar.a("AioTextView", sb5.toString());
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (this.textColor.isStateful() || ((colorStateList = this.linkColor) != null && colorStateList.isStateful())) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.aio.widget.textView.param.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.widget.textView.param.b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.currentParam;
    }

    @Nullable
    public Layout i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (Layout) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.layout;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable);
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            invalidate();
        }
    }

    public float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.spacingAdd;
    }

    public float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Float) iPatchRedirector.redirect((short) 21, (Object) this)).floatValue();
        }
        return this.spacingMult;
    }

    @Nullable
    public Object n(int x16, int y16, @NotNull Class<?> classType) {
        CharSequence o16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return iPatchRedirector.redirect((short) 45, this, Integer.valueOf(x16), Integer.valueOf(y16), classType);
        }
        Intrinsics.checkNotNullParameter(classType, "classType");
        Layout i3 = i();
        if (i3 != null) {
            float f16 = x16;
            int offsetForHorizontal = i3.getOffsetForHorizontal(i3.getLineForVertical(y16), f16);
            if (f16 - i3.getSecondaryHorizontal(offsetForHorizontal) <= this.textSize && (o16 = o()) != null && (o16 instanceof Spanned)) {
                Object[] spans = ((Spanned) o16).getSpans(offsetForHorizontal, offsetForHorizontal, classType);
                if (spans != null) {
                    if (spans.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                    }
                }
                if (!z17) {
                    return spans[0];
                }
            }
        }
        return null;
    }

    @Nullable
    public CharSequence o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (CharSequence) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.text;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.wasLayout = false;
        g gVar = f70072e0;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creator");
        }
        gVar.b(this);
        g gVar2 = f70072e0;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creator");
        }
        gVar2.g(hashCode());
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) canvas);
            return;
        }
        if (this.layout == null) {
            return;
        }
        int i3 = 0;
        if (!this.firstDrawDone && !this.loadDrawableDone) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.firstDrawDone = true;
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.translate(getPaddingLeft(), r());
        }
        long currentTimeMillis = System.currentTimeMillis();
        StaticLayout staticLayout = this.layout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        com.tencent.aio.widget.textView.log.a aVar = com.tencent.aio.widget.textView.log.a.f70035a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("this: ");
        sb5.append(hashCode());
        sb5.append(", layout: ");
        StaticLayout staticLayout2 = this.layout;
        if (staticLayout2 != null) {
            i3 = staticLayout2.hashCode();
        }
        sb5.append(i3);
        sb5.append(" drawTime ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        aVar.a("AioTextView", sb5.toString());
        if (canvas != null) {
            canvas.restore();
        }
        if (z16) {
            t(this.spanCallback, this.text);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            this.wasLayout = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int j3;
        StaticLayout staticLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int min = Math.min(size, this.maxWidth);
        if (mode == 1073741824) {
            j3 = min;
        } else {
            j3 = j(min);
        }
        e(j3);
        if (this.needDoubleCheck) {
            if (mode != 1073741824) {
                min = j(min);
            }
            if (j3 != min) {
                e(min);
                j3 = min;
            }
        }
        if (mode2 != 1073741824 && (staticLayout = this.layout) != null) {
            size2 = staticLayout.getHeight();
        }
        setMeasuredDimension(j3, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (h().onTouchEvent(event) || s(event, new Function4<b, StaticLayout, Spanned, MotionEvent, Boolean>() { // from class: com.tencent.aio.widget.textView.view.AioTextView$onTouchEvent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AioTextView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(b bVar, StaticLayout staticLayout, Spanned spanned, MotionEvent motionEvent) {
                return Boolean.valueOf(invoke2(bVar, staticLayout, spanned, motionEvent));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull b movementMethod, @Nullable StaticLayout staticLayout, @Nullable Spanned spanned, @NotNull MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 1, this, movementMethod, staticLayout, spanned, motionEvent)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
                Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                return movementMethod.d(AioTextView.this, staticLayout, spanned, motionEvent);
            }
        })) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @NotNull
    public TextPaint q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (TextPaint) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.textPaint;
    }

    public final float r() {
        StaticLayout staticLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Float) iPatchRedirector.redirect((short) 33, (Object) this)).floatValue();
        }
        int i3 = this.gravity;
        if ((i3 == 16 || i3 == 17) && (staticLayout = this.layout) != null) {
            return (getHeight() - staticLayout.getHeight()) / 2.0f;
        }
        return getPaddingTop();
    }

    public void setAlignment(@NotNull Layout.Alignment alignment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) alignment);
            return;
        }
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (this.align == alignment) {
            return;
        }
        this.align = alignment;
        u();
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt ellipsize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) ellipsize);
        } else {
            if (this.ellipsize == ellipsize) {
                return;
            }
            this.ellipsize = ellipsize;
            u();
        }
    }

    public void setGravity(int gravity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, gravity);
        } else {
            this.gravity = gravity;
        }
    }

    public void setIncludePad(boolean include) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, include);
        } else {
            if (include == this.includePad) {
                return;
            }
            this.includePad = include;
            u();
        }
    }

    public void setIsPreCreate(boolean preCreate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, preCreate);
        } else {
            this.isPreCreate = preCreate;
        }
    }

    public void setLetterSpacing(float letterSpacing) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(letterSpacing));
        } else {
            if (this.letterSpacing == letterSpacing) {
                return;
            }
            this.letterSpacing = letterSpacing;
            this.textPaint.setLetterSpacing(letterSpacing);
            u();
        }
    }

    @Override // com.tencent.aio.widget.textView.api.c
    public void setLinkTextColor(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) color);
            return;
        }
        Intrinsics.checkNotNullParameter(color, "color");
        if (Intrinsics.areEqual(this.linkColor, color)) {
            return;
        }
        this.linkColor = color;
        w();
    }

    public void setMaxLines(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, value);
        } else {
            if (this.maxLines == value) {
                return;
            }
            this.maxLines = value;
            u();
        }
    }

    public void setMaxWidth(int maxWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, maxWidth);
        } else {
            if (this.maxWidth == maxWidth) {
                return;
            }
            this.maxWidth = maxWidth;
            u();
        }
    }

    public void setMovementMethod(@NotNull b movement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) movement);
        } else {
            Intrinsics.checkNotNullParameter(movement, "movement");
            this.mMovement = movement;
        }
    }

    public void setNeedDoubleCheck(boolean needDoubleCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, needDoubleCheck);
        } else {
            this.needDoubleCheck = needDoubleCheck;
        }
    }

    public void setSpacingAdd(float spacingAdd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(spacingAdd));
        } else {
            if (this.spacingAdd == spacingAdd) {
                return;
            }
            this.spacingAdd = spacingAdd;
            u();
        }
    }

    public void setSpacingMult(float spacingMult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(spacingMult));
        } else {
            if (this.spacingMult == spacingMult) {
                return;
            }
            this.spacingMult = spacingMult;
            u();
        }
    }

    public void setSpanCallBack(@Nullable a span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) span);
        } else {
            this.spanCallback = span;
        }
    }

    public void setSyncCreateLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.syncCreateLayout = true;
        }
    }

    public void setText(@Nullable CharSequence value, @NotNull String valueKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) value, (Object) valueKey);
            return;
        }
        Intrinsics.checkNotNullParameter(valueKey, "valueKey");
        if (Intrinsics.areEqual(this.text, value)) {
            return;
        }
        this.text = value;
        this.valueKey = valueKey;
        this.loadDrawableDone = false;
        this.firstDrawDone = false;
        requestLayout();
    }

    @Override // com.tencent.aio.widget.textView.api.c
    public void setTextColor(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) color);
            return;
        }
        Intrinsics.checkNotNullParameter(color, "color");
        if (Intrinsics.areEqual(this.textColor, color)) {
            return;
        }
        this.textColor = color;
        w();
    }

    public void setTextPaint(@NotNull TextPaint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) paint);
        } else {
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.textPaint = paint;
        }
    }

    public void setTextSize(float size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(size));
        } else {
            if (this.textSize == size && this.textPaint.getTextSize() == size) {
                return;
            }
            this.textSize = size;
            this.textPaint.setTextSize(size);
            u();
        }
    }

    public void setTypeface(@NotNull String assetPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) assetPath);
            return;
        }
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        if (Intrinsics.areEqual(this.textTypeface, assetPath)) {
            return;
        }
        this.textTypeface = assetPath;
        u();
    }

    @Nullable
    public Pair<com.tencent.aio.widget.textView.param.b, Layout> v(int maxLayoutWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (Pair) iPatchRedirector.redirect((short) 39, (Object) this, maxLayoutWidth);
        }
        com.tencent.aio.widget.textView.param.b a16 = f(j(maxLayoutWidth)).a();
        g gVar = f70072e0;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creator");
        }
        com.tencent.aio.widget.textView.cache.a f16 = gVar.f(a16);
        if (f16 != null) {
            return new Pair<>(a16, f16.b());
        }
        this.currentParam = a16;
        g gVar2 = f70072e0;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creator");
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StaticLayout d16 = gVar2.d(a16, context, this.textPaint);
        this.layout = d16;
        return new Pair<>(a16, d16);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) who)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(who, "who");
        super.verifyDrawable(who);
        return true;
    }

    @JvmOverloads
    public AioTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
            return;
        }
        iPatchRedirector.redirect((short) 48, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AioTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            return;
        }
        iPatchRedirector.redirect((short) 47, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AioTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(new AioTextView$gestureDetector$2(this, context));
        this.gestureDetector = lazy;
        this.textPaint = new TextPaint();
        this.spacingMult = 1.0f;
        this.maxLines = Integer.MAX_VALUE;
        this.includePad = true;
        this.align = Layout.Alignment.ALIGN_NORMAL;
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.BLACK)");
        this.textColor = valueOf;
        this.textSize = com.tencent.aio.widget.textView.utils.a.f70071a.a(context, 16);
        this.maxWidth = Integer.MAX_VALUE;
        this.gravity = 48;
    }

    public void setTypeface(@NotNull Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) typeface);
            return;
        }
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        if (Intrinsics.areEqual(this.typeface, typeface)) {
            return;
        }
        this.typeface = typeface;
        this.textPaint.setTypeface(typeface);
        u();
    }
}
