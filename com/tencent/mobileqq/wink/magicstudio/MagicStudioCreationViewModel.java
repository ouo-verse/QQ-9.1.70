package com.tencent.mobileqq.wink.magicstudio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.FaceDetectorFeature;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.context.DaTongParams;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.ak;
import com.tencent.mobileqq.wink.editor.InputMediaType;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.mobileqq.wink.magicstudio.model.Scene;
import com.tencent.mobileqq.wink.magicstudio.model.State;
import com.tencent.mobileqq.wink.utils.al;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;
import org.light.aigc.bean.MediaType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00fb\u00012\u00020\u0001:\u0006\u00fc\u0001\u00fd\u0001\u00fe\u0001B\t\u00a2\u0006\u0006\b\u00f9\u0001\u0010\u00fa\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000bJ9\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J[\u0010.\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u001d\u00101\u001a\u00020\u00102\b\b\u0002\u00100\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102J\u00a4\u0001\u0010;\u001aN\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u000208\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b09070#06j&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u000208\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b09070#`:2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\b\u0002\u0010-\u001a\u00020\u0017H\u0002J \u0010=\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`:2\u0006\u0010\"\u001a\u00020\u0010H\u0002J~\u0010@\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u000208\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b09070#2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u0010?\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\b\u0002\u0010-\u001a\u00020\u0017H\u0002J<\u0010E\u001a\u00020\u00062\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`:2\u0006\u0010B\u001a\u00020<2\b\b\u0002\u0010C\u001a\u00020\u00172\b\b\u0002\u0010D\u001a\u00020\u0010H\u0002J\u0081\u0001\u0010H\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\u001e\u0010F\u001a\u001a\u0012\u0004\u0012\u000208\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b09072\u0006\u00105\u001a\u0002032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010?\u001a\u00020\u00102\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`:2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0018\u0010N\u001a\u00020M2\u0006\u0010J\u001a\u00020\b2\u0006\u0010L\u001a\u00020KH\u0002J\b\u0010O\u001a\u00020\u0006H\u0002J\b\u0010Q\u001a\u00020PH\u0002J\b\u0010R\u001a\u00020\u0010H\u0002J0\u0010Y\u001a\u00020\u00062\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040S2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020W0SJ\u000e\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0010J\u0006\u0010\\\u001a\u00020\u0006J\u000e\u0010]\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0010J\u000e\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\bJ \u0010c\u001a\u00020b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010a\u001a\u00020`2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u008c\u0001\u0010s\u001a\u00020\u00062\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h2\u0016\b\u0002\u0010k\u001a\u0010\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u0006\u0018\u00010j2\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010l2\u0010\b\u0002\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010l2\u0016\b\u0002\u0010p\u001a\u0010\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\u0006\u0018\u00010j2\b\b\u0002\u0010q\u001a\u00020\u00172\b\b\u0002\u0010r\u001a\u00020\u0017H\u0007J\u0018\u0010u\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010t\u001a\u00020\u0010J:\u0010w\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010t\u001a\u00020\u0010J\u0006\u0010x\u001a\u00020\u0006J\u000e\u0010z\u001a\u00020\u00062\u0006\u0010B\u001a\u00020yJ\u000e\u0010}\u001a\u00020\u00102\u0006\u0010|\u001a\u00020{J\u0006\u0010~\u001a\u00020\u0019J\b\u0010\u007f\u001a\u00020\u0006H\u0014J\u0012\u0010\u0081\u0001\u001a\u00020\u00062\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0017J\u0011\u0010\u0082\u0001\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u001b\u0010\u0083\u0001\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u000106j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`:R\u0016\u0010\u0085\u0001\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b>\u0010\u0084\u0001R$\u0010\u0089\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0S0\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u008f\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0S0\u008a\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R*\u0010\u0091\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b070\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0088\u0001R/\u0010\u0094\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b070\u008a\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u008c\u0001\u001a\u0006\b\u0093\u0001\u0010\u008e\u0001R$\u0010\u0096\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040S0\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0088\u0001R)\u0010\u0099\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040S0\u008a\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u008c\u0001\u001a\u0006\b\u0098\u0001\u0010\u008e\u0001R!\u0010\u009c\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009a\u00010\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0088\u0001R&\u0010\u009f\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009a\u00010\u008a\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u008c\u0001\u001a\u0006\b\u009e\u0001\u0010\u008e\u0001R\u001e\u0010\u00a3\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a0\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R$\u0010\u00a9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a0\u00010\u00a4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001e\u0010\u00ac\u0001\u001a\t\u0012\u0005\u0012\u00030\u00aa\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00a2\u0001R$\u0010\u00af\u0001\u001a\n\u0012\u0005\u0012\u00030\u00aa\u00010\u00a4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ad\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00ae\u0001\u0010\u00a8\u0001R\u001d\u0010\u00b1\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00a2\u0001R#\u0010\u00b4\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170\u00a4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b2\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00a8\u0001R)\u0010\u00bb\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R)\u0010\u00bf\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bc\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00b8\u0001\"\u0006\b\u00be\u0001\u0010\u00ba\u0001R)\u0010\u00c3\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c0\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00b8\u0001\"\u0006\b\u00c2\u0001\u0010\u00ba\u0001R)\u0010\u00ca\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001\"\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u001b\u0010\u00cd\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001R+\u0010\u00d4\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00d0\u0001\u0010\u00d1\u0001\"\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u001c\u0010\u00d8\u0001\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u001b\u0010\u00da\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u00c5\u0001R+\u0010\u00de\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00db\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00dc\u0001\u0010\u00c7\u0001\"\u0006\b\u00dd\u0001\u0010\u00c9\u0001R\u0019\u0010\u00df\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u009d\u0001R)\u0010\u00e3\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e0\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00e1\u0001\u0010\u00c7\u0001\"\u0006\b\u00e2\u0001\u0010\u00c9\u0001R)\u0010\u00e9\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e4\u0001\u0010\u009d\u0001\u001a\u0006\b\u00e5\u0001\u0010\u00e6\u0001\"\u0006\b\u00e7\u0001\u0010\u00e8\u0001R \u0010\u00ed\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u00ea\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001R\u001c\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00ee\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001R\u0019\u0010\u00f3\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f2\u0001\u0010\u00b6\u0001R\u0017\u0010\u00f6\u0001\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f4\u0001\u0010\u00f5\u0001R\u0017\u0010\u00f8\u0001\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f7\u0001\u0010\u00f5\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00ff\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataManager;", "I2", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "style", "", "h3", "", "selectId", "z3", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", NowProxyConstants.AccountInfoKey.A2, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "prompt", "", "index", "Landroid/content/Intent;", "x2", "imagePath", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "", "isFromCamera", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "j3", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y2", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/model/b;", "firstAigcFlow", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "template", "count", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/wink/magicstudio/model/a;", "w2", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "desc", "nnCurStyle", "picPath", "safeId", "requireBaseImageIndex", "p2", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Lcom/tencent/mobileqq/wink/magicstudio/model/f;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/flow/MutableSharedFlow;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multiStyleSize", "C2", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "failCount", "successCount", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "Lkotlin/collections/ArrayList;", "b3", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "B2", "i", "allCount", ICustomDataEditor.STRING_ARRAY_PARAM_3, "aigcResps", "info", "isError", "target", "m3", "aigcResponse", "reCount", "f3", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/Pair;Ljava/util/concurrent/atomic/AtomicInteger;Lkotlinx/coroutines/flow/MutableSharedFlow;ILjava/util/ArrayList;ILcom/tencent/mobileqq/wink/magicstudio/model/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", "Lorg/light/aigc/bean/MediaType;", "mediaType", "Landroid/util/Size;", "L2", "z2", "Lcom/tencent/mobileqq/wink/magicstudio/model/Scene;", "Q2", "S2", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "magicStudioTips", "magicStudioStyles", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "magicStudioPrompts", "e3", com.tencent.luggage.wxa.c8.c.G, "i3", "o3", "g3", ReportConstant.COSTREPORT_PREFIX, "d3", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "selectInfo", "Landroid/os/Bundle;", "k3", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/content/Context;", "context", "Landroid/view/View;", "parentView", "Lkotlin/Function1;", "gotoMultiSelect", "Lkotlin/Function0;", "failedAction", "cancelAction", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$c;", "progressAction", "hideProgressDialog", "forceCollect", "u2", "requestAigcCount", "l3", "regenerateUploadImageInfo", "p3", "r3", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "y3", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "E2", "H2", "onCleared", "needReport", "r2", "w3", "N2", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableStateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_tagData", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "W2", "()Lkotlinx/coroutines/flow/StateFlow;", "tagData", "D", "_descData", "E", "J2", "descData", UserInfo.SEX_FEMALE, "_styleData", "G", "V2", "styleData", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "H", "_buttonInfo", "I", Constants.BASE_IN_PLUGIN_VERSION, "buttonInfo", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b;", "J", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_event", "Lkotlinx/coroutines/flow/SharedFlow;", "K", "Lkotlinx/coroutines/flow/SharedFlow;", "K2", "()Lkotlinx/coroutines/flow/SharedFlow;", "event", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "L", "_selectEvent", "M", "T2", "selectEvent", "N", "_showCollection", "P", "U2", "showCollection", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "M2", "()Z", "u3", "(Z)V", "picMode", BdhLogUtil.LogTag.Tag_Req, "getCancelScopeAfterGenerated", ICustomDataEditor.STRING_PARAM_3, "cancelScopeAfterGenerated", ExifInterface.LATITUDE_SOUTH, "Y2", "v3", "isRegenerate", "T", "Ljava/lang/String;", "F2", "()Ljava/lang/String;", "setCurDesc", "(Ljava/lang/String;)V", "curDesc", "U", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "curTag", "V", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", Constants.MMCCID, "()Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "t3", "(Lcom/tencent/mobileqq/wink/magicstudio/model/f;)V", "curStyle", "Lkotlinx/coroutines/Job;", "W", "Lkotlinx/coroutines/Job;", "nextJob", "X", "schemaPrompt", "Y", "R2", "x3", "schemaStyle", "aigcCount", "a0", "P2", "setReportSessionID", "reportSessionID", "b0", "O2", "()I", "setRegenerateCount", "(I)V", "regenerateCount", "Landroidx/lifecycle/Observer;", "c0", "Landroidx/lifecycle/Observer;", "observer", "Lcom/tencent/mobileqq/wink/view/ai;", "d0", "Lcom/tencent/mobileqq/wink/view/ai;", "nextDialog", "e0", "isCreationEventCollected", "f0", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataManager;", "textDataManager", "g0", "imageDataManager", "<init>", "()V", "h0", "a", "b", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel extends ViewModel {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i0, reason: collision with root package name */
    @Nullable
    private static MagicStudioUploadImgInfo f323611i0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<List<MagicStudioPrompt>> tagData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Pair<String, String>> _descData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<Pair<String, String>> descData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> _styleData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> styleData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<MagicStudioButtonInfo> _buttonInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<MagicStudioButtonInfo> buttonInfo;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<b> _event;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<b> event;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<c> _selectEvent;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<c> selectEvent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<Boolean> _showCollection;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<Boolean> showCollection;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean picMode;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean cancelScopeAfterGenerated;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isRegenerate;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String curDesc;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private MagicStudioPrompt curTag;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.magicstudio.model.f curStyle;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Job nextJob;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private String schemaPrompt;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private String schemaStyle;

    /* renamed from: Z, reason: from kotlin metadata */
    private int aigcCount;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportSessionID;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int regenerateCount;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Observer<Unit> observer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ai nextDialog;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isCreationEventCollected;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioDataManager textDataManager;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioDataManager imageDataManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<List<MagicStudioPrompt>> _tagData;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$a;", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "isFromCamera", "Landroid/os/Bundle;", "a", "", "AIGC_COUNT", "Ljava/lang/String;", "IMG_GENERATE_STYLE_ID", "IMG_INFO", "IMG_MODE", "IS_COLLECTION", "IS_VERTICAL", "JUMP_INFO", "MAGIC_STUDIO_PIC_STYLE", "", "MIN_COUNT", "I", "ORIGIN_IMAGE", "PROGRESS_UPDATE_CANCEL", "PROGRESS_UPDATE_START", "REPORT_SESSION_ID", "TAG", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "currentPic2PicImgInfo", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Bundle a(@Nullable MagicStudioPicStyle magicStudioPicStyle, @NotNull LocalMediaInfo localMediaInfo, boolean isFromCamera) {
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            Bundle bundle = new Bundle();
            bundle.putSerializable("origin_image", localMediaInfo);
            bundle.putSerializable("magic_studio_pic_style", magicStudioPicStyle);
            bundle.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, isFromCamera);
            return bundle;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$b;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$c;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "a", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "()Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "b", "Z", "()Z", "isRegenerate", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/model/d;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$b$a, reason: from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class GotoMultiSelect extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final JumpInfo jumpInfo;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isRegenerate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GotoMultiSelect(@NotNull JumpInfo jumpInfo, boolean z16) {
                super(null);
                Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
                this.jumpInfo = jumpInfo;
                this.isRegenerate = z16;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final JumpInfo getJumpInfo() {
                return this.jumpInfo;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getIsRegenerate() {
                return this.isRegenerate;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GotoMultiSelect)) {
                    return false;
                }
                GotoMultiSelect gotoMultiSelect = (GotoMultiSelect) other;
                if (Intrinsics.areEqual(this.jumpInfo, gotoMultiSelect.jumpInfo) && this.isRegenerate == gotoMultiSelect.isRegenerate) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = this.jumpInfo.hashCode() * 31;
                boolean z16 = this.isRegenerate;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return hashCode + i3;
            }

            @NotNull
            public String toString() {
                return "GotoMultiSelect(jumpInfo=" + this.jumpInfo + ", isRegenerate=" + this.isRegenerate + ")";
            }

            public /* synthetic */ GotoMultiSelect(JumpInfo jumpInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(jumpInfo, (i3 & 2) != 0 ? false : z16);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$b;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/lang/Throwable;", "getT", "()Ljava/lang/Throwable;", "t", "<init>", "(Ljava/lang/Throwable;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$b$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class MakeFail extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Throwable t;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MakeFail(@NotNull Throwable t16) {
                super(null);
                Intrinsics.checkNotNullParameter(t16, "t");
                this.t = t16;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof MakeFail) && Intrinsics.areEqual(this.t, ((MakeFail) other).t)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.t.hashCode();
            }

            @NotNull
            public String toString() {
                return "MakeFail(t=" + this.t + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$c;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "progress", "b", "Z", "()Z", "isRegenerate", "<init>", "(IZ)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$b$c, reason: from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class ProgressUpdate extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int progress;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isRegenerate;

            public ProgressUpdate(int i3, boolean z16) {
                super(null);
                this.progress = i3;
                this.isRegenerate = z16;
            }

            /* renamed from: a, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getIsRegenerate() {
                return this.isRegenerate;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ProgressUpdate)) {
                    return false;
                }
                ProgressUpdate progressUpdate = (ProgressUpdate) other;
                if (this.progress == progressUpdate.progress && this.isRegenerate == progressUpdate.isRegenerate) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i3 = this.progress * 31;
                boolean z16 = this.isRegenerate;
                int i16 = z16;
                if (z16 != 0) {
                    i16 = 1;
                }
                return i3 + i16;
            }

            @NotNull
            public String toString() {
                return "ProgressUpdate(progress=" + this.progress + ", isRegenerate=" + this.isRegenerate + ")";
            }

            public /* synthetic */ ProgressUpdate(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, (i16 & 2) != 0 ? false : z16);
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c$b;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class c {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends c {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f323637a = new a();

            a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c$b;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "recommendStyleModelID", "<init>", "(Ljava/util/List;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$c$b, reason: from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class StyleSuccess extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final List<String> recommendStyleModelID;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StyleSuccess(@NotNull List<String> recommendStyleModelID) {
                super(null);
                Intrinsics.checkNotNullParameter(recommendStyleModelID, "recommendStyleModelID");
                this.recommendStyleModelID = recommendStyleModelID;
            }

            @NotNull
            public final List<String> a() {
                return this.recommendStyleModelID;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof StyleSuccess) && Intrinsics.areEqual(this.recommendStyleModelID, ((StyleSuccess) other).recommendStyleModelID)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.recommendStyleModelID.hashCode();
            }

            @NotNull
            public String toString() {
                return "StyleSuccess(recommendStyleModelID=" + this.recommendStyleModelID + ")";
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        c() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f323648a;

        static {
            int[] iArr = new int[InputMediaType.values().length];
            try {
                iArr[InputMediaType.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputMediaType.FACE_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f323648a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioCreationViewModel f323649d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CoroutineExceptionHandler.Companion companion, MagicStudioCreationViewModel magicStudioCreationViewModel) {
            super(companion);
            this.f323649d = magicStudioCreationViewModel;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            w53.b.h("MagicStudioCreationViewModel", "make fail", exception);
            MagicStudioDataSource.f323652a.o0(exception);
            BuildersKt__Builders_commonKt.launch$default(this.f323649d.viewModelScope, null, null, new MagicStudioCreationViewModel$requestPic2Pic$exceptionHandler$1$1(this.f323649d, exception, null), 3, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioCreationViewModel f323650d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(CoroutineExceptionHandler.Companion companion, MagicStudioCreationViewModel magicStudioCreationViewModel) {
            super(companion);
            this.f323650d = magicStudioCreationViewModel;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            w53.b.h("MagicStudioCreationViewModel", "requestText2Pic make fail", exception);
            MagicStudioDataSource.f323652a.o0(exception);
            BuildersKt__Builders_commonKt.launch$default(this.f323650d.viewModelScope, null, null, new MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1(this.f323650d, exception, null), 3, null);
        }
    }

    public MagicStudioCreationViewModel() {
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableStateFlow<List<MagicStudioPrompt>> MutableStateFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._tagData = MutableStateFlow;
        this.tagData = MutableStateFlow;
        MutableStateFlow<Pair<String, String>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(TuplesKt.to("", ""));
        this._descData = MutableStateFlow2;
        this.descData = MutableStateFlow2;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(emptyList2);
        this._styleData = MutableStateFlow3;
        this.styleData = MutableStateFlow3;
        MutableStateFlow<MagicStudioButtonInfo> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._buttonInfo = MutableStateFlow4;
        this.buttonInfo = MutableStateFlow4;
        MutableSharedFlow<b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._event = MutableSharedFlow$default;
        this.event = MutableSharedFlow$default;
        MutableSharedFlow<c> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._selectEvent = MutableSharedFlow$default2;
        this.selectEvent = MutableSharedFlow$default2;
        MutableSharedFlow<Boolean> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._showCollection = MutableSharedFlow$default3;
        this.showCollection = MutableSharedFlow$default3;
        this.curDesc = "";
        this.reportSessionID = "";
        this.observer = new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicStudioCreationViewModel.c3(MagicStudioCreationViewModel.this, (Unit) obj);
            }
        };
        this.textDataManager = new MagicStudioTextDataManager();
        this.imageDataManager = new MagicStudioImageDataManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2() {
        MagicStudioDataSource.S(MagicStudioDataSource.f323652a, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<GenerateInfo> B2(int count) {
        Map emptyMap;
        ArrayList<GenerateInfo> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < count; i3++) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            arrayList.add(new GenerateInfo(emptyMap, "", false, State.Loading, null, null, null, 0, 0, com.tencent.luggage.wxa.ig.w.CTRL_INDEX, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(2:10|11)(2:21|22))(3:23|24|(1:26))|12|13|(1:15)(1:19)|16|17))|28|6|7|(0)(0)|12|13|(0)(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        r6 = kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(1), kotlin.coroutines.jvm.internal.Boxing.boxInt(1));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object C2(int i3, Continuation<? super Integer> continuation) {
        MagicStudioCreationViewModel$getAigcCount$1 magicStudioCreationViewModel$getAigcCount$1;
        Object coroutine_suspended;
        int i16;
        int max;
        if (continuation instanceof MagicStudioCreationViewModel$getAigcCount$1) {
            magicStudioCreationViewModel$getAigcCount$1 = (MagicStudioCreationViewModel$getAigcCount$1) continuation;
            int i17 = magicStudioCreationViewModel$getAigcCount$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                magicStudioCreationViewModel$getAigcCount$1.label = i17 - Integer.MIN_VALUE;
                Object obj = magicStudioCreationViewModel$getAigcCount$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = magicStudioCreationViewModel$getAigcCount$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        i3 = magicStudioCreationViewModel$getAigcCount$1.I$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                    magicStudioCreationViewModel$getAigcCount$1.I$0 = i3;
                    magicStudioCreationViewModel$getAigcCount$1.label = 1;
                    obj = magicStudioDataSource.q0(magicStudioCreationViewModel$getAigcCount$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Pair pair = (Pair) obj;
                w53.b.f("MagicStudioCreationViewModel", "aigcContentFlow getAigcCount triggerServerStatus = " + pair);
                if (i3 <= 0) {
                    max = Math.max(Math.min(((Number) pair.getSecond()).intValue(), i3), 1);
                } else {
                    max = Math.max(((Number) pair.getFirst()).intValue(), 1);
                }
                return Boxing.boxInt(max);
            }
        }
        magicStudioCreationViewModel$getAigcCount$1 = new MagicStudioCreationViewModel$getAigcCount$1(this, continuation);
        Object obj2 = magicStudioCreationViewModel$getAigcCount$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = magicStudioCreationViewModel$getAigcCount$1.label;
        if (i16 == 0) {
        }
        Pair pair2 = (Pair) obj2;
        w53.b.f("MagicStudioCreationViewModel", "aigcContentFlow getAigcCount triggerServerStatus = " + pair2);
        if (i3 <= 0) {
        }
        return Boxing.boxInt(max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioDataManager I2() {
        if (this.picMode) {
            return this.imageDataManager;
        }
        return this.textDataManager;
    }

    private final Size L2(String path, MediaType mediaType) {
        int i3;
        int i16;
        try {
        } catch (Throwable th5) {
            w53.b.h("MagicStudioCreationViewModel", "getMediaWidthAndHeight error", th5);
        }
        if (mediaType == MediaType.TypeVideo) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(path);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            if (extractMetadata != null) {
                i3 = Integer.parseInt(extractMetadata);
            } else {
                i3 = 0;
            }
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (extractMetadata2 != null) {
                i16 = Integer.parseInt(extractMetadata2);
            } else {
                i16 = 0;
            }
            return new Size(i3, i16);
        }
        if (mediaType == MediaType.TypeImage || mediaType == MediaType.TypeGIF) {
            Size h16 = com.tencent.mobileqq.wink.utils.f.h(path);
            Intrinsics.checkNotNullExpressionValue(h16, "getBitmapSize(path)");
            return h16;
        }
        return new Size(0, 0);
    }

    private final Scene Q2() {
        return I2().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S2() {
        IntRange indices;
        Integer num;
        String str = this.schemaStyle;
        if (str != null) {
            indices = CollectionsKt__CollectionsKt.getIndices(this.styleData.getValue());
            Iterator<Integer> it = indices.iterator();
            while (true) {
                if (it.hasNext()) {
                    num = it.next();
                    if (Intrinsics.areEqual(this.styleData.getValue().get(num.intValue()).getStyleID(), str)) {
                        break;
                    }
                } else {
                    num = null;
                    break;
                }
            }
            Integer num2 = num;
            if (num2 == null) {
                return 0;
            }
            return num2.intValue();
        }
        return 0;
    }

    private final Flow<Pair<AIGCContentOutput, Map<String, String>>> a3(int i3, String desc, com.tencent.mobileqq.wink.magicstudio.model.f nnCurStyle, String picPath, String safeId, AtomicInteger failCount, AtomicInteger successCount, int allCount, MutableSharedFlow<GenerateFlowInfo> firstAigcFlow, boolean requireBaseImageIndex) {
        return FlowKt.m2026catch(FlowKt.flowOn(FlowKt.flow(new MagicStudioCreationViewModel$makeAigcFlow$1(nnCurStyle, i3, requireBaseImageIndex, desc, picPath, safeId, this, null)), WinkCoroutineScopes.f317652a.d()), new MagicStudioCreationViewModel$makeAigcFlow$2(failCount, allCount, successCount, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Flow<Pair<AIGCContentOutput, Map<String, String>>>> b3(int count, String desc, com.tencent.mobileqq.wink.magicstudio.model.f nnCurStyle, String picPath, String safeId, AtomicInteger failCount, AtomicInteger successCount, MutableSharedFlow<GenerateFlowInfo> firstAigcFlow, boolean requireBaseImageIndex) {
        ArrayList<Flow<Pair<AIGCContentOutput, Map<String, String>>>> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < count; i3++) {
            arrayList.add(a3(i3, desc, nnCurStyle, picPath, safeId, failCount, successCount, count, firstAigcFlow, requireBaseImageIndex));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(MagicStudioCreationViewModel this$0, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s2(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(1:(1:(1:(1:(1:(6:13|14|15|(1:17)(1:21)|18|19)(2:22|23))(3:24|25|(1:27)(6:28|14|15|(0)(0)|18|19)))(19:29|30|31|32|33|34|35|36|(4:38|(5:41|(1:43)(1:49)|(2:45|46)(1:48)|47|39)|50|51)(1:67)|52|(2:54|(8:56|(1:58)(1:65)|59|(2:61|(1:63)(3:64|25|(0)(0)))|15|(0)(0)|18|19))|66|(0)(0)|59|(0)|15|(0)(0)|18|19))(9:75|76|77|78|79|80|81|82|(1:84)(16:85|33|34|35|36|(0)(0)|52|(0)|66|(0)(0)|59|(0)|15|(0)(0)|18|19)))(4:93|94|95|96))(6:108|(1:110)|111|112|113|(11:115|116|117|118|119|120|121|122|123|124|(1:126)(1:127))(5:138|80|81|82|(0)(0)))|97|98|(1:100)(6:101|79|80|81|82|(0)(0))))|141|6|(0)(0)|97|98|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ae, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01af, code lost:
    
        r28 = r12;
        r12 = r2;
        r2 = r28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, org.light.aigc.bean.MediaType] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f3(CoroutineScope coroutineScope, Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair, AtomicInteger atomicInteger, MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow, int i3, ArrayList<GenerateInfo> arrayList, int i16, com.tencent.mobileqq.wink.magicstudio.model.f fVar, Continuation<? super Unit> continuation) {
        MagicStudioCreationViewModel$onReceiveAigcResp$1 magicStudioCreationViewModel$onReceiveAigcResp$1;
        Object coroutine_suspended;
        int i17;
        Ref.ObjectRef objectRef;
        MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow2;
        int i18;
        ArrayList<GenerateInfo> arrayList2;
        MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow3;
        ArrayList<GenerateInfo> arrayList3;
        MagicStudioCreationViewModel magicStudioCreationViewModel;
        Deferred async$default;
        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair2;
        MagicStudioCreationViewModel magicStudioCreationViewModel2;
        AtomicInteger atomicInteger2;
        CoroutineScope coroutineScope2;
        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair3;
        MagicStudioCreationViewModel magicStudioCreationViewModel3;
        MagicStudioDataManager I2;
        Deferred deferred;
        Ref.ObjectRef objectRef2;
        ArrayList<GenerateInfo> arrayList4;
        AtomicInteger atomicInteger3;
        MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow4;
        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair4;
        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair5;
        String str;
        int i19;
        List<ContentInfo> list;
        String str2;
        ArrayList arrayList5;
        String str3;
        String str4;
        GenerateInfo generateInfo;
        Throwable th5;
        int i26;
        ArrayList<GenerateInfo> arrayList6;
        MutableSharedFlow mutableSharedFlow5;
        MagicStudioCreationViewModel magicStudioCreationViewModel4;
        GenerateInfo generateInfo2;
        Object orNull;
        boolean z16;
        GenerateFlowInfo generateFlowInfo;
        AtomicInteger atomicInteger4;
        MagicStudioCreationViewModel magicStudioCreationViewModel5;
        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair6 = pair;
        AtomicInteger atomicInteger5 = atomicInteger;
        if (continuation instanceof MagicStudioCreationViewModel$onReceiveAigcResp$1) {
            magicStudioCreationViewModel$onReceiveAigcResp$1 = (MagicStudioCreationViewModel$onReceiveAigcResp$1) continuation;
            int i27 = magicStudioCreationViewModel$onReceiveAigcResp$1.label;
            if ((i27 & Integer.MIN_VALUE) != 0) {
                magicStudioCreationViewModel$onReceiveAigcResp$1.label = i27 - Integer.MIN_VALUE;
                Object obj = magicStudioCreationViewModel$onReceiveAigcResp$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = magicStudioCreationViewModel$onReceiveAigcResp$1.label;
                String str5 = "";
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (i17 == 0) {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 != 3) {
                                if (i17 != 4) {
                                    if (i17 == 5) {
                                        generateInfo2 = (GenerateInfo) magicStudioCreationViewModel$onReceiveAigcResp$1.L$3;
                                        arrayList6 = (ArrayList) magicStudioCreationViewModel$onReceiveAigcResp$1.L$2;
                                        atomicInteger4 = (AtomicInteger) magicStudioCreationViewModel$onReceiveAigcResp$1.L$1;
                                        magicStudioCreationViewModel5 = (MagicStudioCreationViewModel) magicStudioCreationViewModel$onReceiveAigcResp$1.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        generateInfo = generateInfo2;
                                        arrayList4 = arrayList6;
                                        magicStudioCreationViewModel = magicStudioCreationViewModel5;
                                        atomicInteger3 = atomicInteger4;
                                        if (atomicInteger3.get() == 0) {
                                            n3(magicStudioCreationViewModel, arrayList4, generateInfo, false, 0, 4, null);
                                        } else {
                                            n3(magicStudioCreationViewModel, arrayList4, generateInfo, false, 0, 12, null);
                                        }
                                        atomicInteger3.incrementAndGet();
                                        String name = Thread.currentThread().getName();
                                        Object[] array = arrayList4.toArray(new GenerateInfo[0]);
                                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                        String arrays = Arrays.toString(array);
                                        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                                        w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name + " = " + arrays);
                                        MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i28 = magicStudioCreationViewModel$onReceiveAigcResp$1.I$0;
                                GenerateInfo generateInfo3 = (GenerateInfo) magicStudioCreationViewModel$onReceiveAigcResp$1.L$4;
                                ArrayList<GenerateInfo> arrayList7 = (ArrayList) magicStudioCreationViewModel$onReceiveAigcResp$1.L$3;
                                mutableSharedFlow5 = (MutableSharedFlow) magicStudioCreationViewModel$onReceiveAigcResp$1.L$2;
                                AtomicInteger atomicInteger6 = (AtomicInteger) magicStudioCreationViewModel$onReceiveAigcResp$1.L$1;
                                magicStudioCreationViewModel4 = (MagicStudioCreationViewModel) magicStudioCreationViewModel$onReceiveAigcResp$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                i26 = i28;
                                generateInfo2 = generateInfo3;
                                arrayList6 = arrayList7;
                                th5 = null;
                                atomicInteger3 = atomicInteger6;
                                generateFlowInfo = new GenerateFlowInfo(generateInfo2, i26, th5);
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel4;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = atomicInteger3;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = arrayList6;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = generateInfo2;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = th5;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.label = 5;
                                if (mutableSharedFlow5.emit(generateFlowInfo, magicStudioCreationViewModel$onReceiveAigcResp$1) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                atomicInteger4 = atomicInteger3;
                                magicStudioCreationViewModel5 = magicStudioCreationViewModel4;
                                generateInfo = generateInfo2;
                                arrayList4 = arrayList6;
                                magicStudioCreationViewModel = magicStudioCreationViewModel5;
                                atomicInteger3 = atomicInteger4;
                                if (atomicInteger3.get() == 0) {
                                }
                                atomicInteger3.incrementAndGet();
                                String name2 = Thread.currentThread().getName();
                                Object[] array2 = arrayList4.toArray(new GenerateInfo[0]);
                                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String arrays2 = Arrays.toString(array2);
                                Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
                                w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name2 + " = " + arrays2);
                                MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                return Unit.INSTANCE;
                            }
                            int i29 = magicStudioCreationViewModel$onReceiveAigcResp$1.I$0;
                            objectRef2 = (Ref.ObjectRef) magicStudioCreationViewModel$onReceiveAigcResp$1.L$5;
                            arrayList4 = (ArrayList) magicStudioCreationViewModel$onReceiveAigcResp$1.L$4;
                            mutableSharedFlow4 = (MutableSharedFlow) magicStudioCreationViewModel$onReceiveAigcResp$1.L$3;
                            atomicInteger3 = (AtomicInteger) magicStudioCreationViewModel$onReceiveAigcResp$1.L$2;
                            pair4 = (Pair) magicStudioCreationViewModel$onReceiveAigcResp$1.L$1;
                            magicStudioCreationViewModel = (MagicStudioCreationViewModel) magicStudioCreationViewModel$onReceiveAigcResp$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                i18 = i29;
                                try {
                                    str = (String) obj;
                                    pair5 = pair4;
                                    mutableSharedFlow3 = mutableSharedFlow4;
                                    i19 = i18;
                                } catch (Exception e16) {
                                    e = e16;
                                    pair6 = pair4;
                                    mutableSharedFlow3 = mutableSharedFlow4;
                                    ArrayList<GenerateInfo> arrayList8 = arrayList4;
                                    objectRef = objectRef2;
                                    atomicInteger5 = atomicInteger3;
                                    arrayList3 = arrayList8;
                                    w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                                    pair5 = pair6;
                                    str = "";
                                    i19 = i18;
                                    ArrayList<GenerateInfo> arrayList9 = arrayList3;
                                    atomicInteger3 = atomicInteger5;
                                    objectRef2 = objectRef;
                                    arrayList4 = arrayList9;
                                    list = pair5.getFirst().contentInfos;
                                    if (list != null) {
                                    }
                                    Size L2 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                                    Map<String, String> second = pair5.getSecond();
                                    State state = State.Success;
                                    if (arrayList5 != null) {
                                    }
                                    str3 = null;
                                    if (str3 == null) {
                                    }
                                    generateInfo = new GenerateInfo(second, str, true, state, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L2.getWidth(), L2.getHeight());
                                    if (atomicInteger3.get() == 0) {
                                    }
                                    if (atomicInteger3.get() == 0) {
                                    }
                                    atomicInteger3.incrementAndGet();
                                    String name22 = Thread.currentThread().getName();
                                    Object[] array22 = arrayList4.toArray(new GenerateInfo[0]);
                                    Intrinsics.checkNotNull(array22, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    String arrays22 = Arrays.toString(array22);
                                    Intrinsics.checkNotNullExpressionValue(arrays22, "toString(this)");
                                    w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name22 + " = " + arrays22);
                                    MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                i18 = i29;
                                pair6 = pair4;
                                mutableSharedFlow3 = mutableSharedFlow4;
                                ArrayList<GenerateInfo> arrayList82 = arrayList4;
                                objectRef = objectRef2;
                                atomicInteger5 = atomicInteger3;
                                arrayList3 = arrayList82;
                                w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                                pair5 = pair6;
                                str = "";
                                i19 = i18;
                                ArrayList<GenerateInfo> arrayList92 = arrayList3;
                                atomicInteger3 = atomicInteger5;
                                objectRef2 = objectRef;
                                arrayList4 = arrayList92;
                                list = pair5.getFirst().contentInfos;
                                if (list != null) {
                                }
                                Size L22 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                                Map<String, String> second2 = pair5.getSecond();
                                State state2 = State.Success;
                                if (arrayList5 != null) {
                                }
                                str3 = null;
                                if (str3 == null) {
                                }
                                generateInfo = new GenerateInfo(second2, str, true, state2, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L22.getWidth(), L22.getHeight());
                                if (atomicInteger3.get() == 0) {
                                }
                                if (atomicInteger3.get() == 0) {
                                }
                                atomicInteger3.incrementAndGet();
                                String name222 = Thread.currentThread().getName();
                                Object[] array222 = arrayList4.toArray(new GenerateInfo[0]);
                                Intrinsics.checkNotNull(array222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String arrays222 = Arrays.toString(array222);
                                Intrinsics.checkNotNullExpressionValue(arrays222, "toString(this)");
                                w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name222 + " = " + arrays222);
                                MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                return Unit.INSTANCE;
                            }
                            list = pair5.getFirst().contentInfos;
                            if (list != null) {
                                str2 = "";
                                arrayList5 = null;
                            } else {
                                arrayList5 = new ArrayList();
                                for (Object obj2 : list) {
                                    String str6 = str5;
                                    if (((ContentInfo) obj2).scene == MediaScene.SceneResultWithQrCode) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        arrayList5.add(obj2);
                                    }
                                    str5 = str6;
                                }
                                str2 = str5;
                            }
                            Size L222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                            Map<String, String> second22 = pair5.getSecond();
                            State state22 = State.Success;
                            if (arrayList5 != null) {
                                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList5, 0);
                                ContentInfo contentInfo = (ContentInfo) orNull;
                                if (contentInfo != null) {
                                    str3 = contentInfo.stringData;
                                    if (str3 == null) {
                                        str4 = str2;
                                    } else {
                                        str4 = str3;
                                    }
                                    generateInfo = new GenerateInfo(second22, str, true, state22, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L222.getWidth(), L222.getHeight());
                                    if (atomicInteger3.get() == 0) {
                                        w53.b.a("MagicStudioCreationViewModel", "firstAigcFlow emit");
                                        MutableSharedFlow<b> mutableSharedFlow6 = magicStudioCreationViewModel._event;
                                        th5 = null;
                                        b.ProgressUpdate progressUpdate = new b.ProgressUpdate(40, false, 2, 0 == true ? 1 : 0);
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = atomicInteger3;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = mutableSharedFlow3;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = arrayList4;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = generateInfo;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = null;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = null;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$7 = null;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i19;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.label = 4;
                                        if (mutableSharedFlow6.emit(progressUpdate, magicStudioCreationViewModel$onReceiveAigcResp$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i26 = i19;
                                        arrayList6 = arrayList4;
                                        mutableSharedFlow5 = mutableSharedFlow3;
                                        magicStudioCreationViewModel4 = magicStudioCreationViewModel;
                                        generateInfo2 = generateInfo;
                                        generateFlowInfo = new GenerateFlowInfo(generateInfo2, i26, th5);
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel4;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = atomicInteger3;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = arrayList6;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = generateInfo2;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = th5;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.label = 5;
                                        if (mutableSharedFlow5.emit(generateFlowInfo, magicStudioCreationViewModel$onReceiveAigcResp$1) != coroutine_suspended) {
                                        }
                                    }
                                    if (atomicInteger3.get() == 0) {
                                    }
                                    atomicInteger3.incrementAndGet();
                                    String name2222 = Thread.currentThread().getName();
                                    Object[] array2222 = arrayList4.toArray(new GenerateInfo[0]);
                                    Intrinsics.checkNotNull(array2222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    String arrays2222 = Arrays.toString(array2222);
                                    Intrinsics.checkNotNullExpressionValue(arrays2222, "toString(this)");
                                    w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name2222 + " = " + arrays2222);
                                    MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                    return Unit.INSTANCE;
                                }
                            }
                            str3 = null;
                            if (str3 == null) {
                            }
                            generateInfo = new GenerateInfo(second22, str, true, state22, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L222.getWidth(), L222.getHeight());
                            if (atomicInteger3.get() == 0) {
                            }
                            if (atomicInteger3.get() == 0) {
                            }
                            atomicInteger3.incrementAndGet();
                            String name22222 = Thread.currentThread().getName();
                            Object[] array22222 = arrayList4.toArray(new GenerateInfo[0]);
                            Intrinsics.checkNotNull(array22222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String arrays22222 = Arrays.toString(array22222);
                            Intrinsics.checkNotNullExpressionValue(arrays22222, "toString(this)");
                            w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name22222 + " = " + arrays22222);
                            MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                            return Unit.INSTANCE;
                        }
                        int i36 = magicStudioCreationViewModel$onReceiveAigcResp$1.I$0;
                        deferred = (Deferred) magicStudioCreationViewModel$onReceiveAigcResp$1.L$6;
                        objectRef = (Ref.ObjectRef) magicStudioCreationViewModel$onReceiveAigcResp$1.L$5;
                        arrayList3 = (ArrayList) magicStudioCreationViewModel$onReceiveAigcResp$1.L$4;
                        mutableSharedFlow3 = (MutableSharedFlow) magicStudioCreationViewModel$onReceiveAigcResp$1.L$3;
                        atomicInteger2 = (AtomicInteger) magicStudioCreationViewModel$onReceiveAigcResp$1.L$2;
                        pair2 = (Pair) magicStudioCreationViewModel$onReceiveAigcResp$1.L$1;
                        magicStudioCreationViewModel2 = (MagicStudioCreationViewModel) magicStudioCreationViewModel$onReceiveAigcResp$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i18 = i36;
                            async$default = deferred;
                            objectRef2 = objectRef;
                            try {
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel2;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = pair2;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = atomicInteger2;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = mutableSharedFlow3;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = arrayList3;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = objectRef2;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = null;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
                                magicStudioCreationViewModel$onReceiveAigcResp$1.label = 3;
                                obj = async$default.await(magicStudioCreationViewModel$onReceiveAigcResp$1);
                            } catch (Exception e18) {
                                e = e18;
                                objectRef = objectRef2;
                                pair6 = pair2;
                                atomicInteger5 = atomicInteger2;
                                magicStudioCreationViewModel = magicStudioCreationViewModel2;
                                w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                                pair5 = pair6;
                                str = "";
                                i19 = i18;
                                ArrayList<GenerateInfo> arrayList922 = arrayList3;
                                atomicInteger3 = atomicInteger5;
                                objectRef2 = objectRef;
                                arrayList4 = arrayList922;
                                list = pair5.getFirst().contentInfos;
                                if (list != null) {
                                }
                                Size L2222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                                Map<String, String> second222 = pair5.getSecond();
                                State state222 = State.Success;
                                if (arrayList5 != null) {
                                }
                                str3 = null;
                                if (str3 == null) {
                                }
                                generateInfo = new GenerateInfo(second222, str, true, state222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L2222.getWidth(), L2222.getHeight());
                                if (atomicInteger3.get() == 0) {
                                }
                                if (atomicInteger3.get() == 0) {
                                }
                                atomicInteger3.incrementAndGet();
                                String name222222 = Thread.currentThread().getName();
                                Object[] array222222 = arrayList4.toArray(new GenerateInfo[0]);
                                Intrinsics.checkNotNull(array222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String arrays222222 = Arrays.toString(array222222);
                                Intrinsics.checkNotNullExpressionValue(arrays222222, "toString(this)");
                                w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name222222 + " = " + arrays222222);
                                MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                return Unit.INSTANCE;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            i18 = i36;
                            pair6 = pair2;
                            atomicInteger5 = atomicInteger2;
                            magicStudioCreationViewModel = magicStudioCreationViewModel2;
                            w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                            pair5 = pair6;
                            str = "";
                            i19 = i18;
                            ArrayList<GenerateInfo> arrayList9222 = arrayList3;
                            atomicInteger3 = atomicInteger5;
                            objectRef2 = objectRef;
                            arrayList4 = arrayList9222;
                            list = pair5.getFirst().contentInfos;
                            if (list != null) {
                            }
                            Size L22222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                            Map<String, String> second2222 = pair5.getSecond();
                            State state2222 = State.Success;
                            if (arrayList5 != null) {
                            }
                            str3 = null;
                            if (str3 == null) {
                            }
                            generateInfo = new GenerateInfo(second2222, str, true, state2222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L22222.getWidth(), L22222.getHeight());
                            if (atomicInteger3.get() == 0) {
                            }
                            if (atomicInteger3.get() == 0) {
                            }
                            atomicInteger3.incrementAndGet();
                            String name2222222 = Thread.currentThread().getName();
                            Object[] array2222222 = arrayList4.toArray(new GenerateInfo[0]);
                            Intrinsics.checkNotNull(array2222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String arrays2222222 = Arrays.toString(array2222222);
                            Intrinsics.checkNotNullExpressionValue(arrays2222222, "toString(this)");
                            w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name2222222 + " = " + arrays2222222);
                            MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                            return Unit.INSTANCE;
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        arrayList4 = arrayList3;
                        atomicInteger3 = atomicInteger2;
                        magicStudioCreationViewModel = magicStudioCreationViewModel2;
                        Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair7 = pair2;
                        mutableSharedFlow4 = mutableSharedFlow3;
                        pair4 = pair7;
                        str = (String) obj;
                        pair5 = pair4;
                        mutableSharedFlow3 = mutableSharedFlow4;
                        i19 = i18;
                        list = pair5.getFirst().contentInfos;
                        if (list != null) {
                        }
                        Size L222222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                        Map<String, String> second22222 = pair5.getSecond();
                        State state22222 = State.Success;
                        if (arrayList5 != null) {
                        }
                        str3 = null;
                        if (str3 == null) {
                        }
                        generateInfo = new GenerateInfo(second22222, str, true, state22222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L222222.getWidth(), L222222.getHeight());
                        if (atomicInteger3.get() == 0) {
                        }
                        if (atomicInteger3.get() == 0) {
                        }
                        atomicInteger3.incrementAndGet();
                        String name22222222 = Thread.currentThread().getName();
                        Object[] array22222222 = arrayList4.toArray(new GenerateInfo[0]);
                        Intrinsics.checkNotNull(array22222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String arrays22222222 = Arrays.toString(array22222222);
                        Intrinsics.checkNotNullExpressionValue(arrays22222222, "toString(this)");
                        w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name22222222 + " = " + arrays22222222);
                        MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                        return Unit.INSTANCE;
                    }
                    int i37 = magicStudioCreationViewModel$onReceiveAigcResp$1.I$0;
                    Deferred deferred2 = (Deferred) magicStudioCreationViewModel$onReceiveAigcResp$1.L$7;
                    objectRef = (Ref.ObjectRef) magicStudioCreationViewModel$onReceiveAigcResp$1.L$6;
                    arrayList3 = (ArrayList) magicStudioCreationViewModel$onReceiveAigcResp$1.L$5;
                    mutableSharedFlow3 = (MutableSharedFlow) magicStudioCreationViewModel$onReceiveAigcResp$1.L$4;
                    AtomicInteger atomicInteger7 = (AtomicInteger) magicStudioCreationViewModel$onReceiveAigcResp$1.L$3;
                    pair3 = (Pair) magicStudioCreationViewModel$onReceiveAigcResp$1.L$2;
                    CoroutineScope coroutineScope3 = (CoroutineScope) magicStudioCreationViewModel$onReceiveAigcResp$1.L$1;
                    MagicStudioCreationViewModel magicStudioCreationViewModel6 = (MagicStudioCreationViewModel) magicStudioCreationViewModel$onReceiveAigcResp$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        async$default = deferred2;
                        atomicInteger5 = atomicInteger7;
                        coroutineScope2 = coroutineScope3;
                        i18 = i37;
                        magicStudioCreationViewModel3 = magicStudioCreationViewModel6;
                    } catch (Exception e26) {
                        e = e26;
                        atomicInteger5 = atomicInteger7;
                        i18 = i37;
                        pair6 = pair3;
                        magicStudioCreationViewModel = magicStudioCreationViewModel6;
                        w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                        pair5 = pair6;
                        str = "";
                        i19 = i18;
                        ArrayList<GenerateInfo> arrayList92222 = arrayList3;
                        atomicInteger3 = atomicInteger5;
                        objectRef2 = objectRef;
                        arrayList4 = arrayList92222;
                        list = pair5.getFirst().contentInfos;
                        if (list != null) {
                        }
                        Size L2222222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                        Map<String, String> second222222 = pair5.getSecond();
                        State state222222 = State.Success;
                        if (arrayList5 != null) {
                        }
                        str3 = null;
                        if (str3 == null) {
                        }
                        generateInfo = new GenerateInfo(second222222, str, true, state222222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L2222222.getWidth(), L2222222.getHeight());
                        if (atomicInteger3.get() == 0) {
                        }
                        if (atomicInteger3.get() == 0) {
                        }
                        atomicInteger3.incrementAndGet();
                        String name222222222 = Thread.currentThread().getName();
                        Object[] array222222222 = arrayList4.toArray(new GenerateInfo[0]);
                        Intrinsics.checkNotNull(array222222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String arrays222222222 = Arrays.toString(array222222222);
                        Intrinsics.checkNotNullExpressionValue(arrays222222222, "toString(this)");
                        w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name222222222 + " = " + arrays222222222);
                        MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (i16 == 0) {
                        w53.b.a("MagicStudioCreationViewModel", "guwen milestoneEnd MILESTONE_MAGIC_GALLERY_SELECT_TO_COMPLETE_FRAME");
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_SELECT_TO_COMPLETE_FRAME);
                    }
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = MediaType.TypeImage;
                    try {
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.d(), null, new MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1(pair6, objectRef, atomicInteger5, null), 2, null);
                        async$default.start();
                        if (atomicInteger.get() == 0) {
                            MutableSharedFlow<b> mutableSharedFlow7 = this._event;
                            b.ProgressUpdate progressUpdate2 = new b.ProgressUpdate(40, false, 2, defaultConstructorMarker);
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = this;
                            coroutineScope2 = coroutineScope;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = coroutineScope2;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = pair6;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = atomicInteger5;
                            mutableSharedFlow2 = mutableSharedFlow;
                            try {
                                magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = mutableSharedFlow2;
                                arrayList2 = arrayList;
                                try {
                                    magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = arrayList2;
                                    magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = objectRef;
                                    magicStudioCreationViewModel$onReceiveAigcResp$1.L$7 = async$default;
                                    i18 = i3;
                                    try {
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
                                        magicStudioCreationViewModel$onReceiveAigcResp$1.label = 1;
                                        if (mutableSharedFlow7.emit(progressUpdate2, magicStudioCreationViewModel$onReceiveAigcResp$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        mutableSharedFlow3 = mutableSharedFlow2;
                                        arrayList3 = arrayList2;
                                        pair3 = pair6;
                                        magicStudioCreationViewModel3 = this;
                                    } catch (Exception e27) {
                                        e = e27;
                                        mutableSharedFlow3 = mutableSharedFlow2;
                                        arrayList3 = arrayList2;
                                        magicStudioCreationViewModel = this;
                                        w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                                        pair5 = pair6;
                                        str = "";
                                        i19 = i18;
                                        ArrayList<GenerateInfo> arrayList922222 = arrayList3;
                                        atomicInteger3 = atomicInteger5;
                                        objectRef2 = objectRef;
                                        arrayList4 = arrayList922222;
                                        list = pair5.getFirst().contentInfos;
                                        if (list != null) {
                                        }
                                        Size L22222222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                                        Map<String, String> second2222222 = pair5.getSecond();
                                        State state2222222 = State.Success;
                                        if (arrayList5 != null) {
                                        }
                                        str3 = null;
                                        if (str3 == null) {
                                        }
                                        generateInfo = new GenerateInfo(second2222222, str, true, state2222222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L22222222.getWidth(), L22222222.getHeight());
                                        if (atomicInteger3.get() == 0) {
                                        }
                                        if (atomicInteger3.get() == 0) {
                                        }
                                        atomicInteger3.incrementAndGet();
                                        String name2222222222 = Thread.currentThread().getName();
                                        Object[] array2222222222 = arrayList4.toArray(new GenerateInfo[0]);
                                        Intrinsics.checkNotNull(array2222222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                        String arrays2222222222 = Arrays.toString(array2222222222);
                                        Intrinsics.checkNotNullExpressionValue(arrays2222222222, "toString(this)");
                                        w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name2222222222 + " = " + arrays2222222222);
                                        MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                    i18 = i3;
                                }
                            } catch (Exception e29) {
                                e = e29;
                                i18 = i3;
                                arrayList2 = arrayList;
                                mutableSharedFlow3 = mutableSharedFlow2;
                                arrayList3 = arrayList2;
                                magicStudioCreationViewModel = this;
                                w53.b.h("MagicStudioCreationViewModel", "imgResult error", e);
                                pair5 = pair6;
                                str = "";
                                i19 = i18;
                                ArrayList<GenerateInfo> arrayList9222222 = arrayList3;
                                atomicInteger3 = atomicInteger5;
                                objectRef2 = objectRef;
                                arrayList4 = arrayList9222222;
                                list = pair5.getFirst().contentInfos;
                                if (list != null) {
                                }
                                Size L222222222 = magicStudioCreationViewModel.L2(str, (MediaType) objectRef2.element);
                                Map<String, String> second22222222 = pair5.getSecond();
                                State state22222222 = State.Success;
                                if (arrayList5 != null) {
                                }
                                str3 = null;
                                if (str3 == null) {
                                }
                                generateInfo = new GenerateInfo(second22222222, str, true, state22222222, str4, magicStudioCreationViewModel.I2().b().getCutImgPath(), (MediaType) objectRef2.element, L222222222.getWidth(), L222222222.getHeight());
                                if (atomicInteger3.get() == 0) {
                                }
                                if (atomicInteger3.get() == 0) {
                                }
                                atomicInteger3.incrementAndGet();
                                String name22222222222 = Thread.currentThread().getName();
                                Object[] array22222222222 = arrayList4.toArray(new GenerateInfo[0]);
                                Intrinsics.checkNotNull(array22222222222, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String arrays22222222222 = Arrays.toString(array22222222222);
                                Intrinsics.checkNotNullExpressionValue(arrays22222222222, "toString(this)");
                                w53.b.f("MagicStudioCreationViewModel", "allAigcFlow \u53d1\u9001  " + name22222222222 + " = " + arrays22222222222);
                                MagicStudioDataSource.f323652a.G().postValue(new ArrayList(arrayList4));
                                return Unit.INSTANCE;
                            }
                        } else {
                            i18 = i3;
                            pair2 = pair6;
                            mutableSharedFlow3 = mutableSharedFlow;
                            arrayList3 = arrayList;
                            magicStudioCreationViewModel2 = this;
                            atomicInteger2 = atomicInteger5;
                            objectRef2 = objectRef;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel2;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = pair2;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = atomicInteger2;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = mutableSharedFlow3;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = arrayList3;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = objectRef2;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = null;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
                            magicStudioCreationViewModel$onReceiveAigcResp$1.label = 3;
                            obj = async$default.await(magicStudioCreationViewModel$onReceiveAigcResp$1);
                            if (obj == coroutine_suspended) {
                            }
                        }
                    } catch (Exception e36) {
                        e = e36;
                        mutableSharedFlow2 = mutableSharedFlow;
                    }
                }
                I2 = magicStudioCreationViewModel3.I2();
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = pair3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = atomicInteger5;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = mutableSharedFlow3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = arrayList3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = objectRef;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = async$default;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$7 = null;
                magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
                magicStudioCreationViewModel$onReceiveAigcResp$1.label = 2;
                if (I2.i(pair3, coroutineScope2, magicStudioCreationViewModel$onReceiveAigcResp$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicStudioCreationViewModel2 = magicStudioCreationViewModel3;
                pair2 = pair3;
                atomicInteger2 = atomicInteger5;
                deferred = async$default;
                async$default = deferred;
                objectRef2 = objectRef;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel2;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = pair2;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = atomicInteger2;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = mutableSharedFlow3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = arrayList3;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = objectRef2;
                magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = null;
                magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
                magicStudioCreationViewModel$onReceiveAigcResp$1.label = 3;
                obj = async$default.await(magicStudioCreationViewModel$onReceiveAigcResp$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        magicStudioCreationViewModel$onReceiveAigcResp$1 = new MagicStudioCreationViewModel$onReceiveAigcResp$1(this, continuation);
        Object obj3 = magicStudioCreationViewModel$onReceiveAigcResp$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = magicStudioCreationViewModel$onReceiveAigcResp$1.label;
        String str52 = "";
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        if (i17 == 0) {
        }
        I2 = magicStudioCreationViewModel3.I2();
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$0 = magicStudioCreationViewModel3;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$1 = pair3;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$2 = atomicInteger5;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$3 = mutableSharedFlow3;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$4 = arrayList3;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$5 = objectRef;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$6 = async$default;
        magicStudioCreationViewModel$onReceiveAigcResp$1.L$7 = null;
        magicStudioCreationViewModel$onReceiveAigcResp$1.I$0 = i18;
        magicStudioCreationViewModel$onReceiveAigcResp$1.label = 2;
        if (I2.i(pair3, coroutineScope2, magicStudioCreationViewModel$onReceiveAigcResp$1) != coroutine_suspended) {
        }
    }

    private final void h3(com.tencent.mobileqq.wink.magicstudio.model.f style) {
        this.curStyle = style;
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$onStyleClicked$1(this, style, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j3(String str, MagicStudioPicStyle magicStudioPicStyle, boolean z16, Continuation<? super MagicStudioUploadImgInfo> continuation) {
        MagicStudioCreationViewModel$prepareGenerateData$1 magicStudioCreationViewModel$prepareGenerateData$1;
        Object coroutine_suspended;
        int i3;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo;
        MagicStudioCreationViewModel magicStudioCreationViewModel;
        Object obj;
        MagicStudioPicStyle magicStudioPicStyle2;
        Object p06;
        MagicStudioPicStyle magicStudioPicStyle3;
        String str2;
        String str3;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo2;
        int i16;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo3;
        MagicStudioPicStyle magicStudioPicStyle4;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo4;
        Ref.ObjectRef objectRef;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo5;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo6;
        MagicStudioPicStyle magicStudioPicStyle5;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo7;
        MagicStudioPicStyle magicStudioPicStyle6;
        T t16;
        String str4 = str;
        if (continuation instanceof MagicStudioCreationViewModel$prepareGenerateData$1) {
            magicStudioCreationViewModel$prepareGenerateData$1 = (MagicStudioCreationViewModel$prepareGenerateData$1) continuation;
            int i17 = magicStudioCreationViewModel$prepareGenerateData$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                magicStudioCreationViewModel$prepareGenerateData$1.label = i17 - Integer.MIN_VALUE;
                Object obj2 = magicStudioCreationViewModel$prepareGenerateData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioCreationViewModel$prepareGenerateData$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        magicStudioUploadImgInfo7 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$3;
                                        str2 = (String) magicStudioCreationViewModel$prepareGenerateData$1.L$2;
                                        magicStudioUploadImgInfo6 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$1;
                                        magicStudioPicStyle6 = (MagicStudioPicStyle) magicStudioCreationViewModel$prepareGenerateData$1.L$0;
                                        ResultKt.throwOnFailure(obj2);
                                        magicStudioUploadImgInfo = magicStudioUploadImgInfo7;
                                        magicStudioPicStyle3 = magicStudioPicStyle6;
                                        magicStudioUploadImgInfo.v(str2);
                                        w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                                        return magicStudioUploadImgInfo6;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                magicStudioUploadImgInfo5 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$4;
                                objectRef = (Ref.ObjectRef) magicStudioCreationViewModel$prepareGenerateData$1.L$3;
                                magicStudioUploadImgInfo6 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$2;
                                magicStudioPicStyle5 = (MagicStudioPicStyle) magicStudioCreationViewModel$prepareGenerateData$1.L$1;
                                ResultKt.throwOnFailure(obj2);
                                t16 = objectRef.element;
                                if (((String) t16) == null) {
                                    magicStudioUploadImgInfo6.p((String) t16);
                                    str2 = (String) objectRef.element;
                                    magicStudioUploadImgInfo = magicStudioUploadImgInfo5;
                                    magicStudioPicStyle3 = magicStudioPicStyle5;
                                    magicStudioUploadImgInfo.v(str2);
                                    w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                                    return magicStudioUploadImgInfo6;
                                }
                                MagicStudioDataSource.m0(MagicStudioDataSource.f323652a, 0L, "\u8bf7\u4e0a\u4f20\u5305\u542b\u4eba\u50cf\u56fe\u7247", 1, null);
                                throw new IllegalStateException("cropFaceRegion failed");
                            }
                            magicStudioUploadImgInfo4 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$2;
                            magicStudioUploadImgInfo3 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$1;
                            magicStudioPicStyle4 = (MagicStudioPicStyle) magicStudioCreationViewModel$prepareGenerateData$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            magicStudioPicStyle3 = magicStudioPicStyle4;
                            magicStudioUploadImgInfo6 = magicStudioUploadImgInfo3;
                            str2 = (String) obj2;
                            magicStudioUploadImgInfo = magicStudioUploadImgInfo4;
                            magicStudioUploadImgInfo.v(str2);
                            w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                            return magicStudioUploadImgInfo6;
                        }
                        magicStudioUploadImgInfo2 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$5;
                        str2 = (String) magicStudioCreationViewModel$prepareGenerateData$1.L$4;
                        MagicStudioUploadImgInfo magicStudioUploadImgInfo8 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$3;
                        MagicStudioPicStyle magicStudioPicStyle7 = (MagicStudioPicStyle) magicStudioCreationViewModel$prepareGenerateData$1.L$2;
                        String str5 = (String) magicStudioCreationViewModel$prepareGenerateData$1.L$1;
                        magicStudioCreationViewModel = (MagicStudioCreationViewModel) magicStudioCreationViewModel$prepareGenerateData$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        magicStudioPicStyle3 = magicStudioPicStyle7;
                        p06 = obj2;
                        magicStudioUploadImgInfo = magicStudioUploadImgInfo8;
                        str3 = str5;
                        magicStudioUploadImgInfo2.u((String) p06);
                        i16 = d.f323648a[magicStudioPicStyle3.getInputMediaType().ordinal()];
                        if (i16 == 1) {
                            if (i16 != 2) {
                                if (m83.a.f416440a.e()) {
                                    CoroutineDispatcher b16 = WinkCoroutineScopes.f317652a.b();
                                    MagicStudioCreationViewModel$prepareGenerateData$4 magicStudioCreationViewModel$prepareGenerateData$4 = new MagicStudioCreationViewModel$prepareGenerateData$4(magicStudioUploadImgInfo, magicStudioCreationViewModel, str3, null);
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$0 = magicStudioPicStyle3;
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$1 = magicStudioUploadImgInfo;
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$2 = str2;
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$3 = magicStudioUploadImgInfo;
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$4 = null;
                                    magicStudioCreationViewModel$prepareGenerateData$1.L$5 = null;
                                    magicStudioCreationViewModel$prepareGenerateData$1.label = 5;
                                    if (BuildersKt.withContext(b16, magicStudioCreationViewModel$prepareGenerateData$4, magicStudioCreationViewModel$prepareGenerateData$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    magicStudioUploadImgInfo7 = magicStudioUploadImgInfo;
                                    magicStudioUploadImgInfo6 = magicStudioUploadImgInfo7;
                                    magicStudioPicStyle6 = magicStudioPicStyle3;
                                    magicStudioUploadImgInfo = magicStudioUploadImgInfo7;
                                    magicStudioPicStyle3 = magicStudioPicStyle6;
                                    magicStudioUploadImgInfo.v(str2);
                                    w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                                    return magicStudioUploadImgInfo6;
                                }
                                magicStudioUploadImgInfo6 = magicStudioUploadImgInfo;
                                magicStudioUploadImgInfo.v(str2);
                                w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                                return magicStudioUploadImgInfo6;
                            }
                            objectRef = new Ref.ObjectRef();
                            CoroutineDispatcher b17 = WinkCoroutineScopes.f317652a.b();
                            MagicStudioCreationViewModel$prepareGenerateData$2 magicStudioCreationViewModel$prepareGenerateData$2 = new MagicStudioCreationViewModel$prepareGenerateData$2(objectRef, magicStudioCreationViewModel, str3, null);
                            magicStudioCreationViewModel$prepareGenerateData$1.L$0 = magicStudioCreationViewModel;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$1 = magicStudioPicStyle3;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$2 = magicStudioUploadImgInfo;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$3 = objectRef;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$4 = magicStudioUploadImgInfo;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$5 = null;
                            magicStudioCreationViewModel$prepareGenerateData$1.label = 4;
                            if (BuildersKt.withContext(b17, magicStudioCreationViewModel$prepareGenerateData$2, magicStudioCreationViewModel$prepareGenerateData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            magicStudioUploadImgInfo5 = magicStudioUploadImgInfo;
                            magicStudioUploadImgInfo6 = magicStudioUploadImgInfo5;
                            magicStudioPicStyle5 = magicStudioPicStyle3;
                            t16 = objectRef.element;
                            if (((String) t16) == null) {
                            }
                        } else {
                            magicStudioUploadImgInfo.w(MagicStudioDataSource.f323652a.Y(str3));
                            al alVar = al.f326675a;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$0 = magicStudioPicStyle3;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$1 = magicStudioUploadImgInfo;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$2 = magicStudioUploadImgInfo;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$3 = null;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$4 = null;
                            magicStudioCreationViewModel$prepareGenerateData$1.L$5 = null;
                            magicStudioCreationViewModel$prepareGenerateData$1.label = 3;
                            MagicStudioPicStyle magicStudioPicStyle8 = magicStudioPicStyle3;
                            Object b18 = al.b(alVar, str3, false, magicStudioCreationViewModel$prepareGenerateData$1, 2, null);
                            if (b18 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            magicStudioUploadImgInfo3 = magicStudioUploadImgInfo;
                            obj2 = b18;
                            magicStudioPicStyle4 = magicStudioPicStyle8;
                            magicStudioUploadImgInfo4 = magicStudioUploadImgInfo3;
                            magicStudioPicStyle3 = magicStudioPicStyle4;
                            magicStudioUploadImgInfo6 = magicStudioUploadImgInfo3;
                            str2 = (String) obj2;
                            magicStudioUploadImgInfo = magicStudioUploadImgInfo4;
                            magicStudioUploadImgInfo.v(str2);
                            w53.b.f("MagicStudioCreationViewModel", "prepareEditorData inputMediaType: " + magicStudioPicStyle3.getInputMediaType() + ", url: " + magicStudioUploadImgInfo6.getUploadUrl());
                            return magicStudioUploadImgInfo6;
                        }
                    } else {
                        MagicStudioUploadImgInfo magicStudioUploadImgInfo9 = (MagicStudioUploadImgInfo) magicStudioCreationViewModel$prepareGenerateData$1.L$3;
                        magicStudioPicStyle2 = (MagicStudioPicStyle) magicStudioCreationViewModel$prepareGenerateData$1.L$2;
                        String str6 = (String) magicStudioCreationViewModel$prepareGenerateData$1.L$1;
                        MagicStudioCreationViewModel magicStudioCreationViewModel2 = (MagicStudioCreationViewModel) magicStudioCreationViewModel$prepareGenerateData$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        magicStudioCreationViewModel = magicStudioCreationViewModel2;
                        magicStudioUploadImgInfo = magicStudioUploadImgInfo9;
                        str4 = str6;
                        obj = obj2;
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    A2();
                    magicStudioUploadImgInfo = new MagicStudioUploadImgInfo(null, null, null, null, null, null, null, false, null, null, false, 2047, null);
                    magicStudioUploadImgInfo.r(z16);
                    magicStudioUploadImgInfo.t(str4);
                    if (m83.a.f416440a.e()) {
                        String calcMd5 = FileUtils.calcMd5(str);
                        Intrinsics.checkNotNullExpressionValue(calcMd5, "calcMd5(imagePath)");
                        magicStudioUploadImgInfo.s(calcMd5);
                    }
                    String N = MagicStudioDataSource.f323652a.N(str4);
                    if (N == null) {
                        N = "";
                    }
                    magicStudioUploadImgInfo.n(N);
                    al alVar2 = al.f326675a;
                    String compressPath = magicStudioUploadImgInfo.getCompressPath();
                    magicStudioCreationViewModel$prepareGenerateData$1.L$0 = this;
                    magicStudioCreationViewModel$prepareGenerateData$1.L$1 = str4;
                    magicStudioCreationViewModel$prepareGenerateData$1.L$2 = magicStudioPicStyle;
                    magicStudioCreationViewModel$prepareGenerateData$1.L$3 = magicStudioUploadImgInfo;
                    magicStudioCreationViewModel$prepareGenerateData$1.label = 1;
                    Object b19 = al.b(alVar2, compressPath, false, magicStudioCreationViewModel$prepareGenerateData$1, 2, null);
                    if (b19 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicStudioCreationViewModel = this;
                    obj = b19;
                    magicStudioPicStyle2 = magicStudioPicStyle;
                }
                String str7 = (String) obj;
                magicStudioUploadImgInfo.o(str7);
                MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                magicStudioUploadImgInfo.w(magicStudioDataSource.Y(magicStudioUploadImgInfo.getCompressPath()));
                magicStudioCreationViewModel$prepareGenerateData$1.L$0 = magicStudioCreationViewModel;
                magicStudioCreationViewModel$prepareGenerateData$1.L$1 = str4;
                magicStudioCreationViewModel$prepareGenerateData$1.L$2 = magicStudioPicStyle2;
                magicStudioCreationViewModel$prepareGenerateData$1.L$3 = magicStudioUploadImgInfo;
                magicStudioCreationViewModel$prepareGenerateData$1.L$4 = str7;
                magicStudioCreationViewModel$prepareGenerateData$1.L$5 = magicStudioUploadImgInfo;
                magicStudioCreationViewModel$prepareGenerateData$1.label = 2;
                p06 = magicStudioDataSource.p0(str7, magicStudioCreationViewModel$prepareGenerateData$1);
                if (p06 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicStudioPicStyle3 = magicStudioPicStyle2;
                str2 = str7;
                str3 = str4;
                magicStudioUploadImgInfo2 = magicStudioUploadImgInfo;
                magicStudioUploadImgInfo2.u((String) p06);
                i16 = d.f323648a[magicStudioPicStyle3.getInputMediaType().ordinal()];
                if (i16 == 1) {
                }
            }
        }
        magicStudioCreationViewModel$prepareGenerateData$1 = new MagicStudioCreationViewModel$prepareGenerateData$1(this, continuation);
        Object obj22 = magicStudioCreationViewModel$prepareGenerateData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioCreationViewModel$prepareGenerateData$1.label;
        if (i3 == 0) {
        }
        String str72 = (String) obj;
        magicStudioUploadImgInfo.o(str72);
        MagicStudioDataSource magicStudioDataSource2 = MagicStudioDataSource.f323652a;
        magicStudioUploadImgInfo.w(magicStudioDataSource2.Y(magicStudioUploadImgInfo.getCompressPath()));
        magicStudioCreationViewModel$prepareGenerateData$1.L$0 = magicStudioCreationViewModel;
        magicStudioCreationViewModel$prepareGenerateData$1.L$1 = str4;
        magicStudioCreationViewModel$prepareGenerateData$1.L$2 = magicStudioPicStyle2;
        magicStudioCreationViewModel$prepareGenerateData$1.L$3 = magicStudioUploadImgInfo;
        magicStudioCreationViewModel$prepareGenerateData$1.L$4 = str72;
        magicStudioCreationViewModel$prepareGenerateData$1.L$5 = magicStudioUploadImgInfo;
        magicStudioCreationViewModel$prepareGenerateData$1.label = 2;
        p06 = magicStudioDataSource2.p0(str72, magicStudioCreationViewModel$prepareGenerateData$1);
        if (p06 != coroutine_suspended) {
        }
    }

    private final void m3(ArrayList<GenerateInfo> aigcResps, GenerateInfo info, boolean isError, int target) {
        boolean z16;
        boolean z17;
        synchronized (aigcResps) {
            if (target > 0) {
                aigcResps.remove(target);
                aigcResps.add(target, info);
                return;
            }
            int i3 = -1;
            if (isError) {
                ListIterator<GenerateInfo> listIterator = aigcResps.listIterator(aigcResps.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().getState() == State.Loading) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        i3 = listIterator.nextIndex();
                        break;
                    }
                }
            } else {
                Iterator<GenerateInfo> it = aigcResps.iterator();
                int i16 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getState() == State.Loading) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                }
            }
            w53.b.a("MagicStudioCreationViewModel", "replaceLoading index = " + i3);
            if (i3 >= 0) {
                aigcResps.remove(i3);
                aigcResps.add(i3, info);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void n3(MagicStudioCreationViewModel magicStudioCreationViewModel, ArrayList arrayList, GenerateInfo generateInfo, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        if ((i16 & 8) != 0) {
            i3 = -1;
        }
        magicStudioCreationViewModel.m3(arrayList, generateInfo, z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p2(CoroutineScope coroutineScope, String str, com.tencent.mobileqq.wink.magicstudio.model.f fVar, String str2, String str3, MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow, int i3, boolean z16, Continuation<? super Boolean> continuation) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.d(), null, new MagicStudioCreationViewModel$aigcContentFlow$2(this, i3, str, fVar, str2, str3, mutableSharedFlow, z16, coroutineScope, null), 2, null);
        return Boxing.boxBoolean(async$default.start());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object q2(MagicStudioCreationViewModel magicStudioCreationViewModel, CoroutineScope coroutineScope, String str, com.tencent.mobileqq.wink.magicstudio.model.f fVar, String str2, String str3, MutableSharedFlow mutableSharedFlow, int i3, boolean z16, Continuation continuation, int i16, Object obj) {
        boolean z17;
        if ((i16 & 128) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        return magicStudioCreationViewModel.p2(coroutineScope, str, fVar, str2, str3, mutableSharedFlow, i3, z17, continuation);
    }

    public static /* synthetic */ void q3(MagicStudioCreationViewModel magicStudioCreationViewModel, String str, MagicStudioPicStyle magicStudioPicStyle, boolean z16, MagicStudioUploadImgInfo magicStudioUploadImgInfo, int i3, int i16, Object obj) {
        boolean z17;
        int i17;
        if ((i16 & 4) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i16 & 8) != 0) {
            magicStudioUploadImgInfo = null;
        }
        MagicStudioUploadImgInfo magicStudioUploadImgInfo2 = magicStudioUploadImgInfo;
        if ((i16 & 16) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        magicStudioCreationViewModel.p3(str, magicStudioPicStyle, z17, magicStudioUploadImgInfo2, i17);
    }

    public static /* synthetic */ void s2(MagicStudioCreationViewModel magicStudioCreationViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        magicStudioCreationViewModel.r2(z16);
    }

    public static /* synthetic */ void v2(MagicStudioCreationViewModel magicStudioCreationViewModel, LifecycleOwner lifecycleOwner, Context context, View view, Function1 function1, Function0 function0, Function0 function02, Function1 function12, boolean z16, boolean z17, int i3, Object obj) {
        View view2;
        Function1 function13;
        Function0 function03;
        Function0 function04;
        Function1 function14;
        boolean z18;
        boolean z19;
        if ((i3 & 4) != 0) {
            view2 = null;
        } else {
            view2 = view;
        }
        if ((i3 & 8) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        if ((i3 & 16) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i3 & 32) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        if ((i3 & 64) != 0) {
            function14 = null;
        } else {
            function14 = function12;
        }
        if ((i3 & 128) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i3 & 256) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        magicStudioCreationViewModel.u2(lifecycleOwner, context, view2, function13, function03, function04, function14, z18, z19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlinx.coroutines.flow.Flow] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w2(MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow, MetaMaterial metaMaterial, int i3, Continuation<? super Flow<CombineFlowInfo>> continuation) {
        MagicStudioCreationViewModel$combineTaskFlow$1 magicStudioCreationViewModel$combineTaskFlow$1;
        Object coroutine_suspended;
        int i16;
        MagicStudioCreationViewModel magicStudioCreationViewModel;
        MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow2;
        if (continuation instanceof MagicStudioCreationViewModel$combineTaskFlow$1) {
            magicStudioCreationViewModel$combineTaskFlow$1 = (MagicStudioCreationViewModel$combineTaskFlow$1) continuation;
            int i17 = magicStudioCreationViewModel$combineTaskFlow$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                magicStudioCreationViewModel$combineTaskFlow$1.label = i17 - Integer.MIN_VALUE;
                Object obj = magicStudioCreationViewModel$combineTaskFlow$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = magicStudioCreationViewModel$combineTaskFlow$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ?? r56 = (Flow) magicStudioCreationViewModel$combineTaskFlow$1.L$1;
                        magicStudioCreationViewModel = (MagicStudioCreationViewModel) magicStudioCreationViewModel$combineTaskFlow$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableSharedFlow2 = r56;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MagicStudioDataManager I2 = I2();
                    magicStudioCreationViewModel$combineTaskFlow$1.L$0 = this;
                    magicStudioCreationViewModel$combineTaskFlow$1.L$1 = mutableSharedFlow;
                    magicStudioCreationViewModel$combineTaskFlow$1.label = 1;
                    obj = I2.d(i3, metaMaterial, magicStudioCreationViewModel$combineTaskFlow$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicStudioCreationViewModel = this;
                    mutableSharedFlow2 = mutableSharedFlow;
                }
                return FlowKt.combine(mutableSharedFlow2, (Flow) obj, new MagicStudioCreationViewModel$combineTaskFlow$2(magicStudioCreationViewModel, null));
            }
        }
        magicStudioCreationViewModel$combineTaskFlow$1 = new MagicStudioCreationViewModel$combineTaskFlow$1(this, continuation);
        Object obj2 = magicStudioCreationViewModel$combineTaskFlow$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = magicStudioCreationViewModel$combineTaskFlow$1.label;
        if (i16 == 0) {
        }
        return FlowKt.combine(mutableSharedFlow2, (Flow) obj2, new MagicStudioCreationViewModel$combineTaskFlow$2(magicStudioCreationViewModel, null));
    }

    private final Intent x2(Activity activity, String prompt, int index) {
        String stringExtra;
        Intent intent = new Intent();
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (stringExtra = intent2.getStringExtra("taskid")) != null) {
            intent.putExtra("xsj_operation_activity_id", stringExtra);
            intent.putExtra("taskid", stringExtra);
        }
        intent.putExtra(QQWinkTempConstants.MAGIC_STUDIO_PROMPT, prompt);
        intent.putExtra(QQWinkTempConstants.FROM_MAGIC_STUDIO, "true");
        intent.putExtra(QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE, QQWinkConstants.WinkTaskRoute.AIGC);
        intent.putExtra(QQWinkTempConstants.MAGIC_STUDIO_COVER_INDEX, String.valueOf(index));
        intent.putExtra(QQWinkTempConstants.MAIGC_STUDIO_REPORT_SESSION_ID, this.reportSessionID);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y2(String str, Continuation<? super String> continuation) {
        MagicStudioCreationViewModel$cropFaceRegionAndUpload$1 magicStudioCreationViewModel$cropFaceRegionAndUpload$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        Object h16;
        boolean z16;
        Object next;
        double d16;
        Bitmap createScaledBitmap;
        if (continuation instanceof MagicStudioCreationViewModel$cropFaceRegionAndUpload$1) {
            magicStudioCreationViewModel$cropFaceRegionAndUpload$1 = (MagicStudioCreationViewModel$cropFaceRegionAndUpload$1) continuation;
            int i16 = magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicStudioCreationViewModel$cropFaceRegionAndUpload$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str3 = (String) magicStudioCreationViewModel$cropFaceRegionAndUpload$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    h16 = obj;
                    str2 = str3;
                } else {
                    ResultKt.throwOnFailure(obj);
                    WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                    Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
                    str2 = str;
                    magicStudioCreationViewModel$cropFaceRegionAndUpload$1.L$0 = str2;
                    magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label = 1;
                    h16 = ak.h(a16, "FACE_AGENT", null, magicStudioCreationViewModel$cropFaceRegionAndUpload$1, 2, null);
                    if (h16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (((Boolean) h16).booleanValue()) {
                    w53.b.c("MagicStudioCreationViewModel", "cropFaceRegion bundle fetch failed");
                    return null;
                }
                Size h17 = com.tencent.mobileqq.wink.utils.f.h(str2);
                List<FaceDetectorFeature> b16 = com.tencent.mobileqq.wink.utils.j.f326712a.b(str2);
                List<FaceDetectorFeature> list = b16;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    w53.b.c("MagicStudioCreationViewModel", "cropFaceRegion defect no face");
                    return null;
                }
                Iterator<T> it = b16.iterator();
                if (!it.hasNext()) {
                    next = null;
                } else {
                    next = it.next();
                    if (it.hasNext()) {
                        FaceDetectorFeature faceDetectorFeature = (FaceDetectorFeature) next;
                        int i17 = faceDetectorFeature.boundsW * faceDetectorFeature.boundsH;
                        do {
                            Object next2 = it.next();
                            FaceDetectorFeature faceDetectorFeature2 = (FaceDetectorFeature) next2;
                            int i18 = faceDetectorFeature2.boundsW * faceDetectorFeature2.boundsH;
                            if (i17 < i18) {
                                next = next2;
                                i17 = i18;
                            }
                        } while (it.hasNext());
                    }
                }
                FaceDetectorFeature faceDetectorFeature3 = (FaceDetectorFeature) next;
                if (faceDetectorFeature3 == null) {
                    w53.b.c("MagicStudioCreationViewModel", "cropFaceRegion defect no face");
                    return null;
                }
                float max = Math.max(h17.getWidth() / faceDetectorFeature3.imageWidth, h17.getHeight() / faceDetectorFeature3.imageHeight);
                double max2 = Math.max(faceDetectorFeature3.boundsX * max * 0.9d, 0.0d);
                double max3 = Math.max(faceDetectorFeature3.boundsY * max * 0.9d, 0.0d);
                double d17 = (faceDetectorFeature3.boundsX + faceDetectorFeature3.boundsW) * max * 1.1d;
                double d18 = (faceDetectorFeature3.boundsY + faceDetectorFeature3.boundsH) * max * 1.1d;
                if (d17 > h17.getWidth()) {
                    d17 = h17.getWidth();
                }
                double d19 = d17 - max2;
                if (d18 > h17.getHeight()) {
                    d16 = h17.getHeight() - max3;
                } else {
                    d16 = d18 - max3;
                }
                Bitmap createBitmap = Bitmap.createBitmap(com.tencent.mobileqq.wink.utils.f.c(str2), (int) max2, (int) max3, (int) d19, (int) d16);
                if (createBitmap.getWidth() <= 1024 && createBitmap.getHeight() <= 1024) {
                    createScaledBitmap = createBitmap;
                } else {
                    int max4 = Math.max(createBitmap.getWidth() / 1024, createBitmap.getHeight() / 1024);
                    createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, createBitmap.getWidth() / max4, createBitmap.getHeight() / max4, true);
                }
                String str4 = MagicStudioDataSource.f323652a.L() + System.nanoTime() + ".png";
                com.tencent.mobileqq.wink.utils.f.v(str4, createScaledBitmap, Bitmap.CompressFormat.PNG, 100);
                createBitmap.recycle();
                createScaledBitmap.recycle();
                al alVar = al.f326675a;
                magicStudioCreationViewModel$cropFaceRegionAndUpload$1.L$0 = null;
                magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label = 2;
                obj = al.b(alVar, str4, false, magicStudioCreationViewModel$cropFaceRegionAndUpload$1, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        magicStudioCreationViewModel$cropFaceRegionAndUpload$1 = new MagicStudioCreationViewModel$cropFaceRegionAndUpload$1(this, continuation);
        Object obj2 = magicStudioCreationViewModel$cropFaceRegionAndUpload$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioCreationViewModel$cropFaceRegionAndUpload$1.label;
        if (i3 == 0) {
        }
        if (((Boolean) h16).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2() {
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).clearTimeEvent(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z3(String str, Continuation<? super Unit> continuation) {
        int collectionSizeOrDefault;
        Object coroutine_suspended;
        List<com.tencent.mobileqq.wink.magicstudio.model.f> value = this.styleData.getValue();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(value, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.wink.magicstudio.model.f fVar : value) {
            boolean areEqual = Intrinsics.areEqual(fVar.getStyleID(), str);
            if (areEqual) {
                this.curStyle = fVar;
            }
            com.tencent.mobileqq.wink.magicstudio.model.f a16 = fVar.a();
            a16.v(areEqual);
            arrayList.add(a16);
        }
        Object emit = this._styleData.emit(arrayList, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (emit == coroutine_suspended) {
            return emit;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final StateFlow<MagicStudioButtonInfo> D2() {
        return this.buttonInfo;
    }

    public final int E2(@NotNull JumpInfo jumpInfo) {
        Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
        return I2().a(jumpInfo);
    }

    @NotNull
    /* renamed from: F2, reason: from getter */
    public final String getCurDesc() {
        return this.curDesc;
    }

    @Nullable
    /* renamed from: G2, reason: from getter */
    public final com.tencent.mobileqq.wink.magicstudio.model.f getCurStyle() {
        return this.curStyle;
    }

    @NotNull
    public final MagicStudioUploadImgInfo H2() {
        return I2().b();
    }

    @NotNull
    public final StateFlow<Pair<String, String>> J2() {
        return this.descData;
    }

    @NotNull
    public final SharedFlow<b> K2() {
        return this.event;
    }

    /* renamed from: M2, reason: from getter */
    public final boolean getPicMode() {
        return this.picMode;
    }

    @Nullable
    public final ArrayList<String> N2() {
        return I2().g();
    }

    /* renamed from: O2, reason: from getter */
    public final int getRegenerateCount() {
        return this.regenerateCount;
    }

    @NotNull
    /* renamed from: P2, reason: from getter */
    public final String getReportSessionID() {
        return this.reportSessionID;
    }

    @Nullable
    /* renamed from: R2, reason: from getter */
    public final String getSchemaStyle() {
        return this.schemaStyle;
    }

    @NotNull
    public final SharedFlow<c> T2() {
        return this.selectEvent;
    }

    @NotNull
    public final SharedFlow<Boolean> U2() {
        return this.showCollection;
    }

    @NotNull
    public final StateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> V2() {
        return this.styleData;
    }

    @NotNull
    public final StateFlow<List<MagicStudioPrompt>> W2() {
        return this.tagData;
    }

    /* renamed from: Y2, reason: from getter */
    public final boolean getIsRegenerate() {
        return this.isRegenerate;
    }

    public final void d3(@NotNull String s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        this.curDesc = s16;
        Pair<String, String> value = this.descData.getValue();
        String component1 = value.component1();
        value.component2();
        this._descData.setValue(TuplesKt.to(component1, s16));
    }

    public final void e3(@NotNull List<MagicStudioTip> magicStudioTips, @NotNull List<com.tencent.mobileqq.wink.magicstudio.model.f> magicStudioStyles, @NotNull List<MagicStudioPrompt> magicStudioPrompts) {
        Intrinsics.checkNotNullParameter(magicStudioTips, "magicStudioTips");
        Intrinsics.checkNotNullParameter(magicStudioStyles, "magicStudioStyles");
        Intrinsics.checkNotNullParameter(magicStudioPrompts, "magicStudioPrompts");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$onPageInit$1(this, magicStudioTips, magicStudioStyles, magicStudioPrompts, null), 3, null);
    }

    public final void g3(int pos) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.styleData.getValue(), pos);
        com.tencent.mobileqq.wink.magicstudio.model.f fVar = (com.tencent.mobileqq.wink.magicstudio.model.f) orNull;
        if (fVar == null) {
            return;
        }
        h3(fVar);
    }

    public final void i3(int pos) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.tagData.getValue(), pos);
        MagicStudioPrompt magicStudioPrompt = (MagicStudioPrompt) orNull;
        if (magicStudioPrompt == null) {
            return;
        }
        this.curTag = magicStudioPrompt;
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$onTagClicked$1(this, magicStudioPrompt, null), 3, null);
    }

    @NotNull
    public final Bundle k3(@NotNull Activity activity, @NotNull b.GotoMultiSelect selectInfo, @Nullable MagicStudioPicStyle magicStudioPicStyle) {
        String str;
        String str2;
        com.tencent.mobileqq.wink.magicstudio.model.f fVar;
        String styleID;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        Bundle bundle = new Bundle();
        bundle.putInt("ability_flag", 2);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putBoolean("camera_direct_return_result", true);
        bundle.putString("camera_fragment_tag", "MAGIC_STUDIO");
        bundle.putBundle("aigc_jump_info", x2(activity, selectInfo.getJumpInfo().getPrompt(), E2(selectInfo.getJumpInfo())).getExtras());
        bundle.putInt(QQWinkTempConstants.AIGC_COUNT, selectInfo.getJumpInfo().getAigcCount());
        bundle.putBoolean("aigc_is_vertical", selectInfo.getJumpInfo().getImgInfo().getIsVertical());
        bundle.putBoolean("aigc_img_mode", selectInfo.getJumpInfo().getIsImgMode());
        com.tencent.mobileqq.wink.magicstudio.model.f fVar2 = this.curStyle;
        String str3 = "";
        if (fVar2 == null || (str = fVar2.getStyleID()) == null) {
            str = "";
        }
        bundle.putString("aigc_img_generate_style_id", str);
        bundle.putBoolean("aigc_is_collection", selectInfo.getJumpInfo().getIsCollectionStyle());
        com.tencent.mobileqq.wink.magicstudio.model.f fVar3 = this.curStyle;
        if (fVar3 == null || (str2 = fVar3.getStyleID()) == null) {
            str2 = "";
        }
        bundle.putString(QQWinkConstants.MAGIC_STUDIO_STYLE_ID, str2);
        if ((magicStudioPicStyle != null && (styleID = magicStudioPicStyle.getMaterialId()) != null) || ((fVar = this.curStyle) != null && (styleID = fVar.getStyleID()) != null)) {
            str3 = styleID;
        }
        bundle.putString(QQWinkConstants.MAGIC_STUDIO_MATERIAL_ID, str3);
        bundle.putString(QQWinkTempConstants.MAIGC_STUDIO_REPORT_SESSION_ID, this.reportSessionID);
        bundle.putBoolean(QQWinkConstants.NEED_AUTO_FILL_TEMPLATE_LIBRARY_HOLDERS, true);
        bundle.putSerializable("magic_studio_pic_style", magicStudioPicStyle);
        if (selectInfo.getJumpInfo().getIsImgMode()) {
            bundle.putParcelable("img_info", H2());
        }
        return bundle;
    }

    public final boolean l3(@Nullable MagicStudioPicStyle magicStudioPicStyle, int requestAigcCount) {
        if (magicStudioPicStyle != null) {
            this.isRegenerate = true;
            this.regenerateCount++;
            MagicStudioUploadImgInfo magicStudioUploadImgInfo = f323611i0;
            if (magicStudioUploadImgInfo != null) {
                p3(magicStudioUploadImgInfo.getOriginFilePath(), magicStudioPicStyle, magicStudioUploadImgInfo.getIsFromCamera(), magicStudioUploadImgInfo, requestAigcCount);
                return true;
            }
            return false;
        }
        return false;
    }

    public final void o3() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$requestButtonInfo$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        MagicStudioDataSource.f323652a.M().removeObserver(this.observer);
        if (!this.cancelScopeAfterGenerated) {
            CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
        }
    }

    public final void p3(@Nullable String imagePath, @Nullable MagicStudioPicStyle magicStudioPicStyle, boolean isFromCamera, @Nullable MagicStudioUploadImgInfo regenerateUploadImageInfo, int requestAigcCount) {
        Job launch$default;
        s2(this, false, 1, null);
        if (NetworkUtil.isNetworkAvailable() && imagePath != null && magicStudioPicStyle != null) {
            this.reportSessionID = DaTongParams.INSTANCE.a();
            WinkDatongCurrentParams.put("xsj_material_id", magicStudioPicStyle.getStyleId());
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, new e(CoroutineExceptionHandler.INSTANCE, this), null, new MagicStudioCreationViewModel$requestPic2Pic$2(this, regenerateUploadImageInfo, imagePath, magicStudioPicStyle, isFromCamera, requestAigcCount, null), 2, null);
            this.nextJob = launch$default;
            return;
        }
        MagicStudioDataSource.m0(MagicStudioDataSource.f323652a, 0L, null, 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$requestPic2Pic$1(this, null), 3, null);
    }

    public final void r2(boolean needReport) {
        Job job = this.nextJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$cancelToNext$1(this, null), 3, null);
        if (needReport) {
            cu.w(this.aigcCount, this.reportSessionID, 1);
        }
    }

    public final void r3() {
        Job launch$default;
        s2(this, false, 1, null);
        this.reportSessionID = DaTongParams.INSTANCE.a();
        com.tencent.mobileqq.wink.magicstudio.model.f fVar = this.curStyle;
        if (fVar == null) {
            return;
        }
        WinkDatongCurrentParams.put("xsj_material_id", fVar.getStyleID());
        Q2();
        String c16 = I2().c(fVar, this.curDesc);
        if (c16 == null) {
            return;
        }
        w53.b.f("MagicStudioCreationViewModel", "desc = " + c16);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, new f(CoroutineExceptionHandler.INSTANCE, this), null, new MagicStudioCreationViewModel$requestText2Pic$1(this, fVar, c16, fVar.getTopic(), null), 2, null);
        this.nextJob = launch$default;
    }

    public final void s3(boolean z16) {
        this.cancelScopeAfterGenerated = z16;
    }

    @JvmOverloads
    public final void t2(@NotNull LifecycleOwner lifecycleOwner, @NotNull Context context, @Nullable View view, @Nullable Function1<? super b.GotoMultiSelect, Unit> function1, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(context, "context");
        v2(this, lifecycleOwner, context, view, function1, function0, function02, null, false, false, TroopInfo.PAY_PRIVILEGE_ALL, null);
    }

    public final void t3(@Nullable com.tencent.mobileqq.wink.magicstudio.model.f fVar) {
        this.curStyle = fVar;
    }

    @JvmOverloads
    public final void u2(@NotNull LifecycleOwner lifecycleOwner, @NotNull Context context, @Nullable View parentView, @Nullable Function1<? super b.GotoMultiSelect, Unit> gotoMultiSelect, @Nullable Function0<Unit> failedAction, @Nullable Function0<Unit> cancelAction, @Nullable Function1<? super b.ProgressUpdate, Unit> progressAction, boolean hideProgressDialog, boolean forceCollect) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isCreationEventCollected && !forceCollect) {
            return;
        }
        this.isCreationEventCollected = true;
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenResumed(new MagicStudioCreationViewModel$collectCreationEvent$1(this, failedAction, progressAction, hideProgressDialog, context, parentView, gotoMultiSelect, cancelAction, null));
    }

    public final void u3(boolean z16) {
        this.picMode = z16;
    }

    public final void v3(boolean z16) {
        this.isRegenerate = z16;
    }

    public final void w3(@Nullable String prompt) {
        this.schemaPrompt = prompt;
    }

    public final void x3(@Nullable String str) {
        this.schemaStyle = str;
    }

    public final void y3(@NotNull MagicStudioUploadImgAndStyle info) {
        Intrinsics.checkNotNullParameter(info, "info");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioCreationViewModel$updateImageAndUpload$1(this, info, null), 3, null);
    }
}
