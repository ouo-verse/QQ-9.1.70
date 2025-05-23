package com.tencent.kuikly.core.render.android.expand.component.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.css.gesture.KRCSSGestureListener;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import d01.w;
import i01.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002\u0082\u0002B\u0015\b\u0016\u0012\b\u0010\u00fc\u0001\u001a\u00030\u00fb\u0001\u00a2\u0006\u0006\b\u00fd\u0001\u0010\u00fe\u0001B!\b\u0016\u0012\b\u0010\u00fc\u0001\u001a\u00030\u00fb\u0001\u0012\n\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u00ff\u0001\u00a2\u0006\u0006\b\u00fd\u0001\u0010\u0081\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'H\u0002J(\u0010.\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J \u00101\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0005H\u0002J(\u00103\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J0\u00104\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*2\u0006\u0010 \u001a\u00020*2\u0006\u0010!\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0012\u00106\u001a\u00020\u00142\b\u00105\u001a\u0004\u0018\u00010%H\u0002J8\u0010:\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u00020\u0014H\u0002J\b\u0010=\u001a\u00020\u0014H\u0002J(\u0010@\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0005H\u0002J(\u0010C\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0005H\u0002J \u0010D\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0005H\u0002J\u0012\u0010F\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010G\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010H\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0002J\u0018\u0010I\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0002J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0002J\u0018\u0010M\u001a\u00020\u00142\u0006\u0010(\u001a\u00020K2\u0006\u0010L\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0018H\u0002J\b\u0010W\u001a\u00020\u0014H\u0002J\b\u0010X\u001a\u00020\u0014H\u0002J\n\u0010Y\u001a\u0004\u0018\u00010\u0000H\u0002J\n\u0010Z\u001a\u0004\u0018\u00010\u0000H\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010]\u001a\u00020\u0005J\u001a\u0010`\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010^2\b\b\u0002\u0010_\u001a\u00020\u0005J\u000e\u0010c\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aJ\u000e\u0010d\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aJ\u000e\u0010f\u001a\u00020\u00142\u0006\u0010b\u001a\u00020eJ\u000e\u0010g\u001a\u00020\u00142\u0006\u0010b\u001a\u00020eJ\u0018\u0010i\u001a\u00020\u00052\u0006\u0010h\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010j\u001a\u00020\u0005JI\u0010s\u001a\u0004\u0018\u00010\u00032\u0006\u0010k\u001a\u00020%2\b\u0010l\u001a\u0004\u0018\u00010%2+\u0010r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`qH\u0016J\u0010\u0010u\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u0012H\u0016J\u0010\u0010x\u001a\u00020\u00142\u0006\u0010w\u001a\u00020vH\u0016J\u0018\u0010{\u001a\u00020\u00142\u0006\u0010y\u001a\u00020'2\u0006\u0010z\u001a\u00020\u0012H\u0016J1\u0010\u0080\u0001\u001a\u00020\u00142\u0006\u0010|\u001a\u00020\u00052\u0006\u0010}\u001a\u00020\u00122\u0006\u0010~\u001a\u00020\u00122\u0006\u0010\u007f\u001a\u00020\u00122\u0006\u0010i\u001a\u00020\u0012H\u0014J\t\u0010\u0081\u0001\u001a\u00020\u0014H\u0016J\u0011\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u0018H\u0016J\u0019\u0010\u0086\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0016J<\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020\u00122\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0014H\u0014R>\u0010\u0091\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R>\u0010\u0093\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R>\u0010\u0095\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R>\u0010\u0097\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R>\u0010\u0099\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u0014\u0018\u00010mj\u0004\u0018\u0001`q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0090\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R(\u0010\u00a3\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u009e\u0001\u0010c\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a5\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a4\u0001\u0010cR\u0018\u0010\u00a7\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u0010cR\u0018\u0010\u00a9\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010cR(\u0010\u00ad\u0001\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\b\u00aa\u0001\u0010c\u001a\u0006\b\u00ab\u0001\u0010\u00a0\u0001\"\u0006\b\u00ac\u0001\u0010\u00a2\u0001R\u0019\u0010\u00af\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00aa\u0001R\u001c\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0017\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b4\u0001\u0010cR\u0018\u0010\u00b6\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b5\u0001\u0010cR\u0018\u0010\u00b8\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b7\u0001\u0010cR0\u0010\u00bc\u0001\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00b9\u0001\u0010c\u001a\u0006\b\u00ba\u0001\u0010\u00a0\u0001\"\u0006\b\u00bb\u0001\u0010\u00a2\u0001R\u0019\u0010\u00bf\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u0018\u0010\u00c1\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c0\u0001\u0010cR'\u0010\u00c7\u0001\u001a\t\u0012\u0004\u0012\u00020a0\u00c2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001\u001a\u0006\b\u00c5\u0001\u0010\u00c6\u0001R!\u0010\u00cc\u0001\u001a\u00030\u00c8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c9\u0001\u0010\u00c4\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u001b\u0010\u00cf\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u001b\u0010\u00d1\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00ce\u0001R\"\u0010\u00d4\u0001\u001a\u000b\u0012\u0004\u0012\u00020e\u0018\u00010\u00c2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u001b\u0010\u00d7\u0001\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u00d6\u0001R\u001b\u0010\u00da\u0001\u001a\u0005\u0018\u00010\u00d8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b;\u0010\u00d9\u0001R(\u0010\u00df\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bG\u0010\u00a4\u0001\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001\"\u0006\b\u00dd\u0001\u0010\u00de\u0001R(\u0010\u00e2\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bF\u0010\u00a4\u0001\u001a\u0006\b\u00e0\u0001\u0010\u00dc\u0001\"\u0006\b\u00e1\u0001\u0010\u00de\u0001R+\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u00e3\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bV\u0010\u00e4\u0001\u001a\u0006\b\u00e5\u0001\u0010\u00e6\u0001\"\u0006\b\u00e7\u0001\u0010\u00e8\u0001R\u001a\u0010\u00eb\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u00ea\u0001R\u001b\u0010\u00ee\u0001\u001a\u0005\u0018\u00010\u00ec\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bM\u0010\u00ed\u0001R\u001a\u0010\u00f0\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bJ\u0010\u00ef\u0001R\u0016\u0010(\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00f1\u0001\u0010\u00f2\u0001R\u0017\u0010\u00f4\u0001\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00f3\u0001\u0010\u00a0\u0001R)\u0010\u00f7\u0001\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00f5\u0001\u0010\u00a0\u0001\"\u0006\b\u00f6\u0001\u0010\u00a2\u0001R\u0016\u0010\u00fa\u0001\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\b\u001a\u0006\b\u00f8\u0001\u0010\u00f9\u0001\u00a8\u0006\u0083\u0002"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Li01/c;", "", "propValue", "", "P0", "Q0", "R0", "S0", "T0", "U0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "d1", "j1", "e1", "X0", "b1", "", "state", "", "t0", "Y", "preState", "Landroid/view/MotionEvent;", "ev", "i1", "l0", "m0", "a0", "r0", "L0", "velocityX", "velocityY", "s0", "n0", "", "", "u0", "Landroid/view/View;", "contentView", "h1", "", "offset", "overScrollStart", "isVertical", "l1", "offsetX", "offsetY", "o0", "isDragging", "q0", "p0", "value", "Y0", "originOffsetX", "originOffsetY", "animate", "F0", "b0", ICustomDataEditor.NUMBER_PARAM_1, "m1", "rvHeight", "contentHeight", "g1", "rvWidth", "contentWidth", "c1", "Z0", WaterFallComponentName.PROPERTY_CONTENT_INSET, "d0", "c0", "i0", "f0", "h0", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerContentView;", "contentViewChild", "g0", "A0", "newState", "K0", "O0", "H0", "I0", "J0", "motionEvent", "e0", "o1", "p1", "j0", "k0", "f1", "k1", "E0", "Lcom/tencent/kuikly/core/render/android/expand/component/list/e;", "immediately", "setContentInsert", "Lcom/tencent/kuikly/core/render/android/expand/component/list/a;", "listener", "Z", "V0", "Lcom/tencent/kuikly/core/render/android/expand/component/list/c;", "X", "W0", "propKey", "b", "M0", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "slopConstant", "setScrollingTouchSlop", "Landroid/graphics/Canvas;", "c", "draw", "child", "index", "addView", "changed", "l", "t", "r", "onLayout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "dispatchTouchEvent", "e", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "fling", "dx", "dy", "", "consumed", "offsetInWindow", "type", "dispatchNestedPreScroll", NodeProps.ON_ATTACHED_TO_WINDOW, "f", "Lkotlin/jvm/functions/Function1;", "scrollEventCallback", tl.h.F, "dragBeginEventCallback", "i", "dragEndEventCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "scrollEndEventCallback", BdhLogUtil.LogTag.Tag_Conn, "willEndDragEventCallback", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "D", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollListener", "E", "y0", "()Z", "setDirectionRow", "(Z)V", ScrollerAttr.DIRECTION_ROW, UserInfo.SEX_FEMALE, "pageEnable", "G", ScrollerAttr.SCROLL_ENABLED, "H", ScrollerAttr.BOUNCES_ENABLE, "I", "C0", "setLimitHeaderBounces$core_render_android_debug", ScrollerAttr.LIMIT_BOUNCES_ENABLE, "J", "preScrollState", "Lcom/tencent/kuikly/core/render/android/expand/component/list/j;", "K", "Lcom/tencent/kuikly/core/render/android/expand/component/list/j;", "overScrollHandler", "L", "M", "supportFling", "N", "needFireWillEndDragEvent", "P", "getEnableSmallTouchSlop", "setEnableSmallTouchSlop", "enableSmallTouchSlop", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "pendingSetContentOffsetStr", BdhLogUtil.LogTag.Tag_Req, "pendingFireOnScroll", "", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "B0", "()Ljava/util/List;", "krRecyclerViewListeners", "Lcom/tencent/kuikly/core/render/android/expand/component/list/k;", "T", "D0", "()Lcom/tencent/kuikly/core/render/android/expand/component/list/k;", "scrollConflictHandler", "U", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "closestHorizontalRecyclerViewParent", "V", "closestVerticalRecyclerViewParent", "W", "Ljava/util/List;", "nestedChildInterceptEventListeners", "Lcom/tencent/kuikly/core/render/android/expand/component/list/g;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/g;", "nestedHorizontalChildInterceptor", "Lcom/tencent/kuikly/core/render/android/expand/component/list/h;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/h;", "nestedVerticalChildInterceptor", "w0", "()F", "setContentOffsetY", "(F)V", "contentOffsetY", "v0", "setContentOffsetX", "contentOffsetX", "Lcom/tencent/kuikly/core/render/android/expand/component/list/b;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/b;", "getTouchDelegate", "()Lcom/tencent/kuikly/core/render/android/expand/component/list/b;", "setTouchDelegate", "(Lcom/tencent/kuikly/core/render/android/expand/component/list/b;)V", "touchDelegate", "Ljava/lang/Boolean;", ScrollerAttr.SCROLL_WITH_PARENT, "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "gestureListener", "Ljava/lang/Float;", ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, "x0", "()Landroid/view/View;", "G0", "isContentViewAttached", "z0", "setForceOverScroll", "forceOverScroll", "N0", "()Ljava/lang/Boolean;", "isScrollWithParent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRRecyclerView extends RecyclerView implements i01.c {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private Function1<Object, Unit> willEndDragEventCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView.OnScrollListener scrollListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean directionRow;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean pageEnable;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean scrollEnabled;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean bouncesEnable;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean limitHeaderBounces;

    /* renamed from: J, reason: from kotlin metadata */
    private int preScrollState;

    /* renamed from: K, reason: from kotlin metadata */
    private j overScrollHandler;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isDragging;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean supportFling;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needFireWillEndDragEvent;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean enableSmallTouchSlop;

    /* renamed from: Q, reason: from kotlin metadata */
    private String pendingSetContentOffsetStr;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean pendingFireOnScroll;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy krRecyclerViewListeners;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy scrollConflictHandler;

    /* renamed from: U, reason: from kotlin metadata */
    private KRRecyclerView closestHorizontalRecyclerViewParent;

    /* renamed from: V, reason: from kotlin metadata */
    private KRRecyclerView closestVerticalRecyclerViewParent;

    /* renamed from: W, reason: from kotlin metadata */
    private List<com.tencent.kuikly.core.render.android.expand.component.list.c> nestedChildInterceptEventListeners;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private g nestedHorizontalChildInterceptor;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private h nestedVerticalChildInterceptor;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float contentOffsetY;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float contentOffsetX;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.expand.component.list.b touchDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> scrollEventCallback;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private Boolean scrollWithParent;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private KRCSSGestureListener gestureListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> dragBeginEventCallback;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private Float syncScrollInMaxOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> dragEndEventCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> scrollEndEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0004R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0004\u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$a;", "", "", "BOUNCES_ENABLE", "Ljava/lang/String;", "CONTENT_HEIGHT", "CONTENT_WIDTH", "DIRECTION_ROW", "DRAG_BEGIN", "DRAG_END", "FLING_ENABLE", "HORIZONTAL_BOUNCES", "IS_DRAGGING", "LIMIT_HEADER_BOUNCES", "METHOD_CONTENT_INSET", "METHOD_CONTENT_INSET_WHEN_END_DRAG", "METHOD_CONTENT_OFFSET", "", "MILLISECOND", UserInfo.SEX_FEMALE, "OFFSET_X", "OFFSET_Y", "PAGING_ENABLED", "SCROLL", "SCROLL_ENABLED", "SCROLL_END", "SCROLL_WITH_PARENT", "SHOW_SCROLLER_INDICATOR", "SYNC_SCROLL_IN_MAX_OFFSET", "VELOCITY_X", "VELOCITY_Y", "VERTICAL_BOUNCES", "VIEW_HEIGHT", "VIEW_NAME", "VIEW_NAME_SCROLL_VIEW", "VIEW_WIDTH", "WILL_DRAG_END", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            j jVar = KRRecyclerView.this.overScrollHandler;
            if (jVar != null && jVar.getForceOverScroll()) {
                return;
            }
            if (KRRecyclerView.this.K0(newState) || KRRecyclerView.this.O0(newState)) {
                KRRecyclerView.this.isDragging = true;
                KRRecyclerView.this.l0();
            }
            if (KRRecyclerView.this.I0(newState) || KRRecyclerView.this.H0(newState)) {
                KRRecyclerView.this.isDragging = false;
                KRRecyclerView.this.m0();
            }
            if (KRRecyclerView.this.J0(newState)) {
                KRRecyclerView.this.n0();
            }
            KRRecyclerView.this.preScrollState = newState;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (!KRRecyclerView.this.getDirectionRow()) {
                dx5 = dy5;
            }
            if (dx5 != 0) {
                j jVar = KRRecyclerView.this.overScrollHandler;
                if (jVar != null) {
                    z16 = jVar.getForceOverScroll();
                } else {
                    z16 = false;
                }
                if (!z16) {
                    KRRecyclerView.this.r0();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$c", "Lcom/tencent/kuikly/core/render/android/css/gesture/b;", "", "a", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c extends com.tencent.kuikly.core.render.android.css.gesture.b {
        c() {
        }

        @Override // com.tencent.kuikly.core.render.android.css.gesture.b
        public void a() {
            j jVar = KRRecyclerView.this.overScrollHandler;
            if (jVar != null) {
                jVar.C();
            }
        }

        @Override // com.tencent.kuikly.core.render.android.css.gesture.b
        public void b() {
            super.b();
            j jVar = KRRecyclerView.this.overScrollHandler;
            if (jVar != null) {
                jVar.x();
            }
            KRRecyclerView.this.t0(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$d", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class d implements Function1<Object, Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f117892e;

        d(Object obj) {
            this.f117892e = obj;
        }

        public void a(@Nullable Object result) {
            Object obj = this.f117892e;
            if (!TypeIntrinsics.isFunctionOfArity(obj, 1)) {
                obj = null;
            }
            Function1 function1 = (Function1) obj;
            if (function1 != null) {
            }
            j jVar = KRRecyclerView.this.overScrollHandler;
            if (jVar != null) {
                jVar.C();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class e extends LinearLayoutManager {
        e(Context context, int i3, boolean z16) {
            super(context, i3, z16);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            KRCSSGestureListener kRCSSGestureListener = KRRecyclerView.this.gestureListener;
            if (kRCSSGestureListener != null && kRCSSGestureListener.l()) {
                return true;
            }
            return super.canScrollHorizontally();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J8\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView$f", "Lcom/tencent/kuikly/core/render/android/expand/component/list/i;", "", "offsetX", "offsetY", "", "overScrollStart", "isDragging", "", "c", "a", "velocityX", "velocityY", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class f implements i {
        f() {
        }

        @Override // com.tencent.kuikly.core.render.android.expand.component.list.i
        public void a(float offsetX, float offsetY, boolean overScrollStart, boolean isDragging) {
            if (KRRecyclerView.this.G0()) {
                KRRecyclerView.this.q0(offsetX, offsetY, overScrollStart, isDragging);
            }
        }

        @Override // com.tencent.kuikly.core.render.android.expand.component.list.i
        public void b(float offsetX, float offsetY, float velocityX, float velocityY, boolean overScrollStart, boolean isDragging) {
            if (KRRecyclerView.this.G0()) {
                KRRecyclerView.this.p0(offsetX, offsetY, velocityX, velocityY, overScrollStart);
            }
        }

        @Override // com.tencent.kuikly.core.render.android.expand.component.list.i
        public void c(float offsetX, float offsetY, boolean overScrollStart, boolean isDragging) {
            if (KRRecyclerView.this.G0()) {
                KRRecyclerView.this.o0(offsetX, offsetY, overScrollStart);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRRecyclerView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollEnabled = true;
        this.bouncesEnable = true;
        this.supportFling = true;
        this.needFireWillEndDragEvent = true;
        this.pendingSetContentOffsetStr = "";
        this.pendingFireOnScroll = true;
        lazy = LazyKt__LazyJVMKt.lazy(KRRecyclerView$krRecyclerViewListeners$2.INSTANCE);
        this.krRecyclerViewListeners = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$scrollConflictHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                Context context2 = KRRecyclerView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return new k(context2);
            }
        });
        this.scrollConflictHandler = lazy2;
        setOverScrollMode(2);
        setFocusableInTouchMode(false);
    }

    private final List<a> B0() {
        return (List) this.krRecyclerViewListeners.getValue();
    }

    private final k D0() {
        return (k) this.scrollConflictHandler.getValue();
    }

    private final void F0(int originOffsetX, int originOffsetY, int offsetX, int offsetY, boolean isVertical, boolean animate) {
        int i3;
        if (G0()) {
            View x06 = x0();
            int i16 = 0;
            if (offsetY < 0) {
                offsetY = 0;
            }
            if (offsetX < 0) {
                offsetX = 0;
            }
            if (isVertical) {
                i3 = offsetY - (-x06.getTop());
            } else {
                i3 = 0;
                i16 = offsetX - (-x06.getLeft());
            }
            if (animate) {
                smoothScrollBy(i16, i3);
            } else {
                scrollBy(i16, i3);
            }
            if (isVertical) {
                g1(originOffsetY, com.tencent.kuikly.core.render.android.css.ktx.b.g(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(x06), animate);
            } else {
                c1(originOffsetX, com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.h(x06), animate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G0() {
        if (getChildAt(0) == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H0(int newState) {
        if (this.preScrollState == 1 && newState == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I0(int newState) {
        if (this.preScrollState == 1 && newState == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J0(int newState) {
        if (this.preScrollState != 0 && newState == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K0(int newState) {
        if (this.preScrollState == 0 && newState == 1) {
            return true;
        }
        return false;
    }

    private final boolean L0() {
        float f16;
        Float f17 = this.syncScrollInMaxOffset;
        if (f17 == null) {
            return false;
        }
        float floatValue = f17.floatValue();
        if (this.directionRow) {
            f16 = this.contentOffsetX;
        } else {
            f16 = this.contentOffsetY;
        }
        if (f16 > floatValue) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O0(int newState) {
        if (this.preScrollState == 2 && newState == 1) {
            return true;
        }
        return false;
    }

    private final boolean P0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.limitHeaderBounces = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean Q0(Object propValue) {
        if (propValue != null) {
            this.dragBeginEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            Y();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean R0(Object propValue) {
        if (propValue != null) {
            this.dragEndEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            Y();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean S0(Object propValue) {
        if (propValue != null) {
            this.scrollEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            Y();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean T0(Object propValue) {
        if (propValue != null) {
            this.scrollEndEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            Y();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean U0(Object propValue) {
        if (propValue != null) {
            this.willEndDragEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean X0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.bouncesEnable = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void Y() {
        if (this.scrollListener != null) {
            return;
        }
        b bVar = new b();
        addOnScrollListener(bVar);
        Unit unit = Unit.INSTANCE;
        this.scrollListener = bVar;
    }

    private final void Y0(String value) {
        List split$default;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && G0()) {
            if (value != null) {
                boolean canScrollVertically = layoutManager.canScrollVertically();
                split$default = StringsKt__StringsKt.split$default((CharSequence) value, new String[]{" "}, false, 0, 6, (Object) null);
                int K = com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), Float.parseFloat((String) split$default.get(0)));
                int K2 = com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), Float.parseFloat((String) split$default.get(1)));
                boolean areEqual = Intrinsics.areEqual((String) split$default.get(2), "1");
                if (b0(K, K2)) {
                    F0(K, K2, K, K2, canScrollVertically, areEqual);
                    value = "";
                }
                this.pendingSetContentOffsetStr = value;
                return;
            }
            return;
        }
        if (value == null) {
            value = "";
        }
        this.pendingSetContentOffsetStr = value;
    }

    private final void Z0(int offsetX, int offsetY, boolean animate) {
        final com.tencent.kuikly.core.render.android.expand.component.list.e eVar = new com.tencent.kuikly.core.render.android.expand.component.list.e(get_kuiklyRenderContext(), "", null, 4, null);
        eVar.j(-offsetY);
        eVar.i(-offsetX);
        eVar.g(animate);
        if (animate) {
            postDelayed(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$setContentOffsetByOverScrollHandler$1
                @Override // java.lang.Runnable
                public final void run() {
                    j jVar = KRRecyclerView.this.overScrollHandler;
                    if (jVar != null) {
                        jVar.e(eVar);
                    }
                }
            }, 0L);
            return;
        }
        j jVar = this.overScrollHandler;
        if (jVar != null) {
            jVar.e(eVar);
        }
    }

    private final void a0() {
        if (!G0()) {
            return;
        }
        this.pendingFireOnScroll = true;
    }

    private final boolean a1(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.directionRow = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean b0(int offsetX, int offsetY) {
        if (this.directionRow) {
            if (offsetX <= x0().getWidth() - getWidth()) {
                return true;
            }
        } else if (offsetY <= x0().getHeight() - getHeight()) {
            return true;
        }
        return false;
    }

    private final boolean b1(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.supportFling = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void c0(String contentInset) {
        j jVar;
        if (contentInset != null && (jVar = this.overScrollHandler) != null) {
            jVar.e(new com.tencent.kuikly.core.render.android.expand.component.list.e(get_kuiklyRenderContext(), contentInset, null, 4, null));
        }
    }

    private final void c1(int offsetX, int rvWidth, int contentWidth, boolean animate) {
        int i3;
        if (offsetX >= 0 && (offsetX <= 0 || contentWidth > rvWidth)) {
            if (offsetX > 0 && (i3 = offsetX + rvWidth) >= contentWidth) {
                offsetX = i3 - contentWidth;
            } else {
                offsetX = -1;
            }
        }
        if (offsetX != -1) {
            Z0(offsetX, 0, animate);
        }
    }

    private final void d0(String contentInset) {
        j jVar;
        if (contentInset != null && (jVar = this.overScrollHandler) != null) {
            jVar.D(new com.tencent.kuikly.core.render.android.expand.component.list.e(get_kuiklyRenderContext(), contentInset, null, 4, null));
        }
    }

    private final boolean d1(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.pageEnable = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean e0(MotionEvent motionEvent) {
        List<com.tencent.kuikly.core.render.android.expand.component.list.c> list = this.nestedChildInterceptEventListeners;
        if (list != null) {
            Iterator<com.tencent.kuikly.core.render.android.expand.component.list.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean e1(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.scrollEnabled = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void f0(float offsetX, float offsetY) {
        Iterator<a> it = B0().iterator();
        while (it.hasNext()) {
            it.next().l(offsetX, offsetY);
        }
    }

    private final boolean f1(Object propValue) {
        Boolean bool;
        if (propValue != null) {
            int intValue = ((Integer) propValue).intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    bool = null;
                } else {
                    bool = Boolean.TRUE;
                }
            } else {
                bool = Boolean.FALSE;
            }
            this.scrollWithParent = bool;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(KRRecyclerContentView contentView, View contentViewChild) {
        Iterator<a> it = B0().iterator();
        while (it.hasNext()) {
            it.next().o(contentView, contentViewChild);
        }
    }

    private final void g1(int offsetY, int rvHeight, int contentHeight, boolean animate) {
        int i3;
        if (offsetY >= 0 && (offsetY <= 0 || contentHeight > rvHeight)) {
            if (offsetY > 0 && (i3 = offsetY + rvHeight) >= contentHeight) {
                offsetY = i3 - contentHeight;
            } else {
                offsetY = -1;
            }
        }
        if (offsetY != -1) {
            Z0(0, offsetY, animate);
        }
    }

    private final void h0(float offsetX, float offsetY) {
        Iterator<a> it = B0().iterator();
        while (it.hasNext()) {
            it.next().j(offsetX, offsetY);
        }
    }

    private final void h1(final View contentView) {
        View view;
        if (!(contentView instanceof KRRecyclerContentView)) {
            view = null;
        } else {
            view = contentView;
        }
        KRRecyclerContentView kRRecyclerContentView = (KRRecyclerContentView) view;
        if (kRRecyclerContentView != null) {
            kRRecyclerContentView.setAddChildCallback(new Function1<View, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$setupAdapter$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View child) {
                    Intrinsics.checkNotNullParameter(child, "child");
                    KRRecyclerView.this.g0((KRRecyclerContentView) contentView, child);
                }
            });
            kRRecyclerContentView.setOnRemoveFromParentCallback(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$setupAdapter$$inlined$also$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    KRRecyclerView.this.setAdapter(null);
                }
            });
        }
        if (contentView != null) {
            setAdapter(new com.tencent.kuikly.core.render.android.expand.component.list.f((KRRecyclerContentView) contentView));
            setLayoutManager(new e(getContext(), !this.directionRow ? 1 : 0, false));
            if (this.pageEnable) {
                new com.tencent.kuikly.core.render.android.expand.component.list.d(new Function1<Integer, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$setupAdapter$3
                    public final void invoke(int i3) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }
                }).attachToRecyclerView(this);
            }
            if (this.bouncesEnable) {
                this.overScrollHandler = new j(this, contentView, !this.directionRow, new f());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView");
    }

    private final void i0(float offsetX, float offsetY) {
        Iterator<a> it = B0().iterator();
        while (it.hasNext()) {
            it.next().onScroll(offsetX, offsetY);
        }
    }

    private final boolean i1(int preState, MotionEvent ev5) {
        KRCSSGestureListener kRCSSGestureListener;
        if (ev5.getActionMasked() != 0 || (kRCSSGestureListener = this.gestureListener) == null || !kRCSSGestureListener.l() || preState != 2 || getScrollState() != 1) {
            return false;
        }
        return true;
    }

    private final KRRecyclerView j0() {
        KRRecyclerView kRRecyclerView;
        boolean z16;
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        while (viewGroup != null) {
            if ((viewGroup instanceof KRRecyclerView) && (z16 = (kRRecyclerView = (KRRecyclerView) viewGroup).directionRow) && z16 == this.directionRow) {
                return kRRecyclerView;
            }
            if (Intrinsics.areEqual(viewGroup, getRootView())) {
                return null;
            }
            ViewParent parent2 = viewGroup.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            viewGroup = (ViewGroup) parent2;
        }
        return null;
    }

    private final boolean j1(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            setHorizontalScrollBarEnabled(z16);
            setVerticalScrollBarEnabled(z16);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final KRRecyclerView k0() {
        KRRecyclerView kRRecyclerView;
        boolean z16;
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        while (viewGroup != null) {
            if ((viewGroup instanceof KRRecyclerView) && !(z16 = (kRRecyclerView = (KRRecyclerView) viewGroup).directionRow) && z16 == this.directionRow) {
                return kRRecyclerView;
            }
            if (Intrinsics.areEqual(viewGroup, getRootView())) {
                return null;
            }
            ViewParent parent2 = viewGroup.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            viewGroup = (ViewGroup) parent2;
        }
        return null;
    }

    private final boolean k1(Object propValue) {
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (propValue != null) {
            this.syncScrollInMaxOffset = Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, ((Float) propValue).floatValue()));
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        this.needFireWillEndDragEvent = true;
        f0(this.contentOffsetX, this.contentOffsetY);
        Function1<Object, Unit> function1 = this.dragBeginEventCallback;
        if (function1 != null) {
            function1.invoke(u0());
        }
    }

    private final float l1(View contentView, float offset, boolean overScrollStart, boolean isVertical) {
        int left;
        if (overScrollStart) {
            return -offset;
        }
        float f16 = -offset;
        if (isVertical) {
            left = contentView.getTop();
        } else {
            left = contentView.getLeft();
        }
        return (-left) + f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        if (this.needFireWillEndDragEvent) {
            s0(0, 0);
        }
        h0(this.contentOffsetX, this.contentOffsetY);
        Function1<Object, Unit> function1 = this.dragEndEventCallback;
        if (function1 != null) {
            function1.invoke(u0());
        }
    }

    private final void m1() {
        if (G0() && this.pendingFireOnScroll) {
            r0();
            this.pendingFireOnScroll = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        Function1<Object, Unit> function1 = this.scrollEndEventCallback;
        if (function1 != null) {
            function1.invoke(u0());
        }
    }

    private final void n1() {
        boolean z16;
        if (!G0()) {
            return;
        }
        if (this.pendingSetContentOffsetStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Y0(this.pendingSetContentOffsetStr);
            this.pendingSetContentOffsetStr = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(float offsetX, float offsetY, boolean overScrollStart) {
        this.contentOffsetX = l1(x0(), offsetX, overScrollStart, !this.directionRow);
        float l16 = l1(x0(), offsetY, overScrollStart, !this.directionRow);
        this.contentOffsetY = l16;
        this.needFireWillEndDragEvent = true;
        f0(this.contentOffsetX, l16);
        Function1<Object, Unit> function1 = this.dragBeginEventCallback;
        if (function1 != null) {
            Map<String, Object> u06 = u0();
            u06.put("offsetX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetX)));
            u06.put("offsetY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetY)));
            function1.invoke(u06);
        }
    }

    private final void o1() {
        KRRecyclerView j06;
        if (this.directionRow && (j06 = j0()) != null) {
            this.closestHorizontalRecyclerViewParent = j06;
            g gVar = new g(this);
            this.nestedHorizontalChildInterceptor = gVar;
            j06.X(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(float offsetX, float offsetY, float velocityX, float velocityY, boolean overScrollStart) {
        this.contentOffsetX = l1(x0(), offsetX, overScrollStart, false);
        this.contentOffsetY = l1(x0(), offsetY, overScrollStart, true);
        if (this.needFireWillEndDragEvent) {
            s0((int) velocityX, (int) velocityY);
        }
        h0(this.contentOffsetX, this.contentOffsetY);
        Function1<Object, Unit> function1 = this.dragEndEventCallback;
        if (function1 != null) {
            Map<String, Object> u06 = u0();
            u06.put("offsetX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetX)));
            u06.put("offsetY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetY)));
            function1.invoke(u06);
        }
    }

    private final void p1() {
        KRRecyclerView k06;
        if (!this.directionRow && (k06 = k0()) != null) {
            this.closestVerticalRecyclerViewParent = k06;
            h hVar = new h(this);
            this.nestedVerticalChildInterceptor = hVar;
            k06.X(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(float offsetX, float offsetY, boolean overScrollStart, boolean isDragging) {
        this.isDragging = isDragging;
        View x06 = x0();
        this.contentOffsetX = l1(x06, offsetX, overScrollStart, false);
        float l16 = l1(x06, offsetY, overScrollStart, true);
        this.contentOffsetY = l16;
        i0(this.contentOffsetX, l16);
        Function1<Object, Unit> function1 = this.scrollEventCallback;
        if (function1 != null) {
            Map<String, Object> u06 = u0();
            u06.put("offsetX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetX)));
            u06.put("offsetY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.contentOffsetY)));
            function1.invoke(u06);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        View x06 = x0();
        float f16 = -x06.getLeft();
        float translationY = (-x06.getTop()) - x0().getTranslationY();
        if (this.contentOffsetX == f16 && this.contentOffsetY == translationY) {
            return;
        }
        this.contentOffsetX = f16;
        this.contentOffsetY = translationY;
        i0(f16, translationY);
        Function1<Object, Unit> function1 = this.scrollEventCallback;
        if (function1 != null) {
            Map<String, Object> u06 = u0();
            if (L0()) {
                u06.put("kr_sync_callback_key", 1);
            }
            function1.invoke(u06);
        }
    }

    private final void s0(int velocityX, int velocityY) {
        this.needFireWillEndDragEvent = false;
        Function1<Object, Unit> function1 = this.willEndDragEventCallback;
        if (function1 != null) {
            Map<String, Object> u06 = u0();
            u06.put("velocityX", Float.valueOf(velocityX / 1000.0f));
            u06.put("velocityY", Float.valueOf(velocityY / 1000.0f));
            j jVar = this.overScrollHandler;
            if (jVar != null && jVar.getOverScrolling()) {
                u06.put("offsetX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), l1(x0(), jVar.getOverScrollX(), jVar.s(), false))));
                u06.put("offsetY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), l1(x0(), jVar.getOverScrollY(), jVar.s(), true))));
            }
            function1.invoke(u06);
        }
    }

    public static /* synthetic */ void setContentInsert$default(KRRecyclerView kRRecyclerView, com.tencent.kuikly.core.render.android.expand.component.list.e eVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        kRRecyclerView.setContentInsert(eVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(int state) {
        try {
            Field f16 = RecyclerView.class.getDeclaredField("mScrollState");
            Intrinsics.checkNotNullExpressionValue(f16, "f");
            f16.setAccessible(true);
            f16.set(this, Integer.valueOf(state));
        } catch (Exception e16) {
            w.f392617a.b("KRListView", "set mTouchSlop error, " + e16);
        }
    }

    private final Map<String, Object> u0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!G0()) {
            return linkedHashMap;
        }
        View x06 = x0();
        linkedHashMap.put("offsetX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), -x06.getLeft())));
        linkedHashMap.put("offsetY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), -x06.getTop())));
        linkedHashMap.put("contentWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.h(x06))));
        linkedHashMap.put("contentHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.g(x06))));
        linkedHashMap.put("viewWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.h(this))));
        linkedHashMap.put("viewHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.g(this))));
        linkedHashMap.put("isDragging", Integer.valueOf(A0(this.isDragging)));
        return linkedHashMap;
    }

    private final View x0() {
        View childAt = getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        return childAt;
    }

    /* renamed from: C0, reason: from getter */
    public final boolean getLimitHeaderBounces() {
        return this.limitHeaderBounces;
    }

    public final boolean E0() {
        KRCSSGestureListener kRCSSGestureListener = this.gestureListener;
        if (kRCSSGestureListener != null && kRCSSGestureListener.l()) {
            return true;
        }
        return false;
    }

    /* renamed from: M0, reason: from getter */
    public final boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    @Nullable
    /* renamed from: N0, reason: from getter */
    public final Boolean getScrollWithParent() {
        return this.scrollWithParent;
    }

    public final void V0(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        B0().remove(listener);
    }

    public final void W0(@NotNull com.tencent.kuikly.core.render.android.expand.component.list.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<com.tencent.kuikly.core.render.android.expand.component.list.c> list = this.nestedChildInterceptEventListeners;
        if (list != null) {
            list.remove(listener);
        }
    }

    public final void X(@NotNull com.tencent.kuikly.core.render.android.expand.component.list.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List list = this.nestedChildInterceptEventListeners;
        if (list == null) {
            list = new ArrayList();
            this.nestedChildInterceptEventListeners = list;
        }
        list.add(listener);
    }

    public final void Z(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        B0().add(listener);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (getAdapter() == null) {
            h1(child);
        } else {
            super.addView(child, index);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r2.equals("touchEnable") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return e1(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        if (r2.equals(com.tencent.kuikly.core.views.ScrollerAttr.BOUNCES_ENABLE) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return X0(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
    
        if (r2.equals("horizontalbounces") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0114, code lost:
    
        if (r2.equals("verticalbounces") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        if (r2.equals(com.tencent.kuikly.core.views.ScrollerAttr.SCROLL_ENABLED) != false) goto L60;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1719031297:
                if (propKey.equals(ScrollerAttr.FLING_ENABLE)) {
                    return b1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1652343083:
                if (propKey.equals("willDragEnd")) {
                    return U0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1151046732:
                break;
            case -909294923:
                break;
            case -907680051:
                if (propKey.equals("scroll")) {
                    return S0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -502352363:
                if (propKey.equals(ScrollerAttr.PAGING_ENABLED)) {
                    return d1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -338527275:
                if (propKey.equals("dragBegin")) {
                    return Q0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -334487993:
                break;
            case 110749:
                if (propKey.equals("pan")) {
                    boolean p16 = c.a.p(this, propKey, propValue);
                    KRCSSGestureListener q16 = KRCSSViewExtensionKt.q(this);
                    this.gestureListener = q16;
                    if (q16 != null) {
                        q16.b(new c());
                        return p16;
                    }
                    return p16;
                }
                return c.a.p(this, propKey, propValue);
            case 94750088:
                if (propKey.equals("click")) {
                    return c.a.p(this, propKey, new d(propValue));
                }
                return c.a.p(this, propKey, propValue);
            case 97692013:
                if (propKey.equals(AIInput.KEY_FRAME)) {
                    a0();
                    return c.a.p(this, propKey, propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 369680317:
                if (propKey.equals(ScrollerAttr.SCROLL_WITH_PARENT)) {
                    return f1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 417766094:
                if (propKey.equals("scrollEnd")) {
                    return T0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 952735195:
                if (propKey.equals(ScrollerAttr.DIRECTION_ROW)) {
                    return a1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 972542030:
                break;
            case 1280722338:
                break;
            case 1454025080:
                if (propKey.equals(ScrollerAttr.SHOW_SCROLLER_INDICATOR)) {
                    return j1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1606947747:
                if (propKey.equals(ScrollerAttr.LIMIT_BOUNCES_ENABLE)) {
                    return P0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1912497927:
                if (propKey.equals("dragEnd")) {
                    return R0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1973298442:
                if (propKey.equals(ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET)) {
                    return k1(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.a(this, method, obj, function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int dx5, int dy5, @Nullable int[] consumed, @Nullable int[] offsetInWindow, int type) {
        if (E0() && !this.directionRow && Math.abs(dx5) > Math.abs(dy5)) {
            if (consumed != null) {
                consumed[1] = dy5;
            }
            return true;
        }
        return super.dispatchNestedPreScroll(dx5, dy5, consumed, offsetInWindow, type);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        j jVar = this.overScrollHandler;
        if (jVar != null && jVar.getForceOverScroll()) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
            com.tencent.kuikly.core.render.android.expand.component.list.b bVar = this.touchDelegate;
            if (bVar != null) {
                bVar.m(ev5);
                return dispatchTouchEvent;
            }
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(@NotNull Canvas c16) {
        Intrinsics.checkNotNullParameter(c16, "c");
        KRCSSViewExtensionKt.g(this, c16);
        super.draw(c16);
        KRCSSViewExtensionKt.h(this, c16);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.l(this, parent);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int velocityX, int velocityY) {
        j jVar = this.overScrollHandler;
        if (jVar == null || !jVar.getOverScrolling()) {
            s0(velocityX, velocityY);
        }
        if (!this.supportFling) {
            t0(0);
            return true;
        }
        return super.fling(velocityX, velocityY);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o1();
        p1();
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        KRRecyclerView kRRecyclerView;
        KRRecyclerView kRRecyclerView2;
        c.a.k(this);
        g gVar = this.nestedHorizontalChildInterceptor;
        if (gVar != null && (kRRecyclerView2 = this.closestHorizontalRecyclerViewParent) != null) {
            kRRecyclerView2.W0(gVar);
        }
        h hVar = this.nestedVerticalChildInterceptor;
        if (hVar != null && (kRRecyclerView = this.closestVerticalRecyclerViewParent) != null) {
            kRRecyclerView.W0(hVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(e16, "e");
        if (!this.scrollEnabled || e0(e16)) {
            return false;
        }
        if (this.directionRow && this.enableSmallTouchSlop) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(e16);
            if (onInterceptTouchEvent) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            return onInterceptTouchEvent;
        }
        com.tencent.kuikly.core.render.android.expand.component.list.b bVar = this.touchDelegate;
        if (bVar != null) {
            z16 = bVar.i(e16);
        } else {
            z16 = false;
        }
        if (z16) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (D0().a(e16, this)) {
            return false;
        }
        int scrollState = getScrollState();
        boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(e16);
        if (i1(scrollState, e16)) {
            return false;
        }
        return onInterceptTouchEvent2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        n1();
        m1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (!this.scrollEnabled) {
            return false;
        }
        KRCSSGestureListener kRCSSGestureListener = this.gestureListener;
        if (kRCSSGestureListener != null && kRCSSGestureListener.getIsPanEventHappening()) {
            return false;
        }
        j jVar = this.overScrollHandler;
        if (jVar != null && jVar.w(e16)) {
            return true;
        }
        return super.onTouchEvent(e16);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return c.a.m(this, propKey);
    }

    public final void setContentInsert(@Nullable com.tencent.kuikly.core.render.android.expand.component.list.e contentInset, boolean immediately) {
        j jVar = this.overScrollHandler;
        if (jVar != null) {
            if (immediately) {
                jVar.D(contentInset);
                if (contentInset == null) {
                    contentInset = new com.tencent.kuikly.core.render.android.expand.component.list.e(get_kuiklyRenderContext(), null, null, 6, null);
                }
                jVar.e(contentInset);
                return;
            }
            jVar.D(contentInset);
        }
    }

    public final void setContentOffsetX(float f16) {
        this.contentOffsetX = f16;
    }

    public final void setContentOffsetY(float f16) {
        this.contentOffsetY = f16;
    }

    public final void setDirectionRow(boolean z16) {
        this.directionRow = z16;
    }

    public final void setEnableSmallTouchSlop(boolean z16) {
        int scaledTouchSlop;
        if (this.enableSmallTouchSlop == z16) {
            return;
        }
        this.enableSmallTouchSlop = z16;
        try {
            if (z16) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
                scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
            } else {
                ViewConfiguration viewConfiguration2 = ViewConfiguration.get(getContext());
                Intrinsics.checkNotNullExpressionValue(viewConfiguration2, "ViewConfiguration.get(context)");
                scaledTouchSlop = viewConfiguration2.getScaledTouchSlop();
            }
            Field f16 = RecyclerView.class.getDeclaredField("mTouchSlop");
            Intrinsics.checkNotNullExpressionValue(f16, "f");
            f16.setAccessible(true);
            f16.set(this, Integer.valueOf(scaledTouchSlop));
        } catch (Exception e16) {
            w.f392617a.b("KRListView", "set mTouchSlop error, " + e16);
        }
    }

    public final void setForceOverScroll(boolean z16) {
        j jVar = this.overScrollHandler;
        if (jVar != null) {
            jVar.F(z16);
        }
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    public final void setLimitHeaderBounces$core_render_android_debug(boolean z16) {
        this.limitHeaderBounces = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int slopConstant) {
        D0().e(slopConstant);
        super.setScrollingTouchSlop(slopConstant);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    public final void setTouchDelegate(@Nullable com.tencent.kuikly.core.render.android.expand.component.list.b bVar) {
        this.touchDelegate = bVar;
    }

    /* renamed from: v0, reason: from getter */
    public final float getContentOffsetX() {
        return this.contentOffsetX;
    }

    /* renamed from: w0, reason: from getter */
    public final float getContentOffsetY() {
        return this.contentOffsetY;
    }

    /* renamed from: y0, reason: from getter */
    public final boolean getDirectionRow() {
        return this.directionRow;
    }

    public final boolean z0() {
        j jVar = this.overScrollHandler;
        if (jVar != null) {
            return jVar.getForceOverScroll();
        }
        return false;
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -2072001199) {
            if (hashCode != -454130068) {
                if (hashCode == 811343908 && method.equals(WaterFallComponentName.PROPERTY_CONTENT_INSET)) {
                    c0(params);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("contentOffset")) {
                Y0(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("contentInsetWhenEndDrag")) {
            d0(params);
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollEnabled = true;
        this.bouncesEnable = true;
        this.supportFling = true;
        this.needFireWillEndDragEvent = true;
        this.pendingSetContentOffsetStr = "";
        this.pendingFireOnScroll = true;
        lazy = LazyKt__LazyJVMKt.lazy(KRRecyclerView$krRecyclerViewListeners$2.INSTANCE);
        this.krRecyclerViewListeners = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView$scrollConflictHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                Context context2 = KRRecyclerView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return new k(context2);
            }
        });
        this.scrollConflictHandler = lazy2;
        setOverScrollMode(2);
        setFocusableInTouchMode(false);
    }

    private final int A0(boolean isDragging) {
        return isDragging ? 1 : 0;
    }
}
