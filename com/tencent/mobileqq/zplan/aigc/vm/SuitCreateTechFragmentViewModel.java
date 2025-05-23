package com.tencent.mobileqq.zplan.aigc.vm;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.aigc.data.AIGCTemplateInfo;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentLoadSoUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import gl0.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import u45.l;
import u45.m;
import uv4.ac;
import uv4.az;
import uv4.bn;
import wc3.AigcPreviewParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00a2\u00022\u00020\u0001:\u0002\u00a3\u0002B\t\u00a2\u0006\u0006\b\u00a0\u0002\u0010\u00a1\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0003J,\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\u00062\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010&J\u001c\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&J\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0006J6\u00107\u001a\u00020\u00062\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020501j\b\u0012\u0004\u0012\u000205`3J\u0006\u00109\u001a\u000208J\u000e\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000208J\u000e\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0004J\b\u0010>\u001a\u00020\u0006H\u0014J\u000e\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0002J\u000e\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\fR>\u0010J\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020501j\b\u0012\u0004\u0012\u000205`30C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR>\u0010\\\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020T`U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010c\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010j\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00040K8\u0006\u00a2\u0006\f\n\u0004\bk\u0010M\u001a\u0004\bl\u0010OR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u0002080K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010MR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u0002080p8\u0006\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010MR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00020K8\u0006\u00a2\u0006\f\n\u0004\bx\u0010M\u001a\u0004\by\u0010OR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010MR\u001d\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00040p8\u0006\u00a2\u0006\f\n\u0004\b}\u0010r\u001a\u0004\b~\u0010tR\u001d\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010K8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010MR!\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010p8\u0006\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010r\u001a\u0005\b\u0084\u0001\u0010tR1\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R1\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u0087\u0001\u001a\u0006\b\u008e\u0001\u0010\u0089\u0001\"\u0006\b\u008f\u0001\u0010\u008b\u0001R)\u0010\u0097\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R)\u0010\u009b\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0092\u0001\u001a\u0006\b\u0099\u0001\u0010\u0094\u0001\"\u0006\b\u009a\u0001\u0010\u0096\u0001R\u001c\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u0002080K8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010MR \u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u0002080p8\u0006\u00a2\u0006\u000e\n\u0005\b\u009e\u0001\u0010r\u001a\u0005\b\u009f\u0001\u0010tR!\u0010\u00a2\u0001\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0087\u0001R \u0010\u00a5\u0001\u001a\b\u0012\u0004\u0012\u0002050K8\u0006\u00a2\u0006\u000e\n\u0005\b\u00a3\u0001\u0010M\u001a\u0005\b\u00a4\u0001\u0010OR\u001c\u0010\u00a7\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040K8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u0010MR \u0010\u00aa\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040p8\u0006\u00a2\u0006\u000e\n\u0005\b\u00a8\u0001\u0010r\u001a\u0005\b\u00a9\u0001\u0010tR\u0019\u0010\u00ab\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0092\u0001R,\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00ac\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001\"\u0006\b\u00b1\u0001\u0010\u00b2\u0001R+\u0010\u00ba\u0001\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001\"\u0006\b\u00b8\u0001\u0010\u00b9\u0001R)\u0010\u00bc\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bb\u0001\u0010\u0092\u0001\u001a\u0006\b\u00bc\u0001\u0010\u0094\u0001\"\u0006\b\u00bd\u0001\u0010\u0096\u0001R\u0018\u0010\u00bf\u0001\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00be\u0001\u0010xR0\u0010\u00c4\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00c0\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c1\u0001\u0010\u0087\u0001\u001a\u0006\b\u00c2\u0001\u0010\u0089\u0001\"\u0006\b\u00c3\u0001\u0010\u008b\u0001R0\u0010\u00c8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00c0\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c5\u0001\u0010\u0087\u0001\u001a\u0006\b\u00c6\u0001\u0010\u0089\u0001\"\u0006\b\u00c7\u0001\u0010\u008b\u0001R,\u0010\u00d0\u0001\u001a\u0005\u0018\u00010\u00c9\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00cd\u0001\"\u0006\b\u00ce\u0001\u0010\u00cf\u0001R(\u0010\u00d6\u0001\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00d1\u0001\u0010x\u001a\u0006\b\u00d2\u0001\u0010\u00d3\u0001\"\u0006\b\u00d4\u0001\u0010\u00d5\u0001R)\u0010\u00da\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d7\u0001\u0010\u0092\u0001\u001a\u0006\b\u00d8\u0001\u0010\u0094\u0001\"\u0006\b\u00d9\u0001\u0010\u0096\u0001R)\u0010\u00e1\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00db\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00dd\u0001\u0010\u00de\u0001\"\u0006\b\u00df\u0001\u0010\u00e0\u0001R)\u0010\u00e5\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e2\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00e3\u0001\u0010\u00de\u0001\"\u0006\b\u00e4\u0001\u0010\u00e0\u0001R)\u0010\u00e9\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e6\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00e7\u0001\u0010\u00de\u0001\"\u0006\b\u00e8\u0001\u0010\u00e0\u0001R(\u0010\u00ef\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00ea\u0001\u0010v\u001a\u0006\b\u00eb\u0001\u0010\u00ec\u0001\"\u0006\b\u00ed\u0001\u0010\u00ee\u0001R)\u0010\u00f3\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f0\u0001\u0010\u0092\u0001\u001a\u0006\b\u00f1\u0001\u0010\u0094\u0001\"\u0006\b\u00f2\u0001\u0010\u0096\u0001R)\u0010\u00f7\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f4\u0001\u0010\u0092\u0001\u001a\u0006\b\u00f5\u0001\u0010\u0094\u0001\"\u0006\b\u00f6\u0001\u0010\u0096\u0001R)\u0010\u00fb\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f8\u0001\u0010\u0092\u0001\u001a\u0006\b\u00f9\u0001\u0010\u0094\u0001\"\u0006\b\u00fa\u0001\u0010\u0096\u0001R(\u0010\u00ff\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00fc\u0001\u0010v\u001a\u0006\b\u00fd\u0001\u0010\u00ec\u0001\"\u0006\b\u00fe\u0001\u0010\u00ee\u0001R(\u0010\u0083\u0002\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0080\u0002\u0010x\u001a\u0006\b\u0081\u0002\u0010\u00d3\u0001\"\u0006\b\u0082\u0002\u0010\u00d5\u0001R(\u0010\u0087\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0084\u0002\u0010v\u001a\u0006\b\u0085\u0002\u0010\u00ec\u0001\"\u0006\b\u0086\u0002\u0010\u00ee\u0001R\u001e\u0010\u0089\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110K8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0088\u0002\u0010MR\"\u0010\u008c\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110p8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0002\u0010r\u001a\u0005\b\u008b\u0002\u0010tR+\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R,\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0094\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0095\u0002\u0010\u0096\u0002\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002\"\u0006\b\u0099\u0002\u0010\u009a\u0002R(\u0010\u009f\u0002\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009c\u0002\u0010^\u001a\u0005\b\u009d\u0002\u0010`\"\u0005\b\u009e\u0002\u0010b\u00a8\u0006\u00a4\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "", "requestIndex", "", "needRefreshUI", "", "j3", "Lcom/tencent/mobileqq/zplan/aigc/data/e;", "aigcTemplateInfo", "gender", "Y2", "", "methodName", "N2", "Liu4/b;", "feed", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", "V2", "d3", "Lu45/l;", "rsp", "W2", "g3", "h3", "Lgl0/b;", "listener", "e2", "f2", "downloadSo", "T2", "", "urlList", "loadingPagUrlList", ICustomDataEditor.STRING_ARRAY_PARAM_3, "pagUrls", NowProxyConstants.AccountInfoKey.A2, "U2", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "b3", WadlProxyConsts.SCENE_ID, "i3", "c2", SemanticAttributes.DbSystemValues.H2, "g2", "Q2", "v2", "f3", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/o;", "Lkotlin/collections/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "imagerys", "K3", "", "L2", "id", Constants.EMULATOR_INFO, "bShow", "J3", "onCleared", WidgetCacheConstellationData.NUM, "L3", "itemId", "b2", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "x2", "()Ljava/util/concurrent/ConcurrentHashMap;", "setMapOfIdToImagery", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "mapOfIdToImagery", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "o2", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentViewState", "(Landroidx/lifecycle/MutableLiveData;)V", "currentViewState", "Ljava/util/HashMap;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "y2", "()Ljava/util/HashMap;", "setMapOfWhiteModel", "(Ljava/util/HashMap;)V", "mapOfWhiteModel", "D", "Landroid/graphics/Bitmap;", "E2", "()Landroid/graphics/Bitmap;", "C3", "(Landroid/graphics/Bitmap;)V", "selectBitmap", "E", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "F2", "()Lcom/tencent/mobileqq/zplan/aigc/data/i;", Constants.BASE_IN_APP_NAME, "(Lcom/tencent/mobileqq/zplan/aigc/data/i;)V", "selectImagery", UserInfo.SEX_FEMALE, "w2", "hideTopAreaLiveData", "G", "_ticketNumLiveData", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "J2", "()Landroidx/lifecycle/LiveData;", "ticketNumLiveData", "I", "_playAdQualificationLiveData", "J", "getPlayAdQualificationLiveData", "playAdQualificationLiveData", "K", "_ticketVisibleLiveData", "L", "K2", "ticketVisibleLiveData", "Luv4/az;", "M", "_previewStoreItem", "N", "getPreviewStoreItem", "previewStoreItem", "P", "Ljava/util/List;", "r2", "()Ljava/util/List;", "setFemaleWhiteModeList", "(Ljava/util/List;)V", "femaleWhiteModeList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "O2", "setWhiteModeList", "whiteModeList", BdhLogUtil.LogTag.Tag_Req, "Z", "B2", "()Z", "v3", "(Z)V", "needFromNewPreview", ExifInterface.LATITUDE_SOUTH, "t2", "r3", "firstNeedWhiteModel", "T", "_ugcId", "U", "getUgcId", "ugcId", "V", "imageryList", "W", "p2", "customPromptLiveData", "X", "_successEvent", "Y", "I2", "successEvent", "isLoadingSucceed", "Lwc3/a;", "a0", "Lwc3/a;", "i2", "()Lwc3/a;", "l3", "(Lwc3/a;)V", "aigcPreviewParams", "b0", "Lcom/tencent/mobileqq/zplan/aigc/data/o;", Constants.MMCCID, "()Lcom/tencent/mobileqq/zplan/aigc/data/o;", "E3", "(Lcom/tencent/mobileqq/zplan/aigc/data/o;)V", "selectedWhiteModelItem", "c0", "isFromUserEdit", "t3", "d0", "requestBeginTimeMs", "", "e0", "j2", "setApiRequestStatus", "apiRequestStatus", "f0", "k2", "setApiResultStatus", "apiResultStatus", "Lvk3/a;", "g0", "Lvk3/a;", "getPagDownloadListener", "()Lvk3/a;", "x3", "(Lvk3/a;)V", "pagDownloadListener", "h0", "C2", "()J", "y3", "(J)V", "performanceTimeStamp", "i0", "R2", "w3", "isOfficial", "j0", "Ljava/lang/String;", "q2", "()Ljava/lang/String;", "p3", "(Ljava/lang/String;)V", "description", "k0", Constants.BASE_IN_PLUGIN_VERSION, "z3", "prompt", "l0", "z2", "u3", "name", "m0", "m2", "()I", ICustomDataEditor.NUMBER_PARAM_3, "(I)V", "clothNumber", "n0", "S2", "F3", "isSwitchingFragment", "o0", "M2", "H3", "useCacheAvatarDataRsp", "p0", "u2", ICustomDataEditor.STRING_PARAM_3, "forceUseSavedAvatar", "q0", "l2", "m3", "avatarType", "r0", "P2", "I3", "whiteModelUgcId", "s0", ICustomDataEditor.NUMBER_PARAM_2, "o3", "currentItemId", "t0", "_fetchFeedSuccessEvent", "u0", ICustomDataEditor.STRING_PARAM_2, "fetchFeedSuccessEvent", "v0", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", "H2", "()Lcom/tencent/mobileqq/zplan/aigc/data/c;", "setShowFeedInfo", "(Lcom/tencent/mobileqq/zplan/aigc/data/c;)V", "showFeedInfo", "Lcom/tencent/image/URLDrawable;", "w0", "Lcom/tencent/image/URLDrawable;", "getFeedClothDrawable", "()Lcom/tencent/image/URLDrawable;", "q3", "(Lcom/tencent/image/URLDrawable;)V", "feedClothDrawable", "x0", "getPromptBgBitmap", "A3", "promptBgBitmap", "<init>", "()V", "y0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel extends ViewModel {

    /* renamed from: y0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: z0 */
    private static boolean f330803z0;

    /* renamed from: D, reason: from kotlin metadata */
    private Bitmap selectBitmap;

    /* renamed from: E, reason: from kotlin metadata */
    private Imagery selectImagery;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Long> _ticketNumLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Long> ticketNumLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _playAdQualificationLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Integer> playAdQualificationLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _ticketVisibleLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<Boolean> ticketVisibleLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<az> _previewStoreItem;

    /* renamed from: N, reason: from kotlin metadata */
    private final LiveData<az> previewStoreItem;

    /* renamed from: P, reason: from kotlin metadata */
    private List<SuitWhiteModelItem> femaleWhiteModeList;

    /* renamed from: Q */
    private List<SuitWhiteModelItem> whiteModeList;

    /* renamed from: R */
    private boolean needFromNewPreview;

    /* renamed from: S */
    private boolean firstNeedWhiteModel;

    /* renamed from: T, reason: from kotlin metadata */
    private final MutableLiveData<Long> _ugcId;

    /* renamed from: U, reason: from kotlin metadata */
    private final LiveData<Long> ugcId;

    /* renamed from: V, reason: from kotlin metadata */
    private List<Imagery> imageryList;

    /* renamed from: W, reason: from kotlin metadata */
    private final MutableLiveData<Imagery> customPromptLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _successEvent;

    /* renamed from: Y, reason: from kotlin metadata */
    private final LiveData<Boolean> successEvent;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isLoadingSucceed;

    /* renamed from: a0, reason: from kotlin metadata */
    private AigcPreviewParams aigcPreviewParams;

    /* renamed from: b0, reason: from kotlin metadata */
    private SuitWhiteModelItem selectedWhiteModelItem;

    /* renamed from: c0, reason: from kotlin metadata */
    private boolean isFromUserEdit;

    /* renamed from: d0, reason: from kotlin metadata */
    private long requestBeginTimeMs;

    /* renamed from: e0, reason: from kotlin metadata */
    private List<Boolean> apiRequestStatus;

    /* renamed from: f0, reason: from kotlin metadata */
    private List<Boolean> apiResultStatus;

    /* renamed from: g0, reason: from kotlin metadata */
    private vk3.a pagDownloadListener;

    /* renamed from: h0, reason: from kotlin metadata */
    private long performanceTimeStamp;

    /* renamed from: i0, reason: from kotlin metadata */
    private boolean isOfficial;

    /* renamed from: j0, reason: from kotlin metadata */
    private String description;

    /* renamed from: k0, reason: from kotlin metadata */
    private String prompt;

    /* renamed from: l0, reason: from kotlin metadata */
    private String name;

    /* renamed from: m0, reason: from kotlin metadata */
    private int clothNumber;

    /* renamed from: n0, reason: from kotlin metadata */
    private boolean isSwitchingFragment;

    /* renamed from: o0, reason: from kotlin metadata */
    private boolean useCacheAvatarDataRsp;

    /* renamed from: p0, reason: from kotlin metadata */
    private boolean forceUseSavedAvatar;

    /* renamed from: q0, reason: from kotlin metadata */
    private int avatarType;

    /* renamed from: r0, reason: from kotlin metadata */
    private long whiteModelUgcId;

    /* renamed from: s0, reason: from kotlin metadata */
    private int currentItemId;

    /* renamed from: t0, reason: from kotlin metadata */
    private final MutableLiveData<AIGCFeedItemInfo2> _fetchFeedSuccessEvent;

    /* renamed from: u0, reason: from kotlin metadata */
    private final LiveData<AIGCFeedItemInfo2> fetchFeedSuccessEvent;

    /* renamed from: v0, reason: from kotlin metadata */
    private AIGCFeedItemInfo2 showFeedInfo;

    /* renamed from: w0, reason: from kotlin metadata */
    private URLDrawable feedClothDrawable;

    /* renamed from: x0, reason: from kotlin metadata */
    private Bitmap promptBgBitmap;

    /* renamed from: i, reason: from kotlin metadata */
    private ConcurrentHashMap<String, ArrayList<Imagery>> mapOfIdToImagery = new ConcurrentHashMap<>();

    /* renamed from: m */
    private MutableLiveData<Integer> currentViewState = new MutableLiveData<>();

    /* renamed from: C */
    private HashMap<Integer, Bitmap> mapOfWhiteModel = new HashMap<>();

    /* renamed from: F */
    private final MutableLiveData<Boolean> hideTopAreaLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$a;", "", "", "needUseCache", "Z", "a", "()Z", "b", "(Z)V", "", "AIGC_AD_PLAY_QUALIFICATION_CAN_PLAY", "I", "AIGC_AD_PLAY_QUALIFICATION_INVALID", "AIGC_AD_PLAY_QUALIFICATION_OVER_FREQUENCY_LIMIT", "ITEM_IN_FEMALE_MALE_WHITE_MODEL_LIST", "ITEM_IN_FEMALE_WHITE_MODEL_LIST", "ITEM_IN_MALE_WHITE_MODEL_LIST", "ITEM_IN_NO_WHITE_MODEL_LIST", "PLAY_AD_SCENE_ID", "REQUEST_INDEX_FEMALE_MODEL_LIST", "REQUEST_INDEX_FILAMENT_SO", "REQUEST_INDEX_IMAGERY_DETAILS", "REQUEST_INDEX_LIGHT_SO", "REQUEST_INDEX_MALE_MODEL_LIST", "REQUEST_LOADING_MIN_DURATION_MS", "REQUEST_PRELOADING_PAG", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return SuitCreateTechFragmentViewModel.f330803z0;
        }

        public final void b(boolean z16) {
            SuitCreateTechFragmentViewModel.f330803z0 = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$e", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements gl0.b {

        /* renamed from: b */
        final /* synthetic */ int f330835b;

        e(int i3) {
            this.f330835b = i3;
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            QLog.i("SuitCreateTechFragmentViewModel", 1, "onComplete after checkSoAndInitFilament " + isSuccess + ", " + downloadSo + ", " + errCode + ", " + errMsg);
            SuitCreateTechFragmentViewModel.this.k2().set(this.f330835b, Boolean.valueOf(isSuccess));
            SuitCreateTechFragmentViewModel.this.j2().set(this.f330835b, Boolean.TRUE);
            SuitCreateTechFragmentViewModel.this.c2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$f", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements gl0.b {

        /* renamed from: b */
        final /* synthetic */ int f330837b;

        f(int i3) {
            this.f330837b = i3;
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            QLog.i("SuitCreateTechFragmentViewModel", 1, "onComplete after checkSoAndInitLightSdk " + isSuccess + ", " + downloadSo);
            SuitCreateTechFragmentViewModel.this.k2().set(this.f330837b, Boolean.valueOf(isSuccess));
            SuitCreateTechFragmentViewModel.this.j2().set(this.f330837b, Boolean.TRUE);
            SuitCreateTechFragmentViewModel.this.c2();
        }
    }

    public SuitCreateTechFragmentViewModel() {
        List<Boolean> mutableListOf;
        List<Boolean> mutableListOf2;
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        this._ticketNumLiveData = mutableLiveData;
        this.ticketNumLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._playAdQualificationLiveData = mutableLiveData2;
        this.playAdQualificationLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._ticketVisibleLiveData = mutableLiveData3;
        this.ticketVisibleLiveData = mutableLiveData3;
        MutableLiveData<az> mutableLiveData4 = new MutableLiveData<>();
        this._previewStoreItem = mutableLiveData4;
        this.previewStoreItem = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._ugcId = mutableLiveData5;
        this.ugcId = mutableLiveData5;
        this.customPromptLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._successEvent = mutableLiveData6;
        this.successEvent = mutableLiveData6;
        Boolean bool = Boolean.FALSE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bool, bool, bool, bool, bool, bool);
        this.apiRequestStatus = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(bool, bool, bool, bool, bool, bool);
        this.apiResultStatus = mutableListOf2;
        this.isOfficial = true;
        this.description = "";
        this.prompt = "";
        this.name = "";
        this.clothNumber = 4;
        this.useCacheAvatarDataRsp = true;
        this.avatarType = 1;
        MutableLiveData<AIGCFeedItemInfo2> mutableLiveData7 = new MutableLiveData<>();
        this._fetchFeedSuccessEvent = mutableLiveData7;
        this.fetchFeedSuccessEvent = mutableLiveData7;
    }

    public final List<String> A2(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!new File(ZPlanPAGLoader.f369875a.g(str, false)).exists()) {
                arrayList.add(str);
            }
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "getNeedDownloadUrlList size " + arrayList.size());
        return arrayList;
    }

    public final String N2(String methodName) {
        com.tencent.mobileqq.zplan.aigc.helper.h hVar = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a;
        if (hVar.k(methodName)) {
            return com.tencent.mobileqq.zplan.aigc.helper.h.i(hVar, methodName, null, 2, null);
        }
        return "";
    }

    public final boolean T2(gl0.b listener, boolean downloadSo) {
        Object m476constructorimpl;
        String aEResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE);
        String aEResUnzipFinalPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_PAG);
        QLog.i("SuitCreateTechFragmentViewModel", 1, "loadLightSdkSoByAERes dir : " + aEResUnzipFinalPath);
        if (aEResUnzipFinalPath == null || aEResUnzipFinalPath.length() == 0) {
            QLog.e("SuitCreateTechFragmentViewModel", 1, "soDir is empty!!!!!");
            return false;
        }
        if (aEResUnzipFinalPath2 == null || aEResUnzipFinalPath2.length() == 0) {
            QLog.e("SuitCreateTechFragmentViewModel", 1, "pagSoDir is empty!!!!!");
            return false;
        }
        String str = aEResUnzipFinalPath + AECameraConstants.LIB_LIGHT;
        if (!new File(str).exists()) {
            return false;
        }
        String str2 = aEResUnzipFinalPath2 + AECameraConstants.LIB_PAG;
        if (!new File(str2).exists()) {
            return false;
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "loadLightSdkSoByAERes soPath: " + str);
        try {
            Result.Companion companion = Result.INSTANCE;
            System.load(str2);
            System.load(str);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            QLog.i("SuitCreateTechFragmentViewModel", 1, "loadLightSdkSoByAERes success");
            if (listener != null) {
                b.a.a(listener, true, downloadSo, 0, null, 8, null);
            }
            return true;
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.i("SuitCreateTechFragmentViewModel", 1, "loadLightSdkSoByAERes fail : " + m479exceptionOrNullimpl);
            if (listener != null) {
                listener.a(false, downloadSo, -1, "System.load error, " + m479exceptionOrNullimpl.getMessage());
            }
        }
        return false;
    }

    private final boolean U2(int requestIndex) {
        if (!this.apiResultStatus.get(requestIndex).booleanValue()) {
            return true;
        }
        this.apiRequestStatus.set(requestIndex, Boolean.TRUE);
        c2();
        return false;
    }

    public final void W2(l rsp) {
        List<Imagery> shuffled;
        ArrayList arrayList = new ArrayList();
        m[] mVarArr = rsp.f438253b;
        Intrinsics.checkNotNullExpressionValue(mVarArr, "rsp.imagerys");
        for (m mVar : mVarArr) {
            arrayList.add(new Imagery(mVar.f438256a, mVar.f438257b, mVar.f438258c, mVar.f438259d, mVar.f438260e, mVar.f438261f, null, mVar.f438262g, 64, null));
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "requestImageryDetails: " + arrayList.size());
        shuffled = CollectionsKt__CollectionsJVMKt.shuffled(arrayList);
        this.imageryList = shuffled;
    }

    private final void a3(int i3, List<String> list, List<String> list2) {
        vk3.a aVar = this.pagDownloadListener;
        if (aVar != null) {
            ZPlanPAGLoader.f369875a.k(aVar);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$preLoadingPagFiles$2(list, list2, this, i3, null), 3, null);
    }

    public static final void d2(SuitCreateTechFragmentViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._successEvent.postValue(Boolean.TRUE);
    }

    private final void d3(int requestIndex, boolean needRefreshUI) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$requestImageryDetails$1(this, requestIndex, needRefreshUI, null), 3, null);
    }

    private final void e2(gl0.b listener) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE, new b(listener));
    }

    public final void f2(gl0.b listener) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_PAG, new c(listener, this));
    }

    private final void g3(int requestIndex) {
        ZPlanFilamentLoadSoUtil.INSTANCE.downloadAndLoadSo(new e(requestIndex));
    }

    private final void h3(int requestIndex) {
        e2(new f(requestIndex));
    }

    private final void j3(int requestIndex, boolean needRefreshUI) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$requestWhiteModelList$1(requestIndex, this, needRefreshUI, null), 3, null);
    }

    public final void A3(Bitmap bitmap) {
        this.promptBgBitmap = bitmap;
    }

    /* renamed from: B2, reason: from getter */
    public final boolean getNeedFromNewPreview() {
        return this.needFromNewPreview;
    }

    /* renamed from: C2, reason: from getter */
    public final long getPerformanceTimeStamp() {
        return this.performanceTimeStamp;
    }

    public final void C3(Bitmap bitmap) {
        this.selectBitmap = bitmap;
    }

    /* renamed from: D2, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public final void D3(Imagery imagery) {
        this.selectImagery = imagery;
    }

    /* renamed from: E2, reason: from getter */
    public final Bitmap getSelectBitmap() {
        return this.selectBitmap;
    }

    public final void E3(SuitWhiteModelItem suitWhiteModelItem) {
        this.selectedWhiteModelItem = suitWhiteModelItem;
    }

    /* renamed from: F2, reason: from getter */
    public final Imagery getSelectImagery() {
        return this.selectImagery;
    }

    public final void F3(boolean z16) {
        this.isSwitchingFragment = z16;
    }

    /* renamed from: G2, reason: from getter */
    public final SuitWhiteModelItem getSelectedWhiteModelItem() {
        return this.selectedWhiteModelItem;
    }

    public final void G3(long j3) {
        this._ugcId.postValue(Long.valueOf(j3));
    }

    /* renamed from: H2, reason: from getter */
    public final AIGCFeedItemInfo2 getShowFeedInfo() {
        return this.showFeedInfo;
    }

    public final void H3(boolean z16) {
        this.useCacheAvatarDataRsp = z16;
    }

    public final LiveData<Boolean> I2() {
        return this.successEvent;
    }

    public final void I3(long j3) {
        this.whiteModelUgcId = j3;
    }

    public final LiveData<Long> J2() {
        return this.ticketNumLiveData;
    }

    public final void J3(boolean bShow) {
        this._ticketVisibleLiveData.postValue(Boolean.valueOf(bShow));
    }

    public final LiveData<Boolean> K2() {
        return this.ticketVisibleLiveData;
    }

    public final void K3(ArrayList<SuitWhiteModelItem> r95, ArrayList<Imagery> imagerys) {
        boolean contains;
        Intrinsics.checkNotNullParameter(r95, "models");
        Intrinsics.checkNotNullParameter(imagerys, "imagerys");
        synchronized (this.mapOfIdToImagery) {
            this.mapOfIdToImagery.clear();
            QLog.i("SuitCreateTechFragmentViewModel", 1, "syncModelAndImagery " + r95.size() + "," + imagerys.size());
            if ((!r95.isEmpty()) && (!imagerys.isEmpty())) {
                for (SuitWhiteModelItem suitWhiteModelItem : r95) {
                    for (Imagery imagery : imagerys) {
                        int[] itemIds = imagery.getItemIds();
                        boolean z16 = false;
                        if (itemIds != null) {
                            contains = ArraysKt___ArraysKt.contains(itemIds, Integer.parseInt(suitWhiteModelItem.getItemId()));
                            if (contains) {
                                z16 = true;
                            }
                        }
                        if (z16) {
                            ArrayList<Imagery> arrayList = this.mapOfIdToImagery.get(suitWhiteModelItem.getItemId());
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            if (!arrayList.contains(imagery)) {
                                arrayList.add(imagery);
                            }
                            this.mapOfIdToImagery.put(suitWhiteModelItem.getItemId(), arrayList);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long L2() {
        Long value = this.ugcId.getValue();
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public final void L3(int r46) {
        this._ticketNumLiveData.postValue(Long.valueOf(r46));
    }

    /* renamed from: M2, reason: from getter */
    public final boolean getUseCacheAvatarDataRsp() {
        return this.useCacheAvatarDataRsp;
    }

    public final List<SuitWhiteModelItem> O2() {
        return this.whiteModeList;
    }

    /* renamed from: P2, reason: from getter */
    public final long getWhiteModelUgcId() {
        return this.whiteModelUgcId;
    }

    /* renamed from: R2, reason: from getter */
    public final boolean getIsOfficial() {
        return this.isOfficial;
    }

    /* renamed from: S2, reason: from getter */
    public final boolean getIsSwitchingFragment() {
        return this.isSwitchingFragment;
    }

    public final int b2(String itemId) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        List<SuitWhiteModelItem> list = this.whiteModeList;
        if (list != null) {
            z16 = false;
            for (SuitWhiteModelItem suitWhiteModelItem : list) {
                if ((suitWhiteModelItem.getItemId().length() > 0) && Intrinsics.areEqual(suitWhiteModelItem.getItemId(), itemId)) {
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "itemId is in male whiteModel");
                    z16 = true;
                }
            }
        } else {
            z16 = false;
        }
        List<SuitWhiteModelItem> list2 = this.femaleWhiteModeList;
        if (list2 != null) {
            z17 = false;
            for (SuitWhiteModelItem suitWhiteModelItem2 : list2) {
                if ((suitWhiteModelItem2.getItemId().length() > 0) && Intrinsics.areEqual(suitWhiteModelItem2.getItemId(), itemId)) {
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "itemId is in female whiteModel");
                    z17 = true;
                }
            }
        } else {
            z17 = false;
        }
        if (z17 && z16) {
            return 3;
        }
        if (z17) {
            return 1;
        }
        return z16 ? 2 : 0;
    }

    public final void b3(com.tencent.mobileqq.zootopia.api.e<String> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$refreshTicketNum$1(callback, this, null), 3, null);
    }

    public final void c2() {
        String joinToString$default;
        String joinToString$default2;
        boolean z16 = this.isLoadingSucceed;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.apiRequestStatus, null, null, null, 0, null, null, 63, null);
        QLog.i("SuitCreateTechFragmentViewModel", 1, "isLoadingSucceed:" + z16 + " apiRequestStatus: " + joinToString$default);
        if (this.isLoadingSucceed) {
            return;
        }
        List<Boolean> list = this.apiRequestStatus;
        Boolean bool = Boolean.FALSE;
        if (list.contains(bool)) {
            return;
        }
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(this.apiResultStatus, null, null, null, 0, null, null, 63, null);
        QLog.i("SuitCreateTechFragmentViewModel", 1, "apiResultStatus: " + joinToString$default2);
        if (!this.apiResultStatus.contains(bool) && this.whiteModeList != null && this.femaleWhiteModeList != null && this.imageryList != null) {
            this.isLoadingSucceed = true;
            if (v2() == UEAvatarGender.MALE.getIndex()) {
                List<SuitWhiteModelItem> list2 = this.whiteModeList;
                Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem> }");
                List<Imagery> list3 = this.imageryList;
                Intrinsics.checkNotNull(list3, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.zplan.aigc.data.Imagery>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.zplan.aigc.data.Imagery> }");
                K3((ArrayList) list2, (ArrayList) list3);
            } else {
                List<SuitWhiteModelItem> list4 = this.femaleWhiteModeList;
                Intrinsics.checkNotNull(list4, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem> }");
                List<Imagery> list5 = this.imageryList;
                Intrinsics.checkNotNull(list5, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.zplan.aigc.data.Imagery>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.zplan.aigc.data.Imagery> }");
                K3((ArrayList) list4, (ArrayList) list5);
            }
            com.tencent.qav.thread.a.d().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.b
                @Override // java.lang.Runnable
                public final void run() {
                    SuitCreateTechFragmentViewModel.d2(SuitCreateTechFragmentViewModel.this);
                }
            }, Math.max(2040 - (System.currentTimeMillis() - this.requestBeginTimeMs), 0L));
        } else {
            this._successEvent.postValue(bool);
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "resource already ");
    }

    public final void f3() {
        QLog.i("SuitCreateTechFragmentViewModel", 1, "refreshSingleFeed " + this.whiteModelUgcId);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$requestSingleFeed$1(this, null), 3, null);
    }

    public final void g2() {
        QLog.i("SuitCreateTechFragmentViewModel", 1, "fetchDataQuiet");
        d3(2, false);
        j3(0, false);
        j3(1, false);
    }

    public final void h2() {
        QLog.i("SuitCreateTechFragmentViewModel", 1, "fetchData");
        this.currentViewState.postValue(-1);
        this.requestBeginTimeMs = System.currentTimeMillis();
        Collections.fill(this.apiRequestStatus, Boolean.FALSE);
        com.tencent.mobileqq.zplan.aigc.utils.c cVar = com.tencent.mobileqq.zplan.aigc.utils.c.f330692a;
        a3(4, cVar.b(), cVar.a());
        if (U2(0)) {
            k3(this, 0, false, 2, null);
        }
        if (U2(1)) {
            k3(this, 1, false, 2, null);
        }
        if (U2(2)) {
            e3(this, 2, false, 2, null);
        }
        if (U2(3)) {
            g3(3);
        }
        if (U2(5)) {
            h3(5);
        }
    }

    /* renamed from: i2, reason: from getter */
    public final AigcPreviewParams getAigcPreviewParams() {
        return this.aigcPreviewParams;
    }

    public final void i3(int r85, com.tencent.mobileqq.zootopia.api.e<Integer> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateTechFragmentViewModel$requestWatchAdQualification$1(r85, callback, this, null), 3, null);
    }

    public final List<Boolean> j2() {
        return this.apiRequestStatus;
    }

    public final List<Boolean> k2() {
        return this.apiResultStatus;
    }

    /* renamed from: l2, reason: from getter */
    public final int getAvatarType() {
        return this.avatarType;
    }

    public final void l3(AigcPreviewParams aigcPreviewParams) {
        this.aigcPreviewParams = aigcPreviewParams;
    }

    /* renamed from: m2, reason: from getter */
    public final int getClothNumber() {
        return this.clothNumber;
    }

    public final void m3(int i3) {
        this.avatarType = i3;
    }

    /* renamed from: n2, reason: from getter */
    public final int getCurrentItemId() {
        return this.currentItemId;
    }

    public final void n3(int i3) {
        this.clothNumber = i3;
    }

    public final MutableLiveData<Integer> o2() {
        return this.currentViewState;
    }

    public final void o3(int i3) {
        this.currentItemId = i3;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        vk3.a aVar = this.pagDownloadListener;
        if (aVar != null) {
            ZPlanPAGLoader.f369875a.k(aVar);
        }
    }

    public final MutableLiveData<Imagery> p2() {
        return this.customPromptLiveData;
    }

    public final void p3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    /* renamed from: q2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final void q3(URLDrawable uRLDrawable) {
        this.feedClothDrawable = uRLDrawable;
    }

    public final List<SuitWhiteModelItem> r2() {
        return this.femaleWhiteModeList;
    }

    public final void r3(boolean z16) {
        this.firstNeedWhiteModel = z16;
    }

    public final LiveData<AIGCFeedItemInfo2> s2() {
        return this.fetchFeedSuccessEvent;
    }

    public final void s3(boolean z16) {
        this.forceUseSavedAvatar = z16;
    }

    /* renamed from: t2, reason: from getter */
    public final boolean getFirstNeedWhiteModel() {
        return this.firstNeedWhiteModel;
    }

    public final void t3(boolean z16) {
        this.isFromUserEdit = z16;
    }

    /* renamed from: u2, reason: from getter */
    public final boolean getForceUseSavedAvatar() {
        return this.forceUseSavedAvatar;
    }

    public final void u3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final int v2() {
        return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b().getIndex();
    }

    public final void v3(boolean z16) {
        this.needFromNewPreview = z16;
    }

    public final MutableLiveData<Boolean> w2() {
        return this.hideTopAreaLiveData;
    }

    public final void w3(boolean z16) {
        this.isOfficial = z16;
    }

    public final ConcurrentHashMap<String, ArrayList<Imagery>> x2() {
        return this.mapOfIdToImagery;
    }

    public final void x3(vk3.a aVar) {
        this.pagDownloadListener = aVar;
    }

    public final HashMap<Integer, Bitmap> y2() {
        return this.mapOfWhiteModel;
    }

    public final void y3(long j3) {
        this.performanceTimeStamp = j3;
    }

    /* renamed from: z2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final void z3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prompt = str;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: e */
        final /* synthetic */ gl0.b f330831e;

        b(gl0.b bVar) {
            this.f330831e = bVar;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int r152) {
            if (Intrinsics.areEqual(aeResInfo != null ? aeResInfo.agentType : null, AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE)) {
                if (r152 != 0 && r152 != 1) {
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "downloadLightSoByAE fail, aeResInfo: " + aeResInfo + ", localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + r152);
                    b.a.a(this.f330831e, false, true, r152, null, 8, null);
                    return;
                }
                QLog.i("SuitCreateTechFragmentViewModel", 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + r152);
                SuitCreateTechFragmentViewModel.this.f2(this.f330831e);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$c", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d */
        final /* synthetic */ gl0.b f330832d;

        /* renamed from: e */
        final /* synthetic */ SuitCreateTechFragmentViewModel f330833e;

        c(gl0.b bVar, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel) {
            this.f330832d = bVar;
            this.f330833e = suitCreateTechFragmentViewModel;
        }

        public static final void b(SuitCreateTechFragmentViewModel this$0, gl0.b listener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            this$0.T2(listener, true);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int r152) {
            if (Intrinsics.areEqual(aeResInfo != null ? aeResInfo.agentType : null, AEResInfo.AGENT_TYPE_PAG)) {
                if (r152 != 0 && r152 != 1) {
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "downloadLightSoByAE fail, aeResInfo: " + aeResInfo + ", localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + r152);
                    b.a.a(this.f330832d, false, true, r152, null, 8, null);
                    return;
                }
                QLog.i("SuitCreateTechFragmentViewModel", 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + r152);
                t74.l lVar = t74.l.f435563a;
                final SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.f330833e;
                final gl0.b bVar = this.f330832d;
                lVar.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitCreateTechFragmentViewModel.c.b(SuitCreateTechFragmentViewModel.this, bVar);
                    }
                });
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }

    public final boolean Q2() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (!NetworkUtil.isNetworkAvailable()) {
                this._successEvent.postValue(Boolean.FALSE);
                QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist no network");
            } else {
                com.tencent.mobileqq.zplan.aigc.helper.h hVar = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a;
                if (!Intrinsics.areEqual(hVar.h("gender", "-1"), String.valueOf(v2()))) {
                    hVar.p("GetUGCTemplateInfo", "");
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist GetUGCTemplateInfo invalid cache");
                }
                UEAvatarGender uEAvatarGender = UEAvatarGender.MALE;
                File c16 = hVar.c("GetUGCTemplateInfo" + uEAvatarGender.getIndex());
                if (c16.exists()) {
                    ac c17 = ac.c(hVar.b(c16));
                    bn[] bnVarArr = c17.f440112a;
                    Intrinsics.checkNotNullExpressionValue(bnVarArr, "rsp.templateList");
                    if (!(bnVarArr.length == 0)) {
                        bn[] bnVarArr2 = c17.f440112a;
                        Intrinsics.checkNotNullExpressionValue(bnVarArr2, "rsp.templateList");
                        Y2(new AIGCTemplateInfo(bnVarArr2, c17.f440113b), uEAvatarGender.getIndex());
                        UEAvatarGender uEAvatarGender2 = UEAvatarGender.FEMALE;
                        File c18 = hVar.c("GetUGCTemplateInfo" + uEAvatarGender2.getIndex());
                        if (c18.exists()) {
                            ac c19 = ac.c(hVar.b(c18));
                            bn[] bnVarArr3 = c19.f440112a;
                            Intrinsics.checkNotNullExpressionValue(bnVarArr3, "rsp.templateList");
                            if (!(bnVarArr3.length == 0)) {
                                bn[] bnVarArr4 = c19.f440112a;
                                Intrinsics.checkNotNullExpressionValue(bnVarArr4, "rsp.templateList");
                                Y2(new AIGCTemplateInfo(bnVarArr4, c19.f440113b), uEAvatarGender2.getIndex());
                                File c26 = hVar.c("GetImageryDetails");
                                if (c26.exists()) {
                                    l rsp = l.c(hVar.b(c26));
                                    m[] mVarArr = rsp.f438253b;
                                    Intrinsics.checkNotNullExpressionValue(mVarArr, "rsp.imagerys");
                                    if (!(mVarArr.length == 0)) {
                                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                                        W2(rsp);
                                        if (!A2(com.tencent.mobileqq.zplan.aigc.utils.c.f330692a.b()).isEmpty()) {
                                            QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist pag need download");
                                        } else if (!ZPlanFilamentLoadSoUtil.INSTANCE.loadSoIfReady(new d())) {
                                            QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist filament so need download");
                                        } else if (!T2(null, false)) {
                                            QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist light so need download");
                                        } else {
                                            QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist true, cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                            List<Boolean> list = this.apiRequestStatus;
                                            Boolean bool = Boolean.TRUE;
                                            Collections.fill(list, bool);
                                            Collections.fill(this.apiResultStatus, bool);
                                            c2();
                                            return true;
                                        }
                                    }
                                } else {
                                    QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist GetImageryDetails need download");
                                }
                            } else {
                                QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist female rsp is empty, GetUGCTemplateInfo need download");
                            }
                        } else {
                            QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist GetUGCTemplateInfo need download");
                        }
                    } else {
                        QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist male rsp is empty, GetUGCTemplateInfo need download");
                    }
                } else {
                    QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist GetUGCTemplateInfo need download");
                }
            }
        } catch (Exception unused) {
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "isCacheExist false, cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return false;
    }

    public final AIGCFeedItemInfo2 V2(iu4.b feed) {
        QLog.i("SuitCreateTechFragmentViewModel", 1, "parseFeedRsp: " + feed);
        iu4.i iVar = feed.f408770i;
        LikeData likeData = iVar != null ? new LikeData(iVar.f408784a, iVar.f408785b) : null;
        long j3 = feed.f408762a;
        String str = feed.f408765d;
        Intrinsics.checkNotNullExpressionValue(str, "feed.name");
        String str2 = feed.f408766e;
        Intrinsics.checkNotNullExpressionValue(str2, "feed.desc");
        String str3 = feed.f408768g;
        Intrinsics.checkNotNullExpressionValue(str3, "feed.url");
        long j16 = feed.f408769h;
        String str4 = feed.f408772k;
        Intrinsics.checkNotNullExpressionValue(str4, "feed.authorName");
        String str5 = feed.f408773l;
        Intrinsics.checkNotNullExpressionValue(str5, "feed.authorHeadUrl");
        AIGCFeedItemInfo2 aIGCFeedItemInfo2 = new AIGCFeedItemInfo2(0, j3, str, str2, str3, j16, str4, str5, String.valueOf(feed.f408771j), likeData, feed.f408763b, 0, null, 6144, null);
        this.showFeedInfo = aIGCFeedItemInfo2;
        Intrinsics.checkNotNull(aIGCFeedItemInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2");
        return aIGCFeedItemInfo2;
    }

    public final void Y2(AIGCTemplateInfo aigcTemplateInfo, int gender) {
        int i3;
        ArrayList arrayList = new ArrayList();
        bn[] templateInfoMap = aigcTemplateInfo.getTemplateInfoMap();
        int length = templateInfoMap.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            bn bnVar = templateInfoMap[i16];
            String str = bnVar.f440381f;
            Intrinsics.checkNotNullExpressionValue(str, "item.extInfo");
            if (str.length() > 0) {
                String str2 = bnVar.f440376a;
                Intrinsics.checkNotNullExpressionValue(str2, "item.itemId");
                if (str2.length() > 0) {
                    String str3 = bnVar.f440377b;
                    if (str3 == null) {
                        str3 = null;
                    }
                    String str4 = str3;
                    String str5 = bnVar.f440376a;
                    Intrinsics.checkNotNullExpressionValue(str5, "item.itemId");
                    az azVar = bnVar.f440382g;
                    long j3 = azVar.f440275b;
                    Intrinsics.checkNotNullExpressionValue(azVar, "item.storeItemInfo");
                    i3 = i16;
                    long M = r94.b.M(azVar);
                    String str6 = bnVar.f440381f;
                    Intrinsics.checkNotNullExpressionValue(str6, "item.extInfo");
                    arrayList.add(new SuitWhiteModelItem(bnVar, str4, str5, new AIGCWhiteModel(j3, M, str6, null), false, 16, null));
                    i16 = i3 + 1;
                }
            }
            i3 = i16;
            i16 = i3 + 1;
        }
        QLog.i("SuitCreateTechFragmentViewModel", 1, "requestWhiteModelList: " + arrayList.size());
        if (gender == UEAvatarGender.FEMALE.getIndex()) {
            this.femaleWhiteModeList = arrayList;
        } else {
            this.whiteModeList = arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c3(SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        suitCreateTechFragmentViewModel.b3(eVar);
    }

    static /* synthetic */ void e3(SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        suitCreateTechFragmentViewModel.d3(i3, z16);
    }

    static /* synthetic */ void k3(SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        suitCreateTechFragmentViewModel.j3(i3, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$d", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements gl0.b {
        d() {
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
        }
    }
}
