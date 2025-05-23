package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mm.libwxaudio.WxAudioNative;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.extension.MediaClipUseType;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.util.WeakReference;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipPlaceHolder;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00c2\u00012\u00020\u0001:\u0002\u00c3\u0001B\t\u00a2\u0006\u0006\b\u00c0\u0001\u0010\u00c1\u0001J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002Jq\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u000e\u001a\u00020\r26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J=\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ*\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0002J5\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J5\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\"J0\u0010)\u001a\u00020(2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002J<\u0010+\u001a\u00020(2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002Jc\u00107\u001a\u00020\u00142\u0006\u0010,\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010-2\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u000101j\n\u0012\u0004\u0012\u000202\u0018\u0001`32\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010:\u001a\u00020-2\u0006\u00109\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0016J\u000e\u0010<\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010>\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010=\u001a\u00020\rJ\u000e\u0010A\u001a\u00020\u00142\u0006\u0010@\u001a\u00020?J\u000e\u0010B\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tJ\b\u0010C\u001a\u0004\u0018\u00010\tJ\u000e\u0010E\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\rJ\u000e\u0010G\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u000bJ\u000e\u0010I\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u000bJ\u001e\u0010K\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010J\u001a\u00020-J\u0006\u0010L\u001a\u00020\u0014J\u0006\u0010M\u001a\u00020\u0014J\b\u0010N\u001a\u00020\u0014H\u0014J^\u0010O\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u000e\u001a\u00020\r26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fJ$\u0010R\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00070P2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\rJ\u0080\u0001\u0010X\u001a\u00020\u00142\u0006\u0010S\u001a\u00020-2\u0006\u00109\u001a\u00020-2\u0006\u0010T\u001a\u00020-2`\u0010\u0015\u001a\\\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(V\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u00140UJ\u0006\u0010Y\u001a\u00020\u0014JD\u0010\\\u001a\u00020\r2\b\u0010Z\u001a\u0004\u0018\u00010-2\u0006\u0010[\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$J\"\u0010^\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010]\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010a\u001a\u0004\u0018\u00010\u001c2\u0006\u0010`\u001a\u00020_JQ\u0010c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010Z\u001a\u00020-2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010b\u001a\u00020&2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\bc\u0010dR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\r0i8\u0006\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR&\u0010q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0o0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010gR)\u0010t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0o0i8\u0006\u00a2\u0006\f\n\u0004\br\u0010k\u001a\u0004\bs\u0010mR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020z0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R!\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020z0~8\u0006\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R.\u0010\u0089\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u008b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010gR&\u0010\u008e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020i8\u0006\u00a2\u0006\u000e\n\u0005\b\u008c\u0001\u0010k\u001a\u0005\b\u008d\u0001\u0010mR\u001d\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010gR!\u0010\u0094\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010i8\u0006\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010k\u001a\u0005\b\u0093\u0001\u0010mR(\u0010\u0098\u0001\u001a\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R)\u0010\u00a3\u0001\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u008a\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R)\u0010\u00a7\u0001\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a4\u0001\u0010\u008a\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a0\u0001\"\u0006\b\u00a6\u0001\u0010\u00a2\u0001R+\u0010\u00ae\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R1\u0010\u00b5\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00af\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001c\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R!\u0010\u00bf\u0001\u001a\u00030\u00ba\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00c4\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategoryList", "", "T1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "", "isFromClipping", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", IXWebBroadcastListener.STAGE_FINISHED, "success", "", "finishedCallback", "B2", "(Landroid/app/Activity;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/List;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/light/ClipPlaceHolder;", "u2", "metaMaterial", "placeHolders", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "f2", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalClips", "g2", "i2", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "aigcData", "", "totalCostTimeMs", "Landroid/content/Intent;", "d2", "selectedMedia", "c2", "intent", "", "templateId", "categoryId", "missionId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "Lkotlin/collections/ArrayList;", "holderInfos", "", "entranceType", "U1", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Integer;Z)V", "imageUrl", "k2", "getLogTag", "H2", "isFromTemplatePage", Constants.MMCCID, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "nextStepUIStateUpdater", "M2", "J2", "v2", "needDismiss", "F2", "mediaClip", "e2", "selectedMediaClip", "b2", "errMsg", "y2", "C2", "I2", "onCleared", NowProxyConstants.AccountInfoKey.A2, "Lmqq/util/WeakReference;", "weakActivity", "z2", "styleId", "safeId", "Lkotlin/Function4;", "result", "costTimeMs", "j2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "filePath", "isOpeningClip", "N2", "appliedTemplateMediaClip", "E2", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "W1", "durationUs", "X1", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;)Lcom/tencent/videocut/model/MediaClip;", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_onTemplateFragmentDismissLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_PARAM_2, "()Landroidx/lifecycle/LiveData;", "onTemplateFragmentDismissLiveData", "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Conn, "_onImageSelectFragmentDismissLiveData", "D", "q2", "onImageSelectFragmentDismissLiveData", "Lkotlinx/coroutines/CoroutineScope;", "E", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_onOpeningEndingUiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "G", "Lkotlinx/coroutines/flow/SharedFlow;", "r2", "()Lkotlinx/coroutines/flow/SharedFlow;", "onOpeningEndingUiEvent", "<set-?>", "H", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "w2", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "selectedMaterial", "I", "_openingEndingMaterialsLiveData", "J", "t2", "openingEndingMaterialsLiveData", "Lcom/tencent/mobileqq/wink/editor/openingending/b;", "K", "_updateOpeningEndingLiveData", "L", "x2", "updateOpeningEndingLiveData", "Landroidx/lifecycle/Observer;", "M", "Landroidx/lifecycle/Observer;", "openingEndingTemplateObserver", "N", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "P", "Z", "requestedOpeningEndingTemplate", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "p2", "()I", "L2", "(I)V", "lastSelectedOpeningIndex", BdhLogUtil.LogTag.Tag_Req, "o2", "K2", "lastSelectedEndingIndex", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", ICustomDataEditor.NUMBER_PARAM_2, "()Ljava/lang/String;", "setLastSelectedCategoryId", "(Ljava/lang/String;)V", "lastSelectedCategoryId", "T", "Ljava/util/List;", "m2", "()Ljava/util/List;", "setAigcStyleMaterials", "(Ljava/util/List;)V", "aigcStyleMaterials", "Lkotlinx/coroutines/Job;", "U", "Lkotlinx/coroutines/Job;", "aigcJob", "Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCService;", "V", "Lkotlin/Lazy;", "l2", "()Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCService;", "aigcService", "<init>", "()V", "W", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel extends BaseViewModel {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String X = u53.e.f438384a + "/opening_ending_cache";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, Boolean>> _onImageSelectFragmentDismissLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<Boolean, Boolean>> onImageSelectFragmentDismissLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<a> _onOpeningEndingUiEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<a> onOpeningEndingUiEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial selectedMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaCategory>> _openingEndingMaterialsLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<MetaCategory>> openingEndingMaterialsLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UpdateOpeningEndingData> _updateOpeningEndingLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UpdateOpeningEndingData> updateOpeningEndingLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Observer<List<MetaCategory>> openingEndingTemplateObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateUpdater;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean requestedOpeningEndingTemplate;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lastSelectedOpeningIndex;

    /* renamed from: R, reason: from kotlin metadata */
    private int lastSelectedEndingIndex;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private String lastSelectedCategoryId;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private List<MetaMaterial> aigcStyleMaterials;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Job aigcJob;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy aigcService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _onTemplateFragmentDismissLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> onTemplateFragmentDismissLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel$a;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "originMediaClips", "Lcom/tencent/mobileqq/wink/editor/openingending/b;", "updateInfo", "b", "Ln73/a;", "result", "a", "", "AIGC_STYLE_CATEGORY_ID", "Ljava/lang/String;", "AUTO_FILL_CONFIG_IMAGE", WxAudioNative.NativeCallBackInterface.KEY_GET_FILE_PATH_CACHE_DIR, "CLEAR_ENDING_MATERIAL_ID", "CLEAR_ENDING_MATERIAL_NAME", "CLEAR_OPENING_MATERIAL_ID", "CLEAR_OPENING_MATERIAL_NAME", "", "DEFAULT_SELECT_INDEX", "I", "ENDING_CATEGORY_ID", "", "EXTRACT_START_OFFSET", "J", "OPENING_CATEGORY_ID", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<MediaClip> a(@NotNull List<? extends MediaClip> originMediaClips, @NotNull AutoClipResult result) {
            Object first;
            Object last;
            Object last2;
            Object first2;
            Intrinsics.checkNotNullParameter(originMediaClips, "originMediaClips");
            Intrinsics.checkNotNullParameter(result, "result");
            if (originMediaClips.isEmpty()) {
                return result.c();
            }
            ArrayList arrayList = new ArrayList();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) originMediaClips);
            MediaClip mediaClip = (MediaClip) first;
            if (com.tencent.videocut.render.extension.e.r(mediaClip) == MediaClipUseType.OPENING) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) result.c());
                if (com.tencent.videocut.render.extension.e.r((MediaClip) first2) == MediaClipUseType.NORMAL) {
                    arrayList.add(mediaClip);
                }
            }
            arrayList.addAll(result.c());
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) originMediaClips);
            MediaClip mediaClip2 = (MediaClip) last;
            if (com.tencent.videocut.render.extension.e.r(mediaClip2) == MediaClipUseType.ENDING) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) result.c());
                if (com.tencent.videocut.render.extension.e.r((MediaClip) last2) == MediaClipUseType.NORMAL) {
                    arrayList.add(mediaClip2);
                }
            }
            return arrayList;
        }

        @NotNull
        public final List<MediaClip> b(@NotNull List<? extends MediaClip> originMediaClips, @NotNull UpdateOpeningEndingData updateInfo) {
            List<MediaClip> mutableList;
            Object last;
            Object first;
            Intrinsics.checkNotNullParameter(originMediaClips, "originMediaClips");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) originMediaClips);
            if (updateInfo.getIsOpeningClip()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
                if (com.tencent.videocut.render.extension.e.r((MediaClip) first) == MediaClipUseType.OPENING) {
                    CollectionsKt__MutableCollectionsKt.removeFirst(mutableList);
                }
                MediaClip mediaClip = updateInfo.getMediaClip();
                if (mediaClip != null) {
                    mutableList.add(0, mediaClip);
                }
            } else {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
                if (com.tencent.videocut.render.extension.e.r((MediaClip) last) == MediaClipUseType.ENDING) {
                    CollectionsKt__MutableCollectionsKt.removeLast(mutableList);
                }
                MediaClip mediaClip2 = updateInfo.getMediaClip();
                if (mediaClip2 != null) {
                    mutableList.add(mediaClip2);
                }
            }
            return mutableList;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            MetaMaterial it = (MetaMaterial) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Integer valueOf = Integer.valueOf(com.tencent.mobileqq.wink.editor.c.e0(it));
            MetaMaterial it5 = (MetaMaterial) t17;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(com.tencent.mobileqq.wink.editor.c.e0(it5)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkEditorOpeningEndingViewModel f321344d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function4 f321345e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineExceptionHandler.Companion companion, WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, Function4 function4) {
            super(companion);
            this.f321344d = winkEditorOpeningEndingViewModel;
            this.f321345e = function4;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkEditorOpeningEndingViewModel", "generateAigcImage exception: " + stackTraceToString);
            if (!(exception instanceof CancellationException)) {
                this.f321345e.invoke(Boolean.FALSE, this.f321344d.l2().f(exception), "", 0L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkEditorOpeningEndingViewModel f321346d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CoroutineExceptionHandler.Companion companion, WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel) {
            super(companion);
            this.f321346d = winkEditorOpeningEndingViewModel;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkEditorOpeningEndingViewModel", "handleAigcTemplate exception: " + stackTraceToString);
            if (!(exception instanceof CancellationException)) {
                this.f321346d.y2(true, false, this.f321346d.l2().f(exception));
            }
        }
    }

    public WinkEditorOpeningEndingViewModel() {
        Lazy lazy;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._onTemplateFragmentDismissLiveData = mutableLiveData;
        this.onTemplateFragmentDismissLiveData = mutableLiveData;
        MutableLiveData<Pair<Boolean, Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._onImageSelectFragmentDismissLiveData = mutableLiveData2;
        this.onImageSelectFragmentDismissLiveData = mutableLiveData2;
        this.viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        MutableSharedFlow<a> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._onOpeningEndingUiEvent = MutableSharedFlow$default;
        this.onOpeningEndingUiEvent = MutableSharedFlow$default;
        MutableLiveData<List<MetaCategory>> mutableLiveData3 = new MutableLiveData<>();
        this._openingEndingMaterialsLiveData = mutableLiveData3;
        this.openingEndingMaterialsLiveData = mutableLiveData3;
        MutableLiveData<UpdateOpeningEndingData> mutableLiveData4 = new MutableLiveData<>();
        this._updateOpeningEndingLiveData = mutableLiveData4;
        this.updateOpeningEndingLiveData = mutableLiveData4;
        this.lastSelectedOpeningIndex = 1;
        this.lastSelectedEndingIndex = 1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIGCService>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$aigcService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkAIGCService invoke() {
                WinkAIGCService winkAIGCService = new WinkAIGCService();
                winkAIGCService.e();
                return winkAIGCService;
            }
        });
        this.aigcService = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B2(Activity activity, MetaMaterial metaMaterial, List<? extends MediaClip> list, boolean z16, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super Unit> continuation) {
        WinkEditorOpeningEndingViewModel$handleTemplateJump$1 winkEditorOpeningEndingViewModel$handleTemplateJump$1;
        Object coroutine_suspended;
        int i3;
        Integer num;
        Object f26;
        final Function2<? super Boolean, ? super Boolean, Unit> function22;
        List<ClipPlaceHolder> list2;
        boolean z17;
        final Activity activity2;
        WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b bVar;
        WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper;
        MetaMaterial metaMaterial2 = metaMaterial;
        if (continuation instanceof WinkEditorOpeningEndingViewModel$handleTemplateJump$1) {
            winkEditorOpeningEndingViewModel$handleTemplateJump$1 = (WinkEditorOpeningEndingViewModel$handleTemplateJump$1) continuation;
            int i16 = winkEditorOpeningEndingViewModel$handleTemplateJump$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkEditorOpeningEndingViewModel$handleTemplateJump$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkEditorOpeningEndingViewModel$handleTemplateJump$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkEditorOpeningEndingViewModel$handleTemplateJump$1.label;
                WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper2 = null;
                if (i3 == 0) {
                    if (i3 == 1) {
                        boolean z18 = winkEditorOpeningEndingViewModel$handleTemplateJump$1.Z$0;
                        list2 = (List) winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$4;
                        function22 = (Function2) winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$3;
                        MetaMaterial metaMaterial3 = (MetaMaterial) winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$2;
                        Activity activity3 = (Activity) winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$1;
                        WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel2 = (WinkEditorOpeningEndingViewModel) winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        activity2 = activity3;
                        z17 = z18;
                        metaMaterial2 = metaMaterial3;
                        winkEditorOpeningEndingViewModel = winkEditorOpeningEndingViewModel2;
                        f26 = obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<ClipPlaceHolder> u26 = u2(metaMaterial2);
                    if (u26 != null) {
                        num = Boxing.boxInt(u26.size());
                    } else {
                        num = null;
                    }
                    w53.b.a("WinkEditorOpeningEndingViewModel", "fillTemplate placeHolders size: " + num);
                    if (u26 == null) {
                        function2.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$0 = this;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$1 = activity;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$2 = metaMaterial2;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$3 = function2;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.L$4 = u26;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.Z$0 = z16;
                    winkEditorOpeningEndingViewModel$handleTemplateJump$1.label = 1;
                    f26 = f2(metaMaterial2, u26, list, winkEditorOpeningEndingViewModel$handleTemplateJump$1);
                    if (f26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function22 = function2;
                    list2 = u26;
                    z17 = z16;
                    activity2 = activity;
                    winkEditorOpeningEndingViewModel = this;
                }
                List<? extends LocalMediaInfo> list3 = (List) f26;
                final Intent c26 = winkEditorOpeningEndingViewModel.c2(activity2, metaMaterial2, list2, list3, z17);
                com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.a();
                bVar = winkEditorOpeningEndingViewModel.nextStepUIStateUpdater;
                if (bVar != null) {
                    winkMediaPickerNextStepHelper2 = new WinkMediaPickerNextStepHelper(bVar);
                }
                winkMediaPickerNextStepHelper = winkMediaPickerNextStepHelper2;
                if (winkMediaPickerNextStepHelper != null) {
                    winkMediaPickerNextStepHelper.h(activity2, TabType.ALL_MEDIA, list3, false, MediaPickerScene.TEMPLATE_LIBRARY, new TemplateLibraryData(metaMaterial2, false, 0), new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$handleTemplateJump$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                            invoke2(mediaPickerOutput);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull MediaPickerOutput output) {
                            Intrinsics.checkNotNullParameter(output, "output");
                            com.tencent.mobileqq.wink.picker.g.d(activity2, c26, output);
                            Function2<Boolean, Boolean, Unit> function23 = function22;
                            Boolean bool = Boolean.FALSE;
                            function23.invoke(bool, bool);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }
        winkEditorOpeningEndingViewModel$handleTemplateJump$1 = new WinkEditorOpeningEndingViewModel$handleTemplateJump$1(this, continuation);
        Object obj2 = winkEditorOpeningEndingViewModel$handleTemplateJump$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkEditorOpeningEndingViewModel$handleTemplateJump$1.label;
        WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper22 = null;
        if (i3 == 0) {
        }
        List<? extends LocalMediaInfo> list32 = (List) f26;
        final Intent c262 = winkEditorOpeningEndingViewModel.c2(activity2, metaMaterial2, list2, list32, z17);
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.a();
        bVar = winkEditorOpeningEndingViewModel.nextStepUIStateUpdater;
        if (bVar != null) {
        }
        winkMediaPickerNextStepHelper = winkMediaPickerNextStepHelper22;
        if (winkMediaPickerNextStepHelper != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(WinkEditorOpeningEndingViewModel this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<List<MetaCategory>> mutableLiveData = this$0._openingEndingMaterialsLiveData;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableLiveData.postValue(this$0.T1(it));
    }

    public static /* synthetic */ boolean O2(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, String str, boolean z16, boolean z17, String str2, String str3, OpeningEndingAigcData openingEndingAigcData, int i3, Object obj) {
        String str4;
        String str5;
        OpeningEndingAigcData openingEndingAigcData2;
        if ((i3 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 32) != 0) {
            openingEndingAigcData2 = null;
        } else {
            openingEndingAigcData2 = openingEndingAigcData;
        }
        return winkEditorOpeningEndingViewModel.N2(str, z16, z17, str4, str5, openingEndingAigcData2);
    }

    private final List<MetaCategory> T1(List<MetaCategory> metaCategoryList) {
        List<MetaMaterial> list;
        Object obj;
        ArrayList<MetaMaterial> arrayList;
        Object obj2;
        ArrayList<MetaMaterial> arrayList2;
        Object obj3;
        ArrayList<MetaMaterial> arrayList3;
        boolean z16;
        ArrayList arrayList4 = new ArrayList();
        List<MetaCategory> list2 = metaCategoryList;
        Iterator<T> it = list2.iterator();
        while (true) {
            list = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "opening")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MetaCategory metaCategory = (MetaCategory) obj;
        if (metaCategory != null) {
            arrayList = metaCategory.materials;
        } else {
            arrayList = null;
        }
        boolean z17 = true;
        if (arrayList != null) {
            ArrayList<MetaMaterial> arrayList5 = metaCategory.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList5, "openingCategory.materials");
            for (MetaMaterial material : arrayList5) {
                Intrinsics.checkNotNullExpressionValue(material, "material");
                com.tencent.mobileqq.wink.editor.c.o1(material, "opening");
                String str = metaCategory.name;
                Intrinsics.checkNotNullExpressionValue(str, "openingCategory.name");
                com.tencent.mobileqq.wink.editor.c.p1(material, str);
            }
            ArrayList<MetaMaterial> arrayList6 = metaCategory.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList6, "openingCategory.materials");
            if (!(arrayList6 instanceof Collection) || !arrayList6.isEmpty()) {
                Iterator<T> it5 = arrayList6.iterator();
                while (it5.hasNext()) {
                    if (Intrinsics.areEqual(((MetaMaterial) it5.next()).f30533id, "CLEAR_OPENING_MATERIAL_ID")) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                ArrayList<MetaMaterial> arrayList7 = metaCategory.materials;
                MetaMaterial metaMaterial = new MetaMaterial();
                metaMaterial.f30533id = "CLEAR_OPENING_MATERIAL_ID";
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "opening");
                com.tencent.mobileqq.wink.editor.c.B1(metaMaterial, "\u4e0d\u4f7f\u7528\u7247\u5934");
                Unit unit = Unit.INSTANCE;
                arrayList7.add(0, metaMaterial);
            }
            arrayList4.add(metaCategory);
        }
        Iterator<T> it6 = list2.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj2 = it6.next();
                if (Intrinsics.areEqual(((MetaCategory) obj2).f30532id, "ending")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        MetaCategory metaCategory2 = (MetaCategory) obj2;
        if (metaCategory2 != null) {
            arrayList2 = metaCategory2.materials;
        } else {
            arrayList2 = null;
        }
        if (arrayList2 != null) {
            ArrayList<MetaMaterial> arrayList8 = metaCategory2.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList8, "endingCategory.materials");
            for (MetaMaterial material2 : arrayList8) {
                Intrinsics.checkNotNullExpressionValue(material2, "material");
                com.tencent.mobileqq.wink.editor.c.o1(material2, "ending");
                String str2 = metaCategory2.name;
                Intrinsics.checkNotNullExpressionValue(str2, "endingCategory.name");
                com.tencent.mobileqq.wink.editor.c.p1(material2, str2);
            }
            ArrayList<MetaMaterial> arrayList9 = metaCategory2.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList9, "endingCategory.materials");
            if (!(arrayList9 instanceof Collection) || !arrayList9.isEmpty()) {
                Iterator<T> it7 = arrayList9.iterator();
                while (it7.hasNext()) {
                    if (Intrinsics.areEqual(((MetaMaterial) it7.next()).f30533id, "CLEAR_ENDING_MATERIAL_ID")) {
                        break;
                    }
                }
            }
            z17 = false;
            if (!z17) {
                ArrayList<MetaMaterial> arrayList10 = metaCategory2.materials;
                MetaMaterial metaMaterial2 = new MetaMaterial();
                metaMaterial2.f30533id = "CLEAR_ENDING_MATERIAL_ID";
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial2, "ending");
                com.tencent.mobileqq.wink.editor.c.B1(metaMaterial2, "\u4e0d\u4f7f\u7528\u7247\u5c3e");
                Unit unit2 = Unit.INSTANCE;
                arrayList10.add(0, metaMaterial2);
            }
            arrayList4.add(metaCategory2);
        }
        Iterator<T> it8 = list2.iterator();
        while (true) {
            if (it8.hasNext()) {
                obj3 = it8.next();
                if (Intrinsics.areEqual(((MetaCategory) obj3).f30532id, "aigc_style")) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        MetaCategory metaCategory3 = (MetaCategory) obj3;
        if (metaCategory3 != null && (arrayList3 = metaCategory3.materials) != null) {
            list = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new b());
        }
        this.aigcStyleMaterials = list;
        if (list != null) {
            Iterator<T> it9 = list.iterator();
            while (it9.hasNext()) {
                com.tencent.mobileqq.wink.editor.c.o1((MetaMaterial) it9.next(), "aigc_style");
            }
        }
        return arrayList4;
    }

    private final void U1(Intent intent, String templateId, String categoryId, String missionId, ArrayList<TemplateLibraryHolderInfo> holderInfos, Integer entranceType, boolean isFromClipping) {
        if (missionId != null) {
            intent.putExtra(QQWinkConstants.MISSION_ID, missionId);
        }
        intent.putExtra("template_holder_slot", holderInfos);
        if (entranceType != null) {
            intent.putExtra(QQWinkConstants.EDITOR_ENTRANCE, entranceType.intValue());
        }
        intent.putExtra(QQWinkConstants.IS_OPENING_ENDING_EDIT_MODE, true);
        intent.putExtra(QQWinkConstants.OPENING_ENDING_TEMPLATE_ID, templateId);
        intent.putExtra(QQWinkConstants.OPENING_ENDING_TEMPLATE_CATEGORY_ID, categoryId);
        intent.putExtra(QQWinkConstants.OPENING_ENDING_IS_FROM_CLIPPING_PAGE, isFromClipping);
        intent.putExtra("wink_output_route", WinkEditorOpeningEndingOutputRouter.ROUTE_PATH);
        intent.putExtra("wink_output_point", 2L);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, companion.g());
        companion.a(intent);
    }

    public static /* synthetic */ MediaClip Z1(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, String str, Boolean bool, String str2, String str3, long j3, OpeningEndingAigcData openingEndingAigcData, int i3, Object obj) {
        Boolean bool2;
        String str4;
        String str5;
        long j16;
        OpeningEndingAigcData openingEndingAigcData2 = null;
        if ((i3 & 2) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        if ((i3 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            j16 = 2500000;
        } else {
            j16 = j3;
        }
        if ((i3 & 32) == 0) {
            openingEndingAigcData2 = openingEndingAigcData;
        }
        return winkEditorOpeningEndingViewModel.X1(str, bool2, str4, str5, j16, openingEndingAigcData2);
    }

    private final Intent c2(Activity activity, MetaMaterial material, List<? extends ClipPlaceHolder> placeHolders, List<? extends LocalMediaInfo> selectedMedia, boolean isFromClipping) {
        String str;
        LocalMediaInfo localMediaInfo;
        Bundle extras;
        Intent intent = new Intent();
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null) {
            str = extras.getString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        } else {
            str = null;
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, str);
        intent.putExtra(QQWinkConstants.MEDIA_PICKER_SCENE, MediaPickerScene.TEMPLATE_LIBRARY);
        intent.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, material);
        ArrayList<TemplateLibraryHolderInfo> arrayList = new ArrayList<>();
        int size = placeHolders.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 < selectedMedia.size()) {
                localMediaInfo = selectedMedia.get(i3);
            } else {
                localMediaInfo = null;
            }
            arrayList.add(new TemplateLibraryHolderInfo(localMediaInfo, ((float) placeHolders.get(i3).contentDuration) / ((float) 1000000), ""));
        }
        U1(intent, material.f30533id, com.tencent.mobileqq.wink.editor.c.o(material), null, arrayList, null, isFromClipping);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent d2(Activity activity, MetaMaterial material, boolean isFromClipping, OpeningEndingAigcData aigcData, long totalCostTimeMs) {
        String str;
        Bundle extras;
        Intent intent = new Intent();
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null) {
            str = extras.getString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        } else {
            str = null;
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, str);
        intent.putExtra(QQWinkConstants.MEDIA_PICKER_SCENE, MediaPickerScene.TEMPLATE_LIBRARY);
        intent.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, material);
        intent.putExtra(QQWinkConstants.OPENING_ENDING_AIGC_DATA, aigcData);
        intent.putExtra(QQWinkConstants.IS_OPENING_ENDING_AIGC_TEMPLATE, true);
        intent.putExtra(QQWinkConstants.OPENING_ENDING_AIGC_GENERATE_COSTTIME, totalCostTimeMs);
        U1(intent, material.f30533id, com.tencent.mobileqq.wink.editor.c.o(material), null, null, null, isFromClipping);
        return intent;
    }

    private final Object f2(MetaMaterial metaMaterial, List<? extends ClipPlaceHolder> list, List<? extends MediaClip> list2, Continuation<? super List<? extends LocalMediaInfo>> continuation) {
        List<? extends MediaClip> list3;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (com.tencent.videocut.render.extension.e.r((MediaClip) obj) == MediaClipUseType.NORMAL) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        list3 = CollectionsKt___CollectionsKt.toList(arrayList);
        if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.k(metaMaterial), "image")) {
            return h2(list, list3, continuation);
        }
        return i2(list, list3, continuation);
    }

    private final List<LocalMediaInfo> g2(List<? extends ClipPlaceHolder> placeHolders, List<? extends MediaClip> normalClips) {
        String str;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : placeHolders) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ResourceModel resourceModel = normalClips.get(i3 % normalClips.size()).resource;
            if (resourceModel == null || (str = resourceModel.path) == null) {
                str = "";
            }
            arrayList.add(str);
            i3 = i16;
        }
        return com.tencent.mobileqq.wink.utils.o.f326724a.i(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x017f -> B:10:0x0185). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h2(List<? extends ClipPlaceHolder> list, List<? extends MediaClip> list2, Continuation<? super List<? extends LocalMediaInfo>> continuation) {
        WinkEditorOpeningEndingViewModel$fillTemplateByImage$1 winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
        Object coroutine_suspended;
        int i3;
        WinkEditorOpeningEndingViewModel$fillTemplateByImage$1 winkEditorOpeningEndingViewModel$fillTemplateByImage$12;
        WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel;
        Iterator it;
        ArrayList arrayList;
        WinkEditorOpeningEndingViewModel$fillTemplateByImage$1 winkEditorOpeningEndingViewModel$fillTemplateByImage$13;
        List<? extends ClipPlaceHolder> list3;
        List<? extends MediaClip> list4;
        long j3;
        String str;
        List<String> mutableListOf;
        Object firstOrNull;
        if (continuation instanceof WinkEditorOpeningEndingViewModel$fillTemplateByImage$1) {
            winkEditorOpeningEndingViewModel$fillTemplateByImage$1 = (WinkEditorOpeningEndingViewModel$fillTemplateByImage$1) continuation;
            int i16 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkEditorOpeningEndingViewModel$fillTemplateByImage$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkEditorOpeningEndingViewModel$fillTemplateByImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (Iterator) winkEditorOpeningEndingViewModel$fillTemplateByImage$1.L$4;
                        ?? r75 = (List) winkEditorOpeningEndingViewModel$fillTemplateByImage$1.L$3;
                        List<? extends MediaClip> list5 = (List) winkEditorOpeningEndingViewModel$fillTemplateByImage$1.L$2;
                        List<? extends ClipPlaceHolder> list6 = (List) winkEditorOpeningEndingViewModel$fillTemplateByImage$1.L$1;
                        WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel2 = (WinkEditorOpeningEndingViewModel) winkEditorOpeningEndingViewModel$fillTemplateByImage$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList2 = r75;
                        arrayList2.addAll(com.tencent.mobileqq.wink.utils.o.f326724a.i((List) obj));
                        winkEditorOpeningEndingViewModel$fillTemplateByImage$13 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
                        arrayList = arrayList2;
                        list4 = list5;
                        list3 = list6;
                        winkEditorOpeningEndingViewModel = winkEditorOpeningEndingViewModel2;
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
                            String[] strArr = new String[1];
                            ResourceModel resourceModel = ((MediaClip) entry.getKey()).resource;
                            if (resourceModel == null || (str = resourceModel.path) == null) {
                                str = "";
                            }
                            strArr[0] = str;
                            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(strArr);
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) oVar.i(mutableListOf));
                            LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
                            if (localMediaInfo != null) {
                                if (e93.i.I(localMediaInfo)) {
                                    ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                                    List<Long> list7 = (List) entry.getValue();
                                    String str2 = X;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.L$0 = winkEditorOpeningEndingViewModel;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.L$1 = list3;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.L$2 = list4;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.L$3 = arrayList;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.L$4 = it;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13.label = 1;
                                    Object E = extractCoverHelper.E(localMediaInfo, list7, 1080, str2, winkEditorOpeningEndingViewModel$fillTemplateByImage$13);
                                    if (E == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    list6 = list3;
                                    list5 = list4;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$1 = winkEditorOpeningEndingViewModel$fillTemplateByImage$13;
                                    obj = E;
                                    arrayList2 = arrayList;
                                    winkEditorOpeningEndingViewModel2 = winkEditorOpeningEndingViewModel;
                                    arrayList2.addAll(com.tencent.mobileqq.wink.utils.o.f326724a.i((List) obj));
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$13 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
                                    arrayList = arrayList2;
                                    list4 = list5;
                                    list3 = list6;
                                    winkEditorOpeningEndingViewModel = winkEditorOpeningEndingViewModel2;
                                    while (it.hasNext()) {
                                    }
                                } else {
                                    Iterator it5 = ((Iterable) entry.getValue()).iterator();
                                    while (it5.hasNext()) {
                                        ((Number) it5.next()).longValue();
                                        arrayList.add(localMediaInfo);
                                    }
                                }
                            }
                        }
                        if (arrayList.size() == list3.size()) {
                            w53.b.c("WinkEditorOpeningEndingViewModel", "fillTemplate failed: localMediaInfos size: " + arrayList.size() + ", placeHolder size: " + list3.size());
                            return winkEditorOpeningEndingViewModel.g2(list3, list4);
                        }
                        return arrayList;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it6 = list2.iterator();
                long j16 = 0;
                while (it6.hasNext()) {
                    ResourceModel resourceModel2 = ((MediaClip) it6.next()).resource;
                    if (resourceModel2 != null) {
                        j3 = resourceModel2.scaleDuration;
                    } else {
                        j3 = 0;
                    }
                    j16 += j3;
                }
                long j17 = 500000;
                long size = (j16 - 500000) / (list.size() + 1);
                int size2 = list.size();
                if (1 <= size2) {
                    int i17 = 1;
                    while (true) {
                        long j18 = (i17 * size) + j17;
                        Iterator<? extends MediaClip> it7 = list2.iterator();
                        long j19 = 0;
                        while (true) {
                            if (it7.hasNext()) {
                                MediaClip next = it7.next();
                                ResourceModel resourceModel3 = next.resource;
                                if (resourceModel3 == null) {
                                    w53.b.c("WinkEditorOpeningEndingViewModel", "fillTemplateByImage, resource is null");
                                } else {
                                    long j26 = resourceModel3.scaleDuration;
                                    winkEditorOpeningEndingViewModel$fillTemplateByImage$12 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
                                    long j27 = j18 - j19;
                                    j19 += j26;
                                    if (j27 >= 0 && j27 <= j26) {
                                        double d16 = ((j27 / j26) * resourceModel3.selectDuration) + resourceModel3.selectStart;
                                        if (!linkedHashMap.containsKey(next)) {
                                            linkedHashMap.put(next, new ArrayList());
                                        }
                                        List list8 = (List) linkedHashMap.get(next);
                                        if (list8 != null) {
                                            Boxing.boxBoolean(list8.add(Boxing.boxLong((long) d16)));
                                        }
                                    } else {
                                        winkEditorOpeningEndingViewModel$fillTemplateByImage$1 = winkEditorOpeningEndingViewModel$fillTemplateByImage$12;
                                    }
                                }
                            } else {
                                winkEditorOpeningEndingViewModel$fillTemplateByImage$12 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
                                break;
                            }
                        }
                        if (i17 == size2) {
                            break;
                        }
                        i17++;
                        winkEditorOpeningEndingViewModel$fillTemplateByImage$1 = winkEditorOpeningEndingViewModel$fillTemplateByImage$12;
                        j17 = 500000;
                    }
                } else {
                    winkEditorOpeningEndingViewModel$fillTemplateByImage$12 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1;
                }
                ArrayList arrayList3 = new ArrayList();
                winkEditorOpeningEndingViewModel = this;
                it = linkedHashMap.entrySet().iterator();
                arrayList = arrayList3;
                winkEditorOpeningEndingViewModel$fillTemplateByImage$13 = winkEditorOpeningEndingViewModel$fillTemplateByImage$12;
                list3 = list;
                list4 = list2;
                while (it.hasNext()) {
                }
                if (arrayList.size() == list3.size()) {
                }
            }
        }
        winkEditorOpeningEndingViewModel$fillTemplateByImage$1 = new WinkEditorOpeningEndingViewModel$fillTemplateByImage$1(this, continuation);
        Object obj2 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkEditorOpeningEndingViewModel$fillTemplateByImage$1.label;
        if (i3 == 0) {
        }
    }

    private final Object i2(List<? extends ClipPlaceHolder> list, List<? extends MediaClip> list2, Continuation<? super List<? extends LocalMediaInfo>> continuation) {
        int collectionSizeOrDefault;
        long j3;
        String str;
        long j16;
        List<? extends MediaClip> list3 = list2;
        Iterator<T> it = list3.iterator();
        long j17 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j16 = resourceModel.selectDuration;
            } else {
                j16 = 0;
            }
            j17 += j16;
        }
        long j18 = 500000;
        long size = (j17 - 500000) / list.size();
        com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list3.iterator();
        while (it5.hasNext()) {
            ResourceModel resourceModel2 = ((MediaClip) it5.next()).resource;
            if (resourceModel2 == null || (str = resourceModel2.path) == null) {
                str = "";
            }
            arrayList.add(str);
        }
        List<LocalMediaInfo> i3 = oVar.i(arrayList);
        if (i3.size() != list2.size()) {
            return h2(list, list2, continuation);
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = list.size();
        int i16 = 0;
        while (i16 < size2) {
            long j19 = list.get(i16).contentDuration;
            long j26 = (i16 * size) + j18;
            int size3 = list2.size();
            int i17 = 0;
            long j27 = 0;
            while (true) {
                if (i17 < size3) {
                    ResourceModel resourceModel3 = list2.get(i17).resource;
                    if (resourceModel3 == null) {
                        w53.b.c("WinkEditorOpeningEndingViewModel", "fillTemplateByVideo, resource is null");
                        j3 = size;
                    } else {
                        j3 = size;
                        long j28 = resourceModel3.selectDuration;
                        long j29 = j26 - j27;
                        j27 += j28;
                        if (j29 >= 0 && j29 <= j28) {
                            if (resourceModel3.type == MediaType.IMAGE) {
                                arrayList2.add(e93.i.b(i3.get(i17)));
                            } else {
                                long j36 = j28 - j29;
                                if (j19 <= j36) {
                                    LocalMediaInfo b16 = e93.i.b(i3.get(i17));
                                    b16.mStartTime = j29 / 1000;
                                    arrayList2.add(b16);
                                } else if (j19 > j36 && j19 <= j28) {
                                    LocalMediaInfo b17 = e93.i.b(i3.get(i17));
                                    b17.mStartTime = (j28 - j19) / 1000;
                                    arrayList2.add(b17);
                                } else {
                                    return h2(list, list2, continuation);
                                }
                            }
                        }
                    }
                    i17++;
                    size = j3;
                } else {
                    j3 = size;
                    break;
                }
            }
            i16++;
            size = j3;
            j18 = 500000;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k2(String imageUrl) {
        int lastIndexOf$default;
        String str;
        boolean z16;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) imageUrl, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            str = imageUrl.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = "";
        }
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (str.charAt(i3) == '?') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            str = str.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        String str2 = X;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = new File(str2, com.tencent.open.base.g.d(imageUrl) + str).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "File(CACHE_DIR, \"${MD5.t\u2026ageUrl)}$extension\").path");
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIGCService l2() {
        return (WinkAIGCService) this.aigcService.getValue();
    }

    private final List<ClipPlaceHolder> u2(MetaMaterial material) {
        boolean z16;
        int collectionSizeOrDefault;
        TemplatePreProcessConfig H0 = com.tencent.mobileqq.wink.editor.c.H0(material);
        if (H0 != null) {
            List<TemplatePreProcessConfig.Media> medias = H0.getMedias();
            if (medias != null && !medias.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                List<TemplatePreProcessConfig.Media> medias2 = H0.getMedias();
                Intrinsics.checkNotNullExpressionValue(medias2, "config.medias");
                List<TemplatePreProcessConfig.Media> list = medias2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (TemplatePreProcessConfig.Media media : list) {
                    arrayList.add(new ClipPlaceHolder(media.getDuration(), media.getFillMode(), media.getWidth(), media.getHeight(), media.getVolume()));
                }
                return arrayList;
            }
        }
        return com.tencent.mobileqq.wink.utils.n.f326718a.a(material);
    }

    public final void A2(@Nullable Activity activity, @NotNull List<? extends MediaClip> mediaClips, boolean isFromClipping, @NotNull Function2<? super Boolean, ? super Boolean, Unit> finishedCallback) {
        MetaMaterial metaMaterial;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        Intrinsics.checkNotNullParameter(finishedCallback, "finishedCallback");
        if (activity != null && (metaMaterial = this.selectedMaterial) != null) {
            Intrinsics.checkNotNull(metaMaterial);
            if (!Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_OPENING_MATERIAL_ID") && !Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_ENDING_MATERIAL_ID")) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorOpeningEndingViewModel$handleNextStep$1(metaMaterial, finishedCallback, this, activity, mediaClips, isFromClipping, null), 3, null);
                return;
            } else {
                Boolean bool = Boolean.TRUE;
                finishedCallback.invoke(bool, bool);
                return;
            }
        }
        finishedCallback.invoke(Boolean.TRUE, Boolean.FALSE);
    }

    public final void C2() {
        this.openingEndingTemplateObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingViewModel.D2(WinkEditorOpeningEndingViewModel.this, (List) obj);
            }
        };
        MutableLiveData<List<MetaCategory>> o16 = WinkEditorResourceManager.a1().o1();
        Observer<List<MetaCategory>> observer = this.openingEndingTemplateObserver;
        Intrinsics.checkNotNull(observer);
        o16.observeForever(observer);
        WinkEditorResourceManager.a1().c3();
    }

    public final void E2(@Nullable Activity activity, @Nullable MediaClip appliedTemplateMediaClip, boolean isFromClipping) {
        String str;
        String str2;
        Bundle extras;
        if (activity != null && appliedTemplateMediaClip != null) {
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.a();
            Intent intent = new Intent();
            if (com.tencent.videocut.render.extension.e.r(appliedTemplateMediaClip) == MediaClipUseType.OPENING) {
                str = "opening";
            } else {
                str = "ending";
            }
            String str3 = str;
            Intent intent2 = activity.getIntent();
            String str4 = null;
            if (intent2 != null && (extras = intent2.getExtras()) != null) {
                str2 = extras.getString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            } else {
                str2 = null;
            }
            intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, str2);
            ResourceModel resourceModel = appliedTemplateMediaClip.resource;
            if (resourceModel != null) {
                str4 = resourceModel.path;
            }
            intent.putExtra(QQWinkConstants.OPENING_ENDING_VIDEO_PATH, str4);
            OpeningEndingAigcData k3 = com.tencent.videocut.render.extension.e.k(appliedTemplateMediaClip);
            if (k3 != null) {
                intent.putExtra(QQWinkConstants.OPENING_ENDING_AIGC_DATA, k3);
                intent.putExtra(QQWinkConstants.IS_OPENING_ENDING_AIGC_TEMPLATE, true);
            }
            U1(intent, com.tencent.videocut.render.extension.e.p(appliedTemplateMediaClip), str3, com.tencent.videocut.render.extension.e.j(appliedTemplateMediaClip), null, 3, isFromClipping);
            Bundle extras2 = intent.getExtras();
            Intrinsics.checkNotNull(extras2);
            com.tencent.mobileqq.wink.f.v(activity, extras2);
            return;
        }
        w53.b.c("WinkEditorOpeningEndingViewModel", "jumpToOpeningEndingEditor failed: mediaClip or activity is null");
    }

    public final void F2(boolean needDismiss) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorOpeningEndingViewModel$needDismissTemplateFragment$1(this, needDismiss, null), 3, null);
    }

    public final void G2(boolean isFromClipping, boolean isFromTemplatePage) {
        this._onImageSelectFragmentDismissLiveData.postValue(TuplesKt.to(Boolean.valueOf(isFromClipping), Boolean.valueOf(isFromTemplatePage)));
    }

    public final void H2(boolean isFromClipping) {
        this._onTemplateFragmentDismissLiveData.postValue(Boolean.valueOf(isFromClipping));
    }

    public final void I2() {
        if (this.requestedOpeningEndingTemplate) {
            return;
        }
        this.requestedOpeningEndingTemplate = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkEditorOpeningEndingViewModel$requestOpeningEndingTemplateOnce$1(null), 3, null);
    }

    public final void J2(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "metaMaterial");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorOpeningEndingViewModel$selectMaterial$1(this, metaMaterial, null), 3, null);
        this.lastSelectedCategoryId = com.tencent.mobileqq.wink.editor.c.o(metaMaterial);
        this.selectedMaterial = metaMaterial;
    }

    public final void K2(int i3) {
        this.lastSelectedEndingIndex = i3;
    }

    public final void L2(int i3) {
        this.lastSelectedOpeningIndex = i3;
    }

    public final void M2(@NotNull com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateUpdater) {
        Intrinsics.checkNotNullParameter(nextStepUIStateUpdater, "nextStepUIStateUpdater");
        this.nextStepUIStateUpdater = nextStepUIStateUpdater;
    }

    public final boolean N2(@Nullable String filePath, boolean isOpeningClip, boolean isFromClipping, @Nullable String templateId, @Nullable String missionId, @Nullable OpeningEndingAigcData aigcData) {
        MediaClip mediaClip;
        if (filePath != null) {
            mediaClip = X1(filePath, Boolean.valueOf(isOpeningClip), templateId, missionId, 2500000L, aigcData);
            if (mediaClip == null) {
                return false;
            }
        } else {
            mediaClip = null;
        }
        this._updateOpeningEndingLiveData.postValue(new UpdateOpeningEndingData(isFromClipping, isOpeningClip, mediaClip));
        return true;
    }

    @Nullable
    public final LocalMediaInfo W1(@NotNull Bitmap bitmap) {
        List<String> mutableListOf;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String str = X;
        String path = new File(str, System.nanoTime() + ".jpg").getPath();
        try {
            FileUtils.createDirectory(str);
            if (FileUtils.saveBitmapToFile(bitmap, path)) {
                com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(path);
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) oVar.i(mutableListOf));
                return (LocalMediaInfo) firstOrNull;
            }
            w53.b.c("WinkEditorOpeningEndingViewModel", "buildLocalMediaInfo failed to save bitmap");
            return null;
        } catch (Exception unused) {
            w53.b.c("WinkEditorOpeningEndingViewModel", "buildLocalMediaInfo failed to create dir: " + X);
            return null;
        }
    }

    @Nullable
    public final MediaClip X1(@NotNull String filePath, @Nullable Boolean isOpeningClip, @Nullable String templateId, @Nullable String missionId, long durationUs, @Nullable OpeningEndingAigcData aigcData) {
        List<String> mutableListOf;
        Object firstOrNull;
        MediaData d16;
        MediaClipUseType mediaClipUseType;
        List mutableListOf2;
        Object first;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(filePath);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) oVar.i(mutableListOf));
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
        if (localMediaInfo == null) {
            return null;
        }
        if (e93.i.I(localMediaInfo)) {
            d16 = e93.i.g(localMediaInfo, false, 2, null);
        } else {
            d16 = e93.i.d(localMediaInfo, durationUs);
        }
        if (Intrinsics.areEqual(isOpeningClip, Boolean.TRUE)) {
            mediaClipUseType = MediaClipUseType.OPENING;
        } else if (Intrinsics.areEqual(isOpeningClip, Boolean.FALSE)) {
            mediaClipUseType = MediaClipUseType.ENDING;
        } else {
            mediaClipUseType = MediaClipUseType.NORMAL;
        }
        com.tencent.videocut.render.repository.a aVar = com.tencent.videocut.render.repository.a.f384196a;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(d16);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) com.tencent.videocut.render.repository.a.e(aVar, mutableListOf2, 0.0f, 2, null));
        return com.tencent.videocut.render.extension.e.c(com.tencent.videocut.render.extension.e.b(com.tencent.videocut.render.extension.e.d(com.tencent.videocut.render.extension.e.e((MediaClip) first, mediaClipUseType), templateId), missionId), aigcData);
    }

    public final void a2() {
        Job job = this.aigcJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void b2(@NotNull MediaClip selectedMediaClip) {
        Intrinsics.checkNotNullParameter(selectedMediaClip, "selectedMediaClip");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorOpeningEndingViewModel$clickEditableOverlay$1(this, selectedMediaClip, null), 3, null);
    }

    public final void e2(@NotNull MediaClip mediaClip) {
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorOpeningEndingViewModel$deleteMediaClip$1(this, mediaClip, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorOpeningEndingViewModel";
    }

    public final void j2(@NotNull String styleId, @NotNull String imageUrl, @NotNull String safeId, @NotNull Function4<? super Boolean, ? super String, ? super String, ? super Long, Unit> finishedCallback) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        Intrinsics.checkNotNullParameter(finishedCallback, "finishedCallback");
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), new c(CoroutineExceptionHandler.INSTANCE, this, finishedCallback), null, new WinkEditorOpeningEndingViewModel$generateAigcImage$1(this, imageUrl, styleId, safeId, finishedCallback, null), 2, null);
        this.aigcJob = launch$default;
    }

    @Nullable
    public final List<MetaMaterial> m2() {
        return this.aigcStyleMaterials;
    }

    @Nullable
    /* renamed from: n2, reason: from getter */
    public final String getLastSelectedCategoryId() {
        return this.lastSelectedCategoryId;
    }

    /* renamed from: o2, reason: from getter */
    public final int getLastSelectedEndingIndex() {
        return this.lastSelectedEndingIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        l2().h();
        Observer<List<MetaCategory>> observer = this.openingEndingTemplateObserver;
        if (observer != null) {
            WinkEditorResourceManager.a1().o1().removeObserver(observer);
        }
    }

    /* renamed from: p2, reason: from getter */
    public final int getLastSelectedOpeningIndex() {
        return this.lastSelectedOpeningIndex;
    }

    @NotNull
    public final LiveData<Pair<Boolean, Boolean>> q2() {
        return this.onImageSelectFragmentDismissLiveData;
    }

    @NotNull
    public final SharedFlow<a> r2() {
        return this.onOpeningEndingUiEvent;
    }

    @NotNull
    public final LiveData<Boolean> s2() {
        return this.onTemplateFragmentDismissLiveData;
    }

    @NotNull
    public final LiveData<List<MetaCategory>> t2() {
        return this.openingEndingMaterialsLiveData;
    }

    @Nullable
    /* renamed from: v2, reason: from getter */
    public final MetaMaterial getSelectedMaterial() {
        return this.selectedMaterial;
    }

    @Nullable
    public final MetaMaterial w2() {
        return this.selectedMaterial;
    }

    @NotNull
    public final LiveData<UpdateOpeningEndingData> x2() {
        return this.updateOpeningEndingLiveData;
    }

    public final void y2(boolean finished, boolean success, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkEditorOpeningEndingViewModel$handleAigcGenerateResult$1(this, finished, success, errMsg, null), 3, null);
    }

    public final void z2(@NotNull WeakReference<Activity> weakActivity, @NotNull OpeningEndingAigcData aigcData, boolean isFromClipping) {
        String selectedAlbumImagePath;
        Job launch$default;
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        Intrinsics.checkNotNullParameter(aigcData, "aigcData");
        if (aigcData.getUseVideoFrame()) {
            selectedAlbumImagePath = aigcData.getExtractedVideoFramePath();
        } else {
            selectedAlbumImagePath = aigcData.getSelectedAlbumImagePath();
        }
        String str = selectedAlbumImagePath;
        if (weakActivity.get() != null && aigcData.getTemplateMaterial() != null && !aigcData.getStyleMaterials().isEmpty()) {
            d dVar = new d(CoroutineExceptionHandler.INSTANCE, this);
            MetaMaterial templateMaterial = aigcData.getTemplateMaterial();
            Intrinsics.checkNotNull(templateMaterial);
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), dVar, null, new WinkEditorOpeningEndingViewModel$handleAigcTemplate$1(templateMaterial, this, str, aigcData, weakActivity, isFromClipping, null), 2, null);
            this.aigcJob = launch$default;
            return;
        }
        y2(true, false, "");
    }
}
