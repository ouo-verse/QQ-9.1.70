package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Magnifier;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.lo.r;
import com.tencent.mm.ui.widget.edittext.CursorHandle;
import com.tencent.mm.ui.widget.pulldown.IBounceView;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010%\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u001b\b\u0016\u0018\u0000 \u00af\u00022\u00020\u0001:\f\u00b0\u0002\u00af\u0002\u00b1\u0002\u00b2\u0002\u00b3\u0002\u00b4\u0002B\u0013\b\u0004\u0012\u0006\u0010E\u001a\u00020C\u00a2\u0006\u0006\b\u00ad\u0002\u0010\u00ae\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u0010\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\fH\u0014J\u0012\u00101\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u000105J\u0006\u00108\u001a\u00020\u0002J\u0012\u0010;\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010<\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010\u0004\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/H\u0014J\u0010\u0010>\u001a\u0004\u0018\u00010/2\u0006\u0010=\u001a\u00020\fJ\u0006\u0010?\u001a\u00020\u0002J\u0006\u0010@\u001a\u00020\u0005J\n\u0010B\u001a\u0004\u0018\u00010AH\u0007R\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010DR$\u0010K\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010O\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010F\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR$\u0010U\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010\\\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010k\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010s\u001a\u00020l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010{\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R+\u0010\u00a4\u0001\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001\"\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u00a7\u0001\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R)\u0010\u00ad\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001\"\u0006\b\u00ab\u0001\u0010\u00ac\u0001R(\u0010\u00b0\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0007\u0010\u00a6\u0001\u001a\u0006\b\u00ae\u0001\u0010\u00aa\u0001\"\u0006\b\u00af\u0001\u0010\u00ac\u0001R\u0018\u0010\u00b2\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\b\u0010\u00b1\u0001R)\u0010\u00b4\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b3\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001R)\u0010\u00bb\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b8\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00aa\u0001\"\u0006\b\u00ba\u0001\u0010\u00ac\u0001R)\u0010\u00bf\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bc\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00b5\u0001\"\u0006\b\u00be\u0001\u0010\u00b7\u0001R\u001c\u0010\u00c1\u0001\u001a\u00020\f8\u0006\u00a2\u0006\u0010\n\u0006\b\u00c0\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00b5\u0001R\u001c\u0010\u00c3\u0001\u001a\u00020\f8\u0006\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00b5\u0001R\u0019\u0010\u00c5\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00b1\u0001R\u0019\u0010\u00c7\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00b1\u0001R\u0019\u0010\u00c9\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00a6\u0001R\u0019\u0010\u00cb\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00a6\u0001R\u0019\u0010\u00cc\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a6\u0001R\u0019\u0010\u00ce\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00a6\u0001R7\u0010\u00d7\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00d0\u00010\u00cf\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\"\u0006\b\u00d5\u0001\u0010\u00d6\u0001R*\u0010\u00df\u0001\u001a\u00030\u00d8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d9\u0001\u0010\u00da\u0001\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001\"\u0006\b\u00dd\u0001\u0010\u00de\u0001R\u0019\u0010\u00e1\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e0\u0001\u0010\u00b1\u0001R*\u0010\u00e9\u0001\u001a\u00030\u00e2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001\u001a\u0006\b\u00e5\u0001\u0010\u00e6\u0001\"\u0006\b\u00e7\u0001\u0010\u00e8\u0001R,\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00ea\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001\u001a\u0006\b\u00ed\u0001\u0010\u00ee\u0001\"\u0006\b\u00ef\u0001\u0010\u00f0\u0001R)\u0010\u00f3\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f2\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00f3\u0001\u0010\u00b5\u0001\"\u0006\b\u00f4\u0001\u0010\u00b7\u0001R)\u0010\u00f8\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f5\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00f6\u0001\u0010\u00aa\u0001\"\u0006\b\u00f7\u0001\u0010\u00ac\u0001R\u0018\u0010\u00fc\u0001\u001a\u00030\u00f9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00fa\u0001\u0010\u00fb\u0001R)\u0010\u0080\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00fd\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00fe\u0001\u0010\u00aa\u0001\"\u0006\b\u00ff\u0001\u0010\u00ac\u0001R\u001f\u0010\u0085\u0002\u001a\u00030\u0081\u00028\u0014X\u0094\u0004\u00a2\u0006\u000f\n\u0006\b\u0082\u0002\u0010\u0083\u0002\u001a\u0005\bL\u0010\u0084\u0002R\u0019\u0010\u0087\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0002\u0010\u00b1\u0001R\u0018\u0010\u008a\u0002\u001a\u00030\u0088\u00028\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u0089\u0002\u0010\u00cd\u0001R\u001c\u0010\u008d\u0002\u001a\u00020\f8\u0006\u00a2\u0006\u0010\n\u0006\b\u008b\u0002\u0010\u00b1\u0001\u001a\u0006\b\u008c\u0002\u0010\u00b5\u0001R+\u0010\u0094\u0002\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R\u001d\u0010\u0097\u0002\u001a\u00030\u0081\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0095\u0002\u0010\u0083\u0002\u001a\u0006\b\u0096\u0002\u0010\u0084\u0002R\u001f\u0010\u0099\u0002\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\u0010\n\u0006\b\u00b1\u0001\u0010\u00a6\u0001\u001a\u0006\b\u0098\u0002\u0010\u00aa\u0001R*\u0010\u00a0\u0002\u001a\u00030\u009a\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0002\u0010\u00c6\u0001\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R*\u0010\u00a4\u0002\u001a\u00030\u009a\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a1\u0002\u0010\u00c6\u0001\u001a\u0006\b\u00a2\u0002\u0010\u009d\u0002\"\u0006\b\u00a3\u0002\u0010\u009f\u0002R*\u0010\u00a8\u0002\u001a\u00030\u009a\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a5\u0002\u0010\u00c6\u0001\u001a\u0006\b\u00a6\u0002\u0010\u009d\u0002\"\u0006\b\u00a7\u0002\u0010\u009f\u0002R\u0013\u0010\u00aa\u0002\u001a\u0002098F\u00a2\u0006\u0007\u001a\u0005\b\u00a9\u0002\u0010YR\u0014\u0010\u00ac\u0002\u001a\u00020\u00058F\u00a2\u0006\b\u001a\u0006\b\u00ab\u0002\u0010\u00aa\u0001\u00a8\u0006\u00b5\u0002"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "", "", "d", "a", "", "duration", HippyTKDListViewAdapter.X, "y", "b", "Lcom/tencent/mm/ui/widget/edittext/InsertHandle;", "insertHandle", "", "hasHandleInMoving", "flag", "isCurHasWindowShow", "getCurVisibilityFlag", "handleNewWayScrollChanged", "closeSelectAndTools", "isHorizontalOrientation", "hasFocus", "handleClickOrFocus", "Landroid/view/View$OnLongClickListener;", "mOutOnLongClickListener", "setOutOnLongClickListener", "Landroid/view/View$OnTouchListener;", "mOutOnTouchListener", "setOutOnTouchListener", "Landroid/view/View$OnFocusChangeListener;", "mOutOnFocusChangeListener", "setOutOnFocusChangeListener", "Landroid/view/View$OnClickListener;", "mOutOnClickListener", "setOutOnClickListener", "Landroid/view/View$OnKeyListener;", "mOutOnKeyListener", "setOutOnKeyListener", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "callback", "setMenuCallback", "showFlag", "showWindows", "hideSelectView", "resetSelectionInfo", "pause", "resume", "isSelect", "Lcom/tencent/mm/ui/widget/edittext/CursorHandle;", "cursorHandle", "showCursorHandle", "startPos", "endPos", "selectText", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnSelectListener;", "selectListener", "setSelectListener", "destroy", "Lcom/tencent/mm/ui/widget/edittext/OperateWindow;", "operateWindow", "showOperWindow", "dismissOperWindow", "isLeft", "getCursorHandle", "dismissInsertionDelay", "getLastTouchRawY", "Lcom/tencent/mm/ui/widget/edittext/MagnifierMotionAnimator;", "getMagnifierAnimator", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder;", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder;", "mBuilder", "Lcom/tencent/mm/ui/widget/edittext/CursorHandle;", "getMStartHandle", "()Lcom/tencent/mm/ui/widget/edittext/CursorHandle;", "setMStartHandle", "(Lcom/tencent/mm/ui/widget/edittext/CursorHandle;)V", "mStartHandle", "c", "getMEndHandle", "setMEndHandle", "mEndHandle", "Lcom/tencent/mm/ui/widget/edittext/InsertHandle;", "getMInsertHandle", "()Lcom/tencent/mm/ui/widget/edittext/InsertHandle;", "setMInsertHandle", "(Lcom/tencent/mm/ui/widget/edittext/InsertHandle;)V", "mInsertHandle", "e", "Lcom/tencent/mm/ui/widget/edittext/OperateWindow;", "getMOperateWindow", "()Lcom/tencent/mm/ui/widget/edittext/OperateWindow;", "setMOperateWindow", "(Lcom/tencent/mm/ui/widget/edittext/OperateWindow;)V", "mOperateWindow", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$SelectionInfo;", "f", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$SelectionInfo;", "getMSelectionInfo", "()Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$SelectionInfo;", "setMSelectionInfo", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$SelectionInfo;)V", "mSelectionInfo", "g", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnSelectListener;", "getMSelectListener", "()Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnSelectListener;", "setMSelectListener", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnSelectListener;)V", "mSelectListener", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "getMTextView", "()Landroid/widget/TextView;", "setMTextView", "(Landroid/widget/TextView;)V", "mTextView", "Landroid/text/Spannable;", "j", "Landroid/text/Spannable;", "mSpannable", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "k", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "l", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "mOnScrollChangedListener", "Landroid/view/View$OnAttachStateChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnAttachStateChangeListener;", "mOnAttachStateChangeListener", "Landroid/view/View$OnLayoutChangeListener;", DomainData.DOMAIN_NAME, "Landroid/view/View$OnLayoutChangeListener;", "mOnLayoutChangeListener", "Landroid/text/TextWatcher;", "o", "Landroid/text/TextWatcher;", "mTextWatcher", "p", "Landroid/view/View$OnLongClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnTouchListener;", "r", "Landroid/view/View$OnFocusChangeListener;", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View$OnClickListener;", "t", "Landroid/view/View$OnKeyListener;", "u", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "getMOnMenuCallback", "()Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "setMOnMenuCallback", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;)V", "mOnMenuCallback", "v", "I", "mSelectedColor", "w", "getMCursorHandleColor", "()I", "setMCursorHandleColor", "(I)V", "mCursorHandleColor", "getMCursorHandleSize", "setMCursorHandleSize", "mCursorHandleSize", "Z", "isHideWhenScroll", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isHide", "()Z", "setHide", "(Z)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getMTextLineHeight", "setMTextLineHeight", "mTextLineHeight", "B", "getMIsEnable", "setMIsEnable", "mIsEnable", BdhLogUtil.LogTag.Tag_Conn, "isHandleScrollInNewWay", "D", "isHandleScrollInOldWay", "E", "mIsScrolling", UserInfo.SEX_FEMALE, "mIsInLongClick", "G", "mTouchX", "H", "mTouchY", "mTouchRawY", "J", "mScrollY", "", "", "K", "Ljava/util/Map;", "getMReuseMenuItems", "()Ljava/util/Map;", "setMReuseMenuItems", "(Ljava/util/Map;)V", "mReuseMenuItems", "", "L", "[I", "getMTempCoors", "()[I", "setMTempCoors", "([I)V", "mTempCoors", "M", "mIsNeedCompactEmailPop", "Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;", "N", "Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;", "getMSysMenuConfig", "()Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;", "setMSysMenuConfig", "(Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;)V", "mSysMenuConfig", "Landroid/view/Menu;", "O", "Landroid/view/Menu;", "getMTextMenu", "()Landroid/view/Menu;", "setMTextMenu", "(Landroid/view/Menu;)V", "mTextMenu", "P", "isIgnoreDettach", "setIgnoreDettach", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getLastHideScrollVisibilityFlag", "setLastHideScrollVisibilityFlag", "lastHideScrollVisibilityFlag", "Landroid/view/ActionMode$Callback;", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/ActionMode$Callback;", "mDisableCallback", ExifInterface.LATITUDE_SOUTH, "getMLastSelectStart", "setMLastSelectStart", "mLastSelectStart", "Ljava/lang/Runnable;", "T", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "showSelectViewTask", "U", "mIsPause", "", "V", "INSERTION_DELAY_TIME", "W", "getFLAG_USE_MAGNIFIER", "FLAG_USE_MAGNIFIER", "X", "Lcom/tencent/mm/ui/widget/edittext/MagnifierMotionAnimator;", "getMMagnifierAnimator", "()Lcom/tencent/mm/ui/widget/edittext/MagnifierMotionAnimator;", "setMMagnifierAnimator", "(Lcom/tencent/mm/ui/widget/edittext/MagnifierMotionAnimator;)V", "mMagnifierAnimator", "Y", "getInsertionHandleDelayDismissTask", "insertionHandleDelayDismissTask", "getUNSET_X_VALUE", "UNSET_X_VALUE", "", "a0", "getMCurrentDragInitialTouchRawX", "()F", "setMCurrentDragInitialTouchRawX", "(F)V", "mCurrentDragInitialTouchRawX", "b0", "getMTextViewScaleX", "setMTextViewScaleX", "mTextViewScaleX", "c0", "getMTextViewScaleY", "setMTextViewScaleY", "mTextViewScaleY", "getOperWindow", "operWindow", "getCurScrollY", "curScrollY", "<init>", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder;)V", "Companion", "Builder", "MenuItem", "OnMenuCallback", "OnSelectListener", "SelectionInfo", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class SelectableEditTextHelper {

    @NotNull
    public static final String TAG = "SelectableEditTextHelper";

    @NotNull
    public static final String TAG_PREF = "EditHelper.";
    public static final int VISIBILITY_FLAG_END_CURSOR_SHOW = 4;
    public static final int VISIBILITY_FLAG_INSERT_CURSOR_SHOW = 8;
    public static final int VISIBILITY_FLAG_OPER_SHOW = 1;
    public static final int VISIBILITY_FLAG_START_CURSOR_SHOW = 2;

    /* renamed from: A, reason: from kotlin metadata */
    public int mTextLineHeight;

    /* renamed from: B, reason: from kotlin metadata */
    public boolean mIsEnable;

    /* renamed from: C, reason: from kotlin metadata */
    public final boolean isHandleScrollInNewWay;

    /* renamed from: D, reason: from kotlin metadata */
    public final boolean isHandleScrollInOldWay;

    /* renamed from: E, reason: from kotlin metadata */
    public boolean mIsScrolling;

    /* renamed from: F, reason: from kotlin metadata */
    public boolean mIsInLongClick;

    /* renamed from: G, reason: from kotlin metadata */
    public int mTouchX;

    /* renamed from: H, reason: from kotlin metadata */
    public int mTouchY;

    /* renamed from: I, reason: from kotlin metadata */
    public int mTouchRawY;

    /* renamed from: J, reason: from kotlin metadata */
    public int mScrollY;

    /* renamed from: K, reason: from kotlin metadata */
    public Map mReuseMenuItems;

    /* renamed from: L, reason: from kotlin metadata */
    public int[] mTempCoors;

    /* renamed from: M, reason: from kotlin metadata */
    public boolean mIsNeedCompactEmailPop;

    /* renamed from: N, reason: from kotlin metadata */
    public SysMenuConfig mSysMenuConfig;

    /* renamed from: O, reason: from kotlin metadata */
    public Menu mTextMenu;

    /* renamed from: P, reason: from kotlin metadata */
    public boolean isIgnoreDettach;

    /* renamed from: Q, reason: from kotlin metadata */
    public int lastHideScrollVisibilityFlag;

    /* renamed from: R, reason: from kotlin metadata */
    public final ActionMode.Callback mDisableCallback;

    /* renamed from: S, reason: from kotlin metadata */
    public int mLastSelectStart;

    /* renamed from: T, reason: from kotlin metadata */
    public final Runnable showSelectViewTask;

    /* renamed from: U, reason: from kotlin metadata */
    public boolean mIsPause;

    /* renamed from: V, reason: from kotlin metadata */
    public final long INSERTION_DELAY_TIME;

    /* renamed from: W, reason: from kotlin metadata */
    public final boolean FLAG_USE_MAGNIFIER;

    /* renamed from: X, reason: from kotlin metadata */
    public MagnifierMotionAnimator mMagnifierAnimator;

    /* renamed from: Y, reason: from kotlin metadata */
    public final Runnable insertionHandleDelayDismissTask;

    /* renamed from: Z, reason: from kotlin metadata */
    public final int UNSET_X_VALUE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Builder mBuilder;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public float mCurrentDragInitialTouchRawX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CursorHandle mStartHandle;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public float mTextViewScaleX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public CursorHandle mEndHandle;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public float mTextViewScaleY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InsertHandle mInsertHandle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public OperateWindow mOperateWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public SelectionInfo mSelectionInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public OnSelectListener mSelectListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TextView mTextView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public Spannable mSpannable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public View.OnAttachStateChangeListener mOnAttachStateChangeListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public View.OnLayoutChangeListener mOnLayoutChangeListener;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public TextWatcher mTextWatcher;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public View.OnLongClickListener mOutOnLongClickListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public View.OnTouchListener mOutOnTouchListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public View.OnFocusChangeListener mOutOnFocusChangeListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public View.OnClickListener mOutOnClickListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public View.OnKeyListener mOutOnKeyListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public OnMenuCallback mOnMenuCallback;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final int mSelectedColor;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public int mCursorHandleColor;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public int mCursorHandleSize;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public boolean isHideWhenScroll;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public boolean isHide;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\u0018\u00002\u00020\u0001:\u0001PB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u00100\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010>\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010B\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\"\u0010F\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00102\u001a\u0004\bD\u00104\"\u0004\bE\u00106R$\u0010M\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder;", "", "", "cursorHandleColor", "setCursorHandleColor", "", "cursorHandleSizeInDp", "setCursorHandleSizeInDp", "selectedBgColor", "setSelectedColor", "", "isEnable", "enable", "", "lang", "setLanguage", "sysMenuConfig", "setSysMenuConfig", "isHandleScrollInNewWay", "handleScrollInNewWay", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "bounceView", "setBounceView", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "build", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getMTextView", "()Landroid/widget/TextView;", "mTextView", "b", "I", "getMCursorHandleColor", "()I", "setMCursorHandleColor", "(I)V", "mCursorHandleColor", "c", "getMSelectedColor", "setMSelectedColor", "mSelectedColor", "d", UserInfo.SEX_FEMALE, "getMCursorHandleSizeInDp", "()F", "setMCursorHandleSizeInDp", "(F)V", "mCursorHandleSizeInDp", "e", "Z", "getMIsEnable", "()Z", "setMIsEnable", "(Z)V", "mIsEnable", "f", "Ljava/lang/String;", "getMLanguage", "()Ljava/lang/String;", "setMLanguage", "(Ljava/lang/String;)V", "mLanguage", "g", "getMSysMenuConfig", "setMSysMenuConfig", "mSysMenuConfig", tl.h.F, "getMIsHandleScrollInNewWay", "setMIsHandleScrollInNewWay", "mIsHandleScrollInNewWay", "i", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "getMBounceView", "()Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "setMBounceView", "(Lcom/tencent/mm/ui/widget/pulldown/IBounceView;)V", "mBounceView", "<init>", "(Landroid/widget/TextView;)V", "AppendParamsCallback", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final TextView mTextView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int mCursorHandleColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int mSelectedColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public float mCursorHandleSizeInDp;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean mIsEnable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public String mLanguage;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public String mSysMenuConfig;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public boolean mIsHandleScrollInNewWay;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public IBounceView mBounceView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0005\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder$AppendParamsCallback;", "", "onAppend", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$Builder;", "builder", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes9.dex */
        public interface AppendParamsCallback {
            @NotNull
            Builder onAppend(@NotNull Builder builder);
        }

        public Builder(@NotNull TextView mTextView) {
            Intrinsics.checkNotNullParameter(mTextView, "mTextView");
            this.mTextView = mTextView;
            this.mCursorHandleColor = R.color.bgb;
            this.mSelectedColor = R.color.cpr;
            this.mCursorHandleSizeInDp = 18.0f;
            this.mIsEnable = true;
        }

        @NotNull
        public final SelectableEditTextHelper build() {
            return new SelectableEditTextHelper(this);
        }

        @NotNull
        public final Builder enable(boolean isEnable) {
            this.mIsEnable = isEnable;
            return this;
        }

        @Nullable
        public final IBounceView getMBounceView() {
            return this.mBounceView;
        }

        public final int getMCursorHandleColor() {
            return this.mCursorHandleColor;
        }

        public final float getMCursorHandleSizeInDp() {
            return this.mCursorHandleSizeInDp;
        }

        public final boolean getMIsEnable() {
            return this.mIsEnable;
        }

        public final boolean getMIsHandleScrollInNewWay() {
            return this.mIsHandleScrollInNewWay;
        }

        @Nullable
        public final String getMLanguage() {
            return this.mLanguage;
        }

        public final int getMSelectedColor() {
            return this.mSelectedColor;
        }

        @Nullable
        public final String getMSysMenuConfig() {
            return this.mSysMenuConfig;
        }

        @NotNull
        public final TextView getMTextView() {
            return this.mTextView;
        }

        @NotNull
        public final Builder handleScrollInNewWay(boolean isHandleScrollInNewWay) {
            this.mIsHandleScrollInNewWay = isHandleScrollInNewWay;
            return this;
        }

        @NotNull
        public final Builder setBounceView(@Nullable IBounceView bounceView) {
            this.mBounceView = bounceView;
            return this;
        }

        @NotNull
        public final Builder setCursorHandleColor(@ColorInt int cursorHandleColor) {
            this.mCursorHandleColor = cursorHandleColor;
            return this;
        }

        @NotNull
        public final Builder setCursorHandleSizeInDp(float cursorHandleSizeInDp) {
            this.mCursorHandleSizeInDp = cursorHandleSizeInDp;
            return this;
        }

        @NotNull
        public final Builder setLanguage(@Nullable String lang) {
            this.mLanguage = lang;
            return this;
        }

        public final void setMBounceView(@Nullable IBounceView iBounceView) {
            this.mBounceView = iBounceView;
        }

        public final void setMCursorHandleColor(int i3) {
            this.mCursorHandleColor = i3;
        }

        public final void setMCursorHandleSizeInDp(float f16) {
            this.mCursorHandleSizeInDp = f16;
        }

        public final void setMIsEnable(boolean z16) {
            this.mIsEnable = z16;
        }

        public final void setMIsHandleScrollInNewWay(boolean z16) {
            this.mIsHandleScrollInNewWay = z16;
        }

        public final void setMLanguage(@Nullable String str) {
            this.mLanguage = str;
        }

        public final void setMSelectedColor(int i3) {
            this.mSelectedColor = i3;
        }

        public final void setMSysMenuConfig(@Nullable String str) {
            this.mSysMenuConfig = str;
        }

        @NotNull
        public final Builder setSelectedColor(@ColorInt int selectedBgColor) {
            this.mSelectedColor = selectedBgColor;
            return this;
        }

        @NotNull
        public final Builder setSysMenuConfig(@Nullable String sysMenuConfig) {
            this.mSysMenuConfig = sysMenuConfig;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000f\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "", "onMenuInit", "", "items", "", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MenuItem;", "visibleFlag", "", "onMenuItemClicked", "v", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "curSelect", "", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnMenuCallback {
        void onMenuInit(@NotNull List<MenuItem> items, int visibleFlag);

        void onMenuItemClicked(@NotNull View v3, @NotNull MenuItem item, @NotNull String curSelect);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnSelectListener;", "", "onTextSelected", "", "content", "", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnSelectListener {
        void onTextSelected(@Nullable CharSequence content);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$SelectionInfo;", "", "", "a", "I", "getMStart", "()I", "setMStart", "(I)V", "mStart", "b", "getMEnd", "setMEnd", "mEnd", "", "mSelectionContent", "Ljava/lang/String;", "<init>", "()V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class SelectionInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int mStart;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int mEnd;

        @JvmField
        @Nullable
        public String mSelectionContent;

        public final int getMEnd() {
            return this.mEnd;
        }

        public final int getMStart() {
            return this.mStart;
        }

        public final void setMEnd(int i3) {
            this.mEnd = i3;
        }

        public final void setMStart(int i3) {
            this.mStart = i3;
        }
    }

    public SelectableEditTextHelper(@NotNull Builder mBuilder) {
        boolean z16;
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        this.mBuilder = mBuilder;
        this.mSelectionInfo = new SelectionInfo();
        this.isHide = true;
        boolean mIsHandleScrollInNewWay = mBuilder.getMIsHandleScrollInNewWay();
        this.isHandleScrollInNewWay = mIsHandleScrollInNewWay;
        this.isHandleScrollInOldWay = !mIsHandleScrollInNewWay;
        this.mReuseMenuItems = new HashMap();
        this.mTempCoors = new int[2];
        this.mDisableCallback = new ActionMode.Callback() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$mDisableCallback$1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(item, "item");
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                n.a(SelectableEditTextHelper.TAG, "mDisableCallback", new Object[0]);
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(@NotNull ActionMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                return false;
            }
        };
        this.mLastSelectStart = -1;
        this.showSelectViewTask = new Runnable() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$showSelectViewTask$1
            @Override // java.lang.Runnable
            public final void run() {
                SelectableEditTextHelper selectableEditTextHelper = SelectableEditTextHelper.this;
                selectableEditTextHelper.showWindows(selectableEditTextHelper.getLastHideScrollVisibilityFlag());
                SelectableEditTextHelper.this.setLastHideScrollVisibilityFlag(0);
                SelectableEditTextHelper.this.isHideWhenScroll = false;
            }
        };
        TextView mTextView = mBuilder.getMTextView();
        this.mTextView = mTextView;
        Context context = mTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mTextView.context");
        this.mContext = context;
        this.mSelectedColor = context.getResources().getColor(mBuilder.getMSelectedColor());
        this.mCursorHandleColor = this.mContext.getResources().getColor(mBuilder.getMCursorHandleColor());
        this.mCursorHandleSize = o.a(this.mContext, (int) mBuilder.getMCursorHandleSizeInDp());
        this.mTextLineHeight = TextLayoutUtil.getLineHeight(this.mTextView);
        this.mIsEnable = mBuilder.getMIsEnable();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29 && (r.c() || r.a())) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsNeedCompactEmailPop = z16;
        this.mSysMenuConfig = SysMenuConfig.INSTANCE.parse(mBuilder.getMSysMenuConfig());
        n.c(TAG, "init %s,%s,%s", Boolean.valueOf(this.mIsEnable), mBuilder.getMLanguage(), Build.BRAND);
        d();
        this.INSERTION_DELAY_TIME = 4000L;
        this.FLAG_USE_MAGNIFIER = i3 >= 28;
        this.insertionHandleDelayDismissTask = new Runnable() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$insertionHandleDelayDismissTask$1
            @Override // java.lang.Runnable
            public final void run() {
                SelectableEditTextHelper.this.b();
            }
        };
        this.UNSET_X_VALUE = -1;
        this.mCurrentDragInitialTouchRawX = -1;
    }

    public static /* synthetic */ boolean isCurHasWindowShow$default(SelectableEditTextHelper selectableEditTextHelper, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = selectableEditTextHelper.getCurVisibilityFlag();
            }
            return selectableEditTextHelper.isCurHasWindowShow(i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isCurHasWindowShow");
    }

    public final void a() {
        String BRAND = Build.BRAND;
        if (TextUtils.isEmpty(BRAND)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String lowerCase = BRAND.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        Intrinsics.areEqual(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, lowerCase);
    }

    public final void b() {
        InsertHandle insertHandle = this.mInsertHandle;
        if (insertHandle != null) {
            insertHandle.dismiss();
        }
    }

    /* renamed from: c, reason: from getter */
    public Runnable getShowSelectViewTask() {
        return this.showSelectViewTask;
    }

    public void closeSelectAndTools() {
        resetSelectionInfo();
        if (!this.isHide) {
            Selection.setSelection(this.mTextView.getEditableText(), this.mTextView.getSelectionEnd());
        }
        hideSelectView();
        this.mTextView.setCursorVisible(true);
    }

    public final void d() {
        IBounceView mBounceView;
        this.mTextView.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$1
            /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
            
                if (r5 == 1) goto L13;
             */
            @Override // android.view.View.OnKeyListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                View.OnKeyListener onKeyListener;
                boolean z16;
                boolean z17;
                n.a(SelectableEditTextHelper.TAG, "init() called with: view = " + view + ", i = " + i3 + ", keyEvent = " + keyEvent, new Object[0]);
                onKeyListener = SelectableEditTextHelper.this.mOutOnKeyListener;
                if (onKeyListener != null) {
                    z16 = onKeyListener.onKey(view, i3, keyEvent);
                } else {
                    z16 = false;
                }
                if (SelectableEditTextHelper.this.getMIsEnable()) {
                    if (keyEvent != null) {
                        int action = keyEvent.getAction();
                        z17 = true;
                    }
                    z17 = false;
                    if (!z17) {
                        return false;
                    }
                    switch (i3) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            SelectableEditTextHelper.this.closeSelectAndTools();
                            return false;
                        default:
                            return false;
                    }
                }
                return z16;
            }
        });
        TextView textView = this.mTextView;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        CharSequence text = this.mTextView.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
        this.mSpannable = (Spannable) text;
        this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                View.OnLongClickListener onLongClickListener;
                boolean z16;
                boolean z17;
                boolean z18;
                int i3;
                int i16;
                onLongClickListener = SelectableEditTextHelper.this.mOutOnLongClickListener;
                if (onLongClickListener != null) {
                    z16 = onLongClickListener.onLongClick(view);
                } else {
                    z16 = false;
                }
                if (SelectableEditTextHelper.this.getMIsEnable()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onLongClick:");
                    z17 = SelectableEditTextHelper.this.mIsScrolling;
                    sb5.append(z17);
                    n.c(SelectableEditTextHelper.TAG, sb5.toString(), new Object[0]);
                    SelectableEditTextHelper.this.a();
                    z18 = SelectableEditTextHelper.this.mIsScrolling;
                    if (!z18) {
                        SelectableEditTextHelper.this.mIsInLongClick = true;
                        SelectableEditTextHelper selectableEditTextHelper = SelectableEditTextHelper.this;
                        i3 = selectableEditTextHelper.mTouchX;
                        i16 = SelectableEditTextHelper.this.mTouchY;
                        selectableEditTextHelper.a(i3, i16);
                        return true;
                    }
                    return false;
                }
                return z16;
            }
        });
        this.mTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                View.OnTouchListener onTouchListener;
                boolean z16;
                boolean z17;
                boolean z18;
                boolean z19;
                int i3;
                boolean z26;
                boolean z27;
                onTouchListener = SelectableEditTextHelper.this.mOutOnTouchListener;
                if (onTouchListener != null) {
                    z16 = onTouchListener.onTouch(view, motionEvent);
                } else {
                    z16 = false;
                }
                if (SelectableEditTextHelper.this.getMIsEnable()) {
                    SelectableEditTextHelper.this.mTouchX = (int) motionEvent.getX();
                    SelectableEditTextHelper.this.mTouchY = (int) motionEvent.getY();
                    SelectableEditTextHelper.this.mTouchRawY = (int) motionEvent.getRawY();
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        SelectableEditTextHelper.this.mIsInLongClick = false;
                        z17 = SelectableEditTextHelper.this.mIsNeedCompactEmailPop;
                        if (z17) {
                            ReflectUtilJava.getEmailPopupWindow(SelectableEditTextHelper.this.getMTextView());
                            SelectableEditTextHelper.this.mIsNeedCompactEmailPop = false;
                        }
                        ReflectUtil.INSTANCE.setSysInsertionEnabled(SelectableEditTextHelper.this.getMTextView(), false);
                    } else if (action == 1) {
                        z18 = SelectableEditTextHelper.this.mIsScrolling;
                        if (z18) {
                            SelectableEditTextHelper.this.mIsScrolling = false;
                            if (SelectableEditTextHelper.this.getIsHandleScrollInOldWay()) {
                                z19 = SelectableEditTextHelper.this.isHideWhenScroll;
                                if (z19) {
                                    SelectableEditTextHelper.this.isHideWhenScroll = false;
                                    SelectableEditTextHelper selectableEditTextHelper = SelectableEditTextHelper.this;
                                    selectableEditTextHelper.showWindows(selectableEditTextHelper.getLastHideScrollVisibilityFlag());
                                    SelectableEditTextHelper.this.setLastHideScrollVisibilityFlag(0);
                                }
                            }
                            return true;
                        }
                    } else if (action == 2) {
                        if (r.c()) {
                            z27 = SelectableEditTextHelper.this.mIsInLongClick;
                            if (z27) {
                                return true;
                            }
                        }
                        i3 = SelectableEditTextHelper.this.mScrollY;
                        if (i3 != SelectableEditTextHelper.this.getMTextView().getScrollY()) {
                            SelectableEditTextHelper.this.mIsScrolling = true;
                            int curVisibilityFlag = SelectableEditTextHelper.this.getCurVisibilityFlag();
                            if (SelectableEditTextHelper.this.getIsHandleScrollInOldWay()) {
                                z26 = SelectableEditTextHelper.this.isHideWhenScroll;
                                if (!z26 && SelectableEditTextHelper.this.isCurHasWindowShow(curVisibilityFlag)) {
                                    SelectableEditTextHelper.this.setLastHideScrollVisibilityFlag(curVisibilityFlag);
                                    SelectableEditTextHelper.this.isHideWhenScroll = true;
                                    SelectableEditTextHelper selectableEditTextHelper2 = SelectableEditTextHelper.this;
                                    selectableEditTextHelper2.dismissOperWindow(selectableEditTextHelper2.getOperWindow());
                                    SelectableEditTextHelper selectableEditTextHelper3 = SelectableEditTextHelper.this;
                                    selectableEditTextHelper3.a(selectableEditTextHelper3.getMStartHandle());
                                    SelectableEditTextHelper selectableEditTextHelper4 = SelectableEditTextHelper.this;
                                    selectableEditTextHelper4.a(selectableEditTextHelper4.getMEndHandle());
                                    SelectableEditTextHelper.this.b();
                                }
                            }
                        }
                    }
                    SelectableEditTextHelper selectableEditTextHelper5 = SelectableEditTextHelper.this;
                    selectableEditTextHelper5.mScrollY = selectableEditTextHelper5.getMTextView().getScrollY();
                    return false;
                }
                return z16;
            }
        });
        this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                View.OnClickListener onClickListener;
                if (SelectableEditTextHelper.this.getMIsEnable()) {
                    n.c(SelectableEditTextHelper.TAG, NodeProps.ON_CLICK, new Object[0]);
                    SelectableEditTextHelper.this.handleClickOrFocus(true);
                }
                onClickListener = SelectableEditTextHelper.this.mOutOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        this.mTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                View.OnFocusChangeListener onFocusChangeListener;
                if (SelectableEditTextHelper.this.getMIsEnable()) {
                    n.a(SelectableEditTextHelper.TAG, "onFocusChange:" + z16, new Object[0]);
                    if (!z16) {
                        SelectableEditTextHelper.this.handleClickOrFocus(false);
                    }
                }
                onFocusChangeListener = SelectableEditTextHelper.this.mOutOnFocusChangeListener;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, z16);
                }
            }
        });
        if (!this.mIsEnable) {
            return;
        }
        this.mTextView.setCustomSelectionActionModeCallback(this.mDisableCallback);
        this.mTextView.setCustomInsertionActionModeCallback(this.mDisableCallback);
        this.mTextWatcher = new TextWatcher() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$6
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s16) {
                Spannable spannable;
                Intrinsics.checkNotNullParameter(s16, "s");
                SelectableEditTextHelper selectableEditTextHelper = SelectableEditTextHelper.this;
                CharSequence text2 = selectableEditTextHelper.getMTextView().getText();
                if (text2 instanceof Spannable) {
                    spannable = (Spannable) text2;
                } else {
                    spannable = null;
                }
                selectableEditTextHelper.mSpannable = spannable;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(s16, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s16, "s");
                if (!SelectableEditTextHelper.this.getIsHide()) {
                    SelectableEditTextHelper.this.resetSelectionInfo();
                    SelectableEditTextHelper.this.hideSelectView();
                }
                SelectableEditTextHelper.this.b();
                SelectableEditTextHelper.this.getMTextView().setCursorVisible(true);
                SelectableEditTextHelper selectableEditTextHelper = SelectableEditTextHelper.this;
                selectableEditTextHelper.setMLastSelectStart(selectableEditTextHelper.getMTextView().getSelectionStart());
            }
        };
        this.mOnAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$7
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View v3) {
                Intrinsics.checkNotNullParameter(v3, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View v3) {
                Intrinsics.checkNotNullParameter(v3, "v");
                n.a(SelectableEditTextHelper.TAG, "onViewDetachedFromWindow:" + SelectableEditTextHelper.this.getIsIgnoreDettach(), new Object[0]);
                if (SelectableEditTextHelper.this.getIsIgnoreDettach()) {
                    return;
                }
                SelectableEditTextHelper.this.destroy();
            }
        };
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$8
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                if (!SelectableEditTextHelper.isCurHasWindowShow$default(SelectableEditTextHelper.this, 0, 1, null)) {
                    return;
                }
                int[] iArr = {SelectableEditTextHelper.this.getMTempCoors()[0], SelectableEditTextHelper.this.getMTempCoors()[1]};
                SelectableEditTextHelper.this.getMTextView().getLocationInWindow(SelectableEditTextHelper.this.getMTempCoors());
                n.a(SelectableEditTextHelper.TAG, "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(iArr[0]), Integer.valueOf(SelectableEditTextHelper.this.getMTempCoors()[0]), Integer.valueOf(iArr[1]), Integer.valueOf(SelectableEditTextHelper.this.getMTempCoors()[1]));
                if (i16 != i26 || i18 != i28 || iArr[1] != SelectableEditTextHelper.this.getMTempCoors()[1]) {
                    SelectableEditTextHelper.this.closeSelectAndTools();
                }
            }
        };
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$9
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean z16;
                if (SelectableEditTextHelper.this.getIsHandleScrollInNewWay()) {
                    z16 = SelectableEditTextHelper.this.isHideWhenScroll;
                    if (z16) {
                        SelectableEditTextHelper.this.a(100);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$10
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                SelectableEditTextHelper.this.handleNewWayScrollChanged();
            }
        };
        if (this.isHandleScrollInNewWay && (mBounceView = this.mBuilder.getMBounceView()) != null) {
            mBounceView.addBounceOffsetChangedListener(new IBounceView.BounceOffsetChangedListener() { // from class: com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper$init$11
                @Override // com.tencent.mm.ui.widget.pulldown.IBounceView.BounceOffsetChangedListener
                public void onBounceOffsetChanged(int offset) {
                    SelectableEditTextHelper.this.handleNewWayScrollChanged();
                }

                @Override // com.tencent.mm.ui.widget.pulldown.IBounceView.BounceOffsetChangedListener
                public void onBounceStart(int direction) {
                }
            });
        }
        this.mTextView.addTextChangedListener(this.mTextWatcher);
        this.mTextView.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        this.mTextView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mTextView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        this.mTextView.getViewTreeObserver().addOnScrollChangedListener(this.mOnScrollChangedListener);
    }

    public final void destroy() {
        this.mTextView.removeTextChangedListener(this.mTextWatcher);
        this.mTextView.removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        this.mTextView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mTextView.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mTextView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        resetSelectionInfo();
        hideSelectView();
        this.mStartHandle = null;
        this.mEndHandle = null;
        this.mOperateWindow = null;
    }

    public final void dismissInsertionDelay() {
        this.mTextView.postDelayed(this.insertionHandleDelayDismissTask, this.INSERTION_DELAY_TIME);
    }

    public void dismissOperWindow(@Nullable OperateWindow operateWindow) {
        if (operateWindow != null) {
            operateWindow.dismiss();
        }
    }

    public final int getCurScrollY() {
        return this.mTextView.getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final int getCurVisibilityFlag() {
        boolean isShow = OperateWindow.INSTANCE.isShow(this.mOperateWindow);
        CursorHandle.Companion companion = CursorHandle.INSTANCE;
        boolean z16 = isShow;
        if (companion.isShow(this.mStartHandle)) {
            z16 = (isShow ? 1 : 0) | 2;
        }
        ?? r06 = z16;
        if (companion.isShow(this.mEndHandle)) {
            r06 = (z16 ? 1 : 0) | 4;
        }
        if (InsertHandle.INSTANCE.isShow(this.mInsertHandle)) {
            return r06 | 8;
        }
        return r06;
    }

    @Nullable
    public final CursorHandle getCursorHandle(boolean isLeft) {
        boolean z16;
        CursorHandle cursorHandle = this.mStartHandle;
        if (cursorHandle != null && cursorHandle.getIsLeft() == isLeft) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.mStartHandle;
        }
        return this.mEndHandle;
    }

    public final boolean getFLAG_USE_MAGNIFIER() {
        return this.FLAG_USE_MAGNIFIER;
    }

    @NotNull
    public final Runnable getInsertionHandleDelayDismissTask() {
        return this.insertionHandleDelayDismissTask;
    }

    public final int getLastHideScrollVisibilityFlag() {
        return this.lastHideScrollVisibilityFlag;
    }

    /* renamed from: getLastTouchRawY, reason: from getter */
    public final int getMTouchRawY() {
        return this.mTouchRawY;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final float getMCurrentDragInitialTouchRawX() {
        return this.mCurrentDragInitialTouchRawX;
    }

    public final int getMCursorHandleColor() {
        return this.mCursorHandleColor;
    }

    public final int getMCursorHandleSize() {
        return this.mCursorHandleSize;
    }

    @Nullable
    public final CursorHandle getMEndHandle() {
        return this.mEndHandle;
    }

    @Nullable
    public final InsertHandle getMInsertHandle() {
        return this.mInsertHandle;
    }

    public final boolean getMIsEnable() {
        return this.mIsEnable;
    }

    public final int getMLastSelectStart() {
        return this.mLastSelectStart;
    }

    @Nullable
    public final MagnifierMotionAnimator getMMagnifierAnimator() {
        return this.mMagnifierAnimator;
    }

    @Nullable
    public final OnMenuCallback getMOnMenuCallback() {
        return this.mOnMenuCallback;
    }

    @Nullable
    public final OperateWindow getMOperateWindow() {
        return this.mOperateWindow;
    }

    @NotNull
    public final Map<Integer, CharSequence> getMReuseMenuItems() {
        return this.mReuseMenuItems;
    }

    @Nullable
    public final OnSelectListener getMSelectListener() {
        return this.mSelectListener;
    }

    @NotNull
    public final SelectionInfo getMSelectionInfo() {
        return this.mSelectionInfo;
    }

    @Nullable
    public final CursorHandle getMStartHandle() {
        return this.mStartHandle;
    }

    @NotNull
    public final SysMenuConfig getMSysMenuConfig() {
        return this.mSysMenuConfig;
    }

    @NotNull
    public final int[] getMTempCoors() {
        return this.mTempCoors;
    }

    public final int getMTextLineHeight() {
        return this.mTextLineHeight;
    }

    @Nullable
    public final Menu getMTextMenu() {
        return this.mTextMenu;
    }

    @NotNull
    public final TextView getMTextView() {
        return this.mTextView;
    }

    public final float getMTextViewScaleX() {
        return this.mTextViewScaleX;
    }

    public final float getMTextViewScaleY() {
        return this.mTextViewScaleY;
    }

    @RequiresApi(28)
    @Nullable
    public final MagnifierMotionAnimator getMagnifierAnimator() {
        if (this.FLAG_USE_MAGNIFIER && this.mMagnifierAnimator == null) {
            this.mMagnifierAnimator = new MagnifierMotionAnimator(new Magnifier(this.mTextView));
        }
        return this.mMagnifierAnimator;
    }

    @NotNull
    public final OperateWindow getOperWindow() {
        OperateWindow operateWindow = this.mOperateWindow;
        if (operateWindow == null) {
            OperateWindow operateWindow2 = new OperateWindow(this, this.mContext);
            this.mOperateWindow = operateWindow2;
            return operateWindow2;
        }
        return operateWindow;
    }

    public final int getUNSET_X_VALUE() {
        return this.UNSET_X_VALUE;
    }

    public final void handleClickOrFocus(boolean hasFocus) {
        if (isHorizontalOrientation()) {
            closeSelectAndTools();
            return;
        }
        if (this.mIsPause) {
            return;
        }
        if (!hasFocus) {
            closeSelectAndTools();
            return;
        }
        if (this.mInsertHandle == null) {
            this.mInsertHandle = new InsertHandle(this, this.mContext);
        }
        CursorHandle cursorHandle = this.mStartHandle;
        if (cursorHandle != null) {
            cursorHandle.dismiss();
        }
        CursorHandle cursorHandle2 = this.mEndHandle;
        if (cursorHandle2 != null) {
            cursorHandle2.dismiss();
        }
        int selectionStart = this.mTextView.getSelectionStart();
        if (this.isHide) {
            if (this.mLastSelectStart != selectionStart) {
                closeSelectAndTools();
            } else {
                a(this.mTouchX, this.mTouchY, false);
                this.mLastSelectStart = selectionStart;
            }
        } else {
            closeSelectAndTools();
        }
        this.mTextView.setCursorVisible(true);
        this.mLastSelectStart = selectionStart;
        a(this.mInsertHandle);
    }

    public final void handleNewWayScrollChanged() {
        if (!this.isHandleScrollInNewWay) {
            return;
        }
        int curVisibilityFlag = getCurVisibilityFlag();
        if (!this.isHideWhenScroll && isCurHasWindowShow(curVisibilityFlag) && !hasHandleInMoving()) {
            this.lastHideScrollVisibilityFlag = curVisibilityFlag;
            this.isHideWhenScroll = true;
            dismissOperWindow(getOperWindow());
            a(this.mStartHandle);
            a(this.mEndHandle);
            b();
        }
    }

    public final boolean hasHandleInMoving() {
        boolean z16;
        boolean z17;
        boolean z18;
        InsertHandle insertHandle = this.mInsertHandle;
        if (insertHandle != null && insertHandle.getIsMoving()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            CursorHandle cursorHandle = this.mStartHandle;
            if (cursorHandle != null && cursorHandle.getIsMoving()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                CursorHandle cursorHandle2 = this.mEndHandle;
                if (cursorHandle2 != null && cursorHandle2.getIsMoving()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    return false;
                }
            }
        }
        return true;
    }

    public void hideSelectView() {
        this.isHide = true;
        a(this.mStartHandle);
        a(this.mEndHandle);
        dismissOperWindow(this.mOperateWindow);
        b();
    }

    public final boolean isCurHasWindowShow(int flag) {
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isHandleScrollInNewWay, reason: from getter */
    public final boolean getIsHandleScrollInNewWay() {
        return this.isHandleScrollInNewWay;
    }

    /* renamed from: isHandleScrollInOldWay, reason: from getter */
    public final boolean getIsHandleScrollInOldWay() {
        return this.isHandleScrollInOldWay;
    }

    /* renamed from: isHide, reason: from getter */
    public final boolean getIsHide() {
        return this.isHide;
    }

    public final boolean isHorizontalOrientation() {
        if (this.mContext.getResources().getConfiguration().orientation != 1) {
            return true;
        }
        return false;
    }

    /* renamed from: isIgnoreDettach, reason: from getter */
    public final boolean getIsIgnoreDettach() {
        return this.isIgnoreDettach;
    }

    public final void pause() {
        this.mIsPause = true;
        closeSelectAndTools();
    }

    public void resetSelectionInfo() {
        this.mSelectionInfo.mSelectionContent = null;
    }

    public final void resume() {
        closeSelectAndTools();
        this.mIsPause = false;
    }

    public void selectText(int startPos, int endPos) {
        Log.d(TAG, "selectText() called with: startPos = " + startPos + ", endPos = " + endPos);
        if (startPos != -1) {
            this.mSelectionInfo.setMStart(startPos);
        }
        if (endPos != -1) {
            this.mSelectionInfo.setMEnd(endPos);
        }
        if (this.mSelectionInfo.getMStart() > this.mSelectionInfo.getMEnd()) {
            int mStart = this.mSelectionInfo.getMStart();
            SelectionInfo selectionInfo = this.mSelectionInfo;
            selectionInfo.setMStart(selectionInfo.getMEnd());
            this.mSelectionInfo.setMEnd(mStart);
        }
        Spannable spannable = this.mSpannable;
        if (spannable != null) {
            try {
                int length = this.mTextView.getText().length();
                if (this.mSelectionInfo.getMStart() <= length && this.mSelectionInfo.getMEnd() <= length) {
                    SelectionInfo selectionInfo2 = this.mSelectionInfo;
                    selectionInfo2.mSelectionContent = spannable.subSequence(selectionInfo2.getMStart(), this.mSelectionInfo.getMEnd()).toString();
                    this.mTextView.setHighlightColor(this.mSelectedColor);
                    Selection.setSelection(spannable, this.mSelectionInfo.getMStart(), this.mSelectionInfo.getMEnd());
                    OnSelectListener onSelectListener = this.mSelectListener;
                    if (onSelectListener != null) {
                        onSelectListener.onTextSelected(this.mSelectionInfo.mSelectionContent);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (Throwable th5) {
                n.a(TAG, th5, "select err", new Object[0]);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void setHide(boolean z16) {
        this.isHide = z16;
    }

    public final void setIgnoreDettach(boolean z16) {
        this.isIgnoreDettach = z16;
    }

    public final void setLastHideScrollVisibilityFlag(int i3) {
        this.lastHideScrollVisibilityFlag = i3;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMCurrentDragInitialTouchRawX(float f16) {
        this.mCurrentDragInitialTouchRawX = f16;
    }

    public final void setMCursorHandleColor(int i3) {
        this.mCursorHandleColor = i3;
    }

    public final void setMCursorHandleSize(int i3) {
        this.mCursorHandleSize = i3;
    }

    public final void setMEndHandle(@Nullable CursorHandle cursorHandle) {
        this.mEndHandle = cursorHandle;
    }

    public final void setMInsertHandle(@Nullable InsertHandle insertHandle) {
        this.mInsertHandle = insertHandle;
    }

    public final void setMIsEnable(boolean z16) {
        this.mIsEnable = z16;
    }

    public final void setMLastSelectStart(int i3) {
        this.mLastSelectStart = i3;
    }

    public final void setMMagnifierAnimator(@Nullable MagnifierMotionAnimator magnifierMotionAnimator) {
        this.mMagnifierAnimator = magnifierMotionAnimator;
    }

    public final void setMOnMenuCallback(@Nullable OnMenuCallback onMenuCallback) {
        this.mOnMenuCallback = onMenuCallback;
    }

    public final void setMOperateWindow(@Nullable OperateWindow operateWindow) {
        this.mOperateWindow = operateWindow;
    }

    public final void setMReuseMenuItems(@NotNull Map<Integer, CharSequence> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mReuseMenuItems = map;
    }

    public final void setMSelectListener(@Nullable OnSelectListener onSelectListener) {
        this.mSelectListener = onSelectListener;
    }

    public final void setMSelectionInfo(@NotNull SelectionInfo selectionInfo) {
        Intrinsics.checkNotNullParameter(selectionInfo, "<set-?>");
        this.mSelectionInfo = selectionInfo;
    }

    public final void setMStartHandle(@Nullable CursorHandle cursorHandle) {
        this.mStartHandle = cursorHandle;
    }

    public final void setMSysMenuConfig(@NotNull SysMenuConfig sysMenuConfig) {
        Intrinsics.checkNotNullParameter(sysMenuConfig, "<set-?>");
        this.mSysMenuConfig = sysMenuConfig;
    }

    public final void setMTempCoors(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.mTempCoors = iArr;
    }

    public final void setMTextLineHeight(int i3) {
        this.mTextLineHeight = i3;
    }

    public final void setMTextMenu(@Nullable Menu menu) {
        this.mTextMenu = menu;
    }

    public final void setMTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTextView = textView;
    }

    public final void setMTextViewScaleX(float f16) {
        this.mTextViewScaleX = f16;
    }

    public final void setMTextViewScaleY(float f16) {
        this.mTextViewScaleY = f16;
    }

    public final void setMenuCallback(@Nullable OnMenuCallback callback) {
        this.mOnMenuCallback = callback;
    }

    public final void setOutOnClickListener(@Nullable View.OnClickListener mOutOnClickListener) {
        this.mOutOnClickListener = mOutOnClickListener;
    }

    public final void setOutOnFocusChangeListener(@Nullable View.OnFocusChangeListener mOutOnFocusChangeListener) {
        this.mOutOnFocusChangeListener = mOutOnFocusChangeListener;
    }

    public final void setOutOnKeyListener(@NotNull View.OnKeyListener mOutOnKeyListener) {
        Intrinsics.checkNotNullParameter(mOutOnKeyListener, "mOutOnKeyListener");
        this.mOutOnKeyListener = mOutOnKeyListener;
    }

    public final void setOutOnLongClickListener(@Nullable View.OnLongClickListener mOutOnLongClickListener) {
        this.mOutOnLongClickListener = mOutOnLongClickListener;
    }

    public final void setOutOnTouchListener(@Nullable View.OnTouchListener mOutOnTouchListener) {
        this.mOutOnTouchListener = mOutOnTouchListener;
    }

    public final void setSelectListener(@Nullable OnSelectListener selectListener) {
        this.mSelectListener = selectListener;
    }

    public void showCursorHandle(@Nullable CursorHandle cursorHandle) {
        int mEnd;
        if (cursorHandle == null) {
            return;
        }
        try {
            Layout layout = this.mTextView.getLayout();
            if (cursorHandle.getIsLeft()) {
                mEnd = this.mSelectionInfo.getMStart();
            } else {
                mEnd = this.mSelectionInfo.getMEnd();
            }
            cursorHandle.show((int) layout.getPrimaryHorizontal(mEnd), layout.getLineBottom(layout.getLineForOffset(mEnd)));
        } catch (Throwable th5) {
            n.b(TAG, "show cursor err\uff1a%s", Log.getStackTraceString(th5));
        }
    }

    public void showOperWindow(@Nullable OperateWindow operateWindow) {
        if (operateWindow != null) {
            try {
                operateWindow.show();
            } catch (Throwable th5) {
                n.b(TAG, "show oper err\uff1a%s", Log.getStackTraceString(th5));
            }
        }
    }

    public final void showWindows(int showFlag) {
        if ((showFlag & 1) > 0) {
            showOperWindow(getOperWindow());
        }
        if ((showFlag & 2) > 0) {
            showCursorHandle(this.mStartHandle);
        }
        if ((showFlag & 4) > 0) {
            showCursorHandle(this.mEndHandle);
        }
        if ((showFlag & 8) > 0) {
            a(this.mInsertHandle);
        }
    }

    public final void a(int duration) {
        this.mTextView.removeCallbacks(getShowSelectViewTask());
        if (duration <= 0) {
            getShowSelectViewTask().run();
        } else {
            this.mTextView.postDelayed(getShowSelectViewTask(), duration);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MenuItem;", "", "name", "", "id", "", "visibleFlag", "(Ljava/lang/String;II)V", "(Ljava/lang/String;I)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class MenuItem {
        public static final int ID_MENU_ITEM_COPY = 16908321;
        public static final int ID_MENU_ITEM_CUT = 16908320;
        public static final int ID_MENU_ITEM_FULL_SCREEN_EDT = 7;
        public static final int ID_MENU_ITEM_PASTE = 16908322;
        public static final int ID_MENU_ITEM_SEARCH = 3;
        public static final int ID_MENU_ITEM_SELECT = 1;
        public static final int ID_MENU_ITEM_SELLECT_ALL = 16908319;
        public static final int ID_MENU_ITEM_TAG = 2;
        public static final int ID_MENU_ITEM_TRANSLATE_DISABLE = 5;
        public static final int ID_MENU_ITEM_TRANSLATE_ENABLE = 4;
        public static final int ID_MENU_ITEM_WRAP = 6;
        public static final int VISIBLE_DEFAULT = 15;
        public static final int VISIBLE_WHEN_CLICK_IN_CONTENT = 4;
        public static final int VISIBLE_WHEN_CLICK_IN_NULL_CONTENT = 2;
        public static final int VISIBLE_WHEN_SELECT_ALL = 1;
        public static final int VISIBLE_WHEN_SELECT_PART = 8;

        @JvmField
        public int id;

        @JvmField
        @NotNull
        public String name;

        @JvmField
        public int visibleFlag;

        public MenuItem(@NotNull String name, int i3, int i16) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.id = i3;
            this.visibleFlag = i16;
        }

        public MenuItem(@NotNull String name, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.id = i3;
            this.visibleFlag = 15;
        }
    }

    public final void a(int x16, int y16) {
        a(x16, y16, true);
    }

    public void a(int x16, int y16, boolean isSelect) {
        int i3;
        if (this.mTextView.getLayout() == null || this.mTextView.getWidth() == 0) {
            return;
        }
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(this, true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(this, false);
        }
        int offsetForPosition = this.mTextView.getOffsetForPosition(x16, y16);
        if (!isSelect) {
            offsetForPosition = this.mTextView.getSelectionStart();
        }
        try {
            i3 = this.mTextView.getLayout().getOffsetToRightOf(offsetForPosition);
        } catch (Throwable unused) {
            i3 = offsetForPosition + 1;
        }
        if (this.mTextView.getText() instanceof Spannable) {
            CharSequence text = this.mTextView.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
            this.mSpannable = (Spannable) text;
        }
        if (this.mSpannable == null) {
            return;
        }
        boolean z16 = offsetForPosition < this.mTextView.getText().length() && isSelect;
        if (z16) {
            this.mTextView.setCursorVisible(false);
        } else {
            i3 = offsetForPosition;
        }
        if (!this.isHide && this.mSelectionInfo.getMStart() == offsetForPosition && this.mSelectionInfo.getMEnd() == i3) {
            return;
        }
        hideSelectView();
        resetSelectionInfo();
        this.isHide = false;
        selectText(offsetForPosition, i3);
        if (z16) {
            showCursorHandle(this.mStartHandle);
            showCursorHandle(this.mEndHandle);
            b();
        }
        showOperWindow(getOperWindow());
    }

    public void a(CursorHandle cursorHandle) {
        if (cursorHandle != null) {
            cursorHandle.dismiss();
        }
    }

    public final void a(InsertHandle insertHandle) {
        try {
            int selectionStart = this.mTextView.getSelectionStart();
            Layout layout = this.mTextView.getLayout();
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(selectionStart);
            int lineBottom = layout.getLineBottom(layout.getLineForOffset(selectionStart));
            if (insertHandle != null) {
                insertHandle.show(primaryHorizontal, lineBottom);
            }
            this.mTextView.removeCallbacks(this.insertionHandleDelayDismissTask);
            dismissInsertionDelay();
        } catch (Throwable th5) {
            n.a(TAG, th5, "showInsertionHandle err", new Object[0]);
        }
    }
}
