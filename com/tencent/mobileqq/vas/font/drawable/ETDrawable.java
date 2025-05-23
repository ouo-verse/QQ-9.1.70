package com.tencent.mobileqq.vas.font.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import b13.g;
import b13.m;
import b13.p;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.api.ETFontUtil;
import com.etrump.mixlayout.e;
import com.etrump.mixlayout.k;
import com.etrump.mixlayout.n;
import com.etrump.mixlayout.q;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.font.manager.h;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import m.e;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y03.AIOTextViewInfo;
import y03.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u00018B\u001d\u0012\b\u0010\u00e6\u0001\u001a\u00030\u00e5\u0001\u0012\b\u0010\u00e8\u0001\u001a\u00030\u00e7\u0001\u00a2\u0006\u0006\b\u00e9\u0001\u0010\u00ea\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\u0010\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016J\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0017J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u000eJ\b\u00102\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\u0018\u00104\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\u001c\u00108\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u000106j\n\u0012\u0004\u0012\u00020&\u0018\u0001`7H\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010<\u001a\u00020;H\u0016J!\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u00020@H\u0016J\u001c\u0010E\u001a\u00020\u00142\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140CH\u0016R \u0010J\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000b0F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0017\u0010O\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\b+\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010R\u001a\u00020G8\u0006\u00a2\u0006\f\n\u0004\bB\u00100\u001a\u0004\bP\u0010QR\u0017\u0010W\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0017\u0010]\u001a\u00020X8\u0006\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R$\u0010c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010g\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010^\u001a\u0004\be\u0010`\"\u0004\bf\u0010bR$\u0010k\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010^\u001a\u0004\bi\u0010`\"\u0004\bj\u0010bR\"\u0010p\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010T\u001a\u0004\bm\u0010V\"\u0004\bn\u0010oR\"\u0010s\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010T\u001a\u0004\bq\u0010V\"\u0004\br\u0010oR\"\u0010w\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010T\u001a\u0004\bu\u0010V\"\u0004\bv\u0010oR\u0017\u0010y\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bx\u0010T\u001a\u0004\bx\u0010VR\u0017\u0010}\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\bT\u0010z\u001a\u0004\b{\u0010|R%\u0010\u0082\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b0\u0010\"\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R%\u0010\u0085\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b_\u0010T\u001a\u0005\b\u0083\u0001\u0010V\"\u0005\b\u0084\u0001\u0010oR)\u0010\u008c\u0001\u001a\u00030\u0086\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\be\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u0092\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bP\u0010\u008e\u0001\u001a\u0005\bt\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010\u0096\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0093\u0001\u0010\"\u001a\u0005\b\u0094\u0001\u0010\u007f\"\u0006\b\u0095\u0001\u0010\u0081\u0001R+\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0005\bT\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010\u009f\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bM\u0010\"\u001a\u0005\b\u0098\u0001\u0010\u007f\"\u0006\b\u009e\u0001\u0010\u0081\u0001R&\u0010\u00a2\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bU\u0010\"\u001a\u0005\b\u00a0\u0001\u0010\u007f\"\u0006\b\u00a1\u0001\u0010\u0081\u0001R'\u0010\u00a4\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00a3\u0001\u0010\"\u001a\u0005\b\u00a4\u0001\u0010\u007f\"\u0006\b\u00a5\u0001\u0010\u0081\u0001R'\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u001a\u0010\u00a6\u0001\u001a\u0006\b\u0093\u0001\u0010\u00a7\u0001\"\u0006\b\u00a8\u0001\u0010\u00a9\u0001R,\u0010\u00ab\u0001\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u000106j\n\u0012\u0004\u0012\u00020&\u0018\u0001`78\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0011\u0010\u00aa\u0001R&\u0010\u00ae\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\u001b\u0010\"\u001a\u0005\b\u00ac\u0001\u0010\u007f\"\u0006\b\u00ad\u0001\u0010\u0081\u0001R\u0017\u0010\u00af\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\"R\u0017\u0010\u00b0\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u001a\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u00b1\u0001R%\u0010\u00b4\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\"\u0010\"\u001a\u0004\bh\u0010\u007f\"\u0006\b\u00b3\u0001\u0010\u0081\u0001R*\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00b5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u000f\u0010\u00b6\u0001\u001a\u0005\bl\u0010\u00b7\u0001\"\u0006\b\u00b8\u0001\u0010\u00b9\u0001R+\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b#\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001\"\u0006\b\u00bf\u0001\u0010\u00c0\u0001R%\u0010\u00c4\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0010\u0010T\u001a\u0005\b\u00c2\u0001\u0010V\"\u0005\b\u00c3\u0001\u0010oR\u001c\u0010\u00c9\u0001\u001a\u00030\u00c5\u00018\u0006\u00a2\u0006\u000f\n\u0005\b\f\u0010\u00c6\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001R\u001d\u0010\u00ce\u0001\u001a\u00030\u00ca\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00cd\u0001R\u001b\u0010\u00d2\u0001\u001a\u00030\u00cf\u00018\u0006\u00a2\u0006\u000e\n\u0005\b\r\u0010\u00d0\u0001\u001a\u0005\bd\u0010\u00d1\u0001R\u0017\u0010\u00d5\u0001\u001a\u00030\u00d3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b-\u0010\u00d4\u0001R\u0017\u0010\u00d6\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0015\u0010\u00d7\u0001\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010TR\u0016\u0010\u00d8\u0001\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00b3\u0001\u0010TR\u0018\u0010\u00d9\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010\"R\u0017\u0010\u00da\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0017\u0010\u00dd\u0001\u001a\u00030\u00db\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b4\u0010\u00dc\u0001R,\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u00de\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00df\u0001\u0010\u00e0\u0001\u001a\u0006\b\u00e1\u0001\u0010\u00e2\u0001\"\u0006\b\u00e3\u0001\u0010\u00e4\u0001\u00a8\u0006\u00eb\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/font/drawable/ETDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Ly03/c;", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/mobileqq/vas/font/IFontManager$b;", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "widthMeasureSpec", "heightMeasureSpec", "", "d0", "f0", "", "a0", "c0", "U", NodeProps.ON_CLICK, "resume", "", "o0", "n0", "h0", "i0", "l0", "T", "V", "Ljava/lang/Class;", "Lm/e;", "cls", HippyTKDListViewAdapter.X, "", "str", "Z", "b0", "t", DomainData.DOMAIN_NAME, "Landroid/graphics/Rect;", "padding", "j", "getPadding", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "X", "g0", "W", "location", "J", "Y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "m0", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "draw", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "b", "(II)Ljava/lang/Integer;", "Ly03/a;", "info", "f", "Lkotlin/Function1;", "block", "setLoadedListener", "Ljava/util/concurrent/ConcurrentHashMap;", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheResult", "", "Ljava/lang/CharSequence;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Ljava/lang/CharSequence;", "text", "M", "()J", "msgId", h.F, "I", BdhLogUtil.LogTag.Tag_Req, "()I", "textSize", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "O", "()Landroid/graphics/Paint;", "paint", "Ljava/lang/Integer;", "K", "()Ljava/lang/Integer;", "setMaxEms", "(Ljava/lang/Integer;)V", "maxEms", BdhLogUtil.LogTag.Tag_Conn, "L", "setMaxLines", "maxLines", "D", UserInfo.SEX_FEMALE, "setETMaxWidth", "eTMaxWidth", "E", "getMinWidth", "setMinWidth", "(I)V", NodeProps.MIN_WIDTH, "getMinHeight", "setMinHeight", NodeProps.MIN_HEIGHT, "G", "getMaxWidth", "setMaxWidth", NodeProps.MAX_WIDTH, "H", "highlightBackgroundColor", "[I", "getViewLocation", "()[I", "viewLocation", "getShouldStartAnimation", "()Z", "k0", "(Z)V", "shouldStartAnimation", "getTextColor", "setTextColor", "textColor", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "getTextColorLink", "()Landroid/content/res/ColorStateList;", "setTextColorLink", "(Landroid/content/res/ColorStateList;)V", "textColorLink", "Lcom/etrump/mixlayout/ETFont;", "Lcom/etrump/mixlayout/ETFont;", "()Lcom/etrump/mixlayout/ETFont;", "setFont", "(Lcom/etrump/mixlayout/ETFont;)V", "font", "N", "getMagicFont", "setMagicFont", "magicFont", "Lcom/etrump/mixlayout/e;", "P", "Lcom/etrump/mixlayout/e;", "()Lcom/etrump/mixlayout/e;", "setLayout", "(Lcom/etrump/mixlayout/e;)V", TtmlNode.TAG_LAYOUT, "setPauseAnimation", "pauseAnimation", "getDecorAnimating", "setDecorAnimating", "decorAnimating", ExifInterface.LATITUDE_SOUTH, "isParsingMagicFont", "setParsingMagicFont", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "setPadding", "(Landroid/graphics/Rect;)V", "Ljava/util/ArrayList;", "drawRect", "getHasSelected", "setHasSelected", "hasSelected", "hasComputeComplexScript", "hasComplexScript", "Lm/e;", "founderColorLayout", "j0", "decorRunning", "Lcom/etrump/mixlayout/ETDecoration;", "Lcom/etrump/mixlayout/ETDecoration;", "()Lcom/etrump/mixlayout/ETDecoration;", "setDecoration", "(Lcom/etrump/mixlayout/ETDecoration;)V", "decoration", "Lc13/a;", "Lc13/a;", "getTextSelection", "()Lc13/a;", "setTextSelection", "(Lc13/a;)V", "textSelection", "getLinkBackcolor", "setLinkBackcolor", "linkBackcolor", "Ly03/b;", "Ly03/b;", "B", "()Ly03/b;", "bitmapLocker", "La13/b;", "e0", "La13/b;", "()La13/b;", "uiHandler", "Landroid/os/Handler;", "Landroid/os/Handler;", "()Landroid/os/Handler;", "createDecorationHandler", "Lcom/etrump/mixlayout/q;", "Lcom/etrump/mixlayout/q;", "textGraphMap", "cacheMeasureResult", "screenWidth", "screenHeight", "isMeasured", "isEnable", "Ljava/lang/Object;", "Ljava/lang/Object;", "fontLock", "Ly03/c$a;", "animationListener", "Ly03/c$a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ly03/c$a;", "setAnimationListener", "(Ly03/c$a;)V", "Lcom/etrump/mixlayout/k;", "fontInfo", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "fontDrawableInfo", "<init>", "(Lcom/etrump/mixlayout/k;Lcom/tencent/mobileqq/vas/font/IFontManager$c;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ETDrawable extends AbsAsyncDrawable implements y03.c {

    /* renamed from: o0, reason: collision with root package name */
    private static final long f309134o0 = ar.INSTANCE.b("kenaiyu", "2024-07-31", "vas_bug_font_wait_time").getInt(120);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Integer maxLines;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer eTMaxWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int minWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int minHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private int maxWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private final int highlightBackgroundColor;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final int[] viewLocation;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean shouldStartAnimation;

    /* renamed from: K, reason: from kotlin metadata */
    private int textColor;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private ColorStateList textColorLink;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ETFont font;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean magicFont;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private e layout;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean pauseAnimation;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean decorAnimating;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isParsingMagicFont;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Rect padding;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Rect> drawRect;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean hasSelected;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean hasComputeComplexScript;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean hasComplexScript;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private m.e founderColorLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean decorRunning;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ETDecoration decoration;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c13.a textSelection;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int linkBackcolor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, int[]> cacheResult;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y03.b bitmapLocker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence text;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a13.b uiHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler createDecorationHandler;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q textGraphMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int textSize;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean cacheMeasureResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final int screenHeight;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean isMeasured;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean isEnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer maxEms;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object fontLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/font/drawable/ETDrawable$b", "Lcom/tencent/mobileqq/vas/font/manager/h$b;", "", "isSuccess", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements h.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILoaderSucessCallback f309154a;

        b(ILoaderSucessCallback iLoaderSucessCallback) {
            this.f309154a = iLoaderSucessCallback;
        }

        @Override // com.tencent.mobileqq.vas.font.manager.h.b
        public void a(boolean isSuccess) {
            if (isSuccess) {
                this.f309154a.onLoadSucceed();
            }
        }
    }

    public ETDrawable(@NotNull k fontInfo, @NotNull IFontManager.FontDrawableInfo fontDrawableInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Intrinsics.checkNotNullParameter(fontDrawableInfo, "fontDrawableInfo");
        this.cacheResult = new ConcurrentHashMap<>();
        CharSequence msg2 = fontDrawableInfo.getMsg();
        this.text = msg2;
        long msgId = fontDrawableInfo.getMsgId();
        this.msgId = msgId;
        int textSize = fontDrawableInfo.getTextSize();
        this.textSize = textSize;
        Paint paint = fontDrawableInfo.getPaint();
        this.paint = paint;
        this.maxEms = fontDrawableInfo.getMaxEms();
        this.maxLines = fontDrawableInfo.getMaxLines();
        this.eTMaxWidth = fontDrawableInfo.getETMaxWidth();
        this.minWidth = fontDrawableInfo.getMinWidth();
        this.minHeight = fontDrawableInfo.getCom.tencent.mtt.hippy.dom.node.NodeProps.MIN_HEIGHT java.lang.String();
        this.maxWidth = fontDrawableInfo.getMaxWidth();
        this.highlightBackgroundColor = fontDrawableInfo.getHighlightBackgroundColor();
        this.viewLocation = fontDrawableInfo.getViewLocation();
        this.shouldStartAnimation = true;
        this.textColor = fontDrawableInfo.getTextColor();
        this.textColorLink = fontDrawableInfo.getTextColorLink();
        if (fontDrawableInfo.getMagicFont() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.magicFont = z16;
        this.padding = new Rect(0, 0, 0, 0);
        this.bitmapLocker = new y03.b();
        this.uiHandler = new a13.b();
        this.createDecorationHandler = new a13.a(FontInfoManager.INSTANCE.b().getMHandlerThread().getLooper());
        this.textGraphMap = new q(fontDrawableInfo.getMsg());
        this.cacheMeasureResult = true;
        this.isEnable = VasNtToggle.VAS_FONT_CRASH_SWITCH_DEFAULT.isEnable(true);
        this.fontLock = new Object();
        ETFont eTFont = new ETFont(fontInfo.f32751a, fontInfo.f32752b, textSize);
        this.font = eTFont;
        eTFont.copy(fontInfo.f32756f);
        ETFont eTFont2 = this.font;
        eTFont2.mAnimationId = msgId;
        eTFont2.mText = msg2;
        eTFont2.setColor(this.textColor);
        this.font.setSize(textSize);
        paint.setTextSize(textSize);
        this.font.setBold((paint.getFlags() & 32) > 0);
        this.font.setShadow(false, 0, 0, 0, 0);
        DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
    }

    private final boolean T() {
        ETDecoration eTDecoration;
        if (this.layout == null || (eTDecoration = this.decoration) == null) {
            return false;
        }
        Intrinsics.checkNotNull(eTDecoration);
        if (eTDecoration.getFrameNum() <= 0) {
            return false;
        }
        return true;
    }

    private final boolean U() {
        ETFont eTFont = this.font;
        int i3 = eTFont.mFontId;
        if (i3 == 0 || eTFont.mFontType != 4) {
            return false;
        }
        int h16 = m.b.h(i3);
        if (h16 != 3 && h16 != 7 && h16 != 8) {
            return false;
        }
        return true;
    }

    private final boolean V() {
        ETFont eTFont = this.font;
        if (eTFont.mFontId == 0 || eTFont.getFontType() != 1 || ETEngine.getInstance().native_containComplexScript(this.text.toString())) {
            return false;
        }
        return true;
    }

    private final boolean Z(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if ('\u0600' <= charAt && charAt < '\u0700') {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if ('\u0750' <= charAt && charAt < '\u0780') {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if ('\ufb50' <= charAt && charAt < '\ufe00') {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        if ('\ufe70' <= charAt && charAt < '\uff00') {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (!z19 && charAt != '\ud835') {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final boolean a0() {
        e eVar = this.layout;
        boolean z16 = true;
        if (eVar == null) {
            return true;
        }
        if (eVar.f32709j >= 2048 || eVar.f32710k >= 2048) {
            z16 = false;
        }
        if (z16 && eVar.f32714o) {
            return false;
        }
        return z16;
    }

    private final boolean b0() {
        if (!this.hasComputeComplexScript) {
            this.hasComplexScript = Z(this.text.toString());
            this.hasComputeComplexScript = true;
        }
        ETFont eTFont = this.font;
        if (eTFont.mFontId != 0 && eTFont.getFontType() == 4 && !this.hasComplexScript) {
            return true;
        }
        return false;
    }

    private final boolean c0() {
        e eVar;
        if (V() && (eVar = this.layout) != null) {
            Intrinsics.checkNotNull(eVar);
            if (eVar.f32719t.get()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [T, int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, int[]] */
    private final int[] d0(final int widthMeasureSpec, final int heightMeasureSpec) {
        try {
            if (b0()) {
                int h16 = m.b.h(this.font.mFontId);
                int f16 = m.b.f(this.font.mFontId);
                if (h16 != 7) {
                    if (h16 != 8) {
                        x(m.class);
                    } else if (f16 != 1 && f16 != 2) {
                        if (f16 != 3 && f16 != 4 && f16 != 5) {
                            x(m.class);
                        } else {
                            x(g.class);
                        }
                    } else {
                        x(p.class);
                    }
                } else {
                    x(b13.b.class);
                }
                if (this.founderColorLayout == null) {
                    return null;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new int[0];
                FontInfoManager.Companion companion = FontInfoManager.INSTANCE;
                if (companion.a()) {
                    if (this.cacheResult.containsKey(Long.valueOf(this.msgId))) {
                        ?? r122 = this.cacheResult.get(Long.valueOf(this.msgId));
                        Intrinsics.checkNotNull(r122);
                        objectRef.element = r122;
                    } else {
                        synchronized (this.fontLock) {
                            companion.b().getMFontHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.drawable.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ETDrawable.e0(ETDrawable.this, objectRef, widthMeasureSpec, heightMeasureSpec);
                                }
                            });
                            this.fontLock.wait(f309134o0);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } else {
                    m.e eVar = this.founderColorLayout;
                    Intrinsics.checkNotNull(eVar);
                    ?? k3 = eVar.k(widthMeasureSpec, heightMeasureSpec, this.msgId, this.magicFont, this.font);
                    Intrinsics.checkNotNullExpressionValue(k3, "founderColorLayout!!.onM\u2026ont\n                    )");
                    objectRef.element = k3;
                }
                T t16 = objectRef.element;
                if (((int[]) t16).length <= 1 || ((int[]) t16)[0] <= 0 || ((int[]) t16)[1] <= 0) {
                    return null;
                }
                this.isMeasured = true;
                return (int[]) t16;
            }
        } catch (Exception e16) {
            QLog.e("FontAnimDrawable.ETDrawable", 1, "measure fontID : " + this.font.mFontId + " FZ fail ", e16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, int[], java.lang.Object] */
    public static final void e0(ETDrawable this$0, Ref.ObjectRef layoutResult, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layoutResult, "$layoutResult");
        synchronized (this$0.fontLock) {
            m.e eVar = this$0.founderColorLayout;
            Intrinsics.checkNotNull(eVar);
            ?? k3 = eVar.k(i3, i16, this$0.msgId, this$0.magicFont, this$0.font);
            Intrinsics.checkNotNullExpressionValue(k3, "founderColorLayout!!.onM\u2026                        )");
            layoutResult.element = k3;
            if (((int[]) k3).length > 1 && ((int[]) k3)[0] > 0 && ((int[]) k3)[1] > 0) {
                this$0.cacheResult.put(Long.valueOf(this$0.msgId), layoutResult.element);
            }
            this$0.fontLock.notify();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x017f A[Catch: Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:7:0x0012, B:10:0x002d, B:16:0x017b, B:18:0x017f, B:21:0x01a4, B:24:0x01d2, B:28:0x01ed, B:30:0x01ad, B:32:0x01c4, B:34:0x01cc, B:36:0x0187, B:38:0x019e, B:40:0x003c, B:42:0x0050, B:43:0x0058, B:45:0x0064, B:48:0x0071, B:49:0x0074, B:55:0x0086, B:56:0x008b, B:60:0x0096, B:62:0x00a6, B:63:0x00aa, B:65:0x00b4, B:69:0x00c9, B:70:0x00cd, B:72:0x00d6, B:77:0x00ed, B:78:0x011a, B:80:0x011e, B:82:0x0145, B:84:0x0148, B:87:0x014f, B:89:0x0161, B:90:0x0174, B:94:0x0092, B:95:0x0080, B:96:0x0079), top: B:6:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ed A[Catch: Exception -> 0x01f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x01f0, blocks: (B:7:0x0012, B:10:0x002d, B:16:0x017b, B:18:0x017f, B:21:0x01a4, B:24:0x01d2, B:28:0x01ed, B:30:0x01ad, B:32:0x01c4, B:34:0x01cc, B:36:0x0187, B:38:0x019e, B:40:0x003c, B:42:0x0050, B:43:0x0058, B:45:0x0064, B:48:0x0071, B:49:0x0074, B:55:0x0086, B:56:0x008b, B:60:0x0096, B:62:0x00a6, B:63:0x00aa, B:65:0x00b4, B:69:0x00c9, B:70:0x00cd, B:72:0x00d6, B:77:0x00ed, B:78:0x011a, B:80:0x011e, B:82:0x0145, B:84:0x0148, B:87:0x014f, B:89:0x0161, B:90:0x0174, B:94:0x0092, B:95:0x0080, B:96:0x0079), top: B:6:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01ad A[Catch: Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:7:0x0012, B:10:0x002d, B:16:0x017b, B:18:0x017f, B:21:0x01a4, B:24:0x01d2, B:28:0x01ed, B:30:0x01ad, B:32:0x01c4, B:34:0x01cc, B:36:0x0187, B:38:0x019e, B:40:0x003c, B:42:0x0050, B:43:0x0058, B:45:0x0064, B:48:0x0071, B:49:0x0074, B:55:0x0086, B:56:0x008b, B:60:0x0096, B:62:0x00a6, B:63:0x00aa, B:65:0x00b4, B:69:0x00c9, B:70:0x00cd, B:72:0x00d6, B:77:0x00ed, B:78:0x011a, B:80:0x011e, B:82:0x0145, B:84:0x0148, B:87:0x014f, B:89:0x0161, B:90:0x0174, B:94:0x0092, B:95:0x0080, B:96:0x0079), top: B:6:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0187 A[Catch: Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:7:0x0012, B:10:0x002d, B:16:0x017b, B:18:0x017f, B:21:0x01a4, B:24:0x01d2, B:28:0x01ed, B:30:0x01ad, B:32:0x01c4, B:34:0x01cc, B:36:0x0187, B:38:0x019e, B:40:0x003c, B:42:0x0050, B:43:0x0058, B:45:0x0064, B:48:0x0071, B:49:0x0074, B:55:0x0086, B:56:0x008b, B:60:0x0096, B:62:0x00a6, B:63:0x00aa, B:65:0x00b4, B:69:0x00c9, B:70:0x00cd, B:72:0x00d6, B:77:0x00ed, B:78:0x011a, B:80:0x011e, B:82:0x0145, B:84:0x0148, B:87:0x014f, B:89:0x0161, B:90:0x0174, B:94:0x0092, B:95:0x0080, B:96:0x0079), top: B:6:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int[] f0(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z16;
        int i3;
        boolean z17;
        Rect rect;
        boolean z18;
        ETDecoration eTDecoration;
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtLeast2;
        boolean z19;
        if (this.font.mFontId != 0 && V()) {
            try {
                int mode = View.MeasureSpec.getMode(widthMeasureSpec);
                int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                e eVar = this.layout;
                if (eVar != null) {
                    if (eVar != null && eVar.f32715p == this.magicFont) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        rect = null;
                        eTDecoration = this.decoration;
                        if (eTDecoration != null) {
                            Intrinsics.checkNotNull(eTDecoration);
                            rect = eTDecoration.mMargins;
                        }
                        if (mode == 1073741824) {
                            Rect rect2 = new Rect();
                            getPadding(rect2);
                            e eVar2 = this.layout;
                            Intrinsics.checkNotNull(eVar2);
                            size = eVar2.f32709j + rect2.left + rect2.right;
                            if (rect != null) {
                                size += rect.left + rect.right;
                            }
                        }
                        coerceAtMost = RangesKt___RangesKt.coerceAtMost(size, this.maxWidth);
                        if (mode2 == 1073741824) {
                            Rect rect3 = new Rect();
                            getPadding(rect3);
                            e eVar3 = this.layout;
                            Intrinsics.checkNotNull(eVar3);
                            int i16 = eVar3.f32710k + rect3.top + rect3.bottom;
                            if (rect != null) {
                                i16 += rect.top + rect.bottom;
                            }
                            if (mode2 == Integer.MIN_VALUE) {
                                size2 = RangesKt___RangesKt.coerceAtMost(i16, size2);
                            } else {
                                size2 = i16;
                            }
                        }
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, this.minWidth);
                        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(size2, this.minHeight);
                        int[] iArr = {coerceAtLeast, coerceAtLeast2};
                        if (a0()) {
                            return null;
                        }
                        this.isMeasured = true;
                        return iArr;
                    }
                }
                this.decorRunning = false;
                e eVar4 = new e();
                this.layout = eVar4;
                this.textSelection = new c13.a(this, eVar4);
                ETDecoration eTDecoration2 = this.decoration;
                if (eTDecoration2 != null) {
                    Intrinsics.checkNotNull(eTDecoration2);
                    eTDecoration2.deleteDescriptor();
                    this.decoration = null;
                }
                ETEngine eTEngine = ETEngine.getInstance();
                Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
                if (fontMetrics != null) {
                    float f16 = (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
                    e eVar5 = this.layout;
                    if (eVar5 != null) {
                        eVar5.f32700a = (int) f16;
                    }
                }
                e eVar6 = this.layout;
                if (eVar6 != null) {
                    eVar6.f32701b = this.msgId;
                }
                if (eVar6 != null) {
                    eVar6.f32715p = this.magicFont;
                }
                if (eVar6 != null) {
                    eVar6.z(this.linkBackcolor);
                }
                int i17 = this.maxWidth;
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i17 = RangesKt___RangesKt.coerceAtMost(i17, size);
                }
                Rect rect4 = new Rect();
                getPadding(rect4);
                int i18 = i17 - (rect4.left + rect4.right);
                if (mode == Integer.MIN_VALUE) {
                    i18 = RangesKt___RangesKt.coerceAtMost(size, i18);
                }
                int i19 = i18;
                e eVar7 = this.layout;
                Intrinsics.checkNotNull(eVar7);
                if (eVar7.f32715p) {
                    IFontManager.Companion companion = IFontManager.INSTANCE;
                    float e16 = companion.e();
                    if (FontSettingManager.getFontLevel() == 18.0f) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        e16 = companion.c();
                    }
                    this.font.setSize(e16 * this.textSize);
                }
                int native_getHorizontalMarginThreshold = eTEngine.native_getHorizontalMarginThreshold(this.font, i19);
                this.font.setSize(this.textSize);
                if (1 <= native_getHorizontalMarginThreshold && native_getHorizontalMarginThreshold < i19) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int i26 = i19 - native_getHorizontalMarginThreshold;
                    e eVar8 = this.layout;
                    Intrinsics.checkNotNull(eVar8);
                    i3 = i19;
                    z17 = eVar8.y(eTEngine, i26, this.text, this.font, this.textColorLink.getDefaultColor(), true, i3);
                    e eVar9 = this.layout;
                    Intrinsics.checkNotNull(eVar9);
                    this.decoration = eVar9.e(eTEngine, true);
                } else {
                    i3 = i19;
                    z17 = false;
                }
                if (this.decoration == null) {
                    e eVar10 = this.layout;
                    Intrinsics.checkNotNull(eVar10);
                    z17 = eVar10.y(eTEngine, i3, this.text, this.font, this.textColorLink.getDefaultColor(), false, i3);
                    e eVar11 = this.layout;
                    Intrinsics.checkNotNull(eVar11);
                    this.decoration = eVar11.e(eTEngine, true);
                }
                if (!z17) {
                    this.layout = null;
                    return null;
                }
                if (!a0()) {
                    return null;
                }
                e eVar12 = this.layout;
                Intrinsics.checkNotNull(eVar12);
                int i27 = eVar12.f32709j;
                e eVar13 = this.layout;
                Intrinsics.checkNotNull(eVar13);
                int i28 = eVar13.f32710k;
                ETDecoration eTDecoration3 = this.decoration;
                if (eTDecoration3 != null) {
                    Intrinsics.checkNotNull(eTDecoration3);
                    rect = eTDecoration3.mMargins;
                    i27 += rect.left + rect.right;
                    i28 += rect.top + rect.bottom;
                } else {
                    rect = null;
                }
                this.bitmapLocker.b(i27, i28, this.textSize);
                eTDecoration = this.decoration;
                if (eTDecoration != null) {
                }
                if (mode == 1073741824) {
                }
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(size, this.maxWidth);
                if (mode2 == 1073741824) {
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, this.minWidth);
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(size2, this.minHeight);
                int[] iArr2 = {coerceAtLeast, coerceAtLeast2};
                if (a0()) {
                }
            } catch (Exception e17) {
                if (this.isEnable) {
                    this.layout = null;
                }
                QLog.e("FontAnimDrawable.ETDrawable", 1, "measure fontID : " + this.font.mFontId + " HY fail ", e17);
            }
        }
        return null;
    }

    private final void h0() {
        m.e eVar = this.founderColorLayout;
        if (eVar != null) {
            eVar.m();
        }
    }

    private final void i0() {
        m.e eVar = this.founderColorLayout;
        if (eVar != null) {
            eVar.n();
        }
    }

    private final void l0(boolean onClick, boolean resume) {
        if (T() && !this.isParsingMagicFont) {
            boolean z16 = ETFontUtil.enableAnimation;
            this.decorAnimating = z16;
            if (z16 && !this.decorRunning) {
                if (resume) {
                    ETDecoration eTDecoration = this.decoration;
                    Intrinsics.checkNotNull(eTDecoration);
                    if (eTDecoration.isLastFrame() && !this.shouldStartAnimation) {
                        return;
                    }
                }
                this.decorRunning = true;
                this.uiHandler.obtainMessage(0, a.a(this)).sendToTarget();
            }
        }
    }

    private final void n0() {
        m.e eVar = this.founderColorLayout;
        if (eVar != null) {
            eVar.o();
        }
    }

    private final void o0(boolean onClick, boolean resume) {
        boolean z16 = true;
        if (ETFontUtil.enableAnimation && !this.pauseAnimation) {
            m.e eVar = this.founderColorLayout;
            if (eVar != null) {
                if (onClick || resume || this.shouldStartAnimation) {
                    Intrinsics.checkNotNull(eVar);
                    int i3 = eVar.f415894g;
                    m.e eVar2 = this.founderColorLayout;
                    Intrinsics.checkNotNull(eVar2);
                    int i16 = eVar2.f415890c;
                    if (resume && i3 == 0 && !this.shouldStartAnimation) {
                        return;
                    }
                    if (i3 == 0) {
                        n0();
                        this.shouldStartAnimation = false;
                        return;
                    }
                    if (1 > i3 || i3 >= i16) {
                        z16 = false;
                    }
                    if (z16) {
                        i0();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m.e eVar3 = this.founderColorLayout;
        if (eVar3 != null) {
            Intrinsics.checkNotNull(eVar3);
            int i17 = eVar3.f415894g;
            m.e eVar4 = this.founderColorLayout;
            Intrinsics.checkNotNull(eVar4);
            int i18 = eVar4.f415890c;
            if (1 > i17 || i17 >= i18) {
                z16 = false;
            }
            if (z16) {
                h0();
            }
        }
    }

    private final void x(Class<? extends m.e> cls) {
        m.e eVar = this.founderColorLayout;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            if (Intrinsics.areEqual(eVar.getClass(), cls)) {
                return;
            }
        }
        if (Intrinsics.areEqual(cls, m.class)) {
            this.founderColorLayout = new m(this, this.font);
            return;
        }
        if (Intrinsics.areEqual(cls, p.class)) {
            this.founderColorLayout = new p(this, this.font);
            return;
        }
        if (Intrinsics.areEqual(cls, b13.b.class)) {
            this.founderColorLayout = new b13.b(this, this.font);
            return;
        }
        if (Intrinsics.areEqual(cls, g.class)) {
            this.founderColorLayout = new g(this, this.font);
            return;
        }
        throw new RuntimeException("Unkown class: " + cls.getName());
    }

    private final IFontManager.DrawableResultInfo y(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        m.e eVar = this.founderColorLayout;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            if (!eVar.j(canvas)) {
                return new IFontManager.DrawableResultInfo(false, false, this.textColor);
            }
        }
        n.a("action_draw", this.font.mFontId, 4, this.text.length(), System.currentTimeMillis() - currentTimeMillis);
        if (U() && this.shouldStartAnimation) {
            o0(false, false);
        }
        return new IFontManager.DrawableResultInfo(true, false, this.textColor);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:7:0x001b, B:9:0x0024, B:11:0x002a, B:13:0x003a, B:15:0x003e, B:17:0x004f, B:18:0x009e, B:19:0x0058, B:21:0x0060, B:24:0x006c, B:26:0x0085, B:27:0x0096, B:29:0x00a6), top: B:6:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final IFontManager.DrawableResultInfo z(Canvas canvas) {
        boolean z16;
        ETDecoration eTDecoration;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.shouldStartAnimation) {
            l0(false, false);
        }
        e eVar = this.layout;
        Intrinsics.checkNotNull(eVar);
        eVar.f32703d.setColor(this.textColor);
        synchronized (this.bitmapLocker) {
            Bitmap bitmap = this.bitmapLocker.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
            if (bitmap != null && !bitmap.isRecycled()) {
                Rect rect = new Rect();
                getPadding(rect);
                int i3 = rect.left;
                int i16 = rect.top;
                if (this.decorRunning && this.decoration != null) {
                    canvas.drawBitmap(bitmap, i3, i16, (Paint) null);
                    ETDecoration eTDecoration2 = this.decoration;
                    Intrinsics.checkNotNull(eTDecoration2);
                    if (eTDecoration2.getDecorationType() == 1) {
                        e eVar2 = this.layout;
                        Intrinsics.checkNotNull(eVar2);
                        eVar2.D(canvas, i3, i16);
                    }
                } else {
                    ETEngine eTEngine = ETEngine.getInstance();
                    ETDecoration eTDecoration3 = this.decoration;
                    if (eTDecoration3 != null) {
                        Intrinsics.checkNotNull(eTDecoration3);
                        if (!eTDecoration3.isLastFrame()) {
                            z16 = true;
                            bitmap.eraseColor(0);
                            e eVar3 = this.layout;
                            Intrinsics.checkNotNull(eVar3);
                            eVar3.g(eTEngine, bitmap, this.decoration, z16);
                            e eVar4 = this.layout;
                            Intrinsics.checkNotNull(eVar4);
                            eVar4.h(canvas, i3, i16, bitmap);
                            eTDecoration = this.decoration;
                            if (eTDecoration != null) {
                                Intrinsics.checkNotNull(eTDecoration);
                                Rect rect2 = eTDecoration.mMargins;
                                Intrinsics.checkNotNullExpressionValue(rect2, "decoration!!.mMargins");
                                i3 += rect2.left;
                                i16 += rect2.top;
                            }
                            e eVar5 = this.layout;
                            Intrinsics.checkNotNull(eVar5);
                            eVar5.D(canvas, i3, i16);
                        }
                    }
                    z16 = false;
                    bitmap.eraseColor(0);
                    e eVar32 = this.layout;
                    Intrinsics.checkNotNull(eVar32);
                    eVar32.g(eTEngine, bitmap, this.decoration, z16);
                    e eVar42 = this.layout;
                    Intrinsics.checkNotNull(eVar42);
                    eVar42.h(canvas, i3, i16, bitmap);
                    eTDecoration = this.decoration;
                    if (eTDecoration != null) {
                    }
                    e eVar52 = this.layout;
                    Intrinsics.checkNotNull(eVar52);
                    eVar52.D(canvas, i3, i16);
                }
                e eVar6 = this.layout;
                Intrinsics.checkNotNull(eVar6);
                eVar6.E(canvas, i3, i16);
            }
            Unit unit = Unit.INSTANCE;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ETFont eTFont = this.font;
        n.a("action_draw", eTFont.mFontId, eTFont.mFontType, this.text.length(), currentTimeMillis2 - currentTimeMillis);
        return new IFontManager.DrawableResultInfo(true, false, this.textColor);
    }

    @Nullable
    public final c.a A() {
        return null;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final y03.b getBitmapLocker() {
        return this.bitmapLocker;
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final Handler getCreateDecorationHandler() {
        return this.createDecorationHandler;
    }

    /* renamed from: D, reason: from getter */
    public final boolean getDecorRunning() {
        return this.decorRunning;
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final ETDecoration getDecoration() {
        return this.decoration;
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final Integer getETMaxWidth() {
        return this.eTMaxWidth;
    }

    @NotNull
    /* renamed from: G, reason: from getter */
    public final ETFont getFont() {
        return this.font;
    }

    /* renamed from: H, reason: from getter */
    public final int getHighlightBackgroundColor() {
        return this.highlightBackgroundColor;
    }

    @Nullable
    /* renamed from: I, reason: from getter */
    public final e getLayout() {
        return this.layout;
    }

    public final void J(@NotNull int[] location) {
        Intrinsics.checkNotNullParameter(location, "location");
        int[] iArr = this.viewLocation;
        location[0] = iArr[0];
        location[1] = iArr[1];
    }

    @Nullable
    /* renamed from: K, reason: from getter */
    public final Integer getMaxEms() {
        return this.maxEms;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final Integer getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: M, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    @NotNull
    /* renamed from: N, reason: from getter */
    public final Rect getPadding() {
        return this.padding;
    }

    @NotNull
    /* renamed from: O, reason: from getter */
    public final Paint getPaint() {
        return this.paint;
    }

    /* renamed from: P, reason: from getter */
    public final boolean getPauseAnimation() {
        return this.pauseAnimation;
    }

    @NotNull
    /* renamed from: Q, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    /* renamed from: R, reason: from getter */
    public final int getTextSize() {
        return this.textSize;
    }

    @NotNull
    /* renamed from: S, reason: from getter */
    public final a13.b getUiHandler() {
        return this.uiHandler;
    }

    /* renamed from: W, reason: from getter */
    public final boolean getHasSelected() {
        return this.hasSelected;
    }

    public final void X() {
        postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.font.drawable.ETDrawable$invalidate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ETDrawable.this.invalidateSelf();
            }
        });
    }

    /* renamed from: Y, reason: from getter */
    public final boolean getCacheMeasureResult() {
        return this.cacheMeasureResult;
    }

    @Override // y03.c
    @Nullable
    public ArrayList<Rect> a() {
        ArrayList<Rect> arrayList;
        m.e eVar;
        if (b0() && (eVar = this.founderColorLayout) != null) {
            if (eVar instanceof m) {
                Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.mobileqq.vas.font.fz.FounderColorLayout");
                this.drawRect = ((m) eVar).G();
            } else if (eVar instanceof g) {
                Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.mobileqq.vas.font.fz.ExpressionLayout");
                this.drawRect = ((g) eVar).G();
            }
        } else if (c0()) {
            e eVar2 = this.layout;
            if (eVar2 != null) {
                arrayList = eVar2.p();
            } else {
                arrayList = null;
            }
            this.drawRect = arrayList;
        }
        if (this.drawRect == null) {
            QLog.e("FontAnimDrawable", 1, "getFontDrawRect == null " + this.font);
        }
        return this.drawRect;
    }

    @Override // y03.c
    @Nullable
    public Integer b(int x16, int y16) {
        c13.a aVar;
        if (b0()) {
            Object obj = this.founderColorLayout;
            if (obj instanceof e.a) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.Vas.ColorFont.FounderBaseLayout.FounderHighlightInterface");
                return Integer.valueOf(this.textGraphMap.b(((e.a) obj).b(x16, y16)));
            }
            return null;
        }
        if (c0() && (aVar = this.textSelection) != null) {
            Intrinsics.checkNotNull(aVar);
            return Integer.valueOf(this.textGraphMap.b(aVar.a(x16, y16)));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b(callback);
        int i3 = this.font.mFontType;
        if (4 == i3) {
            com.tencent.mobileqq.vas.font.manager.h.INSTANCE.a().b(bVar);
        } else if (1 == i3) {
            com.tencent.mobileqq.vas.font.manager.h.INSTANCE.b().b(bVar);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!e(canvas).getDrawFont()) {
            super.draw(canvas);
        }
    }

    @Override // y03.c
    @NotNull
    public IFontManager.DrawableResultInfo e(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!TextUtils.isEmpty(this.text) && this.isMeasured) {
            Rect clipBounds = canvas.getClipBounds();
            Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
            int i3 = clipBounds.left;
            if (i3 != 0 || clipBounds.top != 0) {
                canvas.translate(i3, clipBounds.top);
            }
            if (!c0() && !b0()) {
                ETFont eTFont = this.font;
                if (eTFont.mFontId != 0 && eTFont.mFontType == 1 && ETEngine.getInstance().native_isColorVariantFont(this.font)) {
                    this.textColor = ETEngine.getInstance().native_getTextColor(this.font);
                }
                return new IFontManager.DrawableResultInfo(false, true, this.textColor);
            }
            if (c0()) {
                return z(canvas);
            }
            if (b0()) {
                return y(canvas);
            }
            return new IFontManager.DrawableResultInfo(false, false, this.textColor);
        }
        return new IFontManager.DrawableResultInfo(false, false, 0);
    }

    @Override // y03.c
    public void f(@NotNull AIOTextViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.eTMaxWidth = Integer.valueOf(info.getMaxWidth());
        this.maxEms = Integer.valueOf(info.getMaxEms());
        this.maxLines = Integer.valueOf(info.getMaxLines());
        this.minWidth = info.getMinWidth();
        this.minHeight = info.getMinHeight();
        this.maxWidth = info.getMaxWidth();
        j(info.getPaddingRect());
    }

    @Override // y03.c
    public void g() {
        this.pauseAnimation = false;
        if (c0()) {
            l0(false, true);
        } else if (U()) {
            o0(false, true);
        }
    }

    public final void g0() {
        this.shouldStartAnimation = false;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Rect rect = this.padding;
        padding.left = rect.left;
        padding.top = rect.top;
        padding.right = rect.right;
        padding.bottom = rect.bottom;
        return true;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        int i3 = this.font.mFontType;
        if (4 == i3) {
            return com.tencent.mobileqq.vas.font.manager.h.INSTANCE.a().a();
        }
        if (1 != i3) {
            return true;
        }
        return com.tencent.mobileqq.vas.font.manager.h.INSTANCE.b().a();
    }

    @Override // y03.c
    public void j(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.padding = padding;
    }

    public final void j0(boolean z16) {
        this.decorRunning = z16;
    }

    public final void k0(boolean z16) {
        this.shouldStartAnimation = z16;
    }

    @Override // y03.c
    public void m() {
        this.pauseAnimation = true;
        if (U()) {
            h0();
        }
    }

    public void m0(boolean onClick, boolean resume) {
        this.pauseAnimation = false;
        if (c0()) {
            l0(onClick, resume);
        } else if (U()) {
            o0(onClick, resume);
        }
    }

    @Override // y03.c
    @NotNull
    public String n() {
        String fontPath = ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getFontPath(this.font.mFontId);
        Intrinsics.checkNotNullExpressionValue(fontPath, "fontBusiness.getFontPath(font.mFontId)");
        return fontPath;
    }

    @Override // y03.c
    public boolean o() {
        if ((!c0() || !T()) && !U()) {
            return false;
        }
        m0(true, false);
        return true;
    }

    @Override // y03.c
    @SuppressLint({"DrawAllocation"})
    @NotNull
    public int[] q(int widthMeasureSpec, int heightMeasureSpec) {
        int[] iArr = {widthMeasureSpec, heightMeasureSpec};
        if (TextUtils.isEmpty(this.text)) {
            return iArr;
        }
        int[] d06 = d0(widthMeasureSpec, heightMeasureSpec);
        if (d06 != null) {
            return d06;
        }
        int[] f06 = f0(widthMeasureSpec, heightMeasureSpec);
        if (f06 != null) {
            return f06;
        }
        return iArr;
    }

    @Override // y03.c
    public void setLoadedListener(@NotNull Function1<? super y03.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @Override // y03.c
    public boolean t() {
        return true;
    }
}
