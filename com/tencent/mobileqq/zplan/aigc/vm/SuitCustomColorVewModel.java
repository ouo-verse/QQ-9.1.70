package com.tencent.mobileqq.zplan.aigc.vm;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.helper.c;
import com.tencent.mobileqq.zplan.aigc.render.MaterialInst;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.light.bean.DyeColorInfo;
import org.light.utils.LightDyeUtil;
import qu4.p;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00f8\u00012\u00020\u0001:\u0006\u00f9\u0001\u00fa\u0001\u00fb\u0001B\t\u00a2\u0006\u0006\b\u00f6\u0001\u0010\u00f7\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\u00022\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J0\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0017j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u001e\u0010\u001e\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u001c\u0010#\u001a\u00020\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020\u0006J\u0010\u0010%\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000fJ\u0010\u0010&\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000fJ\u0010\u0010'\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000fJ\u0010\u0010(\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000fJ1\u0010-\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)2\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00020+\u00a2\u0006\u0004\b-\u0010.J$\u00101\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000200J \u00104\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102J\u001c\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u000105J\u000e\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u000208J\u001c\u0010=\u001a\u00020\u00022\u0006\u00109\u001a\u0002082\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020;J\u000e\u0010>\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010?\u001a\u00020\u0002J2\u0010B\u001a\u00020\u00022\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u00109\u001a\u0002082\n\b\u0002\u0010,\u001a\u0004\u0018\u00010AJ\u000e\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020CJ\u001c\u0010G\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010F\u001a\u00020\u0006H\u0007J\u0016\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u00109\u001a\u000208R\u0014\u0010L\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0017\u0010R\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR(\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000f0V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010Y\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR(\u0010j\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010Y\u001a\u0004\bh\u0010]\"\u0004\bi\u0010_R*\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010tR\"\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020w0v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010YR\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00040V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010YR-\u0010\u0080\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0017j\u0002`\u00180V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010YR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0089\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R'\u0010\u0015\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u008e\u0001\u0010x\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R%\u0010\u0095\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00010V0\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0088\u0001R*\u0010\u009b\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00010V0\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u0088\u0001R#\u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0098\u0001\u001a\u0006\b\u009f\u0001\u0010\u009a\u0001R0\u0010\u00a6\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a1\u0001\u0010\u0088\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001\"\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001c\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R,\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R&\u0010\u00b5\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b2\u0001\u0010b\u001a\u0005\b\u00b3\u0001\u0010d\"\u0005\b\u00b4\u0001\u0010fR*\u0010\u00bd\u0001\u001a\u00030\u00b6\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001\"\u0006\b\u00bb\u0001\u0010\u00bc\u0001R(\u0010\u00c3\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00be\u0001\u0010K\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001\"\u0006\b\u00c1\u0001\u0010\u00c2\u0001R&\u0010\u00c7\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00c4\u0001\u0010b\u001a\u0005\b\u00c5\u0001\u0010d\"\u0005\b\u00c6\u0001\u0010fR&\u0010\u00cb\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00c8\u0001\u0010b\u001a\u0005\b\u00c9\u0001\u0010d\"\u0005\b\u00ca\u0001\u0010fR&\u0010\u00cf\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00cc\u0001\u0010b\u001a\u0005\b\u00cd\u0001\u0010d\"\u0005\b\u00ce\u0001\u0010fR&\u0010\u00d3\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00d0\u0001\u0010b\u001a\u0005\b\u00d1\u0001\u0010d\"\u0005\b\u00d2\u0001\u0010fR\u001e\u0010\u00d5\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u0088\u0001R#\u0010\u00d8\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d6\u0001\u0010\u0098\u0001\u001a\u0006\b\u00d7\u0001\u0010\u009a\u0001R\u001e\u0010\u00da\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u0088\u0001R#\u0010\u00dd\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00db\u0001\u0010\u0098\u0001\u001a\u0006\b\u00dc\u0001\u0010\u009a\u0001R\u001e\u0010\u00df\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00de\u0001\u0010\u0088\u0001R#\u0010\u00e2\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e0\u0001\u0010\u0098\u0001\u001a\u0006\b\u00e1\u0001\u0010\u009a\u0001R\u001c\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00a9\u0001R\u001c\u0010\u00e6\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00a9\u0001R\u001c\u0010\u00e8\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e7\u0001\u0010\u00a9\u0001R*\u0010\u00f0\u0001\u001a\u00030\u00e9\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001\u001a\u0006\b\u00ec\u0001\u0010\u00ed\u0001\"\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u001e\u0010\u00f2\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u0088\u0001R#\u0010\u00f5\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00f3\u0001\u0010\u0098\u0001\u001a\u0006\b\u00f4\u0001\u0010\u009a\u0001\u00a8\u0006\u00fc\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "Landroidx/lifecycle/ViewModel;", "", "e3", "", "ktxImagePath", "", "isSRGB", Constants.BASE_IN_PLUGIN_VERSION, "Ljava/util/ArrayList;", "Lqu4/p;", "Lkotlin/collections/ArrayList;", "inputColors", "outputPNGPath", "y3", "", "color", "", "q2", "h3", "slotId", "ugcId", "cacheDirPath", "", "Lcom/tencent/mobileqq/zplan/aigc/vm/UGCResourceMap;", "E2", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "taskQueue", "runnable", "p2", "x3", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "userCacheRsp", ICustomDataEditor.STRING_PARAM_2, "page", "v2", "x2", "z2", "B2", "", "itemId", "Lkotlin/Function2;", "callback", "u2", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "gltfPath", "Lkotlin/Function1;", "g3", "Landroid/content/Context;", "context", Constants.MMCCID, "Landroid/graphics/Bitmap;", "iconBitmap", "F2", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "filamentRender", "i3", "Lkotlin/Function0;", "onComplete", "j3", "k3", "destroy", NodeProps.COLORS, "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "z3", "Lgl0/b;", "listener", "r2", "downloadSo", "f3", "isIcon", "w3", "i", "Ljava/lang/String;", "EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B", "Lcom/tencent/filament/zplan/avatar/CameraParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/avatar/CameraParams;", "R2", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "defaultCamera", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "generateUGCQueue", "", "Lcom/tencent/mobileqq/zplan/aigc/helper/c$a;", "D", "Ljava/util/List;", "ugcMaterialList", "E", "Y2", "()Ljava/util/List;", "t3", "(Ljava/util/List;)V", "hideUgcMaterialSlotIds", UserInfo.SEX_FEMALE, "I", "b3", "()I", "u3", "(I)V", "G", "Q2", "setCustomColors", "customColors", "", "H", "[[F", "getOriginColors", "()[[F", "setOriginColors", "([[F)V", "originColors", "Lorg/light/utils/LightDyeUtil;", "Lorg/light/utils/LightDyeUtil;", "lightDyeUtil", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$b;", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "doubleBufferStatus", "K", "generateTextureFilePathList", "L", "publishResourcePathList", "M", "previewResourceList", "Ljava/util/concurrent/atomic/AtomicInteger;", "N", "Ljava/util/concurrent/atomic/AtomicInteger;", "previewResourceIndex", "Landroidx/lifecycle/MutableLiveData;", "Lw74/a;", "P", "Landroidx/lifecycle/MutableLiveData;", "historyData", "Lcom/tencent/mobileqq/zplan/aigc/helper/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/aigc/helper/d;", "downloadLightSDKHelper", BdhLogUtil.LogTag.Tag_Req, "c3", "()J", "v3", "(J)V", "Lzv4/c;", ExifInterface.LATITUDE_SOUTH, "_ugcStoreItems", "Landroidx/lifecycle/LiveData;", "T", "Landroidx/lifecycle/LiveData;", "d3", "()Landroidx/lifecycle/LiveData;", "ugcStoreItems", "U", "_fetchStatus", "V", "T2", "fetchStatus", "W", ICustomDataEditor.STRING_ARRAY_PARAM_3, "()Landroidx/lifecycle/MutableLiveData;", "setLightSDKIsReady", "(Landroidx/lifecycle/MutableLiveData;)V", "lightSDKIsReady", "Lu55/d;", "X", "Lu55/d;", "mLastStoreItemRsp", "Y", "Lzv4/c;", "P2", "()Lzv4/c;", ICustomDataEditor.STRING_PARAM_3, "(Lzv4/c;)V", "currentUgcStoreItem", "Z", "I2", "l3", "currentItemId", "Luv4/az;", "a0", "Luv4/az;", "N2", "()Luv4/az;", "q3", "(Luv4/az;)V", "currentStoreItem", "b0", "O2", "()Ljava/lang/String;", "r3", "(Ljava/lang/String;)V", "currentStoreItemName", "c0", "J2", "m3", "currentPage", "d0", "K2", ICustomDataEditor.NUMBER_PARAM_3, "currentPageC0", "e0", "L2", "o3", "currentPageC1", "f0", "M2", "p3", "currentPageC2", "g0", "_fetchStatusC0", "h0", "U2", "fetchStatusC0", "i0", "_fetchStatusC1", "j0", "V2", "fetchStatusC1", "k0", "_fetchStatusC2", "l0", "W2", "fetchStatusC2", "m0", "mLastStoreItemRspC0", "n0", "mLastStoreItemRspC1", "o0", "mLastStoreItemRspC2", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "p0", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "H2", "()Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "setAvatarDressDataManager", "(Lcom/tencent/mobileqq/zplan/aigc/helper/b;)V", "avatarDressDataManager", "q0", "_fetchAvatarStatue", "r0", "S2", "fetchAvatarStatue", "<init>", "()V", "s0", "a", "FetchSuitListStatus", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitCustomColorVewModel extends ViewModel {

    /* renamed from: C */
    private final ConcurrentLinkedQueue<Runnable> generateUGCQueue;

    /* renamed from: D, reason: from kotlin metadata */
    private List<c.UGCMaterial> ugcMaterialList;

    /* renamed from: E, reason: from kotlin metadata */
    private List<Integer> hideUgcMaterialSlotIds;

    /* renamed from: F */
    private int slotId;

    /* renamed from: G, reason: from kotlin metadata */
    private List<p> customColors;

    /* renamed from: H, reason: from kotlin metadata */
    private float[][] originColors;

    /* renamed from: I, reason: from kotlin metadata */
    private LightDyeUtil lightDyeUtil;

    /* renamed from: J, reason: from kotlin metadata */
    private ConcurrentHashMap<Integer, TaskStatus> doubleBufferStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private List<String> generateTextureFilePathList;

    /* renamed from: L, reason: from kotlin metadata */
    private List<String> publishResourcePathList;

    /* renamed from: M, reason: from kotlin metadata */
    private List<Map<String, String>> previewResourceList;

    /* renamed from: N, reason: from kotlin metadata */
    private AtomicInteger previewResourceIndex;

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<w74.a> historyData;

    /* renamed from: Q */
    private final com.tencent.mobileqq.zplan.aigc.helper.d downloadLightSDKHelper;

    /* renamed from: R */
    private long ugcId;

    /* renamed from: S */
    private final MutableLiveData<List<zv4.c>> _ugcStoreItems;

    /* renamed from: T, reason: from kotlin metadata */
    private final LiveData<List<zv4.c>> ugcStoreItems;

    /* renamed from: U, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _fetchStatus;

    /* renamed from: V, reason: from kotlin metadata */
    private final LiveData<Integer> fetchStatus;

    /* renamed from: W, reason: from kotlin metadata */
    private MutableLiveData<Boolean> lightSDKIsReady;

    /* renamed from: X, reason: from kotlin metadata */
    private u55.d mLastStoreItemRsp;

    /* renamed from: Y, reason: from kotlin metadata */
    private zv4.c currentUgcStoreItem;

    /* renamed from: Z, reason: from kotlin metadata */
    private int currentItemId;

    /* renamed from: a0, reason: from kotlin metadata */
    private az currentStoreItem;

    /* renamed from: b0, reason: from kotlin metadata */
    private String currentStoreItemName;

    /* renamed from: c0, reason: from kotlin metadata */
    private int currentPage;

    /* renamed from: d0, reason: from kotlin metadata */
    private int currentPageC0;

    /* renamed from: e0, reason: from kotlin metadata */
    private int currentPageC1;

    /* renamed from: f0, reason: from kotlin metadata */
    private int currentPageC2;

    /* renamed from: g0, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _fetchStatusC0;

    /* renamed from: h0, reason: from kotlin metadata */
    private final LiveData<Integer> fetchStatusC0;

    /* renamed from: i, reason: from kotlin metadata */
    private final String EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B = "exp_zplan_mall_new_design_test_copy_B";

    /* renamed from: i0, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _fetchStatusC1;

    /* renamed from: j0, reason: from kotlin metadata */
    private final LiveData<Integer> fetchStatusC1;

    /* renamed from: k0, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _fetchStatusC2;

    /* renamed from: l0, reason: from kotlin metadata */
    private final LiveData<Integer> fetchStatusC2;

    /* renamed from: m */
    private final CameraParams defaultCamera;

    /* renamed from: m0, reason: from kotlin metadata */
    private u55.d mLastStoreItemRspC0;

    /* renamed from: n0, reason: from kotlin metadata */
    private u55.d mLastStoreItemRspC1;

    /* renamed from: o0, reason: from kotlin metadata */
    private u55.d mLastStoreItemRspC2;

    /* renamed from: p0, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.helper.b avatarDressDataManager;

    /* renamed from: q0, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _fetchAvatarStatue;

    /* renamed from: r0, reason: from kotlin metadata */
    private final LiveData<Boolean> fetchAvatarStatue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$FetchSuitListStatus;", "", "(Ljava/lang/String;I)V", "SUCCESS", com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, "Exception", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum FetchSuitListStatus {
        SUCCESS,
        FINISH,
        Exception
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "c", "(Z)V", "generatingImage", "b", "d", "rendering", "<init>", "(ZZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class TaskStatus {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private boolean generatingImage;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private boolean rendering;

        public TaskStatus() {
            this(false, false, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getGeneratingImage() {
            return this.generatingImage;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getRendering() {
            return this.rendering;
        }

        public final void c(boolean z16) {
            this.generatingImage = z16;
        }

        public final void d(boolean z16) {
            this.rendering = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.generatingImage;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.rendering;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "TaskStatus(generatingImage=" + this.generatingImage + ", rendering=" + this.rendering + ")";
        }

        public TaskStatus(boolean z16, boolean z17) {
            this.generatingImage = z16;
            this.rendering = z17;
        }

        public /* synthetic */ TaskStatus(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskStatus)) {
                return false;
            }
            TaskStatus taskStatus = (TaskStatus) other;
            return this.generatingImage == taskStatus.generatingImage && this.rendering == taskStatus.rendering;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SuitCustomColorVewModel", 1, "requestAvatarDressData failed: " + message);
            SuitCustomColorVewModel.this._fetchAvatarStatue.postValue(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        public void a(int result) {
            QLog.i("SuitCustomColorVewModel", 1, "requestAvatarDressData success");
            SuitCustomColorVewModel.this._fetchAvatarStatue.postValue(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$d", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements AigcPreviewBusinessScene.e {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene.e
        public void onComplete() {
            TaskStatus taskStatus = (TaskStatus) SuitCustomColorVewModel.this.doubleBufferStatus.get(Integer.valueOf(SuitCustomColorVewModel.this.previewResourceIndex.get()));
            if (taskStatus != null) {
                taskStatus.d(false);
            }
            QLog.i("SuitCustomColorVewModel", 1, "restoreClusterColor end");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$e", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements AigcPreviewBusinessScene.e {

        /* renamed from: b */
        final /* synthetic */ Function0<Unit> f330870b;

        e(Function0<Unit> function0) {
            this.f330870b = function0;
        }

        @Override // com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene.e
        public void onComplete() {
            TaskStatus taskStatus = (TaskStatus) SuitCustomColorVewModel.this.doubleBufferStatus.get(Integer.valueOf(SuitCustomColorVewModel.this.previewResourceIndex.get()));
            if (taskStatus != null) {
                taskStatus.d(false);
            }
            QLog.e("SuitCustomColorVewModel", 1, "restoreClusterColor end");
            this.f330870b.invoke();
        }
    }

    public final void D2(String str, boolean z16) {
        float[][] colors;
        QLog.e("SuitCustomColorVewModel", 1, "lightDyeUtil generateLightDyeColors begin");
        LightDyeUtil lightDyeUtil = this.lightDyeUtil;
        if (lightDyeUtil != null) {
            synchronized (lightDyeUtil) {
                LightDyeUtil lightDyeUtil2 = this.lightDyeUtil;
                float[][] fArr = null;
                DyeColorInfo dyeColorInfo = lightDyeUtil2 != null ? lightDyeUtil2.setupWithKtxPath(str, z16) : null;
                if (dyeColorInfo != null && (colors = dyeColorInfo.getColors()) != null) {
                    fArr = (float[][]) colors.clone();
                }
                this.originColors = fArr;
                if (fArr != null) {
                    this.customColors.clear();
                    float[][] fArr2 = this.originColors;
                    Intrinsics.checkNotNull(fArr2);
                    for (float[] fArr3 : fArr2) {
                        this.customColors.add(k3(fArr3));
                        QLog.e("SuitCustomColorVewModel", 1, "DyeUtil colorsStr: " + fArr3);
                    }
                }
                QLog.e("SuitCustomColorVewModel", 1, "lightDyeUtil generateLightDyeColors end");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e3() {
        QLog.e("SuitCustomColorVewModel", 1, "initLightDyeUtil");
        LightDyeUtil lightDyeUtil = new LightDyeUtil();
        this.lightDyeUtil = lightDyeUtil;
        Integer valueOf = Integer.valueOf(lightDyeUtil.initInstance());
        if (valueOf != null && valueOf.intValue() == 0) {
            return;
        }
        QLog.e("SuitCustomColorVewModel", 1, "DyeUtil initInstance failed");
    }

    private final void h3() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "SuitCustomColorVewModelreleaseLightDyeUtil", null, null, null, new SuitCustomColorVewModel$releaseLightDyeUtil$1(this, null), 14, null);
        }
    }

    private final void p2(ConcurrentLinkedQueue<Runnable> taskQueue, Runnable runnable) {
        while (taskQueue.size() > 0) {
            taskQueue.poll();
        }
        taskQueue.add(runnable);
    }

    public final void x3(ConcurrentLinkedQueue<Runnable> taskQueue) {
        TaskStatus taskStatus;
        int i3 = (this.previewResourceIndex.get() + 1) % 2;
        TaskStatus taskStatus2 = this.doubleBufferStatus.get(Integer.valueOf(i3));
        if ((taskStatus2 == null || taskStatus2.getGeneratingImage()) ? false : true) {
            TaskStatus taskStatus3 = this.doubleBufferStatus.get(Integer.valueOf(i3));
            if (((taskStatus3 == null || taskStatus3.getRendering()) ? false : true) && taskQueue.size() > 0) {
                TaskStatus taskStatus4 = this.doubleBufferStatus.get(Integer.valueOf(i3));
                if (taskStatus4 != null) {
                    taskStatus4.c(true);
                }
                Runnable poll = taskQueue.poll();
                if (poll != null) {
                    poll.run();
                    return;
                } else {
                    x3(taskQueue);
                    return;
                }
            }
        }
        if (taskQueue.size() != 0 || (taskStatus = this.doubleBufferStatus.get(Integer.valueOf(i3))) == null) {
            return;
        }
        taskStatus.c(false);
    }

    public final void y3(ArrayList<p> inputColors, String outputPNGPath) {
        int collectionSizeOrDefault;
        if (inputColors.size() <= 0) {
            return;
        }
        Iterator<T> it = inputColors.iterator();
        String str = "updateClusterColor ";
        while (it.hasNext()) {
            int i3 = ((p) it.next()).f429637b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) str);
            sb5.append(i3);
            str = sb5.toString();
        }
        QLog.i("SuitCustomColorVewModel", 1, String.valueOf(str));
        this.customColors = inputColors;
        ArrayList arrayList = new ArrayList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(inputColors, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = inputColors.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Boolean.valueOf(arrayList.add(q2(((p) it5.next()).f429637b))));
        }
        Object[] array = arrayList.toArray(new float[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        DyeColorInfo dyeColorInfo = new DyeColorInfo((float[][]) array);
        LightDyeUtil lightDyeUtil = this.lightDyeUtil;
        Integer valueOf = lightDyeUtil != null ? Integer.valueOf(lightDyeUtil.updateClusterColor(dyeColorInfo, outputPNGPath)) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            return;
        }
        QLog.e("SuitCustomColorVewModel", 1, "DyeUtil updateClusterColor failed");
    }

    public final void B2(int page) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCustomColorVewModel$fetchUGCStoreItems_c2$1(this, null), 3, null);
    }

    public final String F2(String ugcId, Bitmap iconBitmap) {
        Intrinsics.checkNotNullParameter(ugcId, "ugcId");
        if (this.publishResourcePathList.isEmpty()) {
            return null;
        }
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        aIGCHelper.n(ugcId, this.publishResourcePathList.get(this.previewResourceIndex.get()));
        aIGCHelper.r(ugcId, this.publishResourcePathList.get(this.previewResourceIndex.get()), iconBitmap);
        return this.publishResourcePathList.get(this.previewResourceIndex.get());
    }

    public final void G2(String slotId, String ugcId, Context context) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        Intrinsics.checkNotNullParameter(ugcId, "ugcId");
        if (context == null) {
            QLog.e("SuitCustomColorVewModel", 1, "context is null!!!");
            return;
        }
        this.publishResourcePathList.clear();
        this.previewResourceList.clear();
        this.generateTextureFilePathList.clear();
        String str = context.getCacheDir() + "/zplanUGCResource/previewCustomFirst";
        String str2 = context.getCacheDir() + "/zplanUGCResource/previewCustomSecond";
        this.publishResourcePathList.add(str);
        this.publishResourcePathList.add(str2);
        Iterator<String> it = this.publishResourcePathList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            if (file.exists()) {
                FilesKt__UtilsKt.deleteRecursively(file);
            }
        }
        this.previewResourceList.add(E2(slotId, ugcId, str));
        this.previewResourceList.add(E2(slotId, ugcId, str2));
    }

    /* renamed from: H2, reason: from getter */
    public final com.tencent.mobileqq.zplan.aigc.helper.b getAvatarDressDataManager() {
        return this.avatarDressDataManager;
    }

    /* renamed from: I2, reason: from getter */
    public final int getCurrentItemId() {
        return this.currentItemId;
    }

    /* renamed from: J2, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* renamed from: K2, reason: from getter */
    public final int getCurrentPageC0() {
        return this.currentPageC0;
    }

    /* renamed from: L2, reason: from getter */
    public final int getCurrentPageC1() {
        return this.currentPageC1;
    }

    /* renamed from: M2, reason: from getter */
    public final int getCurrentPageC2() {
        return this.currentPageC2;
    }

    /* renamed from: N2, reason: from getter */
    public final az getCurrentStoreItem() {
        return this.currentStoreItem;
    }

    /* renamed from: O2, reason: from getter */
    public final String getCurrentStoreItemName() {
        return this.currentStoreItemName;
    }

    /* renamed from: P2, reason: from getter */
    public final zv4.c getCurrentUgcStoreItem() {
        return this.currentUgcStoreItem;
    }

    public final List<p> Q2() {
        return this.customColors;
    }

    /* renamed from: R2, reason: from getter */
    public final CameraParams getDefaultCamera() {
        return this.defaultCamera;
    }

    public final LiveData<Boolean> S2() {
        return this.fetchAvatarStatue;
    }

    public final LiveData<Integer> T2() {
        return this.fetchStatus;
    }

    public final LiveData<Integer> U2() {
        return this.fetchStatusC0;
    }

    public final LiveData<Integer> V2() {
        return this.fetchStatusC1;
    }

    public final LiveData<Integer> W2() {
        return this.fetchStatusC2;
    }

    public final List<Integer> Y2() {
        return this.hideUgcMaterialSlotIds;
    }

    public final MutableLiveData<Boolean> a3() {
        return this.lightSDKIsReady;
    }

    /* renamed from: b3, reason: from getter */
    public final int getSlotId() {
        return this.slotId;
    }

    /* renamed from: c3, reason: from getter */
    public final long getUgcId() {
        return this.ugcId;
    }

    public final LiveData<List<zv4.c>> d3() {
        return this.ugcStoreItems;
    }

    public final void destroy() {
        h3();
    }

    public final boolean f3(gl0.b listener, boolean downloadSo) {
        return this.downloadLightSDKHelper.d(listener, downloadSo);
    }

    public final void g3(String gltfPath, Function1<? super Boolean, Unit> callback) {
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SuitCustomColorVewModel", 1, "gltfPath is " + gltfPath);
        if (gltfPath == null || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e)) == null) {
            return;
        }
        CorountineFunKt.e(f16, "SuitCustomColorVewModellightDyeUtil", null, null, null, new SuitCustomColorVewModel$parseSlotColors$1$1(gltfPath, this, callback, null), 14, null);
    }

    public final void i3(ZplanFilamentSuitRender filamentRender) {
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        DyeColorInfo dyeColorInfo = new DyeColorInfo(this.originColors);
        if (this.originColors != null) {
            this.customColors.clear();
            float[][] fArr = this.originColors;
            Intrinsics.checkNotNull(fArr);
            for (float[] fArr2 : fArr) {
                this.customColors.add(k3(fArr2));
            }
        }
        String str = this.generateTextureFilePathList.get(this.previewResourceIndex.get());
        LightDyeUtil lightDyeUtil = this.lightDyeUtil;
        Integer valueOf = lightDyeUtil != null ? Integer.valueOf(lightDyeUtil.updateClusterColor(dyeColorInfo, str)) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            QLog.e("SuitCustomColorVewModel", 1, "DyeUtil restoreClusterColor failed");
            return;
        }
        TaskStatus taskStatus = this.doubleBufferStatus.get(Integer.valueOf(this.previewResourceIndex.get()));
        if (taskStatus != null) {
            taskStatus.d(true);
        }
        AigcPreviewBusinessScene scene = filamentRender.getScene();
        if (scene != null) {
            scene.updateUgc(new HashMap<>(this.previewResourceList.get(this.previewResourceIndex.get())), new d());
        }
    }

    public final void j3(ZplanFilamentSuitRender filamentRender, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        TaskStatus taskStatus = this.doubleBufferStatus.get(Integer.valueOf(this.previewResourceIndex.get()));
        if (taskStatus != null) {
            taskStatus.d(true);
        }
        AigcPreviewBusinessScene scene = filamentRender.getScene();
        if (scene != null) {
            scene.updateUgc(new HashMap<>(this.previewResourceList.get(this.previewResourceIndex.get())), new e(onComplete));
        }
    }

    public final p k3(float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        p pVar = new p();
        pVar.f429637b = ((int) color[2]) | (((int) color[0]) << 16) | (-16777216) | (((int) color[1]) << 8);
        return pVar;
    }

    public final void l3(int i3) {
        this.currentItemId = i3;
    }

    public final void m3(int i3) {
        this.currentPage = i3;
    }

    public final void n3(int i3) {
        this.currentPageC0 = i3;
    }

    public final void o3(int i3) {
        this.currentPageC1 = i3;
    }

    public final void p3(int i3) {
        this.currentPageC2 = i3;
    }

    public final void q3(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<set-?>");
        this.currentStoreItem = azVar;
    }

    public final void r2(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.downloadLightSDKHelper.b(listener);
    }

    public final void r3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentStoreItemName = str;
    }

    public final void s2(UEAvatarGender uEAvatarGender, boolean z16) {
        QLog.i("SuitCustomColorVewModel", 1, "fetchAvatarData");
        if (z16) {
            this._fetchAvatarStatue.postValue(Boolean.TRUE);
            QLog.i("SuitCustomColorVewModel", 1, "fetchAvatarData userCacheRsp success");
        } else {
            this.avatarDressDataManager.g(uEAvatarGender, z16, new c());
        }
    }

    public final void s3(zv4.c cVar) {
        this.currentUgcStoreItem = cVar;
    }

    public final void t3(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.hideUgcMaterialSlotIds = list;
    }

    public final void u2(Long itemId, Function2<? super Boolean, ? super Long, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (itemId == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCustomColorVewModel$fetchItemUGCId$1(callback, itemId, this, null), 3, null);
    }

    public final void u3(int i3) {
        this.slotId = i3;
    }

    public final void v2(int page) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCustomColorVewModel$fetchUGCStoreItems$1(this, null), 3, null);
    }

    public final void v3(long j3) {
        this.ugcId = j3;
    }

    public final void w3(boolean isIcon, ZplanFilamentSuitRender filamentRender) {
        String json;
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        AigcPreviewBusinessScene scene = filamentRender.getScene();
        if (scene != null) {
            if (isIcon) {
                json = "{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,14.13359],\"target\":[0.0,0.39022,0.0],\"upward\":[0.0,1.0,0.0]}}";
            } else {
                json = new Gson().toJson(this.defaultCamera);
            }
            Intrinsics.checkNotNullExpressionValue(json, "if (isIcon) ICON_CAMERA \u2026n().toJson(defaultCamera)");
            scene.switchCamera(json);
        }
    }

    public final void x2(int page) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCustomColorVewModel$fetchUGCStoreItems_c0$1(this, null), 3, null);
    }

    public final void z2(int page) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCustomColorVewModel$fetchUGCStoreItems_c1$1(this, null), 3, null);
    }

    public final void z3(final ArrayList<p> r26, final ZplanFilamentSuitRender filamentRender, final AigcPreviewBusinessScene.e callback) {
        Intrinsics.checkNotNullParameter(r26, "colors");
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        p2(this.generateUGCQueue, new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$updateCustomColor$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "SuitCustomColorVewModel_updateCustomColor", null, null, null, new SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1(SuitCustomColorVewModel.this, r26, filamentRender, callback, null), 14, null);
                }
            }
        });
        x3(this.generateUGCQueue);
    }

    public SuitCustomColorVewModel() {
        Map<? extends Integer, ? extends TaskStatus> mapOf;
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 18.97268f});
        lookAt.setTarget(new float[]{0.0f, 0.01795728f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        LensProjection lensProjection = new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null);
        lensProjection.setAspect(0.45f);
        lensProjection.setFar(1000.0f);
        lensProjection.setFocalLength(120);
        lensProjection.setNear(0.05f);
        cameraParams.setLensProjection(lensProjection);
        this.defaultCamera = cameraParams;
        this.generateUGCQueue = new ConcurrentLinkedQueue<>();
        this.ugcMaterialList = new ArrayList();
        this.hideUgcMaterialSlotIds = new ArrayList();
        this.slotId = 6;
        this.customColors = new ArrayList();
        this.doubleBufferStatus = new ConcurrentHashMap<>();
        this.generateTextureFilePathList = new ArrayList();
        this.publishResourcePathList = new ArrayList();
        this.previewResourceList = new ArrayList();
        this.previewResourceIndex = new AtomicInteger(0);
        this.historyData = new MutableLiveData<>();
        this.downloadLightSDKHelper = new com.tencent.mobileqq.zplan.aigc.helper.d();
        this.ugcId = -1L;
        MutableLiveData<List<zv4.c>> mutableLiveData = new MutableLiveData<>();
        this._ugcStoreItems = mutableLiveData;
        this.ugcStoreItems = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._fetchStatus = mutableLiveData2;
        this.fetchStatus = mutableLiveData2;
        this.lightSDKIsReady = new MutableLiveData<>();
        this.currentStoreItem = new az();
        this.currentStoreItemName = "";
        this.currentPage = -1;
        this.currentPageC0 = -1;
        this.currentPageC1 = -1;
        this.currentPageC2 = -1;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._fetchStatusC0 = mutableLiveData3;
        this.fetchStatusC0 = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._fetchStatusC1 = mutableLiveData4;
        this.fetchStatusC1 = mutableLiveData4;
        MutableLiveData<Integer> mutableLiveData5 = new MutableLiveData<>();
        this._fetchStatusC2 = mutableLiveData5;
        this.fetchStatusC2 = mutableLiveData5;
        this.avatarDressDataManager = new com.tencent.mobileqq.zplan.aigc.helper.b();
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._fetchAvatarStatue = mutableLiveData6;
        this.fetchAvatarStatue = mutableLiveData6;
        ConcurrentHashMap<Integer, TaskStatus> concurrentHashMap = this.doubleBufferStatus;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, new TaskStatus(false, false, 3, null)), TuplesKt.to(1, new TaskStatus(false, false, 3, null)));
        concurrentHashMap.putAll(mapOf);
    }

    public static /* synthetic */ void A2(SuitCustomColorVewModel suitCustomColorVewModel, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        suitCustomColorVewModel.z2(i3);
    }

    public static /* synthetic */ void A3(SuitCustomColorVewModel suitCustomColorVewModel, ArrayList arrayList, ZplanFilamentSuitRender zplanFilamentSuitRender, AigcPreviewBusinessScene.e eVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        suitCustomColorVewModel.z3(arrayList, zplanFilamentSuitRender, eVar);
    }

    public static /* synthetic */ void C2(SuitCustomColorVewModel suitCustomColorVewModel, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        suitCustomColorVewModel.B2(i3);
    }

    public static /* synthetic */ void w2(SuitCustomColorVewModel suitCustomColorVewModel, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        suitCustomColorVewModel.v2(i3);
    }

    public static /* synthetic */ void y2(SuitCustomColorVewModel suitCustomColorVewModel, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        suitCustomColorVewModel.x2(i3);
    }

    private final Map<String, String> E2(String slotId, String ugcId, String cacheDirPath) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<String, String> mutableMap;
        Map<String, String> mutableMapOf;
        List<c.UGCMaterial> list = this.ugcMaterialList;
        if (list == null || list.isEmpty()) {
            QLog.e("SuitCustomColorVewModel", 1, "ugcMaterialList is empty!!!");
            return new LinkedHashMap();
        }
        List<c.UGCMaterial> list2 = this.ugcMaterialList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (c.UGCMaterial uGCMaterial : list2) {
            Pair pair = TuplesKt.to(uGCMaterial.getMatSlotName(), ugcId + uGCMaterial.getTextureName());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        Iterator<Map.Entry<String, String>> it = aIGCHelper.q(cacheDirPath, mutableMap).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            next.getKey();
            this.generateTextureFilePathList.add(next.getValue());
        }
        ArrayList arrayList = new ArrayList();
        String baseColorName = this.ugcMaterialList.get(0).getBaseColorName();
        String str = ugcId + this.ugcMaterialList.get(0).getTextureName();
        for (c.UGCMaterial uGCMaterial2 : this.ugcMaterialList) {
            if (Intrinsics.areEqual(uGCMaterial2.getBaseColorName(), baseColorName)) {
                arrayList.add(new MaterialInst("CMShow/Assets/Other/Avatar2Design/" + ugcId + "/Texture/" + str, uGCMaterial2.getMatSlotName(), 0, uGCMaterial2.getMatSlotId(), 0, null, null, 116, null));
                arrayList.add(new MaterialInst("CMShow/Assets/Other/Avatar2Design/" + ugcId + "/Texture/" + str, uGCMaterial2.getMatSlotName() + "_LOD", 0, uGCMaterial2.getMatSlotId(), 0, null, null, 116, null));
            }
        }
        String l3 = AIGCHelper.f330685a.l(ugcId, arrayList, cacheDirPath);
        if (!(l3 == null || l3.length() == 0)) {
            Intrinsics.checkNotNull(l3);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(slotId, l3));
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    public static /* synthetic */ void t2(SuitCustomColorVewModel suitCustomColorVewModel, UEAvatarGender uEAvatarGender, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uEAvatarGender = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        suitCustomColorVewModel.s2(uEAvatarGender, z16);
    }

    private final float[] q2(int color) {
        return new float[]{(16711680 & color) >> 16, (65280 & color) >> 8, color & 255};
    }
}
