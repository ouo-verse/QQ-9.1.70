package com.tencent.mobileqq.tianshu.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\b\t*\u0002\u00c8\u0001\b\u0016\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0005p\u00ce\u0001\u00cf\u0001B\u001c\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\t\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0006\b\u00cc\u0001\u0010\u00cd\u0001J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u001c\u0010!\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u001c\u0010$\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010'\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0012\u0010)\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0012\u0010+\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010,\u001a\u00020\fH\u0002J\n\u0010.\u001a\u0004\u0018\u00010-H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u00020\fH\u0002J\u0010\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0002J\u0010\u00107\u001a\u0002042\u0006\u00106\u001a\u000204H\u0002J\u0018\u0010<\u001a\u00020\u00002\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u0002082\u0006\u0010;\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020\u0000H\u0002J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u00020\u0000H\u0002J\b\u0010B\u001a\u00020\u0000H\u0002J\u001c\u0010E\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010D\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\b\u0010J\u001a\u00020\u0010H\u0002J\u0006\u0010K\u001a\u00020\fJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\fJ\u000e\u0010O\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\fJ\u0010\u0010Q\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010PJ\u0006\u0010R\u001a\u00020\u0010J\u0006\u0010S\u001a\u00020\u0000J\u0010\u0010U\u001a\u00020\u00002\b\u0010T\u001a\u0004\u0018\u00010\nJ\u0010\u0010V\u001a\u00020\u00002\b\u0010T\u001a\u0004\u0018\u00010\nJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0012J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u000204J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\u000e\u0010a\u001a\u00020\u00002\u0006\u00109\u001a\u00020`J\u000e\u0010b\u001a\u00020\u00002\u0006\u00109\u001a\u00020`J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010Y\u001a\u000202J\b\u0010Y\u001a\u00020\u0010H\u0004J\u0006\u0010d\u001a\u00020\u0000J\u0006\u0010e\u001a\u00020\u0000J\u0006\u0010f\u001a\u00020\u0000J(\u0010j\u001a\u00020\u00102\u0006\u0010R\u001a\u0002042\u0006\u0010g\u001a\u0002042\u0006\u0010h\u001a\u0002042\u0006\u0010i\u001a\u000204H\u0014J\u0010\u0010k\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\b\u0010l\u001a\u0004\u0018\u00010\nJ\u0016\u0010p\u001a\u00020\u00102\f\u0010o\u001a\b\u0012\u0004\u0012\u00020n0mH\u0016J\u0018\u0010r\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010q\u001a\u00020\fR\u001a\u0010w\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010xR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR&\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bg\u0010{\u001a\u0005\b\u0080\u0001\u0010}\"\u0005\b\u0081\u0001\u0010\u007fR+\u0010\u0088\u0001\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010{R\u0019\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010{R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010tR\u0017\u0010\u008b\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\tR'\u0010\u0090\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bV\u0010\t\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b+\u0010\u0091\u0001R\u0019\u0010\u0095\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b,\u0010\u0094\u0001R\u0018\u0010\u0097\u0001\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b>\u0010\u0096\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b)\u0010\u0091\u0001R\u0018\u0010\u009a\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u0099\u0001R\u0017\u0010\u009b\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010>R\u0018\u0010\u009d\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010\tR\u0017\u0010\u009e\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\tR\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bu\u0010\u0091\u0001R\u001a\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bK\u0010\u00a0\u0001R\u0018\u0010\u00a3\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bJ\u0010\u00a2\u0001R,\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001\"\u0006\b\u00a9\u0001\u0010\u00aa\u0001R'\u0010\u00ae\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b0\u0010\t\u001a\u0006\b\u00ac\u0001\u0010\u008d\u0001\"\u0006\b\u00ad\u0001\u0010\u008f\u0001R\u0019\u0010\u00b1\u0001\u001a\u00030\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u00b0\u0001RH\u0010\u00ba\u0001\u001a\"\u0012\u0015\u0012\u00130\n\u00a2\u0006\u000e\b\u00b3\u0001\u0012\t\b\u00b4\u0001\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00b2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u001b\u0010\u00b5\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001\"\u0006\b\u00b8\u0001\u0010\u00b9\u0001RH\u0010\u00bd\u0001\u001a\"\u0012\u0015\u0012\u00130\n\u00a2\u0006\u000e\b\u00b3\u0001\u0012\t\b\u00b4\u0001\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00b2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0018\u0010\u00b5\u0001\u001a\u0006\b\u00bb\u0001\u0010\u00b7\u0001\"\u0006\b\u00bc\u0001\u0010\u00b9\u0001RH\u0010\u00c0\u0001\u001a\"\u0012\u0015\u0012\u00130\n\u00a2\u0006\u000e\b\u00b3\u0001\u0012\t\b\u00b4\u0001\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00b2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b7\u0010\u00b5\u0001\u001a\u0006\b\u00be\u0001\u0010\u00b7\u0001\"\u0006\b\u00bf\u0001\u0010\u00b9\u0001RH\u0010\u00c3\u0001\u001a\"\u0012\u0015\u0012\u00130\n\u00a2\u0006\u000e\b\u00b3\u0001\u0012\t\b\u00b4\u0001\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00b2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0016\u0010\u00b5\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00b7\u0001\"\u0006\b\u00c2\u0001\u0010\u00b9\u0001R(\u0010\u00c6\u0001\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\u0017\u0010t\u001a\u0005\b\u009c\u0001\u0010v\"\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u0017\u0010\u00c7\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010\tR\u0017\u0010\u00ca\u0001\u001a\u00030\u00c8\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bI\u0010\u00c9\u0001\u00a8\u0006\u00d0\u0001"}, d2 = {"Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/tianshu/ui/c;", "Landroid/content/Context;", "context", "u", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup$LayoutParams;", "Z", "", "path", "", "D", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "", "z0", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$RedTouchAssembleType;", "redTouchAssembleTypeArgs", "w0", "D0", "b0", "c0", "W", "Y", "X", "V", "argPath", "C0", "E0", "redDotAppInfo", "redNumberAppInfo", "F0", "G0", "appInfoNumber", "H0", "redDotInfo", "redNumberInfo", "A0", "B", "J", "u0", "G", "H", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "e", ReportConstant.COSTREPORT_PREFIX, "T", "U", "", "dip", "", "E", "pxValue", "a0", "Landroid/view/ViewGroup$MarginLayoutParams;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$b;", "params", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "I", "target", "f0", "y0", "r", "redPath", "path2", "K", "d0", "t0", "p", "e0", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "open", "l0", "hidden", "setHiddenRedBadge", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "B0", "w", HippyTKDListViewAdapter.X, "extra", "y", UserInfo.SEX_FEMALE, "type", "p0", "v", "h0", "j0", "q0", "r0", "g0", "i0", "Landroid/widget/FrameLayout$LayoutParams;", "m0", "k0", "s0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "n0", "O", "", "Lcom/tencent/mobileqq/tianshu/bean/a;", "list", "a", "autoReportEx", "o0", "d", "Ljava/lang/String;", "P", "()Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$RedTouchAssembleType;", "redTouchAssembleType", "f", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "L", "()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "setAppInfo", "(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V", "getRedNumberAppInfo", "setRedNumberAppInfo", "i", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "getRedTypeInfo", "()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "setRedTypeInfo", "(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;)V", "redTypeInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "redDotNumberAppInfo", "openAutoUpdate", "getOpenAutoExpose", "()Z", "setOpenAutoExpose", "(Z)V", "openAutoExpose", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "badgeLayoutContainer", "Landroid/widget/FrameLayout$LayoutParams;", "parentLayout", "redBadge", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$b;", "redBadgeLayoutParams", "redDotSize", "M", "fitDefaultRedDotSize", "hiddenRedDot", "numberRedBadge", "Landroid/view/ViewGroup$LayoutParams;", "numberRedBadgeLayout", "Landroid/widget/FrameLayout;", "midParentView", "Lcom/tencent/mobileqq/tianshu/observer/c;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/tianshu/observer/c;", "getRedBadgeDelayInfo", "()Lcom/tencent/mobileqq/tianshu/observer/c;", "setRedBadgeDelayInfo", "(Lcom/tencent/mobileqq/tianshu/observer/c;)V", "redBadgeDelayInfo", "getInternalDelay", "setInternalDelay", "internalDelay", "Lcom/tencent/mobileqq/tianshu/ui/e;", "Lcom/tencent/mobileqq/tianshu/ui/e;", "updateEvent", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "getNotifyRedBadgeUpdate", "()Lkotlin/jvm/functions/Function1;", "setNotifyRedBadgeUpdate", "(Lkotlin/jvm/functions/Function1;)V", "notifyRedBadgeUpdate", "getNotifyRedBadgeShow", "setNotifyRedBadgeShow", "notifyRedBadgeShow", "getNotifyRedNumberBadgeShow", "setNotifyRedNumberBadgeShow", "notifyRedNumberBadgeShow", "getNotifyRedBadgeClick", "setNotifyRedBadgeClick", "notifyRedBadgeClick", "setExtraData", "(Ljava/lang/String;)V", WadlProxyConsts.EXTRA_DATA, "isApplyTo", "com/tencent/mobileqq/tianshu/ui/TianshuRedTouch$c", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$c;", "accountChangedCallback", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "b", "RedTouchAssembleType", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class TianshuRedTouch extends FrameLayout implements com.tencent.mobileqq.tianshu.ui.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g0, reason: collision with root package name */
    @NotNull
    private static final String f293140g0;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    private static final String f293141h0;

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static final String f293142i0;

    /* renamed from: j0, reason: collision with root package name */
    @NotNull
    private static final String f293143j0;

    /* renamed from: k0, reason: collision with root package name */
    @NotNull
    private static final String f293144k0;

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    private static final String f293145l0;

    /* renamed from: m0, reason: collision with root package name */
    @NotNull
    private static final String f293146m0;

    /* renamed from: n0, reason: collision with root package name */
    @NotNull
    private static final String f293147n0;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    private static final String f293148o0;

    /* renamed from: p0, reason: collision with root package name */
    @NotNull
    private static final String f293149p0;

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    private static final String f293150q0;

    /* renamed from: r0, reason: collision with root package name */
    @NotNull
    private static final String f293151r0;

    /* renamed from: s0, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, String> f293152s0;

    /* renamed from: t0, reason: collision with root package name */
    private static int f293153t0;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo redDotNumberAppInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String path;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean openAutoUpdate;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean openAutoExpose;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View parentView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ViewGroup badgeLayoutContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private FrameLayout.LayoutParams parentLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View redBadge;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private b redBadgeLayoutParams;

    /* renamed from: L, reason: from kotlin metadata */
    private int redDotSize;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean fitDefaultRedDotSize;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hiddenRedDot;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View numberRedBadge;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ViewGroup.LayoutParams numberRedBadgeLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private FrameLayout midParentView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.tianshu.observer.c redBadgeDelayInfo;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean internalDelay;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private e updateEvent;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> notifyRedBadgeUpdate;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> notifyRedBadgeShow;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> notifyRedNumberBadgeShow;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> notifyRedBadgeClick;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String extraData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isApplyTo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RedTouchAssembleType redTouchAssembleType;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c accountChangedCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo appInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo redNumberAppInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo redDotAppInfo;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$RedTouchAssembleType;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ONLY_REDTOUCH", "ONLY_NUMBER_REDTOUCH", "ALL_REDTOUCH", "ONLY_REDDOT", "ME_REDTOUCH", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class RedTouchAssembleType {
        private static final /* synthetic */ RedTouchAssembleType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RedTouchAssembleType ALL_REDTOUCH;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final RedTouchAssembleType ME_REDTOUCH;
        public static final RedTouchAssembleType ONLY_NUMBER_REDTOUCH;
        public static final RedTouchAssembleType ONLY_REDDOT;
        public static final RedTouchAssembleType ONLY_REDTOUCH;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$RedTouchAssembleType$a;", "", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.tianshu.ui.TianshuRedTouch$RedTouchAssembleType$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ RedTouchAssembleType[] $values() {
            return new RedTouchAssembleType[]{ONLY_REDTOUCH, ONLY_NUMBER_REDTOUCH, ALL_REDTOUCH, ONLY_REDDOT, ME_REDTOUCH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34449);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            ONLY_REDTOUCH = new RedTouchAssembleType("ONLY_REDTOUCH", 0, 0);
            ONLY_NUMBER_REDTOUCH = new RedTouchAssembleType("ONLY_NUMBER_REDTOUCH", 1, 1);
            ALL_REDTOUCH = new RedTouchAssembleType("ALL_REDTOUCH", 2, 2);
            ONLY_REDDOT = new RedTouchAssembleType("ONLY_REDDOT", 3, 3);
            ME_REDTOUCH = new RedTouchAssembleType("ME_REDTOUCH", 4, 4);
            $VALUES = $values();
            INSTANCE = new Companion(null);
        }

        RedTouchAssembleType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static RedTouchAssembleType valueOf(String str) {
            return (RedTouchAssembleType) Enum.valueOf(RedTouchAssembleType.class, str);
        }

        public static RedTouchAssembleType[] values() {
            return (RedTouchAssembleType[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$a;", "", "", "j", "", "path", "", "g", "f", "a", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "redBadge", "c", "b", "e", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "k", "", "l", "vDTRedPointType_NoRedDot", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "vDTRedPointType_Number", "i", "", "hintTypeMapping", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.ui.TianshuRedTouch$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                return;
            }
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) path)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(path);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(path + ".0");
            if ((appInfoByPath == null || !a.d(appInfoByPath)) && (appInfoByPath2 == null || !a.a(appInfoByPath2))) {
                return false;
            }
            return true;
        }

        public final boolean b(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) path)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(path);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(path + ".0");
            if ((appInfoByPath == null || appInfoByPath.delay_show.get() == 0) && (appInfoByPath2 == null || appInfoByPath2.delay_show.get() == 0)) {
                return false;
            }
            return true;
        }

        public final boolean c(@Nullable TianshuRedTouch redBadge) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) redBadge)).booleanValue();
            }
            if (redBadge == null || (str = redBadge.path) == null) {
                return false;
            }
            return TianshuRedTouch.INSTANCE.a(str);
        }

        @NotNull
        public final Map<Integer, String> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return TianshuRedTouch.f293152s0;
            }
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }

        public final int e(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) path)).intValue();
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return 0;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath(path);
            if (appInfoByPath == null) {
                return 0;
            }
            return a.b(appInfoByPath);
        }

        @NotNull
        public final String f(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) path);
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return h();
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(path);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(path + ".0");
            if (appInfoByPath != null && a.d(appInfoByPath) && d().containsKey(Integer.valueOf(appInfoByPath.type.get()))) {
                String str = d().get(Integer.valueOf(appInfoByPath.type.get()));
                if (str == null) {
                    return h();
                }
                return str;
            }
            if (appInfoByPath2 != null && a.a(appInfoByPath2)) {
                return i();
            }
            return h();
        }

        public final int g(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path)).intValue();
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return 0;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(path);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(path + ".0");
            if (appInfoByPath != null && a.d(appInfoByPath) && appInfoByPath2 != null && a.a(appInfoByPath2)) {
                return 2;
            }
            if (appInfoByPath == null || !a.d(appInfoByPath)) {
                if (appInfoByPath2 == null || !a.a(appInfoByPath2)) {
                    return 0;
                }
                return 1;
            }
            return 1;
        }

        @NotNull
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return TianshuRedTouch.f293144k0;
            }
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }

        @NotNull
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return TianshuRedTouch.f293146m0;
            }
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn();
        }

        @Nullable
        public final BusinessInfoCheckUpdate.RedTypeInfo k(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 22, (Object) this, (Object) appInfo);
            }
            if (appInfo == null) {
                return null;
            }
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            if (a.d(appInfo)) {
                redTypeInfo.red_type.set(a.b(appInfo));
            } else if (a.a(appInfo)) {
                redTypeInfo.red_type.set(8);
            }
            return redTypeInfo;
        }

        public final void l(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) path);
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime() ?: return");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            if (iRedTouchManager == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(iRedTouchManager, "app.getRuntimeService(IR\u2026                ?: return");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(path);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(path + ".0");
            if (appInfoByPath != null && a.d(appInfoByPath)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfoByPath, (String) null);
            }
            if (appInfoByPath2 != null && a.a(appInfoByPath2)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfoByPath2, (String) null);
            }
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch$b;", "", "", "toString", "", "a", "I", "b", "()I", "g", "(I)V", LayoutAttrDefine.Gravity.Gravity, "", UserInfo.SEX_FEMALE, "c", "()F", "i", "(F)V", "leftMargin", "d", "j", "rightMargin", "e", "k", "topMargin", "f", "bottomMargin", "getWidth", "l", "width", "getHeight", tl.h.F, "height", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int gravity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float leftMargin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float rightMargin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float topMargin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float bottomMargin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float width;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float height;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.gravity = 17;
            this.width = 10.0f;
            this.height = 10.0f;
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
            }
            return this.bottomMargin;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.gravity;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.leftMargin;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.rightMargin;
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.topMargin;
        }

        public final void f(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            } else {
                this.bottomMargin = f16;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.gravity = i3;
            }
        }

        public final void h(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            } else {
                this.height = f16;
            }
        }

        public final void i(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.leftMargin = f16;
            }
        }

        public final void j(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            } else {
                this.rightMargin = f16;
            }
        }

        public final void k(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            } else {
                this.topMargin = f16;
            }
        }

        public final void l(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.width = f16;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return ((((((super.toString() + "gravity=" + this.gravity + TokenParser.SP) + "leftMargin=" + this.leftMargin + TokenParser.SP) + "rightMargin=" + this.rightMargin + TokenParser.SP) + "topMargin=" + this.topMargin + TokenParser.SP) + "bottomMargin=" + this.bottomMargin) + "width=" + this.width) + "height=" + this.height;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/tianshu/ui/TianshuRedTouch$c", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements IAccountCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TianshuRedTouch.this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TianshuRedTouch.this.R();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TianshuRedTouch.this.R();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            }
        }
    }

    static {
        Map<Integer, String> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 56)) {
            redirector.redirect((short) 56);
            return;
        }
        INSTANCE = new Companion(null);
        f293140g0 = "discover_feature_name";
        f293141h0 = "discover_sequence_em";
        f293142i0 = "is_red_tips_em";
        f293143j0 = "qq_red_tips_type";
        f293144k0 = "no_red_dot";
        f293145l0 = "little_red_dot";
        f293146m0 = "num_red_dot";
        f293147n0 = "recomd_red_dot";
        f293148o0 = "new_red_dot";
        f293149p0 = "other";
        f293150q0 = "avatar_red_dot";
        f293151r0 = "irregular_red_dot";
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(15, "irregular_red_dot"), TuplesKt.to(40, "avatar_red_dot"), TuplesKt.to(8, "num_red_dot"), TuplesKt.to(5, "little_red_dot"), TuplesKt.to(3, "little_red_dot"), TuplesKt.to(9, "little_red_dot"));
        f293152s0 = mapOf;
        f293153t0 = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TianshuRedTouch(@NotNull Context context, @Nullable View view) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
            return;
        }
        this.TAG = "TianshuRedTouch";
        this.redTouchAssembleType = RedTouchAssembleType.ALL_REDTOUCH;
        this.openAutoExpose = true;
        this.parentView = view;
        this.parentLayout = new FrameLayout.LayoutParams(-1, -1);
        this.redDotSize = 11;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -1);
        layoutParams.width = 0;
        layoutParams.gravity = 8388613;
        frameLayout.setLayoutParams(layoutParams);
        this.midParentView = frameLayout;
        this.internalDelay = true;
        this.updateEvent = new e();
        this.redBadgeLayoutParams = new b();
        this.badgeLayoutContainer = u(context);
        this.redBadge = C(context);
        this.numberRedBadgeLayout = Z();
        this.updateEvent.d(this);
        SimpleEventBus.getInstance().registerReceiver(this.updateEvent);
        this.accountChangedCallback = new c();
    }

    private final TianshuRedTouch A(ViewGroup.MarginLayoutParams layout, b params) {
        if (this.fitDefaultRedDotSize) {
            layout.width = E(this.redDotSize);
            layout.height = E(this.redDotSize);
        }
        layout.leftMargin = E(params.c());
        layout.rightMargin = E(params.d());
        layout.topMargin = E(params.e());
        layout.bottomMargin = E(params.a());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(BusinessInfoCheckUpdate.AppInfo redDotInfo, BusinessInfoCheckUpdate.AppInfo redNumberInfo) {
        RedTouchAssembleType redTouchAssembleType = this.redTouchAssembleType;
        if (redTouchAssembleType == RedTouchAssembleType.ONLY_REDTOUCH || redTouchAssembleType == RedTouchAssembleType.ALL_REDTOUCH) {
            if (redDotInfo != null && a.d(redDotInfo)) {
                z0(redDotInfo);
            } else {
                b0();
            }
        }
        RedTouchAssembleType redTouchAssembleType2 = this.redTouchAssembleType;
        if (redTouchAssembleType2 == RedTouchAssembleType.ONLY_NUMBER_REDTOUCH || redTouchAssembleType2 == RedTouchAssembleType.ALL_REDTOUCH) {
            if (redNumberInfo != null && a.a(redNumberInfo)) {
                w0(redNumberInfo, this.redTouchAssembleType);
            } else {
                c0();
            }
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ME_REDTOUCH) {
            F0(redDotInfo, redNumberInfo);
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ONLY_REDDOT) {
            H0(redDotInfo, redNumberInfo);
        }
        String str = this.path;
        if (str != null && INSTANCE.a(str)) {
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B(String argPath) {
        return argPath + ".0";
    }

    @SuppressLint({"SuspiciousIndentation"})
    private final View C(Context context) {
        QUIBadge qUIBadge = new QUIBadge(context);
        qUIBadge.setRedDot();
        qUIBadge.setVisibility(8);
        return qUIBadge;
    }

    private final void C0(String argPath) {
        boolean z16;
        BusinessInfoCheckUpdate.AppInfo appInfo;
        boolean z17;
        String str;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        boolean z18 = false;
        if (argPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (this.hiddenRedDot) {
            QLog.i(this.TAG, 1, "path isHidden: " + argPath);
            return;
        }
        QLog.i(this.TAG, 1, "argPath: " + argPath + ", type = " + this.redTouchAssembleType);
        if (D(argPath)) {
            QLog.i(this.TAG, 1, "delayUpdate argPath: " + argPath);
            return;
        }
        RedTouchAssembleType redTouchAssembleType = this.redTouchAssembleType;
        String str2 = null;
        if (redTouchAssembleType == RedTouchAssembleType.ONLY_REDTOUCH || redTouchAssembleType == RedTouchAssembleType.ALL_REDTOUCH) {
            IRedTouchManager e16 = e();
            if (e16 != null) {
                appInfo = e16.getAppInfoByPath(argPath.toString());
            } else {
                appInfo = null;
            }
            if (appInfo != null && a.d(appInfo)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z0(appInfo);
            } else {
                String str3 = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("path = ");
                sb5.append(argPath);
                sb5.append(" type = ");
                sb5.append(this.redTouchAssembleType);
                sb5.append(" info: ");
                if (appInfo != null) {
                    str = a.g(appInfo);
                } else {
                    str = null;
                }
                sb5.append(str);
                QLog.i(str3, 1, sb5.toString());
                b0();
            }
        }
        RedTouchAssembleType redTouchAssembleType2 = this.redTouchAssembleType;
        if (redTouchAssembleType2 == RedTouchAssembleType.ONLY_NUMBER_REDTOUCH || redTouchAssembleType2 == RedTouchAssembleType.ALL_REDTOUCH) {
            String B = B(argPath);
            IRedTouchManager e17 = e();
            if (e17 != null) {
                appInfo2 = e17.getAppInfoByPath(B.toString());
            } else {
                appInfo2 = null;
            }
            if (appInfo2 != null && a.a(appInfo2)) {
                z18 = true;
            }
            if (z18) {
                w0(appInfo2, this.redTouchAssembleType);
            } else {
                String str4 = this.TAG;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("path = ");
                sb6.append(B);
                sb6.append(" type = ");
                sb6.append(this.redTouchAssembleType);
                sb6.append(" info: ");
                if (appInfo2 != null) {
                    str2 = a.g(appInfo2);
                }
                sb6.append(str2);
                QLog.i(str4, 1, sb6.toString());
                c0();
            }
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ME_REDTOUCH) {
            E0(argPath);
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ONLY_REDDOT) {
            G0(argPath);
        }
        if (INSTANCE.a(argPath)) {
            Y();
        }
        W();
    }

    private final boolean D(final String path) {
        AppRuntime peekAppRuntime;
        boolean z16;
        if (!this.internalDelay || !com.tencent.mobileqq.tianshu.observer.d.f293094a.e(path) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchServer.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        IRedTouchServer iRedTouchServer = (IRedTouchServer) runtimeService;
        com.tencent.mobileqq.tianshu.observer.c cVar = this.redBadgeDelayInfo;
        if (cVar == null) {
            this.redBadgeDelayInfo = new com.tencent.mobileqq.tianshu.observer.c(path);
        } else {
            if (cVar != null && !cVar.f(path)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
        }
        com.tencent.mobileqq.tianshu.observer.c cVar2 = this.redBadgeDelayInfo;
        if (cVar2 != null) {
            cVar2.e(new Function1<com.tencent.mobileqq.tianshu.observer.b, Unit>(path) { // from class: com.tencent.mobileqq.tianshu.ui.TianshuRedTouch$delayUpdateIfNeeds$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $path;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$path = path;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TianshuRedTouch.this, (Object) path);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.tianshu.observer.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.mobileqq.tianshu.observer.b bVar) {
                    com.tencent.mobileqq.tianshu.observer.a d16;
                    IRedTouchManager e16;
                    String B;
                    IRedTouchManager e17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                        return;
                    }
                    if (bVar == null || (d16 = com.tencent.mobileqq.tianshu.observer.d.f293094a.d(bVar.a(), String.valueOf(bVar.d()))) == null) {
                        return;
                    }
                    d16.b(true);
                    e16 = TianshuRedTouch.this.e();
                    BusinessInfoCheckUpdate.AppInfo appInfoByPath = e16 != null ? e16.getAppInfoByPath(this.$path.toString()) : null;
                    B = TianshuRedTouch.this.B(this.$path);
                    e17 = TianshuRedTouch.this.e();
                    TianshuRedTouch.this.A0(appInfoByPath, e17 != null ? e17.getAppInfoByPath(B.toString()) : null);
                }
            });
        }
        iRedTouchServer.notifyUI(1, true, this.redBadgeDelayInfo);
        return true;
    }

    private final void D0() {
        ViewParent viewParent;
        View view;
        View view2 = this.redBadge;
        if (view2 != null) {
            viewParent = view2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && (view = this.numberRedBadge) != null) {
            Intrinsics.checkNotNull(view);
            int width = view.getWidth();
            View view3 = this.numberRedBadge;
            Intrinsics.checkNotNull(view3);
            float a06 = a0(width + (view3.getLeft() * 2));
            if (this.redBadgeLayoutParams.c() < a06) {
                b bVar = this.redBadgeLayoutParams;
                bVar.i(bVar.c() + a06);
                t();
            }
        }
        X();
    }

    private final int E(float dip) {
        return (int) TypedValue.applyDimension(1, dip, getResources().getDisplayMetrics());
    }

    private final void E0(String argPath) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        IRedTouchManager e16 = e();
        BusinessInfoCheckUpdate.AppInfo appInfo2 = null;
        if (e16 != null) {
            appInfo = e16.getAppInfoByPath(argPath.toString());
        } else {
            appInfo = null;
        }
        String B = B(argPath);
        IRedTouchManager e17 = e();
        if (e17 != null) {
            appInfo2 = e17.getAppInfoByPath(B.toString());
        }
        F0(appInfo, appInfo2);
    }

    private final void F0(BusinessInfoCheckUpdate.AppInfo redDotAppInfo, BusinessInfoCheckUpdate.AppInfo redNumberAppInfo) {
        this.fitDefaultRedDotSize = false;
        if (redNumberAppInfo != null && a.a(redNumberAppInfo)) {
            w0(redNumberAppInfo, this.redTouchAssembleType);
            b0();
        } else if (redDotAppInfo != null && a.d(redDotAppInfo)) {
            this.fitDefaultRedDotSize = true;
            z0(redDotAppInfo);
            c0();
        } else {
            b0();
            c0();
        }
    }

    private final boolean G(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || !a.a(appInfo)) {
            return false;
        }
        QLog.d(this.TAG, 2, "redBadgeNumber:" + a.g(appInfo));
        View view = this.numberRedBadge;
        if (view != null) {
            ab.c(view);
        }
        IRedPointUIManager iRedPointUIManager = (IRedPointUIManager) QRoute.api(IRedPointUIManager.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View richRedPointView = iRedPointUIManager.getRichRedPointView(context, appInfo);
        this.numberRedBadge = richRedPointView;
        if (this.redTouchAssembleType == RedTouchAssembleType.ME_REDTOUCH) {
            if (this.midParentView.getParent() == null) {
                this.badgeLayoutContainer.addView(this.midParentView);
            }
            ViewGroup.LayoutParams layoutParams = this.midParentView.getLayoutParams();
            layoutParams.width = this.badgeLayoutContainer.getWidth() / 2;
            this.midParentView.setLayoutParams(layoutParams);
            this.midParentView.addView(richRedPointView);
        } else {
            this.badgeLayoutContainer.addView(richRedPointView);
        }
        View view2 = this.numberRedBadge;
        if (view2 != null) {
            view2.setVisibility(0);
            return true;
        }
        return true;
    }

    private final void G0(String argPath) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        boolean z16;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        String str;
        IRedTouchManager e16 = e();
        String str2 = null;
        if (e16 != null) {
            appInfo = e16.getAppInfoByPath(argPath.toString());
        } else {
            appInfo = null;
        }
        boolean z17 = false;
        if (appInfo != null && a.d(appInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str3 = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("update redDot: ");
            if (appInfo != null) {
                str = a.g(appInfo);
            } else {
                str = null;
            }
            sb5.append(str);
            QLog.i(str3, 1, sb5.toString());
        }
        String B = B(argPath);
        IRedTouchManager e17 = e();
        if (e17 != null) {
            appInfo2 = e17.getAppInfoByPath(B.toString());
        } else {
            appInfo2 = null;
        }
        if (appInfo2 != null && a.a(appInfo2)) {
            z17 = true;
        }
        if (z17) {
            String str4 = this.TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("update redNumber: ");
            if (appInfo2 != null) {
                str2 = a.g(appInfo2);
            }
            sb6.append(str2);
            QLog.i(str4, 1, sb6.toString());
        }
        H0(appInfo, appInfo2);
    }

    private final boolean H() {
        ViewParent viewParent;
        View view;
        View view2 = this.redBadge;
        if (view2 != null) {
            viewParent = view2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && (view = this.redBadge) != null) {
            ab.c(view);
        }
        I();
        View view3 = this.redBadge;
        if (view3 != null) {
            view3.setVisibility(0);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if (r4 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r2 != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H0(BusinessInfoCheckUpdate.AppInfo appInfo, BusinessInfoCheckUpdate.AppInfo appInfoNumber) {
        boolean z16;
        if ((appInfo != null && a.d(appInfo)) || (appInfoNumber != null && a.a(appInfoNumber))) {
            B0(new BusinessInfoCheckUpdate.RedTypeInfo());
            boolean z17 = false;
            if (appInfo != null) {
                BusinessInfoCheckUpdate.AppInfo appInfo2 = this.redDotAppInfo;
                if (appInfo2 != null) {
                    if (appInfo2 != null && !a.f(appInfo2, appInfo)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                QLog.i(this.TAG, 1, "replace redDotInfo: " + a.g(appInfo));
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfo, (String) null);
            }
            if (appInfoNumber != null) {
                BusinessInfoCheckUpdate.AppInfo appInfo3 = this.redDotNumberAppInfo;
                if (appInfo3 != null) {
                    if (appInfo3 != null && !a.f(appInfo3, appInfoNumber)) {
                        z17 = true;
                    }
                }
                QLog.i(this.TAG, 1, "replace redNumberInfo: " + a.g(appInfoNumber));
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfoNumber, (String) null);
            }
            this.redDotAppInfo = appInfo;
            this.redDotNumberAppInfo = appInfoNumber;
            return;
        }
        this.redDotAppInfo = null;
        this.redDotNumberAppInfo = null;
        b0();
    }

    private final TianshuRedTouch I() {
        View view = this.redBadge;
        if (view != null) {
            view.setLayoutParams(N(this.redBadgeLayoutParams));
        }
        View view2 = this.redBadge;
        if (view2 != null) {
            view2.setId(View.generateViewId());
        }
        View view3 = this.redBadge;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        this.badgeLayoutContainer.addView(this.redBadge);
        return this;
    }

    private final boolean J(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || !a.d(appInfo)) {
            return false;
        }
        QLog.d(this.TAG, 2, "redBadge:" + a.g(appInfo));
        View view = this.redBadge;
        if (view != null) {
            ab.c(view);
        }
        IRedPointUIManager iRedPointUIManager = (IRedPointUIManager) QRoute.api(IRedPointUIManager.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View richRedPointView = iRedPointUIManager.getRichRedPointView(context, appInfo);
        if (!Intrinsics.areEqual(richRedPointView, this.redBadge)) {
            this.redBadge = richRedPointView;
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.redBadge = C(context2);
            QLog.d(this.TAG, 2, "get redBadgeInfo fail redBadge:" + a.g(appInfo));
        }
        View view2 = this.redBadge;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.badgeLayoutContainer.addView(this.redBadge);
        v();
        return true;
    }

    private final boolean K(String redPath, String path2) {
        if (redPath == null || path2 == null) {
            return false;
        }
        if (!redPath.equals(path2 + ".0") && !redPath.equals(path2) && !B(redPath).equals(path2)) {
            return false;
        }
        return true;
    }

    private final ViewGroup.MarginLayoutParams N(b params) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = params.b();
        A(layoutParams, params);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                TianshuRedTouch.S(TianshuRedTouch.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TianshuRedTouch this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.path != null) {
            QLog.e(this$0.TAG, 1, "[accountChange] clean all");
            com.tencent.mobileqq.tianshu.observer.d.f293094a.c();
            this$0.b0();
            this$0.c0();
        }
    }

    private final boolean T() {
        RedTouchAssembleType redTouchAssembleType = this.redTouchAssembleType;
        if (redTouchAssembleType != RedTouchAssembleType.ONLY_REDTOUCH && redTouchAssembleType != RedTouchAssembleType.ALL_REDTOUCH && redTouchAssembleType != RedTouchAssembleType.ONLY_REDDOT && redTouchAssembleType != RedTouchAssembleType.ME_REDTOUCH) {
            return false;
        }
        return true;
    }

    private final boolean U() {
        RedTouchAssembleType redTouchAssembleType = this.redTouchAssembleType;
        if (redTouchAssembleType != RedTouchAssembleType.ONLY_NUMBER_REDTOUCH && redTouchAssembleType != RedTouchAssembleType.ALL_REDTOUCH && redTouchAssembleType != RedTouchAssembleType.ONLY_REDDOT && redTouchAssembleType != RedTouchAssembleType.ME_REDTOUCH) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        if (this.notifyRedBadgeClick != null) {
            String valueOf = String.valueOf(this.path);
            Function1<? super String, Unit> function1 = this.notifyRedBadgeClick;
            if (function1 != null) {
                function1.invoke(valueOf);
            }
        }
    }

    private final void W() {
        if (this.notifyRedBadgeUpdate != null) {
            String valueOf = String.valueOf(this.path);
            Function1<? super String, Unit> function1 = this.notifyRedBadgeUpdate;
            if (function1 != null) {
                function1.invoke(valueOf);
            }
        }
    }

    private final void X() {
        if (this.notifyRedNumberBadgeShow != null) {
            String valueOf = String.valueOf(this.path);
            Function1<? super String, Unit> function1 = this.notifyRedNumberBadgeShow;
            if (function1 != null) {
                function1.invoke(valueOf);
            }
        }
    }

    private final void Y() {
        if (this.notifyRedBadgeShow != null) {
            String valueOf = String.valueOf(this.path);
            Function1<? super String, Unit> function1 = this.notifyRedBadgeShow;
            if (function1 != null) {
                function1.invoke(valueOf);
            }
        }
    }

    private final ViewGroup.LayoutParams Z() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388627;
        return layoutParams;
    }

    private final int a0(int pxValue) {
        return (int) ((pxValue / getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final void b0() {
        this.appInfo = null;
        View view = this.redBadge;
        if (view != null) {
            ab.c(view);
        }
        W();
    }

    private final void c0() {
        this.redNumberAppInfo = null;
        View view = this.numberRedBadge;
        if (view != null) {
            ab.c(view);
        }
        W();
    }

    private final void d0(String argPath) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchServer.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        ((IRedTouchServer) runtimeService).notifyUI(com.tencent.mobileqq.tianshu.observer.e.INSTANCE.a(), true, argPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRedTouchManager e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        return (IRedTouchManager) runtimeService;
    }

    private final void e0() {
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            QLog.e(this.TAG, 1, "[RunTime] failed");
        } else {
            MobileQQ.sMobileQQ.unregisterAccountCallback(this.accountChangedCallback);
        }
    }

    private final TianshuRedTouch f0(View target) {
        if (target.getParent() == null) {
            return this;
        }
        ViewParent parent = target.getParent();
        if (parent == null) {
            return this;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup instanceof RelativeLayout) {
            ViewGroup viewGroup2 = this.badgeLayoutContainer;
            int i3 = f293153t0;
            f293153t0 = i3 + 1;
            viewGroup2.setId(i3);
            int id5 = target.getId();
            int childCount = ((RelativeLayout) viewGroup).getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = viewGroup.getChildAt(i16);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                int length = rules.length;
                for (int i17 = 0; i17 < length; i17++) {
                    if (rules[i17] == id5) {
                        rules[i17] = this.badgeLayoutContainer.getId();
                    }
                }
                childAt.setLayoutParams(layoutParams2);
            }
        }
        int indexOfChild = viewGroup.indexOfChild(target);
        viewGroup.removeView(target);
        this.badgeLayoutContainer.setLayoutParams(target.getLayoutParams());
        viewGroup.addView(this.badgeLayoutContainer, indexOfChild);
        return this;
    }

    private final void p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(this.TAG, 1, "[RunTime] failed");
        } else {
            MobileQQ.sMobileQQ.registerAccountCallback(this.accountChangedCallback);
        }
    }

    private final TianshuRedTouch r() {
        View view = this.parentView;
        if (view != null && (view instanceof ViewGroup)) {
            this.badgeLayoutContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ((ViewGroup) view).addView(this.badgeLayoutContainer);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        String str;
        BusinessInfoCheckUpdate.AppInfo appInfo3;
        BusinessInfoCheckUpdate.AppInfo appInfo4;
        String str2;
        String str3;
        BusinessInfoCheckUpdate.AppInfo appInfo5;
        RedTouchAssembleType redTouchAssembleType = this.redTouchAssembleType;
        BusinessInfoCheckUpdate.AppInfo appInfo6 = null;
        if ((redTouchAssembleType == RedTouchAssembleType.ONLY_REDTOUCH || redTouchAssembleType == RedTouchAssembleType.ALL_REDTOUCH) && (appInfo = this.appInfo) != null) {
            IRedTouchManager e16 = e();
            if (e16 != null) {
                appInfo2 = e16.getAppInfoByPath(appInfo.path.get());
            } else {
                appInfo2 = null;
            }
            if (appInfo2 != null && a.e(appInfo2)) {
                b0();
            }
            String str4 = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[clickEvent] info:");
            if (appInfo2 != null) {
                str = a.g(appInfo2);
            } else {
                str = null;
            }
            sb5.append(str);
            QLog.d(str4, 2, sb5.toString());
        }
        RedTouchAssembleType redTouchAssembleType2 = this.redTouchAssembleType;
        if ((redTouchAssembleType2 == RedTouchAssembleType.ONLY_NUMBER_REDTOUCH || redTouchAssembleType2 == RedTouchAssembleType.ALL_REDTOUCH) && (appInfo3 = this.redNumberAppInfo) != null) {
            IRedTouchManager e17 = e();
            if (e17 != null) {
                appInfo4 = e17.getAppInfoByPath(appInfo3.path.get());
            } else {
                appInfo4 = null;
            }
            if (appInfo4 != null && a.e(appInfo4)) {
                c0();
            }
            String str5 = this.TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("[clickEvent] number info:");
            if (appInfo4 != null) {
                str2 = a.g(appInfo4);
            } else {
                str2 = null;
            }
            sb6.append(str2);
            QLog.d(str5, 2, sb6.toString());
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ONLY_REDDOT && (str3 = this.path) != null) {
            IRedTouchManager e18 = e();
            if (e18 != null) {
                appInfo5 = e18.getAppInfoByPath(str3);
            } else {
                appInfo5 = null;
            }
            if (appInfo5 != null && a.d(appInfo5) && a.e(appInfo5)) {
                b0();
            }
            String str6 = str3 + ".0";
            IRedTouchManager e19 = e();
            if (e19 != null) {
                appInfo6 = e19.getAppInfoByPath(str6);
            }
            if (appInfo6 != null && a.a(appInfo6) && a.e(appInfo6)) {
                b0();
            }
        }
        String str7 = this.path;
        if (str7 != null) {
            C0(str7);
        }
    }

    private final void t0(String argPath) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchServer.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        ((IRedTouchServer) runtimeService).notifyUI(com.tencent.mobileqq.tianshu.observer.e.INSTANCE.b(), true, argPath);
    }

    private final FrameLayout u(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    private final void u0() {
        ViewGroup viewGroup;
        final FrameLayout frameLayout = this.midParentView;
        if (frameLayout != null && (viewGroup = this.badgeLayoutContainer) != null) {
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    TianshuRedTouch.v0(frameLayout, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(FrameLayout it12, TianshuRedTouch this$0) {
        Intrinsics.checkNotNullParameter(it12, "$it1");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = it12.getLayoutParams();
        layoutParams.width = this$0.badgeLayoutContainer.getWidth() / 2;
        it12.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r1 != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w0(BusinessInfoCheckUpdate.AppInfo appInfo, RedTouchAssembleType redTouchAssembleTypeArgs) {
        String str;
        String str2;
        boolean z16;
        String str3;
        String str4 = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("numberRedBadge old appInfo: ");
        BusinessInfoCheckUpdate.AppInfo appInfo2 = this.redNumberAppInfo;
        if (appInfo2 != null) {
            str = a.g(appInfo2);
        } else {
            str = null;
        }
        sb5.append(str);
        QLog.i(str4, 1, sb5.toString());
        String str5 = this.TAG;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("numberRedBadge new appInfo: ");
        if (appInfo != null) {
            str2 = a.g(appInfo);
        } else {
            str2 = null;
        }
        sb6.append(str2);
        QLog.i(str5, 1, sb6.toString());
        if (appInfo != null && !a.a(appInfo)) {
            QLog.i(this.TAG, 1, "red number invalid appInfo: " + a.g(appInfo));
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo3 = this.redNumberAppInfo;
        boolean z17 = false;
        if (appInfo3 != null && a.f(appInfo3, appInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str6 = this.TAG;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("dot update appInfo: ");
            if (appInfo != null) {
                str3 = a.g(appInfo);
            } else {
                str3 = null;
            }
            sb7.append(str3);
            QLog.i(str6, 1, sb7.toString());
        }
        if (G(appInfo)) {
            if (appInfo != null) {
                if (this.openAutoExpose && this.badgeLayoutContainer.isShown()) {
                    BusinessInfoCheckUpdate.AppInfo appInfo4 = this.redNumberAppInfo;
                    if (appInfo4 != null) {
                        if (appInfo4 != null && !a.f(appInfo4, appInfo)) {
                            z17 = true;
                        }
                    }
                    ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfo, (String) null);
                }
                QLog.i(this.TAG, 1, "replace appInfo: " + a.g(appInfo));
                this.redNumberAppInfo = appInfo;
            }
            if (redTouchAssembleTypeArgs == RedTouchAssembleType.ONLY_NUMBER_REDTOUCH) {
                View view = this.numberRedBadge;
                if (view != null) {
                    view.setLayoutParams(N(this.redBadgeLayoutParams));
                    return;
                }
                return;
            }
            if (redTouchAssembleTypeArgs == RedTouchAssembleType.ALL_REDTOUCH || redTouchAssembleTypeArgs == RedTouchAssembleType.ME_REDTOUCH) {
                View view2 = this.numberRedBadge;
                if (view2 != null) {
                    view2.setLayoutParams(this.numberRedBadgeLayout);
                }
                View view3 = this.numberRedBadge;
                if (view3 != null) {
                    view3.post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            TianshuRedTouch.x0(TianshuRedTouch.this);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(TianshuRedTouch this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D0();
    }

    private final TianshuRedTouch y0() {
        View view = this.parentView;
        if (view != null) {
            view.setLayoutParams(this.parentLayout);
        }
        View view2 = this.parentView;
        if (view2 != null) {
            this.badgeLayoutContainer.addView(view2);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        if (r2 != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        boolean z16;
        if (appInfo == null || (str = a.g(appInfo)) == null) {
            str = "null info";
        }
        QLog.i(this.TAG, 1, "appInfo: " + str);
        if (appInfo != null && !a.d(appInfo)) {
            QLog.i(this.TAG, 1, "red dot invalid appInfo: " + str);
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo2 = this.appInfo;
        boolean z17 = false;
        if (appInfo2 != null && a.f(appInfo2, appInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i(this.TAG, 1, "dot update appInfo: " + str);
            return;
        }
        if (J(appInfo)) {
            if (appInfo != null && this.openAutoExpose && this.badgeLayoutContainer.isShown()) {
                BusinessInfoCheckUpdate.AppInfo appInfo3 = this.appInfo;
                if (appInfo3 != null) {
                    if (appInfo3 != null && !a.f(appInfo3, appInfo)) {
                        z17 = true;
                    }
                }
                QLog.i(this.TAG, 1, "replace appInfo: " + str);
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfo, (String) null);
            }
            this.appInfo = appInfo;
        }
    }

    public final void B0(@Nullable BusinessInfoCheckUpdate.RedTypeInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appInfo);
        } else if (appInfo == null) {
            b0();
        } else if (H()) {
            this.redTypeInfo = appInfo;
        }
    }

    @NotNull
    public final TianshuRedTouch F(@Nullable String extra) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        BusinessInfoCheckUpdate.AppInfo appInfo3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 35, (Object) this, (Object) extra);
        }
        BusinessInfoCheckUpdate.AppInfo appInfo4 = null;
        if (T() && (appInfo2 = this.appInfo) != null) {
            IRedTouchManager e16 = e();
            if (e16 != null) {
                appInfo3 = e16.getAppInfoByPath(appInfo2.path.get());
            } else {
                appInfo3 = null;
            }
            if (appInfo3 != null && a.d(appInfo3)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfo3, extra);
            }
        }
        if (U() && (appInfo = this.redNumberAppInfo) != null) {
            IRedTouchManager e17 = e();
            if (e17 != null) {
                appInfo4 = e17.getAppInfoByPath(appInfo.path.get());
            }
            if (appInfo4 != null && a.a(appInfo4)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportExposuresDeduplicate(appInfo4, extra);
            }
        }
        return this;
    }

    @Nullable
    public final BusinessInfoCheckUpdate.AppInfo L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appInfo;
    }

    @Nullable
    public final String M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.extraData;
    }

    @Nullable
    public final String O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return this.path;
    }

    @NotNull
    public final String P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    public final boolean Q() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = this.appInfo;
        if (appInfo != null && a.d(appInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null && a.a(appInfo2)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || this.redTypeInfo != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.ui.c
    public void a(@NotNull List<com.tencent.mobileqq.tianshu.bean.a> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<com.tencent.mobileqq.tianshu.bean.a> it = list.iterator();
        while (it.hasNext()) {
            if (K(this.path, it.next().a()) && (str = this.path) != null) {
                C0(str);
                W();
            }
        }
    }

    @NotNull
    public final TianshuRedTouch g0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 41, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.f(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch h0(int v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 37, (Object) this, v3);
        }
        this.redBadgeLayoutParams.g(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch i0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 42, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.h(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch j0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 38, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.i(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch k0(@NotNull FrameLayout.LayoutParams layout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 45, (Object) this, (Object) layout);
        }
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.numberRedBadgeLayout = layout;
        return this;
    }

    @NotNull
    public final TianshuRedTouch l0(boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 28, (Object) this, open);
        }
        this.openAutoExpose = open;
        return this;
    }

    @NotNull
    public final TianshuRedTouch m0(@NotNull FrameLayout.LayoutParams layout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 43, (Object) this, (Object) layout);
        }
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.parentLayout = layout;
        return this;
    }

    @NotNull
    public final TianshuRedTouch n0(@Nullable String argPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 52, (Object) this, (Object) argPath);
        }
        return o0(argPath, true);
    }

    @NotNull
    public final TianshuRedTouch o0(@Nullable String argPath, boolean autoReportEx) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 55, this, argPath, Boolean.valueOf(autoReportEx));
        }
        if (argPath != null) {
            String str = this.path;
            if (str != null && str.equals(argPath)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return this;
            }
        }
        String str2 = this.path;
        if (str2 != null) {
            t0(str2);
        }
        if (this.openAutoUpdate) {
            e0();
            this.openAutoUpdate = false;
        }
        w();
        if (argPath == null) {
            return this;
        }
        this.path = argPath;
        d0(argPath);
        if (!this.openAutoUpdate) {
            p();
            this.openAutoUpdate = true;
        }
        C0(argPath);
        if (autoReportEx && this.openAutoExpose) {
            F(null);
        }
        return this;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (this.redTouchAssembleType == RedTouchAssembleType.ME_REDTOUCH) {
            u0();
        }
    }

    @NotNull
    public final TianshuRedTouch p0(@NotNull RedTouchAssembleType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 36, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        this.redTouchAssembleType = type;
        if (type == RedTouchAssembleType.ONLY_REDDOT) {
            this.fitDefaultRedDotSize = true;
        } else {
            this.fitDefaultRedDotSize = false;
        }
        String str = this.path;
        if (str != null) {
            C0(str);
        }
        return this;
    }

    @NotNull
    public final TianshuRedTouch q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        if (!this.isApplyTo) {
            View view = this.parentView;
            if (view != null && (view instanceof ViewGroup)) {
                z().r().I();
                this.isApplyTo = true;
            }
        } else {
            View view2 = this.redBadge;
            if (view2 != null) {
                view2.setLayoutParams(N(this.redBadgeLayoutParams));
            }
        }
        return this;
    }

    @NotNull
    public final TianshuRedTouch q0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 39, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.j(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch r0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 40, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.k(v3);
        return this;
    }

    @NotNull
    public final TianshuRedTouch s0(float v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 46, this, Float.valueOf(v3));
        }
        this.redBadgeLayoutParams.l(v3);
        return this;
    }

    public final void setAppInfo(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInfo);
        } else {
            this.appInfo = appInfo;
        }
    }

    public final void setExtraData(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.extraData = str;
        }
    }

    public final void setHiddenRedBadge(boolean hidden) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, hidden);
            return;
        }
        this.hiddenRedDot = hidden;
        if (hidden) {
            this.appInfo = null;
            this.redDotNumberAppInfo = null;
            b0();
            c0();
            return;
        }
        String str = this.path;
        if (str != null) {
            RedTouchAssembleType.Companion companion = RedTouchAssembleType.INSTANCE;
            C0(str);
        }
    }

    public final void setInternalDelay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.internalDelay = z16;
        }
    }

    public final void setNotifyRedBadgeClick(@Nullable Function1<? super String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) function1);
        } else {
            this.notifyRedBadgeClick = function1;
        }
    }

    public final void setNotifyRedBadgeShow(@Nullable Function1<? super String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) function1);
        } else {
            this.notifyRedBadgeShow = function1;
        }
    }

    public final void setNotifyRedBadgeUpdate(@Nullable Function1<? super String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) function1);
        } else {
            this.notifyRedBadgeUpdate = function1;
        }
    }

    public final void setNotifyRedNumberBadgeShow(@Nullable Function1<? super String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) function1);
        } else {
            this.notifyRedNumberBadgeShow = function1;
        }
    }

    public final void setOpenAutoExpose(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.openAutoExpose = z16;
        }
    }

    public final void setRedBadgeDelayInfo(@Nullable com.tencent.mobileqq.tianshu.observer.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar);
        } else {
            this.redBadgeDelayInfo = cVar;
        }
    }

    public final void setRedNumberAppInfo(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInfo);
        } else {
            this.redNumberAppInfo = appInfo;
        }
    }

    public final void setRedTypeInfo(@Nullable BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) redTypeInfo);
        } else {
            this.redTypeInfo = redTypeInfo;
        }
    }

    @NotNull
    public final TianshuRedTouch t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        if (!this.isApplyTo) {
            View view = this.parentView;
            if (view != null) {
                z().f0(view).y0().I();
            }
            this.isApplyTo = true;
        } else {
            View view2 = this.redBadge;
            if (view2 != null) {
                view2.setLayoutParams(N(this.redBadgeLayoutParams));
            }
        }
        return this;
    }

    protected final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        View view = this.redBadge;
        if (view != null) {
            view.setLayoutParams(N(this.redBadgeLayoutParams));
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        b0();
        c0();
        this.openAutoUpdate = false;
        this.path = null;
        this.appInfo = null;
        this.redNumberAppInfo = null;
        this.redTypeInfo = null;
    }

    @NotNull
    public final TianshuRedTouch x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        y(this.extraData);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.TianshuRedTouch$clickEvent$$inlined$Runnable$1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TianshuRedTouch.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TianshuRedTouch.this.s();
                    TianshuRedTouch.this.V();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 300L);
        return this;
    }

    @NotNull
    public final TianshuRedTouch y(@Nullable String extra) {
        String str;
        BusinessInfoCheckUpdate.AppInfo appInfo;
        String str2;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        BusinessInfoCheckUpdate.AppInfo appInfo3;
        BusinessInfoCheckUpdate.AppInfo appInfo4;
        String str3;
        BusinessInfoCheckUpdate.AppInfo appInfo5;
        BusinessInfoCheckUpdate.AppInfo appInfo6;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 34, (Object) this, (Object) extra);
        }
        String str5 = null;
        if (T() && (appInfo5 = this.appInfo) != null) {
            IRedTouchManager e16 = e();
            if (e16 != null) {
                appInfo6 = e16.getAppInfoByPath(appInfo5.path.get());
            } else {
                appInfo6 = null;
            }
            if (appInfo6 != null) {
                str4 = a.g(appInfo6);
            } else {
                str4 = null;
            }
            if (appInfo6 != null && a.d(appInfo6)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportClick(appInfo6, extra);
            }
            QLog.d(this.TAG, 1, "[clickEvent] info:" + str4);
        }
        if (U() && (appInfo3 = this.redNumberAppInfo) != null) {
            IRedTouchManager e17 = e();
            if (e17 != null) {
                appInfo4 = e17.getAppInfoByPath(appInfo3.path.get());
            } else {
                appInfo4 = null;
            }
            if (appInfo4 != null) {
                str3 = a.g(appInfo4);
            } else {
                str3 = null;
            }
            if (appInfo4 != null && a.a(appInfo4)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportClick(appInfo3, extra);
            }
            QLog.d(this.TAG, 1, "[clickEvent] number info:" + str3);
        }
        if (this.redTouchAssembleType == RedTouchAssembleType.ONLY_REDDOT && T() && (str = this.path) != null) {
            IRedTouchManager e18 = e();
            if (e18 != null) {
                appInfo = e18.getAppInfoByPath(str);
            } else {
                appInfo = null;
            }
            if (appInfo != null) {
                str2 = a.g(appInfo);
            } else {
                str2 = null;
            }
            if (appInfo != null && a.d(appInfo)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportClick(appInfo, extra);
            }
            QLog.d(this.TAG, 1, "[clickEvent] info:" + str2);
            IRedTouchManager e19 = e();
            if (e19 != null) {
                appInfo2 = e19.getAppInfoByPath(str + ".0");
            } else {
                appInfo2 = null;
            }
            if (appInfo2 != null) {
                str5 = a.g(appInfo2);
            }
            if (appInfo2 != null && a.a(appInfo2)) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportClick(appInfo2, extra);
            }
            QLog.d(this.TAG, 1, "[clickEvent] number info:" + str5);
        }
        return this;
    }

    @NotNull
    public final TianshuRedTouch z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        this.badgeLayoutContainer = this;
        return this;
    }
}
